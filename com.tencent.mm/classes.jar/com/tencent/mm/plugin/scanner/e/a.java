package com.tencent.mm.plugin.scanner.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.util.a.b;
import com.tencent.mm.plugin.scanner.util.a.e;
import com.tencent.mm.plugin.scanner.util.a.h;
import com.tencent.mm.plugin.scanner.util.a.i;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil;", "", "()V", "DEFAULT_DATA_LENGTH_FOR_IMAGE_OCR_CDN", "", "DEFAULT_DATA_LENGTH_FOR_IMAGE_SEARCH_CDN", "Image_Search_Status_Local_Add_Cdn_Task_Error", "Image_Search_Status_Server_Error", "Image_Search_status_OK", "MAX_DATA_LENGTH_FOR_IMAGE_OCR_CDN", "MAX_DATA_LENGTH_FOR_IMAGE_SEARCH_CDN", "MIN_DATA_LENGTH_FOR_IMAGE_OCR_CDN", "MIN_DATA_LENGTH_FOR_IMAGE_SEARCH_CDN", "TAG", "", "configOCRMaxImageSize", "getConfigOCRMaxImageSize", "()I", "configOCRMaxImageSize$delegate", "Lkotlin/Lazy;", "configSearchMaxImageSize", "getConfigSearchMaxImageSize", "configSearchMaxImageSize$delegate", "imageCompressStrategy", "Lcom/tencent/mm/plugin/scanner/util/compress/AiImageCompressStrategy;", "getImageCompressStrategy", "()Lcom/tencent/mm/plugin/scanner/util/compress/AiImageCompressStrategy;", "imageCompressStrategy$delegate", "cancelUploadImage", "", "mediaId", "checkCDNImage", "", "checkRequest", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckRequest;", "callback", "Lcom/tencent/mm/plugin/scanner/image/AiScanImageCDNCheckCallback;", "decodeBitmap", "Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "imagePath", "maxImageSize", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMaxImageSize", "opImageType", "getMediaIdByPath", "filePath", "getOCRMaxImageSize", "getSearchMaxImageSize", "isImageSizeLargerThanConfig", "imageSize", "Landroid/graphics/Point;", "configMaxImageSize", "saveBitmapToFile", "bitmap", "Landroid/graphics/Bitmap;", "targetImagePath", "(Landroid/graphics/Bitmap;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadImage", "Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchCdnUploadResult;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ImageSearchCdnUploadResult", "ImageSearchDecodeResult", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a OPN;
  private static final j OPO;
  private static final j OPP;
  private static final j OPQ;
  
  static
  {
    AppMethodBeat.i(313625);
    OPN = new a();
    OPO = kotlin.k.cm((kotlin.g.a.a)d.OPX);
    OPP = kotlin.k.cm((kotlin.g.a.a)c.OPW);
    OPQ = kotlin.k.cm((kotlin.g.a.a)f.OPZ);
    AppMethodBeat.o(313625);
  }
  
  public static final boolean a(Point paramPoint, int paramInt)
  {
    AppMethodBeat.i(313603);
    if (paramPoint == null)
    {
      AppMethodBeat.o(313603);
      return false;
    }
    Log.d("MicroMsg.AIScanImageCdnUploadUtil", "alvinluo isImageSizeLargerThanConfig image size: %s", new Object[] { paramPoint });
    if (paramPoint.x * paramPoint.y > paramInt)
    {
      AppMethodBeat.o(313603);
      return true;
    }
    AppMethodBeat.o(313603);
    return false;
  }
  
  public static final int ahJ(int paramInt)
  {
    AppMethodBeat.i(313597);
    switch (paramInt)
    {
    case 2: 
    default: 
      paramInt = gQD();
      AppMethodBeat.o(313597);
      return paramInt;
    case 1: 
      paramInt = gQD();
      AppMethodBeat.o(313597);
      return paramInt;
    }
    paramInt = ((Number)OPP.getValue()).intValue();
    AppMethodBeat.o(313597);
    return paramInt;
  }
  
  public static Object e(String paramString, final int paramInt, kotlin.d.d<? super a> paramd)
  {
    AppMethodBeat.i(313602);
    paramString = l.a((f)bg.kCi(), (m)new e(paramString, paramInt, null), paramd);
    AppMethodBeat.o(313602);
    return paramString;
  }
  
  private static int gQD()
  {
    AppMethodBeat.i(313591);
    int i = ((Number)OPO.getValue()).intValue();
    AppMethodBeat.o(313591);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "", "()V", "newHeight", "", "getNewHeight", "()I", "setNewHeight", "(I)V", "newWidth", "getNewWidth", "setNewWidth", "originHeight", "getOriginHeight", "setOriginHeight", "originWidth", "getOriginWidth", "setOriginWidth", "resultImagePath", "", "getResultImagePath", "()Ljava/lang/String;", "setResultImagePath", "(Ljava/lang/String;)V", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public int HJN;
    public int HJO;
    String OPR;
    int OPS;
    int OPT;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final c OPW;
    
    static
    {
      AppMethodBeat.i(313651);
      OPW = new c();
      AppMethodBeat.o(313651);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final d OPX;
    
    static
    {
      AppMethodBeat.i(313649);
      OPX = new d();
      AppMethodBeat.o(313649);
    }
    
    d()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/scanner/image/AIScanImageCdnUploadUtil$ImageSearchDecodeResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super a.a>, Object>
  {
    Object Uf;
    Object VC;
    int label;
    
    e(String paramString, int paramInt, kotlin.d.d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(313689);
      paramd = new e(this.qVp, paramInt, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(313689);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      boolean bool2 = true;
      int j = 0;
      AppMethodBeat.i(313680);
      Object localObject3 = kotlin.d.a.a.aiwj;
      int i;
      Object localObject1;
      Object localObject2;
      Bitmap localBitmap;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(313680);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = new com.tencent.mm.plugin.scanner.util.a.a(this.qVp);
        int k = paramInt;
        i = k;
        if (k < 0)
        {
          localObject1 = a.OPN;
          i = a.gQF();
        }
        paramObject.maxImageSize = i;
        paramObject = (com.tencent.mm.plugin.scanner.util.a.g)paramObject;
        localObject1 = a.OPN;
        localObject2 = e.a(paramObject, (i)a.gQE());
        localBitmap = ((h)localObject2).bitmap;
        if (localBitmap == null)
        {
          Log.e("MicroMsg.AIScanImageCdnUploadUtil", "decode error, bitmap is null");
          AppMethodBeat.o(313680);
          return null;
        }
        Log.i("MicroMsg.AIScanImageCdnUploadUtil", "decode result,width:" + localBitmap.getWidth() + ", height:" + localBitmap.getHeight());
        paramObject = this.qVp;
        localObject1 = kotlin.n.d.UTF_8;
        if (paramObject == null)
        {
          paramObject = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(313680);
          throw paramObject;
        }
        paramObject = paramObject.getBytes((Charset)localObject1);
        s.s(paramObject, "(this as java.lang.String).getBytes(charset)");
        localObject1 = s.X("wcf://ImageSearchFilePath/", com.tencent.mm.b.g.getMessageDigest(paramObject));
        paramObject = a.OPN;
        paramObject = (kotlin.d.d)this;
        this.L$0 = localObject2;
        this.Uf = localBitmap;
        this.VC = localObject1;
        this.label = 1;
        paramObject = a.a(localBitmap, (String)localObject1, paramObject);
        if (paramObject == localObject3)
        {
          AppMethodBeat.o(313680);
          return localObject3;
        }
        break;
      case 1: 
        localObject1 = (String)this.VC;
        localBitmap = (Bitmap)this.Uf;
        localObject2 = (h)this.L$0;
        ResultKt.throwOnFailure(paramObject);
      }
      for (;;)
      {
        boolean bool1 = ((Boolean)paramObject).booleanValue();
        boolean bool3 = y.ZC((String)localObject1);
        if ((!bool1) || (!bool3))
        {
          paramObject = new StringBuilder("save Image Fail, saveSuccess:");
          if (bool1)
          {
            bool1 = true;
            paramObject = paramObject.append(bool1).append(", fileExist:");
            if (!bool3) {
              break label420;
            }
          }
          label420:
          for (bool1 = bool2;; bool1 = false)
          {
            Log.i("MicroMsg.AIScanImageCdnUploadUtil", bool1);
            AppMethodBeat.o(313680);
            return null;
            bool1 = false;
            break;
          }
        }
        paramObject = new a.a();
        localObject3 = ((h)localObject2).PjY;
        if (localObject3 == null)
        {
          i = 0;
          paramObject.HJO = i;
          localObject2 = ((h)localObject2).PjY;
          if (localObject2 != null) {
            break label512;
          }
        }
        label512:
        for (i = j;; i = ((Point)localObject2).x)
        {
          paramObject.HJN = i;
          paramObject.OPS = localBitmap.getWidth();
          paramObject.OPT = localBitmap.getHeight();
          paramObject.OPR = ((String)localObject1);
          AppMethodBeat.o(313680);
          return paramObject;
          i = ((Point)localObject3).y;
          break;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/scanner/util/compress/AiImageCompressStrategy;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<b>
  {
    public static final f OPZ;
    
    static
    {
      AppMethodBeat.i(313657);
      OPZ = new f();
      AppMethodBeat.o(313657);
    }
    
    f()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super Boolean>, Object>
  {
    int label;
    
    g(Bitmap paramBitmap, String paramString, kotlin.d.d<? super g> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(313647);
      paramObject = (kotlin.d.d)new g(this.eGL, this.OQa, paramd);
      AppMethodBeat.o(313647);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      boolean bool2 = true;
      AppMethodBeat.i(313638);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(313638);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      try
      {
        bool1 = BitmapUtil.saveBitmapToImage(this.eGL, 100, Bitmap.CompressFormat.JPEG, this.OQa, true);
        if (bool1)
        {
          bool1 = bool2;
          AppMethodBeat.o(313638);
          return Boolean.valueOf(bool1);
        }
      }
      finally
      {
        for (;;)
        {
          Log.i("MicroMsg.AIScanImageCdnUploadUtil", s.X("save bitmap to image fail:", paramObject.getLocalizedMessage()));
          boolean bool1 = false;
          continue;
          bool1 = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.e.a
 * JD-Core Version:    0.7.0.1
 */