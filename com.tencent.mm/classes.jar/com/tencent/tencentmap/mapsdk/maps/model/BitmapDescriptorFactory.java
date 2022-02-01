package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class BitmapDescriptorFactory
{
  public static final float HUE_AZURE = 210.0F;
  public static final float HUE_BLUE = 240.0F;
  public static final float HUE_CYAN = 180.0F;
  public static final float HUE_GREEN = 120.0F;
  public static final float HUE_MAGENTA = 300.0F;
  public static final float HUE_ORANGE = 30.0F;
  public static final float HUE_RED = 0.0F;
  public static final float HUE_ROSE = 330.0F;
  public static final float HUE_VIOLET = 270.0F;
  public static final float HUE_YELLOW = 60.0F;
  private static AtomicInteger sAttachIndex;
  private static List<TencentMapContext> sTencentMapContextList;
  
  static
  {
    AppMethodBeat.i(237384);
    sTencentMapContextList = new CopyOnWriteArrayList();
    sAttachIndex = new AtomicInteger(0);
    AppMethodBeat.o(237384);
  }
  
  public static void attachMapContext(TencentMapContext paramTencentMapContext)
  {
    AppMethodBeat.i(181049);
    if (!sTencentMapContextList.contains(paramTencentMapContext))
    {
      sTencentMapContextList.add(paramTencentMapContext);
      sAttachIndex.incrementAndGet();
    }
    AppMethodBeat.o(181049);
  }
  
  private static Bitmap createBitmapFromBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(181057);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramBitmap != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (!paramBitmap.isRecycled()) {
        localObject1 = Bitmap.createBitmap(paramBitmap);
      }
      AppMethodBeat.o(181057);
      return localObject1;
    }
    catch (Throwable paramBitmap)
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
  }
  
  public static BitmapDescriptor defaultMarker()
  {
    AppMethodBeat.i(173087);
    Object localObject = getActiveMapContext();
    if (localObject != null)
    {
      localObject = defaultMarker((TencentMapContext)localObject);
      AppMethodBeat.o(173087);
      return localObject;
    }
    AppMethodBeat.o(173087);
    return null;
  }
  
  public static BitmapDescriptor defaultMarker(float paramFloat)
  {
    AppMethodBeat.i(173088);
    Object localObject = getActiveMapContext();
    if (localObject != null)
    {
      localObject = defaultMarker((TencentMapContext)localObject, paramFloat);
      AppMethodBeat.o(173088);
      return localObject;
    }
    AppMethodBeat.o(173088);
    return null;
  }
  
  public static BitmapDescriptor defaultMarker(TencentMapContext paramTencentMapContext)
  {
    AppMethodBeat.i(181054);
    paramTencentMapContext = paramTencentMapContext.createBitmapDescriptor(5);
    AppMethodBeat.o(181054);
    return paramTencentMapContext;
  }
  
  public static BitmapDescriptor defaultMarker(TencentMapContext paramTencentMapContext, float paramFloat)
  {
    AppMethodBeat.i(181055);
    paramTencentMapContext = paramTencentMapContext.createBitmapDescriptor(paramFloat, 6);
    AppMethodBeat.o(181055);
    return paramTencentMapContext;
  }
  
  public static void detachMapContext(TencentMapContext paramTencentMapContext)
  {
    AppMethodBeat.i(237370);
    if (sTencentMapContextList.remove(paramTencentMapContext)) {
      sAttachIndex.decrementAndGet();
    }
    AppMethodBeat.o(237370);
  }
  
  public static BitmapDescriptor fromAsset(TencentMapContext paramTencentMapContext, String paramString)
  {
    AppMethodBeat.i(181051);
    paramTencentMapContext = paramTencentMapContext.createBitmapDescriptor(paramString, 2);
    AppMethodBeat.o(181051);
    return paramTencentMapContext;
  }
  
  public static BitmapDescriptor fromAsset(String paramString)
  {
    AppMethodBeat.i(173084);
    TencentMapContext localTencentMapContext = getActiveMapContext();
    if (localTencentMapContext != null)
    {
      paramString = fromAsset(localTencentMapContext, paramString);
      AppMethodBeat.o(173084);
      return paramString;
    }
    AppMethodBeat.o(173084);
    return null;
  }
  
  public static BitmapDescriptor fromBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(173089);
    TencentMapContext localTencentMapContext = getActiveMapContext();
    if (localTencentMapContext != null)
    {
      paramBitmap = fromBitmap(localTencentMapContext, paramBitmap);
      AppMethodBeat.o(173089);
      return paramBitmap;
    }
    AppMethodBeat.o(173089);
    return null;
  }
  
  public static BitmapDescriptor fromBitmap(TencentMapContext paramTencentMapContext, Bitmap paramBitmap)
  {
    AppMethodBeat.i(181056);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(181056);
      return null;
    }
    paramTencentMapContext = paramTencentMapContext.createBitmapDescriptor(createBitmapFromBitmap(paramBitmap), 7);
    AppMethodBeat.o(181056);
    return paramTencentMapContext;
  }
  
  public static BitmapDescriptor fromBitmaps(TencentMapContext paramTencentMapContext, Bitmap... paramVarArgs)
  {
    AppMethodBeat.i(237382);
    if ((paramTencentMapContext == null) || (paramVarArgs == null))
    {
      AppMethodBeat.o(237382);
      return null;
    }
    paramTencentMapContext = paramTencentMapContext.createBitmapDescriptor(paramVarArgs, 10);
    AppMethodBeat.o(237382);
    return paramTencentMapContext;
  }
  
  public static BitmapDescriptor fromBitmaps(Bitmap... paramVarArgs)
  {
    AppMethodBeat.i(237381);
    TencentMapContext localTencentMapContext = getActiveMapContext();
    if (localTencentMapContext != null)
    {
      paramVarArgs = fromBitmaps(localTencentMapContext, paramVarArgs);
      AppMethodBeat.o(237381);
      return paramVarArgs;
    }
    AppMethodBeat.o(237381);
    return null;
  }
  
  public static BitmapDescriptor fromFile(TencentMapContext paramTencentMapContext, String paramString)
  {
    AppMethodBeat.i(181052);
    paramTencentMapContext = paramTencentMapContext.createBitmapDescriptor(paramString, 3);
    AppMethodBeat.o(181052);
    return paramTencentMapContext;
  }
  
  public static BitmapDescriptor fromFile(String paramString)
  {
    AppMethodBeat.i(173085);
    TencentMapContext localTencentMapContext = getActiveMapContext();
    if (localTencentMapContext != null)
    {
      paramString = fromFile(localTencentMapContext, paramString);
      AppMethodBeat.o(173085);
      return paramString;
    }
    AppMethodBeat.o(173085);
    return null;
  }
  
  public static BitmapDescriptor fromPath(TencentMapContext paramTencentMapContext, String paramString)
  {
    AppMethodBeat.i(181053);
    paramTencentMapContext = paramTencentMapContext.createBitmapDescriptor(paramString, 4);
    AppMethodBeat.o(181053);
    return paramTencentMapContext;
  }
  
  public static BitmapDescriptor fromPath(String paramString)
  {
    AppMethodBeat.i(173086);
    TencentMapContext localTencentMapContext = getActiveMapContext();
    if (localTencentMapContext != null)
    {
      paramString = fromPath(localTencentMapContext, paramString);
      AppMethodBeat.o(173086);
      return paramString;
    }
    AppMethodBeat.o(173086);
    return null;
  }
  
  public static BitmapDescriptor fromResource(int paramInt)
  {
    AppMethodBeat.i(173083);
    Object localObject = getActiveMapContext();
    if (localObject != null)
    {
      localObject = fromResource((TencentMapContext)localObject, paramInt);
      AppMethodBeat.o(173083);
      return localObject;
    }
    AppMethodBeat.o(173083);
    return null;
  }
  
  public static BitmapDescriptor fromResource(TencentMapContext paramTencentMapContext, int paramInt)
  {
    AppMethodBeat.i(181050);
    paramTencentMapContext = paramTencentMapContext.createBitmapDescriptor(paramInt, 1);
    AppMethodBeat.o(181050);
    return paramTencentMapContext;
  }
  
  public static BitmapDescriptor fromView(View paramView)
  {
    AppMethodBeat.i(173090);
    TencentMapContext localTencentMapContext = getActiveMapContext();
    if (localTencentMapContext != null)
    {
      paramView = fromView(localTencentMapContext, paramView);
      AppMethodBeat.o(173090);
      return paramView;
    }
    AppMethodBeat.o(173090);
    return null;
  }
  
  public static BitmapDescriptor fromView(TencentMapContext paramTencentMapContext, View paramView)
  {
    AppMethodBeat.i(181058);
    if (paramView == null)
    {
      AppMethodBeat.o(181058);
      return null;
    }
    try
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
      paramView.buildDrawingCache();
      Bitmap localBitmap = paramView.getDrawingCache();
      paramTencentMapContext = fromBitmap(paramTencentMapContext, localBitmap);
      if (localBitmap != null) {
        localBitmap.recycle();
      }
      paramView.destroyDrawingCache();
      AppMethodBeat.o(181058);
      return paramTencentMapContext;
    }
    catch (Exception paramTencentMapContext)
    {
      AppMethodBeat.o(181058);
    }
    return null;
  }
  
  private static TencentMapContext getActiveMapContext()
  {
    AppMethodBeat.i(237371);
    int i = sAttachIndex.get();
    if ((i > 0) && (i <= sTencentMapContextList.size()))
    {
      TencentMapContext localTencentMapContext = (TencentMapContext)sTencentMapContextList.get(i - 1);
      AppMethodBeat.o(237371);
      return localTencentMapContext;
    }
    AppMethodBeat.o(237371);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory
 * JD-Core Version:    0.7.0.1
 */