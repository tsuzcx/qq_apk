package com.tencent.mm.plugin.order.a;

import android.os.Looper;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.model.p;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class b
  implements ar
{
  private static HashMap<Integer, h.d> dgp;
  private List<WeakReference<Object>> fKm = new ArrayList();
  private bx.a iGD = new b.3(this);
  private ah mHandler = new ah(Looper.getMainLooper());
  com.tencent.mm.plugin.order.model.b mOp = null;
  private com.tencent.mm.plugin.order.b.b mOq;
  private com.tencent.mm.plugin.order.model.c mOr = null;
  private bx.a mOs = new b.2(this);
  
  static
  {
    HashMap localHashMap = new HashMap();
    dgp = localHashMap;
    localHashMap.put(Integer.valueOf("ORDERCOMMONMSGXML_TABLE".hashCode()), new b.1());
    com.tencent.mm.wallet_core.a.i("ShowOrdersInfoProcess", a.class);
  }
  
  public static String bfi()
  {
    if (g.DK()) {
      return com.tencent.mm.plugin.n.c.FG() + "order";
    }
    return "";
  }
  
  public static b brv()
  {
    return (b)p.B(b.class);
  }
  
  public static com.tencent.mm.plugin.order.b.b brx()
  {
    g.DN().CX();
    if (brv().mOq == null)
    {
      b localb = brv();
      g.DQ();
      localb.mOq = new com.tencent.mm.plugin.order.b.b(g.DP().dKu);
    }
    return brv().mOq;
  }
  
  public static com.tencent.mm.plugin.order.model.c bry()
  {
    g.DN().CX();
    if (brv().mOr == null) {
      brv().mOr = new com.tencent.mm.plugin.order.model.c();
    }
    return brv().mOr;
  }
  
  public final void axs()
  {
    if (this.fKm == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.fKm.size())
      {
        WeakReference localWeakReference = (WeakReference)this.fKm.get(i);
        if (localWeakReference != null) {
          localWeakReference.get();
        }
        i += 1;
      }
    }
  }
  
  public final void bh(boolean paramBoolean)
  {
    this.mOp = null;
    this.mOr = null;
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void brw()
  {
    if (this.fKm == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.fKm.size())
      {
        WeakReference localWeakReference = (WeakReference)this.fKm.get(i);
        if (localWeakReference != null) {
          localWeakReference.get();
        }
        i += 1;
      }
    }
  }
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease() {}
  
  public final HashMap<Integer, h.d> xe()
  {
    return dgp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.order.a.b
 * JD-Core Version:    0.7.0.1
 */