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
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.xu;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.d;
import com.tencent.mm.model.as.f;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.aj;
import com.tencent.mm.ui.chatting.d.b.af;
import com.tencent.mm.ui.chatting.d.b.as;
import com.tencent.mm.ui.chatting.d.b.l;
import com.tencent.mm.ui.y.a;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.d.a.a(fFo=as.class)
public class be
  extends a
  implements com.tencent.mm.al.f, as
{
  private as.d Bln;
  private com.tencent.mm.ui.chatting.d JOq;
  private boolean JOr;
  private long JOs;
  private WeakReference<View> JOt;
  private ConcurrentHashMap<Long, Boolean> JOu;
  private com.tencent.mm.sdk.b.c<xu> JOv;
  private View JOw;
  public ChatFooter.d JOx;
  public boolean pys;
  
  public be()
  {
    AppMethodBeat.i(35775);
    this.JOq = null;
    this.pys = false;
    this.JOr = false;
    this.JOu = new ConcurrentHashMap();
    this.Bln = new as.d()
    {
      public final void A(String paramAnonymousString, final long paramAnonymousLong)
      {
        AppMethodBeat.i(35773);
        ad.d("MicroMsg.ChattingUI.VoiceComponent", "onVoiceRemind " + paramAnonymousString + " time " + paramAnonymousLong);
        if (w.Ab(ba.getNotification().Xf())) {
          com.tencent.mm.ui.base.h.a(be.this.cWM.JOR.getContext(), false, paramAnonymousString, be.this.cWM.JOR.getMMResources().getString(2131764760), be.this.cWM.JOR.getMMResources().getString(2131764757), be.this.cWM.JOR.getMMResources().getString(2131764759), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(35772);
              ba.aBQ();
              if (com.tencent.mm.model.c.azs().aN(ba.getNotification().Xf(), paramAnonymousLong))
              {
                int i = ((com.tencent.mm.ui.chatting.d.b.k)be.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fpw();
                paramAnonymous2Int = ((com.tencent.mm.ui.chatting.d.b.k)be.this.cWM.bh(com.tencent.mm.ui.chatting.d.b.k.class)).getCount();
                ba.aBQ();
                i = com.tencent.mm.model.c.azs().h(ba.getNotification().Xf(), paramAnonymousLong, i - paramAnonymous2Int);
                if (i < 0)
                {
                  AppMethodBeat.o(35772);
                  return;
                }
                if (paramAnonymous2Int > i) {
                  be.this.cWM.acU(i);
                }
              }
              AppMethodBeat.o(35772);
            }
          }, null);
        }
        AppMethodBeat.o(35773);
      }
    };
    this.JOv = new com.tencent.mm.sdk.b.c() {};
    this.JOw = null;
    this.JOx = new ChatFooter.d()
    {
      public final void m(Boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(194115);
        if (paramAnonymousBoolean.booleanValue())
        {
          if (be.e(be.this) == null) {
            be.a(be.this, ((ViewStub)be.this.cWM.findViewById(2131306457)).inflate());
          }
          be.e(be.this).setVisibility(0);
          AppMethodBeat.o(194115);
          return;
        }
        if ((be.e(be.this) != null) && (be.e(be.this).getVisibility() == 0)) {
          be.e(be.this).setVisibility(8);
        }
        AppMethodBeat.o(194115);
      }
    };
    AppMethodBeat.o(35775);
  }
  
  public final void Ef(long paramLong)
  {
    AppMethodBeat.i(194116);
    this.JOu.put(Long.valueOf(paramLong), Boolean.TRUE);
    AppMethodBeat.o(194116);
  }
  
  public final boolean Eg(long paramLong)
  {
    AppMethodBeat.i(194117);
    if (this.JOu.containsKey(Long.valueOf(paramLong)))
    {
      boolean bool = ((Boolean)this.JOu.get(Long.valueOf(paramLong))).booleanValue();
      AppMethodBeat.o(194117);
      return bool;
    }
    AppMethodBeat.o(194117);
    return false;
  }
  
  public final boolean Pf()
  {
    AppMethodBeat.i(35777);
    boolean bool1 = ((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCH();
    boolean bool2 = ((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCI();
    int i;
    if ((this.cWM.fFu()) || (bool2)) {
      i = 1;
    }
    while (bool1) {
      if (bool2)
      {
        bool1 = ((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCF().hj(1);
        AppMethodBeat.o(35777);
        return bool1;
        i = 0;
      }
      else
      {
        bool1 = ((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCG().hj(1);
        AppMethodBeat.o(35777);
        return bool1;
      }
    }
    if (((i != 0) && (this.cWM.BYG.ePs == 0)) || (this.cWM.BYG.Pf()))
    {
      AppMethodBeat.o(35777);
      return true;
    }
    AppMethodBeat.o(35777);
    return false;
  }
  
  public final void a(long paramLong, View paramView)
  {
    AppMethodBeat.i(194118);
    this.JOs = paramLong;
    this.JOt = new WeakReference(paramView);
    AppMethodBeat.o(194118);
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
          ad.i("MicroMsg.ChattingUI.VoiceComponent", "rotation %d", new Object[] { Integer.valueOf(paramMMFragment.getWindowManager().getDefaultDisplay().getOrientation()) });
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
        if (this.cWM.JOR.getMMResources().getConfiguration().orientation == 2)
        {
          paramMMFragment.setRequestedOrientation(0);
          AppMethodBeat.o(35784);
          return;
        }
        if (this.cWM.JOR.getMMResources().getConfiguration().orientation == 1)
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
  
  public final void acquireWakeLock()
  {
    AppMethodBeat.i(35779);
    this.cWM.setKeepScreenOn(true);
    AppMethodBeat.o(35779);
  }
  
  public final boolean bV(bu parambu)
  {
    AppMethodBeat.i(35782);
    if (parambu.fph())
    {
      if (parambu.field_msgId == this.JOq.Jyn) {
        this.JOq.aoV();
      }
      AppMethodBeat.o(35782);
      return true;
    }
    AppMethodBeat.o(35782);
    return false;
  }
  
  public final boolean bW(bu parambu)
  {
    AppMethodBeat.i(35783);
    if (parambu.fph())
    {
      ba.aBQ();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(this.cWM.JOR.getContext(), this.cWM.JOR.getContentView());
        AppMethodBeat.o(35783);
        return true;
      }
      if (parambu.field_msgId == this.JOq.Jyn) {
        this.JOq.aoV();
      }
      if (!this.cWM.getTalkerUserName().equals("medianote"))
      {
        ba.aBQ();
        com.tencent.mm.model.c.azo().c(new com.tencent.mm.bb.f(parambu.field_talker, parambu.field_msgSvrId));
      }
      aj.bs(parambu);
      AppMethodBeat.o(35783);
      return true;
    }
    AppMethodBeat.o(35783);
    return false;
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(35785);
    super.fCC();
    ad.i("MicroMsg.ChattingUI.VoiceComponent", "doDestroy, autoPlay:%s", new Object[] { this.JOq });
    com.tencent.mm.modelvoice.t.b(this.JOq);
    e.b(this.JOq);
    ba.aiU().b(127, this);
    releaseWakeLock();
    if (this.JOq != null)
    {
      this.JOq.fAF();
      com.tencent.mm.ui.chatting.d locald = this.JOq;
      locald.release();
      locald.pyq.unInit();
      locald.context = null;
      locald.Jyt = false;
      com.tencent.mm.sdk.b.a.IbL.d(locald.Jyy);
      ba.Nb().b(locald);
      this.JOq = null;
    }
    AppMethodBeat.o(35785);
  }
  
  public final com.tencent.mm.ui.chatting.d fFk()
  {
    return this.JOq;
  }
  
  public final void fFl()
  {
    AppMethodBeat.i(35778);
    com.tencent.mm.ui.chatting.d.b.y localy = (com.tencent.mm.ui.chatting.d.b.y)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.y.class);
    Object localObject = (l)this.cWM.bh(l.class);
    af localaf = (af)this.cWM.bh(af.class);
    if ((((l)localObject).fDs()) || (localaf.fEz()))
    {
      ad.d("MicroMsg.ChattingUI.VoiceComponent", "trigger title icon, in show mode");
      this.cWM.ya(false);
      localy.setTitlePhoneIconVisibility(8);
      localy.setTitleMuteIconVisibility(8);
      AppMethodBeat.o(35778);
      return;
    }
    if (((com.tencent.mm.plugin.forcenotify.a.b)g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).ajz(this.cWM.getTalkerUserName()))
    {
      localy.setTitleForceNotifyIconVisibility(0);
      localy.setTitleMuteIconVisibility(8);
      label146:
      ba.aBQ();
      localObject = (Boolean)com.tencent.mm.model.c.ajl().get(26, null);
      if (localObject != null) {
        break label242;
      }
      this.pys = false;
      label172:
      ad.m("MicroMsg.ChattingUI.VoiceComponent", "triggerTitleIcon and setForceSpeakOff value is %s", new Object[] { Boolean.valueOf(this.pys) });
      if (!this.pys) {
        break label253;
      }
    }
    label242:
    label253:
    for (int i = 0;; i = 8)
    {
      localy.setTitlePhoneIconVisibility(i);
      AppMethodBeat.o(35778);
      return;
      localy.setTitleForceNotifyIconVisibility(8);
      if (!Pf()) {
        break;
      }
      localy.setTitleMuteIconVisibility(0);
      break label146;
      this.pys = ((Boolean)localObject).booleanValue();
      break label172;
    }
  }
  
  public final boolean fFm()
  {
    return this.pys;
  }
  
  public final void fFn()
  {
    this.JOs = 0L;
  }
  
  public final void fwt()
  {
    AppMethodBeat.i(35787);
    fFl();
    AppMethodBeat.o(35787);
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(35788);
    ba.aiU().a(127, this);
    this.JOv.alive();
    AppMethodBeat.o(35788);
  }
  
  public final void fwv()
  {
    AppMethodBeat.i(35789);
    ad.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay looper[%s]", new Object[] { Looper.myLooper() });
    this.JOr = true;
    long l = System.currentTimeMillis();
    ad.i("MicroMsg.ChattingUI.VoiceComponent", "resetAutoPlay autoPlay is:%s tid:%d looper:%s", new Object[] { this.JOq, Long.valueOf(Thread.currentThread().getId()), Looper.myLooper() });
    Object localObject;
    if (this.JOq == null)
    {
      this.JOq = new com.tencent.mm.ui.chatting.d(this.cWM, this, this.cWM.getTalkerUserName());
      com.tencent.mm.modelvoice.t.c(this.JOq);
      e.a(this.JOq);
      ba.aBQ();
      bool = bt.a((Boolean)com.tencent.mm.model.c.ajl().get(16387, null), true);
      localObject = this.JOq;
      if (!((com.tencent.mm.ui.chatting.d)localObject).Jyt)
      {
        ((com.tencent.mm.ui.chatting.d)localObject).Jyr = bool;
        ((com.tencent.mm.ui.chatting.d)localObject).fAF();
      }
      localObject = ((com.tencent.mm.ui.chatting.d.b.d)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCE();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.api.c)localObject).bX(false);
        if (localObject != null)
        {
          if (((c.b)localObject).cQv != null)
          {
            if (((c.b)localObject).cQv.optInt("AudioPlayType", 0) != 1) {
              break label385;
            }
            bool = true;
            label224:
            ((c.b)localObject).cQL = bool;
          }
          if (((c.b)localObject).cQL) {
            this.JOq.Jys = false;
          }
        }
      }
      localObject = this.JOq;
      if (this.pys) {
        break label390;
      }
    }
    label385:
    label390:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.ui.chatting.d)localObject).xP(bool);
      this.JOq.xO(true);
      ad.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay end take[%s]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      if ((w.Ab(this.cWM.getTalkerUserName())) && (as.a.hFR != null)) {
        as.a.hFR.a(this.Bln);
      }
      if (!com.tencent.mm.ax.b.aJj()) {
        ((com.tencent.mm.ui.chatting.d.b.s)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.s.class)).setVoiceInputShowCallback(this.JOx);
      }
      fFl();
      AppMethodBeat.o(35789);
      return;
      this.JOq.aVP(this.cWM.getTalkerUserName());
      break;
      bool = false;
      break label224;
    }
  }
  
  public final void fww()
  {
    AppMethodBeat.i(35790);
    this.JOr = false;
    if ((w.Ab(this.cWM.getTalkerUserName())) && (as.a.hFR != null)) {
      as.a.hFR.b(this.Bln);
    }
    if ((this.JOw != null) && (this.JOw.getVisibility() == 0))
    {
      ad.i("MicroMsg.ChattingUI.VoiceComponent", "doPause set voiceinputMask GONE");
      this.JOw.setVisibility(8);
    }
    ((com.tencent.mm.ui.chatting.d.b.s)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.s.class)).setVoiceInputShowCallback(null);
    ba.aBQ();
    com.tencent.mm.model.c.ajl().set(26, Boolean.valueOf(this.pys));
    if ((!com.tencent.mm.ui.s.fwR()) && (this.JOq != null))
    {
      this.JOq.fAF();
      this.JOq.aoV();
      this.JOq.release();
    }
    AppMethodBeat.o(35790);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(35791);
    ba.aiU().b(127, this);
    this.JOv.dead();
    this.JOu.clear();
    AppMethodBeat.o(35791);
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
    ad.i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramn.getType());
    this.cWM.dismissDialog();
    if (!this.cWM.cBJ)
    {
      ad.i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35792);
      return;
    }
    if (!bt.jh(this.cWM.JOR.getContext()))
    {
      AppMethodBeat.o(35792);
      return;
    }
    Activity localActivity = this.cWM.JOR.getContext();
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
      paramString = com.tencent.mm.modelvoice.s.Ia(((com.tencent.mm.modelvoice.f)paramn).fileName);
      if ((paramString != null) && (paramString.status == 99)) {
        bd.aI(this.cWM.JOR.getContext(), 2131755246);
      }
    }
  }
  
  public final void releaseWakeLock()
  {
    AppMethodBeat.i(35780);
    this.cWM.setKeepScreenOn(false);
    AppMethodBeat.o(35780);
  }
  
  public final void xZ(boolean paramBoolean)
  {
    AppMethodBeat.i(35781);
    if (this.JOq == null)
    {
      ad.e("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff error, autoPlay is null!!!");
      AppMethodBeat.o(35781);
      return;
    }
    ad.m("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff value is %s", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.ui.chatting.d.b.y localy = (com.tencent.mm.ui.chatting.d.b.y)this.cWM.bh(com.tencent.mm.ui.chatting.d.b.y.class);
    if (paramBoolean)
    {
      this.JOq.xP(false);
      this.pys = true;
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(26, Boolean.TRUE);
      localy.setTitlePhoneIconVisibility(0);
      Toast.makeText(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131759557), 0).show();
      this.JOq.fAJ();
      this.cWM.ads(2131689483);
      AppMethodBeat.o(35781);
      return;
    }
    if (!com.tencent.mm.plugin.audio.c.a.bGD()) {
      this.JOq.xP(true);
    }
    for (;;)
    {
      this.pys = false;
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(26, Boolean.FALSE);
      localy.setTitlePhoneIconVisibility(8);
      Toast.makeText(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131759558), 0).show();
      this.JOq.fAJ();
      this.cWM.ads(2131689503);
      AppMethodBeat.o(35781);
      return;
      ad.i("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff true but isBluetoothOn");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.be
 * JD-Core Version:    0.7.0.1
 */