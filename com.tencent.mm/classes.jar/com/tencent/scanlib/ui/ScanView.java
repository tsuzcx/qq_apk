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
  protected static int ROZ = 80;
  protected static int RPb = 1000;
  public f ROY;
  private long RPa;
  private b RPc = new b(Looper.myLooper());
  private a RPd = new a(Looper.myLooper());
  protected TextureView bec;
  private long lastShotTime;
  private int screenOrientation;
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
  
  public void IC(long paramLong)
  {
    long l1 = System.currentTimeMillis() - this.lastShotTime;
    if (l1 > ROZ)
    {
      this.RPc.removeMessages(0);
      this.RPc.sendEmptyMessageDelayed(0, paramLong);
      return;
    }
    long l2 = ROZ;
    this.RPc.removeMessages(0);
    this.RPc.sendEmptyMessageDelayed(0, l2 - l1 + paramLong);
  }
  
  public final void Oy(long paramLong)
  {
    long l1 = System.currentTimeMillis() - this.RPa;
    if (l1 > RPb)
    {
      this.RPd.removeMessages(0);
      this.RPd.sendEmptyMessageDelayed(0, paramLong);
      return;
    }
    long l2 = RPb;
    this.RPd.removeMessages(0);
    this.RPd.sendEmptyMessageDelayed(0, l2 - l1 + paramLong);
  }
  
  public void a(b.b.a parama)
  {
    Log.i("ScanView", "try open camera");
    if (!this.ROY.isOpen())
    {
      Log.i("ScanView", "camera is not open");
      int i = ((Activity)getContext()).getWindowManager().getDefaultDisplay().getRotation();
      c localc = c.hkZ();
      b.g localg = new b.g(this.ROY, i);
      localc.ROp.submit(new c.1(localc, localg, parama));
    }
    do
    {
      return;
      Log.i("ScanView", "camera is already open!");
    } while (parama == null);
    parama.eRl();
  }
  
  public final void a(b.c.a parama)
  {
    int i = ((Activity)getContext()).getWindowManager().getDefaultDisplay().getRotation();
    Log.i("ScanView", "try reopen camera ".concat(String.valueOf(i)));
    c localc = c.hkZ();
    b.h localh = new b.h(this.ROY, i);
    localc.ROp.submit(new c.5(localc, localh, parama));
  }
  
  public final void a(final b.d.a parama)
  {
    Log.i("ScanView", "try start preview");
    if ((this.ROY.isOpen()) && (!this.ROY.dEO()) && (this.surfaceTexture != null))
    {
      c localc = c.hkZ();
      b.i locali = new b.i(this.ROY, this.surfaceTexture);
      parama = new b.d.a()
      {
        public final void eRk()
        {
          AppMethodBeat.i(3604);
          if ((ScanView.this.ROY.isOpen()) && (ScanView.this.ROY.dEO()) && (ScanView.this.surfaceTexture != null))
          {
            ScanView.this.bec.setTransform(ScanView.a(ScanView.this, ScanView.this.ROY.hkU(), new Point(ScanView.this.bec.getWidth(), ScanView.this.bec.getHeight())));
            if (parama != null) {
              parama.eRk();
            }
          }
          AppMethodBeat.o(3604);
        }
      };
      localc.ROp.submit(new c.2(localc, locali, parama));
    }
  }
  
  public final void aPK()
  {
    Log.i("ScanView", "try close camera");
    if (this.ROY.isOpen())
    {
      c localc = c.hkZ();
      b.f localf = new b.f(this.ROY);
      localc.ROp.submit(new c.4(localc, localf));
    }
  }
  
  protected void eQY()
  {
    this.ROY = new a();
  }
  
  protected void init()
  {
    this.bec = new TextureView(getContext());
    this.bec.setSurfaceTextureListener(this);
    addView(this.bec, new FrameLayout.LayoutParams(-1, -1));
    eQY();
    this.screenOrientation = getResources().getConfiguration().orientation;
    a(null);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    Log.i("ScanView", "onAutoFocus %s", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Log.i("ScanView", "onConfigurationChanged %d,%d", new Object[] { Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(this.screenOrientation) });
    if ((paramConfiguration.orientation != this.screenOrientation) && (this.ROY != null))
    {
      this.screenOrientation = paramConfiguration.orientation;
      a(new b.c.a()
      {
        public final void eRl()
        {
          AppMethodBeat.i(174609);
          ScanView.this.ROY.p(new Point(ScanView.this.bec.getWidth(), ScanView.this.bec.getHeight()));
          ScanView.this.a(new b.d.a()
          {
            public final void eRk()
            {
              AppMethodBeat.i(174608);
              ScanView.this.IC(0L);
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
    this.bec.setSurfaceTextureListener(null);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    stopPreview();
    aPK();
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
    if (this.ROY.isOpen())
    {
      this.ROY.p(new Point(paramInt1, paramInt2));
      a(new b.d.a()
      {
        public final void eRk()
        {
          AppMethodBeat.i(174606);
          ScanView.this.IC(0L);
          AppMethodBeat.o(174606);
        }
      });
      return;
    }
    a(new b.b.a()
    {
      public final void eRl()
      {
        AppMethodBeat.i(3606);
        ScanView.this.ROY.p(new Point(paramInt1, paramInt2));
        ScanView.this.a(new b.d.a()
        {
          public final void eRk()
          {
            AppMethodBeat.i(174607);
            ScanView.this.IC(0L);
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
  
  public void stopPreview()
  {
    Log.i("ScanView", "try stop preview");
    if (this.ROY.isOpen())
    {
      c localc = c.hkZ();
      b.j localj = new b.j(this.ROY);
      localc.ROp.submit(new c.3(localc, localj));
    }
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
      if (ScanView.this.ROY.dEO())
      {
        if (!"auto".equals(ScanView.this.ROY.getFocusMode())) {
          ScanView.this.ROY.setFocusMode("auto");
        }
        ScanView.this.ROY.autoFocus(ScanView.this);
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
      if (ScanView.this.ROY.dEO()) {
        ScanView.this.ROY.a(ScanView.this);
      }
      AppMethodBeat.o(3608);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.scanlib.ui.ScanView
 * JD-Core Version:    0.7.0.1
 */