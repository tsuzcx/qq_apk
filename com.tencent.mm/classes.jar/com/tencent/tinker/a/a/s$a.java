package com.tencent.tinker.a.a;

public final class s$a
  implements Comparable<a>
{
  public final short ahOM;
  public boolean ahON;
  public int ahOO = 0;
  public int off = -1;
  public int size = 0;
  
  public s$a(int paramInt, boolean paramBoolean)
  {
    this.ahOM = ((short)paramInt);
    this.ahON = paramBoolean;
    if (paramInt == 0)
    {
      this.off = 0;
      this.size = 1;
      this.ahOO = 112;
    }
    while (paramInt != 4096) {
      return;
    }
    this.size = 1;
  }
  
  private static int aIk(int paramInt)
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
  
  public final boolean jKS()
  {
    return this.size > 0;
  }
  
  public final String toString()
  {
    return String.format("Section[type=%#x,off=%#x,size=%#x]", new Object[] { Short.valueOf(this.ahOM), Integer.valueOf(this.off), Integer.valueOf(this.size) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tinker.a.a.s.a
 * JD-Core Version:    0.7.0.1
 */