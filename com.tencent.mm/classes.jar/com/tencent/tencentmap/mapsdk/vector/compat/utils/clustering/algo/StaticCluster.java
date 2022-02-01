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
    AppMethodBeat.i(217579);
    this.b = new ArrayList();
    this.a = paramLatLng;
    AppMethodBeat.o(217579);
  }
  
  public boolean add(T paramT)
  {
    AppMethodBeat.i(217580);
    boolean bool = this.b.add(paramT);
    AppMethodBeat.o(217580);
    return bool;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(217584);
    if (!(paramObject instanceof StaticCluster))
    {
      AppMethodBeat.o(217584);
      return false;
    }
    if ((((StaticCluster)paramObject).a.equals(this.a)) && (((StaticCluster)paramObject).b.equals(this.b)))
    {
      AppMethodBeat.o(217584);
      return true;
    }
    AppMethodBeat.o(217584);
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
    AppMethodBeat.i(217582);
    int i = this.b.size();
    AppMethodBeat.o(217582);
    return i;
  }
  
  public boolean remove(T paramT)
  {
    AppMethodBeat.i(217581);
    boolean bool = this.b.remove(paramT);
    AppMethodBeat.o(217581);
    return bool;
  }
  
  public String toString()
  {
    AppMethodBeat.i(217583);
    String str = "StaticCluster{mCenter=" + this.a + ", mItems.size=" + this.b.size() + '}';
    AppMethodBeat.o(217583);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.StaticCluster
 * JD-Core Version:    0.7.0.1
 */