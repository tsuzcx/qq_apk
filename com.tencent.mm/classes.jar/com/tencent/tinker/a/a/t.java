package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.a.a;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class t
{
  public int eKZ;
  public int fileSize;
  public byte[] lMU = new byte[20];
  public final t.a wSW = new t.a(0, true);
  public final t.a wSX = new t.a(1, true);
  public final t.a wSY = new t.a(2, true);
  public final t.a wSZ = new t.a(3, true);
  public final t.a wTa = new t.a(4, true);
  public final t.a wTb = new t.a(5, true);
  public final t.a wTc = new t.a(6, true);
  public final t.a wTd = new t.a(4096, true);
  public final t.a wTe = new t.a(4097, true);
  public final t.a wTf = new t.a(4098, true);
  public final t.a wTg = new t.a(4099, true);
  public final t.a wTh = new t.a(8192, false);
  public final t.a wTi = new t.a(8193, true);
  public final t.a wTj = new t.a(8194, false);
  public final t.a wTk = new t.a(8195, false);
  public final t.a wTl = new t.a(8196, false);
  public final t.a wTm = new t.a(8197, false);
  public final t.a wTn = new t.a(8198, true);
  public final t.a[] wTo = { this.wSW, this.wSX, this.wSY, this.wSZ, this.wTa, this.wTb, this.wTc, this.wTd, this.wTe, this.wTf, this.wTg, this.wTh, this.wTi, this.wTj, this.wTk, this.wTl, this.wTm, this.wTn };
  public int wTp;
  public int wTq;
  public int wTr;
  public int wTs;
  
  final void a(i.e parame)
  {
    int k = parame.ayD.getInt();
    int i = 0;
    t.a locala;
    for (Object localObject = null; i < k; localObject = locala)
    {
      int m = parame.ayD.getShort();
      parame.ayD.getShort();
      t.a[] arrayOfa = this.wTo;
      int n = arrayOfa.length;
      int j = 0;
      while (j < n)
      {
        locala = arrayOfa[j];
        if (locala.wTt == m)
        {
          j = parame.ayD.getInt();
          n = parame.ayD.getInt();
          if (((locala.size == 0) || (locala.size == j)) && ((locala.off == -1) || (locala.off == n))) {
            break label185;
          }
          throw new j("Unexpected map value for 0x" + Integer.toHexString(m));
        }
        j += 1;
      }
      throw new IllegalArgumentException("No such map item: " + m);
      label185:
      locala.size = j;
      locala.off = n;
      if ((localObject != null) && (localObject.off > locala.off)) {
        throw new j("Map is unsorted at " + localObject + ", " + locala);
      }
      i += 1;
    }
    this.wSW.off = 0;
    Arrays.sort(this.wTo);
    i = 1;
    while (i < this.wTo.length)
    {
      if (this.wTo[i].off == -1) {
        this.wTo[i].off = this.wTo[(i - 1)].off;
      }
      i += 1;
    }
  }
  
  public final void b(i.e parame)
  {
    t.a[] arrayOfa = this.wTo;
    int m = arrayOfa.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (arrayOfa[i].exists()) {
        k = j + 1;
      }
      i += 1;
    }
    parame.writeInt(j);
    arrayOfa = this.wTo;
    j = arrayOfa.length;
    i = 0;
    while (i < j)
    {
      t.a locala = arrayOfa[i];
      if (locala.exists())
      {
        parame.writeShort(locala.wTt);
        parame.writeShort((short)0);
        parame.writeInt(locala.size);
        parame.writeInt(locala.off);
      }
      i += 1;
    }
  }
  
  public final void cQx()
  {
    int j = this.fileSize;
    int i = this.wTo.length - 1;
    while (i >= 0)
    {
      t.a locala = this.wTo[i];
      int k = j;
      if (locala.off != -1)
      {
        if (locala.off > j) {
          throw new j("Map is unsorted at " + locala);
        }
        locala.wTv = (j - locala.off);
        k = locala.off;
      }
      i -= 1;
      j = k;
    }
    this.wTs = (this.wSW.wTv + this.wSX.wTv + this.wSY.wTv + this.wSZ.wTv + this.wTa.wTv + this.wTb.wTv + this.wTc.wTv);
    this.wTr = (this.fileSize - this.wTs);
  }
  
  public static abstract class a$a<T>
    implements Comparable<T>
  {
    public int off;
    
    public a$a(int paramInt)
    {
      this.off = paramInt;
    }
    
    public boolean equals(Object paramObject)
    {
      return compareTo(paramObject) == 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tinker.a.a.t
 * JD-Core Version:    0.7.0.1
 */