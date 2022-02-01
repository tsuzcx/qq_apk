package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.sdk.platformtools.ak;

final class y$a
  extends c.a
{
  public int KwJ = 0;
  public ImageView Kzd;
  public TextView Kze;
  public TextView Kzf;
  public ImageView Kzg;
  public View oPx;
  
  public final a gJ(View paramView)
  {
    AppMethodBeat.i(37043);
    super.gs(paramView);
    this.fVV = ((TextView)this.uan.findViewById(2131298178));
    this.iFD = ((CheckBox)this.uan.findViewById(2131298068));
    this.hcH = this.uan.findViewById(2131298147);
    this.yUp = ((TextView)this.uan.findViewById(2131298185));
    this.oPx = this.uan.findViewById(2131300196);
    this.Kzg = ((ImageView)this.uan.findViewById(2131299154));
    this.Kzd = ((ImageView)this.uan.findViewById(2131296930));
    this.Kze = ((TextView)this.uan.findViewById(2131296931));
    this.Kzf = ((TextView)this.uan.findViewById(2131296929));
    this.KwJ = c.ku(ak.getContext());
    this.Kzf.setTypeface(((b)g.ab(b.class)).fV(this.uan.getContext()));
    AppMethodBeat.o(37043);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y.a
 * JD-Core Version:    0.7.0.1
 */