package com.tencent.toybrick.e;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.h.c;
import android.support.v7.h.c.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.f;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.c.g.b;
import com.tencent.toybrick.d.a.a;
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
  WeakReference<com.tencent.toybrick.b.b> Ktp;
  public Runnable Ktq;
  public Handler mMainHandler;
  
  public b(com.tencent.toybrick.b.b paramb)
  {
    AppMethodBeat.i(159970);
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.Ktp = new WeakReference(paramb);
    AppMethodBeat.o(159970);
  }
  
  final class a
  {
    public c.b Kts;
    public ArrayList<g> Ktt;
    public HashMap<g, Integer> Ktu;
    
    private a() {}
  }
  
  final class b
    implements Runnable
  {
    boolean Ktj;
    private LinkedList<g> Ktv;
    private ArrayList<g> Ktw;
    
    public b(LinkedList<g> paramLinkedList, ArrayList<g> paramArrayList)
    {
      AppMethodBeat.i(159967);
      this.Ktj = paramLinkedList;
      this.Ktv = new LinkedList(paramArrayList);
      Collection localCollection;
      this.Ktw = new ArrayList(localCollection);
      AppMethodBeat.o(159967);
    }
    
    private void b(List<g> paramList, HashMap<g, Integer> paramHashMap)
    {
      AppMethodBeat.i(159969);
      paramList.clear();
      Object localObject1 = this.Ktv.iterator();
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
      if (this.Ktj)
      {
        localObject2 = paramList.iterator();
        int i = 0;
        for (paramHashMap = null; ((Iterator)localObject2).hasNext(); paramHashMap = (HashMap<g, Integer>)localObject1)
        {
          localObject1 = (g)((Iterator)localObject2).next();
          if (((g)localObject1).fHq() == g.b.Ktg)
          {
            ((g)localObject1).KsY = false;
            if (paramHashMap != null) {
              paramHashMap.KsY = false;
            }
          }
          if (i == paramList.size() - 1) {
            ((g)localObject1).KsY = false;
          }
          i += 1;
        }
      }
      AppMethodBeat.o(159969);
    }
    
    public final void run()
    {
      AppMethodBeat.i(159968);
      ArrayList localArrayList = new ArrayList();
      HashMap localHashMap = new HashMap();
      b(localArrayList, localHashMap);
      c.b localb = c.a(new com.tencent.toybrick.a.a(this.Ktw, localArrayList), true);
      final b.a locala = new b.a(b.this, (byte)0);
      locala.Ktu = localHashMap;
      locala.Kts = localb;
      locala.Ktt = localArrayList;
      b.this.mMainHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(159966);
          com.tencent.toybrick.b.b localb = (com.tencent.toybrick.b.b)b.this.Ktp.get();
          if (localb != null)
          {
            localb.Ksh = locala.Ktt;
            localb.Ksj = locala.Ktu;
            locala.Kts.a(localb);
          }
          AppMethodBeat.o(159966);
        }
      });
      AppMethodBeat.o(159968);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.toybrick.e.b
 * JD-Core Version:    0.7.0.1
 */