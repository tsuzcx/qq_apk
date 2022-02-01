package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.g;
import com.tencent.mm.pluginsdk.ui.span.n;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.textview.a.e;
import com.tencent.mm.ui.widget.textview.a.f;

final class r$a
  extends c.a
{
  com.tencent.mm.ui.widget.b.a JZs;
  protected ImageView KuL;
  a.f Kur;
  protected TextView KvI;
  protected MMNeat7extView Kyq;
  com.tencent.mm.ui.widget.textview.a Kyr;
  g Kys;
  a.e Kyt;
  ViewStub Kyu;
  ChattingItemTranslate Kyv;
  View iBX;
  protected TextView rLB;
  
  public final a gB(View paramView)
  {
    AppMethodBeat.i(36935);
    super.gs(paramView);
    this.Kyq = ((MMNeat7extView)paramView.findViewById(2131298073));
    this.xvJ = ((ProgressBar)paramView.findViewById(2131306220));
    this.KuL = ((ImageView)paramView.findViewById(2131298174));
    this.rLB = ((TextView)paramView.findViewById(2131298044));
    this.KvI = ((TextView)paramView.findViewById(2131298023));
    this.yUp = ((TextView)paramView.findViewById(2131298185));
    this.iFD = ((CheckBox)paramView.findViewById(2131298068));
    this.hcH = paramView.findViewById(2131298147);
    this.iBX = paramView.findViewById(2131298071);
    this.Kyu = ((ViewStub)paramView.findViewById(2131306075));
    this.Kys = new g(this.Kyq, new n(this.Kyq.getContext()));
    AppMethodBeat.o(36935);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.a
 * JD-Core Version:    0.7.0.1
 */