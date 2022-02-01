package com.tencent.wxa.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/wxa/utils/WxaTimeRecorder;", "", "()V", "WxaTimeRecorder", "wxa_router_release"}, k=1, mv={1, 1, 16})
public final class b
{
  private static final HashMap<String, Long> aiea;
  private static int aieb;
  private static HashMap<Integer, HashMap<String, Long>> aiec;
  private static HashMap<Integer, HashMap<String, Boolean>> aied;
  public static final a aiee;
  
  static
  {
    AppMethodBeat.i(210469);
    aiee = new a((byte)0);
    aiea = new HashMap();
    aieb = 1000;
    aiec = new HashMap();
    aied = new HashMap();
    AppMethodBeat.o(210469);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/wxa/utils/WxaTimeRecorder$WxaTimeRecorder;", "", "()V", "TAG", "", "recordId", "", "recordKVMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "recordTimeMap", "", "startKey", "timeRecorderMap", "totalKey", "checkKeyPoint", "key", "checkKeyPointTimeRecord", "", "recodeId", "clearKVTimeRecord", "endRecord", "endTimeRecord", "getKVTimeRecord", "(ILjava/lang/String;)Ljava/lang/Boolean;", "setKVTimeRecord", "value", "startKeyPointTimeRecord", "startRecord", "startTimeRecord", "wxa_router_release"}, k=1, mv={1, 1, 16})
  public static final class a
  {
    public static void bHa(String paramString)
    {
      AppMethodBeat.i(210471);
      s.t(paramString, "key");
      ((Map)b.keW()).put(paramString, Long.valueOf(System.currentTimeMillis()));
      AppMethodBeat.o(210471);
    }
    
    public static long bHb(String paramString)
    {
      AppMethodBeat.i(210472);
      s.t(paramString, "key");
      if (b.keW().containsKey(paramString))
      {
        long l1 = System.currentTimeMillis();
        paramString = b.keW().get(paramString);
        if (paramString == null) {
          s.klw();
        }
        s.r(paramString, "timeRecorderMap[key]!!");
        long l2 = ((Number)paramString).longValue();
        AppMethodBeat.o(210472);
        return l1 - l2;
      }
      AppMethodBeat.o(210472);
      return 0L;
    }
    
    public static long bHc(String paramString)
    {
      AppMethodBeat.i(210475);
      s.t(paramString, "key");
      if (b.keW().containsKey(paramString))
      {
        Object localObject = b.keW().get(paramString);
        if (localObject == null) {
          s.klw();
        }
        s.r(localObject, "timeRecorderMap[key]!!");
        long l1 = ((Number)localObject).longValue();
        b.keW().remove(paramString);
        long l2 = System.currentTimeMillis();
        AppMethodBeat.o(210475);
        return l2 - l1;
      }
      AppMethodBeat.o(210475);
      return 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.wxa.d.b
 * JD-Core Version:    0.7.0.1
 */