package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.af;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.gb;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.c.b.al;
import com.tencent.mm.ui.chatting.c.b.am;
import com.tencent.mm.ui.chatting.c.b.f;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class ay
{
  public static void b(com.tencent.mm.ui.chatting.d.a parama, bj parambj)
  {
    AppMethodBeat.i(37488);
    if ((com.tencent.mm.r.a.ci(parama.HZF.getContext())) || (com.tencent.mm.r.a.cf(parama.HZF.getContext())) || (com.tencent.mm.r.a.ck(parama.HZF.getContext())))
    {
      ac.d("MicroMsg.ChattingItemVoice", "voip is running, not play voice");
      AppMethodBeat.o(37488);
      return;
    }
    az.ayM();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.g(parama.HZF.getContext(), parama.HZF.getContentView());
      AppMethodBeat.o(37488);
      return;
    }
    Object localObject;
    bo localbo;
    int i;
    if ((parambj != null) && (parambj.dpq != null))
    {
      localObject = new p(parambj.dpq.field_content);
      if ((com.tencent.mm.platformtools.ae.isNullOrNil(parambj.dpq.field_content)) || (((p)localObject).time == 0L))
      {
        Toast.makeText(parama.HZF.getContext(), 2131757151, 0).show();
        AppMethodBeat.o(37488);
        return;
      }
      localObject = ((com.tencent.mm.ui.chatting.c.b.ao)parama.bf(com.tencent.mm.ui.chatting.c.b.ao.class)).foG();
      if ((parama.bf(com.tencent.mm.ui.chatting.c.b.i.class) != null) && (localObject != null))
      {
        localbo = parambj.dpq;
        if (((com.tencent.mm.ui.chatting.c.b.ao)parama.bf(com.tencent.mm.ui.chatting.c.b.ao.class)).foG().HKw != localbo.field_msgId)
        {
          parama = (al)parama.bf(al.class);
          if (!parama.Bn(localbo.field_msgId)) {
            break label322;
          }
          i = 7;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        parama = new gb();
        parama.dgs.dgt = 1;
        parama.dgs.scene = i;
        parama.dgs.fileName = localbo.field_imgPath;
        com.tencent.mm.sdk.b.a.GpY.l(parama);
      }
      i = parambj.position;
      parama = parambj.dpq;
      if ((parama == null) || (!parama.eZl()))
      {
        AppMethodBeat.o(37488);
        return;
        label322:
        if (parama.Bk(localbo.field_msgId)) {
          i = 6;
        }
      }
      else
      {
        parambj = new p(parama.field_content);
        if (((parambj.time == 0L) && (parama.field_isSend == 0)) || ((parama.field_status == 1) && (parama.field_isSend == 1)))
        {
          AppMethodBeat.o(37488);
          return;
        }
        if ((parama.field_isSend != 0) || (parambj.time != -1L))
        {
          ((com.tencent.mm.ui.chatting.d)localObject).fkq();
          az.ayM();
          parambj = (Boolean)com.tencent.mm.model.c.agA().get(4115, null);
          if ((parambj == null) || (!parambj.booleanValue()))
          {
            az.ayM();
            com.tencent.mm.model.c.agA().set(4115, Boolean.TRUE);
            ((com.tencent.mm.ui.chatting.d)localObject).fkv();
            ((com.tencent.mm.ui.chatting.d)localObject).HKz = t.a(((com.tencent.mm.ui.chatting.d)localObject).cLy.HZF.getActivity(), ((com.tencent.mm.ui.chatting.d)localObject).context.getString(2131757255), 4000L);
          }
          if ((((com.tencent.mm.ui.chatting.d)localObject).oUG.isPlaying()) && (parama.field_msgId == ((com.tencent.mm.ui.chatting.d)localObject).HKw))
          {
            ((com.tencent.mm.ui.chatting.d)localObject).HKF = true;
            ((com.tencent.mm.ui.chatting.d)localObject).ami();
            AppMethodBeat.o(37488);
            return;
          }
          ((com.tencent.mm.ui.chatting.d)localObject).aN(parama);
          if ((parama.field_isSend == 0) && (!s.W(parama))) {
            ((com.tencent.mm.ui.chatting.d)localObject).aay(i + 1);
          }
          ((com.tencent.mm.ui.chatting.d)localObject).xd(true);
        }
        AppMethodBeat.o(37488);
        return;
      }
      i = 0;
    }
  }
  
  public static final class a
    extends c
  {
    private com.tencent.mm.ui.chatting.d.a HNS;
    private View.OnClickListener IpU;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(37469);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ag(paramLayoutInflater, 2131493461);
        ((View)localObject).setTag(new ay.c().d((View)localObject, true, this.HJB));
      }
      AppMethodBeat.o(37469);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, final bo parambo, String paramString)
    {
      AppMethodBeat.i(37471);
      this.HNS = parama1;
      ay.c localc = (ay.c)parama;
      localc.Iqc.setFromVoice(true);
      localc.Iqc.setFromGroup(parama1.foQ());
      com.tencent.mm.ui.chatting.c.b.i locali = (com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class);
      a(locali, parambo.field_msgId);
      ay.c.a(localc, parambo, paramInt, parama1, true, c(parama1));
      parama = null;
      paramString = ChattingItemTranslate.b.IpD;
      Object localObject = (al)parama1.bf(al.class);
      if (ay.d(parambo, parama1))
      {
        localObject = ((al)localObject).I(parambo.field_msgId, parambo.field_imgPath);
        parama = (c.a)localObject;
        if (bs.isNullOrNil((String)localObject)) {
          break label847;
        }
        paramString = ChattingItemTranslate.b.IpG;
        parama = (c.a)localObject;
      }
      label333:
      label847:
      for (;;)
      {
        int i;
        if ((!bs.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.b.IpD))
        {
          if (localc.IlD == null)
          {
            localc.IlD = ((ChattingItemTranslate)localc.IlC.inflate());
            localc.IlD.setMinimumWidth(localc.IpZ - com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 5));
            localc.IlD.init();
          }
          Context localContext = localc.Ioj.getContext();
          i = (int)localc.IlD.getContentView().getTextSize();
          if (parambo != null)
          {
            localObject = y.xJ(parambo.field_msgSvrId);
            y.b localb = y.ayq().F((String)localObject, true);
            localb.l("prePublishId", "msg_" + parambo.field_msgSvrId);
            localb.l("preUsername", b(this.HNS, parambo));
            localb.l("preChatName", c(this.HNS, parambo));
            localObject = k.a(localContext, parama, i, 1, null, (String)localObject);
            localc.IlD.a((CharSequence)localObject, paramString);
            paramString = new ChattingItemTranslate.a(parambo, parama1.foQ(), paramInt);
            paramString.oeH = 2;
            localc.IlD.setTag(paramString);
            paramString = localc.IlD;
            if (this.IpU == null) {
              this.IpU = new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(37468);
                  paramAnonymousView = (ChattingItemTranslate.a)((ChattingItemTranslate)paramAnonymousView).getTag();
                  if (((al)ay.a.a(ay.a.this).bf(al.class)).Bj(paramAnonymousView.dpq.field_msgId) == ChattingItemTranslate.b.IpF) {
                    ((al)ay.a.a(ay.a.this).bf(al.class)).a(paramAnonymousView.dpq, true, paramAnonymousView.position, 1);
                  }
                  AppMethodBeat.o(37468);
                }
              };
            }
            paramString.setOnClickListener(this.IpU);
            localc.IlD.setOnLongClickListener(c(parama1));
            localc.IlD.setVisibility(0);
            if (!bs.isNullOrNil(parama))
            {
              localc.IlD.setOnTouchListener(locali.fmb());
              localc.IlD.setOnDoubleClickListener(new NeatTextView.b()
              {
                public final boolean gg(View paramAnonymousView)
                {
                  AppMethodBeat.i(37466);
                  ay.c.g(com.tencent.mm.sdk.platformtools.ai.getContext(), parama);
                  ay.cs(parambo);
                  AppMethodBeat.o(37466);
                  return true;
                }
              });
            }
            label489:
            parama = new p(parambo.field_content);
            if (parama.time != 0L) {
              break label631;
            }
            localc.IhW.setVisibility(8);
          }
        }
        for (;;)
        {
          parama = parambo.eSb;
          if ((parama != null) && (parama.length() != 0)) {
            break label818;
          }
          localc.IiR.setVisibility(8);
          AppMethodBeat.o(37471);
          return;
          if (!((al)localObject).Bk(parambo.field_msgId)) {
            break label847;
          }
          parama = ((al)localObject).I(parambo.field_msgId, parambo.field_imgPath);
          paramString = ((al)localObject).Bj(parambo.field_msgId);
          break;
          localObject = null;
          break label333;
          if (localc.IlD == null) {
            break label489;
          }
          localc.IlD.setVisibility(8);
          break label489;
          label631:
          paramString = ((com.tencent.mm.ui.chatting.c.b.ao)parama1.bf(com.tencent.mm.ui.chatting.c.b.ao.class)).foG();
          if (((paramString != null) && (paramString.HKw == parambo.field_msgId)) || (s.W(parambo)))
          {
            paramInt = 1;
            paramString = localc.IhW;
            if (paramInt == 0) {
              break label757;
            }
          }
          label757:
          for (i = 8;; i = 0)
          {
            paramString.setVisibility(i);
            i = (int)s.qw(parama.time);
            if (paramInt != 0) {
              break label763;
            }
            localc.Iqb.setContentDescription(String.format(parama1.HZF.getContext().getString(2131764732), new Object[] { Integer.valueOf(i) }));
            break;
            paramInt = 0;
            break label677;
          }
          label763:
          parama = ((f)parama1.bf(f.class)).aQj(parama1.getTalkerUserName());
          paramString = a.a.fhP();
          localObject = localc.Iqb;
          if (parama != null) {
            parama.toString();
          }
          paramString.ay((View)localObject, i);
        }
        localc.IiR.setVisibility(0);
        b(parama1, localc.IiR, bj.aQO(parama));
        AppMethodBeat.o(37471);
        return;
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
    {
      AppMethodBeat.i(37472);
      az.ayM();
      Object localObject;
      int k;
      int i;
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        localObject = (ChattingItemTranslate.a)paramView.getTag();
        k = ((ChattingItemTranslate.a)localObject).position;
        if (((ChattingItemTranslate.a)localObject).oeH == 1) {
          if (((new p(parambo.field_content).time != 0L) || (parambo.field_isSend != 0)) && ((parambo.field_status != 1) || (parambo.field_isSend != 1)))
          {
            az.ayM();
            Boolean localBoolean = (Boolean)com.tencent.mm.model.c.agA().get(26, null);
            localObject = localBoolean;
            if (localBoolean == null) {
              localObject = Boolean.FALSE;
            }
            if (!((Boolean)localObject).booleanValue()) {
              break label439;
            }
            paramContextMenu.add(k, 120, 0, 2131757073);
            az.ayM();
            localObject = com.tencent.mm.model.c.awB().aNt(parambo.field_talker);
            if ((w.wT(parambo.field_talker)) || (w.xr(parambo.field_talker)) || (localObject == null) || (((com.tencent.mm.storage.ai)localObject).fad())) {
              break label457;
            }
            i = 1;
            label192:
            if (com.tencent.mm.br.d.aCT("favorite")) {
              paramContextMenu.add(k, 116, 0, paramView.getContext().getString(2131761941));
            }
            if (i != 0)
            {
              if (af.aCW().ow(2) <= 0) {
                break label463;
              }
              i = 1;
              label241:
              if ((i != 0) && (!this.HNS.foR())) {
                paramContextMenu.add(k, 114, 0, paramView.getContext().getString(2131757217));
              }
            }
            localObject = (al)this.HNS.bf(al.class);
            if (!ay.d(parambo, this.HNS)) {
              break label469;
            }
            if (!bs.isNullOrNil(((al)localObject).I(parambo.field_msgId, parambo.field_imgPath))) {
              break label685;
            }
            i = 2131757243;
          }
        }
      }
      for (;;)
      {
        label329:
        if ((w.wH(parambo.field_talker)) && (ab.eUK()) && (i != -1)) {
          paramContextMenu.add(k, 121, 0, i);
        }
        for (int j = 1;; j = 0)
        {
          if (!this.HNS.foR()) {
            paramContextMenu.add(k, 100, 0, paramView.getContext().getString(2131757223));
          }
          if ((j == 0) && (ab.eUK()) && (i != -1)) {
            paramContextMenu.add(k, 121, 0, i);
          }
          AppMethodBeat.o(37472);
          return true;
          label439:
          paramContextMenu.add(k, 119, 0, 2131757072);
          break;
          label457:
          i = 0;
          break label192;
          label463:
          i = 0;
          break label241;
          label469:
          if (((al)localObject).Bk(parambo.field_msgId)) {
            break label685;
          }
          i = 2131757243;
          break label329;
          if (((ChattingItemTranslate.a)localObject).oeH == 2)
          {
            localObject = (al)this.HNS.bf(al.class);
            if (((al)localObject).Bj(parambo.field_msgId) == ChattingItemTranslate.b.IpF) {
              paramContextMenu.add(k, 121, 0, 2131757239);
            }
            for (;;)
            {
              AppMethodBeat.o(37472);
              return false;
              if (!bs.isNullOrNil(((al)localObject).I(parambo.field_msgId, parambo.field_imgPath)))
              {
                paramContextMenu.add(k, 141, 0, paramView.getContext().getString(2131757218));
                paramContextMenu.add(k, 142, 0, paramView.getContext().getString(2131762559));
                if (com.tencent.mm.br.d.aCT("favorite")) {
                  paramContextMenu.add(k, 143, 0, paramView.getContext().getString(2131761941));
                }
              }
              paramContextMenu.add(k, 121, 0, 2131757241);
            }
          }
          AppMethodBeat.o(37472);
          return true;
        }
        label685:
        i = -1;
      }
    }
    
    public final boolean a(final MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, final bo parambo)
    {
      AppMethodBeat.i(37473);
      Object localObject = (al)parama.bf(al.class);
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(37473);
        return false;
        ((com.tencent.mm.ui.chatting.c.b.ao)parama.bf(com.tencent.mm.ui.chatting.c.b.ao.class)).xn(true);
        AppMethodBeat.o(37473);
        return true;
        ((com.tencent.mm.ui.chatting.c.b.ao)parama.bf(com.tencent.mm.ui.chatting.c.b.ao.class)).xn(false);
        AppMethodBeat.o(37473);
        return true;
        ay.f(parama, parambo);
        if (((al)localObject).foB()) {
          h.d(parama.HZF.getContext(), parama.HZF.getContext().getString(2131764777), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(37467);
              s.Y(parambo);
              this.IpX.foC();
              this.IpX.a(parambo, true, paramMenuItem.getGroupId(), 0);
              AppMethodBeat.o(37467);
            }
          });
        }
        for (;;)
        {
          com.tencent.mm.modelstat.b.hUE.S(parambo);
          AppMethodBeat.o(37473);
          return true;
          s.Y(parambo);
          ((al)localObject).a(parambo, true, paramMenuItem.getGroupId(), 0);
        }
        paramMenuItem = (ClipboardManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("clipboard");
        parama = ((al)localObject).I(parambo.field_msgId, parambo.field_imgPath);
        if (!bs.isNullOrNil(parama)) {
          paramMenuItem.setText(parama);
        }
        ay.e(8, parambo);
        continue;
        paramMenuItem = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
        localObject = ((al)localObject).I(parambo.field_msgId, parambo.field_imgPath);
        if (parambo.fbw())
        {
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ay.e(9, parambo);
          break;
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 4);
        }
        localObject = ((al)localObject).I(parambo.field_msgId, parambo.field_imgPath);
        paramMenuItem = new cs();
        com.tencent.mm.pluginsdk.model.g.b(paramMenuItem, (String)localObject, 1);
        paramMenuItem.dck.fragment = parama.HZF;
        paramMenuItem.dck.dcq = 43;
        if (paramMenuItem.dck.dcm != null)
        {
          parama = paramMenuItem.dck.dcm.EBJ;
          if (parama != null)
          {
            parama.aJC(parambo.field_talker);
            parama.aJD(u.axw());
            com.tencent.mm.sdk.b.a.GpY.l(paramMenuItem);
          }
        }
        for (;;)
        {
          ay.e(10, parambo);
          break;
          ac.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
        }
        ((com.tencent.mm.ui.chatting.c.b.ao)parama.bf(com.tencent.mm.ui.chatting.c.b.ao.class)).bP(parambo);
        continue;
        ((com.tencent.mm.ui.chatting.c.b.ao)parama.bf(com.tencent.mm.ui.chatting.c.b.ao.class)).bQ(parambo);
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(37474);
      paramView = (bj)paramView.getTag();
      com.tencent.mm.modelstat.b.hUE.R(paramView.dpq);
      ay.b(parama, paramView);
      ((al)parama.bf(al.class)).abc(2);
      ((am)parama.bf(am.class)).foF();
      AppMethodBeat.o(37474);
      return true;
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(37470);
      boolean bool = parama.foQ();
      AppMethodBeat.o(37470);
      return bool;
    }
    
    public final boolean bb(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 34);
    }
    
    public final boolean fqu()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements s.n
  {
    private int Dpo = 3;
    private com.tencent.mm.ui.chatting.d.a HNS;
    
    public final View a(LayoutInflater paramLayoutInflater, View paramView)
    {
      AppMethodBeat.i(37477);
      Object localObject;
      if (paramView != null)
      {
        localObject = paramView;
        if (paramView.getTag() != null) {}
      }
      else
      {
        localObject = new ag(paramLayoutInflater, 2131493504);
        ((View)localObject).setTag(new ay.c().d((View)localObject, false, this.HJB));
      }
      AppMethodBeat.o(37477);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(37482);
      ((com.tencent.mm.ui.chatting.c.b.ao)parama.bf(com.tencent.mm.ui.chatting.c.b.ao.class)).bQ(parambo);
      AppMethodBeat.o(37482);
    }
    
    public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, final bo parambo, String paramString)
    {
      AppMethodBeat.i(37478);
      this.HNS = parama1;
      ay.c localc = (ay.c)parama;
      localc.Iqc.setFromVoice(false);
      localc.Iqc.setFromGroup(parama1.foQ());
      com.tencent.mm.ui.chatting.c.b.i locali = (com.tencent.mm.ui.chatting.c.b.i)parama1.bf(com.tencent.mm.ui.chatting.c.b.i.class);
      a(locali, parambo.field_msgId);
      ay.c.a(localc, parambo, paramInt, parama1, false, c(parama1));
      Object localObject = (al)parama1.bf(al.class);
      parama = null;
      paramString = ChattingItemTranslate.b.IpD;
      if (ay.d(parambo, parama1))
      {
        localObject = ((al)localObject).I(parambo.field_msgId, parambo.field_imgPath);
        parama = (c.a)localObject;
        if (bs.isNullOrNil((String)localObject)) {
          break label768;
        }
        paramString = ChattingItemTranslate.b.IpG;
        parama = (c.a)localObject;
      }
      label768:
      for (;;)
      {
        if ((!bs.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.b.IpD))
        {
          if (localc.IlD == null)
          {
            localc.IlD = ((ChattingItemTranslate)localc.IlC.inflate());
            localc.IlD.setMinimumWidth(localc.IpZ - com.tencent.mm.cc.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ai.getContext(), 5));
            localc.IlD.init();
          }
          Context localContext = localc.Ioj.getContext();
          int i = (int)localc.IlD.getContentView().getTextSize();
          if (parambo != null)
          {
            localObject = y.xJ(parambo.field_msgSvrId);
            y.b localb = y.ayq().F((String)localObject, true);
            localb.l("prePublishId", "msg_" + parambo.field_msgSvrId);
            localb.l("preUsername", b(this.HNS, parambo));
            localb.l("preChatName", c(this.HNS, parambo));
            label333:
            localObject = k.a(localContext, parama, i, 1, null, (String)localObject);
            localc.IlD.a((CharSequence)localObject, paramString);
            paramString = new ChattingItemTranslate.a(parambo, parama1.foQ(), paramInt);
            paramString.oeH = 2;
            localc.IlD.setTag(paramString);
            localc.IlD.setOnLongClickListener(c(parama1));
            localc.IlD.setVisibility(0);
            if (!bs.isNullOrNil(parama))
            {
              localc.IlD.setOnTouchListener(locali.fmb());
              localc.IlD.setOnDoubleClickListener(new NeatTextView.b()
              {
                public final boolean gg(View paramAnonymousView)
                {
                  AppMethodBeat.i(37475);
                  ay.c.g(com.tencent.mm.sdk.platformtools.ai.getContext(), parama);
                  ay.cs(parambo);
                  AppMethodBeat.o(37475);
                  return true;
                }
              });
            }
            label454:
            if (!fqw()) {
              break label729;
            }
            if (localc.Iqh != null) {
              localc.Iqh.setVisibility(8);
            }
            if (localc.Ijf != null) {
              localc.Ijf.setVisibility(8);
            }
            if ((parambo.field_status != 1) && (parambo.field_status != 5)) {
              break label633;
            }
            localc.Iqi.setBackgroundResource(2131231726);
            parambo.GYS = true;
          }
        }
        for (;;)
        {
          a(paramInt, localc, parambo, parama1.foM(), parama1.foQ(), parama1, this);
          AppMethodBeat.o(37478);
          return;
          if (!((al)localObject).Bk(parambo.field_msgId)) {
            break label768;
          }
          parama = ((al)localObject).I(parambo.field_msgId, parambo.field_imgPath);
          paramString = ((al)localObject).Bj(parambo.field_msgId);
          break;
          localObject = null;
          break label333;
          if (localc.IlD == null) {
            break label454;
          }
          localc.IlD.setVisibility(8);
          break label454;
          label633:
          localc.Iqi.setBackground(com.tencent.mm.ui.ao.aI(parama1.HZF.getContext(), 2130968741));
          if ((localc.Ijf != null) && (a(locali, parambo.field_msgId)))
          {
            if (parambo.GYS)
            {
              parama = new AlphaAnimation(0.5F, 1.0F);
              parama.setDuration(300L);
              localc.Iqi.startAnimation(parama);
              parambo.GYS = false;
            }
            localc.Ijf.setVisibility(0);
            continue;
            label729:
            if (localc.Iqh != null)
            {
              localc.Iqh.setVisibility(0);
              if (parambo.field_status >= 2) {
                localc.Iqh.setVisibility(8);
              }
            }
          }
        }
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
    {
      AppMethodBeat.i(37479);
      az.ayM();
      Object localObject;
      int k;
      al localal;
      int i;
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        localObject = (ChattingItemTranslate.a)paramView.getTag();
        k = ((ChattingItemTranslate.a)localObject).position;
        if (((ChattingItemTranslate.a)localObject).oeH == 1)
        {
          localObject = new p(parambo.field_content);
          if (((((p)localObject).time != 0L) || (parambo.field_isSend != 0)) && ((parambo.field_status != 1) || (parambo.field_isSend != 1)))
          {
            if (((com.tencent.mm.ui.chatting.c.b.ao)this.HNS.bf(com.tencent.mm.ui.chatting.c.b.ao.class)).foI()) {
              paramContextMenu.add(k, 120, 0, 2131757073);
            }
          }
          else
          {
            if (parambo.field_status == 5) {
              paramContextMenu.add(k, 103, 0, paramView.getContext().getString(2131757286));
            }
            if (com.tencent.mm.br.d.aCT("favorite")) {
              paramContextMenu.add(k, 116, 0, paramView.getContext().getString(2131761941));
            }
            if ((!parambo.eZj()) && (parambo.eZl()) && ((parambo.field_status == 2) || (parambo.eSf == 1)) && (b(parambo, this.HNS)) && (aQE(parambo.field_talker))) {
              paramContextMenu.add(k, 123, 0, paramView.getContext().getString(2131757234));
            }
            localal = (al)this.HNS.bf(al.class);
            if (!ay.d(parambo, this.HNS)) {
              break label469;
            }
            if (!bs.isNullOrNil(localal.I(parambo.field_msgId, parambo.field_imgPath))) {
              break label685;
            }
            i = 2131757243;
          }
        }
      }
      for (;;)
      {
        label307:
        if ((w.wH(parambo.field_talker)) && (ab.eUK()) && (i != -1)) {
          paramContextMenu.add(k, 121, 0, 2131757243);
        }
        for (int j = 1;; j = 0)
        {
          if (((((p)localObject).time != 0L) || (parambo.field_isSend != 0)) && ((parambo.field_status != 1) || (parambo.field_isSend != 1)) && (!this.HNS.foR())) {
            paramContextMenu.add(k, 100, 0, paramView.getContext().getString(2131757223));
          }
          if ((j == 0) && (ab.eUK()) && (i != -1)) {
            paramContextMenu.add(k, 121, 0, i);
          }
          AppMethodBeat.o(37479);
          return true;
          paramContextMenu.add(k, 119, 0, 2131757072);
          break;
          label469:
          if (localal.Bk(parambo.field_msgId)) {
            break label685;
          }
          i = 2131757243;
          break label307;
          if (((ChattingItemTranslate.a)localObject).oeH == 2)
          {
            localObject = (al)this.HNS.bf(al.class);
            if (((al)localObject).Bj(parambo.field_msgId) == ChattingItemTranslate.b.IpF) {
              paramContextMenu.add(k, 121, 0, 2131757239);
            }
            for (;;)
            {
              AppMethodBeat.o(37479);
              return false;
              if (!bs.isNullOrNil(((al)localObject).I(parambo.field_msgId, parambo.field_imgPath)))
              {
                paramContextMenu.add(k, 141, 0, paramView.getContext().getString(2131757218));
                paramContextMenu.add(k, 142, 0, paramView.getContext().getString(2131762559));
                if (com.tencent.mm.br.d.aCT("favorite")) {
                  paramContextMenu.add(k, 143, 0, paramView.getContext().getString(2131761941));
                }
              }
              paramContextMenu.add(k, 121, 0, 2131757241);
            }
          }
          AppMethodBeat.o(37479);
          return true;
        }
        label685:
        i = -1;
      }
    }
    
    public final boolean a(final MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, final bo parambo)
    {
      AppMethodBeat.i(37480);
      Object localObject = (al)parama.bf(al.class);
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(37480);
        return false;
        ((com.tencent.mm.ui.chatting.c.b.ao)parama.bf(com.tencent.mm.ui.chatting.c.b.ao.class)).xn(true);
        AppMethodBeat.o(37480);
        return true;
        ((com.tencent.mm.ui.chatting.c.b.ao)parama.bf(com.tencent.mm.ui.chatting.c.b.ao.class)).xn(false);
        AppMethodBeat.o(37480);
        return true;
        ay.f(parama, parambo);
        if (((al)localObject).foB()) {
          h.d(parama.HZF.getContext(), parama.HZF.getContext().getString(2131764777), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(37476);
              this.IpX.foC();
              this.IpX.a(parambo, true, paramMenuItem.getGroupId(), 0);
              AppMethodBeat.o(37476);
            }
          });
        }
        for (;;)
        {
          com.tencent.mm.modelstat.b.hUE.S(parambo);
          AppMethodBeat.o(37480);
          return true;
          ((al)localObject).a(parambo, true, paramMenuItem.getGroupId(), 0);
        }
        paramMenuItem = (ClipboardManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("clipboard");
        parama = ((al)localObject).I(parambo.field_msgId, parambo.field_imgPath);
        if (!bs.isNullOrNil(parama)) {
          paramMenuItem.setText(parama);
        }
        ay.e(8, parambo);
        AppMethodBeat.o(37480);
        return true;
        paramMenuItem = new Intent(parama.HZF.getContext(), MsgRetransmitUI.class);
        localObject = ((al)localObject).I(parambo.field_msgId, parambo.field_imgPath);
        if (parambo.fbw())
        {
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().ba(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ay.e(9, parambo);
          AppMethodBeat.o(37480);
          return true;
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 4);
        }
        localObject = ((al)localObject).I(parambo.field_msgId, parambo.field_imgPath);
        paramMenuItem = new cs();
        com.tencent.mm.pluginsdk.model.g.b(paramMenuItem, (String)localObject, 1);
        paramMenuItem.dck.fragment = parama.HZF;
        paramMenuItem.dck.dcq = 43;
        if (paramMenuItem.dck.dcm != null)
        {
          parama = paramMenuItem.dck.dcm.EBJ;
          if (parama != null)
          {
            parama.aJC(u.axw());
            parama.aJD(parambo.field_talker);
            com.tencent.mm.sdk.b.a.GpY.l(paramMenuItem);
          }
        }
        for (;;)
        {
          ay.e(10, parambo);
          AppMethodBeat.o(37480);
          return true;
          ac.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
        }
        ((com.tencent.mm.ui.chatting.c.b.ao)parama.bf(com.tencent.mm.ui.chatting.c.b.ao.class)).bQ(parambo);
      }
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
    {
      AppMethodBeat.i(37481);
      paramView = (bj)paramView.getTag();
      com.tencent.mm.modelstat.b.hUE.R(paramView.dpq);
      ay.b(parama, paramView);
      ((al)parama.bf(al.class)).abc(2);
      ((am)parama.bf(am.class)).foF();
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Wm(parambo.field_talker);
      AppMethodBeat.o(37481);
      return true;
    }
    
    public final boolean bb(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 34);
    }
    
    public final boolean fqu()
    {
      return true;
    }
  }
  
  public static final class c
    extends c.a
  {
    TextView IiR;
    ImageView Ijf;
    ViewStub IlC;
    ChattingItemTranslate IlD;
    TextView Ioj;
    int IpZ;
    TextView Iqa;
    TextView Iqb;
    AnimImageView Iqc;
    FrameLayout Iqd;
    FrameLayout Iqe;
    ImageView Iqf;
    AnimImageView Iqg;
    ProgressBar Iqh;
    TextView Iqi;
    Animation Iqj;
    
    private static int Il(int paramInt)
    {
      if (paramInt <= 2) {
        return 80;
      }
      if (paramInt < 10) {
        return (paramInt - 2) * 9 + 80;
      }
      if (paramInt < 60) {
        return (paramInt / 10 + 7) * 9 + 80;
      }
      return 204;
    }
    
    private static void a(c paramc, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(37487);
      paramc.IhW.setVisibility(paramInt2);
      paramc.Ioj.setVisibility(paramInt2);
      paramc.Iqd.setVisibility(paramInt2);
      if (paramBoolean)
      {
        paramc.Iqg.setVisibility(paramInt1);
        paramc.IiR.setVisibility(paramInt2);
        AppMethodBeat.o(37487);
        return;
      }
      if (paramc.Iqi != null) {
        paramc.Iqi.setVisibility(paramInt1);
      }
      AppMethodBeat.o(37487);
    }
    
    public static void a(c paramc, bo parambo, int paramInt, com.tencent.mm.ui.chatting.d.a parama, boolean paramBoolean, View.OnLongClickListener paramOnLongClickListener)
    {
      AppMethodBeat.i(37484);
      if (paramc == null)
      {
        AppMethodBeat.o(37484);
        return;
      }
      Object localObject = new p(parambo.field_content);
      float f1 = s.qw(((p)localObject).time);
      com.tencent.mm.ui.chatting.d locald = ((com.tencent.mm.ui.chatting.c.b.ao)parama.bf(com.tencent.mm.ui.chatting.c.b.ao.class)).foG();
      label220:
      float f2;
      if ((locald != null) && (parambo.field_msgId == locald.HKw))
      {
        paramc.Iqc.setVisibility(0);
        paramc.Iqc.fia();
        if (parambo.field_isSend != 0) {
          break label729;
        }
        if (((p)localObject).time != 0L) {
          break label525;
        }
        a(paramc, 8, 0, true);
        paramc.Iqg.caT();
        paramc.Iqg.setVisibility(8);
        paramc.IhW.setVisibility(8);
        f1 = 0.0F;
        paramc.IpZ = com.tencent.mm.cc.a.fromDPToPix(parama.HZF.getContext(), Il(0));
        paramc.Iqb.setWidth(paramc.IpZ);
        paramc.Ioj.setText(parama.HZF.getMMResources().getString(2131759570, new Object[] { Integer.valueOf(0) }));
        paramc.Iqc.setWidth(com.tencent.mm.cc.a.fromDPToPix(parama.HZF.getContext(), Il(0)));
        f2 = f1;
        if (1 != parambo.field_isSend) {
          break label1024;
        }
        if (parambo.field_status != 1) {
          break label732;
        }
        a(paramc, 0, 8, false);
        paramc.Iqe.setVisibility(8);
        paramc.fqJ();
        label261:
        localObject = ((com.tencent.mm.ui.chatting.c.b.c)parama.bf(com.tencent.mm.ui.chatting.c.b.c.class)).fmP();
        if (localObject != null)
        {
          if (!((com.tencent.mm.pluginsdk.ui.e)localObject).Dne) {
            break label1031;
          }
          paramc.Ioj.setShadowLayer(2.0F, 1.2F, 1.2F, ((com.tencent.mm.pluginsdk.ui.e)localObject).Dnf);
          label307:
          if (!((com.tencent.mm.pluginsdk.ui.e)localObject).Dng) {
            break label1045;
          }
          paramc.Ioj.setBackgroundResource(2131231724);
        }
        label324:
        localObject = new ChattingItemTranslate.a(parambo, parama.foQ(), paramInt);
        paramc.Iqb.setTag(localObject);
        paramc.Iqb.setOnClickListener(paramc.IhY.d(parama));
        paramc.Iqb.setOnLongClickListener(paramOnLongClickListener);
        paramc.Iqb.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.i)parama.bf(com.tencent.mm.ui.chatting.c.b.i.class)).fmb());
        if ((parambo.euk & 0x1) != 1) {
          break label1079;
        }
        paramc.Iqa.setVisibility(0);
        if (parambo.field_isSend != 0) {
          break label1056;
        }
        paramc.Iqc.setBackgroundResource(2131231624);
        label428:
        if (!paramBoolean) {
          break label1161;
        }
        parama.getTalkerUserName();
      }
      for (;;)
      {
        parambo = ((f)parama.bf(f.class)).aQj(parama.getTalkerUserName());
        parama = a.a.fhP();
        paramOnLongClickListener = paramc.Iqb;
        paramInt = (int)f1;
        if (parambo != null) {
          parambo.toString();
        }
        parama.ay(paramOnLongClickListener, paramInt);
        paramc.Ioj.setContentDescription(" ");
        AppMethodBeat.o(37484);
        return;
        paramc.Iqc.setVisibility(8);
        paramc.Iqc.caT();
        break;
        label525:
        if (((p)localObject).time == -1L)
        {
          a(paramc, 8, 0, true);
          paramc.Iqg.caT();
          paramc.Iqg.setVisibility(8);
          paramc.IpZ = 80;
          paramc.Iqb.setWidth(80);
          paramc.Ioj.setVisibility(8);
          paramc.Iqc.setWidth(com.tencent.mm.cc.a.fromDPToPix(parama.HZF.getContext(), Il((int)f1)));
          break label220;
        }
        a(paramc, 8, 0, true);
        paramc.Iqg.caT();
        paramc.Iqg.setVisibility(8);
        paramc.Ioj.setVisibility(0);
        paramc.IpZ = com.tencent.mm.cc.a.fromDPToPix(parama.HZF.getContext(), Il((int)f1));
        paramc.Iqb.setWidth(paramc.IpZ);
        paramc.Ioj.setText(parama.HZF.getMMResources().getString(2131759570, new Object[] { Integer.valueOf((int)f1) }));
        paramc.Iqc.setWidth(com.tencent.mm.cc.a.fromDPToPix(parama.HZF.getContext(), Il((int)f1)));
        label729:
        break label220;
        label732:
        if (((p)localObject).time == -1L)
        {
          a(paramc, 8, 0, false);
          paramc.Iqb.setWidth(80);
          paramc.IpZ = 80;
          paramc.Ioj.setVisibility(8);
          paramc.Iqe.setVisibility(8);
          paramc.Iqc.setWidth(com.tencent.mm.cc.a.fromDPToPix(parama.HZF.getContext(), Il((int)f1)));
          paramc.fqJ();
          break label261;
        }
        if (parambo.field_status == 7)
        {
          a(paramc, 8, 8, false);
          paramc.Ioj.setVisibility(8);
          paramc.Iqe.setVisibility(0);
          paramc.fqJ();
          if (paramc.Iqf != null)
          {
            paramc.Iqj = AnimationUtils.loadAnimation(paramc.sSS.getContext(), 2130772168);
            paramc.Iqf.startAnimation(paramc.Iqj);
          }
          break label261;
        }
        a(paramc, 8, 0, false);
        paramc.Iqe.setVisibility(8);
        paramc.Ioj.setVisibility(0);
        paramc.fqJ();
        if (((p)localObject).time == 0L) {
          f1 = 0.0F;
        }
        paramc.IpZ = com.tencent.mm.cc.a.fromDPToPix(parama.HZF.getContext(), Il((int)f1));
        paramc.Iqb.setWidth(paramc.IpZ);
        paramc.Ioj.setText(parama.HZF.getMMResources().getString(2131759570, new Object[] { Integer.valueOf((int)f1) }));
        paramc.Iqc.setWidth(com.tencent.mm.cc.a.fromDPToPix(parama.HZF.getContext(), Il((int)f1)));
        f2 = f1;
        label1024:
        f1 = f2;
        break label261;
        label1031:
        paramc.Ioj.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        break label307;
        label1045:
        paramc.Ioj.setBackgroundColor(0);
        break label324;
        label1056:
        paramc.Iqi.setBackgroundResource(2131231734);
        paramc.Iqc.setBackgroundResource(2131231734);
        break label428;
        label1079:
        paramc.Iqa.setVisibility(8);
        if (parambo.field_isSend == 0)
        {
          paramc.Iqc.setBackground(com.tencent.mm.ui.ao.aI(parama.HZF.getContext(), 2130968736));
          break label428;
        }
        paramc.Iqi.setBackground(com.tencent.mm.ui.ao.aI(parama.HZF.getContext(), 2130968741));
        paramc.Iqc.setBackground(com.tencent.mm.ui.ao.aI(parama.HZF.getContext(), 2130968741));
        break label428;
        label1161:
        parama.foM();
      }
    }
    
    private void fqJ()
    {
      AppMethodBeat.i(37486);
      if (this.Iqj != null)
      {
        this.Iqj.cancel();
        this.Iqj = null;
      }
      AppMethodBeat.o(37486);
    }
    
    static void g(Context paramContext, CharSequence paramCharSequence)
    {
      AppMethodBeat.i(37485);
      Intent localIntent = new Intent(paramContext, TextPreviewUI.class);
      localIntent.putExtra("key_chat_text", paramCharSequence);
      paramCharSequence = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramCharSequence.aeD(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$VoiceItemHolder", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramCharSequence.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$VoiceItemHolder", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.jS(paramContext);
      AppMethodBeat.o(37485);
    }
    
    public final c.a d(View paramView, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(37483);
      super.fX(paramView);
      this.fAz = ((TextView)paramView.findViewById(2131298178));
      this.xpH = ((TextView)paramView.findViewById(2131298185));
      this.Iqb = ((TextView)paramView.findViewById(2131298197));
      this.ijt = ((CheckBox)paramView.findViewById(2131298068));
      this.gGk = paramView.findViewById(2131298147);
      this.IhW = ((ImageView)paramView.findViewById(2131298174));
      this.Ioj = ((TextView)paramView.findViewById(2131298073));
      this.Iqd = ((FrameLayout)paramView.findViewById(2131298198));
      this.IlC = ((ViewStub)paramView.findViewById(2131306075));
      this.Iqa = ((TextView)paramView.findViewById(2131298195));
      this.Iqc = ((AnimImageView)paramView.findViewById(2131298194));
      this.Iqc.setType(1);
      if (paramBoolean1)
      {
        this.Iqc.setFromVoice(true);
        this.Iqc.setFromGroup(paramBoolean2);
        this.IiR = ((TextView)paramView.findViewById(2131298023));
        this.Iqg = ((AnimImageView)paramView.findViewById(2131298196));
        this.Iqg.setFromVoice(true);
        this.Iqg.setFromGroup(paramBoolean2);
        this.Iqg.setType(0);
      }
      for (;;)
      {
        AppMethodBeat.o(37483);
        return this;
        this.Iqe = ((FrameLayout)paramView.findViewById(2131298205));
        this.Iqf = ((ImageView)paramView.findViewById(2131298206));
        this.Iqh = ((ProgressBar)paramView.findViewById(2131298207));
        this.vYf = ((ProgressBar)paramView.findViewById(2131306220));
        this.Iqi = ((TextView)paramView.findViewById(2131298208));
        this.Iqc.setFromVoice(false);
        this.Iqc.setFromGroup(paramBoolean2);
        this.Ijf = ((ImageView)paramView.findViewById(2131298176));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ay
 * JD-Core Version:    0.7.0.1
 */