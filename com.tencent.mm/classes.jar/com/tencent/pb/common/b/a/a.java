package com.tencent.pb.common.b.a;

import com.google.a.a.b;
import com.google.a.a.c;
import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public abstract interface a
{
  public static final class am
    extends e
  {
    private static volatile am[] wHX;
    public int iEo = 0;
    public int sqW = 0;
    public String wHY = "";
    public int wHZ = 0;
    
    public am()
    {
      this.aUI = -1;
    }
    
    public static am[] cOb()
    {
      if (wHX == null) {}
      synchronized (c.aUH)
      {
        if (wHX == null) {
          wHX = new am[0];
        }
        return wHX;
      }
    }
    
    public final void a(b paramb)
    {
      if (this.iEo != 0) {
        paramb.aM(1, this.iEo);
      }
      if (!this.wHY.equals("")) {
        paramb.d(2, this.wHY);
      }
      if (this.sqW != 0) {
        paramb.aM(3, this.sqW);
      }
      if (this.wHZ != 0) {
        paramb.aM(4, this.wHZ);
      }
      super.a(paramb);
    }
    
    protected final int oQ()
    {
      int j = super.oQ();
      int i = j;
      if (this.iEo != 0) {
        i = j + b.aO(1, this.iEo);
      }
      j = i;
      if (!this.wHY.equals("")) {
        j = i + b.e(2, this.wHY);
      }
      i = j;
      if (this.sqW != 0) {
        i = j + b.aO(3, this.sqW);
      }
      j = i;
      if (this.wHZ != 0) {
        j = i + b.aO(4, this.wHZ);
      }
      return j;
    }
  }
  
  public static final class at
    extends e
  {
    public byte[] aYQ = g.aUP;
    public int bNM = 0;
    public String name = "";
    public a.ap wIA = null;
    public String wIB = "";
    public String wIC = "";
    public long wID = 0L;
    public byte[] wIE = g.aUP;
    public byte[] wIF = g.aUP;
    public byte[] wIG = g.aUP;
    public byte[] wIH = g.aUP;
    public int wII = 0;
    public byte[] wIJ = g.aUP;
    public byte[] wIK = g.aUP;
    public int wIL = 0;
    public a.n[] wIM = a.n.cNY();
    public byte[] wIt = g.aUP;
    public long wIu = 0L;
    public byte[] wIv = g.aUP;
    public byte[] wIw = g.aUP;
    public byte[] wIx = g.aUP;
    public a.ax wIy = null;
    public byte[] wIz = g.aUP;
    
    public at()
    {
      this.aUI = -1;
    }
    
    public final void a(b paramb)
    {
      if (!this.name.equals("")) {
        paramb.d(1, this.name);
      }
      if (!Arrays.equals(this.wIt, g.aUP)) {
        paramb.b(2, this.wIt);
      }
      if (this.bNM != 0) {
        paramb.aL(3, this.bNM);
      }
      if (this.wIu != 0L) {
        paramb.h(4, this.wIu);
      }
      if (!Arrays.equals(this.wIv, g.aUP)) {
        paramb.b(5, this.wIv);
      }
      if (!Arrays.equals(this.wIw, g.aUP)) {
        paramb.b(6, this.wIw);
      }
      if (!Arrays.equals(this.wIx, g.aUP)) {
        paramb.b(7, this.wIx);
      }
      if (this.wIy != null) {
        paramb.a(8, this.wIy);
      }
      if (!Arrays.equals(this.wIz, g.aUP)) {
        paramb.b(9, this.wIz);
      }
      if (this.wIA != null) {
        paramb.a(10, this.wIA);
      }
      if (!this.wIB.equals("")) {
        paramb.d(100, this.wIB);
      }
      if (!this.wIC.equals("")) {
        paramb.d(101, this.wIC);
      }
      if (this.wID != 0L) {
        paramb.h(200, this.wID);
      }
      if (!Arrays.equals(this.wIE, g.aUP)) {
        paramb.b(201, this.wIE);
      }
      if (!Arrays.equals(this.wIF, g.aUP)) {
        paramb.b(202, this.wIF);
      }
      if (!Arrays.equals(this.wIG, g.aUP)) {
        paramb.b(203, this.wIG);
      }
      if (!Arrays.equals(this.wIH, g.aUP)) {
        paramb.b(204, this.wIH);
      }
      if (this.wII != 0) {
        paramb.aL(220, this.wII);
      }
      if (!Arrays.equals(this.wIJ, g.aUP)) {
        paramb.b(221, this.wIJ);
      }
      if (!Arrays.equals(this.wIK, g.aUP)) {
        paramb.b(222, this.wIK);
      }
      if (!Arrays.equals(this.aYQ, g.aUP)) {
        paramb.b(223, this.aYQ);
      }
      if (this.wIL != 0) {
        paramb.aM(224, this.wIL);
      }
      if ((this.wIM != null) && (this.wIM.length > 0))
      {
        int i = 0;
        while (i < this.wIM.length)
        {
          a.n localn = this.wIM[i];
          if (localn != null) {
            paramb.a(225, localn);
          }
          i += 1;
        }
      }
      super.a(paramb);
    }
    
    protected final int oQ()
    {
      int j = super.oQ();
      int i = j;
      if (!this.name.equals("")) {
        i = j + b.e(1, this.name);
      }
      j = i;
      if (!Arrays.equals(this.wIt, g.aUP)) {
        j = i + b.c(2, this.wIt);
      }
      i = j;
      if (this.bNM != 0) {
        i = j + b.aN(3, this.bNM);
      }
      j = i;
      if (this.wIu != 0L) {
        j = i + b.j(4, this.wIu);
      }
      i = j;
      if (!Arrays.equals(this.wIv, g.aUP)) {
        i = j + b.c(5, this.wIv);
      }
      j = i;
      if (!Arrays.equals(this.wIw, g.aUP)) {
        j = i + b.c(6, this.wIw);
      }
      i = j;
      if (!Arrays.equals(this.wIx, g.aUP)) {
        i = j + b.c(7, this.wIx);
      }
      j = i;
      if (this.wIy != null) {
        j = i + b.b(8, this.wIy);
      }
      i = j;
      if (!Arrays.equals(this.wIz, g.aUP)) {
        i = j + b.c(9, this.wIz);
      }
      j = i;
      if (this.wIA != null) {
        j = i + b.b(10, this.wIA);
      }
      i = j;
      if (!this.wIB.equals("")) {
        i = j + b.e(100, this.wIB);
      }
      j = i;
      if (!this.wIC.equals("")) {
        j = i + b.e(101, this.wIC);
      }
      i = j;
      if (this.wID != 0L) {
        i = j + b.j(200, this.wID);
      }
      j = i;
      if (!Arrays.equals(this.wIE, g.aUP)) {
        j = i + b.c(201, this.wIE);
      }
      i = j;
      if (!Arrays.equals(this.wIF, g.aUP)) {
        i = j + b.c(202, this.wIF);
      }
      j = i;
      if (!Arrays.equals(this.wIG, g.aUP)) {
        j = i + b.c(203, this.wIG);
      }
      i = j;
      if (!Arrays.equals(this.wIH, g.aUP)) {
        i = j + b.c(204, this.wIH);
      }
      j = i;
      if (this.wII != 0) {
        j = i + b.aN(220, this.wII);
      }
      i = j;
      if (!Arrays.equals(this.wIJ, g.aUP)) {
        i = j + b.c(221, this.wIJ);
      }
      j = i;
      if (!Arrays.equals(this.wIK, g.aUP)) {
        j = i + b.c(222, this.wIK);
      }
      int k = j;
      if (!Arrays.equals(this.aYQ, g.aUP)) {
        k = j + b.c(223, this.aYQ);
      }
      i = k;
      if (this.wIL != 0) {
        i = k + b.aO(224, this.wIL);
      }
      j = i;
      if (this.wIM != null)
      {
        j = i;
        if (this.wIM.length > 0)
        {
          j = 0;
          while (j < this.wIM.length)
          {
            a.n localn = this.wIM[j];
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
    private static volatile au[] wIN;
    public String groupId = "";
    public int pRI = 0;
    public long pRJ = 0L;
    public int wGk = 0;
    public a.av[] wHz = a.av.cOf();
    public String wIO = "";
    
    public au()
    {
      this.aUI = -1;
    }
    
    public static au[] cOe()
    {
      if (wIN == null) {}
      synchronized (c.aUH)
      {
        if (wIN == null) {
          wIN = new au[0];
        }
        return wIN;
      }
    }
    
    public final void a(b paramb)
    {
      if (!this.groupId.equals("")) {
        paramb.d(1, this.groupId);
      }
      if (this.pRI != 0) {
        paramb.aL(2, this.pRI);
      }
      if (this.pRJ != 0L) {
        paramb.i(3, this.pRJ);
      }
      if ((this.wHz != null) && (this.wHz.length > 0))
      {
        int i = 0;
        while (i < this.wHz.length)
        {
          a.av localav = this.wHz[i];
          if (localav != null) {
            paramb.a(4, localav);
          }
          i += 1;
        }
      }
      if (this.wGk != 0) {
        paramb.aM(5, this.wGk);
      }
      if (!this.wIO.equals("")) {
        paramb.d(6, this.wIO);
      }
      super.a(paramb);
    }
    
    protected final int oQ()
    {
      int j = super.oQ();
      int i = j;
      if (!this.groupId.equals("")) {
        i = j + b.e(1, this.groupId);
      }
      j = i;
      if (this.pRI != 0) {
        j = i + b.aN(2, this.pRI);
      }
      i = j;
      if (this.pRJ != 0L) {
        i = j + b.k(3, this.pRJ);
      }
      j = i;
      if (this.wHz != null)
      {
        j = i;
        if (this.wHz.length > 0)
        {
          j = 0;
          while (j < this.wHz.length)
          {
            a.av localav = this.wHz[j];
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
      if (this.wGk != 0) {
        i = j + b.aO(5, this.wGk);
      }
      j = i;
      if (!this.wIO.equals("")) {
        j = i + b.e(6, this.wIO);
      }
      return j;
    }
  }
  
  public static final class av
    extends e
  {
    private static volatile av[] wIP;
    public int aQw = 0;
    public int iEo = -1;
    public int platform = 0;
    public int qdI = 0;
    public int sqW = 0;
    public int status = 0;
    public int wGq = 0;
    public byte[] wGv = g.aUP;
    public String wHY = "";
    public int wIQ = 0;
    public int wIR = 0;
    public a.aq wIS = null;
    public int wIT = 0;
    public String wIU = "";
    public a.ar[] wIV = a.ar.cOd();
    public int wIW = 0;
    public int[] wIX = g.aUJ;
    public int wIY = 0;
    public int wIZ = 0;
    public int wJa = 0;
    public int wJb = 0;
    public a.an wJc = null;
    public String wJd = "";
    public int wJe = 0;
    public a.s wJf = null;
    public int wJg = -1;
    public String wJh = "";
    public int wJi = 0;
    public int wJj = 0;
    public int wJk = 0;
    
    public av()
    {
      this.aUI = -1;
    }
    
    public static av[] cOf()
    {
      if (wIP == null) {}
      synchronized (c.aUH)
      {
        if (wIP == null) {
          wIP = new av[0];
        }
        return wIP;
      }
    }
    
    public final void a(b paramb)
    {
      int j = 0;
      if (this.sqW != 0) {
        paramb.aM(1, this.sqW);
      }
      if (this.wIQ != 0) {
        paramb.aM(2, this.wIQ);
      }
      if (this.status != 0) {
        paramb.aM(3, this.status);
      }
      if (this.aQw != 0) {
        paramb.aM(4, this.aQw);
      }
      if (this.iEo != -1) {
        paramb.aL(5, this.iEo);
      }
      if (this.wIR != 0) {
        paramb.aM(6, this.wIR);
      }
      if (this.wIS != null) {
        paramb.a(7, this.wIS);
      }
      if (this.wIT != 0) {
        paramb.aM(8, this.wIT);
      }
      if (!this.wIU.equals("")) {
        paramb.d(9, this.wIU);
      }
      int i;
      if ((this.wIV != null) && (this.wIV.length > 0))
      {
        i = 0;
        while (i < this.wIV.length)
        {
          a.ar localar = this.wIV[i];
          if (localar != null) {
            paramb.a(10, localar);
          }
          i += 1;
        }
      }
      if (this.wIW != 0) {
        paramb.aM(11, this.wIW);
      }
      if ((this.wIX != null) && (this.wIX.length > 0))
      {
        i = j;
        while (i < this.wIX.length)
        {
          paramb.aM(12, this.wIX[i]);
          i += 1;
        }
      }
      if (this.wIY != 0) {
        paramb.aM(13, this.wIY);
      }
      if (this.wIZ != 0) {
        paramb.aM(14, this.wIZ);
      }
      if (this.wJa != 0) {
        paramb.aM(15, this.wJa);
      }
      if (this.wJb != 0) {
        paramb.aM(16, this.wJb);
      }
      if (this.wJc != null) {
        paramb.a(17, this.wJc);
      }
      if (!this.wHY.equals("")) {
        paramb.d(100, this.wHY);
      }
      if (!this.wJd.equals("")) {
        paramb.d(101, this.wJd);
      }
      if (this.wJe != 0) {
        paramb.aM(102, this.wJe);
      }
      if (!Arrays.equals(this.wGv, g.aUP)) {
        paramb.b(200, this.wGv);
      }
      if (this.wJf != null) {
        paramb.a(201, this.wJf);
      }
      if (this.wJg != -1) {
        paramb.aL(202, this.wJg);
      }
      if (!this.wJh.equals("")) {
        paramb.d(203, this.wJh);
      }
      if (this.platform != 0) {
        paramb.aL(204, this.platform);
      }
      if (this.wJi != 0) {
        paramb.aM(205, this.wJi);
      }
      if (this.qdI != 0) {
        paramb.aM(206, this.qdI);
      }
      if (this.wJj != 0) {
        paramb.aM(207, this.wJj);
      }
      if (this.wJk != 0) {
        paramb.aM(208, this.wJk);
      }
      if (this.wGq != 0) {
        paramb.aM(240, this.wGq);
      }
      super.a(paramb);
    }
    
    protected final int oQ()
    {
      int j = super.oQ();
      int i = j;
      if (this.sqW != 0) {
        i = j + b.aO(1, this.sqW);
      }
      j = i;
      if (this.wIQ != 0) {
        j = i + b.aO(2, this.wIQ);
      }
      i = j;
      if (this.status != 0) {
        i = j + b.aO(3, this.status);
      }
      j = i;
      if (this.aQw != 0) {
        j = i + b.aO(4, this.aQw);
      }
      i = j;
      if (this.iEo != -1) {
        i = j + b.aN(5, this.iEo);
      }
      j = i;
      if (this.wIR != 0) {
        j = i + b.aO(6, this.wIR);
      }
      i = j;
      if (this.wIS != null) {
        i = j + b.b(7, this.wIS);
      }
      j = i;
      if (this.wIT != 0) {
        j = i + b.aO(8, this.wIT);
      }
      i = j;
      if (!this.wIU.equals("")) {
        i = j + b.e(9, this.wIU);
      }
      j = i;
      int k;
      if (this.wIV != null)
      {
        j = i;
        if (this.wIV.length > 0)
        {
          j = 0;
          while (j < this.wIV.length)
          {
            a.ar localar = this.wIV[j];
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
      if (this.wIW != 0) {
        i = j + b.aO(11, this.wIW);
      }
      j = i;
      if (this.wIX != null)
      {
        j = i;
        if (this.wIX.length > 0)
        {
          j = 0;
          k = 0;
          while (j < this.wIX.length)
          {
            k += b.dS(this.wIX[j]);
            j += 1;
          }
          j = i + k + this.wIX.length * 1;
        }
      }
      i = j;
      if (this.wIY != 0) {
        i = j + b.aO(13, this.wIY);
      }
      j = i;
      if (this.wIZ != 0) {
        j = i + b.aO(14, this.wIZ);
      }
      i = j;
      if (this.wJa != 0) {
        i = j + b.aO(15, this.wJa);
      }
      j = i;
      if (this.wJb != 0) {
        j = i + b.aO(16, this.wJb);
      }
      i = j;
      if (this.wJc != null) {
        i = j + b.b(17, this.wJc);
      }
      j = i;
      if (!this.wHY.equals("")) {
        j = i + b.e(100, this.wHY);
      }
      i = j;
      if (!this.wJd.equals("")) {
        i = j + b.e(101, this.wJd);
      }
      j = i;
      if (this.wJe != 0) {
        j = i + b.aO(102, this.wJe);
      }
      i = j;
      if (!Arrays.equals(this.wGv, g.aUP)) {
        i = j + b.c(200, this.wGv);
      }
      j = i;
      if (this.wJf != null) {
        j = i + b.b(201, this.wJf);
      }
      i = j;
      if (this.wJg != -1) {
        i = j + b.aN(202, this.wJg);
      }
      j = i;
      if (!this.wJh.equals("")) {
        j = i + b.e(203, this.wJh);
      }
      i = j;
      if (this.platform != 0) {
        i = j + b.aN(204, this.platform);
      }
      j = i;
      if (this.wJi != 0) {
        j = i + b.aO(205, this.wJi);
      }
      i = j;
      if (this.qdI != 0) {
        i = j + b.aO(206, this.qdI);
      }
      j = i;
      if (this.wJj != 0) {
        j = i + b.aO(207, this.wJj);
      }
      i = j;
      if (this.wJk != 0) {
        i = j + b.aO(208, this.wJk);
      }
      j = i;
      if (this.wGq != 0) {
        j = i + b.aO(240, this.wGq);
      }
      return j;
    }
  }
  
  public static final class aw
    extends e
  {
    private static volatile aw[] wJl;
    public String nqW = "";
    public int sqW = 0;
    public String username = "";
    public long wJm = 0L;
    public String wJn = "";
    public String wJo = "";
    
    public aw()
    {
      this.aUI = -1;
    }
    
    public static aw[] cOg()
    {
      if (wJl == null) {}
      synchronized (c.aUH)
      {
        if (wJl == null) {
          wJl = new aw[0];
        }
        return wJl;
      }
    }
    
    public final void a(b paramb)
    {
      if (this.sqW != 0) {
        paramb.aM(1, this.sqW);
      }
      if (!this.username.equals("")) {
        paramb.d(2, this.username);
      }
      if (!this.nqW.equals("")) {
        paramb.d(3, this.nqW);
      }
      if (this.wJm != 0L) {
        paramb.h(4, this.wJm);
      }
      if (!this.wJn.equals("")) {
        paramb.d(5, this.wJn);
      }
      if (!this.wJo.equals("")) {
        paramb.d(6, this.wJo);
      }
      super.a(paramb);
    }
    
    protected final int oQ()
    {
      int j = super.oQ();
      int i = j;
      if (this.sqW != 0) {
        i = j + b.aO(1, this.sqW);
      }
      j = i;
      if (!this.username.equals("")) {
        j = i + b.e(2, this.username);
      }
      i = j;
      if (!this.nqW.equals("")) {
        i = j + b.e(3, this.nqW);
      }
      j = i;
      if (this.wJm != 0L) {
        j = i + b.j(4, this.wJm);
      }
      i = j;
      if (!this.wJn.equals("")) {
        i = j + b.e(5, this.wJn);
      }
      j = i;
      if (!this.wJo.equals("")) {
        j = i + b.e(6, this.wJo);
      }
      return j;
    }
  }
  
  public static final class ax
    extends e
  {
    public int wJp = 0;
    
    public ax()
    {
      this.aUI = -1;
    }
    
    public final void a(b paramb)
    {
      if (this.wJp != 0) {
        paramb.aM(1, this.wJp);
      }
      super.a(paramb);
    }
    
    protected final int oQ()
    {
      int j = super.oQ();
      int i = j;
      if (this.wJp != 0) {
        i = j + b.aO(1, this.wJp);
      }
      return i;
    }
  }
  
  public static final class f
    extends e
  {
    public int aQw = 0;
    public String groupId = "";
    public int pRI = 0;
    public long pRJ = 0L;
    public int wGu = 0;
    
    public f()
    {
      this.aUI = -1;
    }
    
    public final void a(b paramb)
    {
      if (!this.groupId.equals("")) {
        paramb.d(1, this.groupId);
      }
      if (this.pRI != 0) {
        paramb.aL(2, this.pRI);
      }
      if (this.pRJ != 0L) {
        paramb.i(3, this.pRJ);
      }
      if (this.aQw != 0) {
        paramb.aL(4, this.aQw);
      }
      if (this.wGu != 0) {
        paramb.aL(5, this.wGu);
      }
      super.a(paramb);
    }
    
    protected final int oQ()
    {
      int j = super.oQ();
      int i = j;
      if (!this.groupId.equals("")) {
        i = j + b.e(1, this.groupId);
      }
      j = i;
      if (this.pRI != 0) {
        j = i + b.aN(2, this.pRI);
      }
      i = j;
      if (this.pRJ != 0L) {
        i = j + b.k(3, this.pRJ);
      }
      j = i;
      if (this.aQw != 0) {
        j = i + b.aN(4, this.aQw);
      }
      i = j;
      if (this.wGu != 0) {
        i = j + b.aN(5, this.wGu);
      }
      return i;
    }
  }
  
  public static final class p
    extends e
  {
    public long bIt = 0L;
    public String groupId = "";
    public int pRI = 0;
    public long pRJ = 0L;
    public int wGJ = 0;
    public a.aw[] wGK = a.aw.cOg();
    public a.av[] wGL = a.av.cOf();
    public a.as wGM = null;
    public int wGN = 0;
    public int wGO = 0;
    public int wGP = 0;
    public byte[] wGQ = g.aUP;
    public byte[] wGR = g.aUP;
    public a.av[] wGS = a.av.cOf();
    public a.at wGh = null;
    public int wGk = 0;
    public a.ay wGm = null;
    
    public p()
    {
      this.aUI = -1;
    }
    
    public final void a(b paramb)
    {
      int j = 0;
      if (this.wGJ != 0) {
        paramb.aL(1, this.wGJ);
      }
      if (!this.groupId.equals("")) {
        paramb.d(2, this.groupId);
      }
      if (this.pRI != 0) {
        paramb.aL(3, this.pRI);
      }
      if (this.pRJ != 0L) {
        paramb.i(4, this.pRJ);
      }
      if (this.wGk != 0) {
        paramb.aM(5, this.wGk);
      }
      if (this.wGh != null) {
        paramb.a(6, this.wGh);
      }
      int i;
      Object localObject;
      if ((this.wGK != null) && (this.wGK.length > 0))
      {
        i = 0;
        while (i < this.wGK.length)
        {
          localObject = this.wGK[i];
          if (localObject != null) {
            paramb.a(7, (e)localObject);
          }
          i += 1;
        }
      }
      if ((this.wGL != null) && (this.wGL.length > 0))
      {
        i = 0;
        while (i < this.wGL.length)
        {
          localObject = this.wGL[i];
          if (localObject != null) {
            paramb.a(8, (e)localObject);
          }
          i += 1;
        }
      }
      if (this.wGM != null) {
        paramb.a(9, this.wGM);
      }
      if (this.wGm != null) {
        paramb.a(10, this.wGm);
      }
      if (this.wGN != 0) {
        paramb.aM(11, this.wGN);
      }
      if (this.wGO != 0) {
        paramb.aM(12, this.wGO);
      }
      if (this.bIt != 0L) {
        paramb.h(101, this.bIt);
      }
      if (this.wGP != 0) {
        paramb.aM(102, this.wGP);
      }
      if (!Arrays.equals(this.wGQ, g.aUP)) {
        paramb.b(103, this.wGQ);
      }
      if (!Arrays.equals(this.wGR, g.aUP)) {
        paramb.b(200, this.wGR);
      }
      if ((this.wGS != null) && (this.wGS.length > 0))
      {
        i = j;
        while (i < this.wGS.length)
        {
          localObject = this.wGS[i];
          if (localObject != null) {
            paramb.a(201, (e)localObject);
          }
          i += 1;
        }
      }
      super.a(paramb);
    }
    
    protected final int oQ()
    {
      int m = 0;
      int j = super.oQ();
      int i = j;
      if (this.wGJ != 0) {
        i = j + b.aN(1, this.wGJ);
      }
      j = i;
      if (!this.groupId.equals("")) {
        j = i + b.e(2, this.groupId);
      }
      i = j;
      if (this.pRI != 0) {
        i = j + b.aN(3, this.pRI);
      }
      j = i;
      if (this.pRJ != 0L) {
        j = i + b.k(4, this.pRJ);
      }
      int k = j;
      if (this.wGk != 0) {
        k = j + b.aO(5, this.wGk);
      }
      i = k;
      if (this.wGh != null) {
        i = k + b.b(6, this.wGh);
      }
      j = i;
      Object localObject;
      if (this.wGK != null)
      {
        j = i;
        if (this.wGK.length > 0)
        {
          j = 0;
          while (j < this.wGK.length)
          {
            localObject = this.wGK[j];
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
      if (this.wGL != null)
      {
        i = j;
        if (this.wGL.length > 0)
        {
          k = 0;
          i = j;
          j = k;
          while (j < this.wGL.length)
          {
            localObject = this.wGL[j];
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
      if (this.wGM != null) {
        j = i + b.b(9, this.wGM);
      }
      i = j;
      if (this.wGm != null) {
        i = j + b.b(10, this.wGm);
      }
      j = i;
      if (this.wGN != 0) {
        j = i + b.aO(11, this.wGN);
      }
      i = j;
      if (this.wGO != 0) {
        i = j + b.aO(12, this.wGO);
      }
      j = i;
      if (this.bIt != 0L) {
        j = i + b.j(101, this.bIt);
      }
      i = j;
      if (this.wGP != 0) {
        i = j + b.aO(102, this.wGP);
      }
      j = i;
      if (!Arrays.equals(this.wGQ, g.aUP)) {
        j = i + b.c(103, this.wGQ);
      }
      i = j;
      if (!Arrays.equals(this.wGR, g.aUP)) {
        i = j + b.c(200, this.wGR);
      }
      k = i;
      if (this.wGS != null)
      {
        k = i;
        if (this.wGS.length > 0)
        {
          j = m;
          for (;;)
          {
            k = i;
            if (j >= this.wGS.length) {
              break;
            }
            localObject = this.wGS[j];
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
    public int wGT = 0;
    
    public q()
    {
      this.aUI = -1;
    }
    
    public final void a(b paramb)
    {
      paramb.aM(1, this.wGT);
      super.a(paramb);
    }
    
    protected final int oQ()
    {
      return super.oQ() + b.aO(1, this.wGT);
    }
  }
  
  public static final class y
    extends e
  {
    public String wGf = "";
    
    public y()
    {
      this.aUI = -1;
    }
    
    public final void a(b paramb)
    {
      if (!this.wGf.equals("")) {
        paramb.d(1, this.wGf);
      }
      super.a(paramb);
    }
    
    protected final int oQ()
    {
      int j = super.oQ();
      int i = j;
      if (!this.wGf.equals("")) {
        i = j + b.e(1, this.wGf);
      }
      return i;
    }
  }
  
  public static final class z
    extends e
  {
    public String groupId = "";
    public int pRI = 0;
    public long pRJ = 0L;
    public int sPg = -1;
    public int wGF = 0;
    public a.av[] wGL = a.av.cOf();
    public a.as wGM = null;
    public int wGO = 0;
    public a.av[] wGS = a.av.cOf();
    public String wGf = "";
    public a.at wGh = null;
    public int wGk = 0;
    public a.o[] wHA = a.o.cNZ();
    public a.aw[] wHB = a.aw.cOg();
    public int wHC = 0;
    public int[] wHD = g.aUJ;
    public a.o[] wHE = a.o.cNZ();
    public int wHF = 0;
    public int wHG = 0;
    public a.o[] wHH = a.o.cNZ();
    public int wHI = 0;
    public int wHJ = 0;
    public int wHK = 0;
    public byte[] wHL = g.aUP;
    public int[] wHM = g.aUJ;
    
    public z()
    {
      this.aUI = -1;
    }
    
    public final void a(b paramb)
    {
      int j = 0;
      if (!this.groupId.equals("")) {
        paramb.d(1, this.groupId);
      }
      if (this.pRI != 0) {
        paramb.aL(2, this.pRI);
      }
      if (this.pRJ != 0L) {
        paramb.i(3, this.pRJ);
      }
      if (this.wGk != 0) {
        paramb.aM(4, this.wGk);
      }
      int i;
      Object localObject;
      if ((this.wHA != null) && (this.wHA.length > 0))
      {
        i = 0;
        while (i < this.wHA.length)
        {
          localObject = this.wHA[i];
          if (localObject != null) {
            paramb.a(5, (e)localObject);
          }
          i += 1;
        }
      }
      if ((this.wHB != null) && (this.wHB.length > 0))
      {
        i = 0;
        while (i < this.wHB.length)
        {
          localObject = this.wHB[i];
          if (localObject != null) {
            paramb.a(6, (e)localObject);
          }
          i += 1;
        }
      }
      if (this.wGM != null) {
        paramb.a(7, this.wGM);
      }
      if (!this.wGf.equals("")) {
        paramb.d(8, this.wGf);
      }
      if ((this.wGL != null) && (this.wGL.length > 0))
      {
        i = 0;
        while (i < this.wGL.length)
        {
          localObject = this.wGL[i];
          if (localObject != null) {
            paramb.a(9, (e)localObject);
          }
          i += 1;
        }
      }
      if (this.wHC != 0) {
        paramb.aL(10, this.wHC);
      }
      if ((this.wHD != null) && (this.wHD.length > 0))
      {
        i = 0;
        while (i < this.wHD.length)
        {
          paramb.aL(11, this.wHD[i]);
          i += 1;
        }
      }
      if (this.wGh != null) {
        paramb.a(12, this.wGh);
      }
      if (this.wGF != 0) {
        paramb.aM(13, this.wGF);
      }
      if ((this.wHE != null) && (this.wHE.length > 0))
      {
        i = 0;
        while (i < this.wHE.length)
        {
          localObject = this.wHE[i];
          if (localObject != null) {
            paramb.a(14, (e)localObject);
          }
          i += 1;
        }
      }
      if (this.wHF != 0) {
        paramb.aM(15, this.wHF);
      }
      if (this.wHG != 0) {
        paramb.aM(16, this.wHG);
      }
      if ((this.wGS != null) && (this.wGS.length > 0))
      {
        i = 0;
        while (i < this.wGS.length)
        {
          localObject = this.wGS[i];
          if (localObject != null) {
            paramb.a(17, (e)localObject);
          }
          i += 1;
        }
      }
      if ((this.wHH != null) && (this.wHH.length > 0))
      {
        i = 0;
        while (i < this.wHH.length)
        {
          localObject = this.wHH[i];
          if (localObject != null) {
            paramb.a(18, (e)localObject);
          }
          i += 1;
        }
      }
      if (this.wHI != 0) {
        paramb.aL(19, this.wHI);
      }
      if (this.wHJ != 0) {
        paramb.aL(20, this.wHJ);
      }
      if (this.wHK != 0) {
        paramb.aL(21, this.wHK);
      }
      if (!Arrays.equals(this.wHL, g.aUP)) {
        paramb.b(22, this.wHL);
      }
      if (this.sPg != -1) {
        paramb.aL(23, this.sPg);
      }
      if ((this.wHM != null) && (this.wHM.length > 0))
      {
        i = j;
        while (i < this.wHM.length)
        {
          paramb.aM(24, this.wHM[i]);
          i += 1;
        }
      }
      if (this.wGO != 0) {
        paramb.aM(25, this.wGO);
      }
      super.a(paramb);
    }
    
    protected final int oQ()
    {
      int j = super.oQ();
      int i = j;
      if (!this.groupId.equals("")) {
        i = j + b.e(1, this.groupId);
      }
      j = i;
      if (this.pRI != 0) {
        j = i + b.aN(2, this.pRI);
      }
      int k = j;
      if (this.pRJ != 0L) {
        k = j + b.k(3, this.pRJ);
      }
      i = k;
      if (this.wGk != 0) {
        i = k + b.aO(4, this.wGk);
      }
      j = i;
      Object localObject;
      if (this.wHA != null)
      {
        j = i;
        if (this.wHA.length > 0)
        {
          j = 0;
          while (j < this.wHA.length)
          {
            localObject = this.wHA[j];
            k = i;
            if (localObject != null) {
              k = i + b.b(5, (e)localObject);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (this.wHB != null)
      {
        i = j;
        if (this.wHB.length > 0)
        {
          k = 0;
          i = j;
          j = k;
          while (j < this.wHB.length)
          {
            localObject = this.wHB[j];
            k = i;
            if (localObject != null) {
              k = i + b.b(6, (e)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      j = i;
      if (this.wGM != null) {
        j = i + b.b(7, this.wGM);
      }
      i = j;
      if (!this.wGf.equals("")) {
        i = j + b.e(8, this.wGf);
      }
      j = i;
      if (this.wGL != null)
      {
        j = i;
        if (this.wGL.length > 0)
        {
          j = 0;
          while (j < this.wGL.length)
          {
            localObject = this.wGL[j];
            k = i;
            if (localObject != null) {
              k = i + b.b(9, (e)localObject);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (this.wHC != 0) {
        i = j + b.aN(10, this.wHC);
      }
      j = i;
      if (this.wHD != null)
      {
        j = i;
        if (this.wHD.length > 0)
        {
          j = 0;
          k = 0;
          while (j < this.wHD.length)
          {
            k += b.dO(this.wHD[j]);
            j += 1;
          }
          j = i + k + this.wHD.length * 1;
        }
      }
      k = j;
      if (this.wGh != null) {
        k = j + b.b(12, this.wGh);
      }
      i = k;
      if (this.wGF != 0) {
        i = k + b.aO(13, this.wGF);
      }
      j = i;
      if (this.wHE != null)
      {
        j = i;
        if (this.wHE.length > 0)
        {
          j = 0;
          while (j < this.wHE.length)
          {
            localObject = this.wHE[j];
            k = i;
            if (localObject != null) {
              k = i + b.b(14, (e)localObject);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      k = j;
      if (this.wHF != 0) {
        k = j + b.aO(15, this.wHF);
      }
      i = k;
      if (this.wHG != 0) {
        i = k + b.aO(16, this.wHG);
      }
      j = i;
      if (this.wGS != null)
      {
        j = i;
        if (this.wGS.length > 0)
        {
          j = 0;
          while (j < this.wGS.length)
          {
            localObject = this.wGS[j];
            k = i;
            if (localObject != null) {
              k = i + b.b(17, (e)localObject);
            }
            j += 1;
            i = k;
          }
          j = i;
        }
      }
      i = j;
      if (this.wHH != null)
      {
        i = j;
        if (this.wHH.length > 0)
        {
          k = 0;
          i = j;
          j = k;
          while (j < this.wHH.length)
          {
            localObject = this.wHH[j];
            k = i;
            if (localObject != null) {
              k = i + b.b(18, (e)localObject);
            }
            j += 1;
            i = k;
          }
        }
      }
      j = i;
      if (this.wHI != 0) {
        j = i + b.aN(19, this.wHI);
      }
      i = j;
      if (this.wHJ != 0) {
        i = j + b.aN(20, this.wHJ);
      }
      j = i;
      if (this.wHK != 0) {
        j = i + b.aN(21, this.wHK);
      }
      k = j;
      if (!Arrays.equals(this.wHL, g.aUP)) {
        k = j + b.c(22, this.wHL);
      }
      i = k;
      if (this.sPg != -1) {
        i = k + b.aN(23, this.sPg);
      }
      j = i;
      if (this.wHM != null)
      {
        j = i;
        if (this.wHM.length > 0)
        {
          j = 0;
          k = 0;
          while (j < this.wHM.length)
          {
            k += b.dS(this.wHM[j]);
            j += 1;
          }
          j = i + k + this.wHM.length * 2;
        }
      }
      i = j;
      if (this.wGO != 0) {
        i = j + b.aO(25, this.wGO);
      }
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.pb.common.b.a.a
 * JD-Core Version:    0.7.0.1
 */