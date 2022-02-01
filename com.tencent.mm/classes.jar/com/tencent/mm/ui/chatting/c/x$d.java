package com.tencent.mm.ui.chatting.c;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.aj;

final class x$d
  extends RecyclerView.v
{
  static final c frV;
  RelativeLayout GvB;
  TextView GvC;
  RelativeLayout GvD;
  RelativeLayout GvE;
  TextView GvF;
  View frN;
  ImageView fxT;
  
  static
  {
    AppMethodBeat.i(184981);
    c.a locala1 = new c.a();
    locala1.hkf = 2131689599;
    c.a locala2 = locala1.de(a.fromDPToPix(aj.getContext(), 20), a.fromDPToPix(aj.getContext(), 20));
    locala2.gkG = true;
    locala2.hjU = true;
    locala2.hjS = true;
    frV = locala1.azc();
    AppMethodBeat.o(184981);
  }
  
  public x$d(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(184980);
    this.frN = paramView;
    this.GvB = ((RelativeLayout)paramView.findViewById(2131305960));
    this.fxT = ((ImageView)paramView.findViewById(2131305964));
    this.GvC = ((TextView)paramView.findViewById(2131305974));
    this.GvD = ((RelativeLayout)paramView.findViewById(2131305962));
    this.GvE = ((RelativeLayout)paramView.findViewById(2131305968));
    this.GvF = ((TextView)paramView.findViewById(2131305970));
    AppMethodBeat.o(184980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.x.d
 * JD-Core Version:    0.7.0.1
 */