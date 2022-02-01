package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

class ClusterManager$b
  implements Cluster<T>
{
  private T b;
  private Set<T> c;
  
  public ClusterManager$b(T paramT)
  {
    AppMethodBeat.i(192243);
    Object localObject;
    this.b = localObject;
    this.c = Collections.singleton(this.b);
    AppMethodBeat.o(192243);
  }
  
  public Collection<T> getItems()
  {
    return this.c;
  }
  
  public LatLng getPosition()
  {
    AppMethodBeat.i(192244);
    LatLng localLatLng = this.b.getPosition();
    AppMethodBeat.o(192244);
    return localLatLng;
  }
  
  public int getSize()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager.b
 * JD-Core Version:    0.7.0.1
 */