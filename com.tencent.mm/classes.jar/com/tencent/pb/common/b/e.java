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
  private static e Zep = null;
  private final SparseArray<Set<b>> Zeq = new SparseArray();
  private d Zer = null;
  private final Handler handler = new Handler(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      e.this.b((d)paramAnonymousMessage.obj);
    }
  };
  private Vector<d> lCF = new Vector();
  private Vector<d> lCG = new Vector();
  
  private void bim()
  {
    if (this.lCG.size() > 0)
    {
      d locald = (d)this.lCG.get(0);
      int i = 1;
      while (i < this.lCG.size())
      {
        this.lCG.get(i);
        i += 1;
      }
      if (ikH())
      {
        this.lCG.remove(locald);
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
    if (ikH())
    {
      this.lCF.add(paramd);
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
      bim();
      return;
      this.lCG.add(paramd);
    }
  }
  
  public static e ikG()
  {
    if (Zep == null) {}
    try
    {
      if (Zep == null) {
        Zep = new e();
      }
      return Zep;
    }
    finally {}
  }
  
  private boolean ikH()
  {
    return this.lCF.size() < 20;
  }
  
  public final void a(final int paramInt1, final int paramInt2, final String paramString, final d paramd)
  {
    this.lCF.remove(paramd);
    bim();
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
    if (this.Zeq.get(paramInt) == null) {
      this.Zeq.put(paramInt, new HashSet());
    }
    if (!((Set)this.Zeq.get(paramInt)).contains(paramb)) {
      ((Set)this.Zeq.get(paramInt)).add(paramb);
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
        this.Zer = paramd;
      }
    }
    return c(paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.e
 * JD-Core Version:    0.7.0.1
 */