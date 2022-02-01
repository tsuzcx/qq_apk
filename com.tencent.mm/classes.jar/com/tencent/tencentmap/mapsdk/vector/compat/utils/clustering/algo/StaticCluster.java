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
    AppMethodBeat.i(199502);
    this.b = new ArrayList();
    this.a = paramLatLng;
    AppMethodBeat.o(199502);
  }
  
  public boolean add(T paramT)
  {
    AppMethodBeat.i(199503);
    boolean bool = this.b.add(paramT);
    AppMethodBeat.o(199503);
    return bool;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(199507);
    if (!(paramObject instanceof StaticCluster))
    {
      AppMethodBeat.o(199507);
      return false;
    }
    if ((((StaticCluster)paramObject).a.equals(this.a)) && (((StaticCluster)paramObject).b.equals(this.b)))
    {
      AppMethodBeat.o(199507);
      return true;
    }
    AppMethodBeat.o(199507);
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
    AppMethodBeat.i(199505);
    int i = this.b.size();
    AppMethodBeat.o(199505);
    return i;
  }
  
  public boolean remove(T paramT)
  {
    AppMethodBeat.i(199504);
    boolean bool = this.b.remove(paramT);
    AppMethodBeat.o(199504);
    return bool;
  }
  
  public String toString()
  {
    AppMethodBeat.i(199506);
    String str = "StaticCluster{mCenter=" + this.a + ", mItems.size=" + this.b.size() + '}';
    AppMethodBeat.o(199506);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.StaticCluster
 * JD-Core Version:    0.7.0.1
 */