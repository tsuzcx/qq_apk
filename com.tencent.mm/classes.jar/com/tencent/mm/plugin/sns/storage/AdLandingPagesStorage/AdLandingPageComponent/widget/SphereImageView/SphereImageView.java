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
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import java.util.List;

public class SphereImageView
  extends GLTextureView
{
  protected String kul;
  protected TextureView.SurfaceTextureListener lsU;
  private GestureDetector lsn;
  private Context mContext;
  Handler mHandler;
  private SensorManager mSensorManager;
  private int mTouchSlop;
  private boolean nLg;
  private float zKA;
  private float zKB;
  private b zKC;
  private Sensor zKD;
  private float[] zKE;
  private float zKF;
  private long zKG;
  private float zKH;
  private boolean zKI;
  private a zKJ;
  private int zKK;
  private int zKL;
  private boolean zKM;
  private boolean zKN;
  private boolean zKO;
  protected GestureDetector.OnGestureListener zKP;
  protected View.OnClickListener zKQ;
  protected View.OnLongClickListener zKR;
  protected Bitmap zKS;
  protected boolean zKT;
  protected b zKU;
  private float zKy;
  private float zKz;
  
  public SphereImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97258);
    this.zKE = new float[3];
    this.zKF = 0.4F;
    this.zKG = 0L;
    this.nLg = true;
    this.zKI = false;
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
        float f1 = paramAnonymousMessage.zLa;
        float f2 = paramAnonymousMessage.zKZ;
        float f3 = f1 - SphereImageView.b(SphereImageView.this);
        float f4 = f2 - SphereImageView.c(SphereImageView.this);
        paramAnonymousMessage = SphereImageView.d(SphereImageView.this);
        paramAnonymousMessage.zLk += f4 * 1.5F;
        paramAnonymousMessage = SphereImageView.d(SphereImageView.this);
        paramAnonymousMessage.zLj += f3 * 1.5F / 2.0F;
        if (SphereImageView.d(SphereImageView.this).zLj < -50.0F) {
          SphereImageView.d(SphereImageView.this).zLj = -50.0F;
        }
        for (;;)
        {
          SphereImageView.a(SphereImageView.this, f1);
          SphereImageView.b(SphereImageView.this, f2);
          if ((Math.abs(f4) <= 0.01F) && (Math.abs(f3) <= 0.01F)) {
            break;
          }
          long l = System.currentTimeMillis();
          SphereImageView.this.zJF.requestRender();
          if (((Math.abs(f4) <= 0.1F) && (Math.abs(f3) <= 0.1F)) || (l - SphereImageView.e(SphereImageView.this) <= 500L) || (SphereImageView.this.zKU == null)) {
            break;
          }
          SphereImageView.this.zKU.dXr();
          SphereImageView.a(SphereImageView.this, l);
          break;
          if (SphereImageView.d(SphereImageView.this).zLj > 50.0F) {
            SphereImageView.d(SphereImageView.this).zLj = 50.0F;
          }
        }
      }
    };
    this.zKM = true;
    this.zKN = false;
    this.zKO = false;
    this.zKP = new SphereImageView.2(this);
    this.zKS = null;
    this.zKT = false;
    this.kul = "";
    this.lsU = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(97255);
        ad.i("SphereImageView.SphereView", "onSurfaceTextureAvailable, hasPendingImage=" + SphereImageView.this.zKT);
        if (SphereImageView.this.zKT)
        {
          SphereImageView.this.queueEvent(SphereImageView.this.h(SphereImageView.this.zKS, SphereImageView.this.kul));
          SphereImageView.this.zKS = null;
          SphereImageView.this.zKT = false;
          SphereImageView.this.kul = "";
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
    paramAttributeSet = this.lsU;
    this.zJO.add(paramAttributeSet);
    this.zKC = new b(this.mContext);
    setRenderer(this.zKC);
    setRenderMode(0);
    this.mSensorManager = ((SensorManager)this.mContext.getSystemService("sensor"));
    this.zKD = this.mSensorManager.getDefaultSensor(4);
    if (this.zKD == null) {
      ad.e("SphereImageView.SphereView", "device has no Gyroscope sensor, model=" + Build.MODEL + ", brand=" + Build.BRAND);
    }
    for (;;)
    {
      this.zKJ = new a(this);
      this.mTouchSlop = (ViewConfiguration.get(paramContext).getScaledTouchSlop() / 4);
      if (this.mTouchSlop < 4) {
        this.mTouchSlop = 4;
      }
      this.lsn = new GestureDetector(paramContext, this.zKP);
      this.zKH = paramContext.getResources().getDisplayMetrics().density;
      ad.i("SphereImageView.SphereView", "init, displayDensity=" + this.zKH + ", apiLevel=" + Build.VERSION.SDK_INT + ", touchSlop=" + this.mTouchSlop);
      AppMethodBeat.o(97258);
      return;
      ad.i("SphereImageView.SphereView", "has Gyroscope sensor, model=" + Build.MODEL + ", brand=" + Build.BRAND + ", sensor=" + this.zKD);
    }
  }
  
  private float bE(float paramFloat)
  {
    AppMethodBeat.i(97261);
    if (this.zKH == 0.0F)
    {
      this.zKH = 3.0F;
      ad.e("SphereImageView.SphereView", "px2Angle , mDisplayDensity==0");
    }
    paramFloat /= this.zKH;
    float f = this.zKF;
    AppMethodBeat.o(97261);
    return paramFloat * f;
  }
  
  public final void ag(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(97259);
    this.zKC.ag(paramFloat1, paramFloat2);
    AppMethodBeat.o(97259);
  }
  
  public final void dXZ()
  {
    AppMethodBeat.i(97270);
    ad.i("SphereImageView.SphereView", "zero, hash=" + hashCode());
    this.zKC.zLk = 90.0F;
    this.zKC.zLj = 0.0F;
    AppMethodBeat.o(97270);
  }
  
  public final void g(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(97262);
    boolean bool = isAvailable();
    ad.i("SphereImageView.SphereView", "updateImage, isAvailable=" + bool + ", hasPendingImage=" + this.zKT);
    if (bool)
    {
      this.zKS = null;
      this.zKT = false;
      this.kul = "";
      queueEvent(h(paramBitmap, paramString));
      AppMethodBeat.o(97262);
      return;
    }
    this.zKS = paramBitmap;
    this.zKT = true;
    this.kul = paramString;
    AppMethodBeat.o(97262);
  }
  
  public PointF getCurAngle()
  {
    AppMethodBeat.i(97271);
    PointF localPointF = new PointF();
    localPointF.x = this.zKC.zLj;
    localPointF.y = this.zKC.zLk;
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
          ad.i("SphereImageView.SphereView", i);
          localObject = SphereImageView.d(SphereImageView.this);
          Bitmap localBitmap = paramBitmap;
          try
          {
            long l = System.currentTimeMillis();
            if (((b)localObject).zLi != 0)
            {
              GLES20.glDeleteTextures(1, new int[] { ((b)localObject).zLi }, 0);
              ad.i("SphereImageView.SphereRender", "delete old texture");
            }
            i = c.ao(localBitmap);
            ad.i("SphereImageView.SphereRender", "updateImage, oldId=" + ((b)localObject).zLi + ", newId=" + i + ", timeCost=" + (System.currentTimeMillis() - l));
            ((b)localObject).zLi = i;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              ad.e("SphereImageView.SphereRender", "updateImage, exp:" + localThrowable.toString());
            }
          }
          SphereImageView.this.zJF.requestRender();
          if (SphereImageView.this.zKU != null) {
            SphereImageView.this.mHandler.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97253);
                SphereImageView.this.zKU.azP(SphereImageView.3.this.val$url);
                ad.i("SphereImageView.SphereView", "onUpdateImage, isAvailable=" + SphereImageView.this.isAvailable());
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
    this.zKI = false;
    ad.i("SphereImageView.SphereView", "onAttachedToWindow, hash=" + hashCode() + ", apiLevel=" + Build.VERSION.SDK_INT);
    dXZ();
    AppMethodBeat.o(97264);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(97265);
    super.onDetachedFromWindow();
    this.zKI = true;
    ad.i("SphereImageView.SphereView", "onDetachedFromWindow, hash=" + hashCode());
    this.zKS = null;
    this.zKT = false;
    this.kul = "";
    setSensorEnabled(false);
    queueEvent(h(null, ""));
    dXZ();
    if (this.zKU != null) {
      this.zKU.onDetachedFromWindow();
    }
    AppMethodBeat.o(97265);
  }
  
  public void onFinishTemporaryDetach()
  {
    AppMethodBeat.i(97266);
    if (Build.VERSION.SDK_INT < 24)
    {
      ad.i("SphereImageView.SphereView", "onFinishTemporaryDetach, hash=" + hashCode() + ", isAttach2Window=" + isAttachedToWindow());
      dXZ();
      this.zKJ.timestamp = 0L;
      this.zKJ.zKX = true;
    }
    AppMethodBeat.o(97266);
  }
  
  public void onStartTemporaryDetach()
  {
    AppMethodBeat.i(97267);
    if (Build.VERSION.SDK_INT < 24)
    {
      ad.i("SphereImageView.SphereView", "onStartTemporaryDetach, hash=" + hashCode() + ", isAttach2Window=" + isAttachedToWindow());
      dXZ();
      this.zKJ.timestamp = 0L;
      this.zKJ.zKX = false;
    }
    AppMethodBeat.o(97267);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(97260);
    GestureDetector localGestureDetector = this.lsn;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahp(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mq(0)), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    float f1;
    float f2;
    if (this.nLg)
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
      this.zKz = f1;
      this.zKB = f2;
      this.zJF.requestRender();
      AppMethodBeat.o(97260);
      return true;
      this.zKK = ((int)f2);
      this.zKL = ((int)f1);
      if (this.zKO)
      {
        this.zKN = false;
        this.zKM = true;
      }
      if (this.zKU != null)
      {
        this.zKU.dXs();
        continue;
        float f3 = this.zKz;
        float f4 = this.zKB;
        if (this.zKO)
        {
          if ((!this.zKM) && (this.zKN))
          {
            getParent().requestDisallowInterceptTouchEvent(false);
            AppMethodBeat.o(97260);
            return false;
          }
          if ((!this.zKN) && ((int)Math.sqrt((f1 - this.zKL) * (f1 - this.zKL) + (f2 - this.zKK) * (f2 - this.zKK)) >= this.mTouchSlop))
          {
            this.zKN = true;
            if (Math.abs(f1 - this.zKL) > Math.abs(f2 - this.zKK))
            {
              this.zKM = false;
              getParent().requestDisallowInterceptTouchEvent(false);
              AppMethodBeat.o(97260);
              return false;
            }
            this.zKM = true;
          }
        }
        paramMotionEvent = this.zKC;
        float f5 = paramMotionEvent.zLk;
        paramMotionEvent.zLk = (bE(f2 - f4) + f5);
        paramMotionEvent = this.zKC;
        f4 = paramMotionEvent.zLj;
        paramMotionEvent.zLj = (bE(f1 - f3) + f4);
        if (this.zKC.zLj < -50.0F)
        {
          this.zKC.zLj = -50.0F;
        }
        else if (this.zKC.zLj > 50.0F)
        {
          this.zKC.zLj = 50.0F;
          continue;
          if (this.zKO)
          {
            this.zKN = false;
            this.zKM = true;
          }
          if (this.zKU != null) {
            this.zKU.dXt();
          }
        }
      }
    }
  }
  
  public void setEventListener(b paramb)
  {
    this.zKU = paramb;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.zKQ = paramOnClickListener;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.zKR = paramOnLongClickListener;
  }
  
  public void setOnlyHorizontalScroll(boolean paramBoolean)
  {
    this.zKO = paramBoolean;
  }
  
  public void setSensorEnabled(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(97268);
    if ((paramBoolean) && (this.zKI))
    {
      ad.e("SphereImageView.SphereView", "setSensorEnabled when isDetachedFromWindow");
      AppMethodBeat.o(97268);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("enableSensor, enabled=").append(paramBoolean).append(", hash=").append(hashCode()).append(", hasSensor=");
    if (this.zKD != null) {
      bool = true;
    }
    ad.i("SphereImageView.SphereView", bool);
    try
    {
      if (this.zKD == null) {
        break label185;
      }
      if (paramBoolean)
      {
        this.zKJ.timestamp = 0L;
        this.mSensorManager.registerListener(this.zKJ, this.zKD, 0);
        AppMethodBeat.o(97268);
        return;
      }
    }
    catch (Exception localException)
    {
      ad.e("SphereImageView.SphereView", "setSensorEnabled exp:" + localException.toString());
      AppMethodBeat.o(97268);
      return;
    }
    this.mSensorManager.unregisterListener(this.zKJ);
    this.zKJ.timestamp = 0L;
    label185:
    AppMethodBeat.o(97268);
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(97269);
    ad.i("SphereImageView.SphereView", "setTouchEnabled：" + paramBoolean + ", hash=" + hashCode());
    this.nLg = paramBoolean;
    AppMethodBeat.o(97269);
  }
  
  public void setTouchSensitivity(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.zKF = paramFloat;
    }
  }
  
  public static final class a
    implements SensorEventListener
  {
    public long timestamp;
    public boolean zKX;
    WeakReference<SphereImageView> zKY;
    
    public a(SphereImageView paramSphereImageView)
    {
      AppMethodBeat.i(97256);
      this.timestamp = 0L;
      this.zKX = true;
      this.zKY = new WeakReference(paramSphereImageView);
      AppMethodBeat.o(97256);
    }
    
    public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public final void onSensorChanged(SensorEvent paramSensorEvent)
    {
      AppMethodBeat.i(97257);
      SphereImageView localSphereImageView = (SphereImageView)this.zKY.get();
      if (localSphereImageView == null)
      {
        AppMethodBeat.o(97257);
        return;
      }
      if ((Build.VERSION.SDK_INT < 24) && (!this.zKX))
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
          paramSensorEvent.zKZ = f2;
          paramSensorEvent.zLa = f1;
          paramSensorEvent.zLb = f3;
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
    public abstract void azP(String paramString);
    
    public abstract void dXr();
    
    public abstract void dXs();
    
    public abstract void dXt();
    
    public abstract void onDetachedFromWindow();
  }
  
  protected static final class c
  {
    float zKZ;
    float zLa;
    float zLb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView
 * JD-Core Version:    0.7.0.1
 */