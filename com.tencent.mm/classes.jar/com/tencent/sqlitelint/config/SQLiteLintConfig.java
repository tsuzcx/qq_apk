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
    AppMethodBeat.i(52950);
    SQLiteLint.setSqlExecutionCallbackMode(paramSqlExecutionCallbackMode);
    this.sConcernDbList = new ArrayList();
    AppMethodBeat.o(52950);
  }
  
  public final void addConcernDB(ConcernDb paramConcernDb)
  {
    AppMethodBeat.i(52951);
    if (paramConcernDb == null)
    {
      AppMethodBeat.o(52951);
      return;
    }
    if (paramConcernDb.mInstallEnv == null)
    {
      AppMethodBeat.o(52951);
      return;
    }
    String str = paramConcernDb.mInstallEnv.getConcernedDbPath();
    if (TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(52951);
      return;
    }
    int i = 0;
    while (i < this.sConcernDbList.size())
    {
      if (str.equals(paramConcernDb.mInstallEnv.getConcernedDbPath()))
      {
        AppMethodBeat.o(52951);
        return;
      }
      i += 1;
    }
    this.sConcernDbList.add(paramConcernDb);
    AppMethodBeat.o(52951);
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
      AppMethodBeat.i(52949);
      if (!SQLiteLintConfig.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        $assertionsDisabled = bool;
        AppMethodBeat.o(52949);
        return;
      }
    }
    
    public ConcernDb(SQLiteDatabase paramSQLiteDatabase)
    {
      AppMethodBeat.i(52940);
      this.mEnableCheckerList = new ArrayList();
      if ((!$assertionsDisabled) && (paramSQLiteDatabase == null))
      {
        paramSQLiteDatabase = new AssertionError();
        AppMethodBeat.o(52940);
        throw paramSQLiteDatabase;
      }
      this.mInstallEnv = new SQLiteLint.InstallEnv(paramSQLiteDatabase.getPath(), new SimpleSQLiteExecutionDelegate(paramSQLiteDatabase));
      this.mOptions = SQLiteLint.Options.LAX;
      AppMethodBeat.o(52940);
    }
    
    public ConcernDb(SQLiteLint.InstallEnv paramInstallEnv, SQLiteLint.Options paramOptions)
    {
      AppMethodBeat.i(52939);
      this.mEnableCheckerList = new ArrayList();
      this.mInstallEnv = paramInstallEnv;
      this.mOptions = paramOptions;
      AppMethodBeat.o(52939);
    }
    
    private ConcernDb enableChecker(String paramString)
    {
      AppMethodBeat.i(52948);
      this.mEnableCheckerList.add(paramString);
      AppMethodBeat.o(52948);
      return this;
    }
    
    public final ConcernDb enableAllCheckers()
    {
      AppMethodBeat.i(52941);
      ConcernDb localConcernDb = enableExplainQueryPlanChecker().enableAvoidSelectAllChecker().enableWithoutRowIdBetterChecker().enableAvoidAutoIncrementChecker().enablePreparedStatementBetterChecker().enableRedundantIndexChecker();
      AppMethodBeat.o(52941);
      return localConcernDb;
    }
    
    public final ConcernDb enableAvoidAutoIncrementChecker()
    {
      AppMethodBeat.i(52945);
      ConcernDb localConcernDb = enableChecker("AvoidAutoIncrementChecker");
      AppMethodBeat.o(52945);
      return localConcernDb;
    }
    
    public final ConcernDb enableAvoidSelectAllChecker()
    {
      AppMethodBeat.i(52943);
      ConcernDb localConcernDb = enableChecker("AvoidSelectAllChecker");
      AppMethodBeat.o(52943);
      return localConcernDb;
    }
    
    public final ConcernDb enableExplainQueryPlanChecker()
    {
      AppMethodBeat.i(52942);
      ConcernDb localConcernDb = enableChecker("ExplainQueryPlanChecker");
      AppMethodBeat.o(52942);
      return localConcernDb;
    }
    
    public final ConcernDb enablePreparedStatementBetterChecker()
    {
      AppMethodBeat.i(52946);
      ConcernDb localConcernDb = enableChecker("PreparedStatementBetterChecker");
      AppMethodBeat.o(52946);
      return localConcernDb;
    }
    
    public final ConcernDb enableRedundantIndexChecker()
    {
      AppMethodBeat.i(52947);
      ConcernDb localConcernDb = enableChecker("RedundantIndexChecker");
      AppMethodBeat.o(52947);
      return localConcernDb;
    }
    
    public final ConcernDb enableWithoutRowIdBetterChecker()
    {
      AppMethodBeat.i(52944);
      ConcernDb localConcernDb = enableChecker("WithoutRowIdBetterChecker");
      AppMethodBeat.o(52944);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.sqlitelint.config.SQLiteLintConfig
 * JD-Core Version:    0.7.0.1
 */