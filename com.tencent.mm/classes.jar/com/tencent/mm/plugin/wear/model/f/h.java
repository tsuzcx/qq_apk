package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.protocal.c.cjo;
import com.tencent.mm.protocal.c.cjp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
  extends b
{
  private long bIt;
  private long ceq;
  private String cer;
  private List<String> ces;
  
  public h(long paramLong1, long paramLong2, String paramString, List<String> paramList)
  {
    this.bIt = paramLong1;
    this.ceq = paramLong2;
    this.cer = paramString;
    this.ces = paramList;
  }
  
  public final String getName()
  {
    return "WearLuckyReceiveTask";
  }
  
  protected final void send()
  {
    cjo localcjo = new cjo();
    localcjo.tXr = this.ceq;
    localcjo.tXq = this.bIt;
    localcjo.tXs = this.cer;
    try
    {
      if (this.ces != null)
      {
        Iterator localIterator = this.ces.iterator();
        while (localIterator.hasNext())
        {
          String[] arrayOfString = ((String)localIterator.next()).split("=");
          cjp localcjp = new cjp();
          localcjp.tXp = arrayOfString[0];
          localcjp.hRf = arrayOfString[1];
          if (localcjp.hRf.startsWith("wxid")) {
            localcjp.hRf = com.tencent.mm.model.r.gV(localcjp.hRf);
          }
          localcjp.tXr = Long.valueOf(arrayOfString[2]).longValue();
          localcjo.tXt.add(localcjp);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (this.ceq > 0L)
      {
        com.tencent.mm.plugin.wear.model.c.a.kX(true);
        return;
        com.tencent.mm.plugin.wear.model.a.bYL();
        com.tencent.mm.plugin.wear.model.e.r.b(20015, localException.toByteArray(), true);
      }
      com.tencent.mm.plugin.wear.model.c.a.kX(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.f.h
 * JD-Core Version:    0.7.0.1
 */