package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class ae$a
  extends c.a
{
  public ImageView HMl;
  public int PJa = 0;
  public ImageView PLC;
  public TextView PLD;
  public TextView PLE;
  public TextView PLF;
  public View qdl;
  
  public final a gZ(View paramView)
  {
    AppMethodBeat.i(37043);
    super.create(paramView);
    this.timeTV = ((TextView)this.convertView.findViewById(2131298558));
    this.checkBox = ((CheckBox)this.convertView.findViewById(2131298410));
    this.maskView = this.convertView.findViewById(2131298508);
    this.userTV = ((TextView)this.convertView.findViewById(2131298566));
    this.qdl = this.convertView.findViewById(2131301661);
    this.HMl = ((ImageView)this.convertView.findViewById(2131299682));
    this.PLF = ((TextView)this.convertView.findViewById(2131297036));
    this.PLC = ((ImageView)this.convertView.findViewById(2131297035));
    this.PLD = ((TextView)this.convertView.findViewById(2131297037));
    this.PLE = ((TextView)this.convertView.findViewById(2131297034));
    this.PJa = c.kl(MMApplicationContext.getContext());
    this.PLE.setTypeface(((b)g.af(b.class)).gA(this.convertView.getContext()));
    AppMethodBeat.o(37043);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.a
 * JD-Core Version:    0.7.0.1
 */