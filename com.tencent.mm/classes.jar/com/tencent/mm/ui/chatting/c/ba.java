package com.tencent.mm.ui.chatting.c;

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
import com.tencent.mm.am.a.k;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.d;
import com.tencent.mm.model.ar.f;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.aj;
import com.tencent.mm.ui.chatting.c.b.ao;
import com.tencent.mm.ui.chatting.c.b.j;
import com.tencent.mm.ui.x;
import com.tencent.mm.ui.x.a;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.c.a.a(eYT=ao.class)
public class ba
  extends a
  implements com.tencent.mm.al.g, ao
{
  private com.tencent.mm.ui.chatting.d Gzq;
  private View Gzr;
  public ChatFooter.d Gzs;
  public boolean ori;
  private ar.d yGu;
  
  public ba()
  {
    AppMethodBeat.i(35775);
    this.Gzq = null;
    this.ori = false;
    this.yGu = new ar.d()
    {
      public final void x(String paramAnonymousString, final long paramAnonymousLong)
      {
        AppMethodBeat.i(35773);
        ad.d("MicroMsg.ChattingUI.VoiceComponent", "onVoiceRemind " + paramAnonymousString + " time " + paramAnonymousLong);
        if (com.tencent.mm.model.w.tb(az.getNotification().TT())) {
          com.tencent.mm.ui.base.h.a(ba.this.cOd.GzJ.getContext(), false, paramAnonymousString, ba.this.cOd.GzJ.getMMResources().getString(2131764760), ba.this.cOd.GzJ.getMMResources().getString(2131764757), ba.this.cOd.GzJ.getMMResources().getString(2131764759), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(35772);
              az.arV();
              if (com.tencent.mm.model.c.apO().aK(az.getNotification().TT(), paramAnonymousLong))
              {
                int i = ((com.tencent.mm.ui.chatting.c.b.i)ba.this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class)).eKa();
                paramAnonymous2Int = ((com.tencent.mm.ui.chatting.c.b.i)ba.this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class)).getCount();
                az.arV();
                i = com.tencent.mm.model.c.apO().f(az.getNotification().TT(), paramAnonymousLong, i - paramAnonymous2Int);
                if (i < 0)
                {
                  AppMethodBeat.o(35772);
                  return;
                }
                if (paramAnonymous2Int > i) {
                  ba.this.cOd.Yz(i);
                }
              }
              AppMethodBeat.o(35772);
            }
          }, null);
        }
        AppMethodBeat.o(35773);
      }
    };
    this.Gzr = null;
    this.Gzs = new ChatFooter.d()
    {
      public final void j(Boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(35774);
        if (paramAnonymousBoolean.booleanValue())
        {
          if (ba.a(ba.this) == null) {
            ba.a(ba.this, ((ViewStub)ba.this.cOd.findViewById(2131306457)).inflate());
          }
          ba.a(ba.this).setVisibility(0);
          AppMethodBeat.o(35774);
          return;
        }
        if ((ba.a(ba.this) != null) && (ba.a(ba.this).getVisibility() == 0)) {
          ba.a(ba.this).setVisibility(8);
        }
        AppMethodBeat.o(35774);
      }
    };
    AppMethodBeat.o(35775);
  }
  
  public final boolean Ny()
  {
    AppMethodBeat.i(35777);
    boolean bool1 = ((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWC();
    boolean bool2 = ((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWD();
    int i;
    if ((this.cOd.eZa()) || (bool2)) {
      i = 1;
    }
    while (bool1) {
      if (bool2)
      {
        bool1 = ((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWA().ht(1);
        AppMethodBeat.o(35777);
        return bool1;
        i = 0;
      }
      else
      {
        bool1 = ((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWB().ht(1);
        AppMethodBeat.o(35777);
        return bool1;
      }
    }
    if (((i != 0) && (this.cOd.zgX.evx == 0)) || (this.cOd.zgX.Ny()))
    {
      AppMethodBeat.o(35777);
      return true;
    }
    AppMethodBeat.o(35777);
    return false;
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
        if (this.cOd.GzJ.getMMResources().getConfiguration().orientation == 2)
        {
          paramMMFragment.setRequestedOrientation(0);
          AppMethodBeat.o(35784);
          return;
        }
        if (this.cOd.GzJ.getMMResources().getConfiguration().orientation == 1)
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
    this.cOd.setKeepScreenOn(true);
    AppMethodBeat.o(35779);
  }
  
  public final boolean bM(bl parambl)
  {
    AppMethodBeat.i(35782);
    if (parambl.eJN())
    {
      if (parambl.field_msgId == this.Gzq.GkH) {
        this.Gzq.eUI();
      }
      AppMethodBeat.o(35782);
      return true;
    }
    AppMethodBeat.o(35782);
    return false;
  }
  
  public final boolean bN(bl parambl)
  {
    AppMethodBeat.i(35783);
    if (parambl.eJN())
    {
      az.arV();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(this.cOd.GzJ.getContext(), this.cOd.GzJ.getContentView());
        AppMethodBeat.o(35783);
        return true;
      }
      if (parambl.field_msgId == this.Gzq.GkH) {
        this.Gzq.eUI();
      }
      if (!this.cOd.getTalkerUserName().equals("medianote"))
      {
        az.arV();
        com.tencent.mm.model.c.apL().c(new com.tencent.mm.bb.e(parambl.field_talker, parambl.field_msgSvrId));
      }
      aj.bm(parambl);
      AppMethodBeat.o(35783);
      return true;
    }
    AppMethodBeat.o(35783);
    return false;
  }
  
  public final void eQB()
  {
    AppMethodBeat.i(35787);
    eYR();
    AppMethodBeat.o(35787);
  }
  
  public final void eQC()
  {
    AppMethodBeat.i(35788);
    az.aeS().a(127, this);
    AppMethodBeat.o(35788);
  }
  
  public final void eQD()
  {
    AppMethodBeat.i(35789);
    ad.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay looper[%s]", new Object[] { Looper.myLooper() });
    long l = System.currentTimeMillis();
    ad.i("MicroMsg.ChattingUI.VoiceComponent", "resetAutoPlay autoPlay is:%s tid:%d looper:%s", new Object[] { this.Gzq, Long.valueOf(Thread.currentThread().getId()), Looper.myLooper() });
    Object localObject;
    if (this.Gzq == null)
    {
      this.Gzq = new com.tencent.mm.ui.chatting.d(this.cOd, this, this.cOd.getTalkerUserName());
      com.tencent.mm.modelvoice.t.c(this.Gzq);
      com.tencent.mm.modelvoice.e.a(this.Gzq);
      az.arV();
      bool = bt.a((Boolean)com.tencent.mm.model.c.afk().get(16387, null), true);
      localObject = this.Gzq;
      if (!((com.tencent.mm.ui.chatting.d)localObject).GkN)
      {
        ((com.tencent.mm.ui.chatting.d)localObject).GkL = bool;
        ((com.tencent.mm.ui.chatting.d)localObject).eUD();
      }
      localObject = ((com.tencent.mm.ui.chatting.c.b.d)this.cOd.be(com.tencent.mm.ui.chatting.c.b.d.class)).eWz();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.api.c)localObject).bU(false);
        if (localObject != null)
        {
          if (((c.b)localObject).cIj != null)
          {
            if (((c.b)localObject).cIj.optInt("AudioPlayType", 0) != 1) {
              break label380;
            }
            bool = true;
            label219:
            ((c.b)localObject).cIz = bool;
          }
          if (((c.b)localObject).cIz) {
            this.Gzq.GkM = false;
          }
        }
      }
      localObject = this.Gzq;
      if (this.ori) {
        break label385;
      }
    }
    label385:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.ui.chatting.d)localObject).wa(bool);
      this.Gzq.vZ(true);
      ad.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay end take[%s]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      if ((com.tencent.mm.model.w.tb(this.cOd.getTalkerUserName())) && (ar.a.gMZ != null)) {
        ar.a.gMZ.a(this.yGu);
      }
      if (!com.tencent.mm.ax.b.azj()) {
        ((com.tencent.mm.ui.chatting.c.b.q)this.cOd.be(com.tencent.mm.ui.chatting.c.b.q.class)).setVoiceInputShowCallback(this.Gzs);
      }
      eYR();
      AppMethodBeat.o(35789);
      return;
      this.Gzq.aKw(this.cOd.getTalkerUserName());
      break;
      label380:
      bool = false;
      break label219;
    }
  }
  
  public final void eQE()
  {
    AppMethodBeat.i(35790);
    if ((com.tencent.mm.model.w.tb(this.cOd.getTalkerUserName())) && (ar.a.gMZ != null)) {
      ar.a.gMZ.b(this.yGu);
    }
    if ((this.Gzr != null) && (this.Gzr.getVisibility() == 0))
    {
      ad.i("MicroMsg.ChattingUI.VoiceComponent", "doPause set voiceinputMask GONE");
      this.Gzr.setVisibility(8);
    }
    ((com.tencent.mm.ui.chatting.c.b.q)this.cOd.be(com.tencent.mm.ui.chatting.c.b.q.class)).setVoiceInputShowCallback(null);
    az.arV();
    com.tencent.mm.model.c.afk().set(26, Boolean.valueOf(this.ori));
    if ((!com.tencent.mm.ui.r.eQW()) && (this.Gzq != null))
    {
      this.Gzq.eUD();
      this.Gzq.eUI();
      this.Gzq.release();
    }
    AppMethodBeat.o(35790);
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(35791);
    az.aeS().b(127, this);
    AppMethodBeat.o(35791);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(35785);
    super.eWx();
    ad.i("MicroMsg.ChattingUI.VoiceComponent", "doDestroy, autoPlay:%s", new Object[] { this.Gzq });
    com.tencent.mm.modelvoice.t.b(this.Gzq);
    com.tencent.mm.modelvoice.e.b(this.Gzq);
    az.aeS().b(127, this);
    releaseWakeLock();
    if (this.Gzq != null)
    {
      this.Gzq.eUD();
      com.tencent.mm.ui.chatting.d locald = this.Gzq;
      locald.release();
      locald.org.NX();
      locald.context = null;
      locald.GkN = false;
      com.tencent.mm.sdk.b.a.ESL.d(locald.GkS);
      az.Lv().b(locald);
      this.Gzq = null;
    }
    AppMethodBeat.o(35785);
  }
  
  public final com.tencent.mm.ui.chatting.d eYQ()
  {
    return this.Gzq;
  }
  
  public final void eYR()
  {
    AppMethodBeat.i(35778);
    com.tencent.mm.ui.chatting.c.b.w localw = (com.tencent.mm.ui.chatting.c.b.w)this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class);
    if (((j)this.cOd.be(j.class)).eXi())
    {
      ad.d("MicroMsg.ChattingUI.VoiceComponent", "trigger title icon, in show mode");
      this.cOd.wk(false);
      localw.setTitlePhoneIconVisibility(8);
      localw.setTitleMuteIconVisibility(8);
      AppMethodBeat.o(35778);
      return;
    }
    label119:
    Boolean localBoolean;
    if (((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).aaj(this.cOd.getTalkerUserName()))
    {
      localw.setTitleForceNotifyIconVisibility(0);
      localw.setTitleMuteIconVisibility(8);
      az.arV();
      localBoolean = (Boolean)com.tencent.mm.model.c.afk().get(26, null);
      if (localBoolean != null) {
        break label215;
      }
      this.ori = false;
      label145:
      ad.m("MicroMsg.ChattingUI.VoiceComponent", "triggerTitleIcon and setForceSpeakOff value is %s", new Object[] { Boolean.valueOf(this.ori) });
      if (!this.ori) {
        break label226;
      }
    }
    label215:
    label226:
    for (int i = 0;; i = 8)
    {
      localw.setTitlePhoneIconVisibility(i);
      AppMethodBeat.o(35778);
      return;
      localw.setTitleForceNotifyIconVisibility(8);
      if (!Ny()) {
        break;
      }
      localw.setTitleMuteIconVisibility(0);
      break label119;
      this.ori = localBoolean.booleanValue();
      break label145;
    }
  }
  
  public final boolean eYS()
  {
    return this.ori;
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
    this.cOd.dismissDialog();
    if (!this.cOd.ctF)
    {
      ad.i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35792);
      return;
    }
    if (!bt.iM(this.cOd.GzJ.getContext()))
    {
      AppMethodBeat.o(35792);
      return;
    }
    Activity localActivity = this.cOd.GzJ.getContext();
    if (x.a.a(localActivity, paramInt1, paramInt2, paramString, 7)) {}
    while (i != 0)
    {
      AppMethodBeat.o(35792);
      return;
      if (!x.a(localActivity, paramInt1, paramInt2, new Intent().setClass(localActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
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
      paramString = s.AG(((f)paramn).fileName);
      if ((paramString != null) && (paramString.status == 99)) {
        bd.az(this.cOd.GzJ.getContext(), 2131755246);
      }
    }
  }
  
  public final void releaseWakeLock()
  {
    AppMethodBeat.i(35780);
    this.cOd.setKeepScreenOn(false);
    AppMethodBeat.o(35780);
  }
  
  public final void wj(boolean paramBoolean)
  {
    AppMethodBeat.i(35781);
    if (this.Gzq == null)
    {
      ad.e("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff error, autoPlay is null!!!");
      AppMethodBeat.o(35781);
      return;
    }
    ad.m("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff value is %s", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.ui.chatting.c.b.w localw = (com.tencent.mm.ui.chatting.c.b.w)this.cOd.be(com.tencent.mm.ui.chatting.c.b.w.class);
    if (paramBoolean)
    {
      this.Gzq.wa(false);
      this.ori = true;
      az.arV();
      com.tencent.mm.model.c.afk().set(26, Boolean.TRUE);
      localw.setTitlePhoneIconVisibility(0);
      Toast.makeText(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131759557), 0).show();
      this.Gzq.eUH();
      this.cOd.YU(2131689483);
      AppMethodBeat.o(35781);
      return;
    }
    if (!com.tencent.mm.plugin.audio.c.a.bvC()) {
      this.Gzq.wa(true);
    }
    for (;;)
    {
      this.ori = false;
      az.arV();
      com.tencent.mm.model.c.afk().set(26, Boolean.FALSE);
      localw.setTitlePhoneIconVisibility(8);
      Toast.makeText(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131759558), 0).show();
      this.Gzq.eUH();
      this.cOd.YU(2131689503);
      AppMethodBeat.o(35781);
      return;
      ad.i("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff true but isBluetoothOn");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ba
 * JD-Core Version:    0.7.0.1
 */