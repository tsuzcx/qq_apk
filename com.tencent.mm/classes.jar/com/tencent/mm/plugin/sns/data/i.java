package com.tencent.mm.plugin.sns.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Vibrator;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.om;
import com.tencent.mm.g.a.rg;
import com.tencent.mm.modelsfs.f;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.o;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.protocal.protobuf.bcs;>;
import java.util.TimeZone;

public final class i
{
  public static String jzf;
  public static String jzg;
  private static Vibrator kqP;
  private static int rbA = -1;
  public static int rbB = 4194304;
  public static int rbC = 1048576;
  private static String rbD = "";
  public static int rbw = 2147483647;
  public static String rbx;
  private static String rby;
  private static int rbz;
  
  static
  {
    jzf = "<TimelineObject>";
    jzg = "</TimelineObject>";
    rbx = "/";
    rby = "snsb";
    rbz = -1;
  }
  
  public static boolean A(Bitmap paramBitmap)
  {
    AppMethodBeat.i(35831);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(35831);
      return false;
    }
    AppMethodBeat.o(35831);
    return true;
  }
  
  public static boolean DB(int paramInt)
  {
    AppMethodBeat.i(35847);
    ah.getContext().getSharedPreferences(ah.dsP(), 0).edit().putInt("sns_control_flag", paramInt).commit();
    AppMethodBeat.o(35847);
    return true;
  }
  
  public static boolean DC(int paramInt)
  {
    AppMethodBeat.i(35849);
    ah.getContext().getSharedPreferences(ah.dsP(), 0).edit().putInt("sns_respone_count", paramInt).commit();
    AppMethodBeat.o(35849);
    return true;
  }
  
  public static String I(CharSequence paramCharSequence)
  {
    int i = 0;
    AppMethodBeat.i(35851);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(35851);
      return "";
    }
    paramCharSequence = new SpannableString(paramCharSequence);
    o[] arrayOfo = (o[])paramCharSequence.getSpans(0, paramCharSequence.length(), o.class);
    ab.d("MicroMsg.SnsUtil", "removeClickSpanInString, clickSpans.length:%d", new Object[] { Integer.valueOf(arrayOfo.length) });
    while (i < arrayOfo.length)
    {
      paramCharSequence.removeSpan(arrayOfo[i]);
      i += 1;
    }
    paramCharSequence = paramCharSequence.toString();
    AppMethodBeat.o(35851);
    return paramCharSequence;
  }
  
  private static Rect U(Bitmap paramBitmap)
  {
    AppMethodBeat.i(35841);
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    paramBitmap = new Rect(i / 4, 0, (int)(i * 3 / 4.0D), j);
    AppMethodBeat.o(35841);
    return paramBitmap;
  }
  
  private static Rect V(Bitmap paramBitmap)
  {
    AppMethodBeat.i(35842);
    paramBitmap = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    AppMethodBeat.o(35842);
    return paramBitmap;
  }
  
  public static String ZA(String paramString)
  {
    AppMethodBeat.i(35812);
    paramString = "snsu_" + ZJ(paramString);
    AppMethodBeat.o(35812);
    return paramString;
  }
  
  public static String ZB(String paramString)
  {
    AppMethodBeat.i(35821);
    paramString = "sns_tmpb_" + ZJ(paramString);
    AppMethodBeat.o(35821);
    return paramString;
  }
  
  public static String ZC(String paramString)
  {
    AppMethodBeat.i(35823);
    paramString = "sns_tmpt_" + ZJ(paramString);
    AppMethodBeat.o(35823);
    return paramString;
  }
  
  public static String ZD(String paramString)
  {
    AppMethodBeat.i(35826);
    paramString = "sns_tmps_" + ZJ(paramString);
    AppMethodBeat.o(35826);
    return paramString;
  }
  
  public static String ZE(String paramString)
  {
    AppMethodBeat.i(35829);
    paramString = "9_".concat(String.valueOf(paramString));
    AppMethodBeat.o(35829);
    return paramString;
  }
  
  public static com.tencent.mm.memory.n ZF(String paramString)
  {
    AppMethodBeat.i(35834);
    try
    {
      ab.i("MicroMsg.SnsUtil", "decodeFileToBlurThumbBitmap " + com.tencent.mm.vfs.e.cN(paramString));
      boolean bool = com.tencent.mm.vfs.e.cN(paramString);
      if (!bool)
      {
        AppMethodBeat.o(35834);
        return null;
      }
      paramString = ZH(paramString);
      AppMethodBeat.o(35834);
      return paramString;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.SnsUtil", paramString, "snsdecode error", new Object[0]);
      AppMethodBeat.o(35834);
    }
    return null;
  }
  
  /* Error */
  public static Bitmap ZG(String paramString)
  {
    // Byte code:
    //   0: ldc 250
    //   2: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 228	com/tencent/mm/vfs/e:cN	(Ljava/lang/String;)Z
    //   9: istore_2
    //   10: iload_2
    //   11: ifne +10 -> 21
    //   14: ldc 250
    //   16: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aconst_null
    //   20: areturn
    //   21: new 252	android/graphics/BitmapFactory$Options
    //   24: dup
    //   25: invokespecial 254	android/graphics/BitmapFactory$Options:<init>	()V
    //   28: astore 8
    //   30: invokestatic 259	com/tencent/mm/sdk/platformtools/d:dsm	()V
    //   33: aload 8
    //   35: iconst_1
    //   36: putfield 262	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   39: aload 8
    //   41: getfield 262	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   44: istore_1
    //   45: iload_1
    //   46: bipush 10
    //   48: if_icmple +10 -> 58
    //   51: ldc 250
    //   53: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: aconst_null
    //   57: areturn
    //   58: aload_0
    //   59: invokestatic 266	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   62: astore 5
    //   64: invokestatic 272	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   67: lstore_3
    //   68: aload 5
    //   70: aconst_null
    //   71: aload 8
    //   73: invokestatic 278	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   76: astore 7
    //   78: lload_3
    //   79: invokestatic 282	com/tencent/mm/sdk/platformtools/bo:av	(J)J
    //   82: lstore_3
    //   83: aload 8
    //   85: getfield 262	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   88: iconst_1
    //   89: if_icmple +29 -> 118
    //   92: ldc 134
    //   94: new 178	java/lang/StringBuilder
    //   97: dup
    //   98: ldc_w 284
    //   101: invokespecial 183	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   104: aload 8
    //   106: getfield 262	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   109: invokevirtual 287	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   112: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 290	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload 7
    //   120: astore 6
    //   122: aload 7
    //   124: ifnull +16 -> 140
    //   127: aload_0
    //   128: aload 7
    //   130: invokestatic 294	com/tencent/mm/plugin/sns/data/i:s	(Ljava/lang/String;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   133: astore 6
    //   135: aload_0
    //   136: lload_3
    //   137: invokestatic 300	com/tencent/mm/plugin/sns/i/c:aD	(Ljava/lang/String;J)V
    //   140: aload 5
    //   142: ifnull +8 -> 150
    //   145: aload 5
    //   147: invokevirtual 305	java/io/InputStream:close	()V
    //   150: ldc 250
    //   152: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aload 6
    //   157: areturn
    //   158: astore 5
    //   160: aconst_null
    //   161: astore 5
    //   163: aload 8
    //   165: aload 8
    //   167: getfield 262	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   170: iconst_1
    //   171: iadd
    //   172: putfield 262	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   175: aload 5
    //   177: ifnull -138 -> 39
    //   180: aload 5
    //   182: invokevirtual 305	java/io/InputStream:close	()V
    //   185: goto -146 -> 39
    //   188: astore 5
    //   190: goto -151 -> 39
    //   193: astore_0
    //   194: aconst_null
    //   195: astore 5
    //   197: aload 5
    //   199: ifnull +8 -> 207
    //   202: aload 5
    //   204: invokevirtual 305	java/io/InputStream:close	()V
    //   207: ldc 250
    //   209: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   212: aload_0
    //   213: athrow
    //   214: astore_0
    //   215: ldc 134
    //   217: aload_0
    //   218: ldc 239
    //   220: iconst_0
    //   221: anewarray 4	java/lang/Object
    //   224: invokestatic 243	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   227: ldc 250
    //   229: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: aconst_null
    //   233: areturn
    //   234: astore_0
    //   235: goto -85 -> 150
    //   238: astore 5
    //   240: goto -33 -> 207
    //   243: astore_0
    //   244: goto -47 -> 197
    //   247: astore_0
    //   248: goto -51 -> 197
    //   251: astore 6
    //   253: goto -90 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	paramString	String
    //   44	5	1	i	int
    //   9	2	2	bool	boolean
    //   67	70	3	l	long
    //   62	84	5	localInputStream	java.io.InputStream
    //   158	1	5	localOutOfMemoryError1	OutOfMemoryError
    //   161	20	5	localObject1	Object
    //   188	1	5	localIOException1	java.io.IOException
    //   195	8	5	localObject2	Object
    //   238	1	5	localIOException2	java.io.IOException
    //   120	36	6	localBitmap1	Bitmap
    //   251	1	6	localOutOfMemoryError2	OutOfMemoryError
    //   76	53	7	localBitmap2	Bitmap
    //   28	138	8	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   58	64	158	java/lang/OutOfMemoryError
    //   180	185	188	java/io/IOException
    //   58	64	193	finally
    //   5	10	214	java/lang/Exception
    //   21	39	214	java/lang/Exception
    //   39	45	214	java/lang/Exception
    //   145	150	214	java/lang/Exception
    //   180	185	214	java/lang/Exception
    //   202	207	214	java/lang/Exception
    //   207	214	214	java/lang/Exception
    //   145	150	234	java/io/IOException
    //   202	207	238	java/io/IOException
    //   64	118	243	finally
    //   127	140	243	finally
    //   163	175	247	finally
    //   64	118	251	java/lang/OutOfMemoryError
    //   127	140	251	java/lang/OutOfMemoryError
  }
  
  public static com.tencent.mm.memory.n ZH(String paramString)
  {
    AppMethodBeat.i(35836);
    try
    {
      boolean bool = com.tencent.mm.vfs.e.cN(paramString);
      if (!bool)
      {
        AppMethodBeat.o(35836);
        return null;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      d.dsm();
      localOptions.inSampleSize = 1;
      for (;;)
      {
        int i = localOptions.inSampleSize;
        if (i > 10)
        {
          AppMethodBeat.o(35836);
          return null;
        }
        try
        {
          long l = bo.yB();
          com.tencent.mm.memory.n localn = com.tencent.mm.plugin.sns.d.a.c(paramString, localOptions);
          l = bo.av(l);
          if (localn != null) {
            c.aD(paramString, l);
          }
          AppMethodBeat.o(35836);
          return localn;
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
      ab.printErrStackTrace("MicroMsg.SnsUtil", paramString, "snsdecode error", new Object[0]);
      AppMethodBeat.o(35836);
    }
  }
  
  public static String ZI(String paramString)
  {
    AppMethodBeat.i(35837);
    paramString = new StringBuffer(paramString);
    while (paramString.length() < 25) {
      paramString.insert(0, "0");
    }
    paramString = paramString.toString();
    AppMethodBeat.o(35837);
    return paramString;
  }
  
  private static String ZJ(String paramString)
  {
    AppMethodBeat.i(35840);
    if (paramString == null)
    {
      AppMethodBeat.o(35840);
      return "";
    }
    int j = paramString.length();
    int i = 0;
    while ((i < j) && (paramString.charAt(i) == '0')) {
      i += 1;
    }
    paramString = paramString.substring(i);
    AppMethodBeat.o(35840);
    return paramString;
  }
  
  public static boolean ZK(String paramString)
  {
    AppMethodBeat.i(35844);
    boolean bool = paramString.startsWith(com.tencent.mm.compatible.util.e.eQx);
    AppMethodBeat.o(35844);
    return bool;
  }
  
  public static boolean ZL(String paramString)
  {
    AppMethodBeat.i(35845);
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, localOptions);
      int i = localOptions.outWidth;
      int j = localOptions.outHeight;
      if ((j >= i * 2) || (i >= j * 2))
      {
        AppMethodBeat.o(35845);
        return true;
      }
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.SnsUtil", "get error setImageExtInfo");
      AppMethodBeat.o(35845);
      return false;
    }
    AppMethodBeat.o(35845);
    return false;
  }
  
  public static boolean ZM(String paramString)
  {
    AppMethodBeat.i(35846);
    int i = rbB;
    int j;
    int k;
    try
    {
      paramString = d.aoT(paramString);
      j = paramString.outWidth;
      k = paramString.outHeight;
      if ((k <= 0) && (j <= 0))
      {
        AppMethodBeat.o(35846);
        return false;
      }
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.SnsUtil", "get error setImageExtInfo");
      AppMethodBeat.o(35846);
      return false;
    }
    if ((k >= j * 2) || (j >= k * 2))
    {
      AppMethodBeat.o(35846);
      return false;
    }
    if (k * j > i)
    {
      AppMethodBeat.o(35846);
      return true;
    }
    AppMethodBeat.o(35846);
    return false;
  }
  
  public static long ZN(String paramString)
  {
    long l1 = 0L;
    AppMethodBeat.i(35857);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(35857);
      return 0L;
    }
    try
    {
      long l2 = new BigInteger(paramString).longValue();
      l1 = l2;
      ab.i("MicroMsg.SnsUtil", "seq %s to snsId %d ", new Object[] { paramString, Long.valueOf(l2) });
      l1 = l2;
    }
    catch (Exception paramString)
    {
      label62:
      break label62;
    }
    AppMethodBeat.o(35857);
    return l1;
  }
  
  /* Error */
  public static int ZO(String paramString)
  {
    // Byte code:
    //   0: ldc_w 403
    //   3: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 406	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   10: istore_2
    //   11: iload_2
    //   12: ifeq +11 -> 23
    //   15: ldc_w 403
    //   18: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: iconst_0
    //   22: ireturn
    //   23: ldc 134
    //   25: ldc_w 408
    //   28: iconst_1
    //   29: anewarray 4	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: aload_0
    //   35: aastore
    //   36: invokestatic 398	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: new 410	android/media/MediaMetadataRetriever
    //   42: dup
    //   43: invokespecial 411	android/media/MediaMetadataRetriever:<init>	()V
    //   46: astore 4
    //   48: aload 4
    //   50: astore_3
    //   51: aload 4
    //   53: aload_0
    //   54: invokevirtual 414	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   57: aload 4
    //   59: astore_3
    //   60: aload 4
    //   62: bipush 9
    //   64: invokevirtual 417	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   67: iconst_0
    //   68: invokestatic 421	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   71: i2l
    //   72: invokestatic 425	com/tencent/mm/sdk/platformtools/bo:nX	(J)I
    //   75: istore_1
    //   76: aload 4
    //   78: invokevirtual 428	android/media/MediaMetadataRetriever:release	()V
    //   81: ldc_w 403
    //   84: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: iload_1
    //   88: ireturn
    //   89: astore_3
    //   90: aconst_null
    //   91: astore 4
    //   93: aload 4
    //   95: astore_3
    //   96: ldc 134
    //   98: ldc_w 430
    //   101: iconst_1
    //   102: anewarray 4	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: aload_0
    //   108: aastore
    //   109: invokestatic 432	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: aload 4
    //   114: ifnull +8 -> 122
    //   117: aload 4
    //   119: invokevirtual 428	android/media/MediaMetadataRetriever:release	()V
    //   122: ldc_w 403
    //   125: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: iconst_0
    //   129: ireturn
    //   130: astore_0
    //   131: aconst_null
    //   132: astore_3
    //   133: aload_3
    //   134: ifnull +7 -> 141
    //   137: aload_3
    //   138: invokevirtual 428	android/media/MediaMetadataRetriever:release	()V
    //   141: ldc_w 403
    //   144: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aload_0
    //   148: athrow
    //   149: astore_0
    //   150: goto -17 -> 133
    //   153: astore_3
    //   154: goto -61 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramString	String
    //   75	13	1	i	int
    //   10	2	2	bool	boolean
    //   50	10	3	localMediaMetadataRetriever1	android.media.MediaMetadataRetriever
    //   89	1	3	localThrowable1	java.lang.Throwable
    //   95	43	3	localMediaMetadataRetriever2	android.media.MediaMetadataRetriever
    //   153	1	3	localThrowable2	java.lang.Throwable
    //   46	72	4	localMediaMetadataRetriever3	android.media.MediaMetadataRetriever
    // Exception table:
    //   from	to	target	type
    //   6	11	89	java/lang/Throwable
    //   23	48	89	java/lang/Throwable
    //   6	11	130	finally
    //   23	48	130	finally
    //   51	57	149	finally
    //   60	76	149	finally
    //   96	112	149	finally
    //   51	57	153	java/lang/Throwable
    //   60	76	153	java/lang/Throwable
  }
  
  public static List<PointF> ZP(String paramString)
  {
    AppMethodBeat.i(35860);
    ArrayList localArrayList = new ArrayList();
    int i;
    float f1;
    float f2;
    if (!bo.isNullOrNil(paramString))
    {
      String[] arrayOfString1 = paramString.split("[|]");
      int j = arrayOfString1.length;
      i = 0;
      if (i < j)
      {
        String[] arrayOfString2 = arrayOfString1[i].split("[_]");
        if (arrayOfString2.length != 2) {
          break label157;
        }
        f1 = bo.getFloat(arrayOfString2[0], -1.0F);
        f2 = bo.getFloat(arrayOfString2[1], -1.0F);
        if ((f1 != -1.0F) && (f2 != -1.0F)) {
          break label133;
        }
        ab.e("MicroMsg.SnsUtil", "invalid gesture str! %s", new Object[] { paramString });
        localArrayList.clear();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(35860);
      return localArrayList;
      label133:
      localArrayList.add(new PointF(f1, f2));
      i += 1;
      break;
      label157:
      ab.e("MicroMsg.SnsUtil", "invalid gesture str! %s", new Object[] { paramString });
      localArrayList.clear();
    }
  }
  
  public static void ZQ(String paramString)
  {
    AppMethodBeat.i(155716);
    rbD = rbD + paramString + ";";
    AppMethodBeat.o(155716);
  }
  
  public static String Zx(String paramString)
  {
    AppMethodBeat.i(35807);
    paramString = "snst_" + ZJ(paramString);
    AppMethodBeat.o(35807);
    return paramString;
  }
  
  public static String Zy(String paramString)
  {
    AppMethodBeat.i(35808);
    paramString = "snsu_" + ZJ(paramString);
    AppMethodBeat.o(35808);
    return paramString;
  }
  
  public static String Zz(String paramString)
  {
    AppMethodBeat.i(35809);
    paramString = "snsb_" + ZJ(paramString);
    AppMethodBeat.o(35809);
    return paramString;
  }
  
  public static SpannableString a(String paramString, Context paramContext, TextView paramTextView)
  {
    AppMethodBeat.i(35855);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(35855);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("<img src=\"original_label.png\"/>  ");
    localStringBuilder.append(paramString);
    paramString = new SpannableString(j.e(paramContext, localStringBuilder.toString(), (int)paramTextView.getTextSize()));
    AppMethodBeat.o(35855);
    return paramString;
  }
  
  public static void a(SnsAdClick paramSnsAdClick)
  {
    AppMethodBeat.i(35859);
    om localom = new om();
    localom.cFa.cFb = paramSnsAdClick;
    com.tencent.mm.sdk.b.a.ymk.l(localom);
    AppMethodBeat.o(35859);
  }
  
  public static void aC(String paramString, long paramLong)
  {
    AppMethodBeat.i(35830);
    long l = System.currentTimeMillis();
    ab.d("MicroMsg.SnsUtil", " name " + paramString + " allTime " + (l - paramLong));
    AppMethodBeat.o(35830);
  }
  
  private static String ae(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(156217);
    for (;;)
    {
      try
      {
        int i = paramString1.indexOf("#");
        if (i >= 0)
        {
          str2 = paramString1.substring(0, i);
          str1 = paramString1.substring(i);
          if (str2.contains("?"))
          {
            paramString2 = str2 + "&" + paramString2 + "=" + paramString3;
            paramString2 = paramString2 + str1;
            AppMethodBeat.o(156217);
            return paramString2;
          }
          paramString2 = str2 + "?" + paramString2 + "=" + paramString3;
          continue;
        }
        String str1 = "";
      }
      catch (Exception paramString2)
      {
        ab.e("MicroMsg.SnsUtil", "appendUrlParams exp:" + paramString2.toString());
        AppMethodBeat.o(156217);
        return paramString1;
      }
      String str2 = paramString1;
    }
  }
  
  public static long afS()
  {
    AppMethodBeat.i(35854);
    long l = (int)(TimeZone.getDefault().getRawOffset() / 60000L) / 60L;
    AppMethodBeat.o(35854);
    return l;
  }
  
  public static void b(View paramView, Context paramContext)
  {
    AppMethodBeat.i(35852);
    ViewGroup.LayoutParams localLayoutParams;
    int i;
    int k;
    if ((paramView != null) && (com.tencent.mm.cb.a.dr(paramContext) > 1.0F))
    {
      float f = com.tencent.mm.cb.a.dr(paramContext);
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
          break label120;
        }
      }
    }
    for (;;)
    {
      localLayoutParams.height = i;
      paramView.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(35852);
      return;
      label120:
      i = k;
    }
  }
  
  public static boolean b(com.tencent.mm.memory.n paramn)
  {
    AppMethodBeat.i(35832);
    if ((paramn == null) || (paramn.isRecycled()))
    {
      AppMethodBeat.o(35832);
      return false;
    }
    AppMethodBeat.o(35832);
    return true;
  }
  
  public static String bc(int paramInt, String paramString)
  {
    AppMethodBeat.i(35804);
    paramString = paramInt + "-" + paramString;
    AppMethodBeat.o(35804);
    return paramString;
  }
  
  public static String bd(int paramInt, String paramString)
  {
    AppMethodBeat.i(35828);
    paramString = paramInt + "-" + paramString;
    AppMethodBeat.o(35828);
    return paramString;
  }
  
  private static String c(bcs parambcs)
  {
    AppMethodBeat.i(35806);
    if (!bo.isNullOrNil(parambcs.xsg))
    {
      parambcs = parambcs.xsg;
      AppMethodBeat.o(35806);
      return parambcs;
    }
    String str = "";
    try
    {
      parambcs = com.tencent.mm.a.g.w(parambcs.toByteArray());
      AppMethodBeat.o(35806);
      return parambcs;
    }
    catch (Exception parambcs)
    {
      for (;;)
      {
        parambcs = str;
      }
    }
  }
  
  public static String cY(List<bcs> paramList)
  {
    AppMethodBeat.i(35805);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(35805);
      return "";
    }
    Object localObject = "";
    Iterator localIterator = paramList.iterator();
    int i = 0;
    paramList = (List<bcs>)localObject;
    for (;;)
    {
      localObject = paramList;
      if (localIterator.hasNext())
      {
        bcs localbcs = (bcs)localIterator.next();
        localObject = paramList;
        if (paramList.length() > 0) {
          localObject = paramList + "-";
        }
        paramList = (String)localObject + localbcs.Id;
        i += 1;
        if (i >= 4) {
          localObject = paramList;
        }
      }
      else
      {
        AppMethodBeat.o(35805);
        return localObject;
      }
    }
  }
  
  public static String cZ(List<PointF> paramList)
  {
    AppMethodBeat.i(35862);
    StringBuilder localStringBuilder = new StringBuilder("");
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      PointF localPointF = (PointF)localIterator.next();
      localStringBuilder.append(localPointF.x);
      localStringBuilder.append("_");
      localStringBuilder.append(localPointF.y);
      localStringBuilder.append("|");
    }
    if (paramList.size() > 0) {
      localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    }
    paramList = localStringBuilder.toString();
    AppMethodBeat.o(35862);
    return paramList;
  }
  
  public static int cnQ()
  {
    AppMethodBeat.i(35848);
    int i = ah.getContext().getSharedPreferences(ah.dsP(), 0).getInt("sns_control_flag", 0);
    AppMethodBeat.o(35848);
    return i;
  }
  
  public static int cnR()
  {
    AppMethodBeat.i(35850);
    int i = ah.getContext().getSharedPreferences(ah.dsP(), 0).getInt("sns_respone_count", 20);
    AppMethodBeat.o(35850);
    return i;
  }
  
  public static int cnS()
  {
    AppMethodBeat.i(35853);
    Context localContext = ah.getContext();
    if (at.is2G(localContext))
    {
      AppMethodBeat.o(35853);
      return 1;
    }
    if (at.is3G(localContext))
    {
      AppMethodBeat.o(35853);
      return 2;
    }
    if (at.is4G(localContext))
    {
      AppMethodBeat.o(35853);
      return 3;
    }
    if (at.isWifi(localContext))
    {
      AppMethodBeat.o(35853);
      return 4;
    }
    AppMethodBeat.o(35853);
    return 0;
  }
  
  public static String cnT()
  {
    String str = rbD;
    rbD = "";
    return str;
  }
  
  public static String d(bcs parambcs)
  {
    AppMethodBeat.i(35810);
    String str = "snsb_" + ZJ(parambcs.Id);
    if (parambcs.xse == 1)
    {
      parambcs = f.z(str + c(parambcs), parambcs.xsf);
      AppMethodBeat.o(35810);
      return parambcs;
    }
    AppMethodBeat.o(35810);
    return str;
  }
  
  public static String e(bcs parambcs)
  {
    AppMethodBeat.i(35811);
    String str = "snst_" + ZJ(parambcs.Id);
    if (parambcs.xse == 1)
    {
      parambcs = f.z(str + c(parambcs), parambcs.xsf);
      AppMethodBeat.o(35811);
      return parambcs;
    }
    AppMethodBeat.o(35811);
    return str;
  }
  
  public static void e(long[] paramArrayOfLong)
  {
    AppMethodBeat.i(35863);
    try
    {
      if (kqP == null) {
        kqP = (Vibrator)ah.getContext().getSystemService("vibrator");
      }
      kqP.vibrate(paramArrayOfLong, -1);
      AppMethodBeat.o(35863);
      return;
    }
    catch (Exception paramArrayOfLong)
    {
      ab.printErrStackTrace("MicroMsg.SnsUtil", paramArrayOfLong, "vibrate error!", new Object[0]);
      AppMethodBeat.o(35863);
    }
  }
  
  public static String f(bcs parambcs)
  {
    AppMethodBeat.i(35813);
    String str = "snsu_" + ZJ(parambcs.Id);
    if (parambcs.xse == 1)
    {
      parambcs = f.z(str + c(parambcs), parambcs.xsf);
      AppMethodBeat.o(35813);
      return parambcs;
    }
    AppMethodBeat.o(35813);
    return str;
  }
  
  public static String g(bcs parambcs)
  {
    AppMethodBeat.i(35814);
    String str = "snsblurt_" + ZJ(parambcs.Id);
    if (parambcs.xse == 1)
    {
      parambcs = f.z(str + c(parambcs), parambcs.xsf);
      AppMethodBeat.o(35814);
      return parambcs;
    }
    AppMethodBeat.o(35814);
    return str;
  }
  
  public static String gg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(145242);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      ab.e("MicroMsg.SnsUtil", "appendAdUxInfo empty:" + paramString1 + ", " + paramString2);
      AppMethodBeat.o(145242);
      return paramString1;
    }
    str1 = "";
    try
    {
      String str2 = URLEncoder.encode(paramString2, "UTF-8");
      paramString2 = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.SnsUtil", "appendAdUxInfo exp:" + localException.toString() + ", " + paramString2);
        paramString2 = str1;
      }
    }
    paramString1 = ae(paramString1, "uxinfo", paramString2);
    ab.i("MicroMsg.SnsUtil", "appendAdUxInfo, ret=".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(145242);
    return paramString1;
  }
  
  public static String h(bcs parambcs)
  {
    AppMethodBeat.i(35815);
    String str = "snsblurs_" + ZJ(parambcs.Id);
    if (parambcs.xse == 1)
    {
      parambcs = f.z(str + c(parambcs), parambcs.xsf);
      AppMethodBeat.o(35815);
      return parambcs;
    }
    AppMethodBeat.o(35815);
    return str;
  }
  
  public static String i(bcs parambcs)
  {
    AppMethodBeat.i(35816);
    String str = "snstblur_src_" + ZJ(parambcs.Id);
    if (parambcs.xse == 1)
    {
      parambcs = f.z(str + c(parambcs), parambcs.xsf);
      AppMethodBeat.o(35816);
      return parambcs;
    }
    AppMethodBeat.o(35816);
    return str;
  }
  
  public static boolean i(com.tencent.mm.plugin.sns.storage.n paramn)
  {
    return (paramn.field_type == 3) || (paramn.field_type == 4) || (paramn.field_type == 5) || (paramn.field_type == 6) || (paramn.field_type == 9) || (paramn.field_type == 10) || (paramn.field_type == 11) || (paramn.field_type == 12) || (paramn.field_type == 13) || (paramn.field_type == 14) || (paramn.field_type == 17) || (paramn.field_type == 22) || (paramn.field_type == 23);
  }
  
  public static String j(com.tencent.mm.plugin.sns.storage.n paramn)
  {
    AppMethodBeat.i(35856);
    if (paramn == null)
    {
      AppMethodBeat.o(35856);
      return "0";
    }
    paramn = lq(paramn.field_snsId);
    AppMethodBeat.o(35856);
    return paramn;
  }
  
  public static String j(bcs parambcs)
  {
    AppMethodBeat.i(35817);
    String str = "sight_" + ZJ(parambcs.Id);
    if (parambcs.xse == 1)
    {
      parambcs = f.z(str + c(parambcs), parambcs.xsf);
      AppMethodBeat.o(35817);
      return parambcs;
    }
    AppMethodBeat.o(35817);
    return str;
  }
  
  public static String k(bcs parambcs)
  {
    AppMethodBeat.i(35818);
    String str = "sightad_" + ZJ(parambcs.Id);
    if (parambcs.xse == 1)
    {
      parambcs = f.z(str, parambcs.xsf);
      AppMethodBeat.o(35818);
      return parambcs;
    }
    AppMethodBeat.o(35818);
    return str;
  }
  
  public static String l(bcs parambcs)
  {
    AppMethodBeat.i(35819);
    String str = "snsb_" + ZJ(parambcs.Id);
    if (parambcs.xse == 1)
    {
      parambcs = f.z(str + c(parambcs), parambcs.xsf);
      AppMethodBeat.o(35819);
      return parambcs;
    }
    AppMethodBeat.o(35819);
    return str;
  }
  
  public static void la(boolean paramBoolean)
  {
    AppMethodBeat.i(35861);
    rg localrg = new rg();
    localrg.cHN.enable = paramBoolean;
    com.tencent.mm.sdk.b.a.ymk.l(localrg);
    AppMethodBeat.o(35861);
  }
  
  public static String lq(long paramLong)
  {
    AppMethodBeat.i(35838);
    String str = new BigInteger(Long.toBinaryString(paramLong), 2).toString();
    AppMethodBeat.o(35838);
    return str;
  }
  
  public static String lr(long paramLong)
  {
    AppMethodBeat.i(35839);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(35839);
      return "";
    }
    String str = ZI(new BigInteger(Long.toBinaryString(paramLong), 2).toString());
    AppMethodBeat.o(35839);
    return str;
  }
  
  public static String ls(long paramLong)
  {
    AppMethodBeat.i(155108);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.g.RJ();
    localObject = com.tencent.mm.kernel.a.QC() + "_" + paramLong;
    AppMethodBeat.o(155108);
    return localObject;
  }
  
  public static String m(bcs parambcs)
  {
    AppMethodBeat.i(35820);
    String str = "sns_tmpb_" + ZJ(parambcs.Id);
    if (parambcs.xse == 1)
    {
      parambcs = f.z(str + c(parambcs), parambcs.xsf);
      AppMethodBeat.o(35820);
      return parambcs;
    }
    AppMethodBeat.o(35820);
    return str;
  }
  
  public static String n(bcs parambcs)
  {
    AppMethodBeat.i(35822);
    String str = "sns_tmpt_" + ZJ(parambcs.Id);
    if (parambcs.xse == 1)
    {
      parambcs = f.z(str + c(parambcs), parambcs.xsf);
      AppMethodBeat.o(35822);
      return parambcs;
    }
    AppMethodBeat.o(35822);
    return str;
  }
  
  public static Bitmap o(List<com.tencent.mm.memory.n> paramList, int paramInt)
  {
    AppMethodBeat.i(35843);
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (!b((com.tencent.mm.memory.n)((Iterator)localObject1).next()))
      {
        AppMethodBeat.o(35843);
        return null;
      }
    }
    if (paramInt <= 0)
    {
      AppMethodBeat.o(35843);
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramInt, paramInt, Bitmap.Config.ARGB_8888);
    int i = paramList.size();
    LinkedList localLinkedList = new LinkedList();
    int k = paramInt >> 1;
    int j = k + 2;
    k -= 2;
    Object localObject2;
    label175:
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
        break label509;
      }
      localObject3 = ((com.tencent.mm.memory.n)paramList.get(paramInt)).XT();
      localRect = (Rect)localLinkedList.get(paramInt);
      switch (paramList.size())
      {
      default: 
        localObject1 = V((Bitmap)localObject3);
      }
    }
    for (;;)
    {
      ((Canvas)localObject2).drawBitmap((Bitmap)localObject3, (Rect)localObject1, localRect, null);
      i += 1;
      paramInt += 1;
      break label175;
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
      localObject1 = V((Bitmap)localObject3);
      continue;
      localObject1 = U((Bitmap)localObject3);
      continue;
      if (paramInt == 0) {
        localObject1 = U((Bitmap)localObject3);
      } else {
        localObject1 = V((Bitmap)localObject3);
      }
    }
    label509:
    ((Canvas)localObject2).save();
    ((Canvas)localObject2).restore();
    AppMethodBeat.o(35843);
    return localBitmap;
  }
  
  public static String o(bcs parambcs)
  {
    AppMethodBeat.i(35824);
    String str = "sns_tmpu_" + ZJ(parambcs.Id);
    if (parambcs.xse == 1)
    {
      parambcs = f.z(str + c(parambcs), parambcs.xsf);
      AppMethodBeat.o(35824);
      return parambcs;
    }
    AppMethodBeat.o(35824);
    return str;
  }
  
  public static String p(bcs parambcs)
  {
    AppMethodBeat.i(35825);
    String str = "sns_tmps_" + ZJ(parambcs.Id);
    if (parambcs.xse == 1)
    {
      parambcs = f.z(str + c(parambcs), parambcs.xsf);
      AppMethodBeat.o(35825);
      return parambcs;
    }
    AppMethodBeat.o(35825);
    return str;
  }
  
  public static String q(bcs parambcs)
  {
    AppMethodBeat.i(35827);
    String str = "sns_tmpsad_" + ZJ(parambcs.Id);
    if (parambcs.xse == 1)
    {
      parambcs = f.z(str + c(parambcs), parambcs.xsf);
      AppMethodBeat.o(35827);
      return parambcs;
    }
    AppMethodBeat.o(35827);
    return str;
  }
  
  public static Bitmap s(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(35833);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(35833);
      return null;
    }
    String str;
    if (bo.isNullOrNil(paramString)) {
      str = "";
    }
    int i;
    while (bo.isNullOrNil(str))
    {
      AppMethodBeat.o(35833);
      return paramBitmap;
      i = paramString.lastIndexOf(rbx);
      if ((i > 0) && (i + 1 < paramString.length()))
      {
        str = paramString.substring(i + 1);
        if ((str.startsWith(rby)) || (str.startsWith("sns_tmpb_")))
        {
          str = paramString;
          continue;
        }
        if ((str.startsWith("snst_")) || (str.startsWith("snsu_")))
        {
          str = "";
          continue;
        }
      }
      str = paramString;
    }
    for (;;)
    {
      try
      {
        ab.i("MicroMsg.SnsUtil", "[changes below by tomys]parsing jpg, path: %s, size: %s", new Object[] { paramString, Long.valueOf(com.tencent.mm.vfs.e.avI(paramString)) });
        paramString = Exif.fromFile(paramString);
        if (paramString == null) {
          break label244;
        }
        i = paramString.getOrientationInDegree() % 360;
      }
      catch (Exception paramString)
      {
        ab.printErrStackTrace("MicroMsg.SnsUtil", paramString, "Failed parsing JPEG file: ".concat(String.valueOf(str)), new Object[0]);
        i = 0;
        continue;
      }
      finally
      {
        AppMethodBeat.o(35833);
      }
      ab.d("MicroMsg.SnsUtil", "exifPath : %s degree : %d", new Object[] { str, Integer.valueOf(i) });
      paramString = d.b(paramBitmap, i);
      AppMethodBeat.o(35833);
      return paramString;
      label244:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.i
 * JD-Core Version:    0.7.0.1
 */