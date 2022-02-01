package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;

final class m$a
  extends c.a
{
  public int IjS;
  ImageView Ili;
  TextView Ilj;
  TextView Ilk;
  public ImageView Ill;
  TextView fuZ;
  
  public final a B(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(163329);
    super.fX(paramView);
    this.Ili = ((ImageView)this.sSS.findViewById(2131298057));
    this.fAz = ((TextView)this.sSS.findViewById(2131298178));
    this.Ilj = ((TextView)this.sSS.findViewById(2131298182));
    this.Ilk = ((TextView)this.sSS.findViewById(2131298186));
    this.fuZ = ((TextView)this.sSS.findViewById(2131298152));
    this.xpH = ((TextView)this.sSS.findViewById(2131298185));
    this.nDl = this.sSS.findViewById(2131298069);
    this.gGk = this.sSS.findViewById(2131298147);
    if (paramBoolean)
    {
      this.vYf = ((ProgressBar)paramView.findViewById(2131306220));
      this.Ill = ((ImageView)paramView.findViewById(2131298176));
    }
    this.IjS = c.kb(ai.getContext());
    AppMethodBeat.o(163329);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.a
 * JD-Core Version:    0.7.0.1
 */