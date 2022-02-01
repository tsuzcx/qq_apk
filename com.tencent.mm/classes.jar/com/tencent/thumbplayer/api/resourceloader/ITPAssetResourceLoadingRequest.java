package com.tencent.thumbplayer.api.resourceloader;

public abstract interface ITPAssetResourceLoadingRequest
{
  public abstract void finishLoading();
  
  public abstract TPAssetResourceLoadingContentInformationRequest getContentInformation();
  
  public abstract ITPAssetResourceLoadingDataRequest getLoadingDataRequest();
  
  public abstract boolean isCancelled();
  
  public abstract boolean isFinished();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoadingRequest
 * JD-Core Version:    0.7.0.1
 */