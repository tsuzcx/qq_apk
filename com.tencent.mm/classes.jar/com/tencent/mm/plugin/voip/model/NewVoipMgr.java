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
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.view.SurfaceHolder;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.g.a.ya;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.g.a.zd;
import com.tencent.mm.g.a.zd.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.voip.b.n;
import com.tencent.mm.plugin.voip.ui.VoipScoreDialog;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView.b;
import com.tencent.mm.plugin.voip.video.render.j;
import com.tencent.mm.plugin.voip.video.render.j.b;
import com.tencent.mm.plugin.voip.video.render.j.c;
import com.tencent.mm.plugin.voip.video.render.j.d;
import com.tencent.mm.plugin.voip.video.render.j.e;
import com.tencent.mm.plugin.voip.video.render.j.f;
import com.tencent.mm.plugin.voip.video.render.j.g;
import com.tencent.mm.plugin.voip.video.render.j.h;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import d.g.b.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class NewVoipMgr
  extends com.tencent.mm.plugin.voip.a
  implements com.tencent.mm.plugin.voip.video.render.b
{
  static int[] BZB = new int[2];
  static int lwn = 0;
  private volatile com.tencent.mm.plugin.voip.ui.b BYA;
  private a BYB;
  private boolean BYC;
  private boolean BYD;
  private boolean BYE;
  private Object BYF;
  private am BYG;
  boolean BYH;
  private boolean BYI;
  private boolean BYJ;
  private int BYK;
  private boolean BYL;
  private int BYM;
  private long BYN;
  private boolean BYO;
  private boolean BYP;
  private boolean BYQ;
  private boolean BYR;
  private int BYS;
  private int BYT;
  private com.tencent.mm.plugin.voip.video.k BYU;
  private av BYV;
  private boolean BYW;
  private boolean BYX;
  private int BYY;
  private boolean BYZ;
  private com.tencent.mm.plugin.voip.b.c BYx;
  private com.tencent.mm.plugin.voip.b.m BYy;
  private j BYz;
  ap BZA;
  private long BZC;
  private boolean BZD;
  private int BZE;
  private int BZF;
  private com.tencent.mm.plugin.voip.b.i BZG;
  private BroadcastReceiver BZH;
  private BroadcastReceiver BZI;
  int BZJ;
  private com.tencent.mm.sdk.b.c BZK;
  private int BZa;
  private boolean BZb;
  private com.tencent.mm.plugin.voip.widget.b BZc;
  private boolean BZd;
  private boolean BZe;
  private String BZf;
  private boolean BZg;
  private boolean BZh;
  public int BZi;
  public int BZj;
  private long BZk;
  private boolean BZl;
  private long BZm;
  private long BZn;
  private long BZo;
  private long BZp;
  private int BZq;
  boolean BZr;
  boolean BZs;
  private int BZt;
  public int BZu;
  public int BZv;
  int BZw;
  boolean BZx;
  NetChangedBroadcastReceiver BZy;
  PhoneStateListener BZz;
  private long enterTime;
  private String fGM;
  private long hIH;
  private ap jwD;
  private long lastShakeTime;
  PhoneStateListener ljq;
  private boolean mIsMute;
  private int mUIType;
  TelephonyManager oYl;
  private boolean pyt;
  private bk pyu;
  private SensorController pyv;
  private long tlk;
  private TelephonyManager uJU;
  private com.tencent.mm.sdk.b.c uJW;
  private long uMg;
  private boolean vNW;
  
  public NewVoipMgr()
  {
    AppMethodBeat.i(216273);
    this.BYB = null;
    this.BYC = true;
    this.lastShakeTime = -1L;
    this.pyt = false;
    this.BYD = false;
    this.BYE = false;
    this.BYF = new Object();
    this.BYJ = false;
    this.BYK = 4096;
    this.BYL = false;
    this.BYM = -1;
    this.mIsMute = false;
    this.BYN = -1L;
    this.BYO = false;
    this.BYP = false;
    this.BYQ = false;
    this.vNW = false;
    this.BYR = false;
    this.BYS = 0;
    this.BYT = 0;
    this.BYU = new com.tencent.mm.plugin.voip.video.k();
    this.BYV = null;
    this.BYW = false;
    this.BYX = false;
    this.BYY = 0;
    this.BYZ = false;
    this.BZa = -1;
    this.BZb = false;
    this.BZd = false;
    this.BZe = false;
    this.BZf = null;
    this.BZg = true;
    this.BZh = false;
    this.BZi = -1;
    this.BZj = 0;
    this.BZk = -1L;
    this.BZl = false;
    this.BZm = 0L;
    this.BZn = -1L;
    this.BZo = 0L;
    this.BZp = 0L;
    this.BZq = 0;
    this.BZr = false;
    this.BZs = false;
    this.BZt = 0;
    this.BZu = 0;
    this.BZv = 0;
    this.BZw = 0;
    this.BZx = false;
    this.BZA = new ap("getSignalStrength");
    this.oYl = null;
    this.tlk = 0L;
    this.BZC = 0L;
    this.BZD = false;
    this.BZE = 0;
    this.BZF = 0;
    this.BZH = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(216243);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        paramAnonymousIntent = (PowerManager)aj.getContext().getSystemService("power");
        if (("android.intent.action.USER_PRESENT".equals(paramAnonymousContext)) && (paramAnonymousIntent.isScreenOn()))
        {
          if (NewVoipMgr.a(NewVoipMgr.this) != null)
          {
            NewVoipMgr.a(NewVoipMgr.this).BYR = false;
            AppMethodBeat.o(216243);
          }
        }
        else
        {
          if ("android.intent.action.SCREEN_ON".equals(paramAnonymousContext))
          {
            if (NewVoipMgr.a(NewVoipMgr.this) != null) {
              NewVoipMgr.a(NewVoipMgr.this).BYR = false;
            }
            NewVoipMgr.this.kn(true);
            AppMethodBeat.o(216243);
            return;
          }
          if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousContext))
          {
            if (NewVoipMgr.a(NewVoipMgr.this) != null) {
              NewVoipMgr.a(NewVoipMgr.this).BYR = true;
            }
            if (!NewVoipMgr.b(NewVoipMgr.this)) {
              NewVoipMgr.this.kn(true);
            }
            if ((!com.tencent.mm.plugin.voip.b.l.UN(NewVoipMgr.c(NewVoipMgr.this).mState)) && (!NewVoipMgr.d(NewVoipMgr.this))) {
              com.tencent.mm.plugin.voip.c.euM().CdF.stopRing();
            }
          }
        }
        AppMethodBeat.o(216243);
      }
    };
    this.BZI = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(216259);
        if ((paramAnonymousIntent.getAction().equals("com.tencent.mm.foregroundDestroy")) && (com.tencent.mm.plugin.voip.c.euM().dfP) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qwN, false))) {
          com.tencent.mm.plugin.voip.c.euM().a(NewVoipMgr.e(NewVoipMgr.this), NewVoipMgr.f(NewVoipMgr.this), true, com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.uLt);
        }
        AppMethodBeat.o(216259);
      }
    };
    this.uJW = new com.tencent.mm.sdk.b.c() {};
    this.BZJ = 0;
    this.uMg = 0L;
    this.ljq = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        int i = 1;
        AppMethodBeat.i(216249);
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        ad.i("MicroMsg.Voip.NewVoipMgr", "onCallStateChanged :%d, isStartVoip: %b,oldState:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(NewVoipMgr.t(NewVoipMgr.this)), Integer.valueOf(NewVoipMgr.u(NewVoipMgr.this)) });
        if (!NewVoipMgr.t(NewVoipMgr.this))
        {
          AppMethodBeat.o(216249);
          return;
        }
        if (((NewVoipMgr.u(NewVoipMgr.this) == 0) && (paramAnonymousInt == 1)) || ((NewVoipMgr.u(NewVoipMgr.this) == 0) && (paramAnonymousInt == 2))) {
          NewVoipMgr.v(NewVoipMgr.this);
        }
        if (paramAnonymousInt == 1)
        {
          NewVoipMgr.a(NewVoipMgr.this, true);
          if (NewVoipMgr.u(NewVoipMgr.this) == 0) {
            NewVoipMgr.d(NewVoipMgr.this, System.currentTimeMillis());
          }
          NewVoipMgr.c(NewVoipMgr.this, 1);
          com.tencent.mm.plugin.voip.c.euM().Ug(1);
          NewVoipMgr.b(NewVoipMgr.this, true);
        }
        label327:
        label361:
        do
        {
          NewVoipMgr.n(NewVoipMgr.this).BZD = NewVoipMgr.C(NewVoipMgr.this);
          AppMethodBeat.o(216249);
          return;
          if (paramAnonymousInt == 2)
          {
            NewVoipMgr.a(NewVoipMgr.this, false);
            if (NewVoipMgr.u(NewVoipMgr.this) == 1) {
              NewVoipMgr.e(NewVoipMgr.this, System.currentTimeMillis());
            }
            NewVoipMgr.c(NewVoipMgr.this, 2);
            ad.i("MicroMsg.Voip.NewVoipMgr", "phone call coming now!");
            if ((NewVoipMgr.d(NewVoipMgr.this)) && (!com.tencent.mm.plugin.voip.b.l.UN(NewVoipMgr.c(NewVoipMgr.this).mState))) {
              com.tencent.mm.plugin.voip.c.euM().CdF.exT();
            }
            String str2;
            String str1;
            if (com.tencent.mm.plugin.voip.b.l.UN(NewVoipMgr.c(NewVoipMgr.this).mState))
            {
              paramAnonymousString = aj.getContext().getString(2131764803, new Object[] { NewVoipMgr.Bv(bt.rM(NewVoipMgr.w(NewVoipMgr.this))) });
              com.tencent.mm.plugin.voip.c.euM().exu();
              str2 = NewVoipMgr.x(NewVoipMgr.this).field_username;
              if (!NewVoipMgr.f(NewVoipMgr.this)) {
                break label596;
              }
              str1 = bu.IMe;
              if (!NewVoipMgr.d(NewVoipMgr.this)) {
                break label604;
              }
            }
            for (paramAnonymousInt = i;; paramAnonymousInt = 0)
            {
              s.c(str2, str1, paramAnonymousInt, 6, paramAnonymousString);
              NewVoipMgr.d(NewVoipMgr.this, 4107);
              NewVoipMgr.y(NewVoipMgr.this);
              paramAnonymousString = new bu();
              paramAnonymousString.setType(10000);
              paramAnonymousString.qA(System.currentTimeMillis());
              paramAnonymousString.setStatus(6);
              paramAnonymousString.setContent(aj.getContext().getString(2131764801) + ", <a href=\"weixin://voip/callagain/?username=" + NewVoipMgr.e(NewVoipMgr.this) + "&isvideocall=" + NewVoipMgr.f(NewVoipMgr.this) + "\">" + aj.getContext().getString(2131764796) + "</a>");
              if ((NewVoipMgr.e(NewVoipMgr.this) != null) && (!NewVoipMgr.e(NewVoipMgr.this).equals("")))
              {
                paramAnonymousString.tN(NewVoipMgr.e(NewVoipMgr.this));
                ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().as(paramAnonymousString);
              }
              com.tencent.mm.plugin.voip.c.euM().Ug(2);
              NewVoipMgr.b(NewVoipMgr.this, false);
              break;
              paramAnonymousString = aj.getContext().getString(2131764799);
              break label327;
              str1 = bu.IMd;
              break label361;
            }
          }
        } while (paramAnonymousInt != 0);
        label596:
        label604:
        if ((NewVoipMgr.u(NewVoipMgr.this) == 1) || (NewVoipMgr.u(NewVoipMgr.this) == 2)) {
          NewVoipMgr.e(NewVoipMgr.this, System.currentTimeMillis());
        }
        NewVoipMgr.c(NewVoipMgr.this, 0);
        com.tencent.mm.plugin.voip.c.euM().Ug(2);
        if ((1 == NewVoipMgr.z(NewVoipMgr.this)) && (com.tencent.mm.plugin.voip.b.l.UN(NewVoipMgr.c(NewVoipMgr.this).mState)) && (NewVoipMgr.A(NewVoipMgr.this))) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(216245);
              NewVoipMgr.n(NewVoipMgr.this).cn(true);
              AppMethodBeat.o(216245);
            }
          });
        }
        if ((4 == NewVoipMgr.z(NewVoipMgr.this)) && (NewVoipMgr.A(NewVoipMgr.this))) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(216246);
              NewVoipMgr.n(NewVoipMgr.this).aB(NewVoipMgr.B(NewVoipMgr.this), NewVoipMgr.f(NewVoipMgr.this));
              AppMethodBeat.o(216246);
            }
          });
        }
        NewVoipMgr.a(NewVoipMgr.this, false);
        if ((com.tencent.mm.compatible.b.g.ZJ() != null) && (com.tencent.mm.plugin.audio.c.a.bGC().isBluetoothScoOn()))
        {
          ad.i("MicroMsg.Voip.NewVoipMgr", "is bluetooth can use and start bluetooth");
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(216247);
              NewVoipMgr.n(NewVoipMgr.this).aB(NewVoipMgr.B(NewVoipMgr.this), NewVoipMgr.f(NewVoipMgr.this));
              AppMethodBeat.o(216247);
            }
          });
        }
        for (;;)
        {
          NewVoipMgr.b(NewVoipMgr.this, false);
          break;
          if (com.tencent.mm.plugin.audio.c.a.bGC().bGx()) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(216248);
                NewVoipMgr.n(NewVoipMgr.this).aB(NewVoipMgr.B(NewVoipMgr.this), NewVoipMgr.f(NewVoipMgr.this));
                AppMethodBeat.o(216248);
              }
            });
          }
        }
      }
    };
    this.hIH = -1L;
    this.enterTime = -1L;
    this.BZK = new com.tencent.mm.sdk.b.c() {};
    this.BYx = new com.tencent.mm.plugin.voip.b.c();
    AppMethodBeat.o(216273);
  }
  
  private void TN(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(216297);
    ad.i("MicroMsg.Voip.NewVoipMgr", "hangupTalkingOrCancelInvite");
    if (true == evA()) {
      this.BYK = paramInt;
    }
    Object localObject = aj.getContext();
    String str2;
    if (com.tencent.mm.plugin.voip.b.l.UN(this.BYy.mState))
    {
      localObject = ((Context)localObject).getString(2131764803, new Object[] { sm(bt.rM(this.BYN)) });
      str2 = this.BYG.field_username;
      if (!this.BYI) {
        break label251;
      }
    }
    label251:
    for (String str1 = bu.IMe;; str1 = bu.IMd)
    {
      if (this.BYH) {
        i = 1;
      }
      s.c(str2, str1, i, 6, (String)localObject);
      if ((!this.BYH) || (com.tencent.mm.plugin.voip.b.l.UN(this.BYy.mState))) {
        break label259;
      }
      evn();
      if ((this.BYH) && (!com.tencent.mm.plugin.voip.b.l.UN(this.BYy.mState)))
      {
        ad.i("MicroMsg.Voip.NewVoipMgr", "hangupVoipButton OnClick call cancelCall");
        com.tencent.mm.plugin.voip.c.euM().CdF.exS();
      }
      ad.i("MicroMsg.Voip.NewVoipMgr", "hangupVoipButton OnClick call hangUp");
      com.tencent.mm.plugin.voip.c.euM().CdF.exV();
      if (4096 != this.BYK) {
        break label315;
      }
      tK(paramInt);
      evs();
      AppMethodBeat.o(216297);
      return;
      if (this.BYH)
      {
        localObject = ((Context)localObject).getString(2131764798);
        break;
      }
      localObject = ((Context)localObject).getString(2131764797);
      break;
    }
    label259:
    com.tencent.e.h.LTJ.aR(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "VoipMgr_play_end_sound";
      }
      
      public final void run()
      {
        AppMethodBeat.i(216268);
        NewVoipMgr.n(NewVoipMgr.this);
        com.tencent.mm.plugin.voip.b.c.tz(NewVoipMgr.f(NewVoipMgr.this));
        AppMethodBeat.o(216268);
      }
    });
    this.BYD = true;
    this.BYE = true;
    com.tencent.mm.plugin.voip.c.euM().CdF.exV();
    if (4096 == this.BYK)
    {
      tK(paramInt);
      evs();
    }
    label315:
    AppMethodBeat.o(216297);
  }
  
  private boolean TO(int paramInt)
  {
    AppMethodBeat.i(216315);
    if (4111 == paramInt)
    {
      AppMethodBeat.o(216315);
      return true;
    }
    if ((4101 == paramInt) && ((com.tencent.mm.plugin.voip.b.l.UN(this.BYy.mState)) || (this.BYH)))
    {
      AppMethodBeat.o(216315);
      return true;
    }
    AppMethodBeat.o(216315);
    return false;
  }
  
  private static void TP(int paramInt)
  {
    AppMethodBeat.i(216316);
    zd localzd = new zd();
    localzd.dOk.dkM = paramInt;
    com.tencent.mm.sdk.b.a.IbL.l(localzd);
    AppMethodBeat.o(216316);
  }
  
  private boolean d(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(216343);
    String str = com.tencent.mm.n.g.acA().getValue("VOIPShortcutAutoadd");
    ad.i("MicroMsg.Voip.NewVoipMgr", "voip shortcut autoAdd is %s", new Object[] { str });
    if ((str != null) && (str.equals("0")) && (bt.rM(this.BYN) > 30L))
    {
      int i = paramSharedPreferences.getInt("voip_shortcut_prompt_times", 0);
      boolean bool = paramSharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
      if ((i < 3) && (!bool))
      {
        evB();
        paramSharedPreferences.edit().putInt("voip_shortcut_prompt_times", i + 1).commit();
        AppMethodBeat.o(216343);
        return true;
      }
    }
    else if ((str != null) && (str.equals("1")) && (bt.rM(this.BYN) > 15L))
    {
      e(paramSharedPreferences);
      AppMethodBeat.o(216343);
      return false;
    }
    AppMethodBeat.o(216343);
    return false;
  }
  
  private void e(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(216344);
    Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
    localIntent1.putExtra("duplicate", false);
    Intent localIntent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
    localIntent2.addFlags(67108864);
    if (1 == bt.getInt(com.tencent.mm.n.g.acA().getValue("VOIPCallType"), 0))
    {
      localIntent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(2131755762));
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getContext(), 2131234560));
      localIntent1.putExtra("shortcut_icon_resource_id", 2131234560);
    }
    for (;;)
    {
      localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
      com.tencent.mm.plugin.base.model.b.p(getContext(), localIntent1);
      paramSharedPreferences.edit().putBoolean("voip_shortcut_has_added", true).commit();
      AppMethodBeat.o(216344);
      return;
      localIntent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(2131755764));
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getContext(), 2131234599));
      localIntent1.putExtra("shortcut_icon_resource_id", 2131234599);
    }
  }
  
  private boolean evA()
  {
    AppMethodBeat.i(216342);
    if (com.tencent.mm.plugin.voip.b.l.UN(this.BYy.mState))
    {
      SharedPreferences localSharedPreferences = getContext().getSharedPreferences("voip_plugin_prefs", 0);
      if (!localSharedPreferences.getBoolean("voip_shortcut_has_added", false))
      {
        boolean bool = d(localSharedPreferences);
        AppMethodBeat.o(216342);
        return bool;
      }
    }
    AppMethodBeat.o(216342);
    return false;
  }
  
  private void evB()
  {
    AppMethodBeat.i(216346);
    Context localContext = getContext();
    View localView = View.inflate(localContext, 2131494763, null);
    final CheckBox localCheckBox = (CheckBox)localView.findViewById(2131302304);
    localCheckBox.setChecked(false);
    TextView localTextView = (TextView)localView.findViewById(2131302306);
    if (1 == bt.getInt(com.tencent.mm.n.g.acA().getValue("VOIPCallType"), 0)) {
      localTextView.setText(2131764786);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(localContext, false, localContext.getString(2131755906), localView, localContext.getString(2131755939), localContext.getString(2131755831), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(216251);
          paramAnonymousDialogInterface = NewVoipMgr.D(NewVoipMgr.this).getSharedPreferences("voip_plugin_prefs", 0);
          NewVoipMgr.a(NewVoipMgr.this, paramAnonymousDialogInterface);
          if (4096 != NewVoipMgr.E(NewVoipMgr.this))
          {
            NewVoipMgr.d(NewVoipMgr.this, NewVoipMgr.E(NewVoipMgr.this));
            NewVoipMgr.F(NewVoipMgr.this);
          }
          if (NewVoipMgr.G(NewVoipMgr.this) != null) {
            NewVoipMgr.G(NewVoipMgr.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(216250);
                NewVoipMgr.p(NewVoipMgr.this);
                AppMethodBeat.o(216250);
              }
            });
          }
          AppMethodBeat.o(216251);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(216253);
          if (localCheckBox != null) {
            NewVoipMgr.D(NewVoipMgr.this).getSharedPreferences("voip_plugin_prefs", 0).edit().putBoolean("voip_shortcut_never_show_anymore", localCheckBox.isChecked()).commit();
          }
          if (4096 != NewVoipMgr.E(NewVoipMgr.this))
          {
            NewVoipMgr.d(NewVoipMgr.this, NewVoipMgr.E(NewVoipMgr.this));
            NewVoipMgr.F(NewVoipMgr.this);
          }
          if (NewVoipMgr.G(NewVoipMgr.this) != null) {
            NewVoipMgr.G(NewVoipMgr.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(216252);
                NewVoipMgr.p(NewVoipMgr.this);
                AppMethodBeat.o(216252);
              }
            });
          }
          AppMethodBeat.o(216253);
        }
      });
      AppMethodBeat.o(216346);
      return;
      localTextView.setText(2131764787);
    }
  }
  
  private void evF()
  {
    AppMethodBeat.i(216351);
    if (this.BYU != null) {
      this.BYU.b(this);
    }
    if (this.BYV != null)
    {
      ad.d("MicroMsg.Voip.NewVoipMgr", "stop face detect timer");
      this.BYV.stopTimer();
    }
    AppMethodBeat.o(216351);
  }
  
  private boolean evq()
  {
    int j = 0;
    AppMethodBeat.i(216311);
    if (!this.BYy.UR(4101))
    {
      AppMethodBeat.o(216311);
      return false;
    }
    this.BYI = false;
    if (this.BZc != null) {
      this.BZc.BYI = false;
    }
    tK(4101);
    Object localObject1;
    int k;
    int i;
    Object localObject3;
    Object localObject2;
    if ((261 == this.BYy.mState) || (7 == this.BYy.mState))
    {
      com.tencent.mm.plugin.voip.c.euM().Ue(1);
      localObject1 = com.tencent.mm.plugin.report.service.g.yhR;
      long l = com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.uLt;
      k = com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.roomId;
      if (this.BYH)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.g)localObject1).f(11046, new Object[] { Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(k), Integer.valueOf(0), Integer.valueOf(i) });
        localObject3 = com.tencent.mm.plugin.report.service.g.yhR;
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
      ((com.tencent.mm.plugin.report.service.g)localObject3).f(k, (Object[])localObject2);
      do
      {
        com.tencent.mm.plugin.voip.c.euM().CdF.BXC.ewe();
        com.tencent.mm.plugin.voip.c.euM().CdF.BXC.ewf();
        AppMethodBeat.o(216311);
        return true;
        i = 0;
        break;
      } while ((1 != this.BYy.mState) && (3 != this.BYy.mState));
      com.tencent.mm.plugin.voip.c.euM().Ue(1);
      com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
      k = 11046;
      localObject1 = new Object[5];
      localObject1[0] = Integer.valueOf(1);
      localObject1[1] = Long.valueOf(com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.uLt);
      localObject1[2] = Integer.valueOf(com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.roomId);
      localObject1[3] = Integer.valueOf(0);
      i = 4;
      if (this.BYH)
      {
        j = 1;
        localObject2 = localObject1;
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localg;
      }
      else
      {
        localObject2 = localObject1;
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localg;
      }
    }
  }
  
  private void evs()
  {
    AppMethodBeat.i(216321);
    ad.d("MicroMsg.Voip.NewVoipMgr", "delayFinish");
    this.BZf = null;
    if (this.jwD != null) {
      this.jwD.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(216270);
          NewVoipMgr localNewVoipMgr = NewVoipMgr.this;
          ad.i("MicroMsg.Voip.NewVoipMgr", "it is uninit voip report");
          if (localNewVoipMgr.BZA != null)
          {
            localNewVoipMgr.BZA.removeCallbacksAndMessages(null);
            localNewVoipMgr.BZA.quit();
          }
          if (!localNewVoipMgr.BZx)
          {
            if (localNewVoipMgr.BZJ == 0) {
              localNewVoipMgr.TM(localNewVoipMgr.BZw);
            }
            if (localNewVoipMgr.BZJ != 0)
            {
              localNewVoipMgr.BZx = true;
              if (!localNewVoipMgr.BYH) {
                break label183;
              }
            }
          }
          label183:
          for (int i = 0;; i = 1)
          {
            com.tencent.mm.plugin.voip.b.f.a(i, System.currentTimeMillis(), localNewVoipMgr.BZw, localNewVoipMgr.BZw, 0, 0, NewVoipMgr.lwn / localNewVoipMgr.BZJ);
            NewVoipMgr.lwn = 0;
            NewVoipMgr.BZB[0] = 0;
            NewVoipMgr.BZB[1] = 0;
            localNewVoipMgr.BZJ = 0;
            if (localNewVoipMgr.oYl != null) {
              localNewVoipMgr.oYl.listen(localNewVoipMgr.BZz, 0);
            }
            if (localNewVoipMgr.BZy != null)
            {
              aj.getContext().unregisterReceiver(localNewVoipMgr.BZy);
              localNewVoipMgr.BZy = null;
            }
            NewVoipMgr.p(NewVoipMgr.this);
            AppMethodBeat.o(216270);
            return;
          }
        }
      }, 500L);
    }
    AppMethodBeat.o(216321);
  }
  
  private static void evt()
  {
    AppMethodBeat.i(216323);
    yb localyb = new yb();
    localyb.dMo.dsi = 11;
    com.tencent.mm.sdk.b.a.IbL.l(localyb);
    AppMethodBeat.o(216323);
  }
  
  private void evz()
  {
    AppMethodBeat.i(216338);
    synchronized (this.BYF)
    {
      evF();
      if (this.BYz != null) {
        this.BYz.release();
      }
      com.tencent.mm.plugin.voip.b.c.unInit();
      this.BYx.evz();
      AppMethodBeat.o(216338);
      return;
    }
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(216345);
    Context localContext1 = null;
    if (this.BYA != null) {
      localContext1 = this.BYA.eyI();
    }
    Context localContext2 = localContext1;
    if (localContext1 == null) {
      localContext2 = aj.getContext();
    }
    AppMethodBeat.o(216345);
    return localContext2;
  }
  
  private void gg(boolean paramBoolean)
  {
    AppMethodBeat.i(216322);
    ad.i("MicroMsg.Voip.NewVoipMgr", "finish");
    if (this.BZG != null) {
      this.BZG.ezN();
    }
    this.BZb = false;
    this.BZd = false;
    this.lastShakeTime = -1L;
    if (this.BYS != -1)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(11700, new Object[] { Integer.valueOf(this.BYS), Long.valueOf(bt.rM(this.BYN)) });
      this.BYS = -1;
    }
    try
    {
      aj.getContext().unregisterReceiver(this.BZH);
      try
      {
        label105:
        aj.getContext().unregisterReceiver(this.BZI);
        label115:
        com.tencent.mm.sdk.b.a.IbL.d(this.uJW);
        com.tencent.mm.sdk.b.a.IbL.d(this.BZK);
        evF();
        if (this.BYz != null)
        {
          this.BYz.release();
          this.BYz = null;
        }
        if (this.BYA != null)
        {
          this.BYA.uninit();
          this.BYA = null;
          this.BYx.b(this.BYA);
        }
        label237:
        int j;
        label302:
        long l;
        if (com.tencent.mm.plugin.voip.c.euM() != null)
        {
          com.tencent.mm.plugin.voip.c.euM().CdF.stopRing();
          if (paramBoolean)
          {
            com.tencent.mm.plugin.voip.c.euM().exv();
            if (!this.BYI) {
              break label749;
            }
            com.tencent.mm.plugin.voip.c.euM().b(false, true, this.fGM);
            com.tencent.mm.plugin.voip.c.euM().b(aj.getContext(), this);
          }
        }
        else
        {
          this.BYx.doI();
          com.tencent.mm.plugin.voip.c.euM().exG();
          com.tencent.mm.plugin.voip.c.euM().Uo(this.BZj);
          if (!this.BYD) {
            break label764;
          }
          this.BYB = new a();
          com.tencent.e.h.LTJ.aR(this.BYB);
          if ((this.uJU != null) && (this.ljq != null))
          {
            this.uJU.listen(this.ljq, 0);
            this.ljq = null;
          }
          this.uJU = null;
          com.tencent.mm.booter.a.Wt().Wu();
          r.ewQ().ewS();
          r.ewQ().a(null);
          ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
          if (this.pyv != null)
          {
            ad.d("MicroMsg.Voip.NewVoipMgr", "removeSensorCallBack");
            this.pyv.flC();
            this.pyv = null;
            this.BZl = false;
            this.BZm = 0L;
            this.BZk = -1L;
          }
          if (this.pyu != null) {
            this.pyu.flD();
          }
          this.BZn = -1L;
          com.tencent.mm.plugin.voip.c.euM().exJ();
          ad.i("MicroMsg.Voip.NewVoipMgr", "finish, isFinishFromShutdown: %s", new Object[] { Boolean.valueOf(this.BYE) });
          if ((this.BYE) && (com.tencent.mm.plugin.voip.c.euM().exK()))
          {
            com.tencent.mm.plugin.voip.c.euM();
            VoipScoreState.exs();
            Object localObject = new Intent(getContext(), VoipScoreDialog.class);
            ((Intent)localObject).putExtra("key_score_state", com.tencent.mm.plugin.voip.c.euM().exM());
            if (!(getContext() instanceof Activity)) {
              ((Intent)localObject).addFlags(268435456);
            }
            Context localContext = getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          com.tencent.mm.plugin.voip.c.euM().exL();
          evt();
          if (!this.BZs)
          {
            j = com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.roomId;
            l = com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.uLt;
            if (!this.BYH) {
              break label771;
            }
          }
        }
        label771:
        for (int i = 0;; i = 1)
        {
          com.tencent.mm.plugin.voip.b.f.c(j, l, i, 4);
          this.BZs = true;
          ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
          com.tencent.mm.media.g.c.hkn.atJ();
          AppMethodBeat.o(216322);
          return;
          com.tencent.mm.plugin.voip.c.euM().CdF.exV();
          break;
          label749:
          com.tencent.mm.plugin.voip.c.euM().b(false, false, this.fGM);
          break label237;
          label764:
          evz();
          break label302;
        }
      }
      catch (Exception localException1)
      {
        break label115;
      }
    }
    catch (Exception localException2)
    {
      break label105;
    }
  }
  
  private static String sm(long paramLong)
  {
    AppMethodBeat.i(216337);
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
    AppMethodBeat.o(216337);
    return str;
  }
  
  private void tK(final int paramInt)
  {
    AppMethodBeat.i(216314);
    ad.l("MicroMsg.Voip.NewVoipMgr", "swtchState, action: %s, currentState: %s", new Object[] { com.tencent.mm.plugin.voip.b.l.UK(paramInt), com.tencent.mm.plugin.voip.b.l.UK(this.BYy.mState) });
    if ((4101 == paramInt) && (com.tencent.mm.plugin.voip.b.l.UO(this.BYy.mState)))
    {
      evF();
      if (this.BYz != null) {
        this.BYz.release();
      }
      this.BYI = false;
      if (this.BZc != null) {
        this.BZc.BYI = false;
      }
    }
    if (TO(paramInt)) {
      this.BYx.BYP = false;
    }
    if ((TO(paramInt)) && (1 == this.mUIType) && (1 == this.BYM))
    {
      this.BZe = true;
      this.BYx.cn(false);
      if (!com.tencent.mm.plugin.voip.c.euM().CdF.cae())
      {
        this.BYx.evn();
        this.BYx.aC(false, this.BYH);
      }
    }
    this.BYy.US(paramInt);
    if (this.jwD != null) {
      this.jwD.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(216269);
          if (NewVoipMgr.o(NewVoipMgr.this) != null) {
            NewVoipMgr.o(NewVoipMgr.this).iu(paramInt, NewVoipMgr.c(NewVoipMgr.this).mState);
          }
          AppMethodBeat.o(216269);
        }
      });
    }
    switch (this.BYy.mState)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(216314);
      return;
      TP(5);
      AppMethodBeat.o(216314);
      return;
      TP(6);
    }
  }
  
  final void TM(int paramInt)
  {
    AppMethodBeat.i(216289);
    if (paramInt == 5)
    {
      lwn += BZB[0];
      this.BZJ += 1;
      ad.i("MicroMsg.Voip.NewVoipMgr", "mSignalStrength 4G" + BZB[0] + " and index is " + this.BZJ);
      AppMethodBeat.o(216289);
      return;
    }
    WifiManager localWifiManager;
    if (paramInt == 4)
    {
      localWifiManager = (WifiManager)aj.getContext().getApplicationContext().getSystemService("wifi");
      if ((localWifiManager == null) || (localWifiManager.getConnectionInfo() == null)) {}
    }
    for (;;)
    {
      try
      {
        int[] arrayOfInt = BZB;
        if (localWifiManager.getConnectionInfo() != null) {
          continue;
        }
        paramInt = 0;
        arrayOfInt[1] = paramInt;
      }
      catch (Exception localException)
      {
        BZB[1] = 0;
        ad.i("MicroMsg.Voip.NewVoipMgr", "error happened in get wifi info");
        continue;
      }
      lwn += BZB[1];
      this.BZJ += 1;
      ad.i("MicroMsg.Voip.NewVoipMgr", "mSignalStrength WIFI " + BZB[1] + " and index is " + this.BZJ);
      AppMethodBeat.o(216289);
      return;
      paramInt = localWifiManager.getConnectionInfo().getRssi();
    }
  }
  
  public final void TQ(int paramInt)
  {
    AppMethodBeat.i(216328);
    ad.i("MicroMsg.Voip.NewVoipMgr", "remote voip mode changed, cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    if (((1 == paramInt) || (3 == paramInt) || (5 == paramInt) || (6 == paramInt) || (7 == paramInt)) && (this.BYI))
    {
      tK(4101);
      com.tencent.mm.plugin.voip.c.euM().CdF.BXC.ewe();
      com.tencent.mm.plugin.voip.c.euM().CdF.BXC.ewf();
    }
    AppMethodBeat.o(216328);
  }
  
  public final void TR(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(216333);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onSessionBeingCalled, callType: ".concat(String.valueOf(paramInt)));
    if (!this.BYy.UR(4110))
    {
      AppMethodBeat.o(216333);
      return;
    }
    u localu = com.tencent.mm.plugin.voip.c.euM();
    if (paramInt == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramInt == 1) {
        bool2 = true;
      }
      localu.aw(bool1, bool2);
      evn();
      if ((paramInt == 1) && (com.tencent.mm.plugin.voip.b.l.UO(this.BYy.mState))) {
        tK(4101);
      }
      tK(4110);
      AppMethodBeat.o(216333);
      return;
    }
  }
  
  public final void TS(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(216334);
    ad.i("MicroMsg.Voip.NewVoipMgr", "steve:[simucall]onNewSimulCallAutoAccept, callType: ".concat(String.valueOf(paramInt)));
    if (!this.BYy.UR(4100))
    {
      AppMethodBeat.o(216334);
      return;
    }
    u localu = com.tencent.mm.plugin.voip.c.euM();
    if (paramInt == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramInt == 1) {
        bool2 = true;
      }
      localu.aw(bool1, bool2);
      com.tencent.mm.plugin.voip.c.euM().CdF.stopRing();
      if ((paramInt == 1) && (com.tencent.mm.plugin.voip.b.l.UO(this.BYy.mState))) {
        tK(4101);
      }
      tK(4100);
      AppMethodBeat.o(216334);
      return;
    }
  }
  
  public final void a(final Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(216274);
    ad.i("MicroMsg.Voip.NewVoipMgr", "start VoIP, userName: %s, isOutCall: %b, isVideoCall: %b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.BYx.aA(paramBoolean2, paramBoolean1);
    this.BYx.ezv();
    this.BZb = true;
    this.fGM = paramString;
    this.BYH = paramBoolean1;
    this.BYI = paramBoolean2;
    this.BYG = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(this.fGM);
    this.jwD = new ap(Looper.getMainLooper());
    this.BZi = 0;
    this.BZj = 0;
    boolean bool1;
    int j;
    label191:
    label211:
    boolean bool2;
    if (bt.getInt(com.tencent.mm.n.g.acA().getValue("VOIPCameraSwitch"), 1) == 0)
    {
      bool1 = true;
      this.BYJ = bool1;
      if (!this.BYI) {
        this.BYJ = false;
      }
      j = com.tencent.mm.plugin.voip.b.l.aF(paramBoolean1, paramBoolean2);
      i = j;
      if (this.BYJ)
      {
        if (j != 0) {
          break label535;
        }
        i = 1;
        com.tencent.mm.plugin.voip.c.euM().Ue(1);
      }
      if (!paramBoolean1) {
        break label555;
      }
      this.BYy = com.tencent.mm.plugin.voip.b.l.UM(i);
      this.BYx.BYy = this.BYy;
      bool1 = com.tencent.mm.compatible.d.b.aba();
      bool2 = com.tencent.mm.compatible.d.b.abb();
      if (Build.MANUFACTURER.equalsIgnoreCase("meizu"))
      {
        if (!bool1)
        {
          localObject1 = com.tencent.mm.plugin.report.service.g.yhR;
          if (!this.BYI) {
            break label567;
          }
          i = 0;
          label264:
          ((com.tencent.mm.plugin.report.service.g)localObject1).f(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
        }
        if (!bool2)
        {
          localObject1 = com.tencent.mm.plugin.report.service.g.yhR;
          if (!this.BYI) {
            break label573;
          }
          i = 0;
          label311:
          ((com.tencent.mm.plugin.report.service.g)localObject1).f(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
        }
      }
      if ((!bool2) || (!bool1))
      {
        localObject1 = null;
        localObject2 = null;
        if ((bool1) || (bool2)) {
          break label579;
        }
        localObject1 = paramContext.getString(2131764920);
        localObject2 = paramContext.getString(2131764887);
        label382:
        com.tencent.mm.ui.base.h.a(paramContext, (String)localObject1, (String)localObject2, paramContext.getString(2131764890), true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(216265);
            ad.i("MicroMsg.Voip.NewVoipMgr", "show Permission settings");
            com.tencent.mm.compatible.d.b.bZ(paramContext);
            if (!NewVoipMgr.d(NewVoipMgr.this))
            {
              if (NewVoipMgr.f(NewVoipMgr.this))
              {
                NewVoipMgr.this.euY();
                AppMethodBeat.o(216265);
                return;
              }
              NewVoipMgr.this.evb();
              AppMethodBeat.o(216265);
              return;
            }
            if (NewVoipMgr.f(NewVoipMgr.this))
            {
              NewVoipMgr.this.evd();
              AppMethodBeat.o(216265);
              return;
            }
            NewVoipMgr.this.eve();
            AppMethodBeat.o(216265);
          }
        });
      }
      ad.i("MicroMsg.Voip.NewVoipMgr", "initMgr");
      com.tencent.mm.booter.a.Wt().Wv();
      if (!this.BYI) {
        break label631;
      }
      com.tencent.mm.plugin.voip.c.euM().b(true, true, this.fGM);
      label442:
      if (!this.BYH) {
        break label664;
      }
      com.tencent.mm.plugin.voip.c.euM().CdF.exR();
      if (!this.BYI) {
        break label646;
      }
    }
    label646:
    for (int i = com.tencent.mm.plugin.voip.c.euM().aDH(this.BYG.field_username);; i = com.tencent.mm.plugin.voip.c.euM().aDG(this.BYG.field_username))
    {
      if (i >= 0) {
        break label664;
      }
      gg(false);
      i = 0;
      if (i != 0)
      {
        this.BYx.aC(paramBoolean2, paramBoolean1);
        com.tencent.mm.plugin.voip.c.euM().a(paramString, this.BYI, false, paramLong);
      }
      AppMethodBeat.o(216274);
      return;
      bool1 = false;
      break;
      label535:
      i = j;
      if (256 != j) {
        break label191;
      }
      i = 257;
      break label191;
      label555:
      this.BYy = com.tencent.mm.plugin.voip.b.l.UL(i);
      break label211;
      label567:
      i = 1;
      break label264;
      label573:
      i = 1;
      break label311;
      label579:
      if (!bool1)
      {
        localObject1 = paramContext.getString(2131764922);
        localObject2 = paramContext.getString(2131764888);
        break label382;
      }
      if (bool2) {
        break label382;
      }
      localObject1 = paramContext.getString(2131764921);
      localObject2 = paramContext.getString(2131764889);
      break label382;
      label631:
      com.tencent.mm.plugin.voip.c.euM().b(true, false, this.fGM);
      break label442;
    }
    label664:
    com.tencent.mm.plugin.voip.c.euM().a(aj.getContext(), this);
    this.uJU = ((TelephonyManager)aj.getContext().getSystemService("phone"));
    this.uJU.listen(this.ljq, 32);
    paramContext = "voip_recent_contact" + com.tencent.mm.model.u.aAm();
    Object localObject1 = aj.getContext().getSharedPreferences("voip_plugin_prefs", 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString(paramContext, null);
    if (localObject2 != null)
    {
      localObject2 = bt.U(((String)localObject2).split(";"));
      if (localObject2 != null)
      {
        i = ((List)localObject2).size();
        if (((List)localObject2).contains(this.fGM))
        {
          if (i > 1)
          {
            ((List)localObject2).remove(this.fGM);
            label810:
            ((List)localObject2).add(0, this.fGM);
          }
          localObject2 = bt.m((List)localObject2, ";");
          ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
          label853:
          com.tencent.mm.sdk.b.a.IbL.c(this.BZK);
          com.tencent.mm.sdk.b.a.IbL.c(this.uJW);
          this.BYU.a(this);
          paramContext = new IntentFilter();
          paramContext.addAction("android.intent.action.SCREEN_ON");
          paramContext.addAction("android.intent.action.SCREEN_OFF");
          paramContext.addAction("android.intent.action.USER_PRESENT");
          aj.getContext().registerReceiver(this.BZH, paramContext);
          this.pyv = new SensorController(getContext());
          ad.i("MicroMsg.Voip.NewVoipMgr", "initMgr setSensorCallBack");
          this.pyv.a(this);
          if (this.pyu == null)
          {
            this.pyu = new bk(getContext());
            paramContext = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(216266);
                NewVoipMgr.a(NewVoipMgr.this, bt.HI());
                AppMethodBeat.o(216266);
              }
            };
            if (!this.pyu.aD(paramContext)) {
              break label1119;
            }
          }
        }
      }
    }
    label1119:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      if (this.BYI)
      {
        this.BYz = new j(this, this.BYH);
        this.BZG = new com.tencent.mm.plugin.voip.b.i();
      }
      i = 1;
      break;
      if (4 != i) {
        break label810;
      }
      ((List)localObject2).remove(i - 1);
      break label810;
      localObject2 = new ArrayList();
      ((List)localObject2).add(0, this.fGM);
      localObject2 = bt.m((List)localObject2, ";");
      ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
      break label853;
    }
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    AppMethodBeat.i(216294);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onVoipUIDestroy");
    if (this.BYA == paramb)
    {
      ad.d("MicroMsg.Voip.NewVoipMgr", "same VoipUI, clear it");
      this.BYA = null;
      this.BYx.b(null);
    }
    if (this.jwD != null) {
      this.jwD = null;
    }
    AppMethodBeat.o(216294);
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb, int paramInt)
  {
    AppMethodBeat.i(216287);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onVoipUICreated, uiType: %s,  mVoicePlayDevice: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.BYM) });
    if ((1 == paramInt) && (this.BYA != null)) {
      this.BYA.uninit();
    }
    this.BYA = paramb;
    this.mUIType = paramInt;
    this.BYx.b(this.BYA);
    this.BYA.iu(-1, this.BYy.mState);
    this.BYA.setConnectSec(this.BYN);
    this.BYA.Ux(this.BZj);
    AppMethodBeat.o(216287);
  }
  
  public final void a(VoIPRenderSurfaceView paramVoIPRenderSurfaceView)
  {
    AppMethodBeat.i(216301);
    if (this.BYz != null)
    {
      j localj = this.BYz;
      if (paramVoIPRenderSurfaceView != null) {
        paramVoIPRenderSurfaceView.eBn();
      }
      localj.Csu = false;
      localj.Cso = false;
    }
    AppMethodBeat.o(216301);
  }
  
  public final void a(VoIPRenderSurfaceView paramVoIPRenderSurfaceView, int paramInt)
  {
    AppMethodBeat.i(216300);
    if (this.BYz != null)
    {
      com.tencent.mm.plugin.voip.b.i.UH(0);
      Object localObject1 = this.BYz;
      p.h(paramVoIPRenderSurfaceView, "view");
      if (!((j)localObject1).Csu)
      {
        ((j)localObject1).Csu = true;
        Object localObject2 = ((j)localObject1).Csp;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.e)localObject2).K((d.g.a.a)new j.f((j)localObject1));
        }
        localObject2 = ((j)localObject1).Csq;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.c)localObject2).Cru = ((d.g.a.a)new j.g((j)localObject1));
        }
      }
      localObject1 = (j.b)new j.h((j)localObject1);
      p.h(localObject1, "listener");
      paramVoIPRenderSurfaceView.CsP = ((j.b)localObject1);
      paramVoIPRenderSurfaceView.CsQ = paramInt;
      paramVoIPRenderSurfaceView.getHolder().addCallback(paramVoIPRenderSurfaceView.CsO);
    }
    AppMethodBeat.o(216300);
  }
  
  public final void a(VoIPRenderTextureView paramVoIPRenderTextureView)
  {
    AppMethodBeat.i(216302);
    if (this.BYz != null)
    {
      j localj = this.BYz;
      if (paramVoIPRenderTextureView != null)
      {
        paramVoIPRenderTextureView.setSurfaceTextureListener(null);
        j.b localb = paramVoIPRenderTextureView.CsP;
        if (localb != null) {
          localb.UY(paramVoIPRenderTextureView.CsQ);
        }
        paramVoIPRenderTextureView.CsP = null;
      }
      localj.Csu = false;
      localj.Cso = false;
    }
    AppMethodBeat.o(216302);
  }
  
  public final void a(VoIPRenderTextureView paramVoIPRenderTextureView, int paramInt)
  {
    AppMethodBeat.i(216298);
    if (this.BYz != null)
    {
      com.tencent.mm.plugin.voip.b.i.UH(1);
      Object localObject1 = this.BYz;
      p.h(paramVoIPRenderTextureView, "view");
      if (!((j)localObject1).Csu)
      {
        ((j)localObject1).Csu = true;
        Object localObject2 = ((j)localObject1).Csp;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.e)localObject2).K((d.g.a.a)new j.c((j)localObject1));
        }
        localObject2 = ((j)localObject1).Csq;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.c)localObject2).Cru = ((d.g.a.a)new j.d((j)localObject1));
        }
      }
      localObject1 = (j.b)new j.e((j)localObject1);
      p.h(localObject1, "listener");
      paramVoIPRenderTextureView.CsP = ((j.b)localObject1);
      paramVoIPRenderTextureView.CsQ = paramInt;
      paramVoIPRenderTextureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new VoIPRenderTextureView.b(paramVoIPRenderTextureView));
    }
    AppMethodBeat.o(216298);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void a(final int[] paramArrayOfInt, final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(216352);
    if ((this.BYz != null) && (!this.BYz.CcV))
    {
      this.BYz.eBl();
      this.BYz.CcV = true;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(216258);
        if (NewVoipMgr.a(NewVoipMgr.this) != null)
        {
          com.tencent.mm.plugin.voip.video.h localh = NewVoipMgr.a(NewVoipMgr.this).Csm;
          if (localh != null) {
            localh.eAv();
          }
        }
        if (NewVoipMgr.o(NewVoipMgr.this) != null) {
          NewVoipMgr.o(NewVoipMgr.this);
        }
        AppMethodBeat.o(216258);
      }
    });
    AppMethodBeat.o(216352);
  }
  
  public final void aDD(String paramString)
  {
    AppMethodBeat.i(216317);
    if (this.BYA != null)
    {
      this.BZf = paramString;
      this.BYA.aDI(paramString);
    }
    AppMethodBeat.o(216317);
  }
  
  public final void ad(long paramLong, int paramInt)
  {
    int k = 1;
    AppMethodBeat.i(216293);
    Object localObject1;
    int i;
    label60:
    Object localObject2;
    int j;
    if (this.BZG != null) {
      switch (paramInt)
      {
      default: 
        if (this.BYz != null)
        {
          localObject1 = this.BZG;
          if (1 != this.mUIType) {
            break label367;
          }
          i = 1;
          localObject2 = this.BYz.Csp;
          j = k;
          if (localObject2 != null)
          {
            if (((com.tencent.mm.plugin.voip.video.render.e)localObject2).eBe() == 0) {
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
      AppMethodBeat.o(216293);
      return;
      if (1 == this.mUIType)
      {
        if (!com.tencent.mm.plugin.voip.c.euM().CdT)
        {
          localObject1 = this.BZG;
          if ((260 != this.BYy.mState) && (6 != this.BYy.mState)) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.plugin.voip.b.i)localObject1).aD(true, bool);
            com.tencent.mm.plugin.voip.c.euM().CdT = true;
            break;
          }
        }
        localObject1 = this.BZG;
        if ((260 != this.BYy.mState) && (6 != this.BYy.mState)) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.voip.b.i)localObject1).aE(true, bool);
          break;
        }
      }
      if (!com.tencent.mm.plugin.voip.c.euM().CdS)
      {
        localObject1 = this.BZG;
        if ((260 != this.BYy.mState) && (6 != this.BYy.mState)) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.voip.b.i)localObject1).aD(false, bool);
          com.tencent.mm.plugin.voip.c.euM().CdS = true;
          break;
        }
      }
      localObject1 = this.BZG;
      if ((260 != this.BYy.mState) && (6 != this.BYy.mState)) {}
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.voip.b.i)localObject1).aE(false, bool);
        break;
      }
      label367:
      i = 0;
      break label60;
      label373:
      j = 0;
      break label90;
      ((com.tencent.mm.plugin.voip.b.i)localObject1).ClB += 1;
      if (((com.tencent.mm.plugin.voip.b.i)localObject1).ClB == 0)
      {
        if (i != 0)
        {
          if (paramLong > 0L)
          {
            localObject1 = com.tencent.mm.plugin.voip.b.k.ClI;
            com.tencent.mm.plugin.voip.b.k.BH(paramLong);
            AppMethodBeat.o(216293);
          }
        }
        else
        {
          if (paramLong > 0L)
          {
            localObject1 = com.tencent.mm.plugin.voip.b.k.ClI;
            com.tencent.mm.plugin.voip.b.k.BI(paramLong);
          }
          AppMethodBeat.o(216293);
        }
      }
      else if (((com.tencent.mm.plugin.voip.b.i)localObject1).ClB == 60) {
        ((com.tencent.mm.plugin.voip.b.i)localObject1).ClB = -1;
      }
      AppMethodBeat.o(216293);
      return;
      ((com.tencent.mm.plugin.voip.b.i)localObject1).ClC += 1;
      if (((com.tencent.mm.plugin.voip.b.i)localObject1).ClC == 0)
      {
        if (i != 0)
        {
          if (j != 0)
          {
            localObject1 = com.tencent.mm.plugin.voip.b.k.ClI;
            com.tencent.mm.plugin.voip.b.k.BZ(paramLong);
            AppMethodBeat.o(216293);
            return;
          }
          localObject1 = com.tencent.mm.plugin.voip.b.k.ClI;
          com.tencent.mm.plugin.voip.b.k.BX(paramLong);
          AppMethodBeat.o(216293);
          return;
        }
        if (j != 0)
        {
          localObject1 = com.tencent.mm.plugin.voip.b.k.ClI;
          com.tencent.mm.plugin.voip.b.k.Ca(paramLong);
          AppMethodBeat.o(216293);
          return;
        }
        localObject1 = com.tencent.mm.plugin.voip.b.k.ClI;
        com.tencent.mm.plugin.voip.b.k.BY(paramLong);
        AppMethodBeat.o(216293);
        return;
      }
      if (((com.tencent.mm.plugin.voip.b.i)localObject1).ClC == 60) {
        ((com.tencent.mm.plugin.voip.b.i)localObject1).ClC = -1;
      }
      AppMethodBeat.o(216293);
      return;
      ((com.tencent.mm.plugin.voip.b.i)localObject1).ClD += 1;
      if (((com.tencent.mm.plugin.voip.b.i)localObject1).ClD == 0)
      {
        if (i != 0)
        {
          localObject2 = com.tencent.mm.plugin.voip.b.k.ClI;
          com.tencent.mm.plugin.voip.b.k.BJ(paramLong);
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.voip.b.i)localObject1).ClB = 0;
          AppMethodBeat.o(216293);
          return;
          localObject2 = com.tencent.mm.plugin.voip.b.k.ClI;
          com.tencent.mm.plugin.voip.b.k.BK(paramLong);
        }
      }
      if (((com.tencent.mm.plugin.voip.b.i)localObject1).ClD == 60) {
        ((com.tencent.mm.plugin.voip.b.i)localObject1).ClD = -1;
      }
    }
  }
  
  public final void ae(long paramLong, int paramInt) {}
  
  public final void au(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(216299);
    if (this.BZG != null)
    {
      com.tencent.mm.plugin.voip.b.i locali = this.BZG;
      long l = bt.HI();
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          locali.Clz = l;
          AppMethodBeat.o(216299);
          return;
        }
        locali.Clx = l;
        AppMethodBeat.o(216299);
        return;
      }
      if (paramBoolean2)
      {
        locali.ClA = l;
        AppMethodBeat.o(216299);
        return;
      }
      locali.Cly = l;
    }
    AppMethodBeat.o(216299);
  }
  
  public final void av(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(216291);
    if (this.BYA != null) {
      this.BYA.Uv(paramInt1);
    }
    if (this.BYU != null) {
      this.BYU.setPreviewSize(paramInt2, paramInt3);
    }
    AppMethodBeat.o(216291);
  }
  
  public final void bZW() {}
  
  public final void d(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(216329);
    if (this.BYz != null)
    {
      Object localObject1 = this.BYz;
      p.h(paramArrayOfByte, "outData");
      localObject1 = ((j)localObject1).Csq;
      if (localObject1 != null)
      {
        int i = OpenGlRender.FLAG_YV12Edge;
        int j = OpenGlRender.FLAG_Angle90;
        p.h(paramArrayOfByte, "pBuff");
        if (((com.tencent.mm.plugin.voip.video.render.c)localObject1).CoP != null)
        {
          Object localObject2 = ((com.tencent.mm.plugin.voip.video.render.c)localObject1).CrB;
          if (localObject2 != null)
          {
            p.h(paramArrayOfByte, "pBuff");
            localObject2 = ((com.tencent.mm.plugin.voip.video.render.l)localObject2).Ctg;
            p.h(paramArrayOfByte, "pBuff");
            localObject2 = ((com.tencent.mm.plugin.voip.video.c.f)localObject2).CqZ;
            if (localObject2 != null)
            {
              p.h(paramArrayOfByte, "pBuff");
              if (((com.tencent.mm.plugin.voip.video.c.i)localObject2).Cnw == null)
              {
                ((com.tencent.mm.plugin.voip.video.c.i)localObject2).mWidth = paramInt1;
                ((com.tencent.mm.plugin.voip.video.c.i)localObject2).mHeight = paramInt2;
                ((com.tencent.mm.plugin.voip.video.c.i)localObject2).wDn = (i + j);
                ((com.tencent.mm.plugin.voip.video.c.i)localObject2).Cnw = paramArrayOfByte;
              }
            }
          }
          paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.render.c)localObject1).CoP;
          if (paramArrayOfByte == null) {
            p.gfZ();
          }
          ((com.tencent.mm.plugin.voip.video.render.m)localObject1).b(paramArrayOfByte);
        }
      }
      if (this.BYA != null) {
        this.BYA.eyJ();
      }
    }
    AppMethodBeat.o(216329);
  }
  
  public final void dcY()
  {
    AppMethodBeat.i(216319);
    ad.i("MicroMsg.Voip.NewVoipMgr", "on accept");
    evn();
    tK(4100);
    AppMethodBeat.o(216319);
  }
  
  public final void dde()
  {
    AppMethodBeat.i(216340);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onNetWorkChangeMobileNet");
    if (this.BYA != null) {
      this.BYA.eyK();
    }
    AppMethodBeat.o(216340);
  }
  
  public final void ddf()
  {
    AppMethodBeat.i(216341);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onResumeGoodNetStatus");
    if (this.BYA != null) {
      this.BYA.deY();
    }
    AppMethodBeat.o(216341);
  }
  
  public final void dqh()
  {
    AppMethodBeat.i(216312);
    if (this.BYA != null) {
      this.BYA.dqh();
    }
    AppMethodBeat.o(216312);
  }
  
  public final boolean euF()
  {
    return this.BYI;
  }
  
  public final boolean euG()
  {
    return this.BYH;
  }
  
  public final String euH()
  {
    return this.BZf;
  }
  
  public final long euI()
  {
    return this.BZo;
  }
  
  public final long euJ()
  {
    return this.BZp;
  }
  
  public final int euK()
  {
    return this.BZq;
  }
  
  public final boolean euW()
  {
    AppMethodBeat.i(216279);
    if (!this.BYy.UR(4103))
    {
      AppMethodBeat.o(216279);
      return false;
    }
    TN(4103);
    com.tencent.mm.plugin.voip.c.euM().exJ();
    AppMethodBeat.o(216279);
    return true;
  }
  
  public final boolean euX()
  {
    AppMethodBeat.i(216280);
    if (!this.BYy.UR(4101))
    {
      AppMethodBeat.o(216280);
      return false;
    }
    evn();
    com.tencent.mm.plugin.voip.c.euM().Ue(1);
    com.tencent.mm.plugin.voip.c.euM().aw(true, this.BYI);
    com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
    long l = com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.uLt;
    int j = com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.roomId;
    if (this.BYH) {}
    for (int i = 1;; i = 0)
    {
      localg.f(11046, new Object[] { Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i) });
      com.tencent.mm.plugin.report.service.g.yhR.f(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0) });
      tK(4111);
      tK(4101);
      tK(4100);
      AppMethodBeat.o(216280);
      return true;
    }
  }
  
  public final boolean euY()
  {
    int i = 0;
    AppMethodBeat.i(216281);
    if (!this.BYy.UR(4099))
    {
      AppMethodBeat.o(216281);
      return false;
    }
    String str2 = this.BYG.field_username;
    if (this.BYI) {}
    for (String str1 = bu.IMe;; str1 = bu.IMd)
    {
      if (this.BYH) {
        i = 1;
      }
      s.c(str2, str1, i, 6, aj.getContext().getString(2131764807));
      evn();
      com.tencent.mm.plugin.voip.c.euM().CdF.exU();
      tK(4099);
      evs();
      AppMethodBeat.o(216281);
      return true;
    }
  }
  
  public final boolean euZ()
  {
    AppMethodBeat.i(216282);
    if (!this.BYy.UR(4100))
    {
      AppMethodBeat.o(216282);
      return false;
    }
    if (this.BYz != null) {
      this.BYz.eBl();
    }
    ad.i("MicroMsg.Voip.NewVoipMgr", "onAcceptVideoInvite");
    evn();
    com.tencent.mm.plugin.voip.c.euM().aw(false, this.BYI);
    tK(4100);
    AppMethodBeat.o(216282);
    return true;
  }
  
  public final void evC()
  {
    AppMethodBeat.i(216348);
    if ((256 != this.BYy.mState) && (257 != this.BYy.mState))
    {
      AppMethodBeat.o(216348);
      return;
    }
    if ((com.tencent.mm.kernel.g.ajC().ajl().getInt(327945, 0) == 0) && (this.BYA.eyI() != null))
    {
      com.tencent.mm.kernel.g.ajC().ajl().setInt(327945, 1);
      com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.a(this.BYA.eyI(), 2131764868, 2131755906, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(216255);
          NewVoipMgr.this.evE();
          AppMethodBeat.o(216255);
        }
      });
      locald.setCancelable(false);
      locald.setCanceledOnTouchOutside(false);
      locald.show();
      AppMethodBeat.o(216348);
      return;
    }
    n.gG(aj.getContext());
    evE();
    AppMethodBeat.o(216348);
  }
  
  public final void evD()
  {
    AppMethodBeat.i(216349);
    if (!this.BYW) {}
    for (boolean bool = true;; bool = false)
    {
      this.BYW = bool;
      if (!this.BYW) {
        break;
      }
      this.BYV.stopTimer();
      AppMethodBeat.o(216349);
      return;
    }
    if (this.BYV == null) {
      this.BYV = new av("faceDetect", new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(216257);
          NewVoipMgr.I(NewVoipMgr.this);
          AppMethodBeat.o(216257);
          return true;
        }
      }, true);
    }
    this.BYV.az(2000L, 2000L);
    this.BYW = false;
    AppMethodBeat.o(216349);
  }
  
  public final void evE()
  {
    AppMethodBeat.i(216350);
    com.tencent.mm.plugin.voip.c.euM().CdM = com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.roomId;
    String str2 = this.BYG.field_username;
    String str1;
    if (this.BYI)
    {
      str1 = bu.IMe;
      if (!this.BYH) {
        break label124;
      }
    }
    label124:
    for (int i = 1;; i = 0)
    {
      s.c(str2, str1, i, 6, aj.getContext().getString(2131764806));
      evn();
      tK(4108);
      if (this.jwD != null) {
        this.jwD.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(216256);
            NewVoipMgr.H(NewVoipMgr.this);
            AppMethodBeat.o(216256);
          }
        }, 2000L);
      }
      AppMethodBeat.o(216350);
      return;
      str1 = bu.IMd;
      break;
    }
  }
  
  public final void eva()
  {
    if (this.BYz != null) {
      this.BYz.CcV = false;
    }
  }
  
  public final boolean evb()
  {
    int i = 0;
    AppMethodBeat.i(216283);
    if (!this.BYy.UR(4099))
    {
      AppMethodBeat.o(216283);
      return false;
    }
    ad.i("MicroMsg.Voip.NewVoipMgr", "onRejectVoiceInvite");
    String str2 = this.BYG.field_username;
    if (this.BYI) {}
    for (String str1 = bu.IMe;; str1 = bu.IMd)
    {
      if (this.BYH) {
        i = 1;
      }
      s.c(str2, str1, i, 6, aj.getContext().getString(2131764807));
      evn();
      com.tencent.mm.plugin.voip.c.euM().CdF.exU();
      tK(4099);
      evs();
      AppMethodBeat.o(216283);
      return true;
    }
  }
  
  public final boolean evc()
  {
    AppMethodBeat.i(216284);
    if (!this.BYy.UR(4100))
    {
      AppMethodBeat.o(216284);
      return false;
    }
    ad.i("MicroMsg.Voip.NewVoipMgr", "onAcceptVoiceInvite");
    evn();
    com.tencent.mm.plugin.voip.c.euM().aw(true, this.BYI);
    tK(4111);
    tK(4100);
    AppMethodBeat.o(216284);
    return true;
  }
  
  public final boolean evd()
  {
    AppMethodBeat.i(216285);
    if (!this.BYy.UR(4098))
    {
      AppMethodBeat.o(216285);
      return false;
    }
    ad.i("MicroMsg.Voip.NewVoipMgr", "onCancelVideoInvite");
    TN(4098);
    com.tencent.mm.plugin.voip.c.euM().exJ();
    AppMethodBeat.o(216285);
    return true;
  }
  
  public final boolean eve()
  {
    AppMethodBeat.i(216286);
    if (!this.BYy.UR(4098))
    {
      AppMethodBeat.o(216286);
      return false;
    }
    ad.i("MicroMsg.Voip.NewVoipMgr", "onCancelVoiceInvite");
    TN(4098);
    com.tencent.mm.plugin.voip.c.euM().exJ();
    AppMethodBeat.o(216286);
    return true;
  }
  
  public final void evf()
  {
    boolean bool2 = true;
    AppMethodBeat.i(216288);
    if ((this.BYI) && (this.BYz != null))
    {
      j localj = this.BYz;
      Object localObject1 = localj.Csm;
      if ((localObject1 != null) && (localj.Csp != null))
      {
        Object localObject2 = localj.Csp;
        if (localObject2 == null) {
          p.gfZ();
        }
        if (((com.tencent.mm.plugin.voip.video.render.e)localObject2).CrM != null)
        {
          ((com.tencent.mm.plugin.voip.video.h)localObject1).Cmh = false;
          localObject1 = localj.Csp;
          if (localObject1 == null) {
            p.gfZ();
          }
          localObject1 = ((com.tencent.mm.plugin.voip.video.render.e)localObject1).CrM;
          if (localObject1 == null) {
            p.gfZ();
          }
          localObject2 = localj.Csm;
          if (localObject2 == null) {
            break label195;
          }
          bool1 = ((com.tencent.mm.plugin.voip.video.h)localObject2).eAm();
          localj.d((com.tencent.mm.plugin.voip.video.render.g)localObject1, bool1);
        }
      }
    }
    if ((this.BYH) && (com.tencent.mm.plugin.voip.b.l.UP(this.BYy.mState)) && (com.tencent.mm.plugin.voip.c.euM().CdF.cae()))
    {
      this.BYx.aC(this.BYI, this.BYH);
      if (this.BYM != 1) {
        break label200;
      }
    }
    label195:
    label200:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      td(bool1);
      AppMethodBeat.o(216288);
      return;
      bool1 = true;
      break;
    }
  }
  
  public final void evg()
  {
    AppMethodBeat.i(216290);
    ad.i("MicroMsg.Voip.NewVoipMgr", "it is init voip report");
    this.BZy = new NetChangedBroadcastReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    aj.getContext().registerReceiver(this.BZy, localIntentFilter);
    this.oYl = ((TelephonyManager)aj.getContext().getSystemService("phone"));
    this.BZw = com.tencent.mm.plugin.voip.b.f.getNetType(getContext());
    this.BZz = new PhoneStateListener()
    {
      public final void onSignalStrengthsChanged(SignalStrength paramAnonymousSignalStrength)
      {
        AppMethodBeat.i(216267);
        super.onSignalStrengthsChanged(paramAnonymousSignalStrength);
        super.onSignalStrengthsChanged(paramAnonymousSignalStrength);
        paramAnonymousSignalStrength = paramAnonymousSignalStrength.toString().split(" ");
        try
        {
          if ((NewVoipMgr.g(NewVoipMgr.this).getNetworkType() == 13) && (paramAnonymousSignalStrength.length > 9)) {
            NewVoipMgr.evG()[0] = bt.aRe(paramAnonymousSignalStrength[9]);
          }
          AppMethodBeat.o(216267);
          return;
        }
        catch (Exception paramAnonymousSignalStrength)
        {
          ad.printErrStackTrace("MicroMsg.Voip.NewVoipMgr", paramAnonymousSignalStrength, "", new Object[0]);
          AppMethodBeat.o(216267);
        }
      }
    };
    this.oYl.listen(this.BZz, 256);
    AppMethodBeat.o(216290);
  }
  
  public final void evh()
  {
    AppMethodBeat.i(216292);
    if ((this.vNW) || (this.BYA == null) || (this.BYA.eyI() == null) || (this.BYz == null) || (this.BYz.Csm == null))
    {
      ad.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, already show");
      AppMethodBeat.o(216292);
      return;
    }
    if (this.BYz.Csm.cLT())
    {
      AppMethodBeat.o(216292);
      return;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("meizu")) && (!com.tencent.mm.compatible.d.b.abb()))
    {
      ad.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, meizu machine");
      AppMethodBeat.o(216292);
      return;
    }
    if ((com.tencent.mm.compatible.util.d.ly(28)) && (((KeyguardManager)aj.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()))
    {
      ad.i("MicroMsg.Voip.NewVoipMgr", "api level: %s, in keyguard, ignore", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(216292);
      return;
    }
    ad.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, show dialog");
    com.tencent.mm.plugin.report.service.g.yhR.f(11306, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.l(this.BYA.eyI(), 2131764896, 2131755906);
    if (locald == null)
    {
      ad.e("MicroMsg.Voip.NewVoipMgr", "new dialog failed");
      AppMethodBeat.o(216292);
      return;
    }
    locald.setCancelable(false);
    locald.setCanceledOnTouchOutside(false);
    locald.show();
    this.vNW = true;
    com.tencent.mm.plugin.voip.b.i.ezO();
    AppMethodBeat.o(216292);
  }
  
  public final void evi()
  {
    AppMethodBeat.i(216295);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onSwitchCamera");
    j localj;
    Object localObject;
    int i;
    if (this.BYz != null)
    {
      localj = this.BYz;
      ad.i("MicroMsg.VoIPRenderMgr", "onSwitchCamera");
      if (localj.Csm != null)
      {
        localObject = localj.Csm;
        if (localObject == null) {
          p.gfZ();
        }
        if (((com.tencent.mm.plugin.voip.video.h)localObject).eAs() != null)
        {
          localObject = localj.Csm;
          if (localObject != null) {
            ((com.tencent.mm.plugin.voip.video.h)localObject).eAi();
          }
          localObject = localj.Csm;
          if (localObject == null) {
            p.gfZ();
          }
          localObject = ((com.tencent.mm.plugin.voip.video.h)localObject).eAs();
          p.g(localObject, "newCaptureRender!!.previewSize");
          com.tencent.mm.plugin.voip.video.h localh = localj.Csm;
          if (localh == null) {
            p.gfZ();
          }
          i = localh.eAt();
          localh = localj.Csm;
          if (localh == null) {
            p.gfZ();
          }
          if (localh.eAu()) {
            break label189;
          }
        }
      }
    }
    label189:
    for (boolean bool = true;; bool = false)
    {
      localj.a((ac)localObject, i, bool);
      com.tencent.mm.plugin.report.service.g.yhR.f(11079, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(216295);
      return;
    }
  }
  
  public final void evj()
  {
    AppMethodBeat.i(216296);
    if ((this.BYz != null) && (this.BYz.Csm != null) && (true != this.BYz.Csm.eAm())) {
      evi();
    }
    AppMethodBeat.o(216296);
  }
  
  public final void evk()
  {
    AppMethodBeat.i(216303);
    if (this.BYz != null)
    {
      Object localObject1 = this.BYz;
      ad.m("MicroMsg.VoIPRenderMgr", "onRender Mode changed", new Object[0]);
      if (!((j)localObject1).Cik) {}
      for (boolean bool = true;; bool = false)
      {
        ((j)localObject1).Cik = bool;
        Object localObject2 = ((j)localObject1).Csp;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.e)localObject2).eBd();
        }
        localObject2 = ((j)localObject1).Csq;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.m)localObject2).eBd();
        }
        localObject2 = ((j)localObject1).Csp;
        if (localObject2 != null)
        {
          ad.m("MicroMsg.LocalWindowsSurfaceRenderer", "switchRenderSurface", new Object[0]);
          com.tencent.mm.plugin.voip.video.render.m localm = ((com.tencent.mm.plugin.voip.video.render.e)localObject2).CrN;
          if (localm != null) {
            localm.eBb();
          }
          localObject2 = ((com.tencent.mm.plugin.voip.video.render.e)localObject2).CrM;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.voip.video.render.g)localObject2).eBb();
          }
        }
        localObject2 = ((j)localObject1).Csq;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.m)localObject2).eBb();
        }
        localObject2 = ((j)localObject1).Csp;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.e)localObject2).eBc();
        }
        localObject1 = ((j)localObject1).Csq;
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.plugin.voip.video.render.m)localObject1).eBc();
        AppMethodBeat.o(216303);
        return;
      }
    }
    AppMethodBeat.o(216303);
  }
  
  public final void evl()
  {
    AppMethodBeat.i(216305);
    if (this.BYz != null) {
      this.BYz.ir(this.BZu, this.BZv);
    }
    AppMethodBeat.o(216305);
  }
  
  public final void evm()
  {
    AppMethodBeat.i(216307);
    this.BZG.UG(1);
    AppMethodBeat.o(216307);
  }
  
  public final void evn()
  {
    AppMethodBeat.i(216308);
    if (this.BYx != null)
    {
      ad.i("MicroMsg.Voip.NewVoipMgr", "use audioManager to stop voip ring");
      this.BYx.evn();
      AppMethodBeat.o(216308);
      return;
    }
    ad.i("MicroMsg.Voip.NewVoipMgr", "use Subcore to stop voip ring");
    com.tencent.mm.plugin.voip.c.euM().CdF.stopRing();
    AppMethodBeat.o(216308);
  }
  
  public final void evo()
  {
    AppMethodBeat.i(216309);
    if (this.BYA != null) {
      this.BYA.evo();
    }
    AppMethodBeat.o(216309);
  }
  
  public final boolean evp()
  {
    AppMethodBeat.i(216310);
    if (com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.roomId == 0)
    {
      this.BYL = true;
      AppMethodBeat.o(216310);
      return true;
    }
    boolean bool = evq();
    AppMethodBeat.o(216310);
    return bool;
  }
  
  public final void evr()
  {
    AppMethodBeat.i(216313);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onRoomReady");
    if ((this.BYL) && (com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.roomId != 0))
    {
      this.BYL = false;
      evq();
    }
    if (this.BYH) {
      tK(4097);
    }
    AppMethodBeat.o(216313);
  }
  
  public final void evu()
  {
    AppMethodBeat.i(216324);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onNoResp");
    tK(4105);
    String str2 = this.BYG.field_username;
    String str1;
    if (this.BYI)
    {
      str1 = bu.IMe;
      if (!this.BYH) {
        break label181;
      }
    }
    label181:
    for (int i = 1;; i = 0)
    {
      s.c(str2, str1, i, 4, aj.getContext().getString(2131764810));
      com.tencent.mm.plugin.report.service.g.yhR.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.uLt), Long.valueOf(com.tencent.mm.plugin.voip.c.euM().CdF.BXC.evX()), Integer.valueOf(6), Integer.valueOf(ay.getNetWorkType(getContext())) });
      evs();
      AppMethodBeat.o(216324);
      return;
      str1 = bu.IMd;
      break;
    }
  }
  
  public final void evv()
  {
    int j = 0;
    AppMethodBeat.i(216326);
    com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yhR;
    int k = com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.roomId;
    long l1 = com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.uLt;
    long l2 = com.tencent.mm.plugin.voip.c.euM().CdF.BXC.evX();
    if (this.BYH)
    {
      i = 0;
      localg.a(11522, true, true, new Object[] { Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(1) });
      k = com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.roomId;
      l1 = com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.uLt;
      if (!this.BYH) {
        break label198;
      }
    }
    label198:
    for (int i = j;; i = 1)
    {
      com.tencent.mm.plugin.voip.b.f.c(k, l1, i, 3);
      this.BZA.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(216244);
          NewVoipMgr.a(NewVoipMgr.this, NewVoipMgr.h(NewVoipMgr.this));
          NewVoipMgr.q(NewVoipMgr.this).postDelayed(this, 5000L);
          AppMethodBeat.o(216244);
        }
      });
      AppMethodBeat.o(216326);
      return;
      i = 1;
      break;
    }
  }
  
  public final void evw()
  {
    int j = 0;
    AppMethodBeat.i(216327);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onShutDown");
    String str1;
    String str2;
    label99:
    label108:
    int k;
    label156:
    long l;
    if (com.tencent.mm.plugin.voip.b.l.UN(this.BYy.mState))
    {
      str1 = aj.getContext().getString(2131764803, new Object[] { sm(bt.rM(this.BYN)) });
      if ((this.BYH) || (com.tencent.mm.plugin.voip.b.l.UN(this.BYy.mState)))
      {
        String str3 = this.BYG.field_username;
        if (!this.BYI) {
          break label245;
        }
        str2 = bu.IMe;
        if (!this.BYH) {
          break label253;
        }
        i = 1;
        s.c(str3, str2, i, 6, str1);
      }
      com.tencent.mm.plugin.voip.b.c.tz(this.BYI);
      this.BYE = com.tencent.mm.plugin.voip.b.l.UN(this.BYy.mState);
      if (!evA()) {
        break label258;
      }
      this.BYK = 4106;
      com.tencent.mm.plugin.voip.c.euM().exJ();
      if (!this.BZs)
      {
        k = com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.roomId;
        l = com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.uLt;
        if (!this.BYH) {
          break label272;
        }
      }
    }
    label258:
    label272:
    for (int i = j;; i = 1)
    {
      com.tencent.mm.plugin.voip.b.f.c(k, l, i, 4);
      this.BZs = true;
      AppMethodBeat.o(216327);
      return;
      str1 = aj.getContext().getString(2131764799);
      break;
      label245:
      str2 = bu.IMd;
      break label99;
      label253:
      i = 0;
      break label108;
      tK(4106);
      evs();
      break label156;
    }
  }
  
  public final void evx()
  {
    AppMethodBeat.i(216335);
    ad.d("MicroMsg.Voip.NewVoipMgr", "onPretreatmentForStartDev");
    this.BYx.aB(this.BZe, this.BYI);
    AppMethodBeat.o(216335);
  }
  
  public final long evy()
  {
    AppMethodBeat.i(216336);
    ad.m("MicroMsg.Voip.NewVoipMgr", "totalDeviceNearTime: %s", new Object[] { Long.valueOf(this.BZm) });
    long l = this.BZm / 1000L;
    AppMethodBeat.o(216336);
    return l;
  }
  
  public final int getState()
  {
    return this.BYy.mState;
  }
  
  public final String getUserName()
  {
    return this.fGM;
  }
  
  public final void ir(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(216332);
    ad.i("MicroMsg.Voip.NewVoipMgr", "adjustHWViewAspectRatio, HWDecsize:%dx%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.BZu = paramInt1;
    this.BZv = paramInt2;
    if (this.BYz != null) {
      this.BYz.ir(paramInt1, paramInt2);
    }
    AppMethodBeat.o(216332);
  }
  
  public final void kn(boolean paramBoolean)
  {
    AppMethodBeat.i(216276);
    ad.m("MicroMsg.Voip.NewVoipMgr", "onSensorEvent, isON: %s, lastIsDeviceNear: %s, deviceSwitchNearScreenTick: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.BZl), Long.valueOf(this.BZk) });
    if (this.BYy == null)
    {
      ad.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent, not create stateMachine yet, ignore");
      AppMethodBeat.o(216276);
      return;
    }
    if (this.pyt)
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.pyt = paramBoolean;
        ad.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent has skip and val is %s", new Object[] { Boolean.valueOf(this.pyt) });
        AppMethodBeat.o(216276);
        return;
      }
    }
    if ((Math.abs(bt.HI() - this.BZn) < 500L) && (this.BZn != -1L))
    {
      ad.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent time interval too small");
      AppMethodBeat.o(216276);
      return;
    }
    if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFl, true)) && (!paramBoolean) && (this.lastShakeTime != -1L) && (bt.aO(this.lastShakeTime) > 400L))
    {
      this.pyt = true;
      ad.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent has skip case shake near to small");
      AppMethodBeat.o(216276);
      return;
    }
    this.pyt = false;
    if ((com.tencent.mm.plugin.voip.b.l.UN(this.BYy.mState)) && ((this.BZl != paramBoolean) || (this.BZk == -1L)))
    {
      if ((!this.BZl) && (paramBoolean) && (!com.tencent.mm.plugin.voip.b.l.UO(this.BYy.mState)) && (this.mUIType != 2) && (this.BZk != -1L))
      {
        long l = bt.aO(this.BZk);
        ad.i("MicroMsg.Voip.NewVoipMgr", "accumulate near screen time: %s", new Object[] { Long.valueOf(l) });
        this.BZm += l;
      }
      this.BZk = bt.HI();
      this.BZl = paramBoolean;
    }
    if (this.BYA == null)
    {
      ad.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent, voipUI is null, ignore");
      AppMethodBeat.o(216276);
      return;
    }
    if (((this.BYH) || (com.tencent.mm.plugin.voip.b.l.UN(this.BYy.mState))) && (!com.tencent.mm.plugin.voip.b.l.UO(this.BYy.mState)) && (this.mUIType != 2))
    {
      ad.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent, isOn: ".concat(String.valueOf(paramBoolean)));
      this.BYA.setScreenEnable(paramBoolean);
      this.BYC = paramBoolean;
      this.BZn = bt.HI();
    }
    AppMethodBeat.o(216276);
  }
  
  public final void nL(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(216306);
    if ((this.BYz != null) && (this.BZa != paramInt) && ((paramInt == 0) || (paramInt == 180)))
    {
      this.BZa = paramInt;
      Object localObject1 = this.BYz.Csp;
      if (localObject1 != null)
      {
        Object localObject2 = ((com.tencent.mm.plugin.voip.video.render.e)localObject1).CrN;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.voip.video.render.c)localObject2).CrB;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.voip.video.render.l)localObject2).nd(paramInt);
          }
        }
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.e)localObject1).CrM;
        if (localObject2 != null)
        {
          if (((com.tencent.mm.plugin.voip.video.render.g)localObject2).Cse == null)
          {
            localObject1 = ((com.tencent.mm.plugin.voip.video.render.g)localObject2).CrV;
            if (localObject1 != null)
            {
              localObject1 = Integer.valueOf(((com.tencent.mm.media.j.b.a)localObject1).hnk);
              ((com.tencent.mm.plugin.voip.video.render.g)localObject2).Cse = ((Integer)localObject1);
            }
          }
          else
          {
            if (((com.tencent.mm.plugin.voip.video.render.g)localObject2).eBe() != 0) {
              break label190;
            }
            localObject1 = ((com.tencent.mm.plugin.voip.video.render.g)localObject2).CrV;
            if (localObject1 == null) {
              break label183;
            }
            localObject2 = ((com.tencent.mm.plugin.voip.video.render.g)localObject2).Cse;
            if (localObject2 == null) {
              break label178;
            }
          }
          label178:
          for (i = ((Integer)localObject2).intValue();; i = 0)
          {
            ((com.tencent.mm.plugin.voip.video.render.k)localObject1).nd(i + paramInt);
            AppMethodBeat.o(216306);
            return;
            localObject1 = null;
            break;
          }
          label183:
          AppMethodBeat.o(216306);
          return;
          label190:
          localObject1 = ((com.tencent.mm.plugin.voip.video.render.g)localObject2).CrV;
          if (localObject1 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.voip.video.render.g)localObject2).Cse;
            paramInt = i;
            if (localObject2 != null) {
              paramInt = ((Integer)localObject2).intValue();
            }
            ((com.tencent.mm.plugin.voip.video.render.k)localObject1).nd(paramInt);
            AppMethodBeat.o(216306);
            return;
          }
          AppMethodBeat.o(216306);
          return;
        }
        AppMethodBeat.o(216306);
        return;
      }
    }
    AppMethodBeat.o(216306);
  }
  
  public final void ny(boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(216339);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onBadNetStatus");
    if (this.BYA != null) {
      this.BYA.tr(paramBoolean);
    }
    long l;
    if ((!com.tencent.mm.plugin.voip.b.l.UO(this.BYy.mState)) && (!this.BYx.isSpeakerphoneOn()))
    {
      l = System.currentTimeMillis();
      if (l - this.uMg > 30000L)
      {
        this.uMg = l;
        com.tencent.mm.plugin.voip.c.euM().CdF.exY();
      }
    }
    Object localObject = new StringBuilder("report the bad net toast room key is ").append(com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.uLt).append("and in the side");
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      ad.i("MicroMsg.Voip.NewVoipMgr", i);
      localObject = com.tencent.mm.plugin.report.service.g.yhR;
      l = com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.uLt;
      i = j;
      if (paramBoolean) {
        i = 1;
      }
      ((com.tencent.mm.plugin.report.service.g)localObject).a(17151, true, true, new Object[] { Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(216339);
      return;
    }
  }
  
  public final void oG(boolean paramBoolean)
  {
    AppMethodBeat.i(216278);
    this.BYx.ty(paramBoolean);
    AppMethodBeat.o(216278);
  }
  
  public final void onConnected()
  {
    AppMethodBeat.i(216325);
    tK(4102);
    this.BYN = bt.aQJ();
    if (this.BYA != null) {
      this.BYA.setConnectSec(this.BYN);
    }
    boolean bool1 = com.tencent.mm.plugin.voip.c.euM().CdF.BXC.evZ();
    boolean bool2 = com.tencent.mm.plugin.voip.c.euM().CdF.BXC.evY();
    if ((this.BYI) && (this.BYH) && (!bool2) && (!bool1)) {
      com.tencent.mm.plugin.voip.c.euM().Ue(1);
    }
    if (!com.tencent.mm.plugin.voip.b.l.UO(this.BYy.mState)) {
      com.tencent.mm.plugin.report.service.g.yhR.f(11080, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
    }
    bt.F(aj.getContext(), true);
    com.tencent.mm.plugin.voip.c.euM().Up(com.tencent.mm.plugin.voip.c.euM().exI());
    r.ewQ().ewR();
    r.ewQ().a(this);
    k localk = k.Cad;
    k.setRoomId(com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.roomId);
    AppMethodBeat.o(216325);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(216318);
    com.tencent.mm.plugin.voip.b.c.tz(this.BYI);
    String str1 = paramString;
    if (paramInt == 241)
    {
      str1 = paramString;
      if (bt.isNullOrNil(paramString)) {
        str1 = getContext().getString(2131764903);
      }
    }
    if (this.BYA != null) {
      this.BYA.co(paramInt, str1);
    }
    tK(4109);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onError, errCode: %s, roomId: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.roomId) });
    paramString = aj.getContext();
    ad.d("MicroMsg.Voip.NewVoipMgr", "getErrorMsgContent, errorCode".concat(String.valueOf(paramInt)));
    if (paramInt == 235)
    {
      paramString = paramString.getString(2131764809);
      if ((com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.roomId == 0) || (com.tencent.mm.plugin.voip.c.euM().CdL.get(Integer.valueOf(com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.roomId)) != null)) {
        break label427;
      }
      str2 = this.BYG.field_username;
      if (!this.BYI) {
        break label414;
      }
      str1 = bu.IMe;
      if (!this.BYH) {
        break label422;
      }
      paramInt = 1;
      if (com.tencent.mm.plugin.voip.b.l.UN(this.BYy.mState)) {
        paramString = aj.getContext().getString(2131764804, new Object[] { sm(bt.rM(this.BYN)) });
      }
      l = s.a(str2, str1, paramInt, 6, paramString, true);
      com.tencent.mm.plugin.voip.c.euM().CdL.put(Integer.valueOf(com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.roomId), Long.valueOf(l));
    }
    label414:
    label422:
    label427:
    while (com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.roomId != 0) {
      for (;;)
      {
        long l;
        com.tencent.mm.plugin.voip.c.euM().exJ();
        evs();
        AppMethodBeat.o(216318);
        return;
        if (paramInt == 233)
        {
          paramString = paramString.getString(2131764800);
          break;
        }
        if (paramInt == 237)
        {
          paramString = paramString.getString(2131764809);
          break;
        }
        if (paramInt == 236)
        {
          paramString = paramString.getString(2131764800);
          break;
        }
        if (paramInt == 211)
        {
          paramString = paramString.getString(2131764808);
          break;
        }
        paramString = paramString.getString(2131764799);
        break;
        str1 = bu.IMd;
        continue;
        paramInt = 0;
      }
    }
    String str2 = this.BYG.field_username;
    if (this.BYI)
    {
      str1 = bu.IMe;
      label466:
      if (!this.BYH) {
        break label539;
      }
    }
    label539:
    for (paramInt = 1;; paramInt = 0)
    {
      if (com.tencent.mm.plugin.voip.b.l.UN(this.BYy.mState)) {
        paramString = aj.getContext().getString(2131764804, new Object[] { sm(bt.rM(this.BYN)) });
      }
      s.a(str2, str1, paramInt, 6, paramString, true);
      break;
      str1 = bu.IMd;
      break label466;
    }
  }
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture) {}
  
  public final void onReject()
  {
    AppMethodBeat.i(216320);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onReject");
    tK(4099);
    String str2 = this.BYG.field_username;
    String str1;
    if (this.BYI)
    {
      str1 = bu.IMe;
      if (!this.BYH) {
        break label86;
      }
    }
    label86:
    for (int i = 1;; i = 0)
    {
      s.c(str2, str1, i, 6, aj.getContext().getString(2131764811));
      evs();
      AppMethodBeat.o(216320);
      return;
      str1 = bu.IMd;
      break;
    }
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(216331);
    this.BZi = paramInt;
    if (this.BYz != null)
    {
      this.BYz.setHWDecMode(paramInt);
      if (this.BYA != null) {
        this.BYA.Uw(paramInt);
      }
      if (this.BZG != null)
      {
        com.tencent.mm.plugin.voip.b.i locali = this.BZG;
        if ((paramInt & 0x1) != 0)
        {
          locali.Clt += 1L;
          AppMethodBeat.o(216331);
          return;
        }
        locali.Clu += 1L;
      }
    }
    AppMethodBeat.o(216331);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    this.BYM = paramInt;
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(216330);
    ad.i("MicroMsg.Voip.NewVoipMgr", "setVoIPBeauty, isON: " + paramInt + "，mVoipUI: " + this.BYA);
    if (this.BYz != null)
    {
      j localj = this.BYz;
      ad.i("MicroMsg.VoIPRenderMgr", "setVoIPBeauty, mIsStarted:%b, isON:%d", new Object[] { Boolean.valueOf(localj.mIsStarted), Integer.valueOf(paramInt) });
      localj.BZj = paramInt;
      com.tencent.mm.plugin.voip.video.render.e locale = localj.Csp;
      if (locale != null) {
        locale.UW(localj.BZj);
      }
    }
    if (this.BYA != null) {
      this.BYA.Ux(paramInt);
    }
    if ((paramInt != 0) && (this.BZj != paramInt)) {
      com.tencent.mm.plugin.report.service.g.yhR.n(914L, 20L, 1L);
    }
    this.BZj = paramInt;
    AppMethodBeat.o(216330);
  }
  
  public final void ta(boolean paramBoolean)
  {
    AppMethodBeat.i(216275);
    int j = com.tencent.mm.plugin.voip.b.l.aF(false, paramBoolean);
    int i = j;
    if (this.BYJ)
    {
      if (j != 0) {
        break label80;
      }
      i = 1;
    }
    for (;;)
    {
      this.BYy = com.tencent.mm.plugin.voip.b.l.UL(i);
      ad.i("MicroMsg.Voip.NewVoipMgr", "steve:[simucall] resetStateMachine, initState:%d,isOutCall:%s,isVideoCall:%s", new Object[] { Integer.valueOf(i), Boolean.FALSE, Boolean.valueOf(paramBoolean) });
      this.BYH = false;
      AppMethodBeat.o(216275);
      return;
      label80:
      i = j;
      if (256 == j) {
        i = 257;
      }
    }
  }
  
  public final void td(boolean paramBoolean)
  {
    AppMethodBeat.i(216277);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.BYx.cn(paramBoolean);
    this.BYx.Cla = true;
    AppMethodBeat.o(216277);
  }
  
  public final void te(boolean paramBoolean)
  {
    AppMethodBeat.i(216304);
    if (this.BYz != null)
    {
      j localj = this.BYz;
      localj.Cik = paramBoolean;
      localj.setHWDecMode(localj.Cio);
    }
    AppMethodBeat.o(216304);
  }
  
  public final boolean tf(final boolean paramBoolean)
  {
    AppMethodBeat.i(216347);
    if (com.tencent.mm.plugin.voip.c.euM().CdU)
    {
      ad.i("MicroMsg.Voip.NewVoipMgr", "current state is mini, cannot mini!");
      AppMethodBeat.o(216347);
      return false;
    }
    if ((this.BZd) && (!paramBoolean))
    {
      ad.i("MicroMsg.Voip.NewVoipMgr", "has phone call  cannot mini!");
      AppMethodBeat.o(216347);
      return false;
    }
    ad.l("MicroMsg.Voip.NewVoipMgr", "miniOnlyHidenVoip: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ad.i("MicroMsg.Voip.NewVoipMgr", "onMinimizeVoip, async to minimize");
    if (this.BYA != null)
    {
      this.BYA.uninit();
      this.BYA = null;
      this.BYx.b(this.BYA);
    }
    this.hIH = bt.HI();
    if (this.BZc != null) {
      this.BZc.uninit();
    }
    if (this.jwD != null) {
      this.jwD.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(216254);
          NewVoipMgr.c(NewVoipMgr.this, paramBoolean);
          AppMethodBeat.o(216254);
        }
      });
    }
    AppMethodBeat.o(216347);
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
      AppMethodBeat.i(216272);
      if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
      {
        switch (com.tencent.mm.plugin.voip.b.f.getNetType(paramContext))
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
                AppMethodBeat.o(216272);
                return;
              } while (NewVoipMgr.h(NewVoipMgr.this) == 5);
              j = NewVoipMgr.evG()[1];
              if (NewVoipMgr.i(NewVoipMgr.this) == 0) {
                NewVoipMgr.a(NewVoipMgr.this, 4);
              }
            } while (NewVoipMgr.i(NewVoipMgr.this) == 0);
            k = NewVoipMgr.evH() / NewVoipMgr.i(NewVoipMgr.this);
            NewVoipMgr.a(NewVoipMgr.this, 5);
            m = NewVoipMgr.evG()[0];
            ad.i("MicroMsg.Voip.NewVoipMgr", "befor change to 4G and cost " + NewVoipMgr.j(NewVoipMgr.this));
            if (NewVoipMgr.d(NewVoipMgr.this)) {}
            for (;;)
            {
              com.tencent.mm.plugin.voip.b.f.a(i, System.currentTimeMillis(), NewVoipMgr.h(NewVoipMgr.this), 5, j, m, k);
              NewVoipMgr.k(NewVoipMgr.this);
              NewVoipMgr.b(NewVoipMgr.this, 5);
              NewVoipMgr.evI();
              NewVoipMgr.l(NewVoipMgr.this);
              AppMethodBeat.o(216272);
              return;
              i = 1;
            }
          } while (NewVoipMgr.h(NewVoipMgr.this) == 4);
          k = NewVoipMgr.evG()[0];
          if (NewVoipMgr.i(NewVoipMgr.this) == 0) {
            NewVoipMgr.a(NewVoipMgr.this, 5);
          }
        } while (NewVoipMgr.i(NewVoipMgr.this) == 0);
        int m = NewVoipMgr.evH() / NewVoipMgr.i(NewVoipMgr.this);
        NewVoipMgr.a(NewVoipMgr.this, 4);
        int n = NewVoipMgr.evG()[1];
        ad.i("MicroMsg.Voip.NewVoipMgr", "befor change to wifi and cost " + NewVoipMgr.j(NewVoipMgr.this));
        if (NewVoipMgr.d(NewVoipMgr.this)) {}
        for (i = j;; i = 1)
        {
          com.tencent.mm.plugin.voip.b.f.a(i, System.currentTimeMillis(), NewVoipMgr.h(NewVoipMgr.this), 4, k, n, m);
          NewVoipMgr.k(NewVoipMgr.this);
          NewVoipMgr.b(NewVoipMgr.this, 4);
          NewVoipMgr.evI();
          NewVoipMgr.l(NewVoipMgr.this);
          break;
        }
      }
      if ((paramIntent.getAction().equals("android.net.wifi.STATE_CHANGE")) && (NewVoipMgr.m(NewVoipMgr.this) == 0L))
      {
        NewVoipMgr.b(NewVoipMgr.this, System.currentTimeMillis());
        AppMethodBeat.o(216272);
        return;
      }
      if ((paramIntent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) && (NewVoipMgr.m(NewVoipMgr.this) != 0L))
      {
        NewVoipMgr.c(NewVoipMgr.this, System.currentTimeMillis() - NewVoipMgr.m(NewVoipMgr.this));
        NewVoipMgr.b(NewVoipMgr.this, 0L);
      }
      AppMethodBeat.o(216272);
    }
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(216271);
      NewVoipMgr.r(NewVoipMgr.this);
      NewVoipMgr.s(NewVoipMgr.this);
      AppMethodBeat.o(216271);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.NewVoipMgr
 * JD-Core Version:    0.7.0.1
 */