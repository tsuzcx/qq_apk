package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view;

import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterItem;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager.ClusterInfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager.ClusterItemInfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager.OnClusterClickListener;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager.OnClusterInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager.OnClusterItemClickListener;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager.OnClusterItemInfoWindowClickListener;
import java.util.Set;

public abstract interface ClusterRenderer<T extends ClusterItem>
{
  public abstract void cancel();
  
  public abstract void onAdd();
  
  public abstract void onClustersChanged(Set<? extends Cluster<T>> paramSet);
  
  public abstract void onRemove();
  
  public abstract void setInfoWindowAdapter(ClusterManager.ClusterInfoWindowAdapter paramClusterInfoWindowAdapter);
  
  public abstract void setItemInfoWindowAdapter(ClusterManager.ClusterItemInfoWindowAdapter paramClusterItemInfoWindowAdapter);
  
  public abstract void setOnClusterClickListener(ClusterManager.OnClusterClickListener<T> paramOnClusterClickListener);
  
  public abstract void setOnClusterInfoWindowClickListener(ClusterManager.OnClusterInfoWindowClickListener<T> paramOnClusterInfoWindowClickListener);
  
  public abstract void setOnClusterItemClickListener(ClusterManager.OnClusterItemClickListener<T> paramOnClusterItemClickListener);
  
  public abstract void setOnClusterItemInfoWindowClickListener(ClusterManager.OnClusterItemInfoWindowClickListener<T> paramOnClusterItemInfoWindowClickListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.ClusterRenderer
 * JD-Core Version:    0.7.0.1
 */