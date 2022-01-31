package com.tencent.mm.plugin.radar.b;

import a.d.b.g;
import com.tencent.mm.protocal.c.bio;

public final class e$c
{
  public final bio nlt;
  public final c.e nlu;
  
  public e$c(bio parambio, c.e parame)
  {
    this.nlt = parambio;
    this.nlu = parame;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((!g.e(this.nlt, paramObject.nlt)) || (!g.e(this.nlu, paramObject.nlu))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    Object localObject = this.nlt;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.nlu;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    return "LatestChangeStat(member=" + this.nlt + ", state=" + this.nlu + ")";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.e.c
 * JD-Core Version:    0.7.0.1
 */