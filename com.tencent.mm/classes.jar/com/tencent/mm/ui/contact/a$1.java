package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.g;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33456);
    ab.d("MicroMsg.AddressAdapter", "click avatarIv");
    if (paramView == null)
    {
      AppMethodBeat.o(33456);
      return;
    }
    this.Aaf.jSb.r(paramView, this.Aaf.jSc.dc(paramView), 2131821108);
    AppMethodBeat.o(33456);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.1
 * JD-Core Version:    0.7.0.1
 */