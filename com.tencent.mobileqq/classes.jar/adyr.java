import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.media.ThumbnailUtils;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.JpegExifReader;
import com.tencent.image.LocaleFileDownloader;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.SafeBitmapFactory.SafeDecodeOption;
import com.tencent.image.SliceBitmap;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.VideoDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

public class adyr
  extends LocaleFileDownloader
{
  private float jdField_a_of_type_Float;
  private BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  
  public adyr(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
    this.jdField_a_of_type_Float = paramBaseApplicationImpl.getResources().getDisplayMetrics().density;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (((paramInt6 == 2) || (paramInt3 == 2147483647) || (paramInt4 == 2147483647)) && (paramInt1 * paramInt2 <= this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().widthPixels * this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources().getDisplayMetrics().heightPixels * 4))
    {
      paramInt2 = 1;
      return paramInt2;
    }
    float f;
    if (paramInt6 == 1) {
      switch (paramInt5)
      {
      default: 
        paramInt5 = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = paramInt5;
        paramInt6 = paramInt1;
        paramInt5 = paramInt2;
        if (paramInt2 > paramInt3 * 2)
        {
          paramInt6 = paramInt1;
          paramInt5 = paramInt2;
          if (paramInt1 > paramInt4)
          {
            paramInt5 = (int)(paramInt2 * this.jdField_a_of_type_Float + 0.5D);
            paramInt6 = (int)(paramInt1 * this.jdField_a_of_type_Float + 0.5D);
          }
        }
        paramInt1 = paramInt6 * paramInt3 / paramInt5;
        if (paramInt5 >= paramInt3) {
          if (paramInt4 >= paramInt1) {
            f = paramInt3 / paramInt5;
          }
        }
        break;
      }
    }
    for (;;)
    {
      label187:
      if (this.jdField_a_of_type_Float > 2.0F) {}
      for (paramInt1 = (int)(1.0F / f * 3.0F / 4.0F);; paramInt1 = (int)(1.0F / f))
      {
        if (paramInt1 > 1) {
          break label355;
        }
        return 1;
        break;
        if (paramInt4 * 1.5F >= paramInt1)
        {
          f = paramInt4 / paramInt6;
          break label187;
        }
        f = paramInt3 / paramInt5;
        break label187;
        if (paramInt6 < paramInt4)
        {
          if (paramInt4 >= paramInt1)
          {
            if (paramInt5 * 1.5F < paramInt3) {
              break label517;
            }
            f = paramInt3 / paramInt5;
            break label187;
          }
          if (paramInt6 * 1.5F < paramInt4) {
            break label517;
          }
          f = paramInt4 / paramInt6;
          break label187;
        }
        if ((paramInt6 <= paramInt4) || (paramInt6 >= paramInt4 * 1.5F)) {
          break label517;
        }
        f = paramInt4 / paramInt6;
        break label187;
      }
      label355:
      if (paramInt1 > 64)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PEAK", 2, "the pic it fxxking large.....");
        }
        return 64;
      }
      paramInt3 = 64;
      for (;;)
      {
        if (paramInt3 == 0) {
          break label405;
        }
        paramInt4 = paramInt1 & paramInt3;
        paramInt2 = paramInt4;
        if (paramInt4 != 0) {
          break;
        }
        paramInt3 >>= 1;
      }
      label405:
      return 1;
      if ((paramInt3 == 0) || (paramInt4 == 0) || (paramInt3 == -1) || (paramInt4 == -1)) {
        return 1;
      }
      int i = 1;
      paramInt5 = paramInt2;
      paramInt6 = paramInt1;
      paramInt1 = i;
      label441:
      if (paramInt5 <= paramInt4)
      {
        paramInt2 = paramInt1;
        if (paramInt6 <= paramInt3) {
          break;
        }
      }
      i = Math.round(paramInt5 / paramInt4);
      paramInt2 = Math.round(paramInt6 / paramInt3);
      if (i > paramInt2) {}
      for (;;)
      {
        paramInt2 = paramInt1;
        if (i < 2) {
          break;
        }
        paramInt6 /= 2;
        paramInt5 /= 2;
        paramInt1 *= 2;
        break label441;
        i = paramInt2;
      }
      label517:
      f = 1.0F;
    }
  }
  
  private RoundRectBitmap a(Bitmap paramBitmap, int paramInt)
  {
    try
    {
      RoundRectBitmap localRoundRectBitmap = new RoundRectBitmap(paramBitmap, paramInt);
      return localRoundRectBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return new RoundRectBitmap(paramBitmap, 12.0F);
  }
  
  private Object a(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    int i = 0;
    if (paramDownloadParams.tag != null) {
      i = ((Integer)paramDownloadParams.tag).intValue();
    }
    if (i == 3)
    {
      paramURLDrawableHandler = ThumbnailUtils.createVideoThumbnail(paramFile.getAbsolutePath(), 1);
      int j = paramURLDrawableHandler.getWidth();
      i = paramURLDrawableHandler.getHeight();
      float f = Gallery.a(j, i, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, null);
      j = (int)(j * f);
      i = (int)(i * f);
      return ThumbnailUtils.createVideoThumbnail(paramFile.getAbsolutePath(), 1);
    }
    return null;
  }
  
  /* Error */
  private Object a(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    // Byte code:
    //   0: new 128	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 131	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore 18
    //   10: aconst_null
    //   11: astore 15
    //   13: iconst_0
    //   14: istore 6
    //   16: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   19: lstore 10
    //   21: iconst_2
    //   22: newarray byte
    //   24: astore 16
    //   26: aload 18
    //   28: aload 16
    //   30: invokevirtual 141	java/io/FileInputStream:read	([B)I
    //   33: pop
    //   34: aload 16
    //   36: iconst_0
    //   37: baload
    //   38: istore 8
    //   40: aload 16
    //   42: iconst_1
    //   43: baload
    //   44: istore 9
    //   46: getstatic 147	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   49: astore_3
    //   50: iconst_0
    //   51: istore 5
    //   53: iconst_0
    //   54: istore 7
    //   56: iload 8
    //   58: bipush 8
    //   60: ishl
    //   61: ldc 148
    //   63: iand
    //   64: iload 9
    //   66: sipush 255
    //   69: iand
    //   70: ior
    //   71: lookupswitch	default:+790->861, 8273:+494->565, 16973:+494->565, 18249:+501->572, 18761:+491->562, 19789:+491->562, 65496:+491->562
    //   129: invokevirtual 151	java/io/File:length	()J
    //   132: l2i
    //   133: newarray byte
    //   135: astore 20
    //   137: aload 16
    //   139: iconst_0
    //   140: aload 20
    //   142: iconst_0
    //   143: aload 16
    //   145: arraylength
    //   146: invokestatic 157	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   149: aload 18
    //   151: aload 20
    //   153: aload 16
    //   155: arraylength
    //   156: aload 18
    //   158: invokevirtual 160	java/io/FileInputStream:available	()I
    //   161: invokevirtual 163	java/io/FileInputStream:read	([BII)I
    //   164: pop
    //   165: aload 18
    //   167: invokevirtual 166	java/io/FileInputStream:close	()V
    //   170: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq +37 -> 210
    //   176: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   179: lstore 12
    //   181: ldc 56
    //   183: iconst_2
    //   184: new 168	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   191: ldc 171
    //   193: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: lload 12
    //   198: lload 10
    //   200: lsub
    //   201: invokevirtual 178	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   204: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   210: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   213: lstore 10
    //   215: new 183	android/graphics/BitmapFactory$Options
    //   218: dup
    //   219: invokespecial 184	android/graphics/BitmapFactory$Options:<init>	()V
    //   222: astore 19
    //   224: aload 19
    //   226: iconst_1
    //   227: putfield 188	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   230: aload 19
    //   232: aload_3
    //   233: putfield 191	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   236: aload 19
    //   238: sipush 160
    //   241: putfield 194	android/graphics/BitmapFactory$Options:inDensity	I
    //   244: aload 19
    //   246: sipush 160
    //   249: putfield 197	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   252: aload 19
    //   254: sipush 160
    //   257: putfield 200	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   260: aload 19
    //   262: iconst_1
    //   263: putfield 203	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   266: aload 19
    //   268: iconst_1
    //   269: putfield 206	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   272: aload 20
    //   274: iconst_0
    //   275: aload 20
    //   277: arraylength
    //   278: aload 19
    //   280: invokestatic 212	com/tencent/image/SafeBitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   283: pop
    //   284: aload 19
    //   286: getfield 215	android/graphics/BitmapFactory$Options:outWidth	I
    //   289: istore 6
    //   291: aload 19
    //   293: getfield 218	android/graphics/BitmapFactory$Options:outHeight	I
    //   296: istore 7
    //   298: iload 5
    //   300: ifeq +279 -> 579
    //   303: aload_2
    //   304: aload_1
    //   305: invokevirtual 96	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   308: invokestatic 224	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   311: putfield 227	com/tencent/image/DownloadParams:outOrientation	I
    //   314: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   317: ifeq +37 -> 354
    //   320: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   323: lstore 12
    //   325: ldc 56
    //   327: iconst_2
    //   328: new 168	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   335: ldc 229
    //   337: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: lload 12
    //   342: lload 10
    //   344: lsub
    //   345: invokevirtual 178	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   348: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: aload 19
    //   356: iconst_0
    //   357: putfield 188	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   360: aload_0
    //   361: iload 6
    //   363: iload 7
    //   365: aload_2
    //   366: getfield 113	com/tencent/image/DownloadParams:reqWidth	I
    //   369: aload_2
    //   370: getfield 116	com/tencent/image/DownloadParams:reqHeight	I
    //   373: aload_2
    //   374: getfield 227	com/tencent/image/DownloadParams:outOrientation	I
    //   377: iload 4
    //   379: invokespecial 231	adyr:a	(IIIIII)I
    //   382: istore 4
    //   384: aload 19
    //   386: iload 4
    //   388: putfield 234	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   391: aload 20
    //   393: iconst_0
    //   394: aload 20
    //   396: arraylength
    //   397: aload 19
    //   399: invokestatic 212	com/tencent/image/SafeBitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   402: astore 16
    //   404: aload 16
    //   406: sipush 160
    //   409: invokevirtual 238	android/graphics/Bitmap:setDensity	(I)V
    //   412: aload 16
    //   414: invokestatic 244	com/tencent/image/SliceBitmap:needSliceBitmap	(Landroid/graphics/Bitmap;)Z
    //   417: istore 14
    //   419: iload 14
    //   421: ifeq +321 -> 742
    //   424: new 240	com/tencent/image/SliceBitmap
    //   427: dup
    //   428: aload 16
    //   430: invokespecial 247	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   433: astore_3
    //   434: aload 16
    //   436: invokevirtual 250	android/graphics/Bitmap:recycle	()V
    //   439: aload 19
    //   441: getfield 234	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   444: iconst_1
    //   445: if_icmple +44 -> 489
    //   448: aload_2
    //   449: getfield 253	com/tencent/image/DownloadParams:mAutoScaleByDensity	Z
    //   452: ifeq +371 -> 823
    //   455: aload_2
    //   456: iload 6
    //   458: i2f
    //   459: aload_0
    //   460: getfield 33	adyr:jdField_a_of_type_Float	F
    //   463: fmul
    //   464: f2d
    //   465: invokestatic 257	java/lang/Math:ceil	(D)D
    //   468: d2i
    //   469: putfield 258	com/tencent/image/DownloadParams:outWidth	I
    //   472: aload_2
    //   473: iload 7
    //   475: i2f
    //   476: aload_0
    //   477: getfield 33	adyr:jdField_a_of_type_Float	F
    //   480: fmul
    //   481: f2d
    //   482: invokestatic 257	java/lang/Math:ceil	(D)D
    //   485: d2i
    //   486: putfield 259	com/tencent/image/DownloadParams:outHeight	I
    //   489: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   492: ifeq +68 -> 560
    //   495: ldc 56
    //   497: iconst_2
    //   498: new 168	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   505: ldc_w 261
    //   508: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_1
    //   512: invokevirtual 151	java/io/File:length	()J
    //   515: invokevirtual 178	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   518: ldc_w 263
    //   521: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: iload 6
    //   526: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   529: ldc_w 268
    //   532: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: iload 7
    //   537: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   540: ldc_w 270
    //   543: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: aload 19
    //   548: getfield 234	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   551: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   554: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   560: aload_3
    //   561: areturn
    //   562: iconst_1
    //   563: istore 5
    //   565: getstatic 273	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   568: astore_3
    //   569: goto -441 -> 128
    //   572: aload 18
    //   574: invokevirtual 166	java/io/FileInputStream:close	()V
    //   577: aconst_null
    //   578: areturn
    //   579: aload_1
    //   580: invokevirtual 96	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   583: invokestatic 279	agja:c	(Ljava/lang/String;)Z
    //   586: ifeq -272 -> 314
    //   589: aload_2
    //   590: aload_1
    //   591: invokevirtual 96	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   594: invokestatic 284	com/tencent/image/Utils:getHeifOrientation	(Ljava/lang/String;)I
    //   597: putfield 227	com/tencent/image/DownloadParams:outOrientation	I
    //   600: goto -286 -> 314
    //   603: astore_1
    //   604: iconst_1
    //   605: istore 4
    //   607: iload 4
    //   609: ifne +8 -> 617
    //   612: aload 18
    //   614: invokevirtual 166	java/io/FileInputStream:close	()V
    //   617: aload_1
    //   618: athrow
    //   619: astore_3
    //   620: aload 16
    //   622: ifnull +8 -> 630
    //   625: aload 16
    //   627: invokevirtual 250	android/graphics/Bitmap:recycle	()V
    //   630: new 71	java/lang/OutOfMemoryError
    //   633: dup
    //   634: ldc_w 286
    //   637: invokespecial 289	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   640: athrow
    //   641: astore_3
    //   642: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   645: ifeq +69 -> 714
    //   648: ldc 56
    //   650: iconst_2
    //   651: new 168	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   658: ldc_w 291
    //   661: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: iconst_1
    //   665: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   668: ldc_w 293
    //   671: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: aload 19
    //   676: getfield 234	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   679: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   682: ldc_w 295
    //   685: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: aload_2
    //   689: getfield 299	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   692: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: ldc_w 301
    //   698: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: aload_3
    //   702: invokevirtual 304	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   705: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   711: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   714: iload 4
    //   716: iconst_2
    //   717: imul
    //   718: istore 4
    //   720: invokestatic 307	java/lang/System:gc	()V
    //   723: invokestatic 312	java/lang/Thread:yield	()V
    //   726: invokestatic 307	java/lang/System:gc	()V
    //   729: aload 15
    //   731: astore_3
    //   732: iload 4
    //   734: bipush 8
    //   736: if_icmple -297 -> 439
    //   739: goto -355 -> 384
    //   742: aload_2
    //   743: getfield 315	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   746: ifnull +122 -> 868
    //   749: ldc_w 317
    //   752: aload_2
    //   753: getfield 315	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   756: invokevirtual 323	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   759: ifeq +109 -> 868
    //   762: aload_2
    //   763: getfield 315	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   766: checkcast 317	adys
    //   769: astore_3
    //   770: aload_3
    //   771: getfield 325	adys:a	I
    //   774: ifle +82 -> 856
    //   777: aload_0
    //   778: aload 16
    //   780: aload_3
    //   781: getfield 325	adys:a	I
    //   784: invokespecial 327	adyr:a	(Landroid/graphics/Bitmap;I)Lcom/tencent/image/RoundRectBitmap;
    //   787: astore 17
    //   789: aload 17
    //   791: astore_3
    //   792: aload 17
    //   794: getfield 331	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   797: aload 16
    //   799: invokevirtual 336	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   802: ifne -363 -> 439
    //   805: aload 16
    //   807: invokevirtual 250	android/graphics/Bitmap:recycle	()V
    //   810: aload 17
    //   812: astore_3
    //   813: goto -374 -> 439
    //   816: astore_1
    //   817: aload_1
    //   818: invokevirtual 339	java/lang/NullPointerException:printStackTrace	()V
    //   821: aconst_null
    //   822: areturn
    //   823: aload_2
    //   824: iload 6
    //   826: i2d
    //   827: invokestatic 257	java/lang/Math:ceil	(D)D
    //   830: d2i
    //   831: putfield 258	com/tencent/image/DownloadParams:outWidth	I
    //   834: aload_2
    //   835: iload 7
    //   837: i2d
    //   838: invokestatic 257	java/lang/Math:ceil	(D)D
    //   841: d2i
    //   842: putfield 259	com/tencent/image/DownloadParams:outHeight	I
    //   845: goto -356 -> 489
    //   848: astore_1
    //   849: iload 6
    //   851: istore 4
    //   853: goto -246 -> 607
    //   856: aconst_null
    //   857: astore_3
    //   858: goto -419 -> 439
    //   861: iload 7
    //   863: istore 5
    //   865: goto -737 -> 128
    //   868: aload 16
    //   870: astore_3
    //   871: goto -432 -> 439
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	874	0	this	adyr
    //   0	874	1	paramFile	File
    //   0	874	2	paramDownloadParams	DownloadParams
    //   0	874	3	paramURLDrawableHandler	URLDrawableHandler
    //   0	874	4	paramInt	int
    //   51	813	5	i	int
    //   14	836	6	j	int
    //   54	808	7	k	int
    //   38	23	8	m	int
    //   44	26	9	n	int
    //   19	324	10	l1	long
    //   179	162	12	l2	long
    //   417	3	14	bool	boolean
    //   11	719	15	localObject1	Object
    //   24	845	16	localObject2	Object
    //   787	24	17	localRoundRectBitmap	RoundRectBitmap
    //   8	605	18	localFileInputStream	FileInputStream
    //   222	453	19	localOptions	BitmapFactory.Options
    //   135	260	20	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   170	210	603	finally
    //   210	298	603	finally
    //   303	314	603	finally
    //   314	354	603	finally
    //   354	384	603	finally
    //   384	419	603	finally
    //   424	439	603	finally
    //   439	489	603	finally
    //   489	560	603	finally
    //   579	600	603	finally
    //   625	630	603	finally
    //   630	641	603	finally
    //   642	714	603	finally
    //   720	729	603	finally
    //   742	789	603	finally
    //   792	810	603	finally
    //   817	821	603	finally
    //   823	845	603	finally
    //   424	439	619	java/lang/Exception
    //   384	419	641	java/lang/OutOfMemoryError
    //   424	439	641	java/lang/OutOfMemoryError
    //   625	630	641	java/lang/OutOfMemoryError
    //   630	641	641	java/lang/OutOfMemoryError
    //   742	789	641	java/lang/OutOfMemoryError
    //   792	810	641	java/lang/OutOfMemoryError
    //   384	419	816	java/lang/NullPointerException
    //   424	439	816	java/lang/NullPointerException
    //   625	630	816	java/lang/NullPointerException
    //   630	641	816	java/lang/NullPointerException
    //   742	789	816	java/lang/NullPointerException
    //   792	810	816	java/lang/NullPointerException
    //   16	34	848	finally
    //   46	50	848	finally
    //   128	170	848	finally
    //   565	569	848	finally
  }
  
  private Object b(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    paramURLDrawableHandler = new FileInputStream(paramFile);
    Object localObject2 = null;
    try
    {
      localObject1 = new byte[2];
      paramURLDrawableHandler.read((byte[])localObject1);
      k = localObject1[0];
      m = localObject1[1];
      paramURLDrawableHandler.close();
      localObject1 = new FileInputStream(paramFile);
    }
    finally
    {
      for (;;)
      {
        int k;
        int m;
        label132:
        BitmapFactory.Options localOptions;
        paramDownloadParams = paramURLDrawableHandler;
        paramInt = 0;
      }
    }
    try
    {
      paramURLDrawableHandler = Bitmap.Config.ARGB_8888;
      i = 0;
      j = 0;
      switch (k << 8 & 0xFF00 | m & 0xFF)
      {
      }
    }
    finally
    {
      paramInt = 0;
      paramDownloadParams = (DownloadParams)localObject1;
      break label807;
      paramURLDrawableHandler = null;
      break label453;
      i = j;
      break label132;
    }
    localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inPreferredConfig = paramURLDrawableHandler;
    localOptions.inDensity = 160;
    localOptions.inTargetDensity = 160;
    localOptions.inScreenDensity = 160;
    SafeBitmapFactory.decodeStream((InputStream)localObject1, null, localOptions);
    j = localOptions.outWidth;
    k = localOptions.outHeight;
    ((InputStream)localObject1).close();
    if (i != 0) {}
    for (;;)
    {
      try
      {
        Bitmap localBitmap;
        for (;;)
        {
          paramDownloadParams.outOrientation = JpegExifReader.readOrientation(paramFile.getAbsolutePath());
          localOptions.inJustDecodeBounds = false;
          paramInt = a(j, k, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, paramDownloadParams.outOrientation, paramInt);
          i = 1;
          paramURLDrawableHandler = localObject2;
          if (i <= 3) {}
          try
          {
            localOptions.inSampleSize = paramInt;
            paramURLDrawableHandler = new SafeBitmapFactory.SafeDecodeOption();
            paramURLDrawableHandler.inOptions = localOptions;
            paramURLDrawableHandler.inNeedFlashBackTest = false;
            localBitmap = SafeBitmapFactory.safeDecode(paramFile.getAbsolutePath(), paramURLDrawableHandler);
            if (QLog.isColorLevel()) {
              QLog.d("PEAK", 2, "PhotoDecoder regionDecodeInfo:" + paramURLDrawableHandler.toString());
            }
            if ((!paramURLDrawableHandler.isInJustDecodeBounds) && (paramURLDrawableHandler.needRegionDecode))
            {
              localObject3 = paramURLDrawableHandler.getInfo();
              ((HashMap)localObject3).put("from", "PhotoDecoder");
              awrn localawrn = awrn.a(BaseApplicationImpl.getApplication());
              bool = paramURLDrawableHandler.isGetBitmap;
              long l = paramURLDrawableHandler.runTime;
              m = paramURLDrawableHandler.rawHeight;
              localawrn.a(null, "safeDecode", bool, l, paramURLDrawableHandler.rawWidth * m, (HashMap)localObject3, "");
            }
            localBitmap.setDensity(160);
            boolean bool = SliceBitmap.needSliceBitmap(localBitmap);
            if (bool)
            {
              try
              {
                paramURLDrawableHandler = new SliceBitmap(localBitmap);
                localBitmap.recycle();
                label453:
                if (localOptions.inSampleSize > 1)
                {
                  if (!paramDownloadParams.mAutoScaleByDensity) {
                    break label824;
                  }
                  paramDownloadParams.outWidth = ((int)Math.ceil(j * this.jdField_a_of_type_Float));
                  paramDownloadParams.outHeight = ((int)Math.ceil(k * this.jdField_a_of_type_Float));
                }
                if (QLog.isColorLevel()) {
                  QLog.d("PEAK", 2, "image file size:" + paramFile.length() + " , bound:" + localOptions.outWidth + "x" + localOptions.outHeight + " , sampleSize: " + localOptions.inSampleSize);
                }
                return paramURLDrawableHandler;
              }
              catch (Exception paramURLDrawableHandler)
              {
                if (localBitmap == null) {
                  break label610;
                }
                localBitmap.recycle();
                throw new OutOfMemoryError("slice failed.");
              }
              i = 1;
              paramURLDrawableHandler = Bitmap.Config.RGB_565;
              break;
              ((InputStream)localObject1).close();
              return null;
            }
          }
          catch (OutOfMemoryError paramURLDrawableHandler)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("PEAK", 2, "DecodeFile ERROR,oom retryCount=" + i + ",options.inSampleSize=" + localOptions.inSampleSize + ",url=" + paramDownloadParams.urlStr + ",oom.msg:" + paramURLDrawableHandler.getMessage());
              }
              System.gc();
              Thread.yield();
              System.gc();
              i += 1;
              paramInt *= 2;
              break;
              if ((paramDownloadParams.mExtraInfo == null) || (!adys.class.isInstance(paramDownloadParams.mExtraInfo))) {
                break label818;
              }
              paramURLDrawableHandler = (adys)paramDownloadParams.mExtraInfo;
              if (paramURLDrawableHandler.a <= 0) {
                break label872;
              }
              Object localObject3 = a(localBitmap, paramURLDrawableHandler.a);
              paramURLDrawableHandler = (URLDrawableHandler)localObject3;
              if (!((RoundRectBitmap)localObject3).mBitmap.equals(localBitmap))
              {
                localBitmap.recycle();
                paramURLDrawableHandler = (URLDrawableHandler)localObject3;
              }
            }
          }
          catch (NullPointerException paramFile)
          {
            label610:
            paramFile.printStackTrace();
            return null;
          }
        }
        label807:
        paramURLDrawableHandler = localBitmap;
      }
      finally
      {
        paramInt = 1;
        paramDownloadParams = (DownloadParams)localObject1;
        if (paramInt == 0) {
          paramDownloadParams.close();
        }
      }
      label818:
      continue;
      label824:
      double d = j;
      paramDownloadParams.outWidth = ((int)Math.ceil(d));
      paramDownloadParams.outHeight = ((int)Math.ceil(k));
    }
  }
  
  /* Error */
  private Object c(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    // Byte code:
    //   0: new 128	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 131	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore 19
    //   10: iconst_0
    //   11: istore 8
    //   13: iconst_0
    //   14: istore 7
    //   16: iload 8
    //   18: istore 5
    //   20: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   23: lstore 11
    //   25: iload 8
    //   27: istore 5
    //   29: iconst_2
    //   30: newarray byte
    //   32: astore 17
    //   34: iload 8
    //   36: istore 5
    //   38: aload 19
    //   40: aload 17
    //   42: invokevirtual 141	java/io/FileInputStream:read	([B)I
    //   45: pop
    //   46: aload 17
    //   48: iconst_0
    //   49: baload
    //   50: istore 9
    //   52: aload 17
    //   54: iconst_1
    //   55: baload
    //   56: istore 10
    //   58: iload 8
    //   60: istore 5
    //   62: getstatic 147	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   65: astore 16
    //   67: iconst_0
    //   68: istore 6
    //   70: iconst_0
    //   71: istore 5
    //   73: iload 9
    //   75: bipush 8
    //   77: ishl
    //   78: ldc 148
    //   80: iand
    //   81: iload 10
    //   83: sipush 255
    //   86: iand
    //   87: ior
    //   88: lookupswitch	default:+848->936, 8273:+323->411, 16973:+323->411, 18249:+335->423, 18761:+320->408, 19789:+320->408, 65496:+320->408
    //   149: iconst_5
    //   150: istore 5
    //   152: aload_1
    //   153: invokevirtual 151	java/io/File:length	()J
    //   156: l2i
    //   157: newarray byte
    //   159: astore 21
    //   161: iload 8
    //   163: istore 5
    //   165: aload 17
    //   167: iconst_0
    //   168: aload 21
    //   170: iconst_0
    //   171: aload 17
    //   173: arraylength
    //   174: invokestatic 157	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   177: iload 8
    //   179: istore 5
    //   181: aload 19
    //   183: aload 21
    //   185: aload 17
    //   187: arraylength
    //   188: aload 19
    //   190: invokevirtual 160	java/io/FileInputStream:available	()I
    //   193: invokevirtual 163	java/io/FileInputStream:read	([BII)I
    //   196: pop
    //   197: iload 8
    //   199: istore 5
    //   201: aload 19
    //   203: invokevirtual 166	java/io/FileInputStream:close	()V
    //   206: iconst_1
    //   207: istore 7
    //   209: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +37 -> 249
    //   215: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   218: lstore 13
    //   220: ldc 56
    //   222: iconst_2
    //   223: new 168	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   230: ldc 171
    //   232: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: lload 13
    //   237: lload 11
    //   239: lsub
    //   240: invokevirtual 178	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   243: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   249: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   252: lstore 11
    //   254: new 417	com/tencent/mobileqq/pic/JpegOptions
    //   257: dup
    //   258: invokespecial 418	com/tencent/mobileqq/pic/JpegOptions:<init>	()V
    //   261: astore 20
    //   263: aload 20
    //   265: iconst_1
    //   266: putfield 419	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   269: aload 20
    //   271: aload 16
    //   273: putfield 420	com/tencent/mobileqq/pic/JpegOptions:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   276: aload 21
    //   278: aload 20
    //   280: invokestatic 425	com/tencent/mobileqq/pic/JpegDecompressor:decodeByteArray	([BLcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   283: pop
    //   284: aload 20
    //   286: getfield 426	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   289: istore 8
    //   291: aload 20
    //   293: getfield 427	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   296: istore 9
    //   298: iload 6
    //   300: ifeq +14 -> 314
    //   303: aload_2
    //   304: aload_1
    //   305: invokevirtual 96	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   308: invokestatic 224	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   311: putfield 227	com/tencent/image/DownloadParams:outOrientation	I
    //   314: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   317: ifeq +37 -> 354
    //   320: invokestatic 137	android/os/SystemClock:uptimeMillis	()J
    //   323: lstore 13
    //   325: ldc 56
    //   327: iconst_2
    //   328: new 168	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   335: ldc 229
    //   337: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: lload 13
    //   342: lload 11
    //   344: lsub
    //   345: invokevirtual 178	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   348: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: aload 20
    //   356: iconst_0
    //   357: putfield 419	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   360: aload_0
    //   361: iload 8
    //   363: iload 9
    //   365: aload_2
    //   366: getfield 113	com/tencent/image/DownloadParams:reqWidth	I
    //   369: aload_2
    //   370: getfield 116	com/tencent/image/DownloadParams:reqHeight	I
    //   373: aload_2
    //   374: getfield 227	com/tencent/image/DownloadParams:outOrientation	I
    //   377: iload 4
    //   379: invokespecial 231	adyr:a	(IIIIII)I
    //   382: istore 5
    //   384: aload 20
    //   386: iload 5
    //   388: putfield 428	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   391: aload 21
    //   393: aload 20
    //   395: invokestatic 425	com/tencent/mobileqq/pic/JpegDecompressor:decodeByteArray	([BLcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   398: astore 17
    //   400: aload 17
    //   402: ifnonnull +28 -> 430
    //   405: aload 17
    //   407: areturn
    //   408: iconst_1
    //   409: istore 6
    //   411: iload 8
    //   413: istore 5
    //   415: getstatic 273	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   418: astore 16
    //   420: goto -272 -> 148
    //   423: aload 19
    //   425: invokevirtual 166	java/io/FileInputStream:close	()V
    //   428: aconst_null
    //   429: areturn
    //   430: aload 17
    //   432: sipush 160
    //   435: invokevirtual 238	android/graphics/Bitmap:setDensity	(I)V
    //   438: aload 17
    //   440: invokestatic 244	com/tencent/image/SliceBitmap:needSliceBitmap	(Landroid/graphics/Bitmap;)Z
    //   443: istore 15
    //   445: iload 15
    //   447: ifeq +333 -> 780
    //   450: new 240	com/tencent/image/SliceBitmap
    //   453: dup
    //   454: aload 17
    //   456: invokespecial 247	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   459: astore 16
    //   461: aload 17
    //   463: invokevirtual 250	android/graphics/Bitmap:recycle	()V
    //   466: aload 20
    //   468: getfield 428	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   471: iconst_1
    //   472: if_icmple +44 -> 516
    //   475: aload_2
    //   476: getfield 253	com/tencent/image/DownloadParams:mAutoScaleByDensity	Z
    //   479: ifeq +389 -> 868
    //   482: aload_2
    //   483: iload 8
    //   485: i2f
    //   486: aload_0
    //   487: getfield 33	adyr:jdField_a_of_type_Float	F
    //   490: fmul
    //   491: f2d
    //   492: invokestatic 257	java/lang/Math:ceil	(D)D
    //   495: d2i
    //   496: putfield 258	com/tencent/image/DownloadParams:outWidth	I
    //   499: aload_2
    //   500: iload 9
    //   502: i2f
    //   503: aload_0
    //   504: getfield 33	adyr:jdField_a_of_type_Float	F
    //   507: fmul
    //   508: f2d
    //   509: invokestatic 257	java/lang/Math:ceil	(D)D
    //   512: d2i
    //   513: putfield 259	com/tencent/image/DownloadParams:outHeight	I
    //   516: aload 16
    //   518: astore 17
    //   520: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   523: ifeq -118 -> 405
    //   526: ldc 56
    //   528: iconst_2
    //   529: new 168	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   536: ldc_w 261
    //   539: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: aload_1
    //   543: invokevirtual 151	java/io/File:length	()J
    //   546: invokevirtual 178	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   549: ldc_w 263
    //   552: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: iload 8
    //   557: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   560: ldc_w 268
    //   563: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: iload 9
    //   568: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   571: ldc_w 270
    //   574: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: aload 20
    //   579: getfield 428	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   582: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   585: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   591: aload 16
    //   593: areturn
    //   594: astore 16
    //   596: iconst_1
    //   597: istore 6
    //   599: iload 6
    //   601: istore 5
    //   603: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   606: ifeq +19 -> 625
    //   609: iload 6
    //   611: istore 5
    //   613: ldc_w 430
    //   616: iconst_2
    //   617: ldc_w 432
    //   620: aload 16
    //   622: invokestatic 436	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   625: iload 6
    //   627: istore 5
    //   629: aload_0
    //   630: aload_1
    //   631: aload_2
    //   632: aload_3
    //   633: iload 4
    //   635: invokespecial 438	adyr:a	(Ljava/io/File;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;I)Ljava/lang/Object;
    //   638: astore_1
    //   639: aload_1
    //   640: astore 17
    //   642: iload 6
    //   644: ifne -239 -> 405
    //   647: aload 19
    //   649: invokevirtual 166	java/io/FileInputStream:close	()V
    //   652: aload_1
    //   653: areturn
    //   654: astore 16
    //   656: aload 17
    //   658: ifnull +8 -> 666
    //   661: aload 17
    //   663: invokevirtual 250	android/graphics/Bitmap:recycle	()V
    //   666: new 71	java/lang/OutOfMemoryError
    //   669: dup
    //   670: ldc_w 286
    //   673: invokespecial 289	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   676: athrow
    //   677: astore 16
    //   679: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   682: ifeq +70 -> 752
    //   685: ldc 56
    //   687: iconst_2
    //   688: new 168	java/lang/StringBuilder
    //   691: dup
    //   692: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   695: ldc_w 291
    //   698: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: iconst_1
    //   702: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   705: ldc_w 293
    //   708: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: aload 20
    //   713: getfield 428	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   716: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   719: ldc_w 295
    //   722: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: aload_2
    //   726: getfield 299	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   729: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: ldc_w 301
    //   735: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: aload 16
    //   740: invokevirtual 304	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   743: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   749: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   752: iload 5
    //   754: iconst_2
    //   755: imul
    //   756: istore 5
    //   758: invokestatic 307	java/lang/System:gc	()V
    //   761: invokestatic 312	java/lang/Thread:yield	()V
    //   764: invokestatic 307	java/lang/System:gc	()V
    //   767: iload 5
    //   769: bipush 8
    //   771: if_icmplt +156 -> 927
    //   774: aconst_null
    //   775: astore 16
    //   777: goto -311 -> 466
    //   780: aload_2
    //   781: getfield 315	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   784: ifnull +159 -> 943
    //   787: ldc_w 317
    //   790: aload_2
    //   791: getfield 315	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   794: invokevirtual 323	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   797: ifeq +146 -> 943
    //   800: aload_2
    //   801: getfield 315	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   804: checkcast 317	adys
    //   807: astore 16
    //   809: aload 16
    //   811: getfield 325	adys:a	I
    //   814: ifle +116 -> 930
    //   817: aload_0
    //   818: aload 17
    //   820: aload 16
    //   822: getfield 325	adys:a	I
    //   825: invokespecial 327	adyr:a	(Landroid/graphics/Bitmap;I)Lcom/tencent/image/RoundRectBitmap;
    //   828: astore 18
    //   830: aload 18
    //   832: astore 16
    //   834: aload 18
    //   836: getfield 331	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   839: aload 17
    //   841: invokevirtual 336	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   844: ifne -378 -> 466
    //   847: aload 17
    //   849: invokevirtual 250	android/graphics/Bitmap:recycle	()V
    //   852: aload 18
    //   854: astore 16
    //   856: goto -390 -> 466
    //   859: astore 16
    //   861: aload 16
    //   863: invokevirtual 339	java/lang/NullPointerException:printStackTrace	()V
    //   866: aconst_null
    //   867: areturn
    //   868: aload_2
    //   869: iload 8
    //   871: i2d
    //   872: invokestatic 257	java/lang/Math:ceil	(D)D
    //   875: d2i
    //   876: putfield 258	com/tencent/image/DownloadParams:outWidth	I
    //   879: aload_2
    //   880: iload 9
    //   882: i2d
    //   883: invokestatic 257	java/lang/Math:ceil	(D)D
    //   886: d2i
    //   887: putfield 259	com/tencent/image/DownloadParams:outHeight	I
    //   890: goto -374 -> 516
    //   893: astore_1
    //   894: iload 7
    //   896: istore 4
    //   898: iload 4
    //   900: ifne +8 -> 908
    //   903: aload 19
    //   905: invokevirtual 166	java/io/FileInputStream:close	()V
    //   908: aload_1
    //   909: athrow
    //   910: astore_1
    //   911: iload 5
    //   913: istore 4
    //   915: goto -17 -> 898
    //   918: astore 16
    //   920: iload 7
    //   922: istore 6
    //   924: goto -325 -> 599
    //   927: goto -543 -> 384
    //   930: aconst_null
    //   931: astore 16
    //   933: goto -467 -> 466
    //   936: iload 5
    //   938: istore 6
    //   940: goto -792 -> 148
    //   943: aload 17
    //   945: astore 16
    //   947: goto -481 -> 466
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	950	0	this	adyr
    //   0	950	1	paramFile	File
    //   0	950	2	paramDownloadParams	DownloadParams
    //   0	950	3	paramURLDrawableHandler	URLDrawableHandler
    //   0	950	4	paramInt	int
    //   18	919	5	i	int
    //   68	871	6	j	int
    //   14	907	7	k	int
    //   11	859	8	m	int
    //   50	831	9	n	int
    //   56	31	10	i1	int
    //   23	320	11	l1	long
    //   218	123	13	l2	long
    //   443	3	15	bool	boolean
    //   65	527	16	localObject1	Object
    //   594	27	16	localRuntimeException1	java.lang.RuntimeException
    //   654	1	16	localException	Exception
    //   677	62	16	localOutOfMemoryError	OutOfMemoryError
    //   775	80	16	localObject2	Object
    //   859	3	16	localNullPointerException	NullPointerException
    //   918	1	16	localRuntimeException2	java.lang.RuntimeException
    //   931	15	16	localObject3	Object
    //   32	912	17	localObject4	Object
    //   828	25	18	localRoundRectBitmap	RoundRectBitmap
    //   8	896	19	localFileInputStream	FileInputStream
    //   261	451	20	localJpegOptions	com.tencent.mobileqq.pic.JpegOptions
    //   159	233	21	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   209	249	594	java/lang/RuntimeException
    //   249	298	594	java/lang/RuntimeException
    //   303	314	594	java/lang/RuntimeException
    //   314	354	594	java/lang/RuntimeException
    //   354	384	594	java/lang/RuntimeException
    //   384	400	594	java/lang/RuntimeException
    //   430	445	594	java/lang/RuntimeException
    //   450	466	594	java/lang/RuntimeException
    //   466	516	594	java/lang/RuntimeException
    //   520	591	594	java/lang/RuntimeException
    //   661	666	594	java/lang/RuntimeException
    //   666	677	594	java/lang/RuntimeException
    //   679	752	594	java/lang/RuntimeException
    //   758	767	594	java/lang/RuntimeException
    //   780	830	594	java/lang/RuntimeException
    //   834	852	594	java/lang/RuntimeException
    //   861	866	594	java/lang/RuntimeException
    //   868	890	594	java/lang/RuntimeException
    //   450	466	654	java/lang/Exception
    //   384	400	677	java/lang/OutOfMemoryError
    //   430	445	677	java/lang/OutOfMemoryError
    //   450	466	677	java/lang/OutOfMemoryError
    //   661	666	677	java/lang/OutOfMemoryError
    //   666	677	677	java/lang/OutOfMemoryError
    //   780	830	677	java/lang/OutOfMemoryError
    //   834	852	677	java/lang/OutOfMemoryError
    //   384	400	859	java/lang/NullPointerException
    //   430	445	859	java/lang/NullPointerException
    //   450	466	859	java/lang/NullPointerException
    //   661	666	859	java/lang/NullPointerException
    //   666	677	859	java/lang/NullPointerException
    //   780	830	859	java/lang/NullPointerException
    //   834	852	859	java/lang/NullPointerException
    //   209	249	893	finally
    //   249	298	893	finally
    //   303	314	893	finally
    //   314	354	893	finally
    //   354	384	893	finally
    //   384	400	893	finally
    //   430	445	893	finally
    //   450	466	893	finally
    //   466	516	893	finally
    //   520	591	893	finally
    //   661	666	893	finally
    //   666	677	893	finally
    //   679	752	893	finally
    //   758	767	893	finally
    //   780	830	893	finally
    //   834	852	893	finally
    //   861	866	893	finally
    //   868	890	893	finally
    //   20	25	910	finally
    //   29	34	910	finally
    //   38	46	910	finally
    //   62	67	910	finally
    //   152	161	910	finally
    //   165	177	910	finally
    //   181	197	910	finally
    //   201	206	910	finally
    //   415	420	910	finally
    //   603	609	910	finally
    //   613	625	910	finally
    //   629	639	910	finally
    //   20	25	918	java/lang/RuntimeException
    //   29	34	918	java/lang/RuntimeException
    //   38	46	918	java/lang/RuntimeException
    //   62	67	918	java/lang/RuntimeException
    //   152	161	918	java/lang/RuntimeException
    //   165	177	918	java/lang/RuntimeException
    //   181	197	918	java/lang/RuntimeException
    //   201	206	918	java/lang/RuntimeException
    //   415	420	918	java/lang/RuntimeException
  }
  
  /* Error */
  private Object d(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: new 128	java/io/FileInputStream
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 131	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   11: astore 13
    //   13: iconst_2
    //   14: newarray byte
    //   16: astore 12
    //   18: aload 13
    //   20: aload 12
    //   22: invokevirtual 343	java/io/InputStream:read	([B)I
    //   25: pop
    //   26: aload 12
    //   28: iconst_0
    //   29: baload
    //   30: istore 9
    //   32: aload 12
    //   34: iconst_1
    //   35: baload
    //   36: istore 10
    //   38: getstatic 147	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   41: astore 12
    //   43: iconst_0
    //   44: istore 7
    //   46: iconst_0
    //   47: istore 8
    //   49: iload 9
    //   51: bipush 8
    //   53: ishl
    //   54: ldc 148
    //   56: iand
    //   57: iload 10
    //   59: sipush 255
    //   62: iand
    //   63: ior
    //   64: lookupswitch	default:+740->804, 8273:+205->269, 16973:+205->269, 18249:+213->277, 18761:+202->266, 19789:+202->266, 65496:+202->266
    //   125: aconst_null
    //   126: if_icmplt +22967 -> 23093
    //   129: aconst_null
    //   130: if_icmpge +14864 -> 14994
    //   133: aload 16
    //   135: iconst_1
    //   136: putfield 419	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   139: aload 16
    //   141: aload 12
    //   143: putfield 420	com/tencent/mobileqq/pic/JpegOptions:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   146: aload_1
    //   147: invokevirtual 96	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   150: aload 16
    //   152: invokestatic 442	com/tencent/mobileqq/pic/JpegDecompressor:decodeFile	(Ljava/lang/String;Lcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   155: pop
    //   156: aload 16
    //   158: getfield 426	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   161: istore 9
    //   163: aload 16
    //   165: getfield 427	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   168: istore 10
    //   170: iload 7
    //   172: ifeq +14 -> 186
    //   175: aload_2
    //   176: aload_1
    //   177: invokevirtual 96	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   180: invokestatic 224	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   183: putfield 227	com/tencent/image/DownloadParams:outOrientation	I
    //   186: aload 16
    //   188: iconst_0
    //   189: putfield 419	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   192: aload_0
    //   193: iload 9
    //   195: iload 10
    //   197: aload_2
    //   198: getfield 113	com/tencent/image/DownloadParams:reqWidth	I
    //   201: aload_2
    //   202: getfield 116	com/tencent/image/DownloadParams:reqHeight	I
    //   205: aload_2
    //   206: getfield 227	com/tencent/image/DownloadParams:outOrientation	I
    //   209: iload 4
    //   211: invokespecial 231	adyr:a	(IIIIII)I
    //   214: istore 7
    //   216: iconst_1
    //   217: istore 8
    //   219: iload 8
    //   221: iconst_3
    //   222: if_icmpgt +576 -> 798
    //   225: aload 16
    //   227: iload 7
    //   229: putfield 428	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   232: aload_1
    //   233: invokevirtual 96	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   236: aload 16
    //   238: invokestatic 442	com/tencent/mobileqq/pic/JpegDecompressor:decodeFile	(Ljava/lang/String;Lcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   241: astore 14
    //   243: aload 14
    //   245: ifnonnull +46 -> 291
    //   248: aconst_null
    //   249: astore_2
    //   250: aload_2
    //   251: astore_1
    //   252: aload 13
    //   254: ifnull +10 -> 264
    //   257: aload 13
    //   259: invokevirtual 344	java/io/InputStream:close	()V
    //   262: aload_2
    //   263: astore_1
    //   264: aload_1
    //   265: areturn
    //   266: iconst_1
    //   267: istore 7
    //   269: getstatic 273	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   272: astore 12
    //   274: goto -150 -> 124
    //   277: aconst_null
    //   278: astore_1
    //   279: aload 13
    //   281: ifnull -17 -> 264
    //   284: aload 13
    //   286: invokevirtual 344	java/io/InputStream:close	()V
    //   289: aconst_null
    //   290: areturn
    //   291: aload 14
    //   293: sipush 160
    //   296: invokevirtual 238	android/graphics/Bitmap:setDensity	(I)V
    //   299: aload 14
    //   301: invokestatic 244	com/tencent/image/SliceBitmap:needSliceBitmap	(Landroid/graphics/Bitmap;)Z
    //   304: istore 11
    //   306: iload 11
    //   308: ifeq +285 -> 593
    //   311: new 240	com/tencent/image/SliceBitmap
    //   314: dup
    //   315: aload 14
    //   317: invokespecial 247	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   320: astore 12
    //   322: aload 14
    //   324: invokevirtual 250	android/graphics/Bitmap:recycle	()V
    //   327: aload 16
    //   329: getfield 428	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   332: iconst_1
    //   333: if_icmple +44 -> 377
    //   336: aload_2
    //   337: getfield 253	com/tencent/image/DownloadParams:mAutoScaleByDensity	Z
    //   340: ifeq +391 -> 731
    //   343: aload_2
    //   344: iload 9
    //   346: i2f
    //   347: aload_0
    //   348: getfield 33	adyr:jdField_a_of_type_Float	F
    //   351: fmul
    //   352: f2d
    //   353: invokestatic 257	java/lang/Math:ceil	(D)D
    //   356: d2i
    //   357: putfield 258	com/tencent/image/DownloadParams:outWidth	I
    //   360: aload_2
    //   361: iload 10
    //   363: i2f
    //   364: aload_0
    //   365: getfield 33	adyr:jdField_a_of_type_Float	F
    //   368: fmul
    //   369: f2d
    //   370: invokestatic 257	java/lang/Math:ceil	(D)D
    //   373: d2i
    //   374: putfield 259	com/tencent/image/DownloadParams:outHeight	I
    //   377: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   380: ifeq +74 -> 454
    //   383: ldc 56
    //   385: iconst_2
    //   386: new 168	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   393: ldc_w 261
    //   396: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload_1
    //   400: invokevirtual 151	java/io/File:length	()J
    //   403: invokevirtual 178	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   406: ldc_w 263
    //   409: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload 16
    //   414: getfield 426	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   417: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   420: ldc_w 268
    //   423: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: aload 16
    //   428: getfield 427	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   431: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   434: ldc_w 270
    //   437: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: aload 16
    //   442: getfield 428	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   445: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   448: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   454: aload 12
    //   456: astore_1
    //   457: aload 13
    //   459: ifnull -195 -> 264
    //   462: aload 13
    //   464: invokevirtual 344	java/io/InputStream:close	()V
    //   467: aload 12
    //   469: areturn
    //   470: astore 12
    //   472: aload 14
    //   474: ifnull +8 -> 482
    //   477: aload 14
    //   479: invokevirtual 250	android/graphics/Bitmap:recycle	()V
    //   482: new 71	java/lang/OutOfMemoryError
    //   485: dup
    //   486: ldc_w 286
    //   489: invokespecial 289	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   492: athrow
    //   493: astore 12
    //   495: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   498: ifeq +71 -> 569
    //   501: ldc 56
    //   503: iconst_2
    //   504: new 168	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   511: ldc_w 291
    //   514: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: iload 8
    //   519: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   522: ldc_w 293
    //   525: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: aload 16
    //   530: getfield 428	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   533: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   536: ldc_w 295
    //   539: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: aload_2
    //   543: getfield 299	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   546: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: ldc_w 301
    //   552: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload 12
    //   557: invokevirtual 304	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   560: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: invokestatic 62	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   569: invokestatic 307	java/lang/System:gc	()V
    //   572: invokestatic 312	java/lang/Thread:yield	()V
    //   575: invokestatic 307	java/lang/System:gc	()V
    //   578: iload 8
    //   580: iconst_1
    //   581: iadd
    //   582: istore 8
    //   584: iload 7
    //   586: iconst_2
    //   587: imul
    //   588: istore 7
    //   590: goto -371 -> 219
    //   593: aload_2
    //   594: getfield 315	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   597: ifnull +127 -> 724
    //   600: ldc_w 317
    //   603: aload_2
    //   604: getfield 315	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   607: invokevirtual 323	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   610: ifeq +114 -> 724
    //   613: aload_2
    //   614: getfield 315	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   617: checkcast 317	adys
    //   620: astore 12
    //   622: aload 12
    //   624: getfield 325	adys:a	I
    //   627: ifle +165 -> 792
    //   630: aload_0
    //   631: aload 14
    //   633: aload 12
    //   635: getfield 325	adys:a	I
    //   638: invokespecial 327	adyr:a	(Landroid/graphics/Bitmap;I)Lcom/tencent/image/RoundRectBitmap;
    //   641: astore 15
    //   643: aload 15
    //   645: astore 12
    //   647: aload 15
    //   649: getfield 331	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   652: aload 14
    //   654: invokevirtual 336	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   657: ifne -330 -> 327
    //   660: aload 14
    //   662: invokevirtual 250	android/graphics/Bitmap:recycle	()V
    //   665: aload 15
    //   667: astore 12
    //   669: goto -342 -> 327
    //   672: astore 14
    //   674: aload 13
    //   676: astore 12
    //   678: aload 14
    //   680: astore 13
    //   682: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   685: ifeq +15 -> 700
    //   688: ldc_w 430
    //   691: iconst_2
    //   692: ldc_w 444
    //   695: aload 13
    //   697: invokestatic 436	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   700: aload_0
    //   701: aload_1
    //   702: aload_2
    //   703: aload_3
    //   704: iload 4
    //   706: invokespecial 446	adyr:b	(Ljava/io/File;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;I)Ljava/lang/Object;
    //   709: astore_2
    //   710: aload_2
    //   711: astore_1
    //   712: aload 12
    //   714: ifnull -450 -> 264
    //   717: aload 12
    //   719: invokevirtual 344	java/io/InputStream:close	()V
    //   722: aload_2
    //   723: areturn
    //   724: aload 14
    //   726: astore 12
    //   728: goto -401 -> 327
    //   731: iload 9
    //   733: i2d
    //   734: dstore 5
    //   736: aload_2
    //   737: dload 5
    //   739: invokestatic 257	java/lang/Math:ceil	(D)D
    //   742: d2i
    //   743: putfield 258	com/tencent/image/DownloadParams:outWidth	I
    //   746: aload_2
    //   747: iload 10
    //   749: i2d
    //   750: invokestatic 257	java/lang/Math:ceil	(D)D
    //   753: d2i
    //   754: putfield 259	com/tencent/image/DownloadParams:outHeight	I
    //   757: goto -380 -> 377
    //   760: astore_1
    //   761: aload 13
    //   763: astore_2
    //   764: aload_2
    //   765: ifnull +7 -> 772
    //   768: aload_2
    //   769: invokevirtual 344	java/io/InputStream:close	()V
    //   772: aload_1
    //   773: athrow
    //   774: astore_1
    //   775: aconst_null
    //   776: astore_2
    //   777: goto -13 -> 764
    //   780: astore_1
    //   781: aload 12
    //   783: astore_2
    //   784: goto -20 -> 764
    //   787: astore 13
    //   789: goto -107 -> 682
    //   792: aconst_null
    //   793: astore 12
    //   795: goto -468 -> 327
    //   798: aconst_null
    //   799: astore 12
    //   801: goto -474 -> 327
    //   804: iload 8
    //   806: istore 7
    //   808: goto -684 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	811	0	this	adyr
    //   0	811	1	paramFile	File
    //   0	811	2	paramDownloadParams	DownloadParams
    //   0	811	3	paramURLDrawableHandler	URLDrawableHandler
    //   0	811	4	paramInt	int
    //   734	4	5	d	double
    //   44	763	7	i	int
    //   47	758	8	j	int
    //   30	702	9	k	int
    //   36	712	10	m	int
    //   304	3	11	bool	boolean
    //   1	467	12	localObject1	Object
    //   470	1	12	localException	Exception
    //   493	63	12	localOutOfMemoryError	OutOfMemoryError
    //   620	180	12	localObject2	Object
    //   11	751	13	localObject3	Object
    //   787	1	13	localRuntimeException1	java.lang.RuntimeException
    //   241	420	14	localBitmap	Bitmap
    //   672	53	14	localRuntimeException2	java.lang.RuntimeException
    //   641	25	15	localRoundRectBitmap	RoundRectBitmap
    //   131	398	16	localJpegOptions	com.tencent.mobileqq.pic.JpegOptions
    // Exception table:
    //   from	to	target	type
    //   311	327	470	java/lang/Exception
    //   225	243	493	java/lang/OutOfMemoryError
    //   291	306	493	java/lang/OutOfMemoryError
    //   311	327	493	java/lang/OutOfMemoryError
    //   477	482	493	java/lang/OutOfMemoryError
    //   482	493	493	java/lang/OutOfMemoryError
    //   593	643	493	java/lang/OutOfMemoryError
    //   647	665	493	java/lang/OutOfMemoryError
    //   13	26	672	java/lang/RuntimeException
    //   38	43	672	java/lang/RuntimeException
    //   124	170	672	java/lang/RuntimeException
    //   175	186	672	java/lang/RuntimeException
    //   186	216	672	java/lang/RuntimeException
    //   225	243	672	java/lang/RuntimeException
    //   269	274	672	java/lang/RuntimeException
    //   291	306	672	java/lang/RuntimeException
    //   311	327	672	java/lang/RuntimeException
    //   327	377	672	java/lang/RuntimeException
    //   377	454	672	java/lang/RuntimeException
    //   477	482	672	java/lang/RuntimeException
    //   482	493	672	java/lang/RuntimeException
    //   495	569	672	java/lang/RuntimeException
    //   569	578	672	java/lang/RuntimeException
    //   593	643	672	java/lang/RuntimeException
    //   647	665	672	java/lang/RuntimeException
    //   736	757	672	java/lang/RuntimeException
    //   13	26	760	finally
    //   38	43	760	finally
    //   124	170	760	finally
    //   175	186	760	finally
    //   186	216	760	finally
    //   225	243	760	finally
    //   269	274	760	finally
    //   291	306	760	finally
    //   311	327	760	finally
    //   327	377	760	finally
    //   377	454	760	finally
    //   477	482	760	finally
    //   482	493	760	finally
    //   495	569	760	finally
    //   569	578	760	finally
    //   593	643	760	finally
    //   647	665	760	finally
    //   736	757	760	finally
    //   3	13	774	finally
    //   682	700	780	finally
    //   700	710	780	finally
    //   3	13	787	java/lang/RuntimeException
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    long l1 = SystemClock.uptimeMillis();
    try
    {
      if (VideoDrawable.isVideo(paramFile))
      {
        paramURLDrawableHandler = a(paramFile, paramDownloadParams, paramURLDrawableHandler);
        paramDownloadParams = paramURLDrawableHandler;
        if (QLog.isColorLevel())
        {
          l2 = SystemClock.uptimeMillis();
          QLog.d("PEAK", 2, "decode file:" + paramFile.getAbsolutePath() + " cost: " + (l2 - l1));
          paramDownloadParams = paramURLDrawableHandler;
        }
        return paramDownloadParams;
      }
      l2 = paramFile.length();
      int i = 0;
      if (paramDownloadParams.tag != null) {
        i = ((Integer)paramDownloadParams.tag).intValue();
      }
      if ((atra.b()) && (bacm.b(paramFile.getAbsolutePath())))
      {
        if (l2 < 5242880L)
        {
          paramURLDrawableHandler = c(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
          paramDownloadParams = paramURLDrawableHandler;
          return paramURLDrawableHandler;
        }
        paramURLDrawableHandler = d(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
        paramDownloadParams = paramURLDrawableHandler;
        return paramURLDrawableHandler;
      }
      if (l2 < 5242880L)
      {
        paramURLDrawableHandler = a(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
        paramDownloadParams = paramURLDrawableHandler;
        return paramURLDrawableHandler;
      }
      paramURLDrawableHandler = b(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
      paramDownloadParams = paramURLDrawableHandler;
      return paramURLDrawableHandler;
    }
    finally
    {
      long l2;
      if (QLog.isColorLevel())
      {
        l2 = SystemClock.uptimeMillis();
        QLog.d("PEAK", 2, "decode file:" + paramFile.getAbsolutePath() + " cost: " + (l2 - l1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adyr
 * JD-Core Version:    0.7.0.1
 */