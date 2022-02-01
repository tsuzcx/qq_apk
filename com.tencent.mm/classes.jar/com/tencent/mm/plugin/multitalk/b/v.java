package com.tencent.mm.plugin.multitalk.b;

import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.MMTextureView;
import java.util.Timer;

public final class v
  extends MMTextureView
  implements TextureView.SurfaceTextureListener, c
{
  protected MMHandler kAn;
  private boolean ltv;
  private Timer mTimer;
  private int mViewId;
  private String qso;
  private int qsp;
  
  public static int[] Z(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(239325);
    if (paramInt == 0)
    {
      AppMethodBeat.o(239325);
      return null;
    }
    int i = paramInt / 4;
    int[] arrayOfInt = new int[i];
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfInt[paramInt] = (k(paramArrayOfByte[(paramInt * 4)]) | k(paramArrayOfByte[(paramInt * 4 + 1)]) << 8 | k(paramArrayOfByte[(paramInt * 4 + 2)]) << 16 | k(paramArrayOfByte[(paramInt * 4 + 3)]) << 24);
      paramInt += 1;
    }
    AppMethodBeat.o(239325);
    return arrayOfInt;
  }
  
  private static int k(byte paramByte)
  {
    return (paramByte >> 4 & 0xF) * 16 + (paramByte & 0xF);
  }
  
  public final void ES(int paramInt)
  {
    AppMethodBeat.i(239321);
    if (paramInt == this.qsp)
    {
      AppMethodBeat.o(239321);
      return;
    }
    Log.i("MicroMsg.Multitalk.ILinkVideoView", "updateMemberId, viewId:" + this.mViewId + ", openId:" + this.qso + ", memberId:[" + this.qsp + "->" + paramInt + "]");
    this.qsp = paramInt;
    AppMethodBeat.o(239321);
  }
  
  public final int getMemberId()
  {
    return this.qsp;
  }
  
  public final String getOpenId()
  {
    return this.qso;
  }
  
  public final int getViewId()
  {
    return this.mViewId;
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239322);
    StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureAvailable, surface:");
    if (paramSurfaceTexture == null) {
      paramSurfaceTexture = "isNull";
    }
    for (;;)
    {
      Log.i("MicroMsg.Multitalk.ILinkVideoView", paramSurfaceTexture + ", viewId:" + this.mViewId + ", openId:" + this.qso + ", mId:" + this.qsp + ", width:" + paramInt1 + ", height:" + paramInt2);
      gLi();
      try
      {
        paramSurfaceTexture = lockCanvas();
        paramSurfaceTexture.drawColor(-16777216);
        unlockCanvasAndPost(paramSurfaceTexture);
        try
        {
          this.ltv = true;
          return;
        }
        finally
        {
          AppMethodBeat.o(239322);
        }
        paramSurfaceTexture = "nonNull";
      }
      catch (Exception paramSurfaceTexture)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.Multitalk.ILinkVideoView", paramSurfaceTexture, "drawColor for background, unlockCanvasAndPost crash", new Object[0]);
        }
      }
    }
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(239324);
    Log.i("MicroMsg.Multitalk.ILinkVideoView", "onSurfaceTextureDestroyed, viewId:" + this.mViewId + ", openId:" + this.qso + ", mId:" + this.qsp);
    try
    {
      this.ltv = false;
      if (this.mTimer != null)
      {
        this.mTimer.cancel();
        this.mTimer = null;
      }
      if (this.kAn != null) {
        this.kAn.removeCallbacksAndMessages(null);
      }
      AppMethodBeat.o(239324);
      return false;
    }
    finally
    {
      AppMethodBeat.o(239324);
    }
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239323);
    Log.i("MicroMsg.Multitalk.ILinkVideoView", "onSurfaceTextureSizeChanged, viewId:" + this.mViewId + ", openId:" + this.qso + ", mId:" + this.qsp + ", width:" + paramInt1 + ", height:" + paramInt2);
    AppMethodBeat.o(239323);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.v
 * JD-Core Version:    0.7.0.1
 */