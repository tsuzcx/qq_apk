package com.tencent.ttpic.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.model.TextWMElement;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class WMTextDrawer
{
  protected static final String INT_D = "%d";
  private static final String TAG;
  private static Map<String, Typeface> typefaceCache;
  private WMTextDrawer.AsyncDrawRunnable asyncDrawRunnable;
  private boolean isAsyncDrawFinished = true;
  public String lastDrawText = "";
  
  static
  {
    AppMethodBeat.i(84290);
    TAG = WMTextDrawer.class.getSimpleName();
    typefaceCache = new HashMap();
    AppMethodBeat.o(84290);
  }
  
  private void drawHorizontalText(TextWMElement paramTextWMElement, Canvas paramCanvas, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(84283);
    new WMTextDrawer.TextHorizontalLayout(this, paramTextWMElement, paramInt1, paramInt2, paramString).draw(paramCanvas);
    AppMethodBeat.o(84283);
  }
  
  private void drawNormalVerticalText(TextWMElement paramTextWMElement, Canvas paramCanvas, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(84285);
    new WMTextDrawer.TextVerticalLayout(this, paramTextWMElement, paramInt1, paramInt2, paramString).draw(paramCanvas);
    AppMethodBeat.o(84285);
  }
  
  private void drawRotatedVerticalText(TextWMElement paramTextWMElement, String paramString)
  {
    AppMethodBeat.i(84286);
    Bitmap localBitmap = Bitmap.createBitmap(paramTextWMElement.height, paramTextWMElement.width, Bitmap.Config.ARGB_8888);
    drawHorizontalText(paramTextWMElement, new Canvas(localBitmap), localBitmap.getWidth(), localBitmap.getHeight(), paramString);
    if (BitmapUtils.isLegal(paramTextWMElement.getIdleBitmap())) {
      paramTextWMElement.getIdleBitmap().recycle();
    }
    paramTextWMElement.setIdleBitmap(rotateBitmap(localBitmap, paramTextWMElement.rotate));
    AppMethodBeat.o(84286);
  }
  
  private void drawVerticalText(TextWMElement paramTextWMElement, Canvas paramCanvas, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(84284);
    if ((paramTextWMElement.rotate == 90) || (paramTextWMElement.rotate == -90))
    {
      drawRotatedVerticalText(paramTextWMElement, paramString);
      AppMethodBeat.o(84284);
      return;
    }
    drawNormalVerticalText(paramTextWMElement, paramCanvas, paramInt1, paramInt2, paramString);
    AppMethodBeat.o(84284);
  }
  
  private Bitmap rotateBitmap(Bitmap paramBitmap, float paramFloat)
  {
    AppMethodBeat.i(84287);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(84287);
      return null;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Object localObject = new Matrix();
    ((Matrix)localObject).setRotate(paramFloat);
    localObject = Bitmap.createBitmap(paramBitmap, 0, 0, i, j, (Matrix)localObject, false);
    if (localObject.equals(paramBitmap))
    {
      AppMethodBeat.o(84287);
      return localObject;
    }
    paramBitmap.recycle();
    AppMethodBeat.o(84287);
    return localObject;
  }
  
  public void cancelAsyncDrawTask()
  {
    if ((!this.isAsyncDrawFinished) && (this.asyncDrawRunnable != null))
    {
      this.asyncDrawRunnable.isTaskCanceled = true;
      this.isAsyncDrawFinished = true;
    }
  }
  
  public void drawTextToBitmap(TextWMElement paramTextWMElement, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(84282);
    if ((paramString != null) && (!TextUtils.isEmpty(paramString))) {
      this.lastDrawText = paramString;
    }
    this.isAsyncDrawFinished = false;
    this.asyncDrawRunnable = new WMTextDrawer.1(this, paramTextWMElement, paramString, paramBoolean1);
    if (paramBoolean2)
    {
      this.asyncDrawRunnable.run();
      AppMethodBeat.o(84282);
      return;
    }
    AsyncTask.SERIAL_EXECUTOR.execute(this.asyncDrawRunnable);
    AppMethodBeat.o(84282);
  }
  
  public boolean isAsyncDrawFinished()
  {
    return this.isAsyncDrawFinished;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.util.WMTextDrawer
 * JD-Core Version:    0.7.0.1
 */