package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public final class e
  implements b
{
  private static e ahcS = null;
  private final SparseArray<Set<b>> ahcT = new SparseArray();
  private d ahcU = null;
  private final Handler handler = new Handler(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      e.this.b((d)paramAnonymousMessage.obj);
    }
  };
  private Vector<d> oup = new Vector();
  private Vector<d> ouq = new Vector();
  
  private void bFV()
  {
    if (this.ouq.size() > 0)
    {
      d locald = (d)this.ouq.get(0);
      int i = 1;
      while (i < this.ouq.size())
      {
        this.ouq.get(i);
        i += 1;
      }
      if (jQY())
      {
        this.ouq.remove(locald);
        d(locald);
      }
    }
  }
  
  private boolean c(d paramd)
  {
    if (paramd == null) {
      return false;
    }
    d(paramd);
    return true;
  }
  
  private void d(final d paramd)
  {
    if (jQY())
    {
      this.oup.add(paramd);
      int i = paramd.a(this);
      if (i < 0)
      {
        com.tencent.pb.common.c.b.w("MicroMsg.Voip", new Object[] { "doSceneImp do scene failed, ret %d,", Integer.valueOf(i) });
        this.handler.post(new Runnable()
        {
          public final void run()
          {
            e.a(e.this).remove(paramd);
            e.this.a(2, -1, "doScene failed", paramd);
          }
        });
      }
    }
    for (;;)
    {
      bFV();
      return;
      this.ouq.add(paramd);
    }
  }
  
  public static e jQX()
  {
    if (ahcS == null) {}
    try
    {
      if (ahcS == null) {
        ahcS = new e();
      }
      return ahcS;
    }
    finally {}
  }
  
  private boolean jQY()
  {
    return this.oup.size() < 20;
  }
  
  public final void a(final int paramInt1, final int paramInt2, final String paramString, final d paramd)
  {
    this.oup.remove(paramd);
    bFV();
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        Set localSet = (Set)e.b(e.this).get(paramd.getType());
        if ((localSet != null) && (localSet.size() > 0))
        {
          Object localObject = new HashSet();
          ((Set)localObject).addAll(localSet);
          localObject = ((Set)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            b localb = (b)((Iterator)localObject).next();
            if ((localb != null) && (localSet.contains(localb))) {
              localb.a(paramInt1, paramInt2, paramString, paramd);
            }
          }
        }
      }
    });
  }
  
  public final void a(int paramInt, b paramb)
  {
    if (this.ahcT.get(paramInt) == null) {
      this.ahcT.put(paramInt, new HashSet());
    }
    if (!((Set)this.ahcT.get(paramInt)).contains(paramb)) {
      ((Set)this.ahcT.get(paramInt)).add(paramb);
    }
  }
  
  public final boolean b(d paramd)
  {
    if (!h.isNetworkConnected())
    {
      int i = paramd.getType();
      if ((i == 102) || (i == 104) || (i == 103))
      {
        com.tencent.pb.common.c.b.w("MicroMsg.Voip", new Object[] { "doScene do retain mReissueNetScene" });
        this.ahcU = paramd;
      }
    }
    return c(paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.e
 * JD-Core Version:    0.7.0.1
 */