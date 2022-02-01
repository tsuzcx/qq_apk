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
import com.tencent.mm.ak.n;
import com.tencent.mm.al.a.k;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.d;
import com.tencent.mm.model.ar.f;
import com.tencent.mm.model.az;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.aj;
import com.tencent.mm.ui.chatting.c.b.ao;
import com.tencent.mm.ui.chatting.c.b.j;
import com.tencent.mm.ui.y;
import com.tencent.mm.ui.y.a;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.c.a.a(foJ=ao.class)
public class ba
  extends a
  implements com.tencent.mm.ak.g, ao
{
  private com.tencent.mm.ui.chatting.d HZl;
  private View HZm;
  public ChatFooter.d HZn;
  public boolean oUI;
  private ar.d zTI;
  
  public ba()
  {
    AppMethodBeat.i(35775);
    this.HZl = null;
    this.oUI = false;
    this.zTI = new ar.d()
    {
      public final void y(String paramAnonymousString, final long paramAnonymousLong)
      {
        AppMethodBeat.i(35773);
        ac.d("MicroMsg.ChattingUI.VoiceComponent", "onVoiceRemind " + paramAnonymousString + " time " + paramAnonymousLong);
        if (com.tencent.mm.model.w.xe(az.getNotification().UO())) {
          com.tencent.mm.ui.base.h.a(ba.this.cLy.HZF.getContext(), false, paramAnonymousString, ba.this.cLy.HZF.getMMResources().getString(2131764760), ba.this.cLy.HZF.getMMResources().getString(2131764757), ba.this.cLy.HZF.getMMResources().getString(2131764759), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(35772);
              az.ayM();
              if (com.tencent.mm.model.c.awD().aM(az.getNotification().UO(), paramAnonymousLong))
              {
                int i = ((com.tencent.mm.ui.chatting.c.b.i)ba.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class)).eZx();
                paramAnonymous2Int = ((com.tencent.mm.ui.chatting.c.b.i)ba.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class)).getCount();
                az.ayM();
                i = com.tencent.mm.model.c.awD().f(az.getNotification().UO(), paramAnonymousLong, i - paramAnonymous2Int);
                if (i < 0)
                {
                  AppMethodBeat.o(35772);
                  return;
                }
                if (paramAnonymous2Int > i) {
                  ba.this.cLy.aaK(i);
                }
              }
              AppMethodBeat.o(35772);
            }
          }, null);
        }
        AppMethodBeat.o(35773);
      }
    };
    this.HZm = null;
    this.HZn = new ChatFooter.d()
    {
      public final void j(Boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(35774);
        if (paramAnonymousBoolean.booleanValue())
        {
          if (ba.a(ba.this) == null) {
            ba.a(ba.this, ((ViewStub)ba.this.cLy.findViewById(2131306457)).inflate());
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
  
  public final boolean Nw()
  {
    AppMethodBeat.i(35777);
    boolean bool1 = ((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmo();
    boolean bool2 = ((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmp();
    int i;
    if ((this.cLy.foP()) || (bool2)) {
      i = 1;
    }
    while (bool1) {
      if (bool2)
      {
        bool1 = ((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmm().hc(1);
        AppMethodBeat.o(35777);
        return bool1;
        i = 0;
      }
      else
      {
        bool1 = ((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmn().hc(1);
        AppMethodBeat.o(35777);
        return bool1;
      }
    }
    if (((i != 0) && (this.cLy.AzG.exT == 0)) || (this.cLy.AzG.Nw()))
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
          ac.i("MicroMsg.ChattingUI.VoiceComponent", "rotation %d", new Object[] { Integer.valueOf(paramMMFragment.getWindowManager().getDefaultDisplay().getOrientation()) });
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
        if (this.cLy.HZF.getMMResources().getConfiguration().orientation == 2)
        {
          paramMMFragment.setRequestedOrientation(0);
          AppMethodBeat.o(35784);
          return;
        }
        if (this.cLy.HZF.getMMResources().getConfiguration().orientation == 1)
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
    this.cLy.setKeepScreenOn(true);
    AppMethodBeat.o(35779);
  }
  
  public final boolean bP(bo parambo)
  {
    AppMethodBeat.i(35782);
    if (parambo.eZl())
    {
      if (parambo.field_msgId == this.HZl.HKw) {
        this.HZl.ami();
      }
      AppMethodBeat.o(35782);
      return true;
    }
    AppMethodBeat.o(35782);
    return false;
  }
  
  public final boolean bQ(bo parambo)
  {
    AppMethodBeat.i(35783);
    if (parambo.eZl())
    {
      az.ayM();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.g(this.cLy.HZF.getContext(), this.cLy.HZF.getContentView());
        AppMethodBeat.o(35783);
        return true;
      }
      if (parambo.field_msgId == this.HZl.HKw) {
        this.HZl.ami();
      }
      if (!this.cLy.getTalkerUserName().equals("medianote"))
      {
        az.ayM();
        com.tencent.mm.model.c.awA().c(new com.tencent.mm.ba.f(parambo.field_talker, parambo.field_msgSvrId));
      }
      aj.bo(parambo);
      AppMethodBeat.o(35783);
      return true;
    }
    AppMethodBeat.o(35783);
    return false;
  }
  
  public final void fgh()
  {
    AppMethodBeat.i(35787);
    foH();
    AppMethodBeat.o(35787);
  }
  
  public final void fgi()
  {
    AppMethodBeat.i(35788);
    az.agi().a(127, this);
    AppMethodBeat.o(35788);
  }
  
  public final void fgj()
  {
    AppMethodBeat.i(35789);
    ac.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay looper[%s]", new Object[] { Looper.myLooper() });
    long l = System.currentTimeMillis();
    ac.i("MicroMsg.ChattingUI.VoiceComponent", "resetAutoPlay autoPlay is:%s tid:%d looper:%s", new Object[] { this.HZl, Long.valueOf(Thread.currentThread().getId()), Looper.myLooper() });
    Object localObject;
    if (this.HZl == null)
    {
      this.HZl = new com.tencent.mm.ui.chatting.d(this.cLy, this, this.cLy.getTalkerUserName());
      com.tencent.mm.modelvoice.t.c(this.HZl);
      e.a(this.HZl);
      az.ayM();
      bool = bs.a((Boolean)com.tencent.mm.model.c.agA().get(16387, null), true);
      localObject = this.HZl;
      if (!((com.tencent.mm.ui.chatting.d)localObject).HKC)
      {
        ((com.tencent.mm.ui.chatting.d)localObject).HKA = bool;
        ((com.tencent.mm.ui.chatting.d)localObject).fkq();
      }
      localObject = ((com.tencent.mm.ui.chatting.c.b.d)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.d.class)).fml();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.api.c)localObject).bV(false);
        if (localObject != null)
        {
          if (((c.b)localObject).cFq != null)
          {
            if (((c.b)localObject).cFq.optInt("AudioPlayType", 0) != 1) {
              break label380;
            }
            bool = true;
            label219:
            ((c.b)localObject).cFG = bool;
          }
          if (((c.b)localObject).cFG) {
            this.HZl.HKB = false;
          }
        }
      }
      localObject = this.HZl;
      if (this.oUI) {
        break label385;
      }
    }
    label385:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.ui.chatting.d)localObject).xe(bool);
      this.HZl.xd(true);
      ac.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay end take[%s]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      if ((com.tencent.mm.model.w.xe(this.cLy.getTalkerUserName())) && (ar.a.hnz != null)) {
        ar.a.hnz.a(this.zTI);
      }
      if (!com.tencent.mm.aw.b.aGa()) {
        ((com.tencent.mm.ui.chatting.c.b.q)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.q.class)).setVoiceInputShowCallback(this.HZn);
      }
      foH();
      AppMethodBeat.o(35789);
      return;
      this.HZl.aPZ(this.cLy.getTalkerUserName());
      break;
      label380:
      bool = false;
      break label219;
    }
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(35790);
    if ((com.tencent.mm.model.w.xe(this.cLy.getTalkerUserName())) && (ar.a.hnz != null)) {
      ar.a.hnz.b(this.zTI);
    }
    if ((this.HZm != null) && (this.HZm.getVisibility() == 0))
    {
      ac.i("MicroMsg.ChattingUI.VoiceComponent", "doPause set voiceinputMask GONE");
      this.HZm.setVisibility(8);
    }
    ((com.tencent.mm.ui.chatting.c.b.q)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.q.class)).setVoiceInputShowCallback(null);
    az.ayM();
    com.tencent.mm.model.c.agA().set(26, Boolean.valueOf(this.oUI));
    if ((!com.tencent.mm.ui.s.fgF()) && (this.HZl != null))
    {
      this.HZl.fkq();
      this.HZl.ami();
      this.HZl.release();
    }
    AppMethodBeat.o(35790);
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(35791);
    az.agi().b(127, this);
    AppMethodBeat.o(35791);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(35785);
    super.fmj();
    ac.i("MicroMsg.ChattingUI.VoiceComponent", "doDestroy, autoPlay:%s", new Object[] { this.HZl });
    com.tencent.mm.modelvoice.t.b(this.HZl);
    e.b(this.HZl);
    az.agi().b(127, this);
    releaseWakeLock();
    if (this.HZl != null)
    {
      this.HZl.fkq();
      com.tencent.mm.ui.chatting.d locald = this.HZl;
      locald.release();
      locald.oUG.unInit();
      locald.context = null;
      locald.HKC = false;
      com.tencent.mm.sdk.b.a.GpY.d(locald.HKH);
      az.Lt().b(locald);
      this.HZl = null;
    }
    AppMethodBeat.o(35785);
  }
  
  public final com.tencent.mm.ui.chatting.d foG()
  {
    return this.HZl;
  }
  
  public final void foH()
  {
    AppMethodBeat.i(35778);
    com.tencent.mm.ui.chatting.c.b.w localw = (com.tencent.mm.ui.chatting.c.b.w)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.w.class);
    if (((j)this.cLy.bf(j.class)).fmU())
    {
      ac.d("MicroMsg.ChattingUI.VoiceComponent", "trigger title icon, in show mode");
      this.cLy.xo(false);
      localw.setTitlePhoneIconVisibility(8);
      localw.setTitleMuteIconVisibility(8);
      AppMethodBeat.o(35778);
      return;
    }
    label119:
    Boolean localBoolean;
    if (((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.forcenotify.a.b.class)).afb(this.cLy.getTalkerUserName()))
    {
      localw.setTitleForceNotifyIconVisibility(0);
      localw.setTitleMuteIconVisibility(8);
      az.ayM();
      localBoolean = (Boolean)com.tencent.mm.model.c.agA().get(26, null);
      if (localBoolean != null) {
        break label215;
      }
      this.oUI = false;
      label145:
      ac.m("MicroMsg.ChattingUI.VoiceComponent", "triggerTitleIcon and setForceSpeakOff value is %s", new Object[] { Boolean.valueOf(this.oUI) });
      if (!this.oUI) {
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
      if (!Nw()) {
        break;
      }
      localw.setTitleMuteIconVisibility(0);
      break label119;
      this.oUI = localBoolean.booleanValue();
      break label145;
    }
  }
  
  public final boolean foI()
  {
    return this.oUI;
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
    ac.i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramn.getType());
    this.cLy.dismissDialog();
    if (!this.cLy.cqM)
    {
      ac.i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(35792);
      return;
    }
    if (!bs.iX(this.cLy.HZF.getContext()))
    {
      AppMethodBeat.o(35792);
      return;
    }
    Activity localActivity = this.cLy.HZF.getContext();
    if (y.a.a(localActivity, paramInt1, paramInt2, paramString, 7)) {}
    while (i != 0)
    {
      AppMethodBeat.o(35792);
      return;
      if (!y.a(localActivity, paramInt1, paramInt2, new Intent().setClass(localActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
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
      paramString = com.tencent.mm.modelvoice.s.EL(((com.tencent.mm.modelvoice.f)paramn).fileName);
      if ((paramString != null) && (paramString.status == 99)) {
        bc.aF(this.cLy.HZF.getContext(), 2131755246);
      }
    }
  }
  
  public final void releaseWakeLock()
  {
    AppMethodBeat.i(35780);
    this.cLy.setKeepScreenOn(false);
    AppMethodBeat.o(35780);
  }
  
  public final void xn(boolean paramBoolean)
  {
    AppMethodBeat.i(35781);
    if (this.HZl == null)
    {
      ac.e("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff error, autoPlay is null!!!");
      AppMethodBeat.o(35781);
      return;
    }
    ac.m("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff value is %s", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.ui.chatting.c.b.w localw = (com.tencent.mm.ui.chatting.c.b.w)this.cLy.bf(com.tencent.mm.ui.chatting.c.b.w.class);
    if (paramBoolean)
    {
      this.HZl.xe(false);
      this.oUI = true;
      az.ayM();
      com.tencent.mm.model.c.agA().set(26, Boolean.TRUE);
      localw.setTitlePhoneIconVisibility(0);
      Toast.makeText(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131759557), 0).show();
      this.HZl.fku();
      this.cLy.abg(2131689483);
      AppMethodBeat.o(35781);
      return;
    }
    if (!com.tencent.mm.plugin.audio.c.a.bCy()) {
      this.HZl.xe(true);
    }
    for (;;)
    {
      this.oUI = false;
      az.ayM();
      com.tencent.mm.model.c.agA().set(26, Boolean.FALSE);
      localw.setTitlePhoneIconVisibility(8);
      Toast.makeText(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131759558), 0).show();
      this.HZl.fku();
      this.cLy.abg(2131689503);
      AppMethodBeat.o(35781);
      return;
      ac.i("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff true but isBluetoothOn");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ba
 * JD-Core Version:    0.7.0.1
 */