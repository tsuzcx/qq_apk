package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$n
  extends e
{
  private static volatile n[] Mdx;
  public int FHN = 0;
  public String Mdy = "";
  public String nickname = "";
  
  public a$n()
  {
    this.bQO = -1;
  }
  
  public static n[] fXw()
  {
    if (Mdx == null) {}
    synchronized (c.bQN)
    {
      if (Mdx == null) {
        Mdx = new n[0];
      }
      return Mdx;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.FHN != 0) {
      paramb.by(1, this.FHN);
    }
    if (!this.nickname.equals("")) {
      paramb.d(2, this.nickname);
    }
    if (!this.Mdy.equals("")) {
      paramb.d(3, this.Mdy);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.FHN != 0) {
      i = j + b.bA(1, this.FHN);
    }
    j = i;
    if (!this.nickname.equals("")) {
      j = i + b.e(2, this.nickname);
    }
    i = j;
    if (!this.Mdy.equals("")) {
      i = j + b.e(3, this.Mdy);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.n
 * JD-Core Version:    0.7.0.1
 */