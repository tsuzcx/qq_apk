package com.tencent.mm.plugin.webview.ui.tools.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.protocal.protobuf.fv;
import com.tencent.mm.protocal.protobuf.fw;
import com.tencent.mm.protocal.protobuf.fx;
import com.tencent.mm.protocal.protobuf.fy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport$Companion;", "", "()V", "ACTION_TYPE_FRIEND", "", "ACTION_TYPE_SNS", "REPORT_TYPE_10380", "REPORT_TYPE_10945", "REPORT_TYPE_17537", "SHARE_TYPE_MP_VIDEO", "TAG", "", "addCommReportItem", "", "key", "value", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommReportItem;", "doAppMsgCommDataReport", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReportReq;", "logReportData", "kv", "report10380", "actionType", "sharePageType", "vid", "url", "timeLineSessionId", "enterId", "report17537", "eventType", "scene", "subScene", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g$a
{
  private static void a(fw paramfw)
  {
    AppMethodBeat.i(82678);
    c.a locala = new c.a();
    locala.otE = ((a)paramfw);
    locala.otF = ((a)new fx());
    locala.uri = "/cgi-bin/mmbiz-bin/appmsg/appmsg_report";
    locala.funcId = 1870;
    locala.otG = 0;
    locala.respCmdId = 0;
    IPCRunCgi.a(locala.bEF(), g.a..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(82678);
  }
  
  public static void b(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(82680);
    s.u(paramString1, "vid");
    s.u(paramString2, "url");
    fw localfw = new fw();
    fv localfv = new fv();
    localfv.type = 3;
    LinkedList localLinkedList = localfv.YCW;
    s.s(localLinkedList, "reportData.item");
    b("#AppMsgUrl#", paramString2, localLinkedList);
    paramString2 = localfv.YCW;
    s.s(paramString2, "reportData.item");
    b("VideoId", paramString1, paramString2);
    paramString1 = localfv.YCW;
    s.s(paramString1, "reportData.item");
    b("Scene", "141", paramString1);
    paramString1 = localfv.YCW;
    s.s(paramString1, "reportData.item");
    b("SubScene", String.valueOf(paramInt2), paramString1);
    long l = System.currentTimeMillis();
    paramString1 = localfv.YCW;
    s.s(paramString1, "reportData.item");
    b("ClientId", String.valueOf(l), paramString1);
    paramString1 = s.X("", Integer.valueOf(0));
    paramString2 = localfv.YCW;
    s.s(paramString2, "reportData.item");
    b("SessionId", paramString1, paramString2);
    paramString1 = localfv.YCW;
    s.s(paramString1, "reportData.item");
    b("EnterId", String.valueOf(paramInt3), paramString1);
    paramString1 = localfv.YCW;
    s.s(paramString1, "reportData.item");
    b("EventType", String.valueOf(paramInt1), paramString1);
    localfw.YHr.add(localfv);
    a(localfw);
    paramString1 = localfv.YCW;
    s.s(paramString1, "reportData.item");
    e(17537, paramString1);
    AppMethodBeat.o(82680);
  }
  
  private static void b(String paramString1, String paramString2, LinkedList<fy> paramLinkedList)
  {
    AppMethodBeat.i(82682);
    fy localfy = new fy();
    localfy.key = paramString1;
    localfy.onf = paramString2;
    paramLinkedList.add(localfy);
    AppMethodBeat.o(82682);
  }
  
  private static final void c(int paramInt1, int paramInt2, String paramString, c paramc)
  {
    AppMethodBeat.i(296708);
    Log.i(g.access$getTAG$cp(), "appmsg_report errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    AppMethodBeat.o(296708);
  }
  
  private static void e(int paramInt, LinkedList<fy> paramLinkedList)
  {
    AppMethodBeat.i(82681);
    if ((Log.getLogLevel() <= 0) && (!Util.isNullOrNil((List)paramLinkedList)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        fy localfy = (fy)paramLinkedList.next();
        localStringBuilder.append(localfy.key).append(":").append(localfy.onf).append("  ");
      }
      Log.v(g.access$getTAG$cp(), paramInt + ", " + localStringBuilder);
    }
    AppMethodBeat.o(82681);
  }
  
  public static void h(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(296692);
    s.u(paramString1, "vid");
    s.u(paramString2, "url");
    fw localfw = new fw();
    fv localfv = new fv();
    localfv.type = 2;
    LinkedList localLinkedList = localfv.YCW;
    s.s(localLinkedList, "reportData.item");
    b("Vid", paramString1, localLinkedList);
    paramString1 = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
    localLinkedList = localfv.YCW;
    s.s(localLinkedList, "reportData.item");
    b("Network", paramString1, localLinkedList);
    paramString1 = localfv.YCW;
    s.s(paramString1, "reportData.item");
    b("SharePageType", "101", paramString1);
    paramString1 = localfv.YCW;
    s.s(paramString1, "reportData.item");
    b("ContentUrl", paramString2, paramString1);
    paramString1 = localfv.YCW;
    s.s(paramString1, "reportData.item");
    b("#AppMsgUrl#", paramString2, paramString1);
    paramString1 = localfv.YCW;
    s.s(paramString1, "reportData.item");
    b("ActionType", String.valueOf(paramInt1), paramString1);
    paramString1 = s.X("", Integer.valueOf(0));
    paramString2 = localfv.YCW;
    s.s(paramString2, "reportData.item");
    b("SessionId", paramString1, paramString2);
    paramString1 = localfv.YCW;
    s.s(paramString1, "reportData.item");
    b("EnterId", String.valueOf(paramInt2), paramString1);
    localfw.YHr.add(localfv);
    a(localfw);
    paramString1 = localfv.YCW;
    s.s(paramString1, "reportData.item");
    e(10380, paramString1);
    AppMethodBeat.o(296692);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.g.a
 * JD-Core Version:    0.7.0.1
 */