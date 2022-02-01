package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.ArrayList;
import java.util.List;

final class an$c
  extends c.a
{
  TextView Xdu;
  an.f XhY;
  an.h XhZ;
  an.e Xia;
  an.i Xib;
  an.d Xic;
  an.g Xid;
  LinearLayout sHk;
  List<an.a> sHn;
  
  an$c()
  {
    AppMethodBeat.i(37133);
    this.XhY = new an.f();
    this.sHn = new ArrayList();
    this.XhZ = new an.h();
    this.Xia = new an.e();
    this.Xib = new an.i();
    this.Xic = new an.d();
    this.Xid = new an.g();
    AppMethodBeat.o(37133);
  }
  
  public final View getMainContainerView()
  {
    return this.sHk;
  }
  
  public final c.a io(View paramView)
  {
    AppMethodBeat.i(37134);
    LinearLayout localLinearLayout = this.sHk;
    an.a locala = new an.a();
    locala.sEi = paramView;
    locala.mrE = paramView.findViewById(R.h.top_line);
    locala.vpA = paramView.findViewById(R.h.content_ll);
    locala.sDe = ((MMNeat7extView)paramView.findViewById(R.h.title));
    locala.sGR = ((TextView)paramView.findViewById(R.h.summary));
    locala.sGS = paramView.findViewById(R.h.cover_area);
    locala.sCR = ((ImageView)paramView.findViewById(R.h.cover));
    locala.sGV = ((ImageView)paramView.findViewById(R.h.play_icon));
    locala.sGU = ((ImageView)paramView.findViewById(R.h.dyr));
    locala.sGT = paramView.findViewById(R.h.dum);
    locala.sHS = ((ImageView)paramView.findViewById(R.h.dRf));
    locala.XhX = ((TextView)paramView.findViewById(R.h.dRg));
    localLinearLayout.addView(paramView, localLinearLayout.getChildCount());
    this.sHn.add(locala);
    AppMethodBeat.o(37134);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.an.c
 * JD-Core Version:    0.7.0.1
 */