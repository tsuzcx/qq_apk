package com.tencent.mm.plugin.voip.ui;

import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.os.IBinder;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.setting.ui.setting.SettingsAboutCamera;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.s;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.component.UIComponent;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;

@com.tencent.mm.kernel.k
@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
public final class e
  implements d
{
  private int HnR;
  private IListener Hnz;
  private com.tencent.mm.plugin.voip.c.b JPY;
  private boolean JQR;
  private boolean JQS;
  private boolean LrJ;
  private int LrK;
  private VoipBaseFragment UJa;
  private WeakReference<c> UJb;
  private long UJc;
  private long UJd;
  private boolean UJe;
  private int UJf;
  private boolean UJg;
  private boolean UJh;
  private VideoActivity UJi;
  private long UJj;
  private au Uxa;
  private boolean Uxb;
  private boolean Uxc;
  private int Uxg;
  private String luk;
  private IListener mIj;
  private boolean mIsMute;
  private int mStatus;
  private Point nGU;
  com.tencent.mm.plugin.mmsight.model.d orientationEventListener;
  private MMHandler qse;
  private CaptureView wUL;
  private boolean zYf;
  
  public e(VideoActivity paramVideoActivity)
  {
    AppMethodBeat.i(292467);
    this.UJc = -1L;
    this.mStatus = -1;
    this.zYf = false;
    this.UJd = 0L;
    this.UJe = false;
    this.Uxg = -1;
    this.mIsMute = false;
    this.UJf = 1;
    this.JQS = false;
    this.LrJ = false;
    this.LrK = 0;
    this.JQR = false;
    this.UJg = false;
    this.UJh = false;
    this.mIj = new VideoActivityController.1(this, com.tencent.mm.app.f.hfK);
    this.HnR = 1;
    this.Hnz = new VideoActivityController.6(this, com.tencent.mm.app.f.hfK);
    this.UJi = paramVideoActivity;
    AppMethodBeat.o(292467);
  }
  
  private static boolean fwe()
  {
    AppMethodBeat.i(292474);
    for (;;)
    {
      try
      {
        TelephonyManager localTelephonyManager = (TelephonyManager)MMApplicationContext.getContext().getSystemService("phone");
        if (localTelephonyManager == null) {
          continue;
        }
        i = localTelephonyManager.getCallState();
        switch (i)
        {
        default: 
          bool = false;
        }
      }
      catch (Exception localException1)
      {
        int i;
        boolean bool = false;
        Log.e("MicroMsg.Voip.VideoActivityController", "get callState error , errMsg is %s", new Object[] { localException1.getLocalizedMessage() });
        continue;
        bool = false;
        continue;
      }
      try
      {
        Log.i("MicroMsg.Voip.VideoActivityController", "TelephoneManager.callState is %d", new Object[] { Integer.valueOf(i) });
        AppMethodBeat.o(292474);
        return bool;
      }
      catch (Exception localException2)
      {
        continue;
      }
      bool = false;
      continue;
      bool = true;
    }
  }
  
  private int fwf()
  {
    AppMethodBeat.i(292511);
    int i;
    if (com.tencent.mm.plugin.audio.c.a.cTW().cTV())
    {
      i = com.tencent.mm.plugin.audio.c.a.cTR();
      AppMethodBeat.o(292511);
      return i;
    }
    if (!com.tencent.mm.plugin.voip.f.k.arj(this.mStatus))
    {
      i = 2;
      if (this.Uxb) {
        if (!this.Uxc)
        {
          if (af.lXZ.lRC < 0) {
            break label203;
          }
          i = af.lXZ.lRC;
        }
      }
    }
    for (;;)
    {
      int j = i;
      if (!com.tencent.mm.plugin.audio.c.a.cTX())
      {
        j = i;
        if (af.lXZ.lRE < 0) {}
      }
      for (j = af.lXZ.lRE;; j = SubCoreVoip.hVp().gdZ())
      {
        Log.i("MicroMsg.Voip.VideoActivityController", "Current StreamType:%d", new Object[] { Integer.valueOf(j) });
        AppMethodBeat.o(292511);
        return j;
        i = 3;
        if (com.tencent.mm.plugin.audio.c.a.cTQ())
        {
          if (af.lXZ.lRC < 0) {
            break label203;
          }
          i = af.lXZ.lRC;
          break;
        }
        if (af.lXZ.lRz < 0) {
          break;
        }
        i = af.lXZ.lRz;
        break;
        if (!com.tencent.mm.plugin.audio.c.a.cTQ()) {
          break;
        }
        if (af.lXZ.lRC < 0) {
          break label203;
        }
        i = af.lXZ.lRC;
        break;
      }
      label203:
      i = 0;
    }
  }
  
  private void fwg()
  {
    AppMethodBeat.i(292500);
    if ((this.UJb != null) && (this.UJb.get() != null) && (!this.Uxb))
    {
      if (!this.Uxc) {
        break label91;
      }
      ((c)this.UJb.get()).hVK();
    }
    for (;;)
    {
      if ((SubCoreVoip.hVp().huY) && (this.Uxc)) {
        ((c)this.UJb.get()).hVU();
      }
      AppMethodBeat.o(292500);
      return;
      label91:
      ((c)this.UJb.get()).hVM();
    }
  }
  
  private void hWb()
  {
    AppMethodBeat.i(292485);
    this.qse.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(292363);
        e.this.finish();
        AppMethodBeat.o(292363);
      }
    }, 2000L);
    AppMethodBeat.o(292485);
  }
  
  public final void VR(final int paramInt)
  {
    AppMethodBeat.i(292867);
    this.UJi.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(292365);
        if (e.h(e.this) == paramInt)
        {
          AppMethodBeat.o(292365);
          return;
        }
        e.b(e.this, paramInt);
        AppMethodBeat.o(292365);
      }
    });
    AppMethodBeat.o(292867);
  }
  
  public final void VV(int paramInt)
  {
    AppMethodBeat.i(292870);
    if (this.UJa != null) {
      this.UJa.VV(paramInt);
    }
    AppMethodBeat.o(292870);
  }
  
  public final void VW(int paramInt)
  {
    AppMethodBeat.i(292821);
    Intent localIntent = new Intent(this.UJi, SettingsAboutCamera.class);
    localIntent.putExtra("activity_caller_params", 1);
    this.UJi.startActivityForResult(localIntent, 1);
    this.LrJ = true;
    this.LrK = paramInt;
    AppMethodBeat.o(292821);
  }
  
  public final void VX(int paramInt)
  {
    AppMethodBeat.i(292871);
    if (this.UJa != null) {
      this.UJa.VX(paramInt);
    }
    AppMethodBeat.o(292871);
  }
  
  public final void VY(int paramInt)
  {
    AppMethodBeat.i(292873);
    if (this.UJa != null) {
      this.UJa.VY(paramInt);
    }
    AppMethodBeat.o(292873);
  }
  
  public final void aDJ(final String paramString)
  {
    AppMethodBeat.i(292775);
    if (this.UJa != null) {
      this.qse.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(292350);
          if (e.d(e.this) != null) {
            e.d(e.this).aDJ(paramString);
          }
          AppMethodBeat.o(292350);
        }
      });
    }
    AppMethodBeat.o(292775);
  }
  
  public final void aq(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(292852);
    this.UJe = paramBoolean2;
    if (paramBoolean1)
    {
      hWb();
      AppMethodBeat.o(292852);
      return;
    }
    finish();
    AppMethodBeat.o(292852);
  }
  
  public final void bX(final int paramInt, String paramString)
  {
    AppMethodBeat.i(292769);
    Log.i("MicroMsg.Voip.VideoActivityController", "onError, errCode:%d, isVideoCall:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.Uxc) });
    this.zYf = true;
    if (paramInt == 241)
    {
      com.tencent.mm.ui.base.k.c(this.UJi, paramString, null, true);
      AppMethodBeat.o(292769);
      return;
    }
    this.qse.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(292356);
        e.a(e.this, paramInt);
        AppMethodBeat.o(292356);
      }
    });
    AppMethodBeat.o(292769);
  }
  
  public final void c(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(292589);
    paramHashSet.add(com.tencent.mm.plugin.voip.a.a.class);
    paramHashSet.add(com.tencent.mm.plugin.voip.a.b.class);
    AppMethodBeat.o(292589);
  }
  
  public final void dealContentView(View paramView)
  {
    AppMethodBeat.i(292787);
    aw.y(aw.a(this.UJi.getWindow(), null), this.UJi.getBodyView());
    ((ViewGroup)this.UJi.getWindow().getDecorView()).addView(paramView, 0);
    AppMethodBeat.o(292787);
  }
  
  public final void finish()
  {
    int i = 0;
    AppMethodBeat.i(292717);
    this.UJf = 3;
    Log.i("MicroMsg.Voip.VideoActivityController", "finish, finishBczMinimize: %b, status: %s", new Object[] { Boolean.valueOf(this.UJe), com.tencent.mm.plugin.voip.f.k.arg(this.mStatus) });
    if ((!this.UJe) && (com.tencent.mm.plugin.voip.f.k.arj(this.mStatus)) && (4 != this.UJf))
    {
      Log.i("MicroMsg.Voip.VideoActivityController", "finish VideoActivity, start ChattingUI");
      Intent localIntent = new Intent();
      localIntent.addFlags(67108864);
      localIntent.putExtra("Chat_User", this.luk);
      com.tencent.mm.plugin.voip.c.pFn.d(localIntent, this.UJi);
    }
    int j;
    long l;
    if (this.UJh)
    {
      this.UJh = false;
      j = SubCoreVoip.hVp().hYr();
      l = SubCoreVoip.hVp().hVw();
      if (!this.Uxb) {
        break label246;
      }
    }
    for (;;)
    {
      g.c(j, l, i, 5);
      g.arb(1);
      if (this.orientationEventListener != null)
      {
        this.orientationEventListener.disable();
        this.orientationEventListener.KUU = null;
        this.orientationEventListener = null;
      }
      if (this.UJa != null)
      {
        this.UJa.uninit();
        this.UJa = null;
      }
      this.UJb = null;
      this.wUL = null;
      this.JQR = true;
      this.UJi.ias();
      VoipBaseFragment.UKe = -1;
      AppMethodBeat.o(292717);
      return;
      label246:
      i = 1;
    }
  }
  
  public final void fixResources(Resources paramResources) {}
  
  public final void fwi() {}
  
  public final void fwq()
  {
    AppMethodBeat.i(292865);
    if (this.UJa != null) {
      this.UJa.fwq();
    }
    AppMethodBeat.o(292865);
  }
  
  public final Context fwr()
  {
    AppMethodBeat.i(292836);
    AppCompatActivity localAppCompatActivity = this.UJi.getContext();
    AppMethodBeat.o(292836);
    return localAppCompatActivity;
  }
  
  public final void fws()
  {
    AppMethodBeat.i(292825);
    if (this.UJa != null) {
      this.UJa.fws();
    }
    AppMethodBeat.o(292825);
  }
  
  public final void fwv()
  {
    AppMethodBeat.i(292813);
    if (this.UJa != null) {
      this.UJa.abU(10);
    }
    AppMethodBeat.o(292813);
  }
  
  public final void fww()
  {
    AppMethodBeat.i(292850);
    Log.d("MicroMsg.Voip.VideoActivityController", "dismissNetStatusWarning");
    if (this.UJa != null) {
      this.UJa.iaj();
    }
    AppMethodBeat.o(292850);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(292816);
    if (this.UJa != null) {
      this.UJa.aqX(10);
    }
    AppMethodBeat.o(292816);
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return b.e.voip_main;
  }
  
  public final void iU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(292667);
    this.mStatus = paramInt2;
    if ((1 != this.UJf) && (paramInt2 != 8) && (paramInt2 != 262))
    {
      Log.i("MicroMsg.Voip.VideoActivityController", "activity is not normal, can't transform");
      AppMethodBeat.o(292667);
      return;
    }
    if (this.UJa == null)
    {
      Log.i("MicroMsg.Voip.VideoActivityController", "mBaseFragment is null ,already close,now return.");
      AppMethodBeat.o(292667);
      return;
    }
    this.UJa.iU(paramInt1, paramInt2);
    Object localObject;
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(292667);
      return;
    case 1: 
    case 3: 
    case 7: 
    case 257: 
    case 261: 
      this.Uxc = false;
      if ((this.UJa == null) || (!(this.UJa instanceof VoipVoiceFragment)))
      {
        if (this.UJa != null)
        {
          this.UJa.uninit();
          this.UJi.getSupportFragmentManager().beginTransaction().a(this.UJa).FW();
          this.UJa = null;
        }
        Log.i("MicroMsg.Voip.VideoActivityController", "switch to voice fragment");
        localObject = new Bundle();
        ((Bundle)localObject).putString("key_username", this.Uxa.field_username);
        ((Bundle)localObject).putBoolean("key_isoutcall", this.Uxb);
        ((Bundle)localObject).putInt("key_status", this.mStatus);
        this.UJa = new VoipVoiceFragment();
        this.UJa.setArguments((Bundle)localObject);
        this.UJa.setVoipUIListener((c)this.UJb.get());
        this.UJa.wU(this.UJc);
        this.UJa.a(this);
        this.UJa.setVoicePlayDevice(this.Uxg);
        this.UJa.setMute(this.mIsMute);
        this.UJi.getSupportFragmentManager().beginTransaction().b(b.d.voip_container, this.UJa).FW();
      }
      AppMethodBeat.o(292667);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      hWb();
      Log.d("MicroMsg.Voip.VideoActivityController", "finishSmallWindow mStatus: %s", new Object[] { com.tencent.mm.plugin.voip.f.k.arg(this.mStatus) });
      if ((this.mStatus == 262) || (this.mStatus == 8)) {
        SubCoreVoip.hVq().jb(true);
      }
      if (com.tencent.mm.compatible.e.b.dh(this.UJi)) {
        break;
      }
      this.qse.postDelayed(new e.10(this), 2000L);
      break;
      if (this.Uxb)
      {
        localObject = this.UJa;
        if (!this.Uxc) {
          break label556;
        }
      }
      label556:
      for (paramInt1 = b.g.voip_video_call_rejected;; paramInt1 = b.g.voip_audio_call_rejected)
      {
        ((VoipBaseFragment)localObject).mE(paramInt1, -1);
        hWb();
        break;
      }
      this.qse.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(292346);
          if (e.d(e.this) != null) {
            e.d(e.this).mE(b.g.voip_shutdown_tip, -1);
          }
          e.e(e.this);
          AppMethodBeat.o(292346);
        }
      });
      continue;
      this.qse.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(292368);
          e.e(e.this);
          AppMethodBeat.o(292368);
        }
      });
      continue;
      this.qse.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(292344);
          e.e(e.this);
          AppMethodBeat.o(292344);
        }
      }, 50L);
      continue;
      hWb();
      continue;
      finish();
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(292831);
    if (paramInt1 == 1)
    {
      this.LrJ = false;
      if (this.UJa != null)
      {
        if (this.LrK == 2)
        {
          this.UJa.abU(5);
          AppMethodBeat.o(292831);
          return;
        }
        if (this.LrK == 1) {
          this.UJa.aqX(5);
        }
      }
    }
    AppMethodBeat.o(292831);
  }
  
  public final boolean onBackPressed()
  {
    return false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(292639);
    if ((this.nGU != null) && (com.tencent.mm.compatible.util.d.rb(17)))
    {
      paramConfiguration = new Point();
      this.UJi.getWindowManager().getDefaultDisplay().getRealSize(paramConfiguration);
      if ((!paramConfiguration.equals(this.nGU)) && (this.UJa != null))
      {
        this.nGU = paramConfiguration;
        this.UJa.n(this.nGU);
      }
    }
    AppMethodBeat.o(292639);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(292631);
    this.UJi.bf(paramBundle);
    for (;;)
    {
      Object localObject2;
      PBool localPBool;
      PString localPString;
      PInt localPInt;
      try
      {
        paramBundle = t.UBA;
        t.hXP();
        com.tencent.mm.util.e.hPY();
        com.tencent.mm.plugin.voip.floatcard.a.a(SubCoreVoip.hVp().UCa, false, false, 3);
        this.UJi.setActionbarColor(this.UJi.getResources().getColor(b.a.transparent));
        this.UJi.setRequestedOrientation(7);
        if (!com.tencent.mm.plugin.voip.f.m.ky(this.UJi.getContext())) {
          com.tencent.mm.plugin.voip.f.m.kz(this.UJi.getContext());
        }
        Log.i("MicroMsg.Voip.VideoActivityController", "VideoActivity onCreate start");
        this.UJi.getSupportActionBar().hide();
        this.UJi.getWindow().setSoftInputMode(3);
        this.orientationEventListener = new com.tencent.mm.plugin.mmsight.model.d(this.UJi);
        this.orientationEventListener.enable();
        this.orientationEventListener.KUU = this;
        this.UJi.getWindow().addFlags(6815872);
        if (com.tencent.mm.kernel.h.baz()) {
          SubCoreVoip.hVp().bp(false, false);
        }
        this.qse = new MMHandler();
        localObject2 = new PBool();
        localPBool = new PBool();
        localPString = new PString();
        localPInt = new PInt();
        Object localObject1 = new PInt();
        localPString.value = this.UJi.getIntent().getStringExtra("Voip_User");
        ((PBool)localObject2).value = this.UJi.getIntent().getBooleanExtra("Voip_Outcall", true);
        localPBool.value = this.UJi.getIntent().getBooleanExtra("Voip_VideoCall", true);
        this.UJj = this.UJi.getIntent().getLongExtra("Voip_LastPage_Hash", 0L);
        localPInt.value = com.tencent.mm.plugin.voip.f.k.bw(((PBool)localObject2).value, localPBool.value);
        paramBundle = new PLong();
        paramBundle.value = this.UJi.getIntent().getLongExtra("Voip_CallRoomKey", 0L);
        ((PInt)localObject1).value = this.UJi.getIntent().getIntExtra("Voip_Call_From", -1);
        bool = ((PBool)localObject2).value;
        if (bool) {
          try
          {
            if ((fwe()) && (!this.UJi.isFinishing()))
            {
              Toast.makeText(this.UJi, b.g.voip_in_phone_tip, 0).show();
              Log.i("MicroMsg.Voip.VideoActivityController", "this phone is on a call");
              SubCoreVoip.hVp().unRegister();
              this.UJi.ias();
              AppMethodBeat.o(292631);
              return;
            }
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.Voip.VideoActivityController", "not ready now!");
          }
        }
        com.tencent.mm.plugin.voip.f.f localf;
        if (com.tencent.mm.plugin.voip.f.f.ibe())
        {
          localf = com.tencent.mm.plugin.voip.f.f.ULF;
          com.tencent.mm.plugin.voip.f.f.ibn();
        }
        if (paramBundle.value != SubCoreVoip.hVp().hVw())
        {
          if (SubCoreVoip.hVp().hVw() != 0L)
          {
            localf = com.tencent.mm.plugin.voip.f.f.ULF;
            com.tencent.mm.plugin.voip.f.f.ibg();
            if (((PBool)localObject2).value) {
              break label1442;
            }
            if (SubCoreVoip.hVp().UBE.hWB())
            {
              break label1442;
              localf = com.tencent.mm.plugin.voip.f.f.ULF;
              com.tencent.mm.plugin.voip.f.f.a(((PInt)localObject1).value, true, paramBundle.value, SubCoreVoip.hVp().hVw(), bool);
            }
          }
          else
          {
            if ((!com.tencent.mm.plugin.voip.f.f.ibe()) || (SubCoreVoip.hVp().hVw() == 0L)) {
              continue;
            }
            Log.e("MicroMsg.Voip.VideoActivityController", "fake calling comming and forbid itself cause key is no similar");
            SubCoreVoip.hVp().unRegister();
            this.UJi.ias();
            AppMethodBeat.o(292631);
            return;
          }
          bool = false;
          continue;
        }
        else
        {
          localf = com.tencent.mm.plugin.voip.f.f.ULF;
          com.tencent.mm.plugin.voip.f.f.ibh();
          if (((PBool)localObject2).value) {
            break label1447;
          }
          if (!SubCoreVoip.hVp().UBE.hWB()) {
            continue;
          }
          break label1447;
          localf = com.tencent.mm.plugin.voip.f.f.ULF;
          com.tencent.mm.plugin.voip.f.f.a(((PInt)localObject1).value, false, paramBundle.value, SubCoreVoip.hVp().hVw(), bool);
        }
        if ((!((PBool)localObject2).value) && (!SubCoreVoip.hVp().UBE.hWB()) && (com.tencent.mm.plugin.voip.f.f.ibf()))
        {
          Log.e("MicroMsg.Voip.VideoActivityController", "fake calling comming and forbid itself cause engine is close");
          SubCoreVoip.hVp().unRegister();
          localObject2 = com.tencent.mm.plugin.voip.f.f.ULF;
          com.tencent.mm.plugin.voip.f.f.ibl();
          localObject2 = com.tencent.mm.plugin.voip.f.f.ULF;
          com.tencent.mm.plugin.voip.f.f.a(((PInt)localObject1).value, true, paramBundle.value, SubCoreVoip.hVp().hVw(), true);
          localObject1 = com.tencent.mm.plugin.voip.f.f.ULF;
          localObject1 = SubCoreVoip.hVp();
          long l = paramBundle.value;
          paramBundle = (Boolean)((u)localObject1).UCd.get(Long.valueOf(l));
          if (paramBundle == null)
          {
            bool = false;
            if (bool)
            {
              com.tencent.mm.plugin.voip.f.f.ibo();
              this.UJi.ias();
              AppMethodBeat.o(292631);
              return;
              bool = false;
            }
          }
          else
          {
            bool = paramBundle.booleanValue();
            continue;
          }
          com.tencent.mm.plugin.voip.f.f.ibp();
          continue;
        }
        paramBundle = SubCoreVoip.hVp().a(this.UJi, localPString, (PBool)localObject2, localPBool, localPInt, paramBundle, null);
      }
      catch (Exception paramBundle)
      {
        g.arb(2);
        Log.printErrStackTrace("MicroMsg.Voip.VideoActivityController", paramBundle, "", new Object[0]);
        AppMethodBeat.o(292631);
        return;
      }
      if (paramBundle == null)
      {
        Log.e("MicroMsg.Voip.VideoActivityController", "unable to init VoipMgr");
        SubCoreVoip.hVp().unRegister();
        this.UJi.ias();
        AppMethodBeat.o(292631);
        return;
      }
      this.UJb = new WeakReference(paramBundle);
      this.luk = localPString.value;
      this.Uxc = localPBool.value;
      this.Uxb = ((PBool)localObject2).value;
      if (this.mStatus == -1) {}
      for (int i = localPInt.value;; i = this.mStatus)
      {
        this.mStatus = i;
        this.Uxa = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(this.luk);
        paramBundle = new Bundle();
        paramBundle.putString("key_username", this.Uxa.field_username);
        paramBundle.putBoolean("key_isoutcall", this.Uxb);
        paramBundle.putInt("key_status", com.tencent.mm.plugin.voip.f.k.bw(this.Uxb, this.Uxc));
        if (!com.tencent.mm.plugin.voip.f.k.arn(this.mStatus)) {
          break;
        }
        SubCoreVoip.hVp().unRegister();
        Log.i("MicroMsg.Voip.VideoActivityController", "current is run on failed");
        this.UJi.ias();
        AppMethodBeat.o(292631);
        return;
      }
      if (com.tencent.mm.plugin.voip.f.k.ark(this.mStatus)) {}
      for (this.UJa = new NewVoipVideoFragment();; this.UJa = new VoipVoiceFragment())
      {
        this.UJa.setArguments(paramBundle);
        this.UJi.getSupportFragmentManager().beginTransaction().b(b.d.voip_container, this.UJa).FW();
        this.UJi.setTitleVisibility(8);
        if ((com.tencent.mm.plugin.voip.f.k.arl(this.mStatus)) && (this.Uxb)) {
          this.qse.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(292367);
              if ((com.tencent.mm.plugin.voip.f.k.arl(e.b(e.this))) && (!e.c(e.this)) && (e.d(e.this) != null)) {
                e.d(e.this).mE(b.g.voip_callout_timeout_prompt, 10000);
              }
              AppMethodBeat.o(292367);
            }
          }, 20000L);
        }
        if (SubCoreVoip.hVp().UBF.hVj() != null) {
          aDJ(SubCoreVoip.hVp().UBF.hVj());
        }
        if (this.Uxc) {
          s.kx(this.UJi);
        }
        this.JPY = new com.tencent.mm.plugin.voip.c.b(new com.tencent.mm.plugin.ball.a.e(this.UJi));
        this.JPY.J(9, "VOIPFloatBall");
        if ((this.UJb != null) && (this.UJb.get() != null)) {
          ((c)this.UJb.get()).a(this.UJi, 1);
        }
        this.UJa.setVoipUIListener((c)this.UJb.get());
        this.UJa.a(this);
        this.UJa.setMute(this.mIsMute);
        Log.i("MicroMsg.Voip.VideoActivityController", "VideoActivity onCreate end isOutCall:%b isVideoCall:%b username:%s state:%d", new Object[] { Boolean.valueOf(this.Uxb), Boolean.valueOf(this.Uxc), this.luk, Integer.valueOf(this.mStatus) });
        this.mIj.alive();
        this.Hnz.alive();
        if (com.tencent.mm.compatible.util.d.rb(17))
        {
          this.nGU = new Point();
          if (this.UJi.getWindow().getDecorView().getDisplay() != null) {
            this.UJi.getWindow().getDecorView().getDisplay().getRealSize(this.nGU);
          }
        }
        AppMethodBeat.o(292631);
        return;
      }
      label1442:
      boolean bool = true;
      continue;
      label1447:
      bool = true;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(292692);
    this.UJf = 4;
    Log.i("MicroMsg.Voip.VideoActivityController", "onDestroy, status: %s", new Object[] { com.tencent.mm.plugin.voip.f.k.arg(this.mStatus) });
    t localt = t.UBA;
    t.hXQ();
    if (!this.JQR) {
      finish();
    }
    if ((this.UJb != null) && (this.UJb.get() != null)) {
      ((c)this.UJb.get()).a(this.UJi);
    }
    if (this.JPY != null) {
      this.JPY.onDestroy();
    }
    this.mIj.dead();
    this.Hnz.dead();
    this.UJi.iat();
    if (!this.UJe) {
      com.tencent.mm.media.g.c.nAB.bpx();
    }
    AppMethodBeat.o(292692);
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(292681);
    if (paramKeyEvent.getKeyCode() == 4)
    {
      AppMethodBeat.o(292681);
      return true;
    }
    if (!com.tencent.mm.plugin.ringtone.c.gOk())
    {
      if (paramInt == 25)
      {
        if (!SubCoreVoip.hVp().dro())
        {
          if (com.tencent.mm.plugin.audio.c.a.cTW().cTV()) {}
          for (paramInt = com.tencent.mm.plugin.audio.c.a.cTR();; paramInt = ((com.tencent.mm.plugin.ringtone.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ringtone.a.class)).getStreamType())
          {
            com.tencent.mm.plugin.audio.c.a.EZ(paramInt);
            AppMethodBeat.o(292681);
            return true;
          }
        }
        if (com.tencent.mm.plugin.audio.c.a.cTW().cTV()) {}
        for (paramInt = com.tencent.mm.plugin.audio.c.a.cTR();; paramInt = fwf())
        {
          com.tencent.mm.plugin.audio.c.a.EZ(paramInt);
          break;
        }
      }
      if (paramInt == 24)
      {
        if (!SubCoreVoip.hVp().dro())
        {
          if (com.tencent.mm.plugin.audio.c.a.cTW().cTV()) {}
          for (paramInt = com.tencent.mm.plugin.audio.c.a.cTR();; paramInt = ((com.tencent.mm.plugin.ringtone.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ringtone.a.class)).getStreamType())
          {
            com.tencent.mm.plugin.audio.c.a.EY(paramInt);
            AppMethodBeat.o(292681);
            return true;
          }
        }
        if (com.tencent.mm.plugin.audio.c.a.cTW().cTV()) {}
        for (paramInt = com.tencent.mm.plugin.audio.c.a.cTR();; paramInt = fwf())
        {
          com.tencent.mm.plugin.audio.c.a.EY(paramInt);
          break;
        }
      }
    }
    else if (paramInt == 25)
    {
      if ((!SubCoreVoip.hVp().dro()) && (this.Uxb))
      {
        if (com.tencent.mm.plugin.audio.c.a.cTW().cTV()) {}
        for (paramInt = com.tencent.mm.plugin.audio.c.a.cTR();; paramInt = ((com.tencent.mm.plugin.ringtone.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ringtone.a.class)).getStreamType())
        {
          com.tencent.mm.plugin.audio.c.a.EZ(paramInt);
          AppMethodBeat.o(292681);
          return true;
        }
      }
    }
    else if ((paramInt == 24) && (this.Uxb) && (!SubCoreVoip.hVp().dro()))
    {
      if (com.tencent.mm.plugin.audio.c.a.cTW().cTV()) {}
      for (paramInt = com.tencent.mm.plugin.audio.c.a.cTR();; paramInt = ((com.tencent.mm.plugin.ringtone.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.ringtone.a.class)).getStreamType())
      {
        com.tencent.mm.plugin.audio.c.a.EY(paramInt);
        AppMethodBeat.o(292681);
        return true;
      }
    }
    if ((af.lXY.lSU == 1) && (paramInt == 700))
    {
      fwg();
      AppMethodBeat.o(292681);
      return true;
    }
    AppMethodBeat.o(292681);
    return false;
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(292733);
    Log.i("MicroMsg.Voip.VideoActivityController", "onNewIntent");
    AppMethodBeat.o(292733);
  }
  
  public final void onOrientationChange(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(292877);
    paramInt = i;
    switch (((WindowManager)this.UJi.getSystemService("window")).getDefaultDisplay().getRotation())
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      if ((this.UJb != null) && (this.UJb.get() != null) && (this.UJa != null)) {
        ((c)this.UJb.get()).apT(paramInt);
      }
      if (this.UJa != null) {
        this.UJa.aqW(paramInt);
      }
      AppMethodBeat.o(292877);
      return;
      paramInt = 180;
      continue;
      paramInt = 90;
      continue;
      paramInt = 270;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(292738);
    KeyguardManager localKeyguardManager = (KeyguardManager)MMApplicationContext.getContext().getSystemService("keyguard");
    PowerManager localPowerManager = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
    boolean bool2 = localKeyguardManager.inKeyguardRestrictedInputMode();
    boolean bool3 = this.UJi.hasWindowFocus();
    boolean bool4 = localPowerManager.isScreenOn();
    if (((bool3) || (!bool2)) && (bool4)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.JQS = bool1;
      Log.i("MicroMsg.Voip.VideoActivityController", "onPause, status: %s, screenOn: %b, hasWindowFocus: %s, isScreenLocked: %s, isScreenOn: %s", new Object[] { com.tencent.mm.plugin.voip.f.k.arg(this.mStatus), Boolean.valueOf(this.JQS), Boolean.valueOf(bool3), Boolean.valueOf(bool2), Boolean.valueOf(bool4) });
      AppMethodBeat.o(292738);
      return;
    }
  }
  
  public final void onPostResume() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(292859);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      Log.i("MicroMsg.Voip.VideoActivityController", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(292859);
      return;
    }
    Log.i("MicroMsg.Voip.VideoActivityController", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(292859);
      return;
      if (paramArrayOfInt[0] != 0)
      {
        if ("android.permission.CAMERA".equals(paramArrayOfString[0])) {}
        for (paramInt = b.g.permission_camera_request_again_msg;; paramInt = b.g.permission_microphone_request_again_msg)
        {
          com.tencent.mm.ui.base.k.a(this.UJi, this.UJi.getString(paramInt), this.UJi.getString(b.g.permission_tips_title), this.UJi.getString(b.g.jump_to_settings), this.UJi.getString(b.g.app_cancel), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(292366);
              paramAnonymousDialogInterface.dismiss();
              com.tencent.mm.pluginsdk.permission.b.lx(e.g(e.this));
              AppMethodBeat.o(292366);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(292360);
              paramAnonymousDialogInterface.dismiss();
              AppMethodBeat.o(292360);
            }
          });
          AppMethodBeat.o(292859);
          return;
        }
        if (paramArrayOfInt[0] != 0) {
          com.tencent.mm.ui.base.k.a(this.UJi, this.UJi.getString(b.g.permission_microphone_request_again_msg), this.UJi.getString(b.g.permission_tips_title), this.UJi.getString(b.g.jump_to_settings), this.UJi.getString(b.g.app_cancel), false, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(292361);
              com.tencent.mm.pluginsdk.permission.b.lx(e.g(e.this));
              AppMethodBeat.o(292361);
            }
          }, null);
        }
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(292745);
    Log.i("MicroMsg.Voip.VideoActivityController", "onResume, status: %s", new Object[] { com.tencent.mm.plugin.voip.f.k.arg(this.mStatus) });
    ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification().cancel(40);
    l locall = SubCoreVoip.hVp().UBE.UvO;
    if (locall.UyG) {
      locall.UyG = false;
    }
    if ((this.UJb != null) && (this.UJb.get() != null)) {
      ((c)this.UJb.get()).hVP();
    }
    onOrientationChange(0);
    this.UJi.iat();
    this.UJd = Util.currentTicks();
    this.UJh = true;
    if ((this.UJb != null) && (this.UJb.get() != null)) {
      ((c)this.UJb.get()).hVQ();
    }
    if ((this.JPY != null) && (!this.LrJ))
    {
      this.JPY.bhT();
      com.tencent.mm.plugin.ball.f.f.d(true, false, true);
    }
    AppMethodBeat.o(292745);
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {}
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
  
  public final void onStart()
  {
    AppMethodBeat.i(292708);
    if (this.Uxc)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this.UJi, "android.permission.CAMERA", 19, "");
      Log.i("MicroMsg.Voip.VideoActivityController", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), Util.getStack(), this });
      SubCoreVoip.hVp().UBW = bool;
      Log.i("MicroMsg.Voip.VideoActivityController", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this.UJi, "android.permission.RECORD_AUDIO", 19, "")), Util.getStack(), this });
    }
    for (;;)
    {
      if (!this.JQR)
      {
        Log.i("MicroMsg.Voip.VideoActivityController", "onStart");
        this.UJf = 1;
        iU(4096, this.mStatus);
      }
      AppMethodBeat.o(292708);
      return;
      Log.i("MicroMsg.Voip.VideoActivityController", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.pluginsdk.permission.b.a(this.UJi, "android.permission.RECORD_AUDIO", 82, "")), Util.getStack(), this });
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(292699);
    this.UJf = 2;
    Log.i("MicroMsg.Voip.VideoActivityController", "onStop, status: %s", new Object[] { com.tencent.mm.plugin.voip.f.k.arg(this.mStatus) });
    com.tencent.mm.plugin.report.service.h localh;
    if ((262 != this.mStatus) && (8 != this.mStatus) && (this.JQS) && (!this.LrJ) && (!this.JQR) && (this.UJb != null) && (this.UJb.get() != null) && (((c)this.UJb.get()).Gn(false)))
    {
      if (this.UJa != null) {
        this.UJa.iaL();
      }
      aq(false, true);
      if (com.tencent.mm.plugin.voip.f.k.arj(this.mStatus))
      {
        localh = com.tencent.mm.plugin.report.service.h.OAn;
        if (!com.tencent.mm.plugin.voip.f.k.ark(this.mStatus)) {
          break label214;
        }
      }
    }
    label214:
    for (int i = 2;; i = 3)
    {
      localh.b(11618, new Object[] { Integer.valueOf(i), Integer.valueOf(2) });
      if ((this.JPY != null) && (!this.LrJ))
      {
        this.JPY.bhW();
        com.tencent.mm.plugin.ball.f.f.d(false, true, true);
      }
      AppMethodBeat.o(292699);
      return;
    }
  }
  
  public final void onTrimMemory(int paramInt) {}
  
  public final boolean onUserLeaveHint()
  {
    return false;
  }
  
  public final void setConnectSec(long paramLong)
  {
    AppMethodBeat.i(292842);
    this.UJc = paramLong;
    if (this.UJa != null) {
      this.UJa.wU(this.UJc);
    }
    AppMethodBeat.o(292842);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(292801);
    this.mIsMute = paramBoolean;
    if (this.UJa != null) {
      this.UJa.setMute(paramBoolean);
    }
    AppMethodBeat.o(292801);
  }
  
  public final void setScreenEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(292726);
    if (this.UJb != null) {
      this.UJb.get();
    }
    AppMethodBeat.o(292726);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(292796);
    if (this.Uxg != -1) {
      switch (paramInt)
      {
      default: 
        if (!this.Uxc) {
          this.UJi.iat();
        }
        break;
      }
    }
    for (;;)
    {
      this.Uxg = paramInt;
      if ((this.UJb != null) && (this.UJb.get() != null)) {
        ((c)this.UJb.get()).setVoicePlayDevice(paramInt);
      }
      if (this.UJa != null) {
        this.UJa.setVoicePlayDevice(paramInt);
      }
      AppMethodBeat.o(292796);
      return;
      Toast.makeText(this.UJi.getContext(), this.UJi.getContext().getString(b.g.voip_voice_come_from_speaker), 0).show();
      if (!this.Uxc)
      {
        this.UJi.iat();
        continue;
        Toast.makeText(this.UJi.getContext(), this.UJi.getContext().getString(b.g.voip_voice_come_from_earpiece), 0).show();
      }
    }
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(292839);
    if (this.UJa != null) {
      this.UJa.uninit();
    }
    AppMethodBeat.o(292839);
  }
  
  public final void vJ(boolean paramBoolean)
  {
    AppMethodBeat.i(292846);
    Log.d("MicroMsg.Voip.VideoActivityController", "tryShowNetStatusWarning isSelfNetBad".concat(String.valueOf(paramBoolean)));
    if (this.UJa != null) {
      this.UJa.GA(paramBoolean);
    }
    AppMethodBeat.o(292846);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.e
 * JD-Core Version:    0.7.0.1
 */