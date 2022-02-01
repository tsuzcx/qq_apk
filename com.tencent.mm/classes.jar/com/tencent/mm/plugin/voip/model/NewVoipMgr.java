package com.tencent.mm.plugin.voip.model;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.PowerManager;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.f.a.aap;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.abx;
import com.tencent.mm.f.a.abx.a;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.b.a.a;
import com.tencent.mm.plugin.voip.c.j;
import com.tencent.mm.plugin.voip.c.m;
import com.tencent.mm.plugin.voip.ui.VoipScoreDialog;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView.b;
import com.tencent.mm.plugin.voip.video.render.k.b;
import com.tencent.mm.plugin.voip.video.render.k.d;
import com.tencent.mm.plugin.voip.video.render.k.e;
import com.tencent.mm.plugin.voip.video.render.k.f;
import com.tencent.mm.plugin.voip.video.render.k.g;
import com.tencent.mm.plugin.voip.video.render.q;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class NewVoipMgr
  extends com.tencent.mm.plugin.voip.a
  implements com.tencent.mm.plugin.voip.video.render.d
{
  static int[] NLd = new int[2];
  static int pIN = 0;
  private TelephonyManager DOk;
  private IListener DOm;
  private long DQv;
  private boolean EZD;
  private long IMs;
  private MTimerHandler NKA;
  private boolean NKB;
  private boolean NKC;
  private int NKD;
  private boolean NKE;
  private int NKF;
  private boolean NKG;
  private com.tencent.mm.plugin.voip.widget.b NKH;
  private boolean NKI;
  private boolean NKJ;
  private String NKK;
  private boolean NKL;
  private boolean NKM;
  public int NKN;
  public int NKO;
  public int NKP;
  private long NKQ;
  private long NKR;
  private int NKS;
  boolean NKT;
  boolean NKU;
  private int NKV;
  public int NKW;
  public int NKX;
  int NKY;
  boolean NKZ;
  private com.tencent.mm.plugin.voip.c.b NKh;
  private com.tencent.mm.plugin.voip.c.l NKi;
  private com.tencent.mm.plugin.voip.video.render.k NKj;
  private volatile com.tencent.mm.plugin.voip.ui.b NKk;
  private a NKl;
  private boolean NKm;
  private boolean NKn;
  private boolean NKo;
  private Object NKp;
  private as NKq;
  boolean NKr;
  private boolean NKs;
  private boolean NKt;
  private int NKu;
  private boolean NKv;
  private int NKw;
  private long NKx;
  private int NKy;
  private com.tencent.mm.plugin.voip.video.f NKz;
  NetChangedBroadcastReceiver NLa;
  PhoneStateListener NLb;
  MMHandler NLc;
  private long NLe;
  private boolean NLf;
  private com.tencent.mm.plugin.voip.c.h NLg;
  private BroadcastReceiver NLh;
  int NLi;
  private IListener NLj;
  private com.tencent.mm.plugin.voip.c.a NOz;
  private long enterTime;
  private String iSn;
  private long lwE;
  private int mUIType;
  private MMHandler ntw;
  PhoneStateListener prS;
  TelephonyManager tSE;
  
  public NewVoipMgr()
  {
    AppMethodBeat.i(242282);
    this.NKl = null;
    this.NKm = true;
    this.NKn = false;
    this.NKo = false;
    this.NKp = new Object();
    this.NKt = false;
    this.NKu = 4096;
    this.NKv = false;
    this.NKw = -1;
    this.NKx = -1L;
    this.EZD = false;
    this.NKy = 0;
    this.NKz = new com.tencent.mm.plugin.voip.video.f();
    this.NKA = null;
    this.NKB = false;
    this.NKC = false;
    this.NKD = 0;
    this.NKE = false;
    this.NKF = -1;
    this.NKG = false;
    this.NKI = false;
    this.NKJ = false;
    this.NKK = null;
    this.NKL = true;
    this.NKM = false;
    this.NKN = -1;
    this.NKO = 0;
    this.NKP = 0;
    this.NKQ = 0L;
    this.NKR = 0L;
    this.NKS = 0;
    this.NKT = false;
    this.NKU = false;
    this.NKV = 0;
    this.NKW = 0;
    this.NKX = 0;
    this.NKY = 0;
    this.NKZ = false;
    this.NLc = new MMHandler("getSignalStrength");
    this.tSE = null;
    this.IMs = 0L;
    this.NLe = 0L;
    this.NLf = false;
    this.NOz = new com.tencent.mm.plugin.voip.c.a();
    this.NLh = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(244070);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        paramAnonymousIntent = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
        if (("android.intent.action.USER_PRESENT".equals(paramAnonymousContext)) && (paramAnonymousIntent.isScreenOn()))
        {
          if (NewVoipMgr.a(NewVoipMgr.this) != null)
          {
            NewVoipMgr.a(NewVoipMgr.this).NOp = false;
            AppMethodBeat.o(244070);
          }
        }
        else
        {
          if ("android.intent.action.SCREEN_ON".equals(paramAnonymousContext))
          {
            if (NewVoipMgr.a(NewVoipMgr.this) != null) {
              NewVoipMgr.a(NewVoipMgr.this).NOp = false;
            }
            NewVoipMgr.b(NewVoipMgr.this).onSensorEvent(true);
            AppMethodBeat.o(244070);
            return;
          }
          if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousContext))
          {
            if (NewVoipMgr.a(NewVoipMgr.this) != null) {
              NewVoipMgr.a(NewVoipMgr.this).NOp = true;
            }
            if (!NewVoipMgr.c(NewVoipMgr.this)) {
              NewVoipMgr.b(NewVoipMgr.this).onSensorEvent(true);
            }
            if ((!com.tencent.mm.plugin.voip.c.k.alC(NewVoipMgr.d(NewVoipMgr.this).mState)) && (!NewVoipMgr.e(NewVoipMgr.this))) {
              com.tencent.mm.plugin.voip.c.gxs().NPf.stopRing();
            }
          }
        }
        AppMethodBeat.o(244070);
      }
    };
    this.DOm = new IListener() {};
    this.NLi = 0;
    this.DQv = 0L;
    this.prS = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        int i = 1;
        AppMethodBeat.i(241671);
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        Log.i("MicroMsg.Voip.NewVoipMgr", "onCallStateChanged :%d, isStartVoip: %b,oldState:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(NewVoipMgr.t(NewVoipMgr.this)), Integer.valueOf(NewVoipMgr.u(NewVoipMgr.this)) });
        if (!NewVoipMgr.t(NewVoipMgr.this))
        {
          AppMethodBeat.o(241671);
          return;
        }
        if (((NewVoipMgr.u(NewVoipMgr.this) == 0) && (paramAnonymousInt == 1)) || ((NewVoipMgr.u(NewVoipMgr.this) == 0) && (paramAnonymousInt == 2))) {
          NewVoipMgr.v(NewVoipMgr.this);
        }
        if (paramAnonymousInt == 1)
        {
          NewVoipMgr.a(NewVoipMgr.this, true);
          if (NewVoipMgr.u(NewVoipMgr.this) == 0) {
            NewVoipMgr.c(NewVoipMgr.this, System.currentTimeMillis());
          }
          NewVoipMgr.c(NewVoipMgr.this, 1);
          com.tencent.mm.plugin.voip.c.gxs().akS(1);
          NewVoipMgr.b(NewVoipMgr.this, true);
        }
        label325:
        label359:
        do
        {
          NewVoipMgr.b(NewVoipMgr.this).NLf = NewVoipMgr.C(NewVoipMgr.this);
          AppMethodBeat.o(241671);
          return;
          if (paramAnonymousInt == 2)
          {
            NewVoipMgr.a(NewVoipMgr.this, false);
            if (NewVoipMgr.u(NewVoipMgr.this) == 1) {
              NewVoipMgr.d(NewVoipMgr.this, System.currentTimeMillis());
            }
            NewVoipMgr.c(NewVoipMgr.this, 2);
            Log.i("MicroMsg.Voip.NewVoipMgr", "phone call coming now!");
            if ((NewVoipMgr.e(NewVoipMgr.this)) && (!com.tencent.mm.plugin.voip.c.k.alC(NewVoipMgr.d(NewVoipMgr.this).mState))) {
              com.tencent.mm.plugin.voip.c.gxs().gAi();
            }
            String str2;
            String str1;
            if (com.tencent.mm.plugin.voip.c.k.alC(NewVoipMgr.d(NewVoipMgr.this).mState))
            {
              paramAnonymousString = MMApplicationContext.getContext().getString(b.g.voip_call_msg_chat_time, new Object[] { NewVoipMgr.SC(Util.secondsToNow(NewVoipMgr.w(NewVoipMgr.this))) });
              com.tencent.mm.plugin.voip.c.gxs().gAl();
              str2 = NewVoipMgr.x(NewVoipMgr.this).field_username;
              if (!NewVoipMgr.g(NewVoipMgr.this)) {
                break label596;
              }
              str1 = ca.VGy;
              if (!NewVoipMgr.e(NewVoipMgr.this)) {
                break label604;
              }
            }
            for (paramAnonymousInt = i;; paramAnonymousInt = 0)
            {
              s.b(str2, str1, paramAnonymousInt, 6, paramAnonymousString);
              NewVoipMgr.d(NewVoipMgr.this, 4107);
              NewVoipMgr.y(NewVoipMgr.this);
              paramAnonymousString = new ca();
              paramAnonymousString.setType(10000);
              paramAnonymousString.setCreateTime(System.currentTimeMillis());
              paramAnonymousString.setStatus(6);
              paramAnonymousString.setContent(MMApplicationContext.getContext().getString(b.g.voip_call_interrupted_by_other_app) + ", <a href=\"weixin://voip/callagain/?username=" + NewVoipMgr.f(NewVoipMgr.this) + "&isvideocall=" + NewVoipMgr.g(NewVoipMgr.this) + "\">" + MMApplicationContext.getContext().getString(b.g.voip_call_again) + "</a>");
              if ((NewVoipMgr.f(NewVoipMgr.this) != null) && (!NewVoipMgr.f(NewVoipMgr.this).equals("")))
              {
                paramAnonymousString.Jm(NewVoipMgr.f(NewVoipMgr.this));
                ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aM(paramAnonymousString);
              }
              com.tencent.mm.plugin.voip.c.gxs().akS(2);
              NewVoipMgr.b(NewVoipMgr.this, false);
              break;
              paramAnonymousString = MMApplicationContext.getContext().getString(b.g.voip_call_connection_failed);
              break label325;
              str1 = ca.VGx;
              break label359;
            }
          }
        } while (paramAnonymousInt != 0);
        label596:
        label604:
        if ((NewVoipMgr.u(NewVoipMgr.this) == 1) || (NewVoipMgr.u(NewVoipMgr.this) == 2)) {
          NewVoipMgr.d(NewVoipMgr.this, System.currentTimeMillis());
        }
        NewVoipMgr.c(NewVoipMgr.this, 0);
        com.tencent.mm.plugin.voip.c.gxs().akS(2);
        if ((1 == NewVoipMgr.z(NewVoipMgr.this)) && (com.tencent.mm.plugin.voip.c.k.alC(NewVoipMgr.d(NewVoipMgr.this).mState)) && (NewVoipMgr.A(NewVoipMgr.this))) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(236408);
              NewVoipMgr.b(NewVoipMgr.this).ds(true);
              AppMethodBeat.o(236408);
            }
          });
        }
        if ((4 == NewVoipMgr.z(NewVoipMgr.this)) && (NewVoipMgr.A(NewVoipMgr.this))) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(236326);
              NewVoipMgr.b(NewVoipMgr.this).aY(NewVoipMgr.B(NewVoipMgr.this), NewVoipMgr.g(NewVoipMgr.this));
              AppMethodBeat.o(236326);
            }
          });
        }
        NewVoipMgr.a(NewVoipMgr.this, false);
        if ((com.tencent.mm.compatible.b.g.atH() != null) && (com.tencent.mm.plugin.audio.c.a.crn().crm()))
        {
          Log.i("MicroMsg.Voip.NewVoipMgr", "is bluetooth can use and start bluetooth");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(237026);
              NewVoipMgr.b(NewVoipMgr.this).aY(NewVoipMgr.B(NewVoipMgr.this), NewVoipMgr.g(NewVoipMgr.this));
              AppMethodBeat.o(237026);
            }
          });
        }
        for (;;)
        {
          NewVoipMgr.b(NewVoipMgr.this, false);
          break;
          if (com.tencent.mm.plugin.audio.c.a.crn().crh()) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(233402);
                NewVoipMgr.b(NewVoipMgr.this).aY(NewVoipMgr.B(NewVoipMgr.this), NewVoipMgr.g(NewVoipMgr.this));
                AppMethodBeat.o(233402);
              }
            });
          }
        }
      }
    };
    this.lwE = -1L;
    this.enterTime = -1L;
    this.NLj = new IListener() {};
    this.NKh = new com.tencent.mm.plugin.voip.c.b();
    AppMethodBeat.o(242282);
  }
  
  private void Bl(final int paramInt)
  {
    AppMethodBeat.i(242349);
    Log.printDebugStack("MicroMsg.Voip.NewVoipMgr", "swtchState, action: %s, currentState: %s", new Object[] { com.tencent.mm.plugin.voip.c.k.alz(paramInt), com.tencent.mm.plugin.voip.c.k.alz(this.NKi.mState) });
    if ((4101 == paramInt) && (com.tencent.mm.plugin.voip.c.k.alD(this.NKi.mState)))
    {
      gyn();
      if (this.NKj != null) {
        this.NKj.release();
      }
      this.NKs = false;
      if (this.NKH != null) {
        this.NKH.NKs = false;
      }
    }
    if (aky(paramInt)) {
      this.NKh.NXl = false;
    }
    if ((aky(paramInt)) && (1 == this.mUIType) && (1 == this.NKw))
    {
      this.NKh.ds(false);
      gyo();
      if (!com.tencent.mm.plugin.voip.c.gxs().NPf.cNL())
      {
        this.NKh.gxW();
        this.NKh.aZ(false, this.NKr);
      }
      this.NKi.alH(paramInt);
      if (this.ntw != null) {
        this.ntw.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(242584);
            if (NewVoipMgr.o(NewVoipMgr.this) != null) {
              NewVoipMgr.o(NewVoipMgr.this).kR(paramInt, NewVoipMgr.d(NewVoipMgr.this).mState);
            }
            AppMethodBeat.o(242584);
          }
        });
      }
      switch (this.NKi.mState)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(242349);
      return;
      if ((4100 != paramInt) || (com.tencent.mm.plugin.voip.c.gxs().NPf.cNL())) {
        break;
      }
      this.NKh.gxW();
      break;
      akz(5);
      AppMethodBeat.o(242349);
      return;
      akz(6);
    }
  }
  
  private static String GN(long paramLong)
  {
    AppMethodBeat.i(242395);
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
    AppMethodBeat.o(242395);
    return str;
  }
  
  private void akx(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(242325);
    Log.i("MicroMsg.Voip.NewVoipMgr", "hangupTalkingOrCancelInvite");
    if (true == gyi()) {
      this.NKu = paramInt;
    }
    Object localObject = MMApplicationContext.getContext();
    String str2;
    if (com.tencent.mm.plugin.voip.c.k.alC(this.NKi.mState))
    {
      localObject = ((Context)localObject).getString(b.g.voip_call_msg_chat_time, new Object[] { GN(Util.secondsToNow(this.NKx)) });
      str2 = this.NKq.field_username;
      if (!this.NKs) {
        break label245;
      }
    }
    label245:
    for (String str1 = ca.VGy;; str1 = ca.VGx)
    {
      if (this.NKr) {
        i = 1;
      }
      s.b(str2, str1, i, 6, (String)localObject);
      if ((!this.NKr) || (com.tencent.mm.plugin.voip.c.k.alC(this.NKi.mState))) {
        break label253;
      }
      gxW();
      if ((this.NKr) && (!com.tencent.mm.plugin.voip.c.k.alC(this.NKi.mState)))
      {
        Log.i("MicroMsg.Voip.NewVoipMgr", "hangupVoipButton OnClick call cancelCall");
        com.tencent.mm.plugin.voip.c.gxs().gAh();
      }
      Log.i("MicroMsg.Voip.NewVoipMgr", "hangupVoipButton OnClick call hangUp");
      com.tencent.mm.plugin.voip.c.gxs().gAk();
      if (4096 != this.NKu) {
        break label306;
      }
      Bl(paramInt);
      gyb();
      AppMethodBeat.o(242325);
      return;
      if (this.NKr)
      {
        localObject = ((Context)localObject).getString(b.g.voip_call_cancel_msg_to);
        break;
      }
      localObject = ((Context)localObject).getString(b.g.voip_call_cancel_msg_from);
      break;
    }
    label253:
    com.tencent.e.h.ZvG.be(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "VoipMgr_play_end_sound";
      }
      
      public final void run()
      {
        AppMethodBeat.i(241985);
        NewVoipMgr.b(NewVoipMgr.this).Bi(NewVoipMgr.g(NewVoipMgr.this));
        AppMethodBeat.o(241985);
      }
    });
    this.NKn = true;
    this.NKo = true;
    com.tencent.mm.plugin.voip.c.gxs().gAk();
    if (4096 == this.NKu)
    {
      Bl(paramInt);
      gyb();
    }
    label306:
    AppMethodBeat.o(242325);
  }
  
  private boolean aky(int paramInt)
  {
    AppMethodBeat.i(242350);
    if (4111 == paramInt)
    {
      AppMethodBeat.o(242350);
      return true;
    }
    if ((4101 == paramInt) && ((com.tencent.mm.plugin.voip.c.k.alC(this.NKi.mState)) || (this.NKr)))
    {
      AppMethodBeat.o(242350);
      return true;
    }
    AppMethodBeat.o(242350);
    return false;
  }
  
  private static void akz(int paramInt)
  {
    AppMethodBeat.i(242351);
    abx localabx = new abx();
    localabx.gbT.fvK = paramInt;
    EventCenter.instance.publish(localabx);
    AppMethodBeat.o(242351);
  }
  
  private boolean c(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(242411);
    String str = com.tencent.mm.n.h.axc().getValue("VOIPShortcutAutoadd");
    Log.i("MicroMsg.Voip.NewVoipMgr", "voip shortcut autoAdd is %s", new Object[] { str });
    if ((str != null) && (str.equals("0")) && (Util.secondsToNow(this.NKx) > 30L))
    {
      int i = paramSharedPreferences.getInt("voip_shortcut_prompt_times", 0);
      boolean bool = paramSharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
      if ((i < 3) && (!bool))
      {
        gyj();
        paramSharedPreferences.edit().putInt("voip_shortcut_prompt_times", i + 1).commit();
        AppMethodBeat.o(242411);
        return true;
      }
    }
    else if ((str != null) && (str.equals("1")) && (Util.secondsToNow(this.NKx) > 15L))
    {
      d(paramSharedPreferences);
      AppMethodBeat.o(242411);
      return false;
    }
    AppMethodBeat.o(242411);
    return false;
  }
  
  private void d(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(242415);
    Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
    localIntent1.putExtra("duplicate", false);
    Intent localIntent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
    localIntent2.addFlags(67108864);
    if (1 == Util.getInt(com.tencent.mm.n.h.axc().getValue("VOIPCallType"), 0))
    {
      localIntent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(b.g.app_field_voip));
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getContext(), b.c.voip_camerachat));
      localIntent1.putExtra("shortcut_icon_resource_id", b.c.voip_camerachat);
    }
    for (;;)
    {
      localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
      com.tencent.mm.plugin.base.model.b.o(getContext(), localIntent1);
      paramSharedPreferences.edit().putBoolean("voip_shortcut_has_added", true).commit();
      AppMethodBeat.o(242415);
      return;
      localIntent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(b.g.app_field_voipaudio));
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getContext(), b.c.voip_voicechat));
      localIntent1.putExtra("shortcut_icon_resource_id", b.c.voip_voicechat);
    }
  }
  
  private boolean gxY()
  {
    int j = 0;
    AppMethodBeat.i(242346);
    if (!this.NKi.alG(4101))
    {
      AppMethodBeat.o(242346);
      return false;
    }
    this.NKs = false;
    if (this.NKH != null) {
      this.NKH.NKs = false;
    }
    Bl(4101);
    Object localObject1;
    int k;
    int i;
    Object localObject3;
    Object localObject2;
    if ((261 == this.NKi.mState) || (7 == this.NKi.mState))
    {
      com.tencent.mm.plugin.voip.c.gxs().akP(1);
      localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
      long l = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ;
      k = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId;
      if (this.NKr)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject1).a(11046, new Object[] { Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(k), Integer.valueOf(0), Integer.valueOf(i) });
        localObject3 = com.tencent.mm.plugin.report.service.h.IzE;
        k = 11080;
        localObject2 = new Object[3];
        localObject2[0] = Integer.valueOf(2);
        localObject2[1] = Integer.valueOf(0);
        i = 2;
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject1[i] = Integer.valueOf(j);
      ((com.tencent.mm.plugin.report.service.h)localObject3).a(k, (Object[])localObject2);
      do
      {
        com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.gyN();
        com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.gyO();
        AppMethodBeat.o(242346);
        return true;
        i = 0;
        break;
      } while ((1 != this.NKi.mState) && (3 != this.NKi.mState));
      com.tencent.mm.plugin.voip.c.gxs().akP(1);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
      k = 11046;
      localObject1 = new Object[5];
      localObject1[0] = Integer.valueOf(1);
      localObject1[1] = Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ);
      localObject1[2] = Integer.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId);
      localObject1[3] = Integer.valueOf(0);
      i = 4;
      if (this.NKr)
      {
        j = 1;
        localObject2 = localObject1;
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localh;
      }
      else
      {
        localObject2 = localObject1;
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localh;
      }
    }
  }
  
  private void gyb()
  {
    AppMethodBeat.i(242356);
    Log.d("MicroMsg.Voip.NewVoipMgr", "delayFinish");
    this.NKK = null;
    if (this.ntw != null) {
      this.ntw.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(240863);
          NewVoipMgr localNewVoipMgr = NewVoipMgr.this;
          Log.i("MicroMsg.Voip.NewVoipMgr", "it is uninit voip report");
          if (localNewVoipMgr.NLc != null)
          {
            localNewVoipMgr.NLc.removeCallbacksAndMessages(null);
            localNewVoipMgr.NLc.quit();
          }
          if (!localNewVoipMgr.NKZ)
          {
            if (localNewVoipMgr.NLi == 0) {
              localNewVoipMgr.akw(localNewVoipMgr.NKY);
            }
            if (localNewVoipMgr.NLi != 0)
            {
              localNewVoipMgr.NKZ = true;
              if (!localNewVoipMgr.NKr) {
                break label262;
              }
            }
          }
          label262:
          for (int i = 0;; i = 1)
          {
            com.tencent.mm.plugin.voip.c.e.a(i, System.currentTimeMillis(), localNewVoipMgr.NKY, localNewVoipMgr.NKY, 0, 0, NewVoipMgr.pIN / localNewVoipMgr.NLi);
            NewVoipMgr.pIN = 0;
            NewVoipMgr.NLd[0] = 0;
            NewVoipMgr.NLd[1] = 0;
            localNewVoipMgr.NLi = 0;
            if (localNewVoipMgr.tSE != null)
            {
              TelephonyManager localTelephonyManager = localNewVoipMgr.tSE;
              Object localObject = localNewVoipMgr.NLb;
              localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/voip/model/NewVoipMgr", "uninitVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
              localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(1)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(localTelephonyManager, "com/tencent/mm/plugin/voip/model/NewVoipMgr", "uninitVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            }
            if (localNewVoipMgr.NLa != null)
            {
              MMApplicationContext.getContext().unregisterReceiver(localNewVoipMgr.NLa);
              localNewVoipMgr.NLa = null;
            }
            NewVoipMgr.p(NewVoipMgr.this);
            AppMethodBeat.o(240863);
            return;
          }
        }
      }, 500L);
    }
    AppMethodBeat.o(242356);
  }
  
  private static void gyc()
  {
    AppMethodBeat.i(242359);
    aaq localaaq = new aaq();
    localaaq.fZM.fDn = 11;
    EventCenter.instance.publish(localaaq);
    AppMethodBeat.o(242359);
  }
  
  private void gyh()
  {
    long l2 = 0L;
    AppMethodBeat.i(242397);
    synchronized (this.NKp)
    {
      gyn();
      com.tencent.mm.plugin.voip.b.a locala = com.tencent.mm.plugin.voip.b.a.NTi;
      if (this.NKx == 0L)
      {
        l1 = 0L;
        if (this.NKs) {
          l2 = 1L;
        }
        com.tencent.mm.plugin.voip.b.a.aY(l1, l2);
        if (this.NKj != null) {
          this.NKj.release();
        }
        this.NKh.unInit();
        this.NKh.gyh();
        AppMethodBeat.o(242397);
        return;
      }
      long l1 = Util.secondsToNow(this.NKx);
    }
  }
  
  private boolean gyi()
  {
    AppMethodBeat.i(242408);
    if (com.tencent.mm.plugin.voip.c.k.alC(this.NKi.mState))
    {
      SharedPreferences localSharedPreferences = getContext().getSharedPreferences("voip_plugin_prefs", 0);
      if (!localSharedPreferences.getBoolean("voip_shortcut_has_added", false))
      {
        boolean bool = c(localSharedPreferences);
        AppMethodBeat.o(242408);
        return bool;
      }
    }
    AppMethodBeat.o(242408);
    return false;
  }
  
  private void gyj()
  {
    AppMethodBeat.i(242423);
    Context localContext = getContext();
    View localView = View.inflate(localContext, b.e.mm_alert_checkbox, null);
    final CheckBox localCheckBox = (CheckBox)localView.findViewById(b.d.mm_alert_dialog_cb);
    localCheckBox.setChecked(false);
    TextView localTextView = (TextView)localView.findViewById(b.d.mm_alert_dialog_info);
    if (1 == Util.getInt(com.tencent.mm.n.h.axc().getValue("VOIPCallType"), 0)) {
      localTextView.setText(b.g.voip_add_short_cut_tip);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(localContext, false, localContext.getString(b.g.app_tip), localView, localContext.getString(b.g.app_yes), localContext.getString(b.g.app_no), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(237305);
          paramAnonymousDialogInterface = NewVoipMgr.this.getContext().getSharedPreferences("voip_plugin_prefs", 0);
          NewVoipMgr.a(NewVoipMgr.this, paramAnonymousDialogInterface);
          if (4096 != NewVoipMgr.D(NewVoipMgr.this))
          {
            NewVoipMgr.d(NewVoipMgr.this, NewVoipMgr.D(NewVoipMgr.this));
            NewVoipMgr.E(NewVoipMgr.this);
          }
          if (NewVoipMgr.F(NewVoipMgr.this) != null) {
            NewVoipMgr.F(NewVoipMgr.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(238119);
                NewVoipMgr.p(NewVoipMgr.this);
                AppMethodBeat.o(238119);
              }
            });
          }
          AppMethodBeat.o(237305);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(236344);
          if (localCheckBox != null) {
            NewVoipMgr.this.getContext().getSharedPreferences("voip_plugin_prefs", 0).edit().putBoolean("voip_shortcut_never_show_anymore", localCheckBox.isChecked()).commit();
          }
          if (4096 != NewVoipMgr.D(NewVoipMgr.this))
          {
            NewVoipMgr.d(NewVoipMgr.this, NewVoipMgr.D(NewVoipMgr.this));
            NewVoipMgr.E(NewVoipMgr.this);
          }
          if (NewVoipMgr.F(NewVoipMgr.this) != null) {
            NewVoipMgr.F(NewVoipMgr.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(234748);
                NewVoipMgr.p(NewVoipMgr.this);
                AppMethodBeat.o(234748);
              }
            });
          }
          AppMethodBeat.o(236344);
        }
      });
      AppMethodBeat.o(242423);
      return;
      localTextView.setText(b.g.voip_add_short_cut_tip_audio);
    }
  }
  
  private void gyn()
  {
    AppMethodBeat.i(242436);
    if (this.NKz != null) {
      this.NKz.b(this);
    }
    if (this.NKA != null)
    {
      Log.d("MicroMsg.Voip.NewVoipMgr", "stop face detect timer");
      this.NKA.stopTimer();
    }
    AppMethodBeat.o(242436);
  }
  
  private void gyo()
  {
    AppMethodBeat.i(242438);
    this.NKJ = true;
    if ((this.NKJ) && (this.NKw == 2))
    {
      getContext();
      gyp();
    }
    AppMethodBeat.o(242438);
  }
  
  private void gyp()
  {
    AppMethodBeat.i(242439);
    this.NKh.ab(new kotlin.g.a.b() {});
    AppMethodBeat.o(242439);
  }
  
  private void hS(boolean paramBoolean)
  {
    AppMethodBeat.i(242357);
    Log.i("MicroMsg.Voip.NewVoipMgr", "finish");
    if (this.NLg != null) {
      this.NLg.gCP();
    }
    if (this.NOz != null)
    {
      this.NOz.gEI();
      this.NOz.gCh();
    }
    this.NKG = false;
    this.NKI = false;
    if (this.NKy != -1)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(11700, new Object[] { Integer.valueOf(this.NKy), Long.valueOf(Util.secondsToNow(this.NKx)) });
      this.NKy = -1;
    }
    try
    {
      MMApplicationContext.getContext().unregisterReceiver(this.NLh);
      label119:
      this.NKh.gCl();
      EventCenter.instance.removeListener(this.DOm);
      EventCenter.instance.removeListener(this.NLj);
      gyn();
      if (this.NKj != null)
      {
        this.NKj.release();
        this.NKj = null;
      }
      if (this.NKk != null)
      {
        this.NKk.uninit();
        this.NKk = null;
        this.NKh.b(this.NKk);
      }
      label248:
      int j;
      label313:
      long l;
      if (com.tencent.mm.plugin.voip.c.gxs() != null)
      {
        com.tencent.mm.plugin.voip.c.gxs().NPf.stopRing();
        if (paramBoolean)
        {
          com.tencent.mm.plugin.voip.c.gxs().gAm();
          if (!this.NKs) {
            break label786;
          }
          com.tencent.mm.plugin.voip.c.gxs().c(false, true, this.iSn);
          com.tencent.mm.plugin.voip.c.gxs().b(MMApplicationContext.getContext(), this);
        }
      }
      else
      {
        this.NKh.eVm();
        com.tencent.mm.plugin.voip.c.gxs().gAB();
        com.tencent.mm.plugin.voip.c.gxs().akZ(this.NKO);
        if (!this.NKn) {
          break label801;
        }
        this.NKl = new a();
        com.tencent.e.h.ZvG.be(this.NKl);
        Object localObject1;
        Object localObject2;
        if ((this.DOk != null) && (this.prS != null))
        {
          localObject1 = this.DOk;
          localObject2 = this.prS;
          localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
          ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(1)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
          this.prS = null;
        }
        this.DOk = null;
        com.tencent.mm.booter.a.aql().aqm();
        r.gzC().gzE();
        r.gzC().a(null);
        ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        com.tencent.mm.plugin.voip.c.gxs().gAE();
        Log.i("MicroMsg.Voip.NewVoipMgr", "finish, isFinishFromShutdown: %s", new Object[] { Boolean.valueOf(this.NKo) });
        if ((this.NKo) && (com.tencent.mm.plugin.voip.c.gxs().gAF()))
        {
          com.tencent.mm.plugin.voip.c.gxs();
          VoipScoreState.gAe();
          localObject2 = new Intent(getContext(), VoipScoreDialog.class);
          ((Intent)localObject2).putExtra("key_score_state", com.tencent.mm.plugin.voip.c.gxs().gAH());
          if (!(getContext() instanceof Activity)) {
            ((Intent)localObject2).addFlags(268435456);
          }
          localObject1 = getContext();
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        com.tencent.mm.plugin.voip.c.gxs().gAG();
        gyc();
        if (!this.NKU)
        {
          j = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId;
          l = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ;
          if (!this.NKr) {
            break label808;
          }
        }
      }
      label786:
      label801:
      label808:
      for (int i = 0;; i = 1)
      {
        com.tencent.mm.plugin.voip.c.e.c(j, l, i, 4);
        this.NKU = true;
        ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        com.tencent.mm.media.g.c.kVi.aUQ();
        AppMethodBeat.o(242357);
        return;
        com.tencent.mm.plugin.voip.c.gxs().gAk();
        break;
        com.tencent.mm.plugin.voip.c.gxs().c(false, false, this.iSn);
        break label248;
        gyh();
        break label313;
      }
    }
    catch (Exception localException)
    {
      break label119;
    }
  }
  
  public final void AI(boolean paramBoolean)
  {
    AppMethodBeat.i(242289);
    int j = com.tencent.mm.plugin.voip.c.k.bc(false, paramBoolean);
    int i = j;
    if (this.NKt)
    {
      if (j != 0) {
        break label80;
      }
      i = 1;
    }
    for (;;)
    {
      this.NKi = com.tencent.mm.plugin.voip.c.k.alA(i);
      Log.i("MicroMsg.Voip.NewVoipMgr", "steve:[simucall] resetStateMachine, initState:%d,isOutCall:%s,isVideoCall:%s", new Object[] { Integer.valueOf(i), Boolean.FALSE, Boolean.valueOf(paramBoolean) });
      this.NKr = false;
      AppMethodBeat.o(242289);
      return;
      label80:
      i = j;
      if (256 == j) {
        i = 257;
      }
    }
  }
  
  public final void AM(boolean paramBoolean)
  {
    AppMethodBeat.i(242292);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.NKh.ds(paramBoolean);
    this.NKh.NXs = true;
    AppMethodBeat.o(242292);
  }
  
  public final void AN(boolean paramBoolean)
  {
    AppMethodBeat.i(242337);
    if (this.NKj != null)
    {
      com.tencent.mm.plugin.voip.video.render.k localk = this.NKj;
      localk.NUy = paramBoolean;
      localk.setHWDecMode(localk.NUC);
    }
    AppMethodBeat.o(242337);
  }
  
  public final void AO(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(242368);
    Log.printInfoStack("MicroMsg.Voip.NewVoipMgr", "onShutDown", new Object[0]);
    String str1;
    String str3;
    String str2;
    label103:
    label112:
    label125:
    int k;
    label164:
    long l;
    if (com.tencent.mm.plugin.voip.c.k.alC(this.NKi.mState))
    {
      str1 = MMApplicationContext.getContext().getString(b.g.voip_call_msg_chat_time, new Object[] { GN(Util.secondsToNow(this.NKx)) });
      if ((!this.NKr) && (!com.tencent.mm.plugin.voip.c.k.alC(this.NKi.mState))) {
        break label289;
      }
      str3 = this.NKq.field_username;
      if (!this.NKs) {
        break label276;
      }
      str2 = ca.VGy;
      if (!this.NKr) {
        break label284;
      }
      i = 1;
      s.b(str3, str2, i, 6, str1);
      this.NKh.Bi(this.NKs);
      this.NKo = com.tencent.mm.plugin.voip.c.k.alC(this.NKi.mState);
      if (!gyi()) {
        break label359;
      }
      this.NKu = 4106;
      com.tencent.mm.plugin.voip.c.gxs().gAE();
      if (!this.NKU)
      {
        k = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId;
        l = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ;
        if (!this.NKr) {
          break label373;
        }
      }
    }
    label276:
    label284:
    label289:
    label321:
    label354:
    label359:
    label373:
    for (int i = j;; i = 1)
    {
      com.tencent.mm.plugin.voip.c.e.c(k, l, i, 4);
      this.NKU = true;
      AppMethodBeat.o(242368);
      return;
      if (this.NKr)
      {
        str1 = MMApplicationContext.getContext().getString(b.g.voip_call_connection_failed);
        break;
      }
      str1 = MMApplicationContext.getContext().getString(b.g.voip_call_cancel_msg_from);
      break;
      str2 = ca.VGx;
      break label103;
      i = 0;
      break label112;
      if ((this.NKr) || (!paramBoolean)) {
        break label125;
      }
      str3 = this.NKq.field_username;
      if (this.NKs)
      {
        str2 = ca.VGy;
        if (!this.NKr) {
          break label354;
        }
      }
      for (i = 1;; i = 0)
      {
        s.b(str3, str2, i, 6, str1);
        break;
        str2 = ca.VGx;
        break label321;
      }
      Bl(4106);
      gyb();
      break label164;
    }
  }
  
  public final boolean AP(final boolean paramBoolean)
  {
    AppMethodBeat.i(242425);
    if (com.tencent.mm.plugin.voip.c.gxs().NPv)
    {
      Log.i("MicroMsg.Voip.NewVoipMgr", "current state is mini, cannot mini!");
      AppMethodBeat.o(242425);
      return false;
    }
    if ((this.NKI) && (!paramBoolean))
    {
      Log.i("MicroMsg.Voip.NewVoipMgr", "has phone call  cannot mini!");
      AppMethodBeat.o(242425);
      return false;
    }
    Log.printDebugStack("MicroMsg.Voip.NewVoipMgr", "miniOnlyHidenVoip: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Log.i("MicroMsg.Voip.NewVoipMgr", "onMinimizeVoip, async to minimize");
    if (this.NKk != null)
    {
      this.NKk.uninit();
      this.NKk = null;
      this.NKh.b(this.NKk);
    }
    this.lwE = Util.currentTicks();
    if (this.NKH != null) {
      this.NKH.uninit();
    }
    if (this.ntw != null) {
      this.ntw.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(235801);
          NewVoipMgr.c(NewVoipMgr.this, paramBoolean);
          AppMethodBeat.o(235801);
        }
      });
    }
    AppMethodBeat.o(242425);
    return true;
  }
  
  public final void IA(int paramInt)
  {
    int i = 4;
    AppMethodBeat.i(242314);
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbI, true))
    {
      AppMethodBeat.o(242314);
      return;
    }
    if (this.NKj.OeO != null) {}
    for (boolean bool = this.NKj.OeO.gDy();; bool = true)
    {
      switch (paramInt)
      {
      case 3: 
      default: 
      case 2: 
        for (;;)
        {
          com.tencent.mm.plugin.voip.c.gxs().akQ(paramInt);
          AppMethodBeat.o(242314);
          return;
          if (bool) {
            paramInt = 2;
          } else {
            paramInt = 4;
          }
        }
      }
      if (bool) {}
      for (paramInt = i;; paramInt = 2) {
        break;
      }
    }
  }
  
  public final void XB(int paramInt)
  {
    AppMethodBeat.i(242344);
    if (this.NKk != null) {
      this.NKk.XB(paramInt);
    }
    AppMethodBeat.o(242344);
  }
  
  public final void a(final Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(242287);
    Log.i("MicroMsg.Voip.NewVoipMgr", "start VoIP, userName: %s, isOutCall: %b, isVideoCall: %b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.NKh.aX(paramBoolean2, paramBoolean1);
    this.NKh.gCj();
    this.NKG = true;
    this.iSn = paramString;
    this.NKr = paramBoolean1;
    this.NKs = paramBoolean2;
    this.NKq = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(this.iSn);
    this.ntw = new MMHandler(Looper.getMainLooper());
    this.NKN = 0;
    this.NKO = 0;
    this.NKP = 0;
    boolean bool1;
    int j;
    label196:
    label216:
    boolean bool2;
    if (Util.getInt(com.tencent.mm.n.h.axc().getValue("VOIPCameraSwitch"), 1) == 0)
    {
      bool1 = true;
      this.NKt = bool1;
      if (!this.NKs) {
        this.NKt = false;
      }
      j = com.tencent.mm.plugin.voip.c.k.bc(paramBoolean1, paramBoolean2);
      i = j;
      if (this.NKt)
      {
        if (j != 0) {
          break label546;
        }
        i = 1;
        com.tencent.mm.plugin.voip.c.gxs().akP(1);
      }
      if (!paramBoolean1) {
        break label566;
      }
      this.NKi = com.tencent.mm.plugin.voip.c.k.alB(i);
      this.NKh.NKi = this.NKi;
      bool1 = com.tencent.mm.compatible.e.b.avu();
      bool2 = com.tencent.mm.compatible.e.b.avv();
      if (Build.MANUFACTURER.equalsIgnoreCase("meizu"))
      {
        if (!bool1)
        {
          localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
          if (!this.NKs) {
            break label578;
          }
          i = 0;
          label269:
          ((com.tencent.mm.plugin.report.service.h)localObject1).a(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
        }
        if (!bool2)
        {
          localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
          if (!this.NKs) {
            break label584;
          }
          i = 0;
          label316:
          ((com.tencent.mm.plugin.report.service.h)localObject1).a(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
        }
      }
      if ((!bool2) || (!bool1))
      {
        localObject1 = null;
        localObject2 = null;
        if ((bool1) || (bool2)) {
          break label590;
        }
        localObject1 = paramContext.getString(b.g.voip_special_no_audio_camera_permission);
        localObject2 = paramContext.getString(b.g.voip_need_audio_and_camera_title);
        label387:
        com.tencent.mm.ui.base.h.a(paramContext, (String)localObject1, (String)localObject2, paramContext.getString(b.g.voip_need_show_settings_button), true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(244340);
            Log.i("MicroMsg.Voip.NewVoipMgr", "show Permission settings");
            com.tencent.mm.compatible.e.b.cs(paramContext);
            if (!NewVoipMgr.e(NewVoipMgr.this))
            {
              if (NewVoipMgr.g(NewVoipMgr.this))
              {
                NewVoipMgr.this.gxI();
                AppMethodBeat.o(244340);
                return;
              }
              NewVoipMgr.this.gxK();
              AppMethodBeat.o(244340);
              return;
            }
            if (NewVoipMgr.g(NewVoipMgr.this))
            {
              NewVoipMgr.this.gxM();
              AppMethodBeat.o(244340);
              return;
            }
            NewVoipMgr.this.gxN();
            AppMethodBeat.o(244340);
          }
        });
      }
      Log.i("MicroMsg.Voip.NewVoipMgr", "initMgr");
      paramContext = com.tencent.mm.plugin.voip.b.a.NTi;
      com.tencent.mm.plugin.voip.b.a.release();
      com.tencent.mm.booter.a.aql().aqn();
      if (!this.NKs) {
        break label642;
      }
      com.tencent.mm.plugin.voip.c.gxs().c(true, true, this.iSn);
      label454:
      if (!this.NKr) {
        break label675;
      }
      com.tencent.mm.plugin.voip.c.gxs().NPf.gAN();
      if (!this.NKs) {
        break label657;
      }
    }
    label642:
    label657:
    for (int i = com.tencent.mm.plugin.voip.c.gxs().bgg(this.NKq.field_username);; i = com.tencent.mm.plugin.voip.c.gxs().bgf(this.NKq.field_username))
    {
      if (i >= 0) {
        break label675;
      }
      hS(false);
      i = 0;
      if (i != 0)
      {
        this.NKh.aZ(paramBoolean2, paramBoolean1);
        com.tencent.mm.plugin.voip.c.gxs().e(paramString, this.NKs, paramLong);
      }
      AppMethodBeat.o(242287);
      return;
      bool1 = false;
      break;
      label546:
      i = j;
      if (256 != j) {
        break label196;
      }
      i = 257;
      break label196;
      label566:
      this.NKi = com.tencent.mm.plugin.voip.c.k.alA(i);
      break label216;
      label578:
      i = 1;
      break label269;
      label584:
      i = 1;
      break label316;
      label590:
      if (!bool1)
      {
        localObject1 = paramContext.getString(b.g.voip_special_no_record_audio_permission);
        localObject2 = paramContext.getString(b.g.voip_need_audio_title);
        break label387;
      }
      if (bool2) {
        break label387;
      }
      localObject1 = paramContext.getString(b.g.voip_special_no_open_camera_permission);
      localObject2 = paramContext.getString(b.g.voip_need_camera_title);
      break label387;
      com.tencent.mm.plugin.voip.c.gxs().c(true, false, this.iSn);
      break label454;
    }
    label675:
    com.tencent.mm.plugin.voip.c.gxs().a(MMApplicationContext.getContext(), this);
    this.DOk = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
    paramContext = this.DOk;
    Object localObject1 = this.prS;
    localObject1 = com.tencent.mm.hellhoundlib.b.c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject1);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/voip/model/NewVoipMgr", "initMgr", "()Z", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    paramContext.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/voip/model/NewVoipMgr", "initMgr", "()Z", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    paramContext = "voip_recent_contact" + z.bcZ();
    localObject1 = MMApplicationContext.getContext().getSharedPreferences("voip_plugin_prefs", 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString(paramContext, null);
    if (localObject2 != null)
    {
      localObject2 = Util.stringsToList(((String)localObject2).split(";"));
      if (localObject2 != null)
      {
        i = ((List)localObject2).size();
        if (((List)localObject2).contains(this.iSn))
        {
          if (i > 1)
          {
            ((List)localObject2).remove(this.iSn);
            label912:
            ((List)localObject2).add(0, this.iSn);
          }
          localObject2 = Util.listToString((List)localObject2, ";");
          ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
        }
      }
    }
    for (;;)
    {
      EventCenter.instance.addListener(this.NLj);
      EventCenter.instance.addListener(this.DOm);
      this.NKz.a(this);
      paramContext = new IntentFilter();
      paramContext.addAction("android.intent.action.SCREEN_ON");
      paramContext.addAction("android.intent.action.SCREEN_OFF");
      paramContext.addAction("android.intent.action.USER_PRESENT");
      MMApplicationContext.getContext().registerReceiver(this.NLh, paramContext);
      if (this.NKs)
      {
        this.NKj = new com.tencent.mm.plugin.voip.video.render.k(this, this.NKr);
        this.NLg = new com.tencent.mm.plugin.voip.c.h();
      }
      this.NOz.gEI();
      this.NOz.cLZ();
      i = 1;
      break;
      if (4 != i) {
        break label912;
      }
      ((List)localObject2).remove(i - 1);
      break label912;
      localObject2 = new ArrayList();
      ((List)localObject2).add(0, this.iSn);
      localObject2 = Util.listToString((List)localObject2, ";");
      ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
    }
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    AppMethodBeat.i(242320);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onVoipUIDestroy");
    if (this.NKk == paramb)
    {
      Log.d("MicroMsg.Voip.NewVoipMgr", "same VoipUI, clear it");
      this.NKk = null;
      this.NKh.b(null);
    }
    if (this.ntw != null) {
      this.ntw = null;
    }
    AppMethodBeat.o(242320);
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb, int paramInt)
  {
    AppMethodBeat.i(242303);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onVoipUICreated, uiType: %s,  mVoicePlayDevice: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.NKw) });
    if ((1 == paramInt) && (this.NKk != null)) {
      this.NKk.uninit();
    }
    this.NKk = paramb;
    this.mUIType = paramInt;
    this.NKh.b(this.NKk);
    this.NKk.kR(-1, this.NKi.mState);
    this.NKk.setConnectSec(this.NKx);
    this.NKk.alk(this.NKO);
    this.NKk.alk(this.NKP);
    int i;
    if ((this.NKk instanceof Activity))
    {
      i = ((WindowManager)((Activity)this.NKk).getSystemService("window")).getDefaultDisplay().getRotation();
      switch (i)
      {
      default: 
        paramInt = 0;
      }
    }
    for (;;)
    {
      if (this.NKj != null)
      {
        this.NKj.nrf = i;
        this.NKj.NZg = paramInt;
      }
      AppMethodBeat.o(242303);
      return;
      paramInt = 0;
      continue;
      paramInt = 180;
      continue;
      paramInt = 90;
      continue;
      paramInt = 270;
    }
  }
  
  public final void a(VoIPRenderSurfaceView paramVoIPRenderSurfaceView)
  {
    AppMethodBeat.i(242334);
    if (this.NKj != null)
    {
      com.tencent.mm.plugin.voip.video.render.k localk = this.NKj;
      if (paramVoIPRenderSurfaceView != null) {
        paramVoIPRenderSurfaceView.gEA();
      }
      localk.Ofb = false;
      localk.OeQ = false;
    }
    AppMethodBeat.o(242334);
  }
  
  public final void a(VoIPRenderSurfaceView paramVoIPRenderSurfaceView, int paramInt)
  {
    AppMethodBeat.i(242331);
    if (this.NKj != null)
    {
      com.tencent.mm.plugin.voip.c.h.alw(0);
      Object localObject = this.NKj;
      kotlin.g.b.p.k(paramVoIPRenderSurfaceView, "view");
      if (!((com.tencent.mm.plugin.voip.video.render.k)localObject).Ofb)
      {
        ((com.tencent.mm.plugin.voip.video.render.k)localObject).Ofb = true;
        com.tencent.mm.plugin.voip.video.render.p localp = ((com.tencent.mm.plugin.voip.video.render.k)localObject).OeR;
        if (localp != null) {
          localp.am((kotlin.g.a.a)new k.f((com.tencent.mm.plugin.voip.video.render.k)localObject));
        }
      }
      localObject = (k.b)new k.g((com.tencent.mm.plugin.voip.video.render.k)localObject);
      kotlin.g.b.p.k(localObject, "listener");
      paramVoIPRenderSurfaceView.Ofy = ((k.b)localObject);
      paramVoIPRenderSurfaceView.Ofz = paramInt;
      paramVoIPRenderSurfaceView.getHolder().addCallback(paramVoIPRenderSurfaceView.Ofx);
    }
    AppMethodBeat.o(242331);
  }
  
  public final void a(VoIPRenderTextureView paramVoIPRenderTextureView)
  {
    AppMethodBeat.i(242335);
    if (this.NKj != null)
    {
      com.tencent.mm.plugin.voip.video.render.k localk = this.NKj;
      if (paramVoIPRenderTextureView != null)
      {
        paramVoIPRenderTextureView.setSurfaceTextureListener(null);
        k.b localb = paramVoIPRenderTextureView.Ofy;
        if (localb != null) {
          localb.alQ(paramVoIPRenderTextureView.Ofz);
        }
        paramVoIPRenderTextureView.Ofy = null;
      }
      localk.Ofb = false;
      localk.OeQ = false;
    }
    AppMethodBeat.o(242335);
  }
  
  public final void a(VoIPRenderTextureView paramVoIPRenderTextureView, int paramInt)
  {
    AppMethodBeat.i(242327);
    if (this.NKj != null)
    {
      com.tencent.mm.plugin.voip.c.h.alw(1);
      Object localObject = this.NKj;
      kotlin.g.b.p.k(paramVoIPRenderTextureView, "view");
      if (!((com.tencent.mm.plugin.voip.video.render.k)localObject).Ofb)
      {
        ((com.tencent.mm.plugin.voip.video.render.k)localObject).Ofb = true;
        com.tencent.mm.plugin.voip.video.render.p localp = ((com.tencent.mm.plugin.voip.video.render.k)localObject).OeR;
        if (localp != null) {
          localp.am((kotlin.g.a.a)new k.d((com.tencent.mm.plugin.voip.video.render.k)localObject));
        }
      }
      localObject = (k.b)new k.e((com.tencent.mm.plugin.voip.video.render.k)localObject);
      kotlin.g.b.p.k(localObject, "listener");
      paramVoIPRenderTextureView.Ofy = ((k.b)localObject);
      paramVoIPRenderTextureView.Ofz = paramInt;
      paramVoIPRenderTextureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new VoIPRenderTextureView.b(paramVoIPRenderTextureView));
    }
    AppMethodBeat.o(242327);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void a(final int[] paramArrayOfInt, final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(242437);
    if ((this.NKj != null) && (!this.NKj.NOu))
    {
      this.NKj.gEx();
      this.NKj.NOu = true;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(241169);
        if (NewVoipMgr.a(NewVoipMgr.this) != null)
        {
          com.tencent.mm.plugin.voip.video.camera.a.a locala = NewVoipMgr.a(NewVoipMgr.this).OeO;
          if (locala != null) {
            locala.gDI();
          }
        }
        if (NewVoipMgr.o(NewVoipMgr.this) != null) {
          NewVoipMgr.o(NewVoipMgr.this);
        }
        AppMethodBeat.o(241169);
      }
    });
    AppMethodBeat.o(242437);
  }
  
  public final void aF(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(242311);
    if (this.NKk != null) {
      this.NKk.ali(paramInt1);
    }
    if (this.NKz != null) {
      this.NKz.kY(paramInt2, paramInt3);
    }
    AppMethodBeat.o(242311);
  }
  
  public final void aQ(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(242329);
    if (this.NLg != null)
    {
      com.tencent.mm.plugin.voip.c.h localh = this.NLg;
      long l = Util.currentTicks();
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          localh.NXV = l;
          AppMethodBeat.o(242329);
          return;
        }
        localh.NXT = l;
        AppMethodBeat.o(242329);
        return;
      }
      if (paramBoolean2)
      {
        localh.NXW = l;
        AppMethodBeat.o(242329);
        return;
      }
      localh.NXU = l;
    }
    AppMethodBeat.o(242329);
  }
  
  public final void akA(int paramInt)
  {
    AppMethodBeat.i(242370);
    Log.i("MicroMsg.Voip.NewVoipMgr", "remote voip mode changed, cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    if (((1 == paramInt) || (3 == paramInt) || (5 == paramInt) || (6 == paramInt) || (7 == paramInt)) && (this.NKs))
    {
      Bl(4101);
      com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.gyN();
      com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.gyO();
    }
    AppMethodBeat.o(242370);
  }
  
  public final void akB(int paramInt)
  {
    AppMethodBeat.i(242377);
    if (this.NKk != null) {
      this.NKk.akB(paramInt);
    }
    AppMethodBeat.o(242377);
  }
  
  public final void akC(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(242389);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onSessionBeingCalled, callType: ".concat(String.valueOf(paramInt)));
    if (!this.NKi.alG(4110))
    {
      AppMethodBeat.o(242389);
      return;
    }
    u localu = com.tencent.mm.plugin.voip.c.gxs();
    if (paramInt == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramInt == 1) {
        bool2 = true;
      }
      localu.aT(bool1, bool2);
      gxW();
      if ((paramInt == 1) && (com.tencent.mm.plugin.voip.c.k.alD(this.NKi.mState))) {
        Bl(4101);
      }
      Bl(4110);
      AppMethodBeat.o(242389);
      return;
    }
  }
  
  public final void akD(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(242390);
    Log.i("MicroMsg.Voip.NewVoipMgr", "steve:[simucall]onNewSimulCallAutoAccept, callType: ".concat(String.valueOf(paramInt)));
    if (!this.NKi.alG(4100))
    {
      AppMethodBeat.o(242390);
      return;
    }
    u localu = com.tencent.mm.plugin.voip.c.gxs();
    if (paramInt == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramInt == 1) {
        bool2 = true;
      }
      localu.aT(bool1, bool2);
      com.tencent.mm.plugin.voip.c.gxs().NPf.stopRing();
      if ((paramInt == 1) && (com.tencent.mm.plugin.voip.c.k.alD(this.NKi.mState))) {
        Bl(4101);
      }
      Bl(4100);
      AppMethodBeat.o(242390);
      return;
    }
  }
  
  final void akw(int paramInt)
  {
    AppMethodBeat.i(242307);
    if (paramInt == 5)
    {
      pIN += NLd[0];
      this.NLi += 1;
      Log.i("MicroMsg.Voip.NewVoipMgr", "mSignalStrength 4G" + NLd[0] + " and index is " + this.NLi);
      AppMethodBeat.o(242307);
      return;
    }
    if ((paramInt == 4) && (NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {}
    try
    {
      NLd[1] = ConnectivityCompat.Companion.getWiFiRssi();
      pIN += NLd[1];
      this.NLi += 1;
      Log.i("MicroMsg.Voip.NewVoipMgr", "mSignalStrength WIFI " + NLd[1] + " and index is " + this.NLi);
      AppMethodBeat.o(242307);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        NLd[1] = 0;
        Log.i("MicroMsg.Voip.NewVoipMgr", "error happened in get wifi info");
      }
    }
  }
  
  public final void ap(long paramLong, int paramInt)
  {
    int k = 1;
    AppMethodBeat.i(242318);
    Object localObject1;
    int i;
    label60:
    Object localObject2;
    int j;
    if (this.NLg != null) {
      switch (paramInt)
      {
      default: 
        if (this.NKj != null)
        {
          localObject1 = this.NLg;
          if (1 != this.mUIType) {
            break label367;
          }
          i = 1;
          localObject2 = this.NKj.OeR;
          j = k;
          if (localObject2 != null)
          {
            if (((com.tencent.mm.plugin.voip.video.render.p)localObject2).gEF() == 0) {
              break label373;
            }
            j = k;
          }
          label90:
          switch (paramInt)
          {
          }
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(242318);
      return;
      if (1 == this.mUIType)
      {
        if (!com.tencent.mm.plugin.voip.c.gxs().NPu)
        {
          localObject1 = this.NLg;
          if ((260 != this.NKi.mState) && (6 != this.NKi.mState)) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.plugin.voip.c.h)localObject1).ba(true, bool);
            com.tencent.mm.plugin.voip.c.gxs().NPu = true;
            break;
          }
        }
        localObject1 = this.NLg;
        if ((260 != this.NKi.mState) && (6 != this.NKi.mState)) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.voip.c.h)localObject1).bb(true, bool);
          break;
        }
      }
      if (!com.tencent.mm.plugin.voip.c.gxs().NPt)
      {
        localObject1 = this.NLg;
        if ((260 != this.NKi.mState) && (6 != this.NKi.mState)) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.voip.c.h)localObject1).ba(false, bool);
          com.tencent.mm.plugin.voip.c.gxs().NPt = true;
          break;
        }
      }
      localObject1 = this.NLg;
      if ((260 != this.NKi.mState) && (6 != this.NKi.mState)) {}
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.voip.c.h)localObject1).bb(false, bool);
        break;
      }
      label367:
      i = 0;
      break label60;
      label373:
      j = 0;
      break label90;
      ((com.tencent.mm.plugin.voip.c.h)localObject1).NXX += 1;
      if (((com.tencent.mm.plugin.voip.c.h)localObject1).NXX == 0)
      {
        if (i != 0)
        {
          if (paramLong > 0L)
          {
            localObject1 = j.NYe;
            j.SQ(paramLong);
            AppMethodBeat.o(242318);
          }
        }
        else
        {
          if (paramLong > 0L)
          {
            localObject1 = j.NYe;
            j.SR(paramLong);
          }
          AppMethodBeat.o(242318);
        }
      }
      else if (((com.tencent.mm.plugin.voip.c.h)localObject1).NXX == 60) {
        ((com.tencent.mm.plugin.voip.c.h)localObject1).NXX = -1;
      }
      AppMethodBeat.o(242318);
      return;
      ((com.tencent.mm.plugin.voip.c.h)localObject1).NXY += 1;
      if (((com.tencent.mm.plugin.voip.c.h)localObject1).NXY == 0)
      {
        if (i != 0)
        {
          if (j != 0)
          {
            localObject1 = j.NYe;
            j.Ti(paramLong);
            AppMethodBeat.o(242318);
            return;
          }
          localObject1 = j.NYe;
          j.Tg(paramLong);
          AppMethodBeat.o(242318);
          return;
        }
        if (j != 0)
        {
          localObject1 = j.NYe;
          j.Tj(paramLong);
          AppMethodBeat.o(242318);
          return;
        }
        localObject1 = j.NYe;
        j.Th(paramLong);
        AppMethodBeat.o(242318);
        return;
      }
      if (((com.tencent.mm.plugin.voip.c.h)localObject1).NXY == 60) {
        ((com.tencent.mm.plugin.voip.c.h)localObject1).NXY = -1;
      }
      AppMethodBeat.o(242318);
      return;
      ((com.tencent.mm.plugin.voip.c.h)localObject1).NXZ += 1;
      if (((com.tencent.mm.plugin.voip.c.h)localObject1).NXZ == 0)
      {
        if (i != 0)
        {
          localObject2 = j.NYe;
          j.SS(paramLong);
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.voip.c.h)localObject1).NXX = 0;
          AppMethodBeat.o(242318);
          return;
          localObject2 = j.NYe;
          j.ST(paramLong);
        }
      }
      if (((com.tencent.mm.plugin.voip.c.h)localObject1).NXZ == 60) {
        ((com.tencent.mm.plugin.voip.c.h)localObject1).NXZ = -1;
      }
    }
  }
  
  public final void aq(long paramLong, int paramInt) {}
  
  public final void bgb(String paramString)
  {
    AppMethodBeat.i(242352);
    if (this.NKk != null)
    {
      this.NKK = paramString;
      this.NKk.bgj(paramString);
    }
    AppMethodBeat.o(242352);
  }
  
  public final void cNy() {}
  
  public final void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(242373);
    if (this.NKj != null)
    {
      Object localObject1 = this.NKj;
      kotlin.g.b.p.k(paramArrayOfByte, "outData");
      localObject1 = ((com.tencent.mm.plugin.voip.video.render.k)localObject1).OeR;
      if (localObject1 != null)
      {
        int i = OpenGlRender.FLAG_YV12Edge;
        int j = OpenGlRender.FLAG_Angle90;
        kotlin.g.b.p.k(paramArrayOfByte, "pBuff");
        localObject1 = ((com.tencent.mm.plugin.voip.video.render.p)localObject1).Ogc;
        if (localObject1 != null)
        {
          kotlin.g.b.p.k(paramArrayOfByte, "pBuff");
          if (((com.tencent.mm.plugin.voip.video.render.e)localObject1).Obd != null)
          {
            Object localObject2 = ((com.tencent.mm.plugin.voip.video.render.e)localObject1).Oei;
            if (localObject2 != null)
            {
              kotlin.g.b.p.k(paramArrayOfByte, "pBuff");
              localObject2 = ((com.tencent.mm.plugin.voip.video.render.o)localObject2).Suz;
              kotlin.g.b.p.k(paramArrayOfByte, "pBuff");
              localObject2 = ((com.tencent.mm.plugin.voip.video.c.g)localObject2).Odn;
              if (localObject2 != null)
              {
                kotlin.g.b.p.k(paramArrayOfByte, "pBuff");
                if (((com.tencent.mm.plugin.voip.video.c.k)localObject2).NZb == null)
                {
                  ((com.tencent.mm.plugin.voip.video.c.k)localObject2).mWidth = paramInt1;
                  ((com.tencent.mm.plugin.voip.video.c.k)localObject2).mHeight = paramInt2;
                  ((com.tencent.mm.plugin.voip.video.c.k)localObject2).GIg = (i + j);
                  ((com.tencent.mm.plugin.voip.video.c.k)localObject2).NZb = paramArrayOfByte;
                }
              }
            }
            paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.render.e)localObject1).Obd;
            if (paramArrayOfByte == null) {
              kotlin.g.b.p.iCn();
            }
            ((q)localObject1).b(paramArrayOfByte);
          }
        }
      }
      if (this.NKk != null) {
        this.NKk.gBJ();
      }
    }
    AppMethodBeat.o(242373);
  }
  
  public final void eIH()
  {
    AppMethodBeat.i(242354);
    Log.i("MicroMsg.Voip.NewVoipMgr", "on accept");
    gxW();
    Bl(4100);
    AppMethodBeat.o(242354);
  }
  
  public final void eIN()
  {
    long l = 0L;
    AppMethodBeat.i(242401);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onNetWorkChangeMobileNet");
    if (this.NKk != null) {
      this.NKk.gBK();
    }
    com.tencent.mm.plugin.voip.b.a locala = com.tencent.mm.plugin.voip.b.a.NTi;
    if (com.tencent.mm.plugin.voip.c.gxs().NKx == 0L) {}
    for (;;)
    {
      com.tencent.mm.plugin.voip.b.a.n(Long.valueOf(l));
      AppMethodBeat.o(242401);
      return;
      l = Util.secondsToNow(com.tencent.mm.plugin.voip.c.gxs().NKx);
    }
  }
  
  public final void eIO()
  {
    AppMethodBeat.i(242403);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onNetWorkCostMax");
    if (this.NKk != null) {
      this.NKk.eIO();
    }
    AppMethodBeat.o(242403);
  }
  
  public final void eIP()
  {
    AppMethodBeat.i(242405);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onResumeGoodNetStatus");
    if (this.NKk != null) {
      this.NKk.eKF();
    }
    AppMethodBeat.o(242405);
  }
  
  public final void eXH()
  {
    AppMethodBeat.i(242347);
    if (this.NKk != null) {
      this.NKk.eXH();
    }
    AppMethodBeat.o(242347);
  }
  
  public final void fP(int paramInt1, int paramInt2) {}
  
  public final Context getContext()
  {
    AppMethodBeat.i(242418);
    Context localContext1 = null;
    if (this.NKk != null) {
      localContext1 = this.NKk.gBI();
    }
    Context localContext2 = localContext1;
    if (localContext1 == null) {
      localContext2 = MMApplicationContext.getContext();
    }
    AppMethodBeat.o(242418);
    return localContext2;
  }
  
  public final int getState()
  {
    return this.NKi.mState;
  }
  
  public final String getUserName()
  {
    return this.iSn;
  }
  
  public final boolean gxG()
  {
    AppMethodBeat.i(242294);
    if (!this.NKi.alG(4103))
    {
      AppMethodBeat.o(242294);
      return false;
    }
    akx(4103);
    com.tencent.mm.plugin.voip.c.gxs().gAE();
    AppMethodBeat.o(242294);
    return true;
  }
  
  public final boolean gxH()
  {
    AppMethodBeat.i(242295);
    if (!this.NKi.alG(4101))
    {
      AppMethodBeat.o(242295);
      return false;
    }
    gxW();
    com.tencent.mm.plugin.voip.c.gxs().akP(1);
    com.tencent.mm.plugin.voip.c.gxs().aT(true, this.NKs);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
    long l = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ;
    int j = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId;
    if (this.NKr) {}
    for (int i = 1;; i = 0)
    {
      localh.a(11046, new Object[] { Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i) });
      com.tencent.mm.plugin.report.service.h.IzE.a(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0) });
      Bl(4111);
      Bl(4101);
      Bl(4100);
      AppMethodBeat.o(242295);
      return true;
    }
  }
  
  public final boolean gxI()
  {
    int i = 0;
    AppMethodBeat.i(242297);
    if (!this.NKi.alG(4099))
    {
      AppMethodBeat.o(242297);
      return false;
    }
    String str2 = this.NKq.field_username;
    if (this.NKs) {}
    for (String str1 = ca.VGy;; str1 = ca.VGx)
    {
      if (this.NKr) {
        i = 1;
      }
      s.b(str2, str1, i, 6, MMApplicationContext.getContext().getString(b.g.voip_callfrom_reject_msg));
      gxW();
      com.tencent.mm.plugin.voip.c.gxs().gAj();
      Bl(4099);
      gyb();
      AppMethodBeat.o(242297);
      return true;
    }
  }
  
  public final boolean gxJ()
  {
    AppMethodBeat.i(242298);
    if (!this.NKi.alG(4100))
    {
      AppMethodBeat.o(242298);
      return false;
    }
    if (this.NKj != null) {
      this.NKj.gEx();
    }
    Log.i("MicroMsg.Voip.NewVoipMgr", "onAcceptVideoInvite");
    gxW();
    com.tencent.mm.plugin.voip.c.gxs().aT(false, this.NKs);
    Bl(4100);
    AppMethodBeat.o(242298);
    return true;
  }
  
  public final boolean gxK()
  {
    int i = 0;
    AppMethodBeat.i(242299);
    if (!this.NKi.alG(4099))
    {
      AppMethodBeat.o(242299);
      return false;
    }
    Log.i("MicroMsg.Voip.NewVoipMgr", "onRejectVoiceInvite");
    String str2 = this.NKq.field_username;
    if (this.NKs) {}
    for (String str1 = ca.VGy;; str1 = ca.VGx)
    {
      if (this.NKr) {
        i = 1;
      }
      s.b(str2, str1, i, 6, MMApplicationContext.getContext().getString(b.g.voip_callfrom_reject_msg));
      gxW();
      com.tencent.mm.plugin.voip.c.gxs().gAj();
      Bl(4099);
      gyb();
      AppMethodBeat.o(242299);
      return true;
    }
  }
  
  public final boolean gxL()
  {
    AppMethodBeat.i(242300);
    if (!this.NKi.alG(4100))
    {
      AppMethodBeat.o(242300);
      return false;
    }
    Log.i("MicroMsg.Voip.NewVoipMgr", "onAcceptVoiceInvite");
    gxW();
    com.tencent.mm.plugin.voip.c.gxs().aT(true, this.NKs);
    Bl(4111);
    Bl(4100);
    AppMethodBeat.o(242300);
    return true;
  }
  
  public final boolean gxM()
  {
    AppMethodBeat.i(242301);
    if (!this.NKi.alG(4098))
    {
      AppMethodBeat.o(242301);
      return false;
    }
    Log.i("MicroMsg.Voip.NewVoipMgr", "onCancelVideoInvite");
    akx(4098);
    com.tencent.mm.plugin.voip.c.gxs().gAE();
    AppMethodBeat.o(242301);
    return true;
  }
  
  public final boolean gxN()
  {
    AppMethodBeat.i(242302);
    if (!this.NKi.alG(4098))
    {
      AppMethodBeat.o(242302);
      return false;
    }
    Log.i("MicroMsg.Voip.NewVoipMgr", "onCancelVoiceInvite");
    akx(4098);
    com.tencent.mm.plugin.voip.c.gxs().gAE();
    AppMethodBeat.o(242302);
    return true;
  }
  
  public final void gxO()
  {
    boolean bool2 = true;
    AppMethodBeat.i(242305);
    if ((this.NKs) && (this.NKj != null))
    {
      com.tencent.mm.plugin.voip.video.render.k localk = this.NKj;
      if ((localk.OeO != null) && (localk.OeR != null))
      {
        Object localObject = localk.OeR;
        if (localObject == null) {
          kotlin.g.b.p.iCn();
        }
        if (((com.tencent.mm.plugin.voip.video.render.p)localObject).Oga != null)
        {
          localObject = localk.OeR;
          if (localObject == null) {
            kotlin.g.b.p.iCn();
          }
          localObject = ((com.tencent.mm.plugin.voip.video.render.p)localObject).Oga;
          if (localObject == null) {
            kotlin.g.b.p.iCn();
          }
          com.tencent.mm.plugin.voip.video.camera.a.a locala = localk.OeO;
          if (locala == null) {
            break label185;
          }
          bool1 = locala.gDy();
          localk.c((com.tencent.mm.plugin.voip.video.render.h)localObject, bool1);
        }
      }
    }
    if ((this.NKr) && (com.tencent.mm.plugin.voip.c.k.alE(this.NKi.mState)) && (com.tencent.mm.plugin.voip.c.gxs().NPf.cNL()))
    {
      this.NKh.aZ(this.NKs, this.NKr);
      if (this.NKw != 1) {
        break label190;
      }
    }
    label185:
    label190:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      AM(bool1);
      AppMethodBeat.o(242305);
      return;
      bool1 = true;
      break;
    }
  }
  
  public final void gxP()
  {
    AppMethodBeat.i(242309);
    Log.i("MicroMsg.Voip.NewVoipMgr", "it is init voip report");
    this.NLa = new NetChangedBroadcastReceiver();
    Object localObject1 = new IntentFilter();
    ((IntentFilter)localObject1).addAction("android.net.wifi.WIFI_STATE_CHANGED");
    ((IntentFilter)localObject1).addAction("android.net.wifi.STATE_CHANGE");
    ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
    MMApplicationContext.getContext().registerReceiver(this.NLa, (IntentFilter)localObject1);
    this.tSE = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
    this.NKY = com.tencent.mm.plugin.voip.c.e.getNetType(getContext());
    this.NLb = new PhoneStateListener()
    {
      public final void onSignalStrengthsChanged(SignalStrength paramAnonymousSignalStrength)
      {
        AppMethodBeat.i(243951);
        super.onSignalStrengthsChanged(paramAnonymousSignalStrength);
        super.onSignalStrengthsChanged(paramAnonymousSignalStrength);
        paramAnonymousSignalStrength = paramAnonymousSignalStrength.toString().split(" ");
        try
        {
          if ((NewVoipMgr.h(NewVoipMgr.this).getNetworkType() == 13) && (paramAnonymousSignalStrength.length > 9)) {
            NewVoipMgr.gyq()[0] = Util.safeParseInt(paramAnonymousSignalStrength[9]);
          }
          AppMethodBeat.o(243951);
          return;
        }
        catch (Exception paramAnonymousSignalStrength)
        {
          Log.printErrStackTrace("MicroMsg.Voip.NewVoipMgr", paramAnonymousSignalStrength, "", new Object[0]);
          AppMethodBeat.o(243951);
        }
      }
    };
    localObject1 = this.tSE;
    Object localObject2 = this.NLb;
    localObject2 = com.tencent.mm.hellhoundlib.b.c.a(256, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/voip/model/NewVoipMgr", "initVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/voip/model/NewVoipMgr", "initVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    AppMethodBeat.o(242309);
  }
  
  public final void gxQ()
  {
    AppMethodBeat.i(242312);
    if ((this.EZD) || (this.NKk == null) || (this.NKk.gBI() == null) || (this.NKj == null) || (this.NKj.OeO == null))
    {
      Log.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, already show");
      AppMethodBeat.o(242312);
      return;
    }
    if (this.NKj.OeO.egx())
    {
      AppMethodBeat.o(242312);
      return;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("meizu")) && (!com.tencent.mm.compatible.e.b.avv()) && (com.tencent.mm.compatible.util.d.qW(29)))
    {
      Log.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, meizu machine");
      AppMethodBeat.o(242312);
      return;
    }
    if ((com.tencent.mm.compatible.util.d.qV(28)) && (((KeyguardManager)MMApplicationContext.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()))
    {
      Log.i("MicroMsg.Voip.NewVoipMgr", "api level: %s, in keyguard, ignore", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(242312);
      return;
    }
    Log.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, show dialog");
    com.tencent.mm.plugin.report.service.h.IzE.a(11306, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.p(this.NKk.gBI(), b.g.voip_no_record_video_permission, b.g.app_tip);
    if (locald == null)
    {
      Log.e("MicroMsg.Voip.NewVoipMgr", "new dialog failed");
      AppMethodBeat.o(242312);
      return;
    }
    locald.setCancelable(false);
    locald.setCanceledOnTouchOutside(false);
    locald.show();
    this.EZD = true;
    com.tencent.mm.plugin.voip.c.h.gCQ();
    AppMethodBeat.o(242312);
  }
  
  public final void gxR()
  {
    AppMethodBeat.i(242322);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onSwitchCamera");
    com.tencent.mm.plugin.voip.video.render.k localk;
    Object localObject;
    int i;
    if (this.NKj != null)
    {
      localk = this.NKj;
      Log.i("MicroMsg.VoIPRenderMgr", "onSwitchCamera");
      if (localk.OeO != null)
      {
        localObject = localk.OeO;
        if (localObject == null) {
          kotlin.g.b.p.iCn();
        }
        if (((com.tencent.mm.plugin.voip.video.camera.a.a)localObject).gDC() != null)
        {
          localk.onOrientationChange(localk.nrf);
          localObject = localk.OeO;
          if (localObject != null) {
            ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject).gDD();
          }
          localObject = localk.OeO;
          if (localObject == null) {
            kotlin.g.b.p.iCn();
          }
          localObject = ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject).gDC();
          if (localObject == null) {
            kotlin.g.b.p.iCn();
          }
          com.tencent.mm.plugin.voip.video.camera.a.a locala = localk.OeO;
          if (locala == null) {
            kotlin.g.b.p.iCn();
          }
          i = locala.gDE();
          locala = localk.OeO;
          if (locala == null) {
            kotlin.g.b.p.iCn();
          }
          if (locala.gDF()) {
            break label210;
          }
        }
      }
    }
    label210:
    for (boolean bool = true;; bool = false)
    {
      localk.a((ad)localObject, i, bool);
      localk.alO(localk.NZg);
      localk.OeX = true;
      com.tencent.mm.plugin.report.service.h.IzE.a(11079, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(242322);
      return;
    }
  }
  
  public final void gxS()
  {
    AppMethodBeat.i(242323);
    if ((this.NKj != null) && (this.NKj.OeO != null) && (true != this.NKj.OeO.gDy())) {
      gxR();
    }
    AppMethodBeat.o(242323);
  }
  
  public final void gxT()
  {
    AppMethodBeat.i(242336);
    if (this.NKj != null)
    {
      Object localObject1 = this.NKj;
      Log.printInfoStack("MicroMsg.VoIPRenderMgr", "onRender Mode changed", new Object[0]);
      if (!((com.tencent.mm.plugin.voip.video.render.k)localObject1).NUy) {}
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.voip.video.render.k)localObject1).NUy = bool;
        Object localObject2 = ((com.tencent.mm.plugin.voip.video.render.k)localObject1).OeR;
        if (localObject2 != null) {
          com.tencent.mm.plugin.voip.video.render.p.a((com.tencent.mm.plugin.voip.video.render.p)localObject2);
        }
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.k)localObject1).OeR;
        if (localObject2 != null)
        {
          Log.printInfoStack("MicroMsg.LocalWindowsSurfaceRenderer", "switchRenderSurface", new Object[0]);
          q localq = ((com.tencent.mm.plugin.voip.video.render.p)localObject2).Ogb;
          if (localq != null) {
            localq.gEr();
          }
          localObject2 = ((com.tencent.mm.plugin.voip.video.render.p)localObject2).Ogc;
          if (localObject2 != null) {
            ((q)localObject2).gEr();
          }
        }
        localObject1 = ((com.tencent.mm.plugin.voip.video.render.k)localObject1).OeR;
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.plugin.voip.video.render.p)localObject1).gEs();
        AppMethodBeat.o(242336);
        return;
      }
    }
    AppMethodBeat.o(242336);
  }
  
  public final void gxU()
  {
    AppMethodBeat.i(242338);
    if (this.NKj != null) {
      this.NKj.kN(this.NKW, this.NKX);
    }
    AppMethodBeat.o(242338);
  }
  
  public final void gxV()
  {
    AppMethodBeat.i(242341);
    this.NLg.alv(1);
    AppMethodBeat.o(242341);
  }
  
  public final void gxW()
  {
    AppMethodBeat.i(242343);
    if (this.NKh != null)
    {
      Log.i("MicroMsg.Voip.NewVoipMgr", "use audioManager to stop voip ring");
      this.NKh.gxW();
      AppMethodBeat.o(242343);
      return;
    }
    Log.i("MicroMsg.Voip.NewVoipMgr", "use Subcore to stop voip ring");
    com.tencent.mm.plugin.voip.c.gxs().NPf.stopRing();
    AppMethodBeat.o(242343);
  }
  
  public final boolean gxX()
  {
    AppMethodBeat.i(242345);
    if (com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId == 0)
    {
      this.NKv = true;
      AppMethodBeat.o(242345);
      return true;
    }
    boolean bool = gxY();
    AppMethodBeat.o(242345);
    return bool;
  }
  
  public final void gxZ()
  {
    AppMethodBeat.i(242348);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onRoomReady");
    if ((this.NKv) && (com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId != 0))
    {
      this.NKv = false;
      gxY();
    }
    if (this.NKr) {
      Bl(4097);
    }
    AppMethodBeat.o(242348);
  }
  
  public final boolean gxl()
  {
    return this.NKs;
  }
  
  public final boolean gxm()
  {
    return this.NKr;
  }
  
  public final String gxn()
  {
    return this.NKK;
  }
  
  public final long gxo()
  {
    return this.NKQ;
  }
  
  public final long gxp()
  {
    return this.NKR;
  }
  
  public final int gxq()
  {
    return this.NKS;
  }
  
  public final void gya()
  {
    AppMethodBeat.i(242355);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onReject");
    Bl(4099);
    String str2 = this.NKq.field_username;
    String str1;
    if (this.NKs)
    {
      str1 = ca.VGy;
      if (!this.NKr) {
        break label86;
      }
    }
    label86:
    for (int i = 1;; i = 0)
    {
      s.b(str2, str1, i, 6, MMApplicationContext.getContext().getString(b.g.voip_callout_reject_msg));
      gyb();
      AppMethodBeat.o(242355);
      return;
      str1 = ca.VGx;
      break;
    }
  }
  
  public final void gyd()
  {
    AppMethodBeat.i(242362);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onNoResp");
    Bl(4105);
    String str2 = this.NKq.field_username;
    String str1;
    if (this.NKs)
    {
      str1 = ca.VGy;
      if (!this.NKr) {
        break label181;
      }
    }
    label181:
    for (int i = 1;; i = 0)
    {
      s.b(str2, str1, i, 4, MMApplicationContext.getContext().getString(b.g.voip_callout_no_resp));
      com.tencent.mm.plugin.report.service.h.IzE.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.gyI()), Integer.valueOf(6), Integer.valueOf(NetStatusUtil.getNetWorkType(getContext())) });
      gyb();
      AppMethodBeat.o(242362);
      return;
      str1 = ca.VGx;
      break;
    }
  }
  
  public final void gye()
  {
    int j = 0;
    AppMethodBeat.i(242365);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
    int k = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId;
    long l1 = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ;
    long l2 = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.gyI();
    if (this.NKr)
    {
      i = 0;
      localh.a(11522, true, true, new Object[] { Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(1) });
      k = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId;
      l1 = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ;
      if (!this.NKr) {
        break label198;
      }
    }
    label198:
    for (int i = j;; i = 1)
    {
      com.tencent.mm.plugin.voip.c.e.c(k, l1, i, 3);
      this.NLc.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(233374);
          NewVoipMgr.a(NewVoipMgr.this, NewVoipMgr.i(NewVoipMgr.this));
          NewVoipMgr.q(NewVoipMgr.this).postDelayed(this, 5000L);
          AppMethodBeat.o(233374);
        }
      });
      AppMethodBeat.o(242365);
      return;
      i = 1;
      break;
    }
  }
  
  public final void gyf()
  {
    AppMethodBeat.i(242392);
    Log.d("MicroMsg.Voip.NewVoipMgr", "onPretreatmentForStartDev");
    this.NKh.aY(this.NKJ, this.NKs);
    AppMethodBeat.o(242392);
  }
  
  public final long gyg()
  {
    AppMethodBeat.i(242394);
    long l = this.NKh.NXi;
    Log.printInfoStack("MicroMsg.Voip.NewVoipMgr", "totalDeviceNearTime: %s", new Object[] { Long.valueOf(l) });
    l /= 1000L;
    AppMethodBeat.o(242394);
    return l;
  }
  
  public final void gyk()
  {
    AppMethodBeat.i(242428);
    if ((256 != this.NKi.mState) && (257 != this.NKi.mState))
    {
      AppMethodBeat.o(242428);
      return;
    }
    if ((com.tencent.mm.kernel.h.aHG().aHp().getInt(327945, 0) == 0) && (this.NKk.gBI() != null))
    {
      com.tencent.mm.kernel.h.aHG().aHp().setInt(327945, 1);
      com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.a(this.NKk.gBI(), b.g.voip_ignore_warning, b.g.app_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(235017);
          NewVoipMgr.this.gym();
          AppMethodBeat.o(235017);
        }
      });
      locald.setCancelable(false);
      locald.setCanceledOnTouchOutside(false);
      locald.show();
      AppMethodBeat.o(242428);
      return;
    }
    m.aL(MMApplicationContext.getContext(), b.g.voip_ignore_warning);
    gym();
    AppMethodBeat.o(242428);
  }
  
  public final void gyl()
  {
    AppMethodBeat.i(242431);
    if (!this.NKB) {}
    for (boolean bool = true;; bool = false)
    {
      this.NKB = bool;
      if (!this.NKB) {
        break;
      }
      this.NKA.stopTimer();
      AppMethodBeat.o(242431);
      return;
    }
    if (this.NKA == null) {
      this.NKA = new MTimerHandler("faceDetect", new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(235614);
          NewVoipMgr.H(NewVoipMgr.this);
          AppMethodBeat.o(235614);
          return true;
        }
      }, true);
    }
    this.NKA.startTimer(2000L);
    this.NKB = false;
    AppMethodBeat.o(242431);
  }
  
  public final void gym()
  {
    AppMethodBeat.i(242433);
    com.tencent.mm.plugin.voip.c.gxs().NPn = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId;
    String str2 = this.NKq.field_username;
    String str1;
    if (this.NKs)
    {
      str1 = ca.VGy;
      if (!this.NKr) {
        break label124;
      }
    }
    label124:
    for (int i = 1;; i = 0)
    {
      s.b(str2, str1, i, 6, MMApplicationContext.getContext().getString(b.g.voip_callfrom_ignore_msg));
      gxW();
      Bl(4108);
      if (this.ntw != null) {
        this.ntw.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(241331);
            NewVoipMgr.G(NewVoipMgr.this);
            AppMethodBeat.o(241331);
          }
        }, 2000L);
      }
      AppMethodBeat.o(242433);
      return;
      str1 = ca.VGx;
      break;
    }
  }
  
  public final void kM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242339);
    if (this.NKj != null)
    {
      this.NKj.onOrientationChange(paramInt1);
      if (this.NKF != paramInt2)
      {
        this.NKF = paramInt2;
        this.NKj.alO(paramInt2);
      }
    }
    AppMethodBeat.o(242339);
  }
  
  public final void kN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(242386);
    Log.i("MicroMsg.Voip.NewVoipMgr", "adjustHWViewAspectRatio, HWDecsize:%dx%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.NKW = paramInt1;
    this.NKX = paramInt2;
    if (this.NKj != null) {
      this.NKj.kN(paramInt1, paramInt2);
    }
    AppMethodBeat.o(242386);
  }
  
  public final void onConnected()
  {
    AppMethodBeat.i(242363);
    Bl(4102);
    this.NKx = Util.nowSecond();
    com.tencent.mm.plugin.voip.c.gxs().NKx = this.NKx;
    com.tencent.mm.plugin.voip.c.a(this.NKs, this.NKr, this.NKx, this.iSn);
    if (this.NKk != null) {
      this.NKk.setConnectSec(this.NKx);
    }
    boolean bool1 = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.gyK();
    boolean bool2 = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.gyJ();
    if ((this.NKs) && (this.NKr) && (!bool2) && (!bool1)) {
      com.tencent.mm.plugin.voip.c.gxs().akP(1);
    }
    if (!com.tencent.mm.plugin.voip.c.k.alD(this.NKi.mState)) {
      com.tencent.mm.plugin.report.service.h.IzE.a(11080, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
    }
    Util.shake(MMApplicationContext.getContext(), true);
    com.tencent.mm.plugin.voip.c.gxs().ala(com.tencent.mm.plugin.voip.c.gxs().gAD());
    r.gzC().gzD();
    r.gzC().a(this);
    k localk = k.NLD;
    k.setRoomId(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId);
    AppMethodBeat.o(242363);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(242353);
    this.NKh.Bi(this.NKs);
    String str1 = paramString;
    if (paramInt == 241)
    {
      str1 = paramString;
      if (Util.isNullOrNil(paramString)) {
        str1 = getContext().getString(b.g.voip_overload_protection_default_wording);
      }
    }
    if (this.NKk != null) {
      this.NKk.cG(paramInt, str1);
    }
    paramString = com.tencent.mm.plugin.voip.b.a.NTi;
    com.tencent.mm.plugin.voip.b.a.a(a.a.NTn);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onError, errCode: %s, roomId: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId) });
    if (com.tencent.mm.plugin.voip.c.k.alC(this.NKi.mState))
    {
      paramString = MMApplicationContext.getContext().getString(b.g.voip_on_error_shutdown, new Object[] { GN(Util.secondsToNow(this.NKx)) });
      Bl(4109);
      if ((com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId == 0) || (com.tencent.mm.plugin.voip.c.gxs().NPm.get(Integer.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId)) != null)) {
        break label484;
      }
      str2 = this.NKq.field_username;
      if (!this.NKs) {
        break label471;
      }
      str1 = ca.VGy;
      if (!this.NKr) {
        break label479;
      }
      paramInt = 1;
      if (com.tencent.mm.plugin.voip.c.k.alC(this.NKi.mState)) {
        paramString = MMApplicationContext.getContext().getString(b.g.voip_call_msg_chat_time_interrupt_by_err, new Object[] { GN(Util.secondsToNow(this.NKx)) });
      }
      l = s.a(str2, str1, paramInt, 6, paramString, true);
      com.tencent.mm.plugin.voip.c.gxs().NPm.put(Integer.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId), Long.valueOf(l));
    }
    label471:
    label479:
    label484:
    while (com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId != 0) {
      for (;;)
      {
        long l;
        com.tencent.mm.plugin.voip.c.gxs().gAE();
        gyb();
        AppMethodBeat.o(242353);
        return;
        paramString = MMApplicationContext.getContext();
        Log.d("MicroMsg.Voip.NewVoipMgr", "getErrorMsgContent, errorCode".concat(String.valueOf(paramInt)));
        if (paramInt == 235)
        {
          paramString = paramString.getString(b.g.voip_callout_error_msg_unsupport);
          break;
        }
        if (paramInt == 233)
        {
          paramString = paramString.getString(b.g.voip_call_fail);
          break;
        }
        if (paramInt == 237)
        {
          paramString = paramString.getString(b.g.voip_callout_error_msg_unsupport);
          break;
        }
        if (paramInt == 236)
        {
          paramString = paramString.getString(b.g.voip_call_fail);
          break;
        }
        if (paramInt == 211)
        {
          paramString = paramString.getString(b.g.voip_callout_error_msg_busy);
          break;
        }
        paramString = paramString.getString(b.g.voip_call_connection_failed);
        break;
        str1 = ca.VGx;
        continue;
        paramInt = 0;
      }
    }
    String str2 = this.NKq.field_username;
    if (this.NKs)
    {
      str1 = ca.VGy;
      label523:
      if (!this.NKr) {
        break label596;
      }
    }
    label596:
    for (paramInt = 1;; paramInt = 0)
    {
      if (com.tencent.mm.plugin.voip.c.k.alC(this.NKi.mState)) {
        paramString = MMApplicationContext.getContext().getString(b.g.voip_call_msg_chat_time_interrupt_by_err, new Object[] { GN(Util.secondsToNow(this.NKx)) });
      }
      s.a(str2, str1, paramInt, 6, paramString, true);
      break;
      str1 = ca.VGx;
      break label523;
    }
  }
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture) {}
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(242384);
    this.NKN = paramInt;
    if (this.NKj != null)
    {
      this.NKj.setHWDecMode(paramInt);
      if (this.NKk != null) {
        this.NKk.alj(paramInt);
      }
      if (this.NLg != null)
      {
        com.tencent.mm.plugin.voip.c.h localh = this.NLg;
        if ((paramInt & 0x1) != 0)
        {
          localh.NXP += 1L;
          AppMethodBeat.o(242384);
          return;
        }
        localh.NXQ += 1L;
      }
    }
    AppMethodBeat.o(242384);
  }
  
  public final void setSpatiotemporalDenosing(int paramInt)
  {
    AppMethodBeat.i(242382);
    Log.i("MicroMsg.Voip.NewVoipMgr", "setSpatiotemporalDenosing, isON: " + paramInt + "，mVoipUI: " + this.NKk);
    Object localObject1;
    Object localObject2;
    if (this.NKj != null)
    {
      localObject1 = this.NKj;
      Log.i("MicroMsg.VoIPRenderMgr", "setSpatiotemporalDenosing, mIsStarted:%b, isON:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.voip.video.render.k)localObject1).mIsStarted), Integer.valueOf(paramInt) });
      ((com.tencent.mm.plugin.voip.video.render.k)localObject1).NKP = paramInt;
      if ((paramInt == 1) && (!v2protocal.NQD) && (((com.tencent.mm.plugin.voip.video.render.k)localObject1).OeO != null))
      {
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.k)localObject1).OeO;
        if (localObject2 == null) {
          kotlin.g.b.p.iCn();
        }
        if (((com.tencent.mm.plugin.voip.video.camera.a.a)localObject2).gDC() != null)
        {
          localObject2 = ((com.tencent.mm.plugin.voip.video.render.k)localObject1).OeO;
          if (localObject2 == null) {
            kotlin.g.b.p.iCn();
          }
          localObject2 = ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject2).gDC();
          if (localObject2 == null) {
            break label304;
          }
          i = ((ad)localObject2).width;
          if (i < 1280)
          {
            localObject2 = ((com.tencent.mm.plugin.voip.video.render.k)localObject1).OeO;
            if (localObject2 == null) {
              kotlin.g.b.p.iCn();
            }
            localObject2 = ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject2).gDC();
            if (localObject2 == null) {
              break label309;
            }
          }
        }
      }
    }
    label304:
    label309:
    for (int i = ((ad)localObject2).height;; i = 0)
    {
      if (i >= 1280)
      {
        ((com.tencent.mm.plugin.voip.video.render.k)localObject1).NKP = 0;
        Log.i("MicroMsg.VoIPRenderMgr", "The default capturing resolution is 720p, but the 720p capturing is not enabled, close the stFiter");
      }
      localObject2 = com.tencent.mm.plugin.voip.b.a.NTi;
      com.tencent.mm.plugin.voip.b.a.arD(paramInt);
      ((com.tencent.mm.plugin.voip.video.render.k)localObject1).onOrientationChange(((com.tencent.mm.plugin.voip.video.render.k)localObject1).nrf);
      localObject2 = ((com.tencent.mm.plugin.voip.video.render.k)localObject1).OeR;
      if (localObject2 != null)
      {
        i = ((com.tencent.mm.plugin.voip.video.render.k)localObject1).NKP;
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.p)localObject2).Oga;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.h)localObject2).alN(i);
        }
      }
      ((com.tencent.mm.plugin.voip.video.render.k)localObject1).alO(((com.tencent.mm.plugin.voip.video.render.k)localObject1).NZg);
      if (this.NKk != null) {
        localObject1 = this.NKk;
      }
      this.NKP = paramInt;
      AppMethodBeat.o(242382);
      return;
      i = 0;
      break;
    }
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    long l = 0L;
    AppMethodBeat.i(242342);
    Object localObject;
    if (paramInt != 2)
    {
      this.NKh.gCl();
      localObject = com.tencent.mm.plugin.voip.b.a.NTi;
      localObject = com.tencent.mm.plugin.voip.b.a.gBF();
      if (com.tencent.mm.plugin.voip.c.gxs().NKx != 0L) {
        break label107;
      }
    }
    for (;;)
    {
      ((ArrayList)localObject).add(new kotlin.o(Integer.valueOf(paramInt), Long.valueOf(l)));
      this.NKw = paramInt;
      AppMethodBeat.o(242342);
      return;
      if ((this.NKw == 2) || (com.tencent.mm.plugin.voip.c.k.alD(this.NKi.mState))) {
        break;
      }
      getContext();
      gyp();
      break;
      label107:
      l = Util.ticksToNow(com.tencent.mm.plugin.voip.c.gxs().NKx);
    }
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(242379);
    Log.i("MicroMsg.Voip.NewVoipMgr", "setVoIPBeauty, isON: " + paramInt + "，mVoipUI: " + this.NKk);
    if (this.NKj != null)
    {
      com.tencent.mm.plugin.voip.video.render.k localk = this.NKj;
      Log.i("MicroMsg.VoIPRenderMgr", "setVoIPBeauty, mIsStarted:%b, isON:%d", new Object[] { Boolean.valueOf(localk.mIsStarted), Integer.valueOf(paramInt) });
      localk.NKO = paramInt;
      Object localObject = com.tencent.mm.plugin.voip.b.a.NTi;
      com.tencent.mm.plugin.voip.b.a.alR(paramInt);
      localObject = localk.OeR;
      if (localObject != null)
      {
        int i = localk.NKO;
        localObject = ((com.tencent.mm.plugin.voip.video.render.p)localObject).Oga;
        if (localObject != null) {
          ((com.tencent.mm.plugin.voip.video.render.h)localObject).alM(i);
        }
      }
      localk.onOrientationChange(localk.nrf);
      localk.alO(localk.NZg);
    }
    if (this.NKk != null) {
      this.NKk.alk(paramInt);
    }
    if ((paramInt != 0) && (this.NKO != paramInt)) {
      com.tencent.mm.plugin.report.service.h.IzE.p(914L, 20L, 1L);
    }
    this.NKO = paramInt;
    AppMethodBeat.o(242379);
  }
  
  public final void tn(boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(242399);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onBadNetStatus");
    if (this.NKk != null) {
      this.NKk.Ba(paramBoolean);
    }
    long l;
    if ((!com.tencent.mm.plugin.voip.c.k.alD(this.NKi.mState)) && (!this.NKh.crl()))
    {
      l = System.currentTimeMillis();
      if (l - this.DQv > 30000L)
      {
        this.DQv = l;
        com.tencent.mm.plugin.voip.c.gxs().akY(b.f.close_lower_volume);
      }
    }
    Object localObject = new StringBuilder("report the bad net toast room key is ").append(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ).append("and in the side");
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      Log.i("MicroMsg.Voip.NewVoipMgr", i);
      localObject = com.tencent.mm.plugin.report.service.h.IzE;
      l = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ;
      i = j;
      if (paramBoolean) {
        i = 1;
      }
      ((com.tencent.mm.plugin.report.service.h)localObject).a(17151, true, true, new Object[] { Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(242399);
      return;
    }
  }
  
  public final void uy(boolean paramBoolean)
  {
    AppMethodBeat.i(242293);
    this.NKh.Bh(paramBoolean);
    AppMethodBeat.o(242293);
  }
  
  public class NetChangedBroadcastReceiver
    extends BroadcastReceiver
  {
    public NetChangedBroadcastReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int j = 0;
      int i = 0;
      AppMethodBeat.i(238186);
      if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
      {
        switch (com.tencent.mm.plugin.voip.c.e.getNetType(paramContext))
        {
        }
        int k;
        do
        {
          do
          {
            do
            {
              do
              {
                AppMethodBeat.o(238186);
                return;
              } while (NewVoipMgr.i(NewVoipMgr.this) == 5);
              j = NewVoipMgr.gyq()[1];
              if (NewVoipMgr.j(NewVoipMgr.this) == 0) {
                NewVoipMgr.a(NewVoipMgr.this, 4);
              }
            } while (NewVoipMgr.j(NewVoipMgr.this) == 0);
            k = NewVoipMgr.gyr() / NewVoipMgr.j(NewVoipMgr.this);
            NewVoipMgr.a(NewVoipMgr.this, 5);
            m = NewVoipMgr.gyq()[0];
            Log.i("MicroMsg.Voip.NewVoipMgr", "befor change to 4G and cost " + NewVoipMgr.k(NewVoipMgr.this));
            if (NewVoipMgr.e(NewVoipMgr.this)) {}
            for (;;)
            {
              com.tencent.mm.plugin.voip.c.e.a(i, System.currentTimeMillis(), NewVoipMgr.i(NewVoipMgr.this), 5, j, m, k);
              NewVoipMgr.l(NewVoipMgr.this);
              NewVoipMgr.b(NewVoipMgr.this, 5);
              NewVoipMgr.gys();
              NewVoipMgr.m(NewVoipMgr.this);
              AppMethodBeat.o(238186);
              return;
              i = 1;
            }
          } while (NewVoipMgr.i(NewVoipMgr.this) == 4);
          k = NewVoipMgr.gyq()[0];
          if (NewVoipMgr.j(NewVoipMgr.this) == 0) {
            NewVoipMgr.a(NewVoipMgr.this, 5);
          }
        } while (NewVoipMgr.j(NewVoipMgr.this) == 0);
        int m = NewVoipMgr.gyr() / NewVoipMgr.j(NewVoipMgr.this);
        NewVoipMgr.a(NewVoipMgr.this, 4);
        int n = NewVoipMgr.gyq()[1];
        Log.i("MicroMsg.Voip.NewVoipMgr", "befor change to wifi and cost " + NewVoipMgr.k(NewVoipMgr.this));
        if (NewVoipMgr.e(NewVoipMgr.this)) {}
        for (i = j;; i = 1)
        {
          com.tencent.mm.plugin.voip.c.e.a(i, System.currentTimeMillis(), NewVoipMgr.i(NewVoipMgr.this), 4, k, n, m);
          NewVoipMgr.l(NewVoipMgr.this);
          NewVoipMgr.b(NewVoipMgr.this, 4);
          NewVoipMgr.gys();
          NewVoipMgr.m(NewVoipMgr.this);
          break;
        }
      }
      if ((paramIntent.getAction().equals("android.net.wifi.STATE_CHANGE")) && (NewVoipMgr.n(NewVoipMgr.this) == 0L))
      {
        NewVoipMgr.a(NewVoipMgr.this, System.currentTimeMillis());
        AppMethodBeat.o(238186);
        return;
      }
      if ((paramIntent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) && (NewVoipMgr.n(NewVoipMgr.this) != 0L))
      {
        NewVoipMgr.b(NewVoipMgr.this, System.currentTimeMillis() - NewVoipMgr.n(NewVoipMgr.this));
        NewVoipMgr.a(NewVoipMgr.this, 0L);
      }
      AppMethodBeat.o(238186);
    }
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(241561);
      NewVoipMgr.r(NewVoipMgr.this);
      NewVoipMgr.s(NewVoipMgr.this);
      AppMethodBeat.o(241561);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.NewVoipMgr
 * JD-Core Version:    0.7.0.1
 */