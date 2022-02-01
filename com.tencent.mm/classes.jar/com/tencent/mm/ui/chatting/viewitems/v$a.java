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

final class v$a
  extends c.a
{
  com.tencent.mm.ui.widget.b.a JEB;
  a.f JXY;
  protected ImageView JYs;
  protected TextView JZp;
  protected MMNeat7extView KbY;
  com.tencent.mm.ui.widget.textview.a KbZ;
  g Kca;
  a.e Kcb;
  ViewStub Kcc;
  ChattingItemTranslate Kcd;
  View Kcw;
  View ize;
  protected TextView rDq;
  
  public final a gB(View paramView)
  {
    AppMethodBeat.i(37002);
    super.gn(paramView);
    this.KbY = ((MMNeat7extView)paramView.findViewById(2131298073));
    this.xfR = ((ProgressBar)paramView.findViewById(2131306220));
    this.JYs = ((ImageView)paramView.findViewById(2131298174));
    this.rDq = ((TextView)paramView.findViewById(2131298044));
    this.JZp = ((TextView)paramView.findViewById(2131298023));
    this.yEk = ((TextView)paramView.findViewById(2131298185));
    this.iCK = ((CheckBox)paramView.findViewById(2131298068));
    this.gZU = paramView.findViewById(2131298147);
    this.ofK = paramView.findViewById(2131303673);
    this.Kcw = paramView.findViewById(2131303674);
    this.ize = paramView.findViewById(2131298071);
    this.Kcc = ((ViewStub)paramView.findViewById(2131306075));
    this.Kca = new g(this.KbY, new n(this.KbY.getContext()));
    AppMethodBeat.o(37002);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.v.a
 * JD-Core Version:    0.7.0.1
 */