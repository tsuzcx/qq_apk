package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;

final class m$a
  extends c.a
{
  public int Kaq;
  ImageView KbG;
  TextView KbH;
  TextView KbI;
  public ImageView KbJ;
  TextView fOg;
  
  public final a B(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(163329);
    super.gn(paramView);
    this.KbG = ((ImageView)this.tPw.findViewById(2131298057));
    this.fTP = ((TextView)this.tPw.findViewById(2131298178));
    this.KbH = ((TextView)this.tPw.findViewById(2131298182));
    this.KbI = ((TextView)this.tPw.findViewById(2131298186));
    this.fOg = ((TextView)this.tPw.findViewById(2131298152));
    this.yEk = ((TextView)this.tPw.findViewById(2131298185));
    this.ofK = this.tPw.findViewById(2131298069);
    this.gZU = this.tPw.findViewById(2131298147);
    if (paramBoolean)
    {
      this.xfR = ((ProgressBar)paramView.findViewById(2131306220));
      this.KbJ = ((ImageView)paramView.findViewById(2131298176));
    }
    this.Kaq = c.kn(aj.getContext());
    AppMethodBeat.o(163329);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.a
 * JD-Core Version:    0.7.0.1
 */