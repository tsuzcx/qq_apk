package com.tencent.mm.plugin.sns.data;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.net.Uri;
import android.os.PersistableBundle;
import android.os.Vibrator;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.uc;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.memory.n;
import com.tencent.mm.model.ch;
import com.tencent.mm.modelsfs.e;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.sns.j.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.e.m;
import com.tencent.mm.vfs.o;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.protocal.protobuf.bzh;>;
import java.util.TimeZone;

public final class r
{
  public static int MAX_SIZE = 4194304;
  private static Vibrator nQa;
  public static String nyy;
  public static String nyz;
  private static int zuA;
  public static int zuB;
  public static int zuC = 1048576;
  private static String zuD = "";
  private static String zuE = "";
  private static String zuF = "mp.weixin.qq.com";
  public static int zuw = 2147483647;
  public static String zux;
  private static String zuy;
  private static int zuz;
  
  static
  {
    nyy = "<TimelineObject>";
    nyz = "</TimelineObject>";
    zux = "/";
    zuy = "snsb";
    zuz = -1;
    zuA = -1;
    zuB = 3200;
  }
  
  public static boolean J(Bitmap paramBitmap)
  {
    AppMethodBeat.i(95121);
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(95121);
      return false;
    }
    AppMethodBeat.o(95121);
    return true;
  }
  
  public static String N(CharSequence paramCharSequence)
  {
    int i = 0;
    AppMethodBeat.i(95141);
    if (paramCharSequence == null)
    {
      AppMethodBeat.o(95141);
      return "";
    }
    paramCharSequence = new SpannableString(paramCharSequence);
    com.tencent.mm.pluginsdk.ui.span.p[] arrayOfp = (com.tencent.mm.pluginsdk.ui.span.p[])paramCharSequence.getSpans(0, paramCharSequence.length(), com.tencent.mm.pluginsdk.ui.span.p.class);
    ae.d("MicroMsg.SnsUtil", "removeClickSpanInString, clickSpans.length:%d", new Object[] { Integer.valueOf(arrayOfp.length) });
    while (i < arrayOfp.length)
    {
      paramCharSequence.removeSpan(arrayOfp[i]);
      i += 1;
    }
    paramCharSequence = paramCharSequence.toString();
    AppMethodBeat.o(95141);
    return paramCharSequence;
  }
  
  public static boolean Qq(int paramInt)
  {
    AppMethodBeat.i(95137);
    ak.getContext().getSharedPreferences(ak.fow(), 0).edit().putInt("sns_control_flag", paramInt).commit();
    AppMethodBeat.o(95137);
    return true;
  }
  
  public static boolean Qr(int paramInt)
  {
    AppMethodBeat.i(95139);
    ak.getContext().getSharedPreferences(ak.fow(), 0).edit().putInt("sns_respone_count", paramInt).commit();
    AppMethodBeat.o(95139);
    return true;
  }
  
  public static SpannableString a(String paramString, Context paramContext, TextView paramTextView)
  {
    AppMethodBeat.i(95145);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(95145);
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("<img src=\"original_label.png\"/>  ");
    localStringBuilder.append(paramString);
    paramString = new SpannableString(k.e(paramContext, localStringBuilder.toString(), (int)paramTextView.getTextSize()));
    AppMethodBeat.o(95145);
    return paramString;
  }
  
  public static void a(SnsAdClick paramSnsAdClick)
  {
    AppMethodBeat.i(95149);
    qx localqx = new qx();
    localqx.dGz.dGA = paramSnsAdClick;
    com.tencent.mm.sdk.b.a.IvT.l(localqx);
    AppMethodBeat.o(95149);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, int paramInt)
  {
    AppMethodBeat.i(95156);
    String str = paramString2;
    if (!bu.isNullOrNil(paramString2)) {
      str = i.o(paramString2, new String[] { String.format("gdt_vid=%s", new Object[] { paramString5 }), String.format("weixinadinfo=%s.%s.0.0", new Object[] { paramString4, paramString5 }) });
    }
    paramString2 = new f();
    paramString2.dlj = paramString6;
    paramString2.username = paramString1;
    paramString2.version = bu.aSB(paramString3);
    paramString2.jFL = str;
    paramString2.scene = paramInt;
    paramString2.jFN = new PersistableBundle();
    paramString2.jFN.putString("adUxInfo", paramString7);
    ((com.tencent.mm.plugin.appbrand.service.p)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.p.class)).a(ak.getContext(), paramString2);
    ae.i("MicroMsg.SnsUtil", "jumpWeApp userName=" + paramString1 + ", path=" + str + ", ver=" + paramString3 + ", scene=" + paramString2.scene + ", uxinfo=" + paramString7);
    AppMethodBeat.o(95156);
  }
  
  public static long aHd()
  {
    AppMethodBeat.i(95144);
    long l = (int)(TimeZone.getDefault().getRawOffset() / 60000L) / 60L;
    AppMethodBeat.o(95144);
    return l;
  }
  
  private static Rect ak(Bitmap paramBitmap)
  {
    AppMethodBeat.i(95131);
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    paramBitmap = new Rect(i / 4, 0, (int)(i * 3 / 4.0D), j);
    AppMethodBeat.o(95131);
    return paramBitmap;
  }
  
  private static Rect al(Bitmap paramBitmap)
  {
    AppMethodBeat.i(95132);
    paramBitmap = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    AppMethodBeat.o(95132);
    return paramBitmap;
  }
  
  public static int aou(String paramString)
  {
    AppMethodBeat.i(219265);
    int i = azq(paramString);
    if (paramString.indexOf("png") >= 0) {
      i = 1;
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(219265);
        return i;
        if ((paramString.indexOf("jpg") >= 0) || (paramString.indexOf("jpeg") >= 0))
        {
          i = 2;
        }
        else if (paramString.indexOf("mp3") >= 0)
        {
          i = 3;
        }
        else
        {
          if (paramString.indexOf("wxam") < 0) {
            break;
          }
          i = 4;
        }
      }
    } while (paramString.indexOf("vcodec") < 0);
    AppMethodBeat.o(219265);
    return 5;
  }
  
  private static String ay(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(95157);
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
            AppMethodBeat.o(95157);
            return paramString2;
          }
          paramString2 = str2 + "?" + paramString2 + "=" + paramString3;
          continue;
        }
        String str1 = "";
      }
      catch (Exception paramString2)
      {
        ae.e("MicroMsg.SnsUtil", "appendUrlParams exp:" + paramString2.toString());
        AppMethodBeat.o(95157);
        return paramString1;
      }
      String str2 = paramString1;
    }
  }
  
  /* Error */
  public static int azA(String paramString)
  {
    // Byte code:
    //   0: ldc_w 392
    //   3: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 176	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   10: istore_2
    //   11: iload_2
    //   12: ifeq +11 -> 23
    //   15: ldc_w 392
    //   18: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: iconst_0
    //   22: ireturn
    //   23: ldc 106
    //   25: ldc_w 394
    //   28: iconst_1
    //   29: anewarray 4	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: aload_0
    //   35: aastore
    //   36: invokestatic 396	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: new 398	com/tencent/mm/compatible/h/d
    //   42: dup
    //   43: invokespecial 399	com/tencent/mm/compatible/h/d:<init>	()V
    //   46: astore 4
    //   48: aload 4
    //   50: astore_3
    //   51: aload 4
    //   53: aload_0
    //   54: invokevirtual 404	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   57: aload 4
    //   59: astore_3
    //   60: aload 4
    //   62: bipush 9
    //   64: invokevirtual 407	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   67: iconst_0
    //   68: invokestatic 411	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   71: i2l
    //   72: invokestatic 415	com/tencent/mm/sdk/platformtools/bu:DE	(J)I
    //   75: istore_1
    //   76: aload 4
    //   78: invokevirtual 418	android/media/MediaMetadataRetriever:release	()V
    //   81: ldc_w 392
    //   84: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: iload_1
    //   88: ireturn
    //   89: astore_3
    //   90: aconst_null
    //   91: astore 4
    //   93: aload 4
    //   95: astore_3
    //   96: ldc 106
    //   98: ldc_w 420
    //   101: iconst_1
    //   102: anewarray 4	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: aload_0
    //   108: aastore
    //   109: invokestatic 422	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: aload 4
    //   114: ifnull +8 -> 122
    //   117: aload 4
    //   119: invokevirtual 418	android/media/MediaMetadataRetriever:release	()V
    //   122: ldc_w 392
    //   125: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: iconst_0
    //   129: ireturn
    //   130: astore_0
    //   131: aconst_null
    //   132: astore_3
    //   133: aload_3
    //   134: ifnull +7 -> 141
    //   137: aload_3
    //   138: invokevirtual 418	android/media/MediaMetadataRetriever:release	()V
    //   141: ldc_w 392
    //   144: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   50	10	3	locald1	com.tencent.mm.compatible.h.d
    //   89	1	3	localThrowable1	java.lang.Throwable
    //   95	43	3	locald2	com.tencent.mm.compatible.h.d
    //   153	1	3	localThrowable2	java.lang.Throwable
    //   46	72	4	locald3	com.tencent.mm.compatible.h.d
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
  
  public static List<PointF> azB(String paramString)
  {
    AppMethodBeat.i(95150);
    ArrayList localArrayList = new ArrayList();
    int i;
    float f1;
    float f2;
    if (!bu.isNullOrNil(paramString))
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
        f1 = bu.getFloat(arrayOfString2[0], -1.0F);
        f2 = bu.getFloat(arrayOfString2[1], -1.0F);
        if ((f1 != -1.0F) && (f2 != -1.0F)) {
          break label133;
        }
        ae.e("MicroMsg.SnsUtil", "invalid gesture str! %s", new Object[] { paramString });
        localArrayList.clear();
      }
    }
    for (;;)
    {
      AppMethodBeat.o(95150);
      return localArrayList;
      label133:
      localArrayList.add(new PointF(f1, f2));
      i += 1;
      break;
      label157:
      ae.e("MicroMsg.SnsUtil", "invalid gesture str! %s", new Object[] { paramString });
      localArrayList.clear();
    }
  }
  
  public static void azC(String paramString)
  {
    AppMethodBeat.i(95162);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(95162);
      return;
    }
    zuE = zuE + paramString + ";";
    AppMethodBeat.o(95162);
  }
  
  public static String azD(String paramString)
  {
    AppMethodBeat.i(176243);
    Object localObject;
    String str;
    if (!bu.isNullOrNil(paramString))
    {
      localObject = Uri.parse(paramString);
      if (localObject != null) {
        if (bu.lX(((Uri)localObject).getHost(), zuF))
        {
          paramString = bu.bI(((Uri)localObject).getQueryParameter("__biz"), "");
          str = bu.bI(((Uri)localObject).getQueryParameter("mid"), "");
          localObject = bu.bI(((Uri)localObject).getQueryParameter("idx"), "");
        }
      }
    }
    for (paramString = paramString + "_" + str + "_" + (String)localObject;; paramString = "")
    {
      AppMethodBeat.o(176243);
      return paramString;
    }
  }
  
  public static String azi(String paramString)
  {
    AppMethodBeat.i(95097);
    paramString = "snst_" + azv(paramString);
    AppMethodBeat.o(95097);
    return paramString;
  }
  
  public static String azj(String paramString)
  {
    AppMethodBeat.i(95098);
    paramString = "snsu_" + azv(paramString);
    AppMethodBeat.o(95098);
    return paramString;
  }
  
  public static String azk(String paramString)
  {
    AppMethodBeat.i(95099);
    paramString = "snsb_" + azv(paramString);
    AppMethodBeat.o(95099);
    return paramString;
  }
  
  public static String azl(String paramString)
  {
    AppMethodBeat.i(95102);
    paramString = "snsu_" + azv(paramString);
    AppMethodBeat.o(95102);
    return paramString;
  }
  
  public static String azm(String paramString)
  {
    AppMethodBeat.i(95111);
    paramString = "sns_tmpb_" + azv(paramString);
    AppMethodBeat.o(95111);
    return paramString;
  }
  
  public static String azn(String paramString)
  {
    AppMethodBeat.i(95113);
    paramString = "sns_tmpt_" + azv(paramString);
    AppMethodBeat.o(95113);
    return paramString;
  }
  
  public static String azo(String paramString)
  {
    AppMethodBeat.i(95116);
    paramString = "sns_tmps_" + azv(paramString);
    AppMethodBeat.o(95116);
    return paramString;
  }
  
  public static String azp(String paramString)
  {
    AppMethodBeat.i(95119);
    paramString = "9_".concat(String.valueOf(paramString));
    AppMethodBeat.o(95119);
    return paramString;
  }
  
  private static int azq(String paramString)
  {
    AppMethodBeat.i(219266);
    try
    {
      paramString = h.aRz(paramString);
      if (paramString == null)
      {
        AppMethodBeat.o(219266);
        return 0;
      }
      paramString = paramString.outMimeType;
      if (paramString == null)
      {
        AppMethodBeat.o(219266);
        return 0;
      }
      paramString = paramString.toLowerCase();
      int i = paramString.indexOf("png");
      if (i >= 0)
      {
        AppMethodBeat.o(219266);
        return 1;
      }
      if (paramString.indexOf("jpg") < 0)
      {
        i = paramString.indexOf("jpeg");
        if (i < 0) {}
      }
      else
      {
        AppMethodBeat.o(219266);
        return 2;
      }
      i = paramString.indexOf("wxam");
      if (i >= 0)
      {
        AppMethodBeat.o(219266);
        return 4;
      }
      i = paramString.indexOf("vcodec");
      if (i >= 0)
      {
        AppMethodBeat.o(219266);
        return 5;
      }
      AppMethodBeat.o(219266);
      return 0;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(219266);
    }
    return 0;
  }
  
  public static n azr(String paramString)
  {
    AppMethodBeat.i(95124);
    try
    {
      ae.i("MicroMsg.SnsUtil", "decodeFileToBlurThumbBitmap " + o.fB(paramString));
      boolean bool = o.fB(paramString);
      if (!bool)
      {
        AppMethodBeat.o(95124);
        return null;
      }
      paramString = azt(paramString);
      AppMethodBeat.o(95124);
      return paramString;
    }
    catch (Exception paramString)
    {
      ae.printErrStackTrace("MicroMsg.SnsUtil", paramString, "snsdecode error", new Object[0]);
      AppMethodBeat.o(95124);
    }
    return null;
  }
  
  /* Error */
  public static Bitmap azs(String paramString)
  {
    // Byte code:
    //   0: ldc_w 582
    //   3: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 563	com/tencent/mm/vfs/o:fB	(Ljava/lang/String;)Z
    //   10: istore 10
    //   12: iload 10
    //   14: ifne +11 -> 25
    //   17: ldc_w 582
    //   20: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aconst_null
    //   24: areturn
    //   25: aload_0
    //   26: invokestatic 545	com/tencent/mm/sdk/platformtools/h:aRz	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   29: astore 13
    //   31: aload 13
    //   33: ifnull +667 -> 700
    //   36: aload 13
    //   38: getfield 585	android/graphics/BitmapFactory$Options:outWidth	I
    //   41: istore 5
    //   43: aload 13
    //   45: getfield 588	android/graphics/BitmapFactory$Options:outHeight	I
    //   48: istore 6
    //   50: aload_0
    //   51: invokestatic 593	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$ExifHelper:df	(Ljava/lang/String;)I
    //   54: istore 7
    //   56: bipush 90
    //   58: iload 7
    //   60: if_icmpeq +646 -> 706
    //   63: sipush 270
    //   66: iload 7
    //   68: if_icmpne +621 -> 689
    //   71: goto +635 -> 706
    //   74: getstatic 48	com/tencent/mm/plugin/sns/data/r:zuB	I
    //   77: istore 5
    //   79: iload 7
    //   81: iload 8
    //   83: imul
    //   84: iload 5
    //   86: iload 5
    //   88: imul
    //   89: if_icmple +594 -> 683
    //   92: iload 8
    //   94: iload 7
    //   96: iconst_2
    //   97: imul
    //   98: if_icmple +430 -> 528
    //   101: ldc 106
    //   103: ldc_w 595
    //   106: invokestatic 597	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: iload 8
    //   111: iload 7
    //   113: idiv
    //   114: istore 9
    //   116: iload 9
    //   118: iconst_4
    //   119: if_icmpge +274 -> 393
    //   122: getstatic 603	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   125: sipush 1198
    //   128: iconst_0
    //   129: invokevirtual 607	com/tencent/mm/plugin/report/service/g:dD	(II)V
    //   132: getstatic 48	com/tencent/mm/plugin/sns/data/r:zuB	I
    //   135: istore 5
    //   137: iload 5
    //   139: iload 5
    //   141: imul
    //   142: iload 9
    //   144: idiv
    //   145: i2d
    //   146: invokestatic 613	java/lang/Math:sqrt	(D)D
    //   149: d2i
    //   150: istore 6
    //   152: iload 7
    //   154: iload 8
    //   156: if_icmple +580 -> 736
    //   159: iload 6
    //   161: istore 5
    //   163: iload 6
    //   165: iload 9
    //   167: imul
    //   168: istore 6
    //   170: iload 8
    //   172: i2d
    //   173: dconst_1
    //   174: dmul
    //   175: iload 5
    //   177: i2d
    //   178: ddiv
    //   179: dstore_1
    //   180: iload 7
    //   182: i2d
    //   183: dconst_1
    //   184: dmul
    //   185: iload 6
    //   187: i2d
    //   188: ddiv
    //   189: dstore_3
    //   190: dload_1
    //   191: dload_3
    //   192: dcmpg
    //   193: ifge +553 -> 746
    //   196: dload_3
    //   197: dstore_1
    //   198: goto +519 -> 717
    //   201: iload 6
    //   203: iconst_1
    //   204: if_icmple +361 -> 565
    //   207: ldc 106
    //   209: ldc_w 615
    //   212: iconst_3
    //   213: anewarray 4	java/lang/Object
    //   216: dup
    //   217: iconst_0
    //   218: iload 7
    //   220: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   223: aastore
    //   224: dup
    //   225: iconst_1
    //   226: iload 8
    //   228: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   231: aastore
    //   232: dup
    //   233: iconst_2
    //   234: iload 6
    //   236: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   239: aastore
    //   240: invokestatic 396	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   243: new 547	android/graphics/BitmapFactory$Options
    //   246: dup
    //   247: invokespecial 616	android/graphics/BitmapFactory$Options:<init>	()V
    //   250: astore 16
    //   252: invokestatic 619	com/tencent/mm/sdk/platformtools/h:fnS	()V
    //   255: aload 16
    //   257: iload 6
    //   259: putfield 622	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   262: aload_0
    //   263: invokestatic 626	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   266: astore 13
    //   268: invokestatic 629	com/tencent/mm/sdk/platformtools/bu:HQ	()J
    //   271: lstore 11
    //   273: ldc 106
    //   275: ldc_w 631
    //   278: iconst_1
    //   279: anewarray 4	java/lang/Object
    //   282: dup
    //   283: iconst_0
    //   284: aload 16
    //   286: getfield 622	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   289: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   292: aastore
    //   293: invokestatic 120	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   296: aload 13
    //   298: aconst_null
    //   299: aload 16
    //   301: invokestatic 637	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   304: astore 15
    //   306: lload 11
    //   308: invokestatic 641	com/tencent/mm/sdk/platformtools/bu:aO	(J)J
    //   311: lstore 11
    //   313: aload 16
    //   315: getfield 622	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   318: iconst_1
    //   319: if_icmple +29 -> 348
    //   322: ldc 106
    //   324: new 178	java/lang/StringBuilder
    //   327: dup
    //   328: ldc_w 643
    //   331: invokespecial 183	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   334: aload 16
    //   336: getfield 622	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   339: invokevirtual 300	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: invokevirtual 188	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 646	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   348: aload 15
    //   350: astore 14
    //   352: aload 15
    //   354: invokestatic 648	com/tencent/mm/plugin/sns/data/r:J	(Landroid/graphics/Bitmap;)Z
    //   357: ifeq +17 -> 374
    //   360: aload_0
    //   361: aload 15
    //   363: invokestatic 652	com/tencent/mm/plugin/sns/data/r:t	(Ljava/lang/String;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   366: astore 14
    //   368: aload_0
    //   369: lload 11
    //   371: invokestatic 658	com/tencent/mm/plugin/sns/j/c:bl	(Ljava/lang/String;J)V
    //   374: aload 13
    //   376: ifnull +8 -> 384
    //   379: aload 13
    //   381: invokevirtual 663	java/io/InputStream:close	()V
    //   384: ldc_w 582
    //   387: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   390: aload 14
    //   392: areturn
    //   393: iload 9
    //   395: iconst_5
    //   396: if_icmpge +38 -> 434
    //   399: getstatic 603	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   402: sipush 1198
    //   405: iconst_1
    //   406: invokevirtual 607	com/tencent/mm/plugin/report/service/g:dD	(II)V
    //   409: goto -277 -> 132
    //   412: astore_0
    //   413: ldc 106
    //   415: aload_0
    //   416: ldc_w 571
    //   419: iconst_0
    //   420: anewarray 4	java/lang/Object
    //   423: invokestatic 575	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   426: ldc_w 582
    //   429: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   432: aconst_null
    //   433: areturn
    //   434: iload 9
    //   436: bipush 6
    //   438: if_icmpge +16 -> 454
    //   441: getstatic 603	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   444: sipush 1198
    //   447: iconst_2
    //   448: invokevirtual 607	com/tencent/mm/plugin/report/service/g:dD	(II)V
    //   451: goto -319 -> 132
    //   454: iload 9
    //   456: bipush 7
    //   458: if_icmpge +16 -> 474
    //   461: getstatic 603	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   464: sipush 1198
    //   467: iconst_3
    //   468: invokevirtual 607	com/tencent/mm/plugin/report/service/g:dD	(II)V
    //   471: goto -339 -> 132
    //   474: iload 9
    //   476: bipush 8
    //   478: if_icmpge +16 -> 494
    //   481: getstatic 603	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   484: sipush 1198
    //   487: iconst_4
    //   488: invokevirtual 607	com/tencent/mm/plugin/report/service/g:dD	(II)V
    //   491: goto -359 -> 132
    //   494: iload 9
    //   496: bipush 9
    //   498: if_icmpge +16 -> 514
    //   501: getstatic 603	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   504: sipush 1198
    //   507: iconst_5
    //   508: invokevirtual 607	com/tencent/mm/plugin/report/service/g:dD	(II)V
    //   511: goto -379 -> 132
    //   514: getstatic 603	com/tencent/mm/plugin/report/service/g:yxI	Lcom/tencent/mm/plugin/report/service/g;
    //   517: sipush 1198
    //   520: bipush 6
    //   522: invokevirtual 607	com/tencent/mm/plugin/report/service/g:dD	(II)V
    //   525: goto -393 -> 132
    //   528: iload 7
    //   530: getstatic 48	com/tencent/mm/plugin/sns/data/r:zuB	I
    //   533: if_icmpgt +11 -> 544
    //   536: iload 8
    //   538: getstatic 48	com/tencent/mm/plugin/sns/data/r:zuB	I
    //   541: if_icmple +142 -> 683
    //   544: getstatic 48	com/tencent/mm/plugin/sns/data/r:zuB	I
    //   547: istore 5
    //   549: iload 7
    //   551: iload 8
    //   553: iload 5
    //   555: iload 5
    //   557: invokestatic 667	com/tencent/mm/sdk/platformtools/h:O	(IIII)I
    //   560: istore 5
    //   562: goto +159 -> 721
    //   565: ldc 106
    //   567: ldc_w 615
    //   570: iconst_3
    //   571: anewarray 4	java/lang/Object
    //   574: dup
    //   575: iconst_0
    //   576: iload 7
    //   578: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   581: aastore
    //   582: dup
    //   583: iconst_1
    //   584: iload 8
    //   586: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   589: aastore
    //   590: dup
    //   591: iconst_2
    //   592: iload 6
    //   594: invokestatic 114	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   597: aastore
    //   598: invokestatic 120	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   601: goto -358 -> 243
    //   604: astore 14
    //   606: aload 16
    //   608: aload 16
    //   610: getfield 622	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   613: iconst_1
    //   614: iadd
    //   615: putfield 622	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   618: aload 13
    //   620: ifnull -358 -> 262
    //   623: aload 13
    //   625: invokevirtual 663	java/io/InputStream:close	()V
    //   628: goto -366 -> 262
    //   631: astore 13
    //   633: goto -371 -> 262
    //   636: astore_0
    //   637: aload 13
    //   639: ifnull +8 -> 647
    //   642: aload 13
    //   644: invokevirtual 663	java/io/InputStream:close	()V
    //   647: ldc_w 582
    //   650: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   653: aload_0
    //   654: athrow
    //   655: astore_0
    //   656: goto -272 -> 384
    //   659: astore 13
    //   661: goto -14 -> 647
    //   664: astore_0
    //   665: goto -28 -> 637
    //   668: astore_0
    //   669: aconst_null
    //   670: astore 13
    //   672: goto -35 -> 637
    //   675: astore 13
    //   677: aconst_null
    //   678: astore 13
    //   680: goto -74 -> 606
    //   683: iconst_1
    //   684: istore 5
    //   686: goto +35 -> 721
    //   689: iload 5
    //   691: istore 7
    //   693: iload 6
    //   695: istore 8
    //   697: goto -623 -> 74
    //   700: iconst_1
    //   701: istore 6
    //   703: goto -460 -> 243
    //   706: iload 6
    //   708: istore 7
    //   710: iload 5
    //   712: istore 8
    //   714: goto -640 -> 74
    //   717: dload_1
    //   718: d2i
    //   719: istore 5
    //   721: iload 5
    //   723: istore 6
    //   725: iload 5
    //   727: ifgt -526 -> 201
    //   730: iconst_1
    //   731: istore 6
    //   733: goto -532 -> 201
    //   736: iload 9
    //   738: iload 6
    //   740: imul
    //   741: istore 5
    //   743: goto -573 -> 170
    //   746: goto -29 -> 717
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	749	0	paramString	String
    //   179	539	1	d1	double
    //   189	8	3	d2	double
    //   41	701	5	i	int
    //   48	693	6	j	int
    //   54	655	7	k	int
    //   81	632	8	m	int
    //   114	627	9	n	int
    //   10	3	10	bool	boolean
    //   271	99	11	l	long
    //   29	595	13	localObject1	Object
    //   631	12	13	localIOException1	java.io.IOException
    //   659	1	13	localIOException2	java.io.IOException
    //   670	1	13	localObject2	Object
    //   675	1	13	localOutOfMemoryError1	OutOfMemoryError
    //   678	1	13	localObject3	Object
    //   350	41	14	localBitmap1	Bitmap
    //   604	1	14	localOutOfMemoryError2	OutOfMemoryError
    //   304	58	15	localBitmap2	Bitmap
    //   250	359	16	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   6	12	412	java/lang/Exception
    //   25	31	412	java/lang/Exception
    //   36	56	412	java/lang/Exception
    //   74	79	412	java/lang/Exception
    //   101	116	412	java/lang/Exception
    //   122	132	412	java/lang/Exception
    //   132	152	412	java/lang/Exception
    //   170	190	412	java/lang/Exception
    //   207	243	412	java/lang/Exception
    //   243	262	412	java/lang/Exception
    //   379	384	412	java/lang/Exception
    //   399	409	412	java/lang/Exception
    //   441	451	412	java/lang/Exception
    //   461	471	412	java/lang/Exception
    //   481	491	412	java/lang/Exception
    //   501	511	412	java/lang/Exception
    //   514	525	412	java/lang/Exception
    //   528	544	412	java/lang/Exception
    //   544	562	412	java/lang/Exception
    //   565	601	412	java/lang/Exception
    //   623	628	412	java/lang/Exception
    //   642	647	412	java/lang/Exception
    //   647	655	412	java/lang/Exception
    //   268	348	604	java/lang/OutOfMemoryError
    //   352	374	604	java/lang/OutOfMemoryError
    //   623	628	631	java/io/IOException
    //   268	348	636	finally
    //   352	374	636	finally
    //   379	384	655	java/io/IOException
    //   642	647	659	java/io/IOException
    //   606	618	664	finally
    //   262	268	668	finally
    //   262	268	675	java/lang/OutOfMemoryError
  }
  
  public static n azt(String paramString)
  {
    AppMethodBeat.i(95126);
    try
    {
      boolean bool = o.fB(paramString);
      if (!bool)
      {
        AppMethodBeat.o(95126);
        return null;
      }
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      h.fnS();
      localOptions.inSampleSize = 1;
      for (;;)
      {
        int i = localOptions.inSampleSize;
        if (i > 10)
        {
          AppMethodBeat.o(95126);
          return null;
        }
        try
        {
          ae.i("MicroMsg.SnsUtil", "decodeFileToBitmap %s", new Object[] { Integer.valueOf(localOptions.inSampleSize) });
          long l = bu.HQ();
          n localn = com.tencent.mm.plugin.sns.d.a.c(paramString, localOptions);
          l = bu.aO(l);
          if (localn != null) {
            c.bl(paramString, l);
          }
          AppMethodBeat.o(95126);
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
      ae.printErrStackTrace("MicroMsg.SnsUtil", paramString, "snsdecode error", new Object[0]);
      AppMethodBeat.o(95126);
    }
  }
  
  public static String azu(String paramString)
  {
    AppMethodBeat.i(95127);
    paramString = new StringBuffer(paramString);
    while (paramString.length() < 25) {
      paramString.insert(0, "0");
    }
    paramString = paramString.toString();
    AppMethodBeat.o(95127);
    return paramString;
  }
  
  private static String azv(String paramString)
  {
    AppMethodBeat.i(95130);
    if (paramString == null)
    {
      AppMethodBeat.o(95130);
      return "";
    }
    int j = paramString.length();
    int i = 0;
    while ((i < j) && (paramString.charAt(i) == '0')) {
      i += 1;
    }
    paramString = paramString.substring(i);
    AppMethodBeat.o(95130);
    return paramString;
  }
  
  public static boolean azw(String paramString)
  {
    AppMethodBeat.i(95134);
    boolean bool = paramString.startsWith(b.asd());
    AppMethodBeat.o(95134);
    return bool;
  }
  
  public static boolean azx(String paramString)
  {
    AppMethodBeat.i(95135);
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      h.decodeFile(paramString, localOptions);
      int i = localOptions.outWidth;
      int j = localOptions.outHeight;
      if ((j >= i * 2) || (i >= j * 2))
      {
        AppMethodBeat.o(95135);
        return true;
      }
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.SnsUtil", "get error setImageExtInfo");
      AppMethodBeat.o(95135);
      return false;
    }
    AppMethodBeat.o(95135);
    return false;
  }
  
  public static boolean azy(String paramString)
  {
    AppMethodBeat.i(95136);
    int i = MAX_SIZE;
    int j;
    int k;
    try
    {
      paramString = h.aRz(paramString);
      j = paramString.outWidth;
      k = paramString.outHeight;
      if ((k <= 0) && (j <= 0))
      {
        AppMethodBeat.o(95136);
        return false;
      }
    }
    catch (Exception paramString)
    {
      ae.e("MicroMsg.SnsUtil", "get error setImageExtInfo");
      AppMethodBeat.o(95136);
      return false;
    }
    if ((k >= j * 2) || (j >= k * 2))
    {
      AppMethodBeat.o(95136);
      return false;
    }
    if (k * j > i)
    {
      AppMethodBeat.o(95136);
      return true;
    }
    AppMethodBeat.o(95136);
    return false;
  }
  
  public static long azz(String paramString)
  {
    long l1 = 0L;
    AppMethodBeat.i(163071);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(163071);
      return 0L;
    }
    try
    {
      long l2 = new BigInteger(paramString).longValue();
      l1 = l2;
      ae.i("MicroMsg.SnsUtil", "seq %s to snsId %d ", new Object[] { paramString, Long.valueOf(l2) });
      l1 = l2;
    }
    catch (Exception paramString)
    {
      label62:
      break label62;
    }
    AppMethodBeat.o(163071);
    return l1;
  }
  
  private static String b(bzh parambzh)
  {
    AppMethodBeat.i(95096);
    if (!bu.isNullOrNil(parambzh.Hmx))
    {
      parambzh = parambzh.Hmx;
      AppMethodBeat.o(95096);
      return parambzh;
    }
    String str = "";
    try
    {
      parambzh = com.tencent.mm.b.g.getMessageDigest(parambzh.toByteArray());
      AppMethodBeat.o(95096);
      return parambzh;
    }
    catch (Exception parambzh)
    {
      for (;;)
      {
        parambzh = str;
      }
    }
  }
  
  public static void b(View paramView, Context paramContext)
  {
    AppMethodBeat.i(95142);
    ViewGroup.LayoutParams localLayoutParams;
    int i;
    int k;
    if ((paramView != null) && (com.tencent.mm.cb.a.ef(paramContext) > 1.0F))
    {
      float f = com.tencent.mm.cb.a.ef(paramContext);
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
      AppMethodBeat.o(95142);
      return;
      label120:
      i = k;
    }
  }
  
  public static boolean b(n paramn)
  {
    AppMethodBeat.i(95122);
    if ((paramn == null) || (paramn.isRecycled()))
    {
      AppMethodBeat.o(95122);
      return false;
    }
    AppMethodBeat.o(95122);
    return true;
  }
  
  public static String bZ(int paramInt, String paramString)
  {
    AppMethodBeat.i(95094);
    paramString = paramInt + "-" + paramString;
    AppMethodBeat.o(95094);
    return paramString;
  }
  
  public static void bk(String paramString, long paramLong)
  {
    AppMethodBeat.i(95120);
    long l = System.currentTimeMillis();
    ae.d("MicroMsg.SnsUtil", " name " + paramString + " allTime " + (l - paramLong));
    AppMethodBeat.o(95120);
  }
  
  public static String c(bzh parambzh)
  {
    AppMethodBeat.i(95100);
    String str = "snsb_" + azv(parambzh.Id);
    if (parambzh.Hmv == 1)
    {
      parambzh = e.H(str + b(parambzh), parambzh.Hmw);
      AppMethodBeat.o(95100);
      return parambzh;
    }
    AppMethodBeat.o(95100);
    return str;
  }
  
  public static String ca(int paramInt, String paramString)
  {
    AppMethodBeat.i(95118);
    paramString = paramInt + "-" + paramString;
    AppMethodBeat.o(95118);
    return paramString;
  }
  
  public static String d(bzh parambzh)
  {
    AppMethodBeat.i(95101);
    String str = "snst_" + azv(parambzh.Id);
    if (parambzh.Hmv == 1)
    {
      parambzh = e.H(str + b(parambzh), parambzh.Hmw);
      AppMethodBeat.o(95101);
      return parambzh;
    }
    AppMethodBeat.o(95101);
    return str;
  }
  
  public static int dWm()
  {
    AppMethodBeat.i(95138);
    int i = ak.getContext().getSharedPreferences(ak.fow(), 0).getInt("sns_control_flag", 0);
    AppMethodBeat.o(95138);
    return i;
  }
  
  public static int dWn()
  {
    AppMethodBeat.i(95140);
    int i = ak.getContext().getSharedPreferences(ak.fow(), 0).getInt("sns_respone_count", 20);
    AppMethodBeat.o(95140);
    return i;
  }
  
  public static int dWo()
  {
    AppMethodBeat.i(95143);
    Context localContext = ak.getContext();
    if (az.is2G(localContext))
    {
      AppMethodBeat.o(95143);
      return 1;
    }
    if (az.is3G(localContext))
    {
      AppMethodBeat.o(95143);
      return 2;
    }
    if (az.is4G(localContext))
    {
      AppMethodBeat.o(95143);
      return 3;
    }
    if (az.isWifi(localContext))
    {
      AppMethodBeat.o(95143);
      return 4;
    }
    AppMethodBeat.o(95143);
    return 0;
  }
  
  public static String dWp()
  {
    AppMethodBeat.i(95161);
    if (bu.isNullOrNil(zuD))
    {
      long l = ch.aDb();
      localObject = new StringBuilder();
      com.tencent.mm.kernel.g.ajP();
      zuD = com.tencent.mm.kernel.a.aiF() + "_" + l;
    }
    Object localObject = zuD;
    AppMethodBeat.o(95161);
    return localObject;
  }
  
  public static void dWq()
  {
    zuD = "";
  }
  
  public static String dWr()
  {
    String str = zuE;
    zuE = "";
    return str;
  }
  
  public static String e(bzh parambzh)
  {
    AppMethodBeat.i(95103);
    String str = "snsu_" + azv(parambzh.Id);
    if (parambzh.Hmv == 1)
    {
      parambzh = e.H(str + b(parambzh), parambzh.Hmw);
      AppMethodBeat.o(95103);
      return parambzh;
    }
    AppMethodBeat.o(95103);
    return str;
  }
  
  public static void e(long[] paramArrayOfLong)
  {
    AppMethodBeat.i(95153);
    try
    {
      if (nQa == null) {
        nQa = (Vibrator)ak.getContext().getSystemService("vibrator");
      }
      nQa.vibrate(paramArrayOfLong, -1);
      AppMethodBeat.o(95153);
      return;
    }
    catch (Exception paramArrayOfLong)
    {
      ae.printErrStackTrace("MicroMsg.SnsUtil", paramArrayOfLong, "vibrate error!", new Object[0]);
      AppMethodBeat.o(95153);
    }
  }
  
  public static String f(bzh parambzh)
  {
    AppMethodBeat.i(95104);
    String str = "snsblurt_" + azv(parambzh.Id);
    if (parambzh.Hmv == 1)
    {
      parambzh = e.H(str + b(parambzh), parambzh.Hmw);
      AppMethodBeat.o(95104);
      return parambzh;
    }
    AppMethodBeat.o(95104);
    return str;
  }
  
  public static String fQ(List<bzh> paramList)
  {
    AppMethodBeat.i(95095);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(95095);
      return "";
    }
    Object localObject = "";
    Iterator localIterator = paramList.iterator();
    int i = 0;
    paramList = (List<bzh>)localObject;
    for (;;)
    {
      localObject = paramList;
      if (localIterator.hasNext())
      {
        bzh localbzh = (bzh)localIterator.next();
        localObject = paramList;
        if (paramList.length() > 0) {
          localObject = paramList + "-";
        }
        paramList = (String)localObject + localbzh.Id;
        i += 1;
        if (i >= 4) {
          localObject = paramList;
        }
      }
      else
      {
        AppMethodBeat.o(95095);
        return localObject;
      }
    }
  }
  
  public static String fR(List<PointF> paramList)
  {
    AppMethodBeat.i(95152);
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
    AppMethodBeat.o(95152);
    return paramList;
  }
  
  public static String g(bzh parambzh)
  {
    AppMethodBeat.i(95105);
    String str = "snsblurs_" + azv(parambzh.Id);
    if (parambzh.Hmv == 1)
    {
      parambzh = e.H(str + b(parambzh), parambzh.Hmw);
      AppMethodBeat.o(95105);
      return parambzh;
    }
    AppMethodBeat.o(95105);
    return str;
  }
  
  public static void g(Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(95155);
    String str2 = e.m.JpH;
    if (paramString == null) {}
    for (String str1 = "";; str1 = paramString)
    {
      paramIntent.putExtra(str2, str1);
      ae.i("MicroMsg.SnsUtil", "appendAdUxInfoForAdPay, uxInfo=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(95155);
      return;
    }
  }
  
  public static String h(bzh parambzh)
  {
    AppMethodBeat.i(95106);
    String str = "snstblur_src_" + azv(parambzh.Id);
    if (parambzh.Hmv == 1)
    {
      parambzh = e.H(str + b(parambzh), parambzh.Hmw);
      AppMethodBeat.o(95106);
      return parambzh;
    }
    AppMethodBeat.o(95106);
    return str;
  }
  
  public static String i(bzh parambzh)
  {
    AppMethodBeat.i(95107);
    String str = "sight_" + azv(parambzh.Id);
    if (parambzh.Hmv == 1)
    {
      parambzh = e.H(str + b(parambzh), parambzh.Hmw);
      AppMethodBeat.o(95107);
      return parambzh;
    }
    AppMethodBeat.o(95107);
    return str;
  }
  
  public static String j(bzh parambzh)
  {
    AppMethodBeat.i(95108);
    String str = "sightad_" + azv(parambzh.Id);
    if (parambzh.Hmv == 1)
    {
      parambzh = e.H(str, parambzh.Hmw);
      AppMethodBeat.o(95108);
      return parambzh;
    }
    AppMethodBeat.o(95108);
    return str;
  }
  
  public static String jo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(95154);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      ae.e("MicroMsg.SnsUtil", "appendAdUxInfo empty:" + paramString1 + ", " + paramString2);
      AppMethodBeat.o(95154);
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
        ae.e("MicroMsg.SnsUtil", "appendAdUxInfo exp:" + localException.toString() + ", " + paramString2);
        paramString2 = str1;
      }
    }
    paramString1 = ay(paramString1, "uxinfo", paramString2);
    ae.i("MicroMsg.SnsUtil", "appendAdUxInfo, ret=".concat(String.valueOf(paramString1)));
    AppMethodBeat.o(95154);
    return paramString1;
  }
  
  public static String k(bzh parambzh)
  {
    AppMethodBeat.i(95109);
    String str = "snsb_" + azv(parambzh.Id);
    if (parambzh.Hmv == 1)
    {
      parambzh = e.H(str + b(parambzh), parambzh.Hmw);
      AppMethodBeat.o(95109);
      return parambzh;
    }
    AppMethodBeat.o(95109);
    return str;
  }
  
  public static String l(bzh parambzh)
  {
    AppMethodBeat.i(95110);
    String str = "sns_tmpb_" + azv(parambzh.Id);
    if (parambzh.Hmv == 1)
    {
      parambzh = e.H(str + b(parambzh), parambzh.Hmw);
      AppMethodBeat.o(95110);
      return parambzh;
    }
    AppMethodBeat.o(95110);
    return str;
  }
  
  public static String m(bzh parambzh)
  {
    AppMethodBeat.i(95112);
    String str = "sns_tmpt_" + azv(parambzh.Id);
    if (parambzh.Hmv == 1)
    {
      parambzh = e.H(str + b(parambzh), parambzh.Hmw);
      AppMethodBeat.o(95112);
      return parambzh;
    }
    AppMethodBeat.o(95112);
    return str;
  }
  
  public static String n(bzh parambzh)
  {
    AppMethodBeat.i(95114);
    String str = "sns_tmpu_" + azv(parambzh.Id);
    if (parambzh.Hmv == 1)
    {
      parambzh = e.H(str + b(parambzh), parambzh.Hmw);
      AppMethodBeat.o(95114);
      return parambzh;
    }
    AppMethodBeat.o(95114);
    return str;
  }
  
  public static boolean n(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    return (paramp.field_type == 3) || (paramp.field_type == 4) || (paramp.field_type == 5) || (paramp.field_type == 6) || (paramp.field_type == 9) || (paramp.field_type == 10) || (paramp.field_type == 11) || (paramp.field_type == 12) || (paramp.field_type == 13) || (paramp.field_type == 14) || (paramp.field_type == 17) || (paramp.field_type == 22) || (paramp.field_type == 23);
  }
  
  public static String o(com.tencent.mm.plugin.sns.storage.p paramp)
  {
    AppMethodBeat.i(95146);
    if (paramp == null)
    {
      AppMethodBeat.o(95146);
      return "0";
    }
    paramp = zV(paramp.field_snsId);
    AppMethodBeat.o(95146);
    return paramp;
  }
  
  public static String o(bzh parambzh)
  {
    AppMethodBeat.i(95115);
    String str = "sns_tmps_" + azv(parambzh.Id);
    if (parambzh.Hmv == 1)
    {
      parambzh = e.H(str + b(parambzh), parambzh.Hmw);
      AppMethodBeat.o(95115);
      return parambzh;
    }
    AppMethodBeat.o(95115);
    return str;
  }
  
  public static String p(bzh parambzh)
  {
    AppMethodBeat.i(95117);
    String str = "sns_tmpsad_" + azv(parambzh.Id);
    if (parambzh.Hmv == 1)
    {
      parambzh = e.H(str + b(parambzh), parambzh.Hmw);
      AppMethodBeat.o(95117);
      return parambzh;
    }
    AppMethodBeat.o(95117);
    return str;
  }
  
  public static void rr(boolean paramBoolean)
  {
    AppMethodBeat.i(95151);
    uc localuc = new uc();
    localuc.dJF.enable = paramBoolean;
    com.tencent.mm.sdk.b.a.IvT.l(localuc);
    AppMethodBeat.o(95151);
  }
  
  public static Bitmap t(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(95123);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(95123);
      return null;
    }
    String str;
    if (bu.isNullOrNil(paramString)) {
      str = "";
    }
    int i;
    while (bu.isNullOrNil(str))
    {
      AppMethodBeat.o(95123);
      return paramBitmap;
      i = paramString.lastIndexOf(zux);
      if ((i > 0) && (i + 1 < paramString.length()))
      {
        str = paramString.substring(i + 1);
        if ((str.startsWith(zuy)) || (str.startsWith("sns_tmpb_")))
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
        ae.i("MicroMsg.SnsUtil", "[changes below by tomys]parsing jpg, path: %s, size: %s", new Object[] { paramString, Long.valueOf(o.aZR(paramString)) });
        paramString = Exif.fromFile(paramString);
        if (paramString == null) {
          break label246;
        }
        i = paramString.getOrientationInDegree() % 360;
      }
      catch (Exception paramString)
      {
        ae.printErrStackTrace("MicroMsg.SnsUtil", paramString, "Failed parsing JPEG file: ".concat(String.valueOf(str)), new Object[0]);
        i = 0;
        continue;
      }
      finally
      {
        AppMethodBeat.o(95123);
      }
      ae.d("MicroMsg.SnsUtil", "exifPath : %s degree : %d", new Object[] { str, Integer.valueOf(i) });
      paramString = h.a(paramBitmap, i);
      AppMethodBeat.o(95123);
      return paramString;
      label246:
      i = 0;
    }
  }
  
  public static Bitmap v(List<n> paramList, int paramInt)
  {
    AppMethodBeat.i(95133);
    Object localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (!b((n)((Iterator)localObject1).next()))
      {
        AppMethodBeat.o(95133);
        return null;
      }
    }
    if (paramInt <= 0)
    {
      AppMethodBeat.o(95133);
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
      localObject3 = ((n)paramList.get(paramInt)).ayV();
      localRect = (Rect)localLinkedList.get(paramInt);
      switch (paramList.size())
      {
      default: 
        localObject1 = al((Bitmap)localObject3);
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
      localObject1 = al((Bitmap)localObject3);
      continue;
      localObject1 = ak((Bitmap)localObject3);
      continue;
      if (paramInt == 0) {
        localObject1 = ak((Bitmap)localObject3);
      } else {
        localObject1 = al((Bitmap)localObject3);
      }
    }
    label509:
    ((Canvas)localObject2).save();
    ((Canvas)localObject2).restore();
    AppMethodBeat.o(95133);
    return localBitmap;
  }
  
  public static String zV(long paramLong)
  {
    AppMethodBeat.i(95128);
    String str = new BigInteger(Long.toBinaryString(paramLong), 2).toString();
    AppMethodBeat.o(95128);
    return str;
  }
  
  public static String zW(long paramLong)
  {
    AppMethodBeat.i(95129);
    if (paramLong == 0L)
    {
      AppMethodBeat.o(95129);
      return "";
    }
    String str = azu(new BigInteger(Long.toBinaryString(paramLong), 2).toString());
    AppMethodBeat.o(95129);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.data.r
 * JD-Core Version:    0.7.0.1
 */