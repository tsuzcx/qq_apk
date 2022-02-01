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
  protected static int MmB = 80;
  protected static int MmD = 1000;
  public f MmA;
  private long MmC;
  private b MmE = new b(Looper.myLooper());
  private a MmF = new a(Looper.myLooper());
  protected TextureView bef;
  private int screenOrientation;
  protected SurfaceTexture surfaceTexture;
  private long yJX;
  
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
  
  public final void Fv(long paramLong)
  {
    long l1 = System.currentTimeMillis() - this.MmC;
    if (l1 > MmD)
    {
      this.MmF.removeMessages(0);
      this.MmF.sendEmptyMessageDelayed(0, paramLong);
      return;
    }
    long l2 = MmD;
    this.MmF.removeMessages(0);
    this.MmF.sendEmptyMessageDelayed(0, l2 - l1 + paramLong);
  }
  
  public void a(b.b.a parama)
  {
    Log.i("ScanView", "try open camera");
    if (!this.MmA.isOpen())
    {
      Log.i("ScanView", "camera is not open");
      int i = ((Activity)getContext()).getWindowManager().getDefaultDisplay().getRotation();
      c localc = c.fYO();
      b.g localg = new b.g(this.MmA, i);
      localc.MlS.submit(new c.1(localc, localg, parama));
    }
    do
    {
      return;
      Log.i("ScanView", "camera is already open!");
    } while (parama == null);
    parama.dPA();
  }
  
  public final void a(b.c.a parama)
  {
    int i = ((Activity)getContext()).getWindowManager().getDefaultDisplay().getRotation();
    Log.i("ScanView", "try reopen camera ".concat(String.valueOf(i)));
    c localc = c.fYO();
    b.h localh = new b.h(this.MmA, i);
    localc.MlS.submit(new c.5(localc, localh, parama));
  }
  
  public final void a(final b.d.a parama)
  {
    Log.i("ScanView", "try start preview");
    if ((this.MmA.isOpen()) && (!this.MmA.cOB()) && (this.surfaceTexture != null))
    {
      c localc = c.fYO();
      b.i locali = new b.i(this.MmA, this.surfaceTexture);
      parama = new b.d.a()
      {
        public final void dPz()
        {
          AppMethodBeat.i(3604);
          if ((ScanView.this.MmA.isOpen()) && (ScanView.this.MmA.cOB()) && (ScanView.this.surfaceTexture != null))
          {
            ScanView.this.bef.setTransform(ScanView.a(ScanView.this, ScanView.this.MmA.fYJ(), new Point(ScanView.this.bef.getWidth(), ScanView.this.bef.getHeight())));
            if (parama != null) {
              parama.dPz();
            }
          }
          AppMethodBeat.o(3604);
        }
      };
      localc.MlS.submit(new c.2(localc, locali, parama));
    }
  }
  
  public final void axl()
  {
    Log.i("ScanView", "try close camera");
    if (this.MmA.isOpen())
    {
      c localc = c.fYO();
      b.f localf = new b.f(this.MmA);
      localc.MlS.submit(new c.4(localc, localf));
    }
  }
  
  protected void dPo()
  {
    this.MmA = new a();
  }
  
  protected void init()
  {
    this.bef = new TextureView(getContext());
    this.bef.setSurfaceTextureListener(this);
    addView(this.bef, new FrameLayout.LayoutParams(-1, -1));
    dPo();
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
    if ((paramConfiguration.orientation != this.screenOrientation) && (this.MmA != null))
    {
      this.screenOrientation = paramConfiguration.orientation;
      a(new b.c.a()
      {
        public final void dPA()
        {
          AppMethodBeat.i(174609);
          ScanView.this.MmA.m(new Point(ScanView.this.bef.getWidth(), ScanView.this.bef.getHeight()));
          ScanView.this.a(new b.d.a()
          {
            public final void dPz()
            {
              AppMethodBeat.i(174608);
              ScanView.this.zy(0L);
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
    this.bef.setSurfaceTextureListener(null);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    stopPreview();
    axl();
  }
  
  public void onPause()
  {
    Log.i("ScanView", "onPause");
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.yJX = 0L;
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
    if (this.MmA.isOpen())
    {
      this.MmA.m(new Point(paramInt1, paramInt2));
      a(new b.d.a()
      {
        public final void dPz()
        {
          AppMethodBeat.i(174606);
          ScanView.this.zy(0L);
          AppMethodBeat.o(174606);
        }
      });
      return;
    }
    a(new b.b.a()
    {
      public final void dPA()
      {
        AppMethodBeat.i(3606);
        ScanView.this.MmA.m(new Point(paramInt1, paramInt2));
        ScanView.this.a(new b.d.a()
        {
          public final void dPz()
          {
            AppMethodBeat.i(174607);
            ScanView.this.zy(0L);
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
    if (this.MmA.isOpen())
    {
      c localc = c.fYO();
      b.j localj = new b.j(this.MmA);
      localc.MlS.submit(new c.3(localc, localj));
    }
  }
  
  public void zy(long paramLong)
  {
    long l1 = System.currentTimeMillis() - this.yJX;
    if (l1 > MmB)
    {
      this.MmE.removeMessages(0);
      this.MmE.sendEmptyMessageDelayed(0, paramLong);
      return;
    }
    long l2 = MmB;
    this.MmE.removeMessages(0);
    this.MmE.sendEmptyMessageDelayed(0, l2 - l1 + paramLong);
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
      if (ScanView.this.MmA.cOB())
      {
        if (!"auto".equals(ScanView.this.MmA.getFocusMode())) {
          ScanView.this.MmA.setFocusMode("auto");
        }
        ScanView.this.MmA.autoFocus(ScanView.this);
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
      if (ScanView.this.MmA.cOB()) {
        ScanView.this.MmA.a(ScanView.this);
      }
      AppMethodBeat.o(3608);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.scanlib.ui.ScanView
 * JD-Core Version:    0.7.0.1
 */