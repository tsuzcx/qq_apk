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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask;", "Landroid/os/AsyncTask;", "Landroid/content/pm/ResolveInfo;", "Ljava/lang/Void;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "key", "", "callback", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask$BrowserIconLoadCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask$BrowserIconLoadCallback;)V", "convertDrawableToRoundedBitmap", "Landroid/graphics/Bitmap;", "drawable", "doInBackground", "params", "", "([Landroid/content/pm/ResolveInfo;)Landroid/graphics/drawable/Drawable;", "getRoundedBitmapDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "bitmap", "recycleBitmap", "", "onPostExecute", "", "result", "BrowserIconLoadCallback", "Companion", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends AsyncTask<ResolveInfo, Void, Drawable>
{
  public static final b XaZ;
  private final a Xba;
  private final Context context;
  private final String key;
  
  static
  {
    AppMethodBeat.i(296577);
    XaZ = new b((byte)0);
    AppMethodBeat.o(296577);
  }
  
  public e(Context paramContext, String paramString, a parama)
  {
    AppMethodBeat.i(296548);
    this.context = paramContext;
    this.key = paramString;
    this.Xba = parama;
    AppMethodBeat.o(296548);
  }
  
  private Drawable a(ResolveInfo... paramVarArgs)
  {
    Object localObject1 = null;
    Rect localRect = null;
    AppMethodBeat.i(296563);
    s.u(paramVarArgs, "params");
    paramVarArgs = paramVarArgs[0];
    label135:
    int i;
    int j;
    for (;;)
    {
      try
      {
        paramVarArgs = b.a(this.context, paramVarArgs);
      }
      finally
      {
        continue;
        continue;
      }
      try
      {
        if (!(paramVarArgs instanceof BitmapDrawable)) {
          continue;
        }
        localObject1 = h(((BitmapDrawable)paramVarArgs).getBitmap(), false);
        if (localObject1 != null) {
          continue;
        }
        localObject1 = paramVarArgs;
        Log.i("MicroMsg.BrowserIconLoadTask", "alvinluo BrowserIconLoadTask doInBackground name: " + this.key + ", iconDrawable " + paramVarArgs);
      }
      finally
      {
        localObject1 = paramVarArgs;
        Log.printErrStackTrace("MicroMsg.BrowserIconLoadTask", localThrowable, "alvinluo loadBrowserIcon exception", new Object[0]);
        paramVarArgs = (ResolveInfo[])localObject1;
        continue;
        i = paramVarArgs.getIntrinsicWidth();
        continue;
        j = paramVarArgs.getIntrinsicHeight();
        break label332;
      }
      AppMethodBeat.o(296563);
      return paramVarArgs;
      localObject1 = (Drawable)localObject1;
      paramVarArgs = (ResolveInfo[])localObject1;
      continue;
      if ((Build.VERSION.SDK_INT >= 26) && ((paramVarArgs instanceof AdaptiveIconDrawable)))
      {
        if (paramVarArgs == null) {}
        for (localObject1 = localRect;; localObject1 = ((BitmapDrawable)paramVarArgs).getBitmap())
        {
          localObject1 = h((Bitmap)localObject1, true);
          if (localObject1 != null) {
            break label308;
          }
          break label329;
          if (!(paramVarArgs instanceof BitmapDrawable)) {
            break;
          }
        }
        localRect = paramVarArgs.getBounds();
        s.s(localRect, "drawable.bounds");
        if (!localRect.isEmpty())
        {
          i = localRect.width();
          if (localRect.isEmpty()) {
            continue;
          }
          j = localRect.height();
          break label332;
        }
      }
    }
    for (;;)
    {
      localObject1 = Bitmap.createBitmap(k, i, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas((Bitmap)localObject1);
      paramVarArgs.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramVarArgs.draw(localCanvas);
      paramVarArgs.setBounds(localRect);
      break label135;
      label308:
      localObject1 = (Drawable)localObject1;
      paramVarArgs = (ResolveInfo[])localObject1;
      label329:
      break;
      label332:
      int k = i;
      if (i <= 0) {
        k = 1;
      }
      i = j;
      if (j <= 0) {
        i = 1;
      }
    }
  }
  
  private final BitmapDrawable h(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(296570);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(296570);
      return null;
    }
    paramBitmap = BitmapUtil.getRoundedCornerBitmap(paramBitmap, paramBoolean, Math.min(paramBitmap.getWidth(), paramBitmap.getHeight()) * 0.1666667F);
    paramBitmap = new BitmapDrawable(this.context.getResources(), paramBitmap);
    AppMethodBeat.o(296570);
    return paramBitmap;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask$BrowserIconLoadCallback;", "", "onLoadFinish", "", "drawable", "Landroid/graphics/drawable/Drawable;", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void R(Drawable paramDrawable);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserIconLoadTask$Companion;", "", "()V", "ROUND_CORNER_SIZE_FACTOR", "", "TAG", "", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.browser.e
 * JD-Core Version:    0.7.0.1
 */