package com.tencent.toybrick.e;

import android.os.Handler;
import android.support.v7.g.c;
import android.support.v7.g.c.b;
import com.tencent.toybrick.a.a;
import com.tencent.toybrick.c.f;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.c.g.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashMap<Lcom.tencent.toybrick.c.g;Ljava.lang.Integer;>;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class b$b
  implements Runnable
{
  private LinkedList<g> xbB;
  private ArrayList<g> xbC;
  boolean xbp;
  
  public b$b(boolean paramBoolean, LinkedList<g> paramLinkedList, ArrayList<g> paramArrayList)
  {
    this.xbp = paramLinkedList;
    this.xbB = new LinkedList(paramArrayList);
    Collection localCollection;
    this.xbC = new ArrayList(localCollection);
  }
  
  private void a(List<g> paramList, HashMap<g, Integer> paramHashMap)
  {
    paramList.clear();
    Object localObject1 = this.xbB.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (g)((Iterator)localObject1).next();
      if (((f)localObject2).isVisible) {
        paramList.add(localObject2);
      }
      paramHashMap.put(localObject2, Integer.valueOf(paramHashMap.size()));
    }
    Collections.sort(paramList);
    if (this.xbp)
    {
      localObject2 = paramList.iterator();
      int i = 0;
      for (paramHashMap = null; ((Iterator)localObject2).hasNext(); paramHashMap = (HashMap<g, Integer>)localObject1)
      {
        localObject1 = (g)((Iterator)localObject2).next();
        if (((g)localObject1).cQZ() == g.b.xbm)
        {
          ((g)localObject1).xbe = false;
          if (paramHashMap != null) {
            paramHashMap.xbe = false;
          }
        }
        if (i == paramList.size() - 1) {
          ((g)localObject1).xbe = false;
        }
        i += 1;
      }
    }
  }
  
  public final void run()
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    a(localArrayList, localHashMap);
    c.b localb = c.a(new a(this.xbC, localArrayList), true);
    b.a locala = new b.a(this.xbx, (byte)0);
    locala.xbA = localHashMap;
    locala.xby = localb;
    locala.xbz = localArrayList;
    this.xbx.mMainHandler.post(new b.b.1(this, locala));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.toybrick.e.b.b
 * JD-Core Version:    0.7.0.1
 */