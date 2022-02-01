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
import android.view.SurfaceHolder;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.g.a.yg;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.a.zj.a;
import com.tencent.mm.model.at;
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
import com.tencent.mm.sdk.platformtools.ae;
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
import d.g.b.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class NewVoipMgr
  extends com.tencent.mm.plugin.voip.a
  implements com.tencent.mm.plugin.voip.video.render.b
{
  static int[] Crc = new int[2];
  static int lAL = 0;
  private com.tencent.mm.plugin.voip.b.c CpY;
  private com.tencent.mm.plugin.voip.b.m CpZ;
  private boolean CqA;
  private int CqB;
  private boolean CqC;
  private com.tencent.mm.plugin.voip.widget.b CqD;
  private boolean CqE;
  private boolean CqF;
  private String CqG;
  private boolean CqH;
  private boolean CqI;
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
  NetChangedBroadcastReceiver CqZ;
  private j Cqa;
  private volatile com.tencent.mm.plugin.voip.ui.b Cqb;
  private a Cqc;
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
  private boolean Cqp;
  private boolean Cqq;
  private boolean Cqr;
  private boolean Cqs;
  private int Cqt;
  private int Cqu;
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
  private com.tencent.mm.plugin.voip.b.i Crh;
  private BroadcastReceiver Cri;
  private BroadcastReceiver Crj;
  int Crk;
  private com.tencent.mm.sdk.b.c Crl;
  private long enterTime;
  private String fIQ;
  private long hLA;
  private aq jzz;
  private long lastShakeTime;
  PhoneStateListener lnc;
  private boolean mIsMute;
  private int mUIType;
  private boolean pEX;
  private bl pEY;
  private SensorController pEZ;
  TelephonyManager peP;
  private long twc;
  private TelephonyManager uVH;
  private com.tencent.mm.sdk.b.c uVJ;
  private long uXT;
  private boolean vZZ;
  
  public NewVoipMgr()
  {
    AppMethodBeat.i(209952);
    this.Cqc = null;
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
    this.mIsMute = false;
    this.Cqo = -1L;
    this.Cqp = false;
    this.Cqq = false;
    this.Cqr = false;
    this.vZZ = false;
    this.Cqs = false;
    this.Cqt = 0;
    this.Cqu = 0;
    this.Cqv = new com.tencent.mm.plugin.voip.video.k();
    this.Cqw = null;
    this.Cqx = false;
    this.Cqy = false;
    this.Cqz = 0;
    this.CqA = false;
    this.CqB = -1;
    this.CqC = false;
    this.CqE = false;
    this.CqF = false;
    this.CqG = null;
    this.CqH = true;
    this.CqI = false;
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
    this.Cri = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(209922);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        paramAnonymousIntent = (PowerManager)ak.getContext().getSystemService("power");
        if (("android.intent.action.USER_PRESENT".equals(paramAnonymousContext)) && (paramAnonymousIntent.isScreenOn()))
        {
          if (NewVoipMgr.a(NewVoipMgr.this) != null)
          {
            NewVoipMgr.a(NewVoipMgr.this).Cqs = false;
            AppMethodBeat.o(209922);
          }
        }
        else
        {
          if ("android.intent.action.SCREEN_ON".equals(paramAnonymousContext))
          {
            if (NewVoipMgr.a(NewVoipMgr.this) != null) {
              NewVoipMgr.a(NewVoipMgr.this).Cqs = false;
            }
            NewVoipMgr.this.km(true);
            AppMethodBeat.o(209922);
            return;
          }
          if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousContext))
          {
            if (NewVoipMgr.a(NewVoipMgr.this) != null) {
              NewVoipMgr.a(NewVoipMgr.this).Cqs = true;
            }
            if (!NewVoipMgr.b(NewVoipMgr.this)) {
              NewVoipMgr.this.km(true);
            }
            if ((!com.tencent.mm.plugin.voip.b.l.Vu(NewVoipMgr.c(NewVoipMgr.this).mState)) && (!NewVoipMgr.d(NewVoipMgr.this))) {
              com.tencent.mm.plugin.voip.c.eys().Cvg.stopRing();
            }
          }
        }
        AppMethodBeat.o(209922);
      }
    };
    this.Crj = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(209938);
        if ((paramAnonymousIntent.getAction().equals("com.tencent.mm.foregroundDestroy")) && (com.tencent.mm.plugin.voip.c.eys().dgR) && (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qDN, false))) {
          com.tencent.mm.plugin.voip.c.eys().a(NewVoipMgr.e(NewVoipMgr.this), NewVoipMgr.f(NewVoipMgr.this), true, com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.uXg);
        }
        AppMethodBeat.o(209938);
      }
    };
    this.uVJ = new com.tencent.mm.sdk.b.c() {};
    this.Crk = 0;
    this.uXT = 0L;
    this.lnc = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        int i = 1;
        AppMethodBeat.i(209928);
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        ae.i("MicroMsg.Voip.NewVoipMgr", "onCallStateChanged :%d, isStartVoip: %b,oldState:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(NewVoipMgr.t(NewVoipMgr.this)), Integer.valueOf(NewVoipMgr.u(NewVoipMgr.this)) });
        if (!NewVoipMgr.t(NewVoipMgr.this))
        {
          AppMethodBeat.o(209928);
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
          com.tencent.mm.plugin.voip.c.eys().UN(1);
          NewVoipMgr.b(NewVoipMgr.this, true);
        }
        label327:
        label361:
        do
        {
          NewVoipMgr.n(NewVoipMgr.this).Cre = NewVoipMgr.C(NewVoipMgr.this);
          AppMethodBeat.o(209928);
          return;
          if (paramAnonymousInt == 2)
          {
            NewVoipMgr.a(NewVoipMgr.this, false);
            if (NewVoipMgr.u(NewVoipMgr.this) == 1) {
              NewVoipMgr.e(NewVoipMgr.this, System.currentTimeMillis());
            }
            NewVoipMgr.c(NewVoipMgr.this, 2);
            ae.i("MicroMsg.Voip.NewVoipMgr", "phone call coming now!");
            if ((NewVoipMgr.d(NewVoipMgr.this)) && (!com.tencent.mm.plugin.voip.b.l.Vu(NewVoipMgr.c(NewVoipMgr.this).mState))) {
              com.tencent.mm.plugin.voip.c.eys().Cvg.eBB();
            }
            String str2;
            String str1;
            if (com.tencent.mm.plugin.voip.b.l.Vu(NewVoipMgr.c(NewVoipMgr.this).mState))
            {
              paramAnonymousString = ak.getContext().getString(2131764803, new Object[] { NewVoipMgr.BT(bu.rZ(NewVoipMgr.w(NewVoipMgr.this))) });
              com.tencent.mm.plugin.voip.c.eys().eBb();
              str2 = NewVoipMgr.x(NewVoipMgr.this).field_username;
              if (!NewVoipMgr.f(NewVoipMgr.this)) {
                break label596;
              }
              str1 = bv.JgL;
              if (!NewVoipMgr.d(NewVoipMgr.this)) {
                break label604;
              }
            }
            for (paramAnonymousInt = i;; paramAnonymousInt = 0)
            {
              s.c(str2, str1, paramAnonymousInt, 6, paramAnonymousString);
              NewVoipMgr.d(NewVoipMgr.this, 4107);
              NewVoipMgr.y(NewVoipMgr.this);
              paramAnonymousString = new bv();
              paramAnonymousString.setType(10000);
              paramAnonymousString.qN(System.currentTimeMillis());
              paramAnonymousString.setStatus(6);
              paramAnonymousString.setContent(ak.getContext().getString(2131764801) + ", <a href=\"weixin://voip/callagain/?username=" + NewVoipMgr.e(NewVoipMgr.this) + "&isvideocall=" + NewVoipMgr.f(NewVoipMgr.this) + "\">" + ak.getContext().getString(2131764796) + "</a>");
              if ((NewVoipMgr.e(NewVoipMgr.this) != null) && (!NewVoipMgr.e(NewVoipMgr.this).equals("")))
              {
                paramAnonymousString.ui(NewVoipMgr.e(NewVoipMgr.this));
                ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ar(paramAnonymousString);
              }
              com.tencent.mm.plugin.voip.c.eys().UN(2);
              NewVoipMgr.b(NewVoipMgr.this, false);
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
        if ((NewVoipMgr.u(NewVoipMgr.this) == 1) || (NewVoipMgr.u(NewVoipMgr.this) == 2)) {
          NewVoipMgr.e(NewVoipMgr.this, System.currentTimeMillis());
        }
        NewVoipMgr.c(NewVoipMgr.this, 0);
        com.tencent.mm.plugin.voip.c.eys().UN(2);
        if ((1 == NewVoipMgr.z(NewVoipMgr.this)) && (com.tencent.mm.plugin.voip.b.l.Vu(NewVoipMgr.c(NewVoipMgr.this).mState)) && (NewVoipMgr.A(NewVoipMgr.this))) {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(209924);
              NewVoipMgr.n(NewVoipMgr.this).cn(true);
              AppMethodBeat.o(209924);
            }
          });
        }
        if ((4 == NewVoipMgr.z(NewVoipMgr.this)) && (NewVoipMgr.A(NewVoipMgr.this))) {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(209925);
              NewVoipMgr.n(NewVoipMgr.this).aA(NewVoipMgr.B(NewVoipMgr.this), NewVoipMgr.f(NewVoipMgr.this));
              AppMethodBeat.o(209925);
            }
          });
        }
        NewVoipMgr.a(NewVoipMgr.this, false);
        if ((com.tencent.mm.compatible.b.g.ZS() != null) && (com.tencent.mm.plugin.audio.c.a.bHy().isBluetoothScoOn()))
        {
          ae.i("MicroMsg.Voip.NewVoipMgr", "is bluetooth can use and start bluetooth");
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(209926);
              NewVoipMgr.n(NewVoipMgr.this).aA(NewVoipMgr.B(NewVoipMgr.this), NewVoipMgr.f(NewVoipMgr.this));
              AppMethodBeat.o(209926);
            }
          });
        }
        for (;;)
        {
          NewVoipMgr.b(NewVoipMgr.this, false);
          break;
          if (com.tencent.mm.plugin.audio.c.a.bHy().bHt()) {
            ar.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(209927);
                NewVoipMgr.n(NewVoipMgr.this).aA(NewVoipMgr.B(NewVoipMgr.this), NewVoipMgr.f(NewVoipMgr.this));
                AppMethodBeat.o(209927);
              }
            });
          }
        }
      }
    };
    this.hLA = -1L;
    this.enterTime = -1L;
    this.Crl = new com.tencent.mm.sdk.b.c() {};
    this.CpY = new com.tencent.mm.plugin.voip.b.c();
    AppMethodBeat.o(209952);
  }
  
  private void Uu(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(209976);
    ae.i("MicroMsg.Voip.NewVoipMgr", "hangupTalkingOrCancelInvite");
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
        ae.i("MicroMsg.Voip.NewVoipMgr", "hangupVoipButton OnClick call cancelCall");
        com.tencent.mm.plugin.voip.c.eys().Cvg.eBA();
      }
      ae.i("MicroMsg.Voip.NewVoipMgr", "hangupVoipButton OnClick call hangUp");
      com.tencent.mm.plugin.voip.c.eys().Cvg.eBD();
      if (4096 != this.Cql) {
        break label315;
      }
      tP(paramInt);
      eyZ();
      AppMethodBeat.o(209976);
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
        AppMethodBeat.i(209947);
        NewVoipMgr.n(NewVoipMgr.this);
        com.tencent.mm.plugin.voip.b.c.tG(NewVoipMgr.f(NewVoipMgr.this));
        AppMethodBeat.o(209947);
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
    AppMethodBeat.o(209976);
  }
  
  private boolean Uv(int paramInt)
  {
    AppMethodBeat.i(209994);
    if (4111 == paramInt)
    {
      AppMethodBeat.o(209994);
      return true;
    }
    if ((4101 == paramInt) && ((com.tencent.mm.plugin.voip.b.l.Vu(this.CpZ.mState)) || (this.Cqi)))
    {
      AppMethodBeat.o(209994);
      return true;
    }
    AppMethodBeat.o(209994);
    return false;
  }
  
  private static void Uw(int paramInt)
  {
    AppMethodBeat.i(209995);
    zj localzj = new zj();
    localzj.dPA.dlO = paramInt;
    com.tencent.mm.sdk.b.a.IvT.l(localzj);
    AppMethodBeat.o(209995);
  }
  
  private boolean d(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(210022);
    String str = com.tencent.mm.n.g.acL().getValue("VOIPShortcutAutoadd");
    ae.i("MicroMsg.Voip.NewVoipMgr", "voip shortcut autoAdd is %s", new Object[] { str });
    if ((str != null) && (str.equals("0")) && (bu.rZ(this.Cqo) > 30L))
    {
      int i = paramSharedPreferences.getInt("voip_shortcut_prompt_times", 0);
      boolean bool = paramSharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
      if ((i < 3) && (!bool))
      {
        ezi();
        paramSharedPreferences.edit().putInt("voip_shortcut_prompt_times", i + 1).commit();
        AppMethodBeat.o(210022);
        return true;
      }
    }
    else if ((str != null) && (str.equals("1")) && (bu.rZ(this.Cqo) > 15L))
    {
      e(paramSharedPreferences);
      AppMethodBeat.o(210022);
      return false;
    }
    AppMethodBeat.o(210022);
    return false;
  }
  
  private void e(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(210023);
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
      AppMethodBeat.o(210023);
      return;
      localIntent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(2131755764));
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getContext(), 2131234599));
      localIntent1.putExtra("shortcut_icon_resource_id", 2131234599);
    }
  }
  
  private boolean eyX()
  {
    int j = 0;
    AppMethodBeat.i(209990);
    if (!this.CpZ.Vy(4101))
    {
      AppMethodBeat.o(209990);
      return false;
    }
    this.Cqj = false;
    if (this.CqD != null) {
      this.CqD.Cqj = false;
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
        AppMethodBeat.o(209990);
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
    AppMethodBeat.i(210000);
    ae.d("MicroMsg.Voip.NewVoipMgr", "delayFinish");
    this.CqG = null;
    if (this.jzz != null) {
      this.jzz.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(209949);
          NewVoipMgr localNewVoipMgr = NewVoipMgr.this;
          ae.i("MicroMsg.Voip.NewVoipMgr", "it is uninit voip report");
          if (localNewVoipMgr.Crb != null)
          {
            localNewVoipMgr.Crb.removeCallbacksAndMessages(null);
            localNewVoipMgr.Crb.quit();
          }
          if (!localNewVoipMgr.CqY)
          {
            if (localNewVoipMgr.Crk == 0) {
              localNewVoipMgr.Ut(localNewVoipMgr.CqX);
            }
            if (localNewVoipMgr.Crk != 0)
            {
              localNewVoipMgr.CqY = true;
              if (!localNewVoipMgr.Cqi) {
                break label183;
              }
            }
          }
          label183:
          for (int i = 0;; i = 1)
          {
            com.tencent.mm.plugin.voip.b.f.a(i, System.currentTimeMillis(), localNewVoipMgr.CqX, localNewVoipMgr.CqX, 0, 0, NewVoipMgr.lAL / localNewVoipMgr.Crk);
            NewVoipMgr.lAL = 0;
            NewVoipMgr.Crc[0] = 0;
            NewVoipMgr.Crc[1] = 0;
            localNewVoipMgr.Crk = 0;
            if (localNewVoipMgr.peP != null) {
              localNewVoipMgr.peP.listen(localNewVoipMgr.Cra, 0);
            }
            if (localNewVoipMgr.CqZ != null)
            {
              ak.getContext().unregisterReceiver(localNewVoipMgr.CqZ);
              localNewVoipMgr.CqZ = null;
            }
            NewVoipMgr.p(NewVoipMgr.this);
            AppMethodBeat.o(209949);
            return;
          }
        }
      }, 500L);
    }
    AppMethodBeat.o(210000);
  }
  
  private static void eza()
  {
    AppMethodBeat.i(210002);
    yh localyh = new yh();
    localyh.dNE.dto = 11;
    com.tencent.mm.sdk.b.a.IvT.l(localyh);
    AppMethodBeat.o(210002);
  }
  
  private void ezg()
  {
    AppMethodBeat.i(210017);
    synchronized (this.Cqg)
    {
      ezm();
      if (this.Cqa != null) {
        this.Cqa.release();
      }
      com.tencent.mm.plugin.voip.b.c.unInit();
      this.CpY.ezg();
      AppMethodBeat.o(210017);
      return;
    }
  }
  
  private boolean ezh()
  {
    AppMethodBeat.i(210021);
    if (com.tencent.mm.plugin.voip.b.l.Vu(this.CpZ.mState))
    {
      SharedPreferences localSharedPreferences = getContext().getSharedPreferences("voip_plugin_prefs", 0);
      if (!localSharedPreferences.getBoolean("voip_shortcut_has_added", false))
      {
        boolean bool = d(localSharedPreferences);
        AppMethodBeat.o(210021);
        return bool;
      }
    }
    AppMethodBeat.o(210021);
    return false;
  }
  
  private void ezi()
  {
    AppMethodBeat.i(210025);
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
          AppMethodBeat.i(209930);
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
                AppMethodBeat.i(209929);
                NewVoipMgr.p(NewVoipMgr.this);
                AppMethodBeat.o(209929);
              }
            });
          }
          AppMethodBeat.o(209930);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(209932);
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
                AppMethodBeat.i(209931);
                NewVoipMgr.p(NewVoipMgr.this);
                AppMethodBeat.o(209931);
              }
            });
          }
          AppMethodBeat.o(209932);
        }
      });
      AppMethodBeat.o(210025);
      return;
      localTextView.setText(2131764787);
    }
  }
  
  private void ezm()
  {
    AppMethodBeat.i(210030);
    if (this.Cqv != null) {
      this.Cqv.b(this);
    }
    if (this.Cqw != null)
    {
      ae.d("MicroMsg.Voip.NewVoipMgr", "stop face detect timer");
      this.Cqw.stopTimer();
    }
    AppMethodBeat.o(210030);
  }
  
  private void ge(boolean paramBoolean)
  {
    AppMethodBeat.i(210001);
    ae.i("MicroMsg.Voip.NewVoipMgr", "finish");
    if (this.Crh != null) {
      this.Crh.eDv();
    }
    this.CqC = false;
    this.CqE = false;
    this.lastShakeTime = -1L;
    if (this.Cqt != -1)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(11700, new Object[] { Integer.valueOf(this.Cqt), Long.valueOf(bu.rZ(this.Cqo)) });
      this.Cqt = -1;
    }
    try
    {
      ak.getContext().unregisterReceiver(this.Cri);
      try
      {
        label105:
        ak.getContext().unregisterReceiver(this.Crj);
        label115:
        com.tencent.mm.sdk.b.a.IvT.d(this.uVJ);
        com.tencent.mm.sdk.b.a.IvT.d(this.Crl);
        ezm();
        if (this.Cqa != null)
        {
          this.Cqa.release();
          this.Cqa = null;
        }
        if (this.Cqb != null)
        {
          this.Cqb.uninit();
          this.Cqb = null;
          this.CpY.b(this.Cqb);
        }
        label237:
        int j;
        label302:
        long l;
        if (com.tencent.mm.plugin.voip.c.eys() != null)
        {
          com.tencent.mm.plugin.voip.c.eys().Cvg.stopRing();
          if (paramBoolean)
          {
            com.tencent.mm.plugin.voip.c.eys().eBc();
            if (!this.Cqj) {
              break label749;
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
            break label764;
          }
          this.Cqc = new a();
          com.tencent.e.h.MqF.aO(this.Cqc);
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
            ae.d("MicroMsg.Voip.NewVoipMgr", "removeSensorCallBack");
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
          ae.i("MicroMsg.Voip.NewVoipMgr", "finish, isFinishFromShutdown: %s", new Object[] { Boolean.valueOf(this.Cqf) });
          if ((this.Cqf) && (com.tencent.mm.plugin.voip.c.eys().eBs()))
          {
            com.tencent.mm.plugin.voip.c.eys();
            VoipScoreState.eAZ();
            Object localObject = new Intent(getContext(), VoipScoreDialog.class);
            ((Intent)localObject).putExtra("key_score_state", com.tencent.mm.plugin.voip.c.eys().eBu());
            if (!(getContext() instanceof Activity)) {
              ((Intent)localObject).addFlags(268435456);
            }
            Context localContext = getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          com.tencent.mm.plugin.voip.c.eys().eBt();
          eza();
          if (!this.CqT)
          {
            j = com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId;
            l = com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.uXg;
            if (!this.Cqi) {
              break label771;
            }
          }
        }
        label771:
        for (int i = 0;; i = 1)
        {
          com.tencent.mm.plugin.voip.b.f.c(j, l, i, 4);
          this.CqT = true;
          ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
          com.tencent.mm.media.g.c.hnb.atY();
          AppMethodBeat.o(210001);
          return;
          com.tencent.mm.plugin.voip.c.eys().Cvg.eBD();
          break;
          label749:
          com.tencent.mm.plugin.voip.c.eys().c(false, false, this.fIQ);
          break label237;
          label764:
          ezg();
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
  
  private Context getContext()
  {
    AppMethodBeat.i(210024);
    Context localContext1 = null;
    if (this.Cqb != null) {
      localContext1 = this.Cqb.eCq();
    }
    Context localContext2 = localContext1;
    if (localContext1 == null) {
      localContext2 = ak.getContext();
    }
    AppMethodBeat.o(210024);
    return localContext2;
  }
  
  private static String sz(long paramLong)
  {
    AppMethodBeat.i(210016);
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
    AppMethodBeat.o(210016);
    return str;
  }
  
  private void tP(final int paramInt)
  {
    AppMethodBeat.i(209993);
    ae.l("MicroMsg.Voip.NewVoipMgr", "swtchState, action: %s, currentState: %s", new Object[] { com.tencent.mm.plugin.voip.b.l.Vr(paramInt), com.tencent.mm.plugin.voip.b.l.Vr(this.CpZ.mState) });
    if ((4101 == paramInt) && (com.tencent.mm.plugin.voip.b.l.Vv(this.CpZ.mState)))
    {
      ezm();
      if (this.Cqa != null) {
        this.Cqa.release();
      }
      this.Cqj = false;
      if (this.CqD != null) {
        this.CqD.Cqj = false;
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
          AppMethodBeat.i(209948);
          if (NewVoipMgr.o(NewVoipMgr.this) != null) {
            NewVoipMgr.o(NewVoipMgr.this).iy(paramInt, NewVoipMgr.c(NewVoipMgr.this).mState);
          }
          AppMethodBeat.o(209948);
        }
      });
    }
    switch (this.CpZ.mState)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(209993);
      return;
      Uw(5);
      AppMethodBeat.o(209993);
      return;
      Uw(6);
    }
  }
  
  final void Ut(int paramInt)
  {
    AppMethodBeat.i(209968);
    if (paramInt == 5)
    {
      lAL += Crc[0];
      this.Crk += 1;
      ae.i("MicroMsg.Voip.NewVoipMgr", "mSignalStrength 4G" + Crc[0] + " and index is " + this.Crk);
      AppMethodBeat.o(209968);
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
        ae.i("MicroMsg.Voip.NewVoipMgr", "error happened in get wifi info");
        continue;
      }
      lAL += Crc[1];
      this.Crk += 1;
      ae.i("MicroMsg.Voip.NewVoipMgr", "mSignalStrength WIFI " + Crc[1] + " and index is " + this.Crk);
      AppMethodBeat.o(209968);
      return;
      paramInt = localWifiManager.getConnectionInfo().getRssi();
    }
  }
  
  public final void Ux(int paramInt)
  {
    AppMethodBeat.i(210007);
    ae.i("MicroMsg.Voip.NewVoipMgr", "remote voip mode changed, cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    if (((1 == paramInt) || (3 == paramInt) || (5 == paramInt) || (6 == paramInt) || (7 == paramInt)) && (this.Cqj))
    {
      tP(4101);
      com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.ezL();
      com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.ezM();
    }
    AppMethodBeat.o(210007);
  }
  
  public final void Uy(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(210012);
    ae.i("MicroMsg.Voip.NewVoipMgr", "onSessionBeingCalled, callType: ".concat(String.valueOf(paramInt)));
    if (!this.CpZ.Vy(4110))
    {
      AppMethodBeat.o(210012);
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
      AppMethodBeat.o(210012);
      return;
    }
  }
  
  public final void Uz(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(210013);
    ae.i("MicroMsg.Voip.NewVoipMgr", "steve:[simucall]onNewSimulCallAutoAccept, callType: ".concat(String.valueOf(paramInt)));
    if (!this.CpZ.Vy(4100))
    {
      AppMethodBeat.o(210013);
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
      AppMethodBeat.o(210013);
      return;
    }
  }
  
  public final void a(final Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(209953);
    ae.i("MicroMsg.Voip.NewVoipMgr", "start VoIP, userName: %s, isOutCall: %b, isVideoCall: %b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
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
          break label535;
        }
        i = 1;
        com.tencent.mm.plugin.voip.c.eys().UL(1);
      }
      if (!paramBoolean1) {
        break label555;
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
            break label567;
          }
          i = 0;
          label264:
          ((com.tencent.mm.plugin.report.service.g)localObject1).f(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
        }
        if (!bool2)
        {
          localObject1 = com.tencent.mm.plugin.report.service.g.yxI;
          if (!this.Cqj) {
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
            AppMethodBeat.i(209944);
            ae.i("MicroMsg.Voip.NewVoipMgr", "show Permission settings");
            com.tencent.mm.compatible.d.b.cb(paramContext);
            if (!NewVoipMgr.d(NewVoipMgr.this))
            {
              if (NewVoipMgr.f(NewVoipMgr.this))
              {
                NewVoipMgr.this.eyF();
                AppMethodBeat.o(209944);
                return;
              }
              NewVoipMgr.this.eyI();
              AppMethodBeat.o(209944);
              return;
            }
            if (NewVoipMgr.f(NewVoipMgr.this))
            {
              NewVoipMgr.this.eyK();
              AppMethodBeat.o(209944);
              return;
            }
            NewVoipMgr.this.eyL();
            AppMethodBeat.o(209944);
          }
        });
      }
      ae.i("MicroMsg.Voip.NewVoipMgr", "initMgr");
      com.tencent.mm.booter.a.WB().WD();
      if (!this.Cqj) {
        break label631;
      }
      com.tencent.mm.plugin.voip.c.eys().c(true, true, this.fIQ);
      label442:
      if (!this.Cqi) {
        break label664;
      }
      com.tencent.mm.plugin.voip.c.eys().Cvg.eBz();
      if (!this.Cqj) {
        break label646;
      }
    }
    label646:
    for (int i = com.tencent.mm.plugin.voip.c.eys().aFa(this.Cqh.field_username);; i = com.tencent.mm.plugin.voip.c.eys().aEZ(this.Cqh.field_username))
    {
      if (i >= 0) {
        break label664;
      }
      ge(false);
      i = 0;
      if (i != 0)
      {
        this.CpY.aB(paramBoolean2, paramBoolean1);
        com.tencent.mm.plugin.voip.c.eys().a(paramString, this.Cqj, false, paramLong);
      }
      AppMethodBeat.o(209953);
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
      this.CpZ = com.tencent.mm.plugin.voip.b.l.Vs(i);
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
      com.tencent.mm.plugin.voip.c.eys().c(true, false, this.fIQ);
      break label442;
    }
    label664:
    com.tencent.mm.plugin.voip.c.eys().a(ak.getContext(), this);
    this.uVH = ((TelephonyManager)ak.getContext().getSystemService("phone"));
    this.uVH.listen(this.lnc, 32);
    paramContext = "voip_recent_contact" + com.tencent.mm.model.v.aAC();
    Object localObject1 = ak.getContext().getSharedPreferences("voip_plugin_prefs", 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString(paramContext, null);
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
            label810:
            ((List)localObject2).add(0, this.fIQ);
          }
          localObject2 = bu.m((List)localObject2, ";");
          ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
          label853:
          com.tencent.mm.sdk.b.a.IvT.c(this.Crl);
          com.tencent.mm.sdk.b.a.IvT.c(this.uVJ);
          this.Cqv.a(this);
          paramContext = new IntentFilter();
          paramContext.addAction("android.intent.action.SCREEN_ON");
          paramContext.addAction("android.intent.action.SCREEN_OFF");
          paramContext.addAction("android.intent.action.USER_PRESENT");
          ak.getContext().registerReceiver(this.Cri, paramContext);
          this.pEZ = new SensorController(getContext());
          ae.i("MicroMsg.Voip.NewVoipMgr", "initMgr setSensorCallBack");
          this.pEZ.a(this);
          if (this.pEY == null)
          {
            this.pEY = new bl(getContext());
            paramContext = new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(209945);
                NewVoipMgr.a(NewVoipMgr.this, bu.HQ());
                AppMethodBeat.o(209945);
              }
            };
            if (!this.pEY.aB(paramContext)) {
              break label1119;
            }
          }
        }
      }
    }
    label1119:
    for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
    {
      if (this.Cqj)
      {
        this.Cqa = new j(this, this.Cqi);
        this.Crh = new com.tencent.mm.plugin.voip.b.i();
      }
      i = 1;
      break;
      if (4 != i) {
        break label810;
      }
      ((List)localObject2).remove(i - 1);
      break label810;
      localObject2 = new ArrayList();
      ((List)localObject2).add(0, this.fIQ);
      localObject2 = bu.m((List)localObject2, ";");
      ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
      break label853;
    }
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    AppMethodBeat.i(209973);
    ae.i("MicroMsg.Voip.NewVoipMgr", "onVoipUIDestroy");
    if (this.Cqb == paramb)
    {
      ae.d("MicroMsg.Voip.NewVoipMgr", "same VoipUI, clear it");
      this.Cqb = null;
      this.CpY.b(null);
    }
    if (this.jzz != null) {
      this.jzz = null;
    }
    AppMethodBeat.o(209973);
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb, int paramInt)
  {
    AppMethodBeat.i(209966);
    ae.i("MicroMsg.Voip.NewVoipMgr", "onVoipUICreated, uiType: %s,  mVoicePlayDevice: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.Cqn) });
    if ((1 == paramInt) && (this.Cqb != null)) {
      this.Cqb.uninit();
    }
    this.Cqb = paramb;
    this.mUIType = paramInt;
    this.CpY.b(this.Cqb);
    this.Cqb.iy(-1, this.CpZ.mState);
    this.Cqb.setConnectSec(this.Cqo);
    this.Cqb.Ve(this.CqK);
    AppMethodBeat.o(209966);
  }
  
  public final void a(VoIPRenderSurfaceView paramVoIPRenderSurfaceView)
  {
    AppMethodBeat.i(209980);
    if (this.Cqa != null)
    {
      j localj = this.Cqa;
      if (paramVoIPRenderSurfaceView != null) {
        paramVoIPRenderSurfaceView.eEV();
      }
      localj.CJY = false;
      localj.CJS = false;
    }
    AppMethodBeat.o(209980);
  }
  
  public final void a(VoIPRenderSurfaceView paramVoIPRenderSurfaceView, int paramInt)
  {
    AppMethodBeat.i(209979);
    if (this.Cqa != null)
    {
      com.tencent.mm.plugin.voip.b.i.Vo(0);
      Object localObject1 = this.Cqa;
      p.h(paramVoIPRenderSurfaceView, "view");
      if (!((j)localObject1).CJY)
      {
        ((j)localObject1).CJY = true;
        Object localObject2 = ((j)localObject1).CJT;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.e)localObject2).K((d.g.a.a)new j.f((j)localObject1));
        }
        localObject2 = ((j)localObject1).CJU;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.c)localObject2).CIY = ((d.g.a.a)new j.g((j)localObject1));
        }
      }
      localObject1 = (j.b)new j.h((j)localObject1);
      p.h(localObject1, "listener");
      paramVoIPRenderSurfaceView.CKt = ((j.b)localObject1);
      paramVoIPRenderSurfaceView.CKu = paramInt;
      paramVoIPRenderSurfaceView.getHolder().addCallback(paramVoIPRenderSurfaceView.CKs);
    }
    AppMethodBeat.o(209979);
  }
  
  public final void a(VoIPRenderTextureView paramVoIPRenderTextureView)
  {
    AppMethodBeat.i(209981);
    if (this.Cqa != null)
    {
      j localj = this.Cqa;
      if (paramVoIPRenderTextureView != null)
      {
        paramVoIPRenderTextureView.setSurfaceTextureListener(null);
        j.b localb = paramVoIPRenderTextureView.CKt;
        if (localb != null) {
          localb.VF(paramVoIPRenderTextureView.CKu);
        }
        paramVoIPRenderTextureView.CKt = null;
      }
      localj.CJY = false;
      localj.CJS = false;
    }
    AppMethodBeat.o(209981);
  }
  
  public final void a(VoIPRenderTextureView paramVoIPRenderTextureView, int paramInt)
  {
    AppMethodBeat.i(209977);
    if (this.Cqa != null)
    {
      com.tencent.mm.plugin.voip.b.i.Vo(1);
      Object localObject1 = this.Cqa;
      p.h(paramVoIPRenderTextureView, "view");
      if (!((j)localObject1).CJY)
      {
        ((j)localObject1).CJY = true;
        Object localObject2 = ((j)localObject1).CJT;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.e)localObject2).K((d.g.a.a)new j.c((j)localObject1));
        }
        localObject2 = ((j)localObject1).CJU;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.c)localObject2).CIY = ((d.g.a.a)new j.d((j)localObject1));
        }
      }
      localObject1 = (j.b)new j.e((j)localObject1);
      p.h(localObject1, "listener");
      paramVoIPRenderTextureView.CKt = ((j.b)localObject1);
      paramVoIPRenderTextureView.CKu = paramInt;
      paramVoIPRenderTextureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new VoIPRenderTextureView.b(paramVoIPRenderTextureView));
    }
    AppMethodBeat.o(209977);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void a(final int[] paramArrayOfInt, final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(210031);
    if ((this.Cqa != null) && (!this.Cqa.Cuw))
    {
      this.Cqa.eET();
      this.Cqa.Cuw = true;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(209937);
        if (NewVoipMgr.a(NewVoipMgr.this) != null)
        {
          com.tencent.mm.plugin.voip.video.h localh = NewVoipMgr.a(NewVoipMgr.this).CJQ;
          if (localh != null) {
            localh.eEd();
          }
        }
        if (NewVoipMgr.o(NewVoipMgr.this) != null) {
          NewVoipMgr.o(NewVoipMgr.this);
        }
        AppMethodBeat.o(209937);
      }
    });
    AppMethodBeat.o(210031);
  }
  
  public final void aEW(String paramString)
  {
    AppMethodBeat.i(209996);
    if (this.Cqb != null)
    {
      this.CqG = paramString;
      this.Cqb.aFb(paramString);
    }
    AppMethodBeat.o(209996);
  }
  
  public final void ad(long paramLong, int paramInt)
  {
    int k = 1;
    AppMethodBeat.i(209972);
    Object localObject1;
    int i;
    label60:
    Object localObject2;
    int j;
    if (this.Crh != null) {
      switch (paramInt)
      {
      default: 
        if (this.Cqa != null)
        {
          localObject1 = this.Crh;
          if (1 != this.mUIType) {
            break label367;
          }
          i = 1;
          localObject2 = this.Cqa.CJT;
          j = k;
          if (localObject2 != null)
          {
            if (((com.tencent.mm.plugin.voip.video.render.e)localObject2).eEM() == 0) {
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
      AppMethodBeat.o(209972);
      return;
      if (1 == this.mUIType)
      {
        if (!com.tencent.mm.plugin.voip.c.eys().Cvu)
        {
          localObject1 = this.Crh;
          if ((260 != this.CpZ.mState) && (6 != this.CpZ.mState)) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.plugin.voip.b.i)localObject1).aC(true, bool);
            com.tencent.mm.plugin.voip.c.eys().Cvu = true;
            break;
          }
        }
        localObject1 = this.Crh;
        if ((260 != this.CpZ.mState) && (6 != this.CpZ.mState)) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.voip.b.i)localObject1).aD(true, bool);
          break;
        }
      }
      if (!com.tencent.mm.plugin.voip.c.eys().Cvt)
      {
        localObject1 = this.Crh;
        if ((260 != this.CpZ.mState) && (6 != this.CpZ.mState)) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.voip.b.i)localObject1).aC(false, bool);
          com.tencent.mm.plugin.voip.c.eys().Cvt = true;
          break;
        }
      }
      localObject1 = this.Crh;
      if ((260 != this.CpZ.mState) && (6 != this.CpZ.mState)) {}
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.voip.b.i)localObject1).aD(false, bool);
        break;
      }
      label367:
      i = 0;
      break label60;
      label373:
      j = 0;
      break label90;
      ((com.tencent.mm.plugin.voip.b.i)localObject1).CDf += 1;
      if (((com.tencent.mm.plugin.voip.b.i)localObject1).CDf == 0)
      {
        if (i != 0)
        {
          if (paramLong > 0L)
          {
            localObject1 = com.tencent.mm.plugin.voip.b.k.CDm;
            com.tencent.mm.plugin.voip.b.k.Cf(paramLong);
            AppMethodBeat.o(209972);
          }
        }
        else
        {
          if (paramLong > 0L)
          {
            localObject1 = com.tencent.mm.plugin.voip.b.k.CDm;
            com.tencent.mm.plugin.voip.b.k.Cg(paramLong);
          }
          AppMethodBeat.o(209972);
        }
      }
      else if (((com.tencent.mm.plugin.voip.b.i)localObject1).CDf == 60) {
        ((com.tencent.mm.plugin.voip.b.i)localObject1).CDf = -1;
      }
      AppMethodBeat.o(209972);
      return;
      ((com.tencent.mm.plugin.voip.b.i)localObject1).CDg += 1;
      if (((com.tencent.mm.plugin.voip.b.i)localObject1).CDg == 0)
      {
        if (i != 0)
        {
          if (j != 0)
          {
            localObject1 = com.tencent.mm.plugin.voip.b.k.CDm;
            com.tencent.mm.plugin.voip.b.k.Cx(paramLong);
            AppMethodBeat.o(209972);
            return;
          }
          localObject1 = com.tencent.mm.plugin.voip.b.k.CDm;
          com.tencent.mm.plugin.voip.b.k.Cv(paramLong);
          AppMethodBeat.o(209972);
          return;
        }
        if (j != 0)
        {
          localObject1 = com.tencent.mm.plugin.voip.b.k.CDm;
          com.tencent.mm.plugin.voip.b.k.Cy(paramLong);
          AppMethodBeat.o(209972);
          return;
        }
        localObject1 = com.tencent.mm.plugin.voip.b.k.CDm;
        com.tencent.mm.plugin.voip.b.k.Cw(paramLong);
        AppMethodBeat.o(209972);
        return;
      }
      if (((com.tencent.mm.plugin.voip.b.i)localObject1).CDg == 60) {
        ((com.tencent.mm.plugin.voip.b.i)localObject1).CDg = -1;
      }
      AppMethodBeat.o(209972);
      return;
      ((com.tencent.mm.plugin.voip.b.i)localObject1).CDh += 1;
      if (((com.tencent.mm.plugin.voip.b.i)localObject1).CDh == 0)
      {
        if (i != 0)
        {
          localObject2 = com.tencent.mm.plugin.voip.b.k.CDm;
          com.tencent.mm.plugin.voip.b.k.Ch(paramLong);
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.voip.b.i)localObject1).CDf = 0;
          AppMethodBeat.o(209972);
          return;
          localObject2 = com.tencent.mm.plugin.voip.b.k.CDm;
          com.tencent.mm.plugin.voip.b.k.Ci(paramLong);
        }
      }
      if (((com.tencent.mm.plugin.voip.b.i)localObject1).CDh == 60) {
        ((com.tencent.mm.plugin.voip.b.i)localObject1).CDh = -1;
      }
    }
  }
  
  public final void ae(long paramLong, int paramInt) {}
  
  public final void at(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(209978);
    if (this.Crh != null)
    {
      com.tencent.mm.plugin.voip.b.i locali = this.Crh;
      long l = bu.HQ();
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          locali.CDd = l;
          AppMethodBeat.o(209978);
          return;
        }
        locali.CDb = l;
        AppMethodBeat.o(209978);
        return;
      }
      if (paramBoolean2)
      {
        locali.CDe = l;
        AppMethodBeat.o(209978);
        return;
      }
      locali.CDc = l;
    }
    AppMethodBeat.o(209978);
  }
  
  public final void aw(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(209970);
    if (this.Cqb != null) {
      this.Cqb.Vc(paramInt1);
    }
    if (this.Cqv != null) {
      this.Cqv.setPreviewSize(paramInt2, paramInt3);
    }
    AppMethodBeat.o(209970);
  }
  
  public final void cbl() {}
  
  public final void dfQ()
  {
    AppMethodBeat.i(209998);
    ae.i("MicroMsg.Voip.NewVoipMgr", "on accept");
    eyU();
    tP(4100);
    AppMethodBeat.o(209998);
  }
  
  public final void dfW()
  {
    AppMethodBeat.i(210019);
    ae.i("MicroMsg.Voip.NewVoipMgr", "onNetWorkChangeMobileNet");
    if (this.Cqb != null) {
      this.Cqb.eCs();
    }
    AppMethodBeat.o(210019);
  }
  
  public final void dfX()
  {
    AppMethodBeat.i(210020);
    ae.i("MicroMsg.Voip.NewVoipMgr", "onResumeGoodNetStatus");
    if (this.Cqb != null) {
      this.Cqb.dhQ();
    }
    AppMethodBeat.o(210020);
  }
  
  public final void dtu()
  {
    AppMethodBeat.i(209991);
    if (this.Cqb != null) {
      this.Cqb.dtu();
    }
    AppMethodBeat.o(209991);
  }
  
  public final void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(210008);
    if (this.Cqa != null)
    {
      Object localObject1 = this.Cqa;
      p.h(paramArrayOfByte, "outData");
      localObject1 = ((j)localObject1).CJU;
      if (localObject1 != null)
      {
        int i = OpenGlRender.FLAG_YV12Edge;
        int j = OpenGlRender.FLAG_Angle90;
        p.h(paramArrayOfByte, "pBuff");
        if (((com.tencent.mm.plugin.voip.video.render.c)localObject1).CGt != null)
        {
          Object localObject2 = ((com.tencent.mm.plugin.voip.video.render.c)localObject1).CJf;
          if (localObject2 != null)
          {
            p.h(paramArrayOfByte, "pBuff");
            localObject2 = ((com.tencent.mm.plugin.voip.video.render.l)localObject2).CKK;
            p.h(paramArrayOfByte, "pBuff");
            localObject2 = ((com.tencent.mm.plugin.voip.video.c.f)localObject2).CID;
            if (localObject2 != null)
            {
              p.h(paramArrayOfByte, "pBuff");
              if (((com.tencent.mm.plugin.voip.video.c.i)localObject2).CFa == null)
              {
                ((com.tencent.mm.plugin.voip.video.c.i)localObject2).mWidth = paramInt1;
                ((com.tencent.mm.plugin.voip.video.c.i)localObject2).mHeight = paramInt2;
                ((com.tencent.mm.plugin.voip.video.c.i)localObject2).wSY = (i + j);
                ((com.tencent.mm.plugin.voip.video.c.i)localObject2).CFa = paramArrayOfByte;
              }
            }
          }
          paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.render.c)localObject1).CGt;
          if (paramArrayOfByte == null) {
            p.gkB();
          }
          ((com.tencent.mm.plugin.voip.video.render.m)localObject1).b(paramArrayOfByte);
        }
      }
      if (this.Cqb != null) {
        this.Cqb.eCr();
      }
    }
    AppMethodBeat.o(210008);
  }
  
  public final boolean eyD()
  {
    AppMethodBeat.i(209958);
    if (!this.CpZ.Vy(4103))
    {
      AppMethodBeat.o(209958);
      return false;
    }
    Uu(4103);
    com.tencent.mm.plugin.voip.c.eys().eBr();
    AppMethodBeat.o(209958);
    return true;
  }
  
  public final boolean eyE()
  {
    AppMethodBeat.i(209959);
    if (!this.CpZ.Vy(4101))
    {
      AppMethodBeat.o(209959);
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
      AppMethodBeat.o(209959);
      return true;
    }
  }
  
  public final boolean eyF()
  {
    int i = 0;
    AppMethodBeat.i(209960);
    if (!this.CpZ.Vy(4099))
    {
      AppMethodBeat.o(209960);
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
      AppMethodBeat.o(209960);
      return true;
    }
  }
  
  public final boolean eyG()
  {
    AppMethodBeat.i(209961);
    if (!this.CpZ.Vy(4100))
    {
      AppMethodBeat.o(209961);
      return false;
    }
    if (this.Cqa != null) {
      this.Cqa.eET();
    }
    ae.i("MicroMsg.Voip.NewVoipMgr", "onAcceptVideoInvite");
    eyU();
    com.tencent.mm.plugin.voip.c.eys().av(false, this.Cqj);
    tP(4100);
    AppMethodBeat.o(209961);
    return true;
  }
  
  public final void eyH()
  {
    if (this.Cqa != null) {
      this.Cqa.Cuw = false;
    }
  }
  
  public final boolean eyI()
  {
    int i = 0;
    AppMethodBeat.i(209962);
    if (!this.CpZ.Vy(4099))
    {
      AppMethodBeat.o(209962);
      return false;
    }
    ae.i("MicroMsg.Voip.NewVoipMgr", "onRejectVoiceInvite");
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
      AppMethodBeat.o(209962);
      return true;
    }
  }
  
  public final boolean eyJ()
  {
    AppMethodBeat.i(209963);
    if (!this.CpZ.Vy(4100))
    {
      AppMethodBeat.o(209963);
      return false;
    }
    ae.i("MicroMsg.Voip.NewVoipMgr", "onAcceptVoiceInvite");
    eyU();
    com.tencent.mm.plugin.voip.c.eys().av(true, this.Cqj);
    tP(4111);
    tP(4100);
    AppMethodBeat.o(209963);
    return true;
  }
  
  public final boolean eyK()
  {
    AppMethodBeat.i(209964);
    if (!this.CpZ.Vy(4098))
    {
      AppMethodBeat.o(209964);
      return false;
    }
    ae.i("MicroMsg.Voip.NewVoipMgr", "onCancelVideoInvite");
    Uu(4098);
    com.tencent.mm.plugin.voip.c.eys().eBr();
    AppMethodBeat.o(209964);
    return true;
  }
  
  public final boolean eyL()
  {
    AppMethodBeat.i(209965);
    if (!this.CpZ.Vy(4098))
    {
      AppMethodBeat.o(209965);
      return false;
    }
    ae.i("MicroMsg.Voip.NewVoipMgr", "onCancelVoiceInvite");
    Uu(4098);
    com.tencent.mm.plugin.voip.c.eys().eBr();
    AppMethodBeat.o(209965);
    return true;
  }
  
  public final void eyM()
  {
    boolean bool2 = true;
    AppMethodBeat.i(209967);
    if ((this.Cqj) && (this.Cqa != null))
    {
      j localj = this.Cqa;
      Object localObject1 = localj.CJQ;
      if ((localObject1 != null) && (localj.CJT != null))
      {
        Object localObject2 = localj.CJT;
        if (localObject2 == null) {
          p.gkB();
        }
        if (((com.tencent.mm.plugin.voip.video.render.e)localObject2).CJq != null)
        {
          ((com.tencent.mm.plugin.voip.video.h)localObject1).CDL = false;
          localObject1 = localj.CJT;
          if (localObject1 == null) {
            p.gkB();
          }
          localObject1 = ((com.tencent.mm.plugin.voip.video.render.e)localObject1).CJq;
          if (localObject1 == null) {
            p.gkB();
          }
          localObject2 = localj.CJQ;
          if (localObject2 == null) {
            break label195;
          }
          bool1 = ((com.tencent.mm.plugin.voip.video.h)localObject2).eDU();
          localj.d((com.tencent.mm.plugin.voip.video.render.g)localObject1, bool1);
        }
      }
    }
    if ((this.Cqi) && (com.tencent.mm.plugin.voip.b.l.Vw(this.CpZ.mState)) && (com.tencent.mm.plugin.voip.c.eys().Cvg.cbt()))
    {
      this.CpY.aB(this.Cqj, this.Cqi);
      if (this.Cqn != 1) {
        break label200;
      }
    }
    label195:
    label200:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      tk(bool1);
      AppMethodBeat.o(209967);
      return;
      bool1 = true;
      break;
    }
  }
  
  public final void eyN()
  {
    AppMethodBeat.i(209969);
    ae.i("MicroMsg.Voip.NewVoipMgr", "it is init voip report");
    this.CqZ = new NetChangedBroadcastReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    ak.getContext().registerReceiver(this.CqZ, localIntentFilter);
    this.peP = ((TelephonyManager)ak.getContext().getSystemService("phone"));
    this.CqX = com.tencent.mm.plugin.voip.b.f.getNetType(getContext());
    this.Cra = new NewVoipMgr.16(this);
    this.peP.listen(this.Cra, 256);
    AppMethodBeat.o(209969);
  }
  
  public final void eyO()
  {
    AppMethodBeat.i(209971);
    if ((this.vZZ) || (this.Cqb == null) || (this.Cqb.eCq() == null) || (this.Cqa == null) || (this.Cqa.CJQ == null))
    {
      ae.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, already show");
      AppMethodBeat.o(209971);
      return;
    }
    if (this.Cqa.CJQ.cOB())
    {
      AppMethodBeat.o(209971);
      return;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("meizu")) && (!com.tencent.mm.compatible.d.b.abk()))
    {
      ae.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, meizu machine");
      AppMethodBeat.o(209971);
      return;
    }
    if ((com.tencent.mm.compatible.util.d.lA(28)) && (((KeyguardManager)ak.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()))
    {
      ae.i("MicroMsg.Voip.NewVoipMgr", "api level: %s, in keyguard, ignore", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(209971);
      return;
    }
    ae.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, show dialog");
    com.tencent.mm.plugin.report.service.g.yxI.f(11306, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.l(this.Cqb.eCq(), 2131764896, 2131755906);
    if (locald == null)
    {
      ae.e("MicroMsg.Voip.NewVoipMgr", "new dialog failed");
      AppMethodBeat.o(209971);
      return;
    }
    locald.setCancelable(false);
    locald.setCanceledOnTouchOutside(false);
    locald.show();
    this.vZZ = true;
    com.tencent.mm.plugin.voip.b.i.eDw();
    AppMethodBeat.o(209971);
  }
  
  public final void eyP()
  {
    AppMethodBeat.i(209974);
    ae.i("MicroMsg.Voip.NewVoipMgr", "onSwitchCamera");
    j localj;
    Object localObject;
    int i;
    if (this.Cqa != null)
    {
      localj = this.Cqa;
      ae.i("MicroMsg.VoIPRenderMgr", "onSwitchCamera");
      if (localj.CJQ != null)
      {
        localObject = localj.CJQ;
        if (localObject == null) {
          p.gkB();
        }
        if (((com.tencent.mm.plugin.voip.video.h)localObject).eEa() != null)
        {
          localObject = localj.CJQ;
          if (localObject != null) {
            ((com.tencent.mm.plugin.voip.video.h)localObject).eDQ();
          }
          localObject = localj.CJQ;
          if (localObject == null) {
            p.gkB();
          }
          localObject = ((com.tencent.mm.plugin.voip.video.h)localObject).eEa();
          p.g(localObject, "newCaptureRender!!.previewSize");
          com.tencent.mm.plugin.voip.video.h localh = localj.CJQ;
          if (localh == null) {
            p.gkB();
          }
          i = localh.eEb();
          localh = localj.CJQ;
          if (localh == null) {
            p.gkB();
          }
          if (localh.eEc()) {
            break label189;
          }
        }
      }
    }
    label189:
    for (boolean bool = true;; bool = false)
    {
      localj.a((ac)localObject, i, bool);
      com.tencent.mm.plugin.report.service.g.yxI.f(11079, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(209974);
      return;
    }
  }
  
  public final void eyQ()
  {
    AppMethodBeat.i(209975);
    if ((this.Cqa != null) && (this.Cqa.CJQ != null) && (true != this.Cqa.CJQ.eDU())) {
      eyP();
    }
    AppMethodBeat.o(209975);
  }
  
  public final void eyR()
  {
    AppMethodBeat.i(209982);
    if (this.Cqa != null)
    {
      Object localObject1 = this.Cqa;
      ae.m("MicroMsg.VoIPRenderMgr", "onRender Mode changed", new Object[0]);
      if (!((j)localObject1).CzO) {}
      for (boolean bool = true;; bool = false)
      {
        ((j)localObject1).CzO = bool;
        Object localObject2 = ((j)localObject1).CJT;
        if (localObject2 != null) {
          com.tencent.mm.plugin.voip.video.render.e.c((com.tencent.mm.plugin.voip.video.render.e)localObject2);
        }
        localObject2 = ((j)localObject1).CJU;
        if (localObject2 != null) {
          com.tencent.mm.plugin.voip.video.render.c.h((com.tencent.mm.plugin.voip.video.render.c)localObject2);
        }
        localObject2 = ((j)localObject1).CJT;
        if (localObject2 != null)
        {
          ae.m("MicroMsg.LocalWindowsSurfaceRenderer", "switchRenderSurface", new Object[0]);
          com.tencent.mm.plugin.voip.video.render.m localm = ((com.tencent.mm.plugin.voip.video.render.e)localObject2).CJr;
          if (localm != null) {
            localm.eEJ();
          }
          localObject2 = ((com.tencent.mm.plugin.voip.video.render.e)localObject2).CJq;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.voip.video.render.g)localObject2).eEJ();
          }
        }
        localObject2 = ((j)localObject1).CJU;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.m)localObject2).eEJ();
        }
        localObject2 = ((j)localObject1).CJT;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.e)localObject2).eEK();
        }
        localObject1 = ((j)localObject1).CJU;
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.plugin.voip.video.render.m)localObject1).eEK();
        AppMethodBeat.o(209982);
        return;
      }
    }
    AppMethodBeat.o(209982);
  }
  
  public final void eyS()
  {
    AppMethodBeat.i(209984);
    if (this.Cqa != null) {
      this.Cqa.iv(this.CqV, this.CqW);
    }
    AppMethodBeat.o(209984);
  }
  
  public final void eyT()
  {
    AppMethodBeat.i(209986);
    this.Crh.Vn(1);
    AppMethodBeat.o(209986);
  }
  
  public final void eyU()
  {
    AppMethodBeat.i(209987);
    if (this.CpY != null)
    {
      ae.i("MicroMsg.Voip.NewVoipMgr", "use audioManager to stop voip ring");
      this.CpY.eyU();
      AppMethodBeat.o(209987);
      return;
    }
    ae.i("MicroMsg.Voip.NewVoipMgr", "use Subcore to stop voip ring");
    com.tencent.mm.plugin.voip.c.eys().Cvg.stopRing();
    AppMethodBeat.o(209987);
  }
  
  public final void eyV()
  {
    AppMethodBeat.i(209988);
    if (this.Cqb != null) {
      this.Cqb.eyV();
    }
    AppMethodBeat.o(209988);
  }
  
  public final boolean eyW()
  {
    AppMethodBeat.i(209989);
    if (com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId == 0)
    {
      this.Cqm = true;
      AppMethodBeat.o(209989);
      return true;
    }
    boolean bool = eyX();
    AppMethodBeat.o(209989);
    return bool;
  }
  
  public final void eyY()
  {
    AppMethodBeat.i(209992);
    ae.i("MicroMsg.Voip.NewVoipMgr", "onRoomReady");
    if ((this.Cqm) && (com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId != 0))
    {
      this.Cqm = false;
      eyX();
    }
    if (this.Cqi) {
      tP(4097);
    }
    AppMethodBeat.o(209992);
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
    AppMethodBeat.i(210003);
    ae.i("MicroMsg.Voip.NewVoipMgr", "onNoResp");
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
      AppMethodBeat.o(210003);
      return;
      str1 = bv.JgK;
      break;
    }
  }
  
  public final void ezc()
  {
    int j = 0;
    AppMethodBeat.i(210005);
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
        break label198;
      }
    }
    label198:
    for (int i = j;; i = 1)
    {
      com.tencent.mm.plugin.voip.b.f.c(k, l1, i, 3);
      this.Crb.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(209923);
          NewVoipMgr.a(NewVoipMgr.this, NewVoipMgr.h(NewVoipMgr.this));
          NewVoipMgr.q(NewVoipMgr.this).postDelayed(this, 5000L);
          AppMethodBeat.o(209923);
        }
      });
      AppMethodBeat.o(210005);
      return;
      i = 1;
      break;
    }
  }
  
  public final void ezd()
  {
    int j = 0;
    AppMethodBeat.i(210006);
    ae.i("MicroMsg.Voip.NewVoipMgr", "onShutDown");
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
      com.tencent.mm.plugin.voip.b.f.c(k, l, i, 4);
      this.CqT = true;
      AppMethodBeat.o(210006);
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
    AppMethodBeat.i(210014);
    ae.d("MicroMsg.Voip.NewVoipMgr", "onPretreatmentForStartDev");
    this.CpY.aA(this.CqF, this.Cqj);
    AppMethodBeat.o(210014);
  }
  
  public final long ezf()
  {
    AppMethodBeat.i(210015);
    ae.m("MicroMsg.Voip.NewVoipMgr", "totalDeviceNearTime: %s", new Object[] { Long.valueOf(this.CqN) });
    long l = this.CqN / 1000L;
    AppMethodBeat.o(210015);
    return l;
  }
  
  public final void ezj()
  {
    AppMethodBeat.i(210027);
    if ((256 != this.CpZ.mState) && (257 != this.CpZ.mState))
    {
      AppMethodBeat.o(210027);
      return;
    }
    if ((com.tencent.mm.kernel.g.ajR().ajA().getInt(327945, 0) == 0) && (this.Cqb.eCq() != null))
    {
      com.tencent.mm.kernel.g.ajR().ajA().setInt(327945, 1);
      com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.a(this.Cqb.eCq(), 2131764868, 2131755906, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(209934);
          NewVoipMgr.this.ezl();
          AppMethodBeat.o(209934);
        }
      });
      locald.setCancelable(false);
      locald.setCanceledOnTouchOutside(false);
      locald.show();
      AppMethodBeat.o(210027);
      return;
    }
    n.gL(ak.getContext());
    ezl();
    AppMethodBeat.o(210027);
  }
  
  public final void ezk()
  {
    AppMethodBeat.i(210028);
    if (!this.Cqx) {}
    for (boolean bool = true;; bool = false)
    {
      this.Cqx = bool;
      if (!this.Cqx) {
        break;
      }
      this.Cqw.stopTimer();
      AppMethodBeat.o(210028);
      return;
    }
    if (this.Cqw == null) {
      this.Cqw = new com.tencent.mm.sdk.platformtools.aw("faceDetect", new aw.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(209936);
          NewVoipMgr.I(NewVoipMgr.this);
          AppMethodBeat.o(209936);
          return true;
        }
      }, true);
    }
    this.Cqw.ay(2000L, 2000L);
    this.Cqx = false;
    AppMethodBeat.o(210028);
  }
  
  public final void ezl()
  {
    AppMethodBeat.i(210029);
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
            AppMethodBeat.i(209935);
            NewVoipMgr.H(NewVoipMgr.this);
            AppMethodBeat.o(209935);
          }
        }, 2000L);
      }
      AppMethodBeat.o(210029);
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
    AppMethodBeat.i(210011);
    ae.i("MicroMsg.Voip.NewVoipMgr", "adjustHWViewAspectRatio, HWDecsize:%dx%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.CqV = paramInt1;
    this.CqW = paramInt2;
    if (this.Cqa != null) {
      this.Cqa.iv(paramInt1, paramInt2);
    }
    AppMethodBeat.o(210011);
  }
  
  public final void km(boolean paramBoolean)
  {
    AppMethodBeat.i(209955);
    ae.m("MicroMsg.Voip.NewVoipMgr", "onSensorEvent, isON: %s, lastIsDeviceNear: %s, deviceSwitchNearScreenTick: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.CqM), Long.valueOf(this.CqL) });
    if (this.CpZ == null)
    {
      ae.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent, not create stateMachine yet, ignore");
      AppMethodBeat.o(209955);
      return;
    }
    if (this.pEX)
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.pEX = paramBoolean;
        ae.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent has skip and val is %s", new Object[] { Boolean.valueOf(this.pEX) });
        AppMethodBeat.o(209955);
        return;
      }
    }
    if ((Math.abs(bu.HQ() - this.CqO) < 500L) && (this.CqO != -1L))
    {
      ae.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent time interval too small");
      AppMethodBeat.o(209955);
      return;
    }
    if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qMR, true)) && (!paramBoolean) && (this.lastShakeTime != -1L) && (bu.aO(this.lastShakeTime) > 400L))
    {
      this.pEX = true;
      ae.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent has skip case shake near to small");
      AppMethodBeat.o(209955);
      return;
    }
    this.pEX = false;
    if ((com.tencent.mm.plugin.voip.b.l.Vu(this.CpZ.mState)) && ((this.CqM != paramBoolean) || (this.CqL == -1L)))
    {
      if ((!this.CqM) && (paramBoolean) && (!com.tencent.mm.plugin.voip.b.l.Vv(this.CpZ.mState)) && (this.mUIType != 2) && (this.CqL != -1L))
      {
        long l = bu.aO(this.CqL);
        ae.i("MicroMsg.Voip.NewVoipMgr", "accumulate near screen time: %s", new Object[] { Long.valueOf(l) });
        this.CqN += l;
      }
      this.CqL = bu.HQ();
      this.CqM = paramBoolean;
    }
    if (this.Cqb == null)
    {
      ae.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent, voipUI is null, ignore");
      AppMethodBeat.o(209955);
      return;
    }
    if (((this.Cqi) || (com.tencent.mm.plugin.voip.b.l.Vu(this.CpZ.mState))) && (!com.tencent.mm.plugin.voip.b.l.Vv(this.CpZ.mState)) && (this.mUIType != 2))
    {
      ae.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent, isOn: ".concat(String.valueOf(paramBoolean)));
      this.Cqb.setScreenEnable(paramBoolean);
      this.Cqd = paramBoolean;
      this.CqO = bu.HQ();
    }
    AppMethodBeat.o(209955);
  }
  
  public final void nC(boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(210018);
    ae.i("MicroMsg.Voip.NewVoipMgr", "onBadNetStatus");
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
      ae.i("MicroMsg.Voip.NewVoipMgr", i);
      localObject = com.tencent.mm.plugin.report.service.g.yxI;
      l = com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.uXg;
      i = j;
      if (paramBoolean) {
        i = 1;
      }
      ((com.tencent.mm.plugin.report.service.g)localObject).a(17151, true, true, new Object[] { Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(210018);
      return;
    }
  }
  
  public final void nO(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(209985);
    if ((this.Cqa != null) && (this.CqB != paramInt) && ((paramInt == 0) || (paramInt == 180)))
    {
      this.CqB = paramInt;
      Object localObject1 = this.Cqa.CJT;
      if (localObject1 != null)
      {
        Object localObject2 = ((com.tencent.mm.plugin.voip.video.render.e)localObject1).CJr;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.voip.video.render.c)localObject2).CJf;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.voip.video.render.l)localObject2).ng(paramInt);
          }
        }
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.e)localObject1).CJq;
        if (localObject2 != null)
        {
          if (((com.tencent.mm.plugin.voip.video.render.g)localObject2).CJI == null)
          {
            localObject1 = ((com.tencent.mm.plugin.voip.video.render.g)localObject2).CJz;
            if (localObject1 != null)
            {
              localObject1 = Integer.valueOf(((com.tencent.mm.media.j.b.a)localObject1).hpY);
              ((com.tencent.mm.plugin.voip.video.render.g)localObject2).CJI = ((Integer)localObject1);
            }
          }
          else
          {
            if (((com.tencent.mm.plugin.voip.video.render.g)localObject2).eEM() != 0) {
              break label190;
            }
            localObject1 = ((com.tencent.mm.plugin.voip.video.render.g)localObject2).CJz;
            if (localObject1 == null) {
              break label183;
            }
            localObject2 = ((com.tencent.mm.plugin.voip.video.render.g)localObject2).CJI;
            if (localObject2 == null) {
              break label178;
            }
          }
          label178:
          for (i = ((Integer)localObject2).intValue();; i = 0)
          {
            ((com.tencent.mm.plugin.voip.video.render.k)localObject1).ng(i + paramInt);
            AppMethodBeat.o(209985);
            return;
            localObject1 = null;
            break;
          }
          label183:
          AppMethodBeat.o(209985);
          return;
          label190:
          localObject1 = ((com.tencent.mm.plugin.voip.video.render.g)localObject2).CJz;
          if (localObject1 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.voip.video.render.g)localObject2).CJI;
            paramInt = i;
            if (localObject2 != null) {
              paramInt = ((Integer)localObject2).intValue();
            }
            ((com.tencent.mm.plugin.voip.video.render.k)localObject1).ng(paramInt);
            AppMethodBeat.o(209985);
            return;
          }
          AppMethodBeat.o(209985);
          return;
        }
        AppMethodBeat.o(209985);
        return;
      }
    }
    AppMethodBeat.o(209985);
  }
  
  public final void oN(boolean paramBoolean)
  {
    AppMethodBeat.i(209957);
    this.CpY.tF(paramBoolean);
    AppMethodBeat.o(209957);
  }
  
  public final void onConnected()
  {
    AppMethodBeat.i(210004);
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
    AppMethodBeat.o(210004);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(209997);
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
    ae.i("MicroMsg.Voip.NewVoipMgr", "onError, errCode: %s, roomId: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.roomId) });
    paramString = ak.getContext();
    ae.d("MicroMsg.Voip.NewVoipMgr", "getErrorMsgContent, errorCode".concat(String.valueOf(paramInt)));
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
        AppMethodBeat.o(209997);
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
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture) {}
  
  public final void onReject()
  {
    AppMethodBeat.i(209999);
    ae.i("MicroMsg.Voip.NewVoipMgr", "onReject");
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
      AppMethodBeat.o(209999);
      return;
      str1 = bv.JgK;
      break;
    }
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(210010);
    this.CqJ = paramInt;
    if (this.Cqa != null)
    {
      this.Cqa.setHWDecMode(paramInt);
      if (this.Cqb != null) {
        this.Cqb.Vd(paramInt);
      }
      if (this.Crh != null)
      {
        com.tencent.mm.plugin.voip.b.i locali = this.Crh;
        if ((paramInt & 0x1) != 0)
        {
          locali.CCX += 1L;
          AppMethodBeat.o(210010);
          return;
        }
        locali.CCY += 1L;
      }
    }
    AppMethodBeat.o(210010);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    this.Cqn = paramInt;
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(210009);
    ae.i("MicroMsg.Voip.NewVoipMgr", "setVoIPBeauty, isON: " + paramInt + "，mVoipUI: " + this.Cqb);
    if (this.Cqa != null)
    {
      j localj = this.Cqa;
      ae.i("MicroMsg.VoIPRenderMgr", "setVoIPBeauty, mIsStarted:%b, isON:%d", new Object[] { Boolean.valueOf(localj.mIsStarted), Integer.valueOf(paramInt) });
      localj.CqK = paramInt;
      com.tencent.mm.plugin.voip.video.render.e locale = localj.CJT;
      if (locale != null) {
        locale.VD(localj.CqK);
      }
    }
    if (this.Cqb != null) {
      this.Cqb.Ve(paramInt);
    }
    if ((paramInt != 0) && (this.CqK != paramInt)) {
      com.tencent.mm.plugin.report.service.g.yxI.n(914L, 20L, 1L);
    }
    this.CqK = paramInt;
    AppMethodBeat.o(210009);
  }
  
  public final void th(boolean paramBoolean)
  {
    AppMethodBeat.i(209954);
    int j = com.tencent.mm.plugin.voip.b.l.aE(false, paramBoolean);
    int i = j;
    if (this.Cqk)
    {
      if (j != 0) {
        break label80;
      }
      i = 1;
    }
    for (;;)
    {
      this.CpZ = com.tencent.mm.plugin.voip.b.l.Vs(i);
      ae.i("MicroMsg.Voip.NewVoipMgr", "steve:[simucall] resetStateMachine, initState:%d,isOutCall:%s,isVideoCall:%s", new Object[] { Integer.valueOf(i), Boolean.FALSE, Boolean.valueOf(paramBoolean) });
      this.Cqi = false;
      AppMethodBeat.o(209954);
      return;
      label80:
      i = j;
      if (256 == j) {
        i = 257;
      }
    }
  }
  
  public final void tk(boolean paramBoolean)
  {
    AppMethodBeat.i(209956);
    ae.i("MicroMsg.Voip.NewVoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.CpY.cn(paramBoolean);
    this.CpY.CCF = true;
    AppMethodBeat.o(209956);
  }
  
  public final void tl(boolean paramBoolean)
  {
    AppMethodBeat.i(209983);
    if (this.Cqa != null)
    {
      j localj = this.Cqa;
      localj.CzO = paramBoolean;
      localj.setHWDecMode(localj.CzS);
    }
    AppMethodBeat.o(209983);
  }
  
  public final boolean tm(final boolean paramBoolean)
  {
    AppMethodBeat.i(210026);
    if (com.tencent.mm.plugin.voip.c.eys().Cvv)
    {
      ae.i("MicroMsg.Voip.NewVoipMgr", "current state is mini, cannot mini!");
      AppMethodBeat.o(210026);
      return false;
    }
    if ((this.CqE) && (!paramBoolean))
    {
      ae.i("MicroMsg.Voip.NewVoipMgr", "has phone call  cannot mini!");
      AppMethodBeat.o(210026);
      return false;
    }
    ae.l("MicroMsg.Voip.NewVoipMgr", "miniOnlyHidenVoip: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ae.i("MicroMsg.Voip.NewVoipMgr", "onMinimizeVoip, async to minimize");
    if (this.Cqb != null)
    {
      this.Cqb.uninit();
      this.Cqb = null;
      this.CpY.b(this.Cqb);
    }
    this.hLA = bu.HQ();
    if (this.CqD != null) {
      this.CqD.uninit();
    }
    if (this.jzz != null) {
      this.jzz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(209933);
          NewVoipMgr.c(NewVoipMgr.this, paramBoolean);
          AppMethodBeat.o(209933);
        }
      });
    }
    AppMethodBeat.o(210026);
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
      AppMethodBeat.i(209951);
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
                AppMethodBeat.o(209951);
                return;
              } while (NewVoipMgr.h(NewVoipMgr.this) == 5);
              j = NewVoipMgr.ezn()[1];
              if (NewVoipMgr.i(NewVoipMgr.this) == 0) {
                NewVoipMgr.a(NewVoipMgr.this, 4);
              }
            } while (NewVoipMgr.i(NewVoipMgr.this) == 0);
            k = NewVoipMgr.ezo() / NewVoipMgr.i(NewVoipMgr.this);
            NewVoipMgr.a(NewVoipMgr.this, 5);
            m = NewVoipMgr.ezn()[0];
            ae.i("MicroMsg.Voip.NewVoipMgr", "befor change to 4G and cost " + NewVoipMgr.j(NewVoipMgr.this));
            if (NewVoipMgr.d(NewVoipMgr.this)) {}
            for (;;)
            {
              com.tencent.mm.plugin.voip.b.f.a(i, System.currentTimeMillis(), NewVoipMgr.h(NewVoipMgr.this), 5, j, m, k);
              NewVoipMgr.k(NewVoipMgr.this);
              NewVoipMgr.b(NewVoipMgr.this, 5);
              NewVoipMgr.ezp();
              NewVoipMgr.l(NewVoipMgr.this);
              AppMethodBeat.o(209951);
              return;
              i = 1;
            }
          } while (NewVoipMgr.h(NewVoipMgr.this) == 4);
          k = NewVoipMgr.ezn()[0];
          if (NewVoipMgr.i(NewVoipMgr.this) == 0) {
            NewVoipMgr.a(NewVoipMgr.this, 5);
          }
        } while (NewVoipMgr.i(NewVoipMgr.this) == 0);
        int m = NewVoipMgr.ezo() / NewVoipMgr.i(NewVoipMgr.this);
        NewVoipMgr.a(NewVoipMgr.this, 4);
        int n = NewVoipMgr.ezn()[1];
        ae.i("MicroMsg.Voip.NewVoipMgr", "befor change to wifi and cost " + NewVoipMgr.j(NewVoipMgr.this));
        if (NewVoipMgr.d(NewVoipMgr.this)) {}
        for (i = j;; i = 1)
        {
          com.tencent.mm.plugin.voip.b.f.a(i, System.currentTimeMillis(), NewVoipMgr.h(NewVoipMgr.this), 4, k, n, m);
          NewVoipMgr.k(NewVoipMgr.this);
          NewVoipMgr.b(NewVoipMgr.this, 4);
          NewVoipMgr.ezp();
          NewVoipMgr.l(NewVoipMgr.this);
          break;
        }
      }
      if ((paramIntent.getAction().equals("android.net.wifi.STATE_CHANGE")) && (NewVoipMgr.m(NewVoipMgr.this) == 0L))
      {
        NewVoipMgr.b(NewVoipMgr.this, System.currentTimeMillis());
        AppMethodBeat.o(209951);
        return;
      }
      if ((paramIntent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) && (NewVoipMgr.m(NewVoipMgr.this) != 0L))
      {
        NewVoipMgr.c(NewVoipMgr.this, System.currentTimeMillis() - NewVoipMgr.m(NewVoipMgr.this));
        NewVoipMgr.b(NewVoipMgr.this, 0L);
      }
      AppMethodBeat.o(209951);
    }
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(209950);
      NewVoipMgr.r(NewVoipMgr.this);
      NewVoipMgr.s(NewVoipMgr.this);
      AppMethodBeat.o(209950);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.NewVoipMgr
 * JD-Core Version:    0.7.0.1
 */