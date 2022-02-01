package com.tencent.mm.sdk.system;

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
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.File;
import java.util.Locale;

public class AndroidMediaUtil
{
  private static final String TAG = "Luggage.AndroidMediaUtil";
  
  private static int getExifOrientation(String paramString)
  {
    AppMethodBeat.i(175931);
    if (Util.isNullOrNil(paramString))
    {
      Log.d("Luggage.AndroidMediaUtil", "filepath is null or nil");
      AppMethodBeat.o(175931);
      return 0;
    }
    if (!s.YS(paramString))
    {
      Log.d("Luggage.AndroidMediaUtil", "file not exist:[%s]", new Object[] { paramString });
      AppMethodBeat.o(175931);
      return 0;
    }
    int i = Exif.fromFile(paramString).getOrientationInDegree();
    AppMethodBeat.o(175931);
    return i;
  }
  
  public static String getExportImagePath(String paramString)
  {
    AppMethodBeat.i(153461);
    paramString = getSysCameraDirPath() + String.format(Locale.US, "%s%d.%s", new Object[] { "mmexport", Long.valueOf(System.currentTimeMillis()), paramString });
    AppMethodBeat.o(153461);
    return paramString;
  }
  
  public static String getFriendlySdcardPath(String paramString)
  {
    AppMethodBeat.i(214367);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(214367);
      return "";
    }
    try
    {
      String str1 = new File(paramString).getCanonicalPath();
      if (str1.startsWith(b.aKF()))
      {
        i = b.aKF().length();
        if (i >= 0) {
          break label86;
        }
        AppMethodBeat.o(214367);
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
        if (str2.startsWith(b.aKE()))
        {
          i = b.aKE().length();
          continue;
          label86:
          paramString = paramString.substring(i);
          if (paramString.startsWith("/"))
          {
            paramString = "/sdcard".concat(String.valueOf(paramString));
            AppMethodBeat.o(214367);
            return paramString;
          }
          paramString = "/sdcard/".concat(String.valueOf(paramString));
          AppMethodBeat.o(214367);
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
  private static BitmapFactory.Options getImageOptionsJustDecodeBounds(String paramString)
  {
    // Byte code:
    //   0: ldc 159
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 163	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   9: astore_0
    //   10: new 165	android/graphics/BitmapFactory$Options
    //   13: dup
    //   14: invokespecial 166	android/graphics/BitmapFactory$Options:<init>	()V
    //   17: astore_1
    //   18: aload_1
    //   19: iconst_1
    //   20: putfield 170	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   23: aload_0
    //   24: aconst_null
    //   25: aload_1
    //   26: invokestatic 176	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   29: pop
    //   30: aload_0
    //   31: invokestatic 180	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   34: ldc 159
    //   36: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_1
    //   40: areturn
    //   41: astore_0
    //   42: aconst_null
    //   43: astore_0
    //   44: aload_0
    //   45: invokestatic 180	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   48: ldc 159
    //   50: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aconst_null
    //   54: areturn
    //   55: astore_1
    //   56: aconst_null
    //   57: astore_0
    //   58: aload_0
    //   59: invokestatic 180	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   62: ldc 159
    //   64: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  @TargetApi(8)
  public static String getSysCameraDirPath()
  {
    AppMethodBeat.i(175928);
    String str = b.aKV();
    AppMethodBeat.o(175928);
    return str;
  }
  
  public static String getToastSysCameraPath()
  {
    AppMethodBeat.i(153462);
    Object localObject = b.aKD();
    if (((String)localObject).startsWith(b.aKF())) {}
    for (localObject = new File((String)localObject).getParentFile().getParentFile().getParentFile().getAbsolutePath();; localObject = b.aKE())
    {
      try
      {
        str = new File((String)localObject).getCanonicalPath();
        localObject = str;
      }
      catch (Throwable localThrowable)
      {
        String str;
        label54:
        int i;
        break label54;
      }
      str = s.k(getSysCameraDirPath(), true);
      i = str.indexOf((String)localObject);
      if (i < 0) {
        break label133;
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
    label133:
    AppMethodBeat.o(153462);
    return str;
  }
  
  public static void insertPathIntoMediaStore(Context paramContext, String paramString)
  {
    AppMethodBeat.i(214366);
    updateMediaDatabase(paramContext, paramString);
    AppMethodBeat.o(214366);
  }
  
  public static void insertPathIntoMediaStoreAsync(Context paramContext, final String paramString)
  {
    AppMethodBeat.i(214365);
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(214361);
        AndroidMediaUtil.insertPathIntoMediaStore(this.val$context, paramString);
        AppMethodBeat.o(214361);
      }
    });
    AppMethodBeat.o(214365);
  }
  
  public static void refreshMediaScanner(String paramString, Context paramContext)
  {
    AppMethodBeat.i(153460);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(153460);
      return;
    }
    String str1 = s.k(paramString, false);
    if (str1 != null) {}
    try
    {
      updateMediaDatabase(paramContext, str1);
    }
    catch (Throwable localThrowable)
    {
      try
      {
        for (;;)
        {
          paramContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", FileProviderHelper.getUriForFile(paramContext, new o(str1))));
          Log.i("Luggage.AndroidMediaUtil", "refreshing media scanner on path=%s", new Object[] { paramString });
          if (Build.VERSION.SDK_INT <= 28) {
            break;
          }
          try
          {
            String str2 = MimeTypeUtil.getMimeTypeByFilePath(paramString);
            MediaScannerConnection.scanFile(paramContext.getApplicationContext(), new String[] { str1 }, new String[] { str2 }, null);
            AppMethodBeat.o(153460);
            return;
          }
          catch (Throwable paramContext)
          {
            Log.e("Luggage.AndroidMediaUtil", "refresh by MediaScannerConnection, path = %s, thr = %s", new Object[] { paramString, paramContext });
            AppMethodBeat.o(153460);
            return;
          }
          localThrowable = localThrowable;
          Log.printErrStackTrace("Luggage.AndroidMediaUtil", localThrowable, "Cannot update media database", new Object[0]);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("Luggage.AndroidMediaUtil", localException, "", new Object[0]);
        }
      }
    }
    paramContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", FileProviderHelper.getUriForFile(paramContext, new o(paramString))).addFlags(1));
    Log.i("Luggage.AndroidMediaUtil", "refreshing media scanner on path=%s", new Object[] { paramString });
    AppMethodBeat.o(153460);
  }
  
  public static void refreshMediaScannerAsync(String paramString, final Context paramContext)
  {
    AppMethodBeat.i(214362);
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(214359);
        AndroidMediaUtil.refreshMediaScanner(this.val$path, paramContext);
        AppMethodBeat.o(214359);
      }
    });
    AppMethodBeat.o(214362);
  }
  
  public static void refreshMediaScannerWithoutVFSRemap(String paramString, Context paramContext)
  {
    AppMethodBeat.i(214364);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(214364);
      return;
    }
    try
    {
      updateMediaDatabase(paramContext, paramString);
    }
    catch (Throwable localThrowable)
    {
      try
      {
        for (;;)
        {
          paramContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", FileProviderHelper.getUriForFileWithoutVFSRemap(paramContext, new File(paramString))));
          Log.i("Luggage.AndroidMediaUtil", "refreshing media scanner on path=%s", new Object[] { paramString });
          if (Build.VERSION.SDK_INT <= 28) {
            break;
          }
          try
          {
            String str = MimeTypeUtil.getMimeTypeByFilePath(paramString);
            MediaScannerConnection.scanFile(paramContext.getApplicationContext(), new String[] { paramString }, new String[] { str }, null);
            AppMethodBeat.o(214364);
            return;
          }
          catch (Throwable paramContext)
          {
            Log.e("Luggage.AndroidMediaUtil", "refresh by MediaScannerConnection, path = %s, thr = %s", new Object[] { paramString, paramContext });
            AppMethodBeat.o(214364);
            return;
          }
          localThrowable = localThrowable;
          Log.printErrStackTrace("Luggage.AndroidMediaUtil", localThrowable, "Cannot update media database", new Object[0]);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("Luggage.AndroidMediaUtil", localException, "", new Object[0]);
        }
      }
    }
    paramContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", FileProviderHelper.getUriForFileWithoutVFSRemap(paramContext, new File(paramString))).addFlags(1));
    Log.i("Luggage.AndroidMediaUtil", "refreshing media scanner on path=%s", new Object[] { paramString });
    AppMethodBeat.o(214364);
  }
  
  public static void refreshMediaScannerWithoutVFSRemapAsync(String paramString, final Context paramContext)
  {
    AppMethodBeat.i(214363);
    h.RTc.aX(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(214360);
        AndroidMediaUtil.refreshMediaScannerWithoutVFSRemap(this.val$path, paramContext);
        AppMethodBeat.o(214360);
      }
    });
    AppMethodBeat.o(214363);
  }
  
  private static void updateMediaDatabase(Context paramContext, String paramString)
  {
    AppMethodBeat.i(175930);
    try
    {
      String str2 = MimeTypeUtil.getMimeTypeByFilePath(paramString);
      if (str2 == null)
      {
        AppMethodBeat.o(175930);
        return;
      }
      ContentValues localContentValues = new ContentValues();
      Uri localUri;
      Object localObject;
      if (str2.contains("image"))
      {
        localUri = MediaStore.Images.Media.getContentUri("external");
        localObject = getImageOptionsJustDecodeBounds(paramString);
        if (localObject == null)
        {
          AppMethodBeat.o(175930);
          return;
        }
        localContentValues.put("width", Integer.valueOf(((BitmapFactory.Options)localObject).outWidth));
        localContentValues.put("height", Integer.valueOf(((BitmapFactory.Options)localObject).outHeight));
        if ((!str2.contains("jpeg")) && (!str2.contains("jpg"))) {
          break label358;
        }
        localContentValues.put("orientation", Integer.valueOf(getExifOrientation(paramString)));
      }
      for (;;)
      {
        String str1 = s.k(paramString, false);
        localObject = str1;
        if (str1 == null) {
          localObject = paramString;
        }
        localContentValues.put("_data", (String)localObject);
        localContentValues.put("_display_name", new o(paramString).getName());
        localContentValues.put("title", s.bpb(paramString));
        localContentValues.put("_size", Long.valueOf(s.boW(paramString)));
        localContentValues.put("mime_type", str2);
        paramContext.getContentResolver().insert(localUri, localContentValues);
        AppMethodBeat.o(175930);
        return;
        if (str2.contains("video"))
        {
          localUri = MediaStore.Video.Media.getContentUri("external");
          localObject = new d();
          ((MediaMetadataRetriever)localObject).setDataSource(paramString);
          localContentValues.put("width", ((MediaMetadataRetriever)localObject).extractMetadata(18));
          localContentValues.put("height", ((MediaMetadataRetriever)localObject).extractMetadata(19));
          localContentValues.put("duration", ((MediaMetadataRetriever)localObject).extractMetadata(9));
          localContentValues.put("orientation", ((MediaMetadataRetriever)localObject).extractMetadata(24));
        }
        else
        {
          localUri = MediaStore.Files.getContentUri("external");
        }
      }
    }
    catch (Throwable paramContext)
    {
      Log.printErrStackTrace("Luggage.AndroidMediaUtil", paramContext, "[-] Failed when updateMediaDatabase", new Object[0]);
      AppMethodBeat.o(175930);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.system.AndroidMediaUtil
 * JD-Core Version:    0.7.0.1
 */