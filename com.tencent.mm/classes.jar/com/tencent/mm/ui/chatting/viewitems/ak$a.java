package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.a;
import com.tencent.mm.storage.bo.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.contact.e;
import junit.framework.Assert;

public final class ak$a
  extends c
{
  private com.tencent.mm.ui.chatting.d.a HNS;
  
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
      localObject = new ag(paramLayoutInflater, 2131493454);
      ((View)localObject).setTag(new ak.b().gr((View)localObject));
    }
    AppMethodBeat.o(37295);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(37296);
    this.HNS = parama1;
    ak.b localb = (ak.b)parama;
    if (parambo.getType() == 37)
    {
      az.ayM();
      parama = com.tencent.mm.model.c.awD().alv(parambo.field_content);
      if ((parama == null) || (parama.zTO == null) || (parama.zTO.length() <= 0))
      {
        ac.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse verify msg failed");
        AppMethodBeat.o(37296);
        return;
      }
      com.tencent.mm.aj.c.ag(parama.zTO, parama.GYW);
      if (w.wG(parama.zTO))
      {
        localb.Iol.setVisibility(8);
        localb.Iom.setVisibility(8);
        localb.Ion.setVisibility(0);
        localb.Iok.setBackgroundColor(16777215);
        localb.Ion.setText(parama1.HZF.getMMResources().getString(2131759662));
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
          localb.Ilj.setText(2131757172);
          label258:
          localb.iWp.setText(k.b(parama1.HZF.getContext(), parama.getDisplayName(), localb.iWp.getTextSize()));
          z(localb.IhT, parama.zTO);
          localb.Ioj.setVisibility(0);
          if ((parama.content != null) && (!parama.content.trim().equals(""))) {
            localb.Ioj.setText(parama.content);
          }
          break;
        }
      }
    }
    for (;;)
    {
      localb.nDl.setTag(new bj(parambo, parama1.foQ(), paramInt, null, '\000'));
      localb.nDl.setOnClickListener(d(parama1));
      localb.nDl.setOnLongClickListener(c(parama1));
      localb.nDl.setOnTouchListener(((i)parama1.bf(i.class)).fmb());
      AppMethodBeat.o(37296);
      return;
      localb.Iol.setVisibility(0);
      localb.Iom.setVisibility(0);
      localb.Ion.setVisibility(0);
      localb.Iok.setBackgroundResource(2131231692);
      localb.Ion.setText(parama1.HZF.getMMResources().getString(2131759661));
      break;
      localb.Ilj.setText(2131757176);
      break label258;
      localb.Ilj.setText(2131757178);
      break label258;
      localb.Ilj.setText(2131762130);
      break label258;
      localb.Ilj.setText(2131757171);
      break label258;
      paramString = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gf(parama.zTO);
      if ((paramString != null) && (paramString.aPm() != null) && (!paramString.aPm().equals("")))
      {
        localb.Ioo.setVisibility(0);
        localb.Ioo.setText(parama1.HZF.getMMResources().getString(2131757164, new Object[] { paramString.aPm() }));
        break label258;
      }
      localb.Ioo.setVisibility(8);
      break label258;
      localb.Ioj.setText(parama1.HZF.getMMResources().getString(2131757177));
      continue;
      if (parambo.getType() == 40)
      {
        az.ayM();
        bo.a locala = com.tencent.mm.model.c.awD().alw(parambo.field_content);
        if ((locala == null) || (locala.zTO == null) || (locala.zTO.length() <= 0))
        {
          ac.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse possible friend msg failed");
          AppMethodBeat.o(37296);
          return;
        }
        com.tencent.mm.aj.c.ag(locala.zTO, locala.GYW);
        if (w.wG(locala.zTO))
        {
          localb.Iol.setVisibility(8);
          localb.Iom.setVisibility(8);
          localb.Ion.setVisibility(0);
          localb.Iok.setBackgroundColor(16777215);
          localb.Ion.setText(parama1.HZF.getMMResources().getString(2131759662));
          label810:
          switch (locala.scene)
          {
          default: 
            ac.d("MicroMsg.ChattingItemFMessageFrom", "prossible friend sceneType:%d", new Object[] { Integer.valueOf(locala.scene) });
            localb.Ilj.setText(2131757167);
            localb.Ioj.setText(2131757168);
            localb.iWp.setText(k.b(parama1.HZF.getContext(), locala.getDisplayName(), localb.iWp.getTextSize()));
          }
        }
        for (;;)
        {
          z(localb.IhT, locala.zTO);
          break;
          localb.Iol.setVisibility(0);
          localb.Iom.setVisibility(0);
          localb.Ion.setVisibility(0);
          localb.Iok.setBackgroundResource(2131231692);
          localb.Ion.setText(parama1.HZF.getMMResources().getString(2131759661));
          break label810;
          localb.Ilj.setText(2131757158);
          localb.Ioj.setText(2131757159);
          paramString = locala.fcl();
          parama = paramString;
          if (paramString == null) {
            parama = locala.getDisplayName();
          }
          localb.iWp.setText(k.b(parama1.HZF.getContext(), parama, localb.iWp.getTextSize()));
          continue;
          localb.Ilj.setText(2131757163);
          paramString = l.Gq(locala.GYX);
          parama = paramString;
          if (bs.isNullOrNil(paramString)) {
            parama = l.Gq(locala.GYY);
          }
          localb.Ioj.setText(parama1.HZF.getMMResources().getString(2131757164, new Object[] { parama }));
          localb.iWp.setText(k.b(parama1.HZF.getContext(), locala.getDisplayName(), localb.iWp.getTextSize()));
          continue;
          localb.Ilj.setText(2131757174);
          localb.Ioj.setText(2131757175);
          localb.iWp.setText(k.b(parama1.HZF.getContext(), locala.getDisplayName(), localb.iWp.getTextSize()));
          continue;
          localb.Ilj.setText(2131757170);
          localb.Ioj.setText(2131757169);
          localb.iWp.setText(k.b(parama1.HZF.getContext(), locala.getDisplayName(), localb.iWp.getTextSize()));
        }
      }
      ac.w("MicroMsg.ChattingItemFMessageFrom", "FROM_FMESSAGE did not include this type, msgType = " + parambo.getType());
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(37297);
    if (parambo.getType() == 37)
    {
      paramView = parambo.field_content;
      ac.w("MicroMsg.ChattingItemFMessageFrom", "dealClickVerifyMsgEvent : ".concat(String.valueOf(paramView)));
      if ((paramView != null) && (paramView.length() > 0)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(37297);
      return true;
      az.ayM();
      parambo = com.tencent.mm.model.c.awD().alv(paramView);
      if (parambo != null)
      {
        boolean bool;
        label85:
        Object localObject;
        if (parambo.zTO.length() > 0)
        {
          bool = true;
          Assert.assertTrue(bool);
          az.ayM();
          paramView = com.tencent.mm.model.c.awB().aNt(parambo.zTO);
          localObject = new Intent();
          if ((paramView == null) || ((int)paramView.fLJ <= 0) || (!com.tencent.mm.n.b.ln(paramView.field_type))) {
            break label407;
          }
          ((Intent)localObject).putExtra("Contact_User", paramView.field_username);
          e.a((Intent)localObject, paramView.field_username);
          label160:
          parama = parambo.content;
          paramView = parama;
          if (bs.nullAsNil(parama).length() <= 0) {
            switch (parambo.scene)
            {
            }
          }
        }
        for (paramView = this.HNS.HZF.getMMResources().getString(2131757173);; paramView = this.HNS.HZF.getMMResources().getString(2131757177))
        {
          ((Intent)localObject).putExtra("Contact_Content", paramView);
          ((Intent)localObject).putExtra("Contact_verify_Scene", parambo.scene);
          ((Intent)localObject).putExtra("Contact_Uin", parambo.vLk);
          ((Intent)localObject).putExtra("Contact_QQNick", parambo.iLN);
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", parambo.GYX);
          ((Intent)localObject).putExtra("User_From_Fmessage", true);
          ((Intent)localObject).putExtra("Contact_from_msgType", 37);
          ((Intent)localObject).putExtra("Contact_KSnsIFlag", parambo.GZk);
          ((Intent)localObject).putExtra("Contact_KSnsBgUrl", parambo.GZl);
          d.b(this.HNS.HZF.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
          com.tencent.mm.bs.a.XC(parambo.scene);
          break;
          bool = false;
          break label85;
          label407:
          ((Intent)localObject).putExtra("Verify_ticket", parambo.sBi);
          ((Intent)localObject).putExtra("User_Verify", true);
          ((Intent)localObject).putExtra("Contact_User", parambo.zTO);
          ((Intent)localObject).putExtra("Contact_Alias", parambo.eNf);
          ((Intent)localObject).putExtra("Contact_Nick", parambo.nickname);
          ((Intent)localObject).putExtra("Contact_QuanPin", parambo.iLM);
          ((Intent)localObject).putExtra("Contact_PyInitial", parambo.iLL);
          ((Intent)localObject).putExtra("Contact_Sex", parambo.exL);
          ((Intent)localObject).putExtra("Contact_Signature", parambo.signature);
          ((Intent)localObject).putExtra("Contact_Scene", parambo.scene);
          ((Intent)localObject).putExtra("Contact_FMessageCard", true);
          ((Intent)localObject).putExtra("Contact_City", parambo.getCity());
          ((Intent)localObject).putExtra("Contact_Province", parambo.getProvince());
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", parambo.GYX);
          ((Intent)localObject).putExtra("Contact_full_Mobile_MD5", parambo.GYY);
          ((Intent)localObject).putExtra("Contact_KSnsIFlag", parambo.GZk);
          ((Intent)localObject).putExtra("Contact_KSnsBgUrl", parambo.GZl);
          break label160;
        }
        if (parambo.getType() == 40)
        {
          paramView = parambo.field_content;
          az.ayM();
          parambo = com.tencent.mm.model.c.awD().alw(paramView);
          if ((parambo != null) && (parambo.zTO.length() > 0))
          {
            com.tencent.mm.bs.a.XC(parambo.scene);
            az.ayM();
            localObject = com.tencent.mm.model.c.awB().aNt(parambo.zTO);
            if ((localObject != null) && ((int)((com.tencent.mm.n.b)localObject).fLJ > 0) && (com.tencent.mm.n.b.ln(((av)localObject).field_type)))
            {
              e.a(this.HNS.HZF.getContext(), (ai)localObject, parambo);
            }
            else if ((parambo.vLk <= 0L) && ((!bs.isNullOrNil(parambo.GYX)) || (!bs.isNullOrNil(parambo.GYY))))
            {
              parama = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gi(parambo.GYX);
              if ((parama != null) && (parama.JC() != null))
              {
                paramView = parama;
                if (parama.JC().length() > 0) {}
              }
              else
              {
                parama = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gi(parambo.GYY);
                if ((parama != null) && (parama.JC() != null))
                {
                  paramView = parama;
                  if (parama.JC().length() > 0) {}
                }
                else
                {
                  if ((localObject != null) && ((int)((com.tencent.mm.n.b)localObject).fLJ > 0)) {
                    e.a(this.HNS.HZF.getContext(), (ai)localObject, parambo);
                  }
                  for (;;)
                  {
                    ac.e("MicroMsg.ChattingItemFMessageFrom", "error : this is not the mobile contact, MD5 = " + parambo.GYX + " fullMD5:" + parambo.GYY);
                    break;
                    e.a(this.HNS.HZF.getContext(), parambo);
                  }
                }
              }
              if ((paramView.getUsername() == null) || (paramView.getUsername().length() <= 0))
              {
                paramView.username = parambo.zTO;
                paramView.drx = 128;
                if (com.tencent.mm.plugin.account.a.getAddrUploadStg().a(paramView.JC(), paramView) == -1)
                {
                  ac.e("MicroMsg.ChattingItemFMessageFrom", "update mobile contact username failed");
                  continue;
                }
              }
              e.a(this.HNS.HZF.getContext(), parambo);
            }
            else
            {
              e.a(this.HNS.HZF.getContext(), parambo);
            }
          }
        }
      }
    }
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (paramInt == 37) || (paramInt == 40);
  }
  
  protected final boolean fqt()
  {
    return false;
  }
  
  public final boolean fqu()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ak.a
 * JD-Core Version:    0.7.0.1
 */