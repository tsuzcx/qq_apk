package org.chromium.content.common;

import android.os.Bundle;
import android.os.IInterface;
import android.view.Surface;
import org.chromium.base.UnguessableToken;

public abstract interface IGpuProcessCallback
  extends IInterface
{
  public abstract void forwardSurfaceForSurfaceRequest(UnguessableToken paramUnguessableToken, Surface paramSurface);
  
  public abstract SurfaceWrapper getViewSurface(int paramInt);
  
  public abstract void invokeMiscMethod(String paramString, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     org.chromium.content.common.IGpuProcessCallback
 * JD-Core Version:    0.7.0.1
 */