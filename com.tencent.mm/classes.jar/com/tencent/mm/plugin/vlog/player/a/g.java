package com.tencent.mm.plugin.vlog.player.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoXLabEffectRenderProc;", "Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoRenderProc;", "()V", "filterPath", "", "filterWeight", "", "outputTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "xLabEffect", "Lcom/tencent/mm/plugin/xlabeffect/XLabEffect;", "checkCreateOutputTexture", "", "checkInitXLabEffect", "hasEffect", "", "release", "render", "Lcom/tencent/tav/coremedia/TextureInfo;", "context", "Lcom/tencent/tavkit/ciimage/CIContext;", "ptsMs", "", "inputTextures", "", "setFilter", "path", "weight", "updateEffect", "Companion", "plugin-vlog_release"})
public final class g
  extends e
{
  public static final a Ltf;
  String Ltd = "";
  float Lte;
  XLabEffect fVU;
  d zwE;
  
  static
  {
    AppMethodBeat.i(201064);
    Ltf = new a((byte)0);
    AppMethodBeat.o(201064);
  }
  
  public final void release()
  {
    AppMethodBeat.i(201063);
    super.release();
    d locald = this.zwE;
    if (locald != null)
    {
      locald.close();
      AppMethodBeat.o(201063);
      return;
    }
    AppMethodBeat.o(201063);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/render/MultiVideoXLabEffectRenderProc$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.a.g
 * JD-Core Version:    0.7.0.1
 */