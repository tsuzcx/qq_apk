package com.tencent.sqlitelint.behaviour.alert;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.behaviour.BaseBehaviour;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.sqlitelint.util.SLog;
import java.util.List;

public class IssueAlertBehaviour
  extends BaseBehaviour
{
  private static final String NAME = "SQLiteLint";
  private static final String TAG = "Matrix.IssueAlertBehaviour";
  private static Handler sMainHandler;
  private final String mConcernedDbPath;
  private final Context mContext;
  private long mLastInsertRowId;
  
  static
  {
    AppMethodBeat.i(94061);
    sMainHandler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(94061);
  }
  
  public IssueAlertBehaviour(Context paramContext, String paramString)
  {
    AppMethodBeat.i(94058);
    this.mContext = paramContext;
    this.mConcernedDbPath = paramString;
    createShortCut(paramContext);
    AppMethodBeat.o(94058);
  }
  
  private static void createShortCut(Context paramContext)
  {
    AppMethodBeat.i(94060);
    Object localObject = paramContext.getContentResolver().query(Uri.parse("content://com.android.launcher2.settings/favorites?notify=true"), new String[] { "title", "iconResource" }, "title=?", new String[] { "SQLiteLint" }, null);
    if (localObject != null)
    {
      int i = ((Cursor)localObject).getCount();
      ((Cursor)localObject).close();
      if (i > 0)
      {
        AppMethodBeat.o(94060);
        return;
      }
    }
    localObject = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
    ((Intent)localObject).putExtra("android.intent.extra.shortcut.NAME", "SQLiteLint");
    ((Intent)localObject).putExtra("duplicate", false);
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.setClassName(paramContext, CheckedDatabaseListActivity.class.getName());
    ((Intent)localObject).putExtra("android.intent.extra.shortcut.INTENT", localIntent);
    ((Intent)localObject).putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramContext, 2130840450));
    paramContext.sendBroadcast((Intent)localObject);
    AppMethodBeat.o(94060);
  }
  
  public void onPublish(List<SQLiteLintIssue> paramList)
  {
    AppMethodBeat.i(94059);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(94059);
      return;
    }
    long l = IssueStorage.getLastRowId();
    if (l == this.mLastInsertRowId)
    {
      SLog.v("Matrix.IssueAlertBehaviour", "no new issue", new Object[0]);
      AppMethodBeat.o(94059);
      return;
    }
    this.mLastInsertRowId = l;
    sMainHandler.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(94057);
        Intent localIntent = new Intent();
        localIntent.setClass(IssueAlertBehaviour.this.mContext, CheckResultActivity.class);
        localIntent.addFlags(268435456);
        localIntent.putExtra("db_label", IssueAlertBehaviour.this.mConcernedDbPath);
        IssueAlertBehaviour.this.mContext.startActivity(localIntent);
        AppMethodBeat.o(94057);
      }
    });
    AppMethodBeat.o(94059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.alert.IssueAlertBehaviour
 * JD-Core Version:    0.7.0.1
 */