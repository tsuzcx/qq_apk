package com.tencent.mm.plugin.normsg;

import android.util.Base64;
import com.tencent.d.a.b;
import java.util.concurrent.CountDownLatch;

final class Normsg$C2JBridge$1
  implements b
{
  Normsg$C2JBridge$1(String[] paramArrayOfString, CountDownLatch paramCountDownLatch) {}
  
  public final boolean m(int paramInt, byte[] paramArrayOfByte)
  {
    boolean bool = false;
    if (paramInt == 0)
    {
      paramArrayOfByte = Base64.encodeToString(paramArrayOfByte, 2);
      this.mGz[0] = paramArrayOfByte;
      bool = true;
    }
    this.eez.countDown();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.normsg.Normsg.C2JBridge.1
 * JD-Core Version:    0.7.0.1
 */