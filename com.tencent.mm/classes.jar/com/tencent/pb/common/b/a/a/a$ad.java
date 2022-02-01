package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$ad
  extends e
{
  public a.aw JMo = null;
  public int JNU = 0;
  public String groupId = "";
  
  public a$ad()
  {
    this.bGA = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.JMo != null) {
      paramb.a(2, this.JMo);
    }
    if (this.JNU != 0) {
      paramb.bv(3, this.JNU);
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
    if (this.JMo != null) {
      j = i + b.b(2, this.JMo);
    }
    i = j;
    if (this.JNU != 0) {
      i = j + b.bx(3, this.JNU);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ad
 * JD-Core Version:    0.7.0.1
 */