package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class ac$f
  extends ac.b
{
  TextView GMR;
  View isE;
  ImageView mZN;
  ImageView mZZ;
  View naT;
  MMNeat7extView naa;
  MMNeat7extView uWq;
  ImageView uWr;
  
  public final void dy(View paramView)
  {
    AppMethodBeat.i(37137);
    if (this.mYI != null)
    {
      AppMethodBeat.o(37137);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131306453);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37137);
      return;
    }
    localViewStub.inflate();
    this.mYI = paramView.findViewById(2131305992);
    this.naa = ((MMNeat7extView)this.mYI.findViewById(2131305902));
    this.mZN = ((ImageView)this.mYI.findViewById(2131298813));
    this.naT = this.mYI.findViewById(2131298818);
    this.isE = this.mYI.findViewById(2131297444);
    this.uWq = ((MMNeat7extView)this.mYI.findViewById(2131305946));
    this.GMR = ((TextView)this.mYI.findViewById(2131299135));
    this.mZZ = ((ImageView)this.mYI.findViewById(2131303387));
    this.uWr = ((ImageView)this.mYI.findViewById(2131298831));
    AppMethodBeat.o(37137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac.f
 * JD-Core Version:    0.7.0.1
 */