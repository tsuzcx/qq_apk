package com.tencent.mm.plugin.recordvideo.background.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gx;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeDataStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseWeseeProviderInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "Companion", "plugin-recordvideo_release"})
public final class a
  extends j<gx>
{
  private static final String[] SQL_CREATE;
  private static final String TABLE = "WeseeProviderInfo";
  private static final String TAG = "MicroMsg.WeSeeDataStorage";
  public static final a.a woz;
  private final e db;
  
  static
  {
    AppMethodBeat.i(75328);
    woz = new a.a((byte)0);
    TAG = "MicroMsg.WeSeeDataStorage";
    Object localObject = b.woM;
    localObject = b.dul();
    b.a locala = b.woM;
    SQL_CREATE = new String[] { j.getCreateSQLs((c.a)localObject, b.dum()) };
    localObject = b.woM;
    TABLE = b.dum();
    AppMethodBeat.o(75328);
  }
  
  public a(e parame)
  {
    super(parame, (c.a)localObject1, (String)localObject2, b.dun());
    AppMethodBeat.i(75327);
    this.db = parame;
    AppMethodBeat.o(75327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.provider.a
 * JD-Core Version:    0.7.0.1
 */