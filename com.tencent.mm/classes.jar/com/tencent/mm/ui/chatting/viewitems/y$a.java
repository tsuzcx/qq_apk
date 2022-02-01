package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.sdk.platformtools.aj;

final class y$a
  extends c.a
{
  public int Kaq = 0;
  public ImageView KcL;
  public TextView KcM;
  public TextView KcN;
  public ImageView KcO;
  public View oIV;
  
  public final a gE(View paramView)
  {
    AppMethodBeat.i(37043);
    super.gn(paramView);
    this.fTP = ((TextView)this.tPw.findViewById(2131298178));
    this.iCK = ((CheckBox)this.tPw.findViewById(2131298068));
    this.gZU = this.tPw.findViewById(2131298147);
    this.yEk = ((TextView)this.tPw.findViewById(2131298185));
    this.oIV = this.tPw.findViewById(2131300196);
    this.KcO = ((ImageView)this.tPw.findViewById(2131299154));
    this.KcL = ((ImageView)this.tPw.findViewById(2131296930));
    this.KcM = ((TextView)this.tPw.findViewById(2131296931));
    this.KcN = ((TextView)this.tPw.findViewById(2131296929));
    this.Kaq = c.kn(aj.getContext());
    this.KcN.setTypeface(((b)g.ab(b.class)).fP(this.tPw.getContext()));
    AppMethodBeat.o(37043);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.y.a
 * JD-Core Version:    0.7.0.1
 */