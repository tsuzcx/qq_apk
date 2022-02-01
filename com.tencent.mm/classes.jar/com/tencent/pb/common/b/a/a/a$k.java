package com.tencent.pb.common.b.a.a;

import com.google.d.a.b;
import com.google.d.a.e;

public final class a$k
  extends e
{
  public long Hnt = 0L;
  public int action = 0;
  public String ahdK = "";
  public int ahdL = 0;
  public String ahdM = "";
  public String ahdN = "";
  public String groupId = "";
  public int roomId = 0;
  public long timestamp = 0L;
  
  public a$k()
  {
    this.dXv = -1;
  }
  
  public final void a(b paramb)
  {
    paramb.cG(1, this.action);
    paramb.cF(2, this.roomId);
    paramb.t(3, this.Hnt);
    if (!this.groupId.equals("")) {
      paramb.g(4, this.groupId);
    }
    if (this.timestamp != 0L) {
      paramb.n(5, this.timestamp);
    }
    if (!this.ahdK.equals("")) {
      paramb.g(6, this.ahdK);
    }
    if (this.ahdL != 0) {
      paramb.cG(7, this.ahdL);
    }
    if (!this.ahdM.equals("")) {
      paramb.g(8, this.ahdM);
    }
    if (!this.ahdN.equals("")) {
      paramb.g(9, this.ahdN);
    }
    super.a(paramb);
  }
  
  public final int akc()
  {
    int j = super.akc() + b.cK(1, this.action) + b.cJ(2, this.roomId) + b.q(3, this.Hnt);
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.h(4, this.groupId);
    }
    j = i;
    if (this.timestamp != 0L) {
      j = i + b.r(5, this.timestamp);
    }
    i = j;
    if (!this.ahdK.equals("")) {
      i = j + b.h(6, this.ahdK);
    }
    j = i;
    if (this.ahdL != 0) {
      j = i + b.cK(7, this.ahdL);
    }
    i = j;
    if (!this.ahdM.equals("")) {
      i = j + b.h(8, this.ahdM);
    }
    j = i;
    if (!this.ahdN.equals("")) {
      j = i + b.h(9, this.ahdN);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.k
 * JD-Core Version:    0.7.0.1
 */