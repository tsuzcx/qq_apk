package com.tencent.mm.plugin.webview.ui.tools.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.y;
import com.tencent.mm.al.b.a;
import com.tencent.mm.bx.a;
import com.tencent.mm.g.b.a.df;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.es;
import com.tencent.mm.protocal.protobuf.et;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.protocal.protobuf.ev;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport;", "", "()V", "_realPlayTime", "", "get_realPlayTime", "()J", "set_realPlayTime", "(J)V", "endPlayTime", "", "getEndPlayTime", "()I", "setEndPlayTime", "(I)V", "isFans", "", "()Z", "setFans", "(Z)V", "lastOpType", "playErrType", "", "getPlayErrType", "()Ljava/lang/String;", "setPlayErrType", "(Ljava/lang/String;)V", "playStatus", "getPlayStatus", "setPlayStatus", "realPlayTime", "getRealPlayTime", "setRealPlayTime", "scene", "getScene", "setScene", "startPlayTime", "getStartPlayTime", "setStartPlayTime", "stayTimeInPage", "getStayTimeInPage", "setStayTimeInPage", "subScene", "getSubScene", "setSubScene", "doPlayReport", "", "doStopReport", "getPlayType", "report17149", "videoInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "opType", "enterId", "itemShowType", "Companion", "KV17149OpType", "PlayStatus", "plugin-webview_release"})
public class h
{
  public static final a Epa;
  private static final String TAG = "MicroMsg.MpVideoShareReport";
  private int EoZ;
  private long hLG;
  public int irQ;
  protected int ooi;
  protected int orB;
  protected int orC;
  public String orD;
  protected boolean orE;
  protected int scene;
  private long spt;
  
  static
  {
    AppMethodBeat.i(82685);
    Epa = new a((byte)0);
    TAG = "MicroMsg.MpVideoShareReport";
    AppMethodBeat.o(82685);
  }
  
  public h()
  {
    AppMethodBeat.i(82684);
    this.hLG = System.currentTimeMillis();
    this.orD = "";
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
    if (this.EoZ == paramInt1)
    {
      AppMethodBeat.o(82683);
      return;
    }
    this.EoZ = paramInt1;
    paramy.azf();
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
        str1 = paramy.FCc;
        p.g(str1, "videoInfo.videoVid");
        str2 = paramy.FCb;
        p.g(str2, "videoInfo.mpUrl");
        a.b(0, str1, str2, this.ooi, paramInt2);
        int j = m.aaW();
        int i = j;
        if (j == 100) {
          i = -1;
        }
        paramy = new df().mt(paramy.doK).ju(paramInt1).mu(paramy.FCc).iD(i).jq(paramy.hDP).jr(paramy.idx).js(paramInt2).jt(paramy.videoDuration).jz(this.scene).jA(this.ooi).jD(paramy.width).jC(paramy.height).SX();
        if ((this.spt == 0L) && (this.hLG != 0L)) {
          this.spt = (System.currentTimeMillis() - this.hLG);
        }
        paramy = paramy.jw(this.spt).jy(this.orC).jv(System.currentTimeMillis() / 1000L).jx(this.orB).mv(this.orD).SV();
        if (!this.orE) {
          break label525;
        }
        l = 1L;
        label331:
        paramy.jB(l).SW().aLk();
        ad.d(TAG, "eventType: ".concat(String.valueOf(paramInt1)));
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
      this.hLG = System.currentTimeMillis();
      break;
      l = System.currentTimeMillis();
      this.spt += l - this.hLG;
      this.hLG = l;
      break;
      if (paramInt1 == 4)
      {
        str1 = paramy.FCc;
        p.g(str1, "videoInfo.videoVid");
        str2 = paramy.FCb;
        p.g(str2, "videoInfo.mpUrl");
        a.b(1, str1, str2, this.ooi, paramInt2);
        break label132;
      }
      if (paramInt1 != 10) {
        break label132;
      }
      str1 = paramy.FCc;
      p.g(str1, "videoInfo.videoVid");
      str2 = paramy.FCb;
      p.g(str2, "videoInfo.mpUrl");
      a.b(2, str1, str2, this.ooi, paramInt2);
      break label132;
      label525:
      l = 0L;
      break label331;
      this.spt = 0L;
      this.hLG = System.currentTimeMillis();
      this.orC = 0;
    }
  }
  
  public final int eVd()
  {
    switch (this.irQ)
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoShareReport$Companion;", "", "()V", "ACTION_TYPE_FRIEND", "", "ACTION_TYPE_SNS", "REPORT_TYPE_10380", "REPORT_TYPE_10945", "REPORT_TYPE_17537", "SHARE_TYPE_MP_VIDEO", "TAG", "", "addCommReportItem", "", "key", "value", "items", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommReportItem;", "doAppMsgCommDataReport", "req", "Lcom/tencent/mm/protocal/protobuf/AppMsgCommDataReportReq;", "logReportData", "kv", "report10380", "actionType", "sharePageType", "vid", "url", "timeLineSessionId", "enterId", "report17537", "eventType", "scene", "subScene", "plugin-webview_release"})
  public static final class a
  {
    private static void a(et paramet)
    {
      AppMethodBeat.i(82678);
      b.a locala = new b.a();
      locala.c((a)paramet);
      locala.d((a)new eu());
      locala.Dl("/cgi-bin/mmbiz-bin/appmsg/appmsg_report");
      locala.oP(1870);
      locala.oR(0);
      locala.oS(0);
      IPCRunCgi.a(locala.aDC(), (IPCRunCgi.a)h.a.a.Epb);
      AppMethodBeat.o(82678);
    }
    
    private static void a(String paramString1, String paramString2, LinkedList<ev> paramLinkedList)
    {
      AppMethodBeat.i(82682);
      ev localev = new ev();
      localev.key = paramString1;
      localev.hHZ = paramString2;
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
      LinkedList localLinkedList = locales.FsS;
      p.g(localLinkedList, "reportData.item");
      a("#AppMsgUrl#", paramString2, localLinkedList);
      paramString2 = locales.FsS;
      p.g(paramString2, "reportData.item");
      a("VideoId", paramString1, paramString2);
      paramString1 = locales.FsS;
      p.g(paramString1, "reportData.item");
      a("Scene", "141", paramString1);
      paramString1 = locales.FsS;
      p.g(paramString1, "reportData.item");
      a("SubScene", String.valueOf(paramInt2), paramString1);
      long l = System.currentTimeMillis();
      paramString1 = locales.FsS;
      p.g(paramString1, "reportData.item");
      a("ClientId", String.valueOf(l), paramString1);
      paramString1 = locales.FsS;
      p.g(paramString1, "reportData.item");
      a("SessionId", "0", paramString1);
      paramString1 = locales.FsS;
      p.g(paramString1, "reportData.item");
      a("EnterId", String.valueOf(paramInt3), paramString1);
      paramString1 = locales.FsS;
      p.g(paramString1, "reportData.item");
      a("EventType", String.valueOf(paramInt1), paramString1);
      localet.FwA.add(locales);
      a(localet);
      paramString1 = locales.FsS;
      p.g(paramString1, "reportData.item");
      b(17537, paramString1);
      AppMethodBeat.o(82680);
    }
    
    private static void b(int paramInt, LinkedList<ev> paramLinkedList)
    {
      AppMethodBeat.i(82681);
      if ((ad.getLogLevel() <= 0) && (!bt.hj((List)paramLinkedList)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        paramLinkedList = paramLinkedList.iterator();
        while (paramLinkedList.hasNext())
        {
          ev localev = (ev)paramLinkedList.next();
          localStringBuilder.append(localev.key).append(":").append(localev.hHZ).append("  ");
        }
        ad.v(h.access$getTAG$cp(), paramInt + ", " + localStringBuilder);
      }
      AppMethodBeat.o(82681);
    }
    
    public static void i(int paramInt1, String paramString1, String paramString2, int paramInt2)
    {
      AppMethodBeat.i(207613);
      p.h(paramString1, "vid");
      p.h(paramString2, "url");
      et localet = new et();
      es locales = new es();
      locales.type = 2;
      LinkedList localLinkedList = locales.FsS;
      p.g(localLinkedList, "reportData.item");
      a("Vid", paramString1, localLinkedList);
      paramString1 = ay.iR(aj.getContext());
      localLinkedList = locales.FsS;
      p.g(localLinkedList, "reportData.item");
      a("Network", paramString1, localLinkedList);
      paramString1 = locales.FsS;
      p.g(paramString1, "reportData.item");
      a("SharePageType", "101", paramString1);
      paramString1 = locales.FsS;
      p.g(paramString1, "reportData.item");
      a("ContentUrl", paramString2, paramString1);
      paramString1 = locales.FsS;
      p.g(paramString1, "reportData.item");
      a("#AppMsgUrl#", paramString2, paramString1);
      paramString1 = locales.FsS;
      p.g(paramString1, "reportData.item");
      a("ActionType", String.valueOf(paramInt1), paramString1);
      paramString1 = locales.FsS;
      p.g(paramString1, "reportData.item");
      a("SessionId", "0", paramString1);
      paramString1 = locales.FsS;
      p.g(paramString1, "reportData.item");
      a("EnterId", String.valueOf(paramInt2), paramString1);
      localet.FwA.add(locales);
      a(localet);
      paramString1 = locales.FsS;
      p.g(paramString1, "reportData.item");
      b(10380, paramString1);
      AppMethodBeat.o(207613);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.media.h
 * JD-Core Version:    0.7.0.1
 */