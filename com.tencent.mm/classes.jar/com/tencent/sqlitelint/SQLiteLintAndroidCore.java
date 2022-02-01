package com.tencent.sqlitelint;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.behaviour.BaseBehaviour;
import com.tencent.sqlitelint.behaviour.alert.IssueAlertBehaviour;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.sqlitelint.behaviour.persistence.PersistenceBehaviour;
import com.tencent.sqlitelint.behaviour.persistence.SQLiteLintDbHelper;
import com.tencent.sqlitelint.behaviour.report.IssueReportBehaviour;
import com.tencent.sqlitelint.util.SQLite3ProfileHooker;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class SQLiteLintAndroidCore
  implements IOnIssuePublishListener
{
  private static final String TAG = "SQLiteLint.SQLiteLintAndroidCore";
  private final List<BaseBehaviour> mBehaviors;
  private final String mConcernedDbPath;
  private final Context mContext;
  private final ISQLiteExecutionDelegate mSQLiteExecutionDelegate;
  
  SQLiteLintAndroidCore(Context paramContext, SQLiteLint.InstallEnv paramInstallEnv, SQLiteLint.Options paramOptions)
  {
    AppMethodBeat.i(52837);
    this.mContext = paramContext;
    SQLiteLintDbHelper.INSTANCE.initialize(paramContext);
    this.mConcernedDbPath = paramInstallEnv.getConcernedDbPath();
    this.mSQLiteExecutionDelegate = paramInstallEnv.getSQLiteExecutionDelegate();
    if (SQLiteLint.getSqlExecutionCallbackMode() == SQLiteLint.SqlExecutionCallbackMode.HOOK) {
      SQLite3ProfileHooker.hook();
    }
    SQLiteLintNativeBridge.nativeInstall(this.mConcernedDbPath);
    this.mBehaviors = new ArrayList();
    this.mBehaviors.add(new PersistenceBehaviour());
    if (paramOptions.isAlertBehaviourEnable()) {
      this.mBehaviors.add(new IssueAlertBehaviour(paramContext, this.mConcernedDbPath));
    }
    if (paramOptions.isReportBehaviourEnable()) {
      this.mBehaviors.add(new IssueReportBehaviour(SQLiteLint.sReportDelegate));
    }
    AppMethodBeat.o(52837);
  }
  
  public void addBehavior(BaseBehaviour paramBaseBehaviour)
  {
    AppMethodBeat.i(52838);
    if (!this.mBehaviors.contains(paramBaseBehaviour)) {
      this.mBehaviors.add(paramBaseBehaviour);
    }
    AppMethodBeat.o(52838);
  }
  
  public void enableCheckers(List<String> paramList)
  {
    AppMethodBeat.i(52843);
    String[] arrayOfString = new String[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfString[i] = ((String)paramList.get(i));
      i += 1;
    }
    SQLiteLintNativeBridge.nativeEnableCheckers(this.mConcernedDbPath, arrayOfString);
    AppMethodBeat.o(52843);
  }
  
  public ISQLiteExecutionDelegate getSQLiteExecutionDelegate()
  {
    return this.mSQLiteExecutionDelegate;
  }
  
  public void notifySqlExecution(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(52841);
    String str = "null";
    if (paramLong >= 8L) {
      str = SQLiteLintUtil.getThrowableStack(new Throwable());
    }
    SQLiteLintNativeBridge.nativeNotifySqlExecute(paramString1, paramString2, paramLong, str);
    AppMethodBeat.o(52841);
  }
  
  public void onPublish(List<SQLiteLintIssue> paramList)
  {
    int j = 0;
    AppMethodBeat.i(52844);
    Iterator localIterator = paramList.iterator();
    int i;
    for (;;)
    {
      i = j;
      if (!localIterator.hasNext()) {
        break;
      }
      SQLiteLintIssue localSQLiteLintIssue = (SQLiteLintIssue)localIterator.next();
      if (IssueStorage.hasIssue(localSQLiteLintIssue.id)) {
        localSQLiteLintIssue.isNew = false;
      } else {
        localSQLiteLintIssue.isNew = true;
      }
    }
    while (i < this.mBehaviors.size())
    {
      ((BaseBehaviour)this.mBehaviors.get(i)).onPublish(paramList);
      i += 1;
    }
    AppMethodBeat.o(52844);
  }
  
  public void release()
  {
    AppMethodBeat.i(52840);
    if (SQLiteLint.getSqlExecutionCallbackMode() == SQLiteLint.SqlExecutionCallbackMode.HOOK) {
      SQLite3ProfileHooker.unHook();
    }
    SQLiteLintNativeBridge.nativeUninstall(this.mConcernedDbPath);
    AppMethodBeat.o(52840);
  }
  
  public void removeBehavior(BaseBehaviour paramBaseBehaviour)
  {
    AppMethodBeat.i(52839);
    this.mBehaviors.remove(paramBaseBehaviour);
    AppMethodBeat.o(52839);
  }
  
  public void setWhiteList(int paramInt)
  {
    AppMethodBeat.i(52842);
    CheckerWhiteListLogic.setWhiteList(this.mContext, this.mConcernedDbPath, paramInt);
    AppMethodBeat.o(52842);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.sqlitelint.SQLiteLintAndroidCore
 * JD-Core Version:    0.7.0.1
 */