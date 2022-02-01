package com.tencent.mm.plugin.webview.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.g.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.webview.h.b;
import com.tencent.mm.plugin.webview.h.c;
import com.tencent.mm.plugin.webview.h.d;
import com.tencent.mm.plugin.webview.h.f;
import com.tencent.mm.protocal.protobuf.ghr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/util/WebViewPrefetchTestReportUtil;", "", "()V", "TAG", "", "lastReportAction", "Lcom/tencent/mm/plugin/webview/reporter/PrefetchReportNewAction;", "lastReportActionTimestamp", "", "xwebInitFinishTimestamp", "getXwebInitFinishTimestamp", "()J", "setXwebInitFinishTimestamp", "(J)V", "clearAllStatus", "", "report", "action", "controllerInfo", "Lcom/tencent/mm/plugin/webview/reporter/PrefetchWebControllerReportInfo;", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
{
  public static final s XtJ;
  private static d XtK;
  private static long XtL;
  private static long XtM;
  
  static
  {
    AppMethodBeat.i(295700);
    XtJ = new s();
    XtK = d.WQB;
    AppMethodBeat.o(295700);
  }
  
  public static void a(d paramd, f paramf)
  {
    AppMethodBeat.i(295696);
    kotlin.g.b.s.u(paramd, "action");
    kotlin.g.b.s.u(paramf, "controllerInfo");
    Object localObject1 = MultiProcessMMKV.getMMKV("_webview_web_prefetcher_test_info");
    kotlin.g.b.s.s(localObject1, "getMMKV(ConstantsPreload…BVIEW_PREFETCH_TEST_INFO)");
    Object localObject2 = new MMKVSlotManager((MultiProcessMMKV)localObject1, 25200L);
    localObject1 = paramf.ytX;
    localObject2 = (MultiProcessMMKV)((MMKVSlotManager)localObject2).findSlot((String)localObject1);
    ghr localghr;
    int i;
    if (localObject2 == null)
    {
      localObject1 = null;
      localghr = (ghr)localObject1;
      if (localghr == null) {
        break label864;
      }
      kotlin.g.b.s.u(paramd, "action");
      if (!paramf.WQQ.contains(paramd)) {
        break label231;
      }
      paramf.WQS = true;
      iCX();
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        break label260;
      }
      Log.i("MicroMsg.WebViewPrefetchTestReportUtil", "check illegal for report!");
      AppMethodBeat.o(295696);
      return;
      if (((MultiProcessMMKV)localObject2).containsKey((String)localObject1))
      {
        localObject1 = ((MultiProcessMMKV)localObject2).decodeBytes((String)localObject1);
        if (localObject1 != null)
        {
          if (localObject1.length == 0)
          {
            i = 1;
            label159:
            if (i != 0) {
              break label202;
            }
          }
          for (i = 1;; i = 0)
          {
            for (;;)
            {
              if (i == 0) {
                break label225;
              }
              try
              {
                localObject2 = ghr.class.newInstance();
                ((a)localObject2).parseFrom((byte[])localObject1);
                localObject1 = (a)localObject2;
              }
              catch (Exception localException)
              {
                label202:
                Log.printErrStackTrace("MultiProcessMMKV.decodeProtoBuffer", (Throwable)localException, "decode ProtoBuffer", new Object[0]);
              }
            }
            i = 0;
            break label159;
          }
        }
      }
      label225:
      localb = null;
      break;
      label231:
      if (paramf.WQS)
      {
        iCX();
        i = 0;
      }
      else
      {
        paramf.WQQ.add(paramd);
        i = 1;
      }
    }
    label260:
    long l7 = 0L;
    long l8 = 0L;
    long l6 = 0L;
    long l3 = 0L;
    long l4 = 0L;
    localObject2 = d.WQB;
    b localb = b.WQs;
    long l2;
    long l1;
    long l5;
    if (paramd == d.WQC)
    {
      i = 1;
      if ((i == 0) || (paramf.WQN <= 0L)) {
        break label609;
      }
      l2 = System.currentTimeMillis() - paramf.WQN;
      l1 = System.currentTimeMillis() - paramf.WQN;
      XtK = paramd;
      XtL = System.currentTimeMillis();
      l5 = l3;
    }
    for (;;)
    {
      if (kotlin.g.b.s.p(paramf.ytX, localghr.url))
      {
        Log.d("MicroMsg.WebViewPrefetchTestReportUtil", "jr: action:" + paramd + ", bizScene:" + localghr.mUU + ", controlType:" + localghr.dQ + ", completeStatus:" + paramf.WQR + ", durationFromStart:" + l2 + ",durationFromLast:" + l1 + ", isColdBootWebView:" + localb + ", useTimeForToolInit:" + l4 + ",useTimeForConnect:" + l6 + ", useTimeForXWebInit:" + l5);
        com.tencent.mm.plugin.report.service.h.OAn.b(23214, new Object[] { Integer.valueOf(paramd.value), Integer.valueOf(localghr.mUU), Integer.valueOf(localghr.dQ), Integer.valueOf(paramf.WQR.ordinal()), Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(localb.ordinal()), Long.valueOf(l4), Long.valueOf(l6), Long.valueOf(l5), Integer.valueOf(((d)localObject2).ordinal()) });
        AppMethodBeat.o(295696);
        return;
        i = 0;
        break;
        label609:
        if ((paramd == d.WQC) || (paramd == d.WQD) || (paramd == d.WQE) || (paramd == d.WQF) || (paramd == d.WQG)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label690;
          }
          l2 = System.currentTimeMillis() - paramf.WQN;
          l1 = System.currentTimeMillis() - XtL;
          XtK = paramd;
          XtL = System.currentTimeMillis();
          l5 = l3;
          break;
        }
        label690:
        if (paramd == d.WQH)
        {
          i = 1;
          label699:
          l5 = l3;
          l1 = l8;
          l2 = l7;
          if (i == 0) {
            continue;
          }
          l6 = System.currentTimeMillis() - paramf.WQO;
          l2 = ((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).mFH.mFR - paramf.WQN;
          l1 = l2;
          if (l2 < 0L) {
            l1 = 0L;
          }
          l2 = l3;
          if (XtM > 0L)
          {
            l2 = l3;
            if (paramf.WQN > 0L)
            {
              l3 = XtM - paramf.WQN;
              l2 = l3;
              if (l3 < 0L) {
                l2 = 0L;
              }
              XtM = 0L;
            }
          }
          if ((l1 <= 0L) && (l2 <= 0L)) {
            break label856;
          }
        }
        label856:
        for (localb = b.WQt;; localb = b.WQu)
        {
          localObject2 = XtK;
          l4 = l1;
          l5 = l2;
          l1 = l8;
          l2 = l7;
          break;
          i = 0;
          break label699;
        }
      }
    }
    label864:
    AppMethodBeat.o(295696);
  }
  
  private static void iCX()
  {
    XtK = d.WQB;
    XtL = 0L;
    XtM = 0L;
  }
  
  public static void xQ(long paramLong)
  {
    XtM = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.s
 * JD-Core Version:    0.7.0.1
 */