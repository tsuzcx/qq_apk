package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.a;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.b;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.c;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.d;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.d.a;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NonHierarchicalDistanceBasedAlgorithm<T extends ClusterItem>
  implements Algorithm<T>
{
  private static final c f;
  private Context a;
  private int b;
  private int c;
  private final Collection<QuadItem<T>> d;
  private final d<QuadItem<T>> e;
  
  static
  {
    AppMethodBeat.i(192924);
    f = new c(1.0D);
    AppMethodBeat.o(192924);
  }
  
  public NonHierarchicalDistanceBasedAlgorithm(Context paramContext)
  {
    AppMethodBeat.i(192915);
    this.b = 35;
    this.d = new ArrayList();
    this.e = new d(0.0D, 1.0D, 0.0D, 1.0D);
    this.a = paramContext.getApplicationContext();
    this.c = ((int)(this.a.getResources().getDisplayMetrics().density * this.b + 0.5F));
    AppMethodBeat.o(192915);
  }
  
  private double a(b paramb1, b paramb2)
  {
    return (paramb1.a - paramb2.a) * (paramb1.a - paramb2.a) + (paramb1.b - paramb2.b) * (paramb1.b - paramb2.b);
  }
  
  private a a(b paramb, double paramDouble)
  {
    AppMethodBeat.i(192923);
    paramDouble /= 2.0D;
    paramb = new a(paramb.a - paramDouble, paramb.a + paramDouble, paramb.b - paramDouble, paramDouble + paramb.b);
    AppMethodBeat.o(192923);
    return paramb;
  }
  
  public void addItem(T arg1)
  {
    AppMethodBeat.i(192917);
    QuadItem localQuadItem = new QuadItem(???, null);
    synchronized (this.e)
    {
      this.d.add(localQuadItem);
      this.e.a(localQuadItem);
      AppMethodBeat.o(192917);
      return;
    }
  }
  
  public void addItems(Collection<T> paramCollection)
  {
    AppMethodBeat.i(192918);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      addItem((ClusterItem)paramCollection.next());
    }
    AppMethodBeat.o(192918);
  }
  
  public void clearItems()
  {
    AppMethodBeat.i(192919);
    synchronized (this.e)
    {
      this.d.clear();
      this.e.a();
      AppMethodBeat.o(192919);
      return;
    }
  }
  
  public Set<? extends Cluster<T>> getClusters(double paramDouble)
  {
    AppMethodBeat.i(192921);
    int i = (int)paramDouble;
    paramDouble = this.c / Math.pow(2.0D, i + 1) / 256.0D;
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    for (;;)
    {
      QuadItem localQuadItem1;
      Object localObject2;
      synchronized (this.e)
      {
        Iterator localIterator1 = this.d.iterator();
        if (!localIterator1.hasNext()) {
          break;
        }
        localQuadItem1 = (QuadItem)localIterator1.next();
        if (localHashSet1.contains(localQuadItem1)) {
          continue;
        }
        localObject2 = a(localQuadItem1.getPoint(), paramDouble);
        localObject2 = this.e.a((a)localObject2);
        if (((Collection)localObject2).size() == 1)
        {
          localHashSet2.add(localQuadItem1);
          localHashSet1.add(localQuadItem1);
          localHashMap1.put(localQuadItem1, Double.valueOf(0.0D));
        }
      }
      StaticCluster localStaticCluster = new StaticCluster(QuadItem.a(localQuadItem1).getPosition());
      localHashSet2.add(localStaticCluster);
      Iterator localIterator2 = ((Collection)localObject2).iterator();
      while (localIterator2.hasNext())
      {
        QuadItem localQuadItem2 = (QuadItem)localIterator2.next();
        Double localDouble = (Double)localHashMap1.get(localQuadItem2);
        double d1 = a(localQuadItem2.getPoint(), localQuadItem1.getPoint());
        if (localDouble != null)
        {
          if (localDouble.doubleValue() >= d1) {
            ((StaticCluster)localHashMap2.get(localQuadItem2)).remove(QuadItem.a(localQuadItem2));
          }
        }
        else
        {
          localHashMap1.put(localQuadItem2, Double.valueOf(d1));
          localStaticCluster.add(QuadItem.a(localQuadItem2));
          localHashMap2.put(localQuadItem2, localStaticCluster);
        }
      }
      localObject1.addAll((Collection)localObject2);
    }
    AppMethodBeat.o(192921);
    return localHashSet2;
  }
  
  public Collection<T> getItems()
  {
    AppMethodBeat.i(192922);
    ArrayList localArrayList = new ArrayList();
    synchronized (this.e)
    {
      Iterator localIterator = this.d.iterator();
      if (localIterator.hasNext()) {
        localArrayList.add(QuadItem.a((QuadItem)localIterator.next()));
      }
    }
    AppMethodBeat.o(192922);
    return localCollection;
  }
  
  public int getMaxDistanceAtZoom()
  {
    return this.b;
  }
  
  public void removeItem(T arg1)
  {
    AppMethodBeat.i(192920);
    QuadItem localQuadItem = new QuadItem(???, null);
    synchronized (this.e)
    {
      this.d.remove(localQuadItem);
      this.e.b(localQuadItem);
      AppMethodBeat.o(192920);
      return;
    }
  }
  
  public void setMaxDistanceAtZoom(int paramInt)
  {
    AppMethodBeat.i(192916);
    this.b = paramInt;
    this.c = ((int)(this.a.getResources().getDisplayMetrics().density * this.b + 0.5F));
    AppMethodBeat.o(192916);
  }
  
  static class QuadItem<T extends ClusterItem>
    implements d.a, Cluster<T>
  {
    private final T a;
    private final b b;
    private final LatLng c;
    private Set<T> d;
    
    private QuadItem(T paramT)
    {
      AppMethodBeat.i(192925);
      this.a = paramT;
      this.c = paramT.getPosition();
      this.b = NonHierarchicalDistanceBasedAlgorithm.a().a(this.c);
      this.d = Collections.singleton(this.a);
      AppMethodBeat.o(192925);
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(192927);
      if (!(paramObject instanceof QuadItem))
      {
        AppMethodBeat.o(192927);
        return false;
      }
      boolean bool = ((QuadItem)paramObject).a.equals(this.a);
      AppMethodBeat.o(192927);
      return bool;
    }
    
    public Set<T> getItems()
    {
      return this.d;
    }
    
    public b getPoint()
    {
      return this.b;
    }
    
    public LatLng getPosition()
    {
      return this.c;
    }
    
    public int getSize()
    {
      return 1;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(192926);
      int i = this.a.hashCode();
      AppMethodBeat.o(192926);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.NonHierarchicalDistanceBasedAlgorithm
 * JD-Core Version:    0.7.0.1
 */