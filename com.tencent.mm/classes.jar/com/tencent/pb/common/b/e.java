package com.tencent.pb.common.b;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.pb.common.c.c;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import junit.framework.Assert;

public final class e
  implements b
{
  private static e Bde = null;
  private final SparseArray<Set<b>> Bdf = new SparseArray();
  private d Bdg = null;
  private Vector<d> ftC = new Vector();
  private Vector<d> ftD = new Vector();
  private final Handler handler = new e.1(this, Looper.getMainLooper());
  
  private void ady()
  {
    if (this.ftD.size() > 0)
    {
      d locald = (d)this.ftD.get(0);
      int i = 1;
      while (i < this.ftD.size())
      {
        this.ftD.get(i);
        i += 1;
      }
      if (dTF())
      {
        this.ftD.remove(locald);
        b(locald);
      }
    }
  }
  
  private void b(d paramd)
  {
    if (dTF())
    {
      this.ftC.add(paramd);
      int i = paramd.a(this);
      if (i < 0)
      {
        c.w("MicroMsg.Voip", new Object[] { "doSceneImp do scene failed, ret %d,", Integer.valueOf(i) });
        this.handler.post(new e.2(this, paramd));
      }
    }
    for (;;)
    {
      ady();
      return;
      this.ftD.add(paramd);
    }
  }
  
  public static e dTE()
  {
    if (Bde == null) {}
    try
    {
      if (Bde == null) {
        Bde = new e();
      }
      return Bde;
    }
    finally {}
  }
  
  private boolean dTF()
  {
    return this.ftC.size() < 20;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, d paramd)
  {
    this.ftC.remove(paramd);
    ady();
    this.handler.post(new e.3(this, paramd, paramInt1, paramInt2, paramString));
  }
  
  public final void a(int paramInt, b paramb)
  {
    if (this.Bdf.get(paramInt) == null) {
      this.Bdf.put(paramInt, new HashSet());
    }
    if (!((Set)this.Bdf.get(paramInt)).contains(paramb)) {
      ((Set)this.Bdf.get(paramInt)).add(paramb);
    }
  }
  
  public final boolean a(d paramd)
  {
    if (!h.isNetworkConnected())
    {
      int i = paramd.getType();
      if ((i == 102) || (i == 104) || (i == 103))
      {
        c.w("MicroMsg.Voip", new Object[] { "doScene do retain mReissueNetScene" });
        this.Bdg = paramd;
      }
    }
    Assert.assertTrue(true);
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