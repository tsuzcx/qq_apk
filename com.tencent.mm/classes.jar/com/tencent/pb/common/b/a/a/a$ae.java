package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$ae
  extends e
{
  public a.az RDq = null;
  public int REZ = 0;
  public String groupId = "";
  
  public a$ae()
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
    if (this.RDq != null) {
      j = i + b.b(2, this.RDq);
    }
    i = j;
    if (this.REZ != 0) {
      i = j + b.bu(3, this.REZ);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.e(1, this.groupId);
    }
    if (this.RDq != null) {
      paramb.a(2, this.RDq);
    }
    if (this.REZ != 0) {
      paramb.bs(3, this.REZ);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ae
 * JD-Core Version:    0.7.0.1
 */