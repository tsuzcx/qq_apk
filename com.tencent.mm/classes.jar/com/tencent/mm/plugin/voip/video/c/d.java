package com.tencent.mm.plugin.voip.video.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipRenderOnScreenProgram;", "", "renderSize", "", "(I)V", "mTextureProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipTextureRenderProgram;", "mYUVProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipYUVRenderProgram;", "drawFrame", "", "pBuff", "", "w", "h", "flag", "", "release", "renderImpl", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "texture", "renderMode", "updateDrawViewSize", "width", "height", "Companion", "plugin-voip_release"})
public final class d
{
  public static final d.a Hmz;
  public f Hmx;
  public h Hmy;
  
  static
  {
    AppMethodBeat.i(236173);
    Hmz = new d.a((byte)0);
    AppMethodBeat.o(236173);
  }
  
  public d(int paramInt)
  {
    AppMethodBeat.i(236172);
    if (paramInt == 1)
    {
      this.Hmy = new h();
      this.Hmx = new f(true);
      AppMethodBeat.o(236172);
      return;
    }
    this.Hmx = new f(false);
    AppMethodBeat.o(236172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.d
 * JD-Core Version:    0.7.0.1
 */