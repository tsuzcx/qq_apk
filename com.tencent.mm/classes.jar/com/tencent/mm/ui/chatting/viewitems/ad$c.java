package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.ArrayList;
import java.util.List;

final class ad$c
  extends c.a
{
  TextView IiR;
  ad.f ImN;
  ad.h ImO;
  ad.e ImP;
  ad.i ImQ;
  ad.d ImR;
  ad.g ImS;
  LinearLayout nCR;
  List<ad.a> nCU;
  
  ad$c()
  {
    AppMethodBeat.i(37133);
    this.ImN = new ad.f();
    this.nCU = new ArrayList();
    this.ImO = new ad.h();
    this.ImP = new ad.e();
    this.ImQ = new ad.i();
    this.ImR = new ad.d();
    this.ImS = new ad.g();
    AppMethodBeat.o(37133);
  }
  
  public final c.a gq(View paramView)
  {
    AppMethodBeat.i(37134);
    LinearLayout localLinearLayout = this.nCR;
    ad.a locala = new ad.a();
    locala.nBh = paramView;
    locala.ijv = paramView.findViewById(2131306012);
    locala.nCh = paramView.findViewById(2131298764);
    locala.nCy = ((MMNeat7extView)paramView.findViewById(2131305902));
    locala.nCj = ((TextView)paramView.findViewById(2131305546));
    locala.nCk = paramView.findViewById(2131298814);
    locala.nCl = ((ImageView)paramView.findViewById(2131298813));
    locala.nCo = ((ImageView)paramView.findViewById(2131303284));
    locala.nCn = ((ImageView)paramView.findViewById(2131298135));
    locala.nCm = paramView.findViewById(2131297330);
    localLinearLayout.addView(paramView, localLinearLayout.getChildCount());
    this.nCU.add(locala);
    AppMethodBeat.o(37134);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ad.c
 * JD-Core Version:    0.7.0.1
 */