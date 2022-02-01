package com.tencent.thumbplayer.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingRequest;
import com.tencent.thumbplayer.api.resourceloader.TPAssetResourceLoadingContentInformationRequest;

public final class d
  implements ITPAssetResourceLoadingRequest
{
  private int RZY;
  TPAssetResourceLoadingContentInformationRequest Saa;
  c San;
  private boolean Sao;
  private boolean rEt;
  
  public d(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(189266);
    this.RZY = 0;
    this.Sao = false;
    this.rEt = false;
    this.RZY = paramInt;
    this.San = new c(paramLong1, paramLong2, paramBoolean);
    this.San.RZY = paramInt;
    AppMethodBeat.o(189266);
  }
  
  public final void finishLoading()
  {
    try
    {
      this.rEt = true;
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
    return this.Saa;
  }
  
  public final void hnD()
  {
    try
    {
      this.Sao = true;
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
      boolean bool = this.Sao;
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
      boolean bool = this.rEt;
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