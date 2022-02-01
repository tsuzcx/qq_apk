package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.e;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.e.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.Map;

public final class ag
{
  public static void a(com.tencent.mm.ui.chatting.e.a parama, String paramString, bv.a parama1, a parama2)
  {
    AppMethodBeat.i(37189);
    if (!an.aUq(paramString))
    {
      AppMethodBeat.o(37189);
      return;
    }
    String str = parama1.JgX;
    str = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).a(str, "openim_card_type_name", a.a.iKm);
    if (TextUtils.isEmpty(str))
    {
      parama2.KxZ.setText(2131757260);
      parama2.KxY.setBackgroundResource(2131231875);
      c.z(parama2.KxY, paramString);
      str = parama1.JgZ;
      paramString = parama1.JgY;
      if (af.isNullOrNil(str)) {
        break label171;
      }
    }
    label171:
    for (parama = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.a.class)).a(parama.Kkd.getContext(), str, paramString, parama2.Kya.getTextSize());; parama = paramString)
    {
      if (TextUtils.isEmpty(parama)) {
        break label176;
      }
      parama2.Kya.setVisibility(0);
      parama2.Kya.setText(parama);
      AppMethodBeat.o(37189);
      return;
      parama2.KxZ.setText(str);
      break;
    }
    label176:
    parama2.Kya.setVisibility(8);
    AppMethodBeat.o(37189);
  }
  
  public static void a(com.tencent.mm.ui.chatting.e.a parama, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, bv parambv)
  {
    AppMethodBeat.i(37190);
    String str = paramString2;
    if (paramBoolean1)
    {
      str = paramString2;
      if (paramBoolean2) {
        str = com.tencent.mm.model.bl.BN(paramString2);
      }
    }
    bc.aCg();
    bv.a locala = com.tencent.mm.model.c.azI().arp(str);
    if (locala == null)
    {
      AppMethodBeat.o(37190);
      return;
    }
    Intent localIntent = new Intent();
    paramBoolean1 = x.oq(locala.Ecg);
    str = locala.cUA;
    paramString2 = str;
    if (!paramBoolean1)
    {
      com.tencent.mm.plugin.report.service.g.yxI.dD(1430, 0);
      bc.aCg();
      paramString2 = com.tencent.mm.model.c.azF().BH(str);
      if ((paramString2 != null) && (com.tencent.mm.contact.c.lO(paramString2.field_type)))
      {
        paramString2 = paramString2.field_username;
        com.tencent.mm.plugin.report.service.g.yxI.dD(1430, 1);
      }
    }
    else
    {
      localIntent.putExtra("Contact_User", paramString2);
      localIntent.putExtra("Contact_Alias", locala.fhy);
      localIntent.putExtra("Contact_Nick", locala.nickname);
      localIntent.putExtra("Contact_QuanPin", locala.jhO);
      localIntent.putExtra("Contact_PyInitial", locala.jhN);
      localIntent.putExtra("Contact_Uin", locala.xik);
      localIntent.putExtra("Contact_Mobile_MD5", locala.JgT);
      localIntent.putExtra("Contact_full_Mobile_MD5", locala.JgU);
      localIntent.putExtra("Contact_QQNick", locala.fwt());
      localIntent.putExtra("User_From_Fmessage", false);
      localIntent.putExtra("Contact_Scene", locala.scene);
      localIntent.putExtra("Contact_FMessageCard", true);
      localIntent.putExtra("Contact_RemarkName", locala.jhS);
      localIntent.putExtra("Contact_VUser_Info_Flag", locala.Ecg);
      localIntent.putExtra("Contact_VUser_Info", locala.eRk);
      localIntent.putExtra("Contact_BrandIconURL", locala.xfV);
      localIntent.putExtra("Contact_Province", locala.getProvince());
      localIntent.putExtra("Contact_City", locala.getCity());
      localIntent.putExtra("Contact_Sex", locala.eQV);
      localIntent.putExtra("Contact_Signature", locala.signature);
      localIntent.putExtra("Contact_ShowUserName", true);
      localIntent.putExtra("Contact_KSnsIFlag", 0);
      localIntent.putExtra("Contact_Source_FMessage", 17);
      localIntent.putExtra("source_from_user_name", paramString1);
      localIntent.putExtra("source_from_nick_name", w.zO(paramString1));
      localIntent.putExtra(e.c.JoX, locala.Fyj);
      localIntent.putExtra("key_add_contact_openim_appid", locala.JgX);
      localIntent.putExtra("key_add_contact_custom_detail", locala.Jha);
      localIntent.putExtra("key_forward_flag", parambv.fvW());
      localIntent.putExtra("key_msg_id", parambv.field_msgId);
      if ((locala.Ecg & 0x8) > 0)
      {
        if (!af.isNullOrNil(paramString1))
        {
          bc.aCg();
          if (com.tencent.mm.model.c.azF().BH(paramString1).fug()) {
            break label898;
          }
        }
        localIntent.putExtra("Contact_Scene", 17);
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(10298, locala.cUA + ",17");
      }
      label603:
      if ((an.aUq(locala.cUA)) && (locala.scene == 0)) {
        localIntent.putExtra("Contact_Scene", 17);
      }
      if (x.oq(locala.Ecg))
      {
        if (!parama.fJC()) {
          break label945;
        }
        localIntent.putExtra("preChatTYPE", 2);
      }
    }
    for (;;)
    {
      localIntent.putExtra("prePublishId", "msg_" + parambv.field_msgSvrId);
      paramString2 = paramString1;
      if (af.isNullOrNil(paramString1)) {
        paramString2 = v.aAC();
      }
      localIntent.putExtra("preUsername", paramString2);
      localIntent.putExtra("preChatName", parambv.field_talker);
      com.tencent.mm.br.d.b(parama.Kkd.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
      com.tencent.mm.bs.a.aae(locala.scene);
      AppMethodBeat.o(37190);
      return;
      bc.aCg();
      paramString2 = com.tencent.mm.model.c.azH().aqT(str);
      if ((paramString2 != null) && (!af.isNullOrNil(paramString2.field_username)))
      {
        paramString2 = paramString2.field_username;
        com.tencent.mm.plugin.report.service.g.yxI.dD(1430, 2);
        break;
      }
      if ((paramString2 == null) || (af.isNullOrNil(paramString2.field_encryptUsername)))
      {
        paramString2 = new com.tencent.mm.storage.bl(str);
        paramString2.field_modifyTime = System.currentTimeMillis();
        bc.aCg();
        if (!com.tencent.mm.model.c.azH().replace(paramString2)) {
          ae.e("MicroMsg.ChattingItemCardTo", "add friendUser fail, encryptUsername:%s", new Object[] { str });
        }
      }
      localIntent.putExtra("force_get_contact", true);
      com.tencent.mm.plugin.report.service.g.yxI.dD(1430, 3);
      paramString2 = str;
      break;
      label898:
      localIntent.putExtra("Contact_Scene", 41);
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(10298, locala.cUA + ",41");
      break label603;
      label945:
      localIntent.putExtra("preChatTYPE", 1);
    }
  }
  
  static final class a
    extends c.a
  {
    ImageView KvW;
    public int KwJ;
    ImageView KxY;
    TextView KxZ;
    TextView Kya;
    TextView fQm;
    
    public final c.a E(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(37176);
      super.gs(paramView);
      this.KxY = ((ImageView)paramView.findViewById(2131298057));
      this.fVV = ((TextView)paramView.findViewById(2131298178));
      this.KxZ = ((TextView)paramView.findViewById(2131298182));
      this.Kya = ((TextView)paramView.findViewById(2131298186));
      this.fQm = ((TextView)paramView.findViewById(2131298152));
      this.yUp = ((TextView)paramView.findViewById(2131298185));
      this.olI = paramView.findViewById(2131298069);
      this.iFD = ((CheckBox)paramView.findViewById(2131298068));
      this.hcH = paramView.findViewById(2131298147);
      if (!paramBoolean)
      {
        this.KuL = ((ImageView)paramView.findViewById(2131298174));
        this.KvW = ((ImageView)paramView.findViewById(2131298176));
        this.xvJ = ((ProgressBar)paramView.findViewById(2131306220));
      }
      this.KwJ = c.ku(ak.getContext());
      AppMethodBeat.o(37176);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JWz;
    private String KzW;
    private String KzX;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(37177);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ah(paramLayoutInflater, 2131493450);
        ((View)localObject).setTag(new ag.a().E((View)localObject, true));
      }
      AppMethodBeat.o(37177);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
    {
      AppMethodBeat.i(37179);
      this.JWz = parama1;
      ag.a locala = (ag.a)parama;
      bv.a locala1;
      if (parama1.fJC())
      {
        parama = com.tencent.mm.model.bl.BN(parambv.field_content);
        bc.aCg();
        locala1 = com.tencent.mm.model.c.azI().arp(parama);
        if ((locala1.cUA == null) || (locala1.cUA.length() <= 0)) {
          ae.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
        }
        this.KzW = locala1.cUA;
        this.KzX = "";
        if (!af.isNullOrNil(parama))
        {
          parama = bx.M(parama, "msg");
          if (parama == null) {
            ae.e("MicroMsg.ChattingItemCardFrom", "null==attrs");
          }
          if ((parama != null) && (parama.containsKey(".msg.$wechatid"))) {
            this.KzX = ((String)parama.get(".msg.$wechatid"));
          }
        }
        com.tencent.mm.aj.c.al(this.KzW, locala1.JgS);
        ag.a.aI(locala.olI, locala.KwJ);
        if (!x.oq(locala1.Ecg)) {
          break label451;
        }
        locala.KxZ.setText(2131757135);
        locala.Kya.setVisibility(8);
        if (!com.tencent.mm.compatible.util.d.lA(16)) {
          break label439;
        }
        locala.KxY.setBackground(null);
        label217:
        A(locala.KxY, this.KzW);
        label229:
        parama = this.KzX;
        if ((!af.isNullOrNil(parama)) && (!an.aUy(parama)) && (!x.Am(parama))) {
          break label504;
        }
      }
      label281:
      label439:
      label451:
      label491:
      label504:
      for (int i = 1;; i = 0)
      {
        boolean bool = x.oq(locala1.Ecg);
        if ((i != 0) || (bool))
        {
          parama = "";
          if (af.isNullOrNil(parama)) {
            break label491;
          }
          locala.Kya.setVisibility(0);
          locala.Kya.setText(parama);
        }
        for (;;)
        {
          locala.fQm.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.Kkd.getContext(), locala1.nickname, (int)locala.fQm.getTextSize()));
          ag.a(parama1, this.KzW, locala1, locala);
          locala.olI.setTag(new bk(parambv, parama1.fJC(), paramInt, paramString, '\000'));
          locala.olI.setOnClickListener(d(parama1));
          locala.olI.setOnLongClickListener(c(parama1));
          locala.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
          AppMethodBeat.o(37179);
          return;
          parama = parambv.field_content;
          break;
          locala.KxY.setBackgroundDrawable(null);
          break label217;
          locala.KxZ.setText(2131757260);
          locala.KxY.setBackgroundResource(2131231875);
          z(locala.KxY, this.KzW);
          break label229;
          break label281;
          locala.Kya.setVisibility(8);
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(37181);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37181);
        return false;
      }
      paramMenuItem = parama.Kkd.getContext();
      if (com.tencent.mm.ui.chatting.k.bc(parambv))
      {
        h.a(paramMenuItem, paramMenuItem.getString(2131759586), "", paramMenuItem.getString(2131766205), null);
        AppMethodBeat.o(37181);
        return false;
      }
      if (com.tencent.mm.ui.chatting.k.bd(parambv))
      {
        h.a(paramMenuItem, paramMenuItem.getString(2131759587), "", paramMenuItem.getString(2131766205), null);
        AppMethodBeat.o(37181);
        return false;
      }
      paramMenuItem = new Intent(parama.Kkd.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.model.bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 8);
      paramMenuItem.putExtra("Retr_Msg_Id", parambv.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37181);
      return false;
    }
    
    public final boolean a(l paraml, View paramView, bv parambv)
    {
      AppMethodBeat.i(187821);
      int j = ((bk)paramView.getTag()).position;
      bc.aCg();
      bv.a locala = com.tencent.mm.model.c.azI().arp(parambv.field_content);
      if ((locala.cUA == null) || (locala.cUA.length() <= 0)) {
        ae.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
      }
      this.KzW = locala.cUA;
      boolean bool = x.oq(locala.Ecg);
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFU, 0) == 1) {}
      for (int i = 1;; i = 0)
      {
        if (((i != 0) && (parambv.getType() != 66) && (!an.aUq(this.JWz.getTalkerUserName())) && (!an.aUr(this.JWz.getTalkerUserName()))) || (bool)) {
          paraml.a(j, 118, paramView.getContext().getString(2131762559), 2131690478);
        }
        if (!this.JWz.fJD()) {
          paraml.a(j, 100, paramView.getContext().getString(2131757221), 2131690384);
        }
        AppMethodBeat.o(187821);
        return true;
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(37182);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).aaK(parambv.field_talker);
      paramView = (bk)paramView.getTag();
      String str1 = paramView.userName;
      String str2 = parambv.field_content;
      boolean bool2 = paramView.JSi;
      if (parambv.field_isSend == 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ag.a(parama, str1, str2, bool2, bool1, parambv);
        AppMethodBeat.o(37182);
        return true;
      }
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(37178);
      boolean bool = parama.fJC();
      AppMethodBeat.o(37178);
      return bool;
    }
    
    public final boolean br(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 42) || (paramInt == 66));
    }
    
    public final boolean fLz()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
    implements t.n
  {
    private com.tencent.mm.ui.chatting.e.a JWz;
    private String KzW;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(37183);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ah(paramLayoutInflater, 2131493494);
        ((View)localObject).setTag(new ag.a().E((View)localObject, false));
      }
      AppMethodBeat.o(37183);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(37188);
      parambv.fvZ();
      bc.aCg();
      com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
      ((e)parama.bh(e.class)).bE(parambv);
      AppMethodBeat.o(37188);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
    {
      boolean bool1 = true;
      AppMethodBeat.i(37184);
      this.JWz = parama1;
      paramString = (ag.a)parama;
      bc.aCg();
      bv.a locala = com.tencent.mm.model.c.azI().arp(parambv.field_content);
      if ((locala.cUA == null) || (locala.cUA.length() <= 0)) {
        ae.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
      }
      this.KzW = locala.cUA;
      ae.d("MicroMsg.ChattingItemCardTo", "dancy is biz: %s, userName: %s ", new Object[] { Boolean.valueOf(x.Ao(this.KzW)), this.KzW });
      ag.a.aI(paramString.olI, paramString.KwJ);
      if (x.oq(locala.Ecg))
      {
        paramString.KxZ.setText(2131757135);
        paramString.Kya.setVisibility(8);
        if (com.tencent.mm.compatible.util.d.lA(16))
        {
          paramString.KxY.setBackground(null);
          A(paramString.KxY, this.KzW);
          label177:
          paramString.fQm.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.Kkd.getContext(), locala.nickname, paramString.fQm.getTextSize()));
          parama = locala.fhy;
          if (!af.isNullOrNil(this.KzW))
          {
            bc.aCg();
            an localan = com.tencent.mm.model.c.azF().BH(this.KzW);
            if ((localan != null) && (com.tencent.mm.contact.c.lO(localan.field_type))) {
              break label639;
            }
          }
        }
      }
      label302:
      label351:
      label610:
      label639:
      for (int i = 1;; i = 0)
      {
        if ((i == 0) && (af.isNullOrNil(parama)))
        {
          parama = this.KzW;
          if ((af.isNullOrNil(parama)) || (an.aUy(parama)) || (x.Am(parama))) {
            i = 1;
          }
        }
        for (;;)
        {
          boolean bool2 = x.oq(locala.Ecg);
          if ((i != 0) || (bool2)) {
            parama = "";
          }
          if (!af.isNullOrNil(parama))
          {
            paramString.Kya.setVisibility(0);
            paramString.Kya.setText(parama);
            ag.a(parama1, this.KzW, locala, paramString);
            paramString.olI.setTag(new bk(parambv, parama1.fJC(), paramInt, null, '\000'));
            paramString.olI.setOnClickListener(d(parama1));
            paramString.olI.setOnLongClickListener(c(parama1));
            paramString.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
            if (!fLB()) {
              break label610;
            }
            b(paramString, false);
            if ((parambv.field_status != 2) || (!b((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambv.field_msgId))) {
              break label589;
            }
            if (paramString.KvW != null) {
              paramString.KvW.setVisibility(0);
            }
          }
          for (;;)
          {
            a(paramInt, paramString, parambv, parama1.fJy(), parama1.fJC(), parama1, this);
            AppMethodBeat.o(37184);
            return;
            paramString.KxY.setBackgroundDrawable(null);
            break;
            paramString.KxZ.setText(2131757260);
            paramString.KxY.setBackgroundResource(2131231875);
            z(paramString.KxY, this.KzW);
            break label177;
            i = 0;
            break label302;
            paramString.Kya.setVisibility(8);
            break label351;
            if (paramString.KvW != null) {
              paramString.KvW.setVisibility(8);
            }
          }
          if (parambv.field_status < 2) {}
          for (;;)
          {
            b(paramString, bool1);
            break;
            bool1 = false;
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(37186);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37186);
        return false;
      }
      paramMenuItem = parama.Kkd.getContext();
      if (com.tencent.mm.ui.chatting.k.bc(parambv))
      {
        h.a(paramMenuItem, paramMenuItem.getString(2131759586), "", paramMenuItem.getString(2131766205), null);
        AppMethodBeat.o(37186);
        return false;
      }
      if (com.tencent.mm.ui.chatting.k.bd(parambv))
      {
        h.a(paramMenuItem, paramMenuItem.getString(2131759587), "", paramMenuItem.getString(2131766205), null);
        AppMethodBeat.o(37186);
        return false;
      }
      paramMenuItem = new Intent(parama.Kkd.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.model.bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 8);
      paramMenuItem.putExtra("Retr_Msg_Id", parambv.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37186);
      return false;
    }
    
    public final boolean a(l paraml, View paramView, bv parambv)
    {
      AppMethodBeat.i(187822);
      int j = ((bk)paramView.getTag()).position;
      bc.aCg();
      bv.a locala = com.tencent.mm.model.c.azI().arp(parambv.field_content);
      if ((locala.cUA == null) || (locala.cUA.length() <= 0)) {
        ae.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
      }
      this.KzW = locala.cUA;
      boolean bool = x.oq(locala.Ecg);
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFU, 0) == 1) {}
      for (int i = 1;; i = 0)
      {
        if (((i != 0) && (parambv.getType() != 66) && (!an.aUq(this.JWz.getTalkerUserName())) && (!an.aUr(this.JWz.getTalkerUserName()))) || (bool)) {
          paraml.a(j, 118, paramView.getContext().getString(2131762559), 2131690478);
        }
        if ((!parambv.fta()) && ((parambv.field_status == 2) || (parambv.fmr == 1)) && (parambv.fvE()) && (b(parambv, this.JWz)) && (aYa(parambv.field_talker))) {
          paraml.a(j, 123, paramView.getContext().getString(2131757234), 2131690462);
        }
        if (!this.JWz.fJD()) {
          paraml.a(j, 100, paramView.getContext().getString(2131757221), 2131690384);
        }
        AppMethodBeat.o(187822);
        return true;
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(37187);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).aaK(parambv.field_talker);
      paramView = (bk)paramView.getTag();
      String str1 = paramView.userName;
      String str2 = parambv.field_content;
      boolean bool2 = paramView.JSi;
      if (parambv.field_isSend == 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ag.a(parama, str1, str2, bool2, bool1, parambv);
        AppMethodBeat.o(37187);
        return true;
      }
    }
    
    public final boolean br(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 42) || (paramInt == 66));
    }
    
    public final boolean fLz()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ag
 * JD-Core Version:    0.7.0.1
 */