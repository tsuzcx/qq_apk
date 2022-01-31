package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public abstract interface a
{
  public static final class ad
    extends e
  {
    public String BdG = "";
    public String groupId = "";
    public int twP = 0;
    public long twQ = 0L;
    
    public ad()
    {
      this.bgY = -1;
    }
    
    public final void a(b paramb)
    {
      if (!this.groupId.equals("")) {
        paramb.e(1, this.groupId);
      }
      if (this.twP != 0) {
        paramb.bj(2, this.twP);
      }
      if (this.twQ != 0L) {
        paramb.n(3, this.twQ);
      }
      if (!this.BdG.equals("")) {
        paramb.e(4, this.BdG);
      }
      super.a(paramb);
    }
    
    public final int sz()
    {
      int j = super.sz();
      int i = j;
      if (!this.groupId.equals("")) {
        i = j + b.f(1, this.groupId);
      }
      j = i;
      if (this.twP != 0) {
        j = i + b.bl(2, this.twP);
      }
      i = j;
      if (this.twQ != 0L) {
        i = j + b.p(3, this.twQ);
      }
      j = i;
      if (!this.BdG.equals("")) {
        j = i + b.f(4, this.BdG);
      }
      return j;
    }
  }
  
  public static final class af
    extends e
  {
    public int Bfo = 0;
    public int Bfp = 0;
    public int Bfq = 0;
    public int Bfr = 0;
    public int Bfs = 0;
    public int Bft = 0;
    public int Bfu = -1;
    public int Bfv = 0;
    public int nMZ = 0;
    public long nNa = 0L;
    
    public af()
    {
      this.bgY = -1;
    }
    
    public final void a(b paramb)
    {
      if (this.Bfo != 0) {
        paramb.bk(1, this.Bfo);
      }
      if (this.nMZ != 0) {
        paramb.bj(2, this.nMZ);
      }
      if (this.nNa != 0L) {
        paramb.n(3, this.nNa);
      }
      if (this.Bfp != 0) {
        paramb.bk(4, this.Bfp);
      }
      if (this.Bfq != 0) {
        paramb.bk(5, this.Bfq);
      }
      if (this.Bfr != 0) {
        paramb.bk(6, this.Bfr);
      }
      if (this.Bfs != 0) {
        paramb.bk(7, this.Bfs);
      }
      if (this.Bft != 0) {
        paramb.bk(8, this.Bft);
      }
      if (this.Bfu != -1) {
        paramb.bj(9, this.Bfu);
      }
      if (this.Bfv != 0) {
        paramb.bj(10, this.Bfv);
      }
      super.a(paramb);
    }
    
    public final int sz()
    {
      int j = super.sz();
      int i = j;
      if (this.Bfo != 0) {
        i = j + b.bm(1, this.Bfo);
      }
      j = i;
      if (this.nMZ != 0) {
        j = i + b.bl(2, this.nMZ);
      }
      i = j;
      if (this.nNa != 0L) {
        i = j + b.p(3, this.nNa);
      }
      j = i;
      if (this.Bfp != 0) {
        j = i + b.bm(4, this.Bfp);
      }
      i = j;
      if (this.Bfq != 0) {
        i = j + b.bm(5, this.Bfq);
      }
      j = i;
      if (this.Bfr != 0) {
        j = i + b.bm(6, this.Bfr);
      }
      i = j;
      if (this.Bfs != 0) {
        i = j + b.bm(7, this.Bfs);
      }
      j = i;
      if (this.Bft != 0) {
        j = i + b.bm(8, this.Bft);
      }
      i = j;
      if (this.Bfu != -1) {
        i = j + b.bl(9, this.Bfu);
      }
      j = i;
      if (this.Bfv != 0) {
        j = i + b.bl(10, this.Bfv);
      }
      return j;
    }
  }
  
  public static final class am
    extends e
  {
    private static volatile am[] Bfx;
    public String Bfy = "";
    public int Bfz = 0;
    public int kJx = 0;
    public int wjE = 0;
    
    public am()
    {
      this.bgY = -1;
    }
    
    public static am[] dTN()
    {
      if (Bfx == null) {}
      synchronized (c.bgX)
      {
        if (Bfx == null) {
          Bfx = new am[0];
        }
        return Bfx;
      }
    }
    
    public final void a(b paramb)
    {
      if (this.kJx != 0) {
        paramb.bk(1, this.kJx);
      }
      if (!this.Bfy.equals("")) {
        paramb.e(2, this.Bfy);
      }
      if (this.wjE != 0) {
        paramb.bk(3, this.wjE);
      }
      if (this.Bfz != 0) {
        paramb.bk(4, this.Bfz);
      }
      super.a(paramb);
    }
    
    public final int sz()
    {
      int j = super.sz();
      int i = j;
      if (this.kJx != 0) {
        i = j + b.bm(1, this.kJx);
      }
      j = i;
      if (!this.Bfy.equals("")) {
        j = i + b.f(2, this.Bfy);
      }
      i = j;
      if (this.wjE != 0) {
        i = j + b.bm(3, this.wjE);
      }
      j = i;
      if (this.Bfz != 0) {
        j = i + b.bm(4, this.Bfz);
      }
      return j;
    }
  }
  
  public static final class at
    extends e
  {
    public byte[] BfT = g.bhf;
    public long BfU = 0L;
    public byte[] BfV = g.bhf;
    public byte[] BfW = g.bhf;
    public byte[] BfX = g.bhf;
    public a.ax BfY = null;
    public byte[] BfZ = g.bhf;
    public a.ap Bga = null;
    public String Bgb = "";
    public String Bgc = "";
    public long Bgd = 0L;
    public byte[] Bge = g.bhf;
    public byte[] Bgf = g.bhf;
    public byte[] Bgg = g.bhf;
    public byte[] Bgh = g.bhf;
    public int Bgi = 0;
    public byte[] Bgj = g.bhf;
    public byte[] Bgk = g.bhf;
    public int Bgl = 0;
    public a.n[] Bgm = a.n.dTK();
    public byte[] bpy = g.bhf;
    public int cve = 0;
    public String name = "";
    
    public at()
    {
      this.bgY = -1;
    }
    
    public final void a(b paramb)
    {
      if (!this.name.equals("")) {
        paramb.e(1, this.name);
      }
      if (!Arrays.equals(this.BfT, g.bhf)) {
        paramb.b(2, this.BfT);
      }
      if (this.cve != 0) {
        paramb.bj(3, this.cve);
      }
      if (this.BfU != 0L) {
        paramb.m(4, this.BfU);
      }
      if (!Arrays.equals(this.BfV, g.bhf)) {
        paramb.b(5, this.BfV);
      }
      if (!Arrays.equals(this.BfW, g.bhf)) {
        paramb.b(6, this.BfW);
      }
      if (!Arrays.equals(this.BfX, g.bhf)) {
        paramb.b(7, this.BfX);
      }
      if (this.BfY != null) {
        paramb.a(8, this.BfY);
      }
      if (!Arrays.equals(this.BfZ, g.bhf)) {
        paramb.b(9, this.BfZ);
      }
      if (this.Bga != null) {
        paramb.a(10, this.Bga);
      }
      if (!this.Bgb.equals("")) {
        paramb.e(100, this.Bgb);
      }
      if (!this.Bgc.equals("")) {
        paramb.e(101, this.Bgc);
      }
      if (this.Bgd != 0L) {
        paramb.m(200, this.Bgd);
      }
      if (!Arrays.equals(this.Bge, g.bhf)) {
        paramb.b(201, this.Bge);
      }
      if (!Arrays.equals(this.Bgf, g.bhf)) {
        paramb.b(202, this.Bgf);
      }
      if (!Arrays.equals(this.Bgg, g.bhf)) {
        paramb.b(203, this.Bgg);
      }
      if (!Arrays.equals(this.Bgh, g.bhf)) {
        paramb.b(204, this.Bgh);
      }
      if (this.Bgi != 0) {
        paramb.bj(220, this.Bgi);
      }
      if (!Arrays.equals(this.Bgj, g.bhf)) {
        paramb.b(221, this.Bgj);
      }
      if (!Arrays.equals(this.Bgk, g.bhf)) {
        paramb.b(222, this.Bgk);
      }
      if (!Arrays.equals(this.bpy, g.bhf)) {
        paramb.b(223, this.bpy);
      }
      if (this.Bgl != 0) {
        paramb.bk(224, this.Bgl);
      }
      if ((this.Bgm != null) && (this.Bgm.length > 0))
      {
        int i = 0;
        while (i < this.Bgm.length)
        {
          a.n localn = this.Bgm[i];
          if (localn != null) {
            paramb.a(225, localn);
          }
          i += 1;
        }
      }
      super.a(paramb);
    }
    
    public final int sz()
    {
      int j = super.sz();
      int i = j;
      if (!this.name.equals("")) {
        i = j + b.f(1, this.name);
      }
      j = i;
      if (!Arrays.equals(this.BfT, g.bhf)) {
        j = i + b.c(2, this.BfT);
      }
      i = j;
      if (this.cve != 0) {
        i = j + b.bl(3, this.cve);
      }
      j = i;
      if (this.BfU != 0L) {
        j = i + b.o(4, this.BfU);
      }
      i = j;
      if (!Arrays.equals(this.BfV, g.bhf)) {
        i = j + b.c(5, this.BfV);
      }
      j = i;
      if (!Arrays.equals(this.BfW, g.bhf)) {
        j = i + b.c(6, this.BfW);
      }
      i = j;
      if (!Arrays.equals(this.BfX, g.bhf)) {
        i = j + b.c(7, this.BfX);
      }
      j = i;
      if (this.BfY != null) {
        j = i + b.b(8, this.BfY);
      }
      i = j;
      if (!Arrays.equals(this.BfZ, g.bhf)) {
        i = j + b.c(9, this.BfZ);
      }
      j = i;
      if (this.Bga != null) {
        j = i + b.b(10, this.Bga);
      }
      i = j;
      if (!this.Bgb.equals("")) {
        i = j + b.f(100, this.Bgb);
      }
      j = i;
      if (!this.Bgc.equals("")) {
        j = i + b.f(101, this.Bgc);
      }
      i = j;
      if (this.Bgd != 0L) {
        i = j + b.o(200, this.Bgd);
      }
      j = i;
      if (!Arrays.equals(this.Bge, g.bhf)) {
        j = i + b.c(201, this.Bge);
      }
      i = j;
      if (!Arrays.equals(this.Bgf, g.bhf)) {
        i = j + b.c(202, this.Bgf);
      }
      j = i;
      if (!Arrays.equals(this.Bgg, g.bhf)) {
        j = i + b.c(203, this.Bgg);
      }
      i = j;
      if (!Arrays.equals(this.Bgh, g.bhf)) {
        i = j + b.c(204, this.Bgh);
      }
      j = i;
      if (this.Bgi != 0) {
        j = i + b.bl(220, this.Bgi);
      }
      i = j;
      if (!Arrays.equals(this.Bgj, g.bhf)) {
        i = j + b.c(221, this.Bgj);
      }
      j = i;
      if (!Arrays.equals(this.Bgk, g.bhf)) {
        j = i + b.c(222, this.Bgk);
      }
      int k = j;
      if (!Arrays.equals(this.bpy, g.bhf)) {
        k = j + b.c(223, this.bpy);
      }
      i = k;
      if (this.Bgl != 0) {
        i = k + b.bm(224, this.Bgl);
      }
      j = i;
      if (this.Bgm != null)
      {
        j = i;
        if (this.Bgm.length > 0)
        {
          j = 0;
          while (j < this.Bgm.length)
          {
            a.n localn = this.Bgm[j];
            k = i;
            if (localn != null) {
              k = i + b.b(225, localn);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      return j;
    }
  }
  
  public static final class au
    extends e
  {
    private static volatile au[] Bgn;
    public int BdL = 0;
    public a.av[] BeZ = a.av.dTR();
    public String Bgo = "";
    public String groupId = "";
    public int twP = 0;
    public long twQ = 0L;
    
    public au()
    {
      this.bgY = -1;
    }
    
    public static au[] dTQ()
    {
      if (Bgn == null) {}
      synchronized (c.bgX)
      {
        if (Bgn == null) {
          Bgn = new au[0];
        }
        return Bgn;
      }
    }
    
    public final void a(b paramb)
    {
      if (!this.groupId.equals("")) {
        paramb.e(1, this.groupId);
      }
      if (this.twP != 0) {
        paramb.bj(2, this.twP);
      }
      if (this.twQ != 0L) {
        paramb.n(3, this.twQ);
      }
      if ((this.BeZ != null) && (this.BeZ.length > 0))
      {
        int i = 0;
        while (i < this.BeZ.length)
        {
          a.av localav = this.BeZ[i];
          if (localav != null) {
            paramb.a(4, localav);
          }
          i += 1;
        }
      }
      if (this.BdL != 0) {
        paramb.bk(5, this.BdL);
      }
      if (!this.Bgo.equals("")) {
        paramb.e(6, this.Bgo);
      }
      super.a(paramb);
    }
    
    public final int sz()
    {
      int j = super.sz();
      int i = j;
      if (!this.groupId.equals("")) {
        i = j + b.f(1, this.groupId);
      }
      j = i;
      if (this.twP != 0) {
        j = i + b.bl(2, this.twP);
      }
      i = j;
      if (this.twQ != 0L) {
        i = j + b.p(3, this.twQ);
      }
      j = i;
      if (this.BeZ != null)
      {
        j = i;
        if (this.BeZ.length > 0)
        {
          j = 0;
          while (j < this.BeZ.length)
          {
            a.av localav = this.BeZ[j];
            int k = i;
            if (localav != null) {
              k = i + b.b(4, localav);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (this.BdL != 0) {
        i = j + b.bm(5, this.BdL);
      }
      j = i;
      if (!this.Bgo.equals("")) {
        j = i + b.f(6, this.Bgo);
      }
      return j;
    }
  }
  
  public static final class av
    extends e
  {
    private static volatile av[] Bgp;
    public int BdR = 0;
    public byte[] BdW = g.bhf;
    public String Bfy = "";
    public int BgA = 0;
    public int BgB = 0;
    public a.an BgC = null;
    public String BgD = "";
    public int BgE = 0;
    public a.s BgF = null;
    public int BgG = -1;
    public String BgH = "";
    public int BgI = 0;
    public int BgJ = 0;
    public int BgK = 0;
    public int Bgq = 0;
    public int Bgr = 0;
    public a.aq Bgs = null;
    public int Bgt = 0;
    public String Bgu = "";
    public a.ar[] Bgv = a.ar.dTP();
    public int Bgw = 0;
    public int[] Bgx = g.bgZ;
    public int Bgy = 0;
    public int Bgz = 0;
    public int aXG = 0;
    public int kJx = -1;
    public int platform = 0;
    public int status = 0;
    public int tKv = 0;
    public int wjE = 0;
    
    public av()
    {
      this.bgY = -1;
    }
    
    public static av[] dTR()
    {
      if (Bgp == null) {}
      synchronized (c.bgX)
      {
        if (Bgp == null) {
          Bgp = new av[0];
        }
        return Bgp;
      }
    }
    
    public final void a(b paramb)
    {
      int j = 0;
      if (this.wjE != 0) {
        paramb.bk(1, this.wjE);
      }
      if (this.Bgq != 0) {
        paramb.bk(2, this.Bgq);
      }
      if (this.status != 0) {
        paramb.bk(3, this.status);
      }
      if (this.aXG != 0) {
        paramb.bk(4, this.aXG);
      }
      if (this.kJx != -1) {
        paramb.bj(5, this.kJx);
      }
      if (this.Bgr != 0) {
        paramb.bk(6, this.Bgr);
      }
      if (this.Bgs != null) {
        paramb.a(7, this.Bgs);
      }
      if (this.Bgt != 0) {
        paramb.bk(8, this.Bgt);
      }
      if (!this.Bgu.equals("")) {
        paramb.e(9, this.Bgu);
      }
      int i;
      if ((this.Bgv != null) && (this.Bgv.length > 0))
      {
        i = 0;
        while (i < this.Bgv.length)
        {
          a.ar localar = this.Bgv[i];
          if (localar != null) {
            paramb.a(10, localar);
          }
          i += 1;
        }
      }
      if (this.Bgw != 0) {
        paramb.bk(11, this.Bgw);
      }
      if ((this.Bgx != null) && (this.Bgx.length > 0))
      {
        i = j;
        while (i < this.Bgx.length)
        {
          paramb.bk(12, this.Bgx[i]);
          i += 1;
        }
      }
      if (this.Bgy != 0) {
        paramb.bk(13, this.Bgy);
      }
      if (this.Bgz != 0) {
        paramb.bk(14, this.Bgz);
      }
      if (this.BgA != 0) {
        paramb.bk(15, this.BgA);
      }
      if (this.BgB != 0) {
        paramb.bk(16, this.BgB);
      }
      if (this.BgC != null) {
        paramb.a(17, this.BgC);
      }
      if (!this.Bfy.equals("")) {
        paramb.e(100, this.Bfy);
      }
      if (!this.BgD.equals("")) {
        paramb.e(101, this.BgD);
      }
      if (this.BgE != 0) {
        paramb.bk(102, this.BgE);
      }
      if (!Arrays.equals(this.BdW, g.bhf)) {
        paramb.b(200, this.BdW);
      }
      if (this.BgF != null) {
        paramb.a(201, this.BgF);
      }
      if (this.BgG != -1) {
        paramb.bj(202, this.BgG);
      }
      if (!this.BgH.equals("")) {
        paramb.e(203, this.BgH);
      }
      if (this.platform != 0) {
        paramb.bj(204, this.platform);
      }
      if (this.BgI != 0) {
        paramb.bk(205, this.BgI);
      }
      if (this.tKv != 0) {
        paramb.bk(206, this.tKv);
      }
      if (this.BgJ != 0) {
        paramb.bk(207, this.BgJ);
      }
      if (this.BgK != 0) {
        paramb.bk(208, this.BgK);
      }
      if (this.BdR != 0) {
        paramb.bk(240, this.BdR);
      }
      super.a(paramb);
    }
    
    public final int sz()
    {
      int j = super.sz();
      int i = j;
      if (this.wjE != 0) {
        i = j + b.bm(1, this.wjE);
      }
      j = i;
      if (this.Bgq != 0) {
        j = i + b.bm(2, this.Bgq);
      }
      i = j;
      if (this.status != 0) {
        i = j + b.bm(3, this.status);
      }
      j = i;
      if (this.aXG != 0) {
        j = i + b.bm(4, this.aXG);
      }
      i = j;
      if (this.kJx != -1) {
        i = j + b.bl(5, this.kJx);
      }
      j = i;
      if (this.Bgr != 0) {
        j = i + b.bm(6, this.Bgr);
      }
      i = j;
      if (this.Bgs != null) {
        i = j + b.b(7, this.Bgs);
      }
      j = i;
      if (this.Bgt != 0) {
        j = i + b.bm(8, this.Bgt);
      }
      i = j;
      if (!this.Bgu.equals("")) {
        i = j + b.f(9, this.Bgu);
      }
      j = i;
      int k;
      if (this.Bgv != null)
      {
        j = i;
        if (this.Bgv.length > 0)
        {
          j = 0;
          while (j < this.Bgv.length)
          {
            a.ar localar = this.Bgv[j];
            k = i;
            if (localar != null) {
              k = i + b.b(10, localar);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (this.Bgw != 0) {
        i = j + b.bm(11, this.Bgw);
      }
      j = i;
      if (this.Bgx != null)
      {
        j = i;
        if (this.Bgx.length > 0)
        {
          j = 0;
          k = 0;
          while (j < this.Bgx.length)
          {
            k += b.eY(this.Bgx[j]);
            j += 1;
          }
          j = i + k + this.Bgx.length * 1;
        }
      }
      i = j;
      if (this.Bgy != 0) {
        i = j + b.bm(13, this.Bgy);
      }
      j = i;
      if (this.Bgz != 0) {
        j = i + b.bm(14, this.Bgz);
      }
      i = j;
      if (this.BgA != 0) {
        i = j + b.bm(15, this.BgA);
      }
      j = i;
      if (this.BgB != 0) {
        j = i + b.bm(16, this.BgB);
      }
      i = j;
      if (this.BgC != null) {
        i = j + b.b(17, this.BgC);
      }
      j = i;
      if (!this.Bfy.equals("")) {
        j = i + b.f(100, this.Bfy);
      }
      i = j;
      if (!this.BgD.equals("")) {
        i = j + b.f(101, this.BgD);
      }
      j = i;
      if (this.BgE != 0) {
        j = i + b.bm(102, this.BgE);
      }
      i = j;
      if (!Arrays.equals(this.BdW, g.bhf)) {
        i = j + b.c(200, this.BdW);
      }
      j = i;
      if (this.BgF != null) {
        j = i + b.b(201, this.BgF);
      }
      i = j;
      if (this.BgG != -1) {
        i = j + b.bl(202, this.BgG);
      }
      j = i;
      if (!this.BgH.equals("")) {
        j = i + b.f(203, this.BgH);
      }
      i = j;
      if (this.platform != 0) {
        i = j + b.bl(204, this.platform);
      }
      j = i;
      if (this.BgI != 0) {
        j = i + b.bm(205, this.BgI);
      }
      i = j;
      if (this.tKv != 0) {
        i = j + b.bm(206, this.tKv);
      }
      j = i;
      if (this.BgJ != 0) {
        j = i + b.bm(207, this.BgJ);
      }
      i = j;
      if (this.BgK != 0) {
        i = j + b.bm(208, this.BgK);
      }
      j = i;
      if (this.BdR != 0) {
        j = i + b.bm(240, this.BdR);
      }
      return j;
    }
  }
  
  public static final class aw
    extends e
  {
    private static volatile aw[] BgL;
    public long BgM = 0L;
    public String BgN = "";
    public String BgO = "";
    public String pWk = "";
    public String username = "";
    public int wjE = 0;
    
    public aw()
    {
      this.bgY = -1;
    }
    
    public static aw[] dTS()
    {
      if (BgL == null) {}
      synchronized (c.bgX)
      {
        if (BgL == null) {
          BgL = new aw[0];
        }
        return BgL;
      }
    }
    
    public final void a(b paramb)
    {
      if (this.wjE != 0) {
        paramb.bk(1, this.wjE);
      }
      if (!this.username.equals("")) {
        paramb.e(2, this.username);
      }
      if (!this.pWk.equals("")) {
        paramb.e(3, this.pWk);
      }
      if (this.BgM != 0L) {
        paramb.m(4, this.BgM);
      }
      if (!this.BgN.equals("")) {
        paramb.e(5, this.BgN);
      }
      if (!this.BgO.equals("")) {
        paramb.e(6, this.BgO);
      }
      super.a(paramb);
    }
    
    public final int sz()
    {
      int j = super.sz();
      int i = j;
      if (this.wjE != 0) {
        i = j + b.bm(1, this.wjE);
      }
      j = i;
      if (!this.username.equals("")) {
        j = i + b.f(2, this.username);
      }
      i = j;
      if (!this.pWk.equals("")) {
        i = j + b.f(3, this.pWk);
      }
      j = i;
      if (this.BgM != 0L) {
        j = i + b.o(4, this.BgM);
      }
      i = j;
      if (!this.BgN.equals("")) {
        i = j + b.f(5, this.BgN);
      }
      j = i;
      if (!this.BgO.equals("")) {
        j = i + b.f(6, this.BgO);
      }
      return j;
    }
  }
  
  public static final class f
    extends e
  {
    public int BdV = 0;
    public int aXG = 0;
    public String groupId = "";
    public int twP = 0;
    public long twQ = 0L;
    
    public f()
    {
      this.bgY = -1;
    }
    
    public final void a(b paramb)
    {
      if (!this.groupId.equals("")) {
        paramb.e(1, this.groupId);
      }
      if (this.twP != 0) {
        paramb.bj(2, this.twP);
      }
      if (this.twQ != 0L) {
        paramb.n(3, this.twQ);
      }
      if (this.aXG != 0) {
        paramb.bj(4, this.aXG);
      }
      if (this.BdV != 0) {
        paramb.bj(5, this.BdV);
      }
      super.a(paramb);
    }
    
    public final int sz()
    {
      int j = super.sz();
      int i = j;
      if (!this.groupId.equals("")) {
        i = j + b.f(1, this.groupId);
      }
      j = i;
      if (this.twP != 0) {
        j = i + b.bl(2, this.twP);
      }
      i = j;
      if (this.twQ != 0L) {
        i = j + b.p(3, this.twQ);
      }
      j = i;
      if (this.aXG != 0) {
        j = i + b.bl(4, this.aXG);
      }
      i = j;
      if (this.BdV != 0) {
        i = j + b.bl(5, this.BdV);
      }
      return i;
    }
  }
  
  public static final class o
    extends e
  {
    private static volatile o[] Bei;
    public int Bej = 0;
    public int port = 0;
    
    public o()
    {
      this.bgY = -1;
    }
    
    public static o[] dTL()
    {
      if (Bei == null) {}
      synchronized (c.bgX)
      {
        if (Bei == null) {
          Bei = new o[0];
        }
        return Bei;
      }
    }
    
    public final void a(b paramb)
    {
      if (this.Bej != 0) {
        paramb.bk(1, this.Bej);
      }
      if (this.port != 0) {
        paramb.bj(2, this.port);
      }
      super.a(paramb);
    }
    
    public final int sz()
    {
      int j = super.sz();
      int i = j;
      if (this.Bej != 0) {
        i = j + b.bm(1, this.Bej);
      }
      j = i;
      if (this.port != 0) {
        j = i + b.bl(2, this.port);
      }
      return j;
    }
  }
  
  public static final class p
    extends e
  {
    public a.at BdI = null;
    public int BdL = 0;
    public a.ay BdN = null;
    public int Bek = 0;
    public a.aw[] Bel = a.aw.dTS();
    public a.av[] Bem = a.av.dTR();
    public a.as Ben = null;
    public int Beo = 0;
    public int Bep = 0;
    public int Beq = 0;
    public byte[] Ber = g.bhf;
    public byte[] Bes = g.bhf;
    public a.av[] Bet = a.av.dTR();
    public long cpO = 0L;
    public String groupId = "";
    public int twP = 0;
    public long twQ = 0L;
    
    public p()
    {
      this.bgY = -1;
    }
    
    public final void a(b paramb)
    {
      int j = 0;
      if (this.Bek != 0) {
        paramb.bj(1, this.Bek);
      }
      if (!this.groupId.equals("")) {
        paramb.e(2, this.groupId);
      }
      if (this.twP != 0) {
        paramb.bj(3, this.twP);
      }
      if (this.twQ != 0L) {
        paramb.n(4, this.twQ);
      }
      if (this.BdL != 0) {
        paramb.bk(5, this.BdL);
      }
      if (this.BdI != null) {
        paramb.a(6, this.BdI);
      }
      int i;
      Object localObject;
      if ((this.Bel != null) && (this.Bel.length > 0))
      {
        i = 0;
        while (i < this.Bel.length)
        {
          localObject = this.Bel[i];
          if (localObject != null) {
            paramb.a(7, (e)localObject);
          }
          i += 1;
        }
      }
      if ((this.Bem != null) && (this.Bem.length > 0))
      {
        i = 0;
        while (i < this.Bem.length)
        {
          localObject = this.Bem[i];
          if (localObject != null) {
            paramb.a(8, (e)localObject);
          }
          i += 1;
        }
      }
      if (this.Ben != null) {
        paramb.a(9, this.Ben);
      }
      if (this.BdN != null) {
        paramb.a(10, this.BdN);
      }
      if (this.Beo != 0) {
        paramb.bk(11, this.Beo);
      }
      if (this.Bep != 0) {
        paramb.bk(12, this.Bep);
      }
      if (this.cpO != 0L) {
        paramb.m(101, this.cpO);
      }
      if (this.Beq != 0) {
        paramb.bk(102, this.Beq);
      }
      if (!Arrays.equals(this.Ber, g.bhf)) {
        paramb.b(103, this.Ber);
      }
      if (!Arrays.equals(this.Bes, g.bhf)) {
        paramb.b(200, this.Bes);
      }
      if ((this.Bet != null) && (this.Bet.length > 0))
      {
        i = j;
        while (i < this.Bet.length)
        {
          localObject = this.Bet[i];
          if (localObject != null) {
            paramb.a(201, (e)localObject);
          }
          i += 1;
        }
      }
      super.a(paramb);
    }
    
    public final int sz()
    {
      int m = 0;
      int j = super.sz();
      int i = j;
      if (this.Bek != 0) {
        i = j + b.bl(1, this.Bek);
      }
      j = i;
      if (!this.groupId.equals("")) {
        j = i + b.f(2, this.groupId);
      }
      i = j;
      if (this.twP != 0) {
        i = j + b.bl(3, this.twP);
      }
      j = i;
      if (this.twQ != 0L) {
        j = i + b.p(4, this.twQ);
      }
      int k = j;
      if (this.BdL != 0) {
        k = j + b.bm(5, this.BdL);
      }
      i = k;
      if (this.BdI != null) {
        i = k + b.b(6, this.BdI);
      }
      j = i;
      Object localObject;
      if (this.Bel != null)
      {
        j = i;
        if (this.Bel.length > 0)
        {
          j = 0;
          while (j < this.Bel.length)
          {
            localObject = this.Bel[j];
            k = i;
            if (localObject != null) {
              k = i + b.b(7, (e)localObject);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (this.Bem != null)
      {
        i = j;
        if (this.Bem.length > 0)
        {
          k = 0;
          i = j;
          j = k;
          while (j < this.Bem.length)
          {
            localObject = this.Bem[j];
            k = i;
            if (localObject != null) {
              k = i + b.b(8, (e)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      j = i;
      if (this.Ben != null) {
        j = i + b.b(9, this.Ben);
      }
      i = j;
      if (this.BdN != null) {
        i = j + b.b(10, this.BdN);
      }
      j = i;
      if (this.Beo != 0) {
        j = i + b.bm(11, this.Beo);
      }
      i = j;
      if (this.Bep != 0) {
        i = j + b.bm(12, this.Bep);
      }
      j = i;
      if (this.cpO != 0L) {
        j = i + b.o(101, this.cpO);
      }
      i = j;
      if (this.Beq != 0) {
        i = j + b.bm(102, this.Beq);
      }
      j = i;
      if (!Arrays.equals(this.Ber, g.bhf)) {
        j = i + b.c(103, this.Ber);
      }
      i = j;
      if (!Arrays.equals(this.Bes, g.bhf)) {
        i = j + b.c(200, this.Bes);
      }
      k = i;
      if (this.Bet != null)
      {
        k = i;
        if (this.Bet.length > 0)
        {
          j = m;
          for (;;)
          {
            k = i;
            if (j >= this.Bet.length) {
              break;
            }
            localObject = this.Bet[j];
            k = i;
            if (localObject != null) {
              k = i + b.b(201, (e)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      return k;
    }
  }
  
  public static final class q
    extends e
  {
    public int Beu = 0;
    
    public q()
    {
      this.bgY = -1;
    }
    
    public final void a(b paramb)
    {
      paramb.bk(1, this.Beu);
      super.a(paramb);
    }
    
    public final int sz()
    {
      return super.sz() + b.bm(1, this.Beu);
    }
  }
  
  public static final class v
    extends e
  {
    public a.u BeV = null;
    public byte[] body = g.bhf;
    
    public v()
    {
      this.bgY = -1;
    }
    
    public final void a(b paramb)
    {
      if (this.BeV != null) {
        paramb.a(1, this.BeV);
      }
      if (!Arrays.equals(this.body, g.bhf)) {
        paramb.b(2, this.body);
      }
      super.a(paramb);
    }
    
    public final int sz()
    {
      int j = super.sz();
      int i = j;
      if (this.BeV != null) {
        i = j + b.b(1, this.BeV);
      }
      j = i;
      if (!Arrays.equals(this.body, g.bhf)) {
        j = i + b.c(2, this.body);
      }
      return j;
    }
  }
  
  public static final class x
    extends e
  {
    public a.at BdI = null;
    public a.av[] BeZ = a.av.dTR();
    public String groupId = "";
    public int twP = 0;
    public long twQ = 0L;
    
    public x()
    {
      this.bgY = -1;
    }
    
    public final void a(b paramb)
    {
      if (!this.groupId.equals("")) {
        paramb.e(1, this.groupId);
      }
      if (this.twP != 0) {
        paramb.bj(2, this.twP);
      }
      if (this.twQ != 0L) {
        paramb.n(3, this.twQ);
      }
      if ((this.BeZ != null) && (this.BeZ.length > 0))
      {
        int i = 0;
        while (i < this.BeZ.length)
        {
          a.av localav = this.BeZ[i];
          if (localav != null) {
            paramb.a(4, localav);
          }
          i += 1;
        }
      }
      if (this.BdI != null) {
        paramb.a(5, this.BdI);
      }
      super.a(paramb);
    }
    
    public final int sz()
    {
      int j = super.sz();
      int i = j;
      if (!this.groupId.equals("")) {
        i = j + b.f(1, this.groupId);
      }
      j = i;
      if (this.twP != 0) {
        j = i + b.bl(2, this.twP);
      }
      i = j;
      if (this.twQ != 0L) {
        i = j + b.p(3, this.twQ);
      }
      j = i;
      if (this.BeZ != null)
      {
        j = i;
        if (this.BeZ.length > 0)
        {
          j = 0;
          while (j < this.BeZ.length)
          {
            a.av localav = this.BeZ[j];
            int k = i;
            if (localav != null) {
              k = i + b.b(4, localav);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (this.BdI != null) {
        i = j + b.b(5, this.BdI);
      }
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a
 * JD-Core Version:    0.7.0.1
 */