package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class r$a
  extends c.a
{
  public int aeOt;
  ImageView aeQb;
  TextView aeQc;
  TextView aeQd;
  TextView lBD;
  public ImageView tickIV;
  
  public final a U(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(163329);
    super.create(paramView);
    this.aeQb = ((ImageView)this.convertView.findViewById(R.h.fxm));
    this.timeTV = ((TextView)this.convertView.findViewById(R.h.fAm));
    this.aeQc = ((TextView)this.convertView.findViewById(R.h.fAp));
    this.aeQd = ((TextView)this.convertView.findViewById(R.h.fAs));
    this.lBD = ((TextView)this.convertView.findViewById(R.h.fzB));
    this.userTV = ((TextView)this.convertView.findViewById(R.h.fAr));
    this.clickArea = this.convertView.findViewById(R.h.chatting_click_area);
    this.maskView = this.convertView.findViewById(R.h.fzn);
    if (paramBoolean)
    {
      this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.gbo));
      this.tickIV = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
    }
    this.aeOt = c.nn(MMApplicationContext.getContext());
    AppMethodBeat.o(163329);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.a
 * JD-Core Version:    0.7.0.1
 */