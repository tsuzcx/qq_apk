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
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.PowerManager;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.g.a.aaq;
import com.tencent.mm.g.a.aaq.a;
import com.tencent.mm.g.a.zi;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.voip.ui.VoipScoreDialog;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView.b;
import com.tencent.mm.plugin.voip.video.render.j.b;
import com.tencent.mm.plugin.voip.video.render.j.c;
import com.tencent.mm.plugin.voip.video.render.j.d;
import com.tencent.mm.plugin.voip.video.render.j.e;
import com.tencent.mm.plugin.voip.video.render.j.f;
import com.tencent.mm.plugin.voip.video.render.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
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
import kotlin.g.b.p;

public final class NewVoipMgr
  extends com.tencent.mm.plugin.voip.a
  implements com.tencent.mm.plugin.voip.video.render.c
{
  static int[] GUR = new int[2];
  static int mHZ = 0;
  private com.tencent.mm.plugin.voip.b.b GTV;
  private com.tencent.mm.plugin.voip.b.l GTW;
  private com.tencent.mm.plugin.voip.video.render.j GTX;
  private volatile com.tencent.mm.plugin.voip.ui.b GTY;
  private a GTZ;
  private boolean GUA;
  public int GUB;
  public int GUC;
  public int GUD;
  private long GUE;
  private long GUF;
  private int GUG;
  boolean GUH;
  boolean GUI;
  private int GUJ;
  public int GUK;
  public int GUL;
  int GUM;
  boolean GUN;
  NetChangedBroadcastReceiver GUO;
  PhoneStateListener GUP;
  MMHandler GUQ;
  private long GUS;
  private boolean GUT;
  private com.tencent.mm.plugin.voip.b.h GUU;
  private BroadcastReceiver GUV;
  int GUW;
  private IListener GUX;
  private boolean GUa;
  private boolean GUb;
  private boolean GUc;
  private Object GUd;
  private as GUe;
  boolean GUf;
  private boolean GUg;
  private boolean GUh;
  private int GUi;
  private boolean GUj;
  private int GUk;
  private long GUl;
  private int GUm;
  private com.tencent.mm.plugin.voip.video.f GUn;
  private MTimerHandler GUo;
  private boolean GUp;
  private boolean GUq;
  private int GUr;
  private boolean GUs;
  private int GUt;
  private boolean GUu;
  private com.tencent.mm.plugin.voip.widget.b GUv;
  private boolean GUw;
  private boolean GUx;
  private String GUy;
  private boolean GUz;
  private long enterTime;
  private String goe;
  private long iGC;
  private MMHandler kAn;
  private int mUIType;
  PhoneStateListener mtH;
  TelephonyManager qtS;
  private long wNg;
  private TelephonyManager yoi;
  private IListener yok;
  private long yqt;
  private boolean zuc;
  
  public NewVoipMgr()
  {
    AppMethodBeat.i(235514);
    this.GTZ = null;
    this.GUa = true;
    this.GUb = false;
    this.GUc = false;
    this.GUd = new Object();
    this.GUh = false;
    this.GUi = 4096;
    this.GUj = false;
    this.GUk = -1;
    this.GUl = -1L;
    this.zuc = false;
    this.GUm = 0;
    this.GUn = new com.tencent.mm.plugin.voip.video.f();
    this.GUo = null;
    this.GUp = false;
    this.GUq = false;
    this.GUr = 0;
    this.GUs = false;
    this.GUt = -1;
    this.GUu = false;
    this.GUw = false;
    this.GUx = false;
    this.GUy = null;
    this.GUz = true;
    this.GUA = false;
    this.GUB = -1;
    this.GUC = 0;
    this.GUD = 0;
    this.GUE = 0L;
    this.GUF = 0L;
    this.GUG = 0;
    this.GUH = false;
    this.GUI = false;
    this.GUJ = 0;
    this.GUK = 0;
    this.GUL = 0;
    this.GUM = 0;
    this.GUN = false;
    this.GUQ = new MMHandler("getSignalStrength");
    this.qtS = null;
    this.wNg = 0L;
    this.GUS = 0L;
    this.GUT = false;
    this.GUV = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(235485);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        paramAnonymousIntent = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
        if (("android.intent.action.USER_PRESENT".equals(paramAnonymousContext)) && (paramAnonymousIntent.isScreenOn()))
        {
          if (NewVoipMgr.a(NewVoipMgr.this) != null)
          {
            NewVoipMgr.a(NewVoipMgr.this).GYb = false;
            AppMethodBeat.o(235485);
          }
        }
        else
        {
          if ("android.intent.action.SCREEN_ON".equals(paramAnonymousContext))
          {
            if (NewVoipMgr.a(NewVoipMgr.this) != null) {
              NewVoipMgr.a(NewVoipMgr.this).GYb = false;
            }
            NewVoipMgr.b(NewVoipMgr.this).onSensorEvent(true);
            AppMethodBeat.o(235485);
            return;
          }
          if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousContext))
          {
            if (NewVoipMgr.a(NewVoipMgr.this) != null) {
              NewVoipMgr.a(NewVoipMgr.this).GYb = true;
            }
            if (!NewVoipMgr.c(NewVoipMgr.this)) {
              NewVoipMgr.b(NewVoipMgr.this).onSensorEvent(true);
            }
            if ((!com.tencent.mm.plugin.voip.b.k.adP(NewVoipMgr.d(NewVoipMgr.this).mState)) && (!NewVoipMgr.e(NewVoipMgr.this))) {
              com.tencent.mm.plugin.voip.c.fFg().GYS.stopRing();
            }
          }
        }
        AppMethodBeat.o(235485);
      }
    };
    this.yok = new IListener() {};
    this.GUW = 0;
    this.yqt = 0L;
    this.mtH = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        int i = 1;
        AppMethodBeat.i(235511);
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        Log.i("MicroMsg.Voip.NewVoipMgr", "onCallStateChanged :%d, isStartVoip: %b,oldState:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(NewVoipMgr.t(NewVoipMgr.this)), Integer.valueOf(NewVoipMgr.u(NewVoipMgr.this)) });
        if (!NewVoipMgr.t(NewVoipMgr.this))
        {
          AppMethodBeat.o(235511);
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
          com.tencent.mm.plugin.voip.c.fFg().adh(1);
          NewVoipMgr.b(NewVoipMgr.this, true);
        }
        label327:
        label361:
        do
        {
          NewVoipMgr.b(NewVoipMgr.this).GUT = NewVoipMgr.C(NewVoipMgr.this);
          AppMethodBeat.o(235511);
          return;
          if (paramAnonymousInt == 2)
          {
            NewVoipMgr.a(NewVoipMgr.this, false);
            if (NewVoipMgr.u(NewVoipMgr.this) == 1) {
              NewVoipMgr.d(NewVoipMgr.this, System.currentTimeMillis());
            }
            NewVoipMgr.c(NewVoipMgr.this, 2);
            Log.i("MicroMsg.Voip.NewVoipMgr", "phone call coming now!");
            if ((NewVoipMgr.e(NewVoipMgr.this)) && (!com.tencent.mm.plugin.voip.b.k.adP(NewVoipMgr.d(NewVoipMgr.this).mState))) {
              com.tencent.mm.plugin.voip.c.fFg().GYS.fIv();
            }
            String str2;
            String str1;
            if (com.tencent.mm.plugin.voip.b.k.adP(NewVoipMgr.d(NewVoipMgr.this).mState))
            {
              paramAnonymousString = MMApplicationContext.getContext().getString(2131767241, new Object[] { NewVoipMgr.Lg(Util.secondsToNow(NewVoipMgr.w(NewVoipMgr.this))) });
              com.tencent.mm.plugin.voip.c.fFg().fHS();
              str2 = NewVoipMgr.x(NewVoipMgr.this).field_username;
              if (!NewVoipMgr.g(NewVoipMgr.this)) {
                break label596;
              }
              str1 = ca.OqC;
              if (!NewVoipMgr.e(NewVoipMgr.this)) {
                break label604;
              }
            }
            for (paramAnonymousInt = i;; paramAnonymousInt = 0)
            {
              s.c(str2, str1, paramAnonymousInt, 6, paramAnonymousString);
              NewVoipMgr.d(NewVoipMgr.this, 4107);
              NewVoipMgr.y(NewVoipMgr.this);
              paramAnonymousString = new ca();
              paramAnonymousString.setType(10000);
              paramAnonymousString.setCreateTime(System.currentTimeMillis());
              paramAnonymousString.setStatus(6);
              paramAnonymousString.setContent(MMApplicationContext.getContext().getString(2131767239) + ", <a href=\"weixin://voip/callagain/?username=" + NewVoipMgr.f(NewVoipMgr.this) + "&isvideocall=" + NewVoipMgr.g(NewVoipMgr.this) + "\">" + MMApplicationContext.getContext().getString(2131767234) + "</a>");
              if ((NewVoipMgr.f(NewVoipMgr.this) != null) && (!NewVoipMgr.f(NewVoipMgr.this).equals("")))
              {
                paramAnonymousString.Cy(NewVoipMgr.f(NewVoipMgr.this));
                ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(paramAnonymousString);
              }
              com.tencent.mm.plugin.voip.c.fFg().adh(2);
              NewVoipMgr.b(NewVoipMgr.this, false);
              break;
              paramAnonymousString = MMApplicationContext.getContext().getString(2131767237);
              break label327;
              str1 = ca.OqB;
              break label361;
            }
          }
        } while (paramAnonymousInt != 0);
        label596:
        label604:
        if ((NewVoipMgr.u(NewVoipMgr.this) == 1) || (NewVoipMgr.u(NewVoipMgr.this) == 2)) {
          NewVoipMgr.d(NewVoipMgr.this, System.currentTimeMillis());
        }
        NewVoipMgr.c(NewVoipMgr.this, 0);
        com.tencent.mm.plugin.voip.c.fFg().adh(2);
        if ((1 == NewVoipMgr.z(NewVoipMgr.this)) && (com.tencent.mm.plugin.voip.b.k.adP(NewVoipMgr.d(NewVoipMgr.this).mState)) && (NewVoipMgr.A(NewVoipMgr.this))) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(235507);
              NewVoipMgr.b(NewVoipMgr.this).cV(true);
              AppMethodBeat.o(235507);
            }
          });
        }
        if ((4 == NewVoipMgr.z(NewVoipMgr.this)) && (NewVoipMgr.A(NewVoipMgr.this))) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(235508);
              NewVoipMgr.b(NewVoipMgr.this).aM(NewVoipMgr.B(NewVoipMgr.this), NewVoipMgr.g(NewVoipMgr.this));
              AppMethodBeat.o(235508);
            }
          });
        }
        NewVoipMgr.a(NewVoipMgr.this, false);
        if ((com.tencent.mm.compatible.b.g.anF() != null) && (com.tencent.mm.plugin.audio.c.a.cea().isBluetoothScoOn()))
        {
          Log.i("MicroMsg.Voip.NewVoipMgr", "is bluetooth can use and start bluetooth");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(235509);
              NewVoipMgr.b(NewVoipMgr.this).aM(NewVoipMgr.B(NewVoipMgr.this), NewVoipMgr.g(NewVoipMgr.this));
              AppMethodBeat.o(235509);
            }
          });
        }
        for (;;)
        {
          NewVoipMgr.b(NewVoipMgr.this, false);
          break;
          if (com.tencent.mm.plugin.audio.c.a.cea().cdW()) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(235510);
                NewVoipMgr.b(NewVoipMgr.this).aM(NewVoipMgr.B(NewVoipMgr.this), NewVoipMgr.g(NewVoipMgr.this));
                AppMethodBeat.o(235510);
              }
            });
          }
        }
      }
    };
    this.iGC = -1L;
    this.enterTime = -1L;
    this.GUX = new IListener() {};
    this.GTV = new com.tencent.mm.plugin.voip.b.b();
    AppMethodBeat.o(235514);
  }
  
  private static String AF(long paramLong)
  {
    AppMethodBeat.i(235579);
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
    AppMethodBeat.o(235579);
    return str;
  }
  
  private void acN(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(235537);
    Log.i("MicroMsg.Voip.NewVoipMgr", "hangupTalkingOrCancelInvite");
    if (true == fFW()) {
      this.GUi = paramInt;
    }
    Object localObject = MMApplicationContext.getContext();
    String str2;
    if (com.tencent.mm.plugin.voip.b.k.adP(this.GTW.mState))
    {
      localObject = ((Context)localObject).getString(2131767241, new Object[] { AF(Util.secondsToNow(this.GUl)) });
      str2 = this.GUe.field_username;
      if (!this.GUg) {
        break label251;
      }
    }
    label251:
    for (String str1 = ca.OqC;; str1 = ca.OqB)
    {
      if (this.GUf) {
        i = 1;
      }
      s.c(str2, str1, i, 6, (String)localObject);
      if ((!this.GUf) || (com.tencent.mm.plugin.voip.b.k.adP(this.GTW.mState))) {
        break label259;
      }
      fFK();
      if ((this.GUf) && (!com.tencent.mm.plugin.voip.b.k.adP(this.GTW.mState)))
      {
        Log.i("MicroMsg.Voip.NewVoipMgr", "hangupVoipButton OnClick call cancelCall");
        com.tencent.mm.plugin.voip.c.fFg().GYS.fIu();
      }
      Log.i("MicroMsg.Voip.NewVoipMgr", "hangupVoipButton OnClick call hangUp");
      com.tencent.mm.plugin.voip.c.fFg().GYS.fIx();
      if (4096 != this.GUi) {
        break label315;
      }
      xN(paramInt);
      fFP();
      AppMethodBeat.o(235537);
      return;
      if (this.GUf)
      {
        localObject = ((Context)localObject).getString(2131767236);
        break;
      }
      localObject = ((Context)localObject).getString(2131767235);
      break;
    }
    label259:
    com.tencent.f.h.RTc.aX(new com.tencent.f.i.h()
    {
      public final String getKey()
      {
        return "VoipMgr_play_end_sound";
      }
      
      public final void run()
      {
        AppMethodBeat.i(235503);
        NewVoipMgr.b(NewVoipMgr.this).xq(NewVoipMgr.g(NewVoipMgr.this));
        AppMethodBeat.o(235503);
      }
    });
    this.GUb = true;
    this.GUc = true;
    com.tencent.mm.plugin.voip.c.fFg().GYS.fIx();
    if (4096 == this.GUi)
    {
      xN(paramInt);
      fFP();
    }
    label315:
    AppMethodBeat.o(235537);
  }
  
  private boolean acO(int paramInt)
  {
    AppMethodBeat.i(235556);
    if (4111 == paramInt)
    {
      AppMethodBeat.o(235556);
      return true;
    }
    if ((4101 == paramInt) && ((com.tencent.mm.plugin.voip.b.k.adP(this.GTW.mState)) || (this.GUf)))
    {
      AppMethodBeat.o(235556);
      return true;
    }
    AppMethodBeat.o(235556);
    return false;
  }
  
  private static void acP(int paramInt)
  {
    AppMethodBeat.i(235557);
    aaq localaaq = new aaq();
    localaaq.ehD.dDe = paramInt;
    EventCenter.instance.publish(localaaq);
    AppMethodBeat.o(235557);
  }
  
  private boolean c(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(235585);
    String str = com.tencent.mm.n.h.aqJ().getValue("VOIPShortcutAutoadd");
    Log.i("MicroMsg.Voip.NewVoipMgr", "voip shortcut autoAdd is %s", new Object[] { str });
    if ((str != null) && (str.equals("0")) && (Util.secondsToNow(this.GUl) > 30L))
    {
      int i = paramSharedPreferences.getInt("voip_shortcut_prompt_times", 0);
      boolean bool = paramSharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
      if ((i < 3) && (!bool))
      {
        fFX();
        paramSharedPreferences.edit().putInt("voip_shortcut_prompt_times", i + 1).commit();
        AppMethodBeat.o(235585);
        return true;
      }
    }
    else if ((str != null) && (str.equals("1")) && (Util.secondsToNow(this.GUl) > 15L))
    {
      d(paramSharedPreferences);
      AppMethodBeat.o(235585);
      return false;
    }
    AppMethodBeat.o(235585);
    return false;
  }
  
  private void d(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(235586);
    Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
    localIntent1.putExtra("duplicate", false);
    Intent localIntent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
    localIntent2.addFlags(67108864);
    if (1 == Util.getInt(com.tencent.mm.n.h.aqJ().getValue("VOIPCallType"), 0))
    {
      localIntent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(2131755840));
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getContext(), 2131235522));
      localIntent1.putExtra("shortcut_icon_resource_id", 2131235522);
    }
    for (;;)
    {
      localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
      com.tencent.mm.plugin.base.model.b.p(getContext(), localIntent1);
      paramSharedPreferences.edit().putBoolean("voip_shortcut_has_added", true).commit();
      AppMethodBeat.o(235586);
      return;
      localIntent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(2131755842));
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getContext(), 2131235561));
      localIntent1.putExtra("shortcut_icon_resource_id", 2131235561);
    }
  }
  
  private boolean fFN()
  {
    int j = 0;
    AppMethodBeat.i(235552);
    if (!this.GTW.adT(4101))
    {
      AppMethodBeat.o(235552);
      return false;
    }
    this.GUg = false;
    if (this.GUv != null) {
      this.GUv.GUg = false;
    }
    xN(4101);
    Object localObject1;
    int k;
    int i;
    Object localObject3;
    Object localObject2;
    if ((261 == this.GTW.mState) || (7 == this.GTW.mState))
    {
      com.tencent.mm.plugin.voip.c.fFg().adf(1);
      localObject1 = com.tencent.mm.plugin.report.service.h.CyF;
      long l = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH;
      k = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId;
      if (this.GUf)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject1).a(11046, new Object[] { Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(k), Integer.valueOf(0), Integer.valueOf(i) });
        localObject3 = com.tencent.mm.plugin.report.service.h.CyF;
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
        com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGz();
        com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGA();
        AppMethodBeat.o(235552);
        return true;
        i = 0;
        break;
      } while ((1 != this.GTW.mState) && (3 != this.GTW.mState));
      com.tencent.mm.plugin.voip.c.fFg().adf(1);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
      k = 11046;
      localObject1 = new Object[5];
      localObject1[0] = Integer.valueOf(1);
      localObject1[1] = Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH);
      localObject1[2] = Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId);
      localObject1[3] = Integer.valueOf(0);
      i = 4;
      if (this.GUf)
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
  
  private void fFP()
  {
    AppMethodBeat.i(235562);
    Log.d("MicroMsg.Voip.NewVoipMgr", "delayFinish");
    this.GUy = null;
    if (this.kAn != null) {
      this.kAn.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(235505);
          NewVoipMgr localNewVoipMgr = NewVoipMgr.this;
          Log.i("MicroMsg.Voip.NewVoipMgr", "it is uninit voip report");
          if (localNewVoipMgr.GUQ != null)
          {
            localNewVoipMgr.GUQ.removeCallbacksAndMessages(null);
            localNewVoipMgr.GUQ.quit();
          }
          if (!localNewVoipMgr.GUN)
          {
            if (localNewVoipMgr.GUW == 0) {
              localNewVoipMgr.acM(localNewVoipMgr.GUM);
            }
            if (localNewVoipMgr.GUW != 0)
            {
              localNewVoipMgr.GUN = true;
              if (!localNewVoipMgr.GUf) {
                break label262;
              }
            }
          }
          label262:
          for (int i = 0;; i = 1)
          {
            com.tencent.mm.plugin.voip.b.e.a(i, System.currentTimeMillis(), localNewVoipMgr.GUM, localNewVoipMgr.GUM, 0, 0, NewVoipMgr.mHZ / localNewVoipMgr.GUW);
            NewVoipMgr.mHZ = 0;
            NewVoipMgr.GUR[0] = 0;
            NewVoipMgr.GUR[1] = 0;
            localNewVoipMgr.GUW = 0;
            if (localNewVoipMgr.qtS != null)
            {
              TelephonyManager localTelephonyManager = localNewVoipMgr.qtS;
              Object localObject = localNewVoipMgr.GUP;
              localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/voip/model/NewVoipMgr", "uninitVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
              localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(1)).intValue());
              com.tencent.mm.hellhoundlib.a.a.a(localTelephonyManager, "com/tencent/mm/plugin/voip/model/NewVoipMgr", "uninitVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            }
            if (localNewVoipMgr.GUO != null)
            {
              MMApplicationContext.getContext().unregisterReceiver(localNewVoipMgr.GUO);
              localNewVoipMgr.GUO = null;
            }
            NewVoipMgr.p(NewVoipMgr.this);
            AppMethodBeat.o(235505);
            return;
          }
        }
      }, 500L);
    }
    AppMethodBeat.o(235562);
  }
  
  private static void fFQ()
  {
    AppMethodBeat.i(235564);
    zj localzj = new zj();
    localzj.efx.dKy = 11;
    EventCenter.instance.publish(localzj);
    AppMethodBeat.o(235564);
  }
  
  private void fFV()
  {
    AppMethodBeat.i(235580);
    synchronized (this.GUd)
    {
      fGb();
      if (this.GTX != null) {
        this.GTX.release();
      }
      this.GTV.unInit();
      this.GTV.fFV();
      AppMethodBeat.o(235580);
      return;
    }
  }
  
  private boolean fFW()
  {
    AppMethodBeat.i(235584);
    if (com.tencent.mm.plugin.voip.b.k.adP(this.GTW.mState))
    {
      SharedPreferences localSharedPreferences = getContext().getSharedPreferences("voip_plugin_prefs", 0);
      if (!localSharedPreferences.getBoolean("voip_shortcut_has_added", false))
      {
        boolean bool = c(localSharedPreferences);
        AppMethodBeat.o(235584);
        return bool;
      }
    }
    AppMethodBeat.o(235584);
    return false;
  }
  
  private void fFX()
  {
    AppMethodBeat.i(235588);
    Context localContext = getContext();
    View localView = View.inflate(localContext, 2131495497, null);
    final CheckBox localCheckBox = (CheckBox)localView.findViewById(2131304698);
    localCheckBox.setChecked(false);
    TextView localTextView = (TextView)localView.findViewById(2131304700);
    if (1 == Util.getInt(com.tencent.mm.n.h.aqJ().getValue("VOIPCallType"), 0)) {
      localTextView.setText(2131767223);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(localContext, false, localContext.getString(2131755998), localView, localContext.getString(2131756033), localContext.getString(2131755917), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(235487);
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
                AppMethodBeat.i(235486);
                NewVoipMgr.p(NewVoipMgr.this);
                AppMethodBeat.o(235486);
              }
            });
          }
          AppMethodBeat.o(235487);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(235489);
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
                AppMethodBeat.i(235488);
                NewVoipMgr.p(NewVoipMgr.this);
                AppMethodBeat.o(235488);
              }
            });
          }
          AppMethodBeat.o(235489);
        }
      });
      AppMethodBeat.o(235588);
      return;
      localTextView.setText(2131767224);
    }
  }
  
  private void fGb()
  {
    AppMethodBeat.i(235593);
    if (this.GUn != null) {
      this.GUn.b(this);
    }
    if (this.GUo != null)
    {
      Log.d("MicroMsg.Voip.NewVoipMgr", "stop face detect timer");
      this.GUo.stopTimer();
    }
    AppMethodBeat.o(235593);
  }
  
  private void fGc()
  {
    AppMethodBeat.i(235595);
    this.GUx = true;
    if ((this.GUx) && (this.GUk == 2))
    {
      getContext();
      gWP();
    }
    AppMethodBeat.o(235595);
  }
  
  private void gWP()
  {
    AppMethodBeat.i(258471);
    this.GTV.Z(new kotlin.g.a.b() {});
    AppMethodBeat.o(258471);
  }
  
  private void hb(boolean paramBoolean)
  {
    AppMethodBeat.i(235563);
    Log.i("MicroMsg.Voip.NewVoipMgr", "finish");
    if (this.GUU != null) {
      this.GUU.fKp();
    }
    this.GUu = false;
    this.GUw = false;
    if (this.GUm != -1)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(11700, new Object[] { Integer.valueOf(this.GUm), Long.valueOf(Util.secondsToNow(this.GUl)) });
      this.GUm = -1;
    }
    try
    {
      MMApplicationContext.getContext().unregisterReceiver(this.GUV);
      label98:
      this.GTV.fJP();
      EventCenter.instance.removeListener(this.yok);
      EventCenter.instance.removeListener(this.GUX);
      fGb();
      if (this.GTX != null)
      {
        this.GTX.release();
        this.GTX = null;
      }
      if (this.GTY != null)
      {
        this.GTY.uninit();
        this.GTY = null;
        this.GTV.b(this.GTY);
      }
      label227:
      int j;
      label292:
      long l;
      if (com.tencent.mm.plugin.voip.c.fFg() != null)
      {
        com.tencent.mm.plugin.voip.c.fFg().GYS.stopRing();
        if (paramBoolean)
        {
          com.tencent.mm.plugin.voip.c.fFg().fHT();
          if (!this.GUg) {
            break label768;
          }
          com.tencent.mm.plugin.voip.c.fFg().d(false, true, this.goe);
          com.tencent.mm.plugin.voip.c.fFg().b(MMApplicationContext.getContext(), this);
        }
      }
      else
      {
        this.GTV.elB();
        com.tencent.mm.plugin.voip.c.fFg().fIi();
        com.tencent.mm.plugin.voip.c.fFg().adp(this.GUC);
        if (!this.GUb) {
          break label783;
        }
        this.GTZ = new a();
        com.tencent.f.h.RTc.aX(this.GTZ);
        Object localObject1;
        Object localObject2;
        if ((this.yoi != null) && (this.mtH != null))
        {
          localObject1 = this.yoi;
          localObject2 = this.mtH;
          localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
          ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(1)).intValue());
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
          this.mtH = null;
        }
        this.yoi = null;
        com.tencent.mm.booter.a.akp().akq();
        r.fHo().fHq();
        r.fHo().a(null);
        ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        com.tencent.mm.plugin.voip.c.fFg().fIl();
        Log.i("MicroMsg.Voip.NewVoipMgr", "finish, isFinishFromShutdown: %s", new Object[] { Boolean.valueOf(this.GUc) });
        if ((this.GUc) && (com.tencent.mm.plugin.voip.c.fFg().fIm()))
        {
          com.tencent.mm.plugin.voip.c.fFg();
          VoipScoreState.fHQ();
          localObject2 = new Intent(getContext(), VoipScoreDialog.class);
          ((Intent)localObject2).putExtra("key_score_state", com.tencent.mm.plugin.voip.c.fFg().fIo());
          if (!(getContext() instanceof Activity)) {
            ((Intent)localObject2).addFlags(268435456);
          }
          localObject1 = getContext();
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        com.tencent.mm.plugin.voip.c.fFg().fIn();
        fFQ();
        if (!this.GUI)
        {
          j = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId;
          l = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH;
          if (!this.GUf) {
            break label790;
          }
        }
      }
      label768:
      label783:
      label790:
      for (int i = 0;; i = 1)
      {
        com.tencent.mm.plugin.voip.b.e.c(j, l, i, 4);
        this.GUI = true;
        ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        com.tencent.mm.media.g.c.igu.aMA();
        AppMethodBeat.o(235563);
        return;
        com.tencent.mm.plugin.voip.c.fFg().GYS.fIx();
        break;
        com.tencent.mm.plugin.voip.c.fFg().d(false, false, this.goe);
        break label227;
        fFV();
        break label292;
      }
    }
    catch (Exception localException)
    {
      break label98;
    }
  }
  
  private void xN(final int paramInt)
  {
    AppMethodBeat.i(235555);
    Log.printDebugStack("MicroMsg.Voip.NewVoipMgr", "swtchState, action: %s, currentState: %s", new Object[] { com.tencent.mm.plugin.voip.b.k.adM(paramInt), com.tencent.mm.plugin.voip.b.k.adM(this.GTW.mState) });
    if ((4101 == paramInt) && (com.tencent.mm.plugin.voip.b.k.adQ(this.GTW.mState)))
    {
      fGb();
      if (this.GTX != null) {
        this.GTX.release();
      }
      this.GUg = false;
      if (this.GUv != null) {
        this.GUv.GUg = false;
      }
    }
    if (acO(paramInt)) {
      this.GTV.Hgx = false;
    }
    if ((acO(paramInt)) && (1 == this.mUIType) && (1 == this.GUk))
    {
      this.GTV.cV(false);
      fGc();
      if (!com.tencent.mm.plugin.voip.c.fFg().GYS.czl())
      {
        this.GTV.fFK();
        this.GTV.aN(false, this.GUf);
      }
      this.GTW.adU(paramInt);
      if (this.kAn != null) {
        this.kAn.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(235504);
            if (NewVoipMgr.o(NewVoipMgr.this) != null) {
              NewVoipMgr.o(NewVoipMgr.this).jD(paramInt, NewVoipMgr.d(NewVoipMgr.this).mState);
            }
            AppMethodBeat.o(235504);
          }
        });
      }
      switch (this.GTW.mState)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(235555);
      return;
      if ((4100 != paramInt) || (com.tencent.mm.plugin.voip.c.fFg().GYS.czl())) {
        break;
      }
      this.GTV.fFK();
      break;
      acP(5);
      AppMethodBeat.o(235555);
      return;
      acP(6);
    }
  }
  
  public final void a(final Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(235515);
    Log.i("MicroMsg.Voip.NewVoipMgr", "start VoIP, userName: %s, isOutCall: %b, isVideoCall: %b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.GTV.aL(paramBoolean2, paramBoolean1);
    this.GTV.fJN();
    this.GUu = true;
    this.goe = paramString;
    this.GUf = paramBoolean1;
    this.GUg = paramBoolean2;
    this.GUe = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.goe);
    this.kAn = new MMHandler(Looper.getMainLooper());
    this.GUB = 0;
    this.GUC = 0;
    this.GUD = 0;
    boolean bool1;
    int j;
    label196:
    label216:
    boolean bool2;
    if (Util.getInt(com.tencent.mm.n.h.aqJ().getValue("VOIPCameraSwitch"), 1) == 0)
    {
      bool1 = true;
      this.GUh = bool1;
      if (!this.GUg) {
        this.GUh = false;
      }
      j = com.tencent.mm.plugin.voip.b.k.aQ(paramBoolean1, paramBoolean2);
      i = j;
      if (this.GUh)
      {
        if (j != 0) {
          break label539;
        }
        i = 1;
        com.tencent.mm.plugin.voip.c.fFg().adf(1);
      }
      if (!paramBoolean1) {
        break label559;
      }
      this.GTW = com.tencent.mm.plugin.voip.b.k.adO(i);
      this.GTV.GTW = this.GTW;
      bool1 = com.tencent.mm.compatible.e.b.api();
      bool2 = com.tencent.mm.compatible.e.b.apj();
      if (Build.MANUFACTURER.equalsIgnoreCase("meizu"))
      {
        if (!bool1)
        {
          localObject1 = com.tencent.mm.plugin.report.service.h.CyF;
          if (!this.GUg) {
            break label571;
          }
          i = 0;
          label269:
          ((com.tencent.mm.plugin.report.service.h)localObject1).a(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
        }
        if (!bool2)
        {
          localObject1 = com.tencent.mm.plugin.report.service.h.CyF;
          if (!this.GUg) {
            break label577;
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
          break label583;
        }
        localObject1 = paramContext.getString(2131767361);
        localObject2 = paramContext.getString(2131767326);
        label387:
        com.tencent.mm.ui.base.h.a(paramContext, (String)localObject1, (String)localObject2, paramContext.getString(2131767329), true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(235501);
            Log.i("MicroMsg.Voip.NewVoipMgr", "show Permission settings");
            com.tencent.mm.compatible.e.b.cw(paramContext);
            if (!NewVoipMgr.e(NewVoipMgr.this))
            {
              if (NewVoipMgr.g(NewVoipMgr.this))
              {
                NewVoipMgr.this.fFv();
                AppMethodBeat.o(235501);
                return;
              }
              NewVoipMgr.this.fFy();
              AppMethodBeat.o(235501);
              return;
            }
            if (NewVoipMgr.g(NewVoipMgr.this))
            {
              NewVoipMgr.this.fFA();
              AppMethodBeat.o(235501);
              return;
            }
            NewVoipMgr.this.fFB();
            AppMethodBeat.o(235501);
          }
        });
      }
      Log.i("MicroMsg.Voip.NewVoipMgr", "initMgr");
      com.tencent.mm.booter.a.akp().akr();
      if (!this.GUg) {
        break label635;
      }
      com.tencent.mm.plugin.voip.c.fFg().d(true, true, this.goe);
      label447:
      if (!this.GUf) {
        break label668;
      }
      com.tencent.mm.plugin.voip.c.fFg().GYS.fIt();
      if (!this.GUg) {
        break label650;
      }
    }
    label650:
    for (int i = com.tencent.mm.plugin.voip.c.fFg().aUA(this.GUe.field_username);; i = com.tencent.mm.plugin.voip.c.fFg().aUz(this.GUe.field_username))
    {
      if (i >= 0) {
        break label668;
      }
      hb(false);
      i = 0;
      if (i != 0)
      {
        this.GTV.aN(paramBoolean2, paramBoolean1);
        com.tencent.mm.plugin.voip.c.fFg().e(paramString, this.GUg, paramLong);
      }
      AppMethodBeat.o(235515);
      return;
      bool1 = false;
      break;
      label539:
      i = j;
      if (256 != j) {
        break label196;
      }
      i = 257;
      break label196;
      label559:
      this.GTW = com.tencent.mm.plugin.voip.b.k.adN(i);
      break label216;
      label571:
      i = 1;
      break label269;
      label577:
      i = 1;
      break label316;
      label583:
      if (!bool1)
      {
        localObject1 = paramContext.getString(2131767363);
        localObject2 = paramContext.getString(2131767327);
        break label387;
      }
      if (bool2) {
        break label387;
      }
      localObject1 = paramContext.getString(2131767362);
      localObject2 = paramContext.getString(2131767328);
      break label387;
      label635:
      com.tencent.mm.plugin.voip.c.fFg().d(true, false, this.goe);
      break label447;
    }
    label668:
    com.tencent.mm.plugin.voip.c.fFg().a(MMApplicationContext.getContext(), this);
    this.yoi = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
    paramContext = this.yoi;
    Object localObject1 = this.mtH;
    localObject1 = com.tencent.mm.hellhoundlib.b.c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject1);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/voip/model/NewVoipMgr", "initMgr", "()Z", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    paramContext.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/voip/model/NewVoipMgr", "initMgr", "()Z", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    paramContext = "voip_recent_contact" + z.aTY();
    localObject1 = MMApplicationContext.getContext().getSharedPreferences("voip_plugin_prefs", 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString(paramContext, null);
    if (localObject2 != null)
    {
      localObject2 = Util.stringsToList(((String)localObject2).split(";"));
      if (localObject2 != null)
      {
        i = ((List)localObject2).size();
        if (((List)localObject2).contains(this.goe))
        {
          if (i > 1)
          {
            ((List)localObject2).remove(this.goe);
            label905:
            ((List)localObject2).add(0, this.goe);
          }
          localObject2 = Util.listToString((List)localObject2, ";");
          ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
        }
      }
    }
    for (;;)
    {
      EventCenter.instance.addListener(this.GUX);
      EventCenter.instance.addListener(this.yok);
      this.GUn.a(this);
      paramContext = new IntentFilter();
      paramContext.addAction("android.intent.action.SCREEN_ON");
      paramContext.addAction("android.intent.action.SCREEN_OFF");
      paramContext.addAction("android.intent.action.USER_PRESENT");
      MMApplicationContext.getContext().registerReceiver(this.GUV, paramContext);
      if (this.GUg)
      {
        this.GTX = new com.tencent.mm.plugin.voip.video.render.j(this, this.GUf);
        this.GUU = new com.tencent.mm.plugin.voip.b.h();
      }
      i = 1;
      break;
      if (4 != i) {
        break label905;
      }
      ((List)localObject2).remove(i - 1);
      break label905;
      localObject2 = new ArrayList();
      ((List)localObject2).add(0, this.goe);
      localObject2 = Util.listToString((List)localObject2, ";");
      ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
    }
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    AppMethodBeat.i(235534);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onVoipUIDestroy");
    if (this.GTY == paramb)
    {
      Log.d("MicroMsg.Voip.NewVoipMgr", "same VoipUI, clear it");
      this.GTY = null;
      this.GTV.b(null);
    }
    if (this.kAn != null) {
      this.kAn = null;
    }
    AppMethodBeat.o(235534);
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb, int paramInt)
  {
    AppMethodBeat.i(235527);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onVoipUICreated, uiType: %s,  mVoicePlayDevice: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.GUk) });
    if ((1 == paramInt) && (this.GTY != null)) {
      this.GTY.uninit();
    }
    this.GTY = paramb;
    this.mUIType = paramInt;
    this.GTV.b(this.GTY);
    this.GTY.jD(-1, this.GTW.mState);
    this.GTY.setConnectSec(this.GUl);
    this.GTY.adz(this.GUC);
    this.GTY.adz(this.GUD);
    int i;
    if ((this.GTY instanceof Activity))
    {
      i = ((WindowManager)((Activity)this.GTY).getSystemService("window")).getDefaultDisplay().getRotation();
      switch (i)
      {
      default: 
        paramInt = 0;
      }
    }
    for (;;)
    {
      if (this.GTX != null)
      {
        this.GTX.kyf = i;
        this.GTX.Hir = paramInt;
      }
      AppMethodBeat.o(235527);
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
    AppMethodBeat.i(235541);
    if (this.GTX != null)
    {
      com.tencent.mm.plugin.voip.video.render.j localj = this.GTX;
      if (paramVoIPRenderSurfaceView != null) {
        paramVoIPRenderSurfaceView.fLZ();
      }
      localj.Hoh = false;
      localj.HnW = false;
    }
    AppMethodBeat.o(235541);
  }
  
  public final void a(VoIPRenderSurfaceView paramVoIPRenderSurfaceView, int paramInt)
  {
    AppMethodBeat.i(235540);
    if (this.GTX != null)
    {
      com.tencent.mm.plugin.voip.b.h.adJ(0);
      Object localObject = this.GTX;
      p.h(paramVoIPRenderSurfaceView, "view");
      if (!((com.tencent.mm.plugin.voip.video.render.j)localObject).Hoh)
      {
        ((com.tencent.mm.plugin.voip.video.render.j)localObject).Hoh = true;
        com.tencent.mm.plugin.voip.video.render.m localm = ((com.tencent.mm.plugin.voip.video.render.j)localObject).HnX;
        if (localm != null) {
          localm.ad((kotlin.g.a.a)new j.e((com.tencent.mm.plugin.voip.video.render.j)localObject));
        }
      }
      localObject = (j.b)new j.f((com.tencent.mm.plugin.voip.video.render.j)localObject);
      p.h(localObject, "listener");
      paramVoIPRenderSurfaceView.HoG = ((j.b)localObject);
      paramVoIPRenderSurfaceView.HoH = paramInt;
      paramVoIPRenderSurfaceView.getHolder().addCallback(paramVoIPRenderSurfaceView.HoF);
    }
    AppMethodBeat.o(235540);
  }
  
  public final void a(VoIPRenderTextureView paramVoIPRenderTextureView)
  {
    AppMethodBeat.i(235542);
    if (this.GTX != null)
    {
      com.tencent.mm.plugin.voip.video.render.j localj = this.GTX;
      if (paramVoIPRenderTextureView != null)
      {
        paramVoIPRenderTextureView.setSurfaceTextureListener(null);
        j.b localb = paramVoIPRenderTextureView.HoG;
        if (localb != null) {
          localb.aed(paramVoIPRenderTextureView.HoH);
        }
        paramVoIPRenderTextureView.HoG = null;
      }
      localj.Hoh = false;
      localj.HnW = false;
    }
    AppMethodBeat.o(235542);
  }
  
  public final void a(VoIPRenderTextureView paramVoIPRenderTextureView, int paramInt)
  {
    AppMethodBeat.i(235538);
    if (this.GTX != null)
    {
      com.tencent.mm.plugin.voip.b.h.adJ(1);
      Object localObject = this.GTX;
      p.h(paramVoIPRenderTextureView, "view");
      if (!((com.tencent.mm.plugin.voip.video.render.j)localObject).Hoh)
      {
        ((com.tencent.mm.plugin.voip.video.render.j)localObject).Hoh = true;
        com.tencent.mm.plugin.voip.video.render.m localm = ((com.tencent.mm.plugin.voip.video.render.j)localObject).HnX;
        if (localm != null) {
          localm.ad((kotlin.g.a.a)new j.c((com.tencent.mm.plugin.voip.video.render.j)localObject));
        }
      }
      localObject = (j.b)new j.d((com.tencent.mm.plugin.voip.video.render.j)localObject);
      p.h(localObject, "listener");
      paramVoIPRenderTextureView.HoG = ((j.b)localObject);
      paramVoIPRenderTextureView.HoH = paramInt;
      paramVoIPRenderTextureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new VoIPRenderTextureView.b(paramVoIPRenderTextureView));
    }
    AppMethodBeat.o(235538);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void a(final int[] paramArrayOfInt, final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(235594);
    if ((this.GTX != null) && (!this.GTX.GYg))
    {
      this.GTX.fLW();
      this.GTX.GYg = true;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(235494);
        if (NewVoipMgr.a(NewVoipMgr.this) != null)
        {
          com.tencent.mm.plugin.voip.video.camera.a.a locala = NewVoipMgr.a(NewVoipMgr.this).HnU;
          if (locala != null) {
            locala.fLi();
          }
        }
        if (NewVoipMgr.o(NewVoipMgr.this) != null) {
          NewVoipMgr.o(NewVoipMgr.this);
        }
        AppMethodBeat.o(235494);
      }
    });
    AppMethodBeat.o(235594);
  }
  
  public final void aB(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(235531);
    if (this.GTY != null) {
      this.GTY.adx(paramInt1);
    }
    if (this.GUn != null) {
      this.GUn.setPreviewSize(paramInt2, paramInt3);
    }
    AppMethodBeat.o(235531);
  }
  
  public final void aE(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(235539);
    if (this.GUU != null)
    {
      com.tencent.mm.plugin.voip.b.h localh = this.GUU;
      long l = Util.currentTicks();
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          localh.Hhg = l;
          AppMethodBeat.o(235539);
          return;
        }
        localh.Hhe = l;
        AppMethodBeat.o(235539);
        return;
      }
      if (paramBoolean2)
      {
        localh.Hhh = l;
        AppMethodBeat.o(235539);
        return;
      }
      localh.Hhf = l;
    }
    AppMethodBeat.o(235539);
  }
  
  public final void aUw(String paramString)
  {
    AppMethodBeat.i(235558);
    if (this.GTY != null)
    {
      this.GUy = paramString;
      this.GTY.aUB(paramString);
    }
    AppMethodBeat.o(235558);
  }
  
  final void acM(int paramInt)
  {
    AppMethodBeat.i(235529);
    if (paramInt == 5)
    {
      mHZ += GUR[0];
      this.GUW += 1;
      Log.i("MicroMsg.Voip.NewVoipMgr", "mSignalStrength 4G" + GUR[0] + " and index is " + this.GUW);
      AppMethodBeat.o(235529);
      return;
    }
    WifiManager localWifiManager;
    if (paramInt == 4)
    {
      localWifiManager = (WifiManager)MMApplicationContext.getContext().getApplicationContext().getSystemService("wifi");
      if ((localWifiManager == null) || (localWifiManager.getConnectionInfo() == null)) {}
    }
    for (;;)
    {
      try
      {
        int[] arrayOfInt = GUR;
        if (localWifiManager.getConnectionInfo() != null) {
          continue;
        }
        paramInt = 0;
        arrayOfInt[1] = paramInt;
      }
      catch (Exception localException)
      {
        GUR[1] = 0;
        Log.i("MicroMsg.Voip.NewVoipMgr", "error happened in get wifi info");
        continue;
      }
      mHZ += GUR[1];
      this.GUW += 1;
      Log.i("MicroMsg.Voip.NewVoipMgr", "mSignalStrength WIFI " + GUR[1] + " and index is " + this.GUW);
      AppMethodBeat.o(235529);
      return;
      paramInt = localWifiManager.getConnectionInfo().getRssi();
    }
  }
  
  public final void acQ(int paramInt)
  {
    AppMethodBeat.i(235569);
    Log.i("MicroMsg.Voip.NewVoipMgr", "remote voip mode changed, cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    if (((1 == paramInt) || (3 == paramInt) || (5 == paramInt) || (6 == paramInt) || (7 == paramInt)) && (this.GUg))
    {
      xN(4101);
      com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGz();
      com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGA();
    }
    AppMethodBeat.o(235569);
  }
  
  public final void acR(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(235575);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onSessionBeingCalled, callType: ".concat(String.valueOf(paramInt)));
    if (!this.GTW.adT(4110))
    {
      AppMethodBeat.o(235575);
      return;
    }
    u localu = com.tencent.mm.plugin.voip.c.fFg();
    if (paramInt == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramInt == 1) {
        bool2 = true;
      }
      localu.aH(bool1, bool2);
      fFK();
      if ((paramInt == 1) && (com.tencent.mm.plugin.voip.b.k.adQ(this.GTW.mState))) {
        xN(4101);
      }
      xN(4110);
      AppMethodBeat.o(235575);
      return;
    }
  }
  
  public final void acS(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(235576);
    Log.i("MicroMsg.Voip.NewVoipMgr", "steve:[simucall]onNewSimulCallAutoAccept, callType: ".concat(String.valueOf(paramInt)));
    if (!this.GTW.adT(4100))
    {
      AppMethodBeat.o(235576);
      return;
    }
    u localu = com.tencent.mm.plugin.voip.c.fFg();
    if (paramInt == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramInt == 1) {
        bool2 = true;
      }
      localu.aH(bool1, bool2);
      com.tencent.mm.plugin.voip.c.fFg().GYS.stopRing();
      if ((paramInt == 1) && (com.tencent.mm.plugin.voip.b.k.adQ(this.GTW.mState))) {
        xN(4101);
      }
      xN(4100);
      AppMethodBeat.o(235576);
      return;
    }
  }
  
  public final void ag(long paramLong, int paramInt)
  {
    int k = 1;
    AppMethodBeat.i(235533);
    Object localObject1;
    int i;
    label60:
    Object localObject2;
    int j;
    if (this.GUU != null) {
      switch (paramInt)
      {
      default: 
        if (this.GTX != null)
        {
          localObject1 = this.GUU;
          if (1 != this.mUIType) {
            break label367;
          }
          i = 1;
          localObject2 = this.GTX.HnX;
          j = k;
          if (localObject2 != null)
          {
            if (((com.tencent.mm.plugin.voip.video.render.m)localObject2).fMd() == 0) {
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
      AppMethodBeat.o(235533);
      return;
      if (1 == this.mUIType)
      {
        if (!com.tencent.mm.plugin.voip.c.fFg().GZg)
        {
          localObject1 = this.GUU;
          if ((260 != this.GTW.mState) && (6 != this.GTW.mState)) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.plugin.voip.b.h)localObject1).aO(true, bool);
            com.tencent.mm.plugin.voip.c.fFg().GZg = true;
            break;
          }
        }
        localObject1 = this.GUU;
        if ((260 != this.GTW.mState) && (6 != this.GTW.mState)) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.voip.b.h)localObject1).aP(true, bool);
          break;
        }
      }
      if (!com.tencent.mm.plugin.voip.c.fFg().GZf)
      {
        localObject1 = this.GUU;
        if ((260 != this.GTW.mState) && (6 != this.GTW.mState)) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.voip.b.h)localObject1).aO(false, bool);
          com.tencent.mm.plugin.voip.c.fFg().GZf = true;
          break;
        }
      }
      localObject1 = this.GUU;
      if ((260 != this.GTW.mState) && (6 != this.GTW.mState)) {}
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.voip.b.h)localObject1).aP(false, bool);
        break;
      }
      label367:
      i = 0;
      break label60;
      label373:
      j = 0;
      break label90;
      ((com.tencent.mm.plugin.voip.b.h)localObject1).Hhi += 1;
      if (((com.tencent.mm.plugin.voip.b.h)localObject1).Hhi == 0)
      {
        if (i != 0)
        {
          if (paramLong > 0L)
          {
            localObject1 = com.tencent.mm.plugin.voip.b.j.Hhp;
            com.tencent.mm.plugin.voip.b.j.Ls(paramLong);
            AppMethodBeat.o(235533);
          }
        }
        else
        {
          if (paramLong > 0L)
          {
            localObject1 = com.tencent.mm.plugin.voip.b.j.Hhp;
            com.tencent.mm.plugin.voip.b.j.Lt(paramLong);
          }
          AppMethodBeat.o(235533);
        }
      }
      else if (((com.tencent.mm.plugin.voip.b.h)localObject1).Hhi == 60) {
        ((com.tencent.mm.plugin.voip.b.h)localObject1).Hhi = -1;
      }
      AppMethodBeat.o(235533);
      return;
      ((com.tencent.mm.plugin.voip.b.h)localObject1).Hhj += 1;
      if (((com.tencent.mm.plugin.voip.b.h)localObject1).Hhj == 0)
      {
        if (i != 0)
        {
          if (j != 0)
          {
            localObject1 = com.tencent.mm.plugin.voip.b.j.Hhp;
            com.tencent.mm.plugin.voip.b.j.LK(paramLong);
            AppMethodBeat.o(235533);
            return;
          }
          localObject1 = com.tencent.mm.plugin.voip.b.j.Hhp;
          com.tencent.mm.plugin.voip.b.j.LI(paramLong);
          AppMethodBeat.o(235533);
          return;
        }
        if (j != 0)
        {
          localObject1 = com.tencent.mm.plugin.voip.b.j.Hhp;
          com.tencent.mm.plugin.voip.b.j.LL(paramLong);
          AppMethodBeat.o(235533);
          return;
        }
        localObject1 = com.tencent.mm.plugin.voip.b.j.Hhp;
        com.tencent.mm.plugin.voip.b.j.LJ(paramLong);
        AppMethodBeat.o(235533);
        return;
      }
      if (((com.tencent.mm.plugin.voip.b.h)localObject1).Hhj == 60) {
        ((com.tencent.mm.plugin.voip.b.h)localObject1).Hhj = -1;
      }
      AppMethodBeat.o(235533);
      return;
      ((com.tencent.mm.plugin.voip.b.h)localObject1).Hhk += 1;
      if (((com.tencent.mm.plugin.voip.b.h)localObject1).Hhk == 0)
      {
        if (i != 0)
        {
          localObject2 = com.tencent.mm.plugin.voip.b.j.Hhp;
          com.tencent.mm.plugin.voip.b.j.Lu(paramLong);
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.voip.b.h)localObject1).Hhi = 0;
          AppMethodBeat.o(235533);
          return;
          localObject2 = com.tencent.mm.plugin.voip.b.j.Hhp;
          com.tencent.mm.plugin.voip.b.j.Lv(paramLong);
        }
      }
      if (((com.tencent.mm.plugin.voip.b.h)localObject1).Hhk == 60) {
        ((com.tencent.mm.plugin.voip.b.h)localObject1).Hhk = -1;
      }
    }
  }
  
  public final void ah(long paramLong, int paramInt) {}
  
  public final void cza() {}
  
  public final void dZK()
  {
    AppMethodBeat.i(235560);
    Log.i("MicroMsg.Voip.NewVoipMgr", "on accept");
    fFK();
    xN(4100);
    AppMethodBeat.o(235560);
  }
  
  public final void dZQ()
  {
    AppMethodBeat.i(235582);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onNetWorkChangeMobileNet");
    if (this.GTY != null) {
      this.GTY.fJn();
    }
    AppMethodBeat.o(235582);
  }
  
  public final void dZR()
  {
    AppMethodBeat.i(235583);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onResumeGoodNetStatus");
    if (this.GTY != null) {
      this.GTY.ebH();
    }
    AppMethodBeat.o(235583);
  }
  
  public final void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(235570);
    if (this.GTX != null)
    {
      Object localObject1 = this.GTX;
      p.h(paramArrayOfByte, "outData");
      localObject1 = ((com.tencent.mm.plugin.voip.video.render.j)localObject1).HnX;
      if (localObject1 != null)
      {
        int i = OpenGlRender.FLAG_YV12Edge;
        int j = OpenGlRender.FLAG_Angle90;
        p.h(paramArrayOfByte, "pBuff");
        localObject1 = ((com.tencent.mm.plugin.voip.video.render.m)localObject1).Hpl;
        if (localObject1 != null)
        {
          p.h(paramArrayOfByte, "pBuff");
          if (((com.tencent.mm.plugin.voip.video.render.d)localObject1).Hko != null)
          {
            Object localObject2 = ((com.tencent.mm.plugin.voip.video.render.d)localObject1).Hnj;
            if (localObject2 != null)
            {
              p.h(paramArrayOfByte, "pBuff");
              localObject2 = ((com.tencent.mm.plugin.voip.video.render.l)localObject2).Hpi;
              p.h(paramArrayOfByte, "pBuff");
              localObject2 = ((com.tencent.mm.plugin.voip.video.c.d)localObject2).Hmy;
              if (localObject2 != null)
              {
                p.h(paramArrayOfByte, "pBuff");
                if (((com.tencent.mm.plugin.voip.video.c.h)localObject2).Him == null)
                {
                  ((com.tencent.mm.plugin.voip.video.c.h)localObject2).mWidth = paramInt1;
                  ((com.tencent.mm.plugin.voip.video.c.h)localObject2).mHeight = paramInt2;
                  ((com.tencent.mm.plugin.voip.video.c.h)localObject2).AOS = (i + j);
                  ((com.tencent.mm.plugin.voip.video.c.h)localObject2).Him = paramArrayOfByte;
                }
              }
            }
            paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.render.d)localObject1).Hko;
            if (paramArrayOfByte == null) {
              p.hyc();
            }
            ((n)localObject1).b(paramArrayOfByte);
          }
        }
      }
      if (this.GTY != null) {
        this.GTY.fJm();
      }
    }
    AppMethodBeat.o(235570);
  }
  
  public final void enR()
  {
    AppMethodBeat.i(235553);
    if (this.GTY != null) {
      this.GTY.enR();
    }
    AppMethodBeat.o(235553);
  }
  
  public final boolean fEZ()
  {
    return this.GUg;
  }
  
  public final boolean fFA()
  {
    AppMethodBeat.i(235525);
    if (!this.GTW.adT(4098))
    {
      AppMethodBeat.o(235525);
      return false;
    }
    Log.i("MicroMsg.Voip.NewVoipMgr", "onCancelVideoInvite");
    acN(4098);
    com.tencent.mm.plugin.voip.c.fFg().fIl();
    AppMethodBeat.o(235525);
    return true;
  }
  
  public final boolean fFB()
  {
    AppMethodBeat.i(235526);
    if (!this.GTW.adT(4098))
    {
      AppMethodBeat.o(235526);
      return false;
    }
    Log.i("MicroMsg.Voip.NewVoipMgr", "onCancelVoiceInvite");
    acN(4098);
    com.tencent.mm.plugin.voip.c.fFg().fIl();
    AppMethodBeat.o(235526);
    return true;
  }
  
  public final void fFC()
  {
    boolean bool2 = true;
    AppMethodBeat.i(235528);
    if ((this.GUg) && (this.GTX != null))
    {
      com.tencent.mm.plugin.voip.video.render.j localj = this.GTX;
      if ((localj.HnU != null) && (localj.HnX != null))
      {
        Object localObject = localj.HnX;
        if (localObject == null) {
          p.hyc();
        }
        if (((com.tencent.mm.plugin.voip.video.render.m)localObject).Hpj != null)
        {
          localObject = localj.HnX;
          if (localObject == null) {
            p.hyc();
          }
          localObject = ((com.tencent.mm.plugin.voip.video.render.m)localObject).Hpj;
          if (localObject == null) {
            p.hyc();
          }
          com.tencent.mm.plugin.voip.video.camera.a.a locala = localj.HnU;
          if (locala == null) {
            break label185;
          }
          bool1 = locala.fKY();
          localj.d((com.tencent.mm.plugin.voip.video.render.g)localObject, bool1);
        }
      }
    }
    if ((this.GUf) && (com.tencent.mm.plugin.voip.b.k.adR(this.GTW.mState)) && (com.tencent.mm.plugin.voip.c.fFg().GYS.czl()))
    {
      this.GTV.aN(this.GUg, this.GUf);
      if (this.GUk != 1) {
        break label190;
      }
    }
    label185:
    label190:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      wU(bool1);
      AppMethodBeat.o(235528);
      return;
      bool1 = true;
      break;
    }
  }
  
  public final void fFD()
  {
    AppMethodBeat.i(235530);
    Log.i("MicroMsg.Voip.NewVoipMgr", "it is init voip report");
    this.GUO = new NetChangedBroadcastReceiver();
    Object localObject1 = new IntentFilter();
    ((IntentFilter)localObject1).addAction("android.net.wifi.WIFI_STATE_CHANGED");
    ((IntentFilter)localObject1).addAction("android.net.wifi.STATE_CHANGE");
    ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
    MMApplicationContext.getContext().registerReceiver(this.GUO, (IntentFilter)localObject1);
    this.qtS = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
    this.GUM = com.tencent.mm.plugin.voip.b.e.getNetType(getContext());
    this.GUP = new NewVoipMgr.13(this);
    localObject1 = this.qtS;
    Object localObject2 = this.GUP;
    localObject2 = com.tencent.mm.hellhoundlib.b.c.a(256, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/voip/model/NewVoipMgr", "initVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/voip/model/NewVoipMgr", "initVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    AppMethodBeat.o(235530);
  }
  
  public final void fFE()
  {
    AppMethodBeat.i(235532);
    if ((this.zuc) || (this.GTY == null) || (this.GTY.fJl() == null) || (this.GTX == null) || (this.GTX.HnU == null))
    {
      Log.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, already show");
      AppMethodBeat.o(235532);
      return;
    }
    if (this.GTX.HnU.dEO())
    {
      AppMethodBeat.o(235532);
      return;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("meizu")) && (!com.tencent.mm.compatible.e.b.apj()) && (com.tencent.mm.compatible.util.d.oE(29)))
    {
      Log.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, meizu machine");
      AppMethodBeat.o(235532);
      return;
    }
    if ((com.tencent.mm.compatible.util.d.oD(28)) && (((KeyguardManager)MMApplicationContext.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()))
    {
      Log.i("MicroMsg.Voip.NewVoipMgr", "api level: %s, in keyguard, ignore", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(235532);
      return;
    }
    Log.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, show dialog");
    com.tencent.mm.plugin.report.service.h.CyF.a(11306, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.n(this.GTY.fJl(), 2131767335, 2131755998);
    if (locald == null)
    {
      Log.e("MicroMsg.Voip.NewVoipMgr", "new dialog failed");
      AppMethodBeat.o(235532);
      return;
    }
    locald.setCancelable(false);
    locald.setCanceledOnTouchOutside(false);
    locald.show();
    this.zuc = true;
    com.tencent.mm.plugin.voip.b.h.fKq();
    AppMethodBeat.o(235532);
  }
  
  public final void fFF()
  {
    AppMethodBeat.i(235535);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onSwitchCamera");
    com.tencent.mm.plugin.voip.video.render.j localj;
    Object localObject;
    int i;
    if (this.GTX != null)
    {
      localj = this.GTX;
      Log.i("MicroMsg.VoIPRenderMgr", "onSwitchCamera");
      if (localj.HnU != null)
      {
        localObject = localj.HnU;
        if (localObject == null) {
          p.hyc();
        }
        if (((com.tencent.mm.plugin.voip.video.camera.a.a)localObject).fLc() != null)
        {
          localj.onOrientationChange(localj.kyf);
          localObject = localj.HnU;
          if (localObject != null) {
            ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject).fLd();
          }
          localObject = localj.HnU;
          if (localObject == null) {
            p.hyc();
          }
          localObject = ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject).fLc();
          if (localObject == null) {
            p.hyc();
          }
          com.tencent.mm.plugin.voip.video.camera.a.a locala = localj.HnU;
          if (locala == null) {
            p.hyc();
          }
          i = locala.fLe();
          locala = localj.HnU;
          if (locala == null) {
            p.hyc();
          }
          if (locala.fLf()) {
            break label210;
          }
        }
      }
    }
    label210:
    for (boolean bool = true;; bool = false)
    {
      localj.a((ac)localObject, i, bool);
      localj.aeb(localj.Hir);
      localj.Hod = true;
      com.tencent.mm.plugin.report.service.h.CyF.a(11079, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(235535);
      return;
    }
  }
  
  public final void fFG()
  {
    AppMethodBeat.i(235536);
    if ((this.GTX != null) && (this.GTX.HnU != null) && (true != this.GTX.HnU.fKY())) {
      fFF();
    }
    AppMethodBeat.o(235536);
  }
  
  public final void fFH()
  {
    AppMethodBeat.i(235543);
    if (this.GTX != null)
    {
      Object localObject1 = this.GTX;
      Log.printInfoStack("MicroMsg.VoIPRenderMgr", "onRender Mode changed", new Object[0]);
      if (!((com.tencent.mm.plugin.voip.video.render.j)localObject1).HdG) {}
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.voip.video.render.j)localObject1).HdG = bool;
        Object localObject2 = ((com.tencent.mm.plugin.voip.video.render.j)localObject1).HnX;
        if (localObject2 != null) {
          com.tencent.mm.plugin.voip.video.render.m.a((com.tencent.mm.plugin.voip.video.render.m)localObject2);
        }
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.j)localObject1).HnX;
        if (localObject2 != null)
        {
          Log.printInfoStack("MicroMsg.LocalWindowsSurfaceRenderer", "switchRenderSurface", new Object[0]);
          Object localObject3 = ((com.tencent.mm.plugin.voip.video.render.m)localObject2).Hpk;
          if (localObject3 != null) {
            ((n)localObject3).fLQ();
          }
          localObject3 = ((com.tencent.mm.plugin.voip.video.render.m)localObject2).Hpj;
          if (localObject3 != null) {
            ((com.tencent.mm.plugin.voip.video.render.g)localObject3).fLQ();
          }
          localObject2 = ((com.tencent.mm.plugin.voip.video.render.m)localObject2).Hpl;
          if (localObject2 != null) {
            ((n)localObject2).fLQ();
          }
        }
        localObject1 = ((com.tencent.mm.plugin.voip.video.render.j)localObject1).HnX;
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.plugin.voip.video.render.m)localObject1).fLR();
        AppMethodBeat.o(235543);
        return;
      }
    }
    AppMethodBeat.o(235543);
  }
  
  public final void fFI()
  {
    AppMethodBeat.i(235545);
    if (this.GTX != null) {
      this.GTX.jA(this.GUK, this.GUL);
    }
    AppMethodBeat.o(235545);
  }
  
  public final void fFJ()
  {
    AppMethodBeat.i(235547);
    this.GUU.adI(1);
    AppMethodBeat.o(235547);
  }
  
  public final void fFK()
  {
    AppMethodBeat.i(235549);
    if (this.GTV != null)
    {
      Log.i("MicroMsg.Voip.NewVoipMgr", "use audioManager to stop voip ring");
      this.GTV.fFK();
      AppMethodBeat.o(235549);
      return;
    }
    Log.i("MicroMsg.Voip.NewVoipMgr", "use Subcore to stop voip ring");
    com.tencent.mm.plugin.voip.c.fFg().GYS.stopRing();
    AppMethodBeat.o(235549);
  }
  
  public final void fFL()
  {
    AppMethodBeat.i(235550);
    if (this.GTY != null) {
      this.GTY.fFL();
    }
    AppMethodBeat.o(235550);
  }
  
  public final boolean fFM()
  {
    AppMethodBeat.i(235551);
    if (com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId == 0)
    {
      this.GUj = true;
      AppMethodBeat.o(235551);
      return true;
    }
    boolean bool = fFN();
    AppMethodBeat.o(235551);
    return bool;
  }
  
  public final void fFO()
  {
    AppMethodBeat.i(235554);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onRoomReady");
    if ((this.GUj) && (com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId != 0))
    {
      this.GUj = false;
      fFN();
    }
    if (this.GUf) {
      xN(4097);
    }
    AppMethodBeat.o(235554);
  }
  
  public final void fFR()
  {
    AppMethodBeat.i(235565);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onNoResp");
    xN(4105);
    String str2 = this.GUe.field_username;
    String str1;
    if (this.GUg)
    {
      str1 = ca.OqC;
      if (!this.GUf) {
        break label181;
      }
    }
    label181:
    for (int i = 1;; i = 0)
    {
      s.c(str2, str1, i, 4, MMApplicationContext.getContext().getString(2131767248));
      com.tencent.mm.plugin.report.service.h.CyF.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH), Long.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGu()), Integer.valueOf(6), Integer.valueOf(NetStatusUtil.getNetWorkType(getContext())) });
      fFP();
      AppMethodBeat.o(235565);
      return;
      str1 = ca.OqB;
      break;
    }
  }
  
  public final void fFS()
  {
    int j = 0;
    AppMethodBeat.i(235567);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
    int k = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId;
    long l1 = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH;
    long l2 = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGu();
    if (this.GUf)
    {
      i = 0;
      localh.a(11522, true, true, new Object[] { Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(1) });
      k = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId;
      l1 = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH;
      if (!this.GUf) {
        break label198;
      }
    }
    label198:
    for (int i = j;; i = 1)
    {
      com.tencent.mm.plugin.voip.b.e.c(k, l1, i, 3);
      this.GUQ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(235506);
          NewVoipMgr.a(NewVoipMgr.this, NewVoipMgr.i(NewVoipMgr.this));
          NewVoipMgr.q(NewVoipMgr.this).postDelayed(this, 5000L);
          AppMethodBeat.o(235506);
        }
      });
      AppMethodBeat.o(235567);
      return;
      i = 1;
      break;
    }
  }
  
  public final void fFT()
  {
    AppMethodBeat.i(235577);
    Log.d("MicroMsg.Voip.NewVoipMgr", "onPretreatmentForStartDev");
    this.GTV.aM(this.GUx, this.GUg);
    AppMethodBeat.o(235577);
  }
  
  public final long fFU()
  {
    AppMethodBeat.i(235578);
    long l = this.GTV.Hgu;
    Log.printInfoStack("MicroMsg.Voip.NewVoipMgr", "totalDeviceNearTime: %s", new Object[] { Long.valueOf(l) });
    l /= 1000L;
    AppMethodBeat.o(235578);
    return l;
  }
  
  public final void fFY()
  {
    AppMethodBeat.i(235590);
    if ((256 != this.GTW.mState) && (257 != this.GTW.mState))
    {
      AppMethodBeat.o(235590);
      return;
    }
    if ((com.tencent.mm.kernel.g.aAh().azQ().getInt(327945, 0) == 0) && (this.GTY.fJl() != null))
    {
      com.tencent.mm.kernel.g.aAh().azQ().setInt(327945, 1);
      com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.a(this.GTY.fJl(), 2131767307, 2131755998, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(235491);
          NewVoipMgr.this.fGa();
          AppMethodBeat.o(235491);
        }
      });
      locald.setCancelable(false);
      locald.setCanceledOnTouchOutside(false);
      locald.show();
      AppMethodBeat.o(235590);
      return;
    }
    com.tencent.mm.plugin.voip.b.m.hG(MMApplicationContext.getContext());
    fGa();
    AppMethodBeat.o(235590);
  }
  
  public final void fFZ()
  {
    AppMethodBeat.i(235591);
    if (!this.GUp) {}
    for (boolean bool = true;; bool = false)
    {
      this.GUp = bool;
      if (!this.GUp) {
        break;
      }
      this.GUo.stopTimer();
      AppMethodBeat.o(235591);
      return;
    }
    if (this.GUo == null) {
      this.GUo = new MTimerHandler("faceDetect", new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(235493);
          NewVoipMgr.H(NewVoipMgr.this);
          AppMethodBeat.o(235493);
          return true;
        }
      }, true);
    }
    this.GUo.startTimer(2000L);
    this.GUp = false;
    AppMethodBeat.o(235591);
  }
  
  public final boolean fFa()
  {
    return this.GUf;
  }
  
  public final String fFb()
  {
    return this.GUy;
  }
  
  public final long fFc()
  {
    return this.GUE;
  }
  
  public final long fFd()
  {
    return this.GUF;
  }
  
  public final int fFe()
  {
    return this.GUG;
  }
  
  public final boolean fFt()
  {
    AppMethodBeat.i(235519);
    if (!this.GTW.adT(4103))
    {
      AppMethodBeat.o(235519);
      return false;
    }
    acN(4103);
    com.tencent.mm.plugin.voip.c.fFg().fIl();
    AppMethodBeat.o(235519);
    return true;
  }
  
  public final boolean fFu()
  {
    AppMethodBeat.i(235520);
    if (!this.GTW.adT(4101))
    {
      AppMethodBeat.o(235520);
      return false;
    }
    fFK();
    com.tencent.mm.plugin.voip.c.fFg().adf(1);
    com.tencent.mm.plugin.voip.c.fFg().aH(true, this.GUg);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.CyF;
    long l = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH;
    int j = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId;
    if (this.GUf) {}
    for (int i = 1;; i = 0)
    {
      localh.a(11046, new Object[] { Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i) });
      com.tencent.mm.plugin.report.service.h.CyF.a(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0) });
      xN(4111);
      xN(4101);
      xN(4100);
      AppMethodBeat.o(235520);
      return true;
    }
  }
  
  public final boolean fFv()
  {
    int i = 0;
    AppMethodBeat.i(235521);
    if (!this.GTW.adT(4099))
    {
      AppMethodBeat.o(235521);
      return false;
    }
    String str2 = this.GUe.field_username;
    if (this.GUg) {}
    for (String str1 = ca.OqC;; str1 = ca.OqB)
    {
      if (this.GUf) {
        i = 1;
      }
      s.c(str2, str1, i, 6, MMApplicationContext.getContext().getString(2131767245));
      fFK();
      com.tencent.mm.plugin.voip.c.fFg().GYS.fIw();
      xN(4099);
      fFP();
      AppMethodBeat.o(235521);
      return true;
    }
  }
  
  public final boolean fFw()
  {
    AppMethodBeat.i(235522);
    if (!this.GTW.adT(4100))
    {
      AppMethodBeat.o(235522);
      return false;
    }
    if (this.GTX != null) {
      this.GTX.fLW();
    }
    Log.i("MicroMsg.Voip.NewVoipMgr", "onAcceptVideoInvite");
    fFK();
    com.tencent.mm.plugin.voip.c.fFg().aH(false, this.GUg);
    xN(4100);
    AppMethodBeat.o(235522);
    return true;
  }
  
  public final void fFx()
  {
    if (this.GTX != null) {
      this.GTX.GYg = false;
    }
  }
  
  public final boolean fFy()
  {
    int i = 0;
    AppMethodBeat.i(235523);
    if (!this.GTW.adT(4099))
    {
      AppMethodBeat.o(235523);
      return false;
    }
    Log.i("MicroMsg.Voip.NewVoipMgr", "onRejectVoiceInvite");
    String str2 = this.GUe.field_username;
    if (this.GUg) {}
    for (String str1 = ca.OqC;; str1 = ca.OqB)
    {
      if (this.GUf) {
        i = 1;
      }
      s.c(str2, str1, i, 6, MMApplicationContext.getContext().getString(2131767245));
      fFK();
      com.tencent.mm.plugin.voip.c.fFg().GYS.fIw();
      xN(4099);
      fFP();
      AppMethodBeat.o(235523);
      return true;
    }
  }
  
  public final boolean fFz()
  {
    AppMethodBeat.i(235524);
    if (!this.GTW.adT(4100))
    {
      AppMethodBeat.o(235524);
      return false;
    }
    Log.i("MicroMsg.Voip.NewVoipMgr", "onAcceptVoiceInvite");
    fFK();
    com.tencent.mm.plugin.voip.c.fFg().aH(true, this.GUg);
    xN(4111);
    xN(4100);
    AppMethodBeat.o(235524);
    return true;
  }
  
  public final void fGa()
  {
    AppMethodBeat.i(235592);
    com.tencent.mm.plugin.voip.c.fFg().GYZ = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId;
    String str2 = this.GUe.field_username;
    String str1;
    if (this.GUg)
    {
      str1 = ca.OqC;
      if (!this.GUf) {
        break label124;
      }
    }
    label124:
    for (int i = 1;; i = 0)
    {
      s.c(str2, str1, i, 6, MMApplicationContext.getContext().getString(2131767244));
      fFK();
      xN(4108);
      if (this.kAn != null) {
        this.kAn.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(235492);
            NewVoipMgr.G(NewVoipMgr.this);
            AppMethodBeat.o(235492);
          }
        }, 2000L);
      }
      AppMethodBeat.o(235592);
      return;
      str1 = ca.OqB;
      break;
    }
  }
  
  public final void fs(int paramInt1, int paramInt2) {}
  
  public final Context getContext()
  {
    AppMethodBeat.i(235587);
    Context localContext1 = null;
    if (this.GTY != null) {
      localContext1 = this.GTY.fJl();
    }
    Context localContext2 = localContext1;
    if (localContext1 == null) {
      localContext2 = MMApplicationContext.getContext();
    }
    AppMethodBeat.o(235587);
    return localContext2;
  }
  
  public final int getState()
  {
    return this.GTW.mState;
  }
  
  public final String getUserName()
  {
    return this.goe;
  }
  
  public final void jA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235574);
    Log.i("MicroMsg.Voip.NewVoipMgr", "adjustHWViewAspectRatio, HWDecsize:%dx%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.GUK = paramInt1;
    this.GUL = paramInt2;
    if (this.GTX != null) {
      this.GTX.jA(paramInt1, paramInt2);
    }
    AppMethodBeat.o(235574);
  }
  
  public final void jz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235546);
    if (this.GTX != null)
    {
      this.GTX.onOrientationChange(paramInt1);
      if (this.GUt != paramInt2)
      {
        this.GUt = paramInt2;
        this.GTX.aeb(paramInt2);
      }
    }
    AppMethodBeat.o(235546);
  }
  
  public final void onConnected()
  {
    AppMethodBeat.i(235566);
    xN(4102);
    this.GUl = Util.nowSecond();
    com.tencent.mm.plugin.voip.c.a(this.GUg, this.GUf, this.GUl, this.goe);
    if (this.GTY != null) {
      this.GTY.setConnectSec(this.GUl);
    }
    boolean bool1 = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGw();
    boolean bool2 = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGv();
    if ((this.GUg) && (this.GUf) && (!bool2) && (!bool1)) {
      com.tencent.mm.plugin.voip.c.fFg().adf(1);
    }
    if (!com.tencent.mm.plugin.voip.b.k.adQ(this.GTW.mState)) {
      com.tencent.mm.plugin.report.service.h.CyF.a(11080, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
    }
    Util.shake(MMApplicationContext.getContext(), true);
    com.tencent.mm.plugin.voip.c.fFg().adq(com.tencent.mm.plugin.voip.c.fFg().fIk());
    r.fHo().fHp();
    r.fHo().a(this);
    k localk = k.GVq;
    k.setRoomId(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId);
    AppMethodBeat.o(235566);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(235559);
    this.GTV.xq(this.GUg);
    String str1 = paramString;
    if (paramInt == 241)
    {
      str1 = paramString;
      if (Util.isNullOrNil(paramString)) {
        str1 = getContext().getString(2131767344);
      }
    }
    if (this.GTY != null) {
      this.GTY.cF(paramInt, str1);
    }
    Log.i("MicroMsg.Voip.NewVoipMgr", "onError, errCode: %s, roomId: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId) });
    if (com.tencent.mm.plugin.voip.b.k.adP(this.GTW.mState))
    {
      paramString = MMApplicationContext.getContext().getString(2131767340, new Object[] { AF(Util.secondsToNow(this.GUl)) });
      xN(4109);
      if ((com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId == 0) || (com.tencent.mm.plugin.voip.c.fFg().GYY.get(Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId)) != null)) {
        break label474;
      }
      str2 = this.GUe.field_username;
      if (!this.GUg) {
        break label461;
      }
      str1 = ca.OqC;
      if (!this.GUf) {
        break label469;
      }
      paramInt = 1;
      if (com.tencent.mm.plugin.voip.b.k.adP(this.GTW.mState)) {
        paramString = MMApplicationContext.getContext().getString(2131767242, new Object[] { AF(Util.secondsToNow(this.GUl)) });
      }
      l = s.a(str2, str1, paramInt, 6, paramString, true);
      com.tencent.mm.plugin.voip.c.fFg().GYY.put(Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId), Long.valueOf(l));
    }
    label461:
    label469:
    label474:
    while (com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId != 0) {
      for (;;)
      {
        long l;
        com.tencent.mm.plugin.voip.c.fFg().fIl();
        fFP();
        AppMethodBeat.o(235559);
        return;
        paramString = MMApplicationContext.getContext();
        Log.d("MicroMsg.Voip.NewVoipMgr", "getErrorMsgContent, errorCode".concat(String.valueOf(paramInt)));
        if (paramInt == 235)
        {
          paramString = paramString.getString(2131767247);
          break;
        }
        if (paramInt == 233)
        {
          paramString = paramString.getString(2131767238);
          break;
        }
        if (paramInt == 237)
        {
          paramString = paramString.getString(2131767247);
          break;
        }
        if (paramInt == 236)
        {
          paramString = paramString.getString(2131767238);
          break;
        }
        if (paramInt == 211)
        {
          paramString = paramString.getString(2131767246);
          break;
        }
        paramString = paramString.getString(2131767237);
        break;
        str1 = ca.OqB;
        continue;
        paramInt = 0;
      }
    }
    String str2 = this.GUe.field_username;
    if (this.GUg)
    {
      str1 = ca.OqC;
      label513:
      if (!this.GUf) {
        break label586;
      }
    }
    label586:
    for (paramInt = 1;; paramInt = 0)
    {
      if (com.tencent.mm.plugin.voip.b.k.adP(this.GTW.mState)) {
        paramString = MMApplicationContext.getContext().getString(2131767242, new Object[] { AF(Util.secondsToNow(this.GUl)) });
      }
      s.a(str2, str1, paramInt, 6, paramString, true);
      break;
      str1 = ca.OqB;
      break label513;
    }
  }
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture) {}
  
  public final void onReject()
  {
    AppMethodBeat.i(235561);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onReject");
    xN(4099);
    String str2 = this.GUe.field_username;
    String str1;
    if (this.GUg)
    {
      str1 = ca.OqC;
      if (!this.GUf) {
        break label86;
      }
    }
    label86:
    for (int i = 1;; i = 0)
    {
      s.c(str2, str1, i, 6, MMApplicationContext.getContext().getString(2131767249));
      fFP();
      AppMethodBeat.o(235561);
      return;
      str1 = ca.OqB;
      break;
    }
  }
  
  public final void ql(boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(235581);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onBadNetStatus");
    if (this.GTY != null) {
      this.GTY.xi(paramBoolean);
    }
    long l;
    if ((!com.tencent.mm.plugin.voip.b.k.adQ(this.GTW.mState)) && (!this.GTV.isSpeakerphoneOn()))
    {
      l = System.currentTimeMillis();
      if (l - this.yqt > 30000L)
      {
        this.yqt = l;
        com.tencent.mm.plugin.voip.c.fFg().GYS.fIA();
      }
    }
    Object localObject = new StringBuilder("report the bad net toast room key is ").append(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH).append("and in the side");
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      Log.i("MicroMsg.Voip.NewVoipMgr", i);
      localObject = com.tencent.mm.plugin.report.service.h.CyF;
      l = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH;
      i = j;
      if (paramBoolean) {
        i = 1;
      }
      ((com.tencent.mm.plugin.report.service.h)localObject).a(17151, true, true, new Object[] { Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(235581);
      return;
    }
  }
  
  public final void rv(boolean paramBoolean)
  {
    AppMethodBeat.i(235518);
    this.GTV.xp(paramBoolean);
    AppMethodBeat.o(235518);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(235573);
    this.GUB = paramInt;
    if (this.GTX != null)
    {
      this.GTX.setHWDecMode(paramInt);
      if (this.GTY != null) {
        this.GTY.ady(paramInt);
      }
      if (this.GUU != null)
      {
        com.tencent.mm.plugin.voip.b.h localh = this.GUU;
        if ((paramInt & 0x1) != 0)
        {
          localh.Hha += 1L;
          AppMethodBeat.o(235573);
          return;
        }
        localh.Hhb += 1L;
      }
    }
    AppMethodBeat.o(235573);
  }
  
  public final void setSpatiotemporalDenosing(int paramInt)
  {
    AppMethodBeat.i(235572);
    Log.i("MicroMsg.Voip.NewVoipMgr", "setSpatiotemporalDenosing, isON: " + paramInt + "，mVoipUI: " + this.GTY);
    Object localObject1;
    Object localObject2;
    if (this.GTX != null)
    {
      localObject1 = this.GTX;
      Log.i("MicroMsg.VoIPRenderMgr", "setSpatiotemporalDenosing, mIsStarted:%b, isON:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.voip.video.render.j)localObject1).mIsStarted), Integer.valueOf(paramInt) });
      ((com.tencent.mm.plugin.voip.video.render.j)localObject1).GUD = paramInt;
      if ((paramInt == 1) && (!v2protocal.Har) && (((com.tencent.mm.plugin.voip.video.render.j)localObject1).HnU != null))
      {
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.j)localObject1).HnU;
        if (localObject2 == null) {
          p.hyc();
        }
        if (((com.tencent.mm.plugin.voip.video.camera.a.a)localObject2).fLc() != null)
        {
          localObject2 = ((com.tencent.mm.plugin.voip.video.render.j)localObject1).HnU;
          if (localObject2 == null) {
            p.hyc();
          }
          localObject2 = ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject2).fLc();
          if (localObject2 == null) {
            break label295;
          }
          i = ((ac)localObject2).width;
          if (i < 1280)
          {
            localObject2 = ((com.tencent.mm.plugin.voip.video.render.j)localObject1).HnU;
            if (localObject2 == null) {
              p.hyc();
            }
            localObject2 = ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject2).fLc();
            if (localObject2 == null) {
              break label300;
            }
          }
        }
      }
    }
    label295:
    label300:
    for (int i = ((ac)localObject2).height;; i = 0)
    {
      if (i >= 1280)
      {
        ((com.tencent.mm.plugin.voip.video.render.j)localObject1).GUD = 0;
        Log.i("MicroMsg.VoIPRenderMgr", "The default capturing resolution is 720p, but the 720p capturing is not enabled, close the stFiter");
      }
      ((com.tencent.mm.plugin.voip.video.render.j)localObject1).onOrientationChange(((com.tencent.mm.plugin.voip.video.render.j)localObject1).kyf);
      localObject2 = ((com.tencent.mm.plugin.voip.video.render.j)localObject1).HnX;
      if (localObject2 != null)
      {
        i = ((com.tencent.mm.plugin.voip.video.render.j)localObject1).GUD;
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.m)localObject2).Hpj;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.g)localObject2).aea(i);
        }
      }
      ((com.tencent.mm.plugin.voip.video.render.j)localObject1).aeb(((com.tencent.mm.plugin.voip.video.render.j)localObject1).Hir);
      if (this.GTY != null) {
        localObject1 = this.GTY;
      }
      this.GUD = paramInt;
      AppMethodBeat.o(235572);
      return;
      i = 0;
      break;
    }
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(235548);
    if (paramInt != 2) {
      this.GTV.fJP();
    }
    for (;;)
    {
      this.GUk = paramInt;
      AppMethodBeat.o(235548);
      return;
      if ((this.GUk != 2) && (!com.tencent.mm.plugin.voip.b.k.adQ(this.GTW.mState)))
      {
        getContext();
        gWP();
      }
    }
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(235571);
    Log.i("MicroMsg.Voip.NewVoipMgr", "setVoIPBeauty, isON: " + paramInt + "，mVoipUI: " + this.GTY);
    if (this.GTX != null)
    {
      com.tencent.mm.plugin.voip.video.render.j localj = this.GTX;
      Log.i("MicroMsg.VoIPRenderMgr", "setVoIPBeauty, mIsStarted:%b, isON:%d", new Object[] { Boolean.valueOf(localj.mIsStarted), Integer.valueOf(paramInt) });
      localj.GUC = paramInt;
      Object localObject = localj.HnX;
      if (localObject != null)
      {
        int i = localj.GUC;
        localObject = ((com.tencent.mm.plugin.voip.video.render.m)localObject).Hpj;
        if (localObject != null) {
          ((com.tencent.mm.plugin.voip.video.render.g)localObject).adZ(i);
        }
      }
      localj.onOrientationChange(localj.kyf);
      localj.aeb(localj.Hir);
    }
    if (this.GTY != null) {
      this.GTY.adz(paramInt);
    }
    if ((paramInt != 0) && (this.GUC != paramInt)) {
      com.tencent.mm.plugin.report.service.h.CyF.n(914L, 20L, 1L);
    }
    this.GUC = paramInt;
    AppMethodBeat.o(235571);
  }
  
  public final void wQ(boolean paramBoolean)
  {
    AppMethodBeat.i(235516);
    int j = com.tencent.mm.plugin.voip.b.k.aQ(false, paramBoolean);
    int i = j;
    if (this.GUh)
    {
      if (j != 0) {
        break label80;
      }
      i = 1;
    }
    for (;;)
    {
      this.GTW = com.tencent.mm.plugin.voip.b.k.adN(i);
      Log.i("MicroMsg.Voip.NewVoipMgr", "steve:[simucall] resetStateMachine, initState:%d,isOutCall:%s,isVideoCall:%s", new Object[] { Integer.valueOf(i), Boolean.FALSE, Boolean.valueOf(paramBoolean) });
      this.GUf = false;
      AppMethodBeat.o(235516);
      return;
      label80:
      i = j;
      if (256 == j) {
        i = 257;
      }
    }
  }
  
  public final void wU(boolean paramBoolean)
  {
    AppMethodBeat.i(235517);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.GTV.cV(paramBoolean);
    this.GTV.HgE = true;
    AppMethodBeat.o(235517);
  }
  
  public final void wV(boolean paramBoolean)
  {
    AppMethodBeat.i(235544);
    if (this.GTX != null)
    {
      com.tencent.mm.plugin.voip.video.render.j localj = this.GTX;
      localj.HdG = paramBoolean;
      localj.setHWDecMode(localj.HdK);
    }
    AppMethodBeat.o(235544);
  }
  
  public final void wW(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(235568);
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
    if (com.tencent.mm.plugin.voip.b.k.adP(this.GTW.mState))
    {
      str1 = MMApplicationContext.getContext().getString(2131767241, new Object[] { AF(Util.secondsToNow(this.GUl)) });
      if ((!this.GUf) && (!com.tencent.mm.plugin.voip.b.k.adP(this.GTW.mState))) {
        break label289;
      }
      str3 = this.GUe.field_username;
      if (!this.GUg) {
        break label276;
      }
      str2 = ca.OqC;
      if (!this.GUf) {
        break label284;
      }
      i = 1;
      s.c(str3, str2, i, 6, str1);
      this.GTV.xq(this.GUg);
      this.GUc = com.tencent.mm.plugin.voip.b.k.adP(this.GTW.mState);
      if (!fFW()) {
        break label359;
      }
      this.GUi = 4106;
      com.tencent.mm.plugin.voip.c.fFg().fIl();
      if (!this.GUI)
      {
        k = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId;
        l = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH;
        if (!this.GUf) {
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
      com.tencent.mm.plugin.voip.b.e.c(k, l, i, 4);
      this.GUI = true;
      AppMethodBeat.o(235568);
      return;
      if (this.GUf)
      {
        str1 = MMApplicationContext.getContext().getString(2131767237);
        break;
      }
      str1 = MMApplicationContext.getContext().getString(2131767235);
      break;
      str2 = ca.OqB;
      break label103;
      i = 0;
      break label112;
      if ((this.GUf) || (!paramBoolean)) {
        break label125;
      }
      str3 = this.GUe.field_username;
      if (this.GUg)
      {
        str2 = ca.OqC;
        if (!this.GUf) {
          break label354;
        }
      }
      for (i = 1;; i = 0)
      {
        s.c(str3, str2, i, 6, str1);
        break;
        str2 = ca.OqB;
        break label321;
      }
      xN(4106);
      fFP();
      break label164;
    }
  }
  
  public final boolean wX(final boolean paramBoolean)
  {
    AppMethodBeat.i(235589);
    if (com.tencent.mm.plugin.voip.c.fFg().GZh)
    {
      Log.i("MicroMsg.Voip.NewVoipMgr", "current state is mini, cannot mini!");
      AppMethodBeat.o(235589);
      return false;
    }
    if ((this.GUw) && (!paramBoolean))
    {
      Log.i("MicroMsg.Voip.NewVoipMgr", "has phone call  cannot mini!");
      AppMethodBeat.o(235589);
      return false;
    }
    Log.printDebugStack("MicroMsg.Voip.NewVoipMgr", "miniOnlyHidenVoip: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Log.i("MicroMsg.Voip.NewVoipMgr", "onMinimizeVoip, async to minimize");
    if (this.GTY != null)
    {
      this.GTY.uninit();
      this.GTY = null;
      this.GTV.b(this.GTY);
    }
    this.iGC = Util.currentTicks();
    if (this.GUv != null) {
      this.GUv.uninit();
    }
    if (this.kAn != null) {
      this.kAn.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(235490);
          NewVoipMgr.c(NewVoipMgr.this, paramBoolean);
          AppMethodBeat.o(235490);
        }
      });
    }
    AppMethodBeat.o(235589);
    return true;
  }
  
  public class NetChangedBroadcastReceiver
    extends BroadcastReceiver
  {
    public NetChangedBroadcastReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int j = 0;
      int i = 0;
      AppMethodBeat.i(235513);
      if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
      {
        switch (com.tencent.mm.plugin.voip.b.e.getNetType(paramContext))
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
                AppMethodBeat.o(235513);
                return;
              } while (NewVoipMgr.i(NewVoipMgr.this) == 5);
              j = NewVoipMgr.fGd()[1];
              if (NewVoipMgr.j(NewVoipMgr.this) == 0) {
                NewVoipMgr.a(NewVoipMgr.this, 4);
              }
            } while (NewVoipMgr.j(NewVoipMgr.this) == 0);
            k = NewVoipMgr.fGe() / NewVoipMgr.j(NewVoipMgr.this);
            NewVoipMgr.a(NewVoipMgr.this, 5);
            m = NewVoipMgr.fGd()[0];
            Log.i("MicroMsg.Voip.NewVoipMgr", "befor change to 4G and cost " + NewVoipMgr.k(NewVoipMgr.this));
            if (NewVoipMgr.e(NewVoipMgr.this)) {}
            for (;;)
            {
              com.tencent.mm.plugin.voip.b.e.a(i, System.currentTimeMillis(), NewVoipMgr.i(NewVoipMgr.this), 5, j, m, k);
              NewVoipMgr.l(NewVoipMgr.this);
              NewVoipMgr.b(NewVoipMgr.this, 5);
              NewVoipMgr.fGf();
              NewVoipMgr.m(NewVoipMgr.this);
              AppMethodBeat.o(235513);
              return;
              i = 1;
            }
          } while (NewVoipMgr.i(NewVoipMgr.this) == 4);
          k = NewVoipMgr.fGd()[0];
          if (NewVoipMgr.j(NewVoipMgr.this) == 0) {
            NewVoipMgr.a(NewVoipMgr.this, 5);
          }
        } while (NewVoipMgr.j(NewVoipMgr.this) == 0);
        int m = NewVoipMgr.fGe() / NewVoipMgr.j(NewVoipMgr.this);
        NewVoipMgr.a(NewVoipMgr.this, 4);
        int n = NewVoipMgr.fGd()[1];
        Log.i("MicroMsg.Voip.NewVoipMgr", "befor change to wifi and cost " + NewVoipMgr.k(NewVoipMgr.this));
        if (NewVoipMgr.e(NewVoipMgr.this)) {}
        for (i = j;; i = 1)
        {
          com.tencent.mm.plugin.voip.b.e.a(i, System.currentTimeMillis(), NewVoipMgr.i(NewVoipMgr.this), 4, k, n, m);
          NewVoipMgr.l(NewVoipMgr.this);
          NewVoipMgr.b(NewVoipMgr.this, 4);
          NewVoipMgr.fGf();
          NewVoipMgr.m(NewVoipMgr.this);
          break;
        }
      }
      if ((paramIntent.getAction().equals("android.net.wifi.STATE_CHANGE")) && (NewVoipMgr.n(NewVoipMgr.this) == 0L))
      {
        NewVoipMgr.a(NewVoipMgr.this, System.currentTimeMillis());
        AppMethodBeat.o(235513);
        return;
      }
      if ((paramIntent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) && (NewVoipMgr.n(NewVoipMgr.this) != 0L))
      {
        NewVoipMgr.b(NewVoipMgr.this, System.currentTimeMillis() - NewVoipMgr.n(NewVoipMgr.this));
        NewVoipMgr.a(NewVoipMgr.this, 0L);
      }
      AppMethodBeat.o(235513);
    }
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(235512);
      NewVoipMgr.r(NewVoipMgr.this);
      NewVoipMgr.s(NewVoipMgr.this);
      AppMethodBeat.o(235512);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.NewVoipMgr
 * JD-Core Version:    0.7.0.1
 */