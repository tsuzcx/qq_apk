package com.tencent.wcdb;

import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.database.SQLiteAbortException;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteConstraintException;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDiskIOException;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteFullException;
import com.tencent.wcdb.database.SQLiteProgram;
import com.tencent.wcdb.database.SQLiteStatement;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.OperationCanceledException;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.CollationKey;
import java.text.Collator;
import java.util.HashMap;

public final class DatabaseUtils
{
  private static final boolean DEBUG = false;
  private static final char[] DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final int EX_HAS_REPLY_HEADER = -128;
  public static final int STATEMENT_ABORT = 6;
  public static final int STATEMENT_ATTACH = 3;
  public static final int STATEMENT_BEGIN = 4;
  public static final int STATEMENT_COMMIT = 5;
  public static final int STATEMENT_DDL = 8;
  public static final int STATEMENT_OTHER = 99;
  public static final int STATEMENT_PRAGMA = 7;
  public static final int STATEMENT_SELECT = 1;
  public static final int STATEMENT_UNPREPARED = 9;
  public static final int STATEMENT_UPDATE = 2;
  private static final String TAG = "WCDB.DatabaseUtils";
  private static Collator mColl = null;
  
  public static void appendEscapedSQLString(StringBuilder paramStringBuilder, String paramString)
  {
    AppMethodBeat.i(2804);
    paramStringBuilder.append('\'');
    if (paramString.indexOf('\'') != -1)
    {
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        char c = paramString.charAt(i);
        if (c == '\'') {
          paramStringBuilder.append('\'');
        }
        paramStringBuilder.append(c);
        i += 1;
      }
    }
    paramStringBuilder.append(paramString);
    paramStringBuilder.append('\'');
    AppMethodBeat.o(2804);
  }
  
  public static String[] appendSelectionArgs(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(2848);
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length == 0))
    {
      AppMethodBeat.o(2848);
      return paramArrayOfString2;
    }
    String[] arrayOfString = new String[paramArrayOfString1.length + paramArrayOfString2.length];
    System.arraycopy(paramArrayOfString1, 0, arrayOfString, 0, paramArrayOfString1.length);
    System.arraycopy(paramArrayOfString2, 0, arrayOfString, paramArrayOfString1.length, paramArrayOfString2.length);
    AppMethodBeat.o(2848);
    return arrayOfString;
  }
  
  public static final void appendValueToSql(StringBuilder paramStringBuilder, Object paramObject)
  {
    AppMethodBeat.i(2806);
    if (paramObject == null)
    {
      paramStringBuilder.append("NULL");
      AppMethodBeat.o(2806);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      if (((Boolean)paramObject).booleanValue())
      {
        paramStringBuilder.append('1');
        AppMethodBeat.o(2806);
        return;
      }
      paramStringBuilder.append('0');
      AppMethodBeat.o(2806);
      return;
    }
    appendEscapedSQLString(paramStringBuilder, paramObject.toString());
    AppMethodBeat.o(2806);
  }
  
  public static void bindObjectToProgram(SQLiteProgram paramSQLiteProgram, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(2802);
    if (paramObject == null)
    {
      paramSQLiteProgram.bindNull(paramInt);
      AppMethodBeat.o(2802);
      return;
    }
    if (((paramObject instanceof Double)) || ((paramObject instanceof Float)))
    {
      paramSQLiteProgram.bindDouble(paramInt, ((Number)paramObject).doubleValue());
      AppMethodBeat.o(2802);
      return;
    }
    if ((paramObject instanceof Number))
    {
      paramSQLiteProgram.bindLong(paramInt, ((Number)paramObject).longValue());
      AppMethodBeat.o(2802);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      if (((Boolean)paramObject).booleanValue())
      {
        paramSQLiteProgram.bindLong(paramInt, 1L);
        AppMethodBeat.o(2802);
        return;
      }
      paramSQLiteProgram.bindLong(paramInt, 0L);
      AppMethodBeat.o(2802);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      paramSQLiteProgram.bindBlob(paramInt, (byte[])paramObject);
      AppMethodBeat.o(2802);
      return;
    }
    paramSQLiteProgram.bindString(paramInt, paramObject.toString());
    AppMethodBeat.o(2802);
  }
  
  public static String concatenateWhere(String paramString1, String paramString2)
  {
    AppMethodBeat.i(2807);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(2807);
      return paramString2;
    }
    if (TextUtils.isEmpty(paramString2))
    {
      AppMethodBeat.o(2807);
      return paramString1;
    }
    paramString1 = "(" + paramString1 + ") AND (" + paramString2 + ")";
    AppMethodBeat.o(2807);
    return paramString1;
  }
  
  public static void createDbFromSqlStatements(android.content.Context paramContext, String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(2845);
    createDbFromSqlStatements(paramContext, paramString1, null, null, paramInt, paramString2);
    AppMethodBeat.o(2845);
  }
  
  public static void createDbFromSqlStatements(android.content.Context paramContext, String paramString1, byte[] paramArrayOfByte, SQLiteCipherSpec paramSQLiteCipherSpec, int paramInt, String paramString2)
  {
    int i = 0;
    AppMethodBeat.i(2844);
    paramContext = com.tencent.wcdb.support.Context.openOrCreateDatabase(paramContext, paramString1, paramArrayOfByte, paramSQLiteCipherSpec, 0, null);
    paramString1 = TextUtils.split(paramString2, ";\n");
    int j = paramString1.length;
    while (i < j)
    {
      paramArrayOfByte = paramString1[i];
      if (!TextUtils.isEmpty(paramArrayOfByte)) {
        paramContext.execSQL(paramArrayOfByte);
      }
      i += 1;
    }
    paramContext.setVersion(paramInt);
    paramContext.close();
    AppMethodBeat.o(2844);
  }
  
  public static void cursorDoubleToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    AppMethodBeat.i(2827);
    int i = paramCursor.getColumnIndex(paramString1);
    if (!paramCursor.isNull(i))
    {
      paramContentValues.put(paramString2, Double.valueOf(paramCursor.getDouble(i)));
      AppMethodBeat.o(2827);
      return;
    }
    paramContentValues.put(paramString2, null);
    AppMethodBeat.o(2827);
  }
  
  public static void cursorDoubleToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    AppMethodBeat.i(2843);
    int i = paramCursor.getColumnIndex(paramString);
    if ((i != -1) && (!paramCursor.isNull(i))) {
      paramContentValues.put(paramString, Double.valueOf(paramCursor.getDouble(i)));
    }
    AppMethodBeat.o(2843);
  }
  
  public static void cursorDoubleToCursorValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    AppMethodBeat.i(2826);
    cursorDoubleToContentValues(paramCursor, paramString, paramContentValues, paramString);
    AppMethodBeat.o(2826);
  }
  
  public static void cursorFillWindow(Cursor paramCursor, int paramInt, CursorWindow paramCursorWindow)
  {
    AppMethodBeat.i(2803);
    if ((paramInt < 0) || (paramInt >= paramCursor.getCount()))
    {
      AppMethodBeat.o(2803);
      return;
    }
    int j = paramCursor.getPosition();
    int k = paramCursor.getColumnCount();
    paramCursorWindow.clear();
    paramCursorWindow.setStartPosition(paramInt);
    paramCursorWindow.setNumColumns(k);
    int i;
    if (paramCursor.moveToPosition(paramInt)) {
      if (paramCursorWindow.allocRow()) {
        i = 0;
      }
    }
    for (;;)
    {
      Object localObject;
      boolean bool;
      if (i < k) {
        switch (paramCursor.getType(i))
        {
        case 3: 
        default: 
          localObject = paramCursor.getString(i);
          if (localObject != null) {
            bool = paramCursorWindow.putString((String)localObject, paramInt, i);
          }
          break;
        }
      }
      for (;;)
      {
        if (bool) {
          break label282;
        }
        paramCursorWindow.freeLastRow();
        paramInt += 1;
        if (paramCursor.moveToNext()) {
          break;
        }
        paramCursor.moveToPosition(j);
        AppMethodBeat.o(2803);
        return;
        bool = paramCursorWindow.putNull(paramInt, i);
        continue;
        bool = paramCursorWindow.putLong(paramCursor.getLong(i), paramInt, i);
        continue;
        bool = paramCursorWindow.putDouble(paramCursor.getDouble(i), paramInt, i);
        continue;
        localObject = paramCursor.getBlob(i);
        if (localObject != null)
        {
          bool = paramCursorWindow.putBlob((byte[])localObject, paramInt, i);
        }
        else
        {
          bool = paramCursorWindow.putNull(paramInt, i);
          continue;
          bool = paramCursorWindow.putNull(paramInt, i);
        }
      }
      label282:
      i += 1;
    }
  }
  
  public static void cursorFloatToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    AppMethodBeat.i(2842);
    int i = paramCursor.getColumnIndex(paramString);
    if ((i != -1) && (!paramCursor.isNull(i))) {
      paramContentValues.put(paramString, Float.valueOf(paramCursor.getFloat(i)));
    }
    AppMethodBeat.o(2842);
  }
  
  public static void cursorIntToContentValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    AppMethodBeat.i(2822);
    cursorIntToContentValues(paramCursor, paramString, paramContentValues, paramString);
    AppMethodBeat.o(2822);
  }
  
  public static void cursorIntToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    AppMethodBeat.i(2823);
    int i = paramCursor.getColumnIndex(paramString1);
    if (!paramCursor.isNull(i))
    {
      paramContentValues.put(paramString2, Integer.valueOf(paramCursor.getInt(i)));
      AppMethodBeat.o(2823);
      return;
    }
    paramContentValues.put(paramString2, null);
    AppMethodBeat.o(2823);
  }
  
  public static void cursorIntToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    AppMethodBeat.i(2841);
    int i = paramCursor.getColumnIndex(paramString);
    if ((i != -1) && (!paramCursor.isNull(i))) {
      paramContentValues.put(paramString, Integer.valueOf(paramCursor.getInt(i)));
    }
    AppMethodBeat.o(2841);
  }
  
  public static void cursorLongToContentValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    AppMethodBeat.i(2824);
    cursorLongToContentValues(paramCursor, paramString, paramContentValues, paramString);
    AppMethodBeat.o(2824);
  }
  
  public static void cursorLongToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    AppMethodBeat.i(2825);
    int i = paramCursor.getColumnIndex(paramString1);
    if (!paramCursor.isNull(i))
    {
      paramContentValues.put(paramString2, Long.valueOf(paramCursor.getLong(i)));
      AppMethodBeat.o(2825);
      return;
    }
    paramContentValues.put(paramString2, null);
    AppMethodBeat.o(2825);
  }
  
  public static void cursorLongToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    AppMethodBeat.i(2839);
    int i = paramCursor.getColumnIndex(paramString);
    if ((i != -1) && (!paramCursor.isNull(i))) {
      paramContentValues.put(paramString, Long.valueOf(paramCursor.getLong(i)));
    }
    AppMethodBeat.o(2839);
  }
  
  public static int cursorPickFillWindowStartPosition(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2829);
    paramInt1 = Math.max(paramInt1 - paramInt2 / 3, 0);
    AppMethodBeat.o(2829);
    return paramInt1;
  }
  
  public static void cursorRowToContentValues(Cursor paramCursor, ContentValues paramContentValues)
  {
    AppMethodBeat.i(2828);
    AbstractWindowedCursor localAbstractWindowedCursor;
    String[] arrayOfString;
    int i;
    if ((paramCursor instanceof AbstractWindowedCursor))
    {
      localAbstractWindowedCursor = (AbstractWindowedCursor)paramCursor;
      arrayOfString = paramCursor.getColumnNames();
      int j = arrayOfString.length;
      i = 0;
      label33:
      if (i >= j) {
        break label98;
      }
      if ((localAbstractWindowedCursor == null) || (!localAbstractWindowedCursor.isBlob(i))) {
        break label80;
      }
      paramContentValues.put(arrayOfString[i], paramCursor.getBlob(i));
    }
    for (;;)
    {
      i += 1;
      break label33;
      localAbstractWindowedCursor = null;
      break;
      label80:
      paramContentValues.put(arrayOfString[i], paramCursor.getString(i));
    }
    label98:
    AppMethodBeat.o(2828);
  }
  
  public static void cursorShortToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    AppMethodBeat.i(2840);
    int i = paramCursor.getColumnIndex(paramString);
    if ((i != -1) && (!paramCursor.isNull(i))) {
      paramContentValues.put(paramString, Short.valueOf(paramCursor.getShort(i)));
    }
    AppMethodBeat.o(2840);
  }
  
  public static void cursorStringToContentValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    AppMethodBeat.i(2819);
    cursorStringToContentValues(paramCursor, paramString, paramContentValues, paramString);
    AppMethodBeat.o(2819);
  }
  
  public static void cursorStringToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    AppMethodBeat.i(2821);
    paramContentValues.put(paramString2, paramCursor.getString(paramCursor.getColumnIndexOrThrow(paramString1)));
    AppMethodBeat.o(2821);
  }
  
  public static void cursorStringToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    AppMethodBeat.i(2838);
    int i = paramCursor.getColumnIndex(paramString);
    if ((i != -1) && (!paramCursor.isNull(i))) {
      paramContentValues.put(paramString, paramCursor.getString(i));
    }
    AppMethodBeat.o(2838);
  }
  
  public static void cursorStringToInsertHelper(Cursor paramCursor, String paramString, InsertHelper paramInsertHelper, int paramInt)
  {
    AppMethodBeat.i(2820);
    paramInsertHelper.bind(paramInt, paramCursor.getString(paramCursor.getColumnIndexOrThrow(paramString)));
    AppMethodBeat.o(2820);
  }
  
  public static void dumpCurrentRow(Cursor paramCursor)
  {
    AppMethodBeat.i(2815);
    dumpCurrentRow(paramCursor, System.out);
    AppMethodBeat.o(2815);
  }
  
  public static void dumpCurrentRow(Cursor paramCursor, PrintStream paramPrintStream)
  {
    AppMethodBeat.i(2816);
    String[] arrayOfString = paramCursor.getColumnNames();
    paramPrintStream.println(paramCursor.getPosition() + " {");
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          String str1 = paramCursor.getString(i);
          paramPrintStream.println("   " + arrayOfString[i] + '=' + str1);
          i += 1;
        }
        catch (SQLiteException localSQLiteException)
        {
          for (;;)
          {
            String str2 = "<unprintable>";
          }
        }
      }
    }
    paramPrintStream.println("}");
    AppMethodBeat.o(2816);
  }
  
  public static void dumpCurrentRow(Cursor paramCursor, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(2817);
    String[] arrayOfString = paramCursor.getColumnNames();
    paramStringBuilder.append(paramCursor.getPosition() + " {\n");
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          String str1 = paramCursor.getString(i);
          paramStringBuilder.append("   " + arrayOfString[i] + '=' + str1 + "\n");
          i += 1;
        }
        catch (SQLiteException localSQLiteException)
        {
          for (;;)
          {
            String str2 = "<unprintable>";
          }
        }
      }
    }
    paramStringBuilder.append("}\n");
    AppMethodBeat.o(2817);
  }
  
  public static String dumpCurrentRowToString(Cursor paramCursor)
  {
    AppMethodBeat.i(2818);
    StringBuilder localStringBuilder = new StringBuilder();
    dumpCurrentRow(paramCursor, localStringBuilder);
    paramCursor = localStringBuilder.toString();
    AppMethodBeat.o(2818);
    return paramCursor;
  }
  
  public static void dumpCursor(Cursor paramCursor)
  {
    AppMethodBeat.i(2811);
    dumpCursor(paramCursor, System.out);
    AppMethodBeat.o(2811);
  }
  
  public static void dumpCursor(Cursor paramCursor, PrintStream paramPrintStream)
  {
    AppMethodBeat.i(2812);
    paramPrintStream.println(">>>>> Dumping cursor ".concat(String.valueOf(paramCursor)));
    if (paramCursor != null)
    {
      int i = paramCursor.getPosition();
      paramCursor.moveToPosition(-1);
      while (paramCursor.moveToNext()) {
        dumpCurrentRow(paramCursor, paramPrintStream);
      }
      paramCursor.moveToPosition(i);
    }
    paramPrintStream.println("<<<<<");
    AppMethodBeat.o(2812);
  }
  
  public static void dumpCursor(Cursor paramCursor, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(2813);
    paramStringBuilder.append(">>>>> Dumping cursor " + paramCursor + "\n");
    if (paramCursor != null)
    {
      int i = paramCursor.getPosition();
      paramCursor.moveToPosition(-1);
      while (paramCursor.moveToNext()) {
        dumpCurrentRow(paramCursor, paramStringBuilder);
      }
      paramCursor.moveToPosition(i);
    }
    paramStringBuilder.append("<<<<<\n");
    AppMethodBeat.o(2813);
  }
  
  public static String dumpCursorToString(Cursor paramCursor)
  {
    AppMethodBeat.i(2814);
    StringBuilder localStringBuilder = new StringBuilder();
    dumpCursor(paramCursor, localStringBuilder);
    paramCursor = localStringBuilder.toString();
    AppMethodBeat.o(2814);
    return paramCursor;
  }
  
  private static char[] encodeHex(byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length;
    char[] arrayOfChar = new char[k << 1];
    int j = 0;
    int i = 0;
    while (i < k)
    {
      int m = j + 1;
      arrayOfChar[j] = DIGITS[((paramArrayOfByte[i] & 0xF0) >>> 4)];
      j = m + 1;
      arrayOfChar[m] = DIGITS[(paramArrayOfByte[i] & 0xF)];
      i += 1;
    }
    return arrayOfChar;
  }
  
  private static int extractSqlCode(String paramString)
  {
    AppMethodBeat.i(2846);
    int i = 0;
    int j = 0;
    if (i < 3)
    {
      int m = paramString.charAt(i);
      int k;
      if ((m >= 97) && (m <= 122)) {
        k = m - 97 + 65;
      }
      do
      {
        j |= (k & 0x7F) << i * 8;
        i += 1;
        break;
        k = m;
      } while (m < 128);
      AppMethodBeat.o(2846);
      return 0;
    }
    AppMethodBeat.o(2846);
    return j;
  }
  
  public static int findRowIdColumnIndex(String[] paramArrayOfString)
  {
    AppMethodBeat.i(2849);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfString[i].equals("_id"))
      {
        AppMethodBeat.o(2849);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(2849);
    return -1;
  }
  
  public static String getCollationKey(String paramString)
  {
    AppMethodBeat.i(2808);
    paramString = getCollationKeyInBytes(paramString);
    try
    {
      paramString = new String(paramString, 0, getKeyLen(paramString), "ISO8859_1");
      AppMethodBeat.o(2808);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(2808);
    }
    return "";
  }
  
  private static byte[] getCollationKeyInBytes(String paramString)
  {
    AppMethodBeat.i(2810);
    if (mColl == null)
    {
      Collator localCollator = Collator.getInstance();
      mColl = localCollator;
      localCollator.setStrength(0);
    }
    paramString = mColl.getCollationKey(paramString).toByteArray();
    AppMethodBeat.o(2810);
    return paramString;
  }
  
  public static String getHexCollationKey(String paramString)
  {
    AppMethodBeat.i(2809);
    paramString = getCollationKeyInBytes(paramString);
    paramString = new String(encodeHex(paramString), 0, getKeyLen(paramString) * 2);
    AppMethodBeat.o(2809);
    return paramString;
  }
  
  private static int getKeyLen(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte[(paramArrayOfByte.length - 1)] != 0) {
      return paramArrayOfByte.length;
    }
    return paramArrayOfByte.length - 1;
  }
  
  public static int getSqlStatementType(String paramString)
  {
    AppMethodBeat.i(2847);
    paramString = paramString.trim();
    if (paramString.length() < 3)
    {
      AppMethodBeat.o(2847);
      return 99;
    }
    switch (extractSqlCode(paramString))
    {
    default: 
      AppMethodBeat.o(2847);
      return 99;
    case 4998483: 
      AppMethodBeat.o(2847);
      return 1;
    case 4477013: 
    case 4998468: 
    case 5260626: 
    case 5459529: 
      AppMethodBeat.o(2847);
      return 2;
    case 5526593: 
      AppMethodBeat.o(2847);
      return 3;
    case 4476485: 
    case 5066563: 
      AppMethodBeat.o(2847);
      return 5;
    case 5001042: 
      AppMethodBeat.o(2847);
      return 6;
    case 4670786: 
      AppMethodBeat.o(2847);
      return 4;
    case 4280912: 
      AppMethodBeat.o(2847);
      return 7;
    case 4543043: 
    case 5198404: 
    case 5524545: 
      AppMethodBeat.o(2847);
      return 8;
    }
    AppMethodBeat.o(2847);
    return 9;
  }
  
  public static int getTypeOfObject(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    if ((paramObject instanceof byte[])) {
      return 4;
    }
    if (((paramObject instanceof Float)) || ((paramObject instanceof Double))) {
      return 2;
    }
    if (((paramObject instanceof Long)) || ((paramObject instanceof Integer)) || ((paramObject instanceof Short)) || ((paramObject instanceof Byte))) {
      return 1;
    }
    return 3;
  }
  
  public static long longForQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(2834);
    paramSQLiteDatabase = paramSQLiteDatabase.compileStatement(paramString);
    try
    {
      long l = longForQuery(paramSQLiteDatabase, paramArrayOfString);
      return l;
    }
    finally
    {
      paramSQLiteDatabase.close();
      AppMethodBeat.o(2834);
    }
  }
  
  public static long longForQuery(SQLiteStatement paramSQLiteStatement, String[] paramArrayOfString)
  {
    AppMethodBeat.i(2835);
    paramSQLiteStatement.bindAllArgsAsStrings(paramArrayOfString);
    long l = paramSQLiteStatement.simpleQueryForLong();
    AppMethodBeat.o(2835);
    return l;
  }
  
  public static boolean objectEquals(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(2795);
    if ((paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2))))
    {
      AppMethodBeat.o(2795);
      return true;
    }
    AppMethodBeat.o(2795);
    return false;
  }
  
  public static boolean queryIsEmpty(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    AppMethodBeat.i(2833);
    if (longForQuery(paramSQLiteDatabase, "select exists(select 1 from " + paramString + ")", null) == 0L)
    {
      AppMethodBeat.o(2833);
      return true;
    }
    AppMethodBeat.o(2833);
    return false;
  }
  
  public static long queryNumEntries(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    AppMethodBeat.i(2830);
    long l = queryNumEntries(paramSQLiteDatabase, paramString, null, null);
    AppMethodBeat.o(2830);
    return l;
  }
  
  public static long queryNumEntries(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    AppMethodBeat.i(2831);
    long l = queryNumEntries(paramSQLiteDatabase, paramString1, paramString2, null);
    AppMethodBeat.o(2831);
    return l;
  }
  
  public static long queryNumEntries(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(2832);
    if (!TextUtils.isEmpty(paramString2)) {}
    for (paramString2 = " where ".concat(String.valueOf(paramString2));; paramString2 = "")
    {
      long l = longForQuery(paramSQLiteDatabase, "select count(*) from " + paramString1 + paramString2, paramArrayOfString);
      AppMethodBeat.o(2832);
      return l;
    }
  }
  
  private static final int readExceptionCode(Parcel paramParcel)
  {
    AppMethodBeat.i(2797);
    int i = paramParcel.readInt();
    if (i == -128)
    {
      if (paramParcel.readInt() == 0) {
        Log.e("WCDB.DatabaseUtils", "Unexpected zero-sized Parcel reply header.");
      }
      AppMethodBeat.o(2797);
      return 0;
    }
    AppMethodBeat.o(2797);
    return i;
  }
  
  public static final void readExceptionFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(2798);
    int i = readExceptionCode(paramParcel);
    if (i == 0)
    {
      AppMethodBeat.o(2798);
      return;
    }
    readExceptionFromParcel(paramParcel, paramParcel.readString(), i);
    AppMethodBeat.o(2798);
  }
  
  private static final void readExceptionFromParcel(Parcel paramParcel, String paramString, int paramInt)
  {
    AppMethodBeat.i(2801);
    switch (paramInt)
    {
    case 10: 
    default: 
      paramParcel.readException(paramInt, paramString);
      AppMethodBeat.o(2801);
      return;
    case 2: 
      paramParcel = new IllegalArgumentException(paramString);
      AppMethodBeat.o(2801);
      throw paramParcel;
    case 3: 
      paramParcel = new UnsupportedOperationException(paramString);
      AppMethodBeat.o(2801);
      throw paramParcel;
    case 4: 
      paramParcel = new SQLiteAbortException(paramString);
      AppMethodBeat.o(2801);
      throw paramParcel;
    case 5: 
      paramParcel = new SQLiteConstraintException(paramString);
      AppMethodBeat.o(2801);
      throw paramParcel;
    case 6: 
      paramParcel = new SQLiteDatabaseCorruptException(paramString);
      AppMethodBeat.o(2801);
      throw paramParcel;
    case 7: 
      paramParcel = new SQLiteFullException(paramString);
      AppMethodBeat.o(2801);
      throw paramParcel;
    case 8: 
      paramParcel = new SQLiteDiskIOException(paramString);
      AppMethodBeat.o(2801);
      throw paramParcel;
    case 9: 
      paramParcel = new SQLiteException(paramString);
      AppMethodBeat.o(2801);
      throw paramParcel;
    }
    paramParcel = new OperationCanceledException(paramString);
    AppMethodBeat.o(2801);
    throw paramParcel;
  }
  
  public static void readExceptionWithFileNotFoundExceptionFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(2799);
    int i = readExceptionCode(paramParcel);
    if (i == 0)
    {
      AppMethodBeat.o(2799);
      return;
    }
    String str = paramParcel.readString();
    if (i == 1)
    {
      paramParcel = new FileNotFoundException(str);
      AppMethodBeat.o(2799);
      throw paramParcel;
    }
    readExceptionFromParcel(paramParcel, str, i);
    AppMethodBeat.o(2799);
  }
  
  public static void readExceptionWithOperationApplicationExceptionFromParcel(Parcel paramParcel)
  {
    AppMethodBeat.i(2800);
    int i = readExceptionCode(paramParcel);
    if (i == 0)
    {
      AppMethodBeat.o(2800);
      return;
    }
    String str = paramParcel.readString();
    if (i == 10)
    {
      paramParcel = new OperationApplicationException(str);
      AppMethodBeat.o(2800);
      throw paramParcel;
    }
    readExceptionFromParcel(paramParcel, str, i);
    AppMethodBeat.o(2800);
  }
  
  public static String sqlEscapeString(String paramString)
  {
    AppMethodBeat.i(2805);
    StringBuilder localStringBuilder = new StringBuilder();
    appendEscapedSQLString(localStringBuilder, paramString);
    paramString = localStringBuilder.toString();
    AppMethodBeat.o(2805);
    return paramString;
  }
  
  public static String stringForQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(2836);
    paramSQLiteDatabase = paramSQLiteDatabase.compileStatement(paramString);
    try
    {
      paramString = stringForQuery(paramSQLiteDatabase, paramArrayOfString);
      return paramString;
    }
    finally
    {
      paramSQLiteDatabase.close();
      AppMethodBeat.o(2836);
    }
  }
  
  public static String stringForQuery(SQLiteStatement paramSQLiteStatement, String[] paramArrayOfString)
  {
    AppMethodBeat.i(2837);
    paramSQLiteStatement.bindAllArgsAsStrings(paramArrayOfString);
    paramSQLiteStatement = paramSQLiteStatement.simpleQueryForString();
    AppMethodBeat.o(2837);
    return paramSQLiteStatement;
  }
  
  public static final void writeExceptionToParcel(Parcel paramParcel, Exception paramException)
  {
    AppMethodBeat.i(2796);
    int i;
    int j;
    if ((paramException instanceof FileNotFoundException))
    {
      i = 1;
      j = 0;
    }
    for (;;)
    {
      paramParcel.writeInt(i);
      paramParcel.writeString(paramException.getMessage());
      if (j != 0) {
        Log.e("WCDB.DatabaseUtils", "Writing exception to parcel", new Object[] { paramException });
      }
      AppMethodBeat.o(2796);
      return;
      if ((paramException instanceof IllegalArgumentException))
      {
        i = 2;
        j = 1;
      }
      else if ((paramException instanceof UnsupportedOperationException))
      {
        i = 3;
        j = 1;
      }
      else if ((paramException instanceof SQLiteAbortException))
      {
        i = 4;
        j = 1;
      }
      else if ((paramException instanceof SQLiteConstraintException))
      {
        i = 5;
        j = 1;
      }
      else if ((paramException instanceof SQLiteDatabaseCorruptException))
      {
        i = 6;
        j = 1;
      }
      else if ((paramException instanceof SQLiteFullException))
      {
        i = 7;
        j = 1;
      }
      else if ((paramException instanceof SQLiteDiskIOException))
      {
        i = 8;
        j = 1;
      }
      else if ((paramException instanceof SQLiteException))
      {
        i = 9;
        j = 1;
      }
      else if ((paramException instanceof OperationApplicationException))
      {
        i = 10;
        j = 1;
      }
      else
      {
        if (!(paramException instanceof OperationCanceledException)) {
          break;
        }
        i = 11;
        j = 0;
      }
    }
    paramParcel.writeException(paramException);
    Log.e("WCDB.DatabaseUtils", "Writing exception to parcel", new Object[] { paramException });
    AppMethodBeat.o(2796);
  }
  
  @Deprecated
  public static class InsertHelper
  {
    public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
    public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
    private HashMap<String, Integer> mColumns;
    private final SQLiteDatabase mDb;
    private String mInsertSQL = null;
    private SQLiteStatement mInsertStatement = null;
    private SQLiteStatement mPreparedStatement = null;
    private SQLiteStatement mReplaceStatement = null;
    private final String mTableName;
    
    public InsertHelper(SQLiteDatabase paramSQLiteDatabase, String paramString)
    {
      this.mDb = paramSQLiteDatabase;
      this.mTableName = paramString;
    }
    
    private void buildSQL()
    {
      Object localObject1 = null;
      AppMethodBeat.i(2777);
      StringBuilder localStringBuilder1 = new StringBuilder(128);
      localStringBuilder1.append("INSERT INTO ");
      localStringBuilder1.append(this.mTableName);
      localStringBuilder1.append(" (");
      StringBuilder localStringBuilder2 = new StringBuilder(128);
      localStringBuilder2.append("VALUES (");
      Cursor localCursor;
      for (;;)
      {
        try
        {
          localCursor = this.mDb.rawQuery("PRAGMA table_info(" + this.mTableName + ")", null);
          localObject1 = localCursor;
          this.mColumns = new HashMap(localCursor.getCount());
          int i = 1;
          localObject1 = localCursor;
          if (!localCursor.moveToNext()) {
            break;
          }
          localObject1 = localCursor;
          String str1 = localCursor.getString(1);
          localObject1 = localCursor;
          String str3 = localCursor.getString(4);
          localObject1 = localCursor;
          this.mColumns.put(str1, Integer.valueOf(i));
          localObject1 = localCursor;
          localStringBuilder1.append("'");
          localObject1 = localCursor;
          localStringBuilder1.append(str1);
          localObject1 = localCursor;
          localStringBuilder1.append("'");
          if (str3 == null)
          {
            localObject1 = localCursor;
            localStringBuilder2.append("?");
            localObject1 = localCursor;
            if (i == localCursor.getCount())
            {
              str1 = ") ";
              localObject1 = localCursor;
              localStringBuilder1.append(str1);
              localObject1 = localCursor;
              if (i != localCursor.getCount()) {
                break label347;
              }
              str1 = ");";
              localObject1 = localCursor;
              localStringBuilder2.append(str1);
              i += 1;
            }
          }
          else
          {
            localObject1 = localCursor;
            localStringBuilder2.append("COALESCE(?, ");
            localObject1 = localCursor;
            localStringBuilder2.append(str3);
            localObject1 = localCursor;
            localStringBuilder2.append(")");
            continue;
          }
          str2 = ", ";
        }
        finally
        {
          if (localObject1 != null) {
            localObject1.close();
          }
          AppMethodBeat.o(2777);
        }
        continue;
        label347:
        String str2 = ", ";
      }
      if (localCursor != null) {
        localCursor.close();
      }
      localStringBuilder1.append(localStringBuilder2);
      this.mInsertSQL = localStringBuilder1.toString();
      AppMethodBeat.o(2777);
    }
    
    private SQLiteStatement getStatement(boolean paramBoolean)
    {
      AppMethodBeat.i(2778);
      if (paramBoolean)
      {
        if (this.mReplaceStatement == null)
        {
          if (this.mInsertSQL == null) {
            buildSQL();
          }
          localObject = "INSERT OR REPLACE" + this.mInsertSQL.substring(6);
          this.mReplaceStatement = this.mDb.compileStatement((String)localObject);
        }
        localObject = this.mReplaceStatement;
        AppMethodBeat.o(2778);
        return localObject;
      }
      if (this.mInsertStatement == null)
      {
        if (this.mInsertSQL == null) {
          buildSQL();
        }
        this.mInsertStatement = this.mDb.compileStatement(this.mInsertSQL);
      }
      Object localObject = this.mInsertStatement;
      AppMethodBeat.o(2778);
      return localObject;
    }
    
    /* Error */
    private long insertInternal(ContentValues paramContentValues, boolean paramBoolean)
    {
      // Byte code:
      //   0: sipush 2779
      //   3: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: getfield 40	com/tencent/wcdb/DatabaseUtils$InsertHelper:mDb	Lcom/tencent/wcdb/database/SQLiteDatabase;
      //   10: invokevirtual 153	com/tencent/wcdb/database/SQLiteDatabase:beginTransactionNonExclusive	()V
      //   13: aload_0
      //   14: iload_2
      //   15: invokespecial 155	com/tencent/wcdb/DatabaseUtils$InsertHelper:getStatement	(Z)Lcom/tencent/wcdb/database/SQLiteStatement;
      //   18: astore 5
      //   20: aload 5
      //   22: invokevirtual 160	com/tencent/wcdb/database/SQLiteStatement:clearBindings	()V
      //   25: aload_1
      //   26: invokevirtual 166	android/content/ContentValues:valueSet	()Ljava/util/Set;
      //   29: invokeinterface 172 1 0
      //   34: astore 6
      //   36: aload 6
      //   38: invokeinterface 177 1 0
      //   43: ifeq +105 -> 148
      //   46: aload 6
      //   48: invokeinterface 181 1 0
      //   53: checkcast 183	java/util/Map$Entry
      //   56: astore 7
      //   58: aload 5
      //   60: aload_0
      //   61: aload 7
      //   63: invokeinterface 186 1 0
      //   68: checkcast 139	java/lang/String
      //   71: invokevirtual 190	com/tencent/wcdb/DatabaseUtils$InsertHelper:getColumnIndex	(Ljava/lang/String;)I
      //   74: aload 7
      //   76: invokeinterface 193 1 0
      //   81: invokestatic 197	com/tencent/wcdb/DatabaseUtils:bindObjectToProgram	(Lcom/tencent/wcdb/database/SQLiteProgram;ILjava/lang/Object;)V
      //   84: goto -48 -> 36
      //   87: astore 5
      //   89: ldc 199
      //   91: new 52	java/lang/StringBuilder
      //   94: dup
      //   95: ldc 201
      //   97: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   100: aload_1
      //   101: invokevirtual 204	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   104: ldc 206
      //   106: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   109: aload_0
      //   110: getfield 42	com/tencent/wcdb/DatabaseUtils$InsertHelper:mTableName	Ljava/lang/String;
      //   113: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   116: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   119: iconst_1
      //   120: anewarray 4	java/lang/Object
      //   123: dup
      //   124: iconst_0
      //   125: aload 5
      //   127: aastore
      //   128: invokestatic 212	com/tencent/wcdb/support/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   131: aload_0
      //   132: getfield 40	com/tencent/wcdb/DatabaseUtils$InsertHelper:mDb	Lcom/tencent/wcdb/database/SQLiteDatabase;
      //   135: invokevirtual 215	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
      //   138: sipush 2779
      //   141: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   144: ldc2_w 216
      //   147: lreturn
      //   148: aload 5
      //   150: invokevirtual 221	com/tencent/wcdb/database/SQLiteStatement:executeInsert	()J
      //   153: lstore_3
      //   154: aload_0
      //   155: getfield 40	com/tencent/wcdb/DatabaseUtils$InsertHelper:mDb	Lcom/tencent/wcdb/database/SQLiteDatabase;
      //   158: invokevirtual 224	com/tencent/wcdb/database/SQLiteDatabase:setTransactionSuccessful	()V
      //   161: aload_0
      //   162: getfield 40	com/tencent/wcdb/DatabaseUtils$InsertHelper:mDb	Lcom/tencent/wcdb/database/SQLiteDatabase;
      //   165: invokevirtual 215	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
      //   168: sipush 2779
      //   171: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   174: lload_3
      //   175: lreturn
      //   176: astore_1
      //   177: aload_0
      //   178: getfield 40	com/tencent/wcdb/DatabaseUtils$InsertHelper:mDb	Lcom/tencent/wcdb/database/SQLiteDatabase;
      //   181: invokevirtual 215	com/tencent/wcdb/database/SQLiteDatabase:endTransaction	()V
      //   184: sipush 2779
      //   187: invokestatic 126	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   190: aload_1
      //   191: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	192	0	this	InsertHelper
      //   0	192	1	paramContentValues	ContentValues
      //   0	192	2	paramBoolean	boolean
      //   153	22	3	l	long
      //   18	41	5	localSQLiteStatement	SQLiteStatement
      //   87	62	5	localSQLException	SQLException
      //   34	13	6	localIterator	java.util.Iterator
      //   56	19	7	localEntry	java.util.Map.Entry
      // Exception table:
      //   from	to	target	type
      //   13	36	87	com/tencent/wcdb/SQLException
      //   36	84	87	com/tencent/wcdb/SQLException
      //   148	161	87	com/tencent/wcdb/SQLException
      //   13	36	176	finally
      //   36	84	176	finally
      //   89	131	176	finally
      //   148	161	176	finally
    }
    
    public void bind(int paramInt, double paramDouble)
    {
      AppMethodBeat.i(2781);
      this.mPreparedStatement.bindDouble(paramInt, paramDouble);
      AppMethodBeat.o(2781);
    }
    
    public void bind(int paramInt, float paramFloat)
    {
      AppMethodBeat.i(2782);
      this.mPreparedStatement.bindDouble(paramInt, paramFloat);
      AppMethodBeat.o(2782);
    }
    
    public void bind(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(2784);
      this.mPreparedStatement.bindLong(paramInt1, paramInt2);
      AppMethodBeat.o(2784);
    }
    
    public void bind(int paramInt, long paramLong)
    {
      AppMethodBeat.i(2783);
      this.mPreparedStatement.bindLong(paramInt, paramLong);
      AppMethodBeat.o(2783);
    }
    
    public void bind(int paramInt, String paramString)
    {
      AppMethodBeat.i(2788);
      if (paramString == null)
      {
        this.mPreparedStatement.bindNull(paramInt);
        AppMethodBeat.o(2788);
        return;
      }
      this.mPreparedStatement.bindString(paramInt, paramString);
      AppMethodBeat.o(2788);
    }
    
    public void bind(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(2785);
      SQLiteStatement localSQLiteStatement = this.mPreparedStatement;
      if (paramBoolean) {}
      for (long l = 1L;; l = 0L)
      {
        localSQLiteStatement.bindLong(paramInt, l);
        AppMethodBeat.o(2785);
        return;
      }
    }
    
    public void bind(int paramInt, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(2787);
      if (paramArrayOfByte == null)
      {
        this.mPreparedStatement.bindNull(paramInt);
        AppMethodBeat.o(2787);
        return;
      }
      this.mPreparedStatement.bindBlob(paramInt, paramArrayOfByte);
      AppMethodBeat.o(2787);
    }
    
    public void bindNull(int paramInt)
    {
      AppMethodBeat.i(2786);
      this.mPreparedStatement.bindNull(paramInt);
      AppMethodBeat.o(2786);
    }
    
    public void close()
    {
      AppMethodBeat.i(2794);
      if (this.mInsertStatement != null)
      {
        this.mInsertStatement.close();
        this.mInsertStatement = null;
      }
      if (this.mReplaceStatement != null)
      {
        this.mReplaceStatement.close();
        this.mReplaceStatement = null;
      }
      this.mInsertSQL = null;
      this.mColumns = null;
      AppMethodBeat.o(2794);
    }
    
    public long execute()
    {
      AppMethodBeat.i(2790);
      if (this.mPreparedStatement == null)
      {
        IllegalStateException localIllegalStateException = new IllegalStateException("you must prepare this inserter before calling execute");
        AppMethodBeat.o(2790);
        throw localIllegalStateException;
      }
      try
      {
        long l = this.mPreparedStatement.executeInsert();
        return l;
      }
      catch (SQLException localSQLException)
      {
        Log.e("WCDB.DatabaseUtils", "Error executing InsertHelper with table " + this.mTableName, new Object[] { localSQLException });
        return -1L;
      }
      finally
      {
        this.mPreparedStatement = null;
        AppMethodBeat.o(2790);
      }
    }
    
    public int getColumnIndex(String paramString)
    {
      AppMethodBeat.i(2780);
      getStatement(false);
      Integer localInteger = (Integer)this.mColumns.get(paramString);
      if (localInteger == null)
      {
        paramString = new IllegalArgumentException("column '" + paramString + "' is invalid");
        AppMethodBeat.o(2780);
        throw paramString;
      }
      int i = localInteger.intValue();
      AppMethodBeat.o(2780);
      return i;
    }
    
    public long insert(ContentValues paramContentValues)
    {
      AppMethodBeat.i(2789);
      long l = insertInternal(paramContentValues, false);
      AppMethodBeat.o(2789);
      return l;
    }
    
    public void prepareForInsert()
    {
      AppMethodBeat.i(2791);
      this.mPreparedStatement = getStatement(false);
      this.mPreparedStatement.clearBindings();
      AppMethodBeat.o(2791);
    }
    
    public void prepareForReplace()
    {
      AppMethodBeat.i(2792);
      this.mPreparedStatement = getStatement(true);
      this.mPreparedStatement.clearBindings();
      AppMethodBeat.o(2792);
    }
    
    public long replace(ContentValues paramContentValues)
    {
      AppMethodBeat.i(2793);
      long l = insertInternal(paramContentValues, true);
      AppMethodBeat.o(2793);
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wcdb.DatabaseUtils
 * JD-Core Version:    0.7.0.1
 */