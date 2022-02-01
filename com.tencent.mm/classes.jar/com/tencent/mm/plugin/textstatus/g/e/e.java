package com.tencent.mm.plugin.textstatus.g.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReferenceStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReference;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "delete", "", "item", "keys", "", "", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReference;[Ljava/lang/String;)Z", "get", "textStatusId", "userName", "getAllCursor", "Landroid/database/Cursor;", "getAllReadCursor", "getAllUnreadCursor", "getCursorById", "textStatusID", "getIsLikeOther", "statusId", "getLatestRef", "getLikeInfos", "", "getNotifyCount", "", "getReadCount", "getSelfLikeCnt", "getUnreadCount", "getUnreadInfos", "insert", "markDeleteInMsgList", "", "markRead", "replace", "update", "rowId", "", "Companion", "plugin-textstatus_release"})
public final class e
  extends MAutoStorage<d>
{
  public static final String Alf = "TextStatusReference";
  private static final String[] MDY;
  public static final e.a MEb;
  public final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(234476);
    MEb = new e.a((byte)0);
    Alf = "TextStatusReference";
    d.a locala = d.MEa;
    MDY = new String[] { MAutoStorage.getCreateSQLs(d.gmb(), "TextStatusReference") };
    AppMethodBeat.o(234476);
  }
  
  public e(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, d.gmb(), "TextStatusReference", null);
    AppMethodBeat.i(234474);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(234474);
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(234456);
    p.k(paramd, "item");
    boolean bool = super.insertNotify((IAutoDBItem)paramd, false);
    doNotify(paramd.field_UserName);
    AppMethodBeat.o(234456);
    return bool;
  }
  
  public final boolean a(d paramd, String... paramVarArgs)
  {
    AppMethodBeat.i(234460);
    p.k(paramd, "item");
    p.k(paramVarArgs, "keys");
    boolean bool = super.updateNotify((IAutoDBItem)paramd, false, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    doNotify(paramd.field_UserName);
    AppMethodBeat.o(234460);
    return bool;
  }
  
  public final boolean b(d paramd, String... paramVarArgs)
  {
    AppMethodBeat.i(234464);
    p.k(paramd, "item");
    p.k(paramVarArgs, "keys");
    boolean bool = super.delete((IAutoDBItem)paramd, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
    doNotify(paramd.field_UserName);
    AppMethodBeat.o(234464);
    return bool;
  }
  
  public final int bev(String paramString)
  {
    AppMethodBeat.i(234472);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.ba((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(234472);
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
      Log.i("MicroMsg.TextStatus.TextStatusReferenceStorage", "[getSelfLikeCnt]statusId:%s result:%s", new Object[] { paramString, Integer.valueOf(j) });
      AppMethodBeat.o(234472);
      return j;
      i = 0;
      break;
      i = 0;
    }
  }
  
  public final void bew(String paramString)
  {
    AppMethodBeat.i(234468);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.ba(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramString = "update " + Alf + " set Read = 1 where Read != 1 ";
      this.db.execSQL(Alf, paramString);
      AppMethodBeat.o(234468);
      return;
    }
    paramString = "update " + Alf + " set Read = 1 where Read != 1 and TextStatusId = '" + paramString + '\'';
    this.db.execSQL(Alf, paramString);
    AppMethodBeat.o(234468);
  }
  
  public final int cHo()
  {
    int i = 0;
    int j = 0;
    AppMethodBeat.i(234466);
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
    AppMethodBeat.o(234466);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.g.e.e
 * JD-Core Version:    0.7.0.1
 */