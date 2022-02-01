package com.tencent.mm.plugin.vlog.player.render;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoXLabEffectRenderProc;", "Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoRenderProc;", "()V", "filterPath", "", "filterWeight", "", "outputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "checkCreateOutputTexture", "", "checkInitXLabEffect", "hasEffect", "", "release", "render", "Lcom/tencent/tav/coremedia/TextureInfo;", "context", "Lcom/tencent/tavkit/ciimage/CIContext;", "ptsMs", "", "inputTextures", "", "setFilter", "path", "weight", "updateEffect", "Companion", "plugin-vlog_release"})
public final class g
  extends e
{
  public static final a Arm;
  public String Ark = "";
  public float Arl;
  public XLabEffect fZP;
  d gqY;
  
  static
  {
    AppMethodBeat.i(207749);
    Arm = new a((byte)0);
    AppMethodBeat.o(207749);
  }
  
  public final void release()
  {
    AppMethodBeat.i(207748);
    super.release();
    d locald = this.gqY;
    if (locald != null)
    {
      locald.close();
      AppMethodBeat.o(207748);
      return;
    }
    AppMethodBeat.o(207748);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoXLabEffectRenderProc$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.render.g
 * JD-Core Version:    0.7.0.1
 */