package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class ac$g
  extends ac.b
{
  TextView GMS;
  LinearLayout GMU;
  MMNeat7extView naa;
  
  public final void dy(View paramView)
  {
    AppMethodBeat.i(37138);
    if (this.mYI != null)
    {
      AppMethodBeat.o(37138);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131306454);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37138);
      return;
    }
    localViewStub.inflate();
    this.mYI = paramView.findViewById(2131298109);
    this.naa = ((MMNeat7extView)this.mYI.findViewById(2131305902));
    this.GMS = ((TextView)this.mYI.findViewById(2131305729));
    this.GMU = ((LinearLayout)this.mYI.findViewById(2131305743));
    AppMethodBeat.o(37138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac.g
 * JD-Core Version:    0.7.0.1
 */