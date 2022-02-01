package com.tencent.mm.plugin.sns.ad.widget.twistad;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
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
import androidx.lifecycle.h;
import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.d.r;
import com.tencent.mm.plugin.sns.ad.d.r.a;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.ADXml.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class TwistCoverView
  extends FrameLayout
  implements k
{
  private TextView EUI;
  private Handler JMp;
  private boolean JNT;
  private boolean JOa;
  private TwistDegreeView JOf;
  private ImageView JOg;
  private volatile ADXml.k JOh;
  private r JOi;
  private boolean JOj;
  private boolean JOk;
  private boolean JOl;
  private boolean JOm;
  private boolean JOn;
  private boolean JOo;
  private boolean JOp;
  private float JOq;
  private r.a JOr;
  private a JOs;
  private SnsInfo Jws;
  private AnimatorSet atV;
  private TextView eM;
  private int mScene;
  
  public TwistCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(230759);
    this.JOj = false;
    this.JOa = false;
    this.JOk = false;
    this.JNT = false;
    this.JOl = true;
    this.JOm = false;
    this.JOn = false;
    this.JOo = false;
    this.JOp = false;
    this.JMp = new Handler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(236982);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(236982);
          return;
          TwistCoverView.a(TwistCoverView.this, paramAnonymousMessage.arg1);
          AppMethodBeat.o(236982);
          return;
          TwistCoverView.a(TwistCoverView.this, paramAnonymousMessage.arg1 / 1000.0F);
          AppMethodBeat.o(236982);
          return;
          TwistCoverView.a(TwistCoverView.this);
          AppMethodBeat.o(236982);
          return;
          if ((TwistCoverView.b(TwistCoverView.this) != null) && (!TwistCoverView.b(TwistCoverView.this).isRunning())) {
            TwistCoverView.b(TwistCoverView.this).start();
          }
        }
      }
    };
    this.JOq = 0.0F;
    this.JOr = new r.a()
    {
      public final void bZ(float paramAnonymousFloat)
      {
        AppMethodBeat.i(199686);
        Object localObject = TwistCoverView.c(TwistCoverView.this);
        if (localObject == null)
        {
          AppMethodBeat.o(199686);
          return;
        }
        float f = paramAnonymousFloat;
        if (((ADXml.k)localObject).Kke)
        {
          f = paramAnonymousFloat;
          if (paramAnonymousFloat > 0.0F) {
            f = 0.0F;
          }
        }
        paramAnonymousFloat = f;
        if (!((ADXml.k)localObject).Kke)
        {
          paramAnonymousFloat = f;
          if (f < 0.0F) {
            paramAnonymousFloat = 0.0F;
          }
        }
        f = Math.abs(paramAnonymousFloat / ((ADXml.k)localObject).Kkd);
        if (Math.abs(paramAnonymousFloat) > TwistCoverView.d(TwistCoverView.this)) {
          TwistCoverView.b(TwistCoverView.this, Math.abs(paramAnonymousFloat));
        }
        localObject = Message.obtain(TwistCoverView.e(TwistCoverView.this), 2);
        ((Message)localObject).arg1 = ((int)(f * 1000.0F));
        ((Message)localObject).sendToTarget();
        AppMethodBeat.o(199686);
      }
      
      public final void fKc()
      {
        AppMethodBeat.i(199687);
        Message.obtain(TwistCoverView.e(TwistCoverView.this), 3).sendToTarget();
        AppMethodBeat.o(199687);
      }
    };
    LayoutInflater.from(paramContext).inflate(i.g.sns_ad_twist_cover_layout, this, true);
    this.JOf = ((TwistDegreeView)findViewById(i.f.twist_degree_view));
    this.JOg = ((ImageView)findViewById(i.f.phone_icon));
    this.eM = ((TextView)findViewById(i.f.title_txt));
    this.EUI = ((TextView)findViewById(i.f.desc_txt));
    setBackgroundColor(Color.parseColor("#CC000000"));
    if ((paramContext instanceof l)) {
      ((l)paramContext).getLifecycle().a(this);
    }
    AppMethodBeat.o(230759);
  }
  
  private void a(int paramInt, boolean paramBoolean, float paramFloat)
  {
    int i = 1;
    AppMethodBeat.i(230797);
    if (this.Jws == null)
    {
      Log.e("TwistCoverView_report", "reportTwistActionResult, snsInfo==null");
      AppMethodBeat.o(230797);
      return;
    }
    Object localObject2 = this.Jws;
    Object localObject1 = com.tencent.mm.plugin.sns.data.t.Qu(((SnsInfo)localObject2).field_snsId);
    String str = ((SnsInfo)localObject2).getUxinfo();
    int j = this.mScene;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      Log.e("TwistCoverView_report", "reportTwistActionResult, snsId==null, source=".concat(String.valueOf(j)));
      AppMethodBeat.o(230797);
      return;
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      Log.e("TwistCoverView_report", "reportTwistActionResult, snsId==null, source=".concat(String.valueOf(j)));
      AppMethodBeat.o(230797);
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
        if (!this.JOp) {
          ((JSONObject)localObject1).put("sensorDisable", 1);
        }
        ((JSONObject)localObject2).put("extInfo", localObject1);
        localObject1 = ((JSONObject)localObject2).toString();
        m.ks("timeline_twistad_twist_result", (String)localObject1);
        Log.i("TwistCoverView_report", "reportTwistActionResult, content=".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(230797);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("TwistCoverView_report", "reportTwistActionResult exp:" + localException.toString());
      AppMethodBeat.o(230797);
    }
  }
  
  public static void b(ai paramai, int paramInt)
  {
    AppMethodBeat.i(230795);
    if (paramai == null)
    {
      Log.e("TwistCoverView_report", "reportGetTwistIdResult, landingPageData==null");
      AppMethodBeat.o(230795);
      return;
    }
    Object localObject = paramai.getSnsId();
    String str = paramai.uxInfo;
    int i = paramai.source;
    try
    {
      paramai = new JSONObject();
      paramai.put("snsid", Util.nullAsNil((String)localObject));
      paramai.put("uxinfo", Util.nullAsNil(str));
      paramai.put("scene", i);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("result", paramInt);
      paramai.put("extInfo", localObject);
      paramai = paramai.toString();
      m.ks("timeline_twistad_canvas_get_twist_cardId_result", paramai);
      Log.i("TwistCoverView_report", "reportGetTwistIdResult, content=".concat(String.valueOf(paramai)));
      AppMethodBeat.o(230795);
      return;
    }
    catch (Exception paramai)
    {
      Log.e("TwistCoverView_report", "reportGetTwistIdResult exp:" + paramai.toString());
      AppMethodBeat.o(230795);
    }
  }
  
  private void fMA()
  {
    AppMethodBeat.i(230771);
    StringBuilder localStringBuilder = new StringBuilder("resetTwistAngle, sensorMgr==null?");
    if (this.JOi == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("TwistCoverView", bool);
      if (this.JOi != null) {
        this.JOi.reset();
      }
      this.JOf.fMI();
      this.JOj = false;
      this.JOq = 0.0F;
      AppMethodBeat.o(230771);
      return;
    }
  }
  
  private boolean fMB()
  {
    AppMethodBeat.i(230777);
    if (this.JOi != null)
    {
      boolean bool = this.JOi.JzS;
      AppMethodBeat.o(230777);
      return bool;
    }
    Log.i("TwistCoverView", "isSensorEnabled, sensorMgr==null");
    AppMethodBeat.o(230777);
    return false;
  }
  
  private void fMC()
  {
    AppMethodBeat.i(230783);
    if ((this.JOs != null) && (!this.JOj))
    {
      this.JOs.fMH();
      this.JOj = true;
    }
    this.JOo = true;
    AppMethodBeat.o(230783);
  }
  
  private void fMD()
  {
    AppMethodBeat.i(230787);
    this.JMp.removeMessages(4);
    if ((this.atV != null) && (!this.atV.isRunning()))
    {
      Log.d("TwistCoverView", "startIconAnim");
      this.atV.start();
    }
    AppMethodBeat.o(230787);
  }
  
  private void fME()
  {
    AppMethodBeat.i(230788);
    this.JMp.removeMessages(4);
    if ((this.atV != null) && (this.atV.isRunning()))
    {
      Log.d("TwistCoverView", "pauseIconAnim");
      this.atV.pause();
    }
    AppMethodBeat.o(230788);
  }
  
  private void fMF()
  {
    AppMethodBeat.i(230790);
    this.JMp.removeMessages(4);
    StringBuilder localStringBuilder = new StringBuilder("resumeIconAnim, isUIPaused=").append(this.JNT).append(", anim.isPaused=");
    if (this.atV == null) {}
    for (boolean bool = false;; bool = this.atV.isPaused())
    {
      Log.d("TwistCoverView", bool);
      if ((this.atV == null) || (this.JNT)) {
        break label114;
      }
      if (!this.atV.isPaused()) {
        break;
      }
      this.atV.resume();
      AppMethodBeat.o(230790);
      return;
    }
    fMD();
    label114:
    AppMethodBeat.o(230790);
  }
  
  private void fMG()
  {
    AppMethodBeat.i(230792);
    if (this.atV != null)
    {
      Log.d("TwistCoverView", "stopIconAnim");
      this.JMp.removeMessages(4);
      this.atV.removeAllListeners();
      this.atV.end();
      this.atV = null;
    }
    AppMethodBeat.o(230792);
  }
  
  private void hide()
  {
    AppMethodBeat.i(230781);
    if (!this.JOa)
    {
      AppMethodBeat.o(230781);
      return;
    }
    this.JOa = false;
    Log.i("TwistCoverView", "hide");
    fMG();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(250L);
    localObjectAnimator.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(265029);
        TwistCoverView.this.setVisibility(8);
        AppMethodBeat.o(265029);
      }
    });
    localObjectAnimator.start();
    AppMethodBeat.o(230781);
  }
  
  public final void Qp(long paramLong)
  {
    AppMethodBeat.i(230762);
    Message localMessage = Message.obtain(this.JMp, 1);
    localMessage.arg1 = ((int)paramLong);
    localMessage.sendToTarget();
    AppMethodBeat.o(230762);
  }
  
  public final void a(SnsInfo paramSnsInfo, ADXml.k paramk, int paramInt)
  {
    AppMethodBeat.i(230760);
    this.JOh = paramk;
    this.Jws = paramSnsInfo;
    this.mScene = paramInt;
    if ((this.JOh != null) && (paramSnsInfo != null))
    {
      Log.i("TwistCoverView", "initData, id=" + com.tencent.mm.plugin.sns.data.t.Qu(paramSnsInfo.field_snsId) + ", twistInfo=" + this.JOh + ", scene=" + paramInt);
      paramSnsInfo = getContext();
      if (this.JOi == null)
      {
        this.JOi = new r(paramSnsInfo);
        this.JOi.JzZ = this.JOr;
        if (this.JOi.JzR == null) {
          break label171;
        }
      }
    }
    label171:
    for (boolean bool = true;; bool = false)
    {
      this.JOp = bool;
      Log.i("TwistCoverView", "initSensor, isSensorOk=" + this.JOp);
      AppMethodBeat.o(230760);
      return;
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(230770);
    this.JOk = false;
    this.JOh = null;
    this.Jws = null;
    this.JOq = 0.0F;
    this.mScene = -1;
    setSensorEnabled(false);
    hide();
    this.JMp.removeCallbacksAndMessages(null);
    AppMethodBeat.o(230770);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(230766);
    super.onDetachedFromWindow();
    Log.i("TwistCoverView", "onDetachedFromWindow");
    if ((this.JOn) && (!this.JOo)) {
      a(2, false, this.JOq);
    }
    clear();
    this.JOl = true;
    this.JOm = false;
    this.JOo = false;
    AppMethodBeat.o(230766);
  }
  
  public final void onPlayerPaused()
  {
    AppMethodBeat.i(230765);
    if (this.JOh == null)
    {
      AppMethodBeat.o(230765);
      return;
    }
    Log.i("TwistCoverView", "onPlayerPaused");
    this.JOk = true;
    setSensorEnabled(false);
    fME();
    this.JMp.removeMessages(1);
    AppMethodBeat.o(230765);
  }
  
  public void onStartTemporaryDetach()
  {
    AppMethodBeat.i(230768);
    super.onStartTemporaryDetach();
    if (Build.VERSION.SDK_INT < 24)
    {
      Log.i("TwistCoverView", "onStartTemporaryDetach");
      clear();
    }
    AppMethodBeat.o(230768);
  }
  
  @androidx.lifecycle.t(jl=h.a.ON_PAUSE)
  public void onUIPause()
  {
    AppMethodBeat.i(230764);
    if (this.JOh == null)
    {
      AppMethodBeat.o(230764);
      return;
    }
    Log.i("TwistCoverView", "onUIPause");
    this.JNT = true;
    setSensorEnabled(false);
    if (this.JOa) {
      fME();
    }
    AppMethodBeat.o(230764);
  }
  
  @androidx.lifecycle.t(jl=h.a.ON_RESUME)
  public void onUIResume()
  {
    AppMethodBeat.i(230763);
    if (this.JOh == null)
    {
      AppMethodBeat.o(230763);
      return;
    }
    Log.i("TwistCoverView", "onUIResume, isTwistActionCalled=" + this.JOj);
    this.JNT = false;
    if ((this.JOj) && (getVisibility() == 0)) {
      fMF();
    }
    fMA();
    AppMethodBeat.o(230763);
  }
  
  public void setSensorEnabled(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(230775);
    if ((this.JOh == null) && (paramBoolean))
    {
      AppMethodBeat.o(230775);
      return;
    }
    if (((this.JOk) || (this.JNT)) && (paramBoolean))
    {
      Log.e("TwistCoverView", "setSensorEnabled to true when isUIPaused=" + this.JNT + ", isPlayerPaused=" + this.JOk);
      AppMethodBeat.o(230775);
      return;
    }
    Object localObject = new StringBuilder("setSensorEnabled, enabled=").append(paramBoolean).append(", sensorMgr==null?");
    if (this.JOi == null) {}
    for (;;)
    {
      Log.i("TwistCoverView", bool);
      if (this.JOi != null)
      {
        localObject = this.JOi;
        if (((r)localObject).JzR != null)
        {
          if (!paramBoolean) {
            break;
          }
          try
          {
            if (((r)localObject).JzS) {
              break label243;
            }
            ((r)localObject).JzV = 0L;
            ((r)localObject).mSensorManager.registerListener(((r)localObject).JzY, ((r)localObject).JzR, 1);
            ((r)localObject).JzS = true;
            AppMethodBeat.o(230775);
            return;
          }
          catch (Throwable localThrowable)
          {
            new StringBuilder("setEnabled exp=").append(localThrowable.toString());
          }
        }
      }
      AppMethodBeat.o(230775);
      return;
      bool = false;
    }
    localThrowable.mSensorManager.unregisterListener(localThrowable.JzY);
    localThrowable.JzS = false;
    label243:
    AppMethodBeat.o(230775);
  }
  
  public void setTwistActionListener(a parama)
  {
    this.JOs = parama;
  }
  
  public static abstract interface a
  {
    public abstract void fMH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView
 * JD-Core Version:    0.7.0.1
 */