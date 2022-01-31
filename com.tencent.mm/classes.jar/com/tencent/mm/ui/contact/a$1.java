package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import java.util.HashMap;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    y.v("MicroMsg.AddressAdapter", "on delView clicked");
    this.vIN.hZg.bdc();
    if (this.vIN.mDS != null) {
      this.vIN.mDS.bg(((ViewStub)a.a(this.vIN).get(paramView)).getTag());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.1
 * JD-Core Version:    0.7.0.1
 */