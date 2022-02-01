package com.tencent.mm.sdk.platformtools;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Downloads;
import android.provider.MediaStore.Files;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.y;
import java.io.File;
import java.io.OutputStream;

public final class ScopedStorageUtil$MediaStoreOps
{
  public static Uri audioPathToUri(Context paramContext, String paramString)
  {
    AppMethodBeat.i(243834);
    paramContext = pathToUri(paramContext, paramString, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
    AppMethodBeat.o(243834);
    return paramContext;
  }
  
  public static Uri downloadPathToUri(Context paramContext, String paramString)
  {
    AppMethodBeat.i(243838);
    paramContext = pathToUri(paramContext, paramString, MediaStore.Downloads.EXTERNAL_CONTENT_URI);
    AppMethodBeat.o(243838);
    return paramContext;
  }
  
  public static Uri filePathToUri(Context paramContext, String paramString)
  {
    AppMethodBeat.i(243842);
    paramContext = pathToUri(paramContext, paramString, MediaStore.Files.getContentUri("external"));
    AppMethodBeat.o(243842);
    return paramContext;
  }
  
  private static OutputStream getFileOutputStream(String paramString)
  {
    AppMethodBeat.i(243770);
    paramString = y.ev(paramString, false);
    AppMethodBeat.o(243770);
    return paramString;
  }
  
  public static OutputStream getImageOutputStream(Context paramContext, String paramString)
  {
    AppMethodBeat.i(243754);
    paramContext = getOutputStream(paramContext, paramString, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    AppMethodBeat.o(243754);
    return paramContext;
  }
  
  private static OutputStream getOutputStream(Context paramContext, String paramString, Uri paramUri)
  {
    Object localObject3 = null;
    AppMethodBeat.i(243766);
    if (Build.VERSION.SDK_INT < 29)
    {
      paramContext = getFileOutputStream(paramString);
      AppMethodBeat.o(243766);
      return paramContext;
    }
    Object localObject1;
    if (MediaStore.Images.Media.EXTERNAL_CONTENT_URI.equals(paramUri)) {
      localObject1 = Environment.DIRECTORY_PICTURES;
    }
    for (;;)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        Log.w("MicroMsg.ScopedStorageUtil", "#getOutputStream unsupported contentUri: ".concat(String.valueOf(paramUri)));
        paramContext = getFileOutputStream(paramString);
        AppMethodBeat.o(243766);
        return paramContext;
        if (MediaStore.Video.Media.EXTERNAL_CONTENT_URI.equals(paramUri))
        {
          localObject1 = Environment.DIRECTORY_PICTURES;
          continue;
        }
        if (MediaStore.Downloads.EXTERNAL_CONTENT_URI.equals(paramUri)) {
          localObject1 = Environment.DIRECTORY_DOWNLOADS;
        }
      }
      else
      {
        Object localObject4 = MimeTypeUtil.getMimeTypeByFilePath(paramString);
        String str = y.bEq(paramString) + "." + y.alV(paramString);
        Object localObject2 = localObject4;
        if (TextUtils.isEmpty((CharSequence)localObject4))
        {
          Log.w("MicroMsg.ScopedStorageUtil", "#getOutputStream unsupported media type, path = ".concat(String.valueOf(paramString)));
          localObject2 = "application/octet-stream";
        }
        int i;
        int j;
        if (paramString.contains((CharSequence)localObject1))
        {
          i = paramString.indexOf((String)localObject1) + ((String)localObject1).length();
          j = paramString.lastIndexOf(File.separator);
          if (i >= j) {}
        }
        for (localObject1 = (String)localObject1 + paramString.substring(i, j);; localObject1 = null)
        {
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            Log.w("MicroMsg.ScopedStorageUtil", "#getOutputStream can not figure out relative_path, path = ".concat(String.valueOf(paramString)));
            paramContext = getFileOutputStream(paramString);
            AppMethodBeat.o(243766);
            return paramContext;
          }
          localObject4 = new ContentValues();
          ((ContentValues)localObject4).put("mime_type", (String)localObject2);
          ((ContentValues)localObject4).put("_display_name", str);
          ((ContentValues)localObject4).put("relative_path", (String)localObject1);
          localObject1 = paramContext.getContentResolver();
          paramContext = localObject3;
          try
          {
            paramUri = ((ContentResolver)localObject1).insert(paramUri, (ContentValues)localObject4);
            if (paramUri == null)
            {
              paramContext = paramUri;
              Log.w("MicroMsg.ScopedStorageUtil", "#saveWithMediaStore create target media uri fail, path = ".concat(String.valueOf(paramString)));
              paramContext = paramUri;
              paramUri = getFileOutputStream(paramString);
              AppMethodBeat.o(243766);
              return paramUri;
            }
            paramContext = paramUri;
            localObject2 = ((ContentResolver)localObject1).openOutputStream(paramUri);
            if (localObject2 == null)
            {
              paramContext = paramUri;
              paramUri = getFileOutputStream(paramString);
              AppMethodBeat.o(243766);
              return paramUri;
            }
            AppMethodBeat.o(243766);
            return localObject2;
          }
          finally
          {
            if (paramContext == null) {}
          }
          try
          {
            ((ContentResolver)localObject1).delete(paramContext, null, null);
            label417:
            Log.printErrStackTrace("MicroMsg.ScopedStorageUtil", paramUri, "MediaStore save fail", new Object[0]);
            paramContext = getFileOutputStream(paramString);
            AppMethodBeat.o(243766);
            return paramContext;
          }
          finally
          {
            break label417;
          }
        }
      }
      localObject1 = null;
    }
  }
  
  public static Uri imagePathToUri(Context paramContext, String paramString)
  {
    AppMethodBeat.i(243821);
    paramContext = pathToUri(paramContext, paramString, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    AppMethodBeat.o(243821);
    return paramContext;
  }
  
  private static boolean isDownloadsDocument(Uri paramUri)
  {
    AppMethodBeat.i(243808);
    boolean bool = "com.android.providers.downloads.documents".equals(paramUri.getAuthority());
    AppMethodBeat.o(243808);
    return bool;
  }
  
  private static boolean isExternalStorageDocument(Uri paramUri)
  {
    AppMethodBeat.i(243805);
    boolean bool = "com.android.externalstorage.documents".equals(paramUri.getAuthority());
    AppMethodBeat.o(243805);
    return bool;
  }
  
  private static boolean isGooglePhotosUri(Uri paramUri)
  {
    AppMethodBeat.i(243817);
    boolean bool = "com.google.android.apps.photos.content".equals(paramUri.getAuthority());
    AppMethodBeat.o(243817);
    return bool;
  }
  
  private static boolean isMediaDocument(Uri paramUri)
  {
    AppMethodBeat.i(243812);
    boolean bool = "com.android.providers.media.documents".equals(paramUri.getAuthority());
    AppMethodBeat.o(243812);
    return bool;
  }
  
  /* Error */
  private static Uri pathToUri(Context paramContext, String paramString, Uri paramUri)
  {
    // Byte code:
    //   0: ldc 238
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +7 -> 16
    //   12: aload_2
    //   13: ifnonnull +10 -> 23
    //   16: ldc 238
    //   18: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: getstatic 64	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   26: aload_2
    //   27: invokevirtual 83	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   30: ifne +66 -> 96
    //   33: getstatic 118	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   36: aload_2
    //   37: invokevirtual 83	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   40: ifne +56 -> 96
    //   43: getstatic 27	android/provider/MediaStore$Audio$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   46: aload_2
    //   47: invokevirtual 83	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   50: ifne +46 -> 96
    //   53: getstatic 39	android/provider/MediaStore$Downloads:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   56: aload_2
    //   57: invokevirtual 83	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   60: ifne +36 -> 96
    //   63: ldc 43
    //   65: invokestatic 49	android/provider/MediaStore$Files:getContentUri	(Ljava/lang/String;)Landroid/net/Uri;
    //   68: aload_2
    //   69: invokevirtual 83	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   72: ifne +24 -> 96
    //   75: ldc 97
    //   77: ldc 240
    //   79: aload_2
    //   80: invokestatic 105	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   83: invokevirtual 109	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   86: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: ldc 238
    //   91: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aconst_null
    //   95: areturn
    //   96: aload_0
    //   97: invokevirtual 192	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   100: aload_2
    //   101: iconst_1
    //   102: anewarray 101	java/lang/String
    //   105: dup
    //   106: iconst_0
    //   107: ldc 242
    //   109: aastore
    //   110: ldc 244
    //   112: iconst_1
    //   113: anewarray 101	java/lang/String
    //   116: dup
    //   117: iconst_0
    //   118: aload_1
    //   119: aastore
    //   120: aconst_null
    //   121: invokevirtual 248	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   124: astore_0
    //   125: aload_0
    //   126: ifnull +51 -> 177
    //   129: aload_0
    //   130: invokeinterface 254 1 0
    //   135: ifeq +42 -> 177
    //   138: aload_2
    //   139: aload_0
    //   140: aload_0
    //   141: ldc 242
    //   143: invokeinterface 257 2 0
    //   148: invokeinterface 261 2 0
    //   153: invokestatic 264	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   156: invokestatic 268	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   159: astore_1
    //   160: aload_0
    //   161: ifnull +9 -> 170
    //   164: aload_0
    //   165: invokeinterface 271 1 0
    //   170: ldc 238
    //   172: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: aload_1
    //   176: areturn
    //   177: aload_0
    //   178: ifnull +9 -> 187
    //   181: aload_0
    //   182: invokeinterface 271 1 0
    //   187: ldc 238
    //   189: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_1
    //   195: aload_0
    //   196: ifnull +9 -> 205
    //   199: aload_0
    //   200: invokeinterface 271 1 0
    //   205: ldc 238
    //   207: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: aload_1
    //   211: athrow
    //   212: astore_0
    //   213: ldc 97
    //   215: aload_0
    //   216: ldc_w 273
    //   219: iconst_0
    //   220: anewarray 4	java/lang/Object
    //   223: invokestatic 214	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   226: goto -39 -> 187
    //   229: astore_0
    //   230: aload_1
    //   231: aload_0
    //   232: invokevirtual 279	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   235: goto -30 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	238	0	paramContext	Context
    //   0	238	1	paramString	String
    //   0	238	2	paramUri	Uri
    // Exception table:
    //   from	to	target	type
    //   129	160	194	finally
    //   96	125	212	finally
    //   164	170	212	finally
    //   181	187	212	finally
    //   205	212	212	finally
    //   230	235	212	finally
    //   199	205	229	finally
  }
  
  public static Uri saveDownloads(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(243781);
    paramContext = saveWithMediaStore(paramContext, paramString1, paramString2, MediaStore.Downloads.EXTERNAL_CONTENT_URI);
    AppMethodBeat.o(243781);
    return paramContext;
  }
  
  public static OutputStream saveDownloadsOutputStream(Context paramContext, String paramString)
  {
    AppMethodBeat.i(243759);
    paramContext = getOutputStream(paramContext, paramString, MediaStore.Downloads.EXTERNAL_CONTENT_URI);
    AppMethodBeat.o(243759);
    return paramContext;
  }
  
  public static Uri saveImage(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(243774);
    paramContext = saveWithMediaStore(paramContext, paramString1, paramString2, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    AppMethodBeat.o(243774);
    return paramContext;
  }
  
  public static Uri saveVideo(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(243777);
    paramContext = saveWithMediaStore(paramContext, paramString1, paramString2, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
    AppMethodBeat.o(243777);
    return paramContext;
  }
  
  public static OutputStream saveVideoOutputStream(Context paramContext, String paramString)
  {
    AppMethodBeat.i(243756);
    paramContext = getOutputStream(paramContext, paramString, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
    AppMethodBeat.o(243756);
    return paramContext;
  }
  
  /* Error */
  private static Uri saveWithMediaStore(Context paramContext, String paramString1, String paramString2, Uri paramUri)
  {
    // Byte code:
    //   0: ldc_w 295
    //   3: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 299	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   10: ifne +26 -> 36
    //   13: ldc 97
    //   15: ldc_w 301
    //   18: aload_1
    //   19: invokestatic 105	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   22: invokevirtual 109	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   25: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: ldc_w 295
    //   31: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aconst_null
    //   35: areturn
    //   36: getstatic 64	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   39: aload_3
    //   40: invokevirtual 83	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   43: ifeq +39 -> 82
    //   46: getstatic 89	android/os/Environment:DIRECTORY_PICTURES	Ljava/lang/String;
    //   49: astore 6
    //   51: aload 6
    //   53: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifeq +62 -> 118
    //   59: ldc 97
    //   61: ldc_w 303
    //   64: aload_3
    //   65: invokestatic 105	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   68: invokevirtual 109	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   71: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: ldc_w 295
    //   77: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aconst_null
    //   81: areturn
    //   82: getstatic 118	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   85: aload_3
    //   86: invokevirtual 83	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   89: ifeq +11 -> 100
    //   92: getstatic 89	android/os/Environment:DIRECTORY_PICTURES	Ljava/lang/String;
    //   95: astore 6
    //   97: goto -46 -> 51
    //   100: getstatic 39	android/provider/MediaStore$Downloads:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   103: aload_3
    //   104: invokevirtual 83	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   107: ifeq +398 -> 505
    //   110: getstatic 121	android/os/Environment:DIRECTORY_DOWNLOADS	Ljava/lang/String;
    //   113: astore 6
    //   115: goto -64 -> 51
    //   118: aload_2
    //   119: invokestatic 126	com/tencent/mm/sdk/system/MimeTypeUtil:getMimeTypeByFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   122: astore 8
    //   124: new 128	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   131: aload_2
    //   132: invokestatic 132	com/tencent/mm/vfs/y:bEq	(Ljava/lang/String;)Ljava/lang/String;
    //   135: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc 138
    //   140: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_2
    //   144: invokestatic 141	com/tencent/mm/vfs/y:alV	(Ljava/lang/String;)Ljava/lang/String;
    //   147: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: astore 9
    //   155: aload 8
    //   157: astore 7
    //   159: aload 8
    //   161: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   164: ifeq +22 -> 186
    //   167: ldc 97
    //   169: ldc_w 305
    //   172: aload_1
    //   173: invokestatic 105	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   176: invokevirtual 109	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   179: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: ldc 149
    //   184: astore 7
    //   186: aload_2
    //   187: aload 6
    //   189: invokevirtual 152	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   192: ifeq +307 -> 499
    //   195: aload_2
    //   196: aload 6
    //   198: invokevirtual 156	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   201: aload 6
    //   203: invokevirtual 160	java/lang/String:length	()I
    //   206: iadd
    //   207: istore 4
    //   209: aload_2
    //   210: getstatic 165	java/io/File:separator	Ljava/lang/String;
    //   213: invokevirtual 168	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   216: istore 5
    //   218: iload 4
    //   220: iload 5
    //   222: if_icmpge +277 -> 499
    //   225: new 128	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   232: aload 6
    //   234: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_2
    //   238: iload 4
    //   240: iload 5
    //   242: invokevirtual 172	java/lang/String:substring	(II)Ljava/lang/String;
    //   245: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: astore 6
    //   253: aload 6
    //   255: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   258: ifeq +26 -> 284
    //   261: ldc 97
    //   263: ldc_w 307
    //   266: aload_1
    //   267: invokestatic 105	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   270: invokevirtual 109	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   273: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: ldc_w 295
    //   279: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: aconst_null
    //   283: areturn
    //   284: new 176	android/content/ContentValues
    //   287: dup
    //   288: invokespecial 177	android/content/ContentValues:<init>	()V
    //   291: astore 8
    //   293: aload 8
    //   295: ldc 179
    //   297: aload 7
    //   299: invokevirtual 182	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   302: aload 8
    //   304: ldc 184
    //   306: aload 9
    //   308: invokevirtual 182	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: aload 8
    //   313: ldc 186
    //   315: aload 6
    //   317: invokevirtual 182	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: aload_0
    //   321: invokevirtual 192	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   324: astore 6
    //   326: aload 6
    //   328: aload_3
    //   329: aload 8
    //   331: invokevirtual 198	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   334: astore_0
    //   335: aload_0
    //   336: ifnonnull +25 -> 361
    //   339: ldc 97
    //   341: ldc 200
    //   343: aload_2
    //   344: invokestatic 105	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   347: invokevirtual 109	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   350: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   353: ldc_w 295
    //   356: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   359: aconst_null
    //   360: areturn
    //   361: aload 6
    //   363: aload_0
    //   364: invokevirtual 204	android/content/ContentResolver:openOutputStream	(Landroid/net/Uri;)Ljava/io/OutputStream;
    //   367: astore_2
    //   368: new 309	com/tencent/mm/vfs/x
    //   371: dup
    //   372: aload_1
    //   373: invokespecial 312	com/tencent/mm/vfs/x:<init>	(Ljava/lang/String;)V
    //   376: astore_3
    //   377: aload_3
    //   378: aload_2
    //   379: invokestatic 318	com/tencent/g/c/f:f	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   382: pop2
    //   383: aload_3
    //   384: invokevirtual 321	java/io/InputStream:close	()V
    //   387: aload_2
    //   388: ifnull +7 -> 395
    //   391: aload_2
    //   392: invokevirtual 324	java/io/OutputStream:close	()V
    //   395: ldc_w 295
    //   398: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   401: aload_0
    //   402: areturn
    //   403: astore_1
    //   404: aload_3
    //   405: invokevirtual 321	java/io/InputStream:close	()V
    //   408: ldc_w 295
    //   411: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   414: aload_1
    //   415: athrow
    //   416: astore_1
    //   417: aload_2
    //   418: ifnull +7 -> 425
    //   421: aload_2
    //   422: invokevirtual 324	java/io/OutputStream:close	()V
    //   425: ldc_w 295
    //   428: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   431: aload_1
    //   432: athrow
    //   433: astore_2
    //   434: aload_0
    //   435: astore_1
    //   436: aload_2
    //   437: astore_0
    //   438: aload_1
    //   439: ifnull +12 -> 451
    //   442: aload 6
    //   444: aload_1
    //   445: aconst_null
    //   446: aconst_null
    //   447: invokevirtual 208	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   450: pop
    //   451: ldc 97
    //   453: aload_0
    //   454: ldc 210
    //   456: iconst_0
    //   457: anewarray 4	java/lang/Object
    //   460: invokestatic 214	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   463: ldc_w 295
    //   466: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   469: aconst_null
    //   470: areturn
    //   471: astore_3
    //   472: aload_1
    //   473: aload_3
    //   474: invokevirtual 279	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   477: goto -69 -> 408
    //   480: astore_2
    //   481: aload_1
    //   482: aload_2
    //   483: invokevirtual 279	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   486: goto -61 -> 425
    //   489: astore_1
    //   490: goto -39 -> 451
    //   493: astore_0
    //   494: aconst_null
    //   495: astore_1
    //   496: goto -58 -> 438
    //   499: aconst_null
    //   500: astore 6
    //   502: goto -249 -> 253
    //   505: aconst_null
    //   506: astore 6
    //   508: goto -457 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	paramContext	Context
    //   0	511	1	paramString1	String
    //   0	511	2	paramString2	String
    //   0	511	3	paramUri	Uri
    //   207	32	4	i	int
    //   216	25	5	j	int
    //   49	458	6	localObject1	Object
    //   157	141	7	localObject2	Object
    //   122	208	8	localObject3	Object
    //   153	154	9	str	String
    // Exception table:
    //   from	to	target	type
    //   377	383	403	finally
    //   368	377	416	finally
    //   383	387	416	finally
    //   408	416	416	finally
    //   472	477	416	finally
    //   339	353	433	finally
    //   361	368	433	finally
    //   391	395	433	finally
    //   425	433	433	finally
    //   481	486	433	finally
    //   404	408	471	finally
    //   421	425	480	finally
    //   442	451	489	finally
    //   326	335	493	finally
  }
  
  /* Error */
  public static String uriToPath(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: ldc_w 327
    //   3: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 331	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   10: aload_1
    //   11: invokestatic 337	android/provider/DocumentsContract:isDocumentUri	(Landroid/content/Context;Landroid/net/Uri;)Z
    //   14: ifeq +394 -> 408
    //   17: aload_1
    //   18: invokestatic 339	com/tencent/mm/sdk/platformtools/ScopedStorageUtil$MediaStoreOps:isExternalStorageDocument	(Landroid/net/Uri;)Z
    //   21: ifeq +51 -> 72
    //   24: aload_1
    //   25: invokestatic 343	android/provider/DocumentsContract:getDocumentId	(Landroid/net/Uri;)Ljava/lang/String;
    //   28: ldc_w 345
    //   31: invokevirtual 349	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   34: astore_0
    //   35: new 128	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   42: invokestatic 353	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   45: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   48: ldc_w 358
    //   51: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_0
    //   55: iconst_1
    //   56: aaload
    //   57: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore_0
    //   64: ldc_w 327
    //   67: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload_0
    //   71: areturn
    //   72: aload_1
    //   73: invokestatic 360	com/tencent/mm/sdk/platformtools/ScopedStorageUtil$MediaStoreOps:isDownloadsDocument	(Landroid/net/Uri;)Z
    //   76: ifeq +60 -> 136
    //   79: aload_1
    //   80: invokestatic 343	android/provider/DocumentsContract:getDocumentId	(Landroid/net/Uri;)Ljava/lang/String;
    //   83: astore_1
    //   84: ldc_w 362
    //   87: invokestatic 365	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   90: aload_1
    //   91: invokestatic 371	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   94: invokestatic 377	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   97: astore_1
    //   98: aconst_null
    //   99: astore 4
    //   101: aconst_null
    //   102: astore_3
    //   103: ldc_w 379
    //   106: aload_1
    //   107: invokevirtual 382	android/net/Uri:getScheme	()Ljava/lang/String;
    //   110: invokevirtual 385	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   113: ifeq +269 -> 382
    //   116: aload_1
    //   117: invokestatic 387	com/tencent/mm/sdk/platformtools/ScopedStorageUtil$MediaStoreOps:isGooglePhotosUri	(Landroid/net/Uri;)Z
    //   120: ifeq +109 -> 229
    //   123: aload_1
    //   124: invokevirtual 390	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   127: astore_0
    //   128: ldc_w 327
    //   131: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_0
    //   135: areturn
    //   136: aload_1
    //   137: invokestatic 392	com/tencent/mm/sdk/platformtools/ScopedStorageUtil$MediaStoreOps:isMediaDocument	(Landroid/net/Uri;)Z
    //   140: ifeq +268 -> 408
    //   143: aload_1
    //   144: invokestatic 343	android/provider/DocumentsContract:getDocumentId	(Landroid/net/Uri;)Ljava/lang/String;
    //   147: ldc_w 345
    //   150: invokevirtual 349	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   153: astore 5
    //   155: aload 5
    //   157: iconst_0
    //   158: aaload
    //   159: astore_3
    //   160: ldc_w 394
    //   163: aload_3
    //   164: invokevirtual 225	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   167: ifeq +28 -> 195
    //   170: getstatic 64	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   173: astore_1
    //   174: ldc_w 396
    //   177: astore_3
    //   178: iconst_1
    //   179: anewarray 101	java/lang/String
    //   182: astore 4
    //   184: aload 4
    //   186: iconst_0
    //   187: aload 5
    //   189: iconst_1
    //   190: aaload
    //   191: aastore
    //   192: goto -89 -> 103
    //   195: ldc_w 398
    //   198: aload_3
    //   199: invokevirtual 225	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   202: ifeq +10 -> 212
    //   205: getstatic 118	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   208: astore_1
    //   209: goto -35 -> 174
    //   212: ldc_w 400
    //   215: aload_3
    //   216: invokevirtual 225	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   219: ifeq -45 -> 174
    //   222: getstatic 27	android/provider/MediaStore$Audio$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   225: astore_1
    //   226: goto -52 -> 174
    //   229: aload_0
    //   230: invokevirtual 192	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   233: aload_1
    //   234: iconst_1
    //   235: anewarray 101	java/lang/String
    //   238: dup
    //   239: iconst_0
    //   240: ldc_w 402
    //   243: aastore
    //   244: aload_3
    //   245: aload 4
    //   247: aconst_null
    //   248: invokevirtual 248	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   251: astore_0
    //   252: aload_0
    //   253: ifnonnull +21 -> 274
    //   256: aload_0
    //   257: ifnull +9 -> 266
    //   260: aload_0
    //   261: invokeinterface 271 1 0
    //   266: ldc_w 327
    //   269: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: aconst_null
    //   273: areturn
    //   274: aload_0
    //   275: ldc_w 402
    //   278: invokeinterface 257 2 0
    //   283: istore_2
    //   284: aload_0
    //   285: invokeinterface 254 1 0
    //   290: ifeq +29 -> 319
    //   293: aload_0
    //   294: iload_2
    //   295: invokeinterface 405 2 0
    //   300: astore_1
    //   301: aload_0
    //   302: ifnull +9 -> 311
    //   305: aload_0
    //   306: invokeinterface 271 1 0
    //   311: ldc_w 327
    //   314: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   317: aload_1
    //   318: areturn
    //   319: aload_0
    //   320: ifnull +9 -> 329
    //   323: aload_0
    //   324: invokeinterface 271 1 0
    //   329: ldc_w 327
    //   332: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   335: aconst_null
    //   336: areturn
    //   337: astore_1
    //   338: aload_0
    //   339: ifnull +9 -> 348
    //   342: aload_0
    //   343: invokeinterface 271 1 0
    //   348: ldc_w 327
    //   351: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   354: aload_1
    //   355: athrow
    //   356: astore_0
    //   357: ldc 97
    //   359: aload_0
    //   360: ldc_w 407
    //   363: iconst_0
    //   364: anewarray 4	java/lang/Object
    //   367: invokestatic 214	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   370: goto -41 -> 329
    //   373: astore_0
    //   374: aload_1
    //   375: aload_0
    //   376: invokevirtual 279	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   379: goto -31 -> 348
    //   382: ldc_w 409
    //   385: aload_1
    //   386: invokevirtual 382	android/net/Uri:getScheme	()Ljava/lang/String;
    //   389: invokevirtual 385	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   392: ifeq -63 -> 329
    //   395: aload_1
    //   396: invokevirtual 412	android/net/Uri:getPath	()Ljava/lang/String;
    //   399: astore_0
    //   400: ldc_w 327
    //   403: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   406: aload_0
    //   407: areturn
    //   408: aconst_null
    //   409: astore 4
    //   411: aconst_null
    //   412: astore_3
    //   413: goto -310 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	paramContext	Context
    //   0	416	1	paramUri	Uri
    //   283	12	2	i	int
    //   102	311	3	localObject	Object
    //   99	311	4	arrayOfString1	String[]
    //   153	35	5	arrayOfString2	String[]
    // Exception table:
    //   from	to	target	type
    //   274	301	337	finally
    //   6	64	356	finally
    //   72	98	356	finally
    //   103	128	356	finally
    //   136	155	356	finally
    //   160	174	356	finally
    //   178	184	356	finally
    //   195	209	356	finally
    //   212	226	356	finally
    //   229	252	356	finally
    //   260	266	356	finally
    //   305	311	356	finally
    //   323	329	356	finally
    //   348	356	356	finally
    //   374	379	356	finally
    //   382	400	356	finally
    //   342	348	373	finally
  }
  
  public static Uri videoOrImagePathToUri(Context paramContext, String paramString)
  {
    AppMethodBeat.i(243830);
    Uri localUri2 = videoPathToUri(paramContext, paramString);
    Uri localUri1 = localUri2;
    if (localUri2 == null) {
      localUri1 = imagePathToUri(paramContext, paramString);
    }
    AppMethodBeat.o(243830);
    return localUri1;
  }
  
  public static Uri videoPathToUri(Context paramContext, String paramString)
  {
    AppMethodBeat.i(243826);
    paramContext = pathToUri(paramContext, paramString, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
    AppMethodBeat.o(243826);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ScopedStorageUtil.MediaStoreOps
 * JD-Core Version:    0.7.0.1
 */