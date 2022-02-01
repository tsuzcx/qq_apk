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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask;", "Landroid/os/AsyncTask;", "Landroid/content/pm/ResolveInfo;", "Ljava/lang/Void;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "key", "", "callback", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask$BrowserIconLoadCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask$BrowserIconLoadCallback;)V", "convertDrawableToRoundedBitmap", "Landroid/graphics/Bitmap;", "drawable", "doInBackground", "params", "", "([Landroid/content/pm/ResolveInfo;)Landroid/graphics/drawable/Drawable;", "getRoundedBitmapDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "bitmap", "recycleBitmap", "", "onPostExecute", "", "result", "BrowserIconLoadCallback", "Companion", "plugin-webview_release"})
public final class e
  extends AsyncTask<ResolveInfo, Void, Drawable>
{
  public static final b Qje;
  private final a Qjd;
  private final Context context;
  private final String key;
  
  static
  {
    AppMethodBeat.i(221611);
    Qje = new b((byte)0);
    AppMethodBeat.o(221611);
  }
  
  public e(Context paramContext, String paramString, a parama)
  {
    AppMethodBeat.i(221610);
    this.context = paramContext;
    this.key = paramString;
    this.Qjd = parama;
    AppMethodBeat.o(221610);
  }
  
  private Drawable a(ResolveInfo... paramVarArgs)
  {
    Object localObject = null;
    Rect localRect = null;
    AppMethodBeat.i(221597);
    p.k(paramVarArgs, "params");
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
      AppMethodBeat.o(221597);
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
        p.j(localRect, "drawable.bounds");
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
    AppMethodBeat.i(221606);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(221606);
      return null;
    }
    paramBitmap = BitmapUtil.getRoundedCornerBitmap(paramBitmap, paramBoolean, Math.min(paramBitmap.getWidth(), paramBitmap.getHeight()) * 0.1666667F);
    paramBitmap = new BitmapDrawable(this.context.getResources(), paramBitmap);
    AppMethodBeat.o(221606);
    return paramBitmap;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask$BrowserIconLoadCallback;", "", "onLoadFinish", "", "drawable", "Landroid/graphics/drawable/Drawable;", "plugin-webview_release"})
  public static abstract interface a
  {
    public abstract void H(Drawable paramDrawable);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask$Companion;", "", "()V", "ROUND_CORNER_SIZE_FACTOR", "", "TAG", "", "plugin-webview_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.e
 * JD-Core Version:    0.7.0.1
 */