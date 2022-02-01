package com.tencent.mm.plugin.sport.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sport/model/SportKvStorage;", "", "()V", "TAG", "", "stepMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getStepMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "stepMMKV$delegate", "Lkotlin/Lazy;", "getConfigLong", "", "key", "defaultLong", "getConfigString", "defaultString", "getSportDetailInfo", "Lcom/tencent/mm/plugin/sport/model/SportKvStorage$SportDetailInfo;", "onPushCreate", "", "saveSportDetailInfo", "detailInfo", "setConfigLong", "value", "setConfigString", "SportDetailInfo", "plugin-sport_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final n Scc;
  private static final j Scd;
  
  static
  {
    AppMethodBeat.i(263928);
    Scc = new n();
    Scd = kotlin.k.cm((a)n.b.Sce);
    AppMethodBeat.o(263928);
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(263913);
    s.u(parama, "detailInfo");
    parama = parama.toString();
    hur().encode("KEY_STEP_DETAIL_INFO", parama);
    Log.i("MicroMsg.Sport.SportKvStorage", s.X("saveSportDetailInfo detailInfo:", parama));
    AppMethodBeat.o(263913);
  }
  
  public static long bH(String paramString, long paramLong)
  {
    AppMethodBeat.i(263917);
    s.u(paramString, "key");
    paramLong = hur().decodeLong(paramString, paramLong);
    AppMethodBeat.o(263917);
    return paramLong;
  }
  
  public static void bI(String paramString, long paramLong)
  {
    AppMethodBeat.i(263920);
    s.u(paramString, "key");
    hur().encode(paramString, paramLong);
    AppMethodBeat.o(263920);
  }
  
  public static MultiProcessMMKV hur()
  {
    AppMethodBeat.i(263910);
    MultiProcessMMKV localMultiProcessMMKV = (MultiProcessMMKV)Scd.getValue();
    AppMethodBeat.o(263910);
    return localMultiProcessMMKV;
  }
  
  public static a hus()
  {
    AppMethodBeat.i(263912);
    String str = hur().decodeString("KEY_STEP_DETAIL_INFO", "");
    a locala = new a();
    s.s(str, "infoStr");
    locala.bby(str);
    Log.i("MicroMsg.Sport.SportKvStorage", s.X("getSportDetailInfo detailInfo:", str));
    AppMethodBeat.o(263912);
    return locala;
  }
  
  public static void na(String paramString1, String paramString2)
  {
    AppMethodBeat.i(263924);
    s.u(paramString1, "key");
    s.u(paramString2, "value");
    hur().encode(paramString1, paramString2);
    AppMethodBeat.o(263924);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sport/model/SportKvStorage$SportDetailInfo;", "", "()V", "currentTodayStep", "", "getCurrentTodayStep", "()J", "setCurrentTodayStep", "(J)V", "lastSaveSensorStep", "getLastSaveSensorStep", "setLastSaveSensorStep", "lastSaveStepTime", "getLastSaveStepTime", "setLastSaveStepTime", "preSensorNanoTime", "getPreSensorNanoTime", "setPreSensorNanoTime", "preSensorStep", "getPreSensorStep", "setPreSensorStep", "preSysStepTime", "getPreSysStepTime", "setPreSysStepTime", "saveTodayBeginTime", "getSaveTodayBeginTime", "setSaveTodayBeginTime", "fromStr", "", "detailInfoStr", "", "toString", "plugin-sport_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public long SbE;
    public long SbF;
    public long SbG;
    public long SbH;
    public long SbI;
    public long SbJ;
    public long SbK;
    
    public final void bby(String paramString)
    {
      int j = 1;
      AppMethodBeat.i(263941);
      s.u(paramString, "detailInfoStr");
      Object localObject = (CharSequence)paramString;
      localObject = ((Collection)new kotlin.n.k(",").o((CharSequence)localObject, 0)).toArray(new String[0]);
      if (localObject == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(263941);
        throw paramString;
      }
      localObject = (String[])localObject;
      for (;;)
      {
        try
        {
          if (localObject.length == 0)
          {
            i = 1;
            break label236;
            if (i == 0) {
              continue;
            }
            this.SbH = Util.getLong(localObject[0], 0L);
            this.SbI = Util.getLong(localObject[1], 0L);
            this.SbJ = Util.getLong(localObject[2], 0L);
            this.SbK = Util.getLong(localObject[3], 0L);
            this.SbE = Util.getLong(localObject[4], 0L);
            this.SbF = Util.getLong(localObject[5], 0L);
            this.SbG = Util.getLong(localObject[6], 0L);
            AppMethodBeat.o(263941);
            return;
          }
          i = 0;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.Sport.SportKvStorage", (Throwable)localException, "fromStr:" + paramString + ' ', new Object[0]);
          AppMethodBeat.o(263941);
          return;
        }
        int i = 0;
        continue;
        label236:
        if (i == 0) {
          i = j;
        }
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(263934);
      Object localObject = am.aixg;
      localObject = String.format("%d,%d,%d,%d,%d,%d,%d", Arrays.copyOf(new Object[] { Long.valueOf(this.SbH), Long.valueOf(this.SbI), Long.valueOf(this.SbJ), Long.valueOf(this.SbK), Long.valueOf(this.SbE), Long.valueOf(this.SbF), Long.valueOf(this.SbG) }, 7));
      s.s(localObject, "java.lang.String.format(format, *args)");
      AppMethodBeat.o(263934);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.model.n
 * JD-Core Version:    0.7.0.1
 */