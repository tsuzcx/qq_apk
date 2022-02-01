package com.tencent.wcdb.database;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SQLiteQueryBuilder
{
  private static final String TAG = "WCDB.SQLiteQueryBuilder";
  private static final Pattern sLimitPattern;
  private boolean mDistinct = false;
  private SQLiteDatabase.CursorFactory mFactory = null;
  private Map<String, String> mProjectionMap = null;
  private boolean mStrict;
  private String mTables = "";
  private StringBuilder mWhereClause = null;
  
  static
  {
    AppMethodBeat.i(3286);
    sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    AppMethodBeat.o(3286);
  }
  
  private static void appendClause(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    AppMethodBeat.i(3274);
    if (!TextUtils.isEmpty(paramString2))
    {
      paramStringBuilder.append(paramString1);
      paramStringBuilder.append(paramString2);
    }
    AppMethodBeat.o(3274);
  }
  
  public static void appendColumns(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    AppMethodBeat.i(3275);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (str != null)
      {
        if (i > 0) {
          paramStringBuilder.append(", ");
        }
        paramStringBuilder.append(str);
      }
      i += 1;
    }
    paramStringBuilder.append(' ');
    AppMethodBeat.o(3275);
  }
  
  public static String buildQueryString(boolean paramBoolean, String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(3273);
    if ((TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4)))
    {
      paramString1 = new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
      AppMethodBeat.o(3273);
      throw paramString1;
    }
    if ((!TextUtils.isEmpty(paramString6)) && (!sLimitPattern.matcher(paramString6).matches()))
    {
      paramString1 = new IllegalArgumentException("invalid LIMIT clauses:".concat(String.valueOf(paramString6)));
      AppMethodBeat.o(3273);
      throw paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder(120);
    localStringBuilder.append("SELECT ");
    if (paramBoolean) {
      localStringBuilder.append("DISTINCT ");
    }
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0)) {
      appendColumns(localStringBuilder, paramArrayOfString);
    }
    for (;;)
    {
      localStringBuilder.append("FROM ");
      localStringBuilder.append(paramString1);
      appendClause(localStringBuilder, " WHERE ", paramString2);
      appendClause(localStringBuilder, " GROUP BY ", paramString3);
      appendClause(localStringBuilder, " HAVING ", paramString4);
      appendClause(localStringBuilder, " ORDER BY ", paramString5);
      appendClause(localStringBuilder, " LIMIT ", paramString6);
      paramString1 = localStringBuilder.toString();
      AppMethodBeat.o(3273);
      return paramString1;
      localStringBuilder.append("* ");
    }
  }
  
  private String[] computeProjection(String[] paramArrayOfString)
  {
    AppMethodBeat.i(3285);
    Object localObject1;
    int i;
    Object localObject2;
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      if (this.mProjectionMap != null)
      {
        localObject1 = new String[paramArrayOfString.length];
        int j = paramArrayOfString.length;
        i = 0;
        if (i < j)
        {
          localObject2 = paramArrayOfString[i];
          String str = (String)this.mProjectionMap.get(localObject2);
          if (str != null) {
            localObject1[i] = str;
          }
          for (;;)
          {
            i += 1;
            break;
            if ((this.mStrict) || ((!((String)localObject2).contains(" AS ")) && (!((String)localObject2).contains(" as ")))) {
              break label114;
            }
            localObject1[i] = localObject2;
          }
          label114:
          paramArrayOfString = new IllegalArgumentException("Invalid column " + paramArrayOfString[i]);
          AppMethodBeat.o(3285);
          throw paramArrayOfString;
        }
        AppMethodBeat.o(3285);
        return localObject1;
      }
      AppMethodBeat.o(3285);
      return paramArrayOfString;
    }
    if (this.mProjectionMap != null)
    {
      localObject1 = this.mProjectionMap.entrySet();
      paramArrayOfString = new String[((Set)localObject1).size()];
      localObject1 = ((Set)localObject1).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (!((String)((Map.Entry)localObject2).getKey()).equals("_count"))
        {
          paramArrayOfString[i] = ((String)((Map.Entry)localObject2).getValue());
          i += 1;
        }
      }
      AppMethodBeat.o(3285);
      return paramArrayOfString;
    }
    AppMethodBeat.o(3285);
    return null;
  }
  
  private void validateQuerySql(SQLiteDatabase paramSQLiteDatabase, String paramString, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3279);
    paramSQLiteDatabase.getThreadSession().prepare(paramString, paramSQLiteDatabase.getThreadDefaultConnectionFlags(true), paramCancellationSignal, null);
    AppMethodBeat.o(3279);
  }
  
  public void appendWhere(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(3271);
    if (this.mWhereClause == null) {
      this.mWhereClause = new StringBuilder(paramCharSequence.length() + 16);
    }
    if (this.mWhereClause.length() == 0) {
      this.mWhereClause.append('(');
    }
    this.mWhereClause.append(paramCharSequence);
    AppMethodBeat.o(3271);
  }
  
  public void appendWhereEscapeString(String paramString)
  {
    AppMethodBeat.i(3272);
    if (this.mWhereClause == null) {
      this.mWhereClause = new StringBuilder(paramString.length() + 16);
    }
    if (this.mWhereClause.length() == 0) {
      this.mWhereClause.append('(');
    }
    DatabaseUtils.appendEscapedSQLString(this.mWhereClause, paramString);
    AppMethodBeat.o(3272);
  }
  
  public String buildQuery(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(3280);
    paramArrayOfString = computeProjection(paramArrayOfString);
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.mWhereClause != null) && (this.mWhereClause.length() > 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localStringBuilder.append(this.mWhereClause.toString());
        localStringBuilder.append(')');
      }
      if ((paramString1 != null) && (paramString1.length() > 0))
      {
        if (i != 0) {
          localStringBuilder.append(" AND ");
        }
        localStringBuilder.append('(');
        localStringBuilder.append(paramString1);
        localStringBuilder.append(')');
      }
      paramArrayOfString = buildQueryString(this.mDistinct, this.mTables, paramArrayOfString, localStringBuilder.toString(), paramString2, paramString3, paramString4, paramString5);
      AppMethodBeat.o(3280);
      return paramArrayOfString;
    }
  }
  
  @Deprecated
  public String buildQuery(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(3281);
    paramArrayOfString1 = buildQuery(paramArrayOfString1, paramString1, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(3281);
    return paramArrayOfString1;
  }
  
  public String buildUnionQuery(String[] paramArrayOfString, String paramString1, String paramString2)
  {
    AppMethodBeat.i(3284);
    StringBuilder localStringBuilder = new StringBuilder(128);
    int j = paramArrayOfString.length;
    if (this.mDistinct) {}
    for (String str = " UNION ";; str = " UNION ALL ")
    {
      int i = 0;
      while (i < j)
      {
        if (i > 0) {
          localStringBuilder.append(str);
        }
        localStringBuilder.append(paramArrayOfString[i]);
        i += 1;
      }
    }
    appendClause(localStringBuilder, " ORDER BY ", paramString1);
    appendClause(localStringBuilder, " LIMIT ", paramString2);
    paramArrayOfString = localStringBuilder.toString();
    AppMethodBeat.o(3284);
    return paramArrayOfString;
  }
  
  public String buildUnionSubQuery(String paramString1, String[] paramArrayOfString, Set<String> paramSet, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(3282);
    int j = paramArrayOfString.length;
    String[] arrayOfString = new String[j];
    int i = 0;
    if (i < j)
    {
      String str = paramArrayOfString[i];
      if (str.equals(paramString1)) {
        arrayOfString[i] = ("'" + paramString2 + "' AS " + paramString1);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((i <= paramInt) || (paramSet.contains(str))) {
          arrayOfString[i] = str;
        } else {
          arrayOfString[i] = "NULL AS ".concat(String.valueOf(str));
        }
      }
    }
    paramString1 = buildQuery(arrayOfString, paramString3, paramString4, paramString5, null, null);
    AppMethodBeat.o(3282);
    return paramString1;
  }
  
  @Deprecated
  public String buildUnionSubQuery(String paramString1, String[] paramArrayOfString1, Set<String> paramSet, int paramInt, String paramString2, String paramString3, String[] paramArrayOfString2, String paramString4, String paramString5)
  {
    AppMethodBeat.i(3283);
    paramString1 = buildUnionSubQuery(paramString1, paramArrayOfString1, paramSet, paramInt, paramString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(3283);
    return paramString1;
  }
  
  public String getTables()
  {
    return this.mTables;
  }
  
  public Cursor query(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(3276);
    paramSQLiteDatabase = query(paramSQLiteDatabase, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramString3, paramString4, null, null);
    AppMethodBeat.o(3276);
    return paramSQLiteDatabase;
  }
  
  public Cursor query(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(3277);
    paramSQLiteDatabase = query(paramSQLiteDatabase, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramString3, paramString4, paramString5, null);
    AppMethodBeat.o(3277);
    return paramSQLiteDatabase;
  }
  
  public Cursor query(SQLiteDatabase paramSQLiteDatabase, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4, String paramString5, CancellationSignal paramCancellationSignal)
  {
    AppMethodBeat.i(3278);
    if (this.mTables == null)
    {
      AppMethodBeat.o(3278);
      return null;
    }
    if ((this.mStrict) && (paramString1 != null) && (paramString1.length() > 0)) {
      validateQuerySql(paramSQLiteDatabase, buildQuery(paramArrayOfString1, "(" + paramString1 + ")", paramString2, paramString3, paramString4, paramString5), paramCancellationSignal);
    }
    paramArrayOfString1 = buildQuery(paramArrayOfString1, paramString1, paramString2, paramString3, paramString4, paramString5);
    Log.d("WCDB.SQLiteQueryBuilder", "Performing query: ".concat(String.valueOf(paramArrayOfString1)));
    paramSQLiteDatabase = paramSQLiteDatabase.rawQueryWithFactory(this.mFactory, paramArrayOfString1, paramArrayOfString2, SQLiteDatabase.findEditTable(this.mTables), paramCancellationSignal);
    AppMethodBeat.o(3278);
    return paramSQLiteDatabase;
  }
  
  public void setCursorFactory(SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    this.mFactory = paramCursorFactory;
  }
  
  public void setDistinct(boolean paramBoolean)
  {
    this.mDistinct = paramBoolean;
  }
  
  public void setProjectionMap(Map<String, String> paramMap)
  {
    this.mProjectionMap = paramMap;
  }
  
  public void setStrict(boolean paramBoolean)
  {
    this.mStrict = paramBoolean;
  }
  
  public void setTables(String paramString)
  {
    this.mTables = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteQueryBuilder
 * JD-Core Version:    0.7.0.1
 */