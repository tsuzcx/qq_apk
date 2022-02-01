package com.tencent.wecall.talkroom.model;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.ap;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g
{
  List<a> callbacks;
  Handler handler;
  
  public g()
  {
    AppMethodBeat.i(62692);
    this.callbacks = new LinkedList();
    this.handler = new Handler(Looper.getMainLooper());
    AppMethodBeat.o(62692);
  }
  
  public final void a(final int paramInt, final MultiTalkGroup paramMultiTalkGroup)
  {
    AppMethodBeat.i(62694);
    paramMultiTalkGroup = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62792);
        synchronized (g.this.callbacks)
        {
          Iterator localIterator = g.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((g.a)localIterator.next()).a(paramInt, paramMultiTalkGroup);
          }
        }
        AppMethodBeat.o(62792);
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
      if (this.callbacks.contains(parama)) {
        return;
      }
      this.callbacks.add(parama);
      return;
    }
    finally
    {
      AppMethodBeat.o(62695);
    }
  }
  
  public final void dj(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(62698);
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62555);
        synchronized (g.this.callbacks)
        {
          ArrayList localArrayList = new ArrayList(g.this.callbacks);
          ??? = localArrayList.iterator();
          if (((Iterator)???).hasNext()) {
            ((g.a)((Iterator)???).next()).dj(paramString, paramBoolean);
          }
        }
        AppMethodBeat.o(62555);
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
        AppMethodBeat.i(62601);
        synchronized (g.this.callbacks)
        {
          Iterator localIterator = g.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((g.a)localIterator.next()).f(paramMultiTalkGroup);
          }
        }
        AppMethodBeat.o(62601);
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
  
  public final void hf(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(62700);
    com.tencent.pb.common.c.g.runOnMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(183711);
        synchronized (g.this.callbacks)
        {
          Iterator localIterator = g.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((g.a)localIterator.next()).hf(paramString, paramInt);
          }
        }
        AppMethodBeat.o(183711);
      }
    });
    AppMethodBeat.o(62700);
  }
  
  public final void iS(final List<MultiTalkGroup> paramList)
  {
    AppMethodBeat.i(62693);
    paramList = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62602);
        synchronized (g.this.callbacks)
        {
          Iterator localIterator = g.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((g.a)localIterator.next()).iS(paramList);
          }
        }
        AppMethodBeat.o(62602);
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
  
  public final void m(final int paramInt, final Object paramObject)
  {
    AppMethodBeat.i(62696);
    paramObject = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62633);
        synchronized (g.this.callbacks)
        {
          Iterator localIterator = g.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((g.a)localIterator.next()).m(paramInt, paramObject);
          }
        }
        AppMethodBeat.o(62633);
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
  
  public final void onStateChanged(final int paramInt)
  {
    AppMethodBeat.i(62699);
    Runnable local12 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62549);
        synchronized (g.this.callbacks)
        {
          Iterator localIterator = g.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((g.a)localIterator.next()).onStateChanged(paramInt);
          }
        }
        AppMethodBeat.o(62549);
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local12.run();
      AppMethodBeat.o(62699);
      return;
    }
    this.handler.post(local12);
    AppMethodBeat.o(62699);
  }
  
  public static abstract interface a
  {
    public abstract void E(String paramString, byte[] paramArrayOfByte);
    
    public abstract void KD(int paramInt);
    
    public abstract void Ky(int paramInt);
    
    public abstract void a(int paramInt, MultiTalkGroup paramMultiTalkGroup);
    
    public abstract void aMb();
    
    public abstract void aio(int paramInt);
    
    public abstract void aip(int paramInt);
    
    public abstract void b(MultiTalkGroup paramMultiTalkGroup);
    
    public abstract void dj(String paramString, boolean paramBoolean);
    
    public abstract void dpZ();
    
    public abstract void dqa();
    
    public abstract void ez(List<a.ap> paramList);
    
    public abstract void f(MultiTalkGroup paramMultiTalkGroup);
    
    public abstract void fZA();
    
    public abstract void fZB();
    
    public abstract void fZC();
    
    public abstract void hf(String paramString, int paramInt);
    
    public abstract void iS(List<MultiTalkGroup> paramList);
    
    public abstract void m(int paramInt, Object paramObject);
    
    public abstract void o(MultiTalkGroup paramMultiTalkGroup);
    
    public abstract void oG(boolean paramBoolean);
    
    public abstract void onStateChanged(int paramInt);
    
    public abstract void p(MultiTalkGroup paramMultiTalkGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g
 * JD-Core Version:    0.7.0.1
 */