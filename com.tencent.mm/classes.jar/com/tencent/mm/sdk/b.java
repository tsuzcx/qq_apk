package com.tencent.mm.sdk;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.c;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public final class b
  extends am
{
  public String yma;
  HashMap<a, LinkedList<Runnable>> ymb;
  
  public b(Handler.Callback paramCallback, am.a parama)
  {
    super(paramCallback, parama);
    AppMethodBeat.i(51945);
    this.yma = null;
    this.ymb = new HashMap();
    AppMethodBeat.o(51945);
  }
  
  public b(Looper paramLooper, Handler.Callback paramCallback, am.a parama)
  {
    super(paramLooper, paramCallback, parama);
    AppMethodBeat.i(51946);
    this.yma = null;
    this.ymb = new HashMap();
    AppMethodBeat.o(51946);
  }
  
  public b(Looper paramLooper, am.a parama)
  {
    super(paramLooper, parama);
    AppMethodBeat.i(51944);
    this.yma = null;
    this.ymb = new HashMap();
    AppMethodBeat.o(51944);
  }
  
  public b(am.a parama)
  {
    super(parama);
    AppMethodBeat.i(51943);
    this.yma = null;
    this.ymb = new HashMap();
    AppMethodBeat.o(51943);
  }
  
  public b(String paramString, Handler.Callback paramCallback, am.a parama)
  {
    super(Looper.getMainLooper(), paramCallback, parama);
    AppMethodBeat.i(51942);
    this.yma = null;
    this.ymb = new HashMap();
    this.yma = paramString;
    AppMethodBeat.o(51942);
  }
  
  private List<Runnable> a(Runnable paramRunnable, Object paramObject)
  {
    AppMethodBeat.i(51948);
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.ymb)
    {
      Iterator localIterator = this.ymb.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        a locala = (a)localEntry.getKey();
        if (((paramRunnable == null) || (locala.callback == paramRunnable)) && ((paramObject == null) || (paramObject == locala.yme)))
        {
          localLinkedList.addAll((Collection)localEntry.getValue());
          localIterator.remove();
        }
      }
    }
    AppMethodBeat.o(51948);
    return localLinkedList;
  }
  
  private List<Runnable> o(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(51949);
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.ymb)
    {
      Iterator localIterator = this.ymb.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        a locala = (a)localEntry.getKey();
        if ((locala.what == paramInt) && ((paramObject == null) || (paramObject == locala.yme)))
        {
          localLinkedList.addAll((Collection)localEntry.getValue());
          localIterator.remove();
        }
      }
    }
    AppMethodBeat.o(51949);
    return localLinkedList;
  }
  
  private boolean p(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(51950);
    synchronized (this.ymb)
    {
      Iterator localIterator = this.ymb.keySet().iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if ((locala.what == paramInt) && (locala.yme == paramObject))
        {
          AppMethodBeat.o(51950);
          return true;
        }
      }
      AppMethodBeat.o(51950);
      return false;
    }
  }
  
  public final void MY(int paramInt)
  {
    AppMethodBeat.i(51954);
    if (drZ())
    {
      List localList = o(paramInt, null);
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Runnable localRunnable = (Runnable)localIterator.next();
        d.ysn.ak(localRunnable);
      }
      localList.clear();
      AppMethodBeat.o(51954);
      return;
    }
    super.removeMessages(paramInt);
    AppMethodBeat.o(51954);
  }
  
  public final boolean MZ(int paramInt)
  {
    AppMethodBeat.i(51957);
    if (drZ())
    {
      bool = p(paramInt, null);
      AppMethodBeat.o(51957);
      return bool;
    }
    boolean bool = super.hasMessages(paramInt);
    AppMethodBeat.o(51957);
    return bool;
  }
  
  public final void a(Printer paramPrinter, String paramString)
  {
    AppMethodBeat.i(51960);
    if (drZ())
    {
      paramPrinter.println(paramString + "use ThreadPool");
      AppMethodBeat.o(51960);
      return;
    }
    super.dump(paramPrinter, paramString);
    AppMethodBeat.o(51960);
  }
  
  public final void ab(Runnable paramRunnable)
  {
    AppMethodBeat.i(51952);
    if (drZ())
    {
      paramRunnable = a(paramRunnable, null);
      Iterator localIterator = paramRunnable.iterator();
      while (localIterator.hasNext())
      {
        Runnable localRunnable = (Runnable)localIterator.next();
        d.ysn.ak(localRunnable);
      }
      paramRunnable.clear();
      AppMethodBeat.o(51952);
      return;
    }
    super.removeCallbacks(paramRunnable);
    AppMethodBeat.o(51952);
  }
  
  public final void b(Runnable paramRunnable, Object paramObject)
  {
    AppMethodBeat.i(51953);
    if (drZ())
    {
      paramRunnable = a(paramRunnable, paramObject);
      paramObject = paramRunnable.iterator();
      while (paramObject.hasNext())
      {
        Runnable localRunnable = (Runnable)paramObject.next();
        d.ysn.ak(localRunnable);
      }
      paramRunnable.clear();
      AppMethodBeat.o(51953);
      return;
    }
    super.removeCallbacks(paramRunnable, paramObject);
    AppMethodBeat.o(51953);
  }
  
  public final void cs(Object paramObject)
  {
    AppMethodBeat.i(51956);
    if (drZ())
    {
      d.ysm.remove(this.yma);
      paramObject = a(null, paramObject);
      Iterator localIterator = paramObject.iterator();
      while (localIterator.hasNext())
      {
        Runnable localRunnable = (Runnable)localIterator.next();
        d.ysn.ak(localRunnable);
      }
      paramObject.clear();
      AppMethodBeat.o(51956);
      return;
    }
    super.removeCallbacksAndMessages(paramObject);
    AppMethodBeat.o(51956);
  }
  
  public final boolean drZ()
  {
    AppMethodBeat.i(51951);
    if (!TextUtils.isEmpty(this.yma))
    {
      AppMethodBeat.o(51951);
      return true;
    }
    AppMethodBeat.o(51951);
    return false;
  }
  
  public final Looper dsa()
  {
    AppMethodBeat.i(51959);
    if (drZ())
    {
      AppMethodBeat.o(51959);
      return null;
    }
    Looper localLooper = super.getLooper();
    AppMethodBeat.o(51959);
    return localLooper;
  }
  
  public final void q(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(51955);
    if (drZ())
    {
      paramObject = o(paramInt, paramObject);
      Iterator localIterator = paramObject.iterator();
      while (localIterator.hasNext())
      {
        Runnable localRunnable = (Runnable)localIterator.next();
        d.ysn.ak(localRunnable);
      }
      paramObject.clear();
      AppMethodBeat.o(51955);
      return;
    }
    super.removeMessages(paramInt, paramObject);
    AppMethodBeat.o(51955);
  }
  
  public final boolean r(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(51958);
    if (drZ())
    {
      bool = p(paramInt, paramObject);
      AppMethodBeat.o(51958);
      return bool;
    }
    boolean bool = super.hasMessages(paramInt, paramObject);
    AppMethodBeat.o(51958);
    return bool;
  }
  
  public final boolean sendMessageAtTime(final Message paramMessage, long paramLong)
  {
    AppMethodBeat.i(51947);
    if (drZ())
    {
      Runnable local1 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(51939);
          b.this.dispatchMessage(paramMessage);
          b.a(b.this, paramMessage, this);
          AppMethodBeat.o(51939);
        }
      };
      synchronized (this.ymb)
      {
        a locala = new a(paramMessage.what, paramMessage.obj, paramMessage.getCallback());
        if (!this.ymb.containsKey(locala))
        {
          HashMap localHashMap2 = this.ymb;
          paramMessage = new LinkedList();
          localHashMap2.put(locala, paramMessage);
          paramMessage.add(local1);
          d.ysn.a(local1, this.yma, paramLong - SystemClock.uptimeMillis());
          AppMethodBeat.o(51947);
          return true;
        }
        paramMessage = (LinkedList)this.ymb.get(locala);
      }
    }
    boolean bool = super.sendMessageAtTime(paramMessage, paramLong);
    AppMethodBeat.o(51947);
    return bool;
  }
  
  final class a
  {
    Runnable callback;
    int what;
    Object yme;
    
    public a(int paramInt, Object paramObject, Runnable paramRunnable)
    {
      this.what = paramInt;
      this.yme = paramObject;
      this.callback = paramRunnable;
    }
    
    public final boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        bool1 = bool2;
        if (paramObject.what == this.what)
        {
          bool1 = bool2;
          if (paramObject.callback == this.callback)
          {
            bool1 = bool2;
            if (paramObject.yme == this.yme) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(51940);
      if (this.yme != null) {}
      for (int i = this.yme.hashCode();; i = 0)
      {
        if (this.callback != null) {
          j = this.callback.hashCode();
        }
        int k = this.what;
        AppMethodBeat.o(51940);
        return i + j + k;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(51941);
      String str = "WrapMessage{token=" + this.yme + ", what=" + this.what + ", callback=" + this.callback + '}';
      AppMethodBeat.o(51941);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.b
 * JD-Core Version:    0.7.0.1
 */