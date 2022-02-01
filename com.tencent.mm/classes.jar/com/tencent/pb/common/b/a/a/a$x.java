package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$x
  extends e
{
  public a.w Zgm = null;
  public byte[] body = g.ccX;
  
  public a$x()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int j = super.JG();
    int i = j;
    if (this.Zgm != null) {
      i = j + b.b(1, this.Zgm);
    }
    j = i;
    if (!Arrays.equals(this.body, g.ccX)) {
      j = i + b.c(2, this.body);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    if (this.Zgm != null) {
      paramb.a(1, this.Zgm);
    }
    if (!Arrays.equals(this.body, g.ccX)) {
      paramb.b(2, this.body);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.x
 * JD-Core Version:    0.7.0.1
 */