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
    AppMethodBeat.i(190513);
    this.b = new HashMap();
    this.c = new HashMap();
    this.a = paramTencentMap;
    AppMethodBeat.o(190513);
  }
  
  public Collection a()
  {
    AppMethodBeat.i(190514);
    Collection localCollection = new Collection();
    AppMethodBeat.o(190514);
    return localCollection;
  }
  
  public boolean a(Marker paramMarker)
  {
    AppMethodBeat.i(190518);
    Collection localCollection = (Collection)this.c.get(paramMarker);
    if ((localCollection != null) && (localCollection.a(paramMarker)))
    {
      AppMethodBeat.o(190518);
      return true;
    }
    AppMethodBeat.o(190518);
    return false;
  }
  
  public View getInfoWindow(Marker paramMarker)
  {
    AppMethodBeat.i(190515);
    Collection localCollection = (Collection)this.c.get(paramMarker);
    if ((localCollection != null) && (Collection.a(localCollection) != null))
    {
      paramMarker = Collection.a(localCollection).getInfoWindow(paramMarker);
      AppMethodBeat.o(190515);
      return paramMarker;
    }
    AppMethodBeat.o(190515);
    return null;
  }
  
  public void onInfoWindowClick(Marker paramMarker)
  {
    AppMethodBeat.i(190516);
    Collection localCollection = (Collection)this.c.get(paramMarker);
    if ((localCollection != null) && (Collection.b(localCollection) != null)) {
      Collection.b(localCollection).onInfoWindowClick(paramMarker);
    }
    AppMethodBeat.o(190516);
  }
  
  public void onInfoWindowDettached(Marker paramMarker, View paramView) {}
  
  public boolean onMarkerClick(Marker paramMarker)
  {
    AppMethodBeat.i(190517);
    Collection localCollection = (Collection)this.c.get(paramMarker);
    if ((localCollection != null) && (Collection.c(localCollection) != null))
    {
      boolean bool = Collection.c(localCollection).onMarkerClick(paramMarker);
      AppMethodBeat.o(190517);
      return bool;
    }
    AppMethodBeat.o(190517);
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
      AppMethodBeat.i(190508);
      this.b = new HashSet();
      AppMethodBeat.o(190508);
    }
    
    public Marker a(MarkerOptions paramMarkerOptions)
    {
      AppMethodBeat.i(190509);
      paramMarkerOptions = MarkerManager.a(MarkerManager.this).addMarker(paramMarkerOptions);
      this.b.add(paramMarkerOptions);
      MarkerManager.b(MarkerManager.this).put(paramMarkerOptions, this);
      AppMethodBeat.o(190509);
      return paramMarkerOptions;
    }
    
    public void a()
    {
      AppMethodBeat.i(190511);
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        Marker localMarker = (Marker)localIterator.next();
        localMarker.remove();
        MarkerManager.b(MarkerManager.this).remove(localMarker);
      }
      this.b.clear();
      AppMethodBeat.o(190511);
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
      AppMethodBeat.i(190510);
      if (this.b.remove(paramMarker))
      {
        MarkerManager.b(MarkerManager.this).remove(paramMarker);
        paramMarker.remove();
        AppMethodBeat.o(190510);
        return true;
      }
      AppMethodBeat.o(190510);
      return false;
    }
    
    public Collection<Marker> getMarkers()
    {
      AppMethodBeat.i(190512);
      Collection localCollection = Collections.unmodifiableCollection(this.b);
      AppMethodBeat.o(190512);
      return localCollection;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.vector.compat.utils.MarkerManager
 * JD-Core Version:    0.7.0.1
 */