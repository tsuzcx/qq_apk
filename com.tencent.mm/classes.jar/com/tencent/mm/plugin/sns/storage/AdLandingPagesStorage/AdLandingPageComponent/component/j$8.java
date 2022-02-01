package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.g;
import java.util.HashMap;
import java.util.Map;

final class j$8
  implements View.OnClickListener
{
  j$8(j paramj, g paramg, String paramString) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(265535);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingNewH5Comp$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.ujg.bYF();
    paramView = new HashMap();
    paramView.put("ret", "0");
    paramView.put("err_msg", "fail not bind phone");
    this.Kql.g(this.KpH, "fail not bind phone", paramView);
    Log.i("AdLandingNewH5Comp", "handleBindPhoneNumber, not bind phone");
    a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingNewH5Comp$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(265535);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j.8
 * JD-Core Version:    0.7.0.1
 */