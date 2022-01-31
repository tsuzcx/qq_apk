package com.tencent.mm.ui.contact;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.h;

final class ContactRemarkInfoModUI$5$1
  implements Runnable
{
  ContactRemarkInfoModUI$5$1(ContactRemarkInfoModUI.5 param5, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(153953);
    if (!this.egM)
    {
      h.bO(this.Acw.Acv, this.Acw.Acv.getString(2131296926));
      ContactRemarkInfoModUI.r(this.Acw.Acv).setVisibility(0);
      ContactRemarkInfoModUI.s(this.Acw.Acv).setVisibility(8);
      ContactRemarkInfoModUI.t(this.Acw.Acv).setVisibility(8);
      AppMethodBeat.o(153953);
      return;
    }
    ContactRemarkInfoModUI.u(this.Acw.Acv);
    AppMethodBeat.o(153953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkInfoModUI.5.1
 * JD-Core Version:    0.7.0.1
 */