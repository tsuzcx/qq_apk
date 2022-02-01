package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.text.ClipboardManager;
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
import com.tencent.mm.am.ag;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.a;
import com.tencent.mm.g.a.ge;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.d.b.ap;
import com.tencent.mm.ui.chatting.d.b.as;
import com.tencent.mm.ui.chatting.s.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class az
{
  public static boolean a(com.tencent.mm.ui.chatting.e.a parama, bu parambu, int paramInt)
  {
    AppMethodBeat.i(194510);
    if (parambu == null)
    {
      AppMethodBeat.o(194510);
      return false;
    }
    boolean bool1;
    if (parambu.fsi()) {
      if (((as)parama.bh(as.class)).Eg(parambu.field_msgId))
      {
        ad.i("MicroMsg.ChattingItemVoice", "onCreateContextMenu: voice msg is downloading.(1)");
        bool1 = true;
        bool2 = bool1;
        if (bool1)
        {
          ad.i("MicroMsg.ChattingItemVoice", "handleNoFinishDownloadVoiceMsg show alert!");
          com.tencent.mm.ui.base.h.a(parama.JOR.getContext(), parama.JOR.getContext().getString(paramInt), "", parama.JOR.getContext().getString(2131766205), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = false)
    {
      AppMethodBeat.o(194510);
      return bool2;
      if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(parambu.field_msgId).fsi())
      {
        ad.i("MicroMsg.ChattingItemVoice", "onCreateContextMenu: voice msg is downloading.(2)");
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
    }
  }
  
  public static void b(com.tencent.mm.ui.chatting.e.a parama, bk parambk)
  {
    AppMethodBeat.i(37488);
    if ((com.tencent.mm.s.a.cf(parama.JOR.getContext())) || (com.tencent.mm.s.a.cd(parama.JOR.getContext())) || (com.tencent.mm.s.a.ch(parama.JOR.getContext())))
    {
      ad.d("MicroMsg.ChattingItemVoice", "voip is running, not play voice");
      AppMethodBeat.o(37488);
      return;
    }
    ba.aBQ();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.g(parama.JOR.getContext(), parama.JOR.getContentView());
      AppMethodBeat.o(37488);
      return;
    }
    Object localObject;
    bu localbu;
    int i;
    if ((parambk != null) && (parambk.dBd != null))
    {
      localObject = new p(parambk.dBd.field_content);
      if ((af.isNullOrNil(parambk.dBd.field_content)) || (((p)localObject).time == 0L))
      {
        Toast.makeText(parama.JOR.getContext(), 2131757151, 0).show();
        AppMethodBeat.o(37488);
        return;
      }
      localObject = ((as)parama.bh(as.class)).fFk();
      if ((parama.bh(com.tencent.mm.ui.chatting.d.b.k.class) != null) && (localObject != null))
      {
        localbu = parambk.dBd;
        if (((as)parama.bh(as.class)).fFk().Jyn != localbu.field_msgId)
        {
          parama = (ap)parama.bh(ap.class);
          if (!parama.Ed(localbu.field_msgId)) {
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
        parama = new ge();
        parama.drO.drP = 1;
        parama.drO.scene = i;
        parama.drO.fileName = localbu.field_imgPath;
        com.tencent.mm.sdk.b.a.IbL.l(parama);
      }
      i = parambk.position;
      parama = parambk.dBd;
      if ((parama == null) || (!parama.fph()))
      {
        AppMethodBeat.o(37488);
        return;
        label322:
        if (parama.Ea(localbu.field_msgId)) {
          i = 6;
        }
      }
      else
      {
        parambk = new p(parama.field_content);
        if (((parambk.time == 0L) && (parama.field_isSend == 0)) || ((parama.field_status == 1) && (parama.field_isSend == 1)))
        {
          AppMethodBeat.o(37488);
          return;
        }
        if ((parama.field_isSend != 0) || (parambk.time != -1L))
        {
          ((com.tencent.mm.ui.chatting.d)localObject).fAF();
          ba.aBQ();
          parambk = (Boolean)com.tencent.mm.model.c.ajl().get(4115, null);
          if ((parambk == null) || (!parambk.booleanValue()))
          {
            ba.aBQ();
            com.tencent.mm.model.c.ajl().set(4115, Boolean.TRUE);
            ((com.tencent.mm.ui.chatting.d)localObject).fAK();
            ((com.tencent.mm.ui.chatting.d)localObject).Jyq = t.a(((com.tencent.mm.ui.chatting.d)localObject).cWM.JOR.getActivity(), ((com.tencent.mm.ui.chatting.d)localObject).context.getString(2131757255), 4000L);
          }
          if ((((com.tencent.mm.ui.chatting.d)localObject).pyq.isPlaying()) && (parama.field_msgId == ((com.tencent.mm.ui.chatting.d)localObject).Jyn))
          {
            ((com.tencent.mm.ui.chatting.d)localObject).Jyw = true;
            ((com.tencent.mm.ui.chatting.d)localObject).aoV();
            AppMethodBeat.o(37488);
            return;
          }
          ((com.tencent.mm.ui.chatting.d)localObject).aQ(parama);
          if ((parama.field_isSend == 0) && (!s.Z(parama))) {
            ((com.tencent.mm.ui.chatting.d)localObject).acI(i + 1);
          }
          ((com.tencent.mm.ui.chatting.d)localObject).xO(true);
        }
        AppMethodBeat.o(37488);
        return;
      }
      i = 0;
    }
  }
  
  public static boolean b(com.tencent.mm.ui.chatting.e.a parama, bu parambu, int paramInt)
  {
    AppMethodBeat.i(194511);
    if ((parambu != null) && (parambu.field_status == 5))
    {
      ad.i("MicroMsg.ChattingItemVoice", "handleDownloadFailVoiceMsg show alert!");
      com.tencent.mm.ui.base.h.a(parama.JOR.getContext(), parama.JOR.getContext().getString(paramInt), "", parama.JOR.getContext().getString(2131766205), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(194511);
      return true;
    }
    AppMethodBeat.o(194511);
    return false;
  }
  
  public static final class a
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JBI;
    private View.OnClickListener Kgu;
    
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
        localObject = new ah(paramLayoutInflater, 2131493461);
        ((View)localObject).setTag(new az.c().d((View)localObject, true, this.Jxs));
      }
      AppMethodBeat.o(37469);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, final bu parambu, String paramString)
    {
      AppMethodBeat.i(37471);
      this.JBI = parama1;
      az.c localc = (az.c)parama;
      localc.KgC.setFromVoice(true);
      localc.KgC.setFromGroup(parama1.fFv());
      com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class);
      b(localk, parambu.field_msgId);
      az.c.a(localc, parambu, paramInt, parama1, true, c(parama1));
      parama = null;
      paramString = ChattingItemTranslate.b.Kgd;
      Object localObject = (ap)parama1.bh(ap.class);
      if (az.d(parambu, parama1))
      {
        localObject = ((ap)localObject).N(parambu.field_msgId, parambu.field_imgPath);
        parama = (c.a)localObject;
        if (bt.isNullOrNil((String)localObject)) {
          break label847;
        }
        paramString = ChattingItemTranslate.b.Kgg;
        parama = (c.a)localObject;
      }
      label333:
      label847:
      for (;;)
      {
        int i;
        if ((!bt.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.b.Kgd))
        {
          if (localc.Kcd == null)
          {
            localc.Kcd = ((ChattingItemTranslate)localc.Kcc.inflate());
            localc.Kcd.setMinimumWidth(localc.Kgz - com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 5));
            localc.Kcd.init();
          }
          Context localContext = localc.KeJ.getContext();
          i = (int)localc.Kcd.getContentView().getTextSize();
          if (parambu != null)
          {
            localObject = y.AH(parambu.field_msgSvrId);
            y.b localb = y.aBq().F((String)localObject, true);
            localb.k("prePublishId", "msg_" + parambu.field_msgSvrId);
            localb.k("preUsername", b(this.JBI, parambu));
            localb.k("preChatName", c(this.JBI, parambu));
            localObject = com.tencent.mm.pluginsdk.ui.span.k.a(localContext, parama, i, 1, null, (String)localObject);
            localc.Kcd.a((CharSequence)localObject, paramString);
            paramString = new ChattingItemTranslate.a(parambu, parama1.fFv(), paramInt);
            paramString.oIb = 2;
            localc.Kcd.setTag(paramString);
            paramString = localc.Kcd;
            if (this.Kgu == null) {
              this.Kgu = new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(194505);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  paramAnonymousView = (ChattingItemTranslate.a)((ChattingItemTranslate)paramAnonymousView).getTag();
                  if (((ap)az.a.a(az.a.this).bh(ap.class)).DZ(paramAnonymousView.dBd.field_msgId) == ChattingItemTranslate.b.Kgf) {
                    ((ap)az.a.a(az.a.this).bh(ap.class)).a(paramAnonymousView.dBd, true, paramAnonymousView.position, 1);
                  }
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(194505);
                }
              };
            }
            paramString.setOnClickListener(this.Kgu);
            localc.Kcd.setOnLongClickListener(c(parama1));
            localc.Kcd.setVisibility(0);
            if (!bt.isNullOrNil(parama))
            {
              localc.Kcd.setOnTouchListener(localk.fCu());
              localc.Kcd.setOnDoubleClickListener(new NeatTextView.b()
              {
                public final boolean gx(View paramAnonymousView)
                {
                  AppMethodBeat.i(37466);
                  az.c.f(aj.getContext(), parama);
                  az.cy(parambu);
                  AppMethodBeat.o(37466);
                  return true;
                }
              });
            }
            label489:
            parama = new p(parambu.field_content);
            if (parama.time != 0L) {
              break label631;
            }
            localc.JYs.setVisibility(8);
          }
        }
        for (;;)
        {
          parama = parambu.fkq;
          if ((parama != null) && (parama.length() != 0)) {
            break label818;
          }
          localc.JZp.setVisibility(8);
          AppMethodBeat.o(37471);
          return;
          if (!((ap)localObject).Ea(parambu.field_msgId)) {
            break label847;
          }
          parama = ((ap)localObject).N(parambu.field_msgId, parambu.field_imgPath);
          paramString = ((ap)localObject).DZ(parambu.field_msgId);
          break;
          localObject = null;
          break label333;
          if (localc.Kcd == null) {
            break label489;
          }
          localc.Kcd.setVisibility(8);
          break label489;
          label631:
          paramString = ((as)parama1.bh(as.class)).fFk();
          if (((paramString != null) && (paramString.Jyn == parambu.field_msgId)) || (s.Z(parambu)))
          {
            paramInt = 1;
            paramString = localc.JYs;
            if (paramInt == 0) {
              break label757;
            }
          }
          label757:
          for (i = 8;; i = 0)
          {
            paramString.setVisibility(i);
            i = (int)s.sv(parama.time);
            if (paramInt != 0) {
              break label763;
            }
            localc.KgB.setContentDescription(String.format(parama1.JOR.getContext().getString(2131764732), new Object[] { Integer.valueOf(i) }));
            break;
            paramInt = 0;
            break label677;
          }
          label763:
          parama = ((com.tencent.mm.ui.chatting.d.b.f)parama1.bh(com.tencent.mm.ui.chatting.d.b.f.class)).aWa(parama1.getTalkerUserName());
          paramString = a.a.fyf();
          localObject = localc.KgB;
          if (parama != null) {
            parama.toString();
          }
          paramString.aA((View)localObject, i);
        }
        localc.JZp.setVisibility(0);
        b(parama1, localc.JZp, bk.aWI(parama));
        AppMethodBeat.o(37471);
        return;
      }
    }
    
    public final boolean a(final MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, final bu parambu)
    {
      AppMethodBeat.i(37473);
      Object localObject = (ap)parama.bh(ap.class);
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(37473);
        return false;
        ((as)parama.bh(as.class)).xZ(true);
        AppMethodBeat.o(37473);
        return true;
        ((as)parama.bh(as.class)).xZ(false);
        AppMethodBeat.o(37473);
        return true;
        if (az.a(parama, parambu, 2131766902))
        {
          AppMethodBeat.o(37473);
          return true;
        }
        if (az.b(parama, parambu, 2131766902))
        {
          AppMethodBeat.o(37473);
          return true;
        }
        az.f(parama, parambu);
        if (((ap)localObject).fFf()) {
          com.tencent.mm.ui.base.h.d(parama.JOR.getContext(), parama.JOR.getContext().getString(2131764777), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(37467);
              s.ab(parambu);
              this.Kgx.fFg();
              this.Kgx.a(parambu, true, paramMenuItem.getGroupId(), 0);
              AppMethodBeat.o(37467);
            }
          });
        }
        for (;;)
        {
          com.tencent.mm.modelstat.b.inZ.V(parambu);
          AppMethodBeat.o(37473);
          return true;
          s.ab(parambu);
          ((ap)localObject).a(parambu, true, paramMenuItem.getGroupId(), 0);
        }
        paramMenuItem = (ClipboardManager)aj.getContext().getSystemService("clipboard");
        parama = ((ap)localObject).N(parambu.field_msgId, parambu.field_imgPath);
        if (!bt.isNullOrNil(parama)) {
          paramMenuItem.setText(parama);
        }
        az.e(8, parambu);
        continue;
        paramMenuItem = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
        localObject = ((ap)localObject).N(parambu.field_msgId, parambu.field_imgPath);
        if (parambu.frz())
        {
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          az.e(9, parambu);
          break;
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 4);
        }
        localObject = ((ap)localObject).N(parambu.field_msgId, parambu.field_imgPath);
        paramMenuItem = new cv();
        com.tencent.mm.pluginsdk.model.g.b(paramMenuItem, (String)localObject, 1);
        paramMenuItem.dnG.fragment = parama.JOR;
        paramMenuItem.dnG.dnM = 43;
        if (paramMenuItem.dnG.dnI != null)
        {
          parama = paramMenuItem.dnG.dnI.Gjv;
          if (parama != null)
          {
            parama.aPf(parambu.field_talker);
            parama.aPg(u.aAm());
            com.tencent.mm.sdk.b.a.IbL.l(paramMenuItem);
          }
        }
        for (;;)
        {
          az.e(10, parambu);
          break;
          ad.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
        }
        ((as)parama.bh(as.class)).bV(parambu);
        continue;
        ((as)parama.bh(as.class)).bW(parambu);
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bu parambu)
    {
      int k = 0;
      AppMethodBeat.i(194506);
      ba.aBQ();
      Object localObject;
      int m;
      int i;
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        localObject = (ChattingItemTranslate.a)paramView.getTag();
        m = ((ChattingItemTranslate.a)localObject).position;
        if (((ChattingItemTranslate.a)localObject).oIb == 1) {
          if (((new p(parambu.field_content).time != 0L) || (parambu.field_isSend != 0)) && ((parambu.field_status != 1) || (parambu.field_isSend != 1)))
          {
            ba.aBQ();
            Boolean localBoolean = (Boolean)com.tencent.mm.model.c.ajl().get(26, null);
            localObject = localBoolean;
            if (localBoolean == null) {
              localObject = Boolean.FALSE;
            }
            if (!((Boolean)localObject).booleanValue()) {
              break label473;
            }
            paraml.a(m, 120, paramView.getContext().getString(2131757073), 2131690499);
            ba.aBQ();
            localObject = com.tencent.mm.model.c.azp().Bf(parambu.field_talker);
            if ((w.zQ(parambu.field_talker)) || (w.Ap(parambu.field_talker)) || (localObject == null) || (((am)localObject).fqg())) {
              break label498;
            }
            i = 1;
            label202:
            if (com.tencent.mm.bs.d.aIu("favorite")) {
              paraml.a(m, 116, paramView.getContext().getString(2131761941), 2131690400);
            }
            if (i != 0)
            {
              if (ag.aFZ().oX(2) <= 0) {
                break label504;
              }
              i = 1;
              label251:
              if ((i != 0) && (!this.JBI.fFw())) {
                paraml.add(m, 114, 0, paramView.getContext().getString(2131757217));
              }
            }
            localObject = (ap)this.JBI.bh(ap.class);
            if (!az.d(parambu, this.JBI)) {
              break label510;
            }
            if (!bt.isNullOrNil(((ap)localObject).N(parambu.field_msgId, parambu.field_imgPath))) {
              break label725;
            }
            i = 2131757243;
          }
        }
      }
      label725:
      for (;;)
      {
        int j = k;
        if (w.zE(parambu.field_talker))
        {
          j = k;
          if (ac.fko())
          {
            j = k;
            if (i != -1)
            {
              paraml.a(m, 121, paramView.getContext().getString(i), 2131690490);
              j = 1;
            }
          }
        }
        if (!this.JBI.fFw()) {
          paraml.a(m, 100, paramView.getContext().getString(2131757223), 2131690384);
        }
        if ((j == 0) && (ac.fko()) && (i != -1)) {
          paraml.a(m, 121, paramView.getContext().getString(i), 2131690490);
        }
        AppMethodBeat.o(194506);
        return true;
        label473:
        paraml.a(m, 119, paramView.getContext().getString(2131757072), 2131690395);
        break;
        label498:
        i = 0;
        break label202;
        label504:
        i = 0;
        break label251;
        label510:
        if (!((ap)localObject).Ea(parambu.field_msgId))
        {
          i = 2131757243;
          continue;
          if (((ChattingItemTranslate.a)localObject).oIb == 2)
          {
            localObject = (ap)this.JBI.bh(ap.class);
            if (((ap)localObject).DZ(parambu.field_msgId) == ChattingItemTranslate.b.Kgf) {
              paraml.add(m, 121, 0, 2131757239);
            }
            for (;;)
            {
              AppMethodBeat.o(194506);
              return false;
              if (!bt.isNullOrNil(((ap)localObject).N(parambu.field_msgId, parambu.field_imgPath)))
              {
                paraml.a(m, 141, paramView.getContext().getString(2131757218), 2131690381);
                paraml.a(m, 142, paramView.getContext().getString(2131762559), 2131690478);
                if (com.tencent.mm.bs.d.aIu("favorite")) {
                  paraml.a(m, 143, paramView.getContext().getString(2131761941), 2131690400);
                }
              }
              paraml.a(m, 121, paramView.getContext().getString(2131757241), 2131690398);
            }
          }
          AppMethodBeat.o(194506);
          return true;
        }
        else
        {
          i = -1;
        }
      }
    }
    
    public final boolean b(View paramView, final com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(37474);
      if (parambu.field_status == 5)
      {
        ad.i("MicroMsg.ChattingItemVoice", "onItemClick msg(%s) fail", new Object[] { Long.valueOf(parambu.field_msgId) });
        AppMethodBeat.o(37474);
        return true;
      }
      if (parambu.fsi())
      {
        ((as)parama.bh(as.class)).a(parambu.field_msgId, paramView);
        if (((as)parama.bh(as.class)).Eg(parambu.field_msgId))
        {
          ad.i("MicroMsg.ChattingItemVoice", "onCreateContextMenu: voice msg show download animation");
          AppMethodBeat.o(37474);
          return true;
        }
        bu localbu = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(parambu.field_msgId);
        if (localbu.fsi())
        {
          ((as)parama.bh(as.class)).Ef(localbu.field_msgId);
          o.aNA().run();
          com.tencent.e.h.LTJ.aP(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(194504);
              parama.bOo();
              AppMethodBeat.o(194504);
            }
          });
          ad.i("MicroMsg.ChattingItemVoice", "onItemClick voice msg(%s) no finish download!", new Object[] { Long.valueOf(parambu.field_msgId) });
          AppMethodBeat.o(37474);
          return true;
        }
      }
      ((as)parama.bh(as.class)).fFn();
      paramView = (bk)paramView.getTag();
      com.tencent.mm.modelstat.b.inZ.U(paramView.dBd);
      az.b(parama, paramView);
      ((ap)parama.bh(ap.class)).ado(2);
      ((com.tencent.mm.ui.chatting.d.b.aq)parama.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).fFj();
      com.tencent.mm.am.l.I(parambu);
      AppMethodBeat.o(37474);
      return true;
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(37470);
      boolean bool = parama.fFv();
      AppMethodBeat.o(37470);
      return bool;
    }
    
    public final boolean bi(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 34);
    }
    
    public final boolean fHh()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements s.n
  {
    private int EUs = 3;
    private com.tencent.mm.ui.chatting.e.a JBI;
    
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
        localObject = new ah(paramLayoutInflater, 2131493504);
        ((View)localObject).setTag(new az.c().d((View)localObject, false, this.Jxs));
      }
      AppMethodBeat.o(37477);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(37482);
      ((as)parama.bh(as.class)).bW(parambu);
      AppMethodBeat.o(37482);
    }
    
    public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, final bu parambu, String paramString)
    {
      AppMethodBeat.i(37478);
      this.JBI = parama1;
      az.c localc = (az.c)parama;
      localc.KgC.setFromVoice(false);
      localc.KgC.setFromGroup(parama1.fFv());
      com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class);
      b(localk, parambu.field_msgId);
      az.c.a(localc, parambu, paramInt, parama1, false, c(parama1));
      Object localObject = (ap)parama1.bh(ap.class);
      parama = null;
      paramString = ChattingItemTranslate.b.Kgd;
      if (az.d(parambu, parama1))
      {
        localObject = ((ap)localObject).N(parambu.field_msgId, parambu.field_imgPath);
        parama = (c.a)localObject;
        if (bt.isNullOrNil((String)localObject)) {
          break label758;
        }
        paramString = ChattingItemTranslate.b.Kgg;
        parama = (c.a)localObject;
      }
      label333:
      label719:
      label758:
      for (;;)
      {
        if ((!bt.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.b.Kgd))
        {
          if (localc.Kcd == null)
          {
            localc.Kcd = ((ChattingItemTranslate)localc.Kcc.inflate());
            localc.Kcd.setMinimumWidth(localc.Kgz - com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 5));
            localc.Kcd.init();
          }
          Context localContext = localc.KeJ.getContext();
          int i = (int)localc.Kcd.getContentView().getTextSize();
          if (parambu != null)
          {
            localObject = y.AH(parambu.field_msgSvrId);
            y.b localb = y.aBq().F((String)localObject, true);
            localb.k("prePublishId", "msg_" + parambu.field_msgSvrId);
            localb.k("preUsername", b(this.JBI, parambu));
            localb.k("preChatName", c(this.JBI, parambu));
            localObject = com.tencent.mm.pluginsdk.ui.span.k.a(localContext, parama, i, 1, null, (String)localObject);
            localc.Kcd.a((CharSequence)localObject, paramString);
            paramString = new ChattingItemTranslate.a(parambu, parama1.fFv(), paramInt);
            paramString.oIb = 2;
            localc.Kcd.setTag(paramString);
            localc.Kcd.setOnLongClickListener(c(parama1));
            localc.Kcd.setVisibility(0);
            if (!bt.isNullOrNil(parama))
            {
              localc.Kcd.setOnTouchListener(localk.fCu());
              localc.Kcd.setOnDoubleClickListener(new NeatTextView.b()
              {
                public final boolean gx(View paramAnonymousView)
                {
                  AppMethodBeat.i(37475);
                  az.c.f(aj.getContext(), parama);
                  az.cy(parambu);
                  AppMethodBeat.o(37475);
                  return true;
                }
              });
            }
            if (!fHj()) {
              break label719;
            }
            if (localc.KgI != null) {
              localc.KgI.setVisibility(8);
            }
            if (localc.JZD != null) {
              localc.JZD.setVisibility(8);
            }
            if ((parambu.field_status != 1) && (parambu.field_status != 5)) {
              break label633;
            }
            localc.KgJ.setBackgroundResource(2131231726);
            parambu.IMh = true;
          }
        }
        for (;;)
        {
          a(paramInt, localc, parambu, parama1.fFr(), parama1.fFv(), parama1, this);
          AppMethodBeat.o(37478);
          return;
          if (!((ap)localObject).Ea(parambu.field_msgId)) {
            break label758;
          }
          parama = ((ap)localObject).N(parambu.field_msgId, parambu.field_imgPath);
          paramString = ((ap)localObject).DZ(parambu.field_msgId);
          break;
          localObject = null;
          break label333;
          if (localc.Kcd == null) {
            break label454;
          }
          localc.Kcd.setVisibility(8);
          break label454;
          label633:
          localc.KgJ.setBackgroundResource(2131231725);
          if ((localc.JZD != null) && (b(localk, parambu.field_msgId)))
          {
            if (parambu.IMh)
            {
              parama = new AlphaAnimation(0.5F, 1.0F);
              parama.setDuration(300L);
              localc.KgJ.startAnimation(parama);
              parambu.IMh = false;
            }
            localc.JZD.setVisibility(0);
            continue;
            if (localc.KgI != null)
            {
              localc.KgI.setVisibility(0);
              if (parambu.field_status >= 2) {
                localc.KgI.setVisibility(8);
              }
            }
          }
        }
      }
    }
    
    public final boolean a(final MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, final bu parambu)
    {
      AppMethodBeat.i(37480);
      Object localObject = (ap)parama.bh(ap.class);
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(37480);
        return false;
        ((as)parama.bh(as.class)).xZ(true);
        AppMethodBeat.o(37480);
        return true;
        ((as)parama.bh(as.class)).xZ(false);
        AppMethodBeat.o(37480);
        return true;
        if (az.a(parama, parambu, 2131766902))
        {
          AppMethodBeat.o(37480);
          return true;
        }
        if (az.b(parama, parambu, 2131766902))
        {
          AppMethodBeat.o(37480);
          return true;
        }
        az.f(parama, parambu);
        if (((ap)localObject).fFf()) {
          com.tencent.mm.ui.base.h.d(parama.JOR.getContext(), parama.JOR.getContext().getString(2131764777), "", new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(37476);
              this.Kgx.fFg();
              this.Kgx.a(parambu, true, paramMenuItem.getGroupId(), 0);
              AppMethodBeat.o(37476);
            }
          });
        }
        for (;;)
        {
          com.tencent.mm.modelstat.b.inZ.V(parambu);
          AppMethodBeat.o(37480);
          return true;
          ((ap)localObject).a(parambu, true, paramMenuItem.getGroupId(), 0);
        }
        paramMenuItem = (ClipboardManager)aj.getContext().getSystemService("clipboard");
        parama = ((ap)localObject).N(parambu.field_msgId, parambu.field_imgPath);
        if (!bt.isNullOrNil(parama)) {
          paramMenuItem.setText(parama);
        }
        az.e(8, parambu);
        AppMethodBeat.o(37480);
        return true;
        paramMenuItem = new Intent(parama.JOR.getContext(), MsgRetransmitUI.class);
        localObject = ((ap)localObject).N(parambu.field_msgId, parambu.field_imgPath);
        if (parambu.frz())
        {
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          az.e(9, parambu);
          AppMethodBeat.o(37480);
          return true;
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 4);
        }
        localObject = ((ap)localObject).N(parambu.field_msgId, parambu.field_imgPath);
        paramMenuItem = new cv();
        com.tencent.mm.pluginsdk.model.g.b(paramMenuItem, (String)localObject, 1);
        paramMenuItem.dnG.fragment = parama.JOR;
        paramMenuItem.dnG.dnM = 43;
        if (paramMenuItem.dnG.dnI != null)
        {
          parama = paramMenuItem.dnG.dnI.Gjv;
          if (parama != null)
          {
            parama.aPf(u.aAm());
            parama.aPg(parambu.field_talker);
            com.tencent.mm.sdk.b.a.IbL.l(paramMenuItem);
          }
        }
        for (;;)
        {
          az.e(10, parambu);
          AppMethodBeat.o(37480);
          return true;
          ad.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
        }
        ((as)parama.bh(as.class)).bW(parambu);
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bu parambu)
    {
      int k = 0;
      AppMethodBeat.i(194508);
      ba.aBQ();
      Object localObject;
      int m;
      ap localap;
      int i;
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        localObject = (ChattingItemTranslate.a)paramView.getTag();
        m = ((ChattingItemTranslate.a)localObject).position;
        if (((ChattingItemTranslate.a)localObject).oIb == 1)
        {
          localObject = new p(parambu.field_content);
          if (((((p)localObject).time != 0L) || (parambu.field_isSend != 0)) && ((parambu.field_status != 1) || (parambu.field_isSend != 1)))
          {
            if (((as)this.JBI.bh(as.class)).fFm()) {
              paraml.a(m, 120, paramView.getContext().getString(2131757073), 2131690499);
            }
          }
          else
          {
            if (parambu.field_status == 5) {
              paraml.a(m, 103, paramView.getContext().getString(2131757286), 2131690467);
            }
            if (com.tencent.mm.bs.d.aIu("favorite")) {
              paraml.a(m, 116, paramView.getContext().getString(2131761941), 2131690400);
            }
            if ((!parambu.fpd()) && (parambu.fph()) && ((parambu.field_status == 2) || (parambu.fku == 1)) && (b(parambu, this.JBI)) && (aWy(parambu.field_talker))) {
              paraml.a(m, 123, paramView.getContext().getString(2131757234), 2131690462);
            }
            localap = (ap)this.JBI.bh(ap.class);
            if (!az.d(parambu, this.JBI)) {
              break label512;
            }
            if (!bt.isNullOrNil(localap.N(parambu.field_msgId, parambu.field_imgPath))) {
              break label727;
            }
            i = 2131757243;
          }
        }
      }
      for (;;)
      {
        int j = k;
        if (w.zE(parambu.field_talker))
        {
          j = k;
          if (ac.fko())
          {
            j = k;
            if (i != -1)
            {
              paraml.a(m, 121, paramView.getContext().getString(2131757243), 2131690490);
              j = 1;
            }
          }
        }
        if (((((p)localObject).time != 0L) || (parambu.field_isSend != 0)) && ((parambu.field_status != 1) || (parambu.field_isSend != 1)) && (!this.JBI.fFw())) {
          paraml.a(m, 100, paramView.getContext().getString(2131757223), 2131690384);
        }
        if ((j == 0) && (ac.fko()) && (i != -1)) {
          paraml.a(m, 121, paramView.getContext().getString(i), 2131690490);
        }
        AppMethodBeat.o(194508);
        return true;
        paraml.a(m, 119, paramView.getContext().getString(2131757072), 2131690395);
        break;
        label512:
        if (!localap.Ea(parambu.field_msgId))
        {
          i = 2131757243;
          continue;
          if (((ChattingItemTranslate.a)localObject).oIb == 2)
          {
            localObject = (ap)this.JBI.bh(ap.class);
            if (((ap)localObject).DZ(parambu.field_msgId) == ChattingItemTranslate.b.Kgf) {
              paraml.add(m, 121, 0, 2131757239);
            }
            for (;;)
            {
              AppMethodBeat.o(194508);
              return false;
              if (!bt.isNullOrNil(((ap)localObject).N(parambu.field_msgId, parambu.field_imgPath)))
              {
                paraml.a(m, 141, paramView.getContext().getString(2131757218), 2131690381);
                paraml.a(m, 142, paramView.getContext().getString(2131762559), 2131690478);
                if (com.tencent.mm.bs.d.aIu("favorite")) {
                  paraml.a(m, 143, paramView.getContext().getString(2131761941), 2131690400);
                }
              }
              paraml.a(m, 121, paramView.getContext().getString(2131757241), 2131690398);
            }
          }
          AppMethodBeat.o(194508);
          return true;
        }
        else
        {
          label727:
          i = -1;
        }
      }
    }
    
    public final boolean b(View paramView, final com.tencent.mm.ui.chatting.e.a parama, bu parambu)
    {
      AppMethodBeat.i(37481);
      if (parambu.field_status == 5)
      {
        ad.i("MicroMsg.ChattingItemVoice", "onItemClick msg(%s) fail", new Object[] { Long.valueOf(parambu.field_msgId) });
        AppMethodBeat.o(37481);
        return true;
      }
      if (parambu.fsi())
      {
        ((as)parama.bh(as.class)).a(parambu.field_msgId, paramView);
        if (((as)parama.bh(as.class)).Eg(parambu.field_msgId))
        {
          ad.i("MicroMsg.ChattingItemVoice", "onCreateContextMenu: voice msg show download animation");
          AppMethodBeat.o(37481);
          return true;
        }
        bu localbu = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().xY(parambu.field_msgId);
        if (localbu.fsi())
        {
          ((as)parama.bh(as.class)).Ef(localbu.field_msgId);
          o.aNA().run();
          com.tencent.e.h.LTJ.aP(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(194507);
              parama.bOo();
              AppMethodBeat.o(194507);
            }
          });
          ad.i("MicroMsg.ChattingItemVoice", "onItemClick voice msg(%s) no finish download!", new Object[] { Long.valueOf(parambu.field_msgId) });
          AppMethodBeat.o(37481);
          return true;
        }
      }
      ((as)parama.bh(as.class)).fFn();
      paramView = (bk)paramView.getTag();
      com.tencent.mm.modelstat.b.inZ.U(paramView.dBd);
      az.b(parama, paramView);
      ((ap)parama.bh(ap.class)).ado(2);
      ((com.tencent.mm.ui.chatting.d.b.aq)parama.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).fFj();
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).ZT(parambu.field_talker);
      AppMethodBeat.o(37481);
      return true;
    }
    
    public final boolean bi(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 34);
    }
    
    public final boolean fHh()
    {
      return true;
    }
  }
  
  public static final class c
    extends c.a
  {
    ImageView JZD;
    TextView JZp;
    ViewStub Kcc;
    ChattingItemTranslate Kcd;
    TextView KeJ;
    TextView KgA;
    TextView KgB;
    AnimImageView KgC;
    FrameLayout KgD;
    FrameLayout KgE;
    ImageView KgF;
    ProgressBar KgG;
    AnimImageView KgH;
    ProgressBar KgI;
    TextView KgJ;
    ImageView KgK;
    Animation KgL;
    int Kgz;
    
    private static int JH(int paramInt)
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
      paramc.JYs.setVisibility(paramInt2);
      paramc.KeJ.setVisibility(paramInt2);
      paramc.KgD.setVisibility(paramInt2);
      if (paramBoolean)
      {
        paramc.KgH.setVisibility(paramInt1);
        paramc.JZp.setVisibility(paramInt2);
        AppMethodBeat.o(37487);
        return;
      }
      if (paramc.KgJ != null) {
        paramc.KgJ.setVisibility(paramInt1);
      }
      AppMethodBeat.o(37487);
    }
    
    public static void a(c paramc, bu parambu, int paramInt, com.tencent.mm.ui.chatting.e.a parama, boolean paramBoolean, View.OnLongClickListener paramOnLongClickListener)
    {
      AppMethodBeat.i(194509);
      if (paramc == null)
      {
        AppMethodBeat.o(194509);
        return;
      }
      Object localObject = new p(parambu.field_content);
      float f1 = s.sv(((p)localObject).time);
      com.tencent.mm.ui.chatting.d locald = ((as)parama.bh(as.class)).fFk();
      label148:
      label296:
      float f2;
      if ((locald != null) && (parambu.field_msgId == locald.Jyn))
      {
        paramc.KgC.setVisibility(0);
        paramc.KgC.bzc();
        if (!((as)parama.bh(as.class)).Eg(parambu.field_msgId)) {
          break label602;
        }
        ad.d("MicroMsg.ChattingItemVoice", "startDownloadAnim");
        if (paramc.KgG != null)
        {
          paramc.KgG.setVisibility(0);
          if (paramc.KgB != null) {
            paramc.KgB.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          }
        }
        if (parambu.field_isSend != 0) {
          break label1082;
        }
        if (parambu.field_status != 5) {
          break label693;
        }
        a(paramc, 8, 0, true);
        paramc.KgH.cfx();
        paramc.KgH.setVisibility(8);
        paramc.KeJ.setVisibility(0);
        paramc.Kgz = com.tencent.mm.cc.a.fromDPToPix(parama.JOR.getContext(), JH((int)f1));
        paramc.KgB.setWidth(paramc.Kgz);
        paramc.KeJ.setText(parama.JOR.getMMResources().getString(2131759570, new Object[] { Integer.valueOf((int)f1) }));
        paramc.KgC.setWidth(com.tencent.mm.cc.a.fromDPToPix(parama.JOR.getContext(), JH((int)f1)));
        if (paramc.KgK == null) {
          break label1082;
        }
        paramc.KgK.setVisibility(0);
        f2 = f1;
        if (1 != parambu.field_isSend) {
          break label1516;
        }
        if (parambu.field_status != 1) {
          break label1085;
        }
        a(paramc, 0, 8, false);
        paramc.KgE.setVisibility(8);
        paramc.fHw();
        label337:
        localObject = ((com.tencent.mm.ui.chatting.d.b.c)parama.bh(com.tencent.mm.ui.chatting.d.b.c.class)).fDj();
        if (localObject != null)
        {
          if (!((com.tencent.mm.pluginsdk.ui.f)localObject).ESj) {
            break label1523;
          }
          paramc.KeJ.setShadowLayer(2.0F, 1.2F, 1.2F, ((com.tencent.mm.pluginsdk.ui.f)localObject).ESk);
          label383:
          if (!((com.tencent.mm.pluginsdk.ui.f)localObject).ESl) {
            break label1537;
          }
          paramc.KeJ.setBackgroundResource(2131231724);
        }
        label400:
        localObject = new ChattingItemTranslate.a(parambu, parama.fFv(), paramInt);
        paramc.KgB.setTag(localObject);
        paramc.KgB.setOnClickListener(paramc.JYv.d(parama));
        paramc.KgB.setOnLongClickListener(paramOnLongClickListener);
        paramc.KgB.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fCu());
        if ((parambu.eLr & 0x1) != 1) {
          break label1571;
        }
        paramc.KgA.setVisibility(0);
        if (parambu.field_isSend != 0) {
          break label1548;
        }
        paramc.KgC.setBackgroundResource(2131231624);
        label505:
        if (!paramBoolean) {
          break label1623;
        }
        parama.getTalkerUserName();
      }
      for (;;)
      {
        parambu = ((com.tencent.mm.ui.chatting.d.b.f)parama.bh(com.tencent.mm.ui.chatting.d.b.f.class)).aWa(parama.getTalkerUserName());
        parama = a.a.fyf();
        paramOnLongClickListener = paramc.KgB;
        paramInt = (int)f1;
        if (parambu != null) {
          parambu.toString();
        }
        parama.aA(paramOnLongClickListener, paramInt);
        paramc.KeJ.setContentDescription(" ");
        AppMethodBeat.o(194509);
        return;
        paramc.KgC.setVisibility(8);
        paramc.KgC.cfx();
        break;
        label602:
        ad.d("MicroMsg.ChattingItemVoice", "stopDownloadAnim");
        if (paramc.KgG == null) {
          break label148;
        }
        paramc.KgG.setVisibility(8);
        if (paramc.KgB == null) {
          break label148;
        }
        if (paramBoolean)
        {
          paramc.KgB.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.ui.aq.aM(paramc.KgB.getContext(), 2130968740), null, null, null);
          break label148;
        }
        paramc.KgB.setCompoundDrawablesWithIntrinsicBounds(null, null, paramc.KgB.getContext().getResources().getDrawable(2131689927), null);
        break label148;
        label693:
        if (((p)localObject).time == 0L)
        {
          a(paramc, 8, 0, true);
          paramc.KgH.cfx();
          paramc.KgH.setVisibility(8);
          paramc.JYs.setVisibility(8);
          f2 = 0.0F;
          paramc.Kgz = com.tencent.mm.cc.a.fromDPToPix(parama.JOR.getContext(), JH(0));
          paramc.KgB.setWidth(paramc.Kgz);
          paramc.KeJ.setText(parama.JOR.getMMResources().getString(2131759570, new Object[] { Integer.valueOf(0) }));
          paramc.KgC.setWidth(com.tencent.mm.cc.a.fromDPToPix(parama.JOR.getContext(), JH(0)));
          f1 = f2;
          if (paramc.KgK == null) {
            break label296;
          }
          paramc.KgK.setVisibility(8);
          f1 = f2;
          break label296;
        }
        if (((p)localObject).time == -1L)
        {
          a(paramc, 8, 0, true);
          paramc.KgH.cfx();
          paramc.KgH.setVisibility(8);
          paramc.Kgz = 80;
          paramc.KgB.setWidth(80);
          paramc.KeJ.setVisibility(8);
          paramc.KgC.setWidth(com.tencent.mm.cc.a.fromDPToPix(parama.JOR.getContext(), JH((int)f1)));
          if (paramc.KgK == null) {
            break label1082;
          }
          paramc.KgK.setVisibility(8);
          break label296;
        }
        a(paramc, 8, 0, true);
        paramc.KgH.cfx();
        paramc.KgH.setVisibility(8);
        paramc.KeJ.setVisibility(0);
        paramc.Kgz = com.tencent.mm.cc.a.fromDPToPix(parama.JOR.getContext(), JH((int)f1));
        paramc.KgB.setWidth(paramc.Kgz);
        paramc.KeJ.setText(parama.JOR.getMMResources().getString(2131759570, new Object[] { Integer.valueOf((int)f1) }));
        paramc.KgC.setWidth(com.tencent.mm.cc.a.fromDPToPix(parama.JOR.getContext(), JH((int)f1)));
        if (paramc.KgK != null) {
          paramc.KgK.setVisibility(8);
        }
        label1082:
        break label296;
        label1085:
        if (parambu.field_status == 5)
        {
          a(paramc, 8, 0, false);
          paramc.KgE.setVisibility(8);
          paramc.KeJ.setVisibility(0);
          paramc.fHw();
          if (((p)localObject).time == 0L) {
            f1 = 0.0F;
          }
          paramc.Kgz = com.tencent.mm.cc.a.fromDPToPix(parama.JOR.getContext(), JH((int)f1));
          paramc.KgB.setWidth(paramc.Kgz);
          paramc.KeJ.setText(parama.JOR.getMMResources().getString(2131759570, new Object[] { Integer.valueOf((int)f1) }));
          paramc.KgC.setWidth(com.tencent.mm.cc.a.fromDPToPix(parama.JOR.getContext(), JH((int)f1)));
          break label337;
        }
        if (((p)localObject).time == -1L)
        {
          a(paramc, 8, 0, false);
          paramc.KgB.setWidth(80);
          paramc.Kgz = 80;
          paramc.KeJ.setVisibility(8);
          paramc.KgE.setVisibility(8);
          paramc.KgC.setWidth(com.tencent.mm.cc.a.fromDPToPix(parama.JOR.getContext(), JH((int)f1)));
          paramc.fHw();
          break label337;
        }
        if (parambu.field_status == 7)
        {
          a(paramc, 8, 8, false);
          paramc.KeJ.setVisibility(8);
          paramc.KgE.setVisibility(0);
          paramc.fHw();
          if (paramc.KgF != null)
          {
            paramc.KgL = AnimationUtils.loadAnimation(paramc.tPw.getContext(), 2130772168);
            paramc.KgF.startAnimation(paramc.KgL);
          }
          break label337;
        }
        a(paramc, 8, 0, false);
        paramc.KgE.setVisibility(8);
        paramc.KeJ.setVisibility(0);
        paramc.fHw();
        if (((p)localObject).time == 0L) {
          f1 = 0.0F;
        }
        paramc.Kgz = com.tencent.mm.cc.a.fromDPToPix(parama.JOR.getContext(), JH((int)f1));
        paramc.KgB.setWidth(paramc.Kgz);
        paramc.KeJ.setText(parama.JOR.getMMResources().getString(2131759570, new Object[] { Integer.valueOf((int)f1) }));
        paramc.KgC.setWidth(com.tencent.mm.cc.a.fromDPToPix(parama.JOR.getContext(), JH((int)f1)));
        f2 = f1;
        label1516:
        f1 = f2;
        break label337;
        label1523:
        paramc.KeJ.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        break label383;
        label1537:
        paramc.KeJ.setBackgroundColor(0);
        break label400;
        label1548:
        paramc.KgJ.setBackgroundResource(2131231734);
        paramc.KgC.setBackgroundResource(2131231734);
        break label505;
        label1571:
        paramc.KgA.setVisibility(8);
        if (parambu.field_isSend == 0)
        {
          paramc.KgC.setBackgroundResource(2131231606);
          break label505;
        }
        paramc.KgJ.setBackgroundResource(2131231725);
        paramc.KgC.setBackgroundResource(2131231725);
        break label505;
        label1623:
        parama.fFr();
      }
    }
    
    static void f(Context paramContext, CharSequence paramCharSequence)
    {
      AppMethodBeat.i(37485);
      Intent localIntent = new Intent(paramContext, TextPreviewUI.class);
      localIntent.putExtra("key_chat_text", paramCharSequence);
      paramCharSequence = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramCharSequence.ahp(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$VoiceItemHolder", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramCharSequence.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$VoiceItemHolder", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.kd(paramContext);
      AppMethodBeat.o(37485);
    }
    
    private void fHw()
    {
      AppMethodBeat.i(37486);
      if (this.KgL != null)
      {
        this.KgL.cancel();
        this.KgL = null;
      }
      AppMethodBeat.o(37486);
    }
    
    public final c.a d(View paramView, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(37483);
      super.gn(paramView);
      this.fTP = ((TextView)paramView.findViewById(2131298178));
      this.yEk = ((TextView)paramView.findViewById(2131298185));
      this.KgB = ((TextView)paramView.findViewById(2131298197));
      this.iCK = ((CheckBox)paramView.findViewById(2131298068));
      this.gZU = paramView.findViewById(2131298147);
      this.JYs = ((ImageView)paramView.findViewById(2131298174));
      this.KeJ = ((TextView)paramView.findViewById(2131298073));
      this.KgD = ((FrameLayout)paramView.findViewById(2131298198));
      this.KgG = ((ProgressBar)paramView.findViewById(2131308259));
      this.Kcc = ((ViewStub)paramView.findViewById(2131306075));
      this.KgA = ((TextView)paramView.findViewById(2131298195));
      this.KgC = ((AnimImageView)paramView.findViewById(2131298194));
      this.KgC.setType(1);
      if (paramBoolean1)
      {
        this.KgC.setFromVoice(true);
        this.KgC.setFromGroup(paramBoolean2);
        this.JZp = ((TextView)paramView.findViewById(2131298023));
        this.KgH = ((AnimImageView)paramView.findViewById(2131298196));
        this.KgH.setFromVoice(true);
        this.KgH.setFromGroup(paramBoolean2);
        this.KgH.setType(0);
        this.KgK = ((ImageView)paramView.findViewById(2131308256));
      }
      for (;;)
      {
        AppMethodBeat.o(37483);
        return this;
        this.KgE = ((FrameLayout)paramView.findViewById(2131298205));
        this.KgF = ((ImageView)paramView.findViewById(2131298206));
        this.KgI = ((ProgressBar)paramView.findViewById(2131298207));
        this.xfR = ((ProgressBar)paramView.findViewById(2131306220));
        this.KgJ = ((TextView)paramView.findViewById(2131298208));
        this.KgC.setFromVoice(false);
        this.KgC.setFromGroup(paramBoolean2);
        this.JZD = ((ImageView)paramView.findViewById(2131298176));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.az
 * JD-Core Version:    0.7.0.1
 */