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
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;
import java.util.List;

public class SphereImageView
  extends GLTextureView
{
  private float AbF;
  private float AbG;
  private float AbH;
  private float AbI;
  private b AbJ;
  private Sensor AbK;
  private float[] AbL;
  private float AbM;
  private long AbN;
  private float AbO;
  private boolean AbP;
  private a AbQ;
  private int AbR;
  private int AbS;
  private boolean AbT;
  private boolean AbU;
  private boolean AbV;
  protected GestureDetector.OnGestureListener AbW;
  protected View.OnClickListener AbX;
  protected View.OnLongClickListener AbY;
  protected Bitmap AbZ;
  protected boolean Aca;
  protected b Acb;
  protected String kxB;
  private GestureDetector lwM;
  protected TextureView.SurfaceTextureListener lxt;
  private Context mContext;
  Handler mHandler;
  private SensorManager mSensorManager;
  private int mTouchSlop;
  private boolean nQJ;
  
  public SphereImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(97258);
    this.AbL = new float[3];
    this.AbM = 0.4F;
    this.AbN = 0L;
    this.nQJ = true;
    this.AbP = false;
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
        float f1 = paramAnonymousMessage.Ach;
        float f2 = paramAnonymousMessage.Acg;
        float f3 = f1 - SphereImageView.b(SphereImageView.this);
        float f4 = f2 - SphereImageView.c(SphereImageView.this);
        paramAnonymousMessage = SphereImageView.d(SphereImageView.this);
        paramAnonymousMessage.Acr += f4 * 1.5F;
        paramAnonymousMessage = SphereImageView.d(SphereImageView.this);
        paramAnonymousMessage.Acq += f3 * 1.5F / 2.0F;
        if (SphereImageView.d(SphereImageView.this).Acq < -50.0F) {
          SphereImageView.d(SphereImageView.this).Acq = -50.0F;
        }
        for (;;)
        {
          SphereImageView.a(SphereImageView.this, f1);
          SphereImageView.b(SphereImageView.this, f2);
          if ((Math.abs(f4) <= 0.01F) && (Math.abs(f3) <= 0.01F)) {
            break;
          }
          long l = System.currentTimeMillis();
          SphereImageView.this.AaM.requestRender();
          if (((Math.abs(f4) <= 0.1F) && (Math.abs(f3) <= 0.1F)) || (l - SphereImageView.e(SphereImageView.this) <= 500L) || (SphereImageView.this.Acb == null)) {
            break;
          }
          SphereImageView.this.Acb.eaU();
          SphereImageView.a(SphereImageView.this, l);
          break;
          if (SphereImageView.d(SphereImageView.this).Acq > 50.0F) {
            SphereImageView.d(SphereImageView.this).Acq = 50.0F;
          }
        }
      }
    };
    this.AbT = true;
    this.AbU = false;
    this.AbV = false;
    this.AbW = new SphereImageView.2(this);
    this.AbZ = null;
    this.Aca = false;
    this.kxB = "";
    this.lxt = new TextureView.SurfaceTextureListener()
    {
      public final void onSurfaceTextureAvailable(SurfaceTexture paramAnonymousSurfaceTexture, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(97255);
        ae.i("SphereImageView.SphereView", "onSurfaceTextureAvailable, hasPendingImage=" + SphereImageView.this.Aca);
        if (SphereImageView.this.Aca)
        {
          SphereImageView.this.queueEvent(SphereImageView.this.h(SphereImageView.this.AbZ, SphereImageView.this.kxB));
          SphereImageView.this.AbZ = null;
          SphereImageView.this.Aca = false;
          SphereImageView.this.kxB = "";
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
    paramAttributeSet = this.lxt;
    this.AaV.add(paramAttributeSet);
    this.AbJ = new b(this.mContext);
    setRenderer(this.AbJ);
    setRenderMode(0);
    this.mSensorManager = ((SensorManager)this.mContext.getSystemService("sensor"));
    this.AbK = this.mSensorManager.getDefaultSensor(4);
    if (this.AbK == null) {
      ae.e("SphereImageView.SphereView", "device has no Gyroscope sensor, model=" + Build.MODEL + ", brand=" + Build.BRAND);
    }
    for (;;)
    {
      this.AbQ = new a(this);
      this.mTouchSlop = (ViewConfiguration.get(paramContext).getScaledTouchSlop() / 4);
      if (this.mTouchSlop < 4) {
        this.mTouchSlop = 4;
      }
      this.lwM = new GestureDetector(paramContext, this.AbW);
      this.AbO = paramContext.getResources().getDisplayMetrics().density;
      ae.i("SphereImageView.SphereView", "init, displayDensity=" + this.AbO + ", apiLevel=" + Build.VERSION.SDK_INT + ", touchSlop=" + this.mTouchSlop);
      AppMethodBeat.o(97258);
      return;
      ae.i("SphereImageView.SphereView", "has Gyroscope sensor, model=" + Build.MODEL + ", brand=" + Build.BRAND + ", sensor=" + this.AbK);
    }
  }
  
  private float bC(float paramFloat)
  {
    AppMethodBeat.i(97261);
    if (this.AbO == 0.0F)
    {
      this.AbO = 3.0F;
      ae.e("SphereImageView.SphereView", "px2Angle , mDisplayDensity==0");
    }
    paramFloat /= this.AbO;
    float f = this.AbM;
    AppMethodBeat.o(97261);
    return paramFloat * f;
  }
  
  public final void ag(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(97259);
    this.AbJ.ag(paramFloat1, paramFloat2);
    AppMethodBeat.o(97259);
  }
  
  public final void ebD()
  {
    AppMethodBeat.i(97270);
    ae.i("SphereImageView.SphereView", "zero, hash=" + hashCode());
    this.AbJ.Acr = 90.0F;
    this.AbJ.Acq = 0.0F;
    AppMethodBeat.o(97270);
  }
  
  public final void g(Bitmap paramBitmap, String paramString)
  {
    AppMethodBeat.i(97262);
    boolean bool = isAvailable();
    ae.i("SphereImageView.SphereView", "updateImage, isAvailable=" + bool + ", hasPendingImage=" + this.Aca);
    if (bool)
    {
      this.AbZ = null;
      this.Aca = false;
      this.kxB = "";
      queueEvent(h(paramBitmap, paramString));
      AppMethodBeat.o(97262);
      return;
    }
    this.AbZ = paramBitmap;
    this.Aca = true;
    this.kxB = paramString;
    AppMethodBeat.o(97262);
  }
  
  public PointF getCurAngle()
  {
    AppMethodBeat.i(97271);
    PointF localPointF = new PointF();
    localPointF.x = this.AbJ.Acq;
    localPointF.y = this.AbJ.Acr;
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
          ae.i("SphereImageView.SphereView", i);
          localObject = SphereImageView.d(SphereImageView.this);
          Bitmap localBitmap = paramBitmap;
          try
          {
            long l = System.currentTimeMillis();
            if (((b)localObject).Acp != 0)
            {
              GLES20.glDeleteTextures(1, new int[] { ((b)localObject).Acp }, 0);
              ae.i("SphereImageView.SphereRender", "delete old texture");
            }
            i = c.ap(localBitmap);
            ae.i("SphereImageView.SphereRender", "updateImage, oldId=" + ((b)localObject).Acp + ", newId=" + i + ", timeCost=" + (System.currentTimeMillis() - l));
            ((b)localObject).Acp = i;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              ae.e("SphereImageView.SphereRender", "updateImage, exp:" + localThrowable.toString());
            }
          }
          SphereImageView.this.AaM.requestRender();
          if (SphereImageView.this.Acb != null) {
            SphereImageView.this.mHandler.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(97253);
                SphereImageView.this.Acb.aBg(SphereImageView.3.this.val$url);
                ae.i("SphereImageView.SphereView", "onUpdateImage, isAvailable=" + SphereImageView.this.isAvailable());
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
    this.AbP = false;
    ae.i("SphereImageView.SphereView", "onAttachedToWindow, hash=" + hashCode() + ", apiLevel=" + Build.VERSION.SDK_INT);
    ebD();
    AppMethodBeat.o(97264);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(97265);
    super.onDetachedFromWindow();
    this.AbP = true;
    ae.i("SphereImageView.SphereView", "onDetachedFromWindow, hash=" + hashCode());
    this.AbZ = null;
    this.Aca = false;
    this.kxB = "";
    setSensorEnabled(false);
    queueEvent(h(null, ""));
    ebD();
    if (this.Acb != null) {
      this.Acb.onDetachedFromWindow();
    }
    AppMethodBeat.o(97265);
  }
  
  public void onFinishTemporaryDetach()
  {
    AppMethodBeat.i(97266);
    if (Build.VERSION.SDK_INT < 24)
    {
      ae.i("SphereImageView.SphereView", "onFinishTemporaryDetach, hash=" + hashCode() + ", isAttach2Window=" + isAttachedToWindow());
      ebD();
      this.AbQ.timestamp = 0L;
      this.AbQ.Ace = true;
    }
    AppMethodBeat.o(97266);
  }
  
  public void onStartTemporaryDetach()
  {
    AppMethodBeat.i(97267);
    if (Build.VERSION.SDK_INT < 24)
    {
      ae.i("SphereImageView.SphereView", "onStartTemporaryDetach, hash=" + hashCode() + ", isAttach2Window=" + isAttachedToWindow());
      ebD();
      this.AbQ.timestamp = 0L;
      this.AbQ.Ace = false;
    }
    AppMethodBeat.o(97267);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(97260);
    GestureDetector localGestureDetector = this.lwM;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, locala.ahE(), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala.mt(0)), "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/SphereImageView/SphereImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    float f1;
    float f2;
    if (this.nQJ)
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
      this.AbG = f1;
      this.AbI = f2;
      this.AaM.requestRender();
      AppMethodBeat.o(97260);
      return true;
      this.AbR = ((int)f2);
      this.AbS = ((int)f1);
      if (this.AbV)
      {
        this.AbU = false;
        this.AbT = true;
      }
      if (this.Acb != null)
      {
        this.Acb.eaV();
        continue;
        float f3 = this.AbG;
        float f4 = this.AbI;
        if (this.AbV)
        {
          if ((!this.AbT) && (this.AbU))
          {
            getParent().requestDisallowInterceptTouchEvent(false);
            AppMethodBeat.o(97260);
            return false;
          }
          if ((!this.AbU) && ((int)Math.sqrt((f1 - this.AbS) * (f1 - this.AbS) + (f2 - this.AbR) * (f2 - this.AbR)) >= this.mTouchSlop))
          {
            this.AbU = true;
            if (Math.abs(f1 - this.AbS) > Math.abs(f2 - this.AbR))
            {
              this.AbT = false;
              getParent().requestDisallowInterceptTouchEvent(false);
              AppMethodBeat.o(97260);
              return false;
            }
            this.AbT = true;
          }
        }
        paramMotionEvent = this.AbJ;
        float f5 = paramMotionEvent.Acr;
        paramMotionEvent.Acr = (bC(f2 - f4) + f5);
        paramMotionEvent = this.AbJ;
        f4 = paramMotionEvent.Acq;
        paramMotionEvent.Acq = (bC(f1 - f3) + f4);
        if (this.AbJ.Acq < -50.0F)
        {
          this.AbJ.Acq = -50.0F;
        }
        else if (this.AbJ.Acq > 50.0F)
        {
          this.AbJ.Acq = 50.0F;
          continue;
          if (this.AbV)
          {
            this.AbU = false;
            this.AbT = true;
          }
          if (this.Acb != null) {
            this.Acb.eaW();
          }
        }
      }
    }
  }
  
  public void setEventListener(b paramb)
  {
    this.Acb = paramb;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.AbX = paramOnClickListener;
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.AbY = paramOnLongClickListener;
  }
  
  public void setOnlyHorizontalScroll(boolean paramBoolean)
  {
    this.AbV = paramBoolean;
  }
  
  public void setSensorEnabled(boolean paramBoolean)
  {
    boolean bool = false;
    AppMethodBeat.i(97268);
    if ((paramBoolean) && (this.AbP))
    {
      ae.e("SphereImageView.SphereView", "setSensorEnabled when isDetachedFromWindow");
      AppMethodBeat.o(97268);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("enableSensor, enabled=").append(paramBoolean).append(", hash=").append(hashCode()).append(", hasSensor=");
    if (this.AbK != null) {
      bool = true;
    }
    ae.i("SphereImageView.SphereView", bool);
    try
    {
      if (this.AbK == null) {
        break label185;
      }
      if (paramBoolean)
      {
        this.AbQ.timestamp = 0L;
        this.mSensorManager.registerListener(this.AbQ, this.AbK, 0);
        AppMethodBeat.o(97268);
        return;
      }
    }
    catch (Exception localException)
    {
      ae.e("SphereImageView.SphereView", "setSensorEnabled exp:" + localException.toString());
      AppMethodBeat.o(97268);
      return;
    }
    this.mSensorManager.unregisterListener(this.AbQ);
    this.AbQ.timestamp = 0L;
    label185:
    AppMethodBeat.o(97268);
  }
  
  public void setTouchEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(97269);
    ae.i("SphereImageView.SphereView", "setTouchEnabled：" + paramBoolean + ", hash=" + hashCode());
    this.nQJ = paramBoolean;
    AppMethodBeat.o(97269);
  }
  
  public void setTouchSensitivity(float paramFloat)
  {
    if (paramFloat > 0.0F) {
      this.AbM = paramFloat;
    }
  }
  
  public static final class a
    implements SensorEventListener
  {
    public boolean Ace;
    WeakReference<SphereImageView> Acf;
    public long timestamp;
    
    public a(SphereImageView paramSphereImageView)
    {
      AppMethodBeat.i(97256);
      this.timestamp = 0L;
      this.Ace = true;
      this.Acf = new WeakReference(paramSphereImageView);
      AppMethodBeat.o(97256);
    }
    
    public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public final void onSensorChanged(SensorEvent paramSensorEvent)
    {
      AppMethodBeat.i(97257);
      SphereImageView localSphereImageView = (SphereImageView)this.Acf.get();
      if (localSphereImageView == null)
      {
        AppMethodBeat.o(97257);
        return;
      }
      if ((Build.VERSION.SDK_INT < 24) && (!this.Ace))
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
          paramSensorEvent.Acg = f2;
          paramSensorEvent.Ach = f1;
          paramSensorEvent.Aci = f3;
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
    public abstract void aBg(String paramString);
    
    public abstract void eaU();
    
    public abstract void eaV();
    
    public abstract void eaW();
    
    public abstract void onDetachedFromWindow();
  }
  
  protected static final class c
  {
    float Acg;
    float Ach;
    float Aci;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.SphereImageView.SphereImageView
 * JD-Core Version:    0.7.0.1
 */