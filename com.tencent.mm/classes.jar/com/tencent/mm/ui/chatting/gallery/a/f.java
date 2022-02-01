package com.tencent.mm.ui.chatting.gallery.a;

import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.g;
import com.tencent.mm.g.b.a.ab;
import com.tencent.mm.g.b.a.fb;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter;", "", "()V", "fastEntryClick", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter$ImageFastEntryClick;", "fastEntryDetectStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/ImageFastEntryDetectStruct;", "searchButtonReportInfo", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter$ImageSearchButtonReportInfo;", "sessionId", "", "clickFinish", "", "clickResult", "", "clickScanButton", "iconType", "doReportSearchButtonAction", "action", "source", "timestamp", "", "initSearchButtonReportInfo", "msgId", "scene", "chatType", "username", "chatRoomId", "imagePath", "reportFastDetectEntry", "pictureConcluding", "reportFastEntryClick", "reportSearchButtonAction", "resetSearchButtonAction", "setShowIcon", "startSession", "picType", "imgInfo", "Lcom/tencent/mm/modelimage/ImgInfo;", "ChatType", "ClickResult", "Companion", "IconType", "ImageFastEntryClick", "ImageSearchButtonReportInfo", "OpenPictureType", "PictureConcluding", "app_release"})
public final class f
{
  public static final f.a PBZ;
  private fb PBW;
  private b PBX;
  public c PBY;
  private String sessionId = "";
  
  static
  {
    AppMethodBeat.i(231237);
    PBZ = new f.a((byte)0);
    AppMethodBeat.o(231237);
  }
  
  private static void a(final int paramInt, final long paramLong, c paramc)
  {
    AppMethodBeat.i(231236);
    if (paramc == null)
    {
      AppMethodBeat.o(231236);
      return;
    }
    com.tencent.f.h.RTc.e((Runnable)new d(paramc, 1, paramInt, paramLong), "ReportSearchButtonAction");
    AppMethodBeat.o(231236);
  }
  
  private final void gTu()
  {
    AppMethodBeat.i(231234);
    Object localObject1 = this.PBX;
    if ((localObject1 != null) && (((b)localObject1).gqx == true))
    {
      AppMethodBeat.o(231234);
      return;
    }
    localObject1 = this.PBX;
    if (localObject1 != null) {
      ((b)localObject1).gqx = true;
    }
    localObject1 = this.PBX;
    if ((localObject1 == null) || (((b)localObject1).PCa != 1))
    {
      localObject1 = this.PBX;
      if (localObject1 != null) {
        ((b)localObject1).PCa = 2;
      }
    }
    localObject1 = this.PBX;
    if (localObject1 != null)
    {
      Log.v("MicroMsg.ImageScanButtonReporter", "reportFastEntryClick sessionId: %s, clickResult: %s, iconType: %d, clickIconTime: %s, clickFinishTime: %s, diff: %s", new Object[] { ((b)localObject1).sessionId, Integer.valueOf(((b)localObject1).PCa), Integer.valueOf(((b)localObject1).jjN), Long.valueOf(((b)localObject1).PCb), Long.valueOf(((b)localObject1).PCc), Long.valueOf(((b)localObject1).PCc - ((b)localObject1).PCb) });
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
      String str = ((b)localObject1).sessionId;
      int i = ((b)localObject1).PCa;
      int j = ((b)localObject1).jjN;
      long l1 = ((b)localObject1).PCb;
      long l2 = ((b)localObject1).PCc;
      localObject1 = this.PBW;
      if (localObject1 != null)
      {
        localObject1 = ((fb)localObject1).afW();
        localObject2 = this.PBW;
        if (localObject2 == null) {
          break label320;
        }
      }
      label320:
      for (Object localObject2 = ((fb)localObject2).getAesKey();; localObject2 = null)
      {
        localh.a(19778, new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), localObject1, localObject2 });
        AppMethodBeat.o(231234);
        return;
        localObject1 = null;
        break;
      }
    }
    AppMethodBeat.o(231234);
  }
  
  public final void ann(int paramInt)
  {
    AppMethodBeat.i(231230);
    fb localfb = this.PBW;
    if ((localfb != null) && (localfb.afV() == paramInt))
    {
      localfb = this.PBW;
      if (localfb != null) {
        if (localfb.afU() != 0L) {
          break label105;
        }
      }
    }
    else
    {
      Log.v("MicroMsg.ImageScanButtonReporter", "setShowIcon iconType: %d", new Object[] { Integer.valueOf(paramInt) });
      localfb = this.PBW;
      if (localfb != null) {
        localfb.ne(paramInt);
      }
      localfb = this.PBW;
      if (localfb == null) {
        break label105;
      }
      localfb.nc(System.currentTimeMillis());
      AppMethodBeat.o(231230);
      return;
    }
    AppMethodBeat.o(231230);
    return;
    label105:
    AppMethodBeat.o(231230);
  }
  
  public final void ano(int paramInt)
  {
    AppMethodBeat.i(231231);
    Object localObject = this.PBW;
    if (localObject != null) {}
    for (localObject = ((fb)localObject).getSessionId();; localObject = null)
    {
      Log.v("MicroMsg.ImageScanButtonReporter", "reportFastDetectEntry pictureConcluding: %d, sessionId: %s", new Object[] { Integer.valueOf(paramInt), localObject });
      localObject = this.PBW;
      if (localObject != null) {
        ((fb)localObject).nd(paramInt);
      }
      localObject = this.PBW;
      if (localObject == null) {
        break;
      }
      ((fb)localObject).bfK();
      AppMethodBeat.o(231231);
      return;
    }
    AppMethodBeat.o(231231);
  }
  
  public final void anp(int paramInt)
  {
    AppMethodBeat.i(231232);
    Log.i("MicroMsg.ImageScanButtonReporter", "alvinluo clickScanButton iconType: %d", new Object[] { Integer.valueOf(paramInt) });
    this.PBX = new b();
    b localb = this.PBX;
    if (localb == null) {
      p.hyc();
    }
    localb.reset();
    Object localObject = this.PBW;
    if (localObject == null) {
      p.hyc();
    }
    localObject = ((fb)localObject).getSessionId();
    p.g(localObject, "fastEntryDetectStruct!!.sessionId");
    localb.setSessionId((String)localObject);
    localb.jjN = paramInt;
    localb.PCb = System.currentTimeMillis();
    AppMethodBeat.o(231232);
  }
  
  public final void anq(int paramInt)
  {
    AppMethodBeat.i(231233);
    Object localObject = this.PBX;
    if (localObject != null) {
      ((b)localObject).PCa = paramInt;
    }
    localObject = this.PBX;
    if (localObject != null) {
      ((b)localObject).PCc = System.currentTimeMillis();
    }
    localObject = this.PBX;
    if (localObject != null) {}
    for (localObject = Long.valueOf(((b)localObject).PCc);; localObject = null)
    {
      Log.i("MicroMsg.ImageScanButtonReporter", "alvinluo clickFinish clickResult: %d, %s", new Object[] { Integer.valueOf(paramInt), localObject });
      gTu();
      AppMethodBeat.o(231233);
      return;
    }
  }
  
  public final void anr(int paramInt)
  {
    AppMethodBeat.i(231235);
    Object localObject = this.PBY;
    if ((localObject != null) && (((c)localObject).msgId == 0L))
    {
      AppMethodBeat.o(231235);
      return;
    }
    String str = "1,".concat(String.valueOf(paramInt));
    localObject = this.PBY;
    if (localObject != null)
    {
      localObject = ((c)localObject).PCh;
      if (localObject == null) {}
    }
    for (localObject = (Boolean)((HashMap)localObject).get(str); p.j(localObject, Boolean.TRUE); localObject = null)
    {
      AppMethodBeat.o(231235);
      return;
    }
    localObject = this.PBY;
    if (localObject != null) {
      ((Map)((c)localObject).PCh).put(str, Boolean.TRUE);
    }
    a(paramInt, System.currentTimeMillis(), this.PBY);
    AppMethodBeat.o(231235);
  }
  
  public final void b(int paramInt, g paramg)
  {
    Object localObject2 = null;
    AppMethodBeat.i(231229);
    this.PBW = new fb();
    Log.v("MicroMsg.ImageScanButtonReporter", "startSession picType: %d", new Object[] { Integer.valueOf(paramInt) });
    fb localfb = this.PBW;
    if (localfb == null) {
      p.hyc();
    }
    localfb.ne(1L);
    localfb.nd(1L);
    localfb.na(System.currentTimeMillis());
    localfb.nb(paramInt);
    localfb.rX(z.aTY() + "_" + localfb.afT());
    if (paramg != null) {}
    for (Object localObject1 = paramg.getFileId();; localObject1 = null)
    {
      localfb.rY((String)localObject1);
      localObject1 = localObject2;
      if (paramg != null) {
        localObject1 = paramg.getAesKey();
      }
      localfb.rZ((String)localObject1);
      paramg = localfb.getSessionId();
      p.g(paramg, "sessionId");
      this.sessionId = paramg;
      paramg = new c();
      paramg.PCd = System.currentTimeMillis();
      this.PBY = paramg;
      AppMethodBeat.o(231229);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter$ImageFastEntryClick;", "", "()V", "clickFinishTimestamp", "", "getClickFinishTimestamp", "()J", "setClickFinishTimestamp", "(J)V", "clickIconTimestamp", "getClickIconTimestamp", "setClickIconTimestamp", "clickResult", "", "getClickResult", "()I", "setClickResult", "(I)V", "iconType", "getIconType", "setIconType", "isReported", "", "()Z", "setReported", "(Z)V", "sessionId", "", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "reset", "", "app_release"})
  static final class b
  {
    int PCa;
    long PCb;
    long PCc;
    boolean gqx;
    int jjN;
    String sessionId = "";
    
    public final void reset()
    {
      this.sessionId = "";
      this.PCa = 0;
      this.jjN = 0;
      this.PCb = 0L;
      this.PCc = 0L;
      this.gqx = false;
    }
    
    public final void setSessionId(String paramString)
    {
      AppMethodBeat.i(231226);
      p.h(paramString, "<set-?>");
      this.sessionId = paramString;
      AppMethodBeat.o(231226);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter$ImageSearchButtonReportInfo;", "", "()V", "actionReported", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getActionReported", "()Ljava/util/HashMap;", "setActionReported", "(Ljava/util/HashMap;)V", "chatRoomId", "getChatRoomId", "()Ljava/lang/String;", "setChatRoomId", "(Ljava/lang/String;)V", "chatType", "", "getChatType", "()I", "setChatType", "(I)V", "detectId", "", "getDetectId", "()J", "setDetectId", "(J)V", "imageMd5", "getImageMd5", "setImageMd5", "imagePath", "getImagePath", "setImagePath", "msgFromUserName", "getMsgFromUserName", "setMsgFromUserName", "msgId", "getMsgId", "setMsgId", "scene", "getScene", "setScene", "serverSessionId", "getServerSessionId", "setServerSessionId", "sessionId", "getSessionId", "setSessionId", "app_release"})
  public static final class c
  {
    long PCd;
    public String PCe;
    String PCf;
    long PCg;
    public HashMap<String, Boolean> PCh;
    public int chatType;
    public String imagePath;
    public long msgId;
    public String qUK;
    public int scene;
    public String sessionId;
    
    public c()
    {
      AppMethodBeat.i(231227);
      this.sessionId = "";
      this.PCe = "";
      this.qUK = "";
      this.imagePath = "";
      this.PCf = "";
      this.PCh = new HashMap();
      AppMethodBeat.o(231227);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(f.c paramc, int paramInt1, int paramInt2, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(231228);
      Object localObject = this.PCi;
      if (s.YS(((f.c)localObject).imagePath))
      {
        String str = MD5Util.getMD5String(s.aW(((f.c)localObject).imagePath, 0, -1));
        p.g(str, "MD5Util.getMD5String(VFS…omFile(imagePath, 0, -1))");
        p.h(str, "<set-?>");
        ((f.c)localObject).PCf = str;
        Log.v("MicroMsg.ImageScanButtonReporter", "alvinluo doReportSearchButtonAction sessionId: %s, msgId: %s, detectId: %s, action: %d, source: %d, scene: %d, chatType: %d, username: %s, chatRoomId: %s, imagePath: %s, md5: %s, serverSessionId: %s", new Object[] { ((f.c)localObject).sessionId, Long.valueOf(((f.c)localObject).msgId), Long.valueOf(((f.c)localObject).PCd), Integer.valueOf(this.jAd), Integer.valueOf(paramInt), Integer.valueOf(((f.c)localObject).scene), Integer.valueOf(((f.c)localObject).chatType), ((f.c)localObject).PCe, ((f.c)localObject).qUK, ((f.c)localObject).imagePath, ((f.c)localObject).PCf, Long.valueOf(((f.c)localObject).PCg) });
        localObject = new ab();
        ((ab)localObject).ie(this.PCi.sessionId);
        ((ab)localObject).jK(this.jAd);
        ((ab)localObject).jL(paramInt);
        ((ab)localObject).jM(this.PCi.scene);
        ((ab)localObject).jdMethod_if(String.valueOf(this.PCi.msgId));
        ((ab)localObject).jN(this.PCi.chatType);
        ((ab)localObject).ih(this.PCi.qUK);
        ((ab)localObject).ii(this.PCi.PCf);
        ((ab)localObject).bW(paramLong);
        ((ab)localObject).bfK();
      }
      AppMethodBeat.o(231228);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.a.f
 * JD-Core Version:    0.7.0.1
 */