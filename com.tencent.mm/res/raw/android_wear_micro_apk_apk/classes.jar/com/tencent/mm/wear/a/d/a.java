package com.tencent.mm.wear.a.d;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class a
{
  private List<byte[]> aji = Collections.synchronizedList(new LinkedList());
  
  public final void finish()
  {
    this.aji.clear();
  }
  
  public final byte[] nL()
  {
    if (this.aji.size() > 0) {
      return (byte[])this.aji.remove(0);
    }
    return new byte[1024];
  }
  
  public final void o(byte[] paramArrayOfByte)
  {
    if (this.aji.size() <= 2) {
      this.aji.add(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.wear.a.d.a
 * JD-Core Version:    0.7.0.1
 */