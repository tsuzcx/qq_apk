package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;

public final class a$g
  extends e
{
  public int UAZ = 0;
  public long UBa = 0L;
  public String ahdt = "";
  public String groupId = "";
  public int reason = 0;
  
  public a$g()
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
    if (this.reason != 0) {
      paramb.cF(4, this.reason);
    }
    if (!this.ahdt.equals("")) {
      paramb.g(5, this.ahdt);
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
    if (this.reason != 0) {
      j = i + b.cJ(4, this.reason);
    }
    i = j;
    if (!this.ahdt.equals("")) {
      i = j + b.h(5, this.ahdt);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.g
 * JD-Core Version:    0.7.0.1
 */