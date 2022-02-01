package com.tencent.toybrick.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.d.a.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  public Runnable ZQh;
  public Handler mMainHandler;
  WeakReference<com.tencent.toybrick.b.b> yAr;
  
  public b(com.tencent.toybrick.b.b paramb)
  {
    AppMethodBeat.i(159970);
    this.mMainHandler = new Handler(Looper.getMainLooper());
    this.yAr = new WeakReference(paramb);
    AppMethodBeat.o(159970);
  }
  
  final class a
  {
    public h.b ZQj;
    public HashMap<g, Integer> ZQk;
    public ArrayList<g> sYP;
    
    private a() {}
  }
  
  final class b
    implements Runnable
  {
    boolean ZQb;
    private LinkedList<g> ZQl;
    private ArrayList<g> ZQm;
    
    public b(LinkedList<g> paramLinkedList, ArrayList<g> paramArrayList)
    {
      AppMethodBeat.i(159967);
      this.ZQb = paramLinkedList;
      this.ZQl = new LinkedList(paramArrayList);
      Collection localCollection;
      this.ZQm = new ArrayList(localCollection);
      AppMethodBeat.o(159967);
    }
    
    public final void run()
    {
      AppMethodBeat.i(159968);
      ArrayList localArrayList = new ArrayList();
      HashMap localHashMap = new HashMap();
      localArrayList.clear();
      Object localObject = this.ZQl.iterator();
      if (((Iterator)localObject).hasNext())
      {
        ((Iterator)localObject).next();
        AppMethodBeat.o(159968);
        throw null;
      }
      Collections.sort(localArrayList);
      if (this.ZQb)
      {
        localObject = localArrayList.iterator();
        if (((Iterator)localObject).hasNext())
        {
          ((Iterator)localObject).next();
          AppMethodBeat.o(159968);
          throw null;
        }
      }
      localObject = h.a(new com.tencent.toybrick.a.a(this.ZQm, localArrayList), true);
      final b.a locala = new b.a(b.this, (byte)0);
      locala.ZQk = localHashMap;
      locala.ZQj = ((h.b)localObject);
      locala.sYP = localArrayList;
      b.this.mMainHandler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(159966);
          com.tencent.toybrick.b.b localb = (com.tencent.toybrick.b.b)b.this.yAr.get();
          if (localb != null)
          {
            localb.ZPR = locala.sYP;
            localb.ZPT = locala.ZQk;
            locala.ZQj.a(localb);
          }
          AppMethodBeat.o(159966);
        }
      });
      AppMethodBeat.o(159968);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.toybrick.e.b
 * JD-Core Version:    0.7.0.1
 */