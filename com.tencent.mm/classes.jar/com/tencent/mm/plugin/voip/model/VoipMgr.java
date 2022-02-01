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
import android.graphics.Point;
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
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.g.a.ya;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.g.a.zd;
import com.tencent.mm.g.a.zd.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.b.j;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.b.n;
import com.tencent.mm.plugin.voip.ui.VoipScoreDialog;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.b.e.a;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
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
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class VoipMgr
  extends com.tencent.mm.plugin.voip.a
{
  static int[] BZB = new int[2];
  static int lwn = 0;
  volatile com.tencent.mm.plugin.voip.ui.b BYA;
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
  private boolean BYR;
  private int BYS;
  private com.tencent.mm.plugin.voip.video.k BYU;
  private av BYV;
  private boolean BYW;
  private boolean BYX;
  private int BYY;
  private boolean BYZ;
  private com.tencent.mm.plugin.voip.b.c BYx;
  private m BYy;
  ap BZA;
  private long BZC;
  private boolean BZD;
  private int BZE;
  private int BZF;
  private BroadcastReceiver BZH;
  int BZJ;
  private com.tencent.mm.sdk.b.c BZK;
  private boolean BZb;
  private boolean BZd;
  private boolean BZe;
  private String BZf;
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
  PhoneStateListener BZz;
  private com.tencent.mm.plugin.voip.video.a CcP;
  private a CcQ;
  private com.tencent.mm.plugin.voip.widget.d CcR;
  private byte[] CcS;
  private ByteBuffer CcT;
  private int CcU;
  private boolean CcV;
  NetChangedBroadcastReceiver CcW;
  private j CcX;
  private com.tencent.mm.plugin.voip.b.a CcY;
  ap CcZ;
  boolean Cda;
  private String fGM;
  private ap jwD;
  private long lastShakeTime;
  PhoneStateListener ljq;
  private int mUIType;
  private CaptureView oXg;
  TelephonyManager oYl;
  private boolean pyt;
  private bk pyu;
  private SensorController pyv;
  private long tlk;
  private TelephonyManager uJU;
  private com.tencent.mm.sdk.b.c uJW;
  private long uMg;
  private boolean vNW;
  
  public VoipMgr()
  {
    AppMethodBeat.i(114994);
    this.CcQ = null;
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
    this.BYN = -1L;
    this.vNW = false;
    this.BYR = false;
    this.BYS = 0;
    this.BYU = new com.tencent.mm.plugin.voip.video.k();
    this.BYV = null;
    this.BYW = false;
    this.BYX = false;
    this.BYY = 0;
    this.BYZ = false;
    this.BZb = false;
    this.BZd = false;
    this.BZe = false;
    this.BZf = null;
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
    this.CcS = null;
    this.CcT = null;
    this.CcU = 0;
    this.CcV = true;
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
    this.CcZ = new ap("encodeVoipHandler");
    this.BZH = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(114963);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        paramAnonymousIntent = (PowerManager)aj.getContext().getSystemService("power");
        if (("android.intent.action.USER_PRESENT".equals(paramAnonymousContext)) && (paramAnonymousIntent.isScreenOn()))
        {
          VoipMgr.a(VoipMgr.this, false);
          AppMethodBeat.o(114963);
          return;
        }
        if ("android.intent.action.SCREEN_ON".equals(paramAnonymousContext))
        {
          VoipMgr.a(VoipMgr.this, false);
          VoipMgr.this.kn(true);
          AppMethodBeat.o(114963);
          return;
        }
        if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousContext))
        {
          VoipMgr.a(VoipMgr.this, true);
          if (!VoipMgr.a(VoipMgr.this)) {
            VoipMgr.this.kn(true);
          }
          if ((!com.tencent.mm.plugin.voip.b.l.UN(VoipMgr.b(VoipMgr.this).mState)) && (!VoipMgr.c(VoipMgr.this))) {
            VoipMgr.d(VoipMgr.this).evn();
          }
        }
        AppMethodBeat.o(114963);
      }
    };
    this.uJW = new com.tencent.mm.sdk.b.c() {};
    this.BZJ = 0;
    this.Cda = false;
    this.uMg = 0L;
    this.ljq = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        int i = 1;
        AppMethodBeat.i(216370);
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        ad.i("MicroMsg.Voip.VoipMgr", "onCallStateChanged :%d, isStartVoip: %b,oldState:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(VoipMgr.w(VoipMgr.this)), Integer.valueOf(VoipMgr.x(VoipMgr.this)) });
        if (!VoipMgr.w(VoipMgr.this))
        {
          AppMethodBeat.o(216370);
          return;
        }
        if (((VoipMgr.x(VoipMgr.this) == 0) && (paramAnonymousInt == 1)) || ((VoipMgr.x(VoipMgr.this) == 0) && (paramAnonymousInt == 2))) {
          VoipMgr.y(VoipMgr.this);
        }
        if (paramAnonymousInt == 1)
        {
          VoipMgr.b(VoipMgr.this, true);
          if (VoipMgr.x(VoipMgr.this) == 0) {
            VoipMgr.d(VoipMgr.this, System.currentTimeMillis());
          }
          VoipMgr.c(VoipMgr.this, 1);
          com.tencent.mm.plugin.voip.c.euM().Ug(1);
          VoipMgr.c(VoipMgr.this, true);
        }
        label327:
        label361:
        do
        {
          VoipMgr.d(VoipMgr.this).BZD = VoipMgr.F(VoipMgr.this);
          AppMethodBeat.o(216370);
          return;
          if (paramAnonymousInt == 2)
          {
            VoipMgr.b(VoipMgr.this, false);
            if (VoipMgr.x(VoipMgr.this) == 1) {
              VoipMgr.e(VoipMgr.this, System.currentTimeMillis());
            }
            VoipMgr.c(VoipMgr.this, 2);
            ad.i("MicroMsg.Voip.VoipMgr", "phone call coming now!");
            if ((VoipMgr.c(VoipMgr.this)) && (!com.tencent.mm.plugin.voip.b.l.UN(VoipMgr.b(VoipMgr.this).mState))) {
              com.tencent.mm.plugin.voip.c.euM().CdF.exT();
            }
            String str2;
            String str1;
            if (com.tencent.mm.plugin.voip.b.l.UN(VoipMgr.b(VoipMgr.this).mState))
            {
              paramAnonymousString = aj.getContext().getString(2131764803, new Object[] { VoipMgr.Bw(bt.rM(VoipMgr.z(VoipMgr.this))) });
              com.tencent.mm.plugin.voip.c.euM().exu();
              str2 = VoipMgr.A(VoipMgr.this).field_username;
              if (!VoipMgr.g(VoipMgr.this)) {
                break label596;
              }
              str1 = bu.IMe;
              if (!VoipMgr.c(VoipMgr.this)) {
                break label604;
              }
            }
            for (paramAnonymousInt = i;; paramAnonymousInt = 0)
            {
              s.c(str2, str1, paramAnonymousInt, 6, paramAnonymousString);
              VoipMgr.d(VoipMgr.this, 4107);
              VoipMgr.B(VoipMgr.this);
              paramAnonymousString = new bu();
              paramAnonymousString.setType(10000);
              paramAnonymousString.qA(System.currentTimeMillis());
              paramAnonymousString.setStatus(6);
              paramAnonymousString.setContent(aj.getContext().getString(2131764801) + ", <a href=\"weixin://voip/callagain/?username=" + VoipMgr.f(VoipMgr.this) + "&isvideocall=" + VoipMgr.g(VoipMgr.this) + "\">" + aj.getContext().getString(2131764796) + "</a>");
              if ((VoipMgr.f(VoipMgr.this) != null) && (!VoipMgr.f(VoipMgr.this).equals("")))
              {
                paramAnonymousString.tN(VoipMgr.f(VoipMgr.this));
                ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).dlK().as(paramAnonymousString);
              }
              com.tencent.mm.plugin.voip.c.euM().Ug(2);
              VoipMgr.c(VoipMgr.this, false);
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
        if ((VoipMgr.x(VoipMgr.this) == 1) || (VoipMgr.x(VoipMgr.this) == 2)) {
          VoipMgr.e(VoipMgr.this, System.currentTimeMillis());
        }
        VoipMgr.c(VoipMgr.this, 0);
        com.tencent.mm.plugin.voip.c.euM().Ug(2);
        if ((1 == VoipMgr.C(VoipMgr.this)) && (com.tencent.mm.plugin.voip.b.l.UN(VoipMgr.b(VoipMgr.this).mState)) && (VoipMgr.D(VoipMgr.this))) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(216366);
              VoipMgr.d(VoipMgr.this).cn(true);
              AppMethodBeat.o(216366);
            }
          });
        }
        if ((4 == VoipMgr.C(VoipMgr.this)) && (VoipMgr.D(VoipMgr.this))) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(216367);
              VoipMgr.d(VoipMgr.this).aB(VoipMgr.E(VoipMgr.this), VoipMgr.g(VoipMgr.this));
              AppMethodBeat.o(216367);
            }
          });
        }
        VoipMgr.b(VoipMgr.this, false);
        if (com.tencent.mm.plugin.audio.c.a.bGC().isBluetoothScoOn())
        {
          ad.i("MicroMsg.Voip.VoipMgr", "is bluetooth can use and start bluetooth");
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(216368);
              VoipMgr.d(VoipMgr.this).aB(VoipMgr.E(VoipMgr.this), VoipMgr.g(VoipMgr.this));
              AppMethodBeat.o(216368);
            }
          });
        }
        for (;;)
        {
          VoipMgr.c(VoipMgr.this, false);
          break;
          if (com.tencent.mm.plugin.audio.c.a.bGC().bGx()) {
            aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(216369);
                VoipMgr.d(VoipMgr.this).aB(VoipMgr.E(VoipMgr.this), VoipMgr.g(VoipMgr.this));
                AppMethodBeat.o(216369);
              }
            });
          }
        }
      }
    };
    this.BZK = new com.tencent.mm.sdk.b.c() {};
    this.BYx = new com.tencent.mm.plugin.voip.b.c();
    AppMethodBeat.o(114994);
  }
  
  private void E(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115047);
    if (this.BZE % 100 == 0) {
      if (paramArrayOfByte == null) {
        break label272;
      }
    }
    for (;;)
    {
      byte[] arrayOfByte;
      int i;
      try
      {
        if (paramArrayOfByte.length <= 0) {
          break label272;
        }
        arrayOfByte = new byte[5];
        i = paramInt1 * paramInt2 / 2;
        int j = paramInt1 / 2;
        int k = (paramInt2 - 34) * paramInt1 + paramInt1 - 34;
        if (k < paramArrayOfByte.length)
        {
          arrayOfByte[0] = paramArrayOfByte[(paramInt1 * 33 + 33)];
          arrayOfByte[1] = paramArrayOfByte[(paramInt1 * 34 - 34)];
          arrayOfByte[2] = paramArrayOfByte[(i + j)];
          arrayOfByte[3] = paramArrayOfByte[((paramInt2 - 34) * paramInt1 + 33)];
          arrayOfByte[4] = paramArrayOfByte[k];
          ad.i("MicroMsg.Voip.VoipMgr", "onFrameDataReady, sample sendData:[%s, %s, %s, %s, %s], captureFrameCount:%s", new Object[] { Byte.valueOf(arrayOfByte[0]), Byte.valueOf(arrayOfByte[1]), Byte.valueOf(arrayOfByte[2]), Byte.valueOf(arrayOfByte[3]), Byte.valueOf(arrayOfByte[4]), Integer.valueOf(this.BZE) });
          paramInt2 = 0;
          paramInt1 = 0;
          break label288;
          if (paramInt1 >= 5)
          {
            paramArrayOfByte = t.CdB;
            t.exq();
          }
          AppMethodBeat.o(115047);
          return;
        }
        ad.i("MicroMsg.Voip.VoipMgr", "sample check sendData error! %s", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
        AppMethodBeat.o(115047);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        ad.printErrStackTrace("MicroMsg.Voip.VoipMgr", paramArrayOfByte, "sampleCheckSendData error", new Object[0]);
      }
      AppMethodBeat.o(115047);
      return;
      label272:
      ad.i("MicroMsg.Voip.VoipMgr", "sample check sendData error is null or empty");
      AppMethodBeat.o(115047);
      return;
      label288:
      while (paramInt2 < 5)
      {
        i = paramInt1;
        if (arrayOfByte[paramInt2] == 0) {
          i = paramInt1 + 1;
        }
        paramInt2 += 1;
        paramInt1 = i;
      }
    }
  }
  
  private void TN(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(115019);
    ad.i("MicroMsg.Voip.VoipMgr", "hangupTalkingOrCancelInvite");
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
        ad.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call cancelCall");
        com.tencent.mm.plugin.voip.c.euM().CdF.exS();
      }
      ad.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call hangUp");
      com.tencent.mm.plugin.voip.c.euM().CdF.exV();
      if (4096 != this.BYK) {
        break label315;
      }
      tK(paramInt);
      evs();
      AppMethodBeat.o(115019);
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
        AppMethodBeat.i(216387);
        VoipMgr.d(VoipMgr.this);
        com.tencent.mm.plugin.voip.b.c.tz(VoipMgr.g(VoipMgr.this));
        AppMethodBeat.o(216387);
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
    AppMethodBeat.o(115019);
  }
  
  private boolean TO(int paramInt)
  {
    AppMethodBeat.i(115024);
    if (4111 == paramInt)
    {
      AppMethodBeat.o(115024);
      return true;
    }
    if ((4101 == paramInt) && ((com.tencent.mm.plugin.voip.b.l.UN(this.BYy.mState)) || (this.BYH)))
    {
      AppMethodBeat.o(115024);
      return true;
    }
    AppMethodBeat.o(115024);
    return false;
  }
  
  private static void TP(int paramInt)
  {
    AppMethodBeat.i(115025);
    zd localzd = new zd();
    localzd.dOk.dkM = paramInt;
    com.tencent.mm.sdk.b.a.IbL.l(localzd);
    AppMethodBeat.o(115025);
  }
  
  private boolean d(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(115053);
    String str = com.tencent.mm.n.g.acA().getValue("VOIPShortcutAutoadd");
    ad.i("MicroMsg.Voip.VoipMgr", "voip shortcut autoAdd is %s", new Object[] { str });
    if ((str != null) && (str.equals("0")) && (bt.rM(this.BYN) > 30L))
    {
      int i = paramSharedPreferences.getInt("voip_shortcut_prompt_times", 0);
      boolean bool = paramSharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
      if ((i < 3) && (!bool))
      {
        evB();
        paramSharedPreferences.edit().putInt("voip_shortcut_prompt_times", i + 1).commit();
        AppMethodBeat.o(115053);
        return true;
      }
    }
    else if ((str != null) && (str.equals("1")) && (bt.rM(this.BYN) > 15L))
    {
      e(paramSharedPreferences);
      AppMethodBeat.o(115053);
      return false;
    }
    AppMethodBeat.o(115053);
    return false;
  }
  
  private void e(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(115054);
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
      AppMethodBeat.o(115054);
      return;
      localIntent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(2131755764));
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getContext(), 2131234599));
      localIntent1.putExtra("shortcut_icon_resource_id", 2131234599);
    }
  }
  
  private boolean evA()
  {
    AppMethodBeat.i(115052);
    if (com.tencent.mm.plugin.voip.b.l.UN(this.BYy.mState))
    {
      SharedPreferences localSharedPreferences = getContext().getSharedPreferences("voip_plugin_prefs", 0);
      if (!localSharedPreferences.getBoolean("voip_shortcut_has_added", false))
      {
        boolean bool = d(localSharedPreferences);
        AppMethodBeat.o(115052);
        return bool;
      }
    }
    AppMethodBeat.o(115052);
    return false;
  }
  
  private void evB()
  {
    AppMethodBeat.i(115056);
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
          AppMethodBeat.i(216371);
          paramAnonymousDialogInterface = VoipMgr.G(VoipMgr.this).getSharedPreferences("voip_plugin_prefs", 0);
          VoipMgr.a(VoipMgr.this, paramAnonymousDialogInterface);
          if (4096 != VoipMgr.H(VoipMgr.this))
          {
            VoipMgr.d(VoipMgr.this, VoipMgr.H(VoipMgr.this));
            VoipMgr.I(VoipMgr.this);
          }
          if (VoipMgr.J(VoipMgr.this) != null) {
            VoipMgr.J(VoipMgr.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(114969);
                VoipMgr.r(VoipMgr.this);
                AppMethodBeat.o(114969);
              }
            });
          }
          AppMethodBeat.o(216371);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(114974);
          if (localCheckBox != null) {
            VoipMgr.G(VoipMgr.this).getSharedPreferences("voip_plugin_prefs", 0).edit().putBoolean("voip_shortcut_never_show_anymore", localCheckBox.isChecked()).commit();
          }
          if (4096 != VoipMgr.H(VoipMgr.this))
          {
            VoipMgr.d(VoipMgr.this, VoipMgr.H(VoipMgr.this));
            VoipMgr.I(VoipMgr.this);
          }
          if (VoipMgr.J(VoipMgr.this) != null) {
            VoipMgr.J(VoipMgr.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(114973);
                VoipMgr.r(VoipMgr.this);
                AppMethodBeat.o(114973);
              }
            });
          }
          AppMethodBeat.o(114974);
        }
      });
      AppMethodBeat.o(115056);
      return;
      localTextView.setText(2131764787);
    }
  }
  
  private void evF()
  {
    AppMethodBeat.i(115062);
    if (this.BYU != null) {
      this.BYU.b(this);
    }
    if (this.BYV != null)
    {
      ad.d("MicroMsg.Voip.VoipMgr", "stop face detect timer");
      this.BYV.stopTimer();
    }
    AppMethodBeat.o(115062);
  }
  
  private boolean evq()
  {
    int j = 0;
    AppMethodBeat.i(115021);
    if (!this.BYy.UR(4101))
    {
      AppMethodBeat.o(115021);
      return false;
    }
    this.BYI = false;
    if (this.CcR != null) {
      this.CcR.BYI = false;
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
        AppMethodBeat.o(115021);
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
    AppMethodBeat.i(115029);
    ad.d("MicroMsg.Voip.VoipMgr", "delayFinish");
    this.BZf = null;
    if (this.jwD != null) {
      this.jwD.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114964);
          VoipMgr localVoipMgr = VoipMgr.this;
          ad.i("MicroMsg.Voip.VoipMgr", "it is uninit voip report");
          if (localVoipMgr.BZA != null)
          {
            localVoipMgr.BZA.quit();
            localVoipMgr.BZA = null;
          }
          if (!localVoipMgr.BZx)
          {
            if (localVoipMgr.BZJ == 0) {
              localVoipMgr.TM(localVoipMgr.BZw);
            }
            if (localVoipMgr.BZJ != 0)
            {
              localVoipMgr.BZx = true;
              if (!localVoipMgr.BYH) {
                break label180;
              }
            }
          }
          label180:
          for (int i = 0;; i = 1)
          {
            f.a(i, System.currentTimeMillis(), localVoipMgr.BZw, localVoipMgr.BZw, 0, 0, VoipMgr.lwn / localVoipMgr.BZJ);
            VoipMgr.lwn = 0;
            VoipMgr.BZB[0] = 0;
            VoipMgr.BZB[1] = 0;
            localVoipMgr.BZJ = 0;
            if (localVoipMgr.oYl != null) {
              localVoipMgr.oYl.listen(localVoipMgr.BZz, 0);
            }
            if (localVoipMgr.CcW != null)
            {
              aj.getContext().unregisterReceiver(localVoipMgr.CcW);
              localVoipMgr.CcW = null;
            }
            VoipMgr.r(VoipMgr.this);
            AppMethodBeat.o(114964);
            return;
          }
        }
      }, 500L);
    }
    AppMethodBeat.o(115029);
  }
  
  private static void evt()
  {
    AppMethodBeat.i(216395);
    yb localyb = new yb();
    localyb.dMo.dsi = 11;
    com.tencent.mm.sdk.b.a.IbL.l(localyb);
    AppMethodBeat.o(216395);
  }
  
  private void evz()
  {
    AppMethodBeat.i(115048);
    synchronized (this.BYF)
    {
      ewO();
      com.tencent.mm.plugin.voip.b.c.unInit();
      this.BYx.evz();
      AppMethodBeat.o(115048);
      return;
    }
  }
  
  private void ewN()
  {
    AppMethodBeat.i(115043);
    if ((com.tencent.mm.compatible.util.d.ly(28)) && (this.BYI) && (this.CcP != null) && (!this.CcP.cLT()) && (this.BYA != null))
    {
      ad.i("MicroMsg.Voip.VoipMgr", "video call accept, not previewing, api level: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      this.CcP.eAl();
      this.BYA.eyH();
      int k = 320;
      int m = 240;
      int j = m;
      int i = k;
      if (this.CcP == null)
      {
        j = m;
        i = k;
        if (com.tencent.mm.plugin.voip.b.l.UO(this.BYy.mState))
        {
          this.oXg = new CaptureView(aj.getContext());
          ad.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
          i = 640;
          j = 480;
        }
      }
      this.CcP = new com.tencent.mm.plugin.voip.video.a(i, j);
      this.CcP.a(this, true);
      this.CcP.a(this.oXg);
      this.CcP.eAk();
      this.BZE = 0;
    }
    AppMethodBeat.o(115043);
  }
  
  private void ewO()
  {
    AppMethodBeat.i(115049);
    ad.l("MicroMsg.Voip.VoipMgr", "uninitCaptureRender", new Object[0]);
    if (this.CcP != null) {
      evF();
    }
    try
    {
      this.CcP.eAl();
      this.CcP = null;
      AppMethodBeat.o(115049);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.d("MicroMsg.Voip.VoipMgr", "stop capture error:" + localException.toString());
      }
    }
  }
  
  private void ewP()
  {
    AppMethodBeat.i(216397);
    ad.i("MicroMsg.Voip.VoipMgr", "uninitSurfaceTexture!");
    if (this.BYA != null) {
      this.BYA.releaseSurfaceTexture();
    }
    AppMethodBeat.o(216397);
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(115055);
    Context localContext1 = null;
    if (this.BYA != null) {
      localContext1 = this.BYA.eyI();
    }
    Context localContext2 = localContext1;
    if (localContext1 == null) {
      localContext2 = aj.getContext();
    }
    AppMethodBeat.o(115055);
    return localContext2;
  }
  
  private void gg(boolean paramBoolean)
  {
    AppMethodBeat.i(115030);
    ad.i("MicroMsg.Voip.VoipMgr", "finish");
    this.BZb = false;
    this.BZd = false;
    this.lastShakeTime = -1L;
    int i;
    Object localObject1;
    if (this.CcX != null) {
      if (this.CcY != null)
      {
        i = this.BZi;
        localObject1 = this.CcY;
        if ((i & 0x1) == 0) {
          break label773;
        }
        i = 1;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.voip.b.a)localObject1).T(false, i);
      this.CcY.ezm();
      this.CcX.ezN();
      if (this.CcZ != null)
      {
        this.CcZ.removeCallbacksAndMessages(null);
        this.CcZ = null;
      }
      if (this.BYS != -1)
      {
        com.tencent.mm.plugin.report.service.g.yhR.f(11700, new Object[] { Integer.valueOf(this.BYS), Long.valueOf(bt.rM(this.BYN)) });
        this.BYS = -1;
      }
      try
      {
        aj.getContext().unregisterReceiver(this.BZH);
        label165:
        com.tencent.mm.sdk.b.a.IbL.d(this.uJW);
        com.tencent.mm.sdk.b.a.IbL.d(this.BZK);
        ewP();
        if (this.BYA != null)
        {
          this.BYA.uninit();
          this.BYA = null;
          this.BYx.b(this.BYA);
        }
        this.oXg = null;
        label245:
        int j;
        label264:
        label329:
        long l;
        if (com.tencent.mm.plugin.voip.c.euM() != null)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.voip.c.euM().exv();
            if (!this.BYI) {
              break label791;
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
            break label806;
          }
          this.CcQ = new a();
          com.tencent.e.h.LTJ.aR(this.CcQ);
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
            ad.d("MicroMsg.Voip.VoipMgr", "removeSensorCallBack");
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
          ad.i("MicroMsg.Voip.VoipMgr", "finish, isFinishFromShutdown: %s", new Object[] { Boolean.valueOf(this.BYE) });
          if ((this.BYE) && (com.tencent.mm.plugin.voip.c.euM().exK()))
          {
            com.tencent.mm.plugin.voip.c.euM();
            VoipScoreState.exs();
            Object localObject2 = new Intent(getContext(), VoipScoreDialog.class);
            ((Intent)localObject2).putExtra("key_score_state", com.tencent.mm.plugin.voip.c.euM().exM());
            if (!(getContext() instanceof Activity)) {
              ((Intent)localObject2).addFlags(268435456);
            }
            localObject1 = getContext();
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahp(), "com/tencent/mm/plugin/voip/model/VoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/voip/model/VoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          com.tencent.mm.plugin.voip.c.euM().exL();
          evt();
          if (!this.BZs)
          {
            j = com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.roomId;
            l = com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.uLt;
            if (!this.BYH) {
              break label813;
            }
          }
        }
        label773:
        label791:
        label806:
        label813:
        for (i = 0;; i = 1)
        {
          f.c(j, l, i, 4);
          this.BZs = true;
          this.CcS = null;
          this.CcU = 0;
          ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
          com.tencent.mm.media.g.c.hkn.atJ();
          AppMethodBeat.o(115030);
          return;
          i = 0;
          break;
          com.tencent.mm.plugin.voip.c.euM().CdF.exV();
          break label245;
          com.tencent.mm.plugin.voip.c.euM().b(false, false, this.fGM);
          break label264;
          evz();
          break label329;
        }
      }
      catch (Exception localException)
      {
        break label165;
      }
    }
  }
  
  private static String sm(long paramLong)
  {
    AppMethodBeat.i(115045);
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
    AppMethodBeat.o(115045);
    return str;
  }
  
  private void tK(final int paramInt)
  {
    AppMethodBeat.i(115023);
    ad.l("MicroMsg.Voip.VoipMgr", "swtchState, action: %s, currentState: %s", new Object[] { com.tencent.mm.plugin.voip.b.l.UK(paramInt), com.tencent.mm.plugin.voip.b.l.UK(this.BYy.mState) });
    if ((4101 == paramInt) && (com.tencent.mm.plugin.voip.b.l.UO(this.BYy.mState)))
    {
      ewO();
      this.BYI = false;
      if (this.CcR != null) {
        this.CcR.BYI = false;
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
          AppMethodBeat.i(114991);
          if (VoipMgr.q(VoipMgr.this) != null) {
            VoipMgr.q(VoipMgr.this).iu(paramInt, VoipMgr.b(VoipMgr.this).mState);
          }
          AppMethodBeat.o(114991);
        }
      });
    }
    switch (this.BYy.mState)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(115023);
      return;
      TP(5);
      AppMethodBeat.o(115023);
      return;
      TP(6);
    }
  }
  
  private void tl(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(115015);
    if (this.BYI)
    {
      ad.i("MicroMsg.Voip.VoipMgr", "setCameraCaptureBind,  isFace: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      ad.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
      if (this.CcP == null) {
        this.CcP = new com.tencent.mm.plugin.voip.video.a(640, 480);
      }
      if (this.CcP.a(this, paramBoolean) != 1) {
        break label159;
      }
    }
    label159:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.CcV = paramBoolean;
      if ((this.CcV) && (this.oXg != null))
      {
        this.CcP.a(this.oXg);
        com.tencent.mm.plugin.voip.c.euM().Um(this.CcP.eAo());
        if (this.jwD != null) {
          this.jwD.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(216386);
              ad.d("MicroMsg.Voip.VoipMgr", "mCaptureRender == " + VoipMgr.e(VoipMgr.this));
              if (VoipMgr.e(VoipMgr.this) != null)
              {
                VoipMgr.e(VoipMgr.this).eAk();
                VoipMgr.p(VoipMgr.this);
              }
              AppMethodBeat.o(216386);
            }
          }, 50L);
        }
      }
      AppMethodBeat.o(115015);
      return;
    }
  }
  
  final void TM(int paramInt)
  {
    AppMethodBeat.i(115013);
    if (paramInt == 5)
    {
      lwn += BZB[0];
      this.BZJ += 1;
      ad.i("MicroMsg.Voip.VoipMgr", "mSignalStrength 4G" + BZB[0] + " and index is " + this.BZJ);
      AppMethodBeat.o(115013);
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
        ad.i("MicroMsg.Voip.VoipMgr", "error happened in get wifi info");
        continue;
      }
      lwn += BZB[1];
      this.BZJ += 1;
      ad.i("MicroMsg.Voip.VoipMgr", "mSignalStrength WIFI " + BZB[1] + " and index is " + this.BZJ);
      AppMethodBeat.o(115013);
      return;
      paramInt = localWifiManager.getConnectionInfo().getRssi();
    }
  }
  
  public final void TQ(int paramInt)
  {
    AppMethodBeat.i(115035);
    ad.i("MicroMsg.Voip.VoipMgr", "remote voip mode changed, cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    if (((1 == paramInt) || (3 == paramInt) || (5 == paramInt) || (6 == paramInt) || (7 == paramInt)) && (this.BYI))
    {
      tK(4101);
      com.tencent.mm.plugin.voip.c.euM().CdF.BXC.ewe();
      com.tencent.mm.plugin.voip.c.euM().CdF.BXC.ewf();
    }
    AppMethodBeat.o(115035);
  }
  
  public final void TR(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(115040);
    ad.i("MicroMsg.Voip.VoipMgr", "onSessionBeingCalled, callType: ".concat(String.valueOf(paramInt)));
    if (!this.BYy.UR(4110))
    {
      AppMethodBeat.o(115040);
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
      AppMethodBeat.o(115040);
      return;
    }
  }
  
  public final void TS(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(115041);
    ad.i("MicroMsg.Voip.VoipMgr", "steve:[simucall]onNewSimulCallAutoAccept, callType: ".concat(String.valueOf(paramInt)));
    if (!this.BYy.UR(4100))
    {
      AppMethodBeat.o(115041);
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
      AppMethodBeat.o(115041);
      return;
    }
  }
  
  public final void a(final Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(216388);
    ad.i("MicroMsg.Voip.VoipMgr", "start VoIP, userName: %s, isOutCall: %b, isVideoCall: %b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
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
    Object localObject1;
    label264:
    label311:
    Object localObject2;
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
          break label597;
        }
        i = 1;
        com.tencent.mm.plugin.voip.c.euM().Ue(1);
      }
      if (!paramBoolean1) {
        break label617;
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
            break label629;
          }
          i = 0;
          ((com.tencent.mm.plugin.report.service.g)localObject1).f(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
        }
        if (!bool2)
        {
          localObject1 = com.tencent.mm.plugin.report.service.g.yhR;
          if (!this.BYI) {
            break label635;
          }
          i = 0;
          ((com.tencent.mm.plugin.report.service.g)localObject1).f(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
        }
      }
      if ((!bool2) || (!bool1))
      {
        localObject1 = null;
        localObject2 = null;
        if ((bool1) || (bool2)) {
          break label641;
        }
        localObject1 = paramContext.getString(2131764920);
        localObject2 = paramContext.getString(2131764887);
        label382:
        com.tencent.mm.ui.base.h.a(paramContext, (String)localObject1, (String)localObject2, paramContext.getString(2131764890), true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(216382);
            ad.i("MicroMsg.Voip.VoipMgr", "show Permission settings");
            com.tencent.mm.compatible.d.b.bZ(paramContext);
            if (!VoipMgr.c(VoipMgr.this))
            {
              if (VoipMgr.g(VoipMgr.this))
              {
                VoipMgr.this.euY();
                AppMethodBeat.o(216382);
                return;
              }
              VoipMgr.this.evb();
              AppMethodBeat.o(216382);
              return;
            }
            if (VoipMgr.g(VoipMgr.this))
            {
              VoipMgr.this.evd();
              AppMethodBeat.o(216382);
              return;
            }
            VoipMgr.this.eve();
            AppMethodBeat.o(216382);
          }
        });
      }
      ad.i("MicroMsg.Voip.VoipMgr", "initMgr");
      com.tencent.mm.booter.a.Wt().Wv();
      if (!this.BYI) {
        break label693;
      }
      com.tencent.mm.plugin.voip.c.euM().b(true, true, this.fGM);
      label442:
      if (!this.BYH) {
        break label726;
      }
      com.tencent.mm.plugin.voip.c.euM().CdF.exR();
      if (!this.BYI) {
        break label708;
      }
      i = com.tencent.mm.plugin.voip.c.euM().aDH(this.BYG.field_username);
      label480:
      if (i >= 0) {
        break label726;
      }
      gg(false);
      i = 0;
      if (i != 0)
      {
        this.BYx.aC(paramBoolean2, paramBoolean1);
        if (paramBoolean2)
        {
          this.CcX = new j();
          this.CcY = new com.tencent.mm.plugin.voip.b.a();
          i = this.BZi;
          paramContext = this.CcY;
          if ((i & 0x1) == 0) {
            break label1157;
          }
        }
      }
    }
    label641:
    label1157:
    for (int i = 1;; i = 0)
    {
      paramContext.T(false, i);
      this.CcY.ezl();
      com.tencent.mm.plugin.voip.c.euM().a(paramString, this.BYI, false, paramLong);
      AppMethodBeat.o(216388);
      return;
      bool1 = false;
      break;
      label597:
      i = j;
      if (256 != j) {
        break label191;
      }
      i = 257;
      break label191;
      label617:
      this.BYy = com.tencent.mm.plugin.voip.b.l.UL(i);
      break label211;
      label629:
      i = 1;
      break label264;
      label635:
      i = 1;
      break label311;
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
      label693:
      com.tencent.mm.plugin.voip.c.euM().b(true, false, this.fGM);
      break label442;
      label708:
      i = com.tencent.mm.plugin.voip.c.euM().aDG(this.BYG.field_username);
      break label480;
      label726:
      com.tencent.mm.plugin.voip.c.euM().a(aj.getContext(), this);
      this.uJU = ((TelephonyManager)aj.getContext().getSystemService("phone"));
      this.uJU.listen(this.ljq, 32);
      paramContext = "voip_recent_contact" + com.tencent.mm.model.u.aAm();
      localObject1 = aj.getContext().getSharedPreferences("voip_plugin_prefs", 0);
      localObject2 = ((SharedPreferences)localObject1).getString(paramContext, null);
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
              label872:
              ((List)localObject2).add(0, this.fGM);
            }
            localObject2 = bt.m((List)localObject2, ";");
            ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
            label915:
            com.tencent.mm.sdk.b.a.IbL.c(this.BZK);
            com.tencent.mm.sdk.b.a.IbL.c(this.uJW);
            this.BYU.a(this);
            paramContext = new IntentFilter();
            paramContext.addAction("android.intent.action.SCREEN_ON");
            paramContext.addAction("android.intent.action.SCREEN_OFF");
            paramContext.addAction("android.intent.action.USER_PRESENT");
            aj.getContext().registerReceiver(this.BZH, paramContext);
            this.pyv = new SensorController(getContext());
            ad.i("MicroMsg.Voip.VoipMgr", "initMgr setSensorCallBack");
            this.pyv.a(this);
            if (this.pyu == null)
            {
              this.pyu = new bk(getContext());
              paramContext = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(216383);
                  VoipMgr.a(VoipMgr.this, bt.HI());
                  ad.i("MicroMsg.Voip.VoipMgr", "device happened shake in time,%s", new Object[] { Long.valueOf(VoipMgr.h(VoipMgr.this)) });
                  AppMethodBeat.o(216383);
                }
              };
              if (!this.pyu.aD(paramContext)) {
                break label1147;
              }
            }
          }
        }
      }
      label1147:
      for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
      {
        i = 1;
        break;
        if (4 != i) {
          break label872;
        }
        ((List)localObject2).remove(i - 1);
        break label872;
        localObject2 = new ArrayList();
        ((List)localObject2).add(0, this.fGM);
        localObject2 = bt.m((List)localObject2, ";");
        ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
        break label915;
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    AppMethodBeat.i(115016);
    ad.i("MicroMsg.Voip.VoipMgr", "onVoipUIDestroy");
    if (this.BYA == paramb)
    {
      ad.d("MicroMsg.Voip.VoipMgr", "same mVoIPUi, clear it");
      this.BYA = null;
      this.BYx.b(null);
    }
    if (this.jwD != null) {
      this.jwD = null;
    }
    AppMethodBeat.o(115016);
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb, int paramInt)
  {
    AppMethodBeat.i(115011);
    ad.i("MicroMsg.Voip.VoipMgr", "onVoipUICreated, uiType: %s, captureRender: %s, mVoicePlayDevice: %s", new Object[] { Integer.valueOf(paramInt), this.CcP, Integer.valueOf(this.BYM) });
    if ((1 == paramInt) && (this.BYA != null)) {
      this.BYA.uninit();
    }
    this.BYA = paramb;
    this.mUIType = paramInt;
    this.BYx.b(this.BYA);
    if ((this.CcP == null) && (com.tencent.mm.plugin.voip.b.l.UO(this.BYy.mState))) {
      this.oXg = new CaptureView(aj.getContext());
    }
    this.BYA.iu(-1, this.BYy.mState);
    this.BYA.setConnectSec(this.BYN);
    ad.i("MicroMsg.Voip.VoipMgr", "steve: voipMgr decMode:%d, beautyCmd:%d", new Object[] { Integer.valueOf(this.BZi), Integer.valueOf(this.BZj) });
    if (this.BZi != -1)
    {
      this.BYA.setHWDecMode(this.BZi);
      ad.i("MicroMsg.Voip.VoipMgr", "steve: voipMgr setHWDecMode,decMode:%d", new Object[] { Integer.valueOf(this.BZi) });
    }
    this.BYA.setVoipBeauty(this.BZj);
    com.tencent.mm.plugin.voip.video.b.e.eAV().Cql = new e.a()
    {
      public final void Dd()
      {
        AppMethodBeat.i(216384);
        VoipMgr localVoipMgr = VoipMgr.this;
        SurfaceTexture localSurfaceTexture = v2protocal.mSurfaceTexture;
        com.tencent.mm.media.g.d locald = v2protocal.Chn;
        if ((localVoipMgr.BYA != null) && (localSurfaceTexture != null))
        {
          localSurfaceTexture.setOnFrameAvailableListener(localVoipMgr);
          localVoipMgr.BYA.a(localSurfaceTexture, locald);
        }
        AppMethodBeat.o(216384);
      }
    };
    if ((this.BZu != 0) && (this.BZv != 0)) {
      ir(this.BZu, this.BZv);
    }
    AppMethodBeat.o(115011);
  }
  
  public final void a(VoIPRenderSurfaceView paramVoIPRenderSurfaceView) {}
  
  public final void a(VoIPRenderSurfaceView paramVoIPRenderSurfaceView, int paramInt) {}
  
  public final void a(VoIPRenderTextureView paramVoIPRenderTextureView) {}
  
  public final void a(VoIPRenderTextureView paramVoIPRenderTextureView, int paramInt) {}
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(115046);
    if (this.BYR)
    {
      AppMethodBeat.o(115046);
      return;
    }
    if (this.CcP == null)
    {
      ad.e("MicroMsg.Voip.VoipMgr", "onFrameDataReady, captureRender is null!");
      AppMethodBeat.o(115046);
      return;
    }
    int m;
    int n;
    label73:
    final ByteBuffer localByteBuffer;
    int i2;
    final int j;
    label103:
    final int i1;
    label116:
    final int k;
    final int i;
    if (this.CcP.eAm())
    {
      m = OpenGlRender.FLAG_Mirror;
      if (!this.CcP.eAn()) {
        break label470;
      }
      n = OpenGlRender.FLAG_Angle270;
      if (this.BYA != null)
      {
        localByteBuffer = null;
        i2 = 0;
        if ((OpenGlRender.getGLVersion() != 2) || (this.BZj == 0)) {
          break label478;
        }
        j = 1;
        if ((this.BZj & 0x8) == 0) {
          break label484;
        }
        i1 = 1;
        k = j;
        i = i2;
        if (j != 0)
        {
          if ((i1 != 0) || (this.BYA.Uu(2) == null)) {
            break label490;
          }
          i = 1;
          this.CcU = 0;
          k = j;
        }
        label159:
        if ((!this.CcP.eAm()) || (k == 0)) {
          break label682;
        }
        if (i != 1) {
          break label585;
        }
        localByteBuffer = this.BYA.Uu(2).hHi;
        if (localByteBuffer == null) {
          break label736;
        }
      }
    }
    label421:
    label440:
    label470:
    label478:
    label736:
    for (long l = localByteBuffer.capacity();; l = paramLong)
    {
      this.CcT = localByteBuffer;
      k = paramInt2;
      j = paramInt1;
      this.Cda = true;
      i2 = 4;
      Object localObject = null;
      i1 = k;
      k = j;
      j = i2;
      label245:
      ad.d("MicroMsg.Voip.VoipMgr", "jcchen capture data: w=" + paramInt1 + "h=" + paramInt2 + ", vw=" + k + "vh=" + i1 + ", bm=" + i + ", skip:" + this.BZF);
      i = (int)l;
      if (this.CcZ != null) {
        this.CcZ.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(114967);
            if (localByteBuffer != null)
            {
              com.tencent.mm.plugin.voip.c.euM().c(localByteBuffer, i, j, k, i1, 0);
              AppMethodBeat.o(114967);
              return;
            }
            if (this.Cdh != null)
            {
              u localu = com.tencent.mm.plugin.voip.c.euM();
              byte[] arrayOfByte = this.Cdh;
              int i = i;
              int j = j;
              int k = k;
              int m = i1;
              new Point(0, 0);
              localu.c(arrayOfByte, i, j, k, m);
            }
            AppMethodBeat.o(114967);
          }
        });
      }
      this.BYA.a(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, m, n);
      E((byte[])localObject, paramInt1, paramInt2);
      this.BZE += 1;
      boolean bool;
      if (m == OpenGlRender.FLAG_Mirror)
      {
        bool = true;
        this.BYX = bool;
        if (n != OpenGlRender.FLAG_Angle270) {
          break label717;
        }
        paramInt3 = 270;
        this.BYY = paramInt3;
        this.BYU.setPreviewSize(paramInt1, paramInt2);
        AppMethodBeat.o(115046);
        return;
        m = 0;
        break;
        n = OpenGlRender.FLAG_Angle90;
        break label73;
        j = 0;
        break label103;
        label484:
        i1 = 0;
        break label116;
        label490:
        if ((i1 != 0) && (this.BYA.Uu(1) != null) && (this.BYA.Uu(1).hHi != null))
        {
          i = 2;
          this.CcU = 0;
          k = j;
          break label159;
        }
        if ((this.CcS != null) && (this.CcU <= 10))
        {
          i = 3;
          this.CcU += 1;
          k = j;
          break label159;
        }
        k = 0;
        i = i2;
        break label159;
        if (i == 2)
        {
          localObject = this.BYA.Uu(1);
          localByteBuffer = ((com.tencent.mm.plugin.voip.video.b.a)localObject).hHi;
          if (localByteBuffer == null) {
            break label730;
          }
        }
      }
      for (l = localByteBuffer.capacity();; l = paramLong)
      {
        j = ((com.tencent.mm.plugin.voip.video.b.a)localObject).width;
        k = ((com.tencent.mm.plugin.voip.video.b.a)localObject).height;
        this.CcT = localByteBuffer;
        break;
        localByteBuffer = this.CcT;
        if (localByteBuffer != null) {}
        for (l = localByteBuffer.capacity();; l = paramLong)
        {
          this.CcT = localByteBuffer;
          k = paramInt2;
          j = paramInt1;
          break;
          j = paramInt3 + paramInt4;
          this.Cda = false;
          l = paramLong;
          i1 = paramInt2;
          k = paramInt1;
          localObject = paramArrayOfByte;
          break label245;
          bool = false;
          break label421;
          paramInt3 = 90;
          break label440;
        }
      }
    }
  }
  
  public final void a(final int[] paramArrayOfInt, final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(115063);
    if ((!this.CcV) && (this.BYI))
    {
      tl(true);
      this.CcV = true;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(216378);
        if (VoipMgr.e(VoipMgr.this) != null) {
          VoipMgr.e(VoipMgr.this).E(paramArrayOfInt);
        }
        if (VoipMgr.q(VoipMgr.this) != null) {
          VoipMgr.q(VoipMgr.this);
        }
        AppMethodBeat.o(216378);
      }
    });
    AppMethodBeat.o(115063);
  }
  
  public final void aDD(String paramString)
  {
    AppMethodBeat.i(216394);
    if (this.BYA != null)
    {
      this.BZf = paramString;
      this.BYA.aDI(paramString);
    }
    AppMethodBeat.o(216394);
  }
  
  public final void ae(long paramLong, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(216393);
    Object localObject;
    label50:
    boolean bool;
    if (this.CcX != null) {
      switch (paramInt)
      {
      default: 
        localObject = this.CcX;
        if (1 == this.mUIType)
        {
          bool = this.Cda;
          switch (paramInt)
          {
          }
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(216393);
      return;
      if (1 == this.mUIType)
      {
        if (!com.tencent.mm.plugin.voip.c.euM().CdT)
        {
          localObject = this.CcX;
          if ((260 != this.BYy.mState) && (6 != this.BYy.mState)) {}
          for (bool = true;; bool = false)
          {
            ((j)localObject).aD(true, bool);
            com.tencent.mm.plugin.voip.c.euM().CdT = true;
            break;
          }
        }
        localObject = this.CcX;
        if ((260 != this.BYy.mState) && (6 != this.BYy.mState)) {}
        for (bool = true;; bool = false)
        {
          ((j)localObject).aE(true, bool);
          break;
        }
      }
      if (!com.tencent.mm.plugin.voip.c.euM().CdS)
      {
        localObject = this.CcX;
        if ((260 != this.BYy.mState) && (6 != this.BYy.mState)) {}
        for (bool = true;; bool = false)
        {
          ((j)localObject).aD(false, bool);
          com.tencent.mm.plugin.voip.c.euM().CdS = true;
          break;
        }
      }
      localObject = this.CcX;
      if ((260 != this.BYy.mState) && (6 != this.BYy.mState)) {}
      for (bool = true;; bool = false)
      {
        ((j)localObject).aE(false, bool);
        break;
      }
      i = 0;
      break label50;
      ((j)localObject).ClB += 1;
      if (((j)localObject).ClB == 0)
      {
        if (i != 0)
        {
          if (paramLong != -1L)
          {
            localObject = com.tencent.mm.plugin.voip.b.g.Clr;
            com.tencent.mm.plugin.voip.b.g.BH(paramLong);
            AppMethodBeat.o(216393);
          }
        }
        else
        {
          if (paramLong != -1L)
          {
            localObject = com.tencent.mm.plugin.voip.b.g.Clr;
            com.tencent.mm.plugin.voip.b.g.BI(paramLong);
          }
          AppMethodBeat.o(216393);
        }
      }
      else if (((j)localObject).ClB == 60) {
        ((j)localObject).ClB = -1;
      }
      AppMethodBeat.o(216393);
      return;
      ((j)localObject).ClC += 1;
      if (((j)localObject).ClC == 0)
      {
        if (i != 0)
        {
          if (paramLong > 0L)
          {
            if (bool)
            {
              localObject = com.tencent.mm.plugin.voip.b.g.Clr;
              com.tencent.mm.plugin.voip.b.g.BO(paramLong);
              AppMethodBeat.o(216393);
              return;
            }
            localObject = com.tencent.mm.plugin.voip.b.g.Clr;
            com.tencent.mm.plugin.voip.b.g.BL(paramLong);
            AppMethodBeat.o(216393);
          }
        }
        else
        {
          if (paramLong > 0L)
          {
            if (bool)
            {
              localObject = com.tencent.mm.plugin.voip.b.g.Clr;
              com.tencent.mm.plugin.voip.b.g.BN(paramLong);
              AppMethodBeat.o(216393);
              return;
            }
            localObject = com.tencent.mm.plugin.voip.b.g.Clr;
            com.tencent.mm.plugin.voip.b.g.BM(paramLong);
          }
          AppMethodBeat.o(216393);
        }
      }
      else if (((j)localObject).ClC == 30) {
        ((j)localObject).ClC = -1;
      }
      AppMethodBeat.o(216393);
      return;
      ((j)localObject).ClD += 1;
      if (((j)localObject).ClD == 0)
      {
        if (i != 0)
        {
          localObject = com.tencent.mm.plugin.voip.b.g.Clr;
          com.tencent.mm.plugin.voip.b.g.BJ(paramLong);
          AppMethodBeat.o(216393);
          return;
        }
        localObject = com.tencent.mm.plugin.voip.b.g.Clr;
        com.tencent.mm.plugin.voip.b.g.BK(paramLong);
        AppMethodBeat.o(216393);
        return;
      }
      if (((j)localObject).ClD == 60) {
        ((j)localObject).ClD = -1;
      }
    }
  }
  
  public final void au(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(216392);
    if (this.CcX != null)
    {
      j localj = this.CcX;
      long l = bt.HI();
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          localj.ClF = l;
          AppMethodBeat.o(216392);
          return;
        }
        localj.Clx = l;
        AppMethodBeat.o(216392);
        return;
      }
      if (paramBoolean2)
      {
        localj.ClG = l;
        AppMethodBeat.o(216392);
        return;
      }
      localj.Cly = l;
    }
    AppMethodBeat.o(216392);
  }
  
  public final void bZW()
  {
    AppMethodBeat.i(115061);
    if ((true == this.vNW) || (this.BYA == null) || (this.BYA.eyI() == null))
    {
      ad.d("MicroMsg.Voip.VoipMgr", "onCameraError, already show");
      AppMethodBeat.o(115061);
      return;
    }
    if (this.CcP.cLT())
    {
      AppMethodBeat.o(115061);
      return;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("meizu")) && (!com.tencent.mm.compatible.d.b.abb()))
    {
      ad.d("MicroMsg.Voip.VoipMgr", "onCameraError, meizu machine");
      AppMethodBeat.o(115061);
      return;
    }
    if ((com.tencent.mm.compatible.util.d.ly(28)) && (((KeyguardManager)aj.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()))
    {
      ad.i("MicroMsg.Voip.VoipMgr", "api level: %s, in keyguard, ignore", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(115061);
      return;
    }
    ad.d("MicroMsg.Voip.VoipMgr", "onCameraError, show dialog");
    Object localObject = com.tencent.mm.plugin.report.service.g.yhR;
    if (this.BYI) {}
    for (int i = 0;; i = 1)
    {
      ((com.tencent.mm.plugin.report.service.g)localObject).f(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      localObject = com.tencent.mm.ui.base.h.l(this.BYA.eyI(), 2131764896, 2131755906);
      if (localObject != null) {
        break;
      }
      ad.e("MicroMsg.Voip.VoipMgr", "new dialog failed");
      AppMethodBeat.o(115061);
      return;
    }
    ((com.tencent.mm.ui.widget.a.d)localObject).setCancelable(false);
    ((com.tencent.mm.ui.widget.a.d)localObject).setCanceledOnTouchOutside(false);
    ((com.tencent.mm.ui.widget.a.d)localObject).show();
    this.vNW = true;
    com.tencent.mm.plugin.voip.b.i.ezO();
    AppMethodBeat.o(115061);
  }
  
  public final void d(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115036);
    if (this.BYA != null) {
      this.BYA.e(paramInt1, paramInt2, paramArrayOfByte);
    }
    AppMethodBeat.o(115036);
  }
  
  public final void dcY()
  {
    AppMethodBeat.i(115027);
    ad.i("MicroMsg.Voip.VoipMgr", "on accept");
    evn();
    tK(4100);
    AppMethodBeat.o(115027);
  }
  
  public final void dde()
  {
    AppMethodBeat.i(216396);
    ad.i("MicroMsg.Voip.VoipMgr", "onNetWorkChangeMobileNet");
    if (this.BYA != null) {
      this.BYA.eyK();
    }
    AppMethodBeat.o(216396);
  }
  
  public final void ddf()
  {
    AppMethodBeat.i(115051);
    ad.i("MicroMsg.Voip.VoipMgr", "onResumeGoodNetStatus");
    if (this.BYA != null) {
      this.BYA.deY();
    }
    AppMethodBeat.o(115051);
  }
  
  public final void dqh()
  {
    AppMethodBeat.i(184052);
    if (this.BYA != null) {
      this.BYA.dqh();
    }
    AppMethodBeat.o(184052);
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
    AppMethodBeat.i(115003);
    if (!this.BYy.UR(4103))
    {
      AppMethodBeat.o(115003);
      return false;
    }
    TN(4103);
    com.tencent.mm.plugin.voip.c.euM().exJ();
    AppMethodBeat.o(115003);
    return true;
  }
  
  public final boolean euX()
  {
    AppMethodBeat.i(115004);
    if (!this.BYy.UR(4101))
    {
      AppMethodBeat.o(115004);
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
      AppMethodBeat.o(115004);
      return true;
    }
  }
  
  public final boolean euY()
  {
    int i = 0;
    AppMethodBeat.i(115005);
    if (!this.BYy.UR(4099))
    {
      AppMethodBeat.o(115005);
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
      AppMethodBeat.o(115005);
      return true;
    }
  }
  
  public final boolean euZ()
  {
    AppMethodBeat.i(115006);
    if (!this.BYy.UR(4100))
    {
      AppMethodBeat.o(115006);
      return false;
    }
    if ((ae.gcE.fYe == 1) && (this.BYI)) {
      tl(true);
    }
    if (((!this.CcV) || (ae.gcE.fYe == 1) || (ae.gcE.fYf == 1)) && (this.BYI)) {
      if ((this.CcP != null) && (!this.CcP.eAm())) {
        break label152;
      }
    }
    label152:
    for (boolean bool = true;; bool = false)
    {
      tl(bool);
      this.CcV = true;
      ad.i("MicroMsg.Voip.VoipMgr", "onAcceptVideoInvite");
      evn();
      com.tencent.mm.plugin.voip.c.euM().aw(false, this.BYI);
      tK(4100);
      AppMethodBeat.o(115006);
      return true;
    }
  }
  
  public final void evC()
  {
    AppMethodBeat.i(115058);
    if ((256 != this.BYy.mState) && (257 != this.BYy.mState))
    {
      AppMethodBeat.o(115058);
      return;
    }
    if ((com.tencent.mm.kernel.g.ajC().ajl().getInt(327945, 0) == 0) && (this.BYA.eyI() != null))
    {
      com.tencent.mm.kernel.g.ajC().ajl().setInt(327945, 1);
      com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.a(this.BYA.eyI(), 2131764868, 2131755906, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(216373);
          VoipMgr.this.evE();
          AppMethodBeat.o(216373);
        }
      });
      locald.setCancelable(false);
      locald.setCanceledOnTouchOutside(false);
      locald.show();
      AppMethodBeat.o(115058);
      return;
    }
    n.gG(aj.getContext());
    evE();
    AppMethodBeat.o(115058);
  }
  
  public final void evD()
  {
    AppMethodBeat.i(115059);
    if (!this.BYW) {}
    for (boolean bool = true;; bool = false)
    {
      this.BYW = bool;
      if (!this.BYW) {
        break;
      }
      this.BYV.stopTimer();
      AppMethodBeat.o(115059);
      return;
    }
    if (this.BYV == null) {
      this.BYV = new av("faceDetect", new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(216377);
          VoipMgr.L(VoipMgr.this);
          AppMethodBeat.o(216377);
          return true;
        }
      }, true);
    }
    this.BYV.az(2000L, 2000L);
    this.BYW = false;
    AppMethodBeat.o(115059);
  }
  
  public final void evE()
  {
    AppMethodBeat.i(115060);
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
            AppMethodBeat.i(216374);
            VoipMgr.K(VoipMgr.this);
            AppMethodBeat.o(216374);
          }
        }, 2000L);
      }
      AppMethodBeat.o(115060);
      return;
      str1 = bu.IMd;
      break;
    }
  }
  
  public final void eva()
  {
    this.CcV = false;
  }
  
  public final boolean evb()
  {
    int i = 0;
    AppMethodBeat.i(115007);
    if (!this.BYy.UR(4099))
    {
      AppMethodBeat.o(115007);
      return false;
    }
    ad.i("MicroMsg.Voip.VoipMgr", "onRejectVoiceInvite");
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
      AppMethodBeat.o(115007);
      return true;
    }
  }
  
  public final boolean evc()
  {
    AppMethodBeat.i(115008);
    if (!this.BYy.UR(4100))
    {
      AppMethodBeat.o(115008);
      return false;
    }
    ad.i("MicroMsg.Voip.VoipMgr", "onAcceptVoiceInvite");
    evn();
    com.tencent.mm.plugin.voip.c.euM().aw(true, this.BYI);
    tK(4111);
    tK(4100);
    AppMethodBeat.o(115008);
    return true;
  }
  
  public final boolean evd()
  {
    AppMethodBeat.i(115009);
    if (!this.BYy.UR(4098))
    {
      AppMethodBeat.o(115009);
      return false;
    }
    ad.i("MicroMsg.Voip.VoipMgr", "onCancelVideoInvite");
    TN(4098);
    com.tencent.mm.plugin.voip.c.euM().exJ();
    AppMethodBeat.o(115009);
    return true;
  }
  
  public final boolean eve()
  {
    AppMethodBeat.i(115010);
    if (!this.BYy.UR(4098))
    {
      AppMethodBeat.o(115010);
      return false;
    }
    ad.i("MicroMsg.Voip.VoipMgr", "onCancelVoiceInvite");
    TN(4098);
    com.tencent.mm.plugin.voip.c.euM().exJ();
    AppMethodBeat.o(115010);
    return true;
  }
  
  public final void evf()
  {
    AppMethodBeat.i(115012);
    if ((this.BYI) && (this.BYA != null))
    {
      this.BYA.setCaptureView(this.oXg);
      if ((ae.gcE.fYe == 0) || (this.BYH)) {
        if ((this.CcP != null) && (!this.CcP.eAm())) {
          break label145;
        }
      }
    }
    label145:
    for (boolean bool = true;; bool = false)
    {
      tl(bool);
      if ((this.BYH) && (com.tencent.mm.plugin.voip.b.l.UP(this.BYy.mState)) && (com.tencent.mm.plugin.voip.c.euM().CdF.cae()))
      {
        this.BYx.aC(this.BYI, this.BYH);
        this.BYx.b("voip", Integer.valueOf(this.BYM));
      }
      AppMethodBeat.o(115012);
      return;
    }
  }
  
  public final void evg()
  {
    AppMethodBeat.i(115014);
    ad.i("MicroMsg.Voip.VoipMgr", "it is init voip report");
    this.CcW = new NetChangedBroadcastReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    aj.getContext().registerReceiver(this.CcW, localIntentFilter);
    this.oYl = ((TelephonyManager)aj.getContext().getSystemService("phone"));
    this.BZw = f.getNetType(getContext());
    this.BZz = new PhoneStateListener()
    {
      public final void onSignalStrengthsChanged(SignalStrength paramAnonymousSignalStrength)
      {
        AppMethodBeat.i(216385);
        super.onSignalStrengthsChanged(paramAnonymousSignalStrength);
        super.onSignalStrengthsChanged(paramAnonymousSignalStrength);
        paramAnonymousSignalStrength = paramAnonymousSignalStrength.toString().split(" ");
        try
        {
          if ((VoipMgr.i(VoipMgr.this).getNetworkType() == 13) && (paramAnonymousSignalStrength.length > 9)) {
            VoipMgr.aOb()[0] = bt.aRe(paramAnonymousSignalStrength[9]);
          }
          AppMethodBeat.o(216385);
          return;
        }
        catch (Exception paramAnonymousSignalStrength)
        {
          ad.printErrStackTrace("MicroMsg.Voip.VoipMgr", paramAnonymousSignalStrength, "", new Object[0]);
          AppMethodBeat.o(216385);
        }
      }
    };
    this.oYl.listen(this.BZz, 256);
    AppMethodBeat.o(115014);
  }
  
  public final void evi()
  {
    AppMethodBeat.i(115017);
    ad.i("MicroMsg.Voip.VoipMgr", "onSwitchCamera");
    if (this.CcP != null) {
      this.CcP.eAi();
    }
    com.tencent.mm.plugin.report.service.g.yhR.f(11079, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(115017);
  }
  
  public final void evj()
  {
    AppMethodBeat.i(115018);
    if (true != this.CcP.eAm()) {
      evi();
    }
    AppMethodBeat.o(115018);
  }
  
  public final void evk() {}
  
  public final void evl() {}
  
  public final void evm() {}
  
  public final void evn()
  {
    AppMethodBeat.i(216390);
    if (this.BYx != null)
    {
      ad.i("MicroMsg.Voip.VoipMgr", "use audioManager to stop voip ring");
      this.BYx.evn();
      AppMethodBeat.o(216390);
      return;
    }
    ad.i("MicroMsg.Voip.VoipMgr", "use Subcore to stop voip ring");
    com.tencent.mm.plugin.voip.c.euM().CdF.stopRing();
    AppMethodBeat.o(216390);
  }
  
  public final void evo()
  {
    AppMethodBeat.i(216391);
    this.BYA.evo();
    AppMethodBeat.o(216391);
  }
  
  public final boolean evp()
  {
    AppMethodBeat.i(115020);
    if (com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.roomId == 0)
    {
      this.BYL = true;
      AppMethodBeat.o(115020);
      return true;
    }
    boolean bool = evq();
    AppMethodBeat.o(115020);
    return bool;
  }
  
  public final void evr()
  {
    AppMethodBeat.i(115022);
    ad.i("MicroMsg.Voip.VoipMgr", "onRoomReady");
    if ((this.BYL) && (com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.roomId != 0))
    {
      this.BYL = false;
      evq();
    }
    if (this.BYH) {
      tK(4097);
    }
    AppMethodBeat.o(115022);
  }
  
  public final void evu()
  {
    AppMethodBeat.i(115031);
    ad.i("MicroMsg.Voip.VoipMgr", "onNoResp");
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
      AppMethodBeat.o(115031);
      return;
      str1 = bu.IMd;
      break;
    }
  }
  
  public final void evv()
  {
    int j = 0;
    AppMethodBeat.i(115033);
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
        break label205;
      }
    }
    label205:
    for (int i = j;; i = 1)
    {
      f.c(k, l1, i, 3);
      if (this.BZA != null) {
        this.BZA.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(114965);
            VoipMgr.a(VoipMgr.this, VoipMgr.j(VoipMgr.this));
            if (VoipMgr.s(VoipMgr.this) != null) {
              VoipMgr.s(VoipMgr.this).postDelayed(this, 5000L);
            }
            AppMethodBeat.o(114965);
          }
        });
      }
      AppMethodBeat.o(115033);
      return;
      i = 1;
      break;
    }
  }
  
  public final void evw()
  {
    int j = 0;
    AppMethodBeat.i(115034);
    ad.i("MicroMsg.Voip.VoipMgr", "onShutDown");
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
      f.c(k, l, i, 4);
      this.BZs = true;
      AppMethodBeat.o(115034);
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
    AppMethodBeat.i(115042);
    ad.d("MicroMsg.Voip.VoipMgr", "onPretreatmentForStartDev");
    this.BYx.aB(this.BZe, this.BYI);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114966);
          VoipMgr.t(VoipMgr.this);
          AppMethodBeat.o(114966);
        }
      });
      AppMethodBeat.o(115042);
      return;
    }
    ewN();
    AppMethodBeat.o(115042);
  }
  
  public final long evy()
  {
    AppMethodBeat.i(115044);
    ad.m("MicroMsg.Voip.VoipMgr", "totalDeviceNearTime: %s", new Object[] { Long.valueOf(this.BZm) });
    long l = this.BZm / 1000L;
    AppMethodBeat.o(115044);
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
    AppMethodBeat.i(115039);
    ad.i("MicroMsg.Voip.VoipMgr", "adjustHWViewAspectRatio, HWDecsize:%dx%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.BZu = paramInt1;
    this.BZv = paramInt2;
    if (this.BYA != null) {
      this.BYA.ir(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115039);
  }
  
  public final void kn(boolean paramBoolean)
  {
    AppMethodBeat.i(114995);
    ad.m("MicroMsg.Voip.VoipMgr", "onSensorEvent, isON: %s, lastIsDeviceNear: %s, deviceSwitchNearScreenTick: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.BZl), Long.valueOf(this.BZk) });
    if (this.BYy == null)
    {
      ad.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, not create stateMachine yet, ignore");
      AppMethodBeat.o(114995);
      return;
    }
    if (this.pyt)
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.pyt = paramBoolean;
        ad.i("MicroMsg.Voip.VoipMgr", "onSensorEvent has skip and val is %s", new Object[] { Boolean.valueOf(this.pyt) });
        AppMethodBeat.o(114995);
        return;
      }
    }
    if ((Math.abs(bt.HI() - this.BZn) < 500L) && (this.BZn != -1L))
    {
      ad.i("MicroMsg.Voip.VoipMgr", "onSensorEvent time interval too small");
      AppMethodBeat.o(114995);
      return;
    }
    if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qFl, true)) && (!paramBoolean) && (this.lastShakeTime != -1L) && (bt.aO(this.lastShakeTime) > 400L))
    {
      this.pyt = true;
      ad.i("MicroMsg.Voip.VoipMgr", "onSensorEvent has skip case shake near to small");
      AppMethodBeat.o(114995);
      return;
    }
    this.pyt = false;
    if ((com.tencent.mm.plugin.voip.b.l.UN(this.BYy.mState)) && ((this.BZl != paramBoolean) || (this.BZk == -1L)))
    {
      if ((!this.BZl) && (paramBoolean) && (!com.tencent.mm.plugin.voip.b.l.UO(this.BYy.mState)) && (this.mUIType != 2) && (this.BZk != -1L))
      {
        long l = bt.aO(this.BZk);
        ad.i("MicroMsg.Voip.VoipMgr", "accumulate near screen time: %s", new Object[] { Long.valueOf(l) });
        this.BZm += l;
      }
      this.BZk = bt.HI();
      this.BZl = paramBoolean;
    }
    if (this.BYA == null)
    {
      ad.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, voipUI is null, ignore");
      AppMethodBeat.o(114995);
      return;
    }
    if (((this.BYH) || (com.tencent.mm.plugin.voip.b.l.UN(this.BYy.mState))) && (!com.tencent.mm.plugin.voip.b.l.UO(this.BYy.mState)) && (this.mUIType != 2))
    {
      ad.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, isOn: ".concat(String.valueOf(paramBoolean)));
      this.BYA.setScreenEnable(paramBoolean);
      this.BYC = paramBoolean;
      this.BZn = bt.HI();
    }
    AppMethodBeat.o(114995);
  }
  
  public final void nL(int paramInt) {}
  
  public final void ny(boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(115050);
    ad.i("MicroMsg.Voip.VoipMgr", "onBadNetStatus");
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
      ad.i("MicroMsg.Voip.VoipMgr", i);
      localObject = com.tencent.mm.plugin.report.service.g.yhR;
      l = com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.uLt;
      i = j;
      if (paramBoolean) {
        i = 1;
      }
      ((com.tencent.mm.plugin.report.service.g)localObject).a(17151, true, true, new Object[] { Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(115050);
      return;
    }
  }
  
  public final void oG(boolean paramBoolean)
  {
    AppMethodBeat.i(115002);
    this.BYx.ty(paramBoolean);
    AppMethodBeat.o(115002);
  }
  
  public final void onConnected()
  {
    AppMethodBeat.i(115032);
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
    AppMethodBeat.o(115032);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(115026);
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
    ad.i("MicroMsg.Voip.VoipMgr", "onError, errCode: %s, roomId: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.roomId) });
    paramString = aj.getContext();
    ad.d("MicroMsg.Voip.VoipMgr", "getErrorMsgContent, errorCode".concat(String.valueOf(paramInt)));
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
        AppMethodBeat.o(115026);
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
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(115064);
    if (this.BYA != null) {
      this.BYA.requestRender();
    }
    AppMethodBeat.o(115064);
  }
  
  public final void onReject()
  {
    AppMethodBeat.i(115028);
    ad.i("MicroMsg.Voip.VoipMgr", "onReject");
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
      AppMethodBeat.o(115028);
      return;
      str1 = bu.IMd;
      break;
    }
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115038);
    this.BZi = paramInt;
    if (this.BYA != null) {
      this.BYA.setHWDecMode(paramInt);
    }
    if (this.CcX != null)
    {
      Object localObject;
      if (this.CcY != null)
      {
        localObject = this.CcY;
        if ((paramInt & 0x1) == 0) {
          break label96;
        }
      }
      label96:
      for (int i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.voip.b.a)localObject).T(false, i);
        this.CcY.ezl();
        localObject = this.CcX;
        if ((paramInt & 0x1) == 0) {
          break;
        }
        ((j)localObject).Clt += 1L;
        AppMethodBeat.o(115038);
        return;
      }
      ((j)localObject).Clu += 1L;
    }
    AppMethodBeat.o(115038);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    this.BYM = paramInt;
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115037);
    ad.i("MicroMsg.Voip.VoipMgr", "setVoipBeauty, isON: " + paramInt + "，mVoipUI: " + this.BYA);
    if (this.BYA != null) {
      this.BYA.setVoipBeauty(paramInt);
    }
    if ((paramInt != 0) && (this.BZj != paramInt)) {
      com.tencent.mm.plugin.report.service.g.yhR.n(914L, 20L, 1L);
    }
    this.BZF = 2;
    this.BZj = paramInt;
    AppMethodBeat.o(115037);
  }
  
  public final void ta(boolean paramBoolean)
  {
    AppMethodBeat.i(216389);
    if ((this.BYy != null) && (this.BYy.mState >= 0) && (this.BYy.mState <= 8)) {}
    for (int i = 1; i == 0; i = 0)
    {
      ad.i("MicroMsg.Voip.VoipMgr", "steve:[simucall] same state, no need to reset, return!");
      AppMethodBeat.o(216389);
      return;
    }
    int j = com.tencent.mm.plugin.voip.b.l.aF(false, paramBoolean);
    i = j;
    if (this.BYJ)
    {
      if (j != 0) {
        break label136;
      }
      i = 1;
    }
    for (;;)
    {
      this.BYy = com.tencent.mm.plugin.voip.b.l.UL(i);
      ad.i("MicroMsg.Voip.VoipMgr", "steve:[simucall] resetStateMachine, initState:%d,isOutCall:%s,isVideoCall:%s", new Object[] { Integer.valueOf(i), Boolean.FALSE, Boolean.valueOf(paramBoolean) });
      this.BYH = false;
      AppMethodBeat.o(216389);
      return;
      label136:
      i = j;
      if (256 == j) {
        i = 257;
      }
    }
  }
  
  public final void td(boolean paramBoolean)
  {
    AppMethodBeat.i(115001);
    ad.i("MicroMsg.Voip.VoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.BYx.cn(paramBoolean);
    this.BYx.Cla = true;
    AppMethodBeat.o(115001);
  }
  
  public final void te(boolean paramBoolean) {}
  
  public final boolean tf(final boolean paramBoolean)
  {
    AppMethodBeat.i(115057);
    if (com.tencent.mm.plugin.voip.c.euM().CdU)
    {
      ad.i("MicroMsg.Voip.VoipMgr", "current state is mini, cannot mini!");
      AppMethodBeat.o(115057);
      return false;
    }
    if ((this.BZd) && (!paramBoolean))
    {
      ad.i("MicroMsg.Voip.VoipMgr", "has phone call  cannot mini!");
      AppMethodBeat.o(115057);
      return false;
    }
    ad.l("MicroMsg.Voip.VoipMgr", "miniOnlyHidenVoip: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ad.i("MicroMsg.Voip.VoipMgr", "onMinimizeVoip, async to minimize");
    if (this.BYA != null)
    {
      this.BYA.uninit();
      this.BYA = null;
      this.BYx.b(this.BYA);
    }
    if (this.CcR != null) {
      this.CcR.uninit();
    }
    if (this.jwD != null) {
      this.jwD.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(216372);
          VoipMgr.d(VoipMgr.this, paramBoolean);
          AppMethodBeat.o(216372);
        }
      });
    }
    AppMethodBeat.o(115057);
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
      AppMethodBeat.i(114993);
      if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
      {
        switch (f.getNetType(paramContext))
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
                AppMethodBeat.o(114993);
                return;
              } while (VoipMgr.j(VoipMgr.this) == 5);
              j = VoipMgr.aOb()[1];
              if (VoipMgr.k(VoipMgr.this) == 0) {
                VoipMgr.a(VoipMgr.this, 4);
              }
            } while (VoipMgr.k(VoipMgr.this) == 0);
            k = VoipMgr.dsn() / VoipMgr.k(VoipMgr.this);
            VoipMgr.a(VoipMgr.this, 5);
            m = VoipMgr.aOb()[0];
            ad.i("MicroMsg.Voip.VoipMgr", "befor change to 4G and cost " + VoipMgr.l(VoipMgr.this));
            if (VoipMgr.c(VoipMgr.this)) {}
            for (;;)
            {
              f.a(i, System.currentTimeMillis(), VoipMgr.j(VoipMgr.this), 5, j, m, k);
              VoipMgr.m(VoipMgr.this);
              VoipMgr.b(VoipMgr.this, 5);
              VoipMgr.dsp();
              VoipMgr.n(VoipMgr.this);
              AppMethodBeat.o(114993);
              return;
              i = 1;
            }
          } while (VoipMgr.j(VoipMgr.this) == 4);
          k = VoipMgr.aOb()[0];
          if (VoipMgr.k(VoipMgr.this) == 0) {
            VoipMgr.a(VoipMgr.this, 5);
          }
        } while (VoipMgr.k(VoipMgr.this) == 0);
        int m = VoipMgr.dsn() / VoipMgr.k(VoipMgr.this);
        VoipMgr.a(VoipMgr.this, 4);
        int n = VoipMgr.aOb()[1];
        ad.i("MicroMsg.Voip.VoipMgr", "befor change to wifi and cost " + VoipMgr.l(VoipMgr.this));
        if (VoipMgr.c(VoipMgr.this)) {}
        for (i = j;; i = 1)
        {
          f.a(i, System.currentTimeMillis(), VoipMgr.j(VoipMgr.this), 4, k, n, m);
          VoipMgr.m(VoipMgr.this);
          VoipMgr.b(VoipMgr.this, 4);
          VoipMgr.dsp();
          VoipMgr.n(VoipMgr.this);
          break;
        }
      }
      if ((paramIntent.getAction().equals("android.net.wifi.STATE_CHANGE")) && (VoipMgr.o(VoipMgr.this) == 0L))
      {
        VoipMgr.b(VoipMgr.this, System.currentTimeMillis());
        AppMethodBeat.o(114993);
        return;
      }
      if ((paramIntent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) && (VoipMgr.o(VoipMgr.this) != 0L))
      {
        VoipMgr.c(VoipMgr.this, System.currentTimeMillis() - VoipMgr.o(VoipMgr.this));
        VoipMgr.b(VoipMgr.this, 0L);
      }
      AppMethodBeat.o(114993);
    }
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(114992);
      VoipMgr.u(VoipMgr.this);
      VoipMgr.v(VoipMgr.this);
      AppMethodBeat.o(114992);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr
 * JD-Core Version:    0.7.0.1
 */