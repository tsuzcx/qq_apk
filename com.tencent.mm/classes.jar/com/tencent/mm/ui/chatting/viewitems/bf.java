package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.a;
import com.tencent.mm.g.a.gi;
import com.tencent.mm.g.b.a.gn;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelstat.b.b;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.b.au;
import com.tencent.mm.ui.chatting.d.b.aw;
import com.tencent.mm.ui.chatting.d.bi;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class bf
{
  private static boolean a(final int paramInt, com.tencent.mm.ui.chatting.e.a parama, final ca paramca, final com.tencent.mm.ui.chatting.d.b.at paramat, boolean paramBoolean)
  {
    AppMethodBeat.i(233966);
    if (a(parama, paramca, 2131757272))
    {
      AppMethodBeat.o(233966);
      return true;
    }
    if (b(parama, paramca, 2131757270))
    {
      AppMethodBeat.o(233966);
      return true;
    }
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(37465);
        Object localObject = this.PHb;
        ca localca = paramca;
        com.tencent.mm.ui.chatting.d.b.at localat = (com.tencent.mm.ui.chatting.d.b.at)((com.tencent.mm.ui.chatting.e.a)localObject).bh(com.tencent.mm.ui.chatting.d.b.at.class);
        if ((localObject == null) || (localat == null))
        {
          Log.e("MicroMsg.ChattingItemVoice", "alvinluo ui or ui.transformImp null");
          AppMethodBeat.o(37465);
          return;
        }
        int i;
        if (localat.NH(localca.field_msgId)) {
          i = 2;
        }
        for (;;)
        {
          Log.i("MicroMsg.ChattingItemVoice", "alvinluo TransformText report clickScene: %d, msgId: %d", new Object[] { Integer.valueOf(i), Long.valueOf(localca.field_msgId) });
          localObject = new gi();
          ((gi)localObject).dKe.dKf = 1;
          ((gi)localObject).dKe.scene = i;
          ((gi)localObject).dKe.fileName = localca.field_imgPath;
          EventCenter.instance.publish((IEvent)localObject);
          AppMethodBeat.o(37465);
          return;
          if (localat.NC(localca.field_msgId)) {
            i = 3;
          } else if (!Util.isNullOrNil(localat.S(localca.field_msgId, localca.field_imgPath))) {
            i = 5;
          } else {
            i = 1;
          }
        }
      }
    }, "voice_transform_text_report");
    if (paramat.gRs()) {
      com.tencent.mm.ui.base.h.d(parama.Pwc.getContext(), parama.Pwc.getContext().getString(2131767214), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(233950);
          if (this.yVS) {
            s.ak(paramca);
          }
          paramat.gRt();
          paramat.a(paramca, true, paramInt, 0);
          AppMethodBeat.o(233950);
        }
      });
    }
    for (;;)
    {
      parama = com.tencent.mm.modelstat.b.jmd;
      if (parama.bfZ()) {
        parama.a(paramca, b.b.jms, 0);
      }
      AppMethodBeat.o(233966);
      return true;
      if (paramBoolean) {
        s.ak(paramca);
      }
      paramat.a(paramca, true, paramInt, 0);
    }
  }
  
  public static boolean a(com.tencent.mm.ui.chatting.e.a parama, ca paramca, int paramInt)
  {
    AppMethodBeat.i(233964);
    if (paramca == null)
    {
      AppMethodBeat.o(233964);
      return false;
    }
    boolean bool1;
    if (paramca.gDP()) {
      if (((aw)parama.bh(aw.class)).NK(paramca.field_msgId))
      {
        Log.i("MicroMsg.ChattingItemVoice", "onCreateContextMenu: voice msg is downloading.(1)");
        bool1 = true;
        bool2 = bool1;
        if (bool1)
        {
          Log.i("MicroMsg.ChattingItemVoice", "handleNoFinishDownloadVoiceMsg show alert!");
          com.tencent.mm.ui.base.h.a(parama.Pwc.getContext(), parama.Pwc.getContext().getString(paramInt), "", parama.Pwc.getContext().getString(2131768713), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = false)
    {
      AppMethodBeat.o(233964);
      return bool2;
      if (((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(paramca.field_msgId).gDP())
      {
        Log.i("MicroMsg.ChattingItemVoice", "onCreateContextMenu: voice msg is downloading.(2)");
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
    }
  }
  
  public static void b(com.tencent.mm.ui.chatting.e.a parama, bq parambq)
  {
    AppMethodBeat.i(37488);
    if ((com.tencent.mm.q.a.cC(parama.Pwc.getContext())) || (com.tencent.mm.q.a.cA(parama.Pwc.getContext())) || (com.tencent.mm.q.a.cE(parama.Pwc.getContext())))
    {
      Log.d("MicroMsg.ChattingItemVoice", "voip is running, not play voice");
      AppMethodBeat.o(37488);
      return;
    }
    bg.aVF();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      u.g(parama.Pwc.getContext(), parama.Pwc.getContentView());
      AppMethodBeat.o(37488);
      return;
    }
    Object localObject;
    ca localca;
    int i;
    if ((parambq != null) && (parambq.dTX != null))
    {
      localObject = new p(parambq.dTX.field_content);
      if ((af.isNullOrNil(parambq.dTX.field_content)) || (((p)localObject).time == 0L))
      {
        Toast.makeText(parama.Pwc.getContext(), 2131757355, 0).show();
        AppMethodBeat.o(37488);
        return;
      }
      localObject = ((aw)parama.bh(aw.class)).gRx();
      if ((parama.bh(com.tencent.mm.ui.chatting.d.b.k.class) != null) && (localObject != null))
      {
        localca = parambq.dTX;
        if (((aw)parama.bh(aw.class)).gRx().Pei != localca.field_msgId)
        {
          parama = (com.tencent.mm.ui.chatting.d.b.at)parama.bh(com.tencent.mm.ui.chatting.d.b.at.class);
          if (!parama.NH(localca.field_msgId)) {
            break label323;
          }
          i = 7;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        parama = new gi();
        parama.dKe.dKf = 1;
        parama.dKe.scene = i;
        parama.dKe.fileName = localca.field_imgPath;
        EventCenter.instance.publish(parama);
      }
      i = parambq.position;
      parama = parambq.dTX;
      if ((parama == null) || (!parama.gAy()))
      {
        AppMethodBeat.o(37488);
        return;
        label323:
        if (parama.NC(localca.field_msgId)) {
          i = 6;
        }
      }
      else
      {
        parambq = new p(parama.field_content);
        if (((parambq.time == 0L) && (parama.field_isSend == 0)) || ((parama.field_status == 1) && (parama.field_isSend == 1)))
        {
          AppMethodBeat.o(37488);
          return;
        }
        if ((parama.field_isSend != 0) || (parambq.time != -1L))
        {
          ((d)localObject).gMO();
          bg.aVF();
          parambq = (Boolean)com.tencent.mm.model.c.azQ().get(4115, null);
          if ((parambq == null) || (!parambq.booleanValue()))
          {
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(4115, Boolean.TRUE);
            ((d)localObject).gMU();
            ((d)localObject).Pel = u.a(((d)localObject).dom.Pwc.getActivity(), ((d)localObject).context.getString(2131757468), 4000L);
          }
          if ((((d)localObject).qUl.isPlaying()) && (parama.field_msgId == ((d)localObject).Pei))
          {
            ((d)localObject).Per = true;
            ((d)localObject).gMT();
            AppMethodBeat.o(37488);
            return;
          }
          ((d)localObject).bf(parama);
          if ((parama.field_isSend == 0) && (!s.ai(parama))) {
            ((d)localObject).ama(i + 1);
          }
          ((d)localObject).BK(true);
        }
        AppMethodBeat.o(37488);
        return;
      }
      i = 0;
    }
  }
  
  public static boolean b(com.tencent.mm.ui.chatting.e.a parama, ca paramca, int paramInt)
  {
    AppMethodBeat.i(233965);
    if ((paramca != null) && (paramca.gAy()) && (paramca.field_isSend != 1) && (paramca.field_status == 5))
    {
      Log.i("MicroMsg.ChattingItemVoice", "handleDownloadFailVoiceMsg show alert!");
      com.tencent.mm.ui.base.h.a(parama.Pwc.getContext(), parama.Pwc.getContext().getString(paramInt), "", parama.Pwc.getContext().getString(2131768713), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(233965);
      return true;
    }
    AppMethodBeat.o(233965);
    return false;
  }
  
  public static final class a
    extends c
    implements t.n
  {
    private View.OnClickListener PPE;
    private com.tencent.mm.ui.chatting.e.a PhN;
    
    public static void aW(int paramInt, long paramLong)
    {
      AppMethodBeat.i(233957);
      if (!bi.gRD())
      {
        AppMethodBeat.o(233957);
        return;
      }
      gn localgn = new gn();
      localgn.eJR = paramInt;
      localgn.up(String.valueOf(paramLong));
      Log.d("MicroMsg.ChattingItemVoice", "%s", new Object[] { localgn.abW() });
      localgn.bfK();
      AppMethodBeat.o(233957);
    }
    
    public static void f(int paramInt, ca paramca)
    {
      AppMethodBeat.i(233956);
      if (paramca == null)
      {
        Log.i("MicroMsg.ChattingItemVoice", "msgInfo is null???");
        AppMethodBeat.o(233956);
        return;
      }
      aW(paramInt, paramca.field_msgId);
      AppMethodBeat.o(233956);
    }
    
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
        localObject = new an(paramLayoutInflater, 2131493563);
        ((View)localObject).setTag(new bf.c().e((View)localObject, true, this.Pdm));
      }
      AppMethodBeat.o(37469);
      return localObject;
    }
    
    public final void a(final c.a parama, final int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, String paramString)
    {
      AppMethodBeat.i(37471);
      this.PhN = parama1;
      bf.c localc = (bf.c)parama;
      localc.PPL.setFromVoice(true);
      localc.PPL.setFromGroup(parama1.gRM());
      com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class);
      b(localk, paramca.field_msgId);
      bf.c.a(this, localc, paramca, paramInt, parama1, true, c(parama1), this);
      parama = null;
      paramString = ChattingItemTranslate.c.PPm;
      final com.tencent.mm.ui.chatting.d.b.at localat = (com.tencent.mm.ui.chatting.d.b.at)parama1.bh(com.tencent.mm.ui.chatting.d.b.at.class);
      Object localObject;
      if (bf.d(paramca, parama1))
      {
        localObject = localat.S(paramca.field_msgId, paramca.field_imgPath);
        parama = (c.a)localObject;
        if (Util.isNullOrNil((String)localObject)) {
          break label1049;
        }
        paramString = ChattingItemTranslate.c.PPp;
        parama = (c.a)localObject;
      }
      label643:
      label1049:
      for (;;)
      {
        int i;
        if ((!Util.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.c.PPm))
        {
          if (localc.PKI == null)
          {
            localc.PKI = ((ChattingItemTranslate)localc.PKH.inflate());
            localc.PKI.setMinimumWidth(localc.PPI - com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 5));
            localc.PKI.init();
          }
          Context localContext = localc.PNK.getContext();
          i = (int)localc.PKI.getContentView().getTextSize();
          if (paramca != null)
          {
            localObject = ad.JX(paramca.field_msgSvrId);
            ad.b localb = ad.aVe().G((String)localObject, true);
            localb.l("prePublishId", "msg_" + paramca.field_msgSvrId);
            localb.l("preUsername", a(this.PhN, paramca));
            localb.l("preChatName", b(this.PhN, paramca));
            label339:
            localObject = com.tencent.mm.pluginsdk.ui.span.l.a(localContext, parama, i, 1, null, (String)localObject);
            localc.PKI.a((CharSequence)localObject, paramString, localat.NF(paramca.field_msgId), ChattingItemTranslate.b.PPk, paramca.field_msgId, parama1);
            if ((!Util.isNullOrNil((CharSequence)localObject)) && (localat.NF(paramca.field_msgId))) {
              localat.NG(paramca.field_msgId);
            }
            paramString = new ChattingItemTranslate.a(paramca, parama1.gRM(), paramInt);
            paramString.qcr = 2;
            localc.PKI.setTag(paramString);
            paramString = localc.PKI;
            if (this.PPE == null) {
              this.PPE = new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(233953);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  paramAnonymousView = (ChattingItemTranslate.a)((ChattingItemTranslate)paramAnonymousView).getTag();
                  if (((com.tencent.mm.ui.chatting.d.b.at)bf.a.a(bf.a.this).bh(com.tencent.mm.ui.chatting.d.b.at.class)).NB(paramAnonymousView.dTX.field_msgId) == ChattingItemTranslate.c.PPo) {
                    ((com.tencent.mm.ui.chatting.d.b.at)bf.a.a(bf.a.this).bh(com.tencent.mm.ui.chatting.d.b.at.class)).a(paramAnonymousView.dTX, true, paramAnonymousView.position, 1);
                  }
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(233953);
                }
              };
            }
            paramString.setOnClickListener(this.PPE);
            localc.PKI.setOnLongClickListener(c(parama1));
            localc.PKI.setVisibility(0);
            if (!Util.isNullOrNil(parama))
            {
              localc.PKI.setOnTouchListener(localk.gOC());
              localc.PKI.setOnDoubleClickListener(new NeatTextView.b()
              {
                public final boolean gS(View paramAnonymousView)
                {
                  AppMethodBeat.i(37466);
                  bf.c.a(MMApplicationContext.getContext(), parama, parama1);
                  bf.cQ(paramca);
                  AppMethodBeat.o(37466);
                  return true;
                }
              });
            }
            label552:
            if ((com.tencent.mm.ui.ao.isDarkMode()) || (!((com.tencent.mm.ui.chatting.d.b.c)parama1.bh(com.tencent.mm.ui.chatting.d.b.c.class)).gPs())) {
              break label807;
            }
            localc.PPV.setBackgroundResource(2131235461);
            label587:
            localc.PPV.setTextSize(0, com.tencent.mm.cb.a.aH(parama1.Pwc.getContext(), 2131165289));
            if (((aw)parama1.bh(aw.class)).NN(paramca.field_msgId)) {
              break label821;
            }
            localc.PPU.setVisibility(8);
            localc.PPU.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(233951);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                Log.i("MicroMsg.ChattingItemVoice", "voice fast trans text click");
                bf.b(paramInt, parama1, paramca, localat, true);
                bf.a.f(2, paramca);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(233951);
              }
            });
            parama = new p(paramca.field_content);
            if (parama.time != 0L) {
              break label833;
            }
            localc.stateIV.setVisibility(8);
          }
        }
        for (;;)
        {
          parama = paramca.fQR;
          if ((parama != null) && (parama.length() != 0)) {
            break label1020;
          }
          localc.PHZ.setVisibility(8);
          AppMethodBeat.o(37471);
          return;
          if (!localat.NC(paramca.field_msgId)) {
            break label1049;
          }
          parama = localat.S(paramca.field_msgId, paramca.field_imgPath);
          paramString = localat.NB(paramca.field_msgId);
          break;
          localObject = null;
          break label339;
          if (localc.PKI == null) {
            break label552;
          }
          localc.PKI.setVisibility(8);
          break label552;
          label807:
          localc.PPV.setBackgroundResource(2131235458);
          break label587;
          label821:
          localc.PPU.setVisibility(0);
          break label643;
          label833:
          paramString = ((aw)parama1.bh(aw.class)).gRx();
          if (((paramString != null) && (paramString.Pei == paramca.field_msgId)) || (s.ai(paramca)))
          {
            paramInt = 1;
            label879:
            paramString = localc.stateIV;
            if (paramInt == 0) {
              break label959;
            }
          }
          label959:
          for (i = 8;; i = 0)
          {
            paramString.setVisibility(i);
            i = (int)s.AO(parama.time);
            if (paramInt != 0) {
              break label965;
            }
            localc.PPK.setContentDescription(String.format(parama1.Pwc.getContext().getString(2131767169), new Object[] { Integer.valueOf(i) }));
            break;
            paramInt = 0;
            break label879;
          }
          label965:
          parama = ((com.tencent.mm.ui.chatting.d.b.f)parama1.bh(com.tencent.mm.ui.chatting.d.b.f.class)).bmF(parama1.getTalkerUserName());
          paramString = a.a.gKe();
          localObject = localc.PPK;
          if (parama != null) {
            parama.toString();
          }
          paramString.aF((View)localObject, i);
        }
        label1020:
        localc.PHZ.setVisibility(0);
        b(parama1, localc.PHZ, bq.bnn(parama));
        AppMethodBeat.o(37471);
        return;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37473);
      Object localObject = (com.tencent.mm.ui.chatting.d.b.at)parama.bh(com.tencent.mm.ui.chatting.d.b.at.class);
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(37473);
        return false;
        ((aw)parama.bh(aw.class)).BV(true);
        AppMethodBeat.o(37473);
        return true;
        ((aw)parama.bh(aw.class)).BV(false);
        AppMethodBeat.o(37473);
        return true;
        if (!WeChatBrands.Business.Entries.SessionSpeech2TextSnd.checkAvailable(parama.Pwc.getContext()))
        {
          AppMethodBeat.o(37473);
          return true;
        }
        f(3, paramca);
        boolean bool = bf.b(paramMenuItem.getGroupId(), parama, paramca, (com.tencent.mm.ui.chatting.d.b.at)localObject, true);
        AppMethodBeat.o(37473);
        return bool;
        paramMenuItem = ((com.tencent.mm.ui.chatting.d.b.at)localObject).S(paramca.field_msgId, paramca.field_imgPath);
        if (!Util.isNullOrNil(paramMenuItem)) {
          ClipboardHelper.setText(paramMenuItem);
        }
        bf.e(8, paramca);
        continue;
        paramMenuItem = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
        localObject = ((com.tencent.mm.ui.chatting.d.b.at)localObject).S(paramca.field_msgId, paramca.field_imgPath);
        if (paramca.gDg())
        {
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          bf.e(9, paramca);
          break;
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 4);
        }
        localObject = ((com.tencent.mm.ui.chatting.d.b.at)localObject).S(paramca.field_msgId, paramca.field_imgPath);
        paramMenuItem = new cz();
        com.tencent.mm.pluginsdk.model.h.b(paramMenuItem, (String)localObject, 1);
        paramMenuItem.dFZ.fragment = parama.Pwc;
        paramMenuItem.dFZ.dGf = 43;
        if (paramMenuItem.dFZ.dGb != null)
        {
          parama = paramMenuItem.dFZ.dGb.Lya;
          if (parama != null)
          {
            parama.bhf(paramca.field_talker);
            parama.bhg(z.aTY());
            EventCenter.instance.publish(paramMenuItem);
          }
        }
        for (;;)
        {
          bf.e(10, paramca);
          break;
          Log.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
        }
        ((aw)parama.bh(aw.class)).cl(paramca);
        ((aw)parama.bh(aw.class)).gRB();
        continue;
        ((aw)parama.bh(aw.class)).cm(paramca);
      }
    }
    
    public final boolean a(m paramm, View paramView, ca paramca)
    {
      int k = 0;
      AppMethodBeat.i(233955);
      bg.aVF();
      Object localObject;
      int m;
      int i;
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        localObject = (ChattingItemTranslate.a)paramView.getTag();
        m = ((ChattingItemTranslate.a)localObject).position;
        if (((ChattingItemTranslate.a)localObject).qcr == 1) {
          if (((new p(paramca.field_content).time != 0L) || (paramca.field_isSend != 0)) && ((paramca.field_status != 1) || (paramca.field_isSend != 1)))
          {
            bg.aVF();
            Boolean localBoolean = (Boolean)com.tencent.mm.model.c.azQ().get(26, null);
            localObject = localBoolean;
            if (localBoolean == null) {
              localObject = Boolean.FALSE;
            }
            if (!((Boolean)localObject).booleanValue()) {
              break label473;
            }
            paramm.a(m, 120, paramView.getContext().getString(2131757274), 2131690708);
            bg.aVF();
            localObject = com.tencent.mm.model.c.aSN().Kn(paramca.field_talker);
            if ((ab.Jf(paramca.field_talker)) || (ab.JE(paramca.field_talker)) || (localObject == null) || (((as)localObject).gBM())) {
              break label498;
            }
            i = 1;
            label202:
            if (com.tencent.mm.br.c.aZU("favorite")) {
              paramm.a(m, 116, paramView.getContext().getString(2131763947), 2131690551);
            }
            if (i != 0)
            {
              if (ag.bah().sO(2) <= 0) {
                break label504;
              }
              i = 1;
              label251:
              if ((i != 0) && (!this.PhN.gRN())) {
                paramm.add(m, 114, 0, paramView.getContext().getString(2131757429));
              }
            }
            localObject = (com.tencent.mm.ui.chatting.d.b.at)this.PhN.bh(com.tencent.mm.ui.chatting.d.b.at.class);
            if (!bf.d(paramca, this.PhN)) {
              break label510;
            }
            if (!Util.isNullOrNil(((com.tencent.mm.ui.chatting.d.b.at)localObject).S(paramca.field_msgId, paramca.field_imgPath))) {
              break label725;
            }
            i = 2131757456;
          }
        }
      }
      label725:
      for (;;)
      {
        int j = k;
        if (ab.IT(paramca.field_talker))
        {
          j = k;
          if (LocaleUtil.isChineseAppLang())
          {
            j = k;
            if (i != -1)
            {
              paramm.a(m, 121, paramView.getContext().getString(i), 2131690697);
              j = 1;
            }
          }
        }
        if (!this.PhN.gRN()) {
          paramm.a(m, 100, paramView.getContext().getString(2131757435), 2131690529);
        }
        if ((j == 0) && (LocaleUtil.isChineseAppLang()) && (i != -1)) {
          paramm.a(m, 121, paramView.getContext().getString(i), 2131690697);
        }
        AppMethodBeat.o(233955);
        return true;
        label473:
        paramm.a(m, 119, paramView.getContext().getString(2131757273), 2131690544);
        break;
        label498:
        i = 0;
        break label202;
        label504:
        i = 0;
        break label251;
        label510:
        if (!((com.tencent.mm.ui.chatting.d.b.at)localObject).NC(paramca.field_msgId))
        {
          i = 2131757456;
          continue;
          if (((ChattingItemTranslate.a)localObject).qcr == 2)
          {
            localObject = (com.tencent.mm.ui.chatting.d.b.at)this.PhN.bh(com.tencent.mm.ui.chatting.d.b.at.class);
            if (((com.tencent.mm.ui.chatting.d.b.at)localObject).NB(paramca.field_msgId) == ChattingItemTranslate.c.PPo) {
              paramm.add(m, 121, 0, 2131757452);
            }
            for (;;)
            {
              AppMethodBeat.o(233955);
              return false;
              if (!Util.isNullOrNil(((com.tencent.mm.ui.chatting.d.b.at)localObject).S(paramca.field_msgId, paramca.field_imgPath)))
              {
                paramm.a(m, 141, paramView.getContext().getString(2131757430), 2131690525);
                paramm.a(m, 142, paramView.getContext().getString(2131764628), 2131690674);
                if (com.tencent.mm.br.c.aZU("favorite")) {
                  paramm.a(m, 143, paramView.getContext().getString(2131763947), 2131690551);
                }
              }
              paramm.a(m, 121, paramView.getContext().getString(2131757454), 2131690549);
            }
          }
          AppMethodBeat.o(233955);
          return true;
        }
        else
        {
          i = -1;
        }
      }
    }
    
    public final void b(View paramView, final com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(233958);
      if (paramca.field_status == 5)
      {
        paramView = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(paramca.field_msgId);
        paramView.gDQ();
        p localp = new p(paramView.field_content);
        localp.jsi = false;
        paramView.setContent(localp.bie());
        paramView.setStatus(3);
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(paramca.field_msgId, paramView);
        paramView = o.bib().AP(paramca.field_msgSvrId);
        if (paramView.iKP != 0) {
          break label222;
        }
      }
      label222:
      for (paramView.status = 5;; paramView.status = 6)
      {
        paramView.jsm = (System.currentTimeMillis() / 1000L);
        paramView.jvx = 1;
        paramView.cSx = 1048896;
        s.a(paramView);
        ((aw)parama.bh(aw.class)).NJ(paramca.field_msgId);
        o.bid().run();
        com.tencent.f.h.RTc.aV(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(233954);
            parama.cmy();
            AppMethodBeat.o(233954);
          }
        });
        Log.i("MicroMsg.ChattingItemVoice", "onStateBtnClick voice msg(%s) re-download!", new Object[] { Long.valueOf(paramca.field_msgId) });
        AppMethodBeat.o(233958);
        return;
      }
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(37470);
      boolean bool = parama.gRM();
      AppMethodBeat.o(37470);
      return bool;
    }
    
    public final boolean bM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 34);
    }
    
    public final boolean c(View paramView, final com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37474);
      if (paramca.field_status == 5)
      {
        Log.i("MicroMsg.ChattingItemVoice", "onItemClick msg(%s) fail", new Object[] { Long.valueOf(paramca.field_msgId) });
        AppMethodBeat.o(37474);
        return true;
      }
      if (paramca.gDP())
      {
        ((aw)parama.bh(aw.class)).a(paramca.field_msgId, paramView);
        if (((aw)parama.bh(aw.class)).NK(paramca.field_msgId))
        {
          Log.i("MicroMsg.ChattingItemVoice", "onItemClick: voice msg show download animation");
          AppMethodBeat.o(37474);
          return true;
        }
        ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(paramca.field_msgId);
        if (localca.gDP())
        {
          ((aw)parama.bh(aw.class)).NJ(localca.field_msgId);
          o.bid().run();
          com.tencent.f.h.RTc.aV(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(233952);
              parama.cmy();
              AppMethodBeat.o(233952);
            }
          });
          Log.i("MicroMsg.ChattingItemVoice", "onItemClick voice msg(%s) no finish download!", new Object[] { Long.valueOf(paramca.field_msgId) });
          AppMethodBeat.o(37474);
          return true;
        }
      }
      ((aw)parama.bh(aw.class)).NL(paramca.field_msgId);
      ((aw)parama.bh(aw.class)).gRA();
      paramView = (bq)paramView.getTag();
      com.tencent.mm.modelstat.b.jmd.ae(paramView.dTX);
      bf.b(parama, paramView);
      ((com.tencent.mm.ui.chatting.d.b.at)parama.bh(com.tencent.mm.ui.chatting.d.b.at.class)).amG(2);
      ((au)parama.bh(au.class)).gRw();
      c(parama, paramca);
      if (((com.tencent.mm.ui.chatting.d.b.at)parama.bh(com.tencent.mm.ui.chatting.d.b.at.class)).ch(paramca)) {
        aW(4, paramca.field_msgId);
      }
      AppMethodBeat.o(37474);
      return true;
    }
    
    public final boolean gTT()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements t.n
  {
    private int KdF = 3;
    private com.tencent.mm.ui.chatting.e.a PhN;
    
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
        localObject = new an(paramLayoutInflater, 2131493613);
        ((View)localObject).setTag(new bf.c().e((View)localObject, false, this.Pdm));
      }
      AppMethodBeat.o(37477);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, String paramString)
    {
      AppMethodBeat.i(37478);
      this.PhN = parama1;
      bf.c localc = (bf.c)parama;
      localc.PPL.setFromVoice(false);
      localc.PPL.setFromGroup(parama1.gRM());
      com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class);
      b(localk, paramca.field_msgId);
      bf.c.a(this, localc, paramca, paramInt, parama1, false, c(parama1), this);
      com.tencent.mm.ui.chatting.d.b.at localat = (com.tencent.mm.ui.chatting.d.b.at)parama1.bh(com.tencent.mm.ui.chatting.d.b.at.class);
      parama = null;
      paramString = ChattingItemTranslate.c.PPm;
      Object localObject;
      if (bf.d(paramca, parama1))
      {
        localObject = localat.S(paramca.field_msgId, paramca.field_imgPath);
        parama = (c.a)localObject;
        if (Util.isNullOrNil((String)localObject)) {
          break label817;
        }
        paramString = ChattingItemTranslate.c.PPp;
        parama = (c.a)localObject;
      }
      label513:
      label778:
      label817:
      for (;;)
      {
        if ((!Util.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.c.PPm))
        {
          if (localc.PKI == null)
          {
            localc.PKI = ((ChattingItemTranslate)localc.PKH.inflate());
            localc.PKI.setMinimumWidth(localc.PPI - com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 5));
            localc.PKI.init();
          }
          Context localContext = localc.PNK.getContext();
          int i = (int)localc.PKI.getContentView().getTextSize();
          if (paramca != null)
          {
            localObject = ad.JX(paramca.field_msgSvrId);
            ad.b localb = ad.aVe().G((String)localObject, true);
            localb.l("prePublishId", "msg_" + paramca.field_msgSvrId);
            localb.l("preUsername", a(this.PhN, paramca));
            localb.l("preChatName", b(this.PhN, paramca));
            label335:
            localObject = com.tencent.mm.pluginsdk.ui.span.l.a(localContext, parama, i, 1, null, (String)localObject);
            localc.PKI.a((CharSequence)localObject, paramString, localat.NF(paramca.field_msgId), ChattingItemTranslate.b.PPk, paramca.field_msgId, parama1);
            if ((!Util.isNullOrNil((CharSequence)localObject)) && (localat.NF(paramca.field_msgId))) {
              localat.NG(paramca.field_msgId);
            }
            paramString = new ChattingItemTranslate.a(paramca, parama1.gRM(), paramInt);
            paramString.qcr = 2;
            localc.PKI.setTag(paramString);
            localc.PKI.setOnLongClickListener(c(parama1));
            localc.PKI.setVisibility(0);
            if (!Util.isNullOrNil(parama))
            {
              localc.PKI.setOnTouchListener(localk.gOC());
              localc.PKI.setOnDoubleClickListener(new NeatTextView.b()
              {
                public final boolean gS(View paramAnonymousView)
                {
                  AppMethodBeat.i(37475);
                  bf.c.a(MMApplicationContext.getContext(), parama, parama1);
                  bf.cQ(paramca);
                  AppMethodBeat.o(37475);
                  return true;
                }
              });
            }
            if (!gTW()) {
              break label778;
            }
            if (localc.PPR != null) {
              localc.PPR.setVisibility(8);
            }
            if (localc.PIn != null) {
              localc.PIn.setVisibility(8);
            }
            if ((paramca.field_status != 1) && (paramca.field_status != 5)) {
              break label692;
            }
            localc.PPS.setBackgroundResource(2131231797);
            paramca.OqF = true;
          }
        }
        for (;;)
        {
          a(paramInt, localc, paramca, parama1.gRI(), parama1.gRM(), parama1, this);
          AppMethodBeat.o(37478);
          return;
          if (!localat.NC(paramca.field_msgId)) {
            break label817;
          }
          parama = localat.S(paramca.field_msgId, paramca.field_imgPath);
          paramString = localat.NB(paramca.field_msgId);
          break;
          localObject = null;
          break label335;
          if (localc.PKI == null) {
            break label513;
          }
          localc.PKI.setVisibility(8);
          break label513;
          label692:
          localc.PPS.setBackgroundResource(2131231796);
          if ((localc.PIn != null) && (b(localk, paramca.field_msgId)))
          {
            if (paramca.OqF)
            {
              parama = new AlphaAnimation(0.5F, 1.0F);
              parama.setDuration(300L);
              localc.PPS.startAnimation(parama);
              paramca.OqF = false;
            }
            localc.PIn.setVisibility(0);
            continue;
            if (localc.PPR != null)
            {
              localc.PPR.setVisibility(0);
              if (paramca.field_status >= 2) {
                localc.PPR.setVisibility(8);
              }
            }
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37480);
      Object localObject = (com.tencent.mm.ui.chatting.d.b.at)parama.bh(com.tencent.mm.ui.chatting.d.b.at.class);
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(37480);
        return false;
        ((aw)parama.bh(aw.class)).BV(true);
        AppMethodBeat.o(37480);
        return true;
        ((aw)parama.bh(aw.class)).BV(false);
        AppMethodBeat.o(37480);
        return true;
        if (!WeChatBrands.Business.Entries.SessionSpeech2TextSnd.checkAvailable(parama.Pwc.getContext()))
        {
          AppMethodBeat.o(37480);
          return true;
        }
        boolean bool = bf.b(paramMenuItem.getGroupId(), parama, paramca, (com.tencent.mm.ui.chatting.d.b.at)localObject, false);
        AppMethodBeat.o(37480);
        return bool;
        paramMenuItem = ((com.tencent.mm.ui.chatting.d.b.at)localObject).S(paramca.field_msgId, paramca.field_imgPath);
        if (!Util.isNullOrNil(paramMenuItem)) {
          ClipboardHelper.setText(paramMenuItem);
        }
        bf.e(8, paramca);
        AppMethodBeat.o(37480);
        return true;
        paramMenuItem = new Intent(parama.Pwc.getContext(), MsgRetransmitUI.class);
        localObject = ((com.tencent.mm.ui.chatting.d.b.at)localObject).S(paramca.field_msgId, paramca.field_imgPath);
        if (paramca.gDg())
        {
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bl(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          bf.e(9, paramca);
          AppMethodBeat.o(37480);
          return true;
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 4);
        }
        localObject = ((com.tencent.mm.ui.chatting.d.b.at)localObject).S(paramca.field_msgId, paramca.field_imgPath);
        paramMenuItem = new cz();
        com.tencent.mm.pluginsdk.model.h.b(paramMenuItem, (String)localObject, 1);
        paramMenuItem.dFZ.fragment = parama.Pwc;
        paramMenuItem.dFZ.dGf = 43;
        if (paramMenuItem.dFZ.dGb != null)
        {
          parama = paramMenuItem.dFZ.dGb.Lya;
          if (parama != null)
          {
            parama.bhf(z.aTY());
            parama.bhg(paramca.field_talker);
            EventCenter.instance.publish(paramMenuItem);
          }
        }
        for (;;)
        {
          bf.e(10, paramca);
          AppMethodBeat.o(37480);
          return true;
          Log.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
        }
        ((aw)parama.bh(aw.class)).cm(paramca);
      }
    }
    
    public final boolean a(m paramm, View paramView, ca paramca)
    {
      int k = 0;
      AppMethodBeat.i(233960);
      bg.aVF();
      Object localObject;
      int m;
      com.tencent.mm.ui.chatting.d.b.at localat;
      int i;
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        localObject = (ChattingItemTranslate.a)paramView.getTag();
        m = ((ChattingItemTranslate.a)localObject).position;
        if (((ChattingItemTranslate.a)localObject).qcr == 1)
        {
          localObject = new p(paramca.field_content);
          if (((((p)localObject).time != 0L) || (paramca.field_isSend != 0)) && ((paramca.field_status != 1) || (paramca.field_isSend != 1)))
          {
            if (((aw)this.PhN.bh(aw.class)).gRz()) {
              paramm.a(m, 120, paramView.getContext().getString(2131757274), 2131690708);
            }
          }
          else
          {
            if (paramca.field_status == 5) {
              paramm.a(m, 103, paramView.getContext().getString(2131757500), 2131690658);
            }
            if (com.tencent.mm.br.c.aZU("favorite")) {
              paramm.a(m, 116, paramView.getContext().getString(2131763947), 2131690551);
            }
            if ((!paramca.gAt()) && (paramca.gAy()) && ((paramca.field_status == 2) || (paramca.fQV == 1)) && (b(paramca, this.PhN)) && (bnf(paramca.field_talker))) {
              paramm.a(m, 123, paramView.getContext().getString(2131757446), 2131690650);
            }
            localat = (com.tencent.mm.ui.chatting.d.b.at)this.PhN.bh(com.tencent.mm.ui.chatting.d.b.at.class);
            if (!bf.d(paramca, this.PhN)) {
              break label513;
            }
            if (!Util.isNullOrNil(localat.S(paramca.field_msgId, paramca.field_imgPath))) {
              break label728;
            }
            i = 2131757456;
          }
        }
      }
      for (;;)
      {
        int j = k;
        if (ab.IT(paramca.field_talker))
        {
          j = k;
          if (LocaleUtil.isChineseAppLang())
          {
            j = k;
            if (i != -1)
            {
              paramm.a(m, 121, paramView.getContext().getString(2131757456), 2131690697);
              j = 1;
            }
          }
        }
        if (((((p)localObject).time != 0L) || (paramca.field_isSend != 0)) && ((paramca.field_status != 1) || (paramca.field_isSend != 1)) && (!this.PhN.gRN())) {
          paramm.a(m, 100, paramView.getContext().getString(2131757435), 2131690529);
        }
        if ((j == 0) && (LocaleUtil.isChineseAppLang()) && (i != -1)) {
          paramm.a(m, 121, paramView.getContext().getString(i), 2131690697);
        }
        AppMethodBeat.o(233960);
        return true;
        paramm.a(m, 119, paramView.getContext().getString(2131757273), 2131690544);
        break;
        label513:
        if (!localat.NC(paramca.field_msgId))
        {
          i = 2131757456;
          continue;
          if (((ChattingItemTranslate.a)localObject).qcr == 2)
          {
            localObject = (com.tencent.mm.ui.chatting.d.b.at)this.PhN.bh(com.tencent.mm.ui.chatting.d.b.at.class);
            if (((com.tencent.mm.ui.chatting.d.b.at)localObject).NB(paramca.field_msgId) == ChattingItemTranslate.c.PPo) {
              paramm.add(m, 121, 0, 2131757452);
            }
            for (;;)
            {
              AppMethodBeat.o(233960);
              return false;
              if (!Util.isNullOrNil(((com.tencent.mm.ui.chatting.d.b.at)localObject).S(paramca.field_msgId, paramca.field_imgPath)))
              {
                paramm.a(m, 141, paramView.getContext().getString(2131757430), 2131690525);
                paramm.a(m, 142, paramView.getContext().getString(2131764628), 2131690674);
                if (com.tencent.mm.br.c.aZU("favorite")) {
                  paramm.a(m, 143, paramView.getContext().getString(2131763947), 2131690551);
                }
              }
              paramm.a(m, 121, paramView.getContext().getString(2131757454), 2131690549);
            }
          }
          AppMethodBeat.o(233960);
          return true;
        }
        else
        {
          label728:
          i = -1;
        }
      }
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(233961);
      ((aw)parama.bh(aw.class)).cm(paramca);
      AppMethodBeat.o(233961);
    }
    
    public final boolean bM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 34);
    }
    
    public final boolean c(View paramView, final com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37481);
      if (paramca.field_status == 5)
      {
        Log.i("MicroMsg.ChattingItemVoice", "onItemClick msg(%s) fail", new Object[] { Long.valueOf(paramca.field_msgId) });
        AppMethodBeat.o(37481);
        return true;
      }
      if (paramca.gDP())
      {
        ((aw)parama.bh(aw.class)).a(paramca.field_msgId, paramView);
        if (((aw)parama.bh(aw.class)).NK(paramca.field_msgId))
        {
          Log.i("MicroMsg.ChattingItemVoice", "onCreateContextMenu: voice msg show download animation");
          AppMethodBeat.o(37481);
          return true;
        }
        ca localca = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(paramca.field_msgId);
        if (localca.gDP())
        {
          ((aw)parama.bh(aw.class)).NJ(localca.field_msgId);
          o.bid().run();
          com.tencent.f.h.RTc.aV(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(233959);
              parama.cmy();
              AppMethodBeat.o(233959);
            }
          });
          Log.i("MicroMsg.ChattingItemVoice", "onItemClick voice msg(%s) no finish download!", new Object[] { Long.valueOf(paramca.field_msgId) });
          AppMethodBeat.o(37481);
          return true;
        }
      }
      ((aw)parama.bh(aw.class)).gRA();
      paramView = (bq)paramView.getTag();
      com.tencent.mm.modelstat.b.jmd.ae(paramView.dTX);
      bf.b(parama, paramView);
      ((com.tencent.mm.ui.chatting.d.b.at)parama.bh(com.tencent.mm.ui.chatting.d.b.at.class)).amG(2);
      ((au)parama.bh(au.class)).gRw();
      ((com.tencent.mm.plugin.comm.a.b)g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(paramca.field_talker);
      AppMethodBeat.o(37481);
      return true;
    }
    
    public final boolean gTT()
    {
      return true;
    }
  }
  
  public static final class c
    extends c.a
  {
    TextView PHZ;
    ImageView PIn;
    ViewStub PKH;
    ChattingItemTranslate PKI;
    TextView PNK;
    int PPI;
    TextView PPJ;
    TextView PPK;
    AnimImageView PPL;
    FrameLayout PPM;
    FrameLayout PPN;
    ImageView PPO;
    ProgressBar PPP;
    AnimImageView PPQ;
    ProgressBar PPR;
    TextView PPS;
    ImageView PPT;
    RelativeLayout PPU;
    TextView PPV;
    Animation PPW;
    
    private static int Qi(int paramInt)
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
    
    static void a(Context paramContext, CharSequence paramCharSequence, com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(233963);
      Intent localIntent = new Intent(paramContext, TextPreviewUI.class);
      localIntent.putExtra("key_chat_text", paramCharSequence);
      if (parama != null) {
        localIntent.putExtra("is_group_chat", parama.gRM());
      }
      paramCharSequence = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramCharSequence.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$VoiceItemHolder", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramCharSequence.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$VoiceItemHolder", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.kc(paramContext);
      AppMethodBeat.o(233963);
    }
    
    private static void a(c paramc, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(37487);
      paramc.stateIV.setVisibility(paramInt2);
      paramc.PNK.setVisibility(paramInt2);
      paramc.PPM.setVisibility(paramInt2);
      if (paramBoolean)
      {
        paramc.PPQ.setVisibility(paramInt1);
        paramc.PHZ.setVisibility(paramInt2);
        AppMethodBeat.o(37487);
        return;
      }
      if (paramc.PPS != null) {
        paramc.PPS.setVisibility(paramInt1);
      }
      AppMethodBeat.o(37487);
    }
    
    public static void a(c paramc, c paramc1, ca paramca, int paramInt, com.tencent.mm.ui.chatting.e.a parama, boolean paramBoolean, View.OnLongClickListener paramOnLongClickListener, t.n paramn)
    {
      AppMethodBeat.i(233962);
      if (paramc1 == null)
      {
        AppMethodBeat.o(233962);
        return;
      }
      p localp = new p(paramca.field_content);
      float f1 = s.AO(localp.time);
      d locald = ((aw)parama.bh(aw.class)).gRx();
      label150:
      label342:
      float f2;
      if ((locald != null) && (paramca.field_msgId == locald.Pei))
      {
        paramc1.PPL.setVisibility(0);
        paramc1.PPL.bWT();
        if (!((aw)parama.bh(aw.class)).NK(paramca.field_msgId)) {
          break label652;
        }
        Log.d("MicroMsg.ChattingItemVoice", "startDownloadAnim");
        if (paramc1.PPP != null)
        {
          paramc1.PPP.setVisibility(0);
          if (paramc1.PPK != null) {
            paramc1.PPK.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          }
        }
        if (paramca.field_isSend != 0) {
          break label1141;
        }
        if (paramca.field_status != 5) {
          break label743;
        }
        a(paramc1, 8, 0, true);
        paramc1.PPQ.cEA();
        paramc1.PPQ.setVisibility(8);
        paramc1.PNK.setVisibility(0);
        paramc1.PPI = com.tencent.mm.cb.a.fromDPToPix(parama.Pwc.getContext(), Qi((int)f1));
        paramc1.PPK.setWidth(paramc1.PPI);
        paramc1.PNK.setText(parama.Pwc.getMMResources().getString(2131760887, new Object[] { Integer.valueOf((int)f1) }));
        paramc1.PPL.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.Pwc.getContext(), Qi((int)f1)));
        if (paramc1.PPT == null) {
          break label1141;
        }
        paramc1.PPT.setVisibility(0);
        paramc1.PPT.setTag(new bq(paramca, parama.gRM(), paramInt, "", '\000'));
        paramc1.PPT.setOnClickListener(paramc.a(parama, paramn));
        f2 = f1;
        if (1 != paramca.field_isSend) {
          break label1584;
        }
        if (paramca.field_status != 1) {
          break label1144;
        }
        a(paramc1, 0, 8, false);
        paramc1.PPN.setVisibility(8);
        paramc1.gUj();
        label383:
        paramc = ((com.tencent.mm.ui.chatting.d.b.c)parama.bh(com.tencent.mm.ui.chatting.d.b.c.class)).gPr();
        if (paramc != null)
        {
          if (!paramc.Kbw) {
            break label1591;
          }
          paramc1.PNK.setShadowLayer(2.0F, 1.2F, 1.2F, paramc.Kbx);
          label429:
          if (!paramc.Kby) {
            break label1605;
          }
          paramc1.PNK.setBackgroundResource(2131231795);
        }
        label446:
        paramc = new ChattingItemTranslate.a(paramca, parama.gRM(), paramInt);
        paramc1.PPK.setTag(paramc);
        paramc1.PPK.setOnClickListener(paramc1.chattingItem.d(parama));
        paramc1.PPK.setOnLongClickListener(paramOnLongClickListener);
        paramc1.PPK.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
        if ((paramca.fqJ & 0x1) != 1) {
          break label1639;
        }
        paramc1.PPJ.setVisibility(0);
        if (paramca.field_isSend != 0) {
          break label1616;
        }
        paramc1.PPL.setBackgroundResource(2131231688);
        label552:
        if (!paramBoolean) {
          break label1691;
        }
        parama.getTalkerUserName();
      }
      for (;;)
      {
        paramc = ((com.tencent.mm.ui.chatting.d.b.f)parama.bh(com.tencent.mm.ui.chatting.d.b.f.class)).bmF(parama.getTalkerUserName());
        paramca = a.a.gKe();
        parama = paramc1.PPK;
        paramInt = (int)f1;
        if (paramc != null) {
          paramc.toString();
        }
        paramca.aF(parama, paramInt);
        paramc1.PNK.setContentDescription(" ");
        AppMethodBeat.o(233962);
        return;
        paramc1.PPL.setVisibility(8);
        paramc1.PPL.cEA();
        break;
        label652:
        Log.d("MicroMsg.ChattingItemVoice", "stopDownloadAnim");
        if (paramc1.PPP == null) {
          break label150;
        }
        paramc1.PPP.setVisibility(8);
        if (paramc1.PPK == null) {
          break label150;
        }
        if (paramBoolean)
        {
          paramc1.PPK.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.ui.at.aN(paramc1.PPK.getContext(), 2130968755), null, null, null);
          break label150;
        }
        paramc1.PPK.setCompoundDrawablesWithIntrinsicBounds(null, null, paramc1.PPK.getContext().getResources().getDrawable(2131689942), null);
        break label150;
        label743:
        if (localp.time == 0L)
        {
          a(paramc1, 8, 0, true);
          paramc1.PPQ.cEA();
          paramc1.PPQ.setVisibility(8);
          paramc1.stateIV.setVisibility(8);
          f2 = 0.0F;
          paramc1.PPI = com.tencent.mm.cb.a.fromDPToPix(parama.Pwc.getContext(), Qi(0));
          paramc1.PPK.setWidth(paramc1.PPI);
          paramc1.PNK.setText(parama.Pwc.getMMResources().getString(2131760887, new Object[] { Integer.valueOf(0) }));
          paramc1.PPL.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.Pwc.getContext(), Qi(0)));
          f1 = f2;
          if (paramc1.PPT == null) {
            break label342;
          }
          paramc1.PPT.setVisibility(8);
          f1 = f2;
          break label342;
        }
        if (localp.time == -1L)
        {
          a(paramc1, 8, 0, true);
          paramc1.PPQ.cEA();
          paramc1.PPQ.setVisibility(8);
          paramc1.PPI = 80;
          paramc1.PPK.setWidth(80);
          paramc1.PNK.setVisibility(8);
          paramc1.PPL.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.Pwc.getContext(), Qi((int)f1)));
          if (paramc1.PPT == null) {
            break label1141;
          }
          paramc1.PPT.setVisibility(8);
          break label342;
        }
        a(paramc1, 8, 0, true);
        paramc1.PPQ.cEA();
        paramc1.PPQ.setVisibility(8);
        paramc1.PNK.setVisibility(0);
        paramc1.PPI = com.tencent.mm.cb.a.fromDPToPix(parama.Pwc.getContext(), Qi((int)f1));
        paramc1.PPK.setWidth(paramc1.PPI);
        paramc1.PNK.setText(parama.Pwc.getMMResources().getString(2131760887, new Object[] { Integer.valueOf((int)f1) }));
        paramc1.PPL.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.Pwc.getContext(), Qi((int)f1)));
        if (paramc1.PPT != null) {
          paramc1.PPT.setVisibility(8);
        }
        label1141:
        break label342;
        label1144:
        if (paramca.field_status == 5)
        {
          a(paramc1, 8, 0, false);
          paramc1.PPN.setVisibility(8);
          paramc1.PNK.setVisibility(0);
          paramc1.gUj();
          if (localp.time == 0L) {
            f1 = 0.0F;
          }
          paramc1.PPI = com.tencent.mm.cb.a.fromDPToPix(parama.Pwc.getContext(), Qi((int)f1));
          paramc1.PPK.setWidth(paramc1.PPI);
          paramc1.PNK.setText(parama.Pwc.getMMResources().getString(2131760887, new Object[] { Integer.valueOf((int)f1) }));
          paramc1.PPL.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.Pwc.getContext(), Qi((int)f1)));
          break label383;
        }
        if (localp.time == -1L)
        {
          a(paramc1, 8, 0, false);
          paramc1.PPK.setWidth(80);
          paramc1.PPI = 80;
          paramc1.PNK.setVisibility(8);
          paramc1.PPN.setVisibility(8);
          paramc1.PPL.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.Pwc.getContext(), Qi((int)f1)));
          paramc1.gUj();
          break label383;
        }
        if (paramca.field_status == 7)
        {
          a(paramc1, 8, 8, false);
          paramc1.PNK.setVisibility(8);
          paramc1.PPN.setVisibility(0);
          paramc1.gUj();
          if (paramc1.PPO != null)
          {
            paramc1.PPW = AnimationUtils.loadAnimation(paramc1.convertView.getContext(), 2130772201);
            paramc1.PPO.startAnimation(paramc1.PPW);
          }
          break label383;
        }
        a(paramc1, 8, 0, false);
        paramc1.PPN.setVisibility(8);
        paramc1.PNK.setVisibility(0);
        paramc1.gUj();
        if (localp.time == 0L) {
          f1 = 0.0F;
        }
        paramc1.PPI = com.tencent.mm.cb.a.fromDPToPix(parama.Pwc.getContext(), Qi((int)f1));
        paramc1.PPK.setWidth(paramc1.PPI);
        paramc1.PNK.setText(parama.Pwc.getMMResources().getString(2131760887, new Object[] { Integer.valueOf((int)f1) }));
        paramc1.PPL.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.Pwc.getContext(), Qi((int)f1)));
        f2 = f1;
        label1584:
        f1 = f2;
        break label383;
        label1591:
        paramc1.PNK.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        break label429;
        label1605:
        paramc1.PNK.setBackgroundColor(0);
        break label446;
        label1616:
        paramc1.PPS.setBackgroundResource(2131231805);
        paramc1.PPL.setBackgroundResource(2131231805);
        break label552;
        label1639:
        paramc1.PPJ.setVisibility(8);
        if (paramca.field_isSend == 0)
        {
          paramc1.PPL.setBackgroundResource(2131231670);
          break label552;
        }
        paramc1.PPS.setBackgroundResource(2131231796);
        paramc1.PPL.setBackgroundResource(2131231796);
        break label552;
        label1691:
        parama.gRI();
      }
    }
    
    private void gUj()
    {
      AppMethodBeat.i(37486);
      if (this.PPW != null)
      {
        this.PPW.cancel();
        this.PPW = null;
      }
      AppMethodBeat.o(37486);
    }
    
    public final c.a e(View paramView, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(37483);
      super.create(paramView);
      this.timeTV = ((TextView)paramView.findViewById(2131298558));
      this.userTV = ((TextView)paramView.findViewById(2131298566));
      this.PPK = ((TextView)paramView.findViewById(2131298579));
      this.checkBox = ((CheckBox)paramView.findViewById(2131298410));
      this.maskView = paramView.findViewById(2131298508);
      this.stateIV = ((ImageView)paramView.findViewById(2131298554));
      this.PNK = ((TextView)paramView.findViewById(2131298416));
      this.PPM = ((FrameLayout)paramView.findViewById(2131298580));
      this.PPP = ((ProgressBar)paramView.findViewById(2131298576));
      this.PKH = ((ViewStub)paramView.findViewById(2131309405));
      this.PPJ = ((TextView)paramView.findViewById(2131298577));
      this.PPL = ((AnimImageView)paramView.findViewById(2131298575));
      this.PPL.setType(1);
      if (paramBoolean1)
      {
        this.PPL.setFromVoice(true);
        this.PPL.setFromGroup(paramBoolean2);
        this.PHZ = ((TextView)paramView.findViewById(2131298364));
        this.PPQ = ((AnimImageView)paramView.findViewById(2131298578));
        this.PPQ.setFromVoice(true);
        this.PPQ.setFromGroup(paramBoolean2);
        this.PPQ.setType(0);
        this.PPT = ((ImageView)paramView.findViewById(2131298446));
        this.PPU = ((RelativeLayout)paramView.findViewById(2131298448));
        this.PPV = ((TextView)paramView.findViewById(2131298447));
      }
      for (;;)
      {
        AppMethodBeat.o(37483);
        return this;
        this.PPN = ((FrameLayout)paramView.findViewById(2131298587));
        this.PPO = ((ImageView)paramView.findViewById(2131298588));
        this.PPR = ((ProgressBar)paramView.findViewById(2131298589));
        this.uploadingPB = ((ProgressBar)paramView.findViewById(2131309619));
        this.PPS = ((TextView)paramView.findViewById(2131298590));
        this.PPL.setFromVoice(false);
        this.PPL.setFromGroup(paramBoolean2);
        this.PIn = ((ImageView)paramView.findViewById(2131298556));
      }
    }
    
    public final View getMainContainerView()
    {
      return this.PPM;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bf
 * JD-Core Version:    0.7.0.1
 */