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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import java.io.File;
import java.util.Locale;

public final class b
{
  public static String aSY(String paramString)
  {
    AppMethodBeat.i(216752);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(216752);
      return "";
    }
    try
    {
      String str1 = new File(paramString).getCanonicalPath();
      if (str1.startsWith(com.tencent.mm.loader.j.b.asf()))
      {
        i = com.tencent.mm.loader.j.b.asf().length();
        if (i >= 0) {
          break label86;
        }
        AppMethodBeat.o(216752);
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
        if (str2.startsWith(com.tencent.mm.loader.j.b.ase()))
        {
          i = com.tencent.mm.loader.j.b.ase().length();
          continue;
          label86:
          paramString = paramString.substring(i);
          if (paramString.startsWith("/"))
          {
            paramString = "/sdcard".concat(String.valueOf(paramString));
            AppMethodBeat.o(216752);
            return paramString;
          }
          paramString = "/sdcard/".concat(String.valueOf(paramString));
          AppMethodBeat.o(216752);
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
  private static BitmapFactory.Options aSZ(String paramString)
  {
    // Byte code:
    //   0: ldc 80
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 86	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
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
    //   31: invokestatic 105	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   34: ldc 80
    //   36: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_1
    //   40: areturn
    //   41: astore_0
    //   42: aconst_null
    //   43: astore_0
    //   44: aload_0
    //   45: invokestatic 105	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   48: ldc 80
    //   50: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aconst_null
    //   54: areturn
    //   55: astore_1
    //   56: aconst_null
    //   57: astore_0
    //   58: aload_0
    //   59: invokestatic 105	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
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
  
  public static String arS(String paramString)
  {
    AppMethodBeat.i(153461);
    paramString = com.tencent.mm.loader.j.b.asv() + String.format(Locale.US, "%s%d.%s", new Object[] { "mmexport", Long.valueOf(System.currentTimeMillis()), paramString });
    AppMethodBeat.o(153461);
    return paramString;
  }
  
  static void cf(Context paramContext, String paramString)
  {
    AppMethodBeat.i(175930);
    String str2 = d.aPg(paramString);
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
      localObject1 = aSZ(paramString);
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
        localContentValues.put("orientation", Integer.valueOf(df(paramString)));
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      String str1 = com.tencent.mm.vfs.o.k(paramString, false);
      localObject2 = str1;
      if (str1 == null) {
        localObject2 = paramString;
      }
      localContentValues.put("_data", (String)localObject2);
      localContentValues.put("_display_name", new k(paramString).getName());
      localContentValues.put("title", com.tencent.mm.vfs.o.aZW(paramString));
      localContentValues.put("_size", Long.valueOf(com.tencent.mm.vfs.o.aZR(paramString)));
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
  
  private static int df(String paramString)
  {
    AppMethodBeat.i(175931);
    if (bu.isNullOrNil(paramString))
    {
      ae.d("Luggage.AndroidMediaUtil", "filepath is null or nil");
      AppMethodBeat.o(175931);
      return 0;
    }
    if (!com.tencent.mm.vfs.o.fB(paramString))
    {
      ae.d("Luggage.AndroidMediaUtil", "file not exist:[%s]", new Object[] { paramString });
      AppMethodBeat.o(175931);
      return 0;
    }
    int i = Exif.fromFile(paramString).getOrientationInDegree();
    AppMethodBeat.o(175931);
    return i;
  }
  
  @TargetApi(8)
  public static String fje()
  {
    AppMethodBeat.i(224561);
    String str = com.tencent.mm.loader.j.b.asv();
    AppMethodBeat.o(224561);
    return str;
  }
  
  public static String fjf()
  {
    AppMethodBeat.i(153462);
    Object localObject = com.tencent.mm.loader.j.b.asd();
    if (((String)localObject).startsWith(com.tencent.mm.loader.j.b.asf())) {}
    for (localObject = new File((String)localObject).getParentFile().getParentFile().getParentFile().getAbsolutePath();; localObject = com.tencent.mm.loader.j.b.ase())
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
      str = com.tencent.mm.vfs.o.k(com.tencent.mm.loader.j.b.asv(), true);
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
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(153460);
      return;
    }
    String str1 = com.tencent.mm.vfs.o.k(paramString, false);
    if (str1 != null) {}
    try
    {
      cf(paramContext, str1);
    }
    catch (Throwable localThrowable)
    {
      try
      {
        for (;;)
        {
          paramContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", com.tencent.mm.sdk.platformtools.o.a(paramContext, new k(str1))));
          ae.i("Luggage.AndroidMediaUtil", "refreshing media scanner on path=%s", new Object[] { paramString });
          if (Build.VERSION.SDK_INT <= 28) {
            break;
          }
          try
          {
            String str2 = d.aPg(paramString);
            MediaScannerConnection.scanFile(paramContext.getApplicationContext(), new String[] { str1 }, new String[] { str2 }, null);
            AppMethodBeat.o(153460);
            return;
          }
          catch (Throwable paramContext)
          {
            ae.e("Luggage.AndroidMediaUtil", "refresh by MediaScannerConnection, path = %s, thr = %s", new Object[] { paramString, paramContext });
            AppMethodBeat.o(153460);
            return;
          }
          localThrowable = localThrowable;
          ae.printErrStackTrace("Luggage.AndroidMediaUtil", localThrowable, "Cannot update media database", new Object[0]);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("Luggage.AndroidMediaUtil", localException, "", new Object[0]);
        }
      }
    }
    paramContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", com.tencent.mm.sdk.platformtools.o.a(paramContext, new k(paramString))).addFlags(1));
    ae.i("Luggage.AndroidMediaUtil", "refreshing media scanner on path=%s", new Object[] { paramString });
    AppMethodBeat.o(153460);
  }
  
  public static void m(String paramString, final Context paramContext)
  {
    AppMethodBeat.i(216749);
    h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(216747);
        b.k(this.val$path, paramContext);
        AppMethodBeat.o(216747);
      }
    });
    AppMethodBeat.o(216749);
  }
  
  public static void n(String paramString, final Context paramContext)
  {
    AppMethodBeat.i(216750);
    h.MqF.aO(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(216748);
        String str1 = this.val$path;
        Context localContext = paramContext;
        if (!bu.isNullOrNil(str1))
        {
          try
          {
            b.cf(localContext, str1);
          }
          catch (Throwable localThrowable2)
          {
            try
            {
              for (;;)
              {
                localContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", com.tencent.mm.sdk.platformtools.o.d(localContext, new File(str1))));
                ae.i("Luggage.AndroidMediaUtil", "refreshing media scanner on path=%s", new Object[] { str1 });
                if (Build.VERSION.SDK_INT <= 28) {
                  break;
                }
                try
                {
                  String str2 = d.aPg(str1);
                  MediaScannerConnection.scanFile(localContext.getApplicationContext(), new String[] { str1 }, new String[] { str2 }, null);
                  AppMethodBeat.o(216748);
                  return;
                }
                catch (Throwable localThrowable1)
                {
                  ae.e("Luggage.AndroidMediaUtil", "refresh by MediaScannerConnection, path = %s, thr = %s", new Object[] { str1, localThrowable1 });
                  AppMethodBeat.o(216748);
                  return;
                }
                localThrowable2 = localThrowable2;
                ae.printErrStackTrace("Luggage.AndroidMediaUtil", localThrowable2, "Cannot update media database", new Object[0]);
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                ae.printErrStackTrace("Luggage.AndroidMediaUtil", localException, "", new Object[0]);
              }
            }
          }
          localThrowable1.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", com.tencent.mm.sdk.platformtools.o.d(localThrowable1, new File(str1))).addFlags(1));
          ae.i("Luggage.AndroidMediaUtil", "refreshing media scanner on path=%s", new Object[] { str1 });
        }
        AppMethodBeat.o(216748);
      }
    });
    AppMethodBeat.o(216750);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.f.b
 * JD-Core Version:    0.7.0.1
 */