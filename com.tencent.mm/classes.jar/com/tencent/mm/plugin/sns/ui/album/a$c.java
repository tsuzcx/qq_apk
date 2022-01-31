package com.tencent.mm.plugin.sns.ui.album;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.LoadingMoreView;

final class a$c
  extends RecyclerView.v
{
  LoadingMoreView ser;
  
  public a$c(a parama, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(39962);
    this.ser = null;
    this.ser = ((LoadingMoreView)paramView.findViewById(2131827893));
    AppMethodBeat.o(39962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.a.c
 * JD-Core Version:    0.7.0.1
 */