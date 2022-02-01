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
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.g.a.aaq;
import com.tencent.mm.g.a.aaq.a;
import com.tencent.mm.g.a.zi;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.ui.VoipScoreDialog;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.b.e.a;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
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
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class VoipMgr
  extends com.tencent.mm.plugin.voip.a
{
  static int[] GUR = new int[2];
  static int mHZ = 0;
  private com.tencent.mm.plugin.voip.b.b GTV;
  private com.tencent.mm.plugin.voip.b.l GTW;
  volatile com.tencent.mm.plugin.voip.ui.b GTY;
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
  PhoneStateListener GUP;
  MMHandler GUQ;
  private long GUS;
  private boolean GUT;
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
  private boolean GUu;
  private boolean GUw;
  private boolean GUx;
  private String GUy;
  private com.tencent.mm.plugin.voip.video.camera.prev.a GXZ;
  private a GYa;
  private boolean GYb;
  private com.tencent.mm.plugin.voip.widget.d GYc;
  private byte[] GYd;
  private ByteBuffer GYe;
  private int GYf;
  private boolean GYg;
  NetChangedBroadcastReceiver GYh;
  private int GYi;
  private int GYj;
  private com.tencent.mm.plugin.voip.b.i GYk;
  private com.tencent.mm.plugin.voip.b.a GYl;
  MMHandler GYm;
  boolean GYn;
  private String goe;
  private MMHandler kAn;
  private int mUIType;
  PhoneStateListener mtH;
  private CaptureView qsJ;
  TelephonyManager qtS;
  private long wNg;
  private TelephonyManager yoi;
  private IListener yok;
  private long yqt;
  private boolean zuc;
  
  public VoipMgr()
  {
    AppMethodBeat.i(114994);
    this.GYa = null;
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
    this.GYb = false;
    this.GUm = 0;
    this.GUn = new com.tencent.mm.plugin.voip.video.f();
    this.GUo = null;
    this.GUp = false;
    this.GUq = false;
    this.GUr = 0;
    this.GUs = false;
    this.GUu = false;
    this.GUw = false;
    this.GUx = false;
    this.GUy = null;
    this.GUB = -1;
    this.GUC = 0;
    this.GUD = 0;
    this.GUE = 0L;
    this.GUF = 0L;
    this.GUG = 0;
    this.GUH = false;
    this.GUI = false;
    this.GUJ = 0;
    this.GYd = null;
    this.GYe = null;
    this.GYf = 0;
    this.GYg = true;
    this.GUK = 0;
    this.GUL = 0;
    this.GUM = 0;
    this.GUN = false;
    this.GUQ = new MMHandler("getSignalStrength");
    this.qtS = null;
    this.wNg = 0L;
    this.GUS = 0L;
    this.GUT = false;
    this.GYi = 0;
    this.GYj = 0;
    this.GYm = new MMHandler("encodeVoipHandler");
    this.GUV = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(114963);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        paramAnonymousIntent = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
        if (("android.intent.action.USER_PRESENT".equals(paramAnonymousContext)) && (paramAnonymousIntent.isScreenOn()))
        {
          VoipMgr.a(VoipMgr.this, false);
          AppMethodBeat.o(114963);
          return;
        }
        if ("android.intent.action.SCREEN_ON".equals(paramAnonymousContext))
        {
          VoipMgr.a(VoipMgr.this, false);
          VoipMgr.a(VoipMgr.this).onSensorEvent(true);
          AppMethodBeat.o(114963);
          return;
        }
        if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousContext))
        {
          VoipMgr.a(VoipMgr.this, true);
          if (!VoipMgr.b(VoipMgr.this)) {
            VoipMgr.a(VoipMgr.this).onSensorEvent(true);
          }
          if ((!com.tencent.mm.plugin.voip.b.k.adP(VoipMgr.c(VoipMgr.this).mState)) && (!VoipMgr.d(VoipMgr.this))) {
            VoipMgr.a(VoipMgr.this).fFK();
          }
        }
        AppMethodBeat.o(114963);
      }
    };
    this.yok = new IListener() {};
    this.GUW = 0;
    this.GYn = false;
    this.yqt = 0L;
    this.mtH = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        int i = 1;
        AppMethodBeat.i(235616);
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        Log.i("MicroMsg.Voip.VoipMgr", "onCallStateChanged :%d, isStartVoip: %b,oldState:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(VoipMgr.w(VoipMgr.this)), Integer.valueOf(VoipMgr.x(VoipMgr.this)) });
        if (!VoipMgr.w(VoipMgr.this))
        {
          AppMethodBeat.o(235616);
          return;
        }
        if (((VoipMgr.x(VoipMgr.this) == 0) && (paramAnonymousInt == 1)) || ((VoipMgr.x(VoipMgr.this) == 0) && (paramAnonymousInt == 2))) {
          VoipMgr.y(VoipMgr.this);
        }
        if (paramAnonymousInt == 1)
        {
          VoipMgr.c(VoipMgr.this, true);
          if (VoipMgr.x(VoipMgr.this) == 0) {
            VoipMgr.c(VoipMgr.this, System.currentTimeMillis());
          }
          VoipMgr.c(VoipMgr.this, 1);
          com.tencent.mm.plugin.voip.c.fFg().adh(1);
          VoipMgr.d(VoipMgr.this, true);
        }
        label327:
        label361:
        do
        {
          VoipMgr.a(VoipMgr.this).GUT = VoipMgr.F(VoipMgr.this);
          AppMethodBeat.o(235616);
          return;
          if (paramAnonymousInt == 2)
          {
            VoipMgr.c(VoipMgr.this, false);
            if (VoipMgr.x(VoipMgr.this) == 1) {
              VoipMgr.d(VoipMgr.this, System.currentTimeMillis());
            }
            VoipMgr.c(VoipMgr.this, 2);
            Log.i("MicroMsg.Voip.VoipMgr", "phone call coming now!");
            if ((VoipMgr.d(VoipMgr.this)) && (!com.tencent.mm.plugin.voip.b.k.adP(VoipMgr.c(VoipMgr.this).mState))) {
              com.tencent.mm.plugin.voip.c.fFg().GYS.fIv();
            }
            String str2;
            String str1;
            if (com.tencent.mm.plugin.voip.b.k.adP(VoipMgr.c(VoipMgr.this).mState))
            {
              paramAnonymousString = MMApplicationContext.getContext().getString(2131767241, new Object[] { VoipMgr.Lh(Util.secondsToNow(VoipMgr.z(VoipMgr.this))) });
              com.tencent.mm.plugin.voip.c.fFg().fHS();
              str2 = VoipMgr.A(VoipMgr.this).field_username;
              if (!VoipMgr.g(VoipMgr.this)) {
                break label595;
              }
              str1 = ca.OqC;
              if (!VoipMgr.d(VoipMgr.this)) {
                break label603;
              }
            }
            for (paramAnonymousInt = i;; paramAnonymousInt = 0)
            {
              s.c(str2, str1, paramAnonymousInt, 6, paramAnonymousString);
              VoipMgr.d(VoipMgr.this, 4107);
              VoipMgr.B(VoipMgr.this);
              paramAnonymousString = new ca();
              paramAnonymousString.setType(10000);
              paramAnonymousString.setCreateTime(System.currentTimeMillis());
              paramAnonymousString.setStatus(6);
              paramAnonymousString.setContent(MMApplicationContext.getContext().getString(2131767239) + ", <a href=\"weixin://voip/callagain/?username=" + VoipMgr.f(VoipMgr.this) + "&isvideocall=" + VoipMgr.g(VoipMgr.this) + "\">" + MMApplicationContext.getContext().getString(2131767234) + "</a>");
              if ((VoipMgr.f(VoipMgr.this) != null) && (!VoipMgr.f(VoipMgr.this).equals("")))
              {
                paramAnonymousString.Cy(VoipMgr.f(VoipMgr.this));
                ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().aC(paramAnonymousString);
              }
              com.tencent.mm.plugin.voip.c.fFg().adh(2);
              VoipMgr.d(VoipMgr.this, false);
              break;
              paramAnonymousString = MMApplicationContext.getContext().getString(2131767237);
              break label327;
              str1 = ca.OqB;
              break label361;
            }
          }
        } while (paramAnonymousInt != 0);
        label595:
        label603:
        if ((VoipMgr.x(VoipMgr.this) == 1) || (VoipMgr.x(VoipMgr.this) == 2)) {
          VoipMgr.d(VoipMgr.this, System.currentTimeMillis());
        }
        VoipMgr.c(VoipMgr.this, 0);
        com.tencent.mm.plugin.voip.c.fFg().adh(2);
        if ((1 == VoipMgr.C(VoipMgr.this)) && (com.tencent.mm.plugin.voip.b.k.adP(VoipMgr.c(VoipMgr.this).mState)) && (VoipMgr.D(VoipMgr.this))) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(235612);
              VoipMgr.a(VoipMgr.this).cV(true);
              AppMethodBeat.o(235612);
            }
          });
        }
        if ((4 == VoipMgr.C(VoipMgr.this)) && (VoipMgr.D(VoipMgr.this))) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(235613);
              VoipMgr.a(VoipMgr.this).aM(VoipMgr.E(VoipMgr.this), VoipMgr.g(VoipMgr.this));
              AppMethodBeat.o(235613);
            }
          });
        }
        VoipMgr.c(VoipMgr.this, false);
        if (com.tencent.mm.plugin.audio.c.a.cea().isBluetoothScoOn())
        {
          Log.i("MicroMsg.Voip.VoipMgr", "is bluetooth can use and start bluetooth");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(235614);
              VoipMgr.a(VoipMgr.this).aM(VoipMgr.E(VoipMgr.this), VoipMgr.g(VoipMgr.this));
              AppMethodBeat.o(235614);
            }
          });
        }
        for (;;)
        {
          VoipMgr.d(VoipMgr.this, false);
          break;
          if (com.tencent.mm.plugin.audio.c.a.cea().cdW()) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(235615);
                VoipMgr.a(VoipMgr.this).aM(VoipMgr.E(VoipMgr.this), VoipMgr.g(VoipMgr.this));
                AppMethodBeat.o(235615);
              }
            });
          }
        }
      }
    };
    this.GUX = new IListener() {};
    this.GTV = new com.tencent.mm.plugin.voip.b.b();
    AppMethodBeat.o(114994);
  }
  
  private static String AF(long paramLong)
  {
    AppMethodBeat.i(115045);
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
    AppMethodBeat.o(115045);
    return str;
  }
  
  private void P(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115047);
    if (this.GYi % 100 == 0) {
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
          Log.i("MicroMsg.Voip.VoipMgr", "onFrameDataReady, sample sendData:[%s, %s, %s, %s, %s], captureFrameCount:%s", new Object[] { Byte.valueOf(arrayOfByte[0]), Byte.valueOf(arrayOfByte[1]), Byte.valueOf(arrayOfByte[2]), Byte.valueOf(arrayOfByte[3]), Byte.valueOf(arrayOfByte[4]), Integer.valueOf(this.GYi) });
          paramInt2 = 0;
          paramInt1 = 0;
          break label288;
          if (paramInt1 >= 5)
          {
            paramArrayOfByte = t.GYO;
            t.fHO();
          }
          AppMethodBeat.o(115047);
          return;
        }
        Log.i("MicroMsg.Voip.VoipMgr", "sample check sendData error! %s", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
        AppMethodBeat.o(115047);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        Log.printErrStackTrace("MicroMsg.Voip.VoipMgr", paramArrayOfByte, "sampleCheckSendData error", new Object[0]);
      }
      AppMethodBeat.o(115047);
      return;
      label272:
      Log.i("MicroMsg.Voip.VoipMgr", "sample check sendData error is null or empty");
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
  
  private void acN(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(115019);
    Log.i("MicroMsg.Voip.VoipMgr", "hangupTalkingOrCancelInvite");
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
        Log.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call cancelCall");
        com.tencent.mm.plugin.voip.c.fFg().GYS.fIu();
      }
      Log.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call hangUp");
      com.tencent.mm.plugin.voip.c.fFg().GYS.fIx();
      if (4096 != this.GUi) {
        break label315;
      }
      xN(paramInt);
      fFP();
      AppMethodBeat.o(115019);
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
        AppMethodBeat.i(235633);
        VoipMgr.a(VoipMgr.this).xq(VoipMgr.g(VoipMgr.this));
        AppMethodBeat.o(235633);
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
    AppMethodBeat.o(115019);
  }
  
  private boolean acO(int paramInt)
  {
    AppMethodBeat.i(115024);
    if (4111 == paramInt)
    {
      AppMethodBeat.o(115024);
      return true;
    }
    if ((4101 == paramInt) && ((com.tencent.mm.plugin.voip.b.k.adP(this.GTW.mState)) || (this.GUf)))
    {
      AppMethodBeat.o(115024);
      return true;
    }
    AppMethodBeat.o(115024);
    return false;
  }
  
  private static void acP(int paramInt)
  {
    AppMethodBeat.i(115025);
    aaq localaaq = new aaq();
    localaaq.ehD.dDe = paramInt;
    EventCenter.instance.publish(localaaq);
    AppMethodBeat.o(115025);
  }
  
  private boolean c(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(115053);
    String str = com.tencent.mm.n.h.aqJ().getValue("VOIPShortcutAutoadd");
    Log.i("MicroMsg.Voip.VoipMgr", "voip shortcut autoAdd is %s", new Object[] { str });
    if ((str != null) && (str.equals("0")) && (Util.secondsToNow(this.GUl) > 30L))
    {
      int i = paramSharedPreferences.getInt("voip_shortcut_prompt_times", 0);
      boolean bool = paramSharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
      if ((i < 3) && (!bool))
      {
        fFX();
        paramSharedPreferences.edit().putInt("voip_shortcut_prompt_times", i + 1).commit();
        AppMethodBeat.o(115053);
        return true;
      }
    }
    else if ((str != null) && (str.equals("1")) && (Util.secondsToNow(this.GUl) > 15L))
    {
      d(paramSharedPreferences);
      AppMethodBeat.o(115053);
      return false;
    }
    AppMethodBeat.o(115053);
    return false;
  }
  
  private void d(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(115054);
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
      AppMethodBeat.o(115054);
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
    AppMethodBeat.i(115021);
    if (!this.GTW.adT(4101))
    {
      AppMethodBeat.o(115021);
      return false;
    }
    this.GUg = false;
    if (this.GYc != null) {
      this.GYc.GUg = false;
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
        AppMethodBeat.o(115021);
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
    AppMethodBeat.i(115029);
    Log.d("MicroMsg.Voip.VoipMgr", "delayFinish");
    this.GUy = null;
    if (this.kAn != null) {
      this.kAn.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114964);
          VoipMgr localVoipMgr = VoipMgr.this;
          Log.i("MicroMsg.Voip.VoipMgr", "it is uninit voip report");
          if (localVoipMgr.GUQ != null)
          {
            localVoipMgr.GUQ.quit();
            localVoipMgr.GUQ = null;
          }
          if (!localVoipMgr.GUN)
          {
            if (localVoipMgr.GUW == 0) {
              localVoipMgr.acM(localVoipMgr.GUM);
            }
            if (localVoipMgr.GUW != 0)
            {
              localVoipMgr.GUN = true;
              if (!localVoipMgr.GUf) {
                break label259;
              }
            }
          }
          label259:
          for (int i = 0;; i = 1)
          {
            com.tencent.mm.plugin.voip.b.e.a(i, System.currentTimeMillis(), localVoipMgr.GUM, localVoipMgr.GUM, 0, 0, VoipMgr.mHZ / localVoipMgr.GUW);
            VoipMgr.mHZ = 0;
            VoipMgr.GUR[0] = 0;
            VoipMgr.GUR[1] = 0;
            localVoipMgr.GUW = 0;
            if (localVoipMgr.qtS != null)
            {
              TelephonyManager localTelephonyManager = localVoipMgr.qtS;
              Object localObject = localVoipMgr.GUP;
              localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject);
              com.tencent.mm.hellhoundlib.a.a.a(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/voip/model/VoipMgr", "uninitVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
              localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(1)).intValue());
              com.tencent.mm.hellhoundlib.a.a.a(localTelephonyManager, "com/tencent/mm/plugin/voip/model/VoipMgr", "uninitVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            }
            if (localVoipMgr.GYh != null)
            {
              MMApplicationContext.getContext().unregisterReceiver(localVoipMgr.GYh);
              localVoipMgr.GYh = null;
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
  
  private static void fFQ()
  {
    AppMethodBeat.i(235643);
    zj localzj = new zj();
    localzj.efx.dKy = 11;
    EventCenter.instance.publish(localzj);
    AppMethodBeat.o(235643);
  }
  
  private void fFV()
  {
    AppMethodBeat.i(115048);
    synchronized (this.GUd)
    {
      fHl();
      this.GTV.unInit();
      this.GTV.fFV();
      AppMethodBeat.o(115048);
      return;
    }
  }
  
  private boolean fFW()
  {
    AppMethodBeat.i(115052);
    if (com.tencent.mm.plugin.voip.b.k.adP(this.GTW.mState))
    {
      SharedPreferences localSharedPreferences = getContext().getSharedPreferences("voip_plugin_prefs", 0);
      if (!localSharedPreferences.getBoolean("voip_shortcut_has_added", false))
      {
        boolean bool = c(localSharedPreferences);
        AppMethodBeat.o(115052);
        return bool;
      }
    }
    AppMethodBeat.o(115052);
    return false;
  }
  
  private void fFX()
  {
    AppMethodBeat.i(115056);
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
          AppMethodBeat.i(235617);
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
          AppMethodBeat.o(235617);
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
      localTextView.setText(2131767224);
    }
  }
  
  private void fGb()
  {
    AppMethodBeat.i(115062);
    if (this.GUn != null) {
      this.GUn.b(this);
    }
    if (this.GUo != null)
    {
      Log.d("MicroMsg.Voip.VoipMgr", "stop face detect timer");
      this.GUo.stopTimer();
    }
    AppMethodBeat.o(115062);
  }
  
  private void fGc()
  {
    AppMethodBeat.i(235648);
    this.GUx = true;
    if ((this.GUx) && (this.GUk == 2))
    {
      getContext();
      gWP();
    }
    AppMethodBeat.o(235648);
  }
  
  private void fHk()
  {
    AppMethodBeat.i(115043);
    if ((com.tencent.mm.compatible.util.d.oD(28)) && (this.GUg) && (this.GXZ != null) && (!this.GXZ.dEO()) && (this.GTY != null))
    {
      Log.i("MicroMsg.Voip.VoipMgr", "video call accept, not previewing, api level: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      this.GXZ.eoc();
      this.GTY.fJj();
      int k = 320;
      int m = 240;
      int j = m;
      int i = k;
      if (this.GXZ == null)
      {
        j = m;
        i = k;
        if (com.tencent.mm.plugin.voip.b.k.adQ(this.GTW.mState))
        {
          this.qsJ = new CaptureView(MMApplicationContext.getContext());
          Log.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
          i = 640;
          j = 480;
        }
      }
      this.GXZ = new com.tencent.mm.plugin.voip.video.camera.prev.a(i, j);
      this.GXZ.a(this, true);
      this.GXZ.a(this.qsJ);
      this.GXZ.fLb();
      this.GYi = 0;
    }
    AppMethodBeat.o(115043);
  }
  
  private void fHl()
  {
    AppMethodBeat.i(115049);
    Log.printDebugStack("MicroMsg.Voip.VoipMgr", "uninitCaptureRender", new Object[0]);
    if (this.GXZ != null) {
      fGb();
    }
    try
    {
      this.GXZ.eoc();
      this.GXZ = null;
      AppMethodBeat.o(115049);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.d("MicroMsg.Voip.VoipMgr", "stop capture error:" + localException.toString());
      }
    }
  }
  
  private void fHm()
  {
    AppMethodBeat.i(235649);
    Log.i("MicroMsg.Voip.VoipMgr", "uninitSurfaceTexture!");
    if (this.GTY != null) {
      this.GTY.releaseSurfaceTexture();
    }
    AppMethodBeat.o(235649);
  }
  
  private void gWP()
  {
    AppMethodBeat.i(258472);
    this.GTV.Z(new kotlin.g.a.b() {});
    AppMethodBeat.o(258472);
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(115055);
    Context localContext1 = null;
    if (this.GTY != null) {
      localContext1 = this.GTY.fJl();
    }
    Context localContext2 = localContext1;
    if (localContext1 == null) {
      localContext2 = MMApplicationContext.getContext();
    }
    AppMethodBeat.o(115055);
    return localContext2;
  }
  
  private void hb(boolean paramBoolean)
  {
    AppMethodBeat.i(115030);
    Log.i("MicroMsg.Voip.VoipMgr", "finish");
    this.GUu = false;
    this.GUw = false;
    int i;
    Object localObject1;
    if (this.GYk != null) {
      if (this.GYl != null)
      {
        i = this.GUB;
        localObject1 = this.GYl;
        if ((i & 0x1) == 0) {
          break label802;
        }
        i = 1;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.voip.b.a)localObject1).Z(false, i);
      this.GYl.fJL();
      this.GYk.fKp();
      if (this.GYm != null)
      {
        this.GYm.removeCallbacksAndMessages(null);
        this.GYm = null;
      }
      if (this.GUm != -1)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(11700, new Object[] { Integer.valueOf(this.GUm), Long.valueOf(Util.secondsToNow(this.GUl)) });
        this.GUm = -1;
      }
      try
      {
        MMApplicationContext.getContext().unregisterReceiver(this.GUV);
        label158:
        this.GTV.fJP();
        EventCenter.instance.removeListener(this.yok);
        EventCenter.instance.removeListener(this.GUX);
        fHm();
        if (this.GTY != null)
        {
          this.GTY.uninit();
          this.GTY = null;
          this.GTV.b(this.GTY);
        }
        this.qsJ = null;
        label245:
        int j;
        label264:
        label329:
        long l;
        if (com.tencent.mm.plugin.voip.c.fFg() != null)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.voip.c.fFg().fHT();
            if (!this.GUg) {
              break label820;
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
            break label835;
          }
          this.GYa = new a();
          com.tencent.f.h.RTc.aX(this.GYa);
          Object localObject2;
          if ((this.yoi != null) && (this.mtH != null))
          {
            localObject1 = this.yoi;
            localObject2 = this.mtH;
            localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/voip/model/VoipMgr", "finish", "(Z)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(1)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/voip/model/VoipMgr", "finish", "(Z)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            this.mtH = null;
          }
          this.yoi = null;
          com.tencent.mm.booter.a.akp().akq();
          r.fHo().fHq();
          r.fHo().a(null);
          ((com.tencent.mm.plugin.notification.b.a)g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
          com.tencent.mm.plugin.voip.c.fFg().fIl();
          Log.i("MicroMsg.Voip.VoipMgr", "finish, isFinishFromShutdown: %s", new Object[] { Boolean.valueOf(this.GUc) });
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
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/voip/model/VoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/voip/model/VoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          com.tencent.mm.plugin.voip.c.fFg().fIn();
          fFQ();
          if (!this.GUI)
          {
            j = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId;
            l = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH;
            if (!this.GUf) {
              break label842;
            }
          }
        }
        label802:
        label820:
        label835:
        label842:
        for (i = 0;; i = 1)
        {
          com.tencent.mm.plugin.voip.b.e.c(j, l, i, 4);
          this.GUI = true;
          this.GYd = null;
          this.GYf = 0;
          ((com.tencent.mm.plugin.notification.b.a)g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
          com.tencent.mm.media.g.c.igu.aMA();
          AppMethodBeat.o(115030);
          return;
          i = 0;
          break;
          com.tencent.mm.plugin.voip.c.fFg().GYS.fIx();
          break label245;
          com.tencent.mm.plugin.voip.c.fFg().d(false, false, this.goe);
          break label264;
          fFV();
          break label329;
        }
      }
      catch (Exception localException)
      {
        break label158;
      }
    }
  }
  
  private void xN(final int paramInt)
  {
    AppMethodBeat.i(115023);
    Log.printDebugStack("MicroMsg.Voip.VoipMgr", "swtchState, action: %s, currentState: %s", new Object[] { com.tencent.mm.plugin.voip.b.k.adM(paramInt), com.tencent.mm.plugin.voip.b.k.adM(this.GTW.mState) });
    if ((4101 == paramInt) && (com.tencent.mm.plugin.voip.b.k.adQ(this.GTW.mState)))
    {
      fHl();
      this.GUg = false;
      if (this.GYc != null) {
        this.GYc.GUg = false;
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
    }
    this.GTW.adU(paramInt);
    if (this.kAn != null) {
      this.kAn.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114991);
          if (VoipMgr.h(VoipMgr.this) != null) {
            VoipMgr.h(VoipMgr.this).jD(paramInt, VoipMgr.c(VoipMgr.this).mState);
          }
          AppMethodBeat.o(114991);
        }
      });
    }
    switch (this.GTW.mState)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(115023);
      return;
      acP(5);
      AppMethodBeat.o(115023);
      return;
      acP(6);
    }
  }
  
  private void xc(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(115015);
    if (this.GUg)
    {
      Log.i("MicroMsg.Voip.VoipMgr", "setCameraCaptureBind,  isFace: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      Log.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
      if (this.GXZ == null) {
        this.GXZ = new com.tencent.mm.plugin.voip.video.camera.prev.a(640, 480);
      }
      if (this.GXZ.a(this, paramBoolean) != 1) {
        break label159;
      }
    }
    label159:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.GYg = paramBoolean;
      if ((this.GYg) && (this.qsJ != null))
      {
        this.GXZ.a(this.qsJ);
        com.tencent.mm.plugin.voip.c.fFg().adn(this.GXZ.fLa());
        if (this.kAn != null) {
          this.kAn.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(235632);
              Log.d("MicroMsg.Voip.VoipMgr", "mCaptureRender == " + VoipMgr.e(VoipMgr.this));
              if (VoipMgr.e(VoipMgr.this) != null)
              {
                VoipMgr.e(VoipMgr.this).fLb();
                VoipMgr.q(VoipMgr.this);
              }
              AppMethodBeat.o(235632);
            }
          }, 50L);
        }
      }
      AppMethodBeat.o(115015);
      return;
    }
  }
  
  public final void a(final Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(235634);
    Log.i("MicroMsg.Voip.VoipMgr", "start VoIP, userName: %s, isOutCall: %b, isVideoCall: %b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.GTV.aL(paramBoolean2, paramBoolean1);
    this.GTV.fJN();
    this.GUu = true;
    this.goe = paramString;
    this.GUf = paramBoolean1;
    this.GUg = paramBoolean2;
    this.GUe = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(this.goe);
    this.kAn = new MMHandler(Looper.getMainLooper());
    this.GUB = 0;
    this.GUC = 0;
    this.GUD = 0;
    boolean bool1;
    int j;
    label196:
    label216:
    boolean bool2;
    Object localObject1;
    label269:
    label316:
    Object localObject2;
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
          break label601;
        }
        i = 1;
        com.tencent.mm.plugin.voip.c.fFg().adf(1);
      }
      if (!paramBoolean1) {
        break label621;
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
            break label633;
          }
          i = 0;
          ((com.tencent.mm.plugin.report.service.h)localObject1).a(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
        }
        if (!bool2)
        {
          localObject1 = com.tencent.mm.plugin.report.service.h.CyF;
          if (!this.GUg) {
            break label639;
          }
          i = 0;
          ((com.tencent.mm.plugin.report.service.h)localObject1).a(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
        }
      }
      if ((!bool2) || (!bool1))
      {
        localObject1 = null;
        localObject2 = null;
        if ((bool1) || (bool2)) {
          break label645;
        }
        localObject1 = paramContext.getString(2131767361);
        localObject2 = paramContext.getString(2131767326);
        label387:
        com.tencent.mm.ui.base.h.a(paramContext, (String)localObject1, (String)localObject2, paramContext.getString(2131767329), true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(235628);
            Log.i("MicroMsg.Voip.VoipMgr", "show Permission settings");
            com.tencent.mm.compatible.e.b.cw(paramContext);
            if (!VoipMgr.d(VoipMgr.this))
            {
              if (VoipMgr.g(VoipMgr.this))
              {
                VoipMgr.this.fFv();
                AppMethodBeat.o(235628);
                return;
              }
              VoipMgr.this.fFy();
              AppMethodBeat.o(235628);
              return;
            }
            if (VoipMgr.g(VoipMgr.this))
            {
              VoipMgr.this.fFA();
              AppMethodBeat.o(235628);
              return;
            }
            VoipMgr.this.fFB();
            AppMethodBeat.o(235628);
          }
        });
      }
      Log.i("MicroMsg.Voip.VoipMgr", "initMgr");
      com.tencent.mm.booter.a.akp().akr();
      if (!this.GUg) {
        break label697;
      }
      com.tencent.mm.plugin.voip.c.fFg().d(true, true, this.goe);
      label447:
      if (!this.GUf) {
        break label730;
      }
      com.tencent.mm.plugin.voip.c.fFg().GYS.fIt();
      if (!this.GUg) {
        break label712;
      }
      i = com.tencent.mm.plugin.voip.c.fFg().aUA(this.GUe.field_username);
      label485:
      if (i >= 0) {
        break label730;
      }
      hb(false);
      i = 0;
      if (i != 0)
      {
        this.GTV.aN(paramBoolean2, paramBoolean1);
        if (paramBoolean2)
        {
          this.GYk = new com.tencent.mm.plugin.voip.b.i();
          this.GYl = new com.tencent.mm.plugin.voip.b.a();
          i = this.GUB;
          paramContext = this.GYl;
          if ((i & 0x1) == 0) {
            break label1163;
          }
        }
      }
    }
    label645:
    label1163:
    for (int i = 1;; i = 0)
    {
      paramContext.Z(false, i);
      this.GYl.fJK();
      com.tencent.mm.plugin.voip.c.fFg().e(paramString, this.GUg, paramLong);
      AppMethodBeat.o(235634);
      return;
      bool1 = false;
      break;
      label601:
      i = j;
      if (256 != j) {
        break label196;
      }
      i = 257;
      break label196;
      label621:
      this.GTW = com.tencent.mm.plugin.voip.b.k.adN(i);
      break label216;
      label633:
      i = 1;
      break label269;
      label639:
      i = 1;
      break label316;
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
      label697:
      com.tencent.mm.plugin.voip.c.fFg().d(true, false, this.goe);
      break label447;
      label712:
      i = com.tencent.mm.plugin.voip.c.fFg().aUz(this.GUe.field_username);
      break label485;
      label730:
      com.tencent.mm.plugin.voip.c.fFg().a(MMApplicationContext.getContext(), this);
      this.yoi = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
      paramContext = this.yoi;
      localObject1 = this.mtH;
      localObject1 = com.tencent.mm.hellhoundlib.b.c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/voip/model/VoipMgr", "initMgr", "()Z", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      paramContext.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/voip/model/VoipMgr", "initMgr", "()Z", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      paramContext = "voip_recent_contact" + z.aTY();
      localObject1 = MMApplicationContext.getContext().getSharedPreferences("voip_plugin_prefs", 0);
      localObject2 = ((SharedPreferences)localObject1).getString(paramContext, null);
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
              label967:
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
        i = 1;
        break;
        if (4 != i) {
          break label967;
        }
        ((List)localObject2).remove(i - 1);
        break label967;
        localObject2 = new ArrayList();
        ((List)localObject2).add(0, this.goe);
        localObject2 = Util.listToString((List)localObject2, ";");
        ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    AppMethodBeat.i(115016);
    Log.i("MicroMsg.Voip.VoipMgr", "onVoipUIDestroy");
    if (this.GTY == paramb)
    {
      Log.d("MicroMsg.Voip.VoipMgr", "same mVoIPUi, clear it");
      this.GTY = null;
      this.GTV.b(null);
    }
    if (this.kAn != null) {
      this.kAn = null;
    }
    AppMethodBeat.o(115016);
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb, int paramInt)
  {
    AppMethodBeat.i(115011);
    Log.i("MicroMsg.Voip.VoipMgr", "onVoipUICreated, uiType: %s, captureRender: %s, mVoicePlayDevice: %s", new Object[] { Integer.valueOf(paramInt), this.GXZ, Integer.valueOf(this.GUk) });
    if ((1 == paramInt) && (this.GTY != null)) {
      this.GTY.uninit();
    }
    this.GTY = paramb;
    this.mUIType = paramInt;
    this.GTV.b(this.GTY);
    if ((this.GXZ == null) && (com.tencent.mm.plugin.voip.b.k.adQ(this.GTW.mState))) {
      this.qsJ = new CaptureView(MMApplicationContext.getContext());
    }
    this.GTY.jD(-1, this.GTW.mState);
    this.GTY.setConnectSec(this.GUl);
    Log.i("MicroMsg.Voip.VoipMgr", "steve: voipMgr decMode:%d, beautyCmd:%d", new Object[] { Integer.valueOf(this.GUB), Integer.valueOf(this.GUC) });
    if (this.GUB != -1)
    {
      this.GTY.setHWDecMode(this.GUB);
      Log.i("MicroMsg.Voip.VoipMgr", "steve: voipMgr setHWDecMode,decMode:%d", new Object[] { Integer.valueOf(this.GUB) });
    }
    this.GTY.setVoipBeauty(this.GUC);
    this.GTY.setSpatiotemporalDenosing(this.GUD);
    com.tencent.mm.plugin.voip.video.b.e.fLK().HlY = new e.a()
    {
      public final void MC()
      {
        AppMethodBeat.i(235630);
        VoipMgr localVoipMgr = VoipMgr.this;
        SurfaceTexture localSurfaceTexture = v2protocal.mSurfaceTexture;
        com.tencent.mm.media.g.d locald = v2protocal.HcD;
        if ((localVoipMgr.GTY != null) && (localSurfaceTexture != null))
        {
          localSurfaceTexture.setOnFrameAvailableListener(localVoipMgr);
          localVoipMgr.GTY.a(localSurfaceTexture, locald);
        }
        AppMethodBeat.o(235630);
      }
    };
    if ((this.GUK != 0) && (this.GUL != 0)) {
      jA(this.GUK, this.GUL);
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
    if (this.GYb)
    {
      AppMethodBeat.o(115046);
      return;
    }
    if (this.GXZ == null)
    {
      Log.e("MicroMsg.Voip.VoipMgr", "onFrameDataReady, captureRender is null!");
      AppMethodBeat.o(115046);
      return;
    }
    int m;
    int n;
    label73:
    final int i;
    label97:
    final int k;
    label110:
    final int j;
    if (this.GXZ.fLp())
    {
      m = OpenGlRender.FLAG_Mirror;
      if (!this.GXZ.fKZ()) {
        break label488;
      }
      n = OpenGlRender.FLAG_Angle270;
      if (this.GTY != null)
      {
        if ((OpenGlRender.getGLVersion() != 2) || (this.GUC == 0)) {
          break label496;
        }
        i = 1;
        if ((this.GUC & 0x8) == 0) {
          break label502;
        }
        k = 1;
        if ((OpenGlRender.getGLVersion() != 2) || ((this.GUD & 0x1) == 0)) {
          break label508;
        }
        j = 1;
        label129:
        if ((i == 0) && (j == 0)) {
          break label872;
        }
        if ((k != 0) || (this.GTY.adw(2) == null)) {
          break label514;
        }
        this.GYf = 0;
        k = i;
        i = 1;
      }
    }
    for (;;)
    {
      label169:
      final ByteBuffer localByteBuffer;
      if ((this.GXZ.fLp()) && ((k != 0) || (j != 0))) {
        if ((j != 0) && (i == 0))
        {
          localByteBuffer = this.GTY.fJk().HpD;
          if (localByteBuffer == null) {
            break label866;
          }
        }
      }
      label263:
      label439:
      label458:
      label854:
      label860:
      label866:
      for (long l = localByteBuffer.capacity();; l = paramLong)
      {
        this.GYe = localByteBuffer;
        k = paramInt2;
        j = paramInt1;
        this.GYn = true;
        int i2 = 4;
        Object localObject = null;
        i1 = k;
        k = j;
        j = i2;
        Log.d("MicroMsg.Voip.VoipMgr", "jcchen capture data: w=" + paramInt1 + "h=" + paramInt2 + ", vw=" + k + "vh=" + i1 + ", bm=" + i + ", skip:" + this.GYj);
        i = (int)l;
        if (this.GYm != null) {
          this.GYm.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(114967);
              if (localByteBuffer != null)
              {
                com.tencent.mm.plugin.voip.c.fFg().c(localByteBuffer, i, j, k, i1, 0);
                AppMethodBeat.o(114967);
                return;
              }
              if (this.GYu != null)
              {
                u localu = com.tencent.mm.plugin.voip.c.fFg();
                byte[] arrayOfByte = this.GYu;
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
        this.GTY.a(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, m, n);
        P((byte[])localObject, paramInt1, paramInt2);
        this.GYi += 1;
        boolean bool;
        if (m == OpenGlRender.FLAG_Mirror)
        {
          bool = true;
          this.GUq = bool;
          if (n != OpenGlRender.FLAG_Angle270) {
            break label841;
          }
          paramInt3 = 270;
          this.GUr = paramInt3;
          this.GUn.setPreviewSize(paramInt1, paramInt2);
          AppMethodBeat.o(115046);
          return;
          m = 0;
          break;
          label488:
          n = OpenGlRender.FLAG_Angle90;
          break label73;
          label496:
          i = 0;
          break label97;
          label502:
          k = 0;
          break label110;
          label508:
          j = 0;
          break label129;
          if ((k != 0) && (this.GTY.adw(1) != null) && (this.GTY.adw(1).iEK != null))
          {
            this.GYf = 0;
            i1 = 2;
            k = i;
            i = i1;
            break label169;
          }
          if ((j != 0) && (this.GTY.fJk() != null))
          {
            this.GYf = 0;
            i1 = 0;
            k = i;
            i = i1;
            break label169;
          }
          if ((this.GYd != null) && (this.GYf <= 10))
          {
            this.GYf += 1;
            i1 = 3;
            k = i;
            i = i1;
            break label169;
          }
          j = 0;
          k = 0;
          i = 0;
          break label169;
          if (i == 1)
          {
            localByteBuffer = this.GTY.adw(2).iEK;
            if (localByteBuffer == null) {
              break label860;
            }
          }
        }
        for (l = localByteBuffer.capacity();; l = paramLong)
        {
          this.GYe = localByteBuffer;
          k = paramInt2;
          j = paramInt1;
          break;
          if (i == 2)
          {
            localObject = this.GTY.adw(1);
            localByteBuffer = ((com.tencent.mm.plugin.voip.video.b.a)localObject).iEK;
            if (localByteBuffer == null) {
              break label854;
            }
          }
          for (l = localByteBuffer.capacity();; l = paramLong)
          {
            j = ((com.tencent.mm.plugin.voip.video.b.a)localObject).width;
            k = ((com.tencent.mm.plugin.voip.video.b.a)localObject).height;
            this.GYe = localByteBuffer;
            break;
            localByteBuffer = this.GYe;
            if (localByteBuffer != null) {}
            for (l = localByteBuffer.capacity();; l = paramLong)
            {
              this.GYe = localByteBuffer;
              k = paramInt2;
              j = paramInt1;
              break;
              j = paramInt3 + paramInt4;
              this.GYn = false;
              l = paramLong;
              i1 = paramInt2;
              k = paramInt1;
              localByteBuffer = null;
              localObject = paramArrayOfByte;
              break label263;
              bool = false;
              break label439;
              paramInt3 = 90;
              break label458;
            }
          }
        }
      }
      label514:
      label841:
      label872:
      final int i1 = 0;
      k = i;
      i = i1;
    }
  }
  
  public final void a(final int[] paramArrayOfInt, final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(115063);
    if ((!this.GYg) && (this.GUg))
    {
      xc(true);
      this.GYg = true;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(235624);
        if (VoipMgr.e(VoipMgr.this) != null) {
          VoipMgr.e(VoipMgr.this).N(paramArrayOfInt);
        }
        if (VoipMgr.h(VoipMgr.this) != null) {
          VoipMgr.h(VoipMgr.this);
        }
        AppMethodBeat.o(235624);
      }
    });
    AppMethodBeat.o(115063);
  }
  
  public final void aE(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(235640);
    if (this.GYk != null)
    {
      com.tencent.mm.plugin.voip.b.i locali = this.GYk;
      long l = Util.currentTicks();
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          locali.Hhm = l;
          AppMethodBeat.o(235640);
          return;
        }
        locali.Hhe = l;
        AppMethodBeat.o(235640);
        return;
      }
      if (paramBoolean2)
      {
        locali.Hhn = l;
        AppMethodBeat.o(235640);
        return;
      }
      locali.Hhf = l;
    }
    AppMethodBeat.o(235640);
  }
  
  public final void aUw(String paramString)
  {
    AppMethodBeat.i(235642);
    if (this.GTY != null)
    {
      this.GUy = paramString;
      this.GTY.aUB(paramString);
    }
    AppMethodBeat.o(235642);
  }
  
  final void acM(int paramInt)
  {
    AppMethodBeat.i(115013);
    if (paramInt == 5)
    {
      mHZ += GUR[0];
      this.GUW += 1;
      Log.i("MicroMsg.Voip.VoipMgr", "mSignalStrength 4G" + GUR[0] + " and index is " + this.GUW);
      AppMethodBeat.o(115013);
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
        Log.i("MicroMsg.Voip.VoipMgr", "error happened in get wifi info");
        continue;
      }
      mHZ += GUR[1];
      this.GUW += 1;
      Log.i("MicroMsg.Voip.VoipMgr", "mSignalStrength WIFI " + GUR[1] + " and index is " + this.GUW);
      AppMethodBeat.o(115013);
      return;
      paramInt = localWifiManager.getConnectionInfo().getRssi();
    }
  }
  
  public final void acQ(int paramInt)
  {
    AppMethodBeat.i(115035);
    Log.i("MicroMsg.Voip.VoipMgr", "remote voip mode changed, cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    if (((1 == paramInt) || (3 == paramInt) || (5 == paramInt) || (6 == paramInt) || (7 == paramInt)) && (this.GUg))
    {
      xN(4101);
      com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGz();
      com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.fGA();
    }
    AppMethodBeat.o(115035);
  }
  
  public final void acR(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(115040);
    Log.i("MicroMsg.Voip.VoipMgr", "onSessionBeingCalled, callType: ".concat(String.valueOf(paramInt)));
    if (!this.GTW.adT(4110))
    {
      AppMethodBeat.o(115040);
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
      AppMethodBeat.o(115040);
      return;
    }
  }
  
  public final void acS(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(115041);
    Log.i("MicroMsg.Voip.VoipMgr", "steve:[simucall]onNewSimulCallAutoAccept, callType: ".concat(String.valueOf(paramInt)));
    if (!this.GTW.adT(4100))
    {
      AppMethodBeat.o(115041);
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
      AppMethodBeat.o(115041);
      return;
    }
  }
  
  public final void ah(long paramLong, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(235641);
    Object localObject;
    label50:
    boolean bool;
    if (this.GYk != null) {
      switch (paramInt)
      {
      default: 
        localObject = this.GYk;
        if (1 == this.mUIType)
        {
          bool = this.GYn;
          switch (paramInt)
          {
          }
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(235641);
      return;
      if (1 == this.mUIType)
      {
        if (!com.tencent.mm.plugin.voip.c.fFg().GZg)
        {
          localObject = this.GYk;
          if ((260 != this.GTW.mState) && (6 != this.GTW.mState)) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.plugin.voip.b.i)localObject).aO(true, bool);
            com.tencent.mm.plugin.voip.c.fFg().GZg = true;
            break;
          }
        }
        localObject = this.GYk;
        if ((260 != this.GTW.mState) && (6 != this.GTW.mState)) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.voip.b.i)localObject).aP(true, bool);
          break;
        }
      }
      if (!com.tencent.mm.plugin.voip.c.fFg().GZf)
      {
        localObject = this.GYk;
        if ((260 != this.GTW.mState) && (6 != this.GTW.mState)) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.voip.b.i)localObject).aO(false, bool);
          com.tencent.mm.plugin.voip.c.fFg().GZf = true;
          break;
        }
      }
      localObject = this.GYk;
      if ((260 != this.GTW.mState) && (6 != this.GTW.mState)) {}
      for (bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.voip.b.i)localObject).aP(false, bool);
        break;
      }
      i = 0;
      break label50;
      ((com.tencent.mm.plugin.voip.b.i)localObject).Hhi += 1;
      if (((com.tencent.mm.plugin.voip.b.i)localObject).Hhi == 0)
      {
        if (i != 0)
        {
          if (paramLong != -1L)
          {
            localObject = com.tencent.mm.plugin.voip.b.f.HgY;
            com.tencent.mm.plugin.voip.b.f.Ls(paramLong);
            AppMethodBeat.o(235641);
          }
        }
        else
        {
          if (paramLong != -1L)
          {
            localObject = com.tencent.mm.plugin.voip.b.f.HgY;
            com.tencent.mm.plugin.voip.b.f.Lt(paramLong);
          }
          AppMethodBeat.o(235641);
        }
      }
      else if (((com.tencent.mm.plugin.voip.b.i)localObject).Hhi == 60) {
        ((com.tencent.mm.plugin.voip.b.i)localObject).Hhi = -1;
      }
      AppMethodBeat.o(235641);
      return;
      ((com.tencent.mm.plugin.voip.b.i)localObject).Hhj += 1;
      if (((com.tencent.mm.plugin.voip.b.i)localObject).Hhj == 0)
      {
        if (i != 0)
        {
          if (paramLong > 0L)
          {
            if (bool)
            {
              localObject = com.tencent.mm.plugin.voip.b.f.HgY;
              com.tencent.mm.plugin.voip.b.f.Lz(paramLong);
              AppMethodBeat.o(235641);
              return;
            }
            localObject = com.tencent.mm.plugin.voip.b.f.HgY;
            com.tencent.mm.plugin.voip.b.f.Lw(paramLong);
            AppMethodBeat.o(235641);
          }
        }
        else
        {
          if (paramLong > 0L)
          {
            if (bool)
            {
              localObject = com.tencent.mm.plugin.voip.b.f.HgY;
              com.tencent.mm.plugin.voip.b.f.Ly(paramLong);
              AppMethodBeat.o(235641);
              return;
            }
            localObject = com.tencent.mm.plugin.voip.b.f.HgY;
            com.tencent.mm.plugin.voip.b.f.Lx(paramLong);
          }
          AppMethodBeat.o(235641);
        }
      }
      else if (((com.tencent.mm.plugin.voip.b.i)localObject).Hhj == 30) {
        ((com.tencent.mm.plugin.voip.b.i)localObject).Hhj = -1;
      }
      AppMethodBeat.o(235641);
      return;
      ((com.tencent.mm.plugin.voip.b.i)localObject).Hhk += 1;
      if (((com.tencent.mm.plugin.voip.b.i)localObject).Hhk == 0)
      {
        if (i != 0)
        {
          localObject = com.tencent.mm.plugin.voip.b.f.HgY;
          com.tencent.mm.plugin.voip.b.f.Lu(paramLong);
          AppMethodBeat.o(235641);
          return;
        }
        localObject = com.tencent.mm.plugin.voip.b.f.HgY;
        com.tencent.mm.plugin.voip.b.f.Lv(paramLong);
        AppMethodBeat.o(235641);
        return;
      }
      if (((com.tencent.mm.plugin.voip.b.i)localObject).Hhk == 60) {
        ((com.tencent.mm.plugin.voip.b.i)localObject).Hhk = -1;
      }
    }
  }
  
  public final void cza()
  {
    AppMethodBeat.i(115061);
    if ((true == this.zuc) || (this.GTY == null) || (this.GTY.fJl() == null))
    {
      Log.d("MicroMsg.Voip.VoipMgr", "onCameraError, already show");
      AppMethodBeat.o(115061);
      return;
    }
    if (this.GXZ.dEO())
    {
      AppMethodBeat.o(115061);
      return;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("meizu")) && (!com.tencent.mm.compatible.e.b.apj()) && (com.tencent.mm.compatible.util.d.oE(29)))
    {
      Log.d("MicroMsg.Voip.VoipMgr", "onCameraError, meizu machine");
      AppMethodBeat.o(115061);
      return;
    }
    if ((com.tencent.mm.compatible.util.d.oD(28)) && (((KeyguardManager)MMApplicationContext.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()))
    {
      Log.i("MicroMsg.Voip.VoipMgr", "api level: %s, in keyguard, ignore", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(115061);
      return;
    }
    Log.d("MicroMsg.Voip.VoipMgr", "onCameraError, show dialog");
    Object localObject = com.tencent.mm.plugin.report.service.h.CyF;
    if (this.GUg) {}
    for (int i = 0;; i = 1)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).a(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      localObject = com.tencent.mm.ui.base.h.n(this.GTY.fJl(), 2131767335, 2131755998);
      if (localObject != null) {
        break;
      }
      Log.e("MicroMsg.Voip.VoipMgr", "new dialog failed");
      AppMethodBeat.o(115061);
      return;
    }
    ((com.tencent.mm.ui.widget.a.d)localObject).setCancelable(false);
    ((com.tencent.mm.ui.widget.a.d)localObject).setCanceledOnTouchOutside(false);
    ((com.tencent.mm.ui.widget.a.d)localObject).show();
    this.zuc = true;
    com.tencent.mm.plugin.voip.b.h.fKq();
    AppMethodBeat.o(115061);
  }
  
  public final void dZK()
  {
    AppMethodBeat.i(115027);
    Log.i("MicroMsg.Voip.VoipMgr", "on accept");
    fFK();
    xN(4100);
    AppMethodBeat.o(115027);
  }
  
  public final void dZQ()
  {
    AppMethodBeat.i(235646);
    Log.i("MicroMsg.Voip.VoipMgr", "onNetWorkChangeMobileNet");
    if (this.GTY != null) {
      this.GTY.fJn();
    }
    AppMethodBeat.o(235646);
  }
  
  public final void dZR()
  {
    AppMethodBeat.i(115051);
    Log.i("MicroMsg.Voip.VoipMgr", "onResumeGoodNetStatus");
    if (this.GTY != null) {
      this.GTY.ebH();
    }
    AppMethodBeat.o(115051);
  }
  
  public final void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115036);
    if (this.GTY != null) {
      this.GTY.f(paramInt1, paramInt2, paramArrayOfByte);
    }
    AppMethodBeat.o(115036);
  }
  
  public final void enR()
  {
    AppMethodBeat.i(184052);
    if (this.GTY != null) {
      this.GTY.enR();
    }
    AppMethodBeat.o(184052);
  }
  
  public final boolean fEZ()
  {
    return this.GUg;
  }
  
  public final boolean fFA()
  {
    AppMethodBeat.i(115009);
    if (!this.GTW.adT(4098))
    {
      AppMethodBeat.o(115009);
      return false;
    }
    Log.i("MicroMsg.Voip.VoipMgr", "onCancelVideoInvite");
    acN(4098);
    com.tencent.mm.plugin.voip.c.fFg().fIl();
    AppMethodBeat.o(115009);
    return true;
  }
  
  public final boolean fFB()
  {
    AppMethodBeat.i(115010);
    if (!this.GTW.adT(4098))
    {
      AppMethodBeat.o(115010);
      return false;
    }
    Log.i("MicroMsg.Voip.VoipMgr", "onCancelVoiceInvite");
    acN(4098);
    com.tencent.mm.plugin.voip.c.fFg().fIl();
    AppMethodBeat.o(115010);
    return true;
  }
  
  public final void fFC()
  {
    AppMethodBeat.i(115012);
    if ((this.GUg) && (this.GTY != null))
    {
      this.GTY.setCaptureView(this.qsJ);
      if ((ae.gKt.gFB == 0) || (this.GUf)) {
        if ((this.GXZ != null) && (!this.GXZ.fLp())) {
          break label145;
        }
      }
    }
    label145:
    for (boolean bool = true;; bool = false)
    {
      xc(bool);
      if ((this.GUf) && (com.tencent.mm.plugin.voip.b.k.adR(this.GTW.mState)) && (com.tencent.mm.plugin.voip.c.fFg().GYS.czl()))
      {
        this.GTV.aN(this.GUg, this.GUf);
        this.GTV.b("voip", Integer.valueOf(this.GUk));
      }
      AppMethodBeat.o(115012);
      return;
    }
  }
  
  public final void fFD()
  {
    AppMethodBeat.i(115014);
    Log.i("MicroMsg.Voip.VoipMgr", "it is init voip report");
    this.GYh = new NetChangedBroadcastReceiver();
    Object localObject1 = new IntentFilter();
    ((IntentFilter)localObject1).addAction("android.net.wifi.WIFI_STATE_CHANGED");
    ((IntentFilter)localObject1).addAction("android.net.wifi.STATE_CHANGE");
    ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
    MMApplicationContext.getContext().registerReceiver(this.GYh, (IntentFilter)localObject1);
    this.qtS = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
    this.GUM = com.tencent.mm.plugin.voip.b.e.getNetType(getContext());
    this.GUP = new VoipMgr.19(this);
    localObject1 = this.qtS;
    Object localObject2 = this.GUP;
    localObject2 = com.tencent.mm.hellhoundlib.b.c.a(256, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/voip/model/VoipMgr", "initVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/voip/model/VoipMgr", "initVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    AppMethodBeat.o(115014);
  }
  
  public final void fFF()
  {
    AppMethodBeat.i(115017);
    Log.i("MicroMsg.Voip.VoipMgr", "onSwitchCamera");
    if (this.GXZ != null) {
      this.GXZ.fLd();
    }
    com.tencent.mm.plugin.report.service.h.CyF.a(11079, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(115017);
  }
  
  public final void fFG()
  {
    AppMethodBeat.i(115018);
    if (true != this.GXZ.fLp()) {
      fFF();
    }
    AppMethodBeat.o(115018);
  }
  
  public final void fFH() {}
  
  public final void fFI() {}
  
  public final void fFJ() {}
  
  public final void fFK()
  {
    AppMethodBeat.i(235638);
    if (this.GTV != null)
    {
      Log.i("MicroMsg.Voip.VoipMgr", "use audioManager to stop voip ring");
      this.GTV.fFK();
      AppMethodBeat.o(235638);
      return;
    }
    Log.i("MicroMsg.Voip.VoipMgr", "use Subcore to stop voip ring");
    com.tencent.mm.plugin.voip.c.fFg().GYS.stopRing();
    AppMethodBeat.o(235638);
  }
  
  public final void fFL()
  {
    AppMethodBeat.i(235639);
    if (this.GTY != null) {
      this.GTY.fFL();
    }
    AppMethodBeat.o(235639);
  }
  
  public final boolean fFM()
  {
    AppMethodBeat.i(115020);
    if (com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId == 0)
    {
      this.GUj = true;
      AppMethodBeat.o(115020);
      return true;
    }
    boolean bool = fFN();
    AppMethodBeat.o(115020);
    return bool;
  }
  
  public final void fFO()
  {
    AppMethodBeat.i(115022);
    Log.i("MicroMsg.Voip.VoipMgr", "onRoomReady");
    if ((this.GUj) && (com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId != 0))
    {
      this.GUj = false;
      fFN();
    }
    if (this.GUf) {
      xN(4097);
    }
    AppMethodBeat.o(115022);
  }
  
  public final void fFR()
  {
    AppMethodBeat.i(115031);
    Log.i("MicroMsg.Voip.VoipMgr", "onNoResp");
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
      AppMethodBeat.o(115031);
      return;
      str1 = ca.OqB;
      break;
    }
  }
  
  public final void fFS()
  {
    int j = 0;
    AppMethodBeat.i(115033);
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
        break label205;
      }
    }
    label205:
    for (int i = j;; i = 1)
    {
      com.tencent.mm.plugin.voip.b.e.c(k, l1, i, 3);
      if (this.GUQ != null) {
        this.GUQ.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(114965);
            VoipMgr.a(VoipMgr.this, VoipMgr.k(VoipMgr.this));
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
  
  public final void fFT()
  {
    AppMethodBeat.i(115042);
    Log.d("MicroMsg.Voip.VoipMgr", "onPretreatmentForStartDev");
    this.GTV.aM(this.GUx, this.GUg);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      MMHandlerThread.postToMainThread(new Runnable()
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
    fHk();
    AppMethodBeat.o(115042);
  }
  
  public final long fFU()
  {
    AppMethodBeat.i(115044);
    long l = this.GTV.Hgu;
    Log.printInfoStack("MicroMsg.Voip.VoipMgr", "totalDeviceNearTime: %s", new Object[] { Long.valueOf(l) });
    l /= 1000L;
    AppMethodBeat.o(115044);
    return l;
  }
  
  public final void fFY()
  {
    AppMethodBeat.i(115058);
    if ((256 != this.GTW.mState) && (257 != this.GTW.mState))
    {
      AppMethodBeat.o(115058);
      return;
    }
    if ((g.aAh().azQ().getInt(327945, 0) == 0) && (this.GTY.fJl() != null))
    {
      g.aAh().azQ().setInt(327945, 1);
      com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.a(this.GTY.fJl(), 2131767307, 2131755998, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(235619);
          VoipMgr.this.fGa();
          AppMethodBeat.o(235619);
        }
      });
      locald.setCancelable(false);
      locald.setCanceledOnTouchOutside(false);
      locald.show();
      AppMethodBeat.o(115058);
      return;
    }
    m.hG(MMApplicationContext.getContext());
    fGa();
    AppMethodBeat.o(115058);
  }
  
  public final void fFZ()
  {
    AppMethodBeat.i(115059);
    if (!this.GUp) {}
    for (boolean bool = true;; bool = false)
    {
      this.GUp = bool;
      if (!this.GUp) {
        break;
      }
      this.GUo.stopTimer();
      AppMethodBeat.o(115059);
      return;
    }
    if (this.GUo == null) {
      this.GUo = new MTimerHandler("faceDetect", new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(235623);
          VoipMgr.L(VoipMgr.this);
          AppMethodBeat.o(235623);
          return true;
        }
      }, true);
    }
    this.GUo.startTimer(2000L);
    this.GUp = false;
    AppMethodBeat.o(115059);
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
    AppMethodBeat.i(115003);
    if (!this.GTW.adT(4103))
    {
      AppMethodBeat.o(115003);
      return false;
    }
    acN(4103);
    com.tencent.mm.plugin.voip.c.fFg().fIl();
    AppMethodBeat.o(115003);
    return true;
  }
  
  public final boolean fFu()
  {
    AppMethodBeat.i(115004);
    if (!this.GTW.adT(4101))
    {
      AppMethodBeat.o(115004);
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
      AppMethodBeat.o(115004);
      return true;
    }
  }
  
  public final boolean fFv()
  {
    int i = 0;
    AppMethodBeat.i(115005);
    if (!this.GTW.adT(4099))
    {
      AppMethodBeat.o(115005);
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
      AppMethodBeat.o(115005);
      return true;
    }
  }
  
  public final boolean fFw()
  {
    AppMethodBeat.i(115006);
    if (!this.GTW.adT(4100))
    {
      AppMethodBeat.o(115006);
      return false;
    }
    if ((ae.gKt.gFB == 1) && (this.GUg)) {
      xc(true);
    }
    if (((!this.GYg) || (ae.gKt.gFB == 1) || (ae.gKt.gFC == 1)) && (this.GUg)) {
      if ((this.GXZ != null) && (!this.GXZ.fLp())) {
        break label152;
      }
    }
    label152:
    for (boolean bool = true;; bool = false)
    {
      xc(bool);
      this.GYg = true;
      Log.i("MicroMsg.Voip.VoipMgr", "onAcceptVideoInvite");
      fFK();
      com.tencent.mm.plugin.voip.c.fFg().aH(false, this.GUg);
      xN(4100);
      AppMethodBeat.o(115006);
      return true;
    }
  }
  
  public final void fFx()
  {
    this.GYg = false;
  }
  
  public final boolean fFy()
  {
    int i = 0;
    AppMethodBeat.i(115007);
    if (!this.GTW.adT(4099))
    {
      AppMethodBeat.o(115007);
      return false;
    }
    Log.i("MicroMsg.Voip.VoipMgr", "onRejectVoiceInvite");
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
      AppMethodBeat.o(115007);
      return true;
    }
  }
  
  public final boolean fFz()
  {
    AppMethodBeat.i(115008);
    if (!this.GTW.adT(4100))
    {
      AppMethodBeat.o(115008);
      return false;
    }
    Log.i("MicroMsg.Voip.VoipMgr", "onAcceptVoiceInvite");
    fFK();
    com.tencent.mm.plugin.voip.c.fFg().aH(true, this.GUg);
    xN(4111);
    xN(4100);
    AppMethodBeat.o(115008);
    return true;
  }
  
  public final void fGa()
  {
    AppMethodBeat.i(115060);
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
            AppMethodBeat.i(235620);
            VoipMgr.K(VoipMgr.this);
            AppMethodBeat.o(235620);
          }
        }, 2000L);
      }
      AppMethodBeat.o(115060);
      return;
      str1 = ca.OqB;
      break;
    }
  }
  
  public final void fs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235647);
    Log.i("MicroMsg.Voip.VoipMgr", "camera preview size applye is $width and $height");
    AppMethodBeat.o(235647);
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
    AppMethodBeat.i(115039);
    Log.i("MicroMsg.Voip.VoipMgr", "adjustHWViewAspectRatio, HWDecsize:%dx%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.GUK = paramInt1;
    this.GUL = paramInt2;
    if (this.GTY != null) {
      this.GTY.jA(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115039);
  }
  
  public final void jz(int paramInt1, int paramInt2) {}
  
  public final void onConnected()
  {
    AppMethodBeat.i(115032);
    xN(4102);
    this.GUl = Util.nowSecond();
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
    AppMethodBeat.o(115032);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(115026);
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
    xN(4109);
    Log.i("MicroMsg.Voip.VoipMgr", "onError, errCode: %s, roomId: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId) });
    paramString = MMApplicationContext.getContext();
    Log.d("MicroMsg.Voip.VoipMgr", "getErrorMsgContent, errorCode".concat(String.valueOf(paramInt)));
    if (paramInt == 235)
    {
      paramString = paramString.getString(2131767247);
      if ((com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId == 0) || (com.tencent.mm.plugin.voip.c.fFg().GYY.get(Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId)) != null)) {
        break label431;
      }
      str2 = this.GUe.field_username;
      if (!this.GUg) {
        break label418;
      }
      str1 = ca.OqC;
      if (!this.GUf) {
        break label426;
      }
      paramInt = 1;
      if (com.tencent.mm.plugin.voip.b.k.adP(this.GTW.mState)) {
        paramString = MMApplicationContext.getContext().getString(2131767242, new Object[] { AF(Util.secondsToNow(this.GUl)) });
      }
      l = s.a(str2, str1, paramInt, 6, paramString, true);
      com.tencent.mm.plugin.voip.c.fFg().GYY.put(Integer.valueOf(com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId), Long.valueOf(l));
    }
    label418:
    label426:
    label431:
    while (com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId != 0) {
      for (;;)
      {
        long l;
        com.tencent.mm.plugin.voip.c.fFg().fIl();
        fFP();
        AppMethodBeat.o(115026);
        return;
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
      label470:
      if (!this.GUf) {
        break label543;
      }
    }
    label543:
    for (paramInt = 1;; paramInt = 0)
    {
      if (com.tencent.mm.plugin.voip.b.k.adP(this.GTW.mState)) {
        paramString = MMApplicationContext.getContext().getString(2131767242, new Object[] { AF(Util.secondsToNow(this.GUl)) });
      }
      s.a(str2, str1, paramInt, 6, paramString, true);
      break;
      str1 = ca.OqB;
      break label470;
    }
  }
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(115064);
    if (this.GTY != null) {
      this.GTY.requestRender();
    }
    AppMethodBeat.o(115064);
  }
  
  public final void onReject()
  {
    AppMethodBeat.i(115028);
    Log.i("MicroMsg.Voip.VoipMgr", "onReject");
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
      AppMethodBeat.o(115028);
      return;
      str1 = ca.OqB;
      break;
    }
  }
  
  public final void ql(boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(115050);
    Log.i("MicroMsg.Voip.VoipMgr", "onBadNetStatus");
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
      Log.i("MicroMsg.Voip.VoipMgr", i);
      localObject = com.tencent.mm.plugin.report.service.h.CyF;
      l = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH;
      i = j;
      if (paramBoolean) {
        i = 1;
      }
      ((com.tencent.mm.plugin.report.service.h)localObject).a(17151, true, true, new Object[] { Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(115050);
      return;
    }
  }
  
  public final void rv(boolean paramBoolean)
  {
    AppMethodBeat.i(115002);
    this.GTV.xp(paramBoolean);
    AppMethodBeat.o(115002);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115038);
    this.GUB = paramInt;
    if (this.GTY != null) {
      this.GTY.setHWDecMode(paramInt);
    }
    if (this.GYk != null)
    {
      Object localObject;
      if (this.GYl != null)
      {
        localObject = this.GYl;
        if ((paramInt & 0x1) == 0) {
          break label96;
        }
      }
      label96:
      for (int i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.voip.b.a)localObject).Z(false, i);
        this.GYl.fJK();
        localObject = this.GYk;
        if ((paramInt & 0x1) == 0) {
          break;
        }
        ((com.tencent.mm.plugin.voip.b.i)localObject).Hha += 1L;
        AppMethodBeat.o(115038);
        return;
      }
      ((com.tencent.mm.plugin.voip.b.i)localObject).Hhb += 1L;
    }
    AppMethodBeat.o(115038);
  }
  
  public final void setSpatiotemporalDenosing(int paramInt)
  {
    AppMethodBeat.i(235645);
    Log.i("MicroMsg.Voip.VoipMgr", "setSpatiotemporalDenosing, isON: " + paramInt + "，mVoipUI: " + this.GTY);
    if (this.GTY != null) {
      this.GTY.setSpatiotemporalDenosing(paramInt);
    }
    if ((paramInt != 0) && (this.GUD != paramInt)) {
      com.tencent.mm.plugin.report.service.h.CyF.n(914L, 20L, 1L);
    }
    this.GYj = 2;
    this.GUD = paramInt;
    AppMethodBeat.o(235645);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(235637);
    if ((this.GUk == 2) && (paramInt != 2)) {
      this.GTV.fJP();
    }
    for (;;)
    {
      this.GUk = paramInt;
      AppMethodBeat.o(235637);
      return;
      if ((paramInt == 2) && (this.GUk != 2) && (com.tencent.mm.plugin.voip.b.k.adQ(this.GTW.mState)))
      {
        getContext();
        gWP();
      }
    }
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115037);
    Log.i("MicroMsg.Voip.VoipMgr", "setVoipBeauty, isON: " + paramInt + "，mVoipUI: " + this.GTY);
    if (this.GTY != null) {
      this.GTY.setVoipBeauty(paramInt);
    }
    if ((paramInt != 0) && (this.GUC != paramInt)) {
      com.tencent.mm.plugin.report.service.h.CyF.n(914L, 20L, 1L);
    }
    this.GYj = 2;
    this.GUC = paramInt;
    AppMethodBeat.o(115037);
  }
  
  public final void wQ(boolean paramBoolean)
  {
    AppMethodBeat.i(235635);
    if ((this.GTW != null) && (this.GTW.mState >= 0) && (this.GTW.mState <= 8)) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.Voip.VoipMgr", "steve:[simucall] same state, no need to reset, return!");
      AppMethodBeat.o(235635);
      return;
    }
    int j = com.tencent.mm.plugin.voip.b.k.aQ(false, paramBoolean);
    i = j;
    if (this.GUh)
    {
      if (j != 0) {
        break label136;
      }
      i = 1;
    }
    for (;;)
    {
      this.GTW = com.tencent.mm.plugin.voip.b.k.adN(i);
      Log.i("MicroMsg.Voip.VoipMgr", "steve:[simucall] resetStateMachine, initState:%d,isOutCall:%s,isVideoCall:%s", new Object[] { Integer.valueOf(i), Boolean.FALSE, Boolean.valueOf(paramBoolean) });
      this.GUf = false;
      AppMethodBeat.o(235635);
      return;
      label136:
      i = j;
      if (256 == j) {
        i = 257;
      }
    }
  }
  
  public final void wU(boolean paramBoolean)
  {
    AppMethodBeat.i(115001);
    Log.i("MicroMsg.Voip.VoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.GTV.cV(paramBoolean);
    this.GTV.HgE = true;
    AppMethodBeat.o(115001);
  }
  
  public final void wV(boolean paramBoolean) {}
  
  public final void wW(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(235644);
    Log.i("MicroMsg.Voip.VoipMgr", "onShutDown");
    String str1;
    String str2;
    label99:
    label108:
    int k;
    label160:
    long l;
    if (com.tencent.mm.plugin.voip.b.k.adP(this.GTW.mState))
    {
      str1 = MMApplicationContext.getContext().getString(2131767241, new Object[] { AF(Util.secondsToNow(this.GUl)) });
      if ((this.GUf) || (com.tencent.mm.plugin.voip.b.k.adP(this.GTW.mState)))
      {
        String str3 = this.GUe.field_username;
        if (!this.GUg) {
          break label251;
        }
        str2 = ca.OqC;
        if (!this.GUf) {
          break label259;
        }
        i = 1;
        s.c(str3, str2, i, 6, str1);
      }
      this.GTV.xq(this.GUg);
      this.GUc = com.tencent.mm.plugin.voip.b.k.adP(this.GTW.mState);
      if (!fFW()) {
        break label264;
      }
      this.GUi = 4106;
      com.tencent.mm.plugin.voip.c.fFg().fIl();
      if (!this.GUI)
      {
        k = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.roomId;
        l = com.tencent.mm.plugin.voip.c.fFg().GYS.GSZ.GVV.ypH;
        if (!this.GUf) {
          break label278;
        }
      }
    }
    label259:
    label264:
    label278:
    for (int i = j;; i = 1)
    {
      com.tencent.mm.plugin.voip.b.e.c(k, l, i, 4);
      this.GUI = true;
      AppMethodBeat.o(235644);
      return;
      str1 = MMApplicationContext.getContext().getString(2131767237);
      break;
      label251:
      str2 = ca.OqB;
      break label99;
      i = 0;
      break label108;
      xN(4106);
      fFP();
      break label160;
    }
  }
  
  public final boolean wX(final boolean paramBoolean)
  {
    AppMethodBeat.i(115057);
    if (com.tencent.mm.plugin.voip.c.fFg().GZh)
    {
      Log.i("MicroMsg.Voip.VoipMgr", "current state is mini, cannot mini!");
      AppMethodBeat.o(115057);
      return false;
    }
    if ((this.GUw) && (!paramBoolean))
    {
      Log.i("MicroMsg.Voip.VoipMgr", "has phone call  cannot mini!");
      AppMethodBeat.o(115057);
      return false;
    }
    Log.printDebugStack("MicroMsg.Voip.VoipMgr", "miniOnlyHidenVoip: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Log.i("MicroMsg.Voip.VoipMgr", "onMinimizeVoip, async to minimize");
    if (this.GTY != null)
    {
      this.GTY.uninit();
      this.GTY = null;
      this.GTV.b(this.GTY);
    }
    if (this.GYc != null) {
      this.GYc.uninit();
    }
    if (this.kAn != null) {
      this.kAn.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(235618);
          VoipMgr.e(VoipMgr.this, paramBoolean);
          AppMethodBeat.o(235618);
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
                AppMethodBeat.o(114993);
                return;
              } while (VoipMgr.k(VoipMgr.this) == 5);
              j = VoipMgr.biH()[1];
              if (VoipMgr.l(VoipMgr.this) == 0) {
                VoipMgr.a(VoipMgr.this, 4);
              }
            } while (VoipMgr.l(VoipMgr.this) == 0);
            k = VoipMgr.cfm() / VoipMgr.l(VoipMgr.this);
            VoipMgr.a(VoipMgr.this, 5);
            m = VoipMgr.biH()[0];
            Log.i("MicroMsg.Voip.VoipMgr", "befor change to 4G and cost " + VoipMgr.m(VoipMgr.this));
            if (VoipMgr.d(VoipMgr.this)) {}
            for (;;)
            {
              com.tencent.mm.plugin.voip.b.e.a(i, System.currentTimeMillis(), VoipMgr.k(VoipMgr.this), 5, j, m, k);
              VoipMgr.n(VoipMgr.this);
              VoipMgr.b(VoipMgr.this, 5);
              VoipMgr.fHn();
              VoipMgr.o(VoipMgr.this);
              AppMethodBeat.o(114993);
              return;
              i = 1;
            }
          } while (VoipMgr.k(VoipMgr.this) == 4);
          k = VoipMgr.biH()[0];
          if (VoipMgr.l(VoipMgr.this) == 0) {
            VoipMgr.a(VoipMgr.this, 5);
          }
        } while (VoipMgr.l(VoipMgr.this) == 0);
        int m = VoipMgr.cfm() / VoipMgr.l(VoipMgr.this);
        VoipMgr.a(VoipMgr.this, 4);
        int n = VoipMgr.biH()[1];
        Log.i("MicroMsg.Voip.VoipMgr", "befor change to wifi and cost " + VoipMgr.m(VoipMgr.this));
        if (VoipMgr.d(VoipMgr.this)) {}
        for (i = j;; i = 1)
        {
          com.tencent.mm.plugin.voip.b.e.a(i, System.currentTimeMillis(), VoipMgr.k(VoipMgr.this), 4, k, n, m);
          VoipMgr.n(VoipMgr.this);
          VoipMgr.b(VoipMgr.this, 4);
          VoipMgr.fHn();
          VoipMgr.o(VoipMgr.this);
          break;
        }
      }
      if ((paramIntent.getAction().equals("android.net.wifi.STATE_CHANGE")) && (VoipMgr.p(VoipMgr.this) == 0L))
      {
        VoipMgr.a(VoipMgr.this, System.currentTimeMillis());
        AppMethodBeat.o(114993);
        return;
      }
      if ((paramIntent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) && (VoipMgr.p(VoipMgr.this) != 0L))
      {
        VoipMgr.b(VoipMgr.this, System.currentTimeMillis() - VoipMgr.p(VoipMgr.this));
        VoipMgr.a(VoipMgr.this, 0L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr
 * JD-Core Version:    0.7.0.1
 */