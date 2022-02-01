package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import java.util.HashMap;

final class a$3
  implements View.OnClickListener
{
  a$3(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37568);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.v("MicroMsg.AddressAdapter", "on delView clicked");
    this.PSB.plb.ebp();
    if (this.PSB.AAA != null) {
      this.PSB.AAA.cZ(((ViewStub)a.d(this.PSB).get(paramView)).getTag());
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/AddressDrawWithCacheAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(37568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.3
 * JD-Core Version:    0.7.0.1
 */