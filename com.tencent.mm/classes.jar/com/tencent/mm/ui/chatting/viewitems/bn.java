package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.am.j;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.record.model.g;
import com.tencent.mm.plugin.subapp.modelvoiceremind.e;
import com.tencent.mm.plugin.subapp.modelvoiceremind.k;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.api.bf;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.vfs.y;

public final class bn
  extends c
{
  private com.tencent.mm.ui.chatting.d.a aeiK;
  private com.tencent.mm.am.h onSceneEndCallback;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37506);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ap(paramLayoutInflater, R.i.ghl);
      ((View)localObject).setTag(new cg().lS((View)localObject));
    }
    AppMethodBeat.o(37506);
    return localObject;
  }
  
  public final String a(com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37507);
    parama = parama.getTalkerUserName();
    AppMethodBeat.o(37507);
    return parama;
  }
  
  public final void a(c.a parama, final int paramInt, com.tencent.mm.ui.chatting.d.a parama1, final cc paramcc, String paramString)
  {
    AppMethodBeat.i(37508);
    localcg = (cg)parama;
    this.aeiK = parama1;
    Object localObject2 = as.iIJ().rI(paramcc.field_msgId);
    Object localObject1 = paramcc.field_content;
    parama = null;
    paramString = parama;
    if (localObject2 != null)
    {
      paramString = parama;
      if (localObject1 != null) {
        paramString = k.b.aP((String)localObject1, paramcc.field_reserved);
      }
    }
    localObject2 = e.bcA((String)localObject1);
    if ((localObject2 != null) && (((e)localObject2).SFk != 0)) {}
    try
    {
      localObject3 = f.bk(parama1.aezO.getContext(), ((e)localObject2).SFk);
      localObject1 = "";
      parama = (c.a)localObject1;
      if (localObject3 != null)
      {
        parama = (c.a)localObject1;
        if (((String)localObject3).length() > 0)
        {
          localObject3 = ((String)localObject3).split(";");
          localObject1 = "" + localObject3[0].replace(" ", "");
          parama = (c.a)localObject1;
          if (localObject3.length > 1) {
            parama = (String)localObject1 + localObject3[1];
          }
        }
      }
      localObject1 = parama;
      if (paramString != null)
      {
        localObject1 = parama;
        if (paramString.description != null) {
          localObject1 = parama + " " + paramString.description;
        }
      }
      localcg.plr.setText((CharSequence)localObject1);
    }
    catch (Exception parama)
    {
      for (;;)
      {
        Object localObject3;
        long l;
        Log.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindRemind", parama, "", new Object[0]);
        continue;
        int i = 0;
        continue;
        localcg.aeZg.setImageResource(R.g.music_playicon);
      }
    }
    Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "content remind " + Util.secPrint(paramcc.field_content));
    if ((Util.isNullOrNil(paramcc.field_imgPath)) && (((e)localObject2).SFq > 0))
    {
      bh.bCz();
      parama = com.tencent.mm.model.c.bzD().aU(paramcc.field_talker, ((e)localObject2).SFq);
      if ((parama != null) && (!Util.isNullOrNil(parama.field_imgPath)))
      {
        localObject1 = k.PW(z.bAM());
        localObject3 = com.tencent.mm.plugin.subapp.modelvoiceremind.h.dt((String)localObject1, false);
        if (y.O(com.tencent.mm.plugin.subapp.modelvoiceremind.h.dt(parama.field_imgPath, false), (String)localObject3, false) >= 0L)
        {
          paramcc.BT((String)localObject1);
          bh.bCz();
          com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
        }
      }
    }
    if ((Util.isNullOrNil(paramcc.field_imgPath)) && (localObject2 != null) && (((e)localObject2).hzM != null) && (((e)localObject2).hzM.length() > 0) && (((e)localObject2).nRd > 0) && (this.onSceneEndCallback == null))
    {
      parama = k.PW(z.bAM());
      localObject1 = com.tencent.mm.plugin.subapp.modelvoiceremind.h.dt(parama, false);
      if (Util.isNullOrNil(paramcc.field_imgPath))
      {
        paramcc.BT(parama);
        bh.bCz();
        com.tencent.mm.model.c.bzD().a(paramcc.field_msgId, paramcc);
        Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "content.attachid " + paramString.hzM);
        parama = n.a((String)localObject1, paramcc.field_msgId, paramString.sdkVer, paramString.appId, paramString.hzM, paramString.nRd);
        Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "ainfo.field_mediaSvrId " + parama.field_mediaSvrId);
        if (parama.field_mediaSvrId != null)
        {
          paramString = bh.aZW();
          localObject1 = new com.tencent.mm.am.h()
          {
            public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
            {
              AppMethodBeat.i(37504);
              Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "errType " + paramAnonymousInt1 + " errCode " + paramAnonymousInt2 + "  scene " + paramAnonymousp.getType());
              bh.aZW().b(221, bn.a(bn.this));
              bn.b(bn.this);
              AppMethodBeat.o(37504);
            }
          };
          this.onSceneEndCallback = ((com.tencent.mm.am.h)localObject1);
          paramString.a(221, (com.tencent.mm.am.h)localObject1);
          Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "doscene");
          parama = new g(parama);
          bh.aZW().a(parama, 0);
        }
      }
    }
    localcg.aeZg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(37505);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        if (Util.isNullOrNil(paramcc.field_imgPath))
        {
          Log.d("MicroMsg.ChattingItemVoiceRemindRemind", "filename is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37505);
          return;
        }
        paramAnonymousView = ((bf)bn.c(bn.this).cm(bf.class)).jut();
        int i = paramInt;
        localObject = paramcc;
        if (localObject != null)
        {
          paramAnonymousView.joz();
          bh.bCz();
          Boolean localBoolean = (Boolean)com.tencent.mm.model.c.ban().d(4115, null);
          if ((localBoolean == null) || (!localBoolean.booleanValue()))
          {
            bh.bCz();
            com.tencent.mm.model.c.ban().B(4115, Boolean.TRUE);
            paramAnonymousView.joF();
            paramAnonymousView.aeeW = aa.a(paramAnonymousView.hlc.aezO.getActivity(), paramAnonymousView.context.getString(R.l.gyQ), 4000L);
          }
          if ((!paramAnonymousView.xCQ.isPlaying()) || (((fi)localObject).field_msgId != paramAnonymousView.aeeT)) {
            break label239;
          }
          paramAnonymousView.joD();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(37505);
          return;
          label239:
          paramAnonymousView.bL((cc)localObject);
          if ((((fi)localObject).field_isSend == 0) && (!com.tencent.mm.modelvoice.s.aw((cc)localObject))) {
            paramAnonymousView.aBC(i + 1);
          }
          paramAnonymousView.bN(true, false);
        }
      }
    });
    l = paramcc.field_msgId;
    parama = ((bf)this.aeiK.cm(bf.class)).jut();
    if ((parama.isPlaying()) && (parama.aeeT == l))
    {
      i = 1;
      if (i == 0) {
        break label805;
      }
      localcg.aeZg.setImageResource(R.g.music_pauseicon);
      localcg.clickArea.setTag(new bz(paramcc, parama1.juG(), paramInt, null, '\000'));
      bh.bCz();
      if (com.tencent.mm.model.c.isSDCardAvailable()) {
        localcg.clickArea.setOnLongClickListener(c(parama1));
      }
      AppMethodBeat.o(37508);
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37510);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(37510);
      return false;
    }
    paramMenuItem = new Intent(parama.aezO.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", paramcc.field_msgId);
    paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
    com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    parama.startActivity((Intent)paramMenuItem.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoiceRemindRemind", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(37510);
    return false;
  }
  
  public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    AppMethodBeat.i(255335);
    int i = ((bz)paramView.getTag()).position;
    int j = n.bpT(br.a(this.aeiK.juG(), paramcc.field_content, paramcc.field_isSend));
    paramView = k.b.Hf(br.a(this.aeiK.juG(), paramcc.field_content, paramcc.field_isSend));
    if ((paramView.nRd <= 0) || ((paramView.nRd > 0) && (j >= 100))) {
      params.a(i, 111, this.aeiK.aezO.getMMResources().getString(R.l.retransmit), R.k.icons_filled_share);
    }
    if (!this.aeiK.juH()) {
      params.a(i, 100, this.aeiK.aezO.getMMResources().getString(R.l.gyo), R.k.icons_filled_delete);
    }
    AppMethodBeat.o(255335);
    return true;
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.d.a parama)
  {
    return false;
  }
  
  public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    return true;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048190;
  }
  
  public final boolean fXn()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bn
 * JD-Core Version:    0.7.0.1
 */