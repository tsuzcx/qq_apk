package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;

public final class a$ah
  extends e
{
  public int DlI = 0;
  public int Imk = 0;
  public int Iml = 0;
  public int Imm = 0;
  public int Imn = 0;
  public int Imo = 0;
  public int Imp = -1;
  public int Imq = 0;
  public int roomId = 0;
  public long sAY = 0L;
  
  public a$ah()
  {
    this.bIS = -1;
  }
  
  public final void a(b paramb)
  {
    if (this.DlI != 0) {
      paramb.bz(1, this.DlI);
    }
    if (this.roomId != 0) {
      paramb.by(2, this.roomId);
    }
    if (this.sAY != 0L) {
      paramb.o(3, this.sAY);
    }
    if (this.Imk != 0) {
      paramb.bz(4, this.Imk);
    }
    if (this.Iml != 0) {
      paramb.bz(5, this.Iml);
    }
    if (this.Imm != 0) {
      paramb.bz(6, this.Imm);
    }
    if (this.Imn != 0) {
      paramb.bz(7, this.Imn);
    }
    if (this.Imo != 0) {
      paramb.bz(8, this.Imo);
    }
    if (this.Imp != -1) {
      paramb.by(9, this.Imp);
    }
    if (this.Imq != 0) {
      paramb.by(10, this.Imq);
    }
    super.a(paramb);
  }
  
  public final int yg()
  {
    int j = super.yg();
    int i = j;
    if (this.DlI != 0) {
      i = j + b.bB(1, this.DlI);
    }
    j = i;
    if (this.roomId != 0) {
      j = i + b.bA(2, this.roomId);
    }
    i = j;
    if (this.sAY != 0L) {
      i = j + b.q(3, this.sAY);
    }
    j = i;
    if (this.Imk != 0) {
      j = i + b.bB(4, this.Imk);
    }
    i = j;
    if (this.Iml != 0) {
      i = j + b.bB(5, this.Iml);
    }
    j = i;
    if (this.Imm != 0) {
      j = i + b.bB(6, this.Imm);
    }
    i = j;
    if (this.Imn != 0) {
      i = j + b.bB(7, this.Imn);
    }
    j = i;
    if (this.Imo != 0) {
      j = i + b.bB(8, this.Imo);
    }
    i = j;
    if (this.Imp != -1) {
      i = j + b.bA(9, this.Imp);
    }
    j = i;
    if (this.Imq != 0) {
      j = i + b.bA(10, this.Imq);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ah
 * JD-Core Version:    0.7.0.1
 */