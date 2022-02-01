package com.tencent.mm.plugin.voip.video.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipRenderOnScreenProgram;", "", "renderSize", "", "(I)V", "mTextureProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipTextureRenderProgram;", "mYUVProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipYUVRenderProgram;", "drawFrame", "", "pBuff", "", "w", "h", "flag", "", "release", "renderImpl", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "texture", "renderMode", "updateDrawViewSize", "width", "height", "Companion", "plugin-voip_release"})
public final class f
{
  public static final a Cra;
  public g CqY;
  public i CqZ;
  
  static
  {
    AppMethodBeat.i(216076);
    Cra = new a((byte)0);
    AppMethodBeat.o(216076);
  }
  
  public f(int paramInt)
  {
    AppMethodBeat.i(216075);
    if (paramInt == 1)
    {
      this.CqZ = new i();
      this.CqY = new g(true);
      AppMethodBeat.o(216075);
      return;
    }
    this.CqY = new g(false);
    AppMethodBeat.o(216075);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipRenderOnScreenProgram$Companion;", "", "()V", "RENDER_MODE_TEXTURE", "", "RENDER_MODE_YUV", "RENDER_SIDE_LOCAL", "RENDER_SIDE_REMOTE", "TAG", "", "plugin-voip_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.f
 * JD-Core Version:    0.7.0.1
 */