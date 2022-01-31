package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.af;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.r;

public final class b
  extends r<av>
{
  private Context context;
  private View.OnClickListener pwf = new b.2(this);
  private View.OnClickListener pwg = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      Object localObject1;
      if ((paramAnonymousView.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b))
      {
        y.d("MicroMsg.FMessageConversationUI", "verifyOkOnClick onClick");
        localObject1 = (com.tencent.mm.pluginsdk.ui.preference.b)paramAnonymousView.getTag();
        localObject2 = com.tencent.mm.bh.d.RX().abU(((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).username);
        if ((localObject2 == null) || (((ax)localObject2).field_msgContent == null)) {
          y.e("MicroMsg.FMessageConversationUI", "lastRecvFmsg is null, verify fail, talker = " + ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).username);
        }
      }
      else
      {
        return;
      }
      paramAnonymousView = bi.d.acc(((ax)localObject2).field_msgContent);
      y.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).username + ", opcode = MM_VERIFYUSER_VERIFYOK");
      if (paramAnonymousView.uCm == 1)
      {
        h.a(b.a(b.this), paramAnonymousView.uCn, null, b.a(b.this).getString(R.l.fmessage_goto_verify), b.a(b.this).getString(R.l.app_cancel), true, new b.3.1(this, (ax)localObject2), null);
        return;
      }
      au.Hx();
      bv localbv = c.Fx().Id(((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).username);
      Object localObject2 = new Intent();
      ((Intent)localObject2).putExtra("Contact_User", ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).username);
      ((Intent)localObject2).putExtra("Contact_Nick", ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).nickname);
      if (localbv != null) {
        ((Intent)localObject2).putExtra("Contact_RemarkName", localbv.field_conRemark);
      }
      if (!bk.bl(paramAnonymousView.chatroomName))
      {
        au.Hx();
        localObject1 = c.FF().in(paramAnonymousView.chatroomName);
        if (localObject1 != null) {
          ((Intent)localObject2).putExtra("Contact_RoomNickname", ((u)localObject1).gV(paramAnonymousView.pyp));
        }
      }
      ((Intent)localObject2).putExtra("Contact_Scene", paramAnonymousView.scene);
      ((Intent)localObject2).putExtra("Verify_ticket", paramAnonymousView.kzG);
      ((Intent)localObject2).putExtra("sayhi_with_sns_perm_send_verify", false);
      ((Intent)localObject2).putExtra("sayhi_with_sns_perm_add_remark", true);
      ((Intent)localObject2).putExtra("sayhi_with_sns_perm_set_label", true);
      ((Intent)localObject2).putExtra("sayhi_with_jump_to_profile", true);
      com.tencent.mm.br.d.b(b.a(b.this), "profile", ".ui.SayHiWithSnsPermissionUI", (Intent)localObject2);
    }
  };
  
  public b(Context paramContext)
  {
    super(paramContext, new av());
    this.context = paramContext;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.context, R.i.fmessage_contact_item, null);
      paramViewGroup = new a();
      paramViewGroup.pwn = ((MaskLayout)paramView.findViewById(R.h.fmessage_contact_item_avatar));
      paramViewGroup.mYa = ((TextView)paramView.findViewById(R.h.fmessage_contact_item_nick_tv));
      paramViewGroup.pws = ((TextView)paramView.findViewById(R.h.fmessage_contact_item_digest_tv));
      paramViewGroup.pwo = ((Button)paramView.findViewById(R.h.fmessage_contact_add_btn));
      paramViewGroup.pwo.setOnClickListener(this.pwf);
      paramViewGroup.pwp = ((Button)paramView.findViewById(R.h.fmessage_contact_verify_ok_btn));
      paramViewGroup.pwp.setOnClickListener(this.pwg);
      paramViewGroup.pwq = ((TextView)paramView.findViewById(R.h.fmessage_contact_item_verifying_tv));
      paramViewGroup.pwr = ((TextView)paramView.findViewById(R.h.fmessage_contact_item_added_tv));
      paramView.setTag(paramViewGroup);
    }
    av localav;
    for (;;)
    {
      localav = (av)getItem(paramInt);
      a.b.a((ImageView)paramViewGroup.pwn.getContentView(), localav.field_talker);
      paramViewGroup.mYa.setText(j.a(this.context, localav.field_displayName, paramViewGroup.mYa.getTextSize()));
      if (localav.field_fmsgSysRowId > 0L) {
        break label501;
      }
      y.w("MicroMsg.FMessageConversationUI", "getView, fconv fmsgSysRowId is invalid, try getLastFmsg");
      localObject1 = com.tencent.mm.bh.d.RX().abT(localav.field_talker);
      if (localObject1 != null) {
        break;
      }
      y.e("MicroMsg.FMessageConversationUI", "getView, lastFmsg is null, talker = " + localav.field_talker);
      paramViewGroup.pwo.setVisibility(8);
      paramViewGroup.pwp.setVisibility(8);
      paramViewGroup.pwq.setVisibility(8);
      paramViewGroup.pwr.setVisibility(8);
      paramViewGroup.pws.setVisibility(8);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
    }
    Object localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(this.context, (ax)localObject1);
    y.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg talker = " + localav.field_talker);
    Object localObject2;
    if (localav.field_state == 1)
    {
      au.Hx();
      localObject2 = c.Fw().abl(localav.field_talker);
      if ((localObject2 != null) && ((int)((a)localObject2).dBe != 0) && (!a.gR(((ao)localObject2).field_type))) {
        com.tencent.mm.bh.d.RY().du(localav.field_talker, 0);
      }
    }
    if (localObject1 == null)
    {
      y.e("MicroMsg.FMessageConversationUI", "getView, fProvider is null, talker = " + localav.field_talker);
      paramViewGroup.pwo.setVisibility(8);
      paramViewGroup.pwp.setVisibility(8);
      paramViewGroup.pwq.setVisibility(8);
      paramViewGroup.pwr.setVisibility(8);
      paramViewGroup.pws.setVisibility(8);
      return paramView;
      label501:
      localObject1 = this.context;
      long l = localav.field_fmsgSysRowId;
      if (localav.field_fmsgIsSend % 2 == 0) {}
      for (boolean bool = true;; bool = false)
      {
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a((Context)localObject1, l, bool, localav.field_talker, localav.field_fmsgContent, localav.field_fmsgType, localav.field_contentFromUsername, localav.field_contentNickname, localav.field_contentPhoneNumMD5, localav.field_contentFullPhoneNumMD5, localav.field_contentVerifyContent, localav.field_addScene);
        y.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg sysrowid = " + localav.field_fmsgSysRowId + ", talker = " + localav.field_talker);
        break;
      }
    }
    ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).ocd = localav.field_addScene;
    paramViewGroup.pws.setText(j.a(this.context, ((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).dTF, paramViewGroup.pws.getTextSize()));
    switch (localav.field_state)
    {
    default: 
      paramViewGroup.pwo.setVisibility(8);
      paramViewGroup.pwp.setVisibility(8);
      paramViewGroup.pwq.setVisibility(8);
      paramViewGroup.pwr.setVisibility(8);
      paramViewGroup = paramView.findViewById(R.h.fmessage_contact_item_layout);
      if (localav.field_isNew != 0) {
        break;
      }
    }
    for (paramInt = R.g.mm_listitem;; paramInt = R.g.comm_item_highlight_selector)
    {
      paramViewGroup.setBackgroundResource(paramInt);
      return paramView;
      if (localav.field_fmsgSysRowId <= 0L)
      {
        y.w("MicroMsg.FMessageConversationUI", "getView, fmsgSysRowId invalid, try use lastRecvFmsg");
        localObject2 = com.tencent.mm.bh.d.RX().abU(((com.tencent.mm.pluginsdk.ui.preference.b)localObject1).username);
        if (localObject2 == null)
        {
          paramInt = 0;
          label801:
          if ((paramInt != 0) && (paramInt != 3)) {
            break label875;
          }
          paramViewGroup.pwo.setVisibility(0);
          paramViewGroup.pwo.setTag(localObject1);
          paramViewGroup.pwp.setVisibility(8);
        }
      }
      for (;;)
      {
        paramViewGroup.pwq.setVisibility(8);
        paramViewGroup.pwr.setVisibility(8);
        break;
        paramInt = ((ax)localObject2).field_type;
        break label801;
        paramInt = localav.field_recvFmsgType;
        break label801;
        label875:
        paramViewGroup.pwp.setVisibility(0);
        paramViewGroup.pwp.setTag(localObject1);
        paramViewGroup.pwo.setVisibility(8);
      }
      paramViewGroup.pwq.setVisibility(0);
      paramViewGroup.pwo.setVisibility(8);
      paramViewGroup.pwp.setVisibility(8);
      paramViewGroup.pwr.setVisibility(8);
      break;
      paramViewGroup.pwr.setVisibility(0);
      paramViewGroup.pwo.setVisibility(8);
      paramViewGroup.pwp.setVisibility(8);
      paramViewGroup.pwq.setVisibility(8);
      break;
    }
  }
  
  public final void yc()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      setCursor(com.tencent.mm.bh.d.RY().aAn());
      notifyDataSetChanged();
      return;
    }
    ai.d(new b.1(this));
  }
  
  protected final void yd()
  {
    bcS();
    yc();
  }
  
  static final class a
  {
    public TextView mYa;
    public MaskLayout pwn;
    public Button pwo;
    public Button pwp;
    public TextView pwq;
    public TextView pwr;
    public TextView pws;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.ui.friend.b
 * JD-Core Version:    0.7.0.1
 */