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

final class ae$c
  extends c.a
{
  TextView KvI;
  ae.f KzD;
  ae.h KzE;
  ae.e KzF;
  ae.i KzG;
  ae.d KzH;
  ae.g KzI;
  LinearLayout olp;
  List<ae.a> ols;
  
  ae$c()
  {
    AppMethodBeat.i(37133);
    this.KzD = new ae.f();
    this.ols = new ArrayList();
    this.KzE = new ae.h();
    this.KzF = new ae.e();
    this.KzG = new ae.i();
    this.KzH = new ae.d();
    this.KzI = new ae.g();
    AppMethodBeat.o(37133);
  }
  
  public final c.a gM(View paramView)
  {
    AppMethodBeat.i(37134);
    LinearLayout localLinearLayout = this.olp;
    ae.a locala = new ae.a();
    locala.oiV = paramView;
    locala.iFF = paramView.findViewById(2131306012);
    locala.okQ = paramView.findViewById(2131298764);
    locala.oip = ((MMNeat7extView)paramView.findViewById(2131305902));
    locala.okS = ((TextView)paramView.findViewById(2131305546));
    locala.okT = paramView.findViewById(2131298814);
    locala.oic = ((ImageView)paramView.findViewById(2131298813));
    locala.okW = ((ImageView)paramView.findViewById(2131303284));
    locala.okV = ((ImageView)paramView.findViewById(2131298135));
    locala.okU = paramView.findViewById(2131297330);
    localLinearLayout.addView(paramView, localLinearLayout.getChildCount());
    this.ols.add(locala);
    AppMethodBeat.o(37134);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.c
 * JD-Core Version:    0.7.0.1
 */