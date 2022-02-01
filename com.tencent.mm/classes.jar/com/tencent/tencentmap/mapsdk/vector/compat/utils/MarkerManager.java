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
    AppMethodBeat.i(192332);
    this.b = new HashMap();
    this.c = new HashMap();
    this.a = paramTencentMap;
    AppMethodBeat.o(192332);
  }
  
  public Collection a()
  {
    AppMethodBeat.i(192333);
    Collection localCollection = new Collection();
    AppMethodBeat.o(192333);
    return localCollection;
  }
  
  public boolean a(Marker paramMarker)
  {
    AppMethodBeat.i(192337);
    Collection localCollection = (Collection)this.c.get(paramMarker);
    if ((localCollection != null) && (localCollection.a(paramMarker)))
    {
      AppMethodBeat.o(192337);
      return true;
    }
    AppMethodBeat.o(192337);
    return false;
  }
  
  public View getInfoWindow(Marker paramMarker)
  {
    AppMethodBeat.i(192334);
    Collection localCollection = (Collection)this.c.get(paramMarker);
    if ((localCollection != null) && (Collection.a(localCollection) != null))
    {
      paramMarker = Collection.a(localCollection).getInfoWindow(paramMarker);
      AppMethodBeat.o(192334);
      return paramMarker;
    }
    AppMethodBeat.o(192334);
    return null;
  }
  
  public void onInfoWindowClick(Marker paramMarker)
  {
    AppMethodBeat.i(192335);
    Collection localCollection = (Collection)this.c.get(paramMarker);
    if ((localCollection != null) && (Collection.b(localCollection) != null)) {
      Collection.b(localCollection).onInfoWindowClick(paramMarker);
    }
    AppMethodBeat.o(192335);
  }
  
  public void onInfoWindowDettached(Marker paramMarker, View paramView) {}
  
  public boolean onMarkerClick(Marker paramMarker)
  {
    AppMethodBeat.i(192336);
    Collection localCollection = (Collection)this.c.get(paramMarker);
    if ((localCollection != null) && (Collection.c(localCollection) != null))
    {
      boolean bool = Collection.c(localCollection).onMarkerClick(paramMarker);
      AppMethodBeat.o(192336);
      return bool;
    }
    AppMethodBeat.o(192336);
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
      AppMethodBeat.i(192327);
      this.b = new HashSet();
      AppMethodBeat.o(192327);
    }
    
    public Marker a(MarkerOptions paramMarkerOptions)
    {
      AppMethodBeat.i(192328);
      paramMarkerOptions = MarkerManager.a(MarkerManager.this).addMarker(paramMarkerOptions);
      this.b.add(paramMarkerOptions);
      MarkerManager.b(MarkerManager.this).put(paramMarkerOptions, this);
      AppMethodBeat.o(192328);
      return paramMarkerOptions;
    }
    
    public void a()
    {
      AppMethodBeat.i(192330);
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        Marker localMarker = (Marker)localIterator.next();
        localMarker.remove();
        MarkerManager.b(MarkerManager.this).remove(localMarker);
      }
      this.b.clear();
      AppMethodBeat.o(192330);
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
      AppMethodBeat.i(192329);
      if (this.b.remove(paramMarker))
      {
        MarkerManager.b(MarkerManager.this).remove(paramMarker);
        paramMarker.remove();
        AppMethodBeat.o(192329);
        return true;
      }
      AppMethodBeat.o(192329);
      return false;
    }
    
    public Collection<Marker> getMarkers()
    {
      AppMethodBeat.i(192331);
      Collection localCollection = Collections.unmodifiableCollection(this.b);
      AppMethodBeat.o(192331);
      return localCollection;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.MarkerManager
 * JD-Core Version:    0.7.0.1
 */