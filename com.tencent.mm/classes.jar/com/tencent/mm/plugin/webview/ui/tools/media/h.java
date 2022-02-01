package com.tencent.mm.plugin.webview.ui.tools.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.y;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.bw.a;
import com.tencent.mm.g.b.a.df;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.es;
import com.tencent.mm.protocal.protobuf.et;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.protocal.protobuf.ev;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "", "()V", "_realPlayTime", "", "get_realPlayTime", "()J", "set_realPlayTime", "(J)V", "endPlayTime", "", "getEndPlayTime", "()I", "setEndPlayTime", "(I)V", "isFans", "", "()Z", "setFans", "(Z)V", "lastOpType", "playErrType", "", "getPlayErrType", "()Ljava/lang/String;", "setPlayErrType", "(Ljava/lang/String;)V", "playStatus", "getPlayStatus", "setPlayStatus", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "scene", "getScene", "setScene", "startPlayTime", "getStartPlayTime", "setStartPlayTime", "stayTimeInPage", "getStayTimeInPage", "setStayTimeInPage", "subScene", "getSubScene", "setSubScene", "doPlayReport", "", "doStopReport", "getPlayType", "report17149", "videoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "opType", "enterId", "itemShowType", "Companion", "KV17149OpType", "PlayStatus", "plugin-webview_release"})
public class h
{
  public static final a EHf;
  private static final String TAG = "MicroMsg.MpVideoShareReport";
  private int EHe;
  private long hOz;
  public int iuK;
  protected int otZ;
  protected int oxX;
  protected int oxY;
  public String oxZ;
  protected boolean oya;
  protected int scene;
  private long szE;
  
  static
  {
    AppMethodBeat.i(82685);
    EHf = new a((byte)0);
    TAG = "MicroMsg.MpVideoShareReport";
    AppMethodBeat.o(82685);
  }
  
  public h()
  {
    AppMethodBeat.i(82684);
    this.hOz = System.currentTimeMillis();
    this.oxZ = "";
    AppMethodBeat.o(82684);
  }
  
  public final void a(y paramy, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82683);
    if (paramy == null)
    {
      AppMethodBeat.o(82683);
      return;
    }
    if (this.EHe == paramInt1)
    {
      AppMethodBeat.o(82683);
      return;
    }
    this.EHe = paramInt1;
    paramy.azu();
    String str1;
    String str2;
    label132:
    long l;
    switch (paramInt1)
    {
    case 5: 
    case 6: 
    default: 
      if (paramInt1 == 3)
      {
        str1 = paramy.FUx;
        p.g(str1, "videoInfo.videoVid");
        str2 = paramy.FUw;
        p.g(str2, "videoInfo.mpUrl");
        a.b(0, str1, str2, this.otZ, paramInt2);
        int j = m.abf();
        int i = j;
        if (j == 100) {
          i = -1;
        }
        paramy = new df().mL(paramy.dpP).jE(paramInt1).mM(paramy.FUx).iF(i).jA(paramy.hGH).jB(paramy.idx).jC(paramInt2).jD(paramy.videoDuration).jJ(this.scene).jK(this.otZ).jN(paramy.width).jM(paramy.height).Td();
        if ((this.szE == 0L) && (this.hOz != 0L)) {
          this.szE = (System.currentTimeMillis() - this.hOz);
        }
        paramy = paramy.jG(this.szE).jI(this.oxY).jF(System.currentTimeMillis() / 1000L).jH(this.oxX).mN(this.oxZ).Tb();
        if (!this.oya) {
          break label525;
        }
        l = 1L;
        label331:
        paramy.jL(l).Tc().aLH();
        ae.d(TAG, "eventType: ".concat(String.valueOf(paramInt1)));
        switch (paramInt1)
        {
        }
      }
      break;
    }
    for (;;)
    {
      AppMethodBeat.o(82683);
      return;
      this.hOz = System.currentTimeMillis();
      break;
      l = System.currentTimeMillis();
      this.szE += l - this.hOz;
      this.hOz = l;
      break;
      if (paramInt1 == 4)
      {
        str1 = paramy.FUx;
        p.g(str1, "videoInfo.videoVid");
        str2 = paramy.FUw;
        p.g(str2, "videoInfo.mpUrl");
        a.b(1, str1, str2, this.otZ, paramInt2);
        break label132;
      }
      if (paramInt1 != 10) {
        break label132;
      }
      str1 = paramy.FUx;
      p.g(str1, "videoInfo.videoVid");
      str2 = paramy.FUw;
      p.g(str2, "videoInfo.mpUrl");
      a.b(2, str1, str2, this.otZ, paramInt2);
      break label132;
      label525:
      l = 0L;
      break label331;
      this.szE = 0L;
      this.hOz = System.currentTimeMillis();
      this.oxY = 0;
    }
  }
  
  public final int eYQ()
  {
    switch (this.iuK)
    {
    case 0: 
    default: 
      return 3;
    case 1: 
      return 4;
    case 2: 
      return 8;
    case 3: 
      return 9;
    }
    return 10;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport$Companion;", "", "()V", "ACTION_TYPE_FRIEND", "", "ACTION_TYPE_SNS", "REPORT_TYPE_10380", "REPORT_TYPE_10945", "REPORT_TYPE_17537", "SHARE_TYPE_MP_VIDEO", "TAG", "", "addCommReportItem", "", "key", "value", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommReportItem;", "doAppMsgCommDataReport", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReportReq;", "logReportData", "kv", "report10380", "actionType", "sharePageType", "vid", "url", "timeLineSessionId", "enterId", "report17537", "eventType", "scene", "subScene", "plugin-webview_release"})
  public static final class a
  {
    private static void a(et paramet)
    {
      AppMethodBeat.i(82678);
      b.a locala = new b.a();
      locala.c((a)paramet);
      locala.d((a)new eu());
      locala.DN("/cgi-bin/mmbiz-bin/appmsg/appmsg_report");
      locala.oS(1870);
      locala.oU(0);
      locala.oV(0);
      IPCRunCgi.a(locala.aDS(), (IPCRunCgi.a)h.a.a.EHg);
      AppMethodBeat.o(82678);
    }
    
    private static void a(String paramString1, String paramString2, LinkedList<ev> paramLinkedList)
    {
      AppMethodBeat.i(82682);
      ev localev = new ev();
      localev.key = paramString1;
      localev.hKR = paramString2;
      paramLinkedList.add(localev);
      AppMethodBeat.o(82682);
    }
    
    public static void b(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(82680);
      p.h(paramString1, "vid");
      p.h(paramString2, "url");
      et localet = new et();
      es locales = new es();
      locales.type = 3;
      LinkedList localLinkedList = locales.FLq;
      p.g(localLinkedList, "reportData.item");
      a("#AppMsgUrl#", paramString2, localLinkedList);
      paramString2 = locales.FLq;
      p.g(paramString2, "reportData.item");
      a("VideoId", paramString1, paramString2);
      paramString1 = locales.FLq;
      p.g(paramString1, "reportData.item");
      a("Scene", "141", paramString1);
      paramString1 = locales.FLq;
      p.g(paramString1, "reportData.item");
      a("SubScene", String.valueOf(paramInt2), paramString1);
      long l = System.currentTimeMillis();
      paramString1 = locales.FLq;
      p.g(paramString1, "reportData.item");
      a("ClientId", String.valueOf(l), paramString1);
      paramString1 = locales.FLq;
      p.g(paramString1, "reportData.item");
      a("SessionId", "0", paramString1);
      paramString1 = locales.FLq;
      p.g(paramString1, "reportData.item");
      a("EnterId", String.valueOf(paramInt3), paramString1);
      paramString1 = locales.FLq;
      p.g(paramString1, "reportData.item");
      a("EventType", String.valueOf(paramInt1), paramString1);
      localet.FOY.add(locales);
      a(localet);
      paramString1 = locales.FLq;
      p.g(paramString1, "reportData.item");
      b(17537, paramString1);
      AppMethodBeat.o(82680);
    }
    
    private static void b(int paramInt, LinkedList<ev> paramLinkedList)
    {
      AppMethodBeat.i(82681);
      if ((ae.getLogLevel() <= 0) && (!bu.ht((List)paramLinkedList)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext())
        {
          ev localev = (ev)paramLinkedList.next();
          localStringBuilder.append(localev.key).append(":").append(localev.hKR).append("  ");
        }
        ae.v(h.access$getTAG$cp(), paramInt + ", " + localStringBuilder);
      }
      AppMethodBeat.o(82681);
    }
    
    public static void i(int paramInt1, String paramString1, String paramString2, int paramInt2)
    {
      AppMethodBeat.i(199371);
      p.h(paramString1, "vid");
      p.h(paramString2, "url");
      et localet = new et();
      es locales = new es();
      locales.type = 2;
      LinkedList localLinkedList = locales.FLq;
      p.g(localLinkedList, "reportData.item");
      a("Vid", paramString1, localLinkedList);
      paramString1 = az.iW(ak.getContext());
      localLinkedList = locales.FLq;
      p.g(localLinkedList, "reportData.item");
      a("Network", paramString1, localLinkedList);
      paramString1 = locales.FLq;
      p.g(paramString1, "reportData.item");
      a("SharePageType", "101", paramString1);
      paramString1 = locales.FLq;
      p.g(paramString1, "reportData.item");
      a("ContentUrl", paramString2, paramString1);
      paramString1 = locales.FLq;
      p.g(paramString1, "reportData.item");
      a("#AppMsgUrl#", paramString2, paramString1);
      paramString1 = locales.FLq;
      p.g(paramString1, "reportData.item");
      a("ActionType", String.valueOf(paramInt1), paramString1);
      paramString1 = locales.FLq;
      p.g(paramString1, "reportData.item");
      a("SessionId", "0", paramString1);
      paramString1 = locales.FLq;
      p.g(paramString1, "reportData.item");
      a("EnterId", String.valueOf(paramInt2), paramString1);
      localet.FOY.add(locales);
      a(localet);
      paramString1 = locales.FLq;
      p.g(paramString1, "reportData.item");
      b(10380, paramString1);
      AppMethodBeat.o(199371);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.h
 * JD-Core Version:    0.7.0.1
 */