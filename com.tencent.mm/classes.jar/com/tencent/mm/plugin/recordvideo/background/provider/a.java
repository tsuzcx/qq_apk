package com.tencent.mm.plugin.recordvideo.background.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ic;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeDataStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseWeseeProviderInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "Companion", "plugin-recordvideo_release"})
public final class a
  extends MAutoStorage<ic>
{
  private static final String Alf = "WeseeProviderInfo";
  public static final a HIE;
  private static final String[] SQL_CREATE;
  private static final String TAG = "MicroMsg.WeSeeDataStorage";
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(75328);
    HIE = new a((byte)0);
    TAG = "MicroMsg.WeSeeDataStorage";
    Object localObject = b.HIR;
    localObject = b.bHK();
    b.a locala = b.HIR;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs((IAutoDBItem.MAutoDBInfo)localObject, b.fuQ()) };
    localObject = b.HIR;
    Alf = b.fuQ();
    AppMethodBeat.o(75328);
  }
  
  public a(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, (IAutoDBItem.MAutoDBInfo)localObject1, (String)localObject2, b.fuR());
    AppMethodBeat.i(75327);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(75327);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeDataStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "getSQL_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "TABLE", "getTABLE", "()Ljava/lang/String;", "TAG", "getTAG", "plugin-recordvideo_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.provider.a
 * JD-Core Version:    0.7.0.1
 */