package com.tencent.tinker.a.a;

public final class t$a
  implements Comparable<a>
{
  public final short BpZ;
  public boolean Bqa;
  public int byteCount = 0;
  public int off = -1;
  public int size = 0;
  
  public t$a(int paramInt, boolean paramBoolean)
  {
    this.BpZ = ((short)paramInt);
    this.Bqa = paramBoolean;
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
  
  private static int Su(int paramInt)
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
    return String.format("Section[type=%#x,off=%#x,size=%#x]", new Object[] { Short.valueOf(this.BpZ), Integer.valueOf(this.off), Integer.valueOf(this.size) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tinker.a.a.t.a
 * JD-Core Version:    0.7.0.1
 */