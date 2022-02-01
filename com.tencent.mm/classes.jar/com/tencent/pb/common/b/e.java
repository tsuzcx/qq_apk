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
  private static e RCN = null;
  private final SparseArray<Set<b>> RCO = new SparseArray();
  private d RCP = null;
  private final Handler handler = new Handler(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      e.this.a((d)paramAnonymousMessage.obj);
    }
  };
  private Vector<d> iMy = new Vector();
  private Vector<d> iMz = new Vector();
  
  private void aYX()
  {
    if (this.iMz.size() > 0)
    {
      d locald = (d)this.iMz.get(0);
      int i = 1;
      while (i < this.iMz.size())
      {
        this.iMz.get(i);
        i += 1;
      }
      if (hiX())
      {
        this.iMz.remove(locald);
        b(locald);
      }
    }
  }
  
  private void b(final d paramd)
  {
    if (hiX())
    {
      this.iMy.add(paramd);
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
      aYX();
      return;
      this.iMz.add(paramd);
    }
  }
  
  public static e hiW()
  {
    if (RCN == null) {}
    try
    {
      if (RCN == null) {
        RCN = new e();
      }
      return RCN;
    }
    finally {}
  }
  
  private boolean hiX()
  {
    return this.iMy.size() < 20;
  }
  
  public final void a(final int paramInt1, final int paramInt2, final String paramString, final d paramd)
  {
    this.iMy.remove(paramd);
    aYX();
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
    if (this.RCO.get(paramInt) == null) {
      this.RCO.put(paramInt, new HashSet());
    }
    if (!((Set)this.RCO.get(paramInt)).contains(paramb)) {
      ((Set)this.RCO.get(paramInt)).add(paramb);
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
        this.RCP = paramd;
      }
    }
    if (paramd == null) {
      return false;
    }
    b(paramd);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.pb.common.b.e
 * JD-Core Version:    0.7.0.1
 */