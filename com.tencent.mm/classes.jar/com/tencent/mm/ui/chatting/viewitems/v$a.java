package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class v$a
  extends c.a
{
  TextView egr;
  public int zSN;
  ImageView zSm;
  ImageView zUU;
  TextView zUV;
  TextView zUW;
  
  public final c.a A(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(33106);
    super.eV(paramView);
    this.zUU = ((ImageView)paramView.findViewById(2131822657));
    this.ekh = ((TextView)paramView.findViewById(2131820587));
    this.zUV = ((TextView)paramView.findViewById(2131822660));
    this.zUW = ((TextView)paramView.findViewById(2131822659));
    this.egr = ((TextView)paramView.findViewById(2131822658));
    this.qFY = ((TextView)paramView.findViewById(2131821122));
    this.jYu = paramView.findViewById(2131822580);
    this.mCC = ((CheckBox)paramView.findViewById(2131820579));
    this.jbK = paramView.findViewById(2131820586);
    if (!paramBoolean)
    {
      this.zRC = ((ImageView)paramView.findViewById(2131822695));
      this.zSm = ((ImageView)paramView.findViewById(2131822729));
      this.pNd = ((ProgressBar)paramView.findViewById(2131822728));
    }
    this.zSN = c.io(ah.getContext());
    AppMethodBeat.o(33106);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.v.a
 * JD-Core Version:    0.7.0.1
 */