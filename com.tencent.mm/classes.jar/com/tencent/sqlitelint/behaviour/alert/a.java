package com.tencent.sqlitelint.behaviour.alert;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.tencent.sqlitelint.SQLiteLintIssue;
import com.tencent.sqlitelint.d.a;
import com.tencent.sqlitelint.util.SLog;
import java.util.List;

public final class a
  extends com.tencent.sqlitelint.behaviour.a
{
  private static Handler hla = new Handler(Looper.getMainLooper());
  private final Context mContext;
  private final String wQW;
  private long wRu;
  
  public a(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.wQW = paramString;
    paramString = paramContext.getContentResolver().query(Uri.parse("content://com.android.launcher2.settings/favorites?notify=true"), new String[] { "title", "iconResource" }, "title=?", new String[] { "SQLiteLint" }, null);
    if (paramString != null)
    {
      int i = paramString.getCount();
      paramString.close();
      if (i > 0) {}
    }
    else
    {
      paramString = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
      paramString.putExtra("android.intent.extra.shortcut.NAME", "SQLiteLint");
      paramString.putExtra("duplicate", false);
      Intent localIntent = new Intent("android.intent.action.MAIN");
      localIntent.setClassName(paramContext, CheckedDatabaseListActivity.class.getName());
      paramString.putExtra("android.intent.extra.shortcut.INTENT", localIntent);
      paramString.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(paramContext, d.a.sqlite_lint_icon));
      paramContext.sendBroadcast(paramString);
    }
  }
  
  public final void ey(List<SQLiteLintIssue> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    long l = com.tencent.sqlitelint.behaviour.a.a.cPT();
    if (l == this.wRu)
    {
      SLog.v("Matrix.IssueAlertBehaviour", "no new issue", new Object[0]);
      return;
    }
    this.wRu = l;
    hla.post(new Runnable()
    {
      public final void run()
      {
        Intent localIntent = new Intent();
        localIntent.setClass(a.a(a.this), CheckResultActivity.class);
        localIntent.addFlags(268435456);
        localIntent.putExtra("db_label", a.b(a.this));
        a.a(a.this).startActivity(localIntent);
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.behaviour.alert.a
 * JD-Core Version:    0.7.0.1
 */