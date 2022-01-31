package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.a;

final class k$1
  implements a
{
  private int position = 0;
  
  k$1(k paramk) {}
  
  public final byte readByte()
  {
    byte[] arrayOfByte = this.wSM.data;
    int i = this.position;
    this.position = (i + 1);
    return arrayOfByte[i];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tinker.a.a.k.1
 * JD-Core Version:    0.7.0.1
 */