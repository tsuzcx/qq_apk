package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public class SphereImageView
  extends GLTextureView
{
  private SensorManager bmB;
  protected String hzS;
  private GestureDetector idY;
  private Context mContext;
  Handler mHandler;
  private float rAX;
  private float rAY;
  private float rAZ;
  private float rBa;
  private b rBb;
  private Sensor rBc;
  private float[] rBd;
  private float rBe;
  private long rBf;
  private boolean rBg;
  private float rBh;
  private boolean rBi;
  private SphereImageView.a rBj;
  protected GestureDetector.OnGestureListener rBk;
  protected View.OnClickListener rBl;
  protected View.OnLongClickListener rBm;
  protected Bitmap rBn;
  protected boolean rBo;
  protected TextureView.SurfaceTextureListener rBp;
  protected SphereImageView.b rBq;
  
  public SphereImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(145411);
    this.rBd = new float[3];
    this.rBe = 0.4F;
    this.rBf = 0L;
    this.rBg = true;
    this.rBi = false;
    this.mHandler = new SphereImageView.1(this);
    this.rBk = new SphereImageView.2(this);
    this.rBn = null;
    this.rBo = false;
    this.hzS = "";
    this.rBp = new SphereImageView.4(this);
    this.mContext = paramContext;
    setEGLContextClientVersion(2);
    paramAttributeSet = this.rBp;
    this.rAg.add(paramAttributeSet);
    this.rBb = new b(this.mContext);
    setRenderer(this.rBb);
    setRenderMode(0);
    this.bmB = ((SensorManager)this.mContext.getSystemService("sensor"));
    this.rBc = this.bmB.getDefaultSensor(4);
    if (this.rBc == null) {
      ab.e("SphereImageView.SphereView", "device has no Gyroscope sensor, model=" + Build.MODEL + ", brand=" + Build.BRAND);
    }
    for (;;)
    {
      this.rBj = new SphereImageView.a(this);
      this.idY = new GestureDetector(paramContext, this.rBk);
      this.rBh = paramContext.getResources().getDisplayMetrics().density;
      ab.i("SphereImageView.SphereView", "init, displayDensity=" + this.rBh + ", apiLevel=" + Build.VERSION.SDK_INT);
      AppMethodBeat.o(145411);
      return;
      ab.i("SphereImageView.SphereView", "has Gyroscope sensor, model=" + Build.MODEL + ", brand=" + Build.BRAND + ", sensor=" + this.rBc);
    }
  }
  
  private float bc(float paramFloat)
  {
    AppMethodBeat.i(145414);
    if (this.rBh == 0.0F)
    {
      this.rBh = 3.0F;
      ab.e("SphereImageView.SphereView", "px2Angle , mDisplayDensity==0");
    }
    paramFloat /= this.rBh;
    float f = this.rBe;
    AppMethodBeat.o(145414);
    return paramFloat * f;
  }
  
  public final void ad(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(145412);
    this.rBb.ad(paramFloat1, paramFloat2);
    AppMethodBeat.o(145412);
  }
  
  public final void crT()
  {
    AppMethodBeat.i(145423);
    ab.i("SphereImageView.SphereView", "zero, hash=" + hashCode());
    this.rBb.rBG = 90.0F;
    this.rBb.rBF = 0.0F;
    AppMethodBeat.o(145423);
  }
  
  public final void f(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(145415);
    boolean bool = isAvailable();
    ab.i("SphereImageView.SphereView", "updateImage, isAvailable=" + bool + ", hasPendingImage=" + this.rBo);
    if (bool)
    {
      this.rBn = null;
      this.rBo = false;
      this.hzS = "";
      queueEvent(g(paramBitmap, paramString));
      AppMethodBeat.o(145415);
      return;
    }
    this.rBn = paramBitmap;
    this.rBo = true;
    this.hzS = paramString;
    AppMethodBeat.o(145415);
  }
  
  protected final Runnable g(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(145416);
    paramBitmap = new SphereImageView.3(this, paramBitmap, paramString);
    AppMethodBeat.o(145416);
    return paramBitmap;
  }
  
  public PointF getCurAngle()
  {
    AppMethodBeat.i(145424);
    PointF localPointF = new PointF();
    localPointF.x = this.rBb.rBF;
    localPointF.y = this.rBb.rBG;
    AppMethodBeat.o(145424);
    return localPointF;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(145417);
    super.onAttachedToWindow();
    this.rBi = false;
    ab.i("SphereImageView.SphereView", "onAttachedToWindow, hash=" + hashCode() + ", apiLevel=" + Build.VERSION.SDK_INT);
    crT();
    AppMethodBeat.o(145417);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(145418);
    super.onDetachedFromWindow();
    this.rBi = true;
    ab.i("SphereImageView.SphereView", "onDetachedFromWindow, hash=" + hashCode());
    this.rBn = null;
    this.rBo = false;
    this.hzS = "";
    setSensorEnabled(false);
    queueEvent(g(null, ""));
    crT();
    if (this.rBq != null) {
      this.rBq.onDetachedFromWindow();
    }
    AppMethodBeat.o(145418);
  }
  
  public void onFinishTemporaryDetach()
  {
    AppMethodBeat.i(145419);
    if (Build.VERSION.SDK_INT < 24)
    {
      ab.i("SphereImageView.SphereView", "onFinishTemporaryDetach, hash=" + hashCode() + ", isAttach2Window=" + isAttachedToWindow());
      crT();
      this.rBj.timestamp = 0L;
      this.rBj.rBt = true;
    }
    AppMethodBeat.o(145419);
  }
  
  public void onStartTemporaryDetach()
  {
    AppMethodBeat.i(145420);
    if (Build.VERSION.SDK_INT < 24)
    {
      ab.i("SphereImageView.SphereView", "onStartTemporaryDetach, hash=" + hashCode() + ", isAttach2Window=" + isAttachedToWindow());
      crT();
      this.rBj.timestamp = 0L;
      this.rBj.rBt = false;
    }
    AppMethodBeat.o(145420);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(145413);
    this.idY.onTouchEvent(paramMotionEvent);
    float f1;
    float f2;
    if (this.rBg)
    {
      f1 = paramMotionEvent.getY();
      f2 = paramMotionEvent.getX();
      getParent().requestDisallowInterceptTouchEvent(true);
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      this.rAY = f1;
      this.rBa = f2;
      this.rzX.requestRender();
      AppMethodBeat.o(145413);
      return true;
      if (this.rBq != null)
      {
        this.rBq.crw();
        continue;
        float f3 = this.rAY;
        float f4 = this.rBa;
        paramMotionEvent = this.rBb;
        float f5 = paramMotionEvent.rBG;
        paramMotionEvent.rBG = (bc(f2 - f4) + f5);
        paramMotionEvent = this.rBb;
        f4 = paramMotionEvent.rBF;
        paramMotionEvent.rBF = (bc(f1 - f3) + f4);
        if (this.rBb.rBF < -50.0F)
        {
          this.rBb.rBF = -50.0F;
        }
        else if (this.rBb.rBF > 50.0F)
        {
          this.rBb.rBF = 50.0F;
          continue;
          if (this.rBq != null) {
            this.rBq.crx();
          }
        }
      }
    }
  }
  
  public void setEventListener(SphereImageView.b paramb)
  {
    this.rBq = paramb;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.rBl = paramOnClickListener;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.rBm = paramOnLongClickListener;
  }
  
  public void setSensorEnabled(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(145421);
    if ((paramBoolean) && (this.rBi))
    {
      ab.e("SphereImageView.SphereView", "setSensorEnabled when isDetachedFromWindow");
      AppMethodBeat.o(145421);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("enableSensor, enabled=").append(paramBoolean).append(", hash=").append(hashCode()).append(", hasSensor=");
    if (this.rBc != null) {
      bool = true;
    }
    ab.i("SphereImageView.SphereView", bool);
    try
    {
      if (this.rBc == null) {
        break label185;
      }
      if (paramBoolean)
      {
        this.rBj.timestamp = 0L;
        this.bmB.registerListener(this.rBj, this.rBc, 0);
        AppMethodBeat.o(145421);
        return;
      }
    }
    catch (Exception localException)
    {
      ab.e("SphereImageView.SphereView", "setSensorEnabled exp:" + localException.toString());
      AppMethodBeat.o(145421);
      return;
    }
    this.bmB.unregisterListener(this.rBj);
    this.rBj.timestamp = 0L;
    label185:
    AppMethodBeat.o(145421);
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(145422);
    ab.i("SphereImageView.SphereView", "setTouchEnabled：" + paramBoolean + ", hash=" + hashCode());
    this.rBg = paramBoolean;
    AppMethodBeat.o(145422);
  }
  
  public void setTouchSensitivity(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.rBe = paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView
 * JD-Core Version:    0.7.0.1
 */