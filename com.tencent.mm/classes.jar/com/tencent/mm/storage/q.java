package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.threadpool.i;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/storage/BizAdInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/storage/BizAdInfo;", "db", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "adMMkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getAdMMkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "adMMkv$delegate", "Lkotlin/Lazy;", "totalCount", "", "getTotalCount", "()I", "deleteById", "", "id", "", "deleteTable", "deleteTooOldData", "getTodayAdCardCount", "getTodayStartTime", "", "insertOrUpdate", "", "info", "updateAdExposeStatus", "Lcom/tencent/mm/storage/BizTimeLineInfo;", "Companion", "plugin-biz_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends MAutoStorage<p>
{
  private static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public static final q.a acDI;
  private final kotlin.j acDJ;
  private final com.tencent.mm.storagebase.h omV;
  
  static
  {
    AppMethodBeat.i(248818);
    acDI = new q.a((byte)0);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(p.info, "BizAdInfo") };
    INDEX_CREATE = new String[] { "CREATE  INDEX IF NOT EXISTS biz_exposeTime_index ON BizAdInfo ( exposeTime ) " };
    AppMethodBeat.o(248818);
  }
  
  public q(com.tencent.mm.storagebase.h paramh)
  {
    super((ISQLiteDatabase)paramh, p.info, "BizAdInfo", INDEX_CREATE);
    AppMethodBeat.i(248798);
    this.omV = paramh;
    this.acDJ = k.cm((a)q.b.acDK);
    AppMethodBeat.o(248798);
  }
  
  private static final void a(ab paramab, q paramq)
  {
    AppMethodBeat.i(248809);
    s.u(paramab, "$info");
    s.u(paramq, "this$0");
    Log.d("MicroMsg.BizAdInfoStorage", "updateAdExposeStatus msgId=" + paramab.field_msgId + ", traceId=" + paramab.getTraceId() + ", aId=" + paramab.iYs());
    long l = System.currentTimeMillis();
    if (!Util.isEqual(paramab.getTraceId(), paramq.iXh().decodeString("BizLastExposeAdAId")))
    {
      paramq.iXh().encode("BizLastExposeAdTime", l);
      paramq.iXh().encode("BizLastExposeAdAId", paramab.getTraceId());
    }
    Object localObject = com.tencent.mm.plugin.webcanvas.j.WkY;
    com.tencent.mm.plugin.webcanvas.j.xC(69L);
    localObject = new p();
    ((p)localObject).field_aId = paramab.getTraceId();
    ((p)localObject).field_msgId = paramab.field_msgId;
    ((p)localObject).field_exposeTime = l;
    s.u(localObject, "info");
    if (paramq.get((IAutoDBItem)localObject, new String[0]))
    {
      Log.i("MicroMsg.BizAdInfoStorage", "insertOrUpdate exist");
      AppMethodBeat.o(248809);
      return;
    }
    Log.i("MicroMsg.BizAdInfoStorage", s.X("insertOrUpdate ret=", Boolean.valueOf(paramq.insertNotify((IAutoDBItem)localObject, false))));
    d.B((a)new q.c(paramq));
    AppMethodBeat.o(248809);
  }
  
  private final MultiProcessMMKV iXh()
  {
    AppMethodBeat.i(248801);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)this.acDJ.getValue();
    AppMethodBeat.o(248801);
    return localMultiProcessMMKV;
  }
  
  public final void A(ab paramab)
  {
    AppMethodBeat.i(248840);
    s.u(paramab, "info");
    com.tencent.threadpool.h.ahAA.bm(new q..ExternalSyntheticLambda0(paramab, this));
    AppMethodBeat.o(248840);
  }
  
  public final void bSr()
  {
    AppMethodBeat.i(248830);
    Log.i("MicroMsg.BizAdInfoStorage", "deleteTable start");
    this.omV.execSQL("BizAdInfo", "delete from BizAdInfo");
    Log.i("MicroMsg.BizAdInfoStorage", "deleteTable end");
    AppMethodBeat.o(248830);
  }
  
  public final void bvf(String paramString)
  {
    AppMethodBeat.i(248824);
    p localp = new p();
    localp.field_aId = paramString;
    super.delete((IAutoDBItem)localp, false, new String[] { "aId" });
    AppMethodBeat.o(248824);
  }
  
  public final int iXg()
  {
    int i = 0;
    AppMethodBeat.i(248836);
    Object localObject = Calendar.getInstance();
    s.s(localObject, "getInstance()");
    ((Calendar)localObject).setTimeInMillis(System.currentTimeMillis());
    ((Calendar)localObject).set(11, 0);
    ((Calendar)localObject).set(13, 0);
    ((Calendar)localObject).set(12, 0);
    ((Calendar)localObject).set(14, 0);
    long l = ((Calendar)localObject).getTimeInMillis();
    localObject = s.X("SELECT count(*) FROM BizAdInfo where exposeTime > ", Long.valueOf(l));
    localObject = this.omV.rawQuery((String)localObject, null);
    if (((Cursor)localObject).moveToFirst()) {
      i = ((Cursor)localObject).getInt(0);
    }
    ((Cursor)localObject).close();
    Log.d("MicroMsg.BizAdInfoStorage", "getAdCardCount count=" + i + ", beginTime=" + l);
    AppMethodBeat.o(248836);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.q
 * JD-Core Version:    0.7.0.1
 */