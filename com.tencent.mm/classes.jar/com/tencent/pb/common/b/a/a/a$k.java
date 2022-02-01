package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$k
  extends e
{
  public int ADE = 0;
  public long ADF = 0L;
  public byte[] JMC = g.bGH;
  public a.bd JMq = null;
  public int JMs = 0;
  public String groupId = "";
  
  public a$k()
  {
    this.bGA = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.ADE != 0) {
      paramb.bv(2, this.ADE);
    }
    if (this.ADF != 0L) {
      paramb.n(3, this.ADF);
    }
    if (this.JMq != null) {
      paramb.a(4, this.JMq);
    }
    if (this.JMs != 0) {
      paramb.bw(5, this.JMs);
    }
    if (!Arrays.equals(this.JMC, g.bGH)) {
      paramb.b(200, this.JMC);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(1, this.groupId);
    }
    j = i;
    if (this.ADE != 0) {
      j = i + b.bx(2, this.ADE);
    }
    i = j;
    if (this.ADF != 0L) {
      i = j + b.p(3, this.ADF);
    }
    j = i;
    if (this.JMq != null) {
      j = i + b.b(4, this.JMq);
    }
    i = j;
    if (this.JMs != 0) {
      i = j + b.by(5, this.JMs);
    }
    j = i;
    if (!Arrays.equals(this.JMC, g.bGH)) {
      j = i + b.c(200, this.JMC);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.k
 * JD-Core Version:    0.7.0.1
 */