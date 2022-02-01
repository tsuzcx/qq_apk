package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo;

import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterItem;
import java.util.Collection;
import java.util.Set;

public abstract interface Algorithm<T extends ClusterItem>
{
  public abstract void addItem(T paramT);
  
  public abstract void addItems(Collection<T> paramCollection);
  
  public abstract void clearItems();
  
  public abstract Set<? extends Cluster<T>> getClusters(double paramDouble);
  
  public abstract Collection<T> getItems();
  
  public abstract void removeItem(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm
 * JD-Core Version:    0.7.0.1
 */