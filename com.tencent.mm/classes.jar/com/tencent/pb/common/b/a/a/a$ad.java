package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$ad
  extends e
{
  public a.aw LFX = null;
  public int LHD = 0;
  public String groupId = "";
  
  public a$ad()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.LFX != null) {
      paramb.a(2, this.LFX);
    }
    if (this.LHD != 0) {
      paramb.bx(3, this.LHD);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(1, this.groupId);
    }
    j = i;
    if (this.LFX != null) {
      j = i + b.b(2, this.LFX);
    }
    i = j;
    if (this.LHD != 0) {
      i = j + b.bz(3, this.LHD);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ad
 * JD-Core Version:    0.7.0.1
 */