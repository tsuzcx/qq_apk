package com.tencent.mm.pluginsdk.j;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.compatible.deviceinfo.v;

public final class b
{
  public g BUa;
  public int BUb;
  private final int BUc;
  private a BUd;
  public Context context;
  public int fileSize;
  public String filename;
  private boolean gwS;
  public int hyp;
  public MediaRecorder tEx;
  public a wvh;
  
  public b()
  {
    AppMethodBeat.i(31167);
    this.BUb = 0;
    this.BUc = 5;
    this.gwS = false;
    this.BUd = new a(Looper.getMainLooper());
    AppMethodBeat.o(31167);
  }
  
  public final int b(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(31169);
    this.context = paramActivity;
    int i = this.BUa.a(paramActivity, this.wvh, paramBoolean);
    if (i != 0)
    {
      AppMethodBeat.o(31169);
      return i;
    }
    AppMethodBeat.o(31169);
    return 0;
  }
  
  public final int b(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(31171);
    int i = this.BUa.b(paramSurfaceHolder);
    AppMethodBeat.o(31171);
    return i;
  }
  
  public final int ewT()
  {
    AppMethodBeat.i(31170);
    this.BUa.cPF();
    AppMethodBeat.o(31170);
    return 0;
  }
  
  public final int getPreviewHeight()
  {
    AppMethodBeat.i(31173);
    if (this.BUa.fBM.fDV == null)
    {
      AppMethodBeat.o(31173);
      return 0;
    }
    int i = this.BUa.fBM.fDV.getParameters().getPreviewSize().height;
    AppMethodBeat.o(31173);
    return i;
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(31172);
    if (this.BUa.fBM.fDV == null)
    {
      AppMethodBeat.o(31172);
      return 0;
    }
    int i = this.BUa.fBM.fDV.getParameters().getPreviewSize().width;
    AppMethodBeat.o(31172);
    return i;
  }
  
  @TargetApi(9)
  public final void setOrientationHint(final int paramInt)
  {
    AppMethodBeat.i(31168);
    com.tencent.mm.compatible.a.a.a(9, new a.a()
    {
      public final void run()
      {
        AppMethodBeat.i(31165);
        if (b.this.tEx != null) {
          b.this.tEx.setOrientationHint(paramInt);
        }
        AppMethodBeat.o(31165);
      }
    });
    AppMethodBeat.o(31168);
  }
  
  static final class a
    extends Handler
  {
    boolean gwS = false;
    int jzV = 0;
    
    public a(Looper paramLooper)
    {
      super();
    }
    
    @TargetApi(8)
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(31166);
      Camera localCamera = (Camera)paramMessage.obj;
      Camera.Parameters localParameters = localCamera.getParameters();
      int i = localParameters.getZoom() + this.jzV;
      if (this.gwS) {
        if (i >= localParameters.getMaxZoom() / 2) {
          i = localParameters.getMaxZoom() / 2;
        }
      }
      for (;;)
      {
        localParameters.setZoom(i);
        localCamera.setParameters(localParameters);
        AppMethodBeat.o(31166);
        return;
        sendMessageDelayed(Message.obtain(this, 4353, 0, 0, paramMessage.obj), 20L);
        continue;
        if (i <= 0) {
          i = 0;
        } else {
          sendMessageDelayed(Message.obtain(this, 4353, 0, 0, paramMessage.obj), 20L);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.b
 * JD-Core Version:    0.7.0.1
 */