package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.a.a;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class s
{
  public final a MAA = new a(0, true);
  public final a MAB = new a(1, true);
  public final a MAC = new a(2, true);
  public final a MAD = new a(3, true);
  public final a MAE = new a(4, true);
  public final a MAF = new a(5, true);
  public final a MAG = new a(6, true);
  public final a MAH = new a(4096, true);
  public final a MAI = new a(4097, true);
  public final a MAJ = new a(4098, true);
  public final a MAK = new a(4099, true);
  public final a MAL = new a(8192, false);
  public final a MAM = new a(8193, true);
  public final a MAN = new a(8194, false);
  public final a MAO = new a(8195, false);
  public final a MAQ = new a(8196, false);
  public final a MAR = new a(8197, false);
  public final a MAS = new a(8198, true);
  public final a[] MAT = { this.MAA, this.MAB, this.MAC, this.MAD, this.MAE, this.MAF, this.MAG, this.MAH, this.MAI, this.MAJ, this.MAK, this.MAL, this.MAM, this.MAN, this.MAO, this.MAQ, this.MAR, this.MAS };
  public int MAU;
  public int MAV;
  public int MAW;
  public int dataSize;
  public int fileSize;
  public int iAi;
  public byte[] vxd = new byte[20];
  
  final void a(i.e parame)
  {
    int k = parame.aKX.getInt();
    int i = 0;
    a locala;
    for (Object localObject = null; i < k; localObject = locala)
    {
      int m = parame.aKX.getShort();
      parame.aKX.getShort();
      a[] arrayOfa = this.MAT;
      int n = arrayOfa.length;
      int j = 0;
      while (j < n)
      {
        locala = arrayOfa[j];
        if (locala.MAY == m)
        {
          j = parame.aKX.getInt();
          n = parame.aKX.getInt();
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
    this.MAA.off = 0;
    Arrays.sort(this.MAT);
    i = 1;
    while (i < this.MAT.length)
    {
      if (this.MAT[i].off == -1) {
        this.MAT[i].off = this.MAT[(i - 1)].off;
      }
      i += 1;
    }
  }
  
  public final void b(i.e parame)
  {
    a[] arrayOfa = this.MAT;
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
    arrayOfa = this.MAT;
    j = arrayOfa.length;
    i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (locala.exists())
      {
        parame.writeShort(locala.MAY);
        parame.writeShort((short)0);
        parame.writeInt(locala.size);
        parame.writeInt(locala.off);
      }
      i += 1;
    }
  }
  
  public final void gcJ()
  {
    int j = this.fileSize;
    int i = this.MAT.length - 1;
    while (i >= 0)
    {
      a locala = this.MAT[i];
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
    this.MAW = (this.MAA.byteCount + this.MAB.byteCount + this.MAC.byteCount + this.MAD.byteCount + this.MAE.byteCount + this.MAF.byteCount + this.MAG.byteCount);
    this.dataSize = (this.fileSize - this.MAW);
  }
  
  public static final class a
    implements Comparable<a>
  {
    public final short MAY;
    public boolean MAZ;
    public int byteCount = 0;
    public int off = -1;
    public int size = 0;
    
    public a(int paramInt, boolean paramBoolean)
    {
      this.MAY = ((short)paramInt);
      this.MAZ = paramBoolean;
      if (paramInt == 0)
      {
        this.off = 0;
        this.size = 1;
        this.byteCount = 112;
      }
      while (paramInt != 4096) {
        return;
      }
      this.size = 1;
    }
    
    private static int aik(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("unknown section type: ".concat(String.valueOf(paramInt)));
      case 0: 
        return 0;
      case 1: 
        return 1;
      case 2: 
        return 2;
      case 3: 
        return 3;
      case 4: 
        return 4;
      case 5: 
        return 5;
      case 6: 
        return 6;
      case 8194: 
        return 7;
      case 4097: 
        return 8;
      case 8196: 
        return 9;
      case 4099: 
        return 10;
      case 4098: 
        return 11;
      case 8198: 
        return 12;
      case 8195: 
        return 13;
      case 8193: 
        return 14;
      case 8192: 
        return 15;
      case 8197: 
        return 16;
      }
      return 17;
    }
    
    public final boolean exists()
    {
      return this.size > 0;
    }
    
    public final String toString()
    {
      return String.format("Section[type=%#x,off=%#x,size=%#x]", new Object[] { Short.valueOf(this.MAY), Integer.valueOf(this.off), Integer.valueOf(this.size) });
    }
    
    public static abstract class a<T>
      implements Comparable<T>
    {
      public int off;
      
      public a(int paramInt)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.tinker.a.a.s
 * JD-Core Version:    0.7.0.1
 */