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
        AppMethodBeat.i(62660);
        synchronized (g.this.callbacks)
        {
          Iterator localIterator = g.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((g.a)localIterator.next()).a(paramInt, paramMultiTalkGroup);
          }
        }
        AppMethodBeat.o(62660);
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
  
  public final void cZ(final String paramString, final boolean paramBoolean)
  {
    AppMethodBeat.i(62698);
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62589);
        synchronized (g.this.callbacks)
        {
          ArrayList localArrayList = new ArrayList(g.this.callbacks);
          ??? = localArrayList.iterator();
          if (((Iterator)???).hasNext()) {
            ((g.a)((Iterator)???).next()).cZ(paramString, paramBoolean);
          }
        }
        AppMethodBeat.o(62589);
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
        AppMethodBeat.i(62688);
        synchronized (g.this.callbacks)
        {
          Iterator localIterator = g.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((g.a)localIterator.next()).f(paramMultiTalkGroup);
          }
        }
        AppMethodBeat.o(62688);
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
  
  public final void gC(final String paramString, final int paramInt)
  {
    AppMethodBeat.i(62700);
    com.tencent.pb.common.c.g.runOnMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62584);
        synchronized (g.this.callbacks)
        {
          Iterator localIterator = g.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((g.a)localIterator.next()).gC(paramString, paramInt);
          }
        }
        AppMethodBeat.o(62584);
      }
    });
    AppMethodBeat.o(62700);
  }
  
  public final void ir(final List<MultiTalkGroup> paramList)
  {
    AppMethodBeat.i(62693);
    paramList = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62687);
        synchronized (g.this.callbacks)
        {
          Iterator localIterator = g.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((g.a)localIterator.next()).ir(paramList);
          }
        }
        AppMethodBeat.o(62687);
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
        AppMethodBeat.i(183723);
        synchronized (g.this.callbacks)
        {
          Iterator localIterator = g.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((g.a)localIterator.next()).n(paramInt, paramObject);
          }
        }
        AppMethodBeat.o(183723);
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
    Runnable local10 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(62555);
        synchronized (g.this.callbacks)
        {
          Iterator localIterator = g.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((g.a)localIterator.next()).onStateChanged(paramInt);
          }
        }
        AppMethodBeat.o(62555);
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local10.run();
      AppMethodBeat.o(62699);
      return;
    }
    this.handler.post(local10);
    AppMethodBeat.o(62699);
  }
  
  public static abstract interface a
  {
    public abstract void E(String paramString, byte[] paramArrayOfByte);
    
    public abstract void Hh(int paramInt);
    
    public abstract void a(int paramInt, MultiTalkGroup paramMultiTalkGroup);
    
    public abstract void aCb();
    
    public abstract void acS(int paramInt);
    
    public abstract void acT(int paramInt);
    
    public abstract void b(MultiTalkGroup paramMultiTalkGroup);
    
    public abstract void cSr();
    
    public abstract void cSs();
    
    public abstract void cZ(String paramString, boolean paramBoolean);
    
    public abstract void ei(List<a.ap> paramList);
    
    public abstract void f(MultiTalkGroup paramMultiTalkGroup);
    
    public abstract void fpO();
    
    public abstract void fpP();
    
    public abstract void fpQ();
    
    public abstract void gC(String paramString, int paramInt);
    
    public abstract void ir(List<MultiTalkGroup> paramList);
    
    public abstract void n(int paramInt, Object paramObject);
    
    public abstract void ns(boolean paramBoolean);
    
    public abstract void o(MultiTalkGroup paramMultiTalkGroup);
    
    public abstract void onStateChanged(int paramInt);
    
    public abstract void p(MultiTalkGroup paramMultiTalkGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wecall.talkroom.model.g
 * JD-Core Version:    0.7.0.1
 */