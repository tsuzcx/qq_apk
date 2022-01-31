package com.tencent.mm.plugin.sns.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.h.a.nn;
import com.tencent.mm.modelsfs.f;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.o;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.protocal.c.awd;>;
import java.util.TimeZone;

public final class i
{
  public static String hFI = "<TimelineObject>";
  public static String hFJ = "</TimelineObject>";
  public static int onh = 2147483647;
  public static String oni = "/";
  private static String onj = "snsb";
  private static int onk = -1;
  private static int onl = -1;
  public static int onm = 4194304;
  public static int onn = 1048576;
  
  private static Rect I(Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    return new Rect(i / 4, 0, (int)(i * 3 / 4.0D), j);
  }
  
  private static Rect J(Bitmap paramBitmap)
  {
    return new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
  }
  
  public static String MR(String paramString)
  {
    return "snst_" + Nc(paramString);
  }
  
  public static String MS(String paramString)
  {
    return "snsu_" + Nc(paramString);
  }
  
  public static String MT(String paramString)
  {
    return "snsb_" + Nc(paramString);
  }
  
  public static String MU(String paramString)
  {
    return "snsu_" + Nc(paramString);
  }
  
  public static String MV(String paramString)
  {
    return "sns_tmpb_" + Nc(paramString);
  }
  
  public static String MW(String paramString)
  {
    return "sns_tmpt_" + Nc(paramString);
  }
  
  public static String MX(String paramString)
  {
    return "sns_tmps_" + Nc(paramString);
  }
  
  public static com.tencent.mm.memory.n MY(String paramString)
  {
    try
    {
      y.i("MicroMsg.SnsUtil", "decodeFileToBlurThumbBitmap " + com.tencent.mm.vfs.e.bK(paramString));
      if (!com.tencent.mm.vfs.e.bK(paramString)) {
        return null;
      }
      paramString = Na(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.SnsUtil", paramString, "snsdecode error", new Object[0]);
    }
    return null;
  }
  
  /* Error */
  public static Bitmap MZ(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 116	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 142	android/graphics/BitmapFactory$Options
    //   12: dup
    //   13: invokespecial 144	android/graphics/BitmapFactory$Options:<init>	()V
    //   16: astore 8
    //   18: aload 8
    //   20: invokestatic 150	com/tencent/mm/sdk/platformtools/c:c	(Landroid/graphics/BitmapFactory$Options;)V
    //   23: aload 8
    //   25: iconst_1
    //   26: putfield 153	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   29: aload 8
    //   31: getfield 153	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   34: istore_1
    //   35: iload_1
    //   36: bipush 10
    //   38: if_icmple +5 -> 43
    //   41: aconst_null
    //   42: areturn
    //   43: aload_0
    //   44: invokestatic 157	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   47: astore 5
    //   49: aload 5
    //   51: astore 4
    //   53: new 159	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger
    //   56: dup
    //   57: invokespecial 160	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:<init>	()V
    //   60: astore 9
    //   62: aload 5
    //   64: astore 4
    //   66: invokestatic 166	com/tencent/mm/sdk/platformtools/bk:UZ	()J
    //   69: lstore_2
    //   70: aload 5
    //   72: astore 4
    //   74: aload 5
    //   76: aconst_null
    //   77: aload 8
    //   79: aload 9
    //   81: iconst_0
    //   82: iconst_0
    //   83: newarray int
    //   85: invokestatic 172	com/tencent/mm/sdk/platformtools/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;I[I)Landroid/graphics/Bitmap;
    //   88: astore 7
    //   90: aload 5
    //   92: astore 4
    //   94: lload_2
    //   95: invokestatic 176	com/tencent/mm/sdk/platformtools/bk:cp	(J)J
    //   98: lstore_2
    //   99: aload 5
    //   101: astore 4
    //   103: aload 8
    //   105: getfield 153	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   108: iconst_1
    //   109: if_icmple +32 -> 141
    //   112: aload 5
    //   114: astore 4
    //   116: ldc 108
    //   118: new 70	java/lang/StringBuilder
    //   121: dup
    //   122: ldc 178
    //   124: invokespecial 75	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   127: aload 8
    //   129: getfield 153	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   132: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   135: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 184	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: aload 7
    //   143: ifnull +41 -> 184
    //   146: aload 5
    //   148: astore 4
    //   150: aload_0
    //   151: aload 7
    //   153: invokestatic 188	com/tencent/mm/plugin/sns/data/i:q	(Ljava/lang/String;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   156: astore 6
    //   158: aload 5
    //   160: astore 4
    //   162: aload_0
    //   163: lload_2
    //   164: invokestatic 194	com/tencent/mm/plugin/sns/h/c:aj	(Ljava/lang/String;J)V
    //   167: aload 5
    //   169: ifnull +154 -> 323
    //   172: aload 5
    //   174: invokevirtual 199	java/io/InputStream:close	()V
    //   177: aload 6
    //   179: areturn
    //   180: astore_0
    //   181: aload 6
    //   183: areturn
    //   184: aload 7
    //   186: astore 6
    //   188: aload 5
    //   190: astore 4
    //   192: aload 9
    //   194: invokevirtual 202	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:getDecodeResult	()I
    //   197: sipush 2000
    //   200: if_icmplt -33 -> 167
    //   203: aload 5
    //   205: astore 4
    //   207: aload_0
    //   208: bipush 10
    //   210: aload 9
    //   212: invokestatic 208	com/tencent/mm/sdk/platformtools/MMBitmapFactory$KVStatHelper:getKVStatString	(Ljava/lang/Object;ILcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;)Ljava/lang/String;
    //   215: astore 6
    //   217: aload 5
    //   219: astore 4
    //   221: getstatic 214	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   224: sipush 12712
    //   227: aload 6
    //   229: invokevirtual 218	com/tencent/mm/plugin/report/service/h:aC	(ILjava/lang/String;)V
    //   232: aload 7
    //   234: astore 6
    //   236: goto -69 -> 167
    //   239: astore 4
    //   241: aload 5
    //   243: astore 4
    //   245: aload 8
    //   247: aload 8
    //   249: getfield 153	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   252: iconst_1
    //   253: iadd
    //   254: putfield 153	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   257: aload 5
    //   259: ifnull -230 -> 29
    //   262: aload 5
    //   264: invokevirtual 199	java/io/InputStream:close	()V
    //   267: goto -238 -> 29
    //   270: astore 4
    //   272: goto -243 -> 29
    //   275: astore_0
    //   276: aconst_null
    //   277: astore 4
    //   279: aload 4
    //   281: ifnull +8 -> 289
    //   284: aload 4
    //   286: invokevirtual 199	java/io/InputStream:close	()V
    //   289: aload_0
    //   290: athrow
    //   291: astore_0
    //   292: ldc 108
    //   294: aload_0
    //   295: ldc 130
    //   297: iconst_0
    //   298: anewarray 4	java/lang/Object
    //   301: invokestatic 134	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   304: aconst_null
    //   305: areturn
    //   306: astore 4
    //   308: goto -19 -> 289
    //   311: astore_0
    //   312: goto -33 -> 279
    //   315: astore 4
    //   317: aconst_null
    //   318: astore 5
    //   320: goto -79 -> 241
    //   323: aload 6
    //   325: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	paramString	String
    //   34	5	1	i	int
    //   69	95	2	l	long
    //   51	169	4	localInputStream1	java.io.InputStream
    //   239	1	4	localOutOfMemoryError1	OutOfMemoryError
    //   243	1	4	localInputStream2	java.io.InputStream
    //   270	1	4	localIOException1	java.io.IOException
    //   277	8	4	localObject1	Object
    //   306	1	4	localIOException2	java.io.IOException
    //   315	1	4	localOutOfMemoryError2	OutOfMemoryError
    //   47	272	5	localInputStream3	java.io.InputStream
    //   156	168	6	localObject2	Object
    //   88	145	7	localBitmap	Bitmap
    //   16	232	8	localOptions	BitmapFactory.Options
    //   60	151	9	localDecodeResultLogger	MMBitmapFactory.DecodeResultLogger
    // Exception table:
    //   from	to	target	type
    //   172	177	180	java/io/IOException
    //   53	62	239	java/lang/OutOfMemoryError
    //   66	70	239	java/lang/OutOfMemoryError
    //   74	90	239	java/lang/OutOfMemoryError
    //   94	99	239	java/lang/OutOfMemoryError
    //   103	112	239	java/lang/OutOfMemoryError
    //   116	141	239	java/lang/OutOfMemoryError
    //   150	158	239	java/lang/OutOfMemoryError
    //   162	167	239	java/lang/OutOfMemoryError
    //   192	203	239	java/lang/OutOfMemoryError
    //   207	217	239	java/lang/OutOfMemoryError
    //   221	232	239	java/lang/OutOfMemoryError
    //   262	267	270	java/io/IOException
    //   43	49	275	finally
    //   0	7	291	java/lang/Exception
    //   9	29	291	java/lang/Exception
    //   29	35	291	java/lang/Exception
    //   172	177	291	java/lang/Exception
    //   262	267	291	java/lang/Exception
    //   284	289	291	java/lang/Exception
    //   289	291	291	java/lang/Exception
    //   284	289	306	java/io/IOException
    //   53	62	311	finally
    //   66	70	311	finally
    //   74	90	311	finally
    //   94	99	311	finally
    //   103	112	311	finally
    //   116	141	311	finally
    //   150	158	311	finally
    //   162	167	311	finally
    //   192	203	311	finally
    //   207	217	311	finally
    //   221	232	311	finally
    //   245	257	311	finally
    //   43	49	315	java/lang/OutOfMemoryError
  }
  
  public static com.tencent.mm.memory.n Na(String paramString)
  {
    try
    {
      if (!com.tencent.mm.vfs.e.bK(paramString)) {
        return null;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      com.tencent.mm.sdk.platformtools.c.c(localOptions);
      localOptions.inSampleSize = 1;
      for (;;)
      {
        int i = localOptions.inSampleSize;
        if (i > 10) {
          break;
        }
        try
        {
          Object localObject = new MMBitmapFactory.DecodeResultLogger();
          long l = bk.UZ();
          com.tencent.mm.memory.n localn = com.tencent.mm.plugin.sns.d.a.c(paramString, localOptions, (MMBitmapFactory.DecodeResultLogger)localObject);
          l = bk.cp(l);
          if (localn != null)
          {
            com.tencent.mm.plugin.sns.h.c.aj(paramString, l);
          }
          else if (((MMBitmapFactory.DecodeResultLogger)localObject).getDecodeResult() >= 2000)
          {
            localObject = MMBitmapFactory.KVStatHelper.getKVStatString(paramString, 10, (MMBitmapFactory.DecodeResultLogger)localObject);
            h.nFQ.aC(12712, (String)localObject);
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOptions.inSampleSize += 1;
        }
      }
      return null;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.SnsUtil", paramString, "snsdecode error", new Object[0]);
    }
    return localOutOfMemoryError;
  }
  
  public static String Nb(String paramString)
  {
    paramString = new StringBuffer(paramString);
    while (paramString.length() < 25) {
      paramString.insert(0, "0");
    }
    return paramString.toString();
  }
  
  private static String Nc(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    int j = paramString.length();
    int i = 0;
    while ((i < j) && (paramString.charAt(i) == '0')) {
      i += 1;
    }
    return paramString.substring(i);
  }
  
  public static boolean Nd(String paramString)
  {
    return paramString.startsWith(com.tencent.mm.compatible.util.e.bkF);
  }
  
  public static boolean Ne(String paramString)
  {
    boolean bool = false;
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      int i = localOptions.outWidth;
      int j = localOptions.outHeight;
      if ((j >= i * 2) || (i >= j * 2)) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.SnsUtil", "get error setImageExtInfo");
    }
    return false;
  }
  
  public static boolean Nf(String paramString)
  {
    int i = onm;
    int j;
    int k;
    do
    {
      try
      {
        paramString = com.tencent.mm.sdk.platformtools.c.YU(paramString);
        j = paramString.outWidth;
        k = paramString.outHeight;
        if ((k <= 0) && (j <= 0)) {
          return false;
        }
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.SnsUtil", "get error setImageExtInfo");
        return false;
      }
    } while ((k >= j * 2) || (j >= k * 2) || (k * j <= i));
    return true;
  }
  
  public static long Ng(String paramString)
  {
    long l1 = 0L;
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    try
    {
      long l2 = new BigInteger(paramString).longValue();
      l1 = l2;
      y.i("MicroMsg.SnsUtil", "seq %s to snsId %d ", new Object[] { paramString, Long.valueOf(l2) });
      return l2;
    }
    catch (Exception paramString) {}
    return l1;
  }
  
  /* Error */
  public static int Nh(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 318	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: ldc 108
    //   11: ldc_w 320
    //   14: iconst_1
    //   15: anewarray 4	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: aload_0
    //   21: aastore
    //   22: invokestatic 311	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: new 322	android/media/MediaMetadataRetriever
    //   28: dup
    //   29: invokespecial 323	android/media/MediaMetadataRetriever:<init>	()V
    //   32: astore_3
    //   33: aload_3
    //   34: astore_2
    //   35: aload_3
    //   36: aload_0
    //   37: invokevirtual 326	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   40: aload_3
    //   41: astore_2
    //   42: aload_3
    //   43: bipush 9
    //   45: invokevirtual 329	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   48: iconst_0
    //   49: invokestatic 333	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   52: i2l
    //   53: invokestatic 337	com/tencent/mm/sdk/platformtools/bk:hv	(J)I
    //   56: istore_1
    //   57: aload_3
    //   58: invokevirtual 340	android/media/MediaMetadataRetriever:release	()V
    //   61: iload_1
    //   62: ireturn
    //   63: astore_2
    //   64: aconst_null
    //   65: astore_3
    //   66: aload_3
    //   67: astore_2
    //   68: ldc 108
    //   70: ldc_w 342
    //   73: iconst_1
    //   74: anewarray 4	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_0
    //   80: aastore
    //   81: invokestatic 344	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   84: aload_3
    //   85: ifnull +30 -> 115
    //   88: aload_3
    //   89: invokevirtual 340	android/media/MediaMetadataRetriever:release	()V
    //   92: iconst_0
    //   93: ireturn
    //   94: astore_0
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_2
    //   98: ifnull +7 -> 105
    //   101: aload_2
    //   102: invokevirtual 340	android/media/MediaMetadataRetriever:release	()V
    //   105: aload_0
    //   106: athrow
    //   107: astore_0
    //   108: goto -11 -> 97
    //   111: astore_2
    //   112: goto -46 -> 66
    //   115: iconst_0
    //   116: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramString	String
    //   56	6	1	i	int
    //   34	8	2	localMediaMetadataRetriever1	android.media.MediaMetadataRetriever
    //   63	1	2	localThrowable1	java.lang.Throwable
    //   67	35	2	localMediaMetadataRetriever2	android.media.MediaMetadataRetriever
    //   111	1	2	localThrowable2	java.lang.Throwable
    //   32	57	3	localMediaMetadataRetriever3	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   0	7	63	java/lang/Throwable
    //   9	33	63	java/lang/Throwable
    //   0	7	94	finally
    //   9	33	94	finally
    //   35	40	107	finally
    //   42	57	107	finally
    //   68	84	107	finally
    //   35	40	111	java/lang/Throwable
    //   42	57	111	java/lang/Throwable
  }
  
  public static long Nh()
  {
    return (int)(TimeZone.getDefault().getRawOffset() / 60000L) / 60L;
  }
  
  public static SpannableString a(String paramString, Context paramContext, TextView paramTextView)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("<img src=\"original_label.png\"/>  ");
    localStringBuilder.append(paramString);
    return new SpannableString(j.c(paramContext, localStringBuilder.toString(), (int)paramTextView.getTextSize()));
  }
  
  public static void a(SnsAdClick paramSnsAdClick)
  {
    nn localnn = new nn();
    localnn.bXh.bXi = paramSnsAdClick;
    com.tencent.mm.sdk.b.a.udP.m(localnn);
  }
  
  public static String aG(int paramInt, String paramString)
  {
    return paramInt + "-" + paramString;
  }
  
  public static String aH(int paramInt, String paramString)
  {
    return paramInt + "-" + paramString;
  }
  
  public static void ai(String paramString, long paramLong)
  {
    long l = System.currentTimeMillis();
    y.d("MicroMsg.SnsUtil", " name " + paramString + " allTime " + (l - paramLong));
  }
  
  public static void b(View paramView, Context paramContext)
  {
    ViewGroup.LayoutParams localLayoutParams;
    int i;
    int k;
    if ((paramView != null) && (com.tencent.mm.cb.a.cJ(paramContext) > 1.0F))
    {
      float f = com.tencent.mm.cb.a.cJ(paramContext);
      localLayoutParams = paramView.getLayoutParams();
      i = com.tencent.mm.cb.a.fromDPToPix(paramContext, 60);
      if ((localLayoutParams.width >= 0) && (localLayoutParams.height >= 0))
      {
        int m = (int)(localLayoutParams.width * f);
        k = (int)(f * localLayoutParams.height);
        int j = m;
        if (m > i) {
          j = i;
        }
        localLayoutParams.width = j;
        if (k <= i) {
          break label108;
        }
      }
    }
    for (;;)
    {
      localLayoutParams.height = i;
      paramView.setLayoutParams(localLayoutParams);
      return;
      label108:
      i = k;
    }
  }
  
  public static boolean b(com.tencent.mm.memory.n paramn)
  {
    return (paramn != null) && (!paramn.isRecycled());
  }
  
  public static int bCq()
  {
    return ae.getContext().getSharedPreferences(ae.cqR(), 0).getInt("sns_control_flag", 0);
  }
  
  public static int bCr()
  {
    return ae.getContext().getSharedPreferences(ae.cqR(), 0).getInt("sns_respone_count", 20);
  }
  
  public static int bCs()
  {
    Context localContext = ae.getContext();
    if (aq.is2G(localContext)) {
      return 1;
    }
    if (aq.is3G(localContext)) {
      return 2;
    }
    if (aq.is4G(localContext)) {
      return 3;
    }
    if (aq.isWifi(localContext)) {
      return 4;
    }
    return 0;
  }
  
  private static String c(awd paramawd)
  {
    if (!bk.bl(paramawd.tsd)) {
      return paramawd.tsd;
    }
    try
    {
      paramawd = g.o(paramawd.toByteArray());
      return paramawd;
    }
    catch (Exception paramawd) {}
    return "";
  }
  
  public static String cu(List<awd> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      localObject = "";
      return localObject;
    }
    Object localObject = "";
    Iterator localIterator = paramList.iterator();
    int i = 0;
    paramList = (List<awd>)localObject;
    for (;;)
    {
      localObject = paramList;
      if (!localIterator.hasNext()) {
        break;
      }
      awd localawd = (awd)localIterator.next();
      localObject = paramList;
      if (paramList.length() > 0) {
        localObject = paramList + "-";
      }
      paramList = (String)localObject + localawd.lsK;
      i += 1;
      localObject = paramList;
      if (i >= 4) {
        break;
      }
    }
  }
  
  public static String d(awd paramawd)
  {
    String str2 = "snsb_" + Nc(paramawd.lsK);
    String str1 = str2;
    if (paramawd.tsb == 1) {
      str1 = f.q(str2 + c(paramawd), paramawd.tsc);
    }
    return str1;
  }
  
  public static String e(awd paramawd)
  {
    String str2 = "snst_" + Nc(paramawd.lsK);
    String str1 = str2;
    if (paramawd.tsb == 1) {
      str1 = f.q(str2 + c(paramawd), paramawd.tsc);
    }
    return str1;
  }
  
  public static String f(awd paramawd)
  {
    String str2 = "snsu_" + Nc(paramawd.lsK);
    String str1 = str2;
    if (paramawd.tsb == 1) {
      str1 = f.q(str2 + c(paramawd), paramawd.tsc);
    }
    return str1;
  }
  
  public static String fN(long paramLong)
  {
    return new BigInteger(Long.toBinaryString(paramLong), 2).toString();
  }
  
  public static String fO(long paramLong)
  {
    if (paramLong == 0L) {
      return "";
    }
    return Nb(new BigInteger(Long.toBinaryString(paramLong), 2).toString());
  }
  
  public static String g(awd paramawd)
  {
    String str2 = "snsblurt_" + Nc(paramawd.lsK);
    String str1 = str2;
    if (paramawd.tsb == 1) {
      str1 = f.q(str2 + c(paramawd), paramawd.tsc);
    }
    return str1;
  }
  
  public static String h(awd paramawd)
  {
    String str2 = "snsblurs_" + Nc(paramawd.lsK);
    String str1 = str2;
    if (paramawd.tsb == 1) {
      str1 = f.q(str2 + c(paramawd), paramawd.tsc);
    }
    return str1;
  }
  
  public static String i(awd paramawd)
  {
    String str2 = "snstblur_src_" + Nc(paramawd.lsK);
    String str1 = str2;
    if (paramawd.tsb == 1) {
      str1 = f.q(str2 + c(paramawd), paramawd.tsc);
    }
    return str1;
  }
  
  public static boolean i(com.tencent.mm.plugin.sns.storage.n paramn)
  {
    return (paramn.field_type == 3) || (paramn.field_type == 4) || (paramn.field_type == 5) || (paramn.field_type == 6) || (paramn.field_type == 9) || (paramn.field_type == 10) || (paramn.field_type == 11) || (paramn.field_type == 12) || (paramn.field_type == 13) || (paramn.field_type == 14) || (paramn.field_type == 17) || (paramn.field_type == 22) || (paramn.field_type == 23);
  }
  
  public static Bitmap j(List<com.tencent.mm.memory.n> paramList, int paramInt)
  {
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (!b((com.tencent.mm.memory.n)((Iterator)localObject1).next())) {
        return null;
      }
    }
    if (paramInt <= 0) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramInt, paramInt, Bitmap.Config.ARGB_8888);
    int i = paramList.size();
    LinkedList localLinkedList = new LinkedList();
    int k = paramInt >> 1;
    int j = k + 2;
    k -= 2;
    Object localObject2;
    label157:
    Object localObject3;
    Rect localRect;
    if (i == 2)
    {
      localObject1 = new Rect(0, 0, k, paramInt);
      localObject2 = new Rect(j, 0, paramInt, paramInt);
      localLinkedList.add(localObject1);
      localLinkedList.add(localObject2);
      localObject2 = new Canvas(localBitmap);
      ((Canvas)localObject2).drawColor(-1);
      i = 0;
      paramInt = 0;
      if ((paramInt >= paramList.size()) || (i >= 4)) {
        break label489;
      }
      localObject3 = ((com.tencent.mm.memory.n)paramList.get(paramInt)).Fe();
      localRect = (Rect)localLinkedList.get(paramInt);
      switch (paramList.size())
      {
      default: 
        localObject1 = J((Bitmap)localObject3);
      }
    }
    for (;;)
    {
      ((Canvas)localObject2).drawBitmap((Bitmap)localObject3, (Rect)localObject1, localRect, null);
      i += 1;
      paramInt += 1;
      break label157;
      if (i == 3)
      {
        localObject1 = new Rect(0, 0, k, paramInt);
        localObject2 = new Rect(j, 0, paramInt, k);
        localObject3 = new Rect(j, j, paramInt, paramInt);
        localLinkedList.add(localObject1);
        localLinkedList.add(localObject2);
        localLinkedList.add(localObject3);
        break;
      }
      if (i < 4) {
        break;
      }
      localObject1 = new Rect(0, 0, k, k);
      localObject2 = new Rect(0, j, k, paramInt);
      localObject3 = new Rect(j, 0, paramInt, k);
      localRect = new Rect(j, j, paramInt, paramInt);
      localLinkedList.add(localObject1);
      localLinkedList.add(localObject2);
      localLinkedList.add(localObject3);
      localLinkedList.add(localRect);
      break;
      localObject1 = J((Bitmap)localObject3);
      continue;
      localObject1 = I((Bitmap)localObject3);
      continue;
      if (paramInt == 0) {
        localObject1 = I((Bitmap)localObject3);
      } else {
        localObject1 = J((Bitmap)localObject3);
      }
    }
    label489:
    ((Canvas)localObject2).save(31);
    ((Canvas)localObject2).restore();
    return localBitmap;
  }
  
  public static String j(com.tencent.mm.plugin.sns.storage.n paramn)
  {
    if (paramn == null) {
      return "0";
    }
    return fN(paramn.field_snsId);
  }
  
  public static String j(awd paramawd)
  {
    String str2 = "sight_" + Nc(paramawd.lsK);
    String str1 = str2;
    if (paramawd.tsb == 1) {
      str1 = f.q(str2 + c(paramawd), paramawd.tsc);
    }
    return str1;
  }
  
  public static String k(awd paramawd)
  {
    String str2 = "sightad_" + Nc(paramawd.lsK);
    String str1 = str2;
    if (paramawd.tsb == 1) {
      str1 = f.q(str2, paramawd.tsc);
    }
    return str1;
  }
  
  public static String l(awd paramawd)
  {
    String str2 = "snsb_" + Nc(paramawd.lsK);
    String str1 = str2;
    if (paramawd.tsb == 1) {
      str1 = f.q(str2 + c(paramawd), paramawd.tsc);
    }
    return str1;
  }
  
  public static String m(awd paramawd)
  {
    String str2 = "sns_tmpb_" + Nc(paramawd.lsK);
    String str1 = str2;
    if (paramawd.tsb == 1) {
      str1 = f.q(str2 + c(paramawd), paramawd.tsc);
    }
    return str1;
  }
  
  public static String n(awd paramawd)
  {
    String str2 = "sns_tmpt_" + Nc(paramawd.lsK);
    String str1 = str2;
    if (paramawd.tsb == 1) {
      str1 = f.q(str2 + c(paramawd), paramawd.tsc);
    }
    return str1;
  }
  
  public static String o(awd paramawd)
  {
    String str2 = "sns_tmpu_" + Nc(paramawd.lsK);
    String str1 = str2;
    if (paramawd.tsb == 1) {
      str1 = f.q(str2 + c(paramawd), paramawd.tsc);
    }
    return str1;
  }
  
  public static String p(awd paramawd)
  {
    String str2 = "sns_tmps_" + Nc(paramawd.lsK);
    String str1 = str2;
    if (paramawd.tsb == 1) {
      str1 = f.q(str2 + c(paramawd), paramawd.tsc);
    }
    return str1;
  }
  
  public static Bitmap q(String paramString, Bitmap paramBitmap)
  {
    Bitmap localBitmap;
    if (paramBitmap == null) {
      localBitmap = null;
    }
    String str;
    do
    {
      return localBitmap;
      if (!bk.bl(paramString)) {
        break;
      }
      str = "";
      localBitmap = paramBitmap;
    } while (bk.bl(str));
    for (;;)
    {
      try
      {
        y.i("MicroMsg.SnsUtil", "[changes below by tomys]parsing jpg, path: %s, size: %s", new Object[] { paramString, Long.valueOf(com.tencent.mm.vfs.e.aeQ(paramString)) });
        paramString = Exif.fromFile(paramString);
        if (paramString == null) {
          break label223;
        }
        i = paramString.getOrientationInDegree() % 360;
      }
      catch (Exception paramString)
      {
        paramString = paramString;
        y.printErrStackTrace("MicroMsg.SnsUtil", paramString, "Failed parsing JPEG file: " + str, new Object[0]);
        i = 0;
        continue;
      }
      finally {}
      y.d("MicroMsg.SnsUtil", "exifPath : %s degree : %d", new Object[] { str, Integer.valueOf(i) });
      return com.tencent.mm.sdk.platformtools.c.b(paramBitmap, i);
      int i = paramString.lastIndexOf(oni);
      if ((i > 0) && (i + 1 < paramString.length()))
      {
        str = paramString.substring(i + 1);
        if ((str.startsWith(onj)) || (str.startsWith("sns_tmpb_")))
        {
          str = paramString;
          break;
        }
        if ((str.startsWith("snst_")) || (str.startsWith("snsu_")))
        {
          str = "";
          break;
        }
      }
      str = paramString;
      break;
      label223:
      i = 0;
    }
  }
  
  public static String q(awd paramawd)
  {
    String str2 = "sns_tmpsad_" + Nc(paramawd.lsK);
    String str1 = str2;
    if (paramawd.tsb == 1) {
      str1 = f.q(str2 + c(paramawd), paramawd.tsc);
    }
    return str1;
  }
  
  public static boolean s(Bitmap paramBitmap)
  {
    return (paramBitmap != null) && (!paramBitmap.isRecycled());
  }
  
  public static boolean xB(int paramInt)
  {
    ae.getContext().getSharedPreferences(ae.cqR(), 0).edit().putInt("sns_control_flag", paramInt).commit();
    return true;
  }
  
  public static boolean xC(int paramInt)
  {
    ae.getContext().getSharedPreferences(ae.cqR(), 0).edit().putInt("sns_respone_count", paramInt).commit();
    return true;
  }
  
  public static String z(CharSequence paramCharSequence)
  {
    int i = 0;
    if (paramCharSequence == null) {
      return "";
    }
    paramCharSequence = new SpannableString(paramCharSequence);
    o[] arrayOfo = (o[])paramCharSequence.getSpans(0, paramCharSequence.length(), o.class);
    y.d("MicroMsg.SnsUtil", "removeClickSpanInString, clickSpans.length:%d", new Object[] { Integer.valueOf(arrayOfo.length) });
    while (i < arrayOfo.length)
    {
      paramCharSequence.removeSpan(arrayOfo[i]);
      i += 1;
    }
    return paramCharSequence.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.i
 * JD-Core Version:    0.7.0.1
 */