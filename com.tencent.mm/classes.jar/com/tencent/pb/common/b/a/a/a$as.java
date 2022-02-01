package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$as
  extends e
{
  public int JOj = 0;
  public int JOk = 0;
  
  public a$as()
  {
    this.bGA = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.JOj != 0) {
      paramb.bv(1, this.JOj);
    }
    if (this.JOk != 0) {
      paramb.bv(2, this.JOk);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (this.JOj != 0) {
      i = j + b.bx(1, this.JOj);
    }
    j = i;
    if (this.JOk != 0) {
      j = i + b.bx(2, this.JOk);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.as
 * JD-Core Version:    0.7.0.1
 */