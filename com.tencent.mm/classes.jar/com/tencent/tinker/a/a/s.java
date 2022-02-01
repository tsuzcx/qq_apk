package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.a.a;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class s
{
  public byte[] Evq = new byte[20];
  public final s.a ZJA = new s.a(8192, false);
  public final s.a ZJB = new s.a(8193, true);
  public final s.a ZJC = new s.a(8194, false);
  public final s.a ZJD = new s.a(8195, false);
  public final s.a ZJE = new s.a(8196, false);
  public final s.a ZJF = new s.a(8197, false);
  public final s.a ZJG = new s.a(8198, true);
  public final s.a[] ZJH = { this.ZJp, this.ZJq, this.ZJr, this.ZJs, this.ZJt, this.ZJu, this.ZJv, this.ZJw, this.ZJx, this.ZJy, this.ZJz, this.ZJA, this.ZJB, this.ZJC, this.ZJD, this.ZJE, this.ZJF, this.ZJG };
  public int ZJI;
  public int ZJJ;
  public int ZJK;
  public final s.a ZJp = new s.a(0, true);
  public final s.a ZJq = new s.a(1, true);
  public final s.a ZJr = new s.a(2, true);
  public final s.a ZJs = new s.a(3, true);
  public final s.a ZJt = new s.a(4, true);
  public final s.a ZJu = new s.a(5, true);
  public final s.a ZJv = new s.a(6, true);
  public final s.a ZJw = new s.a(4096, true);
  public final s.a ZJx = new s.a(4097, true);
  public final s.a ZJy = new s.a(4098, true);
  public final s.a ZJz = new s.a(4099, true);
  public int dataSize;
  public int fileSize;
  public int mkZ;
  
  final void a(i.e parame)
  {
    int k = parame.aQU.getInt();
    int i = 0;
    s.a locala;
    for (Object localObject = null; i < k; localObject = locala)
    {
      int m = parame.aQU.getShort();
      parame.aQU.getShort();
      s.a[] arrayOfa = this.ZJH;
      int n = arrayOfa.length;
      int j = 0;
      while (j < n)
      {
        locala = arrayOfa[j];
        if (locala.ZJL == m)
        {
          j = parame.aQU.getInt();
          n = parame.aQU.getInt();
          if (((locala.size == 0) || (locala.size == j)) && ((locala.off == -1) || (locala.off == n))) {
            break label178;
          }
          throw new j("Unexpected map value for 0x" + Integer.toHexString(m));
        }
        j += 1;
      }
      throw new IllegalArgumentException("No such map item: ".concat(String.valueOf(m)));
      label178:
      locala.size = j;
      locala.off = n;
      if ((localObject != null) && (localObject.off > locala.off)) {
        throw new j("Map is unsorted at " + localObject + ", " + locala);
      }
      i += 1;
    }
    this.ZJp.off = 0;
    Arrays.sort(this.ZJH);
    i = 1;
    while (i < this.ZJH.length)
    {
      if (this.ZJH[i].off == -1) {
        this.ZJH[i].off = this.ZJH[(i - 1)].off;
      }
      i += 1;
    }
  }
  
  public final void b(i.e parame)
  {
    s.a[] arrayOfa = this.ZJH;
    int m = arrayOfa.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (arrayOfa[i].ifE()) {
        k = j + 1;
      }
      i += 1;
    }
    parame.bV(j);
    arrayOfa = this.ZJH;
    j = arrayOfa.length;
    i = 0;
    while (i < j)
    {
      s.a locala = arrayOfa[i];
      if (locala.ifE())
      {
        parame.a(locala.ZJL);
        parame.a((short)0);
        parame.bV(locala.size);
        parame.bV(locala.off);
      }
      i += 1;
    }
  }
  
  public final void iss()
  {
    int j = this.fileSize;
    int i = this.ZJH.length - 1;
    while (i >= 0)
    {
      s.a locala = this.ZJH[i];
      int k = j;
      if (locala.off != -1)
      {
        if (locala.off > j) {
          throw new j("Map is unsorted at ".concat(String.valueOf(locala)));
        }
        locala.byteCount = (j - locala.off);
        k = locala.off;
      }
      i -= 1;
      j = k;
    }
    this.ZJK = (this.ZJp.byteCount + this.ZJq.byteCount + this.ZJr.byteCount + this.ZJs.byteCount + this.ZJt.byteCount + this.ZJu.byteCount + this.ZJv.byteCount);
    this.dataSize = (this.fileSize - this.ZJK);
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
    
    public int hashCode()
    {
      return super.hashCode();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.tinker.a.a.s
 * JD-Core Version:    0.7.0.1
 */