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
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.e;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.j;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.e.c;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.Map;

public final class ae
{
  public static void a(com.tencent.mm.ui.chatting.d.a parama, String paramString, bl.a parama1, a parama2)
  {
    AppMethodBeat.i(37189);
    if (!com.tencent.mm.storage.af.aHH(paramString))
    {
      AppMethodBeat.o(37189);
      return;
    }
    String str = parama1.FzZ;
    str = ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).a(str, "openim_card_type_name", com.tencent.mm.openim.a.b.a.hNA);
    if (TextUtils.isEmpty(str))
    {
      parama2.GLm.setText(2131757260);
      parama2.GLl.setBackgroundResource(2131231875);
      c.z(parama2.GLl, paramString);
      str = parama1.FAb;
      paramString = parama1.FAa;
      if (com.tencent.mm.platformtools.ae.isNullOrNil(str)) {
        break label171;
      }
    }
    label171:
    for (parama = ((com.tencent.mm.openim.a.b)g.ab(com.tencent.mm.openim.a.b.class)).a(parama.GzJ.getContext(), str, paramString, parama2.GLn.getTextSize());; parama = paramString)
    {
      if (TextUtils.isEmpty(parama)) {
        break label176;
      }
      parama2.GLn.setVisibility(0);
      parama2.GLn.setText(parama);
      AppMethodBeat.o(37189);
      return;
      parama2.GLm.setText(str);
      break;
    }
    label176:
    parama2.GLn.setVisibility(8);
    AppMethodBeat.o(37189);
  }
  
  public static void a(com.tencent.mm.ui.chatting.d.a parama, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, bl parambl)
  {
    AppMethodBeat.i(37190);
    Object localObject = paramString2;
    if (paramBoolean1)
    {
      localObject = paramString2;
      if (paramBoolean2) {
        localObject = com.tencent.mm.model.bi.ug(paramString2);
      }
    }
    az.arV();
    localObject = com.tencent.mm.model.c.apO().agC((String)localObject);
    if (localObject == null)
    {
      AppMethodBeat.o(37190);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", ((bl.a)localObject).yGA);
    localIntent.putExtra("Contact_Alias", ((bl.a)localObject).eKn);
    localIntent.putExtra("Contact_Nick", ((bl.a)localObject).nickname);
    localIntent.putExtra("Contact_QuanPin", ((bl.a)localObject).ilF);
    localIntent.putExtra("Contact_PyInitial", ((bl.a)localObject).ilE);
    localIntent.putExtra("Contact_Uin", ((bl.a)localObject).uCr);
    localIntent.putExtra("Contact_Mobile_MD5", ((bl.a)localObject).FzV);
    localIntent.putExtra("Contact_full_Mobile_MD5", ((bl.a)localObject).FzW);
    localIntent.putExtra("Contact_QQNick", ((bl.a)localObject).eMG());
    localIntent.putExtra("User_From_Fmessage", false);
    localIntent.putExtra("Contact_Scene", ((bl.a)localObject).scene);
    localIntent.putExtra("Contact_FMessageCard", true);
    localIntent.putExtra("Contact_RemarkName", ((bl.a)localObject).ilJ);
    localIntent.putExtra("Contact_VUser_Info_Flag", ((bl.a)localObject).AOL);
    localIntent.putExtra("Contact_VUser_Info", ((bl.a)localObject).evE);
    localIntent.putExtra("Contact_BrandIconURL", ((bl.a)localObject).uAe);
    localIntent.putExtra("Contact_Province", ((bl.a)localObject).getProvince());
    localIntent.putExtra("Contact_City", ((bl.a)localObject).getCity());
    localIntent.putExtra("Contact_Sex", ((bl.a)localObject).evp);
    localIntent.putExtra("Contact_Signature", ((bl.a)localObject).signature);
    localIntent.putExtra("Contact_ShowUserName", true);
    localIntent.putExtra("Contact_KSnsIFlag", 0);
    localIntent.putExtra("Contact_Source_FMessage", 17);
    localIntent.putExtra("source_from_user_name", paramString1);
    localIntent.putExtra("source_from_nick_name", v.sg(paramString1));
    localIntent.putExtra(e.c.FHR, ((bl.a)localObject).Cin);
    localIntent.putExtra("key_add_contact_openim_appid", ((bl.a)localObject).FzZ);
    localIntent.putExtra("key_add_contact_custom_detail", ((bl.a)localObject).FAc);
    localIntent.putExtra("key_forward_flag", parambl.eMn());
    localIntent.putExtra("key_msg_id", parambl.field_msgId);
    if ((((bl.a)localObject).AOL & 0x8) > 0)
    {
      if (!com.tencent.mm.platformtools.ae.isNullOrNil(paramString1))
      {
        az.arV();
        if (com.tencent.mm.model.c.apM().aHY(paramString1).eKB()) {}
      }
      else
      {
        localIntent.putExtra("Contact_Scene", 17);
        com.tencent.mm.plugin.report.service.h.vKh.kvStat(10298, ((bl.a)localObject).yGA + ",17");
      }
    }
    else
    {
      if ((com.tencent.mm.storage.af.aHH(((bl.a)localObject).yGA)) && (((bl.a)localObject).scene == 0)) {
        localIntent.putExtra("Contact_Scene", 17);
      }
      if (w.mZ(((bl.a)localObject).AOL))
      {
        if (!parama.eZb()) {
          break label723;
        }
        localIntent.putExtra("preChatTYPE", 2);
      }
    }
    for (;;)
    {
      localIntent.putExtra("prePublishId", "msg_" + parambl.field_msgSvrId);
      paramString2 = paramString1;
      if (com.tencent.mm.platformtools.ae.isNullOrNil(paramString1)) {
        paramString2 = u.aqG();
      }
      localIntent.putExtra("preUsername", paramString2);
      localIntent.putExtra("preChatName", parambl.field_talker);
      com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
      com.tencent.mm.bt.a.Vt(((bl.a)localObject).scene);
      AppMethodBeat.o(37190);
      return;
      localIntent.putExtra("Contact_Scene", 41);
      com.tencent.mm.plugin.report.service.h.vKh.kvStat(10298, ((bl.a)localObject).yGA + ",41");
      break;
      label723:
      localIntent.putExtra("preChatTYPE", 1);
    }
  }
  
  static final class a
    extends c.a
  {
    public int GJV;
    ImageView GJi;
    ImageView GLl;
    TextView GLm;
    TextView GLn;
    TextView frs;
    
    public final c.a z(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(37176);
      super.fK(paramView);
      this.GLl = ((ImageView)paramView.findViewById(2131298057));
      this.fwS = ((TextView)paramView.findViewById(2131298178));
      this.GLm = ((TextView)paramView.findViewById(2131298182));
      this.GLn = ((TextView)paramView.findViewById(2131298186));
      this.frs = ((TextView)paramView.findViewById(2131298152));
      this.wet = ((TextView)paramView.findViewById(2131298185));
      this.naN = paramView.findViewById(2131298069);
      this.hIS = ((CheckBox)paramView.findViewById(2131298068));
      this.lRB = paramView.findViewById(2131298147);
      if (!paramBoolean)
      {
        this.GHZ = ((ImageView)paramView.findViewById(2131298174));
        this.GJi = ((ImageView)paramView.findViewById(2131298176));
        this.uPp = ((ProgressBar)paramView.findViewById(2131306220));
      }
      this.GJV = c.jQ(aj.getContext());
      AppMethodBeat.o(37176);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private String GNd;
    private String GNe;
    private com.tencent.mm.ui.chatting.d.a Gob;
    
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
        localObject = new af(paramLayoutInflater, 2131493450);
        ((View)localObject).setTag(new ae.a().z((View)localObject, true));
      }
      AppMethodBeat.o(37177);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
    {
      AppMethodBeat.i(37179);
      this.Gob = parama1;
      ae.a locala = (ae.a)parama;
      bl.a locala1;
      if (parama1.eZb())
      {
        parama = com.tencent.mm.model.bi.ug(parambl.field_content);
        az.arV();
        locala1 = com.tencent.mm.model.c.apO().agC(parama);
        if ((locala1.yGA == null) || (locala1.yGA.length() <= 0)) {
          ad.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
        }
        this.GNd = locala1.yGA;
        this.GNe = "";
        if (!com.tencent.mm.platformtools.ae.isNullOrNil(parama))
        {
          parama = bw.K(parama, "msg");
          if (parama == null) {
            ad.e("MicroMsg.ChattingItemCardFrom", "null==attrs");
          }
          if ((parama != null) && (parama.containsKey(".msg.$wechatid"))) {
            this.GNe = ((String)parama.get(".msg.$wechatid"));
          }
        }
        com.tencent.mm.ak.c.ac(this.GNd, locala1.FzU);
        ae.a.aE(locala.naN, locala.GJV);
        if (!w.mZ(locala1.AOL)) {
          break label451;
        }
        locala.GLm.setText(2131757135);
        locala.GLn.setVisibility(8);
        if (!com.tencent.mm.compatible.util.d.lf(16)) {
          break label439;
        }
        locala.GLl.setBackground(null);
        label217:
        A(locala.GLl, this.GNd);
        label229:
        parama = this.GNe;
        if ((!com.tencent.mm.platformtools.ae.isNullOrNil(parama)) && (!com.tencent.mm.storage.af.aHK(parama)) && (!w.sC(parama))) {
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
        boolean bool = w.mZ(locala1.AOL);
        if ((i != 0) || (bool))
        {
          parama = "";
          if (com.tencent.mm.platformtools.ae.isNullOrNil(parama)) {
            break label491;
          }
          locala.GLn.setVisibility(0);
          locala.GLn.setText(parama);
        }
        for (;;)
        {
          locala.frs.setText(k.b(parama1.GzJ.getContext(), locala1.nickname, (int)locala.frs.getTextSize()));
          ae.a(parama1, this.GNd, locala1, locala);
          locala.naN.setTag(new bi(parambl, parama1.eZb(), paramInt, paramString, '\000'));
          locala.naN.setOnClickListener(d(parama1));
          locala.naN.setOnLongClickListener(c(parama1));
          locala.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
          AppMethodBeat.o(37179);
          return;
          parama = parambl.field_content;
          break;
          locala.GLl.setBackgroundDrawable(null);
          break label217;
          locala.GLm.setText(2131757260);
          locala.GLl.setBackgroundResource(2131231875);
          z(locala.GLl, this.GNd);
          break label229;
          break label281;
          locala.GLn.setVisibility(8);
        }
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
    {
      AppMethodBeat.i(37180);
      int j = ((bi)paramView.getTag()).position;
      az.arV();
      bl.a locala = com.tencent.mm.model.c.apO().agC(parambl.field_content);
      if ((locala.yGA == null) || (locala.yGA.length() <= 0)) {
        ad.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
      }
      this.GNd = locala.yGA;
      boolean bool = w.mZ(locala.AOL);
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pqv, 0) == 1) {}
      for (int i = 1;; i = 0)
      {
        if (((i != 0) && (parambl.getType() != 66) && (!com.tencent.mm.storage.af.aHH(this.Gob.getTalkerUserName())) && (!com.tencent.mm.storage.af.aHI(this.Gob.getTalkerUserName()))) || (bool)) {
          paramContextMenu.add(j, 118, 0, paramView.getContext().getString(2131762559));
        }
        if (!this.Gob.eZc()) {
          paramContextMenu.add(j, 100, 0, paramView.getContext().getString(2131757221));
        }
        AppMethodBeat.o(37180);
        return true;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(37181);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37181);
        return false;
      }
      paramMenuItem = parama.GzJ.getContext();
      if (j.aY(parambl))
      {
        com.tencent.mm.ui.base.h.a(paramMenuItem, paramMenuItem.getString(2131759586), "", paramMenuItem.getString(2131766205), null);
        AppMethodBeat.o(37181);
        return false;
      }
      if (j.aZ(parambl))
      {
        com.tencent.mm.ui.base.h.a(paramMenuItem, paramMenuItem.getString(2131759587), "", paramMenuItem.getString(2131766205), null);
        AppMethodBeat.o(37181);
        return false;
      }
      paramMenuItem = new Intent(parama.GzJ.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 8);
      paramMenuItem.putExtra("Retr_Msg_Id", parambl.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37181);
      return false;
    }
    
    public final boolean aX(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 42) || (paramInt == 66));
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(37182);
      ((com.tencent.mm.plugin.comm.a.b)g.ab(com.tencent.mm.plugin.comm.a.b.class)).Sa(parambl.field_talker);
      paramView = (bi)paramView.getTag();
      String str1 = paramView.userName;
      String str2 = parambl.field_content;
      boolean bool2 = paramView.GjM;
      if (parambl.field_isSend == 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ae.a(parama, str1, str2, bool2, bool1, parambl);
        AppMethodBeat.o(37182);
        return true;
      }
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(37178);
      boolean bool = parama.eZb();
      AppMethodBeat.o(37178);
      return bool;
    }
    
    public final boolean faE()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
    implements s.n
  {
    private String GNd;
    private com.tencent.mm.ui.chatting.d.a Gob;
    
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
        localObject = new af(paramLayoutInflater, 2131493494);
        ((View)localObject).setTag(new ae.a().z((View)localObject, false));
      }
      AppMethodBeat.o(37183);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(37188);
      parambl.eMq();
      az.arV();
      com.tencent.mm.model.c.apO().a(parambl.field_msgId, parambl);
      ((e)parama.be(e.class)).bx(parambl);
      AppMethodBeat.o(37188);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
    {
      int j = 1;
      AppMethodBeat.i(37184);
      this.Gob = parama1;
      ae.a locala = (ae.a)parama;
      az.arV();
      bl.a locala1 = com.tencent.mm.model.c.apO().agC(parambl.field_content);
      if ((locala1.yGA == null) || (locala1.yGA.length() <= 0)) {
        ad.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
      }
      this.GNd = locala1.yGA;
      ad.d("MicroMsg.ChattingItemCardTo", "dancy is biz: %s, userName: %s ", new Object[] { Boolean.valueOf(w.sE(this.GNd)), this.GNd });
      ae.a.aE(locala.naN, locala.GJV);
      if (w.mZ(locala1.AOL))
      {
        locala.GLm.setText(2131757135);
        locala.GLn.setVisibility(8);
        if (com.tencent.mm.compatible.util.d.lf(16))
        {
          locala.GLl.setBackground(null);
          A(locala.GLl, this.GNd);
          label177:
          locala.frs.setText(k.b(parama1.GzJ.getContext(), locala1.nickname, locala.frs.getTextSize()));
          parama = locala1.eKn;
          if (!com.tencent.mm.platformtools.ae.isNullOrNil(this.GNd))
          {
            az.arV();
            paramString = com.tencent.mm.model.c.apM().aHY(this.GNd);
            if ((paramString != null) && (com.tencent.mm.n.b.ls(paramString.field_type))) {
              break label688;
            }
          }
        }
      }
      label646:
      label688:
      for (int i = 1;; i = 0)
      {
        if ((i == 0) && (com.tencent.mm.platformtools.ae.isNullOrNil(parama)))
        {
          paramString = this.GNd;
          i = j;
          parama = paramString;
          if (!com.tencent.mm.platformtools.ae.isNullOrNil(paramString))
          {
            i = j;
            parama = paramString;
            if (!com.tencent.mm.storage.af.aHK(paramString))
            {
              if (!w.sC(paramString)) {
                break label603;
              }
              parama = paramString;
              i = j;
            }
          }
        }
        for (;;)
        {
          label324:
          boolean bool = w.mZ(locala1.AOL);
          if ((i != 0) || (bool)) {
            parama = "";
          }
          if (!com.tencent.mm.platformtools.ae.isNullOrNil(parama))
          {
            locala.GLn.setVisibility(0);
            locala.GLn.setText(parama);
            label373:
            ae.a(parama1, this.GNd, locala1, locala);
            locala.naN.setTag(new bi(parambl, parama1.eZb(), paramInt, null, '\000'));
            locala.naN.setOnClickListener(d(parama1));
            locala.naN.setOnLongClickListener(c(parama1));
            locala.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
            if (!faG()) {
              break label646;
            }
            if (locala.uPp != null) {
              locala.uPp.setVisibility(8);
            }
            if ((parambl.field_status != 2) || (!a((i)parama1.be(i.class), parambl.field_msgId))) {
              break label625;
            }
            if (locala.GJi != null) {
              locala.GJi.setVisibility(0);
            }
          }
          for (;;)
          {
            a(paramInt, locala, parambl, parama1.eYX(), parama1.eZb(), parama1, this);
            AppMethodBeat.o(37184);
            return;
            locala.GLl.setBackgroundDrawable(null);
            break;
            locala.GLm.setText(2131757260);
            locala.GLl.setBackgroundResource(2131231875);
            z(locala.GLl, this.GNd);
            break label177;
            label603:
            i = 0;
            parama = paramString;
            break label324;
            locala.GLn.setVisibility(8);
            break label373;
            label625:
            if (locala.GJi != null)
            {
              locala.GJi.setVisibility(8);
              continue;
              if (locala.uPp != null)
              {
                locala.uPp.setVisibility(0);
                if (parambl.field_status >= 2) {
                  locala.uPp.setVisibility(8);
                }
              }
            }
          }
        }
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
    {
      AppMethodBeat.i(37185);
      int j = ((bi)paramView.getTag()).position;
      az.arV();
      bl.a locala = com.tencent.mm.model.c.apO().agC(parambl.field_content);
      if ((locala.yGA == null) || (locala.yGA.length() <= 0)) {
        ad.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
      }
      this.GNd = locala.yGA;
      boolean bool = w.mZ(locala.AOL);
      if (((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pqv, 0) == 1) {}
      for (int i = 1;; i = 0)
      {
        if (((i != 0) && (parambl.getType() != 66) && (!com.tencent.mm.storage.af.aHH(this.Gob.getTalkerUserName())) && (!com.tencent.mm.storage.af.aHI(this.Gob.getTalkerUserName()))) || (bool)) {
          paramContextMenu.add(j, 118, 0, paramView.getContext().getString(2131762559));
        }
        if ((!parambl.eJL()) && ((parambl.field_status == 2) || (parambl.eOX == 1)) && (parambl.eLX()) && (b(parambl, this.Gob)) && (aKZ(parambl.field_talker))) {
          paramContextMenu.add(j, 123, 0, paramView.getContext().getString(2131757234));
        }
        if (!this.Gob.eZc()) {
          paramContextMenu.add(j, 100, 0, paramView.getContext().getString(2131757221));
        }
        AppMethodBeat.o(37185);
        return true;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(37186);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37186);
        return false;
      }
      paramMenuItem = parama.GzJ.getContext();
      if (j.aY(parambl))
      {
        com.tencent.mm.ui.base.h.a(paramMenuItem, paramMenuItem.getString(2131759586), "", paramMenuItem.getString(2131766205), null);
        AppMethodBeat.o(37186);
        return false;
      }
      if (j.aZ(parambl))
      {
        com.tencent.mm.ui.base.h.a(paramMenuItem, paramMenuItem.getString(2131759587), "", paramMenuItem.getString(2131766205), null);
        AppMethodBeat.o(37186);
        return false;
      }
      paramMenuItem = new Intent(parama.GzJ.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.model.bi.b(parama.eZb(), parambl.field_content, parambl.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 8);
      paramMenuItem.putExtra("Retr_Msg_Id", parambl.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37186);
      return false;
    }
    
    public final boolean aX(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 42) || (paramInt == 66));
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(37187);
      ((com.tencent.mm.plugin.comm.a.b)g.ab(com.tencent.mm.plugin.comm.a.b.class)).Sa(parambl.field_talker);
      paramView = (bi)paramView.getTag();
      String str1 = paramView.userName;
      String str2 = parambl.field_content;
      boolean bool2 = paramView.GjM;
      if (parambl.field_isSend == 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ae.a(parama, str1, str2, bool2, bool1, parambl);
        AppMethodBeat.o(37187);
        return true;
      }
    }
    
    public final boolean faE()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ae
 * JD-Core Version:    0.7.0.1
 */