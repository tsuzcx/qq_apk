package com.tencent.mm.ui.chatting.a;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.h;

public final class b$a
  extends RecyclerView.v
{
  TextView eXs;
  ProgressBar frw;
  
  public b$a(b paramb, View paramView)
  {
    super(paramView);
    this.eXs = ((TextView)paramView.findViewById(R.h.date_info));
    this.frw = ((ProgressBar)paramView.findViewById(R.h.load_progress));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.b.a
 * JD-Core Version:    0.7.0.1
 */