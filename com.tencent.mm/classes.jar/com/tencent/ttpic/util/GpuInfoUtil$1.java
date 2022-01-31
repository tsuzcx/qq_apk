package com.tencent.ttpic.util;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class GpuInfoUtil$1
  implements Runnable
{
  GpuInfoUtil$1(Object paramObject) {}
  
  public final void run()
  {
    AppMethodBeat.i(83928);
    if (GpuInfoUtil.access$000() == null)
    {
      ??? = GLES20.glGetString(7937);
      String str1 = GLES20.glGetString(7936);
      String str2 = GLES20.glGetString(7938);
      GpuInfoUtil.access$002((String)??? + "; " + str1 + "; " + str2);
    }
    synchronized (this.val$waitDoneLock)
    {
      this.val$waitDoneLock.notifyAll();
      AppMethodBeat.o(83928);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.util.GpuInfoUtil.1
 * JD-Core Version:    0.7.0.1
 */