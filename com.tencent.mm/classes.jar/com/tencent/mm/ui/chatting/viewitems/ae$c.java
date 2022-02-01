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
  TextView JZp;
  ae.f Kdl;
  ae.h Kdm;
  ae.e Kdn;
  ae.i Kdo;
  ae.d Kdp;
  ae.g Kdq;
  LinearLayout ofq;
  List<ae.a> oft;
  
  ae$c()
  {
    AppMethodBeat.i(37133);
    this.Kdl = new ae.f();
    this.oft = new ArrayList();
    this.Kdm = new ae.h();
    this.Kdn = new ae.e();
    this.Kdo = new ae.i();
    this.Kdp = new ae.d();
    this.Kdq = new ae.g();
    AppMethodBeat.o(37133);
  }
  
  public final c.a gH(View paramView)
  {
    AppMethodBeat.i(37134);
    LinearLayout localLinearLayout = this.ofq;
    ae.a locala = new ae.a();
    locala.odh = paramView;
    locala.iCM = paramView.findViewById(2131306012);
    locala.oeQ = paramView.findViewById(2131298764);
    locala.ocA = ((MMNeat7extView)paramView.findViewById(2131305902));
    locala.oeS = ((TextView)paramView.findViewById(2131305546));
    locala.oeT = paramView.findViewById(2131298814);
    locala.ocn = ((ImageView)paramView.findViewById(2131298813));
    locala.oeW = ((ImageView)paramView.findViewById(2131303284));
    locala.oeV = ((ImageView)paramView.findViewById(2131298135));
    locala.oeU = paramView.findViewById(2131297330);
    localLinearLayout.addView(paramView, localLinearLayout.getChildCount());
    this.oft.add(locala);
    AppMethodBeat.o(37134);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.c
 * JD-Core Version:    0.7.0.1
 */