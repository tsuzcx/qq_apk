package com.tencent.mm.plugin.scanner.e;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.b;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.z;
import com.tencent.mm.protocal.protobuf.mi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.util.Arrays;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper;", "", "()V", "TAG", "", "checkImageCdnStatus", "", "checkRequest", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageRequest;", "callback", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageCallback;", "checkImageValid", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageResult;", "maxImageSize", "", "isTheSameImage", "", "checkCDNImageRequest", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckRequest;", "checkCDNImageResult", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckResult;", "toInfoString", "Lcom/tencent/mm/protocal/protobuf/BizAiScanCdnImg;", "CheckImageCallback", "CheckImageRequest", "CheckImageResult", "plugin-scan_release"})
public final class f
{
  public static final f IJD;
  
  static
  {
    AppMethodBeat.i(221246);
    IJD = new f();
    AppMethodBeat.o(221246);
  }
  
  public static final c a(b paramb, int paramInt)
  {
    AppMethodBeat.i(221199);
    p.k(paramb, "checkRequest");
    c localc = new c();
    boolean bool1 = u.agG(paramb.imagePath);
    boolean bool2 = a.a(paramb.IJE, paramInt);
    if ((bool1) && (bool2)) {
      localc.IJH = 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.AiScanImageCDNCheckHelper", "alvinluo checkImageValid imageSrc: %s, compressType: %d, imageSize: %s, imagePath: %s, fileExist: %s, checkResult: %s", new Object[] { Integer.valueOf(paramb.IJG), Integer.valueOf(paramb.lNK), paramb.IJE, paramb.imagePath, Boolean.valueOf(bool1), Integer.valueOf(localc.IJH) });
      AppMethodBeat.o(221199);
      return localc;
      if (bool1) {
        localc.IJH = 2;
      } else {
        localc.IJH = 3;
      }
    }
  }
  
  public static String a(mi parammi)
  {
    AppMethodBeat.i(221244);
    p.k(parammi, "$this$toInfoString");
    af localaf = af.aaBG;
    parammi = String.format("BizAiScanCdnImg fileId: %s, size: [%s, %s], cdn_src: %s, cdn_status: %s", Arrays.copyOf(new Object[] { parammi.RRY, Integer.valueOf(parammi.w), Integer.valueOf(parammi.h), Integer.valueOf(parammi.RRX), Integer.valueOf(parammi.RSa) }, 5));
    p.j(parammi, "java.lang.String.format(format, *args)");
    AppMethodBeat.o(221244);
    return parammi;
  }
  
  public static final void a(final b paramb, final a parama)
  {
    AppMethodBeat.i(221237);
    p.k(paramb, "checkRequest");
    Object localObject1 = new c();
    final g localg = new g();
    Object localObject2 = paramb.imagePath;
    p.k(localObject2, "<set-?>");
    localg.imagePath = ((String)localObject2);
    localObject2 = paramb.fileId;
    p.k(localObject2, "<set-?>");
    localg.fileId = ((String)localObject2);
    localObject2 = paramb.aesKey;
    p.k(localObject2, "<set-?>");
    localg.aesKey = ((String)localObject2);
    localg.lNK = paramb.lNK;
    localg.IJF = paramb.IJF;
    Log.i("MicroMsg.AiScanImageCDNCheckHelper", "alvinluo checkImageCdnStatus imageSize: %s, fileId: %s", new Object[] { paramb.IJE, paramb.fileId });
    localObject2 = a.IJc;
    paramb = (e)new d((c)localObject1, localg, paramb, parama);
    p.k(localg, "checkRequest");
    p.k(paramb, "callback");
    if (!u.agG(localg.imagePath))
    {
      paramb.a(new h(3, 401));
      AppMethodBeat.o(221237);
      return;
    }
    parama = new com.tencent.mm.i.g();
    parama.taskName = "task_AiScanImagetUploadTask";
    localObject1 = localg.imagePath;
    p.k(localObject1, "filePath");
    parama.field_mediaId = (z.bcZ() + "_image_search_" + (String)localObject1 + "_" + System.currentTimeMillis());
    parama.field_fullpath = localg.imagePath;
    int i;
    boolean bool;
    if (localg.lNK == 1)
    {
      i = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
      parama.field_fileType = i;
      parama.field_priority = com.tencent.mm.i.a.iTU;
      parama.field_needStorage = false;
      if (localg.lNK != 1) {
        break label518;
      }
      bool = true;
      label320:
      parama.field_needCompressImage = bool;
      parama.field_isStreamMedia = false;
      parama.iUL = 15;
      if (localg.IJF) {
        break label523;
      }
      parama.field_fileId = localg.fileId;
      parama.field_aesKey = localg.aesKey;
      parama.field_force_aeskeycdn = false;
    }
    for (parama.field_trysafecdn = true;; parama.field_trysafecdn = false)
    {
      Log.i("MicroMsg.AIScanImageCdnUploadUtil", "alvinluo checkCDNImage mediaId: %s, compressType: %s, fileType: %s forceReUpload: %s, imagePath: %s, fileId: %s", new Object[] { parama.field_mediaId, Integer.valueOf(localg.lNK), Integer.valueOf(parama.field_fileType), Boolean.valueOf(localg.IJF), localg.imagePath, localg.fileId });
      parama.iUG = ((g.a)new a.b(paramb, localg));
      if (com.tencent.mm.aq.f.bkg().f(parama)) {
        break label536;
      }
      Log.e("MicroMsg.AIScanImageCdnUploadUtil", "alvinluo checkCDNImage add task failed mediaId: %s", new Object[] { parama.field_mediaId });
      paramb.a(new h(3, 402));
      AppMethodBeat.o(221237);
      return;
      i = com.tencent.mm.i.a.MediaType_IMAGE;
      break;
      label518:
      bool = false;
      break label320;
      label523:
      parama.field_force_aeskeycdn = true;
    }
    label536:
    parama = parama.field_mediaId;
    p.j(parama, "info.field_mediaId");
    paramb.aXd(parama);
    AppMethodBeat.o(221237);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageCallback;", "", "onCDNStartUpload", "", "mediaId", "", "onCheckResult", "checkImageResult", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageResult;", "plugin-scan_release"})
  public static abstract interface a
  {
    public abstract void a(f.c paramc);
    
    public abstract void aXc(String paramString);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageRequest;", "", "sessionId", "", "imageSrc", "", "(JI)V", "aesKey", "", "getAesKey", "()Ljava/lang/String;", "setAesKey", "(Ljava/lang/String;)V", "compressType", "getCompressType", "()I", "setCompressType", "(I)V", "fileId", "getFileId", "setFileId", "forceReUpload", "", "getForceReUpload", "()Z", "setForceReUpload", "(Z)V", "imagePath", "getImagePath", "setImagePath", "imageSize", "Landroid/graphics/Point;", "getImageSize", "()Landroid/graphics/Point;", "setImageSize", "(Landroid/graphics/Point;)V", "getImageSrc", "msgId", "getMsgId", "()J", "setMsgId", "(J)V", "getSessionId", "toCdnInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanCdnImg;", "plugin-scan_release"})
  public static final class b
  {
    Point IJE;
    boolean IJF;
    final int IJG;
    String aesKey;
    String fileId;
    String imagePath;
    int lNK;
    private final long sessionId;
    
    public b(long paramLong, int paramInt)
    {
      this.sessionId = paramLong;
      this.IJG = paramInt;
      this.imagePath = "";
      this.fileId = "";
      this.aesKey = "";
    }
    
    public final mi fCE()
    {
      AppMethodBeat.i(219151);
      mi localmi = new mi();
      Point localPoint;
      if (this.lNK == 1)
      {
        localmi.RRX = 1;
        localmi.RRY = this.fileId;
        localmi.RRZ = this.aesKey;
        localPoint = this.IJE;
        if (localPoint == null) {
          break label107;
        }
        i = localPoint.x;
        label56:
        localmi.w = i;
        localPoint = this.IJE;
        if (localPoint == null) {
          break label112;
        }
      }
      label107:
      label112:
      for (int i = localPoint.y;; i = 0)
      {
        localmi.h = i;
        localmi.RSa = 0;
        AppMethodBeat.o(219151);
        return localmi;
        if (this.lNK != 0) {
          break;
        }
        localmi.RRX = 2;
        break;
        i = 0;
        break label56;
      }
    }
    
    public final void setAesKey(String paramString)
    {
      AppMethodBeat.i(219146);
      p.k(paramString, "<set-?>");
      this.aesKey = paramString;
      AppMethodBeat.o(219146);
    }
    
    public final void setFileId(String paramString)
    {
      AppMethodBeat.i(219145);
      p.k(paramString, "<set-?>");
      this.fileId = paramString;
      AppMethodBeat.o(219145);
    }
    
    public final void setImagePath(String paramString)
    {
      AppMethodBeat.i(219144);
      p.k(paramString, "<set-?>");
      this.imagePath = paramString;
      AppMethodBeat.o(219144);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$CheckImageResult;", "", "()V", "checkResult", "", "getCheckResult", "()I", "setCheckResult", "(I)V", "errCode", "getErrCode", "setErrCode", "errMsg", "", "getErrMsg", "()Ljava/lang/String;", "setErrMsg", "(Ljava/lang/String;)V", "errType", "getErrType", "setErrType", "reUploadImageCdnInfo", "Lcom/tencent/mm/protocal/protobuf/BizAiScanCdnImg;", "getReUploadImageCdnInfo", "()Lcom/tencent/mm/protocal/protobuf/BizAiScanCdnImg;", "setReUploadImageCdnInfo", "(Lcom/tencent/mm/protocal/protobuf/BizAiScanCdnImg;)V", "valid", "", "Companion", "plugin-scan_release"})
  public static final class c
  {
    public static final f.c.a IJJ;
    int IJH;
    mi IJI;
    int errCode = -1;
    String errMsg = "";
    int errType = -1;
    
    static
    {
      AppMethodBeat.i(222860);
      IJJ = new f.c.a((byte)0);
      AppMethodBeat.o(222860);
    }
    
    public final boolean fCF()
    {
      return this.IJH == 1;
    }
    
    public final void setErrMsg(String paramString)
    {
      AppMethodBeat.i(222857);
      p.k(paramString, "<set-?>");
      this.errMsg = paramString;
      AppMethodBeat.o(222857);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckHelper$checkImageCdnStatus$1", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckCallback;", "onCDNUploadStart", "", "mediaId", "", "onFinish", "checkCDNImageResult", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckResult;", "plugin-scan_release"})
  public static final class d
    implements e
  {
    d(f.c paramc, g paramg, f.b paramb, f.a parama) {}
    
    public final void a(h paramh)
    {
      int j = 0;
      AppMethodBeat.i(219246);
      p.k(paramh, "checkCDNImageResult");
      Log.i("MicroMsg.AiScanImageCDNCheckHelper", "alvinluo checkImageCdnStatus result errType: " + paramh.errType + ", errCode: " + paramh.errCode);
      this.IJK.errType = paramh.errType;
      this.IJK.errCode = paramh.errCode;
      this.IJK.setErrMsg("check cdn image error");
      if ((paramh.errType == 0) && (paramh.errCode == 0))
      {
        localObject = f.IJD;
        if (f.a(localg, paramh)) {
          Log.i("MicroMsg.AiScanImageCDNCheckHelper", "alvinluo checkImageCdnStatus no need to re-upload, fileId: %s", new Object[] { localg.fileId });
        }
      }
      else
      {
        paramh = parama;
        if (paramh == null) {
          break label318;
        }
        paramh.a(this.IJK);
        AppMethodBeat.o(219246);
        return;
      }
      Log.i("MicroMsg.AiScanImageCDNCheckHelper", "alvinluo checkImageCdnStatus re-upload image fileId: %s", new Object[] { paramh.fileId });
      Object localObject = this.IJK;
      mi localmi = new mi();
      label206:
      Point localPoint;
      if (paramb.lNK == 1)
      {
        localmi.RRX = 3;
        localPoint = paramb.IJE;
        if (localPoint == null) {
          break label313;
        }
      }
      label313:
      for (int i = localPoint.x;; i = 0)
      {
        localmi.w = i;
        localPoint = paramb.IJE;
        i = j;
        if (localPoint != null) {
          i = localPoint.y;
        }
        localmi.h = i;
        localmi.RSa = 1;
        localmi.RRY = paramh.fileId;
        localmi.RRZ = paramh.aesKey;
        ((f.c)localObject).IJI = localmi;
        break;
        if (paramb.lNK != 0) {
          break label206;
        }
        localmi.RRX = 5;
        break label206;
      }
      label318:
      AppMethodBeat.o(219246);
    }
    
    public final void aXd(String paramString)
    {
      AppMethodBeat.i(219250);
      p.k(paramString, "mediaId");
      f.a locala = parama;
      if (locala != null)
      {
        locala.aXc(paramString);
        AppMethodBeat.o(219250);
        return;
      }
      AppMethodBeat.o(219250);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.f
 * JD-Core Version:    0.7.0.1
 */