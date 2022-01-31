package com.tencent.mm.ui.chatting.viewitems;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.aj;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class ap
  extends c
{
  private f onSceneEndCallback;
  private ProgressDialog qHd;
  private a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33390);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969130);
      ((View)localObject).setTag(new av().fq((View)localObject));
    }
    AppMethodBeat.o(33390);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33391);
    paramString = (av)parama;
    this.zzP = parama1;
    parama = al.dlL().nx(parambi.field_msgId);
    parama1 = parambi.field_content;
    if ((parama != null) && (parama1 != null)) {}
    for (parama = j.b.mY(parama1);; parama = null)
    {
      boolean bool2 = false;
      parama1 = com.tencent.mm.plugin.subapp.c.e.adQ(parama1);
      boolean bool1 = bool2;
      if (parama1 != null)
      {
        bool1 = bool2;
        if (parama1.sXm == 0) {}
      }
      for (;;)
      {
        try
        {
          localObject1 = com.tencent.mm.pluginsdk.f.h.ah(this.zzP.zJz.getContext(), parama1.sXm);
          if ((parama != null) && (parama.description != null))
          {
            i = parama.description.indexOf('|');
            if ((i <= 0) || (parama.description.length() <= i + 1)) {
              continue;
            }
            localObject2 = parama.description.substring(i + 1);
            paramString.gpM.setText((CharSequence)localObject2);
          }
          if ((localObject1 != null) && (((String)localObject1).length() > 0))
          {
            localObject1 = ((String)localObject1).split(";");
            paramString.zYq.setText(localObject1[0]);
            if (localObject1.length > 1) {
              paramString.zYr.setText(localObject1[1]);
            }
          }
        }
        catch (Exception localException)
        {
          Object localObject1;
          Object localObject2;
          long l;
          Object localObject3;
          ab.printErrStackTrace("MicroMsg.ChattingItemVoiceRemindConfirm", localException, "", new Object[0]);
          continue;
          paramString.zYu.setVisibility(8);
          paramString.gpM.setTextColor(this.zzP.zJz.getMMResources().getColor(2131690628));
          paramString.zYr.setTextColor(this.zzP.zJz.getMMResources().getColor(2131690628));
          paramString.zYq.setTextColor(this.zzP.zJz.getMMResources().getColor(2131690628));
          continue;
          int i = 0;
          continue;
          paramString.zYs.setBackgroundResource(2130840685);
          continue;
        }
        bool1 = ah.mI(parama1.sXm);
        if (!bool1) {
          continue;
        }
        paramString.zYu.setVisibility(0);
        paramString.gpM.setTextColor(this.zzP.zJz.getMMResources().getColor(2131690629));
        paramString.zYr.setTextColor(this.zzP.zJz.getMMResources().getColor(2131690629));
        paramString.zYq.setTextColor(this.zzP.zJz.getMMResources().getColor(2131690629));
        paramString.zYs.setOnClickListener(new ap.1(this, parambi, paramInt));
        l = parambi.field_msgId;
        localObject1 = ((aj)this.zzP.ay(aj.class)).dJv();
        if ((localObject1 == null) || (!((d)localObject1).isPlaying()) || (((d)localObject1).zwt != l)) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        paramString.zYs.setBackgroundResource(2130840684);
        if ((parama1 != null) && (!ah.isNullOrNil(parama1.sXo)) && (parama1.sXp > 0) && (ah.isNullOrNil(parambi.field_reserved)) && (parama != null))
        {
          localObject1 = com.tencent.mm.plugin.subapp.c.k.ve(r.Zn());
          localObject2 = com.tencent.mm.plugin.subapp.c.h.bE((String)localObject1, false);
          parambi.kl((String)localObject1);
          aw.aaz();
          com.tencent.mm.model.c.YC().a(parambi.field_msgId, parambi);
          localObject1 = l.a((String)localObject2, parambi.field_msgId, parama.sdkVer, parama.appId, parama1.sXo, parama1.sXp, parama.type, parama.fgA);
          if (localObject1 != null)
          {
            localObject2 = aw.Rc();
            localObject3 = new ap.2(this, parambi, (String)localObject1, paramInt);
            this.onSceneEndCallback = ((f)localObject3);
            ((p)localObject2).a(221, (f)localObject3);
            localObject1 = new com.tencent.mm.plugin.record.b.e((String)localObject1);
            ((com.tencent.mm.plugin.record.b.e)localObject1).cfO();
            aw.Rc().a((m)localObject1, 0);
          }
        }
        if ((ah.isNullOrNil(parambi.field_imgPath)) && (parama1.sXs > 0))
        {
          aw.aaz();
          localObject1 = com.tencent.mm.model.c.YC().ag(parambi.field_talker, parama1.sXs);
          if (!ah.isNullOrNil(((dd)localObject1).field_imgPath))
          {
            localObject2 = com.tencent.mm.plugin.subapp.c.k.ve(r.Zn());
            localObject3 = com.tencent.mm.plugin.subapp.c.h.bE((String)localObject2, false);
            if (com.tencent.mm.vfs.e.C(com.tencent.mm.plugin.subapp.c.h.bE(((dd)localObject1).field_imgPath, false), (String)localObject3) >= 0L)
            {
              parambi.kk((String)localObject2);
              aw.aaz();
              com.tencent.mm.model.c.YC().a(parambi.field_msgId, parambi);
            }
          }
        }
        if ((ah.isNullOrNil(parambi.field_imgPath)) && (parama1 != null) && (!ah.isNullOrNil(parama1.cmN)) && (parama1.fgw > 0) && (this.onSceneEndCallback == null))
        {
          localObject1 = com.tencent.mm.plugin.subapp.c.k.ve(r.Zn());
          localObject2 = com.tencent.mm.plugin.subapp.c.h.bE((String)localObject1, false);
          parambi.kk((String)localObject1);
          aw.aaz();
          com.tencent.mm.model.c.YC().a(parambi.field_msgId, parambi);
          parama = l.a((String)localObject2, parambi.field_msgId, parama.sdkVer, parama.appId, parama.cmN, parama.fgw);
          ab.d("MicroMsg.ChattingItemVoiceRemindConfirm", "mediaId  " + parama.field_mediaSvrId);
          if (parama.field_mediaSvrId != null)
          {
            localObject1 = aw.Rc();
            localObject2 = new ap.3(this, parama);
            this.onSceneEndCallback = ((f)localObject2);
            ((p)localObject1).a(221, (f)localObject2);
            parama = new com.tencent.mm.plugin.record.b.e(parama);
            aw.Rc().a(parama, 0);
          }
        }
        paramString.zYt.setOnClickListener(new ap.4(this, parambi, parama1));
        paramString.jYu.setTag(new az(parambi, this.zzP.dJG(), paramInt, null, '\000'));
        aw.aaz();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
          paramString.jYu.setOnLongClickListener(c(this.zzP));
        }
        AppMethodBeat.o(33391);
        return;
        paramString.gpM.setText("");
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33392);
    int i = ((az)paramView.getTag()).position;
    int j = l.alu(bf.b(this.zzP.dJG(), parambi.field_content, parambi.field_isSend));
    paramView = j.b.mY(bf.b(this.zzP.dJG(), parambi.field_content, parambi.field_isSend));
    if ((paramView.fgw <= 0) || ((paramView.fgw > 0) && (j >= 100))) {
      paramContextMenu.add(i, 111, 0, this.zzP.zJz.getMMResources().getString(2131302650));
    }
    if (!this.zzP.dJH()) {
      paramContextMenu.add(i, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
    }
    AppMethodBeat.o(33392);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    AppMethodBeat.i(33393);
    switch (paramMenuItem.getItemId())
    {
    default: 
      AppMethodBeat.o(33393);
      return false;
    }
    paramMenuItem = new Intent(parama.zJz.getContext(), MsgRetransmitUI.class);
    paramMenuItem.putExtra("Retr_Msg_content", bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend));
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Msg_Id", parambi.field_msgId);
    parama.startActivity(paramMenuItem);
    AppMethodBeat.o(33393);
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048189;
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    return true;
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
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ap
 * JD-Core Version:    0.7.0.1
 */