package com.tencent.mm.ui.chatting.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.m;
import com.tencent.mm.ai.a.j;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.at.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.d;
import com.tencent.mm.model.am.f;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.chatting.am;
import com.tencent.mm.ui.chatting.b.b.ai;
import com.tencent.mm.ui.chatting.b.b.n;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.w.a;
import com.tencent.mm.ui.x;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.b.a.a(cFA=ai.class)
public class aq
  extends a
  implements com.tencent.mm.ah.f, ai
{
  public boolean ian = false;
  private am.d pyi = new aq.1(this);
  private com.tencent.mm.ui.chatting.d vtp = null;
  private View vtq = null;
  public ChatFooter.d vtr = new aq.2(this);
  
  public final boolean Bj()
  {
    boolean bool1 = ((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDG();
    boolean bool2 = ((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDH();
    int i;
    if ((this.byx.cFD()) || (bool2)) {
      i = 1;
    }
    while (bool1) {
      if (bool2)
      {
        return ((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDE().il(1);
        i = 0;
      }
      else
      {
        return ((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDF().il(1);
      }
    }
    return ((i != 0) && (this.byx.pSb.cCy == 0)) || (this.byx.pSb.Bj());
  }
  
  @TargetApi(9)
  public final void a(x paramx, boolean paramBoolean)
  {
    if (paramx.getLandscapeMode())
    {
      if (!paramBoolean) {
        break label171;
      }
      if (Build.VERSION.SDK_INT < 9) {
        break label119;
      }
      y.i("MicroMsg.ChattingUI.VoiceComponent", "rotation %d", new Object[] { Integer.valueOf(paramx.getWindowManager().getDefaultDisplay().getOrientation()) });
      switch (paramx.getWindowManager().getDefaultDisplay().getOrientation())
      {
      }
    }
    label119:
    do
    {
      return;
      paramx.setRequestedOrientation(1);
      return;
      paramx.setRequestedOrientation(0);
      return;
      paramx.setRequestedOrientation(9);
      return;
      paramx.setRequestedOrientation(8);
      return;
      if (this.byx.vtz.getMMResources().getConfiguration().orientation == 2)
      {
        paramx.setRequestedOrientation(0);
        return;
      }
    } while (this.byx.vtz.getMMResources().getConfiguration().orientation != 1);
    paramx.setRequestedOrientation(1);
    return;
    label171:
    paramx.setRequestedOrientation(-1);
  }
  
  public final void acquireWakeLock()
  {
    this.byx.setKeepScreenOn(true);
  }
  
  public final boolean bc(bi parambi)
  {
    if (parambi.ctA())
    {
      if (parambi.field_msgId == this.vtp.vhz) {
        this.vtp.cCb();
      }
      return true;
    }
    return false;
  }
  
  public final boolean bd(bi parambi)
  {
    if (parambi.ctA())
    {
      com.tencent.mm.model.au.Hx();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.s.gM(this.byx.vtz.getContext());
        return true;
      }
      if (parambi.field_msgId == this.vtp.vhz) {
        this.vtp.cCb();
      }
      if (!this.byx.getTalkerUserName().equals("medianote"))
      {
        com.tencent.mm.model.au.Hx();
        com.tencent.mm.model.c.Fv().b(new com.tencent.mm.ay.d(parambi.field_talker, parambi.field_msgSvrId));
      }
      am.aH(parambi);
      return true;
    }
    return false;
  }
  
  public final void cDC()
  {
    super.cDC();
    r.b(this.vtp);
    com.tencent.mm.modelvoice.e.b(this.vtp);
    releaseWakeLock();
    if (this.vtp != null)
    {
      this.vtp.cBW();
      com.tencent.mm.ui.chatting.d locald = this.vtp;
      locald.release();
      locald.context = null;
      locald.vhF = false;
      com.tencent.mm.sdk.b.a.udP.d(locald.vhK);
      com.tencent.mm.model.au.tu().b(locald);
    }
  }
  
  public final com.tencent.mm.ui.chatting.d cFx()
  {
    return this.vtp;
  }
  
  public final void cFy()
  {
    com.tencent.mm.ui.chatting.b.b.q localq = (com.tencent.mm.ui.chatting.b.b.q)this.byx.ac(com.tencent.mm.ui.chatting.b.b.q.class);
    if (((com.tencent.mm.ui.chatting.b.b.h)this.byx.ac(com.tencent.mm.ui.chatting.b.b.h.class)).cEh())
    {
      y.d("MicroMsg.ChattingUI.VoiceComponent", "trigger title icon, in show mode");
      this.byx.np(false);
      localq.setTitlePhoneIconVisibility(8);
      localq.setTitleMuteIconVisibility(8);
      return;
    }
    Boolean localBoolean;
    if (Bj())
    {
      localq.setTitleMuteIconVisibility(0);
      com.tencent.mm.model.au.Hx();
      localBoolean = (Boolean)com.tencent.mm.model.c.Dz().get(26, null);
      if (localBoolean != null) {
        break label136;
      }
      this.ian = false;
      label108:
      if (!this.ian) {
        break label147;
      }
    }
    label136:
    label147:
    for (int i = 0;; i = 8)
    {
      localq.setTitlePhoneIconVisibility(i);
      return;
      localq.setTitleMuteIconVisibility(8);
      break;
      this.ian = localBoolean.booleanValue();
      break label108;
    }
  }
  
  public final boolean cFz()
  {
    return this.ian;
  }
  
  public final void cyN()
  {
    cFy();
  }
  
  public final void cyO()
  {
    com.tencent.mm.model.au.Dk().a(127, this);
  }
  
  public final void cyP()
  {
    y.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay looper[%s]", new Object[] { Looper.myLooper() });
    long l = System.currentTimeMillis();
    y.i("MicroMsg.ChattingUI.VoiceComponent", "resetAutoPlay autoPlay is:%s tid:%d looper:%s", new Object[] { this.vtp, Long.valueOf(Thread.currentThread().getId()), Looper.myLooper() });
    Object localObject;
    if (this.vtp == null)
    {
      this.vtp = new com.tencent.mm.ui.chatting.d(this.byx, this, this.byx.getTalkerUserName());
      r.c(this.vtp);
      com.tencent.mm.modelvoice.e.a(this.vtp);
      com.tencent.mm.model.au.Hx();
      bool = bk.a((Boolean)com.tencent.mm.model.c.Dz().get(16387, null), true);
      localObject = this.vtp;
      if (!((com.tencent.mm.ui.chatting.d)localObject).vhF)
      {
        ((com.tencent.mm.ui.chatting.d)localObject).vhD = bool;
        ((com.tencent.mm.ui.chatting.d)localObject).cBW();
      }
      localObject = ((com.tencent.mm.ui.chatting.b.b.c)this.byx.ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDD();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.ai.d)localObject).bS(false);
        if (localObject != null)
        {
          if (((d.b)localObject).efa != null)
          {
            if (((d.b)localObject).efa.optInt("AudioPlayType", 0) != 1) {
              break label368;
            }
            bool = true;
            label213:
            ((d.b)localObject).efp = bool;
          }
          if (((d.b)localObject).efp) {
            this.vtp.vhE = false;
          }
        }
      }
      localObject = this.vtp;
      if (this.ian) {
        break label373;
      }
    }
    label368:
    label373:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.ui.chatting.d)localObject).iak = bool;
      this.vtp.ni(true);
      y.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay end take[%s]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      if ((com.tencent.mm.model.s.hI(this.byx.getTalkerUserName())) && (am.a.dVB != null)) {
        am.a.dVB.a(this.pyi);
      }
      if (!b.Pb()) {
        ((n)this.byx.ac(n.class)).setVoiceInputShowCallback(this.vtr);
      }
      cFy();
      return;
      this.vtp.adm(this.byx.getTalkerUserName());
      break;
      bool = false;
      break label213;
    }
  }
  
  public final void cyQ()
  {
    if ((com.tencent.mm.model.s.hI(this.byx.getTalkerUserName())) && (am.a.dVB != null)) {
      am.a.dVB.b(this.pyi);
    }
    if ((this.vtq != null) && (this.vtq.getVisibility() == 0))
    {
      y.i("MicroMsg.ChattingUI.VoiceComponent", "doPause set voiceinputMask GONE");
      this.vtq.setVisibility(8);
    }
    ((n)this.byx.ac(n.class)).setVoiceInputShowCallback(null);
    com.tencent.mm.model.au.Hx();
    com.tencent.mm.model.c.Dz().o(26, Boolean.valueOf(this.ian));
    if ((!com.tencent.mm.ui.s.czw()) && (this.vtp != null))
    {
      this.vtp.cBW();
      this.vtp.cCb();
      this.vtp.release();
    }
    if ((!com.tencent.mm.plugin.voip.e.bPA()) && (!com.tencent.mm.r.a.Bv())) {
      com.tencent.mm.model.au.Hy().yl();
    }
  }
  
  public final void cyR()
  {
    com.tencent.mm.model.au.Dk().b(127, this);
  }
  
  public final void no(boolean paramBoolean)
  {
    if (this.vtp == null)
    {
      y.e("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff error, autoPlay is null!!!");
      return;
    }
    com.tencent.mm.ui.chatting.b.b.q localq = (com.tencent.mm.ui.chatting.b.b.q)this.byx.ac(com.tencent.mm.ui.chatting.b.b.q.class);
    if (paramBoolean)
    {
      this.vtp.iak = false;
      this.ian = true;
      com.tencent.mm.model.au.Hx();
      com.tencent.mm.model.c.Dz().o(26, Boolean.valueOf(true));
      localq.setTitlePhoneIconVisibility(0);
      Toast.makeText(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.fmt_route_phone), 0).show();
      this.vtp.cCa();
      this.byx.Hg(R.k.actionbar_ear_icon);
      return;
    }
    if (!com.tencent.mm.model.au.Hy().yn()) {
      this.vtp.iak = true;
    }
    for (;;)
    {
      this.ian = false;
      com.tencent.mm.model.au.Hx();
      com.tencent.mm.model.c.Dz().o(26, Boolean.valueOf(false));
      localq.setTitlePhoneIconVisibility(8);
      Toast.makeText(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.fmt_route_speaker), 0).show();
      this.vtp.cCa();
      this.byx.Hg(R.k.actionbar_loud_icon);
      return;
      y.i("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff true but isBluetoothOn");
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    int j = 0;
    int i = 0;
    boolean bool1;
    if ((paramInt == 25) && (this.vtp != null) && (this.vtp.isPlaying()) && ((this.ian) || (!this.vtp.iak)))
    {
      if (paramKeyEvent.getAction() == 0)
      {
        paramInt = i;
        if (com.tencent.mm.model.au.Hy().yn())
        {
          paramInt = i;
          if (!com.tencent.mm.model.au.Hy().yt()) {
            paramInt = com.tencent.mm.model.au.Hy().yz();
          }
        }
        com.tencent.mm.model.au.Hy().gr(paramInt);
      }
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (paramInt != 24);
          bool1 = bool2;
        } while (this.vtp == null);
        bool1 = bool2;
      } while (!this.vtp.isPlaying());
      if (this.ian) {
        break;
      }
      bool1 = bool2;
    } while (this.vtp.iak);
    if (paramKeyEvent.getAction() == 0)
    {
      paramInt = j;
      if (com.tencent.mm.model.au.Hy().yn())
      {
        paramInt = j;
        if (!com.tencent.mm.model.au.Hy().yt()) {
          paramInt = com.tencent.mm.model.au.Hy().yz();
        }
      }
      com.tencent.mm.model.au.Hy().gq(paramInt);
    }
    return true;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 1;
    y.i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramm.getType());
    this.byx.dismissDialog();
    if (!this.byx.euf) {
      y.i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd fragment not foreground, return");
    }
    label257:
    for (;;)
    {
      return;
      if (bk.bU(this.byx.vtz.getContext()))
      {
        Activity localActivity = this.byx.vtz.getContext();
        if (w.a.a(localActivity, paramInt1, paramInt2, paramString, 7)) {}
        for (;;)
        {
          if ((i != 0) || (paramInt1 != 0) || (paramInt2 != 0)) {
            break label257;
          }
          switch (paramm.getType())
          {
          default: 
            return;
          }
          paramString = com.tencent.mm.modelvoice.q.oG(((com.tencent.mm.modelvoice.f)paramm).fileName);
          if ((paramString == null) || (paramString.status != 99)) {
            break;
          }
          com.tencent.mm.sdk.platformtools.au.G(this.byx.vtz.getContext(), R.l.after_upload_voice);
          return;
          if (!w.a(localActivity, paramInt1, paramInt2, new Intent().setClass(localActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
            i = 0;
          }
        }
      }
    }
  }
  
  public final void releaseWakeLock()
  {
    this.byx.setKeepScreenOn(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.aq
 * JD-Core Version:    0.7.0.1
 */