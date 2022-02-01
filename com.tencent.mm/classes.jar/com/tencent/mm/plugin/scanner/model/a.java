package com.tencent.mm.plugin.scanner.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.c;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.d.h;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil;", "", "()V", "DEFAULT_DATA_LENGTH_FOR_IMAGE_SEARCH_CDN", "", "Image_Search_Status_Local_Add_Cdn_Task_Error", "Image_Search_Status_Server_Error", "Image_Search_status_OK", "MAX_DATA_LENGTH_FOR_IMAGE_SEARCH_CDN", "MIN_DATA_LENGTH_FOR_IMAGE_SEARCH_CDN", "TAG", "", "configMaxImageSize", "getConfigMaxImageSize", "()I", "configMaxImageSize$delegate", "Lkotlin/Lazy;", "cancelUploadImage", "", "mediaId", "decodeBitmap", "Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "imagePath", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMediaIdByPath", "filePath", "saveBitmapToFile", "bitmap", "Landroid/graphics/Bitmap;", "targetImagePath", "(Landroid/graphics/Bitmap;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadImage", "Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ImageSearchCdnUploadResult", "ImageSearchDecodeResult", "plugin-scan_release"})
public final class a
{
  private static final kotlin.f CEx;
  public static final a CEy;
  
  static
  {
    AppMethodBeat.i(240376);
    CEy = new a();
    CEx = kotlin.g.ah((kotlin.g.a.a)a.c.CEA);
    AppMethodBeat.o(240376);
  }
  
  public static final Object a(String paramString1, String paramString2, kotlin.d.d<? super a> paramd)
  {
    AppMethodBeat.i(240374);
    h localh = new h(kotlin.d.a.b.e(paramd));
    kotlin.d.d locald = (kotlin.d.d)localh;
    if (paramString1 == null)
    {
      paramString1 = new a();
      paramString1.errCode = -1;
      paramString2 = Result.Companion;
      locald.resumeWith(Result.constructor-impl(paramString1));
    }
    for (;;)
    {
      paramString1 = localh.hxK();
      if (paramString1 == kotlin.d.a.a.SXO) {
        p.h(paramd, "frame");
      }
      AppMethodBeat.o(240374);
      return paramString1;
      Log.i("MicroMsg.AIScanImageCdnUploader", "alvinluo uploadImage using cdn mediaId: %s", new Object[] { paramString2 });
      com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
      localg.taskName = "task_AiScanImagetUploadTask";
      localg.field_mediaId = paramString2;
      localg.field_fullpath = paramString1;
      localg.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
      localg.field_priority = com.tencent.mm.i.a.gpM;
      localg.field_needStorage = false;
      localg.field_needCompressImage = true;
      localg.field_isStreamMedia = false;
      localg.field_force_aeskeycdn = true;
      localg.field_trysafecdn = false;
      localg.gqD = 15;
      localg.gqy = ((g.a)new f(locald));
      if (!com.tencent.mm.an.f.baQ().f(localg))
      {
        paramString1 = new a();
        paramString1.errCode = -2;
        paramString2 = Result.Companion;
        locald.resumeWith(Result.constructor-impl(paramString1));
      }
    }
  }
  
  public static Object a(String paramString, kotlin.d.d<? super b> paramd)
  {
    AppMethodBeat.i(240373);
    paramString = kotlinx.coroutines.g.a((kotlin.d.f)ba.hMW(), (m)new d(paramString, null), paramd);
    AppMethodBeat.o(240373);
    return paramString;
  }
  
  public static String aMv(String paramString)
  {
    AppMethodBeat.i(240371);
    p.h(paramString, "filePath");
    paramString = z.aTY() + "_image_search_" + paramString + "_" + System.currentTimeMillis();
    AppMethodBeat.o(240371);
    return paramString;
  }
  
  public static final boolean aMw(String paramString)
  {
    AppMethodBeat.i(240375);
    p.h(paramString, "mediaId");
    boolean bool = com.tencent.mm.an.f.baQ().Ob(paramString);
    AppMethodBeat.o(240375);
    return bool;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;", "", "()V", "aesKey", "", "getAesKey", "()Ljava/lang/String;", "setAesKey", "(Ljava/lang/String;)V", "errCode", "", "getErrCode", "()I", "setErrCode", "(I)V", "fileID", "getFileID", "setFileID", "imageUrl", "getImageUrl", "setImageUrl", "plugin-scan_release"})
  public static final class a
  {
    public String aesKey;
    int errCode;
    public String fileID;
    public String imageUrl;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "", "()V", "originHeight", "", "getOriginHeight", "()I", "setOriginHeight", "(I)V", "originWidth", "getOriginWidth", "setOriginWidth", "resultImagePath", "", "getResultImagePath", "()Ljava/lang/String;", "setResultImagePath", "(Ljava/lang/String;)V", "plugin-scan_release"})
  public static final class b
  {
    String CEz;
    public int xlg;
    public int xlh;
  }
  
  @kotlin.d.b.a.f(c="com.tencent.mm.plugin.scanner.model.AIScanImageCdnUploadUtil$decodeBitmap$2", f="AIScanImageCdnUploadUtil.kt", hxM={121}, m="invokeSuspend")
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class d
    extends j
    implements m<ai, kotlin.d.d<? super a.b>, Object>
  {
    int CEB;
    int CEC;
    float CED;
    Object L$0;
    int label;
    private ai p$;
    Object pED;
    Object pEE;
    Object pEF;
    Object pEG;
    int pEQ;
    int pER;
    int pES;
    
    d(String paramString, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(240363);
      p.h(paramd, "completion");
      paramd = new d(this.lbx, paramd);
      paramd.p$ = ((ai)paramObject);
      AppMethodBeat.o(240363);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(240364);
      paramObject1 = ((d)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.SXb);
      AppMethodBeat.o(240364);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(240362);
      kotlin.d.a.a locala = kotlin.d.a.a.SXO;
      int j;
      int i;
      Object localObject3;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(240362);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Object localObject4 = this.p$;
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapUtil.decodeFile(this.lbx, localOptions);
        j = localOptions.outWidth;
        int k = localOptions.outHeight;
        if ((j <= 0) || (k <= 0))
        {
          Log.e("MicroMsg.AiScanImageSceneUploader", "Error outWidth:" + j + ", outHeight:" + k);
          AppMethodBeat.o(240362);
          return null;
        }
        int m = j * k;
        i = 1;
        float f = m;
        paramObject = a.CEy;
        f /= a.ePL();
        if (f > 1.0F) {
          i = (int)(float)Math.ceil((float)Math.sqrt(f));
        }
        paramObject = new StringBuilder("rate:").append(f).append(", inSampleSize: ").append(i).append(", originWidth:").append(localOptions.outWidth).append(", originHeight:").append(localOptions.outHeight).append(", configMaxImageSize:");
        Object localObject1 = a.CEy;
        Log.i("MicroMsg.AiScanImageSceneUploader", a.ePL());
        localObject1 = null;
        paramObject = localObject1;
        try
        {
          int n = BackwardSupportUtil.ExifHelper.getExifOrientation(this.lbx);
          paramObject = localObject1;
          localOptions.inSampleSize = i;
          paramObject = localObject1;
          localOptions.inJustDecodeBounds = false;
          paramObject = localObject1;
          localObject1 = BitmapUtil.decodeFile(this.lbx, localOptions);
          paramObject = localObject1;
          localObject1 = BitmapUtil.rotate((Bitmap)localObject1, n);
          paramObject = localObject1;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Log.e("MicroMsg.AiScanImageSceneUploader", "decode error, " + localThrowable.getLocalizedMessage());
          }
          Log.i("MicroMsg.AiScanImageSceneUploader", "decode result,width:" + paramObject.getWidth() + ", height:" + paramObject.getHeight());
          localObject2 = this.lbx;
          localObject3 = kotlin.n.d.UTF_8;
          if (localObject2 != null) {
            break label448;
          }
          paramObject = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(240362);
          throw paramObject;
          localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
          p.g(localObject2, "(this as java.lang.String).getBytes(charset)");
          localObject2 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject2);
          localObject3 = "wcf://ImageSearchFilePath/".concat(String.valueOf(localObject2));
          a locala1 = a.CEy;
          this.L$0 = localObject4;
          this.pED = localOptions;
          this.pEQ = j;
          this.pER = k;
          this.pES = m;
          this.CEB = i;
          this.CED = f;
          this.CEC = i;
          this.pEE = paramObject;
          this.pEF = localObject2;
          this.pEG = localObject3;
          this.label = 1;
          localObject4 = a.a(paramObject, (String)localObject3, this);
          localObject2 = localObject4;
          paramObject = localObject3;
          i = k;
          if (localObject4 != locala) {
            break;
          }
        }
        if (paramObject == null)
        {
          Log.e("MicroMsg.AiScanImageSceneUploader", "decode error, bitmap is null");
          AppMethodBeat.o(240362);
          return null;
        }
        AppMethodBeat.o(240362);
        return locala;
      case 1: 
        label448:
        localObject3 = (String)this.pEG;
        i = this.pER;
        j = this.pEQ;
        ResultKt.throwOnFailure(paramObject);
        localObject2 = paramObject;
        paramObject = localObject3;
      }
      boolean bool1 = ((Boolean)localObject2).booleanValue();
      boolean bool2 = s.YS(paramObject);
      if ((!bool1) || (!bool2))
      {
        Log.i("MicroMsg.AiScanImageSceneUploader", "save Image Fail, saveSuccess:" + bool1 + ", fileExist:" + bool2);
        AppMethodBeat.o(240362);
        return null;
      }
      Object localObject2 = new a.b();
      ((a.b)localObject2).xlh = i;
      ((a.b)localObject2).xlg = j;
      ((a.b)localObject2).CEz = paramObject;
      AppMethodBeat.o(240362);
      return localObject2;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/model/AIScanImageCdnUploadUtil$uploadImage$2$2", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "callback", "", "mediaId", "", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "p1", "Ljava/io/ByteArrayOutputStream;", "plugin-scan_release"})
  public static final class f
    implements g.a
  {
    f(kotlin.d.d paramd) {}
    
    public final int a(String paramString, int paramInt, c paramc, com.tencent.mm.i.d paramd, boolean paramBoolean)
    {
      Object localObject = null;
      AppMethodBeat.i(240369);
      if (paramInt != 0)
      {
        paramString = this.iCb;
        paramc = new a.a();
        paramc.errCode = -1;
        paramd = Result.Companion;
        paramString.resumeWith(Result.constructor-impl(paramc));
        Log.e("MicroMsg.AIScanImageCdnUploader", "AIScanImageCdnUploader upload start fail: ".concat(String.valueOf(paramInt)));
        AppMethodBeat.o(240369);
        return 0;
      }
      StringBuilder localStringBuilder = new StringBuilder("upload callback,id:").append(paramString).append(" len:");
      if (paramc != null)
      {
        paramString = Long.valueOf(paramc.field_finishedLength);
        localStringBuilder = localStringBuilder.append(paramString).append(", totalLen:");
        paramString = localObject;
        if (paramc != null) {
          paramString = Long.valueOf(paramc.field_toltalLength);
        }
        Log.i("MicroMsg.AIScanImageCdnUploader", paramString);
        if (paramd != null)
        {
          if (paramd.field_retCode == 0) {
            break label223;
          }
          Log.e("MicroMsg.AIScanImageCdnUploader", "AIScanImageCdnUploader upload result fail: " + paramd.field_retCode);
          paramString = this.iCb;
          paramc = new a.a();
          paramc.errCode = -1;
          paramd = Result.Companion;
          paramString.resumeWith(Result.constructor-impl(paramc));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(240369);
        return 0;
        paramString = null;
        break;
        label223:
        Log.i("MicroMsg.AIScanImageCdnUploader", "AIScanImageCdnUploader success");
        paramString = this.iCb;
        paramc = new a.a();
        paramc.errCode = 0;
        paramc.fileID = paramd.field_fileId;
        paramc.aesKey = paramd.field_aesKey;
        paramc.imageUrl = paramd.field_fileUrl;
        paramd = Result.Companion;
        paramString.resumeWith(Result.constructor-impl(paramc));
      }
    }
    
    public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
    {
      AppMethodBeat.i(240368);
      Log.i("MicroMsg.AIScanImageCdnUploader", "getCdnAuthInfo, mediaId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(240368);
    }
    
    public final byte[] f(String paramString, byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(240370);
      Log.i("MicroMsg.AIScanImageCdnUploader", "decodePrepareResponse, mediaId = %s", new Object[] { paramString });
      AppMethodBeat.o(240370);
      return new byte[0];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.a
 * JD-Core Version:    0.7.0.1
 */