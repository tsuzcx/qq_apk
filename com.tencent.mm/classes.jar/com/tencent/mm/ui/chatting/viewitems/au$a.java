package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.storage.ca.d;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.contact.e;
import junit.framework.Assert;

public final class au$a
  extends c
{
  private com.tencent.mm.ui.chatting.e.a WBq;
  
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
      localObject = new aq(paramLayoutInflater, R.i.edl);
      ((View)localObject).setTag(new au.b().ip((View)localObject));
    }
    AppMethodBeat.o(37295);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37296);
    this.WBq = parama1;
    au.b localb = (au.b)parama;
    if (paramca.getType() == 37)
    {
      bh.beI();
      parama = com.tencent.mm.model.c.bbO().aOT(paramca.field_content);
      if ((parama == null) || (parama.fcC == null) || (parama.fcC.length() <= 0))
      {
        Log.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse verify msg failed");
        AppMethodBeat.o(37296);
        return;
      }
      com.tencent.mm.am.d.aH(parama.fcC, parama.VGF);
      if (ab.Ql(parama.fcC))
      {
        localb.XjM.setVisibility(8);
        localb.XjN.setVisibility(8);
        localb.XjO.setVisibility(0);
        localb.XjL.setBackgroundColor(16777215);
        localb.XjO.setText(parama1.WQv.getMMResources().getString(R.l.friend_added));
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
          localb.Xgl.setText(R.l.euV);
          label263:
          localb.nit.setText(com.tencent.mm.pluginsdk.ui.span.l.b(parama1.WQv.getContext(), parama.getDisplayName(), localb.nit.getTextSize()));
          F(localb.avatarIV, parama.fcC);
          localb.XjK.setVisibility(0);
          if ((parama.content != null) && (!parama.content.trim().equals(""))) {
            localb.XjK.setText(parama.content);
          }
          break;
        }
      }
    }
    for (;;)
    {
      localb.clickArea.setTag(new by(paramca, parama1.hRi(), paramInt, null, '\000'));
      localb.clickArea.setOnClickListener(d(parama1));
      localb.clickArea.setOnLongClickListener(c(parama1));
      localb.clickArea.setOnTouchListener(((k)parama1.bC(k.class)).hNO());
      AppMethodBeat.o(37296);
      return;
      localb.XjM.setVisibility(0);
      localb.XjN.setVisibility(0);
      localb.XjO.setVisibility(0);
      localb.XjL.setBackgroundResource(R.g.chatting_item_multi_bottom);
      localb.XjO.setText(parama1.WQv.getMMResources().getString(R.l.friend_add));
      break;
      localb.Xgl.setText(R.l.euZ);
      break label263;
      localb.Xgl.setText(R.l.eva);
      break label263;
      localb.Xgl.setText(R.l.eQa);
      break label263;
      localb.Xgl.setText(R.l.euU);
      break label263;
      paramString = com.tencent.mm.plugin.account.b.getAddrUploadStg().aax(parama.fcC);
      if ((paramString != null) && (paramString.bxT() != null) && (!paramString.bxT().equals("")))
      {
        localb.XjP.setVisibility(0);
        localb.XjP.setText(parama1.WQv.getMMResources().getString(R.l.euP, new Object[] { paramString.bxT() }));
        break label263;
      }
      localb.XjP.setVisibility(8);
      break label263;
      localb.XjK.setText(parama1.WQv.getMMResources().getString(R.l.chatting_from_verify_lbs_tip));
      continue;
      if (paramca.getType() == 40)
      {
        bh.beI();
        ca.a locala = com.tencent.mm.model.c.bbO().aOU(paramca.field_content);
        if ((locala == null) || (locala.fcC == null) || (locala.fcC.length() <= 0))
        {
          Log.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse possible friend msg failed");
          AppMethodBeat.o(37296);
          return;
        }
        com.tencent.mm.am.d.aH(locala.fcC, locala.VGF);
        if (ab.Ql(locala.fcC))
        {
          localb.XjM.setVisibility(8);
          localb.XjN.setVisibility(8);
          localb.XjO.setVisibility(0);
          localb.XjL.setBackgroundColor(16777215);
          localb.XjO.setText(parama1.WQv.getMMResources().getString(R.l.friend_added));
          label817:
          switch (locala.scene)
          {
          default: 
            Log.d("MicroMsg.ChattingItemFMessageFrom", "prossible friend sceneType:%d", new Object[] { Integer.valueOf(locala.scene) });
            localb.Xgl.setText(R.l.euQ);
            localb.XjK.setText(R.l.euR);
            localb.nit.setText(com.tencent.mm.pluginsdk.ui.span.l.b(parama1.WQv.getContext(), locala.getDisplayName(), localb.nit.getTextSize()));
          }
        }
        for (;;)
        {
          F(localb.avatarIV, locala.fcC);
          break;
          localb.XjM.setVisibility(0);
          localb.XjN.setVisibility(0);
          localb.XjO.setVisibility(0);
          localb.XjL.setBackgroundResource(R.g.chatting_item_multi_bottom);
          localb.XjO.setText(parama1.WQv.getMMResources().getString(R.l.friend_add));
          break label817;
          localb.Xgl.setText(R.l.euM);
          localb.XjK.setText(R.l.euN);
          paramString = locala.hAp();
          parama = paramString;
          if (paramString == null) {
            parama = locala.getDisplayName();
          }
          localb.nit.setText(com.tencent.mm.pluginsdk.ui.span.l.b(parama1.WQv.getContext(), parama, localb.nit.getTextSize()));
          continue;
          localb.Xgl.setText(R.l.euO);
          paramString = com.tencent.mm.plugin.account.friend.a.l.aaI(locala.VGG);
          parama = paramString;
          if (Util.isNullOrNil(paramString)) {
            parama = com.tencent.mm.plugin.account.friend.a.l.aaI(locala.VGH);
          }
          localb.XjK.setText(parama1.WQv.getMMResources().getString(R.l.euP, new Object[] { parama }));
          localb.nit.setText(com.tencent.mm.pluginsdk.ui.span.l.b(parama1.WQv.getContext(), locala.getDisplayName(), localb.nit.getTextSize()));
          continue;
          localb.Xgl.setText(R.l.euX);
          localb.XjK.setText(R.l.euY);
          localb.nit.setText(com.tencent.mm.pluginsdk.ui.span.l.b(parama1.WQv.getContext(), locala.getDisplayName(), localb.nit.getTextSize()));
          continue;
          localb.Xgl.setText(R.l.euT);
          localb.XjK.setText(R.l.euS);
          localb.nit.setText(com.tencent.mm.pluginsdk.ui.span.l.b(parama1.WQv.getContext(), locala.getDisplayName(), localb.nit.getTextSize()));
        }
      }
      Log.w("MicroMsg.ChattingItemFMessageFrom", "FROM_FMESSAGE did not include this type, msgType = " + paramca.getType());
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    return false;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
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
      bh.beI();
      paramca = com.tencent.mm.model.c.bbO().aOT(paramView);
      if (paramca != null)
      {
        boolean bool;
        label85:
        Object localObject;
        if (paramca.fcC.length() > 0)
        {
          bool = true;
          Assert.assertTrue(bool);
          bh.beI();
          paramView = com.tencent.mm.model.c.bbL().RG(paramca.fcC);
          localObject = new Intent();
          if ((paramView == null) || ((int)paramView.jxt <= 0) || (!com.tencent.mm.contact.d.rk(paramView.field_type))) {
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
        for (paramView = this.WBq.WQv.getMMResources().getString(R.l.euW);; paramView = this.WBq.WQv.getMMResources().getString(R.l.chatting_from_verify_lbs_tip))
        {
          ((Intent)localObject).putExtra("Contact_Content", paramView);
          ((Intent)localObject).putExtra("Contact_verify_Scene", paramca.scene);
          ((Intent)localObject).putExtra("Contact_Uin", paramca.GZN);
          ((Intent)localObject).putExtra("Contact_QQNick", paramca.mXr);
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", paramca.VGG);
          ((Intent)localObject).putExtra("User_From_Fmessage", true);
          ((Intent)localObject).putExtra("Contact_from_msgType", 37);
          ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramca.VGT);
          ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramca.VGU);
          com.tencent.mm.by.c.b(this.WBq.WQv.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
          com.tencent.mm.bz.a.are(paramca.scene);
          break;
          bool = false;
          break label85;
          label407:
          ((Intent)localObject).putExtra("Verify_ticket", paramca.BLy);
          ((Intent)localObject).putExtra("User_Verify", true);
          ((Intent)localObject).putExtra("Contact_User", paramca.fcC);
          ((Intent)localObject).putExtra("Contact_Alias", paramca.idS);
          ((Intent)localObject).putExtra("Contact_Nick", paramca.nickname);
          ((Intent)localObject).putExtra("Contact_QuanPin", paramca.mXq);
          ((Intent)localObject).putExtra("Contact_PyInitial", paramca.mXp);
          ((Intent)localObject).putExtra("Contact_Sex", paramca.sex);
          ((Intent)localObject).putExtra("Contact_Signature", paramca.signature);
          ((Intent)localObject).putExtra("Contact_Scene", paramca.scene);
          ((Intent)localObject).putExtra("Contact_FMessageCard", true);
          ((Intent)localObject).putExtra("Contact_City", paramca.getCity());
          ((Intent)localObject).putExtra("Contact_Province", paramca.getProvince());
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", paramca.VGG);
          ((Intent)localObject).putExtra("Contact_full_Mobile_MD5", paramca.VGH);
          ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramca.VGT);
          ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramca.VGU);
          break label160;
        }
        if (paramca.getType() == 40)
        {
          paramView = paramca.field_content;
          bh.beI();
          paramca = com.tencent.mm.model.c.bbO().aOU(paramView);
          if ((paramca != null) && (paramca.fcC.length() > 0))
          {
            com.tencent.mm.bz.a.are(paramca.scene);
            bh.beI();
            localObject = com.tencent.mm.model.c.bbL().RG(paramca.fcC);
            if ((localObject != null) && ((int)((com.tencent.mm.contact.d)localObject).jxt > 0) && (com.tencent.mm.contact.d.rk(((ax)localObject).field_type)))
            {
              e.a(this.WBq.WQv.getContext(), (as)localObject, paramca);
            }
            else if ((paramca.GZN <= 0L) && ((!Util.isNullOrNil(paramca.VGG)) || (!Util.isNullOrNil(paramca.VGH))))
            {
              parama = com.tencent.mm.plugin.account.b.getAddrUploadStg().aaA(paramca.VGG);
              if ((parama != null) && (parama.getMd5() != null))
              {
                paramView = parama;
                if (parama.getMd5().length() > 0) {}
              }
              else
              {
                parama = com.tencent.mm.plugin.account.b.getAddrUploadStg().aaA(paramca.VGH);
                if ((parama != null) && (parama.getMd5() != null))
                {
                  paramView = parama;
                  if (parama.getMd5().length() > 0) {}
                }
                else
                {
                  if ((localObject != null) && ((int)((com.tencent.mm.contact.d)localObject).jxt > 0)) {
                    e.a(this.WBq.WQv.getContext(), (as)localObject, paramca);
                  }
                  for (;;)
                  {
                    Log.e("MicroMsg.ChattingItemFMessageFrom", "error : this is not the mobile contact, MD5 = " + paramca.VGG + " fullMD5:" + paramca.VGH);
                    break;
                    e.a(this.WBq.WQv.getContext(), paramca);
                  }
                }
              }
              if ((paramView.getUsername() == null) || (paramView.getUsername().length() <= 0))
              {
                paramView.username = paramca.fcC;
                paramView.cUP = 128;
                if (com.tencent.mm.plugin.account.b.getAddrUploadStg().a(paramView.getMd5(), paramView) == -1)
                {
                  Log.e("MicroMsg.ChattingItemFMessageFrom", "update mobile contact username failed");
                  continue;
                }
              }
              e.a(this.WBq.WQv.getContext(), paramca);
            }
            else
            {
              e.a(this.WBq.WQv.getContext(), paramca);
            }
          }
        }
      }
    }
  }
  
  public final boolean hTD()
  {
    return false;
  }
  
  protected final boolean hTE()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.au.a
 * JD-Core Version:    0.7.0.1
 */