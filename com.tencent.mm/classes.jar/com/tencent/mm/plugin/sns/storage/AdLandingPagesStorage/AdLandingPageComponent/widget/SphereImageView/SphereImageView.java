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

public class SphereImageView
  extends GLTextureView
{
  protected b KxA;
  private float Kxe;
  private float Kxf;
  private float Kxg;
  private float Kxh;
  private b Kxi;
  private Sensor Kxj;
  private float[] Kxk;
  private float Kxl;
  private long Kxm;
  private float Kxn;
  private boolean Kxo;
  private a Kxp;
  private int Kxq;
  private int Kxr;
  private boolean Kxs;
  private boolean Kxt;
  private boolean Kxu;
  protected GestureDetector.OnGestureListener Kxv;
  protected View.OnClickListener Kxw;
  protected View.OnLongClickListener Kxx;
  protected Bitmap Kxy;
  protected boolean Kxz;
  private Context mContext;
  Handler mHandler;
  private SensorManager mSensorManager;
  private int mTouchSlop;
  protected String oxn;
  private GestureDetector pCU;
  protected TextureView.SurfaceTextureListener pDB;
  private boolean sdB;
  
  public SphereImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97258);
    this.Kxk = new float[3];
    this.Kxl = 0.4F;
    this.Kxm = 0L;
    this.sdB = true;
    this.Kxo = false;
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
        float f1 = paramAnonymousMessage.KxG;
        float f2 = paramAnonymousMessage.KxF;
        float f3 = f1 - SphereImageView.b(SphereImageView.this);
        float f4 = f2 - SphereImageView.c(SphereImageView.this);
        paramAnonymousMessage = SphereImageView.d(SphereImageView.this);
        paramAnonymousMessage.KxQ += f4 * 1.5F;
        paramAnonymousMessage = SphereImageView.d(SphereImageView.this);
        paramAnonymousMessage.KxP += f3 * 1.5F / 2.0F;
        if (SphereImageView.d(SphereImageView.this).KxP < -50.0F) {
          SphereImageView.d(SphereImageView.this).KxP = -50.0F;
        }
        for (;;)
        {
          SphereImageView.a(SphereImageView.this, f1);
          SphereImageView.b(SphereImageView.this, f2);
          if ((Math.abs(f4) <= 0.01F) && (Math.abs(f3) <= 0.01F)) {
            break;
          }
          long l = System.currentTimeMillis();
          SphereImageView.this.Kwm.requestRender();
          if (((Math.abs(f4) <= 0.1F) && (Math.abs(f3) <= 0.1F)) || (l - SphereImageView.e(SphereImageView.this) <= 500L) || (SphereImageView.this.KxA == null)) {
            break;
          }
          SphereImageView.this.KxA.fRD();
          SphereImageView.a(SphereImageView.this, l);
          break;
          if (SphereImageView.d(SphereImageView.this).KxP > 50.0F) {
            SphereImageView.d(SphereImageView.this).KxP = 50.0F;
          }
        }
      }
    };
    this.Kxs = true;
    this.Kxt = false;
    this.Kxu = false;
    this.Kxv = new SphereImageView.2(this);
    this.Kxy = null;
    this.Kxz = false;
    this.oxn = "";
    this.pDB = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(97255);
        Log.i("SphereImageView.SphereView", "onSurfaceTextureAvailable, hasPendingImage=" + SphereImageView.this.Kxz);
        if (SphereImageView.this.Kxz)
        {
          SphereImageView.this.aa(SphereImageView.this.h(SphereImageView.this.Kxy, SphereImageView.this.oxn));
          SphereImageView.this.Kxy = null;
          SphereImageView.this.Kxz = false;
          SphereImageView.this.oxn = "";
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
    a(this.pDB);
    this.Kxi = new b(this.mContext);
    setRenderer(this.Kxi);
    setRenderMode(0);
    this.mSensorManager = ((SensorManager)this.mContext.getSystemService("sensor"));
    this.Kxj = this.mSensorManager.getDefaultSensor(4);
    if (this.Kxj == null) {
      Log.e("SphereImageView.SphereView", "device has no Gyroscope sensor, model=" + Build.MODEL + ", brand=" + Build.BRAND);
    }
    for (;;)
    {
      this.Kxp = new a(this);
      this.mTouchSlop = (ViewConfiguration.get(paramContext).getScaledTouchSlop() / 4);
      if (this.mTouchSlop < 4) {
        this.mTouchSlop = 4;
      }
      this.pCU = new GestureDetector(paramContext, this.Kxv);
      this.Kxn = paramContext.getResources().getDisplayMetrics().density;
      Log.i("SphereImageView.SphereView", "init, displayDensity=" + this.Kxn + ", apiLevel=" + Build.VERSION.SDK_INT + ", touchSlop=" + this.mTouchSlop);
      AppMethodBeat.o(97258);
      return;
      Log.i("SphereImageView.SphereView", "has Gyroscope sensor, model=" + Build.MODEL + ", brand=" + Build.BRAND + ", sensor=" + this.Kxj);
    }
  }
  
  private float ce(float paramFloat)
  {
    AppMethodBeat.i(97261);
    if (this.Kxn == 0.0F)
    {
      this.Kxn = 3.0F;
      Log.e("SphereImageView.SphereView", "px2Angle , mDisplayDensity==0");
    }
    paramFloat /= this.Kxn;
    float f = this.Kxl;
    AppMethodBeat.o(97261);
    return paramFloat * f;
  }
  
  public final void ap(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(97259);
    this.Kxi.ap(paramFloat1, paramFloat2);
    AppMethodBeat.o(97259);
  }
  
  public final void fSo()
  {
    AppMethodBeat.i(97270);
    Log.i("SphereImageView.SphereView", "zero, hash=" + hashCode());
    this.Kxi.KxQ = 90.0F;
    this.Kxi.KxP = 0.0F;
    AppMethodBeat.o(97270);
  }
  
  public final void g(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(97262);
    boolean bool = isAvailable();
    Log.i("SphereImageView.SphereView", "updateImage, isAvailable=" + bool + ", hasPendingImage=" + this.Kxz);
    if (bool)
    {
      this.Kxy = null;
      this.Kxz = false;
      this.oxn = "";
      aa(h(paramBitmap, paramString));
      AppMethodBeat.o(97262);
      return;
    }
    this.Kxy = paramBitmap;
    this.Kxz = true;
    this.oxn = paramString;
    AppMethodBeat.o(97262);
  }
  
  public PointF getCurAngle()
  {
    AppMethodBeat.i(97271);
    PointF localPointF = new PointF();
    localPointF.x = this.Kxi.KxP;
    localPointF.y = this.Kxi.KxQ;
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
            if (((b)localObject).KxO != 0)
            {
              GLES20.glDeleteTextures(1, new int[] { ((b)localObject).KxO }, 0);
              Log.i("SphereImageView.SphereRender", "delete old texture");
            }
            i = c.ax(localBitmap);
            Log.i("SphereImageView.SphereRender", "updateImage, oldId=" + ((b)localObject).KxO + ", newId=" + i + ", timeCost=" + (System.currentTimeMillis() - l));
            ((b)localObject).KxO = i;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              Log.e("SphereImageView.SphereRender", "updateImage, exp:" + localThrowable.toString());
            }
          }
          SphereImageView.this.Kwm.requestRender();
          if (SphereImageView.this.KxA != null) {
            SphereImageView.this.mHandler.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97253);
                SphereImageView.this.KxA.baZ(SphereImageView.3.this.val$url);
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
    this.Kxo = false;
    Log.i("SphereImageView.SphereView", "onAttachedToWindow, hash=" + hashCode() + ", apiLevel=" + Build.VERSION.SDK_INT);
    fSo();
    AppMethodBeat.o(97264);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(97265);
    super.onDetachedFromWindow();
    this.Kxo = true;
    Log.i("SphereImageView.SphereView", "onDetachedFromWindow, hash=" + hashCode());
    this.Kxy = null;
    this.Kxz = false;
    this.oxn = "";
    setSensorEnabled(false);
    aa(h(null, ""));
    fSo();
    if (this.KxA != null) {
      this.KxA.onDetachedFromWindow();
    }
    AppMethodBeat.o(97265);
  }
  
  public void onFinishTemporaryDetach()
  {
    AppMethodBeat.i(97266);
    if (Build.VERSION.SDK_INT < 24)
    {
      Log.i("SphereImageView.SphereView", "onFinishTemporaryDetach, hash=" + hashCode() + ", isAttach2Window=" + isAttachedToWindow());
      fSo();
      this.Kxp.timestamp = 0L;
      this.Kxp.KxD = true;
    }
    AppMethodBeat.o(97266);
  }
  
  public void onStartTemporaryDetach()
  {
    AppMethodBeat.i(97267);
    if (Build.VERSION.SDK_INT < 24)
    {
      Log.i("SphereImageView.SphereView", "onStartTemporaryDetach, hash=" + hashCode() + ", isAttach2Window=" + isAttachedToWindow());
      fSo();
      this.Kxp.timestamp = 0L;
      this.Kxp.KxD = false;
    }
    AppMethodBeat.o(97267);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(97260);
    GestureDetector localGestureDetector = this.pCU;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala.aFh(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.sf(0)), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    float f1;
    float f2;
    if (this.sdB)
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
      this.Kxf = f1;
      this.Kxh = f2;
      this.Kwm.requestRender();
      AppMethodBeat.o(97260);
      return true;
      this.Kxq = ((int)f2);
      this.Kxr = ((int)f1);
      if (this.Kxu)
      {
        this.Kxt = false;
        this.Kxs = true;
      }
      if (this.KxA != null)
      {
        this.KxA.fRE();
        continue;
        float f3 = this.Kxf;
        float f4 = this.Kxh;
        if (this.Kxu)
        {
          if ((!this.Kxs) && (this.Kxt))
          {
            getParent().requestDisallowInterceptTouchEvent(false);
            AppMethodBeat.o(97260);
            return false;
          }
          if ((!this.Kxt) && ((int)Math.sqrt((f1 - this.Kxr) * (f1 - this.Kxr) + (f2 - this.Kxq) * (f2 - this.Kxq)) >= this.mTouchSlop))
          {
            this.Kxt = true;
            if (Math.abs(f1 - this.Kxr) > Math.abs(f2 - this.Kxq))
            {
              this.Kxs = false;
              getParent().requestDisallowInterceptTouchEvent(false);
              AppMethodBeat.o(97260);
              return false;
            }
            this.Kxs = true;
          }
        }
        paramMotionEvent = this.Kxi;
        float f5 = paramMotionEvent.KxQ;
        paramMotionEvent.KxQ = (ce(f2 - f4) + f5);
        paramMotionEvent = this.Kxi;
        f4 = paramMotionEvent.KxP;
        paramMotionEvent.KxP = (ce(f1 - f3) + f4);
        if (this.Kxi.KxP < -50.0F)
        {
          this.Kxi.KxP = -50.0F;
        }
        else if (this.Kxi.KxP > 50.0F)
        {
          this.Kxi.KxP = 50.0F;
          continue;
          if (this.Kxu)
          {
            this.Kxt = false;
            this.Kxs = true;
          }
          if (this.KxA != null) {
            this.KxA.fRF();
          }
        }
      }
    }
  }
  
  public void setEventListener(b paramb)
  {
    this.KxA = paramb;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.Kxw = paramOnClickListener;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.Kxx = paramOnLongClickListener;
  }
  
  public void setOnlyHorizontalScroll(boolean paramBoolean)
  {
    this.Kxu = paramBoolean;
  }
  
  public void setSensorEnabled(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(97268);
    if ((paramBoolean) && (this.Kxo))
    {
      Log.e("SphereImageView.SphereView", "setSensorEnabled when isDetachedFromWindow");
      AppMethodBeat.o(97268);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("enableSensor, enabled=").append(paramBoolean).append(", hash=").append(hashCode()).append(", hasSensor=");
    if (this.Kxj != null) {
      bool = true;
    }
    Log.i("SphereImageView.SphereView", bool);
    try
    {
      if (this.Kxj == null) {
        break label185;
      }
      if (paramBoolean)
      {
        this.Kxp.timestamp = 0L;
        this.mSensorManager.registerListener(this.Kxp, this.Kxj, 0);
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
    this.mSensorManager.unregisterListener(this.Kxp);
    this.Kxp.timestamp = 0L;
    label185:
    AppMethodBeat.o(97268);
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(97269);
    Log.i("SphereImageView.SphereView", "setTouchEnabled：" + paramBoolean + ", hash=" + hashCode());
    this.sdB = paramBoolean;
    AppMethodBeat.o(97269);
  }
  
  public void setTouchSensitivity(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.Kxl = paramFloat;
    }
  }
  
  public static final class a
    implements SensorEventListener
  {
    public boolean KxD;
    WeakReference<SphereImageView> KxE;
    public long timestamp;
    
    public a(SphereImageView paramSphereImageView)
    {
      AppMethodBeat.i(97256);
      this.timestamp = 0L;
      this.KxD = true;
      this.KxE = new WeakReference(paramSphereImageView);
      AppMethodBeat.o(97256);
    }
    
    public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public final void onSensorChanged(SensorEvent paramSensorEvent)
    {
      AppMethodBeat.i(97257);
      SphereImageView localSphereImageView = (SphereImageView)this.KxE.get();
      if (localSphereImageView == null)
      {
        AppMethodBeat.o(97257);
        return;
      }
      if ((Build.VERSION.SDK_INT < 24) && (!this.KxD))
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
          paramSensorEvent.KxF = f2;
          paramSensorEvent.KxG = f1;
          paramSensorEvent.KxH = f3;
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
    public abstract void baZ(String paramString);
    
    public abstract void fRD();
    
    public abstract void fRE();
    
    public abstract void fRF();
    
    public abstract void onDetachedFromWindow();
  }
  
  protected static final class c
  {
    float KxF;
    float KxG;
    float KxH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView
 * JD-Core Version:    0.7.0.1
 */