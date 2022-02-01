package com.tencent.mm.plugin.vlog.player.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect;
import com.tencent.tavkit.composition.video.TAVVideoMixEffect.Filter;
import d.g.a.a;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/render/VLogCompositionMixEffect;", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect;", "effectConfig", "Lcom/tencent/mm/protocal/protobuf/VlogResp;", "(Lcom/tencent/mm/protocal/protobuf/VlogResp;)V", "()V", "filter", "Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoCompositionEffect;", "createFilter", "Lcom/tencent/tavkit/composition/video/TAVVideoMixEffect$Filter;", "effectId", "", "getFrameTexture", "", "getFrameTextureHeight", "getFrameTextureWidth", "renderContext", "Landroid/opengl/EGLContext;", "setBlendBitmapProvider", "", "blendBitmapProvider", "Lkotlin/Function1;", "", "Landroid/graphics/Bitmap;", "setCropRect", "rect", "Landroid/graphics/Rect;", "setFilter", "path", "weight", "", "setFrameRenderCallback", "callback", "Lkotlin/Function0;", "updateRenderSize", "width", "height", "Companion", "plugin-vlog_release"})
public final class h
  implements TAVVideoMixEffect
{
  public static final a Lth;
  public c Ltg;
  
  static
  {
    AppMethodBeat.i(201073);
    Lth = new a((byte)0);
    AppMethodBeat.o(201073);
  }
  
  public h()
  {
    AppMethodBeat.i(201072);
    this.Ltg = new c();
    AppMethodBeat.o(201072);
  }
  
  public h(dkv paramdkv)
  {
    AppMethodBeat.i(201071);
    this.Ltg = new c();
    f localf = this.Ltg.LsN;
    StringBuilder localStringBuilder = new StringBuilder("setEffectConfig:");
    if (paramdkv != null) {}
    for (int i = paramdkv.hashCode();; i = 0)
    {
      ad.i("MiroMsg.MultiVideoVLogEffectRenderProc", i);
      localf.LqR = paramdkv;
      AppMethodBeat.o(201071);
      return;
    }
  }
  
  public final void K(b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(201068);
    k.h(paramb, "blendBitmapProvider");
    this.Ltg.K(paramb);
    AppMethodBeat.o(201068);
  }
  
  public final void U(a<y> parama)
  {
    AppMethodBeat.i(201070);
    k.h(parama, "callback");
    this.Ltg.U(parama);
    AppMethodBeat.o(201070);
  }
  
  public final TAVVideoMixEffect.Filter createFilter()
  {
    return (TAVVideoMixEffect.Filter)this.Ltg;
  }
  
  public final String effectId()
  {
    AppMethodBeat.i(201065);
    String str = "VLogCompositionMixEffect_" + hashCode();
    AppMethodBeat.o(201065);
    return str;
  }
  
  public final void li(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201066);
    this.Ltg.li(paramInt1, paramInt2);
    AppMethodBeat.o(201066);
  }
  
  public final void p(String paramString, float paramFloat)
  {
    AppMethodBeat.i(201069);
    k.h(paramString, "path");
    this.Ltg.p(paramString, paramFloat);
    AppMethodBeat.o(201069);
  }
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(201067);
    k.h(paramRect, "rect");
    this.Ltg.setCropRect(paramRect);
    AppMethodBeat.o(201067);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/render/VLogCompositionMixEffect$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.a.h
 * JD-Core Version:    0.7.0.1
 */