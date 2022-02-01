package com.tencent.tencentmap.mapsdk.maps;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(12)
public class MapFragment
  extends Fragment
{
  private boolean isOnTop = true;
  private TencentMap mTencentMap;
  protected MapView mapV = null;
  
  public static MapFragment newInstance(Context paramContext)
  {
    AppMethodBeat.i(180986);
    MapFragment localMapFragment = new MapFragment();
    localMapFragment.initMap(paramContext);
    AppMethodBeat.o(180986);
    return localMapFragment;
  }
  
  public TencentMap getMap()
  {
    AppMethodBeat.i(180988);
    if (this.mTencentMap == null) {
      this.mTencentMap = this.mapV.getMap();
    }
    TencentMap localTencentMap = this.mTencentMap;
    AppMethodBeat.o(180988);
    return localTencentMap;
  }
  
  protected void initMap(Context paramContext)
  {
    AppMethodBeat.i(180987);
    if (this.mapV == null) {
      this.mapV = onCreateMapView(paramContext.getApplicationContext(), null);
    }
    AppMethodBeat.o(180987);
  }
  
  public void onAttach(Activity paramActivity)
  {
    AppMethodBeat.i(180989);
    super.onAttach(paramActivity);
    AppMethodBeat.o(180989);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(180991);
    super.onCreate(paramBundle);
    AppMethodBeat.o(180991);
  }
  
  protected MapView onCreateMapView(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(180993);
    paramContext = new MapView(paramContext, paramTencentMapOptions);
    AppMethodBeat.o(180993);
    return paramContext;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(180992);
    if (this.mapV == null) {
      this.mapV = onCreateMapView(getActivity().getBaseContext(), null);
    }
    this.mapV.setOnTop(this.isOnTop);
    paramLayoutInflater = this.mapV;
    AppMethodBeat.o(180992);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(180997);
    this.mapV.onDestroy();
    super.onDestroy();
    AppMethodBeat.o(180997);
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(180996);
    this.mapV.onDestroy();
    super.onDestroyView();
    AppMethodBeat.o(180996);
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    AppMethodBeat.i(180990);
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    AppMethodBeat.o(180990);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(181000);
    super.onLowMemory();
    AppMethodBeat.o(181000);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(180995);
    this.mapV.onPause();
    super.onPause();
    AppMethodBeat.o(180995);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(180994);
    this.mapV.onResume();
    super.onResume();
    AppMethodBeat.o(180994);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(181001);
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(181001);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(180998);
    this.mapV.onStart();
    super.onStart();
    AppMethodBeat.o(180998);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(180999);
    this.mapV.onStop();
    super.onStop();
    AppMethodBeat.o(180999);
  }
  
  public void setArguments(Bundle paramBundle)
  {
    AppMethodBeat.i(181002);
    super.setArguments(paramBundle);
    AppMethodBeat.o(181002);
  }
  
  public void setOnTop(boolean paramBoolean)
  {
    this.isOnTop = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.MapFragment
 * JD-Core Version:    0.7.0.1
 */