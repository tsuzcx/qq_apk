package com.tencent.mm.plugin.voip.video.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipRenderOnScreenProgram;", "", "renderSize", "", "(I)V", "mTextureProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipTextureRenderProgram;", "mYUVProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipYUVRenderProgram;", "drawFrame", "", "pBuff", "", "w", "h", "flag", "", "release", "renderImpl", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "texture", "renderMode", "updateDrawViewSize", "width", "height", "Companion", "plugin-voip_release"})
public final class g
{
  public static final g.a Odo;
  public i Odm;
  public k Odn;
  
  static
  {
    AppMethodBeat.i(239444);
    Odo = new g.a((byte)0);
    AppMethodBeat.o(239444);
  }
  
  public g(int paramInt)
  {
    AppMethodBeat.i(239443);
    if (paramInt == 1)
    {
      this.Odn = new k();
      this.Odm = new i(true);
      AppMethodBeat.o(239443);
      return;
    }
    this.Odm = new i(false);
    AppMethodBeat.o(239443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.g
 * JD-Core Version:    0.7.0.1
 */