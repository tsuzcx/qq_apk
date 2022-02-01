package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$l
  extends e
{
  public int NOc = 0;
  public long NOd = 0L;
  public a.bf ZeU = null;
  public int ZeW = 0;
  public byte[] Zfl = g.ccX;
  public String groupId = "";
  
  public a$l()
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
    if (this.NOc != 0) {
      j = i + b.bM(2, this.NOc);
    }
    i = j;
    if (this.NOd != 0L) {
      i = j + b.p(3, this.NOd);
    }
    j = i;
    if (this.ZeU != null) {
      j = i + b.b(4, this.ZeU);
    }
    i = j;
    if (this.ZeW != 0) {
      i = j + b.bN(5, this.ZeW);
    }
    j = i;
    if (!Arrays.equals(this.Zfl, g.ccX)) {
      j = i + b.c(200, this.Zfl);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.f(1, this.groupId);
    }
    if (this.NOc != 0) {
      paramb.bJ(2, this.NOc);
    }
    if (this.NOd != 0L) {
      paramb.r(3, this.NOd);
    }
    if (this.ZeU != null) {
      paramb.a(4, this.ZeU);
    }
    if (this.ZeW != 0) {
      paramb.bK(5, this.ZeW);
    }
    if (!Arrays.equals(this.Zfl, g.ccX)) {
      paramb.b(200, this.Zfl);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.l
 * JD-Core Version:    0.7.0.1
 */