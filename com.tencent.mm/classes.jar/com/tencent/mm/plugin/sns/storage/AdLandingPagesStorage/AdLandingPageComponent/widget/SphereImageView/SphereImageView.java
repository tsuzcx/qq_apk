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
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;

public class SphereImageView
  extends GLTextureView
{
  private float[] CPg;
  private float QVN;
  private float QVO;
  private float QVP;
  private float QVQ;
  private b QVR;
  private Sensor QVS;
  private float QVT;
  private long QVU;
  private float QVV;
  private boolean QVW;
  private a QVX;
  private int QVY;
  private int QVZ;
  private boolean QWa;
  private boolean QWb;
  private boolean QWc;
  protected GestureDetector.OnGestureListener QWd;
  protected View.OnClickListener QWe;
  protected View.OnLongClickListener QWf;
  protected Bitmap QWg;
  protected boolean QWh;
  protected b QWi;
  private Context mContext;
  Handler mHandler;
  private GestureDetector mQj;
  private SensorManager mSensorManager;
  private int mTouchSlop;
  protected String rAM;
  protected TextureView.SurfaceTextureListener sIN;
  private boolean vpd;
  
  public SphereImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97258);
    this.CPg = new float[3];
    this.QVT = 0.4F;
    this.QVU = 0L;
    this.vpd = true;
    this.QVW = false;
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
        float f1 = paramAnonymousMessage.QWo;
        float f2 = paramAnonymousMessage.QWn;
        float f3 = f1 - SphereImageView.b(SphereImageView.this);
        float f4 = f2 - SphereImageView.c(SphereImageView.this);
        paramAnonymousMessage = SphereImageView.d(SphereImageView.this);
        paramAnonymousMessage.QWy += f4 * 1.5F;
        paramAnonymousMessage = SphereImageView.d(SphereImageView.this);
        paramAnonymousMessage.QWx += f3 * 1.5F / 2.0F;
        if (SphereImageView.d(SphereImageView.this).QWx < -50.0F) {
          SphereImageView.d(SphereImageView.this).QWx = -50.0F;
        }
        for (;;)
        {
          SphereImageView.a(SphereImageView.this, f1);
          SphereImageView.b(SphereImageView.this, f2);
          if ((Math.abs(f4) <= 0.01F) && (Math.abs(f3) <= 0.01F)) {
            break;
          }
          long l = System.currentTimeMillis();
          SphereImageView.this.QUV.requestRender();
          if (((Math.abs(f4) <= 0.1F) && (Math.abs(f3) <= 0.1F)) || (l - SphereImageView.e(SphereImageView.this) <= 500L) || (SphereImageView.this.QWi == null)) {
            break;
          }
          SphereImageView.this.QWi.hjD();
          SphereImageView.a(SphereImageView.this, l);
          break;
          if (SphereImageView.d(SphereImageView.this).QWx > 50.0F) {
            SphereImageView.d(SphereImageView.this).QWx = 50.0F;
          }
        }
      }
    };
    this.QWa = true;
    this.QWb = false;
    this.QWc = false;
    this.QWd = new SphereImageView.2(this);
    this.QWg = null;
    this.QWh = false;
    this.rAM = "";
    this.sIN = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(97255);
        Log.i("SphereImageView.SphereView", "onSurfaceTextureAvailable, hasPendingImage=" + SphereImageView.this.QWh);
        if (SphereImageView.this.QWh)
        {
          SphereImageView.this.ag(SphereImageView.this.l(SphereImageView.this.QWg, SphereImageView.this.rAM));
          SphereImageView.this.QWg = null;
          SphereImageView.this.QWh = false;
          SphereImageView.this.rAM = "";
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
    a(this.sIN);
    this.QVR = new b(this.mContext);
    setRenderer(this.QVR);
    setRenderMode(0);
    this.mSensorManager = ((SensorManager)this.mContext.getSystemService("sensor"));
    this.QVS = this.mSensorManager.getDefaultSensor(4);
    if (this.QVS == null) {
      Log.e("SphereImageView.SphereView", "device has no Gyroscope sensor, model=" + q.aPo() + ", brand=" + Build.BRAND);
    }
    for (;;)
    {
      this.QVX = new a(this);
      this.mTouchSlop = (ViewConfiguration.get(paramContext).getScaledTouchSlop() / 4);
      if (this.mTouchSlop < 4) {
        this.mTouchSlop = 4;
      }
      this.mQj = new GestureDetector(paramContext, this.QWd);
      this.QVV = paramContext.getResources().getDisplayMetrics().density;
      Log.i("SphereImageView.SphereView", "init, displayDensity=" + this.QVV + ", apiLevel=" + Build.VERSION.SDK_INT + ", touchSlop=" + this.mTouchSlop);
      AppMethodBeat.o(97258);
      return;
      Log.i("SphereImageView.SphereView", "has Gyroscope sensor, model=" + q.aPo() + ", brand=" + Build.BRAND + ", sensor=" + this.QVS);
    }
  }
  
  private float dn(float paramFloat)
  {
    AppMethodBeat.i(97261);
    if (this.QVV == 0.0F)
    {
      this.QVV = 3.0F;
      Log.e("SphereImageView.SphereView", "px2Angle , mDisplayDensity==0");
    }
    paramFloat /= this.QVV;
    float f = this.QVT;
    AppMethodBeat.o(97261);
    return paramFloat * f;
  }
  
  public final void aV(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(97259);
    this.QVR.aV(paramFloat1, paramFloat2);
    AppMethodBeat.o(97259);
  }
  
  public PointF getCurAngle()
  {
    AppMethodBeat.i(97271);
    PointF localPointF = new PointF();
    localPointF.x = this.QVR.QWx;
    localPointF.y = this.QVR.QWy;
    AppMethodBeat.o(97271);
    return localPointF;
  }
  
  public final void hkt()
  {
    AppMethodBeat.i(97270);
    Log.i("SphereImageView.SphereView", "zero, hash=" + hashCode());
    this.QVR.QWy = 90.0F;
    this.QVR.QWx = 0.0F;
    AppMethodBeat.o(97270);
  }
  
  public final void k(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(97262);
    boolean bool = isAvailable();
    Log.i("SphereImageView.SphereView", "updateImage, isAvailable=" + bool + ", hasPendingImage=" + this.QWh);
    if (bool)
    {
      this.QWg = null;
      this.QWh = false;
      this.rAM = "";
      ag(l(paramBitmap, paramString));
      AppMethodBeat.o(97262);
      return;
    }
    this.QWg = paramBitmap;
    this.QWh = true;
    this.rAM = paramString;
    AppMethodBeat.o(97262);
  }
  
  protected final Runnable l(final Bitmap paramBitmap, final String paramString)
  {
    AppMethodBeat.i(97263);
    paramBitmap = new Runnable()
    {
      public final void run()
      {
        int j = 0;
        AppMethodBeat.i(97254);
        Object localObject1 = new StringBuilder("updateImage in GLThread, bmp.w=");
        if (paramBitmap == null)
        {
          i = 0;
          localObject1 = ((StringBuilder)localObject1).append(i).append(", h=");
          if (paramBitmap != null) {
            break label228;
          }
        }
        label228:
        for (int i = j;; i = paramBitmap.getHeight())
        {
          Log.i("SphereImageView.SphereView", i);
          localObject1 = SphereImageView.d(SphereImageView.this);
          Bitmap localBitmap = paramBitmap;
          try
          {
            long l = System.currentTimeMillis();
            if (((b)localObject1).QWw != 0)
            {
              GLES20.glDeleteTextures(1, new int[] { ((b)localObject1).QWw }, 0);
              Log.i("SphereImageView.SphereRender", "delete old texture");
            }
            i = c.aI(localBitmap);
            Log.i("SphereImageView.SphereRender", "updateImage, oldId=" + ((b)localObject1).QWw + ", newId=" + i + ", timeCost=" + (System.currentTimeMillis() - l));
            ((b)localObject1).QWw = i;
          }
          finally
          {
            for (;;)
            {
              Log.e("SphereImageView.SphereRender", "updateImage, exp:" + localObject2.toString());
            }
          }
          SphereImageView.this.QUV.requestRender();
          if (SphereImageView.this.QWi != null) {
            SphereImageView.this.mHandler.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97253);
                SphereImageView.this.QWi.aZA(SphereImageView.3.this.val$url);
                Log.i("SphereImageView.SphereView", "onUpdateImage, isAvailable=" + SphereImageView.this.isAvailable());
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
    this.QVW = false;
    Log.i("SphereImageView.SphereView", "onAttachedToWindow, hash=" + hashCode() + ", apiLevel=" + Build.VERSION.SDK_INT);
    hkt();
    AppMethodBeat.o(97264);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(97265);
    super.onDetachedFromWindow();
    this.QVW = true;
    Log.i("SphereImageView.SphereView", "onDetachedFromWindow, hash=" + hashCode());
    this.QWg = null;
    this.QWh = false;
    this.rAM = "";
    setSensorEnabled(false);
    ag(l(null, ""));
    hkt();
    if (this.QWi != null) {
      this.QWi.onDetachedFromWindow();
    }
    AppMethodBeat.o(97265);
  }
  
  public void onFinishTemporaryDetach()
  {
    AppMethodBeat.i(97266);
    if (Build.VERSION.SDK_INT < 24)
    {
      Log.i("SphereImageView.SphereView", "onFinishTemporaryDetach, hash=" + hashCode() + ", isAttach2Window=" + isAttachedToWindow());
      hkt();
      this.QVX.timestamp = 0L;
      this.QVX.QWl = true;
    }
    AppMethodBeat.o(97266);
  }
  
  public void onStartTemporaryDetach()
  {
    AppMethodBeat.i(97267);
    if (Build.VERSION.SDK_INT < 24)
    {
      Log.i("SphereImageView.SphereView", "onStartTemporaryDetach, hash=" + hashCode() + ", isAttach2Window=" + isAttachedToWindow());
      hkt();
      this.QVX.timestamp = 0L;
      this.QVX.QWl = false;
    }
    AppMethodBeat.o(97267);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(97260);
    GestureDetector localGestureDetector = this.mQj;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala.aYi(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    float f1;
    float f2;
    if (this.vpd)
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
      this.QVO = f1;
      this.QVQ = f2;
      this.QUV.requestRender();
      AppMethodBeat.o(97260);
      return true;
      this.QVY = ((int)f2);
      this.QVZ = ((int)f1);
      if (this.QWc)
      {
        this.QWb = false;
        this.QWa = true;
      }
      if (this.QWi != null)
      {
        this.QWi.hjE();
        continue;
        float f3 = this.QVO;
        float f4 = this.QVQ;
        if (this.QWc)
        {
          if ((!this.QWa) && (this.QWb))
          {
            getParent().requestDisallowInterceptTouchEvent(false);
            AppMethodBeat.o(97260);
            return false;
          }
          if ((!this.QWb) && ((int)Math.sqrt((f1 - this.QVZ) * (f1 - this.QVZ) + (f2 - this.QVY) * (f2 - this.QVY)) >= this.mTouchSlop))
          {
            this.QWb = true;
            if (Math.abs(f1 - this.QVZ) > Math.abs(f2 - this.QVY))
            {
              this.QWa = false;
              getParent().requestDisallowInterceptTouchEvent(false);
              AppMethodBeat.o(97260);
              return false;
            }
            this.QWa = true;
          }
        }
        paramMotionEvent = this.QVR;
        float f5 = paramMotionEvent.QWy;
        paramMotionEvent.QWy = (dn(f2 - f4) + f5);
        paramMotionEvent = this.QVR;
        f4 = paramMotionEvent.QWx;
        paramMotionEvent.QWx = (dn(f1 - f3) + f4);
        if (this.QVR.QWx < -50.0F)
        {
          this.QVR.QWx = -50.0F;
        }
        else if (this.QVR.QWx > 50.0F)
        {
          this.QVR.QWx = 50.0F;
          continue;
          if (this.QWc)
          {
            this.QWb = false;
            this.QWa = true;
          }
          if (this.QWi != null) {
            this.QWi.hjF();
          }
        }
      }
    }
  }
  
  public void setEventListener(b paramb)
  {
    this.QWi = paramb;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.QWe = paramOnClickListener;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.QWf = paramOnLongClickListener;
  }
  
  public void setOnlyHorizontalScroll(boolean paramBoolean)
  {
    this.QWc = paramBoolean;
  }
  
  public void setSensorEnabled(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(97268);
    if ((paramBoolean) && (this.QVW))
    {
      Log.e("SphereImageView.SphereView", "setSensorEnabled when isDetachedFromWindow");
      AppMethodBeat.o(97268);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("enableSensor, enabled=").append(paramBoolean).append(", hash=").append(hashCode()).append(", hasSensor=");
    if (this.QVS != null) {
      bool = true;
    }
    Log.i("SphereImageView.SphereView", bool);
    try
    {
      if (this.QVS == null) {
        break label185;
      }
      if (paramBoolean)
      {
        this.QVX.timestamp = 0L;
        this.mSensorManager.registerListener(this.QVX, this.QVS, 0);
        AppMethodBeat.o(97268);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e("SphereImageView.SphereView", "setSensorEnabled exp:" + localException.toString());
      AppMethodBeat.o(97268);
      return;
    }
    this.mSensorManager.unregisterListener(this.QVX);
    this.QVX.timestamp = 0L;
    label185:
    AppMethodBeat.o(97268);
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(97269);
    Log.i("SphereImageView.SphereView", "setTouchEnabled：" + paramBoolean + ", hash=" + hashCode());
    this.vpd = paramBoolean;
    AppMethodBeat.o(97269);
  }
  
  public void setTouchSensitivity(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.QVT = paramFloat;
    }
  }
  
  public static final class a
    implements SensorEventListener
  {
    public boolean QWl;
    WeakReference<SphereImageView> QWm;
    public long timestamp;
    
    public a(SphereImageView paramSphereImageView)
    {
      AppMethodBeat.i(97256);
      this.timestamp = 0L;
      this.QWl = true;
      this.QWm = new WeakReference(paramSphereImageView);
      AppMethodBeat.o(97256);
    }
    
    public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public final void onSensorChanged(SensorEvent paramSensorEvent)
    {
      AppMethodBeat.i(97257);
      SphereImageView localSphereImageView = (SphereImageView)this.QWm.get();
      if (localSphereImageView == null)
      {
        AppMethodBeat.o(97257);
        return;
      }
      if ((Build.VERSION.SDK_INT < 24) && (!this.QWl))
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
          paramSensorEvent.QWn = f2;
          paramSensorEvent.QWo = f1;
          paramSensorEvent.QWp = f3;
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
    public abstract void aZA(String paramString);
    
    public abstract void hjD();
    
    public abstract void hjE();
    
    public abstract void hjF();
    
    public abstract void onDetachedFromWindow();
  }
  
  protected static final class c
  {
    float QWn;
    float QWo;
    float QWp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView
 * JD-Core Version:    0.7.0.1
 */