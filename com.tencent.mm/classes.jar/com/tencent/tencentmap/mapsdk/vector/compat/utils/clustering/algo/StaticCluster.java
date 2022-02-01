package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StaticCluster<T extends ClusterItem>
  implements Cluster<T>
{
  private final LatLng a;
  private final List<T> b;
  
  public StaticCluster(LatLng paramLatLng)
  {
    AppMethodBeat.i(192233);
    this.b = new ArrayList();
    this.a = paramLatLng;
    AppMethodBeat.o(192233);
  }
  
  public boolean add(T paramT)
  {
    AppMethodBeat.i(192234);
    boolean bool = this.b.add(paramT);
    AppMethodBeat.o(192234);
    return bool;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(192238);
    if (!(paramObject instanceof StaticCluster))
    {
      AppMethodBeat.o(192238);
      return false;
    }
    if ((((StaticCluster)paramObject).a.equals(this.a)) && (((StaticCluster)paramObject).b.equals(this.b)))
    {
      AppMethodBeat.o(192238);
      return true;
    }
    AppMethodBeat.o(192238);
    return false;
  }
  
  public Collection<T> getItems()
  {
    return this.b;
  }
  
  public LatLng getPosition()
  {
    return this.a;
  }
  
  public int getSize()
  {
    AppMethodBeat.i(192236);
    int i = this.b.size();
    AppMethodBeat.o(192236);
    return i;
  }
  
  public boolean remove(T paramT)
  {
    AppMethodBeat.i(192235);
    boolean bool = this.b.remove(paramT);
    AppMethodBeat.o(192235);
    return bool;
  }
  
  public String toString()
  {
    AppMethodBeat.i(192237);
    String str = "StaticCluster{mCenter=" + this.a + ", mItems.size=" + this.b.size() + '}';
    AppMethodBeat.o(192237);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.StaticCluster
 * JD-Core Version:    0.7.0.1
 */