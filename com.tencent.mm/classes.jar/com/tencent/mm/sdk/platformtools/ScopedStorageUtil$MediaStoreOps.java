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
import com.tencent.mm.vfs.u;
import java.io.File;
import java.io.OutputStream;

public final class ScopedStorageUtil$MediaStoreOps
{
  public static Uri audioPathToUri(Context paramContext, String paramString)
  {
    AppMethodBeat.i(261682);
    paramContext = pathToUri(paramContext, paramString, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
    AppMethodBeat.o(261682);
    return paramContext;
  }
  
  public static Uri downloadPathToUri(Context paramContext, String paramString)
  {
    AppMethodBeat.i(261683);
    paramContext = pathToUri(paramContext, paramString, MediaStore.Downloads.EXTERNAL_CONTENT_URI);
    AppMethodBeat.o(261683);
    return paramContext;
  }
  
  public static Uri filePathToUri(Context paramContext, String paramString)
  {
    AppMethodBeat.i(261684);
    paramContext = pathToUri(paramContext, paramString, MediaStore.Files.getContentUri("external"));
    AppMethodBeat.o(261684);
    return paramContext;
  }
  
  private static OutputStream getFileOutputStream(String paramString)
  {
    AppMethodBeat.i(261655);
    paramString = u.Te(paramString);
    AppMethodBeat.o(261655);
    return paramString;
  }
  
  public static OutputStream getImageOutputStream(Context paramContext, String paramString)
  {
    AppMethodBeat.i(261644);
    paramContext = getOutputStream(paramContext, paramString, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    AppMethodBeat.o(261644);
    return paramContext;
  }
  
  private static OutputStream getOutputStream(Context paramContext, String paramString, Uri paramUri)
  {
    Object localObject3 = null;
    AppMethodBeat.i(261654);
    if (Build.VERSION.SDK_INT < 29)
    {
      paramContext = getFileOutputStream(paramString);
      AppMethodBeat.o(261654);
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
        AppMethodBeat.o(261654);
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
        String str = u.bBW(paramString) + "." + u.asq(paramString);
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
            AppMethodBeat.o(261654);
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
              AppMethodBeat.o(261654);
              return paramUri;
            }
            paramContext = paramUri;
            localObject2 = ((ContentResolver)localObject1).openOutputStream(paramUri);
            if (localObject2 == null)
            {
              paramContext = paramUri;
              paramUri = getFileOutputStream(paramString);
              AppMethodBeat.o(261654);
              return paramUri;
            }
            AppMethodBeat.o(261654);
            return localObject2;
          }
          catch (Throwable paramUri)
          {
            if (paramContext == null) {}
          }
          try
          {
            ((ContentResolver)localObject1).delete(paramContext, null, null);
            label417:
            Log.printErrStackTrace("MicroMsg.ScopedStorageUtil", paramUri, "MediaStore save fail", new Object[0]);
            paramContext = getFileOutputStream(paramString);
            AppMethodBeat.o(261654);
            return paramContext;
          }
          catch (Throwable paramContext)
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
    AppMethodBeat.i(261677);
    paramContext = pathToUri(paramContext, paramString, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    AppMethodBeat.o(261677);
    return paramContext;
  }
  
  private static boolean isDownloadsDocument(Uri paramUri)
  {
    AppMethodBeat.i(261671);
    boolean bool = "com.android.providers.downloads.documents".equals(paramUri.getAuthority());
    AppMethodBeat.o(261671);
    return bool;
  }
  
  private static boolean isExternalStorageDocument(Uri paramUri)
  {
    AppMethodBeat.i(261669);
    boolean bool = "com.android.externalstorage.documents".equals(paramUri.getAuthority());
    AppMethodBeat.o(261669);
    return bool;
  }
  
  private static boolean isGooglePhotosUri(Uri paramUri)
  {
    AppMethodBeat.i(261675);
    boolean bool = "com.google.android.apps.photos.content".equals(paramUri.getAuthority());
    AppMethodBeat.o(261675);
    return bool;
  }
  
  private static boolean isMediaDocument(Uri paramUri)
  {
    AppMethodBeat.i(261673);
    boolean bool = "com.android.providers.media.documents".equals(paramUri.getAuthority());
    AppMethodBeat.o(261673);
    return bool;
  }
  
  /* Error */
  private static Uri pathToUri(Context paramContext, String paramString, Uri paramUri)
  {
    // Byte code:
    //   0: ldc 239
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +7 -> 16
    //   12: aload_2
    //   13: ifnonnull +10 -> 23
    //   16: ldc 239
    //   18: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aconst_null
    //   22: areturn
    //   23: getstatic 63	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   26: aload_2
    //   27: invokevirtual 84	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   30: ifne +66 -> 96
    //   33: getstatic 119	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   36: aload_2
    //   37: invokevirtual 84	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   40: ifne +56 -> 96
    //   43: getstatic 27	android/provider/MediaStore$Audio$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   46: aload_2
    //   47: invokevirtual 84	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   50: ifne +46 -> 96
    //   53: getstatic 39	android/provider/MediaStore$Downloads:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   56: aload_2
    //   57: invokevirtual 84	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   60: ifne +36 -> 96
    //   63: ldc 43
    //   65: invokestatic 49	android/provider/MediaStore$Files:getContentUri	(Ljava/lang/String;)Landroid/net/Uri;
    //   68: aload_2
    //   69: invokevirtual 84	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   72: ifne +24 -> 96
    //   75: ldc 98
    //   77: ldc 241
    //   79: aload_2
    //   80: invokestatic 106	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   83: invokevirtual 110	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   86: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: ldc 239
    //   91: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: aconst_null
    //   95: areturn
    //   96: aload_0
    //   97: invokevirtual 193	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   100: aload_2
    //   101: iconst_1
    //   102: anewarray 102	java/lang/String
    //   105: dup
    //   106: iconst_0
    //   107: ldc 243
    //   109: aastore
    //   110: ldc 245
    //   112: iconst_1
    //   113: anewarray 102	java/lang/String
    //   116: dup
    //   117: iconst_0
    //   118: aload_1
    //   119: aastore
    //   120: aconst_null
    //   121: invokevirtual 249	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   124: astore_3
    //   125: aload_3
    //   126: ifnull +51 -> 177
    //   129: aload_3
    //   130: invokeinterface 255 1 0
    //   135: ifeq +42 -> 177
    //   138: aload_2
    //   139: aload_3
    //   140: aload_3
    //   141: ldc 243
    //   143: invokeinterface 258 2 0
    //   148: invokeinterface 262 2 0
    //   153: invokestatic 265	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   156: invokestatic 269	android/net/Uri:withAppendedPath	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   159: astore_0
    //   160: aload_3
    //   161: ifnull +9 -> 170
    //   164: aload_3
    //   165: invokeinterface 272 1 0
    //   170: ldc 239
    //   172: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: aload_0
    //   176: areturn
    //   177: aload_3
    //   178: ifnull +9 -> 187
    //   181: aload_3
    //   182: invokeinterface 272 1 0
    //   187: ldc 239
    //   189: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aconst_null
    //   193: areturn
    //   194: astore_1
    //   195: ldc 239
    //   197: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: aload_1
    //   201: athrow
    //   202: astore_0
    //   203: aload_3
    //   204: ifnull +13 -> 217
    //   207: aload_1
    //   208: ifnull +42 -> 250
    //   211: aload_3
    //   212: invokeinterface 272 1 0
    //   217: ldc 239
    //   219: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   222: aload_0
    //   223: athrow
    //   224: astore_0
    //   225: ldc 98
    //   227: aload_0
    //   228: ldc_w 274
    //   231: iconst_0
    //   232: anewarray 4	java/lang/Object
    //   235: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   238: goto -51 -> 187
    //   241: astore_2
    //   242: aload_1
    //   243: aload_2
    //   244: invokevirtual 278	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   247: goto -30 -> 217
    //   250: aload_3
    //   251: invokeinterface 272 1 0
    //   256: goto -39 -> 217
    //   259: astore_0
    //   260: aconst_null
    //   261: astore_1
    //   262: goto -59 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	paramContext	Context
    //   0	265	1	paramString	String
    //   0	265	2	paramUri	Uri
    //   124	127	3	localCursor	android.database.Cursor
    // Exception table:
    //   from	to	target	type
    //   129	160	194	java/lang/Throwable
    //   195	202	202	finally
    //   96	125	224	java/lang/Throwable
    //   164	170	224	java/lang/Throwable
    //   181	187	224	java/lang/Throwable
    //   217	224	224	java/lang/Throwable
    //   242	247	224	java/lang/Throwable
    //   250	256	224	java/lang/Throwable
    //   211	217	241	java/lang/Throwable
    //   129	160	259	finally
  }
  
  public static Uri saveDownloads(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(261660);
    paramContext = saveWithMediaStore(paramContext, paramString1, paramString2, MediaStore.Downloads.EXTERNAL_CONTENT_URI);
    AppMethodBeat.o(261660);
    return paramContext;
  }
  
  public static OutputStream saveDownloadsOutputStream(Context paramContext, String paramString)
  {
    AppMethodBeat.i(261650);
    paramContext = getOutputStream(paramContext, paramString, MediaStore.Downloads.EXTERNAL_CONTENT_URI);
    AppMethodBeat.o(261650);
    return paramContext;
  }
  
  public static Uri saveImage(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(261657);
    paramContext = saveWithMediaStore(paramContext, paramString1, paramString2, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
    AppMethodBeat.o(261657);
    return paramContext;
  }
  
  public static Uri saveVideo(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(261658);
    paramContext = saveWithMediaStore(paramContext, paramString1, paramString2, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
    AppMethodBeat.o(261658);
    return paramContext;
  }
  
  public static OutputStream saveVideoOutputStream(Context paramContext, String paramString)
  {
    AppMethodBeat.i(261647);
    paramContext = getOutputStream(paramContext, paramString, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
    AppMethodBeat.o(261647);
    return paramContext;
  }
  
  /* Error */
  private static Uri saveWithMediaStore(Context paramContext, String paramString1, String paramString2, Uri paramUri)
  {
    // Byte code:
    //   0: ldc_w 294
    //   3: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 298	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   10: ifne +26 -> 36
    //   13: ldc 98
    //   15: ldc_w 300
    //   18: aload_1
    //   19: invokestatic 106	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   22: invokevirtual 110	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   25: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: ldc_w 294
    //   31: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aconst_null
    //   35: areturn
    //   36: getstatic 63	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   39: aload_3
    //   40: invokevirtual 84	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   43: ifeq +39 -> 82
    //   46: getstatic 90	android/os/Environment:DIRECTORY_PICTURES	Ljava/lang/String;
    //   49: astore 6
    //   51: aload 6
    //   53: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifeq +62 -> 118
    //   59: ldc 98
    //   61: ldc_w 302
    //   64: aload_3
    //   65: invokestatic 106	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   68: invokevirtual 110	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   71: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: ldc_w 294
    //   77: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aconst_null
    //   81: areturn
    //   82: getstatic 119	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   85: aload_3
    //   86: invokevirtual 84	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   89: ifeq +11 -> 100
    //   92: getstatic 90	android/os/Environment:DIRECTORY_PICTURES	Ljava/lang/String;
    //   95: astore 6
    //   97: goto -46 -> 51
    //   100: getstatic 39	android/provider/MediaStore$Downloads:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   103: aload_3
    //   104: invokevirtual 84	android/net/Uri:equals	(Ljava/lang/Object;)Z
    //   107: ifeq +449 -> 556
    //   110: getstatic 122	android/os/Environment:DIRECTORY_DOWNLOADS	Ljava/lang/String;
    //   113: astore 6
    //   115: goto -64 -> 51
    //   118: aload_2
    //   119: invokestatic 127	com/tencent/mm/sdk/system/MimeTypeUtil:getMimeTypeByFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   122: astore 8
    //   124: new 129	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   131: aload_2
    //   132: invokestatic 133	com/tencent/mm/vfs/u:bBW	(Ljava/lang/String;)Ljava/lang/String;
    //   135: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc 139
    //   140: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_2
    //   144: invokestatic 142	com/tencent/mm/vfs/u:asq	(Ljava/lang/String;)Ljava/lang/String;
    //   147: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: astore 9
    //   155: aload 8
    //   157: astore 7
    //   159: aload 8
    //   161: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   164: ifeq +22 -> 186
    //   167: ldc 98
    //   169: ldc_w 304
    //   172: aload_1
    //   173: invokestatic 106	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   176: invokevirtual 110	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   179: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: ldc 150
    //   184: astore 7
    //   186: aload_2
    //   187: aload 6
    //   189: invokevirtual 153	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   192: ifeq +358 -> 550
    //   195: aload_2
    //   196: aload 6
    //   198: invokevirtual 157	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   201: aload 6
    //   203: invokevirtual 161	java/lang/String:length	()I
    //   206: iadd
    //   207: istore 4
    //   209: aload_2
    //   210: getstatic 166	java/io/File:separator	Ljava/lang/String;
    //   213: invokevirtual 169	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   216: istore 5
    //   218: iload 4
    //   220: iload 5
    //   222: if_icmpge +328 -> 550
    //   225: new 129	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   232: aload 6
    //   234: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_2
    //   238: iload 4
    //   240: iload 5
    //   242: invokevirtual 173	java/lang/String:substring	(II)Ljava/lang/String;
    //   245: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: astore 6
    //   253: aload 6
    //   255: invokestatic 96	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   258: ifeq +26 -> 284
    //   261: ldc 98
    //   263: ldc_w 306
    //   266: aload_1
    //   267: invokestatic 106	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   270: invokevirtual 110	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   273: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   276: ldc_w 294
    //   279: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   282: aconst_null
    //   283: areturn
    //   284: new 177	android/content/ContentValues
    //   287: dup
    //   288: invokespecial 178	android/content/ContentValues:<init>	()V
    //   291: astore 8
    //   293: aload 8
    //   295: ldc 180
    //   297: aload 7
    //   299: invokevirtual 183	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   302: aload 8
    //   304: ldc 185
    //   306: aload 9
    //   308: invokevirtual 183	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: aload 8
    //   313: ldc 187
    //   315: aload 6
    //   317: invokevirtual 183	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: aload_0
    //   321: invokevirtual 193	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   324: astore 6
    //   326: aload 6
    //   328: aload_3
    //   329: aload 8
    //   331: invokevirtual 199	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   334: astore_3
    //   335: aload_3
    //   336: ifnonnull +25 -> 361
    //   339: ldc 98
    //   341: ldc 201
    //   343: aload_2
    //   344: invokestatic 106	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   347: invokevirtual 110	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   350: invokestatic 116	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   353: ldc_w 294
    //   356: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   359: aconst_null
    //   360: areturn
    //   361: aload 6
    //   363: aload_3
    //   364: invokevirtual 205	android/content/ContentResolver:openOutputStream	(Landroid/net/Uri;)Ljava/io/OutputStream;
    //   367: astore_2
    //   368: new 308	com/tencent/mm/vfs/t
    //   371: dup
    //   372: aload_1
    //   373: invokespecial 311	com/tencent/mm/vfs/t:<init>	(Ljava/lang/String;)V
    //   376: astore 7
    //   378: aload 7
    //   380: aload_2
    //   381: invokestatic 317	com/tencent/g/c/f:d	(Ljava/io/InputStream;Ljava/io/OutputStream;)J
    //   384: pop2
    //   385: aload 7
    //   387: invokevirtual 320	java/io/InputStream:close	()V
    //   390: aload_2
    //   391: ifnull +7 -> 398
    //   394: aload_2
    //   395: invokevirtual 323	java/io/OutputStream:close	()V
    //   398: ldc_w 294
    //   401: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   404: aload_3
    //   405: areturn
    //   406: astore_1
    //   407: ldc_w 294
    //   410: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   413: aload_1
    //   414: athrow
    //   415: astore_0
    //   416: aload_1
    //   417: ifnull +93 -> 510
    //   420: aload 7
    //   422: invokevirtual 320	java/io/InputStream:close	()V
    //   425: ldc_w 294
    //   428: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   431: aload_0
    //   432: athrow
    //   433: astore_1
    //   434: ldc_w 294
    //   437: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   440: aload_1
    //   441: athrow
    //   442: astore_0
    //   443: aload_2
    //   444: ifnull +11 -> 455
    //   447: aload_1
    //   448: ifnull +79 -> 527
    //   451: aload_2
    //   452: invokevirtual 323	java/io/OutputStream:close	()V
    //   455: ldc_w 294
    //   458: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   461: aload_0
    //   462: athrow
    //   463: astore_0
    //   464: aload_3
    //   465: astore_1
    //   466: aload_1
    //   467: ifnull +12 -> 479
    //   470: aload 6
    //   472: aload_1
    //   473: aconst_null
    //   474: aconst_null
    //   475: invokevirtual 209	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   478: pop
    //   479: ldc 98
    //   481: aload_0
    //   482: ldc 211
    //   484: iconst_0
    //   485: anewarray 4	java/lang/Object
    //   488: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   491: ldc_w 294
    //   494: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   497: aconst_null
    //   498: areturn
    //   499: astore 7
    //   501: aload_1
    //   502: aload 7
    //   504: invokevirtual 278	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   507: goto -82 -> 425
    //   510: aload 7
    //   512: invokevirtual 320	java/io/InputStream:close	()V
    //   515: goto -90 -> 425
    //   518: astore_2
    //   519: aload_1
    //   520: aload_2
    //   521: invokevirtual 278	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   524: goto -69 -> 455
    //   527: aload_2
    //   528: invokevirtual 323	java/io/OutputStream:close	()V
    //   531: goto -76 -> 455
    //   534: astore_1
    //   535: goto -56 -> 479
    //   538: astore_0
    //   539: aconst_null
    //   540: astore_1
    //   541: goto -75 -> 466
    //   544: astore_0
    //   545: aconst_null
    //   546: astore_1
    //   547: goto -131 -> 416
    //   550: aconst_null
    //   551: astore 6
    //   553: goto -300 -> 253
    //   556: aconst_null
    //   557: astore 6
    //   559: goto -508 -> 51
    //   562: astore_0
    //   563: aconst_null
    //   564: astore_1
    //   565: goto -122 -> 443
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	568	0	paramContext	Context
    //   0	568	1	paramString1	String
    //   0	568	2	paramString2	String
    //   0	568	3	paramUri	Uri
    //   207	32	4	i	int
    //   216	25	5	j	int
    //   49	509	6	localObject1	Object
    //   157	264	7	localObject2	Object
    //   499	12	7	localThrowable	Throwable
    //   122	208	8	localObject3	Object
    //   153	154	9	str	String
    // Exception table:
    //   from	to	target	type
    //   378	385	406	java/lang/Throwable
    //   407	415	415	finally
    //   368	378	433	java/lang/Throwable
    //   385	390	433	java/lang/Throwable
    //   425	433	433	java/lang/Throwable
    //   501	507	433	java/lang/Throwable
    //   510	515	433	java/lang/Throwable
    //   434	442	442	finally
    //   339	353	463	java/lang/Throwable
    //   361	368	463	java/lang/Throwable
    //   394	398	463	java/lang/Throwable
    //   455	463	463	java/lang/Throwable
    //   519	524	463	java/lang/Throwable
    //   527	531	463	java/lang/Throwable
    //   420	425	499	java/lang/Throwable
    //   451	455	518	java/lang/Throwable
    //   470	479	534	java/lang/Throwable
    //   326	335	538	java/lang/Throwable
    //   378	385	544	finally
    //   368	378	562	finally
    //   385	390	562	finally
    //   420	425	562	finally
    //   425	433	562	finally
    //   501	507	562	finally
    //   510	515	562	finally
  }
  
  /* Error */
  public static String uriToPath(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: ldc_w 326
    //   3: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokevirtual 330	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   10: aload_1
    //   11: invokestatic 336	android/provider/DocumentsContract:isDocumentUri	(Landroid/content/Context;Landroid/net/Uri;)Z
    //   14: ifeq +422 -> 436
    //   17: aload_1
    //   18: invokestatic 338	com/tencent/mm/sdk/platformtools/ScopedStorageUtil$MediaStoreOps:isExternalStorageDocument	(Landroid/net/Uri;)Z
    //   21: ifeq +51 -> 72
    //   24: aload_1
    //   25: invokestatic 342	android/provider/DocumentsContract:getDocumentId	(Landroid/net/Uri;)Ljava/lang/String;
    //   28: ldc_w 344
    //   31: invokevirtual 348	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   34: astore_0
    //   35: new 129	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   42: invokestatic 352	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   45: invokevirtual 355	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   48: ldc_w 357
    //   51: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_0
    //   55: iconst_1
    //   56: aaload
    //   57: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: astore_0
    //   64: ldc_w 326
    //   67: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: aload_0
    //   71: areturn
    //   72: aload_1
    //   73: invokestatic 359	com/tencent/mm/sdk/platformtools/ScopedStorageUtil$MediaStoreOps:isDownloadsDocument	(Landroid/net/Uri;)Z
    //   76: ifeq +60 -> 136
    //   79: aload_1
    //   80: invokestatic 342	android/provider/DocumentsContract:getDocumentId	(Landroid/net/Uri;)Ljava/lang/String;
    //   83: astore_1
    //   84: ldc_w 361
    //   87: invokestatic 364	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   90: aload_1
    //   91: invokestatic 370	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   94: invokestatic 376	android/content/ContentUris:withAppendedId	(Landroid/net/Uri;J)Landroid/net/Uri;
    //   97: astore_1
    //   98: aconst_null
    //   99: astore 4
    //   101: aconst_null
    //   102: astore_3
    //   103: ldc_w 378
    //   106: aload_1
    //   107: invokevirtual 381	android/net/Uri:getScheme	()Ljava/lang/String;
    //   110: invokevirtual 384	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   113: ifeq +291 -> 404
    //   116: aload_1
    //   117: invokestatic 386	com/tencent/mm/sdk/platformtools/ScopedStorageUtil$MediaStoreOps:isGooglePhotosUri	(Landroid/net/Uri;)Z
    //   120: ifeq +109 -> 229
    //   123: aload_1
    //   124: invokevirtual 389	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   127: astore_0
    //   128: ldc_w 326
    //   131: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_0
    //   135: areturn
    //   136: aload_1
    //   137: invokestatic 391	com/tencent/mm/sdk/platformtools/ScopedStorageUtil$MediaStoreOps:isMediaDocument	(Landroid/net/Uri;)Z
    //   140: ifeq +296 -> 436
    //   143: aload_1
    //   144: invokestatic 342	android/provider/DocumentsContract:getDocumentId	(Landroid/net/Uri;)Ljava/lang/String;
    //   147: ldc_w 344
    //   150: invokevirtual 348	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   153: astore 5
    //   155: aload 5
    //   157: iconst_0
    //   158: aaload
    //   159: astore_3
    //   160: ldc_w 393
    //   163: aload_3
    //   164: invokevirtual 226	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   167: ifeq +28 -> 195
    //   170: getstatic 63	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   173: astore_1
    //   174: ldc_w 395
    //   177: astore_3
    //   178: iconst_1
    //   179: anewarray 102	java/lang/String
    //   182: astore 4
    //   184: aload 4
    //   186: iconst_0
    //   187: aload 5
    //   189: iconst_1
    //   190: aaload
    //   191: aastore
    //   192: goto -89 -> 103
    //   195: ldc_w 397
    //   198: aload_3
    //   199: invokevirtual 226	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   202: ifeq +10 -> 212
    //   205: getstatic 119	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   208: astore_1
    //   209: goto -35 -> 174
    //   212: ldc_w 399
    //   215: aload_3
    //   216: invokevirtual 226	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   219: ifeq -45 -> 174
    //   222: getstatic 27	android/provider/MediaStore$Audio$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   225: astore_1
    //   226: goto -52 -> 174
    //   229: aload_0
    //   230: invokevirtual 193	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   233: aload_1
    //   234: iconst_1
    //   235: anewarray 102	java/lang/String
    //   238: dup
    //   239: iconst_0
    //   240: ldc_w 401
    //   243: aastore
    //   244: aload_3
    //   245: aload 4
    //   247: aconst_null
    //   248: invokevirtual 249	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   251: astore_3
    //   252: aload_3
    //   253: ifnonnull +21 -> 274
    //   256: aload_3
    //   257: ifnull +9 -> 266
    //   260: aload_3
    //   261: invokeinterface 272 1 0
    //   266: ldc_w 326
    //   269: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: aconst_null
    //   273: areturn
    //   274: aload_3
    //   275: ldc_w 401
    //   278: invokeinterface 258 2 0
    //   283: istore_2
    //   284: aload_3
    //   285: invokeinterface 255 1 0
    //   290: ifeq +29 -> 319
    //   293: aload_3
    //   294: iload_2
    //   295: invokeinterface 404 2 0
    //   300: astore_0
    //   301: aload_3
    //   302: ifnull +9 -> 311
    //   305: aload_3
    //   306: invokeinterface 272 1 0
    //   311: ldc_w 326
    //   314: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   317: aload_0
    //   318: areturn
    //   319: aload_3
    //   320: ifnull +9 -> 329
    //   323: aload_3
    //   324: invokeinterface 272 1 0
    //   329: ldc_w 326
    //   332: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   335: aconst_null
    //   336: areturn
    //   337: astore_1
    //   338: ldc_w 326
    //   341: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   344: aload_1
    //   345: athrow
    //   346: astore_0
    //   347: aload_3
    //   348: ifnull +13 -> 361
    //   351: aload_1
    //   352: ifnull +43 -> 395
    //   355: aload_3
    //   356: invokeinterface 272 1 0
    //   361: ldc_w 326
    //   364: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   367: aload_0
    //   368: athrow
    //   369: astore_0
    //   370: ldc 98
    //   372: aload_0
    //   373: ldc_w 406
    //   376: iconst_0
    //   377: anewarray 4	java/lang/Object
    //   380: invokestatic 215	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   383: goto -54 -> 329
    //   386: astore_3
    //   387: aload_1
    //   388: aload_3
    //   389: invokevirtual 278	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   392: goto -31 -> 361
    //   395: aload_3
    //   396: invokeinterface 272 1 0
    //   401: goto -40 -> 361
    //   404: ldc_w 408
    //   407: aload_1
    //   408: invokevirtual 381	android/net/Uri:getScheme	()Ljava/lang/String;
    //   411: invokevirtual 384	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   414: ifeq -85 -> 329
    //   417: aload_1
    //   418: invokevirtual 411	android/net/Uri:getPath	()Ljava/lang/String;
    //   421: astore_0
    //   422: ldc_w 326
    //   425: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   428: aload_0
    //   429: areturn
    //   430: astore_0
    //   431: aconst_null
    //   432: astore_1
    //   433: goto -86 -> 347
    //   436: aconst_null
    //   437: astore 4
    //   439: aconst_null
    //   440: astore_3
    //   441: goto -338 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	444	0	paramContext	Context
    //   0	444	1	paramUri	Uri
    //   283	12	2	i	int
    //   102	254	3	localObject1	Object
    //   386	10	3	localThrowable	Throwable
    //   440	1	3	localObject2	Object
    //   99	339	4	arrayOfString1	String[]
    //   153	35	5	arrayOfString2	String[]
    // Exception table:
    //   from	to	target	type
    //   274	301	337	java/lang/Throwable
    //   338	346	346	finally
    //   6	64	369	java/lang/Throwable
    //   72	98	369	java/lang/Throwable
    //   103	128	369	java/lang/Throwable
    //   136	155	369	java/lang/Throwable
    //   160	174	369	java/lang/Throwable
    //   178	184	369	java/lang/Throwable
    //   195	209	369	java/lang/Throwable
    //   212	226	369	java/lang/Throwable
    //   229	252	369	java/lang/Throwable
    //   260	266	369	java/lang/Throwable
    //   305	311	369	java/lang/Throwable
    //   323	329	369	java/lang/Throwable
    //   361	369	369	java/lang/Throwable
    //   387	392	369	java/lang/Throwable
    //   395	401	369	java/lang/Throwable
    //   404	422	369	java/lang/Throwable
    //   355	361	386	java/lang/Throwable
    //   274	301	430	finally
  }
  
  public static Uri videoOrImagePathToUri(Context paramContext, String paramString)
  {
    AppMethodBeat.i(261681);
    Uri localUri2 = videoPathToUri(paramContext, paramString);
    Uri localUri1 = localUri2;
    if (localUri2 == null) {
      localUri1 = imagePathToUri(paramContext, paramString);
    }
    AppMethodBeat.o(261681);
    return localUri1;
  }
  
  public static Uri videoPathToUri(Context paramContext, String paramString)
  {
    AppMethodBeat.i(261680);
    paramContext = pathToUri(paramContext, paramString, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
    AppMethodBeat.o(261680);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ScopedStorageUtil.MediaStoreOps
 * JD-Core Version:    0.7.0.1
 */