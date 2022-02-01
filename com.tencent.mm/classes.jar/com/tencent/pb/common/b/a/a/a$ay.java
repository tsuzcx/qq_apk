package com.tencent.pb.common.b.a.a;

import com.google.b.a.b;
import com.google.b.a.c;
import com.google.b.a.e;
import com.google.b.a.g;
import java.util.Arrays;

public final class a$ay
  extends e
{
  private static volatile ay[] MfL;
  public int CMC = 0;
  public int FHN = 0;
  public int Mdk = 0;
  public byte[] Mdp = g.bQV;
  public int MfM = 0;
  public int MfN = 0;
  public a.at MfO = null;
  public int MfP = 0;
  public String MfQ = "";
  public a.au[] MfR = a.au.fXD();
  public int MfS = 0;
  public int[] MfT = g.bQP;
  public int MfU = 0;
  public int MfV = 0;
  public int MfW = 0;
  public int MfX = 0;
  public a.aq MfY = null;
  public String MfZ = "";
  public int Mga = 0;
  public a.t Mgb = null;
  public int Mgc = -1;
  public String Mgd = "";
  public int Mge = 0;
  public int Mgf = 0;
  public int Mgg = 0;
  public String duC = "";
  public int pcE = -1;
  public int platform = 0;
  public int reason = 0;
  public int status = 0;
  
  public a$ay()
  {
    this.bQO = -1;
  }
  
  public static ay[] fXF()
  {
    if (MfL == null) {}
    synchronized (c.bQN)
    {
      if (MfL == null) {
        MfL = new ay[0];
      }
      return MfL;
    }
  }
  
  public final void a(b paramb)
  {
    int j = 0;
    if (this.FHN != 0) {
      paramb.by(1, this.FHN);
    }
    if (this.MfM != 0) {
      paramb.by(2, this.MfM);
    }
    if (this.status != 0) {
      paramb.by(3, this.status);
    }
    if (this.reason != 0) {
      paramb.by(4, this.reason);
    }
    if (this.pcE != -1) {
      paramb.bx(5, this.pcE);
    }
    if (this.MfN != 0) {
      paramb.by(6, this.MfN);
    }
    if (this.MfO != null) {
      paramb.a(7, this.MfO);
    }
    if (this.MfP != 0) {
      paramb.by(8, this.MfP);
    }
    if (!this.MfQ.equals("")) {
      paramb.d(9, this.MfQ);
    }
    int i;
    if ((this.MfR != null) && (this.MfR.length > 0))
    {
      i = 0;
      while (i < this.MfR.length)
      {
        a.au localau = this.MfR[i];
        if (localau != null) {
          paramb.a(10, localau);
        }
        i += 1;
      }
    }
    if (this.MfS != 0) {
      paramb.by(11, this.MfS);
    }
    if ((this.MfT != null) && (this.MfT.length > 0))
    {
      i = j;
      while (i < this.MfT.length)
      {
        paramb.by(12, this.MfT[i]);
        i += 1;
      }
    }
    if (this.MfU != 0) {
      paramb.by(13, this.MfU);
    }
    if (this.MfV != 0) {
      paramb.by(14, this.MfV);
    }
    if (this.MfW != 0) {
      paramb.by(15, this.MfW);
    }
    if (this.MfX != 0) {
      paramb.by(16, this.MfX);
    }
    if (this.MfY != null) {
      paramb.a(17, this.MfY);
    }
    if (!this.duC.equals("")) {
      paramb.d(100, this.duC);
    }
    if (!this.MfZ.equals("")) {
      paramb.d(101, this.MfZ);
    }
    if (this.Mga != 0) {
      paramb.by(102, this.Mga);
    }
    if (!Arrays.equals(this.Mdp, g.bQV)) {
      paramb.b(200, this.Mdp);
    }
    if (this.Mgb != null) {
      paramb.a(201, this.Mgb);
    }
    if (this.Mgc != -1) {
      paramb.bx(202, this.Mgc);
    }
    if (!this.Mgd.equals("")) {
      paramb.d(203, this.Mgd);
    }
    if (this.platform != 0) {
      paramb.bx(204, this.platform);
    }
    if (this.Mge != 0) {
      paramb.by(205, this.Mge);
    }
    if (this.CMC != 0) {
      paramb.by(206, this.CMC);
    }
    if (this.Mgf != 0) {
      paramb.by(207, this.Mgf);
    }
    if (this.Mgg != 0) {
      paramb.by(208, this.Mgg);
    }
    if (this.Mdk != 0) {
      paramb.by(240, this.Mdk);
    }
    super.a(paramb);
  }
  
  public final int zq()
  {
    int j = super.zq();
    int i = j;
    if (this.FHN != 0) {
      i = j + b.bA(1, this.FHN);
    }
    j = i;
    if (this.MfM != 0) {
      j = i + b.bA(2, this.MfM);
    }
    i = j;
    if (this.status != 0) {
      i = j + b.bA(3, this.status);
    }
    j = i;
    if (this.reason != 0) {
      j = i + b.bA(4, this.reason);
    }
    i = j;
    if (this.pcE != -1) {
      i = j + b.bz(5, this.pcE);
    }
    j = i;
    if (this.MfN != 0) {
      j = i + b.bA(6, this.MfN);
    }
    i = j;
    if (this.MfO != null) {
      i = j + b.b(7, this.MfO);
    }
    j = i;
    if (this.MfP != 0) {
      j = i + b.bA(8, this.MfP);
    }
    i = j;
    if (!this.MfQ.equals("")) {
      i = j + b.e(9, this.MfQ);
    }
    j = i;
    int k;
    if (this.MfR != null)
    {
      j = i;
      if (this.MfR.length > 0)
      {
        j = 0;
        while (j < this.MfR.length)
        {
          a.au localau = this.MfR[j];
          k = i;
          if (localau != null) {
            k = i + b.b(10, localau);
          }
          j += 1;
          i = k;
        }
        j = i;
      }
    }
    i = j;
    if (this.MfS != 0) {
      i = j + b.bA(11, this.MfS);
    }
    j = i;
    if (this.MfT != null)
    {
      j = i;
      if (this.MfT.length > 0)
      {
        j = 0;
        k = 0;
        while (j < this.MfT.length)
        {
          k += b.fP(this.MfT[j]);
          j += 1;
        }
        j = i + k + this.MfT.length * 1;
      }
    }
    i = j;
    if (this.MfU != 0) {
      i = j + b.bA(13, this.MfU);
    }
    j = i;
    if (this.MfV != 0) {
      j = i + b.bA(14, this.MfV);
    }
    i = j;
    if (this.MfW != 0) {
      i = j + b.bA(15, this.MfW);
    }
    j = i;
    if (this.MfX != 0) {
      j = i + b.bA(16, this.MfX);
    }
    i = j;
    if (this.MfY != null) {
      i = j + b.b(17, this.MfY);
    }
    j = i;
    if (!this.duC.equals("")) {
      j = i + b.e(100, this.duC);
    }
    i = j;
    if (!this.MfZ.equals("")) {
      i = j + b.e(101, this.MfZ);
    }
    j = i;
    if (this.Mga != 0) {
      j = i + b.bA(102, this.Mga);
    }
    i = j;
    if (!Arrays.equals(this.Mdp, g.bQV)) {
      i = j + b.c(200, this.Mdp);
    }
    j = i;
    if (this.Mgb != null) {
      j = i + b.b(201, this.Mgb);
    }
    i = j;
    if (this.Mgc != -1) {
      i = j + b.bz(202, this.Mgc);
    }
    j = i;
    if (!this.Mgd.equals("")) {
      j = i + b.e(203, this.Mgd);
    }
    i = j;
    if (this.platform != 0) {
      i = j + b.bz(204, this.platform);
    }
    j = i;
    if (this.Mge != 0) {
      j = i + b.bA(205, this.Mge);
    }
    i = j;
    if (this.CMC != 0) {
      i = j + b.bA(206, this.CMC);
    }
    j = i;
    if (this.Mgf != 0) {
      j = i + b.bA(207, this.Mgf);
    }
    i = j;
    if (this.Mgg != 0) {
      i = j + b.bA(208, this.Mgg);
    }
    j = i;
    if (this.Mdk != 0) {
      j = i + b.bA(240, this.Mdk);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a.a.ay
 * JD-Core Version:    0.7.0.1
 */