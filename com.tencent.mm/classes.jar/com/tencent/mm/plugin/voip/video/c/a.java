package com.tencent.mm.plugin.voip.video.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.plugin.voip.f.h;
import com.tencent.mm.plugin.voip.video.render.c;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.r;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/programv2/EncoderSurfacePixelReader;", "", "()V", "renderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "surfaceOut", "Lcom/tencent/mm/plugin/voip/video/render/EncoderSurfaceRender;", "useGpuConvert", "", "release", "", "renderImpl", "outputTexture", "", "setMirror", "isMirror", "setRGBDataCallback", "callback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "setRotate", "encodeRotate", "updateDrawViewSize", "width", "height", "updateEncodeResType", "encWidth", "encHeight", "encoderType", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  c URh;
  final boolean URi;
  e mWu;
  
  public a()
  {
    AppMethodBeat.i(293243);
    h localh = h.ULL;
    this.URi = h.ibC();
    if (this.URi)
    {
      this.URh = new c();
      AppMethodBeat.o(293243);
      return;
    }
    this.mWu = new e(0, 0, 0, 0, 2, 0, 32);
    AppMethodBeat.o(293243);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Ljava/nio/ByteBuffer;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<ByteBuffer, ah>
  {
    a(r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, ah> paramr, a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.a
 * JD-Core Version:    0.7.0.1
 */