package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.f;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.memory.l;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.p;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.j.d.a;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.protocal.protobuf.byi;
import com.tencent.mm.protocal.protobuf.byq;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.e;
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

public final class u
  extends k
{
  public static final String[] SQL_CREATE;
  private static Point hqz;
  private static int yXO;
  private static int yYH;
  public h hHS;
  
  static
  {
    AppMethodBeat.i(97620);
    SQL_CREATE = new String[] { "CREATE TABLE IF NOT EXISTS SnsMedia ( local_id INTEGER PRIMARY KEY, seqId LONG, type INT, createTime LONG, userName VARCHAR(40), totallen INT, offset INT, local_flag INT, tmp_path TEXT, nums INT, try_times INT, StrId VARCHAR(40), upload_buf TEXT, reserved1 INT, reserved2 TEXT, reserved3 TEXT, reserved4 TEXT, reserved5 TEXT )", "CREATE INDEX IF NOT EXISTS serverSnsMediaTimeIndex ON SnsMedia ( createTime )" };
    yYH = 0;
    yXO = 0;
    hqz = new Point();
    AppMethodBeat.o(97620);
  }
  
  public u(h paramh)
  {
    this.hHS = paramh;
  }
  
  private int a(p paramp)
  {
    AppMethodBeat.i(97607);
    localObject1 = ag.getAccSnsPath();
    str2 = ag.getAccSnsTmpPath();
    ad.i("MicroMsg.snsMediaStorage", "SnsMediaStorage %s %s", new Object[] { localObject1, str2 });
    l = System.currentTimeMillis();
    str1 = paramp.path;
    i = paramp.type;
    if (!com.tencent.mm.vfs.i.fv(str1))
    {
      AppMethodBeat.o(97607);
      return -1;
    }
    str4 = com.tencent.mm.b.g.getMessageDigest((str1 + System.currentTimeMillis()).getBytes());
    str3 = q.axV(str4);
    ad.d("MicroMsg.snsMediaStorage", "insert : original img path = ".concat(String.valueOf(str1)));
    if (!com.tencent.mm.vfs.i.fv(str2))
    {
      ad.i("MicroMsg.snsMediaStorage", "create snstmp path ".concat(String.valueOf(str2)));
      com.tencent.mm.vfs.i.aYg(str2);
    }
    if (!com.tencent.mm.vfs.i.fv((String)localObject1))
    {
      ad.i("MicroMsg.snsMediaStorage", "create snsPath ".concat(String.valueOf(localObject1)));
      com.tencent.mm.vfs.i.aYg((String)localObject1);
    }
    localObject2 = new com.tencent.mm.plugin.image.b();
    localObject3 = a(paramp, str1);
    j = ((p)localObject3).width;
    int k = ((p)localObject3).height;
    int m = ((p)localObject3).fileSize;
    ((com.tencent.mm.plugin.image.b)localObject2).uJq = str1;
    ((com.tencent.mm.plugin.image.b)localObject2).uJs = j;
    ((com.tencent.mm.plugin.image.b)localObject2).uJt = k;
    ((com.tencent.mm.plugin.image.b)localObject2).uJu = m;
    if (!d(str2, str1, str3, true))
    {
      AppMethodBeat.o(97607);
      return -1;
    }
    ad.d("MicroMsg.snsMediaStorage", "insert0 " + (System.currentTimeMillis() - l));
    ad.d("MicroMsg.snsMediaStorage", "insert: compressed bigMediaPath = ".concat(String.valueOf(str3)));
    str1 = str2 + str3;
    j = (int)com.tencent.mm.vfs.i.aYo(str1);
    if (q.ans(str1) == 2)
    {
      localObject4 = com.tencent.mm.sdk.platformtools.g.cs(com.tencent.mm.vfs.i.aY(str1, 0, j));
      if (localObject4 != null) {
        ad.i("MicroMsg.snsMediaStorage", "insert yuvInfo:%s", new Object[] { localObject4 });
      }
    }
    try
    {
      localObject1 = com.tencent.mm.vfs.i.k(str1, false);
      paramp = (p)localObject1;
      if (localObject1 == null) {
        paramp = str1;
      }
      paramp = new android.support.e.a(paramp);
      paramp.setAttribute("UserComment", (String)localObject4);
      paramp.saveAttributes();
    }
    catch (Exception paramp)
    {
      try
      {
        ((t)localObject1).zNr = paramp.toByteArray();
        ((t)localObject1).dZi();
        ((t)localObject1).zNm = j;
        ad.i("MicroMsg.snsMediaStorage", "insert a local snsMedia  totallen  :" + j + " filepath: " + str2 + str3);
        i = (int)this.hHS.a("SnsMedia", "local_id", ((t)localObject1).dZh());
        ad.d("MicroMsg.snsMediaStorage", "insert localId ".concat(String.valueOf(i)));
        str4 = "Locall_path".concat(String.valueOf(i));
        ((com.tencent.mm.plugin.image.b)localObject2).uJr = String.valueOf(i);
        ((com.tencent.mm.plugin.image.b)localObject2).md5 = paramp.md5;
        localObject3 = Exif.fromFile(((com.tencent.mm.plugin.image.b)localObject2).uJq);
        j = com.tencent.mm.plugin.image.b.ans(((com.tencent.mm.plugin.image.b)localObject2).uJq);
        paramp = ((Exif)localObject3).dateTimeOriginal;
        localObject4 = ((com.tencent.mm.plugin.image.b)localObject2).uJq;
        if (bt.isNullOrNil(paramp)) {
          break label1924;
        }
        paramp = com.tencent.mm.plugin.image.b.ant(paramp);
        localObject4 = new com.tencent.mm.modelsns.g();
        ((com.tencent.mm.modelsns.g)localObject4).m("20 localID", ((com.tencent.mm.plugin.image.b)localObject2).uJr + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("21 MediaType", j + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("22 OriginWidth", ((com.tencent.mm.plugin.image.b)localObject2).uJs + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("23 OriginHeight", ((com.tencent.mm.plugin.image.b)localObject2).uJt + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("24 CompressedWidth", ((com.tencent.mm.plugin.image.b)localObject2).uJv + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("25 CompressedHeight", ((com.tencent.mm.plugin.image.b)localObject2).uJw + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("26 OriginSize", ((com.tencent.mm.plugin.image.b)localObject2).uJu + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("27 CompressedSize", ((com.tencent.mm.plugin.image.b)localObject2).uJx + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("28 FNumber", ((Exif)localObject3).fNumber + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("29 ExposureTime", ((Exif)localObject3).exposureTime + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("30 ISO", ((Exif)localObject3).isoSpeedRatings + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("31 Flash", ((Exif)localObject3).flash + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("32 LensModel", com.tencent.mm.plugin.image.b.ant(((Exif)localObject3).model) + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("33 CreatTime", paramp + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("34 IsFromWeChat", "0,");
        ((com.tencent.mm.modelsns.g)localObject4).m("35 Scene", ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("36 sceneType", ((Exif)localObject3).sceneType + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("37 fileSource", ((Exif)localObject3).fileSource + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("38 make", ((Exif)localObject3).make + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("39 software", ((Exif)localObject3).software + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("40 fileExt", com.tencent.mm.plugin.image.b.ZF(((com.tencent.mm.plugin.image.b)localObject2).uJq) + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("41 faceCount", "0,");
        ((com.tencent.mm.modelsns.g)localObject4).m("42 YCbCrSubSampling", ((Exif)localObject3).yCbCrSubSampling + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("43 md5", ((com.tencent.mm.plugin.image.b)localObject2).md5 + ',');
        ad.v("MicroMsg.ImgExtInfoReport", "report logbuffer MMImageExifInfo(14525): %s, orgPath:%s", new Object[] { ((com.tencent.mm.modelsns.g)localObject4).RE(), ((com.tencent.mm.plugin.image.b)localObject2).uJq });
        com.tencent.mm.plugin.report.service.g.yhR.f(14525, new Object[] { localObject4 });
        paramp = ((com.tencent.mm.modelsns.g)localObject4).toString();
        localObject2 = com.tencent.mm.plugin.sns.j.d.dVD();
        j = com.tencent.mm.plugin.image.b.ans(str1);
        ((com.tencent.mm.plugin.sns.j.d)localObject2).ztu.put(Integer.valueOf(i), new d.a((com.tencent.mm.plugin.sns.j.d)localObject2, j, paramp));
        paramp = q.axV(str4);
        str1 = aAr(str4);
        com.tencent.mm.vfs.i.aYg(str1);
        ad.i("MicroMsg.snsMediaStorage", "checkcntpath ".concat(String.valueOf(str1)));
        com.tencent.mm.vfs.i.mz(str2 + str3, str1 + paramp);
        str2 = str1 + q.axR(str4);
        str3 = str1 + q.axS(str4);
        com.tencent.mm.vfs.i.deleteFile(str2);
        com.tencent.mm.vfs.i.deleteFile(str3);
        ad.i("MicroMsg.snsMediaStorage", "insert done " + (System.currentTimeMillis() - l) + " targetPath : " + str1 + paramp + " totalLen:" + com.tencent.mm.vfs.i.aYo(new StringBuilder().append(str1).append(paramp).toString()) + "  now delete...:" + str2 + " & " + str3);
        ((t)localObject1).zNn = str4;
        a(i, (t)localObject1);
        AppMethodBeat.o(97607);
        return i;
        paramp = paramp;
        ad.printErrStackTrace("MicroMsg.snsMediaStorage", paramp, "", new Object[0]);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
          continue;
          paramp = com.tencent.mm.plugin.image.b.ant(new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(new Date(new e((String)localObject4).lastModified())));
        }
      }
    }
    j = (int)com.tencent.mm.vfs.i.aYo(str2 + str3);
    localObject3 = a((p)localObject3, str2 + str3);
    k = ((p)localObject3).width;
    m = ((p)localObject3).height;
    ((com.tencent.mm.plugin.image.b)localObject2).uJv = k;
    ((com.tencent.mm.plugin.image.b)localObject2).uJw = m;
    ((com.tencent.mm.plugin.image.b)localObject2).uJx = j;
    localObject1 = new t();
    ((t)localObject1).zNn = str4;
    ((t)localObject1).createTime = ((int)bt.aQJ());
    ((t)localObject1).type = i;
    paramp = new byq();
    paramp.GSK = ((p)localObject3).zdB;
    paramp.GTg = ((p)localObject3).zdA;
    paramp.token = ((p)localObject3).zdC;
    paramp.GTp = ((p)localObject3).zdD;
    paramp.GTD = 0;
    paramp.GTC = new byi();
    paramp.hfV = 0;
    paramp.Desc = ((p)localObject3).desc;
    ad.d("MicroMsg.snsMediaStorage", "upload.filterId " + ((p)localObject3).zdz);
    paramp.GTf = ((p)localObject3).zdz;
    paramp.GPx = 2;
    paramp.md5 = com.tencent.mm.vfs.i.aPK(str2 + str3);
  }
  
  private static p a(p paramp, String paramString)
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
        localObject5 = com.tencent.mm.vfs.i.openRead(paramString);
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
        com.tencent.mm.sdk.platformtools.g.decodeFile(paramString, localOptions);
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
        ad.printErrStackTrace("MicroMsg.snsMediaStorage", localObject4, "setImageExtInfo failed: ".concat(String.valueOf(paramString)), new Object[0]);
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
            throw paramp;
            localIOException2 = localIOException2;
            k = i;
            m = j;
          }
          catch (IOException paramString) {}
        }
      }
      paramp.width = m;
      paramp.height = k;
      paramp.fileSize = ((int)com.tencent.mm.vfs.i.aYo(paramString));
      AppMethodBeat.o(97606);
      return paramp;
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
  
  private boolean a(t paramt)
  {
    AppMethodBeat.i(97599);
    ad.d("MicroMsg.snsMediaStorage", "snsMedia Insert");
    if (paramt == null)
    {
      AppMethodBeat.o(97599);
      return false;
    }
    paramt = paramt.dZh();
    if ((int)this.hHS.a("SnsMedia", "local_id", paramt) != -1)
    {
      AppMethodBeat.o(97599);
      return true;
    }
    AppMethodBeat.o(97599);
    return false;
  }
  
  private static boolean a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap.CompressFormat paramCompressFormat, int paramInt5, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(97617);
    localObject3 = null;
    try
    {
      ad.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, srcWidth: %s, srcHeight: %s, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt3) });
      localObject1 = new BitmapFactory.Options();
      d1 = paramInt2 * 1.0D / paramInt3;
      d2 = paramInt1 * 1.0D / paramInt4;
      if ((paramInt1 != paramInt4) || (paramInt2 != paramInt3)) {
        break label127;
      }
      localObject1 = com.tencent.mm.plugin.sns.d.a.b(paramString1, (BitmapFactory.Options)localObject1);
    }
    catch (OutOfMemoryError paramString1)
    {
      long l;
      paramCompressFormat = null;
      ad.printErrStackTrace("MicroMsg.snsMediaStorage", paramString1, "create thumbnail from orig failed: %s", new Object[] { paramString3 });
      com.tencent.mm.plugin.report.service.g.yhR.n(1487L, 1L, 1L);
      if (paramCompressFormat == null) {
        break label315;
      }
    }
    catch (IOException paramString1)
    {
      for (;;)
      {
        double d1;
        double d2;
        label127:
        int j;
        double d3;
        Object localObject2;
        try
        {
          paramCompressFormat.close();
          AppMethodBeat.o(97617);
          return false;
          i = 0;
          continue;
          d3 = d1;
          break label716;
          d3 = d2;
          break label738;
          ad.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, sampleSize: %s", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject1).inSampleSize) });
          Object localObject1 = com.tencent.mm.plugin.sns.d.a.b(paramString1, (BitmapFactory.Options)localObject1);
          continue;
          ad.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()) });
          localObject2 = localObject1;
          if (paramBoolean)
          {
            if (d1 < d2)
            {
              paramInt2 = (int)Math.ceil(paramInt4 * 1.0D * paramInt2 / paramInt1);
              paramInt1 = paramInt4;
              paramInt3 = BackwardSupportUtil.ExifHelper.cY(paramString1);
              if (paramInt3 == 90) {
                break label746;
              }
              if (paramInt3 != 270) {
                break label695;
              }
              break label746;
              localObject2 = Bitmap.createScaledBitmap((Bitmap)localObject1, paramInt1, paramInt2, true);
              paramString1 = (String)localObject1;
              if (localObject2 != null)
              {
                if (localObject1 == localObject2) {
                  break label755;
                }
                l.ayD().C((Bitmap)localObject1);
                break label755;
              }
              ad.i("MicroMsg.snsMediaStorage", "createThumbNailUnScalebyUpload, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(paramString1.getWidth()), Integer.valueOf(paramString1.getHeight()) });
              localObject2 = paramString1;
            }
          }
          else {
            paramString1 = com.tencent.mm.vfs.i.cX(paramString2 + paramString3, false);
          }
          try
          {
            com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject2, paramInt5, paramCompressFormat, paramString1, false);
            l.ayD().C((Bitmap)localObject2);
            paramString1.close();
            AppMethodBeat.o(97617);
            return true;
          }
          catch (IOException paramString2)
          {
            paramCompressFormat = paramString1;
            paramString1 = paramString2;
            continue;
          }
          catch (OutOfMemoryError paramString2)
          {
            paramCompressFormat = paramString1;
            paramString1 = paramString2;
          }
          d1 = paramInt3 * 1.0D * paramInt1 / paramInt2;
          d1 = Math.ceil(d1);
          paramInt1 = (int)d1;
          paramInt2 = paramInt3;
          continue;
          paramString1 = paramString1;
          paramCompressFormat = localObject3;
          ad.printErrStackTrace("MicroMsg.snsMediaStorage", paramString1, "create thumbnail from orig failed: %s", new Object[] { paramString3 });
          if (paramCompressFormat == null) {}
        }
        catch (IOException paramString1)
        {
          try
          {
            paramCompressFormat.close();
            AppMethodBeat.o(97617);
            return false;
            paramString1 = paramString1;
          }
          catch (IOException paramString1)
          {
            continue;
          }
        }
        continue;
        continue;
        break label704;
        int i = 1;
        if (d1 < d2)
        {
          d3 = d2;
          j = (int)d3;
          if (i != 0) {
            if (d1 < d2)
            {
              d3 = d1;
              j = (int)d3;
              continue;
              paramInt3 = paramInt1;
              paramInt1 = paramInt2;
              paramInt2 = paramInt3;
              continue;
              paramString1 = (String)localObject2;
            }
          }
        }
      }
    }
    ad.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, result bm: %s", new Object[] { localObject1 });
    if (localObject1 == null)
    {
      AppMethodBeat.o(97617);
      return false;
      ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      if ((paramInt2 > paramInt3) || (paramInt1 > paramInt4))
      {
        if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qrf, 0)) {
          break label323;
        }
        i = 1;
        if ((com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED)) {
          break label701;
        }
        if (!com.tencent.mm.sdk.platformtools.i.DEBUG) {
          break label698;
        }
        break label701;
        ((BitmapFactory.Options)localObject1).inSampleSize = j;
        if (((BitmapFactory.Options)localObject1).inSampleSize <= 1) {
          ((BitmapFactory.Options)localObject1).inSampleSize = 1;
        }
      }
      l = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qrg, 10240000);
      while (paramInt2 * paramInt1 / ((BitmapFactory.Options)localObject1).inSampleSize / ((BitmapFactory.Options)localObject1).inSampleSize > l) {
        ((BitmapFactory.Options)localObject1).inSampleSize += 1;
      }
    }
  }
  
  /* Error */
  private static boolean a(String paramString1, int paramInt1, int paramInt2, int paramInt3, Bitmap.CompressFormat paramCompressFormat, int paramInt4, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 742
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aconst_null
    //   7: astore 16
    //   9: ldc 65
    //   11: ldc_w 744
    //   14: iconst_4
    //   15: anewarray 69	java/lang/Object
    //   18: dup
    //   19: iconst_0
    //   20: iload_1
    //   21: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: iload_2
    //   28: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   31: aastore
    //   32: dup
    //   33: iconst_2
    //   34: iload_3
    //   35: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   38: aastore
    //   39: dup
    //   40: iconst_3
    //   41: iload 5
    //   43: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: aastore
    //   47: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   50: new 580	android/graphics/BitmapFactory$Options
    //   53: dup
    //   54: invokespecial 581	android/graphics/BitmapFactory$Options:<init>	()V
    //   57: astore 15
    //   59: iload_2
    //   60: iload_1
    //   61: if_icmple +50 -> 111
    //   64: iload_1
    //   65: istore 9
    //   67: iload 9
    //   69: iload_3
    //   70: if_icmpne +47 -> 117
    //   73: aload_0
    //   74: aload 15
    //   76: invokestatic 646	com/tencent/mm/plugin/sns/d/a:b	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   79: astore 15
    //   81: ldc 65
    //   83: ldc_w 648
    //   86: iconst_1
    //   87: anewarray 69	java/lang/Object
    //   90: dup
    //   91: iconst_0
    //   92: aload 15
    //   94: aastore
    //   95: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   98: aload 15
    //   100: ifnonnull +198 -> 298
    //   103: ldc_w 742
    //   106: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: iconst_0
    //   110: ireturn
    //   111: iload_2
    //   112: istore 9
    //   114: goto -47 -> 67
    //   117: aload 15
    //   119: iconst_1
    //   120: putfield 651	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   123: iload 9
    //   125: iload_3
    //   126: if_icmple +27 -> 153
    //   129: aload 15
    //   131: iload 9
    //   133: iload_3
    //   134: idiv
    //   135: putfield 651	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   138: aload 15
    //   140: getfield 651	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   143: iconst_1
    //   144: if_icmpgt +9 -> 153
    //   147: aload 15
    //   149: iconst_1
    //   150: putfield 651	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   153: ldc_w 653
    //   156: invokestatic 659	com/tencent/mm/kernel/g:ab	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   159: checkcast 653	com/tencent/mm/plugin/expt/b/b
    //   162: getstatic 682	com/tencent/mm/plugin/expt/b/b$a:qrg	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   165: ldc_w 683
    //   168: invokeinterface 668 3 0
    //   173: i2l
    //   174: lstore 13
    //   176: iload_2
    //   177: iload_1
    //   178: imul
    //   179: aload 15
    //   181: getfield 651	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   184: idiv
    //   185: aload 15
    //   187: getfield 651	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   190: idiv
    //   191: i2l
    //   192: lload 13
    //   194: lcmp
    //   195: ifle +69 -> 264
    //   198: aload 15
    //   200: aload 15
    //   202: getfield 651	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   205: iconst_1
    //   206: iadd
    //   207: putfield 651	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   210: goto -34 -> 176
    //   213: astore_0
    //   214: aconst_null
    //   215: astore 4
    //   217: ldc 65
    //   219: aload_0
    //   220: ldc_w 685
    //   223: iconst_1
    //   224: anewarray 69	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: aload 7
    //   231: aastore
    //   232: invokestatic 550	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   235: getstatic 482	com/tencent/mm/plugin/report/service/g:yhR	Lcom/tencent/mm/plugin/report/service/g;
    //   238: ldc2_w 686
    //   241: lconst_0
    //   242: lconst_1
    //   243: invokevirtual 691	com/tencent/mm/plugin/report/service/g:n	(JJJ)V
    //   246: aload 4
    //   248: ifnull +8 -> 256
    //   251: aload 4
    //   253: invokevirtual 694	java/io/OutputStream:close	()V
    //   256: ldc_w 742
    //   259: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   262: iconst_0
    //   263: ireturn
    //   264: ldc 65
    //   266: ldc_w 696
    //   269: iconst_1
    //   270: anewarray 69	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: aload 15
    //   277: getfield 651	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   280: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: aastore
    //   284: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   287: aload_0
    //   288: aload 15
    //   290: invokestatic 646	com/tencent/mm/plugin/sns/d/a:b	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   293: astore 15
    //   295: goto -214 -> 81
    //   298: iload_1
    //   299: iload_3
    //   300: imul
    //   301: iload 9
    //   303: idiv
    //   304: istore 10
    //   306: iload_2
    //   307: iload_3
    //   308: imul
    //   309: iload 9
    //   311: idiv
    //   312: istore 11
    //   314: aload_0
    //   315: invokestatic 717	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$ExifHelper:cY	(Ljava/lang/String;)I
    //   318: istore 12
    //   320: iload 12
    //   322: bipush 90
    //   324: if_icmpeq +461 -> 785
    //   327: iload 12
    //   329: sipush 270
    //   332: if_icmpne +443 -> 775
    //   335: goto +450 -> 785
    //   338: ldc 65
    //   340: ldc_w 746
    //   343: bipush 8
    //   345: anewarray 69	java/lang/Object
    //   348: dup
    //   349: iconst_0
    //   350: aload 15
    //   352: invokevirtual 703	android/graphics/Bitmap:getWidth	()I
    //   355: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   358: aastore
    //   359: dup
    //   360: iconst_1
    //   361: aload 15
    //   363: invokevirtual 706	android/graphics/Bitmap:getHeight	()I
    //   366: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   369: aastore
    //   370: dup
    //   371: iconst_2
    //   372: iload_3
    //   373: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   376: aastore
    //   377: dup
    //   378: iconst_3
    //   379: iload 10
    //   381: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   384: aastore
    //   385: dup
    //   386: iconst_4
    //   387: iload_1
    //   388: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   391: aastore
    //   392: dup
    //   393: iconst_5
    //   394: iload_2
    //   395: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   398: aastore
    //   399: dup
    //   400: bipush 6
    //   402: iload 9
    //   404: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   407: aastore
    //   408: dup
    //   409: bipush 7
    //   411: iload 12
    //   413: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   416: aastore
    //   417: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   420: invokestatic 749	com/tencent/mm/plugin/sns/storage/u:dZl	()Z
    //   423: ifeq +137 -> 560
    //   426: iload 8
    //   428: ifeq +132 -> 560
    //   431: new 97	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   438: aload 6
    //   440: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: aload 7
    //   445: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   451: astore_0
    //   452: aload 15
    //   454: invokestatic 753	com/tencent/mm/plugin/sns/storage/u:ap	(Landroid/graphics/Bitmap;)[B
    //   457: astore 4
    //   459: aload 15
    //   461: invokevirtual 756	android/graphics/Bitmap:recycle	()V
    //   464: invokestatic 762	com/tencent/mm/plugin/emoji/d:cfK	()Lcom/tencent/mm/plugin/emoji/d;
    //   467: pop
    //   468: aload 4
    //   470: aload_0
    //   471: aload 15
    //   473: invokevirtual 703	android/graphics/Bitmap:getWidth	()I
    //   476: aload 15
    //   478: invokevirtual 706	android/graphics/Bitmap:getHeight	()I
    //   481: iload_3
    //   482: iload 10
    //   484: invokestatic 765	com/tencent/mm/plugin/emoji/d:a	([BLjava/lang/String;IIII)I
    //   487: pop
    //   488: ldc 65
    //   490: ldc_w 767
    //   493: iconst_2
    //   494: anewarray 69	java/lang/Object
    //   497: dup
    //   498: iconst_0
    //   499: new 97	java/lang/StringBuilder
    //   502: dup
    //   503: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   506: aload 6
    //   508: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload 7
    //   513: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: aastore
    //   520: dup
    //   521: iconst_1
    //   522: new 97	java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   529: aload 6
    //   531: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload 7
    //   536: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokestatic 187	com/tencent/mm/vfs/i:aYo	(Ljava/lang/String;)J
    //   545: invokestatic 772	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   548: aastore
    //   549: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   552: ldc_w 742
    //   555: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   558: iconst_1
    //   559: ireturn
    //   560: aload 15
    //   562: iload_3
    //   563: iload 10
    //   565: iconst_1
    //   566: invokestatic 721	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   569: astore 17
    //   571: aload 17
    //   573: ifnull +196 -> 769
    //   576: aload 17
    //   578: astore_0
    //   579: aload 15
    //   581: aload 17
    //   583: if_acmpeq +14 -> 597
    //   586: invokestatic 727	com/tencent/mm/memory/l:ayD	()Lcom/tencent/mm/memory/l;
    //   589: aload 15
    //   591: invokevirtual 731	com/tencent/mm/memory/l:C	(Landroid/graphics/Bitmap;)V
    //   594: aload 17
    //   596: astore_0
    //   597: ldc 65
    //   599: ldc_w 774
    //   602: iconst_3
    //   603: anewarray 69	java/lang/Object
    //   606: dup
    //   607: iconst_0
    //   608: aload_0
    //   609: invokevirtual 703	android/graphics/Bitmap:getWidth	()I
    //   612: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   615: aastore
    //   616: dup
    //   617: iconst_1
    //   618: aload_0
    //   619: invokevirtual 706	android/graphics/Bitmap:getHeight	()I
    //   622: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   625: aastore
    //   626: dup
    //   627: iconst_2
    //   628: iload 5
    //   630: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   633: aastore
    //   634: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   637: new 97	java/lang/StringBuilder
    //   640: dup
    //   641: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   644: aload 6
    //   646: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: aload 7
    //   651: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   657: iconst_0
    //   658: invokestatic 737	com/tencent/mm/vfs/i:cX	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   661: astore 15
    //   663: aload_0
    //   664: iload 5
    //   666: aload 4
    //   668: aload 15
    //   670: iconst_0
    //   671: invokestatic 740	com/tencent/mm/sdk/platformtools/g:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/io/OutputStream;Z)Z
    //   674: pop
    //   675: invokestatic 727	com/tencent/mm/memory/l:ayD	()Lcom/tencent/mm/memory/l;
    //   678: aload_0
    //   679: invokevirtual 731	com/tencent/mm/memory/l:C	(Landroid/graphics/Bitmap;)V
    //   682: aload 15
    //   684: invokevirtual 694	java/io/OutputStream:close	()V
    //   687: goto -199 -> 488
    //   690: astore_0
    //   691: aload 16
    //   693: astore 4
    //   695: ldc 65
    //   697: aload_0
    //   698: ldc_w 685
    //   701: iconst_1
    //   702: anewarray 69	java/lang/Object
    //   705: dup
    //   706: iconst_0
    //   707: aload 7
    //   709: aastore
    //   710: invokestatic 550	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   713: aload 4
    //   715: ifnull +8 -> 723
    //   718: aload 4
    //   720: invokevirtual 694	java/io/OutputStream:close	()V
    //   723: ldc_w 742
    //   726: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   729: iconst_0
    //   730: ireturn
    //   731: astore_0
    //   732: goto -476 -> 256
    //   735: astore_0
    //   736: goto -13 -> 723
    //   739: astore_0
    //   740: aload 15
    //   742: astore 4
    //   744: goto -49 -> 695
    //   747: astore_0
    //   748: aconst_null
    //   749: astore 4
    //   751: goto -56 -> 695
    //   754: astore_0
    //   755: aload 15
    //   757: astore 4
    //   759: goto -542 -> 217
    //   762: astore_0
    //   763: aconst_null
    //   764: astore 4
    //   766: goto -549 -> 217
    //   769: aload 15
    //   771: astore_0
    //   772: goto -175 -> 597
    //   775: iload 10
    //   777: istore_3
    //   778: iload 11
    //   780: istore 10
    //   782: goto -444 -> 338
    //   785: iload 11
    //   787: istore_3
    //   788: goto -450 -> 338
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	791	0	paramString1	String
    //   0	791	1	paramInt1	int
    //   0	791	2	paramInt2	int
    //   0	791	3	paramInt3	int
    //   0	791	4	paramCompressFormat	Bitmap.CompressFormat
    //   0	791	5	paramInt4	int
    //   0	791	6	paramString2	String
    //   0	791	7	paramString3	String
    //   0	791	8	paramBoolean	boolean
    //   65	338	9	i	int
    //   304	477	10	j	int
    //   312	474	11	k	int
    //   318	94	12	m	int
    //   174	19	13	l	long
    //   57	713	15	localObject1	Object
    //   7	685	16	localObject2	Object
    //   569	26	17	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   9	59	213	java/lang/OutOfMemoryError
    //   73	81	213	java/lang/OutOfMemoryError
    //   81	98	213	java/lang/OutOfMemoryError
    //   117	123	213	java/lang/OutOfMemoryError
    //   129	153	213	java/lang/OutOfMemoryError
    //   153	176	213	java/lang/OutOfMemoryError
    //   176	210	213	java/lang/OutOfMemoryError
    //   264	295	213	java/lang/OutOfMemoryError
    //   298	320	213	java/lang/OutOfMemoryError
    //   338	426	213	java/lang/OutOfMemoryError
    //   431	488	213	java/lang/OutOfMemoryError
    //   560	571	213	java/lang/OutOfMemoryError
    //   586	594	213	java/lang/OutOfMemoryError
    //   597	663	213	java/lang/OutOfMemoryError
    //   9	59	690	java/io/IOException
    //   73	81	690	java/io/IOException
    //   81	98	690	java/io/IOException
    //   117	123	690	java/io/IOException
    //   129	153	690	java/io/IOException
    //   153	176	690	java/io/IOException
    //   176	210	690	java/io/IOException
    //   264	295	690	java/io/IOException
    //   298	320	690	java/io/IOException
    //   338	426	690	java/io/IOException
    //   431	488	690	java/io/IOException
    //   560	571	690	java/io/IOException
    //   586	594	690	java/io/IOException
    //   597	663	690	java/io/IOException
    //   251	256	731	java/io/IOException
    //   718	723	735	java/io/IOException
    //   663	687	739	java/io/IOException
    //   488	552	747	java/io/IOException
    //   663	687	754	java/lang/OutOfMemoryError
    //   488	552	762	java/lang/OutOfMemoryError
  }
  
  private static boolean a(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(97613);
    BitmapFactory.Options localOptions = com.tencent.mm.sdk.platformtools.g.aQc(paramString1);
    if ((localOptions == null) || (localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
    {
      AppMethodBeat.o(97613);
      return false;
    }
    paramBoolean = a(paramString1, localOptions.outWidth, localOptions.outHeight, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(97613);
    return paramBoolean;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, float paramFloat)
  {
    AppMethodBeat.i(97616);
    d4 = 0.0D;
    j = 1;
    i = 1;
    try
    {
      localObject3 = com.tencent.mm.vfs.i.openRead(paramString1 + paramString2);
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject3;
        Object localObject5;
        int k;
        label135:
        double d7;
        double d8;
        Object localObject1;
        Object localObject2;
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
      localObject5 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject5).inJustDecodeBounds = true;
      MMBitmapFactory.decodeStream((InputStream)localObject3, null, (BitmapFactory.Options)localObject5);
      ((InputStream)localObject3).close();
      localObject3 = null;
    }
    catch (Exception localException2)
    {
      d1 = 0.0D;
      i = j;
      break label414;
    }
    try
    {
      d1 = ((BitmapFactory.Options)localObject5).outWidth;
      k = ((BitmapFactory.Options)localObject5).outHeight;
      d4 = k;
      if ((d1 > 120.0D) || (d4 > 120.0D)) {
        i = 0;
      }
    }
    catch (Exception localException3)
    {
      d1 = 0.0D;
      i = j;
      break label414;
    }
    try
    {
      localObject5 = ((BitmapFactory.Options)localObject5).outMimeType;
      if (d1 < 0.0D) {
        break label506;
      }
      if (d4 >= 0.0D) {
        break label495;
      }
    }
    catch (Exception localException4)
    {
      break label414;
      d2 = d5;
      break label312;
      d3 = d4;
      d2 = d1;
      break label135;
      d3 = 240.0D;
      d2 = 240.0D;
      break label135;
    }
    d7 = paramFloat;
    d8 = paramFloat / 200.0F * 44.0F;
    d5 = paramFloat / 200.0F * 160.0F;
    if ((localObject1 > 0.0D) && (localObject2 > 0.0D))
    {
      d6 = Math.min(d7 / localObject1, d7 / localObject2);
      d5 = localObject1 * d6;
      d6 *= localObject2;
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
      d3 = d6;
      if (d6 > d7) {
        d3 = d7;
      }
      if (d5 > d7) {
        d2 = d7;
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
        boolean bool = a((String)localObject3, j, k, m, n, paramString2, 70, paramString1, paramString3, false);
        AppMethodBeat.o(97616);
        return bool;
        d2 = d5;
        d3 = d5;
      }
    }
  }
  
  private static String aAr(String paramString)
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
    paramString = ag.getAccSnsPath() + paramString + str1;
    AppMethodBeat.o(97598);
    return paramString;
  }
  
  /* Error */
  public static boolean aAt(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 825
    //   5: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 589	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore_0
    //   13: aload_0
    //   14: astore_2
    //   15: new 580	android/graphics/BitmapFactory$Options
    //   18: dup
    //   19: invokespecial 581	android/graphics/BitmapFactory$Options:<init>	()V
    //   22: astore_3
    //   23: aload_0
    //   24: astore_2
    //   25: aload_3
    //   26: iconst_1
    //   27: putfield 585	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   30: aload_0
    //   31: astore_2
    //   32: aload_0
    //   33: aconst_null
    //   34: aload_3
    //   35: invokestatic 790	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   38: pop
    //   39: aload_0
    //   40: astore_2
    //   41: aload_3
    //   42: getfield 795	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   45: astore_3
    //   46: aload_0
    //   47: astore_2
    //   48: ldc 65
    //   50: ldc_w 827
    //   53: aload_3
    //   54: invokestatic 130	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   57: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   60: invokestatic 137	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_0
    //   64: astore_2
    //   65: aload_3
    //   66: invokevirtual 830	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   69: ldc_w 832
    //   72: invokevirtual 835	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   75: istore_1
    //   76: iload_1
    //   77: iflt +19 -> 96
    //   80: aload_0
    //   81: ifnull +7 -> 88
    //   84: aload_0
    //   85: invokevirtual 629	java/io/InputStream:close	()V
    //   88: ldc_w 825
    //   91: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: iconst_1
    //   95: ireturn
    //   96: aload_0
    //   97: ifnull +7 -> 104
    //   100: aload_0
    //   101: invokevirtual 629	java/io/InputStream:close	()V
    //   104: ldc_w 825
    //   107: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: iconst_0
    //   111: ireturn
    //   112: astore_0
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: ifnull +7 -> 123
    //   119: aload_0
    //   120: invokevirtual 629	java/io/InputStream:close	()V
    //   123: ldc_w 825
    //   126: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: iconst_0
    //   130: ireturn
    //   131: astore_0
    //   132: aload_2
    //   133: ifnull +7 -> 140
    //   136: aload_2
    //   137: invokevirtual 629	java/io/InputStream:close	()V
    //   140: ldc_w 825
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
  
  public static Bitmap aAu(String paramString)
  {
    int j = 640;
    AppMethodBeat.i(97619);
    Object localObject = com.tencent.mm.sdk.platformtools.g.aQc(paramString);
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
      localObject = com.tencent.mm.sdk.platformtools.g.d(paramString, j, i, false);
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
    paramString = com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject, Exif.fromFile(paramString).getOrientationInDegree());
    AppMethodBeat.o(97619);
    return paramString;
  }
  
  public static boolean aG(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(221349);
    boolean bool = d(paramString1, paramString2, paramString3, true);
    AppMethodBeat.o(221349);
    return bool;
  }
  
  private static byte[] ap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(198127);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramBitmap.getByteCount());
    paramBitmap.copyPixelsToBuffer(localByteBuffer);
    paramBitmap = localByteBuffer.array();
    AppMethodBeat.o(198127);
    return paramBitmap;
  }
  
  private boolean b(String paramString, t paramt)
  {
    AppMethodBeat.i(97601);
    paramt = paramt.dZh();
    if (this.hHS.update("SnsMedia", paramt, "StrId=?", new String[] { String.valueOf(paramString) }) > 0)
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
        com.tencent.mm.vfs.i.deleteFile(paramString1 + paramString3);
        localObject1 = com.tencent.mm.sdk.platformtools.g.aQc(paramString1 + paramString2);
        if (localObject1 == null)
        {
          ad.e("MicroMsg.snsMediaStorage", "createUserAlbum, getImageOptions error");
          AppMethodBeat.o(97618);
          return false;
        }
        if ((((BitmapFactory.Options)localObject1).outMimeType == null) || ((!((BitmapFactory.Options)localObject1).outMimeType.toLowerCase().endsWith("png")) && (!((BitmapFactory.Options)localObject1).outMimeType.toLowerCase().endsWith("vcodec")) && (!((BitmapFactory.Options)localObject1).outMimeType.toLowerCase().endsWith("wxam")))) {
          continue;
        }
        localObject1 = com.tencent.mm.sdk.platformtools.g.d(paramString1 + paramString2, (int)paramFloat, (int)paramFloat, true);
      }
      catch (OutOfMemoryError paramString1)
      {
        int i1;
        int n;
        double d2;
        ad.printErrStackTrace("MicroMsg.snsMediaStorage", paramString1, "create thumbnail from orig failed: %s", new Object[] { paramString3 });
        com.tencent.mm.plugin.report.service.g.yhR.n(1487L, 2L, 1L);
        AppMethodBeat.o(97618);
        return false;
        double d1 = k * 1.0D * i1 / n;
        i = (int)Math.ceil(d1);
        int j = k;
        continue;
        ad.i("MicroMsg.snsMediaStorage", "createUserAlbum, inSampleSize: %s", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject1).inSampleSize) });
        if (n / i1 != k / m) {
          continue;
        }
        Object localObject1 = com.tencent.mm.plugin.sns.d.a.b(paramString1 + paramString2, (BitmapFactory.Options)localObject1);
        ad.i("MicroMsg.snsMediaStorage", "createUserAlbum, directly use inSampleSize");
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
        localObject2 = l.ayD().a(str, (Rect)localObject2, (BitmapFactory.Options)localObject1);
        localObject1 = localObject2;
        if (localObject2 == null) {
          continue;
        }
        localObject1 = q.t(str, (Bitmap)localObject2);
        ad.d("MicroMsg.SnsBitmapUtil", "regionDecodeWithRotateByExif used %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        ad.i("MicroMsg.snsMediaStorage", "createUserAlbum, dstWidth: %s, dstHeight: %s, startX: %s, startY: %s, scaleFactor: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(paramFloat) });
        continue;
        ad.i("MicroMsg.snsMediaStorage", "createUserAlbum, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()) });
        i = 1;
        if ((((Bitmap)localObject1).getHeight() > 120) || (((Bitmap)localObject1).getWidth() > 120)) {
          continue;
        }
        if (i == 0) {
          continue;
        }
        paramString2 = Bitmap.CompressFormat.PNG;
        com.tencent.mm.sdk.platformtools.g.a((Bitmap)localObject1, 100, paramString2, paramString1 + paramString3, false);
        l.ayD().C((Bitmap)localObject1);
        AppMethodBeat.o(97618);
        return true;
        paramString2 = Bitmap.CompressFormat.JPEG;
        continue;
      }
      catch (Exception paramString1)
      {
        ad.e("MicroMsg.snsMediaStorage", "createUserAlbum error: %s", new Object[] { paramString1.getMessage() });
        ad.printErrStackTrace("MicroMsg.snsMediaStorage", paramString1, "", new Object[0]);
        continue;
        continue;
        int i = 0;
        continue;
      }
      if (localObject1 != null) {
        continue;
      }
      ad.i("MicroMsg.snsMediaStorage", "bitmap error " + paramString1 + paramString2);
      com.tencent.mm.vfs.i.deleteFile(paramString1 + paramString2);
      AppMethodBeat.o(97618);
      return false;
      i1 = ((BitmapFactory.Options)localObject1).outWidth;
      n = ((BitmapFactory.Options)localObject1).outHeight;
      m = (int)paramFloat;
      k = (int)paramFloat;
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
      ad.i("MicroMsg.snsMediaStorage", "createUserAlbum, srcWidth: %s, srcHeight: %s, dstWidth: %s, dstHeight: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k) });
      if ((i1 != m) || (n != k)) {
        continue;
      }
      localObject1 = com.tencent.mm.plugin.sns.d.a.b(paramString1 + paramString2, (BitmapFactory.Options)localObject1);
    }
    if (n * 1.0D / k > i1 * 1.0D / m)
    {
      j = (int)Math.ceil(m * 1.0D * n / i1);
      i = m;
      ad.d("MicroMsg.snsMediaStorage", "createUserAlbum, newWidth: %s, newHeight: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      if ((n <= j) && (i1 <= i)) {
        break label635;
      }
      ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      if ((n > j) || (i1 > i))
      {
        d1 = n * 1.0D / j;
        d2 = i1 * 1.0D / i;
        if (d1 >= d2) {
          break label1125;
        }
        d1 = d2;
        ((BitmapFactory.Options)localObject1).inSampleSize = ((int)d1);
        if (((BitmapFactory.Options)localObject1).inSampleSize <= 1) {
          ((BitmapFactory.Options)localObject1).inSampleSize = 1;
        }
      }
      l = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qrg, 10240000);
      while (n * i1 / ((BitmapFactory.Options)localObject1).inSampleSize / ((BitmapFactory.Options)localObject1).inSampleSize > l) {
        ((BitmapFactory.Options)localObject1).inSampleSize += 1;
      }
    }
  }
  
  /* Error */
  public static boolean d(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 953
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 780	com/tencent/mm/sdk/platformtools/g:aQc	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   10: astore 21
    //   12: aload 21
    //   14: ifnull +1000 -> 1014
    //   17: aload 21
    //   19: getfield 795	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   22: astore 22
    //   24: ldc 65
    //   26: ldc_w 955
    //   29: aload 22
    //   31: invokestatic 130	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   34: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokestatic 137	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload 22
    //   42: ifnull +972 -> 1014
    //   45: aload 22
    //   47: invokevirtual 830	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   50: astore 22
    //   52: aload 22
    //   54: ldc_w 957
    //   57: invokevirtual 835	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   60: iflt +920 -> 980
    //   63: iconst_1
    //   64: istore 17
    //   66: aload 21
    //   68: ifnull +969 -> 1037
    //   71: aload 21
    //   73: getfield 795	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   76: astore 22
    //   78: aload 22
    //   80: ifnull +957 -> 1037
    //   83: aload 22
    //   85: invokevirtual 830	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   88: astore 22
    //   90: aload 22
    //   92: ldc_w 957
    //   95: invokevirtual 835	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   98: iflt +922 -> 1020
    //   101: iconst_1
    //   102: istore 9
    //   104: aload 21
    //   106: ifnull +27 -> 133
    //   109: aload 21
    //   111: getfield 795	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   114: astore 22
    //   116: aload 22
    //   118: ifnull +15 -> 133
    //   121: aload 22
    //   123: invokevirtual 830	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   126: ldc_w 884
    //   129: invokevirtual 835	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   132: pop
    //   133: iconst_m1
    //   134: istore 11
    //   136: bipush 100
    //   138: istore 7
    //   140: iload 11
    //   142: istore 8
    //   144: iload_3
    //   145: ifeq +3487 -> 3632
    //   148: invokestatic 963	com/tencent/mm/ao/f:aGI	()Lcom/tencent/mm/ao/b;
    //   151: pop
    //   152: bipush 64
    //   154: invokestatic 969	com/tencent/mm/ao/b:pa	(I)Z
    //   157: ifne +21 -> 178
    //   160: invokestatic 972	com/tencent/mm/plugin/sns/storage/u:dZk	()Z
    //   163: ifne +15 -> 178
    //   166: invokestatic 975	com/tencent/mm/plugin/sns/storage/u:dZm	()Z
    //   169: ifne +9 -> 178
    //   172: invokestatic 749	com/tencent/mm/plugin/sns/storage/u:dZl	()Z
    //   175: ifeq +943 -> 1118
    //   178: invokestatic 981	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   181: invokestatic 987	com/tencent/mm/sdk/platformtools/ay:isWifi	(Landroid/content/Context;)Z
    //   184: ifeq +859 -> 1043
    //   187: invokestatic 993	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   190: ldc_w 995
    //   193: invokevirtual 1000	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   196: bipush 70
    //   198: invokestatic 1004	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   201: istore 7
    //   203: ldc 65
    //   205: ldc_w 1006
    //   208: bipush 7
    //   210: anewarray 69	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: invokestatic 993	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   218: ldc_w 995
    //   221: invokevirtual 1000	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   224: aastore
    //   225: dup
    //   226: iconst_1
    //   227: invokestatic 993	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   230: ldc_w 1008
    //   233: invokevirtual 1000	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   236: aastore
    //   237: dup
    //   238: iconst_2
    //   239: invokestatic 993	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   242: ldc_w 1010
    //   245: invokevirtual 1000	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   248: aastore
    //   249: dup
    //   250: iconst_3
    //   251: invokestatic 993	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   254: ldc_w 1012
    //   257: invokevirtual 1000	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   260: aastore
    //   261: dup
    //   262: iconst_4
    //   263: invokestatic 993	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   266: ldc_w 1014
    //   269: invokevirtual 1000	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   272: aastore
    //   273: dup
    //   274: iconst_5
    //   275: invokestatic 993	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   278: ldc_w 1016
    //   281: invokevirtual 1000	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   284: aastore
    //   285: dup
    //   286: bipush 6
    //   288: invokestatic 993	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   291: ldc_w 1018
    //   294: invokevirtual 1000	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   297: aastore
    //   298: invokestatic 892	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: ldc 65
    //   303: ldc_w 1020
    //   306: iconst_2
    //   307: anewarray 69	java/lang/Object
    //   310: dup
    //   311: iconst_0
    //   312: iload 7
    //   314: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   317: aastore
    //   318: dup
    //   319: iconst_1
    //   320: iload_3
    //   321: invokestatic 1025	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   324: aastore
    //   325: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   328: iload 7
    //   330: bipush 10
    //   332: if_icmple +10 -> 342
    //   335: iload 7
    //   337: bipush 100
    //   339: if_icmple +3304 -> 3643
    //   342: bipush 60
    //   344: istore 10
    //   346: iload 11
    //   348: istore 8
    //   350: iload 10
    //   352: istore 7
    //   354: iload 9
    //   356: ifeq +3276 -> 3632
    //   359: aload_1
    //   360: invokestatic 1030	com/tencent/mm/sdk/platformtools/MMNativeJpeg:queryQuality	(Ljava/lang/String;)I
    //   363: istore 11
    //   365: iload 11
    //   367: istore 8
    //   369: iload 10
    //   371: istore 7
    //   373: iload 11
    //   375: iload 10
    //   377: if_icmpge +3255 -> 3632
    //   380: iload 11
    //   382: istore 8
    //   384: iload 10
    //   386: istore 7
    //   388: iload 11
    //   390: bipush 25
    //   392: if_icmple +3240 -> 3632
    //   395: iload 11
    //   397: istore 7
    //   399: iload 11
    //   401: istore 10
    //   403: iload 7
    //   405: istore 11
    //   407: aload_1
    //   408: invokestatic 187	com/tencent/mm/vfs/i:aYo	(Ljava/lang/String;)J
    //   411: l2i
    //   412: istore 14
    //   414: sipush 1080
    //   417: istore 8
    //   419: aload_1
    //   420: invokestatic 1035	com/tencent/mm/plugin/facedetect/FaceProNative:detectFaceCnt	(Ljava/lang/String;)I
    //   423: istore 7
    //   425: ldc 65
    //   427: ldc_w 1037
    //   430: iconst_1
    //   431: anewarray 69	java/lang/Object
    //   434: dup
    //   435: iconst_0
    //   436: iload 7
    //   438: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   441: aastore
    //   442: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   445: iload 7
    //   447: iconst_5
    //   448: if_icmplt +8 -> 456
    //   451: sipush 1440
    //   454: istore 8
    //   456: iconst_0
    //   457: istore 12
    //   459: iload 7
    //   461: iconst_5
    //   462: if_icmplt +734 -> 1196
    //   465: iload 12
    //   467: istore 7
    //   469: invokestatic 993	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   472: ldc_w 1039
    //   475: invokevirtual 1000	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   478: astore 22
    //   480: iload 12
    //   482: istore 7
    //   484: aload 22
    //   486: ldc_w 1041
    //   489: invokevirtual 1045	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   492: iconst_0
    //   493: aaload
    //   494: invokestatic 1048	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   497: invokevirtual 1051	java/lang/Integer:intValue	()I
    //   500: istore 12
    //   502: iload 12
    //   504: istore 7
    //   506: aload 22
    //   508: ldc_w 1041
    //   511: invokevirtual 1045	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   514: iconst_1
    //   515: aaload
    //   516: invokestatic 1048	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   519: invokevirtual 1051	java/lang/Integer:intValue	()I
    //   522: istore 13
    //   524: iload 13
    //   526: istore 8
    //   528: iload 12
    //   530: istore 7
    //   532: ldc 65
    //   534: ldc_w 1053
    //   537: bipush 6
    //   539: anewarray 69	java/lang/Object
    //   542: dup
    //   543: iconst_0
    //   544: iload 7
    //   546: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   549: aastore
    //   550: dup
    //   551: iconst_1
    //   552: iload 8
    //   554: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   557: aastore
    //   558: dup
    //   559: iconst_2
    //   560: getstatic 34	com/tencent/mm/plugin/sns/storage/u:yXO	I
    //   563: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   566: aastore
    //   567: dup
    //   568: iconst_3
    //   569: getstatic 32	com/tencent/mm/plugin/sns/storage/u:yYH	I
    //   572: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   575: aastore
    //   576: dup
    //   577: iconst_4
    //   578: iload 10
    //   580: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   583: aastore
    //   584: dup
    //   585: iconst_5
    //   586: iload_3
    //   587: invokestatic 1025	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   590: aastore
    //   591: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   594: iload 7
    //   596: ifgt +919 -> 1515
    //   599: iload 8
    //   601: ifgt +914 -> 1515
    //   604: iconst_0
    //   605: istore 7
    //   607: sipush 1080
    //   610: istore 8
    //   612: invokestatic 993	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   615: ldc_w 1055
    //   618: invokevirtual 1000	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   621: bipush 100
    //   623: invokestatic 1004	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   626: istore 13
    //   628: iload 13
    //   630: istore 12
    //   632: iload 13
    //   634: ifgt +7 -> 641
    //   637: bipush 100
    //   639: istore 12
    //   641: iload 12
    //   643: sipush 1024
    //   646: imul
    //   647: istore 15
    //   649: invokestatic 993	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   652: ldc_w 1057
    //   655: invokevirtual 1000	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   658: sipush 200
    //   661: invokestatic 1004	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   664: istore 13
    //   666: iload 13
    //   668: istore 12
    //   670: iload 13
    //   672: ifgt +8 -> 680
    //   675: sipush 200
    //   678: istore 12
    //   680: iload 12
    //   682: sipush 1024
    //   685: imul
    //   686: istore 16
    //   688: invokestatic 993	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   691: ldc_w 1059
    //   694: invokevirtual 1000	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   697: bipush 10
    //   699: invokestatic 1004	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   702: istore 12
    //   704: iload 12
    //   706: ifle +10 -> 716
    //   709: iload 12
    //   711: bipush 100
    //   713: if_icmplt +2913 -> 3626
    //   716: bipush 10
    //   718: istore 12
    //   720: iconst_0
    //   721: istore 13
    //   723: iload 9
    //   725: ifeq +861 -> 1586
    //   728: aload_1
    //   729: invokestatic 355	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   732: astore 22
    //   734: iload 13
    //   736: istore 9
    //   738: aload 22
    //   740: ifnull +14 -> 754
    //   743: aload 22
    //   745: invokevirtual 620	com/tencent/mm/compatible/util/Exif:getOrientationInDegree	()I
    //   748: sipush 360
    //   751: irem
    //   752: istore 9
    //   754: ldc 65
    //   756: new 97	java/lang/StringBuilder
    //   759: dup
    //   760: ldc_w 1061
    //   763: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   766: aload 21
    //   768: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   771: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   774: ldc_w 1063
    //   777: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: aload 21
    //   782: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   785: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   788: ldc_w 1063
    //   791: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   794: iload 17
    //   796: invokevirtual 1066	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   799: ldc_w 1068
    //   802: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: iload 11
    //   807: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   810: ldc_w 1070
    //   813: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: iload 9
    //   818: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   821: ldc_w 1072
    //   824: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: iload 14
    //   829: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   832: ldc_w 1074
    //   835: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: iload 7
    //   840: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   843: ldc_w 1063
    //   846: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: iload 8
    //   851: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   854: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   857: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   860: invokestatic 993	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   863: ldc_w 1076
    //   866: invokevirtual 1000	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   869: bipush 10
    //   871: invokestatic 1004	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   874: pop
    //   875: aload 21
    //   877: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   880: aload 21
    //   882: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   885: iconst_2
    //   886: imul
    //   887: if_icmpge +18 -> 905
    //   890: aload 21
    //   892: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   895: aload 21
    //   897: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   900: iconst_2
    //   901: imul
    //   902: if_icmplt +1575 -> 2477
    //   905: aload 21
    //   907: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   910: aload 21
    //   912: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   915: imul
    //   916: ldc_w 683
    //   919: if_icmpgt +1270 -> 2189
    //   922: iload 14
    //   924: iload 16
    //   926: if_icmpge +725 -> 1651
    //   929: iload 17
    //   931: ifeq +720 -> 1651
    //   934: iload 9
    //   936: ifne +715 -> 1651
    //   939: invokestatic 749	com/tencent/mm/plugin/sns/storage/u:dZl	()Z
    //   942: ifeq +650 -> 1592
    //   945: iload_3
    //   946: ifeq +646 -> 1592
    //   949: aload_1
    //   950: new 97	java/lang/StringBuilder
    //   953: dup
    //   954: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   957: aload_0
    //   958: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: aload_2
    //   962: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   968: invokestatic 1080	com/tencent/mm/plugin/sns/storage/u:jR	(Ljava/lang/String;Ljava/lang/String;)Z
    //   971: pop
    //   972: ldc_w 953
    //   975: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   978: iconst_1
    //   979: ireturn
    //   980: aload 22
    //   982: ldc_w 1082
    //   985: invokevirtual 835	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   988: iflt +9 -> 997
    //   991: iconst_1
    //   992: istore 17
    //   994: goto -928 -> 66
    //   997: aload 22
    //   999: ldc_w 877
    //   1002: invokevirtual 835	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1005: iflt +9 -> 1014
    //   1008: iconst_1
    //   1009: istore 17
    //   1011: goto -945 -> 66
    //   1014: iconst_0
    //   1015: istore 17
    //   1017: goto -951 -> 66
    //   1020: aload 22
    //   1022: ldc_w 1082
    //   1025: invokevirtual 835	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1028: iflt +9 -> 1037
    //   1031: iconst_1
    //   1032: istore 9
    //   1034: goto -930 -> 104
    //   1037: iconst_0
    //   1038: istore 9
    //   1040: goto -936 -> 104
    //   1043: invokestatic 981	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   1046: invokestatic 1085	com/tencent/mm/sdk/platformtools/ay:is2G	(Landroid/content/Context;)Z
    //   1049: ifeq +22 -> 1071
    //   1052: invokestatic 993	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   1055: ldc_w 1008
    //   1058: invokevirtual 1000	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1061: bipush 70
    //   1063: invokestatic 1004	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   1066: istore 7
    //   1068: goto -865 -> 203
    //   1071: invokestatic 981	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   1074: invokestatic 1088	com/tencent/mm/sdk/platformtools/ay:is3G	(Landroid/content/Context;)Z
    //   1077: ifeq +22 -> 1099
    //   1080: invokestatic 993	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   1083: ldc_w 1010
    //   1086: invokevirtual 1000	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1089: bipush 60
    //   1091: invokestatic 1004	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   1094: istore 7
    //   1096: goto -893 -> 203
    //   1099: invokestatic 993	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   1102: ldc_w 1012
    //   1105: invokevirtual 1000	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1108: bipush 60
    //   1110: invokestatic 1004	com/tencent/mm/sdk/platformtools/bt:getInt	(Ljava/lang/String;I)I
    //   1113: istore 7
    //   1115: goto -912 -> 203
    //   1118: invokestatic 981	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   1121: invokestatic 987	com/tencent/mm/sdk/platformtools/ay:isWifi	(Landroid/content/Context;)Z
    //   1124: ifeq +23 -> 1147
    //   1127: invokestatic 993	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   1130: ldc_w 1014
    //   1133: invokevirtual 1000	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1136: invokestatic 1048	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1139: invokevirtual 1051	java/lang/Integer:intValue	()I
    //   1142: istore 7
    //   1144: goto -941 -> 203
    //   1147: invokestatic 981	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   1150: invokestatic 1085	com/tencent/mm/sdk/platformtools/ay:is2G	(Landroid/content/Context;)Z
    //   1153: ifeq +23 -> 1176
    //   1156: invokestatic 993	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   1159: ldc_w 1016
    //   1162: invokevirtual 1000	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1165: invokestatic 1048	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1168: invokevirtual 1051	java/lang/Integer:intValue	()I
    //   1171: istore 7
    //   1173: goto -970 -> 203
    //   1176: invokestatic 993	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   1179: ldc_w 1018
    //   1182: invokevirtual 1000	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1185: invokestatic 1048	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1188: invokevirtual 1051	java/lang/Integer:intValue	()I
    //   1191: istore 7
    //   1193: goto -990 -> 203
    //   1196: iload 12
    //   1198: istore 7
    //   1200: invokestatic 981	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   1203: invokestatic 987	com/tencent/mm/sdk/platformtools/ay:isWifi	(Landroid/content/Context;)Z
    //   1206: ifeq +73 -> 1279
    //   1209: iload 12
    //   1211: istore 7
    //   1213: invokestatic 993	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   1216: ldc_w 1090
    //   1219: invokevirtual 1000	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1222: astore 22
    //   1224: iload 12
    //   1226: istore 7
    //   1228: aload 22
    //   1230: ldc_w 1041
    //   1233: invokevirtual 1045	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1236: iconst_0
    //   1237: aaload
    //   1238: invokestatic 1048	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1241: invokevirtual 1051	java/lang/Integer:intValue	()I
    //   1244: istore 12
    //   1246: iload 12
    //   1248: istore 7
    //   1250: aload 22
    //   1252: ldc_w 1041
    //   1255: invokevirtual 1045	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1258: iconst_1
    //   1259: aaload
    //   1260: invokestatic 1048	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1263: invokevirtual 1051	java/lang/Integer:intValue	()I
    //   1266: istore 13
    //   1268: iload 13
    //   1270: istore 8
    //   1272: iload 12
    //   1274: istore 7
    //   1276: goto -744 -> 532
    //   1279: iload 12
    //   1281: istore 7
    //   1283: invokestatic 981	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   1286: invokestatic 1085	com/tencent/mm/sdk/platformtools/ay:is2G	(Landroid/content/Context;)Z
    //   1289: ifeq +73 -> 1362
    //   1292: iload 12
    //   1294: istore 7
    //   1296: invokestatic 993	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   1299: ldc_w 1092
    //   1302: invokevirtual 1000	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1305: astore 22
    //   1307: iload 12
    //   1309: istore 7
    //   1311: aload 22
    //   1313: ldc_w 1041
    //   1316: invokevirtual 1045	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1319: iconst_0
    //   1320: aaload
    //   1321: invokestatic 1048	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1324: invokevirtual 1051	java/lang/Integer:intValue	()I
    //   1327: istore 12
    //   1329: iload 12
    //   1331: istore 7
    //   1333: aload 22
    //   1335: ldc_w 1041
    //   1338: invokevirtual 1045	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1341: iconst_1
    //   1342: aaload
    //   1343: invokestatic 1048	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1346: invokevirtual 1051	java/lang/Integer:intValue	()I
    //   1349: istore 13
    //   1351: iload 13
    //   1353: istore 8
    //   1355: iload 12
    //   1357: istore 7
    //   1359: goto -827 -> 532
    //   1362: iload 12
    //   1364: istore 7
    //   1366: invokestatic 981	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   1369: invokestatic 1088	com/tencent/mm/sdk/platformtools/ay:is3G	(Landroid/content/Context;)Z
    //   1372: ifeq +73 -> 1445
    //   1375: iload 12
    //   1377: istore 7
    //   1379: invokestatic 993	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   1382: ldc_w 1094
    //   1385: invokevirtual 1000	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1388: astore 22
    //   1390: iload 12
    //   1392: istore 7
    //   1394: aload 22
    //   1396: ldc_w 1041
    //   1399: invokevirtual 1045	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1402: iconst_0
    //   1403: aaload
    //   1404: invokestatic 1048	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1407: invokevirtual 1051	java/lang/Integer:intValue	()I
    //   1410: istore 12
    //   1412: iload 12
    //   1414: istore 7
    //   1416: aload 22
    //   1418: ldc_w 1041
    //   1421: invokevirtual 1045	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1424: iconst_1
    //   1425: aaload
    //   1426: invokestatic 1048	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1429: invokevirtual 1051	java/lang/Integer:intValue	()I
    //   1432: istore 13
    //   1434: iload 13
    //   1436: istore 8
    //   1438: iload 12
    //   1440: istore 7
    //   1442: goto -910 -> 532
    //   1445: iload 12
    //   1447: istore 7
    //   1449: invokestatic 993	com/tencent/mm/n/g:acA	()Lcom/tencent/mm/n/e;
    //   1452: ldc_w 1096
    //   1455: invokevirtual 1000	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1458: astore 22
    //   1460: iload 12
    //   1462: istore 7
    //   1464: aload 22
    //   1466: ldc_w 1041
    //   1469: invokevirtual 1045	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1472: iconst_0
    //   1473: aaload
    //   1474: invokestatic 1048	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1477: invokevirtual 1051	java/lang/Integer:intValue	()I
    //   1480: istore 12
    //   1482: iload 12
    //   1484: istore 7
    //   1486: aload 22
    //   1488: ldc_w 1041
    //   1491: invokevirtual 1045	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1494: iconst_1
    //   1495: aaload
    //   1496: invokestatic 1048	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1499: invokevirtual 1051	java/lang/Integer:intValue	()I
    //   1502: istore 13
    //   1504: iload 13
    //   1506: istore 8
    //   1508: iload 12
    //   1510: istore 7
    //   1512: goto -980 -> 532
    //   1515: iload 8
    //   1517: sipush 2160
    //   1520: if_icmplt +14 -> 1534
    //   1523: iconst_0
    //   1524: istore 7
    //   1526: sipush 1080
    //   1529: istore 8
    //   1531: goto -919 -> 612
    //   1534: iload 8
    //   1536: ifgt +2093 -> 3629
    //   1539: iload 7
    //   1541: sipush 3240
    //   1544: if_icmple +2085 -> 3629
    //   1547: sipush 1620
    //   1550: istore 7
    //   1552: iconst_0
    //   1553: istore 8
    //   1555: goto -943 -> 612
    //   1558: astore 22
    //   1560: ldc 65
    //   1562: new 97	java/lang/StringBuilder
    //   1565: dup
    //   1566: ldc_w 1098
    //   1569: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1572: aload 22
    //   1574: invokevirtual 950	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1577: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1580: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1583: invokestatic 555	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1586: iconst_0
    //   1587: istore 9
    //   1589: goto -835 -> 754
    //   1592: ldc 65
    //   1594: ldc_w 1100
    //   1597: iload 16
    //   1599: invokestatic 343	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1602: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1605: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1608: aload_1
    //   1609: new 97	java/lang/StringBuilder
    //   1612: dup
    //   1613: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1616: aload_0
    //   1617: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1620: aload_2
    //   1621: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1624: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1627: invokestatic 522	com/tencent/mm/vfs/i:mz	(Ljava/lang/String;Ljava/lang/String;)J
    //   1630: lconst_0
    //   1631: lcmp
    //   1632: iflt +11 -> 1643
    //   1635: ldc_w 953
    //   1638: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1641: iconst_1
    //   1642: ireturn
    //   1643: ldc_w 953
    //   1646: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1649: iconst_0
    //   1650: ireturn
    //   1651: new 580	android/graphics/BitmapFactory$Options
    //   1654: dup
    //   1655: invokespecial 581	android/graphics/BitmapFactory$Options:<init>	()V
    //   1658: astore 24
    //   1660: invokestatic 1103	com/tencent/mm/sdk/platformtools/g:fjY	()V
    //   1663: aconst_null
    //   1664: astore 22
    //   1666: aload_1
    //   1667: invokestatic 589	com/tencent/mm/vfs/i:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1670: astore 21
    //   1672: aload 21
    //   1674: astore 22
    //   1676: aload 21
    //   1678: invokevirtual 595	java/io/InputStream:markSupported	()Z
    //   1681: ifne +1942 -> 3623
    //   1684: aload 21
    //   1686: astore 22
    //   1688: new 597	java/io/BufferedInputStream
    //   1691: dup
    //   1692: aload 21
    //   1694: invokespecial 600	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1697: astore 23
    //   1699: aload 23
    //   1701: astore 21
    //   1703: aload 21
    //   1705: ldc_w 601
    //   1708: invokevirtual 604	java/io/InputStream:mark	(I)V
    //   1711: aload 21
    //   1713: aconst_null
    //   1714: aload 24
    //   1716: invokestatic 790	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1719: astore 22
    //   1721: aload 21
    //   1723: invokevirtual 611	java/io/InputStream:reset	()V
    //   1726: aload 22
    //   1728: ifnonnull +21 -> 1749
    //   1731: aload 21
    //   1733: ifnull +8 -> 1741
    //   1736: aload 21
    //   1738: invokevirtual 629	java/io/InputStream:close	()V
    //   1741: ldc_w 953
    //   1744: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1747: iconst_0
    //   1748: ireturn
    //   1749: iload 9
    //   1751: i2f
    //   1752: fstore 6
    //   1754: aload 22
    //   1756: fload 6
    //   1758: invokestatic 844	com/tencent/mm/sdk/platformtools/g:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   1761: astore 22
    //   1763: invokestatic 749	com/tencent/mm/plugin/sns/storage/u:dZl	()Z
    //   1766: ifeq +211 -> 1977
    //   1769: iload_3
    //   1770: ifeq +207 -> 1977
    //   1773: new 97	java/lang/StringBuilder
    //   1776: dup
    //   1777: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1780: aload_0
    //   1781: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1784: aload_2
    //   1785: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1788: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1791: astore 23
    //   1793: aload 22
    //   1795: invokestatic 753	com/tencent/mm/plugin/sns/storage/u:ap	(Landroid/graphics/Bitmap;)[B
    //   1798: astore 24
    //   1800: aload 22
    //   1802: invokevirtual 756	android/graphics/Bitmap:recycle	()V
    //   1805: invokestatic 762	com/tencent/mm/plugin/emoji/d:cfK	()Lcom/tencent/mm/plugin/emoji/d;
    //   1808: pop
    //   1809: aload 24
    //   1811: aload 23
    //   1813: aload 22
    //   1815: invokevirtual 703	android/graphics/Bitmap:getWidth	()I
    //   1818: aload 22
    //   1820: invokevirtual 706	android/graphics/Bitmap:getHeight	()I
    //   1823: aload 22
    //   1825: invokevirtual 703	android/graphics/Bitmap:getWidth	()I
    //   1828: aload 22
    //   1830: invokevirtual 706	android/graphics/Bitmap:getHeight	()I
    //   1833: invokestatic 765	com/tencent/mm/plugin/emoji/d:a	([BLjava/lang/String;IIII)I
    //   1836: pop
    //   1837: iload 17
    //   1839: ifeq +310 -> 2149
    //   1842: iload 9
    //   1844: ifne +305 -> 2149
    //   1847: new 97	java/lang/StringBuilder
    //   1850: dup
    //   1851: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1854: aload_0
    //   1855: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1858: aload_2
    //   1859: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1862: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1865: invokestatic 187	com/tencent/mm/vfs/i:aYo	(Ljava/lang/String;)J
    //   1868: lstore 19
    //   1870: ldc 65
    //   1872: ldc_w 1105
    //   1875: iconst_3
    //   1876: anewarray 69	java/lang/Object
    //   1879: dup
    //   1880: iconst_0
    //   1881: iload 14
    //   1883: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1886: aastore
    //   1887: dup
    //   1888: iconst_1
    //   1889: lload 19
    //   1891: invokestatic 772	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1894: aastore
    //   1895: dup
    //   1896: iconst_2
    //   1897: iload 12
    //   1899: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1902: aastore
    //   1903: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1906: iload 14
    //   1908: i2l
    //   1909: lload 19
    //   1911: lsub
    //   1912: ldc2_w 1106
    //   1915: lmul
    //   1916: iload 12
    //   1918: iload 14
    //   1920: imul
    //   1921: i2l
    //   1922: lcmp
    //   1923: ifge +208 -> 2131
    //   1926: invokestatic 749	com/tencent/mm/plugin/sns/storage/u:dZl	()Z
    //   1929: ifeq +124 -> 2053
    //   1932: iload_3
    //   1933: ifeq +120 -> 2053
    //   1936: aload_1
    //   1937: new 97	java/lang/StringBuilder
    //   1940: dup
    //   1941: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1944: aload_0
    //   1945: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1948: aload_2
    //   1949: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1952: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1955: invokestatic 1080	com/tencent/mm/plugin/sns/storage/u:jR	(Ljava/lang/String;Ljava/lang/String;)Z
    //   1958: pop
    //   1959: aload 21
    //   1961: ifnull +8 -> 1969
    //   1964: aload 21
    //   1966: invokevirtual 629	java/io/InputStream:close	()V
    //   1969: ldc_w 953
    //   1972: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1975: iconst_1
    //   1976: ireturn
    //   1977: aload 22
    //   1979: iload 10
    //   1981: getstatic 813	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1984: new 97	java/lang/StringBuilder
    //   1987: dup
    //   1988: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1991: aload_0
    //   1992: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1995: aload_2
    //   1996: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1999: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2002: iconst_1
    //   2003: invokestatic 945	com/tencent/mm/sdk/platformtools/g:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   2006: pop
    //   2007: goto -170 -> 1837
    //   2010: astore_0
    //   2011: aload 21
    //   2013: astore 22
    //   2015: ldc 65
    //   2017: aload_0
    //   2018: ldc_w 1109
    //   2021: aload_1
    //   2022: invokestatic 130	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2025: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2028: iconst_0
    //   2029: anewarray 69	java/lang/Object
    //   2032: invokestatic 550	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2035: aload 22
    //   2037: ifnull +8 -> 2045
    //   2040: aload 22
    //   2042: invokevirtual 629	java/io/InputStream:close	()V
    //   2045: ldc_w 953
    //   2048: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2051: iconst_0
    //   2052: ireturn
    //   2053: new 97	java/lang/StringBuilder
    //   2056: dup
    //   2057: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2060: aload_0
    //   2061: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2064: aload_2
    //   2065: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2068: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2071: invokestatic 531	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   2074: pop
    //   2075: aload_1
    //   2076: new 97	java/lang/StringBuilder
    //   2079: dup
    //   2080: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2083: aload_0
    //   2084: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2087: aload_2
    //   2088: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2091: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2094: invokestatic 522	com/tencent/mm/vfs/i:mz	(Ljava/lang/String;Ljava/lang/String;)J
    //   2097: lstore 19
    //   2099: lload 19
    //   2101: lconst_0
    //   2102: lcmp
    //   2103: iflt +23 -> 2126
    //   2106: iconst_1
    //   2107: istore_3
    //   2108: aload 21
    //   2110: ifnull +8 -> 2118
    //   2113: aload 21
    //   2115: invokevirtual 629	java/io/InputStream:close	()V
    //   2118: ldc_w 953
    //   2121: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2124: iload_3
    //   2125: ireturn
    //   2126: iconst_0
    //   2127: istore_3
    //   2128: goto -20 -> 2108
    //   2131: aload 21
    //   2133: ifnull +8 -> 2141
    //   2136: aload 21
    //   2138: invokevirtual 629	java/io/InputStream:close	()V
    //   2141: ldc_w 953
    //   2144: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2147: iconst_1
    //   2148: ireturn
    //   2149: aload 21
    //   2151: ifnull +8 -> 2159
    //   2154: aload 21
    //   2156: invokevirtual 629	java/io/InputStream:close	()V
    //   2159: ldc_w 953
    //   2162: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2165: iconst_1
    //   2166: ireturn
    //   2167: astore_0
    //   2168: aconst_null
    //   2169: astore 21
    //   2171: aload 21
    //   2173: ifnull +8 -> 2181
    //   2176: aload 21
    //   2178: invokevirtual 629	java/io/InputStream:close	()V
    //   2181: ldc_w 953
    //   2184: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2187: aload_0
    //   2188: athrow
    //   2189: ldc 65
    //   2191: new 97	java/lang/StringBuilder
    //   2194: dup
    //   2195: ldc_w 1111
    //   2198: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2201: aload 21
    //   2203: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2206: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2209: ldc_w 1063
    //   2212: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2215: aload 21
    //   2217: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2220: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2223: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2226: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2229: aload 21
    //   2231: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2234: ifgt +9 -> 2243
    //   2237: aload 21
    //   2239: iconst_1
    //   2240: putfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2243: aload 21
    //   2245: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2248: ifgt +9 -> 2257
    //   2251: aload 21
    //   2253: iconst_1
    //   2254: putfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2257: aload 21
    //   2259: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2262: aload 21
    //   2264: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2267: if_icmple +151 -> 2418
    //   2270: aload 21
    //   2272: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2275: aload 21
    //   2277: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2280: idiv
    //   2281: istore 7
    //   2283: iload 7
    //   2285: istore 8
    //   2287: iload 7
    //   2289: ifne +6 -> 2295
    //   2292: iconst_1
    //   2293: istore 8
    //   2295: ldc_w 683
    //   2298: iload 8
    //   2300: idiv
    //   2301: i2d
    //   2302: invokestatic 1114	java/lang/Math:sqrt	(D)D
    //   2305: d2i
    //   2306: istore 7
    //   2308: aload 21
    //   2310: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2313: aload 21
    //   2315: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2318: if_icmple +116 -> 2434
    //   2321: iload 7
    //   2323: iload 8
    //   2325: imul
    //   2326: istore 9
    //   2328: ldc 65
    //   2330: new 97	java/lang/StringBuilder
    //   2333: dup
    //   2334: ldc_w 1116
    //   2337: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2340: iload 9
    //   2342: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2345: ldc_w 1063
    //   2348: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2351: iload 7
    //   2353: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2356: ldc_w 1063
    //   2359: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2362: iload 8
    //   2364: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2367: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2370: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2373: invokestatic 749	com/tencent/mm/plugin/sns/storage/u:dZl	()Z
    //   2376: ifeq +76 -> 2452
    //   2379: iload_3
    //   2380: ifeq +72 -> 2452
    //   2383: aload_1
    //   2384: new 97	java/lang/StringBuilder
    //   2387: dup
    //   2388: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2391: aload_0
    //   2392: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2395: aload_2
    //   2396: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2399: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2402: iload 9
    //   2404: iload 7
    //   2406: invokestatic 1120	com/tencent/mm/plugin/sns/storage/u:q	(Ljava/lang/String;Ljava/lang/String;II)Z
    //   2409: istore_3
    //   2410: ldc_w 953
    //   2413: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2416: iload_3
    //   2417: ireturn
    //   2418: aload 21
    //   2420: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2423: aload 21
    //   2425: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2428: idiv
    //   2429: istore 7
    //   2431: goto -148 -> 2283
    //   2434: iload 7
    //   2436: iload 8
    //   2438: imul
    //   2439: istore 11
    //   2441: iload 7
    //   2443: istore 9
    //   2445: iload 11
    //   2447: istore 7
    //   2449: goto -121 -> 2328
    //   2452: aload_1
    //   2453: iload 7
    //   2455: iload 9
    //   2457: getstatic 813	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   2460: iload 10
    //   2462: aload_0
    //   2463: aload_2
    //   2464: iload_3
    //   2465: invokestatic 1122	com/tencent/mm/plugin/sns/storage/u:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   2468: istore_3
    //   2469: ldc_w 953
    //   2472: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2475: iload_3
    //   2476: ireturn
    //   2477: iload 14
    //   2479: iload 15
    //   2481: if_icmpge +113 -> 2594
    //   2484: iload 17
    //   2486: ifeq +108 -> 2594
    //   2489: iload 9
    //   2491: ifne +103 -> 2594
    //   2494: ldc 65
    //   2496: ldc_w 1124
    //   2499: iload 15
    //   2501: invokestatic 343	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2504: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2507: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2510: invokestatic 749	com/tencent/mm/plugin/sns/storage/u:dZl	()Z
    //   2513: ifeq +38 -> 2551
    //   2516: iload_3
    //   2517: ifeq +34 -> 2551
    //   2520: aload_1
    //   2521: new 97	java/lang/StringBuilder
    //   2524: dup
    //   2525: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2528: aload_0
    //   2529: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2532: aload_2
    //   2533: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2536: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2539: invokestatic 1080	com/tencent/mm/plugin/sns/storage/u:jR	(Ljava/lang/String;Ljava/lang/String;)Z
    //   2542: istore_3
    //   2543: ldc_w 953
    //   2546: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2549: iload_3
    //   2550: ireturn
    //   2551: aload_1
    //   2552: new 97	java/lang/StringBuilder
    //   2555: dup
    //   2556: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2559: aload_0
    //   2560: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2563: aload_2
    //   2564: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2567: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2570: invokestatic 522	com/tencent/mm/vfs/i:mz	(Ljava/lang/String;Ljava/lang/String;)J
    //   2573: lconst_0
    //   2574: lcmp
    //   2575: iflt +11 -> 2586
    //   2578: ldc_w 953
    //   2581: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2584: iconst_1
    //   2585: ireturn
    //   2586: ldc_w 953
    //   2589: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2592: iconst_0
    //   2593: ireturn
    //   2594: aload 21
    //   2596: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2599: aload 21
    //   2601: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2604: if_icmple +169 -> 2773
    //   2607: aload 21
    //   2609: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2612: istore 11
    //   2614: aload 21
    //   2616: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2619: aload 21
    //   2621: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2624: if_icmpge +159 -> 2783
    //   2627: aload 21
    //   2629: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2632: istore 13
    //   2634: iload 8
    //   2636: ifle +10 -> 2646
    //   2639: iload 13
    //   2641: iload 8
    //   2643: if_icmple +15 -> 2658
    //   2646: iload 8
    //   2648: ifgt +576 -> 3224
    //   2651: iload 11
    //   2653: iload 7
    //   2655: if_icmpgt +569 -> 3224
    //   2658: ldc 65
    //   2660: ldc_w 1126
    //   2663: iconst_3
    //   2664: anewarray 69	java/lang/Object
    //   2667: dup
    //   2668: iconst_0
    //   2669: iload 14
    //   2671: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2674: aastore
    //   2675: dup
    //   2676: iconst_1
    //   2677: aload 21
    //   2679: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2682: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2685: aastore
    //   2686: dup
    //   2687: iconst_2
    //   2688: aload 21
    //   2690: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2693: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2696: aastore
    //   2697: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2700: aload_1
    //   2701: invokestatic 187	com/tencent/mm/vfs/i:aYo	(Ljava/lang/String;)J
    //   2704: ldc2_w 1127
    //   2707: lcmp
    //   2708: ifge +232 -> 2940
    //   2711: iload 17
    //   2713: ifeq +123 -> 2836
    //   2716: ldc 65
    //   2718: ldc_w 1130
    //   2721: iconst_1
    //   2722: anewarray 69	java/lang/Object
    //   2725: dup
    //   2726: iconst_0
    //   2727: aload_1
    //   2728: aastore
    //   2729: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2732: invokestatic 749	com/tencent/mm/plugin/sns/storage/u:dZl	()Z
    //   2735: ifeq +58 -> 2793
    //   2738: iload_3
    //   2739: ifeq +54 -> 2793
    //   2742: aload_1
    //   2743: new 97	java/lang/StringBuilder
    //   2746: dup
    //   2747: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2750: aload_0
    //   2751: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2754: aload_2
    //   2755: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2758: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2761: invokestatic 1080	com/tencent/mm/plugin/sns/storage/u:jR	(Ljava/lang/String;Ljava/lang/String;)Z
    //   2764: istore_3
    //   2765: ldc_w 953
    //   2768: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2771: iload_3
    //   2772: ireturn
    //   2773: aload 21
    //   2775: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2778: istore 11
    //   2780: goto -166 -> 2614
    //   2783: aload 21
    //   2785: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2788: istore 13
    //   2790: goto -156 -> 2634
    //   2793: aload_1
    //   2794: new 97	java/lang/StringBuilder
    //   2797: dup
    //   2798: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2801: aload_0
    //   2802: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2805: aload_2
    //   2806: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2809: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2812: invokestatic 522	com/tencent/mm/vfs/i:mz	(Ljava/lang/String;Ljava/lang/String;)J
    //   2815: lconst_0
    //   2816: lcmp
    //   2817: iflt +11 -> 2828
    //   2820: ldc_w 953
    //   2823: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2826: iconst_1
    //   2827: ireturn
    //   2828: ldc_w 953
    //   2831: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2834: iconst_0
    //   2835: ireturn
    //   2836: aload 21
    //   2838: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2841: sipush 150
    //   2844: if_icmpge +96 -> 2940
    //   2847: aload 21
    //   2849: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2852: sipush 150
    //   2855: if_icmpge +85 -> 2940
    //   2858: invokestatic 749	com/tencent/mm/plugin/sns/storage/u:dZl	()Z
    //   2861: ifeq +48 -> 2909
    //   2864: iload_3
    //   2865: ifeq +44 -> 2909
    //   2868: aload_1
    //   2869: new 97	java/lang/StringBuilder
    //   2872: dup
    //   2873: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2876: aload_0
    //   2877: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2880: aload_2
    //   2881: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2884: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2887: aload 21
    //   2889: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2892: aload 21
    //   2894: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2897: invokestatic 1120	com/tencent/mm/plugin/sns/storage/u:q	(Ljava/lang/String;Ljava/lang/String;II)Z
    //   2900: istore_3
    //   2901: ldc_w 953
    //   2904: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2907: iload_3
    //   2908: ireturn
    //   2909: aload_1
    //   2910: aload 21
    //   2912: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2915: aload 21
    //   2917: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2920: getstatic 808	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   2923: iload 10
    //   2925: aload_0
    //   2926: aload_2
    //   2927: iload_3
    //   2928: invokestatic 1122	com/tencent/mm/plugin/sns/storage/u:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   2931: istore_3
    //   2932: ldc_w 953
    //   2935: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2938: iload_3
    //   2939: ireturn
    //   2940: invokestatic 749	com/tencent/mm/plugin/sns/storage/u:dZl	()Z
    //   2943: ifeq +171 -> 3114
    //   2946: iload_3
    //   2947: ifeq +167 -> 3114
    //   2950: aload_1
    //   2951: new 97	java/lang/StringBuilder
    //   2954: dup
    //   2955: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2958: aload_0
    //   2959: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2962: aload_2
    //   2963: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2966: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2969: aload 21
    //   2971: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2974: aload 21
    //   2976: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2979: invokestatic 1120	com/tencent/mm/plugin/sns/storage/u:q	(Ljava/lang/String;Ljava/lang/String;II)Z
    //   2982: istore 18
    //   2984: iload 17
    //   2986: ifeq +229 -> 3215
    //   2989: iload 9
    //   2991: ifne +224 -> 3215
    //   2994: new 97	java/lang/StringBuilder
    //   2997: dup
    //   2998: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3001: aload_0
    //   3002: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3005: aload_2
    //   3006: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3009: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3012: invokestatic 187	com/tencent/mm/vfs/i:aYo	(Ljava/lang/String;)J
    //   3015: lstore 19
    //   3017: ldc 65
    //   3019: ldc_w 1105
    //   3022: iconst_3
    //   3023: anewarray 69	java/lang/Object
    //   3026: dup
    //   3027: iconst_0
    //   3028: iload 14
    //   3030: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3033: aastore
    //   3034: dup
    //   3035: iconst_1
    //   3036: lload 19
    //   3038: invokestatic 772	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3041: aastore
    //   3042: dup
    //   3043: iconst_2
    //   3044: iload 12
    //   3046: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3049: aastore
    //   3050: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3053: iload 14
    //   3055: i2l
    //   3056: lload 19
    //   3058: lsub
    //   3059: ldc2_w 1106
    //   3062: lmul
    //   3063: iload 12
    //   3065: iload 14
    //   3067: imul
    //   3068: i2l
    //   3069: lcmp
    //   3070: ifge +136 -> 3206
    //   3073: invokestatic 749	com/tencent/mm/plugin/sns/storage/u:dZl	()Z
    //   3076: ifeq +65 -> 3141
    //   3079: iload_3
    //   3080: ifeq +61 -> 3141
    //   3083: aload_1
    //   3084: new 97	java/lang/StringBuilder
    //   3087: dup
    //   3088: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3091: aload_0
    //   3092: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3095: aload_2
    //   3096: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3099: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3102: invokestatic 1080	com/tencent/mm/plugin/sns/storage/u:jR	(Ljava/lang/String;Ljava/lang/String;)Z
    //   3105: istore_3
    //   3106: ldc_w 953
    //   3109: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3112: iload_3
    //   3113: ireturn
    //   3114: aload_1
    //   3115: aload 21
    //   3117: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   3120: aload 21
    //   3122: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   3125: getstatic 813	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   3128: iload 10
    //   3130: aload_0
    //   3131: aload_2
    //   3132: iload_3
    //   3133: invokestatic 1122	com/tencent/mm/plugin/sns/storage/u:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   3136: istore 18
    //   3138: goto -154 -> 2984
    //   3141: new 97	java/lang/StringBuilder
    //   3144: dup
    //   3145: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3148: aload_0
    //   3149: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3152: aload_2
    //   3153: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3156: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3159: invokestatic 531	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   3162: pop
    //   3163: aload_1
    //   3164: new 97	java/lang/StringBuilder
    //   3167: dup
    //   3168: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3171: aload_0
    //   3172: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3175: aload_2
    //   3176: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3179: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3182: invokestatic 522	com/tencent/mm/vfs/i:mz	(Ljava/lang/String;Ljava/lang/String;)J
    //   3185: lconst_0
    //   3186: lcmp
    //   3187: iflt +11 -> 3198
    //   3190: ldc_w 953
    //   3193: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3196: iconst_1
    //   3197: ireturn
    //   3198: ldc_w 953
    //   3201: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3204: iconst_0
    //   3205: ireturn
    //   3206: ldc_w 953
    //   3209: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3212: iload 18
    //   3214: ireturn
    //   3215: ldc_w 953
    //   3218: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3221: iload 18
    //   3223: ireturn
    //   3224: iload 8
    //   3226: ifle +159 -> 3385
    //   3229: aload_1
    //   3230: aload 21
    //   3232: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   3235: aload 21
    //   3237: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   3240: iload 8
    //   3242: getstatic 813	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   3245: iload 10
    //   3247: aload_0
    //   3248: aload_2
    //   3249: iload_3
    //   3250: invokestatic 1132	com/tencent/mm/plugin/sns/storage/u:a	(Ljava/lang/String;IIILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   3253: istore 18
    //   3255: iload 17
    //   3257: ifeq +290 -> 3547
    //   3260: iload 9
    //   3262: ifne +285 -> 3547
    //   3265: new 97	java/lang/StringBuilder
    //   3268: dup
    //   3269: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3272: aload_0
    //   3273: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3276: aload_2
    //   3277: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3280: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3283: invokestatic 187	com/tencent/mm/vfs/i:aYo	(Ljava/lang/String;)J
    //   3286: lstore 19
    //   3288: ldc 65
    //   3290: ldc_w 1105
    //   3293: iconst_3
    //   3294: anewarray 69	java/lang/Object
    //   3297: dup
    //   3298: iconst_0
    //   3299: iload 14
    //   3301: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3304: aastore
    //   3305: dup
    //   3306: iconst_1
    //   3307: lload 19
    //   3309: invokestatic 772	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3312: aastore
    //   3313: dup
    //   3314: iconst_2
    //   3315: iload 12
    //   3317: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3320: aastore
    //   3321: invokestatic 74	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3324: iload 14
    //   3326: i2l
    //   3327: lload 19
    //   3329: lsub
    //   3330: ldc2_w 1106
    //   3333: lmul
    //   3334: iload 12
    //   3336: iload 14
    //   3338: imul
    //   3339: i2l
    //   3340: lcmp
    //   3341: ifge +206 -> 3547
    //   3344: invokestatic 749	com/tencent/mm/plugin/sns/storage/u:dZl	()Z
    //   3347: ifeq +135 -> 3482
    //   3350: iload_3
    //   3351: ifeq +131 -> 3482
    //   3354: aload_1
    //   3355: new 97	java/lang/StringBuilder
    //   3358: dup
    //   3359: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3362: aload_0
    //   3363: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3366: aload_2
    //   3367: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3370: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3373: invokestatic 1080	com/tencent/mm/plugin/sns/storage/u:jR	(Ljava/lang/String;Ljava/lang/String;)Z
    //   3376: istore_3
    //   3377: ldc_w 953
    //   3380: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3383: iload_3
    //   3384: ireturn
    //   3385: iload 11
    //   3387: i2d
    //   3388: dconst_1
    //   3389: dmul
    //   3390: iload 7
    //   3392: i2d
    //   3393: ddiv
    //   3394: dstore 4
    //   3396: aload 21
    //   3398: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   3401: i2d
    //   3402: dload 4
    //   3404: ddiv
    //   3405: d2i
    //   3406: istore 7
    //   3408: aload 21
    //   3410: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   3413: i2d
    //   3414: dload 4
    //   3416: ddiv
    //   3417: d2i
    //   3418: istore 8
    //   3420: invokestatic 749	com/tencent/mm/plugin/sns/storage/u:dZl	()Z
    //   3423: ifeq +38 -> 3461
    //   3426: iload_3
    //   3427: ifeq +34 -> 3461
    //   3430: aload_1
    //   3431: new 97	java/lang/StringBuilder
    //   3434: dup
    //   3435: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3438: aload_0
    //   3439: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3442: aload_2
    //   3443: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3446: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3449: iload 7
    //   3451: iload 8
    //   3453: invokestatic 1120	com/tencent/mm/plugin/sns/storage/u:q	(Ljava/lang/String;Ljava/lang/String;II)Z
    //   3456: istore 18
    //   3458: goto -203 -> 3255
    //   3461: aload_1
    //   3462: iload 8
    //   3464: iload 7
    //   3466: getstatic 813	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   3469: iload 10
    //   3471: aload_0
    //   3472: aload_2
    //   3473: iload_3
    //   3474: invokestatic 1122	com/tencent/mm/plugin/sns/storage/u:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   3477: istore 18
    //   3479: goto -224 -> 3255
    //   3482: new 97	java/lang/StringBuilder
    //   3485: dup
    //   3486: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3489: aload_0
    //   3490: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3493: aload_2
    //   3494: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3497: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3500: invokestatic 531	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   3503: pop
    //   3504: aload_1
    //   3505: new 97	java/lang/StringBuilder
    //   3508: dup
    //   3509: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3512: aload_0
    //   3513: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3516: aload_2
    //   3517: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3520: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3523: invokestatic 522	com/tencent/mm/vfs/i:mz	(Ljava/lang/String;Ljava/lang/String;)J
    //   3526: lconst_0
    //   3527: lcmp
    //   3528: iflt +11 -> 3539
    //   3531: ldc_w 953
    //   3534: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3537: iconst_1
    //   3538: ireturn
    //   3539: ldc_w 953
    //   3542: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3545: iconst_0
    //   3546: ireturn
    //   3547: ldc_w 953
    //   3550: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3553: iload 18
    //   3555: ireturn
    //   3556: astore_0
    //   3557: goto -1816 -> 1741
    //   3560: astore_0
    //   3561: goto -1592 -> 1969
    //   3564: astore_0
    //   3565: goto -1447 -> 2118
    //   3568: astore_0
    //   3569: goto -1428 -> 2141
    //   3572: astore_0
    //   3573: goto -1414 -> 2159
    //   3576: astore_0
    //   3577: goto -1532 -> 2045
    //   3580: astore_1
    //   3581: goto -1400 -> 2181
    //   3584: astore_0
    //   3585: goto -1414 -> 2171
    //   3588: astore_0
    //   3589: goto -1418 -> 2171
    //   3592: astore_0
    //   3593: aload 22
    //   3595: astore 21
    //   3597: goto -1426 -> 2171
    //   3600: astore_0
    //   3601: goto -1586 -> 2015
    //   3604: astore 22
    //   3606: goto -3074 -> 532
    //   3609: astore 22
    //   3611: bipush 100
    //   3613: istore 7
    //   3615: goto -3314 -> 301
    //   3618: astore 22
    //   3620: goto -3319 -> 301
    //   3623: goto -1920 -> 1703
    //   3626: goto -2906 -> 720
    //   3629: goto -3017 -> 612
    //   3632: iload 8
    //   3634: istore 11
    //   3636: iload 7
    //   3638: istore 10
    //   3640: goto -3233 -> 407
    //   3643: iload 7
    //   3645: istore 10
    //   3647: goto -3301 -> 346
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3650	0	paramString1	String
    //   0	3650	1	paramString2	String
    //   0	3650	2	paramString3	String
    //   0	3650	3	paramBoolean	boolean
    //   3394	21	4	d	double
    //   1752	5	6	f	float
    //   138	3506	7	i	int
    //   142	3491	8	j	int
    //   102	3159	9	k	int
    //   344	3302	10	m	int
    //   134	3501	11	n	int
    //   457	2882	12	i1	int
    //   522	2267	13	i2	int
    //   412	2927	14	i3	int
    //   647	1853	15	i4	int
    //   686	912	16	i5	int
    //   64	3192	17	bool1	boolean
    //   2982	572	18	bool2	boolean
    //   1868	1460	19	l	long
    //   10	3586	21	localObject1	Object
    //   22	1465	22	localObject2	Object
    //   1558	15	22	localException1	Exception
    //   1664	1930	22	localObject3	Object
    //   3604	1	22	localException2	Exception
    //   3609	1	22	localException3	Exception
    //   3618	1	22	localException4	Exception
    //   1697	115	23	localObject4	Object
    //   1658	152	24	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   728	734	1558	java/lang/Exception
    //   743	754	1558	java/lang/Exception
    //   1703	1726	2010	java/io/IOException
    //   1754	1769	2010	java/io/IOException
    //   1773	1837	2010	java/io/IOException
    //   1847	1906	2010	java/io/IOException
    //   1926	1932	2010	java/io/IOException
    //   1936	1959	2010	java/io/IOException
    //   1977	2007	2010	java/io/IOException
    //   2053	2099	2010	java/io/IOException
    //   1666	1672	2167	finally
    //   1736	1741	3556	java/io/IOException
    //   1964	1969	3560	java/io/IOException
    //   2113	2118	3564	java/io/IOException
    //   2136	2141	3568	java/io/IOException
    //   2154	2159	3572	java/io/IOException
    //   2040	2045	3576	java/io/IOException
    //   2176	2181	3580	java/io/IOException
    //   1676	1684	3584	finally
    //   1688	1699	3584	finally
    //   1703	1726	3588	finally
    //   1754	1769	3588	finally
    //   1773	1837	3588	finally
    //   1847	1906	3588	finally
    //   1926	1932	3588	finally
    //   1936	1959	3588	finally
    //   1977	2007	3588	finally
    //   2053	2099	3588	finally
    //   2015	2035	3592	finally
    //   1666	1672	3600	java/io/IOException
    //   1676	1684	3600	java/io/IOException
    //   1688	1699	3600	java/io/IOException
    //   469	480	3604	java/lang/Exception
    //   484	502	3604	java/lang/Exception
    //   506	524	3604	java/lang/Exception
    //   1200	1209	3604	java/lang/Exception
    //   1213	1224	3604	java/lang/Exception
    //   1228	1246	3604	java/lang/Exception
    //   1250	1268	3604	java/lang/Exception
    //   1283	1292	3604	java/lang/Exception
    //   1296	1307	3604	java/lang/Exception
    //   1311	1329	3604	java/lang/Exception
    //   1333	1351	3604	java/lang/Exception
    //   1366	1375	3604	java/lang/Exception
    //   1379	1390	3604	java/lang/Exception
    //   1394	1412	3604	java/lang/Exception
    //   1416	1434	3604	java/lang/Exception
    //   1449	1460	3604	java/lang/Exception
    //   1464	1482	3604	java/lang/Exception
    //   1486	1504	3604	java/lang/Exception
    //   148	178	3609	java/lang/Exception
    //   178	203	3609	java/lang/Exception
    //   1043	1068	3609	java/lang/Exception
    //   1071	1096	3609	java/lang/Exception
    //   1099	1115	3609	java/lang/Exception
    //   1118	1144	3609	java/lang/Exception
    //   1147	1173	3609	java/lang/Exception
    //   1176	1193	3609	java/lang/Exception
    //   203	301	3618	java/lang/Exception
  }
  
  public static boolean dZk()
  {
    AppMethodBeat.i(97609);
    if ("hevc".equals(ac.iPG))
    {
      AppMethodBeat.o(97609);
      return true;
    }
    boolean bool = ag.dUr();
    AppMethodBeat.o(97609);
    return bool;
  }
  
  public static boolean dZl()
  {
    AppMethodBeat.i(198126);
    if ("wxam".equals(ac.iPG))
    {
      AppMethodBeat.o(198126);
      return true;
    }
    boolean bool = ag.dUt();
    AppMethodBeat.o(198126);
    return bool;
  }
  
  public static boolean dZm()
  {
    AppMethodBeat.i(97610);
    if ("wxpc".equals(ac.iPG))
    {
      AppMethodBeat.o(97610);
      return true;
    }
    boolean bool = ag.dUu();
    AppMethodBeat.o(97610);
    return bool;
  }
  
  public static boolean dZn()
  {
    return (yXO >= 1080) && (yYH >= 1080);
  }
  
  public static int getScreenWidth()
  {
    if (yYH > yXO) {
      return yXO;
    }
    return yYH;
  }
  
  public static void hL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97597);
    yYH = paramInt1;
    yXO = paramInt2;
    ad.i("MicroMsg.snsMediaStorage", "SCREEN %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(97597);
  }
  
  private static boolean jR(String paramString1, String paramString2)
  {
    AppMethodBeat.i(198128);
    paramString1 = com.tencent.mm.plugin.sns.d.a.m(paramString1, 0.0F);
    byte[] arrayOfByte = ap(paramString1);
    paramString1.recycle();
    com.tencent.mm.plugin.emoji.d.cfK();
    if (com.tencent.mm.plugin.emoji.d.a(arrayOfByte, paramString2, paramString1.getWidth(), paramString1.getHeight(), paramString1.getWidth(), paramString1.getHeight()) == 0)
    {
      AppMethodBeat.o(198128);
      return true;
    }
    AppMethodBeat.o(198128);
    return false;
  }
  
  private static boolean q(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198129);
    paramString1 = com.tencent.mm.plugin.sns.d.a.m(paramString1, 0.0F);
    byte[] arrayOfByte = ap(paramString1);
    paramString1.recycle();
    com.tencent.mm.plugin.emoji.d.cfK();
    if (com.tencent.mm.plugin.emoji.d.a(arrayOfByte, paramString2, paramString1.getWidth(), paramString1.getHeight(), paramInt1, paramInt2) == 0)
    {
      AppMethodBeat.o(198129);
      return true;
    }
    AppMethodBeat.o(198129);
    return false;
  }
  
  public final t Aj(long paramLong)
  {
    AppMethodBeat.i(97604);
    t localt = new t();
    Cursor localCursor = this.hHS.a("SnsMedia", null, "local_id=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(97604);
      return null;
    }
    localt.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(97604);
    return localt;
  }
  
  public final int a(int paramInt, t paramt)
  {
    AppMethodBeat.i(97602);
    paramt = paramt.dZh();
    paramInt = this.hHS.update("SnsMedia", paramt, "local_id=?", new String[] { String.valueOf(paramInt) });
    AppMethodBeat.o(97602);
    return paramInt;
  }
  
  public final p a(p paramp, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(97608);
    t localt = new t();
    localt.createTime = ((int)bt.aQJ());
    localt.type = paramp.type;
    byq localbyq = new byq();
    localbyq.GSK = paramp.zdB;
    localbyq.GTg = paramp.zdA;
    localbyq.token = paramp.zdC;
    localbyq.GTp = paramp.zdD;
    localbyq.GTD = 0;
    localbyq.GTC = new byi();
    localbyq.hfV = 0;
    localbyq.Desc = paramp.desc;
    ad.d("MicroMsg.snsMediaStorage", "upload.filterId " + paramp.zdz);
    localbyq.GTf = paramp.zdz;
    localbyq.GPx = 2;
    localbyq.videoPath = paramString1;
    localbyq.GTG = paramString2;
    localbyq.md5 = paramp.zdE;
    for (;;)
    {
      try
      {
        localt.zNr = localbyq.toByteArray();
        localt.dZi();
        i = (int)this.hHS.a("SnsMedia", "local_id", localt.dZh());
        str1 = "Locall_path".concat(String.valueOf(i));
        ad.d("MicroMsg.snsMediaStorage", "insert localId ".concat(String.valueOf(i)));
        String str2 = q.axV(str1);
        String str3 = q.axW(str1);
        String str4 = q.axU(str1);
        String str5 = q.axX(str1);
        String str6 = aAr(str1);
        com.tencent.mm.vfs.i.aYg(str6);
        com.tencent.mm.vfs.i.mz(paramString2, str6 + str2);
        com.tencent.mm.vfs.i.mz(paramString2, str6 + str3);
        com.tencent.mm.vfs.i.mz(paramString2, str6 + str4);
        com.tencent.mm.vfs.i.mz(paramString1, str6 + str5);
        localbyq.videoPath = (str6 + str5);
        localbyq.GTG = (str6 + str3);
        localbyq.md5 = paramp.zdE;
      }
      catch (Exception localException)
      {
        try
        {
          int i;
          String str1;
          localt.zNr = localbyq.toByteArray();
          localt.zNn = str1;
          if ((TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4)))
          {
            a(i, localt);
            paramp = a(paramp, localbyq.GTG);
            paramp.dJd = i;
            AppMethodBeat.o(97608);
            return paramp;
            localException = localException;
            ad.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
          }
        }
        catch (Exception paramString2)
        {
          ad.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
          continue;
          paramString2 = new byi();
          paramString2.nEf = 1;
          paramString2.Url = paramString3;
          localbyq.GTC = paramString2;
          localbyq.GPx = 0;
          f.aGJ();
          localbyq.GTd = com.tencent.mm.ao.a.EL(paramString1);
          if (!bt.isNullOrNil(paramString4))
          {
            paramString1 = new byi();
            paramString1.nEf = 1;
            paramString1.Url = paramString4;
            localbyq.GTE.add(paramString1);
          }
        }
      }
      try
      {
        localt.zNr = localbyq.toByteArray();
        localt.dZj();
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.snsMediaStorage", paramString1, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean a(String paramString, t paramt)
  {
    AppMethodBeat.i(97600);
    ad.d("MicroMsg.snsMediaStorage", "replace AlbumLikeList ".concat(String.valueOf(paramString)));
    Cursor localCursor = this.hHS.a("SnsMedia", null, "StrId=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (localCursor.moveToFirst())
    {
      localCursor.close();
      bool = a(paramt);
      AppMethodBeat.o(97600);
      return bool;
    }
    localCursor.close();
    boolean bool = b(paramString, paramt);
    AppMethodBeat.o(97600);
    return bool;
  }
  
  public final t aAs(String paramString)
  {
    AppMethodBeat.i(97603);
    t localt = new t();
    paramString = this.hHS.a("SnsMedia", null, "StrId=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (paramString.moveToFirst())
    {
      localt.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(97603);
      return localt;
    }
    paramString.close();
    AppMethodBeat.o(97603);
    return null;
  }
  
  public final List<p> fR(List<p> paramList)
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
      p localp1 = (p)paramList.next();
      int i = a(localp1);
      if (i == -1)
      {
        AppMethodBeat.o(97605);
        return null;
      }
      p localp2 = new p(i, localp1.type);
      localp2.height = localp1.height;
      localp2.width = localp1.width;
      localp2.fileSize = localp1.fileSize;
      localLinkedList.add(localp2);
    }
    AppMethodBeat.o(97605);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.u
 * JD-Core Version:    0.7.0.1
 */