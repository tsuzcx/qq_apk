package com.tencent.ttpic.cache;

import com.tencent.common.VideoPngDecoder;

class VideoPreLoader$1
  implements Runnable
{
  VideoPreLoader$1(VideoPreLoader paramVideoPreLoader) {}
  
  public void run()
  {
    if (VideoPreLoader.access$000(this.this$0) != null)
    {
      VideoPreLoader.access$000(this.this$0).release();
      VideoPreLoader.access$002(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.cache.VideoPreLoader.1
 * JD-Core Version:    0.7.0.1
 */