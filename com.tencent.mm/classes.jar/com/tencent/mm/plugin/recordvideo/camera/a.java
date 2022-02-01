package com.tencent.mm.plugin.recordvideo.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.d.h;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/camera/CameraController;", "Lcom/tencent/mm/plugin/recordvideo/camera/ICameraController;", "context", "Landroid/content/Context;", "globalConfig", "Lcom/tencent/mm/plugin/recordvideo/camera/ICameraController$IndependentCameraConfig;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/recordvideo/camera/ICameraController$IndependentCameraConfig;)V", "cameraInstance", "Lcom/tencent/mm/media/widget/camera/ICommonCamera;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "frameAvailableListener", "Lkotlin/Function1;", "Lcom/tencent/mm/media/globject/GLTextureObject;", "Lkotlin/ParameterName;", "name", "texture", "", "getGlobalConfig", "()Lcom/tencent/mm/plugin/recordvideo/camera/ICameraController$IndependentCameraConfig;", "setGlobalConfig", "(Lcom/tencent/mm/plugin/recordvideo/camera/ICameraController$IndependentCameraConfig;)V", "lastSwitchCameraStamp", "", "needResumeRecorder", "", "previewView", "Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;", "recorderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/media/widget/recorder/IMediaRecorder;", "Lkotlin/collections/ArrayList;", "cancelRecord", "isRecording", "release", "startPreview", "preview", "config", "Lcom/tencent/mm/plugin/recordvideo/camera/ICameraController$PreviewConfig;", "(Lcom/tencent/mm/media/widget/camerarecordview/preview/ICameraPreviewView;Lcom/tencent/mm/plugin/recordvideo/camera/ICameraController$PreviewConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startRecord", "configList", "", "Lcom/tencent/mm/plugin/recordvideo/camera/ICameraController$RecordConfig;", "stopPreView", "clearScreen", "stopRecord", "Lcom/tencent/mm/plugin/recordvideo/camera/ICameraController$RecordResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchCamera", "takePictureAndSave", "takePictureBitmap", "Landroid/graphics/Bitmap;", "Companion", "plugin-recordvideo_release"})
public final class a
  implements c
{
  public static final a HJc;
  private final com.tencent.mm.media.widget.a.e HIW;
  private final ArrayList<com.tencent.mm.media.widget.c.b> HIX;
  private com.tencent.mm.media.widget.camerarecordview.preview.e HIY;
  private long HIZ;
  private final kotlin.g.a.b<com.tencent.mm.media.g.d, x> HJa;
  private c.a HJb;
  Context context;
  private volatile boolean leB;
  
  static
  {
    AppMethodBeat.i(216369);
    HJc = new a((byte)0);
    AppMethodBeat.o(216369);
  }
  
  private a(Context paramContext, c.a parama)
  {
    AppMethodBeat.i(216367);
    this.context = paramContext;
    this.HJb = parama;
    paramContext = b.HJh;
    paramContext = this.context;
    int i = this.HJb.HJi;
    p.k(paramContext, "context");
    switch (i)
    {
    default: 
      p.k(paramContext, "context");
      paramContext = b.hQ(paramContext);
    }
    for (;;)
    {
      this.HIW = paramContext;
      this.HIX = new ArrayList();
      this.HJa = ((kotlin.g.a.b)new b(this));
      AppMethodBeat.o(216367);
      return;
      paramContext = b.hP(paramContext);
      continue;
      paramContext = b.hQ(paramContext);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/camera/CameraController$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/media/globject/GLTextureObject;", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<com.tencent.mm.media.g.d, x>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class c
    extends j
    implements m<ak, kotlin.d.d<? super Boolean>, Object>
  {
    Object L$0;
    int label;
    Object oDA;
    private ak p$;
    
    c(a parama, c.b paramb, com.tencent.mm.media.widget.camerarecordview.preview.e parame, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(216938);
      p.k(paramd, "completion");
      paramd = new c(this.HJd, this.HJe, this.HJf, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(216938);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(216941);
      paramObject1 = ((c)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(216941);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(216933);
      Object localObject2 = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(216933);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        if (a.a(this.HJd).aXQ())
        {
          Log.i("MicroMsg.CameraController", "camera is previewing,return");
          paramObject = Boolean.TRUE;
          AppMethodBeat.o(216933);
          return paramObject;
        }
        if (!a.a(this.HJd).y(this.HJd.context, this.HJe.Fie))
        {
          Log.i("MicroMsg.CameraController", "cameraInstance initCamera error!");
          paramObject = Boolean.FALSE;
          AppMethodBeat.o(216933);
          return paramObject;
        }
        a.a(this.HJd, this.HJf);
        localObject1 = this.HJf;
        com.tencent.mm.media.j.a locala = this.HJe.kWg;
        b localb = b.HJh;
        ((com.tencent.mm.media.widget.camerarecordview.preview.e)localObject1).a(locala, b.aZo());
        this.L$0 = paramObject;
        this.oDA = this;
        this.label = 1;
        paramObject = new h(kotlin.d.a.b.k(this));
        localObject1 = (kotlin.d.d)paramObject;
        this.HJf.d((kotlin.g.a.b)new a((kotlin.d.d)localObject1));
        localObject1 = paramObject.iBS();
        if (localObject1 == kotlin.d.a.a.aaAA) {
          p.k(this, "frame");
        }
        paramObject = localObject1;
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(216933);
          return localObject2;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (SurfaceTexture)paramObject;
      if (paramObject == null)
      {
        Log.i("MicroMsg.CameraController", "ICameraPreviewView get null surfacetextue!");
        paramObject = Boolean.FALSE;
        AppMethodBeat.o(216933);
        return paramObject;
      }
      Object localObject1 = a.a(this.HJd);
      localObject2 = b.HJh;
      ((com.tencent.mm.media.widget.a.e)localObject1).a(paramObject, b.aZo(), this.HJe.laV, this.HJe.HJk);
      paramObject = this.HJf;
      localObject1 = a.a(this.HJd).aYf();
      if (localObject1 == null) {
        p.iCn();
      }
      paramObject.a((com.tencent.mm.media.widget.a.b)localObject1);
      this.HJf.setOnDrawListener(a.c(this.HJd));
      paramObject = Boolean.TRUE;
      AppMethodBeat.o(216933);
      return paramObject;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.b<SurfaceTexture, x>
    {
      a(kotlin.d.d paramd)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class d
    extends j
    implements m<ak, kotlin.d.d<? super Boolean>, Object>
  {
    int label;
    private ak p$;
    
    d(a parama, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(218575);
      p.k(paramd, "completion");
      paramd = new d(this.HJd, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(218575);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(218577);
      paramObject1 = ((d)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(218577);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(218571);
      Object localObject = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(218571);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if (!com.tencent.mm.media.widget.d.c.aYX())
      {
        Log.i("MicroMsg.CameraPreviewContainer", "only one camera,refuse switch");
        paramObject = Boolean.FALSE;
        AppMethodBeat.o(218571);
        return paramObject;
      }
      if (System.currentTimeMillis() - a.d(this.HJd) < 1500L)
      {
        paramObject = Boolean.FALSE;
        AppMethodBeat.o(218571);
        return paramObject;
      }
      a.a(this.HJd, System.currentTimeMillis());
      a.fvv();
      paramObject = a.b(this.HJd);
      if (paramObject != null) {
        paramObject.aMN();
      }
      a.a(this.HJd).aXP();
      paramObject = a.a(this.HJd).aYf();
      if (paramObject != null)
      {
        localObject = a.b(this.HJd);
        if (localObject != null) {
          ((com.tencent.mm.media.widget.camerarecordview.preview.e)localObject).a(paramObject);
        }
        paramObject = ((Iterable)a.e(this.HJd)).iterator();
        while (paramObject.hasNext())
        {
          localObject = (com.tencent.mm.media.widget.c.b)paramObject.next();
          ((com.tencent.mm.media.widget.c.b)localObject).setMirror(com.tencent.mm.media.widget.a.b.isFrontCamera());
          ((com.tencent.mm.media.widget.c.b)localObject).u(com.tencent.mm.media.widget.a.b.getPreviewWidth(), com.tencent.mm.media.widget.a.b.getPreviewHeight(), com.tencent.mm.media.widget.a.b.aXY(), com.tencent.mm.media.widget.a.b.aXZ());
        }
      }
      paramObject = Boolean.TRUE;
      AppMethodBeat.o(218571);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.camera.a
 * JD-Core Version:    0.7.0.1
 */