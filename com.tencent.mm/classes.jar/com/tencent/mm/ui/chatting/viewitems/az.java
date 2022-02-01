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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.a;
import com.tencent.mm.g.a.gf;
import com.tencent.mm.g.b.a.dl;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelstat.b.b;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.d.b.ar;
import com.tencent.mm.ui.chatting.d.b.at;
import com.tencent.mm.ui.chatting.d.bf;
import com.tencent.mm.ui.chatting.t.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class az
{
  private static boolean a(final int paramInt, com.tencent.mm.ui.chatting.e.a parama, final bv parambv, final com.tencent.mm.ui.chatting.d.b.aq paramaq, boolean paramBoolean)
  {
    AppMethodBeat.i(187911);
    if (a(parama, parambv, 2131766902))
    {
      AppMethodBeat.o(187911);
      return true;
    }
    if (b(parama, parambv, 2131766902))
    {
      AppMethodBeat.o(187911);
      return true;
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(37465);
        Object localObject = this.KuD;
        bv localbv = parambv;
        com.tencent.mm.ui.chatting.d.b.aq localaq = (com.tencent.mm.ui.chatting.d.b.aq)((com.tencent.mm.ui.chatting.e.a)localObject).bh(com.tencent.mm.ui.chatting.d.b.aq.class);
        if ((localObject == null) || (localaq == null))
        {
          ae.e("MicroMsg.ChattingItemVoice", "alvinluo ui or ui.transformImp null");
          AppMethodBeat.o(37465);
          return;
        }
        int i;
        if (localaq.EC(localbv.field_msgId)) {
          i = 2;
        }
        for (;;)
        {
          ae.i("MicroMsg.ChattingItemVoice", "alvinluo TransformText report clickScene: %d, msgId: %d", new Object[] { Integer.valueOf(i), Long.valueOf(localbv.field_msgId) });
          localObject = new gf();
          ((gf)localObject).dsU.dsV = 1;
          ((gf)localObject).dsU.scene = i;
          ((gf)localObject).dsU.fileName = localbv.field_imgPath;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
          AppMethodBeat.o(37465);
          return;
          if (localaq.Ez(localbv.field_msgId)) {
            i = 3;
          } else if (!bu.isNullOrNil(localaq.O(localbv.field_msgId, localbv.field_imgPath))) {
            i = 5;
          } else {
            i = 1;
          }
        }
      }
    }, "voice_transform_text_report");
    if (paramaq.fJi()) {
      com.tencent.mm.ui.base.h.d(parama.Kkd.getContext(), parama.Kkd.getContext().getString(2131764777), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(187899);
          if (this.vAW) {
            s.aa(parambv);
          }
          paramaq.fJj();
          paramaq.a(parambv, true, paramInt, 0);
          AppMethodBeat.o(187899);
        }
      });
    }
    for (;;)
    {
      parama = com.tencent.mm.modelstat.b.iqT;
      if (parama.aLW()) {
        parama.a(parambv, b.b.iri, 0);
      }
      AppMethodBeat.o(187911);
      return true;
      if (paramBoolean) {
        s.aa(parambv);
      }
      paramaq.a(parambv, true, paramInt, 0);
    }
  }
  
  public static boolean a(com.tencent.mm.ui.chatting.e.a parama, bv parambv, int paramInt)
  {
    AppMethodBeat.i(187909);
    if (parambv == null)
    {
      AppMethodBeat.o(187909);
      return false;
    }
    boolean bool1;
    if (parambv.fwj()) {
      if (((at)parama.bh(at.class)).EF(parambv.field_msgId))
      {
        ae.i("MicroMsg.ChattingItemVoice", "onCreateContextMenu: voice msg is downloading.(1)");
        bool1 = true;
        bool2 = bool1;
        if (bool1)
        {
          ae.i("MicroMsg.ChattingItemVoice", "handleNoFinishDownloadVoiceMsg show alert!");
          com.tencent.mm.ui.base.h.a(parama.Kkd.getContext(), parama.Kkd.getContext().getString(paramInt), "", parama.Kkd.getContext().getString(2131766205), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = false)
    {
      AppMethodBeat.o(187909);
      return bool2;
      if (((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(parambv.field_msgId).fwj())
      {
        ae.i("MicroMsg.ChattingItemVoice", "onCreateContextMenu: voice msg is downloading.(2)");
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
    if ((com.tencent.mm.r.a.ch(parama.Kkd.getContext())) || (com.tencent.mm.r.a.cf(parama.Kkd.getContext())) || (com.tencent.mm.r.a.cj(parama.Kkd.getContext())))
    {
      ae.d("MicroMsg.ChattingItemVoice", "voip is running, not play voice");
      AppMethodBeat.o(37488);
      return;
    }
    bc.aCg();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      t.g(parama.Kkd.getContext(), parama.Kkd.getContentView());
      AppMethodBeat.o(37488);
      return;
    }
    Object localObject;
    bv localbv;
    int i;
    if ((parambk != null) && (parambk.dCi != null))
    {
      localObject = new p(parambk.dCi.field_content);
      if ((af.isNullOrNil(parambk.dCi.field_content)) || (((p)localObject).time == 0L))
      {
        Toast.makeText(parama.Kkd.getContext(), 2131757151, 0).show();
        AppMethodBeat.o(37488);
        return;
      }
      localObject = ((at)parama.bh(at.class)).fJn();
      if ((parama.bh(com.tencent.mm.ui.chatting.d.b.k.class) != null) && (localObject != null))
      {
        localbv = parambk.dCi;
        if (((at)parama.bh(at.class)).fJn().JTd != localbv.field_msgId)
        {
          parama = (com.tencent.mm.ui.chatting.d.b.aq)parama.bh(com.tencent.mm.ui.chatting.d.b.aq.class);
          if (!parama.EC(localbv.field_msgId)) {
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
        parama = new gf();
        parama.dsU.dsV = 1;
        parama.dsU.scene = i;
        parama.dsU.fileName = localbv.field_imgPath;
        com.tencent.mm.sdk.b.a.IvT.l(parama);
      }
      i = parambk.position;
      parama = parambk.dCi;
      if ((parama == null) || (!parama.ftf()))
      {
        AppMethodBeat.o(37488);
        return;
        label323:
        if (parama.Ez(localbv.field_msgId)) {
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
          ((com.tencent.mm.ui.chatting.d)localObject).fEH();
          bc.aCg();
          parambk = (Boolean)com.tencent.mm.model.c.ajA().get(4115, null);
          if ((parambk == null) || (!parambk.booleanValue()))
          {
            bc.aCg();
            com.tencent.mm.model.c.ajA().set(4115, Boolean.TRUE);
            ((com.tencent.mm.ui.chatting.d)localObject).fEM();
            ((com.tencent.mm.ui.chatting.d)localObject).JTg = t.a(((com.tencent.mm.ui.chatting.d)localObject).cXJ.Kkd.getActivity(), ((com.tencent.mm.ui.chatting.d)localObject).context.getString(2131757255), 4000L);
          }
          if ((((com.tencent.mm.ui.chatting.d)localObject).pEU.isPlaying()) && (parama.field_msgId == ((com.tencent.mm.ui.chatting.d)localObject).JTd))
          {
            ((com.tencent.mm.ui.chatting.d)localObject).JTm = true;
            ((com.tencent.mm.ui.chatting.d)localObject).apj();
            AppMethodBeat.o(37488);
            return;
          }
          ((com.tencent.mm.ui.chatting.d)localObject).aP(parama);
          if ((parama.field_isSend == 0) && (!s.Y(parama))) {
            ((com.tencent.mm.ui.chatting.d)localObject).adq(i + 1);
          }
          ((com.tencent.mm.ui.chatting.d)localObject).xV(true);
        }
        AppMethodBeat.o(37488);
        return;
      }
      i = 0;
    }
  }
  
  public static boolean b(com.tencent.mm.ui.chatting.e.a parama, bv parambv, int paramInt)
  {
    AppMethodBeat.i(187910);
    if ((parambv != null) && (parambv.field_status == 5))
    {
      ae.i("MicroMsg.ChattingItemVoice", "handleDownloadFailVoiceMsg show alert!");
      com.tencent.mm.ui.base.h.a(parama.Kkd.getContext(), parama.Kkd.getContext().getString(paramInt), "", parama.Kkd.getContext().getString(2131766205), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(187910);
      return true;
    }
    AppMethodBeat.o(187910);
    return false;
  }
  
  public static final class a
    extends c
  {
    private com.tencent.mm.ui.chatting.e.a JWz;
    private View.OnClickListener KCO;
    
    public static void aQ(int paramInt, long paramLong)
    {
      AppMethodBeat.i(187905);
      if (!bf.fJt())
      {
        AppMethodBeat.o(187905);
        return;
      }
      dl localdl = new dl();
      localdl.ehu = paramInt;
      localdl.nk(String.valueOf(paramLong));
      ae.d("MicroMsg.ChattingItemVoice", "%s", new Object[] { localdl.RD() });
      localdl.aLH();
      AppMethodBeat.o(187905);
    }
    
    public static void f(int paramInt, bv parambv)
    {
      AppMethodBeat.i(187904);
      if (parambv == null)
      {
        ae.i("MicroMsg.ChattingItemVoice", "msgInfo is null???");
        AppMethodBeat.o(187904);
        return;
      }
      aQ(paramInt, parambv.field_msgId);
      AppMethodBeat.o(187904);
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
        localObject = new ah(paramLayoutInflater, 2131493461);
        ((View)localObject).setTag(new az.c().d((View)localObject, true, this.JSi));
      }
      AppMethodBeat.o(37469);
      return localObject;
    }
    
    public final void a(final c.a parama, final int paramInt, final com.tencent.mm.ui.chatting.e.a parama1, final bv parambv, String paramString)
    {
      AppMethodBeat.i(37471);
      this.JWz = parama1;
      az.c localc = (az.c)parama;
      localc.KCV.setFromVoice(true);
      localc.KCV.setFromGroup(parama1.fJC());
      com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class);
      b(localk, parambv.field_msgId);
      az.c.a(localc, parambv, paramInt, parama1, true, c(parama1));
      parama = null;
      paramString = ChattingItemTranslate.b.KCw;
      final com.tencent.mm.ui.chatting.d.b.aq localaq = (com.tencent.mm.ui.chatting.d.b.aq)parama1.bh(com.tencent.mm.ui.chatting.d.b.aq.class);
      Object localObject;
      if (az.d(parambv, parama1))
      {
        localObject = localaq.O(parambv.field_msgId, parambv.field_imgPath);
        parama = (c.a)localObject;
        if (bu.isNullOrNil((String)localObject)) {
          break label990;
        }
        paramString = ChattingItemTranslate.b.KCz;
        parama = (c.a)localObject;
      }
      label337:
      label990:
      for (;;)
      {
        int i;
        if ((!bu.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.b.KCw))
        {
          if (localc.Kyv == null)
          {
            localc.Kyv = ((ChattingItemTranslate)localc.Kyu.inflate());
            localc.Kyv.setMinimumWidth(localc.KCS - com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 5));
            localc.Kyv.init();
          }
          Context localContext = localc.KBc.getContext();
          i = (int)localc.Kyv.getContentView().getTextSize();
          if (parambv != null)
          {
            localObject = z.Br(parambv.field_msgSvrId);
            z.b localb = z.aBG().F((String)localObject, true);
            localb.k("prePublishId", "msg_" + parambv.field_msgSvrId);
            localb.k("preUsername", b(this.JWz, parambv));
            localb.k("preChatName", c(this.JWz, parambv));
            localObject = com.tencent.mm.pluginsdk.ui.span.k.a(localContext, parama, i, 1, null, (String)localObject);
            localc.Kyv.a((CharSequence)localObject, paramString);
            paramString = new ChattingItemTranslate.a(parambv, parama1.fJC(), paramInt);
            paramString.oOD = 2;
            localc.Kyv.setTag(paramString);
            paramString = localc.Kyv;
            if (this.KCO == null) {
              this.KCO = new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(187902);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                  paramAnonymousView = (ChattingItemTranslate.a)((ChattingItemTranslate)paramAnonymousView).getTag();
                  if (((com.tencent.mm.ui.chatting.d.b.aq)az.a.a(az.a.this).bh(com.tencent.mm.ui.chatting.d.b.aq.class)).Ey(paramAnonymousView.dCi.field_msgId) == ChattingItemTranslate.b.KCy) {
                    ((com.tencent.mm.ui.chatting.d.b.aq)az.a.a(az.a.this).bh(com.tencent.mm.ui.chatting.d.b.aq.class)).a(paramAnonymousView.dCi, true, paramAnonymousView.position, 1);
                  }
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(187902);
                }
              };
            }
            paramString.setOnClickListener(this.KCO);
            localc.Kyv.setOnLongClickListener(c(parama1));
            localc.Kyv.setVisibility(0);
            if (!bu.isNullOrNil(parama))
            {
              localc.Kyv.setOnTouchListener(localk.fGw());
              localc.Kyv.setOnDoubleClickListener(new NeatTextView.b()
              {
                public final boolean gC(View paramAnonymousView)
                {
                  AppMethodBeat.i(37466);
                  az.c.f(ak.getContext(), parama);
                  az.cx(parambv);
                  AppMethodBeat.o(37466);
                  return true;
                }
              });
            }
            label493:
            if ((al.isDarkMode()) || (!((com.tencent.mm.ui.chatting.d.b.c)parama1.bh(com.tencent.mm.ui.chatting.d.b.c.class)).fHm())) {
              break label748;
            }
            localc.KDf.setBackgroundResource(2131235107);
            localc.KDf.setTextSize(0, com.tencent.mm.cb.a.ay(parama1.Kkd.getContext(), 2131165284));
            if (((at)parama1.bh(at.class)).EI(parambv.field_msgId)) {
              break label762;
            }
            localc.KDe.setVisibility(8);
            localc.KDe.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(187900);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                ae.i("MicroMsg.ChattingItemVoice", "voice fast trans text click");
                az.b(paramInt, parama1, parambv, localaq, true);
                az.a.f(2, parambv);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(187900);
              }
            });
            parama = new p(parambv.field_content);
            if (parama.time != 0L) {
              break label774;
            }
            localc.KuL.setVisibility(8);
          }
        }
        for (;;)
        {
          parama = parambv.fmn;
          if ((parama != null) && (parama.length() != 0)) {
            break label961;
          }
          localc.KvI.setVisibility(8);
          AppMethodBeat.o(37471);
          return;
          if (!localaq.Ez(parambv.field_msgId)) {
            break label990;
          }
          parama = localaq.O(parambv.field_msgId, parambv.field_imgPath);
          paramString = localaq.Ey(parambv.field_msgId);
          break;
          localObject = null;
          break label337;
          if (localc.Kyv == null) {
            break label493;
          }
          localc.Kyv.setVisibility(8);
          break label493;
          label748:
          localc.KDf.setBackgroundResource(2131235104);
          break label528;
          label762:
          localc.KDe.setVisibility(0);
          break label584;
          paramString = ((at)parama1.bh(at.class)).fJn();
          if (((paramString != null) && (paramString.JTd == parambv.field_msgId)) || (s.Y(parambv)))
          {
            paramInt = 1;
            paramString = localc.KuL;
            if (paramInt == 0) {
              break label900;
            }
          }
          for (i = 8;; i = 0)
          {
            paramString.setVisibility(i);
            i = (int)s.sI(parama.time);
            if (paramInt != 0) {
              break label906;
            }
            localc.KCU.setContentDescription(String.format(parama1.Kkd.getContext().getString(2131764732), new Object[] { Integer.valueOf(i) }));
            break;
            paramInt = 0;
            break label820;
          }
          parama = ((com.tencent.mm.ui.chatting.d.b.f)parama1.bh(com.tencent.mm.ui.chatting.d.b.f.class)).aXB(parama1.getTalkerUserName());
          paramString = a.a.fCh();
          localObject = localc.KCU;
          if (parama != null) {
            parama.toString();
          }
          paramString.aA((View)localObject, i);
        }
        localc.KvI.setVisibility(0);
        b(parama1, localc.KvI, bk.aYj(parama));
        AppMethodBeat.o(37471);
        return;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(37473);
      Object localObject = (com.tencent.mm.ui.chatting.d.b.aq)parama.bh(com.tencent.mm.ui.chatting.d.b.aq.class);
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(37473);
        return false;
        ((at)parama.bh(at.class)).yg(true);
        AppMethodBeat.o(37473);
        return true;
        ((at)parama.bh(at.class)).yg(false);
        AppMethodBeat.o(37473);
        return true;
        f(3, parambv);
        boolean bool = az.b(paramMenuItem.getGroupId(), parama, parambv, (com.tencent.mm.ui.chatting.d.b.aq)localObject, true);
        AppMethodBeat.o(37473);
        return bool;
        paramMenuItem = (ClipboardManager)ak.getContext().getSystemService("clipboard");
        parama = ((com.tencent.mm.ui.chatting.d.b.aq)localObject).O(parambv.field_msgId, parambv.field_imgPath);
        if (!bu.isNullOrNil(parama)) {
          paramMenuItem.setText(parama);
        }
        az.e(8, parambv);
        continue;
        paramMenuItem = new Intent(parama.Kkd.getContext(), MsgRetransmitUI.class);
        localObject = ((com.tencent.mm.ui.chatting.d.b.aq)localObject).O(parambv.field_msgId, parambv.field_imgPath);
        if (parambv.fvz())
        {
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          az.e(9, parambv);
          break;
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 4);
        }
        localObject = ((com.tencent.mm.ui.chatting.d.b.aq)localObject).O(parambv.field_msgId, parambv.field_imgPath);
        paramMenuItem = new cw();
        com.tencent.mm.pluginsdk.model.g.b(paramMenuItem, (String)localObject, 1);
        paramMenuItem.doL.fragment = parama.Kkd;
        paramMenuItem.doL.doR = 43;
        if (paramMenuItem.doL.doN != null)
        {
          parama = paramMenuItem.doL.doN.GCe;
          if (parama != null)
          {
            parama.aQC(parambv.field_talker);
            parama.aQD(v.aAC());
            com.tencent.mm.sdk.b.a.IvT.l(paramMenuItem);
          }
        }
        for (;;)
        {
          az.e(10, parambv);
          break;
          ae.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
        }
        ((at)parama.bh(at.class)).bV(parambv);
        ((at)parama.bh(at.class)).fJr();
        continue;
        ((at)parama.bh(at.class)).bW(parambv);
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bv parambv)
    {
      int k = 0;
      AppMethodBeat.i(187903);
      bc.aCg();
      Object localObject;
      int m;
      int i;
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        localObject = (ChattingItemTranslate.a)paramView.getTag();
        m = ((ChattingItemTranslate.a)localObject).position;
        if (((ChattingItemTranslate.a)localObject).oOD == 1) {
          if (((new p(parambv.field_content).time != 0L) || (parambv.field_isSend != 0)) && ((parambv.field_status != 1) || (parambv.field_isSend != 1)))
          {
            bc.aCg();
            Boolean localBoolean = (Boolean)com.tencent.mm.model.c.ajA().get(26, null);
            localObject = localBoolean;
            if (localBoolean == null) {
              localObject = Boolean.FALSE;
            }
            if (!((Boolean)localObject).booleanValue()) {
              break label473;
            }
            paraml.a(m, 120, paramView.getContext().getString(2131757073), 2131690499);
            bc.aCg();
            localObject = com.tencent.mm.model.c.azF().BH(parambv.field_talker);
            if ((x.AA(parambv.field_talker)) || (x.AZ(parambv.field_talker)) || (localObject == null) || (((an)localObject).fug())) {
              break label498;
            }
            i = 1;
            label202:
            if (com.tencent.mm.br.d.aJN("favorite")) {
              paraml.a(m, 116, paramView.getContext().getString(2131761941), 2131690400);
            }
            if (i != 0)
            {
              if (ag.aGp().pa(2) <= 0) {
                break label504;
              }
              i = 1;
              label251:
              if ((i != 0) && (!this.JWz.fJD())) {
                paraml.add(m, 114, 0, paramView.getContext().getString(2131757217));
              }
            }
            localObject = (com.tencent.mm.ui.chatting.d.b.aq)this.JWz.bh(com.tencent.mm.ui.chatting.d.b.aq.class);
            if (!az.d(parambv, this.JWz)) {
              break label510;
            }
            if (!bu.isNullOrNil(((com.tencent.mm.ui.chatting.d.b.aq)localObject).O(parambv.field_msgId, parambv.field_imgPath))) {
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
        if (x.Ao(parambv.field_talker))
        {
          j = k;
          if (ad.foi())
          {
            j = k;
            if (i != -1)
            {
              paraml.a(m, 121, paramView.getContext().getString(i), 2131690490);
              j = 1;
            }
          }
        }
        if (!this.JWz.fJD()) {
          paraml.a(m, 100, paramView.getContext().getString(2131757223), 2131690384);
        }
        if ((j == 0) && (ad.foi()) && (i != -1)) {
          paraml.a(m, 121, paramView.getContext().getString(i), 2131690490);
        }
        AppMethodBeat.o(187903);
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
        if (!((com.tencent.mm.ui.chatting.d.b.aq)localObject).Ez(parambv.field_msgId))
        {
          i = 2131757243;
          continue;
          if (((ChattingItemTranslate.a)localObject).oOD == 2)
          {
            localObject = (com.tencent.mm.ui.chatting.d.b.aq)this.JWz.bh(com.tencent.mm.ui.chatting.d.b.aq.class);
            if (((com.tencent.mm.ui.chatting.d.b.aq)localObject).Ey(parambv.field_msgId) == ChattingItemTranslate.b.KCy) {
              paraml.add(m, 121, 0, 2131757239);
            }
            for (;;)
            {
              AppMethodBeat.o(187903);
              return false;
              if (!bu.isNullOrNil(((com.tencent.mm.ui.chatting.d.b.aq)localObject).O(parambv.field_msgId, parambv.field_imgPath)))
              {
                paraml.a(m, 141, paramView.getContext().getString(2131757218), 2131690381);
                paraml.a(m, 142, paramView.getContext().getString(2131762559), 2131690478);
                if (com.tencent.mm.br.d.aJN("favorite")) {
                  paraml.a(m, 143, paramView.getContext().getString(2131761941), 2131690400);
                }
              }
              paraml.a(m, 121, paramView.getContext().getString(2131757241), 2131690398);
            }
          }
          AppMethodBeat.o(187903);
          return true;
        }
        else
        {
          i = -1;
        }
      }
    }
    
    public final boolean b(View paramView, final com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(37474);
      if (parambv.field_status == 5)
      {
        ae.i("MicroMsg.ChattingItemVoice", "onItemClick msg(%s) fail", new Object[] { Long.valueOf(parambv.field_msgId) });
        AppMethodBeat.o(37474);
        return true;
      }
      if (parambv.fwj())
      {
        ((at)parama.bh(at.class)).a(parambv.field_msgId, paramView);
        if (((at)parama.bh(at.class)).EF(parambv.field_msgId))
        {
          ae.i("MicroMsg.ChattingItemVoice", "onCreateContextMenu: voice msg show download animation");
          AppMethodBeat.o(37474);
          return true;
        }
        bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(parambv.field_msgId);
        if (localbv.fwj())
        {
          ((at)parama.bh(at.class)).EE(localbv.field_msgId);
          o.aNY().run();
          com.tencent.e.h.MqF.aM(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(187901);
              parama.bPl();
              AppMethodBeat.o(187901);
            }
          });
          ae.i("MicroMsg.ChattingItemVoice", "onItemClick voice msg(%s) no finish download!", new Object[] { Long.valueOf(parambv.field_msgId) });
          AppMethodBeat.o(37474);
          return true;
        }
      }
      ((at)parama.bh(at.class)).EG(parambv.field_msgId);
      ((at)parama.bh(at.class)).fJq();
      paramView = (bk)paramView.getTag();
      com.tencent.mm.modelstat.b.iqT.U(paramView.dCi);
      az.b(parama, paramView);
      ((com.tencent.mm.ui.chatting.d.b.aq)parama.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).adV(2);
      ((ar)parama.bh(ar.class)).fJm();
      com.tencent.mm.al.l.I(parambv);
      if (((com.tencent.mm.ui.chatting.d.b.aq)parama.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).bR(parambv)) {
        aQ(4, parambv.field_msgId);
      }
      AppMethodBeat.o(37474);
      return true;
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.e.a parama)
    {
      AppMethodBeat.i(37470);
      boolean bool = parama.fJC();
      AppMethodBeat.o(37470);
      return bool;
    }
    
    public final boolean br(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 34);
    }
    
    public final boolean fLz()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements t.n
  {
    private int FmN = 3;
    private com.tencent.mm.ui.chatting.e.a JWz;
    
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
        ((View)localObject).setTag(new az.c().d((View)localObject, false, this.JSi));
      }
      AppMethodBeat.o(37477);
      return localObject;
    }
    
    public final void a(com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(37482);
      ((at)parama.bh(at.class)).bW(parambv);
      AppMethodBeat.o(37482);
    }
    
    public final void a(final c.a parama, int paramInt, com.tencent.mm.ui.chatting.e.a parama1, final bv parambv, String paramString)
    {
      AppMethodBeat.i(37478);
      this.JWz = parama1;
      az.c localc = (az.c)parama;
      localc.KCV.setFromVoice(false);
      localc.KCV.setFromGroup(parama1.fJC());
      com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)parama1.bh(com.tencent.mm.ui.chatting.d.b.k.class);
      b(localk, parambv.field_msgId);
      az.c.a(localc, parambv, paramInt, parama1, false, c(parama1));
      Object localObject = (com.tencent.mm.ui.chatting.d.b.aq)parama1.bh(com.tencent.mm.ui.chatting.d.b.aq.class);
      parama = null;
      paramString = ChattingItemTranslate.b.KCw;
      if (az.d(parambv, parama1))
      {
        localObject = ((com.tencent.mm.ui.chatting.d.b.aq)localObject).O(parambv.field_msgId, parambv.field_imgPath);
        parama = (c.a)localObject;
        if (bu.isNullOrNil((String)localObject)) {
          break label758;
        }
        paramString = ChattingItemTranslate.b.KCz;
        parama = (c.a)localObject;
      }
      label333:
      label719:
      label758:
      for (;;)
      {
        if ((!bu.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.b.KCw))
        {
          if (localc.Kyv == null)
          {
            localc.Kyv = ((ChattingItemTranslate)localc.Kyu.inflate());
            localc.Kyv.setMinimumWidth(localc.KCS - com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 5));
            localc.Kyv.init();
          }
          Context localContext = localc.KBc.getContext();
          int i = (int)localc.Kyv.getContentView().getTextSize();
          if (parambv != null)
          {
            localObject = z.Br(parambv.field_msgSvrId);
            z.b localb = z.aBG().F((String)localObject, true);
            localb.k("prePublishId", "msg_" + parambv.field_msgSvrId);
            localb.k("preUsername", b(this.JWz, parambv));
            localb.k("preChatName", c(this.JWz, parambv));
            localObject = com.tencent.mm.pluginsdk.ui.span.k.a(localContext, parama, i, 1, null, (String)localObject);
            localc.Kyv.a((CharSequence)localObject, paramString);
            paramString = new ChattingItemTranslate.a(parambv, parama1.fJC(), paramInt);
            paramString.oOD = 2;
            localc.Kyv.setTag(paramString);
            localc.Kyv.setOnLongClickListener(c(parama1));
            localc.Kyv.setVisibility(0);
            if (!bu.isNullOrNil(parama))
            {
              localc.Kyv.setOnTouchListener(localk.fGw());
              localc.Kyv.setOnDoubleClickListener(new NeatTextView.b()
              {
                public final boolean gC(View paramAnonymousView)
                {
                  AppMethodBeat.i(37475);
                  az.c.f(ak.getContext(), parama);
                  az.cx(parambv);
                  AppMethodBeat.o(37475);
                  return true;
                }
              });
            }
            if (!fLB()) {
              break label719;
            }
            if (localc.KDb != null) {
              localc.KDb.setVisibility(8);
            }
            if (localc.KvW != null) {
              localc.KvW.setVisibility(8);
            }
            if ((parambv.field_status != 1) && (parambv.field_status != 5)) {
              break label633;
            }
            localc.KDc.setBackgroundResource(2131231726);
            parambv.JgO = true;
          }
        }
        for (;;)
        {
          a(paramInt, localc, parambv, parama1.fJy(), parama1.fJC(), parama1, this);
          AppMethodBeat.o(37478);
          return;
          if (!((com.tencent.mm.ui.chatting.d.b.aq)localObject).Ez(parambv.field_msgId)) {
            break label758;
          }
          parama = ((com.tencent.mm.ui.chatting.d.b.aq)localObject).O(parambv.field_msgId, parambv.field_imgPath);
          paramString = ((com.tencent.mm.ui.chatting.d.b.aq)localObject).Ey(parambv.field_msgId);
          break;
          localObject = null;
          break label333;
          if (localc.Kyv == null) {
            break label454;
          }
          localc.Kyv.setVisibility(8);
          break label454;
          label633:
          localc.KDc.setBackgroundResource(2131231725);
          if ((localc.KvW != null) && (b(localk, parambv.field_msgId)))
          {
            if (parambv.JgO)
            {
              parama = new AlphaAnimation(0.5F, 1.0F);
              parama.setDuration(300L);
              localc.KDc.startAnimation(parama);
              parambv.JgO = false;
            }
            localc.KvW.setVisibility(0);
            continue;
            if (localc.KDb != null)
            {
              localc.KDb.setVisibility(0);
              if (parambv.field_status >= 2) {
                localc.KDb.setVisibility(8);
              }
            }
          }
        }
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(37480);
      Object localObject = (com.tencent.mm.ui.chatting.d.b.aq)parama.bh(com.tencent.mm.ui.chatting.d.b.aq.class);
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(37480);
        return false;
        ((at)parama.bh(at.class)).yg(true);
        AppMethodBeat.o(37480);
        return true;
        ((at)parama.bh(at.class)).yg(false);
        AppMethodBeat.o(37480);
        return true;
        boolean bool = az.b(paramMenuItem.getGroupId(), parama, parambv, (com.tencent.mm.ui.chatting.d.b.aq)localObject, false);
        AppMethodBeat.o(37480);
        return bool;
        paramMenuItem = (ClipboardManager)ak.getContext().getSystemService("clipboard");
        parama = ((com.tencent.mm.ui.chatting.d.b.aq)localObject).O(parambv.field_msgId, parambv.field_imgPath);
        if (!bu.isNullOrNil(parama)) {
          paramMenuItem.setText(parama);
        }
        az.e(8, parambv);
        AppMethodBeat.o(37480);
        return true;
        paramMenuItem = new Intent(parama.Kkd.getContext(), MsgRetransmitUI.class);
        localObject = ((com.tencent.mm.ui.chatting.d.b.aq)localObject).O(parambv.field_msgId, parambv.field_imgPath);
        if (parambv.fvz())
        {
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.a(parama, paramMenuItem.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          az.e(9, parambv);
          AppMethodBeat.o(37480);
          return true;
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 4);
        }
        localObject = ((com.tencent.mm.ui.chatting.d.b.aq)localObject).O(parambv.field_msgId, parambv.field_imgPath);
        paramMenuItem = new cw();
        com.tencent.mm.pluginsdk.model.g.b(paramMenuItem, (String)localObject, 1);
        paramMenuItem.doL.fragment = parama.Kkd;
        paramMenuItem.doL.doR = 43;
        if (paramMenuItem.doL.doN != null)
        {
          parama = paramMenuItem.doL.doN.GCe;
          if (parama != null)
          {
            parama.aQC(v.aAC());
            parama.aQD(parambv.field_talker);
            com.tencent.mm.sdk.b.a.IvT.l(paramMenuItem);
          }
        }
        for (;;)
        {
          az.e(10, parambv);
          AppMethodBeat.o(37480);
          return true;
          ae.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
        }
        ((at)parama.bh(at.class)).bW(parambv);
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.l paraml, View paramView, bv parambv)
    {
      int k = 0;
      AppMethodBeat.i(187907);
      bc.aCg();
      Object localObject;
      int m;
      com.tencent.mm.ui.chatting.d.b.aq localaq;
      int i;
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        localObject = (ChattingItemTranslate.a)paramView.getTag();
        m = ((ChattingItemTranslate.a)localObject).position;
        if (((ChattingItemTranslate.a)localObject).oOD == 1)
        {
          localObject = new p(parambv.field_content);
          if (((((p)localObject).time != 0L) || (parambv.field_isSend != 0)) && ((parambv.field_status != 1) || (parambv.field_isSend != 1)))
          {
            if (((at)this.JWz.bh(at.class)).fJp()) {
              paraml.a(m, 120, paramView.getContext().getString(2131757073), 2131690499);
            }
          }
          else
          {
            if (parambv.field_status == 5) {
              paraml.a(m, 103, paramView.getContext().getString(2131757286), 2131690467);
            }
            if (com.tencent.mm.br.d.aJN("favorite")) {
              paraml.a(m, 116, paramView.getContext().getString(2131761941), 2131690400);
            }
            if ((!parambv.fta()) && (parambv.ftf()) && ((parambv.field_status == 2) || (parambv.fmr == 1)) && (b(parambv, this.JWz)) && (aYa(parambv.field_talker))) {
              paraml.a(m, 123, paramView.getContext().getString(2131757234), 2131690462);
            }
            localaq = (com.tencent.mm.ui.chatting.d.b.aq)this.JWz.bh(com.tencent.mm.ui.chatting.d.b.aq.class);
            if (!az.d(parambv, this.JWz)) {
              break label512;
            }
            if (!bu.isNullOrNil(localaq.O(parambv.field_msgId, parambv.field_imgPath))) {
              break label727;
            }
            i = 2131757243;
          }
        }
      }
      for (;;)
      {
        int j = k;
        if (x.Ao(parambv.field_talker))
        {
          j = k;
          if (ad.foi())
          {
            j = k;
            if (i != -1)
            {
              paraml.a(m, 121, paramView.getContext().getString(2131757243), 2131690490);
              j = 1;
            }
          }
        }
        if (((((p)localObject).time != 0L) || (parambv.field_isSend != 0)) && ((parambv.field_status != 1) || (parambv.field_isSend != 1)) && (!this.JWz.fJD())) {
          paraml.a(m, 100, paramView.getContext().getString(2131757223), 2131690384);
        }
        if ((j == 0) && (ad.foi()) && (i != -1)) {
          paraml.a(m, 121, paramView.getContext().getString(i), 2131690490);
        }
        AppMethodBeat.o(187907);
        return true;
        paraml.a(m, 119, paramView.getContext().getString(2131757072), 2131690395);
        break;
        label512:
        if (!localaq.Ez(parambv.field_msgId))
        {
          i = 2131757243;
          continue;
          if (((ChattingItemTranslate.a)localObject).oOD == 2)
          {
            localObject = (com.tencent.mm.ui.chatting.d.b.aq)this.JWz.bh(com.tencent.mm.ui.chatting.d.b.aq.class);
            if (((com.tencent.mm.ui.chatting.d.b.aq)localObject).Ey(parambv.field_msgId) == ChattingItemTranslate.b.KCy) {
              paraml.add(m, 121, 0, 2131757239);
            }
            for (;;)
            {
              AppMethodBeat.o(187907);
              return false;
              if (!bu.isNullOrNil(((com.tencent.mm.ui.chatting.d.b.aq)localObject).O(parambv.field_msgId, parambv.field_imgPath)))
              {
                paraml.a(m, 141, paramView.getContext().getString(2131757218), 2131690381);
                paraml.a(m, 142, paramView.getContext().getString(2131762559), 2131690478);
                if (com.tencent.mm.br.d.aJN("favorite")) {
                  paraml.a(m, 143, paramView.getContext().getString(2131761941), 2131690400);
                }
              }
              paraml.a(m, 121, paramView.getContext().getString(2131757241), 2131690398);
            }
          }
          AppMethodBeat.o(187907);
          return true;
        }
        else
        {
          label727:
          i = -1;
        }
      }
    }
    
    public final boolean b(View paramView, final com.tencent.mm.ui.chatting.e.a parama, bv parambv)
    {
      AppMethodBeat.i(37481);
      if (parambv.field_status == 5)
      {
        ae.i("MicroMsg.ChattingItemVoice", "onItemClick msg(%s) fail", new Object[] { Long.valueOf(parambv.field_msgId) });
        AppMethodBeat.o(37481);
        return true;
      }
      if (parambv.fwj())
      {
        ((at)parama.bh(at.class)).a(parambv.field_msgId, paramView);
        if (((at)parama.bh(at.class)).EF(parambv.field_msgId))
        {
          ae.i("MicroMsg.ChattingItemVoice", "onCreateContextMenu: voice msg show download animation");
          AppMethodBeat.o(37481);
          return true;
        }
        bv localbv = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ys(parambv.field_msgId);
        if (localbv.fwj())
        {
          ((at)parama.bh(at.class)).EE(localbv.field_msgId);
          o.aNY().run();
          com.tencent.e.h.MqF.aM(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(187906);
              parama.bPl();
              AppMethodBeat.o(187906);
            }
          });
          ae.i("MicroMsg.ChattingItemVoice", "onItemClick voice msg(%s) no finish download!", new Object[] { Long.valueOf(parambv.field_msgId) });
          AppMethodBeat.o(37481);
          return true;
        }
      }
      ((at)parama.bh(at.class)).fJq();
      paramView = (bk)paramView.getTag();
      com.tencent.mm.modelstat.b.iqT.U(paramView.dCi);
      az.b(parama, paramView);
      ((com.tencent.mm.ui.chatting.d.b.aq)parama.bh(com.tencent.mm.ui.chatting.d.b.aq.class)).adV(2);
      ((ar)parama.bh(ar.class)).fJm();
      ((com.tencent.mm.plugin.comm.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.comm.a.b.class)).aaK(parambv.field_talker);
      AppMethodBeat.o(37481);
      return true;
    }
    
    public final boolean br(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 34);
    }
    
    public final boolean fLz()
    {
      return true;
    }
  }
  
  public static final class c
    extends c.a
  {
    TextView KBc;
    int KCS;
    TextView KCT;
    TextView KCU;
    AnimImageView KCV;
    FrameLayout KCW;
    FrameLayout KCX;
    ImageView KCY;
    ProgressBar KCZ;
    AnimImageView KDa;
    ProgressBar KDb;
    TextView KDc;
    ImageView KDd;
    RelativeLayout KDe;
    TextView KDf;
    Animation KDg;
    TextView KvI;
    ImageView KvW;
    ViewStub Kyu;
    ChattingItemTranslate Kyv;
    
    private static int Kg(int paramInt)
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
      paramc.KuL.setVisibility(paramInt2);
      paramc.KBc.setVisibility(paramInt2);
      paramc.KCW.setVisibility(paramInt2);
      if (paramBoolean)
      {
        paramc.KDa.setVisibility(paramInt1);
        paramc.KvI.setVisibility(paramInt2);
        AppMethodBeat.o(37487);
        return;
      }
      if (paramc.KDc != null) {
        paramc.KDc.setVisibility(paramInt1);
      }
      AppMethodBeat.o(37487);
    }
    
    public static void a(c paramc, bv parambv, int paramInt, com.tencent.mm.ui.chatting.e.a parama, boolean paramBoolean, View.OnLongClickListener paramOnLongClickListener)
    {
      AppMethodBeat.i(187908);
      if (paramc == null)
      {
        AppMethodBeat.o(187908);
        return;
      }
      Object localObject = new p(parambv.field_content);
      float f1 = s.sI(((p)localObject).time);
      com.tencent.mm.ui.chatting.d locald = ((at)parama.bh(at.class)).fJn();
      label148:
      label296:
      float f2;
      if ((locald != null) && (parambv.field_msgId == locald.JTd))
      {
        paramc.KCV.setVisibility(0);
        paramc.KCV.bzX();
        if (!((at)parama.bh(at.class)).EF(parambv.field_msgId)) {
          break label602;
        }
        ae.d("MicroMsg.ChattingItemVoice", "startDownloadAnim");
        if (paramc.KCZ != null)
        {
          paramc.KCZ.setVisibility(0);
          if (paramc.KCU != null) {
            paramc.KCU.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          }
        }
        if (parambv.field_isSend != 0) {
          break label1082;
        }
        if (parambv.field_status != 5) {
          break label693;
        }
        a(paramc, 8, 0, true);
        paramc.KDa.cgN();
        paramc.KDa.setVisibility(8);
        paramc.KBc.setVisibility(0);
        paramc.KCS = com.tencent.mm.cb.a.fromDPToPix(parama.Kkd.getContext(), Kg((int)f1));
        paramc.KCU.setWidth(paramc.KCS);
        paramc.KBc.setText(parama.Kkd.getMMResources().getString(2131759570, new Object[] { Integer.valueOf((int)f1) }));
        paramc.KCV.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.Kkd.getContext(), Kg((int)f1)));
        if (paramc.KDd == null) {
          break label1082;
        }
        paramc.KDd.setVisibility(0);
        f2 = f1;
        if (1 != parambv.field_isSend) {
          break label1516;
        }
        if (parambv.field_status != 1) {
          break label1085;
        }
        a(paramc, 0, 8, false);
        paramc.KCX.setVisibility(8);
        paramc.fLO();
        label337:
        localObject = ((com.tencent.mm.ui.chatting.d.b.c)parama.bh(com.tencent.mm.ui.chatting.d.b.c.class)).fHl();
        if (localObject != null)
        {
          if (!((com.tencent.mm.pluginsdk.ui.f)localObject).FkE) {
            break label1523;
          }
          paramc.KBc.setShadowLayer(2.0F, 1.2F, 1.2F, ((com.tencent.mm.pluginsdk.ui.f)localObject).FkF);
          label383:
          if (!((com.tencent.mm.pluginsdk.ui.f)localObject).FkG) {
            break label1537;
          }
          paramc.KBc.setBackgroundResource(2131231724);
        }
        label400:
        localObject = new ChattingItemTranslate.a(parambv, parama.fJC(), paramInt);
        paramc.KCU.setTag(localObject);
        paramc.KCU.setOnClickListener(paramc.KuO.d(parama));
        paramc.KCU.setOnLongClickListener(paramOnLongClickListener);
        paramc.KCU.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k)parama.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGw());
        if ((parambv.eNc & 0x1) != 1) {
          break label1571;
        }
        paramc.KCT.setVisibility(0);
        if (parambv.field_isSend != 0) {
          break label1548;
        }
        paramc.KCV.setBackgroundResource(2131231624);
        label505:
        if (!paramBoolean) {
          break label1623;
        }
        parama.getTalkerUserName();
      }
      for (;;)
      {
        parambv = ((com.tencent.mm.ui.chatting.d.b.f)parama.bh(com.tencent.mm.ui.chatting.d.b.f.class)).aXB(parama.getTalkerUserName());
        parama = a.a.fCh();
        paramOnLongClickListener = paramc.KCU;
        paramInt = (int)f1;
        if (parambv != null) {
          parambv.toString();
        }
        parama.aA(paramOnLongClickListener, paramInt);
        paramc.KBc.setContentDescription(" ");
        AppMethodBeat.o(187908);
        return;
        paramc.KCV.setVisibility(8);
        paramc.KCV.cgN();
        break;
        label602:
        ae.d("MicroMsg.ChattingItemVoice", "stopDownloadAnim");
        if (paramc.KCZ == null) {
          break label148;
        }
        paramc.KCZ.setVisibility(8);
        if (paramc.KCU == null) {
          break label148;
        }
        if (paramBoolean)
        {
          paramc.KCU.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.ui.aq.aM(paramc.KCU.getContext(), 2130968740), null, null, null);
          break label148;
        }
        paramc.KCU.setCompoundDrawablesWithIntrinsicBounds(null, null, paramc.KCU.getContext().getResources().getDrawable(2131689927), null);
        break label148;
        label693:
        if (((p)localObject).time == 0L)
        {
          a(paramc, 8, 0, true);
          paramc.KDa.cgN();
          paramc.KDa.setVisibility(8);
          paramc.KuL.setVisibility(8);
          f2 = 0.0F;
          paramc.KCS = com.tencent.mm.cb.a.fromDPToPix(parama.Kkd.getContext(), Kg(0));
          paramc.KCU.setWidth(paramc.KCS);
          paramc.KBc.setText(parama.Kkd.getMMResources().getString(2131759570, new Object[] { Integer.valueOf(0) }));
          paramc.KCV.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.Kkd.getContext(), Kg(0)));
          f1 = f2;
          if (paramc.KDd == null) {
            break label296;
          }
          paramc.KDd.setVisibility(8);
          f1 = f2;
          break label296;
        }
        if (((p)localObject).time == -1L)
        {
          a(paramc, 8, 0, true);
          paramc.KDa.cgN();
          paramc.KDa.setVisibility(8);
          paramc.KCS = 80;
          paramc.KCU.setWidth(80);
          paramc.KBc.setVisibility(8);
          paramc.KCV.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.Kkd.getContext(), Kg((int)f1)));
          if (paramc.KDd == null) {
            break label1082;
          }
          paramc.KDd.setVisibility(8);
          break label296;
        }
        a(paramc, 8, 0, true);
        paramc.KDa.cgN();
        paramc.KDa.setVisibility(8);
        paramc.KBc.setVisibility(0);
        paramc.KCS = com.tencent.mm.cb.a.fromDPToPix(parama.Kkd.getContext(), Kg((int)f1));
        paramc.KCU.setWidth(paramc.KCS);
        paramc.KBc.setText(parama.Kkd.getMMResources().getString(2131759570, new Object[] { Integer.valueOf((int)f1) }));
        paramc.KCV.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.Kkd.getContext(), Kg((int)f1)));
        if (paramc.KDd != null) {
          paramc.KDd.setVisibility(8);
        }
        label1082:
        break label296;
        label1085:
        if (parambv.field_status == 5)
        {
          a(paramc, 8, 0, false);
          paramc.KCX.setVisibility(8);
          paramc.KBc.setVisibility(0);
          paramc.fLO();
          if (((p)localObject).time == 0L) {
            f1 = 0.0F;
          }
          paramc.KCS = com.tencent.mm.cb.a.fromDPToPix(parama.Kkd.getContext(), Kg((int)f1));
          paramc.KCU.setWidth(paramc.KCS);
          paramc.KBc.setText(parama.Kkd.getMMResources().getString(2131759570, new Object[] { Integer.valueOf((int)f1) }));
          paramc.KCV.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.Kkd.getContext(), Kg((int)f1)));
          break label337;
        }
        if (((p)localObject).time == -1L)
        {
          a(paramc, 8, 0, false);
          paramc.KCU.setWidth(80);
          paramc.KCS = 80;
          paramc.KBc.setVisibility(8);
          paramc.KCX.setVisibility(8);
          paramc.KCV.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.Kkd.getContext(), Kg((int)f1)));
          paramc.fLO();
          break label337;
        }
        if (parambv.field_status == 7)
        {
          a(paramc, 8, 8, false);
          paramc.KBc.setVisibility(8);
          paramc.KCX.setVisibility(0);
          paramc.fLO();
          if (paramc.KCY != null)
          {
            paramc.KDg = AnimationUtils.loadAnimation(paramc.uan.getContext(), 2130772168);
            paramc.KCY.startAnimation(paramc.KDg);
          }
          break label337;
        }
        a(paramc, 8, 0, false);
        paramc.KCX.setVisibility(8);
        paramc.KBc.setVisibility(0);
        paramc.fLO();
        if (((p)localObject).time == 0L) {
          f1 = 0.0F;
        }
        paramc.KCS = com.tencent.mm.cb.a.fromDPToPix(parama.Kkd.getContext(), Kg((int)f1));
        paramc.KCU.setWidth(paramc.KCS);
        paramc.KBc.setText(parama.Kkd.getMMResources().getString(2131759570, new Object[] { Integer.valueOf((int)f1) }));
        paramc.KCV.setWidth(com.tencent.mm.cb.a.fromDPToPix(parama.Kkd.getContext(), Kg((int)f1)));
        f2 = f1;
        label1516:
        f1 = f2;
        break label337;
        label1523:
        paramc.KBc.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        break label383;
        label1537:
        paramc.KBc.setBackgroundColor(0);
        break label400;
        label1548:
        paramc.KDc.setBackgroundResource(2131231734);
        paramc.KCV.setBackgroundResource(2131231734);
        break label505;
        label1571:
        paramc.KCT.setVisibility(8);
        if (parambv.field_isSend == 0)
        {
          paramc.KCV.setBackgroundResource(2131231606);
          break label505;
        }
        paramc.KDc.setBackgroundResource(2131231725);
        paramc.KCV.setBackgroundResource(2131231725);
        break label505;
        label1623:
        parama.fJy();
      }
    }
    
    static void f(Context paramContext, CharSequence paramCharSequence)
    {
      AppMethodBeat.i(37485);
      Intent localIntent = new Intent(paramContext, TextPreviewUI.class);
      localIntent.putExtra("key_chat_text", paramCharSequence);
      paramCharSequence = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramCharSequence.ahE(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$VoiceItemHolder", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramCharSequence.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$VoiceItemHolder", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.kk(paramContext);
      AppMethodBeat.o(37485);
    }
    
    private void fLO()
    {
      AppMethodBeat.i(37486);
      if (this.KDg != null)
      {
        this.KDg.cancel();
        this.KDg = null;
      }
      AppMethodBeat.o(37486);
    }
    
    public final c.a d(View paramView, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(37483);
      super.gs(paramView);
      this.fVV = ((TextView)paramView.findViewById(2131298178));
      this.yUp = ((TextView)paramView.findViewById(2131298185));
      this.KCU = ((TextView)paramView.findViewById(2131298197));
      this.iFD = ((CheckBox)paramView.findViewById(2131298068));
      this.hcH = paramView.findViewById(2131298147);
      this.KuL = ((ImageView)paramView.findViewById(2131298174));
      this.KBc = ((TextView)paramView.findViewById(2131298073));
      this.KCW = ((FrameLayout)paramView.findViewById(2131298198));
      this.KCZ = ((ProgressBar)paramView.findViewById(2131308259));
      this.Kyu = ((ViewStub)paramView.findViewById(2131306075));
      this.KCT = ((TextView)paramView.findViewById(2131298195));
      this.KCV = ((AnimImageView)paramView.findViewById(2131298194));
      this.KCV.setType(1);
      if (paramBoolean1)
      {
        this.KCV.setFromVoice(true);
        this.KCV.setFromGroup(paramBoolean2);
        this.KvI = ((TextView)paramView.findViewById(2131298023));
        this.KDa = ((AnimImageView)paramView.findViewById(2131298196));
        this.KDa.setFromVoice(true);
        this.KDa.setFromGroup(paramBoolean2);
        this.KDa.setType(0);
        this.KDd = ((ImageView)paramView.findViewById(2131308256));
        this.KDe = ((RelativeLayout)paramView.findViewById(2131308480));
        this.KDf = ((TextView)paramView.findViewById(2131308479));
      }
      for (;;)
      {
        AppMethodBeat.o(37483);
        return this;
        this.KCX = ((FrameLayout)paramView.findViewById(2131298205));
        this.KCY = ((ImageView)paramView.findViewById(2131298206));
        this.KDb = ((ProgressBar)paramView.findViewById(2131298207));
        this.xvJ = ((ProgressBar)paramView.findViewById(2131306220));
        this.KDc = ((TextView)paramView.findViewById(2131298208));
        this.KCV.setFromVoice(false);
        this.KCV.setFromGroup(paramBoolean2);
        this.KvW = ((ImageView)paramView.findViewById(2131298176));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.az
 * JD-Core Version:    0.7.0.1
 */