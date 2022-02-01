package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.xlabeffect.k;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/render/CameraKitXEffectRender;", "Lcom/tencent/mm/plugin/recordvideo/render/XEffectRenderer;", "()V", "inputTextureObj", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getOutputTexture", "", "texture", "render", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends c
{
  public d NQW;
  
  public a()
  {
    super(6);
  }
  
  public final void bgE()
  {
    AppMethodBeat.i(279397);
    d locald1 = this.NQW;
    if (locald1 == null)
    {
      AppMethodBeat.o(279397);
      return;
    }
    d locald2 = gJc();
    if (locald2 == null)
    {
      AppMethodBeat.o(279397);
      return;
    }
    k localk = this.muW;
    if (localk != null) {
      k.a(localk, locald1.nAF);
    }
    d.a(locald2, this.mWn, this.mWo, 0, null, 0, 0, 60);
    localk = this.muW;
    if (localk != null) {
      k.a(localk, locald1, locald2, false, 60);
    }
    AppMethodBeat.o(279397);
  }
  
  public final d bgF()
  {
    AppMethodBeat.i(279401);
    d locald = gJc();
    AppMethodBeat.o(279401);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.a
 * JD-Core Version:    0.7.0.1
 */