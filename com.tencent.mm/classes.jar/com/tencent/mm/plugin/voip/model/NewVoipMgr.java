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
import com.tencent.mm.g.a.xg;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.a.yj;
import com.tencent.mm.g.a.yj.a;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.aq;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.voip.ui.VoipScoreDialog;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView.b;
import com.tencent.mm.plugin.voip.video.render.f;
import com.tencent.mm.plugin.voip.video.render.h.b;
import com.tencent.mm.plugin.voip.video.render.h.c;
import com.tencent.mm.plugin.voip.video.render.h.d;
import com.tencent.mm.plugin.voip.video.render.h.e;
import com.tencent.mm.plugin.voip.video.render.h.f;
import com.tencent.mm.plugin.voip.video.render.h.g;
import com.tencent.mm.plugin.voip.video.render.h.h;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class NewVoipMgr
  extends com.tencent.mm.plugin.voip.a
  implements com.tencent.mm.plugin.voip.video.render.a
{
  static int[] AAB = new int[2];
  static int kZl = 0;
  ao AAA;
  private long AAD;
  private boolean AAE;
  private int AAF;
  private int AAG;
  private com.tencent.mm.plugin.voip.b.g AAH;
  private BroadcastReceiver AAI;
  private BroadcastReceiver AAJ;
  int AAK;
  private com.tencent.mm.sdk.b.c AAL;
  private int AAa;
  private boolean AAb;
  private com.tencent.mm.plugin.voip.widget.b AAc;
  private boolean AAd;
  private boolean AAe;
  private String AAf;
  private boolean AAg;
  private boolean AAh;
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
  NetChangedBroadcastReceiver AAy;
  PhoneStateListener AAz;
  private volatile com.tencent.mm.plugin.voip.ui.b AzA;
  private a AzB;
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
  private boolean AzO;
  private boolean AzP;
  private boolean AzQ;
  private boolean AzR;
  private int AzS;
  private int AzT;
  private com.tencent.mm.plugin.voip.video.k AzU;
  private au AzV;
  private boolean AzW;
  private boolean AzX;
  private int AzY;
  private boolean AzZ;
  private com.tencent.mm.plugin.voip.b.c Azx;
  private com.tencent.mm.plugin.voip.b.k Azy;
  private com.tencent.mm.plugin.voip.video.render.h Azz;
  private long enterTime;
  private String foE;
  private long hqp;
  private ao jdu;
  PhoneStateListener kMN;
  private long lastShakeTime;
  private boolean mIsMute;
  private int mUIType;
  private boolean oUJ;
  private com.tencent.mm.sdk.platformtools.bj oUK;
  private SensorController oUL;
  TelephonyManager ouQ;
  private long soH;
  private TelephonyManager tHh;
  private com.tencent.mm.sdk.b.c tHj;
  private long tJt;
  private boolean uKQ;
  
  public NewVoipMgr()
  {
    AppMethodBeat.i(208241);
    this.AzB = null;
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
    this.mIsMute = false;
    this.AzN = -1L;
    this.AzO = false;
    this.AzP = false;
    this.AzQ = false;
    this.uKQ = false;
    this.AzR = false;
    this.AzS = 0;
    this.AzT = 0;
    this.AzU = new com.tencent.mm.plugin.voip.video.k();
    this.AzV = null;
    this.AzW = false;
    this.AzX = false;
    this.AzY = 0;
    this.AzZ = false;
    this.AAa = -1;
    this.AAb = false;
    this.AAd = false;
    this.AAe = false;
    this.AAf = null;
    this.AAg = true;
    this.AAh = false;
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
    this.AAI = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(208211);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        paramAnonymousIntent = (PowerManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("power");
        if (("android.intent.action.USER_PRESENT".equals(paramAnonymousContext)) && (paramAnonymousIntent.isScreenOn()))
        {
          if (NewVoipMgr.a(NewVoipMgr.this) != null)
          {
            NewVoipMgr.a(NewVoipMgr.this).AzR = false;
            AppMethodBeat.o(208211);
          }
        }
        else
        {
          if ("android.intent.action.SCREEN_ON".equals(paramAnonymousContext))
          {
            if (NewVoipMgr.a(NewVoipMgr.this) != null) {
              NewVoipMgr.a(NewVoipMgr.this).AzR = false;
            }
            NewVoipMgr.this.kc(true);
            AppMethodBeat.o(208211);
            return;
          }
          if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousContext))
          {
            if (NewVoipMgr.a(NewVoipMgr.this) != null) {
              NewVoipMgr.a(NewVoipMgr.this).AzR = true;
            }
            if (!NewVoipMgr.b(NewVoipMgr.this)) {
              NewVoipMgr.this.kc(true);
            }
            if ((!com.tencent.mm.plugin.voip.b.j.SU(NewVoipMgr.c(NewVoipMgr.this).mState)) && (!NewVoipMgr.d(NewVoipMgr.this))) {
              com.tencent.mm.plugin.voip.c.ehb().AEF.stopRing();
            }
          }
        }
        AppMethodBeat.o(208211);
      }
    };
    this.AAJ = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(208227);
        if ((paramAnonymousIntent.getAction().equals("com.tencent.mm.foregroundDestroy")) && (com.tencent.mm.plugin.voip.c.ehb().cUz) && (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pSp, false))) {
          com.tencent.mm.plugin.voip.c.ehb().i(NewVoipMgr.e(NewVoipMgr.this), NewVoipMgr.f(NewVoipMgr.this), true);
        }
        AppMethodBeat.o(208227);
      }
    };
    this.tHj = new com.tencent.mm.sdk.b.c() {};
    this.AAK = 0;
    this.tJt = 0L;
    this.kMN = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        int i = 1;
        AppMethodBeat.i(208217);
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onCallStateChanged :%d, isStartVoip: %b,oldState:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(NewVoipMgr.t(NewVoipMgr.this)), Integer.valueOf(NewVoipMgr.u(NewVoipMgr.this)) });
        if (!NewVoipMgr.t(NewVoipMgr.this))
        {
          AppMethodBeat.o(208217);
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
          com.tencent.mm.plugin.voip.c.ehb().So(1);
          NewVoipMgr.b(NewVoipMgr.this, true);
        }
        label327:
        label361:
        do
        {
          NewVoipMgr.n(NewVoipMgr.this).AAE = NewVoipMgr.C(NewVoipMgr.this);
          AppMethodBeat.o(208217);
          return;
          if (paramAnonymousInt == 2)
          {
            NewVoipMgr.a(NewVoipMgr.this, false);
            if (NewVoipMgr.u(NewVoipMgr.this) == 1) {
              NewVoipMgr.e(NewVoipMgr.this, System.currentTimeMillis());
            }
            NewVoipMgr.c(NewVoipMgr.this, 2);
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "phone call coming now!");
            if ((NewVoipMgr.d(NewVoipMgr.this)) && (!com.tencent.mm.plugin.voip.b.j.SU(NewVoipMgr.c(NewVoipMgr.this).mState))) {
              com.tencent.mm.plugin.voip.c.ehb().AEF.eki();
            }
            String str2;
            String str1;
            if (com.tencent.mm.plugin.voip.b.j.SU(NewVoipMgr.c(NewVoipMgr.this).mState))
            {
              paramAnonymousString = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764803, new Object[] { NewVoipMgr.yO(bs.pN(NewVoipMgr.w(NewVoipMgr.this))) });
              com.tencent.mm.plugin.voip.c.ehb().ejJ();
              str2 = NewVoipMgr.x(NewVoipMgr.this).field_username;
              if (!NewVoipMgr.f(NewVoipMgr.this)) {
                break label596;
              }
              str1 = bo.GYP;
              if (!NewVoipMgr.d(NewVoipMgr.this)) {
                break label604;
              }
            }
            for (paramAnonymousInt = i;; paramAnonymousInt = 0)
            {
              s.c(str2, str1, paramAnonymousInt, 6, paramAnonymousString);
              NewVoipMgr.d(NewVoipMgr.this, 4107);
              NewVoipMgr.y(NewVoipMgr.this);
              paramAnonymousString = new bo();
              paramAnonymousString.setType(10000);
              paramAnonymousString.oA(System.currentTimeMillis());
              paramAnonymousString.setStatus(6);
              paramAnonymousString.setContent(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764801) + ", <a href=\"weixin://voip/callagain/?username=" + NewVoipMgr.e(NewVoipMgr.this) + "&isvideocall=" + NewVoipMgr.f(NewVoipMgr.this) + "\">" + com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764796) + "</a>");
              if ((NewVoipMgr.e(NewVoipMgr.this) != null) && (!NewVoipMgr.e(NewVoipMgr.this).equals("")))
              {
                paramAnonymousString.re(NewVoipMgr.e(NewVoipMgr.this));
                ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).dcr().ap(paramAnonymousString);
              }
              com.tencent.mm.plugin.voip.c.ehb().So(2);
              NewVoipMgr.b(NewVoipMgr.this, false);
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
        if ((NewVoipMgr.u(NewVoipMgr.this) == 1) || (NewVoipMgr.u(NewVoipMgr.this) == 2)) {
          NewVoipMgr.e(NewVoipMgr.this, System.currentTimeMillis());
        }
        NewVoipMgr.c(NewVoipMgr.this, 0);
        com.tencent.mm.plugin.voip.c.ehb().So(2);
        if ((1 == NewVoipMgr.z(NewVoipMgr.this)) && (com.tencent.mm.plugin.voip.b.j.SU(NewVoipMgr.c(NewVoipMgr.this).mState)) && (NewVoipMgr.A(NewVoipMgr.this))) {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(208213);
              NewVoipMgr.n(NewVoipMgr.this).cm(true);
              AppMethodBeat.o(208213);
            }
          });
        }
        if ((4 == NewVoipMgr.z(NewVoipMgr.this)) && (NewVoipMgr.A(NewVoipMgr.this))) {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(208214);
              NewVoipMgr.n(NewVoipMgr.this).au(NewVoipMgr.B(NewVoipMgr.this), NewVoipMgr.f(NewVoipMgr.this));
              AppMethodBeat.o(208214);
            }
          });
        }
        NewVoipMgr.a(NewVoipMgr.this, false);
        if ((com.tencent.mm.compatible.b.g.Xi() != null) && (com.tencent.mm.plugin.audio.c.a.bCx().isBluetoothScoOn()))
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "is bluetooth can use and start bluetooth");
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(208215);
              NewVoipMgr.n(NewVoipMgr.this).au(NewVoipMgr.B(NewVoipMgr.this), NewVoipMgr.f(NewVoipMgr.this));
              AppMethodBeat.o(208215);
            }
          });
        }
        for (;;)
        {
          NewVoipMgr.b(NewVoipMgr.this, false);
          break;
          if (com.tencent.mm.plugin.audio.c.a.bCx().bCs()) {
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(208216);
                NewVoipMgr.n(NewVoipMgr.this).au(NewVoipMgr.B(NewVoipMgr.this), NewVoipMgr.f(NewVoipMgr.this));
                AppMethodBeat.o(208216);
              }
            });
          }
        }
      }
    };
    this.hqp = -1L;
    this.enterTime = -1L;
    this.AAL = new com.tencent.mm.sdk.b.c() {};
    this.Azx = new com.tencent.mm.plugin.voip.b.c();
    AppMethodBeat.o(208241);
  }
  
  private void RV(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(208265);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "hangupTalkingOrCancelInvite");
    if (true == ehP()) {
      this.AzK = paramInt;
    }
    Object localObject = com.tencent.mm.sdk.platformtools.ai.getContext();
    String str2;
    if (com.tencent.mm.plugin.voip.b.j.SU(this.Azy.mState))
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
      if ((!this.AzH) || (com.tencent.mm.plugin.voip.b.j.SU(this.Azy.mState))) {
        break label259;
      }
      ehD();
      if ((this.AzH) && (!com.tencent.mm.plugin.voip.b.j.SU(this.Azy.mState)))
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "hangupVoipButton OnClick call cancelCall");
        com.tencent.mm.plugin.voip.c.ehb().AEF.ekh();
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "hangupVoipButton OnClick call hangUp");
      com.tencent.mm.plugin.voip.c.ehb().AEF.ekk();
      if (4096 != this.AzK) {
        break label315;
      }
      tg(paramInt);
      ehH();
      AppMethodBeat.o(208265);
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
        AppMethodBeat.i(208236);
        NewVoipMgr.n(NewVoipMgr.this);
        com.tencent.mm.plugin.voip.b.c.sQ(NewVoipMgr.f(NewVoipMgr.this));
        AppMethodBeat.o(208236);
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
    AppMethodBeat.o(208265);
  }
  
  private boolean RW(int paramInt)
  {
    AppMethodBeat.i(208282);
    if (4111 == paramInt)
    {
      AppMethodBeat.o(208282);
      return true;
    }
    if ((4101 == paramInt) && ((com.tencent.mm.plugin.voip.b.j.SU(this.Azy.mState)) || (this.AzH)))
    {
      AppMethodBeat.o(208282);
      return true;
    }
    AppMethodBeat.o(208282);
    return false;
  }
  
  private static void RX(int paramInt)
  {
    AppMethodBeat.i(208283);
    yj localyj = new yj();
    localyj.dBX.cZu = paramInt;
    com.tencent.mm.sdk.b.a.GpY.l(localyj);
    AppMethodBeat.o(208283);
  }
  
  private boolean d(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(208310);
    String str = com.tencent.mm.m.g.ZY().getValue("VOIPShortcutAutoadd");
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "voip shortcut autoAdd is %s", new Object[] { str });
    if ((str != null) && (str.equals("0")) && (bs.pN(this.AzN) > 30L))
    {
      int i = paramSharedPreferences.getInt("voip_shortcut_prompt_times", 0);
      boolean bool = paramSharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
      if ((i < 3) && (!bool))
      {
        ehQ();
        paramSharedPreferences.edit().putInt("voip_shortcut_prompt_times", i + 1).commit();
        AppMethodBeat.o(208310);
        return true;
      }
    }
    else if ((str != null) && (str.equals("1")) && (bs.pN(this.AzN) > 15L))
    {
      e(paramSharedPreferences);
      AppMethodBeat.o(208310);
      return false;
    }
    AppMethodBeat.o(208310);
    return false;
  }
  
  private void e(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(208311);
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
      AppMethodBeat.o(208311);
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
    AppMethodBeat.i(208278);
    if (!this.Azy.SY(4101))
    {
      AppMethodBeat.o(208278);
      return false;
    }
    this.AzI = false;
    if (this.AAc != null) {
      this.AAc.AzI = false;
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
        AppMethodBeat.o(208278);
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
    AppMethodBeat.i(208288);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Voip.NewVoipMgr", "delayFinish");
    this.AAf = null;
    if (this.jdu != null) {
      this.jdu.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(208238);
          NewVoipMgr localNewVoipMgr = NewVoipMgr.this;
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "it is uninit voip report");
          if (localNewVoipMgr.AAA != null)
          {
            localNewVoipMgr.AAA.removeCallbacksAndMessages(null);
            localNewVoipMgr.AAA.quit();
          }
          if (!localNewVoipMgr.AAx)
          {
            if (localNewVoipMgr.AAK == 0) {
              localNewVoipMgr.RU(localNewVoipMgr.AAw);
            }
            if (localNewVoipMgr.AAK != 0)
            {
              localNewVoipMgr.AAx = true;
              if (!localNewVoipMgr.AzH) {
                break label183;
              }
            }
          }
          label183:
          for (int i = 0;; i = 1)
          {
            com.tencent.mm.plugin.voip.b.d.a(i, System.currentTimeMillis(), localNewVoipMgr.AAw, localNewVoipMgr.AAw, 0, 0, NewVoipMgr.kZl / localNewVoipMgr.AAK);
            NewVoipMgr.kZl = 0;
            NewVoipMgr.AAB[0] = 0;
            NewVoipMgr.AAB[1] = 0;
            localNewVoipMgr.AAK = 0;
            if (localNewVoipMgr.ouQ != null) {
              localNewVoipMgr.ouQ.listen(localNewVoipMgr.AAz, 0);
            }
            if (localNewVoipMgr.AAy != null)
            {
              com.tencent.mm.sdk.platformtools.ai.getContext().unregisterReceiver(localNewVoipMgr.AAy);
              localNewVoipMgr.AAy = null;
            }
            NewVoipMgr.p(NewVoipMgr.this);
            AppMethodBeat.o(208238);
            return;
          }
        }
      }, 500L);
    }
    AppMethodBeat.o(208288);
  }
  
  private static void ehI()
  {
    AppMethodBeat.i(208290);
    xh localxh = new xh();
    localxh.dAb.dgL = 11;
    com.tencent.mm.sdk.b.a.GpY.l(localxh);
    AppMethodBeat.o(208290);
  }
  
  private void ehO()
  {
    AppMethodBeat.i(208305);
    synchronized (this.AzF)
    {
      ehU();
      if (this.Azz != null) {
        this.Azz.release();
      }
      com.tencent.mm.plugin.voip.b.c.unInit();
      this.Azx.ehO();
      AppMethodBeat.o(208305);
      return;
    }
  }
  
  private boolean ehP()
  {
    AppMethodBeat.i(208309);
    if (com.tencent.mm.plugin.voip.b.j.SU(this.Azy.mState))
    {
      SharedPreferences localSharedPreferences = getContext().getSharedPreferences("voip_plugin_prefs", 0);
      if (!localSharedPreferences.getBoolean("voip_shortcut_has_added", false))
      {
        boolean bool = d(localSharedPreferences);
        AppMethodBeat.o(208309);
        return bool;
      }
    }
    AppMethodBeat.o(208309);
    return false;
  }
  
  private void ehQ()
  {
    AppMethodBeat.i(208313);
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
          AppMethodBeat.i(208219);
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
                AppMethodBeat.i(208218);
                NewVoipMgr.p(NewVoipMgr.this);
                AppMethodBeat.o(208218);
              }
            });
          }
          AppMethodBeat.o(208219);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(208221);
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
                AppMethodBeat.i(208220);
                NewVoipMgr.p(NewVoipMgr.this);
                AppMethodBeat.o(208220);
              }
            });
          }
          AppMethodBeat.o(208221);
        }
      });
      AppMethodBeat.o(208313);
      return;
      localTextView.setText(2131764787);
    }
  }
  
  private void ehU()
  {
    AppMethodBeat.i(208318);
    if (this.AzU != null) {
      this.AzU.b(this);
    }
    if (this.AzV != null)
    {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Voip.NewVoipMgr", "stop face detect timer");
      this.AzV.stopTimer();
    }
    AppMethodBeat.o(208318);
  }
  
  private void gb(boolean paramBoolean)
  {
    AppMethodBeat.i(208289);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "finish");
    if (this.AAH != null) {
      this.AAH.elS();
    }
    this.AAb = false;
    this.AAd = false;
    this.lastShakeTime = -1L;
    if (this.AzS != -1)
    {
      com.tencent.mm.plugin.report.service.h.wUl.f(11700, new Object[] { Integer.valueOf(this.AzS), Long.valueOf(bs.pN(this.AzN)) });
      this.AzS = -1;
    }
    try
    {
      com.tencent.mm.sdk.platformtools.ai.getContext().unregisterReceiver(this.AAI);
      try
      {
        label105:
        com.tencent.mm.sdk.platformtools.ai.getContext().unregisterReceiver(this.AAJ);
        label115:
        com.tencent.mm.sdk.b.a.GpY.d(this.tHj);
        com.tencent.mm.sdk.b.a.GpY.d(this.AAL);
        ehU();
        if (this.Azz != null)
        {
          this.Azz.release();
          this.Azz = null;
        }
        if (this.AzA != null)
        {
          this.AzA.uninit();
          this.AzA = null;
          this.Azx.b(this.AzA);
        }
        label237:
        int j;
        label302:
        long l;
        if (com.tencent.mm.plugin.voip.c.ehb() != null)
        {
          com.tencent.mm.plugin.voip.c.ehb().AEF.stopRing();
          if (paramBoolean)
          {
            com.tencent.mm.plugin.voip.c.ehb().ejK();
            if (!this.AzI) {
              break label749;
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
            break label764;
          }
          this.AzB = new a();
          com.tencent.e.h.JZN.aS(this.AzB);
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
            com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Voip.NewVoipMgr", "removeSensorCallBack");
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
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "finish, isFinishFromShutdown: %s", new Object[] { Boolean.valueOf(this.AzE) });
          if ((this.AzE) && (com.tencent.mm.plugin.voip.c.ehb().ejZ()))
          {
            com.tencent.mm.plugin.voip.c.ehb();
            VoipScoreState.ejH();
            Object localObject = new Intent(getContext(), VoipScoreDialog.class);
            ((Intent)localObject).putExtra("key_score_state", com.tencent.mm.plugin.voip.c.ehb().ekb());
            if (!(getContext() instanceof Activity)) {
              ((Intent)localObject).addFlags(268435456);
            }
            Context localContext = getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          com.tencent.mm.plugin.voip.c.ehb().eka();
          ehI();
          if (!this.AAs)
          {
            j = com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId;
            l = com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.tIG;
            if (!this.AzH) {
              break label771;
            }
          }
        }
        label771:
        for (int i = 0;; i = 1)
        {
          com.tencent.mm.plugin.voip.b.d.c(j, l, i, 4);
          this.AAs = true;
          ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
          com.tencent.mm.media.f.c.gRV.aqV();
          AppMethodBeat.o(208289);
          return;
          com.tencent.mm.plugin.voip.c.ehb().AEF.ekk();
          break;
          label749:
          com.tencent.mm.plugin.voip.c.ehb().b(false, false, this.foE);
          break label237;
          label764:
          ehO();
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
    AppMethodBeat.i(208312);
    Context localContext1 = null;
    if (this.AzA != null) {
      localContext1 = this.AzA.ekX();
    }
    Context localContext2 = localContext1;
    if (localContext1 == null) {
      localContext2 = com.tencent.mm.sdk.platformtools.ai.getContext();
    }
    AppMethodBeat.o(208312);
    return localContext2;
  }
  
  private static String qn(long paramLong)
  {
    AppMethodBeat.i(208304);
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
    AppMethodBeat.o(208304);
    return str;
  }
  
  private void tg(final int paramInt)
  {
    AppMethodBeat.i(208281);
    com.tencent.mm.sdk.platformtools.ac.l("MicroMsg.Voip.NewVoipMgr", "swtchState, action: %s, currentState: %s", new Object[] { com.tencent.mm.plugin.voip.b.j.SR(paramInt), com.tencent.mm.plugin.voip.b.j.SR(this.Azy.mState) });
    if ((4101 == paramInt) && (com.tencent.mm.plugin.voip.b.j.SV(this.Azy.mState)))
    {
      ehU();
      if (this.Azz != null) {
        this.Azz.release();
      }
      this.AzI = false;
      if (this.AAc != null) {
        this.AAc.AzI = false;
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
          AppMethodBeat.i(208237);
          if (NewVoipMgr.o(NewVoipMgr.this) != null) {
            NewVoipMgr.o(NewVoipMgr.this).ih(paramInt, NewVoipMgr.c(NewVoipMgr.this).mState);
          }
          AppMethodBeat.o(208237);
        }
      });
    }
    switch (this.Azy.mState)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(208281);
      return;
      RX(5);
      AppMethodBeat.o(208281);
      return;
      RX(6);
    }
  }
  
  final void RU(int paramInt)
  {
    AppMethodBeat.i(208257);
    if (paramInt == 5)
    {
      kZl += AAB[0];
      this.AAK += 1;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "mSignalStrength 4G" + AAB[0] + " and index is " + this.AAK);
      AppMethodBeat.o(208257);
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
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "error happened in get wifi info");
        continue;
      }
      kZl += AAB[1];
      this.AAK += 1;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "mSignalStrength WIFI " + AAB[1] + " and index is " + this.AAK);
      AppMethodBeat.o(208257);
      return;
      paramInt = localWifiManager.getConnectionInfo().getRssi();
    }
  }
  
  public final void RY(int paramInt)
  {
    AppMethodBeat.i(208295);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "remote voip mode changed, cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    if (((1 == paramInt) || (3 == paramInt) || (5 == paramInt) || (6 == paramInt) || (7 == paramInt)) && (this.AzI))
    {
      tg(4101);
      com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.eit();
      com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.eiu();
    }
    AppMethodBeat.o(208295);
  }
  
  public final void RZ(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(208300);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onSessionBeingCalled, callType: ".concat(String.valueOf(paramInt)));
    if (!this.Azy.SY(4110))
    {
      AppMethodBeat.o(208300);
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
      if ((paramInt == 1) && (com.tencent.mm.plugin.voip.b.j.SV(this.Azy.mState))) {
        tg(4101);
      }
      tg(4110);
      AppMethodBeat.o(208300);
      return;
    }
  }
  
  public final void Sa(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(208301);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "steve:[simucall]onNewSimulCallAutoAccept, callType: ".concat(String.valueOf(paramInt)));
    if (!this.Azy.SY(4100))
    {
      AppMethodBeat.o(208301);
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
      if ((paramInt == 1) && (com.tencent.mm.plugin.voip.b.j.SV(this.Azy.mState))) {
        tg(4101);
      }
      tg(4100);
      AppMethodBeat.o(208301);
      return;
    }
  }
  
  public final void Y(long paramLong, int paramInt)
  {
    int k = 1;
    AppMethodBeat.i(208261);
    Object localObject1;
    int i;
    label60:
    Object localObject2;
    int j;
    if (this.AAH != null) {
      switch (paramInt)
      {
      default: 
        if (this.Azz != null)
        {
          localObject1 = this.AAH;
          if (1 != this.mUIType) {
            break label367;
          }
          i = 1;
          localObject2 = this.Azz.ASl;
          j = k;
          if (localObject2 != null)
          {
            if (((com.tencent.mm.plugin.voip.video.render.d)localObject2).eng() == 0) {
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
      AppMethodBeat.o(208261);
      return;
      if (1 == this.mUIType)
      {
        if (!com.tencent.mm.plugin.voip.c.ehb().AET)
        {
          localObject1 = this.AAH;
          if ((260 != this.Azy.mState) && (6 != this.Azy.mState)) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.plugin.voip.b.g)localObject1).aw(true, bool);
            com.tencent.mm.plugin.voip.c.ehb().AET = true;
            break;
          }
        }
        localObject1 = this.AAH;
        if ((260 != this.Azy.mState) && (6 != this.Azy.mState)) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.voip.b.g)localObject1).ax(true, bool);
          break;
        }
      }
      if (!com.tencent.mm.plugin.voip.c.ehb().AES)
      {
        localObject1 = this.AAH;
        if ((260 != this.Azy.mState) && (6 != this.Azy.mState)) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.voip.b.g)localObject1).aw(false, bool);
          com.tencent.mm.plugin.voip.c.ehb().AES = true;
          break;
        }
      }
      localObject1 = this.AAH;
      if ((260 != this.Azy.mState) && (6 != this.Azy.mState)) {}
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.voip.b.g)localObject1).ax(false, bool);
        break;
      }
      label367:
      i = 0;
      break label60;
      label373:
      j = 0;
      break label90;
      ((com.tencent.mm.plugin.voip.b.g)localObject1).AMn += 1;
      if (((com.tencent.mm.plugin.voip.b.g)localObject1).AMn == 0)
      {
        if (i != 0)
        {
          if (paramLong > 0L)
          {
            localObject1 = com.tencent.mm.plugin.voip.b.i.AMu;
            com.tencent.mm.plugin.voip.b.i.za(paramLong);
            AppMethodBeat.o(208261);
          }
        }
        else
        {
          if (paramLong > 0L)
          {
            localObject1 = com.tencent.mm.plugin.voip.b.i.AMu;
            com.tencent.mm.plugin.voip.b.i.zb(paramLong);
          }
          AppMethodBeat.o(208261);
        }
      }
      else if (((com.tencent.mm.plugin.voip.b.g)localObject1).AMn == 60) {
        ((com.tencent.mm.plugin.voip.b.g)localObject1).AMn = -1;
      }
      AppMethodBeat.o(208261);
      return;
      ((com.tencent.mm.plugin.voip.b.g)localObject1).AMo += 1;
      if (((com.tencent.mm.plugin.voip.b.g)localObject1).AMo == 0)
      {
        if (i != 0)
        {
          if (j != 0)
          {
            localObject1 = com.tencent.mm.plugin.voip.b.i.AMu;
            com.tencent.mm.plugin.voip.b.i.zs(paramLong);
            AppMethodBeat.o(208261);
            return;
          }
          localObject1 = com.tencent.mm.plugin.voip.b.i.AMu;
          com.tencent.mm.plugin.voip.b.i.zq(paramLong);
          AppMethodBeat.o(208261);
          return;
        }
        if (j != 0)
        {
          localObject1 = com.tencent.mm.plugin.voip.b.i.AMu;
          com.tencent.mm.plugin.voip.b.i.zt(paramLong);
          AppMethodBeat.o(208261);
          return;
        }
        localObject1 = com.tencent.mm.plugin.voip.b.i.AMu;
        com.tencent.mm.plugin.voip.b.i.zr(paramLong);
        AppMethodBeat.o(208261);
        return;
      }
      if (((com.tencent.mm.plugin.voip.b.g)localObject1).AMo == 60) {
        ((com.tencent.mm.plugin.voip.b.g)localObject1).AMo = -1;
      }
      AppMethodBeat.o(208261);
      return;
      ((com.tencent.mm.plugin.voip.b.g)localObject1).AMp += 1;
      if (((com.tencent.mm.plugin.voip.b.g)localObject1).AMp == 0)
      {
        if (i != 0)
        {
          localObject2 = com.tencent.mm.plugin.voip.b.i.AMu;
          com.tencent.mm.plugin.voip.b.i.zc(paramLong);
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.voip.b.g)localObject1).AMn = 0;
          AppMethodBeat.o(208261);
          return;
          localObject2 = com.tencent.mm.plugin.voip.b.i.AMu;
          com.tencent.mm.plugin.voip.b.i.zd(paramLong);
        }
      }
      if (((com.tencent.mm.plugin.voip.b.g)localObject1).AMp == 60) {
        ((com.tencent.mm.plugin.voip.b.g)localObject1).AMp = -1;
      }
    }
  }
  
  public final void Z(long paramLong, int paramInt) {}
  
  public final void a(final Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 1;
    AppMethodBeat.i(208242);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "start VoIP, userName: %s, isOutCall: %b, isVideoCall: %b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
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
      j = com.tencent.mm.plugin.voip.b.j.ay(paramBoolean1, paramBoolean2);
      i = j;
      if (this.AzJ)
      {
        if (j != 0) {
          break label530;
        }
        i = 1;
        com.tencent.mm.plugin.voip.c.ehb().Sm(1);
      }
      if (!paramBoolean1) {
        break label550;
      }
      this.Azy = com.tencent.mm.plugin.voip.b.j.ST(i);
      this.Azx.Azy = this.Azy;
      bool1 = com.tencent.mm.compatible.d.b.Yy();
      bool2 = com.tencent.mm.compatible.d.b.Yz();
      if (Build.MANUFACTURER.equalsIgnoreCase("meizu"))
      {
        if (!bool1)
        {
          localObject1 = com.tencent.mm.plugin.report.service.h.wUl;
          if (!this.AzI) {
            break label562;
          }
          i = 0;
          ((com.tencent.mm.plugin.report.service.h)localObject1).f(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
        }
        if (!bool2)
        {
          localObject1 = com.tencent.mm.plugin.report.service.h.wUl;
          if (!this.AzI) {
            break label568;
          }
          i = 0;
          ((com.tencent.mm.plugin.report.service.h)localObject1).f(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
        }
      }
      if ((!bool2) || (!bool1))
      {
        if ((bool1) || (bool2)) {
          break label574;
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
          AppMethodBeat.i(208233);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "show Permission settings");
          com.tencent.mm.compatible.d.b.cb(paramContext);
          if (!NewVoipMgr.d(NewVoipMgr.this))
          {
            if (NewVoipMgr.f(NewVoipMgr.this))
            {
              NewVoipMgr.this.eho();
              AppMethodBeat.o(208233);
              return;
            }
            NewVoipMgr.this.ehr();
            AppMethodBeat.o(208233);
            return;
          }
          if (NewVoipMgr.f(NewVoipMgr.this))
          {
            NewVoipMgr.this.eht();
            AppMethodBeat.o(208233);
            return;
          }
          NewVoipMgr.this.ehu();
          AppMethodBeat.o(208233);
        }
      });
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "initMgr");
      com.tencent.mm.booter.a.Uc().Ue();
      if (this.AzI)
      {
        com.tencent.mm.plugin.voip.c.ehb().b(true, true, this.foE);
        label439:
        if (!this.AzH) {
          break label659;
        }
        com.tencent.mm.plugin.voip.c.ehb().AEF.ekg();
        if (!this.AzI) {
          break label641;
        }
      }
      label641:
      for (i = com.tencent.mm.plugin.voip.c.ehb().ayy(this.AzG.field_username);; i = com.tencent.mm.plugin.voip.c.ehb().ayx(this.AzG.field_username))
      {
        if (i >= 0) {
          break label659;
        }
        gb(false);
        i = 0;
        if (i != 0)
        {
          this.Azx.av(paramBoolean2, paramBoolean1);
          com.tencent.mm.plugin.voip.c.ehb().i(paramString, this.AzI, false);
        }
        AppMethodBeat.o(208242);
        return;
        bool1 = false;
        break;
        label530:
        i = j;
        if (256 != j) {
          break label194;
        }
        i = 257;
        break label194;
        label550:
        this.Azy = com.tencent.mm.plugin.voip.b.j.SS(i);
        break label214;
        label562:
        i = 1;
        break label267;
        label568:
        i = 1;
        break label314;
        label574:
        if (!bool1)
        {
          localObject1 = paramContext.getString(2131764922);
          localObject2 = paramContext.getString(2131764888);
          break label379;
        }
        if (bool2) {
          break label1129;
        }
        localObject1 = paramContext.getString(2131764921);
        localObject2 = paramContext.getString(2131764889);
        break label379;
        com.tencent.mm.plugin.voip.c.ehb().b(true, false, this.foE);
        break label439;
      }
      label659:
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
              label805:
              ((List)localObject2).add(0, this.foE);
            }
            localObject2 = bs.n((List)localObject2, ";");
            ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
            label848:
            com.tencent.mm.sdk.b.a.GpY.c(this.AAL);
            com.tencent.mm.sdk.b.a.GpY.c(this.tHj);
            this.AzU.a(this);
            paramContext = new IntentFilter();
            paramContext.addAction("android.intent.action.SCREEN_ON");
            paramContext.addAction("android.intent.action.SCREEN_OFF");
            paramContext.addAction("android.intent.action.USER_PRESENT");
            com.tencent.mm.sdk.platformtools.ai.getContext().registerReceiver(this.AAI, paramContext);
            this.oUL = new SensorController(getContext());
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "initMgr setSensorCallBack");
            this.oUL.a(this);
            if (this.oUK == null)
            {
              this.oUK = new com.tencent.mm.sdk.platformtools.bj(getContext());
              paramContext = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(208234);
                  NewVoipMgr.a(NewVoipMgr.this, bs.Gn());
                  AppMethodBeat.o(208234);
                }
              };
              if (!this.oUK.aE(paramContext)) {
                break label1119;
              }
            }
          }
        }
      }
      label1119:
      for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
      {
        i = k;
        if (!this.AzI) {
          break;
        }
        this.Azz = new com.tencent.mm.plugin.voip.video.render.h(this, this.AzH);
        this.AAH = new com.tencent.mm.plugin.voip.b.g();
        i = k;
        break;
        if (4 != i) {
          break label805;
        }
        ((List)localObject2).remove(i - 1);
        break label805;
        localObject2 = new ArrayList();
        ((List)localObject2).add(0, this.foE);
        localObject2 = bs.n((List)localObject2, ";");
        ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
        break label848;
      }
      label1129:
      localObject2 = null;
      localObject1 = null;
    }
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    AppMethodBeat.i(208262);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onVoipUIDestroy");
    if (this.AzA == paramb)
    {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Voip.NewVoipMgr", "same VoipUI, clear it");
      this.AzA = null;
      this.Azx.b(null);
    }
    if (this.jdu != null) {
      this.jdu = null;
    }
    AppMethodBeat.o(208262);
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb, int paramInt)
  {
    AppMethodBeat.i(208255);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onVoipUICreated, uiType: %s,  mVoicePlayDevice: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.AzM) });
    if ((1 == paramInt) && (this.AzA != null)) {
      this.AzA.uninit();
    }
    this.AzA = paramb;
    this.mUIType = paramInt;
    this.Azx.b(this.AzA);
    this.AzA.ih(-1, this.Azy.mState);
    this.AzA.setConnectSec(this.AzN);
    this.AzA.SF(this.AAj);
    AppMethodBeat.o(208255);
  }
  
  public final void a(VoIPRenderSurfaceView paramVoIPRenderSurfaceView)
  {
    AppMethodBeat.i(208269);
    if (this.Azz != null)
    {
      com.tencent.mm.plugin.voip.video.render.h localh = this.Azz;
      if (paramVoIPRenderSurfaceView != null) {
        paramVoIPRenderSurfaceView.eno();
      }
      localh.ASp = false;
      localh.ASk = false;
    }
    AppMethodBeat.o(208269);
  }
  
  public final void a(VoIPRenderSurfaceView paramVoIPRenderSurfaceView, int paramInt)
  {
    AppMethodBeat.i(208268);
    if (this.Azz != null)
    {
      com.tencent.mm.plugin.voip.b.g.SO(0);
      Object localObject1 = this.Azz;
      d.g.b.k.h(paramVoIPRenderSurfaceView, "view");
      if (!((com.tencent.mm.plugin.voip.video.render.h)localObject1).ASp)
      {
        ((com.tencent.mm.plugin.voip.video.render.h)localObject1).ASp = true;
        Object localObject2 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).ASl;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.d)localObject2).G((d.g.a.a)new h.f((com.tencent.mm.plugin.voip.video.render.h)localObject1));
        }
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).ASm;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.b)localObject2).ARw = ((d.g.a.a)new h.g((com.tencent.mm.plugin.voip.video.render.h)localObject1));
        }
      }
      localObject1 = (h.b)new h.h((com.tencent.mm.plugin.voip.video.render.h)localObject1);
      d.g.b.k.h(localObject1, "listener");
      paramVoIPRenderSurfaceView.ASH = ((h.b)localObject1);
      paramVoIPRenderSurfaceView.ASI = paramInt;
      paramVoIPRenderSurfaceView.getHolder().addCallback(paramVoIPRenderSurfaceView.ASG);
    }
    AppMethodBeat.o(208268);
  }
  
  public final void a(VoIPRenderTextureView paramVoIPRenderTextureView)
  {
    AppMethodBeat.i(208270);
    if (this.Azz != null)
    {
      com.tencent.mm.plugin.voip.video.render.h localh = this.Azz;
      if (paramVoIPRenderTextureView != null)
      {
        paramVoIPRenderTextureView.setSurfaceTextureListener(null);
        h.b localb = paramVoIPRenderTextureView.ASH;
        if (localb != null) {
          localb.Tf(paramVoIPRenderTextureView.ASI);
        }
        paramVoIPRenderTextureView.ASH = null;
      }
      localh.ASp = false;
      localh.ASk = false;
    }
    AppMethodBeat.o(208270);
  }
  
  public final void a(VoIPRenderTextureView paramVoIPRenderTextureView, int paramInt)
  {
    AppMethodBeat.i(208266);
    if (this.Azz != null)
    {
      com.tencent.mm.plugin.voip.b.g.SO(1);
      Object localObject1 = this.Azz;
      d.g.b.k.h(paramVoIPRenderTextureView, "view");
      if (!((com.tencent.mm.plugin.voip.video.render.h)localObject1).ASp)
      {
        ((com.tencent.mm.plugin.voip.video.render.h)localObject1).ASp = true;
        Object localObject2 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).ASl;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.d)localObject2).G((d.g.a.a)new h.c((com.tencent.mm.plugin.voip.video.render.h)localObject1));
        }
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).ASm;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.b)localObject2).ARw = ((d.g.a.a)new h.d((com.tencent.mm.plugin.voip.video.render.h)localObject1));
        }
      }
      localObject1 = (h.b)new h.e((com.tencent.mm.plugin.voip.video.render.h)localObject1);
      d.g.b.k.h(localObject1, "listener");
      paramVoIPRenderTextureView.ASH = ((h.b)localObject1);
      paramVoIPRenderTextureView.ASI = paramInt;
      paramVoIPRenderTextureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new VoIPRenderTextureView.b(paramVoIPRenderTextureView));
    }
    AppMethodBeat.o(208266);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void a(final int[] paramArrayOfInt, final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(208319);
    if ((this.Azz != null) && (!this.Azz.ADV))
    {
      this.Azz.enm();
      this.Azz.ADV = true;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208226);
        if (NewVoipMgr.a(NewVoipMgr.this) != null)
        {
          com.tencent.mm.plugin.voip.video.h localh = NewVoipMgr.a(NewVoipMgr.this).ASi;
          if (localh != null) {
            localh.emz();
          }
        }
        if (NewVoipMgr.o(NewVoipMgr.this) != null) {
          NewVoipMgr.o(NewVoipMgr.this);
        }
        AppMethodBeat.o(208226);
      }
    });
    AppMethodBeat.o(208319);
  }
  
  public final void ap(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(208267);
    if (this.AAH != null)
    {
      com.tencent.mm.plugin.voip.b.g localg = this.AAH;
      long l = bs.Gn();
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          localg.AMl = l;
          AppMethodBeat.o(208267);
          return;
        }
        localg.AMj = l;
        AppMethodBeat.o(208267);
        return;
      }
      if (paramBoolean2)
      {
        localg.AMm = l;
        AppMethodBeat.o(208267);
        return;
      }
      localg.AMk = l;
    }
    AppMethodBeat.o(208267);
  }
  
  public final void ayu(String paramString)
  {
    AppMethodBeat.i(208284);
    if (this.AzA != null)
    {
      this.AAf = paramString;
      this.AzA.ayA(paramString);
    }
    AppMethodBeat.o(208284);
  }
  
  public final void bVs() {}
  
  public final void cTN()
  {
    AppMethodBeat.i(208286);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "on accept");
    ehD();
    tg(4100);
    AppMethodBeat.o(208286);
  }
  
  public final void cTT()
  {
    AppMethodBeat.i(208307);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onNetWorkChangeMobileNet");
    if (this.AzA != null) {
      this.AzA.ela();
    }
    AppMethodBeat.o(208307);
  }
  
  public final void cTU()
  {
    AppMethodBeat.i(208308);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onResumeGoodNetStatus");
    if (this.AzA != null) {
      this.AzA.cVN();
    }
    AppMethodBeat.o(208308);
  }
  
  public final void d(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(208296);
    if (this.Azz != null)
    {
      Object localObject1 = this.Azz;
      d.g.b.k.h(paramArrayOfByte, "outData");
      localObject1 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).ASm;
      if (localObject1 != null)
      {
        int i = OpenGlRender.FLAG_YV12Edge;
        int j = OpenGlRender.FLAG_Angle90;
        d.g.b.k.h(paramArrayOfByte, "pBuff");
        if (((com.tencent.mm.plugin.voip.video.render.b)localObject1).APu != null)
        {
          Object localObject2 = ((com.tencent.mm.plugin.voip.video.render.b)localObject1).ARD;
          if (localObject2 != null)
          {
            d.g.b.k.h(paramArrayOfByte, "pBuff");
            localObject2 = ((com.tencent.mm.plugin.voip.video.render.j)localObject2).ASY;
            d.g.b.k.h(paramArrayOfByte, "pBuff");
            localObject2 = ((com.tencent.mm.plugin.voip.video.c.d)localObject2).ARo;
            if (localObject2 != null)
            {
              d.g.b.k.h(paramArrayOfByte, "pBuff");
              if (((com.tencent.mm.plugin.voip.video.c.g)localObject2).AOj == null)
              {
                ((com.tencent.mm.plugin.voip.video.c.g)localObject2).mWidth = paramInt1;
                ((com.tencent.mm.plugin.voip.video.c.g)localObject2).mHeight = paramInt2;
                ((com.tencent.mm.plugin.voip.video.c.g)localObject2).vxT = (i + j);
                ((com.tencent.mm.plugin.voip.video.c.g)localObject2).AOj = paramArrayOfByte;
              }
            }
          }
          paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.render.b)localObject1).APu;
          if (paramArrayOfByte == null) {
            d.g.b.k.fOy();
          }
          ((com.tencent.mm.plugin.voip.video.render.k)localObject1).b(paramArrayOfByte);
        }
      }
      if (this.AzA != null) {
        this.AzA.ekY();
      }
    }
    AppMethodBeat.o(208296);
  }
  
  public final void dgi()
  {
    AppMethodBeat.i(208279);
    if (this.AzA != null) {
      this.AzA.dgi();
    }
    AppMethodBeat.o(208279);
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
  
  public final void ehA()
  {
    AppMethodBeat.i(208271);
    if (this.Azz != null)
    {
      Object localObject1 = this.Azz;
      com.tencent.mm.sdk.platformtools.ac.m("MicroMsg.VoIPRenderMgr", "onRender Mode changed", new Object[0]);
      if (!((com.tencent.mm.plugin.voip.video.render.h)localObject1).AJj) {}
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.voip.video.render.h)localObject1).AJj = bool;
        Object localObject2 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).ASl;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.d)localObject2).enf();
        }
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).ASm;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.k)localObject2).enf();
        }
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).ASl;
        if (localObject2 != null)
        {
          com.tencent.mm.sdk.platformtools.ac.m("MicroMsg.LocalWindowsSurfaceRenderer", "switchRenderSurface", new Object[0]);
          com.tencent.mm.plugin.voip.video.render.k localk = ((com.tencent.mm.plugin.voip.video.render.d)localObject2).ARN;
          if (localk != null) {
            localk.enc();
          }
          localObject2 = ((com.tencent.mm.plugin.voip.video.render.d)localObject2).ARM;
          if (localObject2 != null) {
            ((f)localObject2).enc();
          }
        }
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).ASm;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.k)localObject2).enc();
        }
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).ASl;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.d)localObject2).ene();
        }
        localObject1 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).ASm;
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.plugin.voip.video.render.k)localObject1).ene();
        AppMethodBeat.o(208271);
        return;
      }
    }
    AppMethodBeat.o(208271);
  }
  
  public final void ehB()
  {
    AppMethodBeat.i(208273);
    if (this.Azz != null) {
      this.Azz.ie(this.AAu, this.AAv);
    }
    AppMethodBeat.o(208273);
  }
  
  public final void ehC()
  {
    AppMethodBeat.i(208275);
    this.AAH.SN(1);
    AppMethodBeat.o(208275);
  }
  
  public final void ehD()
  {
    AppMethodBeat.i(208276);
    if (this.Azx != null)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "use audioManager to stop voip ring");
      this.Azx.ehD();
      AppMethodBeat.o(208276);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "use Subcore to stop voip ring");
    com.tencent.mm.plugin.voip.c.ehb().AEF.stopRing();
    AppMethodBeat.o(208276);
  }
  
  public final boolean ehE()
  {
    AppMethodBeat.i(208277);
    if (com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId == 0)
    {
      this.AzL = true;
      AppMethodBeat.o(208277);
      return true;
    }
    boolean bool = ehF();
    AppMethodBeat.o(208277);
    return bool;
  }
  
  public final void ehG()
  {
    AppMethodBeat.i(208280);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onRoomReady");
    if ((this.AzL) && (com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId != 0))
    {
      this.AzL = false;
      ehF();
    }
    if (this.AzH) {
      tg(4097);
    }
    AppMethodBeat.o(208280);
  }
  
  public final void ehJ()
  {
    AppMethodBeat.i(208291);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onNoResp");
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
      AppMethodBeat.o(208291);
      return;
      str1 = bo.GYO;
      break;
    }
  }
  
  public final void ehK()
  {
    int j = 0;
    AppMethodBeat.i(208293);
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
        break label198;
      }
    }
    label198:
    for (int i = j;; i = 1)
    {
      com.tencent.mm.plugin.voip.b.d.c(k, l1, i, 3);
      this.AAA.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(208212);
          NewVoipMgr.a(NewVoipMgr.this, NewVoipMgr.h(NewVoipMgr.this));
          NewVoipMgr.q(NewVoipMgr.this).postDelayed(this, 5000L);
          AppMethodBeat.o(208212);
        }
      });
      AppMethodBeat.o(208293);
      return;
      i = 1;
      break;
    }
  }
  
  public final void ehL()
  {
    int j = 0;
    AppMethodBeat.i(208294);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onShutDown");
    String str1;
    String str2;
    label99:
    label108:
    int k;
    label156:
    long l;
    if (com.tencent.mm.plugin.voip.b.j.SU(this.Azy.mState))
    {
      str1 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764803, new Object[] { qn(bs.pN(this.AzN)) });
      if ((this.AzH) || (com.tencent.mm.plugin.voip.b.j.SU(this.Azy.mState)))
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
      this.AzE = com.tencent.mm.plugin.voip.b.j.SU(this.Azy.mState);
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
      AppMethodBeat.o(208294);
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
    AppMethodBeat.i(208302);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Voip.NewVoipMgr", "onPretreatmentForStartDev");
    this.Azx.au(this.AAe, this.AzI);
    AppMethodBeat.o(208302);
  }
  
  public final long ehN()
  {
    AppMethodBeat.i(208303);
    com.tencent.mm.sdk.platformtools.ac.m("MicroMsg.Voip.NewVoipMgr", "totalDeviceNearTime: %s", new Object[] { Long.valueOf(this.AAm) });
    long l = this.AAm / 1000L;
    AppMethodBeat.o(208303);
    return l;
  }
  
  public final void ehR()
  {
    AppMethodBeat.i(208315);
    if ((256 != this.Azy.mState) && (257 != this.Azy.mState))
    {
      AppMethodBeat.o(208315);
      return;
    }
    if ((com.tencent.mm.kernel.g.agR().agA().getInt(327945, 0) == 0) && (this.AzA.ekX() != null))
    {
      com.tencent.mm.kernel.g.agR().agA().setInt(327945, 1);
      com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.a(this.AzA.ekX(), 2131764868, 2131755906, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(208223);
          NewVoipMgr.this.ehT();
          AppMethodBeat.o(208223);
        }
      });
      locald.setCancelable(false);
      locald.setCanceledOnTouchOutside(false);
      locald.show();
      AppMethodBeat.o(208315);
      return;
    }
    com.tencent.mm.plugin.voip.b.l.gC(com.tencent.mm.sdk.platformtools.ai.getContext());
    ehT();
    AppMethodBeat.o(208315);
  }
  
  public final void ehS()
  {
    AppMethodBeat.i(208316);
    if (!this.AzW) {}
    for (boolean bool = true;; bool = false)
    {
      this.AzW = bool;
      if (!this.AzW) {
        break;
      }
      this.AzV.stopTimer();
      AppMethodBeat.o(208316);
      return;
    }
    if (this.AzV == null) {
      this.AzV = new au("faceDetect", new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(208225);
          NewVoipMgr.I(NewVoipMgr.this);
          AppMethodBeat.o(208225);
          return true;
        }
      }, true);
    }
    this.AzV.au(2000L, 2000L);
    this.AzW = false;
    AppMethodBeat.o(208316);
  }
  
  public final void ehT()
  {
    AppMethodBeat.i(208317);
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
            AppMethodBeat.i(208224);
            NewVoipMgr.H(NewVoipMgr.this);
            AppMethodBeat.o(208224);
          }
        }, 2000L);
      }
      AppMethodBeat.o(208317);
      return;
      str1 = bo.GYO;
      break;
    }
  }
  
  public final boolean ehm()
  {
    AppMethodBeat.i(208247);
    if (!this.Azy.SY(4103))
    {
      AppMethodBeat.o(208247);
      return false;
    }
    RV(4103);
    com.tencent.mm.plugin.voip.c.ehb().ejY();
    AppMethodBeat.o(208247);
    return true;
  }
  
  public final boolean ehn()
  {
    AppMethodBeat.i(208248);
    if (!this.Azy.SY(4101))
    {
      AppMethodBeat.o(208248);
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
      AppMethodBeat.o(208248);
      return true;
    }
  }
  
  public final boolean eho()
  {
    int i = 0;
    AppMethodBeat.i(208249);
    if (!this.Azy.SY(4099))
    {
      AppMethodBeat.o(208249);
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
      AppMethodBeat.o(208249);
      return true;
    }
  }
  
  public final boolean ehp()
  {
    AppMethodBeat.i(208250);
    if (!this.Azy.SY(4100))
    {
      AppMethodBeat.o(208250);
      return false;
    }
    if (this.Azz != null) {
      this.Azz.enm();
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onAcceptVideoInvite");
    ehD();
    com.tencent.mm.plugin.voip.c.ehb().ar(false, this.AzI);
    tg(4100);
    AppMethodBeat.o(208250);
    return true;
  }
  
  public final void ehq()
  {
    if (this.Azz != null) {
      this.Azz.ADV = false;
    }
  }
  
  public final boolean ehr()
  {
    int i = 0;
    AppMethodBeat.i(208251);
    if (!this.Azy.SY(4099))
    {
      AppMethodBeat.o(208251);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onRejectVoiceInvite");
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
      AppMethodBeat.o(208251);
      return true;
    }
  }
  
  public final boolean ehs()
  {
    AppMethodBeat.i(208252);
    if (!this.Azy.SY(4100))
    {
      AppMethodBeat.o(208252);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onAcceptVoiceInvite");
    ehD();
    com.tencent.mm.plugin.voip.c.ehb().ar(true, this.AzI);
    tg(4111);
    tg(4100);
    AppMethodBeat.o(208252);
    return true;
  }
  
  public final boolean eht()
  {
    AppMethodBeat.i(208253);
    if (!this.Azy.SY(4098))
    {
      AppMethodBeat.o(208253);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onCancelVideoInvite");
    RV(4098);
    com.tencent.mm.plugin.voip.c.ehb().ejY();
    AppMethodBeat.o(208253);
    return true;
  }
  
  public final boolean ehu()
  {
    AppMethodBeat.i(208254);
    if (!this.Azy.SY(4098))
    {
      AppMethodBeat.o(208254);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onCancelVoiceInvite");
    RV(4098);
    com.tencent.mm.plugin.voip.c.ehb().ejY();
    AppMethodBeat.o(208254);
    return true;
  }
  
  public final void ehv()
  {
    boolean bool2 = true;
    AppMethodBeat.i(208256);
    if ((this.AzI) && (this.Azz != null))
    {
      com.tencent.mm.plugin.voip.video.render.h localh = this.Azz;
      Object localObject1 = localh.ASi;
      if ((localObject1 != null) && (localh.ASl != null))
      {
        Object localObject2 = localh.ASl;
        if (localObject2 == null) {
          d.g.b.k.fOy();
        }
        if (((com.tencent.mm.plugin.voip.video.render.d)localObject2).ARM != null)
        {
          ((com.tencent.mm.plugin.voip.video.h)localObject1).AMU = false;
          localObject1 = localh.ASl;
          if (localObject1 == null) {
            d.g.b.k.fOy();
          }
          localObject1 = ((com.tencent.mm.plugin.voip.video.render.d)localObject1).ARM;
          if (localObject1 == null) {
            d.g.b.k.fOy();
          }
          localObject2 = localh.ASi;
          if (localObject2 == null) {
            break label195;
          }
          bool1 = ((com.tencent.mm.plugin.voip.video.h)localObject2).emq();
          localh.d((f)localObject1, bool1);
        }
      }
    }
    if ((this.AzH) && (com.tencent.mm.plugin.voip.b.j.SW(this.Azy.mState)) && (com.tencent.mm.plugin.voip.c.ehb().AEF.bVB()))
    {
      this.Azx.av(this.AzI, this.AzH);
      if (this.AzM != 1) {
        break label200;
      }
    }
    label195:
    label200:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      su(bool1);
      AppMethodBeat.o(208256);
      return;
      bool1 = true;
      break;
    }
  }
  
  public final void ehw()
  {
    AppMethodBeat.i(208258);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "it is init voip report");
    this.AAy = new NetChangedBroadcastReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    com.tencent.mm.sdk.platformtools.ai.getContext().registerReceiver(this.AAy, localIntentFilter);
    this.ouQ = ((TelephonyManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("phone"));
    this.AAw = com.tencent.mm.plugin.voip.b.d.getNetType(getContext());
    this.AAz = new NewVoipMgr.16(this);
    this.ouQ.listen(this.AAz, 256);
    AppMethodBeat.o(208258);
  }
  
  public final void ehx()
  {
    AppMethodBeat.i(208260);
    if ((this.uKQ) || (this.AzA == null) || (this.AzA.ekX() == null) || (this.Azz == null) || (this.Azz.ASi == null))
    {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, already show");
      AppMethodBeat.o(208260);
      return;
    }
    if (this.Azz.ASi.cDz())
    {
      AppMethodBeat.o(208260);
      return;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("meizu")) && (!com.tencent.mm.compatible.d.b.Yz()))
    {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, meizu machine");
      AppMethodBeat.o(208260);
      return;
    }
    if ((com.tencent.mm.compatible.util.d.kZ(28)) && (((KeyguardManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "api level: %s, in keyguard, ignore", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(208260);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, show dialog");
    com.tencent.mm.plugin.report.service.h.wUl.f(11306, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.l(this.AzA.ekX(), 2131764896, 2131755906);
    if (locald == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.Voip.NewVoipMgr", "new dialog failed");
      AppMethodBeat.o(208260);
      return;
    }
    locald.setCancelable(false);
    locald.setCanceledOnTouchOutside(false);
    locald.show();
    this.uKQ = true;
    com.tencent.mm.plugin.voip.b.g.elT();
    AppMethodBeat.o(208260);
  }
  
  public final void ehy()
  {
    AppMethodBeat.i(208263);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onSwitchCamera");
    com.tencent.mm.plugin.voip.video.render.h localh;
    Object localObject;
    int i;
    if (this.Azz != null)
    {
      localh = this.Azz;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VoIPRenderMgr", "onSwitchCamera");
      if (localh.ASi != null)
      {
        localObject = localh.ASi;
        if (localObject == null) {
          d.g.b.k.fOy();
        }
        if (((com.tencent.mm.plugin.voip.video.h)localObject).emw() != null)
        {
          localObject = localh.ASi;
          if (localObject != null) {
            ((com.tencent.mm.plugin.voip.video.h)localObject).emn();
          }
          localObject = localh.ASi;
          if (localObject == null) {
            d.g.b.k.fOy();
          }
          localObject = ((com.tencent.mm.plugin.voip.video.h)localObject).emw();
          d.g.b.k.g(localObject, "newCaptureRender!!.previewSize");
          com.tencent.mm.plugin.voip.video.h localh1 = localh.ASi;
          if (localh1 == null) {
            d.g.b.k.fOy();
          }
          i = localh1.emx();
          localh1 = localh.ASi;
          if (localh1 == null) {
            d.g.b.k.fOy();
          }
          if (localh1.emy()) {
            break label189;
          }
        }
      }
    }
    label189:
    for (boolean bool = true;; bool = false)
    {
      localh.a((com.tencent.mm.compatible.deviceinfo.ac)localObject, i, bool);
      com.tencent.mm.plugin.report.service.h.wUl.f(11079, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(208263);
      return;
    }
  }
  
  public final void ehz()
  {
    AppMethodBeat.i(208264);
    if ((this.Azz != null) && (this.Azz.ASi != null) && (true != this.Azz.ASi.emq())) {
      ehy();
    }
    AppMethodBeat.o(208264);
  }
  
  public final int getState()
  {
    return this.Azy.mState;
  }
  
  public final String getUserName()
  {
    return this.foE;
  }
  
  public final void id(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208259);
    if (this.AzA != null) {
      this.AzA.ekZ();
    }
    if (this.AzU != null) {
      this.AzU.setPreviewSize(paramInt1, paramInt2);
    }
    AppMethodBeat.o(208259);
  }
  
  public final void ie(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208299);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "adjustHWViewAspectRatio, HWDecsize:%dx%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.AAu = paramInt1;
    this.AAv = paramInt2;
    if (this.Azz != null) {
      this.Azz.ie(paramInt1, paramInt2);
    }
    AppMethodBeat.o(208299);
  }
  
  public final void kc(boolean paramBoolean)
  {
    AppMethodBeat.i(208244);
    com.tencent.mm.sdk.platformtools.ac.m("MicroMsg.Voip.NewVoipMgr", "onSensorEvent, isON: %s, lastIsDeviceNear: %s, deviceSwitchNearScreenTick: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.AAl), Long.valueOf(this.AAk) });
    if (this.Azy == null)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent, not create stateMachine yet, ignore");
      AppMethodBeat.o(208244);
      return;
    }
    if (this.oUJ)
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.oUJ = paramBoolean;
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent has skip and val is %s", new Object[] { Boolean.valueOf(this.oUJ) });
        AppMethodBeat.o(208244);
        return;
      }
    }
    if ((Math.abs(bs.Gn() - this.AAn) < 500L) && (this.AAn != -1L))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent time interval too small");
      AppMethodBeat.o(208244);
      return;
    }
    if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pZQ, true)) && (!paramBoolean) && (this.lastShakeTime != -1L) && (bs.aO(this.lastShakeTime) > 400L))
    {
      this.oUJ = true;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent has skip case shake near to small");
      AppMethodBeat.o(208244);
      return;
    }
    this.oUJ = false;
    if ((com.tencent.mm.plugin.voip.b.j.SU(this.Azy.mState)) && ((this.AAl != paramBoolean) || (this.AAk == -1L)))
    {
      if ((!this.AAl) && (paramBoolean) && (!com.tencent.mm.plugin.voip.b.j.SV(this.Azy.mState)) && (this.mUIType != 2) && (this.AAk != -1L))
      {
        long l = bs.aO(this.AAk);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "accumulate near screen time: %s", new Object[] { Long.valueOf(l) });
        this.AAm += l;
      }
      this.AAk = bs.Gn();
      this.AAl = paramBoolean;
    }
    if (this.AzA == null)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent, voipUI is null, ignore");
      AppMethodBeat.o(208244);
      return;
    }
    if (((this.AzH) || (com.tencent.mm.plugin.voip.b.j.SU(this.Azy.mState))) && (!com.tencent.mm.plugin.voip.b.j.SV(this.Azy.mState)) && (this.mUIType != 2))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent, isOn: ".concat(String.valueOf(paramBoolean)));
      this.AzA.setScreenEnable(paramBoolean);
      this.AzC = paramBoolean;
      this.AAn = bs.Gn();
    }
    AppMethodBeat.o(208244);
  }
  
  public final void ne(boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(208306);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onBadNetStatus");
    if (this.AzA != null) {
      this.AzA.sI(paramBoolean);
    }
    long l;
    if ((!com.tencent.mm.plugin.voip.b.j.SV(this.Azy.mState)) && (!this.Azx.isSpeakerphoneOn()))
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
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", i);
      localObject = com.tencent.mm.plugin.report.service.h.wUl;
      l = com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.tIG;
      i = j;
      if (paramBoolean) {
        i = 1;
      }
      ((com.tencent.mm.plugin.report.service.h)localObject).a(17151, true, true, new Object[] { Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(208306);
      return;
    }
  }
  
  public final void nm(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(208274);
    if ((this.Azz != null) && (this.AAa != paramInt) && ((paramInt == 0) || (paramInt == 180)))
    {
      this.AAa = paramInt;
      Object localObject1 = this.Azz.ASl;
      if (localObject1 != null)
      {
        Object localObject2 = ((com.tencent.mm.plugin.voip.video.render.d)localObject1).ARN;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.voip.video.render.b)localObject2).ARD;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.voip.video.render.j)localObject2).mE(paramInt);
          }
        }
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.d)localObject1).ARM;
        if (localObject2 != null)
        {
          if (((f)localObject2).ASe == null)
          {
            localObject1 = ((f)localObject2).ARV;
            if (localObject1 != null)
            {
              localObject1 = Integer.valueOf(((com.tencent.mm.media.i.b.a)localObject1).gVh);
              ((f)localObject2).ASe = ((Integer)localObject1);
            }
          }
          else
          {
            if (((f)localObject2).eng() != 0) {
              break label190;
            }
            localObject1 = ((f)localObject2).ARV;
            if (localObject1 == null) {
              break label183;
            }
            localObject2 = ((f)localObject2).ASe;
            if (localObject2 == null) {
              break label178;
            }
          }
          label178:
          for (i = ((Integer)localObject2).intValue();; i = 0)
          {
            ((com.tencent.mm.plugin.voip.video.render.i)localObject1).mE(i + paramInt);
            AppMethodBeat.o(208274);
            return;
            localObject1 = null;
            break;
          }
          label183:
          AppMethodBeat.o(208274);
          return;
          label190:
          localObject1 = ((f)localObject2).ARV;
          if (localObject1 != null)
          {
            localObject2 = ((f)localObject2).ASe;
            paramInt = i;
            if (localObject2 != null) {
              paramInt = ((Integer)localObject2).intValue();
            }
            ((com.tencent.mm.plugin.voip.video.render.i)localObject1).mE(paramInt);
            AppMethodBeat.o(208274);
            return;
          }
          AppMethodBeat.o(208274);
          return;
        }
        AppMethodBeat.o(208274);
        return;
      }
    }
    AppMethodBeat.o(208274);
  }
  
  public final void om(boolean paramBoolean)
  {
    AppMethodBeat.i(208246);
    this.Azx.sO(paramBoolean);
    AppMethodBeat.o(208246);
  }
  
  public final void onConnected()
  {
    AppMethodBeat.i(208292);
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
    if (!com.tencent.mm.plugin.voip.b.j.SV(this.Azy.mState)) {
      com.tencent.mm.plugin.report.service.h.wUl.f(11080, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
    }
    bs.D(com.tencent.mm.sdk.platformtools.ai.getContext(), true);
    com.tencent.mm.plugin.voip.c.ehb().Sx(com.tencent.mm.plugin.voip.c.ehb().ejX());
    r.ejf().ejg();
    r.ejf().a(this);
    k localk = k.ABe;
    k.setRoomId(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId);
    AppMethodBeat.o(208292);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(208285);
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
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onError, errCode: %s, roomId: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.roomId) });
    paramString = com.tencent.mm.sdk.platformtools.ai.getContext();
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.Voip.NewVoipMgr", "getErrorMsgContent, errorCode".concat(String.valueOf(paramInt)));
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
      if (com.tencent.mm.plugin.voip.b.j.SU(this.Azy.mState)) {
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
        AppMethodBeat.o(208285);
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
      if (com.tencent.mm.plugin.voip.b.j.SU(this.Azy.mState)) {
        paramString = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764804, new Object[] { qn(bs.pN(this.AzN)) });
      }
      s.a(str2, str1, paramInt, 6, paramString, true);
      break;
      str1 = bo.GYO;
      break label466;
    }
  }
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture) {}
  
  public final void onReject()
  {
    AppMethodBeat.i(208287);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onReject");
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
      AppMethodBeat.o(208287);
      return;
      str1 = bo.GYO;
      break;
    }
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(208298);
    this.AAi = paramInt;
    if (this.Azz != null)
    {
      this.Azz.setHWDecMode(paramInt);
      if (this.AzA != null) {
        this.AzA.SE(paramInt);
      }
      if (this.AAH != null)
      {
        com.tencent.mm.plugin.voip.b.g localg = this.AAH;
        if ((paramInt & 0x1) != 0)
        {
          localg.AMf += 1L;
          AppMethodBeat.o(208298);
          return;
        }
        localg.AMg += 1L;
      }
    }
    AppMethodBeat.o(208298);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    this.AzM = paramInt;
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(208297);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "setVoIPBeauty, isON: " + paramInt + "，mVoipUI: " + this.AzA);
    if (this.Azz != null)
    {
      com.tencent.mm.plugin.voip.video.render.h localh = this.Azz;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.VoIPRenderMgr", "setVoIPBeauty, mIsStarted:%b, isON:%d", new Object[] { Boolean.valueOf(localh.mIsStarted), Integer.valueOf(paramInt) });
      localh.AAj = paramInt;
      com.tencent.mm.plugin.voip.video.render.d locald = localh.ASl;
      if (locald != null) {
        locald.Td(localh.AAj);
      }
    }
    if (this.AzA != null) {
      this.AzA.SF(paramInt);
    }
    if ((paramInt != 0) && (this.AAj != paramInt)) {
      com.tencent.mm.plugin.report.service.h.wUl.n(914L, 20L, 1L);
    }
    this.AAj = paramInt;
    AppMethodBeat.o(208297);
  }
  
  public final void sr(boolean paramBoolean)
  {
    AppMethodBeat.i(208243);
    int j = com.tencent.mm.plugin.voip.b.j.ay(false, paramBoolean);
    int i = j;
    if (this.AzJ)
    {
      if (j != 0) {
        break label80;
      }
      i = 1;
    }
    for (;;)
    {
      this.Azy = com.tencent.mm.plugin.voip.b.j.SS(i);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "steve:[simucall] resetStateMachine, initState:%d,isOutCall:%s,isVideoCall:%s", new Object[] { Integer.valueOf(i), Boolean.FALSE, Boolean.valueOf(paramBoolean) });
      this.AzH = false;
      AppMethodBeat.o(208243);
      return;
      label80:
      i = j;
      if (256 == j) {
        i = 257;
      }
    }
  }
  
  public final void su(boolean paramBoolean)
  {
    AppMethodBeat.i(208245);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Azx.cm(paramBoolean);
    this.Azx.ALV = true;
    AppMethodBeat.o(208245);
  }
  
  public final void sv(boolean paramBoolean)
  {
    AppMethodBeat.i(208272);
    if (this.Azz != null)
    {
      com.tencent.mm.plugin.voip.video.render.h localh = this.Azz;
      localh.AJj = paramBoolean;
      localh.setHWDecMode(localh.AJn);
    }
    AppMethodBeat.o(208272);
  }
  
  public final boolean sw(final boolean paramBoolean)
  {
    AppMethodBeat.i(208314);
    if (com.tencent.mm.plugin.voip.c.ehb().AEU)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "current state is mini, cannot mini!");
      AppMethodBeat.o(208314);
      return false;
    }
    if ((this.AAd) && (!paramBoolean))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "has phone call  cannot mini!");
      AppMethodBeat.o(208314);
      return false;
    }
    com.tencent.mm.sdk.platformtools.ac.l("MicroMsg.Voip.NewVoipMgr", "miniOnlyHidenVoip: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "onMinimizeVoip, async to minimize");
    if (this.AzA != null)
    {
      this.AzA.uninit();
      this.AzA = null;
      this.Azx.b(this.AzA);
    }
    this.hqp = bs.Gn();
    if (this.AAc != null) {
      this.AAc.uninit();
    }
    if (this.jdu != null) {
      this.jdu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(208222);
          NewVoipMgr.c(NewVoipMgr.this, paramBoolean);
          AppMethodBeat.o(208222);
        }
      });
    }
    AppMethodBeat.o(208314);
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
      AppMethodBeat.i(208240);
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
                AppMethodBeat.o(208240);
                return;
              } while (NewVoipMgr.h(NewVoipMgr.this) == 5);
              j = NewVoipMgr.ehV()[1];
              if (NewVoipMgr.i(NewVoipMgr.this) == 0) {
                NewVoipMgr.a(NewVoipMgr.this, 4);
              }
            } while (NewVoipMgr.i(NewVoipMgr.this) == 0);
            k = NewVoipMgr.ehW() / NewVoipMgr.i(NewVoipMgr.this);
            NewVoipMgr.a(NewVoipMgr.this, 5);
            m = NewVoipMgr.ehV()[0];
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "befor change to 4G and cost " + NewVoipMgr.j(NewVoipMgr.this));
            if (NewVoipMgr.d(NewVoipMgr.this)) {}
            for (;;)
            {
              com.tencent.mm.plugin.voip.b.d.a(i, System.currentTimeMillis(), NewVoipMgr.h(NewVoipMgr.this), 5, j, m, k);
              NewVoipMgr.k(NewVoipMgr.this);
              NewVoipMgr.b(NewVoipMgr.this, 5);
              NewVoipMgr.ehX();
              NewVoipMgr.l(NewVoipMgr.this);
              AppMethodBeat.o(208240);
              return;
              i = 1;
            }
          } while (NewVoipMgr.h(NewVoipMgr.this) == 4);
          k = NewVoipMgr.ehV()[0];
          if (NewVoipMgr.i(NewVoipMgr.this) == 0) {
            NewVoipMgr.a(NewVoipMgr.this, 5);
          }
        } while (NewVoipMgr.i(NewVoipMgr.this) == 0);
        int m = NewVoipMgr.ehW() / NewVoipMgr.i(NewVoipMgr.this);
        NewVoipMgr.a(NewVoipMgr.this, 4);
        int n = NewVoipMgr.ehV()[1];
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.Voip.NewVoipMgr", "befor change to wifi and cost " + NewVoipMgr.j(NewVoipMgr.this));
        if (NewVoipMgr.d(NewVoipMgr.this)) {}
        for (i = j;; i = 1)
        {
          com.tencent.mm.plugin.voip.b.d.a(i, System.currentTimeMillis(), NewVoipMgr.h(NewVoipMgr.this), 4, k, n, m);
          NewVoipMgr.k(NewVoipMgr.this);
          NewVoipMgr.b(NewVoipMgr.this, 4);
          NewVoipMgr.ehX();
          NewVoipMgr.l(NewVoipMgr.this);
          break;
        }
      }
      if ((paramIntent.getAction().equals("android.net.wifi.STATE_CHANGE")) && (NewVoipMgr.m(NewVoipMgr.this) == 0L))
      {
        NewVoipMgr.b(NewVoipMgr.this, System.currentTimeMillis());
        AppMethodBeat.o(208240);
        return;
      }
      if ((paramIntent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) && (NewVoipMgr.m(NewVoipMgr.this) != 0L))
      {
        NewVoipMgr.c(NewVoipMgr.this, System.currentTimeMillis() - NewVoipMgr.m(NewVoipMgr.this));
        NewVoipMgr.b(NewVoipMgr.this, 0L);
      }
      AppMethodBeat.o(208240);
    }
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(208239);
      NewVoipMgr.r(NewVoipMgr.this);
      NewVoipMgr.s(NewVoipMgr.this);
      AppMethodBeat.o(208239);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.NewVoipMgr
 * JD-Core Version:    0.7.0.1
 */