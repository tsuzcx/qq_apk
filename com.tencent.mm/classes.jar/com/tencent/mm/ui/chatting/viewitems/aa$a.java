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
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.bi.d;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.contact.e;
import junit.framework.Assert;

public final class aa$a
  extends c
{
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33203);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969081);
      ((View)localObject).setTag(new aa.b().fl((View)localObject));
    }
    AppMethodBeat.o(33203);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33204);
    this.zzP = parama1;
    aa.b localb = (aa.b)parama;
    if (parambi.getType() == 37)
    {
      aw.aaz();
      parama = com.tencent.mm.model.c.YC().Tx(parambi.field_content);
      if ((parama == null) || (parama.tac == null) || (parama.tac.length() <= 0))
      {
        ab.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse verify msg failed");
        AppMethodBeat.o(33204);
        return;
      }
      com.tencent.mm.ah.b.U(parama.tac, parama.yOh);
      if (t.nT(parama.tac))
      {
        localb.zVS.setVisibility(8);
        localb.zVT.setVisibility(8);
        localb.zVU.setVisibility(0);
        localb.zVR.setBackgroundColor(16777215);
        localb.zVU.setText(parama1.zJz.getMMResources().getString(2131300189));
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
          localb.zUV.setText(2131298183);
          label258:
          localb.gIE.setText(j.b(parama1.zJz.getContext(), parama.getDisplayName(), localb.gIE.getTextSize()));
          w(localb.zRz, parama.tac);
          localb.zVQ.setVisibility(0);
          if ((parama.content != null) && (!parama.content.trim().equals(""))) {
            localb.zVQ.setText(parama.content);
          }
          break;
        }
      }
    }
    for (;;)
    {
      localb.jYu.setTag(new az(parambi, parama1.dJG(), paramInt, null, '\000'));
      localb.jYu.setOnClickListener(d(parama1));
      localb.jYu.setOnLongClickListener(c(parama1));
      localb.jYu.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class)).dHi());
      AppMethodBeat.o(33204);
      return;
      localb.zVS.setVisibility(0);
      localb.zVT.setVisibility(0);
      localb.zVU.setVisibility(0);
      localb.zVR.setBackgroundResource(2130838334);
      localb.zVU.setText(parama1.zJz.getMMResources().getString(2131300188));
      break;
      localb.zUV.setText(2131298187);
      break label258;
      localb.zUV.setText(2131298189);
      break label258;
      localb.zUV.setText(2131302250);
      break label258;
      localb.zUV.setText(2131298182);
      break label258;
      paramString = com.tencent.mm.plugin.account.a.getAddrUploadStg().wX(parama.tac);
      if ((paramString != null) && (paramString.apZ() != null) && (!paramString.apZ().equals("")))
      {
        localb.zVV.setVisibility(0);
        localb.zVV.setText(parama1.zJz.getMMResources().getString(2131298175, new Object[] { paramString.apZ() }));
        break label258;
      }
      localb.zVV.setVisibility(8);
      break label258;
      localb.zVQ.setText(parama1.zJz.getMMResources().getString(2131298188));
      continue;
      if (parambi.getType() == 40)
      {
        aw.aaz();
        bi.a locala = com.tencent.mm.model.c.YC().Ty(parambi.field_content);
        if ((locala == null) || (locala.tac == null) || (locala.tac.length() <= 0))
        {
          ab.e("MicroMsg.ChattingItemFMessageFrom", "getView : parse possible friend msg failed");
          AppMethodBeat.o(33204);
          return;
        }
        com.tencent.mm.ah.b.U(locala.tac, locala.yOh);
        if (t.nT(locala.tac))
        {
          localb.zVS.setVisibility(8);
          localb.zVT.setVisibility(8);
          localb.zVU.setVisibility(0);
          localb.zVR.setBackgroundColor(16777215);
          localb.zVU.setText(parama1.zJz.getMMResources().getString(2131300189));
          label810:
          switch (locala.scene)
          {
          default: 
            ab.d("MicroMsg.ChattingItemFMessageFrom", "prossible friend sceneType:%d", new Object[] { Integer.valueOf(locala.scene) });
            localb.zUV.setText(2131298178);
            localb.zVQ.setText(2131298179);
            localb.gIE.setText(j.b(parama1.zJz.getContext(), locala.getDisplayName(), localb.gIE.getTextSize()));
          }
        }
        for (;;)
        {
          w(localb.zRz, locala.tac);
          break;
          localb.zVS.setVisibility(0);
          localb.zVT.setVisibility(0);
          localb.zVU.setVisibility(0);
          localb.zVR.setBackgroundResource(2130838334);
          localb.zVU.setText(parama1.zJz.getMMResources().getString(2131300188));
          break label810;
          localb.zUV.setText(2131298169);
          localb.zVQ.setText(2131298170);
          paramString = locala.dyu();
          parama = paramString;
          if (paramString == null) {
            parama = locala.getDisplayName();
          }
          localb.gIE.setText(j.b(parama1.zJz.getContext(), parama, localb.gIE.getTextSize()));
          continue;
          localb.zUV.setText(2131298174);
          paramString = l.xj(locala.yOi);
          parama = paramString;
          if (ah.isNullOrNil(paramString)) {
            parama = l.xj(locala.yOj);
          }
          localb.zVQ.setText(parama1.zJz.getMMResources().getString(2131298175, new Object[] { parama }));
          localb.gIE.setText(j.b(parama1.zJz.getContext(), locala.getDisplayName(), localb.gIE.getTextSize()));
          continue;
          localb.zUV.setText(2131298185);
          localb.zVQ.setText(2131298186);
          localb.gIE.setText(j.b(parama1.zJz.getContext(), locala.getDisplayName(), localb.gIE.getTextSize()));
          continue;
          localb.zUV.setText(2131298181);
          localb.zVQ.setText(2131298180);
          localb.gIE.setText(j.b(parama1.zJz.getContext(), locala.getDisplayName(), localb.gIE.getTextSize()));
        }
      }
      ab.w("MicroMsg.ChattingItemFMessageFrom", "FROM_FMESSAGE did not include this type, msgType = " + parambi.getType());
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (paramInt == 37) || (paramInt == 40);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33205);
    if (parambi.getType() == 37)
    {
      paramView = parambi.field_content;
      ab.w("MicroMsg.ChattingItemFMessageFrom", "dealClickVerifyMsgEvent : ".concat(String.valueOf(paramView)));
      if ((paramView != null) && (paramView.length() > 0)) {}
    }
    for (;;)
    {
      AppMethodBeat.o(33205);
      return true;
      aw.aaz();
      parambi = com.tencent.mm.model.c.YC().Tx(paramView);
      if (parambi != null)
      {
        boolean bool;
        label85:
        Object localObject;
        if (parambi.tac.length() > 0)
        {
          bool = true;
          Assert.assertTrue(bool);
          aw.aaz();
          paramView = com.tencent.mm.model.c.YA().arw(parambi.tac);
          localObject = new Intent();
          if ((paramView == null) || ((int)paramView.euF <= 0) || (!com.tencent.mm.n.a.je(paramView.field_type))) {
            break label407;
          }
          ((Intent)localObject).putExtra("Contact_User", paramView.field_username);
          e.a((Intent)localObject, paramView.field_username);
          label160:
          parama = parambi.content;
          paramView = parama;
          if (ah.nullAsNil(parama).length() <= 0) {
            switch (parambi.scene)
            {
            }
          }
        }
        for (paramView = this.zzP.zJz.getMMResources().getString(2131298184);; paramView = this.zzP.zJz.getMMResources().getString(2131298188))
        {
          ((Intent)localObject).putExtra("Contact_Content", paramView);
          ((Intent)localObject).putExtra("Contact_verify_Scene", parambi.scene);
          ((Intent)localObject).putExtra("Contact_Uin", parambi.pAI);
          ((Intent)localObject).putExtra("Contact_QQNick", parambi.gyJ);
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", parambi.yOi);
          ((Intent)localObject).putExtra("User_From_Fmessage", true);
          ((Intent)localObject).putExtra("Contact_from_msgType", 37);
          ((Intent)localObject).putExtra("Contact_KSnsIFlag", parambi.yOv);
          ((Intent)localObject).putExtra("Contact_KSnsBgUrl", parambi.yOw);
          d.b(this.zzP.zJz.getContext(), "profile", ".ui.ContactInfoUI", (Intent)localObject);
          com.tencent.mm.br.a.My(parambi.scene);
          break;
          bool = false;
          break label85;
          label407:
          ((Intent)localObject).putExtra("Verify_ticket", parambi.mVw);
          ((Intent)localObject).putExtra("User_Verify", true);
          ((Intent)localObject).putExtra("Contact_User", parambi.tac);
          ((Intent)localObject).putExtra("Contact_Alias", parambi.dCJ);
          ((Intent)localObject).putExtra("Contact_Nick", parambi.nickname);
          ((Intent)localObject).putExtra("Contact_QuanPin", parambi.gyI);
          ((Intent)localObject).putExtra("Contact_PyInitial", parambi.gyH);
          ((Intent)localObject).putExtra("Contact_Sex", parambi.dqC);
          ((Intent)localObject).putExtra("Contact_Signature", parambi.signature);
          ((Intent)localObject).putExtra("Contact_Scene", parambi.scene);
          ((Intent)localObject).putExtra("Contact_FMessageCard", true);
          ((Intent)localObject).putExtra("Contact_City", parambi.getCity());
          ((Intent)localObject).putExtra("Contact_Province", parambi.getProvince());
          ((Intent)localObject).putExtra("Contact_Mobile_MD5", parambi.yOi);
          ((Intent)localObject).putExtra("Contact_full_Mobile_MD5", parambi.yOj);
          ((Intent)localObject).putExtra("Contact_KSnsIFlag", parambi.yOv);
          ((Intent)localObject).putExtra("Contact_KSnsBgUrl", parambi.yOw);
          break label160;
        }
        if (parambi.getType() == 40)
        {
          paramView = parambi.field_content;
          aw.aaz();
          parambi = com.tencent.mm.model.c.YC().Ty(paramView);
          if ((parambi != null) && (parambi.tac.length() > 0))
          {
            com.tencent.mm.br.a.My(parambi.scene);
            aw.aaz();
            localObject = com.tencent.mm.model.c.YA().arw(parambi.tac);
            if ((localObject != null) && ((int)((com.tencent.mm.n.a)localObject).euF > 0) && (com.tencent.mm.n.a.je(((aq)localObject).field_type)))
            {
              e.a(this.zzP.zJz.getContext(), (ad)localObject, parambi);
            }
            else if ((parambi.pAI <= 0L) && ((!ah.isNullOrNil(parambi.yOi)) || (!ah.isNullOrNil(parambi.yOj))))
            {
              parama = com.tencent.mm.plugin.account.a.getAddrUploadStg().xa(parambi.yOi);
              if ((parama != null) && (parama.Al() != null))
              {
                paramView = parama;
                if (parama.Al().length() > 0) {}
              }
              else
              {
                parama = com.tencent.mm.plugin.account.a.getAddrUploadStg().xa(parambi.yOj);
                if ((parama != null) && (parama.Al() != null))
                {
                  paramView = parama;
                  if (parama.Al().length() > 0) {}
                }
                else
                {
                  if ((localObject != null) && ((int)((com.tencent.mm.n.a)localObject).euF > 0)) {
                    e.a(this.zzP.zJz.getContext(), (ad)localObject, parambi);
                  }
                  for (;;)
                  {
                    ab.e("MicroMsg.ChattingItemFMessageFrom", "error : this is not the mobile contact, MD5 = " + parambi.yOi + " fullMD5:" + parambi.yOj);
                    break;
                    e.a(this.zzP.zJz.getContext(), parambi);
                  }
                }
              }
              if ((paramView.getUsername() == null) || (paramView.getUsername().length() <= 0))
              {
                paramView.username = parambi.tac;
                paramView.bsY = 128;
                if (com.tencent.mm.plugin.account.a.getAddrUploadStg().a(paramView.Al(), paramView) == -1)
                {
                  ab.e("MicroMsg.ChattingItemFMessageFrom", "update mobile contact username failed");
                  continue;
                }
              }
              e.a(this.zzP.zJz.getContext(), parambi);
            }
            else
            {
              e.a(this.zzP.zJz.getContext(), parambi);
            }
          }
        }
      }
    }
  }
  
  protected final boolean dLo()
  {
    return false;
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aa.a
 * JD-Core Version:    0.7.0.1
 */