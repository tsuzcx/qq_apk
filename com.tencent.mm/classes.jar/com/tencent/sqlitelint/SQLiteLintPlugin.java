package com.tencent.sqlitelint;

import android.app.Application;
import android.content.Context;
import com.tencent.matrix.e.b;
import com.tencent.matrix.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.behaviour.report.IssueReportBehaviour.IReportDelegate;
import com.tencent.sqlitelint.config.SQLiteLintConfig;
import com.tencent.sqlitelint.config.SQLiteLintConfig.ConcernDb;
import com.tencent.sqlitelint.util.SLog;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class SQLiteLintPlugin
  extends b
{
  private static final String TAG = "Matrix.SQLiteLintPlugin";
  private final SQLiteLintConfig mConfig;
  private Context mContext;
  
  public SQLiteLintPlugin(SQLiteLintConfig paramSQLiteLintConfig)
  {
    this.mConfig = paramSQLiteLintConfig;
  }
  
  private void reportMatrixIssue(SQLiteLintIssue paramSQLiteLintIssue)
  {
    AppMethodBeat.i(52874);
    SLog.i("Matrix.SQLiteLintPlugin", "reportMatrixIssue type:%d, isNew %b", new Object[] { Integer.valueOf(paramSQLiteLintIssue.type), Boolean.valueOf(paramSQLiteLintIssue.isNew) });
    if (!paramSQLiteLintIssue.isNew)
    {
      AppMethodBeat.o(52874);
      return;
    }
    com.tencent.matrix.report.c localc = new com.tencent.matrix.report.c(paramSQLiteLintIssue.type);
    localc.key = paramSQLiteLintIssue.id;
    JSONObject localJSONObject = new JSONObject();
    localc.cFG = localJSONObject;
    try
    {
      localJSONObject.put("machine", a.aP(getApplication()));
      localJSONObject.put("id", paramSQLiteLintIssue.id);
      localJSONObject.put("dbPath", paramSQLiteLintIssue.dbPath);
      localJSONObject.put("level", paramSQLiteLintIssue.level);
      localJSONObject.put("sql", paramSQLiteLintIssue.sql);
      localJSONObject.put("table", paramSQLiteLintIssue.table);
      localJSONObject.put("desc", paramSQLiteLintIssue.desc);
      localJSONObject.put("detail", paramSQLiteLintIssue.detail);
      localJSONObject.put("advice", paramSQLiteLintIssue.advice);
      localJSONObject.put("createTime", paramSQLiteLintIssue.createTime);
      localJSONObject.put("stack", paramSQLiteLintIssue.extInfo);
      localJSONObject.put("sqlTimeCost", paramSQLiteLintIssue.sqlTimeCost);
      localJSONObject.put("isInMainThread", paramSQLiteLintIssue.isInMainThread);
      onDetectIssue(localc);
      AppMethodBeat.o(52874);
      return;
    }
    catch (JSONException paramSQLiteLintIssue)
    {
      for (;;)
      {
        SLog.i("Matrix.SQLiteLintPlugin", "reportMatrixIssue e:%s", new Object[] { paramSQLiteLintIssue.getLocalizedMessage() });
      }
    }
  }
  
  public void addConcernedDB(SQLiteLintConfig.ConcernDb paramConcernDb)
  {
    AppMethodBeat.i(52873);
    if (!isPluginStarted())
    {
      SLog.i("Matrix.SQLiteLintPlugin", "addConcernedDB isPluginStarted not", new Object[0]);
      AppMethodBeat.o(52873);
      return;
    }
    if (paramConcernDb == null)
    {
      AppMethodBeat.o(52873);
      return;
    }
    this.mConfig.addConcernDB(paramConcernDb);
    String str = paramConcernDb.getInstallEnv().getConcernedDbPath();
    SQLiteLint.install(this.mContext, paramConcernDb.getInstallEnv(), paramConcernDb.getOptions());
    SQLiteLint.setWhiteList(str, paramConcernDb.getWhiteListXmlResId());
    SQLiteLint.enableCheckers(str, paramConcernDb.getEnableCheckerList());
    AppMethodBeat.o(52873);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(52871);
    super.destroy();
    AppMethodBeat.o(52871);
  }
  
  public String getTag()
  {
    return "SQLiteLint";
  }
  
  public void init(Application paramApplication, com.tencent.matrix.e.c paramc)
  {
    AppMethodBeat.i(52868);
    super.init(paramApplication, paramc);
    SQLiteLint.setPackageName(paramApplication);
    this.mContext = paramApplication.getApplicationContext();
    AppMethodBeat.o(52868);
  }
  
  public void notifySqlExecution(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(52872);
    if (!isPluginStarted())
    {
      SLog.i("Matrix.SQLiteLintPlugin", "notifySqlExecution isPluginStarted not", new Object[0]);
      AppMethodBeat.o(52872);
      return;
    }
    SQLiteLint.notifySqlExecution(paramString1, paramString2, paramInt);
    AppMethodBeat.o(52872);
  }
  
  public void start()
  {
    AppMethodBeat.i(52869);
    super.start();
    if (!isSupported())
    {
      AppMethodBeat.o(52869);
      return;
    }
    SQLiteLint.setReportDelegate(new IssueReportBehaviour.IReportDelegate()
    {
      public void report(SQLiteLintIssue paramAnonymousSQLiteLintIssue)
      {
        AppMethodBeat.i(52867);
        if (paramAnonymousSQLiteLintIssue == null)
        {
          AppMethodBeat.o(52867);
          return;
        }
        SQLiteLintPlugin.access$000(SQLiteLintPlugin.this, paramAnonymousSQLiteLintIssue);
        AppMethodBeat.o(52867);
      }
    });
    List localList = this.mConfig.getConcernDbList();
    int i = 0;
    while (i < localList.size())
    {
      SQLiteLintConfig.ConcernDb localConcernDb = (SQLiteLintConfig.ConcernDb)localList.get(i);
      String str = localConcernDb.getInstallEnv().getConcernedDbPath();
      SQLiteLint.install(this.mContext, localConcernDb.getInstallEnv(), localConcernDb.getOptions());
      SQLiteLint.setWhiteList(str, localConcernDb.getWhiteListXmlResId());
      SQLiteLint.enableCheckers(str, localConcernDb.getEnableCheckerList());
      i += 1;
    }
    AppMethodBeat.o(52869);
  }
  
  public void stop()
  {
    AppMethodBeat.i(52870);
    super.stop();
    if (!isSupported())
    {
      AppMethodBeat.o(52870);
      return;
    }
    List localList = this.mConfig.getConcernDbList();
    int i = 0;
    while (i < localList.size())
    {
      SQLiteLint.uninstall(((SQLiteLintConfig.ConcernDb)localList.get(i)).getInstallEnv().getConcernedDbPath());
      i += 1;
    }
    SQLiteLint.setReportDelegate(null);
    AppMethodBeat.o(52870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.sqlitelint.SQLiteLintPlugin
 * JD-Core Version:    0.7.0.1
 */