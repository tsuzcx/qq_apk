package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;
import com.google.d.a.g;
import java.util.Arrays;

public final class a$l
  extends e
{
  public int UAZ = 0;
  public long UBa = 0L;
  public byte[] ahdO = g.dXB;
  public a.bf ahdx = null;
  public int ahdz = 0;
  public String groupId = "";
  
  public a$l()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.g(1, this.groupId);
    }
    if (this.UAZ != 0) {
      paramb.cF(2, this.UAZ);
    }
    if (this.UBa != 0L) {
      paramb.t(3, this.UBa);
    }
    if (this.ahdx != null) {
      paramb.a(4, this.ahdx);
    }
    if (this.ahdz != 0) {
      paramb.cG(5, this.ahdz);
    }
    if (!Arrays.equals(this.ahdO, g.dXB)) {
      paramb.b(200, this.ahdO);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.h(1, this.groupId);
    }
    j = i;
    if (this.UAZ != 0) {
      j = i + b.cJ(2, this.UAZ);
    }
    i = j;
    if (this.UBa != 0L) {
      i = j + b.q(3, this.UBa);
    }
    j = i;
    if (this.ahdx != null) {
      j = i + b.b(4, this.ahdx);
    }
    i = j;
    if (this.ahdz != 0) {
      i = j + b.cK(5, this.ahdz);
    }
    j = i;
    if (!Arrays.equals(this.ahdO, g.dXB)) {
      j = i + b.c(200, this.ahdO);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.l
 * JD-Core Version:    0.7.0.1
 */