package com.tencent.mm.plugin.recordvideo.background.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gt;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeDataStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseWeseeProviderInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "Companion", "plugin-recordvideo_release"})
public final class a
  extends j<gt>
{
  private static final String[] SQL_CREATE;
  private static final String TABLE = "WeseeProviderInfo";
  private static final String TAG = "MicroMsg.WeSeeDataStorage";
  public static final a vfN;
  private final e db;
  
  static
  {
    AppMethodBeat.i(75328);
    vfN = new a((byte)0);
    TAG = "MicroMsg.WeSeeDataStorage";
    Object localObject = b.vga;
    localObject = b.dgD();
    b.a locala = b.vga;
    SQL_CREATE = new String[] { j.getCreateSQLs((c.a)localObject, b.dgE()) };
    localObject = b.vga;
    TABLE = b.dgE();
    AppMethodBeat.o(75328);
  }
  
  public a(e parame)
  {
    super(parame, (c.a)localObject1, (String)localObject2, b.dgF());
    AppMethodBeat.i(75327);
    this.db = parame;
    AppMethodBeat.o(75327);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeDataStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "getTABLE", "()Ljava/lang/String;", "TAG", "getTAG", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.provider.a
 * JD-Core Version:    0.7.0.1
 */