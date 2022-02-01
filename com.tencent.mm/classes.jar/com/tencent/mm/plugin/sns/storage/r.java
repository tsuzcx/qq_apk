package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace.Named;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelsns.n;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.s;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.k.f.a;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.protocal.protobuf.cvo;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.vfs.u;
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

public final class r
  extends MStorage
{
  private static int APq;
  private static int JER;
  public static final String[] SQL_CREATE;
  private static Point lbY;
  public com.tencent.mm.storagebase.h lvy;
  
  static
  {
    AppMethodBeat.i(97620);
    SQL_CREATE = new String[] { "CREATE TABLE IF NOT EXISTS SnsMedia ( local_id INTEGER PRIMARY KEY, seqId LONG, type INT, createTime LONG, userName VARCHAR(40), totallen INT, offset INT, local_flag INT, tmp_path TEXT, nums INT, try_times INT, StrId VARCHAR(40), upload_buf TEXT, reserved1 INT, reserved2 TEXT, reserved3 TEXT, reserved4 TEXT, reserved5 TEXT )", "CREATE INDEX IF NOT EXISTS serverSnsMediaTimeIndex ON SnsMedia ( createTime )" };
    JER = 0;
    APq = 0;
    lbY = new Point();
    AppMethodBeat.o(97620);
  }
  
  public r(com.tencent.mm.storagebase.h paramh)
  {
    this.lvy = paramh;
  }
  
  private int a(s params)
  {
    AppMethodBeat.i(97607);
    localObject1 = aj.getAccSnsPath();
    str2 = aj.getAccSnsTmpPath();
    Log.i("MicroMsg.snsMediaStorage", "SnsMediaStorage %s %s", new Object[] { localObject1, str2 });
    l = System.currentTimeMillis();
    str1 = params.path;
    i = params.type;
    if (!u.agG(str1))
    {
      AppMethodBeat.o(97607);
      return -1;
    }
    str4 = com.tencent.mm.b.g.getMessageDigest((str1 + System.currentTimeMillis()).getBytes());
    str3 = t.aZf(str4);
    Log.d("MicroMsg.snsMediaStorage", "insert : original img path = ".concat(String.valueOf(str1)));
    if (!u.agG(str2))
    {
      Log.i("MicroMsg.snsMediaStorage", "create snstmp path ".concat(String.valueOf(str2)));
      u.bBD(str2);
    }
    if (!u.agG((String)localObject1))
    {
      Log.i("MicroMsg.snsMediaStorage", "create snsPath ".concat(String.valueOf(localObject1)));
      u.bBD((String)localObject1);
    }
    localObject2 = new com.tencent.mm.plugin.image.b();
    localObject3 = a(params, str1);
    j = ((s)localObject3).width;
    int k = ((s)localObject3).height;
    int m = ((s)localObject3).fileSize;
    ((com.tencent.mm.plugin.image.b)localObject2).DNG = str1;
    ((com.tencent.mm.plugin.image.b)localObject2).DNI = j;
    ((com.tencent.mm.plugin.image.b)localObject2).DNJ = k;
    ((com.tencent.mm.plugin.image.b)localObject2).DNK = m;
    if (!h(str2, str1, str3, true))
    {
      AppMethodBeat.o(97607);
      return -1;
    }
    Log.d("MicroMsg.snsMediaStorage", "insert0 " + (System.currentTimeMillis() - l));
    Log.d("MicroMsg.snsMediaStorage", "insert: compressed bigMediaPath = ".concat(String.valueOf(str3)));
    str1 = str2 + str3;
    j = (int)u.bBQ(str1);
    if (t.aLV(str1) == 2)
    {
      localObject4 = BitmapUtil.getYUVType(u.aY(str1, 0, j));
      if (localObject4 != null) {
        Log.i("MicroMsg.snsMediaStorage", "insert yuvInfo:%s", new Object[] { localObject4 });
      }
    }
    try
    {
      localObject1 = u.n(str1, false);
      params = (s)localObject1;
      if (localObject1 == null) {
        params = str1;
      }
      params = new androidx.e.a.a(params);
      params.c("UserComment", (String)localObject4);
      params.ib();
    }
    catch (Exception params)
    {
      try
      {
        ((q)localObject1).KAa = params.toByteArray();
        ((q)localObject1).fSU();
        ((q)localObject1).KzV = j;
        Log.i("MicroMsg.snsMediaStorage", "insert a local snsMedia  totallen  :" + j + " filepath: " + str2 + str3);
        i = (int)this.lvy.insert("SnsMedia", "local_id", ((q)localObject1).fST());
        Log.d("MicroMsg.snsMediaStorage", "insert localId ".concat(String.valueOf(i)));
        str4 = "Locall_path".concat(String.valueOf(i));
        ((com.tencent.mm.plugin.image.b)localObject2).DNH = String.valueOf(i);
        ((com.tencent.mm.plugin.image.b)localObject2).md5 = params.md5;
        localObject3 = Exif.fromFile(((com.tencent.mm.plugin.image.b)localObject2).DNG);
        j = com.tencent.mm.plugin.image.b.aLV(((com.tencent.mm.plugin.image.b)localObject2).DNG);
        params = ((Exif)localObject3).dateTimeOriginal;
        localObject4 = ((com.tencent.mm.plugin.image.b)localObject2).DNG;
        if (Util.isNullOrNil(params)) {
          break label1924;
        }
        params = com.tencent.mm.plugin.image.b.aLW(params);
        localObject4 = new n();
        ((n)localObject4).m("20 localID", ((com.tencent.mm.plugin.image.b)localObject2).DNH + ",");
        ((n)localObject4).m("21 MediaType", j + ",");
        ((n)localObject4).m("22 OriginWidth", ((com.tencent.mm.plugin.image.b)localObject2).DNI + ",");
        ((n)localObject4).m("23 OriginHeight", ((com.tencent.mm.plugin.image.b)localObject2).DNJ + ",");
        ((n)localObject4).m("24 CompressedWidth", ((com.tencent.mm.plugin.image.b)localObject2).DNL + ",");
        ((n)localObject4).m("25 CompressedHeight", ((com.tencent.mm.plugin.image.b)localObject2).DNM + ",");
        ((n)localObject4).m("26 OriginSize", ((com.tencent.mm.plugin.image.b)localObject2).DNK + ",");
        ((n)localObject4).m("27 CompressedSize", ((com.tencent.mm.plugin.image.b)localObject2).DNN + ",");
        ((n)localObject4).m("28 FNumber", ((Exif)localObject3).fNumber + ",");
        ((n)localObject4).m("29 ExposureTime", ((Exif)localObject3).exposureTime + ",");
        ((n)localObject4).m("30 ISO", ((Exif)localObject3).isoSpeedRatings + ",");
        ((n)localObject4).m("31 Flash", ((Exif)localObject3).flash + ",");
        ((n)localObject4).m("32 LensModel", com.tencent.mm.plugin.image.b.aLW(((Exif)localObject3).model) + ",");
        ((n)localObject4).m("33 CreatTime", params + ",");
        ((n)localObject4).m("34 IsFromWeChat", "0,");
        ((n)localObject4).m("35 Scene", ",");
        ((n)localObject4).m("36 sceneType", ((Exif)localObject3).sceneType + ",");
        ((n)localObject4).m("37 fileSource", ((Exif)localObject3).fileSource + ",");
        ((n)localObject4).m("38 make", ((Exif)localObject3).make + ",");
        ((n)localObject4).m("39 software", ((Exif)localObject3).software + ",");
        ((n)localObject4).m("40 fileExt", com.tencent.mm.plugin.image.b.asq(((com.tencent.mm.plugin.image.b)localObject2).DNG) + ",");
        ((n)localObject4).m("41 faceCount", "0,");
        ((n)localObject4).m("42 YCbCrSubSampling", ((Exif)localObject3).yCbCrSubSampling + ",");
        ((n)localObject4).m("43 md5", ((com.tencent.mm.plugin.image.b)localObject2).md5 + ',');
        Log.v("MicroMsg.ImgExtInfoReport", "report logbuffer MMImageExifInfo(14525): %s, orgPath:%s", new Object[] { ((n)localObject4).agI(), ((com.tencent.mm.plugin.image.b)localObject2).DNG });
        com.tencent.mm.plugin.report.service.h.IzE.a(14525, new Object[] { localObject4 });
        params = ((n)localObject4).toString();
        localObject2 = com.tencent.mm.plugin.sns.k.f.fQl();
        j = com.tencent.mm.plugin.image.b.aLV(str1);
        ((com.tencent.mm.plugin.sns.k.f)localObject2).KhV.put(Integer.valueOf(i), new f.a((com.tencent.mm.plugin.sns.k.f)localObject2, j, params));
        params = t.aZf(str4);
        str1 = bbD(str4);
        u.bBD(str1);
        Log.i("MicroMsg.snsMediaStorage", "checkcntpath ".concat(String.valueOf(str1)));
        u.on(str2 + str3, str1 + params);
        str2 = str1 + t.aZb(str4);
        str3 = str1 + t.aZc(str4);
        u.deleteFile(str2);
        u.deleteFile(str3);
        Log.i("MicroMsg.snsMediaStorage", "insert done " + (System.currentTimeMillis() - l) + " targetPath : " + str1 + params + " totalLen:" + u.bBQ(new StringBuilder().append(str1).append(params).toString()) + "  now delete...:" + str2 + " & " + str3);
        ((q)localObject1).KzW = str4;
        a(i, (q)localObject1);
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
          params = com.tencent.mm.plugin.image.b.aLW(new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(new Date(new com.tencent.mm.vfs.q((String)localObject4).lastModified())));
        }
      }
    }
    j = (int)u.bBQ(str2 + str3);
    localObject3 = a((s)localObject3, str2 + str3);
    k = ((s)localObject3).width;
    m = ((s)localObject3).height;
    ((com.tencent.mm.plugin.image.b)localObject2).DNL = k;
    ((com.tencent.mm.plugin.image.b)localObject2).DNM = m;
    ((com.tencent.mm.plugin.image.b)localObject2).DNN = j;
    localObject1 = new q();
    ((q)localObject1).KzW = str4;
    ((q)localObject1).createTime = ((int)Util.nowSecond());
    ((q)localObject1).type = i;
    params = new cvw();
    params.Privated = ((s)localObject3).JRw;
    params.TEb = ((s)localObject3).JRv;
    params.token = ((s)localObject3).JRx;
    params.TEk = ((s)localObject3).JRy;
    params.TEy = 0;
    params.TEx = new cvo();
    params.kQn = 0;
    params.CMB = ((s)localObject3).desc;
    Log.d("MicroMsg.snsMediaStorage", "upload.filterId " + ((s)localObject3).JRu);
    params.TEa = ((s)localObject3).JRu;
    params.TAg = 2;
    params.md5 = u.buc(str2 + str3);
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
        localObject5 = u.Tf(paramString);
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
      params.fileSize = ((int)u.bBQ(paramString));
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
    AppMethodBeat.i(254756);
    try
    {
      byte[] arrayOfByte = ay(paramBitmap);
      com.tencent.mm.plugin.emoji.g.cTr();
      if (com.tencent.mm.plugin.emoji.g.a(arrayOfByte, paramString1, paramString2, paramBitmap.getWidth(), paramBitmap.getHeight(), paramInt1, paramInt2) == 0)
      {
        AppMethodBeat.o(254756);
        return true;
      }
      AppMethodBeat.o(254756);
      return false;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      Log.w("MicroMsg.snsMediaStorage", "convertImg2WxamZip bmp OutOfMemoryError! rollback");
      AppMethodBeat.o(254756);
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
    //   60: getstatic 671	android/os/Build$VERSION:SDK_INT	I
    //   63: bipush 26
    //   65: if_icmple +44 -> 109
    //   68: aload_0
    //   69: ifnull +40 -> 109
    //   72: aload_0
    //   73: getfield 675	android/graphics/BitmapFactory$Options:outColorSpace	Landroid/graphics/ColorSpace;
    //   76: getstatic 681	android/graphics/ColorSpace$Named:DCI_P3	Landroid/graphics/ColorSpace$Named;
    //   79: invokestatic 687	android/graphics/ColorSpace:get	(Landroid/graphics/ColorSpace$Named;)Landroid/graphics/ColorSpace;
    //   82: if_acmpeq +16 -> 98
    //   85: aload_0
    //   86: getfield 675	android/graphics/BitmapFactory$Options:outColorSpace	Landroid/graphics/ColorSpace;
    //   89: getstatic 690	android/graphics/ColorSpace$Named:DISPLAY_P3	Landroid/graphics/ColorSpace$Named;
    //   92: invokestatic 687	android/graphics/ColorSpace:get	(Landroid/graphics/ColorSpace$Named;)Landroid/graphics/ColorSpace;
    //   95: if_acmpne +14 -> 109
    //   98: aload 21
    //   100: getstatic 693	android/graphics/ColorSpace$Named:SRGB	Landroid/graphics/ColorSpace$Named;
    //   103: invokestatic 687	android/graphics/ColorSpace:get	(Landroid/graphics/ColorSpace$Named;)Landroid/graphics/ColorSpace;
    //   106: putfield 696	android/graphics/BitmapFactory$Options:inPreferredColorSpace	Landroid/graphics/ColorSpace;
    //   109: iload_3
    //   110: i2d
    //   111: dconst_1
    //   112: dmul
    //   113: iload 4
    //   115: i2d
    //   116: ddiv
    //   117: dstore 11
    //   119: iload_2
    //   120: i2d
    //   121: dconst_1
    //   122: dmul
    //   123: iload 5
    //   125: i2d
    //   126: ddiv
    //   127: dstore 13
    //   129: iload_2
    //   130: iload 5
    //   132: if_icmpne +44 -> 176
    //   135: iload_3
    //   136: iload 4
    //   138: if_icmpne +38 -> 176
    //   141: aload_1
    //   142: aload 21
    //   144: invokestatic 701	com/tencent/mm/plugin/sns/d/a:b	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   147: astore_0
    //   148: ldc 65
    //   150: ldc_w 703
    //   153: iconst_1
    //   154: anewarray 69	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: aload_0
    //   160: aastore
    //   161: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   164: aload_0
    //   165: ifnonnull +258 -> 423
    //   168: ldc_w 664
    //   171: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: iconst_0
    //   175: ireturn
    //   176: aload 21
    //   178: iconst_1
    //   179: putfield 706	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   182: iload_3
    //   183: iload 4
    //   185: if_icmpgt +9 -> 194
    //   188: iload_2
    //   189: iload 5
    //   191: if_icmple +71 -> 262
    //   194: iconst_1
    //   195: ldc_w 708
    //   198: invokestatic 714	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   201: checkcast 708	com/tencent/mm/plugin/expt/b/b
    //   204: getstatic 720	com/tencent/mm/plugin/expt/b/b$a:vwa	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   207: iconst_0
    //   208: invokeinterface 723 3 0
    //   213: if_icmpne +157 -> 370
    //   216: iconst_1
    //   217: istore 17
    //   219: getstatic 728	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_PURPLE	Z
    //   222: ifne +722 -> 944
    //   225: getstatic 731	com/tencent/mm/sdk/platformtools/BuildInfo:IS_FLAVOR_RED	Z
    //   228: ifne +716 -> 944
    //   231: getstatic 734	com/tencent/mm/sdk/platformtools/BuildInfo:DEBUG	Z
    //   234: ifeq +707 -> 941
    //   237: goto +707 -> 944
    //   240: aload 21
    //   242: iload 18
    //   244: putfield 706	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   247: aload 21
    //   249: getfield 706	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   252: iconst_1
    //   253: if_icmpgt +9 -> 262
    //   256: aload 21
    //   258: iconst_1
    //   259: putfield 706	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   262: ldc_w 708
    //   265: invokestatic 714	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   268: checkcast 708	com/tencent/mm/plugin/expt/b/b
    //   271: getstatic 737	com/tencent/mm/plugin/expt/b/b$a:vwb	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   274: ldc_w 738
    //   277: invokeinterface 723 3 0
    //   282: i2l
    //   283: lstore 19
    //   285: iload_3
    //   286: iload_2
    //   287: imul
    //   288: aload 21
    //   290: getfield 706	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   293: idiv
    //   294: aload 21
    //   296: getfield 706	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   299: idiv
    //   300: i2l
    //   301: lload 19
    //   303: lcmp
    //   304: ifle +86 -> 390
    //   307: aload 21
    //   309: aload 21
    //   311: getfield 706	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   314: iconst_1
    //   315: iadd
    //   316: putfield 706	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   319: goto -34 -> 285
    //   322: astore_0
    //   323: aconst_null
    //   324: astore_1
    //   325: ldc 65
    //   327: aload_0
    //   328: ldc_w 740
    //   331: iconst_1
    //   332: anewarray 69	java/lang/Object
    //   335: dup
    //   336: iconst_0
    //   337: aload 9
    //   339: aastore
    //   340: invokestatic 551	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   343: getstatic 484	com/tencent/mm/plugin/report/service/h:IzE	Lcom/tencent/mm/plugin/report/service/h;
    //   346: ldc2_w 741
    //   349: lconst_1
    //   350: lconst_1
    //   351: invokevirtual 746	com/tencent/mm/plugin/report/service/h:p	(JJJ)V
    //   354: aload_1
    //   355: ifnull +7 -> 362
    //   358: aload_1
    //   359: invokevirtual 749	java/io/OutputStream:close	()V
    //   362: ldc_w 664
    //   365: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   368: iconst_0
    //   369: ireturn
    //   370: iconst_0
    //   371: istore 17
    //   373: goto -154 -> 219
    //   376: dload 11
    //   378: dstore 15
    //   380: goto +579 -> 959
    //   383: dload 13
    //   385: dstore 15
    //   387: goto +594 -> 981
    //   390: ldc 65
    //   392: ldc_w 751
    //   395: iconst_1
    //   396: anewarray 69	java/lang/Object
    //   399: dup
    //   400: iconst_0
    //   401: aload 21
    //   403: getfield 706	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   406: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   409: aastore
    //   410: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   413: aload_1
    //   414: aload 21
    //   416: invokestatic 701	com/tencent/mm/plugin/sns/d/a:b	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   419: astore_0
    //   420: goto -272 -> 148
    //   423: iload 10
    //   425: ifeq +328 -> 753
    //   428: dload 11
    //   430: dload 13
    //   432: dcmpg
    //   433: ifge +294 -> 727
    //   436: iload 5
    //   438: i2d
    //   439: dconst_1
    //   440: dmul
    //   441: iload_3
    //   442: i2d
    //   443: dmul
    //   444: iload_2
    //   445: i2d
    //   446: ddiv
    //   447: invokestatic 757	java/lang/Math:ceil	(D)D
    //   450: d2i
    //   451: istore_3
    //   452: iload 5
    //   454: istore_2
    //   455: aload_1
    //   456: invokestatic 762	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$ExifHelper:getExifOrientation	(Ljava/lang/String;)I
    //   459: istore 4
    //   461: iload 4
    //   463: bipush 90
    //   465: if_icmpeq +524 -> 989
    //   468: iload 4
    //   470: sipush 270
    //   473: if_icmpne +465 -> 938
    //   476: goto +513 -> 989
    //   479: ldc 65
    //   481: ldc_w 764
    //   484: iconst_4
    //   485: anewarray 69	java/lang/Object
    //   488: dup
    //   489: iconst_0
    //   490: aload_0
    //   491: invokevirtual 651	android/graphics/Bitmap:getWidth	()I
    //   494: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   497: aastore
    //   498: dup
    //   499: iconst_1
    //   500: aload_0
    //   501: invokevirtual 654	android/graphics/Bitmap:getHeight	()I
    //   504: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   507: aastore
    //   508: dup
    //   509: iconst_2
    //   510: iload_2
    //   511: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   514: aastore
    //   515: dup
    //   516: iconst_3
    //   517: iload_3
    //   518: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   521: aastore
    //   522: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   525: aload_0
    //   526: iload_2
    //   527: iload_3
    //   528: iconst_1
    //   529: invokestatic 768	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   532: astore 23
    //   534: aload_0
    //   535: astore 21
    //   537: aload 23
    //   539: ifnull +19 -> 558
    //   542: aload_0
    //   543: aload 23
    //   545: if_acmpeq +455 -> 1000
    //   548: invokestatic 774	com/tencent/mm/memory/l:baT	()Lcom/tencent/mm/memory/l;
    //   551: aload_0
    //   552: invokevirtual 778	com/tencent/mm/memory/l:s	(Landroid/graphics/Bitmap;)V
    //   555: goto +445 -> 1000
    //   558: ldc 65
    //   560: ldc_w 780
    //   563: iconst_2
    //   564: anewarray 69	java/lang/Object
    //   567: dup
    //   568: iconst_0
    //   569: aload 21
    //   571: invokevirtual 651	android/graphics/Bitmap:getWidth	()I
    //   574: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   577: aastore
    //   578: dup
    //   579: iconst_1
    //   580: aload 21
    //   582: invokevirtual 654	android/graphics/Bitmap:getHeight	()I
    //   585: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   588: aastore
    //   589: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   592: invokestatic 783	com/tencent/mm/plugin/sns/storage/r:fSY	()Z
    //   595: ifeq +234 -> 829
    //   598: iload 10
    //   600: ifeq +229 -> 829
    //   603: aload 21
    //   605: aload_1
    //   606: new 97	java/lang/StringBuilder
    //   609: dup
    //   610: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   613: aload 8
    //   615: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: aload 9
    //   620: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: invokestatic 786	com/tencent/mm/plugin/sns/storage/r:b	(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;)Z
    //   629: ifne +306 -> 935
    //   632: new 97	java/lang/StringBuilder
    //   635: dup
    //   636: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   639: aload 8
    //   641: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: aload 9
    //   646: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   652: invokestatic 532	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   655: pop
    //   656: new 97	java/lang/StringBuilder
    //   659: dup
    //   660: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   663: aload 8
    //   665: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload 9
    //   670: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   676: invokestatic 790	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   679: astore 8
    //   681: aload 8
    //   683: astore_0
    //   684: aload 8
    //   686: astore_1
    //   687: aload 21
    //   689: iload 7
    //   691: aload 6
    //   693: aload 8
    //   695: iconst_0
    //   696: invokestatic 794	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToStream	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/io/OutputStream;Z)Z
    //   699: pop
    //   700: aload 8
    //   702: astore_0
    //   703: aload 8
    //   705: astore_1
    //   706: aload 8
    //   708: invokevirtual 749	java/io/OutputStream:close	()V
    //   711: invokestatic 774	com/tencent/mm/memory/l:baT	()Lcom/tencent/mm/memory/l;
    //   714: aload 21
    //   716: invokevirtual 778	com/tencent/mm/memory/l:s	(Landroid/graphics/Bitmap;)V
    //   719: ldc_w 664
    //   722: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   725: iconst_1
    //   726: ireturn
    //   727: iload 4
    //   729: i2d
    //   730: dconst_1
    //   731: dmul
    //   732: iload_2
    //   733: i2d
    //   734: dmul
    //   735: iload_3
    //   736: i2d
    //   737: ddiv
    //   738: dstore 11
    //   740: dload 11
    //   742: invokestatic 757	java/lang/Math:ceil	(D)D
    //   745: d2i
    //   746: istore_2
    //   747: iload 4
    //   749: istore_3
    //   750: goto -295 -> 455
    //   753: ldc 65
    //   755: ldc_w 796
    //   758: iconst_2
    //   759: anewarray 69	java/lang/Object
    //   762: dup
    //   763: iconst_0
    //   764: aload_0
    //   765: invokevirtual 651	android/graphics/Bitmap:getWidth	()I
    //   768: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   771: aastore
    //   772: dup
    //   773: iconst_1
    //   774: aload_0
    //   775: invokevirtual 654	android/graphics/Bitmap:getHeight	()I
    //   778: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   781: aastore
    //   782: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   785: aload_0
    //   786: astore 21
    //   788: goto -196 -> 592
    //   791: astore_0
    //   792: aload 22
    //   794: astore_1
    //   795: ldc 65
    //   797: aload_0
    //   798: ldc_w 740
    //   801: iconst_1
    //   802: anewarray 69	java/lang/Object
    //   805: dup
    //   806: iconst_0
    //   807: aload 9
    //   809: aastore
    //   810: invokestatic 551	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   813: aload_1
    //   814: ifnull +7 -> 821
    //   817: aload_1
    //   818: invokevirtual 749	java/io/OutputStream:close	()V
    //   821: ldc_w 664
    //   824: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   827: iconst_0
    //   828: ireturn
    //   829: new 97	java/lang/StringBuilder
    //   832: dup
    //   833: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   836: aload 8
    //   838: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: aload 9
    //   843: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   849: invokestatic 790	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   852: astore 8
    //   854: aload 8
    //   856: astore_0
    //   857: aload 8
    //   859: astore_1
    //   860: aload 21
    //   862: iload 7
    //   864: aload 6
    //   866: aload 8
    //   868: iconst_0
    //   869: invokestatic 794	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToStream	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/io/OutputStream;Z)Z
    //   872: pop
    //   873: aload 8
    //   875: astore_0
    //   876: aload 8
    //   878: astore_1
    //   879: invokestatic 774	com/tencent/mm/memory/l:baT	()Lcom/tencent/mm/memory/l;
    //   882: aload 21
    //   884: invokevirtual 778	com/tencent/mm/memory/l:s	(Landroid/graphics/Bitmap;)V
    //   887: aload 8
    //   889: astore_0
    //   890: aload 8
    //   892: astore_1
    //   893: aload 8
    //   895: invokevirtual 749	java/io/OutputStream:close	()V
    //   898: goto -179 -> 719
    //   901: astore 6
    //   903: aload_0
    //   904: astore_1
    //   905: aload 6
    //   907: astore_0
    //   908: goto -583 -> 325
    //   911: astore_0
    //   912: goto -550 -> 362
    //   915: astore_0
    //   916: goto -95 -> 821
    //   919: astore_0
    //   920: goto -125 -> 795
    //   923: astore_0
    //   924: aconst_null
    //   925: astore_1
    //   926: goto -131 -> 795
    //   929: astore_0
    //   930: aconst_null
    //   931: astore_1
    //   932: goto -607 -> 325
    //   935: goto -224 -> 711
    //   938: goto -459 -> 479
    //   941: goto +6 -> 947
    //   944: iconst_1
    //   945: istore 17
    //   947: dload 11
    //   949: dload 13
    //   951: dcmpg
    //   952: ifge -576 -> 376
    //   955: dload 13
    //   957: dstore 15
    //   959: dload 15
    //   961: d2i
    //   962: istore 18
    //   964: iload 17
    //   966: ifeq -726 -> 240
    //   969: dload 11
    //   971: dload 13
    //   973: dcmpg
    //   974: ifge -591 -> 383
    //   977: dload 11
    //   979: dstore 15
    //   981: dload 15
    //   983: d2i
    //   984: istore 18
    //   986: goto -746 -> 240
    //   989: iload_2
    //   990: istore 4
    //   992: iload_3
    //   993: istore_2
    //   994: iload 4
    //   996: istore_3
    //   997: goto -518 -> 479
    //   1000: aload 23
    //   1002: astore 21
    //   1004: goto -446 -> 558
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1007	0	paramOptions	BitmapFactory.Options
    //   0	1007	1	paramString1	String
    //   0	1007	2	paramInt1	int
    //   0	1007	3	paramInt2	int
    //   0	1007	4	paramInt3	int
    //   0	1007	5	paramInt4	int
    //   0	1007	6	paramCompressFormat	Bitmap.CompressFormat
    //   0	1007	7	paramInt5	int
    //   0	1007	8	paramString2	String
    //   0	1007	9	paramString3	String
    //   0	1007	10	paramBoolean	boolean
    //   117	861	11	d1	double
    //   127	845	13	d2	double
    //   378	604	15	d3	double
    //   217	748	17	i	int
    //   242	743	18	j	int
    //   283	19	19	l	long
    //   58	945	21	localObject1	Object
    //   7	786	22	localObject2	Object
    //   532	469	23	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   9	68	322	java/lang/OutOfMemoryError
    //   72	98	322	java/lang/OutOfMemoryError
    //   98	109	322	java/lang/OutOfMemoryError
    //   109	129	322	java/lang/OutOfMemoryError
    //   141	148	322	java/lang/OutOfMemoryError
    //   148	164	322	java/lang/OutOfMemoryError
    //   176	182	322	java/lang/OutOfMemoryError
    //   194	216	322	java/lang/OutOfMemoryError
    //   219	237	322	java/lang/OutOfMemoryError
    //   240	262	322	java/lang/OutOfMemoryError
    //   262	285	322	java/lang/OutOfMemoryError
    //   285	319	322	java/lang/OutOfMemoryError
    //   390	420	322	java/lang/OutOfMemoryError
    //   436	452	322	java/lang/OutOfMemoryError
    //   455	461	322	java/lang/OutOfMemoryError
    //   479	534	322	java/lang/OutOfMemoryError
    //   548	555	322	java/lang/OutOfMemoryError
    //   558	592	322	java/lang/OutOfMemoryError
    //   592	598	322	java/lang/OutOfMemoryError
    //   603	681	322	java/lang/OutOfMemoryError
    //   740	747	322	java/lang/OutOfMemoryError
    //   753	785	322	java/lang/OutOfMemoryError
    //   829	854	322	java/lang/OutOfMemoryError
    //   9	68	791	java/io/IOException
    //   72	98	791	java/io/IOException
    //   98	109	791	java/io/IOException
    //   109	129	791	java/io/IOException
    //   141	148	791	java/io/IOException
    //   148	164	791	java/io/IOException
    //   176	182	791	java/io/IOException
    //   194	216	791	java/io/IOException
    //   219	237	791	java/io/IOException
    //   240	262	791	java/io/IOException
    //   262	285	791	java/io/IOException
    //   285	319	791	java/io/IOException
    //   390	420	791	java/io/IOException
    //   436	452	791	java/io/IOException
    //   455	461	791	java/io/IOException
    //   479	534	791	java/io/IOException
    //   548	555	791	java/io/IOException
    //   558	592	791	java/io/IOException
    //   592	598	791	java/io/IOException
    //   603	681	791	java/io/IOException
    //   740	747	791	java/io/IOException
    //   753	785	791	java/io/IOException
    //   829	854	791	java/io/IOException
    //   687	700	901	java/lang/OutOfMemoryError
    //   706	711	901	java/lang/OutOfMemoryError
    //   860	873	901	java/lang/OutOfMemoryError
    //   879	887	901	java/lang/OutOfMemoryError
    //   893	898	901	java/lang/OutOfMemoryError
    //   358	362	911	java/io/IOException
    //   817	821	915	java/io/IOException
    //   687	700	919	java/io/IOException
    //   706	711	919	java/io/IOException
    //   860	873	919	java/io/IOException
    //   879	887	919	java/io/IOException
    //   893	898	919	java/io/IOException
    //   711	719	923	java/io/IOException
    //   711	719	929	java/lang/OutOfMemoryError
  }
  
  private static boolean a(BitmapFactory.Options paramOptions, String paramString1, int paramInt1, int paramInt2, int paramInt3, Bitmap.CompressFormat paramCompressFormat, int paramInt4, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(254779);
    localObject3 = null;
    localObject1 = localObject3;
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, srcWidth: %d, srcHeight: %d, fixShort: %d, quality:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
        localObject1 = localObject3;
        localObject2 = new BitmapFactory.Options();
        localObject1 = localObject3;
        if ((Build.VERSION.SDK_INT <= 26) || (paramOptions == null)) {
          continue;
        }
        localObject1 = localObject3;
        if (paramOptions.outColorSpace != ColorSpace.get(ColorSpace.Named.DCI_P3))
        {
          localObject1 = localObject3;
          if (paramOptions.outColorSpace != ColorSpace.get(ColorSpace.Named.DISPLAY_P3)) {}
        }
        else
        {
          localObject1 = localObject3;
          ((BitmapFactory.Options)localObject2).inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
      }
      catch (OutOfMemoryError paramOptions)
      {
        long l;
        paramString1 = null;
        Log.printErrStackTrace("MicroMsg.snsMediaStorage", paramOptions, "create thumbnail from orig failed: %s", new Object[] { paramString3 });
        com.tencent.mm.plugin.report.service.h.IzE.p(1487L, 0L, 1L);
        if (paramString1 == null) {
          continue;
        }
      }
      catch (IOException paramOptions)
      {
        try
        {
          paramString1.close();
          AppMethodBeat.o(254779);
          return false;
          localObject1 = localObject3;
          Log.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, sampleSize: %s", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject2).inSampleSize) });
          localObject1 = localObject3;
          paramOptions = com.tencent.mm.plugin.sns.d.a.b(paramString1, (BitmapFactory.Options)localObject2);
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
            l.baT().s(paramOptions);
            localObject2 = localBitmap;
          }
          localObject1 = localObject3;
          Log.i("MicroMsg.snsMediaStorage", "createThumbNailUnScaleFixShort, bm.width: %s, bm.height: %s, quality:%d", new Object[] { Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()), Integer.valueOf(paramInt4) });
          localObject1 = localObject3;
          if ((fSY()) && (paramBoolean))
          {
            localObject1 = localObject3;
            if (!a((Bitmap)localObject2, paramString1, paramString2 + paramString3, j, paramInt3))
            {
              localObject1 = localObject3;
              u.deleteFile(paramString2 + paramString3);
              localObject1 = localObject3;
              paramString1 = u.Te(paramString2 + paramString3);
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
            l.baT().s((Bitmap)localObject2);
            localObject1 = null;
            Log.i("MicroMsg.snsMediaStorage", "createThumbNailUnScaleFixShort saving to %s, size:%d", new Object[] { paramString2 + paramString3, Long.valueOf(u.bBQ(paramString2 + paramString3)) });
            AppMethodBeat.o(254779);
            return true;
          }
          catch (OutOfMemoryError paramCompressFormat)
          {
            paramString1 = paramOptions;
            paramOptions = paramCompressFormat;
          }
          localObject1 = localObject3;
          paramString1 = u.Te(paramString2 + paramString3);
          localObject1 = paramString1;
          paramOptions = paramString1;
          BitmapUtil.saveBitmapToStream((Bitmap)localObject2, paramInt4, paramCompressFormat, paramString1, false);
          localObject1 = paramString1;
          paramOptions = paramString1;
          l.baT().s((Bitmap)localObject2);
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
            AppMethodBeat.o(254779);
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
        if (paramInt2 <= paramInt1) {
          continue;
        }
        int i = paramInt1;
        continue;
        int k = paramInt3;
        paramInt3 = j;
        int j = k;
        continue;
      }
      if (i != paramInt3) {
        continue;
      }
      localObject1 = localObject3;
      paramOptions = com.tencent.mm.plugin.sns.d.a.b(paramString1, (BitmapFactory.Options)localObject2);
      localObject1 = localObject3;
      Log.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, result bm: %s", new Object[] { paramOptions });
      if (paramOptions != null) {
        continue;
      }
      AppMethodBeat.o(254779);
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
    l = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vwb, 10240000);
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
  
  private boolean a(q paramq)
  {
    AppMethodBeat.i(97599);
    Log.d("MicroMsg.snsMediaStorage", "snsMedia Insert");
    if (paramq == null)
    {
      AppMethodBeat.o(97599);
      return false;
    }
    paramq = paramq.fST();
    if ((int)this.lvy.insert("SnsMedia", "local_id", paramq) != -1)
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
      localObject3 = u.Tf(paramString1 + paramString2);
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
  
  public static boolean aL(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(293121);
    boolean bool = h(paramString1, paramString2, paramString3, true);
    AppMethodBeat.o(293121);
    return bool;
  }
  
  private static byte[] ay(Bitmap paramBitmap)
  {
    AppMethodBeat.i(254750);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramBitmap.getByteCount());
    paramBitmap.copyPixelsToBuffer(localByteBuffer);
    paramBitmap = localByteBuffer.array();
    AppMethodBeat.o(254750);
    return paramBitmap;
  }
  
  private static boolean b(Bitmap paramBitmap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(254754);
    try
    {
      byte[] arrayOfByte = ay(paramBitmap);
      com.tencent.mm.plugin.emoji.g.cTr();
      if (com.tencent.mm.plugin.emoji.g.a(arrayOfByte, paramString1, paramString2, paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getWidth(), paramBitmap.getHeight()) == 0)
      {
        AppMethodBeat.o(254754);
        return true;
      }
      AppMethodBeat.o(254754);
      return false;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      Log.w("MicroMsg.snsMediaStorage", "convertImg2WxamWithoutZip bmp OutOfMemoryError! rollback");
      AppMethodBeat.o(254754);
    }
    return false;
  }
  
  private boolean b(String paramString, q paramq)
  {
    AppMethodBeat.i(97601);
    paramq = paramq.fST();
    if (this.lvy.update("SnsMedia", paramq, "StrId=?", new String[] { String.valueOf(paramString) }) > 0)
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
        u.deleteFile(paramString1 + paramString3);
        localObject1 = BitmapUtil.getImageOptions(paramString1 + paramString2);
        if (localObject1 == null)
        {
          Log.e("MicroMsg.snsMediaStorage", "createUserAlbum, getImageOptions error");
          AppMethodBeat.o(97618);
          return false;
        }
        if ((Build.VERSION.SDK_INT > 26) && (localObject1 != null) && ((((BitmapFactory.Options)localObject1).outColorSpace == ColorSpace.get(ColorSpace.Named.DCI_P3)) || (((BitmapFactory.Options)localObject1).outColorSpace == ColorSpace.get(ColorSpace.Named.DISPLAY_P3)))) {
          ((BitmapFactory.Options)localObject1).inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
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
        com.tencent.mm.plugin.report.service.h.IzE.p(1487L, 2L, 1L);
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
        Object localObject1 = com.tencent.mm.plugin.sns.d.a.b(paramString1 + paramString2, (BitmapFactory.Options)localObject1);
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
        localObject2 = l.baT().a(str, (Rect)localObject2, (BitmapFactory.Options)localObject1);
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
        l.baT().s((Bitmap)localObject1);
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
      u.deleteFile(paramString1 + paramString2);
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
      localObject1 = com.tencent.mm.plugin.sns.d.a.b(paramString1 + paramString2, (BitmapFactory.Options)localObject1);
    }
    if (n * 1.0D / k > i1 * 1.0D / m)
    {
      j = (int)Math.ceil(m * 1.0D * n / i1);
      i = m;
      Log.d("MicroMsg.snsMediaStorage", "createUserAlbum, newWidth: %s, newHeight: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      if ((n <= j) && (i1 <= i)) {
        break label687;
      }
      ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      if ((n > j) || (i1 > i))
      {
        d1 = n * 1.0D / j;
        d2 = i1 * 1.0D / i;
        if (d1 >= d2) {
          break label1177;
        }
        d1 = d2;
        ((BitmapFactory.Options)localObject1).inSampleSize = ((int)d1);
        if (((BitmapFactory.Options)localObject1).inSampleSize <= 1) {
          ((BitmapFactory.Options)localObject1).inSampleSize = 1;
        }
      }
      l = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vwb, 10240000);
      while (n * i1 / ((BitmapFactory.Options)localObject1).inSampleSize / ((BitmapFactory.Options)localObject1).inSampleSize > l) {
        ((BitmapFactory.Options)localObject1).inSampleSize += 1;
      }
    }
  }
  
  private static String bbD(String paramString)
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
    paramString = aj.getAccSnsPath() + paramString + str1;
    AppMethodBeat.o(97598);
    return paramString;
  }
  
  /* Error */
  public static boolean bbF(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 987
    //   5: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 590	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
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
    //   35: invokestatic 833	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   38: pop
    //   39: aload_0
    //   40: astore_2
    //   41: aload_3
    //   42: getfield 838	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   45: astore_3
    //   46: aload_0
    //   47: astore_2
    //   48: ldc 65
    //   50: ldc_w 989
    //   53: aload_3
    //   54: invokestatic 130	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   57: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   60: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_0
    //   64: astore_2
    //   65: aload_3
    //   66: invokevirtual 893	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   69: ldc_w 991
    //   72: invokevirtual 994	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   75: istore_1
    //   76: iload_1
    //   77: iflt +19 -> 96
    //   80: aload_0
    //   81: ifnull +7 -> 88
    //   84: aload_0
    //   85: invokevirtual 630	java/io/InputStream:close	()V
    //   88: ldc_w 987
    //   91: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: iconst_1
    //   95: ireturn
    //   96: aload_0
    //   97: ifnull +7 -> 104
    //   100: aload_0
    //   101: invokevirtual 630	java/io/InputStream:close	()V
    //   104: ldc_w 987
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
    //   123: ldc_w 987
    //   126: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: iconst_0
    //   130: ireturn
    //   131: astore_0
    //   132: aload_2
    //   133: ifnull +7 -> 140
    //   136: aload_2
    //   137: invokevirtual 630	java/io/InputStream:close	()V
    //   140: ldc_w 987
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
  
  public static Bitmap bbG(String paramString)
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
  
  public static boolean fSX()
  {
    AppMethodBeat.i(97609);
    if ("hevc".equals(ac.mGE))
    {
      AppMethodBeat.o(97609);
      return true;
    }
    boolean bool = aj.fOX();
    AppMethodBeat.o(97609);
    return bool;
  }
  
  public static boolean fSY()
  {
    AppMethodBeat.i(254745);
    if ("wxam".equals(ac.mGE))
    {
      AppMethodBeat.o(254745);
      return true;
    }
    boolean bool = aj.fOZ();
    AppMethodBeat.o(254745);
    return bool;
  }
  
  public static boolean fSZ()
  {
    AppMethodBeat.i(97610);
    if ("wxpc".equals(ac.mGE))
    {
      AppMethodBeat.o(97610);
      return true;
    }
    boolean bool = aj.fPa();
    AppMethodBeat.o(97610);
    return bool;
  }
  
  public static boolean fTa()
  {
    return (APq >= 1080) && (JER >= 1080);
  }
  
  public static int getScreenWidth()
  {
    if (JER > APq) {
      return APq;
    }
    return JER;
  }
  
  /* Error */
  public static boolean h(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 1031
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 823	com/tencent/mm/sdk/platformtools/BitmapUtil:getImageOptions	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   10: astore 20
    //   12: aload 20
    //   14: ifnull +1047 -> 1061
    //   17: aload 20
    //   19: getfield 838	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   22: astore 21
    //   24: ldc 65
    //   26: ldc_w 1033
    //   29: aload 21
    //   31: invokestatic 130	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   34: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload 21
    //   42: ifnull +1019 -> 1061
    //   45: aload 21
    //   47: invokevirtual 893	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   50: astore 21
    //   52: aload 21
    //   54: ldc_w 1035
    //   57: invokevirtual 994	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   60: iflt +967 -> 1027
    //   63: iconst_1
    //   64: istore 16
    //   66: aload 20
    //   68: ifnull +1016 -> 1084
    //   71: aload 20
    //   73: getfield 838	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   76: astore 21
    //   78: aload 21
    //   80: ifnull +1004 -> 1084
    //   83: aload 21
    //   85: invokevirtual 893	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   88: astore 21
    //   90: aload 21
    //   92: ldc_w 1035
    //   95: invokevirtual 994	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   98: iflt +969 -> 1067
    //   101: iconst_1
    //   102: istore 17
    //   104: aload 20
    //   106: ifnull +27 -> 133
    //   109: aload 20
    //   111: getfield 838	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   114: astore 21
    //   116: aload 21
    //   118: ifnull +15 -> 133
    //   121: aload 21
    //   123: invokevirtual 893	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   126: ldc_w 902
    //   129: invokevirtual 994	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   132: pop
    //   133: iconst_m1
    //   134: istore 8
    //   136: bipush 100
    //   138: istore 9
    //   140: iload 8
    //   142: istore 10
    //   144: iload_3
    //   145: ifeq +242 -> 387
    //   148: invokestatic 1041	com/tencent/mm/aq/f:bkg	()Lcom/tencent/mm/aq/b;
    //   151: pop
    //   152: bipush 64
    //   154: invokestatic 1047	com/tencent/mm/aq/b:vQ	(I)Z
    //   157: ifne +21 -> 178
    //   160: invokestatic 1049	com/tencent/mm/plugin/sns/storage/r:fSX	()Z
    //   163: ifne +15 -> 178
    //   166: invokestatic 1051	com/tencent/mm/plugin/sns/storage/r:fSZ	()Z
    //   169: ifne +9 -> 178
    //   172: invokestatic 783	com/tencent/mm/plugin/sns/storage/r:fSY	()Z
    //   175: ifeq +990 -> 1165
    //   178: invokestatic 1057	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   181: invokestatic 1063	com/tencent/mm/sdk/platformtools/NetStatusUtil:isWifi	(Landroid/content/Context;)Z
    //   184: ifeq +906 -> 1090
    //   187: invokestatic 1069	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   190: ldc_w 1071
    //   193: invokevirtual 1076	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   196: bipush 70
    //   198: invokestatic 1080	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   201: istore 7
    //   203: ldc 65
    //   205: ldc_w 1082
    //   208: bipush 7
    //   210: anewarray 69	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: invokestatic 1069	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   218: ldc_w 1071
    //   221: invokevirtual 1076	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   224: aastore
    //   225: dup
    //   226: iconst_1
    //   227: invokestatic 1069	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   230: ldc_w 1084
    //   233: invokevirtual 1076	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   236: aastore
    //   237: dup
    //   238: iconst_2
    //   239: invokestatic 1069	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   242: ldc_w 1086
    //   245: invokevirtual 1076	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   248: aastore
    //   249: dup
    //   250: iconst_3
    //   251: invokestatic 1069	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   254: ldc_w 1088
    //   257: invokevirtual 1076	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   260: aastore
    //   261: dup
    //   262: iconst_4
    //   263: invokestatic 1069	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   266: ldc_w 1090
    //   269: invokevirtual 1076	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   272: aastore
    //   273: dup
    //   274: iconst_5
    //   275: invokestatic 1069	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   278: ldc_w 1092
    //   281: invokevirtual 1076	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   284: aastore
    //   285: dup
    //   286: bipush 6
    //   288: invokestatic 1069	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   291: ldc_w 1094
    //   294: invokevirtual 1076	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   297: aastore
    //   298: invokestatic 914	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: ldc 65
    //   303: ldc_w 1096
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
    //   321: invokestatic 1101	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   324: aastore
    //   325: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   328: iload 7
    //   330: bipush 10
    //   332: if_icmple +10 -> 342
    //   335: iload 7
    //   337: bipush 100
    //   339: if_icmple +3606 -> 3945
    //   342: bipush 60
    //   344: istore 7
    //   346: iload 8
    //   348: istore 10
    //   350: iload 7
    //   352: istore 9
    //   354: iload 17
    //   356: ifeq +31 -> 387
    //   359: aload_1
    //   360: invokestatic 1106	com/tencent/mm/sdk/platformtools/MMNativeJpeg:queryQuality	(Ljava/lang/String;)I
    //   363: istore 8
    //   365: iload 8
    //   367: iload 7
    //   369: if_icmpge +3565 -> 3934
    //   372: iload 8
    //   374: bipush 25
    //   376: if_icmple +3558 -> 3934
    //   379: iload 8
    //   381: istore 9
    //   383: iload 8
    //   385: istore 10
    //   387: aload_1
    //   388: invokestatic 188	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   391: l2i
    //   392: istore 14
    //   394: sipush 1080
    //   397: istore 8
    //   399: aload_1
    //   400: invokestatic 1111	com/tencent/mm/plugin/facedetect/FaceProNative:detectFaceCnt	(Ljava/lang/String;)I
    //   403: istore 7
    //   405: ldc 65
    //   407: ldc_w 1113
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
    //   442: if_icmplt +801 -> 1243
    //   445: iload 11
    //   447: istore 7
    //   449: invokestatic 1069	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   452: ldc_w 1115
    //   455: invokevirtual 1076	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   458: astore 21
    //   460: iload 11
    //   462: istore 7
    //   464: aload 21
    //   466: ldc_w 1117
    //   469: invokevirtual 1121	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   472: iconst_0
    //   473: aaload
    //   474: invokestatic 1124	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   477: invokevirtual 1127	java/lang/Integer:intValue	()I
    //   480: istore 11
    //   482: iload 11
    //   484: istore 7
    //   486: aload 21
    //   488: ldc_w 1117
    //   491: invokevirtual 1121	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   494: iconst_1
    //   495: aaload
    //   496: invokestatic 1124	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   499: invokevirtual 1127	java/lang/Integer:intValue	()I
    //   502: istore 12
    //   504: iload 12
    //   506: istore 8
    //   508: iload 11
    //   510: istore 7
    //   512: ldc 65
    //   514: ldc_w 1129
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
    //   540: getstatic 34	com/tencent/mm/plugin/sns/storage/r:APq	I
    //   543: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   546: aastore
    //   547: dup
    //   548: iconst_3
    //   549: getstatic 32	com/tencent/mm/plugin/sns/storage/r:JER	I
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
    //   567: invokestatic 1101	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   570: aastore
    //   571: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   574: iload 7
    //   576: ifgt +986 -> 1562
    //   579: iload 8
    //   581: ifgt +981 -> 1562
    //   584: iconst_0
    //   585: istore 7
    //   587: sipush 1080
    //   590: istore 8
    //   592: invokestatic 1069	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   595: ldc_w 1131
    //   598: invokevirtual 1076	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   601: bipush 100
    //   603: invokestatic 1080	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
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
    //   629: invokestatic 1069	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   632: ldc_w 1133
    //   635: invokevirtual 1076	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   638: sipush 200
    //   641: invokestatic 1080	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
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
    //   668: invokestatic 1069	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   671: ldc_w 1135
    //   674: invokevirtual 1076	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   677: bipush 10
    //   679: invokestatic 1080	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   682: istore 12
    //   684: iload 12
    //   686: ifle +10 -> 696
    //   689: iload 12
    //   691: bipush 100
    //   693: if_icmplt +3235 -> 3928
    //   696: bipush 10
    //   698: istore 12
    //   700: iconst_0
    //   701: istore 11
    //   703: iload 17
    //   705: ifeq +934 -> 1639
    //   708: aload_1
    //   709: invokestatic 357	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
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
    //   736: ldc_w 1137
    //   739: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   742: aload 20
    //   744: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   747: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   750: ldc_w 1139
    //   753: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: aload 20
    //   758: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   761: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   764: ldc_w 1139
    //   767: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: iload 16
    //   772: invokevirtual 1142	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   775: ldc_w 1144
    //   778: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: iload 10
    //   783: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   786: ldc_w 1146
    //   789: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: iload 11
    //   794: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   797: ldc_w 1148
    //   800: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: iload 14
    //   805: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   808: ldc_w 1150
    //   811: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: iload 7
    //   816: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   819: ldc_w 1139
    //   822: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: iload 8
    //   827: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   830: ldc_w 1152
    //   833: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: iload 17
    //   838: invokevirtual 1142	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   841: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   844: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   847: invokestatic 1069	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   850: ldc_w 1154
    //   853: invokevirtual 1076	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   856: bipush 10
    //   858: invokestatic 1080	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
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
    //   889: if_icmplt +1838 -> 2727
    //   892: aload 20
    //   894: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   897: aload 20
    //   899: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   902: imul
    //   903: ldc_w 738
    //   906: if_icmpgt +1578 -> 2484
    //   909: iload 14
    //   911: iload 15
    //   913: if_icmpge +799 -> 1712
    //   916: iload 16
    //   918: ifeq +794 -> 1712
    //   921: iload 11
    //   923: ifne +789 -> 1712
    //   926: invokestatic 783	com/tencent/mm/plugin/sns/storage/r:fSY	()Z
    //   929: ifeq +724 -> 1653
    //   932: iload_3
    //   933: ifeq +720 -> 1653
    //   936: aload_1
    //   937: new 97	java/lang/StringBuilder
    //   940: dup
    //   941: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   944: aload_0
    //   945: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: aload_2
    //   949: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   955: invokestatic 1158	com/tencent/mm/plugin/sns/storage/r:li	(Ljava/lang/String;Ljava/lang/String;)Z
    //   958: istore 16
    //   960: iload 16
    //   962: istore_3
    //   963: iload 16
    //   965: ifne +54 -> 1019
    //   968: new 97	java/lang/StringBuilder
    //   971: dup
    //   972: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   975: aload_0
    //   976: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: aload_2
    //   980: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   986: invokestatic 532	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
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
    //   1009: invokestatic 523	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   1012: lconst_0
    //   1013: lcmp
    //   1014: iflt +634 -> 1648
    //   1017: iconst_1
    //   1018: istore_3
    //   1019: ldc_w 1031
    //   1022: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1025: iload_3
    //   1026: ireturn
    //   1027: aload 21
    //   1029: ldc_w 1160
    //   1032: invokevirtual 994	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1035: iflt +9 -> 1044
    //   1038: iconst_1
    //   1039: istore 16
    //   1041: goto -975 -> 66
    //   1044: aload 21
    //   1046: ldc_w 895
    //   1049: invokevirtual 994	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1052: iflt +9 -> 1061
    //   1055: iconst_1
    //   1056: istore 16
    //   1058: goto -992 -> 66
    //   1061: iconst_0
    //   1062: istore 16
    //   1064: goto -998 -> 66
    //   1067: aload 21
    //   1069: ldc_w 1160
    //   1072: invokevirtual 994	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1075: iflt +9 -> 1084
    //   1078: iconst_1
    //   1079: istore 17
    //   1081: goto -977 -> 104
    //   1084: iconst_0
    //   1085: istore 17
    //   1087: goto -983 -> 104
    //   1090: invokestatic 1057	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1093: invokestatic 1163	com/tencent/mm/sdk/platformtools/NetStatusUtil:is2G	(Landroid/content/Context;)Z
    //   1096: ifeq +22 -> 1118
    //   1099: invokestatic 1069	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   1102: ldc_w 1084
    //   1105: invokevirtual 1076	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1108: bipush 70
    //   1110: invokestatic 1080	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   1113: istore 7
    //   1115: goto -912 -> 203
    //   1118: invokestatic 1057	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1121: invokestatic 1166	com/tencent/mm/sdk/platformtools/NetStatusUtil:is3G	(Landroid/content/Context;)Z
    //   1124: ifeq +22 -> 1146
    //   1127: invokestatic 1069	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   1130: ldc_w 1086
    //   1133: invokevirtual 1076	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1136: bipush 60
    //   1138: invokestatic 1080	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   1141: istore 7
    //   1143: goto -940 -> 203
    //   1146: invokestatic 1069	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   1149: ldc_w 1088
    //   1152: invokevirtual 1076	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1155: bipush 60
    //   1157: invokestatic 1080	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   1160: istore 7
    //   1162: goto -959 -> 203
    //   1165: invokestatic 1057	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1168: invokestatic 1063	com/tencent/mm/sdk/platformtools/NetStatusUtil:isWifi	(Landroid/content/Context;)Z
    //   1171: ifeq +23 -> 1194
    //   1174: invokestatic 1069	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   1177: ldc_w 1090
    //   1180: invokevirtual 1076	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1183: invokestatic 1124	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1186: invokevirtual 1127	java/lang/Integer:intValue	()I
    //   1189: istore 7
    //   1191: goto -988 -> 203
    //   1194: invokestatic 1057	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1197: invokestatic 1163	com/tencent/mm/sdk/platformtools/NetStatusUtil:is2G	(Landroid/content/Context;)Z
    //   1200: ifeq +23 -> 1223
    //   1203: invokestatic 1069	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   1206: ldc_w 1092
    //   1209: invokevirtual 1076	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1212: invokestatic 1124	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1215: invokevirtual 1127	java/lang/Integer:intValue	()I
    //   1218: istore 7
    //   1220: goto -1017 -> 203
    //   1223: invokestatic 1069	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   1226: ldc_w 1094
    //   1229: invokevirtual 1076	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1232: invokestatic 1124	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1235: invokevirtual 1127	java/lang/Integer:intValue	()I
    //   1238: istore 7
    //   1240: goto -1037 -> 203
    //   1243: iload 11
    //   1245: istore 7
    //   1247: invokestatic 1057	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1250: invokestatic 1063	com/tencent/mm/sdk/platformtools/NetStatusUtil:isWifi	(Landroid/content/Context;)Z
    //   1253: ifeq +73 -> 1326
    //   1256: iload 11
    //   1258: istore 7
    //   1260: invokestatic 1069	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   1263: ldc_w 1168
    //   1266: invokevirtual 1076	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1269: astore 21
    //   1271: iload 11
    //   1273: istore 7
    //   1275: aload 21
    //   1277: ldc_w 1117
    //   1280: invokevirtual 1121	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1283: iconst_0
    //   1284: aaload
    //   1285: invokestatic 1124	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1288: invokevirtual 1127	java/lang/Integer:intValue	()I
    //   1291: istore 11
    //   1293: iload 11
    //   1295: istore 7
    //   1297: aload 21
    //   1299: ldc_w 1117
    //   1302: invokevirtual 1121	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1305: iconst_1
    //   1306: aaload
    //   1307: invokestatic 1124	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1310: invokevirtual 1127	java/lang/Integer:intValue	()I
    //   1313: istore 12
    //   1315: iload 12
    //   1317: istore 8
    //   1319: iload 11
    //   1321: istore 7
    //   1323: goto -811 -> 512
    //   1326: iload 11
    //   1328: istore 7
    //   1330: invokestatic 1057	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1333: invokestatic 1163	com/tencent/mm/sdk/platformtools/NetStatusUtil:is2G	(Landroid/content/Context;)Z
    //   1336: ifeq +73 -> 1409
    //   1339: iload 11
    //   1341: istore 7
    //   1343: invokestatic 1069	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   1346: ldc_w 1170
    //   1349: invokevirtual 1076	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1352: astore 21
    //   1354: iload 11
    //   1356: istore 7
    //   1358: aload 21
    //   1360: ldc_w 1117
    //   1363: invokevirtual 1121	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1366: iconst_0
    //   1367: aaload
    //   1368: invokestatic 1124	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1371: invokevirtual 1127	java/lang/Integer:intValue	()I
    //   1374: istore 11
    //   1376: iload 11
    //   1378: istore 7
    //   1380: aload 21
    //   1382: ldc_w 1117
    //   1385: invokevirtual 1121	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1388: iconst_1
    //   1389: aaload
    //   1390: invokestatic 1124	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1393: invokevirtual 1127	java/lang/Integer:intValue	()I
    //   1396: istore 12
    //   1398: iload 12
    //   1400: istore 8
    //   1402: iload 11
    //   1404: istore 7
    //   1406: goto -894 -> 512
    //   1409: iload 11
    //   1411: istore 7
    //   1413: invokestatic 1057	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1416: invokestatic 1166	com/tencent/mm/sdk/platformtools/NetStatusUtil:is3G	(Landroid/content/Context;)Z
    //   1419: ifeq +73 -> 1492
    //   1422: iload 11
    //   1424: istore 7
    //   1426: invokestatic 1069	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   1429: ldc_w 1172
    //   1432: invokevirtual 1076	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1435: astore 21
    //   1437: iload 11
    //   1439: istore 7
    //   1441: aload 21
    //   1443: ldc_w 1117
    //   1446: invokevirtual 1121	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1449: iconst_0
    //   1450: aaload
    //   1451: invokestatic 1124	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1454: invokevirtual 1127	java/lang/Integer:intValue	()I
    //   1457: istore 11
    //   1459: iload 11
    //   1461: istore 7
    //   1463: aload 21
    //   1465: ldc_w 1117
    //   1468: invokevirtual 1121	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1471: iconst_1
    //   1472: aaload
    //   1473: invokestatic 1124	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1476: invokevirtual 1127	java/lang/Integer:intValue	()I
    //   1479: istore 12
    //   1481: iload 12
    //   1483: istore 8
    //   1485: iload 11
    //   1487: istore 7
    //   1489: goto -977 -> 512
    //   1492: iload 11
    //   1494: istore 7
    //   1496: invokestatic 1069	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   1499: ldc_w 1174
    //   1502: invokevirtual 1076	com/tencent/mm/n/f:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1505: astore 21
    //   1507: iload 11
    //   1509: istore 7
    //   1511: aload 21
    //   1513: ldc_w 1117
    //   1516: invokevirtual 1121	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1519: iconst_0
    //   1520: aaload
    //   1521: invokestatic 1124	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1524: invokevirtual 1127	java/lang/Integer:intValue	()I
    //   1527: istore 11
    //   1529: iload 11
    //   1531: istore 7
    //   1533: aload 21
    //   1535: ldc_w 1117
    //   1538: invokevirtual 1121	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1541: iconst_1
    //   1542: aaload
    //   1543: invokestatic 1124	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1546: invokevirtual 1127	java/lang/Integer:intValue	()I
    //   1549: istore 12
    //   1551: iload 12
    //   1553: istore 8
    //   1555: iload 11
    //   1557: istore 7
    //   1559: goto -1047 -> 512
    //   1562: iload 8
    //   1564: sipush 2160
    //   1567: if_icmplt +14 -> 1581
    //   1570: iconst_0
    //   1571: istore 7
    //   1573: sipush 1080
    //   1576: istore 8
    //   1578: goto -986 -> 592
    //   1581: iload 8
    //   1583: ifgt +2348 -> 3931
    //   1586: iload 7
    //   1588: sipush 3240
    //   1591: if_icmple +2340 -> 3931
    //   1594: sipush 1620
    //   1597: istore 7
    //   1599: iconst_0
    //   1600: istore 8
    //   1602: goto -1010 -> 592
    //   1605: astore 21
    //   1607: ldc 65
    //   1609: new 97	java/lang/StringBuilder
    //   1612: dup
    //   1613: ldc_w 1176
    //   1616: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1619: aload 21
    //   1621: invokevirtual 973	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1624: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1627: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1630: invokestatic 556	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1633: iconst_0
    //   1634: istore 11
    //   1636: goto -906 -> 730
    //   1639: aload_1
    //   1640: invokestatic 762	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$ExifHelper:getExifOrientation	(Ljava/lang/String;)I
    //   1643: istore 11
    //   1645: goto -915 -> 730
    //   1648: iconst_0
    //   1649: istore_3
    //   1650: goto -631 -> 1019
    //   1653: ldc 65
    //   1655: ldc_w 1178
    //   1658: iload 15
    //   1660: invokestatic 345	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1663: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1666: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1669: aload_1
    //   1670: new 97	java/lang/StringBuilder
    //   1673: dup
    //   1674: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1677: aload_0
    //   1678: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1681: aload_2
    //   1682: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1685: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1688: invokestatic 523	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   1691: lconst_0
    //   1692: lcmp
    //   1693: iflt +11 -> 1704
    //   1696: ldc_w 1031
    //   1699: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1702: iconst_1
    //   1703: ireturn
    //   1704: ldc_w 1031
    //   1707: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1710: iconst_0
    //   1711: ireturn
    //   1712: new 581	android/graphics/BitmapFactory$Options
    //   1715: dup
    //   1716: invokespecial 582	android/graphics/BitmapFactory$Options:<init>	()V
    //   1719: astore 24
    //   1721: aload 24
    //   1723: invokestatic 1182	com/tencent/mm/sdk/platformtools/BitmapUtil:bindlowMemeryOption	(Landroid/graphics/BitmapFactory$Options;)V
    //   1726: aconst_null
    //   1727: astore 21
    //   1729: aconst_null
    //   1730: astore 20
    //   1732: aload_1
    //   1733: invokestatic 590	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1736: astore 23
    //   1738: aload 23
    //   1740: astore 22
    //   1742: aload 23
    //   1744: astore 20
    //   1746: aload 23
    //   1748: astore 21
    //   1750: aload 23
    //   1752: invokevirtual 596	java/io/InputStream:markSupported	()Z
    //   1755: ifne +22 -> 1777
    //   1758: aload 23
    //   1760: astore 20
    //   1762: aload 23
    //   1764: astore 21
    //   1766: new 598	java/io/BufferedInputStream
    //   1769: dup
    //   1770: aload 23
    //   1772: invokespecial 601	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1775: astore 22
    //   1777: aload 22
    //   1779: astore 20
    //   1781: aload 22
    //   1783: astore 21
    //   1785: aload 22
    //   1787: ldc_w 602
    //   1790: invokevirtual 605	java/io/InputStream:mark	(I)V
    //   1793: aload 22
    //   1795: astore 20
    //   1797: aload 22
    //   1799: astore 21
    //   1801: aload 22
    //   1803: aconst_null
    //   1804: aload 24
    //   1806: invokestatic 833	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1809: astore 23
    //   1811: aload 22
    //   1813: astore 20
    //   1815: aload 22
    //   1817: astore 21
    //   1819: aload 22
    //   1821: invokevirtual 612	java/io/InputStream:reset	()V
    //   1824: aload 23
    //   1826: ifnonnull +21 -> 1847
    //   1829: aload 22
    //   1831: ifnull +8 -> 1839
    //   1834: aload 22
    //   1836: invokevirtual 630	java/io/InputStream:close	()V
    //   1839: ldc_w 1031
    //   1842: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1845: iconst_0
    //   1846: ireturn
    //   1847: iload 11
    //   1849: i2f
    //   1850: fstore 6
    //   1852: aload 22
    //   1854: astore 20
    //   1856: aload 22
    //   1858: astore 21
    //   1860: aload 23
    //   1862: fload 6
    //   1864: invokestatic 1001	com/tencent/mm/sdk/platformtools/BitmapUtil:rotate	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   1867: astore 23
    //   1869: aload 22
    //   1871: astore 20
    //   1873: aload 22
    //   1875: astore 21
    //   1877: invokestatic 783	com/tencent/mm/plugin/sns/storage/r:fSY	()Z
    //   1880: ifeq +396 -> 2276
    //   1883: iload_3
    //   1884: ifeq +392 -> 2276
    //   1887: aload 22
    //   1889: astore 20
    //   1891: aload 22
    //   1893: astore 21
    //   1895: aload 23
    //   1897: aload_1
    //   1898: new 97	java/lang/StringBuilder
    //   1901: dup
    //   1902: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1905: aload_0
    //   1906: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1909: aload_2
    //   1910: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1913: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1916: invokestatic 786	com/tencent/mm/plugin/sns/storage/r:b	(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;)Z
    //   1919: ifne +71 -> 1990
    //   1922: aload 22
    //   1924: astore 20
    //   1926: aload 22
    //   1928: astore 21
    //   1930: new 97	java/lang/StringBuilder
    //   1933: dup
    //   1934: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1937: aload_0
    //   1938: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1941: aload_2
    //   1942: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1945: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1948: invokestatic 532	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   1951: pop
    //   1952: aload 22
    //   1954: astore 20
    //   1956: aload 22
    //   1958: astore 21
    //   1960: aload 23
    //   1962: iload 9
    //   1964: getstatic 856	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1967: new 97	java/lang/StringBuilder
    //   1970: dup
    //   1971: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1974: aload_0
    //   1975: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1978: aload_2
    //   1979: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1982: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1985: iconst_1
    //   1986: invokestatic 968	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   1989: pop
    //   1990: aload 23
    //   1992: ifnull +32 -> 2024
    //   1995: aload 22
    //   1997: astore 20
    //   1999: aload 22
    //   2001: astore 21
    //   2003: aload 23
    //   2005: invokevirtual 1185	android/graphics/Bitmap:isRecycled	()Z
    //   2008: ifne +16 -> 2024
    //   2011: aload 22
    //   2013: astore 20
    //   2015: aload 22
    //   2017: astore 21
    //   2019: aload 23
    //   2021: invokevirtual 1188	android/graphics/Bitmap:recycle	()V
    //   2024: iload 16
    //   2026: ifeq +421 -> 2447
    //   2029: iload 11
    //   2031: ifne +416 -> 2447
    //   2034: aload 22
    //   2036: astore 20
    //   2038: aload 22
    //   2040: astore 21
    //   2042: new 97	java/lang/StringBuilder
    //   2045: dup
    //   2046: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2049: aload_0
    //   2050: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2053: aload_2
    //   2054: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2057: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2060: invokestatic 188	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   2063: lstore 18
    //   2065: aload 22
    //   2067: astore 20
    //   2069: aload 22
    //   2071: astore 21
    //   2073: ldc 65
    //   2075: ldc_w 1190
    //   2078: iconst_3
    //   2079: anewarray 69	java/lang/Object
    //   2082: dup
    //   2083: iconst_0
    //   2084: iload 14
    //   2086: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2089: aastore
    //   2090: dup
    //   2091: iconst_1
    //   2092: lload 18
    //   2094: invokestatic 813	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2097: aastore
    //   2098: dup
    //   2099: iconst_2
    //   2100: iload 12
    //   2102: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2105: aastore
    //   2106: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2109: iload 14
    //   2111: i2l
    //   2112: lload 18
    //   2114: lsub
    //   2115: ldc2_w 1191
    //   2118: lmul
    //   2119: iload 12
    //   2121: iload 14
    //   2123: imul
    //   2124: i2l
    //   2125: lcmp
    //   2126: ifge +303 -> 2429
    //   2129: aload 22
    //   2131: astore 20
    //   2133: aload 22
    //   2135: astore 21
    //   2137: new 97	java/lang/StringBuilder
    //   2140: dup
    //   2141: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2144: aload_0
    //   2145: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2148: aload_2
    //   2149: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2152: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2155: invokestatic 532	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   2158: pop
    //   2159: aload 22
    //   2161: astore 20
    //   2163: aload 22
    //   2165: astore 21
    //   2167: invokestatic 783	com/tencent/mm/plugin/sns/storage/r:fSY	()Z
    //   2170: ifeq +195 -> 2365
    //   2173: iload_3
    //   2174: ifeq +191 -> 2365
    //   2177: aload 22
    //   2179: astore 20
    //   2181: aload 22
    //   2183: astore 21
    //   2185: aload_1
    //   2186: new 97	java/lang/StringBuilder
    //   2189: dup
    //   2190: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2193: aload_0
    //   2194: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2197: aload_2
    //   2198: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2201: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2204: invokestatic 1158	com/tencent/mm/plugin/sns/storage/r:li	(Ljava/lang/String;Ljava/lang/String;)Z
    //   2207: istore 16
    //   2209: iload 16
    //   2211: istore_3
    //   2212: iload 16
    //   2214: ifne +44 -> 2258
    //   2217: aload 22
    //   2219: astore 20
    //   2221: aload 22
    //   2223: astore 21
    //   2225: aload_1
    //   2226: new 97	java/lang/StringBuilder
    //   2229: dup
    //   2230: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2233: aload_0
    //   2234: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2237: aload_2
    //   2238: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2241: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2244: invokestatic 523	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   2247: lstore 18
    //   2249: lload 18
    //   2251: lconst_0
    //   2252: lcmp
    //   2253: iflt +107 -> 2360
    //   2256: iconst_1
    //   2257: istore_3
    //   2258: aload 22
    //   2260: ifnull +8 -> 2268
    //   2263: aload 22
    //   2265: invokevirtual 630	java/io/InputStream:close	()V
    //   2268: ldc_w 1031
    //   2271: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2274: iload_3
    //   2275: ireturn
    //   2276: aload 22
    //   2278: astore 20
    //   2280: aload 22
    //   2282: astore 21
    //   2284: aload 23
    //   2286: iload 9
    //   2288: getstatic 856	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   2291: new 97	java/lang/StringBuilder
    //   2294: dup
    //   2295: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2298: aload_0
    //   2299: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2302: aload_2
    //   2303: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2306: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2309: iconst_1
    //   2310: invokestatic 968	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   2313: pop
    //   2314: goto -290 -> 2024
    //   2317: astore_0
    //   2318: aload 20
    //   2320: astore 21
    //   2322: ldc 65
    //   2324: aload_0
    //   2325: ldc_w 1194
    //   2328: aload_1
    //   2329: invokestatic 130	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2332: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2335: iconst_0
    //   2336: anewarray 69	java/lang/Object
    //   2339: invokestatic 551	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2342: aload 20
    //   2344: ifnull +8 -> 2352
    //   2347: aload 20
    //   2349: invokevirtual 630	java/io/InputStream:close	()V
    //   2352: ldc_w 1031
    //   2355: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2358: iconst_0
    //   2359: ireturn
    //   2360: iconst_0
    //   2361: istore_3
    //   2362: goto -104 -> 2258
    //   2365: aload 22
    //   2367: astore 20
    //   2369: aload 22
    //   2371: astore 21
    //   2373: aload_1
    //   2374: new 97	java/lang/StringBuilder
    //   2377: dup
    //   2378: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2381: aload_0
    //   2382: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2385: aload_2
    //   2386: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2389: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2392: invokestatic 523	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   2395: lstore 18
    //   2397: lload 18
    //   2399: lconst_0
    //   2400: lcmp
    //   2401: iflt +23 -> 2424
    //   2404: iconst_1
    //   2405: istore_3
    //   2406: aload 22
    //   2408: ifnull +8 -> 2416
    //   2411: aload 22
    //   2413: invokevirtual 630	java/io/InputStream:close	()V
    //   2416: ldc_w 1031
    //   2419: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2422: iload_3
    //   2423: ireturn
    //   2424: iconst_0
    //   2425: istore_3
    //   2426: goto -20 -> 2406
    //   2429: aload 22
    //   2431: ifnull +8 -> 2439
    //   2434: aload 22
    //   2436: invokevirtual 630	java/io/InputStream:close	()V
    //   2439: ldc_w 1031
    //   2442: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2445: iconst_1
    //   2446: ireturn
    //   2447: aload 22
    //   2449: ifnull +8 -> 2457
    //   2452: aload 22
    //   2454: invokevirtual 630	java/io/InputStream:close	()V
    //   2457: ldc_w 1031
    //   2460: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2463: iconst_1
    //   2464: ireturn
    //   2465: astore_0
    //   2466: aload 21
    //   2468: ifnull +8 -> 2476
    //   2471: aload 21
    //   2473: invokevirtual 630	java/io/InputStream:close	()V
    //   2476: ldc_w 1031
    //   2479: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2482: aload_0
    //   2483: athrow
    //   2484: ldc 65
    //   2486: new 97	java/lang/StringBuilder
    //   2489: dup
    //   2490: ldc_w 1196
    //   2493: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2496: aload 20
    //   2498: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   2501: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2504: ldc_w 1139
    //   2507: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2510: aload 20
    //   2512: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   2515: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2518: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2521: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2524: aload 20
    //   2526: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   2529: ifgt +9 -> 2538
    //   2532: aload 20
    //   2534: iconst_1
    //   2535: putfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   2538: aload 20
    //   2540: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   2543: ifgt +9 -> 2552
    //   2546: aload 20
    //   2548: iconst_1
    //   2549: putfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   2552: aload 20
    //   2554: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   2557: aload 20
    //   2559: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   2562: if_icmple +131 -> 2693
    //   2565: aload 20
    //   2567: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   2570: aload 20
    //   2572: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   2575: idiv
    //   2576: istore 7
    //   2578: iload 7
    //   2580: istore 8
    //   2582: iload 7
    //   2584: ifne +6 -> 2590
    //   2587: iconst_1
    //   2588: istore 8
    //   2590: ldc_w 738
    //   2593: iload 8
    //   2595: idiv
    //   2596: i2d
    //   2597: invokestatic 1199	java/lang/Math:sqrt	(D)D
    //   2600: d2i
    //   2601: istore 7
    //   2603: aload 20
    //   2605: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   2608: aload 20
    //   2610: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   2613: if_icmple +96 -> 2709
    //   2616: iload 7
    //   2618: iload 8
    //   2620: imul
    //   2621: istore 10
    //   2623: ldc 65
    //   2625: new 97	java/lang/StringBuilder
    //   2628: dup
    //   2629: ldc_w 1201
    //   2632: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2635: iload 10
    //   2637: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2640: ldc_w 1139
    //   2643: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2646: iload 7
    //   2648: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2651: ldc_w 1139
    //   2654: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2657: iload 8
    //   2659: invokevirtual 297	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2662: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2665: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2668: aload_1
    //   2669: iload 7
    //   2671: iload 10
    //   2673: getstatic 856	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   2676: iload 9
    //   2678: aload_0
    //   2679: aload_2
    //   2680: iload_3
    //   2681: invokestatic 1203	com/tencent/mm/plugin/sns/storage/r:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   2684: istore_3
    //   2685: ldc_w 1031
    //   2688: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2691: iload_3
    //   2692: ireturn
    //   2693: aload 20
    //   2695: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   2698: aload 20
    //   2700: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   2703: idiv
    //   2704: istore 7
    //   2706: goto -128 -> 2578
    //   2709: iload 7
    //   2711: iload 8
    //   2713: imul
    //   2714: istore 11
    //   2716: iload 7
    //   2718: istore 10
    //   2720: iload 11
    //   2722: istore 7
    //   2724: goto -101 -> 2623
    //   2727: iload 14
    //   2729: iload 13
    //   2731: if_icmpge +178 -> 2909
    //   2734: iload 16
    //   2736: ifeq +173 -> 2909
    //   2739: iload 11
    //   2741: ifne +168 -> 2909
    //   2744: ldc 65
    //   2746: ldc_w 1205
    //   2749: iload 13
    //   2751: invokestatic 345	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2754: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2757: invokestatic 141	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2760: invokestatic 783	com/tencent/mm/plugin/sns/storage/r:fSY	()Z
    //   2763: ifeq +103 -> 2866
    //   2766: iload_3
    //   2767: ifeq +99 -> 2866
    //   2770: aload_1
    //   2771: new 97	java/lang/StringBuilder
    //   2774: dup
    //   2775: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2778: aload_0
    //   2779: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2782: aload_2
    //   2783: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2786: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2789: invokestatic 1158	com/tencent/mm/plugin/sns/storage/r:li	(Ljava/lang/String;Ljava/lang/String;)Z
    //   2792: istore 16
    //   2794: iload 16
    //   2796: istore_3
    //   2797: iload 16
    //   2799: ifne +54 -> 2853
    //   2802: new 97	java/lang/StringBuilder
    //   2805: dup
    //   2806: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2809: aload_0
    //   2810: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2813: aload_2
    //   2814: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2817: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2820: invokestatic 532	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   2823: pop
    //   2824: aload_1
    //   2825: new 97	java/lang/StringBuilder
    //   2828: dup
    //   2829: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2832: aload_0
    //   2833: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2836: aload_2
    //   2837: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2840: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2843: invokestatic 523	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   2846: lconst_0
    //   2847: lcmp
    //   2848: iflt +13 -> 2861
    //   2851: iconst_1
    //   2852: istore_3
    //   2853: ldc_w 1031
    //   2856: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2859: iload_3
    //   2860: ireturn
    //   2861: iconst_0
    //   2862: istore_3
    //   2863: goto -10 -> 2853
    //   2866: aload_1
    //   2867: new 97	java/lang/StringBuilder
    //   2870: dup
    //   2871: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2874: aload_0
    //   2875: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2878: aload_2
    //   2879: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2882: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2885: invokestatic 523	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   2888: lconst_0
    //   2889: lcmp
    //   2890: iflt +11 -> 2901
    //   2893: ldc_w 1031
    //   2896: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2899: iconst_1
    //   2900: ireturn
    //   2901: ldc_w 1031
    //   2904: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2907: iconst_0
    //   2908: ireturn
    //   2909: aload 20
    //   2911: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   2914: aload 20
    //   2916: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   2919: if_icmple +229 -> 3148
    //   2922: aload 20
    //   2924: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   2927: istore 10
    //   2929: aload 20
    //   2931: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   2934: aload 20
    //   2936: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   2939: if_icmpge +219 -> 3158
    //   2942: aload 20
    //   2944: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   2947: istore 13
    //   2949: iload 8
    //   2951: ifle +10 -> 2961
    //   2954: iload 13
    //   2956: iload 8
    //   2958: if_icmple +15 -> 2973
    //   2961: iload 8
    //   2963: ifgt +586 -> 3549
    //   2966: iload 10
    //   2968: iload 7
    //   2970: if_icmpgt +579 -> 3549
    //   2973: ldc 65
    //   2975: ldc_w 1207
    //   2978: iconst_3
    //   2979: anewarray 69	java/lang/Object
    //   2982: dup
    //   2983: iconst_0
    //   2984: iload 14
    //   2986: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2989: aastore
    //   2990: dup
    //   2991: iconst_1
    //   2992: aload 20
    //   2994: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   2997: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3000: aastore
    //   3001: dup
    //   3002: iconst_2
    //   3003: aload 20
    //   3005: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   3008: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3011: aastore
    //   3012: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3015: aload_1
    //   3016: invokestatic 188	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   3019: ldc2_w 1208
    //   3022: lcmp
    //   3023: ifge +246 -> 3269
    //   3026: iload 16
    //   3028: ifeq +188 -> 3216
    //   3031: ldc 65
    //   3033: ldc_w 1211
    //   3036: iconst_1
    //   3037: anewarray 69	java/lang/Object
    //   3040: dup
    //   3041: iconst_0
    //   3042: aload_1
    //   3043: aastore
    //   3044: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3047: invokestatic 783	com/tencent/mm/plugin/sns/storage/r:fSY	()Z
    //   3050: ifeq +123 -> 3173
    //   3053: iload_3
    //   3054: ifeq +119 -> 3173
    //   3057: aload_1
    //   3058: new 97	java/lang/StringBuilder
    //   3061: dup
    //   3062: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3065: aload_0
    //   3066: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3069: aload_2
    //   3070: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3073: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3076: invokestatic 1158	com/tencent/mm/plugin/sns/storage/r:li	(Ljava/lang/String;Ljava/lang/String;)Z
    //   3079: istore 16
    //   3081: iload 16
    //   3083: istore_3
    //   3084: iload 16
    //   3086: ifne +54 -> 3140
    //   3089: new 97	java/lang/StringBuilder
    //   3092: dup
    //   3093: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3096: aload_0
    //   3097: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3100: aload_2
    //   3101: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3104: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3107: invokestatic 532	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   3110: pop
    //   3111: aload_1
    //   3112: new 97	java/lang/StringBuilder
    //   3115: dup
    //   3116: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3119: aload_0
    //   3120: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3123: aload_2
    //   3124: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3127: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3130: invokestatic 523	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   3133: lconst_0
    //   3134: lcmp
    //   3135: iflt +33 -> 3168
    //   3138: iconst_1
    //   3139: istore_3
    //   3140: ldc_w 1031
    //   3143: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3146: iload_3
    //   3147: ireturn
    //   3148: aload 20
    //   3150: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   3153: istore 10
    //   3155: goto -226 -> 2929
    //   3158: aload 20
    //   3160: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   3163: istore 13
    //   3165: goto -216 -> 2949
    //   3168: iconst_0
    //   3169: istore_3
    //   3170: goto -30 -> 3140
    //   3173: aload_1
    //   3174: new 97	java/lang/StringBuilder
    //   3177: dup
    //   3178: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3181: aload_0
    //   3182: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3185: aload_2
    //   3186: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3189: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3192: invokestatic 523	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   3195: lconst_0
    //   3196: lcmp
    //   3197: iflt +11 -> 3208
    //   3200: ldc_w 1031
    //   3203: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3206: iconst_1
    //   3207: ireturn
    //   3208: ldc_w 1031
    //   3211: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3214: iconst_0
    //   3215: ireturn
    //   3216: aload 20
    //   3218: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   3221: sipush 150
    //   3224: if_icmpge +45 -> 3269
    //   3227: aload 20
    //   3229: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   3232: sipush 150
    //   3235: if_icmpge +34 -> 3269
    //   3238: aload_1
    //   3239: aload 20
    //   3241: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   3244: aload 20
    //   3246: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   3249: getstatic 851	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   3252: iload 9
    //   3254: aload_0
    //   3255: aload_2
    //   3256: iload_3
    //   3257: invokestatic 1203	com/tencent/mm/plugin/sns/storage/r:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   3260: istore_3
    //   3261: ldc_w 1031
    //   3264: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3267: iload_3
    //   3268: ireturn
    //   3269: aload_1
    //   3270: aload 20
    //   3272: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   3275: aload 20
    //   3277: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   3280: getstatic 856	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   3283: iload 9
    //   3285: aload_0
    //   3286: aload_2
    //   3287: iload_3
    //   3288: invokestatic 1203	com/tencent/mm/plugin/sns/storage/r:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   3291: istore 17
    //   3293: iload 16
    //   3295: ifeq +245 -> 3540
    //   3298: iload 11
    //   3300: ifne +240 -> 3540
    //   3303: new 97	java/lang/StringBuilder
    //   3306: dup
    //   3307: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3310: aload_0
    //   3311: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3314: aload_2
    //   3315: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3318: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3321: invokestatic 188	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   3324: lstore 18
    //   3326: ldc 65
    //   3328: ldc_w 1190
    //   3331: iconst_3
    //   3332: anewarray 69	java/lang/Object
    //   3335: dup
    //   3336: iconst_0
    //   3337: iload 14
    //   3339: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3342: aastore
    //   3343: dup
    //   3344: iconst_1
    //   3345: lload 18
    //   3347: invokestatic 813	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3350: aastore
    //   3351: dup
    //   3352: iconst_2
    //   3353: iload 12
    //   3355: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3358: aastore
    //   3359: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3362: iload 14
    //   3364: i2l
    //   3365: lload 18
    //   3367: lsub
    //   3368: ldc2_w 1191
    //   3371: lmul
    //   3372: iload 12
    //   3374: iload 14
    //   3376: imul
    //   3377: i2l
    //   3378: lcmp
    //   3379: ifge +152 -> 3531
    //   3382: new 97	java/lang/StringBuilder
    //   3385: dup
    //   3386: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3389: aload_0
    //   3390: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3393: aload_2
    //   3394: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3397: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3400: invokestatic 532	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   3403: pop
    //   3404: invokestatic 783	com/tencent/mm/plugin/sns/storage/r:fSY	()Z
    //   3407: ifeq +81 -> 3488
    //   3410: iload_3
    //   3411: ifeq +77 -> 3488
    //   3414: aload_1
    //   3415: new 97	java/lang/StringBuilder
    //   3418: dup
    //   3419: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3422: aload_0
    //   3423: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3426: aload_2
    //   3427: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3430: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3433: invokestatic 1158	com/tencent/mm/plugin/sns/storage/r:li	(Ljava/lang/String;Ljava/lang/String;)Z
    //   3436: istore 16
    //   3438: iload 16
    //   3440: istore_3
    //   3441: iload 16
    //   3443: ifne +32 -> 3475
    //   3446: aload_1
    //   3447: new 97	java/lang/StringBuilder
    //   3450: dup
    //   3451: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3454: aload_0
    //   3455: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3458: aload_2
    //   3459: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3462: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3465: invokestatic 523	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   3468: lconst_0
    //   3469: lcmp
    //   3470: iflt +13 -> 3483
    //   3473: iconst_1
    //   3474: istore_3
    //   3475: ldc_w 1031
    //   3478: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3481: iload_3
    //   3482: ireturn
    //   3483: iconst_0
    //   3484: istore_3
    //   3485: goto -10 -> 3475
    //   3488: aload_1
    //   3489: new 97	java/lang/StringBuilder
    //   3492: dup
    //   3493: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3496: aload_0
    //   3497: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3500: aload_2
    //   3501: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3504: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3507: invokestatic 523	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   3510: lconst_0
    //   3511: lcmp
    //   3512: iflt +11 -> 3523
    //   3515: ldc_w 1031
    //   3518: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3521: iconst_1
    //   3522: ireturn
    //   3523: ldc_w 1031
    //   3526: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3529: iconst_0
    //   3530: ireturn
    //   3531: ldc_w 1031
    //   3534: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3537: iload 17
    //   3539: ireturn
    //   3540: ldc_w 1031
    //   3543: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3546: iload 17
    //   3548: ireturn
    //   3549: iload 8
    //   3551: ifle +221 -> 3772
    //   3554: aload 20
    //   3556: aload_1
    //   3557: aload 20
    //   3559: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   3562: aload 20
    //   3564: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   3567: iload 8
    //   3569: getstatic 856	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   3572: iload 9
    //   3574: aload_0
    //   3575: aload_2
    //   3576: iload_3
    //   3577: invokestatic 1213	com/tencent/mm/plugin/sns/storage/r:a	(Landroid/graphics/BitmapFactory$Options;Ljava/lang/String;IIILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   3580: istore 17
    //   3582: iload 16
    //   3584: ifeq +288 -> 3872
    //   3587: iload 11
    //   3589: ifne +283 -> 3872
    //   3592: new 97	java/lang/StringBuilder
    //   3595: dup
    //   3596: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3599: aload_0
    //   3600: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3603: aload_2
    //   3604: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3607: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3610: invokestatic 188	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   3613: lstore 18
    //   3615: ldc 65
    //   3617: ldc_w 1190
    //   3620: iconst_3
    //   3621: anewarray 69	java/lang/Object
    //   3624: dup
    //   3625: iconst_0
    //   3626: iload 14
    //   3628: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3631: aastore
    //   3632: dup
    //   3633: iconst_1
    //   3634: lload 18
    //   3636: invokestatic 813	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3639: aastore
    //   3640: dup
    //   3641: iconst_2
    //   3642: iload 12
    //   3644: invokestatic 503	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3647: aastore
    //   3648: invokestatic 74	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3651: iload 14
    //   3653: i2l
    //   3654: lload 18
    //   3656: lsub
    //   3657: ldc2_w 1191
    //   3660: lmul
    //   3661: iload 12
    //   3663: iload 14
    //   3665: imul
    //   3666: i2l
    //   3667: lcmp
    //   3668: ifge +204 -> 3872
    //   3671: new 97	java/lang/StringBuilder
    //   3674: dup
    //   3675: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3678: aload_0
    //   3679: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3682: aload_2
    //   3683: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3686: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3689: invokestatic 532	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   3692: pop
    //   3693: invokestatic 783	com/tencent/mm/plugin/sns/storage/r:fSY	()Z
    //   3696: ifeq +133 -> 3829
    //   3699: iload_3
    //   3700: ifeq +129 -> 3829
    //   3703: aload_1
    //   3704: new 97	java/lang/StringBuilder
    //   3707: dup
    //   3708: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3711: aload_0
    //   3712: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3715: aload_2
    //   3716: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3719: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3722: invokestatic 1158	com/tencent/mm/plugin/sns/storage/r:li	(Ljava/lang/String;Ljava/lang/String;)Z
    //   3725: istore 16
    //   3727: iload 16
    //   3729: istore_3
    //   3730: iload 16
    //   3732: ifne +32 -> 3764
    //   3735: aload_1
    //   3736: new 97	java/lang/StringBuilder
    //   3739: dup
    //   3740: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3743: aload_0
    //   3744: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3747: aload_2
    //   3748: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3751: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3754: invokestatic 523	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   3757: lconst_0
    //   3758: lcmp
    //   3759: iflt +65 -> 3824
    //   3762: iconst_1
    //   3763: istore_3
    //   3764: ldc_w 1031
    //   3767: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3770: iload_3
    //   3771: ireturn
    //   3772: iload 10
    //   3774: i2d
    //   3775: dconst_1
    //   3776: dmul
    //   3777: iload 7
    //   3779: i2d
    //   3780: ddiv
    //   3781: dstore 4
    //   3783: aload 20
    //   3785: getfield 624	android/graphics/BitmapFactory$Options:outWidth	I
    //   3788: i2d
    //   3789: dload 4
    //   3791: ddiv
    //   3792: d2i
    //   3793: istore 7
    //   3795: aload_1
    //   3796: aload 20
    //   3798: getfield 627	android/graphics/BitmapFactory$Options:outHeight	I
    //   3801: i2d
    //   3802: dload 4
    //   3804: ddiv
    //   3805: d2i
    //   3806: iload 7
    //   3808: getstatic 856	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   3811: iload 9
    //   3813: aload_0
    //   3814: aload_2
    //   3815: iload_3
    //   3816: invokestatic 1203	com/tencent/mm/plugin/sns/storage/r:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   3819: istore 17
    //   3821: goto -239 -> 3582
    //   3824: iconst_0
    //   3825: istore_3
    //   3826: goto -62 -> 3764
    //   3829: aload_1
    //   3830: new 97	java/lang/StringBuilder
    //   3833: dup
    //   3834: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3837: aload_0
    //   3838: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3841: aload_2
    //   3842: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3845: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3848: invokestatic 523	com/tencent/mm/vfs/u:on	(Ljava/lang/String;Ljava/lang/String;)J
    //   3851: lconst_0
    //   3852: lcmp
    //   3853: iflt +11 -> 3864
    //   3856: ldc_w 1031
    //   3859: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3862: iconst_1
    //   3863: ireturn
    //   3864: ldc_w 1031
    //   3867: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3870: iconst_0
    //   3871: ireturn
    //   3872: ldc_w 1031
    //   3875: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3878: iload 17
    //   3880: ireturn
    //   3881: astore_0
    //   3882: goto -2043 -> 1839
    //   3885: astore_0
    //   3886: goto -1618 -> 2268
    //   3889: astore_0
    //   3890: goto -1474 -> 2416
    //   3893: astore_0
    //   3894: goto -1455 -> 2439
    //   3897: astore_0
    //   3898: goto -1441 -> 2457
    //   3901: astore_0
    //   3902: goto -1550 -> 2352
    //   3905: astore_1
    //   3906: goto -1430 -> 2476
    //   3909: astore 21
    //   3911: goto -3399 -> 512
    //   3914: astore 21
    //   3916: bipush 100
    //   3918: istore 7
    //   3920: goto -3619 -> 301
    //   3923: astore 21
    //   3925: goto -3624 -> 301
    //   3928: goto -3228 -> 700
    //   3931: goto -3339 -> 592
    //   3934: iload 8
    //   3936: istore 10
    //   3938: iload 7
    //   3940: istore 9
    //   3942: goto -3555 -> 387
    //   3945: goto -3599 -> 346
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3948	0	paramString1	String
    //   0	3948	1	paramString2	String
    //   0	3948	2	paramString3	String
    //   0	3948	3	paramBoolean	boolean
    //   3781	22	4	d	double
    //   1850	13	6	f	float
    //   201	3738	7	i	int
    //   134	3801	8	j	int
    //   138	3803	9	k	int
    //   142	3795	10	m	int
    //   437	3151	11	n	int
    //   502	3164	12	i1	int
    //   627	2537	13	i2	int
    //   392	3274	14	i3	int
    //   666	993	15	i4	int
    //   64	3667	16	bool1	boolean
    //   102	3777	17	bool2	boolean
    //   2063	1592	18	l	long
    //   10	3787	20	localObject1	Object
    //   22	1512	21	localObject2	Object
    //   1605	15	21	localException1	Exception
    //   1727	745	21	localObject3	Object
    //   3909	1	21	localException2	Exception
    //   3914	1	21	localException3	Exception
    //   3923	1	21	localException4	Exception
    //   1740	713	22	localObject4	Object
    //   1736	549	23	localObject5	Object
    //   1719	86	24	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   708	714	1605	java/lang/Exception
    //   719	730	1605	java/lang/Exception
    //   1732	1738	2317	java/io/IOException
    //   1750	1758	2317	java/io/IOException
    //   1766	1777	2317	java/io/IOException
    //   1785	1793	2317	java/io/IOException
    //   1801	1811	2317	java/io/IOException
    //   1819	1824	2317	java/io/IOException
    //   1860	1869	2317	java/io/IOException
    //   1877	1883	2317	java/io/IOException
    //   1895	1922	2317	java/io/IOException
    //   1930	1952	2317	java/io/IOException
    //   1960	1990	2317	java/io/IOException
    //   2003	2011	2317	java/io/IOException
    //   2019	2024	2317	java/io/IOException
    //   2042	2065	2317	java/io/IOException
    //   2073	2109	2317	java/io/IOException
    //   2137	2159	2317	java/io/IOException
    //   2167	2173	2317	java/io/IOException
    //   2185	2209	2317	java/io/IOException
    //   2225	2249	2317	java/io/IOException
    //   2284	2314	2317	java/io/IOException
    //   2373	2397	2317	java/io/IOException
    //   1732	1738	2465	finally
    //   1750	1758	2465	finally
    //   1766	1777	2465	finally
    //   1785	1793	2465	finally
    //   1801	1811	2465	finally
    //   1819	1824	2465	finally
    //   1860	1869	2465	finally
    //   1877	1883	2465	finally
    //   1895	1922	2465	finally
    //   1930	1952	2465	finally
    //   1960	1990	2465	finally
    //   2003	2011	2465	finally
    //   2019	2024	2465	finally
    //   2042	2065	2465	finally
    //   2073	2109	2465	finally
    //   2137	2159	2465	finally
    //   2167	2173	2465	finally
    //   2185	2209	2465	finally
    //   2225	2249	2465	finally
    //   2284	2314	2465	finally
    //   2322	2342	2465	finally
    //   2373	2397	2465	finally
    //   1834	1839	3881	java/io/IOException
    //   2263	2268	3885	java/io/IOException
    //   2411	2416	3889	java/io/IOException
    //   2434	2439	3893	java/io/IOException
    //   2452	2457	3897	java/io/IOException
    //   2347	2352	3901	java/io/IOException
    //   2471	2476	3905	java/io/IOException
    //   449	460	3909	java/lang/Exception
    //   464	482	3909	java/lang/Exception
    //   486	504	3909	java/lang/Exception
    //   1247	1256	3909	java/lang/Exception
    //   1260	1271	3909	java/lang/Exception
    //   1275	1293	3909	java/lang/Exception
    //   1297	1315	3909	java/lang/Exception
    //   1330	1339	3909	java/lang/Exception
    //   1343	1354	3909	java/lang/Exception
    //   1358	1376	3909	java/lang/Exception
    //   1380	1398	3909	java/lang/Exception
    //   1413	1422	3909	java/lang/Exception
    //   1426	1437	3909	java/lang/Exception
    //   1441	1459	3909	java/lang/Exception
    //   1463	1481	3909	java/lang/Exception
    //   1496	1507	3909	java/lang/Exception
    //   1511	1529	3909	java/lang/Exception
    //   1533	1551	3909	java/lang/Exception
    //   148	178	3914	java/lang/Exception
    //   178	203	3914	java/lang/Exception
    //   1090	1115	3914	java/lang/Exception
    //   1118	1143	3914	java/lang/Exception
    //   1146	1162	3914	java/lang/Exception
    //   1165	1191	3914	java/lang/Exception
    //   1194	1220	3914	java/lang/Exception
    //   1223	1240	3914	java/lang/Exception
    //   203	301	3923	java/lang/Exception
  }
  
  public static void jR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97597);
    JER = paramInt1;
    APq = paramInt2;
    Log.i("MicroMsg.snsMediaStorage", "SCREEN %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(97597);
  }
  
  private static boolean li(String paramString1, String paramString2)
  {
    AppMethodBeat.i(254752);
    try
    {
      Bitmap localBitmap = com.tencent.mm.plugin.sns.d.a.l(paramString1, 0.0F);
      byte[] arrayOfByte = ay(localBitmap);
      localBitmap.recycle();
      com.tencent.mm.plugin.emoji.g.cTr();
      if (com.tencent.mm.plugin.emoji.g.a(arrayOfByte, paramString1, paramString2, localBitmap.getWidth(), localBitmap.getHeight(), localBitmap.getWidth(), localBitmap.getHeight()) == 0)
      {
        AppMethodBeat.o(254752);
        return true;
      }
      AppMethodBeat.o(254752);
      return false;
    }
    catch (OutOfMemoryError paramString2)
    {
      Log.w("MicroMsg.snsMediaStorage", "convertImg2WxamWithoutZip origPath:%s OutOfMemoryError! rollback", new Object[] { paramString1 });
      AppMethodBeat.o(254752);
    }
    return false;
  }
  
  public final q Re(long paramLong)
  {
    AppMethodBeat.i(97604);
    q localq = new q();
    Cursor localCursor = this.lvy.query("SnsMedia", null, "local_id=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(97604);
      return null;
    }
    localq.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(97604);
    return localq;
  }
  
  public final int a(int paramInt, q paramq)
  {
    AppMethodBeat.i(97602);
    paramq = paramq.fST();
    paramInt = this.lvy.update("SnsMedia", paramq, "local_id=?", new String[] { String.valueOf(paramInt) });
    AppMethodBeat.o(97602);
    return paramInt;
  }
  
  public final s a(s params, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(97608);
    q localq = new q();
    localq.createTime = ((int)Util.nowSecond());
    localq.type = params.type;
    cvw localcvw = new cvw();
    localcvw.Privated = params.JRw;
    localcvw.TEb = params.JRv;
    localcvw.token = params.JRx;
    localcvw.TEk = params.JRy;
    localcvw.TEy = 0;
    localcvw.TEx = new cvo();
    localcvw.kQn = 0;
    localcvw.CMB = params.desc;
    Log.d("MicroMsg.snsMediaStorage", "upload.filterId " + params.JRu);
    localcvw.TEa = params.JRu;
    localcvw.TAg = 2;
    localcvw.videoPath = paramString1;
    localcvw.TEB = paramString2;
    localcvw.md5 = params.JRz;
    for (;;)
    {
      try
      {
        localq.KAa = localcvw.toByteArray();
        localq.fSU();
        i = (int)this.lvy.insert("SnsMedia", "local_id", localq.fST());
        str1 = "Locall_path".concat(String.valueOf(i));
        Log.d("MicroMsg.snsMediaStorage", "insert localId ".concat(String.valueOf(i)));
        String str2 = t.aZf(str1);
        String str3 = t.aZg(str1);
        String str4 = t.aZe(str1);
        String str5 = t.aZh(str1);
        String str6 = bbD(str1);
        u.bBD(str6);
        u.on(paramString2, str6 + str2);
        u.on(paramString2, str6 + str3);
        u.on(paramString2, str6 + str4);
        u.on(paramString1, str6 + str5);
        localcvw.videoPath = (str6 + str5);
        localcvw.TEB = (str6 + str3);
        localcvw.md5 = params.JRz;
      }
      catch (Exception localException)
      {
        try
        {
          int i;
          String str1;
          localq.KAa = localcvw.toByteArray();
          localq.KzW = str1;
          if ((TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4)))
          {
            a(i, localq);
            params = a(params, localcvw.TEB);
            params.fWh = i;
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
          paramString2 = new cvo();
          paramString2.rWu = 1;
          paramString2.Url = paramString3;
          localcvw.TEx = paramString2;
          localcvw.TAg = 0;
          com.tencent.mm.aq.f.bkh();
          localcvw.TDY = com.tencent.mm.aq.a.Vu(paramString1);
          if (!Util.isNullOrNil(paramString4))
          {
            paramString1 = new cvo();
            paramString1.rWu = 1;
            paramString1.Url = paramString4;
            localcvw.TEz.add(paramString1);
          }
        }
      }
      try
      {
        localq.KAa = localcvw.toByteArray();
        localq.fSV();
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
  
  public final boolean a(String paramString, q paramq)
  {
    AppMethodBeat.i(97600);
    Log.d("MicroMsg.snsMediaStorage", "replace AlbumLikeList ".concat(String.valueOf(paramString)));
    Cursor localCursor = this.lvy.query("SnsMedia", null, "StrId=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (localCursor.moveToFirst())
    {
      localCursor.close();
      bool = a(paramq);
      AppMethodBeat.o(97600);
      return bool;
    }
    localCursor.close();
    boolean bool = b(paramString, paramq);
    AppMethodBeat.o(97600);
    return bool;
  }
  
  public final q bbE(String paramString)
  {
    AppMethodBeat.i(97603);
    q localq = new q();
    paramString = this.lvy.query("SnsMedia", null, "StrId=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (paramString.moveToFirst())
    {
      localq.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(97603);
      return localq;
    }
    paramString.close();
    AppMethodBeat.o(97603);
    return null;
  }
  
  public final List<s> hE(List<s> paramList)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.r
 * JD-Core Version:    0.7.0.1
 */