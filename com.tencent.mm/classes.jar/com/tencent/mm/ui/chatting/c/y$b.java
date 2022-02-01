package com.tencent.mm.ui.chatting.c;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.aj;

public final class y$b
  extends RecyclerView.v
{
  static final c frV;
  TextView GvC;
  LinearLayout Gwi;
  View frN;
  ImageView fxT;
  
  static
  {
    AppMethodBeat.i(179874);
    c.a locala1 = new c.a();
    locala1.hkf = 2131689599;
    c.a locala2 = locala1.de(a.fromDPToPix(aj.getContext(), 20), a.fromDPToPix(aj.getContext(), 20));
    locala2.gkG = true;
    locala2.hjU = true;
    locala2.hjS = true;
    frV = locala1.azc();
    AppMethodBeat.o(179874);
  }
  
  public y$b(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(179873);
    this.frN = paramView;
    this.Gwi = ((LinearLayout)paramView.findViewById(2131305978));
    this.fxT = ((ImageView)paramView.findViewById(2131305982));
    this.GvC = ((TextView)paramView.findViewById(2131305984));
    AppMethodBeat.o(179873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.y.b
 * JD-Core Version:    0.7.0.1
 */