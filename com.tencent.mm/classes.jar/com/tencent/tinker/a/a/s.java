package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.a.a;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class s
{
  public byte[] KnY = new byte[20];
  public final s.a ahOA = new s.a(4099, true);
  public final s.a ahOB = new s.a(8192, false);
  public final s.a ahOC = new s.a(8193, true);
  public final s.a ahOD = new s.a(8194, false);
  public final s.a ahOE = new s.a(8195, false);
  public final s.a ahOF = new s.a(8196, false);
  public final s.a ahOG = new s.a(8197, false);
  public final s.a ahOH = new s.a(8198, true);
  public final s.a[] ahOI = { this.ahOq, this.ahOr, this.ahOs, this.ahOt, this.ahOu, this.ahOv, this.ahOw, this.ahOx, this.ahOy, this.ahOz, this.ahOA, this.ahOB, this.ahOC, this.ahOD, this.ahOE, this.ahOF, this.ahOG, this.ahOH };
  public int ahOJ;
  public int ahOK;
  public int ahOL;
  public final s.a ahOq = new s.a(0, true);
  public final s.a ahOr = new s.a(1, true);
  public final s.a ahOs = new s.a(2, true);
  public final s.a ahOt = new s.a(3, true);
  public final s.a ahOu = new s.a(4, true);
  public final s.a ahOv = new s.a(5, true);
  public final s.a ahOw = new s.a(6, true);
  public final s.a ahOx = new s.a(4096, true);
  public final s.a ahOy = new s.a(4097, true);
  public final s.a ahOz = new s.a(4098, true);
  public int dataSize;
  public int fileSize;
  public int peK;
  
  final void a(i.e parame)
  {
    int k = parame.cKQ.getInt();
    int i = 0;
    s.a locala;
    for (Object localObject = null; i < k; localObject = locala)
    {
      int m = parame.cKQ.getShort();
      parame.cKQ.getShort();
      s.a[] arrayOfa = this.ahOI;
      int n = arrayOfa.length;
      int j = 0;
      while (j < n)
      {
        locala = arrayOfa[j];
        if (locala.ahOM == m)
        {
          j = parame.cKQ.getInt();
          n = parame.cKQ.getInt();
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
    this.ahOq.off = 0;
    Arrays.sort(this.ahOI);
    i = 1;
    while (i < this.ahOI.length)
    {
      if (this.ahOI[i].off == -1) {
        this.ahOI[i].off = this.ahOI[(i - 1)].off;
      }
      i += 1;
    }
  }
  
  public final void b(i.e parame)
  {
    s.a[] arrayOfa = this.ahOI;
    int m = arrayOfa.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (arrayOfa[i].jKS()) {
        k = j + 1;
      }
      i += 1;
    }
    parame.aX(j);
    arrayOfa = this.ahOI;
    j = arrayOfa.length;
    i = 0;
    while (i < j)
    {
      s.a locala = arrayOfa[i];
      if (locala.jKS())
      {
        parame.b(locala.ahOM);
        parame.b((short)0);
        parame.aX(locala.size);
        parame.aX(locala.off);
      }
      i += 1;
    }
  }
  
  public final void kbS()
  {
    int j = this.fileSize;
    int i = this.ahOI.length - 1;
    while (i >= 0)
    {
      s.a locala = this.ahOI[i];
      int k = j;
      if (locala.off != -1)
      {
        if (locala.off > j) {
          throw new j("Map is unsorted at ".concat(String.valueOf(locala)));
        }
        locala.ahOO = (j - locala.off);
        k = locala.off;
      }
      i -= 1;
      j = k;
    }
    this.ahOL = (this.ahOq.ahOO + this.ahOr.ahOO + this.ahOs.ahOO + this.ahOt.ahOO + this.ahOu.ahOO + this.ahOv.ahOO + this.ahOw.ahOO);
    this.dataSize = (this.fileSize - this.ahOL);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.tinker.a.a.s
 * JD-Core Version:    0.7.0.1
 */