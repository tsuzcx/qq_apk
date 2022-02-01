package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$ao
  extends e
{
  private static volatile ao[] Ims;
  public int nPB = 0;
  
  public a$ao()
  {
    this.bIS = -1;
  }
  
  public static ao[] flu()
  {
    if (Ims == null) {}
    synchronized (c.bIR)
    {
      if (Ims == null) {
        Ims = new ao[0];
      }
      return Ims;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.nPB != 0) {
      paramb.bz(1, this.nPB);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (this.nPB != 0) {
      i = j + b.bB(1, this.nPB);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ao
 * JD-Core Version:    0.7.0.1
 */