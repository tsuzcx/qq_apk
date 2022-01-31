package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.openim.a.b;
import com.tencent.mm.openim.a.b.a;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.t.m;
import com.tencent.mm.ui.e.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class s
{
  public static void a(com.tencent.mm.ui.chatting.c.a parama, String paramString, bi.a parama1, s.a parama2)
  {
    if (!ad.aaU(paramString)) {
      return;
    }
    String str = parama1.uCa;
    str = ((b)com.tencent.mm.kernel.g.r(b.class)).a(str, "openim_card_type_name", b.a.ePI);
    if (TextUtils.isEmpty(str))
    {
      parama2.vDK.setText(R.l.chatting_personal_card);
      parama2.vDJ.setBackgroundResource(R.g.default_avatar);
      c.r(parama2.vDJ, paramString);
      str = parama1.uCc;
      paramString = parama1.uCb;
      if (ah.bl(str)) {
        break label158;
      }
    }
    label158:
    for (parama = ((b)com.tencent.mm.kernel.g.r(b.class)).a(parama.vtz.getContext(), str, paramString, parama2.vDL.getTextSize());; parama = paramString)
    {
      if (TextUtils.isEmpty(parama)) {
        break label163;
      }
      parama2.vDL.setVisibility(0);
      parama2.vDL.setText(parama);
      return;
      parama2.vDK.setText(str);
      break;
    }
    label163:
    parama2.vDL.setVisibility(8);
  }
  
  public static void a(com.tencent.mm.ui.chatting.c.a parama, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = paramString2;
    if (paramBoolean1)
    {
      localObject = paramString2;
      if (paramBoolean2) {
        localObject = com.tencent.mm.model.bd.iJ(paramString2);
      }
    }
    au.Hx();
    paramString2 = com.tencent.mm.model.c.Fy().HN((String)localObject);
    if (paramString2 == null) {
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putExtra("Contact_User", paramString2.pyp);
    ((Intent)localObject).putExtra("Contact_Alias", paramString2.cMT);
    ((Intent)localObject).putExtra("Contact_Nick", paramString2.nickname);
    ((Intent)localObject).putExtra("Contact_QuanPin", paramString2.fha);
    ((Intent)localObject).putExtra("Contact_PyInitial", paramString2.fgZ);
    ((Intent)localObject).putExtra("Contact_Uin", paramString2.mXV);
    ((Intent)localObject).putExtra("Contact_Mobile_MD5", paramString2.uBW);
    ((Intent)localObject).putExtra("Contact_full_Mobile_MD5", paramString2.uBX);
    ((Intent)localObject).putExtra("Contact_QQNick", paramString2.cvM());
    ((Intent)localObject).putExtra("User_From_Fmessage", false);
    ((Intent)localObject).putExtra("Contact_Scene", paramString2.scene);
    ((Intent)localObject).putExtra("Contact_FMessageCard", true);
    ((Intent)localObject).putExtra("Contact_RemarkName", paramString2.fhe);
    ((Intent)localObject).putExtra("Contact_VUser_Info_Flag", paramString2.qZn);
    ((Intent)localObject).putExtra("Contact_VUser_Info", paramString2.cCF);
    ((Intent)localObject).putExtra("Contact_BrandIconURL", paramString2.mVN);
    ((Intent)localObject).putExtra("Contact_Province", paramString2.getProvince());
    ((Intent)localObject).putExtra("Contact_City", paramString2.getCity());
    ((Intent)localObject).putExtra("Contact_Sex", paramString2.sex);
    ((Intent)localObject).putExtra("Contact_Signature", paramString2.signature);
    ((Intent)localObject).putExtra("Contact_ShowUserName", true);
    ((Intent)localObject).putExtra("Contact_KSnsIFlag", 0);
    ((Intent)localObject).putExtra("Contact_Source_FMessage", 17);
    ((Intent)localObject).putExtra("source_from_user_name", paramString1);
    ((Intent)localObject).putExtra("source_from_nick_name", r.gU(paramString1));
    ((Intent)localObject).putExtra(e.a.uHO, paramString2.sii);
    ((Intent)localObject).putExtra("key_add_contact_openim_appid", paramString2.uCa);
    ((Intent)localObject).putExtra("key_add_contact_custom_detail", paramString2.uCd);
    if ((paramString2.qZn & 0x8) > 0)
    {
      if (!ah.bl(paramString1))
      {
        au.Hx();
        if (com.tencent.mm.model.c.Fw().abl(paramString1).cua()) {
          break label510;
        }
      }
      ((Intent)localObject).putExtra("Contact_Scene", 17);
      h.nFQ.aC(10298, paramString2.pyp + ",17");
    }
    for (;;)
    {
      if ((ad.aaU(paramString2.pyp)) && (paramString2.scene == 0)) {
        ((Intent)localObject).putExtra("Contact_Scene", 17);
      }
      com.tencent.mm.br.d.b(parama.vtz.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
      com.tencent.mm.bs.a.EA(paramString2.scene);
      return;
      label510:
      ((Intent)localObject).putExtra("Contact_Scene", 41);
      h.nFQ.aC(10298, paramString2.pyp + ",41");
    }
  }
  
  public static final class c
    extends c
    implements t.m
  {
    private String vDM;
    private com.tencent.mm.ui.chatting.c.a vko;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new t(paramLayoutInflater, R.i.chatting_item_to_card);
        ((View)localObject).setTag(new s.a().s((View)localObject, false));
      }
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.c.a parama, bi parambi)
    {
      parambi.cvz();
      au.Hx();
      com.tencent.mm.model.c.Fy().a(parambi.field_msgId, parambi);
      ((com.tencent.mm.ui.chatting.b.b.d)parama.ac(com.tencent.mm.ui.chatting.b.b.d.class)).aR(parambi);
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
    {
      int j = 1;
      this.vko = parama1;
      s.a locala = (s.a)parama;
      au.Hx();
      bi.a locala1 = com.tencent.mm.model.c.Fy().HN(parambi.field_content);
      if ((locala1.pyp == null) || (locala1.pyp.length() <= 0)) {
        y.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
      }
      this.vDM = locala1.pyp;
      y.d("MicroMsg.ChattingItemCardTo", "dancy is biz: %s, userName: %s ", new Object[] { Boolean.valueOf(com.tencent.mm.model.s.hl(this.vDM)), this.vDM });
      s.a.Y(locala.igg, locala.vBZ);
      label173:
      int i;
      if (com.tencent.mm.model.s.hI(locala1.qZn))
      {
        locala.vDK.setText(R.l.chatting_biz_card);
        locala.vDL.setVisibility(8);
        if (com.tencent.mm.compatible.util.d.gF(16))
        {
          locala.vDJ.setBackground(null);
          s(locala.vDJ, this.vDM);
          locala.doV.setText(j.a(parama1.vtz.getContext(), locala1.nickname, locala.doV.getTextSize()));
          parama = locala1.cMT;
          if (ah.bl(this.vDM)) {
            break label598;
          }
          au.Hx();
          paramString = com.tencent.mm.model.c.Fw().abl(this.vDM);
          if ((paramString == null) || (!com.tencent.mm.n.a.gR(paramString.field_type))) {
            break label598;
          }
          ad.ctZ();
          i = 0;
          label261:
          if ((i != 0) || (!ah.bl(parama))) {
            break label686;
          }
          paramString = this.vDM;
          i = j;
          parama = paramString;
          if (!ah.bl(paramString))
          {
            i = j;
            parama = paramString;
            if (!ad.aaX(paramString))
            {
              if (!com.tencent.mm.model.s.hj(paramString)) {
                break label604;
              }
              parama = paramString;
              i = j;
            }
          }
        }
      }
      label647:
      label686:
      for (;;)
      {
        label324:
        boolean bool = com.tencent.mm.model.s.hI(locala1.qZn);
        if ((i != 0) || (bool)) {
          parama = "";
        }
        if (!ah.bl(parama))
        {
          locala.vDL.setVisibility(0);
          locala.vDL.setText(parama);
          label373:
          s.a(parama1, this.vDM, locala1, locala);
          locala.igg.setTag(new aw(parambi, parama1.cFE(), paramInt, null, '\000'));
          locala.igg.setOnClickListener(d(parama1));
          locala.igg.setOnLongClickListener(c(parama1));
          locala.igg.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
          if (!cHc()) {
            break label647;
          }
          if (locala.nhQ != null) {
            locala.nhQ.setVisibility(8);
          }
          if ((parambi.field_status != 2) || (!a((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class), parambi.field_msgId))) {
            break label626;
          }
          if (locala.vBN != null) {
            locala.vBN.setVisibility(0);
          }
        }
        for (;;)
        {
          a(paramInt, locala, parambi, parama1.cFB(), parama1.cFE(), parama1, this);
          return;
          locala.vDJ.setBackgroundDrawable(null);
          break;
          locala.vDK.setText(R.l.chatting_personal_card);
          locala.vDJ.setBackgroundResource(R.g.default_avatar);
          r(locala.vDJ, this.vDM);
          break label173;
          label598:
          i = 1;
          break label261;
          label604:
          i = 0;
          parama = paramString;
          break label324;
          locala.vDL.setVisibility(8);
          break label373;
          label626:
          if (locala.vBN != null)
          {
            locala.vBN.setVisibility(8);
            continue;
            if (locala.nhQ != null)
            {
              locala.nhQ.setVisibility(0);
              if (parambi.field_status >= 2) {
                locala.nhQ.setVisibility(8);
              }
            }
          }
        }
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
    {
      int i = ((aw)paramView.getTag()).position;
      au.Hx();
      bi.a locala = com.tencent.mm.model.c.Fy().HN(parambi.field_content);
      if ((locala.pyp == null) || (locala.pyp.length() <= 0)) {
        y.e("MicroMsg.ChattingItemCardTo", "getView : parse possible friend msg failed");
      }
      this.vDM = locala.pyp;
      if (com.tencent.mm.model.s.hI(locala.qZn)) {
        paramContextMenu.add(i, 118, 0, paramView.getContext().getString(R.l.retransmit));
      }
      if ((!parambi.ctz()) && ((parambi.field_status == 2) || (parambi.cQJ == 1)) && (parambi.cvn()) && (a(parambi, this.vko)) && (adG(parambi.field_talker))) {
        paramContextMenu.add(i, 123, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_revoke_msg));
      }
      if (!this.vko.cFF()) {
        paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
      }
      return true;
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
    {
      switch (paramMenuItem.getItemId())
      {
      default: 
        return false;
      }
      paramMenuItem = new Intent(parama.vtz.getContext(), MsgRetransmitUI.class);
      paramMenuItem.putExtra("Retr_Msg_content", com.tencent.mm.model.bd.b(parama.cFE(), parambi.field_content, parambi.field_isSend));
      paramMenuItem.putExtra("Retr_Msg_Type", 8);
      paramMenuItem.putExtra("Retr_Msg_Id", parambi.field_msgId);
      parama.startActivity(paramMenuItem);
      return false;
    }
    
    public final boolean au(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && ((paramInt == 42) || (paramInt == 66));
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
    {
      paramView = (aw)paramView.getTag();
      String str1 = paramView.userName;
      String str2 = parambi.field_content;
      boolean bool2 = paramView.vgB;
      if (parambi.field_isSend == 0) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        s.a(parama, str1, str2, bool2, bool1);
        return true;
      }
    }
    
    public final boolean bfO()
    {
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.s
 * JD-Core Version:    0.7.0.1
 */