package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.ViewParent;
import com.tencent.map.tools.Callback;
import com.tencent.mapsdk.internal.t;
import com.tencent.mapsdk.internal.t.1;
import com.tencent.mapsdk.internal.u;
import com.tencent.mapsdk.internal.u.4;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MapView
  extends BaseMapView
{
  private TencentMap mMap;
  protected BaseMapView.MapViewProxy mMapDelegate;
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
    this(paramContext, paramAttributeSet, 0, new TencentMapOptions());
    AppMethodBeat.i(217894);
    AppMethodBeat.o(217894);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, new TencentMapOptions());
    AppMethodBeat.i(181010);
    AppMethodBeat.o(181010);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(217907);
    this.mMap = getMap(paramTencentMapOptions);
    AppMethodBeat.o(217907);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet, TencentMapOptions paramTencentMapOptions)
  {
    this(paramContext, paramAttributeSet, 0, paramTencentMapOptions);
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
    paramTencentMapOptions.setGetMapAsync(new Callback()
    {
      private void a(final TencentMap paramAnonymousTencentMap)
      {
        AppMethodBeat.i(217928);
        paramAnonymousTencentMap.addOnMapLoadedCallback(new TencentMap.OnMapLoadedCallback()
        {
          public final void onMapLoaded()
          {
            AppMethodBeat.i(181006);
            if (MapView.2.this.a != null) {
              MapView.2.this.a.callback(paramAnonymousTencentMap);
            }
            paramAnonymousTencentMap.removeOnMapLoadedCallback(this);
            AppMethodBeat.o(181006);
          }
        });
        AppMethodBeat.o(217928);
      }
    });
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
      paramTencentMapOptions = new t(getContext().getApplicationContext());
      if (localObject == null) {
        break label257;
      }
      Callback local1 = new Callback()
      {
        private void a(BaseMapView.MapViewProxy paramAnonymousMapViewProxy)
        {
          AppMethodBeat.i(217929);
          MapView.this.mMapDelegate = paramAnonymousMapViewProxy;
          if (paramAnonymousMapViewProxy != null)
          {
            MapView.this.mMapDelegate.onResume();
            this.a.callback(paramAnonymousMapViewProxy.getMap());
          }
          AppMethodBeat.o(217929);
        }
      };
      localObject = u.a();
      Context localContext = paramTencentMapOptions.a;
      String str = paramTencentMapOptions.a(localTencentMapOptions);
      paramTencentMapOptions = new t.1(paramTencentMapOptions, this, localTencentMapOptions, local1);
      new Thread(new u.4((u)localObject, localContext, str, new Handler(Looper.getMainLooper()), paramTencentMapOptions), "tms-plugin").start();
    }
    for (;;)
    {
      this.mMapOptions = localTencentMapOptions;
      AppMethodBeat.o(181011);
      return;
      label257:
      this.mMapDelegate = paramTencentMapOptions.a(this, localTencentMapOptions);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(217934);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if ((!bool) && (this.mMapDelegate != null) && (this.mMapDelegate.isTouchable()))
    {
      ViewParent localViewParent = getParent();
      if (localViewParent != null) {
        localViewParent.requestDisallowInterceptTouchEvent(this.mMapOptions.isDisallowInterceptTouchEvent());
      }
      bool = this.mMapDelegate.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(217934);
      return bool;
    }
    AppMethodBeat.o(217934);
    return bool;
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
    u.a();
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
    u.a();
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
    AppMethodBeat.o(181015);
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.MapView
 * JD-Core Version:    0.7.0.1
 */