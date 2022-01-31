package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.h;

public class c$a
{
  public ImageView doU;
  public TextView dsz;
  public View hoY;
  public View igg;
  public View kKz;
  public CheckBox khV;
  public TextView nSa;
  public ProgressBar nhQ;
  public ViewStub vAY;
  public View vAZ;
  public ImageView vBa;
  public String vBb;
  public c vBc;
  
  public static void Y(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      localLayoutParams.width = paramInt;
      paramView.setLayoutParams(localLayoutParams);
      paramView.requestLayout();
    }
  }
  
  public final void dN(View paramView)
  {
    this.kKz = paramView;
    this.dsz = ((TextView)paramView.findViewById(R.h.chatting_time_tv));
    this.doU = ((ImageView)paramView.findViewById(R.h.chatting_avatar_iv));
    this.vAZ = paramView.findViewById(R.h.chatting_histroy_msg_tip);
    this.igg = paramView.findViewById(R.h.chatting_click_area);
    this.vBa = ((ImageView)paramView.findViewById(R.h.chatting_state_iv));
    this.vAY = ((ViewStub)paramView.findViewById(R.h.chatting_send_from_watch_vs));
  }
  
  public final void nt(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      if ((this.khV != null) && (this.khV.getVisibility() != i)) {
        this.khV.setVisibility(i);
      }
      if ((this.hoY != null) && (this.hoY.getVisibility() != i)) {
        this.hoY.setVisibility(i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.c.a
 * JD-Core Version:    0.7.0.1
 */