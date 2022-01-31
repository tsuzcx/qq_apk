package com.tencent.mm.ui.chatting.a;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;

public final class c$d
  extends RecyclerView.v
{
  TextView eXs;
  
  public c$d(c paramc, View paramView)
  {
    super(paramView);
    this.eXs = ((TextView)paramView.findViewById(R.h.date_info));
    this.eXs.setTextColor(c.a(paramc).getResources().getColor(R.e.fav_record_date_color));
    paramView.findViewById(R.h.content).setBackgroundColor(c.a(paramc).getResources().getColor(R.e.fav_listitem_divider_bg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.c.d
 * JD-Core Version:    0.7.0.1
 */