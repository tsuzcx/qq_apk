package com.tencent.mm.plugin.textstatus.h.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.j.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.ISqlCondition;
import com.tencent.mm.sdk.storage.sql.SelectSql;
import com.tencent.mm.sdk.storage.sql.SelectSql.Builder;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStrangerContactStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStrangerContact;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getContact", "sessionId", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends MAutoStorage<h>
{
  public static final i.a TnU;
  private static final String ptT;
  private static final String[] ptU;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(290714);
    TnU = new i.a((byte)0);
    ptT = "TextStatusStrangerContact";
    h.a locala = h.TnR;
    ptU = new String[] { MAutoStorage.getCreateSQLs(h.hHK(), "TextStatusStrangerContact") };
    AppMethodBeat.o(290714);
  }
  
  public i(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, h.hHK(), "TextStatusStrangerContact", null);
    AppMethodBeat.i(290701);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(290701);
  }
  
  public final h bdK(String paramString)
  {
    AppMethodBeat.i(290725);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (n.bp((CharSequence)localObject))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(290725);
      return null;
    }
    localObject = g.TABLE;
    s.s(localObject, "TABLE");
    s.s(g.kiW, "SESSIONID");
    localObject = ((SingleTable)localObject).selectAll();
    Column localColumn = g.kiW;
    paramString = Util.escapeSqlValue(paramString);
    s.s(paramString, "escapeSqlValue(sessionId)");
    paramString = (h)((SelectSql.Builder)localObject).where((ISqlCondition)localColumn.equal(paramString)).build().singleQuery(this.db, h.class);
    AppMethodBeat.o(290725);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.f.i
 * JD-Core Version:    0.7.0.1
 */