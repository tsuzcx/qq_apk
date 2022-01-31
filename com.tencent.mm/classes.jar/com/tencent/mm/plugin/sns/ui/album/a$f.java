package com.tencent.mm.plugin.sns.ui.album;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$f
  extends RecyclerView.v
{
  TextView gpp;
  GridLayoutManager jfY;
  private LinearLayout rUO;
  c sex;
  RecyclerView sey;
  TextView timeTv;
  
  public a$f(a parama, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(39965);
    this.sex = null;
    this.gpp = null;
    this.timeTv = null;
    this.sey = null;
    this.jfY = null;
    this.rUO = null;
    this.gpp = ((TextView)paramView.findViewById(2131827889));
    this.timeTv = ((TextView)paramView.findViewById(2131827891));
    this.sey = ((RecyclerView)paramView.findViewById(2131827892));
    this.jfY = new GridLayoutManager(3);
    this.sex = new c();
    this.sex.seB = parama.sen;
    AppMethodBeat.o(39965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.a.f
 * JD-Core Version:    0.7.0.1
 */