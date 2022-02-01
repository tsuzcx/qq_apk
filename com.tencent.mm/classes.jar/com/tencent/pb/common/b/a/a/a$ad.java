package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$ad
  extends e
{
  public a.aw IkD = null;
  public int Imj = 0;
  public String groupId = "";
  
  public a$ad()
  {
    this.bIS = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.IkD != null) {
      paramb.a(2, this.IkD);
    }
    if (this.Imj != 0) {
      paramb.by(3, this.Imj);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.e(1, this.groupId);
    }
    j = i;
    if (this.IkD != null) {
      j = i + b.b(2, this.IkD);
    }
    i = j;
    if (this.Imj != 0) {
      i = j + b.bA(3, this.Imj);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ad
 * JD-Core Version:    0.7.0.1
 */