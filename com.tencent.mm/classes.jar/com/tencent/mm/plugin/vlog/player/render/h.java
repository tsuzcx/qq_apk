package com.tencent.mm.plugin.vlog.player.render;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dqm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter;
import d.g.a.b;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/player/render/VLogCompositionMixEffect;", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect;", "effectConfig", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "(Lcom/tencent/mm/protocal/protobuf/VlogResp;)V", "()V", "filter", "Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoCompositionEffect;", "createFilter", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect$Filter;", "effectId", "", "getEffect", "Lcom/tencent/mm/plugin/vlog/player/render/BaseMultiVideoCompositionEffect;", "getFrameTexture", "", "getFrameTextureHeight", "getFrameTextureWidth", "renderContext", "Landroid/opengl/EGLContext;", "setBlendBitmapProvider", "", "blendBitmapProvider", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "setCropRect", "rect", "Landroid/graphics/Rect;", "setFilter", "path", "weight", "", "setFrameRenderCallback", "callback", "Lkotlin/Function0;", "updateRenderSize", "width", "height", "Companion", "plugin-vlog_release"})
public final class h
  implements TAVVideoMixEffect
{
  public static final h.a Aro;
  public c Arn;
  
  static
  {
    AppMethodBeat.i(207756);
    Aro = new h.a((byte)0);
    AppMethodBeat.o(207756);
  }
  
  public h()
  {
    AppMethodBeat.i(207755);
    this.Arn = new c();
    AppMethodBeat.o(207755);
  }
  
  public h(dqm paramdqm)
  {
    AppMethodBeat.i(207754);
    this.Arn = new c();
    f localf = this.Arn.AqU;
    StringBuilder localStringBuilder = new StringBuilder("setEffectConfig:");
    if (paramdqm != null) {}
    for (int i = paramdqm.hashCode();; i = 0)
    {
      ac.i("MiroMsg.MultiVideoVLogEffectRenderProc", i);
      localf.AnZ = paramdqm;
      AppMethodBeat.o(207754);
      return;
    }
  }
  
  public final void D(b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(207753);
    k.h(paramb, "blendBitmapProvider");
    this.Arn.D(paramb);
    AppMethodBeat.o(207753);
  }
  
  public final TAVVideoMixEffect.Filter createFilter()
  {
    return (TAVVideoMixEffect.Filter)this.Arn;
  }
  
  public final String effectId()
  {
    AppMethodBeat.i(207750);
    String str = "VLogCompositionMixEffect_" + hashCode();
    AppMethodBeat.o(207750);
    return str;
  }
  
  public final void ia(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(207751);
    this.Arn.ia(paramInt1, paramInt2);
    AppMethodBeat.o(207751);
  }
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(207752);
    k.h(paramRect, "rect");
    this.Arn.setCropRect(paramRect);
    AppMethodBeat.o(207752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.render.h
 * JD-Core Version:    0.7.0.1
 */