package com.tencent.tencentmap.mapsdk.map;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class MapActivity
  extends HellActivity
{
  private List<MapView> mapViewList = new ArrayList();
  private Bundle mysavedInstanceState;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mysavedInstanceState = paramBundle;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.mapViewList.iterator();
    while (localIterator.hasNext())
    {
      MapView localMapView = (MapView)localIterator.next();
      if (localMapView != null) {
        localMapView.onDestroy();
      }
    }
    this.mapViewList.clear();
  }
  
  public void onPause()
  {
    super.onPause();
    Iterator localIterator = this.mapViewList.iterator();
    while (localIterator.hasNext())
    {
      MapView localMapView = (MapView)localIterator.next();
      if (localMapView != null) {
        localMapView.onPause();
      }
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    Iterator localIterator = this.mapViewList.iterator();
    while (localIterator.hasNext())
    {
      MapView localMapView = (MapView)localIterator.next();
      if (localMapView != null) {
        localMapView.onRestart();
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    Iterator localIterator = this.mapViewList.iterator();
    while (localIterator.hasNext())
    {
      MapView localMapView = (MapView)localIterator.next();
      if (localMapView != null) {
        localMapView.onResume();
      }
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    Iterator localIterator = this.mapViewList.iterator();
    while (localIterator.hasNext())
    {
      MapView localMapView = (MapView)localIterator.next();
      if (localMapView != null) {
        localMapView.onStart();
      }
    }
  }
  
  public void onStop()
  {
    super.onStop();
    Iterator localIterator = this.mapViewList.iterator();
    while (localIterator.hasNext())
    {
      MapView localMapView = (MapView)localIterator.next();
      if (localMapView != null) {
        localMapView.onStop();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void setMapView(MapView paramMapView)
  {
    if (paramMapView != null) {
      this.mapViewList.add(paramMapView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.MapActivity
 * JD-Core Version:    0.7.0.1
 */