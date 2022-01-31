package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class u$f
  extends u.b
{
  View gEY;
  ImageView jXH;
  ImageView jXx;
  View jYA;
  TextView pUE;
  MMNeat7extView pUs;
  ImageView pUt;
  
  public final void fj(View paramView)
  {
    AppMethodBeat.i(33075);
    if (this.jXr != null)
    {
      AppMethodBeat.o(33075);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131821878);
    if (localViewStub == null)
    {
      AppMethodBeat.o(33075);
      return;
    }
    localViewStub.inflate();
    this.jXr = paramView.findViewById(2131821905);
    this.gui = ((TextView)this.jXr.findViewById(2131820680));
    this.jXx = ((ImageView)this.jXr.findViewById(2131821438));
    this.jYA = this.jXr.findViewById(2131822519);
    this.gEY = this.jXr.findViewById(2131822522);
    this.pUs = ((MMNeat7extView)this.jXr.findViewById(2131822521));
    this.pUE = ((TextView)this.jXr.findViewById(2131822523));
    this.jXH = ((ImageView)this.jXr.findViewById(2131821909));
    this.pUt = ((ImageView)this.jXr.findViewById(2131822520));
    AppMethodBeat.o(33075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.f
 * JD-Core Version:    0.7.0.1
 */