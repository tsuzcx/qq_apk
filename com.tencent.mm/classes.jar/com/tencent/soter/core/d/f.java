package com.tencent.soter.core.d;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

public final class f
{
  private static Handler Ivh = null;
  CountDownLatch BNN = null;
  
  public final void countDown()
  {
    AppMethodBeat.i(88726);
    if (this.BNN != null) {
      this.BNN.countDown();
    }
    AppMethodBeat.o(88726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.core.d.f
 * JD-Core Version:    0.7.0.1
 */