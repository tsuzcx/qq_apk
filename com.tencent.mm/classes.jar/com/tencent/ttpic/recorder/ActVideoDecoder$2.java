package com.tencent.ttpic.recorder;

import com.tencent.ttpic.VideoModuleConfig;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.util.g;

class ActVideoDecoder$2
  implements Runnable
{
  ActVideoDecoder$2(ActVideoDecoder paramActVideoDecoder) {}
  
  public void run()
  {
    try
    {
      BenchUtil.benchStart(ActVideoDecoder.access$600() + "[decodeNext]");
      ActVideoDecoder.access$700(this.this$0);
      BenchUtil.benchEnd(ActVideoDecoder.access$600() + "[decodeNext]");
      ActVideoDecoder.access$802(this.this$0, false);
      return;
    }
    catch (Exception localException)
    {
      do
      {
        g.a(ActVideoDecoder.access$600(), "decodeNext error: ", localException);
      } while (!VideoModuleConfig.DEBUG);
      throw localException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.recorder.ActVideoDecoder.2
 * JD-Core Version:    0.7.0.1
 */