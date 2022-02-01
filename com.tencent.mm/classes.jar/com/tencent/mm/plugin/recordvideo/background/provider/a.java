package com.tencent.mm.plugin.recordvideo.background.provider;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.iy;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/provider/WeSeeDataStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/autogen/table/BaseWeseeProviderInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "getDb", "()Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MAutoStorage<iy>
{
  public static final a.a NFW;
  private static final String[] SQL_CREATE;
  private static final String TAG;
  private static final String ptT;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(75328);
    NFW = new a.a((byte)0);
    TAG = "MicroMsg.WeSeeDataStorage";
    Object localObject = b.NGj;
    localObject = b.chg();
    b.a locala = b.NGj;
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs((IAutoDBItem.MAutoDBInfo)localObject, b.gGG()) };
    localObject = b.NGj;
    ptT = b.gGG();
    AppMethodBeat.o(75328);
  }
  
  public a(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, (IAutoDBItem.MAutoDBInfo)localObject1, (String)localObject2, b.gGH());
    AppMethodBeat.i(75327);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(75327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.provider.a
 * JD-Core Version:    0.7.0.1
 */