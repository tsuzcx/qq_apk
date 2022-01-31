package com.tencent.mm.plugin.sns.ui.album;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.widget.QDisFadeImageView;
import com.tencent.mm.ui.widget.QImageView.a;

final class c$b
  extends RecyclerView.v
{
  public ImageView iTH;
  public QDisFadeImageView seC;
  
  public c$b(c paramc, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(39981);
    this.seC = null;
    this.iTH = null;
    this.seC = ((QDisFadeImageView)paramView.findViewById(2131827895));
    this.iTH = ((ImageView)paramView.findViewById(2131827896));
    this.iTH.setImageDrawable(aj.e(this.iTH.getContext().getResources().getDrawable(2131231468), -1));
    this.seC.setScaleType(QImageView.a.AED);
    this.seC.setOnClickListener(new c.b.1(this, paramc));
    AppMethodBeat.o(39981);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.c.b
 * JD-Core Version:    0.7.0.1
 */