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

public final class bh
{
  private static ap IfF;
  private static final String IfG;
  private static ContentObserver IfH;
  private static WeakReference<bh.a> IfI;
  private static final String[] aKk;
  private static final Handler sHandler;
  
  static
  {
    AppMethodBeat.i(157810);
    IfF = new ap(a.aZF("MicroMsg.ScreenShotUtil"));
    sHandler = new Handler(Looper.getMainLooper());
    IfG = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
    aKk = new String[] { "_display_name", "_data", "date_added" };
    AppMethodBeat.o(157810);
  }
  
  public static void a(Context paramContext, final bh.a parama)
  {
    AppMethodBeat.i(157809);
    IfF.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194952);
        ad.i("MicroMsg.ScreenShotUtil", "summerscreenshot setScreenShotCallback context[%s] callback[%s], stack[%s]", new Object[] { this.val$context, parama, bt.flS() });
        try
        {
          Context localContext = this.val$context;
          if (localContext == null)
          {
            AppMethodBeat.o(194952);
            return;
          }
          if (parama == null)
          {
            if (bh.flq() != null)
            {
              this.val$context.getContentResolver().unregisterContentObserver(bh.flq());
              bh.a(null);
            }
            if (bh.flr() != null)
            {
              bh.flr().clear();
              bh.f(null);
            }
            AppMethodBeat.o(194952);
            return;
          }
          bh.f(new WeakReference(parama));
          if (bh.flq() == null)
          {
            bh.a(new bh.b(this.val$context, bh.fls()));
            this.val$context.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, bh.flq());
          }
          AppMethodBeat.o(194952);
          return;
        }
        catch (Throwable localThrowable)
        {
          ad.w("MicroMsg.ScreenShotUtil", "summerscreenshot fail e:" + localThrowable.getMessage());
          AppMethodBeat.o(194952);
        }
      }
    });
    AppMethodBeat.o(157809);
  }
  
  public static Bitmap aV(Activity paramActivity)
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
        ad.printErrStackTrace("MicroMsg.ScreenShotUtil", paramActivity, "", new Object[0]);
        paramActivity = localBitmap;
      }
    }
  }
  
  static final class b
    extends ContentObserver
  {
    private String IfK;
    private Context context;
    private long ytW;
    
    public b(Context paramContext, Handler paramHandler)
    {
      super();
      this.context = paramContext;
    }
    
    public final void onChange(final boolean paramBoolean, final Uri paramUri)
    {
      AppMethodBeat.i(194955);
      bh.flt().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194953);
          ad.d("MicroMsg.ScreenShotUtil", "summerscreenshot onChange: " + paramBoolean + ", uri:" + paramUri.toString());
          try
          {
            if ((bh.flr() == null) || (bh.flr().get() == null))
            {
              ad.i("MicroMsg.ScreenShotUtil", "summerscreenshot unregisterContentObserver callback is null 1 mCallbackWeakRef[%s]", new Object[] { bh.flr() });
              if (bh.flq() != null)
              {
                bh.b.a(bh.b.this).getContentResolver().unregisterContentObserver(bh.flq());
                bh.a(null);
              }
              if (bh.flr() != null)
              {
                bh.flr().clear();
                bh.f(null);
                AppMethodBeat.o(194953);
              }
            }
            else if ((paramUri.toString().matches(bh.IfG)) || (paramUri.toString().contains(bh.IfG)))
            {
              bh.b.a(bh.b.this, bh.b.a(bh.b.this), paramUri);
            }
            AppMethodBeat.o(194953);
            return;
          }
          catch (Throwable localThrowable)
          {
            ad.w("MicroMsg.ScreenShotUtil", "summerscreenshot fail e:" + localThrowable.getMessage());
            AppMethodBeat.o(194953);
          }
        }
      });
      super.onChange(paramBoolean, paramUri);
      AppMethodBeat.o(194955);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bh
 * JD-Core Version:    0.7.0.1
 */