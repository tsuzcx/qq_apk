package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class u$e
  extends u.b
{
  ImageView iTH;
  ImageView jXH;
  ImageView jXx;
  View jYA;
  ImageView pUt;
  
  public final void fj(View paramView)
  {
    AppMethodBeat.i(33074);
    if (this.jXr != null)
    {
      AppMethodBeat.o(33074);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131821880);
    if (localViewStub == null)
    {
      AppMethodBeat.o(33074);
      return;
    }
    localViewStub.inflate();
    this.jXr = paramView.findViewById(2131821918);
    this.jXx = ((ImageView)this.jXr.findViewById(2131821438));
    this.jXG = ((ImageView)this.jXr.findViewById(2131821917));
    this.jXH = ((ImageView)this.jXr.findViewById(2131821909));
    this.pUt = ((ImageView)this.jXr.findViewById(2131822520));
    this.iTH = ((ImageView)this.jXr.findViewById(2131821921));
    this.jYA = this.jXr.findViewById(2131821920);
    AppMethodBeat.o(33074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.e
 * JD-Core Version:    0.7.0.1
 */