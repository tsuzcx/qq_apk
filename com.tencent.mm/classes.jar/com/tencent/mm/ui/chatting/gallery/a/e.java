package com.tencent.mm.ui.chatting.gallery.a;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.g;
import com.tencent.mm.f.b.a.gs;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter;", "", "()V", "fastEntryClick", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter$ImageFastEntryClick;", "fastEntryDetectStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/ImageFastEntryDetectStruct;", "searchButtonReportInfo", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter$ImageSearchButtonReportInfo;", "sessionId", "", "clickFinish", "", "clickResult", "", "clickScanButton", "iconType", "doReportSearchButtonAction", "action", "source", "timestamp", "", "initSearchButtonReportInfo", "msgId", "scene", "chatType", "username", "chatRoomId", "imagePath", "reportFastDetectEntry", "pictureConcluding", "reportFastEntryClick", "reportSearchButtonAction", "resetSearchButtonAction", "setShowIcon", "startSession", "picType", "imgInfo", "Lcom/tencent/mm/modelimage/ImgInfo;", "ChatType", "ClickResult", "Companion", "IconType", "ImageFastEntryClick", "ImageSearchButtonReportInfo", "OpenPictureType", "PictureConcluding", "app_release"})
public final class e
{
  public static final e.a WWV;
  private gs WWS;
  private b WWT;
  public e.c WWU;
  private String sessionId = "";
  
  static
  {
    AppMethodBeat.i(290956);
    WWV = new e.a((byte)0);
    AppMethodBeat.o(290956);
  }
  
  private static void a(int paramInt, long paramLong, e.c paramc)
  {
    AppMethodBeat.i(290954);
    if (paramc == null)
    {
      AppMethodBeat.o(290954);
      return;
    }
    com.tencent.e.h.ZvG.g((Runnable)new e.d(paramc, 1, paramInt, paramLong), "ReportSearchButtonAction");
    AppMethodBeat.o(290954);
  }
  
  private final void hTa()
  {
    AppMethodBeat.i(290950);
    Object localObject1 = this.WWT;
    if ((localObject1 != null) && (((b)localObject1).iUF == true))
    {
      AppMethodBeat.o(290950);
      return;
    }
    localObject1 = this.WWT;
    if (localObject1 != null) {
      ((b)localObject1).iUF = true;
    }
    localObject1 = this.WWT;
    if ((localObject1 == null) || (((b)localObject1).WWW != 1))
    {
      localObject1 = this.WWT;
      if (localObject1 != null) {
        ((b)localObject1).WWW = 2;
      }
    }
    localObject1 = this.WWT;
    if (localObject1 != null)
    {
      Log.v("MicroMsg.ImageScanButtonReporter", "reportFastEntryClick sessionId: %s, clickResult: %s, iconType: %d, clickIconTime: %s, clickFinishTime: %s, diff: %s", new Object[] { ((b)localObject1).sessionId, Integer.valueOf(((b)localObject1).WWW), Integer.valueOf(((b)localObject1).lZJ), Long.valueOf(((b)localObject1).WWX), Long.valueOf(((b)localObject1).WWY), Long.valueOf(((b)localObject1).WWY - ((b)localObject1).WWX) });
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
      String str = ((b)localObject1).sessionId;
      int i = ((b)localObject1).WWW;
      int j = ((b)localObject1).lZJ;
      long l1 = ((b)localObject1).WWX;
      long l2 = ((b)localObject1).WWY;
      localObject1 = this.WWS;
      if (localObject1 != null)
      {
        localObject1 = ((gs)localObject1).akZ();
        localObject2 = this.WWS;
        if (localObject2 == null) {
          break label320;
        }
      }
      label320:
      for (Object localObject2 = ((gs)localObject2).getAesKey();; localObject2 = null)
      {
        localh.a(19778, new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), localObject1, localObject2 });
        AppMethodBeat.o(290950);
        return;
        localObject1 = null;
        break;
      }
    }
    AppMethodBeat.o(290950);
  }
  
  public final void awp(int paramInt)
  {
    AppMethodBeat.i(290945);
    gs localgs = this.WWS;
    if ((localgs != null) && (localgs.akY() == paramInt))
    {
      localgs = this.WWS;
      if (localgs != null) {
        if (localgs.akX() != 0L) {
          break label105;
        }
      }
    }
    else
    {
      Log.v("MicroMsg.ImageScanButtonReporter", "setShowIcon iconType: %d", new Object[] { Integer.valueOf(paramInt) });
      localgs = this.WWS;
      if (localgs != null) {
        localgs.pp(paramInt);
      }
      localgs = this.WWS;
      if (localgs == null) {
        break label105;
      }
      localgs.pn(System.currentTimeMillis());
      AppMethodBeat.o(290945);
      return;
    }
    AppMethodBeat.o(290945);
    return;
    label105:
    AppMethodBeat.o(290945);
  }
  
  public final void awq(int paramInt)
  {
    AppMethodBeat.i(290947);
    Object localObject = this.WWS;
    if (localObject != null) {}
    for (localObject = ((gs)localObject).getSessionId();; localObject = null)
    {
      Log.v("MicroMsg.ImageScanButtonReporter", "reportFastDetectEntry pictureConcluding: %d, sessionId: %s", new Object[] { Integer.valueOf(paramInt), localObject });
      localObject = this.WWS;
      if (localObject != null) {
        ((gs)localObject).po(paramInt);
      }
      localObject = this.WWS;
      if (localObject == null) {
        break;
      }
      ((gs)localObject).bpa();
      AppMethodBeat.o(290947);
      return;
    }
    AppMethodBeat.o(290947);
  }
  
  public final void awr(int paramInt)
  {
    AppMethodBeat.i(290948);
    Log.i("MicroMsg.ImageScanButtonReporter", "alvinluo clickScanButton iconType: %d", new Object[] { Integer.valueOf(paramInt) });
    this.WWT = new b();
    b localb = this.WWT;
    if (localb == null) {
      p.iCn();
    }
    localb.reset();
    Object localObject = this.WWS;
    if (localObject == null) {
      p.iCn();
    }
    localObject = ((gs)localObject).getSessionId();
    p.j(localObject, "fastEntryDetectStruct!!.sessionId");
    localb.setSessionId((String)localObject);
    localb.lZJ = paramInt;
    localb.WWX = System.currentTimeMillis();
    AppMethodBeat.o(290948);
  }
  
  public final void aws(int paramInt)
  {
    AppMethodBeat.i(290949);
    Object localObject = this.WWT;
    if (localObject != null) {
      ((b)localObject).WWW = paramInt;
    }
    localObject = this.WWT;
    if (localObject != null) {
      ((b)localObject).WWY = System.currentTimeMillis();
    }
    localObject = this.WWT;
    if (localObject != null) {}
    for (localObject = Long.valueOf(((b)localObject).WWY);; localObject = null)
    {
      Log.i("MicroMsg.ImageScanButtonReporter", "alvinluo clickFinish clickResult: %d, %s", new Object[] { Integer.valueOf(paramInt), localObject });
      hTa();
      AppMethodBeat.o(290949);
      return;
    }
  }
  
  public final void awt(int paramInt)
  {
    AppMethodBeat.i(290952);
    Object localObject = this.WWU;
    if ((localObject != null) && (((e.c)localObject).msgId == 0L))
    {
      AppMethodBeat.o(290952);
      return;
    }
    String str = "1,".concat(String.valueOf(paramInt));
    localObject = this.WWU;
    if (localObject != null)
    {
      localObject = ((e.c)localObject).WXd;
      if (localObject == null) {}
    }
    for (localObject = (Boolean)((HashMap)localObject).get(str); p.h(localObject, Boolean.TRUE); localObject = null)
    {
      AppMethodBeat.o(290952);
      return;
    }
    localObject = this.WWU;
    if (localObject != null) {
      ((Map)((e.c)localObject).WXd).put(str, Boolean.TRUE);
    }
    a(paramInt, System.currentTimeMillis(), this.WWU);
    AppMethodBeat.o(290952);
  }
  
  public final void b(int paramInt, g paramg)
  {
    Object localObject2 = null;
    AppMethodBeat.i(290944);
    this.WWS = new gs();
    Log.v("MicroMsg.ImageScanButtonReporter", "startSession picType: %d", new Object[] { Integer.valueOf(paramInt) });
    gs localgs = this.WWS;
    if (localgs == null) {
      p.iCn();
    }
    localgs.pp(1L);
    localgs.po(1L);
    localgs.pl(System.currentTimeMillis());
    localgs.pm(paramInt);
    localgs.vI(z.bcZ() + "_" + localgs.akW());
    if (paramg != null) {}
    for (Object localObject1 = paramg.getFileId();; localObject1 = null)
    {
      localgs.vJ((String)localObject1);
      localObject1 = localObject2;
      if (paramg != null) {
        localObject1 = paramg.getAesKey();
      }
      localgs.vK((String)localObject1);
      paramg = localgs.getSessionId();
      p.j(paramg, "sessionId");
      this.sessionId = paramg;
      paramg = new e.c();
      paramg.WWZ = System.currentTimeMillis();
      this.WWU = paramg;
      AppMethodBeat.o(290944);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter$ImageFastEntryClick;", "", "()V", "clickFinishTimestamp", "", "getClickFinishTimestamp", "()J", "setClickFinishTimestamp", "(J)V", "clickIconTimestamp", "getClickIconTimestamp", "setClickIconTimestamp", "clickResult", "", "getClickResult", "()I", "setClickResult", "(I)V", "iconType", "getIconType", "setIconType", "isReported", "", "()Z", "setReported", "(Z)V", "sessionId", "", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "reset", "", "app_release"})
  static final class b
  {
    int WWW;
    long WWX;
    long WWY;
    boolean iUF;
    int lZJ;
    String sessionId = "";
    
    public final void reset()
    {
      this.sessionId = "";
      this.WWW = 0;
      this.lZJ = 0;
      this.WWX = 0L;
      this.WWY = 0L;
      this.iUF = false;
    }
    
    public final void setSessionId(String paramString)
    {
      AppMethodBeat.i(284862);
      p.k(paramString, "<set-?>");
      this.sessionId = paramString;
      AppMethodBeat.o(284862);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.e
 * JD-Core Version:    0.7.0.1
 */