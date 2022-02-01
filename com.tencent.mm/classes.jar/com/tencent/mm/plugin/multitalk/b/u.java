package com.tencent.mm.plugin.multitalk.b;

import android.graphics.SurfaceTexture;
import android.view.TextureView.SurfaceTextureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMTextureView;

public final class u
  extends MMTextureView
  implements TextureView.SurfaceTextureListener
{
  public static int[] aa(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(200755);
    if (paramInt == 0)
    {
      AppMethodBeat.o(200755);
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
    AppMethodBeat.o(200755);
    return arrayOfInt;
  }
  
  private static int k(byte paramByte)
  {
    return (paramByte >> 4 & 0xF) * 16 + (paramByte & 0xF);
  }
  
  public final int getMemberId()
  {
    throw null;
  }
  
  public final String getOpenId()
  {
    throw null;
  }
  
  public final int getViewId()
  {
    throw null;
  }
  
  public final void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200752);
    StringBuilder localStringBuilder = new StringBuilder("onSurfaceTextureAvailable, surface:");
    if (paramSurfaceTexture == null) {}
    for (paramSurfaceTexture = "isNull";; paramSurfaceTexture = "nonNull")
    {
      localStringBuilder.append(paramSurfaceTexture).append(", viewId:");
      AppMethodBeat.o(200752);
      throw null;
    }
  }
  
  public final boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    throw null;
  }
  
  public final void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    throw null;
  }
  
  public final void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.u
 * JD-Core Version:    0.7.0.1
 */