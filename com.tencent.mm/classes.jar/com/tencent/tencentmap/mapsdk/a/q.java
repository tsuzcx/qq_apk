package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.CameraParameter;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class q
{
  public static float a(float paramFloat)
  {
    return paramFloat;
  }
  
  public static com.tencent.mapsdk.raster.model.CameraPosition a(com.tencent.tencentmap.mapsdk.maps.model.CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(186301);
    if (paramCameraPosition == null)
    {
      AppMethodBeat.o(186301);
      return null;
    }
    paramCameraPosition = new com.tencent.mapsdk.raster.model.CameraPosition(a(paramCameraPosition.target), b(paramCameraPosition.zoom), paramCameraPosition.tilt, paramCameraPosition.bearing);
    AppMethodBeat.o(186301);
    return paramCameraPosition;
  }
  
  static com.tencent.mapsdk.raster.model.IndoorBuilding a(com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding paramIndoorBuilding)
  {
    AppMethodBeat.i(186314);
    if (paramIndoorBuilding == null)
    {
      AppMethodBeat.o(186314);
      return null;
    }
    List localList = c(paramIndoorBuilding.getLevels());
    if (localList == null)
    {
      AppMethodBeat.o(186314);
      return null;
    }
    paramIndoorBuilding = new com.tencent.mapsdk.raster.model.IndoorBuilding(paramIndoorBuilding.getBuidlingId(), paramIndoorBuilding.getBuildingName(), localList, paramIndoorBuilding.getActiveLevelIndex());
    AppMethodBeat.o(186314);
    return paramIndoorBuilding;
  }
  
  public static com.tencent.mapsdk.raster.model.LatLng a(com.tencent.tencentmap.mapsdk.maps.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(186296);
    if (paramLatLng == null)
    {
      AppMethodBeat.o(186296);
      return null;
    }
    paramLatLng = new com.tencent.mapsdk.raster.model.LatLng(paramLatLng.latitude, paramLatLng.longitude);
    AppMethodBeat.o(186296);
    return paramLatLng;
  }
  
  static com.tencent.mapsdk.raster.model.LatLngBounds a(com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds paramLatLngBounds)
  {
    AppMethodBeat.i(186304);
    if ((paramLatLngBounds == null) || (paramLatLngBounds.northeast == null) || (paramLatLngBounds.southwest == null))
    {
      AppMethodBeat.o(186304);
      return null;
    }
    paramLatLngBounds = new com.tencent.mapsdk.raster.model.LatLngBounds(new com.tencent.mapsdk.raster.model.LatLng(paramLatLngBounds.southwest.latitude, paramLatLngBounds.southwest.longitude), new com.tencent.mapsdk.raster.model.LatLng(paramLatLngBounds.northeast.latitude, paramLatLngBounds.northeast.longitude));
    AppMethodBeat.o(186304);
    return paramLatLngBounds;
  }
  
  public static com.tencent.mapsdk.raster.model.MapPoi a(com.tencent.tencentmap.mapsdk.maps.model.MapPoi paramMapPoi)
  {
    AppMethodBeat.i(186297);
    if (paramMapPoi == null)
    {
      AppMethodBeat.o(186297);
      return null;
    }
    if ((paramMapPoi instanceof com.tencent.tencentmap.mapsdk.maps.model.IndoorMapPoi))
    {
      paramMapPoi = (com.tencent.tencentmap.mapsdk.maps.model.IndoorMapPoi)paramMapPoi;
      paramMapPoi = new com.tencent.mapsdk.raster.model.IndoorMapPoi(paramMapPoi.getName(), a(paramMapPoi.getPosition()), paramMapPoi.getBuildingId(), paramMapPoi.getBuildingName(), paramMapPoi.getFloorName());
      AppMethodBeat.o(186297);
      return paramMapPoi;
    }
    paramMapPoi = new com.tencent.mapsdk.raster.model.MapPoi(paramMapPoi.getName(), a(paramMapPoi.getPosition()));
    AppMethodBeat.o(186297);
    return paramMapPoi;
  }
  
  public static com.tencent.mapsdk.raster.model.VisibleRegion a(com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion paramVisibleRegion)
  {
    AppMethodBeat.i(186302);
    if (paramVisibleRegion == null)
    {
      AppMethodBeat.o(186302);
      return null;
    }
    paramVisibleRegion = new com.tencent.mapsdk.raster.model.VisibleRegion(a(paramVisibleRegion.nearLeft), a(paramVisibleRegion.nearRight), a(paramVisibleRegion.farLeft), a(paramVisibleRegion.farRight), a(paramVisibleRegion.latLngBounds));
    AppMethodBeat.o(186302);
    return paramVisibleRegion;
  }
  
  static com.tencent.tencentmap.mapsdk.maps.CameraUpdate a(com.tencent.tencentmap.mapsdk.map.CameraUpdate paramCameraUpdate, TencentMap paramTencentMap)
  {
    AppMethodBeat.i(186313);
    if ((paramCameraUpdate == null) || (paramCameraUpdate.getParams() == null))
    {
      AppMethodBeat.o(186313);
      return null;
    }
    CameraParameter localCameraParameter = paramCameraUpdate.getParams();
    int j;
    int i;
    int m;
    int k;
    switch (paramCameraUpdate.getParams().cameraUpdate_type)
    {
    default: 
      AppMethodBeat.o(186313);
      return null;
    case 6: 
      paramCameraUpdate = CameraUpdateFactory.newCameraPosition(a(localCameraParameter.newCameraPosition));
      AppMethodBeat.o(186313);
      return paramCameraUpdate;
    case 7: 
      paramCameraUpdate = CameraUpdateFactory.newLatLng(a(localCameraParameter.newLatLng));
      AppMethodBeat.o(186313);
      return paramCameraUpdate;
    case 9: 
      paramCameraUpdate = CameraUpdateFactory.newLatLngBounds(a(localCameraParameter.newLatLngBounds_bounds), localCameraParameter.newLatLngBounds_padding);
      AppMethodBeat.o(186313);
      return paramCameraUpdate;
    case 10: 
      if ((paramTencentMap != null) && (paramTencentMap.getMapWidth() != 0) && (paramTencentMap.getMapWidth() != 0)) {
        if (localCameraParameter.newLatLngBounds_dimension_width < paramTencentMap.getMapWidth())
        {
          j = paramTencentMap.getMapWidth() / 2 - (localCameraParameter.newLatLngBounds_dimension_width / 2 - localCameraParameter.newLatLngBounds_dimension_padding);
          i = j;
          if (localCameraParameter.newLatLngBounds_dimension_height < paramTencentMap.getMapHeight())
          {
            m = paramTencentMap.getMapHeight() / 2 - (localCameraParameter.newLatLngBounds_dimension_height / 2 - localCameraParameter.newLatLngBounds_dimension_padding);
            k = m;
          }
        }
      }
      break;
    }
    for (;;)
    {
      paramCameraUpdate = CameraUpdateFactory.newLatLngBoundsRect(a(localCameraParameter.newLatLngBounds_dimension_bounds), i, j, m, k);
      AppMethodBeat.o(186313);
      return paramCameraUpdate;
      paramCameraUpdate = CameraUpdateFactory.newLatLngZoom(a(localCameraParameter.newLatLngZoom_latlng), a(localCameraParameter.newLatLngZoom_zoom));
      AppMethodBeat.o(186313);
      return paramCameraUpdate;
      paramCameraUpdate = CameraUpdateFactory.scrollBy(localCameraParameter.scrollBy_xPixel, localCameraParameter.scrollBy_yPixel);
      AppMethodBeat.o(186313);
      return paramCameraUpdate;
      paramCameraUpdate = CameraUpdateFactory.zoomBy(localCameraParameter.zoomBy_Point_amount, localCameraParameter.zoomBy_Point_focus);
      AppMethodBeat.o(186313);
      return paramCameraUpdate;
      paramCameraUpdate = CameraUpdateFactory.zoomBy(localCameraParameter.zoomBy_amount);
      AppMethodBeat.o(186313);
      return paramCameraUpdate;
      paramCameraUpdate = CameraUpdateFactory.zoomIn();
      AppMethodBeat.o(186313);
      return paramCameraUpdate;
      paramCameraUpdate = CameraUpdateFactory.zoomOut();
      AppMethodBeat.o(186313);
      return paramCameraUpdate;
      float f;
      if (localCameraParameter.zoomTo_zoom < paramTencentMap.getMinZoomLevel()) {
        f = paramTencentMap.getMinZoomLevel();
      }
      for (;;)
      {
        paramCameraUpdate = CameraUpdateFactory.zoomTo(a(f));
        AppMethodBeat.o(186313);
        return paramCameraUpdate;
        if (localCameraParameter.zoomTo_zoom > paramTencentMap.getMaxZoomLevel()) {
          f = paramTencentMap.getMaxZoomLevel();
        } else {
          f = localCameraParameter.zoomTo_zoom;
        }
      }
      paramCameraUpdate = CameraUpdateFactory.newLatLngBoundsWithMapCenter(a(localCameraParameter.newLatLngBounds_bounds), a(localCameraParameter.newLatLng), localCameraParameter.newLatLngBounds_padding);
      AppMethodBeat.o(186313);
      return paramCameraUpdate;
      paramCameraUpdate = CameraUpdateFactory.newLatLngBoundsRect(a(localCameraParameter.newLatLngBounds_dimension_bounds), localCameraParameter.newLatLngBoundsRects_padLeft, localCameraParameter.newLatLngBoundsRects_padRight, localCameraParameter.newLatLngBoundsRects_padTop, localCameraParameter.newLatLngBoundsRects_padBom);
      AppMethodBeat.o(186313);
      return paramCameraUpdate;
      k = 0;
      m = 0;
      continue;
      i = 0;
      j = 0;
      break;
      k = 0;
      i = 0;
      m = 0;
      j = 0;
    }
  }
  
  public static com.tencent.tencentmap.mapsdk.maps.model.CameraPosition a(com.tencent.mapsdk.raster.model.CameraPosition paramCameraPosition)
  {
    AppMethodBeat.i(186300);
    if (paramCameraPosition == null)
    {
      AppMethodBeat.o(186300);
      return null;
    }
    paramCameraPosition = new com.tencent.tencentmap.mapsdk.maps.model.CameraPosition(a(paramCameraPosition.getTarget()), a(paramCameraPosition.getZoom()), paramCameraPosition.getSkew(), paramCameraPosition.getBearing());
    AppMethodBeat.o(186300);
    return paramCameraPosition;
  }
  
  public static com.tencent.tencentmap.mapsdk.maps.model.CircleOptions a(com.tencent.mapsdk.raster.model.CircleOptions paramCircleOptions)
  {
    AppMethodBeat.i(186305);
    if (paramCircleOptions == null)
    {
      AppMethodBeat.o(186305);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.model.CircleOptions localCircleOptions = new com.tencent.tencentmap.mapsdk.maps.model.CircleOptions();
    com.tencent.tencentmap.mapsdk.maps.model.LatLng localLatLng = a(paramCircleOptions.getCenter());
    if (localLatLng != null) {
      localCircleOptions.center(localLatLng);
    }
    localCircleOptions.center(a(paramCircleOptions.getCenter())).fillColor(paramCircleOptions.getFillColor()).radius(paramCircleOptions.getRadius()).strokeColor(paramCircleOptions.getStrokeColor()).strokeWidth(paramCircleOptions.getStrokeWidth()).visible(paramCircleOptions.isVisible()).zIndex((int)paramCircleOptions.getZIndex()).level(paramCircleOptions.getLevel());
    AppMethodBeat.o(186305);
    return localCircleOptions;
  }
  
  public static com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions a(com.tencent.mapsdk.raster.model.CustomLayerOptions paramCustomLayerOptions)
  {
    AppMethodBeat.i(186311);
    if (paramCustomLayerOptions == null)
    {
      AppMethodBeat.o(186311);
      return null;
    }
    paramCustomLayerOptions = new com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions().layerId(paramCustomLayerOptions.getLayerId());
    AppMethodBeat.o(186311);
    return paramCustomLayerOptions;
  }
  
  static com.tencent.tencentmap.mapsdk.maps.model.IndoorInfo a(com.tencent.mapsdk.raster.model.IndoorInfo paramIndoorInfo)
  {
    AppMethodBeat.i(186315);
    if (paramIndoorInfo == null)
    {
      AppMethodBeat.o(186315);
      return null;
    }
    paramIndoorInfo = new com.tencent.tencentmap.mapsdk.maps.model.IndoorInfo(paramIndoorInfo.getBuildingId(), paramIndoorInfo.getFloorName());
    AppMethodBeat.o(186315);
    return paramIndoorInfo;
  }
  
  public static com.tencent.tencentmap.mapsdk.maps.model.Language a(com.tencent.mapsdk.raster.model.Language paramLanguage)
  {
    AppMethodBeat.i(186317);
    if (paramLanguage == null)
    {
      paramLanguage = com.tencent.tencentmap.mapsdk.maps.model.Language.zh;
      AppMethodBeat.o(186317);
      return paramLanguage;
    }
    switch (3.a[paramLanguage.ordinal()])
    {
    default: 
      paramLanguage = com.tencent.tencentmap.mapsdk.maps.model.Language.zh;
      AppMethodBeat.o(186317);
      return paramLanguage;
    case 1: 
      paramLanguage = com.tencent.tencentmap.mapsdk.maps.model.Language.zh;
      AppMethodBeat.o(186317);
      return paramLanguage;
    }
    paramLanguage = com.tencent.tencentmap.mapsdk.maps.model.Language.en;
    AppMethodBeat.o(186317);
    return paramLanguage;
  }
  
  public static com.tencent.tencentmap.mapsdk.maps.model.LatLng a(com.tencent.mapsdk.raster.model.LatLng paramLatLng)
  {
    AppMethodBeat.i(186295);
    if (paramLatLng == null)
    {
      AppMethodBeat.o(186295);
      return null;
    }
    paramLatLng = new com.tencent.tencentmap.mapsdk.maps.model.LatLng(paramLatLng.getLatitude(), paramLatLng.getLongitude());
    AppMethodBeat.o(186295);
    return paramLatLng;
  }
  
  static com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds a(com.tencent.mapsdk.raster.model.LatLngBounds paramLatLngBounds)
  {
    AppMethodBeat.i(186303);
    if ((paramLatLngBounds == null) || (paramLatLngBounds.getNortheast() == null) || (paramLatLngBounds.getSouthwest() == null))
    {
      AppMethodBeat.o(186303);
      return null;
    }
    paramLatLngBounds = new com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds(new com.tencent.tencentmap.mapsdk.maps.model.LatLng(paramLatLngBounds.getSouthwest().getLatitude(), paramLatLngBounds.getSouthwest().getLongitude()), new com.tencent.tencentmap.mapsdk.maps.model.LatLng(paramLatLngBounds.getNortheast().getLatitude(), paramLatLngBounds.getNortheast().getLongitude()));
    AppMethodBeat.o(186303);
    return paramLatLngBounds;
  }
  
  public static com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions a(com.tencent.mapsdk.raster.model.MarkerOptions paramMarkerOptions)
  {
    AppMethodBeat.i(186306);
    if (paramMarkerOptions == null)
    {
      AppMethodBeat.o(186306);
      return null;
    }
    Object localObject = a(paramMarkerOptions.getPosition());
    if (localObject == null)
    {
      AppMethodBeat.o(186306);
      return null;
    }
    localObject = new com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions((com.tencent.tencentmap.mapsdk.maps.model.LatLng)localObject);
    com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions localMarkerOptions = ((com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions)localObject).alpha(paramMarkerOptions.getAlpha()).visible(paramMarkerOptions.isVisible()).draggable(paramMarkerOptions.isDraggable()).anchor(paramMarkerOptions.getAnchorU(), paramMarkerOptions.getAnchorV()).rotation(paramMarkerOptions.getRotation()).indoorInfo(a(paramMarkerOptions.getIndoorInfo())).zIndex(paramMarkerOptions.getZIndex()).level(paramMarkerOptions.getLevel()).flat(paramMarkerOptions.isFlat());
    if (paramMarkerOptions.isFlat() != paramMarkerOptions.isClockwise()) {}
    for (boolean bool = true;; bool = false)
    {
      localMarkerOptions.clockwise(bool).infoWindowOffset(paramMarkerOptions.getInfoWindowOffsetX(), paramMarkerOptions.getInfowindowOffsetY()).contentDescription(paramMarkerOptions.getContentDescription());
      if (paramMarkerOptions.getIcon() != null) {
        ((com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions)localObject).icon(BitmapDescriptorFactory.fromBitmap(paramMarkerOptions.getIcon().getBitmap()));
      }
      if (paramMarkerOptions.getMarkerView() != null) {
        ((com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions)localObject).icon(BitmapDescriptorFactory.fromView(paramMarkerOptions.getMarkerView()));
      }
      if (paramMarkerOptions.getSnippet() != null) {
        ((com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions)localObject).snippet(paramMarkerOptions.getSnippet());
      }
      if (paramMarkerOptions.getTitle() != null) {
        ((com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions)localObject).title(paramMarkerOptions.getTitle());
      }
      if (paramMarkerOptions.getTag() != null) {
        ((com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions)localObject).tag(paramMarkerOptions.getTag());
      }
      AppMethodBeat.o(186306);
      return localObject;
    }
  }
  
  public static com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions a(com.tencent.mapsdk.raster.model.PolygonOptions paramPolygonOptions)
  {
    AppMethodBeat.i(186308);
    if (paramPolygonOptions == null)
    {
      AppMethodBeat.o(186308);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions localPolygonOptions = new com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions();
    List localList = b(paramPolygonOptions.getPoints());
    if ((localList != null) && (localList.size() > 2))
    {
      localPolygonOptions.addAll(localList);
      localPolygonOptions.visible(paramPolygonOptions.isVisible()).zIndex((int)paramPolygonOptions.getZIndex()).level(paramPolygonOptions.getLevel()).strokeWidth(paramPolygonOptions.getStrokeWidth()).strokeColor(paramPolygonOptions.getStrokeColor()).fillColor(paramPolygonOptions.getFillColor());
      AppMethodBeat.o(186308);
      return localPolygonOptions;
    }
    AppMethodBeat.o(186308);
    return null;
  }
  
  public static com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions a(com.tencent.mapsdk.raster.model.PolylineOptions paramPolylineOptions)
  {
    AppMethodBeat.i(186307);
    if (paramPolylineOptions == null)
    {
      AppMethodBeat.o(186307);
      return null;
    }
    com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions localPolylineOptions = new com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions();
    Object localObject = b(paramPolylineOptions.getPoints());
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      AppMethodBeat.o(186307);
      return null;
    }
    localPolylineOptions.addAll((Iterable)localObject);
    float f = paramPolylineOptions.getWidth();
    localPolylineOptions.zIndex((int)paramPolylineOptions.getZIndex()).level(paramPolylineOptions.getLevel()).width(f).visible(paramPolylineOptions.isVisible()).color(paramPolylineOptions.getColor()).borderColor(paramPolylineOptions.getEdgeColor()).borderWidth(paramPolylineOptions.getEdgeWidth()).lineType(paramPolylineOptions.getLineType()).eraseColor(paramPolylineOptions.getEraseColor()).indoorInfo(a(paramPolylineOptions.getIndoorInfo()));
    if (paramPolylineOptions.getColorTexture() != null) {
      localPolylineOptions.colorTexture(BitmapDescriptorFactory.fromBitmap(paramPolylineOptions.getColorTexture().getBitmap()));
    }
    if (paramPolylineOptions.getArrowTexture() != null)
    {
      localPolylineOptions.arrow(true);
      localPolylineOptions.arrowSpacing((int)paramPolylineOptions.getArrowGap());
      localObject = new Matrix();
      ((Matrix)localObject).postRotate(-90.0F);
    }
    try
    {
      Bitmap localBitmap = paramPolylineOptions.getArrowTexture().getBitmap();
      localBitmap = Bitmap.createScaledBitmap(localBitmap, localBitmap.getWidth(), localBitmap.getHeight(), true);
      localPolylineOptions.arrowTexture(BitmapDescriptorFactory.fromBitmap(Bitmap.createBitmap(localBitmap, 0, 0, localBitmap.getWidth(), localBitmap.getHeight(), (Matrix)localObject, true)));
      label254:
      if (paramPolylineOptions.isDottedLine())
      {
        localObject = new ArrayList();
        ((List)localObject).add(Integer.valueOf((int)(3.0F * paramPolylineOptions.getWidth())));
        ((List)localObject).add(Integer.valueOf((int)paramPolylineOptions.getWidth()));
        localPolylineOptions.pattern((List)localObject);
      }
      if (paramPolylineOptions.getColors() != null) {
        localPolylineOptions.colors(paramPolylineOptions.getColors()[0], paramPolylineOptions.getColors()[1]);
      }
      AppMethodBeat.o(186307);
      return localPolylineOptions;
    }
    catch (Exception localException)
    {
      break label254;
    }
  }
  
  public static com.tencent.tencentmap.mapsdk.maps.model.Tile a(com.tencent.mapsdk.raster.model.Tile paramTile)
  {
    AppMethodBeat.i(186312);
    if (paramTile == null)
    {
      AppMethodBeat.o(186312);
      return null;
    }
    paramTile = new com.tencent.tencentmap.mapsdk.maps.model.Tile(paramTile.mWidth, paramTile.mHeight, paramTile.mData);
    AppMethodBeat.o(186312);
    return paramTile;
  }
  
  public static com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions a(com.tencent.mapsdk.raster.model.TileOverlayOptions paramTileOverlayOptions)
  {
    AppMethodBeat.i(186309);
    if (paramTileOverlayOptions == null)
    {
      AppMethodBeat.o(186309);
      return null;
    }
    paramTileOverlayOptions = new com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions().tileProvider(a(paramTileOverlayOptions.getTileProvider())).diskCacheDir(paramTileOverlayOptions.getDiskCacheDir()).versionInfo(paramTileOverlayOptions.getVersionInfo()).zIndex(paramTileOverlayOptions.getZIndex()).betterQuality(paramTileOverlayOptions.isBetterQuality());
    AppMethodBeat.o(186309);
    return paramTileOverlayOptions;
  }
  
  public static com.tencent.tencentmap.mapsdk.maps.model.TileProvider a(final com.tencent.mapsdk.raster.model.TileProvider paramTileProvider)
  {
    AppMethodBeat.i(186310);
    if (paramTileProvider == null)
    {
      AppMethodBeat.o(186310);
      return null;
    }
    if ((paramTileProvider instanceof com.tencent.mapsdk.raster.model.UrlTileProvider))
    {
      paramTileProvider = new com.tencent.tencentmap.mapsdk.maps.model.UrlTileProvider(((com.tencent.mapsdk.raster.model.UrlTileProvider)paramTileProvider).mWidth, ((com.tencent.mapsdk.raster.model.UrlTileProvider)paramTileProvider).mHeight)
      {
        public final URL getTileUrl(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          AppMethodBeat.i(186405);
          URL localURL = ((com.tencent.mapsdk.raster.model.UrlTileProvider)paramTileProvider).getTileUrl(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
          AppMethodBeat.o(186405);
          return localURL;
        }
      };
      AppMethodBeat.o(186310);
      return paramTileProvider;
    }
    paramTileProvider = new com.tencent.tencentmap.mapsdk.maps.model.TileProvider()
    {
      public final com.tencent.tencentmap.mapsdk.maps.model.Tile getTile(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(186384);
        com.tencent.tencentmap.mapsdk.maps.model.Tile localTile = q.a(this.a.getTile(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3));
        AppMethodBeat.o(186384);
        return localTile;
      }
    };
    AppMethodBeat.o(186310);
    return paramTileProvider;
  }
  
  public static List<com.tencent.mapsdk.raster.model.LatLng> a(List<com.tencent.tencentmap.mapsdk.maps.model.LatLng> paramList)
  {
    AppMethodBeat.i(186298);
    if (paramList == null)
    {
      AppMethodBeat.o(186298);
      return null;
    }
    paramList = (com.tencent.tencentmap.mapsdk.maps.model.LatLng[])paramList.toArray(new com.tencent.tencentmap.mapsdk.maps.model.LatLng[paramList.size()]);
    ArrayList localArrayList = new ArrayList();
    int j = paramList.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(a(paramList[i]));
      i += 1;
    }
    AppMethodBeat.o(186298);
    return localArrayList;
  }
  
  public static float b(float paramFloat)
  {
    return paramFloat;
  }
  
  public static List<com.tencent.tencentmap.mapsdk.maps.model.LatLng> b(List<com.tencent.mapsdk.raster.model.LatLng> paramList)
  {
    AppMethodBeat.i(186299);
    if (paramList == null)
    {
      AppMethodBeat.o(186299);
      return null;
    }
    paramList = (com.tencent.mapsdk.raster.model.LatLng[])paramList.toArray(new com.tencent.mapsdk.raster.model.LatLng[paramList.size()]);
    ArrayList localArrayList = new ArrayList();
    int j = paramList.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(a(paramList[i]));
      i += 1;
    }
    AppMethodBeat.o(186299);
    return localArrayList;
  }
  
  static List<com.tencent.mapsdk.raster.model.IndoorLevel> c(List<com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel> paramList)
  {
    AppMethodBeat.i(186316);
    if (paramList == null)
    {
      AppMethodBeat.o(186316);
      return null;
    }
    Object localObject = new CopyOnWriteArrayList(paramList);
    paramList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel localIndoorLevel = (com.tencent.tencentmap.mapsdk.maps.model.IndoorLevel)((Iterator)localObject).next();
      if (localIndoorLevel == null)
      {
        AppMethodBeat.o(186316);
        return null;
      }
      paramList.add(new com.tencent.mapsdk.raster.model.IndoorLevel(localIndoorLevel.getName()));
    }
    AppMethodBeat.o(186316);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.q
 * JD-Core Version:    0.7.0.1
 */