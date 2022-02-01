package com.tencent.mm.plugin.webview.ui.tools.browser;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask;", "Landroid/os/AsyncTask;", "Landroid/content/pm/ResolveInfo;", "Ljava/lang/Void;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "key", "", "callback", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask$BrowserIconLoadCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask$BrowserIconLoadCallback;)V", "convertDrawableToRoundedBitmap", "Landroid/graphics/Bitmap;", "drawable", "doInBackground", "params", "", "([Landroid/content/pm/ResolveInfo;)Landroid/graphics/drawable/Drawable;", "getRoundedBitmapDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "bitmap", "recycleBitmap", "", "onPostExecute", "", "result", "BrowserIconLoadCallback", "Companion", "plugin-webview_release"})
public final class e
  extends AsyncTask<ResolveInfo, Void, Drawable>
{
  public static final e.b JlM;
  private final e.a JlL;
  private final Context context;
  private final String key;
  
  static
  {
    AppMethodBeat.i(210440);
    JlM = new e.b((byte)0);
    AppMethodBeat.o(210440);
  }
  
  public e(Context paramContext, String paramString, e.a parama)
  {
    AppMethodBeat.i(210439);
    this.context = paramContext;
    this.key = paramString;
    this.JlL = parama;
    AppMethodBeat.o(210439);
  }
  
  private Drawable a(ResolveInfo... paramVarArgs)
  {
    Object localObject = null;
    Rect localRect = null;
    AppMethodBeat.i(210435);
    p.h(paramVarArgs, "params");
    paramVarArgs = paramVarArgs[0];
    for (;;)
    {
      try
      {
        paramVarArgs = b.a(this.context, paramVarArgs);
      }
      catch (Throwable localThrowable2)
      {
        int j;
        Canvas localCanvas;
        continue;
        continue;
        int k = i;
        if (i > 0) {
          continue;
        }
        k = 1;
        int i = j;
        if (j > 0) {
          continue;
        }
        i = 1;
        continue;
      }
      try
      {
        if (!(paramVarArgs instanceof BitmapDrawable)) {
          continue;
        }
        localObject = f(((BitmapDrawable)paramVarArgs).getBitmap(), false);
        if (localObject == null) {
          continue;
        }
        localObject = (Drawable)localObject;
        paramVarArgs = (ResolveInfo[])localObject;
        localObject = paramVarArgs;
        Log.i("MicroMsg.BrowserIconLoadTask", "alvinluo BrowserIconLoadTask doInBackground name: " + this.key + ", iconDrawable " + paramVarArgs);
      }
      catch (Throwable localThrowable1)
      {
        localObject = paramVarArgs;
        Log.printErrStackTrace("MicroMsg.BrowserIconLoadTask", localThrowable1, "alvinluo loadBrowserIcon exception", new Object[0]);
        paramVarArgs = (ResolveInfo[])localObject;
        continue;
        i = paramVarArgs.getIntrinsicWidth();
        continue;
        j = paramVarArgs.getIntrinsicHeight();
      }
      AppMethodBeat.o(210435);
      return paramVarArgs;
      continue;
      if ((Build.VERSION.SDK_INT < 26) || (!(paramVarArgs instanceof AdaptiveIconDrawable))) {
        continue;
      }
      if (paramVarArgs == null)
      {
        localObject = localRect;
        localObject = f((Bitmap)localObject, true);
        if (localObject != null)
        {
          localObject = (Drawable)localObject;
          paramVarArgs = (ResolveInfo[])localObject;
        }
      }
      else if ((paramVarArgs instanceof BitmapDrawable))
      {
        localObject = ((BitmapDrawable)paramVarArgs).getBitmap();
      }
      else
      {
        localRect = paramVarArgs.getBounds();
        p.g(localRect, "drawable.bounds");
        if (!localRect.isEmpty())
        {
          i = localRect.width();
          if (localRect.isEmpty()) {
            continue;
          }
          j = localRect.height();
          continue;
          localObject = Bitmap.createBitmap(k, i, Bitmap.Config.ARGB_8888);
          localCanvas = new Canvas((Bitmap)localObject);
          paramVarArgs.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
          paramVarArgs.draw(localCanvas);
          paramVarArgs.setBounds(localRect);
        }
      }
    }
  }
  
  private final BitmapDrawable f(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(210438);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(210438);
      return null;
    }
    paramBitmap = BitmapUtil.getRoundedCornerBitmap(paramBitmap, paramBoolean, Math.min(paramBitmap.getWidth(), paramBitmap.getHeight()) * 0.1666667F);
    paramBitmap = new BitmapDrawable(this.context.getResources(), paramBitmap);
    AppMethodBeat.o(210438);
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.e
 * JD-Core Version:    0.7.0.1
 */