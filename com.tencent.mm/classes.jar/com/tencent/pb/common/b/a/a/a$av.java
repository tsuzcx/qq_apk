package com.tencent.pb.common.b.a.a;

import com.google.a.a.b;
import com.google.a.a.e;

public final class a$av
  extends e
{
  public int RFr = 0;
  public int RFs = 0;
  
  public a$av()
  {
    this.cbo = -1;
  }
  
  public final int Ig()
  {
    int j = super.Ig();
    int i = j;
    if (this.RFr != 0) {
      i = j + b.bu(1, this.RFr);
    }
    j = i;
    if (this.RFs != 0) {
      j = i + b.bu(2, this.RFs);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    if (this.RFr != 0) {
      paramb.bs(1, this.RFr);
    }
    if (this.RFs != 0) {
      paramb.bs(2, this.RFs);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.av
 * JD-Core Version:    0.7.0.1
 */