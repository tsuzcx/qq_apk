package com.tencent.scanlib.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Display;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.scanlib.a.a;
import com.tencent.scanlib.a.b.b.a;
import com.tencent.scanlib.a.b.c.a;
import com.tencent.scanlib.a.b.d.a;
import com.tencent.scanlib.a.b.f;
import com.tencent.scanlib.a.b.g;
import com.tencent.scanlib.a.b.h;
import com.tencent.scanlib.a.b.i;
import com.tencent.scanlib.a.b.j;
import com.tencent.scanlib.a.c;
import com.tencent.scanlib.a.c.1;
import com.tencent.scanlib.a.c.2;
import com.tencent.scanlib.a.c.3;
import com.tencent.scanlib.a.c.4;
import com.tencent.scanlib.a.c.5;
import com.tencent.scanlib.a.f;
import com.tencent.stubs.logger.Log;
import java.util.concurrent.ExecutorService;

public abstract class ScanView
  extends FrameLayout
  implements Camera.AutoFocusCallback, Camera.PreviewCallback, TextureView.SurfaceTextureListener
{
  protected static int ahws = 80;
  protected static int ahwu = 1000;
  private int Wzx;
  public f ahwr;
  private long ahwt;
  private b ahwv = new b(Looper.myLooper());
  private a ahww = new a(Looper.myLooper());
  protected TextureView cHz;
  private long lastShotTime;
  protected SurfaceTexture surfaceTexture;
  
  public ScanView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ScanView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ScanView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void Bb(long paramLong)
  {
    long l1 = System.currentTimeMillis() - this.ahwt;
    if (l1 > ahwu)
    {
      this.ahww.removeMessages(0);
      this.ahww.sendEmptyMessageDelayed(0, paramLong);
      return;
    }
    long l2 = ahwu;
    this.ahww.removeMessages(0);
    this.ahww.sendEmptyMessageDelayed(0, l2 - l1 + paramLong);
  }
  
  public void a(b.b.a parama)
  {
    Log.i("ScanView", "try open camera");
    if (!this.ahwr.isOpen())
    {
      Log.i("ScanView", "camera is not open");
      int i = ((Activity)getContext()).getWindowManager().getDefaultDisplay().getRotation();
      c localc = c.jXL();
      b.g localg = new b.g(this.ahwr, i);
      localc.ahvK.submit(new c.1(localc, localg, parama));
    }
    do
    {
      return;
      Log.i("ScanView", "camera is already open!");
    } while (parama == null);
    parama.gSY();
  }
  
  public final void a(b.c.a parama)
  {
    int i = ((Activity)getContext()).getWindowManager().getDefaultDisplay().getRotation();
    Log.i("ScanView", "try reopen camera ".concat(String.valueOf(i)));
    c localc = c.jXL();
    b.h localh = new b.h(this.ahwr, i);
    localc.ahvK.submit(new c.5(localc, localh, parama));
  }
  
  public final void a(final b.d.a parama)
  {
    Log.i("ScanView", "try start preview");
    if ((this.ahwr.isOpen()) && (!this.ahwr.boa()) && (this.surfaceTexture != null))
    {
      c localc = c.jXL();
      b.i locali = new b.i(this.ahwr, this.surfaceTexture);
      parama = new b.d.a()
      {
        public final void gSX()
        {
          AppMethodBeat.i(3604);
          if ((ScanView.this.ahwr.isOpen()) && (ScanView.this.ahwr.boa()) && (ScanView.this.surfaceTexture != null))
          {
            ScanView.this.cHz.setTransform(ScanView.a(ScanView.this, ScanView.this.ahwr.jXF(), new Point(ScanView.this.cHz.getWidth(), ScanView.this.cHz.getHeight())));
            if (parama != null) {
              parama.gSX();
            }
          }
          AppMethodBeat.o(3604);
        }
      };
      localc.ahvK.submit(new c.2(localc, locali, parama));
    }
  }
  
  public void auq()
  {
    Log.i("ScanView", "try stop preview");
    if (this.ahwr.isOpen())
    {
      c localc = c.jXL();
      b.j localj = new b.j(this.ahwr);
      localc.ahvK.submit(new c.3(localc, localj));
    }
  }
  
  public final void bty()
  {
    Log.i("ScanView", "try close camera");
    if (this.ahwr.isOpen())
    {
      c localc = c.jXL();
      b.f localf = new b.f(this.ahwr);
      localc.ahvK.submit(new c.4(localc, localf));
    }
  }
  
  protected void gSM()
  {
    this.ahwr = new a();
  }
  
  protected void init()
  {
    this.cHz = new TextureView(getContext());
    this.cHz.setSurfaceTextureListener(this);
    addView(this.cHz, new FrameLayout.LayoutParams(-1, -1));
    gSM();
    this.Wzx = getResources().getConfiguration().orientation;
    a(null);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    Log.i("ScanView", "onAutoFocus %s", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Log.i("ScanView", "onConfigurationChanged %d,%d", new Object[] { Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(this.Wzx) });
    if ((paramConfiguration.orientation != this.Wzx) && (this.ahwr != null))
    {
      this.Wzx = paramConfiguration.orientation;
      a(new b.c.a()
      {
        public final void gSY()
        {
          AppMethodBeat.i(174609);
          ScanView.this.ahwr.q(new Point(ScanView.this.cHz.getWidth(), ScanView.this.cHz.getHeight()));
          ScanView.this.a(new b.d.a()
          {
            public final void gSX()
            {
              AppMethodBeat.i(174608);
              ScanView.this.ua(0L);
              AppMethodBeat.o(174608);
            }
          });
          AppMethodBeat.o(174609);
        }
      });
    }
  }
  
  public void onCreate()
  {
    Log.i("ScanView", "onCreate");
    init();
  }
  
  public void onDestroy()
  {
    Log.i("ScanView", "onDestroy");
    this.cHz.setSurfaceTextureListener(null);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    auq();
    bty();
  }
  
  public void onPause()
  {
    Log.i("ScanView", "onPause");
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.lastShotTime = 0L;
  }
  
  public void onResume()
  {
    Log.i("ScanView", "onResume");
  }
  
  public void onStop()
  {
    Log.i("ScanView", "onStop");
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, final int paramInt1, final int paramInt2)
  {
    Log.i("ScanView", "surface available, %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.surfaceTexture = paramSurfaceTexture;
    if (this.ahwr.isOpen())
    {
      this.ahwr.q(new Point(paramInt1, paramInt2));
      a(new b.d.a()
      {
        public final void gSX()
        {
          AppMethodBeat.i(174606);
          ScanView.this.ua(0L);
          AppMethodBeat.o(174606);
        }
      });
      return;
    }
    a(new b.b.a()
    {
      public final void gSY()
      {
        AppMethodBeat.i(3606);
        ScanView.this.ahwr.q(new Point(paramInt1, paramInt2));
        ScanView.this.a(new b.d.a()
        {
          public final void gSX()
          {
            AppMethodBeat.i(174607);
            ScanView.this.ua(0L);
            AppMethodBeat.o(174607);
          }
        });
        AppMethodBeat.o(3606);
      }
    });
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    Log.i("ScanView", "surface destroyed");
    return true;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    Log.i("ScanView", "surface size changed, %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
  
  public void ua(long paramLong)
  {
    long l1 = System.currentTimeMillis() - this.lastShotTime;
    if (l1 > ahws)
    {
      this.ahwv.removeMessages(0);
      this.ahwv.sendEmptyMessageDelayed(0, paramLong);
      return;
    }
    long l2 = ahws;
    this.ahwv.removeMessages(0);
    this.ahwv.sendEmptyMessageDelayed(0, l2 - l1 + paramLong);
  }
  
  final class a
    extends Handler
  {
    a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(3607);
      ScanView.b(ScanView.this, System.currentTimeMillis());
      if (ScanView.this.ahwr.boa())
      {
        if (!"auto".equals(ScanView.this.ahwr.jXJ())) {
          ScanView.this.ahwr.bFD("auto");
        }
        ScanView.this.ahwr.a(ScanView.this);
        Log.i("ScanView", "do auto focus");
      }
      AppMethodBeat.o(3607);
    }
  }
  
  final class b
    extends Handler
  {
    b(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(3608);
      ScanView.a(ScanView.this, System.currentTimeMillis());
      Log.i("ScanView", "take one shot");
      if (ScanView.this.ahwr.boa()) {
        ScanView.this.ahwr.c(ScanView.this);
      }
      AppMethodBeat.o(3608);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.scanlib.ui.ScanView
 * JD-Core Version:    0.7.0.1
 */