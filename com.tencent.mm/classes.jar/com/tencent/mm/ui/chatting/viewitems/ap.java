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
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.api.q;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.openim.a.a.a;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.f;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.e;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.f.d;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.Map;

public final class ap
{
  public static void a(com.tencent.mm.ui.chatting.e.a parama, String paramString, ca.a parama1, a parama2)
  {
    AppMethodBeat.i(37189);
    if (!as.bvK(paramString))
    {
      AppMethodBeat.o(37189);
      return;
    }
    String str = parama1.VGK;
    str = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).a(str, "openim_card_type_name", a.a.mxX);
    if (TextUtils.isEmpty(str))
    {
      parama2.Xgl.setText(R.l.ews);
      parama2.Xgk.setBackgroundResource(R.g.default_avatar);
      c.F(parama2.Xgk, paramString);
      str = parama1.VGM;
      paramString = parama1.VGL;
      if (ae.isNullOrNil(str)) {
        break label173;
      }
    }
    label173:
    for (parama = ((com.tencent.mm.openim.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.openim.a.a.class)).a(parama.WQv.getContext(), str, paramString, parama2.Xgm.getTextSize());; parama = paramString)
    {
      if (TextUtils.isEmpty(parama)) {
        break label178;
      }
      parama2.Xgm.setVisibility(0);
      parama2.Xgm.setText(parama);
      AppMethodBeat.o(37189);
      return;
      parama2.Xgl.setText(str);
      break;
    }
    label178:
    parama2.Xgm.setVisibility(8);
    AppMethodBeat.o(37189);
  }
  
  public static void a(com.tencent.mm.ui.chatting.e.a parama, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, ca paramca)
  {
    AppMethodBeat.i(37190);
    Log.i("MicroMsg.ChattingItemCard", "dealClickCardMsgEvent, fromUser:%s, groupChat:%s, recv:%s, msgType:%s,msgContent:%s", new Object[] { paramString1, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramca.getType()), paramString2 });
    Object localObject1 = paramString2;
    if (paramBoolean1)
    {
      localObject1 = paramString2;
      if (paramBoolean2) {
        localObject1 = com.tencent.mm.model.bq.RM(paramString2);
      }
    }
    bh.beI();
    localObject1 = com.tencent.mm.model.c.bbO().aOU((String)localObject1);
    if (localObject1 == null)
    {
      AppMethodBeat.o(37190);
      return;
    }
    paramString2 = ((ca.a)localObject1).fcC;
    if (((as.bvK(paramString2)) || (ab.PQ(paramString2))) && (!WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(parama.WQv.getContext())))
    {
      AppMethodBeat.o(37190);
      return;
    }
    Intent localIntent = new Intent();
    Object localObject2;
    if (!ab.uL(((ca.a)localObject1).PKJ))
    {
      com.tencent.mm.plugin.report.service.h.IzE.el(1430, 0);
      bh.beI();
      localObject2 = com.tencent.mm.model.c.bbL().RG(paramString2);
      if ((localObject2 != null) && (com.tencent.mm.contact.d.rk(((ax)localObject2).field_type)))
      {
        paramString2 = ((ax)localObject2).field_username;
        Log.i("MicroMsg.ChattingItemCard", "find in contact, friend:%s", new Object[] { ((ax)localObject2).field_username });
        com.tencent.mm.plugin.report.service.h.IzE.el(1430, 1);
      }
    }
    label1306:
    label1319:
    for (;;)
    {
      localIntent.putExtra("Contact_User", paramString2);
      localIntent.putExtra("Contact_Alias", ((ca.a)localObject1).idS);
      localIntent.putExtra("Contact_Nick", ((ca.a)localObject1).nickname);
      localIntent.putExtra("Contact_QuanPin", ((ca.a)localObject1).mXq);
      localIntent.putExtra("Contact_PyInitial", ((ca.a)localObject1).mXp);
      localIntent.putExtra("Contact_Uin", ((ca.a)localObject1).GZN);
      localIntent.putExtra("Contact_Mobile_MD5", ((ca.a)localObject1).VGG);
      localIntent.putExtra("Contact_full_Mobile_MD5", ((ca.a)localObject1).VGH);
      localIntent.putExtra("Contact_QQNick", ((ca.a)localObject1).hAp());
      localIntent.putExtra("User_From_Fmessage", false);
      localIntent.putExtra("Contact_Scene", ((ca.a)localObject1).scene);
      localIntent.putExtra("Contact_FMessageCard", true);
      localIntent.putExtra("Contact_RemarkName", ((ca.a)localObject1).mXu);
      localIntent.putExtra("Contact_VUser_Info_Flag", ((ca.a)localObject1).PKJ);
      localIntent.putExtra("Contact_VUser_Info", ((ca.a)localObject1).verifyInfo);
      localIntent.putExtra("Contact_BrandIconURL", ((ca.a)localObject1).GXB);
      localIntent.putExtra("Contact_Province", ((ca.a)localObject1).getProvince());
      localIntent.putExtra("Contact_City", ((ca.a)localObject1).getCity());
      localIntent.putExtra("Contact_Sex", ((ca.a)localObject1).sex);
      localIntent.putExtra("Contact_Signature", ((ca.a)localObject1).signature);
      localIntent.putExtra("Contact_ShowUserName", true);
      localIntent.putExtra("Contact_KSnsIFlag", 0);
      localIntent.putExtra("Contact_Source_FMessage", 17);
      localIntent.putExtra("source_from_user_name", paramString1);
      localIntent.putExtra("source_from_nick_name", aa.PI(paramString1));
      localIntent.putExtra(f.d.VRW, ((ca.a)localObject1).RpW);
      localIntent.putExtra("key_add_contact_openim_appid", ((ca.a)localObject1).VGK);
      localIntent.putExtra("key_add_contact_custom_detail", ((ca.a)localObject1).VGN);
      localIntent.putExtra("key_forward_flag", paramca.hzQ());
      localIntent.putExtra("key_msg_id", paramca.field_msgId);
      if ((((ca.a)localObject1).PKJ & 0x8) > 0)
      {
        if (!ae.isNullOrNil(paramString1))
        {
          bh.beI();
          if (com.tencent.mm.model.c.bbL().RG(paramString1).hxX()) {}
        }
        else
        {
          localIntent.putExtra("Contact_Scene", 17);
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(10298, ((ca.a)localObject1).fcC + ",17");
        }
      }
      else
      {
        label709:
        if ((as.bvK(((ca.a)localObject1).fcC)) && (((ca.a)localObject1).scene == 0)) {
          localIntent.putExtra("Contact_Scene", 17);
        }
        if (ab.uL(((ca.a)localObject1).PKJ))
        {
          if (!parama.hRi()) {
            break label1306;
          }
          localIntent.putExtra("preChatTYPE", 2);
        }
      }
      for (;;)
      {
        localIntent.putExtra("prePublishId", "msg_" + paramca.field_msgSvrId);
        paramString2 = paramString1;
        if (ae.isNullOrNil(paramString1)) {
          paramString2 = z.bcZ();
        }
        localIntent.putExtra("preUsername", paramString2);
        localIntent.putExtra("preChatName", paramca.field_talker);
        com.tencent.mm.by.c.b(parama.WQv.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
        com.tencent.mm.bz.a.are(((ca.a)localObject1).scene);
        AppMethodBeat.o(37190);
        return;
        bh.beI();
        com.tencent.mm.storage.bq localbq = com.tencent.mm.model.c.bbN().aOy(paramString2);
        if ((localbq != null) && (!ae.isNullOrNil(localbq.field_username)))
        {
          paramString2 = localbq.field_username;
          Log.i("MicroMsg.ChattingItemCard", "find in FriendUser Map, friend:%s", new Object[] { ((ax)localObject2).field_username });
          com.tencent.mm.plugin.report.service.h.IzE.el(1430, 2);
          break;
        }
        if ((localbq == null) || (ae.isNullOrNil(localbq.field_encryptUsername)))
        {
          localObject2 = new com.tencent.mm.storage.bq(paramString2);
          ((com.tencent.mm.storage.bq)localObject2).field_modifyTime = System.currentTimeMillis();
          bh.beI();
          if (!com.tencent.mm.model.c.bbN().replace((IAutoDBItem)localObject2)) {
            Log.e("MicroMsg.ChattingItemCard", "add friendUser fail, encryptUsername:%s", new Object[] { paramString2 });
          }
        }
        localIntent.putExtra("force_get_contact", true);
        Log.i("MicroMsg.ChattingItemCard", "need to get contact to judge if Friend, KForceGetContact is true");
        com.tencent.mm.plugin.report.service.h.IzE.el(1430, 3);
        break;
        if (!WeChatBrands.Business.Entries.SessionOa.checkAvailable(parama.WQv.getContext()))
        {
          AppMethodBeat.o(37190);
          return;
        }
        bh.beI();
        localObject2 = com.tencent.mm.model.c.bbL().RG(paramString2);
        if ((localObject2 == null) || (!((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ZM())) {
          break label1319;
        }
        int i = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).gkr();
        if ((i == 0) && (!com.tencent.mm.contact.d.rk(((ax)localObject2).field_type)))
        {
          ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ir(parama.WQv.getContext());
          parama = (q)com.tencent.mm.kernel.h.ae(q.class);
          if (paramBoolean1) {}
          for (i = 2;; i = 1)
          {
            parama.d(i, paramString2, ((ca.a)localObject1).nickname);
            AppMethodBeat.o(37190);
            return;
          }
        }
        if (i != 2) {
          break label1319;
        }
        ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.teenmode.a.b.class)).ir(parama.WQv.getContext());
        parama = (q)com.tencent.mm.kernel.h.ae(q.class);
        if (paramBoolean1) {}
        for (i = 2;; i = 1)
        {
          parama.d(i, paramString2, ((ca.a)localObject1).nickname);
          AppMethodBeat.o(37190);
          return;
        }
        localIntent.putExtra("Contact_Scene", 41);
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(10298, ((ca.a)localObject1).fcC + ",41");
        break label709;
        localIntent.putExtra("preChatTYPE", 1);
      }
    }
  }
  
  static final class a
    extends c.a
  {
    ImageView XdI;
    public int Xev;
    ImageView Xgk;
    TextView Xgl;
    TextView Xgm;
    TextView iZH;
    
    public final c.a J(View paramView, boolean paramBoolean)
    {
      AppMethodBeat.i(37176);
      super.create(paramView);
      this.Xgk = ((ImageView)paramView.findViewById(R.h.dwU));
      this.timeTV = ((TextView)paramView.findViewById(R.h.dzs));
      this.Xgl = ((TextView)paramView.findViewById(R.h.dzv));
      this.Xgm = ((TextView)paramView.findViewById(R.h.dzx));
      this.iZH = ((TextView)paramView.findViewById(R.h.dyQ));
      this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
      this.clickArea = paramView.findViewById(R.h.chatting_click_area);
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
      this.maskView = paramView.findViewById(R.h.dyD);
      if (!paramBoolean)
      {
        this.stateIV = ((ImageView)paramView.findViewById(R.h.dzp));
        this.XdI = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
        this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.dYz));
      }
      this.Xev = c.lj(MMApplicationContext.getContext());
      AppMethodBeat.o(37176);
      return this;
    }
  }
  
  public static final class b
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a WBq;
    private String Xiu;
    private String Xiv;
    
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
        localObject = new aq(paramLayoutInflater, R.i.edi);
        ((View)localObject).setTag(new ap.a().J((View)localObject, true));
      }
      AppMethodBeat.o(37177);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      AppMethodBeat.i(37179);
      this.WBq = parama1;
      ap.a locala = (ap.a)parama;
      ca.a locala1;
      if (parama1.hRi())
      {
        parama = com.tencent.mm.model.bq.RM(paramca.field_content);
        bh.beI();
        locala1 = com.tencent.mm.model.c.bbO().aOU(parama);
        if ((locala1.fcC == null) || (locala1.fcC.length() <= 0)) {
          Log.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
        }
        this.Xiu = locala1.fcC;
        this.Xiv = "";
        if (!ae.isNullOrNil(parama))
        {
          parama = XmlParser.parseXml(parama, "msg", null);
          if (parama == null) {
            Log.e("MicroMsg.ChattingItemCardFrom", "null==attrs");
          }
          if ((parama != null) && (parama.containsKey(".msg.$wechatid"))) {
            this.Xiv = ((String)parama.get(".msg.$wechatid"));
          }
        }
        com.tencent.mm.am.d.aH(this.Xiu, locala1.VGF);
        locala.resetChatBubbleWidth(locala.clickArea, locala.Xev);
        if (!ab.uL(locala1.PKJ)) {
          break label455;
        }
        locala.Xgl.setText(R.l.euu);
        locala.Xgm.setVisibility(8);
        if (!com.tencent.mm.compatible.util.d.qV(16)) {
          break label443;
        }
        locala.Xgk.setBackground(null);
        label221:
        G(locala.Xgk, this.Xiu);
        label233:
        parama = this.Xiv;
        if ((!ae.isNullOrNil(parama)) && (!as.bvU(parama)) && (!ab.Qk(parama))) {
          break label508;
        }
      }
      label285:
      label443:
      label455:
      label495:
      label508:
      for (int i = 1;; i = 0)
      {
        boolean bool = ab.uL(locala1.PKJ);
        if ((i != 0) || (bool))
        {
          parama = "";
          if (ae.isNullOrNil(parama)) {
            break label495;
          }
          locala.Xgm.setVisibility(0);
          locala.Xgm.setText(parama);
        }
        for (;;)
        {
          locala.iZH.setText(l.d(parama1.WQv.getContext(), locala1.nickname, (int)locala.iZH.getTextSize()));
          ap.a(parama1, this.Xiu, locala1, locala);
          locala.clickArea.setTag(new by(paramca, parama1.hRi(), paramInt, paramString, '\000'));
          locala.clickArea.setOnClickListener(d(parama1));
          locala.clickArea.setOnLongClickListener(c(parama1));
          locala.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hNO());
          AppMethodBeat.o(37179);
          return;
          parama = paramca.field_content;
          break;
          locala.Xgk.setBackgroundDrawable(null);
          break label221;
          locala.Xgl.setText(R.l.ews);
          locala.Xgk.setBackgroundResource(R.g.default_avatar);
          F(locala.Xgk, this.Xiu);
          break label233;
          break label285;
          locala.Xgm.setVisibility(8);
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37181);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37181);
        return false;
      }
      paramMenuItem = parama.WQv.getContext();
      bh.beI();
      if ((ab.uL(com.tencent.mm.model.c.bbO().aOU(paramca.field_content).PKJ)) && (!WeChatBrands.Business.Entries.SessionOa.checkAvailable(paramMenuItem)))
      {
        AppMethodBeat.o(37181);
        return true;
      }
      if (com.tencent.mm.ui.chatting.k.bM(paramca))
      {
        com.tencent.mm.ui.base.h.a(paramMenuItem, paramMenuItem.getString(R.l.eFT), "", paramMenuItem.getString(R.l.welcome_i_know), null);
        AppMethodBeat.o(37181);
        return false;
      }
      if (com.tencent.mm.ui.chatting.k.bN(paramca))
      {
        com.tencent.mm.ui.base.h.a(paramMenuItem, paramMenuItem.getString(R.l.eFU), "", paramMenuItem.getString(R.l.welcome_i_know), null);
        AppMethodBeat.o(37181);
        return false;
      }
      paramMenuItem = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.model.bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 8);
      paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37181);
      return false;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(211036);
      int j = ((by)paramView.getTag()).position;
      bh.beI();
      ca.a locala = com.tencent.mm.model.c.bbO().aOU(paramca.field_content);
      if ((locala.fcC == null) || (locala.fcC.length() <= 0)) {
        Log.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
      }
      this.Xiu = locala.fcC;
      boolean bool = ab.uL(locala.PKJ);
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGe, 0) == 1) {}
      for (int i = 1;; i = 0)
      {
        if (((i != 0) && (paramca.getType() != 66) && (!as.bvK(this.WBq.getTalkerUserName())) && (!as.bvL(this.WBq.getTalkerUserName()))) || (bool)) {
          paramo.a(j, 118, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
        }
        if (!this.WBq.hRj()) {
          paramo.a(j, 100, paramView.getContext().getString(R.l.evO), R.k.icons_filled_delete);
        }
        AppMethodBeat.o(211036);
        return true;
      }
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(37178);
      boolean bool = parama.hRi();
      AppMethodBeat.o(37178);
      return bool;
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 42) || (paramInt == 66));
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37182);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).asK(paramca.field_talker);
      paramView = (by)paramView.getTag();
      String str1 = paramView.userName;
      String str2 = paramca.field_content;
      boolean bool2 = paramView.Wwx;
      if (paramca.field_isSend == 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ap.a(parama, str1, str2, bool2, bool1, paramca);
        AppMethodBeat.o(37182);
        return true;
      }
    }
    
    public final boolean hTD()
    {
      return false;
    }
  }
  
  public static final class c
    extends c
    implements t.n
  {
    private com.tencent.mm.ui.chatting.e.a WBq;
    private String Xiu;
    
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
        localObject = new aq(paramLayoutInflater, R.i.eei);
        ((View)localObject).setTag(new ap.a().J((View)localObject, false));
      }
      AppMethodBeat.o(37183);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
    {
      boolean bool1 = true;
      AppMethodBeat.i(37184);
      this.WBq = parama1;
      paramString = (ap.a)parama;
      bh.beI();
      ca.a locala = com.tencent.mm.model.c.bbO().aOU(paramca.field_content);
      if ((locala.fcC == null) || (locala.fcC.length() <= 0)) {
        Log.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
      }
      this.Xiu = locala.fcC;
      Log.d("MicroMsg.ChattingItemCardTo", "dancy is biz: %s, userName: %s ", new Object[] { Boolean.valueOf(ab.Qm(this.Xiu)), this.Xiu });
      paramString.resetChatBubbleWidth(paramString.clickArea, paramString.Xev);
      if (ab.uL(locala.PKJ))
      {
        paramString.Xgl.setText(R.l.euu);
        paramString.Xgm.setVisibility(8);
        if (com.tencent.mm.compatible.util.d.qV(16))
        {
          paramString.Xgk.setBackground(null);
          G(paramString.Xgk, this.Xiu);
          label180:
          paramString.iZH.setText(l.b(parama1.WQv.getContext(), locala.nickname, paramString.iZH.getTextSize()));
          parama = locala.idS;
          if (!ae.isNullOrNil(this.Xiu))
          {
            bh.beI();
            as localas = com.tencent.mm.model.c.bbL().RG(this.Xiu);
            if ((localas != null) && (com.tencent.mm.contact.d.rk(localas.field_type))) {
              break label641;
            }
          }
        }
      }
      label641:
      for (int i = 1;; i = 0)
      {
        if ((i == 0) && (ae.isNullOrNil(parama)))
        {
          parama = this.Xiu;
          if ((ae.isNullOrNil(parama)) || (as.bvU(parama)) || (ab.Qk(parama))) {
            i = 1;
          }
        }
        for (;;)
        {
          label305:
          boolean bool2 = ab.uL(locala.PKJ);
          if ((i != 0) || (bool2)) {
            parama = "";
          }
          if (!ae.isNullOrNil(parama))
          {
            paramString.Xgm.setVisibility(0);
            paramString.Xgm.setText(parama);
            label353:
            ap.a(parama1, this.Xiu, locala, paramString);
            paramString.clickArea.setTag(new by(paramca, parama1.hRi(), paramInt, null, '\000'));
            paramString.clickArea.setOnClickListener(d(parama1));
            paramString.clickArea.setOnLongClickListener(c(parama1));
            paramString.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hNO());
            if (!hTG()) {
              break label612;
            }
            b(paramString, false);
            if ((paramca.field_status != 2) || (!b((com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class), paramca.field_msgId))) {
              break label591;
            }
            if (paramString.XdI != null) {
              paramString.XdI.setVisibility(0);
            }
          }
          for (;;)
          {
            a(paramInt, paramString, paramca, parama1.getSelfUserName(), parama1.hRi(), parama1, this);
            AppMethodBeat.o(37184);
            return;
            paramString.Xgk.setBackgroundDrawable(null);
            break;
            paramString.Xgl.setText(R.l.ews);
            paramString.Xgk.setBackgroundResource(R.g.default_avatar);
            F(paramString.Xgk, this.Xiu);
            break label180;
            i = 0;
            break label305;
            paramString.Xgm.setVisibility(8);
            break label353;
            label591:
            if (paramString.XdI != null) {
              paramString.XdI.setVisibility(8);
            }
          }
          label612:
          if (paramca.field_status < 2) {}
          for (;;)
          {
            b(paramString, bool1);
            break;
            bool1 = false;
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37186);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(37186);
        return false;
      }
      paramMenuItem = parama.WQv.getContext();
      if (com.tencent.mm.ui.chatting.k.bM(paramca))
      {
        com.tencent.mm.ui.base.h.a(paramMenuItem, paramMenuItem.getString(R.l.eFT), "", paramMenuItem.getString(R.l.welcome_i_know), null);
        AppMethodBeat.o(37186);
        return false;
      }
      if (com.tencent.mm.ui.chatting.k.bN(paramca))
      {
        com.tencent.mm.ui.base.h.a(paramMenuItem, paramMenuItem.getString(R.l.eFU), "", paramMenuItem.getString(R.l.welcome_i_know), null);
        AppMethodBeat.o(37186);
        return false;
      }
      paramMenuItem = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.model.bq.b(parama.hRi(), paramca.field_content, paramca.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 8);
      paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      parama.startActivity((Intent)paramMenuItem.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemCard$ChattingItemCardTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(37186);
      return false;
    }
    
    public final boolean a(o paramo, View paramView, ca paramca)
    {
      AppMethodBeat.i(289023);
      int j = ((by)paramView.getTag()).position;
      bh.beI();
      ca.a locala = com.tencent.mm.model.c.bbO().aOU(paramca.field_content);
      if ((locala.fcC == null) || (locala.fcC.length() <= 0)) {
        Log.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
      }
      this.Xiu = locala.fcC;
      boolean bool = ab.uL(locala.PKJ);
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vGe, 0) == 1) {}
      for (int i = 1;; i = 0)
      {
        if (((i != 0) && (paramca.getType() != 66) && (!as.bvK(this.WBq.getTalkerUserName())) && (!as.bvL(this.WBq.getTalkerUserName()))) || (bool)) {
          paramo.a(j, 118, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
        }
        if ((!paramca.hwA()) && ((paramca.field_status == 2) || (paramca.ill == 1)) && (paramca.hzy()) && (b(paramca, this.WBq)) && (bzE(paramca.field_talker))) {
          paramo.a(j, 123, paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
        }
        if (!this.WBq.hRj()) {
          paramo.a(j, 100, paramView.getContext().getString(R.l.evO), R.k.icons_filled_delete);
        }
        AppMethodBeat.o(289023);
        return true;
      }
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(289025);
      paramca.unsetOmittedFailResend();
      bh.beI();
      com.tencent.mm.model.c.bbO().a(paramca.field_msgId, paramca);
      ((e)parama.bC(e.class)).co(paramca);
      AppMethodBeat.o(289025);
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 42) || (paramInt == 66));
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37187);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).asK(paramca.field_talker);
      paramView = (by)paramView.getTag();
      String str1 = paramView.userName;
      String str2 = paramca.field_content;
      boolean bool2 = paramView.Wwx;
      if (paramca.field_isSend == 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ap.a(parama, str1, str2, bool2, bool1, paramca);
        AppMethodBeat.o(37187);
        return true;
      }
    }
    
    public final boolean hTD()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ap
 * JD-Core Version:    0.7.0.1
 */