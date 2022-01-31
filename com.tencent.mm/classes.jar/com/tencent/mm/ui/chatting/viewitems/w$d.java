package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;

final class w$d
  extends c.a
{
  ProgressBar nhQ;
  ImageView vBN;
  RTChattingEmojiView vCP;
  ImageView vCQ;
  ViewStub vEB;
  
  public final c.a s(View paramView, boolean paramBoolean)
  {
    super.dN(paramView);
    this.dsz = ((TextView)paramView.findViewById(R.h.chatting_time_tv));
    this.vCP = ((RTChattingEmojiView)paramView.findViewById(R.h.chatting_content_iv));
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.hoY = paramView.findViewById(R.h.chatting_maskview);
    if (paramBoolean) {
      this.nSa = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    }
    for (;;)
    {
      if (this.vCQ != null) {
        ((ViewGroup)this.vCQ.getParent()).setBackgroundDrawable(null);
      }
      this.vEB = ((ViewStub)paramView.findViewById(R.h.chatting_reward_tips));
      return this;
      this.nhQ = ((ProgressBar)paramView.findViewById(R.h.uploading_pb));
      this.nSa = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
      this.vBa = ((ImageView)paramView.findViewById(R.h.chatting_state_iv));
      this.vBN = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.w.d
 * JD-Core Version:    0.7.0.1
 */