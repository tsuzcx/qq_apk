package com.tencent.mm.ui.chatting.d;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.api.c.b;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.xy;
import com.tencent.mm.g.a.xz;
import com.tencent.mm.g.a.ya;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.d;
import com.tencent.mm.model.au.f;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.ui.chatting.d.b.af;
import com.tencent.mm.ui.chatting.d.b.l;
import com.tencent.mm.ui.chatting.viewitems.az.a;
import com.tencent.mm.ui.tools.w;
import com.tencent.mm.ui.y.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.d.a.a(fJv=com.tencent.mm.ui.chatting.d.b.at.class)
public class bf
  extends a
  implements com.tencent.mm.ak.f, com.tencent.mm.ui.chatting.d.b.at
{
  private static Object lock;
  private au.d BCM;
  private com.tencent.mm.sdk.b.c<xz> KjA;
  private com.tencent.mm.sdk.b.c<ya> KjB;
  private View KjC;
  public ChatFooter.d KjD;
  private com.tencent.mm.sdk.b.c<xy> KjE;
  private List<WeakReference<View>> KjF;
  private com.tencent.mm.ui.chatting.d Kjn;
  private boolean Kjo;
  private long Kjp;
  private WeakReference<View> Kjq;
  private ConcurrentHashMap<Long, Boolean> Kjr;
  private boolean Kjs;
  private o Kjt;
  private boolean Kju;
  private boolean Kjv;
  private long Kjw;
  private boolean Kjx;
  private long Kjy;
  private bf.a Kjz;
  private Future OAv;
  private Future dkp;
  private int minHeight;
  public boolean pEW;
  
  static
  {
    AppMethodBeat.i(187455);
    lock = new Object();
    AppMethodBeat.o(187455);
  }
  
  public bf()
  {
    AppMethodBeat.i(35775);
    this.Kjn = null;
    this.pEW = false;
    this.Kjo = false;
    this.Kjr = new ConcurrentHashMap();
    this.Kjs = false;
    this.Kjt = new o()
    {
      public final void onAppBackground(String paramAnonymousString)
      {
        AppMethodBeat.i(187426);
        if (bf.a(bf.this)) {
          com.tencent.e.h.MqF.aM(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(187425);
              bf.this.releaseWakeLock();
              AppMethodBeat.o(187425);
            }
          });
        }
        AppMethodBeat.o(187426);
      }
      
      public final void onAppForeground(String paramAnonymousString) {}
    };
    this.Kju = false;
    this.minHeight = -1;
    this.Kjv = false;
    this.dkp = null;
    this.Kjw = -1L;
    this.Kjx = false;
    this.Kjy = -1L;
    this.Kjz = null;
    this.OAv = null;
    this.BCM = new au.d()
    {
      public final void A(String paramAnonymousString, final long paramAnonymousLong)
      {
        AppMethodBeat.i(187428);
        ae.d("MicroMsg.ChattingUI.VoiceComponent", "onVoiceRemind " + paramAnonymousString + " time " + paramAnonymousLong);
        if (x.AL(bc.getNotification().Xn())) {
          com.tencent.mm.ui.base.h.a(bf.this.cXJ.Kkd.getContext(), false, paramAnonymousString, bf.this.cXJ.Kkd.getMMResources().getString(2131764760), bf.this.cXJ.Kkd.getMMResources().getString(2131764757), bf.this.cXJ.Kkd.getMMResources().getString(2131764759), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(187427);
              bc.aCg();
              if (com.tencent.mm.model.c.azI().aO(bc.getNotification().Xn(), paramAnonymousLong))
              {
                int i = ((com.tencent.mm.ui.chatting.d.b.k)bf.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class)).ftv();
                paramAnonymous2Int = ((com.tencent.mm.ui.chatting.d.b.k)bf.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class)).getCount();
                bc.aCg();
                i = com.tencent.mm.model.c.azI().h(bc.getNotification().Xn(), paramAnonymousLong, i - paramAnonymous2Int);
                if (i < 0)
                {
                  AppMethodBeat.o(187427);
                  return;
                }
                if (paramAnonymous2Int > i) {
                  bf.this.cXJ.adC(i);
                }
              }
              AppMethodBeat.o(187427);
            }
          }, null);
        }
        AppMethodBeat.o(187428);
      }
    };
    this.KjA = new com.tencent.mm.sdk.b.c() {};
    this.KjB = new com.tencent.mm.sdk.b.c() {};
    this.KjC = null;
    this.KjD = new ChatFooter.d()
    {
      public final void m(Boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(187434);
        if (paramAnonymousBoolean.booleanValue())
        {
          if (bf.h(bf.this) == null) {
            bf.a(bf.this, ((ViewStub)bf.this.cXJ.findViewById(2131306457)).inflate());
          }
          bf.h(bf.this).setVisibility(0);
          AppMethodBeat.o(187434);
          return;
        }
        if ((bf.h(bf.this) != null) && (bf.h(bf.this).getVisibility() == 0)) {
          bf.h(bf.this).setVisibility(8);
        }
        AppMethodBeat.o(187434);
      }
    };
    this.KjE = new com.tencent.mm.sdk.b.c() {};
    this.KjF = new ArrayList();
    AppMethodBeat.o(35775);
  }
  
  private void ehQ()
  {
    AppMethodBeat.i(187440);
    ae.i("MicroMsg.ChattingUI.VoiceComponent", "voiceComponent doPause");
    this.Kjo = false;
    if ((x.AL(this.cXJ.getTalkerUserName())) && (au.a.hIJ != null)) {
      au.a.hIJ.b(this.BCM);
    }
    if ((this.KjC != null) && (this.KjC.getVisibility() == 0))
    {
      ae.i("MicroMsg.ChattingUI.VoiceComponent", "doPause set voiceinputMask GONE");
      this.KjC.setVisibility(8);
    }
    ((com.tencent.mm.ui.chatting.d.b.s)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.s.class)).setVoiceInputShowCallback(null);
    bc.aCg();
    com.tencent.mm.model.c.ajA().set(26, Boolean.valueOf(this.pEW));
    if ((this.Kjn != null) && (this.Kjn.isPlaying()))
    {
      localw = w.Lim;
      if (!w.fPd())
      {
        this.Kjs = true;
        localw = w.Lim;
        w.yR(true);
        AppForegroundDelegate.cTA.a(this.Kjt);
        AppMethodBeat.o(187440);
        return;
      }
    }
    w localw = w.Lim;
    w.yR(true);
    if ((!com.tencent.mm.ui.s.fAT()) && (this.Kjn != null))
    {
      this.Kjn.fEH();
      this.Kjn.apj();
      this.Kjn.release();
    }
    AppMethodBeat.o(187440);
  }
  
  public static boolean fJt()
  {
    AppMethodBeat.i(187451);
    int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qMd, 0);
    ae.i("MicroMsg.ChattingUI.VoiceComponent", "isOpenVoiceTransTextBt() swt:%s", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      AppMethodBeat.o(187451);
      return true;
    }
    AppMethodBeat.o(187451);
    return false;
  }
  
  public final void EE(long paramLong)
  {
    AppMethodBeat.i(187441);
    this.Kjr.put(Long.valueOf(paramLong), Boolean.TRUE);
    AppMethodBeat.o(187441);
  }
  
  public final boolean EF(long paramLong)
  {
    AppMethodBeat.i(187442);
    if (this.Kjr.containsKey(Long.valueOf(paramLong)))
    {
      boolean bool = ((Boolean)this.Kjr.get(Long.valueOf(paramLong))).booleanValue();
      AppMethodBeat.o(187442);
      return bool;
    }
    AppMethodBeat.o(187442);
    return false;
  }
  
  public final void EG(long paramLong)
  {
    AppMethodBeat.i(187444);
    if (this.Kjw == paramLong) {}
    synchronized (lock)
    {
      this.Kju = true;
      ??? = ((com.tencent.mm.ui.chatting.d.b.k)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class)).Er(this.Kjw);
      if (??? != null)
      {
        ??? = (RelativeLayout)((View)???).findViewById(2131308480);
        if (??? != null)
        {
          this.Kjw = -1L;
          ((RelativeLayout)???).setVisibility(8);
        }
      }
      AppMethodBeat.o(187444);
      return;
    }
  }
  
  public final void EH(long paramLong)
  {
    AppMethodBeat.i(187445);
    synchronized (lock)
    {
      this.Kju = true;
      if (this.Kjw == paramLong)
      {
        ??? = ((com.tencent.mm.ui.chatting.d.b.k)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class)).Er(this.Kjw);
        if (??? != null)
        {
          ??? = (RelativeLayout)((View)???).findViewById(2131308480);
          if (??? != null)
          {
            this.Kjw = -1L;
            ((RelativeLayout)???).setVisibility(8);
          }
        }
      }
      AppMethodBeat.o(187445);
      return;
    }
  }
  
  public final boolean EI(long paramLong)
  {
    return this.Kjw == paramLong;
  }
  
  public final boolean Pd()
  {
    AppMethodBeat.i(35777);
    boolean bool1 = ((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGJ();
    boolean bool2 = ((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGK();
    int i;
    if ((this.cXJ.fJB()) || (bool2)) {
      i = 1;
    }
    while (bool1) {
      if (bool2)
      {
        bool1 = ((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGH().hk(1);
        AppMethodBeat.o(35777);
        return bool1;
        i = 0;
      }
      else
      {
        bool1 = ((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGI().hk(1);
        AppMethodBeat.o(35777);
        return bool1;
      }
    }
    if (((i != 0) && (this.cXJ.Cqh.eRd == 0)) || (this.cXJ.Cqh.Pd()))
    {
      AppMethodBeat.o(35777);
      return true;
    }
    AppMethodBeat.o(35777);
    return false;
  }
  
  public final void a(long paramLong, View paramView)
  {
    AppMethodBeat.i(187443);
    this.Kjp = paramLong;
    this.Kjq = new WeakReference(paramView);
    AppMethodBeat.o(187443);
  }
  
  @TargetApi(9)
  public final void a(MMFragment paramMMFragment, boolean paramBoolean)
  {
    AppMethodBeat.i(35784);
    if (paramMMFragment.getLandscapeMode()) {
      if (paramBoolean)
      {
        if (Build.VERSION.SDK_INT >= 9)
        {
          ae.i("MicroMsg.ChattingUI.VoiceComponent", "rotation %d", new Object[] { Integer.valueOf(paramMMFragment.getWindowManager().getDefaultDisplay().getOrientation()) });
          switch (paramMMFragment.getWindowManager().getDefaultDisplay().getOrientation())
          {
          default: 
            AppMethodBeat.o(35784);
            return;
          case 0: 
            paramMMFragment.setRequestedOrientation(1);
            AppMethodBeat.o(35784);
            return;
          case 1: 
            paramMMFragment.setRequestedOrientation(0);
            AppMethodBeat.o(35784);
            return;
          case 2: 
            paramMMFragment.setRequestedOrientation(9);
            AppMethodBeat.o(35784);
            return;
          }
          paramMMFragment.setRequestedOrientation(8);
          AppMethodBeat.o(35784);
          return;
        }
        if (this.cXJ.Kkd.getMMResources().getConfiguration().orientation == 2)
        {
          paramMMFragment.setRequestedOrientation(0);
          AppMethodBeat.o(35784);
          return;
        }
        if (this.cXJ.Kkd.getMMResources().getConfiguration().orientation == 1)
        {
          paramMMFragment.setRequestedOrientation(1);
          AppMethodBeat.o(35784);
        }
      }
      else
      {
        paramMMFragment.setRequestedOrientation(-1);
      }
    }
    AppMethodBeat.o(35784);
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(187447);
    super.a(parama);
    this.KjE.alive();
    AppMethodBeat.o(187447);
  }
  
  public final void acquireWakeLock()
  {
    AppMethodBeat.i(35779);
    this.cXJ.setKeepScreenOn(true);
    AppMethodBeat.o(35779);
  }
  
  public final boolean bV(bv parambv)
  {
    AppMethodBeat.i(35782);
    if (parambv.ftf())
    {
      if (parambv.field_msgId == this.Kjn.JTd) {
        this.Kjn.apj();
      }
      AppMethodBeat.o(35782);
      return true;
    }
    AppMethodBeat.o(35782);
    return false;
  }
  
  public final boolean bW(bv parambv)
  {
    AppMethodBeat.i(35783);
    if (parambv.ftf())
    {
      bc.aCg();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getContentView());
        AppMethodBeat.o(35783);
        return true;
      }
      if (parambv.field_msgId == this.Kjn.JTd) {
        this.Kjn.apj();
      }
      if (!this.cXJ.getTalkerUserName().equals("medianote"))
      {
        bc.aCg();
        com.tencent.mm.model.c.azE().d(new com.tencent.mm.ba.f(parambv.field_talker, parambv.field_msgSvrId));
      }
      ak.br(parambv);
      AppMethodBeat.o(35783);
      return true;
    }
    AppMethodBeat.o(35783);
    return false;
  }
  
  public final void fAt()
  {
    AppMethodBeat.i(35787);
    fJo();
    AppMethodBeat.o(35787);
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(35788);
    bc.ajj().a(127, this);
    this.KjA.alive();
    this.KjB.alive();
    this.Kju = false;
    fJs();
    AppMethodBeat.o(35788);
  }
  
  public final void fAv()
  {
    AppMethodBeat.i(35789);
    ae.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay looper[%s]", new Object[] { Looper.myLooper() });
    this.Kjo = true;
    long l = System.currentTimeMillis();
    Object localObject;
    if (!this.Kjs)
    {
      ae.i("MicroMsg.ChattingUI.VoiceComponent", "resetAutoPlay autoPlay is:%s tid:%d looper:%s", new Object[] { this.Kjn, Long.valueOf(Thread.currentThread().getId()), Looper.myLooper() });
      if (this.Kjn != null) {
        break label398;
      }
      this.Kjn = new com.tencent.mm.ui.chatting.d(this.cXJ, this, this.cXJ.getTalkerUserName());
      com.tencent.mm.modelvoice.t.c(this.Kjn);
      e.a(this.Kjn);
      bc.aCg();
      bool = bu.a((Boolean)com.tencent.mm.model.c.ajA().get(16387, null), true);
      localObject = this.Kjn;
      if (!((com.tencent.mm.ui.chatting.d)localObject).JTj)
      {
        ((com.tencent.mm.ui.chatting.d)localObject).JTh = bool;
        ((com.tencent.mm.ui.chatting.d)localObject).fEH();
      }
      localObject = ((com.tencent.mm.ui.chatting.d.b.d)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGG();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.api.c)localObject).bX(false);
        if (localObject != null)
        {
          if (((c.b)localObject).cRf != null)
          {
            if (((c.b)localObject).cRf.optInt("AudioPlayType", 0) != 1) {
              break label415;
            }
            bool = true;
            label234:
            ((c.b)localObject).cRv = bool;
          }
          if (((c.b)localObject).cRv) {
            this.Kjn.JTi = false;
          }
        }
      }
      localObject = this.Kjn;
      if (this.pEW) {
        break label420;
      }
    }
    label398:
    label415:
    label420:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.ui.chatting.d)localObject).xW(bool);
      this.Kjn.xV(true);
      ae.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay end take[%s]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      if ((x.AL(this.cXJ.getTalkerUserName())) && (au.a.hIJ != null)) {
        au.a.hIJ.a(this.BCM);
      }
      if (!com.tencent.mm.aw.b.aJB()) {
        ((com.tencent.mm.ui.chatting.d.b.s)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.s.class)).setVoiceInputShowCallback(this.KjD);
      }
      fJo();
      AppForegroundDelegate.cTA.b(this.Kjt);
      localObject = w.Lim;
      w.yR(true);
      AppMethodBeat.o(35789);
      return;
      this.Kjn.aXq(this.cXJ.getTalkerUserName());
      break;
      bool = false;
      break label234;
    }
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(35790);
    ehQ();
    AppMethodBeat.o(35790);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(35791);
    bc.ajj().b(127, this);
    if (this.OAv != null) {
      this.OAv.cancel(true);
    }
    this.KjA.dead();
    this.KjB.dead();
    this.Kjr.clear();
    AppMethodBeat.o(35791);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(35785);
    super.fGE();
    ae.i("MicroMsg.ChattingUI.VoiceComponent", "doDestroy, autoPlay:%s", new Object[] { this.Kjn });
    com.tencent.mm.modelvoice.t.b(this.Kjn);
    e.b(this.Kjn);
    bc.ajj().b(127, this);
    releaseWakeLock();
    if (this.Kjn != null)
    {
      this.Kjn.fEH();
      com.tencent.mm.ui.chatting.d locald = this.Kjn;
      locald.release();
      locald.pEU.unInit();
      locald.context = null;
      locald.JTj = false;
      com.tencent.mm.sdk.b.a.IvT.d(locald.JTo);
      bc.MW().b(locald);
      this.Kjn = null;
    }
    this.KjE.dead();
    AppMethodBeat.o(35785);
  }
  
  public final com.tencent.mm.ui.chatting.d fJn()
  {
    return this.Kjn;
  }
  
  public final void fJo()
  {
    AppMethodBeat.i(35778);
    com.tencent.mm.ui.chatting.d.b.y localy = (com.tencent.mm.ui.chatting.d.b.y)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.y.class);
    Object localObject = (l)this.cXJ.bh(l.class);
    af localaf = (af)this.cXJ.bh(af.class);
    if ((((l)localObject).fHv()) || (localaf.fID()))
    {
      ae.d("MicroMsg.ChattingUI.VoiceComponent", "trigger title icon, in show mode");
      this.cXJ.yh(false);
      localy.setTitlePhoneIconVisibility(8);
      localy.setTitleMuteIconVisibility(8);
      AppMethodBeat.o(35778);
      return;
    }
    if (((com.tencent.mm.plugin.forcenotify.a.b)g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).akx(this.cXJ.getTalkerUserName()))
    {
      localy.setTitleForceNotifyIconVisibility(0);
      localy.setTitleMuteIconVisibility(8);
      label147:
      bc.aCg();
      localObject = (Boolean)com.tencent.mm.model.c.ajA().get(26, null);
      if (localObject != null) {
        break label244;
      }
      this.pEW = false;
      label173:
      ae.m("MicroMsg.ChattingUI.VoiceComponent", "triggerTitleIcon and setForceSpeakOff value is %s", new Object[] { Boolean.valueOf(this.pEW) });
      if (!this.pEW) {
        break label255;
      }
    }
    label244:
    label255:
    for (int i = 0;; i = 8)
    {
      localy.setTitlePhoneIconVisibility(i);
      AppMethodBeat.o(35778);
      return;
      localy.setTitleForceNotifyIconVisibility(8);
      if (!Pd()) {
        break;
      }
      localy.setTitleMuteIconVisibility(0);
      break label147;
      this.pEW = ((Boolean)localObject).booleanValue();
      break label173;
    }
  }
  
  public final boolean fJp()
  {
    return this.pEW;
  }
  
  public final void fJq()
  {
    this.Kjp = 0L;
  }
  
  public final void fJr()
  {
    AppMethodBeat.i(187446);
    this.Kjx = true;
    fJs();
    AppMethodBeat.o(187446);
  }
  
  public final void fJs()
  {
    AppMethodBeat.i(187450);
    if (((af)this.cXJ.bh(af.class)).fID())
    {
      AppMethodBeat.o(187450);
      return;
    }
    if (!fJt())
    {
      AppMethodBeat.o(187450);
      return;
    }
    final com.tencent.mm.ui.chatting.d.b.k localk = (com.tencent.mm.ui.chatting.d.b.k)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class);
    final SparseArray localSparseArray = localk.fGk();
    if (localSparseArray != null) {
      this.OAv = com.tencent.e.h.MqF.aM(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187438);
          ae.d("MicroMsg.ChattingUI.VoiceComponent", "showVoiceFastTransTextBt lastScrollState:%s", new Object[] { bf.l(bf.this) });
          long l = bf.m(bf.this);
          bf.a(bf.this, -1L);
          int j = bf.n(bf.this);
          bf.o(bf.this).clear();
          int i = localSparseArray.size() - 1;
          Object localObject1 = null;
          Object localObject2;
          Object localObject3;
          if (i >= 0)
          {
            localObject2 = (bv)localSparseArray.get(i);
            localObject3 = bf.a(bf.this, localk, (bv)localObject2, j);
            if (!((Boolean)((Pair)localObject3).second).booleanValue()) {
              break label473;
            }
            localObject1 = localObject2;
          }
          label467:
          label473:
          for (;;)
          {
            localObject2 = localObject1;
            if (((Boolean)((Pair)localObject3).first).booleanValue())
            {
              i -= 1;
              break;
              localObject2 = localObject1;
            }
            if (localObject2 != null)
            {
              localObject1 = ((ei)localObject2).field_msgId + "_" + ((ei)localObject2).field_content;
              ae.i("MicroMsg.ChattingUI.VoiceComponent", "showVoiceFastTransTextBt msg:%s", new Object[] { localObject1 });
              if (localObject2 == null) {
                break label467;
              }
              localObject1 = localk.Er(((ei)localObject2).field_msgId);
              if (localObject1 == null) {
                break label467;
              }
              localObject1 = (RelativeLayout)((View)localObject1).findViewById(2131308480);
              if (localObject1 != null) {
                bf.a(bf.this, ((ei)localObject2).field_msgId);
              }
            }
            for (;;)
            {
              if ((l != 0L) && ((localObject2 == null) || (l != ((ei)localObject2).field_msgId)))
              {
                localObject2 = localk.Er(l);
                if (localObject2 != null)
                {
                  localObject2 = (RelativeLayout)((View)localObject2).findViewById(2131308480);
                  if (localObject2 != null) {
                    bf.o(bf.this).add(new WeakReference(localObject2));
                  }
                }
              }
              localObject2 = bf.o(bf.this).iterator();
              for (;;)
              {
                if (((Iterator)localObject2).hasNext())
                {
                  localObject3 = (WeakReference)((Iterator)localObject2).next();
                  if ((localObject3 != null) && (((WeakReference)localObject3).get() != null) && (((WeakReference)localObject3).get() != localObject1))
                  {
                    ((View)((WeakReference)localObject3).get()).setVisibility(8);
                    continue;
                    localObject1 = "null";
                    break;
                  }
                }
              }
              if (localObject1 != null)
              {
                ((RelativeLayout)localObject1).setVisibility(0);
                if (l != bf.m(bf.this)) {
                  az.a.aQ(1, bf.m(bf.this));
                }
              }
              AppMethodBeat.o(187438);
              return;
              localObject1 = null;
            }
          }
        }
      });
    }
    AppMethodBeat.o(187450);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(35786);
    AppMethodBeat.o(35786);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 1;
    AppMethodBeat.i(35792);
    ae.i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramn.getType());
    this.cXJ.dismissDialog();
    if (!this.cXJ.cCq)
    {
      ae.i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35792);
      return;
    }
    if (!bu.jn(this.cXJ.Kkd.getContext()))
    {
      AppMethodBeat.o(35792);
      return;
    }
    Activity localActivity = this.cXJ.Kkd.getContext();
    if (y.a.a(localActivity, paramInt1, paramInt2, paramString, 7)) {}
    while (i != 0)
    {
      AppMethodBeat.o(35792);
      return;
      if (!com.tencent.mm.ui.y.a(localActivity, paramInt1, paramInt2, new Intent().setClass(localActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
        i = 0;
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      switch (paramn.getType())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35792);
      return;
      paramString = com.tencent.mm.modelvoice.s.IC(((com.tencent.mm.modelvoice.f)paramn).fileName);
      if ((paramString != null) && (paramString.status == 99)) {
        be.aI(this.cXJ.Kkd.getContext(), 2131755246);
      }
    }
  }
  
  public final void onScroll(AbsListView arg1, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(187449);
    if (paramInt2 == 0)
    {
      ae.w("MicroMsg.ChattingUI.VoiceComponent", "onScroll visibleItemCount == 0");
      AppMethodBeat.o(187449);
      return;
    }
    long l = System.currentTimeMillis();
    if ((this.Kjy != -1L) && (l - this.Kjy > 2000L)) {
      this.Kjx = false;
    }
    this.Kjy = l;
    Object localObject1 = (com.tencent.mm.ui.chatting.d.b.k)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class);
    ??? = new bf.a();
    int i = this.cXJ.getHeaderViewsCount();
    bv localbv = ((com.tencent.mm.ui.chatting.d.b.k)localObject1).adI(paramInt1 - i);
    if (localbv != null) {
      ???.KjN = localbv.field_msgId;
    }
    for (;;)
    {
      int j = paramInt1 - i + paramInt2 + 2;
      i = j;
      if (j > ((com.tencent.mm.ui.chatting.d.b.k)localObject1).getCount() - 1) {
        i = ((com.tencent.mm.ui.chatting.d.b.k)localObject1).getCount() - 1;
      }
      localObject1 = ((com.tencent.mm.ui.chatting.d.b.k)localObject1).adI(i);
      if (localObject1 != null) {
        ???.KjO = ((ei)localObject1).field_msgId;
      }
      this.Kjz = ???;
      ae.d("MicroMsg.ChattingUI.VoiceComponent", "onScroll firstVisibleItem:%s visibleItemCount:%s totalItemCount:%s isNoSmoothScrool:%s ifScroll:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(this.Kjx), Boolean.valueOf(this.Kjv) });
      if (!this.Kjv) {
        break;
      }
      this.Kjx = false;
      if (this.dkp != null) {
        this.dkp.cancel(true);
      }
      this.dkp = com.tencent.e.h.MqF.q(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(187437);
          synchronized (bf.fJu())
          {
            if (bf.j(bf.this))
            {
              AppMethodBeat.o(187437);
              return;
            }
            bf.this.fJs();
            bf.k(bf.this);
            AppMethodBeat.o(187437);
            return;
          }
        }
      }, 300L);
      AppMethodBeat.o(187449);
      return;
      localbv = ((com.tencent.mm.ui.chatting.d.b.k)localObject1).adI(paramInt1 + 1 - i);
      if (localbv != null) {
        ???.KjN = localbv.field_msgId;
      }
    }
    synchronized (lock)
    {
      if (this.Kju)
      {
        this.Kjx = false;
        AppMethodBeat.o(187449);
        return;
      }
      if (this.Kjx)
      {
        this.Kjx = false;
        AppMethodBeat.o(187449);
        return;
      }
    }
    this.Kjx = true;
    fJs();
    AppMethodBeat.o(187449);
  }
  
  public final void onScrollStateChanged(AbsListView arg1, int paramInt)
  {
    AppMethodBeat.i(187448);
    super.onScrollStateChanged(???, paramInt);
    ae.i("MicroMsg.ChattingUI.VoiceComponent", "onScrollStateChanged %s", new Object[] { Integer.valueOf(paramInt) });
    this.Kjx = false;
    if (paramInt == 0)
    {
      this.Kjv = false;
      synchronized (lock)
      {
        if (this.Kju)
        {
          AppMethodBeat.o(187448);
          return;
        }
        fJs();
        AppMethodBeat.o(187448);
        return;
      }
    }
    this.Kjv = true;
    AppMethodBeat.o(187448);
  }
  
  public final void releaseWakeLock()
  {
    AppMethodBeat.i(35780);
    this.cXJ.setKeepScreenOn(false);
    if ((this.Kjn != null) && (this.Kjs))
    {
      this.Kjs = false;
      this.Kjn.fEH();
      this.Kjn.apj();
      this.Kjn.release();
    }
    AppForegroundDelegate.cTA.b(this.Kjt);
    this.Kjs = false;
    AppMethodBeat.o(35780);
  }
  
  public final void yg(boolean paramBoolean)
  {
    AppMethodBeat.i(35781);
    if (this.Kjn == null)
    {
      ae.e("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff error, autoPlay is null!!!");
      AppMethodBeat.o(35781);
      return;
    }
    ae.m("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff value is %s", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.ui.chatting.d.b.y localy = (com.tencent.mm.ui.chatting.d.b.y)this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.y.class);
    if (paramBoolean)
    {
      this.Kjn.xW(false);
      this.pEW = true;
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(26, Boolean.TRUE);
      localy.setTitlePhoneIconVisibility(0);
      Toast.makeText(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131759557), 0).show();
      this.Kjn.fEL();
      this.cXJ.adZ(2131689483);
      AppMethodBeat.o(35781);
      return;
    }
    if (!com.tencent.mm.plugin.audio.c.a.bHz()) {
      this.Kjn.xW(true);
    }
    for (;;)
    {
      this.pEW = false;
      bc.aCg();
      com.tencent.mm.model.c.ajA().set(26, Boolean.FALSE);
      localy.setTitlePhoneIconVisibility(8);
      Toast.makeText(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131759558), 0).show();
      this.Kjn.fEL();
      this.cXJ.adZ(2131689503);
      AppMethodBeat.o(35781);
      return;
      ae.i("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff true but isBluetoothOn");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.bf
 * JD-Core Version:    0.7.0.1
 */