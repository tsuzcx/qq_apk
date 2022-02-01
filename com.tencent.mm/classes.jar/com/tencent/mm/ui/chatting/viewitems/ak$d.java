package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ak$d
  extends ak.b
{
  ImageView ptE;
  ImageView pxu;
  TextView pyj;
  ImageView pyk;
  
  public final void du(View paramView)
  {
    AppMethodBeat.i(37135);
    if (this.puO != null)
    {
      AppMethodBeat.o(37135);
      return;
    }
    ViewStub localViewStub = (ViewStub)paramView.findViewById(2131309893);
    if (localViewStub == null)
    {
      AppMethodBeat.o(37135);
      return;
    }
    localViewStub.inflate();
    this.puO = paramView.findViewById(2131298455);
    this.ptE = ((ImageView)this.puO.findViewById(2131299277));
    this.hbb = ((TextView)this.puO.findViewById(2131309195));
    this.pyj = ((TextView)this.puO.findViewById(2131305980));
    this.pxu = ((ImageView)this.puO.findViewById(2131305957));
    this.pyk = ((ImageView)this.puO.findViewById(2131310335));
    this.ptG = ((ImageView)this.puO.findViewById(2131299291));
    AppMethodBeat.o(37135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.d
 * JD-Core Version:    0.7.0.1
 */