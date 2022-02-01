package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$ah
  extends e
{
  public int EFp = 0;
  public int JNV = 0;
  public int JNW = 0;
  public int JNX = 0;
  public int JNY = 0;
  public int JNZ = 0;
  public int JOa = -1;
  public int JOb = 0;
  public int roomId = 0;
  public long tIG = 0L;
  
  public a$ah()
  {
    this.bGA = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.EFp != 0) {
      paramb.bw(1, this.EFp);
    }
    if (this.roomId != 0) {
      paramb.bv(2, this.roomId);
    }
    if (this.tIG != 0L) {
      paramb.n(3, this.tIG);
    }
    if (this.JNV != 0) {
      paramb.bw(4, this.JNV);
    }
    if (this.JNW != 0) {
      paramb.bw(5, this.JNW);
    }
    if (this.JNX != 0) {
      paramb.bw(6, this.JNX);
    }
    if (this.JNY != 0) {
      paramb.bw(7, this.JNY);
    }
    if (this.JNZ != 0) {
      paramb.bw(8, this.JNZ);
    }
    if (this.JOa != -1) {
      paramb.bv(9, this.JOa);
    }
    if (this.JOb != 0) {
      paramb.bv(10, this.JOb);
    }
    super.a(paramb);
  }
  
  public final int xT()
  {
    int j = super.xT();
    int i = j;
    if (this.EFp != 0) {
      i = j + b.by(1, this.EFp);
    }
    j = i;
    if (this.roomId != 0) {
      j = i + b.bx(2, this.roomId);
    }
    i = j;
    if (this.tIG != 0L) {
      i = j + b.p(3, this.tIG);
    }
    j = i;
    if (this.JNV != 0) {
      j = i + b.by(4, this.JNV);
    }
    i = j;
    if (this.JNW != 0) {
      i = j + b.by(5, this.JNW);
    }
    j = i;
    if (this.JNX != 0) {
      j = i + b.by(6, this.JNX);
    }
    i = j;
    if (this.JNY != 0) {
      i = j + b.by(7, this.JNY);
    }
    j = i;
    if (this.JNZ != 0) {
      j = i + b.by(8, this.JNZ);
    }
    i = j;
    if (this.JOa != -1) {
      i = j + b.bx(9, this.JOa);
    }
    j = i;
    if (this.JOb != 0) {
      j = i + b.bx(10, this.JOb);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ah
 * JD-Core Version:    0.7.0.1
 */