package com.tencent.mm.plugin.voip.video.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/voip/video/programv2/VoipRenderOnScreenProgram;", "", "renderSize", "", "(I)V", "mTextureProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipTextureRenderProgram;", "mYUVProgram", "Lcom/tencent/mm/plugin/voip/video/programv2/VoipYUVRenderProgram;", "drawFrame", "", "pBuff", "", "w", "h", "flag", "", "release", "renderImpl", "cubeBuffer", "Ljava/nio/FloatBuffer;", "textureCoordBuff", "texture", "renderMode", "updateDrawViewSize", "width", "height", "Companion", "plugin-voip_release"})
public final class d
{
  public static final d.a zyy;
  public e zyw;
  public g zyx;
  
  static
  {
    AppMethodBeat.i(192377);
    zyy = new d.a((byte)0);
    AppMethodBeat.o(192377);
  }
  
  public d(int paramInt)
  {
    AppMethodBeat.i(192376);
    if (paramInt == 1)
    {
      this.zyx = new g();
      this.zyw = new e(true);
      AppMethodBeat.o(192376);
      return;
    }
    this.zyw = new e(false);
    AppMethodBeat.o(192376);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.c.d
 * JD-Core Version:    0.7.0.1
 */