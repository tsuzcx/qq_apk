package com.tencent.qqmusic.mediaplayer.perf;

public abstract interface Collectable
{
  public abstract void accept(ErrorUploadCollector paramErrorUploadCollector);
  
  public abstract void accept(PlayerInfoCollector paramPlayerInfoCollector);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.Collectable
 * JD-Core Version:    0.7.0.1
 */