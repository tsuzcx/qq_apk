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
  com.tencent.mm.ui.widget.b.a HQL;
  a.f IhD;
  protected ImageView IhW;
  protected TextView IiR;
  g IlA;
  a.e IlB;
  ViewStub IlC;
  ChattingItemTranslate IlD;
  View IlW;
  protected MMNeat7extView Ily;
  com.tencent.mm.ui.widget.textview.a Ilz;
  View ifK;
  protected TextView qTn;
  
  public final a gk(View paramView)
  {
    AppMethodBeat.i(37002);
    super.fX(paramView);
    this.Ily = ((MMNeat7extView)paramView.findViewById(2131298073));
    this.vYf = ((ProgressBar)paramView.findViewById(2131306220));
    this.IhW = ((ImageView)paramView.findViewById(2131298174));
    this.qTn = ((TextView)paramView.findViewById(2131298044));
    this.IiR = ((TextView)paramView.findViewById(2131298023));
    this.xpH = ((TextView)paramView.findViewById(2131298185));
    this.ijt = ((CheckBox)paramView.findViewById(2131298068));
    this.gGk = paramView.findViewById(2131298147);
    this.nDl = paramView.findViewById(2131303673);
    this.IlW = paramView.findViewById(2131303674);
    this.ifK = paramView.findViewById(2131298071);
    this.IlC = ((ViewStub)paramView.findViewById(2131306075));
    this.IlA = new g(this.Ily, new n(this.Ily.getContext()));
    AppMethodBeat.o(37002);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.u.a
 * JD-Core Version:    0.7.0.1
 */