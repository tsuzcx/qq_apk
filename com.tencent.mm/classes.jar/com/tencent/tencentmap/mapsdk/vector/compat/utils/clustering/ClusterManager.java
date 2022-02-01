package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
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
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
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
    AppMethodBeat.i(192947);
    AppMethodBeat.o(192947);
  }
  
  private ClusterManager(Context paramContext, TencentMap paramTencentMap, MarkerManager paramMarkerManager)
  {
    AppMethodBeat.i(192948);
    this.e = new ReentrantReadWriteLock();
    this.j = new ReentrantReadWriteLock();
    this.k = true;
    this.g = paramTencentMap;
    this.a = paramMarkerManager;
    this.c = paramMarkerManager.a();
    this.b = paramMarkerManager.a();
    this.f = new DefaultClusterRenderer(paramContext, paramTencentMap, this);
    this.d = new PreCachingAlgorithmDecorator(new NonHierarchicalDistanceBasedAlgorithm(paramContext));
    this.i = new a(null);
    this.f.onAdd();
    AppMethodBeat.o(192948);
  }
  
  public void addItem(T paramT)
  {
    AppMethodBeat.i(192954);
    this.e.writeLock().lock();
    try
    {
      this.d.addItem(paramT);
      return;
    }
    finally
    {
      this.e.writeLock().unlock();
      AppMethodBeat.o(192954);
    }
  }
  
  public void addItems(Collection<T> paramCollection)
  {
    AppMethodBeat.i(192953);
    this.e.writeLock().lock();
    try
    {
      this.d.addItems(paramCollection);
      return;
    }
    finally
    {
      this.e.writeLock().unlock();
      AppMethodBeat.o(192953);
    }
  }
  
  public void cancel()
  {
    AppMethodBeat.i(192957);
    clearItems();
    if (!this.i.cancel(true)) {
      this.f.cancel();
    }
    AppMethodBeat.o(192957);
  }
  
  public void clearItems()
  {
    AppMethodBeat.i(192951);
    this.e.writeLock().lock();
    try
    {
      this.d.clearItems();
      return;
    }
    finally
    {
      this.e.writeLock().unlock();
      AppMethodBeat.o(192951);
    }
  }
  
  /* Error */
  public void cluster()
  {
    // Byte code:
    //   0: ldc 197
    //   2: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 108	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager:j	Ljava/util/concurrent/locks/ReadWriteLock;
    //   9: invokeinterface 163 1 0
    //   14: invokeinterface 168 1 0
    //   19: aload_0
    //   20: getfield 145	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager:i	Lcom/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager$a;
    //   23: iconst_1
    //   24: invokevirtual 191	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager$a:cancel	(Z)Z
    //   27: pop
    //   28: aload_0
    //   29: new 35	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager$a
    //   32: dup
    //   33: aload_0
    //   34: aconst_null
    //   35: invokespecial 143	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager$a:<init>	(Lcom/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager;Lcom/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager$1;)V
    //   38: putfield 145	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager:i	Lcom/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager$a;
    //   41: getstatic 203	android/os/Build$VERSION:SDK_INT	I
    //   44: bipush 11
    //   46: if_icmpge +53 -> 99
    //   49: aload_0
    //   50: getfield 145	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager:i	Lcom/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager$a;
    //   53: iconst_1
    //   54: anewarray 205	java/lang/Float
    //   57: dup
    //   58: iconst_0
    //   59: aload_0
    //   60: getfield 112	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager:g	Lcom/tencent/tencentmap/mapsdk/map/TencentMap;
    //   63: invokeinterface 211 1 0
    //   68: invokevirtual 217	com/tencent/mapsdk/raster/model/CameraPosition:getZoom	()F
    //   71: invokestatic 221	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   74: aastore
    //   75: invokevirtual 225	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager$a:execute	([Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   78: pop
    //   79: aload_0
    //   80: getfield 108	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager:j	Ljava/util/concurrent/locks/ReadWriteLock;
    //   83: invokeinterface 163 1 0
    //   88: invokeinterface 175 1 0
    //   93: ldc 197
    //   95: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: return
    //   99: aload_0
    //   100: getfield 145	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager:i	Lcom/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager$a;
    //   103: getstatic 231	android/os/AsyncTask:THREAD_POOL_EXECUTOR	Ljava/util/concurrent/Executor;
    //   106: iconst_1
    //   107: anewarray 205	java/lang/Float
    //   110: dup
    //   111: iconst_0
    //   112: aload_0
    //   113: getfield 112	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager:g	Lcom/tencent/tencentmap/mapsdk/map/TencentMap;
    //   116: invokeinterface 211 1 0
    //   121: invokevirtual 217	com/tencent/mapsdk/raster/model/CameraPosition:getZoom	()F
    //   124: invokestatic 221	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   127: aastore
    //   128: invokevirtual 235	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager$a:executeOnExecutor	(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;
    //   131: pop
    //   132: goto -53 -> 79
    //   135: astore_1
    //   136: aload_0
    //   137: getfield 108	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/ClusterManager:j	Ljava/util/concurrent/locks/ReadWriteLock;
    //   140: invokeinterface 163 1 0
    //   145: invokeinterface 175 1 0
    //   150: ldc 197
    //   152: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(192961);
    paramMarker = getMarkerManager().getInfoWindow(paramMarker);
    AppMethodBeat.o(192961);
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
    AppMethodBeat.i(192958);
    if (!this.k)
    {
      AppMethodBeat.o(192958);
      return;
    }
    if ((this.f instanceof TencentMap.OnMapCameraChangeListener)) {
      ((TencentMap.OnMapCameraChangeListener)this.f).onCameraChangeFinish(paramCameraPosition);
    }
    paramCameraPosition = this.g.getCameraPosition();
    if ((this.h != null) && (this.h.getZoom() == paramCameraPosition.getZoom()))
    {
      AppMethodBeat.o(192958);
      return;
    }
    this.h = this.g.getCameraPosition();
    cluster();
    AppMethodBeat.o(192958);
  }
  
  public void onInfoWindowClick(Marker paramMarker)
  {
    AppMethodBeat.i(192960);
    getMarkerManager().onInfoWindowClick(paramMarker);
    AppMethodBeat.o(192960);
  }
  
  public void onInfoWindowDettached(Marker paramMarker, View paramView) {}
  
  public boolean onMarkerClick(Marker paramMarker)
  {
    AppMethodBeat.i(192959);
    boolean bool = getMarkerManager().onMarkerClick(paramMarker);
    AppMethodBeat.o(192959);
    return bool;
  }
  
  public void removeItem(T paramT)
  {
    AppMethodBeat.i(192955);
    this.e.writeLock().lock();
    try
    {
      this.d.removeItem(paramT);
      return;
    }
    finally
    {
      this.e.writeLock().unlock();
      AppMethodBeat.o(192955);
    }
  }
  
  public void setAlgorithm(Algorithm<T> paramAlgorithm)
  {
    AppMethodBeat.i(192950);
    this.e.writeLock().lock();
    try
    {
      if (this.d != null) {
        paramAlgorithm.addItems(this.d.getItems());
      }
      this.d = new PreCachingAlgorithmDecorator(paramAlgorithm);
      this.e.writeLock().unlock();
      cluster();
      AppMethodBeat.o(192950);
      return;
    }
    finally
    {
      this.e.writeLock().unlock();
      AppMethodBeat.o(192950);
    }
  }
  
  public void setClusterEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(192952);
    if ((this.k ^ paramBoolean))
    {
      this.k = paramBoolean;
      cluster();
    }
    AppMethodBeat.o(192952);
  }
  
  public void setClusterInfoWindowAdapter(ClusterInfoWindowAdapter<T> paramClusterInfoWindowAdapter)
  {
    AppMethodBeat.i(192964);
    this.n = paramClusterInfoWindowAdapter;
    this.f.setInfoWindowAdapter(paramClusterInfoWindowAdapter);
    AppMethodBeat.o(192964);
  }
  
  public void setClusterItemInfoWindowAdapter(ClusterItemInfoWindowAdapter<T> paramClusterItemInfoWindowAdapter)
  {
    AppMethodBeat.i(192967);
    this.q = paramClusterItemInfoWindowAdapter;
    this.f.setItemInfoWindowAdapter(paramClusterItemInfoWindowAdapter);
    AppMethodBeat.o(192967);
  }
  
  public void setOnClusterClickListener(OnClusterClickListener<T> paramOnClusterClickListener)
  {
    AppMethodBeat.i(192962);
    this.p = paramOnClusterClickListener;
    this.f.setOnClusterClickListener(paramOnClusterClickListener);
    AppMethodBeat.o(192962);
  }
  
  public void setOnClusterInfoWindowClickListener(OnClusterInfoWindowClickListener<T> paramOnClusterInfoWindowClickListener)
  {
    AppMethodBeat.i(192963);
    this.m = paramOnClusterInfoWindowClickListener;
    this.f.setOnClusterInfoWindowClickListener(paramOnClusterInfoWindowClickListener);
    AppMethodBeat.o(192963);
  }
  
  public void setOnClusterItemClickListener(OnClusterItemClickListener<T> paramOnClusterItemClickListener)
  {
    AppMethodBeat.i(192965);
    this.l = paramOnClusterItemClickListener;
    this.f.setOnClusterItemClickListener(paramOnClusterItemClickListener);
    AppMethodBeat.o(192965);
  }
  
  public void setOnClusterItemInfoWindowClickListener(OnClusterItemInfoWindowClickListener<T> paramOnClusterItemInfoWindowClickListener)
  {
    AppMethodBeat.i(192966);
    this.o = paramOnClusterItemInfoWindowClickListener;
    this.f.setOnClusterItemInfoWindowClickListener(paramOnClusterItemInfoWindowClickListener);
    AppMethodBeat.o(192966);
  }
  
  public void setRenderer(ClusterRenderer<T> paramClusterRenderer)
  {
    AppMethodBeat.i(192949);
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
    AppMethodBeat.o(192949);
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
  
  class a
    extends AsyncTask<Float, Void, Set<? extends Cluster<T>>>
  {
    private a() {}
    
    protected Set<? extends Cluster<T>> a(Float... paramVarArgs)
    {
      AppMethodBeat.i(193027);
      ClusterManager.a(ClusterManager.this).readLock().lock();
      try
      {
        if ((ClusterManager.b(ClusterManager.this)) && (paramVarArgs != null)) {
          break label152;
        }
        paramVarArgs = new HashSet();
        Iterator localIterator = ClusterManager.c(ClusterManager.this).getItems().iterator();
        while (localIterator.hasNext())
        {
          ClusterItem localClusterItem = (ClusterItem)localIterator.next();
          paramVarArgs.add(new ClusterManager.b(ClusterManager.this, localClusterItem));
        }
        ClusterManager.a(ClusterManager.this).readLock().unlock();
      }
      finally
      {
        ClusterManager.a(ClusterManager.this).readLock().unlock();
        AppMethodBeat.o(193027);
      }
      AppMethodBeat.o(193027);
      return paramVarArgs;
      label152:
      paramVarArgs = ClusterManager.c(ClusterManager.this).getClusters(paramVarArgs[0].floatValue());
      ClusterManager.a(ClusterManager.this).readLock().unlock();
      AppMethodBeat.o(193027);
      return paramVarArgs;
    }
    
    protected void a(Set<? extends Cluster<T>> paramSet)
    {
      AppMethodBeat.i(193028);
      ClusterManager.d(ClusterManager.this).onClustersChanged(paramSet);
      AppMethodBeat.o(193028);
    }
  }
  
  class b
    implements Cluster<T>
  {
    private T b;
    private Set<T> c;
    
    public b()
    {
      AppMethodBeat.i(192968);
      Object localObject;
      this.b = localObject;
      this.c = Collections.singleton(this.b);
      AppMethodBeat.o(192968);
    }
    
    public Collection<T> getItems()
    {
      return this.c;
    }
    
    public LatLng getPosition()
    {
      AppMethodBeat.i(192969);
      LatLng localLatLng = this.b.getPosition();
      AppMethodBeat.o(192969);
      return localLatLng;
    }
    
    public int getSize()
    {
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager
 * JD-Core Version:    0.7.0.1
 */