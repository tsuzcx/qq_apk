package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;

final class l$a
  extends c.a
{
  protected ImageView kHQ;
  protected ImageView kHU;
  protected View kfh;
  protected TextView kiv;
  protected TextView vBz;
  protected TextView vCW;
  protected ImageView vCX;
  
  public final a dS(View paramView)
  {
    super.dN(paramView);
    this.kHQ = ((ImageView)paramView.findViewById(R.h.chatting_appmsg_thumb_iv));
    this.kiv = ((TextView)paramView.findViewById(R.h.chatting_appmsg_source_tv));
    this.vCW = ((TextView)paramView.findViewById(R.h.chatting_appmsg_progress));
    this.kfh = paramView.findViewById(R.h.chatting_appmsg_progress_area);
    this.vBz = ((TextView)paramView.findViewById(R.h.chatting_appmsg_comment_tv));
    this.nSa = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    this.vCX = ((ImageView)paramView.findViewById(R.h.chatting_appmsg_refuse_iv));
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.hoY = paramView.findViewById(R.h.chatting_maskview);
    this.kHU = ((ImageView)paramView.findViewById(R.h.chatting_content_mask_iv));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.l.a
 * JD-Core Version:    0.7.0.1
 */