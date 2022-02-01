package com.tencent.mm.plugin.sns.ad.widget.shakead;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.xw;
import com.tencent.mm.plugin.sns.ad.widget.interactionlabel.ShakeCoverAnimView;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import org.libpag.PAGView;

public class ShakeCoverView
  extends FrameLayout
  implements p
{
  public SnsInfo PJQ;
  public Handler PRJ;
  public PAGView QiB;
  public TextView QiC;
  public TextView QiD;
  private ViewGroup QiE;
  private ShakeCoverAnimView QiF;
  public a QiG;
  private b QiH;
  private boolean QiI;
  private boolean QiJ;
  private boolean QiK;
  private boolean QiL;
  private boolean QiM;
  boolean QiN;
  boolean QiO;
  boolean QiP;
  private a QiQ;
  private Context mContext;
  public boolean mIsDestroyed;
  public int mScene;
  
  public ShakeCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(310572);
    this.mIsDestroyed = false;
    this.QiI = false;
    this.PRJ = new Handler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(310585);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(310585);
          return;
          ShakeCoverView.a(ShakeCoverView.this, paramAnonymousMessage.arg1);
        }
      }
    };
    this.QiJ = true;
    this.QiK = false;
    this.QiL = false;
    this.QiM = false;
    this.QiN = false;
    this.QiO = false;
    this.QiP = false;
    this.mContext = paramContext;
    LayoutInflater.from(paramContext).inflate(b.g.sns_ad_shake_cover_layout, this, true);
    this.QiB = ((PAGView)findViewById(b.f.pag_shake_icon));
    this.QiC = ((TextView)findViewById(b.f.tip_title));
    this.QiD = ((TextView)findViewById(b.f.tip_desc));
    this.QiE = ((ViewGroup)findViewById(b.f.tip_txt_layout));
    this.QiF = ((ShakeCoverAnimView)findViewById(b.f.anim_bg_view));
    m.q(this.QiC, b.d.sns_ad_shake_cover_title_font_size);
    m.q(this.QiD, b.d.sns_ad_shake_cover_desc_font_size);
    this.QiB.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(310584);
        ShakeCoverView.a(ShakeCoverView.this).setPath("assets://sns/sns_ad_shake_icon_anim.pag");
        ShakeCoverView.a(ShakeCoverView.this).setScaleMode(3);
        ShakeCoverView.a(ShakeCoverView.this).setRepeatCount(0);
        AppMethodBeat.o(310584);
      }
    });
    if ((paramContext instanceof q)) {
      ((q)paramContext).getLifecycle().addObserver(this);
    }
    AppMethodBeat.o(310572);
  }
  
  private void Dz(boolean paramBoolean)
  {
    AppMethodBeat.i(310581);
    if (!this.QiN)
    {
      AppMethodBeat.o(310581);
      return;
    }
    Log.i("ShakeCoverView", "unSpreadUp, isForDestroy=".concat(String.valueOf(paramBoolean)));
    this.QiN = false;
    this.QiP = false;
    if (!paramBoolean)
    {
      Object localObject2 = this.QiF;
      Log.i("ShakeCoverAnimView", "unSpreadUp, scale=" + ((ShakeCoverAnimView)localObject2).hco);
      Object localObject1 = ObjectAnimator.ofFloat(((ShakeCoverAnimView)localObject2).Qgo, "alpha", new float[] { 0.7F, 0.7F });
      ((ObjectAnimator)localObject1).setDuration(ShakeCoverAnimView.Qgp);
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(((ShakeCoverAnimView)localObject2).Qgo, "scaleX", new float[] { ((ShakeCoverAnimView)localObject2).hco, 1.0F });
      localObjectAnimator.setDuration(ShakeCoverAnimView.Qgp);
      localObject2 = ObjectAnimator.ofFloat(((ShakeCoverAnimView)localObject2).Qgo, "scaleY", new float[] { ((ShakeCoverAnimView)localObject2).hco, 1.0F });
      ((ObjectAnimator)localObject2).setDuration(ShakeCoverAnimView.Qgp);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.play((Animator)localObject1).with(localObjectAnimator).with((Animator)localObject2);
      localAnimatorSet.start();
      localObject1 = ObjectAnimator.ofFloat(this.QiE, "alpha", new float[] { 1.0F, 0.0F });
      ((ObjectAnimator)localObject1).setDuration(500L);
      ((ObjectAnimator)localObject1).addListener(new com.tencent.mm.plugin.sns.ad.widget.b()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(310589);
          ShakeCoverView.b(ShakeCoverView.this).setVisibility(4);
          AppMethodBeat.o(310589);
        }
      });
      ((ObjectAnimator)localObject1).start();
      localObject1 = new xw();
      ((xw)localObject1).ibp.hQm = 2;
      ((xw)localObject1).ibp.ibq = this.PJQ.field_snsId;
      ((xw)localObject1).publish();
      AppMethodBeat.o(310581);
      return;
    }
    this.QiE.setVisibility(4);
    this.QiF.setVisibility(4);
    AppMethodBeat.o(310581);
  }
  
  public static void a(ai paramai, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(310619);
    if (paramai == null)
    {
      Log.e("ShakeCoverView_report", "reportGetShakeCardIdResult, landingPageData==null");
      AppMethodBeat.o(310619);
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
      if (paramBoolean) {}
      for (paramInt = 1;; paramInt = 0)
      {
        ((JSONObject)localObject).put("encoreShake", paramInt);
        paramai.put("extInfo", localObject);
        paramai = paramai.toString();
        m.lU("timeline_shakead_canvas_get_cardId_result", paramai);
        Log.i("ShakeCoverView_report", "reportGetShakeCardIdResult, content=".concat(String.valueOf(paramai)));
        AppMethodBeat.o(310619);
        return;
      }
      return;
    }
    catch (Exception paramai)
    {
      Log.e("ShakeCoverView_report", "reportGetShakeCardIdResult exp:" + paramai.toString());
      AppMethodBeat.o(310619);
    }
  }
  
  private static void a(SnsInfo paramSnsInfo, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(310636);
    if (paramSnsInfo == null)
    {
      Log.e("ShakeCoverView_report", "reportShakeActionResult, landingPageData==null");
      AppMethodBeat.o(310636);
      return;
    }
    Object localObject = t.uA(paramSnsInfo.field_snsId);
    String str = paramSnsInfo.getUxinfo();
    try
    {
      paramSnsInfo = new JSONObject();
      paramSnsInfo.put("snsid", Util.nullAsNil((String)localObject));
      paramSnsInfo.put("uxinfo", Util.nullAsNil(str));
      paramSnsInfo.put("scene", paramInt2);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("result", paramInt1);
      paramSnsInfo.put("extInfo", localObject);
      paramSnsInfo = paramSnsInfo.toString();
      m.lU("timeline_shakead_shake_result", paramSnsInfo);
      Log.i("ShakeCoverView_report", "reportShakeActionResult, content=".concat(String.valueOf(paramSnsInfo)));
      AppMethodBeat.o(310636);
      return;
    }
    catch (Exception paramSnsInfo)
    {
      Log.e("ShakeCoverView_report", "reportShakeActionResult exp:" + paramSnsInfo.toString());
      AppMethodBeat.o(310636);
    }
  }
  
  private void hdA()
  {
    AppMethodBeat.i(310605);
    if (this.QiH != null)
    {
      if (this.QiH.hdD()) {
        Log.i("ShakeCoverView", "stopListenShake");
      }
      this.QiH.cuD();
    }
    AppMethodBeat.o(310605);
  }
  
  private void hdy()
  {
    AppMethodBeat.i(310588);
    Log.i("ShakeCoverView", "startShakeAnim, isUIPaused=" + this.QiI + ", isDestroy=" + this.mIsDestroyed);
    if ((this.mIsDestroyed) || (this.QiI))
    {
      AppMethodBeat.o(310588);
      return;
    }
    this.QiO = true;
    this.QiB.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(310578);
        if (ShakeCoverView.c(ShakeCoverView.this))
        {
          Log.w("ShakeCoverView", "do startShakeAnim, isDestroyed");
          AppMethodBeat.o(310578);
          return;
        }
        Log.i("ShakeCoverView", "do startShakeAnim");
        ShakeCoverView.a(ShakeCoverView.this).play();
        AppMethodBeat.o(310578);
      }
    });
    AppMethodBeat.o(310588);
  }
  
  private void hdz()
  {
    AppMethodBeat.i(310595);
    if (this.QiO) {
      Log.i("ShakeCoverView", "stopShakeAnim");
    }
    this.QiO = false;
    this.QiB.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(310569);
        ShakeCoverView.a(ShakeCoverView.this).stop();
        AppMethodBeat.o(310569);
      }
    });
    AppMethodBeat.o(310595);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(310743);
    this.mIsDestroyed = true;
    this.PRJ.removeCallbacksAndMessages(null);
    hdx();
    Dz(true);
    AppMethodBeat.o(310743);
  }
  
  public final void hdx()
  {
    AppMethodBeat.i(310688);
    Log.i("ShakeCoverView", "doOnPause");
    hdA();
    hdz();
    AppMethodBeat.o(310688);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(310718);
    super.onDetachedFromWindow();
    Log.i("ShakeCoverView", "onDetachedFromWindow");
    if ((this.QiL) && (!this.QiM)) {
      a(this.PJQ, 2, this.mScene);
    }
    clear();
    this.QiJ = true;
    this.QiK = false;
    this.QiM = false;
    AppMethodBeat.o(310718);
  }
  
  public void onStartTemporaryDetach()
  {
    AppMethodBeat.i(310732);
    super.onStartTemporaryDetach();
    if (Build.VERSION.SDK_INT < 24)
    {
      Log.i("ShakeCoverView", "onStartTemporaryDetach");
      if ((this.QiL) && (!this.QiM)) {
        a(this.PJQ, 2, this.mScene);
      }
      clear();
      this.QiJ = true;
      this.QiK = false;
      this.QiM = false;
      AppMethodBeat.o(310732);
      return;
    }
    Log.d("ShakeCoverView", "onStartTemporaryDetach");
    AppMethodBeat.o(310732);
  }
  
  @z(Ho=j.a.ON_PAUSE)
  public void onUIPause()
  {
    AppMethodBeat.i(310706);
    Log.i("ShakeCoverView", "onUIPause");
    this.QiI = true;
    hdx();
    AppMethodBeat.o(310706);
  }
  
  @z(Ho=j.a.ON_RESUME)
  public void onUIResume()
  {
    AppMethodBeat.i(310697);
    Log.i("ShakeCoverView", "onUIResume");
    this.QiI = false;
    AppMethodBeat.o(310697);
  }
  
  public void setOnShakeListener(a parama)
  {
    this.QiQ = parama;
  }
  
  public static abstract interface a
  {
    public abstract void hat();
  }
  
  static final class b
    extends b.a
  {
    WeakReference<ShakeCoverView> QiS;
    private long lastShakeTime;
    
    public b(ShakeCoverView paramShakeCoverView, int paramInt1, int paramInt2)
    {
      super(paramInt2);
      AppMethodBeat.i(310614);
      this.lastShakeTime = Util.currentTicks();
      this.QiS = new WeakReference(paramShakeCoverView);
      AppMethodBeat.o(310614);
    }
    
    public final void hdB()
    {
      AppMethodBeat.i(310625);
      ShakeCoverView localShakeCoverView = (ShakeCoverView)this.QiS.get();
      if (localShakeCoverView == null)
      {
        Log.w("ShakeCoverView", "onShake， shakeCoverView==null");
        AppMethodBeat.o(310625);
        return;
      }
      Context localContext = localShakeCoverView.getContext();
      if (localContext == null)
      {
        Log.w("ShakeCoverView", "onShake， context==null");
        AppMethodBeat.o(310625);
        return;
      }
      if (((localContext instanceof Activity)) && (((Activity)localContext).isFinishing()))
      {
        Log.e("ShakeCoverView", "onShake, ui finished");
        AppMethodBeat.o(310625);
        return;
      }
      long l = Util.ticksToNow(this.lastShakeTime);
      if (l < 1000L)
      {
        Log.i("ShakeCoverView", "onShake, too short, delay=".concat(String.valueOf(l)));
        AppMethodBeat.o(310625);
        return;
      }
      this.lastShakeTime = Util.currentTicks();
      t.g(new long[] { 0L, 80L });
      reset();
      Log.i("ShakeCoverView", "onShake succ");
      ShakeCoverView.d(localShakeCoverView);
      AppMethodBeat.o(310625);
    }
    
    public final void onRelease()
    {
      AppMethodBeat.i(310633);
      Log.i("ShakeCoverView", "onRelease");
      AppMethodBeat.o(310633);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.shakead.ShakeCoverView
 * JD-Core Version:    0.7.0.1
 */