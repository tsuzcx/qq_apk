package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$ae
  extends e
{
  public a.ay ZeS = null;
  public int ZgD = 0;
  public String groupId = "";
  
  public a$ae()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int j = super.JG();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.g(1, this.groupId);
    }
    j = i;
    if (this.ZeS != null) {
      j = i + b.b(2, this.ZeS);
    }
    i = j;
    if (this.ZgD != 0) {
      i = j + b.bM(3, this.ZgD);
    }
    return i;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.f(1, this.groupId);
    }
    if (this.ZeS != null) {
      paramb.a(2, this.ZeS);
    }
    if (this.ZgD != 0) {
      paramb.bJ(3, this.ZgD);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ae
 * JD-Core Version:    0.7.0.1
 */