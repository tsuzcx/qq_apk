package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.map.internal.a;
import com.tencent.map.internal.a.2;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.sheet.SheetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MapView
  extends BaseMapView
{
  private TencentMap mMap;
  private BaseMapView.MapViewProxy mMapDelegate;
  private TencentMapOptions mMapOptions;
  
  static
  {
    AppMethodBeat.i(181027);
    System.loadLibrary("txmapengine");
    AppMethodBeat.o(181027);
  }
  
  public MapView(Context paramContext)
  {
    this(paramContext, new TencentMapOptions());
    AppMethodBeat.i(181008);
    AppMethodBeat.o(181008);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(181010);
    this.mMap = getMap(new TencentMapOptions());
    AppMethodBeat.o(181010);
  }
  
  public MapView(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext);
    AppMethodBeat.i(181009);
    this.mMap = getMap(paramTencentMapOptions);
    AppMethodBeat.o(181009);
  }
  
  private <T extends TencentMap> void getMapSync(TencentMapOptions paramTencentMapOptions, final Callback<T> paramCallback)
  {
    AppMethodBeat.i(181014);
    paramTencentMapOptions.setGetMapAsync(new Callback() {});
    initMap(paramTencentMapOptions);
    AppMethodBeat.o(181014);
  }
  
  private void initMap(TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(181011);
    if ((this.mMap != null) && ((this.mMapOptions == paramTencentMapOptions) || (this.mMapOptions.equals(paramTencentMapOptions))))
    {
      AppMethodBeat.o(181011);
      return;
    }
    TencentMapOptions localTencentMapOptions = paramTencentMapOptions;
    if (paramTencentMapOptions == null) {
      localTencentMapOptions = new TencentMapOptions();
    }
    if (localTencentMapOptions.getMapViewType() == null) {
      localTencentMapOptions.setMapViewType(getViewType());
    }
    if (localTencentMapOptions.getMapKernel() == null) {
      localTencentMapOptions.setMapKernel(getMapKernel());
    }
    setClickable(true);
    if ((this.mMap != null) && (this.mMapDelegate != null))
    {
      this.mMapDelegate.onPause();
      this.mMapDelegate.onStop();
      this.mMapDelegate.onDestroy();
      this.mMapDelegate = null;
      this.mMap = null;
    }
    Object localObject = localTencentMapOptions.getMapAsyncCallback();
    if (this.mMapDelegate == null)
    {
      paramTencentMapOptions = new a(getContext().getApplicationContext(), localTencentMapOptions);
      if (localObject == null) {
        break label217;
      }
      localObject = new Callback() {};
      SheetManager.getInstance().initAsync(paramTencentMapOptions.b, paramTencentMapOptions.a, new a.2(paramTencentMapOptions, this, localTencentMapOptions, (Callback)localObject));
    }
    for (;;)
    {
      this.mMapOptions = localTencentMapOptions;
      AppMethodBeat.o(181011);
      return;
      label217:
      SheetManager.getInstance().init(paramTencentMapOptions.b, paramTencentMapOptions.a);
      this.mMapDelegate = paramTencentMapOptions.a(this, localTencentMapOptions);
    }
  }
  
  public TencentMap getMap()
  {
    AppMethodBeat.i(181012);
    if (this.mMap != null)
    {
      localTencentMap = this.mMap;
      AppMethodBeat.o(181012);
      return localTencentMap;
    }
    TencentMap localTencentMap = getMap(this.mMapOptions);
    AppMethodBeat.o(181012);
    return localTencentMap;
  }
  
  public TencentMap getMap(TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(181013);
    initMap(paramTencentMapOptions);
    if (this.mMapDelegate != null)
    {
      paramTencentMapOptions = this.mMapDelegate.getMap();
      AppMethodBeat.o(181013);
      return paramTencentMapOptions;
    }
    AppMethodBeat.o(181013);
    return null;
  }
  
  public int[] getMapPadding()
  {
    AppMethodBeat.i(181024);
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int k = getPaddingRight();
    int m = getPaddingBottom();
    AppMethodBeat.o(181024);
    return new int[] { i, j, k, m };
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(181021);
    if (this.mMapDelegate != null)
    {
      this.mMapDelegate.onDestroy();
      this.mMapDelegate = null;
    }
    this.mMapOptions = null;
    this.mMap = null;
    AppMethodBeat.o(181021);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(181018);
    if (this.mMapDelegate != null) {
      this.mMapDelegate.onPause();
    }
    AppMethodBeat.o(181018);
  }
  
  public void onRestart()
  {
    AppMethodBeat.i(181019);
    if (this.mMapDelegate != null) {
      this.mMapDelegate.onRestart();
    }
    AppMethodBeat.o(181019);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(181017);
    if (this.mMapDelegate != null) {
      this.mMapDelegate.onResume();
    }
    AppMethodBeat.o(181017);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(181025);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mMapDelegate != null) {
      this.mMapDelegate.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(181025);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(181016);
    if (this.mMapDelegate != null) {
      this.mMapDelegate.onStart();
    }
    AppMethodBeat.o(181016);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(181020);
    if (this.mMapDelegate != null) {
      this.mMapDelegate.onStop();
    }
    AppMethodBeat.o(181020);
  }
  
  public void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181026);
    if ((!(paramObject instanceof Surface)) && (!(paramObject instanceof SurfaceTexture)) && (!(paramObject instanceof SurfaceHolder)))
    {
      AppMethodBeat.o(181026);
      return;
    }
    if (this.mMapDelegate != null) {
      this.mMapDelegate.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
    AppMethodBeat.o(181026);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(181015);
    if ((this.mMapDelegate != null) && (this.mMapDelegate.isTouchable()))
    {
      bool = this.mMapDelegate.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(181015);
      return bool;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(181015);
    return bool;
  }
  
  public void setMapPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(181023);
    setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(181023);
  }
  
  public void setOnTop(boolean paramBoolean)
  {
    AppMethodBeat.i(181022);
    if (this.mMapDelegate != null) {
      this.mMapDelegate.setOnTop(paramBoolean);
    }
    AppMethodBeat.o(181022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.MapView
 * JD-Core Version:    0.7.0.1
 */