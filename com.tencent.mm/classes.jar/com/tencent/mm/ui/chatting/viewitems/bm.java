package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.f;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.record.model.g;
import com.tencent.mm.plugin.subapp.modelvoiceremind.e;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.protocal.protobuf.fzg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.bf;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;

public final class bm
  extends c
{
  private ProgressDialog PqL;
  private com.tencent.mm.ui.chatting.d.a aeiK;
  private com.tencent.mm.am.h onSceneEndCallback;
  
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
      localObject = new ap(paramLayoutInflater, R.i.ghk);
      ((View)localObject).setTag(new bs().lQ((View)localObject));
    }
    AppMethodBeat.o(37500);
    return localObject;
  }
  
  public final void a(final c.a parama, final int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, final cc paramcc, String paramString)
  {
    AppMethodBeat.i(37501);
    paramString = (bs)parama;
    this.aeiK = parama1;
    parama = as.iIJ().rI(paramcc.field_msgId);
    parama1 = paramcc.field_content;
    if ((parama != null) && (parama1 != null)) {}
    for (parama = k.b.Hf(parama1);; parama = null)
    {
      boolean bool2 = false;
      parama1 = e.bcA(parama1);
      boolean bool1 = bool2;
      if (parama1 != null)
      {
        bool1 = bool2;
        if (parama1.SFk == 0) {}
      }
      for (;;)
      {
        try
        {
          localObject1 = f.bk(this.aeiK.aezO.getContext(), parama1.SFk);
          if ((parama != null) && (parama.description != null))
          {
            i = parama.description.indexOf('|');
            if ((i <= 0) || (parama.description.length() <= i + 1)) {
              continue;
            }
            localObject2 = parama.description.substring(i + 1);
            paramString.plr.setText((CharSequence)localObject2);
          }
          if ((localObject1 != null) && (((String)localObject1).length() > 0))
          {
            localObject1 = ((String)localObject1).split(";");
            paramString.aeXu.setText(localObject1[0]);
            if (localObject1.length > 1) {
              paramString.aeXv.setText(localObject1[1]);
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
          paramString.aeXy.setVisibility(8);
          paramString.plr.setTextColor(this.aeiK.aezO.getMMResources().getColor(R.e.flf));
          paramString.aeXv.setTextColor(this.aeiK.aezO.getMMResources().getColor(R.e.flf));
          paramString.aeXu.setTextColor(this.aeiK.aezO.getMMResources().getColor(R.e.flf));
          continue;
          int i = 0;
          continue;
          paramString.aeXw.setBackgroundResource(R.g.fpK);
          continue;
        }
        bool1 = ab.yc(parama1.SFk);
        if (!bool1) {
          continue;
        }
        paramString.aeXy.setVisibility(0);
        paramString.plr.setTextColor(this.aeiK.aezO.getMMResources().getColor(R.e.flg));
        paramString.aeXv.setTextColor(this.aeiK.aezO.getMMResources().getColor(R.e.flg));
        paramString.aeXu.setTextColor(this.aeiK.aezO.getMMResources().getColor(R.e.flg));
        paramString.aeXw.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37493);
            b localb = new b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (ab.isNullOrNil(paramcc.field_imgPath))
            {
              Log.d("MicroMsg.ChattingItemVoiceRemindConfirm", "filename is null");
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(37493);
              return;
            }
            ((bf)bm.a(bm.this).cm(bf.class)).jut().c(paramInt, paramcc);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37493);
          }
        });
        l = paramcc.field_msgId;
        localObject1 = ((bf)this.aeiK.cm(bf.class)).jut();
        if ((localObject1 == null) || (!((com.tencent.mm.ui.chatting.d)localObject1).isPlaying()) || (((com.tencent.mm.ui.chatting.d)localObject1).aeeT != l)) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        paramString.aeXw.setBackgroundResource(R.g.fpJ);
        if ((parama1 != null) && (!ab.isNullOrNil(parama1.SFm)) && (parama1.SFn > 0) && (ab.isNullOrNil(paramcc.field_reserved)) && (parama != null))
        {
          localObject1 = com.tencent.mm.plugin.subapp.modelvoiceremind.k.PW(z.bAM());
          localObject2 = com.tencent.mm.plugin.subapp.modelvoiceremind.h.dt((String)localObject1, false);
          paramcc.BU((String)localObject1);
          bh.bCz();
          com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
          localObject1 = n.a((String)localObject2, paramcc.field_msgId, parama.sdkVer, parama.appId, parama1.SFm, parama1.SFn, parama.type, parama.nRh);
          if (localObject1 != null)
          {
            localObject2 = bh.aZW();
            localObject3 = new com.tencent.mm.am.h()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
              {
                AppMethodBeat.i(37494);
                Log.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousp.getType());
                boolean bool = false;
                if (az.a.okS != null) {
                  bool = az.a.okS.it(paramcc.field_msgId);
                }
                if ((!bool) && (paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0) && (((g)paramAnonymousp).getMediaId().equals(this.bJZ)))
                {
                  paramAnonymousString = cc.bI(paramcc);
                  paramAnonymousString.BT(paramcc.field_reserved);
                  paramAnonymousString.setMsgId(-1L);
                  ((bf)bm.a(bm.this).cm(bf.class)).jut().c(paramInt, paramAnonymousString);
                }
                bh.aZW().b(221, bm.b(bm.this));
                bm.a(bm.this, null);
                AppMethodBeat.o(37494);
              }
            };
            this.onSceneEndCallback = ((com.tencent.mm.am.h)localObject3);
            ((com.tencent.mm.am.s)localObject2).a(221, (com.tencent.mm.am.h)localObject3);
            localObject1 = new g((String)localObject1);
            ((g)localObject1).gGg();
            bh.aZW().a((p)localObject1, 0);
          }
        }
        if ((ab.isNullOrNil(paramcc.field_imgPath)) && (parama1.SFq > 0))
        {
          bh.bCz();
          localObject1 = com.tencent.mm.model.c.bzD().aU(paramcc.field_talker, parama1.SFq);
          if ((localObject1 != null) && (!ab.isNullOrNil(((fi)localObject1).field_imgPath)))
          {
            localObject2 = com.tencent.mm.plugin.subapp.modelvoiceremind.k.PW(z.bAM());
            localObject3 = com.tencent.mm.plugin.subapp.modelvoiceremind.h.dt((String)localObject2, false);
            if (y.O(com.tencent.mm.plugin.subapp.modelvoiceremind.h.dt(((fi)localObject1).field_imgPath, false), (String)localObject3, false) >= 0L)
            {
              paramcc.BT((String)localObject2);
              bh.bCz();
              com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
            }
          }
        }
        if ((ab.isNullOrNil(paramcc.field_imgPath)) && (parama1 != null) && (!ab.isNullOrNil(parama1.hzM)) && (parama1.nRd > 0) && (this.onSceneEndCallback == null))
        {
          localObject1 = com.tencent.mm.plugin.subapp.modelvoiceremind.k.PW(z.bAM());
          localObject2 = com.tencent.mm.plugin.subapp.modelvoiceremind.h.dt((String)localObject1, false);
          paramcc.BT((String)localObject1);
          bh.bCz();
          com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
          parama = n.a((String)localObject2, paramcc.field_msgId, parama.sdkVer, parama.appId, parama.hzM, parama.nRd);
          Log.d("MicroMsg.ChattingItemVoiceRemindConfirm", "mediaId  " + parama.field_mediaSvrId);
          if (parama.field_mediaSvrId != null)
          {
            localObject1 = bh.aZW();
            localObject2 = new com.tencent.mm.am.h()
            {
              public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
              {
                AppMethodBeat.i(37495);
                Log.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousp.getType());
                if (((g)paramAnonymousp).getMediaId().equals(parama.field_mediaSvrId))
                {
                  bh.aZW().b(221, bm.b(bm.this));
                  bm.a(bm.this, null);
                }
                AppMethodBeat.o(37495);
              }
            };
            this.onSceneEndCallback = ((com.tencent.mm.am.h)localObject2);
            ((com.tencent.mm.am.s)localObject1).a(221, (com.tencent.mm.am.h)localObject2);
            parama = new g(parama);
            bh.aZW().a(parama, 0);
          }
        }
        paramString.aeXx.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(37499);
            b localb = new b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            com.tencent.mm.ui.base.k.a(bm.a(bm.this).aezO.getContext(), R.l.gYp, R.l.gYr, new DialogInterface.OnClickListener()
            {
              public final void onClick(final DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(37498);
                bh.aZW().a(331, bm.a(bm.this, new com.tencent.mm.am.h()
                {
                  public final void onSceneEnd(int paramAnonymous3Int1, int paramAnonymous3Int2, String paramAnonymous3String, p paramAnonymous3p)
                  {
                    AppMethodBeat.i(37496);
                    Log.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramAnonymous3Int1 + " errCode " + paramAnonymous3Int2 + "  scene " + paramAnonymous3p.getType());
                    if ((paramAnonymous3Int1 == 0) && (paramAnonymous3Int2 == 0))
                    {
                      paramAnonymous3String = bm.4.this.aeXc.field_content;
                      if (paramAnonymous3String == null) {
                        break label331;
                      }
                    }
                    label331:
                    for (paramAnonymous3String = k.b.Hf(paramAnonymous3String);; paramAnonymous3String = null)
                    {
                      if (paramAnonymous3String != null)
                      {
                        long l = bm.4.this.aeXc.field_msgId;
                        paramAnonymous3String = as.cWJ().yi(l);
                        if (paramAnonymous3String != null) {
                          Log.i("MicroMsg.AppMsgLogic", "summerapp deleteAttachInfoAndFile deleteFile[%b] deleteInfo[%b] msgInfoId[%d] mediaSvrId[%s] path[%s] stack[%s]", new Object[] { Boolean.valueOf(y.deleteFile(paramAnonymous3String.field_fileFullPath)), Boolean.valueOf(as.cWJ().delete(paramAnonymous3String, new String[] { "msgInfoId" })), Long.valueOf(paramAnonymous3String.field_msgInfoId), paramAnonymous3String.field_mediaSvrId, paramAnonymous3String.field_fileFullPath, Util.getStack() });
                        }
                      }
                      br.iu(bm.4.this.aeXc.field_msgId);
                      Toast.makeText(bm.a(bm.this).aezO.getContext(), bm.a(bm.this).aezO.getMMResources().getString(R.l.gye), 0).show();
                      bh.aZW().b(331, bm.b(bm.this));
                      bm.a(bm.this, null);
                      if (bm.c(bm.this) != null) {
                        bm.c(bm.this).dismiss();
                      }
                      AppMethodBeat.o(37496);
                      return;
                    }
                  }
                }));
                paramAnonymous2DialogInterface = new LinkedList();
                Object localObject = new fzg();
                ((fzg)localObject).YHm = bm.4.this.aeXg.SFl;
                paramAnonymous2DialogInterface.add(localObject);
                paramAnonymous2DialogInterface = new com.tencent.mm.plugin.subapp.modelvoiceremind.a(paramAnonymous2DialogInterface, paramAnonymous2DialogInterface.size());
                bh.aZW().a(paramAnonymous2DialogInterface, 0);
                localObject = bm.this;
                Activity localActivity = bm.a(bm.this).aezO.getContext();
                bm.a(bm.this).aezO.getMMResources().getString(R.l.app_tip);
                bm.a((bm)localObject, com.tencent.mm.ui.base.k.a(localActivity, bm.a(bm.this).aezO.getMMResources().getString(R.l.gyf), true, new DialogInterface.OnCancelListener()
                {
                  public final void onCancel(DialogInterface paramAnonymous3DialogInterface)
                  {
                    AppMethodBeat.i(37497);
                    bh.aZW().a(paramAnonymous2DialogInterface);
                    bh.aZW().b(331, bm.b(bm.this));
                    bm.a(bm.this, null);
                    if (bm.c(bm.this) != null) {
                      bm.c(bm.this).dismiss();
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
        paramString.clickArea.setTag(new bz(paramcc, this.aeiK.juG(), paramInt, null, '\000'));
        bh.bCz();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
          paramString.clickArea.setOnLongClickListener(c(this.aeiK));
        }
        AppMethodBeat.o(37501);
        return;
        paramString.plr.setText("");
      }
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37503);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37503);
      return false;
    }
    paramMenuItem = new Intent(parama.aezO.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", paramcc.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindConfirm", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37503);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255287);
    int i = ((bz)paramView.getTag()).position;
    int j = n.bpT(br.a(this.aeiK.juG(), paramcc.field_content, paramcc.field_isSend));
    paramView = k.b.Hf(br.a(this.aeiK.juG(), paramcc.field_content, paramcc.field_isSend));
    if ((paramView.nRd <= 0) || ((paramView.nRd > 0) && (j >= 100))) {
      params.a(i, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
    }
    if (!this.aeiK.juH()) {
      params.a(i, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
    }
    AppMethodBeat.o(255287);
    return true;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return true;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048189;
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
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bm
 * JD-Core Version:    0.7.0.1
 */