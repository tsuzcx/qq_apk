package com.tencent.mm.plugin.scanner.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.util.a.b;
import com.tencent.mm.plugin.scanner.util.a.e;
import com.tencent.mm.plugin.scanner.util.a.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.nio.charset.Charset;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.bc;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil;", "", "()V", "DEFAULT_DATA_LENGTH_FOR_IMAGE_OCR_CDN", "", "DEFAULT_DATA_LENGTH_FOR_IMAGE_SEARCH_CDN", "Image_Search_Status_Local_Add_Cdn_Task_Error", "Image_Search_Status_Server_Error", "Image_Search_status_OK", "MAX_DATA_LENGTH_FOR_IMAGE_OCR_CDN", "MAX_DATA_LENGTH_FOR_IMAGE_SEARCH_CDN", "MIN_DATA_LENGTH_FOR_IMAGE_OCR_CDN", "MIN_DATA_LENGTH_FOR_IMAGE_SEARCH_CDN", "TAG", "", "configOCRMaxImageSize", "getConfigOCRMaxImageSize", "()I", "configOCRMaxImageSize$delegate", "Lkotlin/Lazy;", "configSearchMaxImageSize", "getConfigSearchMaxImageSize", "configSearchMaxImageSize$delegate", "imageCompressStrategy", "Lcom/tencent/mm/plugin/scanner/util/compress/AiImageCompressStrategy;", "getImageCompressStrategy", "()Lcom/tencent/mm/plugin/scanner/util/compress/AiImageCompressStrategy;", "imageCompressStrategy$delegate", "cancelUploadImage", "", "mediaId", "checkCDNImage", "", "checkRequest", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckRequest;", "callback", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckCallback;", "decodeBitmap", "Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "imagePath", "maxImageSize", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMaxImageSize", "opImageType", "getMediaIdByPath", "filePath", "getOCRMaxImageSize", "getSearchMaxImageSize", "isImageSizeLargerThanConfig", "imageSize", "Landroid/graphics/Point;", "configMaxImageSize", "saveBitmapToFile", "bitmap", "Landroid/graphics/Bitmap;", "targetImagePath", "(Landroid/graphics/Bitmap;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadImage", "Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ImageSearchCdnUploadResult", "ImageSearchDecodeResult", "plugin-scan_release"})
public final class a
{
  private static final kotlin.f IIZ;
  private static final kotlin.f IJa;
  private static final kotlin.f IJb;
  public static final a IJc;
  
  static
  {
    AppMethodBeat.i(217909);
    IJc = new a();
    IIZ = kotlin.g.ar((kotlin.g.a.a)d.IJj);
    IJa = kotlin.g.ar((kotlin.g.a.a)c.IJi);
    IJb = kotlin.g.ar((kotlin.g.a.a)f.IJl);
    AppMethodBeat.o(217909);
  }
  
  public static final boolean a(Point paramPoint, int paramInt)
  {
    AppMethodBeat.i(217905);
    if (paramPoint == null)
    {
      AppMethodBeat.o(217905);
      return false;
    }
    Log.d("MicroMsg.AIScanImageCdnUploadUtil", "alvinluo isImageSizeLargerThanConfig image size: %s", new Object[] { paramPoint });
    if (paramPoint.x * paramPoint.y > paramInt)
    {
      AppMethodBeat.o(217905);
      return true;
    }
    AppMethodBeat.o(217905);
    return false;
  }
  
  public static final int adm(int paramInt)
  {
    AppMethodBeat.i(217900);
    switch (paramInt)
    {
    case 2: 
    default: 
      paramInt = fCB();
      AppMethodBeat.o(217900);
      return paramInt;
    case 1: 
      paramInt = fCB();
      AppMethodBeat.o(217900);
      return paramInt;
    }
    paramInt = ((Number)IJa.getValue()).intValue();
    AppMethodBeat.o(217900);
    return paramInt;
  }
  
  public static Object b(String paramString, final int paramInt, kotlin.d.d<? super a> paramd)
  {
    AppMethodBeat.i(217903);
    paramString = kotlinx.coroutines.i.a((kotlin.d.f)bc.iRs(), (m)new e(paramString, paramInt, null), paramd);
    AppMethodBeat.o(217903);
    return paramString;
  }
  
  private static int fCB()
  {
    AppMethodBeat.i(217898);
    int i = ((Number)IIZ.getValue()).intValue();
    AppMethodBeat.o(217898);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "", "()V", "newHeight", "", "getNewHeight", "()I", "setNewHeight", "(I)V", "newWidth", "getNewWidth", "setNewWidth", "originHeight", "getOriginHeight", "setOriginHeight", "originWidth", "getOriginWidth", "setOriginWidth", "resultImagePath", "", "getResultImagePath", "()Ljava/lang/String;", "setResultImagePath", "(Ljava/lang/String;)V", "plugin-scan_release"})
  public static final class a
  {
    public int BXA;
    public int BXB;
    String IJd;
    int IJe;
    int IJf;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Integer>
  {
    public static final c IJi;
    
    static
    {
      AppMethodBeat.i(218676);
      IJi = new c();
      AppMethodBeat.o(218676);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<Integer>
  {
    public static final d IJj;
    
    static
    {
      AppMethodBeat.i(218538);
      IJj = new d();
      AppMethodBeat.o(218538);
    }
    
    d()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class e
    extends j
    implements m<ak, kotlin.d.d<? super a.a>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private ak p$;
    Object pGq;
    Object pGr;
    Object rdb;
    Object sPl;
    
    e(String paramString, int paramInt, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(223680);
      p.k(paramd, "completion");
      paramd = new e(this.nVF, paramInt, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(223680);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(223681);
      paramObject1 = ((e)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(223681);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      int j = 0;
      AppMethodBeat.i(223679);
      Object localObject4 = kotlin.d.a.a.aaAA;
      Object localObject3;
      int i;
      Object localObject1;
      Object localObject2;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(223679);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localObject3 = this.p$;
        com.tencent.mm.plugin.scanner.util.a.a locala = new com.tencent.mm.plugin.scanner.util.a.a(this.nVF);
        if (paramInt < 0) {
          paramObject = a.IJc;
        }
        for (i = a.fCC();; i = paramInt)
        {
          locala.maxImageSize = i;
          paramObject = (com.tencent.mm.plugin.scanner.util.a.g)locala;
          localObject1 = a.IJc;
          localObject2 = e.a(paramObject, (com.tencent.mm.plugin.scanner.util.a.i)a.fCD());
          paramObject = ((h)localObject2).bitmap;
          if (paramObject != null) {
            break;
          }
          Log.e("MicroMsg.AIScanImageCdnUploadUtil", "decode error, bitmap is null");
          AppMethodBeat.o(223679);
          return null;
        }
        Log.i("MicroMsg.AIScanImageCdnUploadUtil", "decode result,width:" + paramObject.getWidth() + ", height:" + paramObject.getHeight());
        localObject1 = this.nVF;
        Object localObject5 = kotlin.n.d.UTF_8;
        if (localObject1 == null)
        {
          paramObject = new t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(223679);
          throw paramObject;
        }
        localObject1 = ((String)localObject1).getBytes((Charset)localObject5);
        p.j(localObject1, "(this as java.lang.String).getBytes(charset)");
        localObject5 = com.tencent.mm.b.g.getMessageDigest((byte[])localObject1);
        localObject1 = "wcf://ImageSearchFilePath/".concat(String.valueOf(localObject5));
        a locala1 = a.IJc;
        this.L$0 = localObject3;
        this.oDA = locala;
        this.pGq = localObject2;
        this.pGr = paramObject;
        this.rdb = localObject5;
        this.sPl = localObject1;
        this.label = 1;
        localObject3 = a.a(paramObject, (String)localObject1, this);
        if (localObject3 == localObject4)
        {
          AppMethodBeat.o(223679);
          return localObject4;
        }
        break;
      case 1: 
        localObject1 = (String)this.sPl;
        localObject4 = (Bitmap)this.pGr;
        localObject2 = (h)this.pGq;
        ResultKt.throwOnFailure(paramObject);
        localObject3 = paramObject;
        paramObject = localObject4;
      }
      for (;;)
      {
        boolean bool1 = ((Boolean)localObject3).booleanValue();
        boolean bool2 = u.agG((String)localObject1);
        if ((!bool1) || (!bool2))
        {
          Log.i("MicroMsg.AIScanImageCdnUploadUtil", "save Image Fail, saveSuccess:" + bool1 + ", fileExist:" + bool2);
          AppMethodBeat.o(223679);
          return null;
        }
        localObject3 = new a.a();
        localObject4 = ((h)localObject2).Jag;
        if (localObject4 != null) {}
        for (i = ((Point)localObject4).y;; i = 0)
        {
          ((a.a)localObject3).BXB = i;
          localObject2 = ((h)localObject2).Jag;
          i = j;
          if (localObject2 != null) {
            i = ((Point)localObject2).x;
          }
          ((a.a)localObject3).BXA = i;
          ((a.a)localObject3).IJe = paramObject.getWidth();
          ((a.a)localObject3).IJf = paramObject.getHeight();
          ((a.a)localObject3).IJd = ((String)localObject1);
          AppMethodBeat.o(223679);
          return localObject3;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/scanner/util/compress/AiImageCompressStrategy;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<b>
  {
    public static final f IJl;
    
    static
    {
      AppMethodBeat.i(217685);
      IJl = new f();
      AppMethodBeat.o(217685);
    }
    
    f()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class g
    extends j
    implements m<ak, kotlin.d.d<? super Boolean>, Object>
  {
    int label;
    private ak p$;
    
    g(Bitmap paramBitmap, String paramString, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(221156);
      p.k(paramd, "completion");
      paramd = new g(this.cLr, this.IJm, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(221156);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(221158);
      paramObject1 = ((g)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(221158);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(221150);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(221150);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      boolean bool1 = false;
      try
      {
        boolean bool2 = BitmapUtil.saveBitmapToImage(this.cLr, 100, Bitmap.CompressFormat.JPEG, this.IJm, true);
        bool1 = bool2;
      }
      catch (Throwable paramObject)
      {
        for (;;)
        {
          Log.i("MicroMsg.AIScanImageCdnUploadUtil", "save bitmap to image fail:" + paramObject.getLocalizedMessage());
        }
      }
      AppMethodBeat.o(221150);
      return Boolean.valueOf(bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.a
 * JD-Core Version:    0.7.0.1
 */