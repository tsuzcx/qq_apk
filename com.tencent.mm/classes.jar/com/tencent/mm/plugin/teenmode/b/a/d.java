package com.tencent.mm.plugin.teenmode.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.teenmode.a.f;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/teenmode/model/storage/TeenModeBindGuardianStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/teenmode/api/TeenModeBindGuardian;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "get", "ticket", "", "Companion", "plugin-teenmode_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends MAutoStorage<f>
{
  public static final d.a SZp;
  private static final String ptT;
  private static final String[] ptU;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(278917);
    SZp = new d.a((byte)0);
    ptT = "TeenModeBindGuardian";
    ptU = new String[] { MAutoStorage.getCreateSQLs(f.dbInfo, "TeenModeBindGuardian") };
    AppMethodBeat.o(278917);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, f.dbInfo, "TeenModeBindGuardian", null);
    AppMethodBeat.i(278898);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(278898);
  }
  
  public final f bdl(String paramString)
  {
    AppMethodBeat.i(278924);
    s.u(paramString, "ticket");
    f localf = new f();
    localf.field_ticket = paramString;
    get((IAutoDBItem)localf, new String[] { "ticket" });
    AppMethodBeat.o(278924);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.teenmode.b.a.d
 * JD-Core Version:    0.7.0.1
 */