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

final class j$7
  implements View.OnClickListener
{
  j$7(j paramj, g paramg, String paramString1, String paramString2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(265838);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingNewH5Comp$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.ujg.bYF();
    paramView = new HashMap();
    paramView.put("ret", "0");
    paramView.put("err_msg", "ok");
    paramView.put("phoneNumber", this.DZj);
    this.Kql.g(this.KpH, "ok", paramView);
    Log.i("AdLandingNewH5Comp", "handleBindPhoneNumber, ok");
    a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingNewH5Comp$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(265838);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j.7
 * JD-Core Version:    0.7.0.1
 */