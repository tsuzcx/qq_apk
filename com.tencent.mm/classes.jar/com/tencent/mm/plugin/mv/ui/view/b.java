package com.tencent.mm.plugin.mv.ui.view;

import android.graphics.Bitmap;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.xeffect.VLogDirector;
import com.tencent.mm.xeffect.effect.EffectManager;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvBitmapEffector;", "", "()V", "TAG", "", "eGLEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eGLHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "eGLThread", "Landroid/os/HandlerThread;", "effectCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "", "effectManager", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "height", "", "imageBitmap", "imageTex", "Lcom/tencent/mm/media/globject/GLTextureObject;", "outputTex", "texNeedCrop", "", "vLogDirector", "Lcom/tencent/mm/xeffect/VLogDirector;", "width", "createEGLEnvironmentIfNeed", "createEGLThread", "destroy", "init", "queue", "call", "Lkotlin/Function0;", "render", "requestEffect", "callback", "requestRender", "setBlurEffect", "blurRadius", "", "setGradientBlurEffect", "blurTop", "blurBottom", "blurMaskRatio", "contentOffset", "setInputBitmap", "bitmap", "setOutputSize", "plugin-mv_release"})
public final class b
{
  HandlerThread AsC;
  MMHandler AsD;
  VLogDirector AsI;
  d Axw;
  d Axx;
  kotlin.g.a.b<? super Bitmap, x> Axy;
  boolean Axz;
  final String TAG;
  int height;
  c.b ilw;
  Bitmap imageBitmap;
  EffectManager wet;
  int width;
  
  public b()
  {
    AppMethodBeat.i(257472);
    this.TAG = ("MicroMsg.Mv.MusicMvBitmapEffector@" + hashCode());
    this.AsI = new VLogDirector();
    this.wet = new EffectManager();
    this.Axz = true;
    AppMethodBeat.o(257472);
  }
  
  public final void k(a<x> parama)
  {
    AppMethodBeat.i(257471);
    p.h(parama, "call");
    Object localObject = this.AsC;
    if (localObject != null)
    {
      if (((HandlerThread)localObject).isAlive() == true)
      {
        localObject = this.AsD;
        if (localObject != null)
        {
          ((MMHandler)localObject).post((Runnable)new c(parama));
          AppMethodBeat.o(257471);
        }
      }
    }
    else
    {
      AppMethodBeat.o(257471);
      return;
    }
    AppMethodBeat.o(257471);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(b paramb, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/mv/ui/view/MusicMvBitmapEffector$render$1$1"})
  static final class c
    implements Runnable
  {
    c(Bitmap paramBitmap, b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(257468);
      kotlin.g.a.b localb = this.AxA.Axy;
      if (localb != null)
      {
        localb.invoke(this.AxB);
        AppMethodBeat.o(257468);
        return;
      }
      AppMethodBeat.o(257468);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.b
 * JD-Core Version:    0.7.0.1
 */