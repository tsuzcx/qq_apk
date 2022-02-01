package com.tencent.tencentmap.mapsdk.map;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mapsdk.rastercore.LogHelper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class QSupportMapFragment
  extends Fragment
{
  private MapView mapView;
  
  public static QSupportMapFragment newInstance()
  {
    AppMethodBeat.i(87487);
    QSupportMapFragment localQSupportMapFragment = new QSupportMapFragment();
    AppMethodBeat.o(87487);
    return localQSupportMapFragment;
  }
  
  public MapView getMapView()
  {
    return this.mapView;
  }
  
  public void onAttach(Activity paramActivity)
  {
    AppMethodBeat.i(87488);
    super.onAttach(paramActivity);
    AppMethodBeat.o(87488);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(87490);
    super.onCreate(paramBundle);
    AppMethodBeat.o(87490);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(87491);
    paramViewGroup = paramBundle;
    if (paramBundle == null) {
      paramViewGroup = getArguments();
    }
    if (this.mapView == null)
    {
      this.mapView = new MapView(paramLayoutInflater.getContext());
      this.mapView.onCreate(paramViewGroup);
    }
    LogHelper.v("js", "QSupportMapFragment onCreateView ");
    paramLayoutInflater = this.mapView;
    AppMethodBeat.o(87491);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(87495);
    this.mapView.onDestroy();
    super.onDestroy();
    AppMethodBeat.o(87495);
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(87494);
    this.mapView.onDestroyView();
    super.onDestroyView();
    AppMethodBeat.o(87494);
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    AppMethodBeat.i(87489);
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    AppMethodBeat.o(87489);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(87493);
    super.onPause();
    this.mapView.onPause();
    AppMethodBeat.o(87493);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(87492);
    super.onResume();
    this.mapView.onResume();
    AppMethodBeat.o(87492);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(87496);
    this.mapView.onSaveInstanceState(paramBundle);
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(87496);
  }
  
  public void setArguments(Bundle paramBundle)
  {
    AppMethodBeat.i(87497);
    super.setArguments(paramBundle);
    AppMethodBeat.o(87497);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.QSupportMapFragment
 * JD-Core Version:    0.7.0.1
 */