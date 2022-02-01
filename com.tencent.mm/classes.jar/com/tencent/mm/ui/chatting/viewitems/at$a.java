package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.storage.cc.f;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.contact.e;
import junit.framework.Assert;

public final class at$a
  extends c
{
  private com.tencent.mm.ui.chatting.d.a aeiK;
  
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
      localObject = new ap(paramLayoutInflater, R.i.gga);
      ((View)localObject).setTag(new at.b().lM((View)localObject));
    }
    AppMethodBeat.o(37295);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(37296);
    this.aeiK = parama1;
    at.b localb = (at.b)parama;
    if (paramcc.getType() == 37)
    {
      bh.bCz();
      parama = com.tencent.mm.model.c.bzD().aLT(paramcc.field_content);
      if ((parama == null) || (parama.hgk == null) || (parama.hgk.length() <= 0))
      {
        Log.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse verify msg failed");
        AppMethodBeat.o(37296);
        return;
      }
      com.tencent.mm.modelavatar.d.aS(parama.hgk, parama.adky);
      if (ab.IR(parama.hgk))
      {
        localb.aeUe.setVisibility(8);
        localb.aeUf.setVisibility(8);
        localb.aeUg.setVisibility(0);
        localb.aeUd.setBackgroundColor(16777215);
        localb.aeUg.setText(parama1.aezO.getMMResources().getString(R.l.friend_added));
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
          localb.aeQc.setText(R.l.gxv);
          label263:
          localb.qfH.setText(p.b(parama1.aezO.getContext(), parama.getDisplayName(), localb.qfH.getTextSize()));
          x(localb.avatarIV, parama.hgk);
          localb.aeUc.setVisibility(0);
          if ((parama.content != null) && (!parama.content.trim().equals(""))) {
            localb.aeUc.setText(parama.content);
          }
          break;
        }
      }
    }
    for (;;)
    {
      localb.clickArea.setTag(new bz(paramcc, parama1.juG(), paramInt, null, '\000'));
      localb.clickArea.setOnClickListener(d(parama1));
      localb.clickArea.setOnLongClickListener(c(parama1));
      localb.clickArea.setOnTouchListener(((m)parama1.cm(m.class)).jqv());
      AppMethodBeat.o(37296);
      return;
      localb.aeUe.setVisibility(0);
      localb.aeUf.setVisibility(0);
      localb.aeUg.setVisibility(0);
      localb.aeUd.setBackgroundResource(R.g.chatting_item_multi_bottom);
      localb.aeUg.setText(parama1.aezO.getMMResources().getString(R.l.friend_add));
      break;
      localb.aeQc.setText(R.l.gxz);
      break label263;
      localb.aeQc.setText(R.l.gxA);
      break label263;
      localb.aeQc.setText(R.l.gSF);
      break label263;
      localb.aeQc.setText(R.l.gxu);
      break label263;
      paramString = com.tencent.mm.plugin.account.b.getAddrUploadStg().SR(parama.hgk);
      if ((paramString != null) && (paramString.bWI() != null) && (!paramString.bWI().equals("")))
      {
        localb.aeUh.setVisibility(0);
        localb.aeUh.setText(parama1.aezO.getMMResources().getString(R.l.gxp, new Object[] { paramString.bWI() }));
        break label263;
      }
      localb.aeUh.setVisibility(8);
      break label263;
      localb.aeUc.setText(parama1.aezO.getMMResources().getString(R.l.chatting_from_verify_lbs_tip));
      continue;
      if (paramcc.getType() == 40)
      {
        bh.bCz();
        cc.a locala = com.tencent.mm.model.c.bzD().aLU(paramcc.field_content);
        if ((locala == null) || (locala.hgk == null) || (locala.hgk.length() <= 0))
        {
          Log.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse possible friend msg failed");
          AppMethodBeat.o(37296);
          return;
        }
        com.tencent.mm.modelavatar.d.aS(locala.hgk, locala.adky);
        if (ab.IR(locala.hgk))
        {
          localb.aeUe.setVisibility(8);
          localb.aeUf.setVisibility(8);
          localb.aeUg.setVisibility(0);
          localb.aeUd.setBackgroundColor(16777215);
          localb.aeUg.setText(parama1.aezO.getMMResources().getString(R.l.friend_added));
          label817:
          switch (locala.scene)
          {
          default: 
            Log.d("MicroMsg.ChattingItemFMessageFrom", "prossible friend sceneType:%d", new Object[] { Integer.valueOf(locala.scene) });
            localb.aeQc.setText(R.l.gxq);
            localb.aeUc.setText(R.l.gxr);
            localb.qfH.setText(p.b(parama1.aezO.getContext(), locala.getDisplayName(), localb.qfH.getTextSize()));
          }
        }
        for (;;)
        {
          x(localb.avatarIV, locala.hgk);
          break;
          localb.aeUe.setVisibility(0);
          localb.aeUf.setVisibility(0);
          localb.aeUg.setVisibility(0);
          localb.aeUd.setBackgroundResource(R.g.chatting_item_multi_bottom);
          localb.aeUg.setText(parama1.aezO.getMMResources().getString(R.l.friend_add));
          break label817;
          localb.aeQc.setText(R.l.gxm);
          localb.aeUc.setText(R.l.gxn);
          paramString = locala.jcv();
          parama = paramString;
          if (paramString == null) {
            parama = locala.getDisplayName();
          }
          localb.qfH.setText(p.b(parama1.aezO.getContext(), parama, localb.qfH.getTextSize()));
          continue;
          localb.aeQc.setText(R.l.gxo);
          paramString = com.tencent.mm.plugin.account.friend.model.i.Tb(locala.adkz);
          parama = paramString;
          if (Util.isNullOrNil(paramString)) {
            parama = com.tencent.mm.plugin.account.friend.model.i.Tb(locala.adkA);
          }
          localb.aeUc.setText(parama1.aezO.getMMResources().getString(R.l.gxp, new Object[] { parama }));
          localb.qfH.setText(p.b(parama1.aezO.getContext(), locala.getDisplayName(), localb.qfH.getTextSize()));
          continue;
          localb.aeQc.setText(R.l.gxx);
          localb.aeUc.setText(R.l.gxy);
          localb.qfH.setText(p.b(parama1.aezO.getContext(), locala.getDisplayName(), localb.qfH.getTextSize()));
          continue;
          localb.aeQc.setText(R.l.gxt);
          localb.aeUc.setText(R.l.gxs);
          localb.qfH.setText(p.b(parama1.aezO.getContext(), locala.getDisplayName(), localb.qfH.getTextSize()));
        }
      }
      Log.w("MicroMsg.ChattingItemFMessageFrom", "FROM_FMESSAGE did not include this type, msgType = " + paramcc.getType());
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    return false;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37297);
    if (paramcc.getType() == 37)
    {
      paramView = paramcc.field_content;
      Log.w("MicroMsg.ChattingItemFMessageFrom", "dealClickVerifyMsgEvent : ".concat(String.valueOf(paramView)));
      if ((paramView != null) && (paramView.length() > 0)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(37297);
      return true;
      bh.bCz();
      paramcc = com.tencent.mm.model.c.bzD().aLT(paramView);
      if (paramcc != null)
      {
        boolean bool;
        label85:
        Object localObject;
        if (paramcc.hgk.length() > 0)
        {
          bool = true;
          Assert.assertTrue(bool);
          bh.bCz();
          paramView = com.tencent.mm.model.c.bzA().JE(paramcc.hgk);
          localObject = new Intent();
          if ((paramView == null) || ((int)paramView.maN <= 0) || (!com.tencent.mm.contact.d.rs(paramView.field_type))) {
            break label407;
          }
          ((Intent)localObject).putExtra("Contact_User", paramView.field_username);
          e.a((Intent)localObject, paramView.field_username);
          label160:
          parama = paramcc.content;
          paramView = parama;
          if (Util.nullAsNil(parama).length() <= 0) {
            switch (paramcc.scene)
            {
            }
          }
        }
        for (paramView = this.aeiK.aezO.getMMResources().getString(R.l.gxw);; paramView = this.aeiK.aezO.getMMResources().getString(R.l.chatting_from_verify_lbs_tip))
        {
          ((Intent)localObject).putExtra("Contact_Content", paramView);
          ((Intent)localObject).putExtra("Contact_verify_Scene", paramcc.scene);
          ((Intent)localObject).putExtra("Contact_Uin", paramcc.MXS);
          ((Intent)localObject).putExtra("Contact_QQNick", paramcc.pTZ);
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", paramcc.adkz);
          ((Intent)localObject).putExtra("User_From_Fmessage", true);
          ((Intent)localObject).putExtra("Contact_from_msgType", 37);
          ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramcc.adkO);
          ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramcc.adkP);
          com.tencent.mm.br.c.b(this.aeiK.aezO.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
          com.tencent.mm.bs.a.axl(paramcc.scene);
          break;
          bool = false;
          break label85;
          label407:
          ((Intent)localObject).putExtra("Verify_ticket", paramcc.pPi);
          ((Intent)localObject).putExtra("User_Verify", true);
          ((Intent)localObject).putExtra("Contact_User", paramcc.hgk);
          ((Intent)localObject).putExtra("Contact_Alias", paramcc.kDc);
          ((Intent)localObject).putExtra("Contact_Nick", paramcc.nickname);
          ((Intent)localObject).putExtra("Contact_QuanPin", paramcc.pTY);
          ((Intent)localObject).putExtra("Contact_PyInitial", paramcc.pTX);
          ((Intent)localObject).putExtra("Contact_Sex", paramcc.sex);
          ((Intent)localObject).putExtra("Contact_Signature", paramcc.signature);
          ((Intent)localObject).putExtra("Contact_Scene", paramcc.scene);
          ((Intent)localObject).putExtra("Contact_FMessageCard", true);
          ((Intent)localObject).putExtra("Contact_City", paramcc.getCity());
          ((Intent)localObject).putExtra("Contact_Province", paramcc.getProvince());
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", paramcc.adkz);
          ((Intent)localObject).putExtra("Contact_full_Mobile_MD5", paramcc.adkA);
          ((Intent)localObject).putExtra("Contact_KSnsIFlag", paramcc.adkO);
          ((Intent)localObject).putExtra("Contact_KSnsBgUrl", paramcc.adkP);
          break label160;
        }
        if (paramcc.getType() == 40)
        {
          paramView = paramcc.field_content;
          bh.bCz();
          paramcc = com.tencent.mm.model.c.bzD().aLU(paramView);
          if ((paramcc != null) && (paramcc.hgk.length() > 0))
          {
            com.tencent.mm.bs.a.axl(paramcc.scene);
            bh.bCz();
            localObject = com.tencent.mm.model.c.bzA().JE(paramcc.hgk);
            if ((localObject != null) && ((int)((com.tencent.mm.contact.d)localObject).maN > 0) && (com.tencent.mm.contact.d.rs(((az)localObject).field_type)))
            {
              e.a(this.aeiK.aezO.getContext(), (au)localObject, paramcc);
            }
            else if ((paramcc.MXS <= 0L) && ((!Util.isNullOrNil(paramcc.adkz)) || (!Util.isNullOrNil(paramcc.adkA))))
            {
              parama = com.tencent.mm.plugin.account.b.getAddrUploadStg().SU(paramcc.adkz);
              if ((parama != null) && (parama.getMd5() != null))
              {
                paramView = parama;
                if (parama.getMd5().length() > 0) {}
              }
              else
              {
                parama = com.tencent.mm.plugin.account.b.getAddrUploadStg().SU(paramcc.adkA);
                if ((parama != null) && (parama.getMd5() != null))
                {
                  paramView = parama;
                  if (parama.getMd5().length() > 0) {}
                }
                else
                {
                  if ((localObject != null) && ((int)((com.tencent.mm.contact.d)localObject).maN > 0)) {
                    e.a(this.aeiK.aezO.getContext(), (au)localObject, paramcc);
                  }
                  for (;;)
                  {
                    Log.e("MicroMsg.ChattingItemFMessageFrom", "error : this is not the mobile contact, MD5 = " + paramcc.adkz + " fullMD5:" + paramcc.adkA);
                    break;
                    e.a(this.aeiK.aezO.getContext(), paramcc);
                  }
                }
              }
              if ((paramView.getUsername() == null) || (paramView.getUsername().length() <= 0))
              {
                paramView.username = paramcc.hgk;
                paramView.eQp = 128;
                if (com.tencent.mm.plugin.account.b.getAddrUploadStg().a(paramView.getMd5(), paramView) == -1)
                {
                  Log.e("MicroMsg.ChattingItemFMessageFrom", "update mobile contact username failed");
                  continue;
                }
              }
              e.a(this.aeiK.aezO.getContext(), paramcc);
            }
            else
            {
              e.a(this.aeiK.aezO.getContext(), paramcc);
            }
          }
        }
      }
    }
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (paramInt == 37) || (paramInt == 40);
  }
  
  public final boolean fXn()
  {
    return false;
  }
  
  protected final boolean jxh()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.at.a
 * JD-Core Version:    0.7.0.1
 */