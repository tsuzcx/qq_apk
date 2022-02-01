package com.tencent.smtt.sdk;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.f;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class l
{
  public static final String a = CookieManager.LOGTAG;
  static File b;
  
  public static File a(Context paramContext)
  {
    AppMethodBeat.i(219426);
    if ((b == null) && (paramContext != null)) {
      b = new File(paramContext.getDir("webview", 0), "Cookies");
    }
    if (b == null) {
      b = new File("/data/data/" + paramContext.getPackageName() + File.separator + "app_webview" + File.separator + "Cookies");
    }
    paramContext = b;
    AppMethodBeat.o(219426);
    return paramContext;
  }
  
  private static String a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    AppMethodBeat.i(219451);
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("select * from ".concat(String.valueOf(paramString)), null);
    int i = paramSQLiteDatabase.getCount();
    int j = paramSQLiteDatabase.getColumnCount();
    paramString = new StringBuilder();
    paramString.append("raws:" + i + ",columns:" + j + "\n");
    if ((i > 0) && (paramSQLiteDatabase.moveToFirst()))
    {
      label125:
      do
      {
        paramString.append("\n");
        i = 0;
        while (i < j)
        {
          try
          {
            String str = paramSQLiteDatabase.getString(i);
            paramString.append(str).append(",");
          }
          catch (Exception localException)
          {
            break label125;
          }
          i += 1;
        }
        paramString.append("\n");
      } while (paramSQLiteDatabase.moveToNext());
    }
    else
    {
      paramSQLiteDatabase = paramString.toString();
      AppMethodBeat.o(219451);
      return paramSQLiteDatabase;
    }
  }
  
  public static ArrayList<String> a(SQLiteDatabase paramSQLiteDatabase)
  {
    localObject1 = null;
    AppMethodBeat.i(219446);
    if (paramSQLiteDatabase == null)
    {
      AppMethodBeat.o(219446);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("select * from sqlite_master where type='table'", null);
      localObject1 = localCursor;
      new StringBuilder("db version:").append(paramSQLiteDatabase.getVersion());
      localObject1 = localCursor;
      if (localCursor.moveToFirst())
      {
        boolean bool;
        do
        {
          localObject1 = localCursor;
          String str1 = localCursor.getString(1);
          localObject1 = localCursor;
          String str2 = localCursor.getString(4);
          localObject1 = localCursor;
          localArrayList.add(str1);
          localObject1 = localCursor;
          new StringBuilder("tablename:").append(str1).append("->").append(str2);
          localObject1 = localCursor;
          a(paramSQLiteDatabase, str1);
          localObject1 = localCursor;
          bool = localCursor.moveToNext();
        } while (bool);
      }
      if (localCursor != null) {
        localCursor.close();
      }
      if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.isOpen())) {
        paramSQLiteDatabase.close();
      }
    }
    finally
    {
      for (;;)
      {
        if (localObject1 != null) {
          localObject1.close();
        }
        if ((paramSQLiteDatabase != null) && (paramSQLiteDatabase.isOpen())) {
          paramSQLiteDatabase.close();
        }
      }
    }
    AppMethodBeat.o(219446);
    return localArrayList;
  }
  
  public static void a(Context paramContext, CookieManager.a parama, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(219470);
    if (paramContext == null)
    {
      AppMethodBeat.o(219470);
      return;
    }
    new StringBuilder("transformCookies:").append(paramString).append(", mode:").append(parama.ordinal());
    l = System.currentTimeMillis();
    if ((parama == CookieManager.a.b) && (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(219470);
      return;
    }
    String[] arrayOfString = paramString.split(",");
    if ((arrayOfString == null) || (arrayOfString.length <= 0))
    {
      AppMethodBeat.o(219470);
      return;
    }
    localSQLiteDatabase = c(paramContext);
    if (localSQLiteDatabase == null)
    {
      AppMethodBeat.o(219470);
      return;
    }
    paramString = null;
    localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        localObject1 = localSQLiteDatabase.rawQuery("select * from cookies", null);
        paramString = (String)localObject1;
        m = ((Cursor)localObject1).getCount();
        if (m <= 0) {
          continue;
        }
        paramString = (String)localObject1;
        if (!((Cursor)localObject1).moveToFirst()) {
          continue;
        }
        paramString = (String)localObject1;
        str = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("host_key"));
        paramString = (String)localObject1;
        if (parama == CookieManager.a.b)
        {
          int k = 0;
          paramString = (String)localObject1;
          int n = arrayOfString.length;
          i = 0;
          j = k;
          if (i >= n) {
            continue;
          }
          paramString = (String)localObject1;
          if (!str.equals(arrayOfString[i])) {
            continue;
          }
          j = 1;
        }
      }
      finally
      {
        Object localObject1;
        int j;
        try
        {
          int m;
          String str;
          Object localObject2;
          new StringBuilder("getCookieDBVersion exception:").append(parama.toString());
          if (paramString != null) {
            paramString.close();
          }
          if ((localSQLiteDatabase == null) || (!localSQLiteDatabase.isOpen())) {
            continue;
          }
          localSQLiteDatabase.close();
        }
        finally
        {
          if (paramString != null) {
            paramString.close();
          }
          if ((localSQLiteDatabase != null) && (localSQLiteDatabase.isOpen())) {
            localSQLiteDatabase.close();
          }
          AppMethodBeat.o(219470);
        }
        new StringBuilder("set cookie:").append(paramString).append(",").append((String)localObject1);
        CookieManager.getInstance().setCookie(paramString, (String)localObject1, true);
        continue;
        if (Build.VERSION.SDK_INT < 21) {
          continue;
        }
        CookieManager.getInstance().flush();
        if (!paramBoolean1) {
          continue;
        }
        a(c(paramContext));
        int i = d(paramContext);
        if (i == -1) {
          continue;
        }
        CookieManager.getInstance();
        CookieManager.setROMCookieDBVersion(paramContext, i);
        new StringBuilder("transformCookies,timeused:").append(System.currentTimeMillis() - l);
        AppMethodBeat.o(219470);
        return;
        CookieSyncManager.getInstance().sync();
        continue;
        if (j == 0) {
          continue;
        }
        continue;
      }
      paramString = (String)localObject1;
      localObject2 = new StringBuilder();
      paramString = (String)localObject1;
      ((StringBuilder)localObject2).append(((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("value")));
      paramString = (String)localObject1;
      ((StringBuilder)localObject2).append(";").append(((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("name")));
      paramString = (String)localObject1;
      ((StringBuilder)localObject2).append(";").append(((Cursor)localObject1).getInt(((Cursor)localObject1).getColumnIndex("expires_utc")));
      paramString = (String)localObject1;
      ((StringBuilder)localObject2).append(";").append(((Cursor)localObject1).getInt(((Cursor)localObject1).getColumnIndex("priority")));
      paramString = (String)localObject1;
      localObject2 = ((StringBuilder)localObject2).toString();
      paramString = (String)localObject1;
      localHashMap.put(str, localObject2);
      paramString = (String)localObject1;
      new StringBuilder("key : value -> ").append(str).append(":").append((String)localObject2);
      paramString = (String)localObject1;
      if (!((Cursor)localObject1).moveToNext())
      {
        paramString = (String)localObject1;
        new StringBuilder("transformCookies,nums - > num : ").append(m).append(",count:").append(localHashMap.size());
        if (localObject1 != null) {
          ((Cursor)localObject1).close();
        }
        if ((localSQLiteDatabase != null) && (localSQLiteDatabase.isOpen())) {
          localSQLiteDatabase.close();
        }
        if (!localHashMap.isEmpty()) {
          continue;
        }
        AppMethodBeat.o(219470);
        return;
        i += 1;
      }
    }
  }
  
  public static boolean b(Context paramContext)
  {
    AppMethodBeat.i(219432);
    if (paramContext == null)
    {
      AppMethodBeat.o(219432);
      return false;
    }
    f.a(a(paramContext), false);
    AppMethodBeat.o(219432);
    return true;
  }
  
  public static SQLiteDatabase c(Context paramContext)
  {
    Object localObject = null;
    AppMethodBeat.i(219437);
    if (paramContext == null)
    {
      AppMethodBeat.o(219437);
      return null;
    }
    paramContext = a(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(219437);
      return null;
    }
    try
    {
      paramContext = SQLiteDatabase.openDatabase(paramContext.getAbsolutePath(), null, 0);
      if (paramContext == null) {
        TbsLog.i(a, "dbPath is not exist!");
      }
      AppMethodBeat.o(219437);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = localObject;
      }
    }
  }
  
  /* Error */
  public static int d(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_2
    //   4: ldc_w 337
    //   7: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: invokestatic 174	java/lang/System:currentTimeMillis	()J
    //   13: lstore 5
    //   15: aload_0
    //   16: invokestatic 191	com/tencent/smtt/sdk/l:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   19: astore 9
    //   21: aload 9
    //   23: ifnonnull +29 -> 52
    //   26: aload 9
    //   28: ifnull +16 -> 44
    //   31: aload 9
    //   33: invokevirtual 154	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   36: ifeq +8 -> 44
    //   39: aload 9
    //   41: invokevirtual 155	android/database/sqlite/SQLiteDatabase:close	()V
    //   44: ldc_w 337
    //   47: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: iconst_m1
    //   51: ireturn
    //   52: aload 9
    //   54: ldc_w 339
    //   57: aconst_null
    //   58: invokevirtual 93	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   61: astore 8
    //   63: aload 8
    //   65: invokeinterface 99 1 0
    //   70: istore 4
    //   72: aload 8
    //   74: invokeinterface 102 1 0
    //   79: pop
    //   80: iload_2
    //   81: istore_1
    //   82: iload 4
    //   84: ifle +44 -> 128
    //   87: iload_2
    //   88: istore_1
    //   89: aload 8
    //   91: invokeinterface 117 1 0
    //   96: ifeq +32 -> 128
    //   99: aload 8
    //   101: iconst_0
    //   102: invokeinterface 121 2 0
    //   107: ldc_w 341
    //   110: invokevirtual 205	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   113: ifeq +89 -> 202
    //   116: aload 8
    //   118: iconst_1
    //   119: invokeinterface 121 2 0
    //   124: invokestatic 346	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   127: istore_1
    //   128: aload 8
    //   130: ifnull +10 -> 140
    //   133: aload 8
    //   135: invokeinterface 151 1 0
    //   140: iload_1
    //   141: istore_2
    //   142: aload 9
    //   144: ifnull +20 -> 164
    //   147: iload_1
    //   148: istore_2
    //   149: aload 9
    //   151: invokevirtual 154	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   154: ifeq +10 -> 164
    //   157: aload 9
    //   159: invokevirtual 155	android/database/sqlite/SQLiteDatabase:close	()V
    //   162: iload_1
    //   163: istore_2
    //   164: new 46	java/lang/StringBuilder
    //   167: dup
    //   168: ldc_w 348
    //   171: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   174: iload_2
    //   175: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   178: ldc_w 350
    //   181: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: invokestatic 174	java/lang/System:currentTimeMillis	()J
    //   187: lload 5
    //   189: lsub
    //   190: invokevirtual 305	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: ldc_w 337
    //   197: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: iload_2
    //   201: ireturn
    //   202: aload 8
    //   204: invokeinterface 126 1 0
    //   209: istore 7
    //   211: iload 7
    //   213: ifne -114 -> 99
    //   216: iload_2
    //   217: istore_1
    //   218: goto -90 -> 128
    //   221: astore_0
    //   222: aconst_null
    //   223: astore 8
    //   225: aconst_null
    //   226: astore 9
    //   228: new 46	java/lang/StringBuilder
    //   231: dup
    //   232: ldc 238
    //   234: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   237: aload_0
    //   238: invokevirtual 241	java/lang/Throwable:toString	()Ljava/lang/String;
    //   241: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload 8
    //   247: ifnull +10 -> 257
    //   250: aload 8
    //   252: invokeinterface 151 1 0
    //   257: iload_3
    //   258: istore_2
    //   259: aload 9
    //   261: ifnull -97 -> 164
    //   264: iload_3
    //   265: istore_2
    //   266: aload 9
    //   268: invokevirtual 154	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   271: ifeq -107 -> 164
    //   274: aload 9
    //   276: invokevirtual 155	android/database/sqlite/SQLiteDatabase:close	()V
    //   279: iload_3
    //   280: istore_2
    //   281: goto -117 -> 164
    //   284: astore_0
    //   285: aload 8
    //   287: ifnull +10 -> 297
    //   290: aload 8
    //   292: invokeinterface 151 1 0
    //   297: aload 9
    //   299: ifnull +16 -> 315
    //   302: aload 9
    //   304: invokevirtual 154	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   307: ifeq +8 -> 315
    //   310: aload 9
    //   312: invokevirtual 155	android/database/sqlite/SQLiteDatabase:close	()V
    //   315: ldc_w 337
    //   318: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   321: aload_0
    //   322: athrow
    //   323: astore_0
    //   324: aconst_null
    //   325: astore 8
    //   327: goto -99 -> 228
    //   330: astore_0
    //   331: goto -103 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	paramContext	Context
    //   81	137	1	i	int
    //   3	278	2	j	int
    //   1	279	3	k	int
    //   70	13	4	m	int
    //   13	175	5	l	long
    //   209	3	7	bool	boolean
    //   61	265	8	localCursor	Cursor
    //   19	292	9	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   15	21	221	finally
    //   228	245	284	finally
    //   52	63	323	finally
    //   63	80	330	finally
    //   89	99	330	finally
    //   99	128	330	finally
    //   202	211	330	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.l
 * JD-Core Version:    0.7.0.1
 */