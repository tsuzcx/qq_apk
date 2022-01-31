package com.tencent.mm.ui.chatting.a;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$d
  extends RecyclerView.v
{
  TextView gpp;
  
  public c$d(c paramc, View paramView)
  {
    super(paramView);
    AppMethodBeat.i(31153);
    this.gpp = ((TextView)paramView.findViewById(2131824015));
    this.gpp.setTextColor(c.a(paramc).getResources().getColor(2131690058));
    paramView.findViewById(2131820946).setBackgroundColor(c.a(paramc).getResources().getColor(2131690052));
    AppMethodBeat.o(31153);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.c.d
 * JD-Core Version:    0.7.0.1
 */