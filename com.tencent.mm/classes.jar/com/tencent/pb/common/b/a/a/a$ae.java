package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;

public final class a$ae
  extends e
{
  public a.ay ahdv = null;
  public int ahfe = 0;
  public String groupId = "";
  
  public a$ae()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.g(1, this.groupId);
    }
    if (this.ahdv != null) {
      paramb.a(2, this.ahdv);
    }
    if (this.ahfe != 0) {
      paramb.cF(3, this.ahfe);
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
    if (this.ahdv != null) {
      j = i + b.b(2, this.ahdv);
    }
    i = j;
    if (this.ahfe != 0) {
      i = j + b.cJ(3, this.ahfe);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ae
 * JD-Core Version:    0.7.0.1
 */