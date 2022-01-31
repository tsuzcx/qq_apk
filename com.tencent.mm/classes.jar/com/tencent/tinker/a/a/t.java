package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.a.a;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class t
{
  public final t.a BpD = new t.a(0, true);
  public final t.a BpE = new t.a(1, true);
  public final t.a BpF = new t.a(2, true);
  public final t.a BpG = new t.a(3, true);
  public final t.a BpH = new t.a(4, true);
  public final t.a BpI = new t.a(5, true);
  public final t.a BpJ = new t.a(6, true);
  public final t.a BpK = new t.a(4096, true);
  public final t.a BpL = new t.a(4097, true);
  public final t.a BpM = new t.a(4098, true);
  public final t.a BpN = new t.a(4099, true);
  public final t.a BpO = new t.a(8192, false);
  public final t.a BpP = new t.a(8193, true);
  public final t.a BpQ = new t.a(8194, false);
  public final t.a BpR = new t.a(8195, false);
  public final t.a BpS = new t.a(8196, false);
  public final t.a BpT = new t.a(8197, false);
  public final t.a BpU = new t.a(8198, true);
  public final t.a[] BpV = { this.BpD, this.BpE, this.BpF, this.BpG, this.BpH, this.BpI, this.BpJ, this.BpK, this.BpL, this.BpM, this.BpN, this.BpO, this.BpP, this.BpQ, this.BpR, this.BpS, this.BpT, this.BpU };
  public int BpW;
  public int BpX;
  public int BpY;
  public int fileSize;
  public int gaG;
  public int lsT;
  public byte[] okn = new byte[20];
  
  final void a(i.e parame)
  {
    int k = parame.aAS.getInt();
    int i = 0;
    t.a locala;
    for (Object localObject = null; i < k; localObject = locala)
    {
      int m = parame.aAS.getShort();
      parame.aAS.getShort();
      t.a[] arrayOfa = this.BpV;
      int n = arrayOfa.length;
      int j = 0;
      while (j < n)
      {
        locala = arrayOfa[j];
        if (locala.BpZ == m)
        {
          j = parame.aAS.getInt();
          n = parame.aAS.getInt();
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
    this.BpD.off = 0;
    Arrays.sort(this.BpV);
    i = 1;
    while (i < this.BpV.length)
    {
      if (this.BpV[i].off == -1) {
        this.BpV[i].off = this.BpV[(i - 1)].off;
      }
      i += 1;
    }
  }
  
  public final void b(i.e parame)
  {
    t.a[] arrayOfa = this.BpV;
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
    arrayOfa = this.BpV;
    j = arrayOfa.length;
    i = 0;
    while (i < j)
    {
      t.a locala = arrayOfa[i];
      if (locala.exists())
      {
        parame.writeShort(locala.BpZ);
        parame.writeShort((short)0);
        parame.writeInt(locala.size);
        parame.writeInt(locala.off);
      }
      i += 1;
    }
  }
  
  public final void dWl()
  {
    int j = this.fileSize;
    int i = this.BpV.length - 1;
    while (i >= 0)
    {
      t.a locala = this.BpV[i];
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
    this.BpY = (this.BpD.byteCount + this.BpE.byteCount + this.BpF.byteCount + this.BpG.byteCount + this.BpH.byteCount + this.BpI.byteCount + this.BpJ.byteCount);
    this.lsT = (this.fileSize - this.BpY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tinker.a.a.t
 * JD-Core Version:    0.7.0.1
 */