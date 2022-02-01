package com.tencent.mm.plugin.multitalk.b;

import android.graphics.Canvas;
import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.base.MMTextureView;
import java.util.Timer;

public final class v
  extends MMTextureView
  implements TextureView.SurfaceTextureListener, c
{
  protected aq jzz;
  private boolean kpN;
  private Timer mTimer;
  private int mViewId;
  private String pdo;
  private int pdp;
  
  public static int[] X(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(190730);
    if (paramInt == 0)
    {
      AppMethodBeat.o(190730);
      return null;
    }
    int i = paramInt / 4;
    int[] arrayOfInt = new int[i];
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfInt[paramInt] = (c(paramArrayOfByte[(paramInt * 4)]) | c(paramArrayOfByte[(paramInt * 4 + 1)]) << 8 | c(paramArrayOfByte[(paramInt * 4 + 2)]) << 16 | c(paramArrayOfByte[(paramInt * 4 + 3)]) << 24);
      paramInt += 1;
    }
    AppMethodBeat.o(190730);
    return arrayOfInt;
  }
  
  private static int c(byte paramByte)
  {
    return (paramByte >> 4 & 0xF) * 16 + (paramByte & 0xF);
  }
  
  public final void Bk(int paramInt)
  {
    AppMethodBeat.i(190726);
    if (paramInt == this.pdp)
    {
      AppMethodBeat.o(190726);
      return;
    }
    ae.i("MicroMsg.Multitalk.ILinkVideoView", "updateMemberId, viewId:" + this.mViewId + ", openId:" + this.pdo + ", memberId:[" + this.pdp + "->" + paramInt + "]");
    this.pdp = paramInt;
    AppMethodBeat.o(190726);
  }
  
  public final int getMemberId()
  {
    return this.pdp;
  }
  
  public final String getOpenId()
  {
    return this.pdo;
  }
  
  public final int getViewId()
  {
    return this.mViewId;
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190727);
    StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureAvailable, surface:");
    if (paramSurfaceTexture == null) {
      paramSurfaceTexture = "isNull";
    }
    for (;;)
    {
      ae.i("MicroMsg.Multitalk.ILinkVideoView", paramSurfaceTexture + ", viewId:" + this.mViewId + ", openId:" + this.pdo + ", mId:" + this.pdp + ", width:" + paramInt1 + ", height:" + paramInt2);
      fDh();
      try
      {
        paramSurfaceTexture = lockCanvas();
        paramSurfaceTexture.drawColor(-16777216);
        unlockCanvasAndPost(paramSurfaceTexture);
        try
        {
          this.kpN = true;
          return;
        }
        finally
        {
          AppMethodBeat.o(190727);
        }
        paramSurfaceTexture = "nonNull";
      }
      catch (Exception paramSurfaceTexture)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.Multitalk.ILinkVideoView", paramSurfaceTexture, "drawColor for background, unlockCanvasAndPost crash", new Object[0]);
        }
      }
    }
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(190729);
    ae.i("MicroMsg.Multitalk.ILinkVideoView", "onSurfaceTextureDestroyed, viewId:" + this.mViewId + ", openId:" + this.pdo + ", mId:" + this.pdp);
    try
    {
      this.kpN = false;
      if (this.mTimer != null)
      {
        this.mTimer.cancel();
        this.mTimer = null;
      }
      if (this.jzz != null) {
        this.jzz.removeCallbacksAndMessages(null);
      }
      AppMethodBeat.o(190729);
      return false;
    }
    finally
    {
      AppMethodBeat.o(190729);
    }
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190728);
    ae.i("MicroMsg.Multitalk.ILinkVideoView", "onSurfaceTextureSizeChanged, viewId:" + this.mViewId + ", openId:" + this.pdo + ", mId:" + this.pdp + ", width:" + paramInt1 + ", height:" + paramInt2);
    AppMethodBeat.o(190728);
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.v
 * JD-Core Version:    0.7.0.1
 */