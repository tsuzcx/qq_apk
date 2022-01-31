package com.tencent.mm.sdk.platformtools;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class bc
{
  private static final String ypS;
  private static final String[] ypT;
  private static ContentObserver ypU;
  private static WeakReference<bc.a> ypV;
  
  static
  {
    AppMethodBeat.i(52250);
    ypS = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
    ypT = new String[] { "_display_name", "_data", "date_added" };
    AppMethodBeat.o(52250);
  }
  
  public static void a(Context paramContext, bc.a parama)
  {
    AppMethodBeat.i(52249);
    ab.i("MicroMsg.ScreenShotUtil", "summerscreenshot setScreenShotCallback context[%s] callback[%s], stack[%s]", new Object[] { paramContext, parama, bo.dtY() });
    if (paramContext == null)
    {
      AppMethodBeat.o(52249);
      return;
    }
    if (parama == null)
    {
      if (ypU != null)
      {
        paramContext.getContentResolver().unregisterContentObserver(ypU);
        ypU = null;
      }
      if (ypV != null)
      {
        ypV.clear();
        ypV = null;
      }
      AppMethodBeat.o(52249);
      return;
    }
    ypV = new WeakReference(parama);
    if (ypU == null)
    {
      ypU = new bc.1(new Handler(Looper.myLooper()), paramContext);
      paramContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, ypU);
    }
    AppMethodBeat.o(52249);
  }
  
  public static Bitmap au(Activity paramActivity)
  {
    AppMethodBeat.i(52248);
    View localView = paramActivity.getWindow().getDecorView();
    localView.setDrawingCacheEnabled(true);
    localView.buildDrawingCache();
    Bitmap localBitmap = localView.getDrawingCache();
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = localRect.top;
    int j = paramActivity.getWindowManager().getDefaultDisplay().getWidth();
    int k = paramActivity.getWindowManager().getDefaultDisplay().getHeight();
    try
    {
      paramActivity = Bitmap.createBitmap(localBitmap, 0, i, j, k - i);
      localView.destroyDrawingCache();
      AppMethodBeat.o(52248);
      return paramActivity;
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ScreenShotUtil", paramActivity, "", new Object[0]);
        paramActivity = localBitmap;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bc
 * JD-Core Version:    0.7.0.1
 */