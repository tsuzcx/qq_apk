package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.MapViewType;

public class MapRenderLayer
  extends MapView
{
  public MapRenderLayer(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext, paramTencentMapOptions);
    AppMethodBeat.i(181003);
    onResume();
    AppMethodBeat.o(181003);
  }
  
  protected final MapViewType getViewType()
  {
    return MapViewType.RenderLayer;
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(181004);
    if ((!(paramObject instanceof Surface)) && (!(paramObject instanceof SurfaceTexture)) && (!(paramObject instanceof SurfaceHolder)))
    {
      AppMethodBeat.o(181004);
      return;
    }
    super.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    AppMethodBeat.o(181004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.MapRenderLayer
 * JD-Core Version:    0.7.0.1
 */