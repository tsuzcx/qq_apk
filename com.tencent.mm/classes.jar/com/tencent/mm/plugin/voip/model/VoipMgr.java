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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xg;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.a.yj;
import com.tencent.mm.g.a.yj.a;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.aq;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.voip.b.j;
import com.tencent.mm.plugin.voip.ui.VoipScoreDialog;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class VoipMgr
  extends com.tencent.mm.plugin.voip.a
{
  static int[] AAB = new int[2];
  static int kZl = 0;
  ao AAA;
  private long AAD;
  private boolean AAE;
  private int AAF;
  private int AAG;
  private BroadcastReceiver AAI;
  int AAK;
  private com.tencent.mm.sdk.b.c AAL;
  private boolean AAb;
  private boolean AAd;
  private boolean AAe;
  private String AAf;
  public int AAi;
  public int AAj;
  private long AAk;
  private boolean AAl;
  private long AAm;
  private long AAn;
  private long AAo;
  private long AAp;
  private int AAq;
  boolean AAr;
  boolean AAs;
  private int AAt;
  public int AAu;
  public int AAv;
  int AAw;
  boolean AAx;
  PhoneStateListener AAz;
  private com.tencent.mm.plugin.voip.video.a ADP;
  private a ADQ;
  private com.tencent.mm.plugin.voip.widget.d ADR;
  private byte[] ADS;
  private ByteBuffer ADT;
  private int ADU;
  private boolean ADV;
  NetChangedBroadcastReceiver ADW;
  private com.tencent.mm.plugin.voip.b.h ADX;
  private com.tencent.mm.plugin.voip.b.a ADY;
  ao ADZ;
  boolean AEa;
  volatile com.tencent.mm.plugin.voip.ui.b AzA;
  private boolean AzC;
  private boolean AzD;
  private boolean AzE;
  private Object AzF;
  private com.tencent.mm.storage.ai AzG;
  boolean AzH;
  private boolean AzI;
  private boolean AzJ;
  private int AzK;
  private boolean AzL;
  private int AzM;
  private long AzN;
  private boolean AzR;
  private int AzS;
  private com.tencent.mm.plugin.voip.video.k AzU;
  private au AzV;
  private boolean AzW;
  private boolean AzX;
  private int AzY;
  private boolean AzZ;
  private com.tencent.mm.plugin.voip.b.c Azx;
  private com.tencent.mm.plugin.voip.b.k Azy;
  private String foE;
  private ao jdu;
  PhoneStateListener kMN;
  private long lastShakeTime;
  private int mUIType;
  private boolean oUJ;
  private com.tencent.mm.sdk.platformtools.bj oUK;
  private SensorController oUL;
  private CaptureView otK;
  TelephonyManager ouQ;
  private long soH;
  private TelephonyManager tHh;
  private com.tencent.mm.sdk.b.c tHj;
  private long tJt;
  private boolean uKQ;
  
  public VoipMgr()
  {
    AppMethodBeat.i(114994);
    this.ADQ = null;
    this.AzC = true;
    this.lastShakeTime = -1L;
    this.oUJ = false;
    this.AzD = false;
    this.AzE = false;
    this.AzF = new Object();
    this.AzJ = false;
    this.AzK = 4096;
    this.AzL = false;
    this.AzM = -1;
    this.AzN = -1L;
    this.uKQ = false;
    this.AzR = false;
    this.AzS = 0;
    this.AzU = new com.tencent.mm.plugin.voip.video.k();
    this.AzV = null;
    this.AzW = false;
    this.AzX = false;
    this.AzY = 0;
    this.AzZ = false;
    this.AAb = false;
    this.AAd = false;
    this.AAe = false;
    this.AAf = null;
    this.AAi = -1;
    this.AAj = 0;
    this.AAk = -1L;
    this.AAl = false;
    this.AAm = 0L;
    this.AAn = -1L;
    this.AAo = 0L;
    this.AAp = 0L;
    this.AAq = 0;
    this.AAr = false;
    this.AAs = false;
    this.AAt = 0;
    this.ADS = null;
    this.ADT = null;
    this.ADU = 0;
    this.ADV = true;
    this.AAu = 0;
    this.AAv = 0;
    this.AAw = 0;
    this.AAx = false;
    this.AAA = new ao("getSignalStrength");
    this.ouQ = null;
    this.soH = 0L;
    this.AAD = 0L;
    this.AAE = false;
    this.AAF = 0;
    this.AAG = 0;
    this.ADZ = new ao("encodeVoipHandler");
    this.AAI = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(114963);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        paramAnonymousIntent = (PowerManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("power");
        if (("android.intent.action.USER_PRESENT".equals(paramAnonymousContext)) && (paramAnonymousIntent.isScreenOn()))
        {
          VoipMgr.a(VoipMgr.this, false);
          AppMethodBeat.o(114963);
          return;
        }
        if ("android.intent.action.SCREEN_ON".equals(paramAnonymousContext))
        {
          VoipMgr.a(VoipMgr.this, false);
          VoipMgr.this.kc(true);
          AppMethodBeat.o(114963);
          return;
        }
        if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousContext))
        {
          VoipMgr.a(VoipMgr.this, true);
          if (!VoipMgr.a(VoipMgr.this)) {
            VoipMgr.this.kc(true);
          }
          if ((!j.SU(VoipMgr.b(VoipMgr.this).mState)) && (!VoipMgr.c(VoipMgr.this))) {
            VoipMgr.d(VoipMgr.this).ehD();
          }
        }
        AppMethodBeat.o(114963);
      }
    };
    this.tHj = new com.tencent.mm.sdk.b.c() {};
    this.AAK = 0;
    this.AEa = false;
    this.tJt = 0L;
    this.kMN = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        int i = 1;
        AppMethodBeat.i(208337);
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        ac.i("MicroMsg.Voip.VoipMgr", "onCallStateChanged :%d, isStartVoip: %b,oldState:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(VoipMgr.w(VoipMgr.this)), Integer.valueOf(VoipMgr.x(VoipMgr.this)) });
        if (!VoipMgr.w(VoipMgr.this))
        {
          AppMethodBeat.o(208337);
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
          com.tencent.mm.plugin.voip.c.ehb().So(1);
          VoipMgr.c(VoipMgr.this, true);
        }
        label327:
        label361:
        do
        {
          VoipMgr.d(VoipMgr.this).AAE = VoipMgr.F(VoipMgr.this);
          AppMethodBeat.o(208337);
          return;
          if (paramAnonymousInt == 2)
          {
            VoipMgr.b(VoipMgr.this, false);
            if (VoipMgr.x(VoipMgr.this) == 1) {
              VoipMgr.e(VoipMgr.this, System.currentTimeMillis());
            }
            VoipMgr.c(VoipMgr.this, 2);
            ac.i("MicroMsg.Voip.VoipMgr", "phone call coming now!");
            if ((VoipMgr.c(VoipMgr.this)) && (!j.SU(VoipMgr.b(VoipMgr.this).mState))) {
              com.tencent.mm.plugin.voip.c.ehb().AEF.eki();
            }
            String str2;
            String str1;
            if (j.SU(VoipMgr.b(VoipMgr.this).mState))
            {
              paramAnonymousString = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764803, new Object[] { VoipMgr.yP(bs.pN(VoipMgr.z(VoipMgr.this))) });
              com.tencent.mm.plugin.voip.c.ehb().ejJ();
              str2 = VoipMgr.A(VoipMgr.this).field_username;
              if (!VoipMgr.g(VoipMgr.this)) {
                break label596;
              }
              str1 = bo.GYP;
              if (!VoipMgr.c(VoipMgr.this)) {
                break label604;
              }
            }
            for (paramAnonymousInt = i;; paramAnonymousInt = 0)
            {
              s.c(str2, str1, paramAnonymousInt, 6, paramAnonymousString);
              VoipMgr.d(VoipMgr.this, 4107);
              VoipMgr.B(VoipMgr.this);
              paramAnonymousString = new bo();
              paramAnonymousString.setType(10000);
              paramAnonymousString.oA(System.currentTimeMillis());
              paramAnonymousString.setStatus(6);
              paramAnonymousString.setContent(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764801) + ", <a href=\"weixin://voip/callagain/?username=" + VoipMgr.f(VoipMgr.this) + "&isvideocall=" + VoipMgr.g(VoipMgr.this) + "\">" + com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764796) + "</a>");
              if ((VoipMgr.f(VoipMgr.this) != null) && (!VoipMgr.f(VoipMgr.this).equals("")))
              {
                paramAnonymousString.re(VoipMgr.f(VoipMgr.this));
                ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().ap(paramAnonymousString);
              }
              com.tencent.mm.plugin.voip.c.ehb().So(2);
              VoipMgr.c(VoipMgr.this, false);
              break;
              paramAnonymousString = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764799);
              break label327;
              str1 = bo.GYO;
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
        com.tencent.mm.plugin.voip.c.ehb().So(2);
        if ((1 == VoipMgr.C(VoipMgr.this)) && (j.SU(VoipMgr.b(VoipMgr.this).mState)) && (VoipMgr.D(VoipMgr.this))) {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(208333);
              VoipMgr.d(VoipMgr.this).cm(true);
              AppMethodBeat.o(208333);
            }
          });
        }
        if ((4 == VoipMgr.C(VoipMgr.this)) && (VoipMgr.D(VoipMgr.this))) {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(208334);
              VoipMgr.d(VoipMgr.this).au(VoipMgr.E(VoipMgr.this), VoipMgr.g(VoipMgr.this));
              AppMethodBeat.o(208334);
            }
          });
        }
        VoipMgr.b(VoipMgr.this, false);
        if ((com.tencent.mm.compatible.b.g.Xi() != null) && (com.tencent.mm.plugin.audio.c.a.bCx().isBluetoothScoOn()))
        {
          ac.i("MicroMsg.Voip.VoipMgr", "is bluetooth can use and start bluetooth");
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(208335);
              VoipMgr.d(VoipMgr.this).au(VoipMgr.E(VoipMgr.this), VoipMgr.g(VoipMgr.this));
              AppMethodBeat.o(208335);
            }
          });
        }
        for (;;)
        {
          VoipMgr.c(VoipMgr.this, false);
          break;
          if (com.tencent.mm.plugin.audio.c.a.bCx().bCs()) {
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(208336);
                VoipMgr.d(VoipMgr.this).au(VoipMgr.E(VoipMgr.this), VoipMgr.g(VoipMgr.this));
                AppMethodBeat.o(208336);
              }
            });
          }
        }
      }
    };
    this.AAL = new com.tencent.mm.sdk.b.c() {};
    this.Azx = new com.tencent.mm.plugin.voip.b.c();
    AppMethodBeat.o(114994);
  }
  
  private void D(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115047);
    if (this.AAF % 100 == 0) {
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
          ac.i("MicroMsg.Voip.VoipMgr", "onFrameDataReady, sample sendData:[%s, %s, %s, %s, %s], captureFrameCount:%s", new Object[] { Byte.valueOf(arrayOfByte[0]), Byte.valueOf(arrayOfByte[1]), Byte.valueOf(arrayOfByte[2]), Byte.valueOf(arrayOfByte[3]), Byte.valueOf(arrayOfByte[4]), Integer.valueOf(this.AAF) });
          paramInt2 = 0;
          paramInt1 = 0;
          break label288;
          if (paramInt1 >= 5)
          {
            paramArrayOfByte = t.AEB;
            t.ejF();
          }
          AppMethodBeat.o(115047);
          return;
        }
        ac.i("MicroMsg.Voip.VoipMgr", "sample check sendData error! %s", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
        AppMethodBeat.o(115047);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        ac.printErrStackTrace("MicroMsg.Voip.VoipMgr", paramArrayOfByte, "sampleCheckSendData error", new Object[0]);
      }
      AppMethodBeat.o(115047);
      return;
      label272:
      ac.i("MicroMsg.Voip.VoipMgr", "sample check sendData error is null or empty");
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
  
  private void RV(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(115019);
    ac.i("MicroMsg.Voip.VoipMgr", "hangupTalkingOrCancelInvite");
    if (true == ehP()) {
      this.AzK = paramInt;
    }
    Object localObject = com.tencent.mm.sdk.platformtools.ai.getContext();
    String str2;
    if (j.SU(this.Azy.mState))
    {
      localObject = ((Context)localObject).getString(2131764803, new Object[] { qn(bs.pN(this.AzN)) });
      str2 = this.AzG.field_username;
      if (!this.AzI) {
        break label251;
      }
    }
    label251:
    for (String str1 = bo.GYP;; str1 = bo.GYO)
    {
      if (this.AzH) {
        i = 1;
      }
      s.c(str2, str1, i, 6, (String)localObject);
      if ((!this.AzH) || (j.SU(this.Azy.mState))) {
        break label259;
      }
      ehD();
      if ((this.AzH) && (!j.SU(this.Azy.mState)))
      {
        ac.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call cancelCall");
        com.tencent.mm.plugin.voip.c.ehb().AEF.ekh();
      }
      ac.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call hangUp");
      com.tencent.mm.plugin.voip.c.ehb().AEF.ekk();
      if (4096 != this.AzK) {
        break label315;
      }
      tg(paramInt);
      ehH();
      AppMethodBeat.o(115019);
      return;
      if (this.AzH)
      {
        localObject = ((Context)localObject).getString(2131764798);
        break;
      }
      localObject = ((Context)localObject).getString(2131764797);
      break;
    }
    label259:
    com.tencent.e.h.JZN.aS(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "VoipMgr_play_end_sound";
      }
      
      public final void run()
      {
        AppMethodBeat.i(208354);
        VoipMgr.d(VoipMgr.this);
        com.tencent.mm.plugin.voip.b.c.sQ(VoipMgr.g(VoipMgr.this));
        AppMethodBeat.o(208354);
      }
    });
    this.AzD = true;
    this.AzE = true;
    com.tencent.mm.plugin.voip.c.ehb().AEF.ekk();
    if (4096 == this.AzK)
    {
      tg(paramInt);
      ehH();
    }
    label315:
    AppMethodBeat.o(115019);
  }
  
  private boolean RW(int paramInt)
  {
    AppMethodBeat.i(115024);
    if (4111 == paramInt)
    {
      AppMethodBeat.o(115024);
      return true;
    }
    if ((4101 == paramInt) && ((j.SU(this.Azy.mState)) || (this.AzH)))
    {
      AppMethodBeat.o(115024);
      return true;
    }
    AppMethodBeat.o(115024);
    return false;
  }
  
  private static void RX(int paramInt)
  {
    AppMethodBeat.i(115025);
    yj localyj = new yj();
    localyj.dBX.cZu = paramInt;
    com.tencent.mm.sdk.b.a.GpY.l(localyj);
    AppMethodBeat.o(115025);
  }
  
  private boolean d(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(115053);
    String str = com.tencent.mm.m.g.ZY().getValue("VOIPShortcutAutoadd");
    ac.i("MicroMsg.Voip.VoipMgr", "voip shortcut autoAdd is %s", new Object[] { str });
    if ((str != null) && (str.equals("0")) && (bs.pN(this.AzN) > 30L))
    {
      int i = paramSharedPreferences.getInt("voip_shortcut_prompt_times", 0);
      boolean bool = paramSharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
      if ((i < 3) && (!bool))
      {
        ehQ();
        paramSharedPreferences.edit().putInt("voip_shortcut_prompt_times", i + 1).commit();
        AppMethodBeat.o(115053);
        return true;
      }
    }
    else if ((str != null) && (str.equals("1")) && (bs.pN(this.AzN) > 15L))
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
    if (1 == bs.getInt(com.tencent.mm.m.g.ZY().getValue("VOIPCallType"), 0))
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
  
  private boolean ehF()
  {
    int j = 0;
    AppMethodBeat.i(115021);
    if (!this.Azy.SY(4101))
    {
      AppMethodBeat.o(115021);
      return false;
    }
    this.AzI = false;
    if (this.ADR != null) {
      this.ADR.AzI = false;
    }
    tg(4101);
    Object localObject1;
    int k;
    int i;
    Object localObject3;
    Object localObject2;
    if ((261 == this.Azy.mState) || (7 == this.Azy.mState))
    {
      com.tencent.mm.plugin.voip.c.ehb().Sm(1);
      localObject1 = com.tencent.mm.plugin.report.service.h.wUl;
      long l = com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.tIG;
      k = com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId;
      if (this.AzH)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject1).f(11046, new Object[] { Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(k), Integer.valueOf(0), Integer.valueOf(i) });
        localObject3 = com.tencent.mm.plugin.report.service.h.wUl;
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
      ((com.tencent.mm.plugin.report.service.h)localObject3).f(k, (Object[])localObject2);
      do
      {
        com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.eit();
        com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.eiu();
        AppMethodBeat.o(115021);
        return true;
        i = 0;
        break;
      } while ((1 != this.Azy.mState) && (3 != this.Azy.mState));
      com.tencent.mm.plugin.voip.c.ehb().Sm(1);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
      k = 11046;
      localObject1 = new Object[5];
      localObject1[0] = Integer.valueOf(1);
      localObject1[1] = Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.tIG);
      localObject1[2] = Integer.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId);
      localObject1[3] = Integer.valueOf(0);
      i = 4;
      if (this.AzH)
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
  
  private void ehH()
  {
    AppMethodBeat.i(115029);
    ac.d("MicroMsg.Voip.VoipMgr", "delayFinish");
    this.AAf = null;
    if (this.jdu != null) {
      this.jdu.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114964);
          VoipMgr localVoipMgr = VoipMgr.this;
          ac.i("MicroMsg.Voip.VoipMgr", "it is uninit voip report");
          if (localVoipMgr.AAA != null)
          {
            localVoipMgr.AAA.quit();
            localVoipMgr.AAA = null;
          }
          if (!localVoipMgr.AAx)
          {
            if (localVoipMgr.AAK == 0) {
              localVoipMgr.RU(localVoipMgr.AAw);
            }
            if (localVoipMgr.AAK != 0)
            {
              localVoipMgr.AAx = true;
              if (!localVoipMgr.AzH) {
                break label180;
              }
            }
          }
          label180:
          for (int i = 0;; i = 1)
          {
            com.tencent.mm.plugin.voip.b.d.a(i, System.currentTimeMillis(), localVoipMgr.AAw, localVoipMgr.AAw, 0, 0, VoipMgr.kZl / localVoipMgr.AAK);
            VoipMgr.kZl = 0;
            VoipMgr.AAB[0] = 0;
            VoipMgr.AAB[1] = 0;
            localVoipMgr.AAK = 0;
            if (localVoipMgr.ouQ != null) {
              localVoipMgr.ouQ.listen(localVoipMgr.AAz, 0);
            }
            if (localVoipMgr.ADW != null)
            {
              com.tencent.mm.sdk.platformtools.ai.getContext().unregisterReceiver(localVoipMgr.ADW);
              localVoipMgr.ADW = null;
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
  
  private static void ehI()
  {
    AppMethodBeat.i(208361);
    xh localxh = new xh();
    localxh.dAb.dgL = 11;
    com.tencent.mm.sdk.b.a.GpY.l(localxh);
    AppMethodBeat.o(208361);
  }
  
  private void ehO()
  {
    AppMethodBeat.i(115048);
    synchronized (this.AzF)
    {
      ejd();
      com.tencent.mm.plugin.voip.b.c.unInit();
      this.Azx.ehO();
      AppMethodBeat.o(115048);
      return;
    }
  }
  
  private boolean ehP()
  {
    AppMethodBeat.i(115052);
    if (j.SU(this.Azy.mState))
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
  
  private void ehQ()
  {
    AppMethodBeat.i(115056);
    Context localContext = getContext();
    View localView = View.inflate(localContext, 2131494763, null);
    final CheckBox localCheckBox = (CheckBox)localView.findViewById(2131302304);
    localCheckBox.setChecked(false);
    TextView localTextView = (TextView)localView.findViewById(2131302306);
    if (1 == bs.getInt(com.tencent.mm.m.g.ZY().getValue("VOIPCallType"), 0)) {
      localTextView.setText(2131764786);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(localContext, false, localContext.getString(2131755906), localView, localContext.getString(2131755939), localContext.getString(2131755831), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(208338);
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
          AppMethodBeat.o(208338);
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
  
  private void ehU()
  {
    AppMethodBeat.i(115062);
    if (this.AzU != null) {
      this.AzU.b(this);
    }
    if (this.AzV != null)
    {
      ac.d("MicroMsg.Voip.VoipMgr", "stop face detect timer");
      this.AzV.stopTimer();
    }
    AppMethodBeat.o(115062);
  }
  
  private void ejc()
  {
    AppMethodBeat.i(115043);
    if ((com.tencent.mm.compatible.util.d.kZ(28)) && (this.AzI) && (this.ADP != null) && (!this.ADP.cDz()) && (this.AzA != null))
    {
      ac.i("MicroMsg.Voip.VoipMgr", "video call accept, not previewing, api level: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      this.ADP.emp();
      this.AzA.ekW();
      int k = 320;
      int m = 240;
      int j = m;
      int i = k;
      if (this.ADP == null)
      {
        j = m;
        i = k;
        if (j.SV(this.Azy.mState))
        {
          this.otK = new CaptureView(com.tencent.mm.sdk.platformtools.ai.getContext());
          ac.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
          i = 640;
          j = 480;
        }
      }
      this.ADP = new com.tencent.mm.plugin.voip.video.a(i, j);
      this.ADP.a(this, true);
      this.ADP.a(this.otK);
      this.ADP.emo();
      this.AAF = 0;
    }
    AppMethodBeat.o(115043);
  }
  
  private void ejd()
  {
    AppMethodBeat.i(115049);
    ac.l("MicroMsg.Voip.VoipMgr", "uninitCaptureRender", new Object[0]);
    if (this.ADP != null) {
      ehU();
    }
    try
    {
      this.ADP.emp();
      this.ADP = null;
      AppMethodBeat.o(115049);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.d("MicroMsg.Voip.VoipMgr", "stop capture error:" + localException.toString());
      }
    }
  }
  
  private void eje()
  {
    AppMethodBeat.i(208363);
    ac.i("MicroMsg.Voip.VoipMgr", "uninitSurfaceTexture!");
    if (this.AzA != null) {
      this.AzA.releaseSurfaceTexture();
    }
    AppMethodBeat.o(208363);
  }
  
  private void gb(boolean paramBoolean)
  {
    AppMethodBeat.i(115030);
    ac.i("MicroMsg.Voip.VoipMgr", "finish");
    this.AAb = false;
    this.AAd = false;
    this.lastShakeTime = -1L;
    int i;
    Object localObject1;
    if (this.ADX != null) {
      if (this.ADY != null)
      {
        i = this.AAi;
        localObject1 = this.ADY;
        if ((i & 0x1) == 0) {
          break label773;
        }
        i = 1;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.voip.b.a)localObject1).S(false, i);
      this.ADY.elC();
      this.ADX.elS();
      if (this.ADZ != null)
      {
        this.ADZ.removeCallbacksAndMessages(null);
        this.ADZ = null;
      }
      if (this.AzS != -1)
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(11700, new Object[] { Integer.valueOf(this.AzS), Long.valueOf(bs.pN(this.AzN)) });
        this.AzS = -1;
      }
      try
      {
        com.tencent.mm.sdk.platformtools.ai.getContext().unregisterReceiver(this.AAI);
        label165:
        com.tencent.mm.sdk.b.a.GpY.d(this.tHj);
        com.tencent.mm.sdk.b.a.GpY.d(this.AAL);
        eje();
        if (this.AzA != null)
        {
          this.AzA.uninit();
          this.AzA = null;
          this.Azx.b(this.AzA);
        }
        this.otK = null;
        label245:
        int j;
        label264:
        label329:
        long l;
        if (com.tencent.mm.plugin.voip.c.ehb() != null)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.voip.c.ehb().ejK();
            if (!this.AzI) {
              break label791;
            }
            com.tencent.mm.plugin.voip.c.ehb().b(false, true, this.foE);
            com.tencent.mm.plugin.voip.c.ehb().b(com.tencent.mm.sdk.platformtools.ai.getContext(), this);
          }
        }
        else
        {
          this.Azx.dfk();
          com.tencent.mm.plugin.voip.c.ehb().ejV();
          com.tencent.mm.plugin.voip.c.ehb().Sw(this.AAj);
          if (!this.AzD) {
            break label806;
          }
          this.ADQ = new a();
          com.tencent.e.h.JZN.aS(this.ADQ);
          if ((this.tHh != null) && (this.kMN != null))
          {
            this.tHh.listen(this.kMN, 0);
            this.kMN = null;
          }
          this.tHh = null;
          com.tencent.mm.booter.a.Uc().Ud();
          r.ejf().ejh();
          r.ejf().a(null);
          ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
          if (this.oUL != null)
          {
            ac.d("MicroMsg.Voip.VoipMgr", "removeSensorCallBack");
            this.oUL.eVS();
            this.oUL = null;
            this.AAl = false;
            this.AAm = 0L;
            this.AAk = -1L;
          }
          if (this.oUK != null) {
            this.oUK.eVT();
          }
          this.AAn = -1L;
          com.tencent.mm.plugin.voip.c.ehb().ejY();
          ac.i("MicroMsg.Voip.VoipMgr", "finish, isFinishFromShutdown: %s", new Object[] { Boolean.valueOf(this.AzE) });
          if ((this.AzE) && (com.tencent.mm.plugin.voip.c.ehb().ejZ()))
          {
            com.tencent.mm.plugin.voip.c.ehb();
            VoipScoreState.ejH();
            Object localObject2 = new Intent(getContext(), VoipScoreDialog.class);
            ((Intent)localObject2).putExtra("key_score_state", com.tencent.mm.plugin.voip.c.ehb().ekb());
            if (!(getContext() instanceof Activity)) {
              ((Intent)localObject2).addFlags(268435456);
            }
            localObject1 = getContext();
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().ba(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aeD(), "com/tencent/mm/plugin/voip/model/VoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/voip/model/VoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          com.tencent.mm.plugin.voip.c.ehb().eka();
          ehI();
          if (!this.AAs)
          {
            j = com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId;
            l = com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.tIG;
            if (!this.AzH) {
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
          com.tencent.mm.plugin.voip.b.d.c(j, l, i, 4);
          this.AAs = true;
          this.ADS = null;
          this.ADU = 0;
          ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
          com.tencent.mm.media.f.c.gRV.aqV();
          AppMethodBeat.o(115030);
          return;
          i = 0;
          break;
          com.tencent.mm.plugin.voip.c.ehb().AEF.ekk();
          break label245;
          com.tencent.mm.plugin.voip.c.ehb().b(false, false, this.foE);
          break label264;
          ehO();
          break label329;
        }
      }
      catch (Exception localException)
      {
        break label165;
      }
    }
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(115055);
    Context localContext1 = null;
    if (this.AzA != null) {
      localContext1 = this.AzA.ekX();
    }
    Context localContext2 = localContext1;
    if (localContext1 == null) {
      localContext2 = com.tencent.mm.sdk.platformtools.ai.getContext();
    }
    AppMethodBeat.o(115055);
    return localContext2;
  }
  
  private static String qn(long paramLong)
  {
    AppMethodBeat.i(115045);
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
    AppMethodBeat.o(115045);
    return str;
  }
  
  private void sC(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(115015);
    if (this.AzI)
    {
      ac.i("MicroMsg.Voip.VoipMgr", "setCameraCaptureBind,  isFace: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      ac.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
      if (this.ADP == null) {
        this.ADP = new com.tencent.mm.plugin.voip.video.a(640, 480);
      }
      if (this.ADP.a(this, paramBoolean) != 1) {
        break label159;
      }
    }
    label159:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.ADV = paramBoolean;
      if ((this.ADV) && (this.otK != null))
      {
        this.ADP.a(this.otK);
        com.tencent.mm.plugin.voip.c.ehb().Su(this.ADP.ems());
        if (this.jdu != null) {
          this.jdu.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(208353);
              ac.d("MicroMsg.Voip.VoipMgr", "mCaptureRender == " + VoipMgr.e(VoipMgr.this));
              if (VoipMgr.e(VoipMgr.this) != null)
              {
                VoipMgr.e(VoipMgr.this).emo();
                VoipMgr.p(VoipMgr.this);
              }
              AppMethodBeat.o(208353);
            }
          }, 50L);
        }
      }
      AppMethodBeat.o(115015);
      return;
    }
  }
  
  private void tg(final int paramInt)
  {
    AppMethodBeat.i(115023);
    ac.l("MicroMsg.Voip.VoipMgr", "swtchState, action: %s, currentState: %s", new Object[] { j.SR(paramInt), j.SR(this.Azy.mState) });
    if ((4101 == paramInt) && (j.SV(this.Azy.mState)))
    {
      ejd();
      this.AzI = false;
      if (this.ADR != null) {
        this.ADR.AzI = false;
      }
    }
    if (RW(paramInt)) {
      this.Azx.AzP = false;
    }
    if ((RW(paramInt)) && (1 == this.mUIType) && (1 == this.AzM))
    {
      this.Azx.cm(false);
      this.AAe = true;
    }
    this.Azy.SZ(paramInt);
    if (this.jdu != null) {
      this.jdu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114991);
          if (VoipMgr.q(VoipMgr.this) != null) {
            VoipMgr.q(VoipMgr.this).ih(paramInt, VoipMgr.b(VoipMgr.this).mState);
          }
          AppMethodBeat.o(114991);
        }
      });
    }
    switch (this.Azy.mState)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(115023);
      return;
      RX(5);
      AppMethodBeat.o(115023);
      return;
      RX(6);
    }
  }
  
  final void RU(int paramInt)
  {
    AppMethodBeat.i(115013);
    if (paramInt == 5)
    {
      kZl += AAB[0];
      this.AAK += 1;
      ac.i("MicroMsg.Voip.VoipMgr", "mSignalStrength 4G" + AAB[0] + " and index is " + this.AAK);
      AppMethodBeat.o(115013);
      return;
    }
    WifiManager localWifiManager;
    if (paramInt == 4)
    {
      localWifiManager = (WifiManager)com.tencent.mm.sdk.platformtools.ai.getContext().getApplicationContext().getSystemService("wifi");
      if ((localWifiManager == null) || (localWifiManager.getConnectionInfo() == null)) {}
    }
    for (;;)
    {
      try
      {
        int[] arrayOfInt = AAB;
        if (localWifiManager.getConnectionInfo() != null) {
          continue;
        }
        paramInt = 0;
        arrayOfInt[1] = paramInt;
      }
      catch (Exception localException)
      {
        AAB[1] = 0;
        ac.i("MicroMsg.Voip.VoipMgr", "error happened in get wifi info");
        continue;
      }
      kZl += AAB[1];
      this.AAK += 1;
      ac.i("MicroMsg.Voip.VoipMgr", "mSignalStrength WIFI " + AAB[1] + " and index is " + this.AAK);
      AppMethodBeat.o(115013);
      return;
      paramInt = localWifiManager.getConnectionInfo().getRssi();
    }
  }
  
  public final void RY(int paramInt)
  {
    AppMethodBeat.i(115035);
    ac.i("MicroMsg.Voip.VoipMgr", "remote voip mode changed, cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    if (((1 == paramInt) || (3 == paramInt) || (5 == paramInt) || (6 == paramInt) || (7 == paramInt)) && (this.AzI))
    {
      tg(4101);
      com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.eit();
      com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.eiu();
    }
    AppMethodBeat.o(115035);
  }
  
  public final void RZ(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(115040);
    ac.i("MicroMsg.Voip.VoipMgr", "onSessionBeingCalled, callType: ".concat(String.valueOf(paramInt)));
    if (!this.Azy.SY(4110))
    {
      AppMethodBeat.o(115040);
      return;
    }
    u localu = com.tencent.mm.plugin.voip.c.ehb();
    if (paramInt == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramInt == 1) {
        bool2 = true;
      }
      localu.ar(bool1, bool2);
      ehD();
      if ((paramInt == 1) && (j.SV(this.Azy.mState))) {
        tg(4101);
      }
      tg(4110);
      AppMethodBeat.o(115040);
      return;
    }
  }
  
  public final void Sa(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(115041);
    ac.i("MicroMsg.Voip.VoipMgr", "steve:[simucall]onNewSimulCallAutoAccept, callType: ".concat(String.valueOf(paramInt)));
    if (!this.Azy.SY(4100))
    {
      AppMethodBeat.o(115041);
      return;
    }
    u localu = com.tencent.mm.plugin.voip.c.ehb();
    if (paramInt == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramInt == 1) {
        bool2 = true;
      }
      localu.ar(bool1, bool2);
      com.tencent.mm.plugin.voip.c.ehb().AEF.stopRing();
      if ((paramInt == 1) && (j.SV(this.Azy.mState))) {
        tg(4101);
      }
      tg(4100);
      AppMethodBeat.o(115041);
      return;
    }
  }
  
  public final void Z(long paramLong, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(208359);
    Object localObject;
    label50:
    boolean bool;
    if (this.ADX != null) {
      switch (paramInt)
      {
      default: 
        localObject = this.ADX;
        if (1 == this.mUIType)
        {
          bool = this.AEa;
          switch (paramInt)
          {
          }
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(208359);
      return;
      if (1 == this.mUIType)
      {
        if (!com.tencent.mm.plugin.voip.c.ehb().AET)
        {
          localObject = this.ADX;
          if ((260 != this.Azy.mState) && (6 != this.Azy.mState)) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.plugin.voip.b.h)localObject).aw(true, bool);
            com.tencent.mm.plugin.voip.c.ehb().AET = true;
            break;
          }
        }
        localObject = this.ADX;
        if ((260 != this.Azy.mState) && (6 != this.Azy.mState)) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.voip.b.h)localObject).ax(true, bool);
          break;
        }
      }
      if (!com.tencent.mm.plugin.voip.c.ehb().AES)
      {
        localObject = this.ADX;
        if ((260 != this.Azy.mState) && (6 != this.Azy.mState)) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.voip.b.h)localObject).aw(false, bool);
          com.tencent.mm.plugin.voip.c.ehb().AES = true;
          break;
        }
      }
      localObject = this.ADX;
      if ((260 != this.Azy.mState) && (6 != this.Azy.mState)) {}
      for (bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.voip.b.h)localObject).ax(false, bool);
        break;
      }
      i = 0;
      break label50;
      ((com.tencent.mm.plugin.voip.b.h)localObject).AMn += 1;
      if (((com.tencent.mm.plugin.voip.b.h)localObject).AMn == 0)
      {
        if (i != 0)
        {
          if (paramLong != -1L)
          {
            localObject = com.tencent.mm.plugin.voip.b.e.AMd;
            com.tencent.mm.plugin.voip.b.e.za(paramLong);
            AppMethodBeat.o(208359);
          }
        }
        else
        {
          if (paramLong != -1L)
          {
            localObject = com.tencent.mm.plugin.voip.b.e.AMd;
            com.tencent.mm.plugin.voip.b.e.zb(paramLong);
          }
          AppMethodBeat.o(208359);
        }
      }
      else if (((com.tencent.mm.plugin.voip.b.h)localObject).AMn == 60) {
        ((com.tencent.mm.plugin.voip.b.h)localObject).AMn = -1;
      }
      AppMethodBeat.o(208359);
      return;
      ((com.tencent.mm.plugin.voip.b.h)localObject).AMo += 1;
      if (((com.tencent.mm.plugin.voip.b.h)localObject).AMo == 0)
      {
        if (i != 0)
        {
          if (paramLong > 0L)
          {
            if (bool)
            {
              localObject = com.tencent.mm.plugin.voip.b.e.AMd;
              com.tencent.mm.plugin.voip.b.e.zh(paramLong);
              AppMethodBeat.o(208359);
              return;
            }
            localObject = com.tencent.mm.plugin.voip.b.e.AMd;
            com.tencent.mm.plugin.voip.b.e.ze(paramLong);
            AppMethodBeat.o(208359);
          }
        }
        else
        {
          if (paramLong > 0L)
          {
            if (bool)
            {
              localObject = com.tencent.mm.plugin.voip.b.e.AMd;
              com.tencent.mm.plugin.voip.b.e.zg(paramLong);
              AppMethodBeat.o(208359);
              return;
            }
            localObject = com.tencent.mm.plugin.voip.b.e.AMd;
            com.tencent.mm.plugin.voip.b.e.zf(paramLong);
          }
          AppMethodBeat.o(208359);
        }
      }
      else if (((com.tencent.mm.plugin.voip.b.h)localObject).AMo == 30) {
        ((com.tencent.mm.plugin.voip.b.h)localObject).AMo = -1;
      }
      AppMethodBeat.o(208359);
      return;
      ((com.tencent.mm.plugin.voip.b.h)localObject).AMp += 1;
      if (((com.tencent.mm.plugin.voip.b.h)localObject).AMp == 0)
      {
        if (i != 0)
        {
          localObject = com.tencent.mm.plugin.voip.b.e.AMd;
          com.tencent.mm.plugin.voip.b.e.zc(paramLong);
          AppMethodBeat.o(208359);
          return;
        }
        localObject = com.tencent.mm.plugin.voip.b.e.AMd;
        com.tencent.mm.plugin.voip.b.e.zd(paramLong);
        AppMethodBeat.o(208359);
        return;
      }
      if (((com.tencent.mm.plugin.voip.b.h)localObject).AMp == 60) {
        ((com.tencent.mm.plugin.voip.b.h)localObject).AMp = -1;
      }
    }
  }
  
  public final void a(final Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 1;
    AppMethodBeat.i(208355);
    ac.i("MicroMsg.Voip.VoipMgr", "start VoIP, userName: %s, isOutCall: %b, isVideoCall: %b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.Azx.aZ(paramBoolean2, paramBoolean1);
    this.Azx.elJ();
    this.AAb = true;
    this.foE = paramString;
    this.AzH = paramBoolean1;
    this.AzI = paramBoolean2;
    this.AzG = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.foE);
    this.jdu = new ao(Looper.getMainLooper());
    this.AAi = 0;
    this.AAj = 0;
    boolean bool1;
    int j;
    int i;
    label194:
    label214:
    boolean bool2;
    Object localObject1;
    label267:
    label314:
    Object localObject2;
    if (bs.getInt(com.tencent.mm.m.g.ZY().getValue("VOIPCameraSwitch"), 1) == 0)
    {
      bool1 = true;
      this.AzJ = bool1;
      if (!this.AzI) {
        this.AzJ = false;
      }
      j = j.ay(paramBoolean1, paramBoolean2);
      i = j;
      if (this.AzJ)
      {
        if (j != 0) {
          break label593;
        }
        i = 1;
        com.tencent.mm.plugin.voip.c.ehb().Sm(1);
      }
      if (!paramBoolean1) {
        break label613;
      }
      this.Azy = j.ST(i);
      this.Azx.Azy = this.Azy;
      bool1 = com.tencent.mm.compatible.d.b.Yy();
      bool2 = com.tencent.mm.compatible.d.b.Yz();
      if (Build.MANUFACTURER.equalsIgnoreCase("meizu"))
      {
        if (!bool1)
        {
          localObject1 = com.tencent.mm.plugin.report.service.h.wUl;
          if (!this.AzI) {
            break label625;
          }
          i = 0;
          ((com.tencent.mm.plugin.report.service.h)localObject1).f(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
        }
        if (!bool2)
        {
          localObject1 = com.tencent.mm.plugin.report.service.h.wUl;
          if (!this.AzI) {
            break label631;
          }
          i = 0;
          ((com.tencent.mm.plugin.report.service.h)localObject1).f(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
        }
      }
      if ((!bool2) || (!bool1))
      {
        if ((bool1) || (bool2)) {
          break label637;
        }
        localObject1 = paramContext.getString(2131764920);
        localObject2 = paramContext.getString(2131764887);
      }
    }
    for (;;)
    {
      label379:
      com.tencent.mm.ui.base.h.a(paramContext, (String)localObject1, (String)localObject2, paramContext.getString(2131764890), true, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(208349);
          ac.i("MicroMsg.Voip.VoipMgr", "show Permission settings");
          com.tencent.mm.compatible.d.b.cb(paramContext);
          if (!VoipMgr.c(VoipMgr.this))
          {
            if (VoipMgr.g(VoipMgr.this))
            {
              VoipMgr.this.eho();
              AppMethodBeat.o(208349);
              return;
            }
            VoipMgr.this.ehr();
            AppMethodBeat.o(208349);
            return;
          }
          if (VoipMgr.g(VoipMgr.this))
          {
            VoipMgr.this.eht();
            AppMethodBeat.o(208349);
            return;
          }
          VoipMgr.this.ehu();
          AppMethodBeat.o(208349);
        }
      });
      ac.i("MicroMsg.Voip.VoipMgr", "initMgr");
      com.tencent.mm.booter.a.Uc().Ue();
      if (this.AzI)
      {
        com.tencent.mm.plugin.voip.c.ehb().b(true, true, this.foE);
        label439:
        if (!this.AzH) {
          break label722;
        }
        com.tencent.mm.plugin.voip.c.ehb().AEF.ekg();
        if (!this.AzI) {
          break label704;
        }
        i = com.tencent.mm.plugin.voip.c.ehb().ayy(this.AzG.field_username);
        label477:
        if (i >= 0) {
          break label722;
        }
        gb(false);
        i = 0;
        if (i != 0)
        {
          this.Azx.av(paramBoolean2, paramBoolean1);
          if (paramBoolean2)
          {
            this.ADX = new com.tencent.mm.plugin.voip.b.h();
            this.ADY = new com.tencent.mm.plugin.voip.b.a();
            i = this.AAi;
            paramContext = this.ADY;
            if ((i & 0x1) == 0) {
              break label1153;
            }
          }
        }
      }
      label1153:
      for (i = k;; i = 0)
      {
        paramContext.S(false, i);
        this.ADY.elB();
        com.tencent.mm.plugin.voip.c.ehb().i(paramString, this.AzI, false);
        AppMethodBeat.o(208355);
        return;
        bool1 = false;
        break;
        label593:
        i = j;
        if (256 != j) {
          break label194;
        }
        i = 257;
        break label194;
        label613:
        this.Azy = j.SS(i);
        break label214;
        label625:
        i = 1;
        break label267;
        label631:
        i = 1;
        break label314;
        label637:
        if (!bool1)
        {
          localObject1 = paramContext.getString(2131764922);
          localObject2 = paramContext.getString(2131764888);
          break label379;
        }
        if (bool2) {
          break label1159;
        }
        localObject1 = paramContext.getString(2131764921);
        localObject2 = paramContext.getString(2131764889);
        break label379;
        com.tencent.mm.plugin.voip.c.ehb().b(true, false, this.foE);
        break label439;
        label704:
        i = com.tencent.mm.plugin.voip.c.ehb().ayx(this.AzG.field_username);
        break label477;
        label722:
        com.tencent.mm.plugin.voip.c.ehb().a(com.tencent.mm.sdk.platformtools.ai.getContext(), this);
        this.tHh = ((TelephonyManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("phone"));
        this.tHh.listen(this.kMN, 32);
        paramContext = "voip_recent_contact" + com.tencent.mm.model.u.axw();
        localObject1 = com.tencent.mm.sdk.platformtools.ai.getContext().getSharedPreferences("voip_plugin_prefs", 0);
        localObject2 = ((SharedPreferences)localObject1).getString(paramContext, null);
        if (localObject2 != null)
        {
          localObject2 = bs.S(((String)localObject2).split(";"));
          if (localObject2 != null)
          {
            i = ((List)localObject2).size();
            if (((List)localObject2).contains(this.foE))
            {
              if (i > 1)
              {
                ((List)localObject2).remove(this.foE);
                label868:
                ((List)localObject2).add(0, this.foE);
              }
              localObject2 = bs.n((List)localObject2, ";");
              ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
              label911:
              com.tencent.mm.sdk.b.a.GpY.c(this.AAL);
              com.tencent.mm.sdk.b.a.GpY.c(this.tHj);
              this.AzU.a(this);
              paramContext = new IntentFilter();
              paramContext.addAction("android.intent.action.SCREEN_ON");
              paramContext.addAction("android.intent.action.SCREEN_OFF");
              paramContext.addAction("android.intent.action.USER_PRESENT");
              com.tencent.mm.sdk.platformtools.ai.getContext().registerReceiver(this.AAI, paramContext);
              this.oUL = new SensorController(getContext());
              ac.i("MicroMsg.Voip.VoipMgr", "initMgr setSensorCallBack");
              this.oUL.a(this);
              if (this.oUK == null)
              {
                this.oUK = new com.tencent.mm.sdk.platformtools.bj(getContext());
                paramContext = new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(208350);
                    VoipMgr.a(VoipMgr.this, bs.Gn());
                    ac.i("MicroMsg.Voip.VoipMgr", "device happened shake in time,%s", new Object[] { Long.valueOf(VoipMgr.h(VoipMgr.this)) });
                    AppMethodBeat.o(208350);
                  }
                };
                if (!this.oUK.aE(paramContext)) {
                  break label1143;
                }
              }
            }
          }
        }
        label1143:
        for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
        {
          i = 1;
          break;
          if (4 != i) {
            break label868;
          }
          ((List)localObject2).remove(i - 1);
          break label868;
          localObject2 = new ArrayList();
          ((List)localObject2).add(0, this.foE);
          localObject2 = bs.n((List)localObject2, ";");
          ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
          break label911;
        }
      }
      label1159:
      localObject2 = null;
      localObject1 = null;
    }
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    AppMethodBeat.i(115016);
    ac.i("MicroMsg.Voip.VoipMgr", "onVoipUIDestroy");
    if (this.AzA == paramb)
    {
      ac.d("MicroMsg.Voip.VoipMgr", "same mVoIPUi, clear it");
      this.AzA = null;
      this.Azx.b(null);
    }
    if (this.jdu != null) {
      this.jdu = null;
    }
    AppMethodBeat.o(115016);
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb, int paramInt)
  {
    AppMethodBeat.i(115011);
    ac.i("MicroMsg.Voip.VoipMgr", "onVoipUICreated, uiType: %s, captureRender: %s, mVoicePlayDevice: %s", new Object[] { Integer.valueOf(paramInt), this.ADP, Integer.valueOf(this.AzM) });
    if ((1 == paramInt) && (this.AzA != null)) {
      this.AzA.uninit();
    }
    this.AzA = paramb;
    this.mUIType = paramInt;
    this.Azx.b(this.AzA);
    if ((this.ADP == null) && (j.SV(this.Azy.mState))) {
      this.otK = new CaptureView(com.tencent.mm.sdk.platformtools.ai.getContext());
    }
    this.AzA.ih(-1, this.Azy.mState);
    this.AzA.setConnectSec(this.AzN);
    ac.i("MicroMsg.Voip.VoipMgr", "steve: voipMgr decMode:%d, beautyCmd:%d", new Object[] { Integer.valueOf(this.AAi), Integer.valueOf(this.AAj) });
    if (this.AAi != -1)
    {
      this.AzA.setHWDecMode(this.AAi);
      ac.i("MicroMsg.Voip.VoipMgr", "steve: voipMgr setHWDecMode,decMode:%d", new Object[] { Integer.valueOf(this.AAi) });
    }
    this.AzA.setVoipBeauty(this.AAj);
    com.tencent.mm.plugin.voip.video.b.e.emX().AQT = new VoipMgr.18(this);
    if ((this.AAu != 0) && (this.AAv != 0)) {
      ie(this.AAu, this.AAv);
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
    if (this.AzR)
    {
      AppMethodBeat.o(115046);
      return;
    }
    if (this.ADP == null)
    {
      ac.e("MicroMsg.Voip.VoipMgr", "onFrameDataReady, captureRender is null!");
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
    if (this.ADP.emq())
    {
      m = OpenGlRender.FLAG_Mirror;
      if (!this.ADP.emr()) {
        break label470;
      }
      n = OpenGlRender.FLAG_Angle270;
      if (this.AzA != null)
      {
        localByteBuffer = null;
        i2 = 0;
        if ((OpenGlRender.getGLVersion() != 2) || (this.AAj == 0)) {
          break label478;
        }
        j = 1;
        if ((this.AAj & 0x8) == 0) {
          break label484;
        }
        i1 = 1;
        k = j;
        i = i2;
        if (j != 0)
        {
          if ((i1 != 0) || (this.AzA.SD(2) == null)) {
            break label490;
          }
          i = 1;
          this.ADU = 0;
          k = j;
        }
        label159:
        if ((!this.ADP.emq()) || (k == 0)) {
          break label682;
        }
        if (i != 1) {
          break label585;
        }
        localByteBuffer = this.AzA.SD(2).hoQ;
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
      this.ADT = localByteBuffer;
      k = paramInt2;
      j = paramInt1;
      this.AEa = true;
      i2 = 4;
      Object localObject = null;
      i1 = k;
      k = j;
      j = i2;
      label245:
      ac.d("MicroMsg.Voip.VoipMgr", "jcchen capture data: w=" + paramInt1 + "h=" + paramInt2 + ", vw=" + k + "vh=" + i1 + ", bm=" + i + ", skip:" + this.AAG);
      i = (int)l;
      if (this.ADZ != null) {
        this.ADZ.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(114967);
            u localu;
            Object localObject;
            int i;
            int j;
            int k;
            int m;
            if (localByteBuffer != null)
            {
              localu = com.tencent.mm.plugin.voip.c.ehb();
              localObject = localByteBuffer;
              i = i;
              j = j;
              k = k;
              m = i1;
              new Point(0, 0);
              localu.b((ByteBuffer)localObject, i, j, k, m);
              AppMethodBeat.o(114967);
              return;
            }
            if (this.AEh != null)
            {
              localu = com.tencent.mm.plugin.voip.c.ehb();
              localObject = this.AEh;
              i = i;
              j = j;
              k = k;
              m = i1;
              new Point(0, 0);
              localu.c((byte[])localObject, i, j, k, m);
            }
            AppMethodBeat.o(114967);
          }
        });
      }
      this.AzA.a(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, m, n);
      D((byte[])localObject, paramInt1, paramInt2);
      this.AAF += 1;
      boolean bool;
      if (m == OpenGlRender.FLAG_Mirror)
      {
        bool = true;
        this.AzX = bool;
        if (n != OpenGlRender.FLAG_Angle270) {
          break label717;
        }
        paramInt3 = 270;
        this.AzY = paramInt3;
        this.AzU.setPreviewSize(paramInt1, paramInt2);
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
        if ((i1 != 0) && (this.AzA.SD(1) != null) && (this.AzA.SD(1).hoQ != null))
        {
          i = 2;
          this.ADU = 0;
          k = j;
          break label159;
        }
        if ((this.ADS != null) && (this.ADU <= 10))
        {
          i = 3;
          this.ADU += 1;
          k = j;
          break label159;
        }
        k = 0;
        i = i2;
        break label159;
        if (i == 2)
        {
          localObject = this.AzA.SD(1);
          localByteBuffer = ((com.tencent.mm.plugin.voip.video.b.a)localObject).hoQ;
          if (localByteBuffer == null) {
            break label730;
          }
        }
      }
      for (l = localByteBuffer.capacity();; l = paramLong)
      {
        j = ((com.tencent.mm.plugin.voip.video.b.a)localObject).width;
        k = ((com.tencent.mm.plugin.voip.video.b.a)localObject).height;
        this.ADT = localByteBuffer;
        break;
        localByteBuffer = this.ADT;
        if (localByteBuffer != null) {}
        for (l = localByteBuffer.capacity();; l = paramLong)
        {
          this.ADT = localByteBuffer;
          k = paramInt2;
          j = paramInt1;
          break;
          j = paramInt3 + paramInt4;
          this.AEa = false;
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
    if ((!this.ADV) && (this.AzI))
    {
      sC(true);
      this.ADV = true;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208345);
        if (VoipMgr.e(VoipMgr.this) != null) {
          VoipMgr.e(VoipMgr.this).E(paramArrayOfInt);
        }
        if (VoipMgr.q(VoipMgr.this) != null) {
          VoipMgr.q(VoipMgr.this);
        }
        AppMethodBeat.o(208345);
      }
    });
    AppMethodBeat.o(115063);
  }
  
  public final void ap(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(208358);
    if (this.ADX != null)
    {
      com.tencent.mm.plugin.voip.b.h localh = this.ADX;
      long l = bs.Gn();
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          localh.AMr = l;
          AppMethodBeat.o(208358);
          return;
        }
        localh.AMj = l;
        AppMethodBeat.o(208358);
        return;
      }
      if (paramBoolean2)
      {
        localh.AMs = l;
        AppMethodBeat.o(208358);
        return;
      }
      localh.AMk = l;
    }
    AppMethodBeat.o(208358);
  }
  
  public final void ayu(String paramString)
  {
    AppMethodBeat.i(208360);
    if (this.AzA != null)
    {
      this.AAf = paramString;
      this.AzA.ayA(paramString);
    }
    AppMethodBeat.o(208360);
  }
  
  public final void bVs()
  {
    AppMethodBeat.i(115061);
    if ((true == this.uKQ) || (this.AzA == null) || (this.AzA.ekX() == null))
    {
      ac.d("MicroMsg.Voip.VoipMgr", "onCameraError, already show");
      AppMethodBeat.o(115061);
      return;
    }
    if (this.ADP.cDz())
    {
      AppMethodBeat.o(115061);
      return;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("meizu")) && (!com.tencent.mm.compatible.d.b.Yz()))
    {
      ac.d("MicroMsg.Voip.VoipMgr", "onCameraError, meizu machine");
      AppMethodBeat.o(115061);
      return;
    }
    if ((com.tencent.mm.compatible.util.d.kZ(28)) && (((KeyguardManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()))
    {
      ac.i("MicroMsg.Voip.VoipMgr", "api level: %s, in keyguard, ignore", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(115061);
      return;
    }
    ac.d("MicroMsg.Voip.VoipMgr", "onCameraError, show dialog");
    Object localObject = com.tencent.mm.plugin.report.service.h.wUl;
    if (this.AzI) {}
    for (int i = 0;; i = 1)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).f(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      localObject = com.tencent.mm.ui.base.h.l(this.AzA.ekX(), 2131764896, 2131755906);
      if (localObject != null) {
        break;
      }
      ac.e("MicroMsg.Voip.VoipMgr", "new dialog failed");
      AppMethodBeat.o(115061);
      return;
    }
    ((com.tencent.mm.ui.widget.a.d)localObject).setCancelable(false);
    ((com.tencent.mm.ui.widget.a.d)localObject).setCanceledOnTouchOutside(false);
    ((com.tencent.mm.ui.widget.a.d)localObject).show();
    this.uKQ = true;
    com.tencent.mm.plugin.voip.b.g.elT();
    AppMethodBeat.o(115061);
  }
  
  public final void cTN()
  {
    AppMethodBeat.i(115027);
    ac.i("MicroMsg.Voip.VoipMgr", "on accept");
    ehD();
    tg(4100);
    AppMethodBeat.o(115027);
  }
  
  public final void cTT()
  {
    AppMethodBeat.i(208362);
    ac.i("MicroMsg.Voip.VoipMgr", "onNetWorkChangeMobileNet");
    if (this.AzA != null) {
      this.AzA.ela();
    }
    AppMethodBeat.o(208362);
  }
  
  public final void cTU()
  {
    AppMethodBeat.i(115051);
    ac.i("MicroMsg.Voip.VoipMgr", "onResumeGoodNetStatus");
    if (this.AzA != null) {
      this.AzA.cVN();
    }
    AppMethodBeat.o(115051);
  }
  
  public final void d(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115036);
    if (this.AzA != null) {
      this.AzA.e(paramInt1, paramInt2, paramArrayOfByte);
    }
    AppMethodBeat.o(115036);
  }
  
  public final void dgi()
  {
    AppMethodBeat.i(184052);
    if (this.AzA != null) {
      this.AzA.dgi();
    }
    AppMethodBeat.o(184052);
  }
  
  public final boolean egU()
  {
    return this.AzI;
  }
  
  public final boolean egV()
  {
    return this.AzH;
  }
  
  public final String egW()
  {
    return this.AAf;
  }
  
  public final long egX()
  {
    return this.AAo;
  }
  
  public final long egY()
  {
    return this.AAp;
  }
  
  public final int egZ()
  {
    return this.AAq;
  }
  
  public final void ehA() {}
  
  public final void ehB() {}
  
  public final void ehC() {}
  
  public final void ehD()
  {
    AppMethodBeat.i(208357);
    if (this.Azx != null)
    {
      ac.i("MicroMsg.Voip.VoipMgr", "use audioManager to stop voip ring");
      this.Azx.ehD();
      AppMethodBeat.o(208357);
      return;
    }
    ac.i("MicroMsg.Voip.VoipMgr", "use Subcore to stop voip ring");
    com.tencent.mm.plugin.voip.c.ehb().AEF.stopRing();
    AppMethodBeat.o(208357);
  }
  
  public final boolean ehE()
  {
    AppMethodBeat.i(115020);
    if (com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId == 0)
    {
      this.AzL = true;
      AppMethodBeat.o(115020);
      return true;
    }
    boolean bool = ehF();
    AppMethodBeat.o(115020);
    return bool;
  }
  
  public final void ehG()
  {
    AppMethodBeat.i(115022);
    ac.i("MicroMsg.Voip.VoipMgr", "onRoomReady");
    if ((this.AzL) && (com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId != 0))
    {
      this.AzL = false;
      ehF();
    }
    if (this.AzH) {
      tg(4097);
    }
    AppMethodBeat.o(115022);
  }
  
  public final void ehJ()
  {
    AppMethodBeat.i(115031);
    ac.i("MicroMsg.Voip.VoipMgr", "onNoResp");
    tg(4105);
    String str2 = this.AzG.field_username;
    String str1;
    if (this.AzI)
    {
      str1 = bo.GYP;
      if (!this.AzH) {
        break label181;
      }
    }
    label181:
    for (int i = 1;; i = 0)
    {
      s.c(str2, str1, i, 4, com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764810));
      com.tencent.mm.plugin.report.service.h.wUl.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.tIG), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.eim()), Integer.valueOf(6), Integer.valueOf(ax.getNetWorkType(getContext())) });
      ehH();
      AppMethodBeat.o(115031);
      return;
      str1 = bo.GYO;
      break;
    }
  }
  
  public final void ehK()
  {
    int j = 0;
    AppMethodBeat.i(115033);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
    int k = com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId;
    long l1 = com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.tIG;
    long l2 = com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.eim();
    if (this.AzH)
    {
      i = 0;
      localh.a(11522, true, true, new Object[] { Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(1) });
      k = com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId;
      l1 = com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.tIG;
      if (!this.AzH) {
        break label205;
      }
    }
    label205:
    for (int i = j;; i = 1)
    {
      com.tencent.mm.plugin.voip.b.d.c(k, l1, i, 3);
      if (this.AAA != null) {
        this.AAA.post(new Runnable()
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
  
  public final void ehL()
  {
    int j = 0;
    AppMethodBeat.i(115034);
    ac.i("MicroMsg.Voip.VoipMgr", "onShutDown");
    String str1;
    String str2;
    label99:
    label108:
    int k;
    label156:
    long l;
    if (j.SU(this.Azy.mState))
    {
      str1 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764803, new Object[] { qn(bs.pN(this.AzN)) });
      if ((this.AzH) || (j.SU(this.Azy.mState)))
      {
        String str3 = this.AzG.field_username;
        if (!this.AzI) {
          break label245;
        }
        str2 = bo.GYP;
        if (!this.AzH) {
          break label253;
        }
        i = 1;
        s.c(str3, str2, i, 6, str1);
      }
      com.tencent.mm.plugin.voip.b.c.sQ(this.AzI);
      this.AzE = j.SU(this.Azy.mState);
      if (!ehP()) {
        break label258;
      }
      this.AzK = 4106;
      com.tencent.mm.plugin.voip.c.ehb().ejY();
      if (!this.AAs)
      {
        k = com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId;
        l = com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.tIG;
        if (!this.AzH) {
          break label272;
        }
      }
    }
    label258:
    label272:
    for (int i = j;; i = 1)
    {
      com.tencent.mm.plugin.voip.b.d.c(k, l, i, 4);
      this.AAs = true;
      AppMethodBeat.o(115034);
      return;
      str1 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764799);
      break;
      label245:
      str2 = bo.GYO;
      break label99;
      label253:
      i = 0;
      break label108;
      tg(4106);
      ehH();
      break label156;
    }
  }
  
  public final void ehM()
  {
    AppMethodBeat.i(115042);
    ac.d("MicroMsg.Voip.VoipMgr", "onPretreatmentForStartDev");
    this.Azx.au(this.AAe, this.AzI);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ap.f(new Runnable()
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
    ejc();
    AppMethodBeat.o(115042);
  }
  
  public final long ehN()
  {
    AppMethodBeat.i(115044);
    ac.m("MicroMsg.Voip.VoipMgr", "totalDeviceNearTime: %s", new Object[] { Long.valueOf(this.AAm) });
    long l = this.AAm / 1000L;
    AppMethodBeat.o(115044);
    return l;
  }
  
  public final void ehR()
  {
    AppMethodBeat.i(115058);
    if ((256 != this.Azy.mState) && (257 != this.Azy.mState))
    {
      AppMethodBeat.o(115058);
      return;
    }
    if ((com.tencent.mm.kernel.g.agR().agA().getInt(327945, 0) == 0) && (this.AzA.ekX() != null))
    {
      com.tencent.mm.kernel.g.agR().agA().setInt(327945, 1);
      com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.a(this.AzA.ekX(), 2131764868, 2131755906, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(208340);
          VoipMgr.this.ehT();
          AppMethodBeat.o(208340);
        }
      });
      locald.setCancelable(false);
      locald.setCanceledOnTouchOutside(false);
      locald.show();
      AppMethodBeat.o(115058);
      return;
    }
    com.tencent.mm.plugin.voip.b.l.gC(com.tencent.mm.sdk.platformtools.ai.getContext());
    ehT();
    AppMethodBeat.o(115058);
  }
  
  public final void ehS()
  {
    AppMethodBeat.i(115059);
    if (!this.AzW) {}
    for (boolean bool = true;; bool = false)
    {
      this.AzW = bool;
      if (!this.AzW) {
        break;
      }
      this.AzV.stopTimer();
      AppMethodBeat.o(115059);
      return;
    }
    if (this.AzV == null) {
      this.AzV = new au("faceDetect", new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(208344);
          VoipMgr.L(VoipMgr.this);
          AppMethodBeat.o(208344);
          return true;
        }
      }, true);
    }
    this.AzV.au(2000L, 2000L);
    this.AzW = false;
    AppMethodBeat.o(115059);
  }
  
  public final void ehT()
  {
    AppMethodBeat.i(115060);
    com.tencent.mm.plugin.voip.c.ehb().AEM = com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId;
    String str2 = this.AzG.field_username;
    String str1;
    if (this.AzI)
    {
      str1 = bo.GYP;
      if (!this.AzH) {
        break label124;
      }
    }
    label124:
    for (int i = 1;; i = 0)
    {
      s.c(str2, str1, i, 6, com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764806));
      ehD();
      tg(4108);
      if (this.jdu != null) {
        this.jdu.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(208341);
            VoipMgr.K(VoipMgr.this);
            AppMethodBeat.o(208341);
          }
        }, 2000L);
      }
      AppMethodBeat.o(115060);
      return;
      str1 = bo.GYO;
      break;
    }
  }
  
  public final boolean ehm()
  {
    AppMethodBeat.i(115003);
    if (!this.Azy.SY(4103))
    {
      AppMethodBeat.o(115003);
      return false;
    }
    RV(4103);
    com.tencent.mm.plugin.voip.c.ehb().ejY();
    AppMethodBeat.o(115003);
    return true;
  }
  
  public final boolean ehn()
  {
    AppMethodBeat.i(115004);
    if (!this.Azy.SY(4101))
    {
      AppMethodBeat.o(115004);
      return false;
    }
    ehD();
    com.tencent.mm.plugin.voip.c.ehb().Sm(1);
    com.tencent.mm.plugin.voip.c.ehb().ar(true, this.AzI);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.wUl;
    long l = com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.tIG;
    int j = com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId;
    if (this.AzH) {}
    for (int i = 1;; i = 0)
    {
      localh.f(11046, new Object[] { Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i) });
      com.tencent.mm.plugin.report.service.h.wUl.f(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0) });
      tg(4111);
      tg(4101);
      tg(4100);
      AppMethodBeat.o(115004);
      return true;
    }
  }
  
  public final boolean eho()
  {
    int i = 0;
    AppMethodBeat.i(115005);
    if (!this.Azy.SY(4099))
    {
      AppMethodBeat.o(115005);
      return false;
    }
    String str2 = this.AzG.field_username;
    if (this.AzI) {}
    for (String str1 = bo.GYP;; str1 = bo.GYO)
    {
      if (this.AzH) {
        i = 1;
      }
      s.c(str2, str1, i, 6, com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764807));
      ehD();
      com.tencent.mm.plugin.voip.c.ehb().AEF.ekj();
      tg(4099);
      ehH();
      AppMethodBeat.o(115005);
      return true;
    }
  }
  
  public final boolean ehp()
  {
    AppMethodBeat.i(115006);
    if (!this.Azy.SY(4100))
    {
      AppMethodBeat.o(115006);
      return false;
    }
    if ((com.tencent.mm.compatible.deviceinfo.ae.fJd.fEF == 1) && (this.AzI)) {
      sC(true);
    }
    if (((!this.ADV) || (com.tencent.mm.compatible.deviceinfo.ae.fJd.fEF == 1) || (com.tencent.mm.compatible.deviceinfo.ae.fJd.fEG == 1)) && (this.AzI)) {
      if ((this.ADP != null) && (!this.ADP.emq())) {
        break label152;
      }
    }
    label152:
    for (boolean bool = true;; bool = false)
    {
      sC(bool);
      this.ADV = true;
      ac.i("MicroMsg.Voip.VoipMgr", "onAcceptVideoInvite");
      ehD();
      com.tencent.mm.plugin.voip.c.ehb().ar(false, this.AzI);
      tg(4100);
      AppMethodBeat.o(115006);
      return true;
    }
  }
  
  public final void ehq()
  {
    this.ADV = false;
  }
  
  public final boolean ehr()
  {
    int i = 0;
    AppMethodBeat.i(115007);
    if (!this.Azy.SY(4099))
    {
      AppMethodBeat.o(115007);
      return false;
    }
    ac.i("MicroMsg.Voip.VoipMgr", "onRejectVoiceInvite");
    String str2 = this.AzG.field_username;
    if (this.AzI) {}
    for (String str1 = bo.GYP;; str1 = bo.GYO)
    {
      if (this.AzH) {
        i = 1;
      }
      s.c(str2, str1, i, 6, com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764807));
      ehD();
      com.tencent.mm.plugin.voip.c.ehb().AEF.ekj();
      tg(4099);
      ehH();
      AppMethodBeat.o(115007);
      return true;
    }
  }
  
  public final boolean ehs()
  {
    AppMethodBeat.i(115008);
    if (!this.Azy.SY(4100))
    {
      AppMethodBeat.o(115008);
      return false;
    }
    ac.i("MicroMsg.Voip.VoipMgr", "onAcceptVoiceInvite");
    ehD();
    com.tencent.mm.plugin.voip.c.ehb().ar(true, this.AzI);
    tg(4111);
    tg(4100);
    AppMethodBeat.o(115008);
    return true;
  }
  
  public final boolean eht()
  {
    AppMethodBeat.i(115009);
    if (!this.Azy.SY(4098))
    {
      AppMethodBeat.o(115009);
      return false;
    }
    ac.i("MicroMsg.Voip.VoipMgr", "onCancelVideoInvite");
    RV(4098);
    com.tencent.mm.plugin.voip.c.ehb().ejY();
    AppMethodBeat.o(115009);
    return true;
  }
  
  public final boolean ehu()
  {
    AppMethodBeat.i(115010);
    if (!this.Azy.SY(4098))
    {
      AppMethodBeat.o(115010);
      return false;
    }
    ac.i("MicroMsg.Voip.VoipMgr", "onCancelVoiceInvite");
    RV(4098);
    com.tencent.mm.plugin.voip.c.ehb().ejY();
    AppMethodBeat.o(115010);
    return true;
  }
  
  public final void ehv()
  {
    AppMethodBeat.i(115012);
    if ((this.AzI) && (this.AzA != null))
    {
      this.AzA.setCaptureView(this.otK);
      if ((com.tencent.mm.compatible.deviceinfo.ae.fJd.fEF == 0) || (this.AzH)) {
        if ((this.ADP != null) && (!this.ADP.emq())) {
          break label145;
        }
      }
    }
    label145:
    for (boolean bool = true;; bool = false)
    {
      sC(bool);
      if ((this.AzH) && (j.SW(this.Azy.mState)) && (com.tencent.mm.plugin.voip.c.ehb().AEF.bVB()))
      {
        this.Azx.av(this.AzI, this.AzH);
        this.Azx.b("voip", Integer.valueOf(this.AzM));
      }
      AppMethodBeat.o(115012);
      return;
    }
  }
  
  public final void ehw()
  {
    AppMethodBeat.i(115014);
    ac.i("MicroMsg.Voip.VoipMgr", "it is init voip report");
    this.ADW = new NetChangedBroadcastReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    com.tencent.mm.sdk.platformtools.ai.getContext().registerReceiver(this.ADW, localIntentFilter);
    this.ouQ = ((TelephonyManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("phone"));
    this.AAw = com.tencent.mm.plugin.voip.b.d.getNetType(getContext());
    this.AAz = new VoipMgr.19(this);
    this.ouQ.listen(this.AAz, 256);
    AppMethodBeat.o(115014);
  }
  
  public final void ehy()
  {
    AppMethodBeat.i(115017);
    ac.i("MicroMsg.Voip.VoipMgr", "onSwitchCamera");
    if (this.ADP != null) {
      this.ADP.emn();
    }
    com.tencent.mm.plugin.report.service.h.wUl.f(11079, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(115017);
  }
  
  public final void ehz()
  {
    AppMethodBeat.i(115018);
    if (true != this.ADP.emq()) {
      ehy();
    }
    AppMethodBeat.o(115018);
  }
  
  public final int getState()
  {
    return this.Azy.mState;
  }
  
  public final String getUserName()
  {
    return this.foE;
  }
  
  public final void ie(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115039);
    ac.i("MicroMsg.Voip.VoipMgr", "adjustHWViewAspectRatio, HWDecsize:%dx%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.AAu = paramInt1;
    this.AAv = paramInt2;
    if (this.AzA != null) {
      this.AzA.ie(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115039);
  }
  
  public final void kc(boolean paramBoolean)
  {
    AppMethodBeat.i(114995);
    ac.m("MicroMsg.Voip.VoipMgr", "onSensorEvent, isON: %s, lastIsDeviceNear: %s, deviceSwitchNearScreenTick: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.AAl), Long.valueOf(this.AAk) });
    if (this.Azy == null)
    {
      ac.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, not create stateMachine yet, ignore");
      AppMethodBeat.o(114995);
      return;
    }
    if (this.oUJ)
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.oUJ = paramBoolean;
        ac.i("MicroMsg.Voip.VoipMgr", "onSensorEvent has skip and val is %s", new Object[] { Boolean.valueOf(this.oUJ) });
        AppMethodBeat.o(114995);
        return;
      }
    }
    if ((Math.abs(bs.Gn() - this.AAn) < 500L) && (this.AAn != -1L))
    {
      ac.i("MicroMsg.Voip.VoipMgr", "onSensorEvent time interval too small");
      AppMethodBeat.o(114995);
      return;
    }
    if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pZQ, true)) && (!paramBoolean) && (this.lastShakeTime != -1L) && (bs.aO(this.lastShakeTime) > 400L))
    {
      this.oUJ = true;
      ac.i("MicroMsg.Voip.VoipMgr", "onSensorEvent has skip case shake near to small");
      AppMethodBeat.o(114995);
      return;
    }
    this.oUJ = false;
    if ((j.SU(this.Azy.mState)) && ((this.AAl != paramBoolean) || (this.AAk == -1L)))
    {
      if ((!this.AAl) && (paramBoolean) && (!j.SV(this.Azy.mState)) && (this.mUIType != 2) && (this.AAk != -1L))
      {
        long l = bs.aO(this.AAk);
        ac.i("MicroMsg.Voip.VoipMgr", "accumulate near screen time: %s", new Object[] { Long.valueOf(l) });
        this.AAm += l;
      }
      this.AAk = bs.Gn();
      this.AAl = paramBoolean;
    }
    if (this.AzA == null)
    {
      ac.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, voipUI is null, ignore");
      AppMethodBeat.o(114995);
      return;
    }
    if (((this.AzH) || (j.SU(this.Azy.mState))) && (!j.SV(this.Azy.mState)) && (this.mUIType != 2))
    {
      ac.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, isOn: ".concat(String.valueOf(paramBoolean)));
      this.AzA.setScreenEnable(paramBoolean);
      this.AzC = paramBoolean;
      this.AAn = bs.Gn();
    }
    AppMethodBeat.o(114995);
  }
  
  public final void ne(boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(115050);
    ac.i("MicroMsg.Voip.VoipMgr", "onBadNetStatus");
    if (this.AzA != null) {
      this.AzA.sI(paramBoolean);
    }
    long l;
    if ((!j.SV(this.Azy.mState)) && (!this.Azx.isSpeakerphoneOn()))
    {
      l = System.currentTimeMillis();
      if (l - this.tJt > 30000L)
      {
        this.tJt = l;
        com.tencent.mm.plugin.voip.c.ehb().AEF.ekn();
      }
    }
    Object localObject = new StringBuilder("report the bad net toast room key is ").append(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.tIG).append("and in the side");
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      ac.i("MicroMsg.Voip.VoipMgr", i);
      localObject = com.tencent.mm.plugin.report.service.h.wUl;
      l = com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.tIG;
      i = j;
      if (paramBoolean) {
        i = 1;
      }
      ((com.tencent.mm.plugin.report.service.h)localObject).a(17151, true, true, new Object[] { Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(115050);
      return;
    }
  }
  
  public final void nm(int paramInt) {}
  
  public final void om(boolean paramBoolean)
  {
    AppMethodBeat.i(115002);
    this.Azx.sO(paramBoolean);
    AppMethodBeat.o(115002);
  }
  
  public final void onConnected()
  {
    AppMethodBeat.i(115032);
    tg(4102);
    this.AzN = bs.aNx();
    if (this.AzA != null) {
      this.AzA.setConnectSec(this.AzN);
    }
    boolean bool1 = com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.eio();
    boolean bool2 = com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ein();
    if ((this.AzI) && (this.AzH) && (!bool2) && (!bool1)) {
      com.tencent.mm.plugin.voip.c.ehb().Sm(1);
    }
    if (!j.SV(this.Azy.mState)) {
      com.tencent.mm.plugin.report.service.h.wUl.f(11080, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
    }
    bs.D(com.tencent.mm.sdk.platformtools.ai.getContext(), true);
    com.tencent.mm.plugin.voip.c.ehb().Sx(com.tencent.mm.plugin.voip.c.ehb().ejX());
    r.ejf().ejg();
    r.ejf().a(this);
    k localk = k.ABe;
    k.setRoomId(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId);
    AppMethodBeat.o(115032);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(115026);
    com.tencent.mm.plugin.voip.b.c.sQ(this.AzI);
    String str1 = paramString;
    if (paramInt == 241)
    {
      str1 = paramString;
      if (bs.isNullOrNil(paramString)) {
        str1 = getContext().getString(2131764903);
      }
    }
    if (this.AzA != null) {
      this.AzA.cg(paramInt, str1);
    }
    tg(4109);
    ac.i("MicroMsg.Voip.VoipMgr", "onError, errCode: %s, roomId: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId) });
    paramString = com.tencent.mm.sdk.platformtools.ai.getContext();
    ac.d("MicroMsg.Voip.VoipMgr", "getErrorMsgContent, errorCode".concat(String.valueOf(paramInt)));
    if (paramInt == 235)
    {
      paramString = paramString.getString(2131764809);
      if ((com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId == 0) || (com.tencent.mm.plugin.voip.c.ehb().AEL.get(Integer.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId)) != null)) {
        break label427;
      }
      str2 = this.AzG.field_username;
      if (!this.AzI) {
        break label414;
      }
      str1 = bo.GYP;
      if (!this.AzH) {
        break label422;
      }
      paramInt = 1;
      if (j.SU(this.Azy.mState)) {
        paramString = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764804, new Object[] { qn(bs.pN(this.AzN)) });
      }
      l = s.a(str2, str1, paramInt, 6, paramString, true);
      com.tencent.mm.plugin.voip.c.ehb().AEL.put(Integer.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId), Long.valueOf(l));
    }
    label414:
    label422:
    label427:
    while (com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId != 0) {
      for (;;)
      {
        long l;
        com.tencent.mm.plugin.voip.c.ehb().ejY();
        ehH();
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
        str1 = bo.GYO;
        continue;
        paramInt = 0;
      }
    }
    String str2 = this.AzG.field_username;
    if (this.AzI)
    {
      str1 = bo.GYP;
      label466:
      if (!this.AzH) {
        break label539;
      }
    }
    label539:
    for (paramInt = 1;; paramInt = 0)
    {
      if (j.SU(this.Azy.mState)) {
        paramString = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764804, new Object[] { qn(bs.pN(this.AzN)) });
      }
      s.a(str2, str1, paramInt, 6, paramString, true);
      break;
      str1 = bo.GYO;
      break label466;
    }
  }
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(115064);
    if (this.AzA != null) {
      this.AzA.requestRender();
    }
    AppMethodBeat.o(115064);
  }
  
  public final void onReject()
  {
    AppMethodBeat.i(115028);
    ac.i("MicroMsg.Voip.VoipMgr", "onReject");
    tg(4099);
    String str2 = this.AzG.field_username;
    String str1;
    if (this.AzI)
    {
      str1 = bo.GYP;
      if (!this.AzH) {
        break label86;
      }
    }
    label86:
    for (int i = 1;; i = 0)
    {
      s.c(str2, str1, i, 6, com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764811));
      ehH();
      AppMethodBeat.o(115028);
      return;
      str1 = bo.GYO;
      break;
    }
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115038);
    this.AAi = paramInt;
    if (this.AzA != null) {
      this.AzA.setHWDecMode(paramInt);
    }
    if (this.ADX != null)
    {
      Object localObject;
      if (this.ADY != null)
      {
        localObject = this.ADY;
        if ((paramInt & 0x1) == 0) {
          break label96;
        }
      }
      label96:
      for (int i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.voip.b.a)localObject).S(false, i);
        this.ADY.elB();
        localObject = this.ADX;
        if ((paramInt & 0x1) == 0) {
          break;
        }
        ((com.tencent.mm.plugin.voip.b.h)localObject).AMf += 1L;
        AppMethodBeat.o(115038);
        return;
      }
      ((com.tencent.mm.plugin.voip.b.h)localObject).AMg += 1L;
    }
    AppMethodBeat.o(115038);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    this.AzM = paramInt;
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115037);
    ac.i("MicroMsg.Voip.VoipMgr", "setVoipBeauty, isON: " + paramInt + "，mVoipUI: " + this.AzA);
    if (this.AzA != null) {
      this.AzA.setVoipBeauty(paramInt);
    }
    if ((paramInt != 0) && (this.AAj != paramInt)) {
      com.tencent.mm.plugin.report.service.h.wUl.n(914L, 20L, 1L);
    }
    this.AAG = 2;
    this.AAj = paramInt;
    AppMethodBeat.o(115037);
  }
  
  public final void sr(boolean paramBoolean)
  {
    AppMethodBeat.i(208356);
    if ((this.Azy != null) && (this.Azy.mState >= 0) && (this.Azy.mState <= 8)) {}
    for (int i = 1; i == 0; i = 0)
    {
      ac.i("MicroMsg.Voip.VoipMgr", "steve:[simucall] same state, no need to reset, return!");
      AppMethodBeat.o(208356);
      return;
    }
    int j = j.ay(false, paramBoolean);
    i = j;
    if (this.AzJ)
    {
      if (j != 0) {
        break label136;
      }
      i = 1;
    }
    for (;;)
    {
      this.Azy = j.SS(i);
      ac.i("MicroMsg.Voip.VoipMgr", "steve:[simucall] resetStateMachine, initState:%d,isOutCall:%s,isVideoCall:%s", new Object[] { Integer.valueOf(i), Boolean.FALSE, Boolean.valueOf(paramBoolean) });
      this.AzH = false;
      AppMethodBeat.o(208356);
      return;
      label136:
      i = j;
      if (256 == j) {
        i = 257;
      }
    }
  }
  
  public final void su(boolean paramBoolean)
  {
    AppMethodBeat.i(115001);
    ac.i("MicroMsg.Voip.VoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Azx.cm(paramBoolean);
    this.Azx.ALV = true;
    AppMethodBeat.o(115001);
  }
  
  public final void sv(boolean paramBoolean) {}
  
  public final boolean sw(final boolean paramBoolean)
  {
    AppMethodBeat.i(115057);
    if (com.tencent.mm.plugin.voip.c.ehb().AEU)
    {
      ac.i("MicroMsg.Voip.VoipMgr", "current state is mini, cannot mini!");
      AppMethodBeat.o(115057);
      return false;
    }
    if ((this.AAd) && (!paramBoolean))
    {
      ac.i("MicroMsg.Voip.VoipMgr", "has phone call  cannot mini!");
      AppMethodBeat.o(115057);
      return false;
    }
    ac.l("MicroMsg.Voip.VoipMgr", "miniOnlyHidenVoip: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ac.i("MicroMsg.Voip.VoipMgr", "onMinimizeVoip, async to minimize");
    if (this.AzA != null)
    {
      this.AzA.uninit();
      this.AzA = null;
      this.Azx.b(this.AzA);
    }
    if (this.ADR != null) {
      this.ADR.uninit();
    }
    if (this.jdu != null) {
      this.jdu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(208339);
          VoipMgr.d(VoipMgr.this, paramBoolean);
          AppMethodBeat.o(208339);
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
        switch (com.tencent.mm.plugin.voip.b.d.getNetType(paramContext))
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
              j = VoipMgr.aKS()[1];
              if (VoipMgr.k(VoipMgr.this) == 0) {
                VoipMgr.a(VoipMgr.this, 4);
              }
            } while (VoipMgr.k(VoipMgr.this) == 0);
            k = VoipMgr.dia() / VoipMgr.k(VoipMgr.this);
            VoipMgr.a(VoipMgr.this, 5);
            m = VoipMgr.aKS()[0];
            ac.i("MicroMsg.Voip.VoipMgr", "befor change to 4G and cost " + VoipMgr.l(VoipMgr.this));
            if (VoipMgr.c(VoipMgr.this)) {}
            for (;;)
            {
              com.tencent.mm.plugin.voip.b.d.a(i, System.currentTimeMillis(), VoipMgr.j(VoipMgr.this), 5, j, m, k);
              VoipMgr.m(VoipMgr.this);
              VoipMgr.b(VoipMgr.this, 5);
              VoipMgr.dic();
              VoipMgr.n(VoipMgr.this);
              AppMethodBeat.o(114993);
              return;
              i = 1;
            }
          } while (VoipMgr.j(VoipMgr.this) == 4);
          k = VoipMgr.aKS()[0];
          if (VoipMgr.k(VoipMgr.this) == 0) {
            VoipMgr.a(VoipMgr.this, 5);
          }
        } while (VoipMgr.k(VoipMgr.this) == 0);
        int m = VoipMgr.dia() / VoipMgr.k(VoipMgr.this);
        VoipMgr.a(VoipMgr.this, 4);
        int n = VoipMgr.aKS()[1];
        ac.i("MicroMsg.Voip.VoipMgr", "befor change to wifi and cost " + VoipMgr.l(VoipMgr.this));
        if (VoipMgr.c(VoipMgr.this)) {}
        for (i = j;; i = 1)
        {
          com.tencent.mm.plugin.voip.b.d.a(i, System.currentTimeMillis(), VoipMgr.j(VoipMgr.this), 4, k, n, m);
          VoipMgr.m(VoipMgr.this);
          VoipMgr.b(VoipMgr.this, 4);
          VoipMgr.dic();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr
 * JD-Core Version:    0.7.0.1
 */