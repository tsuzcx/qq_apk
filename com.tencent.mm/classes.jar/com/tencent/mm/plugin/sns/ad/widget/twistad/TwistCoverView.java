package com.tencent.mm.plugin.sns.ad.widget.twistad;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.graphics.Color;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.e.m;
import com.tencent.mm.plugin.sns.ad.e.m.a;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.storage.ADXml.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ah;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class TwistCoverView
  extends FrameLayout
  implements LifecycleObserver
{
  private Handler DAC;
  private TwistDegreeView DBK;
  private ImageView DBL;
  private volatile ADXml.k DBM;
  private m DBN;
  private boolean DBO;
  private boolean DBP;
  private boolean DBQ;
  private boolean DBR;
  private boolean DBS;
  private boolean DBT;
  private boolean DBU;
  private boolean DBV;
  private boolean DBW;
  private float DBX;
  private m.a DBY;
  private a DBZ;
  private SnsInfo DqO;
  private TextView Xy;
  private int mScene;
  private AnimatorSet xc;
  private TextView zpl;
  
  public TwistCoverView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(202500);
    this.DBO = false;
    this.DBP = false;
    this.DBQ = false;
    this.DBR = false;
    this.DBS = true;
    this.DBT = false;
    this.DBU = false;
    this.DBV = false;
    this.DBW = false;
    this.DAC = new Handler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(202495);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(202495);
          return;
          TwistCoverView.a(TwistCoverView.this, paramAnonymousMessage.arg1);
          AppMethodBeat.o(202495);
          return;
          TwistCoverView.a(TwistCoverView.this, paramAnonymousMessage.arg1 / 1000.0F);
          AppMethodBeat.o(202495);
          return;
          TwistCoverView.a(TwistCoverView.this);
          AppMethodBeat.o(202495);
          return;
          if ((TwistCoverView.b(TwistCoverView.this) != null) && (!TwistCoverView.b(TwistCoverView.this).isRunning())) {
            TwistCoverView.b(TwistCoverView.this).start();
          }
        }
      }
    };
    this.DBX = 0.0F;
    this.DBY = new m.a()
    {
      public final void bS(float paramAnonymousFloat)
      {
        AppMethodBeat.i(202497);
        Object localObject = TwistCoverView.c(TwistCoverView.this);
        if (localObject == null)
        {
          AppMethodBeat.o(202497);
          return;
        }
        float f = paramAnonymousFloat;
        if (((ADXml.k)localObject).DWV)
        {
          f = paramAnonymousFloat;
          if (paramAnonymousFloat > 0.0F) {
            f = 0.0F;
          }
        }
        paramAnonymousFloat = f;
        if (!((ADXml.k)localObject).DWV)
        {
          paramAnonymousFloat = f;
          if (f < 0.0F) {
            paramAnonymousFloat = 0.0F;
          }
        }
        f = Math.abs(paramAnonymousFloat / ((ADXml.k)localObject).DWU);
        if (Math.abs(paramAnonymousFloat) > TwistCoverView.d(TwistCoverView.this)) {
          TwistCoverView.b(TwistCoverView.this, Math.abs(paramAnonymousFloat));
        }
        localObject = Message.obtain(TwistCoverView.e(TwistCoverView.this), 2);
        ((Message)localObject).arg1 = ((int)(f * 1000.0F));
        ((Message)localObject).sendToTarget();
        AppMethodBeat.o(202497);
      }
      
      public final void eWR()
      {
        AppMethodBeat.i(202498);
        Message.obtain(TwistCoverView.e(TwistCoverView.this), 3).sendToTarget();
        AppMethodBeat.o(202498);
      }
    };
    init(paramContext);
    AppMethodBeat.o(202500);
  }
  
  public TwistCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(202501);
    this.DBO = false;
    this.DBP = false;
    this.DBQ = false;
    this.DBR = false;
    this.DBS = true;
    this.DBT = false;
    this.DBU = false;
    this.DBV = false;
    this.DBW = false;
    this.DAC = new Handler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(202495);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(202495);
          return;
          TwistCoverView.a(TwistCoverView.this, paramAnonymousMessage.arg1);
          AppMethodBeat.o(202495);
          return;
          TwistCoverView.a(TwistCoverView.this, paramAnonymousMessage.arg1 / 1000.0F);
          AppMethodBeat.o(202495);
          return;
          TwistCoverView.a(TwistCoverView.this);
          AppMethodBeat.o(202495);
          return;
          if ((TwistCoverView.b(TwistCoverView.this) != null) && (!TwistCoverView.b(TwistCoverView.this).isRunning())) {
            TwistCoverView.b(TwistCoverView.this).start();
          }
        }
      }
    };
    this.DBX = 0.0F;
    this.DBY = new m.a()
    {
      public final void bS(float paramAnonymousFloat)
      {
        AppMethodBeat.i(202497);
        Object localObject = TwistCoverView.c(TwistCoverView.this);
        if (localObject == null)
        {
          AppMethodBeat.o(202497);
          return;
        }
        float f = paramAnonymousFloat;
        if (((ADXml.k)localObject).DWV)
        {
          f = paramAnonymousFloat;
          if (paramAnonymousFloat > 0.0F) {
            f = 0.0F;
          }
        }
        paramAnonymousFloat = f;
        if (!((ADXml.k)localObject).DWV)
        {
          paramAnonymousFloat = f;
          if (f < 0.0F) {
            paramAnonymousFloat = 0.0F;
          }
        }
        f = Math.abs(paramAnonymousFloat / ((ADXml.k)localObject).DWU);
        if (Math.abs(paramAnonymousFloat) > TwistCoverView.d(TwistCoverView.this)) {
          TwistCoverView.b(TwistCoverView.this, Math.abs(paramAnonymousFloat));
        }
        localObject = Message.obtain(TwistCoverView.e(TwistCoverView.this), 2);
        ((Message)localObject).arg1 = ((int)(f * 1000.0F));
        ((Message)localObject).sendToTarget();
        AppMethodBeat.o(202497);
      }
      
      public final void eWR()
      {
        AppMethodBeat.i(202498);
        Message.obtain(TwistCoverView.e(TwistCoverView.this), 3).sendToTarget();
        AppMethodBeat.o(202498);
      }
    };
    init(paramContext);
    AppMethodBeat.o(202501);
  }
  
  private void a(int paramInt, boolean paramBoolean, float paramFloat)
  {
    int i = 1;
    AppMethodBeat.i(202522);
    if (this.DqO == null)
    {
      Log.e("TwistCoverView_report", "reportTwistActionResult, snsInfo==null");
      AppMethodBeat.o(202522);
      return;
    }
    Object localObject2 = this.DqO;
    Object localObject1 = r.Jb(((SnsInfo)localObject2).field_snsId);
    String str = ((SnsInfo)localObject2).getUxinfo();
    int j = this.mScene;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      Log.e("TwistCoverView_report", "reportTwistActionResult, snsId==null, source=".concat(String.valueOf(j)));
      AppMethodBeat.o(202522);
      return;
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      Log.e("TwistCoverView_report", "reportTwistActionResult, snsId==null, source=".concat(String.valueOf(j)));
      AppMethodBeat.o(202522);
      return;
    }
    try
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("snsid", localObject1);
      ((JSONObject)localObject2).put("uxinfo", Util.nullAsNil(str));
      ((JSONObject)localObject2).put("scene", j);
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("result", paramInt);
      if (paramBoolean) {}
      for (paramInt = i;; paramInt = 0)
      {
        ((JSONObject)localObject1).put("triggerByAcceleration", paramInt);
        ((JSONObject)localObject1).put("failedMaxDegree", Math.round(paramFloat));
        if (!this.DBW) {
          ((JSONObject)localObject1).put("sensorDisable", 1);
        }
        ((JSONObject)localObject2).put("extInfo", localObject1);
        localObject1 = ((JSONObject)localObject2).toString();
        k.jY("timeline_twistad_twist_result", (String)localObject1);
        Log.i("TwistCoverView_report", "reportTwistActionResult, content=".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(202522);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("TwistCoverView_report", "reportTwistActionResult exp:" + localException.toString());
      AppMethodBeat.o(202522);
    }
  }
  
  public static void a(ah paramah, int paramInt)
  {
    AppMethodBeat.i(202521);
    if (paramah == null)
    {
      Log.e("TwistCoverView_report", "reportGetTwistIdResult, landingPageData==null");
      AppMethodBeat.o(202521);
      return;
    }
    Object localObject = paramah.getSnsId();
    String str = paramah.uxInfo;
    int i = paramah.source;
    try
    {
      paramah = new JSONObject();
      paramah.put("snsid", Util.nullAsNil((String)localObject));
      paramah.put("uxinfo", Util.nullAsNil(str));
      paramah.put("scene", i);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("result", paramInt);
      paramah.put("extInfo", localObject);
      paramah = paramah.toString();
      k.jY("timeline_twistad_canvas_get_twist_cardId_result", paramah);
      Log.i("TwistCoverView_report", "reportGetTwistIdResult, content=".concat(String.valueOf(paramah)));
      AppMethodBeat.o(202521);
      return;
    }
    catch (Exception paramah)
    {
      Log.e("TwistCoverView_report", "reportGetTwistIdResult exp:" + paramah.toString());
      AppMethodBeat.o(202521);
    }
  }
  
  private void bh(Context paramContext)
  {
    AppMethodBeat.i(202503);
    LayoutInflater.from(paramContext).inflate(2131496408, this, true);
    this.DBK = ((TwistDegreeView)findViewById(2131309553));
    this.DBL = ((ImageView)findViewById(2131305879));
    this.Xy = ((TextView)findViewById(2131309251));
    this.zpl = ((TextView)findViewById(2131299512));
    setBackgroundColor(Color.parseColor("#CC000000"));
    AppMethodBeat.o(202503);
  }
  
  private void eYJ()
  {
    AppMethodBeat.i(202512);
    StringBuilder localStringBuilder = new StringBuilder("resetTwistAngle, sensorMgr==null?");
    if (this.DBN == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("TwistCoverView", bool);
      if (this.DBN != null) {
        this.DBN.reset();
      }
      this.DBK.eYR();
      this.DBO = false;
      this.DBX = 0.0F;
      AppMethodBeat.o(202512);
      return;
    }
  }
  
  private boolean eYK()
  {
    AppMethodBeat.i(202514);
    if (this.DBN != null)
    {
      boolean bool = this.DBN.Dtd;
      AppMethodBeat.o(202514);
      return bool;
    }
    Log.i("TwistCoverView", "isSensorEnabled, sensorMgr==null");
    AppMethodBeat.o(202514);
    return false;
  }
  
  private void eYL()
  {
    AppMethodBeat.i(202516);
    if ((this.DBZ != null) && (!this.DBO))
    {
      this.DBZ.eYQ();
      this.DBO = true;
    }
    this.DBV = true;
    AppMethodBeat.o(202516);
  }
  
  private void eYM()
  {
    AppMethodBeat.i(202517);
    this.DAC.removeMessages(4);
    if ((this.xc != null) && (!this.xc.isRunning()))
    {
      Log.d("TwistCoverView", "startIconAnim");
      this.xc.start();
    }
    AppMethodBeat.o(202517);
  }
  
  private void eYN()
  {
    AppMethodBeat.i(202518);
    this.DAC.removeMessages(4);
    if ((this.xc != null) && (this.xc.isRunning()))
    {
      Log.d("TwistCoverView", "pauseIconAnim");
      this.xc.pause();
    }
    AppMethodBeat.o(202518);
  }
  
  private void eYO()
  {
    AppMethodBeat.i(202519);
    this.DAC.removeMessages(4);
    StringBuilder localStringBuilder = new StringBuilder("resumeIconAnim, isUIPaused=").append(this.DBR).append(", anim.isPaused=");
    if (this.xc == null) {}
    for (boolean bool = false;; bool = this.xc.isPaused())
    {
      Log.d("TwistCoverView", bool);
      if ((this.xc == null) || (this.DBR)) {
        break label113;
      }
      if (!this.xc.isPaused()) {
        break;
      }
      this.xc.resume();
      AppMethodBeat.o(202519);
      return;
    }
    eYM();
    label113:
    AppMethodBeat.o(202519);
  }
  
  private void eYP()
  {
    AppMethodBeat.i(202520);
    if (this.xc != null)
    {
      Log.d("TwistCoverView", "stopIconAnim");
      this.DAC.removeMessages(4);
      this.xc.removeAllListeners();
      this.xc.end();
      this.xc = null;
    }
    AppMethodBeat.o(202520);
  }
  
  private void hide()
  {
    AppMethodBeat.i(202515);
    if (!this.DBP)
    {
      AppMethodBeat.o(202515);
      return;
    }
    this.DBP = false;
    Log.i("TwistCoverView", "hide");
    eYP();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(250L);
    localObjectAnimator.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(202496);
        TwistCoverView.this.setVisibility(8);
        AppMethodBeat.o(202496);
      }
    });
    localObjectAnimator.start();
    AppMethodBeat.o(202515);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(202502);
    bh(paramContext);
    if ((paramContext instanceof LifecycleOwner)) {
      ((LifecycleOwner)paramContext).getLifecycle().addObserver(this);
    }
    AppMethodBeat.o(202502);
  }
  
  public final void IW(long paramLong)
  {
    AppMethodBeat.i(202505);
    Message localMessage = Message.obtain(this.DAC, 1);
    localMessage.arg1 = ((int)paramLong);
    localMessage.sendToTarget();
    AppMethodBeat.o(202505);
  }
  
  public final void a(SnsInfo paramSnsInfo, ADXml.k paramk, int paramInt)
  {
    AppMethodBeat.i(202504);
    this.DBM = paramk;
    this.DqO = paramSnsInfo;
    this.mScene = paramInt;
    if ((this.DBM != null) && (paramSnsInfo != null))
    {
      Log.i("TwistCoverView", "initData, id=" + r.Jb(paramSnsInfo.field_snsId) + ", twistInfo=" + this.DBM + ", scene=" + paramInt);
      paramSnsInfo = getContext();
      if (this.DBN == null)
      {
        this.DBN = new m(paramSnsInfo);
        this.DBN.Dti = this.DBY;
        if (this.DBN.Dtc == null) {
          break label169;
        }
      }
    }
    label169:
    for (boolean bool = true;; bool = false)
    {
      this.DBW = bool;
      Log.i("TwistCoverView", "initSensor, isSensorOk=" + this.DBW);
      AppMethodBeat.o(202504);
      return;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(202511);
    this.DBQ = false;
    this.DBM = null;
    this.DqO = null;
    this.DBX = 0.0F;
    this.mScene = -1;
    setSensorEnabled(false);
    hide();
    this.DAC.removeCallbacksAndMessages(null);
    AppMethodBeat.o(202511);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(202509);
    super.onDetachedFromWindow();
    Log.i("TwistCoverView", "onDetachedFromWindow");
    if ((this.DBU) && (!this.DBV)) {
      a(2, false, this.DBX);
    }
    clear();
    this.DBS = true;
    this.DBT = false;
    this.DBV = false;
    AppMethodBeat.o(202509);
  }
  
  public final void onPlayerPaused()
  {
    AppMethodBeat.i(202508);
    if (this.DBM == null)
    {
      AppMethodBeat.o(202508);
      return;
    }
    Log.i("TwistCoverView", "onPlayerPaused");
    this.DBQ = true;
    setSensorEnabled(false);
    eYN();
    this.DAC.removeMessages(1);
    AppMethodBeat.o(202508);
  }
  
  public void onStartTemporaryDetach()
  {
    AppMethodBeat.i(202510);
    super.onStartTemporaryDetach();
    if (Build.VERSION.SDK_INT < 24)
    {
      Log.i("TwistCoverView", "onStartTemporaryDetach");
      clear();
    }
    AppMethodBeat.o(202510);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void onUIPause()
  {
    AppMethodBeat.i(202507);
    if (this.DBM == null)
    {
      AppMethodBeat.o(202507);
      return;
    }
    Log.i("TwistCoverView", "onUIPause");
    this.DBR = true;
    setSensorEnabled(false);
    if (this.DBP) {
      eYN();
    }
    AppMethodBeat.o(202507);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public void onUIResume()
  {
    AppMethodBeat.i(202506);
    if (this.DBM == null)
    {
      AppMethodBeat.o(202506);
      return;
    }
    Log.i("TwistCoverView", "onUIResume, isTwistActionCalled=" + this.DBO);
    this.DBR = false;
    if ((this.DBO) && (getVisibility() == 0)) {
      eYO();
    }
    eYJ();
    AppMethodBeat.o(202506);
  }
  
  public void setSensorEnabled(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(202513);
    if ((this.DBM == null) && (paramBoolean))
    {
      AppMethodBeat.o(202513);
      return;
    }
    if (((this.DBQ) || (this.DBR)) && (paramBoolean))
    {
      Log.e("TwistCoverView", "setSensorEnabled to true when isUIPaused=" + this.DBR + ", isPlayerPaused=" + this.DBQ);
      AppMethodBeat.o(202513);
      return;
    }
    Object localObject = new StringBuilder("setSensorEnabled, enabled=").append(paramBoolean).append(", sensorMgr==null?");
    if (this.DBN == null) {}
    for (;;)
    {
      Log.i("TwistCoverView", bool);
      if (this.DBN != null)
      {
        localObject = this.DBN;
        if (((m)localObject).Dtc != null)
        {
          if (!paramBoolean) {
            break;
          }
          try
          {
            if (((m)localObject).Dtd) {
              break label241;
            }
            ((m)localObject).Dtg = 0L;
            ((m)localObject).mSensorManager.registerListener(((m)localObject).Dth, ((m)localObject).Dtc, 1);
            ((m)localObject).Dtd = true;
            AppMethodBeat.o(202513);
            return;
          }
          catch (Throwable localThrowable)
          {
            new StringBuilder("setEnabled exp=").append(localThrowable.toString());
          }
        }
      }
      AppMethodBeat.o(202513);
      return;
      bool = false;
    }
    localThrowable.mSensorManager.unregisterListener(localThrowable.Dth);
    localThrowable.Dtd = false;
    label241:
    AppMethodBeat.o(202513);
  }
  
  public void setTwistActionListener(a parama)
  {
    this.DBZ = parama;
  }
  
  public static abstract interface a
  {
    public abstract void eYQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView
 * JD-Core Version:    0.7.0.1
 */