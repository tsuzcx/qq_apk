package com.tencent.mm.plugin.sns.ad.widget.shakead;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;

public class ShakeRandomEncoreView
  extends LinearLayout
  implements p
{
  public TextView QiC;
  public b QiH;
  private boolean QiI;
  ShakeCoverView.a QiQ;
  public ImageView QiT;
  public com.tencent.mm.plugin.sns.ad.landingpage.component.info.b.a QiU;
  private Context mContext;
  private boolean mIsDestroyed;
  
  public ShakeRandomEncoreView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(310535);
    this.mIsDestroyed = false;
    this.QiI = false;
    init(paramContext);
    AppMethodBeat.o(310535);
  }
  
  public ShakeRandomEncoreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(310544);
    this.mIsDestroyed = false;
    this.QiI = false;
    init(paramContext);
    AppMethodBeat.o(310544);
  }
  
  private void ci(Context paramContext)
  {
    AppMethodBeat.i(310557);
    LayoutInflater.from(paramContext).inflate(b.g.sns_ad_shake_random_encore_layout, this);
    this.QiT = ((ImageView)findViewById(b.f.encore_tip_icon));
    this.QiC = ((TextView)findViewById(b.f.encore_tip_txt));
    m.r(this.QiC, b.d.sns_ad_font_size_14);
    AppMethodBeat.o(310557);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(310551);
    setOrientation(0);
    setGravity(16);
    this.mContext = paramContext;
    ci(paramContext);
    if ((paramContext instanceof q)) {
      ((q)paramContext).getLifecycle().addObserver(this);
    }
    AppMethodBeat.o(310551);
  }
  
  public final void hdA()
  {
    AppMethodBeat.i(310574);
    if (this.QiH != null)
    {
      if (this.QiH.hdD()) {
        Log.i("ShakeRandomEncoreView", "stopListenShake");
      }
      this.QiH.cuD();
    }
    AppMethodBeat.o(310574);
  }
  
  public final void hdC()
  {
    int j = 10;
    int i = 8;
    AppMethodBeat.i(310566);
    if ((this.mIsDestroyed) || (this.QiI))
    {
      Log.w("ShakeRandomEncoreView", "startListenShake, isUIPaused=" + this.QiI + ", isDestroyed=" + this.mIsDestroyed);
      AppMethodBeat.o(310566);
      return;
    }
    if (this.QiH == null)
    {
      Log.w("ShakeRandomEncoreView", "startListenShake, shakeSensor==null");
      AppMethodBeat.o(310566);
      return;
    }
    if (!this.QiH.hdE())
    {
      Log.e("ShakeRandomEncoreView", "sensor not support");
      h.OAn.kJ(1572, 4);
      AppMethodBeat.o(310566);
      return;
    }
    h.OAn.kJ(1572, 3);
    int m;
    int k;
    if ((!this.QiH.hdD()) && (this.QiU != null))
    {
      m = this.QiU.PRS;
      k = this.QiU.PRT;
      if (m >= 8) {
        break label235;
      }
    }
    for (;;)
    {
      if (k < 10) {}
      for (;;)
      {
        Log.i("ShakeRandomEncoreView", "startListenShake， min=" + i + ", max=" + j);
        this.QiH.a(new a(this, i, j));
        AppMethodBeat.o(310566);
        return;
        j = k;
      }
      label235:
      i = m;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(310599);
    super.onDetachedFromWindow();
    Log.i("ShakeRandomEncoreView", "onDetachedFromWindow");
    this.mIsDestroyed = true;
    hdA();
    AppMethodBeat.o(310599);
  }
  
  @z(Ho=j.a.ON_PAUSE)
  public void onUIPause()
  {
    AppMethodBeat.i(310594);
    Log.i("ShakeRandomEncoreView", "onUIPause");
    this.QiI = true;
    hdA();
    AppMethodBeat.o(310594);
  }
  
  @z(Ho=j.a.ON_RESUME)
  public void onUIResume()
  {
    AppMethodBeat.i(310586);
    Log.i("ShakeRandomEncoreView", "onUIResume");
    this.QiI = false;
    hdC();
    AppMethodBeat.o(310586);
  }
  
  public void setOnShakeListener(ShakeCoverView.a parama)
  {
    this.QiQ = parama;
  }
  
  static final class a
    extends b.a
  {
    WeakReference<ShakeRandomEncoreView> QiS;
    private long lastShakeTime;
    
    public a(ShakeRandomEncoreView paramShakeRandomEncoreView, int paramInt1, int paramInt2)
    {
      super(paramInt2);
      AppMethodBeat.i(310529);
      this.lastShakeTime = Util.currentTicks();
      this.QiS = new WeakReference(paramShakeRandomEncoreView);
      AppMethodBeat.o(310529);
    }
    
    public final void hdB()
    {
      AppMethodBeat.i(310541);
      ShakeRandomEncoreView localShakeRandomEncoreView = (ShakeRandomEncoreView)this.QiS.get();
      if (localShakeRandomEncoreView == null)
      {
        Log.w("ShakeRandomEncoreView", "onShake， shakeView==null");
        AppMethodBeat.o(310541);
        return;
      }
      Context localContext = localShakeRandomEncoreView.getContext();
      if (localContext == null)
      {
        Log.w("ShakeRandomEncoreView", "onShake， context==null");
        AppMethodBeat.o(310541);
        return;
      }
      if (((localContext instanceof Activity)) && (((Activity)localContext).isFinishing()))
      {
        Log.e("ShakeRandomEncoreView", "onShake, ui finished");
        AppMethodBeat.o(310541);
        return;
      }
      long l = Util.ticksToNow(this.lastShakeTime);
      if (l < 1000L)
      {
        Log.i("ShakeRandomEncoreView", "onShake, too short, delay=".concat(String.valueOf(l)));
        AppMethodBeat.o(310541);
        return;
      }
      this.lastShakeTime = Util.currentTicks();
      t.g(new long[] { 0L, 80L });
      reset();
      Log.i("ShakeRandomEncoreView", "onShake succ");
      if (localShakeRandomEncoreView.QiQ != null) {
        localShakeRandomEncoreView.QiQ.hat();
      }
      AppMethodBeat.o(310541);
    }
    
    public final void onRelease()
    {
      AppMethodBeat.i(310550);
      Log.i("ShakeRandomEncoreView", "onRelease");
      AppMethodBeat.o(310550);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.shakead.ShakeRandomEncoreView
 * JD-Core Version:    0.7.0.1
 */