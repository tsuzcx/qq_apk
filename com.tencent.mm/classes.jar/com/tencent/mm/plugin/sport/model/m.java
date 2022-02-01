package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import java.util.Collection;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.a;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.k;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/sport/model/SportKvStorage;", "", "()V", "TAG", "", "stepMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getStepMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "stepMMKV$delegate", "Lkotlin/Lazy;", "getConfigLong", "", "key", "defaultLong", "getConfigString", "defaultString", "getSportDetailInfo", "Lcom/tencent/mm/plugin/sport/model/SportKvStorage$SportDetailInfo;", "onPushCreate", "", "saveSportDetailInfo", "detailInfo", "setConfigLong", "value", "setConfigString", "SportDetailInfo", "plugin-sport_release"})
public final class m
{
  private static final f Lym;
  public static final m Lyn;
  
  static
  {
    AppMethodBeat.i(221669);
    Lyn = new m();
    Lym = g.ar((a)m.b.Lyo);
    AppMethodBeat.o(221669);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(221656);
    p.k(parama, "detailInfo");
    parama = parama.toString();
    gaY().encode("KEY_STEP_DETAIL_INFO", parama);
    Log.i("MicroMsg.Sport.SportKvStorage", "saveSportDetailInfo detailInfo:".concat(String.valueOf(parama)));
    AppMethodBeat.o(221656);
  }
  
  public static long bv(String paramString, long paramLong)
  {
    AppMethodBeat.i(221657);
    p.k(paramString, "key");
    paramLong = gaY().decodeLong(paramString, paramLong);
    AppMethodBeat.o(221657);
    return paramLong;
  }
  
  public static void bw(String paramString, long paramLong)
  {
    AppMethodBeat.i(221659);
    p.k(paramString, "key");
    gaY().encode(paramString, paramLong);
    AppMethodBeat.o(221659);
  }
  
  public static MultiProcessMMKV gaY()
  {
    AppMethodBeat.i(221652);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)Lym.getValue();
    AppMethodBeat.o(221652);
    return localMultiProcessMMKV;
  }
  
  public static a gaZ()
  {
    AppMethodBeat.i(221655);
    String str = gaY().decodeString("KEY_STEP_DETAIL_INFO", "");
    a locala = new a();
    p.j(str, "infoStr");
    locala.bcK(str);
    Log.i("MicroMsg.Sport.SportKvStorage", "getSportDetailInfo detailInfo:".concat(String.valueOf(str)));
    AppMethodBeat.o(221655);
    return locala;
  }
  
  public static void ls(String paramString1, String paramString2)
  {
    AppMethodBeat.i(221663);
    p.k(paramString1, "key");
    p.k(paramString2, "value");
    gaY().encode(paramString1, paramString2);
    AppMethodBeat.o(221663);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/sport/model/SportKvStorage$SportDetailInfo;", "", "()V", "currentTodayStep", "", "getCurrentTodayStep", "()J", "setCurrentTodayStep", "(J)V", "lastSaveSensorStep", "getLastSaveSensorStep", "setLastSaveSensorStep", "lastSaveStepTime", "getLastSaveStepTime", "setLastSaveStepTime", "preSensorNanoTime", "getPreSensorNanoTime", "setPreSensorNanoTime", "preSensorStep", "getPreSensorStep", "setPreSensorStep", "preSysStepTime", "getPreSysStepTime", "setPreSysStepTime", "saveTodayBeginTime", "getSaveTodayBeginTime", "setSaveTodayBeginTime", "fromStr", "", "detailInfoStr", "", "toString", "plugin-sport_release"})
  public static final class a
  {
    public long LxR;
    public long LxS;
    public long LxT;
    public long LxU;
    public long LxV;
    public long LxW;
    public long LxX;
    
    public final void bcK(String paramString)
    {
      AppMethodBeat.i(221440);
      p.k(paramString, "detailInfoStr");
      Object localObject = (CharSequence)paramString;
      localObject = ((Collection)new k(",").u((CharSequence)localObject, 0)).toArray(new String[0]);
      if (localObject == null)
      {
        paramString = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(221440);
        throw paramString;
      }
      localObject = (String[])localObject;
      try
      {
        this.LxU = Util.getLong(localObject[0], 0L);
        this.LxV = Util.getLong(localObject[1], 0L);
        this.LxW = Util.getLong(localObject[2], 0L);
        this.LxX = Util.getLong(localObject[3], 0L);
        this.LxR = Util.getLong(localObject[4], 0L);
        this.LxS = Util.getLong(localObject[5], 0L);
        this.LxT = Util.getLong(localObject[6], 0L);
        AppMethodBeat.o(221440);
        return;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.Sport.SportKvStorage", (Throwable)localException, "fromStr:" + paramString + ' ', new Object[0]);
        AppMethodBeat.o(221440);
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(221433);
      Object localObject = af.aaBG;
      localObject = String.format("%d,%d,%d,%d,%d,%d,%d", Arrays.copyOf(new Object[] { Long.valueOf(this.LxU), Long.valueOf(this.LxV), Long.valueOf(this.LxW), Long.valueOf(this.LxX), Long.valueOf(this.LxR), Long.valueOf(this.LxS), Long.valueOf(this.LxT) }, 7));
      p.j(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(221433);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.m
 * JD-Core Version:    0.7.0.1
 */