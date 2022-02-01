package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.BitmapDescriptorFactory;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.Projection;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.MarkerManager;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.MarkerManager.Collection;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.b;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.c;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.a.e;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.Cluster;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterItem;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager.ClusterInfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager.ClusterItemInfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager.OnClusterClickListener;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager.OnClusterInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager.OnClusterItemClickListener;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.ClusterManager.OnClusterItemInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.NonHierarchicalDistanceBasedAlgorithm;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.algo.PreCachingAlgorithmDecorator;
import com.tencent.tencentmap.mapsdk.vector.compat.utils.ui.IconGenerator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DefaultClusterRenderer<T extends ClusterItem>
  implements ClusterRenderer<T>
{
  private static final boolean b;
  private static volatile boolean g;
  private static final TimeInterpolator z;
  protected double a;
  private final TencentMap c;
  private final IconGenerator d;
  private final ClusterManager<T> e;
  private final float f;
  private int[] h;
  private ShapeDrawable i;
  private Set<MarkerWithPosition> j;
  private SparseArray<BitmapDescriptor> k;
  private MarkerCache<T> l;
  private int m;
  private Set<? extends Cluster<T>> n;
  private boolean o;
  private Map<Marker, Cluster<T>> p;
  private Map<Cluster<T>, Marker> q;
  private float r;
  private final DefaultClusterRenderer<T>.ViewModifier s;
  private ClusterManager.OnClusterClickListener<T> t;
  private ClusterManager.OnClusterInfoWindowClickListener<T> u;
  private ClusterManager.ClusterInfoWindowAdapter<T> v;
  private ClusterManager.OnClusterItemClickListener<T> w;
  private ClusterManager.OnClusterItemInfoWindowClickListener<T> x;
  private ClusterManager.ClusterItemInfoWindowAdapter<T> y;
  
  static
  {
    AppMethodBeat.i(217962);
    if (Build.VERSION.SDK_INT >= 11) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      g = false;
      z = new DecelerateInterpolator();
      AppMethodBeat.o(217962);
      return;
    }
  }
  
  public DefaultClusterRenderer(Context paramContext, TencentMap paramTencentMap, ClusterManager<T> paramClusterManager)
  {
    AppMethodBeat.i(217855);
    this.h = new int[] { 10, 20, 50, 100, 200, 500, 1000 };
    this.j = Collections.newSetFromMap(new ConcurrentHashMap());
    this.k = new SparseArray();
    this.l = new MarkerCache(null);
    this.m = 4;
    this.o = true;
    this.p = new HashMap();
    this.q = new HashMap();
    this.s = new ViewModifier(null);
    this.c = paramTencentMap;
    this.f = paramContext.getResources().getDisplayMetrics().density;
    this.d = new IconGenerator(paramContext);
    this.d.setContentView(a(paramContext));
    this.d.setTextAppearance(16973886, -1118482, 16.0F, 1);
    this.d.setBackground(d());
    this.e = paramClusterManager;
    if ((paramClusterManager.getAlgorithm() instanceof PreCachingAlgorithmDecorator)) {}
    for (paramContext = ((PreCachingAlgorithmDecorator)paramClusterManager.getAlgorithm()).getAlgorithm(); (paramContext instanceof NonHierarchicalDistanceBasedAlgorithm); paramContext = paramClusterManager.getAlgorithm())
    {
      this.a = ((((NonHierarchicalDistanceBasedAlgorithm)paramContext).getMaxDistanceAtZoom() + 0.5D) * this.f);
      AppMethodBeat.o(217855);
      return;
    }
    this.a = (35.0F * this.f);
    AppMethodBeat.o(217855);
  }
  
  private static double a(b paramb1, b paramb2)
  {
    return (paramb1.a - paramb2.a) * (paramb1.a - paramb2.a) + (paramb1.b - paramb2.b) * (paramb1.b - paramb2.b);
  }
  
  private e a(Context paramContext)
  {
    AppMethodBeat.i(217869);
    paramContext = new e(paramContext);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    paramContext.setId(IconGenerator.SQUARE_TEXT_VIEW_ID);
    int i1 = (int)(12.0F * this.f);
    paramContext.setPadding(i1, i1, i1, i1);
    AppMethodBeat.o(217869);
    return paramContext;
  }
  
  private static b b(List<b> paramList, b paramb, double paramDouble)
  {
    b localb = null;
    AppMethodBeat.i(217879);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(217879);
      return null;
    }
    paramDouble *= paramDouble;
    Iterator localIterator = paramList.iterator();
    paramList = localb;
    if (localIterator.hasNext())
    {
      localb = (b)localIterator.next();
      double d1 = a(localb, paramb);
      if (d1 >= paramDouble) {
        break label99;
      }
      paramDouble = d1;
      paramList = localb;
    }
    label99:
    for (;;)
    {
      break;
      AppMethodBeat.o(217879);
      return paramList;
    }
  }
  
  private LayerDrawable d()
  {
    AppMethodBeat.i(217861);
    this.i = new ShapeDrawable(new OvalShape());
    Object localObject = new ShapeDrawable(new OvalShape());
    ((ShapeDrawable)localObject).getPaint().setColor(-2130706433);
    localObject = new LayerDrawable(new Drawable[] { localObject, this.i });
    int i1 = (int)(this.f * 3.0F);
    ((LayerDrawable)localObject).setLayerInset(1, i1, i1, i1, i1);
    AppMethodBeat.o(217861);
    return localObject;
  }
  
  protected String a(int paramInt)
  {
    AppMethodBeat.i(217977);
    if (this.h == null)
    {
      AppMethodBeat.o(217977);
      return String.valueOf(paramInt);
    }
    if (paramInt < this.h[0])
    {
      AppMethodBeat.o(217977);
      return String.valueOf(paramInt);
    }
    String str = String.valueOf(paramInt) + "+";
    AppMethodBeat.o(217977);
    return str;
  }
  
  protected void a(Cluster<T> paramCluster, Marker paramMarker) {}
  
  protected void a(T paramT, Marker paramMarker) {}
  
  protected boolean a(Cluster<T> paramCluster)
  {
    AppMethodBeat.i(217985);
    if (paramCluster.getSize() > this.m)
    {
      AppMethodBeat.o(217985);
      return true;
    }
    AppMethodBeat.o(217985);
    return false;
  }
  
  public void cancel()
  {
    AppMethodBeat.i(217972);
    g = true;
    onRemove();
    AppMethodBeat.o(217972);
  }
  
  public int getBucket(Cluster<T> paramCluster)
  {
    int i1 = 0;
    AppMethodBeat.i(217979);
    int i2 = paramCluster.getSize();
    if (this.h == null)
    {
      AppMethodBeat.o(217979);
      return i2;
    }
    if (i2 <= this.h[0])
    {
      AppMethodBeat.o(217979);
      return i2;
    }
    do
    {
      i1 += 1;
      if (i1 >= this.h.length - 1) {
        break;
      }
    } while (i2 >= this.h[(i1 + 1)]);
    i1 = this.h[i1];
    AppMethodBeat.o(217979);
    return i1;
    i1 = this.h[(this.h.length - 1)];
    AppMethodBeat.o(217979);
    return i1;
  }
  
  public int[] getBuckets()
  {
    return this.h;
  }
  
  public Cluster<T> getCluster(Marker paramMarker)
  {
    AppMethodBeat.i(218002);
    paramMarker = (Cluster)this.p.get(paramMarker);
    AppMethodBeat.o(218002);
    return paramMarker;
  }
  
  public T getClusterItem(Marker paramMarker)
  {
    AppMethodBeat.i(218000);
    paramMarker = (ClusterItem)this.l.get(paramMarker);
    AppMethodBeat.o(218000);
    return paramMarker;
  }
  
  public int getColor(int paramInt)
  {
    AppMethodBeat.i(217975);
    float f1 = Math.min(paramInt, 300.0F);
    paramInt = Color.HSVToColor(new float[] { (300.0F - f1) * (300.0F - f1) / 90000.0F * 220.0F, 1.0F, 0.6F });
    AppMethodBeat.o(217975);
    return paramInt;
  }
  
  public Marker getMarker(Cluster<T> paramCluster)
  {
    AppMethodBeat.i(218001);
    paramCluster = (Marker)this.q.get(paramCluster);
    AppMethodBeat.o(218001);
    return paramCluster;
  }
  
  public Marker getMarker(T paramT)
  {
    AppMethodBeat.i(217998);
    paramT = this.l.get(paramT);
    AppMethodBeat.o(217998);
    return paramT;
  }
  
  public int getMinClusterSize()
  {
    return this.m;
  }
  
  public void onAdd()
  {
    AppMethodBeat.i(217967);
    this.e.getMarkerCollection().a(new TencentMap.OnMarkerClickListener()
    {
      public boolean onMarkerClick(Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(217775);
        paramAnonymousMarker = (ClusterItem)DefaultClusterRenderer.a(DefaultClusterRenderer.this).get(paramAnonymousMarker);
        if ((DefaultClusterRenderer.b(DefaultClusterRenderer.this) != null) && (paramAnonymousMarker != null) && (DefaultClusterRenderer.b(DefaultClusterRenderer.this).onClusterItemClick(paramAnonymousMarker)))
        {
          AppMethodBeat.o(217775);
          return true;
        }
        AppMethodBeat.o(217775);
        return false;
      }
    });
    this.e.getMarkerCollection().a(new TencentMap.OnInfoWindowClickListener()
    {
      public void onInfoWindowClick(Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(217804);
        if (DefaultClusterRenderer.c(DefaultClusterRenderer.this) != null) {
          DefaultClusterRenderer.c(DefaultClusterRenderer.this).onClusterItemInfoWindowClick((ClusterItem)DefaultClusterRenderer.a(DefaultClusterRenderer.this).get(paramAnonymousMarker));
        }
        AppMethodBeat.o(217804);
      }
    });
    this.e.getMarkerCollection().a(new TencentMap.InfoWindowAdapter()
    {
      public View getInfoWindow(Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(217806);
        paramAnonymousMarker = (ClusterItem)DefaultClusterRenderer.a(DefaultClusterRenderer.this).get(paramAnonymousMarker);
        if ((DefaultClusterRenderer.d(DefaultClusterRenderer.this) == null) || (paramAnonymousMarker == null))
        {
          AppMethodBeat.o(217806);
          return null;
        }
        paramAnonymousMarker = DefaultClusterRenderer.d(DefaultClusterRenderer.this).getInfoWindow(paramAnonymousMarker);
        AppMethodBeat.o(217806);
        return paramAnonymousMarker;
      }
      
      public void onInfoWindowDettached(Marker paramAnonymousMarker, View paramAnonymousView) {}
    });
    this.e.getClusterMarkerCollection().a(new TencentMap.OnMarkerClickListener()
    {
      public boolean onMarkerClick(Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(217786);
        paramAnonymousMarker = (Cluster)DefaultClusterRenderer.e(DefaultClusterRenderer.this).get(paramAnonymousMarker);
        if ((DefaultClusterRenderer.f(DefaultClusterRenderer.this) != null) && (paramAnonymousMarker != null) && (DefaultClusterRenderer.f(DefaultClusterRenderer.this).onClusterClick(paramAnonymousMarker)))
        {
          AppMethodBeat.o(217786);
          return true;
        }
        AppMethodBeat.o(217786);
        return false;
      }
    });
    this.e.getClusterMarkerCollection().a(new TencentMap.OnInfoWindowClickListener()
    {
      public void onInfoWindowClick(Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(217791);
        if (DefaultClusterRenderer.g(DefaultClusterRenderer.this) != null) {
          DefaultClusterRenderer.g(DefaultClusterRenderer.this).onClusterInfoWindowClick((Cluster)DefaultClusterRenderer.e(DefaultClusterRenderer.this).get(paramAnonymousMarker));
        }
        AppMethodBeat.o(217791);
      }
    });
    this.e.getClusterMarkerCollection().a(new TencentMap.InfoWindowAdapter()
    {
      public View getInfoWindow(Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(217815);
        paramAnonymousMarker = (Cluster)DefaultClusterRenderer.e(DefaultClusterRenderer.this).get(paramAnonymousMarker);
        if ((DefaultClusterRenderer.h(DefaultClusterRenderer.this) == null) || (paramAnonymousMarker == null))
        {
          AppMethodBeat.o(217815);
          return null;
        }
        paramAnonymousMarker = DefaultClusterRenderer.h(DefaultClusterRenderer.this).getInfoWindow(paramAnonymousMarker);
        AppMethodBeat.o(217815);
        return paramAnonymousMarker;
      }
      
      public void onInfoWindowDettached(Marker paramAnonymousMarker, View paramAnonymousView) {}
    });
    AppMethodBeat.o(217967);
  }
  
  public void onBeforeClusterItemRendered(T paramT, MarkerOptions paramMarkerOptions) {}
  
  public void onBeforeClusterRendered(Cluster<T> paramCluster, MarkerOptions paramMarkerOptions)
  {
    AppMethodBeat.i(217995);
    int i1 = getBucket(paramCluster);
    BitmapDescriptor localBitmapDescriptor = (BitmapDescriptor)this.k.get(i1);
    paramCluster = localBitmapDescriptor;
    if (localBitmapDescriptor == null)
    {
      this.i.getPaint().setColor(getColor(i1));
      paramCluster = BitmapDescriptorFactory.fromBitmap(this.d.makeIcon(a(i1)));
      this.k.put(i1, paramCluster);
    }
    paramMarkerOptions.icon(paramCluster);
    AppMethodBeat.o(217995);
  }
  
  public void onClustersChanged(Set<? extends Cluster<T>> paramSet)
  {
    AppMethodBeat.i(217987);
    this.s.queue(paramSet);
    AppMethodBeat.o(217987);
  }
  
  public void onRemove()
  {
    AppMethodBeat.i(217970);
    this.e.getMarkerCollection().a(null);
    this.e.getClusterMarkerCollection().a(null);
    AppMethodBeat.o(217970);
  }
  
  public void setBuckets(int[] paramArrayOfInt)
  {
    this.h = paramArrayOfInt;
  }
  
  public void setInfoWindowAdapter(ClusterManager.ClusterInfoWindowAdapter paramClusterInfoWindowAdapter)
  {
    this.v = paramClusterInfoWindowAdapter;
  }
  
  public void setItemInfoWindowAdapter(ClusterManager.ClusterItemInfoWindowAdapter paramClusterItemInfoWindowAdapter)
  {
    this.y = paramClusterItemInfoWindowAdapter;
  }
  
  public void setMinClusterSize(int paramInt)
  {
    AppMethodBeat.i(217984);
    this.m = paramInt;
    if (this.e != null)
    {
      this.o = true;
      this.e.cluster();
    }
    AppMethodBeat.o(217984);
  }
  
  public void setOnClusterClickListener(ClusterManager.OnClusterClickListener<T> paramOnClusterClickListener)
  {
    this.t = paramOnClusterClickListener;
  }
  
  public void setOnClusterInfoWindowClickListener(ClusterManager.OnClusterInfoWindowClickListener<T> paramOnClusterInfoWindowClickListener)
  {
    this.u = paramOnClusterInfoWindowClickListener;
  }
  
  public void setOnClusterItemClickListener(ClusterManager.OnClusterItemClickListener<T> paramOnClusterItemClickListener)
  {
    this.w = paramOnClusterItemClickListener;
  }
  
  public void setOnClusterItemInfoWindowClickListener(ClusterManager.OnClusterItemInfoWindowClickListener<T> paramOnClusterItemInfoWindowClickListener)
  {
    this.x = paramOnClusterItemInfoWindowClickListener;
  }
  
  class AnimationTask
    extends AnimatorListenerAdapter
    implements ValueAnimator.AnimatorUpdateListener
  {
    private final DefaultClusterRenderer.MarkerWithPosition b;
    private final Marker c;
    private final LatLng d;
    private final LatLng e;
    private boolean f;
    private MarkerManager g;
    
    private AnimationTask(DefaultClusterRenderer.MarkerWithPosition paramMarkerWithPosition, LatLng paramLatLng1, LatLng paramLatLng2)
    {
      AppMethodBeat.i(217843);
      this.b = paramMarkerWithPosition;
      this.c = DefaultClusterRenderer.MarkerWithPosition.b(paramMarkerWithPosition);
      this.d = paramLatLng1;
      this.e = paramLatLng2;
      AppMethodBeat.o(217843);
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(217860);
      if (this.f)
      {
        paramAnimator = (Cluster)DefaultClusterRenderer.e(DefaultClusterRenderer.this).get(this.c);
        DefaultClusterRenderer.n(DefaultClusterRenderer.this).remove(paramAnimator);
        DefaultClusterRenderer.a(DefaultClusterRenderer.this).remove(this.c);
        DefaultClusterRenderer.e(DefaultClusterRenderer.this).remove(this.c);
        this.g.a(this.c);
      }
      DefaultClusterRenderer.MarkerWithPosition.a(this.b, this.e);
      AppMethodBeat.o(217860);
    }
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(217873);
      float f1 = paramValueAnimator.getAnimatedFraction();
      double d3 = this.e.getLatitude();
      double d4 = this.d.getLatitude();
      double d5 = f1;
      double d6 = this.d.getLatitude();
      double d2 = this.e.getLongitude() - this.d.getLongitude();
      double d1 = d2;
      if (Math.abs(d2) > 180.0D) {
        d1 = d2 - Math.signum(d2) * 360.0D;
      }
      paramValueAnimator = new LatLng(d6 + (d3 - d4) * d5, d1 * f1 + this.d.getLongitude());
      this.c.setPosition(paramValueAnimator);
      AppMethodBeat.o(217873);
    }
    
    public void perform()
    {
      AppMethodBeat.i(217854);
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.setInterpolator(DefaultClusterRenderer.c());
      localValueAnimator.addUpdateListener(this);
      localValueAnimator.addListener(this);
      localValueAnimator.start();
      AppMethodBeat.o(217854);
    }
    
    public void removeOnAnimationComplete(MarkerManager paramMarkerManager)
    {
      this.g = paramMarkerManager;
      this.f = true;
    }
  }
  
  class CreateMarkerTask
  {
    private final Cluster<T> b;
    private final Set<DefaultClusterRenderer.MarkerWithPosition> c;
    private final LatLng d;
    
    public CreateMarkerTask(Set<DefaultClusterRenderer.MarkerWithPosition> paramSet, LatLng paramLatLng)
    {
      this.b = paramSet;
      this.c = paramLatLng;
      Object localObject;
      this.d = localObject;
    }
    
    private void a(DefaultClusterRenderer<T>.MarkerModifier paramDefaultClusterRenderer)
    {
      AppMethodBeat.i(217853);
      if (!DefaultClusterRenderer.this.a(this.b))
      {
        Iterator localIterator = this.b.getItems().iterator();
        if (localIterator.hasNext())
        {
          ClusterItem localClusterItem = (ClusterItem)localIterator.next();
          localObject2 = DefaultClusterRenderer.a(DefaultClusterRenderer.this).get(localClusterItem);
          DefaultClusterRenderer.MarkerWithPosition localMarkerWithPosition;
          if (localObject2 == null)
          {
            localObject1 = new MarkerOptions().position(localClusterItem.getPosition()).anchor(0.5F, 0.5F);
            if (this.d != null) {
              ((MarkerOptions)localObject1).position(this.d);
            }
            DefaultClusterRenderer.this.onBeforeClusterItemRendered(localClusterItem, (MarkerOptions)localObject1);
            Marker localMarker = DefaultClusterRenderer.o(DefaultClusterRenderer.this).getMarkerCollection().a((MarkerOptions)localObject1);
            localMarkerWithPosition = new DefaultClusterRenderer.MarkerWithPosition(localMarker, null);
            DefaultClusterRenderer.a(DefaultClusterRenderer.this).put(localClusterItem, localMarker);
            localObject1 = localMarkerWithPosition;
            localObject2 = localMarker;
            if (this.d != null)
            {
              paramDefaultClusterRenderer.animate(localMarkerWithPosition, this.d, localClusterItem.getPosition());
              localObject2 = localMarker;
            }
          }
          for (localObject1 = localMarkerWithPosition;; localObject1 = new DefaultClusterRenderer.MarkerWithPosition((Marker)localObject2, null))
          {
            DefaultClusterRenderer.this.a(localClusterItem, (Marker)localObject2);
            this.c.add(localObject1);
            break;
          }
        }
        AppMethodBeat.o(217853);
        return;
      }
      Object localObject2 = new MarkerOptions();
      if (this.d == null) {}
      for (Object localObject1 = this.b.getPosition();; localObject1 = this.d)
      {
        localObject1 = ((MarkerOptions)localObject2).position((LatLng)localObject1).anchor(0.5F, 0.5F);
        DefaultClusterRenderer.this.onBeforeClusterRendered(this.b, (MarkerOptions)localObject1);
        localObject1 = DefaultClusterRenderer.o(DefaultClusterRenderer.this).getClusterMarkerCollection().a((MarkerOptions)localObject1);
        DefaultClusterRenderer.e(DefaultClusterRenderer.this).put(localObject1, this.b);
        DefaultClusterRenderer.n(DefaultClusterRenderer.this).put(this.b, localObject1);
        localObject2 = new DefaultClusterRenderer.MarkerWithPosition((Marker)localObject1, null);
        if (this.d != null) {
          paramDefaultClusterRenderer.animate((DefaultClusterRenderer.MarkerWithPosition)localObject2, this.d, this.b.getPosition());
        }
        DefaultClusterRenderer.this.a(this.b, (Marker)localObject1);
        this.c.add(localObject2);
        AppMethodBeat.o(217853);
        return;
      }
    }
  }
  
  static class MarkerCache<T>
  {
    private Map<T, Marker> a;
    private Map<Marker, T> b;
    
    private MarkerCache()
    {
      AppMethodBeat.i(217810);
      this.a = new HashMap();
      this.b = new HashMap();
      AppMethodBeat.o(217810);
    }
    
    public Marker get(T paramT)
    {
      AppMethodBeat.i(217825);
      paramT = (Marker)this.a.get(paramT);
      AppMethodBeat.o(217825);
      return paramT;
    }
    
    public T get(Marker paramMarker)
    {
      AppMethodBeat.i(217830);
      paramMarker = this.b.get(paramMarker);
      AppMethodBeat.o(217830);
      return paramMarker;
    }
    
    public void put(T paramT, Marker paramMarker)
    {
      AppMethodBeat.i(217836);
      this.a.put(paramT, paramMarker);
      this.b.put(paramMarker, paramT);
      AppMethodBeat.o(217836);
    }
    
    public void remove(Marker paramMarker)
    {
      AppMethodBeat.i(217842);
      Object localObject = this.b.get(paramMarker);
      this.b.remove(paramMarker);
      this.a.remove(localObject);
      AppMethodBeat.o(217842);
    }
  }
  
  class MarkerModifier
    extends Handler
    implements MessageQueue.IdleHandler
  {
    private final Lock b;
    private final Condition c;
    private Queue<DefaultClusterRenderer<T>.CreateMarkerTask> d;
    private Queue<DefaultClusterRenderer<T>.CreateMarkerTask> e;
    private Queue<Marker> f;
    private Queue<Marker> g;
    private Queue<DefaultClusterRenderer<T>.AnimationTask> h;
    private boolean i;
    
    private MarkerModifier()
    {
      super();
      AppMethodBeat.i(217839);
      this.b = new ReentrantLock();
      this.c = this.b.newCondition();
      this.d = new LinkedList();
      this.e = new LinkedList();
      this.f = new LinkedList();
      this.g = new LinkedList();
      this.h = new LinkedList();
      AppMethodBeat.o(217839);
    }
    
    private void a()
    {
      AppMethodBeat.i(217846);
      try
      {
        if (!this.g.isEmpty())
        {
          a((Marker)this.g.poll());
          AppMethodBeat.o(217846);
          return;
        }
        if (!this.h.isEmpty())
        {
          ((DefaultClusterRenderer.AnimationTask)this.h.poll()).perform();
          AppMethodBeat.o(217846);
          return;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        if (DefaultClusterRenderer.a()) {
          cancel();
        }
        AppMethodBeat.o(217846);
        return;
      }
      if (!this.e.isEmpty())
      {
        DefaultClusterRenderer.CreateMarkerTask.a((DefaultClusterRenderer.CreateMarkerTask)this.e.poll(), this);
        AppMethodBeat.o(217846);
        return;
      }
      if (!this.d.isEmpty())
      {
        DefaultClusterRenderer.CreateMarkerTask.a((DefaultClusterRenderer.CreateMarkerTask)this.d.poll(), this);
        AppMethodBeat.o(217846);
        return;
      }
      if (!this.f.isEmpty()) {
        a((Marker)this.f.poll());
      }
      AppMethodBeat.o(217846);
    }
    
    private void a(Marker paramMarker)
    {
      AppMethodBeat.i(217852);
      Cluster localCluster = (Cluster)DefaultClusterRenderer.e(DefaultClusterRenderer.this).get(paramMarker);
      DefaultClusterRenderer.n(DefaultClusterRenderer.this).remove(localCluster);
      DefaultClusterRenderer.a(DefaultClusterRenderer.this).remove(paramMarker);
      DefaultClusterRenderer.e(DefaultClusterRenderer.this).remove(paramMarker);
      DefaultClusterRenderer.o(DefaultClusterRenderer.this).getMarkerManager().a(paramMarker);
      AppMethodBeat.o(217852);
    }
    
    public void add(boolean paramBoolean, DefaultClusterRenderer<T>.CreateMarkerTask paramDefaultClusterRenderer)
    {
      AppMethodBeat.i(217864);
      this.b.lock();
      sendEmptyMessage(0);
      if (paramBoolean) {
        this.e.add(paramDefaultClusterRenderer);
      }
      for (;;)
      {
        this.b.unlock();
        AppMethodBeat.o(217864);
        return;
        this.d.add(paramDefaultClusterRenderer);
      }
    }
    
    public void animate(DefaultClusterRenderer.MarkerWithPosition paramMarkerWithPosition, LatLng paramLatLng1, LatLng paramLatLng2)
    {
      AppMethodBeat.i(217878);
      this.b.lock();
      this.h.add(new DefaultClusterRenderer.AnimationTask(DefaultClusterRenderer.this, paramMarkerWithPosition, paramLatLng1, paramLatLng2, null));
      this.b.unlock();
      AppMethodBeat.o(217878);
    }
    
    public void animateThenRemove(DefaultClusterRenderer.MarkerWithPosition paramMarkerWithPosition, LatLng paramLatLng1, LatLng paramLatLng2)
    {
      AppMethodBeat.i(217883);
      this.b.lock();
      paramMarkerWithPosition = new DefaultClusterRenderer.AnimationTask(DefaultClusterRenderer.this, paramMarkerWithPosition, paramLatLng1, paramLatLng2, null);
      paramMarkerWithPosition.removeOnAnimationComplete(DefaultClusterRenderer.o(DefaultClusterRenderer.this).getMarkerManager());
      this.h.add(paramMarkerWithPosition);
      this.b.unlock();
      AppMethodBeat.o(217883);
    }
    
    public void cancel()
    {
      AppMethodBeat.i(217909);
      this.e.clear();
      this.h.clear();
      this.d.clear();
      this.g.clear();
      this.f.clear();
      AppMethodBeat.o(217909);
    }
    
    public void handleMessage(Message paramMessage)
    {
      int j = 0;
      AppMethodBeat.i(217890);
      if (!this.i)
      {
        Looper.myQueue().addIdleHandler(this);
        this.i = true;
      }
      removeMessages(0);
      this.b.lock();
      for (;;)
      {
        if (j < 10) {}
        try
        {
          a();
          j += 1;
        }
        finally
        {
          this.b.unlock();
          AppMethodBeat.o(217890);
        }
      }
      if (!isBusy())
      {
        this.i = false;
        Looper.myQueue().removeIdleHandler(this);
        this.c.signalAll();
      }
      for (;;)
      {
        this.b.unlock();
        AppMethodBeat.o(217890);
        return;
        sendEmptyMessageDelayed(0, 10L);
      }
    }
    
    /* Error */
    public boolean isBusy()
    {
      // Byte code:
      //   0: ldc 224
      //   2: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 52	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/view/DefaultClusterRenderer$MarkerModifier:b	Ljava/util/concurrent/locks/Lock;
      //   9: invokeinterface 158 1 0
      //   14: aload_0
      //   15: getfield 65	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/view/DefaultClusterRenderer$MarkerModifier:d	Ljava/util/Queue;
      //   18: invokeinterface 89 1 0
      //   23: ifeq +53 -> 76
      //   26: aload_0
      //   27: getfield 67	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/view/DefaultClusterRenderer$MarkerModifier:e	Ljava/util/Queue;
      //   30: invokeinterface 89 1 0
      //   35: ifeq +41 -> 76
      //   38: aload_0
      //   39: getfield 71	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/view/DefaultClusterRenderer$MarkerModifier:g	Ljava/util/Queue;
      //   42: invokeinterface 89 1 0
      //   47: ifeq +29 -> 76
      //   50: aload_0
      //   51: getfield 69	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/view/DefaultClusterRenderer$MarkerModifier:f	Ljava/util/Queue;
      //   54: invokeinterface 89 1 0
      //   59: ifeq +17 -> 76
      //   62: aload_0
      //   63: getfield 73	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/view/DefaultClusterRenderer$MarkerModifier:h	Ljava/util/Queue;
      //   66: invokeinterface 89 1 0
      //   71: istore_1
      //   72: iload_1
      //   73: ifne +21 -> 94
      //   76: iconst_1
      //   77: istore_1
      //   78: aload_0
      //   79: getfield 52	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/view/DefaultClusterRenderer$MarkerModifier:b	Ljava/util/concurrent/locks/Lock;
      //   82: invokeinterface 168 1 0
      //   87: ldc 224
      //   89: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   92: iload_1
      //   93: ireturn
      //   94: iconst_0
      //   95: istore_1
      //   96: goto -18 -> 78
      //   99: astore_2
      //   100: aload_0
      //   101: getfield 52	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/view/DefaultClusterRenderer$MarkerModifier:b	Ljava/util/concurrent/locks/Lock;
      //   104: invokeinterface 168 1 0
      //   109: ldc 224
      //   111: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   114: aload_2
      //   115: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	116	0	this	MarkerModifier
      //   71	25	1	bool	boolean
      //   99	16	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   5	72	99	finally
    }
    
    public boolean queueIdle()
    {
      AppMethodBeat.i(217903);
      sendEmptyMessage(0);
      AppMethodBeat.o(217903);
      return true;
    }
    
    public void remove(boolean paramBoolean, Marker paramMarker)
    {
      AppMethodBeat.i(217871);
      this.b.lock();
      sendEmptyMessage(0);
      if (paramBoolean) {
        this.g.add(paramMarker);
      }
      for (;;)
      {
        this.b.unlock();
        AppMethodBeat.o(217871);
        return;
        this.f.add(paramMarker);
      }
    }
    
    public void waitUntilFree()
    {
      AppMethodBeat.i(217897);
      while (isBusy())
      {
        sendEmptyMessage(0);
        this.b.lock();
        try
        {
          if (isBusy()) {
            this.c.await();
          }
          this.b.unlock();
        }
        catch (InterruptedException localInterruptedException)
        {
          RuntimeException localRuntimeException = new RuntimeException(localInterruptedException);
          AppMethodBeat.o(217897);
          throw localRuntimeException;
        }
        finally
        {
          this.b.unlock();
          AppMethodBeat.o(217897);
        }
      }
      AppMethodBeat.o(217897);
    }
  }
  
  static class MarkerWithPosition
  {
    private final Marker a;
    private LatLng b;
    
    private MarkerWithPosition(Marker paramMarker)
    {
      AppMethodBeat.i(217763);
      this.a = paramMarker;
      this.b = paramMarker.getPosition();
      AppMethodBeat.o(217763);
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(217805);
      if ((paramObject instanceof MarkerWithPosition))
      {
        boolean bool = this.a.equals(((MarkerWithPosition)paramObject).a);
        AppMethodBeat.o(217805);
        return bool;
      }
      AppMethodBeat.o(217805);
      return false;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(217813);
      int i = this.a.hashCode();
      AppMethodBeat.o(217813);
      return i;
    }
  }
  
  class RenderTask
    implements Runnable
  {
    final Set<? extends Cluster<T>> a;
    private Runnable c;
    private Projection d;
    private c e;
    private float f;
    private double g;
    
    private RenderTask(double paramDouble)
    {
      this.a = paramDouble;
      Object localObject;
      this.g = localObject;
    }
    
    public void run()
    {
      AppMethodBeat.i(217880);
      if ((this.a.equals(DefaultClusterRenderer.k(DefaultClusterRenderer.this))) && (!DefaultClusterRenderer.l(DefaultClusterRenderer.this)))
      {
        this.c.run();
        AppMethodBeat.o(217880);
        return;
      }
      if (DefaultClusterRenderer.l(DefaultClusterRenderer.this)) {
        DefaultClusterRenderer.a(DefaultClusterRenderer.this, false);
      }
      DefaultClusterRenderer.MarkerModifier localMarkerModifier = new DefaultClusterRenderer.MarkerModifier(DefaultClusterRenderer.this, null);
      float f1 = this.f;
      if (f1 > DefaultClusterRenderer.j(DefaultClusterRenderer.this)) {}
      float f2;
      Object localObject3;
      LatLngBounds localLatLngBounds;
      Object localObject1;
      Object localObject2;
      Object localObject4;
      for (int i = 1;; i = 0)
      {
        f2 = DefaultClusterRenderer.j(DefaultClusterRenderer.this);
        localObject3 = DefaultClusterRenderer.m(DefaultClusterRenderer.this);
        localLatLngBounds = this.d.getVisibleRegion().getLatLngBounds();
        if ((DefaultClusterRenderer.k(DefaultClusterRenderer.this) == null) || (!DefaultClusterRenderer.b())) {
          break label851;
        }
        localObject1 = new ArrayList();
        localObject2 = DefaultClusterRenderer.k(DefaultClusterRenderer.this).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject4 = (Cluster)((Iterator)localObject2).next();
          if ((DefaultClusterRenderer.this.a((Cluster)localObject4)) && (localLatLngBounds.contains(((Cluster)localObject4).getPosition()))) {
            ((List)localObject1).add(this.e.a(((Cluster)localObject4).getPosition()));
          }
        }
      }
      for (;;)
      {
        localObject4 = Collections.newSetFromMap(new ConcurrentHashMap());
        localObject2 = this.a.iterator();
        Object localObject5;
        boolean bool;
        while (((Iterator)localObject2).hasNext())
        {
          localObject5 = (Cluster)((Iterator)localObject2).next();
          Object localObject6;
          if ((DefaultClusterRenderer.k(DefaultClusterRenderer.this) != null) && (DefaultClusterRenderer.k(DefaultClusterRenderer.this).contains(localObject5)) && (DefaultClusterRenderer.this.a((Cluster)localObject5)))
          {
            localObject6 = (Marker)DefaultClusterRenderer.n(DefaultClusterRenderer.this).get(localObject5);
            if (localObject6 != null)
            {
              ((Set)localObject4).add(new DefaultClusterRenderer.MarkerWithPosition((Marker)localObject6, null));
              continue;
            }
          }
          bool = localLatLngBounds.contains(((Cluster)localObject5).getPosition());
          if ((i != 0) && (bool) && (DefaultClusterRenderer.b()))
          {
            localObject6 = DefaultClusterRenderer.a((List)localObject1, this.e.a(((Cluster)localObject5).getPosition()), this.g);
            if (localObject6 != null)
            {
              localObject6 = this.e.a((b)localObject6);
              localMarkerModifier.add(true, new DefaultClusterRenderer.CreateMarkerTask(DefaultClusterRenderer.this, (Cluster)localObject5, (Set)localObject4, (LatLng)localObject6));
            }
            else
            {
              localMarkerModifier.add(true, new DefaultClusterRenderer.CreateMarkerTask(DefaultClusterRenderer.this, (Cluster)localObject5, (Set)localObject4, null));
            }
          }
          else
          {
            localMarkerModifier.add(bool, new DefaultClusterRenderer.CreateMarkerTask(DefaultClusterRenderer.this, (Cluster)localObject5, (Set)localObject4, null));
          }
        }
        localMarkerModifier.waitUntilFree();
        ((Set)localObject3).removeAll((Collection)localObject4);
        if (DefaultClusterRenderer.b())
        {
          localObject2 = new ArrayList();
          localObject5 = this.a.iterator();
          for (;;)
          {
            localObject1 = localObject2;
            if (!((Iterator)localObject5).hasNext()) {
              break;
            }
            localObject1 = (Cluster)((Iterator)localObject5).next();
            if ((DefaultClusterRenderer.this.a((Cluster)localObject1)) && (localLatLngBounds.contains(((Cluster)localObject1).getPosition()))) {
              ((List)localObject2).add(this.e.a(((Cluster)localObject1).getPosition()));
            }
          }
        }
        localObject1 = null;
        localObject2 = ((Set)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (DefaultClusterRenderer.MarkerWithPosition)((Iterator)localObject2).next();
          bool = localLatLngBounds.contains(DefaultClusterRenderer.MarkerWithPosition.a((DefaultClusterRenderer.MarkerWithPosition)localObject3));
          if ((i == 0) && (f1 - f2 > -3.0F) && (bool) && (DefaultClusterRenderer.b()))
          {
            localObject5 = DefaultClusterRenderer.a((List)localObject1, this.e.a(DefaultClusterRenderer.MarkerWithPosition.a((DefaultClusterRenderer.MarkerWithPosition)localObject3)), this.g);
            if (localObject5 != null)
            {
              localObject5 = this.e.a((b)localObject5);
              localMarkerModifier.animateThenRemove((DefaultClusterRenderer.MarkerWithPosition)localObject3, DefaultClusterRenderer.MarkerWithPosition.a((DefaultClusterRenderer.MarkerWithPosition)localObject3), (LatLng)localObject5);
            }
            else
            {
              localMarkerModifier.remove(true, DefaultClusterRenderer.MarkerWithPosition.b((DefaultClusterRenderer.MarkerWithPosition)localObject3));
            }
          }
          else
          {
            localMarkerModifier.remove(bool, DefaultClusterRenderer.MarkerWithPosition.b((DefaultClusterRenderer.MarkerWithPosition)localObject3));
          }
        }
        localMarkerModifier.waitUntilFree();
        DefaultClusterRenderer.a(DefaultClusterRenderer.this, (Set)localObject4);
        DefaultClusterRenderer.b(DefaultClusterRenderer.this, this.a);
        DefaultClusterRenderer.a(DefaultClusterRenderer.this, f1);
        this.c.run();
        AppMethodBeat.o(217880);
        return;
        label851:
        localObject1 = null;
      }
    }
    
    public void setCallback(Runnable paramRunnable)
    {
      this.c = paramRunnable;
    }
    
    public void setMapZoom(float paramFloat)
    {
      AppMethodBeat.i(217863);
      this.f = paramFloat;
      this.e = new c(256.0D * Math.pow(2.0D, Math.min(paramFloat, DefaultClusterRenderer.j(DefaultClusterRenderer.this)) - 1.0F));
      AppMethodBeat.o(217863);
    }
    
    public void setProjection(Projection paramProjection)
    {
      this.d = paramProjection;
    }
  }
  
  class ViewModifier
    extends Handler
  {
    private boolean b = false;
    private DefaultClusterRenderer<T>.RenderTask c = null;
    
    private ViewModifier() {}
    
    public void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(217835);
      if (paramMessage.what == 1)
      {
        this.b = false;
        if (this.c != null) {
          sendEmptyMessage(0);
        }
        AppMethodBeat.o(217835);
        return;
      }
      removeMessages(0);
      if (this.b)
      {
        AppMethodBeat.o(217835);
        return;
      }
      if (this.c == null)
      {
        AppMethodBeat.o(217835);
        return;
      }
      paramMessage = DefaultClusterRenderer.i(DefaultClusterRenderer.this).getProjection();
      if (paramMessage == null)
      {
        AppMethodBeat.o(217835);
        return;
      }
      try
      {
        DefaultClusterRenderer.RenderTask localRenderTask = this.c;
        this.c = null;
        this.b = true;
        localRenderTask.setCallback(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(217834);
            DefaultClusterRenderer.ViewModifier.this.sendEmptyMessage(1);
            AppMethodBeat.o(217834);
          }
        });
        localRenderTask.setProjection(paramMessage);
        return;
      }
      finally
      {
        try
        {
          localRenderTask.setMapZoom(DefaultClusterRenderer.i(DefaultClusterRenderer.this).getCameraPosition().getZoom());
          new Thread(localRenderTask).start();
          AppMethodBeat.o(217835);
          return;
        }
        catch (NullPointerException paramMessage)
        {
          DefaultClusterRenderer.a();
          AppMethodBeat.o(217835);
        }
        paramMessage = finally;
        AppMethodBeat.o(217835);
      }
    }
    
    public void queue(Set<? extends Cluster<T>> paramSet)
    {
      AppMethodBeat.i(217844);
      try
      {
        this.c = new DefaultClusterRenderer.RenderTask(DefaultClusterRenderer.this, paramSet, DefaultClusterRenderer.this.a, null);
        sendEmptyMessage(0);
        AppMethodBeat.o(217844);
        return;
      }
      finally
      {
        AppMethodBeat.o(217844);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.DefaultClusterRenderer
 * JD-Core Version:    0.7.0.1
 */