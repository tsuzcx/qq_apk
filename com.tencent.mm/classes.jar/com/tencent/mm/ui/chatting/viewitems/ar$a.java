package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.storage.ca.d;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.contact.e;
import junit.framework.Assert;

public final class ar$a
  extends c
{
  private com.tencent.mm.ui.chatting.e.a PhN;
  
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
      localObject = new an(paramLayoutInflater, 2131493555);
      ((View)localObject).setTag(new ar.b().hd((View)localObject));
    }
    AppMethodBeat.o(37295);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37296);
    this.PhN = parama1;
    ar.b localb = (ar.b)parama;
    if (paramca.getType() == 37)
    {
      bg.aVF();
      parama = com.tencent.mm.model.c.aSQ().aEJ(paramca.field_content);
      if ((parama == null) || (parama.dkU == null) || (parama.dkU.length() <= 0))
      {
        Log.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse verify msg failed");
        AppMethodBeat.o(37296);
        return;
      }
      com.tencent.mm.aj.c.ap(parama.dkU, parama.OqJ);
      if (ab.IS(parama.dkU))
      {
        localb.PNM.setVisibility(8);
        localb.PNN.setVisibility(8);
        localb.PNO.setVisibility(0);
        localb.PNL.setBackgroundColor(16777215);
        localb.PNO.setText(parama1.Pwc.getMMResources().getString(2131760983));
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
          localb.PKu.setText(2131757376);
          label258:
          localb.kqG.setText(com.tencent.mm.pluginsdk.ui.span.l.b(parama1.Pwc.getContext(), parama.getDisplayName(), localb.kqG.getTextSize()));
          D(localb.avatarIV, parama.dkU);
          localb.PNK.setVisibility(0);
          if ((parama.content != null) && (!parama.content.trim().equals(""))) {
            localb.PNK.setText(parama.content);
          }
          break;
        }
      }
    }
    for (;;)
    {
      localb.clickArea.setTag(new bq(paramca, parama1.gRM(), paramInt, null, '\000'));
      localb.clickArea.setOnClickListener(d(parama1));
      localb.clickArea.setOnLongClickListener(c(parama1));
      localb.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
      AppMethodBeat.o(37296);
      return;
      localb.PNM.setVisibility(0);
      localb.PNN.setVisibility(0);
      localb.PNO.setVisibility(0);
      localb.PNL.setBackgroundResource(2131231759);
      localb.PNO.setText(parama1.Pwc.getMMResources().getString(2131760982));
      break;
      localb.PKu.setText(2131757380);
      break label258;
      localb.PKu.setText(2131757382);
      break label258;
      localb.PKu.setText(2131764151);
      break label258;
      localb.PKu.setText(2131757375);
      break label258;
      paramString = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(parama.dkU);
      if ((paramString != null) && (paramString.bnK() != null) && (!paramString.bnK().equals("")))
      {
        localb.PNP.setVisibility(0);
        localb.PNP.setText(parama1.Pwc.getMMResources().getString(2131757368, new Object[] { paramString.bnK() }));
        break label258;
      }
      localb.PNP.setVisibility(8);
      break label258;
      localb.PNK.setText(parama1.Pwc.getMMResources().getString(2131757381));
      continue;
      if (paramca.getType() == 40)
      {
        bg.aVF();
        ca.a locala = com.tencent.mm.model.c.aSQ().aEK(paramca.field_content);
        if ((locala == null) || (locala.dkU == null) || (locala.dkU.length() <= 0))
        {
          Log.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse possible friend msg failed");
          AppMethodBeat.o(37296);
          return;
        }
        com.tencent.mm.aj.c.ap(locala.dkU, locala.OqJ);
        if (ab.IS(locala.dkU))
        {
          localb.PNM.setVisibility(8);
          localb.PNN.setVisibility(8);
          localb.PNO.setVisibility(0);
          localb.PNL.setBackgroundColor(16777215);
          localb.PNO.setText(parama1.Pwc.getMMResources().getString(2131760983));
          label810:
          switch (locala.scene)
          {
          default: 
            Log.d("MicroMsg.ChattingItemFMessageFrom", "prossible friend sceneType:%d", new Object[] { Integer.valueOf(locala.scene) });
            localb.PKu.setText(2131757371);
            localb.PNK.setText(2131757372);
            localb.kqG.setText(com.tencent.mm.pluginsdk.ui.span.l.b(parama1.Pwc.getContext(), locala.getDisplayName(), localb.kqG.getTextSize()));
          }
        }
        for (;;)
        {
          D(localb.avatarIV, locala.dkU);
          break;
          localb.PNM.setVisibility(0);
          localb.PNN.setVisibility(0);
          localb.PNO.setVisibility(0);
          localb.PNL.setBackgroundResource(2131231759);
          localb.PNO.setText(parama1.Pwc.getMMResources().getString(2131760982));
          break label810;
          localb.PKu.setText(2131757362);
          localb.PNK.setText(2131757363);
          paramString = locala.gDZ();
          parama = paramString;
          if (paramString == null) {
            parama = locala.getDisplayName();
          }
          localb.kqG.setText(com.tencent.mm.pluginsdk.ui.span.l.b(parama1.Pwc.getContext(), parama, localb.kqG.getTextSize()));
          continue;
          localb.PKu.setText(2131757367);
          paramString = com.tencent.mm.plugin.account.friend.a.l.Tc(locala.OqK);
          parama = paramString;
          if (Util.isNullOrNil(paramString)) {
            parama = com.tencent.mm.plugin.account.friend.a.l.Tc(locala.OqL);
          }
          localb.PNK.setText(parama1.Pwc.getMMResources().getString(2131757368, new Object[] { parama }));
          localb.kqG.setText(com.tencent.mm.pluginsdk.ui.span.l.b(parama1.Pwc.getContext(), locala.getDisplayName(), localb.kqG.getTextSize()));
          continue;
          localb.PKu.setText(2131757378);
          localb.PNK.setText(2131757379);
          localb.kqG.setText(com.tencent.mm.pluginsdk.ui.span.l.b(parama1.Pwc.getContext(), locala.getDisplayName(), localb.kqG.getTextSize()));
          continue;
          localb.PKu.setText(2131757374);
          localb.PNK.setText(2131757373);
          localb.kqG.setText(com.tencent.mm.pluginsdk.ui.span.l.b(parama1.Pwc.getContext(), locala.getDisplayName(), localb.kqG.getTextSize()));
        }
      }
      Log.w("MicroMsg.ChattingItemFMessageFrom", "FROM_FMESSAGE did not include this type, msgType = " + paramca.getType());
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    return false;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramInt == 37) || (paramInt == 40);
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37297);
    if (paramca.getType() == 37)
    {
      paramView = paramca.field_content;
      Log.w("MicroMsg.ChattingItemFMessageFrom", "dealClickVerifyMsgEvent : ".concat(String.valueOf(paramView)));
      if ((paramView != null) && (paramView.length() > 0)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(37297);
      return true;
      bg.aVF();
      paramca = com.tencent.mm.model.c.aSQ().aEJ(paramView);
      if (paramca != null)
      {
        boolean bool;
        label85:
        Object localObject;
        if (paramca.dkU.length() > 0)
        {
          bool = true;
          Assert.assertTrue(bool);
          bg.aVF();
          paramView = com.tencent.mm.model.c.aSN().Kn(paramca.dkU);
          localObject = new Intent();
          if ((paramView == null) || ((int)paramView.gMZ <= 0) || (!com.tencent.mm.contact.c.oR(paramView.field_type))) {
            break label407;
          }
          ((Intent)localObject).putExtra("Contact_User", paramView.field_username);
          e.a((Intent)localObject, paramView.field_username);
          label160:
          parama = paramca.content;
          paramView = parama;
          if (Util.nullAsNil(parama).length() <= 0) {
            switch (paramca.scene)
            {
            }
          }
        }
        for (paramView = this.PhN.Pwc.getMMResources().getString(2131757377);; paramView = this.PhN.Pwc.getMMResources().getString(2131757381))
        {
          ((Intent)localObject).putExtra("Contact_Content", paramView);
          ((Intent)localObject).putExtra("Contact_verify_Scene", paramca.scene);
          ((Intent)localObject).putExtra("Contact_Uin", paramca.Bge);
          ((Intent)localObject).putExtra("Contact_QQNick", paramca.kfS);
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", paramca.OqK);
          ((Intent)localObject).putExtra("User_From_Fmessage", true);
          ((Intent)localObject).putExtra("Contact_from_msgType", 37);
          ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramca.OqX);
          ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramca.OqY);
          com.tencent.mm.br.c.b(this.PhN.Pwc.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
          com.tencent.mm.bs.a.aiT(paramca.scene);
          break;
          bool = false;
          break label85;
          label407:
          ((Intent)localObject).putExtra("Verify_ticket", paramca.wZz);
          ((Intent)localObject).putExtra("User_Verify", true);
          ((Intent)localObject).putExtra("Contact_User", paramca.dkU);
          ((Intent)localObject).putExtra("Contact_Alias", paramca.fMb);
          ((Intent)localObject).putExtra("Contact_Nick", paramca.nickname);
          ((Intent)localObject).putExtra("Contact_QuanPin", paramca.kfR);
          ((Intent)localObject).putExtra("Contact_PyInitial", paramca.kfQ);
          ((Intent)localObject).putExtra("Contact_Sex", paramca.fuA);
          ((Intent)localObject).putExtra("Contact_Signature", paramca.signature);
          ((Intent)localObject).putExtra("Contact_Scene", paramca.scene);
          ((Intent)localObject).putExtra("Contact_FMessageCard", true);
          ((Intent)localObject).putExtra("Contact_City", paramca.getCity());
          ((Intent)localObject).putExtra("Contact_Province", paramca.getProvince());
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", paramca.OqK);
          ((Intent)localObject).putExtra("Contact_full_Mobile_MD5", paramca.OqL);
          ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramca.OqX);
          ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramca.OqY);
          break label160;
        }
        if (paramca.getType() == 40)
        {
          paramView = paramca.field_content;
          bg.aVF();
          paramca = com.tencent.mm.model.c.aSQ().aEK(paramView);
          if ((paramca != null) && (paramca.dkU.length() > 0))
          {
            com.tencent.mm.bs.a.aiT(paramca.scene);
            bg.aVF();
            localObject = com.tencent.mm.model.c.aSN().Kn(paramca.dkU);
            if ((localObject != null) && ((int)((com.tencent.mm.contact.c)localObject).gMZ > 0) && (com.tencent.mm.contact.c.oR(((ax)localObject).field_type)))
            {
              e.a(this.PhN.Pwc.getContext(), (as)localObject, paramca);
            }
            else if ((paramca.Bge <= 0L) && ((!Util.isNullOrNil(paramca.OqK)) || (!Util.isNullOrNil(paramca.OqL))))
            {
              parama = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(paramca.OqK);
              if ((parama != null) && (parama.getMd5() != null))
              {
                paramView = parama;
                if (parama.getMd5().length() > 0) {}
              }
              else
              {
                parama = com.tencent.mm.plugin.account.a.getAddrUploadStg().SU(paramca.OqL);
                if ((parama != null) && (parama.getMd5() != null))
                {
                  paramView = parama;
                  if (parama.getMd5().length() > 0) {}
                }
                else
                {
                  if ((localObject != null) && ((int)((com.tencent.mm.contact.c)localObject).gMZ > 0)) {
                    e.a(this.PhN.Pwc.getContext(), (as)localObject, paramca);
                  }
                  for (;;)
                  {
                    Log.e("MicroMsg.ChattingItemFMessageFrom", "error : this is not the mobile contact, MD5 = " + paramca.OqK + " fullMD5:" + paramca.OqL);
                    break;
                    e.a(this.PhN.Pwc.getContext(), paramca);
                  }
                }
              }
              if ((paramView.getUsername() == null) || (paramView.getUsername().length() <= 0))
              {
                paramView.username = paramca.dkU;
                paramView.cSx = 128;
                if (com.tencent.mm.plugin.account.a.getAddrUploadStg().a(paramView.getMd5(), paramView) == -1)
                {
                  Log.e("MicroMsg.ChattingItemFMessageFrom", "update mobile contact username failed");
                  continue;
                }
              }
              e.a(this.PhN.Pwc.getContext(), paramca);
            }
            else
            {
              e.a(this.PhN.Pwc.getContext(), paramca);
            }
          }
        }
      }
    }
  }
  
  public final boolean gTT()
  {
    return false;
  }
  
  protected final boolean gTU()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ar.a
 * JD-Core Version:    0.7.0.1
 */