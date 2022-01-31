package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.ui.widget.MMNeatTextView;

final class o$a
  extends c.a
{
  protected TextView kiv;
  protected ProgressBar nhQ;
  protected ImageView vBa;
  protected TextView vBz;
  protected MMNeatTextView vDk;
  
  public final a dV(View paramView)
  {
    super.dN(paramView);
    this.vDk = ((MMNeatTextView)paramView.findViewById(R.h.chatting_content_itv));
    this.nhQ = ((ProgressBar)paramView.findViewById(R.h.uploading_pb));
    this.vBa = ((ImageView)paramView.findViewById(R.h.chatting_state_iv));
    this.kiv = ((TextView)paramView.findViewById(R.h.chatting_appmsg_source_tv));
    this.vBz = ((TextView)paramView.findViewById(R.h.chatting_appmsg_comment_tv));
    this.nSa = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.hoY = paramView.findViewById(R.h.chatting_maskview);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.o.a
 * JD-Core Version:    0.7.0.1
 */