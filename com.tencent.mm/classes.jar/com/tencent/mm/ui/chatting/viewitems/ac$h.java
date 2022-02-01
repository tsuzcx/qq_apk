package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class ac$h
  extends ac.b
{
  ImageView hg;
  ImageView mZN;
  ImageView mZZ;
  View naT;
  MMNeat7extView naa;
  TextView timeTv;
  
  public final void dy(View paramView)
  {
    AppMethodBeat.i(37139);
    if (this.mYI != null)
    {
      AppMethodBeat.o(37139);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131306455);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37139);
      return;
    }
    localViewStub.inflate();
    this.mYI = paramView.findViewById(2131298111);
    this.mZN = ((ImageView)this.mYI.findViewById(2131298813));
    this.mZY = ((ImageView)this.mYI.findViewById(2131298826));
    this.mZZ = ((ImageView)this.mYI.findViewById(2131303387));
    this.hg = ((ImageView)this.mYI.findViewById(2131306344));
    this.naa = ((MMNeat7extView)this.mYI.findViewById(2131305948));
    this.timeTv = ((TextView)this.mYI.findViewById(2131305822));
    this.naT = this.mYI.findViewById(2131298187);
    AppMethodBeat.o(37139);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac.h
 * JD-Core Version:    0.7.0.1
 */