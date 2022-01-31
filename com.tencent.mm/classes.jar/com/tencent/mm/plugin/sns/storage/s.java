package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.text.TextUtils;
import com.tencent.mm.a.g;
import com.tencent.mm.ak.f;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.awg;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s
  extends j
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS SnsMedia ( local_id INTEGER PRIMARY KEY, seqId LONG, type INT, createTime LONG, userName VARCHAR(40), totallen INT, offset INT, local_flag INT, tmp_path TEXT, nums INT, try_times INT, StrId VARCHAR(40), upload_buf TEXT, reserved1 INT, reserved2 TEXT, reserved3 TEXT, reserved4 TEXT, reserved5 TEXT )", "CREATE INDEX IF NOT EXISTS serverSnsMediaTimeIndex ON SnsMedia ( createTime )" };
  private static int oki = 0;
  private static int olc = 0;
  private static Point osl = new Point();
  public com.tencent.mm.cf.h dXo;
  
  public s(com.tencent.mm.cf.h paramh)
  {
    this.dXo = paramh;
  }
  
  private static String OP(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    String str2 = g.o(paramString.getBytes());
    paramString = "";
    String str1 = "";
    if (str2.length() > 0) {
      paramString = str2.charAt(0) + "/";
    }
    if (str2.length() >= 2) {
      str1 = str2.charAt(1) + "/";
    }
    return af.getAccSnsPath() + paramString + str1;
  }
  
  /* Error */
  public static boolean OR(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: invokestatic 94	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   8: astore_0
    //   9: aload_0
    //   10: astore_2
    //   11: aload_0
    //   12: astore_3
    //   13: new 96	android/graphics/BitmapFactory$Options
    //   16: dup
    //   17: invokespecial 97	android/graphics/BitmapFactory$Options:<init>	()V
    //   20: astore 4
    //   22: aload_0
    //   23: astore_2
    //   24: aload_0
    //   25: astore_3
    //   26: aload 4
    //   28: iconst_1
    //   29: putfield 101	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   32: aload_0
    //   33: astore_2
    //   34: aload_0
    //   35: astore_3
    //   36: aload_0
    //   37: aconst_null
    //   38: aload 4
    //   40: aconst_null
    //   41: iconst_0
    //   42: iconst_0
    //   43: newarray int
    //   45: invokestatic 107	com/tencent/mm/sdk/platformtools/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;I[I)Landroid/graphics/Bitmap;
    //   48: pop
    //   49: aload_0
    //   50: astore_2
    //   51: aload_0
    //   52: astore_3
    //   53: aload 4
    //   55: getfield 111	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   58: astore 4
    //   60: aload_0
    //   61: astore_2
    //   62: aload_0
    //   63: astore_3
    //   64: ldc 113
    //   66: new 59	java/lang/StringBuilder
    //   69: dup
    //   70: ldc 115
    //   72: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: aload 4
    //   77: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 124	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload_0
    //   87: astore_2
    //   88: aload_0
    //   89: astore_3
    //   90: aload 4
    //   92: invokevirtual 127	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   95: ldc 129
    //   97: invokevirtual 133	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   100: istore_1
    //   101: iload_1
    //   102: iflt +13 -> 115
    //   105: aload_0
    //   106: ifnull +7 -> 113
    //   109: aload_0
    //   110: invokevirtual 138	java/io/InputStream:close	()V
    //   113: iconst_1
    //   114: ireturn
    //   115: aload_0
    //   116: ifnull +7 -> 123
    //   119: aload_0
    //   120: invokevirtual 138	java/io/InputStream:close	()V
    //   123: iconst_0
    //   124: ireturn
    //   125: astore_0
    //   126: aload_2
    //   127: ifnull +7 -> 134
    //   130: aload_2
    //   131: invokevirtual 138	java/io/InputStream:close	()V
    //   134: iconst_0
    //   135: ireturn
    //   136: astore_0
    //   137: aload_3
    //   138: ifnull +7 -> 145
    //   141: aload_3
    //   142: invokevirtual 138	java/io/InputStream:close	()V
    //   145: aload_0
    //   146: athrow
    //   147: astore_0
    //   148: goto -35 -> 113
    //   151: astore_0
    //   152: goto -29 -> 123
    //   155: astore_0
    //   156: goto -22 -> 134
    //   159: astore_2
    //   160: goto -15 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	paramString	String
    //   100	2	1	i	int
    //   3	128	2	str1	String
    //   159	1	2	localIOException	IOException
    //   1	141	3	str2	String
    //   20	71	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	125	java/lang/Exception
    //   13	22	125	java/lang/Exception
    //   26	32	125	java/lang/Exception
    //   36	49	125	java/lang/Exception
    //   53	60	125	java/lang/Exception
    //   64	86	125	java/lang/Exception
    //   90	101	125	java/lang/Exception
    //   4	9	136	finally
    //   13	22	136	finally
    //   26	32	136	finally
    //   36	49	136	finally
    //   53	60	136	finally
    //   64	86	136	finally
    //   90	101	136	finally
    //   109	113	147	java/io/IOException
    //   119	123	151	java/io/IOException
    //   130	134	155	java/io/IOException
    //   141	145	159	java/io/IOException
  }
  
  public static Bitmap OS(String paramString)
  {
    int j = 640;
    Object localObject = c.YU(paramString);
    int i;
    if (((BitmapFactory.Options)localObject).outWidth >= ((BitmapFactory.Options)localObject).outHeight)
    {
      i = 960;
      if (((BitmapFactory.Options)localObject).outWidth < ((BitmapFactory.Options)localObject).outHeight) {
        break label96;
      }
    }
    Bitmap localBitmap;
    for (;;)
    {
      localObject = new MMBitmapFactory.DecodeResultLogger();
      localBitmap = c.a(paramString, j, i, false, (MMBitmapFactory.DecodeResultLogger)localObject, 0);
      if (localBitmap != null) {
        break label103;
      }
      if (((MMBitmapFactory.DecodeResultLogger)localObject).getDecodeResult() >= 2000)
      {
        paramString = MMBitmapFactory.KVStatHelper.getKVStatString(paramString, 10, (MMBitmapFactory.DecodeResultLogger)localObject);
        com.tencent.mm.plugin.report.service.h.nFQ.aC(12712, paramString);
      }
      return null;
      i = 640;
      break;
      label96:
      j = 960;
    }
    label103:
    return c.b(localBitmap, Exif.fromFile(paramString).getOrientationInDegree());
  }
  
  private int a(com.tencent.mm.plugin.sns.data.h paramh)
  {
    Object localObject1 = af.getAccSnsPath();
    String str1 = af.getAccSnsTmpPath();
    y.i("MicroMsg.snsMediaStorage", "SnsMediaStorage %s %s", new Object[] { localObject1, str1 });
    long l = System.currentTimeMillis();
    Object localObject3 = paramh.path;
    int i = paramh.type;
    if (!e.bK((String)localObject3)) {
      return -1;
    }
    Object localObject2 = g.o(((String)localObject3 + System.currentTimeMillis()).getBytes());
    String str2 = i.MV((String)localObject2);
    y.d("MicroMsg.snsMediaStorage", "insert : original img path = " + (String)localObject3);
    if (!e.bK(str1))
    {
      y.i("MicroMsg.snsMediaStorage", "create snstmp path " + str1);
      e.nb(str1);
    }
    if (!e.bK((String)localObject1))
    {
      y.i("MicroMsg.snsMediaStorage", "create snsPath " + (String)localObject1);
      e.nb((String)localObject1);
    }
    localObject1 = new com.tencent.mm.plugin.n.a();
    paramh = a(paramh, (String)localObject3);
    int j = paramh.width;
    int k = paramh.height;
    int m = paramh.fileSize;
    ((com.tencent.mm.plugin.n.a)localObject1).lnE = ((String)localObject3);
    ((com.tencent.mm.plugin.n.a)localObject1).lnG = j;
    ((com.tencent.mm.plugin.n.a)localObject1).lnH = k;
    ((com.tencent.mm.plugin.n.a)localObject1).lnI = m;
    if (!d(str1, (String)localObject3, str2, true)) {
      return -1;
    }
    y.d("MicroMsg.snsMediaStorage", "insert0 " + (System.currentTimeMillis() - l));
    y.d("MicroMsg.snsMediaStorage", "insert: compressed bigMediaPath = " + str2);
    j = (int)e.aeQ(str1 + str2);
    if ((((String)localObject3).toLowerCase().contains("jpg")) || (((String)localObject3).toLowerCase().contains("jpeg")))
    {
      localObject3 = c.bw(e.c((String)localObject3, 0, j));
      if (localObject3 != null) {
        y.i("MicroMsg.snsMediaStorage", "insert yuvInfo:%s", new Object[] { localObject3 });
      }
    }
    try
    {
      localObject4 = new ExifInterface(str1 + str2);
      ((ExifInterface)localObject4).setAttribute("UserComment", (String)localObject3);
      ((ExifInterface)localObject4).saveAttributes();
      j = (int)e.aeQ(str1 + str2);
      localObject3 = a(paramh, str1 + str2);
      k = ((com.tencent.mm.plugin.sns.data.h)localObject3).width;
      m = ((com.tencent.mm.plugin.sns.data.h)localObject3).height;
      ((com.tencent.mm.plugin.n.a)localObject1).lnJ = k;
      ((com.tencent.mm.plugin.n.a)localObject1).lnK = m;
      ((com.tencent.mm.plugin.n.a)localObject1).lnL = j;
      paramh = new r();
      paramh.oLR = ((String)localObject2);
      paramh.createTime = ((int)bk.UX());
      paramh.type = i;
      localObject2 = new awg();
      ((awg)localObject2).trR = ((com.tencent.mm.plugin.sns.data.h)localObject3).onb;
      ((awg)localObject2).tsm = ((com.tencent.mm.plugin.sns.data.h)localObject3).ona;
      ((awg)localObject2).token = ((com.tencent.mm.plugin.sns.data.h)localObject3).ond;
      ((awg)localObject2).tsv = ((com.tencent.mm.plugin.sns.data.h)localObject3).one;
      ((awg)localObject2).tsJ = 0;
      ((awg)localObject2).tsI = new awa();
      ((awg)localObject2).ebp = 0;
      ((awg)localObject2).kRN = ((com.tencent.mm.plugin.sns.data.h)localObject3).desc;
      y.d("MicroMsg.snsMediaStorage", "upload.filterId " + ((com.tencent.mm.plugin.sns.data.h)localObject3).filterId);
      ((awg)localObject2).tsl = ((com.tencent.mm.plugin.sns.data.h)localObject3).filterId;
      ((awg)localObject2).tsL = 2;
      ((awg)localObject2).bIW = e.aeY(str1 + str2);
    }
    catch (Exception localException2)
    {
      try
      {
        Object localObject4;
        paramh.oLV = ((awg)localObject2).toByteArray();
        paramh.bGZ();
        paramh.oLQ = j;
        y.i("MicroMsg.snsMediaStorage", "insert a local snsMedia  totallen  :" + j + " filepath: " + str1 + str2);
        j = (int)this.dXo.insert("SnsMedia", "local_id", paramh.bGY());
        y.d("MicroMsg.snsMediaStorage", "insert localId " + j);
        localObject2 = "Locall_path" + j;
        ((com.tencent.mm.plugin.n.a)localObject1).lnF = String.valueOf(j);
        localObject3 = Exif.fromFile(((com.tencent.mm.plugin.n.a)localObject1).lnE);
        i = 0;
        if (((com.tencent.mm.plugin.n.a)localObject1).lnE.indexOf("png") >= 0)
        {
          i = 1;
          localObject4 = new d();
          ((d)localObject4).j("20 localID", ((com.tencent.mm.plugin.n.a)localObject1).lnF + ",");
          ((d)localObject4).j("21 MediaType", i + ",");
          ((d)localObject4).j("22 OriginWidth", ((com.tencent.mm.plugin.n.a)localObject1).lnG + ",");
          ((d)localObject4).j("23 OriginHeight", ((com.tencent.mm.plugin.n.a)localObject1).lnH + ",");
          ((d)localObject4).j("24 CompressedWidth", ((com.tencent.mm.plugin.n.a)localObject1).lnJ + ",");
          ((d)localObject4).j("25 CompressedHeight", ((com.tencent.mm.plugin.n.a)localObject1).lnK + ",");
          ((d)localObject4).j("26 OriginSize", ((com.tencent.mm.plugin.n.a)localObject1).lnI + ",");
          ((d)localObject4).j("27 CompressedSize", ((com.tencent.mm.plugin.n.a)localObject1).lnL + ",");
          ((d)localObject4).j("28 FNumber", ((Exif)localObject3).fNumber + ",");
          ((d)localObject4).j("29 ExposureTime", ((Exif)localObject3).exposureTime + ",");
          ((d)localObject4).j("30 ISO", ((Exif)localObject3).isoSpeedRatings + ",");
          ((d)localObject4).j("31 Flash", ((Exif)localObject3).flash + ",");
          ((d)localObject4).j("32 LensModel", com.tencent.mm.plugin.n.a.Fv(((Exif)localObject3).model) + ",");
          ((d)localObject4).j("33 CreatTime", com.tencent.mm.plugin.n.a.Fv(((Exif)localObject3).dateTimeOriginal) + ",");
          ((d)localObject4).j("34 IsFromWeChat", "0,");
          ((d)localObject4).j("35 Scene", ",");
          ((d)localObject4).j("36 sceneType", ((Exif)localObject3).sceneType + ",");
          ((d)localObject4).j("37 fileSource", ((Exif)localObject3).fileSource + ",");
          ((d)localObject4).j("38 make", ((Exif)localObject3).make + ",");
          ((d)localObject4).j("39 software", ((Exif)localObject3).software + ",");
          ((d)localObject4).j("40 fileExt", com.tencent.mm.plugin.n.a.bM(((com.tencent.mm.plugin.n.a)localObject1).lnE) + ",");
          y.v("MicroMsg.ImgExtInfoReport", "report logbuffer MMImageExifInfo(14525): %s, orgPath:%s", new Object[] { ((d)localObject4).uJ(), ((com.tencent.mm.plugin.n.a)localObject1).lnE });
          com.tencent.mm.plugin.report.service.h.nFQ.f(14525, new Object[] { localObject4 });
          localObject1 = i.MV((String)localObject2);
          localObject3 = OP((String)localObject2);
          e.nb((String)localObject3);
          y.i("MicroMsg.snsMediaStorage", "checkcntpath " + (String)localObject3);
          e.r(str1 + str2, (String)localObject3 + (String)localObject1);
          str1 = (String)localObject3 + i.MR((String)localObject2);
          str2 = (String)localObject3 + i.MS((String)localObject2);
          e.deleteFile(str1);
          e.deleteFile(str2);
          y.i("MicroMsg.snsMediaStorage", "insert done " + (System.currentTimeMillis() - l) + " targetPath : " + (String)localObject3 + (String)localObject1 + " totalLen:" + e.aeQ(new StringBuilder().append((String)localObject3).append((String)localObject1).toString()) + "  now delete...:" + str1 + " & " + str2);
          paramh.oLR = ((String)localObject2);
          a(j, paramh);
          return j;
          localException2 = localException2;
          y.printErrStackTrace("MicroMsg.snsMediaStorage", localException2, "", new Object[0]);
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          y.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
          continue;
          if ((((com.tencent.mm.plugin.n.a)localObject1).lnE.indexOf("jpg") >= 0) || (((com.tencent.mm.plugin.n.a)localObject1).lnE.indexOf("jpeg") >= 0)) {
            i = 2;
          } else if (((com.tencent.mm.plugin.n.a)localObject1).lnE.indexOf("mp3") >= 0) {
            i = 3;
          }
        }
      }
    }
  }
  
  private static com.tencent.mm.plugin.sns.data.h a(com.tencent.mm.plugin.sns.data.h paramh, String paramString)
  {
    Object localObject5 = null;
    localObject1 = null;
    n = 0;
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
        localObject5 = e.openRead(paramString);
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
        BitmapFactory.decodeStream((InputStream)localObject1, null, localOptions);
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
        y.printErrStackTrace("MicroMsg.snsMediaStorage", localObject4, "setImageExtInfo failed: " + paramString, new Object[0]);
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
          break label322;
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
            throw paramh;
            localIOException2 = localIOException2;
            k = i;
            m = j;
          }
          catch (IOException paramString) {}
        }
      }
      paramh.width = m;
      paramh.height = k;
      paramh.fileSize = ((int)e.aeQ(paramString));
      return paramh;
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
  
  private static boolean a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap.CompressFormat paramCompressFormat, int paramInt5, String paramString2, String paramString3, boolean paramBoolean)
  {
    Object localObject5 = null;
    Object localObject3 = localObject5;
    Object localObject4;
    double d2;
    double d3;
    try
    {
      y.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, srcWidth: %s, srcHeight: %s, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt3) });
      localObject3 = localObject5;
      Object localObject2 = new BitmapFactory.Options();
      localObject3 = localObject5;
      localObject4 = new MMBitmapFactory.DecodeResultLogger();
      localObject3 = localObject5;
      d2 = paramInt2 * 1.0D / paramInt3;
      localObject3 = localObject5;
      d3 = paramInt1 * 1.0D / paramInt4;
      if ((paramInt1 == paramInt4) && (paramInt2 == paramInt3))
      {
        localObject3 = localObject5;
        localObject2 = com.tencent.mm.plugin.sns.d.a.b(paramString1, (BitmapFactory.Options)localObject2, (MMBitmapFactory.DecodeResultLogger)localObject4);
      }
      for (;;)
      {
        localObject3 = localObject5;
        y.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, result bm: %s", new Object[] { localObject2 });
        if (localObject2 == null)
        {
          localObject3 = localObject5;
          if (((MMBitmapFactory.DecodeResultLogger)localObject4).getDecodeResult() >= 2000)
          {
            localObject3 = localObject5;
            paramString1 = MMBitmapFactory.KVStatHelper.getKVStatString(paramString1, 10, (MMBitmapFactory.DecodeResultLogger)localObject4);
            localObject3 = localObject5;
            com.tencent.mm.plugin.report.service.h.nFQ.aC(12712, paramString1);
            break label666;
            localObject3 = localObject5;
            ((BitmapFactory.Options)localObject2).inSampleSize = 1;
            if (paramInt2 > paramInt3) {
              break label668;
            }
            if (paramInt1 > paramInt4)
            {
              break label668;
              label221:
              localObject3 = localObject5;
              Object localObject1;
              ((BitmapFactory.Options)localObject2).inSampleSize = ((int)localObject1);
              localObject3 = localObject5;
              if (((BitmapFactory.Options)localObject2).inSampleSize <= 1) {
                localObject3 = localObject5;
              }
            }
            for (((BitmapFactory.Options)localObject2).inSampleSize = 1;; ((BitmapFactory.Options)localObject2).inSampleSize += 1)
            {
              localObject3 = localObject5;
              if (paramInt2 * paramInt1 / ((BitmapFactory.Options)localObject2).inSampleSize / ((BitmapFactory.Options)localObject2).inSampleSize <= 2764800) {
                break;
              }
              localObject3 = localObject5;
            }
          }
        }
        else
        {
          try
          {
            ((OutputStream)localObject3).close();
            return false;
            d1 = d2;
            break label221;
            localObject3 = localObject5;
            y.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, sampleSize: %s", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject2).inSampleSize) });
            localObject3 = localObject5;
            localObject2 = com.tencent.mm.plugin.sns.d.a.b(paramString1, (BitmapFactory.Options)localObject2, (MMBitmapFactory.DecodeResultLogger)localObject4);
            continue;
            localObject3 = localObject5;
            y.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()) });
            localObject4 = localObject2;
            if (paramBoolean)
            {
              if (d2 >= d3) {
                break label631;
              }
              localObject3 = localObject5;
              paramInt2 = (int)Math.ceil(paramInt4 * 1.0D * paramInt2 / paramInt1);
              paramInt1 = paramInt4;
            }
            for (;;)
            {
              localObject3 = localObject5;
              paramInt3 = BackwardSupportUtil.ExifHelper.YS(paramString1);
              if (paramInt3 == 90) {
                break label683;
              }
              if (paramInt3 != 270) {
                break;
              }
              break label683;
              localObject3 = localObject5;
              localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject2, paramInt1, paramInt2, true);
              paramString1 = (String)localObject2;
              if (localObject4 != null)
              {
                if (localObject2 == localObject4) {
                  break label692;
                }
                localObject3 = localObject5;
                l.Fb().n((Bitmap)localObject2);
                break label692;
              }
              localObject3 = localObject5;
              y.i("MicroMsg.snsMediaStorage", "createThumbNailUnScalebyUpload, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(paramString1.getWidth()), Integer.valueOf(paramString1.getHeight()) });
              localObject4 = paramString1;
              localObject3 = localObject5;
              paramString1 = e.I(paramString2 + paramString3, false);
              localObject3 = paramString1;
              c.a((Bitmap)localObject4, paramInt5, paramCompressFormat, paramString1, false);
              localObject3 = paramString1;
              l.Fb().n((Bitmap)localObject4);
              localObject3 = paramString1;
              paramString1.close();
              return true;
              localObject3 = localObject5;
              d1 = Math.ceil(paramInt3 * 1.0D * paramInt1 / paramInt2);
              paramInt1 = (int)d1;
              paramInt2 = paramInt3;
            }
          }
          catch (IOException paramString1)
          {
            for (;;) {}
          }
        }
      }
    }
    catch (IOException paramString1)
    {
      y.printErrStackTrace("MicroMsg.snsMediaStorage", paramString1, "create thumbnail from orig failed: %s", new Object[] { paramString3 });
      if (localObject3 == null) {}
    }
    for (;;)
    {
      double d1;
      label631:
      return false;
      label666:
      label668:
      if (d2 < d3)
      {
        d1 = d3;
        break;
        label683:
        paramInt3 = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = paramInt3;
        continue;
        label692:
        paramString1 = (String)localObject4;
      }
    }
  }
  
  private static boolean a(String paramString1, int paramInt1, int paramInt2, int paramInt3, Bitmap.CompressFormat paramCompressFormat, int paramInt4, String paramString2, String paramString3)
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    int i;
    try
    {
      y.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, srcWidth: %d, srcHeight: %d, fixShort: %d, quality:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      localObject1 = localObject3;
      Object localObject2 = new BitmapFactory.Options();
      localObject1 = localObject3;
      Object localObject4 = new MMBitmapFactory.DecodeResultLogger();
      if (paramInt2 > paramInt1)
      {
        i = paramInt1;
        if (i == paramInt3)
        {
          localObject1 = localObject3;
          localObject2 = com.tencent.mm.plugin.sns.d.a.b(paramString1, (BitmapFactory.Options)localObject2, (MMBitmapFactory.DecodeResultLogger)localObject4);
        }
        for (;;)
        {
          localObject1 = localObject3;
          y.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, result bm: %s", new Object[] { localObject2 });
          if (localObject2 == null)
          {
            localObject1 = localObject3;
            if (((MMBitmapFactory.DecodeResultLogger)localObject4).getDecodeResult() >= 2000)
            {
              localObject1 = localObject3;
              paramString1 = MMBitmapFactory.KVStatHelper.getKVStatString(paramString1, 10, (MMBitmapFactory.DecodeResultLogger)localObject4);
              localObject1 = localObject3;
              com.tencent.mm.plugin.report.service.h.nFQ.aC(12712, paramString1);
              break label727;
              localObject1 = localObject3;
              ((BitmapFactory.Options)localObject2).inSampleSize = 1;
              if (i > paramInt3)
              {
                localObject1 = localObject3;
                ((BitmapFactory.Options)localObject2).inSampleSize = (i / paramInt3);
                localObject1 = localObject3;
                if (((BitmapFactory.Options)localObject2).inSampleSize <= 1) {
                  localObject1 = localObject3;
                }
              }
              for (((BitmapFactory.Options)localObject2).inSampleSize = 1;; ((BitmapFactory.Options)localObject2).inSampleSize += 1)
              {
                localObject1 = localObject3;
                if (paramInt2 * paramInt1 / ((BitmapFactory.Options)localObject2).inSampleSize / ((BitmapFactory.Options)localObject2).inSampleSize <= 5529600) {
                  break;
                }
                localObject1 = localObject3;
              }
            }
          }
          else
          {
            try
            {
              localObject1.close();
              return false;
              localObject1 = localObject3;
              y.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, sampleSize: %s", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject2).inSampleSize) });
              localObject1 = localObject3;
              localObject2 = com.tencent.mm.plugin.sns.d.a.b(paramString1, (BitmapFactory.Options)localObject2, (MMBitmapFactory.DecodeResultLogger)localObject4);
              continue;
              localObject1 = localObject3;
              j = paramInt1 * paramInt3 / i;
              localObject1 = localObject3;
              paramInt3 = paramInt2 * paramInt3 / i;
              localObject1 = localObject3;
              m = BackwardSupportUtil.ExifHelper.YS(paramString1);
              if (m != 90) {
                if (m == 270)
                {
                  break label735;
                  localObject1 = localObject3;
                  y.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, bm.width: %s, bm.height: %s, new:[%d,%d], src:[%d, %d], shortEdge:%d,degree:%d", new Object[] { Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()), Integer.valueOf(paramInt3), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(m) });
                  localObject1 = localObject3;
                  localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject2, paramInt3, j, true);
                  if (localObject4 != null)
                  {
                    paramString1 = (String)localObject4;
                    if (localObject2 != localObject4)
                    {
                      localObject1 = localObject3;
                      l.Fb().n((Bitmap)localObject2);
                      paramString1 = (String)localObject4;
                    }
                    localObject1 = localObject3;
                    y.i("MicroMsg.snsMediaStorage", "createThumbNailUnScaleFixShort, bm.width: %s, bm.height: %s, quality:%d", new Object[] { Integer.valueOf(paramString1.getWidth()), Integer.valueOf(paramString1.getHeight()), Integer.valueOf(paramInt4) });
                    localObject1 = localObject3;
                    localObject2 = e.I(paramString2 + paramString3, false);
                    localObject1 = localObject2;
                    c.a(paramString1, paramInt4, paramCompressFormat, (OutputStream)localObject2, false);
                    localObject1 = localObject2;
                    l.Fb().n(paramString1);
                    localObject1 = localObject2;
                    ((OutputStream)localObject2).close();
                    localObject1 = null;
                    y.i("MicroMsg.snsMediaStorage", "createThumbNailUnScaleFixShort saving to %s, size:%d", new Object[] { paramString2 + paramString3, Long.valueOf(e.aeQ(paramString2 + paramString3)) });
                    return true;
                  }
                }
              }
            }
            catch (IOException paramString1)
            {
              for (;;)
              {
                continue;
                paramString1 = (String)localObject2;
                continue;
                k = paramInt3;
                paramInt3 = j;
                j = k;
              }
            }
          }
        }
      }
    }
    catch (IOException paramString1)
    {
      y.printErrStackTrace("MicroMsg.snsMediaStorage", paramString1, "create thumbnail from orig failed: %s", new Object[] { paramString3 });
      if (localObject1 == null) {}
    }
    label727:
    label735:
    for (;;)
    {
      int j;
      int m;
      int k;
      return false;
      i = paramInt2;
      break;
    }
  }
  
  private static boolean a(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, String paramString3, boolean paramBoolean)
  {
    BitmapFactory.Options localOptions = c.YU(paramString1);
    if ((localOptions == null) || (localOptions.outWidth <= 0) || (localOptions.outHeight <= 0)) {
      return false;
    }
    return a(paramString1, localOptions.outWidth, localOptions.outHeight, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2, paramString3, paramBoolean);
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, float paramFloat)
  {
    localObject3 = null;
    try
    {
      InputStream localInputStream = e.openRead(paramString1 + paramString2);
      localObject3 = localInputStream;
      localOptions = new BitmapFactory.Options();
      localObject3 = localInputStream;
      localOptions.inJustDecodeBounds = true;
      localObject3 = localInputStream;
      MMBitmapFactory.decodeStream(localInputStream, null, localOptions, null, 0, new int[0]);
      localObject3 = localInputStream;
      localInputStream.close();
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        BitmapFactory.Options localOptions;
        label141:
        double d7;
        double d8;
        Object localObject2;
        Object localObject1;
        double d6;
        i = 1;
        d1 = 0.0D;
        d2 = 0.0D;
        if (localObject3 != null)
        {
          try
          {
            ((InputStream)localObject3).close();
            d6 = 240.0D;
            d5 = 240.0D;
            d4 = d1;
            d3 = d2;
            d1 = d6;
            d2 = d5;
          }
          catch (IOException localIOException) {}
        }
        else
        {
          d6 = 240.0D;
          d5 = 240.0D;
          d4 = d1;
          d3 = d2;
          d1 = d6;
          d2 = d5;
          continue;
          paramString2 = Bitmap.CompressFormat.JPEG;
        }
      }
    }
    for (;;)
    {
      try
      {
        d3 = localOptions.outWidth;
        i = localOptions.outHeight;
        d1 = i;
        if ((d3 <= 120.0D) && (d1 <= 120.0D)) {
          continue;
        }
        i = 0;
      }
      catch (Exception localException1)
      {
        Object localObject4 = null;
        i = 1;
        d1 = 0.0D;
        d2 = 0.0D;
        break label429;
        Object localObject5;
        i = 1;
        break;
        d5 = 240.0D;
        d2 = 240.0D;
        break label141;
      }
      try
      {
        localObject3 = localOptions.outMimeType;
        if (d3 < 0.0D) {
          continue;
        }
        if (d1 >= 0.0D) {
          continue;
        }
      }
      catch (Exception localException2)
      {
        localObject5 = null;
        d2 = d3;
        break label429;
        d4 = d5;
        break label318;
        d2 = d1;
        d5 = d3;
        break label141;
      }
    }
    d7 = paramFloat;
    d8 = paramFloat / 200.0F * 44.0F;
    d4 = paramFloat / 200.0F * 160.0F;
    if ((localObject2 > 0.0D) && (localObject1 > 0.0D))
    {
      d4 = Math.min(d7 / localObject2, d7 / localObject1);
      localObject2 *= d4;
      d6 = localObject1 * d4;
      d2 = d6;
      d4 = d5;
      if (d5 < d8)
      {
        d2 = 1.0D * d8 / d5;
        d4 = d5 * d2;
        d2 = d6 * d2;
      }
      d5 = d2;
      d6 = d4;
      if (d2 < d8)
      {
        d5 = 1.0D * d8 / d2;
        d6 = d4 * d5;
        d5 = d2 * d5;
      }
      d2 = d6;
      if (d6 > d7) {
        d2 = d7;
      }
      if (d5 > d7)
      {
        d4 = d7;
        label318:
        d5 = d1;
        d1 = d4;
      }
    }
    else
    {
      for (d4 = d5;; d4 = d5)
      {
        localObject3 = paramString1 + paramString2;
        int j = (int)d3;
        int k = (int)d4;
        int m = (int)d1;
        int n = (int)d2;
        if (i == 0) {
          break;
        }
        paramString2 = Bitmap.CompressFormat.PNG;
        return a((String)localObject3, j, k, m, n, paramString2, 70, paramString1, paramString3, false);
        d5 = d1;
        d1 = d4;
        d2 = d4;
      }
    }
  }
  
  public static boolean ab(String paramString1, String paramString2, String paramString3)
  {
    return d(paramString1, paramString2, paramString3, true);
  }
  
  public static boolean b(String paramString1, String paramString2, String paramString3, float paramFloat)
  {
    Object localObject1;
    for (;;)
    {
      MMBitmapFactory.DecodeResultLogger localDecodeResultLogger;
      int i1;
      int n;
      int m;
      int k;
      try
      {
        e.deleteFile(paramString1 + paramString3);
        localDecodeResultLogger = new MMBitmapFactory.DecodeResultLogger();
        localObject1 = c.YU(paramString1 + paramString2);
        if (localObject1 == null)
        {
          y.e("MicroMsg.snsMediaStorage", "createUserAlbum, getImageOptions error");
          return false;
        }
        if ((((BitmapFactory.Options)localObject1).outMimeType != null) && ((((BitmapFactory.Options)localObject1).outMimeType.toLowerCase().endsWith("png")) || (((BitmapFactory.Options)localObject1).outMimeType.toLowerCase().endsWith("vcodec"))))
        {
          localObject1 = c.a(paramString1 + paramString2, (int)paramFloat, (int)paramFloat, true, localDecodeResultLogger, 0);
          if (localObject1 != null) {
            break;
          }
          y.i("MicroMsg.snsMediaStorage", "bitmap error " + paramString1 + paramString2);
          if (localDecodeResultLogger.getDecodeResult() >= 2000)
          {
            paramString3 = MMBitmapFactory.KVStatHelper.getKVStatString(paramString1 + paramString2, 10, localDecodeResultLogger);
            com.tencent.mm.plugin.report.service.h.nFQ.aC(12712, paramString3);
          }
          e.deleteFile(paramString1 + paramString2);
          return false;
        }
        i1 = ((BitmapFactory.Options)localObject1).outWidth;
        n = ((BitmapFactory.Options)localObject1).outHeight;
        m = (int)paramFloat;
        k = (int)paramFloat;
        ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
        y.i("MicroMsg.snsMediaStorage", "createUserAlbum, srcWidth: %s, srcHeight: %s, dstWidth: %s, dstHeight: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k) });
        if ((i1 == m) && (n == k))
        {
          localObject1 = com.tencent.mm.plugin.sns.d.a.b(paramString1 + paramString2, (BitmapFactory.Options)localObject1, localDecodeResultLogger);
          continue;
        }
        if (n * 1.0D / k > i1 * 1.0D / m)
        {
          j = (int)Math.ceil(m * 1.0D * n / i1);
          i = m;
          y.d("MicroMsg.snsMediaStorage", "createUserAlbum, newWidth: %s, newHeight: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          ((BitmapFactory.Options)localObject1).inSampleSize = 1;
          if ((n <= j) && (i1 <= i)) {
            break label632;
          }
          ((BitmapFactory.Options)localObject1).inSampleSize = 1;
          if ((n > j) || (i1 > i))
          {
            d1 = n * 1.0D / j;
            double d2 = i1 * 1.0D / i;
            if (d1 >= d2) {
              break label1084;
            }
            d1 = d2;
            ((BitmapFactory.Options)localObject1).inSampleSize = ((int)d1);
            if (((BitmapFactory.Options)localObject1).inSampleSize <= 1) {
              ((BitmapFactory.Options)localObject1).inSampleSize = 1;
            }
          }
          if (n * i1 / ((BitmapFactory.Options)localObject1).inSampleSize / ((BitmapFactory.Options)localObject1).inSampleSize <= 2764800) {
            break label632;
          }
          ((BitmapFactory.Options)localObject1).inSampleSize += 1;
          continue;
          return true;
        }
      }
      catch (Exception paramString1)
      {
        y.e("MicroMsg.snsMediaStorage", "createUserAlbum error: %s", new Object[] { paramString1.getMessage() });
        y.printErrStackTrace("MicroMsg.snsMediaStorage", paramString1, "", new Object[0]);
      }
      double d1 = k * 1.0D * i1 / n;
      i = (int)Math.ceil(d1);
      int j = k;
      continue;
      label632:
      y.i("MicroMsg.snsMediaStorage", "createUserAlbum, inSampleSize: %s", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject1).inSampleSize) });
      if (n / i1 == k / m)
      {
        localObject1 = com.tencent.mm.plugin.sns.d.a.b(paramString1 + paramString2, (BitmapFactory.Options)localObject1, localDecodeResultLogger);
        y.i("MicroMsg.snsMediaStorage", "createUserAlbum, directly use inSampleSize");
      }
      else
      {
        paramFloat = Math.max(i / i1, j / n);
        i = (int)(m / paramFloat);
        j = (int)(k / paramFloat);
        i = Math.min(i1, i);
        j = Math.min(n, j);
        k = Math.max(0, i1 - i >> 1);
        m = Math.max(0, n - j >> 1);
        Object localObject2 = new Rect();
        ((Rect)localObject2).left = k;
        ((Rect)localObject2).right = (k + i);
        ((Rect)localObject2).top = m;
        ((Rect)localObject2).bottom = (m + j);
        String str = paramString1 + paramString2;
        long l = System.currentTimeMillis();
        localObject2 = l.Fb().a(str, (Rect)localObject2, (BitmapFactory.Options)localObject1, localDecodeResultLogger);
        localObject1 = localObject2;
        if (localObject2 != null) {
          localObject1 = i.q(str, (Bitmap)localObject2);
        }
        y.d("MicroMsg.SnsBitmapUtil", "regionDecodeWithRotateByExif used %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        y.i("MicroMsg.snsMediaStorage", "createUserAlbum, dstWidth: %s, dstHeight: %s, startX: %s, startY: %s, scaleFactor: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(paramFloat) });
      }
    }
    y.i("MicroMsg.snsMediaStorage", "createUserAlbum, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()) });
    int i = 1;
    if ((((Bitmap)localObject1).getHeight() <= 120) && (((Bitmap)localObject1).getWidth() <= 120)) {}
    for (;;)
    {
      if (i != 0) {}
      for (paramString2 = Bitmap.CompressFormat.PNG;; paramString2 = Bitmap.CompressFormat.JPEG)
      {
        c.a((Bitmap)localObject1, 100, paramString2, paramString1 + paramString3, false);
        l.Fb().n((Bitmap)localObject1);
        break;
      }
      label1084:
      break;
      i = 0;
    }
  }
  
  public static boolean bHb()
  {
    if ("hevc".equals(ae.eTC)) {
      return true;
    }
    return af.bDP();
  }
  
  public static boolean bHc()
  {
    if ("wxpc".equals(ae.eTC)) {
      return true;
    }
    return af.bDQ();
  }
  
  public static boolean bHd()
  {
    return (oki >= 1080) && (olc >= 1080);
  }
  
  /* Error */
  public static boolean d(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 146	com/tencent/mm/sdk/platformtools/c:YU	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   4: astore 21
    //   6: aload 21
    //   8: ifnull +981 -> 989
    //   11: aload 21
    //   13: getfield 111	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   16: astore 22
    //   18: ldc 113
    //   20: new 59	java/lang/StringBuilder
    //   23: dup
    //   24: ldc_w 826
    //   27: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   30: aload 22
    //   32: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 124	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: aload 22
    //   43: ifnull +946 -> 989
    //   46: aload 22
    //   48: invokevirtual 127	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   51: astore 22
    //   53: aload 22
    //   55: ldc_w 279
    //   58: invokevirtual 133	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   61: iflt +894 -> 955
    //   64: iconst_1
    //   65: istore 17
    //   67: aload 21
    //   69: ifnull +943 -> 1012
    //   72: aload 21
    //   74: getfield 111	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   77: astore 22
    //   79: aload 22
    //   81: ifnull +931 -> 1012
    //   84: aload 22
    //   86: invokevirtual 127	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   89: astore 22
    //   91: aload 22
    //   93: ldc_w 279
    //   96: invokevirtual 133	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   99: iflt +896 -> 995
    //   102: iconst_1
    //   103: istore 10
    //   105: iconst_m1
    //   106: istore 11
    //   108: bipush 100
    //   110: istore 7
    //   112: iload_3
    //   113: ifeq +2955 -> 3068
    //   116: iload 7
    //   118: istore 8
    //   120: invokestatic 832	com/tencent/mm/ak/f:Nd	()Lcom/tencent/mm/ak/b;
    //   123: pop
    //   124: iload 7
    //   126: istore 8
    //   128: bipush 64
    //   130: invokestatic 838	com/tencent/mm/ak/b:iq	(I)Z
    //   133: ifne +23 -> 156
    //   136: iload 7
    //   138: istore 8
    //   140: invokestatic 840	com/tencent/mm/plugin/sns/storage/s:bHb	()Z
    //   143: ifne +13 -> 156
    //   146: iload 7
    //   148: istore 8
    //   150: invokestatic 842	com/tencent/mm/plugin/sns/storage/s:bHc	()Z
    //   153: ifeq +960 -> 1113
    //   156: iload 7
    //   158: istore 8
    //   160: invokestatic 848	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   163: invokestatic 854	com/tencent/mm/sdk/platformtools/aq:isWifi	(Landroid/content/Context;)Z
    //   166: ifeq +852 -> 1018
    //   169: iload 7
    //   171: istore 8
    //   173: invokestatic 860	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   176: ldc_w 862
    //   179: invokevirtual 867	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   182: bipush 70
    //   184: invokestatic 871	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   187: istore 7
    //   189: iload 7
    //   191: istore 8
    //   193: ldc 113
    //   195: ldc_w 873
    //   198: bipush 7
    //   200: anewarray 199	java/lang/Object
    //   203: dup
    //   204: iconst_0
    //   205: invokestatic 860	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   208: ldc_w 862
    //   211: invokevirtual 867	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   214: aastore
    //   215: dup
    //   216: iconst_1
    //   217: invokestatic 860	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   220: ldc_w 875
    //   223: invokevirtual 867	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   226: aastore
    //   227: dup
    //   228: iconst_2
    //   229: invokestatic 860	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   232: ldc_w 877
    //   235: invokevirtual 867	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   238: aastore
    //   239: dup
    //   240: iconst_3
    //   241: invokestatic 860	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   244: ldc_w 879
    //   247: invokevirtual 867	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   250: aastore
    //   251: dup
    //   252: iconst_4
    //   253: invokestatic 860	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   256: ldc_w 881
    //   259: invokevirtual 867	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   262: aastore
    //   263: dup
    //   264: iconst_5
    //   265: invokestatic 860	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   268: ldc_w 883
    //   271: invokevirtual 867	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   274: aastore
    //   275: dup
    //   276: bipush 6
    //   278: invokestatic 860	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   281: ldc_w 885
    //   284: invokevirtual 867	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   287: aastore
    //   288: invokestatic 744	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   291: ldc 113
    //   293: ldc_w 887
    //   296: iconst_2
    //   297: anewarray 199	java/lang/Object
    //   300: dup
    //   301: iconst_0
    //   302: iload 7
    //   304: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   307: aastore
    //   308: dup
    //   309: iconst_1
    //   310: iload_3
    //   311: invokestatic 892	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   314: aastore
    //   315: invokestatic 203	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   318: iload 7
    //   320: bipush 10
    //   322: if_icmple +10 -> 332
    //   325: iload 7
    //   327: bipush 100
    //   329: if_icmple +2736 -> 3065
    //   332: bipush 60
    //   334: istore 7
    //   336: iload 10
    //   338: ifeq +2720 -> 3058
    //   341: aload_1
    //   342: invokestatic 897	com/tencent/mm/sdk/platformtools/MMNativeJpeg:queryQuality	(Ljava/lang/String;)I
    //   345: istore 8
    //   347: iload 8
    //   349: iload 7
    //   351: if_icmpge +2696 -> 3047
    //   354: iload 8
    //   356: bipush 25
    //   358: if_icmple +2689 -> 3047
    //   361: iload 8
    //   363: istore 9
    //   365: iload 8
    //   367: istore 11
    //   369: aload_1
    //   370: invokestatic 277	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   373: l2i
    //   374: istore 14
    //   376: sipush 1080
    //   379: istore 8
    //   381: aload_1
    //   382: invokestatic 902	com/tencent/mm/plugin/facedetect/FaceProNative:detectFaceCnt	(Ljava/lang/String;)I
    //   385: istore 7
    //   387: ldc 113
    //   389: ldc_w 904
    //   392: iconst_1
    //   393: anewarray 199	java/lang/Object
    //   396: dup
    //   397: iconst_0
    //   398: iload 7
    //   400: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   403: aastore
    //   404: invokestatic 203	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   407: iload 7
    //   409: iconst_5
    //   410: if_icmplt +8 -> 418
    //   413: sipush 1440
    //   416: istore 8
    //   418: iconst_0
    //   419: istore 12
    //   421: iload 7
    //   423: iconst_5
    //   424: if_icmplt +787 -> 1211
    //   427: iload 12
    //   429: istore 7
    //   431: invokestatic 860	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   434: ldc_w 906
    //   437: invokevirtual 867	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   440: astore 22
    //   442: iload 12
    //   444: istore 7
    //   446: aload 22
    //   448: ldc_w 908
    //   451: invokevirtual 912	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   454: iconst_0
    //   455: aaload
    //   456: invokestatic 915	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   459: invokevirtual 918	java/lang/Integer:intValue	()I
    //   462: istore 12
    //   464: iload 12
    //   466: istore 7
    //   468: aload 22
    //   470: ldc_w 908
    //   473: invokevirtual 912	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   476: iconst_1
    //   477: aaload
    //   478: invokestatic 915	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   481: invokevirtual 918	java/lang/Integer:intValue	()I
    //   484: istore 13
    //   486: iload 13
    //   488: istore 8
    //   490: iload 12
    //   492: istore 7
    //   494: ldc 113
    //   496: ldc_w 920
    //   499: bipush 6
    //   501: anewarray 199	java/lang/Object
    //   504: dup
    //   505: iconst_0
    //   506: iload 7
    //   508: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   511: aastore
    //   512: dup
    //   513: iconst_1
    //   514: iload 8
    //   516: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   519: aastore
    //   520: dup
    //   521: iconst_2
    //   522: getstatic 27	com/tencent/mm/plugin/sns/storage/s:oki	I
    //   525: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   528: aastore
    //   529: dup
    //   530: iconst_3
    //   531: getstatic 25	com/tencent/mm/plugin/sns/storage/s:olc	I
    //   534: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   537: aastore
    //   538: dup
    //   539: iconst_4
    //   540: iload 9
    //   542: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   545: aastore
    //   546: dup
    //   547: iconst_5
    //   548: iload_3
    //   549: invokestatic 892	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   552: aastore
    //   553: invokestatic 203	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   556: iload 7
    //   558: ifgt +972 -> 1530
    //   561: iload 8
    //   563: ifgt +967 -> 1530
    //   566: iconst_0
    //   567: istore 7
    //   569: sipush 1080
    //   572: istore 8
    //   574: invokestatic 860	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   577: ldc_w 922
    //   580: invokevirtual 867	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   583: bipush 100
    //   585: invokestatic 871	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   588: istore 13
    //   590: iload 13
    //   592: istore 12
    //   594: iload 13
    //   596: ifgt +7 -> 603
    //   599: bipush 100
    //   601: istore 12
    //   603: iload 12
    //   605: sipush 1024
    //   608: imul
    //   609: istore 15
    //   611: invokestatic 860	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   614: ldc_w 924
    //   617: invokevirtual 867	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   620: sipush 200
    //   623: invokestatic 871	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   626: istore 13
    //   628: iload 13
    //   630: istore 12
    //   632: iload 13
    //   634: ifgt +8 -> 642
    //   637: sipush 200
    //   640: istore 12
    //   642: iload 12
    //   644: sipush 1024
    //   647: imul
    //   648: istore 16
    //   650: invokestatic 860	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   653: ldc_w 926
    //   656: invokevirtual 867	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   659: bipush 10
    //   661: invokestatic 871	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   664: istore 12
    //   666: iload 12
    //   668: ifle +10 -> 678
    //   671: iload 12
    //   673: bipush 100
    //   675: if_icmplt +2366 -> 3041
    //   678: bipush 10
    //   680: istore 12
    //   682: iconst_0
    //   683: istore 13
    //   685: iload 10
    //   687: ifeq +914 -> 1601
    //   690: aload_1
    //   691: invokestatic 184	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   694: astore 22
    //   696: iload 13
    //   698: istore 10
    //   700: aload 22
    //   702: ifnull +14 -> 716
    //   705: aload 22
    //   707: invokevirtual 187	com/tencent/mm/compatible/util/Exif:getOrientationInDegree	()I
    //   710: sipush 360
    //   713: irem
    //   714: istore 10
    //   716: ldc 113
    //   718: new 59	java/lang/StringBuilder
    //   721: dup
    //   722: ldc_w 928
    //   725: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   728: aload 21
    //   730: getfield 149	android/graphics/BitmapFactory$Options:outWidth	I
    //   733: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   736: ldc_w 930
    //   739: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: aload 21
    //   744: getfield 152	android/graphics/BitmapFactory$Options:outHeight	I
    //   747: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   750: ldc_w 930
    //   753: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: iload 17
    //   758: invokevirtual 933	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   761: ldc_w 935
    //   764: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: iload 11
    //   769: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   772: ldc_w 937
    //   775: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: iload 10
    //   780: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   783: ldc_w 939
    //   786: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: iload 14
    //   791: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   794: ldc_w 941
    //   797: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: iload 7
    //   802: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   805: ldc_w 930
    //   808: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: iload 8
    //   813: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   816: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   819: invokestatic 234	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   822: invokestatic 860	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   825: ldc_w 943
    //   828: invokevirtual 867	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   831: bipush 10
    //   833: invokestatic 871	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   836: pop
    //   837: aload 21
    //   839: getfield 149	android/graphics/BitmapFactory$Options:outWidth	I
    //   842: aload 21
    //   844: getfield 152	android/graphics/BitmapFactory$Options:outHeight	I
    //   847: iconst_2
    //   848: imul
    //   849: if_icmpge +18 -> 867
    //   852: aload 21
    //   854: getfield 152	android/graphics/BitmapFactory$Options:outHeight	I
    //   857: aload 21
    //   859: getfield 149	android/graphics/BitmapFactory$Options:outWidth	I
    //   862: iconst_2
    //   863: imul
    //   864: if_icmplt +1395 -> 2259
    //   867: aload 21
    //   869: getfield 149	android/graphics/BitmapFactory$Options:outWidth	I
    //   872: aload 21
    //   874: getfield 152	android/graphics/BitmapFactory$Options:outHeight	I
    //   877: imul
    //   878: ldc_w 944
    //   881: if_icmpgt +1143 -> 2024
    //   884: iload 14
    //   886: iload 16
    //   888: if_icmpge +721 -> 1609
    //   891: iload 17
    //   893: ifeq +716 -> 1609
    //   896: iload 10
    //   898: ifne +711 -> 1609
    //   901: ldc 113
    //   903: new 59	java/lang/StringBuilder
    //   906: dup
    //   907: ldc_w 946
    //   910: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   913: iload 16
    //   915: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   918: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   921: invokestatic 234	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   924: aload_1
    //   925: new 59	java/lang/StringBuilder
    //   928: dup
    //   929: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   932: aload_0
    //   933: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: aload_2
    //   937: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   943: invokestatic 557	com/tencent/mm/vfs/e:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   946: lconst_0
    //   947: lcmp
    //   948: iflt +659 -> 1607
    //   951: iconst_1
    //   952: istore_3
    //   953: iload_3
    //   954: ireturn
    //   955: aload 22
    //   957: ldc_w 285
    //   960: invokevirtual 133	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   963: iflt +9 -> 972
    //   966: iconst_1
    //   967: istore 17
    //   969: goto -902 -> 67
    //   972: aload 22
    //   974: ldc_w 440
    //   977: invokevirtual 133	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   980: iflt +9 -> 989
    //   983: iconst_1
    //   984: istore 17
    //   986: goto -919 -> 67
    //   989: iconst_0
    //   990: istore 17
    //   992: goto -925 -> 67
    //   995: aload 22
    //   997: ldc_w 285
    //   1000: invokevirtual 133	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1003: iflt +9 -> 1012
    //   1006: iconst_1
    //   1007: istore 10
    //   1009: goto -904 -> 105
    //   1012: iconst_0
    //   1013: istore 10
    //   1015: goto -910 -> 105
    //   1018: iload 7
    //   1020: istore 8
    //   1022: invokestatic 848	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   1025: invokestatic 949	com/tencent/mm/sdk/platformtools/aq:is2G	(Landroid/content/Context;)Z
    //   1028: ifeq +26 -> 1054
    //   1031: iload 7
    //   1033: istore 8
    //   1035: invokestatic 860	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   1038: ldc_w 875
    //   1041: invokevirtual 867	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1044: bipush 70
    //   1046: invokestatic 871	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   1049: istore 7
    //   1051: goto -862 -> 189
    //   1054: iload 7
    //   1056: istore 8
    //   1058: invokestatic 848	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   1061: invokestatic 952	com/tencent/mm/sdk/platformtools/aq:is3G	(Landroid/content/Context;)Z
    //   1064: ifeq +26 -> 1090
    //   1067: iload 7
    //   1069: istore 8
    //   1071: invokestatic 860	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   1074: ldc_w 877
    //   1077: invokevirtual 867	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1080: bipush 60
    //   1082: invokestatic 871	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   1085: istore 7
    //   1087: goto -898 -> 189
    //   1090: iload 7
    //   1092: istore 8
    //   1094: invokestatic 860	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   1097: ldc_w 879
    //   1100: invokevirtual 867	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1103: bipush 60
    //   1105: invokestatic 871	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   1108: istore 7
    //   1110: goto -921 -> 189
    //   1113: iload 7
    //   1115: istore 8
    //   1117: invokestatic 848	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   1120: invokestatic 854	com/tencent/mm/sdk/platformtools/aq:isWifi	(Landroid/content/Context;)Z
    //   1123: ifeq +27 -> 1150
    //   1126: iload 7
    //   1128: istore 8
    //   1130: invokestatic 860	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   1133: ldc_w 881
    //   1136: invokevirtual 867	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1139: invokestatic 915	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1142: invokevirtual 918	java/lang/Integer:intValue	()I
    //   1145: istore 7
    //   1147: goto -958 -> 189
    //   1150: iload 7
    //   1152: istore 8
    //   1154: invokestatic 848	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   1157: invokestatic 949	com/tencent/mm/sdk/platformtools/aq:is2G	(Landroid/content/Context;)Z
    //   1160: ifeq +27 -> 1187
    //   1163: iload 7
    //   1165: istore 8
    //   1167: invokestatic 860	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   1170: ldc_w 883
    //   1173: invokevirtual 867	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1176: invokestatic 915	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1179: invokevirtual 918	java/lang/Integer:intValue	()I
    //   1182: istore 7
    //   1184: goto -995 -> 189
    //   1187: iload 7
    //   1189: istore 8
    //   1191: invokestatic 860	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   1194: ldc_w 885
    //   1197: invokevirtual 867	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1200: invokestatic 915	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1203: invokevirtual 918	java/lang/Integer:intValue	()I
    //   1206: istore 7
    //   1208: goto -1019 -> 189
    //   1211: iload 12
    //   1213: istore 7
    //   1215: invokestatic 848	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   1218: invokestatic 854	com/tencent/mm/sdk/platformtools/aq:isWifi	(Landroid/content/Context;)Z
    //   1221: ifeq +73 -> 1294
    //   1224: iload 12
    //   1226: istore 7
    //   1228: invokestatic 860	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   1231: ldc_w 954
    //   1234: invokevirtual 867	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1237: astore 22
    //   1239: iload 12
    //   1241: istore 7
    //   1243: aload 22
    //   1245: ldc_w 908
    //   1248: invokevirtual 912	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1251: iconst_0
    //   1252: aaload
    //   1253: invokestatic 915	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1256: invokevirtual 918	java/lang/Integer:intValue	()I
    //   1259: istore 12
    //   1261: iload 12
    //   1263: istore 7
    //   1265: aload 22
    //   1267: ldc_w 908
    //   1270: invokevirtual 912	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1273: iconst_1
    //   1274: aaload
    //   1275: invokestatic 915	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1278: invokevirtual 918	java/lang/Integer:intValue	()I
    //   1281: istore 13
    //   1283: iload 13
    //   1285: istore 8
    //   1287: iload 12
    //   1289: istore 7
    //   1291: goto -797 -> 494
    //   1294: iload 12
    //   1296: istore 7
    //   1298: invokestatic 848	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   1301: invokestatic 949	com/tencent/mm/sdk/platformtools/aq:is2G	(Landroid/content/Context;)Z
    //   1304: ifeq +73 -> 1377
    //   1307: iload 12
    //   1309: istore 7
    //   1311: invokestatic 860	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   1314: ldc_w 956
    //   1317: invokevirtual 867	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1320: astore 22
    //   1322: iload 12
    //   1324: istore 7
    //   1326: aload 22
    //   1328: ldc_w 908
    //   1331: invokevirtual 912	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1334: iconst_0
    //   1335: aaload
    //   1336: invokestatic 915	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1339: invokevirtual 918	java/lang/Integer:intValue	()I
    //   1342: istore 12
    //   1344: iload 12
    //   1346: istore 7
    //   1348: aload 22
    //   1350: ldc_w 908
    //   1353: invokevirtual 912	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1356: iconst_1
    //   1357: aaload
    //   1358: invokestatic 915	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1361: invokevirtual 918	java/lang/Integer:intValue	()I
    //   1364: istore 13
    //   1366: iload 13
    //   1368: istore 8
    //   1370: iload 12
    //   1372: istore 7
    //   1374: goto -880 -> 494
    //   1377: iload 12
    //   1379: istore 7
    //   1381: invokestatic 848	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   1384: invokestatic 952	com/tencent/mm/sdk/platformtools/aq:is3G	(Landroid/content/Context;)Z
    //   1387: ifeq +73 -> 1460
    //   1390: iload 12
    //   1392: istore 7
    //   1394: invokestatic 860	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   1397: ldc_w 958
    //   1400: invokevirtual 867	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1403: astore 22
    //   1405: iload 12
    //   1407: istore 7
    //   1409: aload 22
    //   1411: ldc_w 908
    //   1414: invokevirtual 912	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1417: iconst_0
    //   1418: aaload
    //   1419: invokestatic 915	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1422: invokevirtual 918	java/lang/Integer:intValue	()I
    //   1425: istore 12
    //   1427: iload 12
    //   1429: istore 7
    //   1431: aload 22
    //   1433: ldc_w 908
    //   1436: invokevirtual 912	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1439: iconst_1
    //   1440: aaload
    //   1441: invokestatic 915	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1444: invokevirtual 918	java/lang/Integer:intValue	()I
    //   1447: istore 13
    //   1449: iload 13
    //   1451: istore 8
    //   1453: iload 12
    //   1455: istore 7
    //   1457: goto -963 -> 494
    //   1460: iload 12
    //   1462: istore 7
    //   1464: invokestatic 860	com/tencent/mm/m/g:AA	()Lcom/tencent/mm/m/e;
    //   1467: ldc_w 960
    //   1470: invokevirtual 867	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1473: astore 22
    //   1475: iload 12
    //   1477: istore 7
    //   1479: aload 22
    //   1481: ldc_w 908
    //   1484: invokevirtual 912	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1487: iconst_0
    //   1488: aaload
    //   1489: invokestatic 915	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1492: invokevirtual 918	java/lang/Integer:intValue	()I
    //   1495: istore 12
    //   1497: iload 12
    //   1499: istore 7
    //   1501: aload 22
    //   1503: ldc_w 908
    //   1506: invokevirtual 912	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1509: iconst_1
    //   1510: aaload
    //   1511: invokestatic 915	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1514: invokevirtual 918	java/lang/Integer:intValue	()I
    //   1517: istore 13
    //   1519: iload 13
    //   1521: istore 8
    //   1523: iload 12
    //   1525: istore 7
    //   1527: goto -1033 -> 494
    //   1530: iload 8
    //   1532: sipush 2160
    //   1535: if_icmplt +14 -> 1549
    //   1538: iconst_0
    //   1539: istore 7
    //   1541: sipush 1080
    //   1544: istore 8
    //   1546: goto -972 -> 574
    //   1549: iload 8
    //   1551: ifgt +1493 -> 3044
    //   1554: iload 7
    //   1556: sipush 3240
    //   1559: if_icmple +1485 -> 3044
    //   1562: sipush 1620
    //   1565: istore 7
    //   1567: iconst_0
    //   1568: istore 8
    //   1570: goto -996 -> 574
    //   1573: astore 22
    //   1575: ldc 113
    //   1577: new 59	java/lang/StringBuilder
    //   1580: dup
    //   1581: ldc_w 962
    //   1584: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1587: aload 22
    //   1589: invokevirtual 749	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1592: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1595: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1598: invokestatic 588	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1601: iconst_0
    //   1602: istore 10
    //   1604: goto -888 -> 716
    //   1607: iconst_0
    //   1608: ireturn
    //   1609: new 96	android/graphics/BitmapFactory$Options
    //   1612: dup
    //   1613: invokespecial 97	android/graphics/BitmapFactory$Options:<init>	()V
    //   1616: astore 23
    //   1618: aload 23
    //   1620: invokestatic 965	com/tencent/mm/sdk/platformtools/c:c	(Landroid/graphics/BitmapFactory$Options;)V
    //   1623: aload_1
    //   1624: invokestatic 94	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1627: astore 21
    //   1629: aload 21
    //   1631: invokevirtual 594	java/io/InputStream:markSupported	()Z
    //   1634: ifne +1404 -> 3038
    //   1637: new 596	java/io/BufferedInputStream
    //   1640: dup
    //   1641: aload 21
    //   1643: invokespecial 599	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1646: astore 22
    //   1648: aload 22
    //   1650: astore 21
    //   1652: aload 21
    //   1654: ldc_w 600
    //   1657: invokevirtual 604	java/io/InputStream:mark	(I)V
    //   1660: new 154	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger
    //   1663: dup
    //   1664: invokespecial 155	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:<init>	()V
    //   1667: astore 22
    //   1669: aload 21
    //   1671: aconst_null
    //   1672: aload 23
    //   1674: aload 22
    //   1676: iconst_0
    //   1677: iconst_0
    //   1678: newarray int
    //   1680: invokestatic 107	com/tencent/mm/sdk/platformtools/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;I[I)Landroid/graphics/Bitmap;
    //   1683: astore 23
    //   1685: aload 21
    //   1687: invokevirtual 612	java/io/InputStream:reset	()V
    //   1690: aload 23
    //   1692: ifnonnull +45 -> 1737
    //   1695: aload 22
    //   1697: invokevirtual 162	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:getDecodeResult	()I
    //   1700: sipush 2000
    //   1703: if_icmplt +22 -> 1725
    //   1706: aload_1
    //   1707: bipush 10
    //   1709: aload 22
    //   1711: invokestatic 168	com/tencent/mm/sdk/platformtools/MMBitmapFactory$KVStatHelper:getKVStatString	(Ljava/lang/Object;ILcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;)Ljava/lang/String;
    //   1714: astore_0
    //   1715: getstatic 174	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   1718: sipush 12712
    //   1721: aload_0
    //   1722: invokevirtual 178	com/tencent/mm/plugin/report/service/h:aC	(ILjava/lang/String;)V
    //   1725: aload 21
    //   1727: ifnull +8 -> 1735
    //   1730: aload 21
    //   1732: invokevirtual 138	java/io/InputStream:close	()V
    //   1735: iconst_0
    //   1736: ireturn
    //   1737: iload 10
    //   1739: i2f
    //   1740: fstore 6
    //   1742: aload 23
    //   1744: fload 6
    //   1746: invokestatic 191	com/tencent/mm/sdk/platformtools/c:b	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   1749: iload 9
    //   1751: getstatic 727	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1754: new 59	java/lang/StringBuilder
    //   1757: dup
    //   1758: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1761: aload_0
    //   1762: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1765: aload_2
    //   1766: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1769: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1772: iconst_1
    //   1773: invokestatic 802	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   1776: iload 17
    //   1778: ifeq +181 -> 1959
    //   1781: iload 10
    //   1783: ifne +176 -> 1959
    //   1786: new 59	java/lang/StringBuilder
    //   1789: dup
    //   1790: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1793: aload_0
    //   1794: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1797: aload_2
    //   1798: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1801: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1804: invokestatic 277	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   1807: lstore 19
    //   1809: ldc 113
    //   1811: ldc_w 967
    //   1814: iconst_3
    //   1815: anewarray 199	java/lang/Object
    //   1818: dup
    //   1819: iconst_0
    //   1820: iload 14
    //   1822: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1825: aastore
    //   1826: dup
    //   1827: iconst_1
    //   1828: lload 19
    //   1830: invokestatic 703	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1833: aastore
    //   1834: dup
    //   1835: iconst_2
    //   1836: iload 12
    //   1838: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1841: aastore
    //   1842: invokestatic 203	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1845: iload 14
    //   1847: i2l
    //   1848: lload 19
    //   1850: lsub
    //   1851: ldc2_w 968
    //   1854: lmul
    //   1855: iload 12
    //   1857: iload 14
    //   1859: imul
    //   1860: i2l
    //   1861: lcmp
    //   1862: ifge +85 -> 1947
    //   1865: new 59	java/lang/StringBuilder
    //   1868: dup
    //   1869: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1872: aload_0
    //   1873: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1876: aload_2
    //   1877: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1880: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1883: invokestatic 566	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   1886: pop
    //   1887: aload_1
    //   1888: new 59	java/lang/StringBuilder
    //   1891: dup
    //   1892: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   1895: aload_0
    //   1896: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1899: aload_2
    //   1900: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1903: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1906: invokestatic 557	com/tencent/mm/vfs/e:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   1909: lstore 19
    //   1911: lload 19
    //   1913: lconst_0
    //   1914: lcmp
    //   1915: iflt +26 -> 1941
    //   1918: iconst_1
    //   1919: istore 17
    //   1921: iload 17
    //   1923: istore_3
    //   1924: aload 21
    //   1926: ifnull -973 -> 953
    //   1929: aload 21
    //   1931: invokevirtual 138	java/io/InputStream:close	()V
    //   1934: iload 17
    //   1936: ireturn
    //   1937: astore_0
    //   1938: iload 17
    //   1940: ireturn
    //   1941: iconst_0
    //   1942: istore 17
    //   1944: goto -23 -> 1921
    //   1947: aload 21
    //   1949: ifnull +8 -> 1957
    //   1952: aload 21
    //   1954: invokevirtual 138	java/io/InputStream:close	()V
    //   1957: iconst_1
    //   1958: ireturn
    //   1959: aload 21
    //   1961: ifnull +8 -> 1969
    //   1964: aload 21
    //   1966: invokevirtual 138	java/io/InputStream:close	()V
    //   1969: iconst_1
    //   1970: ireturn
    //   1971: astore_2
    //   1972: aconst_null
    //   1973: astore_0
    //   1974: ldc 113
    //   1976: aload_2
    //   1977: new 59	java/lang/StringBuilder
    //   1980: dup
    //   1981: ldc_w 971
    //   1984: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1987: aload_1
    //   1988: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1991: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1994: iconst_0
    //   1995: anewarray 199	java/lang/Object
    //   1998: invokestatic 583	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2001: aload_0
    //   2002: ifnull +7 -> 2009
    //   2005: aload_0
    //   2006: invokevirtual 138	java/io/InputStream:close	()V
    //   2009: iconst_0
    //   2010: ireturn
    //   2011: astore_1
    //   2012: aconst_null
    //   2013: astore_0
    //   2014: aload_0
    //   2015: ifnull +7 -> 2022
    //   2018: aload_0
    //   2019: invokevirtual 138	java/io/InputStream:close	()V
    //   2022: aload_1
    //   2023: athrow
    //   2024: ldc 113
    //   2026: new 59	java/lang/StringBuilder
    //   2029: dup
    //   2030: ldc_w 973
    //   2033: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2036: aload 21
    //   2038: getfield 149	android/graphics/BitmapFactory$Options:outWidth	I
    //   2041: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2044: ldc_w 930
    //   2047: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2050: aload 21
    //   2052: getfield 152	android/graphics/BitmapFactory$Options:outHeight	I
    //   2055: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2058: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2061: invokestatic 234	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2064: aload 21
    //   2066: getfield 152	android/graphics/BitmapFactory$Options:outHeight	I
    //   2069: ifgt +9 -> 2078
    //   2072: aload 21
    //   2074: iconst_1
    //   2075: putfield 152	android/graphics/BitmapFactory$Options:outHeight	I
    //   2078: aload 21
    //   2080: getfield 149	android/graphics/BitmapFactory$Options:outWidth	I
    //   2083: ifgt +9 -> 2092
    //   2086: aload 21
    //   2088: iconst_1
    //   2089: putfield 149	android/graphics/BitmapFactory$Options:outWidth	I
    //   2092: aload 21
    //   2094: getfield 149	android/graphics/BitmapFactory$Options:outWidth	I
    //   2097: aload 21
    //   2099: getfield 152	android/graphics/BitmapFactory$Options:outHeight	I
    //   2102: if_icmple +123 -> 2225
    //   2105: aload 21
    //   2107: getfield 149	android/graphics/BitmapFactory$Options:outWidth	I
    //   2110: aload 21
    //   2112: getfield 152	android/graphics/BitmapFactory$Options:outHeight	I
    //   2115: idiv
    //   2116: istore 7
    //   2118: iload 7
    //   2120: istore 8
    //   2122: iload 7
    //   2124: ifne +6 -> 2130
    //   2127: iconst_1
    //   2128: istore 8
    //   2130: ldc_w 944
    //   2133: iload 8
    //   2135: idiv
    //   2136: i2d
    //   2137: invokestatic 976	java/lang/Math:sqrt	(D)D
    //   2140: d2i
    //   2141: istore 7
    //   2143: aload 21
    //   2145: getfield 149	android/graphics/BitmapFactory$Options:outWidth	I
    //   2148: aload 21
    //   2150: getfield 152	android/graphics/BitmapFactory$Options:outHeight	I
    //   2153: if_icmple +88 -> 2241
    //   2156: iload 7
    //   2158: iload 8
    //   2160: imul
    //   2161: istore 10
    //   2163: ldc 113
    //   2165: new 59	java/lang/StringBuilder
    //   2168: dup
    //   2169: ldc_w 978
    //   2172: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2175: iload 10
    //   2177: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2180: ldc_w 930
    //   2183: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2186: iload 7
    //   2188: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2191: ldc_w 930
    //   2194: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2197: iload 8
    //   2199: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2202: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2205: invokestatic 234	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2208: aload_1
    //   2209: iload 7
    //   2211: iload 10
    //   2213: getstatic 727	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   2216: iload 9
    //   2218: aload_0
    //   2219: aload_2
    //   2220: iload_3
    //   2221: invokestatic 980	com/tencent/mm/plugin/sns/storage/s:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   2224: ireturn
    //   2225: aload 21
    //   2227: getfield 152	android/graphics/BitmapFactory$Options:outHeight	I
    //   2230: aload 21
    //   2232: getfield 149	android/graphics/BitmapFactory$Options:outWidth	I
    //   2235: idiv
    //   2236: istore 7
    //   2238: goto -120 -> 2118
    //   2241: iload 7
    //   2243: iload 8
    //   2245: imul
    //   2246: istore 11
    //   2248: iload 7
    //   2250: istore 10
    //   2252: iload 11
    //   2254: istore 7
    //   2256: goto -93 -> 2163
    //   2259: iload 14
    //   2261: iload 15
    //   2263: if_icmpge +67 -> 2330
    //   2266: iload 17
    //   2268: ifeq +62 -> 2330
    //   2271: iload 10
    //   2273: ifne +57 -> 2330
    //   2276: ldc 113
    //   2278: new 59	java/lang/StringBuilder
    //   2281: dup
    //   2282: ldc_w 982
    //   2285: invokespecial 118	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2288: iload 15
    //   2290: invokevirtual 384	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2293: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2296: invokestatic 234	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2299: aload_1
    //   2300: new 59	java/lang/StringBuilder
    //   2303: dup
    //   2304: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   2307: aload_0
    //   2308: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2311: aload_2
    //   2312: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2315: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2318: invokestatic 557	com/tencent/mm/vfs/e:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   2321: lconst_0
    //   2322: lcmp
    //   2323: iflt +5 -> 2328
    //   2326: iconst_1
    //   2327: ireturn
    //   2328: iconst_0
    //   2329: ireturn
    //   2330: aload 21
    //   2332: getfield 149	android/graphics/BitmapFactory$Options:outWidth	I
    //   2335: aload 21
    //   2337: getfield 152	android/graphics/BitmapFactory$Options:outHeight	I
    //   2340: if_icmple +157 -> 2497
    //   2343: aload 21
    //   2345: getfield 149	android/graphics/BitmapFactory$Options:outWidth	I
    //   2348: istore 11
    //   2350: aload 21
    //   2352: getfield 149	android/graphics/BitmapFactory$Options:outWidth	I
    //   2355: aload 21
    //   2357: getfield 152	android/graphics/BitmapFactory$Options:outHeight	I
    //   2360: if_icmpge +147 -> 2507
    //   2363: aload 21
    //   2365: getfield 149	android/graphics/BitmapFactory$Options:outWidth	I
    //   2368: istore 13
    //   2370: iload 8
    //   2372: ifle +10 -> 2382
    //   2375: iload 13
    //   2377: iload 8
    //   2379: if_icmple +15 -> 2394
    //   2382: iload 8
    //   2384: ifgt +355 -> 2739
    //   2387: iload 11
    //   2389: iload 7
    //   2391: if_icmpgt +348 -> 2739
    //   2394: ldc 113
    //   2396: ldc_w 984
    //   2399: iconst_3
    //   2400: anewarray 199	java/lang/Object
    //   2403: dup
    //   2404: iconst_0
    //   2405: iload 14
    //   2407: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2410: aastore
    //   2411: dup
    //   2412: iconst_1
    //   2413: aload 21
    //   2415: getfield 149	android/graphics/BitmapFactory$Options:outWidth	I
    //   2418: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2421: aastore
    //   2422: dup
    //   2423: iconst_2
    //   2424: aload 21
    //   2426: getfield 152	android/graphics/BitmapFactory$Options:outHeight	I
    //   2429: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2432: aastore
    //   2433: invokestatic 203	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2436: aload_1
    //   2437: invokestatic 277	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   2440: ldc2_w 985
    //   2443: lcmp
    //   2444: ifge +120 -> 2564
    //   2447: iload 17
    //   2449: ifeq +70 -> 2519
    //   2452: ldc 113
    //   2454: ldc_w 988
    //   2457: iconst_1
    //   2458: anewarray 199	java/lang/Object
    //   2461: dup
    //   2462: iconst_0
    //   2463: aload_1
    //   2464: aastore
    //   2465: invokestatic 203	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2468: aload_1
    //   2469: new 59	java/lang/StringBuilder
    //   2472: dup
    //   2473: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   2476: aload_0
    //   2477: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2480: aload_2
    //   2481: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2484: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2487: invokestatic 557	com/tencent/mm/vfs/e:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   2490: lconst_0
    //   2491: lcmp
    //   2492: iflt +25 -> 2517
    //   2495: iconst_1
    //   2496: ireturn
    //   2497: aload 21
    //   2499: getfield 152	android/graphics/BitmapFactory$Options:outHeight	I
    //   2502: istore 11
    //   2504: goto -154 -> 2350
    //   2507: aload 21
    //   2509: getfield 152	android/graphics/BitmapFactory$Options:outHeight	I
    //   2512: istore 13
    //   2514: goto -144 -> 2370
    //   2517: iconst_0
    //   2518: ireturn
    //   2519: aload 21
    //   2521: getfield 149	android/graphics/BitmapFactory$Options:outWidth	I
    //   2524: sipush 150
    //   2527: if_icmpge +37 -> 2564
    //   2530: aload 21
    //   2532: getfield 152	android/graphics/BitmapFactory$Options:outHeight	I
    //   2535: sipush 150
    //   2538: if_icmpge +26 -> 2564
    //   2541: aload_1
    //   2542: aload 21
    //   2544: getfield 152	android/graphics/BitmapFactory$Options:outHeight	I
    //   2547: aload 21
    //   2549: getfield 149	android/graphics/BitmapFactory$Options:outWidth	I
    //   2552: getstatic 722	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   2555: iload 9
    //   2557: aload_0
    //   2558: aload_2
    //   2559: iload_3
    //   2560: invokestatic 980	com/tencent/mm/plugin/sns/storage/s:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   2563: ireturn
    //   2564: aload_1
    //   2565: aload 21
    //   2567: getfield 152	android/graphics/BitmapFactory$Options:outHeight	I
    //   2570: aload 21
    //   2572: getfield 149	android/graphics/BitmapFactory$Options:outWidth	I
    //   2575: getstatic 727	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   2578: iload 9
    //   2580: aload_0
    //   2581: aload_2
    //   2582: iload_3
    //   2583: invokestatic 980	com/tencent/mm/plugin/sns/storage/s:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   2586: istore 18
    //   2588: iload 18
    //   2590: istore_3
    //   2591: iload 17
    //   2593: ifeq -1640 -> 953
    //   2596: iload 18
    //   2598: istore_3
    //   2599: iload 10
    //   2601: ifne -1648 -> 953
    //   2604: new 59	java/lang/StringBuilder
    //   2607: dup
    //   2608: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   2611: aload_0
    //   2612: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2615: aload_2
    //   2616: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2619: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2622: invokestatic 277	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   2625: lstore 19
    //   2627: ldc 113
    //   2629: ldc_w 967
    //   2632: iconst_3
    //   2633: anewarray 199	java/lang/Object
    //   2636: dup
    //   2637: iconst_0
    //   2638: iload 14
    //   2640: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2643: aastore
    //   2644: dup
    //   2645: iconst_1
    //   2646: lload 19
    //   2648: invokestatic 703	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2651: aastore
    //   2652: dup
    //   2653: iconst_2
    //   2654: iload 12
    //   2656: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2659: aastore
    //   2660: invokestatic 203	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2663: iload 18
    //   2665: istore_3
    //   2666: iload 14
    //   2668: i2l
    //   2669: lload 19
    //   2671: lsub
    //   2672: ldc2_w 968
    //   2675: lmul
    //   2676: iload 12
    //   2678: iload 14
    //   2680: imul
    //   2681: i2l
    //   2682: lcmp
    //   2683: ifge -1730 -> 953
    //   2686: new 59	java/lang/StringBuilder
    //   2689: dup
    //   2690: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   2693: aload_0
    //   2694: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2697: aload_2
    //   2698: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2701: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2704: invokestatic 566	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   2707: pop
    //   2708: aload_1
    //   2709: new 59	java/lang/StringBuilder
    //   2712: dup
    //   2713: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   2716: aload_0
    //   2717: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2720: aload_2
    //   2721: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2724: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2727: invokestatic 557	com/tencent/mm/vfs/e:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   2730: lconst_0
    //   2731: lcmp
    //   2732: iflt +5 -> 2737
    //   2735: iconst_1
    //   2736: ireturn
    //   2737: iconst_0
    //   2738: ireturn
    //   2739: iload 8
    //   2741: ifle +177 -> 2918
    //   2744: aload_1
    //   2745: aload 21
    //   2747: getfield 149	android/graphics/BitmapFactory$Options:outWidth	I
    //   2750: aload 21
    //   2752: getfield 152	android/graphics/BitmapFactory$Options:outHeight	I
    //   2755: iload 8
    //   2757: getstatic 727	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   2760: iload 9
    //   2762: aload_0
    //   2763: aload_2
    //   2764: invokestatic 990	com/tencent/mm/plugin/sns/storage/s:a	(Ljava/lang/String;IIILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;)Z
    //   2767: istore 18
    //   2769: iload 18
    //   2771: istore_3
    //   2772: iload 17
    //   2774: ifeq -1821 -> 953
    //   2777: iload 18
    //   2779: istore_3
    //   2780: iload 10
    //   2782: ifne -1829 -> 953
    //   2785: new 59	java/lang/StringBuilder
    //   2788: dup
    //   2789: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   2792: aload_0
    //   2793: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2796: aload_2
    //   2797: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2800: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2803: invokestatic 277	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
    //   2806: lstore 19
    //   2808: ldc 113
    //   2810: ldc_w 967
    //   2813: iconst_3
    //   2814: anewarray 199	java/lang/Object
    //   2817: dup
    //   2818: iconst_0
    //   2819: iload 14
    //   2821: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2824: aastore
    //   2825: dup
    //   2826: iconst_1
    //   2827: lload 19
    //   2829: invokestatic 703	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2832: aastore
    //   2833: dup
    //   2834: iconst_2
    //   2835: iload 12
    //   2837: invokestatic 627	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2840: aastore
    //   2841: invokestatic 203	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2844: iload 18
    //   2846: istore_3
    //   2847: iload 14
    //   2849: i2l
    //   2850: lload 19
    //   2852: lsub
    //   2853: ldc2_w 968
    //   2856: lmul
    //   2857: iload 12
    //   2859: iload 14
    //   2861: imul
    //   2862: i2l
    //   2863: lcmp
    //   2864: ifge -1911 -> 953
    //   2867: new 59	java/lang/StringBuilder
    //   2870: dup
    //   2871: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   2874: aload_0
    //   2875: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2878: aload_2
    //   2879: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2882: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2885: invokestatic 566	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   2888: pop
    //   2889: aload_1
    //   2890: new 59	java/lang/StringBuilder
    //   2893: dup
    //   2894: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   2897: aload_0
    //   2898: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2901: aload_2
    //   2902: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2905: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2908: invokestatic 557	com/tencent/mm/vfs/e:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   2911: lconst_0
    //   2912: lcmp
    //   2913: iflt +57 -> 2970
    //   2916: iconst_1
    //   2917: ireturn
    //   2918: iload 11
    //   2920: i2d
    //   2921: dconst_1
    //   2922: dmul
    //   2923: iload 7
    //   2925: i2d
    //   2926: ddiv
    //   2927: dstore 4
    //   2929: aload 21
    //   2931: getfield 149	android/graphics/BitmapFactory$Options:outWidth	I
    //   2934: i2d
    //   2935: dload 4
    //   2937: ddiv
    //   2938: d2i
    //   2939: istore 7
    //   2941: aload_1
    //   2942: aload 21
    //   2944: getfield 152	android/graphics/BitmapFactory$Options:outHeight	I
    //   2947: i2d
    //   2948: dload 4
    //   2950: ddiv
    //   2951: d2i
    //   2952: iload 7
    //   2954: getstatic 727	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   2957: iload 9
    //   2959: aload_0
    //   2960: aload_2
    //   2961: iload_3
    //   2962: invokestatic 980	com/tencent/mm/plugin/sns/storage/s:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   2965: istore 18
    //   2967: goto -198 -> 2769
    //   2970: iconst_0
    //   2971: ireturn
    //   2972: astore_0
    //   2973: goto -1238 -> 1735
    //   2976: astore_0
    //   2977: goto -1020 -> 1957
    //   2980: astore_0
    //   2981: goto -1012 -> 1969
    //   2984: astore_0
    //   2985: goto -976 -> 2009
    //   2988: astore_0
    //   2989: goto -967 -> 2022
    //   2992: astore_1
    //   2993: aload 21
    //   2995: astore_0
    //   2996: goto -982 -> 2014
    //   2999: astore_1
    //   3000: aload 21
    //   3002: astore_0
    //   3003: goto -989 -> 2014
    //   3006: astore_1
    //   3007: goto -993 -> 2014
    //   3010: astore_2
    //   3011: aload 21
    //   3013: astore_0
    //   3014: goto -1040 -> 1974
    //   3017: astore_2
    //   3018: aload 21
    //   3020: astore_0
    //   3021: goto -1047 -> 1974
    //   3024: astore 22
    //   3026: goto -2532 -> 494
    //   3029: astore 22
    //   3031: iload 8
    //   3033: istore 7
    //   3035: goto -2744 -> 291
    //   3038: goto -1386 -> 1652
    //   3041: goto -2359 -> 682
    //   3044: goto -2470 -> 574
    //   3047: iload 8
    //   3049: istore 11
    //   3051: iload 7
    //   3053: istore 9
    //   3055: goto -2686 -> 369
    //   3058: iload 7
    //   3060: istore 9
    //   3062: goto -2693 -> 369
    //   3065: goto -2729 -> 336
    //   3068: bipush 100
    //   3070: istore 9
    //   3072: goto -2703 -> 369
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3075	0	paramString1	String
    //   0	3075	1	paramString2	String
    //   0	3075	2	paramString3	String
    //   0	3075	3	paramBoolean	boolean
    //   2927	22	4	d	double
    //   1740	5	6	f	float
    //   110	2949	7	i	int
    //   118	2930	8	j	int
    //   363	2708	9	k	int
    //   103	2678	10	m	int
    //   106	2944	11	n	int
    //   419	2443	12	i1	int
    //   484	2029	13	i2	int
    //   374	2488	14	i3	int
    //   609	1680	15	i4	int
    //   648	266	16	i5	int
    //   65	2708	17	bool1	boolean
    //   2586	380	18	bool2	boolean
    //   1807	1044	19	l	long
    //   4	3015	21	localObject1	Object
    //   16	1486	22	localObject2	Object
    //   1573	15	22	localException1	Exception
    //   1646	64	22	localObject3	Object
    //   3024	1	22	localException2	Exception
    //   3029	1	22	localException3	Exception
    //   1616	127	23	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   690	696	1573	java/lang/Exception
    //   705	716	1573	java/lang/Exception
    //   1929	1934	1937	java/io/IOException
    //   1623	1629	1971	java/io/IOException
    //   1623	1629	2011	finally
    //   1730	1735	2972	java/io/IOException
    //   1952	1957	2976	java/io/IOException
    //   1964	1969	2980	java/io/IOException
    //   2005	2009	2984	java/io/IOException
    //   2018	2022	2988	java/io/IOException
    //   1629	1648	2992	finally
    //   1652	1690	2999	finally
    //   1695	1725	2999	finally
    //   1742	1776	2999	finally
    //   1786	1845	2999	finally
    //   1865	1911	2999	finally
    //   1974	2001	3006	finally
    //   1629	1648	3010	java/io/IOException
    //   1652	1690	3017	java/io/IOException
    //   1695	1725	3017	java/io/IOException
    //   1742	1776	3017	java/io/IOException
    //   1786	1845	3017	java/io/IOException
    //   1865	1911	3017	java/io/IOException
    //   431	442	3024	java/lang/Exception
    //   446	464	3024	java/lang/Exception
    //   468	486	3024	java/lang/Exception
    //   1215	1224	3024	java/lang/Exception
    //   1228	1239	3024	java/lang/Exception
    //   1243	1261	3024	java/lang/Exception
    //   1265	1283	3024	java/lang/Exception
    //   1298	1307	3024	java/lang/Exception
    //   1311	1322	3024	java/lang/Exception
    //   1326	1344	3024	java/lang/Exception
    //   1348	1366	3024	java/lang/Exception
    //   1381	1390	3024	java/lang/Exception
    //   1394	1405	3024	java/lang/Exception
    //   1409	1427	3024	java/lang/Exception
    //   1431	1449	3024	java/lang/Exception
    //   1464	1475	3024	java/lang/Exception
    //   1479	1497	3024	java/lang/Exception
    //   1501	1519	3024	java/lang/Exception
    //   120	124	3029	java/lang/Exception
    //   128	136	3029	java/lang/Exception
    //   140	146	3029	java/lang/Exception
    //   150	156	3029	java/lang/Exception
    //   160	169	3029	java/lang/Exception
    //   173	189	3029	java/lang/Exception
    //   193	291	3029	java/lang/Exception
    //   1022	1031	3029	java/lang/Exception
    //   1035	1051	3029	java/lang/Exception
    //   1058	1067	3029	java/lang/Exception
    //   1071	1087	3029	java/lang/Exception
    //   1094	1110	3029	java/lang/Exception
    //   1117	1126	3029	java/lang/Exception
    //   1130	1147	3029	java/lang/Exception
    //   1154	1163	3029	java/lang/Exception
    //   1167	1184	3029	java/lang/Exception
    //   1191	1208	3029	java/lang/Exception
  }
  
  public static void dT(int paramInt1, int paramInt2)
  {
    olc = paramInt1;
    oki = paramInt2;
    y.i("MicroMsg.snsMediaStorage", "SCREEN %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static int getScreenWidth()
  {
    if (olc > oki) {
      return oki;
    }
    return olc;
  }
  
  public final r OQ(String paramString)
  {
    r localr = new r();
    paramString = this.dXo.a("SnsMedia", null, "StrId=?", new String[] { paramString }, null, null, null, 2);
    if (paramString.moveToFirst())
    {
      localr.d(paramString);
      paramString.close();
      return localr;
    }
    paramString.close();
    return null;
  }
  
  public final int a(int paramInt, r paramr)
  {
    paramr = paramr.bGY();
    return this.dXo.update("SnsMedia", paramr, "local_id=?", new String[] { String.valueOf(paramInt) });
  }
  
  public final com.tencent.mm.plugin.sns.data.h a(com.tencent.mm.plugin.sns.data.h paramh, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    r localr = new r();
    localr.createTime = ((int)bk.UX());
    localr.type = paramh.type;
    awg localawg = new awg();
    localawg.trR = paramh.onb;
    localawg.tsm = paramh.ona;
    localawg.token = paramh.ond;
    localawg.tsv = paramh.one;
    localawg.tsJ = 0;
    localawg.tsI = new awa();
    localawg.ebp = 0;
    localawg.kRN = paramh.desc;
    y.d("MicroMsg.snsMediaStorage", "upload.filterId " + paramh.filterId);
    localawg.tsl = paramh.filterId;
    localawg.tsL = 2;
    localawg.videoPath = paramString1;
    localawg.tsN = paramString2;
    localawg.bIW = paramh.onf;
    for (;;)
    {
      try
      {
        localr.oLV = localawg.toByteArray();
        localr.bGZ();
        i = (int)this.dXo.insert("SnsMedia", "local_id", localr.bGY());
        str1 = "Locall_path" + i;
        y.d("MicroMsg.snsMediaStorage", "insert localId " + i);
        String str2 = i.MV(str1);
        String str3 = i.MW(str1);
        String str4 = i.MU(str1);
        String str5 = i.MX(str1);
        String str6 = OP(str1);
        e.nb(str6);
        e.r(paramString2, str6 + str2);
        e.r(paramString2, str6 + str3);
        e.r(paramString2, str6 + str4);
        e.r(paramString1, str6 + str5);
        localawg.videoPath = (str6 + str5);
        localawg.tsN = (str6 + str3);
        localawg.bIW = paramh.onf;
      }
      catch (Exception localException)
      {
        try
        {
          int i;
          String str1;
          localr.oLV = localawg.toByteArray();
          localr.oLR = str1;
          if ((TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4)))
          {
            a(i, localr);
            paramh = a(paramh, localawg.tsN);
            paramh.onc = i;
            return paramh;
            localException = localException;
            y.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
          }
        }
        catch (Exception paramString2)
        {
          y.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
          continue;
          paramString2 = new awa();
          paramString2.hQR = 1;
          paramString2.kSC = paramString3;
          localawg.tsI = paramString2;
          localawg.tsL = 0;
          f.Ne();
          localawg.tsk = com.tencent.mm.ak.a.lH(paramString1);
          if (!bk.bl(paramString4))
          {
            paramString1 = new awa();
            paramString1.hQR = 1;
            paramString1.kSC = paramString4;
            localawg.tsK.add(paramString1);
          }
        }
      }
      try
      {
        localr.oLV = localawg.toByteArray();
        localr.bHa();
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.snsMediaStorage", paramString1, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean a(String paramString, r paramr)
  {
    y.d("MicroMsg.snsMediaStorage", "replace AlbumLikeList " + paramString);
    Cursor localCursor = this.dXo.a("SnsMedia", null, "StrId=?", new String[] { paramString }, null, null, null, 2);
    if (localCursor.moveToFirst())
    {
      localCursor.close();
      y.d("MicroMsg.snsMediaStorage", "snsMedia Insert");
      if (paramr != null)
      {
        paramString = paramr.bGY();
        if ((int)this.dXo.insert("SnsMedia", "local_id", paramString) != -1) {
          return true;
        }
      }
      return false;
    }
    localCursor.close();
    paramr = paramr.bGY();
    return this.dXo.update("SnsMedia", paramr, "StrId=?", new String[] { paramString }) > 0;
  }
  
  public final List<com.tencent.mm.plugin.sns.data.h> cC(List<com.tencent.mm.plugin.sns.data.h> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    if ((paramList == null) || (paramList.size() == 0)) {
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.sns.data.h localh1 = (com.tencent.mm.plugin.sns.data.h)paramList.next();
      int i = a(localh1);
      if (i == -1) {
        return null;
      }
      com.tencent.mm.plugin.sns.data.h localh2 = new com.tencent.mm.plugin.sns.data.h(i, localh1.type);
      localh2.height = localh1.height;
      localh2.width = localh1.width;
      localh2.fileSize = localh1.fileSize;
      localLinkedList.add(localh2);
    }
    return localLinkedList;
  }
  
  public final r gu(long paramLong)
  {
    r localr = new r();
    Cursor localCursor = this.dXo.a("SnsMedia", null, "local_id=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      return null;
    }
    localr.d(localCursor);
    localCursor.close();
    return localr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.s
 * JD-Core Version:    0.7.0.1
 */