package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.e;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.e.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.Map;

public final class af
{
  public static void a(com.tencent.mm.ui.chatting.d.a parama, String paramString, bo.a parama1, a parama2)
  {
    AppMethodBeat.i(37189);
    if (!com.tencent.mm.storage.ai.aNc(paramString))
    {
      AppMethodBeat.o(37189);
      return;
    }
    String str = parama1.GZb;
    str = ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).a(str, "openim_card_type_name", com.tencent.mm.openim.a.b.a.inW);
    if (TextUtils.isEmpty(str))
    {
      parama2.Ilj.setText(2131757260);
      parama2.Ili.setBackgroundResource(2131231875);
      c.z(parama2.Ili, paramString);
      str = parama1.GZd;
      paramString = parama1.GZc;
      if (ae.isNullOrNil(str)) {
        break label171;
      }
    }
    label171:
    for (parama = ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).a(parama.HZF.getContext(), str, paramString, parama2.Ilk.getTextSize());; parama = paramString)
    {
      if (TextUtils.isEmpty(parama)) {
        break label176;
      }
      parama2.Ilk.setVisibility(0);
      parama2.Ilk.setText(parama);
      AppMethodBeat.o(37189);
      return;
      parama2.Ilj.setText(str);
      break;
    }
    label176:
    parama2.Ilk.setVisibility(8);
    AppMethodBeat.o(37189);
  }
  
  public static void a(com.tencent.mm.ui.chatting.d.a parama, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, bo parambo)
  {
    AppMethodBeat.i(37190);
    Object localObject = paramString2;
    if (paramBoolean1)
    {
      localObject = paramString2;
      if (paramBoolean2) {
        localObject = bi.ym(paramString2);
      }
    }
    az.ayM();
    localObject = com.tencent.mm.model.c.awD().alw((String)localObject);
    if (localObject == null)
    {
      AppMethodBeat.o(37190);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", ((bo.a)localObject).zTO);
    localIntent.putExtra("Contact_Alias", ((bo.a)localObject).eNf);
    localIntent.putExtra("Contact_Nick", ((bo.a)localObject).nickname);
    localIntent.putExtra("Contact_QuanPin", ((bo.a)localObject).iLM);
    localIntent.putExtra("Contact_PyInitial", ((bo.a)localObject).iLL);
    localIntent.putExtra("Contact_Uin", ((bo.a)localObject).vLk);
    localIntent.putExtra("Contact_Mobile_MD5", ((bo.a)localObject).GYX);
    localIntent.putExtra("Contact_full_Mobile_MD5", ((bo.a)localObject).GYY);
    localIntent.putExtra("Contact_QQNick", ((bo.a)localObject).fcl());
    localIntent.putExtra("User_From_Fmessage", false);
    localIntent.putExtra("Contact_Scene", ((bo.a)localObject).scene);
    localIntent.putExtra("Contact_FMessageCard", true);
    localIntent.putExtra("Contact_RemarkName", ((bo.a)localObject).iLQ);
    localIntent.putExtra("Contact_VUser_Info_Flag", ((bo.a)localObject).Chb);
    localIntent.putExtra("Contact_VUser_Info", ((bo.a)localObject).eya);
    localIntent.putExtra("Contact_BrandIconURL", ((bo.a)localObject).vIX);
    localIntent.putExtra("Contact_Province", ((bo.a)localObject).getProvince());
    localIntent.putExtra("Contact_City", ((bo.a)localObject).getCity());
    localIntent.putExtra("Contact_Sex", ((bo.a)localObject).exL);
    localIntent.putExtra("Contact_Signature", ((bo.a)localObject).signature);
    localIntent.putExtra("Contact_ShowUserName", true);
    localIntent.putExtra("Contact_KSnsIFlag", 0);
    localIntent.putExtra("Contact_Source_FMessage", 17);
    localIntent.putExtra("source_from_user_name", paramString1);
    localIntent.putExtra("source_from_nick_name", v.wj(paramString1));
    localIntent.putExtra(e.c.HgZ, ((bo.a)localObject).DAE);
    localIntent.putExtra("key_add_contact_openim_appid", ((bo.a)localObject).GZb);
    localIntent.putExtra("key_add_contact_custom_detail", ((bo.a)localObject).GZe);
    localIntent.putExtra("key_forward_flag", parambo.fbS());
    localIntent.putExtra("key_msg_id", parambo.field_msgId);
    if ((((bo.a)localObject).Chb & 0x8) > 0)
    {
      if (!ae.isNullOrNil(paramString1))
      {
        az.ayM();
        if (com.tencent.mm.model.c.awB().aNt(paramString1).fad()) {}
      }
      else
      {
        localIntent.putExtra("Contact_Scene", 17);
        com.tencent.mm.plugin.report.service.h.wUl.kvStat(10298, ((bo.a)localObject).zTO + ",17");
      }
    }
    else
    {
      if ((com.tencent.mm.storage.ai.aNc(((bo.a)localObject).zTO)) && (((bo.a)localObject).scene == 0)) {
        localIntent.putExtra("Contact_Scene", 17);
      }
      if (w.nN(((bo.a)localObject).Chb))
      {
        if (!parama.foQ()) {
          break label723;
        }
        localIntent.putExtra("preChatTYPE", 2);
      }
    }
    for (;;)
    {
      localIntent.putExtra("prePublishId", "msg_" + parambo.field_msgSvrId);
      paramString2 = paramString1;
      if (ae.isNullOrNil(paramString1)) {
        paramString2 = u.axw();
      }
      localIntent.putExtra("preUsername", paramString2);
      localIntent.putExtra("preChatName", parambo.field_talker);
      com.tencent.mm.br.d.b(parama.HZF.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
      com.tencent.mm.bs.a.XC(((bo.a)localObject).scene);
      AppMethodBeat.o(37190);
      return;
      localIntent.putExtra("Contact_Scene", 41);
      com.tencent.mm.plugin.report.service.h.wUl.kvStat(10298, ((bo.a)localObject).zTO + ",41");
      break;
      label723:
      localIntent.putExtra("preChatTYPE", 1);
    }
  }
  
  static final class a
    extends c.a
  {
    public int IjS;
    ImageView Ijf;
    ImageView Ili;
    TextView Ilj;
    TextView Ilk;
    TextView fuZ;
    
    public final c.a z(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(37176);
      super.fX(paramView);
      this.Ili = ((ImageView)paramView.findViewById(2131298057));
      this.fAz = ((TextView)paramView.findViewById(2131298178));
      this.Ilj = ((TextView)paramView.findViewById(2131298182));
      this.Ilk = ((TextView)paramView.findViewById(2131298186));
      this.fuZ = ((TextView)paramView.findViewById(2131298152));
      this.xpH = ((TextView)paramView.findViewById(2131298185));
      this.nDl = paramView.findViewById(2131298069);
      this.ijt = ((CheckBox)paramView.findViewById(2131298068));
      this.gGk = paramView.findViewById(2131298147);
      if (!paramBoolean)
      {
        this.IhW = ((ImageView)paramView.findViewById(2131298174));
        this.Ijf = ((ImageView)paramView.findViewById(2131298176));
        this.vYf = ((ProgressBar)paramView.findViewById(2131306220));
      }
      this.IjS = c.kb(com.tencent.mm.sdk.platformtools.ai.getContext());
      AppMethodBeat.o(37176);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a HNS;
    private String Inf;
    private String Ing;
    
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
        localObject = new ag(paramLayoutInflater, 2131493450);
        ((View)localObject).setTag(new af.a().z((View)localObject, true));
      }
      AppMethodBeat.o(37177);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
    {
      AppMethodBeat.i(37179);
      this.HNS = parama1;
      af.a locala = (af.a)parama;
      bo.a locala1;
      if (parama1.foQ())
      {
        parama = bi.ym(parambo.field_content);
        az.ayM();
        locala1 = com.tencent.mm.model.c.awD().alw(parama);
        if ((locala1.zTO == null) || (locala1.zTO.length() <= 0)) {
          ac.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
        }
        this.Inf = locala1.zTO;
        this.Ing = "";
        if (!ae.isNullOrNil(parama))
        {
          parama = bv.L(parama, "msg");
          if (parama == null) {
            ac.e("MicroMsg.ChattingItemCardFrom", "null==attrs");
          }
          if ((parama != null) && (parama.containsKey(".msg.$wechatid"))) {
            this.Ing = ((String)parama.get(".msg.$wechatid"));
          }
        }
        com.tencent.mm.aj.c.ag(this.Inf, locala1.GYW);
        af.a.aG(locala.nDl, locala.IjS);
        if (!w.nN(locala1.Chb)) {
          break label451;
        }
        locala.Ilj.setText(2131757135);
        locala.Ilk.setVisibility(8);
        if (!com.tencent.mm.compatible.util.d.kZ(16)) {
          break label439;
        }
        locala.Ili.setBackground(null);
        label217:
        A(locala.Ili, this.Inf);
        label229:
        parama = this.Ing;
        if ((!ae.isNullOrNil(parama)) && (!com.tencent.mm.storage.ai.aNf(parama)) && (!w.wF(parama))) {
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
        boolean bool = w.nN(locala1.Chb);
        if ((i != 0) || (bool))
        {
          parama = "";
          if (ae.isNullOrNil(parama)) {
            break label491;
          }
          locala.Ilk.setVisibility(0);
          locala.Ilk.setText(parama);
        }
        for (;;)
        {
          locala.fuZ.setText(k.b(parama1.HZF.getContext(), locala1.nickname, (int)locala.fuZ.getTextSize()));
          af.a(parama1, this.Inf, locala1, locala);
          locala.nDl.setTag(new bj(parambo, parama1.foQ(), paramInt, paramString, '\000'));
          locala.nDl.setOnClickListener(d(parama1));
          locala.nDl.setOnLongClickListener(c(parama1));
          locala.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
          AppMethodBeat.o(37179);
          return;
          parama = parambo.field_content;
          break;
          locala.Ili.setBackgroundDrawable(null);
          break label217;
          locala.Ilj.setText(2131757260);
          locala.Ili.setBackgroundResource(2131231875);
          z(locala.Ili, this.Inf);
          break label229;
          break label281;
          locala.Ilk.setVisibility(8);
        }
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
    {
      AppMethodBeat.i(37180);
      int j = ((bj)paramView.getTag()).position;
      az.ayM();
      bo.a locala = com.tencent.mm.model.c.awD().alw(parambo.field_content);
      if ((locala.zTO == null) || (locala.zTO.length() <= 0)) {
        ac.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
      }
      this.Inf = locala.zTO;
      boolean bool = w.nN(locala.Chb);
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pUi, 0) == 1) {}
      for (int i = 1;; i = 0)
      {
        if (((i != 0) && (parambo.getType() != 66) && (!com.tencent.mm.storage.ai.aNc(this.HNS.getTalkerUserName())) && (!com.tencent.mm.storage.ai.aNd(this.HNS.getTalkerUserName()))) || (bool)) {
          paramContextMenu.add(j, 118, 0, paramView.getContext().getString(2131762559));
        }
        if (!this.HNS.foR()) {
          paramContextMenu.add(j, 100, 0, paramView.getContext().getString(2131757221));
        }
        AppMethodBeat.o(37180);
        return true;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(37181);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37181);
        return false;
      }
      paramMenuItem = parama.HZF.getContext();
      if (j.ba(parambo))
      {
        com.tencent.mm.ui.base.h.a(paramMenuItem, paramMenuItem.getString(2131759586), "", paramMenuItem.getString(2131766205), null);
        AppMethodBeat.o(37181);
        return false;
      }
      if (j.bb(parambo))
      {
        com.tencent.mm.ui.base.h.a(paramMenuItem, paramMenuItem.getString(2131759587), "", paramMenuItem.getString(2131766205), null);
        AppMethodBeat.o(37181);
        return false;
      }
      paramMenuItem = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 8);
      paramMenuItem.putExtra("Retr_Msg_Id", parambo.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37181);
      return false;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(37182);
      ((com.tencent.mm.plugin.comm.a.b)g.ab(com.tencent.mm.plugin.comm.a.b.class)).Wm(parambo.field_talker);
      paramView = (bj)paramView.getTag();
      String str1 = paramView.userName;
      String str2 = parambo.field_content;
      boolean bool2 = paramView.HJB;
      if (parambo.field_isSend == 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        af.a(parama, str1, str2, bool2, bool1, parambo);
        AppMethodBeat.o(37182);
        return true;
      }
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(37178);
      boolean bool = parama.foQ();
      AppMethodBeat.o(37178);
      return bool;
    }
    
    public final boolean bb(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 42) || (paramInt == 66));
    }
    
    public final boolean fqu()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
    implements s.n
  {
    private com.tencent.mm.ui.chatting.d.a HNS;
    private String Inf;
    
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
        localObject = new ag(paramLayoutInflater, 2131493494);
        ((View)localObject).setTag(new af.a().z((View)localObject, false));
      }
      AppMethodBeat.o(37183);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(37188);
      parambo.fbV();
      az.ayM();
      com.tencent.mm.model.c.awD().a(parambo.field_msgId, parambo);
      ((e)parama.bf(e.class)).bz(parambo);
      AppMethodBeat.o(37188);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
    {
      boolean bool1 = true;
      AppMethodBeat.i(37184);
      this.HNS = parama1;
      paramString = (af.a)parama;
      az.ayM();
      bo.a locala = com.tencent.mm.model.c.awD().alw(parambo.field_content);
      if ((locala.zTO == null) || (locala.zTO.length() <= 0)) {
        ac.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
      }
      this.Inf = locala.zTO;
      ac.d("MicroMsg.ChattingItemCardTo", "dancy is biz: %s, userName: %s ", new Object[] { Boolean.valueOf(w.wH(this.Inf)), this.Inf });
      af.a.aG(paramString.nDl, paramString.IjS);
      if (w.nN(locala.Chb))
      {
        paramString.Ilj.setText(2131757135);
        paramString.Ilk.setVisibility(8);
        if (com.tencent.mm.compatible.util.d.kZ(16))
        {
          paramString.Ili.setBackground(null);
          A(paramString.Ili, this.Inf);
          label177:
          paramString.fuZ.setText(k.b(parama1.HZF.getContext(), locala.nickname, paramString.fuZ.getTextSize()));
          parama = locala.eNf;
          if (!ae.isNullOrNil(this.Inf))
          {
            az.ayM();
            com.tencent.mm.storage.ai localai = com.tencent.mm.model.c.awB().aNt(this.Inf);
            if ((localai != null) && (com.tencent.mm.n.b.ln(localai.field_type))) {
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
        if ((i == 0) && (ae.isNullOrNil(parama)))
        {
          parama = this.Inf;
          if ((ae.isNullOrNil(parama)) || (com.tencent.mm.storage.ai.aNf(parama)) || (w.wF(parama))) {
            i = 1;
          }
        }
        for (;;)
        {
          boolean bool2 = w.nN(locala.Chb);
          if ((i != 0) || (bool2)) {
            parama = "";
          }
          if (!ae.isNullOrNil(parama))
          {
            paramString.Ilk.setVisibility(0);
            paramString.Ilk.setText(parama);
            af.a(parama1, this.Inf, locala, paramString);
            paramString.nDl.setTag(new bj(parambo, parama1.foQ(), paramInt, null, '\000'));
            paramString.nDl.setOnClickListener(d(parama1));
            paramString.nDl.setOnLongClickListener(c(parama1));
            paramString.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
            if (!fqw()) {
              break label610;
            }
            b(paramString, false);
            if ((parambo.field_status != 2) || (!a((i)parama1.bf(i.class), parambo.field_msgId))) {
              break label589;
            }
            if (paramString.Ijf != null) {
              paramString.Ijf.setVisibility(0);
            }
          }
          for (;;)
          {
            a(paramInt, paramString, parambo, parama1.foM(), parama1.foQ(), parama1, this);
            AppMethodBeat.o(37184);
            return;
            paramString.Ili.setBackgroundDrawable(null);
            break;
            paramString.Ilj.setText(2131757260);
            paramString.Ili.setBackgroundResource(2131231875);
            z(paramString.Ili, this.Inf);
            break label177;
            i = 0;
            break label302;
            paramString.Ilk.setVisibility(8);
            break label351;
            if (paramString.Ijf != null) {
              paramString.Ijf.setVisibility(8);
            }
          }
          if (parambo.field_status < 2) {}
          for (;;)
          {
            b(paramString, bool1);
            break;
            bool1 = false;
          }
        }
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
    {
      AppMethodBeat.i(37185);
      int j = ((bj)paramView.getTag()).position;
      az.ayM();
      bo.a locala = com.tencent.mm.model.c.awD().alw(parambo.field_content);
      if ((locala.zTO == null) || (locala.zTO.length() <= 0)) {
        ac.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
      }
      this.Inf = locala.zTO;
      boolean bool = w.nN(locala.Chb);
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pUi, 0) == 1) {}
      for (int i = 1;; i = 0)
      {
        if (((i != 0) && (parambo.getType() != 66) && (!com.tencent.mm.storage.ai.aNc(this.HNS.getTalkerUserName())) && (!com.tencent.mm.storage.ai.aNd(this.HNS.getTalkerUserName()))) || (bool)) {
          paramContextMenu.add(j, 118, 0, paramView.getContext().getString(2131762559));
        }
        if ((!parambo.eZj()) && ((parambo.field_status == 2) || (parambo.eSf == 1)) && (parambo.fbB()) && (b(parambo, this.HNS)) && (aQE(parambo.field_talker))) {
          paramContextMenu.add(j, 123, 0, paramView.getContext().getString(2131757234));
        }
        if (!this.HNS.foR()) {
          paramContextMenu.add(j, 100, 0, paramView.getContext().getString(2131757221));
        }
        AppMethodBeat.o(37185);
        return true;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(37186);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37186);
        return false;
      }
      paramMenuItem = parama.HZF.getContext();
      if (j.ba(parambo))
      {
        com.tencent.mm.ui.base.h.a(paramMenuItem, paramMenuItem.getString(2131759586), "", paramMenuItem.getString(2131766205), null);
        AppMethodBeat.o(37186);
        return false;
      }
      if (j.bb(parambo))
      {
        com.tencent.mm.ui.base.h.a(paramMenuItem, paramMenuItem.getString(2131759587), "", paramMenuItem.getString(2131766205), null);
        AppMethodBeat.o(37186);
        return false;
      }
      paramMenuItem = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", bi.b(parama.foQ(), parambo.field_content, parambo.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 8);
      paramMenuItem.putExtra("Retr_Msg_Id", parambo.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37186);
      return false;
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(37187);
      ((com.tencent.mm.plugin.comm.a.b)g.ab(com.tencent.mm.plugin.comm.a.b.class)).Wm(parambo.field_talker);
      paramView = (bj)paramView.getTag();
      String str1 = paramView.userName;
      String str2 = parambo.field_content;
      boolean bool2 = paramView.HJB;
      if (parambo.field_isSend == 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        af.a(parama, str1, str2, bool2, bool1, parambo);
        AppMethodBeat.o(37187);
        return true;
      }
    }
    
    public final boolean bb(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 42) || (paramInt == 66));
    }
    
    public final boolean fqu()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.af
 * JD-Core Version:    0.7.0.1
 */