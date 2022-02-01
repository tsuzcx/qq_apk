package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$ao
  extends e
{
  private static volatile ao[] LHN;
  public int oWb = 0;
  
  public a$ao()
  {
    this.bQO = -1;
  }
  
  public static ao[] fTa()
  {
    if (LHN == null) {}
    synchronized (c.bQN)
    {
      if (LHN == null) {
        LHN = new ao[0];
      }
      return LHN;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.oWb != 0) {
      paramb.by(1, this.oWb);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.oWb != 0) {
      i = j + b.bA(1, this.oWb);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ao
 * JD-Core Version:    0.7.0.1
 */