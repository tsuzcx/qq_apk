package com.tencent.sqlitelint;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.behaviour.report.IssueReportBehaviour.IReportDelegate;
import com.tencent.sqlitelint.util.SQLite3ProfileHooker;
import java.util.List;

public class SQLiteLint
{
  private static final int BEHAVIOUR_ALERT = 1;
  private static final int BEHAVIOUR_REPORT = 2;
  public static String sPackageName;
  static IssueReportBehaviour.IReportDelegate sReportDelegate;
  private static SqlExecutionCallbackMode sSqlExecutionCallbackMode;
  
  static
  {
    AppMethodBeat.i(93992);
    if (!SQLiteLint.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      SQLiteLintNativeBridge.loadLibrary();
      sSqlExecutionCallbackMode = null;
      sPackageName = null;
      AppMethodBeat.o(93992);
      return;
    }
  }
  
  public static void enableCheckers(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(93990);
    if (SQLiteLintAndroidCoreManager.INSTANCE.get(paramString) == null)
    {
      AppMethodBeat.o(93990);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(93990);
      return;
    }
    SQLiteLintAndroidCoreManager.INSTANCE.get(paramString).enableCheckers(paramList);
    AppMethodBeat.o(93990);
  }
  
  public static SqlExecutionCallbackMode getSqlExecutionCallbackMode()
  {
    return sSqlExecutionCallbackMode;
  }
  
  public static void install(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(93985);
    if ((!$assertionsDisabled) && (paramSQLiteDatabase == null))
    {
      paramContext = new AssertionError();
      AppMethodBeat.o(93985);
      throw paramContext;
    }
    if ((!$assertionsDisabled) && (sSqlExecutionCallbackMode == null))
    {
      paramContext = new AssertionError("SqlExecutionCallbackMode not set！setSqlExecutionCallbackMode must be called before install");
      AppMethodBeat.o(93985);
      throw paramContext;
    }
    paramSQLiteDatabase = new InstallEnv(paramSQLiteDatabase.getPath(), new SimpleSQLiteExecutionDelegate(paramSQLiteDatabase));
    SQLiteLintAndroidCoreManager.INSTANCE.install(paramContext, paramSQLiteDatabase, Options.LAX);
    AppMethodBeat.o(93985);
  }
  
  public static void install(Context paramContext, InstallEnv paramInstallEnv, Options paramOptions)
  {
    AppMethodBeat.i(93986);
    if ((!$assertionsDisabled) && (paramInstallEnv == null))
    {
      paramContext = new AssertionError();
      AppMethodBeat.o(93986);
      throw paramContext;
    }
    if ((!$assertionsDisabled) && (sSqlExecutionCallbackMode == null))
    {
      paramContext = new AssertionError("SqlExecutionCallbackMode is UNKNOWN！setSqlExecutionCallbackMode must be called before install");
      AppMethodBeat.o(93986);
      throw paramContext;
    }
    Options localOptions = paramOptions;
    if (paramOptions == null) {
      localOptions = Options.LAX;
    }
    SQLiteLintAndroidCoreManager.INSTANCE.install(paramContext, paramInstallEnv, localOptions);
    AppMethodBeat.o(93986);
  }
  
  public static void notifySqlExecution(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(93987);
    if (SQLiteLintAndroidCoreManager.INSTANCE.get(paramString1) == null)
    {
      AppMethodBeat.o(93987);
      return;
    }
    SQLiteLintAndroidCoreManager.INSTANCE.get(paramString1).notifySqlExecution(paramString1, paramString2, paramInt);
    AppMethodBeat.o(93987);
  }
  
  public static void setPackageName(Context paramContext)
  {
    AppMethodBeat.i(93991);
    if (sPackageName == null) {
      sPackageName = paramContext.getPackageName();
    }
    AppMethodBeat.o(93991);
  }
  
  static void setReportDelegate(IssueReportBehaviour.IReportDelegate paramIReportDelegate)
  {
    sReportDelegate = paramIReportDelegate;
  }
  
  public static void setSqlExecutionCallbackMode(SqlExecutionCallbackMode paramSqlExecutionCallbackMode)
  {
    AppMethodBeat.i(93984);
    if (sSqlExecutionCallbackMode != null)
    {
      AppMethodBeat.o(93984);
      return;
    }
    sSqlExecutionCallbackMode = paramSqlExecutionCallbackMode;
    if (paramSqlExecutionCallbackMode == SqlExecutionCallbackMode.HOOK) {
      SQLite3ProfileHooker.hook();
    }
    AppMethodBeat.o(93984);
  }
  
  public static void setWhiteList(String paramString, int paramInt)
  {
    AppMethodBeat.i(93989);
    if (SQLiteLintAndroidCoreManager.INSTANCE.get(paramString) == null)
    {
      AppMethodBeat.o(93989);
      return;
    }
    SQLiteLintAndroidCoreManager.INSTANCE.get(paramString).setWhiteList(paramInt);
    AppMethodBeat.o(93989);
  }
  
  public static void uninstall(String paramString)
  {
    AppMethodBeat.i(93988);
    SQLiteLintAndroidCoreManager.INSTANCE.get(paramString).release();
    SQLiteLintAndroidCoreManager.INSTANCE.remove(paramString);
    AppMethodBeat.o(93988);
  }
  
  public static final class InstallEnv
  {
    private final String mConcernedDbPath;
    private final ISQLiteExecutionDelegate mSQLiteExecutionDelegate;
    
    static
    {
      AppMethodBeat.i(93977);
      if (!SQLiteLint.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(93977);
        return;
      }
    }
    
    public InstallEnv(String paramString, ISQLiteExecutionDelegate paramISQLiteExecutionDelegate)
    {
      AppMethodBeat.i(93976);
      if ((!$assertionsDisabled) && (paramString == null))
      {
        paramString = new AssertionError();
        AppMethodBeat.o(93976);
        throw paramString;
      }
      if ((!$assertionsDisabled) && (paramISQLiteExecutionDelegate == null))
      {
        paramString = new AssertionError();
        AppMethodBeat.o(93976);
        throw paramString;
      }
      this.mConcernedDbPath = paramString;
      this.mSQLiteExecutionDelegate = paramISQLiteExecutionDelegate;
      AppMethodBeat.o(93976);
    }
    
    public final String getConcernedDbPath()
    {
      return this.mConcernedDbPath;
    }
    
    public final ISQLiteExecutionDelegate getSQLiteExecutionDelegate()
    {
      return this.mSQLiteExecutionDelegate;
    }
  }
  
  public static final class Options
  {
    public static final Options LAX;
    private int behaviourMask;
    
    static
    {
      AppMethodBeat.i(93980);
      LAX = new Builder().build();
      AppMethodBeat.o(93980);
    }
    
    public final boolean isAlertBehaviourEnable()
    {
      return (this.behaviourMask & 0x1) > 0;
    }
    
    public final boolean isReportBehaviourEnable()
    {
      return (this.behaviourMask & 0x2) > 0;
    }
    
    public static final class Builder
    {
      private int mBehaviourMask;
      
      public Builder()
      {
        AppMethodBeat.i(93978);
        this.mBehaviourMask |= 0x1;
        AppMethodBeat.o(93978);
      }
      
      public final SQLiteLint.Options build()
      {
        AppMethodBeat.i(93979);
        SQLiteLint.Options localOptions = new SQLiteLint.Options();
        SQLiteLint.Options.access$002(localOptions, this.mBehaviourMask);
        AppMethodBeat.o(93979);
        return localOptions;
      }
      
      public final Builder setAlertBehaviour(boolean paramBoolean)
      {
        if (paramBoolean)
        {
          this.mBehaviourMask |= 0x1;
          return this;
        }
        this.mBehaviourMask &= 0xFFFFFFFE;
        return this;
      }
      
      public final Builder setReportBehaviour(boolean paramBoolean)
      {
        if (paramBoolean)
        {
          this.mBehaviourMask |= 0x2;
          return this;
        }
        this.mBehaviourMask &= 0xFFFFFFFD;
        return this;
      }
    }
  }
  
  public static enum SqlExecutionCallbackMode
  {
    static
    {
      AppMethodBeat.i(93983);
      HOOK = new SqlExecutionCallbackMode("HOOK", 0);
      CUSTOM_NOTIFY = new SqlExecutionCallbackMode("CUSTOM_NOTIFY", 1);
      $VALUES = new SqlExecutionCallbackMode[] { HOOK, CUSTOM_NOTIFY };
      AppMethodBeat.o(93983);
    }
    
    private SqlExecutionCallbackMode() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.SQLiteLint
 * JD-Core Version:    0.7.0.1
 */