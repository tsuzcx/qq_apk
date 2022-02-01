package com.tencent.tencentmap.mapsdk.vector.compat.utils;

import android.view.View;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MarkerManager
  implements TencentMap.InfoWindowAdapter, TencentMap.OnInfoWindowClickListener, TencentMap.OnMarkerClickListener
{
  private final TencentMap a;
  private final Map<String, Collection> b;
  private final Map<Marker, Collection> c;
  
  public MarkerManager(TencentMap paramTencentMap)
  {
    AppMethodBeat.i(217635);
    this.b = new HashMap();
    this.c = new HashMap();
    this.a = paramTencentMap;
    AppMethodBeat.o(217635);
  }
  
  public Collection a()
  {
    AppMethodBeat.i(217656);
    Collection localCollection = new Collection();
    AppMethodBeat.o(217656);
    return localCollection;
  }
  
  public boolean a(Marker paramMarker)
  {
    AppMethodBeat.i(217686);
    Collection localCollection = (Collection)this.c.get(paramMarker);
    if ((localCollection != null) && (localCollection.a(paramMarker)))
    {
      AppMethodBeat.o(217686);
      return true;
    }
    AppMethodBeat.o(217686);
    return false;
  }
  
  public View getInfoWindow(Marker paramMarker)
  {
    AppMethodBeat.i(217665);
    Collection localCollection = (Collection)this.c.get(paramMarker);
    if ((localCollection != null) && (Collection.a(localCollection) != null))
    {
      paramMarker = Collection.a(localCollection).getInfoWindow(paramMarker);
      AppMethodBeat.o(217665);
      return paramMarker;
    }
    AppMethodBeat.o(217665);
    return null;
  }
  
  public void onInfoWindowClick(Marker paramMarker)
  {
    AppMethodBeat.i(217677);
    Collection localCollection = (Collection)this.c.get(paramMarker);
    if ((localCollection != null) && (Collection.b(localCollection) != null)) {
      Collection.b(localCollection).onInfoWindowClick(paramMarker);
    }
    AppMethodBeat.o(217677);
  }
  
  public void onInfoWindowDettached(Marker paramMarker, View paramView) {}
  
  public boolean onMarkerClick(Marker paramMarker)
  {
    AppMethodBeat.i(217683);
    Collection localCollection = (Collection)this.c.get(paramMarker);
    if ((localCollection != null) && (Collection.c(localCollection) != null))
    {
      boolean bool = Collection.c(localCollection).onMarkerClick(paramMarker);
      AppMethodBeat.o(217683);
      return bool;
    }
    AppMethodBeat.o(217683);
    return false;
  }
  
  public class Collection
  {
    private final Set<Marker> b;
    private TencentMap.OnInfoWindowClickListener c;
    private TencentMap.OnMarkerClickListener d;
    private TencentMap.InfoWindowAdapter e;
    
    public Collection()
    {
      AppMethodBeat.i(217623);
      this.b = new HashSet();
      AppMethodBeat.o(217623);
    }
    
    public Marker a(MarkerOptions paramMarkerOptions)
    {
      AppMethodBeat.i(217641);
      paramMarkerOptions = MarkerManager.a(MarkerManager.this).addMarker(paramMarkerOptions);
      this.b.add(paramMarkerOptions);
      MarkerManager.b(MarkerManager.this).put(paramMarkerOptions, this);
      AppMethodBeat.o(217641);
      return paramMarkerOptions;
    }
    
    public void a()
    {
      AppMethodBeat.i(217661);
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        Marker localMarker = (Marker)localIterator.next();
        localMarker.remove();
        MarkerManager.b(MarkerManager.this).remove(localMarker);
      }
      this.b.clear();
      AppMethodBeat.o(217661);
    }
    
    public void a(TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
    {
      this.e = paramInfoWindowAdapter;
    }
    
    public void a(TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
    {
      this.c = paramOnInfoWindowClickListener;
    }
    
    public void a(TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
    {
      this.d = paramOnMarkerClickListener;
    }
    
    public boolean a(Marker paramMarker)
    {
      AppMethodBeat.i(217652);
      if (this.b.remove(paramMarker))
      {
        MarkerManager.b(MarkerManager.this).remove(paramMarker);
        paramMarker.remove();
        AppMethodBeat.o(217652);
        return true;
      }
      AppMethodBeat.o(217652);
      return false;
    }
    
    public Collection<Marker> getMarkers()
    {
      AppMethodBeat.i(217669);
      Collection localCollection = Collections.unmodifiableCollection(this.b);
      AppMethodBeat.o(217669);
      return localCollection;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.MarkerManager
 * JD-Core Version:    0.7.0.1
 */