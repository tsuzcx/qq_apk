package com.tencent.mm.pluginsdk.m;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.os.Looper;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a.a;
import com.tencent.mm.compatible.deviceinfo.w;

public final class b
{
  private boolean EZj;
  public MediaRecorder FbE;
  public a JvN;
  public h Rbi;
  public int Rbj;
  private final int Rbk;
  private b.a Rbl;
  public Context context;
  public int fileSize;
  public String filename;
  public int mfT;
  
  public b()
  {
    AppMethodBeat.i(31167);
    this.Rbj = 0;
    this.Rbk = 5;
    this.EZj = false;
    this.Rbl = new b.a(Looper.getMainLooper());
    AppMethodBeat.o(31167);
  }
  
  @TargetApi(9)
  public void aqa(final int paramInt)
  {
    AppMethodBeat.i(31168);
    com.tencent.mm.compatible.a.a.a(9, new a.a()
    {
      public final void run()
      {
        AppMethodBeat.i(31165);
        if (b.this.FbE != null) {
          b.this.FbE.setOrientationHint(paramInt);
        }
        AppMethodBeat.o(31165);
      }
    });
    AppMethodBeat.o(31168);
  }
  
  public final int e(Activity paramActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(31169);
    this.context = paramActivity;
    int i = this.Rbi.a(paramActivity, this.JvN, paramBoolean);
    if (i != 0)
    {
      AppMethodBeat.o(31169);
      return i;
    }
    AppMethodBeat.o(31169);
    return 0;
  }
  
  public final int e(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(31171);
    int i = this.Rbi.e(paramSurfaceHolder);
    AppMethodBeat.o(31171);
    return i;
  }
  
  public final int getPreviewHeight()
  {
    AppMethodBeat.i(31173);
    if (this.Rbi.jqD.jta == null)
    {
      AppMethodBeat.o(31173);
      return 0;
    }
    int i = this.Rbi.jqD.jta.getParameters().getPreviewSize().height;
    AppMethodBeat.o(31173);
    return i;
  }
  
  public final int getPreviewWidth()
  {
    AppMethodBeat.i(31172);
    if (this.Rbi.jqD.jta == null)
    {
      AppMethodBeat.o(31172);
      return 0;
    }
    int i = this.Rbi.jqD.jta.getParameters().getPreviewSize().width;
    AppMethodBeat.o(31172);
    return i;
  }
  
  public final int hiS()
  {
    AppMethodBeat.i(31170);
    this.Rbi.eTe();
    AppMethodBeat.o(31170);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.m.b
 * JD-Core Version:    0.7.0.1
 */