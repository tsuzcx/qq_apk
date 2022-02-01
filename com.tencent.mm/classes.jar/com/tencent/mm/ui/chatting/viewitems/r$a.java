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
  public int Xev;
  ImageView Xgk;
  TextView Xgl;
  TextView Xgm;
  TextView iZH;
  public ImageView tickIV;
  
  public final a O(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(163329);
    super.create(paramView);
    this.Xgk = ((ImageView)this.convertView.findViewById(R.h.dwU));
    this.timeTV = ((TextView)this.convertView.findViewById(R.h.dzs));
    this.Xgl = ((TextView)this.convertView.findViewById(R.h.dzv));
    this.Xgm = ((TextView)this.convertView.findViewById(R.h.dzx));
    this.iZH = ((TextView)this.convertView.findViewById(R.h.dyQ));
    this.userTV = ((TextView)this.convertView.findViewById(R.h.chatting_user_tv));
    this.clickArea = this.convertView.findViewById(R.h.chatting_click_area);
    this.maskView = this.convertView.findViewById(R.h.dyD);
    if (paramBoolean)
    {
      this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.dYz));
      this.tickIV = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
    }
    this.Xev = c.lj(MMApplicationContext.getContext());
    AppMethodBeat.o(163329);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.a
 * JD-Core Version:    0.7.0.1
 */