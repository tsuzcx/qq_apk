package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.storage.bv.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.contact.e;
import junit.framework.Assert;

public final class al$a
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37295);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131493454);
      ((View)localObject).setTag(new al.b().gN((View)localObject));
    }
    AppMethodBeat.o(37295);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37296);
    this.JWz = parama1;
    al.b localb = (al.b)parama;
    if (parambv.getType() == 37)
    {
      bc.aCg();
      parama = com.tencent.mm.model.c.azI().aro(parambv.field_content);
      if ((parama == null) || (parama.cUA == null) || (parama.cUA.length() <= 0))
      {
        ae.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse verify msg failed");
        AppMethodBeat.o(37296);
        return;
      }
      com.tencent.mm.aj.c.al(parama.cUA, parama.JgS);
      if (x.An(parama.cUA))
      {
        localb.KBe.setVisibility(8);
        localb.KBf.setVisibility(8);
        localb.KBg.setVisibility(0);
        localb.KBd.setBackgroundColor(16777215);
        localb.KBg.setText(parama1.Kkd.getMMResources().getString(2131759662));
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
          localb.KxZ.setText(2131757172);
          label258:
          localb.jsr.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.Kkd.getContext(), parama.getDisplayName(), localb.jsr.getTextSize()));
          z(localb.KuH, parama.cUA);
          localb.KBc.setVisibility(0);
          if ((parama.content != null) && (!parama.content.trim().equals(""))) {
            localb.KBc.setText(parama.content);
          }
          break;
        }
      }
    }
    for (;;)
    {
      localb.olI.setTag(new bk(parambv, parama1.fJC(), paramInt, null, '\000'));
      localb.olI.setOnClickListener(d(parama1));
      localb.olI.setOnLongClickListener(c(parama1));
      localb.olI.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
      AppMethodBeat.o(37296);
      return;
      localb.KBe.setVisibility(0);
      localb.KBf.setVisibility(0);
      localb.KBg.setVisibility(0);
      localb.KBd.setBackgroundResource(2131231692);
      localb.KBg.setText(parama1.Kkd.getMMResources().getString(2131759661));
      break;
      localb.KxZ.setText(2131757176);
      break label258;
      localb.KxZ.setText(2131757178);
      break label258;
      localb.KxZ.setText(2131762130);
      break label258;
      localb.KxZ.setText(2131757171);
      break label258;
      paramString = com.tencent.mm.plugin.account.a.getAddrUploadStg().JT(parama.cUA);
      if ((paramString != null) && (paramString.aSX() != null) && (!paramString.aSX().equals("")))
      {
        localb.KBh.setVisibility(0);
        localb.KBh.setText(parama1.Kkd.getMMResources().getString(2131757164, new Object[] { paramString.aSX() }));
        break label258;
      }
      localb.KBh.setVisibility(8);
      break label258;
      localb.KBc.setText(parama1.Kkd.getMMResources().getString(2131757177));
      continue;
      if (parambv.getType() == 40)
      {
        bc.aCg();
        bv.a locala = com.tencent.mm.model.c.azI().arp(parambv.field_content);
        if ((locala == null) || (locala.cUA == null) || (locala.cUA.length() <= 0))
        {
          ae.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse possible friend msg failed");
          AppMethodBeat.o(37296);
          return;
        }
        com.tencent.mm.aj.c.al(locala.cUA, locala.JgS);
        if (x.An(locala.cUA))
        {
          localb.KBe.setVisibility(8);
          localb.KBf.setVisibility(8);
          localb.KBg.setVisibility(0);
          localb.KBd.setBackgroundColor(16777215);
          localb.KBg.setText(parama1.Kkd.getMMResources().getString(2131759662));
          label810:
          switch (locala.scene)
          {
          default: 
            ae.d("MicroMsg.ChattingItemFMessageFrom", "prossible friend sceneType:%d", new Object[] { Integer.valueOf(locala.scene) });
            localb.KxZ.setText(2131757167);
            localb.KBc.setText(2131757168);
            localb.jsr.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.Kkd.getContext(), locala.getDisplayName(), localb.jsr.getTextSize()));
          }
        }
        for (;;)
        {
          z(localb.KuH, locala.cUA);
          break;
          localb.KBe.setVisibility(0);
          localb.KBf.setVisibility(0);
          localb.KBg.setVisibility(0);
          localb.KBd.setBackgroundResource(2131231692);
          localb.KBg.setText(parama1.Kkd.getMMResources().getString(2131759661));
          break label810;
          localb.KxZ.setText(2131757158);
          localb.KBc.setText(2131757159);
          paramString = locala.fwt();
          parama = paramString;
          if (paramString == null) {
            parama = locala.getDisplayName();
          }
          localb.jsr.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.Kkd.getContext(), parama, localb.jsr.getTextSize()));
          continue;
          localb.KxZ.setText(2131757163);
          paramString = com.tencent.mm.plugin.account.friend.a.l.Ke(locala.JgT);
          parama = paramString;
          if (bu.isNullOrNil(paramString)) {
            parama = com.tencent.mm.plugin.account.friend.a.l.Ke(locala.JgU);
          }
          localb.KBc.setText(parama1.Kkd.getMMResources().getString(2131757164, new Object[] { parama }));
          localb.jsr.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.Kkd.getContext(), locala.getDisplayName(), localb.jsr.getTextSize()));
          continue;
          localb.KxZ.setText(2131757174);
          localb.KBc.setText(2131757175);
          localb.jsr.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.Kkd.getContext(), locala.getDisplayName(), localb.jsr.getTextSize()));
          continue;
          localb.KxZ.setText(2131757170);
          localb.KBc.setText(2131757169);
          localb.jsr.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.Kkd.getContext(), locala.getDisplayName(), localb.jsr.getTextSize()));
        }
      }
      ae.w("MicroMsg.ChattingItemFMessageFrom", "FROM_FMESSAGE did not include this type, msgType = " + parambv.getType());
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bv parambv)
  {
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37297);
    if (parambv.getType() == 37)
    {
      paramView = parambv.field_content;
      ae.w("MicroMsg.ChattingItemFMessageFrom", "dealClickVerifyMsgEvent : ".concat(String.valueOf(paramView)));
      if ((paramView != null) && (paramView.length() > 0)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(37297);
      return true;
      bc.aCg();
      parambv = com.tencent.mm.model.c.azI().aro(paramView);
      if (parambv != null)
      {
        boolean bool;
        label85:
        Object localObject;
        if (parambv.cUA.length() > 0)
        {
          bool = true;
          Assert.assertTrue(bool);
          bc.aCg();
          paramView = com.tencent.mm.model.c.azF().BH(parambv.cUA);
          localObject = new Intent();
          if ((paramView == null) || ((int)paramView.ght <= 0) || (!com.tencent.mm.contact.c.lO(paramView.field_type))) {
            break label407;
          }
          ((Intent)localObject).putExtra("Contact_User", paramView.field_username);
          e.a((Intent)localObject, paramView.field_username);
          label160:
          parama = parambv.content;
          paramView = parama;
          if (bu.nullAsNil(parama).length() <= 0) {
            switch (parambv.scene)
            {
            }
          }
        }
        for (paramView = this.JWz.Kkd.getMMResources().getString(2131757173);; paramView = this.JWz.Kkd.getMMResources().getString(2131757177))
        {
          ((Intent)localObject).putExtra("Contact_Content", paramView);
          ((Intent)localObject).putExtra("Contact_verify_Scene", parambv.scene);
          ((Intent)localObject).putExtra("Contact_Uin", parambv.xik);
          ((Intent)localObject).putExtra("Contact_QQNick", parambv.jhP);
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", parambv.JgT);
          ((Intent)localObject).putExtra("User_From_Fmessage", true);
          ((Intent)localObject).putExtra("Contact_from_msgType", 37);
          ((Intent)localObject).putExtra("Contact_KSnsIFlag", parambv.Jhg);
          ((Intent)localObject).putExtra("Contact_KSnsBgUrl", parambv.Jhh);
          d.b(this.JWz.Kkd.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
          com.tencent.mm.bs.a.aae(parambv.scene);
          break;
          bool = false;
          break label85;
          label407:
          ((Intent)localObject).putExtra("Verify_ticket", parambv.tIA);
          ((Intent)localObject).putExtra("User_Verify", true);
          ((Intent)localObject).putExtra("Contact_User", parambv.cUA);
          ((Intent)localObject).putExtra("Contact_Alias", parambv.fhy);
          ((Intent)localObject).putExtra("Contact_Nick", parambv.nickname);
          ((Intent)localObject).putExtra("Contact_QuanPin", parambv.jhO);
          ((Intent)localObject).putExtra("Contact_PyInitial", parambv.jhN);
          ((Intent)localObject).putExtra("Contact_Sex", parambv.eQV);
          ((Intent)localObject).putExtra("Contact_Signature", parambv.signature);
          ((Intent)localObject).putExtra("Contact_Scene", parambv.scene);
          ((Intent)localObject).putExtra("Contact_FMessageCard", true);
          ((Intent)localObject).putExtra("Contact_City", parambv.getCity());
          ((Intent)localObject).putExtra("Contact_Province", parambv.getProvince());
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", parambv.JgT);
          ((Intent)localObject).putExtra("Contact_full_Mobile_MD5", parambv.JgU);
          ((Intent)localObject).putExtra("Contact_KSnsIFlag", parambv.Jhg);
          ((Intent)localObject).putExtra("Contact_KSnsBgUrl", parambv.Jhh);
          break label160;
        }
        if (parambv.getType() == 40)
        {
          paramView = parambv.field_content;
          bc.aCg();
          parambv = com.tencent.mm.model.c.azI().arp(paramView);
          if ((parambv != null) && (parambv.cUA.length() > 0))
          {
            com.tencent.mm.bs.a.aae(parambv.scene);
            bc.aCg();
            localObject = com.tencent.mm.model.c.azF().BH(parambv.cUA);
            if ((localObject != null) && ((int)((com.tencent.mm.contact.c)localObject).ght > 0) && (com.tencent.mm.contact.c.lO(((aw)localObject).field_type)))
            {
              e.a(this.JWz.Kkd.getContext(), (an)localObject, parambv);
            }
            else if ((parambv.xik <= 0L) && ((!bu.isNullOrNil(parambv.JgT)) || (!bu.isNullOrNil(parambv.JgU))))
            {
              parama = com.tencent.mm.plugin.account.a.getAddrUploadStg().JW(parambv.JgT);
              if ((parama != null) && (parama.Lj() != null))
              {
                paramView = parama;
                if (parama.Lj().length() > 0) {}
              }
              else
              {
                parama = com.tencent.mm.plugin.account.a.getAddrUploadStg().JW(parambv.JgU);
                if ((parama != null) && (parama.Lj() != null))
                {
                  paramView = parama;
                  if (parama.Lj().length() > 0) {}
                }
                else
                {
                  if ((localObject != null) && ((int)((com.tencent.mm.contact.c)localObject).ght > 0)) {
                    e.a(this.JWz.Kkd.getContext(), (an)localObject, parambv);
                  }
                  for (;;)
                  {
                    ae.e("MicroMsg.ChattingItemFMessageFrom", "error : this is not the mobile contact, MD5 = " + parambv.JgT + " fullMD5:" + parambv.JgU);
                    break;
                    e.a(this.JWz.Kkd.getContext(), parambv);
                  }
                }
              }
              if ((paramView.getUsername() == null) || (paramView.getUsername().length() <= 0))
              {
                paramView.username = parambv.cUA;
                paramView.dEu = 128;
                if (com.tencent.mm.plugin.account.a.getAddrUploadStg().a(paramView.Lj(), paramView) == -1)
                {
                  ae.e("MicroMsg.ChattingItemFMessageFrom", "update mobile contact username failed");
                  continue;
                }
              }
              e.a(this.JWz.Kkd.getContext(), parambv);
            }
            else
            {
              e.a(this.JWz.Kkd.getContext(), parambv);
            }
          }
        }
      }
    }
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return (paramInt == 37) || (paramInt == 40);
  }
  
  protected final boolean fLy()
  {
    return false;
  }
  
  public final boolean fLz()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.al.a
 * JD-Core Version:    0.7.0.1
 */