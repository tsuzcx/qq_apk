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

final class u$a
  extends c.a
{
  a.f GHI;
  protected ImageView GHZ;
  protected TextView GIU;
  protected MMNeat7extView GLB;
  com.tencent.mm.ui.widget.textview.a GLC;
  g GLD;
  a.e GLE;
  ViewStub GLF;
  ChattingItemTranslate GLG;
  View GLZ;
  com.tencent.mm.ui.widget.b.a GqT;
  View hFi;
  protected TextView qkL;
  protected ProgressBar uPp;
  
  public final a fX(View paramView)
  {
    AppMethodBeat.i(37002);
    super.fK(paramView);
    this.GLB = ((MMNeat7extView)paramView.findViewById(2131298073));
    this.uPp = ((ProgressBar)paramView.findViewById(2131306220));
    this.GHZ = ((ImageView)paramView.findViewById(2131298174));
    this.qkL = ((TextView)paramView.findViewById(2131298044));
    this.GIU = ((TextView)paramView.findViewById(2131298023));
    this.wet = ((TextView)paramView.findViewById(2131298185));
    this.hIS = ((CheckBox)paramView.findViewById(2131298068));
    this.lRB = paramView.findViewById(2131298147);
    this.naN = paramView.findViewById(2131303673);
    this.GLZ = paramView.findViewById(2131303674);
    this.hFi = paramView.findViewById(2131298071);
    this.GLF = ((ViewStub)paramView.findViewById(2131306075));
    this.GLD = new g(this.GLB, new n(this.GLB.getContext()));
    AppMethodBeat.o(37002);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.a
 * JD-Core Version:    0.7.0.1
 */