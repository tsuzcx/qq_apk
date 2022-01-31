package com.tencent.mm.ui;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;

public final class MultiTalkRoomPopupNav$a
{
  private Button jRz;
  TextView titleView;
  LinearLayout uPD;
  
  private MultiTalkRoomPopupNav$a(MultiTalkRoomPopupNav paramMultiTalkRoomPopupNav, boolean paramBoolean)
  {
    this.jRz = ((Button)paramMultiTalkRoomPopupNav.findViewById(R.h.multitalk_alert_cancel_btn));
    this.titleView = ((TextView)paramMultiTalkRoomPopupNav.findViewById(R.h.multitalk_tv_dialog_title));
    this.uPD = ((LinearLayout)paramMultiTalkRoomPopupNav.findViewById(R.h.multitalk_dialog_layout));
    if (paramBoolean)
    {
      this.uPD.setBackgroundResource(R.g.multitalk_talking_banner_shape);
      this.jRz.setTextColor(paramMultiTalkRoomPopupNav.getResources().getColor(R.e.multitalk_popup_nav_black_text_color));
      return;
    }
    this.uPD.setBackgroundResource(R.g.multitalk_default_banner_shape);
    this.jRz.setTextColor(paramMultiTalkRoomPopupNav.getResources().getColor(R.e.cancel_btn_color));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.MultiTalkRoomPopupNav.a
 * JD-Core Version:    0.7.0.1
 */