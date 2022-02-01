package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo;

import androidx.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.b;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.c;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterItem;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GridBasedAlgorithm<T extends ClusterItem>
  implements Algorithm<T>
{
  private final Set<T> a;
  
  public GridBasedAlgorithm()
  {
    AppMethodBeat.i(246978);
    this.a = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(246978);
  }
  
  private static long a(long paramLong, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(246987);
    paramLong = (paramLong * Math.floor(paramDouble1) + Math.floor(paramDouble2));
    AppMethodBeat.o(246987);
    return paramLong;
  }
  
  public void addItem(T paramT)
  {
    AppMethodBeat.i(246979);
    this.a.add(paramT);
    AppMethodBeat.o(246979);
  }
  
  public void addItems(Collection<T> paramCollection)
  {
    AppMethodBeat.i(246980);
    this.a.addAll(paramCollection);
    AppMethodBeat.o(246980);
  }
  
  public void clearItems()
  {
    AppMethodBeat.i(246982);
    this.a.clear();
    AppMethodBeat.o(246982);
  }
  
  public Set<? extends Cluster<T>> getClusters(double paramDouble)
  {
    AppMethodBeat.i(246986);
    long l1 = Math.ceil(256.0D * Math.pow(2.0D, paramDouble) / 100.0D);
    c localc = new c(l1);
    HashSet localHashSet = new HashSet();
    d locald = new d();
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      if (localIterator.hasNext())
      {
        ClusterItem localClusterItem = (ClusterItem)localIterator.next();
        b localb = localc.a(localClusterItem.getPosition());
        long l2 = a(l1, localb.a, localb.b);
        StaticCluster localStaticCluster2 = (StaticCluster)locald.get(l2, null);
        StaticCluster localStaticCluster1 = localStaticCluster2;
        if (localStaticCluster2 == null)
        {
          localStaticCluster1 = new StaticCluster(localc.a(new b(Math.floor(localb.a) + 0.5D, Math.floor(localb.b) + 0.5D)));
          locald.a(l2, localStaticCluster1);
          localHashSet.add(localStaticCluster1);
        }
        localStaticCluster1.add(localClusterItem);
      }
    }
    AppMethodBeat.o(246986);
    return localHashSet;
  }
  
  public Collection<T> getItems()
  {
    return this.a;
  }
  
  public void removeItem(T paramT)
  {
    AppMethodBeat.i(246984);
    this.a.remove(paramT);
    AppMethodBeat.o(246984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.GridBasedAlgorithm
 * JD-Core Version:    0.7.0.1
 */