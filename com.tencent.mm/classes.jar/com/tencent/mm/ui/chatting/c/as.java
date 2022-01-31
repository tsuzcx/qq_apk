package com.tencent.mm.ui.chatting.c;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.aj.a.j;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.ae;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.d;
import com.tencent.mm.model.ao.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.v.a;
import org.json.JSONObject;

@com.tencent.mm.ui.chatting.c.a.a(dJy=com.tencent.mm.ui.chatting.c.b.aj.class)
public class as
  extends a
  implements com.tencent.mm.ai.f, com.tencent.mm.ui.chatting.c.b.aj
{
  public boolean mtW;
  private ao.d sZW;
  private com.tencent.mm.ui.chatting.d zJh;
  private View zJi;
  public ChatFooter.d zJj;
  
  public as()
  {
    AppMethodBeat.i(31868);
    this.zJh = null;
    this.mtW = false;
    this.sZW = new as.1(this);
    this.zJi = null;
    this.zJj = new as.2(this);
    AppMethodBeat.o(31868);
  }
  
  private boolean d(int paramInt, KeyEvent paramKeyEvent)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(31869);
    if ((paramInt == 25) && (this.zJh != null) && (this.zJh.isPlaying()) && ((this.mtW) || (!this.zJh.mtV)))
    {
      if (paramKeyEvent.getAction() == 0)
      {
        paramInt = i;
        if (aw.aaA().KH())
        {
          paramInt = i;
          if (!aw.aaA().KN()) {
            paramInt = aw.aaA().KU();
          }
        }
        aw.aaA().iG(paramInt);
      }
      AppMethodBeat.o(31869);
      return true;
    }
    if ((paramInt == 24) && (this.zJh != null) && (this.zJh.isPlaying()) && ((this.mtW) || (!this.zJh.mtV)))
    {
      if (paramKeyEvent.getAction() == 0)
      {
        paramInt = j;
        if (aw.aaA().KH())
        {
          paramInt = j;
          if (!aw.aaA().KN()) {
            paramInt = aw.aaA().KU();
          }
        }
        aw.aaA().iF(paramInt);
      }
      AppMethodBeat.o(31869);
      return true;
    }
    AppMethodBeat.o(31869);
    return false;
  }
  
  public final boolean DP()
  {
    AppMethodBeat.i(31870);
    boolean bool1 = ((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHv();
    boolean bool2 = ((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHw();
    int i;
    if ((this.caz.dJF()) || (bool2)) {
      i = 1;
    }
    while (bool1) {
      if (bool2)
      {
        bool1 = ((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHt().kY(1);
        AppMethodBeat.o(31870);
        return bool1;
        i = 0;
      }
      else
      {
        bool1 = ((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHu().kY(1);
        AppMethodBeat.o(31870);
        return bool1;
      }
    }
    if (((i != 0) && (this.caz.txj.dqK == 0)) || (this.caz.txj.DP()))
    {
      AppMethodBeat.o(31870);
      return true;
    }
    AppMethodBeat.o(31870);
    return false;
  }
  
  @TargetApi(9)
  public final void a(MMFragment paramMMFragment, boolean paramBoolean)
  {
    AppMethodBeat.i(31877);
    if (paramMMFragment.getLandscapeMode()) {
      if (paramBoolean)
      {
        if (Build.VERSION.SDK_INT >= 9)
        {
          ab.i("MicroMsg.ChattingUI.VoiceComponent", "rotation %d", new Object[] { Integer.valueOf(paramMMFragment.getWindowManager().getDefaultDisplay().getOrientation()) });
          switch (paramMMFragment.getWindowManager().getDefaultDisplay().getOrientation())
          {
          default: 
            AppMethodBeat.o(31877);
            return;
          case 0: 
            paramMMFragment.setRequestedOrientation(1);
            AppMethodBeat.o(31877);
            return;
          case 1: 
            paramMMFragment.setRequestedOrientation(0);
            AppMethodBeat.o(31877);
            return;
          case 2: 
            paramMMFragment.setRequestedOrientation(9);
            AppMethodBeat.o(31877);
            return;
          }
          paramMMFragment.setRequestedOrientation(8);
          AppMethodBeat.o(31877);
          return;
        }
        if (this.caz.zJz.getMMResources().getConfiguration().orientation == 2)
        {
          paramMMFragment.setRequestedOrientation(0);
          AppMethodBeat.o(31877);
          return;
        }
        if (this.caz.zJz.getMMResources().getConfiguration().orientation == 1)
        {
          paramMMFragment.setRequestedOrientation(1);
          AppMethodBeat.o(31877);
        }
      }
      else
      {
        paramMMFragment.setRequestedOrientation(-1);
      }
    }
    AppMethodBeat.o(31877);
  }
  
  public final void acquireWakeLock()
  {
    AppMethodBeat.i(31872);
    this.caz.setKeepScreenOn(true);
    AppMethodBeat.o(31872);
  }
  
  public final boolean bo(bi parambi)
  {
    AppMethodBeat.i(31875);
    if (parambi.dvW())
    {
      if (parambi.field_msgId == this.zJh.zwt) {
        this.zJh.dFN();
      }
      AppMethodBeat.o(31875);
      return true;
    }
    AppMethodBeat.o(31875);
    return false;
  }
  
  public final boolean bp(bi parambi)
  {
    AppMethodBeat.i(31876);
    if (parambi.dvW())
    {
      aw.aaz();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        com.tencent.mm.ui.base.t.ii(this.caz.zJz.getContext());
        AppMethodBeat.o(31876);
        return true;
      }
      if (parambi.field_msgId == this.zJh.zwt) {
        this.zJh.dFN();
      }
      if (!this.caz.getTalkerUserName().equals("medianote"))
      {
        aw.aaz();
        com.tencent.mm.model.c.Yz().c(new com.tencent.mm.az.e(parambi.field_talker, parambi.field_msgSvrId));
      }
      com.tencent.mm.ui.chatting.aj.aR(parambi);
      AppMethodBeat.o(31876);
      return true;
    }
    AppMethodBeat.o(31876);
    return false;
  }
  
  public final void dBZ()
  {
    AppMethodBeat.i(31880);
    dJw();
    AppMethodBeat.o(31880);
  }
  
  public final void dCa()
  {
    AppMethodBeat.i(31881);
    aw.Rc().a(127, this);
    AppMethodBeat.o(31881);
  }
  
  public final void dCb()
  {
    AppMethodBeat.i(31882);
    ab.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay looper[%s]", new Object[] { Looper.myLooper() });
    long l = System.currentTimeMillis();
    ab.i("MicroMsg.ChattingUI.VoiceComponent", "resetAutoPlay autoPlay is:%s tid:%d looper:%s", new Object[] { this.zJh, Long.valueOf(Thread.currentThread().getId()), Looper.myLooper() });
    Object localObject;
    if (this.zJh == null)
    {
      this.zJh = new com.tencent.mm.ui.chatting.d(this.caz, this, this.caz.getTalkerUserName());
      com.tencent.mm.modelvoice.t.c(this.zJh);
      com.tencent.mm.modelvoice.e.a(this.zJh);
      aw.aaz();
      bool = bo.a((Boolean)com.tencent.mm.model.c.Ru().get(16387, null), true);
      localObject = this.zJh;
      if (!((com.tencent.mm.ui.chatting.d)localObject).zwz)
      {
        ((com.tencent.mm.ui.chatting.d)localObject).zwx = bool;
        ((com.tencent.mm.ui.chatting.d)localObject).dFI();
      }
      localObject = ((com.tencent.mm.ui.chatting.c.b.d)this.caz.ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHs();
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.aj.d)localObject).cU(false);
        if (localObject != null)
        {
          if (((d.b)localObject).fvc != null)
          {
            if (((d.b)localObject).fvc.optInt("AudioPlayType", 0) != 1) {
              break label380;
            }
            bool = true;
            label219:
            ((d.b)localObject).fvr = bool;
          }
          if (((d.b)localObject).fvr) {
            this.zJh.zwy = false;
          }
        }
      }
      localObject = this.zJh;
      if (this.mtW) {
        break label385;
      }
    }
    label385:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.ui.chatting.d)localObject).mtV = bool;
      this.zJh.qR(true);
      ab.i("MicroMsg.ChattingUI.VoiceComponent", "summeranrt resetAutoPlay end take[%s]ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      if ((com.tencent.mm.model.t.or(this.caz.getTalkerUserName())) && (ao.a.flL != null)) {
        ao.a.flL.a(this.sZW);
      }
      if (!com.tencent.mm.au.b.aic()) {
        ((o)this.caz.ay(o.class)).setVoiceInputShowCallback(this.zJj);
      }
      dJw();
      AppMethodBeat.o(31882);
      return;
      this.zJh.atI(this.caz.getTalkerUserName());
      break;
      label380:
      bool = false;
      break label219;
    }
  }
  
  public final void dCc()
  {
    AppMethodBeat.i(31883);
    if ((com.tencent.mm.model.t.or(this.caz.getTalkerUserName())) && (ao.a.flL != null)) {
      ao.a.flL.b(this.sZW);
    }
    if ((this.zJi != null) && (this.zJi.getVisibility() == 0))
    {
      ab.i("MicroMsg.ChattingUI.VoiceComponent", "doPause set voiceinputMask GONE");
      this.zJi.setVisibility(8);
    }
    ((o)this.caz.ay(o.class)).setVoiceInputShowCallback(null);
    aw.aaz();
    com.tencent.mm.model.c.Ru().set(26, Boolean.valueOf(this.mtW));
    if (this.zJh != null)
    {
      this.zJh.dFI();
      this.zJh.dFN();
      this.zJh.release();
    }
    AppMethodBeat.o(31883);
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31884);
    aw.Rc().b(127, this);
    AppMethodBeat.o(31884);
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(31878);
    super.dHq();
    com.tencent.mm.modelvoice.t.b(this.zJh);
    com.tencent.mm.modelvoice.e.b(this.zJh);
    aw.Rc().b(127, this);
    releaseWakeLock();
    if (this.zJh != null)
    {
      this.zJh.dFI();
      com.tencent.mm.ui.chatting.d locald = this.zJh;
      locald.release();
      locald.context = null;
      locald.zwz = false;
      com.tencent.mm.sdk.b.a.ymk.d(locald.zwE);
      aw.BY().b(locald);
    }
    AppMethodBeat.o(31878);
  }
  
  public final com.tencent.mm.ui.chatting.d dJv()
  {
    return this.zJh;
  }
  
  public final void dJw()
  {
    AppMethodBeat.i(31871);
    com.tencent.mm.ui.chatting.c.b.r localr = (com.tencent.mm.ui.chatting.c.b.r)this.caz.ay(com.tencent.mm.ui.chatting.c.b.r.class);
    if (((com.tencent.mm.ui.chatting.c.b.i)this.caz.ay(com.tencent.mm.ui.chatting.c.b.i.class)).dHW())
    {
      ab.d("MicroMsg.ChattingUI.VoiceComponent", "trigger title icon, in show mode");
      this.caz.qZ(false);
      localr.setTitlePhoneIconVisibility(8);
      localr.setTitleMuteIconVisibility(8);
      AppMethodBeat.o(31871);
      return;
    }
    label119:
    Boolean localBoolean;
    if (((com.tencent.mm.plugin.forcenotify.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.forcenotify.a.b.class)).On(this.caz.getTalkerUserName()))
    {
      localr.setTitleForceNotifyIconVisibility(0);
      localr.setTitleMuteIconVisibility(8);
      aw.aaz();
      localBoolean = (Boolean)com.tencent.mm.model.c.Ru().get(26, null);
      if (localBoolean != null) {
        break label193;
      }
      this.mtW = false;
      label145:
      if (!this.mtW) {
        break label204;
      }
    }
    label193:
    label204:
    for (int i = 0;; i = 8)
    {
      localr.setTitlePhoneIconVisibility(i);
      AppMethodBeat.o(31871);
      return;
      localr.setTitleForceNotifyIconVisibility(8);
      if (!DP()) {
        break;
      }
      localr.setTitleMuteIconVisibility(0);
      break label119;
      this.mtW = localBoolean.booleanValue();
      break label145;
    }
  }
  
  public final boolean dJx()
  {
    return this.mtW;
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(31879);
    boolean bool = d(paramInt, paramKeyEvent);
    AppMethodBeat.o(31879);
    return bool;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 1;
    AppMethodBeat.i(31885);
    ab.i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " sceneType:" + paramm.getType());
    this.caz.dismissDialog();
    if (!this.caz.bSe)
    {
      ab.i("MicroMsg.ChattingUI.VoiceComponent", "onSceneEnd fragment not foreground, return");
      AppMethodBeat.o(31885);
      return;
    }
    if (!bo.cB(this.caz.zJz.getContext()))
    {
      AppMethodBeat.o(31885);
      return;
    }
    Activity localActivity = this.caz.zJz.getContext();
    if (v.a.a(localActivity, paramInt1, paramInt2, paramString, 7)) {}
    while (i != 0)
    {
      AppMethodBeat.o(31885);
      return;
      if (!v.a(localActivity, paramInt1, paramInt2, new Intent().setClass(localActivity, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), paramString)) {
        i = 0;
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      switch (paramm.getType())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(31885);
      return;
      paramString = s.vT(((com.tencent.mm.modelvoice.f)paramm).fileName);
      if ((paramString != null) && (paramString.status == 99)) {
        ay.ax(this.caz.zJz.getContext(), 2131296514);
      }
    }
  }
  
  public final void qY(boolean paramBoolean)
  {
    AppMethodBeat.i(31874);
    if (this.zJh == null)
    {
      ab.e("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff error, autoPlay is null!!!");
      AppMethodBeat.o(31874);
      return;
    }
    com.tencent.mm.ui.chatting.c.b.r localr = (com.tencent.mm.ui.chatting.c.b.r)this.caz.ay(com.tencent.mm.ui.chatting.c.b.r.class);
    if (paramBoolean)
    {
      this.zJh.mtV = false;
      this.mtW = true;
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(26, Boolean.TRUE);
      localr.setTitlePhoneIconVisibility(0);
      Toast.makeText(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131300090), 0).show();
      this.zJh.dFM();
      this.caz.PN(2131230730);
      AppMethodBeat.o(31874);
      return;
    }
    if (!aw.aaA().KH()) {
      this.zJh.mtV = true;
    }
    for (;;)
    {
      this.mtW = false;
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(26, Boolean.FALSE);
      localr.setTitlePhoneIconVisibility(8);
      Toast.makeText(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131300091), 0).show();
      this.zJh.dFM();
      this.caz.PN(2131230750);
      AppMethodBeat.o(31874);
      return;
      ab.i("MicroMsg.ChattingUI.VoiceComponent", "setForceSpeakOff true but isBluetoothOn");
    }
  }
  
  public final void releaseWakeLock()
  {
    AppMethodBeat.i(31873);
    this.caz.setKeepScreenOn(false);
    AppMethodBeat.o(31873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.as
 * JD-Core Version:    0.7.0.1
 */