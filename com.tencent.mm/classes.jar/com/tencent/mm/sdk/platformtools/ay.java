package com.tencent.mm.sdk.platformtools;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import java.lang.ref.WeakReference;

public final class ay
{
  private static final String uhM = MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString();
  private static final String[] uhN = { "_display_name", "_data", "date_added" };
  private static ContentObserver uhO;
  private static WeakReference<a> uhP;
  
  public static void a(Context paramContext, a parama)
  {
    y.i("MicroMsg.ScreenShotUtil", "summerscreenshot setScreenShotCallback context[%s] callback[%s], stack[%s]", new Object[] { paramContext, parama, bk.csb() });
    if (paramContext == null) {}
    do
    {
      do
      {
        return;
        if (parama != null) {
          break;
        }
        if (uhO != null)
        {
          paramContext.getContentResolver().unregisterContentObserver(uhO);
          uhO = null;
        }
      } while (uhP == null);
      uhP.clear();
      uhP = null;
      return;
      uhP = new WeakReference(parama);
    } while (uhO != null);
    uhO = new ay.1(new Handler(Looper.myLooper()), paramContext);
    paramContext.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, uhO);
  }
  
  public static abstract interface a
  {
    public abstract void aqt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ay
 * JD-Core Version:    0.7.0.1
 */