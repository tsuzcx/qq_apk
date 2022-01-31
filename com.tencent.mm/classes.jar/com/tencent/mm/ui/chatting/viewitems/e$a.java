package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ah;

final class e$a
  extends c.a
{
  public int maxSize = 0;
  public ImageView owb;
  public int zSN = 0;
  public ImageView zTk;
  public TextView zTl;
  public TextView zTm;
  public TextView zTn;
  public TextView zTo;
  public ImageView zTp;
  public int zTq = 0;
  public long zTr;
  public boolean zTs;
  
  public final a eY(View paramView)
  {
    AppMethodBeat.i(32863);
    super.eV(paramView);
    this.ekh = ((TextView)this.ngZ.findViewById(2131820587));
    this.mCC = ((CheckBox)this.ngZ.findViewById(2131820579));
    this.jbK = this.ngZ.findViewById(2131820586);
    this.qFY = ((TextView)this.ngZ.findViewById(2131821122));
    this.zTk = ((ImageView)this.ngZ.findViewById(2131822626));
    this.zTl = ((TextView)this.ngZ.findViewById(2131822627));
    this.zTm = ((TextView)this.ngZ.findViewById(2131822628));
    this.zTn = ((TextView)this.ngZ.findViewById(2131822629));
    this.jYu = this.ngZ.findViewById(2131822580);
    this.owb = ((ImageView)this.ngZ.findViewById(2131822623));
    this.zTo = ((TextView)this.ngZ.findViewById(2131822630));
    this.zTp = ((ImageView)this.ngZ.findViewById(2131822624));
    this.zSN = c.io(ah.getContext());
    this.zTq = a.ao(ah.getContext(), 2131427524);
    this.maxSize = ((int)(a.ap(ah.getContext(), 2131427524) * 1.45F));
    AppMethodBeat.o(32863);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e.a
 * JD-Core Version:    0.7.0.1
 */