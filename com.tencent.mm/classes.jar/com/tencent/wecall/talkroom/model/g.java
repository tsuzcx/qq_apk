package com.tencent.wecall.talkroom.model;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.b.a.a.a.as;
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
        AppMethodBeat.i(62662);
        synchronized (g.this.callbacks)
        {
          Iterator localIterator = g.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((g.a)localIterator.next()).a(paramInt, paramMultiTalkGroup);
          }
        }
        AppMethodBeat.o(62662);
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
  
  public final void dH(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(62698);
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62549);
        synchronized (g.this.callbacks)
        {
          ArrayList localArrayList = new ArrayList(g.this.callbacks);
          ??? = localArrayList.iterator();
          if (((Iterator)???).hasNext()) {
            ((g.a)((Iterator)???).next()).dH(paramString, paramBoolean);
          }
        }
        AppMethodBeat.o(62549);
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
        AppMethodBeat.i(62721);
        synchronized (g.this.callbacks)
        {
          Iterator localIterator = g.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((g.a)localIterator.next()).f(paramMultiTalkGroup);
          }
        }
        AppMethodBeat.o(62721);
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
  
  public final void hK(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(62700);
    com.tencent.pb.common.c.g.runOnMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(199669);
        synchronized (g.this.callbacks)
        {
          Iterator localIterator = g.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((g.a)localIterator.next()).hK(paramString, paramInt);
          }
        }
        AppMethodBeat.o(199669);
      }
    });
    AppMethodBeat.o(62700);
  }
  
  public final void ki(final List<MultiTalkGroup> paramList)
  {
    AppMethodBeat.i(62693);
    paramList = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62660);
        synchronized (g.this.callbacks)
        {
          Iterator localIterator = g.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((g.a)localIterator.next()).ki(paramList);
          }
        }
        AppMethodBeat.o(62660);
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
  
  public final void n(final int paramInt, final Object paramObject)
  {
    AppMethodBeat.i(62696);
    paramObject = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62688);
        synchronized (g.this.callbacks)
        {
          Iterator localIterator = g.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((g.a)localIterator.next()).n(paramInt, paramObject);
          }
        }
        AppMethodBeat.o(62688);
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
    Runnable local13 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(183712);
        synchronized (g.this.callbacks)
        {
          Iterator localIterator = g.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((g.a)localIterator.next()).onStateChanged(paramInt);
          }
        }
        AppMethodBeat.o(183712);
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
  
  public static abstract interface a
  {
    public abstract void F(String paramString, byte[] paramArrayOfByte);
    
    public abstract void Rd(int paramInt);
    
    public abstract void Ri(int paramInt);
    
    public abstract void a(int paramInt, MultiTalkGroup paramMultiTalkGroup);
    
    public abstract void asG(int paramInt);
    
    public abstract void asH(int paramInt);
    
    public abstract void b(MultiTalkGroup paramMultiTalkGroup);
    
    public abstract void bgz();
    
    public abstract void dH(String paramString, boolean paramBoolean);
    
    public abstract void enG();
    
    public abstract void enH();
    
    public abstract void enI();
    
    public abstract void f(MultiTalkGroup paramMultiTalkGroup);
    
    public abstract void fz(List<a.as> paramList);
    
    public abstract void hK(String paramString, int paramInt);
    
    public abstract void hrc();
    
    public abstract void hrd();
    
    public abstract void hre();
    
    public abstract void ki(List<MultiTalkGroup> paramList);
    
    public abstract void n(int paramInt, Object paramObject);
    
    public abstract void onStateChanged(int paramInt);
    
    public abstract void p(MultiTalkGroup paramMultiTalkGroup);
    
    public abstract void q(MultiTalkGroup paramMultiTalkGroup);
    
    public abstract void rv(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g
 * JD-Core Version:    0.7.0.1
 */