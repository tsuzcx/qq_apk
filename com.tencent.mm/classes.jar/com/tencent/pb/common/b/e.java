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
  private static e Ika = null;
  private final SparseArray<Set<b>> Ikb = new SparseArray();
  private d Ikc = null;
  private Vector<d> gVJ = new Vector();
  private Vector<d> gVK = new Vector();
  private final Handler handler = new Handler(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      e.this.a((d)paramAnonymousMessage.obj);
    }
  };
  
  private void auW()
  {
    if (this.gVK.size() > 0)
    {
      d locald = (d)this.gVK.get(0);
      int i = 1;
      while (i < this.gVK.size())
      {
        this.gVK.get(i);
        i += 1;
      }
      if (flm())
      {
        this.gVK.remove(locald);
        b(locald);
      }
    }
  }
  
  private void b(final d paramd)
  {
    if (flm())
    {
      this.gVJ.add(paramd);
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
      auW();
      return;
      this.gVK.add(paramd);
    }
  }
  
  public static e fll()
  {
    if (Ika == null) {}
    try
    {
      if (Ika == null) {
        Ika = new e();
      }
      return Ika;
    }
    finally {}
  }
  
  private boolean flm()
  {
    return this.gVJ.size() < 20;
  }
  
  public final void a(final int paramInt1, final int paramInt2, final String paramString, final d paramd)
  {
    this.gVJ.remove(paramd);
    auW();
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
    if (this.Ikb.get(paramInt) == null) {
      this.Ikb.put(paramInt, new HashSet());
    }
    if (!((Set)this.Ikb.get(paramInt)).contains(paramb)) {
      ((Set)this.Ikb.get(paramInt)).add(paramb);
    }
  }
  
  public final boolean a(d paramd)
  {
    if (!h.isNetworkConnected())
    {
      int i = paramd.getType();
      if ((i == 102) || (i == 104) || (i == 103))
      {
        com.tencent.pb.common.c.b.w("MicroMsg.Voip", new Object[] { "doScene do retain mReissueNetScene" });
        this.Ikc = paramd;
      }
    }
    if (paramd == null) {
      return false;
    }
    b(paramd);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.pb.common.b.e
 * JD-Core Version:    0.7.0.1
 */