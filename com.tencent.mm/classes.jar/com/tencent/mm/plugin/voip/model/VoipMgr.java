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
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.f.a.aap;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.abx;
import com.tencent.mm.f.a.abx.a;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.c.m;
import com.tencent.mm.plugin.voip.ui.VoipScoreDialog;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.b.e.a;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
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
  static int[] NLd = new int[2];
  static int pIN = 0;
  private TelephonyManager DOk;
  private IListener DOm;
  private long DQv;
  private boolean EZD;
  private long IMs;
  private MTimerHandler NKA;
  private boolean NKB;
  private boolean NKC;
  private int NKD;
  private boolean NKE;
  private boolean NKG;
  private boolean NKI;
  private boolean NKJ;
  private String NKK;
  public int NKN;
  public int NKO;
  public int NKP;
  private long NKQ;
  private long NKR;
  private int NKS;
  boolean NKT;
  boolean NKU;
  private int NKV;
  public int NKW;
  public int NKX;
  int NKY;
  boolean NKZ;
  private com.tencent.mm.plugin.voip.c.b NKh;
  private com.tencent.mm.plugin.voip.c.l NKi;
  volatile com.tencent.mm.plugin.voip.ui.b NKk;
  private boolean NKm;
  private boolean NKn;
  private boolean NKo;
  private Object NKp;
  private as NKq;
  boolean NKr;
  private boolean NKs;
  private boolean NKt;
  private int NKu;
  private boolean NKv;
  private int NKw;
  private long NKx;
  private int NKy;
  private com.tencent.mm.plugin.voip.video.f NKz;
  PhoneStateListener NLb;
  MMHandler NLc;
  private long NLe;
  private boolean NLf;
  private BroadcastReceiver NLh;
  int NLi;
  private IListener NLj;
  MMHandler NOA;
  boolean NOB;
  private com.tencent.mm.plugin.voip.video.camera.prev.a NOn;
  private a NOo;
  private boolean NOp;
  private com.tencent.mm.plugin.voip.widget.d NOq;
  private byte[] NOr;
  private ByteBuffer NOs;
  private int NOt;
  private boolean NOu;
  NetChangedBroadcastReceiver NOv;
  private int NOw;
  private int NOx;
  private com.tencent.mm.plugin.voip.c.i NOy;
  private com.tencent.mm.plugin.voip.c.a NOz;
  private String iSn;
  private int mUIType;
  private MMHandler ntw;
  PhoneStateListener prS;
  private CaptureView tRv;
  TelephonyManager tSE;
  
  public VoipMgr()
  {
    AppMethodBeat.i(114994);
    this.NOo = null;
    this.NKm = true;
    this.NKn = false;
    this.NKo = false;
    this.NKp = new Object();
    this.NKt = false;
    this.NKu = 4096;
    this.NKv = false;
    this.NKw = -1;
    this.NKx = -1L;
    this.EZD = false;
    this.NOp = false;
    this.NKy = 0;
    this.NKz = new com.tencent.mm.plugin.voip.video.f();
    this.NKA = null;
    this.NKB = false;
    this.NKC = false;
    this.NKD = 0;
    this.NKE = false;
    this.NKG = false;
    this.NKI = false;
    this.NKJ = false;
    this.NKK = null;
    this.NKN = -1;
    this.NKO = 0;
    this.NKP = 0;
    this.NKQ = 0L;
    this.NKR = 0L;
    this.NKS = 0;
    this.NKT = false;
    this.NKU = false;
    this.NKV = 0;
    this.NOr = null;
    this.NOs = null;
    this.NOt = 0;
    this.NOu = true;
    this.NKW = 0;
    this.NKX = 0;
    this.NKY = 0;
    this.NKZ = false;
    this.NLc = new MMHandler("getSignalStrength");
    this.tSE = null;
    this.IMs = 0L;
    this.NLe = 0L;
    this.NLf = false;
    this.NOw = 0;
    this.NOx = 0;
    this.NOA = new MMHandler("encodeVoipHandler");
    this.NLh = new BroadcastReceiver()
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
          if ((!com.tencent.mm.plugin.voip.c.k.alC(VoipMgr.c(VoipMgr.this).mState)) && (!VoipMgr.d(VoipMgr.this))) {
            VoipMgr.a(VoipMgr.this).gxW();
          }
        }
        AppMethodBeat.o(114963);
      }
    };
    this.DOm = new IListener() {};
    this.NLi = 0;
    this.NOB = false;
    this.DQv = 0L;
    this.prS = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        int i = 1;
        AppMethodBeat.i(237447);
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        Log.i("MicroMsg.Voip.VoipMgr", "onCallStateChanged :%d, isStartVoip: %b,oldState:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(VoipMgr.w(VoipMgr.this)), Integer.valueOf(VoipMgr.x(VoipMgr.this)) });
        if (!VoipMgr.w(VoipMgr.this))
        {
          AppMethodBeat.o(237447);
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
          com.tencent.mm.plugin.voip.c.gxs().akS(1);
          VoipMgr.d(VoipMgr.this, true);
        }
        label325:
        label359:
        do
        {
          VoipMgr.a(VoipMgr.this).NLf = VoipMgr.F(VoipMgr.this);
          AppMethodBeat.o(237447);
          return;
          if (paramAnonymousInt == 2)
          {
            VoipMgr.c(VoipMgr.this, false);
            if (VoipMgr.x(VoipMgr.this) == 1) {
              VoipMgr.d(VoipMgr.this, System.currentTimeMillis());
            }
            VoipMgr.c(VoipMgr.this, 2);
            Log.i("MicroMsg.Voip.VoipMgr", "phone call coming now!");
            if ((VoipMgr.d(VoipMgr.this)) && (!com.tencent.mm.plugin.voip.c.k.alC(VoipMgr.c(VoipMgr.this).mState))) {
              com.tencent.mm.plugin.voip.c.gxs().gAi();
            }
            String str2;
            String str1;
            if (com.tencent.mm.plugin.voip.c.k.alC(VoipMgr.c(VoipMgr.this).mState))
            {
              paramAnonymousString = MMApplicationContext.getContext().getString(b.g.voip_call_msg_chat_time, new Object[] { VoipMgr.SD(Util.secondsToNow(VoipMgr.z(VoipMgr.this))) });
              com.tencent.mm.plugin.voip.c.gxs().gAl();
              str2 = VoipMgr.A(VoipMgr.this).field_username;
              if (!VoipMgr.g(VoipMgr.this)) {
                break label596;
              }
              str1 = ca.VGy;
              if (!VoipMgr.d(VoipMgr.this)) {
                break label604;
              }
            }
            for (paramAnonymousInt = i;; paramAnonymousInt = 0)
            {
              s.b(str2, str1, paramAnonymousInt, 6, paramAnonymousString);
              VoipMgr.d(VoipMgr.this, 4107);
              VoipMgr.B(VoipMgr.this);
              paramAnonymousString = new ca();
              paramAnonymousString.setType(10000);
              paramAnonymousString.setCreateTime(System.currentTimeMillis());
              paramAnonymousString.setStatus(6);
              paramAnonymousString.setContent(MMApplicationContext.getContext().getString(b.g.voip_call_interrupted_by_other_app) + ", <a href=\"weixin://voip/callagain/?username=" + VoipMgr.f(VoipMgr.this) + "&isvideocall=" + VoipMgr.g(VoipMgr.this) + "\">" + MMApplicationContext.getContext().getString(b.g.voip_call_again) + "</a>");
              if ((VoipMgr.f(VoipMgr.this) != null) && (!VoipMgr.f(VoipMgr.this).equals("")))
              {
                paramAnonymousString.Jm(VoipMgr.f(VoipMgr.this));
                ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aM(paramAnonymousString);
              }
              com.tencent.mm.plugin.voip.c.gxs().akS(2);
              VoipMgr.d(VoipMgr.this, false);
              break;
              paramAnonymousString = MMApplicationContext.getContext().getString(b.g.voip_call_connection_failed);
              break label325;
              str1 = ca.VGx;
              break label359;
            }
          }
        } while (paramAnonymousInt != 0);
        label596:
        label604:
        if ((VoipMgr.x(VoipMgr.this) == 1) || (VoipMgr.x(VoipMgr.this) == 2)) {
          VoipMgr.d(VoipMgr.this, System.currentTimeMillis());
        }
        VoipMgr.c(VoipMgr.this, 0);
        com.tencent.mm.plugin.voip.c.gxs().akS(2);
        if ((1 == VoipMgr.C(VoipMgr.this)) && (com.tencent.mm.plugin.voip.c.k.alC(VoipMgr.c(VoipMgr.this).mState)) && (VoipMgr.D(VoipMgr.this))) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(233623);
              VoipMgr.a(VoipMgr.this).ds(true);
              AppMethodBeat.o(233623);
            }
          });
        }
        if ((4 == VoipMgr.C(VoipMgr.this)) && (VoipMgr.D(VoipMgr.this))) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(243324);
              VoipMgr.a(VoipMgr.this).aY(VoipMgr.E(VoipMgr.this), VoipMgr.g(VoipMgr.this));
              AppMethodBeat.o(243324);
            }
          });
        }
        VoipMgr.c(VoipMgr.this, false);
        if (com.tencent.mm.plugin.audio.c.a.crn().crm())
        {
          Log.i("MicroMsg.Voip.VoipMgr", "is bluetooth can use and start bluetooth");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(244806);
              VoipMgr.a(VoipMgr.this).aY(VoipMgr.E(VoipMgr.this), VoipMgr.g(VoipMgr.this));
              AppMethodBeat.o(244806);
            }
          });
        }
        for (;;)
        {
          VoipMgr.d(VoipMgr.this, false);
          break;
          if (com.tencent.mm.plugin.audio.c.a.crn().crh()) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(242151);
                VoipMgr.a(VoipMgr.this).aY(VoipMgr.E(VoipMgr.this), VoipMgr.g(VoipMgr.this));
                AppMethodBeat.o(242151);
              }
            });
          }
        }
      }
    };
    this.NLj = new IListener() {};
    this.NKh = new com.tencent.mm.plugin.voip.c.b();
    this.NOz = new com.tencent.mm.plugin.voip.c.a();
    AppMethodBeat.o(114994);
  }
  
  private void AU(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(115015);
    if (this.NKs)
    {
      Log.i("MicroMsg.Voip.VoipMgr", "setCameraCaptureBind,  isFace: %s", new Object[] { Boolean.valueOf(paramBoolean) });
      Log.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
      if (this.NOn == null) {
        this.NOn = new com.tencent.mm.plugin.voip.video.camera.prev.a(640, 480);
      }
      if (this.NOn.a(this, paramBoolean) != 1) {
        break label159;
      }
    }
    label159:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.NOu = paramBoolean;
      if ((this.NOu) && (this.tRv != null))
      {
        this.NOn.a(this.tRv);
        com.tencent.mm.plugin.voip.c.gxs().akX(this.NOn.gDA());
        if (this.ntw != null) {
          this.ntw.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(239615);
              Log.d("MicroMsg.Voip.VoipMgr", "mCaptureRender == " + VoipMgr.e(VoipMgr.this));
              if (VoipMgr.e(VoipMgr.this) != null)
              {
                VoipMgr.e(VoipMgr.this).gDB();
                VoipMgr.q(VoipMgr.this);
              }
              AppMethodBeat.o(239615);
            }
          }, 50L);
        }
      }
      AppMethodBeat.o(115015);
      return;
    }
  }
  
  private void Bl(final int paramInt)
  {
    AppMethodBeat.i(115023);
    Log.printDebugStack("MicroMsg.Voip.VoipMgr", "swtchState, action: %s, currentState: %s", new Object[] { com.tencent.mm.plugin.voip.c.k.alz(paramInt), com.tencent.mm.plugin.voip.c.k.alz(this.NKi.mState) });
    if ((4101 == paramInt) && (com.tencent.mm.plugin.voip.c.k.alD(this.NKi.mState)))
    {
      gzz();
      this.NKs = false;
      if (this.NOq != null) {
        this.NOq.NKs = false;
      }
    }
    if (aky(paramInt)) {
      this.NKh.NXl = false;
    }
    if ((aky(paramInt)) && (1 == this.mUIType) && (1 == this.NKw))
    {
      this.NKh.ds(false);
      gyo();
      if (!com.tencent.mm.plugin.voip.c.gxs().NPf.cNL())
      {
        this.NKh.gxW();
        this.NKh.aZ(false, this.NKr);
      }
    }
    this.NKi.alH(paramInt);
    if (this.ntw != null) {
      this.ntw.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114991);
          if (VoipMgr.h(VoipMgr.this) != null) {
            VoipMgr.h(VoipMgr.this).kR(paramInt, VoipMgr.c(VoipMgr.this).mState);
          }
          AppMethodBeat.o(114991);
        }
      });
    }
    switch (this.NKi.mState)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(115023);
      return;
      akz(5);
      AppMethodBeat.o(115023);
      return;
      akz(6);
    }
  }
  
  private static String GN(long paramLong)
  {
    AppMethodBeat.i(115045);
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
    AppMethodBeat.o(115045);
    return str;
  }
  
  private void R(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115047);
    if (this.NOw % 100 == 0) {
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
          Log.i("MicroMsg.Voip.VoipMgr", "onFrameDataReady, sample sendData:[%s, %s, %s, %s, %s], captureFrameCount:%s", new Object[] { Byte.valueOf(arrayOfByte[0]), Byte.valueOf(arrayOfByte[1]), Byte.valueOf(arrayOfByte[2]), Byte.valueOf(arrayOfByte[3]), Byte.valueOf(arrayOfByte[4]), Integer.valueOf(this.NOw) });
          paramInt2 = 0;
          paramInt1 = 0;
          break label288;
          if (paramInt1 >= 5)
          {
            paramArrayOfByte = t.NPb;
            t.gAc();
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
  
  private void akx(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(115019);
    Log.i("MicroMsg.Voip.VoipMgr", "hangupTalkingOrCancelInvite");
    if (true == gyi()) {
      this.NKu = paramInt;
    }
    Object localObject = MMApplicationContext.getContext();
    String str2;
    if (com.tencent.mm.plugin.voip.c.k.alC(this.NKi.mState))
    {
      localObject = ((Context)localObject).getString(b.g.voip_call_msg_chat_time, new Object[] { GN(Util.secondsToNow(this.NKx)) });
      str2 = this.NKq.field_username;
      if (!this.NKs) {
        break label245;
      }
    }
    label245:
    for (String str1 = ca.VGy;; str1 = ca.VGx)
    {
      if (this.NKr) {
        i = 1;
      }
      s.b(str2, str1, i, 6, (String)localObject);
      if ((!this.NKr) || (com.tencent.mm.plugin.voip.c.k.alC(this.NKi.mState))) {
        break label253;
      }
      gxW();
      if ((this.NKr) && (!com.tencent.mm.plugin.voip.c.k.alC(this.NKi.mState)))
      {
        Log.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call cancelCall");
        com.tencent.mm.plugin.voip.c.gxs().gAh();
      }
      Log.i("MicroMsg.Voip.VoipMgr", "hangupVoipButton OnClick call hangUp");
      com.tencent.mm.plugin.voip.c.gxs().gAk();
      if (4096 != this.NKu) {
        break label306;
      }
      Bl(paramInt);
      gyb();
      AppMethodBeat.o(115019);
      return;
      if (this.NKr)
      {
        localObject = ((Context)localObject).getString(b.g.voip_call_cancel_msg_to);
        break;
      }
      localObject = ((Context)localObject).getString(b.g.voip_call_cancel_msg_from);
      break;
    }
    label253:
    com.tencent.e.h.ZvG.be(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "VoipMgr_play_end_sound";
      }
      
      public final void run()
      {
        AppMethodBeat.i(233512);
        VoipMgr.a(VoipMgr.this).Bi(VoipMgr.g(VoipMgr.this));
        AppMethodBeat.o(233512);
      }
    });
    this.NKn = true;
    this.NKo = true;
    com.tencent.mm.plugin.voip.c.gxs().gAk();
    if (4096 == this.NKu)
    {
      Bl(paramInt);
      gyb();
    }
    label306:
    AppMethodBeat.o(115019);
  }
  
  private boolean aky(int paramInt)
  {
    AppMethodBeat.i(115024);
    if (4111 == paramInt)
    {
      AppMethodBeat.o(115024);
      return true;
    }
    if ((4101 == paramInt) && ((com.tencent.mm.plugin.voip.c.k.alC(this.NKi.mState)) || (this.NKr)))
    {
      AppMethodBeat.o(115024);
      return true;
    }
    AppMethodBeat.o(115024);
    return false;
  }
  
  private static void akz(int paramInt)
  {
    AppMethodBeat.i(115025);
    abx localabx = new abx();
    localabx.gbT.fvK = paramInt;
    EventCenter.instance.publish(localabx);
    AppMethodBeat.o(115025);
  }
  
  private boolean c(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(115053);
    String str = com.tencent.mm.n.h.axc().getValue("VOIPShortcutAutoadd");
    Log.i("MicroMsg.Voip.VoipMgr", "voip shortcut autoAdd is %s", new Object[] { str });
    if ((str != null) && (str.equals("0")) && (Util.secondsToNow(this.NKx) > 30L))
    {
      int i = paramSharedPreferences.getInt("voip_shortcut_prompt_times", 0);
      boolean bool = paramSharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
      if ((i < 3) && (!bool))
      {
        gyj();
        paramSharedPreferences.edit().putInt("voip_shortcut_prompt_times", i + 1).commit();
        AppMethodBeat.o(115053);
        return true;
      }
    }
    else if ((str != null) && (str.equals("1")) && (Util.secondsToNow(this.NKx) > 15L))
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
    if (1 == Util.getInt(com.tencent.mm.n.h.axc().getValue("VOIPCallType"), 0))
    {
      localIntent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(b.g.app_field_voip));
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getContext(), b.c.voip_camerachat));
      localIntent1.putExtra("shortcut_icon_resource_id", b.c.voip_camerachat);
    }
    for (;;)
    {
      localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
      com.tencent.mm.plugin.base.model.b.o(getContext(), localIntent1);
      paramSharedPreferences.edit().putBoolean("voip_shortcut_has_added", true).commit();
      AppMethodBeat.o(115054);
      return;
      localIntent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(b.g.app_field_voipaudio));
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getContext(), b.c.voip_voicechat));
      localIntent1.putExtra("shortcut_icon_resource_id", b.c.voip_voicechat);
    }
  }
  
  private Context getContext()
  {
    AppMethodBeat.i(115055);
    Context localContext1 = null;
    if (this.NKk != null) {
      localContext1 = this.NKk.gBI();
    }
    Context localContext2 = localContext1;
    if (localContext1 == null) {
      localContext2 = MMApplicationContext.getContext();
    }
    AppMethodBeat.o(115055);
    return localContext2;
  }
  
  private boolean gxY()
  {
    int j = 0;
    AppMethodBeat.i(115021);
    if (!this.NKi.alG(4101))
    {
      AppMethodBeat.o(115021);
      return false;
    }
    this.NKs = false;
    if (this.NOq != null) {
      this.NOq.NKs = false;
    }
    Bl(4101);
    Object localObject1;
    int k;
    int i;
    Object localObject3;
    Object localObject2;
    if ((261 == this.NKi.mState) || (7 == this.NKi.mState))
    {
      com.tencent.mm.plugin.voip.c.gxs().akP(1);
      localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
      long l = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ;
      k = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId;
      if (this.NKr)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject1).a(11046, new Object[] { Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(k), Integer.valueOf(0), Integer.valueOf(i) });
        localObject3 = com.tencent.mm.plugin.report.service.h.IzE;
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
        com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.gyN();
        com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.gyO();
        AppMethodBeat.o(115021);
        return true;
        i = 0;
        break;
      } while ((1 != this.NKi.mState) && (3 != this.NKi.mState));
      com.tencent.mm.plugin.voip.c.gxs().akP(1);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
      k = 11046;
      localObject1 = new Object[5];
      localObject1[0] = Integer.valueOf(1);
      localObject1[1] = Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ);
      localObject1[2] = Integer.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId);
      localObject1[3] = Integer.valueOf(0);
      i = 4;
      if (this.NKr)
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
  
  private void gyb()
  {
    AppMethodBeat.i(115029);
    Log.d("MicroMsg.Voip.VoipMgr", "delayFinish");
    this.NKK = null;
    if (this.ntw != null) {
      this.ntw.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(114964);
          VoipMgr localVoipMgr = VoipMgr.this;
          Log.i("MicroMsg.Voip.VoipMgr", "it is uninit voip report");
          if (localVoipMgr.NLc != null)
          {
            localVoipMgr.NLc.quit();
            localVoipMgr.NLc = null;
          }
          if (!localVoipMgr.NKZ)
          {
            if (localVoipMgr.NLi == 0) {
              localVoipMgr.akw(localVoipMgr.NKY);
            }
            if (localVoipMgr.NLi != 0)
            {
              localVoipMgr.NKZ = true;
              if (!localVoipMgr.NKr) {
                break label259;
              }
            }
          }
          label259:
          for (int i = 0;; i = 1)
          {
            com.tencent.mm.plugin.voip.c.e.a(i, System.currentTimeMillis(), localVoipMgr.NKY, localVoipMgr.NKY, 0, 0, VoipMgr.pIN / localVoipMgr.NLi);
            VoipMgr.pIN = 0;
            VoipMgr.NLd[0] = 0;
            VoipMgr.NLd[1] = 0;
            localVoipMgr.NLi = 0;
            if (localVoipMgr.tSE != null)
            {
              TelephonyManager localTelephonyManager = localVoipMgr.tSE;
              Object localObject = localVoipMgr.NLb;
              localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject);
              com.tencent.mm.hellhoundlib.a.a.b(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/voip/model/VoipMgr", "uninitVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
              localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(1)).intValue());
              com.tencent.mm.hellhoundlib.a.a.c(localTelephonyManager, "com/tencent/mm/plugin/voip/model/VoipMgr", "uninitVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
            }
            if (localVoipMgr.NOv != null)
            {
              MMApplicationContext.getContext().unregisterReceiver(localVoipMgr.NOv);
              localVoipMgr.NOv = null;
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
  
  private static void gyc()
  {
    AppMethodBeat.i(241005);
    aaq localaaq = new aaq();
    localaaq.fZM.fDn = 11;
    EventCenter.instance.publish(localaaq);
    AppMethodBeat.o(241005);
  }
  
  private void gyh()
  {
    long l2 = 0L;
    AppMethodBeat.i(115048);
    synchronized (this.NKp)
    {
      com.tencent.mm.plugin.voip.b.a locala = com.tencent.mm.plugin.voip.b.a.NTi;
      if (this.NKx == 0L)
      {
        l1 = 0L;
        if (this.NKs) {
          l2 = 1L;
        }
        com.tencent.mm.plugin.voip.b.a.aY(l1, l2);
        gzz();
        this.NKh.unInit();
        this.NKh.gyh();
        AppMethodBeat.o(115048);
        return;
      }
      long l1 = Util.secondsToNow(this.NKx);
    }
  }
  
  private boolean gyi()
  {
    AppMethodBeat.i(115052);
    if (com.tencent.mm.plugin.voip.c.k.alC(this.NKi.mState))
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
  
  private void gyj()
  {
    AppMethodBeat.i(115056);
    Context localContext = getContext();
    View localView = View.inflate(localContext, b.e.mm_alert_checkbox, null);
    final CheckBox localCheckBox = (CheckBox)localView.findViewById(b.d.mm_alert_dialog_cb);
    localCheckBox.setChecked(false);
    TextView localTextView = (TextView)localView.findViewById(b.d.mm_alert_dialog_info);
    if (1 == Util.getInt(com.tencent.mm.n.h.axc().getValue("VOIPCallType"), 0)) {
      localTextView.setText(b.g.voip_add_short_cut_tip);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.h.a(localContext, false, localContext.getString(b.g.app_tip), localView, localContext.getString(b.g.app_yes), localContext.getString(b.g.app_no), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(238631);
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
          AppMethodBeat.o(238631);
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
      localTextView.setText(b.g.voip_add_short_cut_tip_audio);
    }
  }
  
  private void gyn()
  {
    AppMethodBeat.i(115062);
    if (this.NKz != null) {
      this.NKz.b(this);
    }
    if (this.NKA != null)
    {
      Log.d("MicroMsg.Voip.VoipMgr", "stop face detect timer");
      this.NKA.stopTimer();
    }
    AppMethodBeat.o(115062);
  }
  
  private void gyo()
  {
    AppMethodBeat.i(241055);
    this.NKJ = true;
    if ((this.NKJ) && (this.NKw == 2))
    {
      getContext();
      gyp();
    }
    AppMethodBeat.o(241055);
  }
  
  private void gyp()
  {
    AppMethodBeat.i(240974);
    this.NKh.ab(new kotlin.g.a.b() {});
    AppMethodBeat.o(240974);
  }
  
  private void gzA()
  {
    AppMethodBeat.i(241060);
    Log.i("MicroMsg.Voip.VoipMgr", "uninitSurfaceTexture!");
    if (this.NKk != null) {
      this.NKk.releaseSurfaceTexture();
    }
    AppMethodBeat.o(241060);
  }
  
  private void gzy()
  {
    AppMethodBeat.i(115043);
    if ((com.tencent.mm.compatible.util.d.qV(28)) && (this.NKs) && (this.NOn != null) && (!this.NOn.egx()) && (this.NKk != null))
    {
      Log.i("MicroMsg.Voip.VoipMgr", "video call accept, not previewing, api level: %s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      this.NOn.eXS();
      this.NKk.gBG();
      int k = 320;
      int m = 240;
      int j = m;
      int i = k;
      if (this.NOn == null)
      {
        j = m;
        i = k;
        if (com.tencent.mm.plugin.voip.c.k.alD(this.NKi.mState))
        {
          this.tRv = new CaptureView(MMApplicationContext.getContext());
          Log.i("MicroMsg.Voip.VoipMgr", "steve: 640 capture!");
          i = 640;
          j = 480;
        }
      }
      this.NOn = new com.tencent.mm.plugin.voip.video.camera.prev.a(i, j);
      this.NOn.a(this, true);
      this.NOn.a(this.tRv);
      this.NOn.gDB();
      this.NOw = 0;
    }
    AppMethodBeat.o(115043);
  }
  
  private void gzz()
  {
    AppMethodBeat.i(115049);
    Log.printDebugStack("MicroMsg.Voip.VoipMgr", "uninitCaptureRender", new Object[0]);
    if (this.NOn != null) {
      gyn();
    }
    try
    {
      this.NOn.eXS();
      this.NOn = null;
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
  
  private void hS(boolean paramBoolean)
  {
    AppMethodBeat.i(115030);
    Log.i("MicroMsg.Voip.VoipMgr", "finish");
    this.NKG = false;
    this.NKI = false;
    if (this.NOy != null) {
      this.NOy.gCP();
    }
    if (this.NOz != null)
    {
      this.NOz.gEI();
      this.NOz.gCh();
    }
    if (this.NOA != null)
    {
      this.NOA.removeCallbacksAndMessages(null);
      this.NOA = null;
    }
    if (this.NKy != -1)
    {
      com.tencent.mm.plugin.report.service.h.IzE.a(11700, new Object[] { Integer.valueOf(this.NKy), Long.valueOf(Util.secondsToNow(this.NKx)) });
      this.NKy = -1;
    }
    try
    {
      MMApplicationContext.getContext().unregisterReceiver(this.NLh);
      label139:
      this.NKh.gCl();
      EventCenter.instance.removeListener(this.DOm);
      EventCenter.instance.removeListener(this.NLj);
      gzA();
      if (this.NKk != null)
      {
        this.NKk.uninit();
        this.NKk = null;
        this.NKh.b(this.NKk);
      }
      this.tRv = null;
      label245:
      int j;
      label310:
      long l;
      if (com.tencent.mm.plugin.voip.c.gxs() != null)
      {
        if (paramBoolean)
        {
          com.tencent.mm.plugin.voip.c.gxs().gAm();
          if (!this.NKs) {
            break label793;
          }
          com.tencent.mm.plugin.voip.c.gxs().c(false, true, this.iSn);
          com.tencent.mm.plugin.voip.c.gxs().b(MMApplicationContext.getContext(), this);
        }
      }
      else
      {
        this.NKh.eVm();
        com.tencent.mm.plugin.voip.c.gxs().gAB();
        com.tencent.mm.plugin.voip.c.gxs().akZ(this.NKO);
        if (!this.NKn) {
          break label808;
        }
        this.NOo = new a();
        com.tencent.e.h.ZvG.be(this.NOo);
        Object localObject1;
        Object localObject2;
        if ((this.DOk != null) && (this.prS != null))
        {
          localObject1 = this.DOk;
          localObject2 = this.prS;
          localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/voip/model/VoipMgr", "finish", "(Z)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
          ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(1)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/voip/model/VoipMgr", "finish", "(Z)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
          this.prS = null;
        }
        this.DOk = null;
        com.tencent.mm.booter.a.aql().aqm();
        r.gzC().gzE();
        r.gzC().a(null);
        ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        com.tencent.mm.plugin.voip.c.gxs().gAE();
        Log.i("MicroMsg.Voip.VoipMgr", "finish, isFinishFromShutdown: %s", new Object[] { Boolean.valueOf(this.NKo) });
        if ((this.NKo) && (com.tencent.mm.plugin.voip.c.gxs().gAF()))
        {
          com.tencent.mm.plugin.voip.c.gxs();
          VoipScoreState.gAe();
          localObject2 = new Intent(getContext(), VoipScoreDialog.class);
          ((Intent)localObject2).putExtra("key_score_state", com.tencent.mm.plugin.voip.c.gxs().gAH());
          if (!(getContext() instanceof Activity)) {
            ((Intent)localObject2).addFlags(268435456);
          }
          localObject1 = getContext();
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/voip/model/VoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/voip/model/VoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        com.tencent.mm.plugin.voip.c.gxs().gAG();
        gyc();
        if (!this.NKU)
        {
          j = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId;
          l = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ;
          if (!this.NKr) {
            break label815;
          }
        }
      }
      label793:
      label808:
      label815:
      for (int i = 0;; i = 1)
      {
        com.tencent.mm.plugin.voip.c.e.c(j, l, i, 4);
        this.NKU = true;
        this.NOr = null;
        this.NOt = 0;
        ((com.tencent.mm.plugin.notification.b.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(40);
        com.tencent.mm.media.g.c.kVi.aUQ();
        AppMethodBeat.o(115030);
        return;
        com.tencent.mm.plugin.voip.c.gxs().gAk();
        break;
        com.tencent.mm.plugin.voip.c.gxs().c(false, false, this.iSn);
        break label245;
        gyh();
        break label310;
      }
    }
    catch (Exception localException)
    {
      break label139;
    }
  }
  
  public final void AI(boolean paramBoolean)
  {
    AppMethodBeat.i(240971);
    if ((this.NKi != null) && (this.NKi.mState >= 0) && (this.NKi.mState <= 8)) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.i("MicroMsg.Voip.VoipMgr", "steve:[simucall] same state, no need to reset, return!");
      AppMethodBeat.o(240971);
      return;
    }
    int j = com.tencent.mm.plugin.voip.c.k.bc(false, paramBoolean);
    i = j;
    if (this.NKt)
    {
      if (j != 0) {
        break label136;
      }
      i = 1;
    }
    for (;;)
    {
      this.NKi = com.tencent.mm.plugin.voip.c.k.alA(i);
      Log.i("MicroMsg.Voip.VoipMgr", "steve:[simucall] resetStateMachine, initState:%d,isOutCall:%s,isVideoCall:%s", new Object[] { Integer.valueOf(i), Boolean.FALSE, Boolean.valueOf(paramBoolean) });
      this.NKr = false;
      AppMethodBeat.o(240971);
      return;
      label136:
      i = j;
      if (256 == j) {
        i = 257;
      }
    }
  }
  
  public final void AM(boolean paramBoolean)
  {
    AppMethodBeat.i(115001);
    Log.i("MicroMsg.Voip.VoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.NKh.ds(paramBoolean);
    this.NKh.NXs = true;
    AppMethodBeat.o(115001);
  }
  
  public final void AN(boolean paramBoolean) {}
  
  public final void AO(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(241009);
    Log.i("MicroMsg.Voip.VoipMgr", "onShutDown");
    String str1;
    String str2;
    label99:
    label108:
    int k;
    label160:
    long l;
    if (com.tencent.mm.plugin.voip.c.k.alC(this.NKi.mState))
    {
      str1 = MMApplicationContext.getContext().getString(b.g.voip_call_msg_chat_time, new Object[] { GN(Util.secondsToNow(this.NKx)) });
      if ((this.NKr) || (com.tencent.mm.plugin.voip.c.k.alC(this.NKi.mState)))
      {
        String str3 = this.NKq.field_username;
        if (!this.NKs) {
          break label251;
        }
        str2 = ca.VGy;
        if (!this.NKr) {
          break label259;
        }
        i = 1;
        s.b(str3, str2, i, 6, str1);
      }
      this.NKh.Bi(this.NKs);
      this.NKo = com.tencent.mm.plugin.voip.c.k.alC(this.NKi.mState);
      if (!gyi()) {
        break label264;
      }
      this.NKu = 4106;
      com.tencent.mm.plugin.voip.c.gxs().gAE();
      if (!this.NKU)
      {
        k = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId;
        l = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ;
        if (!this.NKr) {
          break label278;
        }
      }
    }
    label259:
    label264:
    label278:
    for (int i = j;; i = 1)
    {
      com.tencent.mm.plugin.voip.c.e.c(k, l, i, 4);
      this.NKU = true;
      AppMethodBeat.o(241009);
      return;
      str1 = MMApplicationContext.getContext().getString(b.g.voip_call_connection_failed);
      break;
      label251:
      str2 = ca.VGx;
      break label99;
      i = 0;
      break label108;
      Bl(4106);
      gyb();
      break label160;
    }
  }
  
  public final boolean AP(final boolean paramBoolean)
  {
    AppMethodBeat.i(115057);
    if (com.tencent.mm.plugin.voip.c.gxs().NPv)
    {
      Log.i("MicroMsg.Voip.VoipMgr", "current state is mini, cannot mini!");
      AppMethodBeat.o(115057);
      return false;
    }
    if ((this.NKI) && (!paramBoolean))
    {
      Log.i("MicroMsg.Voip.VoipMgr", "has phone call  cannot mini!");
      AppMethodBeat.o(115057);
      return false;
    }
    Log.printDebugStack("MicroMsg.Voip.VoipMgr", "miniOnlyHidenVoip: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Log.i("MicroMsg.Voip.VoipMgr", "onMinimizeVoip, async to minimize");
    if (this.NKk != null)
    {
      this.NKk.uninit();
      this.NKk = null;
      this.NKh.b(this.NKk);
    }
    if (this.NOq != null) {
      this.NOq.uninit();
    }
    if (this.ntw != null) {
      this.ntw.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(236244);
          VoipMgr.e(VoipMgr.this, paramBoolean);
          AppMethodBeat.o(236244);
        }
      });
    }
    AppMethodBeat.o(115057);
    return true;
  }
  
  public final void IA(int paramInt)
  {
    int i = 4;
    AppMethodBeat.i(241042);
    if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wbI, true))
    {
      AppMethodBeat.o(241042);
      return;
    }
    if (this.NOn != null) {}
    for (boolean bool = this.NOn.gDP();; bool = true)
    {
      switch (paramInt)
      {
      case 3: 
      default: 
      case 2: 
        for (;;)
        {
          com.tencent.mm.plugin.voip.c.gxs().akQ(paramInt);
          AppMethodBeat.o(241042);
          return;
          if (bool) {
            paramInt = 2;
          } else {
            paramInt = 4;
          }
        }
      }
      if (bool) {}
      for (paramInt = i;; paramInt = 2) {
        break;
      }
    }
  }
  
  public final void XB(int paramInt)
  {
    AppMethodBeat.i(240988);
    if (this.NKk != null) {
      this.NKk.XB(paramInt);
    }
    AppMethodBeat.o(240988);
  }
  
  public final void a(final Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(240964);
    Log.i("MicroMsg.Voip.VoipMgr", "start VoIP, userName: %s, isOutCall: %b, isVideoCall: %b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    this.NKh.aX(paramBoolean2, paramBoolean1);
    this.NKh.gCj();
    this.NKG = true;
    this.iSn = paramString;
    this.NKr = paramBoolean1;
    this.NKs = paramBoolean2;
    this.NKq = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(this.iSn);
    this.ntw = new MMHandler(Looper.getMainLooper());
    this.NKN = 0;
    this.NKO = 0;
    this.NKP = 0;
    boolean bool1;
    int j;
    label196:
    label216:
    boolean bool2;
    if (Util.getInt(com.tencent.mm.n.h.axc().getValue("VOIPCameraSwitch"), 1) == 0)
    {
      bool1 = true;
      this.NKt = bool1;
      if (!this.NKs) {
        this.NKt = false;
      }
      j = com.tencent.mm.plugin.voip.c.k.bc(paramBoolean1, paramBoolean2);
      i = j;
      if (this.NKt)
      {
        if (j != 0) {
          break label569;
        }
        i = 1;
        com.tencent.mm.plugin.voip.c.gxs().akP(1);
      }
      if (!paramBoolean1) {
        break label589;
      }
      this.NKi = com.tencent.mm.plugin.voip.c.k.alB(i);
      this.NKh.NKi = this.NKi;
      bool1 = com.tencent.mm.compatible.e.b.avu();
      bool2 = com.tencent.mm.compatible.e.b.avv();
      if (Build.MANUFACTURER.equalsIgnoreCase("meizu"))
      {
        if (!bool1)
        {
          localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
          if (!this.NKs) {
            break label601;
          }
          i = 0;
          label269:
          ((com.tencent.mm.plugin.report.service.h)localObject1).a(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
        }
        if (!bool2)
        {
          localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
          if (!this.NKs) {
            break label607;
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
          break label613;
        }
        localObject1 = paramContext.getString(b.g.voip_special_no_audio_camera_permission);
        localObject2 = paramContext.getString(b.g.voip_need_audio_and_camera_title);
        label387:
        com.tencent.mm.ui.base.h.a(paramContext, (String)localObject1, (String)localObject2, paramContext.getString(b.g.voip_need_show_settings_button), true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(235375);
            Log.i("MicroMsg.Voip.VoipMgr", "show Permission settings");
            com.tencent.mm.compatible.e.b.cs(paramContext);
            if (!VoipMgr.d(VoipMgr.this))
            {
              if (VoipMgr.g(VoipMgr.this))
              {
                VoipMgr.this.gxI();
                AppMethodBeat.o(235375);
                return;
              }
              VoipMgr.this.gxK();
              AppMethodBeat.o(235375);
              return;
            }
            if (VoipMgr.g(VoipMgr.this))
            {
              VoipMgr.this.gxM();
              AppMethodBeat.o(235375);
              return;
            }
            VoipMgr.this.gxN();
            AppMethodBeat.o(235375);
          }
        });
      }
      Log.i("MicroMsg.Voip.VoipMgr", "initMgr");
      com.tencent.mm.booter.a.aql().aqn();
      if (!this.NKs) {
        break label665;
      }
      com.tencent.mm.plugin.voip.c.gxs().c(true, true, this.iSn);
      label447:
      if (!this.NKr) {
        break label698;
      }
      com.tencent.mm.plugin.voip.c.gxs().NPf.gAN();
      if (!this.NKs) {
        break label680;
      }
    }
    label665:
    label680:
    for (int i = com.tencent.mm.plugin.voip.c.gxs().bgg(this.NKq.field_username);; i = com.tencent.mm.plugin.voip.c.gxs().bgf(this.NKq.field_username))
    {
      if (i >= 0) {
        break label698;
      }
      hS(false);
      i = 0;
      if (i != 0)
      {
        this.NKh.aZ(paramBoolean2, paramBoolean1);
        if (paramBoolean2) {
          this.NOy = new com.tencent.mm.plugin.voip.c.i();
        }
        this.NOz.gEI();
        this.NOz.cLZ();
        com.tencent.mm.plugin.voip.c.gxs().e(paramString, this.NKs, paramLong);
      }
      AppMethodBeat.o(240964);
      return;
      bool1 = false;
      break;
      label569:
      i = j;
      if (256 != j) {
        break label196;
      }
      i = 257;
      break label196;
      label589:
      this.NKi = com.tencent.mm.plugin.voip.c.k.alA(i);
      break label216;
      label601:
      i = 1;
      break label269;
      label607:
      i = 1;
      break label316;
      label613:
      if (!bool1)
      {
        localObject1 = paramContext.getString(b.g.voip_special_no_record_audio_permission);
        localObject2 = paramContext.getString(b.g.voip_need_audio_title);
        break label387;
      }
      if (bool2) {
        break label387;
      }
      localObject1 = paramContext.getString(b.g.voip_special_no_open_camera_permission);
      localObject2 = paramContext.getString(b.g.voip_need_camera_title);
      break label387;
      com.tencent.mm.plugin.voip.c.gxs().c(true, false, this.iSn);
      break label447;
    }
    label698:
    com.tencent.mm.plugin.voip.c.gxs().a(MMApplicationContext.getContext(), this);
    this.DOk = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
    paramContext = this.DOk;
    Object localObject1 = this.prS;
    localObject1 = com.tencent.mm.hellhoundlib.b.c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject1);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/voip/model/VoipMgr", "initMgr", "()Z", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    paramContext.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/voip/model/VoipMgr", "initMgr", "()Z", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    paramContext = "voip_recent_contact" + z.bcZ();
    localObject1 = MMApplicationContext.getContext().getSharedPreferences("voip_plugin_prefs", 0);
    Object localObject2 = ((SharedPreferences)localObject1).getString(paramContext, null);
    if (localObject2 != null)
    {
      localObject2 = Util.stringsToList(((String)localObject2).split(";"));
      if (localObject2 != null)
      {
        i = ((List)localObject2).size();
        if (((List)localObject2).contains(this.iSn))
        {
          if (i > 1)
          {
            ((List)localObject2).remove(this.iSn);
            label935:
            ((List)localObject2).add(0, this.iSn);
          }
          localObject2 = Util.listToString((List)localObject2, ";");
          ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
        }
      }
    }
    for (;;)
    {
      EventCenter.instance.addListener(this.NLj);
      EventCenter.instance.addListener(this.DOm);
      this.NKz.a(this);
      paramContext = new IntentFilter();
      paramContext.addAction("android.intent.action.SCREEN_ON");
      paramContext.addAction("android.intent.action.SCREEN_OFF");
      paramContext.addAction("android.intent.action.USER_PRESENT");
      MMApplicationContext.getContext().registerReceiver(this.NLh, paramContext);
      i = 1;
      break;
      if (4 != i) {
        break label935;
      }
      ((List)localObject2).remove(i - 1);
      break label935;
      localObject2 = new ArrayList();
      ((List)localObject2).add(0, this.iSn);
      localObject2 = Util.listToString((List)localObject2, ";");
      ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
    }
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    AppMethodBeat.i(115016);
    Log.i("MicroMsg.Voip.VoipMgr", "onVoipUIDestroy");
    if (this.NKk == paramb)
    {
      Log.d("MicroMsg.Voip.VoipMgr", "same mVoIPUi, clear it");
      this.NKk = null;
      this.NKh.b(null);
    }
    if (this.ntw != null) {
      this.ntw = null;
    }
    AppMethodBeat.o(115016);
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb, int paramInt)
  {
    AppMethodBeat.i(115011);
    Log.i("MicroMsg.Voip.VoipMgr", "onVoipUICreated, uiType: %s, captureRender: %s, mVoicePlayDevice: %s", new Object[] { Integer.valueOf(paramInt), this.NOn, Integer.valueOf(this.NKw) });
    if ((1 == paramInt) && (this.NKk != null)) {
      this.NKk.uninit();
    }
    this.NKk = paramb;
    this.mUIType = paramInt;
    this.NKh.b(this.NKk);
    if ((this.NOn == null) && (com.tencent.mm.plugin.voip.c.k.alD(this.NKi.mState))) {
      this.tRv = new CaptureView(MMApplicationContext.getContext());
    }
    this.NKk.kR(-1, this.NKi.mState);
    this.NKk.setConnectSec(this.NKx);
    Log.i("MicroMsg.Voip.VoipMgr", "steve: voipMgr decMode:%d, beautyCmd:%d", new Object[] { Integer.valueOf(this.NKN), Integer.valueOf(this.NKO) });
    if (this.NKN != -1)
    {
      this.NKk.setHWDecMode(this.NKN);
      Log.i("MicroMsg.Voip.VoipMgr", "steve: voipMgr setHWDecMode,decMode:%d", new Object[] { Integer.valueOf(this.NKN) });
    }
    this.NKk.setVoipBeauty(this.NKO);
    this.NKk.setSpatiotemporalDenosing(this.NKP);
    com.tencent.mm.plugin.voip.video.b.e.gEk().OcN = new e.a()
    {
      public final void Pu()
      {
        AppMethodBeat.i(242045);
        VoipMgr localVoipMgr = VoipMgr.this;
        SurfaceTexture localSurfaceTexture = v2protocal.mSurfaceTexture;
        com.tencent.mm.media.g.d locald = v2protocal.NSP;
        if ((localVoipMgr.NKk != null) && (localSurfaceTexture != null))
        {
          localSurfaceTexture.setOnFrameAvailableListener(localVoipMgr);
          localVoipMgr.NKk.a(localSurfaceTexture, locald);
        }
        AppMethodBeat.o(242045);
      }
    };
    if ((this.NKW != 0) && (this.NKX != 0)) {
      kN(this.NKW, this.NKX);
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
    if (this.NOp)
    {
      AppMethodBeat.o(115046);
      return;
    }
    if (this.NOn == null)
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
    if (this.NOn.gDP())
    {
      m = OpenGlRender.FLAG_Mirror;
      if (!this.NOn.gDz()) {
        break label488;
      }
      n = OpenGlRender.FLAG_Angle270;
      if (this.NKk != null)
      {
        if ((OpenGlRender.getGLVersion() != 2) || (this.NKO == 0)) {
          break label496;
        }
        i = 1;
        if ((this.NKO & 0x8) == 0) {
          break label502;
        }
        k = 1;
        if ((OpenGlRender.getGLVersion() != 2) || ((this.NKP & 0x1) == 0)) {
          break label508;
        }
        j = 1;
        label129:
        if ((i == 0) && (j == 0)) {
          break label872;
        }
        if ((k != 0) || (this.NKk.alh(2) == null)) {
          break label514;
        }
        this.NOt = 0;
        k = i;
        i = 1;
      }
    }
    for (;;)
    {
      label169:
      final ByteBuffer localByteBuffer;
      if ((this.NOn.gDP()) && ((k != 0) || (j != 0))) {
        if ((j != 0) && (i == 0))
        {
          localByteBuffer = this.NKk.gBH().Ogw;
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
        this.NOs = localByteBuffer;
        k = paramInt2;
        j = paramInt1;
        this.NOB = true;
        int i2 = 4;
        Object localObject = null;
        i1 = k;
        k = j;
        j = i2;
        Log.d("MicroMsg.Voip.VoipMgr", "jcchen capture data: w=" + paramInt1 + "h=" + paramInt2 + ", vw=" + k + "vh=" + i1 + ", bm=" + i + ", skip:" + this.NOx);
        i = (int)l;
        if (this.NOA != null) {
          this.NOA.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(114967);
              if (localByteBuffer != null)
              {
                com.tencent.mm.plugin.voip.c.gxs().c(localByteBuffer, i, j, k, i1, 0);
                AppMethodBeat.o(114967);
                return;
              }
              if (this.NOI != null)
              {
                u localu = com.tencent.mm.plugin.voip.c.gxs();
                byte[] arrayOfByte = this.NOI;
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
        this.NKk.a(paramArrayOfByte, paramLong, paramInt1, paramInt2, paramInt3 + paramInt4, m, n);
        R((byte[])localObject, paramInt1, paramInt2);
        this.NOw += 1;
        boolean bool;
        if (m == OpenGlRender.FLAG_Mirror)
        {
          bool = true;
          this.NKC = bool;
          if (n != OpenGlRender.FLAG_Angle270) {
            break label841;
          }
          paramInt3 = 270;
          this.NKD = paramInt3;
          this.NKz.kY(paramInt1, paramInt2);
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
          if ((k != 0) && (this.NKk.alh(1) != null) && (this.NKk.alh(1).luM != null))
          {
            this.NOt = 0;
            i1 = 2;
            k = i;
            i = i1;
            break label169;
          }
          if ((j != 0) && (this.NKk.gBH() != null))
          {
            this.NOt = 0;
            i1 = 0;
            k = i;
            i = i1;
            break label169;
          }
          if ((this.NOr != null) && (this.NOt <= 10))
          {
            this.NOt += 1;
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
            localByteBuffer = this.NKk.alh(2).luM;
            if (localByteBuffer == null) {
              break label860;
            }
          }
        }
        for (l = localByteBuffer.capacity();; l = paramLong)
        {
          this.NOs = localByteBuffer;
          k = paramInt2;
          j = paramInt1;
          break;
          if (i == 2)
          {
            localObject = this.NKk.alh(1);
            localByteBuffer = ((com.tencent.mm.plugin.voip.video.b.a)localObject).luM;
            if (localByteBuffer == null) {
              break label854;
            }
          }
          for (l = localByteBuffer.capacity();; l = paramLong)
          {
            j = ((com.tencent.mm.plugin.voip.video.b.a)localObject).width;
            k = ((com.tencent.mm.plugin.voip.video.b.a)localObject).height;
            this.NOs = localByteBuffer;
            break;
            localByteBuffer = this.NOs;
            if (localByteBuffer != null) {}
            for (l = localByteBuffer.capacity();; l = paramLong)
            {
              this.NOs = localByteBuffer;
              k = paramInt2;
              j = paramInt1;
              break;
              j = paramInt3 + paramInt4;
              this.NOB = false;
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
    if ((!this.NOu) && (this.NKs))
    {
      AU(true);
      this.NOu = true;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(239328);
        if (VoipMgr.e(VoipMgr.this) != null) {
          VoipMgr.e(VoipMgr.this).M(paramArrayOfInt);
        }
        if (VoipMgr.h(VoipMgr.this) != null) {
          VoipMgr.h(VoipMgr.this);
        }
        AppMethodBeat.o(239328);
      }
    });
    AppMethodBeat.o(115063);
  }
  
  public final void aQ(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(240989);
    if (this.NOy != null)
    {
      com.tencent.mm.plugin.voip.c.i locali = this.NOy;
      long l = Util.currentTicks();
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          locali.NYb = l;
          AppMethodBeat.o(240989);
          return;
        }
        locali.NXT = l;
        AppMethodBeat.o(240989);
        return;
      }
      if (paramBoolean2)
      {
        locali.NYc = l;
        AppMethodBeat.o(240989);
        return;
      }
      locali.NXU = l;
    }
    AppMethodBeat.o(240989);
  }
  
  public final void akA(int paramInt)
  {
    AppMethodBeat.i(115035);
    Log.i("MicroMsg.Voip.VoipMgr", "remote voip mode changed, cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    if (((1 == paramInt) || (3 == paramInt) || (5 == paramInt) || (6 == paramInt) || (7 == paramInt)) && (this.NKs))
    {
      Bl(4101);
      com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.gyN();
      com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.gyO();
    }
    AppMethodBeat.o(115035);
  }
  
  public final void akB(int paramInt)
  {
    AppMethodBeat.i(241013);
    if (this.NKk != null) {
      this.NKk.akB(paramInt);
    }
    AppMethodBeat.o(241013);
  }
  
  public final void akC(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(115040);
    Log.i("MicroMsg.Voip.VoipMgr", "onSessionBeingCalled, callType: ".concat(String.valueOf(paramInt)));
    if (!this.NKi.alG(4110))
    {
      AppMethodBeat.o(115040);
      return;
    }
    u localu = com.tencent.mm.plugin.voip.c.gxs();
    if (paramInt == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramInt == 1) {
        bool2 = true;
      }
      localu.aT(bool1, bool2);
      gxW();
      if ((paramInt == 1) && (com.tencent.mm.plugin.voip.c.k.alD(this.NKi.mState))) {
        Bl(4101);
      }
      Bl(4110);
      AppMethodBeat.o(115040);
      return;
    }
  }
  
  public final void akD(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(115041);
    Log.i("MicroMsg.Voip.VoipMgr", "steve:[simucall]onNewSimulCallAutoAccept, callType: ".concat(String.valueOf(paramInt)));
    if (!this.NKi.alG(4100))
    {
      AppMethodBeat.o(115041);
      return;
    }
    u localu = com.tencent.mm.plugin.voip.c.gxs();
    if (paramInt == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramInt == 1) {
        bool2 = true;
      }
      localu.aT(bool1, bool2);
      com.tencent.mm.plugin.voip.c.gxs().NPf.stopRing();
      if ((paramInt == 1) && (com.tencent.mm.plugin.voip.c.k.alD(this.NKi.mState))) {
        Bl(4101);
      }
      Bl(4100);
      AppMethodBeat.o(115041);
      return;
    }
  }
  
  final void akw(int paramInt)
  {
    AppMethodBeat.i(115013);
    if (paramInt == 5)
    {
      pIN += NLd[0];
      this.NLi += 1;
      Log.i("MicroMsg.Voip.VoipMgr", "mSignalStrength 4G" + NLd[0] + " and index is " + this.NLi);
      AppMethodBeat.o(115013);
      return;
    }
    if ((paramInt == 4) && (NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {}
    try
    {
      NLd[1] = ConnectivityCompat.Companion.getWiFiRssi();
      pIN += NLd[1];
      this.NLi += 1;
      Log.i("MicroMsg.Voip.VoipMgr", "mSignalStrength WIFI " + NLd[1] + " and index is " + this.NLi);
      AppMethodBeat.o(115013);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        NLd[1] = 0;
        Log.i("MicroMsg.Voip.VoipMgr", "error happened in get wifi info");
      }
    }
  }
  
  public final void aq(long paramLong, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(240990);
    Object localObject;
    label50:
    boolean bool;
    if (this.NOy != null) {
      switch (paramInt)
      {
      default: 
        localObject = this.NOy;
        if (1 == this.mUIType)
        {
          bool = this.NOB;
          switch (paramInt)
          {
          }
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(240990);
      return;
      if (1 == this.mUIType)
      {
        if (!com.tencent.mm.plugin.voip.c.gxs().NPu)
        {
          localObject = this.NOy;
          if ((260 != this.NKi.mState) && (6 != this.NKi.mState)) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.plugin.voip.c.i)localObject).ba(true, bool);
            com.tencent.mm.plugin.voip.c.gxs().NPu = true;
            break;
          }
        }
        localObject = this.NOy;
        if ((260 != this.NKi.mState) && (6 != this.NKi.mState)) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.voip.c.i)localObject).bb(true, bool);
          break;
        }
      }
      if (!com.tencent.mm.plugin.voip.c.gxs().NPt)
      {
        localObject = this.NOy;
        if ((260 != this.NKi.mState) && (6 != this.NKi.mState)) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.voip.c.i)localObject).ba(false, bool);
          com.tencent.mm.plugin.voip.c.gxs().NPt = true;
          break;
        }
      }
      localObject = this.NOy;
      if ((260 != this.NKi.mState) && (6 != this.NKi.mState)) {}
      for (bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.voip.c.i)localObject).bb(false, bool);
        break;
      }
      i = 0;
      break label50;
      ((com.tencent.mm.plugin.voip.c.i)localObject).NXX += 1;
      if (((com.tencent.mm.plugin.voip.c.i)localObject).NXX == 0)
      {
        if (i != 0)
        {
          if (paramLong != -1L)
          {
            localObject = com.tencent.mm.plugin.voip.c.f.NXN;
            com.tencent.mm.plugin.voip.c.f.SQ(paramLong);
            AppMethodBeat.o(240990);
          }
        }
        else
        {
          if (paramLong != -1L)
          {
            localObject = com.tencent.mm.plugin.voip.c.f.NXN;
            com.tencent.mm.plugin.voip.c.f.SR(paramLong);
          }
          AppMethodBeat.o(240990);
        }
      }
      else if (((com.tencent.mm.plugin.voip.c.i)localObject).NXX == 60) {
        ((com.tencent.mm.plugin.voip.c.i)localObject).NXX = -1;
      }
      AppMethodBeat.o(240990);
      return;
      ((com.tencent.mm.plugin.voip.c.i)localObject).NXY += 1;
      if (((com.tencent.mm.plugin.voip.c.i)localObject).NXY == 0)
      {
        if (i != 0)
        {
          if (paramLong > 0L)
          {
            if (bool)
            {
              localObject = com.tencent.mm.plugin.voip.c.f.NXN;
              com.tencent.mm.plugin.voip.c.f.SX(paramLong);
              AppMethodBeat.o(240990);
              return;
            }
            localObject = com.tencent.mm.plugin.voip.c.f.NXN;
            com.tencent.mm.plugin.voip.c.f.SU(paramLong);
            AppMethodBeat.o(240990);
          }
        }
        else
        {
          if (paramLong > 0L)
          {
            if (bool)
            {
              localObject = com.tencent.mm.plugin.voip.c.f.NXN;
              com.tencent.mm.plugin.voip.c.f.SW(paramLong);
              AppMethodBeat.o(240990);
              return;
            }
            localObject = com.tencent.mm.plugin.voip.c.f.NXN;
            com.tencent.mm.plugin.voip.c.f.SV(paramLong);
          }
          AppMethodBeat.o(240990);
        }
      }
      else if (((com.tencent.mm.plugin.voip.c.i)localObject).NXY == 30) {
        ((com.tencent.mm.plugin.voip.c.i)localObject).NXY = -1;
      }
      AppMethodBeat.o(240990);
      return;
      ((com.tencent.mm.plugin.voip.c.i)localObject).NXZ += 1;
      if (((com.tencent.mm.plugin.voip.c.i)localObject).NXZ == 0)
      {
        if (i != 0)
        {
          localObject = com.tencent.mm.plugin.voip.c.f.NXN;
          com.tencent.mm.plugin.voip.c.f.SS(paramLong);
          AppMethodBeat.o(240990);
          return;
        }
        localObject = com.tencent.mm.plugin.voip.c.f.NXN;
        com.tencent.mm.plugin.voip.c.f.ST(paramLong);
        AppMethodBeat.o(240990);
        return;
      }
      if (((com.tencent.mm.plugin.voip.c.i)localObject).NXZ == 60) {
        ((com.tencent.mm.plugin.voip.c.i)localObject).NXZ = -1;
      }
    }
  }
  
  public final void bgb(String paramString)
  {
    AppMethodBeat.i(240996);
    if (this.NKk != null)
    {
      this.NKK = paramString;
      this.NKk.bgj(paramString);
    }
    AppMethodBeat.o(240996);
  }
  
  public final void cNy()
  {
    AppMethodBeat.i(115061);
    if ((true == this.EZD) || (this.NKk == null) || (this.NKk.gBI() == null))
    {
      Log.d("MicroMsg.Voip.VoipMgr", "onCameraError, already show");
      AppMethodBeat.o(115061);
      return;
    }
    if (this.NOn.egx())
    {
      AppMethodBeat.o(115061);
      return;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("meizu")) && (!com.tencent.mm.compatible.e.b.avv()) && (com.tencent.mm.compatible.util.d.qW(29)))
    {
      Log.d("MicroMsg.Voip.VoipMgr", "onCameraError, meizu machine");
      AppMethodBeat.o(115061);
      return;
    }
    if ((com.tencent.mm.compatible.util.d.qV(28)) && (((KeyguardManager)MMApplicationContext.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()))
    {
      Log.i("MicroMsg.Voip.VoipMgr", "api level: %s, in keyguard, ignore", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(115061);
      return;
    }
    Log.d("MicroMsg.Voip.VoipMgr", "onCameraError, show dialog");
    Object localObject = com.tencent.mm.plugin.report.service.h.IzE;
    if (this.NKs) {}
    for (int i = 0;; i = 1)
    {
      ((com.tencent.mm.plugin.report.service.h)localObject).a(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      localObject = com.tencent.mm.ui.base.h.p(this.NKk.gBI(), b.g.voip_no_record_video_permission, b.g.app_tip);
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
    this.EZD = true;
    com.tencent.mm.plugin.voip.c.h.gCQ();
    AppMethodBeat.o(115061);
  }
  
  public final void e(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(115036);
    if (this.NKk != null) {
      this.NKk.f(paramInt1, paramInt2, paramArrayOfByte);
    }
    AppMethodBeat.o(115036);
  }
  
  public final void eIH()
  {
    AppMethodBeat.i(115027);
    Log.i("MicroMsg.Voip.VoipMgr", "on accept");
    gxW();
    Bl(4100);
    AppMethodBeat.o(115027);
  }
  
  public final void eIN()
  {
    AppMethodBeat.i(241050);
    Log.i("MicroMsg.Voip.VoipMgr", "onNetWorkChangeMobileNet");
    if (this.NKk != null) {
      this.NKk.gBK();
    }
    AppMethodBeat.o(241050);
  }
  
  public final void eIO()
  {
    AppMethodBeat.i(241051);
    Log.i("MicroMsg.Voip.VoipMgr", "onNetWorkCostMax");
    if (this.NKk != null) {
      this.NKk.eIO();
    }
    AppMethodBeat.o(241051);
  }
  
  public final void eIP()
  {
    AppMethodBeat.i(115051);
    Log.i("MicroMsg.Voip.VoipMgr", "onResumeGoodNetStatus");
    if (this.NKk != null) {
      this.NKk.eKF();
    }
    AppMethodBeat.o(115051);
  }
  
  public final void eXH()
  {
    AppMethodBeat.i(184052);
    if (this.NKk != null) {
      this.NKk.eXH();
    }
    AppMethodBeat.o(184052);
  }
  
  public final void fP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(241054);
    Log.i("MicroMsg.Voip.VoipMgr", "camera preview size applye is $width and $height");
    AppMethodBeat.o(241054);
  }
  
  public final int getState()
  {
    return this.NKi.mState;
  }
  
  public final String getUserName()
  {
    return this.iSn;
  }
  
  public final boolean gxG()
  {
    AppMethodBeat.i(115003);
    if (!this.NKi.alG(4103))
    {
      AppMethodBeat.o(115003);
      return false;
    }
    akx(4103);
    com.tencent.mm.plugin.voip.c.gxs().gAE();
    AppMethodBeat.o(115003);
    return true;
  }
  
  public final boolean gxH()
  {
    AppMethodBeat.i(115004);
    if (!this.NKi.alG(4101))
    {
      AppMethodBeat.o(115004);
      return false;
    }
    gxW();
    com.tencent.mm.plugin.voip.c.gxs().akP(1);
    com.tencent.mm.plugin.voip.c.gxs().aT(true, this.NKs);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
    long l = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ;
    int j = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId;
    if (this.NKr) {}
    for (int i = 1;; i = 0)
    {
      localh.a(11046, new Object[] { Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i) });
      com.tencent.mm.plugin.report.service.h.IzE.a(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0) });
      Bl(4111);
      Bl(4101);
      Bl(4100);
      AppMethodBeat.o(115004);
      return true;
    }
  }
  
  public final boolean gxI()
  {
    int i = 0;
    AppMethodBeat.i(115005);
    if (!this.NKi.alG(4099))
    {
      AppMethodBeat.o(115005);
      return false;
    }
    String str2 = this.NKq.field_username;
    if (this.NKs) {}
    for (String str1 = ca.VGy;; str1 = ca.VGx)
    {
      if (this.NKr) {
        i = 1;
      }
      s.b(str2, str1, i, 6, MMApplicationContext.getContext().getString(b.g.voip_callfrom_reject_msg));
      gxW();
      com.tencent.mm.plugin.voip.c.gxs().gAj();
      Bl(4099);
      gyb();
      AppMethodBeat.o(115005);
      return true;
    }
  }
  
  public final boolean gxJ()
  {
    AppMethodBeat.i(115006);
    if (!this.NKi.alG(4100))
    {
      AppMethodBeat.o(115006);
      return false;
    }
    if ((af.juH.jpL == 1) && (this.NKs)) {
      AU(true);
    }
    if (((!this.NOu) || (af.juH.jpL == 1) || (af.juH.jpM == 1)) && (this.NKs)) {
      if ((this.NOn != null) && (!this.NOn.gDP())) {
        break label152;
      }
    }
    label152:
    for (boolean bool = true;; bool = false)
    {
      AU(bool);
      this.NOu = true;
      Log.i("MicroMsg.Voip.VoipMgr", "onAcceptVideoInvite");
      gxW();
      com.tencent.mm.plugin.voip.c.gxs().aT(false, this.NKs);
      Bl(4100);
      AppMethodBeat.o(115006);
      return true;
    }
  }
  
  public final boolean gxK()
  {
    int i = 0;
    AppMethodBeat.i(115007);
    if (!this.NKi.alG(4099))
    {
      AppMethodBeat.o(115007);
      return false;
    }
    Log.i("MicroMsg.Voip.VoipMgr", "onRejectVoiceInvite");
    String str2 = this.NKq.field_username;
    if (this.NKs) {}
    for (String str1 = ca.VGy;; str1 = ca.VGx)
    {
      if (this.NKr) {
        i = 1;
      }
      s.b(str2, str1, i, 6, MMApplicationContext.getContext().getString(b.g.voip_callfrom_reject_msg));
      gxW();
      com.tencent.mm.plugin.voip.c.gxs().gAj();
      Bl(4099);
      gyb();
      AppMethodBeat.o(115007);
      return true;
    }
  }
  
  public final boolean gxL()
  {
    AppMethodBeat.i(115008);
    if (!this.NKi.alG(4100))
    {
      AppMethodBeat.o(115008);
      return false;
    }
    Log.i("MicroMsg.Voip.VoipMgr", "onAcceptVoiceInvite");
    gxW();
    com.tencent.mm.plugin.voip.c.gxs().aT(true, this.NKs);
    Bl(4111);
    Bl(4100);
    AppMethodBeat.o(115008);
    return true;
  }
  
  public final boolean gxM()
  {
    AppMethodBeat.i(115009);
    if (!this.NKi.alG(4098))
    {
      AppMethodBeat.o(115009);
      return false;
    }
    Log.i("MicroMsg.Voip.VoipMgr", "onCancelVideoInvite");
    akx(4098);
    com.tencent.mm.plugin.voip.c.gxs().gAE();
    AppMethodBeat.o(115009);
    return true;
  }
  
  public final boolean gxN()
  {
    AppMethodBeat.i(115010);
    if (!this.NKi.alG(4098))
    {
      AppMethodBeat.o(115010);
      return false;
    }
    Log.i("MicroMsg.Voip.VoipMgr", "onCancelVoiceInvite");
    akx(4098);
    com.tencent.mm.plugin.voip.c.gxs().gAE();
    AppMethodBeat.o(115010);
    return true;
  }
  
  public final void gxO()
  {
    AppMethodBeat.i(115012);
    if ((this.NKs) && (this.NKk != null))
    {
      this.NKk.setCaptureView(this.tRv);
      if ((af.juH.jpL == 0) || (this.NKr)) {
        if ((this.NOn != null) && (!this.NOn.gDP())) {
          break label145;
        }
      }
    }
    label145:
    for (boolean bool = true;; bool = false)
    {
      AU(bool);
      if ((this.NKr) && (com.tencent.mm.plugin.voip.c.k.alE(this.NKi.mState)) && (com.tencent.mm.plugin.voip.c.gxs().NPf.cNL()))
      {
        this.NKh.aZ(this.NKs, this.NKr);
        this.NKh.b("voip", Integer.valueOf(this.NKw));
      }
      AppMethodBeat.o(115012);
      return;
    }
  }
  
  public final void gxP()
  {
    AppMethodBeat.i(115014);
    Log.i("MicroMsg.Voip.VoipMgr", "it is init voip report");
    this.NOv = new NetChangedBroadcastReceiver();
    Object localObject1 = new IntentFilter();
    ((IntentFilter)localObject1).addAction("android.net.wifi.WIFI_STATE_CHANGED");
    ((IntentFilter)localObject1).addAction("android.net.wifi.STATE_CHANGE");
    ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
    MMApplicationContext.getContext().registerReceiver(this.NOv, (IntentFilter)localObject1);
    this.tSE = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
    this.NKY = com.tencent.mm.plugin.voip.c.e.getNetType(getContext());
    this.NLb = new PhoneStateListener()
    {
      public final void onSignalStrengthsChanged(SignalStrength paramAnonymousSignalStrength)
      {
        AppMethodBeat.i(242650);
        super.onSignalStrengthsChanged(paramAnonymousSignalStrength);
        super.onSignalStrengthsChanged(paramAnonymousSignalStrength);
        paramAnonymousSignalStrength = paramAnonymousSignalStrength.toString().split(" ");
        try
        {
          if ((VoipMgr.j(VoipMgr.this).getNetworkType() == 13) && (paramAnonymousSignalStrength.length > 9)) {
            VoipMgr.bsf()[0] = Util.safeParseInt(paramAnonymousSignalStrength[9]);
          }
          AppMethodBeat.o(242650);
          return;
        }
        catch (Exception paramAnonymousSignalStrength)
        {
          Log.printErrStackTrace("MicroMsg.Voip.VoipMgr", paramAnonymousSignalStrength, "", new Object[0]);
          AppMethodBeat.o(242650);
        }
      }
    };
    localObject1 = this.tSE;
    Object localObject2 = this.NLb;
    localObject2 = com.tencent.mm.hellhoundlib.b.c.a(256, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/voip/model/VoipMgr", "initVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/voip/model/VoipMgr", "initVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    AppMethodBeat.o(115014);
  }
  
  public final void gxR()
  {
    AppMethodBeat.i(115017);
    Log.i("MicroMsg.Voip.VoipMgr", "onSwitchCamera");
    if (this.NOn != null) {
      this.NOn.gDD();
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(11079, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(115017);
  }
  
  public final void gxS()
  {
    AppMethodBeat.i(115018);
    if (true != this.NOn.gDP()) {
      gxR();
    }
    AppMethodBeat.o(115018);
  }
  
  public final void gxT() {}
  
  public final void gxU() {}
  
  public final void gxV() {}
  
  public final void gxW()
  {
    AppMethodBeat.i(240987);
    if (this.NKh != null)
    {
      Log.i("MicroMsg.Voip.VoipMgr", "use audioManager to stop voip ring");
      this.NKh.gxW();
      AppMethodBeat.o(240987);
      return;
    }
    Log.i("MicroMsg.Voip.VoipMgr", "use Subcore to stop voip ring");
    com.tencent.mm.plugin.voip.c.gxs().NPf.stopRing();
    AppMethodBeat.o(240987);
  }
  
  public final boolean gxX()
  {
    AppMethodBeat.i(115020);
    if (com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId == 0)
    {
      this.NKv = true;
      AppMethodBeat.o(115020);
      return true;
    }
    boolean bool = gxY();
    AppMethodBeat.o(115020);
    return bool;
  }
  
  public final void gxZ()
  {
    AppMethodBeat.i(115022);
    Log.i("MicroMsg.Voip.VoipMgr", "onRoomReady");
    if ((this.NKv) && (com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId != 0))
    {
      this.NKv = false;
      gxY();
    }
    if (this.NKr) {
      Bl(4097);
    }
    AppMethodBeat.o(115022);
  }
  
  public final boolean gxl()
  {
    return this.NKs;
  }
  
  public final boolean gxm()
  {
    return this.NKr;
  }
  
  public final String gxn()
  {
    return this.NKK;
  }
  
  public final long gxo()
  {
    return this.NKQ;
  }
  
  public final long gxp()
  {
    return this.NKR;
  }
  
  public final int gxq()
  {
    return this.NKS;
  }
  
  public final void gya()
  {
    AppMethodBeat.i(115028);
    Log.i("MicroMsg.Voip.VoipMgr", "onReject");
    Bl(4099);
    String str2 = this.NKq.field_username;
    String str1;
    if (this.NKs)
    {
      str1 = ca.VGy;
      if (!this.NKr) {
        break label86;
      }
    }
    label86:
    for (int i = 1;; i = 0)
    {
      s.b(str2, str1, i, 6, MMApplicationContext.getContext().getString(b.g.voip_callout_reject_msg));
      gyb();
      AppMethodBeat.o(115028);
      return;
      str1 = ca.VGx;
      break;
    }
  }
  
  public final void gyd()
  {
    AppMethodBeat.i(115031);
    Log.i("MicroMsg.Voip.VoipMgr", "onNoResp");
    Bl(4105);
    String str2 = this.NKq.field_username;
    String str1;
    if (this.NKs)
    {
      str1 = ca.VGy;
      if (!this.NKr) {
        break label181;
      }
    }
    label181:
    for (int i = 1;; i = 0)
    {
      s.b(str2, str1, i, 4, MMApplicationContext.getContext().getString(b.g.voip_callout_no_resp));
      com.tencent.mm.plugin.report.service.h.IzE.a(11518, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.gyI()), Integer.valueOf(6), Integer.valueOf(NetStatusUtil.getNetWorkType(getContext())) });
      gyb();
      AppMethodBeat.o(115031);
      return;
      str1 = ca.VGx;
      break;
    }
  }
  
  public final void gye()
  {
    int j = 0;
    AppMethodBeat.i(115033);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
    int k = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId;
    long l1 = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ;
    long l2 = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.gyI();
    if (this.NKr)
    {
      i = 0;
      localh.a(11522, true, true, new Object[] { Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(1) });
      k = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId;
      l1 = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ;
      if (!this.NKr) {
        break label205;
      }
    }
    label205:
    for (int i = j;; i = 1)
    {
      com.tencent.mm.plugin.voip.c.e.c(k, l1, i, 3);
      if (this.NLc != null) {
        this.NLc.post(new Runnable()
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
  
  public final void gyf()
  {
    AppMethodBeat.i(115042);
    Log.d("MicroMsg.Voip.VoipMgr", "onPretreatmentForStartDev");
    this.NKh.aY(this.NKJ, this.NKs);
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
    gzy();
    AppMethodBeat.o(115042);
  }
  
  public final long gyg()
  {
    AppMethodBeat.i(115044);
    long l = this.NKh.NXi;
    Log.printInfoStack("MicroMsg.Voip.VoipMgr", "totalDeviceNearTime: %s", new Object[] { Long.valueOf(l) });
    l /= 1000L;
    AppMethodBeat.o(115044);
    return l;
  }
  
  public final void gyk()
  {
    AppMethodBeat.i(115058);
    if ((256 != this.NKi.mState) && (257 != this.NKi.mState))
    {
      AppMethodBeat.o(115058);
      return;
    }
    if ((com.tencent.mm.kernel.h.aHG().aHp().getInt(327945, 0) == 0) && (this.NKk.gBI() != null))
    {
      com.tencent.mm.kernel.h.aHG().aHp().setInt(327945, 1);
      com.tencent.mm.ui.widget.a.d locald = com.tencent.mm.ui.base.h.a(this.NKk.gBI(), b.g.voip_ignore_warning, b.g.app_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(236190);
          VoipMgr.this.gym();
          AppMethodBeat.o(236190);
        }
      });
      locald.setCancelable(false);
      locald.setCanceledOnTouchOutside(false);
      locald.show();
      AppMethodBeat.o(115058);
      return;
    }
    m.aL(MMApplicationContext.getContext(), b.g.voip_ignore_warning);
    gym();
    AppMethodBeat.o(115058);
  }
  
  public final void gyl()
  {
    AppMethodBeat.i(115059);
    if (!this.NKB) {}
    for (boolean bool = true;; bool = false)
    {
      this.NKB = bool;
      if (!this.NKB) {
        break;
      }
      this.NKA.stopTimer();
      AppMethodBeat.o(115059);
      return;
    }
    if (this.NKA == null) {
      this.NKA = new MTimerHandler("faceDetect", new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(236232);
          VoipMgr.L(VoipMgr.this);
          AppMethodBeat.o(236232);
          return true;
        }
      }, true);
    }
    this.NKA.startTimer(2000L);
    this.NKB = false;
    AppMethodBeat.o(115059);
  }
  
  public final void gym()
  {
    AppMethodBeat.i(115060);
    com.tencent.mm.plugin.voip.c.gxs().NPn = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId;
    String str2 = this.NKq.field_username;
    String str1;
    if (this.NKs)
    {
      str1 = ca.VGy;
      if (!this.NKr) {
        break label124;
      }
    }
    label124:
    for (int i = 1;; i = 0)
    {
      s.b(str2, str1, i, 6, MMApplicationContext.getContext().getString(b.g.voip_callfrom_ignore_msg));
      gxW();
      Bl(4108);
      if (this.ntw != null) {
        this.ntw.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(234707);
            VoipMgr.K(VoipMgr.this);
            AppMethodBeat.o(234707);
          }
        }, 2000L);
      }
      AppMethodBeat.o(115060);
      return;
      str1 = ca.VGx;
      break;
    }
  }
  
  public final void kM(int paramInt1, int paramInt2) {}
  
  public final void kN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115039);
    Log.i("MicroMsg.Voip.VoipMgr", "adjustHWViewAspectRatio, HWDecsize:%dx%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.NKW = paramInt1;
    this.NKX = paramInt2;
    if (this.NKk != null) {
      this.NKk.kN(paramInt1, paramInt2);
    }
    AppMethodBeat.o(115039);
  }
  
  public final void onConnected()
  {
    AppMethodBeat.i(115032);
    Bl(4102);
    this.NKx = Util.nowSecond();
    if (this.NKk != null) {
      this.NKk.setConnectSec(this.NKx);
    }
    boolean bool1 = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.gyK();
    boolean bool2 = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.gyJ();
    if ((this.NKs) && (this.NKr) && (!bool2) && (!bool1)) {
      com.tencent.mm.plugin.voip.c.gxs().akP(1);
    }
    if (!com.tencent.mm.plugin.voip.c.k.alD(this.NKi.mState)) {
      com.tencent.mm.plugin.report.service.h.IzE.a(11080, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
    }
    Util.shake(MMApplicationContext.getContext(), true);
    com.tencent.mm.plugin.voip.c.gxs().ala(com.tencent.mm.plugin.voip.c.gxs().gAD());
    r.gzC().gzD();
    r.gzC().a(this);
    k localk = k.NLD;
    k.setRoomId(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId);
    AppMethodBeat.o(115032);
  }
  
  public final void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(115026);
    this.NKh.Bi(this.NKs);
    String str1 = paramString;
    if (paramInt == 241)
    {
      str1 = paramString;
      if (Util.isNullOrNil(paramString)) {
        str1 = getContext().getString(b.g.voip_overload_protection_default_wording);
      }
    }
    if (this.NKk != null) {
      this.NKk.cG(paramInt, str1);
    }
    Bl(4109);
    Log.i("MicroMsg.Voip.VoipMgr", "onError, errCode: %s, roomId: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId) });
    paramString = MMApplicationContext.getContext();
    Log.d("MicroMsg.Voip.VoipMgr", "getErrorMsgContent, errorCode".concat(String.valueOf(paramInt)));
    if (paramInt == 235)
    {
      paramString = paramString.getString(b.g.voip_callout_error_msg_unsupport);
      if ((com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId == 0) || (com.tencent.mm.plugin.voip.c.gxs().NPm.get(Integer.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId)) != null)) {
        break label431;
      }
      str2 = this.NKq.field_username;
      if (!this.NKs) {
        break label418;
      }
      str1 = ca.VGy;
      if (!this.NKr) {
        break label426;
      }
      paramInt = 1;
      if (com.tencent.mm.plugin.voip.c.k.alC(this.NKi.mState)) {
        paramString = MMApplicationContext.getContext().getString(b.g.voip_call_msg_chat_time_interrupt_by_err, new Object[] { GN(Util.secondsToNow(this.NKx)) });
      }
      l = s.a(str2, str1, paramInt, 6, paramString, true);
      com.tencent.mm.plugin.voip.c.gxs().NPm.put(Integer.valueOf(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId), Long.valueOf(l));
    }
    label418:
    label426:
    label431:
    while (com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.roomId != 0) {
      for (;;)
      {
        long l;
        com.tencent.mm.plugin.voip.c.gxs().gAE();
        gyb();
        AppMethodBeat.o(115026);
        return;
        if (paramInt == 233)
        {
          paramString = paramString.getString(b.g.voip_call_fail);
          break;
        }
        if (paramInt == 237)
        {
          paramString = paramString.getString(b.g.voip_callout_error_msg_unsupport);
          break;
        }
        if (paramInt == 236)
        {
          paramString = paramString.getString(b.g.voip_call_fail);
          break;
        }
        if (paramInt == 211)
        {
          paramString = paramString.getString(b.g.voip_callout_error_msg_busy);
          break;
        }
        paramString = paramString.getString(b.g.voip_call_connection_failed);
        break;
        str1 = ca.VGx;
        continue;
        paramInt = 0;
      }
    }
    String str2 = this.NKq.field_username;
    if (this.NKs)
    {
      str1 = ca.VGy;
      label470:
      if (!this.NKr) {
        break label543;
      }
    }
    label543:
    for (paramInt = 1;; paramInt = 0)
    {
      if (com.tencent.mm.plugin.voip.c.k.alC(this.NKi.mState)) {
        paramString = MMApplicationContext.getContext().getString(b.g.voip_call_msg_chat_time_interrupt_by_err, new Object[] { GN(Util.secondsToNow(this.NKx)) });
      }
      s.a(str2, str1, paramInt, 6, paramString, true);
      break;
      str1 = ca.VGx;
      break label470;
    }
  }
  
  public final void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(115064);
    if (this.NKk != null) {
      this.NKk.requestRender();
    }
    AppMethodBeat.o(115064);
  }
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(115038);
    this.NKN = paramInt;
    if (this.NKk != null) {
      this.NKk.setHWDecMode(paramInt);
    }
    if (this.NOy != null)
    {
      com.tencent.mm.plugin.voip.c.i locali = this.NOy;
      if ((paramInt & 0x1) != 0)
      {
        locali.NXP += 1L;
        AppMethodBeat.o(115038);
        return;
      }
      locali.NXQ += 1L;
    }
    AppMethodBeat.o(115038);
  }
  
  public final void setSpatiotemporalDenosing(int paramInt)
  {
    AppMethodBeat.i(241020);
    Log.i("MicroMsg.Voip.VoipMgr", "setSpatiotemporalDenosing, isON: " + paramInt + "，mVoipUI: " + this.NKk);
    if (this.NKk != null) {
      this.NKk.setSpatiotemporalDenosing(paramInt);
    }
    if ((paramInt != 0) && (this.NKP != paramInt)) {
      com.tencent.mm.plugin.report.service.h.IzE.p(914L, 20L, 1L);
    }
    this.NOx = 2;
    this.NKP = paramInt;
    AppMethodBeat.o(241020);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(240985);
    if ((this.NKw == 2) && (paramInt != 2)) {
      this.NKh.gCl();
    }
    for (;;)
    {
      this.NKw = paramInt;
      AppMethodBeat.o(240985);
      return;
      if ((paramInt == 2) && (this.NKw != 2) && (!com.tencent.mm.plugin.voip.c.k.alD(this.NKi.mState)))
      {
        getContext();
        gyp();
      }
    }
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    AppMethodBeat.i(115037);
    Log.i("MicroMsg.Voip.VoipMgr", "setVoipBeauty, isON: " + paramInt + "，mVoipUI: " + this.NKk);
    if (this.NKk != null) {
      this.NKk.setVoipBeauty(paramInt);
    }
    if ((paramInt != 0) && (this.NKO != paramInt)) {
      com.tencent.mm.plugin.report.service.h.IzE.p(914L, 20L, 1L);
    }
    this.NOx = 2;
    this.NKO = paramInt;
    AppMethodBeat.o(115037);
  }
  
  public final void tn(boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(115050);
    Log.i("MicroMsg.Voip.VoipMgr", "onBadNetStatus");
    if (this.NKk != null) {
      this.NKk.Ba(paramBoolean);
    }
    long l;
    if ((!com.tencent.mm.plugin.voip.c.k.alD(this.NKi.mState)) && (!this.NKh.crl()))
    {
      l = System.currentTimeMillis();
      if (l - this.DQv > 30000L)
      {
        this.DQv = l;
        com.tencent.mm.plugin.voip.c.gxs().akY(b.f.close_lower_volume);
      }
    }
    Object localObject = new StringBuilder("report the bad net toast room key is ").append(com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ).append("and in the side");
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      Log.i("MicroMsg.Voip.VoipMgr", i);
      localObject = com.tencent.mm.plugin.report.service.h.IzE;
      l = com.tencent.mm.plugin.voip.c.gxs().NPf.NJk.NMi.DPJ;
      i = j;
      if (paramBoolean) {
        i = 1;
      }
      ((com.tencent.mm.plugin.report.service.h)localObject).a(17151, true, true, new Object[] { Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(115050);
      return;
    }
  }
  
  public final void uy(boolean paramBoolean)
  {
    AppMethodBeat.i(115002);
    this.NKh.Bh(paramBoolean);
    AppMethodBeat.o(115002);
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
        switch (com.tencent.mm.plugin.voip.c.e.getNetType(paramContext))
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
              j = VoipMgr.bsf()[1];
              if (VoipMgr.l(VoipMgr.this) == 0) {
                VoipMgr.a(VoipMgr.this, 4);
              }
            } while (VoipMgr.l(VoipMgr.this) == 0);
            k = VoipMgr.cPc() / VoipMgr.l(VoipMgr.this);
            VoipMgr.a(VoipMgr.this, 5);
            m = VoipMgr.bsf()[0];
            Log.i("MicroMsg.Voip.VoipMgr", "befor change to 4G and cost " + VoipMgr.m(VoipMgr.this));
            if (VoipMgr.d(VoipMgr.this)) {}
            for (;;)
            {
              com.tencent.mm.plugin.voip.c.e.a(i, System.currentTimeMillis(), VoipMgr.k(VoipMgr.this), 5, j, m, k);
              VoipMgr.n(VoipMgr.this);
              VoipMgr.b(VoipMgr.this, 5);
              VoipMgr.gzB();
              VoipMgr.o(VoipMgr.this);
              AppMethodBeat.o(114993);
              return;
              i = 1;
            }
          } while (VoipMgr.k(VoipMgr.this) == 4);
          k = VoipMgr.bsf()[0];
          if (VoipMgr.l(VoipMgr.this) == 0) {
            VoipMgr.a(VoipMgr.this, 5);
          }
        } while (VoipMgr.l(VoipMgr.this) == 0);
        int m = VoipMgr.cPc() / VoipMgr.l(VoipMgr.this);
        VoipMgr.a(VoipMgr.this, 4);
        int n = VoipMgr.bsf()[1];
        Log.i("MicroMsg.Voip.VoipMgr", "befor change to wifi and cost " + VoipMgr.m(VoipMgr.this));
        if (VoipMgr.d(VoipMgr.this)) {}
        for (i = j;; i = 1)
        {
          com.tencent.mm.plugin.voip.c.e.a(i, System.currentTimeMillis(), VoipMgr.k(VoipMgr.this), 4, k, n, m);
          VoipMgr.n(VoipMgr.this);
          VoipMgr.b(VoipMgr.this, 4);
          VoipMgr.gzB();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.VoipMgr
 * JD-Core Version:    0.7.0.1
 */