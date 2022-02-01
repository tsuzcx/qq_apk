package com.tencent.mm.ui.n;

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
  public static Bitmap a(View paramView, int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(205362);
    if (paramView == null)
    {
      AppMethodBeat.o(205362);
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
    a(localCanvas, paramView, true);
    BitmapUtil.setBitmapDensity(paramConfig);
    paramView = BitmapTracer.trace(paramConfig);
    AppMethodBeat.o(205362);
    return paramView;
  }
  
  public static Bitmap a(View paramView, Bitmap.Config paramConfig)
  {
    AppMethodBeat.i(205363);
    if (paramView == null)
    {
      AppMethodBeat.o(205363);
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
    AppMethodBeat.o(205363);
    return paramView;
  }
  
  private static void a(Canvas paramCanvas, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(205364);
    paramView.draw(paramCanvas);
    paramView = c(paramView, (int)paramView.getX(), (int)paramView.getY(), paramBoolean);
    if (paramView.size() > 0)
    {
      paramView = paramView.iterator();
      while (paramView.hasNext())
      {
        a locala = (a)paramView.next();
        Object localObject;
        if ((locala != null) && (locala.Qof != null))
        {
          localObject = locala.Qof;
          localObject = ((TextureView)localObject).getBitmap(((TextureView)localObject).getWidth(), ((TextureView)localObject).getHeight());
          if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
            Log.e("MicroMsg.BitmapUtil", "get thumb bitmap null or is recycled");
          } else {
            paramCanvas.drawBitmap((Bitmap)localObject, locala.left, locala.top, null);
          }
        }
        else if ((locala != null) && ((locala.Qog instanceof IWebView)) && (paramBoolean))
        {
          localObject = locala.Qog.captureBitmap();
          if ((localObject == null) || (((Bitmap)localObject).isRecycled())) {
            Log.e("MicroMsg.BitmapUtil", "get thumb bitmap null or is recycled");
          } else {
            paramCanvas.drawBitmap((Bitmap)localObject, locala.left, locala.top, null);
          }
        }
      }
    }
    AppMethodBeat.o(205364);
  }
  
  private static List<a> c(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(205365);
    ArrayList localArrayList = new ArrayList();
    a locala;
    if ((paramView instanceof TextureView))
    {
      locala = new a();
      locala.Qof = ((TextureView)paramView);
      locala.left = paramInt1;
      locala.top = paramInt2;
      localArrayList.add(locala);
    }
    for (;;)
    {
      AppMethodBeat.o(205365);
      return localArrayList;
      if ((paramBoolean) && ((paramView instanceof WebView)))
      {
        locala = new a();
        locala.Qog = ((WebView)paramView);
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
  
  public static Bitmap hn(View paramView)
  {
    AppMethodBeat.i(258467);
    paramView = a(paramView, Bitmap.Config.ARGB_8888);
    AppMethodBeat.o(258467);
    return paramView;
  }
  
  static final class a
  {
    TextureView Qof;
    IWebView Qog;
    int left = 0;
    int top = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.n.a
 * JD-Core Version:    0.7.0.1
 */