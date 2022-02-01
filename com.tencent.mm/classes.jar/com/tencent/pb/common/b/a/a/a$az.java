package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;

public final class a$az
  extends e
{
  private static volatile az[] Mgh;
  public int FHN = 0;
  public long Mgi = 0L;
  public String Mgj = "";
  public String Mgk = "";
  public String headUrl = "";
  public String username = "";
  
  public a$az()
  {
    this.bQO = -1;
  }
  
  public static az[] fXG()
  {
    if (Mgh == null) {}
    synchronized (c.bQN)
    {
      if (Mgh == null) {
        Mgh = new az[0];
      }
      return Mgh;
    }
  }
  
  public final void a(b paramb)
  {
    if (this.FHN != 0) {
      paramb.by(1, this.FHN);
    }
    if (!this.username.equals("")) {
      paramb.d(2, this.username);
    }
    if (!this.headUrl.equals("")) {
      paramb.d(3, this.headUrl);
    }
    if (this.Mgi != 0L) {
      paramb.m(4, this.Mgi);
    }
    if (!this.Mgj.equals("")) {
      paramb.d(5, this.Mgj);
    }
    if (!this.Mgk.equals("")) {
      paramb.d(6, this.Mgk);
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
    if (!this.username.equals("")) {
      j = i + b.e(2, this.username);
    }
    i = j;
    if (!this.headUrl.equals("")) {
      i = j + b.e(3, this.headUrl);
    }
    j = i;
    if (this.Mgi != 0L) {
      j = i + b.o(4, this.Mgi);
    }
    i = j;
    if (!this.Mgj.equals("")) {
      i = j + b.e(5, this.Mgj);
    }
    j = i;
    if (!this.Mgk.equals("")) {
      j = i + b.e(6, this.Mgk);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.az
 * JD-Core Version:    0.7.0.1
 */