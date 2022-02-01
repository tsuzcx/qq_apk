package com.tencent.tencentmap.mapsdk.maps.internal;

import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.map.lib.models.GeoPoint;
import com.tencent.mapsdk.internal.ae;
import com.tencent.mapsdk.internal.al;
import com.tencent.mapsdk.internal.az;
import com.tencent.mapsdk.internal.bg;
import com.tencent.mapsdk.internal.bi;
import com.tencent.mapsdk.internal.bn;
import com.tencent.mapsdk.internal.eq;
import com.tencent.mapsdk.internal.mk;
import com.tencent.mapsdk.internal.mk.e;
import com.tencent.mapsdk.internal.ne;
import com.tencent.mapsdk.internal.np;
import com.tencent.mapsdk.internal.rz;
import com.tencent.mapsdk.internal.sc;
import com.tencent.mapsdk.internal.sj;
import com.tencent.mapsdk.internal.sr;
import com.tencent.mapsdk.internal.sv;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.AsyncOperateCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IntersectionOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds.Builder;
import com.tencent.tencentmap.mapsdk.maps.model.MapRouteSection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class TencentMapPro
{
  private sj mVectorMapDelegate;
  private boolean mapDestroyed = false;
  private bg mapManager;
  private ae viewControl;
  
  public TencentMapPro(bg parambg, ae paramae)
  {
    this.mapManager = parambg;
    this.viewControl = paramae;
    this.mVectorMapDelegate = parambg.b;
  }
  
  public final IntersectionOverlay addIntersectionEnlargeOverlay(IntersectionOverlayOptions paramIntersectionOverlayOptions)
  {
    AppMethodBeat.i(217993);
    mk localmk;
    if ((!this.mapDestroyed) && (this.mVectorMapDelegate != null))
    {
      localmk = this.mVectorMapDelegate.aB;
      if (localmk != null) {}
    }
    else
    {
      AppMethodBeat.o(217993);
      return null;
    }
    if (localmk.g == null)
    {
      AppMethodBeat.o(217993);
      return null;
    }
    paramIntersectionOverlayOptions = (IntersectionOverlay)localmk.k.a(new ne(paramIntersectionOverlayOptions));
    AppMethodBeat.o(217993);
    return paramIntersectionOverlayOptions;
  }
  
  public final void addRouteNameSegments(List<MapRouteSectionWithName> paramList, List<LatLng> paramList1)
  {
    AppMethodBeat.i(217981);
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MapRouteSectionWithName localMapRouteSectionWithName = (MapRouteSectionWithName)paramList.next();
        if (localMapRouteSectionWithName != null)
        {
          MapRouteSection localMapRouteSection = new MapRouteSection();
          localMapRouteSection.color = localMapRouteSectionWithName.color;
          localMapRouteSection.endNum = localMapRouteSectionWithName.endNum;
          localMapRouteSection.roadName = localMapRouteSectionWithName.roadName;
          localMapRouteSection.startNum = localMapRouteSectionWithName.startNum;
          localArrayList.add(localMapRouteSection);
        }
      }
      addSegmentsWithRouteName(localArrayList, paramList1);
    }
    AppMethodBeat.o(217981);
  }
  
  public final void addSegmentsWithRouteName(List<MapRouteSection> paramList, List<LatLng> paramList1)
  {
    AppMethodBeat.i(217980);
    if ((this.mapDestroyed) || (this.mapManager == null))
    {
      AppMethodBeat.o(217980);
      return;
    }
    Object localObject = this.mapManager;
    if (((bg)localObject).b != null)
    {
      localObject = (VectorMap)((bg)localObject).b.e_;
      if (localObject != null)
      {
        paramList1 = GeoPoint.from(paramList1);
        localObject = ((VectorMap)localObject).o;
        if (((mk)localObject).z == null) {
          ((mk)localObject).z = new mk.e((mk)localObject);
        }
        localObject = ((mk)localObject).z;
        ((mk.e)localObject).a = paramList;
        ((mk.e)localObject).b = paramList1;
        mk.a(((mk.e)localObject).c).a(paramList, paramList1);
      }
    }
    AppMethodBeat.o(217980);
  }
  
  public final void animateToNaviPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(217939);
    if ((this.mapDestroyed) || (this.mapManager == null))
    {
      AppMethodBeat.o(217939);
      return;
    }
    this.mapManager.a(paramLatLng, paramFloat1, paramFloat2, 0.0F, true);
    AppMethodBeat.o(217939);
  }
  
  public final void animateToNaviPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(217943);
    if ((this.mapDestroyed) || (this.mapManager == null))
    {
      AppMethodBeat.o(217943);
      return;
    }
    this.mapManager.a(paramLatLng, paramFloat1, paramFloat2, paramFloat3, true);
    AppMethodBeat.o(217943);
  }
  
  public final void animateToNaviPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    AppMethodBeat.i(217946);
    if ((this.mapDestroyed) || (this.mapManager == null))
    {
      AppMethodBeat.o(217946);
      return;
    }
    this.mapManager.a(paramLatLng, paramFloat1, paramFloat2, paramFloat3, paramBoolean);
    AppMethodBeat.o(217946);
  }
  
  public final void animateToNaviPosition2(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean)
  {
    AppMethodBeat.i(217950);
    if ((this.mapDestroyed) || (this.mapManager == null))
    {
      AppMethodBeat.o(217950);
      return;
    }
    bg localbg = this.mapManager;
    rz localrz = new rz();
    localrz.b((int)(paramLatLng.latitude * 1000000.0D), (int)(paramLatLng.longitude * 1000000.0D));
    localrz.a(paramFloat3);
    localrz.c(paramFloat1);
    localrz.d(paramFloat2);
    localrz.a = localbg.j;
    localrz.g = true;
    localrz.a(1000L);
    ((VectorMap)localbg.b.e_).w();
    ((VectorMap)localbg.b.e_).a(localrz);
    AppMethodBeat.o(217950);
  }
  
  public final float calNaviLevel(LatLngBounds paramLatLngBounds, float paramFloat, int paramInt, boolean paramBoolean)
  {
    float f = 0.0F;
    AppMethodBeat.i(217953);
    if ((this.mapDestroyed) || (this.mapManager == null))
    {
      AppMethodBeat.o(217953);
      return 0.0F;
    }
    bg localbg = this.mapManager;
    if (paramLatLngBounds == null)
    {
      AppMethodBeat.o(217953);
      return 0.0F;
    }
    int i;
    if (paramBoolean)
    {
      i = localbg.b.L;
      if (paramBoolean) {
        break label139;
      }
      paramFloat = f;
    }
    label139:
    for (;;)
    {
      int j = i;
      if (i < 0) {
        j = localbg.b.ak / 2;
      }
      paramFloat = localbg.a(paramFloat, 0, 0, paramInt, localbg.b.al - j, paramLatLngBounds.southwest, paramLatLngBounds.northeast);
      AppMethodBeat.o(217953);
      return paramFloat;
      i = localbg.b.N;
      break;
    }
  }
  
  public final float calNaviLevel2(LatLng paramLatLng1, LatLng paramLatLng2, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
  {
    paramFloat2 = 0.0F;
    AppMethodBeat.i(217956);
    if ((this.mapDestroyed) || (this.mapManager == null))
    {
      AppMethodBeat.o(217956);
      return 0.0F;
    }
    bg localbg = this.mapManager;
    if ((paramLatLng1 == null) || (paramLatLng2 == null))
    {
      AppMethodBeat.o(217956);
      return 0.0F;
    }
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    localBuilder.include(paramLatLng1);
    localBuilder.include(paramLatLng2);
    if (!paramBoolean) {
      paramFloat1 = paramFloat2;
    }
    for (;;)
    {
      paramFloat1 = localbg.a(paramFloat1, 0, 0, paramInt, 0, localBuilder.build().southwest, localBuilder.build().northeast);
      AppMethodBeat.o(217956);
      return paramFloat1;
    }
  }
  
  public final float calNaviLevel3(LatLng paramLatLng1, LatLng paramLatLng2, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    AppMethodBeat.i(217959);
    if ((this.mapDestroyed) || (this.mapManager == null))
    {
      AppMethodBeat.o(217959);
      return 0.0F;
    }
    bg localbg = this.mapManager;
    if ((paramLatLng1 == null) || (paramLatLng2 == null))
    {
      AppMethodBeat.o(217959);
      return 0.0F;
    }
    LatLngBounds.Builder localBuilder = new LatLngBounds.Builder();
    localBuilder.include(paramLatLng1);
    localBuilder.include(paramLatLng2);
    if (!paramBoolean) {
      paramFloat = 0.0F;
    }
    for (;;)
    {
      paramFloat = localbg.a(paramFloat, paramInt1, paramInt2, paramInt3, paramInt4, localBuilder.build().southwest, localBuilder.build().northeast);
      AppMethodBeat.o(217959);
      return paramFloat;
    }
  }
  
  public final CameraPosition calculateZoomToSpanLevelAsync(List<IOverlay> paramList, List<LatLng> paramList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, TencentMap.AsyncOperateCallback<CameraPosition> paramAsyncOperateCallback)
  {
    AppMethodBeat.i(217976);
    if ((this.mapDestroyed) || (this.mapManager == null))
    {
      if (paramAsyncOperateCallback != null) {
        paramAsyncOperateCallback.onOperateFinished(null);
      }
      AppMethodBeat.o(217976);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        IOverlay localIOverlay = (IOverlay)paramList.next();
        if ((localIOverlay instanceof eq)) {
          localArrayList.add((eq)localIOverlay);
        }
      }
    }
    paramList = this.mapManager.a(localArrayList, paramList1, paramInt1, paramInt2, paramInt3, paramInt4, paramAsyncOperateCallback);
    AppMethodBeat.o(217976);
    return paramList;
  }
  
  public final void clearRouteNameSegments()
  {
    AppMethodBeat.i(217983);
    if ((this.mapDestroyed) || (this.mapManager == null))
    {
      AppMethodBeat.o(217983);
      return;
    }
    Object localObject = this.mapManager;
    if (((bg)localObject).b != null)
    {
      localObject = (VectorMap)((bg)localObject).b.e_;
      if (localObject != null) {
        ((VectorMap)localObject).clearRouteNameSegments();
      }
    }
    AppMethodBeat.o(217983);
  }
  
  public final boolean isNaviStateEnabled()
  {
    AppMethodBeat.i(217990);
    if ((this.mapDestroyed) || (this.mapManager == null))
    {
      AppMethodBeat.o(217990);
      return false;
    }
    boolean bool = this.mapManager.x();
    AppMethodBeat.o(217990);
    return bool;
  }
  
  public final void moveToNavPosition(CameraUpdate paramCameraUpdate, LatLng paramLatLng)
  {
    AppMethodBeat.i(217973);
    if ((this.mapDestroyed) || (this.mapManager == null))
    {
      AppMethodBeat.o(217973);
      return;
    }
    this.mapManager.a(paramCameraUpdate);
    if (paramLatLng != null) {
      setNavCenter((int)(paramLatLng.latitude * 1000000.0D), (int)(paramLatLng.longitude * 1000000.0D));
    }
    AppMethodBeat.o(217973);
  }
  
  public final void onDestroy()
  {
    this.mapDestroyed = true;
  }
  
  public final void setNavCenter(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217986);
    if (this.viewControl == null)
    {
      AppMethodBeat.o(217986);
      return;
    }
    Object localObject = this.viewControl;
    if (((ae)localObject).a == null) {}
    for (localObject = null;; localObject = ((ae)localObject).a.C())
    {
      if ((localObject instanceof sv)) {
        ((sv)localObject).getVectorMapDelegate().b(paramInt1, paramInt2);
      }
      AppMethodBeat.o(217986);
      return;
    }
  }
  
  public final void setNaviFixingProportion(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(217964);
    if ((this.mapDestroyed) || (this.mapManager == null))
    {
      AppMethodBeat.o(217964);
      return;
    }
    bg localbg = this.mapManager;
    float f;
    if (localbg.b != null)
    {
      if (paramFloat1 >= 0.0F) {
        break label122;
      }
      f = 0.0F;
      if (paramFloat2 >= 0.0F) {
        break label135;
      }
      paramFloat1 = 0.0F;
    }
    for (;;)
    {
      int i = (int)(localbg.b.ak * f);
      int j = (int)(localbg.b.al * paramFloat1);
      localbg.b.c(i, j);
      localbg.b.O = f;
      localbg.b.P = paramFloat1;
      AppMethodBeat.o(217964);
      return;
      label122:
      f = paramFloat1;
      if (paramFloat1 <= 1.0F) {
        break;
      }
      f = 1.0F;
      break;
      label135:
      paramFloat1 = paramFloat2;
      if (paramFloat2 > 1.0F) {
        paramFloat1 = 1.0F;
      }
    }
  }
  
  public final void setNaviFixingProportion2D(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(217969);
    if ((this.mapDestroyed) || (this.mapManager == null))
    {
      AppMethodBeat.o(217969);
      return;
    }
    bg localbg = this.mapManager;
    float f;
    if (localbg.b != null)
    {
      if (paramFloat1 >= 0.0F) {
        break label122;
      }
      f = 0.0F;
      if (paramFloat2 >= 0.0F) {
        break label135;
      }
      paramFloat1 = 0.0F;
    }
    for (;;)
    {
      int i = (int)(localbg.b.ak * f);
      int j = (int)(localbg.b.al * paramFloat1);
      localbg.b.d(i, j);
      localbg.b.Q = f;
      localbg.b.R = paramFloat1;
      AppMethodBeat.o(217969);
      return;
      label122:
      f = paramFloat1;
      if (paramFloat1 <= 1.0F) {
        break;
      }
      f = 1.0F;
      break;
      label135:
      paramFloat1 = paramFloat2;
      if (paramFloat2 > 1.0F) {
        paramFloat1 = 1.0F;
      }
    }
  }
  
  public final void setNaviStateEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(217988);
    if ((this.mapDestroyed) || (this.mapManager == null))
    {
      AppMethodBeat.o(217988);
      return;
    }
    this.mapManager.h(paramBoolean);
    AppMethodBeat.o(217988);
  }
  
  public final void setOnCameraChangeListener(TencentMap.OnCameraChangeListener paramOnCameraChangeListener)
  {
    if ((this.mapDestroyed) || (this.mapManager == null)) {}
    bg localbg;
    do
    {
      return;
      localbg = this.mapManager;
    } while (localbg.b == null);
    localbg.b.G = paramOnCameraChangeListener;
  }
  
  public final void setOptionalResourcePath(String paramString)
  {
    AppMethodBeat.i(217992);
    mk localmk;
    if ((!this.mapDestroyed) && (this.mVectorMapDelegate != null))
    {
      localmk = this.mVectorMapDelegate.aB;
      if (localmk != null) {}
    }
    else
    {
      AppMethodBeat.o(217992);
      return;
    }
    if (localmk.x != null) {
      localmk.x.a(paramString);
    }
    AppMethodBeat.o(217992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.internal.TencentMapPro
 * JD-Core Version:    0.7.0.1
 */