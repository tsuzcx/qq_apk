package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ag;
import com.tencent.mm.ui.chatting.c.b.aj;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class ao$b
  extends c
  implements s.n
{
  private int vSt = 3;
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33367);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969125);
      ((View)localObject).setTag(new ao.c().c((View)localObject, false, this.zvB));
    }
    AppMethodBeat.o(33367);
    return localObject;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33372);
    ((aj)parama.ay(aj.class)).bp(parambi);
    AppMethodBeat.o(33372);
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33368);
    this.zzP = parama1;
    ao.c localc = (ao.c)parama;
    localc.zXQ.setFromVoice(false);
    localc.zXQ.setFromGroup(parama1.dJG());
    com.tencent.mm.ui.chatting.c.b.h localh = (com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class);
    a(localh, parambi.field_msgId);
    ao.c.a(localc, parambi, paramInt, parama1, false, c(parama1));
    Object localObject = (ag)parama1.ay(ag.class);
    paramString = null;
    parama = ChattingItemTranslate.b.zXu;
    if (ao.c(parambi, parama1))
    {
      localObject = ((ag)localObject).D(parambi.field_msgId, parambi.field_imgPath);
      paramString = (String)localObject;
      if (!bo.isNullOrNil((String)localObject))
      {
        parama = ChattingItemTranslate.b.zXx;
        paramString = (String)localObject;
      }
      if ((bo.isNullOrNil(paramString)) && (parama == ChattingItemTranslate.b.zXu)) {
        break label464;
      }
      if (localc.zXi == null)
      {
        localc.zXi = ((ChattingItemTranslate)localc.zXh.inflate());
        localc.zXi.setMinimumWidth(localc.zXN - com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 5));
        localc.zXi.init();
      }
      localc.zXi.a(paramString, parama);
      if (!bo.isNullOrNil(paramString))
      {
        parama = new ChattingItemTranslate.a(parambi, parama1.dJG(), paramInt);
        parama.kwo = 2;
        localc.zXi.setTag(parama);
        localc.zXi.setOnTouchListener(localh.dHi());
        localc.zXi.setOnDoubleClickListener(new ao.b.1(this, paramString, parambi));
        localc.zXi.setOnLongClickListener(c(parama1));
        localc.zXi.setVisibility(0);
      }
      label313:
      if (!dLr()) {
        break label571;
      }
      if (localc.zXV != null) {
        localc.zXV.setVisibility(8);
      }
      if (localc.zSm != null) {
        localc.zSm.setVisibility(8);
      }
      if ((parambi.field_status != 1) && (parambi.field_status != 5)) {
        break label485;
      }
      localc.zXW.setBackgroundResource(2130838368);
      parambi.yOd = true;
    }
    for (;;)
    {
      a(paramInt, localc, parambi, parama1.dJD(), parama1.dJG(), parama1, this);
      AppMethodBeat.o(33368);
      return;
      if (!((ag)localObject).oG(parambi.field_msgId)) {
        break;
      }
      paramString = ((ag)localObject).D(parambi.field_msgId, parambi.field_imgPath);
      parama = ((ag)localObject).oF(parambi.field_msgId);
      break;
      label464:
      if (localc.zXi == null) {
        break label313;
      }
      localc.zXi.setVisibility(8);
      break label313;
      label485:
      localc.zXW.setBackgroundResource(2130838367);
      if ((localc.zSm != null) && (a(localh, parambi.field_msgId)))
      {
        if (parambi.yOd)
        {
          parama = new AlphaAnimation(0.5F, 1.0F);
          parama.setDuration(300L);
          localc.zXW.startAnimation(parama);
          parambi.yOd = false;
        }
        localc.zSm.setVisibility(0);
        continue;
        label571:
        if (localc.zXV != null)
        {
          localc.zXV.setVisibility(0);
          if (parambi.field_status >= 2) {
            localc.zXV.setVisibility(8);
          }
        }
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33369);
    aw.aaz();
    Object localObject;
    int k;
    ag localag;
    int i;
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      localObject = (ChattingItemTranslate.a)paramView.getTag();
      k = ((ChattingItemTranslate.a)localObject).position;
      if (((ChattingItemTranslate.a)localObject).kwo == 1)
      {
        localObject = new p(parambi.field_content);
        if (((((p)localObject).time != 0L) || (parambi.field_isSend != 0)) && ((parambi.field_status != 1) || (parambi.field_isSend != 1)))
        {
          if (((aj)this.zzP.ay(aj.class)).dJx()) {
            paramContextMenu.add(k, 120, 0, 2131298107);
          }
        }
        else
        {
          if (parambi.field_status == 5) {
            paramContextMenu.add(k, 103, 0, paramView.getContext().getString(2131298295));
          }
          if (d.ahR("favorite")) {
            paramContextMenu.add(k, 116, 0, paramView.getContext().getString(2131302102));
          }
          if ((!parambi.dvV()) && (parambi.dvW()) && ((parambi.field_status == 2) || (parambi.dGV == 1)) && (a(parambi, this.zzP)) && (auk(parambi.field_talker))) {
            paramContextMenu.add(k, 123, 0, paramView.getContext().getString(2131298244));
          }
          localag = (ag)this.zzP.ay(ag.class);
          if (!ao.c(parambi, this.zzP)) {
            break label470;
          }
          if (bo.isNullOrNil(localag.D(parambi.field_msgId, parambi.field_imgPath))) {
            break label462;
          }
          i = 2131298250;
          label307:
          if ((!t.nU(parambi.field_talker)) || (!aa.dsC())) {
            break label603;
          }
          paramContextMenu.add(k, 121, 0, i);
        }
      }
    }
    label462:
    label470:
    label603:
    for (int j = 1;; j = 0)
    {
      if (((((p)localObject).time != 0L) || (parambi.field_isSend != 0)) && ((parambi.field_status != 1) || (parambi.field_isSend != 1)) && (!this.zzP.dJH())) {
        paramContextMenu.add(k, 100, 0, paramView.getContext().getString(2131298234));
      }
      if ((j == 0) && (aa.dsC()) && (i != -1)) {
        paramContextMenu.add(k, 121, 0, i);
      }
      AppMethodBeat.o(33369);
      return true;
      paramContextMenu.add(k, 119, 0, 2131298106);
      break;
      i = 2131298252;
      break label307;
      if (localag.oG(parambi.field_msgId))
      {
        i = 2131298248;
        break label307;
      }
      i = 2131298252;
      break label307;
      if (((ChattingItemTranslate.a)localObject).kwo == 2)
      {
        paramContextMenu.add(k, 141, 0, paramView.getContext().getString(2131298229));
        paramContextMenu.add(k, 142, 0, paramView.getContext().getString(2131302650));
        if (d.ahR("favorite")) {
          paramContextMenu.add(k, 143, 0, paramView.getContext().getString(2131302102));
        }
        AppMethodBeat.o(33369);
        return false;
      }
      AppMethodBeat.o(33369);
      return true;
    }
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33370);
    Object localObject = (ag)parama.ay(ag.class);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33370);
      return false;
      ((aj)parama.ay(aj.class)).qY(true);
      AppMethodBeat.o(33370);
      return true;
      ((aj)parama.ay(aj.class)).qY(false);
      AppMethodBeat.o(33370);
      return true;
      ao.e(parama, parambi);
      if (((ag)localObject).dJr()) {
        com.tencent.mm.ui.base.h.a(parama.zJz.getContext(), parama.zJz.getContext().getString(2131304601), "", new ao.b.2(this, (ag)localObject, parambi, paramMenuItem));
      }
      for (;;)
      {
        b.fRu.G(parambi);
        AppMethodBeat.o(33370);
        return true;
        ((ag)localObject).a(parambi, true, paramMenuItem.getGroupId(), 0);
      }
      paramMenuItem = (ClipboardManager)ah.getContext().getSystemService("clipboard");
      parama = ((ag)localObject).D(parambi.field_msgId, parambi.field_imgPath);
      if (!bo.isNullOrNil(parama)) {
        paramMenuItem.setText(parama);
      }
      ao.e(8, parambi);
      AppMethodBeat.o(33370);
      return true;
      paramMenuItem = new Intent(parama.zJz.getContext(), MsgRetransmitUI.class);
      localObject = ((ag)localObject).D(parambi.field_msgId, parambi.field_imgPath);
      if (parambi.dxM())
      {
        paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
        paramMenuItem.putExtra("Retr_Msg_Type", 6);
      }
      for (;;)
      {
        parama.startActivity(paramMenuItem);
        ao.e(9, parambi);
        AppMethodBeat.o(33370);
        return true;
        paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
        paramMenuItem.putExtra("Retr_Msg_Type", 4);
      }
      localObject = ((ag)localObject).D(parambi.field_msgId, parambi.field_imgPath);
      paramMenuItem = new cm();
      e.b(paramMenuItem, (String)localObject, 1);
      paramMenuItem.cpR.fragment = parama.zJz;
      paramMenuItem.cpR.cpY = 43;
      if (paramMenuItem.cpR.cpT != null)
      {
        parama = paramMenuItem.cpR.cpT.wVa;
        if (parama != null)
        {
          parama.aon(r.Zn());
          parama.aoo(parambi.field_talker);
          com.tencent.mm.sdk.b.a.ymk.l(paramMenuItem);
        }
      }
      for (;;)
      {
        ao.e(10, parambi);
        AppMethodBeat.o(33370);
        return true;
        ab.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
      }
      ((aj)parama.ay(aj.class)).bp(parambi);
    }
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 34);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33371);
    paramView = (az)paramView.getTag();
    b.fRu.F(paramView.cEE);
    ao.a(parama, paramView);
    ((ag)parama.ay(ag.class)).PK(2);
    AppMethodBeat.o(33371);
    return true;
  }
  
  public final boolean dLp()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ao.b
 * JD-Core Version:    0.7.0.1
 */