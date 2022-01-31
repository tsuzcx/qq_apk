package com.tencent.mm.sdk.platformtools;

import android.os.HandlerThread;
import android.os.Looper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class ax<K, V>
{
  public final am byQ;
  public volatile boolean byT = false;
  public final ab<K, a<V>> luc;
  protected Object tag;
  private final long threshold;
  private final long timeoutMillis;
  public final LinkedHashMap<K, b<K, V>> uhE = new LinkedHashMap();
  private final c<K, V> uhF;
  public final am uhG;
  private final long uhH;
  private boolean uhI = true;
  
  public ax(c<K, V> paramc, Looper paramLooper, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (paramc == null) {
      throw new IllegalArgumentException("arg appender can not be null!");
    }
    if (paramLooper == null) {
      throw new IllegalArgumentException("arg looper can not be null!");
    }
    if (paramInt1 <= 0) {
      throw new IllegalArgumentException("arg size can not be <= 0!");
    }
    this.uhF = paramc;
    this.luc = new ab(paramInt1);
    long l;
    if (paramInt2 > 0)
    {
      l = paramInt2;
      this.threshold = l;
      if (paramLong1 <= 0L) {
        break label191;
      }
      label107:
      this.uhH = paramLong1;
      if (paramLong2 <= 0L) {
        break label199;
      }
    }
    for (;;)
    {
      this.timeoutMillis = paramLong2;
      this.byQ = new am(paramLooper, new am.a()
      {
        public final boolean tC()
        {
          long l = System.currentTimeMillis();
          ax.this.mx(false);
          y.i("MicroMsg.RWCache", "summer timer onTimerExpired e appendAll takes: " + (System.currentTimeMillis() - l) + " ms");
          return false;
        }
      }, false);
      this.uhG = new am(new ai("RWCache_timeoutChecker").mnU.getLooper(), new am.a()
      {
        public final boolean tC()
        {
          ax.this.byT = true;
          return false;
        }
      }, false);
      return;
      l = 40L;
      break;
      label191:
      paramLong1 = 60000L;
      break label107;
      label199:
      paramLong2 = 60000L;
    }
  }
  
  public final V get(K paramK)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    a locala = (a)this.luc.get(paramK);
    if (locala != null) {
      return locala.uhK;
    }
    this.luc.put(paramK, new a(null));
    return null;
  }
  
  public final Object getTag()
  {
    return this.tag;
  }
  
  public final void mx(boolean paramBoolean)
  {
    y.i("MicroMsg.RWCache", "summer appendAll force: " + paramBoolean + " tid: " + Thread.currentThread().getId() + " holderMap size: " + this.uhE.size());
    try
    {
      this.uhI = true;
      if (this.uhE.isEmpty()) {
        return;
      }
      if (!this.uhF.Rw()) {
        return;
      }
    }
    finally {}
    Iterator localIterator = this.uhE.entrySet().iterator();
    if (paramBoolean) {
      while (localIterator.hasNext())
      {
        this.uhF.a(this, (b)((Map.Entry)localIterator.next()).getValue());
        localIterator.remove();
      }
    }
    this.byT = false;
    am localam = this.uhG;
    long l = this.timeoutMillis;
    localam.S(l, l);
    while ((!this.byT) && (localIterator.hasNext()))
    {
      this.uhF.a(this, (b)((Map.Entry)localIterator.next()).getValue());
      localIterator.remove();
    }
    if (this.byT) {
      y.i("MicroMsg.RWCache", "summer appendAll timeout size[%d] hasNext[%b] end", new Object[] { Integer.valueOf(this.uhE.size()), Boolean.valueOf(localIterator.hasNext()) });
    }
    this.uhG.stopTimer();
    this.uhF.Rx();
  }
  
  public final boolean n(K paramK, V paramV)
  {
    if (paramK == null) {
      throw new NullPointerException("key == null");
    }
    Object localObject = (a)this.luc.get(paramK);
    a locala = new a(paramV);
    if (locala.equals(localObject)) {
      return false;
    }
    this.luc.put(paramK, locala);
    localObject = new b();
    ((b)localObject).smD = paramK;
    ((b)localObject).values = paramV;
    int i;
    if (paramV == null)
    {
      i = 2;
      ((b)localObject).uhL = i;
    }
    for (;;)
    {
      try
      {
        this.uhE.put(paramK, localObject);
        if ((!this.uhI) || (this.uhE.size() <= this.threshold)) {
          break label157;
        }
        this.byQ.S(0L, 0L);
        this.uhI = false;
        return true;
      }
      finally {}
      i = 1;
      break;
      label157:
      if (this.byQ.crl())
      {
        paramK = this.byQ;
        long l = this.uhH;
        paramK.S(l, l);
      }
    }
  }
  
  public final void setTag(Object paramObject)
  {
    this.tag = paramObject;
  }
  
  static final class a<V>
  {
    final V uhK;
    
    a(V paramV)
    {
      this.uhK = paramV;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (paramObject == null) {}
      do
      {
        do
        {
          return false;
        } while (!(paramObject instanceof a));
        paramObject = (a)paramObject;
        if (this.uhK != null) {
          break;
        }
      } while (paramObject.uhK != null);
      return true;
      return this.uhK.equals(paramObject.uhK);
    }
  }
  
  public static final class b<K, V>
  {
    public K smD;
    public int uhL;
    public V values;
  }
  
  public static abstract interface c<K, V>
  {
    public abstract boolean Rw();
    
    public abstract void Rx();
    
    public abstract void a(ax<K, V> paramax, ax.b<K, V> paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ax
 * JD-Core Version:    0.7.0.1
 */