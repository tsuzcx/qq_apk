package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class ak$g
  extends ak.b
{
  TextView PMn;
  LinearLayout PMo;
  MMNeat7extView ptR;
  
  public final void du(View paramView)
  {
    AppMethodBeat.i(37138);
    if (this.puO != null)
    {
      AppMethodBeat.o(37138);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131309897);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37138);
      return;
    }
    localViewStub.inflate();
    this.puO = paramView.findViewById(2131298459);
    this.ptR = ((MMNeat7extView)this.puO.findViewById(2131309195));
    this.PMn = ((TextView)this.puO.findViewById(2131308996));
    this.PMo = ((LinearLayout)this.puO.findViewById(2131309010));
    AppMethodBeat.o(37138);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.g
 * JD-Core Version:    0.7.0.1
 */