package com.tencent.mm.plugin.normsg;

import android.util.Base64;
import com.tencent.e.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

final class Normsg$C2JBridge$1
  implements b
{
  Normsg$C2JBridge$1(String[] paramArrayOfString, CountDownLatch paramCountDownLatch) {}
  
  public final boolean n(int paramInt, byte[] paramArrayOfByte)
  {
    boolean bool = false;
    AppMethodBeat.i(10254);
    if (paramInt == 0)
    {
      paramArrayOfByte = Base64.encodeToString(paramArrayOfByte, 2);
      this.pgF[0] = paramArrayOfByte;
      bool = true;
    }
    this.val$latch.countDown();
    AppMethodBeat.o(10254);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.Normsg.C2JBridge.1
 * JD-Core Version:    0.7.0.1
 */