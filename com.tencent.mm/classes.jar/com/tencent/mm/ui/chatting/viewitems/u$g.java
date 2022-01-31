package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class u$g
  extends u.b
{
  MMNeat7extView jXI;
  View zUO;
  
  public final void fj(View paramView)
  {
    AppMethodBeat.i(33076);
    if (this.jXr != null)
    {
      AppMethodBeat.o(33076);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131821884);
    if (localViewStub == null)
    {
      AppMethodBeat.o(33076);
      return;
    }
    localViewStub.inflate();
    this.jXr = paramView.findViewById(2131821932);
    this.zUO = paramView.findViewById(2131820697);
    this.jXI = ((MMNeat7extView)this.jXr.findViewById(2131820680));
    AppMethodBeat.o(33076);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.g
 * JD-Core Version:    0.7.0.1
 */