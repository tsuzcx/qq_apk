package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;

final class az$d
  extends c.a
{
  TextView Aoo;
  ImageView aeNG;
  ImageView aePK;
  ImageView aeRQ;
  TextView aeUS;
  View aeUT;
  
  public final c.a P(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(37340);
    super.create(paramView);
    this.timeTV = ((TextView)paramView.findViewById(R.h.fAm));
    this.aePK = ((ImageView)paramView.findViewById(R.h.fxz));
    this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
    this.maskView = paramView.findViewById(R.h.fzn);
    this.aeUT = paramView.findViewById(R.h.gbq);
    if (paramBoolean)
    {
      this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
      this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.downloading_pb));
    }
    for (;;)
    {
      this.aeRQ = ((ImageView)paramView.findViewById(R.h.fxB));
      this.Aoo = ((TextView)paramView.findViewById(R.h.fwZ));
      AppMethodBeat.o(37340);
      return this;
      this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.gbo));
      this.aeUS = ((TextView)paramView.findViewById(R.h.gbp));
      this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
      this.aeNG = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
    }
  }
  
  public final View getMainContainerView()
  {
    return this.aePK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.az.d
 * JD-Core Version:    0.7.0.1
 */