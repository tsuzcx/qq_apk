package com.tencent.tencentmap.mapsdk.map;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.tencentmap.mapsdk.a.i;

public class QSupportMapFragment
  extends Fragment
{
  private MapView mapView;
  
  public static QSupportMapFragment newInstance()
  {
    return new QSupportMapFragment();
  }
  
  public MapView getMapView()
  {
    return this.mapView;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramBundle;
    if (paramBundle == null) {
      paramViewGroup = getArguments();
    }
    if (this.mapView == null)
    {
      this.mapView = new MapView(paramLayoutInflater.getContext());
      this.mapView.onCreate(paramViewGroup);
    }
    i.a("js", "QSupportMapFragment onCreateView ");
    return this.mapView;
  }
  
  public void onDestroy()
  {
    this.mapView.onDestroy();
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    this.mapView.onDestroyView();
    super.onDestroyView();
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
  }
  
  public void onPause()
  {
    super.onPause();
    this.mapView.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.mapView.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    this.mapView.onSaveInstanceState(paramBundle);
    super.onSaveInstanceState(paramBundle);
  }
  
  public void setArguments(Bundle paramBundle)
  {
    super.setArguments(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.QSupportMapFragment
 * JD-Core Version:    0.7.0.1
 */