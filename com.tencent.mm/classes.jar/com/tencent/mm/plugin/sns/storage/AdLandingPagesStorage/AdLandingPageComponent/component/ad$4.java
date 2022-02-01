package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.sdk.platformtools.Log;

final class ad$4
  implements View.OnLongClickListener
{
  ad$4(ad paramad) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(292771);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPagePureImageComponet$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
    Log.i("AdLandingPagePureImageComponet", "onLongClick, filePath=" + this.KsN.JQu);
    boolean bool = this.KsN.Kqk.kr(this.KsN.JQu, this.KsN.imageUrl);
    a.a(bool, this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPagePureImageComponet$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(292771);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad.4
 * JD-Core Version:    0.7.0.1
 */