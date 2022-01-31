package com.tencent.xweb.x5;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class h$a
{
  private static final AtomicInteger GJ;
  private HashMap<Integer, byte[]> cct;
  
  static
  {
    AppMethodBeat.i(84841);
    GJ = new AtomicInteger(1);
    AppMethodBeat.o(84841);
  }
  
  public h$a()
  {
    AppMethodBeat.i(84837);
    this.cct = new HashMap();
    AppMethodBeat.o(84837);
  }
  
  @JavascriptInterface
  public final byte[] getNativeBuffer(int paramInt)
  {
    AppMethodBeat.i(84840);
    byte[] arrayOfByte = (byte[])this.cct.remove(Integer.valueOf(paramInt));
    AppMethodBeat.o(84840);
    return arrayOfByte;
  }
  
  @JavascriptInterface
  public final int getNativeBufferId()
  {
    AppMethodBeat.i(84838);
    int k;
    int i;
    do
    {
      k = GJ.get();
      int j = k + 1;
      i = j;
      if (j > 16777215) {
        i = 1;
      }
    } while (!GJ.compareAndSet(k, i));
    AppMethodBeat.o(84838);
    return k;
  }
  
  @JavascriptInterface
  public final void setNativeBuffer(int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(84839);
    this.cct.put(Integer.valueOf(paramInt), paramArrayOfByte);
    AppMethodBeat.o(84839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.x5.h.a
 * JD-Core Version:    0.7.0.1
 */