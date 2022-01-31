package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ae$d
  extends c.a
{
  TextView mCZ;
  ProgressBar pNd;
  ImageView zSm;
  ImageView zTT;
  ImageView zUt;
  TextView zWm;
  View zWn;
  
  public final c.a A(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(33246);
    super.eV(paramView);
    this.ekh = ((TextView)paramView.findViewById(2131820587));
    this.zTT = ((ImageView)paramView.findViewById(2131822642));
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.jbK = paramView.findViewById(2131820586);
    this.zWn = paramView.findViewById(2131822682);
    if (paramBoolean)
    {
      this.qFY = ((TextView)paramView.findViewById(2131821122));
      this.pNd = ((ProgressBar)paramView.findViewById(2131822683));
    }
    for (;;)
    {
      this.zUt = ((ImageView)paramView.findViewById(2131822646));
      this.mCZ = ((TextView)paramView.findViewById(2131822607));
      AppMethodBeat.o(33246);
      return this;
      this.pNd = ((ProgressBar)paramView.findViewById(2131822728));
      this.zWm = ((TextView)paramView.findViewById(2131822736));
      this.qFY = ((TextView)paramView.findViewById(2131821122));
      this.zSm = ((ImageView)paramView.findViewById(2131822729));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae.d
 * JD-Core Version:    0.7.0.1
 */