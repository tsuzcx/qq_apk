package com.tencent.mm.pluginsdk.g.a.c;

import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bo;
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
  private static final ThreadLocal<j> vOy = new n.a.1();
  private final int vMT;
  public volatile c vOA;
  private final AtomicInteger vOz;
  
  protected n$a(Req paramReq)
  {
    super(paramReq);
    this.vMT = paramReq.vMT;
    this.vOz = new AtomicInteger(this.vMT);
  }
  
  protected m a(j paramj)
  {
    if (!avW()) {
      return j.a(this);
    }
    paramj = q.a.dmz().alQ(dlZ());
    if (paramj != null)
    {
      paramj.field_status = 1;
      q.a.dmz().h(paramj);
    }
    return j.a(this);
  }
  
  public boolean avT()
  {
    return false;
  }
  
  public boolean avU()
  {
    return true;
  }
  
  public boolean avV()
  {
    return false;
  }
  
  protected boolean avW()
  {
    return true;
  }
  
  public boolean avX()
  {
    if (this.vOz.decrementAndGet() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.vOA.E(dlZ(), this.vMT, this.vOz.get());
      return bool;
    }
  }
  
  public final String dlZ()
  {
    return ((l)avY()).vMK;
  }
  
  public final String dmt()
  {
    return "GET";
  }
  
  public final Collection<b> dmu()
  {
    Map localMap = ((l)avY()).getRequestHeaders();
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
      if (!bo.isNullOrNil(str2)) {
        localLinkedList.add(new b(str1, str2));
      }
    }
    return localLinkedList;
  }
  
  public final int dmv()
  {
    return ((l)avY()).dmv();
  }
  
  public final String dmw()
  {
    return "application/x-www-form-urlencoded;charset=utf-8";
  }
  
  public final int getConnectTimeout()
  {
    return ((l)avY()).getConnectTimeout();
  }
  
  public final String getFilePath()
  {
    return ((l)avY()).getFilePath();
  }
  
  public final int getReadTimeout()
  {
    return ((l)avY()).getReadTimeout();
  }
  
  public String getURL()
  {
    return ((l)avY()).url;
  }
  
  public boolean hq(long paramLong)
  {
    this.vOA.D(dlZ(), paramLong);
    long l = bd.dtH();
    ab.i("MicroMsg.ResDownloader.NetworkWorker", "%s: get available size = %d", new Object[] { dlZ(), Long.valueOf(l) });
    return l >= paramLong;
  }
  
  public final void run()
  {
    m localm = a((j)vOy.get());
    if (localm != null)
    {
      this.vOA.a(this, localm);
      return;
    }
    ab.e("MicroMsg.ResDownloader.NetworkWorker", "groupId = %s, performer get null response", new Object[] { avS() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.c.n.a
 * JD-Core Version:    0.7.0.1
 */