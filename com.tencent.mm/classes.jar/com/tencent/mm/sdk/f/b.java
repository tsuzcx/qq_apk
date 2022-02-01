package com.tencent.mm.sdk.f;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.MediaStore.Files;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.vfs.e;
import java.io.File;
import java.util.Locale;

public final class b
{
  public static String aRB(String paramString)
  {
    AppMethodBeat.i(213161);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(213161);
      return "";
    }
    try
    {
      String str1 = new File(paramString).getCanonicalPath();
      if (str1.startsWith(com.tencent.mm.loader.j.b.arQ()))
      {
        i = com.tencent.mm.loader.j.b.arQ().length();
        if (i >= 0) {
          break label86;
        }
        AppMethodBeat.o(213161);
        return paramString;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        int i;
        String str2 = paramString;
        continue;
        if (str2.startsWith(com.tencent.mm.loader.j.b.arP()))
        {
          i = com.tencent.mm.loader.j.b.arP().length();
          continue;
          label86:
          paramString = paramString.substring(i);
          if (paramString.startsWith("/"))
          {
            paramString = "/sdcard".concat(String.valueOf(paramString));
            AppMethodBeat.o(213161);
            return paramString;
          }
          paramString = "/sdcard/".concat(String.valueOf(paramString));
          AppMethodBeat.o(213161);
          return paramString;
        }
        else
        {
          i = -1;
        }
      }
    }
  }
  
  /* Error */
  private static BitmapFactory.Options aRC(String paramString)
  {
    // Byte code:
    //   0: ldc 80
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 86	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   9: astore_0
    //   10: new 88	android/graphics/BitmapFactory$Options
    //   13: dup
    //   14: invokespecial 91	android/graphics/BitmapFactory$Options:<init>	()V
    //   17: astore_1
    //   18: aload_1
    //   19: iconst_1
    //   20: putfield 95	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   23: aload_0
    //   24: aconst_null
    //   25: aload_1
    //   26: invokestatic 101	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   29: pop
    //   30: aload_0
    //   31: invokestatic 105	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   34: ldc 80
    //   36: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_1
    //   40: areturn
    //   41: astore_0
    //   42: aconst_null
    //   43: astore_0
    //   44: aload_0
    //   45: invokestatic 105	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   48: ldc 80
    //   50: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aconst_null
    //   54: areturn
    //   55: astore_1
    //   56: aconst_null
    //   57: astore_0
    //   58: aload_0
    //   59: invokestatic 105	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   62: ldc 80
    //   64: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   67: aload_1
    //   68: athrow
    //   69: astore_1
    //   70: goto -12 -> 58
    //   73: astore_1
    //   74: goto -30 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramString	String
    //   17	23	1	localOptions	BitmapFactory.Options
    //   55	13	1	localObject1	Object
    //   69	1	1	localObject2	Object
    //   73	1	1	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   5	10	41	java/io/FileNotFoundException
    //   5	10	55	finally
    //   10	30	69	finally
    //   10	30	73	java/io/FileNotFoundException
  }
  
  public static String aqN(String paramString)
  {
    AppMethodBeat.i(153461);
    paramString = com.tencent.mm.loader.j.b.asg() + String.format(Locale.US, "%s%d.%s", new Object[] { "mmexport", Long.valueOf(System.currentTimeMillis()), paramString });
    AppMethodBeat.o(153461);
    return paramString;
  }
  
  private static int cY(String paramString)
  {
    AppMethodBeat.i(175931);
    if (bt.isNullOrNil(paramString))
    {
      ad.d("Luggage.AndroidMediaUtil", "filepath is null or nil");
      AppMethodBeat.o(175931);
      return 0;
    }
    if (!com.tencent.mm.vfs.i.fv(paramString))
    {
      ad.d("Luggage.AndroidMediaUtil", "file not exist:[%s]", new Object[] { paramString });
      AppMethodBeat.o(175931);
      return 0;
    }
    int i = Exif.fromFile(paramString).getOrientationInDegree();
    AppMethodBeat.o(175931);
    return i;
  }
  
  static void ce(Context paramContext, String paramString)
  {
    AppMethodBeat.i(175930);
    String str2 = d.aNJ(paramString);
    if (str2 == null)
    {
      AppMethodBeat.o(175930);
      return;
    }
    ContentValues localContentValues = new ContentValues();
    Object localObject2;
    Object localObject1;
    if (str2.contains("image"))
    {
      localObject2 = MediaStore.Images.Media.getContentUri("external");
      localObject1 = aRC(paramString);
      if (localObject1 == null)
      {
        AppMethodBeat.o(175930);
        return;
      }
      localContentValues.put("width", Integer.valueOf(((BitmapFactory.Options)localObject1).outWidth));
      localContentValues.put("height", Integer.valueOf(((BitmapFactory.Options)localObject1).outHeight));
      if (!str2.contains("jpeg"))
      {
        localObject1 = localObject2;
        if (!str2.contains("jpg")) {}
      }
      else
      {
        localContentValues.put("orientation", Integer.valueOf(cY(paramString)));
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      String str1 = com.tencent.mm.vfs.i.k(paramString, false);
      localObject2 = str1;
      if (str1 == null) {
        localObject2 = paramString;
      }
      localContentValues.put("_data", (String)localObject2);
      localContentValues.put("_display_name", new e(paramString).getName());
      localContentValues.put("title", com.tencent.mm.vfs.i.aYt(paramString));
      localContentValues.put("_size", Long.valueOf(com.tencent.mm.vfs.i.aYo(paramString)));
      localContentValues.put("mime_type", str2);
      paramContext.getContentResolver().insert((Uri)localObject1, localContentValues);
      AppMethodBeat.o(175930);
      return;
      if (str2.contains("video"))
      {
        localObject1 = MediaStore.Video.Media.getContentUri("external");
        localObject2 = new com.tencent.mm.compatible.h.d();
        ((MediaMetadataRetriever)localObject2).setDataSource(paramString);
        localContentValues.put("width", ((MediaMetadataRetriever)localObject2).extractMetadata(18));
        localContentValues.put("height", ((MediaMetadataRetriever)localObject2).extractMetadata(19));
        localContentValues.put("duration", ((MediaMetadataRetriever)localObject2).extractMetadata(9));
        localContentValues.put("orientation", ((MediaMetadataRetriever)localObject2).extractMetadata(24));
      }
      else
      {
        localObject1 = MediaStore.Files.getContentUri("external");
      }
    }
  }
  
  @TargetApi(8)
  public static String ffo()
  {
    AppMethodBeat.i(221741);
    String str = com.tencent.mm.loader.j.b.asg();
    AppMethodBeat.o(221741);
    return str;
  }
  
  public static String ffp()
  {
    AppMethodBeat.i(153462);
    Object localObject = com.tencent.mm.loader.j.b.arO();
    if (((String)localObject).startsWith(com.tencent.mm.loader.j.b.arQ())) {}
    for (localObject = new File((String)localObject).getParentFile().getParentFile().getParentFile().getAbsolutePath();; localObject = com.tencent.mm.loader.j.b.arP())
    {
      try
      {
        str = new File((String)localObject).getCanonicalPath();
        localObject = str;
      }
      catch (Throwable localThrowable)
      {
        String str;
        label55:
        int i;
        break label55;
      }
      str = com.tencent.mm.vfs.i.k(com.tencent.mm.loader.j.b.asg(), true);
      i = str.indexOf((String)localObject);
      if (i < 0) {
        break label136;
      }
      localObject = str.substring(((String)localObject).length() + i);
      if (!((String)localObject).startsWith("/")) {
        break;
      }
      localObject = "/sdcard".concat(String.valueOf(localObject));
      AppMethodBeat.o(153462);
      return localObject;
    }
    localObject = "/sdcard/".concat(String.valueOf(localObject));
    AppMethodBeat.o(153462);
    return localObject;
    label136:
    AppMethodBeat.o(153462);
    return str;
  }
  
  public static void k(String paramString, Context paramContext)
  {
    AppMethodBeat.i(153460);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(153460);
      return;
    }
    String str1 = com.tencent.mm.vfs.i.k(paramString, false);
    if (str1 != null) {}
    try
    {
      ce(paramContext, str1);
    }
    catch (Throwable localThrowable)
    {
      try
      {
        for (;;)
        {
          paramContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", n.a(paramContext, new e(str1))));
          ad.i("Luggage.AndroidMediaUtil", "refreshing media scanner on path=%s", new Object[] { paramString });
          if (Build.VERSION.SDK_INT <= 28) {
            break;
          }
          try
          {
            String str2 = d.aNJ(paramString);
            MediaScannerConnection.scanFile(paramContext.getApplicationContext(), new String[] { str1 }, new String[] { str2 }, null);
            AppMethodBeat.o(153460);
            return;
          }
          catch (Throwable paramContext)
          {
            ad.e("Luggage.AndroidMediaUtil", "refresh by MediaScannerConnection, path = %s, thr = %s", new Object[] { paramString, paramContext });
            AppMethodBeat.o(153460);
            return;
          }
          localThrowable = localThrowable;
          ad.printErrStackTrace("Luggage.AndroidMediaUtil", localThrowable, "Cannot update media database", new Object[0]);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("Luggage.AndroidMediaUtil", localException, "", new Object[0]);
        }
      }
    }
    paramContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", n.a(paramContext, new e(paramString))).addFlags(1));
    ad.i("Luggage.AndroidMediaUtil", "refreshing media scanner on path=%s", new Object[] { paramString });
    AppMethodBeat.o(153460);
  }
  
  public static void o(String paramString, final Context paramContext)
  {
    AppMethodBeat.i(213159);
    h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213158);
        String str1 = this.val$path;
        Context localContext = paramContext;
        if (!bt.isNullOrNil(str1))
        {
          try
          {
            b.ce(localContext, str1);
          }
          catch (Throwable localThrowable2)
          {
            try
            {
              for (;;)
              {
                localContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", n.d(localContext, new File(str1))));
                ad.i("Luggage.AndroidMediaUtil", "refreshing media scanner on path=%s", new Object[] { str1 });
                if (Build.VERSION.SDK_INT <= 28) {
                  break;
                }
                try
                {
                  String str2 = d.aNJ(str1);
                  MediaScannerConnection.scanFile(localContext.getApplicationContext(), new String[] { str1 }, new String[] { str2 }, null);
                  AppMethodBeat.o(213158);
                  return;
                }
                catch (Throwable localThrowable1)
                {
                  ad.e("Luggage.AndroidMediaUtil", "refresh by MediaScannerConnection, path = %s, thr = %s", new Object[] { str1, localThrowable1 });
                  AppMethodBeat.o(213158);
                  return;
                }
                localThrowable2 = localThrowable2;
                ad.printErrStackTrace("Luggage.AndroidMediaUtil", localThrowable2, "Cannot update media database", new Object[0]);
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ad.printErrStackTrace("Luggage.AndroidMediaUtil", localException, "", new Object[0]);
              }
            }
          }
          localThrowable1.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", n.d(localThrowable1, new File(str1))).addFlags(1));
          ad.i("Luggage.AndroidMediaUtil", "refreshing media scanner on path=%s", new Object[] { str1 });
        }
        AppMethodBeat.o(213158);
      }
    });
    AppMethodBeat.o(213159);
  }
  
  public static void s(String paramString, final Context paramContext)
  {
    AppMethodBeat.i(221740);
    h.LTJ.aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(221739);
        b.k(this.val$path, paramContext);
        AppMethodBeat.o(221739);
      }
    });
    AppMethodBeat.o(221740);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.f.b
 * JD-Core Version:    0.7.0.1
 */