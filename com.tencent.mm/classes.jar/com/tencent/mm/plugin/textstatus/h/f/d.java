package com.tencent.mm.plugin.textstatus.h.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.auth.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLikeStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "delete", "", "item", "keys", "", "", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;[Ljava/lang/String;)Z", "doNotify", "", "name", "get", "textStatusId", "userName", "getAllCursor", "Landroid/database/Cursor;", "getAllReadCursor", "getAllUnreadCursor", "getCursorById", "textStatusID", "getIsLikeOther", "statusId", "getLatestLike", "getLikeInfos", "", "getNotifyCount", "", "getReadCount", "getSelfLikeCnt", "getUnreadCount", "afterTime", "getUnreadInfos", "insert", "markDeleteInMsgList", "markRead", "replace", "update", "rowId", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends MAutoStorage<c>
{
  public static final d.a TnL;
  public static final String ptT;
  private static final String[] ptU;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(290726);
    TnL = new d.a((byte)0);
    ptT = "TextStatusLike";
    c.a locala = c.TnI;
    ptU = new String[] { MAutoStorage.getCreateSQLs(c.hHK(), "TextStatusLike") };
    AppMethodBeat.o(290726);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.hHK(), "TextStatusLike", null);
    AppMethodBeat.i(290710);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(290710);
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(290738);
    s.u(paramc, "item");
    boolean bool = super.insertNotify((IAutoDBItem)paramc, false);
    doNotify(paramc.field_HashUserName);
    AppMethodBeat.o(290738);
    return bool;
  }
  
  public final boolean a(c paramc, String... paramVarArgs)
  {
    AppMethodBeat.i(290748);
    s.u(paramc, "item");
    s.u(paramVarArgs, "keys");
    boolean bool = super.updateNotify((IAutoDBItem)paramc, false, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    doNotify(paramc.field_HashUserName);
    AppMethodBeat.o(290748);
    return bool;
  }
  
  public final int aor(int paramInt)
  {
    AppMethodBeat.i(290782);
    Object localObject;
    if (paramInt < 0)
    {
      localObject = "select count(rowid) from " + ptT + " where Read != 1 ";
      localObject = this.db.rawQuery((String)localObject, null);
      s.s(localObject, "db.rawQuery(sql, null)");
      if (!((Cursor)localObject).moveToFirst()) {
        break label112;
      }
    }
    label112:
    for (paramInt = ((Cursor)localObject).getInt(0);; paramInt = 0)
    {
      ((Cursor)localObject).close();
      AppMethodBeat.o(290782);
      return paramInt;
      localObject = "select count(rowid) from " + ptT + " where Read != 1 and CreateTime > " + paramInt;
      break;
    }
  }
  
  public final boolean b(c paramc, String... paramVarArgs)
  {
    AppMethodBeat.i(290755);
    s.u(paramc, "item");
    s.u(paramVarArgs, "keys");
    boolean bool = super.delete((IAutoDBItem)paramc, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    doNotify(paramc.field_HashUserName);
    AppMethodBeat.o(290755);
    return bool;
  }
  
  public final boolean bdV(String paramString)
  {
    AppMethodBeat.i(290793);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(290793);
      return false;
    }
    localObject = "select count(rowid) from " + ptT + " where TextStatusId = ? and HashUserName = ?";
    localObject = this.db.rawQuery((String)localObject, new String[] { paramString, a.cUx() });
    s.s(localObject, "db.rawQuery(sql, arrayOf…sId, Account.username()))");
    if (((Cursor)localObject).moveToFirst()) {}
    for (i = ((Cursor)localObject).getInt(0);; i = 0)
    {
      ((Cursor)localObject).close();
      Log.i("MicroMsg.TextStatus.TextStatusLikeStorage", "[getIsLikeOther]statusId:%s result:%s", new Object[] { paramString, Integer.valueOf(i) });
      if (i > 0)
      {
        AppMethodBeat.o(290793);
        return true;
      }
      AppMethodBeat.o(290793);
      return false;
    }
  }
  
  public final void doNotify(String paramString)
  {
    AppMethodBeat.i(290733);
    super.doNotify(paramString, -1, null);
    AppMethodBeat.o(290733);
  }
  
  public final c ni(String paramString1, String paramString2)
  {
    AppMethodBeat.i(290768);
    s.u(paramString1, "textStatusId");
    s.u(paramString2, "userName");
    String str = "select rowid, * from " + ptT + " where TextStatusId = ? and HashUserName = ? ";
    paramString2 = this.db.rawQuery(str, new String[] { Util.escapeSqlValue(paramString1), Util.escapeSqlValue(paramString2) });
    s.s(paramString2, "db.rawQuery(sql, arrayOf…scapeSqlValue(userName)))");
    paramString1 = null;
    if (paramString2.moveToFirst())
    {
      paramString1 = new c();
      paramString1.convertFrom(paramString2);
    }
    paramString2.close();
    AppMethodBeat.o(290768);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.f.d
 * JD-Core Version:    0.7.0.1
 */