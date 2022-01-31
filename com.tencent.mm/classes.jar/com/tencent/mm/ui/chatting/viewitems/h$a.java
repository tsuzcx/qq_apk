package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.MMTextView;

final class h$a
  extends c.a
{
  View eML;
  ImageView vBN;
  MMTextView vCB;
  
  public final c.a s(View paramView, boolean paramBoolean)
  {
    super.dN(paramView);
    this.dsz = ((TextView)paramView.findViewById(R.h.chatting_time_tv));
    this.nSa = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    this.vCB = ((MMTextView)paramView.findViewById(R.h.chatting_content_itv));
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.hoY = paramView.findViewById(R.h.chatting_maskview);
    this.eML = paramView.findViewById(R.h.chatting_content_area);
    if (!paramBoolean)
    {
      this.vBN = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
      this.vBa = ((ImageView)paramView.findViewById(R.h.chatting_state_iv));
      this.nhQ = ((ProgressBar)paramView.findViewById(R.h.uploading_pb));
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.h.a
 * JD-Core Version:    0.7.0.1
 */