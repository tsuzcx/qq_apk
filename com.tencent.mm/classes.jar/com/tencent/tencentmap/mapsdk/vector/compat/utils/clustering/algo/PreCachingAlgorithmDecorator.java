package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo;

import androidx.b.e;
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
  private final e<Integer, Set<? extends Cluster<T>>> b;
  private final ReadWriteLock c;
  
  public PreCachingAlgorithmDecorator(Algorithm<T> paramAlgorithm)
  {
    AppMethodBeat.i(246992);
    this.b = new e(5);
    this.c = new ReentrantReadWriteLock();
    this.a = paramAlgorithm;
    AppMethodBeat.o(246992);
  }
  
  private Set<? extends Cluster<T>> a(int paramInt)
  {
    AppMethodBeat.i(247006);
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
    AppMethodBeat.o(247006);
    return localSet1;
  }
  
  private void a()
  {
    AppMethodBeat.i(247003);
    this.b.evictAll();
    AppMethodBeat.o(247003);
  }
  
  public void addItem(T paramT)
  {
    AppMethodBeat.i(246995);
    this.a.addItem(paramT);
    a();
    AppMethodBeat.o(246995);
  }
  
  public void addItems(Collection<T> paramCollection)
  {
    AppMethodBeat.i(246997);
    this.a.addItems(paramCollection);
    a();
    AppMethodBeat.o(246997);
  }
  
  public void clearItems()
  {
    AppMethodBeat.i(246999);
    this.a.clearItems();
    a();
    AppMethodBeat.o(246999);
  }
  
  public Algorithm getAlgorithm()
  {
    return this.a;
  }
  
  public Set<? extends Cluster<T>> getClusters(double paramDouble)
  {
    AppMethodBeat.i(247004);
    int i = (int)paramDouble;
    Set localSet = a(i);
    if (this.b.get(Integer.valueOf(i + 1)) == null) {
      new Thread(new PrecacheRunnable(i + 1)).start();
    }
    if (this.b.get(Integer.valueOf(i - 1)) == null) {
      new Thread(new PrecacheRunnable(i - 1)).start();
    }
    AppMethodBeat.o(247004);
    return localSet;
  }
  
  public Collection<T> getItems()
  {
    AppMethodBeat.i(247005);
    Collection localCollection = this.a.getItems();
    AppMethodBeat.o(247005);
    return localCollection;
  }
  
  public void removeItem(T paramT)
  {
    AppMethodBeat.i(247002);
    this.a.removeItem(paramT);
    a();
    AppMethodBeat.o(247002);
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
      AppMethodBeat.i(247010);
      try
      {
        Thread.sleep((Math.random() * 500.0D + 500.0D));
        label20:
        PreCachingAlgorithmDecorator.a(PreCachingAlgorithmDecorator.this, this.b);
        AppMethodBeat.o(247010);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label20;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.PreCachingAlgorithmDecorator
 * JD-Core Version:    0.7.0.1
 */