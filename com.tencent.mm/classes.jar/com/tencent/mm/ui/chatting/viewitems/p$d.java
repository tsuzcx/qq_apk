package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.k;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class p$d
  extends c.a
{
  public static final int vDm = a.fromDPToPix(ae.getContext(), 240);
  public static final int vDn = a.fromDPToPix(ae.getContext(), 192);
  static final c vDo;
  protected ThreeDotsLoadingView him;
  protected ImageView pEu;
  protected ChattingItemFooter vBA;
  protected ImageView vBB;
  protected LinearLayout vBC;
  protected ViewGroup vBD;
  protected TextView vBE;
  protected LinearLayout vBF;
  ImageView vBN;
  protected TextView vBR;
  protected ImageView vBS;
  protected TextView vBT;
  protected TextView vBU;
  protected LinearLayout vBV;
  protected TextView vBY;
  protected ImageView vBt;
  protected ImageView vBw;
  protected ImageView vBx;
  protected TextView vBz;
  protected ViewGroup vDp;
  protected View vDq;
  
  static
  {
    com.tencent.mm.as.a.a.c.a locala1 = new com.tencent.mm.as.a.a.c.a();
    locala1.eru = R.k.app_brand_app_default_icon_for_tail;
    com.tencent.mm.as.a.a.c.a locala2 = locala1.bn(a.fromDPToPix(ae.getContext(), 20), a.fromDPToPix(ae.getContext(), 20));
    locala2.erD = true;
    locala2.erf = true;
    locala2.erd = true;
    vDo = locala1.OV();
  }
  
  public final d u(View paramView, boolean paramBoolean)
  {
    super.dN(paramView);
    this.vBt = ((ImageView)paramView.findViewById(R.h.chatting_appmsg_sub_menu_icon));
    this.vBw = ((ImageView)this.kKz.findViewById(R.h.chatting_continue_btn));
    this.vBx = ((ImageView)this.kKz.findViewById(R.h.chatting_stop_btn));
    this.vBz = ((TextView)paramView.findViewById(R.h.chatting_appmsg_comment_tv));
    this.vBB = ((ImageView)paramView.findViewById(R.h.chatting_appmsg_refuse_iv));
    this.khV = ((CheckBox)paramView.findViewById(R.h.chatting_checkbox));
    this.hoY = paramView.findViewById(R.h.chatting_maskview);
    this.nSa = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
    this.vBA = ((ChattingItemFooter)paramView.findViewById(R.h.footer));
    this.vBC = ((LinearLayout)paramView.findViewById(R.h.app_msg_layout));
    this.vBD = ((ViewGroup)paramView.findViewById(R.h.location_share_layout));
    this.vBE = ((TextView)paramView.findViewById(R.h.location_share_content));
    this.vBF = ((LinearLayout)paramView.findViewById(R.h.chatting_area));
    this.igg = paramView.findViewById(R.h.chatting_click_area);
    if (!paramBoolean)
    {
      this.vBN = ((ImageView)this.kKz.findViewById(R.h.chatting_status_tick));
      this.nhQ = ((ProgressBar)this.kKz.findViewById(R.h.uploading_pb));
    }
    this.vBV = ((LinearLayout)paramView.findViewById(R.h.chatting_appmsg_appbrand_content));
    this.him = ((ThreeDotsLoadingView)paramView.findViewById(R.h.loading_view));
    this.pEu = ((ImageView)paramView.findViewById(R.h.cover_iv));
    this.vBY = ((TextView)paramView.findViewById(R.h.chatting_appmsg_appbrand_nickname_tv));
    this.vBR = ((TextView)paramView.findViewById(R.h.chatting_appmsg_appbrand_desc_tv));
    this.vBS = ((ImageView)paramView.findViewById(R.h.chatting_appmsg_appbrand_source_iv));
    this.vBT = ((TextView)paramView.findViewById(R.h.chatting_appmsg_appbrand_source_tv));
    this.vBU = ((TextView)paramView.findViewById(R.h.chatting_appmsg_appbrand_source_tag_tv));
    this.vDp = ((ViewGroup)paramView.findViewById(R.h.cover_vg));
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.p.d
 * JD-Core Version:    0.7.0.1
 */