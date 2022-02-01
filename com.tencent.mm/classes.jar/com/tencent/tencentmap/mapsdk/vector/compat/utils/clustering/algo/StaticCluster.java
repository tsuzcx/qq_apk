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
    AppMethodBeat.i(192909);
    this.b = new ArrayList();
    this.a = paramLatLng;
    AppMethodBeat.o(192909);
  }
  
  public boolean add(T paramT)
  {
    AppMethodBeat.i(192910);
    boolean bool = this.b.add(paramT);
    AppMethodBeat.o(192910);
    return bool;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(192914);
    if (!(paramObject instanceof StaticCluster))
    {
      AppMethodBeat.o(192914);
      return false;
    }
    if ((((StaticCluster)paramObject).a.equals(this.a)) && (((StaticCluster)paramObject).b.equals(this.b)))
    {
      AppMethodBeat.o(192914);
      return true;
    }
    AppMethodBeat.o(192914);
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
    AppMethodBeat.i(192912);
    int i = this.b.size();
    AppMethodBeat.o(192912);
    return i;
  }
  
  public boolean remove(T paramT)
  {
    AppMethodBeat.i(192911);
    boolean bool = this.b.remove(paramT);
    AppMethodBeat.o(192911);
    return bool;
  }
  
  public String toString()
  {
    AppMethodBeat.i(192913);
    String str = "StaticCluster{mCenter=" + this.a + ", mItems.size=" + this.b.size() + '}';
    AppMethodBeat.o(192913);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.StaticCluster
 * JD-Core Version:    0.7.0.1
 */