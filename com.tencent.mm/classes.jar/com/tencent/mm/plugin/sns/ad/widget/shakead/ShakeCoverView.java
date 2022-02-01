package com.tencent.mm.plugin.sns.ad.widget.shakead;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.h;
import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ai;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.pluginsdk.m.d;
import com.tencent.mm.pluginsdk.m.d.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import org.libpag.PAGView;

public class ShakeCoverView
  extends FrameLayout
  implements k
{
  private a JDc;
  private Handler JMp;
  private ImageView JNM;
  private PAGView JNN;
  private ImageView JNO;
  private TextView JNP;
  private TextView JNQ;
  private ViewGroup JNR;
  private d JNS;
  private boolean JNT;
  private boolean JNU;
  private boolean JNV;
  private boolean JNW;
  private boolean JNX;
  boolean JNY;
  boolean JNZ;
  boolean JOa;
  private a JOb;
  private SnsInfo Jws;
  private int Oeh;
  private Context mContext;
  private boolean mIsDestroyed;
  private int mScene;
  
  public ShakeCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(200126);
    this.mIsDestroyed = false;
    this.JNT = false;
    this.JMp = new Handler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(269429);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(269429);
          return;
          ShakeCoverView.a(ShakeCoverView.this, paramAnonymousMessage.arg1);
        }
      }
    };
    this.JNU = true;
    this.JNV = false;
    this.JNW = false;
    this.JNX = false;
    this.JNY = false;
    this.JNZ = false;
    this.JOa = false;
    this.mContext = paramContext;
    LayoutInflater.from(paramContext).inflate(i.g.sns_ad_shake_cover_layout, this, true);
    this.JNN = ((PAGView)findViewById(i.f.pag_shake_icon));
    this.JNO = ((ImageView)findViewById(i.f.static_icon));
    this.JNM = ((ImageView)findViewById(i.f.shake_bg));
    this.JNM.setAlpha(0.5F);
    this.JNP = ((TextView)findViewById(i.f.tip_title));
    this.JNQ = ((TextView)findViewById(i.f.tip_desc));
    this.JNR = ((ViewGroup)findViewById(i.f.tip_txt_layout));
    this.JNN.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(245608);
        ShakeCoverView.a(ShakeCoverView.this).setPath("assets://sns/sns_ad_shake_icon_anim.pag");
        ShakeCoverView.a(ShakeCoverView.this).setScaleMode(3);
        ShakeCoverView.a(ShakeCoverView.this).setRepeatCount(0);
        AppMethodBeat.o(245608);
      }
    });
    this.Oeh = com.tencent.mm.ci.a.fromDPToPix(paramContext, 50);
    if ((paramContext instanceof l)) {
      ((l)paramContext).getLifecycle().a(this);
    }
    AppMethodBeat.o(200126);
  }
  
  public static void a(ai paramai, int paramInt)
  {
    AppMethodBeat.i(200165);
    if (paramai == null)
    {
      Log.e("ShakeCoverView_report", "reportGetShakeCardIdResult, landingPageData==null");
      AppMethodBeat.o(200165);
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
      m.ks("timeline_shakead_canvas_get_cardId_result", paramai);
      Log.i("ShakeCoverView_report", "reportGetShakeCardIdResult, content=".concat(String.valueOf(paramai)));
      AppMethodBeat.o(200165);
      return;
    }
    catch (Exception paramai)
    {
      Log.e("ShakeCoverView_report", "reportGetShakeCardIdResult exp:" + paramai.toString());
      AppMethodBeat.o(200165);
    }
  }
  
  private static void a(SnsInfo paramSnsInfo, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200170);
    if (paramSnsInfo == null)
    {
      Log.e("ShakeCoverView_report", "reportShakeActionResult, landingPageData==null");
      AppMethodBeat.o(200170);
      return;
    }
    Object localObject = com.tencent.mm.plugin.sns.data.t.Qu(paramSnsInfo.field_snsId);
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
      m.ks("timeline_shakead_shake_result", paramSnsInfo);
      Log.i("ShakeCoverView_report", "reportShakeActionResult, content=".concat(String.valueOf(paramSnsInfo)));
      AppMethodBeat.o(200170);
      return;
    }
    catch (Exception paramSnsInfo)
    {
      Log.e("ShakeCoverView_report", "reportShakeActionResult exp:" + paramSnsInfo.toString());
      AppMethodBeat.o(200170);
    }
  }
  
  private void fMy()
  {
    AppMethodBeat.i(200141);
    if (this.JNZ) {
      Log.i("ShakeCoverView", "stopShakeAnim");
    }
    this.JNZ = false;
    this.JNN.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(270160);
        ShakeCoverView.a(ShakeCoverView.this).stop();
        AppMethodBeat.o(270160);
      }
    });
    AppMethodBeat.o(200141);
  }
  
  private void fMz()
  {
    AppMethodBeat.i(200158);
    if (this.JNS != null)
    {
      if (this.JNS.hiU()) {
        Log.i("ShakeCoverView", "stopListenShake");
      }
      this.JNS.cPS();
    }
    AppMethodBeat.o(200158);
  }
  
  public final void Qp(long paramLong)
  {
    AppMethodBeat.i(200136);
    Message localMessage = Message.obtain(this.JMp, 1);
    localMessage.arg1 = ((int)paramLong);
    localMessage.sendToTarget();
    AppMethodBeat.o(200136);
  }
  
  public final void a(SnsInfo paramSnsInfo, int paramInt)
  {
    AppMethodBeat.i(200135);
    if (paramSnsInfo == null)
    {
      AppMethodBeat.o(200135);
      return;
    }
    this.mScene = paramInt;
    this.Jws = paramSnsInfo;
    this.JDc = paramSnsInfo.getAdXml().adShakeInfo;
    if (this.JDc != null)
    {
      this.JNP.setText(this.JDc.title);
      this.JNQ.setText(this.JDc.desc);
    }
    this.mIsDestroyed = false;
    AppMethodBeat.o(200135);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(200155);
    this.mIsDestroyed = true;
    this.JMp.removeCallbacksAndMessages(null);
    fMw();
    AppMethodBeat.o(200155);
  }
  
  public final void fMw()
  {
    AppMethodBeat.i(200139);
    Log.i("ShakeCoverView", "doOnPause");
    fMz();
    fMy();
    AppMethodBeat.o(200139);
  }
  
  public final void fMx()
  {
    AppMethodBeat.i(200140);
    Log.i("ShakeCoverView", "startShakeAnim, isUIPaused=" + this.JNT + ", isDestroy=" + this.mIsDestroyed);
    if ((this.mIsDestroyed) || (this.JNT))
    {
      AppMethodBeat.o(200140);
      return;
    }
    this.JNZ = true;
    this.JNN.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(206666);
        if (ShakeCoverView.c(ShakeCoverView.this))
        {
          Log.w("ShakeCoverView", "do startShakeAnim, isDestroyed");
          AppMethodBeat.o(206666);
          return;
        }
        Log.i("ShakeCoverView", "do startShakeAnim");
        ShakeCoverView.a(ShakeCoverView.this).play();
        AppMethodBeat.o(206666);
      }
    });
    AppMethodBeat.o(200140);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(200149);
    super.onDetachedFromWindow();
    Log.i("ShakeCoverView", "onDetachedFromWindow");
    if ((this.JNW) && (!this.JNX)) {
      a(this.Jws, 2, this.mScene);
    }
    clear();
    this.JNU = true;
    this.JNV = false;
    this.JNX = false;
    AppMethodBeat.o(200149);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(200133);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.i("ShakeCoverView", "onSizeChanged, w=" + paramInt1 + ", h=" + paramInt2);
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      paramInt1 = getHeight();
      paramInt2 = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 68);
      paramInt3 = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 20);
      this.Oeh = ((paramInt1 - paramInt2 - com.tencent.mm.ci.a.fromDPToPix(this.mContext, 49) - paramInt3) / 2);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.JNN.getLayoutParams();
      if (localLayoutParams.topMargin != this.Oeh)
      {
        localLayoutParams.topMargin = this.Oeh;
        this.JNN.setLayoutParams(localLayoutParams);
      }
      if (!this.JNY)
      {
        float f1 = getWidth() / 2 - com.tencent.mm.ci.a.fromDPToPix(this.mContext, 28);
        float f2 = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 34) + this.Oeh - com.tencent.mm.ci.a.fromDPToPix(this.mContext, 28);
        this.JNN.setTranslationX(f1);
        this.JNN.setTranslationY(-f2);
        this.JNN.setScaleX(0.41F);
        this.JNN.setScaleY(0.41F);
      }
    }
    AppMethodBeat.o(200133);
  }
  
  public void onStartTemporaryDetach()
  {
    AppMethodBeat.i(200152);
    super.onStartTemporaryDetach();
    if (Build.VERSION.SDK_INT < 24)
    {
      Log.i("ShakeCoverView", "onStartTemporaryDetach");
      if ((this.JNW) && (!this.JNX)) {
        a(this.Jws, 2, this.mScene);
      }
      clear();
      this.JNU = true;
      this.JNV = false;
      this.JNX = false;
      AppMethodBeat.o(200152);
      return;
    }
    Log.d("ShakeCoverView", "onStartTemporaryDetach");
    AppMethodBeat.o(200152);
  }
  
  @androidx.lifecycle.t(jl=h.a.ON_PAUSE)
  public void onUIPause()
  {
    AppMethodBeat.i(200148);
    Log.i("ShakeCoverView", "onUIPause");
    this.JNT = true;
    fMw();
    AppMethodBeat.o(200148);
  }
  
  @androidx.lifecycle.t(jl=h.a.ON_RESUME)
  public void onUIResume()
  {
    AppMethodBeat.i(200145);
    Log.i("ShakeCoverView", "onUIResume");
    this.JNT = false;
    AppMethodBeat.o(200145);
  }
  
  public void setOnShakeListener(a parama)
  {
    this.JOb = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onShake();
  }
  
  static final class b
    extends d.a
  {
    WeakReference<ShakeCoverView> JOd;
    private long lastShakeTime;
    
    public b(ShakeCoverView paramShakeCoverView)
    {
      AppMethodBeat.i(268252);
      this.lastShakeTime = Util.currentTicks();
      this.JOd = new WeakReference(paramShakeCoverView);
      AppMethodBeat.o(268252);
    }
    
    public final void onRelease()
    {
      AppMethodBeat.i(268254);
      Log.i("ShakeCoverView", "onRelease");
      AppMethodBeat.o(268254);
    }
    
    public final void onShake(boolean paramBoolean)
    {
      AppMethodBeat.i(268253);
      ShakeCoverView localShakeCoverView = (ShakeCoverView)this.JOd.get();
      if (localShakeCoverView == null)
      {
        Log.w("ShakeCoverView", "onShake， shakeCoverView==null");
        AppMethodBeat.o(268253);
        return;
      }
      Context localContext = localShakeCoverView.getContext();
      if (localContext == null)
      {
        Log.w("ShakeCoverView", "onShake， context==null");
        AppMethodBeat.o(268253);
        return;
      }
      if (((localContext instanceof Activity)) && (((Activity)localContext).isFinishing()))
      {
        Log.e("ShakeCoverView", "onShake, ui finished");
        AppMethodBeat.o(268253);
        return;
      }
      long l = Util.ticksToNow(this.lastShakeTime);
      if (l < 800L)
      {
        Log.i("ShakeCoverView", "onShake, too short, delay=".concat(String.valueOf(l)));
        AppMethodBeat.o(268253);
        return;
      }
      this.lastShakeTime = Util.currentTicks();
      com.tencent.mm.plugin.sns.data.t.e(new long[] { 0L, 80L });
      reset();
      Log.i("ShakeCoverView", "onShake succ");
      ShakeCoverView.d(localShakeCoverView);
      AppMethodBeat.o(268253);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.shakead.ShakeCoverView
 * JD-Core Version:    0.7.0.1
 */