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
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.PowerManager;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.Size;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.autogen.a.acm;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.adu;
import com.tencent.mm.autogen.a.adu.a;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.f.m;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderSurfaceView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView.b;
import com.tencent.mm.plugin.voip.video.render.h.l;
import com.tencent.mm.plugin.voip.video.render.j.b;
import com.tencent.mm.plugin.voip.video.render.j.f;
import com.tencent.mm.plugin.voip.video.render.j.g;
import com.tencent.mm.plugin.voip.video.render.j.h;
import com.tencent.mm.plugin.voip.video.render.j.i;
import com.tencent.mm.plugin.voip.video.render.j.n;
import com.tencent.mm.plugin.voip.video.render.o;
import com.tencent.mm.plugin.voip.video.render.p;
import com.tencent.mm.plugin.voip.video.render.p.e;
import com.tencent.mm.plugin.voip.widget.VoipScoreDialog;
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
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.ah;

public class NewVoipMgr
  extends com.tencent.mm.plugin.voip.a
  implements com.tencent.mm.plugin.voip.video.render.e
{
  private static int UxL = 0;
  private static int[] UxM = new int[2];
  private IListener JFB;
  private TelephonyManager JFz;
  private long JHG;
  private boolean KVp;
  private long LiJ;
  private long LiK;
  private int LiL;
  private long OTF;
  protected int PRF;
  protected com.tencent.mm.plugin.voip.f.d UwR;
  public com.tencent.mm.plugin.voip.f.l UwS;
  public com.tencent.mm.plugin.voip.video.render.j UwT;
  protected volatile com.tencent.mm.plugin.voip.ui.b UwU;
  private a UwV;
  private boolean UwW;
  private boolean UwX;
  private boolean UwY;
  private Object UwZ;
  public int UxA;
  boolean UxB;
  boolean UxC;
  private int UxD;
  public int UxE;
  public int UxF;
  private int UxG;
  private boolean UxH;
  private NetChangedBroadcastReceiver UxI;
  private PhoneStateListener UxJ;
  private MMHandler UxK;
  private long UxN;
  private boolean UxO;
  private com.tencent.mm.plugin.voip.f.b UxP;
  private boolean UxQ;
  protected com.tencent.mm.plugin.voip.f.i UxR;
  private BroadcastReceiver UxS;
  private int UxT;
  private long UxU;
  private IListener UxV;
  protected au Uxa;
  protected boolean Uxb;
  protected boolean Uxc;
  private boolean Uxd;
  private int Uxe;
  private boolean Uxf;
  protected int Uxg;
  private long Uxh;
  protected int Uxi;
  public long Uxj;
  private com.tencent.mm.plugin.voip.video.f Uxk;
  private MTimerHandler Uxl;
  private boolean Uxm;
  private boolean Uxn;
  private int Uxo;
  private boolean Uxp;
  private int Uxq;
  protected boolean Uxr;
  protected com.tencent.mm.plugin.voip.widget.b Uxs;
  private boolean Uxt;
  private boolean Uxu;
  private String Uxv;
  private boolean Uxw;
  private boolean Uxx;
  public int Uxy;
  public int Uxz;
  private long enterTime;
  protected String luk;
  private long ood;
  protected MMHandler qse;
  PhoneStateListener swG;
  private TelephonyManager wVW;
  
  public NewVoipMgr()
  {
    AppMethodBeat.i(293362);
    this.UwV = null;
    this.UwW = true;
    this.UwX = false;
    this.UwY = false;
    this.UwZ = new Object();
    this.Uxd = false;
    this.Uxe = 4096;
    this.Uxf = false;
    this.Uxg = -1;
    this.Uxh = -1L;
    this.KVp = false;
    this.Uxi = 0;
    this.Uxj = -1L;
    this.Uxk = new com.tencent.mm.plugin.voip.video.f();
    this.Uxl = null;
    this.Uxm = false;
    this.Uxn = false;
    this.Uxo = 0;
    this.Uxp = false;
    this.Uxq = -1;
    this.Uxr = false;
    this.Uxt = false;
    this.Uxu = false;
    this.Uxv = null;
    this.Uxw = true;
    this.Uxx = false;
    this.Uxy = -1;
    this.Uxz = 0;
    this.UxA = 0;
    this.LiJ = 0L;
    this.LiK = 0L;
    this.LiL = 0;
    this.UxB = false;
    this.UxC = false;
    this.UxD = 0;
    this.UxE = 0;
    this.UxF = 0;
    this.UxG = 0;
    this.UxH = false;
    this.UxK = new MMHandler("getSignalStrength");
    this.wVW = null;
    this.OTF = 0L;
    this.UxN = 0L;
    this.UxO = false;
    this.UxP = new com.tencent.mm.plugin.voip.f.b();
    this.UxQ = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.ySr, true);
    this.UxS = new BroadcastReceiver()
    {
      public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(293364);
        paramAnonymousContext = paramAnonymousIntent.getAction();
        paramAnonymousIntent = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
        boolean bool;
        if (("android.intent.action.USER_PRESENT".equals(paramAnonymousContext)) && (paramAnonymousIntent.isScreenOn()))
        {
          if (NewVoipMgr.this.UwT == null) {
            break label217;
          }
          NewVoipMgr.this.UwT.GY(false);
          NewVoipMgr.this.UwT.UTd = false;
          bool = true;
        }
        for (;;)
        {
          NewVoipMgr.this.onScreenStateChange(bool);
          AppMethodBeat.o(293364);
          return;
          if ("android.intent.action.SCREEN_ON".equals(paramAnonymousContext))
          {
            if (NewVoipMgr.this.UwT != null)
            {
              NewVoipMgr.this.UwT.GY(false);
              NewVoipMgr.this.UwT.UTd = false;
            }
            NewVoipMgr.this.UwR.onSensorEvent(true);
            bool = true;
          }
          else
          {
            if ("android.intent.action.SCREEN_OFF".equals(paramAnonymousContext))
            {
              if (NewVoipMgr.this.UwT != null)
              {
                NewVoipMgr.this.UwT.UTd = true;
                NewVoipMgr.this.UwT.GY(true);
              }
              if (!NewVoipMgr.a(NewVoipMgr.this)) {
                NewVoipMgr.this.UwR.onSensorEvent(true);
              }
              NewVoipMgr.this.hVY();
            }
            bool = false;
            continue;
            label217:
            bool = true;
          }
        }
      }
    };
    this.JFB = new IListener(com.tencent.mm.app.f.hfK) {};
    this.UxT = 0;
    this.UxU = 0L;
    this.JHG = 0L;
    this.swG = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        int i = 1;
        AppMethodBeat.i(293374);
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        Log.i("MicroMsg.Voip.NewVoipMgr", "onCallStateChanged :%d, isStartVoip: %b,oldState:%d", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(NewVoipMgr.this.Uxr), Integer.valueOf(NewVoipMgr.l(NewVoipMgr.this)) });
        if (!NewVoipMgr.this.Uxr)
        {
          AppMethodBeat.o(293374);
          return;
        }
        if (((NewVoipMgr.l(NewVoipMgr.this) == 0) && (paramAnonymousInt == 1)) || ((NewVoipMgr.l(NewVoipMgr.this) == 0) && (paramAnonymousInt == 2))) {
          NewVoipMgr.m(NewVoipMgr.this);
        }
        if (paramAnonymousInt == 1)
        {
          NewVoipMgr.a(NewVoipMgr.this, true);
          if (NewVoipMgr.l(NewVoipMgr.this) == 0) {
            NewVoipMgr.c(NewVoipMgr.this, System.currentTimeMillis());
          }
          NewVoipMgr.c(NewVoipMgr.this, 1);
          SubCoreVoip.hVp().aqo(1);
          NewVoipMgr.b(NewVoipMgr.this, true);
        }
        label601:
        do
        {
          NewVoipMgr.this.UwR.UxO = NewVoipMgr.r(NewVoipMgr.this);
          AppMethodBeat.o(293374);
          return;
          if (paramAnonymousInt == 2)
          {
            NewVoipMgr.a(NewVoipMgr.this, false);
            if (NewVoipMgr.l(NewVoipMgr.this) == 1) {
              NewVoipMgr.d(NewVoipMgr.this, System.currentTimeMillis());
            }
            NewVoipMgr.c(NewVoipMgr.this, 2);
            Log.i("MicroMsg.Voip.NewVoipMgr", "phone call coming now!");
            Object localObject1;
            if ((NewVoipMgr.this.Uxb) && (!com.tencent.mm.plugin.voip.f.k.arj(NewVoipMgr.this.UwS.mState)))
            {
              paramAnonymousString = SubCoreVoip.hVp();
              localObject1 = com.tencent.mm.plugin.voip.d.c.UGb;
              com.tencent.mm.plugin.voip.d.c.a(com.tencent.mm.plugin.voip.d.c.a.UGJ);
              paramAnonymousString = paramAnonymousString.UBE;
              Log.i("MicroMsg.Voip.VoipServiceEx", "cancelCallByPhoneInter, roomId:" + paramAnonymousString.UvO.UyU.roomId);
              if (paramAnonymousString.UvO.UyU.roomId != 0)
              {
                paramAnonymousString.UvO.UyU.UFN.UAh = 102;
                paramAnonymousString.UvO.UyU.UFN.UAt = 6;
                if (SubCoreVoip.hVp().UBF != null)
                {
                  paramAnonymousString.UvO.UyU.UFN.UAY = SubCoreVoip.hVp().UBF.hVm();
                  paramAnonymousString.UvO.UyU.UFN.LiJ = (SubCoreVoip.hVp().UBF.hVk() / 1000L);
                  paramAnonymousString.UvO.UyU.UFN.LiK = (SubCoreVoip.hVp().UBF.hVl() / 1000L);
                }
                com.tencent.mm.plugin.report.service.h.OAn.a(11521, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.roomId), Long.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.Hnt), Long.valueOf(SubCoreVoip.hVp().UBE.UvO.hWC()), Integer.valueOf(3), Long.valueOf(System.currentTimeMillis()), Long.valueOf(System.currentTimeMillis()) });
                paramAnonymousString.aqv(3);
              }
            }
            Object localObject2;
            if (com.tencent.mm.plugin.voip.f.k.arj(NewVoipMgr.this.UwS.mState))
            {
              paramAnonymousString = MMApplicationContext.getContext().getString(b.g.voip_call_msg_chat_time, new Object[] { NewVoipMgr.wR(Util.secondsToNow(NewVoipMgr.n(NewVoipMgr.this))) });
              localObject1 = SubCoreVoip.hVp();
              localObject2 = com.tencent.mm.plugin.voip.d.c.UGb;
              com.tencent.mm.plugin.voip.d.c.a(com.tencent.mm.plugin.voip.d.c.a.UGJ);
              localObject1 = ((u)localObject1).UBE;
              Log.i("MicroMsg.Voip.VoipServiceEx", "hangUpByPhoneInter");
              if (((v)localObject1).UvO.UyU.roomId != 0) {
                break label930;
              }
              ((v)localObject1).UvO.UyW.hWX();
              ((v)localObject1).reset();
              localObject2 = NewVoipMgr.this.Uxa.field_username;
              if (!NewVoipMgr.this.Uxc) {
                break label970;
              }
              localObject1 = cc.adkp;
              if (!NewVoipMgr.this.Uxb) {
                break label978;
              }
            }
            for (paramAnonymousInt = i;; paramAnonymousInt = 0)
            {
              s.b((String)localObject2, (String)localObject1, paramAnonymousInt, 6, paramAnonymousString);
              NewVoipMgr.this.By(4107);
              NewVoipMgr.o(NewVoipMgr.this);
              paramAnonymousString = new cc();
              paramAnonymousString.setType(10000);
              paramAnonymousString.setCreateTime(System.currentTimeMillis());
              paramAnonymousString.setStatus(6);
              paramAnonymousString.setContent(MMApplicationContext.getContext().getString(b.g.voip_call_interrupted_by_other_app) + ", <a href=\"weixin://voip/callagain/?username=" + NewVoipMgr.this.luk + "&isvideocall=" + NewVoipMgr.this.Uxc + "\">" + MMApplicationContext.getContext().getString(b.g.voip_call_again) + "</a>");
              if ((NewVoipMgr.this.luk != null) && (!NewVoipMgr.this.luk.equals("")))
              {
                paramAnonymousString.BS(NewVoipMgr.this.luk);
                ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().ba(paramAnonymousString);
              }
              SubCoreVoip.hVp().aqo(2);
              NewVoipMgr.b(NewVoipMgr.this, false);
              break;
              paramAnonymousString = MMApplicationContext.getContext().getString(b.g.voip_call_connection_failed);
              break label601;
              ((v)localObject1).UvO.UyU.UFN.UAh = 109;
              ((v)localObject1).UvO.UyU.UFN.UAz = 4;
              ((v)localObject1).hYO();
              break label662;
              localObject1 = cc.adko;
              break label689;
            }
          }
        } while (paramAnonymousInt != 0);
        label662:
        label689:
        label970:
        label978:
        if ((NewVoipMgr.l(NewVoipMgr.this) == 1) || (NewVoipMgr.l(NewVoipMgr.this) == 2)) {
          NewVoipMgr.d(NewVoipMgr.this, System.currentTimeMillis());
        }
        label930:
        NewVoipMgr.c(NewVoipMgr.this, 0);
        SubCoreVoip.hVp().aqo(2);
        if ((1 == NewVoipMgr.this.Uxg) && (com.tencent.mm.plugin.voip.f.k.arj(NewVoipMgr.this.UwS.mState)) && (NewVoipMgr.p(NewVoipMgr.this))) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(293318);
              NewVoipMgr.this.UwR.ee(true);
              AppMethodBeat.o(293318);
            }
          });
        }
        if ((4 == NewVoipMgr.this.Uxg) && (NewVoipMgr.p(NewVoipMgr.this))) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(293326);
              NewVoipMgr.this.UwR.bt(NewVoipMgr.q(NewVoipMgr.this), NewVoipMgr.this.Uxc);
              AppMethodBeat.o(293326);
            }
          });
        }
        NewVoipMgr.a(NewVoipMgr.this, false);
        if ((com.tencent.mm.compatible.b.g.aOf() != null) && (com.tencent.mm.plugin.audio.c.a.cTW().cTV()))
        {
          Log.i("MicroMsg.Voip.NewVoipMgr", "is bluetooth can use and start bluetooth");
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(293327);
              NewVoipMgr.this.UwR.bt(NewVoipMgr.q(NewVoipMgr.this), NewVoipMgr.this.Uxc);
              AppMethodBeat.o(293327);
            }
          });
        }
        for (;;)
        {
          NewVoipMgr.b(NewVoipMgr.this, false);
          break;
          if (com.tencent.mm.plugin.audio.c.a.cTW().cTQ()) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(293329);
                NewVoipMgr.this.UwR.bt(NewVoipMgr.q(NewVoipMgr.this), NewVoipMgr.this.Uxc);
                AppMethodBeat.o(293329);
              }
            });
          }
        }
      }
    };
    this.ood = -1L;
    this.enterTime = -1L;
    this.UxV = new IListener(com.tencent.mm.app.f.hfK) {};
    this.UwR = SubCoreVoip.hVp().UwR;
    if (this.UwR == null)
    {
      this.UwR = new com.tencent.mm.plugin.voip.f.d();
      SubCoreVoip.hVp().UwR = this.UwR;
    }
    Object localObject = com.tencent.mm.plugin.voip.d.c.UGb;
    com.tencent.mm.plugin.voip.d.c.a(Integer.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.roomId), Long.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.Hnt), this.luk);
    localObject = com.tencent.mm.plugin.voip.d.f.UGZ;
    com.tencent.mm.plugin.voip.d.f.a(Integer.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.roomId), Long.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.Hnt), this.luk);
    this.UwR.a(Integer.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.roomId), Long.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.Hnt));
    AppMethodBeat.o(293362);
  }
  
  private void apR(int paramInt)
  {
    AppMethodBeat.i(293369);
    if (paramInt == 5)
    {
      UxL += UxM[0];
      this.UxT += 1;
      Log.i("MicroMsg.Voip.NewVoipMgr", "mSignalStrength 4G" + UxM[0] + " and index is " + this.UxT);
      AppMethodBeat.o(293369);
      return;
    }
    if ((paramInt == 4) && (NetStatusUtil.isWifi(MMApplicationContext.getContext()))) {}
    try
    {
      UxM[1] = ConnectivityCompat.Companion.getWiFiRssi();
      UxL += UxM[1];
      this.UxT += 1;
      Log.i("MicroMsg.Voip.NewVoipMgr", "mSignalStrength WIFI " + UxM[1] + " and index is " + this.UxT);
      AppMethodBeat.o(293369);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        UxM[1] = 0;
        Log.i("MicroMsg.Voip.NewVoipMgr", "error happened in get wifi info");
      }
    }
  }
  
  private void apS(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(293373);
    Log.i("MicroMsg.Voip.NewVoipMgr", "hangupTalkingOrCancelInvite");
    if (true == hWe()) {
      this.Uxe = paramInt;
    }
    Object localObject = MMApplicationContext.getContext();
    String str2;
    if (com.tencent.mm.plugin.voip.f.k.arj(this.UwS.mState))
    {
      localObject = ((Context)localObject).getString(b.g.voip_call_msg_chat_time, new Object[] { iY(Util.secondsToNow(this.Uxh)) });
      str2 = this.Uxa.field_username;
      if (!this.Uxc) {
        break label245;
      }
    }
    label245:
    for (String str1 = cc.adkp;; str1 = cc.adko)
    {
      if (this.Uxb) {
        i = 1;
      }
      s.b(str2, str1, i, 6, (String)localObject);
      if ((!this.Uxb) || (com.tencent.mm.plugin.voip.f.k.arj(this.UwS.mState))) {
        break label253;
      }
      hVY();
      if ((this.Uxb) && (!com.tencent.mm.plugin.voip.f.k.arj(this.UwS.mState)))
      {
        Log.i("MicroMsg.Voip.NewVoipMgr", "hangupVoipButton OnClick call cancelCall");
        SubCoreVoip.hVp().hYn();
      }
      Log.i("MicroMsg.Voip.NewVoipMgr", "hangupVoipButton OnClick call hangUp");
      SubCoreVoip.hVp().hYp();
      if (4096 != this.Uxe) {
        break label296;
      }
      By(paramInt);
      hWb();
      AppMethodBeat.o(293373);
      return;
      if (this.Uxb)
      {
        localObject = ((Context)localObject).getString(b.g.voip_call_cancel_msg_to);
        break;
      }
      localObject = ((Context)localObject).getString(b.g.voip_call_cancel_msg_from);
      break;
    }
    label253:
    this.UwR.iba();
    this.UwX = true;
    this.UwY = true;
    SubCoreVoip.hVp().hYp();
    if (4096 == this.Uxe)
    {
      By(paramInt);
      hWb();
    }
    label296:
    AppMethodBeat.o(293373);
  }
  
  private boolean apU(int paramInt)
  {
    AppMethodBeat.i(293380);
    if (4111 == paramInt)
    {
      AppMethodBeat.o(293380);
      return true;
    }
    if ((4101 == paramInt) && ((com.tencent.mm.plugin.voip.f.k.arj(this.UwS.mState)) || (this.Uxb)))
    {
      AppMethodBeat.o(293380);
      return true;
    }
    AppMethodBeat.o(293380);
    return false;
  }
  
  private static void apV(int paramInt)
  {
    AppMethodBeat.i(293381);
    adu localadu = new adu();
    localadu.iif.hAf = paramInt;
    localadu.publish();
    AppMethodBeat.o(293381);
  }
  
  private boolean d(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(293397);
    String str = com.tencent.mm.k.i.aRC().getValue("VOIPShortcutAutoadd");
    Log.i("MicroMsg.Voip.NewVoipMgr", "voip shortcut autoAdd is %s", new Object[] { str });
    if ((str != null) && (str.equals("0")) && (Util.secondsToNow(this.Uxh) > 30L))
    {
      int i = paramSharedPreferences.getInt("voip_shortcut_prompt_times", 0);
      boolean bool = paramSharedPreferences.getBoolean("voip_shortcut_never_show_anymore", false);
      if ((i < 3) && (!bool))
      {
        hWf();
        paramSharedPreferences.edit().putInt("voip_shortcut_prompt_times", i + 1).commit();
        AppMethodBeat.o(293397);
        return true;
      }
    }
    else if ((str != null) && (str.equals("1")) && (Util.secondsToNow(this.Uxh) > 15L))
    {
      e(paramSharedPreferences);
      AppMethodBeat.o(293397);
      return false;
    }
    AppMethodBeat.o(293397);
    return false;
  }
  
  private void e(SharedPreferences paramSharedPreferences)
  {
    AppMethodBeat.i(293402);
    Intent localIntent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
    localIntent1.putExtra("duplicate", false);
    Intent localIntent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
    localIntent2.addFlags(67108864);
    if (1 == Util.getInt(com.tencent.mm.k.i.aRC().getValue("VOIPCallType"), 0))
    {
      localIntent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(b.g.app_field_voip));
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getContext(), b.c.voip_camerachat));
      localIntent1.putExtra("shortcut_icon_resource_id", b.c.voip_camerachat);
    }
    for (;;)
    {
      localIntent1.putExtra("android.intent.extra.shortcut.INTENT", localIntent2);
      com.tencent.mm.plugin.base.model.b.F(getContext(), localIntent1);
      paramSharedPreferences.edit().putBoolean("voip_shortcut_has_added", true).commit();
      AppMethodBeat.o(293402);
      return;
      localIntent2.putExtra("LauncherUI.Shortcut.LaunchType", "launch_type_voip_audio");
      localIntent1.putExtra("android.intent.extra.shortcut.NAME", getContext().getString(b.g.app_field_voipaudio));
      localIntent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(getContext(), b.c.voip_voicechat));
      localIntent1.putExtra("shortcut_icon_resource_id", b.c.voip_voicechat);
    }
  }
  
  private boolean hWa()
  {
    int j = 0;
    AppMethodBeat.i(293378);
    if (!this.UwS.aro(4101))
    {
      AppMethodBeat.o(293378);
      return false;
    }
    this.Uxc = false;
    if (this.Uxs != null) {
      this.Uxs.Uxc = false;
    }
    By(4101);
    Object localObject1;
    int k;
    int i;
    Object localObject3;
    Object localObject2;
    if ((261 == this.UwS.mState) || (7 == this.UwS.mState))
    {
      SubCoreVoip.hVp().aqh(1);
      localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
      long l = SubCoreVoip.hVp().UBE.UvO.UyU.Hnt;
      k = SubCoreVoip.hVp().UBE.UvO.UyU.roomId;
      if (this.Uxb)
      {
        i = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject1).b(11046, new Object[] { Integer.valueOf(2), Long.valueOf(l), Integer.valueOf(k), Integer.valueOf(0), Integer.valueOf(i) });
        localObject3 = com.tencent.mm.plugin.report.service.h.OAn;
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
      ((com.tencent.mm.plugin.report.service.h)localObject3).b(k, (Object[])localObject2);
      do
      {
        SubCoreVoip.hVp().UBE.UvO.hWH();
        SubCoreVoip.hVp().UBE.UvO.hWI();
        AppMethodBeat.o(293378);
        return true;
        i = 0;
        break;
      } while ((1 != this.UwS.mState) && (3 != this.UwS.mState));
      SubCoreVoip.hVp().aqh(1);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
      k = 11046;
      localObject1 = new Object[5];
      localObject1[0] = Integer.valueOf(1);
      localObject1[1] = Long.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.Hnt);
      localObject1[2] = Integer.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.roomId);
      localObject1[3] = Integer.valueOf(0);
      i = 4;
      if (this.Uxb)
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
  
  private void hWb()
  {
    AppMethodBeat.i(293384);
    Log.d("MicroMsg.Voip.NewVoipMgr", "delayFinish");
    this.Uxv = null;
    if (this.qse != null) {
      this.qse.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(293347);
          NewVoipMgr.this.hVR();
          NewVoipMgr.this.finish();
          AppMethodBeat.o(293347);
        }
      }, 500L);
    }
    AppMethodBeat.o(293384);
  }
  
  private static void hWc()
  {
    AppMethodBeat.i(293389);
    acn localacn = new acn();
    localacn.ifU.hId = 11;
    localacn.publish();
    AppMethodBeat.o(293389);
  }
  
  private void hWd()
  {
    long l2 = 0L;
    AppMethodBeat.i(293394);
    synchronized (this.UwZ)
    {
      hWl();
      Object localObject2 = com.tencent.mm.plugin.voip.d.c.UGb;
      if (this.Uxh == 0L)
      {
        l1 = 0L;
        if (this.Uxc) {
          l2 = 1L;
        }
        com.tencent.mm.plugin.voip.d.c.bC(l1, l2);
        if (this.Uxc)
        {
          localObject2 = com.tencent.mm.plugin.voip.d.f.UGZ;
          com.tencent.mm.plugin.voip.d.f.iab();
        }
        localObject2 = com.tencent.mm.plugin.voip.d.i.UHA;
        com.tencent.mm.plugin.voip.d.i.cIX();
        if (this.UwT != null) {
          this.UwT.release();
        }
        this.UwR.unInit();
        this.UwR.hWd();
        AppMethodBeat.o(293394);
        return;
      }
      long l1 = Util.secondsToNow(this.Uxh);
    }
  }
  
  private boolean hWe()
  {
    AppMethodBeat.i(293395);
    if (com.tencent.mm.plugin.voip.f.k.arj(this.UwS.mState))
    {
      SharedPreferences localSharedPreferences = getContext().getSharedPreferences("voip_plugin_prefs", 0);
      if (!localSharedPreferences.getBoolean("voip_shortcut_has_added", false))
      {
        boolean bool = d(localSharedPreferences);
        AppMethodBeat.o(293395);
        return bool;
      }
    }
    AppMethodBeat.o(293395);
    return false;
  }
  
  private void hWf()
  {
    AppMethodBeat.i(293404);
    Context localContext = getContext();
    View localView = View.inflate(localContext, b.e.mm_alert_checkbox, null);
    final CheckBox localCheckBox = (CheckBox)localView.findViewById(b.d.mm_alert_dialog_cb);
    localCheckBox.setChecked(false);
    TextView localTextView = (TextView)localView.findViewById(b.d.mm_alert_dialog_info);
    if (1 == Util.getInt(com.tencent.mm.k.i.aRC().getValue("VOIPCallType"), 0)) {
      localTextView.setText(b.g.voip_add_short_cut_tip);
    }
    for (;;)
    {
      com.tencent.mm.ui.base.k.a(localContext, false, localContext.getString(b.g.app_tip), localView, localContext.getString(b.g.app_yes), localContext.getString(b.g.app_no), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(293363);
          paramAnonymousDialogInterface = NewVoipMgr.this.getContext().getSharedPreferences("voip_plugin_prefs", 0);
          NewVoipMgr.a(NewVoipMgr.this, paramAnonymousDialogInterface);
          if (4096 != NewVoipMgr.s(NewVoipMgr.this))
          {
            NewVoipMgr.this.By(NewVoipMgr.s(NewVoipMgr.this));
            NewVoipMgr.t(NewVoipMgr.this);
          }
          if (NewVoipMgr.this.qse != null) {
            NewVoipMgr.this.qse.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(293367);
                NewVoipMgr.this.finish();
                AppMethodBeat.o(293367);
              }
            });
          }
          AppMethodBeat.o(293363);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(293408);
          if (localCheckBox != null) {
            NewVoipMgr.this.getContext().getSharedPreferences("voip_plugin_prefs", 0).edit().putBoolean("voip_shortcut_never_show_anymore", localCheckBox.isChecked()).commit();
          }
          if (4096 != NewVoipMgr.s(NewVoipMgr.this))
          {
            NewVoipMgr.this.By(NewVoipMgr.s(NewVoipMgr.this));
            NewVoipMgr.t(NewVoipMgr.this);
          }
          if (NewVoipMgr.this.qse != null) {
            NewVoipMgr.this.qse.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(293319);
                NewVoipMgr.this.finish();
                AppMethodBeat.o(293319);
              }
            });
          }
          AppMethodBeat.o(293408);
        }
      });
      AppMethodBeat.o(293404);
      return;
      localTextView.setText(b.g.voip_add_short_cut_tip_audio);
    }
  }
  
  private void hWl()
  {
    AppMethodBeat.i(293405);
    if (this.Uxk != null) {
      this.Uxk.a(this);
    }
    if (this.Uxl != null)
    {
      Log.d("MicroMsg.Voip.NewVoipMgr", "stop face detect timer");
      this.Uxl.stopTimer();
    }
    AppMethodBeat.o(293405);
  }
  
  private void hWm()
  {
    AppMethodBeat.i(293406);
    this.UwR.aM(new kotlin.g.a.b() {});
    AppMethodBeat.o(293406);
  }
  
  private void iR(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(293387);
    Log.i("MicroMsg.Voip.NewVoipMgr", "finish");
    this.UxU = 0L;
    Log.i("MicroMsg.Voip.NewVoipMgr", "finish: isStartVoip=" + this.Uxr);
    if (!this.Uxr)
    {
      SubCoreVoip.hVp().hYB();
      AppMethodBeat.o(293387);
      return;
    }
    if (this.UxR != null) {
      this.UxR.ibN();
    }
    if (this.UxP != null)
    {
      this.UxP.iaT();
      this.UxP.iaU();
    }
    this.Uxr = false;
    this.Uxt = false;
    if (this.Uxi != -1)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(11700, new Object[] { Integer.valueOf(this.Uxi), Long.valueOf(Util.secondsToNow(this.Uxh)) });
      this.Uxi = -1;
    }
    try
    {
      MMApplicationContext.getContext().unregisterReceiver(this.UxS);
      label172:
      this.UwR.ibb();
      this.JFB.dead();
      this.UxV.dead();
      hWl();
      if (this.UwT != null)
      {
        this.UwT.release();
        this.UwT = null;
      }
      if (this.UwU != null)
      {
        this.UwU.uninit();
        this.UwU = null;
        this.UwR.c(this.UwU);
      }
      if (this.Uxs != null)
      {
        this.Uxs.uninit();
        this.Uxs = null;
      }
      hVY();
      label307:
      int i;
      label344:
      Object localObject1;
      label392:
      int k;
      long l;
      if (SubCoreVoip.hVp() != null)
      {
        if (paramBoolean)
        {
          SubCoreVoip.hVp().hYq();
          if (!this.Uxc) {
            break label892;
          }
          SubCoreVoip.hVp().d(false, true, this.luk);
          SubCoreVoip.hVp().b(MMApplicationContext.getContext(), this);
        }
      }
      else
      {
        this.UwR.ged();
        if ((this.Uxh == -1L) && (!this.Uxb)) {
          break label907;
        }
        i = 1;
        SubCoreVoip.hVp().hYB();
        SubCoreVoip.hVp().aqu(this.Uxz);
        if (!this.UwX) {
          break label912;
        }
        this.UwV = new a();
        com.tencent.threadpool.h.ahAA.bm(this.UwV);
        Object localObject2;
        if ((this.JFz != null) && (this.swG != null))
        {
          localObject1 = this.JFz;
          localObject2 = this.swG;
          localObject2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
          ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(1)).intValue());
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
          this.swG = null;
        }
        this.JFz = null;
        com.tencent.mm.booter.a.aKj().aKk();
        r.hXJ().hXL();
        r.hXJ().a(null);
        ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().cancel(40);
        SubCoreVoip.hVp().hYD();
        Log.i("MicroMsg.Voip.NewVoipMgr", "finish, isFinishFromShutdown: %s", new Object[] { Boolean.valueOf(this.UwY) });
        if ((this.UwY) && (SubCoreVoip.hVp().hYE()))
        {
          SubCoreVoip.hVp();
          VoipScoreState.hYk();
          localObject2 = new Intent(getContext(), VoipScoreDialog.class);
          ((Intent)localObject2).putExtra("key_score_state", SubCoreVoip.hVp().hYG());
          if (!(getContext() instanceof Activity)) {
            ((Intent)localObject2).addFlags(268435456);
          }
          localObject1 = getContext();
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/voip/model/NewVoipMgr", "finish", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        SubCoreVoip.hVp().hYF();
        hWc();
        if (!this.UxC)
        {
          k = SubCoreVoip.hVp().UBE.UvO.UyU.roomId;
          l = SubCoreVoip.hVp().UBE.UvO.UyU.Hnt;
          if (!this.Uxb) {
            break label919;
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.voip.f.g.c(k, l, j, 4);
        this.UxC = true;
        ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().cancel(40);
        com.tencent.mm.media.g.c.nAB.bpx();
        if ((i != 0) && (this.luk != null))
        {
          localObject1 = com.tencent.mm.plugin.voip.f.c.ULf;
          com.tencent.mm.plugin.voip.f.c.aG(this.Uxb, this.luk);
        }
        AppMethodBeat.o(293387);
        return;
        SubCoreVoip.hVp().hYp();
        break;
        label892:
        SubCoreVoip.hVp().d(false, false, this.luk);
        break label307;
        label907:
        i = 0;
        break label344;
        label912:
        hWd();
        break label392;
        label919:
        j = 1;
      }
    }
    catch (Exception localException)
    {
      break label172;
    }
  }
  
  private static String iY(long paramLong)
  {
    AppMethodBeat.i(293391);
    String str = String.format("%02d:%02d", new Object[] { Long.valueOf(paramLong / 60L), Long.valueOf(paramLong % 60L) });
    AppMethodBeat.o(293391);
    return str;
  }
  
  protected void By(final int paramInt)
  {
    AppMethodBeat.i(293649);
    Log.printDebugStack("MicroMsg.Voip.NewVoipMgr", "swtchState, action: %s, currentState: %s", new Object[] { com.tencent.mm.plugin.voip.f.k.arg(paramInt), com.tencent.mm.plugin.voip.f.k.arg(this.UwS.mState) });
    Object localObject;
    if ((4101 == paramInt) && (com.tencent.mm.plugin.voip.f.k.ark(this.UwS.mState)))
    {
      hWl();
      if (this.UwT != null) {
        this.UwT.release();
      }
      this.Uxc = false;
      if (this.Uxs != null) {
        this.Uxs.Uxc = false;
      }
      localObject = SubCoreVoip.hVp();
      if (((u)localObject).UCa != null) {
        ((u)localObject).UCa.hVA();
      }
    }
    if (apU(paramInt)) {
      this.UwR.ULt = false;
    }
    if ((apU(paramInt)) && (1 == this.PRF) && (1 == this.Uxg))
    {
      this.UwR.ee(false);
      this.Uxu = true;
      if ((this.Uxu) && (this.Uxg == 2))
      {
        getContext();
        hWm();
      }
      if (!SubCoreVoip.hVp().dro())
      {
        this.UwR.hVY();
        this.UwR.o(this.luk, false, this.Uxb);
      }
      localObject = this.UwS;
      if (((com.tencent.mm.plugin.voip.f.l)localObject).aro(paramInt)) {
        break label345;
      }
      Log.e("MicroMsg.Voip.VoipStateMachine", "can't tranform due to no such rule");
      label247:
      if (this.qse != null) {
        this.qse.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(293345);
            if (NewVoipMgr.this.UwU != null) {
              NewVoipMgr.this.UwU.iU(paramInt, NewVoipMgr.this.UwS.mState);
            }
            AppMethodBeat.o(293345);
          }
        });
      }
      switch (this.UwS.mState)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(293649);
      return;
      if ((4100 != paramInt) || (SubCoreVoip.hVp().dro())) {
        break;
      }
      this.UwR.hVY();
      break;
      label345:
      int i = ((Integer)((Map)((com.tencent.mm.plugin.voip.f.l)localObject).UMd.get(Integer.valueOf(((com.tencent.mm.plugin.voip.f.l)localObject).mState))).get(Integer.valueOf(paramInt))).intValue();
      Log.d("MicroMsg.Voip.VoipStateMachine", "from oldState: %s to newState: %s, action: %s", new Object[] { com.tencent.mm.plugin.voip.f.k.arg(((com.tencent.mm.plugin.voip.f.l)localObject).mState), com.tencent.mm.plugin.voip.f.k.arg(i), com.tencent.mm.plugin.voip.f.k.arg(paramInt) });
      ((com.tencent.mm.plugin.voip.f.l)localObject).mState = i;
      break label247;
      apV(5);
      AppMethodBeat.o(293649);
      return;
      apV(6);
    }
  }
  
  public final void Gh(boolean paramBoolean)
  {
    AppMethodBeat.i(293534);
    int j = com.tencent.mm.plugin.voip.f.k.bw(false, paramBoolean);
    int i = j;
    if (this.Uxd)
    {
      if (j != 0) {
        break label80;
      }
      i = 1;
    }
    for (;;)
    {
      this.UwS = com.tencent.mm.plugin.voip.f.k.arh(i);
      Log.i("MicroMsg.Voip.NewVoipMgr", "steve:[simucall] resetStateMachine, initState:%d,isOutCall:%s,isVideoCall:%s", new Object[] { Integer.valueOf(i), Boolean.FALSE, Boolean.valueOf(paramBoolean) });
      this.Uxb = false;
      AppMethodBeat.o(293534);
      return;
      label80:
      i = j;
      if (256 == j) {
        i = 257;
      }
    }
  }
  
  public final void Gl(boolean paramBoolean)
  {
    AppMethodBeat.i(293538);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onSpeakerStateChanged, isSpeakerOn: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.UwR.ee(paramBoolean);
    this.UwR.ULx = true;
    AppMethodBeat.o(293538);
  }
  
  public final void Gm(boolean paramBoolean)
  {
    AppMethodBeat.i(293614);
    if (this.UwT != null)
    {
      com.tencent.mm.plugin.voip.video.render.j localj = this.UwT;
      localj.UIF = paramBoolean;
      localj.setHWDecMode(localj.UII);
    }
    AppMethodBeat.o(293614);
  }
  
  public final boolean Gn(final boolean paramBoolean)
  {
    AppMethodBeat.i(293715);
    if (SubCoreVoip.hVp().UBU)
    {
      Log.i("MicroMsg.Voip.NewVoipMgr", "current state is mini, cannot mini!");
      AppMethodBeat.o(293715);
      return false;
    }
    if ((this.Uxt) && (!paramBoolean))
    {
      Log.i("MicroMsg.Voip.NewVoipMgr", "has phone call  cannot mini!");
      AppMethodBeat.o(293715);
      return false;
    }
    Log.printDebugStack("MicroMsg.Voip.NewVoipMgr", "miniOnlyHidenVoip: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Log.i("MicroMsg.Voip.NewVoipMgr", "onMinimizeVoip, async to minimize");
    this.ood = Util.currentTicks();
    if (this.qse != null) {
      this.qse.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(293407);
          if (NewVoipMgr.this.Uxs != null)
          {
            NewVoipMgr.this.Uxs.uninit();
            NewVoipMgr.this.Uxs = null;
          }
          NewVoipMgr.this.vF(paramBoolean);
          AppMethodBeat.o(293407);
        }
      });
    }
    AppMethodBeat.o(293715);
    return true;
  }
  
  public final void Jd(int paramInt)
  {
    int i = 4;
    AppMethodBeat.i(293574);
    if (!((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zvd, true))
    {
      AppMethodBeat.o(293574);
      return;
    }
    if (this.UwT.UTc != null) {}
    for (boolean bool = this.UwT.UTc.icu();; bool = true)
    {
      switch (paramInt)
      {
      case 3: 
      default: 
      case 2: 
        for (;;)
        {
          SubCoreVoip.hVp().aqm(paramInt);
          AppMethodBeat.o(293574);
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
  
  public final void VQ(int paramInt)
  {
    AppMethodBeat.i(293679);
    Log.i("MicroMsg.Voip.NewVoipMgr", "remote voip mode changed, cmd:%d", new Object[] { Integer.valueOf(paramInt) });
    if (((1 == paramInt) || (3 == paramInt) || (5 == paramInt) || (6 == paramInt) || (7 == paramInt)) && (this.Uxc))
    {
      By(4101);
      SubCoreVoip.hVp().UBE.UvO.hWH();
      SubCoreVoip.hVp().UBE.UvO.hWI();
    }
    AppMethodBeat.o(293679);
  }
  
  public final void VR(int paramInt)
  {
    AppMethodBeat.i(293687);
    if (this.UwU != null) {
      this.UwU.VR(paramInt);
    }
    AppMethodBeat.o(293687);
  }
  
  public final void VS(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(293700);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onSessionBeingCalled, callType: ".concat(String.valueOf(paramInt)));
    if (!this.UwS.aro(4110))
    {
      AppMethodBeat.o(293700);
      return;
    }
    u localu = SubCoreVoip.hVp();
    if (paramInt == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramInt == 1) {
        bool2 = true;
      }
      localu.bq(bool1, bool2);
      hVY();
      if ((paramInt == 1) && (com.tencent.mm.plugin.voip.f.k.ark(this.UwS.mState))) {
        By(4101);
      }
      By(4110);
      AppMethodBeat.o(293700);
      return;
    }
  }
  
  public final void VT(int paramInt)
  {
    boolean bool2 = false;
    AppMethodBeat.i(293702);
    Log.i("MicroMsg.Voip.NewVoipMgr", "steve:[simucall]onNewSimulCallAutoAccept, callType: ".concat(String.valueOf(paramInt)));
    if (!this.UwS.aro(4100))
    {
      AppMethodBeat.o(293702);
      return;
    }
    u localu = SubCoreVoip.hVp();
    if (paramInt == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (paramInt == 1) {
        bool2 = true;
      }
      localu.bq(bool1, bool2);
      hVY();
      if ((paramInt == 1) && (com.tencent.mm.plugin.voip.f.k.ark(this.UwS.mState))) {
        By(4101);
      }
      By(4100);
      AppMethodBeat.o(293702);
      return;
    }
  }
  
  public final void VW(int paramInt)
  {
    AppMethodBeat.i(293636);
    if (this.UwU != null) {
      this.UwU.VW(paramInt);
    }
    AppMethodBeat.o(293636);
  }
  
  public final void a(final Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(293528);
    Log.i("MicroMsg.Voip.NewVoipMgr", "start VoIP, userName: %s, isOutCall: %b, isVideoCall: %b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    Object localObject1 = this.UwR;
    Object localObject2 = com.tencent.mm.plugin.audio.c.a.uVi;
    label133:
    boolean bool;
    label229:
    int j;
    if (com.tencent.mm.plugin.audio.c.a.a.cTW().cTQ())
    {
      i = 3;
      ((com.tencent.mm.plugin.voip.f.d)localObject1).Uxg = i;
      ((com.tencent.mm.plugin.voip.f.d)localObject1).OEa = paramBoolean1;
      ((com.tencent.mm.plugin.voip.f.d)localObject1).UvH = paramBoolean2;
      ((com.tencent.mm.plugin.voip.f.d)localObject1).ULt = paramBoolean2;
      if ((!com.tencent.mm.plugin.ringtone.c.gOg()) || (paramBoolean1))
      {
        localObject1 = this.UwR;
        localObject2 = com.tencent.mm.plugin.audio.c.a.uVi;
        localObject2 = com.tencent.mm.plugin.audio.d.b.uVo;
        if (!com.tencent.mm.plugin.audio.d.b.cUa()) {
          break label669;
        }
        ((com.tencent.mm.plugin.voip.f.d)localObject1).b("voip", Integer.valueOf(4));
      }
      this.Uxr = true;
      this.luk = paramString;
      this.Uxb = paramBoolean1;
      this.Uxc = paramBoolean2;
      this.Uxa = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(this.luk);
      this.qse = new MMHandler(Looper.getMainLooper());
      this.Uxy = 0;
      this.Uxz = 0;
      this.UxA = 0;
      if (Util.getInt(com.tencent.mm.k.i.aRC().getValue("VOIPCameraSwitch"), 1) != 0) {
        break label715;
      }
      bool = true;
      this.Uxd = bool;
      if (!this.Uxc) {
        this.Uxd = false;
      }
      j = com.tencent.mm.plugin.voip.f.k.bw(paramBoolean1, paramBoolean2);
      i = j;
      if (this.Uxd)
      {
        if (j != 0) {
          break label721;
        }
        i = 1;
        label274:
        SubCoreVoip.hVp().aqh(1);
      }
      if (!paramBoolean1) {
        break label741;
      }
      this.UwS = com.tencent.mm.plugin.voip.f.k.ari(i);
      label294:
      this.UwR.UwS = this.UwS;
      paramBoolean1 = com.tencent.mm.compatible.e.b.aPO();
      paramBoolean2 = com.tencent.mm.compatible.e.b.aPP();
      if (Build.MANUFACTURER.equalsIgnoreCase("meizu"))
      {
        if (!paramBoolean1)
        {
          localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
          if (!this.Uxc) {
            break label753;
          }
          i = 0;
          label345:
          ((com.tencent.mm.plugin.report.service.h)localObject1).b(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(1) });
        }
        if (!paramBoolean2)
        {
          localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
          if (!this.Uxc) {
            break label759;
          }
          i = 0;
          label392:
          ((com.tencent.mm.plugin.report.service.h)localObject1).b(11306, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
        }
      }
      if ((!paramBoolean2) || (!paramBoolean1))
      {
        localObject1 = null;
        localObject2 = null;
        if ((paramBoolean1) || (paramBoolean2)) {
          break label765;
        }
        localObject1 = paramContext.getString(b.g.voip_special_no_audio_camera_permission);
        localObject2 = paramContext.getString(b.g.voip_need_audio_and_camera_title);
        label461:
        com.tencent.mm.ui.base.k.a(paramContext, (String)localObject1, (String)localObject2, paramContext.getString(b.g.voip_need_show_settings_button), true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(293350);
            Log.i("MicroMsg.Voip.NewVoipMgr", "show Permission settings");
            com.tencent.mm.compatible.e.b.dg(paramContext);
            if (!NewVoipMgr.this.Uxb)
            {
              if (NewVoipMgr.this.Uxc)
              {
                NewVoipMgr.this.hVJ();
                AppMethodBeat.o(293350);
                return;
              }
              NewVoipMgr.this.hVL();
              AppMethodBeat.o(293350);
              return;
            }
            if (NewVoipMgr.this.Uxc)
            {
              NewVoipMgr.this.hVN();
              AppMethodBeat.o(293350);
              return;
            }
            NewVoipMgr.this.hVO();
            AppMethodBeat.o(293350);
          }
        });
      }
      Log.i("MicroMsg.Voip.NewVoipMgr", "initMgr");
      com.tencent.mm.booter.a.aKj().aKl();
      if (this.UxQ) {
        SubCoreVoip.hVp().ggh();
      }
      if (!this.Uxc) {
        break label816;
      }
      SubCoreVoip.hVp().d(true, true, this.luk);
      label534:
      if (!this.Uxb) {
        break label859;
      }
      SubCoreVoip.hVp().UBE.hYN();
      if (!this.Uxc) {
        break label831;
      }
      paramContext = SubCoreVoip.hVp();
      localObject1 = this.Uxa.field_username;
    }
    for (int i = paramContext.UBE.hy((String)localObject1, 0);; i = paramContext.UBE.hy((String)localObject1, 1))
    {
      if (i >= 0) {
        break label859;
      }
      finish();
      i = 0;
      if (i != 0) {
        SubCoreVoip.hVp().e(paramString, this.Uxc, paramLong);
      }
      AppMethodBeat.o(293528);
      return;
      localObject2 = com.tencent.mm.plugin.audio.c.a.uVi;
      localObject2 = com.tencent.mm.plugin.audio.d.b.uVo;
      if (com.tencent.mm.plugin.audio.d.b.cUa())
      {
        localObject2 = com.tencent.mm.plugin.audio.c.a.uVi;
        if (com.tencent.mm.plugin.audio.c.a.a.cTY())
        {
          i = 4;
          break;
        }
      }
      if (paramBoolean2)
      {
        i = 1;
        break;
      }
      i = 2;
      break;
      label669:
      localObject2 = com.tencent.mm.plugin.audio.c.a.uVi;
      if (com.tencent.mm.plugin.audio.c.a.a.cTW().cTQ())
      {
        ((com.tencent.mm.plugin.voip.f.d)localObject1).b("voip", Integer.valueOf(3));
        break label133;
      }
      ((com.tencent.mm.plugin.voip.f.d)localObject1).b("voip", Integer.valueOf(2));
      break label133;
      label715:
      bool = false;
      break label229;
      label721:
      i = j;
      if (256 != j) {
        break label274;
      }
      i = 257;
      break label274;
      label741:
      this.UwS = com.tencent.mm.plugin.voip.f.k.arh(i);
      break label294;
      label753:
      i = 1;
      break label345;
      label759:
      i = 1;
      break label392;
      label765:
      if (!paramBoolean1)
      {
        localObject1 = paramContext.getString(b.g.voip_special_no_record_audio_permission);
        localObject2 = paramContext.getString(b.g.voip_need_audio_title);
        break label461;
      }
      if (paramBoolean2) {
        break label461;
      }
      localObject1 = paramContext.getString(b.g.voip_special_no_open_camera_permission);
      localObject2 = paramContext.getString(b.g.voip_need_camera_title);
      break label461;
      label816:
      SubCoreVoip.hVp().d(true, false, this.luk);
      break label534;
      label831:
      paramContext = SubCoreVoip.hVp();
      localObject1 = this.Uxa.field_username;
    }
    label859:
    SubCoreVoip.hVp().a(MMApplicationContext.getContext(), this);
    this.JFz = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
    paramContext = this.JFz;
    localObject1 = this.swG;
    localObject1 = com.tencent.mm.hellhoundlib.b.c.a(32, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject1);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/voip/model/NewVoipMgr", "initMgr", "()Z", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    paramContext.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/voip/model/NewVoipMgr", "initMgr", "()Z", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    paramContext = "voip_recent_contact" + z.bAM();
    localObject1 = MMApplicationContext.getContext().getSharedPreferences("voip_plugin_prefs", 0);
    localObject2 = ((SharedPreferences)localObject1).getString(paramContext, null);
    if (localObject2 != null)
    {
      localObject2 = Util.stringsToList(((String)localObject2).split(";"));
      if (localObject2 != null)
      {
        i = ((List)localObject2).size();
        if (((List)localObject2).contains(this.luk))
        {
          if (i > 1)
          {
            ((List)localObject2).remove(this.luk);
            label1096:
            ((List)localObject2).add(0, this.luk);
          }
          localObject2 = Util.listToString((List)localObject2, ";");
          ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
        }
      }
    }
    for (;;)
    {
      this.UxV.alive();
      this.JFB.alive();
      paramContext = this.Uxk;
      if (!paramContext.mCallbackList.contains(this)) {
        paramContext.mCallbackList.add(this);
      }
      paramContext = new IntentFilter();
      paramContext.addAction("android.intent.action.SCREEN_ON");
      paramContext.addAction("android.intent.action.SCREEN_OFF");
      paramContext.addAction("android.intent.action.USER_PRESENT");
      MMApplicationContext.getContext().registerReceiver(this.UxS, paramContext);
      if (this.Uxc) {
        fwa();
      }
      this.UxP.iaT();
      this.UxP.dpF();
      i = 1;
      break;
      if (4 != i) {
        break label1096;
      }
      ((List)localObject2).remove(i - 1);
      break label1096;
      localObject2 = new ArrayList();
      ((List)localObject2).add(0, this.luk);
      localObject2 = Util.listToString((List)localObject2, ";");
      ((SharedPreferences)localObject1).edit().putString(paramContext, (String)localObject2).commit();
    }
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    AppMethodBeat.i(293587);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onVoipUIDestroy");
    if (this.UwU == paramb)
    {
      Log.d("MicroMsg.Voip.NewVoipMgr", "same VoipUI, clear it");
      this.UwU = null;
      this.UwR.c(null);
    }
    if (this.qse != null) {
      this.qse = null;
    }
    AppMethodBeat.o(293587);
  }
  
  public final void a(com.tencent.mm.plugin.voip.ui.b paramb, int paramInt)
  {
    AppMethodBeat.i(293558);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onVoipUICreated, uiType: %s,  mVoicePlayDevice: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.Uxg) });
    ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().cancel(40);
    if (1 == paramInt)
    {
      if (this.UwU != null) {
        this.UwU.uninit();
      }
      if (this.UwT != null) {
        this.UwT.ids();
      }
    }
    this.UwU = paramb;
    this.PRF = paramInt;
    this.UwR.c(this.UwU);
    this.UwU.iU(-1, this.UwS.mState);
    this.UwU.setConnectSec(this.Uxh);
    this.UwU.VY(this.Uxz);
    this.UwU.VY(this.UxA);
    if ((this.UwU instanceof Activity)) {
      switch (((WindowManager)((Activity)this.UwU).getSystemService("window")).getDefaultDisplay().getRotation())
      {
      default: 
        paramInt = 0;
      }
    }
    for (;;)
    {
      if (this.UwT != null) {
        this.UwT.qpM = paramInt;
      }
      AppMethodBeat.o(293558);
      return;
      paramInt = 0;
      continue;
      paramInt = 180;
      continue;
      paramInt = 90;
      continue;
      paramInt = 270;
    }
  }
  
  public final void a(VoIPRenderSurfaceView paramVoIPRenderSurfaceView)
  {
    AppMethodBeat.i(293606);
    if (this.UwT != null)
    {
      com.tencent.mm.plugin.voip.video.render.j localj = this.UwT;
      if (paramVoIPRenderSurfaceView != null) {
        paramVoIPRenderSurfaceView.idy();
      }
      localj.UTw = false;
      localj.UTk = false;
    }
    AppMethodBeat.o(293606);
  }
  
  public final void a(VoIPRenderSurfaceView paramVoIPRenderSurfaceView, int paramInt)
  {
    AppMethodBeat.i(293605);
    if (this.UwT != null)
    {
      com.tencent.mm.plugin.voip.f.i.are(0);
      Object localObject = this.UwT;
      kotlin.g.b.s.u(paramVoIPRenderSurfaceView, "view");
      if (!((com.tencent.mm.plugin.voip.video.render.j)localObject).UTw)
      {
        ((com.tencent.mm.plugin.voip.video.render.j)localObject).UTw = true;
        o localo = ((com.tencent.mm.plugin.voip.video.render.j)localObject).UTl;
        if (localo != null) {
          localo.bZ((kotlin.g.a.a)new j.h((com.tencent.mm.plugin.voip.video.render.j)localObject));
        }
      }
      localObject = (j.b)new j.i((com.tencent.mm.plugin.voip.video.render.j)localObject);
      kotlin.g.b.s.u(localObject, "listener");
      Log.i(paramVoIPRenderSurfaceView.TAG, "addRenderEventListener");
      paramVoIPRenderSurfaceView.UTQ = ((j.b)localObject);
      paramVoIPRenderSurfaceView.UTR = paramInt;
      paramVoIPRenderSurfaceView.getHolder().addCallback((SurfaceHolder.Callback)paramVoIPRenderSurfaceView.UTP);
    }
    AppMethodBeat.o(293605);
  }
  
  public final void a(VoIPRenderTextureView paramVoIPRenderTextureView)
  {
    AppMethodBeat.i(293609);
    if (this.UwT != null)
    {
      com.tencent.mm.plugin.voip.video.render.j localj = this.UwT;
      if (paramVoIPRenderTextureView != null) {
        paramVoIPRenderTextureView.idB();
      }
      localj.UTw = false;
      localj.UTk = false;
    }
    AppMethodBeat.o(293609);
  }
  
  public final void a(VoIPRenderTextureView paramVoIPRenderTextureView, int paramInt)
  {
    AppMethodBeat.i(293598);
    if (this.UwT != null)
    {
      com.tencent.mm.plugin.voip.f.i.are(1);
      Object localObject = this.UwT;
      kotlin.g.b.s.u(paramVoIPRenderTextureView, "view");
      if (!((com.tencent.mm.plugin.voip.video.render.j)localObject).UTw)
      {
        ((com.tencent.mm.plugin.voip.video.render.j)localObject).UTw = true;
        o localo = ((com.tencent.mm.plugin.voip.video.render.j)localObject).UTl;
        if (localo != null) {
          localo.bZ((kotlin.g.a.a)new j.f((com.tencent.mm.plugin.voip.video.render.j)localObject));
        }
      }
      localObject = (j.b)new j.g((com.tencent.mm.plugin.voip.video.render.j)localObject);
      kotlin.g.b.s.u(localObject, "listener");
      paramVoIPRenderTextureView.UTV = ((j.b)localObject);
      paramVoIPRenderTextureView.UTR = paramInt;
      paramVoIPRenderTextureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new VoIPRenderTextureView.b(paramVoIPRenderTextureView));
    }
    AppMethodBeat.o(293598);
  }
  
  public final void a(byte[] paramArrayOfByte, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public final void a(final int[] paramArrayOfInt, final boolean paramBoolean, final int paramInt)
  {
    AppMethodBeat.i(293729);
    if ((this.UwT != null) && (!this.UwT.UTj))
    {
      this.UwT.idu();
      this.UwT.UTj = true;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(293355);
        Object localObject;
        if (NewVoipMgr.this.UwT != null)
        {
          localObject = NewVoipMgr.this.UwT.UTc;
          if (localObject != null) {
            ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject).icB();
          }
        }
        if (NewVoipMgr.this.UwU != null) {
          localObject = NewVoipMgr.this.UwU;
        }
        AppMethodBeat.o(293355);
      }
    });
    AppMethodBeat.o(293729);
  }
  
  public final void aDH(String paramString)
  {
    AppMethodBeat.i(293651);
    if (this.UwU != null)
    {
      this.Uxv = paramString;
      this.UwU.aDJ(paramString);
    }
    AppMethodBeat.o(293651);
  }
  
  public final void aF(boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(293629);
    long l = System.currentTimeMillis();
    if ((Build.VERSION.SDK_INT < 29) || (AppForegroundDelegate.heY.eLx))
    {
      Bundle localBundle;
      if (this.UxU > 0L)
      {
        l -= this.UxU;
        Log.i("MicroMsg.Voip.NewVoipMgr", "startVoipRing, isVideoCall:" + paramBoolean + " isOutCall:false toUser:" + paramString + " seekStartMs:" + l);
        localBundle = new Bundle();
        if (!paramBoolean) {
          break label206;
        }
      }
      label206:
      for (int i = 0;; i = 1)
      {
        localBundle.putInt("isVideoCall", i);
        localBundle.putString("username", paramString);
        localBundle.putBoolean("isOutCall", false);
        localBundle.putString("scene", "start");
        localBundle.putLong("seekStartMs", l);
        paramBoolean = ((com.tencent.mm.plugin.ringtone.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ringtone.a.class)).responseSence(com.tencent.mm.plugin.ringtone.a.a.OBd, localBundle);
        if (this.UwR != null) {
          this.UwR.ULz = paramBoolean;
        }
        this.UxU = 0L;
        AppMethodBeat.o(293629);
        return;
        l = 0L;
        break;
      }
    }
    Log.i("MicroMsg.Voip.NewVoipMgr", "start channel ring, now:".concat(String.valueOf(l)));
    this.UxU = l;
    AppMethodBeat.o(293629);
  }
  
  public final void aH(long paramLong, int paramInt)
  {
    int k = 1;
    AppMethodBeat.i(293580);
    Object localObject1;
    int i;
    label60:
    Object localObject2;
    int j;
    if (this.UxR != null) {
      switch (paramInt)
      {
      default: 
        if (this.UwT != null)
        {
          localObject1 = this.UxR;
          if (1 != this.PRF) {
            break label371;
          }
          i = 1;
          localObject2 = this.UwT.UTl;
          if ((localObject2 == null) || (((o)localObject2).idG() != 0)) {
            break label377;
          }
          j = 1;
          label85:
          if (j != 0) {
            break label383;
          }
          j = k;
          label94:
          switch (paramInt)
          {
          }
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(293580);
      return;
      if (1 == this.PRF)
      {
        if (!SubCoreVoip.hVp().UBT)
        {
          localObject1 = this.UxR;
          if ((260 != this.UwS.mState) && (6 != this.UwS.mState)) {}
          for (bool = true;; bool = false)
          {
            ((com.tencent.mm.plugin.voip.f.i)localObject1).bu(true, bool);
            SubCoreVoip.hVp().UBT = true;
            break;
          }
        }
        localObject1 = this.UxR;
        if ((260 != this.UwS.mState) && (6 != this.UwS.mState)) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.voip.f.i)localObject1).bv(true, bool);
          break;
        }
      }
      if (!SubCoreVoip.hVp().UBS)
      {
        localObject1 = this.UxR;
        if ((260 != this.UwS.mState) && (6 != this.UwS.mState)) {}
        for (bool = true;; bool = false)
        {
          ((com.tencent.mm.plugin.voip.f.i)localObject1).bu(false, bool);
          SubCoreVoip.hVp().UBS = true;
          break;
        }
      }
      localObject1 = this.UxR;
      if ((260 != this.UwS.mState) && (6 != this.UwS.mState)) {}
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.plugin.voip.f.i)localObject1).bv(false, bool);
        break;
      }
      label371:
      i = 0;
      break label60;
      label377:
      j = 0;
      break label85;
      label383:
      j = 0;
      break label94;
      ((com.tencent.mm.plugin.voip.f.i)localObject1).ULY += 1;
      if (((com.tencent.mm.plugin.voip.f.i)localObject1).ULY == 0)
      {
        if (i != 0)
        {
          if (paramLong > 0L)
          {
            localObject1 = com.tencent.mm.plugin.voip.f.j.UMb;
            com.tencent.mm.plugin.voip.f.j.xg(paramLong);
            AppMethodBeat.o(293580);
          }
        }
        else if (paramLong > 0L)
        {
          localObject1 = com.tencent.mm.plugin.voip.f.j.UMb;
          com.tencent.mm.plugin.voip.f.j.xh(paramLong);
          AppMethodBeat.o(293580);
        }
      }
      else if (((com.tencent.mm.plugin.voip.f.i)localObject1).ULY == 60) {
        ((com.tencent.mm.plugin.voip.f.i)localObject1).ULY = -1;
      }
      AppMethodBeat.o(293580);
      return;
      ((com.tencent.mm.plugin.voip.f.i)localObject1).ULZ += 1;
      if (((com.tencent.mm.plugin.voip.f.i)localObject1).ULZ == 0)
      {
        if (i != 0)
        {
          if (j != 0)
          {
            localObject1 = com.tencent.mm.plugin.voip.f.j.UMb;
            com.tencent.mm.plugin.voip.f.j.xm(paramLong);
            AppMethodBeat.o(293580);
            return;
          }
          localObject1 = com.tencent.mm.plugin.voip.f.j.UMb;
          com.tencent.mm.plugin.voip.f.j.xk(paramLong);
          AppMethodBeat.o(293580);
          return;
        }
        if (j != 0)
        {
          localObject1 = com.tencent.mm.plugin.voip.f.j.UMb;
          com.tencent.mm.plugin.voip.f.j.xn(paramLong);
          AppMethodBeat.o(293580);
          return;
        }
        localObject1 = com.tencent.mm.plugin.voip.f.j.UMb;
        com.tencent.mm.plugin.voip.f.j.xl(paramLong);
        AppMethodBeat.o(293580);
        return;
      }
      if (((com.tencent.mm.plugin.voip.f.i)localObject1).ULZ == 60) {
        ((com.tencent.mm.plugin.voip.f.i)localObject1).ULZ = -1;
      }
      AppMethodBeat.o(293580);
      return;
      ((com.tencent.mm.plugin.voip.f.i)localObject1).UMa += 1;
      if (((com.tencent.mm.plugin.voip.f.i)localObject1).UMa == 0)
      {
        if (i != 0)
        {
          localObject2 = com.tencent.mm.plugin.voip.f.j.UMb;
          com.tencent.mm.plugin.voip.f.j.xi(paramLong);
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.voip.f.i)localObject1).ULY = 0;
          AppMethodBeat.o(293580);
          return;
          localObject2 = com.tencent.mm.plugin.voip.f.j.UMb;
          com.tencent.mm.plugin.voip.f.j.xj(paramLong);
        }
      }
      if (((com.tencent.mm.plugin.voip.f.i)localObject1).UMa == 60) {
        ((com.tencent.mm.plugin.voip.f.i)localObject1).UMa = -1;
      }
    }
  }
  
  public final boolean aL(kotlin.g.a.b<Boolean, ah> paramb)
  {
    AppMethodBeat.i(293593);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onSwitchCamera");
    if (this.UwT != null)
    {
      com.tencent.mm.plugin.voip.video.render.j localj = this.UwT;
      Log.i("MicroMsg.VoIPRenderMgr", "onSwitchCamera");
      if (localj.UTc != null)
      {
        Object localObject = localj.UTl;
        if (localObject != null)
        {
          paramb = (kotlin.g.a.b)new j.n(localj, paramb);
          localObject = ((o)localObject).UUs;
          if (localObject != null) {
            ((com.tencent.mm.plugin.voip.video.render.h)localObject).K((kotlin.g.a.a)new h.l((com.tencent.mm.plugin.voip.video.render.h)localObject, paramb));
          }
        }
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(11079, new Object[] { Integer.valueOf(1) });
    }
    AppMethodBeat.o(293593);
    return true;
  }
  
  public final void apT(int paramInt)
  {
    AppMethodBeat.i(293617);
    if (this.UwT != null)
    {
      this.UwT.onOrientationChange(paramInt);
      if (this.Uxq != paramInt)
      {
        this.Uxq = paramInt;
        this.UwT.aru(paramInt);
      }
    }
    AppMethodBeat.o(293617);
  }
  
  public void b(Size paramSize, int paramInt) {}
  
  public final void b(com.tencent.mm.plugin.voip.ui.b paramb)
  {
    AppMethodBeat.i(293720);
    this.Uxi += 1;
    if (this.UwU != null)
    {
      this.UwU.aq(false, true);
      this.UwU = null;
      this.UwR.c(this.UwU);
    }
    a(paramb, 2);
    hVY();
    AppMethodBeat.o(293720);
  }
  
  public final void bh(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(293565);
    if (this.UwU != null) {
      this.UwU.VV(paramInt1);
    }
    if (this.Uxk != null)
    {
      com.tencent.mm.plugin.voip.video.f localf = this.Uxk;
      localf.UOb = paramInt3;
      localf.UOa = paramInt2;
    }
    AppMethodBeat.o(293565);
  }
  
  public final void bn(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(293604);
    if (this.UxR != null)
    {
      com.tencent.mm.plugin.voip.f.i locali = this.UxR;
      long l = Util.currentTicks();
      if (paramBoolean1)
      {
        if (paramBoolean2)
        {
          locali.ULW = l;
          AppMethodBeat.o(293604);
          return;
        }
        locali.ULU = l;
        AppMethodBeat.o(293604);
        return;
      }
      if (paramBoolean2)
      {
        locali.ULX = l;
        AppMethodBeat.o(293604);
        return;
      }
      locali.ULV = l;
    }
    AppMethodBeat.o(293604);
  }
  
  public final void c(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(293685);
    if (this.UwT != null)
    {
      Object localObject = this.UwT;
      kotlin.g.b.s.u(paramArrayOfByte, "outData");
      com.tencent.mm.plugin.voip.d.g localg = com.tencent.mm.plugin.voip.d.g.UHs;
      com.tencent.mm.plugin.voip.d.g.iae();
      localObject = ((com.tencent.mm.plugin.voip.video.render.j)localObject).UTl;
      if (localObject != null)
      {
        int i = OpenGlRender.FLAG_YV12Edge;
        int j = OpenGlRender.FLAG_Angle90;
        kotlin.g.b.s.u(paramArrayOfByte, "pBuff");
        localObject = ((o)localObject).UUu;
        if (localObject != null)
        {
          kotlin.g.b.s.u(paramArrayOfByte, "pBuff");
          ((p)localObject).K((kotlin.g.a.a)new p.e((p)localObject, paramInt1, paramInt2, paramArrayOfByte, i + j));
        }
      }
      if (this.UwU != null) {
        this.UwU.fwq();
      }
    }
    AppMethodBeat.o(293685);
  }
  
  public final void dre() {}
  
  public final void fQN()
  {
    long l = 0L;
    AppMethodBeat.i(293709);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onNetWorkChangeMobileNet");
    if (this.UwU != null) {
      this.UwU.fwv();
    }
    com.tencent.mm.plugin.voip.d.c localc = com.tencent.mm.plugin.voip.d.c.UGb;
    if (SubCoreVoip.hVp().Uxh == 0L) {}
    for (;;)
    {
      com.tencent.mm.plugin.voip.d.c.t(Long.valueOf(l));
      AppMethodBeat.o(293709);
      return;
      l = Util.secondsToNow(SubCoreVoip.hVp().Uxh);
    }
  }
  
  public final void fQO()
  {
    AppMethodBeat.i(293712);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onResumeGoodNetStatus");
    if (this.UwU != null) {
      this.UwU.fww();
    }
    AppMethodBeat.o(293712);
  }
  
  protected void finish()
  {
    AppMethodBeat.i(293660);
    iR(false);
    AppMethodBeat.o(293660);
  }
  
  public void fvW()
  {
    AppMethodBeat.i(293658);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onReject");
    By(4099);
    String str2 = this.Uxa.field_username;
    String str1;
    if (this.Uxc)
    {
      str1 = cc.adkp;
      if (!this.Uxb) {
        break label86;
      }
    }
    label86:
    for (int i = 1;; i = 0)
    {
      s.b(str2, str1, i, 6, MMApplicationContext.getContext().getString(b.g.voip_callout_reject_msg));
      hWb();
      AppMethodBeat.o(293658);
      return;
      str1 = cc.adko;
      break;
    }
  }
  
  protected com.tencent.mm.plugin.voip.video.render.j fwa()
  {
    AppMethodBeat.i(293535);
    this.UwT = new com.tencent.mm.plugin.voip.video.render.j(this, this.Uxb);
    this.UxR = new com.tencent.mm.plugin.voip.f.i();
    com.tencent.mm.plugin.voip.video.render.j localj = this.UwT;
    AppMethodBeat.o(293535);
    return localj;
  }
  
  public void fwc()
  {
    AppMethodBeat.i(293584);
    if (this.UwT != null) {
      this.UwT.idv();
    }
    AppMethodBeat.o(293584);
  }
  
  public void fwd()
  {
    AppMethodBeat.i(293647);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onRoomReady");
    if ((this.Uxf) && (SubCoreVoip.hVp().UBE.UvO.UyU.roomId != 0))
    {
      this.Uxf = false;
      hWa();
    }
    if (this.Uxb) {
      By(4097);
    }
    Object localObject = com.tencent.mm.plugin.voip.d.c.UGb;
    com.tencent.mm.plugin.voip.d.c.a(Integer.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.roomId), Long.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.Hnt), this.luk);
    localObject = com.tencent.mm.plugin.voip.d.f.UGZ;
    com.tencent.mm.plugin.voip.d.f.a(Integer.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.roomId), Long.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.Hnt), this.luk);
    localObject = com.tencent.mm.plugin.voip.d.i.UHA;
    com.tencent.mm.plugin.voip.d.i.bi(SubCoreVoip.hVp().UBE.UvO.UyU.roomId, SubCoreVoip.hVp().UBE.UvO.UyU.Hnt);
    this.UwR.a(Integer.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.roomId), Long.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.Hnt));
    AppMethodBeat.o(293647);
  }
  
  public final void fwi()
  {
    AppMethodBeat.i(293643);
    if (this.UwU != null) {
      this.UwU.fwi();
    }
    AppMethodBeat.o(293643);
  }
  
  public final void fwj()
  {
    AppMethodBeat.i(293657);
    Log.i("MicroMsg.Voip.NewVoipMgr", "on accept");
    hVY();
    By(4100);
    AppMethodBeat.o(293657);
  }
  
  public final void fwk()
  {
    AppMethodBeat.i(293664);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onNoResp");
    By(4105);
    String str2 = this.Uxa.field_username;
    String str1;
    if (this.Uxc)
    {
      str1 = cc.adkp;
      if (!this.Uxb) {
        break label181;
      }
    }
    label181:
    for (int i = 1;; i = 0)
    {
      s.b(str2, str1, i, 4, MMApplicationContext.getContext().getString(b.g.voip_callout_no_resp));
      com.tencent.mm.plugin.report.service.h.OAn.a(11518, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.roomId), Long.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.Hnt), Long.valueOf(SubCoreVoip.hVp().UBE.UvO.hWC()), Integer.valueOf(6), Integer.valueOf(NetStatusUtil.getNetWorkType(getContext())) });
      hWb();
      AppMethodBeat.o(293664);
      return;
      str1 = cc.adko;
      break;
    }
  }
  
  public final void fwl()
  {
    int j = 0;
    AppMethodBeat.i(293673);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
    int k = SubCoreVoip.hVp().UBE.UvO.UyU.roomId;
    long l1 = SubCoreVoip.hVp().UBE.UvO.UyU.Hnt;
    long l2 = SubCoreVoip.hVp().UBE.UvO.hWC();
    if (this.Uxb)
    {
      i = 0;
      localh.a(11522, true, true, new Object[] { Integer.valueOf(k), Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), Integer.valueOf(1) });
      k = SubCoreVoip.hVp().UBE.UvO.UyU.roomId;
      l1 = SubCoreVoip.hVp().UBE.UvO.UyU.Hnt;
      if (!this.Uxb) {
        break label198;
      }
    }
    label198:
    for (int i = j;; i = 1)
    {
      com.tencent.mm.plugin.voip.f.g.c(k, l1, i, 3);
      this.UxK.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(293359);
          NewVoipMgr.a(NewVoipMgr.this, NewVoipMgr.c(NewVoipMgr.this));
          NewVoipMgr.i(NewVoipMgr.this).postDelayed(this, 5000L);
          AppMethodBeat.o(293359);
        }
      });
      AppMethodBeat.o(293673);
      return;
      i = 1;
      break;
    }
  }
  
  public final void fwm()
  {
    AppMethodBeat.i(293704);
    Log.d("MicroMsg.Voip.NewVoipMgr", "onPretreatmentForStartDev");
    this.UwR.bt(this.Uxu, this.Uxc);
    AppMethodBeat.o(293704);
  }
  
  public final long fwn()
  {
    AppMethodBeat.i(293705);
    long l = this.UwR.ULq;
    Log.printInfoStack("MicroMsg.Voip.NewVoipMgr", "totalDeviceNearTime: %s", new Object[] { Long.valueOf(l) });
    l /= 1000L;
    AppMethodBeat.o(293705);
    return l;
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(293711);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onNetWorkCostMax");
    if (this.UwU != null) {
      this.UwU.fwx();
    }
    AppMethodBeat.o(293711);
  }
  
  public final void gG(int paramInt1, int paramInt2) {}
  
  public final Context getContext()
  {
    AppMethodBeat.i(293713);
    Context localContext1 = null;
    if (this.UwU != null) {
      localContext1 = this.UwU.fwr();
    }
    Context localContext2 = localContext1;
    if (localContext1 == null) {
      localContext2 = MMApplicationContext.getContext();
    }
    AppMethodBeat.o(293713);
    return localContext2;
  }
  
  public final int getState()
  {
    if (this.UwS == null) {
      return -1;
    }
    return this.UwS.mState;
  }
  
  public final String getUserName()
  {
    return this.luk;
  }
  
  public final boolean hVH()
  {
    AppMethodBeat.i(293541);
    if (!this.UwS.aro(4103))
    {
      AppMethodBeat.o(293541);
      return false;
    }
    apS(4103);
    SubCoreVoip.hVp().hYD();
    AppMethodBeat.o(293541);
    return true;
  }
  
  public final boolean hVI()
  {
    AppMethodBeat.i(293543);
    if (!this.UwS.aro(4101))
    {
      AppMethodBeat.o(293543);
      return false;
    }
    hVY();
    SubCoreVoip.hVp().aqh(1);
    SubCoreVoip.hVp().bq(true, this.Uxc);
    com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
    long l = SubCoreVoip.hVp().UBE.UvO.UyU.Hnt;
    int j = SubCoreVoip.hVp().UBE.UvO.UyU.roomId;
    if (this.Uxb) {}
    for (int i = 1;; i = 0)
    {
      localh.b(11046, new Object[] { Integer.valueOf(1), Long.valueOf(l), Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(i) });
      com.tencent.mm.plugin.report.service.h.OAn.b(11080, new Object[] { Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0) });
      By(4111);
      By(4101);
      By(4100);
      AppMethodBeat.o(293543);
      return true;
    }
  }
  
  public final boolean hVJ()
  {
    int i = 0;
    AppMethodBeat.i(293545);
    if (!this.UwS.aro(4099))
    {
      AppMethodBeat.o(293545);
      return false;
    }
    String str2 = this.Uxa.field_username;
    if (this.Uxc) {}
    for (String str1 = cc.adkp;; str1 = cc.adko)
    {
      if (this.Uxb) {
        i = 1;
      }
      s.b(str2, str1, i, 6, MMApplicationContext.getContext().getString(b.g.voip_callfrom_reject_msg));
      hVY();
      SubCoreVoip.hVp().hYo();
      By(4099);
      hWb();
      AppMethodBeat.o(293545);
      return true;
    }
  }
  
  public final boolean hVK()
  {
    AppMethodBeat.i(293546);
    if (this.UwS == null)
    {
      AppMethodBeat.o(293546);
      return false;
    }
    if (!this.UwS.aro(4100))
    {
      AppMethodBeat.o(293546);
      return false;
    }
    if (this.UwT != null) {
      this.UwT.idu();
    }
    Log.i("MicroMsg.Voip.NewVoipMgr", "onAcceptVideoInvite");
    hVY();
    SubCoreVoip.hVp().bq(false, this.Uxc);
    By(4100);
    AppMethodBeat.o(293546);
    return true;
  }
  
  public final boolean hVL()
  {
    int i = 0;
    AppMethodBeat.i(293549);
    if (this.UwS == null)
    {
      AppMethodBeat.o(293549);
      return false;
    }
    if (!this.UwS.aro(4099))
    {
      AppMethodBeat.o(293549);
      return false;
    }
    Log.i("MicroMsg.Voip.NewVoipMgr", "onRejectVoiceInvite");
    String str2 = this.Uxa.field_username;
    if (this.Uxc) {}
    for (String str1 = cc.adkp;; str1 = cc.adko)
    {
      if (this.Uxb) {
        i = 1;
      }
      s.b(str2, str1, i, 6, MMApplicationContext.getContext().getString(b.g.voip_callfrom_reject_msg));
      hVY();
      SubCoreVoip.hVp().hYo();
      By(4099);
      hWb();
      AppMethodBeat.o(293549);
      return true;
    }
  }
  
  public final boolean hVM()
  {
    AppMethodBeat.i(293550);
    if (!this.UwS.aro(4100))
    {
      AppMethodBeat.o(293550);
      return false;
    }
    Log.i("MicroMsg.Voip.NewVoipMgr", "onAcceptVoiceInvite");
    hVY();
    SubCoreVoip.hVp().bq(true, this.Uxc);
    if (this.UwR != null) {
      this.UwR.ee(false);
    }
    By(4111);
    By(4100);
    AppMethodBeat.o(293550);
    return true;
  }
  
  public final boolean hVN()
  {
    AppMethodBeat.i(293553);
    if (!this.UwS.aro(4098))
    {
      AppMethodBeat.o(293553);
      return false;
    }
    Log.i("MicroMsg.Voip.NewVoipMgr", "onCancelVideoInvite");
    apS(4098);
    SubCoreVoip.hVp().hYD();
    AppMethodBeat.o(293553);
    return true;
  }
  
  public final boolean hVO()
  {
    AppMethodBeat.i(293555);
    if (!this.UwS.aro(4098))
    {
      AppMethodBeat.o(293555);
      return false;
    }
    Log.i("MicroMsg.Voip.NewVoipMgr", "onCancelVoiceInvite");
    apS(4098);
    SubCoreVoip.hVp().hYD();
    AppMethodBeat.o(293555);
    return true;
  }
  
  public final void hVP()
  {
    boolean bool = true;
    AppMethodBeat.i(293559);
    if ((this.Uxb) && (com.tencent.mm.plugin.voip.f.k.arl(getState())) && (SubCoreVoip.hVp().dro()))
    {
      this.UwR.o(this.luk, this.Uxc, this.Uxb);
      if ((!com.tencent.mm.plugin.ringtone.c.gOg()) || (this.Uxb))
      {
        if (this.Uxg == 1) {}
        for (;;)
        {
          Gl(bool);
          AppMethodBeat.o(293559);
          return;
          bool = false;
        }
      }
    }
    else if ((!this.Uxb) && (com.tencent.mm.plugin.voip.f.k.arm(getState())) && (SubCoreVoip.hVp().dro()))
    {
      this.UwR.o(this.luk, this.Uxc, this.Uxb);
      if ((!com.tencent.mm.plugin.ringtone.c.gOg()) || (this.Uxb)) {
        this.UwR.b("voip", Integer.valueOf(this.Uxg));
      }
    }
    AppMethodBeat.o(293559);
  }
  
  public final void hVQ()
  {
    AppMethodBeat.i(293562);
    Log.i("MicroMsg.Voip.NewVoipMgr", "it is init voip report");
    this.UxI = new NetChangedBroadcastReceiver();
    Object localObject1 = new IntentFilter();
    ((IntentFilter)localObject1).addAction("android.net.wifi.WIFI_STATE_CHANGED");
    ((IntentFilter)localObject1).addAction("android.net.wifi.STATE_CHANGE");
    ((IntentFilter)localObject1).addAction("android.net.conn.CONNECTIVITY_CHANGE");
    MMApplicationContext.getContext().registerReceiver(this.UxI, (IntentFilter)localObject1);
    this.wVW = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
    getContext();
    this.UxG = com.tencent.mm.plugin.voip.f.g.ibq();
    this.UxJ = new PhoneStateListener()
    {
      public final void onSignalStrengthsChanged(SignalStrength paramAnonymousSignalStrength)
      {
        AppMethodBeat.i(293353);
        super.onSignalStrengthsChanged(paramAnonymousSignalStrength);
        super.onSignalStrengthsChanged(paramAnonymousSignalStrength);
        paramAnonymousSignalStrength = paramAnonymousSignalStrength.toString().split(" ");
        try
        {
          if ((NewVoipMgr.b(NewVoipMgr.this).getNetworkType() == 13) && (paramAnonymousSignalStrength.length > 9)) {
            NewVoipMgr.dRV()[0] = Util.safeParseInt(paramAnonymousSignalStrength[9]);
          }
          AppMethodBeat.o(293353);
          return;
        }
        catch (Exception paramAnonymousSignalStrength)
        {
          Log.printErrStackTrace("MicroMsg.Voip.NewVoipMgr", paramAnonymousSignalStrength, "", new Object[0]);
          AppMethodBeat.o(293353);
        }
      }
    };
    localObject1 = this.wVW;
    Object localObject2 = this.UxJ;
    localObject2 = com.tencent.mm.hellhoundlib.b.c.a(256, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/voip/model/NewVoipMgr", "initVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/voip/model/NewVoipMgr", "initVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    AppMethodBeat.o(293562);
  }
  
  public final void hVR()
  {
    AppMethodBeat.i(293563);
    Log.i("MicroMsg.Voip.NewVoipMgr", "it is uninit voip report");
    if (this.UxK != null)
    {
      this.UxK.removeCallbacksAndMessages(null);
      this.UxK.quit();
    }
    if (!this.UxH)
    {
      if (this.UxT == 0) {
        apR(this.UxG);
      }
      if (this.UxT != 0)
      {
        this.UxH = true;
        if (!this.Uxb) {
          break label260;
        }
      }
    }
    label260:
    for (int i = 0;; i = 1)
    {
      com.tencent.mm.plugin.voip.f.g.a(i, System.currentTimeMillis(), this.UxG, this.UxG, 0, 0, UxL / this.UxT);
      UxL = 0;
      UxM[0] = 0;
      UxM[1] = 0;
      this.UxT = 0;
      if (this.wVW != null)
      {
        TelephonyManager localTelephonyManager = this.wVW;
        Object localObject = this.UxJ;
        localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/voip/model/NewVoipMgr", "uninitVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
        localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(1)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localTelephonyManager, "com/tencent/mm/plugin/voip/model/NewVoipMgr", "uninitVoipReport", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      }
      if (this.UxI != null)
      {
        MMApplicationContext.getContext().unregisterReceiver(this.UxI);
        this.UxI = null;
      }
      AppMethodBeat.o(293563);
      return;
    }
  }
  
  public final void hVS()
  {
    AppMethodBeat.i(293568);
    if ((this.KVp) || (this.UwU == null) || (this.UwU.fwr() == null) || (this.UwT == null) || (this.UwT.UTc == null))
    {
      Log.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, already show");
      AppMethodBeat.o(293568);
      return;
    }
    if (this.UwT.UTc.boa())
    {
      AppMethodBeat.o(293568);
      return;
    }
    if ((Build.MANUFACTURER.equalsIgnoreCase("meizu")) && (!com.tencent.mm.compatible.e.b.aPP()) && (com.tencent.mm.compatible.util.d.rc(29)))
    {
      Log.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, meizu machine");
      AppMethodBeat.o(293568);
      return;
    }
    if ((com.tencent.mm.compatible.util.d.rb(28)) && (((KeyguardManager)MMApplicationContext.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()))
    {
      Log.i("MicroMsg.Voip.NewVoipMgr", "api level: %s, in keyguard, ignore", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      AppMethodBeat.o(293568);
      return;
    }
    Log.d("MicroMsg.Voip.NewVoipMgr", "onCameraError, show dialog");
    com.tencent.mm.plugin.report.service.h.OAn.b(11306, new Object[] { Integer.valueOf(0), Integer.valueOf(0) });
    try
    {
      com.tencent.mm.ui.widget.a.e locale = com.tencent.mm.ui.base.k.s(this.UwU.fwr(), b.g.voip_no_record_video_permission, b.g.app_tip);
      if (locale == null)
      {
        Log.e("MicroMsg.Voip.NewVoipMgr", "new dialog failed");
        AppMethodBeat.o(293568);
        return;
      }
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      Object localObject;
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Voip.NewVoipMgr", localUnsupportedOperationException, "failed to show alert", new Object[0]);
        localObject = null;
      }
      localObject.setCancelable(false);
      localObject.setCanceledOnTouchOutside(false);
      localObject.show();
      this.KVp = true;
      com.tencent.mm.plugin.voip.f.i.ibO();
      AppMethodBeat.o(293568);
    }
  }
  
  public final boolean hVT()
  {
    return 1 == this.PRF;
  }
  
  public final void hVU()
  {
    AppMethodBeat.i(293596);
    if ((this.UwT != null) && (this.UwT.UTc != null) && (true != this.UwT.UTc.icu())) {
      aL(null);
    }
    AppMethodBeat.o(293596);
  }
  
  public final void hVV()
  {
    AppMethodBeat.i(293612);
    Object localObject1;
    if (this.UwT != null)
    {
      localObject1 = this.UwT;
      Log.printInfoStack("MicroMsg.VoIPRenderMgr", "onRender Mode changed", new Object[0]);
      if (((com.tencent.mm.plugin.voip.video.render.j)localObject1).UIF) {
        break label129;
      }
    }
    label129:
    for (boolean bool = true;; bool = false)
    {
      ((com.tencent.mm.plugin.voip.video.render.j)localObject1).UIF = bool;
      Object localObject2 = ((com.tencent.mm.plugin.voip.video.render.j)localObject1).UTl;
      if (localObject2 != null) {
        o.a((o)localObject2);
      }
      localObject2 = ((com.tencent.mm.plugin.voip.video.render.j)localObject1).UTl;
      if (localObject2 != null)
      {
        Log.printInfoStack("MicroMsg.LocalWindowsSurfaceRenderer", "switchRenderSurface", new Object[0]);
        p localp = ((o)localObject2).UUt;
        if (localp != null) {
          localp.idh();
        }
        localObject2 = ((o)localObject2).UUu;
        if (localObject2 != null) {
          ((p)localObject2).idh();
        }
      }
      localObject1 = ((com.tencent.mm.plugin.voip.video.render.j)localObject1).UTl;
      if (localObject1 != null) {
        ((o)localObject1).idi();
      }
      AppMethodBeat.o(293612);
      return;
    }
  }
  
  public final void hVW()
  {
    AppMethodBeat.i(293615);
    if (this.UwT != null) {
      this.UwT.iS(this.UxE, this.UxF);
    }
    AppMethodBeat.o(293615);
  }
  
  public final void hVX()
  {
    AppMethodBeat.i(293620);
    this.UxR.ard(1);
    AppMethodBeat.o(293620);
  }
  
  public final void hVY()
  {
    AppMethodBeat.i(293632);
    if (this.UwU != null) {
      this.UwU.fws();
    }
    if (this.UwR != null) {
      this.UwR.ULz = false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("scene", "close");
    localBundle.putLong("roomKey", SubCoreVoip.hVp().UBE.UvO.UyU.Hnt);
    localBundle.putBoolean("isVideoCall", this.Uxc);
    localBundle.putBoolean("isOutCall", this.Uxb);
    localBundle.putString("username", this.luk);
    ((com.tencent.mm.plugin.ringtone.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ringtone.a.class)).responseSence(com.tencent.mm.plugin.ringtone.a.a.OBd, localBundle);
    if (this.UwR != null) {
      this.UwR.ULz = false;
    }
    AppMethodBeat.o(293632);
  }
  
  public final boolean hVZ()
  {
    AppMethodBeat.i(293640);
    if (SubCoreVoip.hVp().UBE.UvO.UyU.roomId == 0)
    {
      this.Uxf = true;
      AppMethodBeat.o(293640);
      return true;
    }
    boolean bool = hWa();
    AppMethodBeat.o(293640);
    return bool;
  }
  
  public final boolean hVh()
  {
    return this.Uxc;
  }
  
  public final boolean hVi()
  {
    return this.Uxb;
  }
  
  public final String hVj()
  {
    return this.Uxv;
  }
  
  public final long hVk()
  {
    return this.LiJ;
  }
  
  public final long hVl()
  {
    return this.LiK;
  }
  
  public final int hVm()
  {
    return this.LiL;
  }
  
  public final boolean hVn()
  {
    AppMethodBeat.i(293725);
    if ((this.UwT == null) || (this.UwT.UTc == null))
    {
      AppMethodBeat.o(293725);
      return false;
    }
    boolean bool = this.UwT.UTc.icu();
    AppMethodBeat.o(293725);
    return bool;
  }
  
  public final boolean hWg()
  {
    AppMethodBeat.i(293717);
    Log.i("MicroMsg.Voip.NewVoipMgr", "isMinimized mUIType: " + this.PRF);
    if (2 == this.PRF)
    {
      Log.i("MicroMsg.Voip.NewVoipMgr", "already is widget");
      AppMethodBeat.o(293717);
      return true;
    }
    AppMethodBeat.o(293717);
    return false;
  }
  
  public final void hWh()
  {
    AppMethodBeat.i(293722);
    if (this.Uxs != null)
    {
      this.Uxs.uninit();
      this.Uxs = null;
    }
    SubCoreVoip.hVp().bp(false, false);
    AppMethodBeat.o(293722);
  }
  
  public final void hWi()
  {
    AppMethodBeat.i(293723);
    if ((256 != this.UwS.mState) && (257 != this.UwS.mState))
    {
      AppMethodBeat.o(293723);
      return;
    }
    if ((com.tencent.mm.kernel.h.baE().ban().getInt(327945, 0) == 0) && (this.UwU.fwr() != null))
    {
      com.tencent.mm.kernel.h.baE().ban().setInt(327945, 1);
      com.tencent.mm.ui.widget.a.e locale = com.tencent.mm.ui.base.k.a(this.UwU.fwr(), b.g.voip_ignore_warning, b.g.app_tip, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(293411);
          NewVoipMgr.this.hWk();
          AppMethodBeat.o(293411);
        }
      });
      locale.setCancelable(false);
      locale.setCanceledOnTouchOutside(false);
      locale.show();
      AppMethodBeat.o(293723);
      return;
    }
    m.bd(MMApplicationContext.getContext(), b.g.voip_ignore_warning);
    hWk();
    AppMethodBeat.o(293723);
  }
  
  public final void hWj()
  {
    AppMethodBeat.i(293724);
    if (!this.Uxm) {}
    for (boolean bool = true;; bool = false)
    {
      this.Uxm = bool;
      if (!this.Uxm) {
        break;
      }
      this.Uxl.stopTimer();
      AppMethodBeat.o(293724);
      return;
    }
    if (this.Uxl == null) {
      this.Uxl = new MTimerHandler("faceDetect", new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(293358);
          NewVoipMgr.v(NewVoipMgr.this);
          AppMethodBeat.o(293358);
          return true;
        }
      }, true);
    }
    this.Uxl.startTimer(2000L);
    this.Uxm = false;
    AppMethodBeat.o(293724);
  }
  
  public final void hWk()
  {
    AppMethodBeat.i(293728);
    SubCoreVoip.hVp().UBM = SubCoreVoip.hVp().UBE.UvO.UyU.roomId;
    String str2 = this.Uxa.field_username;
    String str1;
    if (this.Uxc)
    {
      str1 = cc.adkp;
      if (!this.Uxb) {
        break label124;
      }
    }
    label124:
    for (int i = 1;; i = 0)
    {
      s.b(str2, str1, i, 6, MMApplicationContext.getContext().getString(b.g.voip_callfrom_ignore_msg));
      hVY();
      By(4108);
      if (this.qse != null) {
        this.qse.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(293409);
            NewVoipMgr.u(NewVoipMgr.this);
            AppMethodBeat.o(293409);
          }
        }, 2000L);
      }
      AppMethodBeat.o(293728);
      return;
      str1 = cc.adko;
      break;
    }
  }
  
  public final void iS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(293695);
    Log.i("MicroMsg.Voip.NewVoipMgr", "adjustHWViewAspectRatio, HWDecsize:%dx%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.UxE = paramInt1;
    this.UxF = paramInt2;
    if (this.UwT != null) {
      this.UwT.iS(paramInt1, paramInt2);
    }
    AppMethodBeat.o(293695);
  }
  
  public void onConnected()
  {
    AppMethodBeat.i(293670);
    By(4102);
    this.Uxh = Util.nowSecond();
    this.Uxj = Util.nowMilliSecond();
    SubCoreVoip.hVp().Uxh = this.Uxh;
    SubCoreVoip.a(this.Uxc, this.Uxb, this.Uxh, this.luk);
    if (this.UwU != null) {
      this.UwU.setConnectSec(this.Uxh);
    }
    boolean bool1 = SubCoreVoip.hVp().UBE.UvO.hWE();
    boolean bool2 = SubCoreVoip.hVp().UBE.UvO.hWD();
    if ((this.Uxc) && (this.Uxb) && (!bool2) && (!bool1)) {
      SubCoreVoip.hVp().aqh(1);
    }
    if (!com.tencent.mm.plugin.voip.f.k.ark(this.UwS.mState)) {
      com.tencent.mm.plugin.report.service.h.OAn.b(11080, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0) });
    }
    Util.shake(MMApplicationContext.getContext(), true);
    Object localObject1 = SubCoreVoip.hVp();
    int i = SubCoreVoip.hVp().UBE.UvO.UyU.UDH;
    localObject1 = ((u)localObject1).UBE;
    ((v)localObject1).UCt = 0;
    if (i > 0) {
      v.UCk = i;
    }
    Object localObject2 = (TelephonyManager)MMApplicationContext.getContext().getSystemService("phone");
    if (localObject2 != null)
    {
      Object localObject3 = new v.6((v)localObject1, (TelephonyManager)localObject2);
      localObject3 = com.tencent.mm.hellhoundlib.b.c.a(256, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject3);
      com.tencent.mm.hellhoundlib.a.a.b(localObject2, ((com.tencent.mm.hellhoundlib.b.a)localObject3).aYi(), "com/tencent/mm/plugin/voip/model/VoipServiceEx", "VOIPmoileSignalStrength", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      ((TelephonyManager)localObject2).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject3).sb(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject3).sb(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject2, "com/tencent/mm/plugin/voip/model/VoipServiceEx", "VOIPmoileSignalStrength", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    }
    ((v)localObject1).UCC = new v.c((v)localObject1);
    MMApplicationContext.getContext().registerReceiver(((v)localObject1).UCC, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    if (com.tencent.mm.plugin.voip.f.a.ULa == null) {
      com.tencent.mm.plugin.voip.f.a.ULa = new com.tencent.mm.plugin.voip.f.a.a((byte)0);
    }
    localObject2 = new IntentFilter();
    ((IntentFilter)localObject2).addAction("android.intent.action.BATTERY_OKAY");
    ((IntentFilter)localObject2).addAction("android.intent.action.BATTERY_LOW");
    MMApplicationContext.getContext().registerReceiver(com.tencent.mm.plugin.voip.f.a.ULa, (IntentFilter)localObject2);
    if (((v)localObject1).UCu != null) {
      ((v)localObject1).UCu.cancel(false);
    }
    if (((v)localObject1).UCv != null) {
      ((v)localObject1).UCv.cancel(false);
    }
    ((v)localObject1).UCA = new v.b((v)localObject1);
    ((v)localObject1).UCB = new v.a((v)localObject1);
    ((v)localObject1).UCu = com.tencent.threadpool.h.ahAA.a(((v)localObject1).UCA, 0L, TimeUnit.SECONDS.toMillis(v.UCk));
    ((v)localObject1).UCv = com.tencent.threadpool.h.ahAA.a(((v)localObject1).UCB, 0L, TimeUnit.SECONDS.toMillis(v.UCl));
    r.hXJ().hXK();
    r.hXJ().a(this);
    localObject1 = k.Uyp;
    k.setRoomId(SubCoreVoip.hVp().UBE.UvO.UyU.roomId);
    localObject1 = com.tencent.mm.plugin.voip.d.i.UHA;
    com.tencent.mm.plugin.voip.d.i.fRQ();
    AppMethodBeat.o(293670);
  }
  
  public void onError(int paramInt, String paramString)
  {
    AppMethodBeat.i(293656);
    this.UwR.iba();
    String str1 = paramString;
    if (paramInt == 241)
    {
      str1 = paramString;
      if (Util.isNullOrNil(paramString)) {
        str1 = getContext().getString(b.g.voip_overload_protection_default_wording);
      }
    }
    if (this.UwU != null) {
      this.UwU.bX(paramInt, str1);
    }
    paramString = com.tencent.mm.plugin.voip.d.c.UGb;
    com.tencent.mm.plugin.voip.d.c.a(com.tencent.mm.plugin.voip.d.c.a.UGI);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onError, errCode: %s, roomId: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.roomId) });
    if (com.tencent.mm.plugin.voip.f.k.arj(getState()))
    {
      paramString = MMApplicationContext.getContext().getString(b.g.voip_on_error_shutdown, new Object[] { iY(Util.secondsToNow(this.Uxh)) });
      By(4109);
      if ((SubCoreVoip.hVp().UBE.UvO.UyU.roomId == 0) || (SubCoreVoip.hVp().UBL.get(Integer.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.roomId)) != null)) {
        break label477;
      }
      str2 = this.Uxa.field_username;
      if (!this.Uxc) {
        break label464;
      }
      str1 = cc.adkp;
      if (!this.Uxb) {
        break label472;
      }
      paramInt = 1;
      if (com.tencent.mm.plugin.voip.f.k.arj(this.UwS.mState)) {
        paramString = MMApplicationContext.getContext().getString(b.g.voip_call_msg_chat_time_interrupt_by_err, new Object[] { iY(Util.secondsToNow(this.Uxh)) });
      }
      l = s.a(str2, str1, paramInt, 6, paramString, true);
      SubCoreVoip.hVp().UBL.put(Integer.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.roomId), Long.valueOf(l));
    }
    label464:
    label472:
    label477:
    while (SubCoreVoip.hVp().UBE.UvO.UyU.roomId != 0) {
      for (;;)
      {
        long l;
        SubCoreVoip.hVp().hYD();
        hWb();
        AppMethodBeat.o(293656);
        return;
        paramString = MMApplicationContext.getContext();
        Log.d("MicroMsg.Voip.NewVoipMgr", "getErrorMsgContent, errorCode".concat(String.valueOf(paramInt)));
        if (paramInt == 235)
        {
          paramString = paramString.getString(b.g.voip_callout_error_msg_unsupport);
          break;
        }
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
        str1 = cc.adko;
        continue;
        paramInt = 0;
      }
    }
    String str2 = this.Uxa.field_username;
    if (this.Uxc)
    {
      str1 = cc.adkp;
      label516:
      if (!this.Uxb) {
        break label589;
      }
    }
    label589:
    for (paramInt = 1;; paramInt = 0)
    {
      if (com.tencent.mm.plugin.voip.f.k.arj(this.UwS.mState)) {
        paramString = MMApplicationContext.getContext().getString(b.g.voip_call_msg_chat_time_interrupt_by_err, new Object[] { iY(Util.secondsToNow(this.Uxh)) });
      }
      s.a(str2, str1, paramInt, 6, paramString, true);
      break;
      str1 = cc.adko;
      break label516;
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture) {}
  
  public void onScreenStateChange(boolean paramBoolean) {}
  
  public final void setHWDecMode(int paramInt)
  {
    AppMethodBeat.i(293693);
    this.Uxy = paramInt;
    if (this.UwT != null)
    {
      this.UwT.setHWDecMode(paramInt);
      if (this.UwU != null) {
        this.UwU.VX(paramInt);
      }
      if (this.UxR != null)
      {
        com.tencent.mm.plugin.voip.f.i locali = this.UxR;
        if ((paramInt & 0x1) != 0)
        {
          locali.ULQ += 1L;
          AppMethodBeat.o(293693);
          return;
        }
        locali.ULR += 1L;
      }
    }
    AppMethodBeat.o(293693);
  }
  
  public final void setSpatiotemporalDenosing(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(293691);
    Log.i("MicroMsg.Voip.NewVoipMgr", "setSpatiotemporalDenosing, isON: " + paramInt + "，mVoipUI: " + this.UwU);
    Object localObject1;
    Object localObject2;
    Size localSize;
    int i;
    if (this.UwT != null)
    {
      localObject1 = this.UwT;
      Log.i("MicroMsg.VoIPRenderMgr", "setSpatiotemporalDenosing, mIsStarted:%b, isON:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.voip.video.render.j)localObject1).mIsStarted), Integer.valueOf(paramInt) });
      ((com.tencent.mm.plugin.voip.video.render.j)localObject1).UxA = paramInt;
      localObject2 = ((com.tencent.mm.plugin.voip.video.render.j)localObject1).UTc;
      if (localObject2 != null)
      {
        if ((paramInt == 1) && (!v2protocal.UDp) && (((com.tencent.mm.plugin.voip.video.camera.a.a)localObject2).hq() != null))
        {
          localSize = ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject2).hq();
          if (localSize != null) {
            break label334;
          }
          i = 0;
          if (i < 1280)
          {
            localObject2 = ((com.tencent.mm.plugin.voip.video.camera.a.a)localObject2).hq();
            if (localObject2 != null) {
              break label343;
            }
            i = 0;
            label160:
            if (i < 1280) {}
          }
          else
          {
            ((com.tencent.mm.plugin.voip.video.render.j)localObject1).UxA = 0;
            Log.i("MicroMsg.VoIPRenderMgr", "The default capturing resolution is 720p, but the 720p capturing is not enabled, close the stFiter");
          }
        }
        localObject2 = com.tencent.mm.plugin.voip.d.c.UGb;
        com.tencent.mm.plugin.voip.d.c.aqE(paramInt);
        ((com.tencent.mm.plugin.voip.video.render.j)localObject1).onOrientationChange(((com.tencent.mm.plugin.voip.video.render.j)localObject1).qpM);
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.j)localObject1).UTl;
        if (localObject2 != null)
        {
          i = ((com.tencent.mm.plugin.voip.video.render.j)localObject1).UxA;
          localObject2 = ((o)localObject2).UUs;
          if (localObject2 != null) {
            ((com.tencent.mm.plugin.voip.video.render.h)localObject2).arw(i);
          }
        }
        ((com.tencent.mm.plugin.voip.video.render.j)localObject1).aru(((com.tencent.mm.plugin.voip.video.render.j)localObject1).qpM);
        localObject2 = ((com.tencent.mm.plugin.voip.video.render.j)localObject1).UTl;
        if (localObject2 != null)
        {
          if (((com.tencent.mm.plugin.voip.video.render.j)localObject1).UxA == 0) {
            break label352;
          }
          label267:
          if (((o)localObject2).UUw) {
            break label357;
          }
          localObject1 = ((o)localObject2).UUv;
          if (localObject1 != null)
          {
            Log.i("MicroMsg.EncodeWindowSurfaceRenderer", kotlin.g.b.s.X("setVoipSTFilter:", Boolean.valueOf(bool)));
            ((com.tencent.mm.plugin.voip.video.render.b)localObject1).URF = bool;
          }
        }
      }
    }
    for (;;)
    {
      if (this.UwU != null) {
        localObject1 = this.UwU;
      }
      this.UxA = paramInt;
      AppMethodBeat.o(293691);
      return;
      label334:
      i = localSize.getWidth();
      break;
      label343:
      i = ((Size)localObject2).getHeight();
      break label160;
      label352:
      bool = false;
      break label267;
      label357:
      localObject1 = ((o)localObject2).UUs;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).USM;
        if (localObject1 != null)
        {
          Log.i("MicroMsg.EncodeWindowSurfaceRenderer", kotlin.g.b.s.X("setVoipSTFilter:", Boolean.valueOf(bool)));
          ((com.tencent.mm.plugin.voip.video.render.a)localObject1).URF = bool;
        }
      }
    }
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    long l = 0L;
    AppMethodBeat.i(293626);
    Object localObject;
    if (paramInt != 2)
    {
      this.UwR.ibb();
      localObject = com.tencent.mm.plugin.voip.d.c.UGb;
      localObject = com.tencent.mm.plugin.voip.d.c.hZJ();
      if (SubCoreVoip.hVp().Uxh != 0L) {
        break label107;
      }
    }
    for (;;)
    {
      ((ConcurrentLinkedQueue)localObject).add(new kotlin.r(Integer.valueOf(paramInt), Long.valueOf(l)));
      this.Uxg = paramInt;
      AppMethodBeat.o(293626);
      return;
      if ((this.Uxg == 2) || (com.tencent.mm.plugin.voip.f.k.ark(this.UwS.mState))) {
        break;
      }
      getContext();
      hWm();
      break;
      label107:
      l = Util.ticksToNow(SubCoreVoip.hVp().Uxh);
    }
  }
  
  public final void setVoipBeauty(int paramInt)
  {
    boolean bool = true;
    AppMethodBeat.i(293688);
    Log.i("MicroMsg.Voip.NewVoipMgr", "setVoIPBeauty, isON: " + paramInt + "，mVoipUI: " + this.UwU);
    Object localObject1;
    Object localObject2;
    if (this.UwT != null)
    {
      localObject1 = this.UwT;
      Log.i("MicroMsg.VoIPRenderMgr", "setVoIPBeauty, mIsStarted:%b, isON:%d", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.voip.video.render.j)localObject1).mIsStarted), Integer.valueOf(paramInt) });
      ((com.tencent.mm.plugin.voip.video.render.j)localObject1).Uxz = paramInt;
      localObject2 = com.tencent.mm.plugin.voip.d.c.UGb;
      com.tencent.mm.plugin.voip.d.c.aqD(paramInt);
      localObject2 = com.tencent.mm.plugin.voip.d.f.UGZ;
      com.tencent.mm.plugin.voip.d.f.aqH(paramInt);
      localObject2 = ((com.tencent.mm.plugin.voip.video.render.j)localObject1).UTl;
      if (localObject2 != null)
      {
        int i = ((com.tencent.mm.plugin.voip.video.render.j)localObject1).Uxz;
        localObject2 = ((o)localObject2).UUs;
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.voip.video.render.h)localObject2).arv(i);
        }
      }
      ((com.tencent.mm.plugin.voip.video.render.j)localObject1).onOrientationChange(((com.tencent.mm.plugin.voip.video.render.j)localObject1).qpM);
      ((com.tencent.mm.plugin.voip.video.render.j)localObject1).aru(((com.tencent.mm.plugin.voip.video.render.j)localObject1).qpM);
      localObject2 = ((com.tencent.mm.plugin.voip.video.render.j)localObject1).UTl;
      if (localObject2 != null)
      {
        if (((com.tencent.mm.plugin.voip.video.render.j)localObject1).Uxz == 0) {
          break label296;
        }
        if (!((o)localObject2).UUw) {
          break label301;
        }
        localObject1 = ((o)localObject2).UUs;
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.voip.video.render.h)localObject1).USM;
          if (localObject1 != null)
          {
            Log.i("MicroMsg.EncodeWindowSurfaceRenderer", kotlin.g.b.s.X("setVoipFaceBeauty:", Boolean.valueOf(bool)));
            ((com.tencent.mm.plugin.voip.video.render.a)localObject1).URE = bool;
          }
        }
      }
    }
    for (;;)
    {
      if (this.UwU != null) {
        this.UwU.VY(paramInt);
      }
      if ((paramInt != 0) && (this.Uxz != paramInt)) {
        com.tencent.mm.plugin.report.service.h.OAn.p(914L, 20L, 1L);
      }
      this.Uxz = paramInt;
      AppMethodBeat.o(293688);
      return;
      label296:
      bool = false;
      break;
      label301:
      localObject1 = ((o)localObject2).UUv;
      if (localObject1 != null)
      {
        Log.i("MicroMsg.EncodeWindowSurfaceRenderer", kotlin.g.b.s.X("setVoipFaceBeauty:", Boolean.valueOf(bool)));
        ((com.tencent.mm.plugin.voip.video.render.b)localObject1).URE = bool;
      }
    }
  }
  
  protected void vF(boolean paramBoolean)
  {
    AppMethodBeat.i(293718);
    Log.i("MicroMsg.Voip.NewVoipMgr", "do minimizeVoip");
    if ((2 == this.PRF) && (Build.VERSION.SDK_INT < 24))
    {
      Log.e("MicroMsg.Voip.NewVoipMgr", "already is widget");
      AppMethodBeat.o(293718);
      return;
    }
    if ((262 == this.UwS.mState) || (8 == this.UwS.mState))
    {
      Log.e("MicroMsg.Voip.NewVoipMgr", "voip call has finished!，state is %s", new Object[] { Integer.valueOf(this.UwS.mState) });
      AppMethodBeat.o(293718);
      return;
    }
    if (this.UwU != null) {
      this.UwU.setScreenEnable(true);
    }
    this.Uxs = new com.tencent.mm.plugin.voip.widget.b(this, this.UwS.mState, this.Uxa, this.Uxc, this.Uxb, paramBoolean);
    if ((this.Uxc) && (this.UxR != null)) {
      this.UxR.ard(0);
    }
    SubCoreVoip.hVp().bp(true, paramBoolean);
    AppMethodBeat.o(293718);
  }
  
  public void vI(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(293676);
    Log.printInfoStack("MicroMsg.Voip.NewVoipMgr", "onShutDown", new Object[0]);
    if (this.UwS == null)
    {
      Log.w("MicroMsg.Voip.NewVoipMgr", "shutdown when startVoIP() didn't get called");
      AppMethodBeat.o(293676);
      return;
    }
    String str1;
    String str3;
    String str2;
    label126:
    int k;
    label135:
    label148:
    label183:
    long l;
    if (com.tencent.mm.plugin.voip.f.k.arj(this.UwS.mState))
    {
      str1 = MMApplicationContext.getContext().getString(b.g.voip_call_msg_chat_time, new Object[] { iY(Util.secondsToNow(this.Uxh)) });
      if ((!this.Uxb) && (!com.tencent.mm.plugin.voip.f.k.arj(this.UwS.mState))) {
        break label308;
      }
      str3 = this.Uxa.field_username;
      if (!this.Uxc) {
        break label295;
      }
      str2 = cc.adkp;
      if (!this.Uxb) {
        break label303;
      }
      i = 1;
      s.b(str3, str2, i, 6, str1);
      this.UwR.iba();
      this.UwY = com.tencent.mm.plugin.voip.f.k.arj(this.UwS.mState);
      if (!hWe()) {
        break label378;
      }
      this.Uxe = 4106;
      SubCoreVoip.hVp().hYD();
      if (!this.UxC)
      {
        k = SubCoreVoip.hVp().UBE.UvO.UyU.roomId;
        l = SubCoreVoip.hVp().UBE.UvO.UyU.Hnt;
        if (!this.Uxb) {
          break label392;
        }
      }
    }
    label392:
    for (int i = j;; i = 1)
    {
      com.tencent.mm.plugin.voip.f.g.c(k, l, i, 4);
      this.UxC = true;
      AppMethodBeat.o(293676);
      return;
      if (this.Uxb)
      {
        str1 = MMApplicationContext.getContext().getString(b.g.voip_call_connection_failed);
        break;
      }
      str1 = MMApplicationContext.getContext().getString(b.g.voip_call_cancel_msg_from);
      break;
      label295:
      str2 = cc.adko;
      break label126;
      label303:
      i = 0;
      break label135;
      label308:
      if ((this.Uxb) || (!paramBoolean)) {
        break label148;
      }
      str3 = this.Uxa.field_username;
      if (this.Uxc)
      {
        str2 = cc.adkp;
        label340:
        if (!this.Uxb) {
          break label373;
        }
      }
      label373:
      for (i = 1;; i = 0)
      {
        s.b(str3, str2, i, 6, str1);
        break;
        str2 = cc.adko;
        break label340;
      }
      label378:
      By(4106);
      hWb();
      break label183;
    }
  }
  
  public final void xy(boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(293706);
    Log.i("MicroMsg.Voip.NewVoipMgr", "onBadNetStatus");
    if (this.UwU != null) {
      this.UwU.vJ(paramBoolean);
    }
    long l;
    if ((!com.tencent.mm.plugin.voip.f.k.ark(this.UwS.mState)) && (!this.UwR.cTU()))
    {
      l = System.currentTimeMillis();
      if (l - this.JHG > 30000L)
      {
        this.JHG = l;
        localObject = new Bundle();
        ((Bundle)localObject).putString("scene", "bad_net");
        ((com.tencent.mm.plugin.ringtone.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ringtone.a.class)).responseSence(com.tencent.mm.plugin.ringtone.a.a.OBd, (Bundle)localObject);
      }
    }
    Object localObject = new StringBuilder("report the bad net toast room key is ").append(SubCoreVoip.hVp().UBE.UvO.UyU.Hnt).append("and in the side");
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      Log.i("MicroMsg.Voip.NewVoipMgr", i);
      localObject = com.tencent.mm.plugin.report.service.h.OAn;
      l = SubCoreVoip.hVp().UBE.UvO.UyU.Hnt;
      i = j;
      if (paramBoolean) {
        i = 1;
      }
      ((com.tencent.mm.plugin.report.service.h)localObject).a(17151, true, true, new Object[] { Long.valueOf(l), Integer.valueOf(i) });
      AppMethodBeat.o(293706);
      return;
    }
  }
  
  public final void yN(boolean paramBoolean)
  {
    AppMethodBeat.i(293539);
    this.UwR.GL(paramBoolean);
    AppMethodBeat.o(293539);
  }
  
  public class NetChangedBroadcastReceiver
    extends BroadcastReceiver
  {
    public NetChangedBroadcastReceiver() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      int j = 0;
      int i = 0;
      AppMethodBeat.i(293351);
      if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
      {
        switch (com.tencent.mm.plugin.voip.f.g.ibq())
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
                AppMethodBeat.o(293351);
                return;
              } while (NewVoipMgr.c(NewVoipMgr.this) == 5);
              j = NewVoipMgr.dRV()[1];
              if (NewVoipMgr.d(NewVoipMgr.this) == 0) {
                NewVoipMgr.a(NewVoipMgr.this, 4);
              }
            } while (NewVoipMgr.d(NewVoipMgr.this) == 0);
            k = NewVoipMgr.cdH() / NewVoipMgr.d(NewVoipMgr.this);
            NewVoipMgr.a(NewVoipMgr.this, 5);
            m = NewVoipMgr.dRV()[0];
            Log.i("MicroMsg.Voip.NewVoipMgr", "befor change to 4G and cost " + NewVoipMgr.e(NewVoipMgr.this));
            if (NewVoipMgr.this.Uxb) {}
            for (;;)
            {
              com.tencent.mm.plugin.voip.f.g.a(i, System.currentTimeMillis(), NewVoipMgr.c(NewVoipMgr.this), 5, j, m, k);
              NewVoipMgr.f(NewVoipMgr.this);
              NewVoipMgr.b(NewVoipMgr.this, 5);
              NewVoipMgr.hWn();
              NewVoipMgr.g(NewVoipMgr.this);
              AppMethodBeat.o(293351);
              return;
              i = 1;
            }
          } while (NewVoipMgr.c(NewVoipMgr.this) == 4);
          k = NewVoipMgr.dRV()[0];
          if (NewVoipMgr.d(NewVoipMgr.this) == 0) {
            NewVoipMgr.a(NewVoipMgr.this, 5);
          }
        } while (NewVoipMgr.d(NewVoipMgr.this) == 0);
        int m = NewVoipMgr.cdH() / NewVoipMgr.d(NewVoipMgr.this);
        NewVoipMgr.a(NewVoipMgr.this, 4);
        int n = NewVoipMgr.dRV()[1];
        Log.i("MicroMsg.Voip.NewVoipMgr", "befor change to wifi and cost " + NewVoipMgr.e(NewVoipMgr.this));
        if (NewVoipMgr.this.Uxb) {}
        for (i = j;; i = 1)
        {
          com.tencent.mm.plugin.voip.f.g.a(i, System.currentTimeMillis(), NewVoipMgr.c(NewVoipMgr.this), 4, k, n, m);
          NewVoipMgr.f(NewVoipMgr.this);
          NewVoipMgr.b(NewVoipMgr.this, 4);
          NewVoipMgr.hWn();
          NewVoipMgr.g(NewVoipMgr.this);
          break;
        }
      }
      if ((paramIntent.getAction().equals("android.net.wifi.STATE_CHANGE")) && (NewVoipMgr.h(NewVoipMgr.this) == 0L))
      {
        NewVoipMgr.a(NewVoipMgr.this, System.currentTimeMillis());
        AppMethodBeat.o(293351);
        return;
      }
      if ((paramIntent.getAction().equals("android.net.wifi.WIFI_STATE_CHANGED")) && (NewVoipMgr.h(NewVoipMgr.this) != 0L))
      {
        NewVoipMgr.b(NewVoipMgr.this, System.currentTimeMillis() - NewVoipMgr.h(NewVoipMgr.this));
        NewVoipMgr.a(NewVoipMgr.this, 0L);
      }
      AppMethodBeat.o(293351);
    }
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(293342);
      NewVoipMgr.j(NewVoipMgr.this);
      NewVoipMgr.k(NewVoipMgr.this);
      AppMethodBeat.o(293342);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.NewVoipMgr
 * JD-Core Version:    0.7.0.1
 */