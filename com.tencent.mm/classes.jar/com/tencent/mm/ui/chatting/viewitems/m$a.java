package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class m$a
  extends c.a
{
  public int KwJ;
  ImageView KxY;
  TextView KxZ;
  TextView Kya;
  public ImageView Kyb;
  TextView fQm;
  
  public final a G(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(163329);
    super.gs(paramView);
    this.KxY = ((ImageView)this.uan.findViewById(2131298057));
    this.fVV = ((TextView)this.uan.findViewById(2131298178));
    this.KxZ = ((TextView)this.uan.findViewById(2131298182));
    this.Kya = ((TextView)this.uan.findViewById(2131298186));
    this.fQm = ((TextView)this.uan.findViewById(2131298152));
    this.yUp = ((TextView)this.uan.findViewById(2131298185));
    this.olI = this.uan.findViewById(2131298069);
    this.hcH = this.uan.findViewById(2131298147);
    if (paramBoolean)
    {
      this.xvJ = ((ProgressBar)paramView.findViewById(2131306220));
      this.Kyb = ((ImageView)paramView.findViewById(2131298176));
    }
    this.KwJ = c.ku(ak.getContext());
    AppMethodBeat.o(163329);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.a
 * JD-Core Version:    0.7.0.1
 */