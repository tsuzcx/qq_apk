package com.tencent.mm.plugin.voip.video.render;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.c.b;
import com.tencent.mm.plugin.voip.video.c.c;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.r;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/render/VoipEncoderTextureRenderProcTexture;", "Lcom/tencent/mm/plugin/voip/video/render/VoipTextureRenderProcTexture;", "textureWidth", "", "textureHeight", "drawWidth", "drawHeight", "renderOutputType", "scaleType", "(IIIIII)V", "setEncodeMirror", "", "isMirror", "", "setEncodeRotate", "encodeRotate", "setRGBDataCallback", "callback", "Lkotlin/Function4;", "Ljava/nio/ByteBuffer;", "Lcom/tencent/mm/plugin/voip/video/program/FaceBeautyDataCallBack;", "updateEncodeResType", "encodeWidth", "encodeHeight", "encoderType", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends n
{
  private l(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, 0, paramInt3, 1, 2);
    AppMethodBeat.i(293079);
    this.UUp = ((b)new c());
    AppMethodBeat.o(293079);
  }
  
  public final void GZ(boolean paramBoolean)
  {
    AppMethodBeat.i(293092);
    b localb = this.UUp;
    if (localb != null) {
      localb.setMirror(paramBoolean);
    }
    AppMethodBeat.o(293092);
  }
  
  public final void arz(int paramInt)
  {
    AppMethodBeat.i(293096);
    b localb = this.UUp;
    if (localb != null) {
      localb.th(paramInt);
    }
    AppMethodBeat.o(293096);
  }
  
  public final void bl(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(293106);
    b localb = this.UUp;
    if (localb != null) {
      localb.bl(paramInt1, paramInt2, paramInt3);
    }
    AppMethodBeat.o(293106);
  }
  
  public final void i(r<? super ByteBuffer, ? super Integer, ? super Integer, ? super Integer, ah> paramr)
  {
    AppMethodBeat.i(293101);
    s.u(paramr, "callback");
    b localb = this.UUp;
    if (localb != null) {
      localb.i(paramr);
    }
    AppMethodBeat.o(293101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.l
 * JD-Core Version:    0.7.0.1
 */