package com.tencent.mm.plugin.recordvideo.background.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hu;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeDataStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseWeseeProviderInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "Companion", "plugin-recordvideo_release"})
public final class a
  extends MAutoStorage<hu>
{
  public static final a BMs;
  private static final String[] SQL_CREATE;
  private static final String TABLE = "WeseeProviderInfo";
  private static final String TAG = "MicroMsg.WeSeeDataStorage";
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(75328);
    BMs = new a((byte)0);
    TAG = "MicroMsg.WeSeeDataStorage";
    Object localObject = b.BMF;
    localObject = b.eIL();
    b.a locala = b.BMF;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs((IAutoDBItem.MAutoDBInfo)localObject, b.eIM()) };
    localObject = b.BMF;
    TABLE = b.eIM();
    AppMethodBeat.o(75328);
  }
  
  public a(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, (IAutoDBItem.MAutoDBInfo)localObject1, (String)localObject2, b.eIN());
    AppMethodBeat.i(75327);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(75327);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeDataStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "getTABLE", "()Ljava/lang/String;", "TAG", "getTAG", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.provider.a
 * JD-Core Version:    0.7.0.1
 */