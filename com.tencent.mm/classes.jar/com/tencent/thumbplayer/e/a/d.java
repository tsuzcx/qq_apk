package com.tencent.thumbplayer.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingRequest;
import com.tencent.thumbplayer.api.resourceloader.TPAssetResourceLoadingContentInformationRequest;

public final class d
  implements ITPAssetResourceLoadingRequest
{
  private int ZCI;
  TPAssetResourceLoadingContentInformationRequest ZCK;
  c ZCX;
  private boolean ZCY;
  private boolean vkd;
  
  public d(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(220724);
    this.ZCI = 0;
    this.ZCY = false;
    this.vkd = false;
    this.ZCI = paramInt;
    this.ZCX = new c(paramLong1, paramLong2, paramBoolean);
    this.ZCX.ZCI = paramInt;
    AppMethodBeat.o(220724);
  }
  
  public final void finishLoading()
  {
    try
    {
      this.vkd = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final TPAssetResourceLoadingContentInformationRequest getContentInformation()
  {
    return this.ZCK;
  }
  
  public final void ire()
  {
    try
    {
      this.ZCY = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean isCancelled()
  {
    try
    {
      boolean bool = this.ZCY;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean isFinished()
  {
    try
    {
      boolean bool = this.vkd;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.e.a.d
 * JD-Core Version:    0.7.0.1
 */