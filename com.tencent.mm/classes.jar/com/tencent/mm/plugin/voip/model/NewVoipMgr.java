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
import com.tencent.mm.g.a.wv;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.g.a.xy;
import com.tencent.mm.g.a.xy.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.voip.ui.VoipScoreDialog;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView.b;
import com.tencent.mm.plugin.voip.video.render.h.b;
import com.tencent.mm.plugin.voip.video.render.h.c;
import com.tencent.mm.plugin.voip.video.render.h.d;
import com.tencent.mm.plugin.voip.video.render.h.e;
import com.tencent.mm.plugin.voip.video.render.h.f;
import com.tencent.mm.plugin.voip.video.render.h.g;
import com.tencent.mm.plugin.voip.video.render.h.h;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class NewVoipMgr
  extends com.tencent.mm.plugin.voip.a
  implements com.tencent.mm.plugin.voip.video.render.a
{
  static int kxX = 0;
  static int[] zhS = new int[2];
  private long enterTime;
  private String flk;
  private long gPP;
  private ap iDu;
  PhoneStateListener klv;
  private long lastShakeTime;
  private boolean mIsMute;
  private int mUIType;
  TelephonyManager nRA;
  private boolean orj;
  private bk ork;
  private SensorController orl;
  private long rfP;
  private long sBL;
  private TelephonyManager szx;
  private com.tencent.mm.sdk.b.c szz;
  private boolean tCt;
  private com.tencent.mm.plugin.voip.b.b zgO;
  private com.tencent.mm.plugin.voip.b.j zgP;
  private com.tencent.mm.plugin.voip.video.render.h zgQ;
  private volatile com.tencent.mm.plugin.voip.ui.b zgR;
  private a zgS;
  private boolean zgT;
  private boolean zgU;
  private boolean zgV;
  private Object zgW;
  private af zgX;
  boolean zgY;
  private boolean zgZ;
  public int zhA;
  private long zhB;
  private boolean zhC;
  private long zhD;
  private long zhE;
  private long zhF;
  private long zhG;
  private int zhH;
  boolean zhI;
  boolean zhJ;
  private int zhK;
  public int zhL;
  public int zhM;
  int zhN;
  boolean zhO;
  NetChangedBroadcastReceiver zhP;
  PhoneStateListener zhQ;
  ap zhR;
  private long zhT;
  private boolean zhU;
  private int zhV;
  private int zhW;
  private com.tencent.mm.plugin.voip.b.f zhX;
  private BroadcastReceiver zhY;
  private BroadcastReceiver zhZ;
  private boolean zha;
  private int zhb;
  private boolean zhc;
  private int zhd;
  private long zhe;
  private boolean zhf;
  private boolean zhg;
  private boolean zhh;
  private boolean zhi;
  private int zhj;
  private int zhk;
  private com.tencent.mm.plugin.voip.video.k zhl;
  private av zhm;
  private boolean zhn;
  private boolean zho;
  private int zhp;
  private boolean zhq;
  private int zhr;
  private boolean zhs;
  private com.tencent.mm.plugin.voip.widget.b zht;
  private boolean zhu;
  private boolean zhv;
  private String zhw;
  private boolean zhx;
  private boolean zhy;
  public int zhz;
  int zia;
  private com.tencent.mm.sdk.b.c zib;
  
  public NewVoipMgr()
  {
    AppMethodBeat.i(191920);
    this.zgS = null;
    this.zgT = true;
    this.lastShakeTime = -1L;
    this.orj = false;
    this.zgU = false;
    this.zgV = false;
    this.zgW = new Object();
    this.zha = false;
    this.zhb = 4096;
    this.zhc = false;
    this.zhd = -1;
    this.mIsMute = false;
    this.zhe = -1L;
    this.zhf = false;
    this.zhg = false;
    this.zhh = false;
    this.tCt = false;
    this.zhi = false;
    this.zhj = 0;
    this.zhk = 0;
    this.zhl = new com.tencent.mm.plugin.voip.video.k();
    this.zhm = null;
    this.zhn = false;
    this.zho = false;
    this.zhp = 0;
    this.zhq = false;
    this.zhr = -1;
    this.zhs = false;
    this.zhu = false;
    this.zhv = false;
    this.zhw = null;
    this.zhx = true;
    this.zhy = false;
    this.zhz = -1;
    this.zhA = 0;
    this.zhB = -1L;
    this.zhC = false;
    this.zhD = 0L;
    this.zhE = -1L;
    this.zhF = 0L;
    this.zhG = 0L;
    this.zhH = 0;
    this.zhI = false;
    this.zhJ = false;
    this.zhK = 0;
    this.zhL = 0;
    this.zhM = 0;
    this.zhN = 0;
    this.zhO = false;
    this.zhR = new ap("getSignalStrength");
    this.nRA = null;
    this.rfP = 0L;
    this.zhT = 0L;
    this.zhU = false;
    this.zhV = 0;
    this.zhW = 0;
    this.zhY = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(191890);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        paramAnonymousIntent = (PowerManager)aj.getContext().getSystemService("power");
        if (("android.intent.action.USER_PRESENT".equals(paramAnonymousContext)) && (paramAnonymousIntent.isScreenOn()))
        {
          if (NewVoipMgr.a(NewVoipMgr.this) != null)
          {
            NewVoipMgr.a(NewVoipMgr.this).zhi = false;
            AppMethodBeat.o(191890);
          }
        }
        else
        {
          if ("android.intent.action.SCREEN_ON".equals(paramAnonymousContext))
          {
            if (NewVoipMgr.a(NewVoipMgr.this) != null) {
              NewVoipMgr.a(NewVoipMgr.this).zhi = false;
            }
            NewVoipMgr.this.jz(true);
            AppMethodBeat.o(191890);
            return;
          }
          if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousContext))
          {
            if (NewVoipMgr.a(NewVoipMgr.this) != null) {
              NewVoipMgr.a(NewVoipMgr.this).zhi = true;
            }
            if (!NewVoipMgr.b(NewVoipMgr.this)) {
              NewVoipMgr.this.jz(true);
            }
            if ((!com.tencent.mm.plugin.voip.b.i.QL(NewVoipMgr.c(NewVoipMgr.this).mState)) && (!NewVoipMgr.d(NewVoipMgr.this))) {
              com.tencent.mm.plugin.voip.c.dRQ().zlR.stopRing();
            }
          }
        }
        AppMethodBeat.o(191890);
      }
    };
    this.zhZ = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(191906);
        if ((paramAnonymousIntent.getAction().equals("com.tencent.mm.foregroundDestroy")) && (com.tencent.mm.plugin.voip.c.dRQ().cXd) && (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.poI, false))) {
          com.tencent.mm.plugin.voip.c.dRQ().h(NewVoipMgr.e(NewVoipMgr.this), NewVoipMgr.f(NewVoipMgr.this), true);
        }
        AppMethodBeat.o(191906);
      }
    };
    this.szz = new com.tencent.mm.sdk.b.c() {};
    this.zia = 0;
    this.sBL = 0L;
    this.klv = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        int i = 1;
        AppMethodBeat.i(191896);
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        ad.i("MicroMsg.Voip.NewVoipMgr", "onCallStateChanged :%d, isStartVoip: %b,oldState:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(NewVoipMgr.t(NewVoipMgr.this)), Integer.valueOf(NewVoipMgr.u(NewVoipMgr.this)) });
        if (!NewVoipMgr.t(NewVoipMgr.this))
        {
          AppMethodBeat.o(191896);
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
          com.tencent.mm.plugin.voip.c.dRQ().Qf(1);
          NewVoipMgr.b(NewVoipMgr.this, true);
        }
        label327:
        label361:
        do
        {
          NewVoipMgr.n(NewVoipMgr.this).zhU = NewVoipMgr.C(NewVoipMgr.this);
          AppMethodBeat.o(191896);
          return;
          if (paramAnonymousInt == 2)
          {
            NewVoipMgr.a(NewVoipMgr.this, false);
            if (NewVoipMgr.u(NewVoipMgr.this) == 1) {
              NewVoipMgr.e(NewVoipMgr.this, System.currentTimeMillis());
            }
            NewVoipMgr.c(NewVoipMgr.this, 2);
            ad.i("MicroMsg.Voip.NewVoipMgr", "phone call coming now!");
            if ((NewVoipMgr.d(NewVoipMgr.this)) && (!com.tencent.mm.plugin.voip.b.i.QL(NewVoipMgr.c(NewVoipMgr.this).mState))) {
              com.tencent.mm.plugin.voip.c.dRQ().zlR.dUW();
            }
            String str2;
            String str1;
            if (com.tencent.mm.plugin.voip.b.i.QL(NewVoipMgr.c(NewVoipMgr.this).mState))
            {
              paramAnonymousString = aj.getContext().getString(2131764803, new Object[] { NewVoipMgr.ul(bt.lZ(NewVoipMgr.w(NewVoipMgr.this))) });
              com.tencent.mm.plugin.voip.c.dRQ().dUx();
              str2 = NewVoipMgr.x(NewVoipMgr.this).field_username;
              if (!NewVoipMgr.f(NewVoipMgr.this)) {
                break label596;
              }
              str1 = bl.FzN;
              if (!NewVoipMgr.d(NewVoipMgr.this)) {
                break label604;
              }
            }
            for (paramAnonymousInt = i;; paramAnonymousInt = 0)
            {
              s.c(str2, str1, paramAnonymousInt, 6, paramAnonymousString);
              NewVoipMgr.d(NewVoipMgr.this, 4107);
              NewVoipMgr.y(NewVoipMgr.this);
              paramAnonymousString = new bl();
              paramAnonymousString.setType(10000);
              paramAnonymousString.kY(System.currentTimeMillis());
              paramAnonymousString.setStatus(6);
              paramAnonymousString.setContent(aj.getContext().getString(2131764801) + ", <a href=\"weixin://voip/callagain/?username=" + NewVoipMgr.e(NewVoipMgr.this) + "&isvideocall=" + NewVoipMgr.f(NewVoipMgr.this) + "\">" + aj.getContext().getString(2131764796) + "</a>");
              if ((NewVoipMgr.e(NewVoipMgr.this) != null) && (!NewVoipMgr.e(NewVoipMgr.this).equals("")))
              {
                paramAnonymousString.nY(NewVoipMgr.e(NewVoipMgr.this));
                ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().an(paramAnonymousString);
              }
              com.tencent.mm.plugin.voip.c.dRQ().Qf(2);
              NewVoipMgr.b(NewVoipMgr.this, false);
              break;
              paramAnonymousString = aj.getContext().getString(2131764799);
              break label327;
              str1 = bl.FzM;
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
        com.tencent.mm.plugin.voip.c.dRQ().Qf(2);
        if ((1 == NewVoipMgr.z(NewVoipMgr.this)) && (com.tencent.mm.plugin.voip.b.i.QL(NewVoipMgr.c(NewVoipMgr.this).mState)) && (NewVoipMgr.A(NewVoipMgr.this))) {
          com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(191892);
              NewVoipMgr.n(NewVoipMgr.this).ck(true);
              AppMethodBeat.o(191892);
            }
          });
        }
        if ((4 == NewVoipMgr.z(NewVoipMgr.this)) && (NewVoipMgr.A(NewVoipMgr.this))) {
          com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(191893);
              NewVoipMgr.n(NewVoipMgr.this).aq(NewVoipMgr.B(NewVoipMgr.this), NewVoipMgr.f(NewVoipMgr.this));
              AppMethodBeat.o(191893);
            }
          });
        }
        NewVoipMgr.a(NewVoipMgr.this, false);
        if ((com.tencent.mm.compatible.b.g.Wk() != null) && (com.tencent.mm.plugin.audio.c.a.bvB().isBluetoothScoOn()))
        {
          ad.i("MicroMsg.Voip.NewVoipMgr", "is bluetooth can use and start bluetooth");
          com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(191894);
              NewVoipMgr.n(NewVoipMgr.this).aq(NewVoipMgr.B(NewVoipMgr.this), NewVoipMgr.f(NewVoipMgr.this));
              AppMethodBeat.o(191894);
            }
          });
        }
        for (;;)
        {
          NewVoipMgr.b(NewVoipMgr.this, false);
          break;
          if (com.tencent.mm.plugin.audio.c.a.bvB().bvw()) {
            com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(191895);
                NewVoipMgr.n(NewVoipMgr.this).aq(NewVoipMgr.B(NewVoipMgr.this), NewVoipMgr.f(NewVoipMgr.this));
                AppMethodBeat.o(191895);
              }
            });
          }
        }
      }
    };
    this.gPP = -1L;
    this.enterTime = -1L;
    this.zib = new com.tencent.mm.sdk.b.c() {};
    this.zgO = new com.tencent.mm.plugin.voip.b.b();
    AppMethodBeat.o(191920);
  }
  
  private void PM(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(191944);
    ad.i("MicroMsg.Voip.NewVoipMgr", "hangupTalkingOrCancelInvite");
    if (true == dSD()) {
      this.zhb = paramInt;
    }
    Object localObject = aj.getContext();
    String str2;
    if (com.tencent.mm.plugin.voip.b.i.QL(this.zgP.mState))
    {
      localObject = ((Context)localObject).getString(2131764803, new Object[] { mz(bt.lZ(this.zhe)) });
      str2 = this.zgX.field_username;
      if (!this.zgZ) {
        break label251;
      }
    }
    label251:
    for (String str1 = bl.FzN;; str1 = bl.FzM)
    {
      if (this.zgY) {
        i = 1;
      }
      s.c(str2, str1, i, 6, (String)localObject);
      if ((!this.zgY) || (com.tencent.mm.plugin.voip.b.i.QL(this.zgP.mState))) {
        break label259;
      }
      dSr();
      if ((this.zgY) && (!com.tencent.mm.plugin.voip.b.i.QL(this.zgP.mState)))
      {
        ad.i("MicroMsg.Voip.NewVoipMgr", "hangupVoipButton OnClick call cancelCall");
        com.tencent.mm.plugin.voip.c.dRQ().zlR.dUV();
      }
      ad.i("MicroMsg.Voip.NewVoipMgr", "hangupVoipButton OnClick call hangUp");
      com.tencent.mm.plugin.voip.c.dRQ().zlR.dUY();
      if (4096 != this.zhb) {
        break label315;
      }
      sq(paramInt);
      dSv();
      AppMethodBeat.o(191944);
      return;
      if (this.zgY)
      {
        localObject = ((Context)localObject).getString(2131764798);
        break;
      }
      localObject = ((Context)localObject).getString(2131764797);
      break;
    }
    label259:
    com.tencent.e.h.Iye.aP(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "VoipMgr_play_end_sound";
      }
      
      public final void run()
      {
        AppMethodBeat.i(191915);
        NewVoipMgr.n(NewVoipMgr.this);
        com.tencent.mm.plugin.voip.b.b.rP(NewVoipMgr.f(NewVoipMgr.this));
        AppMethodBeat.o(191915);
      }
    });
    this.zgU = true;
    this.zgV = true;
    com.tencent.mm.plugin.voip.c.dRQ().zlR.dUY();
    if (4096 == this.zhb)
    {
      sq(paramInt);
      dSv();
    }
    label315:
    AppMethodBeat.o(191944);
  }
  
  private boolean PN(int paramInt)
  {
    AppMethodBeat.i(191961);
    if (4111 == paramInt)
    {
      AppMethodBeat.o(191961);
      return true;
    }
    if ((4101 == paramInt) && ((com.tencent.mm.plugin.voip.b.i.QL(this.zgP.mState)) || (this.zgY)))
    {
      AppMethodBeat.o(191961);
      return true;
    }
    AppMethodBeat.o(191961);
    return false;
  }
  
  private static void PO(int paramInt)
  {
    AppMethodBeat.i(191962);
    xy localxy = new xy();
    localxy.dEl.dbV = paramInt;
    com.tencent.mm.sdk.b.a.ESL.l(localxy);
    AppMethodBeat.o(191962);
  }
  
  private boolean d(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(191988);
    String str = com.tencent.mm.m.g.Zd().getValue("VOIPShortcutAutoadd");
    ad.i("MicroMsg.Voip.NewVoipMgr", "voip shortcut autoAdd is %s", new Object[] { str });
    if ((str != null) && (str.equals("0")) && (bt.lZ(this.zhe) > 30L))
    {
      int i = paramSharedPreferences.getInt("voip_shortcut_prompt_times", 0);
      boolean bool = paramSharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
      if ((i < 3) && (!bool))
      {
        dSE();
        paramSharedPreferences.edit().putInt("voip_shortcut_prompt_times", i + 1).commit();
        AppMethodBeat.o(191988);
        return true;
      }
    }
    else if ((str != null) && (str.equals("1")) && (bt.lZ(this.zhe) > 15L))
    {
      e(paramSharedPreferences);
      AppMethodBeat.o(191988);
      return false;
    }
    AppMethodBeat.o(191988);
    return false;
  }
  
  private void dSC()
  {
    AppMethodBeat.i(191984);
    synchronized (this.zgW)
    {
      dSI();
      if (this.zgQ != null) {
        this.zgQ.release();
      }
      com.tencent.mm.plugin.voip.b.b.NX();
      this.zgO.dSC();
      AppMethodBeat.o(191984);
      return;
    }
  }
  
  private boolean dSD()
  {
    AppMethodBeat.i(191987);
    if (com.tencent.mm.plugin.voip.b.i.QL(this.zgP.mState))
    {
      SharedPreferences localSharedPreferences = getContext().getSharedPreferences("voip_plugin_prefs", 0);
      if (!localSharedPreferences.getBoolean("voip_shortcut_has_added", false))
      {
        boolean bool = d(localSharedPreferences);
        AppMethodBeat.o(191987);
        return bool;
      }
    }
    AppMethodBeat.o(191987);
    return false;
  }
  
  private void dSE()
  {
    AppMethodBeat.i(191991);
    Context localContext = getContext();
    View localView = View.inflate(localContext, 2131494763, null);
    final CheckBox localCheckBox = (CheckBox)localView.findViewById(2131302304);
    localCheckBox.setChecked(false);
    TextView localTextView = (TextView)localView.findViewById(2131302306);
    if (1 == bt.getInt(com.tencent.mm.m.g.Zd().getValue("VOIPCallType"), 0)) {
      localTextView.setText(2131764786);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(localContext, false, localContext.getString(2131755906), localView, localContext.getString(2131755939), localContext.getString(2131755831), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(191898);
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
                AppMethodBeat.i(191897);
                NewVoipMgr.p(NewVoipMgr.this);
                AppMethodBeat.o(191897);
              }
            });
          }
          AppMethodBeat.o(191898);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(191900);
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
                AppMethodBeat.i(191899);
                NewVoipMgr.p(NewVoipMgr.this);
                AppMethodBeat.o(191899);
              }
            });
          }
          AppMethodBeat.o(191900);
        }
      });
      AppMethodBeat.o(191991);
      return;
      localTextView.setText(2131764787);
    }
  }
  
  private void dSI()
  {
    AppMethodBeat.i(191996);
    if (this.zhl != null) {
      this.zhl.b(this);
    }
    if (this.zhm != null)
    {
      ad.d("MicroMsg.Voip.NewVoipMgr", "stop face detect timer");
      this.zhm.stopTimer();
    }
    AppMethodBeat.o(191996);
  }
  
  private boolean dSt()
  {
    int j = 0;
    AppMethodBeat.i(191957);
    if (!this.zgP.QP(4101))
    {
      AppMethodBeat.o(191957);
      return false;
    }
    this.zgZ = false;
    if (this.zht != null) {
      this.zht.zgZ = false;
    }
    sq(4101);
    Object localObject1;
    int k;
    int i;
    Object localObject3;
    Object localObject2;
    if ((261 == this.zgP.mState) || (7 == this.zgP.mState))
    {
      com.tencent.mm.plugin.voip.c.dRQ().Qd(1);
      localObject1 = com.tencent.mm.plugin.report.service.h.vKh;
      long l = com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.sAY;
      k = com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.roomId;
      if (this.zgY)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject1).f(11046, new Object[] { Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(k), Integer.valueOf(0), Integer.valueOf(i) });
        localObject3 = com.tencent.mm.plugin.report.service.h.vKh;
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
        com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.dTh();
        com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.dTi();
        AppMethodBeat.o(191957);
        return true;
        i = 0;
        break;
      } while ((1 != this.zgP.mState) && (3 != this.zgP.mState));
      com.tencent.mm.plugin.voip.c.dRQ().Qd(1);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
      k = 11046;
      localObject1 = new Object[5];
      localObject1[0] = Integer.valueOf(1);
      localObject1[1] = Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.sAY);
      localObject1[2] = Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.roomId);
      localObject1[3] = Integer.valueOf(0);
      i = 4;
      if (this.zgY)
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
  
  private void dSv()
  {
    AppMethodBeat.i(191967);
    ad.d("MicroMsg.Voip.NewVoipMgr", "delayFinish");
    this.zhw = null;
    if (this.iDu != null) {
      this.iDu.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(191917);
          NewVoipMgr localNewVoipMgr = NewVoipMgr.this;
          ad.i("MicroMsg.Voip.NewVoipMgr", "it is uninit voip report");
          if (localNewVoipMgr.zhR != null)
          {
            localNewVoipMgr.zhR.removeCallbacksAndMessages(null);
            localNewVoipMgr.zhR.quit();
          }
          if (!localNewVoipMgr.zhO)
          {
            if (localNewVoipMgr.zia == 0) {
              localNewVoipMgr.PL(localNewVoipMgr.zhN);
            }
            if (localNewVoipMgr.zia != 0)
            {
              localNewVoipMgr.zhO = true;
              if (!localNewVoipMgr.zgY) {
                break label183;
              }
            }
          }
          label183:
          for (int i = 0;; i = 1)
          {
            com.tencent.mm.plugin.voip.b.c.a(i, System.currentTimeMillis(), localNewVoipMgr.zhN, localNewVoipMgr.zhN, 0, 0, NewVoipMgr.kxX / localNewVoipMgr.zia);
            NewVoipMgr.kxX = 0;
            NewVoipMgr.zhS[0] = 0;
            NewVoipMgr.zhS[1] = 0;
            localNewVoipMgr.zia = 0;
            if (localNewVoipMgr.nRA != null) {
              localNewVoipMgr.nRA.listen(localNewVoipMgr.zhQ, 0);
            }
            if (localNewVoipMgr.zhP != null)
            {
              aj.getContext().unregisterReceiver(localNewVoipMgr.zhP);
              localNewVoipMgr.zhP = null;
            }
            NewVoipMgr.p(NewVoipMgr.this);
            AppMethodBeat.o(191917);
            return;
          }
        }
      }, 500L);
    }
    AppMethodBeat.o(191967);
  }
  
  private static void dSw()
  {
    AppMethodBeat.i(191969);
    ww localww = new ww();
    localww.dCp.djq = 11;
    com.tencent.mm.sdk.b.a.ESL.l(localww);
    AppMethodBeat.o(191969);
  }
  
  private void e(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(191989);
    Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
    localIntent1.putExtra("duplicate", false);
    Intent localIntent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
    localIntent2.addFlags(67108864);
    if (1 == bt.getInt(com.tencent.mm.m.g.Zd().getValue("VOIPCallType"), 0))
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
      AppMethodBeat.o(191989);
      return;
      localIntent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(2131755764));
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getContext(), 2131234599));
      localIntent1.putExtra("shortcut_icon_resource_id", 2131234599);
    }
  }
  
  private void fF(boolean paramBoolean)
  {
    AppMethodBeat.i(191968);
    ad.i("MicroMsg.Voip.NewVoipMgr", "finish");
    if (this.zhX != null) {
      this.zhX.dWx();
    }
    this.zhs = false;
    this.zhu = false;
    this.lastShakeTime = -1L;
    if (this.zhj != -1)
    {
      com.tencent.mm.plugin.report.service.h.vKh.f(11700, new Object[] { Integer.valueOf(this.zhj), Long.valueOf(bt.lZ(this.zhe)) });
      this.zhj = -1;
    }
    try
    {
      aj.getContext().unregisterReceiver(this.zhY);
      try
      {
        label105:
        aj.getContext().unregisterReceiver(this.zhZ);
        label115:
        com.tencent.mm.sdk.b.a.ESL.d(this.szz);
        com.tencent.mm.sdk.b.a.ESL.d(this.zib);
        dSI();
        if (this.zgQ != null)
        {
          this.zgQ.release();
          this.zgQ = null;
        }
        if (this.zgR != null)
        {
          this.zgR.uninit();
          this.zgR = null;
          this.zgO.b(this.zgR);
        }
        label237:
        int j;
        label302:
        long l;
        if (com.tencent.mm.plugin.voip.c.dRQ() != null)
        {
          com.tencent.mm.plugin.voip.c.dRQ().zlR.stopRing();
          if (paramBoolean)
          {
            com.tencent.mm.plugin.voip.c.dRQ().dUy();
            if (!this.zgZ) {
              break label749;
            }
            com.tencent.mm.plugin.voip.c.dRQ().b(false, true, this.flk);
            com.tencent.mm.plugin.voip.c.dRQ().b(aj.getContext(), this);
          }
        }
        else
        {
          this.zgO.cRA();
          com.tencent.mm.plugin.voip.c.dRQ().dUJ();
          com.tencent.mm.plugin.voip.c.dRQ().Qn(this.zhA);
          if (!this.zgU) {
            break label764;
          }
          this.zgS = new a();
          com.tencent.e.h.Iye.aP(this.zgS);
          if ((this.szx != null) && (this.klv != null))
          {
            this.szx.listen(this.klv, 0);
            this.klv = null;
          }
          this.szx = null;
          com.tencent.mm.booter.a.Ti().Tj();
          r.dTT().dTV();
          r.dTT().a(null);
          ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
          if (this.orl != null)
          {
            ad.d("MicroMsg.Voip.NewVoipMgr", "removeSensorCallBack");
            this.orl.eGx();
            this.orl = null;
            this.zhC = false;
            this.zhD = 0L;
            this.zhB = -1L;
          }
          if (this.ork != null) {
            this.ork.eGy();
          }
          this.zhE = -1L;
          com.tencent.mm.plugin.voip.c.dRQ().dUM();
          ad.i("MicroMsg.Voip.NewVoipMgr", "finish, isFinishFromShutdown: %s", new Object[] { Boolean.valueOf(this.zgV) });
          if ((this.zgV) && (com.tencent.mm.plugin.voip.c.dRQ().dUN()))
          {
            com.tencent.mm.plugin.voip.c.dRQ();
            VoipScoreState.dUv();
            Object localObject = new Intent(getContext(), VoipScoreDialog.class);
            ((Intent)localObject).putExtra("key_score_state", com.tencent.mm.plugin.voip.c.dRQ().dUP());
            if (!(getContext() instanceof Activity)) {
              ((Intent)localObject).addFlags(268435456);
            }
            Context localContext = getContext();
            localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
            com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          com.tencent.mm.plugin.voip.c.dRQ().dUO();
          dSw();
          if (!this.zhJ)
          {
            j = com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.roomId;
            l = com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.sAY;
            if (!this.zgY) {
              break label771;
            }
          }
        }
        label771:
        for (int i = 0;; i = 1)
        {
          com.tencent.mm.plugin.voip.b.c.c(j, l, i, 4);
          this.zhJ = true;
          ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
          com.tencent.mm.media.f.c.grn.ajW();
          AppMethodBeat.o(191968);
          return;
          com.tencent.mm.plugin.voip.c.dRQ().zlR.dUY();
          break;
          label749:
          com.tencent.mm.plugin.voip.c.dRQ().b(false, false, this.flk);
          break label237;
          label764:
          dSC();
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
    AppMethodBeat.i(191990);
    Context localContext1 = null;
    if (this.zgR != null) {
      localContext1 = this.zgR.dVM();
    }
    Context localContext2 = localContext1;
    if (localContext1 == null) {
      localContext2 = aj.getContext();
    }
    AppMethodBeat.o(191990);
    return localContext2;
  }
  
  private static String mz(long paramLong)
  {
    AppMethodBeat.i(191983);
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
    AppMethodBeat.o(191983);
    return str;
  }
  
  private void sq(final int paramInt)
  {
    AppMethodBeat.i(191960);
    ad.l("MicroMsg.Voip.NewVoipMgr", "swtchState, action: %s, currentState: %s", new Object[] { com.tencent.mm.plugin.voip.b.i.QI(paramInt), com.tencent.mm.plugin.voip.b.i.QI(this.zgP.mState) });
    if ((4101 == paramInt) && (com.tencent.mm.plugin.voip.b.i.QM(this.zgP.mState)))
    {
      dSI();
      if (this.zgQ != null) {
        this.zgQ.release();
      }
      this.zgZ = false;
      if (this.zht != null) {
        this.zht.zgZ = false;
      }
    }
    if (PN(paramInt)) {
      this.zgO.zhg = false;
    }
    if ((PN(paramInt)) && (1 == this.mUIType) && (1 == this.zhd))
    {
      this.zgO.ck(false);
      this.zhv = true;
    }
    this.zgP.QQ(paramInt);
    if (this.iDu != null) {
      this.iDu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(191916);
          if (NewVoipMgr.o(NewVoipMgr.this) != null) {
            NewVoipMgr.o(NewVoipMgr.this).hS(paramInt, NewVoipMgr.c(NewVoipMgr.this).mState);
          }
          AppMethodBeat.o(191916);
        }
      });
    }
    switch (this.zgP.mState)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(191960);
      return;
      PO(5);
      AppMethodBeat.o(191960);
      return;
      PO(6);
    }
  }
  
  final void PL(int paramInt)
  {
    AppMethodBeat.i(191936);
    if (paramInt == 5)
    {
      kxX += zhS[0];
      this.zia += 1;
      ad.i("MicroMsg.Voip.NewVoipMgr", "mSignalStrength 4G" + zhS[0] + " and index is " + this.zia);
      AppMethodBeat.o(191936);
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
        int[] arrayOfInt = zhS;
        if (localWifiManager.getConnectionInfo() != null) {
          continue;
        }
        paramInt = 0;
        arrayOfInt[1] = paramInt;
      }
      catch (Exception localException)
      {
        zhS[1] = 0;
        ad.i("MicroMsg.Voip.NewVoipMgr", "error happened in get wifi info");
        continue;
      }
      kxX += zhS[1];
      this.zia += 1;
      ad.i("MicroMsg.Voip.NewVoipMgr", "mSignalStrength WIFI " + zhS[1] + " and index is " + this.zia);
      AppMethodBeat.o(191936);
      return;
      paramInt = localWifiManager.getConnectionInfo().getRssi();
    }
  }
  
  public final void PP(int paramInt)
  {
    AppMethodBeat.i(191974);
    ad.i("MicroMsg.Voip.NewVoipMgr", "remote voip mode changed, cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    if (((1 == paramInt) || (3 == paramInt) || (5 == paramInt) || (6 == paramInt) || (7 == paramInt)) && (this.zgZ))
    {
      sq(4101);
      com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.dTh();
      com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.dTi();
    }
    AppMethodBeat.o(191974);
  }
  
  public final void PQ(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(191979);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onSessionBeingCalled, callType: ".concat(String.valueOf(paramInt)));
    if (!this.zgP.QP(4110))
    {
      AppMethodBeat.o(191979);
      return;
    }
    u localu = com.tencent.mm.plugin.voip.c.dRQ();
    if (paramInt == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramInt == 1) {
        bool2 = true;
      }
      localu.an(bool1, bool2);
      dSr();
      if ((paramInt == 1) && (com.tencent.mm.plugin.voip.b.i.QM(this.zgP.mState))) {
        sq(4101);
      }
      sq(4110);
      AppMethodBeat.o(191979);
      return;
    }
  }
  
  public final void PR(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(191980);
    ad.i("MicroMsg.Voip.NewVoipMgr", "steve:[simucall]onNewSimulCallAutoAccept, callType: ".concat(String.valueOf(paramInt)));
    if (!this.zgP.QP(4100))
    {
      AppMethodBeat.o(191980);
      return;
    }
    u localu = com.tencent.mm.plugin.voip.c.dRQ();
    if (paramInt == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramInt == 1) {
        bool2 = true;
      }
      localu.an(bool1, bool2);
      com.tencent.mm.plugin.voip.c.dRQ().zlR.stopRing();
      if ((paramInt == 1) && (com.tencent.mm.plugin.voip.b.i.QM(this.zgP.mState))) {
        sq(4101);
      }
      sq(4100);
      AppMethodBeat.o(191980);
      return;
    }
  }
  
  public final void V(long paramLong, int paramInt)
  {
    int k = 1;
    AppMethodBeat.i(191940);
    Object localObject1;
    int i;
    label60:
    Object localObject2;
    int j;
    if (this.zhX != null) {
      switch (paramInt)
      {
      default: 
        if (this.zgQ != null)
        {
          localObject1 = this.zhX;
          if (1 != this.mUIType) {
            break label367;
          }
          i = 1;
          localObject2 = this.zgQ.zzU;
          j = k;
          if (localObject2 != null)
          {
            if (((com.tencent.mm.plugin.voip.video.render.d)localObject2).dXK() == 0) {
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
      AppMethodBeat.o(191940);
      return;
      if (1 == this.mUIType)
      {
        if (!com.tencent.mm.plugin.voip.c.dRQ().zmf)
        {
          localObject1 = this.zhX;
          if ((260 != this.zgP.mState) && (6 != this.zgP.mState)) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.plugin.voip.b.f)localObject1).as(true, bool);
            com.tencent.mm.plugin.voip.c.dRQ().zmf = true;
            break;
          }
        }
        localObject1 = this.zhX;
        if ((260 != this.zgP.mState) && (6 != this.zgP.mState)) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.voip.b.f)localObject1).at(true, bool);
          break;
        }
      }
      if (!com.tencent.mm.plugin.voip.c.dRQ().zme)
      {
        localObject1 = this.zhX;
        if ((260 != this.zgP.mState) && (6 != this.zgP.mState)) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.voip.b.f)localObject1).as(false, bool);
          com.tencent.mm.plugin.voip.c.dRQ().zme = true;
          break;
        }
      }
      localObject1 = this.zhX;
      if ((260 != this.zgP.mState) && (6 != this.zgP.mState)) {}
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.voip.b.f)localObject1).at(false, bool);
        break;
      }
      label367:
      i = 0;
      break label60;
      label373:
      j = 0;
      break label90;
      ((com.tencent.mm.plugin.voip.b.f)localObject1).ztw += 1;
      if (((com.tencent.mm.plugin.voip.b.f)localObject1).ztw == 0)
      {
        if (i != 0)
        {
          if (paramLong > 0L)
          {
            localObject1 = com.tencent.mm.plugin.voip.b.h.ztD;
            com.tencent.mm.plugin.voip.b.h.ux(paramLong);
            AppMethodBeat.o(191940);
          }
        }
        else
        {
          if (paramLong > 0L)
          {
            localObject1 = com.tencent.mm.plugin.voip.b.h.ztD;
            com.tencent.mm.plugin.voip.b.h.uy(paramLong);
          }
          AppMethodBeat.o(191940);
        }
      }
      else if (((com.tencent.mm.plugin.voip.b.f)localObject1).ztw == 60) {
        ((com.tencent.mm.plugin.voip.b.f)localObject1).ztw = -1;
      }
      AppMethodBeat.o(191940);
      return;
      ((com.tencent.mm.plugin.voip.b.f)localObject1).ztx += 1;
      if (((com.tencent.mm.plugin.voip.b.f)localObject1).ztx == 0)
      {
        if (i != 0)
        {
          if (j != 0)
          {
            localObject1 = com.tencent.mm.plugin.voip.b.h.ztD;
            com.tencent.mm.plugin.voip.b.h.uP(paramLong);
            AppMethodBeat.o(191940);
            return;
          }
          localObject1 = com.tencent.mm.plugin.voip.b.h.ztD;
          com.tencent.mm.plugin.voip.b.h.uN(paramLong);
          AppMethodBeat.o(191940);
          return;
        }
        if (j != 0)
        {
          localObject1 = com.tencent.mm.plugin.voip.b.h.ztD;
          com.tencent.mm.plugin.voip.b.h.uQ(paramLong);
          AppMethodBeat.o(191940);
          return;
        }
        localObject1 = com.tencent.mm.plugin.voip.b.h.ztD;
        com.tencent.mm.plugin.voip.b.h.uO(paramLong);
        AppMethodBeat.o(191940);
        return;
      }
      if (((com.tencent.mm.plugin.voip.b.f)localObject1).ztx == 60) {
        ((com.tencent.mm.plugin.voip.b.f)localObject1).ztx = -1;
      }
      AppMethodBeat.o(191940);
      return;
      ((com.tencent.mm.plugin.voip.b.f)localObject1).zty += 1;
      if (((com.tencent.mm.plugin.voip.b.f)localObject1).zty == 0)
      {
        if (i != 0)
        {
          localObject2 = com.tencent.mm.plugin.voip.b.h.ztD;
          com.tencent.mm.plugin.voip.b.h.uz(paramLong);
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.voip.b.f)localObject1).ztw = 0;
          AppMethodBeat.o(191940);
          return;
          localObject2 = com.tencent.mm.plugin.voip.b.h.ztD;
          com.tencent.mm.plugin.voip.b.h.uA(paramLong);
        }
      }
      if (((com.tencent.mm.plugin.voip.b.f)localObject1).zty == 60) {
        ((com.tencent.mm.plugin.voip.b.f)localObject1).zty = -1;
      }
    }
  }
  
  public final void W(long paramLong, int paramInt) {}
  
  public final void a(final Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 1;
    AppMethodBeat.i(191921);
    ad.i("MicroMsg.Voip.NewVoipMgr", "start VoIP, userName: %s, isOutCall: %b, isVideoCall: %b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.zgO.rO(paramBoolean2);
    this.zgO.dWr();
    this.zhs = true;
    this.flk = paramString;
    this.zgY = paramBoolean1;
    this.zgZ = paramBoolean2;
    this.zgX = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.flk);
    this.iDu = new ap(Looper.getMainLooper());
    this.zhz = 0;
    this.zhA = 0;
    boolean bool1;
    int j;
    int i;
    label193:
    label213:
    boolean bool2;
    Object localObject1;
    label266:
    label313:
    Object localObject2;
    if (bt.getInt(com.tencent.mm.m.g.Zd().getValue("VOIPCameraSwitch"), 1) == 0)
    {
      bool1 = true;
      this.zha = bool1;
      if (!this.zgZ) {
        this.zha = false;
      }
      j = com.tencent.mm.plugin.voip.b.i.au(paramBoolean1, paramBoolean2);
      i = j;
      if (this.zha)
      {
        if (j != 0) {
          break label529;
        }
        i = 1;
        com.tencent.mm.plugin.voip.c.dRQ().Qd(1);
      }
      if (!paramBoolean1) {
        break label549;
      }
      this.zgP = com.tencent.mm.plugin.voip.b.i.QK(i);
      this.zgO.zgP = this.zgP;
      bool1 = com.tencent.mm.compatible.d.b.XB();
      bool2 = com.tencent.mm.compatible.d.b.XC();
      if (Build.MANUFACTURER.equalsIgnoreCase("meizu"))
      {
        if (!bool1)
        {
          localObject1 = com.tencent.mm.plugin.report.service.h.vKh;
          if (!this.zgZ) {
            break label561;
          }
          i = 0;
          ((com.tencent.mm.plugin.report.service.h)localObject1).f(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
        }
        if (!bool2)
        {
          localObject1 = com.tencent.mm.plugin.report.service.h.vKh;
          if (!this.zgZ) {
            break label567;
          }
          i = 0;
          ((com.tencent.mm.plugin.report.service.h)localObject1).f(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
        }
      }
      if ((!bool2) || (!bool1))
      {
        if ((bool1) || (bool2)) {
          break label573;
        }
        localObject1 = paramContext.getString(2131764920);
        localObject2 = paramContext.getString(2131764887);
      }
    }
    for (;;)
    {
      label378:
      com.tencent.mm.ui.base.h.a(paramContext, (String)localObject1, (String)localObject2, paramContext.getString(2131764890), true, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(191912);
          ad.i("MicroMsg.Voip.NewVoipMgr", "show Permission settings");
          com.tencent.mm.compatible.d.b.bY(paramContext);
          if (!NewVoipMgr.d(NewVoipMgr.this))
          {
            if (NewVoipMgr.f(NewVoipMgr.this))
            {
              NewVoipMgr.this.dSc();
              AppMethodBeat.o(191912);
              return;
            }
            NewVoipMgr.this.dSf();
            AppMethodBeat.o(191912);
            return;
          }
          if (NewVoipMgr.f(NewVoipMgr.this))
          {
            NewVoipMgr.this.dSh();
            AppMethodBeat.o(191912);
            return;
          }
          NewVoipMgr.this.dSi();
          AppMethodBeat.o(191912);
        }
      });
      ad.i("MicroMsg.Voip.NewVoipMgr", "initMgr");
      com.tencent.mm.booter.a.Ti().Tk();
      if (this.zgZ)
      {
        com.tencent.mm.plugin.voip.c.dRQ().b(true, true, this.flk);
        label438:
        if (!this.zgY) {
          break label658;
        }
        com.tencent.mm.plugin.voip.c.dRQ().zlR.dUU();
        if (!this.zgZ) {
          break label640;
        }
      }
      label640:
      for (i = com.tencent.mm.plugin.voip.c.dRQ().ath(this.zgX.field_username);; i = com.tencent.mm.plugin.voip.c.dRQ().atg(this.zgX.field_username))
      {
        if (i >= 0) {
          break label658;
        }
        fF(false);
        i = 0;
        if (i != 0)
        {
          this.zgO.ar(paramBoolean2, paramBoolean1);
          com.tencent.mm.plugin.voip.c.dRQ().h(paramString, this.zgZ, false);
        }
        AppMethodBeat.o(191921);
        return;
        bool1 = false;
        break;
        label529:
        i = j;
        if (256 != j) {
          break label193;
        }
        i = 257;
        break label193;
        label549:
        this.zgP = com.tencent.mm.plugin.voip.b.i.QJ(i);
        break label213;
        label561:
        i = 1;
        break label266;
        label567:
        i = 1;
        break label313;
        label573:
        if (!bool1)
        {
          localObject1 = paramContext.getString(2131764922);
          localObject2 = paramContext.getString(2131764888);
          break label378;
        }
        if (bool2) {
          break label1128;
        }
        localObject1 = paramContext.getString(2131764921);
        localObject2 = paramContext.getString(2131764889);
        break label378;
        com.tencent.mm.plugin.voip.c.dRQ().b(true, false, this.flk);
        break label438;
      }
      label658:
      com.tencent.mm.plugin.voip.c.dRQ().a(aj.getContext(), this);
      this.szx = ((TelephonyManager)aj.getContext().getSystemService("phone"));
      this.szx.listen(this.klv, 32);
      paramContext = "voip_recent_contact" + com.tencent.mm.model.u.aqG();
      localObject1 = aj.getContext().getSharedPreferences("voip_plugin_prefs", 0);
      localObject2 = ((SharedPreferences)localObject1).getString(paramContext, null);
      if (localObject2 != null)
      {
        localObject2 = bt.S(((String)localObject2).split(";"));
        if (localObject2 != null)
        {
          i = ((List)localObject2).size();
          if (((List)localObject2).contains(this.flk))
          {
            if (i > 1)
            {
              ((List)localObject2).remove(this.flk);
              label804:
              ((List)localObject2).add(0, this.flk);
            }
            localObject2 = bt.n((List)localObject2, ";");
            ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
            label847:
            com.tencent.mm.sdk.b.a.ESL.c(this.zib);
            com.tencent.mm.sdk.b.a.ESL.c(this.szz);
            this.zhl.a(this);
            paramContext = new IntentFilter();
            paramContext.addAction("android.intent.action.SCREEN_ON");
            paramContext.addAction("android.intent.action.SCREEN_OFF");
            paramContext.addAction("android.intent.action.USER_PRESENT");
            aj.getContext().registerReceiver(this.zhY, paramContext);
            this.orl = new SensorController(getContext());
            ad.i("MicroMsg.Voip.NewVoipMgr", "initMgr setSensorCallBack");
            this.orl.a(this);
            if (this.ork == null)
            {
              this.ork = new bk(getContext());
              paramContext = new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(191913);
                  NewVoipMgr.a(NewVoipMgr.this, bt.GC());
                  AppMethodBeat.o(191913);
                }
              };
              if (!this.ork.aC(paramContext)) {
                break label1118;
              }
            }
          }
        }
      }
      label1118:
      for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
      {
        i = k;
        if (!this.zgZ) {
          break;
        }
        this.zgQ = new com.tencent.mm.plugin.voip.video.render.h(this, this.zgY);
        this.zhX = new com.tencent.mm.plugin.voip.b.f();
        i = k;
        break;
        if (4 != i) {
          break label804;
        }
        ((List)localObject2).remove(i - 1);
        break label804;
        localObject2 = new ArrayList();
        ((List)localObject2).add(0, this.flk);
        localObject2 = bt.n((List)localObject2, ";");
        ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
        break label847;
      }
      label1128:
      localObject2 = null;
      localObject1 = null;
    }
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    AppMethodBeat.i(191941);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onVoipUIDestroy");
    if (this.zgR == paramb)
    {
      ad.d("MicroMsg.Voip.NewVoipMgr", "same VoipUI, clear it");
      this.zgR = null;
      this.zgO.b(null);
    }
    if (this.iDu != null) {
      this.iDu = null;
    }
    AppMethodBeat.o(191941);
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb, int paramInt)
  {
    AppMethodBeat.i(191934);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onVoipUICreated, uiType: %s,  mVoicePlayDevice: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.zhd) });
    if ((1 == paramInt) && (this.zgR != null)) {
      this.zgR.uninit();
    }
    this.zgR = paramb;
    this.mUIType = paramInt;
    this.zgO.b(this.zgR);
    this.zgR.hS(-1, this.zgP.mState);
    this.zgR.setConnectSec(this.zhe);
    this.zgR.Qw(this.zhA);
    AppMethodBeat.o(191934);
  }
  
  public final void a(VoIPRenderSurfaceView paramVoIPRenderSurfaceView)
  {
    AppMethodBeat.i(191948);
    if (this.zgQ != null)
    {
      com.tencent.mm.plugin.voip.video.render.h localh = this.zgQ;
      if (paramVoIPRenderSurfaceView != null) {
        paramVoIPRenderSurfaceView.dXS();
      }
      localh.zzY = false;
      localh.zzT = false;
    }
    AppMethodBeat.o(191948);
  }
  
  public final void a(VoIPRenderSurfaceView paramVoIPRenderSurfaceView, int paramInt)
  {
    AppMethodBeat.i(191947);
    if (this.zgQ != null)
    {
      com.tencent.mm.plugin.voip.b.f.QF(0);
      Object localObject1 = this.zgQ;
      d.g.b.k.h(paramVoIPRenderSurfaceView, "view");
      if (!((com.tencent.mm.plugin.voip.video.render.h)localObject1).zzY)
      {
        ((com.tencent.mm.plugin.voip.video.render.h)localObject1).zzY = true;
        Object localObject2 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).zzU;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.d)localObject2).A((d.g.a.a)new h.f((com.tencent.mm.plugin.voip.video.render.h)localObject1));
        }
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).zzV;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.b)localObject2).zyF = ((d.g.a.a)new h.g((com.tencent.mm.plugin.voip.video.render.h)localObject1));
        }
      }
      localObject1 = (h.b)new h.h((com.tencent.mm.plugin.voip.video.render.h)localObject1);
      d.g.b.k.h(localObject1, "listener");
      paramVoIPRenderSurfaceView.zAp = ((h.b)localObject1);
      paramVoIPRenderSurfaceView.zAq = paramInt;
      paramVoIPRenderSurfaceView.getHolder().addCallback(paramVoIPRenderSurfaceView.zAo);
    }
    AppMethodBeat.o(191947);
  }
  
  public final void a(VoIPRenderTextureView paramVoIPRenderTextureView)
  {
    AppMethodBeat.i(191949);
    if (this.zgQ != null)
    {
      com.tencent.mm.plugin.voip.video.render.h localh = this.zgQ;
      if (paramVoIPRenderTextureView != null)
      {
        paramVoIPRenderTextureView.setSurfaceTextureListener(null);
        h.b localb = paramVoIPRenderTextureView.zAp;
        if (localb != null) {
          localb.QW(paramVoIPRenderTextureView.zAq);
        }
        paramVoIPRenderTextureView.zAp = null;
      }
      localh.zzY = false;
      localh.zzT = false;
    }
    AppMethodBeat.o(191949);
  }
  
  public final void a(VoIPRenderTextureView paramVoIPRenderTextureView, int paramInt)
  {
    AppMethodBeat.i(191945);
    if (this.zgQ != null)
    {
      com.tencent.mm.plugin.voip.b.f.QF(1);
      Object localObject1 = this.zgQ;
      d.g.b.k.h(paramVoIPRenderTextureView, "view");
      if (!((com.tencent.mm.plugin.voip.video.render.h)localObject1).zzY)
      {
        ((com.tencent.mm.plugin.voip.video.render.h)localObject1).zzY = true;
        Object localObject2 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).zzU;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.d)localObject2).A((d.g.a.a)new h.c((com.tencent.mm.plugin.voip.video.render.h)localObject1));
        }
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).zzV;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.b)localObject2).zyF = ((d.g.a.a)new h.d((com.tencent.mm.plugin.voip.video.render.h)localObject1));
        }
      }
      localObject1 = (h.b)new h.e((com.tencent.mm.plugin.voip.video.render.h)localObject1);
      d.g.b.k.h(localObject1, "listener");
      paramVoIPRenderTextureView.zAp = ((h.b)localObject1);
      paramVoIPRenderTextureView.zAq = paramInt;
      paramVoIPRenderTextureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new VoIPRenderTextureView.b(paramVoIPRenderTextureView));
    }
    AppMethodBeat.o(191945);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void a(int[] paramArrayOfInt, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(191997);
    if ((this.zgQ != null) && (!this.zgQ.zlk))
    {
      this.zgQ.dXQ();
      this.zgQ.zlk = true;
    }
    com.tencent.mm.sdk.platformtools.aq.f(new NewVoipMgr.10(this, paramArrayOfInt, paramBoolean, paramInt));
    AppMethodBeat.o(191997);
  }
  
  public final void al(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(191946);
    if (this.zhX != null)
    {
      com.tencent.mm.plugin.voip.b.f localf = this.zhX;
      long l = bt.GC();
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          localf.ztu = l;
          AppMethodBeat.o(191946);
          return;
        }
        localf.zts = l;
        AppMethodBeat.o(191946);
        return;
      }
      if (paramBoolean2)
      {
        localf.ztv = l;
        AppMethodBeat.o(191946);
        return;
      }
      localf.ztt = l;
    }
    AppMethodBeat.o(191946);
  }
  
  public final void atd(String paramString)
  {
    AppMethodBeat.i(191963);
    if (this.zgR != null)
    {
      this.zhw = paramString;
      this.zgR.atj(paramString);
    }
    AppMethodBeat.o(191963);
  }
  
  public final void bOf() {}
  
  public final void cGD()
  {
    AppMethodBeat.i(191965);
    ad.i("MicroMsg.Voip.NewVoipMgr", "on accept");
    dSr();
    sq(4100);
    AppMethodBeat.o(191965);
  }
  
  public final void cGJ()
  {
    AppMethodBeat.i(191986);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onResumeGoodNetStatus");
    if (this.zgR != null) {
      this.zgR.cIC();
    }
    AppMethodBeat.o(191986);
  }
  
  public final void cSz()
  {
    AppMethodBeat.i(191958);
    if (this.zgR != null) {
      this.zgR.cSz();
    }
    AppMethodBeat.o(191958);
  }
  
  public final void d(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(191975);
    if (this.zgQ != null)
    {
      Object localObject1 = this.zgQ;
      d.g.b.k.h(paramArrayOfByte, "outData");
      localObject1 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).zzV;
      if (localObject1 != null)
      {
        int i = OpenGlRender.FLAG_YV12Edge;
        int j = OpenGlRender.FLAG_Angle90;
        d.g.b.k.h(paramArrayOfByte, "pBuff");
        if (((com.tencent.mm.plugin.voip.video.render.b)localObject1).zwD != null)
        {
          Object localObject2 = ((com.tencent.mm.plugin.voip.video.render.b)localObject1).zyM;
          if (localObject2 != null)
          {
            d.g.b.k.h(paramArrayOfByte, "pBuff");
            localObject2 = ((com.tencent.mm.plugin.voip.video.render.j)localObject2).zAG;
            d.g.b.k.h(paramArrayOfByte, "pBuff");
            localObject2 = ((com.tencent.mm.plugin.voip.video.c.d)localObject2).zyx;
            if (localObject2 != null)
            {
              d.g.b.k.h(paramArrayOfByte, "pBuff");
              if (((com.tencent.mm.plugin.voip.video.c.g)localObject2).zvs == null)
              {
                ((com.tencent.mm.plugin.voip.video.c.g)localObject2).mWidth = paramInt1;
                ((com.tencent.mm.plugin.voip.video.c.g)localObject2).mHeight = paramInt2;
                ((com.tencent.mm.plugin.voip.video.c.g)localObject2).uoX = (i + j);
                ((com.tencent.mm.plugin.voip.video.c.g)localObject2).zvs = paramArrayOfByte;
              }
            }
          }
          paramArrayOfByte = ((com.tencent.mm.plugin.voip.video.render.b)localObject1).zwD;
          if (paramArrayOfByte == null) {
            d.g.b.k.fvU();
          }
          ((com.tencent.mm.plugin.voip.video.render.k)localObject1).b(paramArrayOfByte);
        }
      }
      if (this.zgR != null) {
        this.zgR.dVN();
      }
    }
    AppMethodBeat.o(191975);
  }
  
  public final boolean dRJ()
  {
    return this.zgZ;
  }
  
  public final boolean dRK()
  {
    return this.zgY;
  }
  
  public final String dRL()
  {
    return this.zhw;
  }
  
  public final long dRM()
  {
    return this.zhF;
  }
  
  public final long dRN()
  {
    return this.zhG;
  }
  
  public final int dRO()
  {
    return this.zhH;
  }
  
  public final void dSA()
  {
    AppMethodBeat.i(191981);
    ad.d("MicroMsg.Voip.NewVoipMgr", "onPretreatmentForStartDev");
    this.zgO.aq(this.zhv, this.zgZ);
    AppMethodBeat.o(191981);
  }
  
  public final long dSB()
  {
    AppMethodBeat.i(191982);
    ad.m("MicroMsg.Voip.NewVoipMgr", "totalDeviceNearTime: %s", new Object[] { Long.valueOf(this.zhD) });
    long l = this.zhD / 1000L;
    AppMethodBeat.o(191982);
    return l;
  }
  
  public final void dSF()
  {
    AppMethodBeat.i(191993);
    if ((256 != this.zgP.mState) && (257 != this.zgP.mState))
    {
      AppMethodBeat.o(191993);
      return;
    }
    if ((com.tencent.mm.kernel.g.afB().afk().getInt(327945, 0) == 0) && (this.zgR.dVM() != null))
    {
      com.tencent.mm.kernel.g.afB().afk().setInt(327945, 1);
      com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.a(this.zgR.dVM(), 2131764868, 2131755906, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(191902);
          NewVoipMgr.this.dSH();
          AppMethodBeat.o(191902);
        }
      });
      locald.setCancelable(false);
      locald.setCanceledOnTouchOutside(false);
      locald.show();
      AppMethodBeat.o(191993);
      return;
    }
    com.tencent.mm.plugin.voip.b.k.gq(aj.getContext());
    dSH();
    AppMethodBeat.o(191993);
  }
  
  public final void dSG()
  {
    AppMethodBeat.i(191994);
    if (!this.zhn) {}
    for (boolean bool = true;; bool = false)
    {
      this.zhn = bool;
      if (!this.zhn) {
        break;
      }
      this.zhm.stopTimer();
      AppMethodBeat.o(191994);
      return;
    }
    if (this.zhm == null) {
      this.zhm = new av("faceDetect", new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(191904);
          NewVoipMgr.I(NewVoipMgr.this);
          AppMethodBeat.o(191904);
          return true;
        }
      }, true);
    }
    this.zhm.av(2000L, 2000L);
    this.zhn = false;
    AppMethodBeat.o(191994);
  }
  
  public final void dSH()
  {
    AppMethodBeat.i(191995);
    com.tencent.mm.plugin.voip.c.dRQ().zlY = com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.roomId;
    String str2 = this.zgX.field_username;
    String str1;
    if (this.zgZ)
    {
      str1 = bl.FzN;
      if (!this.zgY) {
        break label124;
      }
    }
    label124:
    for (int i = 1;; i = 0)
    {
      s.c(str2, str1, i, 6, aj.getContext().getString(2131764806));
      dSr();
      sq(4108);
      if (this.iDu != null) {
        this.iDu.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(191903);
            NewVoipMgr.H(NewVoipMgr.this);
            AppMethodBeat.o(191903);
          }
        }, 2000L);
      }
      AppMethodBeat.o(191995);
      return;
      str1 = bl.FzM;
      break;
    }
  }
  
  public final boolean dSa()
  {
    AppMethodBeat.i(191926);
    if (!this.zgP.QP(4103))
    {
      AppMethodBeat.o(191926);
      return false;
    }
    PM(4103);
    com.tencent.mm.plugin.voip.c.dRQ().dUM();
    AppMethodBeat.o(191926);
    return true;
  }
  
  public final boolean dSb()
  {
    AppMethodBeat.i(191927);
    if (!this.zgP.QP(4101))
    {
      AppMethodBeat.o(191927);
      return false;
    }
    dSr();
    com.tencent.mm.plugin.voip.c.dRQ().Qd(1);
    com.tencent.mm.plugin.voip.c.dRQ().an(true, this.zgZ);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
    long l = com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.sAY;
    int j = com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.roomId;
    if (this.zgY) {}
    for (int i = 1;; i = 0)
    {
      localh.f(11046, new Object[] { Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i) });
      com.tencent.mm.plugin.report.service.h.vKh.f(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0) });
      sq(4111);
      sq(4101);
      sq(4100);
      AppMethodBeat.o(191927);
      return true;
    }
  }
  
  public final boolean dSc()
  {
    int i = 0;
    AppMethodBeat.i(191928);
    if (!this.zgP.QP(4099))
    {
      AppMethodBeat.o(191928);
      return false;
    }
    String str2 = this.zgX.field_username;
    if (this.zgZ) {}
    for (String str1 = bl.FzN;; str1 = bl.FzM)
    {
      if (this.zgY) {
        i = 1;
      }
      s.c(str2, str1, i, 6, aj.getContext().getString(2131764807));
      dSr();
      com.tencent.mm.plugin.voip.c.dRQ().zlR.dUX();
      sq(4099);
      dSv();
      AppMethodBeat.o(191928);
      return true;
    }
  }
  
  public final boolean dSd()
  {
    AppMethodBeat.i(191929);
    if (!this.zgP.QP(4100))
    {
      AppMethodBeat.o(191929);
      return false;
    }
    if (this.zgQ != null) {
      this.zgQ.dXQ();
    }
    ad.i("MicroMsg.Voip.NewVoipMgr", "onAcceptVideoInvite");
    dSr();
    com.tencent.mm.plugin.voip.c.dRQ().an(false, this.zgZ);
    sq(4100);
    AppMethodBeat.o(191929);
    return true;
  }
  
  public final void dSe()
  {
    if (this.zgQ != null) {
      this.zgQ.zlk = false;
    }
  }
  
  public final boolean dSf()
  {
    int i = 0;
    AppMethodBeat.i(191930);
    if (!this.zgP.QP(4099))
    {
      AppMethodBeat.o(191930);
      return false;
    }
    ad.i("MicroMsg.Voip.NewVoipMgr", "onRejectVoiceInvite");
    String str2 = this.zgX.field_username;
    if (this.zgZ) {}
    for (String str1 = bl.FzN;; str1 = bl.FzM)
    {
      if (this.zgY) {
        i = 1;
      }
      s.c(str2, str1, i, 6, aj.getContext().getString(2131764807));
      dSr();
      com.tencent.mm.plugin.voip.c.dRQ().zlR.dUX();
      sq(4099);
      dSv();
      AppMethodBeat.o(191930);
      return true;
    }
  }
  
  public final boolean dSg()
  {
    AppMethodBeat.i(191931);
    if (!this.zgP.QP(4100))
    {
      AppMethodBeat.o(191931);
      return false;
    }
    ad.i("MicroMsg.Voip.NewVoipMgr", "onAcceptVoiceInvite");
    dSr();
    com.tencent.mm.plugin.voip.c.dRQ().an(true, this.zgZ);
    sq(4111);
    sq(4100);
    AppMethodBeat.o(191931);
    return true;
  }
  
  public final boolean dSh()
  {
    AppMethodBeat.i(191932);
    if (!this.zgP.QP(4098))
    {
      AppMethodBeat.o(191932);
      return false;
    }
    ad.i("MicroMsg.Voip.NewVoipMgr", "onCancelVideoInvite");
    PM(4098);
    com.tencent.mm.plugin.voip.c.dRQ().dUM();
    AppMethodBeat.o(191932);
    return true;
  }
  
  public final boolean dSi()
  {
    AppMethodBeat.i(191933);
    if (!this.zgP.QP(4098))
    {
      AppMethodBeat.o(191933);
      return false;
    }
    ad.i("MicroMsg.Voip.NewVoipMgr", "onCancelVoiceInvite");
    PM(4098);
    com.tencent.mm.plugin.voip.c.dRQ().dUM();
    AppMethodBeat.o(191933);
    return true;
  }
  
  public final void dSj()
  {
    boolean bool2 = true;
    AppMethodBeat.i(191935);
    if ((this.zgZ) && (this.zgQ != null))
    {
      com.tencent.mm.plugin.voip.video.render.h localh = this.zgQ;
      Object localObject1 = localh.zzR;
      if ((localObject1 != null) && (localh.zzU != null))
      {
        Object localObject2 = localh.zzU;
        if (localObject2 == null) {
          d.g.b.k.fvU();
        }
        if (((com.tencent.mm.plugin.voip.video.render.d)localObject2).zyV != null)
        {
          ((com.tencent.mm.plugin.voip.video.h)localObject1).zuc = false;
          localObject1 = localh.zzU;
          if (localObject1 == null) {
            d.g.b.k.fvU();
          }
          localObject1 = ((com.tencent.mm.plugin.voip.video.render.d)localObject1).zyV;
          if (localObject1 == null) {
            d.g.b.k.fvU();
          }
          localObject2 = localh.zzR;
          if (localObject2 == null) {
            break label195;
          }
          bool1 = ((com.tencent.mm.plugin.voip.video.h)localObject2).dWW();
          localh.c((com.tencent.mm.plugin.voip.video.render.f)localObject1, bool1);
        }
      }
    }
    if ((this.zgY) && (com.tencent.mm.plugin.voip.b.i.QN(this.zgP.mState)) && (com.tencent.mm.plugin.voip.c.dRQ().zlR.cSx()))
    {
      this.zgO.ar(this.zgZ, this.zgY);
      if (this.zhd != 1) {
        break label200;
      }
    }
    label195:
    label200:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      rt(bool1);
      AppMethodBeat.o(191935);
      return;
      bool1 = true;
      break;
    }
  }
  
  public final void dSk()
  {
    AppMethodBeat.i(191937);
    ad.i("MicroMsg.Voip.NewVoipMgr", "it is init voip report");
    this.zhP = new NetChangedBroadcastReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    aj.getContext().registerReceiver(this.zhP, localIntentFilter);
    this.nRA = ((TelephonyManager)aj.getContext().getSystemService("phone"));
    this.zhN = com.tencent.mm.plugin.voip.b.c.getNetType(getContext());
    this.zhQ = new NewVoipMgr.16(this);
    this.nRA.listen(this.zhQ, 256);
    AppMethodBeat.o(191937);
  }
  
  public final void dSl()
  {
    AppMethodBeat.i(191939);
    if ((this.tCt) || (this.zgR == null) || (this.zgR.dVM() == null) || (this.zgQ == null) || (this.zgQ.zzR == null))
    {
      ad.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, already show");
      AppMethodBeat.o(191939);
      return;
    }
    if (this.zgQ.zzR.cPP())
    {
      AppMethodBeat.o(191939);
      return;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("meizu")) && (!com.tencent.mm.compatible.d.b.XC()))
    {
      ad.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, meizu machine");
      AppMethodBeat.o(191939);
      return;
    }
    if ((com.tencent.mm.compatible.util.d.lf(28)) && (((KeyguardManager)aj.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()))
    {
      ad.i("MicroMsg.Voip.NewVoipMgr", "api level: %s, in keyguard, ignore", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(191939);
      return;
    }
    ad.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, show dialog");
    com.tencent.mm.plugin.report.service.h.vKh.f(11306, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.j(this.zgR.dVM(), 2131764896, 2131755906);
    if (locald == null)
    {
      ad.e("MicroMsg.Voip.NewVoipMgr", "new dialog failed");
      AppMethodBeat.o(191939);
      return;
    }
    locald.setCancelable(false);
    locald.setCanceledOnTouchOutside(false);
    locald.show();
    this.tCt = true;
    com.tencent.mm.plugin.voip.b.f.dWy();
    AppMethodBeat.o(191939);
  }
  
  public final void dSm()
  {
    AppMethodBeat.i(191942);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onSwitchCamera");
    com.tencent.mm.plugin.voip.video.render.h localh;
    Object localObject;
    int i;
    if (this.zgQ != null)
    {
      localh = this.zgQ;
      ad.i("MicroMsg.VoIPRenderMgr", "onSwitchCamera");
      if (localh.zzR != null)
      {
        localObject = localh.zzR;
        if (localObject == null) {
          d.g.b.k.fvU();
        }
        if (((com.tencent.mm.plugin.voip.video.h)localObject).dXc() != null)
        {
          localObject = localh.zzR;
          if (localObject != null) {
            ((com.tencent.mm.plugin.voip.video.h)localObject).dWT();
          }
          localObject = localh.zzR;
          if (localObject == null) {
            d.g.b.k.fvU();
          }
          localObject = ((com.tencent.mm.plugin.voip.video.h)localObject).dXc();
          d.g.b.k.g(localObject, "newCaptureRender!!.previewSize");
          com.tencent.mm.plugin.voip.video.h localh1 = localh.zzR;
          if (localh1 == null) {
            d.g.b.k.fvU();
          }
          i = localh1.dXd();
          localh1 = localh.zzR;
          if (localh1 == null) {
            d.g.b.k.fvU();
          }
          if (localh1.dXe()) {
            break label189;
          }
        }
      }
    }
    label189:
    for (boolean bool = true;; bool = false)
    {
      localh.a((ac)localObject, i, bool);
      com.tencent.mm.plugin.report.service.h.vKh.f(11079, new Object[] { Integer.valueOf(1) });
      AppMethodBeat.o(191942);
      return;
    }
  }
  
  public final void dSn()
  {
    AppMethodBeat.i(191943);
    if ((this.zgQ != null) && (this.zgQ.zzR != null) && (true != this.zgQ.zzR.dWW())) {
      dSm();
    }
    AppMethodBeat.o(191943);
  }
  
  public final void dSo()
  {
    AppMethodBeat.i(191950);
    if (this.zgQ != null)
    {
      Object localObject1 = this.zgQ;
      ad.m("MicroMsg.VoIPRenderMgr", "onRender Mode changed", new Object[0]);
      if (!((com.tencent.mm.plugin.voip.video.render.h)localObject1).zqu) {}
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.voip.video.render.h)localObject1).zqu = bool;
        Object localObject2 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).zzU;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.d)localObject2).dXJ();
        }
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).zzV;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.k)localObject2).dXJ();
        }
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).zzU;
        if (localObject2 != null)
        {
          ad.m("MicroMsg.LocalWindowsSurfaceRenderer", "switchRenderSurface", new Object[0]);
          com.tencent.mm.plugin.voip.video.render.k localk = ((com.tencent.mm.plugin.voip.video.render.d)localObject2).zyW;
          if (localk != null) {
            localk.dXH();
          }
          localObject2 = ((com.tencent.mm.plugin.voip.video.render.d)localObject2).zyV;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.voip.video.render.f)localObject2).dXH();
          }
        }
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).zzV;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.k)localObject2).dXH();
        }
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).zzU;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.d)localObject2).dXI();
        }
        localObject1 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).zzV;
        if (localObject1 == null) {
          break;
        }
        ((com.tencent.mm.plugin.voip.video.render.k)localObject1).dXI();
        AppMethodBeat.o(191950);
        return;
      }
    }
    AppMethodBeat.o(191950);
  }
  
  public final void dSp()
  {
    AppMethodBeat.i(191952);
    if (this.zgQ != null) {
      this.zgQ.hP(this.zhL, this.zhM);
    }
    AppMethodBeat.o(191952);
  }
  
  public final void dSq()
  {
    AppMethodBeat.i(191954);
    this.zhX.QE(1);
    AppMethodBeat.o(191954);
  }
  
  public final void dSr()
  {
    AppMethodBeat.i(191955);
    if (this.zgO != null)
    {
      ad.i("MicroMsg.Voip.NewVoipMgr", "use audioManager to stop voip ring");
      this.zgO.dSr();
      AppMethodBeat.o(191955);
      return;
    }
    ad.i("MicroMsg.Voip.NewVoipMgr", "use Subcore to stop voip ring");
    com.tencent.mm.plugin.voip.c.dRQ().zlR.stopRing();
    AppMethodBeat.o(191955);
  }
  
  public final boolean dSs()
  {
    AppMethodBeat.i(191956);
    if (com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.roomId == 0)
    {
      this.zhc = true;
      AppMethodBeat.o(191956);
      return true;
    }
    boolean bool = dSt();
    AppMethodBeat.o(191956);
    return bool;
  }
  
  public final void dSu()
  {
    AppMethodBeat.i(191959);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onRoomReady");
    if ((this.zhc) && (com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.roomId != 0))
    {
      this.zhc = false;
      dSt();
    }
    if (this.zgY) {
      sq(4097);
    }
    AppMethodBeat.o(191959);
  }
  
  public final void dSx()
  {
    AppMethodBeat.i(191970);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onNoResp");
    sq(4105);
    String str2 = this.zgX.field_username;
    String str1;
    if (this.zgZ)
    {
      str1 = bl.FzN;
      if (!this.zgY) {
        break label181;
      }
    }
    label181:
    for (int i = 1;; i = 0)
    {
      s.c(str2, str1, i, 4, aj.getContext().getString(2131764810));
      com.tencent.mm.plugin.report.service.h.vKh.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.sAY), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.dTa()), Integer.valueOf(6), Integer.valueOf(ay.getNetWorkType(getContext())) });
      dSv();
      AppMethodBeat.o(191970);
      return;
      str1 = bl.FzM;
      break;
    }
  }
  
  public final void dSy()
  {
    int j = 0;
    AppMethodBeat.i(191972);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.vKh;
    int k = com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.roomId;
    long l1 = com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.sAY;
    long l2 = com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.dTa();
    if (this.zgY)
    {
      i = 0;
      localh.a(11522, true, true, new Object[] { Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(1) });
      k = com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.roomId;
      l1 = com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.sAY;
      if (!this.zgY) {
        break label198;
      }
    }
    label198:
    for (int i = j;; i = 1)
    {
      com.tencent.mm.plugin.voip.b.c.c(k, l1, i, 3);
      this.zhR.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(191891);
          NewVoipMgr.a(NewVoipMgr.this, NewVoipMgr.h(NewVoipMgr.this));
          NewVoipMgr.q(NewVoipMgr.this).postDelayed(this, 5000L);
          AppMethodBeat.o(191891);
        }
      });
      AppMethodBeat.o(191972);
      return;
      i = 1;
      break;
    }
  }
  
  public final void dSz()
  {
    int j = 0;
    AppMethodBeat.i(191973);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onShutDown");
    String str1;
    String str2;
    label99:
    label108:
    int k;
    label156:
    long l;
    if (com.tencent.mm.plugin.voip.b.i.QL(this.zgP.mState))
    {
      str1 = aj.getContext().getString(2131764803, new Object[] { mz(bt.lZ(this.zhe)) });
      if ((this.zgY) || (com.tencent.mm.plugin.voip.b.i.QL(this.zgP.mState)))
      {
        String str3 = this.zgX.field_username;
        if (!this.zgZ) {
          break label245;
        }
        str2 = bl.FzN;
        if (!this.zgY) {
          break label253;
        }
        i = 1;
        s.c(str3, str2, i, 6, str1);
      }
      com.tencent.mm.plugin.voip.b.b.rP(this.zgZ);
      this.zgV = com.tencent.mm.plugin.voip.b.i.QL(this.zgP.mState);
      if (!dSD()) {
        break label258;
      }
      this.zhb = 4106;
      com.tencent.mm.plugin.voip.c.dRQ().dUM();
      if (!this.zhJ)
      {
        k = com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.roomId;
        l = com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.sAY;
        if (!this.zgY) {
          break label272;
        }
      }
    }
    label258:
    label272:
    for (int i = j;; i = 1)
    {
      com.tencent.mm.plugin.voip.b.c.c(k, l, i, 4);
      this.zhJ = true;
      AppMethodBeat.o(191973);
      return;
      str1 = aj.getContext().getString(2131764799);
      break;
      label245:
      str2 = bl.FzM;
      break label99;
      label253:
      i = 0;
      break label108;
      sq(4106);
      dSv();
      break label156;
    }
  }
  
  public final int getState()
  {
    return this.zgP.mState;
  }
  
  public final String getUserName()
  {
    return this.flk;
  }
  
  public final void hO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191938);
    if (this.zgR != null) {
      this.zgR.dVO();
    }
    if (this.zhl != null) {
      this.zhl.setPreviewSize(paramInt1, paramInt2);
    }
    AppMethodBeat.o(191938);
  }
  
  public final void hP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(191978);
    ad.i("MicroMsg.Voip.NewVoipMgr", "adjustHWViewAspectRatio, HWDecsize:%dx%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.zhL = paramInt1;
    this.zhM = paramInt2;
    if (this.zgQ != null) {
      this.zgQ.hP(paramInt1, paramInt2);
    }
    AppMethodBeat.o(191978);
  }
  
  public final void jz(boolean paramBoolean)
  {
    AppMethodBeat.i(191923);
    ad.m("MicroMsg.Voip.NewVoipMgr", "onSensorEvent, isON: %s, lastIsDeviceNear: %s, deviceSwitchNearScreenTick: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.zhC), Long.valueOf(this.zhB) });
    if (this.zgP == null)
    {
      ad.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent, not create stateMachine yet, ignore");
      AppMethodBeat.o(191923);
      return;
    }
    if (this.orj)
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.orj = paramBoolean;
        ad.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent has skip and val is %s", new Object[] { Boolean.valueOf(this.orj) });
        AppMethodBeat.o(191923);
        return;
      }
    }
    if ((Math.abs(bt.GC() - this.zhE) < 500L) && (this.zhE != -1L))
    {
      ad.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent time interval too small");
      AppMethodBeat.o(191923);
      return;
    }
    if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pvC, true)) && (!paramBoolean) && (this.lastShakeTime != -1L) && (bt.aS(this.lastShakeTime) > 400L))
    {
      this.orj = true;
      ad.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent has skip case shake near to small");
      AppMethodBeat.o(191923);
      return;
    }
    this.orj = false;
    if ((com.tencent.mm.plugin.voip.b.i.QL(this.zgP.mState)) && ((this.zhC != paramBoolean) || (this.zhB == -1L)))
    {
      if ((!this.zhC) && (paramBoolean) && (!com.tencent.mm.plugin.voip.b.i.QM(this.zgP.mState)) && (this.mUIType != 2) && (this.zhB != -1L))
      {
        long l = bt.aS(this.zhB);
        ad.i("MicroMsg.Voip.NewVoipMgr", "accumulate near screen time: %s", new Object[] { Long.valueOf(l) });
        this.zhD += l;
      }
      this.zhB = bt.GC();
      this.zhC = paramBoolean;
    }
    if (this.zgR == null)
    {
      ad.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent, voipUI is null, ignore");
      AppMethodBeat.o(191923);
      return;
    }
    if (((this.zgY) || (com.tencent.mm.plugin.voip.b.i.QL(this.zgP.mState))) && (!com.tencent.mm.plugin.voip.b.i.QM(this.zgP.mState)) && (this.mUIType != 2))
    {
      ad.i("MicroMsg.Voip.NewVoipMgr", "onSensorEvent, isOn: ".concat(String.valueOf(paramBoolean)));
      this.zgR.setScreenEnable(paramBoolean);
      this.zgT = paramBoolean;
      this.zhE = bt.GC();
    }
    AppMethodBeat.o(191923);
  }
  
  public final void ml(boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(191985);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onBadNetStatus");
    if (this.zgR != null) {
      this.zgR.rH(paramBoolean);
    }
    long l;
    if ((!com.tencent.mm.plugin.voip.b.i.QM(this.zgP.mState)) && (!this.zgO.isSpeakerphoneOn()))
    {
      l = System.currentTimeMillis();
      if (l - this.sBL > 30000L)
      {
        this.sBL = l;
        com.tencent.mm.plugin.voip.c.dRQ().zlR.dVb();
      }
    }
    Object localObject = new StringBuilder("report the bad net toast room key is ").append(com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.sAY).append("and in the side");
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      ad.i("MicroMsg.Voip.NewVoipMgr", i);
      localObject = com.tencent.mm.plugin.report.service.h.vKh;
      l = com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.sAY;
      i = j;
      if (paramBoolean) {
        i = 1;
      }
      ((com.tencent.mm.plugin.report.service.h)localObject).a(17151, true, true, new Object[] { Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(191985);
      return;
    }
  }
  
  public final void ns(boolean paramBoolean)
  {
    AppMethodBeat.i(191925);
    this.zgO.rN(paramBoolean);
    AppMethodBeat.o(191925);
  }
  
  public final void onConnected()
  {
    AppMethodBeat.i(191971);
    sq(4102);
    this.zhe = bt.aGK();
    if (this.zgR != null) {
      this.zgR.setConnectSec(this.zhe);
    }
    boolean bool1 = com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.dTc();
    boolean bool2 = com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.dTb();
    if ((this.zgZ) && (this.zgY) && (!bool2) && (!bool1)) {
      com.tencent.mm.plugin.voip.c.dRQ().Qd(1);
    }
    if (!com.tencent.mm.plugin.voip.b.i.QM(this.zgP.mState)) {
      com.tencent.mm.plugin.report.service.h.vKh.f(11080, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
    }
    bt.C(aj.getContext(), true);
    com.tencent.mm.plugin.voip.c.dRQ().Qo(com.tencent.mm.plugin.voip.c.dRQ().dUL());
    r.dTT().dTU();
    r.dTT().a(this);
    k localk = k.ziu;
    k.setRoomId(com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.roomId);
    AppMethodBeat.o(191971);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(191964);
    com.tencent.mm.plugin.voip.b.b.rP(this.zgZ);
    String str1 = paramString;
    if (paramInt == 241)
    {
      str1 = paramString;
      if (bt.isNullOrNil(paramString)) {
        str1 = getContext().getString(2131764903);
      }
    }
    if (this.zgR != null) {
      this.zgR.cd(paramInt, str1);
    }
    sq(4109);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onError, errCode: %s, roomId: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.roomId) });
    paramString = aj.getContext();
    ad.d("MicroMsg.Voip.NewVoipMgr", "getErrorMsgContent, errorCode".concat(String.valueOf(paramInt)));
    if (paramInt == 235)
    {
      paramString = paramString.getString(2131764809);
      if ((com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.roomId == 0) || (com.tencent.mm.plugin.voip.c.dRQ().zlX.get(Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.roomId)) != null)) {
        break label427;
      }
      str2 = this.zgX.field_username;
      if (!this.zgZ) {
        break label414;
      }
      str1 = bl.FzN;
      if (!this.zgY) {
        break label422;
      }
      paramInt = 1;
      if (com.tencent.mm.plugin.voip.b.i.QL(this.zgP.mState)) {
        paramString = aj.getContext().getString(2131764804, new Object[] { mz(bt.lZ(this.zhe)) });
      }
      l = s.a(str2, str1, paramInt, 6, paramString, true);
      com.tencent.mm.plugin.voip.c.dRQ().zlX.put(Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.roomId), Long.valueOf(l));
    }
    label414:
    label422:
    label427:
    while (com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.roomId != 0) {
      for (;;)
      {
        long l;
        com.tencent.mm.plugin.voip.c.dRQ().dUM();
        dSv();
        AppMethodBeat.o(191964);
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
        str1 = bl.FzM;
        continue;
        paramInt = 0;
      }
    }
    String str2 = this.zgX.field_username;
    if (this.zgZ)
    {
      str1 = bl.FzN;
      label466:
      if (!this.zgY) {
        break label539;
      }
    }
    label539:
    for (paramInt = 1;; paramInt = 0)
    {
      if (com.tencent.mm.plugin.voip.b.i.QL(this.zgP.mState)) {
        paramString = aj.getContext().getString(2131764804, new Object[] { mz(bt.lZ(this.zhe)) });
      }
      s.a(str2, str1, paramInt, 6, paramString, true);
      break;
      str1 = bl.FzM;
      break label466;
    }
  }
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture) {}
  
  public final void onReject()
  {
    AppMethodBeat.i(191966);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onReject");
    sq(4099);
    String str2 = this.zgX.field_username;
    String str1;
    if (this.zgZ)
    {
      str1 = bl.FzN;
      if (!this.zgY) {
        break label86;
      }
    }
    label86:
    for (int i = 1;; i = 0)
    {
      s.c(str2, str1, i, 6, aj.getContext().getString(2131764811));
      dSv();
      AppMethodBeat.o(191966);
      return;
      str1 = bl.FzM;
      break;
    }
  }
  
  public final void rq(boolean paramBoolean)
  {
    AppMethodBeat.i(191922);
    int j = com.tencent.mm.plugin.voip.b.i.au(false, paramBoolean);
    int i = j;
    if (this.zha)
    {
      if (j != 0) {
        break label80;
      }
      i = 1;
    }
    for (;;)
    {
      this.zgP = com.tencent.mm.plugin.voip.b.i.QJ(i);
      ad.i("MicroMsg.Voip.NewVoipMgr", "steve:[simucall] resetStateMachine, initState:%d,isOutCall:%s,isVideoCall:%s", new Object[] { Integer.valueOf(i), Boolean.FALSE, Boolean.valueOf(paramBoolean) });
      this.zgY = false;
      AppMethodBeat.o(191922);
      return;
      label80:
      i = j;
      if (256 == j) {
        i = 257;
      }
    }
  }
  
  public final void rt(boolean paramBoolean)
  {
    AppMethodBeat.i(191924);
    ad.i("MicroMsg.Voip.NewVoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.zgO.ck(paramBoolean);
    this.zgO.zte = true;
    AppMethodBeat.o(191924);
  }
  
  public final void ru(boolean paramBoolean)
  {
    AppMethodBeat.i(191951);
    if (this.zgQ != null)
    {
      com.tencent.mm.plugin.voip.video.render.h localh = this.zgQ;
      localh.zqu = paramBoolean;
      localh.setHWDecMode(localh.zqz);
    }
    AppMethodBeat.o(191951);
  }
  
  public final boolean rv(final boolean paramBoolean)
  {
    AppMethodBeat.i(191992);
    if (com.tencent.mm.plugin.voip.c.dRQ().zmg)
    {
      ad.i("MicroMsg.Voip.NewVoipMgr", "current state is mini, cannot mini!");
      AppMethodBeat.o(191992);
      return false;
    }
    if ((this.zhu) && (!paramBoolean))
    {
      ad.i("MicroMsg.Voip.NewVoipMgr", "has phone call  cannot mini!");
      AppMethodBeat.o(191992);
      return false;
    }
    ad.l("MicroMsg.Voip.NewVoipMgr", "miniOnlyHidenVoip: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ad.i("MicroMsg.Voip.NewVoipMgr", "onMinimizeVoip, async to minimize");
    if (this.zgR != null)
    {
      this.zgR.uninit();
      this.zgR = null;
      this.zgO.b(this.zgR);
    }
    this.gPP = bt.GC();
    if (this.zht != null) {
      this.zht.uninit();
    }
    if (this.iDu != null) {
      this.iDu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(191901);
          NewVoipMgr.c(NewVoipMgr.this, paramBoolean);
          AppMethodBeat.o(191901);
        }
      });
    }
    AppMethodBeat.o(191992);
    return true;
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(191977);
    this.zhz = paramInt;
    if (this.zgQ != null)
    {
      this.zgQ.setHWDecMode(paramInt);
      if (this.zgR != null) {
        this.zgR.Qv(paramInt);
      }
      if (this.zhX != null)
      {
        com.tencent.mm.plugin.voip.b.f localf = this.zhX;
        if ((paramInt & 0x1) != 0)
        {
          localf.zto += 1L;
          AppMethodBeat.o(191977);
          return;
        }
        localf.ztp += 1L;
      }
    }
    AppMethodBeat.o(191977);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    this.zhd = paramInt;
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(191976);
    ad.i("MicroMsg.Voip.NewVoipMgr", "setVoIPBeauty, isON: " + paramInt + "，mVoipUI: " + this.zgR);
    if (this.zgQ != null)
    {
      com.tencent.mm.plugin.voip.video.render.h localh = this.zgQ;
      ad.i("MicroMsg.VoIPRenderMgr", "setVoIPBeauty, mIsStarted:%b, isON:%d", new Object[] { Boolean.valueOf(localh.mIsStarted), Integer.valueOf(paramInt) });
      localh.zhA = paramInt;
      com.tencent.mm.plugin.voip.video.render.d locald = localh.zzU;
      if (locald != null) {
        locald.QU(localh.zhA);
      }
    }
    if (this.zgR != null) {
      this.zgR.Qw(paramInt);
    }
    if ((paramInt != 0) && (this.zhA != paramInt)) {
      com.tencent.mm.plugin.report.service.h.vKh.m(914L, 20L, 1L);
    }
    this.zhA = paramInt;
    AppMethodBeat.o(191976);
  }
  
  public final void wy(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(191953);
    if ((this.zgQ != null) && (this.zhr != paramInt) && ((paramInt == 0) || (paramInt == 180)))
    {
      this.zhr = paramInt;
      Object localObject1 = this.zgQ.zzU;
      if (localObject1 != null)
      {
        Object localObject2 = ((com.tencent.mm.plugin.voip.video.render.d)localObject1).zyW;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.voip.video.render.b)localObject2).zyM;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.voip.video.render.j)localObject2).mz(paramInt);
          }
        }
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.d)localObject1).zyV;
        if (localObject2 != null)
        {
          if (((com.tencent.mm.plugin.voip.video.render.f)localObject2).zzN == null)
          {
            localObject1 = ((com.tencent.mm.plugin.voip.video.render.f)localObject2).zzE;
            if (localObject1 != null)
            {
              localObject1 = Integer.valueOf(((com.tencent.mm.media.i.b.a)localObject1).guD);
              ((com.tencent.mm.plugin.voip.video.render.f)localObject2).zzN = ((Integer)localObject1);
            }
          }
          else
          {
            if (((com.tencent.mm.plugin.voip.video.render.f)localObject2).dXK() != 0) {
              break label190;
            }
            localObject1 = ((com.tencent.mm.plugin.voip.video.render.f)localObject2).zzE;
            if (localObject1 == null) {
              break label183;
            }
            localObject2 = ((com.tencent.mm.plugin.voip.video.render.f)localObject2).zzN;
            if (localObject2 == null) {
              break label178;
            }
          }
          label178:
          for (i = ((Integer)localObject2).intValue();; i = 0)
          {
            ((com.tencent.mm.plugin.voip.video.render.i)localObject1).mz(i + paramInt);
            AppMethodBeat.o(191953);
            return;
            localObject1 = null;
            break;
          }
          label183:
          AppMethodBeat.o(191953);
          return;
          label190:
          localObject1 = ((com.tencent.mm.plugin.voip.video.render.f)localObject2).zzE;
          if (localObject1 != null)
          {
            localObject2 = ((com.tencent.mm.plugin.voip.video.render.f)localObject2).zzN;
            paramInt = i;
            if (localObject2 != null) {
              paramInt = ((Integer)localObject2).intValue();
            }
            ((com.tencent.mm.plugin.voip.video.render.i)localObject1).mz(paramInt);
            AppMethodBeat.o(191953);
            return;
          }
          AppMethodBeat.o(191953);
          return;
        }
        AppMethodBeat.o(191953);
        return;
      }
    }
    AppMethodBeat.o(191953);
  }
  
  public class NetChangedBroadcastReceiver
    extends BroadcastReceiver
  {
    public NetChangedBroadcastReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int j = 0;
      int i = 0;
      AppMethodBeat.i(191919);
      if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
      {
        switch (com.tencent.mm.plugin.voip.b.c.getNetType(paramContext))
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
                AppMethodBeat.o(191919);
                return;
              } while (NewVoipMgr.h(NewVoipMgr.this) == 5);
              j = NewVoipMgr.dSJ()[1];
              if (NewVoipMgr.i(NewVoipMgr.this) == 0) {
                NewVoipMgr.a(NewVoipMgr.this, 4);
              }
            } while (NewVoipMgr.i(NewVoipMgr.this) == 0);
            k = NewVoipMgr.dSK() / NewVoipMgr.i(NewVoipMgr.this);
            NewVoipMgr.a(NewVoipMgr.this, 5);
            m = NewVoipMgr.dSJ()[0];
            ad.i("MicroMsg.Voip.NewVoipMgr", "befor change to 4G and cost " + NewVoipMgr.j(NewVoipMgr.this));
            if (NewVoipMgr.d(NewVoipMgr.this)) {}
            for (;;)
            {
              com.tencent.mm.plugin.voip.b.c.a(i, System.currentTimeMillis(), NewVoipMgr.h(NewVoipMgr.this), 5, j, m, k);
              NewVoipMgr.k(NewVoipMgr.this);
              NewVoipMgr.b(NewVoipMgr.this, 5);
              NewVoipMgr.dSL();
              NewVoipMgr.l(NewVoipMgr.this);
              AppMethodBeat.o(191919);
              return;
              i = 1;
            }
          } while (NewVoipMgr.h(NewVoipMgr.this) == 4);
          k = NewVoipMgr.dSJ()[0];
          if (NewVoipMgr.i(NewVoipMgr.this) == 0) {
            NewVoipMgr.a(NewVoipMgr.this, 5);
          }
        } while (NewVoipMgr.i(NewVoipMgr.this) == 0);
        int m = NewVoipMgr.dSK() / NewVoipMgr.i(NewVoipMgr.this);
        NewVoipMgr.a(NewVoipMgr.this, 4);
        int n = NewVoipMgr.dSJ()[1];
        ad.i("MicroMsg.Voip.NewVoipMgr", "befor change to wifi and cost " + NewVoipMgr.j(NewVoipMgr.this));
        if (NewVoipMgr.d(NewVoipMgr.this)) {}
        for (i = j;; i = 1)
        {
          com.tencent.mm.plugin.voip.b.c.a(i, System.currentTimeMillis(), NewVoipMgr.h(NewVoipMgr.this), 4, k, n, m);
          NewVoipMgr.k(NewVoipMgr.this);
          NewVoipMgr.b(NewVoipMgr.this, 4);
          NewVoipMgr.dSL();
          NewVoipMgr.l(NewVoipMgr.this);
          break;
        }
      }
      if ((paramIntent.getAction().equals("android.net.wifi.STATE_CHANGE")) && (NewVoipMgr.m(NewVoipMgr.this) == 0L))
      {
        NewVoipMgr.b(NewVoipMgr.this, System.currentTimeMillis());
        AppMethodBeat.o(191919);
        return;
      }
      if ((paramIntent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) && (NewVoipMgr.m(NewVoipMgr.this) != 0L))
      {
        NewVoipMgr.c(NewVoipMgr.this, System.currentTimeMillis() - NewVoipMgr.m(NewVoipMgr.this));
        NewVoipMgr.b(NewVoipMgr.this, 0L);
      }
      AppMethodBeat.o(191919);
    }
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(191918);
      NewVoipMgr.r(NewVoipMgr.this);
      NewVoipMgr.s(NewVoipMgr.this);
      AppMethodBeat.o(191918);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.NewVoipMgr
 * JD-Core Version:    0.7.0.1
 */