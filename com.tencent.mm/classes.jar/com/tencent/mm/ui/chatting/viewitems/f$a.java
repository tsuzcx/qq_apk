package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ah;

final class f$a
  extends c.a
{
  public int maxSize = 0;
  public int zSN = 0;
  public ImageView zTk;
  public TextView zTl;
  public TextView zTm;
  public TextView zTn;
  public int zTq = 0;
  
  public final a eZ(View paramView)
  {
    AppMethodBeat.i(32877);
    super.eV(paramView);
    this.ekh = ((TextView)this.ngZ.findViewById(2131820587));
    this.mCC = ((CheckBox)this.ngZ.findViewById(2131820579));
    this.jbK = this.ngZ.findViewById(2131820586);
    this.qFY = ((TextView)this.ngZ.findViewById(2131821122));
    this.zTk = ((ImageView)this.ngZ.findViewById(2131822626));
    this.zTl = ((TextView)this.ngZ.findViewById(2131822627));
    this.zTm = ((TextView)this.ngZ.findViewById(2131822628));
    this.zTn = ((TextView)this.ngZ.findViewById(2131822629));
    this.jYu = ((LinearLayout)this.ngZ.findViewById(2131822580));
    this.zSN = c.io(ah.getContext());
    this.zTq = a.ao(ah.getContext(), 2131427524);
    this.maxSize = ((int)(a.ap(ah.getContext(), 2131427524) * 1.45F));
    AppMethodBeat.o(32877);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.f.a
 * JD-Core Version:    0.7.0.1
 */