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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
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
    if (!u.agG(paramString))
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
    AppMethodBeat.i(209907);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(209907);
      return "";
    }
    try
    {
      String str1 = new File(paramString).getCanonicalPath();
      if (str1.startsWith(b.aSH()))
      {
        i = b.aSH().length();
        if (i >= 0) {
          break label86;
        }
        AppMethodBeat.o(209907);
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
        if (str2.startsWith(b.aSG()))
        {
          i = b.aSG().length();
          continue;
          label86:
          paramString = paramString.substring(i);
          if (paramString.startsWith("/"))
          {
            paramString = "/sdcard".concat(String.valueOf(paramString));
            AppMethodBeat.o(209907);
            return paramString;
          }
          paramString = "/sdcard/".concat(String.valueOf(paramString));
          AppMethodBeat.o(209907);
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
    //   0: ldc 157
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 161	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   9: astore_0
    //   10: new 163	android/graphics/BitmapFactory$Options
    //   13: dup
    //   14: invokespecial 164	android/graphics/BitmapFactory$Options:<init>	()V
    //   17: astore_1
    //   18: aload_1
    //   19: iconst_1
    //   20: putfield 168	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   23: aload_0
    //   24: aconst_null
    //   25: aload_1
    //   26: invokestatic 174	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   29: pop
    //   30: aload_0
    //   31: invokestatic 178	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   34: ldc 157
    //   36: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_1
    //   40: areturn
    //   41: astore_0
    //   42: aconst_null
    //   43: astore_0
    //   44: aload_0
    //   45: invokestatic 178	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   48: ldc 157
    //   50: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aconst_null
    //   54: areturn
    //   55: astore_1
    //   56: aconst_null
    //   57: astore_0
    //   58: aload_0
    //   59: invokestatic 178	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   62: ldc 157
    //   64: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    String str = b.aSX();
    AppMethodBeat.o(175928);
    return str;
  }
  
  public static String getToastSysCameraPath()
  {
    AppMethodBeat.i(153462);
    Object localObject = b.aSF();
    if (((String)localObject).startsWith(b.aSH())) {}
    for (localObject = new File((String)localObject).getParentFile().getParentFile().getParentFile().getAbsolutePath();; localObject = b.aSG())
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
      str = u.n(getSysCameraDirPath(), true);
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
    AppMethodBeat.i(209905);
    updateMediaDatabase(paramContext, paramString);
    AppMethodBeat.o(209905);
  }
  
  public static void insertPathIntoMediaStoreAsync(Context paramContext, final String paramString)
  {
    AppMethodBeat.i(209904);
    h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(209987);
        AndroidMediaUtil.insertPathIntoMediaStore(this.val$context, paramString);
        AppMethodBeat.o(209987);
      }
    });
    AppMethodBeat.o(209904);
  }
  
  public static void refreshMediaScanner(String paramString, Context paramContext)
  {
    AppMethodBeat.i(153460);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(153460);
      return;
    }
    String str1 = u.n(paramString, false);
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
          paramContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", FileProviderHelper.getUriForFile(paramContext, new q(str1))));
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
    paramContext.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", FileProviderHelper.getUriForFile(paramContext, new q(paramString))).addFlags(1));
    Log.i("Luggage.AndroidMediaUtil", "refreshing media scanner on path=%s", new Object[] { paramString });
    AppMethodBeat.o(153460);
  }
  
  public static void refreshMediaScannerAsync(String paramString, Context paramContext)
  {
    AppMethodBeat.i(209900);
    h.ZvG.be(new AndroidMediaUtil.1(paramString, paramContext));
    AppMethodBeat.o(209900);
  }
  
  public static void refreshMediaScannerWithoutVFSRemap(String paramString, Context paramContext)
  {
    AppMethodBeat.i(209903);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(209903);
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
            AppMethodBeat.o(209903);
            return;
          }
          catch (Throwable paramContext)
          {
            Log.e("Luggage.AndroidMediaUtil", "refresh by MediaScannerConnection, path = %s, thr = %s", new Object[] { paramString, paramContext });
            AppMethodBeat.o(209903);
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
    AppMethodBeat.o(209903);
  }
  
  public static void refreshMediaScannerWithoutVFSRemapAsync(String paramString, final Context paramContext)
  {
    AppMethodBeat.i(209902);
    h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(209949);
        AndroidMediaUtil.refreshMediaScannerWithoutVFSRemap(this.val$path, paramContext);
        AppMethodBeat.o(209949);
      }
    });
    AppMethodBeat.o(209902);
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
        String str1 = u.n(paramString, false);
        localObject = str1;
        if (str1 == null) {
          localObject = paramString;
        }
        localContentValues.put("_data", (String)localObject);
        localContentValues.put("_display_name", new q(paramString).getName());
        localContentValues.put("title", u.bBW(paramString));
        localContentValues.put("_size", Long.valueOf(u.bBQ(paramString)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.system.AndroidMediaUtil
 * JD-Core Version:    0.7.0.1
 */