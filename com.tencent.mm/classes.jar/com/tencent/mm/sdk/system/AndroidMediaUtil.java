package com.tencent.mm.sdk.system;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.provider.MediaStore.Files;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.i.d;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
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
    if (!y.ZC(paramString))
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
    AppMethodBeat.i(243230);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(243230);
      return "";
    }
    try
    {
      String str1 = new File(paramString).getCanonicalPath();
      if (str1.startsWith(b.bmv()))
      {
        i = b.bmv().length();
        if (i >= 0) {
          break label86;
        }
        AppMethodBeat.o(243230);
        return paramString;
      }
    }
    finally
    {
      for (;;)
      {
        int i;
        String str2 = paramString;
        continue;
        if (str2.startsWith(b.bmu()))
        {
          i = b.bmu().length();
          continue;
          label86:
          paramString = paramString.substring(i);
          if (paramString.startsWith("/"))
          {
            paramString = "/sdcard".concat(String.valueOf(paramString));
            AppMethodBeat.o(243230);
            return paramString;
          }
          paramString = "/sdcard/".concat(String.valueOf(paramString));
          AppMethodBeat.o(243230);
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
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 161	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
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
    //   36: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: aload_1
    //   40: areturn
    //   41: astore_0
    //   42: aconst_null
    //   43: astore_0
    //   44: aload_0
    //   45: invokestatic 178	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   48: ldc 157
    //   50: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   53: aconst_null
    //   54: areturn
    //   55: astore_1
    //   56: aconst_null
    //   57: astore_0
    //   58: aload_0
    //   59: invokestatic 178	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   62: ldc 157
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
  
  public static String getSysCameraDirPath()
  {
    AppMethodBeat.i(175928);
    String str = b.bmL();
    AppMethodBeat.o(175928);
    return str;
  }
  
  public static String getToastSysCameraPath()
  {
    AppMethodBeat.i(153462);
    Object localObject1 = b.bmt();
    if (((String)localObject1).startsWith(b.bmv())) {}
    for (localObject1 = new File((String)localObject1).getParentFile().getParentFile().getParentFile().getAbsolutePath();; localObject1 = b.bmu())
    {
      try
      {
        str = new File((String)localObject1).getCanonicalPath();
        localObject1 = str;
      }
      finally
      {
        String str;
        label54:
        int i;
        break label54;
      }
      str = y.n(getSysCameraDirPath(), true);
      i = str.indexOf((String)localObject1);
      if (i < 0) {
        break label133;
      }
      localObject1 = str.substring(((String)localObject1).length() + i);
      if (!((String)localObject1).startsWith("/")) {
        break;
      }
      localObject1 = "/sdcard".concat(String.valueOf(localObject1));
      AppMethodBeat.o(153462);
      return localObject1;
    }
    localObject1 = "/sdcard/".concat(String.valueOf(localObject1));
    AppMethodBeat.o(153462);
    return localObject1;
    label133:
    AppMethodBeat.o(153462);
    return str;
  }
  
  public static void insertPathIntoMediaStore(Context paramContext, String paramString)
  {
    AppMethodBeat.i(243223);
    updateMediaDatabase(paramContext, paramString);
    AppMethodBeat.o(243223);
  }
  
  public static void insertPathIntoMediaStoreAsync(Context paramContext, final String paramString)
  {
    AppMethodBeat.i(243220);
    h.ahAA.bm(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(243197);
        AndroidMediaUtil.insertPathIntoMediaStore(AndroidMediaUtil.this, paramString);
        AppMethodBeat.o(243197);
      }
    });
    AppMethodBeat.o(243220);
  }
  
  /* Error */
  public static void refreshMediaScanner(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: ldc 228
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 34	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifeq +9 -> 18
    //   12: ldc 228
    //   14: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: return
    //   18: aload_0
    //   19: iconst_0
    //   20: invokestatic 198	com/tencent/mm/vfs/y:n	(Ljava/lang/String;Z)Ljava/lang/String;
    //   23: astore_2
    //   24: aload_2
    //   25: ifnull +33 -> 58
    //   28: aload_1
    //   29: aload_2
    //   30: invokestatic 207	com/tencent/mm/sdk/system/AndroidMediaUtil:updateMediaDatabase	(Landroid/content/Context;Ljava/lang/String;)V
    //   33: aload_1
    //   34: new 230	android/content/Intent
    //   37: dup
    //   38: ldc 232
    //   40: aload_1
    //   41: new 234	com/tencent/mm/vfs/u
    //   44: dup
    //   45: aload_2
    //   46: invokespecial 235	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   49: invokestatic 241	com/tencent/mm/sdk/platformtools/FileProviderHelper:getUriForFile	(Landroid/content/Context;Lcom/tencent/mm/vfs/u;)Landroid/net/Uri;
    //   52: invokespecial 244	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   55: invokevirtual 250	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   58: ldc 14
    //   60: ldc 252
    //   62: iconst_1
    //   63: anewarray 4	java/lang/Object
    //   66: dup
    //   67: iconst_0
    //   68: aload_0
    //   69: aastore
    //   70: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   73: getstatic 260	android/os/Build$VERSION:SDK_INT	I
    //   76: bipush 28
    //   78: if_icmple +98 -> 176
    //   81: aload_0
    //   82: invokestatic 265	com/tencent/mm/sdk/system/MimeTypeUtil:getMimeTypeByFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   85: astore_3
    //   86: aload_1
    //   87: invokevirtual 269	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   90: iconst_1
    //   91: anewarray 103	java/lang/String
    //   94: dup
    //   95: iconst_0
    //   96: aload_2
    //   97: aastore
    //   98: iconst_1
    //   99: anewarray 103	java/lang/String
    //   102: dup
    //   103: iconst_0
    //   104: aload_3
    //   105: aastore
    //   106: aconst_null
    //   107: invokestatic 275	android/media/MediaScannerConnection:scanFile	(Landroid/content/Context;[Ljava/lang/String;[Ljava/lang/String;Landroid/media/MediaScannerConnection$OnScanCompletedListener;)V
    //   110: ldc 228
    //   112: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: return
    //   116: astore_3
    //   117: ldc 14
    //   119: aload_3
    //   120: ldc_w 277
    //   123: iconst_0
    //   124: anewarray 4	java/lang/Object
    //   127: invokestatic 281	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: goto -97 -> 33
    //   133: astore_3
    //   134: ldc 14
    //   136: aload_3
    //   137: ldc 114
    //   139: iconst_0
    //   140: anewarray 4	java/lang/Object
    //   143: invokestatic 281	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: goto -88 -> 58
    //   149: astore_1
    //   150: ldc 14
    //   152: ldc_w 283
    //   155: iconst_2
    //   156: anewarray 4	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: aload_0
    //   162: aastore
    //   163: dup
    //   164: iconst_1
    //   165: aload_1
    //   166: aastore
    //   167: invokestatic 286	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: ldc 228
    //   172: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: return
    //   176: aload_1
    //   177: new 230	android/content/Intent
    //   180: dup
    //   181: ldc 232
    //   183: aload_1
    //   184: new 234	com/tencent/mm/vfs/u
    //   187: dup
    //   188: aload_0
    //   189: invokespecial 235	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   192: invokestatic 241	com/tencent/mm/sdk/platformtools/FileProviderHelper:getUriForFile	(Landroid/content/Context;Lcom/tencent/mm/vfs/u;)Landroid/net/Uri;
    //   195: invokespecial 244	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   198: iconst_1
    //   199: invokevirtual 290	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   202: invokevirtual 250	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   205: ldc 14
    //   207: ldc 252
    //   209: iconst_1
    //   210: anewarray 4	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: aload_0
    //   216: aastore
    //   217: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: ldc 228
    //   222: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   225: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramString	String
    //   0	226	1	paramContext	Context
    //   23	74	2	str1	String
    //   85	20	3	str2	String
    //   116	4	3	localThrowable	java.lang.Throwable
    //   133	4	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   28	33	116	finally
    //   33	58	133	java/lang/Exception
    //   81	110	149	finally
  }
  
  public static void refreshMediaScannerAsync(String paramString, final Context paramContext)
  {
    AppMethodBeat.i(243203);
    h.ahAA.bm(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(243201);
        AndroidMediaUtil.refreshMediaScanner(AndroidMediaUtil.this, paramContext);
        AppMethodBeat.o(243201);
      }
    });
    AppMethodBeat.o(243203);
  }
  
  /* Error */
  public static void refreshMediaScannerWithoutVFSRemap(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 296
    //   3: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 34	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   10: ifeq +10 -> 20
    //   13: ldc_w 296
    //   16: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: return
    //   20: aload_1
    //   21: aload_0
    //   22: invokestatic 207	com/tencent/mm/sdk/system/AndroidMediaUtil:updateMediaDatabase	(Landroid/content/Context;Ljava/lang/String;)V
    //   25: aload_1
    //   26: new 230	android/content/Intent
    //   29: dup
    //   30: ldc 232
    //   32: aload_1
    //   33: new 116	java/io/File
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: invokestatic 300	com/tencent/mm/sdk/platformtools/FileProviderHelper:getUriForFileWithoutVFSRemap	(Landroid/content/Context;Ljava/io/File;)Landroid/net/Uri;
    //   44: invokespecial 244	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   47: invokevirtual 250	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   50: ldc 14
    //   52: ldc 252
    //   54: iconst_1
    //   55: anewarray 4	java/lang/Object
    //   58: dup
    //   59: iconst_0
    //   60: aload_0
    //   61: aastore
    //   62: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: getstatic 260	android/os/Build$VERSION:SDK_INT	I
    //   68: bipush 28
    //   70: if_icmple +100 -> 170
    //   73: aload_0
    //   74: invokestatic 265	com/tencent/mm/sdk/system/MimeTypeUtil:getMimeTypeByFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   77: astore_2
    //   78: aload_1
    //   79: invokevirtual 269	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   82: iconst_1
    //   83: anewarray 103	java/lang/String
    //   86: dup
    //   87: iconst_0
    //   88: aload_0
    //   89: aastore
    //   90: iconst_1
    //   91: anewarray 103	java/lang/String
    //   94: dup
    //   95: iconst_0
    //   96: aload_2
    //   97: aastore
    //   98: aconst_null
    //   99: invokestatic 275	android/media/MediaScannerConnection:scanFile	(Landroid/content/Context;[Ljava/lang/String;[Ljava/lang/String;Landroid/media/MediaScannerConnection$OnScanCompletedListener;)V
    //   102: ldc_w 296
    //   105: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: return
    //   109: astore_2
    //   110: ldc 14
    //   112: aload_2
    //   113: ldc_w 277
    //   116: iconst_0
    //   117: anewarray 4	java/lang/Object
    //   120: invokestatic 281	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   123: goto -98 -> 25
    //   126: astore_2
    //   127: ldc 14
    //   129: aload_2
    //   130: ldc 114
    //   132: iconst_0
    //   133: anewarray 4	java/lang/Object
    //   136: invokestatic 281	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: goto -89 -> 50
    //   142: astore_1
    //   143: ldc 14
    //   145: ldc_w 283
    //   148: iconst_2
    //   149: anewarray 4	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: aload_0
    //   155: aastore
    //   156: dup
    //   157: iconst_1
    //   158: aload_1
    //   159: aastore
    //   160: invokestatic 286	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   163: ldc_w 296
    //   166: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: return
    //   170: aload_1
    //   171: new 230	android/content/Intent
    //   174: dup
    //   175: ldc 232
    //   177: aload_1
    //   178: new 116	java/io/File
    //   181: dup
    //   182: aload_0
    //   183: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   186: invokestatic 300	com/tencent/mm/sdk/platformtools/FileProviderHelper:getUriForFileWithoutVFSRemap	(Landroid/content/Context;Ljava/io/File;)Landroid/net/Uri;
    //   189: invokespecial 244	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   192: iconst_1
    //   193: invokevirtual 290	android/content/Intent:addFlags	(I)Landroid/content/Intent;
    //   196: invokevirtual 250	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   199: ldc 14
    //   201: ldc 252
    //   203: iconst_1
    //   204: anewarray 4	java/lang/Object
    //   207: dup
    //   208: iconst_0
    //   209: aload_0
    //   210: aastore
    //   211: invokestatic 254	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: ldc_w 296
    //   217: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	paramString	String
    //   0	221	1	paramContext	Context
    //   77	20	2	str	String
    //   109	4	2	localThrowable	java.lang.Throwable
    //   126	4	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   20	25	109	finally
    //   25	50	126	java/lang/Exception
    //   73	102	142	finally
  }
  
  public static void refreshMediaScannerWithoutVFSRemapAsync(String paramString, final Context paramContext)
  {
    AppMethodBeat.i(243211);
    h.ahAA.bm(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(243209);
        AndroidMediaUtil.refreshMediaScannerWithoutVFSRemap(AndroidMediaUtil.this, paramContext);
        AppMethodBeat.o(243209);
      }
    });
    AppMethodBeat.o(243211);
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
        String str1 = y.n(paramString, false);
        localObject = str1;
        if (str1 == null) {
          localObject = paramString;
        }
        localContentValues.put("_data", (String)localObject);
        localContentValues.put("_display_name", new u(paramString).getName());
        localContentValues.put("title", y.bEq(paramString));
        localContentValues.put("_size", Long.valueOf(y.bEl(paramString)));
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
    finally
    {
      Log.printErrStackTrace("Luggage.AndroidMediaUtil", paramContext, "[-] Failed when updateMediaDatabase", new Object[0]);
      AppMethodBeat.o(175930);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.system.AndroidMediaUtil
 * JD-Core Version:    0.7.0.1
 */