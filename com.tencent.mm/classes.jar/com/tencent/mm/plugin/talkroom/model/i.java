package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.d;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
{
  List<d> callbacks;
  aq handler;
  
  public i()
  {
    AppMethodBeat.i(29541);
    this.callbacks = new LinkedList();
    this.handler = new aq(Looper.getMainLooper());
    AppMethodBeat.o(29541);
  }
  
  public final void Hk(final String paramString)
  {
    AppMethodBeat.i(29545);
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29536);
        synchronized (i.this.callbacks)
        {
          Iterator localIterator = i.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((d)localIterator.next()).Hk(paramString);
          }
        }
        AppMethodBeat.o(29536);
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramString.run();
      AppMethodBeat.o(29545);
      return;
    }
    this.handler.post(paramString);
    AppMethodBeat.o(29545);
  }
  
  public final void aMA()
  {
    AppMethodBeat.i(29547);
    Runnable local12 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29540);
        synchronized (i.this.callbacks)
        {
          Iterator localIterator = i.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((d)localIterator.next()).aMA();
          }
        }
        AppMethodBeat.o(29540);
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local12.run();
      AppMethodBeat.o(29547);
      return;
    }
    this.handler.post(local12);
    AppMethodBeat.o(29547);
  }
  
  public final void aMD()
  {
    AppMethodBeat.i(29548);
    Runnable local4 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29532);
        synchronized (i.this.callbacks)
        {
          Iterator localIterator = i.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((d)localIterator.next()).aMD();
          }
        }
        AppMethodBeat.o(29532);
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local4.run();
      AppMethodBeat.o(29548);
      return;
    }
    this.handler.post(local4);
    AppMethodBeat.o(29548);
  }
  
  public final void aMy()
  {
    AppMethodBeat.i(29542);
    Runnable local1 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29529);
        synchronized (i.this.callbacks)
        {
          Iterator localIterator = i.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((d)localIterator.next()).aMy();
          }
        }
        AppMethodBeat.o(29529);
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local1.run();
      AppMethodBeat.o(29542);
      return;
    }
    this.handler.post(local1);
    AppMethodBeat.o(29542);
  }
  
  public final void j(final int paramInt1, final int paramInt2, final String paramString)
  {
    AppMethodBeat.i(29546);
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29537);
        synchronized (i.this.callbacks)
        {
          Iterator localIterator = i.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((d)localIterator.next()).j(paramInt1, paramInt2, paramString);
          }
        }
        AppMethodBeat.o(29537);
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramString.run();
      AppMethodBeat.o(29546);
      return;
    }
    this.handler.post(paramString);
    AppMethodBeat.o(29546);
  }
  
  public final void qk(final int paramInt)
  {
    AppMethodBeat.i(29544);
    Runnable local7 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29535);
        synchronized (i.this.callbacks)
        {
          Iterator localIterator = i.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((d)localIterator.next()).qk(paramInt);
          }
        }
        AppMethodBeat.o(29535);
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      local7.run();
      AppMethodBeat.o(29544);
      return;
    }
    this.handler.post(local7);
    AppMethodBeat.o(29544);
  }
  
  public final void s(final String paramString, final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(29543);
    paramString = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(29533);
        synchronized (i.this.callbacks)
        {
          Iterator localIterator = i.this.callbacks.iterator();
          if (localIterator.hasNext()) {
            ((d)localIterator.next()).s(paramString, paramInt1, paramInt2);
          }
        }
        AppMethodBeat.o(29533);
      }
    };
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramString.run();
      AppMethodBeat.o(29543);
      return;
    }
    this.handler.post(paramString);
    AppMethodBeat.o(29543);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.talkroom.model.i
 * JD-Core Version:    0.7.0.1
 */