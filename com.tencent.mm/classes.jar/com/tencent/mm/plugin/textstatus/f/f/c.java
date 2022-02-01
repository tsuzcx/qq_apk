package com.tencent.mm.plugin.textstatus.f.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.auth.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLikeStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "delete", "", "item", "keys", "", "", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;[Ljava/lang/String;)Z", "get", "textStatusId", "userName", "getAllCursor", "Landroid/database/Cursor;", "getAllReadCursor", "getAllUnreadCursor", "getCursorById", "textStatusID", "getIsLikeOther", "statusId", "getLatestLike", "getLikeInfos", "", "getNotifyCount", "", "getSelfLikeCnt", "getUnreadCount", "getUnreadInfos", "insert", "markRead", "", "replace", "update", "rowId", "", "Companion", "plugin-textstatus_release"})
public final class c
  extends MAutoStorage<b>
{
  private static final String[] FZH;
  public static final a FZI;
  public static final String TABLE = "TextStatusLike";
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(216267);
    FZI = new a((byte)0);
    TABLE = "TextStatusLike";
    b.a locala = b.FZG;
    FZH = new String[] { MAutoStorage.getCreateSQLs(b.fvW(), "TextStatusLike") };
    AppMethodBeat.o(216267);
  }
  
  public c(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, b.fvW(), "TextStatusLike", null);
    AppMethodBeat.i(216266);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(216266);
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(216253);
    p.h(paramb, "item");
    boolean bool = super.insertNotify((IAutoDBItem)paramb, false);
    doNotify(paramb.field_HashUserName);
    AppMethodBeat.o(216253);
    return bool;
  }
  
  public final boolean a(b paramb, String... paramVarArgs)
  {
    AppMethodBeat.i(216256);
    p.h(paramb, "item");
    p.h(paramVarArgs, "keys");
    boolean bool = super.updateNotify((IAutoDBItem)paramb, false, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    doNotify(paramb.field_HashUserName);
    AppMethodBeat.o(216256);
    return bool;
  }
  
  public final boolean aTi(String paramString)
  {
    AppMethodBeat.i(216263);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.aL((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(216263);
      return false;
    }
    localObject = "select count(rowid) from " + TABLE + " where TextStatusId = ? and HashUserName = ?";
    localObject = this.db.rawQuery((String)localObject, new String[] { paramString, a.ceA() });
    p.g(localObject, "db.rawQuery(sql, arrayOf…sId, Account.username()))");
    if (localObject != null) {
      if (((Cursor)localObject).moveToFirst())
      {
        i = ((Cursor)localObject).getInt(0);
        ((Cursor)localObject).close();
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.TxtStatus.TextStatusLikeStorage", "[getIsLikeOther]statusId:%s result:%s", new Object[] { paramString, Integer.valueOf(i) });
      if (i > 0)
      {
        AppMethodBeat.o(216263);
        return true;
      }
      AppMethodBeat.o(216263);
      return false;
      i = 0;
      break;
      i = 0;
    }
  }
  
  public final int aTj(String paramString)
  {
    AppMethodBeat.i(216264);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.aL((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(216264);
      return 0;
    }
    localObject = "select count(rowid) from " + TABLE + " where TextStatusId = ?";
    localObject = this.db.rawQuery((String)localObject, new String[] { paramString });
    p.g(localObject, "db.rawQuery(sql, arrayOf(statusId))");
    if (localObject != null) {
      if (((Cursor)localObject).moveToFirst())
      {
        i = ((Cursor)localObject).getInt(0);
        ((Cursor)localObject).close();
      }
    }
    for (;;)
    {
      int j = i;
      if (i < 0) {
        j = 0;
      }
      Log.i("MicroMsg.TxtStatus.TextStatusLikeStorage", "[getSelfLikeCnt]statusId:%s result:%s", new Object[] { paramString, Integer.valueOf(j) });
      AppMethodBeat.o(216264);
      return j;
      i = 0;
      break;
      i = 0;
    }
  }
  
  public final boolean b(b paramb, String... paramVarArgs)
  {
    AppMethodBeat.i(216259);
    p.h(paramb, "item");
    p.h(paramVarArgs, "keys");
    boolean bool = super.delete((IAutoDBItem)paramb, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    doNotify(paramb.field_HashUserName);
    AppMethodBeat.o(216259);
    return bool;
  }
  
  public final int ctM()
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(216262);
    Object localObject = "select count(rowid) from " + TABLE + " where Read != 1 ";
    localObject = this.db.rawQuery((String)localObject, null);
    p.g(localObject, "db.rawQuery(sql, null)");
    if (localObject != null)
    {
      i = j;
      if (((Cursor)localObject).moveToFirst()) {
        i = ((Cursor)localObject).getInt(0);
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(216262);
    return i;
  }
  
  public final b lc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(216261);
    p.h(paramString1, "textStatusId");
    p.h(paramString2, "userName");
    Object localObject = "select rowid, * from " + TABLE + " where TextStatusId = ? and HashUserName = ? ";
    localObject = this.db.rawQuery((String)localObject, new String[] { Util.escapeSqlValue(paramString1), Util.escapeSqlValue(paramString2) });
    p.g(localObject, "db.rawQuery(sql, arrayOf…scapeSqlValue(userName)))");
    paramString1 = null;
    paramString2 = null;
    if (localObject != null)
    {
      paramString1 = paramString2;
      if (((Cursor)localObject).moveToFirst())
      {
        paramString1 = new b();
        paramString1.convertFrom((Cursor)localObject);
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(216261);
    return paramString1;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLikeStorage$Companion;", "", "()V", "TABLE", "", "getTABLE", "()Ljava/lang/String;", "TABLE_CREATE_SQL", "", "kotlin.jvm.PlatformType", "getTABLE_CREATE_SQL", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TAG", "plugin-textstatus_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.f.c
 * JD-Core Version:    0.7.0.1
 */