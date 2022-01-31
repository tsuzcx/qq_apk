package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class n$a<Req extends l>
  extends f.d<Req>
  implements e
{
  private static final ThreadLocal<j> rXH = new n.a.1();
  private final int rWd;
  private final AtomicInteger rXI;
  public volatile c rXJ;
  
  public n$a(Req paramReq)
  {
    super(paramReq);
    this.rWd = paramReq.rWd;
    this.rXI = new AtomicInteger(this.rWd);
  }
  
  public m a(j paramj)
  {
    if (!acf()) {
      return j.a(this);
    }
    paramj = q.a.clL().Wl(cls());
    if (paramj != null)
    {
      paramj.field_status = 1;
      q.a.clL().g(paramj);
    }
    return j.a(this);
  }
  
  public boolean acc()
  {
    return false;
  }
  
  public boolean acd()
  {
    return true;
  }
  
  public boolean ace()
  {
    return false;
  }
  
  public boolean acf()
  {
    return true;
  }
  
  public boolean acg()
  {
    return true;
  }
  
  public boolean ach()
  {
    if (this.rXI.decrementAndGet() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.rXJ.s(cls(), this.rWd, this.rXI.get());
      return bool;
    }
  }
  
  public final String bjl()
  {
    return ((l)aci()).bjl();
  }
  
  public final String clF()
  {
    return "GET";
  }
  
  public final Collection<b> clG()
  {
    Map localMap = ((l)aci()).getRequestHeaders();
    if ((localMap == null) || (localMap.size() == 0)) {
      return null;
    }
    Object localObject = localMap.keySet();
    if ((localObject == null) || (((Set)localObject).size() == 0)) {
      return null;
    }
    LinkedList localLinkedList = new LinkedList();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str1 = (String)((Iterator)localObject).next();
      String str2 = (String)localMap.get(str1);
      if (!bk.bl(str2)) {
        localLinkedList.add(new b(str1, str2));
      }
    }
    return localLinkedList;
  }
  
  public final int clH()
  {
    return ((l)aci()).clH();
  }
  
  public final String clI()
  {
    return "application/x-www-form-urlencoded;charset=utf-8";
  }
  
  public final String cls()
  {
    return ((l)aci()).rVT;
  }
  
  public boolean ct(long paramLong)
  {
    this.rXJ.u(cls(), paramLong);
    long l = az.crH();
    y.i("MicroMsg.ResDownloader.NetworkWorker", "%s: get available size = %d", new Object[] { cls(), Long.valueOf(l) });
    return l >= paramLong;
  }
  
  public final int getConnectTimeout()
  {
    return ((l)aci()).getConnectTimeout();
  }
  
  public final int getReadTimeout()
  {
    return ((l)aci()).getReadTimeout();
  }
  
  public String getURL()
  {
    return ((l)aci()).url;
  }
  
  public final void run()
  {
    m localm = a((j)rXH.get());
    if (localm != null)
    {
      this.rXJ.a(this, localm);
      return;
    }
    y.e("MicroMsg.ResDownloader.NetworkWorker", "groupId = %s, performer get null response", new Object[] { acb() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.n.a
 * JD-Core Version:    0.7.0.1
 */