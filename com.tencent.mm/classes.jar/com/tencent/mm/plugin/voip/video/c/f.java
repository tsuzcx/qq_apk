package com.tencent.mm.plugin.voip.video.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipRenderOnScreenProgram;", "", "renderSize", "", "(I)V", "mTextureProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipTextureRenderProgram;", "mYUVProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipYUVRenderProgram;", "drawFrame", "", "pBuff", "", "w", "h", "flag", "", "release", "renderImpl", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "texture", "renderMode", "updateDrawViewSize", "width", "height", "Companion", "plugin-voip_release"})
public final class f
{
  public static final a CIE;
  public g CIC;
  public i CID;
  
  static
  {
    AppMethodBeat.i(210497);
    CIE = new a((byte)0);
    AppMethodBeat.o(210497);
  }
  
  public f(int paramInt)
  {
    AppMethodBeat.i(210496);
    if (paramInt == 1)
    {
      this.CID = new i();
      this.CIC = new g(true);
      AppMethodBeat.o(210496);
      return;
    }
    this.CIC = new g(false);
    AppMethodBeat.o(210496);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipRenderOnScreenProgram$Companion;", "", "()V", "RENDER_MODE_TEXTURE", "", "RENDER_MODE_YUV", "RENDER_SIDE_LOCAL", "RENDER_SIDE_REMOTE", "TAG", "", "plugin-voip_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.f
 * JD-Core Version:    0.7.0.1
 */