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
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.List;

public class SphereImageView
  extends GLTextureView
{
  private float EjV;
  private float EjW;
  private float EjX;
  private float EjY;
  private b EjZ;
  private Sensor Eka;
  private float[] Ekb;
  private float Ekc;
  private long Ekd;
  private float Eke;
  private boolean Ekf;
  private a Ekg;
  private int Ekh;
  private int Eki;
  private boolean Ekj;
  private boolean Ekk;
  private boolean Ekl;
  protected GestureDetector.OnGestureListener Ekm;
  protected View.OnClickListener Ekn;
  protected View.OnLongClickListener Eko;
  protected Bitmap Ekp;
  protected boolean Ekq;
  protected b Ekr;
  protected String lBO;
  private Context mContext;
  private GestureDetector mDJ;
  protected TextureView.SurfaceTextureListener mEq;
  Handler mHandler;
  private SensorManager mSensorManager;
  private int mTouchSlop;
  private boolean pbB;
  
  public SphereImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97258);
    this.Ekb = new float[3];
    this.Ekc = 0.4F;
    this.Ekd = 0L;
    this.pbB = true;
    this.Ekf = false;
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
        float f1 = paramAnonymousMessage.Ekx;
        float f2 = paramAnonymousMessage.Ekw;
        float f3 = f1 - SphereImageView.b(SphereImageView.this);
        float f4 = f2 - SphereImageView.c(SphereImageView.this);
        paramAnonymousMessage = SphereImageView.d(SphereImageView.this);
        paramAnonymousMessage.EkH += f4 * 1.5F;
        paramAnonymousMessage = SphereImageView.d(SphereImageView.this);
        paramAnonymousMessage.EkG += f3 * 1.5F / 2.0F;
        if (SphereImageView.d(SphereImageView.this).EkG < -50.0F) {
          SphereImageView.d(SphereImageView.this).EkG = -50.0F;
        }
        for (;;)
        {
          SphereImageView.a(SphereImageView.this, f1);
          SphereImageView.b(SphereImageView.this, f2);
          if ((Math.abs(f4) <= 0.01F) && (Math.abs(f3) <= 0.01F)) {
            break;
          }
          long l = System.currentTimeMillis();
          SphereImageView.this.Ejd.requestRender();
          if (((Math.abs(f4) <= 0.1F) && (Math.abs(f3) <= 0.1F)) || (l - SphereImageView.e(SphereImageView.this) <= 500L) || (SphereImageView.this.Ekr == null)) {
            break;
          }
          SphereImageView.this.Ekr.fdK();
          SphereImageView.a(SphereImageView.this, l);
          break;
          if (SphereImageView.d(SphereImageView.this).EkG > 50.0F) {
            SphereImageView.d(SphereImageView.this).EkG = 50.0F;
          }
        }
      }
    };
    this.Ekj = true;
    this.Ekk = false;
    this.Ekl = false;
    this.Ekm = new SphereImageView.2(this);
    this.Ekp = null;
    this.Ekq = false;
    this.lBO = "";
    this.mEq = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(97255);
        Log.i("SphereImageView.SphereView", "onSurfaceTextureAvailable, hasPendingImage=" + SphereImageView.this.Ekq);
        if (SphereImageView.this.Ekq)
        {
          SphereImageView.this.queueEvent(SphereImageView.this.h(SphereImageView.this.Ekp, SphereImageView.this.lBO));
          SphereImageView.this.Ekp = null;
          SphereImageView.this.Ekq = false;
          SphereImageView.this.lBO = "";
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
    paramAttributeSet = this.mEq;
    this.Ejm.add(paramAttributeSet);
    this.EjZ = new b(this.mContext);
    setRenderer(this.EjZ);
    setRenderMode(0);
    this.mSensorManager = ((SensorManager)this.mContext.getSystemService("sensor"));
    this.Eka = this.mSensorManager.getDefaultSensor(4);
    if (this.Eka == null) {
      Log.e("SphereImageView.SphereView", "device has no Gyroscope sensor, model=" + Build.MODEL + ", brand=" + Build.BRAND);
    }
    for (;;)
    {
      this.Ekg = new a(this);
      this.mTouchSlop = (ViewConfiguration.get(paramContext).getScaledTouchSlop() / 4);
      if (this.mTouchSlop < 4) {
        this.mTouchSlop = 4;
      }
      this.mDJ = new GestureDetector(paramContext, this.Ekm);
      this.Eke = paramContext.getResources().getDisplayMetrics().density;
      Log.i("SphereImageView.SphereView", "init, displayDensity=" + this.Eke + ", apiLevel=" + Build.VERSION.SDK_INT + ", touchSlop=" + this.mTouchSlop);
      AppMethodBeat.o(97258);
      return;
      Log.i("SphereImageView.SphereView", "has Gyroscope sensor, model=" + Build.MODEL + ", brand=" + Build.BRAND + ", sensor=" + this.Eka);
    }
  }
  
  private float bW(float paramFloat)
  {
    AppMethodBeat.i(97261);
    if (this.Eke == 0.0F)
    {
      this.Eke = 3.0F;
      Log.e("SphereImageView.SphereView", "px2Angle , mDisplayDensity==0");
    }
    paramFloat /= this.Eke;
    float f = this.Ekc;
    AppMethodBeat.o(97261);
    return paramFloat * f;
  }
  
  public final void an(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(97259);
    this.EjZ.an(paramFloat1, paramFloat2);
    AppMethodBeat.o(97259);
  }
  
  public final void feu()
  {
    AppMethodBeat.i(97270);
    Log.i("SphereImageView.SphereView", "zero, hash=" + hashCode());
    this.EjZ.EkH = 90.0F;
    this.EjZ.EkG = 0.0F;
    AppMethodBeat.o(97270);
  }
  
  public final void g(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(97262);
    boolean bool = isAvailable();
    Log.i("SphereImageView.SphereView", "updateImage, isAvailable=" + bool + ", hasPendingImage=" + this.Ekq);
    if (bool)
    {
      this.Ekp = null;
      this.Ekq = false;
      this.lBO = "";
      queueEvent(h(paramBitmap, paramString));
      AppMethodBeat.o(97262);
      return;
    }
    this.Ekp = paramBitmap;
    this.Ekq = true;
    this.lBO = paramString;
    AppMethodBeat.o(97262);
  }
  
  public PointF getCurAngle()
  {
    AppMethodBeat.i(97271);
    PointF localPointF = new PointF();
    localPointF.x = this.EjZ.EkG;
    localPointF.y = this.EjZ.EkH;
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
          Log.i("SphereImageView.SphereView", i);
          localObject = SphereImageView.d(SphereImageView.this);
          Bitmap localBitmap = paramBitmap;
          try
          {
            long l = System.currentTimeMillis();
            if (((b)localObject).EkF != 0)
            {
              GLES20.glDeleteTextures(1, new int[] { ((b)localObject).EkF }, 0);
              Log.i("SphereImageView.SphereRender", "delete old texture");
            }
            i = c.aA(localBitmap);
            Log.i("SphereImageView.SphereRender", "updateImage, oldId=" + ((b)localObject).EkF + ", newId=" + i + ", timeCost=" + (System.currentTimeMillis() - l));
            ((b)localObject).EkF = i;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              Log.e("SphereImageView.SphereRender", "updateImage, exp:" + localThrowable.toString());
            }
          }
          SphereImageView.this.Ejd.requestRender();
          if (SphereImageView.this.Ekr != null) {
            SphereImageView.this.mHandler.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97253);
                SphereImageView.this.Ekr.aQa(SphereImageView.3.this.val$url);
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
    this.Ekf = false;
    Log.i("SphereImageView.SphereView", "onAttachedToWindow, hash=" + hashCode() + ", apiLevel=" + Build.VERSION.SDK_INT);
    feu();
    AppMethodBeat.o(97264);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(97265);
    super.onDetachedFromWindow();
    this.Ekf = true;
    Log.i("SphereImageView.SphereView", "onDetachedFromWindow, hash=" + hashCode());
    this.Ekp = null;
    this.Ekq = false;
    this.lBO = "";
    setSensorEnabled(false);
    queueEvent(h(null, ""));
    feu();
    if (this.Ekr != null) {
      this.Ekr.onDetachedFromWindow();
    }
    AppMethodBeat.o(97265);
  }
  
  public void onFinishTemporaryDetach()
  {
    AppMethodBeat.i(97266);
    if (Build.VERSION.SDK_INT < 24)
    {
      Log.i("SphereImageView.SphereView", "onFinishTemporaryDetach, hash=" + hashCode() + ", isAttach2Window=" + isAttachedToWindow());
      feu();
      this.Ekg.timestamp = 0L;
      this.Ekg.Eku = true;
    }
    AppMethodBeat.o(97266);
  }
  
  public void onStartTemporaryDetach()
  {
    AppMethodBeat.i(97267);
    if (Build.VERSION.SDK_INT < 24)
    {
      Log.i("SphereImageView.SphereView", "onStartTemporaryDetach, hash=" + hashCode() + ", isAttach2Window=" + isAttachedToWindow());
      feu();
      this.Ekg.timestamp = 0L;
      this.Ekg.Eku = false;
    }
    AppMethodBeat.o(97267);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(97260);
    GestureDetector localGestureDetector = this.mDJ;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.axQ(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    float f1;
    float f2;
    if (this.pbB)
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
      this.EjW = f1;
      this.EjY = f2;
      this.Ejd.requestRender();
      AppMethodBeat.o(97260);
      return true;
      this.Ekh = ((int)f2);
      this.Eki = ((int)f1);
      if (this.Ekl)
      {
        this.Ekk = false;
        this.Ekj = true;
      }
      if (this.Ekr != null)
      {
        this.Ekr.fdL();
        continue;
        float f3 = this.EjW;
        float f4 = this.EjY;
        if (this.Ekl)
        {
          if ((!this.Ekj) && (this.Ekk))
          {
            getParent().requestDisallowInterceptTouchEvent(false);
            AppMethodBeat.o(97260);
            return false;
          }
          if ((!this.Ekk) && ((int)Math.sqrt((f1 - this.Eki) * (f1 - this.Eki) + (f2 - this.Ekh) * (f2 - this.Ekh)) >= this.mTouchSlop))
          {
            this.Ekk = true;
            if (Math.abs(f1 - this.Eki) > Math.abs(f2 - this.Ekh))
            {
              this.Ekj = false;
              getParent().requestDisallowInterceptTouchEvent(false);
              AppMethodBeat.o(97260);
              return false;
            }
            this.Ekj = true;
          }
        }
        paramMotionEvent = this.EjZ;
        float f5 = paramMotionEvent.EkH;
        paramMotionEvent.EkH = (bW(f2 - f4) + f5);
        paramMotionEvent = this.EjZ;
        f4 = paramMotionEvent.EkG;
        paramMotionEvent.EkG = (bW(f1 - f3) + f4);
        if (this.EjZ.EkG < -50.0F)
        {
          this.EjZ.EkG = -50.0F;
        }
        else if (this.EjZ.EkG > 50.0F)
        {
          this.EjZ.EkG = 50.0F;
          continue;
          if (this.Ekl)
          {
            this.Ekk = false;
            this.Ekj = true;
          }
          if (this.Ekr != null) {
            this.Ekr.fdM();
          }
        }
      }
    }
  }
  
  public void setEventListener(b paramb)
  {
    this.Ekr = paramb;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.Ekn = paramOnClickListener;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.Eko = paramOnLongClickListener;
  }
  
  public void setOnlyHorizontalScroll(boolean paramBoolean)
  {
    this.Ekl = paramBoolean;
  }
  
  public void setSensorEnabled(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(97268);
    if ((paramBoolean) && (this.Ekf))
    {
      Log.e("SphereImageView.SphereView", "setSensorEnabled when isDetachedFromWindow");
      AppMethodBeat.o(97268);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("enableSensor, enabled=").append(paramBoolean).append(", hash=").append(hashCode()).append(", hasSensor=");
    if (this.Eka != null) {
      bool = true;
    }
    Log.i("SphereImageView.SphereView", bool);
    try
    {
      if (this.Eka == null) {
        break label185;
      }
      if (paramBoolean)
      {
        this.Ekg.timestamp = 0L;
        this.mSensorManager.registerListener(this.Ekg, this.Eka, 0);
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
    this.mSensorManager.unregisterListener(this.Ekg);
    this.Ekg.timestamp = 0L;
    label185:
    AppMethodBeat.o(97268);
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(97269);
    Log.i("SphereImageView.SphereView", "setTouchEnabled：" + paramBoolean + ", hash=" + hashCode());
    this.pbB = paramBoolean;
    AppMethodBeat.o(97269);
  }
  
  public void setTouchSensitivity(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.Ekc = paramFloat;
    }
  }
  
  public static final class a
    implements SensorEventListener
  {
    public boolean Eku;
    WeakReference<SphereImageView> Ekv;
    public long timestamp;
    
    public a(SphereImageView paramSphereImageView)
    {
      AppMethodBeat.i(97256);
      this.timestamp = 0L;
      this.Eku = true;
      this.Ekv = new WeakReference(paramSphereImageView);
      AppMethodBeat.o(97256);
    }
    
    public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public final void onSensorChanged(SensorEvent paramSensorEvent)
    {
      AppMethodBeat.i(97257);
      SphereImageView localSphereImageView = (SphereImageView)this.Ekv.get();
      if (localSphereImageView == null)
      {
        AppMethodBeat.o(97257);
        return;
      }
      if ((Build.VERSION.SDK_INT < 24) && (!this.Eku))
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
          paramSensorEvent.Ekw = f2;
          paramSensorEvent.Ekx = f1;
          paramSensorEvent.Eky = f3;
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
    public abstract void aQa(String paramString);
    
    public abstract void fdK();
    
    public abstract void fdL();
    
    public abstract void fdM();
    
    public abstract void onDetachedFromWindow();
  }
  
  protected static final class c
  {
    float Ekw;
    float Ekx;
    float Eky;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView
 * JD-Core Version:    0.7.0.1
 */