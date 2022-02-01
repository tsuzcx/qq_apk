package com.tencent.thumbplayer.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingRequest;
import com.tencent.thumbplayer.api.resourceloader.TPAssetResourceLoadingContentInformationRequest;

public final class d
  implements ITPAssetResourceLoadingRequest
{
  private int ahHL;
  TPAssetResourceLoadingContentInformationRequest ahHN;
  c ahIa;
  private boolean ahIb;
  private boolean ywb;
  
  public d(long paramLong1, long paramLong2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(227002);
    this.ahHL = 0;
    this.ahIb = false;
    this.ywb = false;
    this.ahHL = paramInt;
    this.ahIa = new c(paramLong1, paramLong2, paramBoolean);
    this.ahIa.ahHL = paramInt;
    AppMethodBeat.o(227002);
  }
  
  public final void finishLoading()
  {
    try
    {
      this.ywb = true;
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
    return this.ahHN;
  }
  
  public final boolean isCancelled()
  {
    try
    {
      boolean bool = this.ahIb;
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
      boolean bool = this.ywb;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void kaA()
  {
    try
    {
      this.ahIb = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.e.a.d
 * JD-Core Version:    0.7.0.1
 */