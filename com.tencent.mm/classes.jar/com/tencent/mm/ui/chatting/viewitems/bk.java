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
import com.tencent.mm.R.a;
import com.tencent.mm.R.d;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ao.af;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.a;
import com.tencent.mm.f.a.gp;
import com.tencent.mm.f.b.a.is;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.modelstat.b.b;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.d;
import com.tencent.mm.ui.chatting.d.b.au;
import com.tencent.mm.ui.chatting.d.b.av;
import com.tencent.mm.ui.chatting.d.b.ax;
import com.tencent.mm.ui.chatting.d.bl;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class bk
{
  private static boolean a(final int paramInt, com.tencent.mm.ui.chatting.e.a parama, final ca paramca, final au paramau, boolean paramBoolean)
  {
    AppMethodBeat.i(288797);
    if (a(parama, paramca, R.l.etZ))
    {
      AppMethodBeat.o(288797);
      return true;
    }
    if (b(parama, paramca, R.l.etX))
    {
      AppMethodBeat.o(288797);
      return true;
    }
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(37465);
        Object localObject = this.QWD;
        ca localca = paramca;
        au localau = (au)((com.tencent.mm.ui.chatting.e.a)localObject).bC(au.class);
        if ((localObject == null) || (localau == null))
        {
          Log.e("MicroMsg.ChattingItemVoice", "alvinluo ui or ui.transformImp null");
          AppMethodBeat.o(37465);
          return;
        }
        int i;
        if (localau.VT(localca.field_msgId)) {
          i = 2;
        }
        for (;;)
        {
          Log.i("MicroMsg.ChattingItemVoice", "alvinluo TransformText report clickScene: %d, msgId: %d", new Object[] { Integer.valueOf(i), Long.valueOf(localca.field_msgId) });
          localObject = new gp();
          ((gp)localObject).fCT.fCU = 1;
          ((gp)localObject).fCT.scene = i;
          ((gp)localObject).fCT.fileName = localca.field_imgPath;
          EventCenter.instance.publish((IEvent)localObject);
          AppMethodBeat.o(37465);
          return;
          if (localau.VO(localca.field_msgId)) {
            i = 3;
          } else if (!Util.isNullOrNil(localau.ae(localca.field_msgId, localca.field_imgPath))) {
            i = 5;
          } else {
            i = 1;
          }
        }
      }
    }, "voice_transform_text_report");
    if (paramau.hQP()) {
      com.tencent.mm.ui.base.h.d(parama.WQv.getContext(), parama.WQv.getContext().getString(R.l.eVt), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(264658);
          if (this.EzU) {
            s.as(paramca);
          }
          paramau.hQQ();
          paramau.a(paramca, true, paramInt, 0);
          AppMethodBeat.o(264658);
        }
      });
    }
    for (;;)
    {
      parama = com.tencent.mm.modelstat.b.mcf;
      if (parama.bpp()) {
        parama.a(paramca, b.b.mcu, 0);
      }
      AppMethodBeat.o(288797);
      return true;
      if (paramBoolean) {
        s.as(paramca);
      }
      paramau.a(paramca, true, paramInt, 0);
    }
  }
  
  public static boolean a(com.tencent.mm.ui.chatting.e.a parama, ca paramca, int paramInt)
  {
    AppMethodBeat.i(288795);
    if (paramca == null)
    {
      AppMethodBeat.o(288795);
      return false;
    }
    boolean bool1;
    if (paramca.hAd()) {
      if (((ax)parama.bC(ax.class)).VW(paramca.field_msgId))
      {
        Log.i("MicroMsg.ChattingItemVoice", "onCreateContextMenu: voice msg is downloading.(1)");
        bool1 = true;
        bool2 = bool1;
        if (bool1)
        {
          Log.i("MicroMsg.ChattingItemVoice", "handleNoFinishDownloadVoiceMsg show alert!");
          com.tencent.mm.ui.base.h.a(parama.WQv.getContext(), parama.WQv.getContext().getString(paramInt), "", parama.WQv.getContext().getString(R.l.welcome_i_know), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = false)
    {
      AppMethodBeat.o(288795);
      return bool2;
      if (((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramca.field_msgId).hAd())
      {
        Log.i("MicroMsg.ChattingItemVoice", "onCreateContextMenu: voice msg is downloading.(2)");
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
    }
  }
  
  public static void b(com.tencent.mm.ui.chatting.e.a parama, by paramby)
  {
    AppMethodBeat.i(37488);
    if ((com.tencent.mm.q.a.cy(parama.WQv.getContext())) || (com.tencent.mm.q.a.cw(parama.WQv.getContext())) || (com.tencent.mm.q.a.cB(parama.WQv.getContext())))
    {
      Log.d("MicroMsg.ChattingItemVoice", "voip is running, not play voice");
      AppMethodBeat.o(37488);
      return;
    }
    bh.beI();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      com.tencent.mm.ui.base.w.g(parama.WQv.getContext(), parama.WQv.getContentView());
      AppMethodBeat.o(37488);
      return;
    }
    Object localObject;
    ca localca;
    int i;
    if ((paramby != null) && (paramby.fNz != null))
    {
      localObject = new p(paramby.fNz.field_content);
      if ((ae.isNullOrNil(paramby.fNz.field_content)) || (((p)localObject).time == 0L))
      {
        Toast.makeText(parama.WQv.getContext(), R.l.euI, 0).show();
        AppMethodBeat.o(37488);
        return;
      }
      localObject = ((ax)parama.bC(ax.class)).hQU();
      if ((parama.bC(com.tencent.mm.ui.chatting.d.b.k.class) != null) && (localObject != null))
      {
        localca = paramby.fNz;
        if (((ax)parama.bC(ax.class)).hQU().WxA != localca.field_msgId)
        {
          parama = (au)parama.bC(au.class);
          if (!parama.VT(localca.field_msgId)) {
            break label324;
          }
          i = 7;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        parama = new gp();
        parama.fCT.fCU = 1;
        parama.fCT.scene = i;
        parama.fCT.fileName = localca.field_imgPath;
        EventCenter.instance.publish(parama);
      }
      i = paramby.position;
      parama = paramby.fNz;
      if ((parama == null) || (!parama.hwF()))
      {
        AppMethodBeat.o(37488);
        return;
        label324:
        if (parama.VO(localca.field_msgId)) {
          i = 6;
        }
      }
      else
      {
        paramby = new p(parama.field_content);
        if (((paramby.time == 0L) && (parama.field_isSend == 0)) || ((parama.field_status == 1) && (parama.field_isSend == 1)))
        {
          AppMethodBeat.o(37488);
          return;
        }
        if ((parama.field_isSend != 0) || (paramby.time != -1L))
        {
          ((d)localObject).hLX();
          bh.beI();
          paramby = (Boolean)com.tencent.mm.model.c.aHp().b(4115, null);
          if ((paramby == null) || (!paramby.booleanValue()))
          {
            bh.beI();
            com.tencent.mm.model.c.aHp().i(4115, Boolean.TRUE);
            ((d)localObject).hMd();
            ((d)localObject).WxD = com.tencent.mm.ui.base.w.a(((d)localObject).fgR.WQv.getActivity(), ((d)localObject).context.getString(R.l.ewq), 4000L);
          }
          if ((((d)localObject).uwr.isPlaying()) && (parama.field_msgId == ((d)localObject).WxA))
          {
            ((d)localObject).WxJ = true;
            ((d)localObject).hMc();
            AppMethodBeat.o(37488);
            return;
          }
          ((d)localObject).by(parama);
          if ((parama.field_isSend == 0) && (!s.aq(parama))) {
            ((d)localObject).ava(i + 1);
          }
          ((d)localObject).oO(true);
        }
        AppMethodBeat.o(37488);
        return;
      }
      i = 0;
    }
  }
  
  public static boolean b(com.tencent.mm.ui.chatting.e.a parama, ca paramca, int paramInt)
  {
    AppMethodBeat.i(288796);
    if ((paramca != null) && (paramca.hwF()) && (paramca.field_isSend != 1) && (paramca.field_status == 5))
    {
      Log.i("MicroMsg.ChattingItemVoice", "handleDownloadFailVoiceMsg show alert!");
      com.tencent.mm.ui.base.h.a(parama.WQv.getContext(), parama.WQv.getContext().getString(paramInt), "", parama.WQv.getContext().getString(R.l.welcome_i_know), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(288796);
      return true;
    }
    AppMethodBeat.o(288796);
    return false;
  }
  
  public static final class a
    extends c
    implements t.n
  {
    private com.tencent.mm.ui.chatting.e.a WBq;
    private View.OnClickListener XlG;
    
    public static void bh(int paramInt, long paramLong)
    {
      AppMethodBeat.i(244503);
      if (!bl.hRa())
      {
        AppMethodBeat.o(244503);
        return;
      }
      is localis = new is();
      localis.gJu = paramInt;
      localis.zO(String.valueOf(paramLong));
      Log.d("MicroMsg.ChattingItemVoice", "%s", new Object[] { localis.agI() });
      localis.bpa();
      AppMethodBeat.o(244503);
    }
    
    public static void g(int paramInt, ca paramca)
    {
      AppMethodBeat.i(244502);
      if (paramca == null)
      {
        Log.i("MicroMsg.ChattingItemVoice", "msgInfo is null???");
        AppMethodBeat.o(244502);
        return;
      }
      bh(paramInt, paramca.field_msgId);
      AppMethodBeat.o(244502);
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
        localObject = new aq(paramLayoutInflater, R.i.eds);
        ((View)localObject).setTag(new bk.c().e((View)localObject, true, this.Wwx));
      }
      AppMethodBeat.o(37469);
      return localObject;
    }
    
    public final void a(final c.a parama, final int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, String paramString)
    {
      AppMethodBeat.i(37471);
      this.WBq = parama1;
      bk.c localc = (bk.c)parama;
      localc.XlN.setFromVoice(true);
      localc.XlN.setFromGroup(parama1.hRi());
      com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class);
      b(localk, paramca.field_msgId);
      bk.c.a(this, localc, paramca, paramInt, parama1, true, c(parama1), this);
      paramString = ChattingItemTranslate.c.Xlo;
      final au localau = (au)parama1.bC(au.class);
      if (bk.d(paramca, parama1))
      {
        parama = localau.ae(paramca.field_msgId, paramca.field_imgPath);
        if (Util.isNullOrNil(parama)) {
          break label1043;
        }
        paramString = ChattingItemTranslate.c.Xlr;
      }
      label1038:
      label1043:
      for (;;)
      {
        int i;
        Object localObject;
        if ((!Util.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.c.Xlo))
        {
          if (localc.XgC == null)
          {
            localc.XgC = ((ChattingItemTranslate)localc.XgB.inflate());
            localc.XgC.setMinimumWidth(localc.XlK - com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 5));
            localc.XgC.init();
          }
          Context localContext = localc.XjK.getContext();
          i = (int)localc.XgC.getContentView().getTextSize();
          if (paramca != null)
          {
            localObject = ad.Rp(paramca.field_msgSvrId);
            ad.b localb = ad.beh().I((String)localObject, true);
            localb.k("prePublishId", "msg_" + paramca.field_msgSvrId);
            localb.k("preUsername", a(this.WBq, paramca));
            localb.k("preChatName", b(this.WBq, paramca));
            label329:
            localObject = l.a(localContext, parama, i, null, (String)localObject);
            localc.XgC.a((CharSequence)localObject, paramString, localau.VR(paramca.field_msgId), ChattingItemTranslate.b.Xlm, paramca.field_msgId, parama1);
            if ((!Util.isNullOrNil((CharSequence)localObject)) && (localau.VR(paramca.field_msgId))) {
              localau.VS(paramca.field_msgId);
            }
            paramString = new ChattingItemTranslate.a(paramca, parama1.hRi(), paramInt);
            paramString.viewType = 2;
            localc.XgC.setTag(paramString);
            paramString = localc.XgC;
            if (this.XlG == null) {
              this.XlG = new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(266038);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  paramAnonymousView = (ChattingItemTranslate.a)((ChattingItemTranslate)paramAnonymousView).getTag();
                  if (((au)bk.a.a(bk.a.this).bC(au.class)).VN(paramAnonymousView.fNz.field_msgId) == ChattingItemTranslate.c.Xlq) {
                    ((au)bk.a.a(bk.a.this).bC(au.class)).a(paramAnonymousView.fNz, true, paramAnonymousView.position, 1);
                  }
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(266038);
                }
              };
            }
            paramString.setOnClickListener(this.XlG);
            localc.XgC.setOnLongClickListener(c(parama1));
            localc.XgC.setVisibility(0);
            if (!Util.isNullOrNil(parama))
            {
              localc.XgC.setOnTouchListener(localk.hNO());
              localc.XgC.setOnDoubleClickListener(new NeatTextView.b()
              {
                public final boolean ie(View paramAnonymousView)
                {
                  AppMethodBeat.i(37466);
                  bk.c.a(MMApplicationContext.getContext(), parama, parama1);
                  bk.dj(paramca);
                  AppMethodBeat.o(37466);
                  return true;
                }
              });
            }
            label541:
            if ((ar.isDarkMode()) || (!((com.tencent.mm.ui.chatting.d.b.c)parama1.bC(com.tencent.mm.ui.chatting.d.b.c.class)).hOI())) {
              break label796;
            }
            localc.XlX.setBackgroundResource(R.g.voice_to_text_custom_bg);
            label576:
            localc.XlX.setTextSize(0, com.tencent.mm.ci.a.aZ(parama1.WQv.getContext(), R.f.Edge_1_5_A));
            if (((ax)parama1.bC(ax.class)).VZ(paramca.field_msgId)) {
              break label810;
            }
            localc.XlW.setVisibility(8);
            label632:
            localc.XlW.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(246723);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                Log.i("MicroMsg.ChattingItemVoice", "voice fast trans text click");
                bk.b(paramInt, parama1, paramca, localau, true);
                bk.a.g(2, paramca);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(246723);
              }
            });
            parama = new p(paramca.field_content);
            if (parama.time != 0L) {
              break label822;
            }
            localc.stateIV.setVisibility(8);
          }
        }
        for (;;)
        {
          parama = paramca.ilh;
          if ((parama != null) && (parama.length() != 0)) {
            break label1009;
          }
          localc.Xdu.setVisibility(8);
          AppMethodBeat.o(37471);
          return;
          if (!localau.VO(paramca.field_msgId)) {
            break label1038;
          }
          parama = localau.ae(paramca.field_msgId, paramca.field_imgPath);
          paramString = localau.VN(paramca.field_msgId);
          break;
          localObject = null;
          break label329;
          if (localc.XgC == null) {
            break label541;
          }
          localc.XgC.setVisibility(8);
          break label541;
          label796:
          localc.XlX.setBackgroundResource(R.g.voice_to_text_bg);
          break label576;
          label810:
          localc.XlW.setVisibility(0);
          break label632;
          label822:
          paramString = ((ax)parama1.bC(ax.class)).hQU();
          if (((paramString != null) && (paramString.WxA == paramca.field_msgId)) || (s.aq(paramca)))
          {
            paramInt = 1;
            label868:
            paramString = localc.stateIV;
            if (paramInt == 0) {
              break label948;
            }
          }
          label948:
          for (i = 8;; i = 0)
          {
            paramString.setVisibility(i);
            i = (int)s.GW(parama.time);
            if (paramInt != 0) {
              break label954;
            }
            localc.XlM.setContentDescription(String.format(parama1.WQv.getContext().getString(R.l.voice_msg_unread_desc), new Object[] { Integer.valueOf(i) }));
            break;
            paramInt = 0;
            break label868;
          }
          label954:
          parama = ((com.tencent.mm.ui.chatting.d.b.f)parama1.bC(com.tencent.mm.ui.chatting.d.b.f.class)).bzg(parama1.getTalkerUserName());
          paramString = a.a.hJg();
          localObject = localc.XlM;
          if (parama != null) {
            parama.toString();
          }
          paramString.aK((View)localObject, i);
        }
        label1009:
        localc.Xdu.setVisibility(0);
        b(parama1, localc.Xdu, by.bzO(parama));
        AppMethodBeat.o(37471);
        return;
        parama = null;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37473);
      Object localObject = (au)parama.bC(au.class);
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(37473);
        return false;
        ((ax)parama.bC(ax.class)).Gq(true);
        AppMethodBeat.o(37473);
        return true;
        ((ax)parama.bC(ax.class)).Gq(false);
        AppMethodBeat.o(37473);
        return true;
        if (!WeChatBrands.Business.Entries.SessionSpeech2TextSnd.checkAvailable(parama.WQv.getContext()))
        {
          AppMethodBeat.o(37473);
          return true;
        }
        g(3, paramca);
        boolean bool = bk.b(paramMenuItem.getGroupId(), parama, paramca, (au)localObject, true);
        AppMethodBeat.o(37473);
        return bool;
        paramMenuItem = ((au)localObject).ae(paramca.field_msgId, paramca.field_imgPath);
        if (!Util.isNullOrNil(paramMenuItem)) {
          ClipboardHelper.setText(paramMenuItem);
        }
        bk.f(8, paramca);
        continue;
        paramMenuItem = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
        localObject = ((au)localObject).ae(paramca.field_msgId, paramca.field_imgPath);
        if (paramca.hzt())
        {
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          bk.f(9, paramca);
          break;
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 4);
        }
        localObject = ((au)localObject).ae(paramca.field_msgId, paramca.field_imgPath);
        paramMenuItem = new dd();
        j.b(paramMenuItem, (String)localObject, 1);
        paramMenuItem.fyI.fragment = parama.WQv;
        paramMenuItem.fyI.fyP = 43;
        if (paramMenuItem.fyI.fyK != null)
        {
          parama = paramMenuItem.fyI.fyK.SAB;
          if (parama != null)
          {
            parama.btx(paramca.field_talker);
            parama.bty(z.bcZ());
            EventCenter.instance.publish(paramMenuItem);
          }
        }
        for (;;)
        {
          bk.f(10, paramca);
          break;
          Log.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
        }
        ((ax)parama.bC(ax.class)).cE(paramca);
        ((ax)parama.bC(ax.class)).hQY();
        continue;
        ((ax)parama.bC(ax.class)).cF(paramca);
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.o paramo, View paramView, ca paramca)
    {
      int k = 0;
      AppMethodBeat.i(244498);
      bh.beI();
      Object localObject;
      int m;
      int i;
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        localObject = (ChattingItemTranslate.a)paramView.getTag();
        m = ((ChattingItemTranslate.a)localObject).position;
        if (((ChattingItemTranslate.a)localObject).viewType == 1) {
          if (((new p(paramca.field_content).time != 0L) || (paramca.field_isSend != 0)) && ((paramca.field_status != 1) || (paramca.field_isSend != 1)))
          {
            bh.beI();
            Boolean localBoolean = (Boolean)com.tencent.mm.model.c.aHp().b(26, null);
            localObject = localBoolean;
            if (localBoolean == null) {
              localObject = Boolean.FALSE;
            }
            if (!((Boolean)localObject).booleanValue()) {
              break label473;
            }
            paramo.a(m, 120, paramView.getContext().getString(R.l.chatfooter_SpeakerOff), R.k.icons_filled_volume_up);
            bh.beI();
            localObject = com.tencent.mm.model.c.bbL().RG(paramca.field_talker);
            if ((ab.Qy(paramca.field_talker)) || (ab.QX(paramca.field_talker)) || (localObject == null) || (((as)localObject).hxX())) {
              break label498;
            }
            i = 1;
            label202:
            if (com.tencent.mm.by.c.blP("favorite")) {
              paramo.a(m, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
            }
            if (i != 0)
            {
              if (af.bjv().vL(2) <= 0) {
                break label504;
              }
              i = 1;
              label251:
              if ((i != 0) && (!this.WBq.hRj())) {
                paramo.add(m, 114, 0, paramView.getContext().getString(R.l.evJ));
              }
            }
            localObject = (au)this.WBq.bC(au.class);
            if (!bk.d(paramca, this.WBq)) {
              break label510;
            }
            if (!Util.isNullOrNil(((au)localObject).ae(paramca.field_msgId, paramca.field_imgPath))) {
              break label725;
            }
            i = R.l.ewj;
          }
        }
      }
      label725:
      for (;;)
      {
        int j = k;
        if (ab.Qm(paramca.field_talker))
        {
          j = k;
          if (LocaleUtil.isChineseAppLang())
          {
            j = k;
            if (i != -1)
            {
              paramo.a(m, 121, paramView.getContext().getString(i), R.k.icons_filled_transfer_text);
              j = 1;
            }
          }
        }
        if (!this.WBq.hRj()) {
          paramo.a(m, 100, paramView.getContext().getString(R.l.evQ), R.k.icons_filled_delete);
        }
        if ((j == 0) && (LocaleUtil.isChineseAppLang()) && (i != -1)) {
          paramo.a(m, 121, paramView.getContext().getString(i), R.k.icons_filled_transfer_text);
        }
        AppMethodBeat.o(244498);
        return true;
        label473:
        paramo.a(m, 119, paramView.getContext().getString(R.l.chatfooter_SpeakerON), R.k.icons_filled_ear);
        break;
        label498:
        i = 0;
        break label202;
        label504:
        i = 0;
        break label251;
        label510:
        if (!((au)localObject).VO(paramca.field_msgId))
        {
          i = R.l.ewj;
          continue;
          if (((ChattingItemTranslate.a)localObject).viewType == 2)
          {
            localObject = (au)this.WBq.bC(au.class);
            if (((au)localObject).VN(paramca.field_msgId) == ChattingItemTranslate.c.Xlq) {
              paramo.add(m, 121, 0, R.l.ewf);
            }
            for (;;)
            {
              AppMethodBeat.o(244498);
              return false;
              if (!Util.isNullOrNil(((au)localObject).ae(paramca.field_msgId, paramca.field_imgPath)))
              {
                paramo.a(m, 141, paramView.getContext().getString(R.l.evK), R.k.icons_filled_copy);
                paramo.a(m, 142, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
                if (com.tencent.mm.by.c.blP("favorite")) {
                  paramo.a(m, 143, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
                }
              }
              paramo.a(m, 121, paramView.getContext().getString(R.l.ewh), R.k.icons_filled_eyes_off);
            }
          }
          AppMethodBeat.o(244498);
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
      AppMethodBeat.i(244504);
      if (paramca.field_status == 5)
      {
        paramView = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramca.field_msgId);
        paramView.hAe();
        p localp = new p(paramView.field_content);
        localp.mhL = false;
        paramView.setContent(localp.brC());
        paramView.setStatus(3);
        ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().a(paramca.field_msgId, paramView);
        paramView = com.tencent.mm.modelvoice.o.brz().GX(paramca.field_msgSvrId);
        if (paramView.lAW != 0) {
          break label222;
        }
      }
      label222:
      for (paramView.status = 5;; paramView.status = 6)
      {
        paramView.mhP = (System.currentTimeMillis() / 1000L);
        paramView.mla = 1;
        paramView.cUP = 1048896;
        s.a(paramView);
        ((ax)parama.bC(ax.class)).VV(paramca.field_msgId);
        com.tencent.mm.modelvoice.o.brB().run();
        com.tencent.e.h.ZvG.bc(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(276497);
            parama.cAe();
            AppMethodBeat.o(276497);
          }
        });
        Log.i("MicroMsg.ChattingItemVoice", "onStateBtnClick voice msg(%s) re-download!", new Object[] { Long.valueOf(paramca.field_msgId) });
        AppMethodBeat.o(244504);
        return;
      }
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(37470);
      boolean bool = parama.hRi();
      AppMethodBeat.o(37470);
      return bool;
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
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
      if (paramca.hAd())
      {
        ((ax)parama.bC(ax.class)).a(paramca.field_msgId, paramView);
        if (((ax)parama.bC(ax.class)).VW(paramca.field_msgId))
        {
          Log.i("MicroMsg.ChattingItemVoice", "onItemClick: voice msg show download animation");
          AppMethodBeat.o(37474);
          return true;
        }
        ca localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramca.field_msgId);
        if (localca.hAd())
        {
          ((ax)parama.bC(ax.class)).VV(localca.field_msgId);
          com.tencent.mm.modelvoice.o.brB().run();
          com.tencent.e.h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(198526);
              parama.cAe();
              AppMethodBeat.o(198526);
            }
          });
          Log.i("MicroMsg.ChattingItemVoice", "onItemClick voice msg(%s) no finish download!", new Object[] { Long.valueOf(paramca.field_msgId) });
          AppMethodBeat.o(37474);
          return true;
        }
      }
      ((ax)parama.bC(ax.class)).VX(paramca.field_msgId);
      ((ax)parama.bC(ax.class)).hQX();
      paramView = (by)paramView.getTag();
      com.tencent.mm.modelstat.b.mcf.am(paramView.fNz);
      bk.b(parama, paramView);
      ((au)parama.bC(au.class)).avH(2);
      ((av)parama.bC(av.class)).hQT();
      c(parama, paramca);
      if (((au)parama.bC(au.class)).cA(paramca)) {
        bh(4, paramca.field_msgId);
      }
      AppMethodBeat.o(37474);
      return true;
    }
    
    public final boolean hTD()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements t.n
  {
    private int Rem = 3;
    private com.tencent.mm.ui.chatting.e.a WBq;
    
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
        localObject = new aq(paramLayoutInflater, R.i.eeq);
        ((View)localObject).setTag(new bk.c().e((View)localObject, false, this.Wwx));
      }
      AppMethodBeat.o(37477);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final ca paramca, String paramString)
    {
      AppMethodBeat.i(37478);
      this.WBq = parama1;
      bk.c localc = (bk.c)parama;
      localc.XlN.setFromVoice(false);
      localc.XlN.setFromGroup(parama1.hRi());
      com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)parama1.bC(com.tencent.mm.ui.chatting.d.b.k.class);
      b(localk, paramca.field_msgId);
      bk.c.a(this, localc, paramca, paramInt, parama1, false, c(parama1), this);
      au localau = (au)parama1.bC(au.class);
      paramString = ChattingItemTranslate.c.Xlo;
      if (bk.d(paramca, parama1))
      {
        parama = localau.ae(paramca.field_msgId, paramca.field_imgPath);
        if (Util.isNullOrNil(parama)) {
          break label811;
        }
        paramString = ChattingItemTranslate.c.Xlr;
      }
      label681:
      label811:
      for (;;)
      {
        Object localObject;
        if ((!Util.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.c.Xlo))
        {
          if (localc.XgC == null)
          {
            localc.XgC = ((ChattingItemTranslate)localc.XgB.inflate());
            localc.XgC.setMinimumWidth(localc.XlK - com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 5));
            localc.XgC.init();
          }
          Context localContext = localc.XjK.getContext();
          int i = (int)localc.XgC.getContentView().getTextSize();
          if (paramca != null)
          {
            localObject = ad.Rp(paramca.field_msgSvrId);
            ad.b localb = ad.beh().I((String)localObject, true);
            localb.k("prePublishId", "msg_" + paramca.field_msgSvrId);
            localb.k("preUsername", a(this.WBq, paramca));
            localb.k("preChatName", b(this.WBq, paramca));
            label325:
            localObject = l.a(localContext, parama, i, null, (String)localObject);
            localc.XgC.a((CharSequence)localObject, paramString, localau.VR(paramca.field_msgId), ChattingItemTranslate.b.Xlm, paramca.field_msgId, parama1);
            if ((!Util.isNullOrNil((CharSequence)localObject)) && (localau.VR(paramca.field_msgId))) {
              localau.VS(paramca.field_msgId);
            }
            paramString = new ChattingItemTranslate.a(paramca, parama1.hRi(), paramInt);
            paramString.viewType = 2;
            localc.XgC.setTag(paramString);
            localc.XgC.setOnLongClickListener(c(parama1));
            localc.XgC.setVisibility(0);
            if (!Util.isNullOrNil(parama))
            {
              localc.XgC.setOnTouchListener(localk.hNO());
              localc.XgC.setOnDoubleClickListener(new NeatTextView.b()
              {
                public final boolean ie(View paramAnonymousView)
                {
                  AppMethodBeat.i(37475);
                  bk.c.a(MMApplicationContext.getContext(), parama, parama1);
                  bk.dj(paramca);
                  AppMethodBeat.o(37475);
                  return true;
                }
              });
            }
            label502:
            if (!hTG()) {
              break label767;
            }
            if (localc.XlT != null) {
              localc.XlT.setVisibility(8);
            }
            if (localc.XdI != null) {
              localc.XdI.setVisibility(8);
            }
            if ((paramca.field_status != 1) && (paramca.field_status != 5)) {
              break label681;
            }
            localc.XlU.setBackgroundResource(R.g.dnl);
            paramca.VGB = true;
          }
        }
        for (;;)
        {
          a(paramInt, localc, paramca, parama1.getSelfUserName(), parama1.hRi(), parama1, this);
          AppMethodBeat.o(37478);
          return;
          if (!localau.VO(paramca.field_msgId)) {
            break label806;
          }
          parama = localau.ae(paramca.field_msgId, paramca.field_imgPath);
          paramString = localau.VN(paramca.field_msgId);
          break;
          localObject = null;
          break label325;
          if (localc.XgC == null) {
            break label502;
          }
          localc.XgC.setVisibility(8);
          break label502;
          localc.XlU.setBackgroundResource(R.g.chatto_bg);
          if ((localc.XdI != null) && (b(localk, paramca.field_msgId)))
          {
            if (paramca.VGB)
            {
              parama = new AlphaAnimation(0.5F, 1.0F);
              parama.setDuration(300L);
              localc.XlU.startAnimation(parama);
              paramca.VGB = false;
            }
            localc.XdI.setVisibility(0);
            continue;
            label767:
            if (localc.XlT != null)
            {
              localc.XlT.setVisibility(0);
              if (paramca.field_status >= 2) {
                localc.XlT.setVisibility(8);
              }
            }
          }
        }
        parama = null;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(37480);
      Object localObject = (au)parama.bC(au.class);
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(37480);
        return false;
        ((ax)parama.bC(ax.class)).Gq(true);
        AppMethodBeat.o(37480);
        return true;
        ((ax)parama.bC(ax.class)).Gq(false);
        AppMethodBeat.o(37480);
        return true;
        if (!WeChatBrands.Business.Entries.SessionSpeech2TextSnd.checkAvailable(parama.WQv.getContext()))
        {
          AppMethodBeat.o(37480);
          return true;
        }
        boolean bool = bk.b(paramMenuItem.getGroupId(), parama, paramca, (au)localObject, false);
        AppMethodBeat.o(37480);
        return bool;
        paramMenuItem = ((au)localObject).ae(paramca.field_msgId, paramca.field_imgPath);
        if (!Util.isNullOrNil(paramMenuItem)) {
          ClipboardHelper.setText(paramMenuItem);
        }
        bk.f(8, paramca);
        AppMethodBeat.o(37480);
        return true;
        paramMenuItem = new Intent(parama.WQv.getContext(), MsgRetransmitUI.class);
        localObject = ((au)localObject).ae(paramca.field_msgId, paramca.field_imgPath);
        if (paramca.hzt())
        {
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bm(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          bk.f(9, paramca);
          AppMethodBeat.o(37480);
          return true;
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 4);
        }
        localObject = ((au)localObject).ae(paramca.field_msgId, paramca.field_imgPath);
        paramMenuItem = new dd();
        j.b(paramMenuItem, (String)localObject, 1);
        paramMenuItem.fyI.fragment = parama.WQv;
        paramMenuItem.fyI.fyP = 43;
        if (paramMenuItem.fyI.fyK != null)
        {
          parama = paramMenuItem.fyI.fyK.SAB;
          if (parama != null)
          {
            parama.btx(z.bcZ());
            parama.bty(paramca.field_talker);
            EventCenter.instance.publish(paramMenuItem);
          }
        }
        for (;;)
        {
          bk.f(10, paramca);
          AppMethodBeat.o(37480);
          return true;
          Log.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
        }
        ((ax)parama.bC(ax.class)).cF(paramca);
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.o paramo, View paramView, ca paramca)
    {
      int k = 0;
      AppMethodBeat.i(286313);
      bh.beI();
      Object localObject;
      int m;
      au localau;
      int i;
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        localObject = (ChattingItemTranslate.a)paramView.getTag();
        m = ((ChattingItemTranslate.a)localObject).position;
        if (((ChattingItemTranslate.a)localObject).viewType == 1)
        {
          localObject = new p(paramca.field_content);
          if (((((p)localObject).time != 0L) || (paramca.field_isSend != 0)) && ((paramca.field_status != 1) || (paramca.field_isSend != 1)))
          {
            if (((ax)this.WBq.bC(ax.class)).hQW()) {
              paramo.a(m, 120, paramView.getContext().getString(R.l.chatfooter_SpeakerOff), R.k.icons_filled_volume_up);
            }
          }
          else
          {
            if (paramca.field_status == 5) {
              paramo.a(m, 103, paramView.getContext().getString(R.l.ewJ), R.k.icons_filled_refresh);
            }
            if (com.tencent.mm.by.c.blP("favorite")) {
              paramo.a(m, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
            }
            if ((!paramca.hwA()) && (paramca.hwF()) && ((paramca.field_status == 2) || (paramca.ill == 1)) && (b(paramca, this.WBq)) && (bzE(paramca.field_talker))) {
              paramo.a(m, 123, paramView.getContext().getString(R.l.ewa), R.k.icons_filled_previous);
            }
            localau = (au)this.WBq.bC(au.class);
            if (!bk.d(paramca, this.WBq)) {
              break label512;
            }
            if (!Util.isNullOrNil(localau.ae(paramca.field_msgId, paramca.field_imgPath))) {
              break label727;
            }
            i = R.l.ewj;
          }
        }
      }
      for (;;)
      {
        int j = k;
        if (ab.Qm(paramca.field_talker))
        {
          j = k;
          if (LocaleUtil.isChineseAppLang())
          {
            j = k;
            if (i != -1)
            {
              paramo.a(m, 121, paramView.getContext().getString(i), R.k.icons_filled_transfer_text);
              j = 1;
            }
          }
        }
        if (((((p)localObject).time != 0L) || (paramca.field_isSend != 0)) && ((paramca.field_status != 1) || (paramca.field_isSend != 1)) && (!this.WBq.hRj())) {
          paramo.a(m, 100, paramView.getContext().getString(R.l.evQ), R.k.icons_filled_delete);
        }
        if ((j == 0) && (LocaleUtil.isChineseAppLang()) && (i != -1)) {
          paramo.a(m, 121, paramView.getContext().getString(i), R.k.icons_filled_transfer_text);
        }
        AppMethodBeat.o(286313);
        return true;
        paramo.a(m, 119, paramView.getContext().getString(R.l.chatfooter_SpeakerON), R.k.icons_filled_ear);
        break;
        label512:
        if (!localau.VO(paramca.field_msgId))
        {
          i = R.l.ewj;
          continue;
          if (((ChattingItemTranslate.a)localObject).viewType == 2)
          {
            localObject = (au)this.WBq.bC(au.class);
            if (((au)localObject).VN(paramca.field_msgId) == ChattingItemTranslate.c.Xlq) {
              paramo.add(m, 121, 0, R.l.ewf);
            }
            for (;;)
            {
              AppMethodBeat.o(286313);
              return false;
              if (!Util.isNullOrNil(((au)localObject).ae(paramca.field_msgId, paramca.field_imgPath)))
              {
                paramo.a(m, 141, paramView.getContext().getString(R.l.evK), R.k.icons_filled_copy);
                paramo.a(m, 142, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
                if (com.tencent.mm.by.c.blP("favorite")) {
                  paramo.a(m, 143, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
                }
              }
              paramo.a(m, 121, paramView.getContext().getString(R.l.ewh), R.k.icons_filled_eyes_off);
            }
          }
          AppMethodBeat.o(286313);
          return true;
        }
        else
        {
          label727:
          i = -1;
        }
      }
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
    {
      AppMethodBeat.i(286315);
      ((ax)parama.bC(ax.class)).cF(paramca);
      AppMethodBeat.o(286315);
    }
    
    public final boolean bZ(int paramInt, boolean paramBoolean)
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
      if (paramca.hAd())
      {
        ((ax)parama.bC(ax.class)).a(paramca.field_msgId, paramView);
        if (((ax)parama.bC(ax.class)).VW(paramca.field_msgId))
        {
          Log.i("MicroMsg.ChattingItemVoice", "onCreateContextMenu: voice msg show download animation");
          AppMethodBeat.o(37481);
          return true;
        }
        ca localca = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(paramca.field_msgId);
        if (localca.hAd())
        {
          ((ax)parama.bC(ax.class)).VV(localca.field_msgId);
          com.tencent.mm.modelvoice.o.brB().run();
          com.tencent.e.h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(270499);
              parama.cAe();
              AppMethodBeat.o(270499);
            }
          });
          Log.i("MicroMsg.ChattingItemVoice", "onItemClick voice msg(%s) no finish download!", new Object[] { Long.valueOf(paramca.field_msgId) });
          AppMethodBeat.o(37481);
          return true;
        }
      }
      ((ax)parama.bC(ax.class)).hQX();
      paramView = (by)paramView.getTag();
      com.tencent.mm.modelstat.b.mcf.am(paramView.fNz);
      bk.b(parama, paramView);
      ((au)parama.bC(au.class)).avH(2);
      ((av)parama.bC(av.class)).hQT();
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.comm.a.b.class)).asK(paramca.field_talker);
      AppMethodBeat.o(37481);
      return true;
    }
    
    public final boolean hTD()
    {
      return true;
    }
  }
  
  public static final class c
    extends c.a
  {
    ImageView XdI;
    TextView Xdu;
    ViewStub XgB;
    ChattingItemTranslate XgC;
    TextView XjK;
    int XlK;
    TextView XlL;
    TextView XlM;
    AnimImageView XlN;
    FrameLayout XlO;
    FrameLayout XlP;
    ImageView XlQ;
    ProgressBar XlR;
    AnimImageView XlS;
    ProgressBar XlT;
    TextView XlU;
    ImageView XlV;
    RelativeLayout XlW;
    TextView XlX;
    Animation XlY;
    
    private static int Wu(int paramInt)
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
      AppMethodBeat.i(291712);
      Intent localIntent = new Intent(paramContext, TextPreviewUI.class);
      localIntent.putExtra("key_chat_text", paramCharSequence);
      if (parama != null) {
        localIntent.putExtra("is_group_chat", parama.hRi());
      }
      paramCharSequence = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramCharSequence.aFh(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$VoiceItemHolder", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramCharSequence.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$VoiceItemHolder", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.la(paramContext);
      AppMethodBeat.o(291712);
    }
    
    private static void a(c paramc, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(37487);
      paramc.stateIV.setVisibility(paramInt2);
      paramc.XjK.setVisibility(paramInt2);
      paramc.XlO.setVisibility(paramInt2);
      if (paramBoolean)
      {
        paramc.XlS.setVisibility(paramInt1);
        paramc.Xdu.setVisibility(paramInt2);
        AppMethodBeat.o(37487);
        return;
      }
      if (paramc.XlU != null) {
        paramc.XlU.setVisibility(paramInt1);
      }
      AppMethodBeat.o(37487);
    }
    
    public static void a(c paramc, c paramc1, ca paramca, int paramInt, com.tencent.mm.ui.chatting.e.a parama, boolean paramBoolean, View.OnLongClickListener paramOnLongClickListener, t.n paramn)
    {
      AppMethodBeat.i(291710);
      if (paramc1 == null)
      {
        AppMethodBeat.o(291710);
        return;
      }
      p localp = new p(paramca.field_content);
      float f1 = s.GW(localp.time);
      d locald = ((ax)parama.bC(ax.class)).hQU();
      label150:
      label347:
      float f2;
      if ((locald != null) && (paramca.field_msgId == locald.WxA))
      {
        paramc1.XlN.setVisibility(0);
        paramc1.XlN.cjx();
        if (!((ax)parama.bC(ax.class)).VW(paramca.field_msgId)) {
          break label662;
        }
        Log.d("MicroMsg.ChattingItemVoice", "startDownloadAnim");
        if (paramc1.XlR != null)
        {
          paramc1.XlR.setVisibility(0);
          if (paramc1.XlM != null) {
            paramc1.XlM.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          }
        }
        if (paramca.field_isSend != 0) {
          break label1166;
        }
        if (paramca.field_status != 5) {
          break label753;
        }
        paramca.hAj();
        a(paramc1, 8, 0, true);
        paramc1.XlS.cTg();
        paramc1.XlS.setVisibility(8);
        paramc1.XjK.setVisibility(0);
        paramc1.XlK = com.tencent.mm.ci.a.fromDPToPix(parama.WQv.getContext(), Wu((int)f1));
        paramc1.XlM.setWidth(paramc1.XlK);
        paramc1.XjK.setText(parama.WQv.getMMResources().getString(R.l.eFR, new Object[] { Integer.valueOf((int)f1) }));
        paramc1.XlN.setWidth(com.tencent.mm.ci.a.fromDPToPix(parama.WQv.getContext(), Wu((int)f1)));
        if (paramc1.XlV == null) {
          break label1166;
        }
        paramc1.XlV.setVisibility(0);
        paramc1.XlV.setTag(new by(paramca, parama.hRi(), paramInt, "", '\000'));
        paramc1.XlV.setOnClickListener(paramc.a(parama, paramn));
        f2 = f1;
        if (1 != paramca.field_isSend) {
          break label1629;
        }
        if (paramca.field_status != 1) {
          break label1169;
        }
        paramca.hAj();
        a(paramc1, 0, 8, false);
        paramc1.XlP.setVisibility(8);
        paramc1.hTX();
        label393:
        paramc = ((com.tencent.mm.ui.chatting.d.b.c)parama.bC(com.tencent.mm.ui.chatting.d.b.c.class)).hOH();
        if (paramc != null)
        {
          if (!paramc.Rcb) {
            break label1636;
          }
          paramc1.XjK.setShadowLayer(2.0F, 1.2F, 1.2F, paramc.Rcc);
          label439:
          if (!paramc.Rcd) {
            break label1650;
          }
          paramc1.XjK.setBackgroundResource(R.g.dnk);
        }
        label456:
        paramc = new ChattingItemTranslate.a(paramca, parama.hRi(), paramInt);
        paramc1.XlM.setTag(paramc);
        paramc1.XlM.setOnClickListener(paramc1.chattingItem.d(parama));
        paramc1.XlM.setOnLongClickListener(paramOnLongClickListener);
        paramc1.XlM.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama.bC(com.tencent.mm.ui.chatting.d.b.k.class)).hNO());
        if ((paramca.hxx & 0x1) != 1) {
          break label1684;
        }
        paramc1.XlL.setVisibility(0);
        if (paramca.field_isSend != 0) {
          break label1661;
        }
        paramc1.XlN.setBackgroundResource(R.g.dmR);
        label562:
        if (!paramBoolean) {
          break label1736;
        }
        parama.getTalkerUserName();
      }
      for (;;)
      {
        paramc = ((com.tencent.mm.ui.chatting.d.b.f)parama.bC(com.tencent.mm.ui.chatting.d.b.f.class)).bzg(parama.getTalkerUserName());
        paramca = a.a.hJg();
        parama = paramc1.XlM;
        paramInt = (int)f1;
        if (paramc != null) {
          paramc.toString();
        }
        paramca.aK(parama, paramInt);
        paramc1.XjK.setContentDescription(" ");
        AppMethodBeat.o(291710);
        return;
        paramc1.XlN.setVisibility(8);
        paramc1.XlN.cTg();
        break;
        label662:
        Log.d("MicroMsg.ChattingItemVoice", "stopDownloadAnim");
        if (paramc1.XlR == null) {
          break label150;
        }
        paramc1.XlR.setVisibility(8);
        if (paramc1.XlM == null) {
          break label150;
        }
        if (paramBoolean)
        {
          paramc1.XlM.setCompoundDrawablesWithIntrinsicBounds(aw.bf(paramc1.XlM.getContext(), R.d.chatfrom_voice_playing_f3), null, null, null);
          break label150;
        }
        paramc1.XlM.setCompoundDrawablesWithIntrinsicBounds(null, null, paramc1.XlM.getContext().getResources().getDrawable(R.k.chatto_voice_playing), null);
        break label150;
        label753:
        if (localp.time == 0L)
        {
          paramca.hAj();
          a(paramc1, 8, 0, true);
          paramc1.XlS.cTg();
          paramc1.XlS.setVisibility(8);
          paramc1.stateIV.setVisibility(8);
          f2 = 0.0F;
          paramc1.XlK = com.tencent.mm.ci.a.fromDPToPix(parama.WQv.getContext(), Wu(0));
          paramc1.XlM.setWidth(paramc1.XlK);
          paramc1.XjK.setText(parama.WQv.getMMResources().getString(R.l.eFR, new Object[] { Integer.valueOf(0) }));
          paramc1.XlN.setWidth(com.tencent.mm.ci.a.fromDPToPix(parama.WQv.getContext(), Wu(0)));
          f1 = f2;
          if (paramc1.XlV == null) {
            break label347;
          }
          paramc1.XlV.setVisibility(8);
          f1 = f2;
          break label347;
        }
        if (localp.time == -1L)
        {
          paramca.hAj();
          a(paramc1, 8, 0, true);
          paramc1.XlS.cTg();
          paramc1.XlS.setVisibility(8);
          paramc1.XlK = 80;
          paramc1.XlM.setWidth(80);
          paramc1.XjK.setVisibility(8);
          paramc1.XlN.setWidth(com.tencent.mm.ci.a.fromDPToPix(parama.WQv.getContext(), Wu((int)f1)));
          if (paramc1.XlV == null) {
            break label1166;
          }
          paramc1.XlV.setVisibility(8);
          break label347;
        }
        paramca.hAj();
        a(paramc1, 8, 0, true);
        paramc1.XlS.cTg();
        paramc1.XlS.setVisibility(8);
        paramc1.XjK.setVisibility(0);
        paramc1.XlK = com.tencent.mm.ci.a.fromDPToPix(parama.WQv.getContext(), Wu((int)f1));
        paramc1.XlM.setWidth(paramc1.XlK);
        paramc1.XjK.setText(parama.WQv.getMMResources().getString(R.l.eFR, new Object[] { Integer.valueOf((int)f1) }));
        paramc1.XlN.setWidth(com.tencent.mm.ci.a.fromDPToPix(parama.WQv.getContext(), Wu((int)f1)));
        if (paramc1.XlV != null) {
          paramc1.XlV.setVisibility(8);
        }
        label1166:
        break label347;
        label1169:
        if (paramca.field_status == 5)
        {
          paramca.hAj();
          a(paramc1, 8, 0, false);
          paramc1.XlP.setVisibility(8);
          paramc1.XjK.setVisibility(0);
          paramc1.hTX();
          if (localp.time == 0L) {
            f1 = 0.0F;
          }
          paramc1.XlK = com.tencent.mm.ci.a.fromDPToPix(parama.WQv.getContext(), Wu((int)f1));
          paramc1.XlM.setWidth(paramc1.XlK);
          paramc1.XjK.setText(parama.WQv.getMMResources().getString(R.l.eFR, new Object[] { Integer.valueOf((int)f1) }));
          paramc1.XlN.setWidth(com.tencent.mm.ci.a.fromDPToPix(parama.WQv.getContext(), Wu((int)f1)));
          break label393;
        }
        if (localp.time == -1L)
        {
          paramca.hAj();
          a(paramc1, 8, 0, false);
          paramc1.XlM.setWidth(80);
          paramc1.XlK = 80;
          paramc1.XjK.setVisibility(8);
          paramc1.XlP.setVisibility(8);
          paramc1.XlN.setWidth(com.tencent.mm.ci.a.fromDPToPix(parama.WQv.getContext(), Wu((int)f1)));
          paramc1.hTX();
          break label393;
        }
        if (paramca.field_status == 7)
        {
          paramca.hAj();
          a(paramc1, 8, 8, false);
          paramc1.XjK.setVisibility(8);
          paramc1.XlP.setVisibility(0);
          paramc1.hTX();
          if (paramc1.XlQ != null)
          {
            paramc1.XlY = AnimationUtils.loadAnimation(paramc1.convertView.getContext(), R.a.djM);
            paramc1.XlQ.startAnimation(paramc1.XlY);
          }
          break label393;
        }
        paramca.hAj();
        a(paramc1, 8, 0, false);
        paramc1.XlP.setVisibility(8);
        paramc1.XjK.setVisibility(0);
        paramc1.hTX();
        if (localp.time == 0L) {
          f1 = 0.0F;
        }
        paramc1.XlK = com.tencent.mm.ci.a.fromDPToPix(parama.WQv.getContext(), Wu((int)f1));
        paramc1.XlM.setWidth(paramc1.XlK);
        paramc1.XjK.setText(parama.WQv.getMMResources().getString(R.l.eFR, new Object[] { Integer.valueOf((int)f1) }));
        paramc1.XlN.setWidth(com.tencent.mm.ci.a.fromDPToPix(parama.WQv.getContext(), Wu((int)f1)));
        f2 = f1;
        label1629:
        f1 = f2;
        break label393;
        label1636:
        paramc1.XjK.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        break label439;
        label1650:
        paramc1.XjK.setBackgroundColor(0);
        break label456;
        label1661:
        paramc1.XlU.setBackgroundResource(R.g.dnm);
        paramc1.XlN.setBackgroundResource(R.g.dnm);
        break label562;
        label1684:
        paramc1.XlL.setVisibility(8);
        if (paramca.field_isSend == 0)
        {
          paramc1.XlN.setBackgroundResource(R.g.chatfrom_bg);
          break label562;
        }
        paramc1.XlU.setBackgroundResource(R.g.chatto_bg);
        paramc1.XlN.setBackgroundResource(R.g.chatto_bg);
        break label562;
        label1736:
        parama.getSelfUserName();
      }
    }
    
    private void hTX()
    {
      AppMethodBeat.i(37486);
      if (this.XlY != null)
      {
        this.XlY.cancel();
        this.XlY = null;
      }
      AppMethodBeat.o(37486);
    }
    
    public final c.a e(View paramView, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(37483);
      super.create(paramView);
      this.timeTV = ((TextView)paramView.findViewById(R.h.dzs));
      this.userTV = ((TextView)paramView.findViewById(R.h.chatting_user_tv));
      this.XlM = ((TextView)paramView.findViewById(R.h.dzI));
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.dwZ));
      this.maskView = paramView.findViewById(R.h.dyD);
      this.stateIV = ((ImageView)paramView.findViewById(R.h.dzp));
      this.XjK = ((TextView)paramView.findViewById(R.h.chatting_content_itv));
      this.XlO = ((FrameLayout)paramView.findViewById(R.h.dzJ));
      this.XlR = ((ProgressBar)paramView.findViewById(R.h.dzF));
      this.XgB = ((ViewStub)paramView.findViewById(R.h.dXZ));
      this.XlL = ((TextView)paramView.findViewById(R.h.dzG));
      this.XlN = ((AnimImageView)paramView.findViewById(R.h.dzE));
      this.XlN.setType(1);
      if (paramBoolean1)
      {
        this.XlN.setFromVoice(true);
        this.XlN.setFromGroup(paramBoolean2);
        this.Xdu = ((TextView)paramView.findViewById(R.h.dwm));
        this.XlS = ((AnimImageView)paramView.findViewById(R.h.dzH));
        this.XlS.setFromVoice(true);
        this.XlS.setFromGroup(paramBoolean2);
        this.XlS.setType(0);
        this.XlV = ((ImageView)paramView.findViewById(R.h.dxE));
        this.XlW = ((RelativeLayout)paramView.findViewById(R.h.dxG));
        this.XlX = ((TextView)paramView.findViewById(R.h.dxF));
      }
      for (;;)
      {
        AppMethodBeat.o(37483);
        return this;
        this.XlP = ((FrameLayout)paramView.findViewById(R.h.dzO));
        this.XlQ = ((ImageView)paramView.findViewById(R.h.dzP));
        this.XlT = ((ProgressBar)paramView.findViewById(R.h.dzQ));
        this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.dYz));
        this.XlU = ((TextView)paramView.findViewById(R.h.dzR));
        this.XlN.setFromVoice(false);
        this.XlN.setFromGroup(paramBoolean2);
        this.XdI = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
      }
    }
    
    public final View getMainContainerView()
    {
      return this.XlO;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bk
 * JD-Core Version:    0.7.0.1
 */