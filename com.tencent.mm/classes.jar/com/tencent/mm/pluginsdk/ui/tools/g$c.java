package com.tencent.mm.pluginsdk.ui.tools;

import java.util.HashMap;

abstract class g$c<K, V>
{
  private HashMap<K, c<K, V>.a> nVp;
  private int smA;
  private final int sms;
  private c<K, V>.a smy;
  private c<K, V>.a smz;
  
  public g$c(g paramg, int paramInt)
  {
    this.sms = Math.max(1, paramInt);
    this.nVp = new HashMap();
    this.smy = new g.c.a(this);
    this.smz = new g.c.a(this);
    this.smy.smC = this.smz;
    this.smz.smB = this.smy;
    this.smA = 0;
  }
  
  private void a(c<K, V>.a paramc)
  {
    paramc.smC = this.smy.smC;
    paramc.smC.smB = paramc;
    this.smy.smC = paramc;
    paramc.smB = this.smy;
  }
  
  private static void b(c<K, V>.a paramc)
  {
    paramc.smB.smC = paramc.smC;
    paramc.smC.smB = paramc.smB;
    paramc.smC = null;
    paramc.smB = null;
  }
  
  protected abstract void bN(V paramV);
  
  public final void clear()
  {
    while (this.smA > 0)
    {
      g.c.a locala = this.smz.smB;
      b(locala);
      this.nVp.remove(locala.smD);
      bN(locala.value);
      this.smA -= 1;
    }
  }
  
  public final V get(K paramK)
  {
    try
    {
      paramK = (g.c.a)this.nVp.get(paramK);
      if (paramK != null)
      {
        b(paramK);
        a(paramK);
        paramK = paramK.value;
        return paramK;
      }
      return null;
    }
    finally {}
  }
  
  public final V put(K paramK, V paramV)
  {
    try
    {
      g.c.a locala = (g.c.a)this.nVp.get(paramK);
      if (locala != null)
      {
        b(locala);
        paramK = locala.value;
        locala.value = paramV;
        a(locala);
        return paramK;
      }
      paramV = new g.c.a(this, paramK, paramV);
      a(paramV);
      this.nVp.put(paramK, paramV);
      for (this.smA += 1; this.sms < this.smA; this.smA -= 1)
      {
        paramK = this.smz.smB;
        b(paramK);
        this.nVp.remove(paramK.smD);
        bN(paramK.value);
      }
    }
    finally {}
    return null;
  }
  
  public String toString()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      for (Object localObject1 = this.smy.smC; localObject1 != this.smz; localObject1 = ((g.c.a)localObject1).smC) {
        localStringBuilder.append("[key:").append(((g.c.a)localObject1).smD).append(", value:").append(((g.c.a)localObject1).value).append("]");
      }
      localObject1 = localStringBuilder.toString();
      return localObject1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.g.c
 * JD-Core Version:    0.7.0.1
 */