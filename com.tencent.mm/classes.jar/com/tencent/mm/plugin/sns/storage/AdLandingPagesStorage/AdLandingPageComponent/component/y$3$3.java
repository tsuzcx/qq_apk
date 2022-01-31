package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.GLTextureView.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.a;
import com.tencent.mm.sdk.platformtools.ab;

final class y$3$3
  implements Runnable
{
  y$3$3(y.3 param3, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(145309);
    this.rxR.rxQ.rxI.crT();
    this.rxR.rxQ.rxI.rzX.requestRender();
    String str = this.rxR.rxQ.crs().rrf;
    if (!a.gw(str, "scene_ad_landing"))
    {
      ab.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "do shoot");
      a.a(this.rxR.rxQ.rxI, str, "scene_ad_landing");
    }
    ab.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "enable sensor after shoot");
    this.rxR.rxQ.rxI.setSensorEnabled(true);
    ab.i("MicroMsg.Sns.SphereImageView.AdLandingPageSphereImageComponent", "enable touch, delay=" + this.nKE);
    this.rxR.rxQ.rxI.setTouchEnabled(true);
    AppMethodBeat.o(145309);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y.3.3
 * JD-Core Version:    0.7.0.1
 */