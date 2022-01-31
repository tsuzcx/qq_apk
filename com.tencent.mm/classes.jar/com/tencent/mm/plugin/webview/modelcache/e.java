package com.tencent.mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
{
  private final SparseArray<b<e.a>> rhf = new SparseArray();
  
  public final boolean Ce(int paramInt)
  {
    b localb;
    synchronized (this.rhf)
    {
      localb = (b)this.rhf.get(paramInt);
      this.rhf.remove(paramInt);
      if (localb == null) {}
    }
    synchronized (localb.dMQ)
    {
      localb.rhj.clear();
      return true;
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public final boolean a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)) || (bk.bl(paramString3)) || ((paramInt2 != 2) && (paramInt2 != 1) && (paramInt2 != 3))) {
      return false;
    }
    b localb;
    synchronized (this.rhf)
    {
      localb = (b)this.rhf.get(paramInt1);
      if (localb == null) {
        return true;
      }
    }
    for (;;)
    {
      synchronized (localb.dMQ)
      {
        if (localb.rhj.size() == 0) {
          return true;
        }
        LinkedList localLinkedList = new LinkedList();
        paramInt1 = 0;
        if (paramInt1 < localb.rhj.size())
        {
          e.a locala = (e.a)localb.valueAt(paramInt1);
          if ((!bk.pm(locala.appId).equals(paramString1)) || (!bk.pm(locala.ceG).equals(paramString2)) || (!bk.pm(locala.ceH).equals(paramString3)) || (locala.ceI != paramInt2)) {
            break label263;
          }
          localLinkedList.add(Integer.valueOf(locala.key));
          break label263;
        }
        paramString1 = localLinkedList.iterator();
        if (paramString1.hasNext()) {
          localb.remove(((Integer)paramString1.next()).intValue());
        }
      }
      return true;
      label263:
      paramInt1 += 1;
    }
  }
  
  public final boolean a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)) || (bk.bl(paramString3)) || (bk.bl(paramString4)) || ((paramInt2 != 2) && (paramInt2 != 1) && (paramInt2 != 3))) {
      return false;
    }
    b localb;
    synchronized (this.rhf)
    {
      localb = (b)this.rhf.get(paramInt1);
      if (localb == null) {
        return true;
      }
    }
    for (;;)
    {
      synchronized (localb.dMQ)
      {
        if (localb.rhj.size() == 0) {
          return true;
        }
        LinkedList localLinkedList = new LinkedList();
        paramInt1 = 0;
        if (paramInt1 < localb.rhj.size())
        {
          e.a locala = (e.a)localb.valueAt(paramInt1);
          if ((!bk.pm(locala.appId).equals(paramString1)) || (!bk.pm(locala.ceG).equals(paramString2)) || (!bk.pm(locala.ceH).equals(paramString3)) || (!bk.pm(locala.rhi).equals(paramString4)) || (locala.ceI != paramInt2)) {
            break label287;
          }
          localLinkedList.add(Integer.valueOf(locala.key));
          break label287;
        }
        paramString1 = localLinkedList.iterator();
        if (paramString1.hasNext()) {
          localb.remove(((Integer)paramString1.next()).intValue());
        }
      }
      return true;
      label287:
      paramInt1 += 1;
    }
  }
  
  public final List<e.c> s(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)) || (bk.bl(paramString3)) || (bk.bl(paramString4))) {}
    String str;
    do
    {
      return null;
      str = p.Sz(paramString1);
    } while (bk.bl(str));
    LinkedList localLinkedList = new LinkedList();
    paramString1 = this.rhf;
    int i = 0;
    for (;;)
    {
      int j;
      try
      {
        if (i < this.rhf.size())
        {
          b localb = (b)this.rhf.valueAt(i);
          if (localb == null) {
            break label254;
          }
          byte[] arrayOfByte = localb.dMQ;
          j = 0;
          try
          {
            if (j < localb.rhj.size())
            {
              e.a locala = (e.a)localb.valueAt(j);
              if ((!bk.pm(locala.rhi).equals(str)) || (!bk.pm(locala.appId).equals(paramString2)) || (!bk.pm(locala.ceG).equals(paramString3)) || (!bk.pm(locala.ceH).equals(paramString4))) {
                break label245;
              }
              localLinkedList.add(new e.c(locala.rhh, locala.rhg));
              break label245;
            }
          }
          finally {}
        }
      }
      finally {}
      return localLinkedList;
      label245:
      j += 1;
      continue;
      label254:
      i += 1;
    }
  }
  
  private static final class b<T>
  {
    final byte[] dMQ = new byte[0];
    final SparseArray<T> rhj = new SparseArray();
    
    public final void remove(int paramInt)
    {
      this.rhj.remove(paramInt);
    }
    
    public final T valueAt(int paramInt)
    {
      return this.rhj.valueAt(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modelcache.e
 * JD-Core Version:    0.7.0.1
 */