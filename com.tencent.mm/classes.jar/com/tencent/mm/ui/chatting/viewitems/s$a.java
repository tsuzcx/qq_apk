package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.sdk.platformtools.ae;

final class s$a
  extends c.a
{
  TextView doV;
  ImageView vBN;
  public int vBZ;
  ImageView vDJ;
  TextView vDK;
  TextView vDL;
  
  public final c.a s(View paramView, boolean paramBoolean)
  {
    super.dN(paramView);
    this.vDJ = ((ImageView)paramView.findViewById(R.h.chatting_avatar_iv_card));
    this.dsz = ((TextView)paramView.findViewById(R.h.chatting_time_tv));
    this.vDK = ((TextView)paramView.findViewById(R.h.chatting_type_tv));
    this.vDL = ((TextView)paramView.findViewById(R.h.chatting_username_tv));
    this.doV = ((TextView)paramView.findViewById(R.h.chatting_nickname_tv));
    this.nSa = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    this.igg = paramView.findViewById(R.h.chatting_click_area);
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.hoY = paramView.findViewById(R.h.chatting_maskview);
    if (!paramBoolean)
    {
      this.vBa = ((ImageView)paramView.findViewById(R.h.chatting_state_iv));
      this.vBN = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
      this.nhQ = ((ProgressBar)paramView.findViewById(R.h.uploading_pb));
    }
    this.vBZ = c.gT(ae.getContext());
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.s.a
 * JD-Core Version:    0.7.0.1
 */