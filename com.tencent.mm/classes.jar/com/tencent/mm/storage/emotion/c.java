package com.tencent.mm.storage.emotion;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.g;
import com.tencent.mm.cg.g.a;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
  extends j<b>
  implements g.a
{
  public static final String[] SQL_CREATE;
  public e db;
  public SharedPreferences yPW;
  
  static
  {
    AppMethodBeat.i(62800);
    SQL_CREATE = new String[] { j.getCreateSQLs(b.info, "EmojiInfoDesc") };
    AppMethodBeat.o(62800);
  }
  
  public c(e parame)
  {
    this(parame, b.info, "EmojiInfoDesc");
  }
  
  private c(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
    AppMethodBeat.i(62794);
    this.db = parame;
    this.yPW = PreferenceManager.getDefaultSharedPreferences(ah.getContext());
    AppMethodBeat.o(62794);
  }
  
  public final String Kx(String paramString)
  {
    AppMethodBeat.i(62795);
    String str1 = null;
    String str2 = String.format("select %s from %s where %s=?", new Object[] { "desc", "EmojiInfoDesc", "md5_lang" });
    Object localObject = paramString + aa.dsG().toLowerCase();
    localObject = this.db.a(str2, new String[] { localObject }, 2);
    if (((Cursor)localObject).moveToFirst()) {
      str1 = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("desc"));
    }
    ((Cursor)localObject).close();
    if (!bo.isNullOrNil(str1))
    {
      AppMethodBeat.o(62795);
      return str1;
    }
    paramString = paramString + "default";
    paramString = this.db.a(str2, new String[] { paramString }, 2);
    if (paramString.moveToFirst()) {
      str1 = paramString.getString(paramString.getColumnIndex("desc"));
    }
    paramString.close();
    AppMethodBeat.o(62795);
    return str1;
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final boolean asM(String paramString)
  {
    bool2 = true;
    bool3 = false;
    boolean bool4 = false;
    AppMethodBeat.i(62796);
    String str2 = String.format("select %s from %s where %s=?", new Object[] { "click_flag", "EmojiInfoDesc", "groupId" });
    localObject = null;
    str1 = null;
    for (;;)
    {
      try
      {
        paramString = this.db.a(str2, new String[] { paramString }, 2);
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
        ab.w("MicroMsg.emoji.EmojiInfoDescStorage", "[isPurChase] Exception:%s", new Object[] { paramString.toString() });
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
        AppMethodBeat.o(62796);
      }
      AppMethodBeat.o(62796);
      return bool2;
      bool1 = false;
    }
  }
  
  public final boolean asN(String paramString)
  {
    bool2 = true;
    bool3 = false;
    boolean bool4 = false;
    AppMethodBeat.i(62797);
    String str2 = String.format("select %s from %s where %s=?", new Object[] { "download_flag", "EmojiInfoDesc", "groupId" });
    localObject = null;
    str1 = null;
    for (;;)
    {
      try
      {
        paramString = this.db.a(str2, new String[] { paramString }, 2);
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
        ab.w("MicroMsg.emoji.EmojiInfoDescStorage", "[isPurChase] Exception:%s", new Object[] { paramString.toString() });
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
        AppMethodBeat.o(62797);
      }
      AppMethodBeat.o(62797);
      return bool2;
      bool1 = false;
    }
  }
  
  public final boolean asO(String paramString)
  {
    bool4 = false;
    boolean bool3 = false;
    AppMethodBeat.i(62798);
    bool2 = bool4;
    String str2;
    if (com.tencent.mm.plugin.emoji.h.b.Lk(paramString))
    {
      str2 = String.format("select %s from %s where %s=?", new Object[] { "desc", "EmojiInfoDesc", "groupId" });
      localObject = null;
      str1 = null;
    }
    try
    {
      paramString = this.db.a(str2, new String[] { paramString }, 2);
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
        ab.w("MicroMsg.emoji.EmojiInfoDescStorage", paramString.toString());
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
      AppMethodBeat.o(62798);
    }
    AppMethodBeat.o(62798);
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.c
 * JD-Core Version:    0.7.0.1
 */