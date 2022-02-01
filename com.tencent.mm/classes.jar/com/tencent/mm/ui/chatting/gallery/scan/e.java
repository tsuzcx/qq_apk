package com.tencent.mm.ui.chatting.gallery.scan;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ap;
import com.tencent.mm.autogen.mmdata.rpt.in;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter;", "", "()V", "fastEntryClick", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter$ImageFastEntryClick;", "fastEntryDetectStruct", "Lcom/tencent/mm/autogen/mmdata/rpt/ImageFastEntryDetectStruct;", "searchButtonReportInfo", "Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter$ImageSearchButtonReportInfo;", "sessionId", "", "clickFinish", "", "clickResult", "", "clickScanButton", "iconType", "doReportSearchButtonAction", "action", "source", "timestamp", "", "initSearchButtonReportInfo", "msgId", "scene", "chatType", "username", "chatRoomId", "imagePath", "reportFastDetectEntry", "pictureConcluding", "reportFastEntryClick", "reportSearchButtonAction", "resetSearchButtonAction", "setShowIcon", "startSession", "picType", "imgInfo", "Lcom/tencent/mm/modelimage/ImgInfo;", "ChatType", "ClickResult", "Companion", "IconType", "ImageFastEntryClick", "ImageSearchButtonReportInfo", "OpenPictureType", "PictureConcluding", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e.a aeGw;
  private in aeGx;
  private b aeGy;
  public c aeGz;
  private String sessionId = "";
  
  static
  {
    AppMethodBeat.i(254841);
    aeGw = new e.a((byte)0);
    AppMethodBeat.o(254841);
  }
  
  private static void a(int paramInt, long paramLong, c paramc)
  {
    AppMethodBeat.i(254827);
    if (paramc == null)
    {
      AppMethodBeat.o(254827);
      return;
    }
    com.tencent.threadpool.h.ahAA.j(new e..ExternalSyntheticLambda0(paramc, 1, paramInt, paramLong), "ReportSearchButtonAction");
    AppMethodBeat.o(254827);
  }
  
  private static final void a(c paramc, int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(254835);
    if (y.ZC(paramc.imagePath))
    {
      Object localObject = y.bi(paramc.imagePath, 0, -1);
      if (localObject != null)
      {
        localObject = MD5Util.getMD5String((byte[])localObject);
        s.s(localObject, "getMD5String(data)");
        s.u(localObject, "<set-?>");
        paramc.aeGF = ((String)localObject);
        Log.v("MicroMsg.ImageScanButtonReporter", "alvinluo doReportSearchButtonAction sessionId: %s, msgId: %s, detectId: %s, action: %d, source: %d, scene: %d, chatType: %d, username: %s, chatRoomId: %s, imagePath: %s, md5: %s, serverSessionId: %s", new Object[] { paramc.sessionId, Long.valueOf(paramc.msgId), Long.valueOf(paramc.aeGD), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramc.scene), Integer.valueOf(paramc.chatType), paramc.aeGE, paramc.xEn, paramc.imagePath, paramc.aeGF, Long.valueOf(paramc.aeGG) });
        localObject = new ap();
        ((ap)localObject).kC(paramc.sessionId);
        ((ap)localObject).ilm = paramInt1;
        ((ap)localObject).ioZ = paramInt2;
        ((ap)localObject).imW = paramc.scene;
        ((ap)localObject).kD(String.valueOf(paramc.msgId));
        ((ap)localObject).imM = paramc.chatType;
        ((ap)localObject).kF(paramc.xEn);
        ((ap)localObject).kG(paramc.aeGF);
        ((ap)localObject).ipe = paramLong;
        ((ap)localObject).bMH();
      }
    }
    AppMethodBeat.o(254835);
  }
  
  private final void jwD()
  {
    AppMethodBeat.i(254823);
    Object localObject1 = this.aeGy;
    if ((localObject1 != null) && (((b)localObject1).lwK == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(254823);
      return;
    }
    localObject1 = this.aeGy;
    if (localObject1 != null) {
      ((b)localObject1).lwK = true;
    }
    localObject1 = this.aeGy;
    com.tencent.mm.plugin.report.service.h localh;
    String str;
    int j;
    long l1;
    long l2;
    if ((localObject1 != null) && (((b)localObject1).aeGA == 1))
    {
      i = 1;
      if (i == 0)
      {
        localObject1 = this.aeGy;
        if (localObject1 != null) {
          ((b)localObject1).aeGA = 2;
        }
      }
      localObject1 = this.aeGy;
      if (localObject1 != null)
      {
        Log.v("MicroMsg.ImageScanButtonReporter", "reportFastEntryClick sessionId: %s, clickResult: %s, iconType: %d, clickIconTime: %s, clickFinishTime: %s, diff: %s", new Object[] { ((b)localObject1).sessionId, Integer.valueOf(((b)localObject1).aeGA), Integer.valueOf(((b)localObject1).qvo), Long.valueOf(((b)localObject1).aeGB), Long.valueOf(((b)localObject1).aeGC), Long.valueOf(((b)localObject1).aeGC - ((b)localObject1).aeGB) });
        localh = com.tencent.mm.plugin.report.service.h.OAn;
        str = ((b)localObject1).sessionId;
        i = ((b)localObject1).aeGA;
        j = ((b)localObject1).qvo;
        l1 = ((b)localObject1).aeGB;
        l2 = ((b)localObject1).aeGC;
        localObject1 = this.aeGx;
        if (localObject1 != null) {
          break label328;
        }
        localObject1 = null;
        label245:
        localObject2 = this.aeGx;
        if (localObject2 != null) {
          break label338;
        }
      }
    }
    label328:
    label338:
    for (Object localObject2 = null;; localObject2 = ((in)localObject2).iOf)
    {
      localh.b(19778, new Object[] { str, Integer.valueOf(i), Integer.valueOf(j), Long.valueOf(l1), Long.valueOf(l2), localObject1, localObject2 });
      AppMethodBeat.o(254823);
      return;
      i = 0;
      break;
      localObject1 = ((in)localObject1).iOe;
      break label245;
    }
  }
  
  public final void aCZ(int paramInt)
  {
    AppMethodBeat.i(254862);
    in localin = this.aeGx;
    if ((localin != null) && (localin.iwE == paramInt))
    {
      i = 1;
      if (i != 0)
      {
        localin = this.aeGx;
        if ((localin == null) || (localin.iQs != 0L)) {
          break label117;
        }
      }
    }
    label117:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.v("MicroMsg.ImageScanButtonReporter", "setShowIcon iconType: %d", new Object[] { Integer.valueOf(paramInt) });
        localin = this.aeGx;
        if (localin != null) {
          localin.iwE = paramInt;
        }
        localin = this.aeGx;
        if (localin != null) {
          localin.iQs = System.currentTimeMillis();
        }
      }
      AppMethodBeat.o(254862);
      return;
      i = 0;
      break;
    }
  }
  
  public final void aDa(int paramInt)
  {
    AppMethodBeat.i(254867);
    Object localObject = this.aeGx;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((in)localObject).ijk)
    {
      Log.v("MicroMsg.ImageScanButtonReporter", "reportFastDetectEntry pictureConcluding: %d, sessionId: %s", new Object[] { Integer.valueOf(paramInt), localObject });
      localObject = this.aeGx;
      if (localObject != null) {
        ((in)localObject).iQt = paramInt;
      }
      localObject = this.aeGx;
      if (localObject != null) {
        ((in)localObject).bMH();
      }
      AppMethodBeat.o(254867);
      return;
    }
  }
  
  public final void aDb(int paramInt)
  {
    AppMethodBeat.i(254876);
    Log.i("MicroMsg.ImageScanButtonReporter", "alvinluo clickScanButton iconType: %d", new Object[] { Integer.valueOf(paramInt) });
    this.aeGy = new b();
    b localb = this.aeGy;
    s.checkNotNull(localb);
    localb.reset();
    Object localObject = this.aeGx;
    s.checkNotNull(localObject);
    localObject = ((in)localObject).ijk;
    s.s(localObject, "fastEntryDetectStruct!!.sessionId");
    localb.setSessionId((String)localObject);
    localb.qvo = paramInt;
    localb.aeGB = System.currentTimeMillis();
    AppMethodBeat.o(254876);
  }
  
  public final void aDc(int paramInt)
  {
    AppMethodBeat.i(254880);
    Object localObject = this.aeGy;
    if (localObject != null) {
      ((b)localObject).aeGA = paramInt;
    }
    localObject = this.aeGy;
    if (localObject != null) {
      ((b)localObject).aeGC = System.currentTimeMillis();
    }
    localObject = this.aeGy;
    if (localObject == null) {}
    for (localObject = null;; localObject = Long.valueOf(((b)localObject).aeGC))
    {
      Log.i("MicroMsg.ImageScanButtonReporter", "alvinluo clickFinish clickResult: %d, %s", new Object[] { Integer.valueOf(paramInt), localObject });
      jwD();
      AppMethodBeat.o(254880);
      return;
    }
  }
  
  public final void aDd(int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(254886);
    Object localObject = this.aeGz;
    if ((localObject != null) && (((c)localObject).msgId == 0L)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(254886);
      return;
    }
    localObject = "1,".concat(String.valueOf(paramInt));
    c localc = this.aeGz;
    if (localc == null) {}
    while (bool)
    {
      AppMethodBeat.o(254886);
      return;
      bool = s.p(localc.aeGH.get(localObject), Boolean.TRUE);
    }
    localc = this.aeGz;
    if (localc != null) {
      ((Map)localc.aeGH).put(localObject, Boolean.TRUE);
    }
    a(paramInt, System.currentTimeMillis(), this.aeGz);
    AppMethodBeat.o(254886);
  }
  
  public final void b(int paramInt, com.tencent.mm.modelimage.h paramh)
  {
    Object localObject2 = null;
    AppMethodBeat.i(254854);
    this.aeGx = new in();
    Log.v("MicroMsg.ImageScanButtonReporter", "startSession picType: %d", new Object[] { Integer.valueOf(paramInt) });
    in localin = this.aeGx;
    s.checkNotNull(localin);
    localin.iwE = 1L;
    localin.iQt = 1L;
    localin.iQq = System.currentTimeMillis();
    localin.iQr = paramInt;
    localin.rQ(z.bAM() + '_' + localin.iQq);
    Object localObject1;
    if (paramh == null)
    {
      localObject1 = null;
      localin.rR((String)localObject1);
      if (paramh != null) {
        break label196;
      }
    }
    label196:
    for (paramh = localObject2;; paramh = paramh.getAesKey())
    {
      localin.rS(paramh);
      paramh = localin.ijk;
      s.s(paramh, "sessionId");
      this.sessionId = paramh;
      paramh = new c();
      paramh.aeGD = System.currentTimeMillis();
      localObject1 = ah.aiuX;
      this.aeGz = paramh;
      AppMethodBeat.o(254854);
      return;
      localObject1 = paramh.getFileId();
      break;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter$ImageFastEntryClick;", "", "()V", "clickFinishTimestamp", "", "getClickFinishTimestamp", "()J", "setClickFinishTimestamp", "(J)V", "clickIconTimestamp", "getClickIconTimestamp", "setClickIconTimestamp", "clickResult", "", "getClickResult", "()I", "setClickResult", "(I)V", "iconType", "getIconType", "setIconType", "isReported", "", "()Z", "setReported", "(Z)V", "sessionId", "", "getSessionId", "()Ljava/lang/String;", "setSessionId", "(Ljava/lang/String;)V", "reset", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
  {
    int aeGA;
    long aeGB;
    long aeGC;
    boolean lwK;
    int qvo;
    String sessionId = "";
    
    public final void reset()
    {
      this.sessionId = "";
      this.aeGA = 0;
      this.qvo = 0;
      this.aeGB = 0L;
      this.aeGC = 0L;
      this.lwK = false;
    }
    
    public final void setSessionId(String paramString)
    {
      AppMethodBeat.i(254870);
      s.u(paramString, "<set-?>");
      this.sessionId = paramString;
      AppMethodBeat.o(254870);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/scan/ImageScanButtonReporter$ImageSearchButtonReportInfo;", "", "()V", "actionReported", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getActionReported", "()Ljava/util/HashMap;", "setActionReported", "(Ljava/util/HashMap;)V", "chatRoomId", "getChatRoomId", "()Ljava/lang/String;", "setChatRoomId", "(Ljava/lang/String;)V", "chatType", "", "getChatType", "()I", "setChatType", "(I)V", "detectId", "", "getDetectId", "()J", "setDetectId", "(J)V", "imageMd5", "getImageMd5", "setImageMd5", "imagePath", "getImagePath", "setImagePath", "msgFromUserName", "getMsgFromUserName", "setMsgFromUserName", "msgId", "getMsgId", "setMsgId", "scene", "getScene", "setScene", "serverSessionId", "getServerSessionId", "setServerSessionId", "sessionId", "getSessionId", "setSessionId", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    long aeGD;
    public String aeGE;
    String aeGF;
    long aeGG;
    public HashMap<String, Boolean> aeGH;
    public int chatType;
    public String imagePath;
    public long msgId;
    public int scene;
    public String sessionId;
    public String xEn;
    
    public c()
    {
      AppMethodBeat.i(254866);
      this.sessionId = "";
      this.aeGE = "";
      this.xEn = "";
      this.imagePath = "";
      this.aeGF = "";
      this.aeGH = new HashMap();
      AppMethodBeat.o(254866);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.scan.e
 * JD-Core Version:    0.7.0.1
 */