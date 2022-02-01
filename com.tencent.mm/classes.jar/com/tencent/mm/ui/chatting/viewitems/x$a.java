package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class x$a
  extends c.a
{
  TextView Xgt;
  ImageView jiu;
  TextView kEs;
  public ImageView tickIV;
  TextView xoK;
  
  public final a T(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(266079);
    super.create(paramView);
    this.jiu = ((ImageView)paramView.findViewById(R.h.dHQ));
    this.xoK = ((TextView)paramView.findViewById(R.h.dHS));
    this.kEs = ((TextView)paramView.findViewById(R.h.dHR));
    this.Xgt = ((TextView)paramView.findViewById(R.h.dHT));
    this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    if (paramBoolean)
    {
      this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.dYz));
      this.tickIV = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
    }
    AppMethodBeat.o(266079);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.a
 * JD-Core Version:    0.7.0.1
 */