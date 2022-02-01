package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ac$e
  extends ac.b
{
  ImageView hg;
  ImageView mZN;
  ImageView mZZ;
  View naT;
  ImageView uWr;
  
  public final void dy(View paramView)
  {
    AppMethodBeat.i(37136);
    if (this.mYI != null)
    {
      AppMethodBeat.o(37136);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131306451);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37136);
      return;
    }
    localViewStub.inflate();
    this.mYI = paramView.findViewById(2131298107);
    this.mZN = ((ImageView)this.mYI.findViewById(2131298813));
    this.mZY = ((ImageView)this.mYI.findViewById(2131298826));
    this.mZZ = ((ImageView)this.mYI.findViewById(2131303387));
    this.uWr = ((ImageView)this.mYI.findViewById(2131298831));
    this.hg = ((ImageView)this.mYI.findViewById(2131303256));
    this.naT = this.mYI.findViewById(2131298160);
    AppMethodBeat.o(37136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac.e
 * JD-Core Version:    0.7.0.1
 */