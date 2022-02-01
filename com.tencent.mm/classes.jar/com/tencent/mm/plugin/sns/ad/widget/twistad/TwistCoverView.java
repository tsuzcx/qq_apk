package com.tencent.mm.plugin.sns.ad.widget.twistad;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.d.b.a;
import com.tencent.mm.plugin.sns.ad.d.b.a.a;
import com.tencent.mm.plugin.sns.ad.d.b.d;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.ADXml.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class TwistCoverView
  extends FrameLayout
  implements p
{
  private TextView KPG;
  public SnsInfo PJQ;
  public Handler PRJ;
  private boolean QiI;
  private boolean QiP;
  private boolean QjA;
  private boolean QjB;
  private boolean QjC;
  public boolean QjD;
  private float QjE;
  public a.a QjF;
  private a QjG;
  private TwistDegreeView Qjt;
  private ImageView Qju;
  public volatile ADXml.k Qjv;
  public d Qjw;
  private boolean Qjx;
  public boolean Qjy;
  private boolean Qjz;
  private AnimatorSet cis;
  private TextView fO;
  public int mScene;
  
  public TwistCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(310344);
    this.Qjx = false;
    this.QiP = false;
    this.Qjy = false;
    this.QiI = false;
    this.Qjz = true;
    this.QjA = false;
    this.QjB = false;
    this.QjC = false;
    this.QjD = false;
    this.PRJ = new Handler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(310353);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(310353);
          return;
          TwistCoverView.a(TwistCoverView.this, paramAnonymousMessage.arg1);
          AppMethodBeat.o(310353);
          return;
          TwistCoverView.a(TwistCoverView.this, paramAnonymousMessage.arg1 / 1000.0F);
          AppMethodBeat.o(310353);
          return;
          TwistCoverView.a(TwistCoverView.this);
          AppMethodBeat.o(310353);
          return;
          if ((TwistCoverView.b(TwistCoverView.this) != null) && (!TwistCoverView.b(TwistCoverView.this).isRunning())) {
            TwistCoverView.b(TwistCoverView.this).start();
          }
        }
      }
    };
    this.QjE = 0.0F;
    this.QjF = new a.a()
    {
      public final void df(float paramAnonymousFloat)
      {
        AppMethodBeat.i(310345);
        Object localObject = TwistCoverView.c(TwistCoverView.this);
        if (localObject == null)
        {
          Log.w("TwistCoverView", "onDegreeChange, twistInfo==null");
          AppMethodBeat.o(310345);
          return;
        }
        float f = paramAnonymousFloat;
        if (((ADXml.k)localObject).QIc)
        {
          f = paramAnonymousFloat;
          if (paramAnonymousFloat > 0.0F) {
            f = 0.0F;
          }
        }
        paramAnonymousFloat = f;
        if (!((ADXml.k)localObject).QIc)
        {
          paramAnonymousFloat = f;
          if (f < 0.0F) {
            paramAnonymousFloat = 0.0F;
          }
        }
        f = Math.abs(paramAnonymousFloat / ((ADXml.k)localObject).QIb);
        if (Math.abs(paramAnonymousFloat) > TwistCoverView.d(TwistCoverView.this)) {
          TwistCoverView.b(TwistCoverView.this, Math.abs(paramAnonymousFloat));
        }
        localObject = Message.obtain(TwistCoverView.e(TwistCoverView.this), 2);
        ((Message)localObject).arg1 = ((int)(f * 1000.0F));
        ((Message)localObject).sendToTarget();
        AppMethodBeat.o(310345);
      }
      
      public final void hab()
      {
        AppMethodBeat.i(310351);
        Message.obtain(TwistCoverView.e(TwistCoverView.this), 3).sendToTarget();
        AppMethodBeat.o(310351);
      }
    };
    LayoutInflater.from(paramContext).inflate(b.g.sns_ad_twist_cover_layout, this, true);
    this.Qjt = ((TwistDegreeView)findViewById(b.f.twist_degree_view));
    this.Qju = ((ImageView)findViewById(b.f.phone_icon));
    this.fO = ((TextView)findViewById(b.f.title_txt));
    this.KPG = ((TextView)findViewById(b.f.desc_txt));
    m.q(this.fO, b.d.sns_ad_twist_cover_title_font_size);
    m.q(this.KPG, b.d.sns_ad_twist_cover_desc_font_size);
    setBackgroundColor(Color.parseColor("#CC000000"));
    if ((paramContext instanceof q)) {
      ((q)paramContext).getLifecycle().addObserver(this);
    }
    AppMethodBeat.o(310344);
  }
  
  private void a(int paramInt, boolean paramBoolean, float paramFloat)
  {
    int i = 1;
    AppMethodBeat.i(310436);
    if (this.PJQ == null)
    {
      Log.e("TwistCoverView_report", "reportTwistActionResult, snsInfo==null");
      AppMethodBeat.o(310436);
      return;
    }
    Object localObject2 = this.PJQ;
    Object localObject1 = t.uA(((SnsInfo)localObject2).field_snsId);
    String str = ((SnsInfo)localObject2).getUxinfo();
    int j = this.mScene;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      Log.e("TwistCoverView_report", "reportTwistActionResult, snsId==null, source=".concat(String.valueOf(j)));
      AppMethodBeat.o(310436);
      return;
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      Log.e("TwistCoverView_report", "reportTwistActionResult, snsId==null, source=".concat(String.valueOf(j)));
      AppMethodBeat.o(310436);
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
        if (!this.QjD) {
          ((JSONObject)localObject1).put("sensorDisable", 1);
        }
        ((JSONObject)localObject2).put("extInfo", localObject1);
        localObject1 = ((JSONObject)localObject2).toString();
        m.lU("timeline_twistad_twist_result", (String)localObject1);
        Log.i("TwistCoverView_report", "reportTwistActionResult, content=".concat(String.valueOf(localObject1)));
        AppMethodBeat.o(310436);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e("TwistCoverView_report", "reportTwistActionResult exp:" + localException.toString());
      AppMethodBeat.o(310436);
    }
  }
  
  public static void a(ai paramai, int paramInt)
  {
    AppMethodBeat.i(310422);
    if (paramai == null)
    {
      Log.e("TwistCoverView_report", "reportGetTwistIdResult, landingPageData==null");
      AppMethodBeat.o(310422);
      return;
    }
    Object localObject = paramai.QLy;
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
      m.lU("timeline_twistad_canvas_get_twist_cardId_result", paramai);
      Log.i("TwistCoverView_report", "reportGetTwistIdResult, content=".concat(String.valueOf(paramai)));
      AppMethodBeat.o(310422);
      return;
    }
    catch (Exception paramai)
    {
      Log.e("TwistCoverView_report", "reportGetTwistIdResult exp:" + paramai.toString());
      AppMethodBeat.o(310422);
    }
  }
  
  private void clear()
  {
    AppMethodBeat.i(310352);
    this.Qjy = false;
    this.Qjv = null;
    this.PJQ = null;
    this.QjE = 0.0F;
    this.mScene = -1;
    setSensorEnabled(false);
    hide();
    this.PRJ.removeCallbacksAndMessages(null);
    AppMethodBeat.o(310352);
  }
  
  private boolean haa()
  {
    AppMethodBeat.i(310365);
    if (this.Qjw != null)
    {
      d locald = this.Qjw;
      if (locald.PPz != null)
      {
        boolean bool = locald.PPz.haa();
        AppMethodBeat.o(310365);
        return bool;
      }
      AppMethodBeat.o(310365);
      return false;
    }
    Log.i("TwistCoverView", "isSensorEnabled, sensorMgr==null");
    AppMethodBeat.o(310365);
    return false;
  }
  
  private void hdI()
  {
    AppMethodBeat.i(310358);
    StringBuilder localStringBuilder = new StringBuilder("resetTwistAngle, sensorMgr==null?");
    if (this.Qjw == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("TwistCoverView", bool);
      if (this.Qjw != null) {
        this.Qjw.reset();
      }
      this.Qjt.hdP();
      this.Qjx = false;
      this.QjE = 0.0F;
      AppMethodBeat.o(310358);
      return;
    }
  }
  
  private void hdJ()
  {
    AppMethodBeat.i(310381);
    if ((this.QjG != null) && (!this.Qjx))
    {
      this.QjG.hdO();
      this.Qjx = true;
    }
    this.QjC = true;
    AppMethodBeat.o(310381);
  }
  
  private void hdK()
  {
    AppMethodBeat.i(310389);
    this.PRJ.removeMessages(4);
    if ((this.cis != null) && (!this.cis.isRunning()))
    {
      Log.d("TwistCoverView", "startIconAnim");
      this.cis.start();
    }
    AppMethodBeat.o(310389);
  }
  
  private void hdM()
  {
    AppMethodBeat.i(310396);
    this.PRJ.removeMessages(4);
    StringBuilder localStringBuilder = new StringBuilder("resumeIconAnim, isUIPaused=").append(this.QiI).append(", anim.isPaused=");
    if (this.cis == null) {}
    for (boolean bool = false;; bool = this.cis.isPaused())
    {
      Log.d("TwistCoverView", bool);
      if ((this.cis == null) || (this.QiI)) {
        break label114;
      }
      if (!this.cis.isPaused()) {
        break;
      }
      this.cis.resume();
      AppMethodBeat.o(310396);
      return;
    }
    hdK();
    label114:
    AppMethodBeat.o(310396);
  }
  
  private void hdN()
  {
    AppMethodBeat.i(310408);
    if (this.cis != null)
    {
      Log.d("TwistCoverView", "stopIconAnim");
      this.PRJ.removeMessages(4);
      this.cis.removeAllListeners();
      this.cis.end();
      this.cis.setTarget(null);
      this.cis = null;
    }
    AppMethodBeat.o(310408);
  }
  
  private void hide()
  {
    AppMethodBeat.i(310374);
    if (!this.QiP)
    {
      AppMethodBeat.o(310374);
      return;
    }
    this.QiP = false;
    Log.i("TwistCoverView", "hide");
    hdN();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(250L);
    localObjectAnimator.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(310343);
        TwistCoverView.this.setVisibility(8);
        AppMethodBeat.o(310343);
      }
    });
    localObjectAnimator.start();
    AppMethodBeat.o(310374);
  }
  
  public final void hdL()
  {
    AppMethodBeat.i(310548);
    this.PRJ.removeMessages(4);
    if ((this.cis != null) && (this.cis.isRunning()))
    {
      Log.d("TwistCoverView", "pauseIconAnim");
      this.cis.pause();
    }
    AppMethodBeat.o(310548);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(310519);
    super.onDetachedFromWindow();
    Log.i("TwistCoverView", "onDetachedFromWindow");
    if ((this.QjB) && (!this.QjC)) {
      a(2, false, this.QjE);
    }
    clear();
    this.Qjz = true;
    this.QjA = false;
    this.QjC = false;
    AppMethodBeat.o(310519);
  }
  
  public void onStartTemporaryDetach()
  {
    AppMethodBeat.i(310523);
    super.onStartTemporaryDetach();
    if (Build.VERSION.SDK_INT < 24)
    {
      Log.i("TwistCoverView", "onStartTemporaryDetach");
      clear();
    }
    AppMethodBeat.o(310523);
  }
  
  @z(Ho=j.a.ON_PAUSE)
  public void onUIPause()
  {
    AppMethodBeat.i(310512);
    if (this.Qjv == null)
    {
      AppMethodBeat.o(310512);
      return;
    }
    Log.i("TwistCoverView", "onUIPause");
    this.QiI = true;
    setSensorEnabled(false);
    if (this.QiP) {
      hdL();
    }
    AppMethodBeat.o(310512);
  }
  
  @z(Ho=j.a.ON_RESUME)
  public void onUIResume()
  {
    AppMethodBeat.i(310505);
    if (this.Qjv == null)
    {
      AppMethodBeat.o(310505);
      return;
    }
    Log.i("TwistCoverView", "onUIResume, isTwistActionCalled=" + this.Qjx);
    this.QiI = false;
    if ((this.Qjx) && (getVisibility() == 0)) {
      hdM();
    }
    hdI();
    AppMethodBeat.o(310505);
  }
  
  public void setSensorEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(310533);
    if ((this.Qjv == null) && (paramBoolean))
    {
      AppMethodBeat.o(310533);
      return;
    }
    if (((this.Qjy) || (this.QiI)) && (paramBoolean))
    {
      Log.e("TwistCoverView", "setSensorEnabled to true when isUIPaused=" + this.QiI + ", isPlayerPaused=" + this.Qjy);
      AppMethodBeat.o(310533);
      return;
    }
    Object localObject = new StringBuilder("setSensorEnabled, enabled=").append(paramBoolean).append(", sensorMgr==null?");
    if (this.Qjw == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("TwistCoverView", bool);
      if (this.Qjw != null)
      {
        localObject = this.Qjw;
        if (((d)localObject).PPz != null) {
          ((d)localObject).PPz.setEnabled(paramBoolean);
        }
      }
      AppMethodBeat.o(310533);
      return;
    }
  }
  
  public void setTwistActionListener(a parama)
  {
    this.QjG = parama;
  }
  
  public static abstract interface a
  {
    public abstract void hdO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView
 * JD-Core Version:    0.7.0.1
 */