package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$k
  extends e
{
  public long DPJ = 0L;
  public String Zfh = "";
  public int Zfi = 0;
  public String Zfj = "";
  public String Zfk = "";
  public int action = 0;
  public String groupId = "";
  public int roomId = 0;
  public long timestamp = 0L;
  
  public a$k()
  {
    this.ccR = -1;
  }
  
  public final int JG()
  {
    int j = super.JG() + b.bN(1, this.action) + b.bM(2, this.roomId) + b.p(3, this.DPJ);
    int i = j;
    if (!this.groupId.equals("")) {
      i = j + b.g(4, this.groupId);
    }
    j = i;
    if (this.timestamp != 0L) {
      j = i + b.q(5, this.timestamp);
    }
    i = j;
    if (!this.Zfh.equals("")) {
      i = j + b.g(6, this.Zfh);
    }
    j = i;
    if (this.Zfi != 0) {
      j = i + b.bN(7, this.Zfi);
    }
    i = j;
    if (!this.Zfj.equals("")) {
      i = j + b.g(8, this.Zfj);
    }
    j = i;
    if (!this.Zfk.equals("")) {
      j = i + b.g(9, this.Zfk);
    }
    return j;
  }
  
  public final void a(b paramb)
  {
    paramb.bK(1, this.action);
    paramb.bJ(2, this.roomId);
    paramb.r(3, this.DPJ);
    if (!this.groupId.equals("")) {
      paramb.f(4, this.groupId);
    }
    if (this.timestamp != 0L) {
      paramb.n(5, this.timestamp);
    }
    if (!this.Zfh.equals("")) {
      paramb.f(6, this.Zfh);
    }
    if (this.Zfi != 0) {
      paramb.bK(7, this.Zfi);
    }
    if (!this.Zfj.equals("")) {
      paramb.f(8, this.Zfj);
    }
    if (!this.Zfk.equals("")) {
      paramb.f(9, this.Zfk);
    }
    super.a(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.k
 * JD-Core Version:    0.7.0.1
 */