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
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.g.a.wv;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.g.a.xy;
import com.tencent.mm.g.a.xy.a;
import com.tencent.mm.g.c.au;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.b.j;
import com.tencent.mm.plugin.voip.ui.VoipScoreDialog;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
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

public final class VoipMgr
  extends com.tencent.mm.plugin.voip.a
{
  static int kxX = 0;
  static int[] zhS = new int[2];
  private String flk;
  private ap iDu;
  PhoneStateListener klv;
  private long lastShakeTime;
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
  private j zgP;
  volatile com.tencent.mm.plugin.voip.ui.b zgR;
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
  PhoneStateListener zhQ;
  ap zhR;
  private long zhT;
  private boolean zhU;
  private int zhV;
  private int zhW;
  private BroadcastReceiver zhY;
  private boolean zha;
  private int zhb;
  private boolean zhc;
  private int zhd;
  private long zhe;
  private boolean zhi;
  private int zhj;
  private com.tencent.mm.plugin.voip.video.k zhl;
  private av zhm;
  private boolean zhn;
  private boolean zho;
  private int zhp;
  private boolean zhq;
  private boolean zhs;
  private boolean zhu;
  private boolean zhv;
  private String zhw;
  public int zhz;
  int zia;
  private com.tencent.mm.sdk.b.c zib;
  private com.tencent.mm.plugin.voip.video.a zle;
  private CaptureView zlf;
  private a zlg;
  private com.tencent.mm.plugin.voip.widget.d zlh;
  private byte[] zli;
  private int zlj;
  private boolean zlk;
  NetChangedBroadcastReceiver zll;
  private com.tencent.mm.plugin.voip.b.g zlm;
  private com.tencent.mm.plugin.voip.b.a zln;
  ap zlo;
  boolean zlp;
  
  public VoipMgr()
  {
    AppMethodBeat.i(114994);
    this.zlg = null;
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
    this.zhe = -1L;
    this.tCt = false;
    this.zhi = false;
    this.zhj = 0;
    this.zhl = new com.tencent.mm.plugin.voip.video.k();
    this.zhm = null;
    this.zhn = false;
    this.zho = false;
    this.zhp = 0;
    this.zhq = false;
    this.zhs = false;
    this.zhu = false;
    this.zhv = false;
    this.zhw = null;
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
    this.zli = null;
    this.zlj = 0;
    this.zlk = true;
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
    this.zlo = new ap("encodeVoipHandler");
    this.zhY = new BroadcastReceiver()
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
          VoipMgr.this.jz(true);
          AppMethodBeat.o(114963);
          return;
        }
        if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousContext))
        {
          VoipMgr.a(VoipMgr.this, true);
          if (!VoipMgr.a(VoipMgr.this)) {
            VoipMgr.this.jz(true);
          }
          if ((!com.tencent.mm.plugin.voip.b.i.QL(VoipMgr.b(VoipMgr.this).mState)) && (!VoipMgr.c(VoipMgr.this))) {
            VoipMgr.d(VoipMgr.this).dSr();
          }
        }
        AppMethodBeat.o(114963);
      }
    };
    this.szz = new com.tencent.mm.sdk.b.c() {};
    this.zia = 0;
    this.zlp = false;
    this.sBL = 0L;
    this.klv = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        int i = 1;
        AppMethodBeat.i(192014);
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        ad.i("MicroMsg.Voip.VoipMgr", "onCallStateChanged :%d, isStartVoip: %b,oldState:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(VoipMgr.w(VoipMgr.this)), Integer.valueOf(VoipMgr.x(VoipMgr.this)) });
        if (!VoipMgr.w(VoipMgr.this))
        {
          AppMethodBeat.o(192014);
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
          com.tencent.mm.plugin.voip.c.dRQ().Qf(1);
          VoipMgr.c(VoipMgr.this, true);
        }
        label327:
        label361:
        do
        {
          VoipMgr.d(VoipMgr.this).zhU = VoipMgr.F(VoipMgr.this);
          AppMethodBeat.o(192014);
          return;
          if (paramAnonymousInt == 2)
          {
            VoipMgr.b(VoipMgr.this, false);
            if (VoipMgr.x(VoipMgr.this) == 1) {
              VoipMgr.e(VoipMgr.this, System.currentTimeMillis());
            }
            VoipMgr.c(VoipMgr.this, 2);
            ad.i("MicroMsg.Voip.VoipMgr", "phone call coming now!");
            if ((VoipMgr.c(VoipMgr.this)) && (!com.tencent.mm.plugin.voip.b.i.QL(VoipMgr.b(VoipMgr.this).mState))) {
              com.tencent.mm.plugin.voip.c.dRQ().zlR.dUW();
            }
            String str2;
            String str1;
            if (com.tencent.mm.plugin.voip.b.i.QL(VoipMgr.b(VoipMgr.this).mState))
            {
              paramAnonymousString = aj.getContext().getString(2131764803, new Object[] { VoipMgr.um(bt.lZ(VoipMgr.z(VoipMgr.this))) });
              com.tencent.mm.plugin.voip.c.dRQ().dUx();
              str2 = VoipMgr.A(VoipMgr.this).field_username;
              if (!VoipMgr.g(VoipMgr.this)) {
                break label596;
              }
              str1 = bl.FzN;
              if (!VoipMgr.c(VoipMgr.this)) {
                break label604;
              }
            }
            for (paramAnonymousInt = i;; paramAnonymousInt = 0)
            {
              s.c(str2, str1, paramAnonymousInt, 6, paramAnonymousString);
              VoipMgr.d(VoipMgr.this, 4107);
              VoipMgr.B(VoipMgr.this);
              paramAnonymousString = new bl();
              paramAnonymousString.setType(10000);
              paramAnonymousString.kY(System.currentTimeMillis());
              paramAnonymousString.setStatus(6);
              paramAnonymousString.setContent(aj.getContext().getString(2131764801) + ", <a href=\"weixin://voip/callagain/?username=" + VoipMgr.f(VoipMgr.this) + "&isvideocall=" + VoipMgr.g(VoipMgr.this) + "\">" + aj.getContext().getString(2131764796) + "</a>");
              if ((VoipMgr.f(VoipMgr.this) != null) && (!VoipMgr.f(VoipMgr.this).equals("")))
              {
                paramAnonymousString.nY(VoipMgr.f(VoipMgr.this));
                ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).cOI().an(paramAnonymousString);
              }
              com.tencent.mm.plugin.voip.c.dRQ().Qf(2);
              VoipMgr.c(VoipMgr.this, false);
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
        if ((VoipMgr.x(VoipMgr.this) == 1) || (VoipMgr.x(VoipMgr.this) == 2)) {
          VoipMgr.e(VoipMgr.this, System.currentTimeMillis());
        }
        VoipMgr.c(VoipMgr.this, 0);
        com.tencent.mm.plugin.voip.c.dRQ().Qf(2);
        if ((1 == VoipMgr.C(VoipMgr.this)) && (com.tencent.mm.plugin.voip.b.i.QL(VoipMgr.b(VoipMgr.this).mState)) && (VoipMgr.D(VoipMgr.this))) {
          com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(192010);
              VoipMgr.d(VoipMgr.this).ck(true);
              AppMethodBeat.o(192010);
            }
          });
        }
        if ((4 == VoipMgr.C(VoipMgr.this)) && (VoipMgr.D(VoipMgr.this))) {
          com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(192011);
              VoipMgr.d(VoipMgr.this).aq(VoipMgr.E(VoipMgr.this), VoipMgr.g(VoipMgr.this));
              AppMethodBeat.o(192011);
            }
          });
        }
        VoipMgr.b(VoipMgr.this, false);
        if ((com.tencent.mm.compatible.b.g.Wk() != null) && (com.tencent.mm.plugin.audio.c.a.bvB().isBluetoothScoOn()))
        {
          ad.i("MicroMsg.Voip.VoipMgr", "is bluetooth can use and start bluetooth");
          com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(192012);
              VoipMgr.d(VoipMgr.this).aq(VoipMgr.E(VoipMgr.this), VoipMgr.g(VoipMgr.this));
              AppMethodBeat.o(192012);
            }
          });
        }
        for (;;)
        {
          VoipMgr.c(VoipMgr.this, false);
          break;
          if (com.tencent.mm.plugin.audio.c.a.bvB().bvw()) {
            com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(192013);
                VoipMgr.d(VoipMgr.this).aq(VoipMgr.E(VoipMgr.this), VoipMgr.g(VoipMgr.this));
                AppMethodBeat.o(192013);
              }
            });
          }
        }
      }
    };
    this.zib = new com.tencent.mm.sdk.b.c() {};
    this.zgO = new com.tencent.mm.plugin.voip.b.b();
    AppMethodBeat.o(114994);
  }
  
  private void E(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115047);
    if (this.zhV % 100 == 0) {
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
          ad.i("MicroMsg.Voip.VoipMgr", "onFrameDataReady, sample sendData:[%s, %s, %s, %s, %s], captureFrameCount:%s", new Object[] { Byte.valueOf(arrayOfByte[0]), Byte.valueOf(arrayOfByte[1]), Byte.valueOf(arrayOfByte[2]), Byte.valueOf(arrayOfByte[3]), Byte.valueOf(arrayOfByte[4]), Integer.valueOf(this.zhV) });
          paramInt2 = 0;
          paramInt1 = 0;
          break label288;
          if (paramInt1 >= 5)
          {
            paramArrayOfByte = t.zlN;
            t.dUt();
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
  
  private void PM(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(115019);
    ad.i("MicroMsg.Voip.VoipMgr", "hangupTalkingOrCancelInvite");
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
        ad.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call cancelCall");
        com.tencent.mm.plugin.voip.c.dRQ().zlR.dUV();
      }
      ad.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call hangUp");
      com.tencent.mm.plugin.voip.c.dRQ().zlR.dUY();
      if (4096 != this.zhb) {
        break label315;
      }
      sq(paramInt);
      dSv();
      AppMethodBeat.o(115019);
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
        AppMethodBeat.i(192031);
        VoipMgr.d(VoipMgr.this);
        com.tencent.mm.plugin.voip.b.b.rP(VoipMgr.g(VoipMgr.this));
        AppMethodBeat.o(192031);
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
    AppMethodBeat.o(115019);
  }
  
  private boolean PN(int paramInt)
  {
    AppMethodBeat.i(115024);
    if (4111 == paramInt)
    {
      AppMethodBeat.o(115024);
      return true;
    }
    if ((4101 == paramInt) && ((com.tencent.mm.plugin.voip.b.i.QL(this.zgP.mState)) || (this.zgY)))
    {
      AppMethodBeat.o(115024);
      return true;
    }
    AppMethodBeat.o(115024);
    return false;
  }
  
  private static void PO(int paramInt)
  {
    AppMethodBeat.i(115025);
    xy localxy = new xy();
    localxy.dEl.dbV = paramInt;
    com.tencent.mm.sdk.b.a.ESL.l(localxy);
    AppMethodBeat.o(115025);
  }
  
  private boolean d(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(115053);
    String str = com.tencent.mm.m.g.Zd().getValue("VOIPShortcutAutoadd");
    ad.i("MicroMsg.Voip.VoipMgr", "voip shortcut autoAdd is %s", new Object[] { str });
    if ((str != null) && (str.equals("0")) && (bt.lZ(this.zhe) > 30L))
    {
      int i = paramSharedPreferences.getInt("voip_shortcut_prompt_times", 0);
      boolean bool = paramSharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
      if ((i < 3) && (!bool))
      {
        dSE();
        paramSharedPreferences.edit().putInt("voip_shortcut_prompt_times", i + 1).commit();
        AppMethodBeat.o(115053);
        return true;
      }
    }
    else if ((str != null) && (str.equals("1")) && (bt.lZ(this.zhe) > 15L))
    {
      e(paramSharedPreferences);
      AppMethodBeat.o(115053);
      return false;
    }
    AppMethodBeat.o(115053);
    return false;
  }
  
  private void dSC()
  {
    AppMethodBeat.i(115048);
    synchronized (this.zgW)
    {
      dTR();
      com.tencent.mm.plugin.voip.b.b.NX();
      this.zgO.dSC();
      AppMethodBeat.o(115048);
      return;
    }
  }
  
  private boolean dSD()
  {
    AppMethodBeat.i(115052);
    if (com.tencent.mm.plugin.voip.b.i.QL(this.zgP.mState))
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
  
  private void dSE()
  {
    AppMethodBeat.i(115056);
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
          AppMethodBeat.i(192015);
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
          AppMethodBeat.o(192015);
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
  
  private void dSI()
  {
    AppMethodBeat.i(115062);
    if (this.zhl != null) {
      this.zhl.b(this);
    }
    if (this.zhm != null)
    {
      ad.d("MicroMsg.Voip.VoipMgr", "stop face detect timer");
      this.zhm.stopTimer();
    }
    AppMethodBeat.o(115062);
  }
  
  private boolean dSt()
  {
    int j = 0;
    AppMethodBeat.i(115021);
    if (!this.zgP.QP(4101))
    {
      AppMethodBeat.o(115021);
      return false;
    }
    this.zgZ = false;
    if (this.zlh != null) {
      this.zlh.zgZ = false;
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
        AppMethodBeat.o(115021);
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
    AppMethodBeat.i(115029);
    ad.d("MicroMsg.Voip.VoipMgr", "delayFinish");
    this.zhw = null;
    if (this.iDu != null) {
      this.iDu.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114964);
          VoipMgr localVoipMgr = VoipMgr.this;
          ad.i("MicroMsg.Voip.VoipMgr", "it is uninit voip report");
          if (localVoipMgr.zhR != null)
          {
            localVoipMgr.zhR.quit();
            localVoipMgr.zhR = null;
          }
          if (!localVoipMgr.zhO)
          {
            if (localVoipMgr.zia == 0) {
              localVoipMgr.PL(localVoipMgr.zhN);
            }
            if (localVoipMgr.zia != 0)
            {
              localVoipMgr.zhO = true;
              if (!localVoipMgr.zgY) {
                break label180;
              }
            }
          }
          label180:
          for (int i = 0;; i = 1)
          {
            com.tencent.mm.plugin.voip.b.c.a(i, System.currentTimeMillis(), localVoipMgr.zhN, localVoipMgr.zhN, 0, 0, VoipMgr.kxX / localVoipMgr.zia);
            VoipMgr.kxX = 0;
            VoipMgr.zhS[0] = 0;
            VoipMgr.zhS[1] = 0;
            localVoipMgr.zia = 0;
            if (localVoipMgr.nRA != null) {
              localVoipMgr.nRA.listen(localVoipMgr.zhQ, 0);
            }
            if (localVoipMgr.zll != null)
            {
              aj.getContext().unregisterReceiver(localVoipMgr.zll);
              localVoipMgr.zll = null;
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
  
  private static void dSw()
  {
    AppMethodBeat.i(192038);
    ww localww = new ww();
    localww.dCp.djq = 11;
    com.tencent.mm.sdk.b.a.ESL.l(localww);
    AppMethodBeat.o(192038);
  }
  
  private void dTQ()
  {
    AppMethodBeat.i(115043);
    if ((com.tencent.mm.compatible.util.d.lf(28)) && (this.zgZ) && (this.zle != null) && (!this.zle.cPP()) && (this.zgR != null))
    {
      ad.i("MicroMsg.Voip.VoipMgr", "video call accept, not previewing, api level: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      this.zle.dWV();
      this.zgR.dVK();
      int k = 320;
      int m = 240;
      int j = m;
      int i = k;
      if (this.zle == null)
      {
        j = m;
        i = k;
        if (com.tencent.mm.plugin.voip.b.i.QM(this.zgP.mState))
        {
          this.zlf = new CaptureView(aj.getContext());
          ad.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
          i = 640;
          j = 480;
        }
      }
      this.zle = new com.tencent.mm.plugin.voip.video.a(i, j);
      this.zle.a(this, true);
      this.zle.a(this.zlf);
      this.zle.dWU();
      this.zhV = 0;
    }
    AppMethodBeat.o(115043);
  }
  
  private void dTR()
  {
    AppMethodBeat.i(115049);
    ad.l("MicroMsg.Voip.VoipMgr", "uninitCaptureRender", new Object[0]);
    if (this.zle != null) {
      dSI();
    }
    try
    {
      this.zle.dWV();
      this.zle = null;
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
  
  private void dTS()
  {
    AppMethodBeat.i(192039);
    ad.i("MicroMsg.Voip.VoipMgr", "uninitSurfaceTexture!");
    if (this.zgR != null) {
      this.zgR.releaseSurfaceTexture();
    }
    AppMethodBeat.o(192039);
  }
  
  private void e(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(115054);
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
      AppMethodBeat.o(115054);
      return;
      localIntent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(2131755764));
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getContext(), 2131234599));
      localIntent1.putExtra("shortcut_icon_resource_id", 2131234599);
    }
  }
  
  private void fF(boolean paramBoolean)
  {
    AppMethodBeat.i(115030);
    ad.i("MicroMsg.Voip.VoipMgr", "finish");
    this.zhs = false;
    this.zhu = false;
    this.lastShakeTime = -1L;
    int i;
    Object localObject1;
    if (this.zlm != null) {
      if (this.zln != null)
      {
        i = this.zhz;
        localObject1 = this.zln;
        if ((i & 0x1) == 0) {
          break label773;
        }
        i = 1;
      }
    }
    for (;;)
    {
      ((com.tencent.mm.plugin.voip.b.a)localObject1).Q(false, i);
      this.zln.dWq();
      this.zlm.dWx();
      if (this.zlo != null)
      {
        this.zlo.removeCallbacksAndMessages(null);
        this.zlo = null;
      }
      if (this.zhj != -1)
      {
        com.tencent.mm.plugin.report.service.h.vKh.f(11700, new Object[] { Integer.valueOf(this.zhj), Long.valueOf(bt.lZ(this.zhe)) });
        this.zhj = -1;
      }
      try
      {
        aj.getContext().unregisterReceiver(this.zhY);
        label165:
        com.tencent.mm.sdk.b.a.ESL.d(this.szz);
        com.tencent.mm.sdk.b.a.ESL.d(this.zib);
        dTS();
        if (this.zgR != null)
        {
          this.zgR.uninit();
          this.zgR = null;
          this.zgO.b(this.zgR);
        }
        this.zlf = null;
        label245:
        int j;
        label264:
        label329:
        long l;
        if (com.tencent.mm.plugin.voip.c.dRQ() != null)
        {
          if (paramBoolean)
          {
            com.tencent.mm.plugin.voip.c.dRQ().dUy();
            if (!this.zgZ) {
              break label791;
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
            break label806;
          }
          this.zlg = new a();
          com.tencent.e.h.Iye.aP(this.zlg);
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
            ad.d("MicroMsg.Voip.VoipMgr", "removeSensorCallBack");
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
          ad.i("MicroMsg.Voip.VoipMgr", "finish, isFinishFromShutdown: %s", new Object[] { Boolean.valueOf(this.zgV) });
          if ((this.zgV) && (com.tencent.mm.plugin.voip.c.dRQ().dUN()))
          {
            com.tencent.mm.plugin.voip.c.dRQ();
            VoipScoreState.dUv();
            Object localObject2 = new Intent(getContext(), VoipScoreDialog.class);
            ((Intent)localObject2).putExtra("key_score_state", com.tencent.mm.plugin.voip.c.dRQ().dUP());
            if (!(getContext() instanceof Activity)) {
              ((Intent)localObject2).addFlags(268435456);
            }
            localObject1 = getContext();
            localObject2 = new com.tencent.mm.hellhoundlib.b.a().bd(localObject2);
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).adn(), "com/tencent/mm/plugin/voip/model/VoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/voip/model/VoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          com.tencent.mm.plugin.voip.c.dRQ().dUO();
          dSw();
          if (!this.zhJ)
          {
            j = com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.roomId;
            l = com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.sAY;
            if (!this.zgY) {
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
          com.tencent.mm.plugin.voip.b.c.c(j, l, i, 4);
          this.zhJ = true;
          this.zli = null;
          this.zlj = 0;
          ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
          com.tencent.mm.media.f.c.grn.ajW();
          AppMethodBeat.o(115030);
          return;
          i = 0;
          break;
          com.tencent.mm.plugin.voip.c.dRQ().zlR.dUY();
          break label245;
          com.tencent.mm.plugin.voip.c.dRQ().b(false, false, this.flk);
          break label264;
          dSC();
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
    if (this.zgR != null) {
      localContext1 = this.zgR.dVM();
    }
    Context localContext2 = localContext1;
    if (localContext1 == null) {
      localContext2 = aj.getContext();
    }
    AppMethodBeat.o(115055);
    return localContext2;
  }
  
  private static String mz(long paramLong)
  {
    AppMethodBeat.i(115045);
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
    AppMethodBeat.o(115045);
    return str;
  }
  
  private void rB(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(115015);
    if (this.zgZ)
    {
      ad.i("MicroMsg.Voip.VoipMgr", "setCameraCaptureBind,  isFace: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      ad.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
      if (this.zle == null) {
        this.zle = new com.tencent.mm.plugin.voip.video.a(640, 480);
      }
      if (this.zle.a(this, paramBoolean) != 1) {
        break label159;
      }
    }
    label159:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.zlk = paramBoolean;
      if ((this.zlk) && (this.zlf != null))
      {
        this.zle.a(this.zlf);
        com.tencent.mm.plugin.voip.c.dRQ().Ql(this.zle.dWY());
        if (this.iDu != null) {
          this.iDu.postDelayed(new VoipMgr.20(this), 50L);
        }
      }
      AppMethodBeat.o(115015);
      return;
    }
  }
  
  private void sq(final int paramInt)
  {
    AppMethodBeat.i(115023);
    ad.l("MicroMsg.Voip.VoipMgr", "swtchState, action: %s, currentState: %s", new Object[] { com.tencent.mm.plugin.voip.b.i.QI(paramInt), com.tencent.mm.plugin.voip.b.i.QI(this.zgP.mState) });
    if ((4101 == paramInt) && (com.tencent.mm.plugin.voip.b.i.QM(this.zgP.mState)))
    {
      dTR();
      this.zgZ = false;
      if (this.zlh != null) {
        this.zlh.zgZ = false;
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
          AppMethodBeat.i(114991);
          if (VoipMgr.q(VoipMgr.this) != null) {
            VoipMgr.q(VoipMgr.this).hS(paramInt, VoipMgr.b(VoipMgr.this).mState);
          }
          AppMethodBeat.o(114991);
        }
      });
    }
    switch (this.zgP.mState)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(115023);
      return;
      PO(5);
      AppMethodBeat.o(115023);
      return;
      PO(6);
    }
  }
  
  final void PL(int paramInt)
  {
    AppMethodBeat.i(115013);
    if (paramInt == 5)
    {
      kxX += zhS[0];
      this.zia += 1;
      ad.i("MicroMsg.Voip.VoipMgr", "mSignalStrength 4G" + zhS[0] + " and index is " + this.zia);
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
        ad.i("MicroMsg.Voip.VoipMgr", "error happened in get wifi info");
        continue;
      }
      kxX += zhS[1];
      this.zia += 1;
      ad.i("MicroMsg.Voip.VoipMgr", "mSignalStrength WIFI " + zhS[1] + " and index is " + this.zia);
      AppMethodBeat.o(115013);
      return;
      paramInt = localWifiManager.getConnectionInfo().getRssi();
    }
  }
  
  public final void PP(int paramInt)
  {
    AppMethodBeat.i(115035);
    ad.i("MicroMsg.Voip.VoipMgr", "remote voip mode changed, cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    if (((1 == paramInt) || (3 == paramInt) || (5 == paramInt) || (6 == paramInt) || (7 == paramInt)) && (this.zgZ))
    {
      sq(4101);
      com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.dTh();
      com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.dTi();
    }
    AppMethodBeat.o(115035);
  }
  
  public final void PQ(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(115040);
    ad.i("MicroMsg.Voip.VoipMgr", "onSessionBeingCalled, callType: ".concat(String.valueOf(paramInt)));
    if (!this.zgP.QP(4110))
    {
      AppMethodBeat.o(115040);
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
      AppMethodBeat.o(115040);
      return;
    }
  }
  
  public final void PR(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(115041);
    ad.i("MicroMsg.Voip.VoipMgr", "steve:[simucall]onNewSimulCallAutoAccept, callType: ".concat(String.valueOf(paramInt)));
    if (!this.zgP.QP(4100))
    {
      AppMethodBeat.o(115041);
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
      AppMethodBeat.o(115041);
      return;
    }
  }
  
  public final void W(long paramLong, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(192036);
    Object localObject;
    label50:
    boolean bool;
    if (this.zlm != null) {
      switch (paramInt)
      {
      default: 
        localObject = this.zlm;
        if (1 == this.mUIType)
        {
          bool = this.zlp;
          switch (paramInt)
          {
          }
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(192036);
      return;
      if (1 == this.mUIType)
      {
        if (!com.tencent.mm.plugin.voip.c.dRQ().zmf)
        {
          localObject = this.zlm;
          if ((260 != this.zgP.mState) && (6 != this.zgP.mState)) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.plugin.voip.b.g)localObject).as(true, bool);
            com.tencent.mm.plugin.voip.c.dRQ().zmf = true;
            break;
          }
        }
        localObject = this.zlm;
        if ((260 != this.zgP.mState) && (6 != this.zgP.mState)) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.voip.b.g)localObject).at(true, bool);
          break;
        }
      }
      if (!com.tencent.mm.plugin.voip.c.dRQ().zme)
      {
        localObject = this.zlm;
        if ((260 != this.zgP.mState) && (6 != this.zgP.mState)) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.voip.b.g)localObject).as(false, bool);
          com.tencent.mm.plugin.voip.c.dRQ().zmf = true;
          break;
        }
      }
      localObject = this.zlm;
      if ((260 != this.zgP.mState) && (6 != this.zgP.mState)) {}
      for (bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.voip.b.g)localObject).at(false, bool);
        break;
      }
      i = 0;
      break label50;
      ((com.tencent.mm.plugin.voip.b.g)localObject).ztw += 1;
      if (((com.tencent.mm.plugin.voip.b.g)localObject).ztw == 0)
      {
        if (i != 0)
        {
          if (paramLong != -1L)
          {
            localObject = com.tencent.mm.plugin.voip.b.d.ztm;
            com.tencent.mm.plugin.voip.b.d.ux(paramLong);
            AppMethodBeat.o(192036);
          }
        }
        else
        {
          if (paramLong != -1L)
          {
            localObject = com.tencent.mm.plugin.voip.b.d.ztm;
            com.tencent.mm.plugin.voip.b.d.uy(paramLong);
          }
          AppMethodBeat.o(192036);
        }
      }
      else if (((com.tencent.mm.plugin.voip.b.g)localObject).ztw == 60) {
        ((com.tencent.mm.plugin.voip.b.g)localObject).ztw = -1;
      }
      AppMethodBeat.o(192036);
      return;
      ((com.tencent.mm.plugin.voip.b.g)localObject).ztx += 1;
      if (((com.tencent.mm.plugin.voip.b.g)localObject).ztx == 0)
      {
        if (i != 0)
        {
          if (paramLong > 0L)
          {
            if (bool)
            {
              localObject = com.tencent.mm.plugin.voip.b.d.ztm;
              com.tencent.mm.plugin.voip.b.d.uE(paramLong);
              AppMethodBeat.o(192036);
              return;
            }
            localObject = com.tencent.mm.plugin.voip.b.d.ztm;
            com.tencent.mm.plugin.voip.b.d.uB(paramLong);
            AppMethodBeat.o(192036);
          }
        }
        else
        {
          if (paramLong > 0L)
          {
            if (bool)
            {
              localObject = com.tencent.mm.plugin.voip.b.d.ztm;
              com.tencent.mm.plugin.voip.b.d.uD(paramLong);
              AppMethodBeat.o(192036);
              return;
            }
            localObject = com.tencent.mm.plugin.voip.b.d.ztm;
            com.tencent.mm.plugin.voip.b.d.uC(paramLong);
          }
          AppMethodBeat.o(192036);
        }
      }
      else if (((com.tencent.mm.plugin.voip.b.g)localObject).ztx == 30) {
        ((com.tencent.mm.plugin.voip.b.g)localObject).ztx = -1;
      }
      AppMethodBeat.o(192036);
      return;
      ((com.tencent.mm.plugin.voip.b.g)localObject).zty += 1;
      if (((com.tencent.mm.plugin.voip.b.g)localObject).zty == 0)
      {
        if (i != 0)
        {
          localObject = com.tencent.mm.plugin.voip.b.d.ztm;
          com.tencent.mm.plugin.voip.b.d.uz(paramLong);
          AppMethodBeat.o(192036);
          return;
        }
        localObject = com.tencent.mm.plugin.voip.b.d.ztm;
        com.tencent.mm.plugin.voip.b.d.uA(paramLong);
        AppMethodBeat.o(192036);
        return;
      }
      if (((com.tencent.mm.plugin.voip.b.g)localObject).zty == 60) {
        ((com.tencent.mm.plugin.voip.b.g)localObject).zty = -1;
      }
    }
  }
  
  public final void a(final Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 1;
    AppMethodBeat.i(192032);
    ad.i("MicroMsg.Voip.VoipMgr", "start VoIP, userName: %s, isOutCall: %b, isVideoCall: %b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
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
          break label592;
        }
        i = 1;
        com.tencent.mm.plugin.voip.c.dRQ().Qd(1);
      }
      if (!paramBoolean1) {
        break label612;
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
            break label624;
          }
          i = 0;
          ((com.tencent.mm.plugin.report.service.h)localObject1).f(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
        }
        if (!bool2)
        {
          localObject1 = com.tencent.mm.plugin.report.service.h.vKh;
          if (!this.zgZ) {
            break label630;
          }
          i = 0;
          ((com.tencent.mm.plugin.report.service.h)localObject1).f(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
        }
      }
      if ((!bool2) || (!bool1))
      {
        if ((bool1) || (bool2)) {
          break label636;
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
          AppMethodBeat.i(192026);
          ad.i("MicroMsg.Voip.VoipMgr", "show Permission settings");
          com.tencent.mm.compatible.d.b.bY(paramContext);
          if (!VoipMgr.c(VoipMgr.this))
          {
            if (VoipMgr.g(VoipMgr.this))
            {
              VoipMgr.this.dSc();
              AppMethodBeat.o(192026);
              return;
            }
            VoipMgr.this.dSf();
            AppMethodBeat.o(192026);
            return;
          }
          if (VoipMgr.g(VoipMgr.this))
          {
            VoipMgr.this.dSh();
            AppMethodBeat.o(192026);
            return;
          }
          VoipMgr.this.dSi();
          AppMethodBeat.o(192026);
        }
      });
      ad.i("MicroMsg.Voip.VoipMgr", "initMgr");
      com.tencent.mm.booter.a.Ti().Tk();
      if (this.zgZ)
      {
        com.tencent.mm.plugin.voip.c.dRQ().b(true, true, this.flk);
        label438:
        if (!this.zgY) {
          break label721;
        }
        com.tencent.mm.plugin.voip.c.dRQ().zlR.dUU();
        if (!this.zgZ) {
          break label703;
        }
        i = com.tencent.mm.plugin.voip.c.dRQ().ath(this.zgX.field_username);
        label476:
        if (i >= 0) {
          break label721;
        }
        fF(false);
        i = 0;
        if (i != 0)
        {
          this.zgO.ar(paramBoolean2, paramBoolean1);
          if (paramBoolean2)
          {
            this.zlm = new com.tencent.mm.plugin.voip.b.g();
            this.zln = new com.tencent.mm.plugin.voip.b.a();
            i = this.zhz;
            paramContext = this.zln;
            if ((i & 0x1) == 0) {
              break label1152;
            }
          }
        }
      }
      label1152:
      for (i = k;; i = 0)
      {
        paramContext.Q(false, i);
        this.zln.dWp();
        com.tencent.mm.plugin.voip.c.dRQ().h(paramString, this.zgZ, false);
        AppMethodBeat.o(192032);
        return;
        bool1 = false;
        break;
        label592:
        i = j;
        if (256 != j) {
          break label193;
        }
        i = 257;
        break label193;
        label612:
        this.zgP = com.tencent.mm.plugin.voip.b.i.QJ(i);
        break label213;
        label624:
        i = 1;
        break label266;
        label630:
        i = 1;
        break label313;
        label636:
        if (!bool1)
        {
          localObject1 = paramContext.getString(2131764922);
          localObject2 = paramContext.getString(2131764888);
          break label378;
        }
        if (bool2) {
          break label1158;
        }
        localObject1 = paramContext.getString(2131764921);
        localObject2 = paramContext.getString(2131764889);
        break label378;
        com.tencent.mm.plugin.voip.c.dRQ().b(true, false, this.flk);
        break label438;
        label703:
        i = com.tencent.mm.plugin.voip.c.dRQ().atg(this.zgX.field_username);
        break label476;
        label721:
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
                label867:
                ((List)localObject2).add(0, this.flk);
              }
              localObject2 = bt.n((List)localObject2, ";");
              ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
              label910:
              com.tencent.mm.sdk.b.a.ESL.c(this.zib);
              com.tencent.mm.sdk.b.a.ESL.c(this.szz);
              this.zhl.a(this);
              paramContext = new IntentFilter();
              paramContext.addAction("android.intent.action.SCREEN_ON");
              paramContext.addAction("android.intent.action.SCREEN_OFF");
              paramContext.addAction("android.intent.action.USER_PRESENT");
              aj.getContext().registerReceiver(this.zhY, paramContext);
              this.orl = new SensorController(getContext());
              ad.i("MicroMsg.Voip.VoipMgr", "initMgr setSensorCallBack");
              this.orl.a(this);
              if (this.ork == null)
              {
                this.ork = new bk(getContext());
                paramContext = new VoipMgr.17(this);
                if (!this.ork.aC(paramContext)) {
                  break label1142;
                }
              }
            }
          }
        }
        label1142:
        for (this.lastShakeTime = 0L;; this.lastShakeTime = -1L)
        {
          i = 1;
          break;
          if (4 != i) {
            break label867;
          }
          ((List)localObject2).remove(i - 1);
          break label867;
          localObject2 = new ArrayList();
          ((List)localObject2).add(0, this.flk);
          localObject2 = bt.n((List)localObject2, ";");
          ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
          break label910;
        }
      }
      label1158:
      localObject2 = null;
      localObject1 = null;
    }
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    AppMethodBeat.i(115016);
    ad.i("MicroMsg.Voip.VoipMgr", "onVoipUIDestroy");
    if (this.zgR == paramb)
    {
      ad.d("MicroMsg.Voip.VoipMgr", "same mVoIPUi, clear it");
      this.zgR = null;
      this.zgO.b(null);
    }
    if (this.iDu != null) {
      this.iDu = null;
    }
    AppMethodBeat.o(115016);
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb, int paramInt)
  {
    AppMethodBeat.i(115011);
    ad.i("MicroMsg.Voip.VoipMgr", "onVoipUICreated, uiType: %s, captureRender: %s, mVoicePlayDevice: %s", new Object[] { Integer.valueOf(paramInt), this.zle, Integer.valueOf(this.zhd) });
    if ((1 == paramInt) && (this.zgR != null)) {
      this.zgR.uninit();
    }
    this.zgR = paramb;
    this.mUIType = paramInt;
    this.zgO.b(this.zgR);
    if ((this.zle == null) && (com.tencent.mm.plugin.voip.b.i.QM(this.zgP.mState))) {
      this.zlf = new CaptureView(aj.getContext());
    }
    this.zgR.hS(-1, this.zgP.mState);
    this.zgR.setConnectSec(this.zhe);
    ad.i("MicroMsg.Voip.VoipMgr", "steve: voipMgr decMode:%d, beautyCmd:%d", new Object[] { Integer.valueOf(this.zhz), Integer.valueOf(this.zhA) });
    if (this.zhz != -1)
    {
      this.zgR.setHWDecMode(this.zhz);
      ad.i("MicroMsg.Voip.VoipMgr", "steve: voipMgr setHWDecMode,decMode:%d", new Object[] { Integer.valueOf(this.zhz) });
    }
    this.zgR.setVoipBeauty(this.zhA);
    com.tencent.mm.plugin.voip.video.b.e.dXC().zya = new VoipMgr.18(this);
    if ((this.zhL != 0) && (this.zhM != 0)) {
      hP(this.zhL, this.zhM);
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
    if (this.zhi)
    {
      AppMethodBeat.o(115046);
      return;
    }
    if (this.zle == null)
    {
      ad.e("MicroMsg.Voip.VoipMgr", "onFrameDataReady, captureRender is null!");
      AppMethodBeat.o(115046);
      return;
    }
    int n;
    int i1;
    label73:
    int k;
    int j;
    label100:
    int i;
    label113:
    byte[] arrayOfByte;
    label144:
    long l;
    int m;
    if (this.zle.dWW())
    {
      n = OpenGlRender.FLAG_Mirror;
      if (!this.zle.dWX()) {
        break label452;
      }
      i1 = OpenGlRender.FLAG_Angle270;
      if (this.zgR != null)
      {
        k = 0;
        if ((OpenGlRender.getGLVersion() != 2) || (this.zhA == 0)) {
          break label460;
        }
        j = 1;
        if ((this.zhA & 0x8) == 0) {
          break label466;
        }
        i = 1;
        if (j == 0) {
          break label559;
        }
        if ((i != 0) || (this.zgR.Qu(2) == null)) {
          break label472;
        }
        i = 1;
        this.zlj = 0;
        if ((!this.zle.dWW()) || (j == 0) || (i == 0)) {
          break label660;
        }
        if (i != 1) {
          break label565;
        }
        arrayOfByte = this.zgR.Qu(2).zxj;
        l = arrayOfByte.length;
        this.zli = arrayOfByte;
        k = paramInt2;
        j = paramInt1;
        m = 4;
      }
    }
    for (;;)
    {
      label208:
      this.zlp = true;
      int i2 = m;
      m = k;
      k = j;
      j = i2;
      label229:
      ad.d("MicroMsg.Voip.VoipMgr", "jcchen capture data: w=" + paramInt1 + "h=" + paramInt2 + ", vw=" + k + "vh=" + m + ", bm=" + i + ", skip:" + this.zhW);
      i = (int)l;
      if (this.zlo != null) {
        this.zlo.post(new VoipMgr.5(this, arrayOfByte, i, j, k, m));
      }
      this.zgR.a(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, n, i1);
      E(arrayOfByte, paramInt1, paramInt2);
      this.zhV += 1;
      boolean bool;
      if (n == OpenGlRender.FLAG_Mirror)
      {
        bool = true;
        label403:
        this.zho = bool;
        if (i1 != OpenGlRender.FLAG_Angle270) {
          break label695;
        }
      }
      label559:
      label565:
      label695:
      for (paramInt3 = 270;; paramInt3 = 90)
      {
        this.zhp = paramInt3;
        this.zhl.setPreviewSize(paramInt1, paramInt2);
        AppMethodBeat.o(115046);
        return;
        n = 0;
        break;
        label452:
        i1 = OpenGlRender.FLAG_Angle90;
        break label73;
        label460:
        j = 0;
        break label100;
        label466:
        i = 0;
        break label113;
        label472:
        if ((i != 0) && (this.zgR.Qu(1) != null) && (this.zgR.Qu(1).zxj != null))
        {
          i = 2;
          this.zlj = 0;
          break label144;
        }
        if ((this.zli != null) && (this.zlj <= 10))
        {
          i = 3;
          this.zlj += 1;
          break label144;
        }
        j = 0;
        i = k;
        break label144;
        i = 0;
        break label144;
        if (i == 2)
        {
          com.tencent.mm.plugin.voip.video.b.a locala = this.zgR.Qu(1);
          arrayOfByte = locala.zxj;
          m = 4;
          l = arrayOfByte.length;
          j = locala.width;
          k = locala.height;
          this.zli = arrayOfByte;
          break label208;
        }
        if (i != 3) {
          break label702;
        }
        arrayOfByte = this.zli;
        l = arrayOfByte.length;
        this.zli = arrayOfByte;
        k = paramInt2;
        j = paramInt1;
        m = 4;
        break label208;
        j = paramInt3 + paramInt4;
        this.zlp = false;
        l = paramLong;
        m = paramInt2;
        k = paramInt1;
        arrayOfByte = paramArrayOfByte;
        break label229;
        bool = false;
        break label403;
      }
      label660:
      label702:
      l = paramLong;
      k = paramInt2;
      j = paramInt1;
      arrayOfByte = null;
      m = paramInt3 + paramInt4;
    }
  }
  
  public final void a(int[] paramArrayOfInt, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(115063);
    if ((!this.zlk) && (this.zgZ))
    {
      rB(true);
      this.zlk = true;
    }
    com.tencent.mm.sdk.platformtools.aq.f(new VoipMgr.14(this, paramArrayOfInt, paramBoolean, paramInt));
    AppMethodBeat.o(115063);
  }
  
  public final void al(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(192035);
    if (this.zlm != null)
    {
      com.tencent.mm.plugin.voip.b.g localg = this.zlm;
      long l = bt.GC();
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          localg.ztA = l;
          AppMethodBeat.o(192035);
          return;
        }
        localg.zts = l;
        AppMethodBeat.o(192035);
        return;
      }
      if (paramBoolean2)
      {
        localg.ztB = l;
        AppMethodBeat.o(192035);
        return;
      }
      localg.ztt = l;
    }
    AppMethodBeat.o(192035);
  }
  
  public final void atd(String paramString)
  {
    AppMethodBeat.i(192037);
    if (this.zgR != null)
    {
      this.zhw = paramString;
      this.zgR.atj(paramString);
    }
    AppMethodBeat.o(192037);
  }
  
  public final void bOf()
  {
    AppMethodBeat.i(115061);
    if ((true == this.tCt) || (this.zgR == null) || (this.zgR.dVM() == null))
    {
      ad.d("MicroMsg.Voip.VoipMgr", "onCameraError, already show");
      AppMethodBeat.o(115061);
      return;
    }
    if (this.zle.cPP())
    {
      AppMethodBeat.o(115061);
      return;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("meizu")) && (!com.tencent.mm.compatible.d.b.XC()))
    {
      ad.d("MicroMsg.Voip.VoipMgr", "onCameraError, meizu machine");
      AppMethodBeat.o(115061);
      return;
    }
    if ((com.tencent.mm.compatible.util.d.lf(28)) && (((KeyguardManager)aj.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()))
    {
      ad.i("MicroMsg.Voip.VoipMgr", "api level: %s, in keyguard, ignore", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(115061);
      return;
    }
    ad.d("MicroMsg.Voip.VoipMgr", "onCameraError, show dialog");
    Object localObject = com.tencent.mm.plugin.report.service.h.vKh;
    if (this.zgZ) {}
    for (int i = 0;; i = 1)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).f(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      localObject = com.tencent.mm.ui.base.h.j(this.zgR.dVM(), 2131764896, 2131755906);
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
    this.tCt = true;
    f.dWy();
    AppMethodBeat.o(115061);
  }
  
  public final void cGD()
  {
    AppMethodBeat.i(115027);
    ad.i("MicroMsg.Voip.VoipMgr", "on accept");
    dSr();
    sq(4100);
    AppMethodBeat.o(115027);
  }
  
  public final void cGJ()
  {
    AppMethodBeat.i(115051);
    ad.i("MicroMsg.Voip.VoipMgr", "onResumeGoodNetStatus");
    if (this.zgR != null) {
      this.zgR.cIC();
    }
    AppMethodBeat.o(115051);
  }
  
  public final void cSz()
  {
    AppMethodBeat.i(184052);
    if (this.zgR != null) {
      this.zgR.cSz();
    }
    AppMethodBeat.o(184052);
  }
  
  public final void d(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115036);
    if (this.zgR != null) {
      this.zgR.e(paramInt1, paramInt2, paramArrayOfByte);
    }
    AppMethodBeat.o(115036);
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
    AppMethodBeat.i(115042);
    ad.d("MicroMsg.Voip.VoipMgr", "onPretreatmentForStartDev");
    this.zgO.aq(this.zhv, this.zgZ);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
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
    dTQ();
    AppMethodBeat.o(115042);
  }
  
  public final long dSB()
  {
    AppMethodBeat.i(115044);
    ad.m("MicroMsg.Voip.VoipMgr", "totalDeviceNearTime: %s", new Object[] { Long.valueOf(this.zhD) });
    long l = this.zhD / 1000L;
    AppMethodBeat.o(115044);
    return l;
  }
  
  public final void dSF()
  {
    AppMethodBeat.i(115058);
    if ((256 != this.zgP.mState) && (257 != this.zgP.mState))
    {
      AppMethodBeat.o(115058);
      return;
    }
    if ((com.tencent.mm.kernel.g.afB().afk().getInt(327945, 0) == 0) && (this.zgR.dVM() != null))
    {
      com.tencent.mm.kernel.g.afB().afk().setInt(327945, 1);
      com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.a(this.zgR.dVM(), 2131764868, 2131755906, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(192017);
          VoipMgr.this.dSH();
          AppMethodBeat.o(192017);
        }
      });
      locald.setCancelable(false);
      locald.setCanceledOnTouchOutside(false);
      locald.show();
      AppMethodBeat.o(115058);
      return;
    }
    com.tencent.mm.plugin.voip.b.k.gq(aj.getContext());
    dSH();
    AppMethodBeat.o(115058);
  }
  
  public final void dSG()
  {
    AppMethodBeat.i(115059);
    if (!this.zhn) {}
    for (boolean bool = true;; bool = false)
    {
      this.zhn = bool;
      if (!this.zhn) {
        break;
      }
      this.zhm.stopTimer();
      AppMethodBeat.o(115059);
      return;
    }
    if (this.zhm == null) {
      this.zhm = new av("faceDetect", new VoipMgr.13(this), true);
    }
    this.zhm.av(2000L, 2000L);
    this.zhn = false;
    AppMethodBeat.o(115059);
  }
  
  public final void dSH()
  {
    AppMethodBeat.i(115060);
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
            AppMethodBeat.i(192018);
            VoipMgr.K(VoipMgr.this);
            AppMethodBeat.o(192018);
          }
        }, 2000L);
      }
      AppMethodBeat.o(115060);
      return;
      str1 = bl.FzM;
      break;
    }
  }
  
  public final boolean dSa()
  {
    AppMethodBeat.i(115003);
    if (!this.zgP.QP(4103))
    {
      AppMethodBeat.o(115003);
      return false;
    }
    PM(4103);
    com.tencent.mm.plugin.voip.c.dRQ().dUM();
    AppMethodBeat.o(115003);
    return true;
  }
  
  public final boolean dSb()
  {
    AppMethodBeat.i(115004);
    if (!this.zgP.QP(4101))
    {
      AppMethodBeat.o(115004);
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
      AppMethodBeat.o(115004);
      return true;
    }
  }
  
  public final boolean dSc()
  {
    int i = 0;
    AppMethodBeat.i(115005);
    if (!this.zgP.QP(4099))
    {
      AppMethodBeat.o(115005);
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
      AppMethodBeat.o(115005);
      return true;
    }
  }
  
  public final boolean dSd()
  {
    AppMethodBeat.i(115006);
    if (!this.zgP.QP(4100))
    {
      AppMethodBeat.o(115006);
      return false;
    }
    if ((ae.fFw.fAY == 1) && (this.zgZ)) {
      rB(true);
    }
    if (((!this.zlk) || (ae.fFw.fAY == 1) || (ae.fFw.fAZ == 1)) && (this.zgZ)) {
      if ((this.zle != null) && (!this.zle.dWW())) {
        break label152;
      }
    }
    label152:
    for (boolean bool = true;; bool = false)
    {
      rB(bool);
      this.zlk = true;
      ad.i("MicroMsg.Voip.VoipMgr", "onAcceptVideoInvite");
      dSr();
      com.tencent.mm.plugin.voip.c.dRQ().an(false, this.zgZ);
      sq(4100);
      AppMethodBeat.o(115006);
      return true;
    }
  }
  
  public final void dSe()
  {
    this.zlk = false;
  }
  
  public final boolean dSf()
  {
    int i = 0;
    AppMethodBeat.i(115007);
    if (!this.zgP.QP(4099))
    {
      AppMethodBeat.o(115007);
      return false;
    }
    ad.i("MicroMsg.Voip.VoipMgr", "onRejectVoiceInvite");
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
      AppMethodBeat.o(115007);
      return true;
    }
  }
  
  public final boolean dSg()
  {
    AppMethodBeat.i(115008);
    if (!this.zgP.QP(4100))
    {
      AppMethodBeat.o(115008);
      return false;
    }
    ad.i("MicroMsg.Voip.VoipMgr", "onAcceptVoiceInvite");
    dSr();
    com.tencent.mm.plugin.voip.c.dRQ().an(true, this.zgZ);
    sq(4111);
    sq(4100);
    AppMethodBeat.o(115008);
    return true;
  }
  
  public final boolean dSh()
  {
    AppMethodBeat.i(115009);
    if (!this.zgP.QP(4098))
    {
      AppMethodBeat.o(115009);
      return false;
    }
    ad.i("MicroMsg.Voip.VoipMgr", "onCancelVideoInvite");
    PM(4098);
    com.tencent.mm.plugin.voip.c.dRQ().dUM();
    AppMethodBeat.o(115009);
    return true;
  }
  
  public final boolean dSi()
  {
    AppMethodBeat.i(115010);
    if (!this.zgP.QP(4098))
    {
      AppMethodBeat.o(115010);
      return false;
    }
    ad.i("MicroMsg.Voip.VoipMgr", "onCancelVoiceInvite");
    PM(4098);
    com.tencent.mm.plugin.voip.c.dRQ().dUM();
    AppMethodBeat.o(115010);
    return true;
  }
  
  public final void dSj()
  {
    AppMethodBeat.i(115012);
    if ((this.zgZ) && (this.zgR != null))
    {
      this.zgR.setCaptureView(this.zlf);
      if ((ae.fFw.fAY == 0) || (this.zgY)) {
        if ((this.zle != null) && (!this.zle.dWW())) {
          break label145;
        }
      }
    }
    label145:
    for (boolean bool = true;; bool = false)
    {
      rB(bool);
      if ((this.zgY) && (com.tencent.mm.plugin.voip.b.i.QN(this.zgP.mState)) && (com.tencent.mm.plugin.voip.c.dRQ().zlR.cSx()))
      {
        this.zgO.ar(this.zgZ, this.zgY);
        this.zgO.b("voip", Integer.valueOf(this.zhd));
      }
      AppMethodBeat.o(115012);
      return;
    }
  }
  
  public final void dSk()
  {
    AppMethodBeat.i(115014);
    ad.i("MicroMsg.Voip.VoipMgr", "it is init voip report");
    this.zll = new NetChangedBroadcastReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    aj.getContext().registerReceiver(this.zll, localIntentFilter);
    this.nRA = ((TelephonyManager)aj.getContext().getSystemService("phone"));
    this.zhN = com.tencent.mm.plugin.voip.b.c.getNetType(getContext());
    this.zhQ = new VoipMgr.19(this);
    this.nRA.listen(this.zhQ, 256);
    AppMethodBeat.o(115014);
  }
  
  public final void dSm()
  {
    AppMethodBeat.i(115017);
    ad.i("MicroMsg.Voip.VoipMgr", "onSwitchCamera");
    if (this.zle != null) {
      this.zle.dWT();
    }
    com.tencent.mm.plugin.report.service.h.vKh.f(11079, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(115017);
  }
  
  public final void dSn()
  {
    AppMethodBeat.i(115018);
    if (true != this.zle.dWW()) {
      dSm();
    }
    AppMethodBeat.o(115018);
  }
  
  public final void dSo() {}
  
  public final void dSp() {}
  
  public final void dSq() {}
  
  public final void dSr()
  {
    AppMethodBeat.i(192034);
    if (this.zgO != null)
    {
      ad.i("MicroMsg.Voip.VoipMgr", "use audioManager to stop voip ring");
      this.zgO.dSr();
      AppMethodBeat.o(192034);
      return;
    }
    ad.i("MicroMsg.Voip.VoipMgr", "use Subcore to stop voip ring");
    com.tencent.mm.plugin.voip.c.dRQ().zlR.stopRing();
    AppMethodBeat.o(192034);
  }
  
  public final boolean dSs()
  {
    AppMethodBeat.i(115020);
    if (com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.roomId == 0)
    {
      this.zhc = true;
      AppMethodBeat.o(115020);
      return true;
    }
    boolean bool = dSt();
    AppMethodBeat.o(115020);
    return bool;
  }
  
  public final void dSu()
  {
    AppMethodBeat.i(115022);
    ad.i("MicroMsg.Voip.VoipMgr", "onRoomReady");
    if ((this.zhc) && (com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.roomId != 0))
    {
      this.zhc = false;
      dSt();
    }
    if (this.zgY) {
      sq(4097);
    }
    AppMethodBeat.o(115022);
  }
  
  public final void dSx()
  {
    AppMethodBeat.i(115031);
    ad.i("MicroMsg.Voip.VoipMgr", "onNoResp");
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
      AppMethodBeat.o(115031);
      return;
      str1 = bl.FzM;
      break;
    }
  }
  
  public final void dSy()
  {
    int j = 0;
    AppMethodBeat.i(115033);
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
        break label205;
      }
    }
    label205:
    for (int i = j;; i = 1)
    {
      com.tencent.mm.plugin.voip.b.c.c(k, l1, i, 3);
      if (this.zhR != null) {
        this.zhR.post(new Runnable()
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
  
  public final void dSz()
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
      AppMethodBeat.o(115034);
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
  
  public final void hP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115039);
    ad.i("MicroMsg.Voip.VoipMgr", "adjustHWViewAspectRatio, HWDecsize:%dx%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.zhL = paramInt1;
    this.zhM = paramInt2;
    if (this.zgR != null) {
      this.zgR.hP(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115039);
  }
  
  public final void jz(boolean paramBoolean)
  {
    AppMethodBeat.i(114995);
    ad.m("MicroMsg.Voip.VoipMgr", "onSensorEvent, isON: %s, lastIsDeviceNear: %s, deviceSwitchNearScreenTick: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(this.zhC), Long.valueOf(this.zhB) });
    if (this.zgP == null)
    {
      ad.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, not create stateMachine yet, ignore");
      AppMethodBeat.o(114995);
      return;
    }
    if (this.orj)
    {
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        this.orj = paramBoolean;
        ad.i("MicroMsg.Voip.VoipMgr", "onSensorEvent has skip and val is %s", new Object[] { Boolean.valueOf(this.orj) });
        AppMethodBeat.o(114995);
        return;
      }
    }
    if ((Math.abs(bt.GC() - this.zhE) < 500L) && (this.zhE != -1L))
    {
      ad.i("MicroMsg.Voip.VoipMgr", "onSensorEvent time interval too small");
      AppMethodBeat.o(114995);
      return;
    }
    if ((((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pvC, true)) && (!paramBoolean) && (this.lastShakeTime != -1L) && (bt.aS(this.lastShakeTime) > 400L))
    {
      this.orj = true;
      ad.i("MicroMsg.Voip.VoipMgr", "onSensorEvent has skip case shake near to small");
      AppMethodBeat.o(114995);
      return;
    }
    this.orj = false;
    if ((com.tencent.mm.plugin.voip.b.i.QL(this.zgP.mState)) && ((this.zhC != paramBoolean) || (this.zhB == -1L)))
    {
      if ((!this.zhC) && (paramBoolean) && (!com.tencent.mm.plugin.voip.b.i.QM(this.zgP.mState)) && (this.mUIType != 2) && (this.zhB != -1L))
      {
        long l = bt.aS(this.zhB);
        ad.i("MicroMsg.Voip.VoipMgr", "accumulate near screen time: %s", new Object[] { Long.valueOf(l) });
        this.zhD += l;
      }
      this.zhB = bt.GC();
      this.zhC = paramBoolean;
    }
    if (this.zgR == null)
    {
      ad.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, voipUI is null, ignore");
      AppMethodBeat.o(114995);
      return;
    }
    if (((this.zgY) || (com.tencent.mm.plugin.voip.b.i.QL(this.zgP.mState))) && (!com.tencent.mm.plugin.voip.b.i.QM(this.zgP.mState)) && (this.mUIType != 2))
    {
      ad.i("MicroMsg.Voip.VoipMgr", "onSensorEvent, isOn: ".concat(String.valueOf(paramBoolean)));
      this.zgR.setScreenEnable(paramBoolean);
      this.zgT = paramBoolean;
      this.zhE = bt.GC();
    }
    AppMethodBeat.o(114995);
  }
  
  public final void ml(boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(115050);
    ad.i("MicroMsg.Voip.VoipMgr", "onBadNetStatus");
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
      ad.i("MicroMsg.Voip.VoipMgr", i);
      localObject = com.tencent.mm.plugin.report.service.h.vKh;
      l = com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.sAY;
      i = j;
      if (paramBoolean) {
        i = 1;
      }
      ((com.tencent.mm.plugin.report.service.h)localObject).a(17151, true, true, new Object[] { Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(115050);
      return;
    }
  }
  
  public final void ns(boolean paramBoolean)
  {
    AppMethodBeat.i(115002);
    this.zgO.rN(paramBoolean);
    AppMethodBeat.o(115002);
  }
  
  public final void onConnected()
  {
    AppMethodBeat.i(115032);
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
    AppMethodBeat.o(115032);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(115026);
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
    ad.i("MicroMsg.Voip.VoipMgr", "onError, errCode: %s, roomId: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.roomId) });
    paramString = aj.getContext();
    ad.d("MicroMsg.Voip.VoipMgr", "getErrorMsgContent, errorCode".concat(String.valueOf(paramInt)));
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
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(115064);
    if (this.zgR != null) {
      this.zgR.requestRender();
    }
    AppMethodBeat.o(115064);
  }
  
  public final void onReject()
  {
    AppMethodBeat.i(115028);
    ad.i("MicroMsg.Voip.VoipMgr", "onReject");
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
      AppMethodBeat.o(115028);
      return;
      str1 = bl.FzM;
      break;
    }
  }
  
  public final void rq(boolean paramBoolean)
  {
    AppMethodBeat.i(192033);
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
      ad.i("MicroMsg.Voip.VoipMgr", "steve:[simucall] resetStateMachine, initState:%d,isOutCall:%s,isVideoCall:%s", new Object[] { Integer.valueOf(i), Boolean.FALSE, Boolean.valueOf(paramBoolean) });
      this.zgY = false;
      AppMethodBeat.o(192033);
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
    AppMethodBeat.i(115001);
    ad.i("MicroMsg.Voip.VoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.zgO.ck(paramBoolean);
    this.zgO.zte = true;
    AppMethodBeat.o(115001);
  }
  
  public final void ru(boolean paramBoolean) {}
  
  public final boolean rv(final boolean paramBoolean)
  {
    AppMethodBeat.i(115057);
    if (com.tencent.mm.plugin.voip.c.dRQ().zmg)
    {
      ad.i("MicroMsg.Voip.VoipMgr", "current state is mini, cannot mini!");
      AppMethodBeat.o(115057);
      return false;
    }
    if ((this.zhu) && (!paramBoolean))
    {
      ad.i("MicroMsg.Voip.VoipMgr", "has phone call  cannot mini!");
      AppMethodBeat.o(115057);
      return false;
    }
    ad.l("MicroMsg.Voip.VoipMgr", "miniOnlyHidenVoip: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    ad.i("MicroMsg.Voip.VoipMgr", "onMinimizeVoip, async to minimize");
    if (this.zgR != null)
    {
      this.zgR.uninit();
      this.zgR = null;
      this.zgO.b(this.zgR);
    }
    if (this.zlh != null) {
      this.zlh.uninit();
    }
    if (this.iDu != null) {
      this.iDu.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(192016);
          VoipMgr.d(VoipMgr.this, paramBoolean);
          AppMethodBeat.o(192016);
        }
      });
    }
    AppMethodBeat.o(115057);
    return true;
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115038);
    this.zhz = paramInt;
    if (this.zgR != null) {
      this.zgR.setHWDecMode(paramInt);
    }
    if (this.zlm != null)
    {
      Object localObject;
      if (this.zln != null)
      {
        localObject = this.zln;
        if ((paramInt & 0x1) == 0) {
          break label96;
        }
      }
      label96:
      for (int i = 1;; i = 0)
      {
        ((com.tencent.mm.plugin.voip.b.a)localObject).Q(false, i);
        this.zln.dWp();
        localObject = this.zlm;
        if ((paramInt & 0x1) == 0) {
          break;
        }
        ((com.tencent.mm.plugin.voip.b.g)localObject).zto += 1L;
        AppMethodBeat.o(115038);
        return;
      }
      ((com.tencent.mm.plugin.voip.b.g)localObject).ztp += 1L;
    }
    AppMethodBeat.o(115038);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    this.zhd = paramInt;
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115037);
    ad.i("MicroMsg.Voip.VoipMgr", "setVoipBeauty, isON: " + paramInt + "，mVoipUI: " + this.zgR);
    if (this.zgR != null) {
      this.zgR.setVoipBeauty(paramInt);
    }
    if ((paramInt != 0) && (this.zhA != paramInt)) {
      com.tencent.mm.plugin.report.service.h.vKh.m(914L, 20L, 1L);
    }
    this.zhW = 2;
    this.zhA = paramInt;
    AppMethodBeat.o(115037);
  }
  
  public final void wy(int paramInt) {}
  
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
                AppMethodBeat.o(114993);
                return;
              } while (VoipMgr.j(VoipMgr.this) == 5);
              j = VoipMgr.aEb()[1];
              if (VoipMgr.k(VoipMgr.this) == 0) {
                VoipMgr.a(VoipMgr.this, 4);
              }
            } while (VoipMgr.k(VoipMgr.this) == 0);
            k = VoipMgr.cUu() / VoipMgr.k(VoipMgr.this);
            VoipMgr.a(VoipMgr.this, 5);
            m = VoipMgr.aEb()[0];
            ad.i("MicroMsg.Voip.VoipMgr", "befor change to 4G and cost " + VoipMgr.l(VoipMgr.this));
            if (VoipMgr.c(VoipMgr.this)) {}
            for (;;)
            {
              com.tencent.mm.plugin.voip.b.c.a(i, System.currentTimeMillis(), VoipMgr.j(VoipMgr.this), 5, j, m, k);
              VoipMgr.m(VoipMgr.this);
              VoipMgr.b(VoipMgr.this, 5);
              VoipMgr.cUw();
              VoipMgr.n(VoipMgr.this);
              AppMethodBeat.o(114993);
              return;
              i = 1;
            }
          } while (VoipMgr.j(VoipMgr.this) == 4);
          k = VoipMgr.aEb()[0];
          if (VoipMgr.k(VoipMgr.this) == 0) {
            VoipMgr.a(VoipMgr.this, 5);
          }
        } while (VoipMgr.k(VoipMgr.this) == 0);
        int m = VoipMgr.cUu() / VoipMgr.k(VoipMgr.this);
        VoipMgr.a(VoipMgr.this, 4);
        int n = VoipMgr.aEb()[1];
        ad.i("MicroMsg.Voip.VoipMgr", "befor change to wifi and cost " + VoipMgr.l(VoipMgr.this));
        if (VoipMgr.c(VoipMgr.this)) {}
        for (i = j;; i = 1)
        {
          com.tencent.mm.plugin.voip.b.c.a(i, System.currentTimeMillis(), VoipMgr.j(VoipMgr.this), 4, k, n, m);
          VoipMgr.m(VoipMgr.this);
          VoipMgr.b(VoipMgr.this, 4);
          VoipMgr.cUw();
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