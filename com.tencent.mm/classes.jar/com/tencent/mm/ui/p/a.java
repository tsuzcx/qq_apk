package com.tencent.mm.ui.p;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapTracer;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.IWebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public static Bitmap a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(249771);
    if (paramView == null)
    {
      AppMethodBeat.o(249771);
      return null;
    }
    paramConfig = Bitmap.createBitmap(paramInt1, paramInt2, paramConfig);
    Object localObject = new Matrix();
    ((Matrix)localObject).setScale(paramInt1 / paramView.getWidth(), paramInt2 / paramView.getHeight());
    Canvas localCanvas = new Canvas(paramConfig);
    localCanvas.setMatrix((Matrix)localObject);
    localObject = paramView.getBackground();
    if (localObject != null) {
      ((Drawable)localObject).draw(localCanvas);
    }
    a(localCanvas, paramView, paramBoolean);
    BitmapUtil.setBitmapDensity(paramConfig);
    paramView = BitmapTracer.trace(paramConfig);
    AppMethodBeat.o(249771);
    return paramView;
  }
  
  public static Bitmap a(View paramView, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(249776);
    if (paramView == null)
    {
      AppMethodBeat.o(249776);
      return null;
    }
    paramConfig = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), paramConfig);
    Canvas localCanvas = new Canvas(paramConfig);
    Drawable localDrawable = paramView.getBackground();
    if (localDrawable != null) {
      localDrawable.draw(localCanvas);
    }
    a(localCanvas, paramView, false);
    BitmapUtil.setBitmapDensity(paramConfig);
    paramView = BitmapTracer.trace(paramConfig);
    AppMethodBeat.o(249776);
    return paramView;
  }
  
  private static void a(Canvas paramCanvas, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(249783);
    Object localObject1 = c(paramView, (int)paramView.getX(), (int)paramView.getY(), paramBoolean);
    Object localObject2 = new ArrayList();
    Iterator localIterator = ((List)localObject1).iterator();
    Object localObject3;
    while (localIterator.hasNext())
    {
      localObject3 = (a)localIterator.next();
      if ((localObject3 != null) && ((((a)localObject3).afCz instanceof IWebView)) && (((a)localObject3).afCz.getX5WebViewExtension() != null)) {
        ((List)localObject2).add(localObject3);
      }
    }
    localIterator = ((List)localObject2).iterator();
    while (localIterator.hasNext())
    {
      localObject3 = ((a)localIterator.next()).afCz;
      if (((IWebView)localObject3).getWebViewUI() != null) {
        ((IWebView)localObject3).getWebViewUI().setWillNotDraw(true);
      }
    }
    paramView.draw(paramCanvas);
    paramView = ((List)localObject2).iterator();
    while (paramView.hasNext())
    {
      localObject2 = ((a)paramView.next()).afCz;
      if (((IWebView)localObject2).getWebViewUI() != null) {
        ((IWebView)localObject2).getWebViewUI().setWillNotDraw(false);
      }
    }
    if (((List)localObject1).size() > 0)
    {
      paramView = ((List)localObject1).iterator();
      while (paramView.hasNext())
      {
        localObject1 = (a)paramView.next();
        if ((localObject1 != null) && (((a)localObject1).afCy != null))
        {
          localObject2 = ((a)localObject1).afCy;
          localObject2 = ((TextureView)localObject2).getBitmap(((TextureView)localObject2).getWidth(), ((TextureView)localObject2).getHeight());
          if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
            Log.e("MicroMsg.BitmapUtil", "get thumb bitmap null or is recycled");
          } else {
            paramCanvas.drawBitmap((Bitmap)localObject2, ((a)localObject1).left, ((a)localObject1).top, null);
          }
        }
        else if ((localObject1 != null) && ((((a)localObject1).afCz instanceof IWebView)) && (paramBoolean))
        {
          localObject2 = ((a)localObject1).afCz.captureBitmap();
          if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
            Log.e("MicroMsg.BitmapUtil", "get thumb bitmap null or is recycled");
          } else {
            paramCanvas.drawBitmap((Bitmap)localObject2, ((a)localObject1).left, ((a)localObject1).top, null);
          }
        }
      }
    }
    AppMethodBeat.o(249783);
  }
  
  private static List<a> c(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(249786);
    ArrayList localArrayList = new ArrayList();
    a locala;
    if ((paramView instanceof TextureView))
    {
      locala = new a();
      locala.afCy = ((TextureView)paramView);
      locala.left = paramInt1;
      locala.top = paramInt2;
      localArrayList.add(locala);
    }
    for (;;)
    {
      AppMethodBeat.o(249786);
      return localArrayList;
      if ((paramBoolean) && ((paramView instanceof WebView)))
      {
        locala = new a();
        locala.afCz = ((WebView)paramView);
        locala.left = paramInt1;
        locala.top = paramInt2;
        localArrayList.add(locala);
      }
      else if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int i = 0;
        while (i < paramView.getChildCount())
        {
          localArrayList.addAll(c(paramView.getChildAt(i), (int)(paramView.getX() + paramInt1), (int)(paramView.getY() + paramInt2), paramBoolean));
          i += 1;
        }
      }
    }
  }
  
  static final class a
  {
    TextureView afCy;
    IWebView afCz;
    int left = 0;
    int top = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.p.a
 * JD-Core Version:    0.7.0.1
 */