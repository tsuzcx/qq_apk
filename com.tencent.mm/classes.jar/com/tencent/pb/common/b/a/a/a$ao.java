package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$ao
  extends e
{
  private static volatile ao[] JOd;
  public int osF = 0;
  
  public a$ao()
  {
    this.bGA = -1;
  }
  
  public static ao[] fBL()
  {
    if (JOd == null) {}
    synchronized (c.bGz)
    {
      if (JOd == null) {
        JOd = new ao[0];
      }
      return JOd;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.osF != 0) {
      paramb.bw(1, this.osF);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (this.osF != 0) {
      i = j + b.by(1, this.osF);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ao
 * JD-Core Version:    0.7.0.1
 */