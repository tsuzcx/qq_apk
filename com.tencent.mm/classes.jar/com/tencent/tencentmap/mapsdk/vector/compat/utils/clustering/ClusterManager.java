package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering;

import android.content.Context;
import android.view.View;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.MarkerManager;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.MarkerManager.Collection;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.Algorithm;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.NonHierarchicalDistanceBasedAlgorithm;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.PreCachingAlgorithmDecorator;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.ClusterRenderer;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.DefaultClusterRenderer;
import java.util.Collection;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ClusterManager<T extends ClusterItem>
  implements TencentMap.InfoWindowAdapter, TencentMap.OnInfoWindowClickListener, TencentMap.OnMapCameraChangeListener, TencentMap.OnMarkerClickListener
{
  private final MarkerManager a;
  private final MarkerManager.Collection b;
  private final MarkerManager.Collection c;
  private Algorithm<T> d;
  private final ReadWriteLock e;
  private ClusterRenderer<T> f;
  private TencentMap g;
  private CameraPosition h;
  private ClusterManager<T>.a i;
  private final ReadWriteLock j;
  private boolean k;
  private OnClusterItemClickListener<T> l;
  private OnClusterInfoWindowClickListener<T> m;
  private ClusterInfoWindowAdapter<T> n;
  private OnClusterItemInfoWindowClickListener<T> o;
  private OnClusterClickListener<T> p;
  private ClusterItemInfoWindowAdapter<T> q;
  
  public ClusterManager(Context paramContext, TencentMap paramTencentMap)
  {
    this(paramContext, paramTencentMap, new MarkerManager(paramTencentMap));
    AppMethodBeat.i(217714);
    AppMethodBeat.o(217714);
  }
  
  private ClusterManager(Context paramContext, TencentMap paramTencentMap, MarkerManager paramMarkerManager)
  {
    AppMethodBeat.i(217725);
    this.e = new ReentrantReadWriteLock();
    this.j = new ReentrantReadWriteLock();
    this.k = true;
    this.g = paramTencentMap;
    this.a = paramMarkerManager;
    this.c = paramMarkerManager.a();
    this.b = paramMarkerManager.a();
    this.f = new DefaultClusterRenderer(paramContext, paramTencentMap, this);
    this.d = new PreCachingAlgorithmDecorator(new NonHierarchicalDistanceBasedAlgorithm(paramContext));
    this.i = new ClusterManager.a(this, null);
    this.f.onAdd();
    AppMethodBeat.o(217725);
  }
  
  public void addItem(T paramT)
  {
    AppMethodBeat.i(217870);
    this.e.writeLock().lock();
    try
    {
      this.d.addItem(paramT);
      return;
    }
    finally
    {
      this.e.writeLock().unlock();
      AppMethodBeat.o(217870);
    }
  }
  
  public void addItems(Collection<T> paramCollection)
  {
    AppMethodBeat.i(217866);
    this.e.writeLock().lock();
    try
    {
      this.d.addItems(paramCollection);
      return;
    }
    finally
    {
      this.e.writeLock().unlock();
      AppMethodBeat.o(217866);
    }
  }
  
  public void cancel()
  {
    AppMethodBeat.i(217888);
    clearItems();
    if (!this.i.cancel(true)) {
      this.f.cancel();
    }
    AppMethodBeat.o(217888);
  }
  
  public void clearItems()
  {
    AppMethodBeat.i(217847);
    this.e.writeLock().lock();
    try
    {
      this.d.clearItems();
      return;
    }
    finally
    {
      this.e.writeLock().unlock();
      AppMethodBeat.o(217847);
    }
  }
  
  /* Error */
  public void cluster()
  {
    // Byte code:
    //   0: ldc 195
    //   2: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 106	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager:j	Ljava/util/concurrent/locks/ReadWriteLock;
    //   9: invokeinterface 161 1 0
    //   14: invokeinterface 166 1 0
    //   19: aload_0
    //   20: getfield 143	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager:i	Lcom/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager$a;
    //   23: iconst_1
    //   24: invokevirtual 189	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager$a:cancel	(Z)Z
    //   27: pop
    //   28: aload_0
    //   29: new 33	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager$a
    //   32: dup
    //   33: aload_0
    //   34: aconst_null
    //   35: invokespecial 141	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager$a:<init>	(Lcom/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager;Lcom/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager$1;)V
    //   38: putfield 143	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager:i	Lcom/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager$a;
    //   41: getstatic 201	android/os/Build$VERSION:SDK_INT	I
    //   44: bipush 11
    //   46: if_icmpge +53 -> 99
    //   49: aload_0
    //   50: getfield 143	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager:i	Lcom/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager$a;
    //   53: iconst_1
    //   54: anewarray 203	java/lang/Float
    //   57: dup
    //   58: iconst_0
    //   59: aload_0
    //   60: getfield 110	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager:g	Lcom/tencent/tencentmap/mapsdk/map/TencentMap;
    //   63: invokeinterface 209 1 0
    //   68: invokevirtual 215	com/tencent/mapsdk/raster/model/CameraPosition:getZoom	()F
    //   71: invokestatic 219	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   74: aastore
    //   75: invokevirtual 223	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager$a:execute	([Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   78: pop
    //   79: aload_0
    //   80: getfield 106	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager:j	Ljava/util/concurrent/locks/ReadWriteLock;
    //   83: invokeinterface 161 1 0
    //   88: invokeinterface 173 1 0
    //   93: ldc 195
    //   95: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: return
    //   99: aload_0
    //   100: getfield 143	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager:i	Lcom/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager$a;
    //   103: getstatic 229	android/os/AsyncTask:THREAD_POOL_EXECUTOR	Ljava/util/concurrent/Executor;
    //   106: iconst_1
    //   107: anewarray 203	java/lang/Float
    //   110: dup
    //   111: iconst_0
    //   112: aload_0
    //   113: getfield 110	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager:g	Lcom/tencent/tencentmap/mapsdk/map/TencentMap;
    //   116: invokeinterface 209 1 0
    //   121: invokevirtual 215	com/tencent/mapsdk/raster/model/CameraPosition:getZoom	()F
    //   124: invokestatic 219	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   127: aastore
    //   128: invokevirtual 233	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager$a:executeOnExecutor	(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   131: pop
    //   132: goto -53 -> 79
    //   135: astore_1
    //   136: aload_0
    //   137: getfield 106	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager:j	Ljava/util/concurrent/locks/ReadWriteLock;
    //   140: invokeinterface 161 1 0
    //   145: invokeinterface 173 1 0
    //   150: ldc 195
    //   152: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aload_1
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	ClusterManager
    //   135	21	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   19	79	135	finally
    //   99	132	135	finally
  }
  
  public Algorithm<T> getAlgorithm()
  {
    return this.d;
  }
  
  public MarkerManager.Collection getClusterMarkerCollection()
  {
    return this.c;
  }
  
  public View getInfoWindow(Marker paramMarker)
  {
    AppMethodBeat.i(217911);
    paramMarker = getMarkerManager().getInfoWindow(paramMarker);
    AppMethodBeat.o(217911);
    return paramMarker;
  }
  
  public MarkerManager.Collection getMarkerCollection()
  {
    return this.b;
  }
  
  public MarkerManager getMarkerManager()
  {
    return this.a;
  }
  
  public ClusterRenderer<T> getRenderer()
  {
    return this.f;
  }
  
  public boolean isClusterEnabled()
  {
    return this.k;
  }
  
  public void onCameraChange(CameraPosition paramCameraPosition) {}
  
  public void onCameraChangeFinish(CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(217895);
    if (!this.k)
    {
      AppMethodBeat.o(217895);
      return;
    }
    if ((this.f instanceof TencentMap.OnMapCameraChangeListener)) {
      ((TencentMap.OnMapCameraChangeListener)this.f).onCameraChangeFinish(paramCameraPosition);
    }
    paramCameraPosition = this.g.getCameraPosition();
    if ((this.h != null) && (this.h.getZoom() == paramCameraPosition.getZoom()))
    {
      AppMethodBeat.o(217895);
      return;
    }
    this.h = this.g.getCameraPosition();
    cluster();
    AppMethodBeat.o(217895);
  }
  
  public void onInfoWindowClick(Marker paramMarker)
  {
    AppMethodBeat.i(217906);
    getMarkerManager().onInfoWindowClick(paramMarker);
    AppMethodBeat.o(217906);
  }
  
  public void onInfoWindowDettached(Marker paramMarker, View paramView) {}
  
  public boolean onMarkerClick(Marker paramMarker)
  {
    AppMethodBeat.i(217901);
    boolean bool = getMarkerManager().onMarkerClick(paramMarker);
    AppMethodBeat.o(217901);
    return bool;
  }
  
  public void removeItem(T paramT)
  {
    AppMethodBeat.i(217877);
    this.e.writeLock().lock();
    try
    {
      this.d.removeItem(paramT);
      return;
    }
    finally
    {
      this.e.writeLock().unlock();
      AppMethodBeat.o(217877);
    }
  }
  
  public void setAlgorithm(Algorithm<T> paramAlgorithm)
  {
    AppMethodBeat.i(217820);
    this.e.writeLock().lock();
    try
    {
      if (this.d != null) {
        paramAlgorithm.addItems(this.d.getItems());
      }
      this.d = new PreCachingAlgorithmDecorator(paramAlgorithm);
      this.e.writeLock().unlock();
      cluster();
      AppMethodBeat.o(217820);
      return;
    }
    finally
    {
      this.e.writeLock().unlock();
      AppMethodBeat.o(217820);
    }
  }
  
  public void setClusterEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(217859);
    if ((this.k ^ paramBoolean))
    {
      this.k = paramBoolean;
      cluster();
    }
    AppMethodBeat.o(217859);
  }
  
  public void setClusterInfoWindowAdapter(ClusterInfoWindowAdapter<T> paramClusterInfoWindowAdapter)
  {
    AppMethodBeat.i(217924);
    this.n = paramClusterInfoWindowAdapter;
    this.f.setInfoWindowAdapter(paramClusterInfoWindowAdapter);
    AppMethodBeat.o(217924);
  }
  
  public void setClusterItemInfoWindowAdapter(ClusterItemInfoWindowAdapter<T> paramClusterItemInfoWindowAdapter)
  {
    AppMethodBeat.i(217942);
    this.q = paramClusterItemInfoWindowAdapter;
    this.f.setItemInfoWindowAdapter(paramClusterItemInfoWindowAdapter);
    AppMethodBeat.o(217942);
  }
  
  public void setOnClusterClickListener(OnClusterClickListener<T> paramOnClusterClickListener)
  {
    AppMethodBeat.i(217918);
    this.p = paramOnClusterClickListener;
    this.f.setOnClusterClickListener(paramOnClusterClickListener);
    AppMethodBeat.o(217918);
  }
  
  public void setOnClusterInfoWindowClickListener(OnClusterInfoWindowClickListener<T> paramOnClusterInfoWindowClickListener)
  {
    AppMethodBeat.i(217922);
    this.m = paramOnClusterInfoWindowClickListener;
    this.f.setOnClusterInfoWindowClickListener(paramOnClusterInfoWindowClickListener);
    AppMethodBeat.o(217922);
  }
  
  public void setOnClusterItemClickListener(OnClusterItemClickListener<T> paramOnClusterItemClickListener)
  {
    AppMethodBeat.i(217931);
    this.l = paramOnClusterItemClickListener;
    this.f.setOnClusterItemClickListener(paramOnClusterItemClickListener);
    AppMethodBeat.o(217931);
  }
  
  public void setOnClusterItemInfoWindowClickListener(OnClusterItemInfoWindowClickListener<T> paramOnClusterItemInfoWindowClickListener)
  {
    AppMethodBeat.i(217937);
    this.o = paramOnClusterItemInfoWindowClickListener;
    this.f.setOnClusterItemInfoWindowClickListener(paramOnClusterItemInfoWindowClickListener);
    AppMethodBeat.o(217937);
  }
  
  public void setRenderer(ClusterRenderer<T> paramClusterRenderer)
  {
    AppMethodBeat.i(217801);
    this.f.setOnClusterClickListener(null);
    this.f.setOnClusterItemClickListener(null);
    this.c.a();
    this.b.a();
    this.f.onRemove();
    this.f = paramClusterRenderer;
    this.f.onAdd();
    this.f.setOnClusterClickListener(this.p);
    this.f.setOnClusterInfoWindowClickListener(this.m);
    this.f.setOnClusterItemClickListener(this.l);
    this.f.setOnClusterItemInfoWindowClickListener(this.o);
    cluster();
    AppMethodBeat.o(217801);
  }
  
  public static abstract interface ClusterInfoWindowAdapter<T extends ClusterItem>
  {
    public abstract View getInfoContents(Cluster<T> paramCluster);
    
    public abstract View getInfoWindow(Cluster<T> paramCluster);
    
    public abstract View getInfoWindowPressState(Cluster<T> paramCluster);
  }
  
  public static abstract interface ClusterItemInfoWindowAdapter<T extends ClusterItem>
  {
    public abstract View getInfoContents(T paramT);
    
    public abstract View getInfoWindow(T paramT);
    
    public abstract View getInfoWindowPressState(T paramT);
  }
  
  public static abstract interface OnClusterClickListener<T extends ClusterItem>
  {
    public abstract boolean onClusterClick(Cluster<T> paramCluster);
  }
  
  public static abstract interface OnClusterInfoWindowClickListener<T extends ClusterItem>
  {
    public abstract void onClusterInfoWindowClick(Cluster<T> paramCluster);
  }
  
  public static abstract interface OnClusterItemClickListener<T extends ClusterItem>
  {
    public abstract boolean onClusterItemClick(T paramT);
  }
  
  public static abstract interface OnClusterItemInfoWindowClickListener<T extends ClusterItem>
  {
    public abstract void onClusterItemInfoWindowClick(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager
 * JD-Core Version:    0.7.0.1
 */