package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ac$d
  extends ac.b
{
  ImageView mZN;
  ImageView mZQ;
  TextView naQ;
  ImageView naR;
  
  public final void dy(View paramView)
  {
    AppMethodBeat.i(37135);
    if (this.mYI != null)
    {
      AppMethodBeat.o(37135);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131306450);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37135);
      return;
    }
    localViewStub.inflate();
    this.mYI = paramView.findViewById(2131298105);
    this.mZN = ((ImageView)this.mYI.findViewById(2131298813));
    this.fQp = ((TextView)this.mYI.findViewById(2131305902));
    this.naQ = ((TextView)this.mYI.findViewById(2131303307));
    this.mZQ = ((ImageView)this.mYI.findViewById(2131303284));
    this.naR = ((ImageView)this.mYI.findViewById(2131306868));
    this.mZY = ((ImageView)this.mYI.findViewById(2131298826));
    AppMethodBeat.o(37135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac.d
 * JD-Core Version:    0.7.0.1
 */