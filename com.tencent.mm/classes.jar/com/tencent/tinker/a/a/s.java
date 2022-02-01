package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.a.a;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class s
{
  public final a MdF = new a(0, true);
  public final a MdG = new a(1, true);
  public final a MdH = new a(2, true);
  public final a MdI = new a(3, true);
  public final a MdJ = new a(4, true);
  public final a MdK = new a(5, true);
  public final a MdL = new a(6, true);
  public final a MdM = new a(4096, true);
  public final a MdN = new a(4097, true);
  public final a MdO = new a(4098, true);
  public final a MdP = new a(4099, true);
  public final a MdQ = new a(8192, false);
  public final a MdR = new a(8193, true);
  public final a MdS = new a(8194, false);
  public final a MdT = new a(8195, false);
  public final a MdU = new a(8196, false);
  public final a MdV = new a(8197, false);
  public final a MdW = new a(8198, true);
  public final a[] MdX = { this.MdF, this.MdG, this.MdH, this.MdI, this.MdJ, this.MdK, this.MdL, this.MdM, this.MdN, this.MdO, this.MdP, this.MdQ, this.MdR, this.MdS, this.MdT, this.MdU, this.MdV, this.MdW };
  public int MdY;
  public int MdZ;
  public int Mea;
  public int dataSize;
  public int fileSize;
  public int ixp;
  public byte[] vkY = new byte[20];
  
  final void a(i.e parame)
  {
    int k = parame.aKX.getInt();
    int i = 0;
    a locala;
    for (Object localObject = null; i < k; localObject = locala)
    {
      int m = parame.aKX.getShort();
      parame.aKX.getShort();
      a[] arrayOfa = this.MdX;
      int n = arrayOfa.length;
      int j = 0;
      while (j < n)
      {
        locala = arrayOfa[j];
        if (locala.Meb == m)
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
    this.MdF.off = 0;
    Arrays.sort(this.MdX);
    i = 1;
    while (i < this.MdX.length)
    {
      if (this.MdX[i].off == -1) {
        this.MdX[i].off = this.MdX[(i - 1)].off;
      }
      i += 1;
    }
  }
  
  public final void b(i.e parame)
  {
    a[] arrayOfa = this.MdX;
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
    arrayOfa = this.MdX;
    j = arrayOfa.length;
    i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (locala.exists())
      {
        parame.writeShort(locala.Meb);
        parame.writeShort((short)0);
        parame.writeInt(locala.size);
        parame.writeInt(locala.off);
      }
      i += 1;
    }
  }
  
  public final void fYk()
  {
    int j = this.fileSize;
    int i = this.MdX.length - 1;
    while (i >= 0)
    {
      a locala = this.MdX[i];
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
    this.Mea = (this.MdF.byteCount + this.MdG.byteCount + this.MdH.byteCount + this.MdI.byteCount + this.MdJ.byteCount + this.MdK.byteCount + this.MdL.byteCount);
    this.dataSize = (this.fileSize - this.Mea);
  }
  
  public static final class a
    implements Comparable<a>
  {
    public final short Meb;
    public boolean Mec;
    public int byteCount = 0;
    public int off = -1;
    public int size = 0;
    
    public a(int paramInt, boolean paramBoolean)
    {
      this.Meb = ((short)paramInt);
      this.Mec = paramBoolean;
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
    
    private static int ahB(int paramInt)
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
      return String.format("Section[type=%#x,off=%#x,size=%#x]", new Object[] { Short.valueOf(this.Meb), Integer.valueOf(this.off), Integer.valueOf(this.size) });
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