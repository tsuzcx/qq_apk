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
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.e;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.e.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.Map;

public final class ag
{
  public static void a(com.tencent.mm.ui.chatting.e.a parama, String paramString, bu.a parama1, a parama2)
  {
    AppMethodBeat.i(37189);
    if (!am.aSQ(paramString))
    {
      AppMethodBeat.o(37189);
      return;
    }
    String str = parama1.IMq;
    str = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).a(str, "openim_card_type_name", com.tencent.mm.openim.a.b.a.iHt);
    if (TextUtils.isEmpty(str))
    {
      parama2.KbH.setText(2131757260);
      parama2.KbG.setBackgroundResource(2131231875);
      c.z(parama2.KbG, paramString);
      str = parama1.IMs;
      paramString = parama1.IMr;
      if (af.isNullOrNil(str)) {
        break label171;
      }
    }
    label171:
    for (parama = ((com.tencent.mm.openim.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.openim.a.b.class)).a(parama.JOR.getContext(), str, paramString, parama2.KbI.getTextSize());; parama = paramString)
    {
      if (TextUtils.isEmpty(parama)) {
        break label176;
      }
      parama2.KbI.setVisibility(0);
      parama2.KbI.setText(parama);
      AppMethodBeat.o(37189);
      return;
      parama2.KbH.setText(str);
      break;
    }
    label176:
    parama2.KbI.setVisibility(8);
    AppMethodBeat.o(37189);
  }
  
  public static void a(com.tencent.mm.ui.chatting.e.a parama, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, bu parambu)
  {
    AppMethodBeat.i(37190);
    String str = paramString2;
    if (paramBoolean1)
    {
      str = paramString2;
      if (paramBoolean2) {
        str = bj.Bl(paramString2);
      }
    }
    ba.aBQ();
    bu.a locala = com.tencent.mm.model.c.azs().aqk(str);
    if (locala == null)
    {
      AppMethodBeat.o(37190);
      return;
    }
    Intent localIntent = new Intent();
    paramBoolean1 = w.on(locala.DKi);
    str = locala.dHm;
    paramString2 = str;
    if (!paramBoolean1)
    {
      com.tencent.mm.plugin.report.service.g.yhR.dD(1430, 0);
      ba.aBQ();
      paramString2 = com.tencent.mm.model.c.azp().Bf(str);
      if ((paramString2 != null) && (com.tencent.mm.o.b.lM(paramString2.field_type)))
      {
        paramString2 = paramString2.field_username;
        com.tencent.mm.plugin.report.service.g.yhR.dD(1430, 1);
      }
    }
    else
    {
      localIntent.putExtra("Contact_User", paramString2);
      localIntent.putExtra("Contact_Alias", locala.ffB);
      localIntent.putExtra("Contact_Nick", locala.nickname);
      localIntent.putExtra("Contact_QuanPin", locala.jeV);
      localIntent.putExtra("Contact_PyInitial", locala.jeU);
      localIntent.putExtra("Contact_Uin", locala.wSt);
      localIntent.putExtra("Contact_Mobile_MD5", locala.IMm);
      localIntent.putExtra("Contact_full_Mobile_MD5", locala.IMn);
      localIntent.putExtra("Contact_QQNick", locala.fss());
      localIntent.putExtra("User_From_Fmessage", false);
      localIntent.putExtra("Contact_Scene", locala.scene);
      localIntent.putExtra("Contact_FMessageCard", true);
      localIntent.putExtra("Contact_RemarkName", locala.jeZ);
      localIntent.putExtra("Contact_VUser_Info_Flag", locala.DKi);
      localIntent.putExtra("Contact_VUser_Info", locala.ePz);
      localIntent.putExtra("Contact_BrandIconURL", locala.wQe);
      localIntent.putExtra("Contact_Province", locala.getProvince());
      localIntent.putExtra("Contact_City", locala.getCity());
      localIntent.putExtra("Contact_Sex", locala.ePk);
      localIntent.putExtra("Contact_Signature", locala.signature);
      localIntent.putExtra("Contact_ShowUserName", true);
      localIntent.putExtra("Contact_KSnsIFlag", 0);
      localIntent.putExtra("Contact_Source_FMessage", 17);
      localIntent.putExtra("source_from_user_name", paramString1);
      localIntent.putExtra("source_from_nick_name", v.ze(paramString1));
      localIntent.putExtra(e.c.IUp, locala.FfL);
      localIntent.putExtra("key_add_contact_openim_appid", locala.IMq);
      localIntent.putExtra("key_add_contact_custom_detail", locala.IMt);
      localIntent.putExtra("key_forward_flag", parambu.frV());
      localIntent.putExtra("key_msg_id", parambu.field_msgId);
      if ((locala.DKi & 0x8) > 0)
      {
        if (!af.isNullOrNil(paramString1))
        {
          ba.aBQ();
          if (com.tencent.mm.model.c.azp().Bf(paramString1).fqg()) {
            break label898;
          }
        }
        localIntent.putExtra("Contact_Scene", 17);
        com.tencent.mm.plugin.report.service.g.yhR.kvStat(10298, locala.dHm + ",17");
      }
      label603:
      if ((am.aSQ(locala.dHm)) && (locala.scene == 0)) {
        localIntent.putExtra("Contact_Scene", 17);
      }
      if (w.on(locala.DKi))
      {
        if (!parama.fFv()) {
          break label945;
        }
        localIntent.putExtra("preChatTYPE", 2);
      }
    }
    for (;;)
    {
      localIntent.putExtra("prePublishId", "msg_" + parambu.field_msgSvrId);
      paramString2 = paramString1;
      if (af.isNullOrNil(paramString1)) {
        paramString2 = u.aAm();
      }
      localIntent.putExtra("preUsername", paramString2);
      localIntent.putExtra("preChatName", parambu.field_talker);
      com.tencent.mm.bs.d.b(parama.JOR.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
      com.tencent.mm.bt.a.Zy(locala.scene);
      AppMethodBeat.o(37190);
      return;
      ba.aBQ();
      paramString2 = com.tencent.mm.model.c.azr().apO(str);
      if ((paramString2 != null) && (!af.isNullOrNil(paramString2.field_username)))
      {
        paramString2 = paramString2.field_username;
        com.tencent.mm.plugin.report.service.g.yhR.dD(1430, 2);
        break;
      }
      if ((paramString2 == null) || (af.isNullOrNil(paramString2.field_encryptUsername)))
      {
        paramString2 = new com.tencent.mm.storage.bk(str);
        paramString2.field_modifyTime = System.currentTimeMillis();
        ba.aBQ();
        if (!com.tencent.mm.model.c.azr().replace(paramString2)) {
          ad.e("MicroMsg.ChattingItemCardTo", "add friendUser fail, encryptUsername:%s", new Object[] { str });
        }
      }
      localIntent.putExtra("force_get_contact", true);
      com.tencent.mm.plugin.report.service.g.yhR.dD(1430, 3);
      paramString2 = str;
      break;
      label898:
      localIntent.putExtra("Contact_Scene", 41);
      com.tencent.mm.plugin.report.service.g.yhR.kvStat(10298, locala.dHm + ",41");
      break label603;
      label945:
      localIntent.putExtra("preChatTYPE", 1);
    }
  }
  
  static final class a
    extends c.a
  {
    ImageView JZD;
    public int Kaq;
    ImageView KbG;
    TextView KbH;
    TextView KbI;
    TextView fOg;
    
    public final c.a z(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(37176);
      super.gn(paramView);
      this.KbG = ((ImageView)paramView.findViewById(2131298057));
      this.fTP = ((TextView)paramView.findViewById(2131298178));
      this.KbH = ((TextView)paramView.findViewById(2131298182));
      this.KbI = ((TextView)paramView.findViewById(2131298186));
      this.fOg = ((TextView)paramView.findViewById(2131298152));
      this.yEk = ((TextView)paramView.findViewById(2131298185));
      this.ofK = paramView.findViewById(2131298069);
      this.iCK = ((CheckBox)paramView.findViewById(2131298068));
      this.gZU = paramView.findViewById(2131298147);
      if (!paramBoolean)
      {
        this.JYs = ((ImageView)paramView.findViewById(2131298174));
        this.JZD = ((ImageView)paramView.findViewById(2131298176));
        this.xfR = ((ProgressBar)paramView.findViewById(2131306220));
      }
      this.Kaq = c.kn(aj.getContext());
      AppMethodBeat.o(37176);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JBI;
    private String KdD;
    private String KdE;
    
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
        ((View)localObject).setTag(new ag.a().z((View)localObject, true));
      }
      AppMethodBeat.o(37177);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
    {
      AppMethodBeat.i(37179);
      this.JBI = parama1;
      ag.a locala = (ag.a)parama;
      bu.a locala1;
      if (parama1.fFv())
      {
        parama = bj.Bl(parambu.field_content);
        ba.aBQ();
        locala1 = com.tencent.mm.model.c.azs().aqk(parama);
        if ((locala1.dHm == null) || (locala1.dHm.length() <= 0)) {
          ad.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
        }
        this.KdD = locala1.dHm;
        this.KdE = "";
        if (!af.isNullOrNil(parama))
        {
          parama = bw.M(parama, "msg");
          if (parama == null) {
            ad.e("MicroMsg.ChattingItemCardFrom", "null==attrs");
          }
          if ((parama != null) && (parama.containsKey(".msg.$wechatid"))) {
            this.KdE = ((String)parama.get(".msg.$wechatid"));
          }
        }
        com.tencent.mm.ak.c.ak(this.KdD, locala1.IMl);
        ag.a.aI(locala.ofK, locala.Kaq);
        if (!w.on(locala1.DKi)) {
          break label451;
        }
        locala.KbH.setText(2131757135);
        locala.KbI.setVisibility(8);
        if (!com.tencent.mm.compatible.util.d.ly(16)) {
          break label439;
        }
        locala.KbG.setBackground(null);
        label217:
        A(locala.KbG, this.KdD);
        label229:
        parama = this.KdE;
        if ((!af.isNullOrNil(parama)) && (!am.aSX(parama)) && (!w.zC(parama))) {
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
        boolean bool = w.on(locala1.DKi);
        if ((i != 0) || (bool))
        {
          parama = "";
          if (af.isNullOrNil(parama)) {
            break label491;
          }
          locala.KbI.setVisibility(0);
          locala.KbI.setText(parama);
        }
        for (;;)
        {
          locala.fOg.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.JOR.getContext(), locala1.nickname, (int)locala.fOg.getTextSize()));
          ag.a(parama1, this.KdD, locala1, locala);
          locala.ofK.setTag(new bk(parambu, parama1.fFv(), paramInt, paramString, '\000'));
          locala.ofK.setOnClickListener(d(parama1));
          locala.ofK.setOnLongClickListener(c(parama1));
          locala.ofK.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
          AppMethodBeat.o(37179);
          return;
          parama = parambu.field_content;
          break;
          locala.KbG.setBackgroundDrawable(null);
          break label217;
          locala.KbH.setText(2131757260);
          locala.KbG.setBackgroundResource(2131231875);
          z(locala.KbG, this.KdD);
          break label229;
          break label281;
          locala.KbI.setVisibility(8);
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(37181);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37181);
        return false;
      }
      paramMenuItem = parama.JOR.getContext();
      if (j.bd(parambu))
      {
        h.a(paramMenuItem, paramMenuItem.getString(2131759586), "", paramMenuItem.getString(2131766205), null);
        AppMethodBeat.o(37181);
        return false;
      }
      if (j.be(parambu))
      {
        h.a(paramMenuItem, paramMenuItem.getString(2131759587), "", paramMenuItem.getString(2131766205), null);
        AppMethodBeat.o(37181);
        return false;
      }
      paramMenuItem = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 8);
      paramMenuItem.putExtra("Retr_Msg_Id", parambu.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37181);
      return false;
    }
    
    public final boolean a(l paraml, View paramView, bu parambu)
    {
      AppMethodBeat.i(194426);
      int j = ((bk)paramView.getTag()).position;
      ba.aBQ();
      bu.a locala = com.tencent.mm.model.c.azs().aqk(parambu.field_content);
      if ((locala.dHm == null) || (locala.dHm.length() <= 0)) {
        ad.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
      }
      this.KdD = locala.dHm;
      boolean bool = w.on(locala.DKi);
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qyO, 0) == 1) {}
      for (int i = 1;; i = 0)
      {
        if (((i != 0) && (parambu.getType() != 66) && (!am.aSQ(this.JBI.getTalkerUserName())) && (!am.aSR(this.JBI.getTalkerUserName()))) || (bool)) {
          paraml.a(j, 118, paramView.getContext().getString(2131762559), 2131690478);
        }
        if (!this.JBI.fFw()) {
          paraml.a(j, 100, paramView.getContext().getString(2131757221), 2131690384);
        }
        AppMethodBeat.o(194426);
        return true;
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(37182);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ZT(parambu.field_talker);
      paramView = (bk)paramView.getTag();
      String str1 = paramView.userName;
      String str2 = parambu.field_content;
      boolean bool2 = paramView.Jxs;
      if (parambu.field_isSend == 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ag.a(parama, str1, str2, bool2, bool1, parambu);
        AppMethodBeat.o(37182);
        return true;
      }
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(37178);
      boolean bool = parama.fFv();
      AppMethodBeat.o(37178);
      return bool;
    }
    
    public final boolean bi(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 42) || (paramInt == 66));
    }
    
    public final boolean fHh()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
    implements s.n
  {
    private com.tencent.mm.ui.chatting.e.a JBI;
    private String KdD;
    
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
        ((View)localObject).setTag(new ag.a().z((View)localObject, false));
      }
      AppMethodBeat.o(37183);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(37188);
      parambu.frY();
      ba.aBQ();
      com.tencent.mm.model.c.azs().a(parambu.field_msgId, parambu);
      ((e)parama.bh(e.class)).bF(parambu);
      AppMethodBeat.o(37188);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
    {
      boolean bool1 = true;
      AppMethodBeat.i(37184);
      this.JBI = parama1;
      paramString = (ag.a)parama;
      ba.aBQ();
      bu.a locala = com.tencent.mm.model.c.azs().aqk(parambu.field_content);
      if ((locala.dHm == null) || (locala.dHm.length() <= 0)) {
        ad.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
      }
      this.KdD = locala.dHm;
      ad.d("MicroMsg.ChattingItemCardTo", "dancy is biz: %s, userName: %s ", new Object[] { Boolean.valueOf(w.zE(this.KdD)), this.KdD });
      ag.a.aI(paramString.ofK, paramString.Kaq);
      if (w.on(locala.DKi))
      {
        paramString.KbH.setText(2131757135);
        paramString.KbI.setVisibility(8);
        if (com.tencent.mm.compatible.util.d.ly(16))
        {
          paramString.KbG.setBackground(null);
          A(paramString.KbG, this.KdD);
          label177:
          paramString.fOg.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.JOR.getContext(), locala.nickname, paramString.fOg.getTextSize()));
          parama = locala.ffB;
          if (!af.isNullOrNil(this.KdD))
          {
            ba.aBQ();
            am localam = com.tencent.mm.model.c.azp().Bf(this.KdD);
            if ((localam != null) && (com.tencent.mm.o.b.lM(localam.field_type))) {
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
          parama = this.KdD;
          if ((af.isNullOrNil(parama)) || (am.aSX(parama)) || (w.zC(parama))) {
            i = 1;
          }
        }
        for (;;)
        {
          boolean bool2 = w.on(locala.DKi);
          if ((i != 0) || (bool2)) {
            parama = "";
          }
          if (!af.isNullOrNil(parama))
          {
            paramString.KbI.setVisibility(0);
            paramString.KbI.setText(parama);
            ag.a(parama1, this.KdD, locala, paramString);
            paramString.ofK.setTag(new bk(parambu, parama1.fFv(), paramInt, null, '\000'));
            paramString.ofK.setOnClickListener(d(parama1));
            paramString.ofK.setOnLongClickListener(c(parama1));
            paramString.ofK.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
            if (!fHj()) {
              break label610;
            }
            b(paramString, false);
            if ((parambu.field_status != 2) || (!b((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class), parambu.field_msgId))) {
              break label589;
            }
            if (paramString.JZD != null) {
              paramString.JZD.setVisibility(0);
            }
          }
          for (;;)
          {
            a(paramInt, paramString, parambu, parama1.fFr(), parama1.fFv(), parama1, this);
            AppMethodBeat.o(37184);
            return;
            paramString.KbG.setBackgroundDrawable(null);
            break;
            paramString.KbH.setText(2131757260);
            paramString.KbG.setBackgroundResource(2131231875);
            z(paramString.KbG, this.KdD);
            break label177;
            i = 0;
            break label302;
            paramString.KbI.setVisibility(8);
            break label351;
            if (paramString.JZD != null) {
              paramString.JZD.setVisibility(8);
            }
          }
          if (parambu.field_status < 2) {}
          for (;;)
          {
            b(paramString, bool1);
            break;
            bool1 = false;
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(37186);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37186);
        return false;
      }
      paramMenuItem = parama.JOR.getContext();
      if (j.bd(parambu))
      {
        h.a(paramMenuItem, paramMenuItem.getString(2131759586), "", paramMenuItem.getString(2131766205), null);
        AppMethodBeat.o(37186);
        return false;
      }
      if (j.be(parambu))
      {
        h.a(paramMenuItem, paramMenuItem.getString(2131759587), "", paramMenuItem.getString(2131766205), null);
        AppMethodBeat.o(37186);
        return false;
      }
      paramMenuItem = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", bj.b(parama.fFv(), parambu.field_content, parambu.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 8);
      paramMenuItem.putExtra("Retr_Msg_Id", parambu.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37186);
      return false;
    }
    
    public final boolean a(l paraml, View paramView, bu parambu)
    {
      AppMethodBeat.i(194427);
      int j = ((bk)paramView.getTag()).position;
      ba.aBQ();
      bu.a locala = com.tencent.mm.model.c.azs().aqk(parambu.field_content);
      if ((locala.dHm == null) || (locala.dHm.length() <= 0)) {
        ad.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
      }
      this.KdD = locala.dHm;
      boolean bool = w.on(locala.DKi);
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qyO, 0) == 1) {}
      for (int i = 1;; i = 0)
      {
        if (((i != 0) && (parambu.getType() != 66) && (!am.aSQ(this.JBI.getTalkerUserName())) && (!am.aSR(this.JBI.getTalkerUserName()))) || (bool)) {
          paraml.a(j, 118, paramView.getContext().getString(2131762559), 2131690478);
        }
        if ((!parambu.fpd()) && ((parambu.field_status == 2) || (parambu.fku == 1)) && (parambu.frE()) && (b(parambu, this.JBI)) && (aWy(parambu.field_talker))) {
          paraml.a(j, 123, paramView.getContext().getString(2131757234), 2131690462);
        }
        if (!this.JBI.fFw()) {
          paraml.a(j, 100, paramView.getContext().getString(2131757221), 2131690384);
        }
        AppMethodBeat.o(194427);
        return true;
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(37187);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ZT(parambu.field_talker);
      paramView = (bk)paramView.getTag();
      String str1 = paramView.userName;
      String str2 = parambu.field_content;
      boolean bool2 = paramView.Jxs;
      if (parambu.field_isSend == 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ag.a(parama, str1, str2, bool2, bool1, parambu);
        AppMethodBeat.o(37187);
        return true;
      }
    }
    
    public final boolean bi(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 42) || (paramInt == 66));
    }
    
    public final boolean fHh()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ag
 * JD-Core Version:    0.7.0.1
 */