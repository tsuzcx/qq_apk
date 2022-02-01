package com.tencent.mm.plugin.webview.ui.tools.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.fb;
import com.tencent.mm.protocal.protobuf.fc;
import com.tencent.mm.protocal.protobuf.fd;
import com.tencent.mm.protocal.protobuf.fe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport$Companion;", "", "()V", "ACTION_TYPE_FRIEND", "", "ACTION_TYPE_SNS", "REPORT_TYPE_10380", "REPORT_TYPE_10945", "REPORT_TYPE_17537", "SHARE_TYPE_MP_VIDEO", "TAG", "", "addCommReportItem", "", "key", "value", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommReportItem;", "doAppMsgCommDataReport", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReportReq;", "logReportData", "kv", "report10380", "actionType", "sharePageType", "vid", "url", "timeLineSessionId", "enterId", "report17537", "eventType", "scene", "subScene", "plugin-webview_release"})
public final class h$a
{
  private static void a(fc paramfc)
  {
    AppMethodBeat.i(82678);
    d.a locala = new d.a();
    locala.c((a)paramfc);
    locala.d((a)new fd());
    locala.TW("/cgi-bin/mmbiz-bin/appmsg/appmsg_report");
    locala.vD(1870);
    locala.vF(0);
    locala.vG(0);
    IPCRunCgi.a(locala.bgN(), (IPCRunCgi.a)a.Quz);
    AppMethodBeat.o(82678);
  }
  
  public static void b(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(82680);
    p.k(paramString1, "vid");
    p.k(paramString2, "url");
    fc localfc = new fc();
    fb localfb = new fb();
    localfb.type = 3;
    LinkedList localLinkedList = localfb.RGi;
    p.j(localLinkedList, "reportData.item");
    b("#AppMsgUrl#", paramString2, localLinkedList);
    paramString2 = localfb.RGi;
    p.j(paramString2, "reportData.item");
    b("VideoId", paramString1, paramString2);
    paramString1 = localfb.RGi;
    p.j(paramString1, "reportData.item");
    b("Scene", "141", paramString1);
    paramString1 = localfb.RGi;
    p.j(paramString1, "reportData.item");
    b("SubScene", String.valueOf(paramInt2), paramString1);
    long l = System.currentTimeMillis();
    paramString1 = localfb.RGi;
    p.j(paramString1, "reportData.item");
    b("ClientId", String.valueOf(l), paramString1);
    paramString1 = localfb.RGi;
    p.j(paramString1, "reportData.item");
    b("SessionId", "0", paramString1);
    paramString1 = localfb.RGi;
    p.j(paramString1, "reportData.item");
    b("EnterId", String.valueOf(paramInt3), paramString1);
    paramString1 = localfb.RGi;
    p.j(paramString1, "reportData.item");
    b("EventType", String.valueOf(paramInt1), paramString1);
    localfc.RJX.add(localfb);
    a(localfc);
    paramString1 = localfb.RGi;
    p.j(paramString1, "reportData.item");
    f(17537, paramString1);
    AppMethodBeat.o(82680);
  }
  
  private static void b(String paramString1, String paramString2, LinkedList<fe> paramLinkedList)
  {
    AppMethodBeat.i(82682);
    fe localfe = new fe();
    localfe.key = paramString1;
    localfe.lvH = paramString2;
    paramLinkedList.add(localfe);
    AppMethodBeat.o(82682);
  }
  
  private static void f(int paramInt, LinkedList<fe> paramLinkedList)
  {
    AppMethodBeat.i(82681);
    if ((Log.getLogLevel() <= 0) && (!Util.isNullOrNil((List)paramLinkedList)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        fe localfe = (fe)paramLinkedList.next();
        localStringBuilder.append(localfe.key).append(":").append(localfe.lvH).append("  ");
      }
      Log.v(h.access$getTAG$cp(), paramInt + ", " + localStringBuilder);
    }
    AppMethodBeat.o(82681);
  }
  
  public static void i(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(220488);
    p.k(paramString1, "vid");
    p.k(paramString2, "url");
    fc localfc = new fc();
    fb localfb = new fb();
    localfb.type = 2;
    LinkedList localLinkedList = localfb.RGi;
    p.j(localLinkedList, "reportData.item");
    b("Vid", paramString1, localLinkedList);
    paramString1 = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
    localLinkedList = localfb.RGi;
    p.j(localLinkedList, "reportData.item");
    b("Network", paramString1, localLinkedList);
    paramString1 = localfb.RGi;
    p.j(paramString1, "reportData.item");
    b("SharePageType", "101", paramString1);
    paramString1 = localfb.RGi;
    p.j(paramString1, "reportData.item");
    b("ContentUrl", paramString2, paramString1);
    paramString1 = localfb.RGi;
    p.j(paramString1, "reportData.item");
    b("#AppMsgUrl#", paramString2, paramString1);
    paramString1 = localfb.RGi;
    p.j(paramString1, "reportData.item");
    b("ActionType", String.valueOf(paramInt1), paramString1);
    paramString1 = localfb.RGi;
    p.j(paramString1, "reportData.item");
    b("SessionId", "0", paramString1);
    paramString1 = localfb.RGi;
    p.j(paramString1, "reportData.item");
    b("EnterId", String.valueOf(paramInt2), paramString1);
    localfc.RJX.add(localfb);
    a(localfc);
    paramString1 = localfb.RGi;
    p.j(paramString1, "reportData.item");
    f(10380, paramString1);
    AppMethodBeat.o(220488);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class a
    implements IPCRunCgi.a
  {
    public static final a Quz;
    
    static
    {
      AppMethodBeat.i(82677);
      Quz = new a();
      AppMethodBeat.o(82677);
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, d paramd)
    {
      AppMethodBeat.i(82676);
      Log.i(h.access$getTAG$cp(), "appmsg_report errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      AppMethodBeat.o(82676);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.h.a
 * JD-Core Version:    0.7.0.1
 */