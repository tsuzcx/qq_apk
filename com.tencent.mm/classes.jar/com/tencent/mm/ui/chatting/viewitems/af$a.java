package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;

final class af$a
  extends c.a
{
  public ImageView Vts;
  public int aeOt = 0;
  public ImageView aeRA;
  public TextView aeRB;
  public TextView aeRC;
  public TextView aeRD;
  public View uiF;
  
  public final a lH(View paramView)
  {
    AppMethodBeat.i(37043);
    super.create(paramView);
    this.timeTV = ((TextView)this.convertView.findViewById(R.h.fAm));
    this.checkBox = ((CheckBox)this.convertView.findViewById(R.h.fxt));
    this.maskView = this.convertView.findViewById(R.h.fzn);
    this.userTV = ((TextView)this.convertView.findViewById(R.h.fAr));
    this.uiF = this.convertView.findViewById(R.h.footer);
    this.Vts = ((ImageView)this.convertView.findViewById(R.h.divider));
    this.aeRD = ((TextView)this.convertView.findViewById(R.h.fsk));
    this.aeRA = ((ImageView)this.convertView.findViewById(R.h.fsj));
    this.aeRB = ((TextView)this.convertView.findViewById(R.h.fsi));
    this.aeRC = ((TextView)this.convertView.findViewById(R.h.fsl));
    this.aeOt = c.nn(MMApplicationContext.getContext());
    aw.a(this.aeRC.getPaint(), 0.8F);
    AppMethodBeat.o(37043);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.af.a
 * JD-Core Version:    0.7.0.1
 */