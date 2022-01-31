package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import java.util.Map;

public final class v
{
  public static void a(com.tencent.mm.ui.chatting.d.a parama, String paramString, bi.a parama1, v.a parama2)
  {
    AppMethodBeat.i(33119);
    if (!ad.arf(paramString))
    {
      AppMethodBeat.o(33119);
      return;
    }
    String str = parama1.yOm;
    str = ((com.tencent.mm.openim.a.b)g.E(com.tencent.mm.openim.a.b.class)).a(str, "openim_card_type_name", b.a.gfD);
    if (TextUtils.isEmpty(str))
    {
      parama2.zUV.setText(2131298269);
      parama2.zUU.setBackgroundResource(2130838493);
      c.w(parama2.zUU, paramString);
      str = parama1.yOo;
      paramString = parama1.yOn;
      if (ah.isNullOrNil(str)) {
        break label171;
      }
    }
    label171:
    for (parama = ((com.tencent.mm.openim.a.b)g.E(com.tencent.mm.openim.a.b.class)).a(parama.zJz.getContext(), str, paramString, parama2.zUW.getTextSize());; parama = paramString)
    {
      if (TextUtils.isEmpty(parama)) {
        break label176;
      }
      parama2.zUW.setVisibility(0);
      parama2.zUW.setText(parama);
      AppMethodBeat.o(33119);
      return;
      parama2.zUV.setText(str);
      break;
    }
    label176:
    parama2.zUW.setVisibility(8);
    AppMethodBeat.o(33119);
  }
  
  public static void a(com.tencent.mm.ui.chatting.d.a parama, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, bi parambi)
  {
    AppMethodBeat.i(33120);
    Object localObject = paramString2;
    if (paramBoolean1)
    {
      localObject = paramString2;
      if (paramBoolean2) {
        localObject = bf.pv(paramString2);
      }
    }
    aw.aaz();
    localObject = com.tencent.mm.model.c.YC().Ty((String)localObject);
    if (localObject == null)
    {
      AppMethodBeat.o(33120);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", ((bi.a)localObject).tac);
    localIntent.putExtra("Contact_Alias", ((bi.a)localObject).dCJ);
    localIntent.putExtra("Contact_Nick", ((bi.a)localObject).nickname);
    localIntent.putExtra("Contact_QuanPin", ((bi.a)localObject).gyI);
    localIntent.putExtra("Contact_PyInitial", ((bi.a)localObject).gyH);
    localIntent.putExtra("Contact_Uin", ((bi.a)localObject).pAI);
    localIntent.putExtra("Contact_Mobile_MD5", ((bi.a)localObject).yOi);
    localIntent.putExtra("Contact_full_Mobile_MD5", ((bi.a)localObject).yOj);
    localIntent.putExtra("Contact_QQNick", ((bi.a)localObject).dyu());
    localIntent.putExtra("User_From_Fmessage", false);
    localIntent.putExtra("Contact_Scene", ((bi.a)localObject).scene);
    localIntent.putExtra("Contact_FMessageCard", true);
    localIntent.putExtra("Contact_RemarkName", ((bi.a)localObject).gyM);
    localIntent.putExtra("Contact_VUser_Info_Flag", ((bi.a)localObject).uOT);
    localIntent.putExtra("Contact_VUser_Info", ((bi.a)localObject).dqP);
    localIntent.putExtra("Contact_BrandIconURL", ((bi.a)localObject).pyu);
    localIntent.putExtra("Contact_Province", ((bi.a)localObject).getProvince());
    localIntent.putExtra("Contact_City", ((bi.a)localObject).getCity());
    localIntent.putExtra("Contact_Sex", ((bi.a)localObject).dqC);
    localIntent.putExtra("Contact_Signature", ((bi.a)localObject).signature);
    localIntent.putExtra("Contact_ShowUserName", true);
    localIntent.putExtra("Contact_KSnsIFlag", 0);
    localIntent.putExtra("Contact_Source_FMessage", 17);
    localIntent.putExtra("source_from_user_name", paramString1);
    localIntent.putExtra("source_from_nick_name", s.nD(paramString1));
    localIntent.putExtra(e.b.yUZ, ((bi.a)localObject).waH);
    localIntent.putExtra("key_add_contact_openim_appid", ((bi.a)localObject).yOm);
    localIntent.putExtra("key_add_contact_custom_detail", ((bi.a)localObject).yOp);
    if ((((bi.a)localObject).uOT & 0x8) > 0)
    {
      if (!ah.isNullOrNil(paramString1))
      {
        aw.aaz();
        if (com.tencent.mm.model.c.YA().arw(paramString1).dwz()) {}
      }
      else
      {
        localIntent.putExtra("Contact_Scene", 17);
        com.tencent.mm.plugin.report.service.h.qsU.kvStat(10298, ((bi.a)localObject).tac + ",17");
      }
    }
    else
    {
      if ((ad.arf(((bi.a)localObject).tac)) && (((bi.a)localObject).scene == 0)) {
        localIntent.putExtra("Contact_Scene", 17);
      }
      if (t.ku(((bi.a)localObject).uOT))
      {
        if (!parama.dJG()) {
          break label694;
        }
        localIntent.putExtra("preChatTYPE", 2);
      }
    }
    for (;;)
    {
      localIntent.putExtra("prePublishId", "msg_" + parambi.field_msgSvrId);
      paramString2 = paramString1;
      if (ah.isNullOrNil(paramString1)) {
        paramString2 = r.Zn();
      }
      localIntent.putExtra("preUsername", paramString2);
      localIntent.putExtra("preChatName", parambi.field_talker);
      com.tencent.mm.bq.d.b(parama.zJz.getContext(), "profile", ".ui.ContactInfoUI", localIntent);
      com.tencent.mm.br.a.My(((bi.a)localObject).scene);
      AppMethodBeat.o(33120);
      return;
      localIntent.putExtra("Contact_Scene", 41);
      com.tencent.mm.plugin.report.service.h.qsU.kvStat(10298, ((bi.a)localObject).tac + ",41");
      break;
      label694:
      localIntent.putExtra("preChatTYPE", 1);
    }
  }
  
  public static final class b
    extends c
  {
    private String zUX;
    private String zUY;
    private com.tencent.mm.ui.chatting.d.a zzP;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(33107);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new w(paramLayoutInflater, 2130969077);
        ((View)localObject).setTag(new v.a().A((View)localObject, true));
      }
      AppMethodBeat.o(33107);
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
    {
      AppMethodBeat.i(33109);
      this.zzP = parama1;
      v.a locala = (v.a)parama;
      bi.a locala1;
      if (parama1.dJG())
      {
        parama = bf.pv(parambi.field_content);
        aw.aaz();
        locala1 = com.tencent.mm.model.c.YC().Ty(parama);
        if ((locala1.tac == null) || (locala1.tac.length() <= 0)) {
          ab.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
        }
        this.zUX = locala1.tac;
        this.zUY = "";
        if (!ah.isNullOrNil(parama))
        {
          parama = br.F(parama, "msg");
          if (parama.containsKey(".msg.$wechatid")) {
            this.zUY = ((String)parama.get(".msg.$wechatid"));
          }
        }
        com.tencent.mm.ah.b.U(this.zUX, locala1.yOh);
        v.a.ar(locala.jYu, locala.zSN);
        if (!t.ku(locala1.uOT)) {
          break label436;
        }
        locala.zUV.setText(2131298146);
        locala.zUW.setVisibility(8);
        if (!com.tencent.mm.compatible.util.d.fv(16)) {
          break label424;
        }
        locala.zUU.setBackground(null);
        label202:
        x(locala.zUU, this.zUX);
        label214:
        parama = this.zUY;
        if ((!ah.isNullOrNil(parama)) && (!ad.ari(parama)) && (!t.nS(parama))) {
          break label489;
        }
      }
      label266:
      label424:
      label436:
      label476:
      label489:
      for (int i = 1;; i = 0)
      {
        boolean bool = t.ku(locala1.uOT);
        if ((i != 0) || (bool))
        {
          parama = "";
          if (ah.isNullOrNil(parama)) {
            break label476;
          }
          locala.zUW.setVisibility(0);
          locala.zUW.setText(parama);
        }
        for (;;)
        {
          locala.egr.setText(j.b(parama1.zJz.getContext(), locala1.nickname, (int)locala.egr.getTextSize()));
          v.a(parama1, this.zUX, locala1, locala);
          locala.jYu.setTag(new az(parambi, parama1.dJG(), paramInt, paramString, '\000'));
          locala.jYu.setOnClickListener(d(parama1));
          locala.jYu.setOnLongClickListener(c(parama1));
          locala.jYu.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHi());
          AppMethodBeat.o(33109);
          return;
          parama = parambi.field_content;
          break;
          locala.zUU.setBackgroundDrawable(null);
          break label202;
          locala.zUV.setText(2131298269);
          locala.zUU.setBackgroundResource(2130838493);
          w(locala.zUU, this.zUX);
          break label214;
          break label266;
          locala.zUW.setVisibility(8);
        }
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
    {
      AppMethodBeat.i(33110);
      int i = ((az)paramView.getTag()).position;
      aw.aaz();
      parambi = com.tencent.mm.model.c.YC().Ty(parambi.field_content);
      if ((parambi.tac == null) || (parambi.tac.length() <= 0)) {
        ab.e("MicroMsg.ChattingItemCardFrom", "getView : parse possible friend msg failed");
      }
      this.zUX = parambi.tac;
      if (t.ku(parambi.uOT)) {
        paramContextMenu.add(i, 118, 0, paramView.getContext().getString(2131302650));
      }
      if (!this.zzP.dJH()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(2131298232));
      }
      AppMethodBeat.o(33110);
      return true;
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
    {
      AppMethodBeat.i(33111);
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(33111);
        return false;
      }
      paramMenuItem = new Intent(parama.zJz.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 8);
      paramMenuItem.putExtra("Retr_Msg_Id", parambi.field_msgId);
      parama.startActivity(paramMenuItem);
      AppMethodBeat.o(33111);
      return false;
    }
    
    public final boolean aK(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 42) || (paramInt == 66));
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
    {
      AppMethodBeat.i(33112);
      paramView = (az)paramView.getTag();
      String str1 = paramView.userName;
      String str2 = parambi.field_content;
      boolean bool2 = paramView.zvB;
      if (parambi.field_isSend == 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        v.a(parama, str1, str2, bool2, bool1, parambi);
        AppMethodBeat.o(33112);
        return true;
      }
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(33108);
      boolean bool = parama.dJG();
      AppMethodBeat.o(33108);
      return bool;
    }
    
    public final boolean dLp()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.v
 * JD-Core Version:    0.7.0.1
 */