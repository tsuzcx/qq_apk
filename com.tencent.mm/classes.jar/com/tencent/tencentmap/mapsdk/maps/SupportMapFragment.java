package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SupportMapFragment
  extends Fragment
{
  private boolean isOnTop = false;
  private TencentMap mTencentMap;
  protected MapView mapV = null;
  
  public static SupportMapFragment newInstance(Context paramContext)
  {
    AppMethodBeat.i(181028);
    SupportMapFragment localSupportMapFragment = new SupportMapFragment();
    localSupportMapFragment.initMap(paramContext);
    AppMethodBeat.o(181028);
    return localSupportMapFragment;
  }
  
  public TencentMap getMap()
  {
    AppMethodBeat.i(181030);
    if (this.mTencentMap == null) {
      this.mTencentMap = this.mapV.getMap();
    }
    TencentMap localTencentMap = this.mTencentMap;
    AppMethodBeat.o(181030);
    return localTencentMap;
  }
  
  protected void initMap(Context paramContext)
  {
    AppMethodBeat.i(181029);
    this.mapV = onCreateMapView(paramContext, null);
    AppMethodBeat.o(181029);
  }
  
  protected MapView onCreateMapView(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(181032);
    paramContext = new MapView(paramContext, paramTencentMapOptions);
    AppMethodBeat.o(181032);
    return paramContext;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(181031);
    if (this.mapV == null) {
      this.mapV = onCreateMapView(getActivity().getBaseContext(), null);
    }
    this.mapV.setOnTop(this.isOnTop);
    paramLayoutInflater = this.mapV;
    AppMethodBeat.o(181031);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(181036);
    this.mapV.onDestroy();
    super.onDestroy();
    this.mapV = null;
    AppMethodBeat.o(181036);
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(181035);
    this.mapV.onDestroy();
    super.onDestroyView();
    AppMethodBeat.o(181035);
  }
  
  public void onLowMemory()
  {
    AppMethodBeat.i(181039);
    super.onLowMemory();
    AppMethodBeat.o(181039);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(181034);
    this.mapV.onPause();
    super.onPause();
    AppMethodBeat.o(181034);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(181033);
    this.mapV.onResume();
    super.onResume();
    AppMethodBeat.o(181033);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(181040);
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(181040);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(181037);
    this.mapV.onStart();
    super.onStart();
    AppMethodBeat.o(181037);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(181038);
    this.mapV.onStop();
    super.onStop();
    AppMethodBeat.o(181038);
  }
  
  public void setArguments(Bundle paramBundle)
  {
    AppMethodBeat.i(181041);
    super.setArguments(paramBundle);
    AppMethodBeat.o(181041);
  }
  
  public void setOnTop(boolean paramBoolean)
  {
    this.isOnTop = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.SupportMapFragment
 * JD-Core Version:    0.7.0.1
 */