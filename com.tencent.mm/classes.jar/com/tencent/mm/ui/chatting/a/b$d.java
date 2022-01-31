package com.tencent.mm.ui.chatting.a;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;

public final class b$d
  extends RecyclerView.v
{
  ImageView khQ;
  View khR;
  TextView khS;
  ImageView khT;
  View khU;
  CheckBox khV;
  View khW;
  
  public b$d(b paramb, View paramView)
  {
    super(paramView);
    this.khQ = ((ImageView)paramView.findViewById(R.h.grid_header_item));
    this.khR = paramView.findViewById(R.h.video_tips_root);
    this.khU = paramView.findViewById(R.h.sight_tips_root);
    this.khS = ((TextView)paramView.findViewById(R.h.video_time_tv));
    this.khT = ((ImageView)paramView.findViewById(R.h.grid_selected_item_mask));
    this.khV = ((CheckBox)paramView.findViewById(R.h.media_cbx));
    this.khW = paramView.findViewById(R.h.media_cbx_clickarea);
    this.khW.setVisibility(8);
    this.khV.setVisibility(8);
    this.khR.setVisibility(8);
    this.khS.setVisibility(8);
    this.khU.setVisibility(8);
    this.khQ.setOnClickListener(new b.d.1(this, paramb));
    this.khW.setOnClickListener(new b.d.2(this, paramb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.b.d
 * JD-Core Version:    0.7.0.1
 */