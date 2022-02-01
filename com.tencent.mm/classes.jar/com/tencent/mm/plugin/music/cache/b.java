package com.tencent.mm.plugin.music.cache;

public abstract interface b
{
  public static final Long LKA = Long.valueOf(60000L);
  public static final Long LKz;
  public static final Long hrF = Long.valueOf(2592000000L);
  public static final Long hrG = Long.valueOf(604800000L);
  public static final Long hrJ = Long.valueOf(86400000L);
  public static final Long hrK = Long.valueOf(43200000L);
  public static final Long hrL = Long.valueOf(240000L);
  
  static
  {
    LKz = hrJ;
  }
  
  public abstract void gmQ();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.cache.b
 * JD-Core Version:    0.7.0.1
 */