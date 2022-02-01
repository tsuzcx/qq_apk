package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
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
import com.tencent.mm.an.af;
import com.tencent.mm.autogen.a.acm;
import com.tencent.mm.autogen.a.acm.a;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.a;
import com.tencent.mm.autogen.a.ha;
import com.tencent.mm.autogen.a.iz;
import com.tencent.mm.autogen.a.iz.a;
import com.tencent.mm.autogen.a.ns;
import com.tencent.mm.autogen.a.ns.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.lc;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.modelstat.b.b;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.n.a.5;
import com.tencent.mm.n.a.8;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.a.a.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.AnimImageView;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.TextPreviewUI;
import com.tencent.mm.ui.chatting.component.api.bb;
import com.tencent.mm.ui.chatting.component.api.bc;
import com.tencent.mm.ui.chatting.component.api.bf;
import com.tencent.mm.ui.chatting.component.api.g;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.ui.chatting.component.bt;
import com.tencent.mm.ui.chatting.v.n;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.util.b.a;
import com.tencent.neattextview.textview.view.NeatTextView.b;

public final class bl
{
  public static final int bsQ;
  private static final MultiProcessMMKV eMf;
  
  static
  {
    AppMethodBeat.i(255308);
    bsQ = ViewConfiguration.getDoubleTapTimeout();
    eMf = MultiProcessMMKV.getSingleMMKV("voice_continue_play_info");
    AppMethodBeat.o(255308);
  }
  
  private static long a(long paramLong1, long paramLong2, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(255263);
    String str = eMf.getString(String.valueOf(paramLong1), "0,0");
    if (eMf.getLong("current_interrupt_msg_id-".concat(String.valueOf(paramString)), 0L) != paramLong1)
    {
      Log.i("MicroMsg.ChattingItemVoice", "[voice interrupt] %d current voice isn't the latest interrupt one %s", new Object[] { Long.valueOf(paramLong1), paramString });
      AppMethodBeat.o(255263);
      return 0L;
    }
    long l1;
    int i;
    if (str != null)
    {
      paramString = str.split(",");
      if (paramString.length != 2)
      {
        Log.i("MicroMsg.ChattingItemVoice", "[voice interrupt] interrupt info format error");
        AppMethodBeat.o(255263);
        return -1L;
      }
      try
      {
        l1 = Long.parseLong(paramString[1]);
        long l2 = System.currentTimeMillis() - l1;
        com.tencent.mm.util.i locali = com.tencent.mm.util.i.agtt;
        i = com.tencent.mm.util.i.a(b.a.agrf, -1);
        if ((l2 > ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ziD, 86400L) * 1000L) || ((i >= 0) && (l2 > i * 60L * 1000L)))
        {
          eMf.remove(String.valueOf(paramLong1));
          Log.i("MicroMsg.ChattingItemVoice", "[voice interrupt] interrupt info expired, record timestamp: ".concat(String.valueOf(l1)));
          AppMethodBeat.o(255263);
          return -1L;
        }
        l1 = Long.parseLong(paramString[0]);
        if ((2000L < l1) && (2000L + l1 < paramLong2))
        {
          Log.i("MicroMsg.ChattingItemVoice", "[voice interrupt] get interrupt time ".concat(String.valueOf(l1)));
          if (paramBoolean)
          {
            eMf.remove(String.valueOf(paramLong1));
            Log.i("MicroMsg.ChattingItemVoice", "[voice interrupt] return pts and remove info ".concat(String.valueOf(l1)));
          }
          if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ziC, -1) == 1)
          {
            i = 1;
            Log.i("MicroMsg.ChattingItemVoice", "[voice interrupt] disable flag");
            if (i == 0) {
              break label377;
            }
            AppMethodBeat.o(255263);
            return -1L;
          }
        }
      }
      catch (NumberFormatException paramString)
      {
        Log.e("MicroMsg.ChattingItemVoice", "[voice interrupt] parse data error str: ".concat(String.valueOf(str)));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(255263);
      return -1L;
      i = 0;
      break;
      label377:
      AppMethodBeat.o(255263);
      return l1;
      eMf.remove(String.valueOf(paramLong1));
      Log.i("MicroMsg.ChattingItemVoice", "[voice interrupt] pts out of limit");
    }
  }
  
  public static void a(com.tencent.mm.ui.chatting.d.a parama, bz parambz, MsgQuoteItem paramMsgQuoteItem)
  {
    AppMethodBeat.i(255274);
    com.tencent.mm.ui.chatting.d locald;
    long l;
    boolean bool2;
    if ((parambz != null) && (parambz.hTm != null) && (a(parama, parambz.hTm, paramMsgQuoteItem)))
    {
      paramMsgQuoteItem = new com.tencent.mm.modelvoice.p(parambz.hTm.field_content);
      locald = ((bf)parama.cm(bf.class)).jut();
      l = a(parambz.hTm.field_msgId, paramMsgQuoteItem.time, true, parama.getTalkerUserName());
      if (l > 0L)
      {
        bool2 = parama.juH();
        if (parama.juG()) {
          break label178;
        }
      }
    }
    label178:
    for (boolean bool1 = true;; bool1 = false)
    {
      com.tencent.mm.ui.report.c.a(bool2, bool1, 3L, parambz.hTm.field_msgId, paramMsgQuoteItem.time, l);
      if ((parama.cm(m.class) != null) && (locald != null))
      {
        k(parama, parambz.hTm);
        locald.a(parambz.position, parambz.hTm);
      }
      AppMethodBeat.o(255274);
      return;
    }
  }
  
  private static boolean a(final int paramInt, com.tencent.mm.ui.chatting.d.a parama, final cc paramcc, final bb parambb, boolean paramBoolean)
  {
    AppMethodBeat.i(255288);
    if (b(parama, paramcc, R.l.gwx))
    {
      AppMethodBeat.o(255288);
      return true;
    }
    if (c(parama, paramcc, R.l.gwv))
    {
      AppMethodBeat.o(255288);
      return true;
    }
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(37465);
        bl.m(bl.this, paramcc);
        AppMethodBeat.o(37465);
      }
    }, "voice_transform_text_report");
    if (parambb.jtS()) {
      k.d(parama.aezO.getContext(), parama.aezO.getContext().getString(R.l.gYx), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(255048);
          if (this.KsH) {
            com.tencent.mm.modelvoice.s.ay(paramcc);
          }
          parambb.jtT();
          parambb.a(paramcc, true, paramInt, 0);
          AppMethodBeat.o(255048);
        }
      });
    }
    for (;;)
    {
      parama = com.tencent.mm.modelstat.b.oUZ;
      if (parama.bMW()) {
        parama.a(paramcc, b.b.oVp, 0);
      }
      AppMethodBeat.o(255288);
      return true;
      if (paramBoolean) {
        com.tencent.mm.modelvoice.s.ay(paramcc);
      }
      parambb.a(paramcc, true, paramInt, 0);
    }
  }
  
  private static boolean a(com.tencent.mm.ui.chatting.d.a parama, cc paramcc, MsgQuoteItem paramMsgQuoteItem)
  {
    AppMethodBeat.i(255270);
    Object localObject1 = parama.aezO.getContext();
    Object localObject2 = new acm();
    ((acm)localObject2).publish();
    if (((acm)localObject2).ifS.hzK) {
      k.a((Context)localObject1, "", com.tencent.mm.n.a.t((Context)localObject1, ((acm)localObject2).ifS.ifT), ((Context)localObject1).getString(c.h.app_i_know), new a.5());
    }
    int i;
    if ((!((acm)localObject2).ifS.hzK) && (!com.tencent.mm.n.a.v(parama.aezO.getContext(), true)))
    {
      localObject1 = parama.aezO.getContext();
      localObject2 = new ns();
      ((ns)localObject2).publish();
      Log.i("MicroMsg.DeviceOccupy", "checkFinderLiveStatePlaying isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(((ns)localObject2).hQh.isStart), Boolean.valueOf(((ns)localObject2).hQh.hKC) });
      if ((!((ns)localObject2).hQh.isStart) || (!((ns)localObject2).hQh.hKC)) {
        break label428;
      }
      i = 1;
      if (i != 0) {
        k.a((Context)localObject1, "", ((Context)localObject1).getString(c.h.finder_live_open_new_tip_anchor_busy), ((Context)localObject1).getString(c.h.app_i_know), new a.8());
      }
      if ((i == 0) && (!com.tencent.mm.n.a.r(parama.aezO.getContext(), true)))
      {
        localObject2 = parama.aezO.getContext();
        localObject1 = new iz();
        ((iz)localObject1).publish();
        Log.i("MicroMsg.DeviceOccupy", "checkFinderLive isLiving %b isAnchor %b", new Object[] { Boolean.valueOf(((iz)localObject1).hKB.isStart), Boolean.valueOf(((iz)localObject1).hKB.hKC) });
        if ((!((iz)localObject1).hKB.isStart) || (((iz)localObject1).hKB.hKC) || (!((iz)localObject1).hKB.hKD)) {
          break label433;
        }
        i = 1;
        label346:
        if (i != 0) {
          if (!((iz)localObject1).hKB.hKC) {
            break label438;
          }
        }
      }
    }
    label428:
    label433:
    label438:
    for (localObject1 = ((Context)localObject2).getString(c.h.finder_live_open_new_tip_anchor_busy);; localObject1 = ((Context)localObject2).getString(c.h.finder_live_open_new_tip_visitor_busy))
    {
      aa.makeText((Context)localObject2, (CharSequence)localObject1, 0).show();
      if ((i == 0) && (!com.tencent.mm.n.a.dl(parama.aezO.getContext())) && (!com.tencent.mm.n.a.dp(parama.aezO.getContext()))) {
        break label451;
      }
      Log.d("MicroMsg.ChattingItemVoice", "voip is running, not play voice");
      AppMethodBeat.o(255270);
      return false;
      i = 0;
      break;
      i = 0;
      break label346;
    }
    label451:
    bh.bCz();
    if (!com.tencent.mm.model.c.isSDCardAvailable())
    {
      aa.j(parama.aezO.getContext(), parama.aezO.getContentView());
      AppMethodBeat.o(255270);
      return false;
    }
    localObject1 = new com.tencent.mm.modelvoice.p(paramcc.field_content);
    if ((com.tencent.mm.platformtools.ab.isNullOrNil(paramcc.field_content)) || (((com.tencent.mm.modelvoice.p)localObject1).time == 0L))
    {
      Toast.makeText(parama.aezO.getContext(), R.l.gzg, 0).show();
      if (paramMsgQuoteItem != null) {
        com.tencent.mm.plugin.msgquote.model.b.e(5L, paramMsgQuoteItem.LgU, paramMsgQuoteItem.type, 0L);
      }
      AppMethodBeat.o(255270);
      return false;
    }
    AppMethodBeat.o(255270);
    return true;
  }
  
  public static void b(com.tencent.mm.ui.chatting.d.a parama, bz parambz)
  {
    AppMethodBeat.i(37488);
    a(parama, parambz, null);
    AppMethodBeat.o(37488);
  }
  
  public static boolean b(com.tencent.mm.ui.chatting.d.a parama, cc paramcc, int paramInt)
  {
    AppMethodBeat.i(255283);
    if (paramcc == null)
    {
      AppMethodBeat.o(255283);
      return false;
    }
    boolean bool1;
    if (paramcc.jch()) {
      if (((bf)parama.cm(bf.class)).Ae(paramcc.field_msgId))
      {
        Log.i("MicroMsg.ChattingItemVoice", "onCreateContextMenu: voice msg is downloading.(1)");
        bool1 = true;
        bool2 = bool1;
        if (bool1)
        {
          Log.i("MicroMsg.ChattingItemVoice", "handleNoFinishDownloadVoiceMsg show alert!");
          k.a(parama.aezO.getContext(), parama.aezO.getContext().getString(paramInt), "", parama.aezO.getContext().getString(R.l.welcome_i_know), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
        }
      }
    }
    for (boolean bool2 = bool1;; bool2 = false)
    {
      AppMethodBeat.o(255283);
      return bool2;
      if (((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramcc.field_msgId).jch())
      {
        Log.i("MicroMsg.ChattingItemVoice", "onCreateContextMenu: voice msg is downloading.(2)");
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
    }
  }
  
  public static boolean c(com.tencent.mm.ui.chatting.d.a parama, cc paramcc, int paramInt)
  {
    AppMethodBeat.i(255286);
    if ((paramcc != null) && (paramcc.iYj()) && (paramcc.field_isSend != 1) && (paramcc.field_status == 5))
    {
      Log.i("MicroMsg.ChattingItemVoice", "handleDownloadFailVoiceMsg show alert!");
      k.a(parama.aezO.getContext(), parama.aezO.getContext().getString(paramInt), "", parama.aezO.getContext().getString(R.l.welcome_i_know), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(255286);
      return true;
    }
    AppMethodBeat.o(255286);
    return false;
  }
  
  private static void k(com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(255279);
    if (((bf)parama.cm(bf.class)).jut().aeeT == paramcc.field_msgId)
    {
      AppMethodBeat.o(255279);
      return;
    }
    parama = (bb)parama.cm(bb.class);
    int i;
    if (parama.Ab(paramcc.field_msgId)) {
      i = 7;
    }
    for (;;)
    {
      if (i != 0)
      {
        parama = new ha();
        parama.hHI.hHJ = 1;
        parama.hHI.scene = i;
        parama.hHI.fileName = paramcc.field_imgPath;
        parama.publish();
      }
      AppMethodBeat.o(255279);
      return;
      if (parama.zW(paramcc.field_msgId)) {
        i = 6;
      } else {
        i = 0;
      }
    }
  }
  
  public static final class a
    extends c
    implements v.n
  {
    private com.tencent.threadpool.i.d<?> aeWG = null;
    private View.OnClickListener aeWH;
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
    public static boolean a(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc, bz parambz, MsgQuoteItem paramMsgQuoteItem)
    {
      AppMethodBeat.i(254922);
      if (paramcc.field_status == 5)
      {
        Log.i("MicroMsg.ChattingItemVoice", "onItemClick msg(%s) fail", new Object[] { Long.valueOf(paramcc.field_msgId) });
        AppMethodBeat.o(254922);
        return true;
      }
      if (paramcc.jch())
      {
        ((bf)parama.cm(bf.class)).a(paramcc.field_msgId, paramView);
        if (((bf)parama.cm(bf.class)).Ae(paramcc.field_msgId))
        {
          Log.i("MicroMsg.ChattingItemVoice", "onItemClick: voice msg show download animation");
          AppMethodBeat.o(254922);
          return true;
        }
        paramView = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramcc.field_msgId);
        if (paramView.jch())
        {
          ((bf)parama.cm(bf.class)).Ad(paramView.field_msgId);
          o.bPh().run();
          com.tencent.threadpool.h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(254868);
              bl.a.this.dcZ();
              AppMethodBeat.o(254868);
            }
          });
          Log.i("MicroMsg.ChattingItemVoice", "onItemClick voice msg(%s) no finish download!", new Object[] { Long.valueOf(paramcc.field_msgId) });
          AppMethodBeat.o(254922);
          return true;
        }
      }
      if (parambz == null)
      {
        Log.i("MicroMsg.ChattingItemVoice", "onItemClick tag(%s) is null", new Object[] { Long.valueOf(paramcc.field_msgId) });
        AppMethodBeat.o(254922);
        return true;
      }
      ((bf)parama.cm(bf.class)).Af(paramcc.field_msgId);
      ((bf)parama.cm(bf.class)).juw();
      com.tencent.mm.modelstat.b.oUZ.ar(parambz.hTm);
      bl.a(parama, parambz, paramMsgQuoteItem);
      ((bb)parama.cm(bb.class)).aCl(2);
      ((bc)parama.cm(bc.class)).jtW();
      c(parama, paramcc);
      if (((bb)parama.cm(bb.class)).cX(paramcc)) {
        bq(4, paramcc.field_msgId);
      }
      AppMethodBeat.o(254922);
      return true;
    }
    
    public static void bq(int paramInt, long paramLong)
    {
      AppMethodBeat.i(254914);
      if (!bt.juz())
      {
        AppMethodBeat.o(254914);
        return;
      }
      lc locallc = new lc();
      locallc.iYK = paramInt;
      locallc.tZ(String.valueOf(paramLong));
      Log.d("MicroMsg.ChattingItemVoice", "%s", new Object[] { locallc.aIF() });
      locallc.bMH();
      AppMethodBeat.o(254914);
    }
    
    public static void h(int paramInt, cc paramcc)
    {
      AppMethodBeat.i(254906);
      if (paramcc == null)
      {
        Log.i("MicroMsg.ChattingItemVoice", "msgInfo is null???");
        AppMethodBeat.o(254906);
        return;
      }
      bq(paramInt, paramcc.field_msgId);
      AppMethodBeat.o(254906);
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
        localObject = new ap(paramLayoutInflater, R.i.ggi);
        ((View)localObject).setTag(new bl.c().d((View)localObject, true, this.aedO));
      }
      AppMethodBeat.o(37469);
      return localObject;
    }
    
    public final void a(final c.a parama, final int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, final cc paramcc, String paramString)
    {
      AppMethodBeat.i(37471);
      this.aeiK = parama1;
      bl.c localc = (bl.c)parama;
      localc.aeWO.setFromVoice(true);
      localc.aeWO.setFromGroup(parama1.juG());
      m localm = (m)parama1.cm(m.class);
      b(localm, paramcc.field_msgId);
      bl.c.a(this, localc, paramcc, paramInt, parama1, true, c(parama1), this);
      paramString = ChattingItemTranslate.c.aeWe;
      final bb localbb = (bb)parama1.cm(bb.class);
      if (bl.e(paramcc, parama1))
      {
        parama = localbb.ar(paramcc.field_msgId, paramcc.field_imgPath);
        if (Util.isNullOrNil(parama)) {
          break label1109;
        }
        paramString = ChattingItemTranslate.c.aeWh;
      }
      label331:
      label589:
      label851:
      label1109:
      for (;;)
      {
        int i;
        Object localObject;
        if ((!Util.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.c.aeWe))
        {
          if (localc.aeQx == null)
          {
            localc.aeQx = ((ChattingItemTranslate)localc.aeQw.inflate());
            localc.aeQx.setMinimumWidth(localc.aeWL - com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 5));
            localc.aeQx.init();
          }
          Context localContext = localc.aeUc.getContext();
          i = (int)localc.aeQx.getContentView().getTextSize();
          if (paramcc != null)
          {
            localObject = ad.Jo(paramcc.field_msgSvrId);
            ad.b localb = ad.bCb().M((String)localObject, true);
            localb.q("prePublishId", "msg_" + paramcc.field_msgSvrId);
            localb.q("preUsername", a(this.aeiK, paramcc));
            localb.q("preChatName", b(this.aeiK, paramcc));
            localObject = com.tencent.mm.pluginsdk.ui.span.p.a(localContext, parama, i, null, (String)localObject);
            localc.aeQx.a((CharSequence)localObject, paramString, localbb.zZ(paramcc.field_msgId), ChattingItemTranslate.b.aeWc, paramcc.field_msgId, parama1);
            if ((!Util.isNullOrNil((CharSequence)localObject)) && (localbb.zZ(paramcc.field_msgId))) {
              localbb.Aa(paramcc.field_msgId);
            }
            paramString = new ChattingItemTranslate.a(paramcc, parama1.juG(), paramInt);
            paramString.viewType = 2;
            localc.aeQx.setTag(paramString);
            paramString = localc.aeQx;
            if (this.aeWH == null) {
              this.aeWH = new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(254898);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymousView);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  paramAnonymousView = (ChattingItemTranslate.a)((ChattingItemTranslate)paramAnonymousView).getTag();
                  if (((bb)bl.a.a(bl.a.this).cm(bb.class)).zV(paramAnonymousView.hTm.field_msgId) == ChattingItemTranslate.c.aeWg) {
                    ((bb)bl.a.a(bl.a.this).cm(bb.class)).a(paramAnonymousView.hTm, true, paramAnonymousView.position, 1);
                  }
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(254898);
                }
              };
            }
            paramString.setOnClickListener(this.aeWH);
            localc.aeQx.setOnLongClickListener(c(parama1));
            localc.aeQx.setVisibility(0);
            if (!Util.isNullOrNil(parama))
            {
              localc.aeQx.setOnTouchListener(localm.jqv());
              localc.aeQx.setOnDoubleClickListener(new NeatTextView.b()
              {
                public final boolean lA(View paramAnonymousView)
                {
                  AppMethodBeat.i(37466);
                  bl.c.a(MMApplicationContext.getContext(), parama, parama1);
                  bl.dJ(paramcc);
                  AppMethodBeat.o(37466);
                  return true;
                }
              });
            }
            if ((aw.isDarkMode()) || (!((com.tencent.mm.ui.chatting.component.api.d)parama1.cm(com.tencent.mm.ui.chatting.component.api.d.class)).jry())) {
              break label851;
            }
            localc.aeWY.setBackgroundResource(R.g.voice_to_text_custom_bg);
            localc.aeXa.setBackgroundResource(R.g.voice_to_text_custom_bg);
            localc.aeWY.setTextSize(0, com.tencent.mm.cd.a.bs(parama1.aezO.getContext(), R.f.Edge_1_5_A));
            localc.aeXa.setTextSize(0, com.tencent.mm.cd.a.bs(parama1.aezO.getContext(), R.f.Edge_1_5_A));
            if (((bf)parama1.cm(bf.class)).Ah(paramcc.field_msgId)) {
              break label876;
            }
            localc.aeWX.setVisibility(8);
            localc.aeWX.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(254907);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                Log.i("MicroMsg.ChattingItemVoice", "voice fast trans text click");
                bl.b(paramInt, parama1, paramcc, localbb, true);
                bl.a.h(2, paramcc);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(254907);
              }
            });
            localc.aeWZ.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(37468);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                bl.l(parama1, paramcc);
                paramAnonymousView.setVisibility(8);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37468);
              }
            });
            parama = new com.tencent.mm.modelvoice.p(paramcc.field_content);
            if (parama.time != 0L) {
              break label888;
            }
            localc.stateIV.setVisibility(8);
          }
        }
        for (;;)
        {
          parama = paramcc.kLg;
          if ((parama != null) && (parama.length() != 0)) {
            break label1074;
          }
          localc.aeNs.setVisibility(8);
          AppMethodBeat.o(37471);
          return;
          if (!localbb.zW(paramcc.field_msgId)) {
            break label1104;
          }
          parama = localbb.ar(paramcc.field_msgId, paramcc.field_imgPath);
          paramString = localbb.zV(paramcc.field_msgId);
          break;
          localObject = null;
          break label331;
          if (localc.aeQx == null) {
            break label543;
          }
          localc.aeQx.setVisibility(8);
          break label543;
          localc.aeWY.setBackgroundResource(R.g.voice_to_text_bg);
          localc.aeXa.setBackgroundResource(R.g.voice_to_text_bg);
          break label589;
          label876:
          localc.aeWX.setVisibility(0);
          break label667;
          label888:
          paramString = ((bf)parama1.cm(bf.class)).jut();
          if (((paramString != null) && (paramString.aeeT == paramcc.field_msgId)) || (com.tencent.mm.modelvoice.s.aw(paramcc)))
          {
            paramInt = 1;
            paramString = localc.stateIV;
            if (paramInt == 0) {
              break label1013;
            }
          }
          label1013:
          for (i = 8;; i = 0)
          {
            paramString.setVisibility(i);
            i = (int)com.tencent.mm.modelvoice.s.jh(parama.time);
            if (paramInt != 0) {
              break label1019;
            }
            localc.aeWN.setContentDescription(String.format(parama1.aezO.getContext().getString(R.l.voice_msg_unread_desc), new Object[] { Integer.valueOf(i) }));
            break;
            paramInt = 0;
            break label933;
          }
          label1019:
          parama = ((g)parama1.cm(g.class)).bAK(parama1.getTalkerUserName());
          paramString = a.a.jlv();
          localObject = localc.aeWN;
          if (parama != null) {
            parama.toString();
          }
          paramString.bh((View)localObject, i);
        }
        localc.aeNs.setVisibility(0);
        b(parama1, localc.aeNs, bz.bBE(parama));
        AppMethodBeat.o(37471);
        return;
        parama = null;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(37473);
      Object localObject = (bb)parama.cm(bb.class);
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(37473);
        return false;
        ((bf)parama.cm(bf.class)).Me(true);
        AppMethodBeat.o(37473);
        return true;
        ((bf)parama.cm(bf.class)).Me(false);
        AppMethodBeat.o(37473);
        return true;
        if (!WeChatBrands.Business.Entries.SessionSpeech2TextSnd.checkAvailable(parama.aezO.getContext()))
        {
          AppMethodBeat.o(37473);
          return true;
        }
        h(3, paramcc);
        boolean bool = bl.b(paramMenuItem.getGroupId(), parama, paramcc, (bb)localObject, true);
        AppMethodBeat.o(37473);
        return bool;
        paramMenuItem = ((bb)localObject).ar(paramcc.field_msgId, paramcc.field_imgPath);
        if (!Util.isNullOrNil(paramMenuItem)) {
          ClipboardHelper.setText(paramMenuItem);
        }
        bl.g(8, paramcc);
        continue;
        paramMenuItem = new Intent(parama.aezO.getContext(), MsgRetransmitUI.class);
        localObject = ((bb)localObject).ar(paramcc.field_msgId, paramcc.field_imgPath);
        if (paramcc.jbw())
        {
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceFrom", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          bl.g(9, paramcc);
          break;
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 4);
        }
        localObject = ((bb)localObject).ar(paramcc.field_msgId, paramcc.field_imgPath);
        paramMenuItem = new dn();
        l.b(paramMenuItem, (String)localObject, 1);
        paramMenuItem.hDr.fragment = parama.aezO;
        paramMenuItem.hDr.hDy = 43;
        if (paramMenuItem.hDr.hDt != null)
        {
          parama = paramMenuItem.hDr.hDt.ZBt;
          if (parama != null)
          {
            parama.bto(paramcc.field_talker);
            parama.btp(z.bAM());
            paramMenuItem.publish();
          }
        }
        for (;;)
        {
          bl.g(10, paramcc);
          break;
          Log.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
        }
        ((bf)parama.cm(bf.class)).db(paramcc);
        ((bf)parama.cm(bf.class)).jux();
        continue;
        ((bf)parama.cm(bf.class)).cU(paramcc);
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(254966);
      bh.bCz();
      int k;
      int i;
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        paramContextMenuInfo = (ChattingItemTranslate.a)paramView.getTag();
        k = paramContextMenuInfo.position;
        if (paramContextMenuInfo.viewType == 1) {
          if (((new com.tencent.mm.modelvoice.p(paramcc.field_content).time != 0L) || (paramcc.field_isSend != 0)) && ((paramcc.field_status != 1) || (paramcc.field_isSend != 1)))
          {
            bh.bCz();
            Boolean localBoolean = (Boolean)com.tencent.mm.model.c.ban().d(26, null);
            paramContextMenuInfo = localBoolean;
            if (localBoolean == null) {
              paramContextMenuInfo = Boolean.FALSE;
            }
            if (!paramContextMenuInfo.booleanValue()) {
              break label458;
            }
            params.a(k, 120, paramView.getContext().getString(R.l.chatfooter_SpeakerOff), R.k.icons_filled_volume_up);
            bh.bCz();
            paramContextMenuInfo = com.tencent.mm.model.c.bzA().JE(paramcc.field_talker);
            if ((au.bwc(paramcc.field_talker)) || (com.tencent.mm.model.ab.IV(paramcc.field_talker)) || (paramContextMenuInfo == null) || (paramContextMenuInfo.iZC())) {
              break label483;
            }
            i = 1;
            label197:
            if (com.tencent.mm.br.c.blq("favorite")) {
              params.a(k, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
            }
            if (i != 0)
            {
              if (af.bHf().vQ(2) <= 0) {
                break label489;
              }
              i = 1;
              label246:
              if ((i != 0) && (!this.aeiK.juH())) {
                params.add(k, 114, 0, paramView.getContext().getString(R.l.gyk));
              }
            }
            paramContextMenuInfo = (bb)this.aeiK.cm(bb.class);
            if (!bl.e(paramcc, this.aeiK)) {
              break label495;
            }
            if (!Util.isNullOrNil(paramContextMenuInfo.ar(paramcc.field_msgId, paramcc.field_imgPath))) {
              break label715;
            }
            i = R.l.gyJ;
          }
        }
      }
      for (;;)
      {
        label333:
        if ((com.tencent.mm.model.ab.IS(paramcc.field_talker)) && (LocaleUtil.isChineseAppLang()) && (i != -1)) {
          params.a(k, 121, paramView.getContext().getString(i), R.k.icons_filled_transfer_text);
        }
        for (int j = 1;; j = 0)
        {
          if (!this.aeiK.juH()) {
            params.a(k, 100, paramView.getContext().getString(R.l.gyq), R.k.icons_filled_delete);
          }
          if ((j == 0) && (LocaleUtil.isChineseAppLang()) && (i != -1)) {
            params.a(k, 121, paramView.getContext().getString(i), R.k.icons_filled_transfer_text);
          }
          AppMethodBeat.o(254966);
          return true;
          label458:
          params.a(k, 119, paramView.getContext().getString(R.l.chatfooter_SpeakerON), R.k.icons_filled_ear);
          break;
          label483:
          i = 0;
          break label197;
          label489:
          i = 0;
          break label246;
          label495:
          if (paramContextMenuInfo.zW(paramcc.field_msgId)) {
            break label715;
          }
          i = R.l.gyJ;
          break label333;
          if (paramContextMenuInfo.viewType == 2)
          {
            paramContextMenuInfo = (bb)this.aeiK.cm(bb.class);
            if (paramContextMenuInfo.zV(paramcc.field_msgId) == ChattingItemTranslate.c.aeWg) {
              params.add(k, 121, 0, R.l.gyF);
            }
            for (;;)
            {
              AppMethodBeat.o(254966);
              return false;
              if (!Util.isNullOrNil(paramContextMenuInfo.ar(paramcc.field_msgId, paramcc.field_imgPath)))
              {
                params.a(k, 141, paramView.getContext().getString(R.l.gyl), R.k.icons_filled_copy);
                params.a(k, 142, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
                if (com.tencent.mm.br.c.blq("favorite")) {
                  params.a(k, 143, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
                }
              }
              params.a(k, 121, paramView.getContext().getString(R.l.gyH), R.k.icons_filled_eyes_off);
            }
          }
          AppMethodBeat.o(254966);
          return true;
        }
        label715:
        i = -1;
      }
    }
    
    public final void b(View paramView, final com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(254984);
      if (paramcc.field_status == 5)
      {
        paramView = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramcc.field_msgId);
        paramView.jci();
        com.tencent.mm.modelvoice.p localp = new com.tencent.mm.modelvoice.p(paramView.field_content);
        localp.paW = false;
        paramView.setContent(localp.bPi());
        paramView.setStatus(3);
        ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(paramcc.field_msgId, paramView);
        paramView = o.bPf().ji(paramcc.field_msgSvrId);
        if (paramView.osy != 0) {
          break label219;
        }
      }
      label219:
      for (paramView.status = 5;; paramView.status = 6)
      {
        paramView.pba = (System.currentTimeMillis() / 1000L);
        paramView.peL = 1;
        paramView.eQp = 1048896;
        com.tencent.mm.modelvoice.s.a(paramView);
        ((bf)parama.cm(bf.class)).Ad(paramcc.field_msgId);
        o.bPh().run();
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(254871);
            parama.dcZ();
            AppMethodBeat.o(254871);
          }
        });
        Log.i("MicroMsg.ChattingItemVoice", "onStateBtnClick voice msg(%s) re-download!", new Object[] { Long.valueOf(paramcc.field_msgId) });
        AppMethodBeat.o(254984);
        return;
      }
    }
    
    protected final boolean b(com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(37470);
      boolean bool = parama.juG();
      AppMethodBeat.o(37470);
      return bool;
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(37474);
      boolean bool = a(paramView, parama, paramcc, (bz)paramView.getTag(), null);
      AppMethodBeat.o(37474);
      return bool;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && (paramInt == 34);
    }
    
    public final boolean fXn()
    {
      return false;
    }
  }
  
  public static final class b
    extends c
    implements v.n
  {
    private int Yar = 3;
    private com.tencent.threadpool.i.d<?> aeWG = null;
    private com.tencent.mm.ui.chatting.d.a aeiK;
    
    public static boolean a(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc, bz parambz)
    {
      AppMethodBeat.i(254900);
      if (paramcc.field_status == 5)
      {
        Log.i("MicroMsg.ChattingItemVoice", "onItemClick msg(%s) fail", new Object[] { Long.valueOf(paramcc.field_msgId) });
        AppMethodBeat.o(254900);
        return true;
      }
      if (paramcc.jch())
      {
        ((bf)parama.cm(bf.class)).a(paramcc.field_msgId, paramView);
        if (((bf)parama.cm(bf.class)).Ae(paramcc.field_msgId))
        {
          Log.i("MicroMsg.ChattingItemVoice", "onCreateContextMenu: voice msg show download animation");
          AppMethodBeat.o(254900);
          return true;
        }
        paramView = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(paramcc.field_msgId);
        if (paramView.jch())
        {
          ((bf)parama.cm(bf.class)).Ad(paramView.field_msgId);
          o.bPh().run();
          com.tencent.threadpool.h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(255325);
              bl.b.this.dcZ();
              AppMethodBeat.o(255325);
            }
          });
          Log.i("MicroMsg.ChattingItemVoice", "onItemClick voice msg(%s) no finish download!", new Object[] { Long.valueOf(paramcc.field_msgId) });
          AppMethodBeat.o(254900);
          return true;
        }
      }
      if (parambz == null)
      {
        Log.i("MicroMsg.ChattingItemVoice", "onItemClick tag(%s) is null", new Object[] { Long.valueOf(paramcc.field_msgId) });
        AppMethodBeat.o(254900);
        return true;
      }
      ((bf)parama.cm(bf.class)).juw();
      com.tencent.mm.modelstat.b.oUZ.ar(parambz.hTm);
      bl.b(parama, parambz);
      ((bb)parama.cm(bb.class)).aCl(2);
      ((bc)parama.cm(bc.class)).jtW();
      ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
      AppMethodBeat.o(254900);
      return true;
    }
    
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
        localObject = new ap(paramLayoutInflater, R.i.ghg);
        ((View)localObject).setTag(new bl.c().d((View)localObject, false, this.aedO));
      }
      AppMethodBeat.o(37477);
      return localObject;
    }
    
    public final void a(final c.a parama, int paramInt, final com.tencent.mm.ui.chatting.d.a parama1, final cc paramcc, String paramString)
    {
      AppMethodBeat.i(37478);
      this.aeiK = parama1;
      bl.c localc = (bl.c)parama;
      localc.aeWO.setFromVoice(false);
      localc.aeWO.setFromGroup(parama1.juG());
      m localm = (m)parama1.cm(m.class);
      b(localm, paramcc.field_msgId);
      bl.c.a(this, localc, paramcc, paramInt, parama1, false, c(parama1), this);
      bb localbb = (bb)parama1.cm(bb.class);
      paramString = ChattingItemTranslate.c.aeWe;
      if (bl.e(paramcc, parama1))
      {
        parama = localbb.ar(paramcc.field_msgId, paramcc.field_imgPath);
        if (Util.isNullOrNil(parama)) {
          break label906;
        }
        paramString = ChattingItemTranslate.c.aeWh;
      }
      label776:
      label906:
      for (;;)
      {
        Object localObject;
        if ((!Util.isNullOrNil(parama)) || (paramString != ChattingItemTranslate.c.aeWe))
        {
          if (localc.aeQx == null)
          {
            localc.aeQx = ((ChattingItemTranslate)localc.aeQw.inflate());
            localc.aeQx.setMinimumWidth(localc.aeWL - com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 5));
            localc.aeQx.init();
          }
          Context localContext = localc.aeUc.getContext();
          int i = (int)localc.aeQx.getContentView().getTextSize();
          if (paramcc != null)
          {
            localObject = ad.Jo(paramcc.field_msgSvrId);
            ad.b localb = ad.bCb().M((String)localObject, true);
            localb.q("prePublishId", "msg_" + paramcc.field_msgSvrId);
            localb.q("preUsername", a(this.aeiK, paramcc));
            localb.q("preChatName", b(this.aeiK, paramcc));
            label329:
            localObject = com.tencent.mm.pluginsdk.ui.span.p.a(localContext, parama, i, null, (String)localObject);
            localc.aeQx.a((CharSequence)localObject, paramString, localbb.zZ(paramcc.field_msgId), ChattingItemTranslate.b.aeWc, paramcc.field_msgId, parama1);
            if ((!Util.isNullOrNil((CharSequence)localObject)) && (localbb.zZ(paramcc.field_msgId))) {
              localbb.Aa(paramcc.field_msgId);
            }
            paramString = new ChattingItemTranslate.a(paramcc, parama1.juG(), paramInt);
            paramString.viewType = 2;
            localc.aeQx.setTag(paramString);
            localc.aeQx.setOnLongClickListener(c(parama1));
            localc.aeQx.setVisibility(0);
            if (!Util.isNullOrNil(parama))
            {
              localc.aeQx.setOnTouchListener(localm.jqv());
              localc.aeQx.setOnDoubleClickListener(new NeatTextView.b()
              {
                public final boolean lA(View paramAnonymousView)
                {
                  AppMethodBeat.i(37475);
                  bl.c.a(MMApplicationContext.getContext(), parama, parama1);
                  bl.dJ(paramcc);
                  AppMethodBeat.o(37475);
                  return true;
                }
              });
            }
            label506:
            if ((aw.isDarkMode()) || (!((com.tencent.mm.ui.chatting.component.api.d)parama1.cm(com.tencent.mm.ui.chatting.component.api.d.class)).jry())) {
              break label762;
            }
            localc.aeXa.setBackgroundResource(R.g.voice_to_text_custom_bg);
            label541:
            localc.aeXa.setTextSize(0, com.tencent.mm.cd.a.bs(parama1.aezO.getContext(), R.f.Edge_1_5_A));
            localc.aeWZ.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(255317);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceTo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                bl.l(parama1, paramcc);
                paramAnonymousView.setVisibility(8);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceTo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(255317);
              }
            });
            if (!jxj()) {
              break label862;
            }
            if (localc.aeWU != null) {
              localc.aeWU.setVisibility(8);
            }
            if (localc.aeNG != null) {
              localc.aeNG.setVisibility(8);
            }
            if ((paramcc.field_status != 1) && (paramcc.field_status != 5)) {
              break label776;
            }
            localc.aeWV.setBackgroundResource(R.g.fnx);
            paramcc.adku = true;
          }
        }
        for (;;)
        {
          a(paramInt, localc, paramcc, parama1.getSelfUserName(), parama1.juG(), parama1, this);
          AppMethodBeat.o(37478);
          return;
          if (!localbb.zW(paramcc.field_msgId)) {
            break label901;
          }
          parama = localbb.ar(paramcc.field_msgId, paramcc.field_imgPath);
          paramString = localbb.zV(paramcc.field_msgId);
          break;
          localObject = null;
          break label329;
          if (localc.aeQx == null) {
            break label506;
          }
          localc.aeQx.setVisibility(8);
          break label506;
          label762:
          localc.aeXa.setBackgroundResource(R.g.voice_to_text_bg);
          break label541;
          localc.aeWV.setBackgroundResource(R.g.chatto_bg);
          if ((localc.aeNG != null) && (b(localm, paramcc.field_msgId)))
          {
            if (paramcc.adku)
            {
              parama = new AlphaAnimation(0.5F, 1.0F);
              parama.setDuration(300L);
              localc.aeWV.startAnimation(parama);
              paramcc.adku = false;
            }
            localc.aeNG.setVisibility(0);
            continue;
            label862:
            if (localc.aeWU != null)
            {
              localc.aeWU.setVisibility(0);
              if (paramcc.field_status >= 2) {
                localc.aeWU.setVisibility(8);
              }
            }
          }
        }
        parama = null;
      }
    }
    
    public final boolean a(MenuItem paramMenuItem, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(37480);
      Object localObject = (bb)parama.cm(bb.class);
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(37480);
        return false;
        ((bf)parama.cm(bf.class)).Me(true);
        AppMethodBeat.o(37480);
        return true;
        ((bf)parama.cm(bf.class)).Me(false);
        AppMethodBeat.o(37480);
        return true;
        if (!WeChatBrands.Business.Entries.SessionSpeech2TextSnd.checkAvailable(parama.aezO.getContext()))
        {
          AppMethodBeat.o(37480);
          return true;
        }
        boolean bool = bl.b(paramMenuItem.getGroupId(), parama, paramcc, (bb)localObject, false);
        AppMethodBeat.o(37480);
        return bool;
        paramMenuItem = ((bb)localObject).ar(paramcc.field_msgId, paramcc.field_imgPath);
        if (!Util.isNullOrNil(paramMenuItem)) {
          ClipboardHelper.setText(paramMenuItem);
        }
        bl.g(8, paramcc);
        AppMethodBeat.o(37480);
        return true;
        paramMenuItem = new Intent(parama.aezO.getContext(), MsgRetransmitUI.class);
        localObject = ((bb)localObject).ar(paramcc.field_msgId, paramcc.field_imgPath);
        if (paramcc.jbw())
        {
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 6);
        }
        for (;;)
        {
          paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
          com.tencent.mm.hellhoundlib.a.a.b(parama, paramMenuItem.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          parama.startActivity((Intent)paramMenuItem.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(parama, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$ChattingItemVoiceTo", "onContextItemSelected", "(Landroid/view/MenuItem;Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          bl.g(9, paramcc);
          AppMethodBeat.o(37480);
          return true;
          paramMenuItem.putExtra("Retr_Msg_content", (String)localObject);
          paramMenuItem.putExtra("Retr_Msg_Type", 4);
        }
        localObject = ((bb)localObject).ar(paramcc.field_msgId, paramcc.field_imgPath);
        paramMenuItem = new dn();
        l.b(paramMenuItem, (String)localObject, 1);
        paramMenuItem.hDr.fragment = parama.aezO;
        paramMenuItem.hDr.hDy = 43;
        if (paramMenuItem.hDr.hDt != null)
        {
          parama = paramMenuItem.hDr.hDt.ZBt;
          if (parama != null)
          {
            parama.bto(z.bAM());
            parama.btp(paramcc.field_talker);
            paramMenuItem.publish();
          }
        }
        for (;;)
        {
          bl.g(10, paramcc);
          AppMethodBeat.o(37480);
          return true;
          Log.e("MicroMsg.ChattingItemVoice", "alvinluo transform text fav failed");
        }
        ((bf)parama.cm(bf.class)).cU(paramcc);
      }
    }
    
    public final boolean a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
    {
      AppMethodBeat.i(254923);
      bh.bCz();
      int k;
      bb localbb;
      int i;
      if (com.tencent.mm.model.c.isSDCardAvailable())
      {
        paramContextMenuInfo = (ChattingItemTranslate.a)paramView.getTag();
        k = paramContextMenuInfo.position;
        if (paramContextMenuInfo.viewType == 1)
        {
          paramContextMenuInfo = new com.tencent.mm.modelvoice.p(paramcc.field_content);
          if (((paramContextMenuInfo.time != 0L) || (paramcc.field_isSend != 0)) && ((paramcc.field_status != 1) || (paramcc.field_isSend != 1)))
          {
            if (((bf)this.aeiK.cm(bf.class)).juv()) {
              params.a(k, 120, paramView.getContext().getString(R.l.chatfooter_SpeakerOff), R.k.icons_filled_volume_up);
            }
          }
          else
          {
            if (paramcc.field_status == 5) {
              params.a(k, 103, paramView.getContext().getString(R.l.gzm), R.k.icons_filled_refresh);
            }
            if (com.tencent.mm.br.c.blq("favorite")) {
              params.a(k, 116, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
            }
            if ((!paramcc.iYe()) && (paramcc.iYj()) && ((paramcc.field_status == 2) || (paramcc.kLk == 1)) && (c(paramcc, this.aeiK)) && (bBs(paramcc.field_talker))) {
              params.a(k, 123, paramView.getContext().getString(R.l.gyA), R.k.icons_filled_previous);
            }
            localbb = (bb)this.aeiK.cm(bb.class);
            if (!bl.e(paramcc, this.aeiK)) {
              break label508;
            }
            if (!Util.isNullOrNil(localbb.ar(paramcc.field_msgId, paramcc.field_imgPath))) {
              break label729;
            }
            i = R.l.gyJ;
          }
        }
      }
      for (;;)
      {
        label323:
        if ((com.tencent.mm.model.ab.IS(paramcc.field_talker)) && (LocaleUtil.isChineseAppLang()) && (i != -1)) {
          params.a(k, 121, paramView.getContext().getString(i), R.k.icons_filled_transfer_text);
        }
        for (int j = 1;; j = 0)
        {
          if (((paramContextMenuInfo.time != 0L) || (paramcc.field_isSend != 0)) && ((paramcc.field_status != 1) || (paramcc.field_isSend != 1)) && (!this.aeiK.juH())) {
            params.a(k, 100, paramView.getContext().getString(R.l.gyq), R.k.icons_filled_delete);
          }
          if ((j == 0) && (LocaleUtil.isChineseAppLang()) && (i != -1)) {
            params.a(k, 121, paramView.getContext().getString(i), R.k.icons_filled_transfer_text);
          }
          AppMethodBeat.o(254923);
          return true;
          params.a(k, 119, paramView.getContext().getString(R.l.chatfooter_SpeakerON), R.k.icons_filled_ear);
          break;
          label508:
          if (localbb.zW(paramcc.field_msgId)) {
            break label729;
          }
          i = R.l.gyJ;
          break label323;
          if (paramContextMenuInfo.viewType == 2)
          {
            paramContextMenuInfo = (bb)this.aeiK.cm(bb.class);
            if (paramContextMenuInfo.zV(paramcc.field_msgId) == ChattingItemTranslate.c.aeWg) {
              params.add(k, 121, 0, R.l.gyF);
            }
            for (;;)
            {
              AppMethodBeat.o(254923);
              return false;
              if (!Util.isNullOrNil(paramContextMenuInfo.ar(paramcc.field_msgId, paramcc.field_imgPath)))
              {
                params.a(k, 141, paramView.getContext().getString(R.l.gyl), R.k.icons_filled_copy);
                params.a(k, 142, paramView.getContext().getString(R.l.retransmit), R.k.icons_filled_share);
                if (com.tencent.mm.br.c.blq("favorite")) {
                  params.a(k, 143, paramView.getContext().getString(R.l.plugin_favorite_opt), R.k.icons_filled_favorites);
                }
              }
              params.a(k, 121, paramView.getContext().getString(R.l.gyH), R.k.icons_filled_eyes_off);
            }
          }
          AppMethodBeat.o(254923);
          return true;
        }
        label729:
        i = -1;
      }
    }
    
    public final void b(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(254935);
      ((bf)parama.cm(bf.class)).cU(paramcc);
      AppMethodBeat.o(254935);
    }
    
    public final boolean c(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
    {
      AppMethodBeat.i(37481);
      boolean bool = a(paramView, parama, paramcc, (bz)paramView.getTag());
      AppMethodBeat.o(37481);
      return bool;
    }
    
    public final boolean cM(int paramInt, boolean paramBoolean)
    {
      return (paramBoolean) && (paramInt == 34);
    }
    
    public final boolean fXn()
    {
      return true;
    }
  }
  
  public static final class c
    extends c.a
  {
    ImageView aeNG;
    TextView aeNs;
    ViewStub aeQw;
    ChattingItemTranslate aeQx;
    TextView aeUc;
    int aeWL;
    TextView aeWM;
    TextView aeWN;
    AnimImageView aeWO;
    FrameLayout aeWP;
    FrameLayout aeWQ;
    ImageView aeWR;
    ProgressBar aeWS;
    AnimImageView aeWT;
    ProgressBar aeWU;
    TextView aeWV;
    ImageView aeWW;
    RelativeLayout aeWX;
    TextView aeWY;
    RelativeLayout aeWZ;
    TextView aeXa;
    Animation aeXb;
    
    static void a(Context paramContext, CharSequence paramCharSequence, com.tencent.mm.ui.chatting.d.a parama)
    {
      AppMethodBeat.i(254913);
      Intent localIntent = new Intent(paramContext, TextPreviewUI.class);
      localIntent.putExtra("key_chat_text", paramCharSequence);
      if (parama != null) {
        localIntent.putExtra("is_group_chat", parama.juG());
      }
      paramCharSequence = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramCharSequence.aYi(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$VoiceItemHolder", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramCharSequence.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/ui/chatting/viewitems/ChattingItemVoice$VoiceItemHolder", "goPreviewText", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/tencent/mm/ui/chatting/context/ChattingContext;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.ui.base.b.ne(paramContext);
      AppMethodBeat.o(254913);
    }
    
    private static void a(c paramc, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(37487);
      paramc.stateIV.setVisibility(paramInt2);
      paramc.aeUc.setVisibility(paramInt2);
      paramc.aeWP.setVisibility(paramInt2);
      if (paramBoolean)
      {
        paramc.aeWT.setVisibility(paramInt1);
        paramc.aeNs.setVisibility(paramInt2);
        AppMethodBeat.o(37487);
        return;
      }
      if (paramc.aeWV != null) {
        paramc.aeWV.setVisibility(paramInt1);
      }
      AppMethodBeat.o(37487);
    }
    
    public static void a(c paramc, c paramc1, cc paramcc, int paramInt, com.tencent.mm.ui.chatting.d.a parama, boolean paramBoolean, View.OnLongClickListener paramOnLongClickListener, v.n paramn)
    {
      AppMethodBeat.i(254908);
      if (paramc1 == null)
      {
        AppMethodBeat.o(254908);
        return;
      }
      com.tencent.mm.modelvoice.p localp = new com.tencent.mm.modelvoice.p(paramcc.field_content);
      float f1 = com.tencent.mm.modelvoice.s.jh(localp.time);
      com.tencent.mm.ui.chatting.d locald = ((bf)parama.cm(bf.class)).jut();
      boolean bool1;
      label164:
      label196:
      label455:
      float f2;
      if ((locald != null) && (paramcc.field_msgId == locald.aeeT))
      {
        paramc1.aeWO.setVisibility(0);
        paramc1.aeWO.cKI();
        long l = bl.c(paramcc.field_msgId, localp.time, parama.getTalkerUserName());
        if (l <= 0L) {
          break label776;
        }
        Log.i("MicroMsg.ChattingItemVoice", "[voice interrupt] set continue play visible " + paramcc.field_msgId);
        paramc1.aeWZ.setVisibility(0);
        boolean bool2 = parama.juH();
        if (parama.juG()) {
          break label770;
        }
        bool1 = true;
        com.tencent.mm.ui.report.c.a(bool2, bool1, 1L, paramcc.field_msgId, localp.time, l);
        if (!((bf)parama.cm(bf.class)).Ae(paramcc.field_msgId)) {
          break label788;
        }
        Log.d("MicroMsg.ChattingItemVoice", "startDownloadAnim");
        if (paramc1.aeWS != null)
        {
          paramc1.aeWS.setVisibility(0);
          if (paramc1.aeWN != null) {
            paramc1.aeWN.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
          }
        }
        label258:
        if (paramcc.field_isSend != 0) {
          break label1292;
        }
        if (paramcc.field_status != 5) {
          break label879;
        }
        paramcc.jcp();
        a(paramc1, 8, 0, true);
        paramc1.aeWT.dxz();
        paramc1.aeWT.setVisibility(8);
        paramc1.aeUc.setVisibility(0);
        paramc1.aeWL = com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), aaq((int)f1));
        paramc1.aeWN.setWidth(paramc1.aeWL);
        paramc1.aeUc.setText(parama.aezO.getMMResources().getString(R.l.gIM, new Object[] { Integer.valueOf((int)f1) }));
        paramc1.aeWO.setWidth(com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), aaq((int)f1)));
        if (paramc1.aeWW == null) {
          break label1292;
        }
        paramc1.aeWW.setVisibility(0);
        paramc1.aeWW.setTag(new bz(paramcc, parama.juG(), paramInt, "", '\000'));
        paramc1.aeWW.setOnClickListener(paramc.a(parama, paramn));
        f2 = f1;
        if (1 != paramcc.field_isSend) {
          break label1755;
        }
        if (paramcc.field_status != 1) {
          break label1295;
        }
        paramcc.jcp();
        a(paramc1, 0, 8, false);
        paramc1.aeWQ.setVisibility(8);
        paramc1.jxC();
        label501:
        paramc = ((com.tencent.mm.ui.chatting.component.api.d)parama.cm(com.tencent.mm.ui.chatting.component.api.d.class)).jrx();
        if (paramc != null)
        {
          if (!paramc.XYg) {
            break label1762;
          }
          paramc1.aeUc.setShadowLayer(2.0F, 1.2F, 1.2F, paramc.XYh);
          label547:
          if (!paramc.XYi) {
            break label1776;
          }
          paramc1.aeUc.setBackgroundResource(R.g.fnw);
        }
        label564:
        paramc = new ChattingItemTranslate.a(paramcc, parama.juG(), paramInt);
        paramc1.aeWN.setTag(paramc);
        paramc1.aeWN.setOnClickListener(paramc1.chattingItem.d(parama));
        paramc1.aeWN.setOnLongClickListener(paramOnLongClickListener);
        paramc1.aeWN.setOnTouchListener(((m)parama.cm(m.class)).jqv());
        if ((paramcc.jUq & 0x1) != 1) {
          break label1810;
        }
        paramc1.aeWM.setVisibility(0);
        if (paramcc.field_isSend != 0) {
          break label1787;
        }
        paramc1.aeWO.setBackgroundResource(R.g.fnd);
        label670:
        if (!paramBoolean) {
          break label1862;
        }
        parama.getTalkerUserName();
      }
      for (;;)
      {
        paramc = ((g)parama.cm(g.class)).bAK(parama.getTalkerUserName());
        paramcc = a.a.jlv();
        parama = paramc1.aeWN;
        paramInt = (int)f1;
        if (paramc != null) {
          paramc.toString();
        }
        paramcc.bh(parama, paramInt);
        paramc1.aeUc.setContentDescription(" ");
        AppMethodBeat.o(254908);
        return;
        paramc1.aeWO.setVisibility(8);
        paramc1.aeWO.dxz();
        break;
        label770:
        bool1 = false;
        break label164;
        label776:
        paramc1.aeWZ.setVisibility(8);
        break label196;
        label788:
        Log.d("MicroMsg.ChattingItemVoice", "stopDownloadAnim");
        if (paramc1.aeWS == null) {
          break label258;
        }
        paramc1.aeWS.setVisibility(8);
        if (paramc1.aeWN == null) {
          break label258;
        }
        if (paramBoolean)
        {
          paramc1.aeWN.setCompoundDrawablesWithIntrinsicBounds(bd.by(paramc1.aeWN.getContext(), R.d.chatfrom_voice_playing_f3), null, null, null);
          break label258;
        }
        paramc1.aeWN.setCompoundDrawablesWithIntrinsicBounds(null, null, paramc1.aeWN.getContext().getResources().getDrawable(R.k.chatto_voice_playing), null);
        break label258;
        label879:
        if (localp.time == 0L)
        {
          paramcc.jcp();
          a(paramc1, 8, 0, true);
          paramc1.aeWT.dxz();
          paramc1.aeWT.setVisibility(8);
          paramc1.stateIV.setVisibility(8);
          f2 = 0.0F;
          paramc1.aeWL = com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), aaq(0));
          paramc1.aeWN.setWidth(paramc1.aeWL);
          paramc1.aeUc.setText(parama.aezO.getMMResources().getString(R.l.gIM, new Object[] { Integer.valueOf(0) }));
          paramc1.aeWO.setWidth(com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), aaq(0)));
          f1 = f2;
          if (paramc1.aeWW == null) {
            break label455;
          }
          paramc1.aeWW.setVisibility(8);
          f1 = f2;
          break label455;
        }
        if (localp.time == -1L)
        {
          paramcc.jcp();
          a(paramc1, 8, 0, true);
          paramc1.aeWT.dxz();
          paramc1.aeWT.setVisibility(8);
          paramc1.aeWL = 80;
          paramc1.aeWN.setWidth(80);
          paramc1.aeUc.setVisibility(8);
          paramc1.aeWO.setWidth(com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), aaq((int)f1)));
          if (paramc1.aeWW == null) {
            break label1292;
          }
          paramc1.aeWW.setVisibility(8);
          break label455;
        }
        paramcc.jcp();
        a(paramc1, 8, 0, true);
        paramc1.aeWT.dxz();
        paramc1.aeWT.setVisibility(8);
        paramc1.aeUc.setVisibility(0);
        paramc1.aeWL = com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), aaq((int)f1));
        paramc1.aeWN.setWidth(paramc1.aeWL);
        paramc1.aeUc.setText(parama.aezO.getMMResources().getString(R.l.gIM, new Object[] { Integer.valueOf((int)f1) }));
        paramc1.aeWO.setWidth(com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), aaq((int)f1)));
        if (paramc1.aeWW != null) {
          paramc1.aeWW.setVisibility(8);
        }
        label1292:
        break label455;
        label1295:
        if (paramcc.field_status == 5)
        {
          paramcc.jcp();
          a(paramc1, 8, 0, false);
          paramc1.aeWQ.setVisibility(8);
          paramc1.aeUc.setVisibility(0);
          paramc1.jxC();
          if (localp.time == 0L) {
            f1 = 0.0F;
          }
          paramc1.aeWL = com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), aaq((int)f1));
          paramc1.aeWN.setWidth(paramc1.aeWL);
          paramc1.aeUc.setText(parama.aezO.getMMResources().getString(R.l.gIM, new Object[] { Integer.valueOf((int)f1) }));
          paramc1.aeWO.setWidth(com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), aaq((int)f1)));
          break label501;
        }
        if (localp.time == -1L)
        {
          paramcc.jcp();
          a(paramc1, 8, 0, false);
          paramc1.aeWN.setWidth(80);
          paramc1.aeWL = 80;
          paramc1.aeUc.setVisibility(8);
          paramc1.aeWQ.setVisibility(8);
          paramc1.aeWO.setWidth(com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), aaq((int)f1)));
          paramc1.jxC();
          break label501;
        }
        if (paramcc.field_status == 7)
        {
          paramcc.jcp();
          a(paramc1, 8, 8, false);
          paramc1.aeUc.setVisibility(8);
          paramc1.aeWQ.setVisibility(0);
          paramc1.jxC();
          if (paramc1.aeWR != null)
          {
            paramc1.aeXb = AnimationUtils.loadAnimation(paramc1.convertView.getContext(), R.a.fjN);
            paramc1.aeWR.startAnimation(paramc1.aeXb);
          }
          break label501;
        }
        paramcc.jcp();
        a(paramc1, 8, 0, false);
        paramc1.aeWQ.setVisibility(8);
        paramc1.aeUc.setVisibility(0);
        paramc1.jxC();
        if (localp.time == 0L) {
          f1 = 0.0F;
        }
        paramc1.aeWL = com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), aaq((int)f1));
        paramc1.aeWN.setWidth(paramc1.aeWL);
        paramc1.aeUc.setText(parama.aezO.getMMResources().getString(R.l.gIM, new Object[] { Integer.valueOf((int)f1) }));
        paramc1.aeWO.setWidth(com.tencent.mm.cd.a.fromDPToPix(parama.aezO.getContext(), aaq((int)f1)));
        f2 = f1;
        label1755:
        f1 = f2;
        break label501;
        label1762:
        paramc1.aeUc.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
        break label547;
        label1776:
        paramc1.aeUc.setBackgroundColor(0);
        break label564;
        label1787:
        paramc1.aeWV.setBackgroundResource(R.g.fny);
        paramc1.aeWO.setBackgroundResource(R.g.fny);
        break label670;
        label1810:
        paramc1.aeWM.setVisibility(8);
        if (paramcc.field_isSend == 0)
        {
          paramc1.aeWO.setBackgroundResource(R.g.chatfrom_bg);
          break label670;
        }
        paramc1.aeWV.setBackgroundResource(R.g.chatto_bg);
        paramc1.aeWO.setBackgroundResource(R.g.chatto_bg);
        break label670;
        label1862:
        parama.getSelfUserName();
      }
    }
    
    private static int aaq(int paramInt)
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
    
    private void jxC()
    {
      AppMethodBeat.i(37486);
      if (this.aeXb != null)
      {
        this.aeXb.cancel();
        this.aeXb = null;
      }
      AppMethodBeat.o(37486);
    }
    
    public final c.a d(View paramView, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(37483);
      super.create(paramView);
      this.timeTV = ((TextView)paramView.findViewById(R.h.fAm));
      this.userTV = ((TextView)paramView.findViewById(R.h.fAr));
      this.aeWN = ((TextView)paramView.findViewById(R.h.fAC));
      this.checkBox = ((CheckBox)paramView.findViewById(R.h.fxt));
      this.maskView = paramView.findViewById(R.h.fzn);
      this.stateIV = ((ImageView)paramView.findViewById(R.h.fAj));
      this.aeUc = ((TextView)paramView.findViewById(R.h.fxy));
      this.aeWP = ((FrameLayout)paramView.findViewById(R.h.fAD));
      this.aeWS = ((ProgressBar)paramView.findViewById(R.h.fAz));
      this.aeQw = ((ViewStub)paramView.findViewById(R.h.gaF));
      this.aeWM = ((TextView)paramView.findViewById(R.h.fAA));
      this.aeWO = ((AnimImageView)paramView.findViewById(R.h.fAy));
      this.aeWO.setType(1);
      this.aeWZ = ((RelativeLayout)paramView.findViewById(R.h.fyo));
      this.aeXa = ((TextView)paramView.findViewById(R.h.fyn));
      if (paramBoolean1)
      {
        this.aeWO.setFromVoice(true);
        this.aeWO.setFromGroup(paramBoolean2);
        this.aeNs = ((TextView)paramView.findViewById(R.h.fwD));
        this.aeWT = ((AnimImageView)paramView.findViewById(R.h.fAB));
        this.aeWT.setFromVoice(true);
        this.aeWT.setFromGroup(paramBoolean2);
        this.aeWT.setType(0);
        this.aeWW = ((ImageView)paramView.findViewById(R.h.fyi));
        this.aeWX = ((RelativeLayout)paramView.findViewById(R.h.fyk));
        this.aeWY = ((TextView)paramView.findViewById(R.h.fyj));
      }
      for (;;)
      {
        AppMethodBeat.o(37483);
        return this;
        this.aeWQ = ((FrameLayout)paramView.findViewById(R.h.fAI));
        this.aeWR = ((ImageView)paramView.findViewById(R.h.fAJ));
        this.aeWU = ((ProgressBar)paramView.findViewById(R.h.fAK));
        this.uploadingPB = ((ProgressBar)paramView.findViewById(R.h.gbo));
        this.aeWV = ((TextView)paramView.findViewById(R.h.fAL));
        this.aeWO.setFromVoice(false);
        this.aeWO.setFromGroup(paramBoolean2);
        this.aeNG = ((ImageView)paramView.findViewById(R.h.chatting_status_tick));
      }
    }
    
    public final View getMainContainerView()
    {
      return this.aeWP;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bl
 * JD-Core Version:    0.7.0.1
 */