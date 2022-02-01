package com.tencent.mm.storage.emotion;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class e
  extends MAutoStorage<d>
{
  private static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public SharedPreferences admz;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(105057);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(d.info, "EmojiInfoDesc") };
    INDEX_CREATE = new String[] { "create index if not exists descGroupIdIndex on EmojiInfoDesc ( groupId )" };
    AppMethodBeat.o(105057);
  }
  
  public e(ISQLiteDatabase paramISQLiteDatabase)
  {
    this(paramISQLiteDatabase, d.info, "EmojiInfoDesc", INDEX_CREATE);
  }
  
  private e(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, paramArrayOfString);
    AppMethodBeat.i(105050);
    this.db = paramISQLiteDatabase;
    this.admz = PreferenceManager.getDefaultSharedPreferences(MMApplicationContext.getContext());
    AppMethodBeat.o(105050);
  }
  
  private boolean byX(String paramString)
  {
    bool4 = false;
    boolean bool3 = false;
    AppMethodBeat.i(105054);
    bool2 = bool4;
    String str2;
    if (com.tencent.mm.plugin.emoji.g.d.apb(paramString))
    {
      str2 = String.format("select %s from %s where %s=?", new Object[] { "desc", "EmojiInfoDesc", "groupId" });
      localObject = null;
      str1 = null;
    }
    try
    {
      paramString = this.db.rawQuery(str2, new String[] { paramString }, 2);
      boolean bool1 = bool3;
      if (paramString != null)
      {
        str1 = paramString;
        localObject = paramString;
        bool2 = paramString.moveToFirst();
        bool1 = bool3;
        if (bool2) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (paramString != null)
      {
        paramString.close();
        bool2 = bool1;
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        localObject = str1;
        Log.w("MicroMsg.emoji.EmojiInfoDescStorage", paramString.toString());
        bool2 = bool4;
        if (str1 != null)
        {
          str1.close();
          bool2 = bool4;
        }
      }
    }
    finally
    {
      if (localObject == null) {
        break label172;
      }
      ((Cursor)localObject).close();
      AppMethodBeat.o(105054);
    }
    AppMethodBeat.o(105054);
    return bool2;
  }
  
  public final String aoi(String paramString)
  {
    AppMethodBeat.i(105051);
    String str1 = null;
    String str2 = String.format("select %s from %s where %s=?", new Object[] { "desc", "EmojiInfoDesc", "md5_lang" });
    Object localObject = paramString + LocaleUtil.getApplicationLanguage().toLowerCase();
    localObject = this.db.rawQuery(str2, new String[] { localObject }, 2);
    if (((Cursor)localObject).moveToFirst()) {
      str1 = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("desc"));
    }
    ((Cursor)localObject).close();
    if (!Util.isNullOrNil(str1))
    {
      AppMethodBeat.o(105051);
      return str1;
    }
    paramString = paramString + "default";
    paramString = this.db.rawQuery(str2, new String[] { paramString }, 2);
    if (paramString.moveToFirst()) {
      str1 = paramString.getString(paramString.getColumnIndex("desc"));
    }
    paramString.close();
    AppMethodBeat.o(105051);
    return str1;
  }
  
  public final boolean byV(String paramString)
  {
    bool2 = true;
    bool3 = false;
    boolean bool4 = false;
    AppMethodBeat.i(105052);
    String str2 = String.format("select %s from %s where %s=?", new Object[] { "click_flag", "EmojiInfoDesc", "groupId" });
    localObject = null;
    str1 = null;
    for (;;)
    {
      try
      {
        paramString = this.db.rawQuery(str2, new String[] { paramString }, 2);
        bool1 = bool4;
        if (paramString != null)
        {
          bool1 = bool4;
          str1 = paramString;
          localObject = paramString;
          if (paramString.moveToFirst())
          {
            str1 = paramString;
            localObject = paramString;
            int i = paramString.getInt(paramString.getColumnIndex("click_flag"));
            if ((i & 0x1) != 1) {
              continue;
            }
            bool1 = bool2;
          }
        }
        bool2 = bool1;
        if (paramString != null)
        {
          paramString.close();
          bool2 = bool1;
        }
      }
      catch (Exception paramString)
      {
        boolean bool1;
        localObject = str1;
        Log.w("MicroMsg.emoji.EmojiInfoDescStorage", "[isPurChase] Exception:%s", new Object[] { paramString.toString() });
        bool2 = bool3;
        if (str1 == null) {
          continue;
        }
        str1.close();
        bool2 = bool3;
        continue;
      }
      finally
      {
        if (localObject == null) {
          continue;
        }
        ((Cursor)localObject).close();
        AppMethodBeat.o(105052);
      }
      AppMethodBeat.o(105052);
      return bool2;
      bool1 = false;
    }
  }
  
  public final boolean byW(String paramString)
  {
    bool2 = true;
    bool3 = false;
    boolean bool4 = false;
    AppMethodBeat.i(105053);
    String str2 = String.format("select %s from %s where %s=?", new Object[] { "download_flag", "EmojiInfoDesc", "groupId" });
    localObject = null;
    str1 = null;
    for (;;)
    {
      try
      {
        paramString = this.db.rawQuery(str2, new String[] { paramString }, 2);
        bool1 = bool4;
        if (paramString != null)
        {
          bool1 = bool4;
          str1 = paramString;
          localObject = paramString;
          if (paramString.moveToFirst())
          {
            str1 = paramString;
            localObject = paramString;
            int i = paramString.getInt(paramString.getColumnIndex("download_flag"));
            if ((i & 0x1) != 1) {
              continue;
            }
            bool1 = bool2;
          }
        }
        bool2 = bool1;
        if (paramString != null)
        {
          paramString.close();
          bool2 = bool1;
        }
      }
      catch (Exception paramString)
      {
        boolean bool1;
        localObject = str1;
        Log.w("MicroMsg.emoji.EmojiInfoDescStorage", "[isPurChase] Exception:%s", new Object[] { paramString.toString() });
        bool2 = bool3;
        if (str1 == null) {
          continue;
        }
        str1.close();
        bool2 = bool3;
        continue;
      }
      finally
      {
        if (localObject == null) {
          continue;
        }
        ((Cursor)localObject).close();
        AppMethodBeat.o(105053);
      }
      AppMethodBeat.o(105053);
      return bool2;
      bool1 = false;
    }
  }
  
  public final boolean byY(String paramString)
  {
    AppMethodBeat.i(249002);
    if (com.tencent.mm.plugin.emoji.g.d.apb(paramString))
    {
      long l1 = this.admz.getLong("274544".concat(String.valueOf(paramString)), 0L);
      long l2 = System.currentTimeMillis();
      if (l2 - l1 >= 86400000L)
      {
        AppMethodBeat.o(249002);
        return true;
      }
      if ((!byX(paramString)) && (l2 - l1 >= 3600000L))
      {
        AppMethodBeat.o(249002);
        return true;
      }
    }
    AppMethodBeat.o(249002);
    return false;
  }
  
  /* Error */
  public final java.util.ArrayList<d> byZ(String paramString)
  {
    // Byte code:
    //   0: ldc 203
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 205	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 206	java/util/ArrayList:<init>	()V
    //   12: astore_3
    //   13: new 124	java/lang/StringBuilder
    //   16: dup
    //   17: ldc 208
    //   19: invokespecial 211	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: aload_1
    //   23: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 213
    //   28: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore_1
    //   35: aload_0
    //   36: getfield 54	com/tencent/mm/storage/emotion/e:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   39: aload_1
    //   40: aconst_null
    //   41: iconst_2
    //   42: invokeinterface 96 4 0
    //   47: astore_1
    //   48: aload_1
    //   49: ifnull +45 -> 94
    //   52: aload_1
    //   53: invokeinterface 102 1 0
    //   58: ifeq +36 -> 94
    //   61: new 25	com/tencent/mm/storage/emotion/d
    //   64: dup
    //   65: invokespecial 214	com/tencent/mm/storage/emotion/d:<init>	()V
    //   68: astore 4
    //   70: aload 4
    //   72: aload_1
    //   73: invokevirtual 218	com/tencent/mm/storage/emotion/d:convertFrom	(Landroid/database/Cursor;)V
    //   76: aload_3
    //   77: aload 4
    //   79: invokevirtual 222	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   82: pop
    //   83: aload_1
    //   84: invokeinterface 225 1 0
    //   89: istore_2
    //   90: iload_2
    //   91: ifne -30 -> 61
    //   94: aload_1
    //   95: ifnull +9 -> 104
    //   98: aload_1
    //   99: invokeinterface 105 1 0
    //   104: ldc 203
    //   106: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_3
    //   110: areturn
    //   111: astore 4
    //   113: aload_1
    //   114: ifnull +9 -> 123
    //   117: aload_1
    //   118: invokeinterface 105 1 0
    //   123: ldc 203
    //   125: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: aload 4
    //   130: athrow
    //   131: astore_1
    //   132: ldc 107
    //   134: aload_1
    //   135: ldc 227
    //   137: iconst_0
    //   138: anewarray 82	java/lang/Object
    //   141: invokestatic 231	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: goto -40 -> 104
    //   147: astore_1
    //   148: aload 4
    //   150: aload_1
    //   151: invokevirtual 237	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   154: goto -31 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	e
    //   0	157	1	paramString	String
    //   89	2	2	bool	boolean
    //   12	98	3	localArrayList	java.util.ArrayList
    //   68	10	4	locald	d
    //   111	38	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   52	61	111	finally
    //   61	90	111	finally
    //   35	48	131	java/lang/Exception
    //   98	104	131	java/lang/Exception
    //   123	131	131	java/lang/Exception
    //   148	154	131	java/lang/Exception
    //   117	123	147	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.e
 * JD-Core Version:    0.7.0.1
 */