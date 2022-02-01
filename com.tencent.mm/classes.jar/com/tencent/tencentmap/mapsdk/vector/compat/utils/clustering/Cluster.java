package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering;

import com.tencent.mapsdk.raster.model.LatLng;
import java.util.Collection;

public abstract interface Cluster<T extends ClusterItem>
{
  public abstract Collection<T> getItems();
  
  public abstract LatLng getPosition();
  
  public abstract int getSize();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster
 * JD-Core Version:    0.7.0.1
 */