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

final class ac$c
  extends c.a
{
  TextView GIU;
  ac.f GML;
  ac.h GMM;
  ac.e GMN;
  ac.i GMO;
  ac.d GMP;
  ac.g GMQ;
  LinearLayout nat;
  List<ac.a> naw;
  
  ac$c()
  {
    AppMethodBeat.i(37133);
    this.GML = new ac.f();
    this.naw = new ArrayList();
    this.GMM = new ac.h();
    this.GMN = new ac.e();
    this.GMO = new ac.i();
    this.GMP = new ac.d();
    this.GMQ = new ac.g();
    AppMethodBeat.o(37133);
  }
  
  public final c.a gd(View paramView)
  {
    AppMethodBeat.i(37134);
    LinearLayout localLinearLayout = this.nat;
    ac.a locala = new ac.a();
    locala.mYI = paramView;
    locala.hIU = paramView.findViewById(2131306012);
    locala.mZJ = paramView.findViewById(2131298764);
    locala.naa = ((MMNeat7extView)paramView.findViewById(2131305902));
    locala.mZL = ((TextView)paramView.findViewById(2131305546));
    locala.mZM = paramView.findViewById(2131298814);
    locala.mZN = ((ImageView)paramView.findViewById(2131298813));
    locala.mZQ = ((ImageView)paramView.findViewById(2131303284));
    locala.mZP = ((ImageView)paramView.findViewById(2131298135));
    locala.mZO = paramView.findViewById(2131297330);
    localLinearLayout.addView(paramView, localLinearLayout.getChildCount());
    this.naw.add(locala);
    AppMethodBeat.o(37134);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ac.c
 * JD-Core Version:    0.7.0.1
 */