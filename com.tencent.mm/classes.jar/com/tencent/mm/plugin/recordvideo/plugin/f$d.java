package com.tencent.mm.plugin.recordvideo.plugin;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.e;
import com.tencent.mm.api.r;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/recordvideo/plugin/EditPhotoContainerPlugin$loadPhotoEditLogic$2", "Lcom/tencent/mm/api/ISelectedFeatureListener;", "onSelectedDetailFeature", "", "features", "Lcom/tencent/mm/api/FeaturesType;", "index", "", "onSelectedFeature", "showVKB", "isShow", "", "plugin-recordvideo_release"})
public final class f$d
  implements r
{
  public final void a(e parame)
  {
    AppMethodBeat.i(150620);
    j.q(parame, "features");
    ab.i("MicroMsg.EditPhotoPluginLayout", "[onSelectedFeature] features:%s", new Object[] { parame.name() });
    if (parame == e.bVV) {
      d.b.a(this.qbZ.qbI, d.c.qff);
    }
    AppMethodBeat.o(150620);
  }
  
  public final void a(e parame, int paramInt)
  {
    AppMethodBeat.i(150621);
    j.q(parame, "features");
    ab.i("MicroMsg.EditPhotoPluginLayout", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { parame.name(), Integer.valueOf(paramInt) });
    AppMethodBeat.o(150621);
  }
  
  public final void bk(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.f.d
 * JD-Core Version:    0.7.0.1
 */