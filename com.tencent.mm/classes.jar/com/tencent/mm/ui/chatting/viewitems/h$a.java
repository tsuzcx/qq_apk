package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMTextView;

final class h$a
  extends c.a
{
  View gcq;
  ImageView zSm;
  MMTextView zTF;
  
  public final c.a A(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(32902);
    super.eV(paramView);
    this.ekh = ((TextView)paramView.findViewById(2131820587));
    this.qFY = ((TextView)paramView.findViewById(2131821122));
    this.zTF = ((MMTextView)paramView.findViewById(2131821123));
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.jbK = paramView.findViewById(2131820586);
    this.gcq = paramView.findViewById(2131820580);
    if (!paramBoolean)
    {
      this.zSm = ((ImageView)paramView.findViewById(2131822729));
      this.zRC = ((ImageView)paramView.findViewById(2131822695));
      this.pNd = ((ProgressBar)paramView.findViewById(2131822728));
    }
    AppMethodBeat.o(32902);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.h.a
 * JD-Core Version:    0.7.0.1
 */