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

final class ak$c
  extends c.a
{
  TextView PHZ;
  ak.f PMe;
  ak.h PMf;
  ak.e PMg;
  ak.i PMh;
  ak.d PMi;
  ak.g PMj;
  LinearLayout pxI;
  List<ak.a> pxL;
  
  ak$c()
  {
    AppMethodBeat.i(37133);
    this.PMe = new ak.f();
    this.pxL = new ArrayList();
    this.PMf = new ak.h();
    this.PMg = new ak.e();
    this.PMh = new ak.i();
    this.PMi = new ak.d();
    this.PMj = new ak.g();
    AppMethodBeat.o(37133);
  }
  
  public final View getMainContainerView()
  {
    return this.pxI;
  }
  
  public final c.a hc(View paramView)
  {
    AppMethodBeat.i(37134);
    LinearLayout localLinearLayout = this.pxI;
    ak.a locala = new ak.a();
    locala.puO = paramView;
    locala.jBI = paramView.findViewById(2131309322);
    locala.pxo = paramView.findViewById(2131299208);
    locala.ptR = ((MMNeat7extView)paramView.findViewById(2131309195));
    locala.pxq = ((TextView)paramView.findViewById(2131308767));
    locala.pxr = paramView.findViewById(2131299279);
    locala.ptE = ((ImageView)paramView.findViewById(2131299277));
    locala.pxu = ((ImageView)paramView.findViewById(2131305957));
    locala.pxt = ((ImageView)paramView.findViewById(2131298496));
    locala.pxs = paramView.findViewById(2131297533);
    locala.pyp = ((ImageView)paramView.findViewById(2131305927));
    locala.PMd = ((TextView)paramView.findViewById(2131305934));
    localLinearLayout.addView(paramView, localLinearLayout.getChildCount());
    this.pxL.add(locala);
    AppMethodBeat.o(37134);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.c
 * JD-Core Version:    0.7.0.1
 */