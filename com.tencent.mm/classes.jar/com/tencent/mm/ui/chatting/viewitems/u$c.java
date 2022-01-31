package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

final class u$c
  extends c.a
{
  LinearLayout jYa;
  List<u.a> jYd;
  TextView zRY;
  u.f zUI;
  u.h zUJ;
  u.e zUK;
  u.i zUL;
  u.d zUM;
  u.g zUN;
  
  u$c()
  {
    AppMethodBeat.i(33071);
    this.zUI = new u.f();
    this.jYd = new ArrayList();
    this.zUJ = new u.h();
    this.zUK = new u.e();
    this.zUL = new u.i();
    this.zUM = new u.d();
    this.zUN = new u.g();
    AppMethodBeat.o(33071);
  }
  
  public final c.a fk(View paramView)
  {
    AppMethodBeat.i(33072);
    LinearLayout localLinearLayout = this.jYa;
    u.a locala = new u.a();
    locala.jXr = paramView;
    locala.jXs = paramView.findViewById(2131821887);
    locala.jXt = paramView.findViewById(2131821888);
    locala.gui = ((TextView)paramView.findViewById(2131820680));
    locala.jXv = ((TextView)paramView.findViewById(2131821890));
    locala.jXw = paramView.findViewById(2131821437);
    locala.jXx = ((ImageView)paramView.findViewById(2131821438));
    locala.jXy = ((ImageView)paramView.findViewById(2131821895));
    localLinearLayout.addView(paramView, localLinearLayout.getChildCount());
    this.jYd.add(locala);
    AppMethodBeat.o(33072);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.c
 * JD-Core Version:    0.7.0.1
 */