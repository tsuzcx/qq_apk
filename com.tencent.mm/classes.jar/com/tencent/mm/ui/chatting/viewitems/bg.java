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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.f;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.subapp.d.e;
import com.tencent.mm.plugin.subapp.d.k;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.protobuf.esj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.s;
import java.util.LinkedList;

public final class bg
  extends c
{
  private ProgressDialog Dav;
  private com.tencent.mm.ui.chatting.e.a PhN;
  private com.tencent.mm.ak.i onSceneEndCallback;
  
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
      localObject = new an(paramLayoutInflater, 2131493619);
      ((View)localObject).setTag(new bm().hh((View)localObject));
    }
    AppMethodBeat.o(37500);
    return localObject;
  }
  
  public final void a(final c.a parama, final int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, String paramString)
  {
    AppMethodBeat.i(37501);
    paramString = (bm)parama;
    this.PhN = parama1;
    parama = ao.gnf().GL(paramca.field_msgId);
    parama1 = paramca.field_content;
    if ((parama != null) && (parama1 != null)) {}
    for (parama = k.b.HD(parama1);; parama = null)
    {
      boolean bool2 = false;
      parama1 = e.aSK(parama1);
      boolean bool1 = bool2;
      if (parama1 != null)
      {
        bool1 = bool2;
        if (parama1.FJX == 0) {}
      }
      for (;;)
      {
        try
        {
          localObject1 = com.tencent.mm.pluginsdk.i.f.az(this.PhN.Pwc.getContext(), parama1.FJX);
          if ((parama != null) && (parama.description != null))
          {
            i = parama.description.indexOf('|');
            if ((i <= 0) || (parama.description.length() <= i + 1)) {
              continue;
            }
            localObject2 = parama.description.substring(i + 1);
            paramString.jBR.setText((CharSequence)localObject2);
          }
          if ((localObject1 != null) && (((String)localObject1).length() > 0))
          {
            localObject1 = ((String)localObject1).split(";");
            paramString.PQp.setText(localObject1[0]);
            if (localObject1.length > 1) {
              paramString.PQq.setText(localObject1[1]);
            }
          }
        }
        catch (Exception localException)
        {
          Object localObject1;
          Object localObject2;
          long l;
          Object localObject3;
          Log.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindConfirm", localException, "", new Object[0]);
          continue;
          paramString.PQt.setVisibility(8);
          paramString.jBR.setTextColor(this.PhN.Pwc.getMMResources().getColor(2131101327));
          paramString.PQq.setTextColor(this.PhN.Pwc.getMMResources().getColor(2131101327));
          paramString.PQp.setTextColor(this.PhN.Pwc.getMMResources().getColor(2131101327));
          continue;
          int i = 0;
          continue;
          paramString.PQr.setBackgroundResource(2131235454);
          continue;
        }
        bool1 = af.uT(parama1.FJX);
        if (!bool1) {
          continue;
        }
        paramString.PQt.setVisibility(0);
        paramString.jBR.setTextColor(this.PhN.Pwc.getMMResources().getColor(2131101328));
        paramString.PQq.setTextColor(this.PhN.Pwc.getMMResources().getColor(2131101328));
        paramString.PQp.setTextColor(this.PhN.Pwc.getMMResources().getColor(2131101328));
        paramString.PQr.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37493);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (af.isNullOrNil(paramca.field_imgPath))
            {
              Log.d("MicroMsg.ChattingItemVoiceRemindConfirm", "filename is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(37493);
              return;
            }
            ((aw)bg.a(bg.this).bh(aw.class)).gRx().b(paramInt, paramca);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37493);
          }
        });
        l = paramca.field_msgId;
        localObject1 = ((aw)this.PhN.bh(aw.class)).gRx();
        if ((localObject1 == null) || (!((com.tencent.mm.ui.chatting.d)localObject1).isPlaying()) || (((com.tencent.mm.ui.chatting.d)localObject1).Pei != l)) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        paramString.PQr.setBackgroundResource(2131235453);
        if ((parama1 != null) && (!af.isNullOrNil(parama1.FJZ)) && (parama1.FKa > 0) && (af.isNullOrNil(paramca.field_reserved)) && (parama != null))
        {
          localObject1 = k.Qv(z.aTY());
          localObject2 = com.tencent.mm.plugin.subapp.d.h.cz((String)localObject1, false);
          paramca.CA((String)localObject1);
          com.tencent.mm.model.bg.aVF();
          com.tencent.mm.model.c.aSQ().a(paramca.field_msgId, paramca);
          localObject1 = com.tencent.mm.pluginsdk.model.app.m.a((String)localObject2, paramca.field_msgId, parama.sdkVer, parama.appId, parama1.FJZ, parama1.FKa, parama.type, parama.iwM);
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.model.bg.azz();
            localObject3 = new com.tencent.mm.ak.i()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
              {
                AppMethodBeat.i(37494);
                Log.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousq.getType());
                boolean bool = false;
                if (ay.a.iDt != null) {
                  bool = ay.a.iDt.Ac(paramca.field_msgId);
                }
                if ((!bool) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (((com.tencent.mm.plugin.record.b.f)paramAnonymousq).getMediaId().equals(this.LY)))
                {
                  paramAnonymousString = ca.aZ(paramca);
                  paramAnonymousString.Cz(paramca.field_reserved);
                  paramAnonymousString.setMsgId(-1L);
                  ((aw)bg.a(bg.this).bh(aw.class)).gRx().b(paramInt, paramAnonymousString);
                }
                com.tencent.mm.model.bg.azz().b(221, bg.b(bg.this));
                bg.a(bg.this, null);
                AppMethodBeat.o(37494);
              }
            };
            this.onSceneEndCallback = ((com.tencent.mm.ak.i)localObject3);
            ((t)localObject2).a(221, (com.tencent.mm.ak.i)localObject3);
            localObject1 = new com.tencent.mm.plugin.record.b.f((String)localObject1);
            ((com.tencent.mm.plugin.record.b.f)localObject1).eIm();
            com.tencent.mm.model.bg.azz().a((q)localObject1, 0);
          }
        }
        if ((af.isNullOrNil(paramca.field_imgPath)) && (parama1.FKd > 0))
        {
          com.tencent.mm.model.bg.aVF();
          localObject1 = com.tencent.mm.model.c.aSQ().aJ(paramca.field_talker, parama1.FKd);
          if (!af.isNullOrNil(((eo)localObject1).field_imgPath))
          {
            localObject2 = k.Qv(z.aTY());
            localObject3 = com.tencent.mm.plugin.subapp.d.h.cz((String)localObject2, false);
            if (s.nw(com.tencent.mm.plugin.subapp.d.h.cz(((eo)localObject1).field_imgPath, false), (String)localObject3) >= 0L)
            {
              paramca.Cz((String)localObject2);
              com.tencent.mm.model.bg.aVF();
              com.tencent.mm.model.c.aSQ().a(paramca.field_msgId, paramca);
            }
          }
        }
        if ((af.isNullOrNil(paramca.field_imgPath)) && (parama1 != null) && (!af.isNullOrNil(parama1.dCK)) && (parama1.iwI > 0) && (this.onSceneEndCallback == null))
        {
          localObject1 = k.Qv(z.aTY());
          localObject2 = com.tencent.mm.plugin.subapp.d.h.cz((String)localObject1, false);
          paramca.Cz((String)localObject1);
          com.tencent.mm.model.bg.aVF();
          com.tencent.mm.model.c.aSQ().a(paramca.field_msgId, paramca);
          parama = com.tencent.mm.pluginsdk.model.app.m.a((String)localObject2, paramca.field_msgId, parama.sdkVer, parama.appId, parama.dCK, parama.iwI);
          Log.d("MicroMsg.ChattingItemVoiceRemindConfirm", "mediaId  " + parama.field_mediaSvrId);
          if (parama.field_mediaSvrId != null)
          {
            localObject1 = com.tencent.mm.model.bg.azz();
            localObject2 = new com.tencent.mm.ak.i()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
              {
                AppMethodBeat.i(37495);
                Log.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousq.getType());
                if (((com.tencent.mm.plugin.record.b.f)paramAnonymousq).getMediaId().equals(parama.field_mediaSvrId))
                {
                  com.tencent.mm.model.bg.azz().b(221, bg.b(bg.this));
                  bg.a(bg.this, null);
                }
                AppMethodBeat.o(37495);
              }
            };
            this.onSceneEndCallback = ((com.tencent.mm.ak.i)localObject2);
            ((t)localObject1).a(221, (com.tencent.mm.ak.i)localObject2);
            parama = new com.tencent.mm.plugin.record.b.f(parama);
            com.tencent.mm.model.bg.azz().a(parama, 0);
          }
        }
        paramString.PQs.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37499);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            com.tencent.mm.ui.base.h.a(bg.a(bg.this).Pwc.getContext(), 2131767195, 2131767197, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(37498);
                com.tencent.mm.model.bg.azz().a(331, bg.a(bg.this, new com.tencent.mm.ak.i()
                {
                  public final void onSceneEnd(int paramAnonymous3Int1, int paramAnonymous3Int2, String paramAnonymous3String, q paramAnonymous3q)
                  {
                    AppMethodBeat.i(37496);
                    Log.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymous3Int1 + " errCode " + paramAnonymous3Int2 + "  scene " + paramAnonymous3q.getType());
                    if ((paramAnonymous3Int1 == 0) && (paramAnonymous3Int2 == 0))
                    {
                      paramAnonymous3String = bg.4.this.PPX.field_content;
                      if (paramAnonymous3String == null) {
                        break label330;
                      }
                    }
                    label330:
                    for (paramAnonymous3String = k.b.HD(paramAnonymous3String);; paramAnonymous3String = null)
                    {
                      if (paramAnonymous3String != null)
                      {
                        long l = bg.4.this.PPX.field_msgId;
                        paramAnonymous3String = ao.cgO().Mp(l);
                        if (paramAnonymous3String != null) {
                          Log.i("MicroMsg.AppMsgLogic", "summerapp deleteAttachInfoAndFile deleteFile[%b] deleteInfo[%b] msgInfoId[%d] mediaSvrId[%s] path[%s] stack[%s]", new Object[] { Boolean.valueOf(s.deleteFile(paramAnonymous3String.field_fileFullPath)), Boolean.valueOf(ao.cgO().delete(paramAnonymous3String, new String[] { "msgInfoId" })), Long.valueOf(paramAnonymous3String.field_msgInfoId), paramAnonymous3String.field_mediaSvrId, paramAnonymous3String.field_fileFullPath, Util.getStack() });
                        }
                      }
                      bp.Ad(bg.4.this.PPX.field_msgId);
                      Toast.makeText(bg.a(bg.this).Pwc.getContext(), bg.a(bg.this).Pwc.getMMResources().getString(2131757421), 0).show();
                      com.tencent.mm.model.bg.azz().b(331, bg.b(bg.this));
                      bg.a(bg.this, null);
                      if (bg.c(bg.this) != null) {
                        bg.c(bg.this).dismiss();
                      }
                      AppMethodBeat.o(37496);
                      return;
                    }
                  }
                }));
                paramAnonymous2DialogInterface = new LinkedList();
                Object localObject = new esj();
                ((esj)localObject).KIB = bg.4.this.PQb.FJY;
                paramAnonymous2DialogInterface.add(localObject);
                paramAnonymous2DialogInterface = new com.tencent.mm.plugin.subapp.d.a(paramAnonymous2DialogInterface, paramAnonymous2DialogInterface.size());
                com.tencent.mm.model.bg.azz().a(paramAnonymous2DialogInterface, 0);
                localObject = bg.this;
                Activity localActivity = bg.a(bg.this).Pwc.getContext();
                bg.a(bg.this).Pwc.getMMResources().getString(2131755998);
                bg.a((bg)localObject, com.tencent.mm.ui.base.h.a(localActivity, bg.a(bg.this).Pwc.getMMResources().getString(2131757422), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                  {
                    AppMethodBeat.i(37497);
                    com.tencent.mm.model.bg.azz().a(paramAnonymous2DialogInterface);
                    com.tencent.mm.model.bg.azz().b(331, bg.b(bg.this));
                    bg.a(bg.this, null);
                    if (bg.c(bg.this) != null) {
                      bg.c(bg.this).dismiss();
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
        paramString.clickArea.setTag(new bq(paramca, this.PhN.gRM(), paramInt, null, '\000'));
        com.tencent.mm.model.bg.aVF();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
          paramString.clickArea.setOnLongClickListener(c(this.PhN));
        }
        AppMethodBeat.o(37501);
        return;
        paramString.jBR.setText("");
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(37503);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37503);
      return false;
    }
    paramMenuItem = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bp.b(parama.gRM(), paramca.field_content, paramca.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", paramca.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37503);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.m paramm, View paramView, ca paramca)
  {
    AppMethodBeat.i(233968);
    int i = ((bq)paramView.getTag()).position;
    int j = com.tencent.mm.pluginsdk.model.app.m.bdI(bp.b(this.PhN.gRM(), paramca.field_content, paramca.field_isSend));
    paramView = k.b.HD(bp.b(this.PhN.gRM(), paramca.field_content, paramca.field_isSend));
    if ((paramView.iwI <= 0) || ((paramView.iwI > 0) && (j >= 100))) {
      paramm.a(i, 111, this.PhN.Pwc.getMMResources().getString(2131764628), 2131690674);
    }
    if (!this.PhN.gRN()) {
      paramm.a(i, 100, this.PhN.Pwc.getMMResources().getString(2131757433), 2131690529);
    }
    AppMethodBeat.o(233968);
    return true;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048189;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bg
 * JD-Core Version:    0.7.0.1
 */