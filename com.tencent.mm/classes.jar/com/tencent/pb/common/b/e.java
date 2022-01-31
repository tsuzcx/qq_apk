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
  private static e wFE = null;
  private Vector<d> edA = new Vector();
  private Vector<d> edz = new Vector();
  private final Handler handler = new e.1(this, Looper.getMainLooper());
  private final SparseArray<Set<b>> wFF = new SparseArray();
  private d wFG = null;
  
  private void KK()
  {
    if (this.edA.size() > 0)
    {
      d locald = (d)this.edA.get(0);
      int i = 1;
      while (i < this.edA.size())
      {
        this.edA.get(i);
        i += 1;
      }
      if (cNT())
      {
        this.edA.remove(locald);
        b(locald);
      }
    }
  }
  
  private void b(d paramd)
  {
    int i;
    if (cNT())
    {
      this.edz.add(paramd);
      if (paramd.wFw == null)
      {
        c.x("MicroMsg.Voip", new Object[] { paramd.TAG2, "dosene reqData is null cmd=" + paramd.wFy });
        i = -1;
        if (i < 0)
        {
          c.x("MicroMsg.Voip", new Object[] { "doSceneImp do scene failed, ret %d,", Integer.valueOf(i) });
          this.handler.post(new e.2(this, paramd));
        }
      }
    }
    for (;;)
    {
      KK();
      return;
      paramd.wFv = this;
      i locali = new i(paramd);
      i = f.cNV().a(null, locali, paramd.wFy, paramd.cNR(), paramd.wFw, paramd.wFA);
      if (i >= 0) {
        paramd.mHandler.postDelayed(paramd.edV, 60000L);
      }
      c.d("MicroMsg.Voip", new Object[] { "NETTASK_SEND dosene:cmd ", paramd.cNR(), Integer.valueOf(i) });
      break;
      this.edA.add(paramd);
    }
  }
  
  public static e cNS()
  {
    if (wFE == null) {}
    try
    {
      if (wFE == null) {
        wFE = new e();
      }
      return wFE;
    }
    finally {}
  }
  
  private boolean cNT()
  {
    return this.edz.size() < 20;
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, d paramd)
  {
    this.edz.remove(paramd);
    KK();
    this.handler.post(new e.3(this, paramd, paramInt1, paramInt2, paramString));
  }
  
  public final void a(int paramInt, b paramb)
  {
    if (this.wFF.get(paramInt) == null) {
      this.wFF.put(paramInt, new HashSet());
    }
    if (!((Set)this.wFF.get(paramInt)).contains(paramb)) {
      ((Set)this.wFF.get(paramInt)).add(paramb);
    }
  }
  
  public final boolean a(d paramd)
  {
    if (!h.isNetworkConnected())
    {
      int i = paramd.getType();
      if ((i == 102) || (i == 104) || (i == 103))
      {
        c.x("MicroMsg.Voip", new Object[] { "doScene do retain mReissueNetScene" });
        this.wFG = paramd;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.pb.common.b.e
 * JD-Core Version:    0.7.0.1
 */