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
  private static SQLiteLint.SqlExecutionCallbackMode sSqlExecutionCallbackMode;
  
  static
  {
    AppMethodBeat.i(52836);
    if (!SQLiteLint.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      SQLiteLintNativeBridge.loadLibrary();
      sSqlExecutionCallbackMode = null;
      sPackageName = null;
      AppMethodBeat.o(52836);
      return;
    }
  }
  
  public static void enableCheckers(String paramString, List<String> paramList)
  {
    AppMethodBeat.i(52834);
    if (SQLiteLintAndroidCoreManager.INSTANCE.get(paramString) == null)
    {
      AppMethodBeat.o(52834);
      return;
    }
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(52834);
      return;
    }
    SQLiteLintAndroidCoreManager.INSTANCE.get(paramString).enableCheckers(paramList);
    AppMethodBeat.o(52834);
  }
  
  public static SQLiteLint.SqlExecutionCallbackMode getSqlExecutionCallbackMode()
  {
    return sSqlExecutionCallbackMode;
  }
  
  public static void install(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
  {
    AppMethodBeat.i(52829);
    if ((!$assertionsDisabled) && (paramSQLiteDatabase == null))
    {
      paramContext = new AssertionError();
      AppMethodBeat.o(52829);
      throw paramContext;
    }
    if ((!$assertionsDisabled) && (sSqlExecutionCallbackMode == null))
    {
      paramContext = new AssertionError("SqlExecutionCallbackMode not set！setSqlExecutionCallbackMode must be called before install");
      AppMethodBeat.o(52829);
      throw paramContext;
    }
    paramSQLiteDatabase = new InstallEnv(paramSQLiteDatabase.getPath(), new SimpleSQLiteExecutionDelegate(paramSQLiteDatabase));
    SQLiteLintAndroidCoreManager.INSTANCE.install(paramContext, paramSQLiteDatabase, Options.LAX);
    AppMethodBeat.o(52829);
  }
  
  public static void install(Context paramContext, InstallEnv paramInstallEnv, Options paramOptions)
  {
    AppMethodBeat.i(52830);
    if ((!$assertionsDisabled) && (paramInstallEnv == null))
    {
      paramContext = new AssertionError();
      AppMethodBeat.o(52830);
      throw paramContext;
    }
    if ((!$assertionsDisabled) && (sSqlExecutionCallbackMode == null))
    {
      paramContext = new AssertionError("SqlExecutionCallbackMode is UNKNOWN！setSqlExecutionCallbackMode must be called before install");
      AppMethodBeat.o(52830);
      throw paramContext;
    }
    Options localOptions = paramOptions;
    if (paramOptions == null) {
      localOptions = Options.LAX;
    }
    SQLiteLintAndroidCoreManager.INSTANCE.install(paramContext, paramInstallEnv, localOptions);
    AppMethodBeat.o(52830);
  }
  
  public static void notifySqlExecution(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(52831);
    if (SQLiteLintAndroidCoreManager.INSTANCE.get(paramString1) == null)
    {
      AppMethodBeat.o(52831);
      return;
    }
    SQLiteLintAndroidCoreManager.INSTANCE.get(paramString1).notifySqlExecution(paramString1, paramString2, paramInt);
    AppMethodBeat.o(52831);
  }
  
  public static void setPackageName(Context paramContext)
  {
    AppMethodBeat.i(52835);
    if (sPackageName == null) {
      sPackageName = paramContext.getPackageName();
    }
    AppMethodBeat.o(52835);
  }
  
  static void setReportDelegate(IssueReportBehaviour.IReportDelegate paramIReportDelegate)
  {
    sReportDelegate = paramIReportDelegate;
  }
  
  public static void setSqlExecutionCallbackMode(SQLiteLint.SqlExecutionCallbackMode paramSqlExecutionCallbackMode)
  {
    AppMethodBeat.i(52828);
    if (sSqlExecutionCallbackMode != null)
    {
      AppMethodBeat.o(52828);
      return;
    }
    sSqlExecutionCallbackMode = paramSqlExecutionCallbackMode;
    if (paramSqlExecutionCallbackMode == SQLiteLint.SqlExecutionCallbackMode.HOOK) {
      SQLite3ProfileHooker.hook();
    }
    AppMethodBeat.o(52828);
  }
  
  public static void setWhiteList(String paramString, int paramInt)
  {
    AppMethodBeat.i(52833);
    if (SQLiteLintAndroidCoreManager.INSTANCE.get(paramString) == null)
    {
      AppMethodBeat.o(52833);
      return;
    }
    SQLiteLintAndroidCoreManager.INSTANCE.get(paramString).setWhiteList(paramInt);
    AppMethodBeat.o(52833);
  }
  
  public static void uninstall(String paramString)
  {
    AppMethodBeat.i(52832);
    SQLiteLintAndroidCoreManager.INSTANCE.get(paramString).release();
    SQLiteLintAndroidCoreManager.INSTANCE.remove(paramString);
    AppMethodBeat.o(52832);
  }
  
  public static final class InstallEnv
  {
    private final String mConcernedDbPath;
    private final ISQLiteExecutionDelegate mSQLiteExecutionDelegate;
    
    static
    {
      AppMethodBeat.i(52821);
      if (!SQLiteLint.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(52821);
        return;
      }
    }
    
    public InstallEnv(String paramString, ISQLiteExecutionDelegate paramISQLiteExecutionDelegate)
    {
      AppMethodBeat.i(52820);
      if ((!$assertionsDisabled) && (paramString == null))
      {
        paramString = new AssertionError();
        AppMethodBeat.o(52820);
        throw paramString;
      }
      if ((!$assertionsDisabled) && (paramISQLiteExecutionDelegate == null))
      {
        paramString = new AssertionError();
        AppMethodBeat.o(52820);
        throw paramString;
      }
      this.mConcernedDbPath = paramString;
      this.mSQLiteExecutionDelegate = paramISQLiteExecutionDelegate;
      AppMethodBeat.o(52820);
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
      AppMethodBeat.i(52824);
      LAX = new Builder().build();
      AppMethodBeat.o(52824);
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
        AppMethodBeat.i(52822);
        this.mBehaviourMask |= 0x1;
        AppMethodBeat.o(52822);
      }
      
      public final SQLiteLint.Options build()
      {
        AppMethodBeat.i(52823);
        SQLiteLint.Options localOptions = new SQLiteLint.Options();
        SQLiteLint.Options.access$002(localOptions, this.mBehaviourMask);
        AppMethodBeat.o(52823);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.sqlitelint.SQLiteLint
 * JD-Core Version:    0.7.0.1
 */