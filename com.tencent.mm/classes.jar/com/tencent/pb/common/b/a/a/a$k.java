package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$k
  extends e
{
  public int Cuf = 0;
  public long Cug = 0L;
  public a.bd Mdd = null;
  public int Mdf = 0;
  public byte[] Mdp = g.bQV;
  public String groupId = "";
  
  public a$k()
  {
    this.bQO = -1;
  }
  
  public final void a(b paramb)
  {
    if (!this.groupId.equals("")) {
      paramb.d(1, this.groupId);
    }
    if (this.Cuf != 0) {
      paramb.bx(2, this.Cuf);
    }
    if (this.Cug != 0L) {
      paramb.n(3, this.Cug);
    }
    if (this.Mdd != null) {
      paramb.a(4, this.Mdd);
    }
    if (this.Mdf != 0) {
      paramb.by(5, this.Mdf);
    }
    if (!Arrays.equals(this.Mdp, g.bQV)) {
      paramb.b(200, this.Mdp);
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
    if (this.Cuf != 0) {
      j = i + b.bz(2, this.Cuf);
    }
    i = j;
    if (this.Cug != 0L) {
      i = j + b.p(3, this.Cug);
    }
    j = i;
    if (this.Mdd != null) {
      j = i + b.b(4, this.Mdd);
    }
    i = j;
    if (this.Mdf != 0) {
      i = j + b.bA(5, this.Mdf);
    }
    j = i;
    if (!Arrays.equals(this.Mdp, g.bQV)) {
      j = i + b.c(200, this.Mdp);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.k
 * JD-Core Version:    0.7.0.1
 */