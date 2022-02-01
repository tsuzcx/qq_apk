package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;

final class ah$a
  extends c.a
{
  public ImageView OEh;
  public int Xev = 0;
  public ImageView Xhw;
  public TextView Xhx;
  public TextView Xhy;
  public TextView Xhz;
  public View tzi;
  
  public final a il(View paramView)
  {
    AppMethodBeat.i(37043);
    super.create(paramView);
    this.timeTV = ((TextView)this.convertView.findViewById(R.h.dzs));
    this.checkBox = ((CheckBox)this.convertView.findViewById(R.h.dwZ));
    this.maskView = this.convertView.findViewById(R.h.dyD);
    this.userTV = ((TextView)this.convertView.findViewById(R.h.chatting_user_tv));
    this.tzi = this.convertView.findViewById(R.h.footer);
    this.OEh = ((ImageView)this.convertView.findViewById(R.h.divider));
    this.Xhz = ((TextView)this.convertView.findViewById(R.h.drS));
    this.Xhw = ((ImageView)this.convertView.findViewById(R.h.drR));
    this.Xhx = ((TextView)this.convertView.findViewById(R.h.drQ));
    this.Xhy = ((TextView)this.convertView.findViewById(R.h.drT));
    this.Xev = c.lj(MMApplicationContext.getContext());
    ar.a(this.Xhy.getPaint(), 0.8F);
    AppMethodBeat.o(37043);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ah.a
 * JD-Core Version:    0.7.0.1
 */