package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.a;
import com.tencent.mm.storage.bu.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.contact.e;
import junit.framework.Assert;

public final class al$a
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JBI;
  
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
      ((View)localObject).setTag(new al.b().gI((View)localObject));
    }
    AppMethodBeat.o(37295);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(37296);
    this.JBI = parama1;
    al.b localb = (al.b)parama;
    if (parambu.getType() == 37)
    {
      ba.aBQ();
      parama = com.tencent.mm.model.c.azs().aqj(parambu.field_content);
      if ((parama == null) || (parama.dHm == null) || (parama.dHm.length() <= 0))
      {
        ad.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse verify msg failed");
        AppMethodBeat.o(37296);
        return;
      }
      com.tencent.mm.ak.c.ak(parama.dHm, parama.IMl);
      if (w.zD(parama.dHm))
      {
        localb.KeL.setVisibility(8);
        localb.KeM.setVisibility(8);
        localb.KeN.setVisibility(0);
        localb.KeK.setBackgroundColor(16777215);
        localb.KeN.setText(parama1.JOR.getMMResources().getString(2131759662));
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
          localb.KbH.setText(2131757172);
          label258:
          localb.jpy.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.JOR.getContext(), parama.getDisplayName(), localb.jpy.getTextSize()));
          z(localb.JYo, parama.dHm);
          localb.KeJ.setVisibility(0);
          if ((parama.content != null) && (!parama.content.trim().equals(""))) {
            localb.KeJ.setText(parama.content);
          }
          break;
        }
      }
    }
    for (;;)
    {
      localb.ofK.setTag(new bk(parambu, parama1.fFv(), paramInt, null, '\000'));
      localb.ofK.setOnClickListener(d(parama1));
      localb.ofK.setOnLongClickListener(c(parama1));
      localb.ofK.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
      AppMethodBeat.o(37296);
      return;
      localb.KeL.setVisibility(0);
      localb.KeM.setVisibility(0);
      localb.KeN.setVisibility(0);
      localb.KeK.setBackgroundResource(2131231692);
      localb.KeN.setText(parama1.JOR.getMMResources().getString(2131759661));
      break;
      localb.KbH.setText(2131757176);
      break label258;
      localb.KbH.setText(2131757178);
      break label258;
      localb.KbH.setText(2131762130);
      break label258;
      localb.KbH.setText(2131757171);
      break label258;
      paramString = com.tencent.mm.plugin.account.a.getAddrUploadStg().Ju(parama.dHm);
      if ((paramString != null) && (paramString.aSy() != null) && (!paramString.aSy().equals("")))
      {
        localb.KeO.setVisibility(0);
        localb.KeO.setText(parama1.JOR.getMMResources().getString(2131757164, new Object[] { paramString.aSy() }));
        break label258;
      }
      localb.KeO.setVisibility(8);
      break label258;
      localb.KeJ.setText(parama1.JOR.getMMResources().getString(2131757177));
      continue;
      if (parambu.getType() == 40)
      {
        ba.aBQ();
        bu.a locala = com.tencent.mm.model.c.azs().aqk(parambu.field_content);
        if ((locala == null) || (locala.dHm == null) || (locala.dHm.length() <= 0))
        {
          ad.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse possible friend msg failed");
          AppMethodBeat.o(37296);
          return;
        }
        com.tencent.mm.ak.c.ak(locala.dHm, locala.IMl);
        if (w.zD(locala.dHm))
        {
          localb.KeL.setVisibility(8);
          localb.KeM.setVisibility(8);
          localb.KeN.setVisibility(0);
          localb.KeK.setBackgroundColor(16777215);
          localb.KeN.setText(parama1.JOR.getMMResources().getString(2131759662));
          label810:
          switch (locala.scene)
          {
          default: 
            ad.d("MicroMsg.ChattingItemFMessageFrom", "prossible friend sceneType:%d", new Object[] { Integer.valueOf(locala.scene) });
            localb.KbH.setText(2131757167);
            localb.KeJ.setText(2131757168);
            localb.jpy.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.JOR.getContext(), locala.getDisplayName(), localb.jpy.getTextSize()));
          }
        }
        for (;;)
        {
          z(localb.JYo, locala.dHm);
          break;
          localb.KeL.setVisibility(0);
          localb.KeM.setVisibility(0);
          localb.KeN.setVisibility(0);
          localb.KeK.setBackgroundResource(2131231692);
          localb.KeN.setText(parama1.JOR.getMMResources().getString(2131759661));
          break label810;
          localb.KbH.setText(2131757158);
          localb.KeJ.setText(2131757159);
          paramString = locala.fss();
          parama = paramString;
          if (paramString == null) {
            parama = locala.getDisplayName();
          }
          localb.jpy.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.JOR.getContext(), parama, localb.jpy.getTextSize()));
          continue;
          localb.KbH.setText(2131757163);
          paramString = com.tencent.mm.plugin.account.friend.a.l.JF(locala.IMm);
          parama = paramString;
          if (bt.isNullOrNil(paramString)) {
            parama = com.tencent.mm.plugin.account.friend.a.l.JF(locala.IMn);
          }
          localb.KeJ.setText(parama1.JOR.getMMResources().getString(2131757164, new Object[] { parama }));
          localb.jpy.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.JOR.getContext(), locala.getDisplayName(), localb.jpy.getTextSize()));
          continue;
          localb.KbH.setText(2131757174);
          localb.KeJ.setText(2131757175);
          localb.jpy.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.JOR.getContext(), locala.getDisplayName(), localb.jpy.getTextSize()));
          continue;
          localb.KbH.setText(2131757170);
          localb.KeJ.setText(2131757169);
          localb.jpy.setText(com.tencent.mm.pluginsdk.ui.span.k.b(parama1.JOR.getContext(), locala.getDisplayName(), localb.jpy.getTextSize()));
        }
      }
      ad.w("MicroMsg.ChattingItemFMessageFrom", "FROM_FMESSAGE did not include this type, msgType = " + parambu.getType());
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bu parambu)
  {
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(37297);
    if (parambu.getType() == 37)
    {
      paramView = parambu.field_content;
      ad.w("MicroMsg.ChattingItemFMessageFrom", "dealClickVerifyMsgEvent : ".concat(String.valueOf(paramView)));
      if ((paramView != null) && (paramView.length() > 0)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(37297);
      return true;
      ba.aBQ();
      parambu = com.tencent.mm.model.c.azs().aqj(paramView);
      if (parambu != null)
      {
        boolean bool;
        label85:
        Object localObject;
        if (parambu.dHm.length() > 0)
        {
          bool = true;
          Assert.assertTrue(bool);
          ba.aBQ();
          paramView = com.tencent.mm.model.c.azp().Bf(parambu.dHm);
          localObject = new Intent();
          if ((paramView == null) || ((int)paramView.gfj <= 0) || (!com.tencent.mm.o.b.lM(paramView.field_type))) {
            break label407;
          }
          ((Intent)localObject).putExtra("Contact_User", paramView.field_username);
          e.a((Intent)localObject, paramView.field_username);
          label160:
          parama = parambu.content;
          paramView = parama;
          if (bt.nullAsNil(parama).length() <= 0) {
            switch (parambu.scene)
            {
            }
          }
        }
        for (paramView = this.JBI.JOR.getMMResources().getString(2131757173);; paramView = this.JBI.JOR.getMMResources().getString(2131757177))
        {
          ((Intent)localObject).putExtra("Contact_Content", paramView);
          ((Intent)localObject).putExtra("Contact_verify_Scene", parambu.scene);
          ((Intent)localObject).putExtra("Contact_Uin", parambu.wSt);
          ((Intent)localObject).putExtra("Contact_QQNick", parambu.jeW);
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", parambu.IMm);
          ((Intent)localObject).putExtra("User_From_Fmessage", true);
          ((Intent)localObject).putExtra("Contact_from_msgType", 37);
          ((Intent)localObject).putExtra("Contact_KSnsIFlag", parambu.IMz);
          ((Intent)localObject).putExtra("Contact_KSnsBgUrl", parambu.IMA);
          d.b(this.JBI.JOR.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
          com.tencent.mm.bt.a.Zy(parambu.scene);
          break;
          bool = false;
          break label85;
          label407:
          ((Intent)localObject).putExtra("Verify_ticket", parambu.txJ);
          ((Intent)localObject).putExtra("User_Verify", true);
          ((Intent)localObject).putExtra("Contact_User", parambu.dHm);
          ((Intent)localObject).putExtra("Contact_Alias", parambu.ffB);
          ((Intent)localObject).putExtra("Contact_Nick", parambu.nickname);
          ((Intent)localObject).putExtra("Contact_QuanPin", parambu.jeV);
          ((Intent)localObject).putExtra("Contact_PyInitial", parambu.jeU);
          ((Intent)localObject).putExtra("Contact_Sex", parambu.ePk);
          ((Intent)localObject).putExtra("Contact_Signature", parambu.signature);
          ((Intent)localObject).putExtra("Contact_Scene", parambu.scene);
          ((Intent)localObject).putExtra("Contact_FMessageCard", true);
          ((Intent)localObject).putExtra("Contact_City", parambu.getCity());
          ((Intent)localObject).putExtra("Contact_Province", parambu.getProvince());
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", parambu.IMm);
          ((Intent)localObject).putExtra("Contact_full_Mobile_MD5", parambu.IMn);
          ((Intent)localObject).putExtra("Contact_KSnsIFlag", parambu.IMz);
          ((Intent)localObject).putExtra("Contact_KSnsBgUrl", parambu.IMA);
          break label160;
        }
        if (parambu.getType() == 40)
        {
          paramView = parambu.field_content;
          ba.aBQ();
          parambu = com.tencent.mm.model.c.azs().aqk(paramView);
          if ((parambu != null) && (parambu.dHm.length() > 0))
          {
            com.tencent.mm.bt.a.Zy(parambu.scene);
            ba.aBQ();
            localObject = com.tencent.mm.model.c.azp().Bf(parambu.dHm);
            if ((localObject != null) && ((int)((com.tencent.mm.o.b)localObject).gfj > 0) && (com.tencent.mm.o.b.lM(((aw)localObject).field_type)))
            {
              e.a(this.JBI.JOR.getContext(), (am)localObject, parambu);
            }
            else if ((parambu.wSt <= 0L) && ((!bt.isNullOrNil(parambu.IMm)) || (!bt.isNullOrNil(parambu.IMn))))
            {
              parama = com.tencent.mm.plugin.account.a.getAddrUploadStg().Jx(parambu.IMm);
              if ((parama != null) && (parama.Lb() != null))
              {
                paramView = parama;
                if (parama.Lb().length() > 0) {}
              }
              else
              {
                parama = com.tencent.mm.plugin.account.a.getAddrUploadStg().Jx(parambu.IMn);
                if ((parama != null) && (parama.Lb() != null))
                {
                  paramView = parama;
                  if (parama.Lb().length() > 0) {}
                }
                else
                {
                  if ((localObject != null) && ((int)((com.tencent.mm.o.b)localObject).gfj > 0)) {
                    e.a(this.JBI.JOR.getContext(), (am)localObject, parambu);
                  }
                  for (;;)
                  {
                    ad.e("MicroMsg.ChattingItemFMessageFrom", "error : this is not the mobile contact, MD5 = " + parambu.IMm + " fullMD5:" + parambu.IMn);
                    break;
                    e.a(this.JBI.JOR.getContext(), parambu);
                  }
                }
              }
              if ((paramView.getUsername() == null) || (paramView.getUsername().length() <= 0))
              {
                paramView.username = parambu.dHm;
                paramView.dDp = 128;
                if (com.tencent.mm.plugin.account.a.getAddrUploadStg().a(paramView.Lb(), paramView) == -1)
                {
                  ad.e("MicroMsg.ChattingItemFMessageFrom", "update mobile contact username failed");
                  continue;
                }
              }
              e.a(this.JBI.JOR.getContext(), parambu);
            }
            else
            {
              e.a(this.JBI.JOR.getContext(), parambu);
            }
          }
        }
      }
    }
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return (paramInt == 37) || (paramInt == 40);
  }
  
  protected final boolean fHg()
  {
    return false;
  }
  
  public final boolean fHh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.al.a
 * JD-Core Version:    0.7.0.1
 */