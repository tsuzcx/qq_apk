package com.tencent.toybrick.e;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.h.c;
import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.a.a;
import com.tencent.toybrick.c.f;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.c.g.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashMap<Lcom.tencent.toybrick.c.g;Ljava.lang.Integer;>;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  WeakReference<com.tencent.toybrick.b.b> Byb;
  public Runnable Byc;
  public Handler mMainHandler;
  
  public b(com.tencent.toybrick.b.b paramb)
  {
    AppMethodBeat.i(113233);
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.Byb = new WeakReference(paramb);
    AppMethodBeat.o(113233);
  }
  
  final class b
    implements Runnable
  {
    boolean BxV;
    private LinkedList<g> Byh;
    private ArrayList<g> Byi;
    
    public b(LinkedList<g> paramLinkedList, ArrayList<g> paramArrayList)
    {
      AppMethodBeat.i(113230);
      this.BxV = paramLinkedList;
      this.Byh = new LinkedList(paramArrayList);
      Collection localCollection;
      this.Byi = new ArrayList(localCollection);
      AppMethodBeat.o(113230);
    }
    
    private void a(List<g> paramList, HashMap<g, Integer> paramHashMap)
    {
      AppMethodBeat.i(113232);
      paramList.clear();
      Object localObject1 = this.Byh.iterator();
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
      if (this.BxV)
      {
        localObject2 = paramList.iterator();
        int i = 0;
        for (paramHashMap = null; ((Iterator)localObject2).hasNext(); paramHashMap = (HashMap<g, Integer>)localObject1)
        {
          localObject1 = (g)((Iterator)localObject2).next();
          if (((g)localObject1).dWO() == g.b.BxS)
          {
            ((g)localObject1).BxK = false;
            if (paramHashMap != null) {
              paramHashMap.BxK = false;
            }
          }
          if (i == paramList.size() - 1) {
            ((g)localObject1).BxK = false;
          }
          i += 1;
        }
      }
      AppMethodBeat.o(113232);
    }
    
    public final void run()
    {
      AppMethodBeat.i(113231);
      ArrayList localArrayList = new ArrayList();
      HashMap localHashMap = new HashMap();
      a(localArrayList, localHashMap);
      c.b localb = c.a(new a(this.Byi, localArrayList), true);
      b.a locala = new b.a(b.this, (byte)0);
      locala.Byg = localHashMap;
      locala.Bye = localb;
      locala.Byf = localArrayList;
      b.this.mMainHandler.post(new b.b.1(this, locala));
      AppMethodBeat.o(113231);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.toybrick.e.b
 * JD-Core Version:    0.7.0.1
 */