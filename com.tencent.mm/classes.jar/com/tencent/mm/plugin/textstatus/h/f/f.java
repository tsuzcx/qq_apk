package com.tencent.mm.plugin.textstatus.h.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReferenceStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReference;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "delete", "", "item", "keys", "", "", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReference;[Ljava/lang/String;)Z", "doNotify", "", "name", "get", "textStatusId", "userName", "getAllCursor", "Landroid/database/Cursor;", "getAllReadCursor", "getAllUnreadCursor", "getCursorById", "textStatusID", "getIsLikeOther", "statusId", "getLatestRef", "getLikeInfos", "", "getNotifyCount", "", "getReadCount", "getSelfLikeCnt", "getUnreadCount", "afterTime", "getUnreadInfos", "insert", "markDeleteInMsgList", "markRead", "replace", "update", "rowId", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends MAutoStorage<e>
{
  public static final f.a TnN;
  public static final String ptT;
  private static final String[] ptU;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(290707);
    TnN = new f.a((byte)0);
    ptT = "TextStatusReference";
    e.a locala = e.TnM;
    ptU = new String[] { MAutoStorage.getCreateSQLs(e.hHK(), "TextStatusReference") };
    AppMethodBeat.o(290707);
  }
  
  public f(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, e.hHK(), "TextStatusReference", null);
    AppMethodBeat.i(290700);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(290700);
  }
  
  public final boolean a(e parame)
  {
    AppMethodBeat.i(290715);
    s.u(parame, "item");
    boolean bool = super.insertNotify((IAutoDBItem)parame, false);
    doNotify(parame.field_UserName);
    AppMethodBeat.o(290715);
    return bool;
  }
  
  public final boolean a(e parame, String... paramVarArgs)
  {
    AppMethodBeat.i(290719);
    s.u(parame, "item");
    s.u(paramVarArgs, "keys");
    boolean bool = super.updateNotify((IAutoDBItem)parame, false, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    doNotify(parame.field_UserName);
    AppMethodBeat.o(290719);
    return bool;
  }
  
  public final int aor(int paramInt)
  {
    AppMethodBeat.i(290732);
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
      AppMethodBeat.o(290732);
      return paramInt;
      localObject = "select count(rowid) from " + ptT + " where Read != 1 and CreateTime > " + paramInt;
      break;
    }
  }
  
  public final boolean b(e parame, String... paramVarArgs)
  {
    AppMethodBeat.i(290724);
    s.u(parame, "item");
    s.u(paramVarArgs, "keys");
    boolean bool = super.delete((IAutoDBItem)parame, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    doNotify(parame.field_UserName);
    AppMethodBeat.o(290724);
    return bool;
  }
  
  public final void bdW(String paramString)
  {
    AppMethodBeat.i(290741);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = "update " + ptT + " set Read = 1 where Read != 1 ";
      this.db.execSQL(ptT, paramString);
      AppMethodBeat.o(290741);
      return;
    }
    paramString = "update " + ptT + " set Read = 1 where Read != 1 and TextStatusId = '" + paramString + '\'';
    this.db.execSQL(ptT, paramString);
    AppMethodBeat.o(290741);
  }
  
  public final void doNotify(String paramString)
  {
    AppMethodBeat.i(290709);
    super.doNotify(paramString, -1, null);
    AppMethodBeat.o(290709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.f.f
 * JD-Core Version:    0.7.0.1
 */