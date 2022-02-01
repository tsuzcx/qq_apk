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
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class l
{
  public static final String a = CookieManager.LOGTAG;
  static File b;
  
  public static File a(Context paramContext)
  {
    AppMethodBeat.i(192925);
    if ((b == null) && (paramContext != null)) {
      b = new File(paramContext.getDir("webview", 0), "Cookies");
    }
    if (b == null) {
      b = new File("/data/data/" + paramContext.getPackageName() + File.separator + "app_webview" + File.separator + "Cookies");
    }
    paramContext = b;
    AppMethodBeat.o(192925);
    return paramContext;
  }
  
  private static String a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    AppMethodBeat.i(192929);
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
      AppMethodBeat.o(192929);
      return paramSQLiteDatabase;
    }
  }
  
  public static ArrayList<String> a(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject3 = null;
    localObject1 = null;
    AppMethodBeat.i(192928);
    if (paramSQLiteDatabase == null)
    {
      AppMethodBeat.o(192928);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("select * from sqlite_master where type='table'", null);
      localObject1 = localCursor;
      localObject3 = localCursor;
      new StringBuilder("db version:").append(paramSQLiteDatabase.getVersion());
      localObject1 = localCursor;
      localObject3 = localCursor;
      if (localCursor.moveToFirst())
      {
        boolean bool;
        do
        {
          localObject1 = localCursor;
          localObject3 = localCursor;
          String str1 = localCursor.getString(1);
          localObject1 = localCursor;
          localObject3 = localCursor;
          String str2 = localCursor.getString(4);
          localObject1 = localCursor;
          localObject3 = localCursor;
          localArrayList.add(str1);
          localObject1 = localCursor;
          localObject3 = localCursor;
          new StringBuilder("tablename:").append(str1).append("->").append(str2);
          localObject1 = localCursor;
          localObject3 = localCursor;
          a(paramSQLiteDatabase, str1);
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
        break label260;
      }
      localThrowable.close();
      if ((paramSQLiteDatabase == null) || (!paramSQLiteDatabase.isOpen())) {
        break label275;
      }
      paramSQLiteDatabase.close();
      AppMethodBeat.o(192928);
    }
    AppMethodBeat.o(192928);
    return localArrayList;
  }
  
  public static void a(Context paramContext, CookieManager.a parama, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192931);
    if (paramContext == null)
    {
      AppMethodBeat.o(192931);
      return;
    }
    new StringBuilder("transformCookies:").append(paramString).append(", mode:").append(parama.ordinal());
    long l = System.currentTimeMillis();
    if ((parama == CookieManager.a.b) && (TextUtils.isEmpty(paramString)))
    {
      AppMethodBeat.o(192931);
      return;
    }
    String[] arrayOfString = paramString.split(",");
    if ((arrayOfString == null) || (arrayOfString.length <= 0))
    {
      AppMethodBeat.o(192931);
      return;
    }
    SQLiteDatabase localSQLiteDatabase = c(paramContext);
    if (localSQLiteDatabase == null)
    {
      AppMethodBeat.o(192931);
      return;
    }
    Object localObject1 = null;
    paramString = null;
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      int i;
      int j;
      try
      {
        Cursor localCursor = localSQLiteDatabase.rawQuery("select * from cookies", null);
        paramString = localCursor;
        localObject1 = localCursor;
        int m = localCursor.getCount();
        if (m > 0)
        {
          paramString = localCursor;
          localObject1 = localCursor;
          if (localCursor.moveToFirst())
          {
            paramString = localCursor;
            localObject1 = localCursor;
            String str = localCursor.getString(localCursor.getColumnIndex("host_key"));
            paramString = localCursor;
            localObject1 = localCursor;
            if (parama == CookieManager.a.b)
            {
              int k = 0;
              paramString = localCursor;
              localObject1 = localCursor;
              int n = arrayOfString.length;
              i = 0;
              j = k;
              if (i >= n) {
                break label849;
              }
              paramString = localCursor;
              localObject1 = localCursor;
              if (!str.equals(arrayOfString[i])) {
                continue;
              }
              j = 1;
              break label849;
            }
            paramString = localCursor;
            localObject1 = localCursor;
            Object localObject2 = new StringBuilder();
            paramString = localCursor;
            localObject1 = localCursor;
            ((StringBuilder)localObject2).append(localCursor.getString(localCursor.getColumnIndex("value")));
            paramString = localCursor;
            localObject1 = localCursor;
            ((StringBuilder)localObject2).append(";").append(localCursor.getString(localCursor.getColumnIndex("name")));
            paramString = localCursor;
            localObject1 = localCursor;
            ((StringBuilder)localObject2).append(";").append(localCursor.getInt(localCursor.getColumnIndex("expires_utc")));
            paramString = localCursor;
            localObject1 = localCursor;
            ((StringBuilder)localObject2).append(";").append(localCursor.getInt(localCursor.getColumnIndex("priority")));
            paramString = localCursor;
            localObject1 = localCursor;
            localObject2 = ((StringBuilder)localObject2).toString();
            paramString = localCursor;
            localObject1 = localCursor;
            localHashMap.put(str, localObject2);
            paramString = localCursor;
            localObject1 = localCursor;
            new StringBuilder("key : value -> ").append(str).append(":").append((String)localObject2);
            paramString = localCursor;
            localObject1 = localCursor;
            if (localCursor.moveToNext()) {
              continue;
            }
          }
        }
        paramString = localCursor;
        localObject1 = localCursor;
        new StringBuilder("transformCookies,nums - > num : ").append(m).append(",count:").append(localHashMap.size());
        if (localCursor != null) {
          localCursor.close();
        }
        if ((localSQLiteDatabase != null) && (localSQLiteDatabase.isOpen())) {
          localSQLiteDatabase.close();
        }
      }
      catch (Throwable parama)
      {
        localObject1 = paramString;
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
        if (localObject1 == null) {
          continue;
        }
        ((Cursor)localObject1).close();
        if ((localSQLiteDatabase == null) || (!localSQLiteDatabase.isOpen())) {
          continue;
        }
        localSQLiteDatabase.close();
        AppMethodBeat.o(192931);
      }
      if (localHashMap.isEmpty())
      {
        AppMethodBeat.o(192931);
        return;
        i += 1;
      }
      else
      {
        b(paramContext);
        parama = localHashMap.entrySet().iterator();
        while (parama.hasNext())
        {
          localObject1 = (Map.Entry)parama.next();
          paramString = (String)((Map.Entry)localObject1).getKey();
          localObject1 = (String)((Map.Entry)localObject1).getValue();
          new StringBuilder("set cookie:").append(paramString).append(",").append((String)localObject1);
          CookieManager.getInstance().setCookie(paramString, (String)localObject1, true);
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
          new StringBuilder("transformCookies,timeused:").append(System.currentTimeMillis() - l);
          AppMethodBeat.o(192931);
          return;
          CookieSyncManager.getInstance().sync();
        }
        label849:
        if (j == 0) {}
      }
    }
  }
  
  public static boolean b(Context paramContext)
  {
    AppMethodBeat.i(192926);
    if (paramContext == null)
    {
      AppMethodBeat.o(192926);
      return false;
    }
    f.a(a(paramContext), false);
    AppMethodBeat.o(192926);
    return true;
  }
  
  public static SQLiteDatabase c(Context paramContext)
  {
    Object localObject = null;
    AppMethodBeat.i(192927);
    if (paramContext == null)
    {
      AppMethodBeat.o(192927);
      return null;
    }
    paramContext = a(paramContext);
    if (paramContext == null)
    {
      AppMethodBeat.o(192927);
      return null;
    }
    try
    {
      paramContext = SQLiteDatabase.openDatabase(paramContext.getAbsolutePath(), null, 0);
      if (paramContext == null) {
        TbsLog.i(a, "dbPath is not exist!");
      }
      AppMethodBeat.o(192927);
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
    //   10: invokestatic 176	java/lang/System:currentTimeMillis	()J
    //   13: lstore 5
    //   15: aload_0
    //   16: invokestatic 193	com/tencent/smtt/sdk/l:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   19: astore_0
    //   20: aload_0
    //   21: ifnonnull +26 -> 47
    //   24: aload_0
    //   25: ifnull +14 -> 39
    //   28: aload_0
    //   29: invokevirtual 156	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   32: ifeq +7 -> 39
    //   35: aload_0
    //   36: invokevirtual 157	android/database/sqlite/SQLiteDatabase:close	()V
    //   39: ldc_w 337
    //   42: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: iconst_m1
    //   46: ireturn
    //   47: aload_0
    //   48: ldc_w 339
    //   51: aconst_null
    //   52: invokevirtual 93	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   55: astore 8
    //   57: aload 8
    //   59: astore 10
    //   61: aload_0
    //   62: astore 9
    //   64: aload 8
    //   66: invokeinterface 99 1 0
    //   71: istore 4
    //   73: aload 8
    //   75: astore 10
    //   77: aload_0
    //   78: astore 9
    //   80: aload 8
    //   82: invokeinterface 102 1 0
    //   87: pop
    //   88: iload_2
    //   89: istore_1
    //   90: iload 4
    //   92: ifle +65 -> 157
    //   95: iload_2
    //   96: istore_1
    //   97: aload 8
    //   99: astore 10
    //   101: aload_0
    //   102: astore 9
    //   104: aload 8
    //   106: invokeinterface 117 1 0
    //   111: ifeq +46 -> 157
    //   114: aload 8
    //   116: astore 10
    //   118: aload_0
    //   119: astore 9
    //   121: aload 8
    //   123: iconst_0
    //   124: invokeinterface 121 2 0
    //   129: ldc_w 341
    //   132: invokevirtual 207	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   135: ifeq +93 -> 228
    //   138: aload 8
    //   140: astore 10
    //   142: aload_0
    //   143: astore 9
    //   145: aload 8
    //   147: iconst_1
    //   148: invokeinterface 121 2 0
    //   153: invokestatic 346	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   156: istore_1
    //   157: aload 8
    //   159: ifnull +10 -> 169
    //   162: aload 8
    //   164: invokeinterface 153 1 0
    //   169: iload_1
    //   170: istore_2
    //   171: aload_0
    //   172: ifnull +18 -> 190
    //   175: iload_1
    //   176: istore_2
    //   177: aload_0
    //   178: invokevirtual 156	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   181: ifeq +9 -> 190
    //   184: aload_0
    //   185: invokevirtual 157	android/database/sqlite/SQLiteDatabase:close	()V
    //   188: iload_1
    //   189: istore_2
    //   190: new 46	java/lang/StringBuilder
    //   193: dup
    //   194: ldc_w 348
    //   197: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   200: iload_2
    //   201: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   204: ldc_w 350
    //   207: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokestatic 176	java/lang/System:currentTimeMillis	()J
    //   213: lload 5
    //   215: lsub
    //   216: invokevirtual 305	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: ldc_w 337
    //   223: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: iload_2
    //   227: ireturn
    //   228: aload 8
    //   230: astore 10
    //   232: aload_0
    //   233: astore 9
    //   235: aload 8
    //   237: invokeinterface 126 1 0
    //   242: istore 7
    //   244: iload 7
    //   246: ifne -132 -> 114
    //   249: iload_2
    //   250: istore_1
    //   251: goto -94 -> 157
    //   254: astore 11
    //   256: aconst_null
    //   257: astore 8
    //   259: aconst_null
    //   260: astore_0
    //   261: aload 8
    //   263: astore 10
    //   265: aload_0
    //   266: astore 9
    //   268: new 46	java/lang/StringBuilder
    //   271: dup
    //   272: ldc 240
    //   274: invokespecial 51	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   277: aload 11
    //   279: invokevirtual 241	java/lang/Throwable:toString	()Ljava/lang/String;
    //   282: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload 8
    //   288: ifnull +10 -> 298
    //   291: aload 8
    //   293: invokeinterface 153 1 0
    //   298: iload_3
    //   299: istore_2
    //   300: aload_0
    //   301: ifnull -111 -> 190
    //   304: iload_3
    //   305: istore_2
    //   306: aload_0
    //   307: invokevirtual 156	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   310: ifeq -120 -> 190
    //   313: aload_0
    //   314: invokevirtual 157	android/database/sqlite/SQLiteDatabase:close	()V
    //   317: iload_3
    //   318: istore_2
    //   319: goto -129 -> 190
    //   322: astore 8
    //   324: aconst_null
    //   325: astore 10
    //   327: aconst_null
    //   328: astore_0
    //   329: aload 10
    //   331: ifnull +10 -> 341
    //   334: aload 10
    //   336: invokeinterface 153 1 0
    //   341: aload_0
    //   342: ifnull +14 -> 356
    //   345: aload_0
    //   346: invokevirtual 156	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   349: ifeq +7 -> 356
    //   352: aload_0
    //   353: invokevirtual 157	android/database/sqlite/SQLiteDatabase:close	()V
    //   356: ldc_w 337
    //   359: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   362: aload 8
    //   364: athrow
    //   365: astore 8
    //   367: aconst_null
    //   368: astore 10
    //   370: goto -41 -> 329
    //   373: astore 8
    //   375: aload 9
    //   377: astore_0
    //   378: goto -49 -> 329
    //   381: astore 11
    //   383: aconst_null
    //   384: astore 8
    //   386: goto -125 -> 261
    //   389: astore 11
    //   391: goto -130 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	paramContext	Context
    //   89	162	1	i	int
    //   3	316	2	j	int
    //   1	317	3	k	int
    //   71	20	4	m	int
    //   13	201	5	l	long
    //   242	3	7	bool	boolean
    //   55	237	8	localCursor1	Cursor
    //   322	41	8	localObject1	Object
    //   365	1	8	localObject2	Object
    //   373	1	8	localObject3	Object
    //   384	1	8	localObject4	Object
    //   62	314	9	localContext	Context
    //   59	310	10	localCursor2	Cursor
    //   254	24	11	localThrowable1	Throwable
    //   381	1	11	localThrowable2	Throwable
    //   389	1	11	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   15	20	254	java/lang/Throwable
    //   15	20	322	finally
    //   47	57	365	finally
    //   64	73	373	finally
    //   80	88	373	finally
    //   104	114	373	finally
    //   121	138	373	finally
    //   145	157	373	finally
    //   235	244	373	finally
    //   268	286	373	finally
    //   47	57	381	java/lang/Throwable
    //   64	73	389	java/lang/Throwable
    //   80	88	389	java/lang/Throwable
    //   104	114	389	java/lang/Throwable
    //   121	138	389	java/lang/Throwable
    //   145	157	389	java/lang/Throwable
    //   235	244	389	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.l
 * JD-Core Version:    0.7.0.1
 */