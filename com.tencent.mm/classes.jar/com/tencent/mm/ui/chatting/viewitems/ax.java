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
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.ga;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.c.b.al;
import com.tencent.mm.ui.chatting.c.b.f;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class ax
{
  public static void b(com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(37488);
    if ((com.tencent.mm.r.a.ce(parama.GzJ.getContext())) || (com.tencent.mm.r.a.cc(parama.GzJ.getContext())))
    {
      ad.d("MicroMsg.ChattingItemVoice", "voip is running, not play voice");
      AppMethodBeat.o(37488);
      return;
    }
    az.arV();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.g(parama.GzJ.getContext(), parama.GzJ.getContentView());
      AppMethodBeat.o(37488);
      return;
    }
    Object localObject;
    bl localbl;
    int i;
    if ((parambi != null) && (parambi.drF != null))
    {
      localObject = new p(parambi.drF.field_content);
      if ((ae.isNullOrNil(parambi.drF.field_content)) || (((p)localObject).time == 0L))
      {
        Toast.makeText(parama.GzJ.getContext(), 2131757151, 0).show();
        AppMethodBeat.o(37488);
        return;
      }
      localObject = ((com.tencent.mm.ui.chatting.c.b.ao)parama.be(com.tencent.mm.ui.chatting.c.b.ao.class)).eYQ();
      if ((parama.be(com.tencent.mm.ui.chatting.c.b.i.class) != null) && (localObject != null))
      {
        localbl = parambi.drF;
        if (((com.tencent.mm.ui.chatting.c.b.ao)parama.be(com.tencent.mm.ui.chatting.c.b.ao.class)).eYQ().GkH != localbl.field_msgId)
        {
          parama = (al)parama.be(al.class);
          if (!parama.wK(localbl.field_msgId)) {
            break label309;
          }
          i = 7;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        parama = new ga();
        parama.diX.diY = 1;
        parama.diX.scene = i;
        parama.diX.fileName = localbl.field_imgPath;
        com.tencent.mm.sdk.b.a.ESL.l(parama);
      }
      i = parambi.position;
      parama = parambi.drF;
      if ((parama == null) || (!parama.eJN()))
      {
        AppMethodBeat.o(37488);
        return;
        label309:
        if (parama.wH(localbl.field_msgId)) {
          i = 6;
        }
      }
      else
      {
        parambi = new p(parama.field_content);
        if (((parambi.time == 0L) && (parama.field_isSend == 0)) || ((parama.field_status == 1) && (parama.field_isSend == 1)))
        {
          AppMethodBeat.o(37488);
          return;
        }
        if ((parama.field_isSend != 0) || (parambi.time != -1L))
        {
          ((com.tencent.mm.ui.chatting.d)localObject).eUD();
          az.arV();
          parambi = (Boolean)com.tencent.mm.model.c.afk().get(4115, null);
          if ((parambi == null) || (!parambi.booleanValue()))
          {
            az.arV();
            com.tencent.mm.model.c.afk().set(4115, Boolean.TRUE);
            ((com.tencent.mm.ui.chatting.d)localObject).eUJ();
            ((com.tencent.mm.ui.chatting.d)localObject).GkK = t.a(((com.tencent.mm.ui.chatting.d)localObject).cOd.GzJ.getActivity(), ((com.tencent.mm.ui.chatting.d)localObject).context.getString(2131757255), 4000L);
          }
          if ((((com.tencent.mm.ui.chatting.d)localObject).org.isPlaying()) && (parama.field_msgId == ((com.tencent.mm.ui.chatting.d)localObject).GkH))
          {
            ((com.tencent.mm.ui.chatting.d)localObject).GkQ = true;
            ((com.tencent.mm.ui.chatting.d)localObject).eUI();
            AppMethodBeat.o(37488);
            return;
          }
          ((com.tencent.mm.ui.chatting.d)localObject).aL(parama);
          if ((parama.field_isSend == 0) && (!s.W(parama))) {
            ((com.tencent.mm.ui.chatting.d)localObject).Yn(i + 1);
          }
          ((com.tencent.mm.ui.chatting.d)localObject).vZ(true);
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
    private View.OnClickListener GPT;
    private com.tencent.mm.ui.chatting.d.a Gob;
    
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
        localObject = new af(paramLayoutInflater, 2131493461);
        ((View)localObject).setTag(new ax.c().d((View)localObject, true, this.GjM));
      }
      AppMethodBeat.o(37469);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, final bl parambl, String paramString)
    {
      AppMethodBeat.i(37471);
      this.Gob = parama1;
      ax.c localc = (ax.c)parama;
      localc.GQb.setFromVoice(true);
      localc.GQb.setFromGroup(parama1.eZb());
      com.tencent.mm.ui.chatting.c.b.i locali = (com.tencent.mm.ui.chatting.c.b.i)parama1.be(com.tencent.mm.ui.chatting.c.b.i.class);
      a(locali, parambl.field_msgId);
      ax.c.a(localc, parambl, paramInt, parama1, true, c(parama1));
      parama = null;
      paramString = ChattingItemTranslate.b.GPB;
      Object localObject = (al)parama1.be(al.class);
      if (ax.d(parambl, parama1))
      {
        localObject = ((al)localObject).K(parambl.field_msgId, parambl.field_imgPath);
        parama = (c.a)localObject;
        if (bt.isNullOrNil((String)localObject)) {
          break label847;
        }
        paramString = ChattingItemTranslate.b.GPE;
        parama = (c.a)localObject;
      }
      label333:
      label847:
      for (;;)
      {
        int i;
        if ((!bt.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.b.GPB))
        {
          if (localc.GLG == null)
          {
            localc.GLG = ((ChattingItemTranslate)localc.GLF.inflate());
            localc.GLG.setMinimumWidth(localc.GPY - com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 5));
            localc.GLG.init();
          }
          Context localContext = localc.GOh.getContext();
          i = (int)localc.GLG.getContentView().getTextSize();
          if (parambl != null)
          {
            localObject = y.tD(parambl.field_msgSvrId);
            y.b localb = y.arz().E((String)localObject, true);
            localb.m("prePublishId", "msg_" + parambl.field_msgSvrId);
            localb.m("preUsername", b(this.Gob, parambl));
            localb.m("preChatName", c(this.Gob, parambl));
            localObject = k.a(localContext, parama, i, 1, null, (String)localObject);
            localc.GLG.a((CharSequence)localObject, paramString);
            paramString = new ChattingItemTranslate.a(parambl, parama1.eZb(), paramInt);
            paramString.nBH = 2;
            localc.GLG.setTag(paramString);
            paramString = localc.GLG;
            if (this.GPT == null) {
              this.GPT = new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(37468);
                  paramAnonymousView = (ChattingItemTranslate.a)((ChattingItemTranslate)paramAnonymousView).getTag();
                  if (((al)ax.a.a(ax.a.this).be(al.class)).wG(paramAnonymousView.drF.field_msgId) == ChattingItemTranslate.b.GPD) {
                    ((al)ax.a.a(ax.a.this).be(al.class)).a(paramAnonymousView.drF, true, paramAnonymousView.position, 1);
                  }
                  AppMethodBeat.o(37468);
                }
              };
            }
            paramString.setOnClickListener(this.GPT);
            localc.GLG.setOnLongClickListener(c(parama1));
            localc.GLG.setVisibility(0);
            if (!bt.isNullOrNil(parama))
            {
              localc.GLG.setOnTouchListener(locali.eWp());
              localc.GLG.setOnDoubleClickListener(new NeatTextView.b()
              {
                public final boolean fT(View paramAnonymousView)
                {
                  AppMethodBeat.i(37466);
                  ax.c.g(aj.getContext(), parama);
                  ax.cp(parambl);
                  AppMethodBeat.o(37466);
                  return true;
                }
              });
            }
            label489:
            parama = new p(parambl.field_content);
            if (parama.time != 0L) {
              break label631;
            }
            localc.GHZ.setVisibility(8);
          }
        }
        for (;;)
        {
          parama = parambl.eOT;
          if ((parama != null) && (parama.length() != 0)) {
            break label818;
          }
          localc.GIU.setVisibility(8);
          AppMethodBeat.o(37471);
          return;
          if (!((al)localObject).wH(parambl.field_msgId)) {
            break label847;
          }
          parama = ((al)localObject).K(parambl.field_msgId, parambl.field_imgPath);
          paramString = ((al)localObject).wG(parambl.field_msgId);
          break;
          localObject = null;
          break label333;
          if (localc.GLG == null) {
            break label489;
          }
          localc.GLG.setVisibility(8);
          break label489;
          label631:
          paramString = ((com.tencent.mm.ui.chatting.c.b.ao)parama1.be(com.tencent.mm.ui.chatting.c.b.ao.class)).eYQ();
          if (((paramString != null) && (paramString.GkH == parambl.field_msgId)) || (s.W(parambl)))
          {
            paramInt = 1;
            paramString = localc.GHZ;
            if (paramInt == 0) {
              break label757;
            }
          }
          label757:
          for (i = 8;; i = 0)
          {
            paramString.setVisibility(i);
            i = (int)s.mI(parama.time);
            if (paramInt != 0) {
              break label763;
            }
            localc.GQa.setContentDescription(String.format(parama1.GzJ.getContext().getString(2131764732), new Object[] { Integer.valueOf(i) }));
            break;
            paramInt = 0;
            break label677;
          }
          label763:
          parama = ((f)parama1.be(f.class)).aKG(parama1.getTalkerUserName());
          paramString = a.a.eSf();
          localObject = localc.GQa;
          if (parama != null) {
            parama.toString();
          }
          paramString.aw((View)localObject, i);
        }
        localc.GIU.setVisibility(0);
        b(parama1, localc.GIU, bi.aLk(parama));
        AppMethodBeat.o(37471);
        return;
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
    {
      AppMethodBeat.i(37472);
      az.arV();
      Object localObject;
      int k;
      int i;
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        localObject = (ChattingItemTranslate.a)paramView.getTag();
        k = ((ChattingItemTranslate.a)localObject).position;
        if (((ChattingItemTranslate.a)localObject).nBH == 1) {
          if (((new p(parambl.field_content).time != 0L) || (parambl.field_isSend != 0)) && ((parambl.field_status != 1) || (parambl.field_isSend != 1)))
          {
            az.arV();
            Boolean localBoolean = (Boolean)com.tencent.mm.model.c.afk().get(26, null);
            localObject = localBoolean;
            if (localBoolean == null) {
              localObject = Boolean.FALSE;
            }
            if (!((Boolean)localObject).booleanValue()) {
              break label439;
            }
            paramContextMenu.add(k, 120, 0, 2131757073);
            az.arV();
            localObject = com.tencent.mm.model.c.apM().aHY(parambl.field_talker);
            if ((w.sQ(parambl.field_talker)) || (w.to(parambl.field_talker)) || (localObject == null) || (((com.tencent.mm.storage.af)localObject).eKB())) {
              break label457;
            }
            i = 1;
            label192:
            if (com.tencent.mm.bs.d.axB("favorite")) {
              paramContextMenu.add(k, 116, 0, paramView.getContext().getString(2131761941));
            }
            if (i != 0)
            {
              if (com.tencent.mm.am.af.awe().nI(2) <= 0) {
                break label463;
              }
              i = 1;
              label241:
              if ((i != 0) && (!this.Gob.eZc())) {
                paramContextMenu.add(k, 114, 0, paramView.getContext().getString(2131757217));
              }
            }
            localObject = (al)this.Gob.be(al.class);
            if (!ax.d(parambl, this.Gob)) {
              break label469;
            }
            if (!bt.isNullOrNil(((al)localObject).K(parambl.field_msgId, parambl.field_imgPath))) {
              break label685;
            }
            i = 2131757243;
          }
        }
      }
      for (;;)
      {
        label329:
        if ((w.sE(parambl.field_talker)) && (ac.eFq()) && (i != -1)) {
          paramContextMenu.add(k, 121, 0, i);
        }
        for (int j = 1;; j = 0)
        {
          if (!this.Gob.eZc()) {
            paramContextMenu.add(k, 100, 0, paramView.getContext().getString(2131757223));
          }
          if ((j == 0) && (ac.eFq()) && (i != -1)) {
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
          if (((al)localObject).wH(parambl.field_msgId)) {
            break label685;
          }
          i = 2131757243;
          break label329;
          if (((ChattingItemTranslate.a)localObject).nBH == 2)
          {
            localObject = (al)this.Gob.be(al.class);
            if (((al)localObject).wG(parambl.field_msgId) == ChattingItemTranslate.b.GPD) {
              paramContextMenu.add(k, 121, 0, 2131757239);
            }
            for (;;)
            {
              AppMethodBeat.o(37472);
              return false;
              if (!bt.isNullOrNil(((al)localObject).K(parambl.field_msgId, parambl.field_imgPath)))
              {
                paramContextMenu.add(k, 141, 0, paramView.getContext().getString(2131757218));
                paramContextMenu.add(k, 142, 0, paramView.getContext().getString(2131762559));
                if (com.tencent.mm.bs.d.axB("favorite")) {
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
    
    public final boolean a(final MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, final bl parambl)
    {
      AppMethodBeat.i(37473);
      Object localObject = (al)parama.be(al.class);
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(37473);
        return false;
        ((com.tencent.mm.ui.chatting.c.b.ao)parama.be(com.tencent.mm.ui.chatting.c.b.ao.class)).wj(true);
        AppMethodBeat.o(37473);
        return true;
        ((com.tencent.mm.ui.chatting.c.b.ao)parama.be(com.tencent.mm.ui.chatting.c.b.ao.class)).wj(false);
        AppMethodBeat.o(37473);
        return true;
        ax.f(parama, parambl);
        if (((al)localObject).eYM()) {
          h.d(parama.GzJ.getContext(), parama.GzJ.getContext().getString(2131764777), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(37467);
              s.Y(parambl);
              this.GPW.eYN();
              this.GPW.a(parambl, true, paramMenuItem.getGroupId(), 0);
              AppMethodBeat.o(37467);
            }
          });
        }
        for (;;)
        {
          com.tencent.mm.modelstat.b.huc.S(parambl);
          AppMethodBeat.o(37473);
          return true;
          s.Y(parambl);
          ((al)localObject).a(parambl, true, paramMenuItem.getGroupId(), 0);
        }
        paramMenuItem = (ClipboardManager)aj.getContext().getSystemService("clipboard");
        parama = ((al)localObject).K(parambl.field_msgId, parambl.field_imgPath);
        if (!bt.isNullOrNil(parama)) {
          paramMenuItem.setText(parama);
        }
        ax.e(8, parambl);
        continue;
        paramMenuItem = new Intent(parama.GzJ.getContext(), MsgRetransmitUI.class);
        localObject = ((al)localObject).K(parambl.field_msgId, parambl.field_imgPath);
        if (parambl.eLS())
        {
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ax.e(9, parambl);
          break;
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 4);
        }
        localObject = ((al)localObject).K(parambl.field_msgId, parambl.field_imgPath);
        paramMenuItem = new cs();
        com.tencent.mm.pluginsdk.model.g.b(paramMenuItem, (String)localObject, 1);
        paramMenuItem.deQ.fragment = parama.GzJ;
        paramMenuItem.deQ.deW = 43;
        if (paramMenuItem.deQ.deS != null)
        {
          parama = paramMenuItem.deQ.deS.DiD;
          if (parama != null)
          {
            parama.aEl(parambl.field_talker);
            parama.aEm(u.aqG());
            com.tencent.mm.sdk.b.a.ESL.l(paramMenuItem);
          }
        }
        for (;;)
        {
          ax.e(10, parambl);
          break;
          ad.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
        }
        ((com.tencent.mm.ui.chatting.c.b.ao)parama.be(com.tencent.mm.ui.chatting.c.b.ao.class)).bM(parambl);
        continue;
        ((com.tencent.mm.ui.chatting.c.b.ao)parama.be(com.tencent.mm.ui.chatting.c.b.ao.class)).bN(parambl);
      }
    }
    
    public final boolean aX(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 34);
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(37474);
      paramView = (bi)paramView.getTag();
      com.tencent.mm.modelstat.b.huc.R(paramView.drF);
      ax.b(parama, paramView);
      ((al)parama.be(al.class)).YR(2);
      AppMethodBeat.o(37474);
      return true;
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(37470);
      boolean bool = parama.eZb();
      AppMethodBeat.o(37470);
      return bool;
    }
    
    public final boolean faE()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements s.n
  {
    private int BWX = 3;
    private com.tencent.mm.ui.chatting.d.a Gob;
    
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
        localObject = new af(paramLayoutInflater, 2131493504);
        ((View)localObject).setTag(new ax.c().d((View)localObject, false, this.GjM));
      }
      AppMethodBeat.o(37477);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(37482);
      ((com.tencent.mm.ui.chatting.c.b.ao)parama.be(com.tencent.mm.ui.chatting.c.b.ao.class)).bN(parambl);
      AppMethodBeat.o(37482);
    }
    
    public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.d.a parama1, final bl parambl, String paramString)
    {
      AppMethodBeat.i(37478);
      this.Gob = parama1;
      ax.c localc = (ax.c)parama;
      localc.GQb.setFromVoice(false);
      localc.GQb.setFromGroup(parama1.eZb());
      com.tencent.mm.ui.chatting.c.b.i locali = (com.tencent.mm.ui.chatting.c.b.i)parama1.be(com.tencent.mm.ui.chatting.c.b.i.class);
      a(locali, parambl.field_msgId);
      ax.c.a(localc, parambl, paramInt, parama1, false, c(parama1));
      Object localObject = (al)parama1.be(al.class);
      parama = null;
      paramString = ChattingItemTranslate.b.GPB;
      if (ax.d(parambl, parama1))
      {
        localObject = ((al)localObject).K(parambl.field_msgId, parambl.field_imgPath);
        parama = (c.a)localObject;
        if (bt.isNullOrNil((String)localObject)) {
          break label768;
        }
        paramString = ChattingItemTranslate.b.GPE;
        parama = (c.a)localObject;
      }
      label768:
      for (;;)
      {
        if ((!bt.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.b.GPB))
        {
          if (localc.GLG == null)
          {
            localc.GLG = ((ChattingItemTranslate)localc.GLF.inflate());
            localc.GLG.setMinimumWidth(localc.GPY - com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 5));
            localc.GLG.init();
          }
          Context localContext = localc.GOh.getContext();
          int i = (int)localc.GLG.getContentView().getTextSize();
          if (parambl != null)
          {
            localObject = y.tD(parambl.field_msgSvrId);
            y.b localb = y.arz().E((String)localObject, true);
            localb.m("prePublishId", "msg_" + parambl.field_msgSvrId);
            localb.m("preUsername", b(this.Gob, parambl));
            localb.m("preChatName", c(this.Gob, parambl));
            label333:
            localObject = k.a(localContext, parama, i, 1, null, (String)localObject);
            localc.GLG.a((CharSequence)localObject, paramString);
            paramString = new ChattingItemTranslate.a(parambl, parama1.eZb(), paramInt);
            paramString.nBH = 2;
            localc.GLG.setTag(paramString);
            localc.GLG.setOnLongClickListener(c(parama1));
            localc.GLG.setVisibility(0);
            if (!bt.isNullOrNil(parama))
            {
              localc.GLG.setOnTouchListener(locali.eWp());
              localc.GLG.setOnDoubleClickListener(new NeatTextView.b()
              {
                public final boolean fT(View paramAnonymousView)
                {
                  AppMethodBeat.i(37475);
                  ax.c.g(aj.getContext(), parama);
                  ax.cp(parambl);
                  AppMethodBeat.o(37475);
                  return true;
                }
              });
            }
            label454:
            if (!faG()) {
              break label729;
            }
            if (localc.GQg != null) {
              localc.GQg.setVisibility(8);
            }
            if (localc.GJi != null) {
              localc.GJi.setVisibility(8);
            }
            if ((parambl.field_status != 1) && (parambl.field_status != 5)) {
              break label633;
            }
            localc.GQh.setBackgroundResource(2131231726);
            parambl.FzQ = true;
          }
        }
        for (;;)
        {
          a(paramInt, localc, parambl, parama1.eYX(), parama1.eZb(), parama1, this);
          AppMethodBeat.o(37478);
          return;
          if (!((al)localObject).wH(parambl.field_msgId)) {
            break label768;
          }
          parama = ((al)localObject).K(parambl.field_msgId, parambl.field_imgPath);
          paramString = ((al)localObject).wG(parambl.field_msgId);
          break;
          localObject = null;
          break label333;
          if (localc.GLG == null) {
            break label454;
          }
          localc.GLG.setVisibility(8);
          break label454;
          label633:
          localc.GQh.setBackground(com.tencent.mm.ui.ao.aC(parama1.GzJ.getContext(), 2130968741));
          if ((localc.GJi != null) && (a(locali, parambl.field_msgId)))
          {
            if (parambl.FzQ)
            {
              parama = new AlphaAnimation(0.5F, 1.0F);
              parama.setDuration(300L);
              localc.GQh.startAnimation(parama);
              parambl.FzQ = false;
            }
            localc.GJi.setVisibility(0);
            continue;
            label729:
            if (localc.GQg != null)
            {
              localc.GQg.setVisibility(0);
              if (parambl.field_status >= 2) {
                localc.GQg.setVisibility(8);
              }
            }
          }
        }
      }
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
    {
      AppMethodBeat.i(37479);
      az.arV();
      Object localObject;
      int k;
      al localal;
      int i;
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        localObject = (ChattingItemTranslate.a)paramView.getTag();
        k = ((ChattingItemTranslate.a)localObject).position;
        if (((ChattingItemTranslate.a)localObject).nBH == 1)
        {
          localObject = new p(parambl.field_content);
          if (((((p)localObject).time != 0L) || (parambl.field_isSend != 0)) && ((parambl.field_status != 1) || (parambl.field_isSend != 1)))
          {
            if (((com.tencent.mm.ui.chatting.c.b.ao)this.Gob.be(com.tencent.mm.ui.chatting.c.b.ao.class)).eYS()) {
              paramContextMenu.add(k, 120, 0, 2131757073);
            }
          }
          else
          {
            if (parambl.field_status == 5) {
              paramContextMenu.add(k, 103, 0, paramView.getContext().getString(2131757286));
            }
            if (com.tencent.mm.bs.d.axB("favorite")) {
              paramContextMenu.add(k, 116, 0, paramView.getContext().getString(2131761941));
            }
            if ((!parambl.eJL()) && (parambl.eJN()) && ((parambl.field_status == 2) || (parambl.eOX == 1)) && (b(parambl, this.Gob)) && (aKZ(parambl.field_talker))) {
              paramContextMenu.add(k, 123, 0, paramView.getContext().getString(2131757234));
            }
            localal = (al)this.Gob.be(al.class);
            if (!ax.d(parambl, this.Gob)) {
              break label469;
            }
            if (!bt.isNullOrNil(localal.K(parambl.field_msgId, parambl.field_imgPath))) {
              break label685;
            }
            i = 2131757243;
          }
        }
      }
      for (;;)
      {
        label307:
        if ((w.sE(parambl.field_talker)) && (ac.eFq()) && (i != -1)) {
          paramContextMenu.add(k, 121, 0, 2131757243);
        }
        for (int j = 1;; j = 0)
        {
          if (((((p)localObject).time != 0L) || (parambl.field_isSend != 0)) && ((parambl.field_status != 1) || (parambl.field_isSend != 1)) && (!this.Gob.eZc())) {
            paramContextMenu.add(k, 100, 0, paramView.getContext().getString(2131757223));
          }
          if ((j == 0) && (ac.eFq()) && (i != -1)) {
            paramContextMenu.add(k, 121, 0, i);
          }
          AppMethodBeat.o(37479);
          return true;
          paramContextMenu.add(k, 119, 0, 2131757072);
          break;
          label469:
          if (localal.wH(parambl.field_msgId)) {
            break label685;
          }
          i = 2131757243;
          break label307;
          if (((ChattingItemTranslate.a)localObject).nBH == 2)
          {
            localObject = (al)this.Gob.be(al.class);
            if (((al)localObject).wG(parambl.field_msgId) == ChattingItemTranslate.b.GPD) {
              paramContextMenu.add(k, 121, 0, 2131757239);
            }
            for (;;)
            {
              AppMethodBeat.o(37479);
              return false;
              if (!bt.isNullOrNil(((al)localObject).K(parambl.field_msgId, parambl.field_imgPath)))
              {
                paramContextMenu.add(k, 141, 0, paramView.getContext().getString(2131757218));
                paramContextMenu.add(k, 142, 0, paramView.getContext().getString(2131762559));
                if (com.tencent.mm.bs.d.axB("favorite")) {
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
    
    public final boolean a(final MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, final bl parambl)
    {
      AppMethodBeat.i(37480);
      Object localObject = (al)parama.be(al.class);
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(37480);
        return false;
        ((com.tencent.mm.ui.chatting.c.b.ao)parama.be(com.tencent.mm.ui.chatting.c.b.ao.class)).wj(true);
        AppMethodBeat.o(37480);
        return true;
        ((com.tencent.mm.ui.chatting.c.b.ao)parama.be(com.tencent.mm.ui.chatting.c.b.ao.class)).wj(false);
        AppMethodBeat.o(37480);
        return true;
        ax.f(parama, parambl);
        if (((al)localObject).eYM()) {
          h.d(parama.GzJ.getContext(), parama.GzJ.getContext().getString(2131764777), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(37476);
              this.GPW.eYN();
              this.GPW.a(parambl, true, paramMenuItem.getGroupId(), 0);
              AppMethodBeat.o(37476);
            }
          });
        }
        for (;;)
        {
          com.tencent.mm.modelstat.b.huc.S(parambl);
          AppMethodBeat.o(37480);
          return true;
          ((al)localObject).a(parambl, true, paramMenuItem.getGroupId(), 0);
        }
        paramMenuItem = (ClipboardManager)aj.getContext().getSystemService("clipboard");
        parama = ((al)localObject).K(parambl.field_msgId, parambl.field_imgPath);
        if (!bt.isNullOrNil(parama)) {
          paramMenuItem.setText(parama);
        }
        ax.e(8, parambl);
        AppMethodBeat.o(37480);
        return true;
        paramMenuItem = new Intent(parama.GzJ.getContext(), MsgRetransmitUI.class);
        localObject = ((al)localObject).K(parambl.field_msgId, parambl.field_imgPath);
        if (parambl.eLS())
        {
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bd(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ax.e(9, parambl);
          AppMethodBeat.o(37480);
          return true;
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 4);
        }
        localObject = ((al)localObject).K(parambl.field_msgId, parambl.field_imgPath);
        paramMenuItem = new cs();
        com.tencent.mm.pluginsdk.model.g.b(paramMenuItem, (String)localObject, 1);
        paramMenuItem.deQ.fragment = parama.GzJ;
        paramMenuItem.deQ.deW = 43;
        if (paramMenuItem.deQ.deS != null)
        {
          parama = paramMenuItem.deQ.deS.DiD;
          if (parama != null)
          {
            parama.aEl(u.aqG());
            parama.aEm(parambl.field_talker);
            com.tencent.mm.sdk.b.a.ESL.l(paramMenuItem);
          }
        }
        for (;;)
        {
          ax.e(10, parambl);
          AppMethodBeat.o(37480);
          return true;
          ad.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
        }
        ((com.tencent.mm.ui.chatting.c.b.ao)parama.be(com.tencent.mm.ui.chatting.c.b.ao.class)).bN(parambl);
      }
    }
    
    public final boolean aX(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 34);
    }
    
    public final boolean b(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
    {
      AppMethodBeat.i(37481);
      paramView = (bi)paramView.getTag();
      com.tencent.mm.modelstat.b.huc.R(paramView.drF);
      ax.b(parama, paramView);
      ((al)parama.be(al.class)).YR(2);
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).Sa(parambl.field_talker);
      AppMethodBeat.o(37481);
      return true;
    }
    
    public final boolean faE()
    {
      return true;
    }
  }
  
  public static final class c
    extends c.a
  {
    TextView GIU;
    ImageView GJi;
    ViewStub GLF;
    ChattingItemTranslate GLG;
    TextView GOh;
    int GPY;
    TextView GPZ;
    TextView GQa;
    AnimImageView GQb;
    FrameLayout GQc;
    FrameLayout GQd;
    ImageView GQe;
    AnimImageView GQf;
    ProgressBar GQg;
    TextView GQh;
    Animation GQi;
    
    private static int Gp(int paramInt)
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
      paramc.GHZ.setVisibility(paramInt2);
      paramc.GOh.setVisibility(paramInt2);
      paramc.GQc.setVisibility(paramInt2);
      if (paramBoolean)
      {
        paramc.GQf.setVisibility(paramInt1);
        paramc.GIU.setVisibility(paramInt2);
        AppMethodBeat.o(37487);
        return;
      }
      if (paramc.GQh != null) {
        paramc.GQh.setVisibility(paramInt1);
      }
      AppMethodBeat.o(37487);
    }
    
    public static void a(c paramc, bl parambl, int paramInt, com.tencent.mm.ui.chatting.d.a parama, boolean paramBoolean, View.OnLongClickListener paramOnLongClickListener)
    {
      AppMethodBeat.i(37484);
      if (paramc == null)
      {
        AppMethodBeat.o(37484);
        return;
      }
      Object localObject = new p(parambl.field_content);
      float f1 = s.mI(((p)localObject).time);
      com.tencent.mm.ui.chatting.d locald = ((com.tencent.mm.ui.chatting.c.b.ao)parama.be(com.tencent.mm.ui.chatting.c.b.ao.class)).eYQ();
      label220:
      float f2;
      if ((locald != null) && (parambl.field_msgId == locald.GkH))
      {
        paramc.GQb.setVisibility(0);
        paramc.GQb.eSq();
        if (parambl.field_isSend != 0) {
          break label729;
        }
        if (((p)localObject).time != 0L) {
          break label525;
        }
        a(paramc, 8, 0, true);
        paramc.GQf.bTF();
        paramc.GQf.setVisibility(8);
        paramc.GHZ.setVisibility(8);
        f1 = 0.0F;
        paramc.GPY = com.tencent.mm.cd.a.fromDPToPix(parama.GzJ.getContext(), Gp(0));
        paramc.GQa.setWidth(paramc.GPY);
        paramc.GOh.setText(parama.GzJ.getMMResources().getString(2131759570, new Object[] { Integer.valueOf(0) }));
        paramc.GQb.setWidth(com.tencent.mm.cd.a.fromDPToPix(parama.GzJ.getContext(), Gp(0)));
        f2 = f1;
        if (1 != parambl.field_isSend) {
          break label1024;
        }
        if (parambl.field_status != 1) {
          break label732;
        }
        a(paramc, 0, 8, false);
        paramc.GQd.setVisibility(8);
        paramc.faT();
        label261:
        localObject = ((com.tencent.mm.ui.chatting.c.b.c)parama.be(com.tencent.mm.ui.chatting.c.b.c.class)).eXd();
        if (localObject != null)
        {
          if (!((com.tencent.mm.pluginsdk.ui.e)localObject).BUO) {
            break label1031;
          }
          paramc.GOh.setShadowLayer(2.0F, 1.2F, 1.2F, ((com.tencent.mm.pluginsdk.ui.e)localObject).BUP);
          label307:
          if (!((com.tencent.mm.pluginsdk.ui.e)localObject).BUQ) {
            break label1045;
          }
          paramc.GOh.setBackgroundResource(2131231724);
        }
        label324:
        localObject = new ChattingItemTranslate.a(parambl, parama.eZb(), paramInt);
        paramc.GQa.setTag(localObject);
        paramc.GQa.setOnClickListener(paramc.GIb.d(parama));
        paramc.GQa.setOnLongClickListener(paramOnLongClickListener);
        paramc.GQa.setOnTouchListener(((com.tencent.mm.ui.chatting.c.b.i)parama.be(com.tencent.mm.ui.chatting.c.b.i.class)).eWp());
        if ((parambl.esg & 0x1) != 1) {
          break label1079;
        }
        paramc.GPZ.setVisibility(0);
        if (parambl.field_isSend != 0) {
          break label1056;
        }
        paramc.GQb.setBackgroundResource(2131231624);
        label428:
        if (!paramBoolean) {
          break label1161;
        }
        parama.getTalkerUserName();
      }
      for (;;)
      {
        parambl = ((f)parama.be(f.class)).aKG(parama.getTalkerUserName());
        parama = a.a.eSf();
        paramOnLongClickListener = paramc.GQa;
        paramInt = (int)f1;
        if (parambl != null) {
          parambl.toString();
        }
        parama.aw(paramOnLongClickListener, paramInt);
        paramc.GOh.setContentDescription(" ");
        AppMethodBeat.o(37484);
        return;
        paramc.GQb.setVisibility(8);
        paramc.GQb.bTF();
        break;
        label525:
        if (((p)localObject).time == -1L)
        {
          a(paramc, 8, 0, true);
          paramc.GQf.bTF();
          paramc.GQf.setVisibility(8);
          paramc.GPY = 80;
          paramc.GQa.setWidth(80);
          paramc.GOh.setVisibility(8);
          paramc.GQb.setWidth(com.tencent.mm.cd.a.fromDPToPix(parama.GzJ.getContext(), Gp((int)f1)));
          break label220;
        }
        a(paramc, 8, 0, true);
        paramc.GQf.bTF();
        paramc.GQf.setVisibility(8);
        paramc.GOh.setVisibility(0);
        paramc.GPY = com.tencent.mm.cd.a.fromDPToPix(parama.GzJ.getContext(), Gp((int)f1));
        paramc.GQa.setWidth(paramc.GPY);
        paramc.GOh.setText(parama.GzJ.getMMResources().getString(2131759570, new Object[] { Integer.valueOf((int)f1) }));
        paramc.GQb.setWidth(com.tencent.mm.cd.a.fromDPToPix(parama.GzJ.getContext(), Gp((int)f1)));
        label729:
        break label220;
        label732:
        if (((p)localObject).time == -1L)
        {
          a(paramc, 8, 0, false);
          paramc.GQa.setWidth(80);
          paramc.GPY = 80;
          paramc.GOh.setVisibility(8);
          paramc.GQd.setVisibility(8);
          paramc.GQb.setWidth(com.tencent.mm.cd.a.fromDPToPix(parama.GzJ.getContext(), Gp((int)f1)));
          paramc.faT();
          break label261;
        }
        if (parambl.field_status == 7)
        {
          a(paramc, 8, 8, false);
          paramc.GOh.setVisibility(8);
          paramc.GQd.setVisibility(0);
          paramc.faT();
          if (paramc.GQe != null)
          {
            paramc.GQi = AnimationUtils.loadAnimation(paramc.rLd.getContext(), 2130772168);
            paramc.GQe.startAnimation(paramc.GQi);
          }
          break label261;
        }
        a(paramc, 8, 0, false);
        paramc.GQd.setVisibility(8);
        paramc.GOh.setVisibility(0);
        paramc.faT();
        if (((p)localObject).time == 0L) {
          f1 = 0.0F;
        }
        paramc.GPY = com.tencent.mm.cd.a.fromDPToPix(parama.GzJ.getContext(), Gp((int)f1));
        paramc.GQa.setWidth(paramc.GPY);
        paramc.GOh.setText(parama.GzJ.getMMResources().getString(2131759570, new Object[] { Integer.valueOf((int)f1) }));
        paramc.GQb.setWidth(com.tencent.mm.cd.a.fromDPToPix(parama.GzJ.getContext(), Gp((int)f1)));
        f2 = f1;
        label1024:
        f1 = f2;
        break label261;
        label1031:
        paramc.GOh.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        break label307;
        label1045:
        paramc.GOh.setBackgroundColor(0);
        break label324;
        label1056:
        paramc.GQh.setBackgroundResource(2131231734);
        paramc.GQb.setBackgroundResource(2131231734);
        break label428;
        label1079:
        paramc.GPZ.setVisibility(8);
        if (parambl.field_isSend == 0)
        {
          paramc.GQb.setBackground(com.tencent.mm.ui.ao.aC(parama.GzJ.getContext(), 2130968736));
          break label428;
        }
        paramc.GQh.setBackground(com.tencent.mm.ui.ao.aC(parama.GzJ.getContext(), 2130968741));
        paramc.GQb.setBackground(com.tencent.mm.ui.ao.aC(parama.GzJ.getContext(), 2130968741));
        break label428;
        label1161:
        parama.eYX();
      }
    }
    
    private void faT()
    {
      AppMethodBeat.i(37486);
      if (this.GQi != null)
      {
        this.GQi.cancel();
        this.GQi = null;
      }
      AppMethodBeat.o(37486);
    }
    
    static void g(Context paramContext, CharSequence paramCharSequence)
    {
      AppMethodBeat.i(37485);
      Intent localIntent = new Intent(paramContext, TextPreviewUI.class);
      localIntent.putExtra("key_chat_text", paramCharSequence);
      paramCharSequence = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramCharSequence.adn(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$VoiceItemHolder", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramCharSequence.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$VoiceItemHolder", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.jH(paramContext);
      AppMethodBeat.o(37485);
    }
    
    public final c.a d(View paramView, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(37483);
      super.fK(paramView);
      this.fwS = ((TextView)paramView.findViewById(2131298178));
      this.wet = ((TextView)paramView.findViewById(2131298185));
      this.GQa = ((TextView)paramView.findViewById(2131298197));
      this.hIS = ((CheckBox)paramView.findViewById(2131298068));
      this.lRB = paramView.findViewById(2131298147);
      this.GHZ = ((ImageView)paramView.findViewById(2131298174));
      this.GOh = ((TextView)paramView.findViewById(2131298073));
      this.GQc = ((FrameLayout)paramView.findViewById(2131298198));
      this.GLF = ((ViewStub)paramView.findViewById(2131306075));
      this.GPZ = ((TextView)paramView.findViewById(2131298195));
      this.GQb = ((AnimImageView)paramView.findViewById(2131298194));
      this.GQb.setType(1);
      if (paramBoolean1)
      {
        this.GQb.setFromVoice(true);
        this.GQb.setFromGroup(paramBoolean2);
        this.GIU = ((TextView)paramView.findViewById(2131298023));
        this.GQf = ((AnimImageView)paramView.findViewById(2131298196));
        this.GQf.setFromVoice(true);
        this.GQf.setFromGroup(paramBoolean2);
        this.GQf.setType(0);
      }
      for (;;)
      {
        AppMethodBeat.o(37483);
        return this;
        this.GQd = ((FrameLayout)paramView.findViewById(2131298205));
        this.GQe = ((ImageView)paramView.findViewById(2131298206));
        this.GQg = ((ProgressBar)paramView.findViewById(2131298207));
        this.uPp = ((ProgressBar)paramView.findViewById(2131306220));
        this.GQh = ((TextView)paramView.findViewById(2131298208));
        this.GQb.setFromVoice(false);
        this.GQb.setFromGroup(paramBoolean2);
        this.GJi = ((ImageView)paramView.findViewById(2131298176));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ax
 * JD-Core Version:    0.7.0.1
 */