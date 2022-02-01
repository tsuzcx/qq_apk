package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class ao$a
  extends c.a
{
  ImageView aeNG;
  public int aeOt;
  ImageView aeQb;
  TextView aeQc;
  TextView aeQd;
  TextView lBD;
  
  public final c.a P(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37176);
    super.create(paramView);
    this.aeQb = ((ImageView)paramView.findViewById(R.h.fxm));
    this.timeTV = ((TextView)paramView.findViewById(R.h.fAm));
    this.aeQc = ((TextView)paramView.findViewById(R.h.fAp));
    this.aeQd = ((TextView)paramView.findViewById(R.h.fAs));
    this.lBD = ((TextView)paramView.findViewById(R.h.fzB));
    this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
    this.clickArea = paramView.findViewById(R.h.chatting_click_area);
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = paramView.findViewById(R.h.fzn);
    if (!paramBoolean)
    {
      this.stateIV = ((ImageView)paramView.findViewById(R.h.fAj));
      this.aeNG = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
      this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.gbo));
    }
    this.aeOt = c.nn(MMApplicationContext.getContext());
    AppMethodBeat.o(37176);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ao.a
 * JD-Core Version:    0.7.0.1
 */