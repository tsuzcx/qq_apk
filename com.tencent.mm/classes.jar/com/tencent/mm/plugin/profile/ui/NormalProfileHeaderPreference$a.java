package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.patmsg.ui.AvatarPatTipImageView;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.g;
import com.tencent.mm.pluginsdk.ui.preference.FMessageListView;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;

final class NormalProfileHeaderPreference$a
{
  TextView JBA;
  TextView MYA;
  MMNeat7extView MYB;
  TextView MYC;
  TextView MYD;
  TextView MYE;
  TextView MYF;
  TextView MYG;
  AvatarPatTipImageView MYH;
  FMessageListView MYI;
  private View MYJ;
  LinearLayout MYK;
  g MYL;
  View MYM;
  ImageView MYN;
  private ImageView MYO;
  private ImageView MYP;
  View MYQ;
  ImageView MYR;
  View MYS;
  private View MYT;
  View MYU;
  ImageView MYV;
  TextView MYW;
  private View MYt;
  private View MYu;
  private View MYv;
  private View MYw;
  private View MYx;
  private View MYy;
  ImageView MYz;
  View pKl;
  View plc;
  TextView yEQ;
  
  NormalProfileHeaderPreference$a(final NormalProfileHeaderPreference paramNormalProfileHeaderPreference, View paramView)
  {
    AppMethodBeat.i(27274);
    this.MYt = null;
    this.MYu = null;
    this.MYv = null;
    this.MYw = null;
    this.MYx = null;
    this.MYy = null;
    this.MYz = null;
    this.yEQ = null;
    this.MYA = null;
    this.MYB = null;
    this.MYC = null;
    this.JBA = null;
    this.MYD = null;
    this.MYE = null;
    this.MYF = null;
    this.MYG = null;
    this.MYH = null;
    this.MYK = null;
    this.MYL = null;
    this.MYM = null;
    this.plc = paramView;
    if ((this.plc != null) && (NormalProfileHeaderPreference.g(paramNormalProfileHeaderPreference) != null)) {
      this.plc.addOnLayoutChangeListener(NormalProfileHeaderPreference.g(paramNormalProfileHeaderPreference));
    }
    this.MYQ = paramView.findViewById(R.h.accept_setting_layout);
    this.MYI = ((FMessageListView)paramView.findViewById(R.h.contact_profile_fmessage_listview));
    this.MYJ = paramView.findViewById(R.h.contact_profile_fmessage_listview_line);
    this.MYt = paramView.findViewById(R.h.contact_profile_delete_contact);
    this.MYu = paramView.findViewById(R.h.contact_profile_accept_contact);
    this.MYv = paramView.findViewById(R.h.contact_profile_say_hi);
    this.MYx = paramView.findViewById(R.h.contact_profile_add_contact);
    this.MYy = paramView.findViewById(R.h.contact_profile_send_msg_layout);
    this.MYw = paramView.findViewById(R.h.contact_profile_voip_layout);
    this.MYH = ((AvatarPatTipImageView)paramView.findViewById(R.h.contact_profile_avatar_iv));
    this.MYC = ((TextView)paramView.findViewById(R.h.contact_profile_chatroom_nickname_tv));
    this.MYB = ((MMNeat7extView)paramView.findViewById(R.h.contact_profile_remark_tv));
    this.yEQ = ((TextView)paramView.findViewById(R.h.contact_profile_nickname_tv));
    this.MYU = paramView.findViewById(R.h.contact_finder_auth_info_layout);
    this.MYV = ((ImageView)paramView.findViewById(R.h.contact_finder_auth_icon));
    this.MYW = ((TextView)paramView.findViewById(R.h.contact_finder_auth_info));
    this.MYA = ((TextView)paramView.findViewById(R.h.contact_open_im_tv));
    this.MYz = ((ImageView)paramView.findViewById(R.h.contact_profile_sex_iv));
    this.JBA = ((TextView)paramView.findViewById(R.h.contact_profile_username_tv));
    this.MYD = ((TextView)paramView.findViewById(R.h.contact_profile_signature));
    this.MYE = ((TextView)paramView.findViewById(R.h.contact_profile_location));
    this.MYF = ((TextView)paramView.findViewById(R.h.contact_profile_distance));
    this.MYG = ((TextView)paramView.findViewById(R.h.contact_profile_tip));
    this.MYN = ((ImageView)paramView.findViewById(R.h.contact_power_star));
    this.MYO = ((ImageView)paramView.findViewById(R.h.contact_power_sns_feed));
    this.MYP = ((ImageView)paramView.findViewById(R.h.contact_power_sns_out));
    this.MYR = ((ImageView)paramView.findViewById(R.h.contact_corner_bg));
    this.MYS = paramView.findViewById(R.h.contact_profile_root_root);
    this.MYT = paramView.findViewById(R.h.contact_profile_base_info);
    this.MYK = ((LinearLayout)paramView.findViewById(R.h.contact_profile_header_root));
    this.MYM = paramView.findViewById(R.h.v_intercept_head_root_click);
    if (!au.bwQ(NormalProfileHeaderPreference.h(paramNormalProfileHeaderPreference).field_username))
    {
      Object localObject1 = (RelativeLayout)this.MYS;
      Object localObject2 = this.MYK;
      if (ac.hFS())
      {
        localObject2 = ((f)h.az(f.class)).getProfileCardView(this.MYq.mContext, (RelativeLayout)localObject1, (LinearLayout)localObject2, this.MYq.mContext.getResources().getDimensionPixelSize(R.f.Edge_2A));
        ((RelativeLayout)localObject1).addView(((g)localObject2).getView());
        localObject1 = (RelativeLayout.LayoutParams)((g)localObject2).getView().getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject1).width = -1;
        ((RelativeLayout.LayoutParams)localObject1).height = -2;
        ((RelativeLayout.LayoutParams)localObject1).addRule(3, R.h.contact_profile_header_root);
        this.MYL = ((g)localObject2);
      }
    }
    this.pKl = paramView.findViewById(R.h.divider);
    this.MYQ.findViewById(R.h.remark_name).setOnClickListener(paramNormalProfileHeaderPreference);
    this.MYQ.findViewById(R.h.mod_sns_permission).setOnClickListener(paramNormalProfileHeaderPreference);
    this.MYy.setOnClickListener(paramNormalProfileHeaderPreference);
    this.MYw.setOnClickListener(paramNormalProfileHeaderPreference);
    this.MYH.setOnClickListener(paramNormalProfileHeaderPreference);
    this.MYt.setOnClickListener(paramNormalProfileHeaderPreference);
    this.MYu.setOnClickListener(paramNormalProfileHeaderPreference);
    this.MYv.setOnClickListener(paramNormalProfileHeaderPreference);
    this.MYx.setOnClickListener(paramNormalProfileHeaderPreference);
    if ((this.plc.getContext() instanceof Activity)) {
      this.MYI.setForceHideReply(((Activity)this.plc.getContext()).getIntent().getBooleanExtra("Contact_Conversation_IsForceHideReplyBtn", false));
    }
    this.JBA.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(27273);
        NormalProfileHeaderPreference.a.this.MYq.qjs = ((int)paramAnonymousMotionEvent.getRawX());
        NormalProfileHeaderPreference.a.this.MYq.qjt = ((int)paramAnonymousMotionEvent.getRawY());
        int i = NormalProfileHeaderPreference.a.this.MYq.qjs;
        int j = NormalProfileHeaderPreference.a.this.MYq.qjt;
        paramAnonymousView.setTag(R.h.touch_loc, new int[] { i, j });
        AppMethodBeat.o(27273);
        return false;
      }
    });
    this.JBA.setOnLongClickListener(paramNormalProfileHeaderPreference);
    paramView = i.agtt;
    if (i.a(b.a.agqA, 0) == 1) {
      this.MYB.setOnLongClickListener(paramNormalProfileHeaderPreference);
    }
    if (this.MYR != null) {
      this.MYR.setOnClickListener(paramNormalProfileHeaderPreference);
    }
    if (this.MYS != null) {
      this.MYS.setOnClickListener(paramNormalProfileHeaderPreference);
    }
    AppMethodBeat.o(27274);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.NormalProfileHeaderPreference.a
 * JD-Core Version:    0.7.0.1
 */