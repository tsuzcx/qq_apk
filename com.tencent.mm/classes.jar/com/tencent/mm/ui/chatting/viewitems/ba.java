package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.f;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.subapp.d.e;
import com.tencent.mm.plugin.subapp.d.k;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.dyc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.at;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.o;
import java.util.LinkedList;

public final class ba
  extends c
{
  private com.tencent.mm.ui.chatting.e.a JWz;
  private com.tencent.mm.ak.f onSceneEndCallback;
  private ProgressDialog yVG;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37500);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131493510);
      ((View)localObject).setTag(new bg().gR((View)localObject));
    }
    AppMethodBeat.o(37500);
    return localObject;
  }
  
  public final void a(final c.a parama, final int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final bv parambv, String paramString)
  {
    AppMethodBeat.i(37501);
    paramString = (bg)parama;
    this.JWz = parama1;
    parama = ao.fdU().yb(parambv.field_msgId);
    parama1 = parambv.field_content;
    if ((parama != null) && (parama1 != null)) {}
    for (parama = k.b.zb(parama1);; parama = null)
    {
      boolean bool2 = false;
      parama1 = e.aDP(parama1);
      boolean bool1 = bool2;
      if (parama1 != null)
      {
        bool1 = bool2;
        if (parama1.Bzm == 0) {}
      }
      for (;;)
      {
        try
        {
          localObject1 = com.tencent.mm.pluginsdk.i.i.aq(this.JWz.Kkd.getContext(), parama1.Bzm);
          if ((parama != null) && (parama.description != null))
          {
            i = parama.description.indexOf('|');
            if ((i <= 0) || (parama.description.length() <= i + 1)) {
              continue;
            }
            localObject2 = parama.description.substring(i + 1);
            paramString.iFO.setText((CharSequence)localObject2);
          }
          if ((localObject1 != null) && (((String)localObject1).length() > 0))
          {
            localObject1 = ((String)localObject1).split(";");
            paramString.KDz.setText(localObject1[0]);
            if (localObject1.length > 1) {
              paramString.KDA.setText(localObject1[1]);
            }
          }
        }
        catch (Exception localException)
        {
          Object localObject1;
          Object localObject2;
          long l;
          Object localObject3;
          ae.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindConfirm", localException, "", new Object[0]);
          continue;
          paramString.KDD.setVisibility(8);
          paramString.iFO.setTextColor(this.JWz.Kkd.getMMResources().getColor(2131101084));
          paramString.KDA.setTextColor(this.JWz.Kkd.getMMResources().getColor(2131101084));
          paramString.KDz.setTextColor(this.JWz.Kkd.getMMResources().getColor(2131101084));
          continue;
          int i = 0;
          continue;
          paramString.KDB.setBackgroundResource(2131234498);
          continue;
        }
        bool1 = af.rc(parama1.Bzm);
        if (!bool1) {
          continue;
        }
        paramString.KDD.setVisibility(0);
        paramString.iFO.setTextColor(this.JWz.Kkd.getMMResources().getColor(2131101085));
        paramString.KDA.setTextColor(this.JWz.Kkd.getMMResources().getColor(2131101085));
        paramString.KDz.setTextColor(this.JWz.Kkd.getMMResources().getColor(2131101085));
        paramString.KDB.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37493);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (af.isNullOrNil(parambv.field_imgPath))
            {
              ae.d("MicroMsg.ChattingItemVoiceRemindConfirm", "filename is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(37493);
              return;
            }
            ((at)ba.a(ba.this).bh(at.class)).fJn().b(paramInt, parambv);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37493);
          }
        });
        l = parambv.field_msgId;
        localObject1 = ((at)this.JWz.bh(at.class)).fJn();
        if ((localObject1 == null) || (!((com.tencent.mm.ui.chatting.d)localObject1).isPlaying()) || (((com.tencent.mm.ui.chatting.d)localObject1).JTd != l)) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        paramString.KDB.setBackgroundResource(2131234497);
        if ((parama1 != null) && (!af.isNullOrNil(parama1.Bzo)) && (parama1.Bzp > 0) && (af.isNullOrNil(parambv.field_reserved)) && (parama != null))
        {
          localObject1 = k.HI(v.aAC());
          localObject2 = com.tencent.mm.plugin.subapp.d.h.ch((String)localObject1, false);
          parambv.uk((String)localObject1);
          bc.aCg();
          com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
          localObject1 = m.a((String)localObject2, parambv.field_msgId, parama.sdkVer, parama.appId, parama1.Bzo, parama1.Bzp, parama.type, parama.hCG);
          if (localObject1 != null)
          {
            localObject2 = bc.ajj();
            localObject3 = new com.tencent.mm.ak.f()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
              {
                AppMethodBeat.i(37494);
                ae.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousn.getType());
                boolean bool = false;
                if (au.a.hIJ != null) {
                  bool = au.a.hIJ.rV(parambv.field_msgId);
                }
                if ((!bool) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (((com.tencent.mm.plugin.record.b.f)paramAnonymousn).getMediaId().equals(this.LO)))
                {
                  paramAnonymousString = bv.aM(parambv);
                  paramAnonymousString.uj(parambv.field_reserved);
                  paramAnonymousString.setMsgId(-1L);
                  ((at)ba.a(ba.this).bh(at.class)).fJn().b(paramInt, paramAnonymousString);
                }
                bc.ajj().b(221, ba.b(ba.this));
                ba.a(ba.this, null);
                AppMethodBeat.o(37494);
              }
            };
            this.onSceneEndCallback = ((com.tencent.mm.ak.f)localObject3);
            ((q)localObject2).a(221, (com.tencent.mm.ak.f)localObject3);
            localObject1 = new com.tencent.mm.plugin.record.b.f((String)localObject1);
            ((com.tencent.mm.plugin.record.b.f)localObject1).dHz();
            bc.ajj().a((n)localObject1, 0);
          }
        }
        if ((af.isNullOrNil(parambv.field_imgPath)) && (parama1.Bzs > 0))
        {
          bc.aCg();
          localObject1 = com.tencent.mm.model.c.azI().aJ(parambv.field_talker, parama1.Bzs);
          if (!af.isNullOrNil(((ei)localObject1).field_imgPath))
          {
            localObject2 = k.HI(v.aAC());
            localObject3 = com.tencent.mm.plugin.subapp.d.h.ch((String)localObject2, false);
            if (o.mF(com.tencent.mm.plugin.subapp.d.h.ch(((ei)localObject1).field_imgPath, false), (String)localObject3) >= 0L)
            {
              parambv.uj((String)localObject2);
              bc.aCg();
              com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
            }
          }
        }
        if ((af.isNullOrNil(parambv.field_imgPath)) && (parama1 != null) && (!af.isNullOrNil(parama1.dlu)) && (parama1.hCC > 0) && (this.onSceneEndCallback == null))
        {
          localObject1 = k.HI(v.aAC());
          localObject2 = com.tencent.mm.plugin.subapp.d.h.ch((String)localObject1, false);
          parambv.uj((String)localObject1);
          bc.aCg();
          com.tencent.mm.model.c.azI().a(parambv.field_msgId, parambv);
          parama = m.a((String)localObject2, parambv.field_msgId, parama.sdkVer, parama.appId, parama.dlu, parama.hCC);
          ae.d("MicroMsg.ChattingItemVoiceRemindConfirm", "mediaId  " + parama.field_mediaSvrId);
          if (parama.field_mediaSvrId != null)
          {
            localObject1 = bc.ajj();
            localObject2 = new com.tencent.mm.ak.f()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
              {
                AppMethodBeat.i(37495);
                ae.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousn.getType());
                if (((com.tencent.mm.plugin.record.b.f)paramAnonymousn).getMediaId().equals(parama.field_mediaSvrId))
                {
                  bc.ajj().b(221, ba.b(ba.this));
                  ba.a(ba.this, null);
                }
                AppMethodBeat.o(37495);
              }
            };
            this.onSceneEndCallback = ((com.tencent.mm.ak.f)localObject2);
            ((q)localObject1).a(221, (com.tencent.mm.ak.f)localObject2);
            parama = new com.tencent.mm.plugin.record.b.f(parama);
            bc.ajj().a(parama, 0);
          }
        }
        paramString.KDC.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37499);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            com.tencent.mm.ui.base.h.a(ba.a(ba.this).Kkd.getContext(), 2131764758, 2131764760, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(37498);
                bc.ajj().a(331, ba.a(ba.this, new com.tencent.mm.ak.f()
                {
                  public final void onSceneEnd(int paramAnonymous3Int1, int paramAnonymous3Int2, String paramAnonymous3String, n paramAnonymous3n)
                  {
                    AppMethodBeat.i(37496);
                    ae.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymous3Int1 + " errCode " + paramAnonymous3Int2 + "  scene " + paramAnonymous3n.getType());
                    if ((paramAnonymous3Int1 == 0) && (paramAnonymous3Int2 == 0))
                    {
                      paramAnonymous3String = ba.4.this.KDh.field_content;
                      if (paramAnonymous3String == null) {
                        break label330;
                      }
                    }
                    label330:
                    for (paramAnonymous3String = k.b.zb(paramAnonymous3String);; paramAnonymous3String = null)
                    {
                      if (paramAnonymous3String != null)
                      {
                        long l = ba.4.this.KDh.field_msgId;
                        paramAnonymous3String = ao.bJV().CZ(l);
                        if (paramAnonymous3String != null) {
                          ae.i("MicroMsg.AppMsgLogic", "summerapp deleteAttachInfoAndFile deleteFile[%b] deleteInfo[%b] msgInfoId[%d] mediaSvrId[%s] path[%s] stack[%s]", new Object[] { Boolean.valueOf(o.deleteFile(paramAnonymous3String.field_fileFullPath)), Boolean.valueOf(ao.bJV().delete(paramAnonymous3String, new String[] { "msgInfoId" })), Long.valueOf(paramAnonymous3String.field_msgInfoId), paramAnonymous3String.field_mediaSvrId, paramAnonymous3String.field_fileFullPath, bu.fpN() });
                        }
                      }
                      bl.rW(ba.4.this.KDh.field_msgId);
                      Toast.makeText(ba.a(ba.this).Kkd.getContext(), ba.a(ba.this).Kkd.getMMResources().getString(2131757209), 0).show();
                      bc.ajj().b(331, ba.b(ba.this));
                      ba.a(ba.this, null);
                      if (ba.c(ba.this) != null) {
                        ba.c(ba.this).dismiss();
                      }
                      AppMethodBeat.o(37496);
                      return;
                    }
                  }
                }));
                paramAnonymous2DialogInterface = new LinkedList();
                Object localObject = new dyc();
                ((dyc)localObject).FOT = ba.4.this.KDl.Bzn;
                paramAnonymous2DialogInterface.add(localObject);
                paramAnonymous2DialogInterface = new com.tencent.mm.plugin.subapp.d.a(paramAnonymous2DialogInterface, paramAnonymous2DialogInterface.size());
                bc.ajj().a(paramAnonymous2DialogInterface, 0);
                localObject = ba.this;
                Activity localActivity = ba.a(ba.this).Kkd.getContext();
                ba.a(ba.this).Kkd.getMMResources().getString(2131755906);
                ba.a((ba)localObject, com.tencent.mm.ui.base.h.b(localActivity, ba.a(ba.this).Kkd.getMMResources().getString(2131757210), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                  {
                    AppMethodBeat.i(37497);
                    bc.ajj().a(paramAnonymous2DialogInterface);
                    bc.ajj().b(331, ba.b(ba.this));
                    ba.a(ba.this, null);
                    if (ba.c(ba.this) != null) {
                      ba.c(ba.this).dismiss();
                    }
                    AppMethodBeat.o(37497);
                  }
                }));
                AppMethodBeat.o(37498);
              }
            }, null);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37499);
          }
        });
        paramString.olI.setTag(new bk(parambv, this.JWz.fJC(), paramInt, null, '\000'));
        bc.aCg();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
          paramString.olI.setOnLongClickListener(c(this.JWz));
        }
        AppMethodBeat.o(37501);
        return;
        paramString.iFO.setText("");
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(37503);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37503);
      return false;
    }
    paramMenuItem = new Intent(parama.Kkd.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bl.b(parama.fJC(), parambv.field_content, parambv.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambv.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37503);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bv parambv)
  {
    AppMethodBeat.i(187913);
    int i = ((bk)paramView.getTag()).position;
    int j = m.aNi(bl.b(this.JWz.fJC(), parambv.field_content, parambv.field_isSend));
    paramView = k.b.zb(bl.b(this.JWz.fJC(), parambv.field_content, parambv.field_isSend));
    if ((paramView.hCC <= 0) || ((paramView.hCC > 0) && (j >= 100))) {
      paraml.a(i, 111, this.JWz.Kkd.getMMResources().getString(2131762559), 2131690478);
    }
    if (!this.JWz.fJD()) {
      paraml.a(i, 100, this.JWz.Kkd.getMMResources().getString(2131757221), 2131690384);
    }
    AppMethodBeat.o(187913);
    return true;
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    return true;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048189;
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
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ba
 * JD-Core Version:    0.7.0.1
 */