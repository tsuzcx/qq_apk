package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo;

import android.support.v4.e.g;
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
    AppMethodBeat.i(192201);
    this.a = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(192201);
  }
  
  private static long a(long paramLong, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(192207);
    paramLong = (paramLong * Math.floor(paramDouble1) + Math.floor(paramDouble2));
    AppMethodBeat.o(192207);
    return paramLong;
  }
  
  public void addItem(T paramT)
  {
    AppMethodBeat.i(192202);
    this.a.add(paramT);
    AppMethodBeat.o(192202);
  }
  
  public void addItems(Collection<T> paramCollection)
  {
    AppMethodBeat.i(192203);
    this.a.addAll(paramCollection);
    AppMethodBeat.o(192203);
  }
  
  public void clearItems()
  {
    AppMethodBeat.i(192204);
    this.a.clear();
    AppMethodBeat.o(192204);
  }
  
  public Set<? extends Cluster<T>> getClusters(double paramDouble)
  {
    AppMethodBeat.i(192206);
    long l1 = Math.ceil(256.0D * Math.pow(2.0D, paramDouble) / 100.0D);
    c localc = new c(l1);
    HashSet localHashSet = new HashSet();
    g localg = new g();
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      if (localIterator.hasNext())
      {
        ClusterItem localClusterItem = (ClusterItem)localIterator.next();
        b localb = localc.a(localClusterItem.getPosition());
        long l2 = a(l1, localb.a, localb.b);
        StaticCluster localStaticCluster2 = (StaticCluster)localg.get(l2, null);
        StaticCluster localStaticCluster1 = localStaticCluster2;
        if (localStaticCluster2 == null)
        {
          localStaticCluster1 = new StaticCluster(localc.a(new b(Math.floor(localb.a) + 0.5D, Math.floor(localb.b) + 0.5D)));
          localg.put(l2, localStaticCluster1);
          localHashSet.add(localStaticCluster1);
        }
        localStaticCluster1.add(localClusterItem);
      }
    }
    AppMethodBeat.o(192206);
    return localHashSet;
  }
  
  public Collection<T> getItems()
  {
    return this.a;
  }
  
  public void removeItem(T paramT)
  {
    AppMethodBeat.i(192205);
    this.a.remove(paramT);
    AppMethodBeat.o(192205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.GridBasedAlgorithm
 * JD-Core Version:    0.7.0.1
 */