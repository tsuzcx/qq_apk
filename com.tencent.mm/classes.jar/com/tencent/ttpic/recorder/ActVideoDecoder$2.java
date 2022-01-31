package com.tencent.ttpic.recorder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GLConfig;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.util.i;

class ActVideoDecoder$2
  implements Runnable
{
  ActVideoDecoder$2(ActVideoDecoder paramActVideoDecoder) {}
  
  public void run()
  {
    AppMethodBeat.i(83678);
    try
    {
      BenchUtil.benchStart(ActVideoDecoder.access$600() + "[decodeNext]");
      ActVideoDecoder.access$700(this.this$0);
      BenchUtil.benchEnd(ActVideoDecoder.access$600() + "[decodeNext]");
      ActVideoDecoder.access$802(this.this$0, false);
      AppMethodBeat.o(83678);
      return;
    }
    catch (Exception localException)
    {
      do
      {
        i.a(ActVideoDecoder.access$600(), "decodeNext error: ", localException);
      } while (!GLConfig.DEBUG);
      AppMethodBeat.o(83678);
      throw localException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.recorder.ActVideoDecoder.2
 * JD-Core Version:    0.7.0.1
 */