package com.tencent.mm.ui.chatting.gallery.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cp;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter;", "", "()V", "fastEntryClick", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter$ImageFastEntryClick;", "fastEntryDetectStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/ImageFastEntryDetectStruct;", "sessionId", "", "clickFinish", "", "clickResult", "", "clickScanButton", "iconType", "reportFastDetectEntry", "pictureConcluding", "reportFastEntryClick", "setShowIcon", "startSession", "picType", "ClickResult", "Companion", "IconType", "ImageFastEntryClick", "OpenPictureType", "PictureConcluding", "app_release"})
public final class b
{
  public static final b.a JUj;
  private cp JRW;
  private b JUi;
  private String sessionId = "";
  
  static
  {
    AppMethodBeat.i(194871);
    JUj = new b.a((byte)0);
    AppMethodBeat.o(194871);
  }
  
  private final void fGO()
  {
    AppMethodBeat.i(194870);
    b localb = this.JUi;
    if ((localb != null) && (localb.fJh == true))
    {
      AppMethodBeat.o(194870);
      return;
    }
    localb = this.JUi;
    if (localb != null) {
      localb.fJh = true;
    }
    localb = this.JUi;
    if ((localb == null) || (localb.JUk != 1))
    {
      localb = this.JUi;
      if (localb != null) {
        localb.JUk = 2;
      }
    }
    localb = this.JUi;
    if (localb != null)
    {
      ad.v("MicroMsg.ImageScanButtonReporter", "reportFastEntryClick sessionId: %s, clickResult: %s, iconType: %d, clickIconTime: %s, clickFinishTime: %s, diff: %s", new Object[] { localb.sessionId, Integer.valueOf(localb.JUk), Integer.valueOf(localb.ilN), Long.valueOf(localb.JUl), Long.valueOf(localb.JUm), Long.valueOf(localb.JUm - localb.JUl) });
      g.yhR.f(19778, new Object[] { localb.sessionId, Integer.valueOf(localb.JUk), Integer.valueOf(localb.ilN), Long.valueOf(localb.JUl), Long.valueOf(localb.JUm) });
      AppMethodBeat.o(194870);
      return;
    }
    AppMethodBeat.o(194870);
  }
  
  public final void adV(int paramInt)
  {
    AppMethodBeat.i(194865);
    this.JRW = new cp();
    ad.v("MicroMsg.ImageScanButtonReporter", "startSession picType: %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject = this.JRW;
    if (localObject == null) {
      p.gfZ();
    }
    ((cp)localObject).id(1L);
    ((cp)localObject).ic(1L);
    ((cp)localObject).hZ(System.currentTimeMillis());
    ((cp)localObject).ia(paramInt);
    ((cp)localObject).lP(u.aAm() + "_" + ((cp)localObject).SN());
    localObject = ((cp)localObject).getSessionId();
    p.g(localObject, "sessionId");
    this.sessionId = ((String)localObject);
    AppMethodBeat.o(194865);
  }
  
  public final void adW(int paramInt)
  {
    AppMethodBeat.i(194866);
    cp localcp = this.JRW;
    if ((localcp != null) && (localcp.SP() == paramInt))
    {
      localcp = this.JRW;
      if (localcp != null) {
        if (localcp.SO() != 0L) {
          break label105;
        }
      }
    }
    else
    {
      ad.v("MicroMsg.ImageScanButtonReporter", "setShowIcon iconType: %d", new Object[] { Integer.valueOf(paramInt) });
      localcp = this.JRW;
      if (localcp != null) {
        localcp.id(paramInt);
      }
      localcp = this.JRW;
      if (localcp == null) {
        break label105;
      }
      localcp.ib(System.currentTimeMillis());
      AppMethodBeat.o(194866);
      return;
    }
    AppMethodBeat.o(194866);
    return;
    label105:
    AppMethodBeat.o(194866);
  }
  
  public final void adX(int paramInt)
  {
    AppMethodBeat.i(194867);
    Object localObject = this.JRW;
    if (localObject != null) {}
    for (localObject = ((cp)localObject).getSessionId();; localObject = null)
    {
      ad.v("MicroMsg.ImageScanButtonReporter", "reportFastDetectEntry pictureConcluding: %d, sessionId: %s", new Object[] { Integer.valueOf(paramInt), localObject });
      localObject = this.JRW;
      if (localObject != null) {
        ((cp)localObject).ic(paramInt);
      }
      localObject = this.JRW;
      if (localObject == null) {
        break;
      }
      ((cp)localObject).aLk();
      AppMethodBeat.o(194867);
      return;
    }
    AppMethodBeat.o(194867);
  }
  
  public final void adY(int paramInt)
  {
    AppMethodBeat.i(194868);
    ad.i("MicroMsg.ImageScanButtonReporter", "alvinluo clickScanButton iconType: %d", new Object[] { Integer.valueOf(paramInt) });
    this.JUi = new b();
    b localb = this.JUi;
    if (localb == null) {
      p.gfZ();
    }
    localb.reset();
    Object localObject = this.JRW;
    if (localObject == null) {
      p.gfZ();
    }
    localObject = ((cp)localObject).getSessionId();
    p.g(localObject, "fastEntryDetectStruct!!.sessionId");
    localb.setSessionId((String)localObject);
    localb.ilN = paramInt;
    localb.JUl = System.currentTimeMillis();
    AppMethodBeat.o(194868);
  }
  
  public final void adZ(int paramInt)
  {
    AppMethodBeat.i(194869);
    Object localObject = this.JUi;
    if (localObject != null) {
      ((b)localObject).JUk = paramInt;
    }
    localObject = this.JUi;
    if (localObject != null) {
      ((b)localObject).JUm = System.currentTimeMillis();
    }
    localObject = this.JUi;
    if (localObject != null) {}
    for (localObject = Long.valueOf(((b)localObject).JUm);; localObject = null)
    {
      ad.i("MicroMsg.ImageScanButtonReporter", "alvinluo clickFinish clickResult: %d, %s", new Object[] { Integer.valueOf(paramInt), localObject });
      fGO();
      AppMethodBeat.o(194869);
      return;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter$ImageFastEntryClick;", "", "()V", "clickFinishTimestamp", "", "getClickFinishTimestamp", "()J", "setClickFinishTimestamp", "(J)V", "clickIconTimestamp", "getClickIconTimestamp", "setClickIconTimestamp", "clickResult", "", "getClickResult", "()I", "setClickResult", "(I)V", "iconType", "getIconType", "setIconType", "isReported", "", "()Z", "setReported", "(Z)V", "sessionId", "", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "reset", "", "app_release"})
  static final class b
  {
    int JUk;
    long JUl;
    long JUm;
    boolean fJh;
    int ilN;
    String sessionId = "";
    
    public final void reset()
    {
      this.sessionId = "";
      this.JUk = 0;
      this.ilN = 0;
      this.JUl = 0L;
      this.JUm = 0L;
      this.fJh = false;
    }
    
    public final void setSessionId(String paramString)
    {
      AppMethodBeat.i(194864);
      p.h(paramString, "<set-?>");
      this.sessionId = paramString;
      AppMethodBeat.o(194864);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.b
 * JD-Core Version:    0.7.0.1
 */