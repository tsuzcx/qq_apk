package com.tencent.mm.plugin.voip.video.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipRenderOnScreenProgram;", "", "renderSize", "", "(I)V", "mTextureProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipTextureRenderProgram;", "mYUVProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipYUVRenderProgram;", "drawFrame", "", "pBuff", "", "w", "h", "flag", "", "release", "renderImpl", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "texture", "renderMode", "updateDrawViewSize", "width", "height", "Companion", "plugin-voip_release"})
public final class d
{
  public static final a ARp;
  public e ARn;
  public g ARo;
  
  static
  {
    AppMethodBeat.i(208728);
    ARp = new a((byte)0);
    AppMethodBeat.o(208728);
  }
  
  public d(int paramInt)
  {
    AppMethodBeat.i(208727);
    if (paramInt == 1)
    {
      this.ARo = new g();
      this.ARn = new e(true);
      AppMethodBeat.o(208727);
      return;
    }
    this.ARn = new e(false);
    AppMethodBeat.o(208727);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipRenderOnScreenProgram$Companion;", "", "()V", "RENDER_MODE_TEXTURE", "", "RENDER_MODE_YUV", "RENDER_SIDE_LOCAL", "RENDER_SIDE_REMOTE", "TAG", "", "plugin-voip_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.d
 * JD-Core Version:    0.7.0.1
 */