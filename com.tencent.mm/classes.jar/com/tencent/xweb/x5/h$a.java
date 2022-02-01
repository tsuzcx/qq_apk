package com.tencent.xweb.x5;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class h$a
{
  private static final AtomicInteger OD;
  private HashMap<Integer, byte[]> KED;
  
  static
  {
    AppMethodBeat.i(153865);
    OD = new AtomicInteger(1);
    AppMethodBeat.o(153865);
  }
  
  public h$a()
  {
    AppMethodBeat.i(153861);
    this.KED = new HashMap();
    AppMethodBeat.o(153861);
  }
  
  @JavascriptInterface
  public final byte[] getNativeBuffer(int paramInt)
  {
    AppMethodBeat.i(153864);
    byte[] arrayOfByte = (byte[])this.KED.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(153864);
    return arrayOfByte;
  }
  
  @JavascriptInterface
  public final int getNativeBufferId()
  {
    AppMethodBeat.i(153862);
    int k;
    int i;
    do
    {
      k = OD.get();
      int j = k + 1;
      i = j;
      if (j > 16777215) {
        i = 1;
      }
    } while (!OD.compareAndSet(k, i));
    AppMethodBeat.o(153862);
    return k;
  }
  
  @JavascriptInterface
  public final void setNativeBuffer(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(153863);
    this.KED.put(Integer.valueOf(paramInt), paramArrayOfByte);
    AppMethodBeat.o(153863);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.x5.h.a
 * JD-Core Version:    0.7.0.1
 */