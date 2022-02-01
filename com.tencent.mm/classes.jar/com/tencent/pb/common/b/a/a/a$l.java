package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class a$l
  extends e
{
  public int GXO = 0;
  public long GXP = 0L;
  public byte[] RDF = g.cbu;
  public a.bg RDs = null;
  public int RDu = 0;
  public String groupId = "";
  
  public a$l()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.f(1, this.groupId);
    }
    j = i;
    if (this.GXO != 0) {
      j = i + b.bu(2, this.GXO);
    }
    i = j;
    if (this.GXP != 0L) {
      i = j + b.r(3, this.GXP);
    }
    j = i;
    if (this.RDs != null) {
      j = i + b.b(4, this.RDs);
    }
    i = j;
    if (this.RDu != 0) {
      i = j + b.bC(5, this.RDu);
    }
    j = i;
    if (!Arrays.equals(this.RDF, g.cbu)) {
      j = i + b.c(200, this.RDF);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.e(1, this.groupId);
    }
    if (this.GXO != 0) {
      paramb.bs(2, this.GXO);
    }
    if (this.GXP != 0L) {
      paramb.q(3, this.GXP);
    }
    if (this.RDs != null) {
      paramb.a(4, this.RDs);
    }
    if (this.RDu != 0) {
      paramb.bB(5, this.RDu);
    }
    if (!Arrays.equals(this.RDF, g.cbu)) {
      paramb.b(200, this.RDF);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.l
 * JD-Core Version:    0.7.0.1
 */