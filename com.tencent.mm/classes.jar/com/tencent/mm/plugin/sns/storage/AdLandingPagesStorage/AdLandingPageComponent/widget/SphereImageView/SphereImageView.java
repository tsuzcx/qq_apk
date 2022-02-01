package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
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
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;
import java.util.List;

public class SphereImageView
  extends GLTextureView
{
  protected String jZP;
  protected TextureView.SurfaceTextureListener kVV;
  private GestureDetector kVo;
  private Context mContext;
  Handler mHandler;
  private SensorManager mSensorManager;
  private boolean nkJ;
  private boolean ytA;
  private a ytB;
  protected GestureDetector.OnGestureListener ytC;
  protected View.OnClickListener ytD;
  protected View.OnLongClickListener ytE;
  protected Bitmap ytF;
  protected boolean ytG;
  protected b ytH;
  private float ytq;
  private float ytr;
  private float yts;
  private float ytt;
  private b ytu;
  private Sensor ytv;
  private float[] ytw;
  private float ytx;
  private long yty;
  private float ytz;
  
  public SphereImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97258);
    this.ytw = new float[3];
    this.ytx = 0.4F;
    this.yty = 0L;
    this.nkJ = true;
    this.ytA = false;
    this.mHandler = new Handler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(97250);
        switch (paramAnonymousMessage.what)
        {
        default: 
          AppMethodBeat.o(97250);
          return;
        }
        paramAnonymousMessage = (SphereImageView.c)paramAnonymousMessage.obj;
        float f1 = paramAnonymousMessage.ytN;
        float f2 = paramAnonymousMessage.ytM;
        float f3 = f1 - SphereImageView.b(SphereImageView.this);
        float f4 = f2 - SphereImageView.c(SphereImageView.this);
        paramAnonymousMessage = SphereImageView.d(SphereImageView.this);
        paramAnonymousMessage.ytX += f4 * 1.5F;
        paramAnonymousMessage = SphereImageView.d(SphereImageView.this);
        paramAnonymousMessage.ytW += f3 * 1.5F / 2.0F;
        if (SphereImageView.d(SphereImageView.this).ytW < -50.0F) {
          SphereImageView.d(SphereImageView.this).ytW = -50.0F;
        }
        for (;;)
        {
          SphereImageView.a(SphereImageView.this, f1);
          SphereImageView.b(SphereImageView.this, f2);
          if ((Math.abs(f4) <= 0.01F) && (Math.abs(f3) <= 0.01F)) {
            break;
          }
          long l = System.currentTimeMillis();
          SphereImageView.this.ysx.requestRender();
          if (((Math.abs(f4) <= 0.1F) && (Math.abs(f3) <= 0.1F)) || (l - SphereImageView.e(SphereImageView.this) <= 500L) || (SphereImageView.this.ytH == null)) {
            break;
          }
          SphereImageView.this.ytH.dLa();
          SphereImageView.a(SphereImageView.this, l);
          break;
          if (SphereImageView.d(SphereImageView.this).ytW > 50.0F) {
            SphereImageView.d(SphereImageView.this).ytW = 50.0F;
          }
        }
      }
    };
    this.ytC = new SphereImageView.2(this);
    this.ytF = null;
    this.ytG = false;
    this.jZP = "";
    this.kVV = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(97255);
        ac.i("SphereImageView.SphereView", "onSurfaceTextureAvailable, hasPendingImage=" + SphereImageView.this.ytG);
        if (SphereImageView.this.ytG)
        {
          SphereImageView.this.queueEvent(SphereImageView.this.h(SphereImageView.this.ytF, SphereImageView.this.jZP));
          SphereImageView.this.ytF = null;
          SphereImageView.this.ytG = false;
          SphereImageView.this.jZP = "";
        }
        AppMethodBeat.o(97255);
      }
      
      public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramAnonymousSurfaceTexture)
      {
        return false;
      }
      
      public final void onSurfaceTextureSizeChanged(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void onSurfaceTextureUpdated(SurfaceTexture paramAnonymousSurfaceTexture) {}
    };
    this.mContext = paramContext;
    setEGLContextClientVersion(2);
    paramAttributeSet = this.kVV;
    this.ysG.add(paramAttributeSet);
    this.ytu = new b(this.mContext);
    setRenderer(this.ytu);
    setRenderMode(0);
    this.mSensorManager = ((SensorManager)this.mContext.getSystemService("sensor"));
    this.ytv = this.mSensorManager.getDefaultSensor(4);
    if (this.ytv == null) {
      ac.e("SphereImageView.SphereView", "device has no Gyroscope sensor, model=" + Build.MODEL + ", brand=" + Build.BRAND);
    }
    for (;;)
    {
      this.ytB = new a(this);
      this.kVo = new GestureDetector(paramContext, this.ytC);
      this.ytz = paramContext.getResources().getDisplayMetrics().density;
      ac.i("SphereImageView.SphereView", "init, displayDensity=" + this.ytz + ", apiLevel=" + Build.VERSION.SDK_INT);
      AppMethodBeat.o(97258);
      return;
      ac.i("SphereImageView.SphereView", "has Gyroscope sensor, model=" + Build.MODEL + ", brand=" + Build.BRAND + ", sensor=" + this.ytv);
    }
  }
  
  private float bB(float paramFloat)
  {
    AppMethodBeat.i(97261);
    if (this.ytz == 0.0F)
    {
      this.ytz = 3.0F;
      ac.e("SphereImageView.SphereView", "px2Angle , mDisplayDensity==0");
    }
    paramFloat /= this.ytz;
    float f = this.ytx;
    AppMethodBeat.o(97261);
    return paramFloat * f;
  }
  
  public final void ab(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(97259);
    this.ytu.ab(paramFloat1, paramFloat2);
    AppMethodBeat.o(97259);
  }
  
  public final void dLJ()
  {
    AppMethodBeat.i(97270);
    ac.i("SphereImageView.SphereView", "zero, hash=" + hashCode());
    this.ytu.ytX = 90.0F;
    this.ytu.ytW = 0.0F;
    AppMethodBeat.o(97270);
  }
  
  public final void g(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(97262);
    boolean bool = isAvailable();
    ac.i("SphereImageView.SphereView", "updateImage, isAvailable=" + bool + ", hasPendingImage=" + this.ytG);
    if (bool)
    {
      this.ytF = null;
      this.ytG = false;
      this.jZP = "";
      queueEvent(h(paramBitmap, paramString));
      AppMethodBeat.o(97262);
      return;
    }
    this.ytF = paramBitmap;
    this.ytG = true;
    this.jZP = paramString;
    AppMethodBeat.o(97262);
  }
  
  public PointF getCurAngle()
  {
    AppMethodBeat.i(97271);
    PointF localPointF = new PointF();
    localPointF.x = this.ytu.ytW;
    localPointF.y = this.ytu.ytX;
    AppMethodBeat.o(97271);
    return localPointF;
  }
  
  protected final Runnable h(final Bitmap paramBitmap, final String paramString)
  {
    AppMethodBeat.i(97263);
    paramBitmap = new Runnable()
    {
      public final void run()
      {
        int j = 0;
        AppMethodBeat.i(97254);
        Object localObject = new StringBuilder("updateImage in GLThread, bmp.w=");
        if (paramBitmap == null)
        {
          i = 0;
          localObject = ((StringBuilder)localObject).append(i).append(", h=");
          if (paramBitmap != null) {
            break label228;
          }
        }
        label228:
        for (int i = j;; i = paramBitmap.getHeight())
        {
          ac.i("SphereImageView.SphereView", i);
          localObject = SphereImageView.d(SphereImageView.this);
          Bitmap localBitmap = paramBitmap;
          try
          {
            long l = System.currentTimeMillis();
            if (((b)localObject).ytV != 0)
            {
              GLES20.glDeleteTextures(1, new int[] { ((b)localObject).ytV }, 0);
              ac.i("SphereImageView.SphereRender", "delete old texture");
            }
            i = c.am(localBitmap);
            ac.i("SphereImageView.SphereRender", "updateImage, oldId=" + ((b)localObject).ytV + ", newId=" + i + ", timeCost=" + (System.currentTimeMillis() - l));
            ((b)localObject).ytV = i;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              ac.e("SphereImageView.SphereRender", "updateImage, exp:" + localThrowable.toString());
            }
          }
          SphereImageView.this.ysx.requestRender();
          if (SphereImageView.this.ytH != null) {
            SphereImageView.this.mHandler.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97253);
                SphereImageView.this.ytH.auI(SphereImageView.3.this.val$url);
                ac.i("SphereImageView.SphereView", "onUpdateImage, isAvailable=" + SphereImageView.this.isAvailable());
                AppMethodBeat.o(97253);
              }
            });
          }
          AppMethodBeat.o(97254);
          return;
          i = paramBitmap.getWidth();
          break;
        }
      }
    };
    AppMethodBeat.o(97263);
    return paramBitmap;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(97264);
    super.onAttachedToWindow();
    this.ytA = false;
    ac.i("SphereImageView.SphereView", "onAttachedToWindow, hash=" + hashCode() + ", apiLevel=" + Build.VERSION.SDK_INT);
    dLJ();
    AppMethodBeat.o(97264);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(97265);
    super.onDetachedFromWindow();
    this.ytA = true;
    ac.i("SphereImageView.SphereView", "onDetachedFromWindow, hash=" + hashCode());
    this.ytF = null;
    this.ytG = false;
    this.jZP = "";
    setSensorEnabled(false);
    queueEvent(h(null, ""));
    dLJ();
    if (this.ytH != null) {
      this.ytH.onDetachedFromWindow();
    }
    AppMethodBeat.o(97265);
  }
  
  public void onFinishTemporaryDetach()
  {
    AppMethodBeat.i(97266);
    if (Build.VERSION.SDK_INT < 24)
    {
      ac.i("SphereImageView.SphereView", "onFinishTemporaryDetach, hash=" + hashCode() + ", isAttach2Window=" + isAttachedToWindow());
      dLJ();
      this.ytB.timestamp = 0L;
      this.ytB.ytK = true;
    }
    AppMethodBeat.o(97266);
  }
  
  public void onStartTemporaryDetach()
  {
    AppMethodBeat.i(97267);
    if (Build.VERSION.SDK_INT < 24)
    {
      ac.i("SphereImageView.SphereView", "onStartTemporaryDetach, hash=" + hashCode() + ", isAttach2Window=" + isAttachedToWindow());
      dLJ();
      this.ytB.timestamp = 0L;
      this.ytB.ytK = false;
    }
    AppMethodBeat.o(97267);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(97260);
    this.kVo.onTouchEvent(paramMotionEvent);
    float f1;
    float f2;
    if (this.nkJ)
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
      this.ytr = f1;
      this.ytt = f2;
      this.ysx.requestRender();
      AppMethodBeat.o(97260);
      return true;
      if (this.ytH != null)
      {
        this.ytH.dLb();
        continue;
        float f3 = this.ytr;
        float f4 = this.ytt;
        paramMotionEvent = this.ytu;
        float f5 = paramMotionEvent.ytX;
        paramMotionEvent.ytX = (bB(f2 - f4) + f5);
        paramMotionEvent = this.ytu;
        f4 = paramMotionEvent.ytW;
        paramMotionEvent.ytW = (bB(f1 - f3) + f4);
        if (this.ytu.ytW < -50.0F)
        {
          this.ytu.ytW = -50.0F;
        }
        else if (this.ytu.ytW > 50.0F)
        {
          this.ytu.ytW = 50.0F;
          continue;
          if (this.ytH != null) {
            this.ytH.dLc();
          }
        }
      }
    }
  }
  
  public void setEventListener(b paramb)
  {
    this.ytH = paramb;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.ytD = paramOnClickListener;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.ytE = paramOnLongClickListener;
  }
  
  public void setSensorEnabled(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(97268);
    if ((paramBoolean) && (this.ytA))
    {
      ac.e("SphereImageView.SphereView", "setSensorEnabled when isDetachedFromWindow");
      AppMethodBeat.o(97268);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("enableSensor, enabled=").append(paramBoolean).append(", hash=").append(hashCode()).append(", hasSensor=");
    if (this.ytv != null) {
      bool = true;
    }
    ac.i("SphereImageView.SphereView", bool);
    try
    {
      if (this.ytv == null) {
        break label185;
      }
      if (paramBoolean)
      {
        this.ytB.timestamp = 0L;
        this.mSensorManager.registerListener(this.ytB, this.ytv, 0);
        AppMethodBeat.o(97268);
        return;
      }
    }
    catch (Exception localException)
    {
      ac.e("SphereImageView.SphereView", "setSensorEnabled exp:" + localException.toString());
      AppMethodBeat.o(97268);
      return;
    }
    this.mSensorManager.unregisterListener(this.ytB);
    this.ytB.timestamp = 0L;
    label185:
    AppMethodBeat.o(97268);
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(97269);
    ac.i("SphereImageView.SphereView", "setTouchEnabled：" + paramBoolean + ", hash=" + hashCode());
    this.nkJ = paramBoolean;
    AppMethodBeat.o(97269);
  }
  
  public void setTouchSensitivity(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.ytx = paramFloat;
    }
  }
  
  public static final class a
    implements SensorEventListener
  {
    public long timestamp;
    public boolean ytK;
    WeakReference<SphereImageView> ytL;
    
    public a(SphereImageView paramSphereImageView)
    {
      AppMethodBeat.i(97256);
      this.timestamp = 0L;
      this.ytK = true;
      this.ytL = new WeakReference(paramSphereImageView);
      AppMethodBeat.o(97256);
    }
    
    public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public final void onSensorChanged(SensorEvent paramSensorEvent)
    {
      AppMethodBeat.i(97257);
      SphereImageView localSphereImageView = (SphereImageView)this.ytL.get();
      if (localSphereImageView == null)
      {
        AppMethodBeat.o(97257);
        return;
      }
      if ((Build.VERSION.SDK_INT < 24) && (!this.ytK))
      {
        AppMethodBeat.o(97257);
        return;
      }
      if (paramSensorEvent.sensor.getType() == 4)
      {
        if (this.timestamp != 0L)
        {
          long l = System.currentTimeMillis();
          float f1 = (float)(l - this.timestamp) / 1000.0F;
          if (f1 < 0.012D)
          {
            AppMethodBeat.o(97257);
            return;
          }
          this.timestamp = l;
          Object localObject = SphereImageView.a(localSphereImageView);
          localObject[0] += paramSensorEvent.values[0] * f1;
          localObject = SphereImageView.a(localSphereImageView);
          localObject[1] += paramSensorEvent.values[1] * f1;
          localObject = SphereImageView.a(localSphereImageView);
          float f2 = localObject[2];
          localObject[2] = (f1 * paramSensorEvent.values[2] + f2);
          f1 = (float)Math.toDegrees(SphereImageView.a(localSphereImageView)[0]);
          f2 = (float)Math.toDegrees(SphereImageView.a(localSphereImageView)[1]);
          float f3 = (float)Math.toDegrees(SphereImageView.a(localSphereImageView)[2]);
          paramSensorEvent = new SphereImageView.c();
          paramSensorEvent.ytM = f2;
          paramSensorEvent.ytN = f1;
          paramSensorEvent.ytO = f3;
          localObject = Message.obtain();
          ((Message)localObject).what = 1;
          ((Message)localObject).obj = paramSensorEvent;
          localSphereImageView.mHandler.sendMessage((Message)localObject);
          AppMethodBeat.o(97257);
          return;
        }
        this.timestamp = System.currentTimeMillis();
      }
      AppMethodBeat.o(97257);
    }
  }
  
  public static abstract interface b
  {
    public abstract void auI(String paramString);
    
    public abstract void dLa();
    
    public abstract void dLb();
    
    public abstract void dLc();
    
    public abstract void onDetachedFromWindow();
  }
  
  protected static final class c
  {
    float ytM;
    float ytN;
    float ytO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView
 * JD-Core Version:    0.7.0.1
 */