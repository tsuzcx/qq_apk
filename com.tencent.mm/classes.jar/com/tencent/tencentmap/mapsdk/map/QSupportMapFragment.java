package com.tencent.tencentmap.mapsdk.map;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.h;

public class QSupportMapFragment
  extends Fragment
{
  private MapView mapView;
  
  public static QSupportMapFragment newInstance()
  {
    AppMethodBeat.i(101317);
    QSupportMapFragment localQSupportMapFragment = new QSupportMapFragment();
    AppMethodBeat.o(101317);
    return localQSupportMapFragment;
  }
  
  public MapView getMapView()
  {
    return this.mapView;
  }
  
  public void onAttach(Activity paramActivity)
  {
    AppMethodBeat.i(101318);
    super.onAttach(paramActivity);
    AppMethodBeat.o(101318);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(101320);
    super.onCreate(paramBundle);
    AppMethodBeat.o(101320);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(101321);
    paramViewGroup = paramBundle;
    if (paramBundle == null) {
      paramViewGroup = getArguments();
    }
    if (this.mapView == null)
    {
      this.mapView = new MapView(paramLayoutInflater.getContext());
      this.mapView.onCreate(paramViewGroup);
    }
    h.a("js", "QSupportMapFragment onCreateView ");
    paramLayoutInflater = this.mapView;
    AppMethodBeat.o(101321);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(101325);
    this.mapView.onDestroy();
    super.onDestroy();
    AppMethodBeat.o(101325);
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(101324);
    this.mapView.onDestroyView();
    super.onDestroyView();
    AppMethodBeat.o(101324);
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    AppMethodBeat.i(101319);
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    AppMethodBeat.o(101319);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(101323);
    super.onPause();
    this.mapView.onPause();
    AppMethodBeat.o(101323);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(101322);
    super.onResume();
    this.mapView.onResume();
    AppMethodBeat.o(101322);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(101326);
    this.mapView.onSaveInstanceState(paramBundle);
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(101326);
  }
  
  public void setArguments(Bundle paramBundle)
  {
    AppMethodBeat.i(101327);
    super.setArguments(paramBundle);
    AppMethodBeat.o(101327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.QSupportMapFragment
 * JD-Core Version:    0.7.0.1
 */