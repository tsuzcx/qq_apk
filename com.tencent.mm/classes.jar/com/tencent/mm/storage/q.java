package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import kotlin.g.a.a;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/storage/BizAdInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/storage/BizAdInfo;", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "totalCount", "", "getTotalCount", "()I", "deleteById", "", "id", "", "deleteTooOldData", "getTodayAdCardCount", "getTodayStartTime", "", "insertOrUpdate", "", "info", "Companion", "plugin-biz_release"})
public final class q
  extends MAutoStorage<p>
{
  private static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public static final a Vcy;
  final h lvy;
  
  static
  {
    AppMethodBeat.i(206766);
    Vcy = new a((byte)0);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(p.info, "BizAdInfo") };
    INDEX_CREATE = new String[] { "CREATE  INDEX IF NOT EXISTS biz_exposeTime_index ON BizAdInfo ( exposeTime ) " };
    AppMethodBeat.o(206766);
  }
  
  public q(h paramh)
  {
    super((ISQLiteDatabase)paramh, p.info, "BizAdInfo", INDEX_CREATE);
    AppMethodBeat.i(206764);
    this.lvy = paramh;
    AppMethodBeat.o(206764);
  }
  
  public final boolean a(p paramp)
  {
    AppMethodBeat.i(206760);
    kotlin.g.b.p.k(paramp, "info");
    if (get((IAutoDBItem)paramp, new String[0]))
    {
      Log.i("MicroMsg.BizAdInfoStorage", "insertOrUpdate exist");
      AppMethodBeat.o(206760);
      return false;
    }
    boolean bool = super.insertNotify((IAutoDBItem)paramp, false);
    Log.i("MicroMsg.BizAdInfoStorage", "insertOrUpdate ret=".concat(String.valueOf(bool)));
    d.h((a)new b(this));
    AppMethodBeat.o(206760);
    return bool;
  }
  
  public final void buY(String paramString)
  {
    AppMethodBeat.i(206762);
    p localp = new p();
    localp.field_aId = paramString;
    super.delete((IAutoDBItem)localp, false, new String[] { "aId" });
    AppMethodBeat.o(206762);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/storage/BizAdInfoStorage$Companion;", "", "()V", "DELETE_DATA_COUNT", "", "INDEX_CREATE", "", "", "getINDEX_CREATE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "MAX_DATA_COLUMN", "SQL_CREATE", "kotlin.jvm.PlatformType", "TABLE", "TAG", "plugin-biz_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements a<x>
  {
    b(q paramq)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.storage.q
 * JD-Core Version:    0.7.0.1
 */