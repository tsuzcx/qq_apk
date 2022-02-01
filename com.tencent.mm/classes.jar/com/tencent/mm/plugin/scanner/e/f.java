package com.tencent.mm.plugin.scanner.e;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.g.a;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.protocal.protobuf.nn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper;", "", "()V", "TAG", "", "checkImageCdnStatus", "", "checkRequest", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageRequest;", "callback", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageCallback;", "checkImageValid", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageResult;", "maxImageSize", "", "isTheSameImage", "", "checkCDNImageRequest", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckRequest;", "checkCDNImageResult", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckResult;", "toInfoString", "Lcom/tencent/mm/protocal/protobuf/BizAiScanCdnImg;", "CheckImageCallback", "CheckImageRequest", "CheckImageResult", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f OQq;
  
  static
  {
    AppMethodBeat.i(313679);
    OQq = new f();
    AppMethodBeat.o(313679);
  }
  
  public static final c a(b paramb, int paramInt)
  {
    AppMethodBeat.i(313639);
    s.u(paramb, "checkRequest");
    c localc = new c();
    boolean bool1 = y.ZC(paramb.imagePath);
    boolean bool2 = a.a(paramb.OQs, paramInt);
    if ((bool1) && (bool2)) {
      localc.OQv = 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.AiScanImageCDNCheckHelper", "alvinluo checkImageValid imageSrc: %s, compressType: %d, imageSize: %s, imagePath: %s, fileExist: %s, checkResult: %s", new Object[] { Integer.valueOf(paramb.OQr), Integer.valueOf(paramb.oGu), paramb.OQs, paramb.imagePath, Boolean.valueOf(bool1), Integer.valueOf(localc.OQv) });
      AppMethodBeat.o(313639);
      return localc;
      if (bool1) {
        localc.OQv = 2;
      } else {
        localc.OQv = 3;
      }
    }
  }
  
  public static String a(nn paramnn)
  {
    AppMethodBeat.i(313668);
    s.u(paramnn, "<this>");
    am localam = am.aixg;
    paramnn = String.format("BizAiScanCdnImg fileId: %s, size: [%s, %s], cdn_src: %s, cdn_status: %s", Arrays.copyOf(new Object[] { paramnn.YPy, Integer.valueOf(paramnn.w), Integer.valueOf(paramnn.h), Integer.valueOf(paramnn.YPx), Integer.valueOf(paramnn.YPA) }, 5));
    s.s(paramnn, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(313668);
    return paramnn;
  }
  
  public static final void a(final b paramb, final a parama)
  {
    AppMethodBeat.i(313661);
    s.u(paramb, "checkRequest");
    Object localObject1 = new c();
    final g localg = new g();
    Object localObject2 = paramb.imagePath;
    s.u(localObject2, "<set-?>");
    localg.imagePath = ((String)localObject2);
    localObject2 = paramb.fileId;
    s.u(localObject2, "<set-?>");
    localg.fileId = ((String)localObject2);
    localObject2 = paramb.aesKey;
    s.u(localObject2, "<set-?>");
    localg.aesKey = ((String)localObject2);
    localg.oGu = paramb.oGu;
    localg.OQt = paramb.OQt;
    Log.i("MicroMsg.AiScanImageCDNCheckHelper", "alvinluo checkImageCdnStatus imageSize: %s, fileId: %s", new Object[] { paramb.OQs, paramb.fileId });
    localObject2 = a.OPN;
    paramb = (e)new d((c)localObject1, localg, parama, paramb);
    s.u(localg, "checkRequest");
    s.u(paramb, "callback");
    if (!y.ZC(localg.imagePath))
    {
      paramb.a(new h(3, 401));
      AppMethodBeat.o(313661);
      return;
    }
    parama = new com.tencent.mm.g.g();
    parama.taskName = "task_AiScanImagetUploadTask";
    localObject1 = localg.imagePath;
    s.u(localObject1, "filePath");
    parama.field_mediaId = (z.bAM() + "_image_search_" + (String)localObject1 + '_' + System.currentTimeMillis());
    parama.field_fullpath = localg.imagePath;
    int i;
    boolean bool;
    if (localg.oGu == 1)
    {
      i = com.tencent.mm.g.a.MediaType_FULLSIZEIMAGE;
      parama.field_fileType = i;
      parama.field_priority = com.tencent.mm.g.a.lvZ;
      parama.field_needStorage = false;
      if (localg.oGu != 1) {
        break label518;
      }
      bool = true;
      label320:
      parama.field_needCompressImage = bool;
      parama.field_isStreamMedia = false;
      parama.lwQ = 15;
      if (localg.OQt) {
        break label523;
      }
      parama.field_fileId = localg.fileId;
      parama.field_aesKey = localg.aesKey;
      parama.field_force_aeskeycdn = false;
    }
    for (parama.field_trysafecdn = true;; parama.field_trysafecdn = false)
    {
      Log.i("MicroMsg.AIScanImageCdnUploadUtil", "alvinluo checkCDNImage mediaId: %s, compressType: %s, fileType: %s forceReUpload: %s, imagePath: %s, fileId: %s", new Object[] { parama.field_mediaId, Integer.valueOf(localg.oGu), Integer.valueOf(parama.field_fileType), Boolean.valueOf(localg.OQt), localg.imagePath, localg.fileId });
      parama.lwL = ((g.a)new a.b(paramb, localg));
      if (k.bHW().g(parama)) {
        break label536;
      }
      Log.e("MicroMsg.AIScanImageCdnUploadUtil", "alvinluo checkCDNImage add task failed mediaId: %s", new Object[] { parama.field_mediaId });
      paramb.a(new h(3, 402));
      AppMethodBeat.o(313661);
      return;
      i = com.tencent.mm.g.a.MediaType_IMAGE;
      break;
      label518:
      bool = false;
      break label320;
      label523:
      parama.field_force_aeskeycdn = true;
    }
    label536:
    parama = parama.field_mediaId;
    s.s(parama, "info.field_mediaId");
    paramb.aUE(parama);
    AppMethodBeat.o(313661);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageCallback;", "", "onCDNStartUpload", "", "mediaId", "", "onCheckResult", "checkImageResult", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageResult;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(f.c paramc);
    
    public abstract void aUD(String paramString);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageRequest;", "", "sessionId", "", "imageSrc", "", "(JI)V", "aesKey", "", "getAesKey", "()Ljava/lang/String;", "setAesKey", "(Ljava/lang/String;)V", "compressType", "getCompressType", "()I", "setCompressType", "(I)V", "fileId", "getFileId", "setFileId", "forceReUpload", "", "getForceReUpload", "()Z", "setForceReUpload", "(Z)V", "imagePath", "getImagePath", "setImagePath", "imageSize", "Landroid/graphics/Point;", "getImageSize", "()Landroid/graphics/Point;", "setImageSize", "(Landroid/graphics/Point;)V", "getImageSrc", "msgId", "getMsgId", "()J", "setMsgId", "(J)V", "getSessionId", "toCdnInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanCdnImg;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    final int OQr;
    Point OQs;
    boolean OQt;
    String aesKey;
    String fileId;
    String imagePath;
    int oGu;
    private final long sessionId;
    
    public b(long paramLong, int paramInt)
    {
      this.sessionId = paramLong;
      this.OQr = paramInt;
      this.imagePath = "";
      this.fileId = "";
      this.aesKey = "";
    }
    
    public final nn gQG()
    {
      AppMethodBeat.i(313576);
      nn localnn = new nn();
      Point localPoint;
      if (this.oGu == 1)
      {
        localnn.YPx = 1;
        localnn.YPy = this.fileId;
        localnn.YPz = this.aesKey;
        localPoint = this.OQs;
        if (localPoint != null) {
          break label101;
        }
        i = 0;
        label53:
        localnn.w = i;
        localPoint = this.OQs;
        if (localPoint != null) {
          break label109;
        }
      }
      label101:
      label109:
      for (int i = 0;; i = localPoint.y)
      {
        localnn.h = i;
        localnn.YPA = 0;
        AppMethodBeat.o(313576);
        return localnn;
        if (this.oGu != 0) {
          break;
        }
        localnn.YPx = 2;
        break;
        i = localPoint.x;
        break label53;
      }
    }
    
    public final void setAesKey(String paramString)
    {
      AppMethodBeat.i(313574);
      s.u(paramString, "<set-?>");
      this.aesKey = paramString;
      AppMethodBeat.o(313574);
    }
    
    public final void setFileId(String paramString)
    {
      AppMethodBeat.i(313572);
      s.u(paramString, "<set-?>");
      this.fileId = paramString;
      AppMethodBeat.o(313572);
    }
    
    public final void setImagePath(String paramString)
    {
      AppMethodBeat.i(313566);
      s.u(paramString, "<set-?>");
      this.imagePath = paramString;
      AppMethodBeat.o(313566);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageResult;", "", "()V", "checkResult", "", "getCheckResult", "()I", "setCheckResult", "(I)V", "errCode", "getErrCode", "setErrCode", "errMsg", "", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "errType", "getErrType", "setErrType", "reUploadImageCdnInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanCdnImg;", "getReUploadImageCdnInfo", "()Lcom/tencent/mm/protocal/protobuf/BizAiScanCdnImg;", "setReUploadImageCdnInfo", "(Lcom/tencent/mm/protocal/protobuf/BizAiScanCdnImg;)V", "valid", "", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    public static final f.c.a OQu;
    int OQv;
    nn OQw;
    int errCode = -1;
    String errMsg = "";
    int errType = -1;
    
    static
    {
      AppMethodBeat.i(313563);
      OQu = new f.c.a((byte)0);
      AppMethodBeat.o(313563);
    }
    
    public final boolean boj()
    {
      return this.OQv == 1;
    }
    
    public final void setErrMsg(String paramString)
    {
      AppMethodBeat.i(313569);
      s.u(paramString, "<set-?>");
      this.errMsg = paramString;
      AppMethodBeat.o(313569);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$checkImageCdnStatus$1", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckCallback;", "onCDNUploadStart", "", "mediaId", "", "onFinish", "checkCDNImageResult", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckResult;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements e
  {
    d(f.c paramc, g paramg, f.a parama, f.b paramb) {}
    
    public final void a(h paramh)
    {
      int j = 0;
      AppMethodBeat.i(313567);
      s.u(paramh, "checkCDNImageResult");
      Log.i("MicroMsg.AiScanImageCDNCheckHelper", "alvinluo checkImageCdnStatus result errType: " + paramh.errType + ", errCode: " + paramh.errCode);
      this.OQx.errType = paramh.errType;
      this.OQx.errCode = paramh.errCode;
      this.OQx.setErrMsg("check cdn image error");
      if ((paramh.errType == 0) && (paramh.errCode == 0))
      {
        localObject1 = f.OQq;
        if (f.a(localg, paramh)) {
          Log.i("MicroMsg.AiScanImageCDNCheckHelper", "alvinluo checkImageCdnStatus no need to re-upload, fileId: %s", new Object[] { localg.fileId });
        }
      }
      else
      {
        paramh = parama;
        if (paramh != null) {
          paramh.a(this.OQx);
        }
        AppMethodBeat.o(313567);
        return;
      }
      Log.i("MicroMsg.AiScanImageCDNCheckHelper", "alvinluo checkImageCdnStatus re-upload image fileId: %s", new Object[] { paramh.fileId });
      Object localObject1 = this.OQx;
      nn localnn = new nn();
      Object localObject2 = paramb;
      label210:
      Point localPoint;
      if (((f.b)localObject2).oGu == 1)
      {
        localnn.YPx = 3;
        localPoint = ((f.b)localObject2).OQs;
        if (localPoint != null) {
          break label305;
        }
        i = 0;
        label224:
        localnn.w = i;
        localObject2 = ((f.b)localObject2).OQs;
        if (localObject2 != null) {
          break label314;
        }
      }
      label305:
      label314:
      for (int i = j;; i = ((Point)localObject2).y)
      {
        localnn.h = i;
        localnn.YPA = 1;
        localnn.YPy = paramh.fileId;
        localnn.YPz = paramh.aesKey;
        paramh = ah.aiuX;
        ((f.c)localObject1).OQw = localnn;
        break;
        if (((f.b)localObject2).oGu != 0) {
          break label210;
        }
        localnn.YPx = 5;
        break label210;
        i = localPoint.x;
        break label224;
      }
    }
    
    public final void aUE(String paramString)
    {
      AppMethodBeat.i(313573);
      s.u(paramString, "mediaId");
      f.a locala = parama;
      if (locala != null) {
        locala.aUD(paramString);
      }
      AppMethodBeat.o(313573);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.f
 * JD-Core Version:    0.7.0.1
 */