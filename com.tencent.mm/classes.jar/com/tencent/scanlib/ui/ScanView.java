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
  protected static int ZrE = 80;
  protected static int ZrG = 1000;
  private int PJe;
  public f ZrD;
  private long ZrF;
  private b ZrH = new b(Looper.myLooper());
  private a ZrI = new a(Looper.myLooper());
  protected TextureView aND;
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
  
  public void PW(long paramLong)
  {
    long l1 = System.currentTimeMillis() - this.lastShotTime;
    if (l1 > ZrE)
    {
      this.ZrH.removeMessages(0);
      this.ZrH.sendEmptyMessageDelayed(0, paramLong);
      return;
    }
    long l2 = ZrE;
    this.ZrH.removeMessages(0);
    this.ZrH.sendEmptyMessageDelayed(0, l2 - l1 + paramLong);
  }
  
  public void TL()
  {
    Log.i("ScanView", "try stop preview");
    if (this.ZrD.isOpen())
    {
      c localc = c.ioy();
      b.j localj = new b.j(this.ZrD);
      localc.ZqV.submit(new c.3(localc, localj));
    }
  }
  
  public final void WO(long paramLong)
  {
    long l1 = System.currentTimeMillis() - this.ZrF;
    if (l1 > ZrG)
    {
      this.ZrI.removeMessages(0);
      this.ZrI.sendEmptyMessageDelayed(0, paramLong);
      return;
    }
    long l2 = ZrG;
    this.ZrI.removeMessages(0);
    this.ZrI.sendEmptyMessageDelayed(0, l2 - l1 + paramLong);
  }
  
  public void a(b.b.a parama)
  {
    Log.i("ScanView", "try open camera");
    if (!this.ZrD.isOpen())
    {
      Log.i("ScanView", "camera is not open");
      int i = ((Activity)getContext()).getWindowManager().getDefaultDisplay().getRotation();
      c localc = c.ioy();
      b.g localg = new b.g(this.ZrD, i);
      localc.ZqV.submit(new c.1(localc, localg, parama));
    }
    do
    {
      return;
      Log.i("ScanView", "camera is already open!");
    } while (parama == null);
    parama.fEl();
  }
  
  public final void a(b.c.a parama)
  {
    int i = ((Activity)getContext()).getWindowManager().getDefaultDisplay().getRotation();
    Log.i("ScanView", "try reopen camera ".concat(String.valueOf(i)));
    c localc = c.ioy();
    b.h localh = new b.h(this.ZrD, i);
    localc.ZqV.submit(new c.5(localc, localh, parama));
  }
  
  public final void a(final b.d.a parama)
  {
    Log.i("ScanView", "try start preview");
    if ((this.ZrD.isOpen()) && (!this.ZrD.egx()) && (this.surfaceTexture != null))
    {
      c localc = c.ioy();
      b.i locali = new b.i(this.ZrD, this.surfaceTexture);
      parama = new b.d.a()
      {
        public final void fEk()
        {
          AppMethodBeat.i(3604);
          if ((ScanView.this.ZrD.isOpen()) && (ScanView.this.ZrD.egx()) && (ScanView.this.surfaceTexture != null))
          {
            ScanView.this.aND.setTransform(ScanView.a(ScanView.this, ScanView.this.ZrD.ios(), new Point(ScanView.this.aND.getWidth(), ScanView.this.aND.getHeight())));
            if (parama != null) {
              parama.fEk();
            }
          }
          AppMethodBeat.o(3604);
        }
      };
      localc.ZqV.submit(new c.2(localc, locali, parama));
    }
  }
  
  public final void aYA()
  {
    Log.i("ScanView", "try close camera");
    if (this.ZrD.isOpen())
    {
      c localc = c.ioy();
      b.f localf = new b.f(this.ZrD);
      localc.ZqV.submit(new c.4(localc, localf));
    }
  }
  
  protected void fDY()
  {
    this.ZrD = new a();
  }
  
  protected void init()
  {
    this.aND = new TextureView(getContext());
    this.aND.setSurfaceTextureListener(this);
    addView(this.aND, new FrameLayout.LayoutParams(-1, -1));
    fDY();
    this.PJe = getResources().getConfiguration().orientation;
    a(null);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    Log.i("ScanView", "onAutoFocus %s", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    Log.i("ScanView", "onConfigurationChanged %d,%d", new Object[] { Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(this.PJe) });
    if ((paramConfiguration.orientation != this.PJe) && (this.ZrD != null))
    {
      this.PJe = paramConfiguration.orientation;
      a(new b.c.a()
      {
        public final void fEl()
        {
          AppMethodBeat.i(174609);
          ScanView.this.ZrD.o(new Point(ScanView.this.aND.getWidth(), ScanView.this.aND.getHeight()));
          ScanView.this.a(new b.d.a()
          {
            public final void fEk()
            {
              AppMethodBeat.i(174608);
              ScanView.this.PW(0L);
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
    this.aND.setSurfaceTextureListener(null);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    TL();
    aYA();
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
    if (this.ZrD.isOpen())
    {
      this.ZrD.o(new Point(paramInt1, paramInt2));
      a(new b.d.a()
      {
        public final void fEk()
        {
          AppMethodBeat.i(174606);
          ScanView.this.PW(0L);
          AppMethodBeat.o(174606);
        }
      });
      return;
    }
    a(new b.b.a()
    {
      public final void fEl()
      {
        AppMethodBeat.i(3606);
        ScanView.this.ZrD.o(new Point(paramInt1, paramInt2));
        ScanView.this.a(new b.d.a()
        {
          public final void fEk()
          {
            AppMethodBeat.i(174607);
            ScanView.this.PW(0L);
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
      if (ScanView.this.ZrD.egx())
      {
        if (!"auto".equals(ScanView.this.ZrD.iow())) {
          ScanView.this.ZrD.bCY("auto");
        }
        ScanView.this.ZrD.a(ScanView.this);
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
      if (ScanView.this.ZrD.egx()) {
        ScanView.this.ZrD.c(ScanView.this);
      }
      AppMethodBeat.o(3608);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.scanlib.ui.ScanView
 * JD-Core Version:    0.7.0.1
 */