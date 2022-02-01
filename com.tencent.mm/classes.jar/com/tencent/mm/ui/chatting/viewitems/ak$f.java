package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class ak$f
  extends ak.b
{
  MMNeat7extView BCK;
  ImageView BCL;
  TextView PMm;
  View kmV;
  ImageView ptE;
  MMNeat7extView ptR;
  ImageView ptS;
  View puc;
  
  public final void du(View paramView)
  {
    AppMethodBeat.i(37137);
    if (this.puO != null)
    {
      AppMethodBeat.o(37137);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131309896);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37137);
      return;
    }
    localViewStub.inflate();
    this.puO = paramView.findViewById(2131309299);
    this.ptR = ((MMNeat7extView)this.puO.findViewById(2131309195));
    this.ptE = ((ImageView)this.puO.findViewById(2131299277));
    this.puc = this.puO.findViewById(2131299283);
    this.kmV = this.puO.findViewById(2131297673);
    this.BCK = ((MMNeat7extView)this.puO.findViewById(2131309246));
    this.PMm = ((TextView)this.puO.findViewById(2131299662));
    this.ptS = ((ImageView)this.puO.findViewById(2131306101));
    this.BCL = ((ImageView)this.puO.findViewById(2131299296));
    AppMethodBeat.o(37137);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.f
 * JD-Core Version:    0.7.0.1
 */