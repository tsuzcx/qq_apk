package com.tencent.mm.sdk.a;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.j;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import junit.framework.Assert;

public final class a
{
  public static a YM = new a();
  private b YL = new b();
  private final HashMap<Integer, LinkedList<e>> YN = new HashMap();
  private final HashMap<Integer, c> YO = new HashMap();
  
  private void a(LinkedList<e> paramLinkedList, d paramd)
  {
    if (paramd.lo()) {
      Collections.sort(paramLinkedList, new Comparator() {});
    }
    e[] arrayOfe = new e[paramLinkedList.size()];
    paramLinkedList.toArray(arrayOfe);
    int j = arrayOfe.length;
    int i = 0;
    while ((i < j) && ((!arrayOfe[i].b(paramd)) || (!paramd.lo()))) {
      i += 1;
    }
    if (paramd.YK != null) {
      paramd.YK.run();
    }
  }
  
  public final void a(final d paramd, Looper paramLooper)
  {
    Assert.assertNotNull("EventPoolImpl.asyncPublish event", paramd);
    Assert.assertNotNull("EventPoolImpl.asyncPublish looper", paramLooper);
    f.e("MicroMsg.EventCenter", "publish %s(%d)", new Object[] { paramd, Integer.valueOf(paramd.ln()) });
    new j(paramLooper).post(new Runnable()
    {
      public final void run()
      {
        a.YM.a(paramd);
      }
    });
  }
  
  public final boolean a(d paramd)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    Assert.assertNotNull("EventPoolImpl.publish", paramd);
    f.e("MicroMsg.EventCenter", "publish %s(%d)", new Object[] { paramd, Integer.valueOf(paramd.ln()) });
    LinkedList localLinkedList = null;
    for (;;)
    {
      try
      {
        int i = paramd.ln();
        Object localObject = (LinkedList)this.YN.get(Integer.valueOf(i));
        if (localObject != null)
        {
          localLinkedList = new LinkedList((Collection)localObject);
          bool1 = true;
        }
        localObject = (c)this.YO.get(Integer.valueOf(i));
        if (localObject != null)
        {
          bool1 = bool2;
          if (!bool1) {
            f.b("MicroMsg.EventCenter", "No listener for this event %s(%d), Stack: %s.", new Object[] { paramd, Integer.valueOf(i), "" });
          }
          if (localLinkedList != null) {
            a(localLinkedList, paramd);
          }
          if (localObject != null) {
            ((c)localObject).a(com.tencent.mm.vending.g.b.Y(paramd));
          }
          return bool1;
        }
      }
      finally {}
    }
  }
  
  @Deprecated
  public final boolean a(e parame)
  {
    try
    {
      Assert.assertNotNull("EventPoolImpl.add", parame);
      f.e("MicroMsg.EventCenter", "addListener %s(%d)", new Object[] { parame, Integer.valueOf(parame.ln()) });
      Object localObject2 = (LinkedList)this.YN.get(Integer.valueOf(parame.ln()));
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this.YN;
        int i = parame.ln();
        localObject1 = new LinkedList();
        ((HashMap)localObject2).put(Integer.valueOf(i), localObject1);
      }
      if (((LinkedList)localObject1).contains(parame)) {
        return true;
      }
      com.tencent.mm.sdk.platformtools.b.M(parame);
      boolean bool = ((LinkedList)localObject1).add(parame);
      return bool;
    }
    finally {}
  }
  
  @Deprecated
  public final boolean b(e parame)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        Assert.assertNotNull("EventPoolImpl.remove", parame);
        f.e("MicroMsg.EventCenter", "removeListener %s(%d)", new Object[] { parame, Integer.valueOf(parame.ln()) });
        Object localObject = (LinkedList)this.YN.get(Integer.valueOf(parame.ln()));
        if (localObject != null) {
          bool = ((LinkedList)localObject).remove(parame);
        }
        localObject = (c)this.YO.get(Integer.valueOf(parame.ln()));
        if (localObject != null)
        {
          ((c)localObject).c(parame);
          bool = true;
          com.tencent.mm.sdk.platformtools.b.N(parame);
          return bool;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.a.a
 * JD-Core Version:    0.7.0.1
 */