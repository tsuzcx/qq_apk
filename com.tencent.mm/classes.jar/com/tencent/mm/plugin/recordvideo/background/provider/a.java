package com.tencent.mm.plugin.recordvideo.background.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hh;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeDataStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseWeseeProviderInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "Companion", "plugin-recordvideo_release"})
public final class a
  extends j<hh>
{
  private static final String[] SQL_CREATE;
  private static final String TABLE = "WeseeProviderInfo";
  private static final String TAG = "MicroMsg.WeSeeDataStorage";
  public static final a xwp;
  private final e db;
  
  static
  {
    AppMethodBeat.i(75328);
    xwp = new a((byte)0);
    TAG = "MicroMsg.WeSeeDataStorage";
    Object localObject = b.xwC;
    localObject = b.dEH();
    b.a locala = b.xwC;
    SQL_CREATE = new String[] { j.getCreateSQLs((c.a)localObject, b.dEI()) };
    localObject = b.xwC;
    TABLE = b.dEI();
    AppMethodBeat.o(75328);
  }
  
  public a(e parame)
  {
    super(parame, (c.a)localObject1, (String)localObject2, b.dEJ());
    AppMethodBeat.i(75327);
    this.db = parame;
    AppMethodBeat.o(75327);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeDataStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "getTABLE", "()Ljava/lang/String;", "TAG", "getTAG", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.provider.a
 * JD-Core Version:    0.7.0.1
 */