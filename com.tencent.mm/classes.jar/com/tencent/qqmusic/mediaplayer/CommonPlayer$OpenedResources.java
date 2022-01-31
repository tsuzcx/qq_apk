package com.tencent.qqmusic.mediaplayer;

import com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;

class CommonPlayer$OpenedResources
{
  private File bufferFile;
  private CacheDataSource dataSource;
  
  void release()
  {
    if ((this.bufferFile != null) && (!this.bufferFile.delete())) {
      Logger.w("CommonPlayer", "[release] failed to delete buffer file: " + this.bufferFile);
    }
    if (this.dataSource != null) {
      this.dataSource.setListener(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.CommonPlayer.OpenedResources
 * JD-Core Version:    0.7.0.1
 */