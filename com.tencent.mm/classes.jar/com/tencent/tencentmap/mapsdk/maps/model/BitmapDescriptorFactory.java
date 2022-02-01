package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.View;
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
  private static final AtomicInteger sAttachIndex;
  private static final List<TencentMapContext> sTencentMapContextList;
  
  static
  {
    AppMethodBeat.i(218047);
    sTencentMapContextList = new CopyOnWriteArrayList();
    sAttachIndex = new AtomicInteger(0);
    AppMethodBeat.o(218047);
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
        localObject1 = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
      }
      AppMethodBeat.o(181057);
      return localObject1;
    }
    finally
    {
      for (;;)
      {
        localObject1 = localObject2;
      }
    }
  }
  
  /* Error */
  private static Bitmap[] createBitmapFromBitmaps(Bitmap... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 95
    //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: arraylength
    //   7: anewarray 78	android/graphics/Bitmap
    //   10: astore_2
    //   11: iconst_0
    //   12: istore_1
    //   13: iload_1
    //   14: aload_2
    //   15: arraylength
    //   16: if_icmpge +20 -> 36
    //   19: aload_2
    //   20: iload_1
    //   21: aload_0
    //   22: iload_1
    //   23: aaload
    //   24: invokestatic 97	com/tencent/tencentmap/mapsdk/maps/model/BitmapDescriptorFactory:createBitmapFromBitmap	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   27: aastore
    //   28: iload_1
    //   29: iconst_1
    //   30: iadd
    //   31: istore_1
    //   32: goto -19 -> 13
    //   35: astore_0
    //   36: ldc 95
    //   38: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   41: aload_2
    //   42: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	paramVarArgs	Bitmap[]
    //   12	20	1	i	int
    //   10	32	2	arrayOfBitmap	Bitmap[]
    // Exception table:
    //   from	to	target	type
    //   13	28	35	finally
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
    AppMethodBeat.i(218024);
    if (sTencentMapContextList.remove(paramTencentMapContext)) {
      sAttachIndex.decrementAndGet();
    }
    AppMethodBeat.o(218024);
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
    AppMethodBeat.i(218045);
    if ((paramTencentMapContext == null) || (paramVarArgs == null))
    {
      AppMethodBeat.o(218045);
      return null;
    }
    paramTencentMapContext = paramTencentMapContext.createBitmapDescriptor(createBitmapFromBitmaps(paramVarArgs), 10);
    AppMethodBeat.o(218045);
    return paramTencentMapContext;
  }
  
  public static BitmapDescriptor fromBitmaps(Bitmap... paramVarArgs)
  {
    AppMethodBeat.i(218044);
    TencentMapContext localTencentMapContext = getActiveMapContext();
    if (localTencentMapContext != null)
    {
      paramVarArgs = fromBitmaps(localTencentMapContext, paramVarArgs);
      AppMethodBeat.o(218044);
      return paramVarArgs;
    }
    AppMethodBeat.o(218044);
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
  
  /* Error */
  public static BitmapDescriptor fromView(TencentMapContext paramTencentMapContext, View paramView)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: ldc 191
    //   7: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_1
    //   11: ifnonnull +15 -> 26
    //   14: ldc 191
    //   16: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_2
    //   20: astore_0
    //   21: ldc 2
    //   23: monitorexit
    //   24: aload_0
    //   25: areturn
    //   26: aload_1
    //   27: iconst_0
    //   28: iconst_0
    //   29: invokestatic 197	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   32: iconst_0
    //   33: iconst_0
    //   34: invokestatic 197	android/view/View$MeasureSpec:makeMeasureSpec	(II)I
    //   37: invokevirtual 203	android/view/View:measure	(II)V
    //   40: aload_1
    //   41: iconst_0
    //   42: iconst_0
    //   43: aload_1
    //   44: invokevirtual 206	android/view/View:getMeasuredWidth	()I
    //   47: aload_1
    //   48: invokevirtual 209	android/view/View:getMeasuredHeight	()I
    //   51: invokevirtual 213	android/view/View:layout	(IIII)V
    //   54: aload_1
    //   55: invokevirtual 216	android/view/View:buildDrawingCache	()V
    //   58: aload_0
    //   59: aload_1
    //   60: invokevirtual 220	android/view/View:getDrawingCache	()Landroid/graphics/Bitmap;
    //   63: invokestatic 147	com/tencent/tencentmap/mapsdk/maps/model/BitmapDescriptorFactory:fromBitmap	(Lcom/tencent/tencentmap/mapsdk/maps/TencentMapContext;Landroid/graphics/Bitmap;)Lcom/tencent/tencentmap/mapsdk/maps/model/BitmapDescriptor;
    //   66: astore_0
    //   67: aload_1
    //   68: invokevirtual 223	android/view/View:destroyDrawingCache	()V
    //   71: ldc 191
    //   73: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: goto -55 -> 21
    //   79: astore_0
    //   80: ldc 191
    //   82: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_2
    //   86: astore_0
    //   87: goto -66 -> 21
    //   90: astore_0
    //   91: ldc 2
    //   93: monitorexit
    //   94: aload_0
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramTencentMapContext	TencentMapContext
    //   0	96	1	paramView	View
    //   1	85	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	71	79	java/lang/Exception
    //   5	10	90	finally
    //   14	19	90	finally
    //   26	71	90	finally
    //   71	76	90	finally
    //   80	85	90	finally
  }
  
  private static TencentMapContext getActiveMapContext()
  {
    AppMethodBeat.i(218026);
    int i = sAttachIndex.get();
    if ((i > 0) && (i <= sTencentMapContextList.size()))
    {
      TencentMapContext localTencentMapContext = (TencentMapContext)sTencentMapContextList.get(i - 1);
      AppMethodBeat.o(218026);
      return localTencentMapContext;
    }
    AppMethodBeat.o(218026);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory
 * JD-Core Version:    0.7.0.1
 */