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
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.a;
import com.tencent.mm.storage.bl.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.contact.e;
import junit.framework.Assert;

public final class aj$a
  extends c
{
  private com.tencent.mm.ui.chatting.d.a Gob;
  
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
      localObject = new af(paramLayoutInflater, 2131493454);
      ((View)localObject).setTag(new aj.b().ge((View)localObject));
    }
    AppMethodBeat.o(37295);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(37296);
    this.Gob = parama1;
    aj.b localb = (aj.b)parama;
    if (parambl.getType() == 37)
    {
      az.arV();
      parama = com.tencent.mm.model.c.apO().agB(parambl.field_content);
      if ((parama == null) || (parama.yGA == null) || (parama.yGA.length() <= 0))
      {
        ad.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse verify msg failed");
        AppMethodBeat.o(37296);
        return;
      }
      com.tencent.mm.ak.c.ac(parama.yGA, parama.FzU);
      if (w.sD(parama.yGA))
      {
        localb.GOj.setVisibility(8);
        localb.GOk.setVisibility(8);
        localb.GOl.setVisibility(0);
        localb.GOi.setBackgroundColor(16777215);
        localb.GOl.setText(parama1.GzJ.getMMResources().getString(2131759662));
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
          localb.GLm.setText(2131757172);
          label258:
          localb.iwl.setText(k.b(parama1.GzJ.getContext(), parama.getDisplayName(), localb.iwl.getTextSize()));
          z(localb.GHW, parama.yGA);
          localb.GOh.setVisibility(0);
          if ((parama.content != null) && (!parama.content.trim().equals(""))) {
            localb.GOh.setText(parama.content);
          }
          break;
        }
      }
    }
    for (;;)
    {
      localb.naN.setTag(new bi(parambl, parama1.eZb(), paramInt, null, '\000'));
      localb.naN.setOnClickListener(d(parama1));
      localb.naN.setOnLongClickListener(c(parama1));
      localb.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
      AppMethodBeat.o(37296);
      return;
      localb.GOj.setVisibility(0);
      localb.GOk.setVisibility(0);
      localb.GOl.setVisibility(0);
      localb.GOi.setBackgroundResource(2131231692);
      localb.GOl.setText(parama1.GzJ.getMMResources().getString(2131759661));
      break;
      localb.GLm.setText(2131757176);
      break label258;
      localb.GLm.setText(2131757178);
      break label258;
      localb.GLm.setText(2131762130);
      break label258;
      localb.GLm.setText(2131757171);
      break label258;
      paramString = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cc(parama.yGA);
      if ((paramString != null) && (paramString.aIv() != null) && (!paramString.aIv().equals("")))
      {
        localb.GOm.setVisibility(0);
        localb.GOm.setText(parama1.GzJ.getMMResources().getString(2131757164, new Object[] { paramString.aIv() }));
        break label258;
      }
      localb.GOm.setVisibility(8);
      break label258;
      localb.GOh.setText(parama1.GzJ.getMMResources().getString(2131757177));
      continue;
      if (parambl.getType() == 40)
      {
        az.arV();
        bl.a locala = com.tencent.mm.model.c.apO().agC(parambl.field_content);
        if ((locala == null) || (locala.yGA == null) || (locala.yGA.length() <= 0))
        {
          ad.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse possible friend msg failed");
          AppMethodBeat.o(37296);
          return;
        }
        com.tencent.mm.ak.c.ac(locala.yGA, locala.FzU);
        if (w.sD(locala.yGA))
        {
          localb.GOj.setVisibility(8);
          localb.GOk.setVisibility(8);
          localb.GOl.setVisibility(0);
          localb.GOi.setBackgroundColor(16777215);
          localb.GOl.setText(parama1.GzJ.getMMResources().getString(2131759662));
          label810:
          switch (locala.scene)
          {
          default: 
            ad.d("MicroMsg.ChattingItemFMessageFrom", "prossible friend sceneType:%d", new Object[] { Integer.valueOf(locala.scene) });
            localb.GLm.setText(2131757167);
            localb.GOh.setText(2131757168);
            localb.iwl.setText(k.b(parama1.GzJ.getContext(), locala.getDisplayName(), localb.iwl.getTextSize()));
          }
        }
        for (;;)
        {
          z(localb.GHW, locala.yGA);
          break;
          localb.GOj.setVisibility(0);
          localb.GOk.setVisibility(0);
          localb.GOl.setVisibility(0);
          localb.GOi.setBackgroundResource(2131231692);
          localb.GOl.setText(parama1.GzJ.getMMResources().getString(2131759661));
          break label810;
          localb.GLm.setText(2131757158);
          localb.GOh.setText(2131757159);
          paramString = locala.eMG();
          parama = paramString;
          if (paramString == null) {
            parama = locala.getDisplayName();
          }
          localb.iwl.setText(k.b(parama1.GzJ.getContext(), parama, localb.iwl.getTextSize()));
          continue;
          localb.GLm.setText(2131757163);
          paramString = l.Cn(locala.FzV);
          parama = paramString;
          if (bt.isNullOrNil(paramString)) {
            parama = l.Cn(locala.FzW);
          }
          localb.GOh.setText(parama1.GzJ.getMMResources().getString(2131757164, new Object[] { parama }));
          localb.iwl.setText(k.b(parama1.GzJ.getContext(), locala.getDisplayName(), localb.iwl.getTextSize()));
          continue;
          localb.GLm.setText(2131757174);
          localb.GOh.setText(2131757175);
          localb.iwl.setText(k.b(parama1.GzJ.getContext(), locala.getDisplayName(), localb.iwl.getTextSize()));
          continue;
          localb.GLm.setText(2131757170);
          localb.GOh.setText(2131757169);
          localb.iwl.setText(k.b(parama1.GzJ.getContext(), locala.getDisplayName(), localb.iwl.getTextSize()));
        }
      }
      ad.w("MicroMsg.ChattingItemFMessageFrom", "FROM_FMESSAGE did not include this type, msgType = " + parambl.getType());
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return (paramInt == 37) || (paramInt == 40);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(37297);
    if (parambl.getType() == 37)
    {
      paramView = parambl.field_content;
      ad.w("MicroMsg.ChattingItemFMessageFrom", "dealClickVerifyMsgEvent : ".concat(String.valueOf(paramView)));
      if ((paramView != null) && (paramView.length() > 0)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(37297);
      return true;
      az.arV();
      parambl = com.tencent.mm.model.c.apO().agB(paramView);
      if (parambl != null)
      {
        boolean bool;
        label85:
        Object localObject;
        if (parambl.yGA.length() > 0)
        {
          bool = true;
          Assert.assertTrue(bool);
          az.arV();
          paramView = com.tencent.mm.model.c.apM().aHY(parambl.yGA);
          localObject = new Intent();
          if ((paramView == null) || ((int)paramView.fId <= 0) || (!com.tencent.mm.n.b.ls(paramView.field_type))) {
            break label407;
          }
          ((Intent)localObject).putExtra("Contact_User", paramView.field_username);
          e.a((Intent)localObject, paramView.field_username);
          label160:
          parama = parambl.content;
          paramView = parama;
          if (bt.nullAsNil(parama).length() <= 0) {
            switch (parambl.scene)
            {
            }
          }
        }
        for (paramView = this.Gob.GzJ.getMMResources().getString(2131757173);; paramView = this.Gob.GzJ.getMMResources().getString(2131757177))
        {
          ((Intent)localObject).putExtra("Contact_Content", paramView);
          ((Intent)localObject).putExtra("Contact_verify_Scene", parambl.scene);
          ((Intent)localObject).putExtra("Contact_Uin", parambl.uCr);
          ((Intent)localObject).putExtra("Contact_QQNick", parambl.ilG);
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", parambl.FzV);
          ((Intent)localObject).putExtra("User_From_Fmessage", true);
          ((Intent)localObject).putExtra("Contact_from_msgType", 37);
          ((Intent)localObject).putExtra("Contact_KSnsIFlag", parambl.FAi);
          ((Intent)localObject).putExtra("Contact_KSnsBgUrl", parambl.FAj);
          d.b(this.Gob.GzJ.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
          com.tencent.mm.bt.a.Vt(parambl.scene);
          break;
          bool = false;
          break label85;
          label407:
          ((Intent)localObject).putExtra("Verify_ticket", parambl.rso);
          ((Intent)localObject).putExtra("User_Verify", true);
          ((Intent)localObject).putExtra("Contact_User", parambl.yGA);
          ((Intent)localObject).putExtra("Contact_Alias", parambl.eKn);
          ((Intent)localObject).putExtra("Contact_Nick", parambl.nickname);
          ((Intent)localObject).putExtra("Contact_QuanPin", parambl.ilF);
          ((Intent)localObject).putExtra("Contact_PyInitial", parambl.ilE);
          ((Intent)localObject).putExtra("Contact_Sex", parambl.evp);
          ((Intent)localObject).putExtra("Contact_Signature", parambl.signature);
          ((Intent)localObject).putExtra("Contact_Scene", parambl.scene);
          ((Intent)localObject).putExtra("Contact_FMessageCard", true);
          ((Intent)localObject).putExtra("Contact_City", parambl.getCity());
          ((Intent)localObject).putExtra("Contact_Province", parambl.getProvince());
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", parambl.FzV);
          ((Intent)localObject).putExtra("Contact_full_Mobile_MD5", parambl.FzW);
          ((Intent)localObject).putExtra("Contact_KSnsIFlag", parambl.FAi);
          ((Intent)localObject).putExtra("Contact_KSnsBgUrl", parambl.FAj);
          break label160;
        }
        if (parambl.getType() == 40)
        {
          paramView = parambl.field_content;
          az.arV();
          parambl = com.tencent.mm.model.c.apO().agC(paramView);
          if ((parambl != null) && (parambl.yGA.length() > 0))
          {
            com.tencent.mm.bt.a.Vt(parambl.scene);
            az.arV();
            localObject = com.tencent.mm.model.c.apM().aHY(parambl.yGA);
            if ((localObject != null) && ((int)((com.tencent.mm.n.b)localObject).fId > 0) && (com.tencent.mm.n.b.ls(((au)localObject).field_type)))
            {
              e.a(this.Gob.GzJ.getContext(), (com.tencent.mm.storage.af)localObject, parambl);
            }
            else if ((parambl.uCr <= 0L) && ((!bt.isNullOrNil(parambl.FzV)) || (!bt.isNullOrNil(parambl.FzW))))
            {
              parama = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cf(parambl.FzV);
              if ((parama != null) && (parama.JS() != null))
              {
                paramView = parama;
                if (parama.JS().length() > 0) {}
              }
              else
              {
                parama = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cf(parambl.FzW);
                if ((parama != null) && (parama.JS() != null))
                {
                  paramView = parama;
                  if (parama.JS().length() > 0) {}
                }
                else
                {
                  if ((localObject != null) && ((int)((com.tencent.mm.n.b)localObject).fId > 0)) {
                    e.a(this.Gob.GzJ.getContext(), (com.tencent.mm.storage.af)localObject, parambl);
                  }
                  for (;;)
                  {
                    ad.e("MicroMsg.ChattingItemFMessageFrom", "error : this is not the mobile contact, MD5 = " + parambl.FzV + " fullMD5:" + parambl.FzW);
                    break;
                    e.a(this.Gob.GzJ.getContext(), parambl);
                  }
                }
              }
              if ((paramView.getUsername() == null) || (paramView.getUsername().length() <= 0))
              {
                paramView.username = parambl.yGA;
                paramView.dtM = 128;
                if (com.tencent.mm.plugin.account.a.getAddrUploadStg().a(paramView.JS(), paramView) == -1)
                {
                  ad.e("MicroMsg.ChattingItemFMessageFrom", "update mobile contact username failed");
                  continue;
                }
              }
              e.a(this.Gob.GzJ.getContext(), parambl);
            }
            else
            {
              e.a(this.Gob.GzJ.getContext(), parambl);
            }
          }
        }
      }
    }
  }
  
  protected final boolean faD()
  {
    return false;
  }
  
  public final boolean faE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aj.a
 * JD-Core Version:    0.7.0.1
 */