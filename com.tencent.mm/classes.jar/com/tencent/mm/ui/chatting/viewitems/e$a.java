package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;

final class e$a
  extends c.a
{
  public int maxSize = 0;
  public int vBZ = 0;
  public ImageView vCn;
  public TextView vCo;
  public TextView vCp;
  public TextView vCq;
  public int vCr = 0;
  
  public final a dO(View paramView)
  {
    super.dN(paramView);
    this.dsz = ((TextView)this.kKz.findViewById(R.h.chatting_time_tv));
    this.khV = ((CheckBox)this.kKz.findViewById(R.h.chatting_checkbox));
    this.hoY = this.kKz.findViewById(R.h.chatting_maskview);
    this.nSa = ((TextView)this.kKz.findViewById(R.h.chatting_user_tv));
    this.vCn = ((ImageView)this.kKz.findViewById(R.h.appmsg_c2c_icon));
    this.vCo = ((TextView)this.kKz.findViewById(R.h.appmsg_c2c_title));
    this.vCp = ((TextView)this.kKz.findViewById(R.h.appmsg_c2c_desc));
    this.vCq = ((TextView)this.kKz.findViewById(R.h.appmsg_c2c_tmpl_title));
    this.igg = ((LinearLayout)this.kKz.findViewById(R.h.chatting_click_area));
    this.vBZ = c.gT(ae.getContext());
    this.vCr = a.aa(ae.getContext(), R.f.ChatLucyTitleTextSize);
    this.maxSize = ((int)(a.ab(ae.getContext(), R.f.ChatLucyTitleTextSize) * 1.45F));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e.a
 * JD-Core Version:    0.7.0.1
 */