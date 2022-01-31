package com.tencent.smtt.sdk;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class y
{
  public static final String a = CookieManager.LOGTAG;
  static File b;
  
  public static File a(Context paramContext)
  {
    AppMethodBeat.i(139119);
    if ((b == null) && (paramContext != null)) {
      b = new File(paramContext.getDir("webview", 0), "Cookies");
    }
    if (b == null) {
      b = new File("/data/data/" + paramContext.getPackageName() + File.separator + "app_webview" + File.separator + "Cookies");
    }
    paramContext = b;
    AppMethodBeat.o(139119);
    return paramContext;
  }
  
  private static String a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    AppMethodBeat.i(139123);
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
      AppMethodBeat.o(139123);
      return paramSQLiteDatabase;
    }
  }
  
  public static ArrayList<String> a(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject3 = null;
    localObject1 = null;
    AppMethodBeat.i(139122);
    if (paramSQLiteDatabase == null)
    {
      AppMethodBeat.o(139122);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("select * from sqlite_master where type='table'", null);
      localObject1 = localCursor;
      localObject3 = localCursor;
      if (localCursor.moveToFirst())
      {
        boolean bool;
        do
        {
          localObject1 = localCursor;
          localObject3 = localCursor;
          String str = localCursor.getString(1);
          localObject1 = localCursor;
          localObject3 = localCursor;
          localCursor.getString(4);
          localObject1 = localCursor;
          localObject3 = localCursor;
          localArrayList.add(str);
          localObject1 = localCursor;
          localObject3 = localCursor;
          a(paramSQLiteDatabase, str);
          localObject1 = localCursor;
          localObject3 = localCursor;
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
    catch (Throwable localThrowable)
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
    finally
    {
      if (localThrowable == null) {
        break label205;
      }
      localThrowable.close();
      if ((paramSQLiteDatabase == null) || (!paramSQLiteDatabase.isOpen())) {
        break label220;
      }
      paramSQLiteDatabase.close();
      AppMethodBeat.o(139122);
    }
    AppMethodBeat.o(139122);
    return localArrayList;
  }
  
  public static void a(Context paramContext, CookieManager.a parama, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = null;
    Cursor localCursor = null;
    AppMethodBeat.i(139125);
    if (paramContext == null)
    {
      AppMethodBeat.o(139125);
      return;
    }
    if ((parama == CookieManager.a.b) && (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(139125);
      return;
    }
    String[] arrayOfString = paramString.split(",");
    if ((arrayOfString == null) || (arrayOfString.length <= 0))
    {
      AppMethodBeat.o(139125);
      return;
    }
    SQLiteDatabase localSQLiteDatabase = c(paramContext);
    if (localSQLiteDatabase == null)
    {
      AppMethodBeat.o(139125);
      return;
    }
    HashMap localHashMap = new HashMap();
    paramString = localCursor;
    for (;;)
    {
      int i;
      try
      {
        localCursor = localSQLiteDatabase.rawQuery("select * from cookies", null);
        paramString = localCursor;
        localObject = localCursor;
        if (localCursor.getCount() > 0)
        {
          paramString = localCursor;
          localObject = localCursor;
          if (localCursor.moveToFirst())
          {
            paramString = localCursor;
            localObject = localCursor;
            String str = localCursor.getString(localCursor.getColumnIndex("host_key"));
            paramString = localCursor;
            localObject = localCursor;
            if (parama == CookieManager.a.b)
            {
              paramString = localCursor;
              localObject = localCursor;
              int j = arrayOfString.length;
              i = 0;
              if (i >= j) {
                break label692;
              }
              paramString = localCursor;
              localObject = localCursor;
              if (!str.equals(arrayOfString[i])) {
                continue;
              }
              i = 1;
              break label695;
            }
            paramString = localCursor;
            localObject = localCursor;
            StringBuilder localStringBuilder = new StringBuilder();
            paramString = localCursor;
            localObject = localCursor;
            localStringBuilder.append(localCursor.getString(localCursor.getColumnIndex("value")));
            paramString = localCursor;
            localObject = localCursor;
            localStringBuilder.append(";").append(localCursor.getString(localCursor.getColumnIndex("name")));
            paramString = localCursor;
            localObject = localCursor;
            localStringBuilder.append(";").append(localCursor.getInt(localCursor.getColumnIndex("expires_utc")));
            paramString = localCursor;
            localObject = localCursor;
            localStringBuilder.append(";").append(localCursor.getInt(localCursor.getColumnIndex("priority")));
            paramString = localCursor;
            localObject = localCursor;
            localHashMap.put(str, localStringBuilder.toString());
            paramString = localCursor;
            localObject = localCursor;
            paramBoolean2 = localCursor.moveToNext();
            if (paramBoolean2) {
              continue;
            }
          }
        }
        if (localCursor != null) {
          localCursor.close();
        }
        if ((localSQLiteDatabase != null) && (localSQLiteDatabase.isOpen())) {
          localSQLiteDatabase.close();
        }
      }
      catch (Throwable parama)
      {
        localObject = paramString;
        new StringBuilder("getCookieDBVersion exception:").append(parama.toString());
        if (paramString == null) {
          continue;
        }
        paramString.close();
        if ((localSQLiteDatabase == null) || (!localSQLiteDatabase.isOpen())) {
          continue;
        }
        localSQLiteDatabase.close();
        continue;
      }
      finally
      {
        if (localObject == null) {
          continue;
        }
        ((Cursor)localObject).close();
        if ((localSQLiteDatabase == null) || (!localSQLiteDatabase.isOpen())) {
          continue;
        }
        localSQLiteDatabase.close();
        AppMethodBeat.o(139125);
      }
      if (localHashMap.isEmpty())
      {
        AppMethodBeat.o(139125);
        return;
        i += 1;
      }
      else
      {
        b(paramContext);
        parama = localHashMap.entrySet().iterator();
        while (parama.hasNext())
        {
          localObject = (Map.Entry)parama.next();
          paramString = (String)((Map.Entry)localObject).getKey();
          localObject = (String)((Map.Entry)localObject).getValue();
          CookieManager.getInstance().setCookie(paramString, (String)localObject, true);
        }
        if (Build.VERSION.SDK_INT >= 21) {
          CookieManager.getInstance().flush();
        }
        for (;;)
        {
          if (paramBoolean1)
          {
            a(c(paramContext));
            i = d(paramContext);
            if (i != -1)
            {
              CookieManager.getInstance();
              CookieManager.setROMCookieDBVersion(paramContext, i);
            }
          }
          AppMethodBeat.o(139125);
          return;
          CookieSyncManager.getInstance().sync();
        }
        label692:
        i = 0;
        label695:
        if (i == 0) {}
      }
    }
  }
  
  public static boolean b(Context paramContext)
  {
    AppMethodBeat.i(139120);
    if (paramContext == null)
    {
      AppMethodBeat.o(139120);
      return false;
    }
    k.a(a(paramContext), false);
    AppMethodBeat.o(139120);
    return true;
  }
  
  public static SQLiteDatabase c(Context paramContext)
  {
    Object localObject = null;
    AppMethodBeat.i(139121);
    if (paramContext == null)
    {
      AppMethodBeat.o(139121);
      return null;
    }
    paramContext = a(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(139121);
      return null;
    }
    try
    {
      paramContext = SQLiteDatabase.openDatabase(paramContext.getAbsolutePath(), null, 0);
      if (paramContext == null) {
        TbsLog.i(a, "dbPath is not exist!");
      }
      AppMethodBeat.o(139121);
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
    //   4: ldc_w 297
    //   7: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: invokestatic 303	java/lang/System:currentTimeMillis	()J
    //   13: pop2
    //   14: aload_0
    //   15: invokestatic 171	com/tencent/smtt/sdk/y:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   18: astore_0
    //   19: aload_0
    //   20: ifnonnull +26 -> 46
    //   23: aload_0
    //   24: ifnull +14 -> 38
    //   27: aload_0
    //   28: invokevirtual 147	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   31: ifeq +7 -> 38
    //   34: aload_0
    //   35: invokevirtual 148	android/database/sqlite/SQLiteDatabase:close	()V
    //   38: ldc_w 297
    //   41: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: iconst_m1
    //   45: ireturn
    //   46: aload_0
    //   47: ldc_w 305
    //   50: aconst_null
    //   51: invokevirtual 93	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   54: astore 7
    //   56: aload 7
    //   58: invokeinterface 99 1 0
    //   63: istore 4
    //   65: aload 7
    //   67: invokeinterface 102 1 0
    //   72: pop
    //   73: iload_2
    //   74: istore_1
    //   75: iload 4
    //   77: ifle +44 -> 121
    //   80: iload_2
    //   81: istore_1
    //   82: aload 7
    //   84: invokeinterface 117 1 0
    //   89: ifeq +32 -> 121
    //   92: aload 7
    //   94: iconst_0
    //   95: invokeinterface 121 2 0
    //   100: ldc_w 307
    //   103: invokevirtual 185	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   106: ifeq +56 -> 162
    //   109: aload 7
    //   111: iconst_1
    //   112: invokeinterface 121 2 0
    //   117: invokestatic 312	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   120: istore_1
    //   121: aload 7
    //   123: ifnull +10 -> 133
    //   126: aload 7
    //   128: invokeinterface 144 1 0
    //   133: iload_1
    //   134: istore_2
    //   135: aload_0
    //   136: ifnull +18 -> 154
    //   139: iload_1
    //   140: istore_2
    //   141: aload_0
    //   142: invokevirtual 147	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   145: ifeq +9 -> 154
    //   148: aload_0
    //   149: invokevirtual 148	android/database/sqlite/SQLiteDatabase:close	()V
    //   152: iload_1
    //   153: istore_2
    //   154: ldc_w 297
    //   157: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: iload_2
    //   161: ireturn
    //   162: aload 7
    //   164: invokeinterface 126 1 0
    //   169: istore 5
    //   171: iload 5
    //   173: ifne -81 -> 92
    //   176: iload_2
    //   177: istore_1
    //   178: goto -57 -> 121
    //   181: astore_0
    //   182: aconst_null
    //   183: astore 7
    //   185: aconst_null
    //   186: astore_0
    //   187: aload 7
    //   189: ifnull +10 -> 199
    //   192: aload 7
    //   194: invokeinterface 144 1 0
    //   199: iload_3
    //   200: istore_2
    //   201: aload_0
    //   202: ifnull -48 -> 154
    //   205: iload_3
    //   206: istore_2
    //   207: aload_0
    //   208: invokevirtual 147	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   211: ifeq -57 -> 154
    //   214: aload_0
    //   215: invokevirtual 148	android/database/sqlite/SQLiteDatabase:close	()V
    //   218: iload_3
    //   219: istore_2
    //   220: goto -66 -> 154
    //   223: astore 6
    //   225: aconst_null
    //   226: astore 7
    //   228: aconst_null
    //   229: astore_0
    //   230: aload 7
    //   232: ifnull +10 -> 242
    //   235: aload 7
    //   237: invokeinterface 144 1 0
    //   242: aload_0
    //   243: ifnull +14 -> 257
    //   246: aload_0
    //   247: invokevirtual 147	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   250: ifeq +7 -> 257
    //   253: aload_0
    //   254: invokevirtual 148	android/database/sqlite/SQLiteDatabase:close	()V
    //   257: ldc_w 297
    //   260: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: aload 6
    //   265: athrow
    //   266: astore 6
    //   268: aconst_null
    //   269: astore 7
    //   271: goto -41 -> 230
    //   274: astore 6
    //   276: goto -46 -> 230
    //   279: astore 6
    //   281: aconst_null
    //   282: astore 7
    //   284: goto -97 -> 187
    //   287: astore 6
    //   289: goto -102 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	paramContext	Context
    //   74	104	1	i	int
    //   3	217	2	j	int
    //   1	218	3	k	int
    //   63	13	4	m	int
    //   169	3	5	bool	boolean
    //   223	41	6	localObject1	Object
    //   266	1	6	localObject2	Object
    //   274	1	6	localObject3	Object
    //   279	1	6	localThrowable1	Throwable
    //   287	1	6	localThrowable2	Throwable
    //   54	229	7	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   14	19	181	java/lang/Throwable
    //   14	19	223	finally
    //   46	56	266	finally
    //   56	73	274	finally
    //   82	92	274	finally
    //   92	121	274	finally
    //   162	171	274	finally
    //   46	56	279	java/lang/Throwable
    //   56	73	287	java/lang/Throwable
    //   82	92	287	java/lang/Throwable
    //   92	121	287	java/lang/Throwable
    //   162	171	287	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.y
 * JD-Core Version:    0.7.0.1
 */