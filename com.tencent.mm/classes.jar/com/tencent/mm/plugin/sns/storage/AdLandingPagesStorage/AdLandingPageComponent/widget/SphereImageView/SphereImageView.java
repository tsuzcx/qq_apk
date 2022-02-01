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
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import java.util.List;

public class SphereImageView
  extends GLTextureView
{
  protected String jzs;
  private GestureDetector ktZ;
  protected TextureView.SurfaceTextureListener kuG;
  private Context mContext;
  Handler mHandler;
  private boolean mIG;
  private SensorManager mSensorManager;
  private float xgC;
  private float xgD;
  private float xgE;
  private float xgF;
  private b xgG;
  private Sensor xgH;
  private float[] xgI;
  private float xgJ;
  private long xgK;
  private float xgL;
  private boolean xgM;
  private a xgN;
  protected GestureDetector.OnGestureListener xgO;
  protected View.OnClickListener xgP;
  protected View.OnLongClickListener xgQ;
  protected Bitmap xgR;
  protected boolean xgS;
  protected b xgT;
  
  public SphereImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97258);
    this.xgI = new float[3];
    this.xgJ = 0.4F;
    this.xgK = 0L;
    this.mIG = true;
    this.xgM = false;
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
        float f1 = paramAnonymousMessage.xgZ;
        float f2 = paramAnonymousMessage.xgY;
        float f3 = f1 - SphereImageView.b(SphereImageView.this);
        float f4 = f2 - SphereImageView.c(SphereImageView.this);
        paramAnonymousMessage = SphereImageView.d(SphereImageView.this);
        paramAnonymousMessage.xhj += f4 * 1.5F;
        paramAnonymousMessage = SphereImageView.d(SphereImageView.this);
        paramAnonymousMessage.xhi += f3 * 1.5F / 2.0F;
        if (SphereImageView.d(SphereImageView.this).xhi < -50.0F) {
          SphereImageView.d(SphereImageView.this).xhi = -50.0F;
        }
        for (;;)
        {
          SphereImageView.a(SphereImageView.this, f1);
          SphereImageView.b(SphereImageView.this, f2);
          if ((Math.abs(f4) <= 0.01F) && (Math.abs(f3) <= 0.01F)) {
            break;
          }
          long l = System.currentTimeMillis();
          SphereImageView.this.xfJ.requestRender();
          if (((Math.abs(f4) <= 0.1F) && (Math.abs(f3) <= 0.1F)) || (l - SphereImageView.e(SphereImageView.this) <= 500L) || (SphereImageView.this.xgT == null)) {
            break;
          }
          SphereImageView.this.xgT.dwB();
          SphereImageView.a(SphereImageView.this, l);
          break;
          if (SphereImageView.d(SphereImageView.this).xhi > 50.0F) {
            SphereImageView.d(SphereImageView.this).xhi = 50.0F;
          }
        }
      }
    };
    this.xgO = new GestureDetector.OnGestureListener()
    {
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return false;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(97252);
        if (SphereImageView.this.xgQ != null)
        {
          SphereImageView.this.xgQ.onLongClick(SphereImageView.this);
          ad.i("SphereImageView.SphereView", "onLongPress, hash=" + hashCode());
        }
        AppMethodBeat.o(97252);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        return false;
      }
      
      public final void onShowPress(MotionEvent paramAnonymousMotionEvent) {}
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(97251);
        if (SphereImageView.this.xgP != null)
        {
          SphereImageView.this.xgP.onClick(SphereImageView.this);
          ad.i("SphereImageView.SphereView", "onClick, hash=" + hashCode());
        }
        AppMethodBeat.o(97251);
        return true;
      }
    };
    this.xgR = null;
    this.xgS = false;
    this.jzs = "";
    this.kuG = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(97255);
        ad.i("SphereImageView.SphereView", "onSurfaceTextureAvailable, hasPendingImage=" + SphereImageView.this.xgS);
        if (SphereImageView.this.xgS)
        {
          SphereImageView.this.queueEvent(SphereImageView.this.h(SphereImageView.this.xgR, SphereImageView.this.jzs));
          SphereImageView.this.xgR = null;
          SphereImageView.this.xgS = false;
          SphereImageView.this.jzs = "";
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
    paramAttributeSet = this.kuG;
    this.xfS.add(paramAttributeSet);
    this.xgG = new b(this.mContext);
    setRenderer(this.xgG);
    setRenderMode(0);
    this.mSensorManager = ((SensorManager)this.mContext.getSystemService("sensor"));
    this.xgH = this.mSensorManager.getDefaultSensor(4);
    if (this.xgH == null) {
      ad.e("SphereImageView.SphereView", "device has no Gyroscope sensor, model=" + Build.MODEL + ", brand=" + Build.BRAND);
    }
    for (;;)
    {
      this.xgN = new a(this);
      this.ktZ = new GestureDetector(paramContext, this.xgO);
      this.xgL = paramContext.getResources().getDisplayMetrics().density;
      ad.i("SphereImageView.SphereView", "init, displayDensity=" + this.xgL + ", apiLevel=" + Build.VERSION.SDK_INT);
      AppMethodBeat.o(97258);
      return;
      ad.i("SphereImageView.SphereView", "has Gyroscope sensor, model=" + Build.MODEL + ", brand=" + Build.BRAND + ", sensor=" + this.xgH);
    }
  }
  
  private float bt(float paramFloat)
  {
    AppMethodBeat.i(97261);
    if (this.xgL == 0.0F)
    {
      this.xgL = 3.0F;
      ad.e("SphereImageView.SphereView", "px2Angle , mDisplayDensity==0");
    }
    paramFloat /= this.xgL;
    float f = this.xgJ;
    AppMethodBeat.o(97261);
    return paramFloat * f;
  }
  
  public final void X(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(97259);
    this.xgG.X(paramFloat1, paramFloat2);
    AppMethodBeat.o(97259);
  }
  
  public final void dxk()
  {
    AppMethodBeat.i(97270);
    ad.i("SphereImageView.SphereView", "zero, hash=" + hashCode());
    this.xgG.xhj = 90.0F;
    this.xgG.xhi = 0.0F;
    AppMethodBeat.o(97270);
  }
  
  public final void g(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(97262);
    boolean bool = isAvailable();
    ad.i("SphereImageView.SphereView", "updateImage, isAvailable=" + bool + ", hasPendingImage=" + this.xgS);
    if (bool)
    {
      this.xgR = null;
      this.xgS = false;
      this.jzs = "";
      queueEvent(h(paramBitmap, paramString));
      AppMethodBeat.o(97262);
      return;
    }
    this.xgR = paramBitmap;
    this.xgS = true;
    this.jzs = paramString;
    AppMethodBeat.o(97262);
  }
  
  public PointF getCurAngle()
  {
    AppMethodBeat.i(97271);
    PointF localPointF = new PointF();
    localPointF.x = this.xgG.xhi;
    localPointF.y = this.xgG.xhj;
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
            if (((b)localObject).xhh != 0)
            {
              GLES20.glDeleteTextures(1, new int[] { ((b)localObject).xhh }, 0);
              ad.i("SphereImageView.SphereRender", "delete old texture");
            }
            i = c.al(localBitmap);
            ad.i("SphereImageView.SphereRender", "updateImage, oldId=" + ((b)localObject).xhh + ", newId=" + i + ", timeCost=" + (System.currentTimeMillis() - l));
            ((b)localObject).xhh = i;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              ad.e("SphereImageView.SphereRender", "updateImage, exp:" + localThrowable.toString());
            }
          }
          SphereImageView.this.xfJ.requestRender();
          if (SphereImageView.this.xgT != null) {
            SphereImageView.this.mHandler.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97253);
                SphereImageView.this.xgT.apy(SphereImageView.3.this.val$url);
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
    this.xgM = false;
    ad.i("SphereImageView.SphereView", "onAttachedToWindow, hash=" + hashCode() + ", apiLevel=" + Build.VERSION.SDK_INT);
    dxk();
    AppMethodBeat.o(97264);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(97265);
    super.onDetachedFromWindow();
    this.xgM = true;
    ad.i("SphereImageView.SphereView", "onDetachedFromWindow, hash=" + hashCode());
    this.xgR = null;
    this.xgS = false;
    this.jzs = "";
    setSensorEnabled(false);
    queueEvent(h(null, ""));
    dxk();
    if (this.xgT != null) {
      this.xgT.onDetachedFromWindow();
    }
    AppMethodBeat.o(97265);
  }
  
  public void onFinishTemporaryDetach()
  {
    AppMethodBeat.i(97266);
    if (Build.VERSION.SDK_INT < 24)
    {
      ad.i("SphereImageView.SphereView", "onFinishTemporaryDetach, hash=" + hashCode() + ", isAttach2Window=" + isAttachedToWindow());
      dxk();
      this.xgN.timestamp = 0L;
      this.xgN.xgW = true;
    }
    AppMethodBeat.o(97266);
  }
  
  public void onStartTemporaryDetach()
  {
    AppMethodBeat.i(97267);
    if (Build.VERSION.SDK_INT < 24)
    {
      ad.i("SphereImageView.SphereView", "onStartTemporaryDetach, hash=" + hashCode() + ", isAttach2Window=" + isAttachedToWindow());
      dxk();
      this.xgN.timestamp = 0L;
      this.xgN.xgW = false;
    }
    AppMethodBeat.o(97267);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(97260);
    this.ktZ.onTouchEvent(paramMotionEvent);
    float f1;
    float f2;
    if (this.mIG)
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
      this.xgD = f1;
      this.xgF = f2;
      this.xfJ.requestRender();
      AppMethodBeat.o(97260);
      return true;
      if (this.xgT != null)
      {
        this.xgT.dwC();
        continue;
        float f3 = this.xgD;
        float f4 = this.xgF;
        paramMotionEvent = this.xgG;
        float f5 = paramMotionEvent.xhj;
        paramMotionEvent.xhj = (bt(f2 - f4) + f5);
        paramMotionEvent = this.xgG;
        f4 = paramMotionEvent.xhi;
        paramMotionEvent.xhi = (bt(f1 - f3) + f4);
        if (this.xgG.xhi < -50.0F)
        {
          this.xgG.xhi = -50.0F;
        }
        else if (this.xgG.xhi > 50.0F)
        {
          this.xgG.xhi = 50.0F;
          continue;
          if (this.xgT != null) {
            this.xgT.dwD();
          }
        }
      }
    }
  }
  
  public void setEventListener(b paramb)
  {
    this.xgT = paramb;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.xgP = paramOnClickListener;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.xgQ = paramOnLongClickListener;
  }
  
  public void setSensorEnabled(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(97268);
    if ((paramBoolean) && (this.xgM))
    {
      ad.e("SphereImageView.SphereView", "setSensorEnabled when isDetachedFromWindow");
      AppMethodBeat.o(97268);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("enableSensor, enabled=").append(paramBoolean).append(", hash=").append(hashCode()).append(", hasSensor=");
    if (this.xgH != null) {
      bool = true;
    }
    ad.i("SphereImageView.SphereView", bool);
    try
    {
      if (this.xgH == null) {
        break label185;
      }
      if (paramBoolean)
      {
        this.xgN.timestamp = 0L;
        this.mSensorManager.registerListener(this.xgN, this.xgH, 0);
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
    this.mSensorManager.unregisterListener(this.xgN);
    this.xgN.timestamp = 0L;
    label185:
    AppMethodBeat.o(97268);
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(97269);
    ad.i("SphereImageView.SphereView", "setTouchEnabled：" + paramBoolean + ", hash=" + hashCode());
    this.mIG = paramBoolean;
    AppMethodBeat.o(97269);
  }
  
  public void setTouchSensitivity(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.xgJ = paramFloat;
    }
  }
  
  public static final class a
    implements SensorEventListener
  {
    public long timestamp;
    public boolean xgW;
    WeakReference<SphereImageView> xgX;
    
    public a(SphereImageView paramSphereImageView)
    {
      AppMethodBeat.i(97256);
      this.timestamp = 0L;
      this.xgW = true;
      this.xgX = new WeakReference(paramSphereImageView);
      AppMethodBeat.o(97256);
    }
    
    public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public final void onSensorChanged(SensorEvent paramSensorEvent)
    {
      AppMethodBeat.i(97257);
      SphereImageView localSphereImageView = (SphereImageView)this.xgX.get();
      if (localSphereImageView == null)
      {
        AppMethodBeat.o(97257);
        return;
      }
      if ((Build.VERSION.SDK_INT < 24) && (!this.xgW))
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
          paramSensorEvent.xgY = f2;
          paramSensorEvent.xgZ = f1;
          paramSensorEvent.xha = f3;
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
    public abstract void apy(String paramString);
    
    public abstract void dwB();
    
    public abstract void dwC();
    
    public abstract void dwD();
    
    public abstract void onDetachedFromWindow();
  }
  
  protected static final class c
  {
    float xgY;
    float xgZ;
    float xha;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView
 * JD-Core Version:    0.7.0.1
 */