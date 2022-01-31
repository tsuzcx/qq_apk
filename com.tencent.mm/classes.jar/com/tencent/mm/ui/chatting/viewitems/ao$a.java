package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.ag;
import com.tencent.mm.ui.chatting.c.b.aj;
import com.tencent.mm.ui.chatting.c.b.f;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;

public final class ao$a
  extends c
{
  private View.OnClickListener zXI;
  private com.tencent.mm.ui.chatting.d.a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33359);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969088);
      ((View)localObject).setTag(new ao.c().c((View)localObject, true, this.zvB));
    }
    AppMethodBeat.o(33359);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33361);
    this.zzP = parama1;
    ao.c localc = (ao.c)parama;
    localc.zXQ.setFromVoice(true);
    localc.zXQ.setFromGroup(parama1.dJG());
    com.tencent.mm.ui.chatting.c.b.h localh = (com.tencent.mm.ui.chatting.c.b.h)parama1.ay(com.tencent.mm.ui.chatting.c.b.h.class);
    a(localh, parambi.field_msgId);
    ao.c.a(localc, parambi, paramInt, parama1, true, c(parama1));
    parama = null;
    paramString = ChattingItemTranslate.b.zXu;
    Object localObject = (ag)parama1.ay(ag.class);
    if (ao.c(parambi, parama1))
    {
      localObject = ((ag)localObject).D(parambi.field_msgId, parambi.field_imgPath);
      parama = (c.a)localObject;
      if (!bo.isNullOrNil((String)localObject))
      {
        paramString = ChattingItemTranslate.b.zXx;
        parama = (c.a)localObject;
      }
      if ((bo.isNullOrNil(parama)) && (paramString == ChattingItemTranslate.b.zXu)) {
        break label463;
      }
      if (localc.zXi == null)
      {
        localc.zXi = ((ChattingItemTranslate)localc.zXh.inflate());
        localc.zXi.setMinimumWidth(localc.zXN - com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 5));
        localc.zXi.init();
      }
      localc.zXi.a(parama, paramString);
      paramString = new ChattingItemTranslate.a(parambi, parama1.dJG(), paramInt);
      paramString.kwo = 2;
      localc.zXi.setTag(paramString);
      paramString = localc.zXi;
      if (this.zXI == null) {
        this.zXI = new ao.a.3(this);
      }
      paramString.setOnClickListener(this.zXI);
      if (!bo.isNullOrNil(parama))
      {
        localc.zXi.setOnTouchListener(localh.dHi());
        localc.zXi.setOnDoubleClickListener(new ao.a.1(this, parama, parambi));
        localc.zXi.setOnLongClickListener(c(parama1));
        localc.zXi.setVisibility(0);
      }
      label348:
      parama = new p(parambi.field_content);
      if (parama.time != 0L) {
        break label484;
      }
      localc.zRC.setVisibility(8);
    }
    for (;;)
    {
      parama = parambi.dGR;
      if ((parama != null) && (parama.length() != 0)) {
        break label671;
      }
      localc.zRY.setVisibility(8);
      AppMethodBeat.o(33361);
      return;
      if (!((ag)localObject).oG(parambi.field_msgId)) {
        break;
      }
      parama = ((ag)localObject).D(parambi.field_msgId, parambi.field_imgPath);
      paramString = ((ag)localObject).oF(parambi.field_msgId);
      break;
      label463:
      if (localc.zXi == null) {
        break label348;
      }
      localc.zXi.setVisibility(8);
      break label348;
      label484:
      paramString = ((aj)parama1.ay(aj.class)).dJv();
      if (((paramString != null) && (paramString.zwt == parambi.field_msgId)) || (s.K(parambi)))
      {
        paramInt = 1;
        label530:
        paramString = localc.zRC;
        if (paramInt == 0) {
          break label610;
        }
      }
      label610:
      for (int i = 8;; i = 0)
      {
        paramString.setVisibility(i);
        i = (int)s.hi(parama.time);
        if (paramInt != 0) {
          break label616;
        }
        localc.zXP.setContentDescription(String.format(parama1.zJz.getContext().getString(2131304559), new Object[] { Integer.valueOf(i) }));
        break;
        paramInt = 0;
        break label530;
      }
      label616:
      parama = ((f)parama1.ay(f.class)).atS(parama1.getTalkerUserName());
      paramString = a.a.dDt();
      localObject = localc.zXP;
      if (parama != null) {
        parama.toString();
      }
      paramString.al((View)localObject, i);
    }
    label671:
    localc.zRY.setVisibility(0);
    b(parama1, localc.zRY, az.auv(parama));
    AppMethodBeat.o(33361);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33362);
    aw.aaz();
    if (com.tencent.mm.model.c.isSDCardAvailable())
    {
      Object localObject = (ChattingItemTranslate.a)paramView.getTag();
      int m = ((ChattingItemTranslate.a)localObject).position;
      if (((ChattingItemTranslate.a)localObject).kwo == 1)
      {
        int i;
        label192:
        label241:
        int k;
        if (((new p(parambi.field_content).time != 0L) || (parambi.field_isSend != 0)) && ((parambi.field_status != 1) || (parambi.field_isSend != 1)))
        {
          aw.aaz();
          Boolean localBoolean = (Boolean)com.tencent.mm.model.c.Ru().get(26, null);
          localObject = localBoolean;
          if (localBoolean == null) {
            localObject = Boolean.FALSE;
          }
          if (!((Boolean)localObject).booleanValue()) {
            break label454;
          }
          paramContextMenu.add(m, 120, 0, 2131298107);
          aw.aaz();
          localObject = com.tencent.mm.model.c.YA().arw(parambi.field_talker);
          if ((t.og(parambi.field_talker)) || (t.oD(parambi.field_talker)) || (localObject == null) || (((ad)localObject).dwz())) {
            break label472;
          }
          i = 1;
          if (com.tencent.mm.bq.d.ahR("favorite")) {
            paramContextMenu.add(m, 116, 0, paramView.getContext().getString(2131302102));
          }
          if (i != 0)
          {
            if (com.tencent.mm.aj.z.afi().lb(2) <= 0) {
              break label478;
            }
            i = 1;
            if ((i != 0) && (!this.zzP.dJH())) {
              paramContextMenu.add(m, 114, 0, paramView.getContext().getString(2131298228));
            }
          }
          localObject = (ag)this.zzP.ay(ag.class);
          k = 0;
          if (!ao.c(parambi, this.zzP)) {
            break label492;
          }
          if (bo.isNullOrNil(((ag)localObject).D(parambi.field_msgId, parambi.field_imgPath))) {
            break label484;
          }
          i = 2131298250;
        }
        for (;;)
        {
          int j = k;
          if (t.nU(parambi.field_talker))
          {
            j = k;
            if (aa.dsC())
            {
              j = k;
              if (i != -1)
              {
                paramContextMenu.add(m, 121, 0, i);
                j = 1;
              }
            }
          }
          if (!this.zzP.dJH()) {
            paramContextMenu.add(m, 100, 0, paramView.getContext().getString(2131298234));
          }
          if ((j == 0) && (aa.dsC()) && (i != -1)) {
            paramContextMenu.add(m, 121, 0, i);
          }
          AppMethodBeat.o(33362);
          return true;
          label454:
          paramContextMenu.add(m, 119, 0, 2131298106);
          break;
          label472:
          i = 0;
          break label192;
          label478:
          i = 0;
          break label241;
          label484:
          i = 2131298252;
          continue;
          label492:
          if (((ag)localObject).oG(parambi.field_msgId)) {
            i = 2131298248;
          } else {
            i = 2131298252;
          }
        }
      }
      if (((ChattingItemTranslate.a)localObject).kwo == 2)
      {
        paramContextMenu.add(m, 141, 0, paramView.getContext().getString(2131298229));
        paramContextMenu.add(m, 142, 0, paramView.getContext().getString(2131302650));
        if (com.tencent.mm.bq.d.ahR("favorite")) {
          paramContextMenu.add(m, 143, 0, paramView.getContext().getString(2131302102));
        }
        AppMethodBeat.o(33362);
        return false;
      }
    }
    AppMethodBeat.o(33362);
    return true;
  }
  
  public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33363);
    Object localObject = (ag)parama.ay(ag.class);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(33363);
      return false;
      ((aj)parama.ay(aj.class)).qY(true);
      AppMethodBeat.o(33363);
      return true;
      ((aj)parama.ay(aj.class)).qY(false);
      AppMethodBeat.o(33363);
      return true;
      ao.e(parama, parambi);
      if (((ag)localObject).dJr()) {
        com.tencent.mm.ui.base.h.a(parama.zJz.getContext(), parama.zJz.getContext().getString(2131304601), "", new ao.a.2(this, parambi, (ag)localObject, paramMenuItem));
      }
      for (;;)
      {
        b.fRu.G(parambi);
        AppMethodBeat.o(33363);
        return true;
        s.M(parambi);
        ((ag)localObject).a(parambi, true, paramMenuItem.getGroupId(), 0);
      }
      paramMenuItem = (ClipboardManager)ah.getContext().getSystemService("clipboard");
      parama = ((ag)localObject).D(parambi.field_msgId, parambi.field_imgPath);
      if (!bo.isNullOrNil(parama)) {
        paramMenuItem.setText(parama);
      }
      ao.e(8, parambi);
      continue;
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
        break;
        paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
        paramMenuItem.putExtra("Retr_Msg_Type", 4);
      }
      localObject = ((ag)localObject).D(parambi.field_msgId, parambi.field_imgPath);
      paramMenuItem = new cm();
      com.tencent.mm.pluginsdk.model.e.b(paramMenuItem, (String)localObject, 1);
      paramMenuItem.cpR.fragment = parama.zJz;
      paramMenuItem.cpR.cpY = 43;
      if (paramMenuItem.cpR.cpT != null)
      {
        parama = paramMenuItem.cpR.cpT.wVa;
        if (parama != null)
        {
          parama.aon(parambi.field_talker);
          parama.aoo(r.Zn());
          com.tencent.mm.sdk.b.a.ymk.l(paramMenuItem);
        }
      }
      for (;;)
      {
        ao.e(10, parambi);
        break;
        ab.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
      }
      ((aj)parama.ay(aj.class)).bo(parambi);
      continue;
      ((aj)parama.ay(aj.class)).bp(parambi);
    }
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 34);
  }
  
  public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33364);
    paramView = (az)paramView.getTag();
    b.fRu.F(paramView.cEE);
    ao.a(parama, paramView);
    ((ag)parama.ay(ag.class)).PK(2);
    AppMethodBeat.o(33364);
    return true;
  }
  
  protected final boolean b(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(33360);
    boolean bool = parama.dJG();
    AppMethodBeat.o(33360);
    return bool;
  }
  
  public final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ao.a
 * JD-Core Version:    0.7.0.1
 */