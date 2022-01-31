package com.tencent.sqlitelint.config;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.SQLiteLint;
import com.tencent.sqlitelint.SQLiteLint.InstallEnv;
import com.tencent.sqlitelint.SQLiteLint.Options;
import com.tencent.sqlitelint.SQLiteLint.SqlExecutionCallbackMode;
import com.tencent.sqlitelint.SimpleSQLiteExecutionDelegate;
import java.util.ArrayList;
import java.util.List;

public final class SQLiteLintConfig
{
  private final List<ConcernDb> sConcernDbList;
  
  public SQLiteLintConfig(SQLiteLint.SqlExecutionCallbackMode paramSqlExecutionCallbackMode)
  {
    AppMethodBeat.i(94106);
    SQLiteLint.setSqlExecutionCallbackMode(paramSqlExecutionCallbackMode);
    this.sConcernDbList = new ArrayList();
    AppMethodBeat.o(94106);
  }
  
  public final void addConcernDB(ConcernDb paramConcernDb)
  {
    AppMethodBeat.i(94107);
    if (paramConcernDb == null)
    {
      AppMethodBeat.o(94107);
      return;
    }
    if (paramConcernDb.mInstallEnv == null)
    {
      AppMethodBeat.o(94107);
      return;
    }
    String str = paramConcernDb.mInstallEnv.getConcernedDbPath();
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(94107);
      return;
    }
    int i = 0;
    while (i < this.sConcernDbList.size())
    {
      if (str.equals(paramConcernDb.mInstallEnv.getConcernedDbPath()))
      {
        AppMethodBeat.o(94107);
        return;
      }
      i += 1;
    }
    this.sConcernDbList.add(paramConcernDb);
    AppMethodBeat.o(94107);
  }
  
  public final List<ConcernDb> getConcernDbList()
  {
    return this.sConcernDbList;
  }
  
  public static final class ConcernDb
  {
    private static final String AVOID_AUTO_INCREMENT_CHECKER_NAME = "AvoidAutoIncrementChecker";
    private static final String AVOID_SELECT_ALL_CHECKER_NAME = "AvoidSelectAllChecker";
    private static final String EXPLAIN_QUERY_PLAN_CHECKER_NAME = "ExplainQueryPlanChecker";
    private static final String PREPARED_STATEMENT_BETTER_CHECKER_NAME = "PreparedStatementBetterChecker";
    private static final String REDUNDANT_INDEX_CHECKER_NAME = "RedundantIndexChecker";
    private static final String WITHOUT_ROWID_BETTER_CHECKER_NAME = "WithoutRowIdBetterChecker";
    private final List<String> mEnableCheckerList;
    private final SQLiteLint.InstallEnv mInstallEnv;
    private final SQLiteLint.Options mOptions;
    private int mWhiteListXmlResId;
    
    static
    {
      AppMethodBeat.i(94105);
      if (!SQLiteLintConfig.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(94105);
        return;
      }
    }
    
    public ConcernDb(SQLiteDatabase paramSQLiteDatabase)
    {
      AppMethodBeat.i(94096);
      this.mEnableCheckerList = new ArrayList();
      if ((!$assertionsDisabled) && (paramSQLiteDatabase == null))
      {
        paramSQLiteDatabase = new AssertionError();
        AppMethodBeat.o(94096);
        throw paramSQLiteDatabase;
      }
      this.mInstallEnv = new SQLiteLint.InstallEnv(paramSQLiteDatabase.getPath(), new SimpleSQLiteExecutionDelegate(paramSQLiteDatabase));
      this.mOptions = SQLiteLint.Options.LAX;
      AppMethodBeat.o(94096);
    }
    
    public ConcernDb(SQLiteLint.InstallEnv paramInstallEnv, SQLiteLint.Options paramOptions)
    {
      AppMethodBeat.i(94095);
      this.mEnableCheckerList = new ArrayList();
      this.mInstallEnv = paramInstallEnv;
      this.mOptions = paramOptions;
      AppMethodBeat.o(94095);
    }
    
    private ConcernDb enableChecker(String paramString)
    {
      AppMethodBeat.i(94104);
      this.mEnableCheckerList.add(paramString);
      AppMethodBeat.o(94104);
      return this;
    }
    
    public final ConcernDb enableAllCheckers()
    {
      AppMethodBeat.i(94097);
      ConcernDb localConcernDb = enableExplainQueryPlanChecker().enableAvoidSelectAllChecker().enableWithoutRowIdBetterChecker().enableAvoidAutoIncrementChecker().enablePreparedStatementBetterChecker().enableRedundantIndexChecker();
      AppMethodBeat.o(94097);
      return localConcernDb;
    }
    
    public final ConcernDb enableAvoidAutoIncrementChecker()
    {
      AppMethodBeat.i(94101);
      ConcernDb localConcernDb = enableChecker("AvoidAutoIncrementChecker");
      AppMethodBeat.o(94101);
      return localConcernDb;
    }
    
    public final ConcernDb enableAvoidSelectAllChecker()
    {
      AppMethodBeat.i(94099);
      ConcernDb localConcernDb = enableChecker("AvoidSelectAllChecker");
      AppMethodBeat.o(94099);
      return localConcernDb;
    }
    
    public final ConcernDb enableExplainQueryPlanChecker()
    {
      AppMethodBeat.i(94098);
      ConcernDb localConcernDb = enableChecker("ExplainQueryPlanChecker");
      AppMethodBeat.o(94098);
      return localConcernDb;
    }
    
    public final ConcernDb enablePreparedStatementBetterChecker()
    {
      AppMethodBeat.i(94102);
      ConcernDb localConcernDb = enableChecker("PreparedStatementBetterChecker");
      AppMethodBeat.o(94102);
      return localConcernDb;
    }
    
    public final ConcernDb enableRedundantIndexChecker()
    {
      AppMethodBeat.i(94103);
      ConcernDb localConcernDb = enableChecker("RedundantIndexChecker");
      AppMethodBeat.o(94103);
      return localConcernDb;
    }
    
    public final ConcernDb enableWithoutRowIdBetterChecker()
    {
      AppMethodBeat.i(94100);
      ConcernDb localConcernDb = enableChecker("WithoutRowIdBetterChecker");
      AppMethodBeat.o(94100);
      return localConcernDb;
    }
    
    public final List<String> getEnableCheckerList()
    {
      return this.mEnableCheckerList;
    }
    
    public final SQLiteLint.InstallEnv getInstallEnv()
    {
      return this.mInstallEnv;
    }
    
    public final SQLiteLint.Options getOptions()
    {
      return this.mOptions;
    }
    
    public final int getWhiteListXmlResId()
    {
      return this.mWhiteListXmlResId;
    }
    
    public final ConcernDb setWhiteListXml(int paramInt)
    {
      this.mWhiteListXmlResId = paramInt;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.sqlitelint.config.SQLiteLintConfig
 * JD-Core Version:    0.7.0.1
 */