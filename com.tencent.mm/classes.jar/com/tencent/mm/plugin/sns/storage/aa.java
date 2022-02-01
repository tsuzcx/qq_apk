package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.plugin.emoji.f;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.image.b;
import com.tencent.mm.plugin.sns.data.s;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.statistics.g.a;
import com.tencent.mm.protocal.protobuf.dmu;
import com.tencent.mm.protocal.protobuf.dnc;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class aa
  extends MStorage
{
  private static int CCP;
  private static int DRE;
  public static final String[] SQL_CREATE;
  private static Point nGU;
  public com.tencent.mm.storagebase.h omV;
  
  static
  {
    AppMethodBeat.i(97620);
    SQL_CREATE = new String[] { "CREATE TABLE IF NOT EXISTS SnsMedia ( local_id INTEGER PRIMARY KEY, seqId LONG, type INT, createTime LONG, userName VARCHAR(40), totallen INT, offset INT, local_flag INT, tmp_path TEXT, nums INT, try_times INT, StrId VARCHAR(40), upload_buf TEXT, reserved1 INT, reserved2 TEXT, reserved3 TEXT, reserved4 TEXT, reserved5 TEXT )", "CREATE INDEX IF NOT EXISTS serverSnsMediaTimeIndex ON SnsMedia ( createTime )" };
    DRE = 0;
    CCP = 0;
    nGU = new Point();
    AppMethodBeat.o(97620);
  }
  
  public aa(com.tencent.mm.storagebase.h paramh)
  {
    this.omV = paramh;
  }
  
  private int a(s params)
  {
    AppMethodBeat.i(97607);
    localObject1 = al.getAccSnsPath();
    str2 = al.getAccSnsTmpPath();
    Log.i("MicroMsg.snsMediaStorage", "SnsMediaStorage %s %s", new Object[] { localObject1, str2 });
    l = System.currentTimeMillis();
    str1 = params.path;
    i = params.type;
    if (!y.ZC(str1))
    {
      AppMethodBeat.o(97607);
      return -1;
    }
    str4 = com.tencent.mm.b.g.getMessageDigest((str1 + System.currentTimeMillis()).getBytes());
    str3 = t.aXq(str4);
    Log.d("MicroMsg.snsMediaStorage", "insert : original img path = ".concat(String.valueOf(str1)));
    if (!y.ZC(str2))
    {
      Log.i("MicroMsg.snsMediaStorage", "create snstmp path ".concat(String.valueOf(str2)));
      y.bDX(str2);
    }
    if (!y.ZC((String)localObject1))
    {
      Log.i("MicroMsg.snsMediaStorage", "create snsPath ".concat(String.valueOf(localObject1)));
      y.bDX((String)localObject1);
    }
    localObject2 = new b();
    localObject3 = a(params, str1);
    j = ((s)localObject3).width;
    int k = ((s)localObject3).height;
    int m = ((s)localObject3).fileSize;
    ((b)localObject2).JEV = str1;
    ((b)localObject2).JEX = j;
    ((b)localObject2).JEY = k;
    ((b)localObject2).JEZ = m;
    if (!i(str2, str1, str3, true))
    {
      AppMethodBeat.o(97607);
      return -1;
    }
    Log.d("MicroMsg.snsMediaStorage", "insert0 " + (System.currentTimeMillis() - l));
    Log.d("MicroMsg.snsMediaStorage", "insert: compressed bigMediaPath = ".concat(String.valueOf(str3)));
    str1 = str2 + str3;
    j = (int)y.bEl(str1);
    if (t.aIP(str1) == 2)
    {
      localObject4 = BitmapUtil.getYUVType(y.bi(str1, 0, j));
      if (localObject4 != null) {
        Log.i("MicroMsg.snsMediaStorage", "insert yuvInfo:%s", new Object[] { localObject4 });
      }
    }
    try
    {
      localObject1 = y.n(str1, false);
      params = (s)localObject1;
      if (localObject1 == null) {
        params = str1;
      }
      params = new androidx.f.a.a(params);
      params.m("UserComment", (String)localObject4);
      params.FM();
    }
    catch (Exception params)
    {
      try
      {
        ((z)localObject1).QZv = params.toByteArray();
        ((z)localObject1).hlg();
        ((z)localObject1).QZs = j;
        Log.i("MicroMsg.snsMediaStorage", "insert a local snsMedia  totallen  :" + j + " filepath: " + str2 + str3);
        i = (int)this.omV.insert("SnsMedia", "local_id", ((z)localObject1).hlf());
        Log.d("MicroMsg.snsMediaStorage", "insert localId ".concat(String.valueOf(i)));
        str4 = "Locall_path".concat(String.valueOf(i));
        ((b)localObject2).JEW = String.valueOf(i);
        ((b)localObject2).md5 = params.md5;
        localObject3 = Exif.fromFile(((b)localObject2).JEV);
        j = b.aIP(((b)localObject2).JEV);
        params = ((Exif)localObject3).dateTimeOriginal;
        localObject4 = ((b)localObject2).JEV;
        if (Util.isNullOrNil(params)) {
          break label1925;
        }
        params = b.aIQ(params);
        localObject4 = new n();
        ((n)localObject4).s("20 localID", ((b)localObject2).JEW + ",");
        ((n)localObject4).s("21 MediaType", j + ",");
        ((n)localObject4).s("22 OriginWidth", ((b)localObject2).JEX + ",");
        ((n)localObject4).s("23 OriginHeight", ((b)localObject2).JEY + ",");
        ((n)localObject4).s("24 CompressedWidth", ((b)localObject2).JFa + ",");
        ((n)localObject4).s("25 CompressedHeight", ((b)localObject2).JFb + ",");
        ((n)localObject4).s("26 OriginSize", ((b)localObject2).JEZ + ",");
        ((n)localObject4).s("27 CompressedSize", ((b)localObject2).JFc + ",");
        ((n)localObject4).s("28 FNumber", ((Exif)localObject3).fNumber + ",");
        ((n)localObject4).s("29 ExposureTime", ((Exif)localObject3).exposureTime + ",");
        ((n)localObject4).s("30 ISO", ((Exif)localObject3).isoSpeedRatings + ",");
        ((n)localObject4).s("31 Flash", ((Exif)localObject3).flash + ",");
        ((n)localObject4).s("32 LensModel", b.aIQ(((Exif)localObject3).model) + ",");
        ((n)localObject4).s("33 CreatTime", params + ",");
        ((n)localObject4).s("34 IsFromWeChat", "0,");
        ((n)localObject4).s("35 Scene", ",");
        ((n)localObject4).s("36 sceneType", ((Exif)localObject3).sceneType + ",");
        ((n)localObject4).s("37 fileSource", ((Exif)localObject3).fileSource + ",");
        ((n)localObject4).s("38 make", ((Exif)localObject3).make + ",");
        ((n)localObject4).s("39 software", ((Exif)localObject3).software + ",");
        ((n)localObject4).s("40 fileExt", b.alV(((b)localObject2).JEV) + ",");
        ((n)localObject4).s("41 faceCount", "0,");
        ((n)localObject4).s("42 YCbCrSubSampling", ((Exif)localObject3).yCbCrSubSampling + ",");
        ((n)localObject4).s("43 md5", ((b)localObject2).md5 + ',');
        Log.v("MicroMsg.ImgExtInfoReport", "report logbuffer MMImageExifInfo(14525): %s, orgPath:%s", new Object[] { ((n)localObject4).aIF(), ((b)localObject2).JEV });
        com.tencent.mm.plugin.report.service.h.OAn.b(14525, new Object[] { localObject4 });
        params = ((n)localObject4).toString();
        localObject2 = com.tencent.mm.plugin.sns.statistics.g.hii();
        j = b.aIP(str1);
        ((com.tencent.mm.plugin.sns.statistics.g)localObject2).QFK.put(Integer.valueOf(i), new g.a((com.tencent.mm.plugin.sns.statistics.g)localObject2, j, params));
        params = t.aXq(str4);
        str1 = bak(str4);
        y.bDX(str1);
        Log.i("MicroMsg.snsMediaStorage", "checkcntpath ".concat(String.valueOf(str1)));
        y.O(str2 + str3, str1 + params, false);
        str2 = str1 + t.aXm(str4);
        str3 = str1 + t.aXn(str4);
        y.deleteFile(str2);
        y.deleteFile(str3);
        Log.i("MicroMsg.snsMediaStorage", "insert done " + (System.currentTimeMillis() - l) + " targetPath : " + str1 + params + " totalLen:" + y.bEl(new StringBuilder().append(str1).append(params).toString()) + "  now delete...:" + str2 + " & " + str3);
        ((z)localObject1).Oxm = str4;
        a(i, (z)localObject1);
        AppMethodBeat.o(97607);
        return i;
        params = params;
        Log.printErrStackTrace("MicroMsg.snsMediaStorage", params, "", new Object[0]);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
          continue;
          params = b.aIQ(new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(new Date(new u((String)localObject4).lastModified())));
        }
      }
    }
    j = (int)y.bEl(str2 + str3);
    localObject3 = a((s)localObject3, str2 + str3);
    k = ((s)localObject3).width;
    m = ((s)localObject3).height;
    ((b)localObject2).JFa = k;
    ((b)localObject2).JFb = m;
    ((b)localObject2).JFc = j;
    localObject1 = new z();
    ((z)localObject1).Oxm = str4;
    ((z)localObject1).createTime = ((int)Util.nowSecond());
    ((z)localObject1).type = i;
    params = new dnc();
    params.Privated = ((s)localObject3).Qoh;
    params.aaTH = ((s)localObject3).Qog;
    params.token = ((s)localObject3).Qoi;
    params.aaTQ = ((s)localObject3).Qoj;
    params.aaUf = 0;
    params.aaUe = new dmu();
    params.nrQ = 0;
    params.IGG = ((s)localObject3).desc;
    Log.d("MicroMsg.snsMediaStorage", "upload.filterId " + ((s)localObject3).Qof);
    params.aaTG = ((s)localObject3).Qof;
    params.aaPu = 2;
    params.md5 = y.bub(str2 + str3);
  }
  
  private static s a(s params, String paramString)
  {
    n = 0;
    AppMethodBeat.i(97606);
    Object localObject5 = null;
    localObject1 = null;
    localObject4 = localObject1;
    Object localObject2 = localObject5;
    for (;;)
    {
      try
      {
        localOptions = new BitmapFactory.Options();
        localObject4 = localObject1;
        localObject2 = localObject5;
        localOptions.inJustDecodeBounds = true;
        localObject4 = localObject1;
        localObject2 = localObject5;
        localObject5 = y.Lh(paramString);
        localObject1 = localObject5;
        localObject4 = localObject5;
        localObject2 = localObject5;
        if (!((InputStream)localObject5).markSupported())
        {
          localObject4 = localObject5;
          localObject2 = localObject5;
          localObject1 = new BufferedInputStream((InputStream)localObject5);
        }
        localObject4 = localObject1;
        localObject2 = localObject1;
        ((InputStream)localObject1).mark(1048576);
        localObject4 = localObject1;
        localObject2 = localObject1;
        BitmapUtil.decodeFile(paramString, localOptions);
        localObject4 = localObject1;
        localObject2 = localObject1;
        ((InputStream)localObject1).reset();
        localObject4 = localObject1;
        localObject2 = localObject1;
        localObject5 = new Exif();
        localObject4 = localObject1;
        localObject2 = localObject1;
        ((Exif)localObject5).parseFromStream((InputStream)localObject1);
        localObject4 = localObject1;
        localObject2 = localObject1;
        i = ((Exif)localObject5).getOrientationInDegree();
        if ((i == 90) || (i == 270))
        {
          localObject4 = localObject1;
          localObject2 = localObject1;
          k = localOptions.outWidth;
          localObject2 = localObject1;
          i = k;
        }
      }
      catch (Exception localException1)
      {
        BitmapFactory.Options localOptions;
        i = 0;
        localObject1 = localObject4;
        localObject4 = localException1;
        localObject3 = localObject1;
        Log.printErrStackTrace("MicroMsg.snsMediaStorage", localObject4, "setImageExtInfo failed: ".concat(String.valueOf(paramString)), new Object[0]);
        k = i;
        m = n;
        if (localObject1 == null) {
          continue;
        }
        try
        {
          ((InputStream)localObject1).close();
          k = i;
          m = n;
        }
        catch (IOException localIOException1)
        {
          k = i;
          m = n;
        }
        continue;
      }
      finally
      {
        if (localObject3 == null) {}
      }
      for (;;)
      {
        try
        {
          j = localOptions.outHeight;
          i = k;
          k = i;
          m = j;
          if (localObject1 == null) {
            break;
          }
        }
        catch (Exception localException2)
        {
          break label332;
        }
        try
        {
          ((InputStream)localObject1).close();
          m = j;
          k = i;
        }
        catch (IOException localIOException2)
        {
          try
          {
            localObject3.close();
            AppMethodBeat.o(97606);
            throw params;
            localIOException2 = localIOException2;
            k = i;
            m = j;
          }
          catch (IOException paramString) {}
        }
      }
      params.width = m;
      params.height = k;
      params.fileSize = ((int)y.bEl(paramString));
      AppMethodBeat.o(97606);
      return params;
      localObject4 = localObject1;
      localObject2 = localObject1;
      j = localOptions.outHeight;
      localObject2 = localObject1;
      i = j;
      k = localOptions.outWidth;
      i = j;
      j = k;
    }
  }
  
  private static boolean a(Bitmap paramBitmap, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(306620);
    try
    {
      byte[] arrayOfByte = aP(paramBitmap);
      f.dxM();
      if (f.a(arrayOfByte, paramString1, paramString2, paramBitmap.getWidth(), paramBitmap.getHeight(), paramInt1, paramInt2) == 0)
      {
        AppMethodBeat.o(306620);
        return true;
      }
      AppMethodBeat.o(306620);
      return false;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      Log.w("MicroMsg.snsMediaStorage", "convertImg2WxamZip bmp OutOfMemoryError! rollback");
      AppMethodBeat.o(306620);
    }
    return false;
  }
  
  /* Error */
  private static boolean a(BitmapFactory.Options paramOptions, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap.CompressFormat paramCompressFormat, int paramInt5, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 664
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 22
    //   9: ldc 65
    //   11: ldc_w 666
    //   14: iconst_4
    //   15: anewarray 69	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: iload_2
    //   21: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: iload_3
    //   28: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   31: aastore
    //   32: dup
    //   33: iconst_2
    //   34: iload 5
    //   36: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   39: aastore
    //   40: dup
    //   41: iconst_3
    //   42: iload 4
    //   44: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: aastore
    //   48: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: new 581	android/graphics/BitmapFactory$Options
    //   54: dup
    //   55: invokespecial 582	android/graphics/BitmapFactory$Options:<init>	()V
    //   58: astore 21
    //   60: iload_3
    //   61: i2d
    //   62: dconst_1
    //   63: dmul
    //   64: iload 4
    //   66: i2d
    //   67: ddiv
    //   68: dstore 11
    //   70: iload_2
    //   71: i2d
    //   72: dconst_1
    //   73: dmul
    //   74: iload 5
    //   76: i2d
    //   77: ddiv
    //   78: dstore 13
    //   80: iload_2
    //   81: iload 5
    //   83: if_icmpne +45 -> 128
    //   86: iload_3
    //   87: iload 4
    //   89: if_icmpne +39 -> 128
    //   92: aload_1
    //   93: aload 21
    //   95: aload_0
    //   96: invokestatic 671	com/tencent/mm/plugin/sns/e/a:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   99: astore_0
    //   100: ldc 65
    //   102: ldc_w 673
    //   105: iconst_1
    //   106: anewarray 69	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: aload_0
    //   112: aastore
    //   113: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   116: aload_0
    //   117: ifnonnull +259 -> 376
    //   120: ldc_w 664
    //   123: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: iconst_0
    //   127: ireturn
    //   128: aload 21
    //   130: iconst_1
    //   131: putfield 676	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   134: iload_3
    //   135: iload 4
    //   137: if_icmpgt +9 -> 146
    //   140: iload_2
    //   141: iload 5
    //   143: if_icmple +71 -> 214
    //   146: iconst_1
    //   147: ldc_w 678
    //   150: invokestatic 684	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   153: checkcast 678	com/tencent/mm/plugin/expt/b/c
    //   156: getstatic 690	com/tencent/mm/plugin/expt/b/c$a:yJb	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   159: iconst_0
    //   160: invokeinterface 693 3 0
    //   165: if_icmpne +157 -> 322
    //   168: iconst_1
    //   169: istore 17
    //   171: getstatic 698	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_PURPLE	Z
    //   174: ifne +725 -> 899
    //   177: getstatic 701	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   180: ifne +719 -> 899
    //   183: getstatic 704	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   186: ifeq +710 -> 896
    //   189: goto +710 -> 899
    //   192: aload 21
    //   194: iload 18
    //   196: putfield 676	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   199: aload 21
    //   201: getfield 676	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   204: iconst_1
    //   205: if_icmpgt +9 -> 214
    //   208: aload 21
    //   210: iconst_1
    //   211: putfield 676	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   214: ldc_w 678
    //   217: invokestatic 684	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   220: checkcast 678	com/tencent/mm/plugin/expt/b/c
    //   223: getstatic 707	com/tencent/mm/plugin/expt/b/c$a:yJc	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   226: ldc_w 708
    //   229: invokeinterface 693 3 0
    //   234: i2l
    //   235: lstore 19
    //   237: iload_3
    //   238: iload_2
    //   239: imul
    //   240: aload 21
    //   242: getfield 676	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   245: idiv
    //   246: aload 21
    //   248: getfield 676	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   251: idiv
    //   252: i2l
    //   253: lload 19
    //   255: lcmp
    //   256: ifle +86 -> 342
    //   259: aload 21
    //   261: aload 21
    //   263: getfield 676	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   266: iconst_1
    //   267: iadd
    //   268: putfield 676	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   271: goto -34 -> 237
    //   274: astore_0
    //   275: aconst_null
    //   276: astore_1
    //   277: ldc 65
    //   279: aload_0
    //   280: ldc_w 710
    //   283: iconst_1
    //   284: anewarray 69	java/lang/Object
    //   287: dup
    //   288: iconst_0
    //   289: aload 9
    //   291: aastore
    //   292: invokestatic 551	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   295: getstatic 483	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
    //   298: ldc2_w 711
    //   301: lconst_1
    //   302: lconst_1
    //   303: invokevirtual 716	com/tencent/mm/plugin/report/service/h:p	(JJJ)V
    //   306: aload_1
    //   307: ifnull +7 -> 314
    //   310: aload_1
    //   311: invokevirtual 719	java/io/OutputStream:close	()V
    //   314: ldc_w 664
    //   317: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   320: iconst_0
    //   321: ireturn
    //   322: iconst_0
    //   323: istore 17
    //   325: goto -154 -> 171
    //   328: dload 11
    //   330: dstore 15
    //   332: goto +582 -> 914
    //   335: dload 13
    //   337: dstore 15
    //   339: goto +597 -> 936
    //   342: ldc 65
    //   344: ldc_w 721
    //   347: iconst_1
    //   348: anewarray 69	java/lang/Object
    //   351: dup
    //   352: iconst_0
    //   353: aload 21
    //   355: getfield 676	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   358: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   361: aastore
    //   362: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   365: aload_1
    //   366: aload 21
    //   368: aload_0
    //   369: invokestatic 671	com/tencent/mm/plugin/sns/e/a:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   372: astore_0
    //   373: goto -273 -> 100
    //   376: iload 10
    //   378: ifeq +329 -> 707
    //   381: dload 11
    //   383: dload 13
    //   385: dcmpg
    //   386: ifge +295 -> 681
    //   389: iload 5
    //   391: i2d
    //   392: dconst_1
    //   393: dmul
    //   394: iload_3
    //   395: i2d
    //   396: dmul
    //   397: iload_2
    //   398: i2d
    //   399: ddiv
    //   400: invokestatic 727	java/lang/Math:ceil	(D)D
    //   403: d2i
    //   404: istore_3
    //   405: iload 5
    //   407: istore_2
    //   408: aload_1
    //   409: invokestatic 732	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$ExifHelper:getExifOrientation	(Ljava/lang/String;)I
    //   412: istore 4
    //   414: iload 4
    //   416: bipush 90
    //   418: if_icmpeq +526 -> 944
    //   421: iload 4
    //   423: sipush 270
    //   426: if_icmpne +467 -> 893
    //   429: goto +515 -> 944
    //   432: ldc 65
    //   434: ldc_w 734
    //   437: iconst_4
    //   438: anewarray 69	java/lang/Object
    //   441: dup
    //   442: iconst_0
    //   443: aload_0
    //   444: invokevirtual 651	android/graphics/Bitmap:getWidth	()I
    //   447: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   450: aastore
    //   451: dup
    //   452: iconst_1
    //   453: aload_0
    //   454: invokevirtual 654	android/graphics/Bitmap:getHeight	()I
    //   457: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   460: aastore
    //   461: dup
    //   462: iconst_2
    //   463: iload_2
    //   464: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   467: aastore
    //   468: dup
    //   469: iconst_3
    //   470: iload_3
    //   471: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   474: aastore
    //   475: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   478: aload_0
    //   479: iload_2
    //   480: iload_3
    //   481: iconst_1
    //   482: invokestatic 738	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   485: astore 23
    //   487: aload_0
    //   488: astore 21
    //   490: aload 23
    //   492: ifnull +19 -> 511
    //   495: aload_0
    //   496: aload 23
    //   498: if_acmpeq +457 -> 955
    //   501: invokestatic 744	com/tencent/mm/memory/k:bvO	()Lcom/tencent/mm/memory/k;
    //   504: aload_0
    //   505: invokevirtual 748	com/tencent/mm/memory/k:N	(Landroid/graphics/Bitmap;)V
    //   508: goto +447 -> 955
    //   511: ldc 65
    //   513: ldc_w 750
    //   516: iconst_2
    //   517: anewarray 69	java/lang/Object
    //   520: dup
    //   521: iconst_0
    //   522: aload 21
    //   524: invokevirtual 651	android/graphics/Bitmap:getWidth	()I
    //   527: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   530: aastore
    //   531: dup
    //   532: iconst_1
    //   533: aload 21
    //   535: invokevirtual 654	android/graphics/Bitmap:getHeight	()I
    //   538: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   541: aastore
    //   542: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   545: invokestatic 753	com/tencent/mm/plugin/sns/storage/aa:hlk	()Z
    //   548: ifeq +235 -> 783
    //   551: iload 10
    //   553: ifeq +230 -> 783
    //   556: aload 21
    //   558: aload_1
    //   559: new 97	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   566: aload 8
    //   568: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: aload 9
    //   573: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: invokestatic 756	com/tencent/mm/plugin/sns/storage/aa:b	(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;)Z
    //   582: ifne +308 -> 890
    //   585: new 97	java/lang/StringBuilder
    //   588: dup
    //   589: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   592: aload 8
    //   594: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: aload 9
    //   599: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   605: invokestatic 532	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   608: pop
    //   609: new 97	java/lang/StringBuilder
    //   612: dup
    //   613: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   616: aload 8
    //   618: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: aload 9
    //   623: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: iconst_0
    //   630: invokestatic 760	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   633: astore 8
    //   635: aload 8
    //   637: astore_0
    //   638: aload 8
    //   640: astore_1
    //   641: aload 21
    //   643: iload 7
    //   645: aload 6
    //   647: aload 8
    //   649: iconst_0
    //   650: invokestatic 764	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToStream	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/io/OutputStream;Z)Z
    //   653: pop
    //   654: aload 8
    //   656: astore_0
    //   657: aload 8
    //   659: astore_1
    //   660: aload 8
    //   662: invokevirtual 719	java/io/OutputStream:close	()V
    //   665: invokestatic 744	com/tencent/mm/memory/k:bvO	()Lcom/tencent/mm/memory/k;
    //   668: aload 21
    //   670: invokevirtual 748	com/tencent/mm/memory/k:N	(Landroid/graphics/Bitmap;)V
    //   673: ldc_w 664
    //   676: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   679: iconst_1
    //   680: ireturn
    //   681: iload 4
    //   683: i2d
    //   684: dconst_1
    //   685: dmul
    //   686: iload_2
    //   687: i2d
    //   688: dmul
    //   689: iload_3
    //   690: i2d
    //   691: ddiv
    //   692: dstore 11
    //   694: dload 11
    //   696: invokestatic 727	java/lang/Math:ceil	(D)D
    //   699: d2i
    //   700: istore_2
    //   701: iload 4
    //   703: istore_3
    //   704: goto -296 -> 408
    //   707: ldc 65
    //   709: ldc_w 766
    //   712: iconst_2
    //   713: anewarray 69	java/lang/Object
    //   716: dup
    //   717: iconst_0
    //   718: aload_0
    //   719: invokevirtual 651	android/graphics/Bitmap:getWidth	()I
    //   722: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   725: aastore
    //   726: dup
    //   727: iconst_1
    //   728: aload_0
    //   729: invokevirtual 654	android/graphics/Bitmap:getHeight	()I
    //   732: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   735: aastore
    //   736: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   739: aload_0
    //   740: astore 21
    //   742: goto -197 -> 545
    //   745: astore_0
    //   746: aload 22
    //   748: astore_1
    //   749: ldc 65
    //   751: aload_0
    //   752: ldc_w 710
    //   755: iconst_1
    //   756: anewarray 69	java/lang/Object
    //   759: dup
    //   760: iconst_0
    //   761: aload 9
    //   763: aastore
    //   764: invokestatic 551	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   767: aload_1
    //   768: ifnull +7 -> 775
    //   771: aload_1
    //   772: invokevirtual 719	java/io/OutputStream:close	()V
    //   775: ldc_w 664
    //   778: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   781: iconst_0
    //   782: ireturn
    //   783: new 97	java/lang/StringBuilder
    //   786: dup
    //   787: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   790: aload 8
    //   792: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: aload 9
    //   797: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   803: iconst_0
    //   804: invokestatic 760	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   807: astore 8
    //   809: aload 8
    //   811: astore_0
    //   812: aload 8
    //   814: astore_1
    //   815: aload 21
    //   817: iload 7
    //   819: aload 6
    //   821: aload 8
    //   823: iconst_0
    //   824: invokestatic 764	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToStream	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/io/OutputStream;Z)Z
    //   827: pop
    //   828: aload 8
    //   830: astore_0
    //   831: aload 8
    //   833: astore_1
    //   834: invokestatic 744	com/tencent/mm/memory/k:bvO	()Lcom/tencent/mm/memory/k;
    //   837: aload 21
    //   839: invokevirtual 748	com/tencent/mm/memory/k:N	(Landroid/graphics/Bitmap;)V
    //   842: aload 8
    //   844: astore_0
    //   845: aload 8
    //   847: astore_1
    //   848: aload 8
    //   850: invokevirtual 719	java/io/OutputStream:close	()V
    //   853: goto -180 -> 673
    //   856: astore 6
    //   858: aload_0
    //   859: astore_1
    //   860: aload 6
    //   862: astore_0
    //   863: goto -586 -> 277
    //   866: astore_0
    //   867: goto -553 -> 314
    //   870: astore_0
    //   871: goto -96 -> 775
    //   874: astore_0
    //   875: goto -126 -> 749
    //   878: astore_0
    //   879: aconst_null
    //   880: astore_1
    //   881: goto -132 -> 749
    //   884: astore_0
    //   885: aconst_null
    //   886: astore_1
    //   887: goto -610 -> 277
    //   890: goto -225 -> 665
    //   893: goto -461 -> 432
    //   896: goto +6 -> 902
    //   899: iconst_1
    //   900: istore 17
    //   902: dload 11
    //   904: dload 13
    //   906: dcmpg
    //   907: ifge -579 -> 328
    //   910: dload 13
    //   912: dstore 15
    //   914: dload 15
    //   916: d2i
    //   917: istore 18
    //   919: iload 17
    //   921: ifeq -729 -> 192
    //   924: dload 11
    //   926: dload 13
    //   928: dcmpg
    //   929: ifge -594 -> 335
    //   932: dload 11
    //   934: dstore 15
    //   936: dload 15
    //   938: d2i
    //   939: istore 18
    //   941: goto -749 -> 192
    //   944: iload_2
    //   945: istore 4
    //   947: iload_3
    //   948: istore_2
    //   949: iload 4
    //   951: istore_3
    //   952: goto -520 -> 432
    //   955: aload 23
    //   957: astore 21
    //   959: goto -448 -> 511
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	962	0	paramOptions	BitmapFactory.Options
    //   0	962	1	paramString1	String
    //   0	962	2	paramInt1	int
    //   0	962	3	paramInt2	int
    //   0	962	4	paramInt3	int
    //   0	962	5	paramInt4	int
    //   0	962	6	paramCompressFormat	Bitmap.CompressFormat
    //   0	962	7	paramInt5	int
    //   0	962	8	paramString2	String
    //   0	962	9	paramString3	String
    //   0	962	10	paramBoolean	boolean
    //   68	865	11	d1	double
    //   78	849	13	d2	double
    //   330	607	15	d3	double
    //   169	751	17	i	int
    //   194	746	18	j	int
    //   235	19	19	l	long
    //   58	900	21	localObject1	Object
    //   7	740	22	localObject2	Object
    //   485	471	23	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   9	80	274	java/lang/OutOfMemoryError
    //   92	100	274	java/lang/OutOfMemoryError
    //   100	116	274	java/lang/OutOfMemoryError
    //   128	134	274	java/lang/OutOfMemoryError
    //   146	168	274	java/lang/OutOfMemoryError
    //   171	189	274	java/lang/OutOfMemoryError
    //   192	214	274	java/lang/OutOfMemoryError
    //   214	237	274	java/lang/OutOfMemoryError
    //   237	271	274	java/lang/OutOfMemoryError
    //   342	373	274	java/lang/OutOfMemoryError
    //   389	405	274	java/lang/OutOfMemoryError
    //   408	414	274	java/lang/OutOfMemoryError
    //   432	487	274	java/lang/OutOfMemoryError
    //   501	508	274	java/lang/OutOfMemoryError
    //   511	545	274	java/lang/OutOfMemoryError
    //   545	551	274	java/lang/OutOfMemoryError
    //   556	635	274	java/lang/OutOfMemoryError
    //   694	701	274	java/lang/OutOfMemoryError
    //   707	739	274	java/lang/OutOfMemoryError
    //   783	809	274	java/lang/OutOfMemoryError
    //   9	80	745	java/io/IOException
    //   92	100	745	java/io/IOException
    //   100	116	745	java/io/IOException
    //   128	134	745	java/io/IOException
    //   146	168	745	java/io/IOException
    //   171	189	745	java/io/IOException
    //   192	214	745	java/io/IOException
    //   214	237	745	java/io/IOException
    //   237	271	745	java/io/IOException
    //   342	373	745	java/io/IOException
    //   389	405	745	java/io/IOException
    //   408	414	745	java/io/IOException
    //   432	487	745	java/io/IOException
    //   501	508	745	java/io/IOException
    //   511	545	745	java/io/IOException
    //   545	551	745	java/io/IOException
    //   556	635	745	java/io/IOException
    //   694	701	745	java/io/IOException
    //   707	739	745	java/io/IOException
    //   783	809	745	java/io/IOException
    //   641	654	856	java/lang/OutOfMemoryError
    //   660	665	856	java/lang/OutOfMemoryError
    //   815	828	856	java/lang/OutOfMemoryError
    //   834	842	856	java/lang/OutOfMemoryError
    //   848	853	856	java/lang/OutOfMemoryError
    //   310	314	866	java/io/IOException
    //   771	775	870	java/io/IOException
    //   641	654	874	java/io/IOException
    //   660	665	874	java/io/IOException
    //   815	828	874	java/io/IOException
    //   834	842	874	java/io/IOException
    //   848	853	874	java/io/IOException
    //   665	673	878	java/io/IOException
    //   665	673	884	java/lang/OutOfMemoryError
  }
  
  private static boolean a(BitmapFactory.Options paramOptions, String paramString1, int paramInt1, int paramInt2, int paramInt3, Bitmap.CompressFormat paramCompressFormat, int paramInt4, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(306713);
    localObject3 = null;
    localObject1 = localObject3;
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, srcWidth: %d, srcHeight: %d, fixShort: %d, quality:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
        localObject1 = localObject3;
        localObject2 = new BitmapFactory.Options();
        if (paramInt2 <= paramInt1) {
          continue;
        }
        i = paramInt1;
        if (i != paramInt3) {
          continue;
        }
        localObject1 = localObject3;
        paramOptions = com.tencent.mm.plugin.sns.e.a.a(paramString1, (BitmapFactory.Options)localObject2, paramOptions);
      }
      catch (OutOfMemoryError paramOptions)
      {
        long l;
        paramString1 = null;
        Log.printErrStackTrace("MicroMsg.snsMediaStorage", paramOptions, "create thumbnail from orig failed: %s", new Object[] { paramString3 });
        com.tencent.mm.plugin.report.service.h.OAn.p(1487L, 0L, 1L);
        if (paramString1 == null) {
          continue;
        }
      }
      catch (IOException paramOptions)
      {
        try
        {
          int i;
          paramString1.close();
          AppMethodBeat.o(306713);
          return false;
          localObject1 = localObject3;
          Log.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, sampleSize: %s", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject2).inSampleSize) });
          localObject1 = localObject3;
          paramOptions = com.tencent.mm.plugin.sns.e.a.a(paramString1, (BitmapFactory.Options)localObject2, paramOptions);
          continue;
          localObject1 = localObject3;
          j = paramInt1 * paramInt3 / i;
          localObject1 = localObject3;
          paramInt3 = paramInt2 * paramInt3 / i;
          localObject1 = localObject3;
          int m = BackwardSupportUtil.ExifHelper.getExifOrientation(paramString1);
          if (m == 90) {
            continue;
          }
          if (m != 270) {
            continue;
          }
          continue;
          localObject1 = localObject3;
          Log.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, bm.width: %s, bm.height: %s, new:[%d,%d], src:[%d, %d], shortEdge:%d,degree:%d", new Object[] { Integer.valueOf(paramOptions.getWidth()), Integer.valueOf(paramOptions.getHeight()), Integer.valueOf(j), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(m) });
          localObject1 = localObject3;
          Bitmap localBitmap = Bitmap.createScaledBitmap(paramOptions, j, paramInt3, true);
          if (localBitmap == null) {
            continue;
          }
          localObject2 = localBitmap;
          if (paramOptions != localBitmap)
          {
            localObject1 = localObject3;
            com.tencent.mm.memory.k.bvO().N(paramOptions);
            localObject2 = localBitmap;
          }
          localObject1 = localObject3;
          Log.i("MicroMsg.snsMediaStorage", "createThumbNailUnScaleFixShort, bm.width: %s, bm.height: %s, quality:%d", new Object[] { Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()), Integer.valueOf(paramInt4) });
          localObject1 = localObject3;
          if ((hlk()) && (paramBoolean))
          {
            localObject1 = localObject3;
            if (!a((Bitmap)localObject2, paramString1, paramString2 + paramString3, j, paramInt3))
            {
              localObject1 = localObject3;
              y.deleteFile(paramString2 + paramString3);
              localObject1 = localObject3;
              paramString1 = y.ev(paramString2 + paramString3, false);
              localObject1 = paramString1;
              paramOptions = paramString1;
            }
          }
          try
          {
            BitmapUtil.saveBitmapToStream((Bitmap)localObject2, paramInt4, paramCompressFormat, paramString1, false);
            localObject1 = paramString1;
            paramOptions = paramString1;
            paramString1.close();
            localObject1 = null;
            com.tencent.mm.memory.k.bvO().N((Bitmap)localObject2);
            localObject1 = null;
            Log.i("MicroMsg.snsMediaStorage", "createThumbNailUnScaleFixShort saving to %s, size:%d", new Object[] { paramString2 + paramString3, Long.valueOf(y.bEl(paramString2 + paramString3)) });
            AppMethodBeat.o(306713);
            return true;
          }
          catch (OutOfMemoryError paramCompressFormat)
          {
            paramString1 = paramOptions;
            paramOptions = paramCompressFormat;
          }
          localObject1 = localObject3;
          paramString1 = y.ev(paramString2 + paramString3, false);
          localObject1 = paramString1;
          paramOptions = paramString1;
          BitmapUtil.saveBitmapToStream((Bitmap)localObject2, paramInt4, paramCompressFormat, paramString1, false);
          localObject1 = paramString1;
          paramOptions = paramString1;
          com.tencent.mm.memory.k.bvO().N((Bitmap)localObject2);
          localObject1 = paramString1;
          paramOptions = paramString1;
          paramString1.close();
          continue;
          paramOptions = paramOptions;
          Log.printErrStackTrace("MicroMsg.snsMediaStorage", paramOptions, "create thumbnail from orig failed: %s", new Object[] { paramString3 });
          if (localObject1 == null) {}
        }
        catch (IOException paramOptions)
        {
          try
          {
            ((OutputStream)localObject1).close();
            AppMethodBeat.o(306713);
            return false;
            paramOptions = paramOptions;
          }
          catch (IOException paramOptions)
          {
            continue;
          }
        }
        continue;
        Object localObject2 = paramOptions;
        continue;
        continue;
        int k = paramInt3;
        paramInt3 = j;
        int j = k;
        continue;
      }
      localObject1 = localObject3;
      Log.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, result bm: %s", new Object[] { paramOptions });
      if (paramOptions != null) {
        continue;
      }
      AppMethodBeat.o(306713);
      return false;
      i = paramInt2;
    }
    localObject1 = localObject3;
    ((BitmapFactory.Options)localObject2).inSampleSize = 1;
    if (i > paramInt3)
    {
      localObject1 = localObject3;
      ((BitmapFactory.Options)localObject2).inSampleSize = (i / paramInt3);
      localObject1 = localObject3;
      if (((BitmapFactory.Options)localObject2).inSampleSize <= 1)
      {
        localObject1 = localObject3;
        ((BitmapFactory.Options)localObject2).inSampleSize = 1;
      }
    }
    localObject1 = localObject3;
    l = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yJc, 10240000);
    for (;;)
    {
      localObject1 = localObject3;
      if (paramInt2 * paramInt1 / ((BitmapFactory.Options)localObject2).inSampleSize / ((BitmapFactory.Options)localObject2).inSampleSize <= l) {
        break;
      }
      localObject1 = localObject3;
      ((BitmapFactory.Options)localObject2).inSampleSize += 1;
    }
  }
  
  private boolean a(z paramz)
  {
    AppMethodBeat.i(97599);
    Log.d("MicroMsg.snsMediaStorage", "snsMedia Insert");
    if (paramz == null)
    {
      AppMethodBeat.o(97599);
      return false;
    }
    paramz = paramz.hlf();
    if ((int)this.omV.insert("SnsMedia", "local_id", paramz) != -1)
    {
      AppMethodBeat.o(97599);
      return true;
    }
    AppMethodBeat.o(97599);
    return false;
  }
  
  private static boolean a(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(97613);
    BitmapFactory.Options localOptions = BitmapUtil.getImageOptions(paramString1);
    if ((localOptions == null) || (localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
    {
      AppMethodBeat.o(97613);
      return false;
    }
    paramBoolean = a(localOptions, paramString1, localOptions.outWidth, localOptions.outHeight, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(97613);
    return paramBoolean;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, float paramFloat)
  {
    AppMethodBeat.i(97616);
    d4 = 0.0D;
    j = 1;
    i = 1;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    try
    {
      localObject3 = y.Lh(paramString1 + paramString2);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject3;
        int k;
        String str;
        label135:
        double d7;
        double d8;
        Object localObject2;
        Object localObject1;
        double d6;
        label312:
        Object localObject4 = null;
        d1 = 0.0D;
        i = j;
        if (localObject4 != null)
        {
          try
          {
            localObject4.close();
            d2 = 240.0D;
            d3 = 240.0D;
          }
          catch (IOException localIOException) {}
        }
        else
        {
          d2 = 240.0D;
          d3 = 240.0D;
          continue;
          paramString2 = Bitmap.CompressFormat.JPEG;
        }
      }
    }
    try
    {
      localOptions.inJustDecodeBounds = true;
      MMBitmapFactory.decodeStream((InputStream)localObject3, null, localOptions);
      ((InputStream)localObject3).close();
      localObject3 = null;
    }
    catch (Exception localException2)
    {
      d1 = 0.0D;
      i = j;
      break label428;
    }
    try
    {
      d1 = localOptions.outWidth;
      k = localOptions.outHeight;
      d4 = k;
      if ((d1 > 120.0D) || (d4 > 120.0D)) {
        i = 0;
      }
    }
    catch (Exception localException3)
    {
      d1 = 0.0D;
      i = j;
      break label428;
    }
    try
    {
      str = localOptions.outMimeType;
      if (d1 < 0.0D) {
        break label520;
      }
      if (d4 >= 0.0D) {
        break label509;
      }
    }
    catch (Exception localException4)
    {
      break label428;
      d3 = d5;
      break label312;
      d2 = d4;
      d3 = d1;
      break label135;
      d2 = 240.0D;
      d3 = 240.0D;
      break label135;
    }
    d7 = paramFloat;
    d8 = paramFloat / 200.0F * 44.0F;
    d5 = paramFloat / 200.0F * 160.0F;
    if ((localObject2 > 0.0D) && (localObject1 > 0.0D))
    {
      d6 = Math.min(d7 / localObject2, d7 / localObject1);
      d5 = localObject2 * d6;
      d6 *= localObject1;
      d2 = d6;
      d3 = d5;
      if (d5 < d8)
      {
        d2 = 1.0D * d8 / d5;
        d3 = d5 * d2;
        d2 = d6 * d2;
      }
      d5 = d2;
      d6 = d3;
      if (d2 < d8)
      {
        d5 = 1.0D * d8 / d2;
        d6 = d3 * d5;
        d5 = d2 * d5;
      }
      d2 = d6;
      if (d6 > d7) {
        d2 = d7;
      }
      if (d5 > d7)
      {
        d3 = d7;
        d5 = d3;
        d3 = d2;
        d2 = d5;
      }
    }
    else
    {
      for (;;)
      {
        localObject3 = paramString1 + paramString2;
        j = (int)d1;
        k = (int)d4;
        int m = (int)d2;
        int n = (int)d3;
        if (i == 0) {
          break;
        }
        paramString2 = Bitmap.CompressFormat.PNG;
        boolean bool = a(localOptions, (String)localObject3, j, k, m, n, paramString2, 70, paramString1, paramString3, false);
        AppMethodBeat.o(97616);
        return bool;
        d2 = d5;
        d3 = d5;
      }
    }
  }
  
  private static byte[] aP(Bitmap paramBitmap)
  {
    AppMethodBeat.i(306603);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramBitmap.getByteCount());
    paramBitmap.copyPixelsToBuffer(localByteBuffer);
    paramBitmap = localByteBuffer.array();
    AppMethodBeat.o(306603);
    return paramBitmap;
  }
  
  private static boolean b(Bitmap paramBitmap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(306615);
    try
    {
      byte[] arrayOfByte = aP(paramBitmap);
      f.dxM();
      if (f.a(arrayOfByte, paramString1, paramString2, paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getWidth(), paramBitmap.getHeight()) == 0)
      {
        AppMethodBeat.o(306615);
        return true;
      }
      AppMethodBeat.o(306615);
      return false;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      Log.w("MicroMsg.snsMediaStorage", "convertImg2WxamWithoutZip bmp OutOfMemoryError! rollback");
      AppMethodBeat.o(306615);
    }
    return false;
  }
  
  private boolean b(String paramString, z paramz)
  {
    AppMethodBeat.i(97601);
    paramz = paramz.hlf();
    if (this.omV.update("SnsMedia", paramz, "StrId=?", new String[] { String.valueOf(paramString) }) > 0)
    {
      AppMethodBeat.o(97601);
      return true;
    }
    AppMethodBeat.o(97601);
    return false;
  }
  
  public static boolean b(String paramString1, String paramString2, String paramString3, float paramFloat)
  {
    AppMethodBeat.i(97618);
    for (;;)
    {
      try
      {
        y.deleteFile(paramString1 + paramString3);
        localObject1 = BitmapUtil.getImageOptions(paramString1 + paramString2);
        if (localObject1 == null)
        {
          Log.e("MicroMsg.snsMediaStorage", "createUserAlbum, getImageOptions error");
          AppMethodBeat.o(97618);
          return false;
        }
        if ((((BitmapFactory.Options)localObject1).outMimeType == null) || ((!((BitmapFactory.Options)localObject1).outMimeType.toLowerCase().endsWith("png")) && (!((BitmapFactory.Options)localObject1).outMimeType.toLowerCase().endsWith("vcodec")) && (!((BitmapFactory.Options)localObject1).outMimeType.toLowerCase().endsWith("wxam")))) {
          continue;
        }
        localObject1 = BitmapUtil.extractThumbNail(paramString1 + paramString2, (int)paramFloat, (int)paramFloat, true);
      }
      catch (OutOfMemoryError paramString1)
      {
        int i1;
        int n;
        double d2;
        Log.printErrStackTrace("MicroMsg.snsMediaStorage", paramString1, "create thumbnail from orig failed: %s", new Object[] { paramString3 });
        com.tencent.mm.plugin.report.service.h.OAn.p(1487L, 2L, 1L);
        AppMethodBeat.o(97618);
        return false;
        double d1 = k * 1.0D * i1 / n;
        i = (int)Math.ceil(d1);
        int j = k;
        continue;
        Log.i("MicroMsg.snsMediaStorage", "createUserAlbum, inSampleSize: %s", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject1).inSampleSize) });
        if (n / i1 != k / m) {
          continue;
        }
        Object localObject1 = com.tencent.mm.plugin.sns.e.a.a(paramString1 + paramString2, (BitmapFactory.Options)localObject1, (BitmapFactory.Options)localObject1);
        Log.i("MicroMsg.snsMediaStorage", "createUserAlbum, directly use inSampleSize");
        continue;
        paramFloat = Math.max(i / i1, j / n);
        i = (int)(m / paramFloat);
        j = (int)(k / paramFloat);
        i = Math.min(i1, i);
        j = Math.min(n, j);
        int k = Math.max(0, i1 - i >> 1);
        int m = Math.max(0, n - j >> 1);
        Object localObject2 = new Rect();
        ((Rect)localObject2).left = k;
        ((Rect)localObject2).right = (k + i);
        ((Rect)localObject2).top = m;
        ((Rect)localObject2).bottom = (m + j);
        String str = paramString1 + paramString2;
        long l = System.currentTimeMillis();
        localObject2 = com.tencent.mm.memory.k.bvO().a(str, (Rect)localObject2, (BitmapFactory.Options)localObject1);
        localObject1 = localObject2;
        if (localObject2 == null) {
          continue;
        }
        localObject1 = t.t(str, (Bitmap)localObject2);
        Log.d("MicroMsg.SnsBitmapUtil", "regionDecodeWithRotateByExif used %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        Log.i("MicroMsg.snsMediaStorage", "createUserAlbum, dstWidth: %s, dstHeight: %s, startX: %s, startY: %s, scaleFactor: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(paramFloat) });
        continue;
        Log.i("MicroMsg.snsMediaStorage", "createUserAlbum, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()) });
        i = 1;
        if ((((Bitmap)localObject1).getHeight() > 120) || (((Bitmap)localObject1).getWidth() > 120)) {
          continue;
        }
        if (i == 0) {
          continue;
        }
        paramString2 = Bitmap.CompressFormat.PNG;
        BitmapUtil.saveBitmapToImage((Bitmap)localObject1, 100, paramString2, paramString1 + paramString3, false);
        com.tencent.mm.memory.k.bvO().N((Bitmap)localObject1);
        AppMethodBeat.o(97618);
        return true;
        paramString2 = Bitmap.CompressFormat.JPEG;
        continue;
      }
      catch (Exception paramString1)
      {
        Log.e("MicroMsg.snsMediaStorage", "createUserAlbum error: %s", new Object[] { paramString1.getMessage() });
        Log.printErrStackTrace("MicroMsg.snsMediaStorage", paramString1, "", new Object[0]);
        continue;
        continue;
        int i = 0;
        continue;
      }
      if (localObject1 != null) {
        continue;
      }
      Log.i("MicroMsg.snsMediaStorage", "bitmap error " + paramString1 + paramString2);
      y.deleteFile(paramString1 + paramString2);
      AppMethodBeat.o(97618);
      return false;
      i1 = ((BitmapFactory.Options)localObject1).outWidth;
      n = ((BitmapFactory.Options)localObject1).outHeight;
      m = (int)paramFloat;
      k = (int)paramFloat;
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
      Log.i("MicroMsg.snsMediaStorage", "createUserAlbum, srcWidth: %s, srcHeight: %s, dstWidth: %s, dstHeight: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k) });
      if ((i1 != m) || (n != k)) {
        continue;
      }
      localObject1 = com.tencent.mm.plugin.sns.e.a.a(paramString1 + paramString2, (BitmapFactory.Options)localObject1, (BitmapFactory.Options)localObject1);
    }
    if (n * 1.0D / k > i1 * 1.0D / m)
    {
      j = (int)Math.ceil(m * 1.0D * n / i1);
      i = m;
      Log.d("MicroMsg.snsMediaStorage", "createUserAlbum, newWidth: %s, newHeight: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      if ((n <= j) && (i1 <= i)) {
        break label637;
      }
      ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      if ((n > j) || (i1 > i))
      {
        d1 = n * 1.0D / j;
        d2 = i1 * 1.0D / i;
        if (d1 >= d2) {
          break label1129;
        }
        d1 = d2;
        ((BitmapFactory.Options)localObject1).inSampleSize = ((int)d1);
        if (((BitmapFactory.Options)localObject1).inSampleSize <= 1) {
          ((BitmapFactory.Options)localObject1).inSampleSize = 1;
        }
      }
      l = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.yJc, 10240000);
      while (n * i1 / ((BitmapFactory.Options)localObject1).inSampleSize / ((BitmapFactory.Options)localObject1).inSampleSize > l) {
        ((BitmapFactory.Options)localObject1).inSampleSize += 1;
      }
    }
  }
  
  private static String bak(String paramString)
  {
    AppMethodBeat.i(97598);
    if (paramString == null)
    {
      AppMethodBeat.o(97598);
      return "";
    }
    String str2 = com.tencent.mm.b.g.getMessageDigest(paramString.getBytes());
    paramString = "";
    String str1 = "";
    if (str2.length() > 0) {
      paramString = str2.charAt(0) + "/";
    }
    if (str2.length() >= 2) {
      str1 = str2.charAt(1) + "/";
    }
    paramString = al.getAccSnsPath() + paramString + str1;
    AppMethodBeat.o(97598);
    return paramString;
  }
  
  /* Error */
  public static boolean bam(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 954
    //   5: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 590	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore_0
    //   13: aload_0
    //   14: astore_2
    //   15: new 581	android/graphics/BitmapFactory$Options
    //   18: dup
    //   19: invokespecial 582	android/graphics/BitmapFactory$Options:<init>	()V
    //   22: astore_3
    //   23: aload_0
    //   24: astore_2
    //   25: aload_3
    //   26: iconst_1
    //   27: putfield 586	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   30: aload_0
    //   31: astore_2
    //   32: aload_0
    //   33: aconst_null
    //   34: aload_3
    //   35: invokestatic 803	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   38: pop
    //   39: aload_0
    //   40: astore_2
    //   41: aload_3
    //   42: getfield 808	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   45: astore_3
    //   46: aload_0
    //   47: astore_2
    //   48: ldc 65
    //   50: ldc_w 956
    //   53: aload_3
    //   54: invokestatic 130	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   57: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   60: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_0
    //   64: astore_2
    //   65: aload_3
    //   66: invokevirtual 860	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   69: ldc_w 958
    //   72: invokevirtual 961	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   75: istore_1
    //   76: iload_1
    //   77: iflt +19 -> 96
    //   80: aload_0
    //   81: ifnull +7 -> 88
    //   84: aload_0
    //   85: invokevirtual 630	java/io/InputStream:close	()V
    //   88: ldc_w 954
    //   91: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: iconst_1
    //   95: ireturn
    //   96: aload_0
    //   97: ifnull +7 -> 104
    //   100: aload_0
    //   101: invokevirtual 630	java/io/InputStream:close	()V
    //   104: ldc_w 954
    //   107: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: iconst_0
    //   111: ireturn
    //   112: astore_0
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: ifnull +7 -> 123
    //   119: aload_0
    //   120: invokevirtual 630	java/io/InputStream:close	()V
    //   123: ldc_w 954
    //   126: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: iconst_0
    //   130: ireturn
    //   131: astore_0
    //   132: aload_2
    //   133: ifnull +7 -> 140
    //   136: aload_2
    //   137: invokevirtual 630	java/io/InputStream:close	()V
    //   140: ldc_w 954
    //   143: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: aload_0
    //   147: athrow
    //   148: astore_0
    //   149: goto -61 -> 88
    //   152: astore_0
    //   153: goto -49 -> 104
    //   156: astore_0
    //   157: goto -34 -> 123
    //   160: astore_2
    //   161: goto -21 -> 140
    //   164: astore_2
    //   165: goto -50 -> 115
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramString	String
    //   75	2	1	i	int
    //   1	136	2	str	String
    //   160	1	2	localIOException	IOException
    //   164	1	2	localException	Exception
    //   22	44	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	13	112	java/lang/Exception
    //   8	13	131	finally
    //   15	23	131	finally
    //   25	30	131	finally
    //   32	39	131	finally
    //   41	46	131	finally
    //   48	63	131	finally
    //   65	76	131	finally
    //   84	88	148	java/io/IOException
    //   100	104	152	java/io/IOException
    //   119	123	156	java/io/IOException
    //   136	140	160	java/io/IOException
    //   15	23	164	java/lang/Exception
    //   25	30	164	java/lang/Exception
    //   32	39	164	java/lang/Exception
    //   41	46	164	java/lang/Exception
    //   48	63	164	java/lang/Exception
    //   65	76	164	java/lang/Exception
  }
  
  public static Bitmap ban(String paramString)
  {
    int j = 640;
    AppMethodBeat.i(97619);
    Object localObject = BitmapUtil.getImageOptions(paramString);
    int i;
    if (((BitmapFactory.Options)localObject).outWidth >= ((BitmapFactory.Options)localObject).outHeight)
    {
      i = 960;
      if (((BitmapFactory.Options)localObject).outWidth < ((BitmapFactory.Options)localObject).outHeight) {
        break label68;
      }
    }
    for (;;)
    {
      localObject = BitmapUtil.extractThumbNail(paramString, j, i, false);
      if (localObject != null) {
        break label75;
      }
      AppMethodBeat.o(97619);
      return null;
      i = 640;
      break;
      label68:
      j = 960;
    }
    label75:
    paramString = BitmapUtil.rotate((Bitmap)localObject, Exif.fromFile(paramString).getOrientationInDegree());
    AppMethodBeat.o(97619);
    return paramString;
  }
  
  public static boolean bd(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(369894);
    boolean bool = i(paramString1, paramString2, paramString3, true);
    AppMethodBeat.o(369894);
    return bool;
  }
  
  public static int getScreenWidth()
  {
    if (DRE > CCP) {
      return CCP;
    }
    return DRE;
  }
  
  public static boolean hlj()
  {
    AppMethodBeat.i(97609);
    if ("hevc".equals(com.tencent.mm.platformtools.z.pDe))
    {
      AppMethodBeat.o(97609);
      return true;
    }
    boolean bool = al.hgR();
    AppMethodBeat.o(97609);
    return bool;
  }
  
  public static boolean hlk()
  {
    AppMethodBeat.i(306599);
    if ("wxam".equals(com.tencent.mm.platformtools.z.pDe))
    {
      AppMethodBeat.o(306599);
      return true;
    }
    boolean bool = al.hgT();
    AppMethodBeat.o(306599);
    return bool;
  }
  
  public static boolean hll()
  {
    AppMethodBeat.i(97610);
    if ("wxpc".equals(com.tencent.mm.platformtools.z.pDe))
    {
      AppMethodBeat.o(97610);
      return true;
    }
    boolean bool = al.hgU();
    AppMethodBeat.o(97610);
    return bool;
  }
  
  public static boolean hlm()
  {
    return (CCP >= 1080) && (DRE >= 1080);
  }
  
  /* Error */
  public static boolean i(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 1001
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 793	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   10: astore 20
    //   12: aload 20
    //   14: ifnull +1048 -> 1062
    //   17: aload 20
    //   19: getfield 808	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   22: astore 21
    //   24: ldc 65
    //   26: ldc_w 1003
    //   29: aload 21
    //   31: invokestatic 130	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   34: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload 21
    //   42: ifnull +1020 -> 1062
    //   45: aload 21
    //   47: invokevirtual 860	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   50: astore 21
    //   52: aload 21
    //   54: ldc_w 1005
    //   57: invokevirtual 961	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   60: iflt +968 -> 1028
    //   63: iconst_1
    //   64: istore 16
    //   66: aload 20
    //   68: ifnull +1017 -> 1085
    //   71: aload 20
    //   73: getfield 808	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   76: astore 21
    //   78: aload 21
    //   80: ifnull +1005 -> 1085
    //   83: aload 21
    //   85: invokevirtual 860	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   88: astore 21
    //   90: aload 21
    //   92: ldc_w 1005
    //   95: invokevirtual 961	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   98: iflt +970 -> 1068
    //   101: iconst_1
    //   102: istore 17
    //   104: aload 20
    //   106: ifnull +27 -> 133
    //   109: aload 20
    //   111: getfield 808	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   114: astore 21
    //   116: aload 21
    //   118: ifnull +15 -> 133
    //   121: aload 21
    //   123: invokevirtual 860	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   126: ldc_w 869
    //   129: invokevirtual 961	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   132: pop
    //   133: iconst_m1
    //   134: istore 8
    //   136: bipush 100
    //   138: istore 9
    //   140: iload 8
    //   142: istore 10
    //   144: iload_3
    //   145: ifeq +242 -> 387
    //   148: invokestatic 1011	com/tencent/mm/modelcdntran/k:bHW	()Lcom/tencent/mm/modelcdntran/g;
    //   151: pop
    //   152: bipush 64
    //   154: invokestatic 1017	com/tencent/mm/modelcdntran/g:vV	(I)Z
    //   157: ifne +21 -> 178
    //   160: invokestatic 1019	com/tencent/mm/plugin/sns/storage/aa:hlj	()Z
    //   163: ifne +15 -> 178
    //   166: invokestatic 1021	com/tencent/mm/plugin/sns/storage/aa:hll	()Z
    //   169: ifne +9 -> 178
    //   172: invokestatic 753	com/tencent/mm/plugin/sns/storage/aa:hlk	()Z
    //   175: ifeq +991 -> 1166
    //   178: invokestatic 1027	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   181: invokestatic 1033	com/tencent/mm/sdk/platformtools/NetStatusUtil:isWifi	(Landroid/content/Context;)Z
    //   184: ifeq +907 -> 1091
    //   187: invokestatic 1039	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   190: ldc_w 1041
    //   193: invokevirtual 1046	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   196: bipush 70
    //   198: invokestatic 1050	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   201: istore 7
    //   203: ldc 65
    //   205: ldc_w 1052
    //   208: bipush 7
    //   210: anewarray 69	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: invokestatic 1039	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   218: ldc_w 1041
    //   221: invokevirtual 1046	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   224: aastore
    //   225: dup
    //   226: iconst_1
    //   227: invokestatic 1039	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   230: ldc_w 1054
    //   233: invokevirtual 1046	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   236: aastore
    //   237: dup
    //   238: iconst_2
    //   239: invokestatic 1039	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   242: ldc_w 1056
    //   245: invokevirtual 1046	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   248: aastore
    //   249: dup
    //   250: iconst_3
    //   251: invokestatic 1039	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   254: ldc_w 1058
    //   257: invokevirtual 1046	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   260: aastore
    //   261: dup
    //   262: iconst_4
    //   263: invokestatic 1039	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   266: ldc_w 1060
    //   269: invokevirtual 1046	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   272: aastore
    //   273: dup
    //   274: iconst_5
    //   275: invokestatic 1039	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   278: ldc_w 1062
    //   281: invokevirtual 1046	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   284: aastore
    //   285: dup
    //   286: bipush 6
    //   288: invokestatic 1039	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   291: ldc_w 1064
    //   294: invokevirtual 1046	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   297: aastore
    //   298: invokestatic 881	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: ldc 65
    //   303: ldc_w 1066
    //   306: iconst_2
    //   307: anewarray 69	java/lang/Object
    //   310: dup
    //   311: iconst_0
    //   312: iload 7
    //   314: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   317: aastore
    //   318: dup
    //   319: iconst_1
    //   320: iload_3
    //   321: invokestatic 1071	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   324: aastore
    //   325: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   328: iload 7
    //   330: bipush 10
    //   332: if_icmple +10 -> 342
    //   335: iload 7
    //   337: bipush 100
    //   339: if_icmple +3670 -> 4009
    //   342: bipush 60
    //   344: istore 7
    //   346: iload 8
    //   348: istore 10
    //   350: iload 7
    //   352: istore 9
    //   354: iload 17
    //   356: ifeq +31 -> 387
    //   359: aload_1
    //   360: invokestatic 1076	com/tencent/mm/sdk/platformtools/MMNativeJpeg:queryQuality	(Ljava/lang/String;)I
    //   363: istore 8
    //   365: iload 8
    //   367: iload 7
    //   369: if_icmpge +3629 -> 3998
    //   372: iload 8
    //   374: bipush 25
    //   376: if_icmple +3622 -> 3998
    //   379: iload 8
    //   381: istore 9
    //   383: iload 8
    //   385: istore 10
    //   387: aload_1
    //   388: invokestatic 187	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   391: l2i
    //   392: istore 14
    //   394: sipush 1080
    //   397: istore 8
    //   399: aload_1
    //   400: invokestatic 1081	com/tencent/mm/plugin/facedetect/FaceProNative:detectFaceCnt	(Ljava/lang/String;)I
    //   403: istore 7
    //   405: ldc 65
    //   407: ldc_w 1083
    //   410: iconst_1
    //   411: anewarray 69	java/lang/Object
    //   414: dup
    //   415: iconst_0
    //   416: iload 7
    //   418: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   421: aastore
    //   422: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   425: iload 7
    //   427: iconst_5
    //   428: if_icmplt +8 -> 436
    //   431: sipush 1440
    //   434: istore 8
    //   436: iconst_0
    //   437: istore 11
    //   439: iload 7
    //   441: iconst_5
    //   442: if_icmplt +802 -> 1244
    //   445: iload 11
    //   447: istore 7
    //   449: invokestatic 1039	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   452: ldc_w 1085
    //   455: invokevirtual 1046	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   458: astore 21
    //   460: iload 11
    //   462: istore 7
    //   464: aload 21
    //   466: ldc_w 1087
    //   469: invokevirtual 1091	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   472: iconst_0
    //   473: aaload
    //   474: invokestatic 1094	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   477: invokevirtual 1097	java/lang/Integer:intValue	()I
    //   480: istore 11
    //   482: iload 11
    //   484: istore 7
    //   486: aload 21
    //   488: ldc_w 1087
    //   491: invokevirtual 1091	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   494: iconst_1
    //   495: aaload
    //   496: invokestatic 1094	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   499: invokevirtual 1097	java/lang/Integer:intValue	()I
    //   502: istore 12
    //   504: iload 12
    //   506: istore 8
    //   508: iload 11
    //   510: istore 7
    //   512: ldc 65
    //   514: ldc_w 1099
    //   517: bipush 6
    //   519: anewarray 69	java/lang/Object
    //   522: dup
    //   523: iconst_0
    //   524: iload 7
    //   526: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   529: aastore
    //   530: dup
    //   531: iconst_1
    //   532: iload 8
    //   534: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   537: aastore
    //   538: dup
    //   539: iconst_2
    //   540: getstatic 34	com/tencent/mm/plugin/sns/storage/aa:CCP	I
    //   543: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   546: aastore
    //   547: dup
    //   548: iconst_3
    //   549: getstatic 32	com/tencent/mm/plugin/sns/storage/aa:DRE	I
    //   552: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   555: aastore
    //   556: dup
    //   557: iconst_4
    //   558: iload 9
    //   560: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   563: aastore
    //   564: dup
    //   565: iconst_5
    //   566: iload_3
    //   567: invokestatic 1071	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   570: aastore
    //   571: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   574: iload 7
    //   576: ifgt +987 -> 1563
    //   579: iload 8
    //   581: ifgt +982 -> 1563
    //   584: iconst_0
    //   585: istore 7
    //   587: sipush 1080
    //   590: istore 8
    //   592: invokestatic 1039	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   595: ldc_w 1101
    //   598: invokevirtual 1046	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   601: bipush 100
    //   603: invokestatic 1050	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   606: istore 12
    //   608: iload 12
    //   610: istore 11
    //   612: iload 12
    //   614: ifgt +7 -> 621
    //   617: bipush 100
    //   619: istore 11
    //   621: iload 11
    //   623: sipush 1024
    //   626: imul
    //   627: istore 13
    //   629: invokestatic 1039	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   632: ldc_w 1103
    //   635: invokevirtual 1046	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   638: sipush 200
    //   641: invokestatic 1050	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   644: istore 12
    //   646: iload 12
    //   648: istore 11
    //   650: iload 12
    //   652: ifgt +8 -> 660
    //   655: sipush 200
    //   658: istore 11
    //   660: iload 11
    //   662: sipush 1024
    //   665: imul
    //   666: istore 15
    //   668: invokestatic 1039	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   671: ldc_w 1105
    //   674: invokevirtual 1046	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   677: bipush 10
    //   679: invokestatic 1050	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   682: istore 12
    //   684: iload 12
    //   686: ifle +10 -> 696
    //   689: iload 12
    //   691: bipush 100
    //   693: if_icmplt +3299 -> 3992
    //   696: bipush 10
    //   698: istore 12
    //   700: iconst_0
    //   701: istore 11
    //   703: iload 17
    //   705: ifeq +935 -> 1640
    //   708: aload_1
    //   709: invokestatic 356	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   712: astore 21
    //   714: aload 21
    //   716: ifnull +14 -> 730
    //   719: aload 21
    //   721: invokevirtual 621	com/tencent/mm/compatible/util/Exif:getOrientationInDegree	()I
    //   724: sipush 360
    //   727: irem
    //   728: istore 11
    //   730: ldc 65
    //   732: new 97	java/lang/StringBuilder
    //   735: dup
    //   736: ldc_w 1107
    //   739: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   742: aload 20
    //   744: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   747: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   750: ldc_w 1109
    //   753: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: aload 20
    //   758: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   761: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   764: ldc_w 1109
    //   767: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: iload 16
    //   772: invokevirtual 1112	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   775: ldc_w 1114
    //   778: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: iload 10
    //   783: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   786: ldc_w 1116
    //   789: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: iload 11
    //   794: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   797: ldc_w 1118
    //   800: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: iload 14
    //   805: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   808: ldc_w 1120
    //   811: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: iload 7
    //   816: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   819: ldc_w 1109
    //   822: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: iload 8
    //   827: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   830: ldc_w 1122
    //   833: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: iload 17
    //   838: invokevirtual 1112	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   841: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   844: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   847: invokestatic 1039	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   850: ldc_w 1124
    //   853: invokevirtual 1046	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   856: bipush 10
    //   858: invokestatic 1050	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   861: pop
    //   862: aload 20
    //   864: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   867: aload 20
    //   869: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   872: iconst_2
    //   873: imul
    //   874: if_icmpge +18 -> 892
    //   877: aload 20
    //   879: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   882: aload 20
    //   884: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   887: iconst_2
    //   888: imul
    //   889: if_icmplt +1894 -> 2783
    //   892: aload 20
    //   894: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   897: aload 20
    //   899: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   902: imul
    //   903: ldc_w 708
    //   906: if_icmpgt +1634 -> 2540
    //   909: iload 14
    //   911: iload 15
    //   913: if_icmpge +801 -> 1714
    //   916: iload 16
    //   918: ifeq +796 -> 1714
    //   921: iload 11
    //   923: ifne +791 -> 1714
    //   926: invokestatic 753	com/tencent/mm/plugin/sns/storage/aa:hlk	()Z
    //   929: ifeq +725 -> 1654
    //   932: iload_3
    //   933: ifeq +721 -> 1654
    //   936: aload_1
    //   937: new 97	java/lang/StringBuilder
    //   940: dup
    //   941: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   944: aload_0
    //   945: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: aload_2
    //   949: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   955: invokestatic 1128	com/tencent/mm/plugin/sns/storage/aa:mR	(Ljava/lang/String;Ljava/lang/String;)Z
    //   958: istore 16
    //   960: iload 16
    //   962: istore_3
    //   963: iload 16
    //   965: ifne +55 -> 1020
    //   968: new 97	java/lang/StringBuilder
    //   971: dup
    //   972: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   975: aload_0
    //   976: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: aload_2
    //   980: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   986: invokestatic 532	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   989: pop
    //   990: aload_1
    //   991: new 97	java/lang/StringBuilder
    //   994: dup
    //   995: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   998: aload_0
    //   999: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: aload_2
    //   1003: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1006: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1009: iconst_0
    //   1010: invokestatic 523	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   1013: lconst_0
    //   1014: lcmp
    //   1015: iflt +634 -> 1649
    //   1018: iconst_1
    //   1019: istore_3
    //   1020: ldc_w 1001
    //   1023: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1026: iload_3
    //   1027: ireturn
    //   1028: aload 21
    //   1030: ldc_w 1130
    //   1033: invokevirtual 961	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1036: iflt +9 -> 1045
    //   1039: iconst_1
    //   1040: istore 16
    //   1042: goto -976 -> 66
    //   1045: aload 21
    //   1047: ldc_w 862
    //   1050: invokevirtual 961	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1053: iflt +9 -> 1062
    //   1056: iconst_1
    //   1057: istore 16
    //   1059: goto -993 -> 66
    //   1062: iconst_0
    //   1063: istore 16
    //   1065: goto -999 -> 66
    //   1068: aload 21
    //   1070: ldc_w 1130
    //   1073: invokevirtual 961	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1076: iflt +9 -> 1085
    //   1079: iconst_1
    //   1080: istore 17
    //   1082: goto -978 -> 104
    //   1085: iconst_0
    //   1086: istore 17
    //   1088: goto -984 -> 104
    //   1091: invokestatic 1027	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1094: invokestatic 1133	com/tencent/mm/sdk/platformtools/NetStatusUtil:is2G	(Landroid/content/Context;)Z
    //   1097: ifeq +22 -> 1119
    //   1100: invokestatic 1039	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   1103: ldc_w 1054
    //   1106: invokevirtual 1046	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1109: bipush 70
    //   1111: invokestatic 1050	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   1114: istore 7
    //   1116: goto -913 -> 203
    //   1119: invokestatic 1027	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1122: invokestatic 1136	com/tencent/mm/sdk/platformtools/NetStatusUtil:is3G	(Landroid/content/Context;)Z
    //   1125: ifeq +22 -> 1147
    //   1128: invokestatic 1039	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   1131: ldc_w 1056
    //   1134: invokevirtual 1046	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1137: bipush 60
    //   1139: invokestatic 1050	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   1142: istore 7
    //   1144: goto -941 -> 203
    //   1147: invokestatic 1039	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   1150: ldc_w 1058
    //   1153: invokevirtual 1046	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1156: bipush 60
    //   1158: invokestatic 1050	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   1161: istore 7
    //   1163: goto -960 -> 203
    //   1166: invokestatic 1027	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1169: invokestatic 1033	com/tencent/mm/sdk/platformtools/NetStatusUtil:isWifi	(Landroid/content/Context;)Z
    //   1172: ifeq +23 -> 1195
    //   1175: invokestatic 1039	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   1178: ldc_w 1060
    //   1181: invokevirtual 1046	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1184: invokestatic 1094	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1187: invokevirtual 1097	java/lang/Integer:intValue	()I
    //   1190: istore 7
    //   1192: goto -989 -> 203
    //   1195: invokestatic 1027	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1198: invokestatic 1133	com/tencent/mm/sdk/platformtools/NetStatusUtil:is2G	(Landroid/content/Context;)Z
    //   1201: ifeq +23 -> 1224
    //   1204: invokestatic 1039	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   1207: ldc_w 1062
    //   1210: invokevirtual 1046	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1213: invokestatic 1094	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1216: invokevirtual 1097	java/lang/Integer:intValue	()I
    //   1219: istore 7
    //   1221: goto -1018 -> 203
    //   1224: invokestatic 1039	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   1227: ldc_w 1064
    //   1230: invokevirtual 1046	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1233: invokestatic 1094	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1236: invokevirtual 1097	java/lang/Integer:intValue	()I
    //   1239: istore 7
    //   1241: goto -1038 -> 203
    //   1244: iload 11
    //   1246: istore 7
    //   1248: invokestatic 1027	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1251: invokestatic 1033	com/tencent/mm/sdk/platformtools/NetStatusUtil:isWifi	(Landroid/content/Context;)Z
    //   1254: ifeq +73 -> 1327
    //   1257: iload 11
    //   1259: istore 7
    //   1261: invokestatic 1039	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   1264: ldc_w 1138
    //   1267: invokevirtual 1046	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1270: astore 21
    //   1272: iload 11
    //   1274: istore 7
    //   1276: aload 21
    //   1278: ldc_w 1087
    //   1281: invokevirtual 1091	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1284: iconst_0
    //   1285: aaload
    //   1286: invokestatic 1094	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1289: invokevirtual 1097	java/lang/Integer:intValue	()I
    //   1292: istore 11
    //   1294: iload 11
    //   1296: istore 7
    //   1298: aload 21
    //   1300: ldc_w 1087
    //   1303: invokevirtual 1091	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1306: iconst_1
    //   1307: aaload
    //   1308: invokestatic 1094	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1311: invokevirtual 1097	java/lang/Integer:intValue	()I
    //   1314: istore 12
    //   1316: iload 12
    //   1318: istore 8
    //   1320: iload 11
    //   1322: istore 7
    //   1324: goto -812 -> 512
    //   1327: iload 11
    //   1329: istore 7
    //   1331: invokestatic 1027	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1334: invokestatic 1133	com/tencent/mm/sdk/platformtools/NetStatusUtil:is2G	(Landroid/content/Context;)Z
    //   1337: ifeq +73 -> 1410
    //   1340: iload 11
    //   1342: istore 7
    //   1344: invokestatic 1039	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   1347: ldc_w 1140
    //   1350: invokevirtual 1046	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1353: astore 21
    //   1355: iload 11
    //   1357: istore 7
    //   1359: aload 21
    //   1361: ldc_w 1087
    //   1364: invokevirtual 1091	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1367: iconst_0
    //   1368: aaload
    //   1369: invokestatic 1094	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1372: invokevirtual 1097	java/lang/Integer:intValue	()I
    //   1375: istore 11
    //   1377: iload 11
    //   1379: istore 7
    //   1381: aload 21
    //   1383: ldc_w 1087
    //   1386: invokevirtual 1091	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1389: iconst_1
    //   1390: aaload
    //   1391: invokestatic 1094	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1394: invokevirtual 1097	java/lang/Integer:intValue	()I
    //   1397: istore 12
    //   1399: iload 12
    //   1401: istore 8
    //   1403: iload 11
    //   1405: istore 7
    //   1407: goto -895 -> 512
    //   1410: iload 11
    //   1412: istore 7
    //   1414: invokestatic 1027	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1417: invokestatic 1136	com/tencent/mm/sdk/platformtools/NetStatusUtil:is3G	(Landroid/content/Context;)Z
    //   1420: ifeq +73 -> 1493
    //   1423: iload 11
    //   1425: istore 7
    //   1427: invokestatic 1039	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   1430: ldc_w 1142
    //   1433: invokevirtual 1046	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1436: astore 21
    //   1438: iload 11
    //   1440: istore 7
    //   1442: aload 21
    //   1444: ldc_w 1087
    //   1447: invokevirtual 1091	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1450: iconst_0
    //   1451: aaload
    //   1452: invokestatic 1094	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1455: invokevirtual 1097	java/lang/Integer:intValue	()I
    //   1458: istore 11
    //   1460: iload 11
    //   1462: istore 7
    //   1464: aload 21
    //   1466: ldc_w 1087
    //   1469: invokevirtual 1091	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1472: iconst_1
    //   1473: aaload
    //   1474: invokestatic 1094	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1477: invokevirtual 1097	java/lang/Integer:intValue	()I
    //   1480: istore 12
    //   1482: iload 12
    //   1484: istore 8
    //   1486: iload 11
    //   1488: istore 7
    //   1490: goto -978 -> 512
    //   1493: iload 11
    //   1495: istore 7
    //   1497: invokestatic 1039	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   1500: ldc_w 1144
    //   1503: invokevirtual 1046	com/tencent/mm/k/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1506: astore 21
    //   1508: iload 11
    //   1510: istore 7
    //   1512: aload 21
    //   1514: ldc_w 1087
    //   1517: invokevirtual 1091	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1520: iconst_0
    //   1521: aaload
    //   1522: invokestatic 1094	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1525: invokevirtual 1097	java/lang/Integer:intValue	()I
    //   1528: istore 11
    //   1530: iload 11
    //   1532: istore 7
    //   1534: aload 21
    //   1536: ldc_w 1087
    //   1539: invokevirtual 1091	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1542: iconst_1
    //   1543: aaload
    //   1544: invokestatic 1094	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1547: invokevirtual 1097	java/lang/Integer:intValue	()I
    //   1550: istore 12
    //   1552: iload 12
    //   1554: istore 8
    //   1556: iload 11
    //   1558: istore 7
    //   1560: goto -1048 -> 512
    //   1563: iload 8
    //   1565: sipush 2160
    //   1568: if_icmplt +14 -> 1582
    //   1571: iconst_0
    //   1572: istore 7
    //   1574: sipush 1080
    //   1577: istore 8
    //   1579: goto -987 -> 592
    //   1582: iload 8
    //   1584: ifgt +2411 -> 3995
    //   1587: iload 7
    //   1589: sipush 3240
    //   1592: if_icmple +2403 -> 3995
    //   1595: sipush 1620
    //   1598: istore 7
    //   1600: iconst_0
    //   1601: istore 8
    //   1603: goto -1011 -> 592
    //   1606: astore 21
    //   1608: ldc 65
    //   1610: new 97	java/lang/StringBuilder
    //   1613: dup
    //   1614: ldc_w 1146
    //   1617: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1620: aload 21
    //   1622: invokevirtual 940	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1625: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1628: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1631: invokestatic 556	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1634: iconst_0
    //   1635: istore 11
    //   1637: goto -907 -> 730
    //   1640: aload_1
    //   1641: invokestatic 732	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$ExifHelper:getExifOrientation	(Ljava/lang/String;)I
    //   1644: istore 11
    //   1646: goto -916 -> 730
    //   1649: iconst_0
    //   1650: istore_3
    //   1651: goto -631 -> 1020
    //   1654: ldc 65
    //   1656: ldc_w 1148
    //   1659: iload 15
    //   1661: invokestatic 344	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1664: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1667: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1670: aload_1
    //   1671: new 97	java/lang/StringBuilder
    //   1674: dup
    //   1675: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1678: aload_0
    //   1679: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1682: aload_2
    //   1683: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1686: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1689: iconst_0
    //   1690: invokestatic 523	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   1693: lconst_0
    //   1694: lcmp
    //   1695: iflt +11 -> 1706
    //   1698: ldc_w 1001
    //   1701: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1704: iconst_1
    //   1705: ireturn
    //   1706: ldc_w 1001
    //   1709: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1712: iconst_0
    //   1713: ireturn
    //   1714: new 581	android/graphics/BitmapFactory$Options
    //   1717: dup
    //   1718: invokespecial 582	android/graphics/BitmapFactory$Options:<init>	()V
    //   1721: astore 24
    //   1723: getstatic 1153	android/os/Build$VERSION:SDK_INT	I
    //   1726: bipush 26
    //   1728: if_icmple +47 -> 1775
    //   1731: aload 20
    //   1733: ifnull +42 -> 1775
    //   1736: aload 20
    //   1738: getfield 1157	android/graphics/BitmapFactory$Options:outColorSpace	Landroid/graphics/ColorSpace;
    //   1741: getstatic 1163	android/graphics/ColorSpace$Named:DCI_P3	Landroid/graphics/ColorSpace$Named;
    //   1744: invokestatic 1169	android/graphics/ColorSpace:get	(Landroid/graphics/ColorSpace$Named;)Landroid/graphics/ColorSpace;
    //   1747: if_acmpeq +17 -> 1764
    //   1750: aload 20
    //   1752: getfield 1157	android/graphics/BitmapFactory$Options:outColorSpace	Landroid/graphics/ColorSpace;
    //   1755: getstatic 1172	android/graphics/ColorSpace$Named:DISPLAY_P3	Landroid/graphics/ColorSpace$Named;
    //   1758: invokestatic 1169	android/graphics/ColorSpace:get	(Landroid/graphics/ColorSpace$Named;)Landroid/graphics/ColorSpace;
    //   1761: if_acmpne +14 -> 1775
    //   1764: aload 24
    //   1766: getstatic 1175	android/graphics/ColorSpace$Named:SRGB	Landroid/graphics/ColorSpace$Named;
    //   1769: invokestatic 1169	android/graphics/ColorSpace:get	(Landroid/graphics/ColorSpace$Named;)Landroid/graphics/ColorSpace;
    //   1772: putfield 1178	android/graphics/BitmapFactory$Options:inPreferredColorSpace	Landroid/graphics/ColorSpace;
    //   1775: aload 24
    //   1777: invokestatic 1182	com/tencent/mm/sdk/platformtools/BitmapUtil:bindlowMemeryOption	(Landroid/graphics/BitmapFactory$Options;)V
    //   1780: aconst_null
    //   1781: astore 21
    //   1783: aconst_null
    //   1784: astore 20
    //   1786: aload_1
    //   1787: invokestatic 590	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1790: astore 23
    //   1792: aload 23
    //   1794: astore 22
    //   1796: aload 23
    //   1798: astore 20
    //   1800: aload 23
    //   1802: astore 21
    //   1804: aload 23
    //   1806: invokevirtual 596	java/io/InputStream:markSupported	()Z
    //   1809: ifne +22 -> 1831
    //   1812: aload 23
    //   1814: astore 20
    //   1816: aload 23
    //   1818: astore 21
    //   1820: new 598	java/io/BufferedInputStream
    //   1823: dup
    //   1824: aload 23
    //   1826: invokespecial 601	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1829: astore 22
    //   1831: aload 22
    //   1833: astore 20
    //   1835: aload 22
    //   1837: astore 21
    //   1839: aload 22
    //   1841: ldc_w 602
    //   1844: invokevirtual 605	java/io/InputStream:mark	(I)V
    //   1847: aload 22
    //   1849: astore 20
    //   1851: aload 22
    //   1853: astore 21
    //   1855: aload 22
    //   1857: aconst_null
    //   1858: aload 24
    //   1860: invokestatic 803	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1863: astore 23
    //   1865: aload 22
    //   1867: astore 20
    //   1869: aload 22
    //   1871: astore 21
    //   1873: aload 22
    //   1875: invokevirtual 612	java/io/InputStream:reset	()V
    //   1878: aload 23
    //   1880: ifnonnull +21 -> 1901
    //   1883: aload 22
    //   1885: ifnull +8 -> 1893
    //   1888: aload 22
    //   1890: invokevirtual 630	java/io/InputStream:close	()V
    //   1893: ldc_w 1001
    //   1896: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1899: iconst_0
    //   1900: ireturn
    //   1901: iload 11
    //   1903: i2f
    //   1904: fstore 6
    //   1906: aload 22
    //   1908: astore 20
    //   1910: aload 22
    //   1912: astore 21
    //   1914: aload 23
    //   1916: fload 6
    //   1918: invokestatic 968	com/tencent/mm/sdk/platformtools/BitmapUtil:rotate	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   1921: astore 23
    //   1923: aload 22
    //   1925: astore 20
    //   1927: aload 22
    //   1929: astore 21
    //   1931: invokestatic 753	com/tencent/mm/plugin/sns/storage/aa:hlk	()Z
    //   1934: ifeq +397 -> 2331
    //   1937: iload_3
    //   1938: ifeq +393 -> 2331
    //   1941: aload 22
    //   1943: astore 20
    //   1945: aload 22
    //   1947: astore 21
    //   1949: aload 23
    //   1951: aload_1
    //   1952: new 97	java/lang/StringBuilder
    //   1955: dup
    //   1956: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1959: aload_0
    //   1960: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1963: aload_2
    //   1964: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1967: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1970: invokestatic 756	com/tencent/mm/plugin/sns/storage/aa:b	(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;)Z
    //   1973: ifne +71 -> 2044
    //   1976: aload 22
    //   1978: astore 20
    //   1980: aload 22
    //   1982: astore 21
    //   1984: new 97	java/lang/StringBuilder
    //   1987: dup
    //   1988: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1991: aload_0
    //   1992: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1995: aload_2
    //   1996: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1999: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2002: invokestatic 532	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   2005: pop
    //   2006: aload 22
    //   2008: astore 20
    //   2010: aload 22
    //   2012: astore 21
    //   2014: aload 23
    //   2016: iload 9
    //   2018: getstatic 826	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   2021: new 97	java/lang/StringBuilder
    //   2024: dup
    //   2025: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2028: aload_0
    //   2029: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2032: aload_2
    //   2033: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2036: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2039: iconst_1
    //   2040: invokestatic 935	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   2043: pop
    //   2044: aload 23
    //   2046: ifnull +32 -> 2078
    //   2049: aload 22
    //   2051: astore 20
    //   2053: aload 22
    //   2055: astore 21
    //   2057: aload 23
    //   2059: invokevirtual 1185	android/graphics/Bitmap:isRecycled	()Z
    //   2062: ifne +16 -> 2078
    //   2065: aload 22
    //   2067: astore 20
    //   2069: aload 22
    //   2071: astore 21
    //   2073: aload 23
    //   2075: invokevirtual 1188	android/graphics/Bitmap:recycle	()V
    //   2078: iload 16
    //   2080: ifeq +423 -> 2503
    //   2083: iload 11
    //   2085: ifne +418 -> 2503
    //   2088: aload 22
    //   2090: astore 20
    //   2092: aload 22
    //   2094: astore 21
    //   2096: new 97	java/lang/StringBuilder
    //   2099: dup
    //   2100: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2103: aload_0
    //   2104: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2107: aload_2
    //   2108: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2111: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2114: invokestatic 187	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   2117: lstore 18
    //   2119: aload 22
    //   2121: astore 20
    //   2123: aload 22
    //   2125: astore 21
    //   2127: ldc 65
    //   2129: ldc_w 1190
    //   2132: iconst_3
    //   2133: anewarray 69	java/lang/Object
    //   2136: dup
    //   2137: iconst_0
    //   2138: iload 14
    //   2140: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2143: aastore
    //   2144: dup
    //   2145: iconst_1
    //   2146: lload 18
    //   2148: invokestatic 783	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2151: aastore
    //   2152: dup
    //   2153: iconst_2
    //   2154: iload 12
    //   2156: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2159: aastore
    //   2160: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2163: iload 14
    //   2165: i2l
    //   2166: lload 18
    //   2168: lsub
    //   2169: ldc2_w 1191
    //   2172: lmul
    //   2173: iload 12
    //   2175: iload 14
    //   2177: imul
    //   2178: i2l
    //   2179: lcmp
    //   2180: ifge +305 -> 2485
    //   2183: aload 22
    //   2185: astore 20
    //   2187: aload 22
    //   2189: astore 21
    //   2191: new 97	java/lang/StringBuilder
    //   2194: dup
    //   2195: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2198: aload_0
    //   2199: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2202: aload_2
    //   2203: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2206: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2209: invokestatic 532	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   2212: pop
    //   2213: aload 22
    //   2215: astore 20
    //   2217: aload 22
    //   2219: astore 21
    //   2221: invokestatic 753	com/tencent/mm/plugin/sns/storage/aa:hlk	()Z
    //   2224: ifeq +196 -> 2420
    //   2227: iload_3
    //   2228: ifeq +192 -> 2420
    //   2231: aload 22
    //   2233: astore 20
    //   2235: aload 22
    //   2237: astore 21
    //   2239: aload_1
    //   2240: new 97	java/lang/StringBuilder
    //   2243: dup
    //   2244: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2247: aload_0
    //   2248: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2251: aload_2
    //   2252: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2255: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2258: invokestatic 1128	com/tencent/mm/plugin/sns/storage/aa:mR	(Ljava/lang/String;Ljava/lang/String;)Z
    //   2261: istore 16
    //   2263: iload 16
    //   2265: istore_3
    //   2266: iload 16
    //   2268: ifne +45 -> 2313
    //   2271: aload 22
    //   2273: astore 20
    //   2275: aload 22
    //   2277: astore 21
    //   2279: aload_1
    //   2280: new 97	java/lang/StringBuilder
    //   2283: dup
    //   2284: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2287: aload_0
    //   2288: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2291: aload_2
    //   2292: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2295: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2298: iconst_0
    //   2299: invokestatic 523	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   2302: lstore 18
    //   2304: lload 18
    //   2306: lconst_0
    //   2307: lcmp
    //   2308: iflt +107 -> 2415
    //   2311: iconst_1
    //   2312: istore_3
    //   2313: aload 22
    //   2315: ifnull +8 -> 2323
    //   2318: aload 22
    //   2320: invokevirtual 630	java/io/InputStream:close	()V
    //   2323: ldc_w 1001
    //   2326: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2329: iload_3
    //   2330: ireturn
    //   2331: aload 22
    //   2333: astore 20
    //   2335: aload 22
    //   2337: astore 21
    //   2339: aload 23
    //   2341: iload 9
    //   2343: getstatic 826	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   2346: new 97	java/lang/StringBuilder
    //   2349: dup
    //   2350: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2353: aload_0
    //   2354: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2357: aload_2
    //   2358: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2361: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2364: iconst_1
    //   2365: invokestatic 935	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   2368: pop
    //   2369: goto -291 -> 2078
    //   2372: astore_0
    //   2373: aload 20
    //   2375: astore 21
    //   2377: ldc 65
    //   2379: aload_0
    //   2380: ldc_w 1194
    //   2383: aload_1
    //   2384: invokestatic 130	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2387: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2390: iconst_0
    //   2391: anewarray 69	java/lang/Object
    //   2394: invokestatic 551	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2397: aload 20
    //   2399: ifnull +8 -> 2407
    //   2402: aload 20
    //   2404: invokevirtual 630	java/io/InputStream:close	()V
    //   2407: ldc_w 1001
    //   2410: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2413: iconst_0
    //   2414: ireturn
    //   2415: iconst_0
    //   2416: istore_3
    //   2417: goto -104 -> 2313
    //   2420: aload 22
    //   2422: astore 20
    //   2424: aload 22
    //   2426: astore 21
    //   2428: aload_1
    //   2429: new 97	java/lang/StringBuilder
    //   2432: dup
    //   2433: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2436: aload_0
    //   2437: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2440: aload_2
    //   2441: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2444: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2447: iconst_0
    //   2448: invokestatic 523	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   2451: lstore 18
    //   2453: lload 18
    //   2455: lconst_0
    //   2456: lcmp
    //   2457: iflt +23 -> 2480
    //   2460: iconst_1
    //   2461: istore_3
    //   2462: aload 22
    //   2464: ifnull +8 -> 2472
    //   2467: aload 22
    //   2469: invokevirtual 630	java/io/InputStream:close	()V
    //   2472: ldc_w 1001
    //   2475: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2478: iload_3
    //   2479: ireturn
    //   2480: iconst_0
    //   2481: istore_3
    //   2482: goto -20 -> 2462
    //   2485: aload 22
    //   2487: ifnull +8 -> 2495
    //   2490: aload 22
    //   2492: invokevirtual 630	java/io/InputStream:close	()V
    //   2495: ldc_w 1001
    //   2498: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2501: iconst_1
    //   2502: ireturn
    //   2503: aload 22
    //   2505: ifnull +8 -> 2513
    //   2508: aload 22
    //   2510: invokevirtual 630	java/io/InputStream:close	()V
    //   2513: ldc_w 1001
    //   2516: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2519: iconst_1
    //   2520: ireturn
    //   2521: astore_0
    //   2522: aload 21
    //   2524: ifnull +8 -> 2532
    //   2527: aload 21
    //   2529: invokevirtual 630	java/io/InputStream:close	()V
    //   2532: ldc_w 1001
    //   2535: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2538: aload_0
    //   2539: athrow
    //   2540: ldc 65
    //   2542: new 97	java/lang/StringBuilder
    //   2545: dup
    //   2546: ldc_w 1196
    //   2549: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2552: aload 20
    //   2554: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   2557: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2560: ldc_w 1109
    //   2563: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2566: aload 20
    //   2568: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   2571: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2574: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2577: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2580: aload 20
    //   2582: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   2585: ifgt +9 -> 2594
    //   2588: aload 20
    //   2590: iconst_1
    //   2591: putfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   2594: aload 20
    //   2596: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   2599: ifgt +9 -> 2608
    //   2602: aload 20
    //   2604: iconst_1
    //   2605: putfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   2608: aload 20
    //   2610: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   2613: aload 20
    //   2615: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   2618: if_icmple +131 -> 2749
    //   2621: aload 20
    //   2623: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   2626: aload 20
    //   2628: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   2631: idiv
    //   2632: istore 7
    //   2634: iload 7
    //   2636: istore 8
    //   2638: iload 7
    //   2640: ifne +6 -> 2646
    //   2643: iconst_1
    //   2644: istore 8
    //   2646: ldc_w 708
    //   2649: iload 8
    //   2651: idiv
    //   2652: i2d
    //   2653: invokestatic 1199	java/lang/Math:sqrt	(D)D
    //   2656: d2i
    //   2657: istore 7
    //   2659: aload 20
    //   2661: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   2664: aload 20
    //   2666: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   2669: if_icmple +96 -> 2765
    //   2672: iload 7
    //   2674: iload 8
    //   2676: imul
    //   2677: istore 10
    //   2679: ldc 65
    //   2681: new 97	java/lang/StringBuilder
    //   2684: dup
    //   2685: ldc_w 1201
    //   2688: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2691: iload 10
    //   2693: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2696: ldc_w 1109
    //   2699: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2702: iload 7
    //   2704: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2707: ldc_w 1109
    //   2710: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2713: iload 8
    //   2715: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2718: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2721: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2724: aload_1
    //   2725: iload 7
    //   2727: iload 10
    //   2729: getstatic 826	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   2732: iload 9
    //   2734: aload_0
    //   2735: aload_2
    //   2736: iload_3
    //   2737: invokestatic 1203	com/tencent/mm/plugin/sns/storage/aa:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   2740: istore_3
    //   2741: ldc_w 1001
    //   2744: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2747: iload_3
    //   2748: ireturn
    //   2749: aload 20
    //   2751: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   2754: aload 20
    //   2756: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   2759: idiv
    //   2760: istore 7
    //   2762: goto -128 -> 2634
    //   2765: iload 7
    //   2767: iload 8
    //   2769: imul
    //   2770: istore 11
    //   2772: iload 7
    //   2774: istore 10
    //   2776: iload 11
    //   2778: istore 7
    //   2780: goto -101 -> 2679
    //   2783: iload 14
    //   2785: iload 13
    //   2787: if_icmpge +180 -> 2967
    //   2790: iload 16
    //   2792: ifeq +175 -> 2967
    //   2795: iload 11
    //   2797: ifne +170 -> 2967
    //   2800: ldc 65
    //   2802: ldc_w 1205
    //   2805: iload 13
    //   2807: invokestatic 344	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2810: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2813: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2816: invokestatic 753	com/tencent/mm/plugin/sns/storage/aa:hlk	()Z
    //   2819: ifeq +104 -> 2923
    //   2822: iload_3
    //   2823: ifeq +100 -> 2923
    //   2826: aload_1
    //   2827: new 97	java/lang/StringBuilder
    //   2830: dup
    //   2831: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2834: aload_0
    //   2835: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2838: aload_2
    //   2839: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2842: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2845: invokestatic 1128	com/tencent/mm/plugin/sns/storage/aa:mR	(Ljava/lang/String;Ljava/lang/String;)Z
    //   2848: istore 16
    //   2850: iload 16
    //   2852: istore_3
    //   2853: iload 16
    //   2855: ifne +55 -> 2910
    //   2858: new 97	java/lang/StringBuilder
    //   2861: dup
    //   2862: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2865: aload_0
    //   2866: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2869: aload_2
    //   2870: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2873: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2876: invokestatic 532	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   2879: pop
    //   2880: aload_1
    //   2881: new 97	java/lang/StringBuilder
    //   2884: dup
    //   2885: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2888: aload_0
    //   2889: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2892: aload_2
    //   2893: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2896: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2899: iconst_0
    //   2900: invokestatic 523	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   2903: lconst_0
    //   2904: lcmp
    //   2905: iflt +13 -> 2918
    //   2908: iconst_1
    //   2909: istore_3
    //   2910: ldc_w 1001
    //   2913: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2916: iload_3
    //   2917: ireturn
    //   2918: iconst_0
    //   2919: istore_3
    //   2920: goto -10 -> 2910
    //   2923: aload_1
    //   2924: new 97	java/lang/StringBuilder
    //   2927: dup
    //   2928: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2931: aload_0
    //   2932: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2935: aload_2
    //   2936: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2939: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2942: iconst_0
    //   2943: invokestatic 523	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   2946: lconst_0
    //   2947: lcmp
    //   2948: iflt +11 -> 2959
    //   2951: ldc_w 1001
    //   2954: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2957: iconst_1
    //   2958: ireturn
    //   2959: ldc_w 1001
    //   2962: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2965: iconst_0
    //   2966: ireturn
    //   2967: aload 20
    //   2969: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   2972: aload 20
    //   2974: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   2977: if_icmple +230 -> 3207
    //   2980: aload 20
    //   2982: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   2985: istore 10
    //   2987: aload 20
    //   2989: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   2992: aload 20
    //   2994: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   2997: if_icmpge +220 -> 3217
    //   3000: aload 20
    //   3002: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   3005: istore 13
    //   3007: iload 8
    //   3009: ifle +10 -> 3019
    //   3012: iload 13
    //   3014: iload 8
    //   3016: if_icmple +15 -> 3031
    //   3019: iload 8
    //   3021: ifgt +590 -> 3611
    //   3024: iload 10
    //   3026: iload 7
    //   3028: if_icmpgt +583 -> 3611
    //   3031: ldc 65
    //   3033: ldc_w 1207
    //   3036: iconst_3
    //   3037: anewarray 69	java/lang/Object
    //   3040: dup
    //   3041: iconst_0
    //   3042: iload 14
    //   3044: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3047: aastore
    //   3048: dup
    //   3049: iconst_1
    //   3050: aload 20
    //   3052: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   3055: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3058: aastore
    //   3059: dup
    //   3060: iconst_2
    //   3061: aload 20
    //   3063: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   3066: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3069: aastore
    //   3070: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3073: aload_1
    //   3074: invokestatic 187	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   3077: ldc2_w 1208
    //   3080: lcmp
    //   3081: ifge +248 -> 3329
    //   3084: iload 16
    //   3086: ifeq +190 -> 3276
    //   3089: ldc 65
    //   3091: ldc_w 1211
    //   3094: iconst_1
    //   3095: anewarray 69	java/lang/Object
    //   3098: dup
    //   3099: iconst_0
    //   3100: aload_1
    //   3101: aastore
    //   3102: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3105: invokestatic 753	com/tencent/mm/plugin/sns/storage/aa:hlk	()Z
    //   3108: ifeq +124 -> 3232
    //   3111: iload_3
    //   3112: ifeq +120 -> 3232
    //   3115: aload_1
    //   3116: new 97	java/lang/StringBuilder
    //   3119: dup
    //   3120: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3123: aload_0
    //   3124: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3127: aload_2
    //   3128: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3131: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3134: invokestatic 1128	com/tencent/mm/plugin/sns/storage/aa:mR	(Ljava/lang/String;Ljava/lang/String;)Z
    //   3137: istore 16
    //   3139: iload 16
    //   3141: istore_3
    //   3142: iload 16
    //   3144: ifne +55 -> 3199
    //   3147: new 97	java/lang/StringBuilder
    //   3150: dup
    //   3151: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3154: aload_0
    //   3155: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3158: aload_2
    //   3159: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3162: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3165: invokestatic 532	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   3168: pop
    //   3169: aload_1
    //   3170: new 97	java/lang/StringBuilder
    //   3173: dup
    //   3174: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3177: aload_0
    //   3178: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3181: aload_2
    //   3182: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3185: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3188: iconst_0
    //   3189: invokestatic 523	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   3192: lconst_0
    //   3193: lcmp
    //   3194: iflt +33 -> 3227
    //   3197: iconst_1
    //   3198: istore_3
    //   3199: ldc_w 1001
    //   3202: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3205: iload_3
    //   3206: ireturn
    //   3207: aload 20
    //   3209: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   3212: istore 10
    //   3214: goto -227 -> 2987
    //   3217: aload 20
    //   3219: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   3222: istore 13
    //   3224: goto -217 -> 3007
    //   3227: iconst_0
    //   3228: istore_3
    //   3229: goto -30 -> 3199
    //   3232: aload_1
    //   3233: new 97	java/lang/StringBuilder
    //   3236: dup
    //   3237: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3240: aload_0
    //   3241: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3244: aload_2
    //   3245: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3248: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3251: iconst_0
    //   3252: invokestatic 523	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   3255: lconst_0
    //   3256: lcmp
    //   3257: iflt +11 -> 3268
    //   3260: ldc_w 1001
    //   3263: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3266: iconst_1
    //   3267: ireturn
    //   3268: ldc_w 1001
    //   3271: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3274: iconst_0
    //   3275: ireturn
    //   3276: aload 20
    //   3278: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   3281: sipush 150
    //   3284: if_icmpge +45 -> 3329
    //   3287: aload 20
    //   3289: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   3292: sipush 150
    //   3295: if_icmpge +34 -> 3329
    //   3298: aload_1
    //   3299: aload 20
    //   3301: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   3304: aload 20
    //   3306: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   3309: getstatic 821	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   3312: iload 9
    //   3314: aload_0
    //   3315: aload_2
    //   3316: iload_3
    //   3317: invokestatic 1203	com/tencent/mm/plugin/sns/storage/aa:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   3320: istore_3
    //   3321: ldc_w 1001
    //   3324: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3327: iload_3
    //   3328: ireturn
    //   3329: aload_1
    //   3330: aload 20
    //   3332: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   3335: aload 20
    //   3337: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   3340: getstatic 826	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   3343: iload 9
    //   3345: aload_0
    //   3346: aload_2
    //   3347: iload_3
    //   3348: invokestatic 1203	com/tencent/mm/plugin/sns/storage/aa:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   3351: istore 17
    //   3353: iload 16
    //   3355: ifeq +247 -> 3602
    //   3358: iload 11
    //   3360: ifne +242 -> 3602
    //   3363: new 97	java/lang/StringBuilder
    //   3366: dup
    //   3367: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3370: aload_0
    //   3371: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3374: aload_2
    //   3375: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3378: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3381: invokestatic 187	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   3384: lstore 18
    //   3386: ldc 65
    //   3388: ldc_w 1190
    //   3391: iconst_3
    //   3392: anewarray 69	java/lang/Object
    //   3395: dup
    //   3396: iconst_0
    //   3397: iload 14
    //   3399: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3402: aastore
    //   3403: dup
    //   3404: iconst_1
    //   3405: lload 18
    //   3407: invokestatic 783	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3410: aastore
    //   3411: dup
    //   3412: iconst_2
    //   3413: iload 12
    //   3415: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3418: aastore
    //   3419: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3422: iload 14
    //   3424: i2l
    //   3425: lload 18
    //   3427: lsub
    //   3428: ldc2_w 1191
    //   3431: lmul
    //   3432: iload 12
    //   3434: iload 14
    //   3436: imul
    //   3437: i2l
    //   3438: lcmp
    //   3439: ifge +154 -> 3593
    //   3442: new 97	java/lang/StringBuilder
    //   3445: dup
    //   3446: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3449: aload_0
    //   3450: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3453: aload_2
    //   3454: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3457: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3460: invokestatic 532	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   3463: pop
    //   3464: invokestatic 753	com/tencent/mm/plugin/sns/storage/aa:hlk	()Z
    //   3467: ifeq +82 -> 3549
    //   3470: iload_3
    //   3471: ifeq +78 -> 3549
    //   3474: aload_1
    //   3475: new 97	java/lang/StringBuilder
    //   3478: dup
    //   3479: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3482: aload_0
    //   3483: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3486: aload_2
    //   3487: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3490: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3493: invokestatic 1128	com/tencent/mm/plugin/sns/storage/aa:mR	(Ljava/lang/String;Ljava/lang/String;)Z
    //   3496: istore 16
    //   3498: iload 16
    //   3500: istore_3
    //   3501: iload 16
    //   3503: ifne +33 -> 3536
    //   3506: aload_1
    //   3507: new 97	java/lang/StringBuilder
    //   3510: dup
    //   3511: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3514: aload_0
    //   3515: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3518: aload_2
    //   3519: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3522: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3525: iconst_0
    //   3526: invokestatic 523	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   3529: lconst_0
    //   3530: lcmp
    //   3531: iflt +13 -> 3544
    //   3534: iconst_1
    //   3535: istore_3
    //   3536: ldc_w 1001
    //   3539: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3542: iload_3
    //   3543: ireturn
    //   3544: iconst_0
    //   3545: istore_3
    //   3546: goto -10 -> 3536
    //   3549: aload_1
    //   3550: new 97	java/lang/StringBuilder
    //   3553: dup
    //   3554: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3557: aload_0
    //   3558: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3561: aload_2
    //   3562: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3565: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3568: iconst_0
    //   3569: invokestatic 523	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   3572: lconst_0
    //   3573: lcmp
    //   3574: iflt +11 -> 3585
    //   3577: ldc_w 1001
    //   3580: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3583: iconst_1
    //   3584: ireturn
    //   3585: ldc_w 1001
    //   3588: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3591: iconst_0
    //   3592: ireturn
    //   3593: ldc_w 1001
    //   3596: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3599: iload 17
    //   3601: ireturn
    //   3602: ldc_w 1001
    //   3605: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3608: iload 17
    //   3610: ireturn
    //   3611: iload 8
    //   3613: ifle +222 -> 3835
    //   3616: aload 20
    //   3618: aload_1
    //   3619: aload 20
    //   3621: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   3624: aload 20
    //   3626: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   3629: iload 8
    //   3631: getstatic 826	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   3634: iload 9
    //   3636: aload_0
    //   3637: aload_2
    //   3638: iload_3
    //   3639: invokestatic 1213	com/tencent/mm/plugin/sns/storage/aa:a	(Landroid/graphics/BitmapFactory$Options;Ljava/lang/String;IIILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   3642: istore 17
    //   3644: iload 16
    //   3646: ifeq +290 -> 3936
    //   3649: iload 11
    //   3651: ifne +285 -> 3936
    //   3654: new 97	java/lang/StringBuilder
    //   3657: dup
    //   3658: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3661: aload_0
    //   3662: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3665: aload_2
    //   3666: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3669: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3672: invokestatic 187	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   3675: lstore 18
    //   3677: ldc 65
    //   3679: ldc_w 1190
    //   3682: iconst_3
    //   3683: anewarray 69	java/lang/Object
    //   3686: dup
    //   3687: iconst_0
    //   3688: iload 14
    //   3690: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3693: aastore
    //   3694: dup
    //   3695: iconst_1
    //   3696: lload 18
    //   3698: invokestatic 783	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3701: aastore
    //   3702: dup
    //   3703: iconst_2
    //   3704: iload 12
    //   3706: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3709: aastore
    //   3710: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3713: iload 14
    //   3715: i2l
    //   3716: lload 18
    //   3718: lsub
    //   3719: ldc2_w 1191
    //   3722: lmul
    //   3723: iload 12
    //   3725: iload 14
    //   3727: imul
    //   3728: i2l
    //   3729: lcmp
    //   3730: ifge +206 -> 3936
    //   3733: new 97	java/lang/StringBuilder
    //   3736: dup
    //   3737: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3740: aload_0
    //   3741: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3744: aload_2
    //   3745: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3748: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3751: invokestatic 532	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   3754: pop
    //   3755: invokestatic 753	com/tencent/mm/plugin/sns/storage/aa:hlk	()Z
    //   3758: ifeq +134 -> 3892
    //   3761: iload_3
    //   3762: ifeq +130 -> 3892
    //   3765: aload_1
    //   3766: new 97	java/lang/StringBuilder
    //   3769: dup
    //   3770: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3773: aload_0
    //   3774: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3777: aload_2
    //   3778: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3781: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3784: invokestatic 1128	com/tencent/mm/plugin/sns/storage/aa:mR	(Ljava/lang/String;Ljava/lang/String;)Z
    //   3787: istore 16
    //   3789: iload 16
    //   3791: istore_3
    //   3792: iload 16
    //   3794: ifne +33 -> 3827
    //   3797: aload_1
    //   3798: new 97	java/lang/StringBuilder
    //   3801: dup
    //   3802: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3805: aload_0
    //   3806: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3809: aload_2
    //   3810: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3813: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3816: iconst_0
    //   3817: invokestatic 523	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   3820: lconst_0
    //   3821: lcmp
    //   3822: iflt +65 -> 3887
    //   3825: iconst_1
    //   3826: istore_3
    //   3827: ldc_w 1001
    //   3830: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3833: iload_3
    //   3834: ireturn
    //   3835: iload 10
    //   3837: i2d
    //   3838: dconst_1
    //   3839: dmul
    //   3840: iload 7
    //   3842: i2d
    //   3843: ddiv
    //   3844: dstore 4
    //   3846: aload 20
    //   3848: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   3851: i2d
    //   3852: dload 4
    //   3854: ddiv
    //   3855: d2i
    //   3856: istore 7
    //   3858: aload_1
    //   3859: aload 20
    //   3861: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   3864: i2d
    //   3865: dload 4
    //   3867: ddiv
    //   3868: d2i
    //   3869: iload 7
    //   3871: getstatic 826	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   3874: iload 9
    //   3876: aload_0
    //   3877: aload_2
    //   3878: iload_3
    //   3879: invokestatic 1203	com/tencent/mm/plugin/sns/storage/aa:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   3882: istore 17
    //   3884: goto -240 -> 3644
    //   3887: iconst_0
    //   3888: istore_3
    //   3889: goto -62 -> 3827
    //   3892: aload_1
    //   3893: new 97	java/lang/StringBuilder
    //   3896: dup
    //   3897: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3900: aload_0
    //   3901: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3904: aload_2
    //   3905: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3908: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3911: iconst_0
    //   3912: invokestatic 523	com/tencent/mm/vfs/y:O	(Ljava/lang/String;Ljava/lang/String;Z)J
    //   3915: lconst_0
    //   3916: lcmp
    //   3917: iflt +11 -> 3928
    //   3920: ldc_w 1001
    //   3923: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3926: iconst_1
    //   3927: ireturn
    //   3928: ldc_w 1001
    //   3931: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3934: iconst_0
    //   3935: ireturn
    //   3936: ldc_w 1001
    //   3939: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3942: iload 17
    //   3944: ireturn
    //   3945: astore_0
    //   3946: goto -2053 -> 1893
    //   3949: astore_0
    //   3950: goto -1627 -> 2323
    //   3953: astore_0
    //   3954: goto -1482 -> 2472
    //   3957: astore_0
    //   3958: goto -1463 -> 2495
    //   3961: astore_0
    //   3962: goto -1449 -> 2513
    //   3965: astore_0
    //   3966: goto -1559 -> 2407
    //   3969: astore_1
    //   3970: goto -1438 -> 2532
    //   3973: astore 21
    //   3975: goto -3463 -> 512
    //   3978: astore 21
    //   3980: bipush 100
    //   3982: istore 7
    //   3984: goto -3683 -> 301
    //   3987: astore 21
    //   3989: goto -3688 -> 301
    //   3992: goto -3292 -> 700
    //   3995: goto -3403 -> 592
    //   3998: iload 8
    //   4000: istore 10
    //   4002: iload 7
    //   4004: istore 9
    //   4006: goto -3619 -> 387
    //   4009: goto -3663 -> 346
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4012	0	paramString1	String
    //   0	4012	1	paramString2	String
    //   0	4012	2	paramString3	String
    //   0	4012	3	paramBoolean	boolean
    //   3844	22	4	d	double
    //   1904	13	6	f	float
    //   201	3802	7	i	int
    //   134	3865	8	j	int
    //   138	3867	9	k	int
    //   142	3859	10	m	int
    //   437	3213	11	n	int
    //   502	3226	12	i1	int
    //   627	2596	13	i2	int
    //   392	3336	14	i3	int
    //   666	994	15	i4	int
    //   64	3729	16	bool1	boolean
    //   102	3841	17	bool2	boolean
    //   2117	1600	18	l	long
    //   10	3850	20	localObject1	Object
    //   22	1513	21	localObject2	Object
    //   1606	15	21	localException1	Exception
    //   1781	747	21	localObject3	Object
    //   3973	1	21	localException2	Exception
    //   3978	1	21	localException3	Exception
    //   3987	1	21	localException4	Exception
    //   1794	715	22	localObject4	Object
    //   1790	550	23	localObject5	Object
    //   1721	138	24	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   708	714	1606	java/lang/Exception
    //   719	730	1606	java/lang/Exception
    //   1786	1792	2372	java/io/IOException
    //   1804	1812	2372	java/io/IOException
    //   1820	1831	2372	java/io/IOException
    //   1839	1847	2372	java/io/IOException
    //   1855	1865	2372	java/io/IOException
    //   1873	1878	2372	java/io/IOException
    //   1914	1923	2372	java/io/IOException
    //   1931	1937	2372	java/io/IOException
    //   1949	1976	2372	java/io/IOException
    //   1984	2006	2372	java/io/IOException
    //   2014	2044	2372	java/io/IOException
    //   2057	2065	2372	java/io/IOException
    //   2073	2078	2372	java/io/IOException
    //   2096	2119	2372	java/io/IOException
    //   2127	2163	2372	java/io/IOException
    //   2191	2213	2372	java/io/IOException
    //   2221	2227	2372	java/io/IOException
    //   2239	2263	2372	java/io/IOException
    //   2279	2304	2372	java/io/IOException
    //   2339	2369	2372	java/io/IOException
    //   2428	2453	2372	java/io/IOException
    //   1786	1792	2521	finally
    //   1804	1812	2521	finally
    //   1820	1831	2521	finally
    //   1839	1847	2521	finally
    //   1855	1865	2521	finally
    //   1873	1878	2521	finally
    //   1914	1923	2521	finally
    //   1931	1937	2521	finally
    //   1949	1976	2521	finally
    //   1984	2006	2521	finally
    //   2014	2044	2521	finally
    //   2057	2065	2521	finally
    //   2073	2078	2521	finally
    //   2096	2119	2521	finally
    //   2127	2163	2521	finally
    //   2191	2213	2521	finally
    //   2221	2227	2521	finally
    //   2239	2263	2521	finally
    //   2279	2304	2521	finally
    //   2339	2369	2521	finally
    //   2377	2397	2521	finally
    //   2428	2453	2521	finally
    //   1888	1893	3945	java/io/IOException
    //   2318	2323	3949	java/io/IOException
    //   2467	2472	3953	java/io/IOException
    //   2490	2495	3957	java/io/IOException
    //   2508	2513	3961	java/io/IOException
    //   2402	2407	3965	java/io/IOException
    //   2527	2532	3969	java/io/IOException
    //   449	460	3973	java/lang/Exception
    //   464	482	3973	java/lang/Exception
    //   486	504	3973	java/lang/Exception
    //   1248	1257	3973	java/lang/Exception
    //   1261	1272	3973	java/lang/Exception
    //   1276	1294	3973	java/lang/Exception
    //   1298	1316	3973	java/lang/Exception
    //   1331	1340	3973	java/lang/Exception
    //   1344	1355	3973	java/lang/Exception
    //   1359	1377	3973	java/lang/Exception
    //   1381	1399	3973	java/lang/Exception
    //   1414	1423	3973	java/lang/Exception
    //   1427	1438	3973	java/lang/Exception
    //   1442	1460	3973	java/lang/Exception
    //   1464	1482	3973	java/lang/Exception
    //   1497	1508	3973	java/lang/Exception
    //   1512	1530	3973	java/lang/Exception
    //   1534	1552	3973	java/lang/Exception
    //   148	178	3978	java/lang/Exception
    //   178	203	3978	java/lang/Exception
    //   1091	1116	3978	java/lang/Exception
    //   1119	1144	3978	java/lang/Exception
    //   1147	1163	3978	java/lang/Exception
    //   1166	1192	3978	java/lang/Exception
    //   1195	1221	3978	java/lang/Exception
    //   1224	1241	3978	java/lang/Exception
    //   203	301	3987	java/lang/Exception
  }
  
  public static void lD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97597);
    DRE = paramInt1;
    CCP = paramInt2;
    Log.i("MicroMsg.snsMediaStorage", "SCREEN %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(97597);
  }
  
  private static boolean mR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(306609);
    try
    {
      Bitmap localBitmap = com.tencent.mm.plugin.sns.e.a.m(paramString1, 0.0F);
      byte[] arrayOfByte = aP(localBitmap);
      localBitmap.recycle();
      f.dxM();
      if (f.a(arrayOfByte, paramString1, paramString2, localBitmap.getWidth(), localBitmap.getHeight(), localBitmap.getWidth(), localBitmap.getHeight()) == 0)
      {
        AppMethodBeat.o(306609);
        return true;
      }
      AppMethodBeat.o(306609);
      return false;
    }
    catch (OutOfMemoryError paramString2)
    {
      Log.w("MicroMsg.snsMediaStorage", "convertImg2WxamWithoutZip origPath:%s OutOfMemoryError! rollback", new Object[] { paramString1 });
      AppMethodBeat.o(306609);
    }
    return false;
  }
  
  public final int a(int paramInt, z paramz)
  {
    AppMethodBeat.i(97602);
    paramz = paramz.hlf();
    paramInt = this.omV.update("SnsMedia", paramz, "local_id=?", new String[] { String.valueOf(paramInt) });
    AppMethodBeat.o(97602);
    return paramInt;
  }
  
  public final s a(s params, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(97608);
    z localz = new z();
    localz.createTime = ((int)Util.nowSecond());
    localz.type = params.type;
    dnc localdnc = new dnc();
    localdnc.Privated = params.Qoh;
    localdnc.aaTH = params.Qog;
    localdnc.token = params.Qoi;
    localdnc.aaTQ = params.Qoj;
    localdnc.aaUf = 0;
    localdnc.aaUe = new dmu();
    localdnc.nrQ = 0;
    localdnc.IGG = params.desc;
    Log.d("MicroMsg.snsMediaStorage", "upload.filterId " + params.Qof);
    localdnc.aaTG = params.Qof;
    localdnc.aaPu = 2;
    localdnc.videoPath = paramString1;
    localdnc.aaUi = paramString2;
    localdnc.md5 = params.Qok;
    for (;;)
    {
      try
      {
        localz.QZv = localdnc.toByteArray();
        localz.hlg();
        i = (int)this.omV.insert("SnsMedia", "local_id", localz.hlf());
        str1 = "Locall_path".concat(String.valueOf(i));
        Log.d("MicroMsg.snsMediaStorage", "insert localId ".concat(String.valueOf(i)));
        String str2 = t.aXq(str1);
        String str3 = t.aXr(str1);
        String str4 = t.aXp(str1);
        String str5 = t.aXs(str1);
        String str6 = bak(str1);
        y.bDX(str6);
        y.O(paramString2, str6 + str2, false);
        y.O(paramString2, str6 + str3, false);
        y.O(paramString2, str6 + str4, false);
        y.O(paramString1, str6 + str5, false);
        localdnc.videoPath = (str6 + str5);
        localdnc.aaUi = (str6 + str3);
        localdnc.md5 = params.Qok;
      }
      catch (Exception localException)
      {
        try
        {
          int i;
          String str1;
          localz.QZv = localdnc.toByteArray();
          localz.Oxm = str1;
          if ((TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4)))
          {
            a(i, localz);
            params = a(params, localdnc.aaUi);
            params.icg = i;
            AppMethodBeat.o(97608);
            return params;
            localException = localException;
            Log.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
          }
        }
        catch (Exception paramString2)
        {
          Log.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
          continue;
          paramString2 = new dmu();
          paramString2.vhJ = 1;
          paramString2.Url = paramString3;
          localdnc.aaUe = paramString2;
          localdnc.aaPu = 0;
          com.tencent.mm.modelcdntran.k.bHX();
          localdnc.aaTE = d.Nu(paramString1);
          if (!Util.isNullOrNil(paramString4))
          {
            paramString1 = new dmu();
            paramString1.vhJ = 1;
            paramString1.Url = paramString4;
            localdnc.aaUg.add(paramString1);
          }
        }
      }
      try
      {
        localz.QZv = localdnc.toByteArray();
        localz.hlh();
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.snsMediaStorage", paramString1, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean a(String paramString, z paramz)
  {
    AppMethodBeat.i(97600);
    Log.d("MicroMsg.snsMediaStorage", "replace AlbumLikeList ".concat(String.valueOf(paramString)));
    Cursor localCursor = this.omV.query("SnsMedia", null, "StrId=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (localCursor.moveToFirst())
    {
      localCursor.close();
      bool = a(paramz);
      AppMethodBeat.o(97600);
      return bool;
    }
    localCursor.close();
    boolean bool = b(paramString, paramz);
    AppMethodBeat.o(97600);
    return bool;
  }
  
  public final z bal(String paramString)
  {
    AppMethodBeat.i(97603);
    z localz = new z();
    paramString = this.omV.query("SnsMedia", null, "StrId=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (paramString.moveToFirst())
    {
      localz.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(97603);
      return localz;
    }
    paramString.close();
    AppMethodBeat.o(97603);
    return null;
  }
  
  public final List<s> kF(List<s> paramList)
  {
    AppMethodBeat.i(97605);
    LinkedList localLinkedList = new LinkedList();
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(97605);
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      s locals1 = (s)paramList.next();
      int i = a(locals1);
      if (i == -1)
      {
        AppMethodBeat.o(97605);
        return null;
      }
      s locals2 = new s(i, locals1.type);
      locals2.height = locals1.height;
      locals2.width = locals1.width;
      locals2.fileSize = locals1.fileSize;
      localLinkedList.add(locals2);
    }
    AppMethodBeat.o(97605);
    return localLinkedList;
  }
  
  public final z vk(long paramLong)
  {
    AppMethodBeat.i(97604);
    z localz = new z();
    Cursor localCursor = this.omV.query("SnsMedia", null, "local_id=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(97604);
      return null;
    }
    localz.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(97604);
    return localz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.aa
 * JD-Core Version:    0.7.0.1
 */