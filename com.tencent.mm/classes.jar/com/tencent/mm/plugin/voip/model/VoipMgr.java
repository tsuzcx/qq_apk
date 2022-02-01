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
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yg;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.a.zj.a;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.b.j;
import com.tencent.mm.plugin.voip.b.m;
import com.tencent.mm.plugin.voip.b.n;
import com.tencent.mm.plugin.voip.ui.VoipScoreDialog;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class VoipMgr
  extends com.tencent.mm.plugin.voip.a
{
  static int[] Crc = new int[2];
  static int lAL = 0;
  private com.tencent.mm.plugin.voip.b.c CpY;
  private m CpZ;
  private boolean CqA;
  private boolean CqC;
  private boolean CqE;
  private boolean CqF;
  private String CqG;
  public int CqJ;
  public int CqK;
  private long CqL;
  private boolean CqM;
  private long CqN;
  private long CqO;
  private long CqP;
  private long CqQ;
  private int CqR;
  boolean CqS;
  boolean CqT;
  private int CqU;
  public int CqV;
  public int CqW;
  int CqX;
  boolean CqY;
  volatile com.tencent.mm.plugin.voip.ui.b Cqb;
  private boolean Cqd;
  private boolean Cqe;
  private boolean Cqf;
  private Object Cqg;
  private an Cqh;
  boolean Cqi;
  private boolean Cqj;
  private boolean Cqk;
  private int Cql;
  private boolean Cqm;
  private int Cqn;
  private long Cqo;
  private boolean Cqs;
  private int Cqt;
  private com.tencent.mm.plugin.voip.video.k Cqv;
  private com.tencent.mm.sdk.platformtools.aw Cqw;
  private boolean Cqx;
  private boolean Cqy;
  private int Cqz;
  PhoneStateListener Cra;
  aq Crb;
  private long Crd;
  private boolean Cre;
  private int Crf;
  private int Crg;
  private BroadcastReceiver Cri;
  int Crk;
  private com.tencent.mm.sdk.b.c Crl;
  aq CuA;
  boolean CuB;
  private com.tencent.mm.plugin.voip.video.a Cuq;
  private a Cur;
  private com.tencent.mm.plugin.voip.widget.d Cus;
  private byte[] Cut;
  private ByteBuffer Cuu;
  private int Cuv;
  private boolean Cuw;
  NetChangedBroadcastReceiver Cux;
  private j Cuy;
  private com.tencent.mm.plugin.voip.b.a Cuz;
  private String fIQ;
  private aq jzz;
  private long lastShakeTime;
  PhoneStateListener lnc;
  private int mUIType;
  private boolean pEX;
  private bl pEY;
  private SensorController pEZ;
  private CaptureView pdJ;
  TelephonyManager peP;
  private long twc;
  private TelephonyManager uVH;
  private com.tencent.mm.sdk.b.c uVJ;
  private long uXT;
  private boolean vZZ;
  
  public VoipMgr()
  {
    AppMethodBeat.i(114994);
    this.Cur = null;
    this.Cqd = true;
    this.lastShakeTime = -1L;
    this.pEX = false;
    this.Cqe = false;
    this.Cqf = false;
    this.Cqg = new Object();
    this.Cqk = false;
    this.Cql = 4096;
    this.Cqm = false;
    this.Cqn = -1;
    this.Cqo = -1L;
    this.vZZ = false;
    this.Cqs = false;
    this.Cqt = 0;
    this.Cqv = new com.tencent.mm.plugin.voip.video.k();
    this.Cqw = null;
    this.Cqx = false;
    this.Cqy = false;
    this.Cqz = 0;
    this.CqA = false;
    this.CqC = false;
    this.CqE = false;
    this.CqF = false;
    this.CqG = null;
    this.CqJ = -1;
    this.CqK = 0;
    this.CqL = -1L;
    this.CqM = false;
    this.CqN = 0L;
    this.CqO = -1L;
    this.CqP = 0L;
    this.CqQ = 0L;
    this.CqR = 0;
    this.CqS = false;
    this.CqT = false;
    this.CqU = 0;
    this.Cut = null;
    this.Cuu = null;
    this.Cuv = 0;
    this.Cuw = true;
    this.CqV = 0;
    this.CqW = 0;
    this.CqX = 0;
    this.CqY = false;
    this.Crb = new aq("getSignalStrength");
    this.peP = null;
    this.twc = 0L;
    this.Crd = 0L;
    this.Cre = false;
    this.Crf = 0;
    this.Crg = 0;
    this.CuA = new aq("encodeVoipHandler");
    this.Cri = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(114963);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        paramAnonymousIntent = (PowerManager)ak.getContext().getSystemService("power");
        if (("android.intent.action.USER_PRESENT".equals(paramAnonymousContext)) && (paramAnonymousIntent.isScreenOn()))
        {
          VoipMgr.a(VoipMgr.this, false);
          AppMethodBeat.o(114963);
          return;
        }
        if ("android.intent.action.SCREEN_ON".equals(paramAnonymousContext))
        {
          VoipMgr.a(VoipMgr.this, false);
          VoipMgr.this.km(true);
          AppMethodBeat.o(114963);
          return;
        }
        if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousContext))
        {
          VoipMgr.a(VoipMgr.this, true);
          if (!VoipMgr.a(VoipMgr.this)) {
            VoipMgr.this.km(true);
          }
          if ((!com.tencent.mm.plugin.voip.b.l.Vu(VoipMgr.b(VoipMgr.this).mState)) && (!VoipMgr.c(VoipMgr.this))) {
            VoipMgr.d(VoipMgr.this).eyU();
          }
        }
        AppMethodBeat.o(114963);
      }
    };
    this.uVJ = new com.tencent.mm.sdk.b.c() {};
    this.Crk = 0;
    this.CuB = false;
    this.uXT = 0L;
    this.lnc = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        int i = 1;
        AppMethodBeat.i(210049);
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onCallStateChanged :%d, isStartVoip: %b,oldState:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(VoipMgr.w(VoipMgr.this)), Integer.valueOf(VoipMgr.x(VoipMgr.this)) });
        if (!VoipMgr.w(VoipMgr.this))
        {
          AppMethodBeat.o(210049);
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
          com.tencent.mm.plugin.voip.c.eys().UN(1);
          VoipMgr.c(VoipMgr.this, true);
        }
        label327:
        label361:
        do
        {
          VoipMgr.d(VoipMgr.this).Cre = VoipMgr.F(VoipMgr.this);
          AppMethodBeat.o(210049);
          return;
          if (paramAnonymousInt == 2)
          {
            VoipMgr.b(VoipMgr.this, false);
            if (VoipMgr.x(VoipMgr.this) == 1) {
              VoipMgr.e(VoipMgr.this, System.currentTimeMillis());
            }
            VoipMgr.c(VoipMgr.this, 2);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "phone call coming now!");
            if ((VoipMgr.c(VoipMgr.this)) && (!com.tencent.mm.plugin.voip.b.l.Vu(VoipMgr.b(VoipMgr.this).mState))) {
              com.tencent.mm.plugin.voip.c.eys().Cvg.eBB();
            }
            String str2;
            String str1;
            if (com.tencent.mm.plugin.voip.b.l.Vu(VoipMgr.b(VoipMgr.this).mState))
            {
              paramAnonymousString = ak.getContext().getString(2131764803, new Object[] { VoipMgr.BU(bu.rZ(VoipMgr.z(VoipMgr.this))) });
              com.tencent.mm.plugin.voip.c.eys().eBb();
              str2 = VoipMgr.A(VoipMgr.this).field_username;
              if (!VoipMgr.g(VoipMgr.this)) {
                break label596;
              }
              str1 = bv.JgL;
              if (!VoipMgr.c(VoipMgr.this)) {
                break label604;
              }
            }
            for (paramAnonymousInt = i;; paramAnonymousInt = 0)
            {
              s.c(str2, str1, paramAnonymousInt, 6, paramAnonymousString);
              VoipMgr.d(VoipMgr.this, 4107);
              VoipMgr.B(VoipMgr.this);
              paramAnonymousString = new bv();
              paramAnonymousString.setType(10000);
              paramAnonymousString.qN(System.currentTimeMillis());
              paramAnonymousString.setStatus(6);
              paramAnonymousString.setContent(ak.getContext().getString(2131764801) + ", <a href=\"weixin://voip/callagain/?username=" + VoipMgr.f(VoipMgr.this) + "&isvideocall=" + VoipMgr.g(VoipMgr.this) + "\">" + ak.getContext().getString(2131764796) + "</a>");
              if ((VoipMgr.f(VoipMgr.this) != null) && (!VoipMgr.f(VoipMgr.this).equals("")))
              {
                paramAnonymousString.ui(VoipMgr.f(VoipMgr.this));
                ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ar(paramAnonymousString);
              }
              com.tencent.mm.plugin.voip.c.eys().UN(2);
              VoipMgr.c(VoipMgr.this, false);
              break;
              paramAnonymousString = ak.getContext().getString(2131764799);
              break label327;
              str1 = bv.JgK;
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
        com.tencent.mm.plugin.voip.c.eys().UN(2);
        if ((1 == VoipMgr.C(VoipMgr.this)) && (com.tencent.mm.plugin.voip.b.l.Vu(VoipMgr.b(VoipMgr.this).mState)) && (VoipMgr.D(VoipMgr.this))) {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(210045);
              VoipMgr.d(VoipMgr.this).cn(true);
              AppMethodBeat.o(210045);
            }
          });
        }
        if ((4 == VoipMgr.C(VoipMgr.this)) && (VoipMgr.D(VoipMgr.this))) {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(210046);
              VoipMgr.d(VoipMgr.this).aA(VoipMgr.E(VoipMgr.this), VoipMgr.g(VoipMgr.this));
              AppMethodBeat.o(210046);
            }
          });
        }
        VoipMgr.b(VoipMgr.this, false);
        if (com.tencent.mm.plugin.audio.c.a.bHy().isBluetoothScoOn())
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "is bluetooth can use and start bluetooth");
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(210047);
              VoipMgr.d(VoipMgr.this).aA(VoipMgr.E(VoipMgr.this), VoipMgr.g(VoipMgr.this));
              AppMethodBeat.o(210047);
            }
          });
        }
        for (;;)
        {
          VoipMgr.c(VoipMgr.this, false);
          break;
          if (com.tencent.mm.plugin.audio.c.a.bHy().bHt()) {
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(210048);
                VoipMgr.d(VoipMgr.this).aA(VoipMgr.E(VoipMgr.this), VoipMgr.g(VoipMgr.this));
                AppMethodBeat.o(210048);
              }
            });
          }
        }
      }
    };
    this.Crl = new com.tencent.mm.sdk.b.c() {};
    this.CpY = new com.tencent.mm.plugin.voip.b.c();
    AppMethodBeat.o(114994);
  }
  
  private void F(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115047);
    if (this.Crf % 100 == 0) {
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
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onFrameDataReady, sample sendData:[%s, %s, %s, %s, %s], captureFrameCount:%s", new Object[] { Byte.valueOf(arrayOfByte[0]), Byte.valueOf(arrayOfByte[1]), Byte.valueOf(arrayOfByte[2]), Byte.valueOf(arrayOfByte[3]), Byte.valueOf(arrayOfByte[4]), Integer.valueOf(this.Crf) });
          paramInt2 = 0;
          paramInt1 = 0;
          break label288;
          if (paramInt1 >= 5)
          {
            paramArrayOfByte = t.Cvc;
            t.eAX();
          }
          AppMethodBeat.o(115047);
          return;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "sample check sendData error! %s", new Object[] { Integer.valueOf(paramArrayOfByte.length) });
        AppMethodBeat.o(115047);
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.Voip.VoipMgr", paramArrayOfByte, "sampleCheckSendData error", new Object[0]);
      }
      AppMethodBeat.o(115047);
      return;
      label272:
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "sample check sendData error is null or empty");
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
  
  private void Uu(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(115019);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "hangupTalkingOrCancelInvite");
    if (true == ezh()) {
      this.Cql = paramInt;
    }
    Object localObject = ak.getContext();
    String str2;
    if (com.tencent.mm.plugin.voip.b.l.Vu(this.CpZ.mState))
    {
      localObject = ((Context)localObject).getString(2131764803, new Object[] { sz(bu.rZ(this.Cqo)) });
      str2 = this.Cqh.field_username;
      if (!this.Cqj) {
        break label251;
      }
    }
    label251:
    for (String str1 = bv.JgL;; str1 = bv.JgK)
    {
      if (this.Cqi) {
        i = 1;
      }
      s.c(str2, str1, i, 6, (String)localObject);
      if ((!this.Cqi) || (com.tencent.mm.plugin.voip.b.l.Vu(this.CpZ.mState))) {
        break label259;
      }
      eyU();
      if ((this.Cqi) && (!com.tencent.mm.plugin.voip.b.l.Vu(this.CpZ.mState)))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call cancelCall");
        com.tencent.mm.plugin.voip.c.eys().Cvg.eBA();
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call hangUp");
      com.tencent.mm.plugin.voip.c.eys().Cvg.eBD();
      if (4096 != this.Cql) {
        break label315;
      }
      tP(paramInt);
      eyZ();
      AppMethodBeat.o(115019);
      return;
      if (this.Cqi)
      {
        localObject = ((Context)localObject).getString(2131764798);
        break;
      }
      localObject = ((Context)localObject).getString(2131764797);
      break;
    }
    label259:
    com.tencent.e.h.MqF.aO(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "VoipMgr_play_end_sound";
      }
      
      public final void run()
      {
        AppMethodBeat.i(210066);
        VoipMgr.d(VoipMgr.this);
        com.tencent.mm.plugin.voip.b.c.tG(VoipMgr.g(VoipMgr.this));
        AppMethodBeat.o(210066);
      }
    });
    this.Cqe = true;
    this.Cqf = true;
    com.tencent.mm.plugin.voip.c.eys().Cvg.eBD();
    if (4096 == this.Cql)
    {
      tP(paramInt);
      eyZ();
    }
    label315:
    AppMethodBeat.o(115019);
  }
  
  private boolean Uv(int paramInt)
  {
    AppMethodBeat.i(115024);
    if (4111 == paramInt)
    {
      AppMethodBeat.o(115024);
      return true;
    }
    if ((4101 == paramInt) && ((com.tencent.mm.plugin.voip.b.l.Vu(this.CpZ.mState)) || (this.Cqi)))
    {
      AppMethodBeat.o(115024);
      return true;
    }
    AppMethodBeat.o(115024);
    return false;
  }
  
  private static void Uw(int paramInt)
  {
    AppMethodBeat.i(115025);
    zj localzj = new zj();
    localzj.dPA.dlO = paramInt;
    com.tencent.mm.sdk.b.a.IvT.l(localzj);
    AppMethodBeat.o(115025);
  }
  
  private boolean d(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(115053);
    String str = com.tencent.mm.n.g.acL().getValue("VOIPShortcutAutoadd");
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "voip shortcut autoAdd is %s", new Object[] { str });
    if ((str != null) && (str.equals("0")) && (bu.rZ(this.Cqo) > 30L))
    {
      int i = paramSharedPreferences.getInt("voip_shortcut_prompt_times", 0);
      boolean bool = paramSharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
      if ((i < 3) && (!bool))
      {
        ezi();
        paramSharedPreferences.edit().putInt("voip_shortcut_prompt_times", i + 1).commit();
        AppMethodBeat.o(115053);
        return true;
      }
    }
    else if ((str != null) && (str.equals("1")) && (bu.rZ(this.Cqo) > 15L))
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
    if (1 == bu.getInt(com.tencent.mm.n.g.acL().getValue("VOIPCallType"), 0))
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
  
  private void eAu()
  {
    AppMethodBeat.i(115043);
    if ((com.tencent.mm.compatible.util.d.lA(28)) && (this.Cqj) && (this.Cuq != null) && (!this.Cuq.cOB()) && (this.Cqb != null))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "video call accept, not previewing, api level: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      this.Cuq.eDT();
      this.Cqb.eCp();
      int k = 320;
      int m = 240;
      int j = m;
      int i = k;
      if (this.Cuq == null)
      {
        j = m;
        i = k;
        if (com.tencent.mm.plugin.voip.b.l.Vv(this.CpZ.mState))
        {
          this.pdJ = new CaptureView(ak.getContext());
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
          i = 640;
          j = 480;
        }
      }
      this.Cuq = new com.tencent.mm.plugin.voip.video.a(i, j);
      this.Cuq.a(this, true);
      this.Cuq.a(this.pdJ);
      this.Cuq.eDS();
      this.Crf = 0;
    }
    AppMethodBeat.o(115043);
  }
  
  private void eAv()
  {
    AppMethodBeat.i(115049);
    com.tencent.mm.sdk.platformtools.ae.l("MicroMsg.Voip.VoipMgr", "uninitCaptureRender", new Object[0]);
    if (this.Cuq != null) {
      ezm();
    }
    try
    {
      this.Cuq.eDT();
      this.Cuq = null;
      AppMethodBeat.o(115049);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VoipMgr", "stop capture error:" + localException.toString());
      }
    }
  }
  
  private void eAw()
  {
    AppMethodBeat.i(210076);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "uninitSurfaceTexture!");
    if (this.Cqb != null) {
      this.Cqb.releaseSurfaceTexture();
    }
    AppMethodBeat.o(210076);
  }
  
  private boolean eyX()
  {
    int j = 0;
    AppMethodBeat.i(115021);
    if (!this.CpZ.Vy(4101))
    {
      AppMethodBeat.o(115021);
      return false;
    }
    this.Cqj = false;
    if (this.Cus != null) {
      this.Cus.Cqj = false;
    }
    tP(4101);
    Object localObject1;
    int k;
    int i;
    Object localObject3;
    Object localObject2;
    if ((261 == this.CpZ.mState) || (7 == this.CpZ.mState))
    {
      com.tencent.mm.plugin.voip.c.eys().UL(1);
      localObject1 = com.tencent.mm.plugin.report.service.g.yxI;
      long l = com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.uXg;
      k = com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId;
      if (this.Cqi)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.g)localObject1).f(11046, new Object[] { Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(k), Integer.valueOf(0), Integer.valueOf(i) });
        localObject3 = com.tencent.mm.plugin.report.service.g.yxI;
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
        com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.ezL();
        com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.ezM();
        AppMethodBeat.o(115021);
        return true;
        i = 0;
        break;
      } while ((1 != this.CpZ.mState) && (3 != this.CpZ.mState));
      com.tencent.mm.plugin.voip.c.eys().UL(1);
      com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
      k = 11046;
      localObject1 = new Object[5];
      localObject1[0] = Integer.valueOf(1);
      localObject1[1] = Long.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.uXg);
      localObject1[2] = Integer.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId);
      localObject1[3] = Integer.valueOf(0);
      i = 4;
      if (this.Cqi)
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
  
  private void eyZ()
  {
    AppMethodBeat.i(115029);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VoipMgr", "delayFinish");
    this.CqG = null;
    if (this.jzz != null) {
      this.jzz.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114964);
          VoipMgr localVoipMgr = VoipMgr.this;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "it is uninit voip report");
          if (localVoipMgr.Crb != null)
          {
            localVoipMgr.Crb.quit();
            localVoipMgr.Crb = null;
          }
          if (!localVoipMgr.CqY)
          {
            if (localVoipMgr.Crk == 0) {
              localVoipMgr.Ut(localVoipMgr.CqX);
            }
            if (localVoipMgr.Crk != 0)
            {
              localVoipMgr.CqY = true;
              if (!localVoipMgr.Cqi) {
                break label180;
              }
            }
          }
          label180:
          for (int i = 0;; i = 1)
          {
            f.a(i, System.currentTimeMillis(), localVoipMgr.CqX, localVoipMgr.CqX, 0, 0, VoipMgr.lAL / localVoipMgr.Crk);
            VoipMgr.lAL = 0;
            VoipMgr.Crc[0] = 0;
            VoipMgr.Crc[1] = 0;
            localVoipMgr.Crk = 0;
            if (localVoipMgr.peP != null) {
              localVoipMgr.peP.listen(localVoipMgr.Cra, 0);
            }
            if (localVoipMgr.Cux != null)
            {
              ak.getContext().unregisterReceiver(localVoipMgr.Cux);
              localVoipMgr.Cux = null;
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
  
  private static void eza()
  {
    AppMethodBeat.i(210074);
    yh localyh = new yh();
    localyh.dNE.dto = 11;
    com.tencent.mm.sdk.b.a.IvT.l(localyh);
    AppMethodBeat.o(210074);
  }
  
  private void ezg()
  {
    AppMethodBeat.i(115048);
    synchronized (this.Cqg)
    {
      eAv();
      com.tencent.mm.plugin.voip.b.c.unInit();
      this.CpY.ezg();
      AppMethodBeat.o(115048);
      return;
    }
  }
  
  private boolean ezh()
  {
    AppMethodBeat.i(115052);
    if (com.tencent.mm.plugin.voip.b.l.Vu(this.CpZ.mState))
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
  
  private void ezi()
  {
    AppMethodBeat.i(115056);
    Context localContext = getContext();
    View localView = View.inflate(localContext, 2131494763, null);
    final CheckBox localCheckBox = (CheckBox)localView.findViewById(2131302304);
    localCheckBox.setChecked(false);
    TextView localTextView = (TextView)localView.findViewById(2131302306);
    if (1 == bu.getInt(com.tencent.mm.n.g.acL().getValue("VOIPCallType"), 0)) {
      localTextView.setText(2131764786);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(localContext, false, localContext.getString(2131755906), localView, localContext.getString(2131755939), localContext.getString(2131755831), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(210050);
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
          AppMethodBeat.o(210050);
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
  
  private void ezm()
  {
    AppMethodBeat.i(115062);
    if (this.Cqv != null) {
      this.Cqv.b(this);
    }
    if (this.Cqw != null)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VoipMgr", "stop face detect timer");
      this.Cqw.stopTimer();
    }
    AppMethodBeat.o(115062);
  }
  
  private void ge(boolean paramBoolean)
  {
    AppMethodBeat.i(115030);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "finish");
    this.CqC = false;
    this.CqE = false;
    this.lastShakeTime = -1L;
    int i;
    Object localObject1;
    if (this.Cuy != null) {
      if (this.Cuz != null)
      {
        i = this.CqJ;
        localObject1 = this.Cuz;
        if ((i & 0x1) == 0) {
          break label773;
        }
        i = 1;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.voip.b.a)localObject1).W(false, i);
      this.Cuz.eCU();
      this.Cuy.eDv();
      if (this.CuA != null)
      {
        this.CuA.removeCallbacksAndMessages(null);
        this.CuA = null;
      }
      if (this.Cqt != -1)
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(11700, new Object[] { Integer.valueOf(this.Cqt), Long.valueOf(bu.rZ(this.Cqo)) });
        this.Cqt = -1;
      }
      try
      {
        ak.getContext().unregisterReceiver(this.Cri);
        label165:
        com.tencent.mm.sdk.b.a.IvT.d(this.uVJ);
        com.tencent.mm.sdk.b.a.IvT.d(this.Crl);
        eAw();
        if (this.Cqb != null)
        {
          this.Cqb.uninit();
          this.Cqb = null;
          this.CpY.b(this.Cqb);
        }
        this.pdJ = null;
        label245:
        int j;
        label264:
        label329:
        long l;
        if (com.tencent.mm.plugin.voip.c.eys() != null)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.voip.c.eys().eBc();
            if (!this.Cqj) {
              break label791;
            }
            com.tencent.mm.plugin.voip.c.eys().c(false, true, this.fIQ);
            com.tencent.mm.plugin.voip.c.eys().b(ak.getContext(), this);
          }
        }
        else
        {
          this.CpY.drG();
          com.tencent.mm.plugin.voip.c.eys().eBo();
          com.tencent.mm.plugin.voip.c.eys().UV(this.CqK);
          if (!this.Cqe) {
            break label806;
          }
          this.Cur = new a();
          com.tencent.e.h.MqF.aO(this.Cur);
          if ((this.uVH != null) && (this.lnc != null))
          {
            this.uVH.listen(this.lnc, 0);
            this.lnc = null;
          }
          this.uVH = null;
          com.tencent.mm.booter.a.WB().WC();
          r.eAx().eAz();
          r.eAx().a(null);
          ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
          if (this.pEZ != null)
          {
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VoipMgr", "removeSensorCallBack");
            this.pEZ.fpx();
            this.pEZ = null;
            this.CqM = false;
            this.CqN = 0L;
            this.CqL = -1L;
          }
          if (this.pEY != null) {
            this.pEY.fpy();
          }
          this.CqO = -1L;
          com.tencent.mm.plugin.voip.c.eys().eBr();
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "finish, isFinishFromShutdown: %s", new Object[] { Boolean.valueOf(this.Cqf) });
          if ((this.Cqf) && (com.tencent.mm.plugin.voip.c.eys().eBs()))
          {
            com.tencent.mm.plugin.voip.c.eys();
            VoipScoreState.eAZ();
            Object localObject2 = new Intent(getContext(), VoipScoreDialog.class);
            ((Intent)localObject2).putExtra("key_score_state", com.tencent.mm.plugin.voip.c.eys().eBu());
            if (!(getContext() instanceof Activity)) {
              ((Intent)localObject2).addFlags(268435456);
            }
            localObject1 = getContext();
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/voip/model/VoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/voip/model/VoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          com.tencent.mm.plugin.voip.c.eys().eBt();
          eza();
          if (!this.CqT)
          {
            j = com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId;
            l = com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.uXg;
            if (!this.Cqi) {
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
          this.CqT = true;
          this.Cut = null;
          this.Cuv = 0;
          ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
          com.tencent.mm.media.g.c.hnb.atY();
          AppMethodBeat.o(115030);
          return;
          i = 0;
          break;
          com.tencent.mm.plugin.voip.c.eys().Cvg.eBD();
          break label245;
          com.tencent.mm.plugin.voip.c.eys().c(false, false, this.fIQ);
          break label264;
          ezg();
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
    if (this.Cqb != null) {
      localContext1 = this.Cqb.eCq();
    }
    Context localContext2 = localContext1;
    if (localContext1 == null) {
      localContext2 = ak.getContext();
    }
    AppMethodBeat.o(115055);
    return localContext2;
  }
  
  private static String sz(long paramLong)
  {
    AppMethodBeat.i(115045);
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
    AppMethodBeat.o(115045);
    return str;
  }
  
  private void tP(final int paramInt)
  {
    AppMethodBeat.i(115023);
    com.tencent.mm.sdk.platformtools.ae.l("MicroMsg.Voip.VoipMgr", "swtchState, action: %s, currentState: %s", new Object[] { com.tencent.mm.plugin.voip.b.l.Vr(paramInt), com.tencent.mm.plugin.voip.b.l.Vr(this.CpZ.mState) });
    if ((4101 == paramInt) && (com.tencent.mm.plugin.voip.b.l.Vv(this.CpZ.mState)))
    {
      eAv();
      this.Cqj = false;
      if (this.Cus != null) {
        this.Cus.Cqj = false;
      }
    }
    if (Uv(paramInt)) {
      this.CpY.Cqq = false;
    }
    if ((Uv(paramInt)) && (1 == this.mUIType) && (1 == this.Cqn))
    {
      this.CqF = true;
      this.CpY.cn(false);
      if (!com.tencent.mm.plugin.voip.c.eys().Cvg.cbt())
      {
        this.CpY.eyU();
        this.CpY.aB(false, this.Cqi);
      }
    }
    this.CpZ.Vz(paramInt);
    if (this.jzz != null) {
      this.jzz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114991);
          if (VoipMgr.q(VoipMgr.this) != null) {
            VoipMgr.q(VoipMgr.this).iy(paramInt, VoipMgr.b(VoipMgr.this).mState);
          }
          AppMethodBeat.o(114991);
        }
      });
    }
    switch (this.CpZ.mState)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(115023);
      return;
      Uw(5);
      AppMethodBeat.o(115023);
      return;
      Uw(6);
    }
  }
  
  private void ts(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(115015);
    if (this.Cqj)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "setCameraCaptureBind,  isFace: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
      if (this.Cuq == null) {
        this.Cuq = new com.tencent.mm.plugin.voip.video.a(640, 480);
      }
      if (this.Cuq.a(this, paramBoolean) != 1) {
        break label159;
      }
    }
    label159:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.Cuw = paramBoolean;
      if ((this.Cuw) && (this.pdJ != null))
      {
        this.Cuq.a(this.pdJ);
        com.tencent.mm.plugin.voip.c.eys().UT(this.Cuq.eDW());
        if (this.jzz != null) {
          this.jzz.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(210065);
              com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VoipMgr", "mCaptureRender == " + VoipMgr.e(VoipMgr.this));
              if (VoipMgr.e(VoipMgr.this) != null)
              {
                VoipMgr.e(VoipMgr.this).eDS();
                VoipMgr.p(VoipMgr.this);
              }
              AppMethodBeat.o(210065);
            }
          }, 50L);
        }
      }
      AppMethodBeat.o(115015);
      return;
    }
  }
  
  final void Ut(int paramInt)
  {
    AppMethodBeat.i(115013);
    if (paramInt == 5)
    {
      lAL += Crc[0];
      this.Crk += 1;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "mSignalStrength 4G" + Crc[0] + " and index is " + this.Crk);
      AppMethodBeat.o(115013);
      return;
    }
    WifiManager localWifiManager;
    if (paramInt == 4)
    {
      localWifiManager = (WifiManager)ak.getContext().getApplicationContext().getSystemService("wifi");
      if ((localWifiManager == null) || (localWifiManager.getConnectionInfo() == null)) {}
    }
    for (;;)
    {
      try
      {
        int[] arrayOfInt = Crc;
        if (localWifiManager.getConnectionInfo() != null) {
          continue;
        }
        paramInt = 0;
        arrayOfInt[1] = paramInt;
      }
      catch (Exception localException)
      {
        Crc[1] = 0;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "error happened in get wifi info");
        continue;
      }
      lAL += Crc[1];
      this.Crk += 1;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "mSignalStrength WIFI " + Crc[1] + " and index is " + this.Crk);
      AppMethodBeat.o(115013);
      return;
      paramInt = localWifiManager.getConnectionInfo().getRssi();
    }
  }
  
  public final void Ux(int paramInt)
  {
    AppMethodBeat.i(115035);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "remote voip mode changed, cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    if (((1 == paramInt) || (3 == paramInt) || (5 == paramInt) || (6 == paramInt) || (7 == paramInt)) && (this.Cqj))
    {
      tP(4101);
      com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.ezL();
      com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.ezM();
    }
    AppMethodBeat.o(115035);
  }
  
  public final void Uy(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(115040);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onSessionBeingCalled, callType: ".concat(String.valueOf(paramInt)));
    if (!this.CpZ.Vy(4110))
    {
      AppMethodBeat.o(115040);
      return;
    }
    u localu = com.tencent.mm.plugin.voip.c.eys();
    if (paramInt == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramInt == 1) {
        bool2 = true;
      }
      localu.av(bool1, bool2);
      eyU();
      if ((paramInt == 1) && (com.tencent.mm.plugin.voip.b.l.Vv(this.CpZ.mState))) {
        tP(4101);
      }
      tP(4110);
      AppMethodBeat.o(115040);
      return;
    }
  }
  
  public final void Uz(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(115041);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "steve:[simucall]onNewSimulCallAutoAccept, callType: ".concat(String.valueOf(paramInt)));
    if (!this.CpZ.Vy(4100))
    {
      AppMethodBeat.o(115041);
      return;
    }
    u localu = com.tencent.mm.plugin.voip.c.eys();
    if (paramInt == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramInt == 1) {
        bool2 = true;
      }
      localu.av(bool1, bool2);
      com.tencent.mm.plugin.voip.c.eys().Cvg.stopRing();
      if ((paramInt == 1) && (com.tencent.mm.plugin.voip.b.l.Vv(this.CpZ.mState))) {
        tP(4101);
      }
      tP(4100);
      AppMethodBeat.o(115041);
      return;
    }
  }
  
  public final void a(final Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(210067);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "start VoIP, userName: %s, isOutCall: %b, isVideoCall: %b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.CpY.az(paramBoolean2, paramBoolean1);
    this.CpY.eDd();
    this.CqC = true;
    this.fIQ = paramString;
    this.Cqi = paramBoolean1;
    this.Cqj = paramBoolean2;
    this.Cqh = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(this.fIQ);
    this.jzz = new aq(Looper.getMainLooper());
    this.CqJ = 0;
    this.CqK = 0;
    boolean bool1;
    int j;
    label191:
    label211:
    boolean bool2;
    Object localObject1;
    label264:
    label311:
    Object localObject2;
    if (bu.getInt(com.tencent.mm.n.g.acL().getValue("VOIPCameraSwitch"), 1) == 0)
    {
      bool1 = true;
      this.Cqk = bool1;
      if (!this.Cqj) {
        this.Cqk = false;
      }
      j = com.tencent.mm.plugin.voip.b.l.aE(paramBoolean1, paramBoolean2);
      i = j;
      if (this.Cqk)
      {
        if (j != 0) {
          break label597;
        }
        i = 1;
        com.tencent.mm.plugin.voip.c.eys().UL(1);
      }
      if (!paramBoolean1) {
        break label617;
      }
      this.CpZ = com.tencent.mm.plugin.voip.b.l.Vt(i);
      this.CpY.CpZ = this.CpZ;
      bool1 = com.tencent.mm.compatible.d.b.abj();
      bool2 = com.tencent.mm.compatible.d.b.abk();
      if (Build.MANUFACTURER.equalsIgnoreCase("meizu"))
      {
        if (!bool1)
        {
          localObject1 = com.tencent.mm.plugin.report.service.g.yxI;
          if (!this.Cqj) {
            break label629;
          }
          i = 0;
          ((com.tencent.mm.plugin.report.service.g)localObject1).f(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
        }
        if (!bool2)
        {
          localObject1 = com.tencent.mm.plugin.report.service.g.yxI;
          if (!this.Cqj) {
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
            AppMethodBeat.i(210061);
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "show Permission settings");
            com.tencent.mm.compatible.d.b.cb(paramContext);
            if (!VoipMgr.c(VoipMgr.this))
            {
              if (VoipMgr.g(VoipMgr.this))
              {
                VoipMgr.this.eyF();
                AppMethodBeat.o(210061);
                return;
              }
              VoipMgr.this.eyI();
              AppMethodBeat.o(210061);
              return;
            }
            if (VoipMgr.g(VoipMgr.this))
            {
              VoipMgr.this.eyK();
              AppMethodBeat.o(210061);
              return;
            }
            VoipMgr.this.eyL();
            AppMethodBeat.o(210061);
          }
        });
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "initMgr");
      com.tencent.mm.booter.a.WB().WD();
      if (!this.Cqj) {
        break label693;
      }
      com.tencent.mm.plugin.voip.c.eys().c(true, true, this.fIQ);
      label442:
      if (!this.Cqi) {
        break label726;
      }
      com.tencent.mm.plugin.voip.c.eys().Cvg.eBz();
      if (!this.Cqj) {
        break label708;
      }
      i = com.tencent.mm.plugin.voip.c.eys().aFa(this.Cqh.field_username);
      label480:
      if (i >= 0) {
        break label726;
      }
      ge(false);
      i = 0;
      if (i != 0)
      {
        this.CpY.aB(paramBoolean2, paramBoolean1);
        if (paramBoolean2)
        {
          this.Cuy = new j();
          this.Cuz = new com.tencent.mm.plugin.voip.b.a();
          i = this.CqJ;
          paramContext = this.Cuz;
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
      paramContext.W(false, i);
      this.Cuz.eCT();
      com.tencent.mm.plugin.voip.c.eys().a(paramString, this.Cqj, false, paramLong);
      AppMethodBeat.o(210067);
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
      this.CpZ = com.tencent.mm.plugin.voip.b.l.Vs(i);
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
      com.tencent.mm.plugin.voip.c.eys().c(true, false, this.fIQ);
      break label442;
      label708:
      i = com.tencent.mm.plugin.voip.c.eys().aEZ(this.Cqh.field_username);
      break label480;
      label726:
      com.tencent.mm.plugin.voip.c.eys().a(ak.getContext(), this);
      this.uVH = ((TelephonyManager)ak.getContext().getSystemService("phone"));
      this.uVH.listen(this.lnc, 32);
      paramContext = "voip_recent_contact" + com.tencent.mm.model.v.aAC();
      localObject1 = ak.getContext().getSharedPreferences("voip_plugin_prefs", 0);
      localObject2 = ((SharedPreferences)localObject1).getString(paramContext, null);
      if (localObject2 != null)
      {
        localObject2 = bu.U(((String)localObject2).split(";"));
        if (localObject2 != null)
        {
          i = ((List)localObject2).size();
          if (((List)localObject2).contains(this.fIQ))
          {
            if (i > 1)
            {
              ((List)localObject2).remove(this.fIQ);
              label872:
              ((List)localObject2).add(0, this.fIQ);
            }
            localObject2 = bu.m((List)localObject2, ";");
            ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
            label915:
            com.tencent.mm.sdk.b.a.IvT.c(this.Crl);
            com.tencent.mm.sdk.b.a.IvT.c(this.uVJ);
            this.Cqv.a(this);
            paramContext = new IntentFilter();
            paramContext.addAction("android.intent.action.SCREEN_ON");
            paramContext.addAction("android.intent.action.SCREEN_OFF");
            paramContext.addAction("android.intent.action.USER_PRESENT");
            ak.getContext().registerReceiver(this.Cri, paramContext);
            this.pEZ = new SensorController(getContext());
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "initMgr setSensorCallBack");
            this.pEZ.a(this);
            if (this.pEY == null)
            {
              this.pEY = new bl(getContext());
              paramContext = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(210062);
                  VoipMgr.a(VoipMgr.this, bu.HQ());
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "device happened shake in time,%s", new Object[] { Long.valueOf(VoipMgr.h(VoipMgr.this)) });
                  AppMethodBeat.o(210062);
                }
              };
              if (!this.pEY.aB(paramContext)) {
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
        ((List)localObject2).add(0, this.fIQ);
        localObject2 = bu.m((List)localObject2, ";");
        ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
        break label915;
      }
    }
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    AppMethodBeat.i(115016);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onVoipUIDestroy");
    if (this.Cqb == paramb)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VoipMgr", "same mVoIPUi, clear it");
      this.Cqb = null;
      this.CpY.b(null);
    }
    if (this.jzz != null) {
      this.jzz = null;
    }
    AppMethodBeat.o(115016);
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb, int paramInt)
  {
    AppMethodBeat.i(115011);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onVoipUICreated, uiType: %s, captureRender: %s, mVoicePlayDevice: %s", new Object[] { Integer.valueOf(paramInt), this.Cuq, Integer.valueOf(this.Cqn) });
    if ((1 == paramInt) && (this.Cqb != null)) {
      this.Cqb.uninit();
    }
    this.Cqb = paramb;
    this.mUIType = paramInt;
    this.CpY.b(this.Cqb);
    if ((this.Cuq == null) && (com.tencent.mm.plugin.voip.b.l.Vv(this.CpZ.mState))) {
      this.pdJ = new CaptureView(ak.getContext());
    }
    this.Cqb.iy(-1, this.CpZ.mState);
    this.Cqb.setConnectSec(this.Cqo);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "steve: voipMgr decMode:%d, beautyCmd:%d", new Object[] { Integer.valueOf(this.CqJ), Integer.valueOf(this.CqK) });
    if (this.CqJ != -1)
    {
      this.Cqb.setHWDecMode(this.CqJ);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "steve: voipMgr setHWDecMode,decMode:%d", new Object[] { Integer.valueOf(this.CqJ) });
    }
    this.Cqb.setVoipBeauty(this.CqK);
    com.tencent.mm.plugin.voip.video.b.e.eED().CHP = new VoipMgr.18(this);
    if ((this.CqV != 0) && (this.CqW != 0)) {
      iv(this.CqV, this.CqW);
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
    if (this.Cqs)
    {
      AppMethodBeat.o(115046);
      return;
    }
    if (this.Cuq == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Voip.VoipMgr", "onFrameDataReady, captureRender is null!");
      AppMethodBeat.o(115046);
      return;
    }
    int m;
    int n;
    label73:
    ByteBuffer localByteBuffer;
    int i2;
    int j;
    label103:
    int i1;
    label116:
    int k;
    int i;
    if (this.Cuq.eDU())
    {
      m = OpenGlRender.FLAG_Mirror;
      if (!this.Cuq.eDV()) {
        break label470;
      }
      n = OpenGlRender.FLAG_Angle270;
      if (this.Cqb != null)
      {
        localByteBuffer = null;
        i2 = 0;
        if ((OpenGlRender.getGLVersion() != 2) || (this.CqK == 0)) {
          break label478;
        }
        j = 1;
        if ((this.CqK & 0x8) == 0) {
          break label484;
        }
        i1 = 1;
        k = j;
        i = i2;
        if (j != 0)
        {
          if ((i1 != 0) || (this.Cqb.Vb(2) == null)) {
            break label490;
          }
          i = 1;
          this.Cuv = 0;
          k = j;
        }
        label159:
        if ((!this.Cuq.eDU()) || (k == 0)) {
          break label682;
        }
        if (i != 1) {
          break label585;
        }
        localByteBuffer = this.Cqb.Vb(2).hKa;
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
      this.Cuu = localByteBuffer;
      k = paramInt2;
      j = paramInt1;
      this.CuB = true;
      i2 = 4;
      Object localObject = null;
      i1 = k;
      k = j;
      j = i2;
      label245:
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VoipMgr", "jcchen capture data: w=" + paramInt1 + "h=" + paramInt2 + ", vw=" + k + "vh=" + i1 + ", bm=" + i + ", skip:" + this.Crg);
      i = (int)l;
      if (this.CuA != null) {
        this.CuA.post(new VoipMgr.5(this, localByteBuffer, i, j, k, i1, (byte[])localObject));
      }
      this.Cqb.a(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, m, n);
      F((byte[])localObject, paramInt1, paramInt2);
      this.Crf += 1;
      boolean bool;
      if (m == OpenGlRender.FLAG_Mirror)
      {
        bool = true;
        this.Cqy = bool;
        if (n != OpenGlRender.FLAG_Angle270) {
          break label717;
        }
        paramInt3 = 270;
        this.Cqz = paramInt3;
        this.Cqv.setPreviewSize(paramInt1, paramInt2);
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
        if ((i1 != 0) && (this.Cqb.Vb(1) != null) && (this.Cqb.Vb(1).hKa != null))
        {
          i = 2;
          this.Cuv = 0;
          k = j;
          break label159;
        }
        if ((this.Cut != null) && (this.Cuv <= 10))
        {
          i = 3;
          this.Cuv += 1;
          k = j;
          break label159;
        }
        k = 0;
        i = i2;
        break label159;
        if (i == 2)
        {
          localObject = this.Cqb.Vb(1);
          localByteBuffer = ((com.tencent.mm.plugin.voip.video.b.a)localObject).hKa;
          if (localByteBuffer == null) {
            break label730;
          }
        }
      }
      for (l = localByteBuffer.capacity();; l = paramLong)
      {
        j = ((com.tencent.mm.plugin.voip.video.b.a)localObject).width;
        k = ((com.tencent.mm.plugin.voip.video.b.a)localObject).height;
        this.Cuu = localByteBuffer;
        break;
        localByteBuffer = this.Cuu;
        if (localByteBuffer != null) {}
        for (l = localByteBuffer.capacity();; l = paramLong)
        {
          this.Cuu = localByteBuffer;
          k = paramInt2;
          j = paramInt1;
          break;
          j = paramInt3 + paramInt4;
          this.CuB = false;
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
    if ((!this.Cuw) && (this.Cqj))
    {
      ts(true);
      this.Cuw = true;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210057);
        if (VoipMgr.e(VoipMgr.this) != null) {
          VoipMgr.e(VoipMgr.this).F(paramArrayOfInt);
        }
        if (VoipMgr.q(VoipMgr.this) != null) {
          VoipMgr.q(VoipMgr.this);
        }
        AppMethodBeat.o(210057);
      }
    });
    AppMethodBeat.o(115063);
  }
  
  public final void aEW(String paramString)
  {
    AppMethodBeat.i(210073);
    if (this.Cqb != null)
    {
      this.CqG = paramString;
      this.Cqb.aFb(paramString);
    }
    AppMethodBeat.o(210073);
  }
  
  public final void ae(long paramLong, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(210072);
    Object localObject;
    label50:
    boolean bool;
    if (this.Cuy != null) {
      switch (paramInt)
      {
      default: 
        localObject = this.Cuy;
        if (1 == this.mUIType)
        {
          bool = this.CuB;
          switch (paramInt)
          {
          }
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(210072);
      return;
      if (1 == this.mUIType)
      {
        if (!com.tencent.mm.plugin.voip.c.eys().Cvu)
        {
          localObject = this.Cuy;
          if ((260 != this.CpZ.mState) && (6 != this.CpZ.mState)) {}
          for (bool = true;; bool = false)
          {
            ((j)localObject).aC(true, bool);
            com.tencent.mm.plugin.voip.c.eys().Cvu = true;
            break;
          }
        }
        localObject = this.Cuy;
        if ((260 != this.CpZ.mState) && (6 != this.CpZ.mState)) {}
        for (bool = true;; bool = false)
        {
          ((j)localObject).aD(true, bool);
          break;
        }
      }
      if (!com.tencent.mm.plugin.voip.c.eys().Cvt)
      {
        localObject = this.Cuy;
        if ((260 != this.CpZ.mState) && (6 != this.CpZ.mState)) {}
        for (bool = true;; bool = false)
        {
          ((j)localObject).aC(false, bool);
          com.tencent.mm.plugin.voip.c.eys().Cvt = true;
          break;
        }
      }
      localObject = this.Cuy;
      if ((260 != this.CpZ.mState) && (6 != this.CpZ.mState)) {}
      for (bool = true;; bool = false)
      {
        ((j)localObject).aD(false, bool);
        break;
      }
      i = 0;
      break label50;
      ((j)localObject).CDf += 1;
      if (((j)localObject).CDf == 0)
      {
        if (i != 0)
        {
          if (paramLong != -1L)
          {
            localObject = com.tencent.mm.plugin.voip.b.g.CCV;
            com.tencent.mm.plugin.voip.b.g.Cf(paramLong);
            AppMethodBeat.o(210072);
          }
        }
        else
        {
          if (paramLong != -1L)
          {
            localObject = com.tencent.mm.plugin.voip.b.g.CCV;
            com.tencent.mm.plugin.voip.b.g.Cg(paramLong);
          }
          AppMethodBeat.o(210072);
        }
      }
      else if (((j)localObject).CDf == 60) {
        ((j)localObject).CDf = -1;
      }
      AppMethodBeat.o(210072);
      return;
      ((j)localObject).CDg += 1;
      if (((j)localObject).CDg == 0)
      {
        if (i != 0)
        {
          if (paramLong > 0L)
          {
            if (bool)
            {
              localObject = com.tencent.mm.plugin.voip.b.g.CCV;
              com.tencent.mm.plugin.voip.b.g.Cm(paramLong);
              AppMethodBeat.o(210072);
              return;
            }
            localObject = com.tencent.mm.plugin.voip.b.g.CCV;
            com.tencent.mm.plugin.voip.b.g.Cj(paramLong);
            AppMethodBeat.o(210072);
          }
        }
        else
        {
          if (paramLong > 0L)
          {
            if (bool)
            {
              localObject = com.tencent.mm.plugin.voip.b.g.CCV;
              com.tencent.mm.plugin.voip.b.g.Cl(paramLong);
              AppMethodBeat.o(210072);
              return;
            }
            localObject = com.tencent.mm.plugin.voip.b.g.CCV;
            com.tencent.mm.plugin.voip.b.g.Ck(paramLong);
          }
          AppMethodBeat.o(210072);
        }
      }
      else if (((j)localObject).CDg == 30) {
        ((j)localObject).CDg = -1;
      }
      AppMethodBeat.o(210072);
      return;
      ((j)localObject).CDh += 1;
      if (((j)localObject).CDh == 0)
      {
        if (i != 0)
        {
          localObject = com.tencent.mm.plugin.voip.b.g.CCV;
          com.tencent.mm.plugin.voip.b.g.Ch(paramLong);
          AppMethodBeat.o(210072);
          return;
        }
        localObject = com.tencent.mm.plugin.voip.b.g.CCV;
        com.tencent.mm.plugin.voip.b.g.Ci(paramLong);
        AppMethodBeat.o(210072);
        return;
      }
      if (((j)localObject).CDh == 60) {
        ((j)localObject).CDh = -1;
      }
    }
  }
  
  public final void at(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(210071);
    if (this.Cuy != null)
    {
      j localj = this.Cuy;
      long l = bu.HQ();
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          localj.CDj = l;
          AppMethodBeat.o(210071);
          return;
        }
        localj.CDb = l;
        AppMethodBeat.o(210071);
        return;
      }
      if (paramBoolean2)
      {
        localj.CDk = l;
        AppMethodBeat.o(210071);
        return;
      }
      localj.CDc = l;
    }
    AppMethodBeat.o(210071);
  }
  
  public final void cbl()
  {
    AppMethodBeat.i(115061);
    if ((true == this.vZZ) || (this.Cqb == null) || (this.Cqb.eCq() == null))
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VoipMgr", "onCameraError, already show");
      AppMethodBeat.o(115061);
      return;
    }
    if (this.Cuq.cOB())
    {
      AppMethodBeat.o(115061);
      return;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("meizu")) && (!com.tencent.mm.compatible.d.b.abk()))
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VoipMgr", "onCameraError, meizu machine");
      AppMethodBeat.o(115061);
      return;
    }
    if ((com.tencent.mm.compatible.util.d.lA(28)) && (((KeyguardManager)ak.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "api level: %s, in keyguard, ignore", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(115061);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VoipMgr", "onCameraError, show dialog");
    Object localObject = com.tencent.mm.plugin.report.service.g.yxI;
    if (this.Cqj) {}
    for (int i = 0;; i = 1)
    {
      ((com.tencent.mm.plugin.report.service.g)localObject).f(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      localObject = com.tencent.mm.ui.base.h.l(this.Cqb.eCq(), 2131764896, 2131755906);
      if (localObject != null) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.Voip.VoipMgr", "new dialog failed");
      AppMethodBeat.o(115061);
      return;
    }
    ((com.tencent.mm.ui.widget.a.d)localObject).setCancelable(false);
    ((com.tencent.mm.ui.widget.a.d)localObject).setCanceledOnTouchOutside(false);
    ((com.tencent.mm.ui.widget.a.d)localObject).show();
    this.vZZ = true;
    com.tencent.mm.plugin.voip.b.i.eDw();
    AppMethodBeat.o(115061);
  }
  
  public final void dfQ()
  {
    AppMethodBeat.i(115027);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "on accept");
    eyU();
    tP(4100);
    AppMethodBeat.o(115027);
  }
  
  public final void dfW()
  {
    AppMethodBeat.i(210075);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onNetWorkChangeMobileNet");
    if (this.Cqb != null) {
      this.Cqb.eCs();
    }
    AppMethodBeat.o(210075);
  }
  
  public final void dfX()
  {
    AppMethodBeat.i(115051);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onResumeGoodNetStatus");
    if (this.Cqb != null) {
      this.Cqb.dhQ();
    }
    AppMethodBeat.o(115051);
  }
  
  public final void dtu()
  {
    AppMethodBeat.i(184052);
    if (this.Cqb != null) {
      this.Cqb.dtu();
    }
    AppMethodBeat.o(184052);
  }
  
  public final void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115036);
    if (this.Cqb != null) {
      this.Cqb.f(paramInt1, paramInt2, paramArrayOfByte);
    }
    AppMethodBeat.o(115036);
  }
  
  public final boolean eyD()
  {
    AppMethodBeat.i(115003);
    if (!this.CpZ.Vy(4103))
    {
      AppMethodBeat.o(115003);
      return false;
    }
    Uu(4103);
    com.tencent.mm.plugin.voip.c.eys().eBr();
    AppMethodBeat.o(115003);
    return true;
  }
  
  public final boolean eyE()
  {
    AppMethodBeat.i(115004);
    if (!this.CpZ.Vy(4101))
    {
      AppMethodBeat.o(115004);
      return false;
    }
    eyU();
    com.tencent.mm.plugin.voip.c.eys().UL(1);
    com.tencent.mm.plugin.voip.c.eys().av(true, this.Cqj);
    com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
    long l = com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.uXg;
    int j = com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId;
    if (this.Cqi) {}
    for (int i = 1;; i = 0)
    {
      localg.f(11046, new Object[] { Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i) });
      com.tencent.mm.plugin.report.service.g.yxI.f(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0) });
      tP(4111);
      tP(4101);
      tP(4100);
      AppMethodBeat.o(115004);
      return true;
    }
  }
  
  public final boolean eyF()
  {
    int i = 0;
    AppMethodBeat.i(115005);
    if (!this.CpZ.Vy(4099))
    {
      AppMethodBeat.o(115005);
      return false;
    }
    String str2 = this.Cqh.field_username;
    if (this.Cqj) {}
    for (String str1 = bv.JgL;; str1 = bv.JgK)
    {
      if (this.Cqi) {
        i = 1;
      }
      s.c(str2, str1, i, 6, ak.getContext().getString(2131764807));
      eyU();
      com.tencent.mm.plugin.voip.c.eys().Cvg.eBC();
      tP(4099);
      eyZ();
      AppMethodBeat.o(115005);
      return true;
    }
  }
  
  public final boolean eyG()
  {
    AppMethodBeat.i(115006);
    if (!this.CpZ.Vy(4100))
    {
      AppMethodBeat.o(115006);
      return false;
    }
    if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gak == 1) && (this.Cqj)) {
      ts(true);
    }
    if (((!this.Cuw) || (com.tencent.mm.compatible.deviceinfo.ae.geM.gak == 1) || (com.tencent.mm.compatible.deviceinfo.ae.geM.gal == 1)) && (this.Cqj)) {
      if ((this.Cuq != null) && (!this.Cuq.eDU())) {
        break label152;
      }
    }
    label152:
    for (boolean bool = true;; bool = false)
    {
      ts(bool);
      this.Cuw = true;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onAcceptVideoInvite");
      eyU();
      com.tencent.mm.plugin.voip.c.eys().av(false, this.Cqj);
      tP(4100);
      AppMethodBeat.o(115006);
      return true;
    }
  }
  
  public final void eyH()
  {
    this.Cuw = false;
  }
  
  public final boolean eyI()
  {
    int i = 0;
    AppMethodBeat.i(115007);
    if (!this.CpZ.Vy(4099))
    {
      AppMethodBeat.o(115007);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onRejectVoiceInvite");
    String str2 = this.Cqh.field_username;
    if (this.Cqj) {}
    for (String str1 = bv.JgL;; str1 = bv.JgK)
    {
      if (this.Cqi) {
        i = 1;
      }
      s.c(str2, str1, i, 6, ak.getContext().getString(2131764807));
      eyU();
      com.tencent.mm.plugin.voip.c.eys().Cvg.eBC();
      tP(4099);
      eyZ();
      AppMethodBeat.o(115007);
      return true;
    }
  }
  
  public final boolean eyJ()
  {
    AppMethodBeat.i(115008);
    if (!this.CpZ.Vy(4100))
    {
      AppMethodBeat.o(115008);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onAcceptVoiceInvite");
    eyU();
    com.tencent.mm.plugin.voip.c.eys().av(true, this.Cqj);
    tP(4111);
    tP(4100);
    AppMethodBeat.o(115008);
    return true;
  }
  
  public final boolean eyK()
  {
    AppMethodBeat.i(115009);
    if (!this.CpZ.Vy(4098))
    {
      AppMethodBeat.o(115009);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onCancelVideoInvite");
    Uu(4098);
    com.tencent.mm.plugin.voip.c.eys().eBr();
    AppMethodBeat.o(115009);
    return true;
  }
  
  public final boolean eyL()
  {
    AppMethodBeat.i(115010);
    if (!this.CpZ.Vy(4098))
    {
      AppMethodBeat.o(115010);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onCancelVoiceInvite");
    Uu(4098);
    com.tencent.mm.plugin.voip.c.eys().eBr();
    AppMethodBeat.o(115010);
    return true;
  }
  
  public final void eyM()
  {
    AppMethodBeat.i(115012);
    if ((this.Cqj) && (this.Cqb != null))
    {
      this.Cqb.setCaptureView(this.pdJ);
      if ((com.tencent.mm.compatible.deviceinfo.ae.geM.gak == 0) || (this.Cqi)) {
        if ((this.Cuq != null) && (!this.Cuq.eDU())) {
          break label145;
        }
      }
    }
    label145:
    for (boolean bool = true;; bool = false)
    {
      ts(bool);
      if ((this.Cqi) && (com.tencent.mm.plugin.voip.b.l.Vw(this.CpZ.mState)) && (com.tencent.mm.plugin.voip.c.eys().Cvg.cbt()))
      {
        this.CpY.aB(this.Cqj, this.Cqi);
        this.CpY.b("voip", Integer.valueOf(this.Cqn));
      }
      AppMethodBeat.o(115012);
      return;
    }
  }
  
  public final void eyN()
  {
    AppMethodBeat.i(115014);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "it is init voip report");
    this.Cux = new NetChangedBroadcastReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    ak.getContext().registerReceiver(this.Cux, localIntentFilter);
    this.peP = ((TelephonyManager)ak.getContext().getSystemService("phone"));
    this.CqX = f.getNetType(getContext());
    this.Cra = new VoipMgr.19(this);
    this.peP.listen(this.Cra, 256);
    AppMethodBeat.o(115014);
  }
  
  public final void eyP()
  {
    AppMethodBeat.i(115017);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onSwitchCamera");
    if (this.Cuq != null) {
      this.Cuq.eDQ();
    }
    com.tencent.mm.plugin.report.service.g.yxI.f(11079, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(115017);
  }
  
  public final void eyQ()
  {
    AppMethodBeat.i(115018);
    if (true != this.Cuq.eDU()) {
      eyP();
    }
    AppMethodBeat.o(115018);
  }
  
  public final void eyR() {}
  
  public final void eyS() {}
  
  public final void eyT() {}
  
  public final void eyU()
  {
    AppMethodBeat.i(210069);
    if (this.CpY != null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "use audioManager to stop voip ring");
      this.CpY.eyU();
      AppMethodBeat.o(210069);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "use Subcore to stop voip ring");
    com.tencent.mm.plugin.voip.c.eys().Cvg.stopRing();
    AppMethodBeat.o(210069);
  }
  
  public final void eyV()
  {
    AppMethodBeat.i(210070);
    this.Cqb.eyV();
    AppMethodBeat.o(210070);
  }
  
  public final boolean eyW()
  {
    AppMethodBeat.i(115020);
    if (com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId == 0)
    {
      this.Cqm = true;
      AppMethodBeat.o(115020);
      return true;
    }
    boolean bool = eyX();
    AppMethodBeat.o(115020);
    return bool;
  }
  
  public final void eyY()
  {
    AppMethodBeat.i(115022);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onRoomReady");
    if ((this.Cqm) && (com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId != 0))
    {
      this.Cqm = false;
      eyX();
    }
    if (this.Cqi) {
      tP(4097);
    }
    AppMethodBeat.o(115022);
  }
  
  public final boolean eyl()
  {
    return this.Cqj;
  }
  
  public final boolean eym()
  {
    return this.Cqi;
  }
  
  public final String eyn()
  {
    return this.CqG;
  }
  
  public final long eyo()
  {
    return this.CqP;
  }
  
  public final long eyp()
  {
    return this.CqQ;
  }
  
  public final int eyq()
  {
    return this.CqR;
  }
  
  public final void ezb()
  {
    AppMethodBeat.i(115031);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onNoResp");
    tP(4105);
    String str2 = this.Cqh.field_username;
    String str1;
    if (this.Cqj)
    {
      str1 = bv.JgL;
      if (!this.Cqi) {
        break label181;
      }
    }
    label181:
    for (int i = 1;; i = 0)
    {
      s.c(str2, str1, i, 4, ak.getContext().getString(2131764810));
      com.tencent.mm.plugin.report.service.g.yxI.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.uXg), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.ezE()), Integer.valueOf(6), Integer.valueOf(az.getNetWorkType(getContext())) });
      eyZ();
      AppMethodBeat.o(115031);
      return;
      str1 = bv.JgK;
      break;
    }
  }
  
  public final void ezc()
  {
    int j = 0;
    AppMethodBeat.i(115033);
    com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
    int k = com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId;
    long l1 = com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.uXg;
    long l2 = com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.ezE();
    if (this.Cqi)
    {
      i = 0;
      localg.a(11522, true, true, new Object[] { Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(1) });
      k = com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId;
      l1 = com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.uXg;
      if (!this.Cqi) {
        break label205;
      }
    }
    label205:
    for (int i = j;; i = 1)
    {
      f.c(k, l1, i, 3);
      if (this.Crb != null) {
        this.Crb.post(new Runnable()
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
  
  public final void ezd()
  {
    int j = 0;
    AppMethodBeat.i(115034);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onShutDown");
    String str1;
    String str2;
    label99:
    label108:
    int k;
    label156:
    long l;
    if (com.tencent.mm.plugin.voip.b.l.Vu(this.CpZ.mState))
    {
      str1 = ak.getContext().getString(2131764803, new Object[] { sz(bu.rZ(this.Cqo)) });
      if ((this.Cqi) || (com.tencent.mm.plugin.voip.b.l.Vu(this.CpZ.mState)))
      {
        String str3 = this.Cqh.field_username;
        if (!this.Cqj) {
          break label245;
        }
        str2 = bv.JgL;
        if (!this.Cqi) {
          break label253;
        }
        i = 1;
        s.c(str3, str2, i, 6, str1);
      }
      com.tencent.mm.plugin.voip.b.c.tG(this.Cqj);
      this.Cqf = com.tencent.mm.plugin.voip.b.l.Vu(this.CpZ.mState);
      if (!ezh()) {
        break label258;
      }
      this.Cql = 4106;
      com.tencent.mm.plugin.voip.c.eys().eBr();
      if (!this.CqT)
      {
        k = com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId;
        l = com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.uXg;
        if (!this.Cqi) {
          break label272;
        }
      }
    }
    label258:
    label272:
    for (int i = j;; i = 1)
    {
      f.c(k, l, i, 4);
      this.CqT = true;
      AppMethodBeat.o(115034);
      return;
      str1 = ak.getContext().getString(2131764799);
      break;
      label245:
      str2 = bv.JgK;
      break label99;
      label253:
      i = 0;
      break label108;
      tP(4106);
      eyZ();
      break label156;
    }
  }
  
  public final void eze()
  {
    AppMethodBeat.i(115042);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VoipMgr", "onPretreatmentForStartDev");
    this.CpY.aA(this.CqF, this.Cqj);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      ar.f(new Runnable()
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
    eAu();
    AppMethodBeat.o(115042);
  }
  
  public final long ezf()
  {
    AppMethodBeat.i(115044);
    com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.Voip.VoipMgr", "totalDeviceNearTime: %s", new Object[] { Long.valueOf(this.CqN) });
    long l = this.CqN / 1000L;
    AppMethodBeat.o(115044);
    return l;
  }
  
  public final void ezj()
  {
    AppMethodBeat.i(115058);
    if ((256 != this.CpZ.mState) && (257 != this.CpZ.mState))
    {
      AppMethodBeat.o(115058);
      return;
    }
    if ((com.tencent.mm.kernel.g.ajR().ajA().getInt(327945, 0) == 0) && (this.Cqb.eCq() != null))
    {
      com.tencent.mm.kernel.g.ajR().ajA().setInt(327945, 1);
      com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.a(this.Cqb.eCq(), 2131764868, 2131755906, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(210052);
          VoipMgr.this.ezl();
          AppMethodBeat.o(210052);
        }
      });
      locald.setCancelable(false);
      locald.setCanceledOnTouchOutside(false);
      locald.show();
      AppMethodBeat.o(115058);
      return;
    }
    n.gL(ak.getContext());
    ezl();
    AppMethodBeat.o(115058);
  }
  
  public final void ezk()
  {
    AppMethodBeat.i(115059);
    if (!this.Cqx) {}
    for (boolean bool = true;; bool = false)
    {
      this.Cqx = bool;
      if (!this.Cqx) {
        break;
      }
      this.Cqw.stopTimer();
      AppMethodBeat.o(115059);
      return;
    }
    if (this.Cqw == null) {
      this.Cqw = new com.tencent.mm.sdk.platformtools.aw("faceDetect", new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(210056);
          VoipMgr.L(VoipMgr.this);
          AppMethodBeat.o(210056);
          return true;
        }
      }, true);
    }
    this.Cqw.ay(2000L, 2000L);
    this.Cqx = false;
    AppMethodBeat.o(115059);
  }
  
  public final void ezl()
  {
    AppMethodBeat.i(115060);
    com.tencent.mm.plugin.voip.c.eys().Cvn = com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId;
    String str2 = this.Cqh.field_username;
    String str1;
    if (this.Cqj)
    {
      str1 = bv.JgL;
      if (!this.Cqi) {
        break label124;
      }
    }
    label124:
    for (int i = 1;; i = 0)
    {
      s.c(str2, str1, i, 6, ak.getContext().getString(2131764806));
      eyU();
      tP(4108);
      if (this.jzz != null) {
        this.jzz.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(210053);
            VoipMgr.K(VoipMgr.this);
            AppMethodBeat.o(210053);
          }
        }, 2000L);
      }
      AppMethodBeat.o(115060);
      return;
      str1 = bv.JgK;
      break;
    }
  }
  
  public final int getState()
  {
    return this.CpZ.mState;
  }
  
  public final String getUserName()
  {
    return this.fIQ;
  }
  
  public final void iv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115039);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "adjustHWViewAspectRatio, HWDecsize:%dx%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.CqV = paramInt1;
    this.CqW = paramInt2;
    if (this.Cqb != null) {
      this.Cqb.iv(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115039);
  }
  
  public final void km(boolean paramBoolean)
  {
    AppMethodBeat.i(114995);
    com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.Voip.VoipMgr", "onSensorEvent, isON: %s, lastIsDeviceNear: %s, deviceSwitchNearScreenTick: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.CqM), Long.valueOf(this.CqL) });
    if (this.CpZ == null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, not create stateMachine yet, ignore");
      AppMethodBeat.o(114995);
      return;
    }
    if (this.pEX)
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.pEX = paramBoolean;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onSensorEvent has skip and val is %s", new Object[] { Boolean.valueOf(this.pEX) });
        AppMethodBeat.o(114995);
        return;
      }
    }
    if ((Math.abs(bu.HQ() - this.CqO) < 500L) && (this.CqO != -1L))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onSensorEvent time interval too small");
      AppMethodBeat.o(114995);
      return;
    }
    if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qMR, true)) && (!paramBoolean) && (this.lastShakeTime != -1L) && (bu.aO(this.lastShakeTime) > 400L))
    {
      this.pEX = true;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onSensorEvent has skip case shake near to small");
      AppMethodBeat.o(114995);
      return;
    }
    this.pEX = false;
    if ((com.tencent.mm.plugin.voip.b.l.Vu(this.CpZ.mState)) && ((this.CqM != paramBoolean) || (this.CqL == -1L)))
    {
      if ((!this.CqM) && (paramBoolean) && (!com.tencent.mm.plugin.voip.b.l.Vv(this.CpZ.mState)) && (this.mUIType != 2) && (this.CqL != -1L))
      {
        long l = bu.aO(this.CqL);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "accumulate near screen time: %s", new Object[] { Long.valueOf(l) });
        this.CqN += l;
      }
      this.CqL = bu.HQ();
      this.CqM = paramBoolean;
    }
    if (this.Cqb == null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, voipUI is null, ignore");
      AppMethodBeat.o(114995);
      return;
    }
    if (((this.Cqi) || (com.tencent.mm.plugin.voip.b.l.Vu(this.CpZ.mState))) && (!com.tencent.mm.plugin.voip.b.l.Vv(this.CpZ.mState)) && (this.mUIType != 2))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, isOn: ".concat(String.valueOf(paramBoolean)));
      this.Cqb.setScreenEnable(paramBoolean);
      this.Cqd = paramBoolean;
      this.CqO = bu.HQ();
    }
    AppMethodBeat.o(114995);
  }
  
  public final void nC(boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(115050);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onBadNetStatus");
    if (this.Cqb != null) {
      this.Cqb.ty(paramBoolean);
    }
    long l;
    if ((!com.tencent.mm.plugin.voip.b.l.Vv(this.CpZ.mState)) && (!this.CpY.isSpeakerphoneOn()))
    {
      l = System.currentTimeMillis();
      if (l - this.uXT > 30000L)
      {
        this.uXT = l;
        com.tencent.mm.plugin.voip.c.eys().Cvg.eBG();
      }
    }
    Object localObject = new StringBuilder("report the bad net toast room key is ").append(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.uXg).append("and in the side");
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", i);
      localObject = com.tencent.mm.plugin.report.service.g.yxI;
      l = com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.uXg;
      i = j;
      if (paramBoolean) {
        i = 1;
      }
      ((com.tencent.mm.plugin.report.service.g)localObject).a(17151, true, true, new Object[] { Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(115050);
      return;
    }
  }
  
  public final void nO(int paramInt) {}
  
  public final void oN(boolean paramBoolean)
  {
    AppMethodBeat.i(115002);
    this.CpY.tF(paramBoolean);
    AppMethodBeat.o(115002);
  }
  
  public final void onConnected()
  {
    AppMethodBeat.i(115032);
    tP(4102);
    this.Cqo = bu.aRi();
    if (this.Cqb != null) {
      this.Cqb.setConnectSec(this.Cqo);
    }
    boolean bool1 = com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.ezG();
    boolean bool2 = com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.ezF();
    if ((this.Cqj) && (this.Cqi) && (!bool2) && (!bool1)) {
      com.tencent.mm.plugin.voip.c.eys().UL(1);
    }
    if (!com.tencent.mm.plugin.voip.b.l.Vv(this.CpZ.mState)) {
      com.tencent.mm.plugin.report.service.g.yxI.f(11080, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
    }
    bu.F(ak.getContext(), true);
    com.tencent.mm.plugin.voip.c.eys().UW(com.tencent.mm.plugin.voip.c.eys().eBq());
    r.eAx().eAy();
    r.eAx().a(this);
    k localk = k.CrE;
    k.setRoomId(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId);
    AppMethodBeat.o(115032);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(115026);
    com.tencent.mm.plugin.voip.b.c.tG(this.Cqj);
    String str1 = paramString;
    if (paramInt == 241)
    {
      str1 = paramString;
      if (bu.isNullOrNil(paramString)) {
        str1 = getContext().getString(2131764903);
      }
    }
    if (this.Cqb != null) {
      this.Cqb.co(paramInt, str1);
    }
    tP(4109);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onError, errCode: %s, roomId: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId) });
    paramString = ak.getContext();
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.Voip.VoipMgr", "getErrorMsgContent, errorCode".concat(String.valueOf(paramInt)));
    if (paramInt == 235)
    {
      paramString = paramString.getString(2131764809);
      if ((com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId == 0) || (com.tencent.mm.plugin.voip.c.eys().Cvm.get(Integer.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId)) != null)) {
        break label427;
      }
      str2 = this.Cqh.field_username;
      if (!this.Cqj) {
        break label414;
      }
      str1 = bv.JgL;
      if (!this.Cqi) {
        break label422;
      }
      paramInt = 1;
      if (com.tencent.mm.plugin.voip.b.l.Vu(this.CpZ.mState)) {
        paramString = ak.getContext().getString(2131764804, new Object[] { sz(bu.rZ(this.Cqo)) });
      }
      l = s.a(str2, str1, paramInt, 6, paramString, true);
      com.tencent.mm.plugin.voip.c.eys().Cvm.put(Integer.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId), Long.valueOf(l));
    }
    label414:
    label422:
    label427:
    while (com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId != 0) {
      for (;;)
      {
        long l;
        com.tencent.mm.plugin.voip.c.eys().eBr();
        eyZ();
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
        str1 = bv.JgK;
        continue;
        paramInt = 0;
      }
    }
    String str2 = this.Cqh.field_username;
    if (this.Cqj)
    {
      str1 = bv.JgL;
      label466:
      if (!this.Cqi) {
        break label539;
      }
    }
    label539:
    for (paramInt = 1;; paramInt = 0)
    {
      if (com.tencent.mm.plugin.voip.b.l.Vu(this.CpZ.mState)) {
        paramString = ak.getContext().getString(2131764804, new Object[] { sz(bu.rZ(this.Cqo)) });
      }
      s.a(str2, str1, paramInt, 6, paramString, true);
      break;
      str1 = bv.JgK;
      break label466;
    }
  }
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(115064);
    if (this.Cqb != null) {
      this.Cqb.requestRender();
    }
    AppMethodBeat.o(115064);
  }
  
  public final void onReject()
  {
    AppMethodBeat.i(115028);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onReject");
    tP(4099);
    String str2 = this.Cqh.field_username;
    String str1;
    if (this.Cqj)
    {
      str1 = bv.JgL;
      if (!this.Cqi) {
        break label86;
      }
    }
    label86:
    for (int i = 1;; i = 0)
    {
      s.c(str2, str1, i, 6, ak.getContext().getString(2131764811));
      eyZ();
      AppMethodBeat.o(115028);
      return;
      str1 = bv.JgK;
      break;
    }
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115038);
    this.CqJ = paramInt;
    if (this.Cqb != null) {
      this.Cqb.setHWDecMode(paramInt);
    }
    if (this.Cuy != null)
    {
      Object localObject;
      if (this.Cuz != null)
      {
        localObject = this.Cuz;
        if ((paramInt & 0x1) == 0) {
          break label96;
        }
      }
      label96:
      for (int i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.voip.b.a)localObject).W(false, i);
        this.Cuz.eCT();
        localObject = this.Cuy;
        if ((paramInt & 0x1) == 0) {
          break;
        }
        ((j)localObject).CCX += 1L;
        AppMethodBeat.o(115038);
        return;
      }
      ((j)localObject).CCY += 1L;
    }
    AppMethodBeat.o(115038);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    this.Cqn = paramInt;
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115037);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "setVoipBeauty, isON: " + paramInt + "，mVoipUI: " + this.Cqb);
    if (this.Cqb != null) {
      this.Cqb.setVoipBeauty(paramInt);
    }
    if ((paramInt != 0) && (this.CqK != paramInt)) {
      com.tencent.mm.plugin.report.service.g.yxI.n(914L, 20L, 1L);
    }
    this.Crg = 2;
    this.CqK = paramInt;
    AppMethodBeat.o(115037);
  }
  
  public final void th(boolean paramBoolean)
  {
    AppMethodBeat.i(210068);
    if ((this.CpZ != null) && (this.CpZ.mState >= 0) && (this.CpZ.mState <= 8)) {}
    for (int i = 1; i == 0; i = 0)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "steve:[simucall] same state, no need to reset, return!");
      AppMethodBeat.o(210068);
      return;
    }
    int j = com.tencent.mm.plugin.voip.b.l.aE(false, paramBoolean);
    i = j;
    if (this.Cqk)
    {
      if (j != 0) {
        break label136;
      }
      i = 1;
    }
    for (;;)
    {
      this.CpZ = com.tencent.mm.plugin.voip.b.l.Vs(i);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "steve:[simucall] resetStateMachine, initState:%d,isOutCall:%s,isVideoCall:%s", new Object[] { Integer.valueOf(i), Boolean.FALSE, Boolean.valueOf(paramBoolean) });
      this.Cqi = false;
      AppMethodBeat.o(210068);
      return;
      label136:
      i = j;
      if (256 == j) {
        i = 257;
      }
    }
  }
  
  public final void tk(boolean paramBoolean)
  {
    AppMethodBeat.i(115001);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.CpY.cn(paramBoolean);
    this.CpY.CCF = true;
    AppMethodBeat.o(115001);
  }
  
  public final void tl(boolean paramBoolean) {}
  
  public final boolean tm(final boolean paramBoolean)
  {
    AppMethodBeat.i(115057);
    if (com.tencent.mm.plugin.voip.c.eys().Cvv)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "current state is mini, cannot mini!");
      AppMethodBeat.o(115057);
      return false;
    }
    if ((this.CqE) && (!paramBoolean))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "has phone call  cannot mini!");
      AppMethodBeat.o(115057);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ae.l("MicroMsg.Voip.VoipMgr", "miniOnlyHidenVoip: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "onMinimizeVoip, async to minimize");
    if (this.Cqb != null)
    {
      this.Cqb.uninit();
      this.Cqb = null;
      this.CpY.b(this.Cqb);
    }
    if (this.Cus != null) {
      this.Cus.uninit();
    }
    if (this.jzz != null) {
      this.jzz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(210051);
          VoipMgr.d(VoipMgr.this, paramBoolean);
          AppMethodBeat.o(210051);
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
              j = VoipMgr.aOz()[1];
              if (VoipMgr.k(VoipMgr.this) == 0) {
                VoipMgr.a(VoipMgr.this, 4);
              }
            } while (VoipMgr.k(VoipMgr.this) == 0);
            k = VoipMgr.dvC() / VoipMgr.k(VoipMgr.this);
            VoipMgr.a(VoipMgr.this, 5);
            m = VoipMgr.aOz()[0];
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "befor change to 4G and cost " + VoipMgr.l(VoipMgr.this));
            if (VoipMgr.c(VoipMgr.this)) {}
            for (;;)
            {
              f.a(i, System.currentTimeMillis(), VoipMgr.j(VoipMgr.this), 5, j, m, k);
              VoipMgr.m(VoipMgr.this);
              VoipMgr.b(VoipMgr.this, 5);
              VoipMgr.dvE();
              VoipMgr.n(VoipMgr.this);
              AppMethodBeat.o(114993);
              return;
              i = 1;
            }
          } while (VoipMgr.j(VoipMgr.this) == 4);
          k = VoipMgr.aOz()[0];
          if (VoipMgr.k(VoipMgr.this) == 0) {
            VoipMgr.a(VoipMgr.this, 5);
          }
        } while (VoipMgr.k(VoipMgr.this) == 0);
        int m = VoipMgr.dvC() / VoipMgr.k(VoipMgr.this);
        VoipMgr.a(VoipMgr.this, 4);
        int n = VoipMgr.aOz()[1];
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.Voip.VoipMgr", "befor change to wifi and cost " + VoipMgr.l(VoipMgr.this));
        if (VoipMgr.c(VoipMgr.this)) {}
        for (i = j;; i = 1)
        {
          f.a(i, System.currentTimeMillis(), VoipMgr.j(VoipMgr.this), 4, k, n, m);
          VoipMgr.m(VoipMgr.this);
          VoipMgr.b(VoipMgr.this, 4);
          VoipMgr.dvE();
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