package com.tencent.mm.plugin.webview.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.i.c;
import com.tencent.mm.plugin.webview.i.d;
import com.tencent.mm.protocal.protobuf.fld;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/util/WebViewPrefetchTestReportUtil;", "", "()V", "TAG", "", "reportFromKV", "", "preProcessCompletion", "url", "action", "Lcom/tencent/mm/plugin/webview/reporter/PrefetchReportNewAction;", "meetPrecondition", "prefetchComplete", "Lcom/tencent/mm/plugin/webview/reporter/PrefetchProcessCompletion;", "clickStartTime", "", "webview-sdk_release"})
public final class o
{
  public static final o QAC;
  
  static
  {
    AppMethodBeat.i(206586);
    QAC = new o();
    AppMethodBeat.o(206586);
  }
  
  public static boolean a(boolean paramBoolean, String paramString, d paramd, c paramc, long paramLong)
  {
    AppMethodBeat.i(206585);
    p.k(paramString, "url");
    p.k(paramd, "action");
    p.k(paramc, "prefetchComplete");
    if ((!paramBoolean) && (paramd != d.PZK))
    {
      AppMethodBeat.o(206585);
      return false;
    }
    Object localObject1 = MultiProcessMMKV.getMMKV("_webview_web_prefetcher_test_info");
    p.j(localObject1, "MultiProcessMMKV.getMMKV…BVIEW_PREFETCH_TEST_INFO)");
    localObject1 = (MultiProcessMMKV)new MMKVSlotManager((MultiProcessMMKV)localObject1, 25200L).findSlot(paramString);
    int i;
    if (localObject1 != null) {
      if (((MultiProcessMMKV)localObject1).containsKey(paramString))
      {
        localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes(paramString);
        if (localObject1 != null) {
          if (localObject1.length == 0)
          {
            i = 1;
            if (i != 0) {
              break label268;
            }
            i = 1;
            label120:
            if (i == 0) {
              break label292;
            }
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        Object localObject3 = fld.class.newInstance();
        ((a)localObject3).parseFrom((byte[])localObject1);
        localObject1 = (a)localObject3;
        localObject1 = (fld)localObject1;
        if (localObject1 == null) {
          break label304;
        }
        long l = 0L;
        if (paramLong > 0L) {
          l = System.currentTimeMillis() - paramLong;
        }
        if (!p.h(paramString, ((fld)localObject1).url)) {
          break label304;
        }
        h.IzE.a(23214, new Object[] { Integer.valueOf(paramd.ordinal()), Integer.valueOf(((fld)localObject1).kqZ), Integer.valueOf(((fld)localObject1).dQ), Integer.valueOf(paramc.ordinal()), Long.valueOf(l) });
        AppMethodBeat.o(206585);
        return true;
      }
      catch (Exception localException)
      {
        label268:
        Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
      }
      i = 0;
      break;
      i = 0;
      break label120;
      label292:
      Object localObject2 = null;
      continue;
      localObject2 = null;
    }
    label304:
    AppMethodBeat.o(206585);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.o
 * JD-Core Version:    0.7.0.1
 */