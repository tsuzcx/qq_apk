package com.tencent.mm.pluginsdk.i;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.hardware.SensorManager;
import android.media.MediaRecorder;
import android.os.Looper;
import android.view.SurfaceHolder;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  public Context context;
  public int eFO;
  public int fileSize;
  public String filename;
  private boolean mgx = false;
  public MediaRecorder mjf;
  public a oiw;
  public f rYj;
  public int rYk = 0;
  private final int rYl = 5;
  private b.a rYm = new b.a(Looper.getMainLooper());
  
  public final int a(Activity paramActivity, boolean paramBoolean)
  {
    this.context = paramActivity;
    f localf = this.rYj;
    a locala = this.oiw;
    int i;
    if (locala == null) {
      i = 0 - g.getLine();
    }
    while (i != 0)
    {
      return i;
      localf.rYt = locala;
      if ((localf.aVT == null) && (localf.mgB == null))
      {
        localf.aVT = ((SensorManager)paramActivity.getSystemService("sensor"));
        localf.mgB = localf.aVT.getDefaultSensor(1);
      }
      if ((paramBoolean) || (localf.dwJ == null))
      {
        localf.biI();
        if (paramBoolean) {
          f.mgz = (f.mgz ^ 0xFFFFFFFF) & 0x1;
        }
        localf.jXx = d.u(paramActivity, f.mgz);
        if (localf.jXx == null)
        {
          y.e("MicroMsg.YuvReocrder", "start camera FAILED!");
          i = 0 - g.getLine();
          continue;
        }
        localf.dwJ = localf.jXx.dwJ;
        localf.rYt.rotate = localf.jXx.rotate;
        if (localf.dwJ == null)
        {
          y.e("MicroMsg.YuvReocrder", "start camera FAILED!");
          i = 0 - g.getLine();
          continue;
        }
      }
      i = 0;
    }
    return 0;
  }
  
  public final int b(SurfaceHolder paramSurfaceHolder)
  {
    return this.rYj.b(paramSurfaceHolder);
  }
  
  public final int clT()
  {
    this.rYj.biI();
    return 0;
  }
  
  public final int getPreviewHeight()
  {
    if (this.rYj.dwJ == null) {
      return 0;
    }
    return this.rYj.dwJ.getParameters().getPreviewSize().height;
  }
  
  public final int getPreviewWidth()
  {
    if (this.rYj.dwJ == null) {
      return 0;
    }
    return this.rYj.dwJ.getParameters().getPreviewSize().width;
  }
  
  @TargetApi(9)
  public final void setOrientationHint(int paramInt)
  {
    com.tencent.mm.compatible.a.a.a(9, new b.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.b
 * JD-Core Version:    0.7.0.1
 */