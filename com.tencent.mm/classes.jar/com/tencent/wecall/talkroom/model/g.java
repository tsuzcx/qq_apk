package com.tencent.wecall.talkroom.model;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.ar;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
{
  List<a> bPE;
  Handler handler;
  
  public g()
  {
    AppMethodBeat.i(62692);
    this.bPE = new LinkedList();
    this.handler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(62692);
  }
  
  public final void L(final int paramInt, final Object paramObject)
  {
    AppMethodBeat.i(62696);
    paramObject = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62601);
        synchronized (g.this.bPE)
        {
          Iterator localIterator = g.this.bPE.iterator();
          if (localIterator.hasNext()) {
            ((g.a)localIterator.next()).L(paramInt, paramObject);
          }
        }
        AppMethodBeat.o(62601);
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramObject.run();
      AppMethodBeat.o(62696);
      return;
    }
    this.handler.post(paramObject);
    AppMethodBeat.o(62696);
  }
  
  public final void a(final int paramInt, final MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(62694);
    paramMultiTalkGroup = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(183723);
        synchronized (g.this.bPE)
        {
          Iterator localIterator = g.this.bPE.iterator();
          if (localIterator.hasNext()) {
            ((g.a)localIterator.next()).a(paramInt, paramMultiTalkGroup);
          }
        }
        AppMethodBeat.o(183723);
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramMultiTalkGroup.run();
      AppMethodBeat.o(62694);
      return;
    }
    this.handler.post(paramMultiTalkGroup);
    AppMethodBeat.o(62694);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(62695);
    try
    {
      if (this.bPE.contains(parama)) {
        return;
      }
      this.bPE.add(parama);
      return;
    }
    finally
    {
      AppMethodBeat.o(62695);
    }
  }
  
  public final void eI(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(62698);
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(183712);
        synchronized (g.this.bPE)
        {
          ArrayList localArrayList = new ArrayList(g.this.bPE);
          ??? = localArrayList.iterator();
          if (((Iterator)???).hasNext()) {
            ((g.a)((Iterator)???).next()).eI(paramString, paramBoolean);
          }
        }
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramString.run();
      AppMethodBeat.o(62698);
      return;
    }
    this.handler.post(paramString);
    AppMethodBeat.o(62698);
  }
  
  public final void f(final MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(62697);
    paramMultiTalkGroup = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62589);
        synchronized (g.this.bPE)
        {
          Iterator localIterator = g.this.bPE.iterator();
          if (localIterator.hasNext()) {
            ((g.a)localIterator.next()).f(paramMultiTalkGroup);
          }
        }
        AppMethodBeat.o(62589);
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramMultiTalkGroup.run();
      AppMethodBeat.o(62697);
      return;
    }
    this.handler.post(paramMultiTalkGroup);
    AppMethodBeat.o(62697);
  }
  
  public final void onStateChanged(final int paramInt)
  {
    AppMethodBeat.i(62699);
    Runnable local13 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62553);
        synchronized (g.this.bPE)
        {
          Iterator localIterator = g.this.bPE.iterator();
          if (localIterator.hasNext()) {
            ((g.a)localIterator.next()).onStateChanged(paramInt);
          }
        }
        AppMethodBeat.o(62553);
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local13.run();
      AppMethodBeat.o(62699);
      return;
    }
    this.handler.post(local13);
    AppMethodBeat.o(62699);
  }
  
  public final void oz(final List<MultiTalkGroup> paramList)
  {
    AppMethodBeat.i(62693);
    paramList = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62792);
        synchronized (g.this.bPE)
        {
          Iterator localIterator = g.this.bPE.iterator();
          if (localIterator.hasNext()) {
            ((g.a)localIterator.next()).oz(paramList);
          }
        }
        AppMethodBeat.o(62792);
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramList.run();
      AppMethodBeat.o(62693);
      return;
    }
    this.handler.post(paramList);
    AppMethodBeat.o(62693);
  }
  
  public static abstract interface a
  {
    public abstract void L(int paramInt, Object paramObject);
    
    public abstract void N(String paramString, byte[] paramArrayOfByte);
    
    public abstract void a(int paramInt, MultiTalkGroup paramMultiTalkGroup);
    
    public abstract void aF(String paramString, int paramInt1, int paramInt2);
    
    public abstract void aJh(int paramInt);
    
    public abstract void aJi(int paramInt);
    
    public abstract void abC(int paramInt);
    
    public abstract void abH(int paramInt);
    
    public abstract void b(MultiTalkGroup paramMultiTalkGroup);
    
    public abstract void bNv();
    
    public abstract void c(MultiTalkGroup paramMultiTalkGroup, long paramLong);
    
    public abstract void d(MultiTalkGroup paramMultiTalkGroup, long paramLong);
    
    public abstract void eI(String paramString, boolean paramBoolean);
    
    public abstract void f(MultiTalkGroup paramMultiTalkGroup);
    
    public abstract void ggm();
    
    public abstract void ggn();
    
    public abstract void ggo();
    
    public abstract void iY(List<a.ar> paramList);
    
    public abstract void jF(String paramString, int paramInt);
    
    public abstract void keh();
    
    public abstract void kei();
    
    public abstract void onStateChanged(int paramInt);
    
    public abstract void oz(List<MultiTalkGroup> paramList);
    
    public abstract void yN(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g
 * JD-Core Version:    0.7.0.1
 */