package com.tencent.mm.plugin.textstatus.g.e;

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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLikeStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "delete", "", "item", "keys", "", "", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;[Ljava/lang/String;)Z", "get", "textStatusId", "userName", "getAllCursor", "Landroid/database/Cursor;", "getAllReadCursor", "getAllUnreadCursor", "getCursorById", "textStatusID", "getIsLikeOther", "statusId", "getLatestLike", "getLikeInfos", "", "getNotifyCount", "", "getReadCount", "getSelfLikeCnt", "getUnreadCount", "getUnreadInfos", "insert", "markDeleteInMsgList", "", "markRead", "replace", "update", "rowId", "", "Companion", "plugin-textstatus_release"})
public final class c
  extends MAutoStorage<b>
{
  public static final String Alf = "TextStatusLike";
  private static final String[] MDY;
  public static final c.a MDZ;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(237817);
    MDZ = new c.a((byte)0);
    Alf = "TextStatusLike";
    b.a locala = b.MDX;
    MDY = new String[] { MAutoStorage.getCreateSQLs(b.gmb(), "TextStatusLike") };
    AppMethodBeat.o(237817);
  }
  
  public c(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, b.gmb(), "TextStatusLike", null);
    AppMethodBeat.i(237816);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(237816);
  }
  
  public final boolean a(b paramb)
  {
    AppMethodBeat.i(237790);
    p.k(paramb, "item");
    boolean bool = super.insertNotify((IAutoDBItem)paramb, false);
    doNotify(paramb.field_HashUserName);
    AppMethodBeat.o(237790);
    return bool;
  }
  
  public final boolean a(b paramb, String... paramVarArgs)
  {
    AppMethodBeat.i(237797);
    p.k(paramb, "item");
    p.k(paramVarArgs, "keys");
    boolean bool = super.updateNotify((IAutoDBItem)paramb, false, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    doNotify(paramb.field_HashUserName);
    AppMethodBeat.o(237797);
    return bool;
  }
  
  public final boolean b(b paramb, String... paramVarArgs)
  {
    AppMethodBeat.i(237805);
    p.k(paramb, "item");
    p.k(paramVarArgs, "keys");
    boolean bool = super.delete((IAutoDBItem)paramb, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    doNotify(paramb.field_HashUserName);
    AppMethodBeat.o(237805);
    return bool;
  }
  
  public final boolean beu(String paramString)
  {
    AppMethodBeat.i(237814);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.ba((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(237814);
      return false;
    }
    localObject = "select count(rowid) from " + Alf + " where TextStatusId = ? and HashUserName = ?";
    localObject = this.db.rawQuery((String)localObject, new String[] { paramString, a.crN() });
    p.j(localObject, "db.rawQuery(sql, arrayOf…sId, Account.username()))");
    if (localObject != null) {
      if (((Cursor)localObject).moveToFirst())
      {
        i = ((Cursor)localObject).getInt(0);
        ((Cursor)localObject).close();
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.TextStatus.TextStatusLikeStorage", "[getIsLikeOther]statusId:%s result:%s", new Object[] { paramString, Integer.valueOf(i) });
      if (i > 0)
      {
        AppMethodBeat.o(237814);
        return true;
      }
      AppMethodBeat.o(237814);
      return false;
      i = 0;
      break;
      i = 0;
    }
  }
  
  public final int bev(String paramString)
  {
    AppMethodBeat.i(237815);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.ba((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(237815);
      return 0;
    }
    localObject = "select count(rowid) from " + Alf + " where TextStatusId = ?";
    localObject = this.db.rawQuery((String)localObject, new String[] { paramString });
    p.j(localObject, "db.rawQuery(sql, arrayOf(statusId))");
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
      Log.i("MicroMsg.TextStatus.TextStatusLikeStorage", "[getSelfLikeCnt]statusId:%s result:%s", new Object[] { paramString, Integer.valueOf(j) });
      AppMethodBeat.o(237815);
      return j;
      i = 0;
      break;
      i = 0;
    }
  }
  
  public final int cHo()
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(237813);
    Object localObject = "select count(rowid) from " + Alf + " where Read != 1 ";
    localObject = this.db.rawQuery((String)localObject, null);
    p.j(localObject, "db.rawQuery(sql, null)");
    if (localObject != null)
    {
      i = j;
      if (((Cursor)localObject).moveToFirst()) {
        i = ((Cursor)localObject).getInt(0);
      }
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(237813);
    return i;
  }
  
  public final b lz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(237811);
    p.k(paramString1, "textStatusId");
    p.k(paramString2, "userName");
    Object localObject = "select rowid, * from " + Alf + " where TextStatusId = ? and HashUserName = ? ";
    localObject = this.db.rawQuery((String)localObject, new String[] { Util.escapeSqlValue(paramString1), Util.escapeSqlValue(paramString2) });
    p.j(localObject, "db.rawQuery(sql, arrayOf…scapeSqlValue(userName)))");
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
    AppMethodBeat.o(237811);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.e.c
 * JD-Core Version:    0.7.0.1
 */