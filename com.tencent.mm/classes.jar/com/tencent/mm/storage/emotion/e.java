package com.tencent.mm.storage.emotion;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.i.b;
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
  public SharedPreferences VID;
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
  
  public e(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString, String[] paramArrayOfString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, paramArrayOfString);
    AppMethodBeat.i(105050);
    this.db = paramISQLiteDatabase;
    this.VID = PreferenceManager.getDefaultSharedPreferences(MMApplicationContext.getContext());
    AppMethodBeat.o(105050);
  }
  
  private boolean bxH(String paramString)
  {
    bool4 = false;
    boolean bool3 = false;
    AppMethodBeat.i(105054);
    bool2 = bool4;
    String str2;
    if (b.avb(paramString))
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
  
  public final String auh(String paramString)
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
  
  public final boolean bxF(String paramString)
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
  
  public final boolean bxG(String paramString)
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
  
  public final boolean bxI(String paramString)
  {
    AppMethodBeat.i(226253);
    if (b.avb(paramString))
    {
      long l1 = this.VID.getLong("274544".concat(String.valueOf(paramString)), 0L);
      long l2 = System.currentTimeMillis();
      if (l2 - l1 >= 86400000L)
      {
        AppMethodBeat.o(226253);
        return true;
      }
      if ((!bxH(paramString)) && (l2 - l1 >= 3600000L))
      {
        AppMethodBeat.o(226253);
        return true;
      }
    }
    AppMethodBeat.o(226253);
    return false;
  }
  
  /* Error */
  public final java.util.ArrayList<d> bxJ(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 205
    //   4: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 207	java/util/ArrayList
    //   10: dup
    //   11: invokespecial 208	java/util/ArrayList:<init>	()V
    //   14: astore 4
    //   16: new 124	java/lang/StringBuilder
    //   19: dup
    //   20: ldc 210
    //   22: invokespecial 213	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   25: aload_1
    //   26: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 215
    //   31: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: astore_1
    //   38: aload_0
    //   39: getfield 54	com/tencent/mm/storage/emotion/e:db	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
    //   42: aload_1
    //   43: aconst_null
    //   44: iconst_2
    //   45: invokeinterface 96 4 0
    //   50: astore 5
    //   52: aload 5
    //   54: ifnull +46 -> 100
    //   57: aload 5
    //   59: invokeinterface 102 1 0
    //   64: ifeq +36 -> 100
    //   67: new 25	com/tencent/mm/storage/emotion/d
    //   70: dup
    //   71: invokespecial 216	com/tencent/mm/storage/emotion/d:<init>	()V
    //   74: astore_1
    //   75: aload_1
    //   76: aload 5
    //   78: invokevirtual 220	com/tencent/mm/storage/emotion/d:convertFrom	(Landroid/database/Cursor;)V
    //   81: aload 4
    //   83: aload_1
    //   84: invokevirtual 224	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   87: pop
    //   88: aload 5
    //   90: invokeinterface 227 1 0
    //   95: istore_2
    //   96: iload_2
    //   97: ifne -30 -> 67
    //   100: aload 5
    //   102: ifnull +10 -> 112
    //   105: aload 5
    //   107: invokeinterface 105 1 0
    //   112: ldc 205
    //   114: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload 4
    //   119: areturn
    //   120: astore_3
    //   121: ldc 205
    //   123: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_3
    //   127: athrow
    //   128: astore_1
    //   129: aload 5
    //   131: ifnull +14 -> 145
    //   134: aload_3
    //   135: ifnull +44 -> 179
    //   138: aload 5
    //   140: invokeinterface 105 1 0
    //   145: ldc 205
    //   147: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_1
    //   151: athrow
    //   152: astore_1
    //   153: ldc 107
    //   155: aload_1
    //   156: ldc 229
    //   158: iconst_0
    //   159: anewarray 82	java/lang/Object
    //   162: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: goto -53 -> 112
    //   168: astore 5
    //   170: aload_3
    //   171: aload 5
    //   173: invokevirtual 237	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   176: goto -31 -> 145
    //   179: aload 5
    //   181: invokeinterface 105 1 0
    //   186: goto -41 -> 145
    //   189: astore_1
    //   190: goto -61 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	this	e
    //   0	193	1	paramString	String
    //   95	2	2	bool	boolean
    //   1	1	3	localObject	Object
    //   120	51	3	localThrowable1	java.lang.Throwable
    //   14	104	4	localArrayList	java.util.ArrayList
    //   50	89	5	localCursor	Cursor
    //   168	12	5	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   57	67	120	java/lang/Throwable
    //   67	96	120	java/lang/Throwable
    //   121	128	128	finally
    //   38	52	152	java/lang/Exception
    //   105	112	152	java/lang/Exception
    //   138	145	152	java/lang/Exception
    //   145	152	152	java/lang/Exception
    //   170	176	152	java/lang/Exception
    //   179	186	152	java/lang/Exception
    //   138	145	168	java/lang/Throwable
    //   57	67	189	finally
    //   67	96	189	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.e
 * JD-Core Version:    0.7.0.1
 */