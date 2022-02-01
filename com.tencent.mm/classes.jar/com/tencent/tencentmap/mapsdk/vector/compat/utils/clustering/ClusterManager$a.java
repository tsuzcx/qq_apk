package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.ClusterRenderer;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

class ClusterManager$a
  extends AsyncTask<Float, Void, Set<? extends Cluster<T>>>
{
  private ClusterManager$a(ClusterManager paramClusterManager) {}
  
  protected Set<? extends Cluster<T>> a(Float... paramVarArgs)
  {
    AppMethodBeat.i(217733);
    ClusterManager.a(this.a).readLock().lock();
    try
    {
      if ((ClusterManager.b(this.a)) && (paramVarArgs != null)) {
        break label152;
      }
      paramVarArgs = new HashSet();
      Iterator localIterator = ClusterManager.c(this.a).getItems().iterator();
      while (localIterator.hasNext())
      {
        ClusterItem localClusterItem = (ClusterItem)localIterator.next();
        paramVarArgs.add(new ClusterManager.b(this.a, localClusterItem));
      }
      ClusterManager.a(this.a).readLock().unlock();
    }
    finally
    {
      ClusterManager.a(this.a).readLock().unlock();
      AppMethodBeat.o(217733);
    }
    AppMethodBeat.o(217733);
    return paramVarArgs;
    label152:
    paramVarArgs = ClusterManager.c(this.a).getClusters(paramVarArgs[0].floatValue());
    ClusterManager.a(this.a).readLock().unlock();
    AppMethodBeat.o(217733);
    return paramVarArgs;
  }
  
  protected void a(Set<? extends Cluster<T>> paramSet)
  {
    AppMethodBeat.i(217742);
    ClusterManager.d(this.a).onClustersChanged(paramSet);
    AppMethodBeat.o(217742);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager.a
 * JD-Core Version:    0.7.0.1
 */