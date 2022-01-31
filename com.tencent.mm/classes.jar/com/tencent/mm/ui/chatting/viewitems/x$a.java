package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.bi.d;
import junit.framework.Assert;

public final class x$a
  extends c
{
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
      localObject = new t(paramLayoutInflater, R.i.chatting_item_from_fmessage);
      ((View)localObject).setTag(new x.b().dX((View)localObject));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    x.b localb = (x.b)parama;
    if (parambi.getType() == 37)
    {
      au.Hx();
      parama = com.tencent.mm.model.c.Fy().HM(parambi.field_content);
      if ((parama == null) || (parama.pyp == null) || (parama.pyp.length() <= 0))
      {
        y.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse verify msg failed");
        return;
      }
      com.tencent.mm.ag.b.M(parama.pyp, parama.uBV);
      if (s.hk(parama.pyp))
      {
        localb.vEE.setVisibility(8);
        localb.vEF.setVisibility(8);
        localb.vEG.setVisibility(0);
        localb.vED.setBackgroundColor(16777215);
        localb.vEG.setText(parama1.vtz.getMMResources().getString(R.l.friend_added));
        switch (parama.scene)
        {
        case 14: 
        case 15: 
        case 16: 
        case 17: 
        case 19: 
        case 20: 
        case 21: 
        default: 
          localb.vDK.setText(R.l.chatting_from_verify_contact);
          label251:
          localb.frb.setText(j.a(parama1.vtz.getContext(), parama.getDisplayName(), localb.frb.getTextSize()));
          r(localb.doU, parama.pyp);
          localb.vEC.setVisibility(0);
          if ((parama.content != null) && (!parama.content.trim().equals(""))) {
            localb.vEC.setText(parama.content);
          }
          break;
        }
      }
    }
    for (;;)
    {
      localb.igg.setTag(new aw(parambi, parama1.cFE(), paramInt, null, '\000'));
      localb.igg.setOnClickListener(d(parama1));
      localb.igg.setOnLongClickListener(c(parama1));
      localb.igg.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g)parama1.ac(com.tencent.mm.ui.chatting.b.b.g.class)).cDu());
      return;
      localb.vEE.setVisibility(0);
      localb.vEF.setVisibility(0);
      localb.vEG.setVisibility(0);
      localb.vED.setBackgroundResource(R.g.chatting_item_multi_bottom);
      localb.vEG.setText(parama1.vtz.getMMResources().getString(R.l.friend_add));
      break;
      localb.vDK.setText(R.l.chatting_from_verify_lbs);
      break label251;
      localb.vDK.setText(R.l.chatting_from_verify_shake);
      break label251;
      localb.vDK.setText(R.l.qrcode_sayhi_from);
      break label251;
      localb.vDK.setText(R.l.chatting_from_verify_bottle);
      break label251;
      paramString = com.tencent.mm.plugin.account.b.getAddrUploadStg().pH(parama.pyp);
      if ((paramString != null) && (paramString.Wx() != null) && (!paramString.Wx().equals("")))
      {
        localb.vEH.setVisibility(0);
        localb.vEH.setText(parama1.vtz.getMMResources().getString(R.l.chatting_from_mobile_friends_content, new Object[] { paramString.Wx() }));
        break label251;
      }
      localb.vEH.setVisibility(8);
      break label251;
      localb.vEC.setText(parama1.vtz.getMMResources().getString(R.l.chatting_from_verify_lbs_tip));
      continue;
      if (parambi.getType() == 40)
      {
        au.Hx();
        bi.a locala = com.tencent.mm.model.c.Fy().HN(parambi.field_content);
        if ((locala == null) || (locala.pyp == null) || (locala.pyp.length() <= 0))
        {
          y.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse possible friend msg failed");
          return;
        }
        com.tencent.mm.ag.b.M(locala.pyp, locala.uBV);
        if (s.hk(locala.pyp))
        {
          localb.vEE.setVisibility(8);
          localb.vEF.setVisibility(8);
          localb.vEG.setVisibility(0);
          localb.vED.setBackgroundColor(16777215);
          localb.vEG.setText(parama1.vtz.getMMResources().getString(R.l.friend_added));
          label794:
          switch (locala.scene)
          {
          default: 
            y.d("MicroMsg.ChattingItemFMessageFrom", "prossible friend sceneType:%d", new Object[] { Integer.valueOf(locala.scene) });
            localb.vDK.setText(R.l.chatting_from_possible_friends);
            localb.vEC.setText(R.l.chatting_from_possible_friends_content);
            localb.frb.setText(j.a(parama1.vtz.getContext(), locala.getDisplayName(), localb.frb.getTextSize()));
          }
        }
        for (;;)
        {
          r(localb.doU, locala.pyp);
          break;
          localb.vEE.setVisibility(0);
          localb.vEF.setVisibility(0);
          localb.vEG.setVisibility(0);
          localb.vED.setBackgroundResource(R.g.chatting_item_multi_bottom);
          localb.vEG.setText(parama1.vtz.getMMResources().getString(R.l.friend_add));
          break label794;
          localb.vDK.setText(R.l.chatting_from_QQ_friends);
          localb.vEC.setText(R.l.chatting_from_QQ_friends_content);
          paramString = locala.cvM();
          parama = paramString;
          if (paramString == null) {
            parama = locala.getDisplayName();
          }
          localb.frb.setText(j.a(parama1.vtz.getContext(), parama, localb.frb.getTextSize()));
          continue;
          localb.vDK.setText(R.l.chatting_from_mobile_friends);
          paramString = l.pO(locala.uBW);
          parama = paramString;
          if (ah.bl(paramString)) {
            parama = l.pO(locala.uBX);
          }
          localb.vEC.setText(parama1.vtz.getMMResources().getString(R.l.chatting_from_mobile_friends_content, new Object[] { parama }));
          localb.frb.setText(j.a(parama1.vtz.getContext(), locala.getDisplayName(), localb.frb.getTextSize()));
          continue;
          localb.vDK.setText(R.l.chatting_from_verify_facebook);
          localb.vEC.setText(R.l.chatting_from_verify_facebook_content);
          localb.frb.setText(j.a(parama1.vtz.getContext(), locala.getDisplayName(), localb.frb.getTextSize()));
          continue;
          localb.vDK.setText(R.l.chatting_from_sns_tip);
          localb.vEC.setText(R.l.chatting_from_sns_add_now);
          localb.frb.setText(j.a(parama1.vtz.getContext(), locala.getDisplayName(), localb.frb.getTextSize()));
        }
      }
      y.w("MicroMsg.ChattingItemFMessageFrom", "FROM_FMESSAGE did not include this type, msgType = " + parambi.getType());
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (paramInt == 37) || (paramInt == 40);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    if (parambi.getType() == 37)
    {
      paramView = parambi.field_content;
      y.w("MicroMsg.ChattingItemFMessageFrom", "dealClickVerifyMsgEvent : " + paramView);
      if ((paramView != null) && (paramView.length() > 0)) {}
    }
    label155:
    do
    {
      do
      {
        do
        {
          return true;
          au.Hx();
          parambi = com.tencent.mm.model.c.Fy().HM(paramView);
        } while (parambi == null);
        boolean bool;
        if (parambi.pyp.length() > 0)
        {
          bool = true;
          Assert.assertTrue(bool);
          au.Hx();
          paramView = com.tencent.mm.model.c.Fw().abl(parambi.pyp);
          localObject = new Intent();
          if ((paramView == null) || ((int)paramView.dBe <= 0) || (!com.tencent.mm.n.a.gR(paramView.field_type))) {
            break label402;
          }
          ((Intent)localObject).putExtra("Contact_User", paramView.field_username);
          com.tencent.mm.ui.contact.e.a((Intent)localObject, paramView.field_username);
          parama = parambi.content;
          paramView = parama;
          if (ah.pm(parama).length() <= 0) {
            switch (parambi.scene)
            {
            }
          }
        }
        for (paramView = this.vko.vtz.getMMResources().getString(R.l.chatting_from_verify_contact_tip);; paramView = this.vko.vtz.getMMResources().getString(R.l.chatting_from_verify_lbs_tip))
        {
          ((Intent)localObject).putExtra("Contact_Content", paramView);
          ((Intent)localObject).putExtra("Contact_verify_Scene", parambi.scene);
          ((Intent)localObject).putExtra("Contact_Uin", parambi.mXV);
          ((Intent)localObject).putExtra("Contact_QQNick", parambi.fhb);
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", parambi.uBW);
          ((Intent)localObject).putExtra("User_From_Fmessage", true);
          ((Intent)localObject).putExtra("Contact_from_msgType", 37);
          ((Intent)localObject).putExtra("Contact_KSnsIFlag", parambi.uCj);
          ((Intent)localObject).putExtra("Contact_KSnsBgUrl", parambi.uCk);
          d.b(this.vko.vtz.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
          com.tencent.mm.bs.a.EA(parambi.scene);
          return true;
          bool = false;
          break;
          ((Intent)localObject).putExtra("Verify_ticket", parambi.kzG);
          ((Intent)localObject).putExtra("User_Verify", true);
          ((Intent)localObject).putExtra("Contact_User", parambi.pyp);
          ((Intent)localObject).putExtra("Contact_Alias", parambi.cMT);
          ((Intent)localObject).putExtra("Contact_Nick", parambi.nickname);
          ((Intent)localObject).putExtra("Contact_QuanPin", parambi.fha);
          ((Intent)localObject).putExtra("Contact_PyInitial", parambi.fgZ);
          ((Intent)localObject).putExtra("Contact_Sex", parambi.sex);
          ((Intent)localObject).putExtra("Contact_Signature", parambi.signature);
          ((Intent)localObject).putExtra("Contact_Scene", parambi.scene);
          ((Intent)localObject).putExtra("Contact_FMessageCard", true);
          ((Intent)localObject).putExtra("Contact_City", parambi.getCity());
          ((Intent)localObject).putExtra("Contact_Province", parambi.getProvince());
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", parambi.uBW);
          ((Intent)localObject).putExtra("Contact_full_Mobile_MD5", parambi.uBX);
          ((Intent)localObject).putExtra("Contact_KSnsIFlag", parambi.uCj);
          ((Intent)localObject).putExtra("Contact_KSnsBgUrl", parambi.uCk);
          break label155;
        }
      } while (parambi.getType() != 40);
      paramView = parambi.field_content;
      au.Hx();
      parambi = com.tencent.mm.model.c.Fy().HN(paramView);
    } while ((parambi == null) || (parambi.pyp.length() <= 0));
    label402:
    com.tencent.mm.bs.a.EA(parambi.scene);
    au.Hx();
    Object localObject = com.tencent.mm.model.c.Fw().abl(parambi.pyp);
    if ((localObject != null) && ((int)((com.tencent.mm.n.a)localObject).dBe > 0) && (com.tencent.mm.n.a.gR(((ao)localObject).field_type)))
    {
      com.tencent.mm.ui.contact.e.a(this.vko.vtz.getContext(), (ad)localObject, parambi);
      return true;
    }
    if ((parambi.mXV <= 0L) && ((!ah.bl(parambi.uBW)) || (!ah.bl(parambi.uBX))))
    {
      parama = com.tencent.mm.plugin.account.b.getAddrUploadStg().pI(parambi.uBW);
      if ((parama != null) && (parama.Wv() != null))
      {
        paramView = parama;
        if (parama.Wv().length() > 0) {}
      }
      else
      {
        parama = com.tencent.mm.plugin.account.b.getAddrUploadStg().pI(parambi.uBX);
        if ((parama != null) && (parama.Wv() != null))
        {
          paramView = parama;
          if (parama.Wv().length() > 0) {}
        }
        else
        {
          if ((localObject != null) && ((int)((com.tencent.mm.n.a)localObject).dBe > 0)) {
            com.tencent.mm.ui.contact.e.a(this.vko.vtz.getContext(), (ad)localObject, parambi);
          }
          for (;;)
          {
            y.e("MicroMsg.ChattingItemFMessageFrom", "error : this is not the mobile contact, MD5 = " + parambi.uBW + " fullMD5:" + parambi.uBX);
            return true;
            com.tencent.mm.ui.contact.e.a(this.vko.vtz.getContext(), parambi);
          }
        }
      }
      if ((paramView.getUsername() == null) || (paramView.getUsername().length() <= 0))
      {
        paramView.username = parambi.pyp;
        paramView.bcw = 128;
        if (com.tencent.mm.plugin.account.b.getAddrUploadStg().a(paramView.Wv(), paramView) == -1)
        {
          y.e("MicroMsg.ChattingItemFMessageFrom", "update mobile contact username failed");
          return true;
        }
      }
      com.tencent.mm.ui.contact.e.a(this.vko.vtz.getContext(), parambi);
      return true;
    }
    com.tencent.mm.ui.contact.e.a(this.vko.vtz.getContext(), parambi);
    return true;
  }
  
  public final boolean bfO()
  {
    return false;
  }
  
  protected final boolean cHb()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.x.a
 * JD-Core Version:    0.7.0.1
 */