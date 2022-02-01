package com.tencent.wework.api.util;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class OpenDataUtils
{
  /* Error */
  public static String an(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 7
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 15	java/io/File
    //   8: dup
    //   9: aload_2
    //   10: invokespecial 19	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: new 21	android/net/Uri$Builder
    //   17: dup
    //   18: invokespecial 24	android/net/Uri$Builder:<init>	()V
    //   21: ldc 26
    //   23: invokevirtual 30	android/net/Uri$Builder:scheme	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   26: new 32	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   33: aload_1
    //   34: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc 39
    //   39: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokevirtual 46	android/net/Uri$Builder:authority	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   48: ldc 48
    //   50: invokevirtual 51	android/net/Uri$Builder:appendPath	(Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   53: ldc 53
    //   55: aload_3
    //   56: invokevirtual 56	java/io/File:getName	()Ljava/lang/String;
    //   59: invokevirtual 60	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   62: ldc 62
    //   64: aload_2
    //   65: invokevirtual 60	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   68: invokevirtual 66	android/net/Uri$Builder:build	()Landroid/net/Uri;
    //   71: astore_1
    //   72: aload_0
    //   73: invokevirtual 72	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   76: aload_1
    //   77: invokevirtual 78	android/content/ContentResolver:openOutputStream	(Landroid/net/Uri;)Ljava/io/OutputStream;
    //   80: astore_1
    //   81: new 80	java/io/FileInputStream
    //   84: dup
    //   85: aload_3
    //   86: invokespecial 83	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: astore_0
    //   90: sipush 1024
    //   93: newarray byte
    //   95: astore_2
    //   96: aload_0
    //   97: aload_2
    //   98: invokevirtual 87	java/io/FileInputStream:read	([B)I
    //   101: ifle +35 -> 136
    //   104: aload_1
    //   105: aload_2
    //   106: invokevirtual 93	java/io/OutputStream:write	([B)V
    //   109: goto -13 -> 96
    //   112: astore_2
    //   113: aload_0
    //   114: ifnull +7 -> 121
    //   117: aload_0
    //   118: invokevirtual 96	java/io/FileInputStream:close	()V
    //   121: aload_1
    //   122: ifnull +7 -> 129
    //   125: aload_1
    //   126: invokevirtual 97	java/io/OutputStream:close	()V
    //   129: ldc 7
    //   131: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aconst_null
    //   135: areturn
    //   136: aload_3
    //   137: invokevirtual 56	java/io/File:getName	()Ljava/lang/String;
    //   140: astore_2
    //   141: aload_0
    //   142: invokevirtual 96	java/io/FileInputStream:close	()V
    //   145: aload_1
    //   146: ifnull +7 -> 153
    //   149: aload_1
    //   150: invokevirtual 97	java/io/OutputStream:close	()V
    //   153: ldc 7
    //   155: invokestatic 100	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: aload_2
    //   159: areturn
    //   160: astore_0
    //   161: goto -16 -> 145
    //   164: astore_0
    //   165: goto -12 -> 153
    //   168: astore_0
    //   169: goto -48 -> 121
    //   172: astore_0
    //   173: goto -44 -> 129
    //   176: astore_0
    //   177: aconst_null
    //   178: astore_1
    //   179: aconst_null
    //   180: astore_0
    //   181: goto -68 -> 113
    //   184: astore_0
    //   185: aconst_null
    //   186: astore_0
    //   187: goto -74 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramContext	Context
    //   0	190	1	paramString1	String
    //   0	190	2	paramString2	String
    //   13	124	3	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   90	96	112	finally
    //   96	109	112	finally
    //   136	141	112	finally
    //   141	145	160	finally
    //   149	153	164	finally
    //   117	121	168	finally
    //   125	129	172	finally
    //   5	81	176	finally
    //   81	90	184	finally
  }
  
  public static long c(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    AppMethodBeat.i(210596);
    try
    {
      paramString1 = new Uri.Builder().scheme("content").authority(paramString2 + ".wwapi").appendPath("bundle").appendQueryParameter("pakage", paramString1).build();
      paramString2 = new ContentValues();
      Parcel localParcel = Parcel.obtain();
      paramBundle.writeToParcel(localParcel, 0);
      paramBundle = localParcel.marshall();
      localParcel.recycle();
      paramString2.put("data", paramBundle);
      long l = ContentUris.parseId(paramContext.getContentResolver().insert(paramString1, paramString2));
      return l;
    }
    finally
    {
      AppMethodBeat.o(210596);
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.wework.api.util.OpenDataUtils
 * JD-Core Version:    0.7.0.1
 */