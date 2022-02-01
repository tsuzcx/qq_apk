package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.memory.l;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.data.q;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.d.a;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.protocal.protobuf.bzk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.vfs.o;
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
  extends com.tencent.mm.sdk.e.k
{
  public static final String[] SQL_CREATE;
  private static Point htn;
  private static int zop;
  private static int zpi;
  public com.tencent.mm.storagebase.h hKK;
  
  static
  {
    AppMethodBeat.i(97620);
    SQL_CREATE = new String[] { "CREATE TABLE IF NOT EXISTS SnsMedia ( local_id INTEGER PRIMARY KEY, seqId LONG, type INT, createTime LONG, userName VARCHAR(40), totallen INT, offset INT, local_flag INT, tmp_path TEXT, nums INT, try_times INT, StrId VARCHAR(40), upload_buf TEXT, reserved1 INT, reserved2 TEXT, reserved3 TEXT, reserved4 TEXT, reserved5 TEXT )", "CREATE INDEX IF NOT EXISTS serverSnsMediaTimeIndex ON SnsMedia ( createTime )" };
    zpi = 0;
    zop = 0;
    htn = new Point();
    AppMethodBeat.o(97620);
  }
  
  public u(com.tencent.mm.storagebase.h paramh)
  {
    this.hKK = paramh;
  }
  
  private int a(q paramq)
  {
    AppMethodBeat.i(97607);
    localObject1 = ah.getAccSnsPath();
    str2 = ah.getAccSnsTmpPath();
    ae.i("MicroMsg.snsMediaStorage", "SnsMediaStorage %s %s", new Object[] { localObject1, str2 });
    l = System.currentTimeMillis();
    str1 = paramq.path;
    i = paramq.type;
    if (!o.fB(str1))
    {
      AppMethodBeat.o(97607);
      return -1;
    }
    str4 = com.tencent.mm.b.g.getMessageDigest((str1 + System.currentTimeMillis()).getBytes());
    str3 = r.azm(str4);
    ae.d("MicroMsg.snsMediaStorage", "insert : original img path = ".concat(String.valueOf(str1)));
    if (!o.fB(str2))
    {
      ae.i("MicroMsg.snsMediaStorage", "create snstmp path ".concat(String.valueOf(str2)));
      o.aZI(str2);
    }
    if (!o.fB((String)localObject1))
    {
      ae.i("MicroMsg.snsMediaStorage", "create snsPath ".concat(String.valueOf(localObject1)));
      o.aZI((String)localObject1);
    }
    localObject2 = new com.tencent.mm.plugin.image.b();
    localObject3 = a(paramq, str1);
    j = ((q)localObject3).width;
    int k = ((q)localObject3).height;
    int m = ((q)localObject3).fileSize;
    ((com.tencent.mm.plugin.image.b)localObject2).uVd = str1;
    ((com.tencent.mm.plugin.image.b)localObject2).uVf = j;
    ((com.tencent.mm.plugin.image.b)localObject2).uVg = k;
    ((com.tencent.mm.plugin.image.b)localObject2).uVh = m;
    if (!d(str2, str1, str3, true))
    {
      AppMethodBeat.o(97607);
      return -1;
    }
    ae.d("MicroMsg.snsMediaStorage", "insert0 " + (System.currentTimeMillis() - l));
    ae.d("MicroMsg.snsMediaStorage", "insert: compressed bigMediaPath = ".concat(String.valueOf(str3)));
    str1 = str2 + str3;
    j = (int)o.aZR(str1);
    if (r.aou(str1) == 2)
    {
      localObject4 = com.tencent.mm.sdk.platformtools.h.cv(o.bb(str1, 0, j));
      if (localObject4 != null) {
        ae.i("MicroMsg.snsMediaStorage", "insert yuvInfo:%s", new Object[] { localObject4 });
      }
    }
    try
    {
      localObject1 = o.k(str1, false);
      paramq = (q)localObject1;
      if (localObject1 == null) {
        paramq = str1;
      }
      paramq = new android.support.e.a(paramq);
      paramq.setAttribute("UserComment", (String)localObject4);
      paramq.saveAttributes();
    }
    catch (Exception paramq)
    {
      try
      {
        ((t)localObject1).Aey = paramq.toByteArray();
        ((t)localObject1).ecN();
        ((t)localObject1).Aet = j;
        ae.i("MicroMsg.snsMediaStorage", "insert a local snsMedia  totallen  :" + j + " filepath: " + str2 + str3);
        i = (int)this.hKK.a("SnsMedia", "local_id", ((t)localObject1).ecM());
        ae.d("MicroMsg.snsMediaStorage", "insert localId ".concat(String.valueOf(i)));
        str4 = "Locall_path".concat(String.valueOf(i));
        ((com.tencent.mm.plugin.image.b)localObject2).uVe = String.valueOf(i);
        ((com.tencent.mm.plugin.image.b)localObject2).md5 = paramq.md5;
        localObject3 = Exif.fromFile(((com.tencent.mm.plugin.image.b)localObject2).uVd);
        j = com.tencent.mm.plugin.image.b.aou(((com.tencent.mm.plugin.image.b)localObject2).uVd);
        paramq = ((Exif)localObject3).dateTimeOriginal;
        localObject4 = ((com.tencent.mm.plugin.image.b)localObject2).uVd;
        if (bu.isNullOrNil(paramq)) {
          break label1924;
        }
        paramq = com.tencent.mm.plugin.image.b.aov(paramq);
        localObject4 = new com.tencent.mm.modelsns.g();
        ((com.tencent.mm.modelsns.g)localObject4).m("20 localID", ((com.tencent.mm.plugin.image.b)localObject2).uVe + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("21 MediaType", j + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("22 OriginWidth", ((com.tencent.mm.plugin.image.b)localObject2).uVf + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("23 OriginHeight", ((com.tencent.mm.plugin.image.b)localObject2).uVg + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("24 CompressedWidth", ((com.tencent.mm.plugin.image.b)localObject2).uVi + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("25 CompressedHeight", ((com.tencent.mm.plugin.image.b)localObject2).uVj + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("26 OriginSize", ((com.tencent.mm.plugin.image.b)localObject2).uVh + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("27 CompressedSize", ((com.tencent.mm.plugin.image.b)localObject2).uVk + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("28 FNumber", ((Exif)localObject3).fNumber + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("29 ExposureTime", ((Exif)localObject3).exposureTime + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("30 ISO", ((Exif)localObject3).isoSpeedRatings + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("31 Flash", ((Exif)localObject3).flash + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("32 LensModel", com.tencent.mm.plugin.image.b.aov(((Exif)localObject3).model) + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("33 CreatTime", paramq + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("34 IsFromWeChat", "0,");
        ((com.tencent.mm.modelsns.g)localObject4).m("35 Scene", ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("36 sceneType", ((Exif)localObject3).sceneType + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("37 fileSource", ((Exif)localObject3).fileSource + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("38 make", ((Exif)localObject3).make + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("39 software", ((Exif)localObject3).software + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("40 fileExt", com.tencent.mm.plugin.image.b.aaw(((com.tencent.mm.plugin.image.b)localObject2).uVd) + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("41 faceCount", "0,");
        ((com.tencent.mm.modelsns.g)localObject4).m("42 YCbCrSubSampling", ((Exif)localObject3).yCbCrSubSampling + ",");
        ((com.tencent.mm.modelsns.g)localObject4).m("43 md5", ((com.tencent.mm.plugin.image.b)localObject2).md5 + ',');
        ae.v("MicroMsg.ImgExtInfoReport", "report logbuffer MMImageExifInfo(14525): %s, orgPath:%s", new Object[] { ((com.tencent.mm.modelsns.g)localObject4).RD(), ((com.tencent.mm.plugin.image.b)localObject2).uVd });
        com.tencent.mm.plugin.report.service.g.yxI.f(14525, new Object[] { localObject4 });
        paramq = ((com.tencent.mm.modelsns.g)localObject4).toString();
        localObject2 = com.tencent.mm.plugin.sns.j.d.dZe();
        j = com.tencent.mm.plugin.image.b.aou(str1);
        ((com.tencent.mm.plugin.sns.j.d)localObject2).zKJ.put(Integer.valueOf(i), new d.a((com.tencent.mm.plugin.sns.j.d)localObject2, j, paramq));
        paramq = r.azm(str4);
        str1 = aBI(str4);
        o.aZI(str1);
        ae.i("MicroMsg.snsMediaStorage", "checkcntpath ".concat(String.valueOf(str1)));
        o.mF(str2 + str3, str1 + paramq);
        str2 = str1 + r.azi(str4);
        str3 = str1 + r.azj(str4);
        o.deleteFile(str2);
        o.deleteFile(str3);
        ae.i("MicroMsg.snsMediaStorage", "insert done " + (System.currentTimeMillis() - l) + " targetPath : " + str1 + paramq + " totalLen:" + o.aZR(new StringBuilder().append(str1).append(paramq).toString()) + "  now delete...:" + str2 + " & " + str3);
        ((t)localObject1).Aeu = str4;
        a(i, (t)localObject1);
        AppMethodBeat.o(97607);
        return i;
        paramq = paramq;
        ae.printErrStackTrace("MicroMsg.snsMediaStorage", paramq, "", new Object[0]);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
          continue;
          paramq = com.tencent.mm.plugin.image.b.aov(new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(new Date(new com.tencent.mm.vfs.k((String)localObject4).lastModified())));
        }
      }
    }
    j = (int)o.aZR(str2 + str3);
    localObject3 = a((q)localObject3, str2 + str3);
    k = ((q)localObject3).width;
    m = ((q)localObject3).height;
    ((com.tencent.mm.plugin.image.b)localObject2).uVi = k;
    ((com.tencent.mm.plugin.image.b)localObject2).uVj = m;
    ((com.tencent.mm.plugin.image.b)localObject2).uVk = j;
    localObject1 = new t();
    ((t)localObject1).Aeu = str4;
    ((t)localObject1).createTime = ((int)bu.aRi());
    ((t)localObject1).type = i;
    paramq = new bzk();
    paramq.Hml = ((q)localObject3).zur;
    paramq.HmH = ((q)localObject3).zuq;
    paramq.token = ((q)localObject3).zus;
    paramq.HmQ = ((q)localObject3).zut;
    paramq.Hne = 0;
    paramq.Hnd = new bzc();
    paramq.hiJ = 0;
    paramq.Desc = ((q)localObject3).desc;
    ae.d("MicroMsg.snsMediaStorage", "upload.filterId " + ((q)localObject3).zup);
    paramq.HmG = ((q)localObject3).zup;
    paramq.HiZ = 2;
    paramq.md5 = o.aRh(str2 + str3);
  }
  
  private static q a(q paramq, String paramString)
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
        localObject5 = o.openRead(paramString);
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
        com.tencent.mm.sdk.platformtools.h.decodeFile(paramString, localOptions);
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
        ae.printErrStackTrace("MicroMsg.snsMediaStorage", localObject4, "setImageExtInfo failed: ".concat(String.valueOf(paramString)), new Object[0]);
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
            throw paramq;
            localIOException2 = localIOException2;
            k = i;
            m = j;
          }
          catch (IOException paramString) {}
        }
      }
      paramq.width = m;
      paramq.height = k;
      paramq.fileSize = ((int)o.aZR(paramString));
      AppMethodBeat.o(97606);
      return paramq;
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
    AppMethodBeat.i(219646);
    try
    {
      byte[] arrayOfByte = aq(paramBitmap);
      com.tencent.mm.plugin.emoji.d.cha();
      if (com.tencent.mm.plugin.emoji.d.a(arrayOfByte, paramString1, paramString2, paramBitmap.getWidth(), paramBitmap.getHeight(), paramInt1, paramInt2) == 0)
      {
        AppMethodBeat.o(219646);
        return true;
      }
      AppMethodBeat.o(219646);
      return false;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      ae.w("MicroMsg.snsMediaStorage", "convertImg2WxamZip bmp OutOfMemoryError! rollback");
      AppMethodBeat.o(219646);
    }
    return false;
  }
  
  private boolean a(t paramt)
  {
    AppMethodBeat.i(97599);
    ae.d("MicroMsg.snsMediaStorage", "snsMedia Insert");
    if (paramt == null)
    {
      AppMethodBeat.o(97599);
      return false;
    }
    paramt = paramt.ecM();
    if ((int)this.hKK.a("SnsMedia", "local_id", paramt) != -1)
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
      ae.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, srcWidth: %s, srcHeight: %s, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt3) });
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
      ae.printErrStackTrace("MicroMsg.snsMediaStorage", paramString1, "create thumbnail from orig failed: %s", new Object[] { paramString3 });
      com.tencent.mm.plugin.report.service.g.yxI.n(1487L, 1L, 1L);
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
        Bitmap localBitmap;
        try
        {
          paramCompressFormat.close();
          AppMethodBeat.o(97617);
          return false;
          i = 0;
          continue;
          d3 = d1;
          break label883;
          d3 = d2;
          break label905;
          ae.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, sampleSize: %s", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject1).inSampleSize) });
          localObject1 = com.tencent.mm.plugin.sns.d.a.b(paramString1, (BitmapFactory.Options)localObject1);
          continue;
          ae.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()) });
          localObject2 = localObject1;
          if (paramBoolean)
          {
            if (d1 < d2)
            {
              paramInt2 = (int)Math.ceil(paramInt4 * 1.0D * paramInt2 / paramInt1);
              paramInt1 = paramInt4;
              paramInt3 = BackwardSupportUtil.ExifHelper.df(paramString1);
              if (paramInt3 == 90) {
                break label913;
              }
              if (paramInt3 != 270) {
                break label862;
              }
              break label913;
              localBitmap = Bitmap.createScaledBitmap((Bitmap)localObject1, paramInt1, paramInt2, true);
              localObject2 = localObject1;
              if (localBitmap != null)
              {
                if (localObject1 == localBitmap) {
                  break label922;
                }
                l.ayS().D((Bitmap)localObject1);
                break label922;
              }
              ae.i("MicroMsg.snsMediaStorage", "createThumbNailUnScalebyUpload, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(localObject2.getWidth()), Integer.valueOf(localObject2.getHeight()) });
            }
          }
          else
          {
            if ((!ecQ()) || (!paramBoolean)) {
              continue;
            }
            if (b(localObject2, paramString1, paramString2 + paramString3)) {
              break label859;
            }
            o.deleteFile(paramString2 + paramString3);
            localObject1 = o.db(paramString2 + paramString3, false);
            paramString1 = (String)localObject1;
            paramString2 = (String)localObject1;
          }
        }
        catch (IOException paramString1)
        {
          try
          {
            com.tencent.mm.sdk.platformtools.h.a(localObject2, paramInt5, paramCompressFormat, (OutputStream)localObject1, false);
            paramString1 = (String)localObject1;
            paramString2 = (String)localObject1;
            ((OutputStream)localObject1).close();
            try
            {
              l.ayS().D(localObject2);
              AppMethodBeat.o(97617);
              return true;
            }
            catch (IOException paramString1)
            {
              paramCompressFormat = null;
              continue;
            }
            catch (OutOfMemoryError paramString1)
            {
              paramCompressFormat = null;
            }
            d1 = paramInt3 * 1.0D * paramInt1 / paramInt2;
            paramInt1 = (int)Math.ceil(d1);
            paramInt2 = paramInt3;
            continue;
            Object localObject1 = o.db(paramString2 + paramString3, false);
            paramString1 = (String)localObject1;
            paramString2 = (String)localObject1;
            com.tencent.mm.sdk.platformtools.h.a(localObject2, paramInt5, paramCompressFormat, (OutputStream)localObject1, false);
            paramString1 = (String)localObject1;
            paramString2 = (String)localObject1;
            l.ayS().D(localObject2);
            paramString1 = (String)localObject1;
            paramString2 = (String)localObject1;
            ((OutputStream)localObject1).close();
            continue;
          }
          catch (OutOfMemoryError paramString2)
          {
            paramCompressFormat = paramString1;
            paramString1 = paramString2;
            continue;
            paramString1 = paramString1;
            paramCompressFormat = localObject3;
            ae.printErrStackTrace("MicroMsg.snsMediaStorage", paramString1, "create thumbnail from orig failed: %s", new Object[] { paramString3 });
            if (paramCompressFormat != null) {}
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
          catch (IOException paramString1)
          {
            paramCompressFormat = paramString2;
            continue;
          }
        }
        continue;
        continue;
        continue;
        break label871;
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
              localObject2 = localBitmap;
            }
          }
        }
      }
    }
    ae.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, result bm: %s", new Object[] { localObject1 });
    if (localObject1 == null)
    {
      AppMethodBeat.o(97617);
      return false;
      ((BitmapFactory.Options)localObject1).inSampleSize = 1;
      if ((paramInt2 > paramInt3) || (paramInt1 > paramInt4))
      {
        if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxU, 0)) {
          break label323;
        }
        i = 1;
        if ((j.IS_FLAVOR_PURPLE) || (j.IS_FLAVOR_RED)) {
          break label868;
        }
        if (!j.DEBUG) {
          break label865;
        }
        break label868;
        ((BitmapFactory.Options)localObject1).inSampleSize = j;
        if (((BitmapFactory.Options)localObject1).inSampleSize <= 1) {
          ((BitmapFactory.Options)localObject1).inSampleSize = 1;
        }
      }
      l = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxV, 10240000);
      while (paramInt2 * paramInt1 / ((BitmapFactory.Options)localObject1).inSampleSize / ((BitmapFactory.Options)localObject1).inSampleSize > l) {
        ((BitmapFactory.Options)localObject1).inSampleSize += 1;
      }
    }
  }
  
  private static boolean a(String paramString1, int paramInt1, int paramInt2, int paramInt3, Bitmap.CompressFormat paramCompressFormat, int paramInt4, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(219648);
    localObject4 = null;
    localObject1 = localObject4;
    for (;;)
    {
      try
      {
        ae.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, srcWidth: %d, srcHeight: %d, fixShort: %d, quality:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
        localObject1 = localObject4;
        localObject2 = new BitmapFactory.Options();
        if (paramInt2 <= paramInt1) {
          continue;
        }
        i = paramInt1;
        if (i != paramInt3) {
          continue;
        }
        localObject1 = localObject4;
        localObject2 = com.tencent.mm.plugin.sns.d.a.b(paramString1, (BitmapFactory.Options)localObject2);
      }
      catch (OutOfMemoryError paramString1)
      {
        long l;
        paramCompressFormat = null;
        ae.printErrStackTrace("MicroMsg.snsMediaStorage", paramString1, "create thumbnail from orig failed: %s", new Object[] { paramString3 });
        com.tencent.mm.plugin.report.service.g.yxI.n(1487L, 0L, 1L);
        if (paramCompressFormat == null) {
          continue;
        }
      }
      catch (IOException paramString1)
      {
        Object localObject2;
        try
        {
          int i;
          paramCompressFormat.close();
          AppMethodBeat.o(219648);
          return false;
          localObject1 = localObject4;
          ae.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, sampleSize: %s", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject2).inSampleSize) });
          localObject1 = localObject4;
          localObject2 = com.tencent.mm.plugin.sns.d.a.b(paramString1, (BitmapFactory.Options)localObject2);
          continue;
          localObject1 = localObject4;
          j = paramInt1 * paramInt3 / i;
          localObject1 = localObject4;
          paramInt3 = paramInt2 * paramInt3 / i;
          localObject1 = localObject4;
          int m = BackwardSupportUtil.ExifHelper.df(paramString1);
          if (m == 90) {
            continue;
          }
          if (m != 270) {
            continue;
          }
          continue;
          localObject1 = localObject4;
          ae.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, bm.width: %s, bm.height: %s, new:[%d,%d], src:[%d, %d], shortEdge:%d,degree:%d", new Object[] { Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()), Integer.valueOf(j), Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(m) });
          localObject1 = localObject4;
          Bitmap localBitmap = Bitmap.createScaledBitmap((Bitmap)localObject2, j, paramInt3, true);
          if (localBitmap == null) {
            continue;
          }
          localObject3 = localBitmap;
          if (localObject2 != localBitmap)
          {
            localObject1 = localObject4;
            l.ayS().D((Bitmap)localObject2);
            localObject3 = localBitmap;
          }
          localObject1 = localObject4;
          ae.i("MicroMsg.snsMediaStorage", "createThumbNailUnScaleFixShort, bm.width: %s, bm.height: %s, quality:%d", new Object[] { Integer.valueOf(((Bitmap)localObject3).getWidth()), Integer.valueOf(((Bitmap)localObject3).getHeight()), Integer.valueOf(paramInt4) });
          localObject1 = localObject4;
          if ((ecQ()) && (paramBoolean))
          {
            localObject1 = localObject4;
            if (!a((Bitmap)localObject3, paramString1, paramString2 + paramString3, j, paramInt3))
            {
              localObject1 = localObject4;
              o.deleteFile(paramString2 + paramString3);
              localObject1 = localObject4;
              localObject2 = o.db(paramString2 + paramString3, false);
              localObject1 = localObject2;
              paramString1 = (String)localObject2;
            }
          }
          try
          {
            com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject3, paramInt4, paramCompressFormat, (OutputStream)localObject2, false);
            localObject1 = localObject2;
            paramString1 = (String)localObject2;
            ((OutputStream)localObject2).close();
            localObject1 = null;
            l.ayS().D((Bitmap)localObject3);
            localObject1 = null;
            ae.i("MicroMsg.snsMediaStorage", "createThumbNailUnScaleFixShort saving to %s, size:%d", new Object[] { paramString2 + paramString3, Long.valueOf(o.aZR(paramString2 + paramString3)) });
            AppMethodBeat.o(219648);
            return true;
          }
          catch (OutOfMemoryError paramString2)
          {
            paramCompressFormat = paramString1;
            paramString1 = paramString2;
          }
          localObject1 = localObject4;
          localObject2 = o.db(paramString2 + paramString3, false);
          localObject1 = localObject2;
          paramString1 = (String)localObject2;
          com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject3, paramInt4, paramCompressFormat, (OutputStream)localObject2, false);
          localObject1 = localObject2;
          paramString1 = (String)localObject2;
          l.ayS().D((Bitmap)localObject3);
          localObject1 = localObject2;
          paramString1 = (String)localObject2;
          ((OutputStream)localObject2).close();
          continue;
          paramString1 = paramString1;
          ae.printErrStackTrace("MicroMsg.snsMediaStorage", paramString1, "create thumbnail from orig failed: %s", new Object[] { paramString3 });
          if (localObject1 == null) {}
        }
        catch (IOException paramString1)
        {
          try
          {
            localObject1.close();
            AppMethodBeat.o(219648);
            return false;
            paramString1 = paramString1;
          }
          catch (IOException paramString1)
          {
            continue;
          }
        }
        continue;
        Object localObject3 = localObject2;
        continue;
        continue;
        int k = paramInt3;
        paramInt3 = j;
        int j = k;
        continue;
      }
      localObject1 = localObject4;
      ae.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, result bm: %s", new Object[] { localObject2 });
      if (localObject2 != null) {
        continue;
      }
      AppMethodBeat.o(219648);
      return false;
      i = paramInt2;
    }
    localObject1 = localObject4;
    ((BitmapFactory.Options)localObject2).inSampleSize = 1;
    if (i > paramInt3)
    {
      localObject1 = localObject4;
      ((BitmapFactory.Options)localObject2).inSampleSize = (i / paramInt3);
      localObject1 = localObject4;
      if (((BitmapFactory.Options)localObject2).inSampleSize <= 1)
      {
        localObject1 = localObject4;
        ((BitmapFactory.Options)localObject2).inSampleSize = 1;
      }
    }
    localObject1 = localObject4;
    l = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxV, 10240000);
    for (;;)
    {
      localObject1 = localObject4;
      if (paramInt2 * paramInt1 / ((BitmapFactory.Options)localObject2).inSampleSize / ((BitmapFactory.Options)localObject2).inSampleSize <= l) {
        break;
      }
      localObject1 = localObject4;
      ((BitmapFactory.Options)localObject2).inSampleSize += 1;
    }
  }
  
  private static boolean a(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(97613);
    BitmapFactory.Options localOptions = com.tencent.mm.sdk.platformtools.h.aRz(paramString1);
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
      localObject3 = o.openRead(paramString1 + paramString2);
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
  
  private static String aBI(String paramString)
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
    paramString = ah.getAccSnsPath() + paramString + str1;
    AppMethodBeat.o(97598);
    return paramString;
  }
  
  /* Error */
  public static boolean aBK(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 833
    //   5: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 589	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
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
    //   35: invokestatic 798	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   38: pop
    //   39: aload_0
    //   40: astore_2
    //   41: aload_3
    //   42: getfield 803	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   45: astore_3
    //   46: aload_0
    //   47: astore_2
    //   48: ldc 65
    //   50: ldc_w 835
    //   53: aload_3
    //   54: invokestatic 130	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   57: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   60: invokestatic 137	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_0
    //   64: astore_2
    //   65: aload_3
    //   66: invokevirtual 838	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   69: ldc_w 840
    //   72: invokevirtual 843	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   75: istore_1
    //   76: iload_1
    //   77: iflt +19 -> 96
    //   80: aload_0
    //   81: ifnull +7 -> 88
    //   84: aload_0
    //   85: invokevirtual 629	java/io/InputStream:close	()V
    //   88: ldc_w 833
    //   91: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: iconst_1
    //   95: ireturn
    //   96: aload_0
    //   97: ifnull +7 -> 104
    //   100: aload_0
    //   101: invokevirtual 629	java/io/InputStream:close	()V
    //   104: ldc_w 833
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
    //   123: ldc_w 833
    //   126: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: iconst_0
    //   130: ireturn
    //   131: astore_0
    //   132: aload_2
    //   133: ifnull +7 -> 140
    //   136: aload_2
    //   137: invokevirtual 629	java/io/InputStream:close	()V
    //   140: ldc_w 833
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
  
  public static Bitmap aBL(String paramString)
  {
    int j = 640;
    AppMethodBeat.i(97619);
    Object localObject = com.tencent.mm.sdk.platformtools.h.aRz(paramString);
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
      localObject = com.tencent.mm.sdk.platformtools.h.d(paramString, j, i, false);
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
    paramString = com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject, Exif.fromFile(paramString).getOrientationInDegree());
    AppMethodBeat.o(97619);
    return paramString;
  }
  
  public static boolean aG(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(224107);
    boolean bool = d(paramString1, paramString2, paramString3, true);
    AppMethodBeat.o(224107);
    return bool;
  }
  
  private static byte[] aq(Bitmap paramBitmap)
  {
    AppMethodBeat.i(219643);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramBitmap.getByteCount());
    paramBitmap.copyPixelsToBuffer(localByteBuffer);
    paramBitmap = localByteBuffer.array();
    AppMethodBeat.o(219643);
    return paramBitmap;
  }
  
  private static boolean b(Bitmap paramBitmap, String paramString1, String paramString2)
  {
    AppMethodBeat.i(219645);
    try
    {
      byte[] arrayOfByte = aq(paramBitmap);
      com.tencent.mm.plugin.emoji.d.cha();
      if (com.tencent.mm.plugin.emoji.d.a(arrayOfByte, paramString1, paramString2, paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getWidth(), paramBitmap.getHeight()) == 0)
      {
        AppMethodBeat.o(219645);
        return true;
      }
      AppMethodBeat.o(219645);
      return false;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      ae.w("MicroMsg.snsMediaStorage", "convertImg2WxamWithoutZip bmp OutOfMemoryError! rollback");
      AppMethodBeat.o(219645);
    }
    return false;
  }
  
  private boolean b(String paramString, t paramt)
  {
    AppMethodBeat.i(97601);
    paramt = paramt.ecM();
    if (this.hKK.update("SnsMedia", paramt, "StrId=?", new String[] { String.valueOf(paramString) }) > 0)
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
        o.deleteFile(paramString1 + paramString3);
        localObject1 = com.tencent.mm.sdk.platformtools.h.aRz(paramString1 + paramString2);
        if (localObject1 == null)
        {
          ae.e("MicroMsg.snsMediaStorage", "createUserAlbum, getImageOptions error");
          AppMethodBeat.o(97618);
          return false;
        }
        if ((((BitmapFactory.Options)localObject1).outMimeType == null) || ((!((BitmapFactory.Options)localObject1).outMimeType.toLowerCase().endsWith("png")) && (!((BitmapFactory.Options)localObject1).outMimeType.toLowerCase().endsWith("vcodec")) && (!((BitmapFactory.Options)localObject1).outMimeType.toLowerCase().endsWith("wxam")))) {
          continue;
        }
        localObject1 = com.tencent.mm.sdk.platformtools.h.d(paramString1 + paramString2, (int)paramFloat, (int)paramFloat, true);
      }
      catch (OutOfMemoryError paramString1)
      {
        int i1;
        int n;
        double d2;
        ae.printErrStackTrace("MicroMsg.snsMediaStorage", paramString1, "create thumbnail from orig failed: %s", new Object[] { paramString3 });
        com.tencent.mm.plugin.report.service.g.yxI.n(1487L, 2L, 1L);
        AppMethodBeat.o(97618);
        return false;
        double d1 = k * 1.0D * i1 / n;
        i = (int)Math.ceil(d1);
        int j = k;
        continue;
        ae.i("MicroMsg.snsMediaStorage", "createUserAlbum, inSampleSize: %s", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject1).inSampleSize) });
        if (n / i1 != k / m) {
          continue;
        }
        Object localObject1 = com.tencent.mm.plugin.sns.d.a.b(paramString1 + paramString2, (BitmapFactory.Options)localObject1);
        ae.i("MicroMsg.snsMediaStorage", "createUserAlbum, directly use inSampleSize");
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
        localObject2 = l.ayS().a(str, (Rect)localObject2, (BitmapFactory.Options)localObject1);
        localObject1 = localObject2;
        if (localObject2 == null) {
          continue;
        }
        localObject1 = r.t(str, (Bitmap)localObject2);
        ae.d("MicroMsg.SnsBitmapUtil", "regionDecodeWithRotateByExif used %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        ae.i("MicroMsg.snsMediaStorage", "createUserAlbum, dstWidth: %s, dstHeight: %s, startX: %s, startY: %s, scaleFactor: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(paramFloat) });
        continue;
        ae.i("MicroMsg.snsMediaStorage", "createUserAlbum, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()) });
        i = 1;
        if ((((Bitmap)localObject1).getHeight() > 120) || (((Bitmap)localObject1).getWidth() > 120)) {
          continue;
        }
        if (i == 0) {
          continue;
        }
        paramString2 = Bitmap.CompressFormat.PNG;
        com.tencent.mm.sdk.platformtools.h.a((Bitmap)localObject1, 100, paramString2, paramString1 + paramString3, false);
        l.ayS().D((Bitmap)localObject1);
        AppMethodBeat.o(97618);
        return true;
        paramString2 = Bitmap.CompressFormat.JPEG;
        continue;
      }
      catch (Exception paramString1)
      {
        ae.e("MicroMsg.snsMediaStorage", "createUserAlbum error: %s", new Object[] { paramString1.getMessage() });
        ae.printErrStackTrace("MicroMsg.snsMediaStorage", paramString1, "", new Object[0]);
        continue;
        continue;
        int i = 0;
        continue;
      }
      if (localObject1 != null) {
        continue;
      }
      ae.i("MicroMsg.snsMediaStorage", "bitmap error " + paramString1 + paramString2);
      o.deleteFile(paramString1 + paramString2);
      AppMethodBeat.o(97618);
      return false;
      i1 = ((BitmapFactory.Options)localObject1).outWidth;
      n = ((BitmapFactory.Options)localObject1).outHeight;
      m = (int)paramFloat;
      k = (int)paramFloat;
      ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
      ae.i("MicroMsg.snsMediaStorage", "createUserAlbum, srcWidth: %s, srcHeight: %s, dstWidth: %s, dstHeight: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k) });
      if ((i1 != m) || (n != k)) {
        continue;
      }
      localObject1 = com.tencent.mm.plugin.sns.d.a.b(paramString1 + paramString2, (BitmapFactory.Options)localObject1);
    }
    if (n * 1.0D / k > i1 * 1.0D / m)
    {
      j = (int)Math.ceil(m * 1.0D * n / i1);
      i = m;
      ae.d("MicroMsg.snsMediaStorage", "createUserAlbum, newWidth: %s, newHeight: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
      l = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qxV, 10240000);
      while (n * i1 / ((BitmapFactory.Options)localObject1).inSampleSize / ((BitmapFactory.Options)localObject1).inSampleSize > l) {
        ((BitmapFactory.Options)localObject1).inSampleSize += 1;
      }
    }
  }
  
  /* Error */
  public static boolean d(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 964
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 788	com/tencent/mm/sdk/platformtools/h:aRz	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   10: astore 20
    //   12: aload 20
    //   14: ifnull +1047 -> 1061
    //   17: aload 20
    //   19: getfield 803	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   22: astore 21
    //   24: ldc 65
    //   26: ldc_w 966
    //   29: aload 21
    //   31: invokestatic 130	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   34: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokestatic 137	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload 21
    //   42: ifnull +1019 -> 1061
    //   45: aload 21
    //   47: invokevirtual 838	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   50: astore 21
    //   52: aload 21
    //   54: ldc_w 968
    //   57: invokevirtual 843	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   60: iflt +967 -> 1027
    //   63: iconst_1
    //   64: istore 16
    //   66: aload 20
    //   68: ifnull +1016 -> 1084
    //   71: aload 20
    //   73: getfield 803	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   76: astore 21
    //   78: aload 21
    //   80: ifnull +1004 -> 1084
    //   83: aload 21
    //   85: invokevirtual 838	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   88: astore 21
    //   90: aload 21
    //   92: ldc_w 968
    //   95: invokevirtual 843	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   98: iflt +969 -> 1067
    //   101: iconst_1
    //   102: istore 17
    //   104: aload 20
    //   106: ifnull +27 -> 133
    //   109: aload 20
    //   111: getfield 803	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   114: astore 21
    //   116: aload 21
    //   118: ifnull +15 -> 133
    //   121: aload 21
    //   123: invokevirtual 838	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   126: ldc_w 895
    //   129: invokevirtual 843	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   132: pop
    //   133: iconst_m1
    //   134: istore 8
    //   136: bipush 100
    //   138: istore 9
    //   140: iload 8
    //   142: istore 10
    //   144: iload_3
    //   145: ifeq +242 -> 387
    //   148: invokestatic 974	com/tencent/mm/an/f:aGZ	()Lcom/tencent/mm/an/b;
    //   151: pop
    //   152: bipush 64
    //   154: invokestatic 980	com/tencent/mm/an/b:pd	(I)Z
    //   157: ifne +21 -> 178
    //   160: invokestatic 983	com/tencent/mm/plugin/sns/storage/u:ecP	()Z
    //   163: ifne +15 -> 178
    //   166: invokestatic 986	com/tencent/mm/plugin/sns/storage/u:ecR	()Z
    //   169: ifne +9 -> 178
    //   172: invokestatic 755	com/tencent/mm/plugin/sns/storage/u:ecQ	()Z
    //   175: ifeq +990 -> 1165
    //   178: invokestatic 992	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   181: invokestatic 998	com/tencent/mm/sdk/platformtools/az:isWifi	(Landroid/content/Context;)Z
    //   184: ifeq +906 -> 1090
    //   187: invokestatic 1004	com/tencent/mm/n/g:acL	()Lcom/tencent/mm/n/e;
    //   190: ldc_w 1006
    //   193: invokevirtual 1011	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   196: bipush 70
    //   198: invokestatic 1015	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   201: istore 7
    //   203: ldc 65
    //   205: ldc_w 1017
    //   208: bipush 7
    //   210: anewarray 69	java/lang/Object
    //   213: dup
    //   214: iconst_0
    //   215: invokestatic 1004	com/tencent/mm/n/g:acL	()Lcom/tencent/mm/n/e;
    //   218: ldc_w 1006
    //   221: invokevirtual 1011	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   224: aastore
    //   225: dup
    //   226: iconst_1
    //   227: invokestatic 1004	com/tencent/mm/n/g:acL	()Lcom/tencent/mm/n/e;
    //   230: ldc_w 1019
    //   233: invokevirtual 1011	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   236: aastore
    //   237: dup
    //   238: iconst_2
    //   239: invokestatic 1004	com/tencent/mm/n/g:acL	()Lcom/tencent/mm/n/e;
    //   242: ldc_w 1021
    //   245: invokevirtual 1011	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   248: aastore
    //   249: dup
    //   250: iconst_3
    //   251: invokestatic 1004	com/tencent/mm/n/g:acL	()Lcom/tencent/mm/n/e;
    //   254: ldc_w 1023
    //   257: invokevirtual 1011	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   260: aastore
    //   261: dup
    //   262: iconst_4
    //   263: invokestatic 1004	com/tencent/mm/n/g:acL	()Lcom/tencent/mm/n/e;
    //   266: ldc_w 1025
    //   269: invokevirtual 1011	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   272: aastore
    //   273: dup
    //   274: iconst_5
    //   275: invokestatic 1004	com/tencent/mm/n/g:acL	()Lcom/tencent/mm/n/e;
    //   278: ldc_w 1027
    //   281: invokevirtual 1011	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   284: aastore
    //   285: dup
    //   286: bipush 6
    //   288: invokestatic 1004	com/tencent/mm/n/g:acL	()Lcom/tencent/mm/n/e;
    //   291: ldc_w 1029
    //   294: invokevirtual 1011	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   297: aastore
    //   298: invokestatic 903	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: ldc 65
    //   303: ldc_w 1031
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
    //   321: invokestatic 1036	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   324: aastore
    //   325: invokestatic 74	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   328: iload 7
    //   330: bipush 10
    //   332: if_icmple +10 -> 342
    //   335: iload 7
    //   337: bipush 100
    //   339: if_icmple +3602 -> 3941
    //   342: bipush 60
    //   344: istore 7
    //   346: iload 8
    //   348: istore 10
    //   350: iload 7
    //   352: istore 9
    //   354: iload 17
    //   356: ifeq +31 -> 387
    //   359: aload_1
    //   360: invokestatic 1041	com/tencent/mm/sdk/platformtools/MMNativeJpeg:queryQuality	(Ljava/lang/String;)I
    //   363: istore 8
    //   365: iload 8
    //   367: iload 7
    //   369: if_icmpge +3561 -> 3930
    //   372: iload 8
    //   374: bipush 25
    //   376: if_icmple +3554 -> 3930
    //   379: iload 8
    //   381: istore 9
    //   383: iload 8
    //   385: istore 10
    //   387: aload_1
    //   388: invokestatic 187	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
    //   391: l2i
    //   392: istore 14
    //   394: sipush 1080
    //   397: istore 8
    //   399: aload_1
    //   400: invokestatic 1046	com/tencent/mm/plugin/facedetect/FaceProNative:detectFaceCnt	(Ljava/lang/String;)I
    //   403: istore 7
    //   405: ldc 65
    //   407: ldc_w 1048
    //   410: iconst_1
    //   411: anewarray 69	java/lang/Object
    //   414: dup
    //   415: iconst_0
    //   416: iload 7
    //   418: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   421: aastore
    //   422: invokestatic 74	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
    //   449: invokestatic 1004	com/tencent/mm/n/g:acL	()Lcom/tencent/mm/n/e;
    //   452: ldc_w 1050
    //   455: invokevirtual 1011	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   458: astore 21
    //   460: iload 11
    //   462: istore 7
    //   464: aload 21
    //   466: ldc_w 1052
    //   469: invokevirtual 1056	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   472: iconst_0
    //   473: aaload
    //   474: invokestatic 1059	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   477: invokevirtual 1062	java/lang/Integer:intValue	()I
    //   480: istore 11
    //   482: iload 11
    //   484: istore 7
    //   486: aload 21
    //   488: ldc_w 1052
    //   491: invokevirtual 1056	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   494: iconst_1
    //   495: aaload
    //   496: invokestatic 1059	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   499: invokevirtual 1062	java/lang/Integer:intValue	()I
    //   502: istore 12
    //   504: iload 12
    //   506: istore 8
    //   508: iload 11
    //   510: istore 7
    //   512: ldc 65
    //   514: ldc_w 1064
    //   517: bipush 6
    //   519: anewarray 69	java/lang/Object
    //   522: dup
    //   523: iconst_0
    //   524: iload 7
    //   526: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   529: aastore
    //   530: dup
    //   531: iconst_1
    //   532: iload 8
    //   534: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   537: aastore
    //   538: dup
    //   539: iconst_2
    //   540: getstatic 34	com/tencent/mm/plugin/sns/storage/u:zop	I
    //   543: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   546: aastore
    //   547: dup
    //   548: iconst_3
    //   549: getstatic 32	com/tencent/mm/plugin/sns/storage/u:zpi	I
    //   552: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   555: aastore
    //   556: dup
    //   557: iconst_4
    //   558: iload 9
    //   560: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   563: aastore
    //   564: dup
    //   565: iconst_5
    //   566: iload_3
    //   567: invokestatic 1036	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   570: aastore
    //   571: invokestatic 74	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   574: iload 7
    //   576: ifgt +986 -> 1562
    //   579: iload 8
    //   581: ifgt +981 -> 1562
    //   584: iconst_0
    //   585: istore 7
    //   587: sipush 1080
    //   590: istore 8
    //   592: invokestatic 1004	com/tencent/mm/n/g:acL	()Lcom/tencent/mm/n/e;
    //   595: ldc_w 1066
    //   598: invokevirtual 1011	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   601: bipush 100
    //   603: invokestatic 1015	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
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
    //   629: invokestatic 1004	com/tencent/mm/n/g:acL	()Lcom/tencent/mm/n/e;
    //   632: ldc_w 1068
    //   635: invokevirtual 1011	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   638: sipush 200
    //   641: invokestatic 1015	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
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
    //   668: invokestatic 1004	com/tencent/mm/n/g:acL	()Lcom/tencent/mm/n/e;
    //   671: ldc_w 1070
    //   674: invokevirtual 1011	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   677: bipush 10
    //   679: invokestatic 1015	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   682: istore 12
    //   684: iload 12
    //   686: ifle +10 -> 696
    //   689: iload 12
    //   691: bipush 100
    //   693: if_icmplt +3231 -> 3924
    //   696: bipush 10
    //   698: istore 12
    //   700: iconst_0
    //   701: istore 11
    //   703: iload 17
    //   705: ifeq +934 -> 1639
    //   708: aload_1
    //   709: invokestatic 355	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   712: astore 21
    //   714: aload 21
    //   716: ifnull +14 -> 730
    //   719: aload 21
    //   721: invokevirtual 620	com/tencent/mm/compatible/util/Exif:getOrientationInDegree	()I
    //   724: sipush 360
    //   727: irem
    //   728: istore 11
    //   730: ldc 65
    //   732: new 97	java/lang/StringBuilder
    //   735: dup
    //   736: ldc_w 1072
    //   739: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   742: aload 20
    //   744: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   747: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   750: ldc_w 1074
    //   753: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: aload 20
    //   758: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   761: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   764: ldc_w 1074
    //   767: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: iload 16
    //   772: invokevirtual 1077	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   775: ldc_w 1079
    //   778: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: iload 10
    //   783: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   786: ldc_w 1081
    //   789: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: iload 11
    //   794: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   797: ldc_w 1083
    //   800: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: iload 14
    //   805: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   808: ldc_w 1085
    //   811: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: iload 7
    //   816: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   819: ldc_w 1074
    //   822: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: iload 8
    //   827: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   830: ldc_w 1087
    //   833: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: iload 17
    //   838: invokevirtual 1077	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   841: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   844: invokestatic 141	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   847: invokestatic 1004	com/tencent/mm/n/g:acL	()Lcom/tencent/mm/n/e;
    //   850: ldc_w 1089
    //   853: invokevirtual 1011	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   856: bipush 10
    //   858: invokestatic 1015	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   861: pop
    //   862: aload 20
    //   864: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   867: aload 20
    //   869: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   872: iconst_2
    //   873: imul
    //   874: if_icmpge +18 -> 892
    //   877: aload 20
    //   879: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   882: aload 20
    //   884: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   887: iconst_2
    //   888: imul
    //   889: if_icmplt +1836 -> 2725
    //   892: aload 20
    //   894: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   897: aload 20
    //   899: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   902: imul
    //   903: ldc_w 711
    //   906: if_icmpgt +1576 -> 2482
    //   909: iload 14
    //   911: iload 15
    //   913: if_icmpge +799 -> 1712
    //   916: iload 16
    //   918: ifeq +794 -> 1712
    //   921: iload 11
    //   923: ifne +789 -> 1712
    //   926: invokestatic 755	com/tencent/mm/plugin/sns/storage/u:ecQ	()Z
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
    //   955: invokestatic 1093	com/tencent/mm/plugin/sns/storage/u:jY	(Ljava/lang/String;Ljava/lang/String;)Z
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
    //   986: invokestatic 531	com/tencent/mm/vfs/o:deleteFile	(Ljava/lang/String;)Z
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
    //   1009: invokestatic 522	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   1012: lconst_0
    //   1013: lcmp
    //   1014: iflt +634 -> 1648
    //   1017: iconst_1
    //   1018: istore_3
    //   1019: ldc_w 964
    //   1022: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1025: iload_3
    //   1026: ireturn
    //   1027: aload 21
    //   1029: ldc_w 1095
    //   1032: invokevirtual 843	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1035: iflt +9 -> 1044
    //   1038: iconst_1
    //   1039: istore 16
    //   1041: goto -975 -> 66
    //   1044: aload 21
    //   1046: ldc_w 888
    //   1049: invokevirtual 843	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1052: iflt +9 -> 1061
    //   1055: iconst_1
    //   1056: istore 16
    //   1058: goto -992 -> 66
    //   1061: iconst_0
    //   1062: istore 16
    //   1064: goto -998 -> 66
    //   1067: aload 21
    //   1069: ldc_w 1095
    //   1072: invokevirtual 843	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1075: iflt +9 -> 1084
    //   1078: iconst_1
    //   1079: istore 17
    //   1081: goto -977 -> 104
    //   1084: iconst_0
    //   1085: istore 17
    //   1087: goto -983 -> 104
    //   1090: invokestatic 992	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   1093: invokestatic 1098	com/tencent/mm/sdk/platformtools/az:is2G	(Landroid/content/Context;)Z
    //   1096: ifeq +22 -> 1118
    //   1099: invokestatic 1004	com/tencent/mm/n/g:acL	()Lcom/tencent/mm/n/e;
    //   1102: ldc_w 1019
    //   1105: invokevirtual 1011	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1108: bipush 70
    //   1110: invokestatic 1015	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   1113: istore 7
    //   1115: goto -912 -> 203
    //   1118: invokestatic 992	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   1121: invokestatic 1101	com/tencent/mm/sdk/platformtools/az:is3G	(Landroid/content/Context;)Z
    //   1124: ifeq +22 -> 1146
    //   1127: invokestatic 1004	com/tencent/mm/n/g:acL	()Lcom/tencent/mm/n/e;
    //   1130: ldc_w 1021
    //   1133: invokevirtual 1011	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1136: bipush 60
    //   1138: invokestatic 1015	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   1141: istore 7
    //   1143: goto -940 -> 203
    //   1146: invokestatic 1004	com/tencent/mm/n/g:acL	()Lcom/tencent/mm/n/e;
    //   1149: ldc_w 1023
    //   1152: invokevirtual 1011	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1155: bipush 60
    //   1157: invokestatic 1015	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   1160: istore 7
    //   1162: goto -959 -> 203
    //   1165: invokestatic 992	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   1168: invokestatic 998	com/tencent/mm/sdk/platformtools/az:isWifi	(Landroid/content/Context;)Z
    //   1171: ifeq +23 -> 1194
    //   1174: invokestatic 1004	com/tencent/mm/n/g:acL	()Lcom/tencent/mm/n/e;
    //   1177: ldc_w 1025
    //   1180: invokevirtual 1011	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1183: invokestatic 1059	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1186: invokevirtual 1062	java/lang/Integer:intValue	()I
    //   1189: istore 7
    //   1191: goto -988 -> 203
    //   1194: invokestatic 992	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   1197: invokestatic 1098	com/tencent/mm/sdk/platformtools/az:is2G	(Landroid/content/Context;)Z
    //   1200: ifeq +23 -> 1223
    //   1203: invokestatic 1004	com/tencent/mm/n/g:acL	()Lcom/tencent/mm/n/e;
    //   1206: ldc_w 1027
    //   1209: invokevirtual 1011	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1212: invokestatic 1059	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1215: invokevirtual 1062	java/lang/Integer:intValue	()I
    //   1218: istore 7
    //   1220: goto -1017 -> 203
    //   1223: invokestatic 1004	com/tencent/mm/n/g:acL	()Lcom/tencent/mm/n/e;
    //   1226: ldc_w 1029
    //   1229: invokevirtual 1011	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1232: invokestatic 1059	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1235: invokevirtual 1062	java/lang/Integer:intValue	()I
    //   1238: istore 7
    //   1240: goto -1037 -> 203
    //   1243: iload 11
    //   1245: istore 7
    //   1247: invokestatic 992	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   1250: invokestatic 998	com/tencent/mm/sdk/platformtools/az:isWifi	(Landroid/content/Context;)Z
    //   1253: ifeq +73 -> 1326
    //   1256: iload 11
    //   1258: istore 7
    //   1260: invokestatic 1004	com/tencent/mm/n/g:acL	()Lcom/tencent/mm/n/e;
    //   1263: ldc_w 1103
    //   1266: invokevirtual 1011	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1269: astore 21
    //   1271: iload 11
    //   1273: istore 7
    //   1275: aload 21
    //   1277: ldc_w 1052
    //   1280: invokevirtual 1056	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1283: iconst_0
    //   1284: aaload
    //   1285: invokestatic 1059	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1288: invokevirtual 1062	java/lang/Integer:intValue	()I
    //   1291: istore 11
    //   1293: iload 11
    //   1295: istore 7
    //   1297: aload 21
    //   1299: ldc_w 1052
    //   1302: invokevirtual 1056	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1305: iconst_1
    //   1306: aaload
    //   1307: invokestatic 1059	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1310: invokevirtual 1062	java/lang/Integer:intValue	()I
    //   1313: istore 12
    //   1315: iload 12
    //   1317: istore 8
    //   1319: iload 11
    //   1321: istore 7
    //   1323: goto -811 -> 512
    //   1326: iload 11
    //   1328: istore 7
    //   1330: invokestatic 992	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   1333: invokestatic 1098	com/tencent/mm/sdk/platformtools/az:is2G	(Landroid/content/Context;)Z
    //   1336: ifeq +73 -> 1409
    //   1339: iload 11
    //   1341: istore 7
    //   1343: invokestatic 1004	com/tencent/mm/n/g:acL	()Lcom/tencent/mm/n/e;
    //   1346: ldc_w 1105
    //   1349: invokevirtual 1011	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1352: astore 21
    //   1354: iload 11
    //   1356: istore 7
    //   1358: aload 21
    //   1360: ldc_w 1052
    //   1363: invokevirtual 1056	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1366: iconst_0
    //   1367: aaload
    //   1368: invokestatic 1059	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1371: invokevirtual 1062	java/lang/Integer:intValue	()I
    //   1374: istore 11
    //   1376: iload 11
    //   1378: istore 7
    //   1380: aload 21
    //   1382: ldc_w 1052
    //   1385: invokevirtual 1056	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1388: iconst_1
    //   1389: aaload
    //   1390: invokestatic 1059	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1393: invokevirtual 1062	java/lang/Integer:intValue	()I
    //   1396: istore 12
    //   1398: iload 12
    //   1400: istore 8
    //   1402: iload 11
    //   1404: istore 7
    //   1406: goto -894 -> 512
    //   1409: iload 11
    //   1411: istore 7
    //   1413: invokestatic 992	com/tencent/mm/sdk/platformtools/ak:getContext	()Landroid/content/Context;
    //   1416: invokestatic 1101	com/tencent/mm/sdk/platformtools/az:is3G	(Landroid/content/Context;)Z
    //   1419: ifeq +73 -> 1492
    //   1422: iload 11
    //   1424: istore 7
    //   1426: invokestatic 1004	com/tencent/mm/n/g:acL	()Lcom/tencent/mm/n/e;
    //   1429: ldc_w 1107
    //   1432: invokevirtual 1011	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1435: astore 21
    //   1437: iload 11
    //   1439: istore 7
    //   1441: aload 21
    //   1443: ldc_w 1052
    //   1446: invokevirtual 1056	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1449: iconst_0
    //   1450: aaload
    //   1451: invokestatic 1059	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1454: invokevirtual 1062	java/lang/Integer:intValue	()I
    //   1457: istore 11
    //   1459: iload 11
    //   1461: istore 7
    //   1463: aload 21
    //   1465: ldc_w 1052
    //   1468: invokevirtual 1056	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1471: iconst_1
    //   1472: aaload
    //   1473: invokestatic 1059	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1476: invokevirtual 1062	java/lang/Integer:intValue	()I
    //   1479: istore 12
    //   1481: iload 12
    //   1483: istore 8
    //   1485: iload 11
    //   1487: istore 7
    //   1489: goto -977 -> 512
    //   1492: iload 11
    //   1494: istore 7
    //   1496: invokestatic 1004	com/tencent/mm/n/g:acL	()Lcom/tencent/mm/n/e;
    //   1499: ldc_w 1109
    //   1502: invokevirtual 1011	com/tencent/mm/n/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1505: astore 21
    //   1507: iload 11
    //   1509: istore 7
    //   1511: aload 21
    //   1513: ldc_w 1052
    //   1516: invokevirtual 1056	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1519: iconst_0
    //   1520: aaload
    //   1521: invokestatic 1059	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1524: invokevirtual 1062	java/lang/Integer:intValue	()I
    //   1527: istore 11
    //   1529: iload 11
    //   1531: istore 7
    //   1533: aload 21
    //   1535: ldc_w 1052
    //   1538: invokevirtual 1056	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1541: iconst_1
    //   1542: aaload
    //   1543: invokestatic 1059	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1546: invokevirtual 1062	java/lang/Integer:intValue	()I
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
    //   1583: ifgt +2344 -> 3927
    //   1586: iload 7
    //   1588: sipush 3240
    //   1591: if_icmple +2336 -> 3927
    //   1594: sipush 1620
    //   1597: istore 7
    //   1599: iconst_0
    //   1600: istore 8
    //   1602: goto -1010 -> 592
    //   1605: astore 21
    //   1607: ldc 65
    //   1609: new 97	java/lang/StringBuilder
    //   1612: dup
    //   1613: ldc_w 1111
    //   1616: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1619: aload 21
    //   1621: invokevirtual 961	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1624: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1627: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1630: invokestatic 555	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1633: iconst_0
    //   1634: istore 11
    //   1636: goto -906 -> 730
    //   1639: aload_1
    //   1640: invokestatic 737	com/tencent/mm/sdk/platformtools/BackwardSupportUtil$ExifHelper:df	(Ljava/lang/String;)I
    //   1643: istore 11
    //   1645: goto -915 -> 730
    //   1648: iconst_0
    //   1649: istore_3
    //   1650: goto -631 -> 1019
    //   1653: ldc 65
    //   1655: ldc_w 1113
    //   1658: iload 15
    //   1660: invokestatic 343	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1663: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1666: invokestatic 141	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1669: aload_1
    //   1670: new 97	java/lang/StringBuilder
    //   1673: dup
    //   1674: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1677: aload_0
    //   1678: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1681: aload_2
    //   1682: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1685: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1688: invokestatic 522	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   1691: lconst_0
    //   1692: lcmp
    //   1693: iflt +11 -> 1704
    //   1696: ldc_w 964
    //   1699: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1702: iconst_1
    //   1703: ireturn
    //   1704: ldc_w 964
    //   1707: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1710: iconst_0
    //   1711: ireturn
    //   1712: new 580	android/graphics/BitmapFactory$Options
    //   1715: dup
    //   1716: invokespecial 581	android/graphics/BitmapFactory$Options:<init>	()V
    //   1719: astore 24
    //   1721: invokestatic 1116	com/tencent/mm/sdk/platformtools/h:fnS	()V
    //   1724: aconst_null
    //   1725: astore 21
    //   1727: aconst_null
    //   1728: astore 20
    //   1730: aload_1
    //   1731: invokestatic 589	com/tencent/mm/vfs/o:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1734: astore 23
    //   1736: aload 23
    //   1738: astore 22
    //   1740: aload 23
    //   1742: astore 20
    //   1744: aload 23
    //   1746: astore 21
    //   1748: aload 23
    //   1750: invokevirtual 595	java/io/InputStream:markSupported	()Z
    //   1753: ifne +22 -> 1775
    //   1756: aload 23
    //   1758: astore 20
    //   1760: aload 23
    //   1762: astore 21
    //   1764: new 597	java/io/BufferedInputStream
    //   1767: dup
    //   1768: aload 23
    //   1770: invokespecial 600	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1773: astore 22
    //   1775: aload 22
    //   1777: astore 20
    //   1779: aload 22
    //   1781: astore 21
    //   1783: aload 22
    //   1785: ldc_w 601
    //   1788: invokevirtual 604	java/io/InputStream:mark	(I)V
    //   1791: aload 22
    //   1793: astore 20
    //   1795: aload 22
    //   1797: astore 21
    //   1799: aload 22
    //   1801: aconst_null
    //   1802: aload 24
    //   1804: invokestatic 798	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1807: astore 23
    //   1809: aload 22
    //   1811: astore 20
    //   1813: aload 22
    //   1815: astore 21
    //   1817: aload 22
    //   1819: invokevirtual 611	java/io/InputStream:reset	()V
    //   1822: aload 23
    //   1824: ifnonnull +21 -> 1845
    //   1827: aload 22
    //   1829: ifnull +8 -> 1837
    //   1832: aload 22
    //   1834: invokevirtual 629	java/io/InputStream:close	()V
    //   1837: ldc_w 964
    //   1840: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1843: iconst_0
    //   1844: ireturn
    //   1845: iload 11
    //   1847: i2f
    //   1848: fstore 6
    //   1850: aload 22
    //   1852: astore 20
    //   1854: aload 22
    //   1856: astore 21
    //   1858: aload 23
    //   1860: fload 6
    //   1862: invokestatic 852	com/tencent/mm/sdk/platformtools/h:a	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   1865: astore 23
    //   1867: aload 22
    //   1869: astore 20
    //   1871: aload 22
    //   1873: astore 21
    //   1875: invokestatic 755	com/tencent/mm/plugin/sns/storage/u:ecQ	()Z
    //   1878: ifeq +396 -> 2274
    //   1881: iload_3
    //   1882: ifeq +392 -> 2274
    //   1885: aload 22
    //   1887: astore 20
    //   1889: aload 22
    //   1891: astore 21
    //   1893: aload 23
    //   1895: aload_1
    //   1896: new 97	java/lang/StringBuilder
    //   1899: dup
    //   1900: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1903: aload_0
    //   1904: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1907: aload_2
    //   1908: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1911: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1914: invokestatic 758	com/tencent/mm/plugin/sns/storage/u:b	(Landroid/graphics/Bitmap;Ljava/lang/String;Ljava/lang/String;)Z
    //   1917: ifne +71 -> 1988
    //   1920: aload 22
    //   1922: astore 20
    //   1924: aload 22
    //   1926: astore 21
    //   1928: new 97	java/lang/StringBuilder
    //   1931: dup
    //   1932: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1935: aload_0
    //   1936: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1939: aload_2
    //   1940: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1943: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1946: invokestatic 531	com/tencent/mm/vfs/o:deleteFile	(Ljava/lang/String;)Z
    //   1949: pop
    //   1950: aload 22
    //   1952: astore 20
    //   1954: aload 22
    //   1956: astore 21
    //   1958: aload 23
    //   1960: iload 9
    //   1962: getstatic 821	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1965: new 97	java/lang/StringBuilder
    //   1968: dup
    //   1969: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1972: aload_0
    //   1973: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1976: aload_2
    //   1977: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1980: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1983: iconst_1
    //   1984: invokestatic 956	com/tencent/mm/sdk/platformtools/h:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   1987: pop
    //   1988: aload 23
    //   1990: ifnull +32 -> 2022
    //   1993: aload 22
    //   1995: astore 20
    //   1997: aload 22
    //   1999: astore 21
    //   2001: aload 23
    //   2003: invokevirtual 1119	android/graphics/Bitmap:isRecycled	()Z
    //   2006: ifne +16 -> 2022
    //   2009: aload 22
    //   2011: astore 20
    //   2013: aload 22
    //   2015: astore 21
    //   2017: aload 23
    //   2019: invokevirtual 1122	android/graphics/Bitmap:recycle	()V
    //   2022: iload 16
    //   2024: ifeq +421 -> 2445
    //   2027: iload 11
    //   2029: ifne +416 -> 2445
    //   2032: aload 22
    //   2034: astore 20
    //   2036: aload 22
    //   2038: astore 21
    //   2040: new 97	java/lang/StringBuilder
    //   2043: dup
    //   2044: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2047: aload_0
    //   2048: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2051: aload_2
    //   2052: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2055: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2058: invokestatic 187	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
    //   2061: lstore 18
    //   2063: aload 22
    //   2065: astore 20
    //   2067: aload 22
    //   2069: astore 21
    //   2071: ldc 65
    //   2073: ldc_w 1124
    //   2076: iconst_3
    //   2077: anewarray 69	java/lang/Object
    //   2080: dup
    //   2081: iconst_0
    //   2082: iload 14
    //   2084: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2087: aastore
    //   2088: dup
    //   2089: iconst_1
    //   2090: lload 18
    //   2092: invokestatic 782	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2095: aastore
    //   2096: dup
    //   2097: iconst_2
    //   2098: iload 12
    //   2100: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2103: aastore
    //   2104: invokestatic 74	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2107: iload 14
    //   2109: i2l
    //   2110: lload 18
    //   2112: lsub
    //   2113: ldc2_w 1125
    //   2116: lmul
    //   2117: iload 12
    //   2119: iload 14
    //   2121: imul
    //   2122: i2l
    //   2123: lcmp
    //   2124: ifge +303 -> 2427
    //   2127: aload 22
    //   2129: astore 20
    //   2131: aload 22
    //   2133: astore 21
    //   2135: new 97	java/lang/StringBuilder
    //   2138: dup
    //   2139: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2142: aload_0
    //   2143: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2146: aload_2
    //   2147: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2150: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2153: invokestatic 531	com/tencent/mm/vfs/o:deleteFile	(Ljava/lang/String;)Z
    //   2156: pop
    //   2157: aload 22
    //   2159: astore 20
    //   2161: aload 22
    //   2163: astore 21
    //   2165: invokestatic 755	com/tencent/mm/plugin/sns/storage/u:ecQ	()Z
    //   2168: ifeq +195 -> 2363
    //   2171: iload_3
    //   2172: ifeq +191 -> 2363
    //   2175: aload 22
    //   2177: astore 20
    //   2179: aload 22
    //   2181: astore 21
    //   2183: aload_1
    //   2184: new 97	java/lang/StringBuilder
    //   2187: dup
    //   2188: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2191: aload_0
    //   2192: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2195: aload_2
    //   2196: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2199: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2202: invokestatic 1093	com/tencent/mm/plugin/sns/storage/u:jY	(Ljava/lang/String;Ljava/lang/String;)Z
    //   2205: istore 16
    //   2207: iload 16
    //   2209: istore_3
    //   2210: iload 16
    //   2212: ifne +44 -> 2256
    //   2215: aload 22
    //   2217: astore 20
    //   2219: aload 22
    //   2221: astore 21
    //   2223: aload_1
    //   2224: new 97	java/lang/StringBuilder
    //   2227: dup
    //   2228: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2231: aload_0
    //   2232: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2235: aload_2
    //   2236: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2239: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2242: invokestatic 522	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   2245: lstore 18
    //   2247: lload 18
    //   2249: lconst_0
    //   2250: lcmp
    //   2251: iflt +107 -> 2358
    //   2254: iconst_1
    //   2255: istore_3
    //   2256: aload 22
    //   2258: ifnull +8 -> 2266
    //   2261: aload 22
    //   2263: invokevirtual 629	java/io/InputStream:close	()V
    //   2266: ldc_w 964
    //   2269: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2272: iload_3
    //   2273: ireturn
    //   2274: aload 22
    //   2276: astore 20
    //   2278: aload 22
    //   2280: astore 21
    //   2282: aload 23
    //   2284: iload 9
    //   2286: getstatic 821	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   2289: new 97	java/lang/StringBuilder
    //   2292: dup
    //   2293: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2296: aload_0
    //   2297: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2300: aload_2
    //   2301: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2304: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2307: iconst_1
    //   2308: invokestatic 956	com/tencent/mm/sdk/platformtools/h:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   2311: pop
    //   2312: goto -290 -> 2022
    //   2315: astore_0
    //   2316: aload 20
    //   2318: astore 21
    //   2320: ldc 65
    //   2322: aload_0
    //   2323: ldc_w 1128
    //   2326: aload_1
    //   2327: invokestatic 130	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2330: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2333: iconst_0
    //   2334: anewarray 69	java/lang/Object
    //   2337: invokestatic 550	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2340: aload 20
    //   2342: ifnull +8 -> 2350
    //   2345: aload 20
    //   2347: invokevirtual 629	java/io/InputStream:close	()V
    //   2350: ldc_w 964
    //   2353: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2356: iconst_0
    //   2357: ireturn
    //   2358: iconst_0
    //   2359: istore_3
    //   2360: goto -104 -> 2256
    //   2363: aload 22
    //   2365: astore 20
    //   2367: aload 22
    //   2369: astore 21
    //   2371: aload_1
    //   2372: new 97	java/lang/StringBuilder
    //   2375: dup
    //   2376: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2379: aload_0
    //   2380: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2383: aload_2
    //   2384: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2387: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2390: invokestatic 522	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   2393: lstore 18
    //   2395: lload 18
    //   2397: lconst_0
    //   2398: lcmp
    //   2399: iflt +23 -> 2422
    //   2402: iconst_1
    //   2403: istore_3
    //   2404: aload 22
    //   2406: ifnull +8 -> 2414
    //   2409: aload 22
    //   2411: invokevirtual 629	java/io/InputStream:close	()V
    //   2414: ldc_w 964
    //   2417: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2420: iload_3
    //   2421: ireturn
    //   2422: iconst_0
    //   2423: istore_3
    //   2424: goto -20 -> 2404
    //   2427: aload 22
    //   2429: ifnull +8 -> 2437
    //   2432: aload 22
    //   2434: invokevirtual 629	java/io/InputStream:close	()V
    //   2437: ldc_w 964
    //   2440: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2443: iconst_1
    //   2444: ireturn
    //   2445: aload 22
    //   2447: ifnull +8 -> 2455
    //   2450: aload 22
    //   2452: invokevirtual 629	java/io/InputStream:close	()V
    //   2455: ldc_w 964
    //   2458: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2461: iconst_1
    //   2462: ireturn
    //   2463: astore_0
    //   2464: aload 21
    //   2466: ifnull +8 -> 2474
    //   2469: aload 21
    //   2471: invokevirtual 629	java/io/InputStream:close	()V
    //   2474: ldc_w 964
    //   2477: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2480: aload_0
    //   2481: athrow
    //   2482: ldc 65
    //   2484: new 97	java/lang/StringBuilder
    //   2487: dup
    //   2488: ldc_w 1130
    //   2491: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2494: aload 20
    //   2496: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2499: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2502: ldc_w 1074
    //   2505: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2508: aload 20
    //   2510: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2513: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2516: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2519: invokestatic 141	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2522: aload 20
    //   2524: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2527: ifgt +9 -> 2536
    //   2530: aload 20
    //   2532: iconst_1
    //   2533: putfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2536: aload 20
    //   2538: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2541: ifgt +9 -> 2550
    //   2544: aload 20
    //   2546: iconst_1
    //   2547: putfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2550: aload 20
    //   2552: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2555: aload 20
    //   2557: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2560: if_icmple +131 -> 2691
    //   2563: aload 20
    //   2565: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2568: aload 20
    //   2570: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2573: idiv
    //   2574: istore 7
    //   2576: iload 7
    //   2578: istore 8
    //   2580: iload 7
    //   2582: ifne +6 -> 2588
    //   2585: iconst_1
    //   2586: istore 8
    //   2588: ldc_w 711
    //   2591: iload 8
    //   2593: idiv
    //   2594: i2d
    //   2595: invokestatic 1133	java/lang/Math:sqrt	(D)D
    //   2598: d2i
    //   2599: istore 7
    //   2601: aload 20
    //   2603: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2606: aload 20
    //   2608: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2611: if_icmple +96 -> 2707
    //   2614: iload 7
    //   2616: iload 8
    //   2618: imul
    //   2619: istore 10
    //   2621: ldc 65
    //   2623: new 97	java/lang/StringBuilder
    //   2626: dup
    //   2627: ldc_w 1135
    //   2630: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2633: iload 10
    //   2635: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2638: ldc_w 1074
    //   2641: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2644: iload 7
    //   2646: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2649: ldc_w 1074
    //   2652: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2655: iload 8
    //   2657: invokevirtual 296	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2660: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2663: invokestatic 141	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2666: aload_1
    //   2667: iload 7
    //   2669: iload 10
    //   2671: getstatic 821	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   2674: iload 9
    //   2676: aload_0
    //   2677: aload_2
    //   2678: iload_3
    //   2679: invokestatic 1137	com/tencent/mm/plugin/sns/storage/u:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   2682: istore_3
    //   2683: ldc_w 964
    //   2686: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2689: iload_3
    //   2690: ireturn
    //   2691: aload 20
    //   2693: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2696: aload 20
    //   2698: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2701: idiv
    //   2702: istore 7
    //   2704: goto -128 -> 2576
    //   2707: iload 7
    //   2709: iload 8
    //   2711: imul
    //   2712: istore 11
    //   2714: iload 7
    //   2716: istore 10
    //   2718: iload 11
    //   2720: istore 7
    //   2722: goto -101 -> 2621
    //   2725: iload 14
    //   2727: iload 13
    //   2729: if_icmpge +178 -> 2907
    //   2732: iload 16
    //   2734: ifeq +173 -> 2907
    //   2737: iload 11
    //   2739: ifne +168 -> 2907
    //   2742: ldc 65
    //   2744: ldc_w 1139
    //   2747: iload 13
    //   2749: invokestatic 343	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2752: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2755: invokestatic 141	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2758: invokestatic 755	com/tencent/mm/plugin/sns/storage/u:ecQ	()Z
    //   2761: ifeq +103 -> 2864
    //   2764: iload_3
    //   2765: ifeq +99 -> 2864
    //   2768: aload_1
    //   2769: new 97	java/lang/StringBuilder
    //   2772: dup
    //   2773: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2776: aload_0
    //   2777: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2780: aload_2
    //   2781: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2784: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2787: invokestatic 1093	com/tencent/mm/plugin/sns/storage/u:jY	(Ljava/lang/String;Ljava/lang/String;)Z
    //   2790: istore 16
    //   2792: iload 16
    //   2794: istore_3
    //   2795: iload 16
    //   2797: ifne +54 -> 2851
    //   2800: new 97	java/lang/StringBuilder
    //   2803: dup
    //   2804: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2807: aload_0
    //   2808: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2811: aload_2
    //   2812: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2815: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2818: invokestatic 531	com/tencent/mm/vfs/o:deleteFile	(Ljava/lang/String;)Z
    //   2821: pop
    //   2822: aload_1
    //   2823: new 97	java/lang/StringBuilder
    //   2826: dup
    //   2827: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2830: aload_0
    //   2831: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2834: aload_2
    //   2835: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2838: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2841: invokestatic 522	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   2844: lconst_0
    //   2845: lcmp
    //   2846: iflt +13 -> 2859
    //   2849: iconst_1
    //   2850: istore_3
    //   2851: ldc_w 964
    //   2854: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2857: iload_3
    //   2858: ireturn
    //   2859: iconst_0
    //   2860: istore_3
    //   2861: goto -10 -> 2851
    //   2864: aload_1
    //   2865: new 97	java/lang/StringBuilder
    //   2868: dup
    //   2869: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2872: aload_0
    //   2873: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2876: aload_2
    //   2877: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2880: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2883: invokestatic 522	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   2886: lconst_0
    //   2887: lcmp
    //   2888: iflt +11 -> 2899
    //   2891: ldc_w 964
    //   2894: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2897: iconst_1
    //   2898: ireturn
    //   2899: ldc_w 964
    //   2902: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2905: iconst_0
    //   2906: ireturn
    //   2907: aload 20
    //   2909: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2912: aload 20
    //   2914: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2917: if_icmple +229 -> 3146
    //   2920: aload 20
    //   2922: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2925: istore 10
    //   2927: aload 20
    //   2929: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2932: aload 20
    //   2934: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   2937: if_icmpge +219 -> 3156
    //   2940: aload 20
    //   2942: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2945: istore 13
    //   2947: iload 8
    //   2949: ifle +10 -> 2959
    //   2952: iload 13
    //   2954: iload 8
    //   2956: if_icmple +15 -> 2971
    //   2959: iload 8
    //   2961: ifgt +586 -> 3547
    //   2964: iload 10
    //   2966: iload 7
    //   2968: if_icmpgt +579 -> 3547
    //   2971: ldc 65
    //   2973: ldc_w 1141
    //   2976: iconst_3
    //   2977: anewarray 69	java/lang/Object
    //   2980: dup
    //   2981: iconst_0
    //   2982: iload 14
    //   2984: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2987: aastore
    //   2988: dup
    //   2989: iconst_1
    //   2990: aload 20
    //   2992: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   2995: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2998: aastore
    //   2999: dup
    //   3000: iconst_2
    //   3001: aload 20
    //   3003: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   3006: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3009: aastore
    //   3010: invokestatic 74	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3013: aload_1
    //   3014: invokestatic 187	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
    //   3017: ldc2_w 1142
    //   3020: lcmp
    //   3021: ifge +246 -> 3267
    //   3024: iload 16
    //   3026: ifeq +188 -> 3214
    //   3029: ldc 65
    //   3031: ldc_w 1145
    //   3034: iconst_1
    //   3035: anewarray 69	java/lang/Object
    //   3038: dup
    //   3039: iconst_0
    //   3040: aload_1
    //   3041: aastore
    //   3042: invokestatic 74	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3045: invokestatic 755	com/tencent/mm/plugin/sns/storage/u:ecQ	()Z
    //   3048: ifeq +123 -> 3171
    //   3051: iload_3
    //   3052: ifeq +119 -> 3171
    //   3055: aload_1
    //   3056: new 97	java/lang/StringBuilder
    //   3059: dup
    //   3060: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3063: aload_0
    //   3064: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3067: aload_2
    //   3068: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3071: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3074: invokestatic 1093	com/tencent/mm/plugin/sns/storage/u:jY	(Ljava/lang/String;Ljava/lang/String;)Z
    //   3077: istore 16
    //   3079: iload 16
    //   3081: istore_3
    //   3082: iload 16
    //   3084: ifne +54 -> 3138
    //   3087: new 97	java/lang/StringBuilder
    //   3090: dup
    //   3091: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3094: aload_0
    //   3095: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3098: aload_2
    //   3099: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3102: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3105: invokestatic 531	com/tencent/mm/vfs/o:deleteFile	(Ljava/lang/String;)Z
    //   3108: pop
    //   3109: aload_1
    //   3110: new 97	java/lang/StringBuilder
    //   3113: dup
    //   3114: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3117: aload_0
    //   3118: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3121: aload_2
    //   3122: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3125: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3128: invokestatic 522	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   3131: lconst_0
    //   3132: lcmp
    //   3133: iflt +33 -> 3166
    //   3136: iconst_1
    //   3137: istore_3
    //   3138: ldc_w 964
    //   3141: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3144: iload_3
    //   3145: ireturn
    //   3146: aload 20
    //   3148: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   3151: istore 10
    //   3153: goto -226 -> 2927
    //   3156: aload 20
    //   3158: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   3161: istore 13
    //   3163: goto -216 -> 2947
    //   3166: iconst_0
    //   3167: istore_3
    //   3168: goto -30 -> 3138
    //   3171: aload_1
    //   3172: new 97	java/lang/StringBuilder
    //   3175: dup
    //   3176: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3179: aload_0
    //   3180: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3183: aload_2
    //   3184: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3187: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3190: invokestatic 522	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   3193: lconst_0
    //   3194: lcmp
    //   3195: iflt +11 -> 3206
    //   3198: ldc_w 964
    //   3201: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3204: iconst_1
    //   3205: ireturn
    //   3206: ldc_w 964
    //   3209: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3212: iconst_0
    //   3213: ireturn
    //   3214: aload 20
    //   3216: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   3219: sipush 150
    //   3222: if_icmpge +45 -> 3267
    //   3225: aload 20
    //   3227: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   3230: sipush 150
    //   3233: if_icmpge +34 -> 3267
    //   3236: aload_1
    //   3237: aload 20
    //   3239: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   3242: aload 20
    //   3244: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   3247: getstatic 816	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   3250: iload 9
    //   3252: aload_0
    //   3253: aload_2
    //   3254: iload_3
    //   3255: invokestatic 1137	com/tencent/mm/plugin/sns/storage/u:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   3258: istore_3
    //   3259: ldc_w 964
    //   3262: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3265: iload_3
    //   3266: ireturn
    //   3267: aload_1
    //   3268: aload 20
    //   3270: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   3273: aload 20
    //   3275: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   3278: getstatic 821	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   3281: iload 9
    //   3283: aload_0
    //   3284: aload_2
    //   3285: iload_3
    //   3286: invokestatic 1137	com/tencent/mm/plugin/sns/storage/u:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   3289: istore 17
    //   3291: iload 16
    //   3293: ifeq +245 -> 3538
    //   3296: iload 11
    //   3298: ifne +240 -> 3538
    //   3301: new 97	java/lang/StringBuilder
    //   3304: dup
    //   3305: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3308: aload_0
    //   3309: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3312: aload_2
    //   3313: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3316: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3319: invokestatic 187	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
    //   3322: lstore 18
    //   3324: ldc 65
    //   3326: ldc_w 1124
    //   3329: iconst_3
    //   3330: anewarray 69	java/lang/Object
    //   3333: dup
    //   3334: iconst_0
    //   3335: iload 14
    //   3337: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3340: aastore
    //   3341: dup
    //   3342: iconst_1
    //   3343: lload 18
    //   3345: invokestatic 782	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3348: aastore
    //   3349: dup
    //   3350: iconst_2
    //   3351: iload 12
    //   3353: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3356: aastore
    //   3357: invokestatic 74	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3360: iload 14
    //   3362: i2l
    //   3363: lload 18
    //   3365: lsub
    //   3366: ldc2_w 1125
    //   3369: lmul
    //   3370: iload 12
    //   3372: iload 14
    //   3374: imul
    //   3375: i2l
    //   3376: lcmp
    //   3377: ifge +152 -> 3529
    //   3380: new 97	java/lang/StringBuilder
    //   3383: dup
    //   3384: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3387: aload_0
    //   3388: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3391: aload_2
    //   3392: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3395: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3398: invokestatic 531	com/tencent/mm/vfs/o:deleteFile	(Ljava/lang/String;)Z
    //   3401: pop
    //   3402: invokestatic 755	com/tencent/mm/plugin/sns/storage/u:ecQ	()Z
    //   3405: ifeq +81 -> 3486
    //   3408: iload_3
    //   3409: ifeq +77 -> 3486
    //   3412: aload_1
    //   3413: new 97	java/lang/StringBuilder
    //   3416: dup
    //   3417: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3420: aload_0
    //   3421: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3424: aload_2
    //   3425: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3428: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3431: invokestatic 1093	com/tencent/mm/plugin/sns/storage/u:jY	(Ljava/lang/String;Ljava/lang/String;)Z
    //   3434: istore 16
    //   3436: iload 16
    //   3438: istore_3
    //   3439: iload 16
    //   3441: ifne +32 -> 3473
    //   3444: aload_1
    //   3445: new 97	java/lang/StringBuilder
    //   3448: dup
    //   3449: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3452: aload_0
    //   3453: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3456: aload_2
    //   3457: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3460: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3463: invokestatic 522	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   3466: lconst_0
    //   3467: lcmp
    //   3468: iflt +13 -> 3481
    //   3471: iconst_1
    //   3472: istore_3
    //   3473: ldc_w 964
    //   3476: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3479: iload_3
    //   3480: ireturn
    //   3481: iconst_0
    //   3482: istore_3
    //   3483: goto -10 -> 3473
    //   3486: aload_1
    //   3487: new 97	java/lang/StringBuilder
    //   3490: dup
    //   3491: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3494: aload_0
    //   3495: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3498: aload_2
    //   3499: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3502: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3505: invokestatic 522	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   3508: lconst_0
    //   3509: lcmp
    //   3510: iflt +11 -> 3521
    //   3513: ldc_w 964
    //   3516: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3519: iconst_1
    //   3520: ireturn
    //   3521: ldc_w 964
    //   3524: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3527: iconst_0
    //   3528: ireturn
    //   3529: ldc_w 964
    //   3532: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3535: iload 17
    //   3537: ireturn
    //   3538: ldc_w 964
    //   3541: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3544: iload 17
    //   3546: ireturn
    //   3547: iload 8
    //   3549: ifle +219 -> 3768
    //   3552: aload_1
    //   3553: aload 20
    //   3555: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   3558: aload 20
    //   3560: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   3563: iload 8
    //   3565: getstatic 821	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   3568: iload 9
    //   3570: aload_0
    //   3571: aload_2
    //   3572: iload_3
    //   3573: invokestatic 1147	com/tencent/mm/plugin/sns/storage/u:a	(Ljava/lang/String;IIILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   3576: istore 17
    //   3578: iload 16
    //   3580: ifeq +288 -> 3868
    //   3583: iload 11
    //   3585: ifne +283 -> 3868
    //   3588: new 97	java/lang/StringBuilder
    //   3591: dup
    //   3592: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3595: aload_0
    //   3596: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3599: aload_2
    //   3600: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3603: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3606: invokestatic 187	com/tencent/mm/vfs/o:aZR	(Ljava/lang/String;)J
    //   3609: lstore 18
    //   3611: ldc 65
    //   3613: ldc_w 1124
    //   3616: iconst_3
    //   3617: anewarray 69	java/lang/Object
    //   3620: dup
    //   3621: iconst_0
    //   3622: iload 14
    //   3624: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3627: aastore
    //   3628: dup
    //   3629: iconst_1
    //   3630: lload 18
    //   3632: invokestatic 782	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3635: aastore
    //   3636: dup
    //   3637: iconst_2
    //   3638: iload 12
    //   3640: invokestatic 502	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3643: aastore
    //   3644: invokestatic 74	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   3647: iload 14
    //   3649: i2l
    //   3650: lload 18
    //   3652: lsub
    //   3653: ldc2_w 1125
    //   3656: lmul
    //   3657: iload 12
    //   3659: iload 14
    //   3661: imul
    //   3662: i2l
    //   3663: lcmp
    //   3664: ifge +204 -> 3868
    //   3667: new 97	java/lang/StringBuilder
    //   3670: dup
    //   3671: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3674: aload_0
    //   3675: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3678: aload_2
    //   3679: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3682: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3685: invokestatic 531	com/tencent/mm/vfs/o:deleteFile	(Ljava/lang/String;)Z
    //   3688: pop
    //   3689: invokestatic 755	com/tencent/mm/plugin/sns/storage/u:ecQ	()Z
    //   3692: ifeq +133 -> 3825
    //   3695: iload_3
    //   3696: ifeq +129 -> 3825
    //   3699: aload_1
    //   3700: new 97	java/lang/StringBuilder
    //   3703: dup
    //   3704: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3707: aload_0
    //   3708: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3711: aload_2
    //   3712: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3715: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3718: invokestatic 1093	com/tencent/mm/plugin/sns/storage/u:jY	(Ljava/lang/String;Ljava/lang/String;)Z
    //   3721: istore 16
    //   3723: iload 16
    //   3725: istore_3
    //   3726: iload 16
    //   3728: ifne +32 -> 3760
    //   3731: aload_1
    //   3732: new 97	java/lang/StringBuilder
    //   3735: dup
    //   3736: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3739: aload_0
    //   3740: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3743: aload_2
    //   3744: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3747: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3750: invokestatic 522	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   3753: lconst_0
    //   3754: lcmp
    //   3755: iflt +65 -> 3820
    //   3758: iconst_1
    //   3759: istore_3
    //   3760: ldc_w 964
    //   3763: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3766: iload_3
    //   3767: ireturn
    //   3768: iload 10
    //   3770: i2d
    //   3771: dconst_1
    //   3772: dmul
    //   3773: iload 7
    //   3775: i2d
    //   3776: ddiv
    //   3777: dstore 4
    //   3779: aload 20
    //   3781: getfield 623	android/graphics/BitmapFactory$Options:outWidth	I
    //   3784: i2d
    //   3785: dload 4
    //   3787: ddiv
    //   3788: d2i
    //   3789: istore 7
    //   3791: aload_1
    //   3792: aload 20
    //   3794: getfield 626	android/graphics/BitmapFactory$Options:outHeight	I
    //   3797: i2d
    //   3798: dload 4
    //   3800: ddiv
    //   3801: d2i
    //   3802: iload 7
    //   3804: getstatic 821	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   3807: iload 9
    //   3809: aload_0
    //   3810: aload_2
    //   3811: iload_3
    //   3812: invokestatic 1137	com/tencent/mm/plugin/sns/storage/u:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   3815: istore 17
    //   3817: goto -239 -> 3578
    //   3820: iconst_0
    //   3821: istore_3
    //   3822: goto -62 -> 3760
    //   3825: aload_1
    //   3826: new 97	java/lang/StringBuilder
    //   3829: dup
    //   3830: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   3833: aload_0
    //   3834: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3837: aload_2
    //   3838: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3841: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3844: invokestatic 522	com/tencent/mm/vfs/o:mF	(Ljava/lang/String;Ljava/lang/String;)J
    //   3847: lconst_0
    //   3848: lcmp
    //   3849: iflt +11 -> 3860
    //   3852: ldc_w 964
    //   3855: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3858: iconst_1
    //   3859: ireturn
    //   3860: ldc_w 964
    //   3863: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3866: iconst_0
    //   3867: ireturn
    //   3868: ldc_w 964
    //   3871: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3874: iload 17
    //   3876: ireturn
    //   3877: astore_0
    //   3878: goto -2041 -> 1837
    //   3881: astore_0
    //   3882: goto -1616 -> 2266
    //   3885: astore_0
    //   3886: goto -1472 -> 2414
    //   3889: astore_0
    //   3890: goto -1453 -> 2437
    //   3893: astore_0
    //   3894: goto -1439 -> 2455
    //   3897: astore_0
    //   3898: goto -1548 -> 2350
    //   3901: astore_1
    //   3902: goto -1428 -> 2474
    //   3905: astore 21
    //   3907: goto -3395 -> 512
    //   3910: astore 21
    //   3912: bipush 100
    //   3914: istore 7
    //   3916: goto -3615 -> 301
    //   3919: astore 21
    //   3921: goto -3620 -> 301
    //   3924: goto -3224 -> 700
    //   3927: goto -3335 -> 592
    //   3930: iload 8
    //   3932: istore 10
    //   3934: iload 7
    //   3936: istore 9
    //   3938: goto -3551 -> 387
    //   3941: goto -3595 -> 346
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3944	0	paramString1	String
    //   0	3944	1	paramString2	String
    //   0	3944	2	paramString3	String
    //   0	3944	3	paramBoolean	boolean
    //   3777	22	4	d	double
    //   1848	13	6	f	float
    //   201	3734	7	i	int
    //   134	3797	8	j	int
    //   138	3799	9	k	int
    //   142	3791	10	m	int
    //   437	3147	11	n	int
    //   502	3160	12	i1	int
    //   627	2535	13	i2	int
    //   392	3270	14	i3	int
    //   666	993	15	i4	int
    //   64	3663	16	bool1	boolean
    //   102	3773	17	bool2	boolean
    //   2061	1590	18	l	long
    //   10	3783	20	localObject1	Object
    //   22	1512	21	localObject2	Object
    //   1605	15	21	localException1	Exception
    //   1725	745	21	localObject3	Object
    //   3905	1	21	localException2	Exception
    //   3910	1	21	localException3	Exception
    //   3919	1	21	localException4	Exception
    //   1738	713	22	localObject4	Object
    //   1734	549	23	localObject5	Object
    //   1719	84	24	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   708	714	1605	java/lang/Exception
    //   719	730	1605	java/lang/Exception
    //   1730	1736	2315	java/io/IOException
    //   1748	1756	2315	java/io/IOException
    //   1764	1775	2315	java/io/IOException
    //   1783	1791	2315	java/io/IOException
    //   1799	1809	2315	java/io/IOException
    //   1817	1822	2315	java/io/IOException
    //   1858	1867	2315	java/io/IOException
    //   1875	1881	2315	java/io/IOException
    //   1893	1920	2315	java/io/IOException
    //   1928	1950	2315	java/io/IOException
    //   1958	1988	2315	java/io/IOException
    //   2001	2009	2315	java/io/IOException
    //   2017	2022	2315	java/io/IOException
    //   2040	2063	2315	java/io/IOException
    //   2071	2107	2315	java/io/IOException
    //   2135	2157	2315	java/io/IOException
    //   2165	2171	2315	java/io/IOException
    //   2183	2207	2315	java/io/IOException
    //   2223	2247	2315	java/io/IOException
    //   2282	2312	2315	java/io/IOException
    //   2371	2395	2315	java/io/IOException
    //   1730	1736	2463	finally
    //   1748	1756	2463	finally
    //   1764	1775	2463	finally
    //   1783	1791	2463	finally
    //   1799	1809	2463	finally
    //   1817	1822	2463	finally
    //   1858	1867	2463	finally
    //   1875	1881	2463	finally
    //   1893	1920	2463	finally
    //   1928	1950	2463	finally
    //   1958	1988	2463	finally
    //   2001	2009	2463	finally
    //   2017	2022	2463	finally
    //   2040	2063	2463	finally
    //   2071	2107	2463	finally
    //   2135	2157	2463	finally
    //   2165	2171	2463	finally
    //   2183	2207	2463	finally
    //   2223	2247	2463	finally
    //   2282	2312	2463	finally
    //   2320	2340	2463	finally
    //   2371	2395	2463	finally
    //   1832	1837	3877	java/io/IOException
    //   2261	2266	3881	java/io/IOException
    //   2409	2414	3885	java/io/IOException
    //   2432	2437	3889	java/io/IOException
    //   2450	2455	3893	java/io/IOException
    //   2345	2350	3897	java/io/IOException
    //   2469	2474	3901	java/io/IOException
    //   449	460	3905	java/lang/Exception
    //   464	482	3905	java/lang/Exception
    //   486	504	3905	java/lang/Exception
    //   1247	1256	3905	java/lang/Exception
    //   1260	1271	3905	java/lang/Exception
    //   1275	1293	3905	java/lang/Exception
    //   1297	1315	3905	java/lang/Exception
    //   1330	1339	3905	java/lang/Exception
    //   1343	1354	3905	java/lang/Exception
    //   1358	1376	3905	java/lang/Exception
    //   1380	1398	3905	java/lang/Exception
    //   1413	1422	3905	java/lang/Exception
    //   1426	1437	3905	java/lang/Exception
    //   1441	1459	3905	java/lang/Exception
    //   1463	1481	3905	java/lang/Exception
    //   1496	1507	3905	java/lang/Exception
    //   1511	1529	3905	java/lang/Exception
    //   1533	1551	3905	java/lang/Exception
    //   148	178	3910	java/lang/Exception
    //   178	203	3910	java/lang/Exception
    //   1090	1115	3910	java/lang/Exception
    //   1118	1143	3910	java/lang/Exception
    //   1146	1162	3910	java/lang/Exception
    //   1165	1191	3910	java/lang/Exception
    //   1194	1220	3910	java/lang/Exception
    //   1223	1240	3910	java/lang/Exception
    //   203	301	3919	java/lang/Exception
  }
  
  public static boolean ecP()
  {
    AppMethodBeat.i(97609);
    if ("hevc".equals(ac.iSz))
    {
      AppMethodBeat.o(97609);
      return true;
    }
    boolean bool = ah.dXR();
    AppMethodBeat.o(97609);
    return bool;
  }
  
  public static boolean ecQ()
  {
    AppMethodBeat.i(219642);
    if ("wxam".equals(ac.iSz))
    {
      AppMethodBeat.o(219642);
      return true;
    }
    boolean bool = ah.dXT();
    AppMethodBeat.o(219642);
    return bool;
  }
  
  public static boolean ecR()
  {
    AppMethodBeat.i(97610);
    if ("wxpc".equals(ac.iSz))
    {
      AppMethodBeat.o(97610);
      return true;
    }
    boolean bool = ah.dXU();
    AppMethodBeat.o(97610);
    return bool;
  }
  
  public static boolean ecS()
  {
    return (zop >= 1080) && (zpi >= 1080);
  }
  
  public static int getScreenWidth()
  {
    if (zpi > zop) {
      return zop;
    }
    return zpi;
  }
  
  public static void hO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(97597);
    zpi = paramInt1;
    zop = paramInt2;
    ae.i("MicroMsg.snsMediaStorage", "SCREEN %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(97597);
  }
  
  private static boolean jY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(219644);
    try
    {
      Bitmap localBitmap = com.tencent.mm.plugin.sns.d.a.m(paramString1, 0.0F);
      byte[] arrayOfByte = aq(localBitmap);
      localBitmap.recycle();
      com.tencent.mm.plugin.emoji.d.cha();
      if (com.tencent.mm.plugin.emoji.d.a(arrayOfByte, paramString1, paramString2, localBitmap.getWidth(), localBitmap.getHeight(), localBitmap.getWidth(), localBitmap.getHeight()) == 0)
      {
        AppMethodBeat.o(219644);
        return true;
      }
      AppMethodBeat.o(219644);
      return false;
    }
    catch (OutOfMemoryError paramString2)
    {
      ae.w("MicroMsg.snsMediaStorage", "convertImg2WxamWithoutZip origPath:%s OutOfMemoryError! rollback", new Object[] { paramString1 });
      AppMethodBeat.o(219644);
    }
    return false;
  }
  
  public final t AH(long paramLong)
  {
    AppMethodBeat.i(97604);
    t localt = new t();
    Cursor localCursor = this.hKK.a("SnsMedia", null, "local_id=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
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
    paramt = paramt.ecM();
    paramInt = this.hKK.update("SnsMedia", paramt, "local_id=?", new String[] { String.valueOf(paramInt) });
    AppMethodBeat.o(97602);
    return paramInt;
  }
  
  public final q a(q paramq, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(97608);
    t localt = new t();
    localt.createTime = ((int)bu.aRi());
    localt.type = paramq.type;
    bzk localbzk = new bzk();
    localbzk.Hml = paramq.zur;
    localbzk.HmH = paramq.zuq;
    localbzk.token = paramq.zus;
    localbzk.HmQ = paramq.zut;
    localbzk.Hne = 0;
    localbzk.Hnd = new bzc();
    localbzk.hiJ = 0;
    localbzk.Desc = paramq.desc;
    ae.d("MicroMsg.snsMediaStorage", "upload.filterId " + paramq.zup);
    localbzk.HmG = paramq.zup;
    localbzk.HiZ = 2;
    localbzk.videoPath = paramString1;
    localbzk.Hnh = paramString2;
    localbzk.md5 = paramq.zuu;
    for (;;)
    {
      try
      {
        localt.Aey = localbzk.toByteArray();
        localt.ecN();
        i = (int)this.hKK.a("SnsMedia", "local_id", localt.ecM());
        str1 = "Locall_path".concat(String.valueOf(i));
        ae.d("MicroMsg.snsMediaStorage", "insert localId ".concat(String.valueOf(i)));
        String str2 = r.azm(str1);
        String str3 = r.azn(str1);
        String str4 = r.azl(str1);
        String str5 = r.azo(str1);
        String str6 = aBI(str1);
        o.aZI(str6);
        o.mF(paramString2, str6 + str2);
        o.mF(paramString2, str6 + str3);
        o.mF(paramString2, str6 + str4);
        o.mF(paramString1, str6 + str5);
        localbzk.videoPath = (str6 + str5);
        localbzk.Hnh = (str6 + str3);
        localbzk.md5 = paramq.zuu;
      }
      catch (Exception localException)
      {
        try
        {
          int i;
          String str1;
          localt.Aey = localbzk.toByteArray();
          localt.Aeu = str1;
          if ((TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4)))
          {
            a(i, localt);
            paramq = a(paramq, localbzk.Hnh);
            paramq.dKr = i;
            AppMethodBeat.o(97608);
            return paramq;
            localException = localException;
            ae.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
          }
        }
        catch (Exception paramString2)
        {
          ae.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
          continue;
          paramString2 = new bzc();
          paramString2.nJA = 1;
          paramString2.Url = paramString3;
          localbzk.Hnd = paramString2;
          localbzk.HiZ = 0;
          f.aHa();
          localbzk.HmE = com.tencent.mm.an.a.Fn(paramString1);
          if (!bu.isNullOrNil(paramString4))
          {
            paramString1 = new bzc();
            paramString1.nJA = 1;
            paramString1.Url = paramString4;
            localbzk.Hnf.add(paramString1);
          }
        }
      }
      try
      {
        localt.Aey = localbzk.toByteArray();
        localt.ecO();
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.snsMediaStorage", paramString1, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean a(String paramString, t paramt)
  {
    AppMethodBeat.i(97600);
    ae.d("MicroMsg.snsMediaStorage", "replace AlbumLikeList ".concat(String.valueOf(paramString)));
    Cursor localCursor = this.hKK.a("SnsMedia", null, "StrId=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
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
  
  public final t aBJ(String paramString)
  {
    AppMethodBeat.i(97603);
    t localt = new t();
    paramString = this.hKK.a("SnsMedia", null, "StrId=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
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
  
  public final List<q> ga(List<q> paramList)
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
      q localq1 = (q)paramList.next();
      int i = a(localq1);
      if (i == -1)
      {
        AppMethodBeat.o(97605);
        return null;
      }
      q localq2 = new q(i, localq1.type);
      localq2.height = localq1.height;
      localq2.width = localq1.width;
      localq2.fileSize = localq1.fileSize;
      localLinkedList.add(localq2);
    }
    AppMethodBeat.o(97605);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.u
 * JD-Core Version:    0.7.0.1
 */