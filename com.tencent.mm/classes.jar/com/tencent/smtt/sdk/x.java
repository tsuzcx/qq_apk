package com.tencent.smtt.sdk;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.j;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class x
{
  public static final String a = CookieManager.LOGTAG;
  static File b;
  
  public static File a(Context paramContext)
  {
    if ((b == null) && (paramContext != null)) {
      b = new File(paramContext.getDir("webview", 0), "Cookies");
    }
    if (b == null) {
      b = new File("/data/data/" + paramContext.getPackageName() + File.separator + "app_webview" + File.separator + "Cookies");
    }
    return b;
  }
  
  private static String a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("select * from " + paramString, null);
    int i = paramSQLiteDatabase.getCount();
    int j = paramSQLiteDatabase.getColumnCount();
    paramString = new StringBuilder();
    paramString.append("raws:" + i + ",columns:" + j + "\n");
    if ((i > 0) && (paramSQLiteDatabase.moveToFirst())) {
      label127:
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
            break label127;
          }
          i += 1;
        }
        paramString.append("\n");
      } while (paramSQLiteDatabase.moveToNext());
    } else {
      return paramString.toString();
    }
  }
  
  public static ArrayList<String> a(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject3 = null;
    localObject1 = null;
    if (paramSQLiteDatabase == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      localCursor = paramSQLiteDatabase.rawQuery("select * from sqlite_master where type='table'", null);
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
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Cursor localCursor;
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
        break label190;
      }
      localThrowable.close();
      if ((paramSQLiteDatabase == null) || (!paramSQLiteDatabase.isOpen())) {
        break label205;
      }
      paramSQLiteDatabase.close();
    }
    return localArrayList;
  }
  
  public static void a(Context paramContext, CookieManager.a parama, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = null;
    Cursor localCursor = null;
    if (paramContext == null) {}
    label10:
    String[] arrayOfString;
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      do
      {
        break label10;
        break label10;
        do
        {
          return;
        } while ((parama == CookieManager.a.b) && (TextUtils.isEmpty(paramString)));
        arrayOfString = paramString.split(",");
      } while ((arrayOfString == null) || (arrayOfString.length <= 0));
      localSQLiteDatabase = c(paramContext);
    } while (localSQLiteDatabase == null);
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
                break label648;
              }
              paramString = localCursor;
              localObject = localCursor;
              if (!str.equals(arrayOfString[i])) {
                continue;
              }
              i = 1;
              break label651;
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
      }
      if (localHashMap.isEmpty()) {
        break;
      }
      b(paramContext);
      parama = localHashMap.entrySet().iterator();
      if (parama.hasNext())
      {
        localObject = (Map.Entry)parama.next();
        paramString = (String)((Map.Entry)localObject).getKey();
        localObject = (String)((Map.Entry)localObject).getValue();
        CookieManager.getInstance().setCookie(paramString, (String)localObject, true);
        continue;
        i += 1;
      }
      else
      {
        if (Build.VERSION.SDK_INT >= 21) {
          CookieManager.getInstance().flush();
        }
        for (;;)
        {
          if (!paramBoolean1) {
            break label646;
          }
          a(c(paramContext));
          i = d(paramContext);
          if (i == -1) {
            break;
          }
          CookieManager.getInstance();
          CookieManager.setROMCookieDBVersion(paramContext, i);
          return;
          CookieSyncManager.getInstance().sync();
        }
        label646:
        break label10;
        label648:
        i = 0;
        label651:
        if (i == 0) {}
      }
    }
  }
  
  public static boolean b(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    j.a(a(paramContext), false);
    return true;
  }
  
  public static SQLiteDatabase c(Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramContext == null) {}
    for (;;)
    {
      return localObject1;
      paramContext = a(paramContext);
      if (paramContext == null) {
        continue;
      }
      try
      {
        paramContext = SQLiteDatabase.openDatabase(paramContext.getAbsolutePath(), null, 0);
        localObject1 = paramContext;
        if (paramContext != null) {
          continue;
        }
        TbsLog.i(a, "dbPath is not exist!");
        return paramContext;
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          paramContext = localObject2;
        }
      }
    }
  }
  
  /* Error */
  public static int d(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: iconst_0
    //   3: istore_3
    //   4: invokestatic 280	java/lang/System:currentTimeMillis	()J
    //   7: pop2
    //   8: aload_0
    //   9: invokestatic 150	com/tencent/smtt/sdk/x:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore_0
    //   13: aload_0
    //   14: ifnonnull +22 -> 36
    //   17: aload_0
    //   18: ifnull +14 -> 32
    //   21: aload_0
    //   22: invokevirtual 125	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   25: ifeq +7 -> 32
    //   28: aload_0
    //   29: invokevirtual 126	android/database/sqlite/SQLiteDatabase:close	()V
    //   32: iconst_m1
    //   33: istore_2
    //   34: iload_2
    //   35: ireturn
    //   36: aload_0
    //   37: ldc_w 282
    //   40: aconst_null
    //   41: invokevirtual 72	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   44: astore 7
    //   46: aload 7
    //   48: invokeinterface 78 1 0
    //   53: istore 4
    //   55: aload 7
    //   57: invokeinterface 81 1 0
    //   62: pop
    //   63: iload_2
    //   64: istore_1
    //   65: iload 4
    //   67: ifle +44 -> 111
    //   70: iload_2
    //   71: istore_1
    //   72: aload 7
    //   74: invokeinterface 96 1 0
    //   79: ifeq +32 -> 111
    //   82: aload 7
    //   84: iconst_0
    //   85: invokeinterface 100 2 0
    //   90: ldc_w 284
    //   93: invokevirtual 164	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   96: ifeq +48 -> 144
    //   99: aload 7
    //   101: iconst_1
    //   102: invokeinterface 100 2 0
    //   107: invokestatic 289	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   110: istore_1
    //   111: aload 7
    //   113: ifnull +10 -> 123
    //   116: aload 7
    //   118: invokeinterface 122 1 0
    //   123: iload_1
    //   124: istore_2
    //   125: aload_0
    //   126: ifnull -92 -> 34
    //   129: iload_1
    //   130: istore_2
    //   131: aload_0
    //   132: invokevirtual 125	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   135: ifeq -101 -> 34
    //   138: aload_0
    //   139: invokevirtual 126	android/database/sqlite/SQLiteDatabase:close	()V
    //   142: iload_1
    //   143: ireturn
    //   144: aload 7
    //   146: invokeinterface 105 1 0
    //   151: istore 5
    //   153: iload 5
    //   155: ifne -73 -> 82
    //   158: iload_2
    //   159: istore_1
    //   160: goto -49 -> 111
    //   163: astore_0
    //   164: aconst_null
    //   165: astore 7
    //   167: aconst_null
    //   168: astore_0
    //   169: aload 7
    //   171: ifnull +10 -> 181
    //   174: aload 7
    //   176: invokeinterface 122 1 0
    //   181: iload_3
    //   182: istore_2
    //   183: aload_0
    //   184: ifnull -150 -> 34
    //   187: iload_3
    //   188: istore_2
    //   189: aload_0
    //   190: invokevirtual 125	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   193: ifeq -159 -> 34
    //   196: aload_0
    //   197: invokevirtual 126	android/database/sqlite/SQLiteDatabase:close	()V
    //   200: iconst_0
    //   201: ireturn
    //   202: astore 6
    //   204: aconst_null
    //   205: astore 7
    //   207: aconst_null
    //   208: astore_0
    //   209: aload 7
    //   211: ifnull +10 -> 221
    //   214: aload 7
    //   216: invokeinterface 122 1 0
    //   221: aload_0
    //   222: ifnull +14 -> 236
    //   225: aload_0
    //   226: invokevirtual 125	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   229: ifeq +7 -> 236
    //   232: aload_0
    //   233: invokevirtual 126	android/database/sqlite/SQLiteDatabase:close	()V
    //   236: aload 6
    //   238: athrow
    //   239: astore 6
    //   241: aconst_null
    //   242: astore 7
    //   244: goto -35 -> 209
    //   247: astore 6
    //   249: goto -40 -> 209
    //   252: astore 6
    //   254: aconst_null
    //   255: astore 7
    //   257: goto -88 -> 169
    //   260: astore 6
    //   262: goto -93 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	paramContext	Context
    //   64	96	1	i	int
    //   1	188	2	j	int
    //   3	185	3	k	int
    //   53	13	4	m	int
    //   151	3	5	bool	boolean
    //   202	35	6	localObject1	Object
    //   239	1	6	localObject2	Object
    //   247	1	6	localObject3	Object
    //   252	1	6	localThrowable1	Throwable
    //   260	1	6	localThrowable2	Throwable
    //   44	212	7	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   8	13	163	java/lang/Throwable
    //   8	13	202	finally
    //   36	46	239	finally
    //   46	63	247	finally
    //   72	82	247	finally
    //   82	111	247	finally
    //   144	153	247	finally
    //   36	46	252	java/lang/Throwable
    //   46	63	260	java/lang/Throwable
    //   72	82	260	java/lang/Throwable
    //   82	111	260	java/lang/Throwable
    //   144	153	260	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.smtt.sdk.x
 * JD-Core Version:    0.7.0.1
 */