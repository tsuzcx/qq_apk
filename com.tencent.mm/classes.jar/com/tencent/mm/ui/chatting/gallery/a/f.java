package com.tencent.mm.ui.chatting.gallery.a;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cp;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter;", "", "()V", "fastEntryClick", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter$ImageFastEntryClick;", "fastEntryDetectStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/ImageFastEntryDetectStruct;", "searchButtonReportInfo", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter$ImageSearchButtonReportInfo;", "sessionId", "", "clickFinish", "", "clickResult", "", "clickScanButton", "iconType", "doReportSearchButtonAction", "initSearchButtonReportInfo", "msgId", "", "scene", "chatType", "username", "chatRoomId", "imagePath", "reportFastDetectEntry", "pictureConcluding", "reportFastEntryClick", "reportSearchButtonAction", "action", "source", "setSearchSource", "setShowIcon", "startSession", "picType", "ChatType", "ClickResult", "Companion", "IconType", "ImageFastEntryClick", "ImageSearchButtonReportInfo", "OpenPictureType", "PictureConcluding", "SearchButtonAction", "SearchButtonSource", "app_release"})
public final class f
{
  public static final f.a KpQ;
  private cp KpN;
  private b KpO;
  public c KpP;
  private String sessionId = "";
  
  static
  {
    AppMethodBeat.i(188286);
    KpQ = new f.a((byte)0);
    AppMethodBeat.o(188286);
  }
  
  private final void a(final c paramc)
  {
    AppMethodBeat.i(188285);
    if (paramc == null)
    {
      AppMethodBeat.o(188285);
      return;
    }
    h.MqF.i((Runnable)new d(this, paramc), "ReportSearchButtonAction");
    AppMethodBeat.o(188285);
  }
  
  private final void fLc()
  {
    AppMethodBeat.i(188283);
    b localb = this.KpO;
    if ((localb != null) && (localb.fLk == true))
    {
      AppMethodBeat.o(188283);
      return;
    }
    localb = this.KpO;
    if (localb != null) {
      localb.fLk = true;
    }
    localb = this.KpO;
    if ((localb == null) || (localb.KpR != 1))
    {
      localb = this.KpO;
      if (localb != null) {
        localb.KpR = 2;
      }
    }
    localb = this.KpO;
    if (localb != null)
    {
      ae.v("MicroMsg.ImageScanButtonReporter", "reportFastEntryClick sessionId: %s, clickResult: %s, iconType: %d, clickIconTime: %s, clickFinishTime: %s, diff: %s", new Object[] { localb.sessionId, Integer.valueOf(localb.KpR), Integer.valueOf(localb.ioG), Long.valueOf(localb.KpS), Long.valueOf(localb.KpT), Long.valueOf(localb.KpT - localb.KpS) });
      g.yxI.f(19778, new Object[] { localb.sessionId, Integer.valueOf(localb.KpR), Integer.valueOf(localb.ioG), Long.valueOf(localb.KpS), Long.valueOf(localb.KpT) });
      AppMethodBeat.o(188283);
      return;
    }
    AppMethodBeat.o(188283);
  }
  
  public final void aeD(int paramInt)
  {
    AppMethodBeat.i(188278);
    this.KpN = new cp();
    ae.v("MicroMsg.ImageScanButtonReporter", "startSession picType: %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject = this.KpN;
    if (localObject == null) {
      p.gkB();
    }
    ((cp)localObject).ii(1L);
    ((cp)localObject).ih(1L);
    ((cp)localObject).ie(System.currentTimeMillis());
    ((cp)localObject).jdMethod_if(paramInt);
    ((cp)localObject).mg(v.aAC() + "_" + ((cp)localObject).SR());
    localObject = ((cp)localObject).getSessionId();
    p.g(localObject, "sessionId");
    this.sessionId = ((String)localObject);
    localObject = new c();
    ((c)localObject).KpU = System.currentTimeMillis();
    this.KpP = ((c)localObject);
    AppMethodBeat.o(188278);
  }
  
  public final void aeE(int paramInt)
  {
    AppMethodBeat.i(188279);
    cp localcp = this.KpN;
    if ((localcp != null) && (localcp.ST() == paramInt))
    {
      localcp = this.KpN;
      if (localcp != null) {
        if (localcp.SS() != 0L) {
          break label106;
        }
      }
    }
    else
    {
      ae.v("MicroMsg.ImageScanButtonReporter", "setShowIcon iconType: %d", new Object[] { Integer.valueOf(paramInt) });
      localcp = this.KpN;
      if (localcp != null) {
        localcp.ii(paramInt);
      }
      localcp = this.KpN;
      if (localcp == null) {
        break label106;
      }
      localcp.ig(System.currentTimeMillis());
      AppMethodBeat.o(188279);
      return;
    }
    AppMethodBeat.o(188279);
    return;
    label106:
    AppMethodBeat.o(188279);
  }
  
  public final void aeF(int paramInt)
  {
    AppMethodBeat.i(188280);
    Object localObject = this.KpN;
    if (localObject != null) {}
    for (localObject = ((cp)localObject).getSessionId();; localObject = null)
    {
      ae.v("MicroMsg.ImageScanButtonReporter", "reportFastDetectEntry pictureConcluding: %d, sessionId: %s", new Object[] { Integer.valueOf(paramInt), localObject });
      localObject = this.KpN;
      if (localObject != null) {
        ((cp)localObject).ih(paramInt);
      }
      localObject = this.KpN;
      if (localObject == null) {
        break;
      }
      ((cp)localObject).aLH();
      AppMethodBeat.o(188280);
      return;
    }
    AppMethodBeat.o(188280);
  }
  
  public final void aeG(int paramInt)
  {
    AppMethodBeat.i(188281);
    ae.i("MicroMsg.ImageScanButtonReporter", "alvinluo clickScanButton iconType: %d", new Object[] { Integer.valueOf(paramInt) });
    this.KpO = new b();
    b localb = this.KpO;
    if (localb == null) {
      p.gkB();
    }
    localb.reset();
    Object localObject = this.KpN;
    if (localObject == null) {
      p.gkB();
    }
    localObject = ((cp)localObject).getSessionId();
    p.g(localObject, "fastEntryDetectStruct!!.sessionId");
    localb.setSessionId((String)localObject);
    localb.ioG = paramInt;
    localb.KpS = System.currentTimeMillis();
    AppMethodBeat.o(188281);
  }
  
  public final void aeH(int paramInt)
  {
    AppMethodBeat.i(188282);
    Object localObject = this.KpO;
    if (localObject != null) {
      ((b)localObject).KpR = paramInt;
    }
    localObject = this.KpO;
    if (localObject != null) {
      ((b)localObject).KpT = System.currentTimeMillis();
    }
    localObject = this.KpO;
    if (localObject != null) {}
    for (localObject = Long.valueOf(((b)localObject).KpT);; localObject = null)
    {
      ae.i("MicroMsg.ImageScanButtonReporter", "alvinluo clickFinish clickResult: %d, %s", new Object[] { Integer.valueOf(paramInt), localObject });
      fLc();
      AppMethodBeat.o(188282);
      return;
    }
  }
  
  public final void jX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(188284);
    Object localObject = this.KpP;
    if ((localObject != null) && (((c)localObject).msgId == 0L))
    {
      AppMethodBeat.o(188284);
      return;
    }
    localObject = this.KpP;
    if (localObject != null)
    {
      localObject = ((c)localObject).KpX;
      if (localObject == null) {}
    }
    for (localObject = (Boolean)((HashMap)localObject).get(Integer.valueOf(paramInt1)); p.i(localObject, Boolean.TRUE); localObject = null)
    {
      AppMethodBeat.o(188284);
      return;
    }
    localObject = this.KpP;
    if (localObject != null)
    {
      ((c)localObject).action = paramInt1;
      ((c)localObject).doj = paramInt2;
      ((Map)((c)localObject).KpX).put(Integer.valueOf(paramInt1), Boolean.TRUE);
    }
    a(this.KpP);
    AppMethodBeat.o(188284);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter$ImageFastEntryClick;", "", "()V", "clickFinishTimestamp", "", "getClickFinishTimestamp", "()J", "setClickFinishTimestamp", "(J)V", "clickIconTimestamp", "getClickIconTimestamp", "setClickIconTimestamp", "clickResult", "", "getClickResult", "()I", "setClickResult", "(I)V", "iconType", "getIconType", "setIconType", "isReported", "", "()Z", "setReported", "(Z)V", "sessionId", "", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "reset", "", "app_release"})
  static final class b
  {
    int KpR;
    long KpS;
    long KpT;
    boolean fLk;
    int ioG;
    String sessionId = "";
    
    public final void reset()
    {
      this.sessionId = "";
      this.KpR = 0;
      this.ioG = 0;
      this.KpS = 0L;
      this.KpT = 0L;
      this.fLk = false;
    }
    
    public final void setSessionId(String paramString)
    {
      AppMethodBeat.i(188275);
      p.h(paramString, "<set-?>");
      this.sessionId = paramString;
      AppMethodBeat.o(188275);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter$ImageSearchButtonReportInfo;", "", "()V", "action", "", "getAction", "()I", "setAction", "(I)V", "actionReported", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getActionReported", "()Ljava/util/HashMap;", "setActionReported", "(Ljava/util/HashMap;)V", "chatRoomId", "", "getChatRoomId", "()Ljava/lang/String;", "setChatRoomId", "(Ljava/lang/String;)V", "chatType", "getChatType", "setChatType", "detectId", "", "getDetectId", "()J", "setDetectId", "(J)V", "imageMd5", "getImageMd5", "setImageMd5", "imagePath", "getImagePath", "setImagePath", "msgFromUserName", "getMsgFromUserName", "setMsgFromUserName", "msgId", "getMsgId", "setMsgId", "scene", "getScene", "setScene", "source", "getSource", "setSource", "app_release"})
  public static final class c
  {
    long KpU;
    public String KpV;
    String KpW;
    HashMap<Integer, Boolean> KpX;
    int action;
    public int chatType;
    public int doj;
    public String imagePath;
    public long msgId;
    public String pFr;
    public int scene;
    
    public c()
    {
      AppMethodBeat.i(188276);
      this.KpV = "";
      this.pFr = "";
      this.imagePath = "";
      this.KpW = "";
      this.KpX = new HashMap();
      AppMethodBeat.o(188276);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(f paramf, f.c paramc) {}
    
    public final void run()
    {
      int i = 1;
      AppMethodBeat.i(188277);
      Object localObject1 = paramc;
      Object localObject2;
      String str1;
      long l1;
      int j;
      int k;
      int m;
      long l2;
      String str2;
      int n;
      String str3;
      if (o.fB(((f.c)localObject1).imagePath))
      {
        localObject2 = aj.B(o.bb(((f.c)localObject1).imagePath, 0, -1));
        p.g(localObject2, "MD5Util.getMD5String(VFS…omFile(imagePath, 0, -1))");
        p.h(localObject2, "<set-?>");
        ((f.c)localObject1).KpW = ((String)localObject2);
        localObject2 = g.yxI;
        str1 = f.a(this.KpY);
        l1 = ((f.c)localObject1).KpU;
        j = ((f.c)localObject1).action;
        k = ((f.c)localObject1).doj;
        m = ((f.c)localObject1).scene;
        l2 = ((f.c)localObject1).msgId;
        str2 = ((f.c)localObject1).KpV;
        n = ((f.c)localObject1).chatType;
        str3 = ((f.c)localObject1).pFr;
        localObject1 = ((f.c)localObject1).KpW;
        if (!e.fLb()) {
          break label238;
        }
      }
      for (;;)
      {
        ((g)localObject2).f(20733, new Object[] { str1, Long.valueOf(l1), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Long.valueOf(l2), str2, Integer.valueOf(n), str3, localObject1, Integer.valueOf(i) });
        AppMethodBeat.o(188277);
        return;
        label238:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.f
 * JD-Core Version:    0.7.0.1
 */