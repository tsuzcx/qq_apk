package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo;

import android.support.v4.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterItem;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PreCachingAlgorithmDecorator<T extends ClusterItem>
  implements Algorithm<T>
{
  private final Algorithm<T> a;
  private final h<Integer, Set<? extends Cluster<T>>> b;
  private final ReadWriteLock c;
  
  public PreCachingAlgorithmDecorator(Algorithm<T> paramAlgorithm)
  {
    AppMethodBeat.i(192223);
    this.b = new h(5);
    this.c = new ReentrantReadWriteLock();
    this.a = paramAlgorithm;
    AppMethodBeat.o(192223);
  }
  
  private Set<? extends Cluster<T>> a(int paramInt)
  {
    AppMethodBeat.i(192231);
    this.c.readLock().lock();
    Set localSet2 = (Set)this.b.get(Integer.valueOf(paramInt));
    this.c.readLock().unlock();
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      this.c.writeLock().lock();
      localSet2 = (Set)this.b.get(Integer.valueOf(paramInt));
      localSet1 = localSet2;
      if (localSet2 == null)
      {
        localSet1 = this.a.getClusters(paramInt);
        this.b.put(Integer.valueOf(paramInt), localSet1);
      }
      this.c.writeLock().unlock();
    }
    AppMethodBeat.o(192231);
    return localSet1;
  }
  
  private void a()
  {
    AppMethodBeat.i(192228);
    this.b.evictAll();
    AppMethodBeat.o(192228);
  }
  
  public void addItem(T paramT)
  {
    AppMethodBeat.i(192224);
    this.a.addItem(paramT);
    a();
    AppMethodBeat.o(192224);
  }
  
  public void addItems(Collection<T> paramCollection)
  {
    AppMethodBeat.i(192225);
    this.a.addItems(paramCollection);
    a();
    AppMethodBeat.o(192225);
  }
  
  public void clearItems()
  {
    AppMethodBeat.i(192226);
    this.a.clearItems();
    a();
    AppMethodBeat.o(192226);
  }
  
  public Algorithm getAlgorithm()
  {
    return this.a;
  }
  
  public Set<? extends Cluster<T>> getClusters(double paramDouble)
  {
    AppMethodBeat.i(192229);
    int i = (int)paramDouble;
    Set localSet = a(i);
    if (this.b.get(Integer.valueOf(i + 1)) == null) {
      new Thread(new PrecacheRunnable(i + 1)).start();
    }
    if (this.b.get(Integer.valueOf(i - 1)) == null) {
      new Thread(new PrecacheRunnable(i - 1)).start();
    }
    AppMethodBeat.o(192229);
    return localSet;
  }
  
  public Collection<T> getItems()
  {
    AppMethodBeat.i(192230);
    Collection localCollection = this.a.getItems();
    AppMethodBeat.o(192230);
    return localCollection;
  }
  
  public void removeItem(T paramT)
  {
    AppMethodBeat.i(192227);
    this.a.removeItem(paramT);
    a();
    AppMethodBeat.o(192227);
  }
  
  class PrecacheRunnable
    implements Runnable
  {
    private final int b;
    
    public PrecacheRunnable(int paramInt)
    {
      this.b = paramInt;
    }
    
    public void run()
    {
      AppMethodBeat.i(192222);
      try
      {
        Thread.sleep((Math.random() * 500.0D + 500.0D));
        label20:
        PreCachingAlgorithmDecorator.a(PreCachingAlgorithmDecorator.this, this.b);
        AppMethodBeat.o(192222);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label20;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.PreCachingAlgorithmDecorator
 * JD-Core Version:    0.7.0.1
 */