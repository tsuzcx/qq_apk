package com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
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
  private Set<DefaultClusterRenderer.MarkerWithPosition> j;
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
    AppMethodBeat.i(190503);
    if (Build.VERSION.SDK_INT >= 11) {}
    for (boolean bool = true;; bool = false)
    {
      b = bool;
      g = false;
      z = new DecelerateInterpolator();
      AppMethodBeat.o(190503);
      return;
    }
  }
  
  public DefaultClusterRenderer(Context paramContext, TencentMap paramTencentMap, ClusterManager<T> paramClusterManager)
  {
    AppMethodBeat.i(190484);
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
      AppMethodBeat.o(190484);
      return;
    }
    this.a = (35.0F * this.f);
    AppMethodBeat.o(190484);
  }
  
  private static double a(b paramb1, b paramb2)
  {
    return (paramb1.a - paramb2.a) * (paramb1.a - paramb2.a) + (paramb1.b - paramb2.b) * (paramb1.b - paramb2.b);
  }
  
  private e a(Context paramContext)
  {
    AppMethodBeat.i(190489);
    paramContext = new e(paramContext);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    paramContext.setId(IconGenerator.SQUARE_TEXT_VIEW_ID);
    int i1 = (int)(12.0F * this.f);
    paramContext.setPadding(i1, i1, i1, i1);
    AppMethodBeat.o(190489);
    return paramContext;
  }
  
  private static b b(List<b> paramList, b paramb, double paramDouble)
  {
    b localb = null;
    AppMethodBeat.i(190496);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(190496);
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
      AppMethodBeat.o(190496);
      return paramList;
    }
  }
  
  private LayerDrawable d()
  {
    AppMethodBeat.i(190488);
    this.i = new ShapeDrawable(new OvalShape());
    Object localObject = new ShapeDrawable(new OvalShape());
    ((ShapeDrawable)localObject).getPaint().setColor(-2130706433);
    localObject = new LayerDrawable(new Drawable[] { localObject, this.i });
    int i1 = (int)(this.f * 3.0F);
    ((LayerDrawable)localObject).setLayerInset(1, i1, i1, i1, i1);
    AppMethodBeat.o(190488);
    return localObject;
  }
  
  protected String a(int paramInt)
  {
    AppMethodBeat.i(190491);
    if (this.h == null)
    {
      AppMethodBeat.o(190491);
      return String.valueOf(paramInt);
    }
    if (paramInt < this.h[0])
    {
      AppMethodBeat.o(190491);
      return String.valueOf(paramInt);
    }
    String str = String.valueOf(paramInt) + "+";
    AppMethodBeat.o(190491);
    return str;
  }
  
  protected void a(Cluster<T> paramCluster, Marker paramMarker) {}
  
  protected void a(T paramT, Marker paramMarker) {}
  
  protected boolean a(Cluster<T> paramCluster)
  {
    AppMethodBeat.i(190494);
    if (paramCluster.getSize() > this.m)
    {
      AppMethodBeat.o(190494);
      return true;
    }
    AppMethodBeat.o(190494);
    return false;
  }
  
  public void cancel()
  {
    AppMethodBeat.i(190487);
    g = true;
    onRemove();
    AppMethodBeat.o(190487);
  }
  
  public int getBucket(Cluster<T> paramCluster)
  {
    int i1 = 0;
    AppMethodBeat.i(190492);
    int i2 = paramCluster.getSize();
    if (this.h == null)
    {
      AppMethodBeat.o(190492);
      return i2;
    }
    if (i2 <= this.h[0])
    {
      AppMethodBeat.o(190492);
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
    AppMethodBeat.o(190492);
    return i1;
    i1 = this.h[(this.h.length - 1)];
    AppMethodBeat.o(190492);
    return i1;
  }
  
  public int[] getBuckets()
  {
    return this.h;
  }
  
  public Cluster<T> getCluster(Marker paramMarker)
  {
    AppMethodBeat.i(190501);
    paramMarker = (Cluster)this.p.get(paramMarker);
    AppMethodBeat.o(190501);
    return paramMarker;
  }
  
  public T getClusterItem(Marker paramMarker)
  {
    AppMethodBeat.i(190499);
    paramMarker = (ClusterItem)this.l.get(paramMarker);
    AppMethodBeat.o(190499);
    return paramMarker;
  }
  
  public int getColor(int paramInt)
  {
    AppMethodBeat.i(190490);
    float f1 = Math.min(paramInt, 300.0F);
    paramInt = Color.HSVToColor(new float[] { (300.0F - f1) * (300.0F - f1) / 90000.0F * 220.0F, 1.0F, 0.6F });
    AppMethodBeat.o(190490);
    return paramInt;
  }
  
  public Marker getMarker(Cluster<T> paramCluster)
  {
    AppMethodBeat.i(190500);
    paramCluster = (Marker)this.q.get(paramCluster);
    AppMethodBeat.o(190500);
    return paramCluster;
  }
  
  public Marker getMarker(T paramT)
  {
    AppMethodBeat.i(190498);
    paramT = this.l.get(paramT);
    AppMethodBeat.o(190498);
    return paramT;
  }
  
  public int getMinClusterSize()
  {
    return this.m;
  }
  
  public void onAdd()
  {
    AppMethodBeat.i(190485);
    this.e.getMarkerCollection().a(new TencentMap.OnMarkerClickListener()
    {
      public boolean onMarkerClick(Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(190447);
        if ((DefaultClusterRenderer.a(DefaultClusterRenderer.this) != null) && (DefaultClusterRenderer.a(DefaultClusterRenderer.this).onClusterItemClick((ClusterItem)DefaultClusterRenderer.b(DefaultClusterRenderer.this).get(paramAnonymousMarker))))
        {
          AppMethodBeat.o(190447);
          return true;
        }
        AppMethodBeat.o(190447);
        return false;
      }
    });
    this.e.getMarkerCollection().a(new TencentMap.OnInfoWindowClickListener()
    {
      public void onInfoWindowClick(Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(190448);
        if (DefaultClusterRenderer.c(DefaultClusterRenderer.this) != null) {
          DefaultClusterRenderer.c(DefaultClusterRenderer.this).onClusterItemInfoWindowClick((ClusterItem)DefaultClusterRenderer.b(DefaultClusterRenderer.this).get(paramAnonymousMarker));
        }
        AppMethodBeat.o(190448);
      }
    });
    this.e.getMarkerCollection().a(new TencentMap.InfoWindowAdapter()
    {
      public View getInfoWindow(Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(190449);
        if (DefaultClusterRenderer.d(DefaultClusterRenderer.this) != null)
        {
          paramAnonymousMarker = DefaultClusterRenderer.d(DefaultClusterRenderer.this).getInfoWindow((ClusterItem)DefaultClusterRenderer.b(DefaultClusterRenderer.this).get(paramAnonymousMarker));
          AppMethodBeat.o(190449);
          return paramAnonymousMarker;
        }
        AppMethodBeat.o(190449);
        return null;
      }
      
      public void onInfoWindowDettached(Marker paramAnonymousMarker, View paramAnonymousView) {}
    });
    this.e.getClusterMarkerCollection().a(new TencentMap.OnMarkerClickListener()
    {
      public boolean onMarkerClick(Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(190450);
        if ((DefaultClusterRenderer.e(DefaultClusterRenderer.this) != null) && (DefaultClusterRenderer.e(DefaultClusterRenderer.this).onClusterClick((Cluster)DefaultClusterRenderer.f(DefaultClusterRenderer.this).get(paramAnonymousMarker))))
        {
          AppMethodBeat.o(190450);
          return true;
        }
        AppMethodBeat.o(190450);
        return false;
      }
    });
    this.e.getClusterMarkerCollection().a(new TencentMap.OnInfoWindowClickListener()
    {
      public void onInfoWindowClick(Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(190451);
        if (DefaultClusterRenderer.g(DefaultClusterRenderer.this) != null) {
          DefaultClusterRenderer.g(DefaultClusterRenderer.this).onClusterInfoWindowClick((Cluster)DefaultClusterRenderer.f(DefaultClusterRenderer.this).get(paramAnonymousMarker));
        }
        AppMethodBeat.o(190451);
      }
    });
    this.e.getClusterMarkerCollection().a(new TencentMap.InfoWindowAdapter()
    {
      public View getInfoWindow(Marker paramAnonymousMarker)
      {
        AppMethodBeat.i(190452);
        if (DefaultClusterRenderer.h(DefaultClusterRenderer.this) != null)
        {
          paramAnonymousMarker = DefaultClusterRenderer.h(DefaultClusterRenderer.this).getInfoWindow((Cluster)DefaultClusterRenderer.f(DefaultClusterRenderer.this).get(paramAnonymousMarker));
          AppMethodBeat.o(190452);
          return paramAnonymousMarker;
        }
        AppMethodBeat.o(190452);
        return null;
      }
      
      public void onInfoWindowDettached(Marker paramAnonymousMarker, View paramAnonymousView) {}
    });
    AppMethodBeat.o(190485);
  }
  
  public void onBeforeClusterItemRendered(T paramT, MarkerOptions paramMarkerOptions) {}
  
  public void onBeforeClusterRendered(Cluster<T> paramCluster, MarkerOptions paramMarkerOptions)
  {
    AppMethodBeat.i(190497);
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
    AppMethodBeat.o(190497);
  }
  
  public void onClustersChanged(Set<? extends Cluster<T>> paramSet)
  {
    AppMethodBeat.i(190495);
    this.s.queue(paramSet);
    AppMethodBeat.o(190495);
  }
  
  public void onRemove()
  {
    AppMethodBeat.i(190486);
    this.e.getMarkerCollection().a(null);
    this.e.getClusterMarkerCollection().a(null);
    AppMethodBeat.o(190486);
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
    AppMethodBeat.i(190493);
    this.m = paramInt;
    if (this.e != null)
    {
      this.o = true;
      this.e.cluster();
    }
    AppMethodBeat.o(190493);
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
  
  @TargetApi(12)
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
      AppMethodBeat.i(190453);
      this.b = paramMarkerWithPosition;
      this.c = DefaultClusterRenderer.MarkerWithPosition.b(paramMarkerWithPosition);
      this.d = paramLatLng1;
      this.e = paramLatLng2;
      AppMethodBeat.o(190453);
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(190455);
      if (this.f)
      {
        paramAnimator = (Cluster)DefaultClusterRenderer.f(DefaultClusterRenderer.this).get(this.c);
        DefaultClusterRenderer.n(DefaultClusterRenderer.this).remove(paramAnimator);
        DefaultClusterRenderer.b(DefaultClusterRenderer.this).remove(this.c);
        DefaultClusterRenderer.f(DefaultClusterRenderer.this).remove(this.c);
        this.g.a(this.c);
      }
      DefaultClusterRenderer.MarkerWithPosition.a(this.b, this.e);
      AppMethodBeat.o(190455);
    }
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(190456);
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
      AppMethodBeat.o(190456);
    }
    
    public void perform()
    {
      AppMethodBeat.i(190454);
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.setInterpolator(DefaultClusterRenderer.c());
      localValueAnimator.addUpdateListener(this);
      localValueAnimator.addListener(this);
      localValueAnimator.start();
      AppMethodBeat.o(190454);
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
      AppMethodBeat.i(190457);
      if (!DefaultClusterRenderer.this.a(this.b))
      {
        Iterator localIterator = this.b.getItems().iterator();
        if (localIterator.hasNext())
        {
          ClusterItem localClusterItem = (ClusterItem)localIterator.next();
          localObject2 = DefaultClusterRenderer.b(DefaultClusterRenderer.this).get(localClusterItem);
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
            DefaultClusterRenderer.b(DefaultClusterRenderer.this).put(localClusterItem, localMarker);
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
        AppMethodBeat.o(190457);
        return;
      }
      Object localObject2 = new MarkerOptions();
      if (this.d == null) {}
      for (Object localObject1 = this.b.getPosition();; localObject1 = this.d)
      {
        localObject1 = ((MarkerOptions)localObject2).position((LatLng)localObject1).anchor(0.5F, 0.5F);
        DefaultClusterRenderer.this.onBeforeClusterRendered(this.b, (MarkerOptions)localObject1);
        localObject1 = DefaultClusterRenderer.o(DefaultClusterRenderer.this).getClusterMarkerCollection().a((MarkerOptions)localObject1);
        DefaultClusterRenderer.f(DefaultClusterRenderer.this).put(localObject1, this.b);
        DefaultClusterRenderer.n(DefaultClusterRenderer.this).put(this.b, localObject1);
        localObject2 = new DefaultClusterRenderer.MarkerWithPosition((Marker)localObject1, null);
        if (this.d != null) {
          paramDefaultClusterRenderer.animate((DefaultClusterRenderer.MarkerWithPosition)localObject2, this.d, this.b.getPosition());
        }
        DefaultClusterRenderer.this.a(this.b, (Marker)localObject1);
        this.c.add(localObject2);
        AppMethodBeat.o(190457);
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
      AppMethodBeat.i(190459);
      this.a = new HashMap();
      this.b = new HashMap();
      AppMethodBeat.o(190459);
    }
    
    public Marker get(T paramT)
    {
      AppMethodBeat.i(190460);
      paramT = (Marker)this.a.get(paramT);
      AppMethodBeat.o(190460);
      return paramT;
    }
    
    public T get(Marker paramMarker)
    {
      AppMethodBeat.i(190461);
      paramMarker = this.b.get(paramMarker);
      AppMethodBeat.o(190461);
      return paramMarker;
    }
    
    public void put(T paramT, Marker paramMarker)
    {
      AppMethodBeat.i(190462);
      this.a.put(paramT, paramMarker);
      this.b.put(paramMarker, paramT);
      AppMethodBeat.o(190462);
    }
    
    public void remove(Marker paramMarker)
    {
      AppMethodBeat.i(190463);
      Object localObject = this.b.get(paramMarker);
      this.b.remove(paramMarker);
      this.a.remove(localObject);
      AppMethodBeat.o(190463);
    }
  }
  
  @SuppressLint({"HandlerLeak"})
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
      AppMethodBeat.i(190464);
      this.b = new ReentrantLock();
      this.c = this.b.newCondition();
      this.d = new LinkedList();
      this.e = new LinkedList();
      this.f = new LinkedList();
      this.g = new LinkedList();
      this.h = new LinkedList();
      AppMethodBeat.o(190464);
    }
    
    @TargetApi(11)
    private void a()
    {
      AppMethodBeat.i(190470);
      try
      {
        if (!this.g.isEmpty())
        {
          a((Marker)this.g.poll());
          AppMethodBeat.o(190470);
          return;
        }
        if (!this.h.isEmpty())
        {
          ((DefaultClusterRenderer.AnimationTask)this.h.poll()).perform();
          AppMethodBeat.o(190470);
          return;
        }
      }
      catch (NullPointerException localNullPointerException)
      {
        if (DefaultClusterRenderer.a()) {
          cancel();
        }
        AppMethodBeat.o(190470);
        return;
      }
      if (!this.e.isEmpty())
      {
        DefaultClusterRenderer.CreateMarkerTask.a((DefaultClusterRenderer.CreateMarkerTask)this.e.poll(), this);
        AppMethodBeat.o(190470);
        return;
      }
      if (!this.d.isEmpty())
      {
        DefaultClusterRenderer.CreateMarkerTask.a((DefaultClusterRenderer.CreateMarkerTask)this.d.poll(), this);
        AppMethodBeat.o(190470);
        return;
      }
      if (!this.f.isEmpty()) {
        a((Marker)this.f.poll());
      }
      AppMethodBeat.o(190470);
    }
    
    private void a(Marker paramMarker)
    {
      AppMethodBeat.i(190471);
      Cluster localCluster = (Cluster)DefaultClusterRenderer.f(DefaultClusterRenderer.this).get(paramMarker);
      DefaultClusterRenderer.n(DefaultClusterRenderer.this).remove(localCluster);
      DefaultClusterRenderer.b(DefaultClusterRenderer.this).remove(paramMarker);
      DefaultClusterRenderer.f(DefaultClusterRenderer.this).remove(paramMarker);
      DefaultClusterRenderer.o(DefaultClusterRenderer.this).getMarkerManager().a(paramMarker);
      AppMethodBeat.o(190471);
    }
    
    public void add(boolean paramBoolean, DefaultClusterRenderer<T>.CreateMarkerTask paramDefaultClusterRenderer)
    {
      AppMethodBeat.i(190465);
      this.b.lock();
      sendEmptyMessage(0);
      if (paramBoolean) {
        this.e.add(paramDefaultClusterRenderer);
      }
      for (;;)
      {
        this.b.unlock();
        AppMethodBeat.o(190465);
        return;
        this.d.add(paramDefaultClusterRenderer);
      }
    }
    
    public void animate(DefaultClusterRenderer.MarkerWithPosition paramMarkerWithPosition, LatLng paramLatLng1, LatLng paramLatLng2)
    {
      AppMethodBeat.i(190467);
      this.b.lock();
      this.h.add(new DefaultClusterRenderer.AnimationTask(DefaultClusterRenderer.this, paramMarkerWithPosition, paramLatLng1, paramLatLng2, null));
      this.b.unlock();
      AppMethodBeat.o(190467);
    }
    
    @TargetApi(11)
    public void animateThenRemove(DefaultClusterRenderer.MarkerWithPosition paramMarkerWithPosition, LatLng paramLatLng1, LatLng paramLatLng2)
    {
      AppMethodBeat.i(190468);
      this.b.lock();
      paramMarkerWithPosition = new DefaultClusterRenderer.AnimationTask(DefaultClusterRenderer.this, paramMarkerWithPosition, paramLatLng1, paramLatLng2, null);
      paramMarkerWithPosition.removeOnAnimationComplete(DefaultClusterRenderer.o(DefaultClusterRenderer.this).getMarkerManager());
      this.h.add(paramMarkerWithPosition);
      this.b.unlock();
      AppMethodBeat.o(190468);
    }
    
    public void cancel()
    {
      AppMethodBeat.i(190475);
      this.e.clear();
      this.h.clear();
      this.d.clear();
      this.g.clear();
      this.f.clear();
      AppMethodBeat.o(190475);
    }
    
    public void handleMessage(Message paramMessage)
    {
      int j = 0;
      AppMethodBeat.i(190469);
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
          AppMethodBeat.o(190469);
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
        AppMethodBeat.o(190469);
        return;
        sendEmptyMessageDelayed(0, 10L);
      }
    }
    
    /* Error */
    public boolean isBusy()
    {
      // Byte code:
      //   0: ldc 230
      //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 55	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/view/DefaultClusterRenderer$MarkerModifier:b	Ljava/util/concurrent/locks/Lock;
      //   9: invokeinterface 164 1 0
      //   14: aload_0
      //   15: getfield 68	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/view/DefaultClusterRenderer$MarkerModifier:d	Ljava/util/Queue;
      //   18: invokeinterface 94 1 0
      //   23: ifeq +53 -> 76
      //   26: aload_0
      //   27: getfield 70	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/view/DefaultClusterRenderer$MarkerModifier:e	Ljava/util/Queue;
      //   30: invokeinterface 94 1 0
      //   35: ifeq +41 -> 76
      //   38: aload_0
      //   39: getfield 74	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/view/DefaultClusterRenderer$MarkerModifier:g	Ljava/util/Queue;
      //   42: invokeinterface 94 1 0
      //   47: ifeq +29 -> 76
      //   50: aload_0
      //   51: getfield 72	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/view/DefaultClusterRenderer$MarkerModifier:f	Ljava/util/Queue;
      //   54: invokeinterface 94 1 0
      //   59: ifeq +17 -> 76
      //   62: aload_0
      //   63: getfield 76	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/view/DefaultClusterRenderer$MarkerModifier:h	Ljava/util/Queue;
      //   66: invokeinterface 94 1 0
      //   71: istore_1
      //   72: iload_1
      //   73: ifne +21 -> 94
      //   76: iconst_1
      //   77: istore_1
      //   78: aload_0
      //   79: getfield 55	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/view/DefaultClusterRenderer$MarkerModifier:b	Ljava/util/concurrent/locks/Lock;
      //   82: invokeinterface 174 1 0
      //   87: ldc 230
      //   89: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   92: iload_1
      //   93: ireturn
      //   94: iconst_0
      //   95: istore_1
      //   96: goto -18 -> 78
      //   99: astore_2
      //   100: aload_0
      //   101: getfield 55	com/tencent/tencentmap/mapsdk/vector/compat/utils/clustering/view/DefaultClusterRenderer$MarkerModifier:b	Ljava/util/concurrent/locks/Lock;
      //   104: invokeinterface 174 1 0
      //   109: ldc 230
      //   111: invokestatic 79	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
      AppMethodBeat.i(190474);
      sendEmptyMessage(0);
      AppMethodBeat.o(190474);
      return true;
    }
    
    public void remove(boolean paramBoolean, Marker paramMarker)
    {
      AppMethodBeat.i(190466);
      this.b.lock();
      sendEmptyMessage(0);
      if (paramBoolean) {
        this.g.add(paramMarker);
      }
      for (;;)
      {
        this.b.unlock();
        AppMethodBeat.o(190466);
        return;
        this.f.add(paramMarker);
      }
    }
    
    public void waitUntilFree()
    {
      AppMethodBeat.i(190473);
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
          AppMethodBeat.o(190473);
          throw localRuntimeException;
        }
        finally
        {
          this.b.unlock();
          AppMethodBeat.o(190473);
        }
      }
      AppMethodBeat.o(190473);
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
    
    @SuppressLint({"NewApi"})
    public void run()
    {
      AppMethodBeat.i(190480);
      if ((this.a.equals(DefaultClusterRenderer.k(DefaultClusterRenderer.this))) && (!DefaultClusterRenderer.l(DefaultClusterRenderer.this)))
      {
        this.c.run();
        AppMethodBeat.o(190480);
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
        AppMethodBeat.o(190480);
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
      AppMethodBeat.i(190479);
      this.f = paramFloat;
      this.e = new c(256.0D * Math.pow(2.0D, Math.min(paramFloat, DefaultClusterRenderer.j(DefaultClusterRenderer.this)) - 1.0F));
      AppMethodBeat.o(190479);
    }
    
    public void setProjection(Projection paramProjection)
    {
      this.d = paramProjection;
    }
  }
  
  @SuppressLint({"HandlerLeak"})
  class ViewModifier
    extends Handler
  {
    private boolean b = false;
    private DefaultClusterRenderer<T>.RenderTask c = null;
    
    private ViewModifier() {}
    
    public void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(190482);
      if (paramMessage.what == 1)
      {
        this.b = false;
        if (this.c != null) {
          sendEmptyMessage(0);
        }
        AppMethodBeat.o(190482);
        return;
      }
      removeMessages(0);
      if (this.b)
      {
        AppMethodBeat.o(190482);
        return;
      }
      if (this.c == null)
      {
        AppMethodBeat.o(190482);
        return;
      }
      paramMessage = DefaultClusterRenderer.i(DefaultClusterRenderer.this).getProjection();
      if (paramMessage == null)
      {
        AppMethodBeat.o(190482);
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
            AppMethodBeat.i(190481);
            DefaultClusterRenderer.ViewModifier.this.sendEmptyMessage(1);
            AppMethodBeat.o(190481);
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
          AppMethodBeat.o(190482);
          return;
        }
        catch (NullPointerException paramMessage)
        {
          DefaultClusterRenderer.a();
          AppMethodBeat.o(190482);
        }
        paramMessage = finally;
        AppMethodBeat.o(190482);
      }
    }
    
    public void queue(Set<? extends Cluster<T>> paramSet)
    {
      AppMethodBeat.i(190483);
      try
      {
        this.c = new DefaultClusterRenderer.RenderTask(DefaultClusterRenderer.this, paramSet, DefaultClusterRenderer.this.a, null);
        sendEmptyMessage(0);
        AppMethodBeat.o(190483);
        return;
      }
      finally
      {
        AppMethodBeat.o(190483);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.clustering.view.DefaultClusterRenderer
 * JD-Core Version:    0.7.0.1
 */