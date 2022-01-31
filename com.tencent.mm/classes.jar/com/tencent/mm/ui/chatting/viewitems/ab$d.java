package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.h;

final class ab$d
  extends c.a
{
  TextView kiv;
  ProgressBar nhQ;
  ImageView vBN;
  ImageView vCQ;
  TextView vEY;
  ImageView vEZ;
  View vFa;
  
  public final c.a s(View paramView, boolean paramBoolean)
  {
    super.dN(paramView);
    this.dsz = ((TextView)paramView.findViewById(R.h.chatting_time_tv));
    this.vCQ = ((ImageView)paramView.findViewById(R.h.chatting_content_iv));
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.hoY = paramView.findViewById(R.h.chatting_maskview);
    this.vFa = paramView.findViewById(R.h.uploading_view);
    if (paramBoolean)
    {
      this.nSa = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
      this.nhQ = ((ProgressBar)paramView.findViewById(R.h.downloading_pb));
    }
    for (;;)
    {
      this.vEZ = ((ImageView)paramView.findViewById(R.h.chatting_content_mask_iv));
      this.kiv = ((TextView)paramView.findViewById(R.h.chatting_appmsg_source_tv));
      return this;
      this.nhQ = ((ProgressBar)paramView.findViewById(R.h.uploading_pb));
      this.vEY = ((TextView)paramView.findViewById(R.h.uploading_tv));
      this.nSa = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
      this.vBN = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ab.d
 * JD-Core Version:    0.7.0.1
 */