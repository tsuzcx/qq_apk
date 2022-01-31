package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import java.util.HashMap;

final class a$3
  implements View.OnClickListener
{
  a$3(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(156717);
    ab.v("MicroMsg.AddressAdapter", "on delView clicked");
    this.Aaf.jSe.bKl();
    if (this.Aaf.pdU != null) {
      this.Aaf.pdU.bC(((ViewStub)a.f(this.Aaf).get(paramView)).getTag());
    }
    AppMethodBeat.o(156717);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.3
 * JD-Core Version:    0.7.0.1
 */