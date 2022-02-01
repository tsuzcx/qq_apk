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
import com.tencent.e.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class bi
{
  private static aq IzQ;
  private static final String IzR;
  private static ContentObserver IzS;
  private static WeakReference<bi.a> IzT;
  private static final String[] aKk;
  private static final Handler sHandler;
  
  static
  {
    AppMethodBeat.i(157810);
    IzQ = new aq(a.bbi("MicroMsg.ScreenShotUtil"));
    sHandler = new Handler(Looper.getMainLooper());
    IzR = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
    aKk = new String[] { "_display_name", "_data", "date_added" };
    AppMethodBeat.o(157810);
  }
  
  public static void a(Context paramContext, final bi.a parama)
  {
    AppMethodBeat.i(157809);
    IzQ.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200299);
        ae.i("MicroMsg.ScreenShotUtil", "summerscreenshot setScreenShotCallback context[%s] callback[%s], stack[%s]", new Object[] { this.val$context, parama, bu.fpN() });
        try
        {
          Context localContext = this.val$context;
          if (localContext == null)
          {
            AppMethodBeat.o(200299);
            return;
          }
          if (parama == null)
          {
            if (bi.fpl() != null)
            {
              this.val$context.getContentResolver().unregisterContentObserver(bi.fpl());
              bi.a(null);
            }
            if (bi.fpm() != null)
            {
              bi.fpm().clear();
              bi.j(null);
            }
            AppMethodBeat.o(200299);
            return;
          }
          bi.j(new WeakReference(parama));
          if (bi.fpl() == null)
          {
            bi.a(new bi.b(this.val$context, bi.fpn()));
            this.val$context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, bi.fpl());
          }
          AppMethodBeat.o(200299);
          return;
        }
        catch (Throwable localThrowable)
        {
          ae.w("MicroMsg.ScreenShotUtil", "summerscreenshot fail e:" + localThrowable.getMessage());
          AppMethodBeat.o(200299);
        }
      }
    });
    AppMethodBeat.o(157809);
  }
  
  public static Bitmap aW(Activity paramActivity)
  {
    AppMethodBeat.i(157808);
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
      AppMethodBeat.o(157808);
      return paramActivity;
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.ScreenShotUtil", paramActivity, "", new Object[0]);
        paramActivity = localBitmap;
      }
    }
  }
  
  static final class b
    extends ContentObserver
  {
    private String IzV;
    private Context context;
    private long yJX;
    
    public b(Context paramContext, Handler paramHandler)
    {
      super();
      this.context = paramContext;
    }
    
    public final void onChange(final boolean paramBoolean, final Uri paramUri)
    {
      AppMethodBeat.i(200302);
      bi.fpo().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(200300);
          ae.d("MicroMsg.ScreenShotUtil", "summerscreenshot onChange: " + paramBoolean + ", uri:" + paramUri.toString());
          try
          {
            if ((bi.fpm() == null) || (bi.fpm().get() == null))
            {
              ae.i("MicroMsg.ScreenShotUtil", "summerscreenshot unregisterContentObserver callback is null 1 mCallbackWeakRef[%s]", new Object[] { bi.fpm() });
              if (bi.fpl() != null)
              {
                bi.b.a(bi.b.this).getContentResolver().unregisterContentObserver(bi.fpl());
                bi.a(null);
              }
              if (bi.fpm() != null)
              {
                bi.fpm().clear();
                bi.j(null);
                AppMethodBeat.o(200300);
              }
            }
            else if ((paramUri.toString().matches(bi.IzR)) || (paramUri.toString().contains(bi.IzR)))
            {
              bi.b.a(bi.b.this, bi.b.a(bi.b.this), paramUri);
            }
            AppMethodBeat.o(200300);
            return;
          }
          catch (Throwable localThrowable)
          {
            ae.w("MicroMsg.ScreenShotUtil", "summerscreenshot fail e:" + localThrowable.getMessage());
            AppMethodBeat.o(200300);
          }
        }
      });
      super.onChange(paramBoolean, paramUri);
      AppMethodBeat.o(200302);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bi
 * JD-Core Version:    0.7.0.1
 */