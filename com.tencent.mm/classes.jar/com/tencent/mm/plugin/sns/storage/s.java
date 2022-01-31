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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.al.f;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.memory.l;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.protocal.protobuf.bcv;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s
  extends k
{
  public static final String[] SQL_CREATE;
  private static int qYs;
  private static int qZk;
  private static Point rhc;
  public com.tencent.mm.cg.h fnw;
  
  static
  {
    AppMethodBeat.i(38001);
    SQL_CREATE = new String[] { "CREATE TABLE IF NOT EXISTS SnsMedia ( local_id INTEGER PRIMARY KEY, seqId LONG, type INT, createTime LONG, userName VARCHAR(40), totallen INT, offset INT, local_flag INT, tmp_path TEXT, nums INT, try_times INT, StrId VARCHAR(40), upload_buf TEXT, reserved1 INT, reserved2 TEXT, reserved3 TEXT, reserved4 TEXT, reserved5 TEXT )", "CREATE INDEX IF NOT EXISTS serverSnsMediaTimeIndex ON SnsMedia ( createTime )" };
    qZk = 0;
    qYs = 0;
    rhc = new Point();
    AppMethodBeat.o(38001);
  }
  
  public s(com.tencent.mm.cg.h paramh)
  {
    this.fnw = paramh;
  }
  
  private int a(com.tencent.mm.plugin.sns.data.h paramh)
  {
    AppMethodBeat.i(37988);
    Object localObject1 = ag.getAccSnsPath();
    String str1 = ag.getAccSnsTmpPath();
    ab.i("MicroMsg.snsMediaStorage", "SnsMediaStorage %s %s", new Object[] { localObject1, str1 });
    long l = System.currentTimeMillis();
    Object localObject2 = paramh.path;
    int i = paramh.type;
    if (!e.cN((String)localObject2))
    {
      AppMethodBeat.o(37988);
      return -1;
    }
    String str3 = g.w(((String)localObject2 + System.currentTimeMillis()).getBytes());
    String str2 = i.ZB(str3);
    ab.d("MicroMsg.snsMediaStorage", "insert : original img path = ".concat(String.valueOf(localObject2)));
    if (!e.cN(str1))
    {
      ab.i("MicroMsg.snsMediaStorage", "create snstmp path ".concat(String.valueOf(str1)));
      e.um(str1);
    }
    if (!e.cN((String)localObject1))
    {
      ab.i("MicroMsg.snsMediaStorage", "create snsPath ".concat(String.valueOf(localObject1)));
      e.um((String)localObject1);
    }
    localObject1 = new com.tencent.mm.plugin.i.a();
    paramh = a(paramh, (String)localObject2);
    int j = paramh.width;
    int k = paramh.height;
    int m = paramh.fileSize;
    ((com.tencent.mm.plugin.i.a)localObject1).nLb = ((String)localObject2);
    ((com.tencent.mm.plugin.i.a)localObject1).nLd = j;
    ((com.tencent.mm.plugin.i.a)localObject1).nLe = k;
    ((com.tencent.mm.plugin.i.a)localObject1).nLf = m;
    if (!d(str1, (String)localObject2, str2, true))
    {
      AppMethodBeat.o(37988);
      return -1;
    }
    ab.d("MicroMsg.snsMediaStorage", "insert0 " + (System.currentTimeMillis() - l));
    ab.d("MicroMsg.snsMediaStorage", "insert: compressed bigMediaPath = ".concat(String.valueOf(str2)));
    j = (int)e.avI(str1 + str2);
    if ((((String)localObject2).toLowerCase().contains("jpg")) || (((String)localObject2).toLowerCase().contains("jpeg")))
    {
      localObject2 = com.tencent.mm.sdk.platformtools.d.bU(e.i((String)localObject2, 0, j));
      if (localObject2 != null) {
        ab.i("MicroMsg.snsMediaStorage", "insert yuvInfo:%s", new Object[] { localObject2 });
      }
    }
    try
    {
      localObject3 = new ExifInterface(str1 + str2);
      ((ExifInterface)localObject3).setAttribute("UserComment", (String)localObject2);
      ((ExifInterface)localObject3).saveAttributes();
      j = (int)e.avI(str1 + str2);
      localObject3 = a(paramh, str1 + str2);
      k = ((com.tencent.mm.plugin.sns.data.h)localObject3).width;
      m = ((com.tencent.mm.plugin.sns.data.h)localObject3).height;
      ((com.tencent.mm.plugin.i.a)localObject1).nLg = k;
      ((com.tencent.mm.plugin.i.a)localObject1).nLh = m;
      ((com.tencent.mm.plugin.i.a)localObject1).nLi = j;
      localObject2 = new r();
      ((r)localObject2).rDC = str3;
      ((r)localObject2).createTime = ((int)bo.aox());
      ((r)localObject2).type = i;
      paramh = new bcv();
      paramh.xrU = ((com.tencent.mm.plugin.sns.data.h)localObject3).rbr;
      paramh.xsp = ((com.tencent.mm.plugin.sns.data.h)localObject3).rbq;
      paramh.token = ((com.tencent.mm.plugin.sns.data.h)localObject3).rbs;
      paramh.xsy = ((com.tencent.mm.plugin.sns.data.h)localObject3).rbt;
      paramh.xsL = 0;
      paramh.xsK = new bcp();
      paramh.ePG = 0;
      paramh.Desc = ((com.tencent.mm.plugin.sns.data.h)localObject3).desc;
      ab.d("MicroMsg.snsMediaStorage", "upload.filterId " + ((com.tencent.mm.plugin.sns.data.h)localObject3).filterId);
      paramh.xso = ((com.tencent.mm.plugin.sns.data.h)localObject3).filterId;
      paramh.nkT = 2;
      paramh.cqq = e.avP(str1 + str2);
    }
    catch (Exception localException1)
    {
      try
      {
        ((r)localObject2).rDG = paramh.toByteArray();
        ((r)localObject2).ctd();
        ((r)localObject2).rDB = j;
        ab.i("MicroMsg.snsMediaStorage", "insert a local snsMedia  totallen  :" + j + " filepath: " + str1 + str2);
        j = (int)this.fnw.a("SnsMedia", "local_id", ((r)localObject2).ctc());
        ab.d("MicroMsg.snsMediaStorage", "insert localId ".concat(String.valueOf(j)));
        str3 = "Locall_path".concat(String.valueOf(j));
        ((com.tencent.mm.plugin.i.a)localObject1).nLc = String.valueOf(j);
        ((com.tencent.mm.plugin.i.a)localObject1).cqq = paramh.cqq;
        Object localObject3 = Exif.fromFile(((com.tencent.mm.plugin.i.a)localObject1).nLb);
        i = com.tencent.mm.plugin.i.a.uD(((com.tencent.mm.plugin.i.a)localObject1).nLb);
        if (((com.tencent.mm.plugin.i.a)localObject1).nLb.indexOf("png") >= 0)
        {
          i = 1;
          paramh = ((Exif)localObject3).dateTimeOriginal;
          localObject4 = ((com.tencent.mm.plugin.i.a)localObject1).nLb;
          if (bo.isNullOrNil(paramh)) {
            break label1983;
          }
          paramh = com.tencent.mm.plugin.i.a.QU(paramh);
          localObject4 = new com.tencent.mm.modelsns.d();
          ((com.tencent.mm.modelsns.d)localObject4).k("20 localID", ((com.tencent.mm.plugin.i.a)localObject1).nLc + ",");
          ((com.tencent.mm.modelsns.d)localObject4).k("21 MediaType", i + ",");
          ((com.tencent.mm.modelsns.d)localObject4).k("22 OriginWidth", ((com.tencent.mm.plugin.i.a)localObject1).nLd + ",");
          ((com.tencent.mm.modelsns.d)localObject4).k("23 OriginHeight", ((com.tencent.mm.plugin.i.a)localObject1).nLe + ",");
          ((com.tencent.mm.modelsns.d)localObject4).k("24 CompressedWidth", ((com.tencent.mm.plugin.i.a)localObject1).nLg + ",");
          ((com.tencent.mm.modelsns.d)localObject4).k("25 CompressedHeight", ((com.tencent.mm.plugin.i.a)localObject1).nLh + ",");
          ((com.tencent.mm.modelsns.d)localObject4).k("26 OriginSize", ((com.tencent.mm.plugin.i.a)localObject1).nLf + ",");
          ((com.tencent.mm.modelsns.d)localObject4).k("27 CompressedSize", ((com.tencent.mm.plugin.i.a)localObject1).nLi + ",");
          ((com.tencent.mm.modelsns.d)localObject4).k("28 FNumber", ((Exif)localObject3).fNumber + ",");
          ((com.tencent.mm.modelsns.d)localObject4).k("29 ExposureTime", ((Exif)localObject3).exposureTime + ",");
          ((com.tencent.mm.modelsns.d)localObject4).k("30 ISO", ((Exif)localObject3).isoSpeedRatings + ",");
          ((com.tencent.mm.modelsns.d)localObject4).k("31 Flash", ((Exif)localObject3).flash + ",");
          ((com.tencent.mm.modelsns.d)localObject4).k("32 LensModel", com.tencent.mm.plugin.i.a.QU(((Exif)localObject3).model) + ",");
          ((com.tencent.mm.modelsns.d)localObject4).k("33 CreatTime", paramh + ",");
          ((com.tencent.mm.modelsns.d)localObject4).k("34 IsFromWeChat", "0,");
          ((com.tencent.mm.modelsns.d)localObject4).k("35 Scene", ",");
          ((com.tencent.mm.modelsns.d)localObject4).k("36 sceneType", ((Exif)localObject3).sceneType + ",");
          ((com.tencent.mm.modelsns.d)localObject4).k("37 fileSource", ((Exif)localObject3).fileSource + ",");
          ((com.tencent.mm.modelsns.d)localObject4).k("38 make", ((Exif)localObject3).make + ",");
          ((com.tencent.mm.modelsns.d)localObject4).k("39 software", ((Exif)localObject3).software + ",");
          ((com.tencent.mm.modelsns.d)localObject4).k("40 fileExt", com.tencent.mm.plugin.i.a.cP(((com.tencent.mm.plugin.i.a)localObject1).nLb) + ",");
          ((com.tencent.mm.modelsns.d)localObject4).k("41 faceCount", "0,");
          ((com.tencent.mm.modelsns.d)localObject4).k("42 YCbCrSubSampling", ((Exif)localObject3).yCbCrSubSampling + ",");
          ((com.tencent.mm.modelsns.d)localObject4).k("43 md5", ((com.tencent.mm.plugin.i.a)localObject1).cqq + ',');
          ab.v("MicroMsg.ImgExtInfoReport", "report logbuffer MMImageExifInfo(14525): %s, orgPath:%s", new Object[] { ((com.tencent.mm.modelsns.d)localObject4).Fg(), ((com.tencent.mm.plugin.i.a)localObject1).nLb });
          com.tencent.mm.plugin.report.service.h.qsU.e(14525, new Object[] { localObject4 });
          paramh = ((com.tencent.mm.modelsns.d)localObject4).toString();
          com.tencent.mm.plugin.sns.i.d.cqe().roI.put(Integer.valueOf(j), paramh);
          paramh = i.ZB(str3);
          localObject1 = abJ(str3);
          e.um((String)localObject1);
          ab.i("MicroMsg.snsMediaStorage", "checkcntpath ".concat(String.valueOf(localObject1)));
          e.C(str1 + str2, (String)localObject1 + paramh);
          str1 = (String)localObject1 + i.Zx(str3);
          str2 = (String)localObject1 + i.Zy(str3);
          e.deleteFile(str1);
          e.deleteFile(str2);
          ab.i("MicroMsg.snsMediaStorage", "insert done " + (System.currentTimeMillis() - l) + " targetPath : " + (String)localObject1 + paramh + " totalLen:" + e.avI(new StringBuilder().append((String)localObject1).append(paramh).toString()) + "  now delete...:" + str1 + " & " + str2);
          ((r)localObject2).rDC = str3;
          a(j, (r)localObject2);
          AppMethodBeat.o(37988);
          return j;
          localException1 = localException1;
          ab.printErrStackTrace("MicroMsg.snsMediaStorage", localException1, "", new Object[0]);
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject4;
          ab.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
          continue;
          if ((((com.tencent.mm.plugin.i.a)localObject1).nLb.indexOf("jpg") >= 0) || (((com.tencent.mm.plugin.i.a)localObject1).nLb.indexOf("jpeg") >= 0))
          {
            i = 2;
          }
          else if (((com.tencent.mm.plugin.i.a)localObject1).nLb.indexOf("mp3") >= 0)
          {
            i = 3;
            continue;
            label1983:
            paramh = com.tencent.mm.plugin.i.a.QU(new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(new Date(new File((String)localObject4).lastModified())));
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
    AppMethodBeat.i(37987);
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
        ab.printErrStackTrace("MicroMsg.snsMediaStorage", localObject4, "setImageExtInfo failed: ".concat(String.valueOf(paramString)), new Object[0]);
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
          break label334;
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
            AppMethodBeat.o(37987);
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
      paramh.fileSize = ((int)e.avI(paramString));
      AppMethodBeat.o(37987);
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
  
  private boolean a(r paramr)
  {
    AppMethodBeat.i(37980);
    ab.d("MicroMsg.snsMediaStorage", "snsMedia Insert");
    if (paramr == null)
    {
      AppMethodBeat.o(37980);
      return false;
    }
    paramr = paramr.ctc();
    if ((int)this.fnw.a("SnsMedia", "local_id", paramr) != -1)
    {
      AppMethodBeat.o(37980);
      return true;
    }
    AppMethodBeat.o(37980);
    return false;
  }
  
  private static boolean a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Bitmap.CompressFormat paramCompressFormat, int paramInt5, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(37998);
    Object localObject5 = null;
    Object localObject3 = localObject5;
    double d2;
    double d3;
    try
    {
      ab.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, srcWidth: %s, srcHeight: %s, width: %s, height: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt3) });
      localObject3 = localObject5;
      Object localObject2 = new BitmapFactory.Options();
      localObject3 = localObject5;
      d2 = paramInt2 * 1.0D / paramInt3;
      localObject3 = localObject5;
      d3 = paramInt1 * 1.0D / paramInt4;
      if ((paramInt1 == paramInt4) && (paramInt2 == paramInt3))
      {
        localObject3 = localObject5;
        localObject2 = com.tencent.mm.plugin.sns.d.a.b(paramString1, (BitmapFactory.Options)localObject2);
      }
      for (;;)
      {
        localObject3 = localObject5;
        ab.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, result bm: %s", new Object[] { localObject2 });
        if (localObject2 == null)
        {
          AppMethodBeat.o(37998);
          return false;
          localObject3 = localObject5;
          ((BitmapFactory.Options)localObject2).inSampleSize = 1;
          if (paramInt2 <= paramInt3)
          {
            if (paramInt1 > paramInt4)
            {
              break label634;
              label175:
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
            AppMethodBeat.o(37998);
            return false;
            d1 = d2;
            break label175;
            localObject3 = localObject5;
            ab.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, sampleSize: %s", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject2).inSampleSize) });
            localObject3 = localObject5;
            localObject2 = com.tencent.mm.plugin.sns.d.a.b(paramString1, (BitmapFactory.Options)localObject2);
            continue;
            localObject3 = localObject5;
            ab.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()) });
            localObject4 = localObject2;
            if (paramBoolean)
            {
              if (d2 >= d3) {
                break label595;
              }
              localObject3 = localObject5;
              paramInt2 = (int)Math.ceil(paramInt4 * 1.0D * paramInt2 / paramInt1);
              paramInt1 = paramInt4;
            }
            for (;;)
            {
              localObject3 = localObject5;
              paramInt3 = BackwardSupportUtil.ExifHelper.bY(paramString1);
              if (paramInt3 == 90) {
                break label649;
              }
              if (paramInt3 != 270) {
                break;
              }
              break label649;
              localObject3 = localObject5;
              localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject2, paramInt1, paramInt2, true);
              paramString1 = (String)localObject2;
              if (localObject4 != null)
              {
                if (localObject2 == localObject4) {
                  break label658;
                }
                localObject3 = localObject5;
                l.XQ().u((Bitmap)localObject2);
                break label658;
              }
              localObject3 = localObject5;
              ab.i("MicroMsg.snsMediaStorage", "createThumbNailUnScalebyUpload, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(paramString1.getWidth()), Integer.valueOf(paramString1.getHeight()) });
              localObject4 = paramString1;
              localObject3 = localObject5;
              paramString1 = e.M(paramString2 + paramString3, false);
              localObject3 = paramString1;
              com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject4, paramInt5, paramCompressFormat, paramString1, false);
              localObject3 = paramString1;
              l.XQ().u((Bitmap)localObject4);
              localObject3 = paramString1;
              paramString1.close();
              AppMethodBeat.o(37998);
              return true;
              d1 = paramInt3 * 1.0D * paramInt1 / paramInt2;
              localObject3 = localObject5;
              d1 = Math.ceil(d1);
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
      ab.printErrStackTrace("MicroMsg.snsMediaStorage", paramString1, "create thumbnail from orig failed: %s", new Object[] { paramString3 });
      if (localObject3 == null) {}
    }
    label649:
    label658:
    for (;;)
    {
      double d1;
      Object localObject4;
      label595:
      label634:
      if (d2 < d3)
      {
        d1 = d3;
        break;
        paramInt3 = paramInt1;
        paramInt1 = paramInt2;
        paramInt2 = paramInt3;
        continue;
        paramString1 = (String)localObject4;
      }
    }
  }
  
  private static boolean a(String paramString1, int paramInt1, int paramInt2, int paramInt3, Bitmap.CompressFormat paramCompressFormat, int paramInt4, String paramString2, String paramString3)
  {
    AppMethodBeat.i(37995);
    localObject3 = null;
    localObject1 = localObject3;
    try
    {
      ab.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, srcWidth: %d, srcHeight: %d, fixShort: %d, quality:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      localObject1 = localObject3;
      Object localObject2 = new BitmapFactory.Options();
      int i;
      if (paramInt2 > paramInt1)
      {
        i = paramInt1;
        if (i != paramInt3) {
          break label133;
        }
        localObject1 = localObject3;
        localObject2 = com.tencent.mm.plugin.sns.d.a.b(paramString1, (BitmapFactory.Options)localObject2);
      }
      for (;;)
      {
        localObject1 = localObject3;
        ab.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, result bm: %s", new Object[] { localObject2 });
        if (localObject2 == null)
        {
          AppMethodBeat.o(37995);
          return false;
          i = paramInt2;
          break;
          label133:
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
        try
        {
          localObject1.close();
          AppMethodBeat.o(37995);
          return false;
          localObject1 = localObject3;
          ab.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, sampleSize: %s", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject2).inSampleSize) });
          localObject1 = localObject3;
          localObject2 = com.tencent.mm.plugin.sns.d.a.b(paramString1, (BitmapFactory.Options)localObject2);
          continue;
          localObject1 = localObject3;
          j = paramInt1 * paramInt3 / i;
          localObject1 = localObject3;
          paramInt3 = paramInt2 * paramInt3 / i;
          localObject1 = localObject3;
          int m = BackwardSupportUtil.ExifHelper.bY(paramString1);
          if (m != 90) {
            if (m == 270)
            {
              break label697;
              localObject1 = localObject3;
              ab.i("MicroMsg.snsMediaStorage", "createThumbNailUnScale, bm.width: %s, bm.height: %s, new:[%d,%d], src:[%d, %d], shortEdge:%d,degree:%d", new Object[] { Integer.valueOf(((Bitmap)localObject2).getWidth()), Integer.valueOf(((Bitmap)localObject2).getHeight()), Integer.valueOf(paramInt3), Integer.valueOf(j), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(m) });
              localObject1 = localObject3;
              Bitmap localBitmap = Bitmap.createScaledBitmap((Bitmap)localObject2, paramInt3, j, true);
              if (localBitmap != null)
              {
                paramString1 = localBitmap;
                if (localObject2 != localBitmap)
                {
                  localObject1 = localObject3;
                  l.XQ().u((Bitmap)localObject2);
                  paramString1 = localBitmap;
                }
                localObject1 = localObject3;
                ab.i("MicroMsg.snsMediaStorage", "createThumbNailUnScaleFixShort, bm.width: %s, bm.height: %s, quality:%d", new Object[] { Integer.valueOf(paramString1.getWidth()), Integer.valueOf(paramString1.getHeight()), Integer.valueOf(paramInt4) });
                localObject1 = localObject3;
                localObject2 = e.M(paramString2 + paramString3, false);
                localObject1 = localObject2;
                com.tencent.mm.sdk.platformtools.d.a(paramString1, paramInt4, paramCompressFormat, (OutputStream)localObject2, false);
                localObject1 = localObject2;
                l.XQ().u(paramString1);
                localObject1 = localObject2;
                ((OutputStream)localObject2).close();
                localObject1 = null;
                ab.i("MicroMsg.snsMediaStorage", "createThumbNailUnScaleFixShort saving to %s, size:%d", new Object[] { paramString2 + paramString3, Long.valueOf(e.avI(paramString2 + paramString3)) });
                AppMethodBeat.o(37995);
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
            int k = paramInt3;
            paramInt3 = j;
            int j = k;
          }
        }
      }
    }
    catch (IOException paramString1)
    {
      ab.printErrStackTrace("MicroMsg.snsMediaStorage", paramString1, "create thumbnail from orig failed: %s", new Object[] { paramString3 });
      if (localObject1 == null) {}
    }
  }
  
  private static boolean a(String paramString1, int paramInt1, int paramInt2, Bitmap.CompressFormat paramCompressFormat, int paramInt3, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(37994);
    BitmapFactory.Options localOptions = com.tencent.mm.sdk.platformtools.d.aoT(paramString1);
    if ((localOptions == null) || (localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
    {
      AppMethodBeat.o(37994);
      return false;
    }
    paramBoolean = a(paramString1, localOptions.outWidth, localOptions.outHeight, paramInt1, paramInt2, paramCompressFormat, paramInt3, paramString2, paramString3, paramBoolean);
    AppMethodBeat.o(37994);
    return paramBoolean;
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, float paramFloat)
  {
    AppMethodBeat.i(37997);
    d4 = 0.0D;
    j = 1;
    i = 1;
    try
    {
      localObject3 = e.openRead(paramString1 + paramString2);
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
        AppMethodBeat.o(37997);
        return bool;
        d2 = d5;
        d3 = d5;
      }
    }
  }
  
  private static String abJ(String paramString)
  {
    AppMethodBeat.i(37979);
    if (paramString == null)
    {
      AppMethodBeat.o(37979);
      return "";
    }
    String str2 = g.w(paramString.getBytes());
    paramString = "";
    String str1 = "";
    if (str2.length() > 0) {
      paramString = str2.charAt(0) + "/";
    }
    if (str2.length() >= 2) {
      str1 = str2.charAt(1) + "/";
    }
    paramString = ag.getAccSnsPath() + paramString + str1;
    AppMethodBeat.o(37979);
    return paramString;
  }
  
  /* Error */
  public static boolean abL(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 774
    //   5: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 595	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   12: astore_0
    //   13: aload_0
    //   14: astore_2
    //   15: new 586	android/graphics/BitmapFactory$Options
    //   18: dup
    //   19: invokespecial 587	android/graphics/BitmapFactory$Options:<init>	()V
    //   22: astore_3
    //   23: aload_0
    //   24: astore_2
    //   25: aload_3
    //   26: iconst_1
    //   27: putfield 591	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   30: aload_0
    //   31: astore_2
    //   32: aload_0
    //   33: aconst_null
    //   34: aload_3
    //   35: invokestatic 739	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   38: pop
    //   39: aload_0
    //   40: astore_2
    //   41: aload_3
    //   42: getfield 744	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   45: astore_3
    //   46: aload_0
    //   47: astore_2
    //   48: ldc 65
    //   50: ldc_w 776
    //   53: aload_3
    //   54: invokestatic 130	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   57: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   60: invokestatic 137	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_0
    //   64: astore_2
    //   65: aload_3
    //   66: invokevirtual 190	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   69: ldc_w 778
    //   72: invokevirtual 366	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   75: istore_1
    //   76: iload_1
    //   77: iflt +19 -> 96
    //   80: aload_0
    //   81: ifnull +7 -> 88
    //   84: aload_0
    //   85: invokevirtual 637	java/io/InputStream:close	()V
    //   88: ldc_w 774
    //   91: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: iconst_1
    //   95: ireturn
    //   96: aload_0
    //   97: ifnull +7 -> 104
    //   100: aload_0
    //   101: invokevirtual 637	java/io/InputStream:close	()V
    //   104: ldc_w 774
    //   107: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: iconst_0
    //   111: ireturn
    //   112: astore_0
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: ifnull +7 -> 123
    //   119: aload_0
    //   120: invokevirtual 637	java/io/InputStream:close	()V
    //   123: ldc_w 774
    //   126: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: iconst_0
    //   130: ireturn
    //   131: astore_0
    //   132: aload_2
    //   133: ifnull +7 -> 140
    //   136: aload_2
    //   137: invokevirtual 637	java/io/InputStream:close	()V
    //   140: ldc_w 774
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
  
  public static Bitmap abM(String paramString)
  {
    int j = 640;
    AppMethodBeat.i(38000);
    Object localObject = com.tencent.mm.sdk.platformtools.d.aoT(paramString);
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
      localObject = com.tencent.mm.sdk.platformtools.d.d(paramString, j, i, false);
      if (localObject != null) {
        break label75;
      }
      AppMethodBeat.o(38000);
      return null;
      i = 640;
      break;
      label68:
      j = 960;
    }
    label75:
    paramString = com.tencent.mm.sdk.platformtools.d.b((Bitmap)localObject, Exif.fromFile(paramString).getOrientationInDegree());
    AppMethodBeat.o(38000);
    return paramString;
  }
  
  public static boolean an(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(156758);
    boolean bool = d(paramString1, paramString2, paramString3, true);
    AppMethodBeat.o(156758);
    return bool;
  }
  
  private boolean b(String paramString, r paramr)
  {
    AppMethodBeat.i(37982);
    paramr = paramr.ctc();
    if (this.fnw.update("SnsMedia", paramr, "StrId=?", new String[] { String.valueOf(paramString) }) > 0)
    {
      AppMethodBeat.o(37982);
      return true;
    }
    AppMethodBeat.o(37982);
    return false;
  }
  
  public static boolean b(String paramString1, String paramString2, String paramString3, float paramFloat)
  {
    AppMethodBeat.i(37999);
    Object localObject1;
    for (;;)
    {
      int i1;
      int n;
      int m;
      int k;
      try
      {
        e.deleteFile(paramString1 + paramString3);
        localObject1 = com.tencent.mm.sdk.platformtools.d.aoT(paramString1 + paramString2);
        if (localObject1 == null)
        {
          ab.e("MicroMsg.snsMediaStorage", "createUserAlbum, getImageOptions error");
          AppMethodBeat.o(37999);
          return false;
        }
        if ((((BitmapFactory.Options)localObject1).outMimeType != null) && ((((BitmapFactory.Options)localObject1).outMimeType.toLowerCase().endsWith("png")) || (((BitmapFactory.Options)localObject1).outMimeType.toLowerCase().endsWith("vcodec"))))
        {
          localObject1 = com.tencent.mm.sdk.platformtools.d.d(paramString1 + paramString2, (int)paramFloat, (int)paramFloat, true);
          if (localObject1 != null) {
            break;
          }
          ab.i("MicroMsg.snsMediaStorage", "bitmap error " + paramString1 + paramString2);
          e.deleteFile(paramString1 + paramString2);
          AppMethodBeat.o(37999);
          return false;
        }
        i1 = ((BitmapFactory.Options)localObject1).outWidth;
        n = ((BitmapFactory.Options)localObject1).outHeight;
        m = (int)paramFloat;
        k = (int)paramFloat;
        ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
        ab.i("MicroMsg.snsMediaStorage", "createUserAlbum, srcWidth: %s, srcHeight: %s, dstWidth: %s, dstHeight: %s", new Object[] { Integer.valueOf(i1), Integer.valueOf(n), Integer.valueOf(m), Integer.valueOf(k) });
        if ((i1 == m) && (n == k))
        {
          localObject1 = com.tencent.mm.plugin.sns.d.a.b(paramString1 + paramString2, (BitmapFactory.Options)localObject1);
          continue;
        }
        if (n * 1.0D / k <= i1 * 1.0D / m) {
          break label566;
        }
        j = (int)Math.ceil(m * 1.0D * n / i1);
        i = m;
        ab.d("MicroMsg.snsMediaStorage", "createUserAlbum, newWidth: %s, newHeight: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        ((BitmapFactory.Options)localObject1).inSampleSize = 1;
        if ((n <= j) && (i1 <= i)) {
          break label596;
        }
        ((BitmapFactory.Options)localObject1).inSampleSize = 1;
        if ((n > j) || (i1 > i))
        {
          d1 = n * 1.0D / j;
          double d2 = i1 * 1.0D / i;
          if (d1 >= d2) {
            break label1044;
          }
          d1 = d2;
          ((BitmapFactory.Options)localObject1).inSampleSize = ((int)d1);
          if (((BitmapFactory.Options)localObject1).inSampleSize <= 1) {
            ((BitmapFactory.Options)localObject1).inSampleSize = 1;
          }
        }
        if (n * i1 / ((BitmapFactory.Options)localObject1).inSampleSize / ((BitmapFactory.Options)localObject1).inSampleSize <= 2764800) {
          break label596;
        }
        ((BitmapFactory.Options)localObject1).inSampleSize += 1;
        continue;
        AppMethodBeat.o(37999);
      }
      catch (Exception paramString1)
      {
        ab.e("MicroMsg.snsMediaStorage", "createUserAlbum error: %s", new Object[] { paramString1.getMessage() });
        ab.printErrStackTrace("MicroMsg.snsMediaStorage", paramString1, "", new Object[0]);
      }
      return true;
      label566:
      double d1 = k * 1.0D * i1 / n;
      i = (int)Math.ceil(d1);
      int j = k;
      continue;
      label596:
      ab.i("MicroMsg.snsMediaStorage", "createUserAlbum, inSampleSize: %s", new Object[] { Integer.valueOf(((BitmapFactory.Options)localObject1).inSampleSize) });
      if (n / i1 == k / m)
      {
        localObject1 = com.tencent.mm.plugin.sns.d.a.b(paramString1 + paramString2, (BitmapFactory.Options)localObject1);
        ab.i("MicroMsg.snsMediaStorage", "createUserAlbum, directly use inSampleSize");
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
        localObject2 = l.XQ().a(str, (Rect)localObject2, (BitmapFactory.Options)localObject1);
        localObject1 = localObject2;
        if (localObject2 != null) {
          localObject1 = i.s(str, (Bitmap)localObject2);
        }
        ab.d("MicroMsg.SnsBitmapUtil", "regionDecodeWithRotateByExif used %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        ab.i("MicroMsg.snsMediaStorage", "createUserAlbum, dstWidth: %s, dstHeight: %s, startX: %s, startY: %s, scaleFactor: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Float.valueOf(paramFloat) });
      }
    }
    ab.i("MicroMsg.snsMediaStorage", "createUserAlbum, bm.width: %s, bm.height: %s", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()) });
    int i = 1;
    if ((((Bitmap)localObject1).getHeight() <= 120) && (((Bitmap)localObject1).getWidth() <= 120)) {}
    for (;;)
    {
      if (i != 0) {}
      for (paramString2 = Bitmap.CompressFormat.PNG;; paramString2 = Bitmap.CompressFormat.JPEG)
      {
        com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject1, 100, paramString2, paramString1 + paramString3, false);
        l.XQ().u((Bitmap)localObject1);
        break;
      }
      label1044:
      break;
      i = 0;
    }
  }
  
  public static boolean ctf()
  {
    AppMethodBeat.i(37990);
    if ("hevc".equals(ae.glx))
    {
      AppMethodBeat.o(37990);
      return true;
    }
    boolean bool = ag.cpp();
    AppMethodBeat.o(37990);
    return bool;
  }
  
  public static boolean ctg()
  {
    AppMethodBeat.i(37991);
    if ("wxpc".equals(ae.glx))
    {
      AppMethodBeat.o(37991);
      return true;
    }
    boolean bool = ag.cpq();
    AppMethodBeat.o(37991);
    return bool;
  }
  
  public static boolean cth()
  {
    return (qYs >= 1080) && (qZk >= 1080);
  }
  
  /* Error */
  public static boolean d(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc_w 897
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: invokestatic 732	com/tencent/mm/sdk/platformtools/d:aoT	(Ljava/lang/String;)Landroid/graphics/BitmapFactory$Options;
    //   10: astore 20
    //   12: aload 20
    //   14: ifnull +952 -> 966
    //   17: aload 20
    //   19: getfield 744	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   22: astore 21
    //   24: ldc 65
    //   26: ldc_w 899
    //   29: aload 21
    //   31: invokestatic 130	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   34: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   37: invokestatic 137	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload 21
    //   42: ifnull +924 -> 966
    //   45: aload 21
    //   47: invokevirtual 190	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   50: astore 21
    //   52: aload 21
    //   54: ldc 192
    //   56: invokevirtual 366	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   59: iflt +874 -> 933
    //   62: iconst_1
    //   63: istore 17
    //   65: aload 20
    //   67: ifnull +921 -> 988
    //   70: aload 20
    //   72: getfield 744	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   75: astore 21
    //   77: aload 21
    //   79: ifnull +909 -> 988
    //   82: aload 21
    //   84: invokevirtual 190	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   87: astore 21
    //   89: aload 21
    //   91: ldc 192
    //   93: invokevirtual 366	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   96: iflt +876 -> 972
    //   99: iconst_1
    //   100: istore 10
    //   102: iconst_m1
    //   103: istore 8
    //   105: bipush 100
    //   107: istore 9
    //   109: iload 8
    //   111: istore 11
    //   113: iload_3
    //   114: ifeq +236 -> 350
    //   117: invokestatic 905	com/tencent/mm/al/f:afO	()Lcom/tencent/mm/al/b;
    //   120: pop
    //   121: bipush 64
    //   123: invokestatic 911	com/tencent/mm/al/b:lc	(I)Z
    //   126: ifne +15 -> 141
    //   129: invokestatic 913	com/tencent/mm/plugin/sns/storage/s:ctf	()Z
    //   132: ifne +9 -> 141
    //   135: invokestatic 915	com/tencent/mm/plugin/sns/storage/s:ctg	()Z
    //   138: ifeq +931 -> 1069
    //   141: invokestatic 921	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   144: invokestatic 927	com/tencent/mm/sdk/platformtools/at:isWifi	(Landroid/content/Context;)Z
    //   147: ifeq +847 -> 994
    //   150: invokestatic 933	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   153: ldc_w 935
    //   156: invokevirtual 940	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   159: bipush 70
    //   161: invokestatic 944	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   164: istore 7
    //   166: ldc 65
    //   168: ldc_w 946
    //   171: bipush 7
    //   173: anewarray 69	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: invokestatic 933	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   181: ldc_w 935
    //   184: invokevirtual 940	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   187: aastore
    //   188: dup
    //   189: iconst_1
    //   190: invokestatic 933	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   193: ldc_w 948
    //   196: invokevirtual 940	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   199: aastore
    //   200: dup
    //   201: iconst_2
    //   202: invokestatic 933	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   205: ldc_w 950
    //   208: invokevirtual 940	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   211: aastore
    //   212: dup
    //   213: iconst_3
    //   214: invokestatic 933	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   217: ldc_w 952
    //   220: invokevirtual 940	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   223: aastore
    //   224: dup
    //   225: iconst_4
    //   226: invokestatic 933	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   229: ldc_w 954
    //   232: invokevirtual 940	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   235: aastore
    //   236: dup
    //   237: iconst_5
    //   238: invokestatic 933	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   241: ldc_w 956
    //   244: invokevirtual 940	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   247: aastore
    //   248: dup
    //   249: bipush 6
    //   251: invokestatic 933	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   254: ldc_w 958
    //   257: invokevirtual 940	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   260: aastore
    //   261: invokestatic 814	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: ldc 65
    //   266: ldc_w 960
    //   269: iconst_2
    //   270: anewarray 69	java/lang/Object
    //   273: dup
    //   274: iconst_0
    //   275: iload 7
    //   277: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   280: aastore
    //   281: dup
    //   282: iconst_1
    //   283: iload_3
    //   284: invokestatic 965	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   287: aastore
    //   288: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   291: iload 7
    //   293: bipush 10
    //   295: if_icmple +10 -> 305
    //   298: iload 7
    //   300: bipush 100
    //   302: if_icmple +2794 -> 3096
    //   305: bipush 60
    //   307: istore 7
    //   309: iload 8
    //   311: istore 11
    //   313: iload 7
    //   315: istore 9
    //   317: iload 10
    //   319: ifeq +31 -> 350
    //   322: aload_1
    //   323: invokestatic 970	com/tencent/mm/sdk/platformtools/MMNativeJpeg:queryQuality	(Ljava/lang/String;)I
    //   326: istore 8
    //   328: iload 8
    //   330: iload 7
    //   332: if_icmpge +2753 -> 3085
    //   335: iload 8
    //   337: bipush 25
    //   339: if_icmple +2746 -> 3085
    //   342: iload 8
    //   344: istore 9
    //   346: iload 8
    //   348: istore 11
    //   350: aload_1
    //   351: invokestatic 187	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   354: l2i
    //   355: istore 14
    //   357: sipush 1080
    //   360: istore 8
    //   362: aload_1
    //   363: invokestatic 975	com/tencent/mm/plugin/facedetect/FaceProNative:detectFaceCnt	(Ljava/lang/String;)I
    //   366: istore 7
    //   368: ldc 65
    //   370: ldc_w 977
    //   373: iconst_1
    //   374: anewarray 69	java/lang/Object
    //   377: dup
    //   378: iconst_0
    //   379: iload 7
    //   381: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   384: aastore
    //   385: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   388: iload 7
    //   390: iconst_5
    //   391: if_icmplt +8 -> 399
    //   394: sipush 1440
    //   397: istore 8
    //   399: iconst_0
    //   400: istore 12
    //   402: iload 7
    //   404: iconst_5
    //   405: if_icmplt +742 -> 1147
    //   408: iload 12
    //   410: istore 7
    //   412: invokestatic 933	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   415: ldc_w 979
    //   418: invokevirtual 940	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   421: astore 21
    //   423: iload 12
    //   425: istore 7
    //   427: aload 21
    //   429: ldc_w 981
    //   432: invokevirtual 985	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   435: iconst_0
    //   436: aaload
    //   437: invokestatic 988	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   440: invokevirtual 991	java/lang/Integer:intValue	()I
    //   443: istore 12
    //   445: iload 12
    //   447: istore 7
    //   449: aload 21
    //   451: ldc_w 981
    //   454: invokevirtual 985	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   457: iconst_1
    //   458: aaload
    //   459: invokestatic 988	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   462: invokevirtual 991	java/lang/Integer:intValue	()I
    //   465: istore 13
    //   467: iload 13
    //   469: istore 8
    //   471: iload 12
    //   473: istore 7
    //   475: ldc 65
    //   477: ldc_w 993
    //   480: bipush 6
    //   482: anewarray 69	java/lang/Object
    //   485: dup
    //   486: iconst_0
    //   487: iload 7
    //   489: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   492: aastore
    //   493: dup
    //   494: iconst_1
    //   495: iload 8
    //   497: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   500: aastore
    //   501: dup
    //   502: iconst_2
    //   503: getstatic 34	com/tencent/mm/plugin/sns/storage/s:qYs	I
    //   506: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   509: aastore
    //   510: dup
    //   511: iconst_3
    //   512: getstatic 32	com/tencent/mm/plugin/sns/storage/s:qZk	I
    //   515: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   518: aastore
    //   519: dup
    //   520: iconst_4
    //   521: iload 9
    //   523: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   526: aastore
    //   527: dup
    //   528: iconst_5
    //   529: iload_3
    //   530: invokestatic 965	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   533: aastore
    //   534: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   537: iload 7
    //   539: ifgt +927 -> 1466
    //   542: iload 8
    //   544: ifgt +922 -> 1466
    //   547: iconst_0
    //   548: istore 7
    //   550: sipush 1080
    //   553: istore 8
    //   555: invokestatic 933	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   558: ldc_w 995
    //   561: invokevirtual 940	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   564: bipush 100
    //   566: invokestatic 944	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   569: istore 13
    //   571: iload 13
    //   573: istore 12
    //   575: iload 13
    //   577: ifgt +7 -> 584
    //   580: bipush 100
    //   582: istore 12
    //   584: iload 12
    //   586: sipush 1024
    //   589: imul
    //   590: istore 15
    //   592: invokestatic 933	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   595: ldc_w 997
    //   598: invokevirtual 940	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   601: sipush 200
    //   604: invokestatic 944	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   607: istore 13
    //   609: iload 13
    //   611: istore 12
    //   613: iload 13
    //   615: ifgt +8 -> 623
    //   618: sipush 200
    //   621: istore 12
    //   623: iload 12
    //   625: sipush 1024
    //   628: imul
    //   629: istore 16
    //   631: invokestatic 933	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   634: ldc_w 999
    //   637: invokevirtual 940	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   640: bipush 10
    //   642: invokestatic 944	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   645: istore 12
    //   647: iload 12
    //   649: ifle +10 -> 659
    //   652: iload 12
    //   654: bipush 100
    //   656: if_icmplt +2423 -> 3079
    //   659: bipush 10
    //   661: istore 12
    //   663: iconst_0
    //   664: istore 13
    //   666: iload 10
    //   668: ifeq +869 -> 1537
    //   671: aload_1
    //   672: invokestatic 357	com/tencent/mm/compatible/util/Exif:fromFile	(Ljava/lang/String;)Lcom/tencent/mm/compatible/util/Exif;
    //   675: astore 21
    //   677: iload 13
    //   679: istore 10
    //   681: aload 21
    //   683: ifnull +14 -> 697
    //   686: aload 21
    //   688: invokevirtual 628	com/tencent/mm/compatible/util/Exif:getOrientationInDegree	()I
    //   691: sipush 360
    //   694: irem
    //   695: istore 10
    //   697: ldc 65
    //   699: new 97	java/lang/StringBuilder
    //   702: dup
    //   703: ldc_w 1001
    //   706: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   709: aload 20
    //   711: getfield 631	android/graphics/BitmapFactory$Options:outWidth	I
    //   714: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   717: ldc_w 1003
    //   720: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: aload 20
    //   725: getfield 634	android/graphics/BitmapFactory$Options:outHeight	I
    //   728: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   731: ldc_w 1003
    //   734: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: iload 17
    //   739: invokevirtual 1006	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   742: ldc_w 1008
    //   745: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: iload 11
    //   750: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   753: ldc_w 1010
    //   756: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: iload 10
    //   761: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   764: ldc_w 1012
    //   767: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: iload 14
    //   772: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   775: ldc_w 1014
    //   778: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   781: iload 7
    //   783: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   786: ldc_w 1003
    //   789: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: iload 8
    //   794: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   797: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   800: invokestatic 141	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   803: invokestatic 933	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   806: ldc_w 1016
    //   809: invokevirtual 940	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   812: bipush 10
    //   814: invokestatic 944	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   817: pop
    //   818: aload 20
    //   820: getfield 631	android/graphics/BitmapFactory$Options:outWidth	I
    //   823: aload 20
    //   825: getfield 634	android/graphics/BitmapFactory$Options:outHeight	I
    //   828: iconst_2
    //   829: imul
    //   830: if_icmpge +18 -> 848
    //   833: aload 20
    //   835: getfield 634	android/graphics/BitmapFactory$Options:outHeight	I
    //   838: aload 20
    //   840: getfield 631	android/graphics/BitmapFactory$Options:outWidth	I
    //   843: iconst_2
    //   844: imul
    //   845: if_icmplt +1426 -> 2271
    //   848: aload 20
    //   850: getfield 631	android/graphics/BitmapFactory$Options:outWidth	I
    //   853: aload 20
    //   855: getfield 634	android/graphics/BitmapFactory$Options:outHeight	I
    //   858: imul
    //   859: ldc_w 1017
    //   862: if_icmpgt +1166 -> 2028
    //   865: iload 14
    //   867: iload 16
    //   869: if_icmpge +682 -> 1551
    //   872: iload 17
    //   874: ifeq +677 -> 1551
    //   877: iload 10
    //   879: ifne +672 -> 1551
    //   882: ldc 65
    //   884: ldc_w 1019
    //   887: iload 16
    //   889: invokestatic 345	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   892: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   895: invokestatic 141	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   898: aload_1
    //   899: new 97	java/lang/StringBuilder
    //   902: dup
    //   903: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   906: aload_0
    //   907: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: aload_2
    //   911: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   914: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   917: invokestatic 527	com/tencent/mm/vfs/e:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   920: lconst_0
    //   921: lcmp
    //   922: iflt +621 -> 1543
    //   925: ldc_w 897
    //   928: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   931: iconst_1
    //   932: ireturn
    //   933: aload 21
    //   935: ldc 198
    //   937: invokevirtual 366	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   940: iflt +9 -> 949
    //   943: iconst_1
    //   944: istore 17
    //   946: goto -881 -> 65
    //   949: aload 21
    //   951: ldc_w 363
    //   954: invokevirtual 366	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   957: iflt +9 -> 966
    //   960: iconst_1
    //   961: istore 17
    //   963: goto -898 -> 65
    //   966: iconst_0
    //   967: istore 17
    //   969: goto -904 -> 65
    //   972: aload 21
    //   974: ldc 198
    //   976: invokevirtual 366	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   979: iflt +9 -> 988
    //   982: iconst_1
    //   983: istore 10
    //   985: goto -883 -> 102
    //   988: iconst_0
    //   989: istore 10
    //   991: goto -889 -> 102
    //   994: invokestatic 921	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   997: invokestatic 1022	com/tencent/mm/sdk/platformtools/at:is2G	(Landroid/content/Context;)Z
    //   1000: ifeq +22 -> 1022
    //   1003: invokestatic 933	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   1006: ldc_w 948
    //   1009: invokevirtual 940	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1012: bipush 70
    //   1014: invokestatic 944	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   1017: istore 7
    //   1019: goto -853 -> 166
    //   1022: invokestatic 921	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   1025: invokestatic 1025	com/tencent/mm/sdk/platformtools/at:is3G	(Landroid/content/Context;)Z
    //   1028: ifeq +22 -> 1050
    //   1031: invokestatic 933	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   1034: ldc_w 950
    //   1037: invokevirtual 940	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1040: bipush 60
    //   1042: invokestatic 944	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   1045: istore 7
    //   1047: goto -881 -> 166
    //   1050: invokestatic 933	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   1053: ldc_w 952
    //   1056: invokevirtual 940	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1059: bipush 60
    //   1061: invokestatic 944	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   1064: istore 7
    //   1066: goto -900 -> 166
    //   1069: invokestatic 921	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   1072: invokestatic 927	com/tencent/mm/sdk/platformtools/at:isWifi	(Landroid/content/Context;)Z
    //   1075: ifeq +23 -> 1098
    //   1078: invokestatic 933	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   1081: ldc_w 954
    //   1084: invokevirtual 940	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1087: invokestatic 988	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1090: invokevirtual 991	java/lang/Integer:intValue	()I
    //   1093: istore 7
    //   1095: goto -929 -> 166
    //   1098: invokestatic 921	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   1101: invokestatic 1022	com/tencent/mm/sdk/platformtools/at:is2G	(Landroid/content/Context;)Z
    //   1104: ifeq +23 -> 1127
    //   1107: invokestatic 933	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   1110: ldc_w 956
    //   1113: invokevirtual 940	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1116: invokestatic 988	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1119: invokevirtual 991	java/lang/Integer:intValue	()I
    //   1122: istore 7
    //   1124: goto -958 -> 166
    //   1127: invokestatic 933	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   1130: ldc_w 958
    //   1133: invokevirtual 940	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1136: invokestatic 988	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1139: invokevirtual 991	java/lang/Integer:intValue	()I
    //   1142: istore 7
    //   1144: goto -978 -> 166
    //   1147: iload 12
    //   1149: istore 7
    //   1151: invokestatic 921	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   1154: invokestatic 927	com/tencent/mm/sdk/platformtools/at:isWifi	(Landroid/content/Context;)Z
    //   1157: ifeq +73 -> 1230
    //   1160: iload 12
    //   1162: istore 7
    //   1164: invokestatic 933	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   1167: ldc_w 1027
    //   1170: invokevirtual 940	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1173: astore 21
    //   1175: iload 12
    //   1177: istore 7
    //   1179: aload 21
    //   1181: ldc_w 981
    //   1184: invokevirtual 985	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1187: iconst_0
    //   1188: aaload
    //   1189: invokestatic 988	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1192: invokevirtual 991	java/lang/Integer:intValue	()I
    //   1195: istore 12
    //   1197: iload 12
    //   1199: istore 7
    //   1201: aload 21
    //   1203: ldc_w 981
    //   1206: invokevirtual 985	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1209: iconst_1
    //   1210: aaload
    //   1211: invokestatic 988	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1214: invokevirtual 991	java/lang/Integer:intValue	()I
    //   1217: istore 13
    //   1219: iload 13
    //   1221: istore 8
    //   1223: iload 12
    //   1225: istore 7
    //   1227: goto -752 -> 475
    //   1230: iload 12
    //   1232: istore 7
    //   1234: invokestatic 921	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   1237: invokestatic 1022	com/tencent/mm/sdk/platformtools/at:is2G	(Landroid/content/Context;)Z
    //   1240: ifeq +73 -> 1313
    //   1243: iload 12
    //   1245: istore 7
    //   1247: invokestatic 933	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   1250: ldc_w 1029
    //   1253: invokevirtual 940	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1256: astore 21
    //   1258: iload 12
    //   1260: istore 7
    //   1262: aload 21
    //   1264: ldc_w 981
    //   1267: invokevirtual 985	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1270: iconst_0
    //   1271: aaload
    //   1272: invokestatic 988	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1275: invokevirtual 991	java/lang/Integer:intValue	()I
    //   1278: istore 12
    //   1280: iload 12
    //   1282: istore 7
    //   1284: aload 21
    //   1286: ldc_w 981
    //   1289: invokevirtual 985	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1292: iconst_1
    //   1293: aaload
    //   1294: invokestatic 988	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1297: invokevirtual 991	java/lang/Integer:intValue	()I
    //   1300: istore 13
    //   1302: iload 13
    //   1304: istore 8
    //   1306: iload 12
    //   1308: istore 7
    //   1310: goto -835 -> 475
    //   1313: iload 12
    //   1315: istore 7
    //   1317: invokestatic 921	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   1320: invokestatic 1025	com/tencent/mm/sdk/platformtools/at:is3G	(Landroid/content/Context;)Z
    //   1323: ifeq +73 -> 1396
    //   1326: iload 12
    //   1328: istore 7
    //   1330: invokestatic 933	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   1333: ldc_w 1031
    //   1336: invokevirtual 940	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1339: astore 21
    //   1341: iload 12
    //   1343: istore 7
    //   1345: aload 21
    //   1347: ldc_w 981
    //   1350: invokevirtual 985	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1353: iconst_0
    //   1354: aaload
    //   1355: invokestatic 988	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1358: invokevirtual 991	java/lang/Integer:intValue	()I
    //   1361: istore 12
    //   1363: iload 12
    //   1365: istore 7
    //   1367: aload 21
    //   1369: ldc_w 981
    //   1372: invokevirtual 985	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1375: iconst_1
    //   1376: aaload
    //   1377: invokestatic 988	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1380: invokevirtual 991	java/lang/Integer:intValue	()I
    //   1383: istore 13
    //   1385: iload 13
    //   1387: istore 8
    //   1389: iload 12
    //   1391: istore 7
    //   1393: goto -918 -> 475
    //   1396: iload 12
    //   1398: istore 7
    //   1400: invokestatic 933	com/tencent/mm/m/g:Nq	()Lcom/tencent/mm/m/e;
    //   1403: ldc_w 1033
    //   1406: invokevirtual 940	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   1409: astore 21
    //   1411: iload 12
    //   1413: istore 7
    //   1415: aload 21
    //   1417: ldc_w 981
    //   1420: invokevirtual 985	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1423: iconst_0
    //   1424: aaload
    //   1425: invokestatic 988	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1428: invokevirtual 991	java/lang/Integer:intValue	()I
    //   1431: istore 12
    //   1433: iload 12
    //   1435: istore 7
    //   1437: aload 21
    //   1439: ldc_w 981
    //   1442: invokevirtual 985	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1445: iconst_1
    //   1446: aaload
    //   1447: invokestatic 988	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1450: invokevirtual 991	java/lang/Integer:intValue	()I
    //   1453: istore 13
    //   1455: iload 13
    //   1457: istore 8
    //   1459: iload 12
    //   1461: istore 7
    //   1463: goto -988 -> 475
    //   1466: iload 8
    //   1468: sipush 2160
    //   1471: if_icmplt +14 -> 1485
    //   1474: iconst_0
    //   1475: istore 7
    //   1477: sipush 1080
    //   1480: istore 8
    //   1482: goto -927 -> 555
    //   1485: iload 8
    //   1487: ifgt +1595 -> 3082
    //   1490: iload 7
    //   1492: sipush 3240
    //   1495: if_icmple +1587 -> 3082
    //   1498: sipush 1620
    //   1501: istore 7
    //   1503: iconst_0
    //   1504: istore 8
    //   1506: goto -951 -> 555
    //   1509: astore 21
    //   1511: ldc 65
    //   1513: new 97	java/lang/StringBuilder
    //   1516: dup
    //   1517: ldc_w 1035
    //   1520: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1523: aload 21
    //   1525: invokevirtual 819	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1528: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1531: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1534: invokestatic 559	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1537: iconst_0
    //   1538: istore 10
    //   1540: goto -843 -> 697
    //   1543: ldc_w 897
    //   1546: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1549: iconst_0
    //   1550: ireturn
    //   1551: new 586	android/graphics/BitmapFactory$Options
    //   1554: dup
    //   1555: invokespecial 587	android/graphics/BitmapFactory$Options:<init>	()V
    //   1558: astore 24
    //   1560: invokestatic 1038	com/tencent/mm/sdk/platformtools/d:dsm	()V
    //   1563: aconst_null
    //   1564: astore 21
    //   1566: aconst_null
    //   1567: astore 20
    //   1569: aload_1
    //   1570: invokestatic 595	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1573: astore 23
    //   1575: aload 23
    //   1577: astore 22
    //   1579: aload 23
    //   1581: astore 20
    //   1583: aload 23
    //   1585: astore 21
    //   1587: aload 23
    //   1589: invokevirtual 601	java/io/InputStream:markSupported	()Z
    //   1592: ifne +22 -> 1614
    //   1595: aload 23
    //   1597: astore 20
    //   1599: aload 23
    //   1601: astore 21
    //   1603: new 603	java/io/BufferedInputStream
    //   1606: dup
    //   1607: aload 23
    //   1609: invokespecial 606	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1612: astore 22
    //   1614: aload 22
    //   1616: astore 20
    //   1618: aload 22
    //   1620: astore 21
    //   1622: aload 22
    //   1624: ldc_w 607
    //   1627: invokevirtual 610	java/io/InputStream:mark	(I)V
    //   1630: aload 22
    //   1632: astore 20
    //   1634: aload 22
    //   1636: astore 21
    //   1638: aload 22
    //   1640: aconst_null
    //   1641: aload 24
    //   1643: invokestatic 739	com/tencent/mm/graphics/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1646: astore 23
    //   1648: aload 22
    //   1650: astore 20
    //   1652: aload 22
    //   1654: astore 21
    //   1656: aload 22
    //   1658: invokevirtual 619	java/io/InputStream:reset	()V
    //   1661: aload 23
    //   1663: ifnonnull +21 -> 1684
    //   1666: aload 22
    //   1668: ifnull +8 -> 1676
    //   1671: aload 22
    //   1673: invokevirtual 637	java/io/InputStream:close	()V
    //   1676: ldc_w 897
    //   1679: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1682: iconst_0
    //   1683: ireturn
    //   1684: iload 10
    //   1686: i2f
    //   1687: fstore 6
    //   1689: aload 22
    //   1691: astore 20
    //   1693: aload 22
    //   1695: astore 21
    //   1697: aload 23
    //   1699: fload 6
    //   1701: invokestatic 787	com/tencent/mm/sdk/platformtools/d:b	(Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   1704: iload 9
    //   1706: getstatic 762	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   1709: new 97	java/lang/StringBuilder
    //   1712: dup
    //   1713: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1716: aload_0
    //   1717: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1720: aload_2
    //   1721: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1724: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1727: iconst_1
    //   1728: invokestatic 872	com/tencent/mm/sdk/platformtools/d:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   1731: iload 17
    //   1733: ifeq +215 -> 1948
    //   1736: iload 10
    //   1738: ifne +210 -> 1948
    //   1741: aload 22
    //   1743: astore 20
    //   1745: aload 22
    //   1747: astore 21
    //   1749: new 97	java/lang/StringBuilder
    //   1752: dup
    //   1753: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1756: aload_0
    //   1757: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1760: aload_2
    //   1761: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1764: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1767: invokestatic 187	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   1770: lstore 18
    //   1772: aload 22
    //   1774: astore 20
    //   1776: aload 22
    //   1778: astore 21
    //   1780: ldc 65
    //   1782: ldc_w 1040
    //   1785: iconst_3
    //   1786: anewarray 69	java/lang/Object
    //   1789: dup
    //   1790: iconst_0
    //   1791: iload 14
    //   1793: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1796: aastore
    //   1797: dup
    //   1798: iconst_1
    //   1799: lload 18
    //   1801: invokestatic 726	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1804: aastore
    //   1805: dup
    //   1806: iconst_2
    //   1807: iload 12
    //   1809: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1812: aastore
    //   1813: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1816: iload 14
    //   1818: i2l
    //   1819: lload 18
    //   1821: lsub
    //   1822: ldc2_w 1041
    //   1825: lmul
    //   1826: iload 12
    //   1828: iload 14
    //   1830: imul
    //   1831: i2l
    //   1832: lcmp
    //   1833: ifge +97 -> 1930
    //   1836: aload 22
    //   1838: astore 20
    //   1840: aload 22
    //   1842: astore 21
    //   1844: new 97	java/lang/StringBuilder
    //   1847: dup
    //   1848: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1851: aload_0
    //   1852: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1855: aload_2
    //   1856: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1859: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1862: invokestatic 536	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   1865: pop
    //   1866: aload 22
    //   1868: astore 20
    //   1870: aload 22
    //   1872: astore 21
    //   1874: aload_1
    //   1875: new 97	java/lang/StringBuilder
    //   1878: dup
    //   1879: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1882: aload_0
    //   1883: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1886: aload_2
    //   1887: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1890: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1893: invokestatic 527	com/tencent/mm/vfs/e:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   1896: lstore 18
    //   1898: lload 18
    //   1900: lconst_0
    //   1901: lcmp
    //   1902: iflt +23 -> 1925
    //   1905: iconst_1
    //   1906: istore_3
    //   1907: aload 22
    //   1909: ifnull +8 -> 1917
    //   1912: aload 22
    //   1914: invokevirtual 637	java/io/InputStream:close	()V
    //   1917: ldc_w 897
    //   1920: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1923: iload_3
    //   1924: ireturn
    //   1925: iconst_0
    //   1926: istore_3
    //   1927: goto -20 -> 1907
    //   1930: aload 22
    //   1932: ifnull +8 -> 1940
    //   1935: aload 22
    //   1937: invokevirtual 637	java/io/InputStream:close	()V
    //   1940: ldc_w 897
    //   1943: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1946: iconst_1
    //   1947: ireturn
    //   1948: aload 22
    //   1950: ifnull +8 -> 1958
    //   1953: aload 22
    //   1955: invokevirtual 637	java/io/InputStream:close	()V
    //   1958: ldc_w 897
    //   1961: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1964: iconst_1
    //   1965: ireturn
    //   1966: astore_0
    //   1967: aload 20
    //   1969: astore 21
    //   1971: ldc 65
    //   1973: aload_0
    //   1974: ldc_w 1044
    //   1977: aload_1
    //   1978: invokestatic 130	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1981: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1984: iconst_0
    //   1985: anewarray 69	java/lang/Object
    //   1988: invokestatic 555	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1991: aload 20
    //   1993: ifnull +8 -> 2001
    //   1996: aload 20
    //   1998: invokevirtual 637	java/io/InputStream:close	()V
    //   2001: ldc_w 897
    //   2004: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2007: iconst_0
    //   2008: ireturn
    //   2009: astore_0
    //   2010: aload 21
    //   2012: ifnull +8 -> 2020
    //   2015: aload 21
    //   2017: invokevirtual 637	java/io/InputStream:close	()V
    //   2020: ldc_w 897
    //   2023: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2026: aload_0
    //   2027: athrow
    //   2028: ldc 65
    //   2030: new 97	java/lang/StringBuilder
    //   2033: dup
    //   2034: ldc_w 1046
    //   2037: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2040: aload 20
    //   2042: getfield 631	android/graphics/BitmapFactory$Options:outWidth	I
    //   2045: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2048: ldc_w 1003
    //   2051: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2054: aload 20
    //   2056: getfield 634	android/graphics/BitmapFactory$Options:outHeight	I
    //   2059: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2062: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2065: invokestatic 141	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2068: aload 20
    //   2070: getfield 634	android/graphics/BitmapFactory$Options:outHeight	I
    //   2073: ifgt +9 -> 2082
    //   2076: aload 20
    //   2078: iconst_1
    //   2079: putfield 634	android/graphics/BitmapFactory$Options:outHeight	I
    //   2082: aload 20
    //   2084: getfield 631	android/graphics/BitmapFactory$Options:outWidth	I
    //   2087: ifgt +9 -> 2096
    //   2090: aload 20
    //   2092: iconst_1
    //   2093: putfield 631	android/graphics/BitmapFactory$Options:outWidth	I
    //   2096: aload 20
    //   2098: getfield 631	android/graphics/BitmapFactory$Options:outWidth	I
    //   2101: aload 20
    //   2103: getfield 634	android/graphics/BitmapFactory$Options:outHeight	I
    //   2106: if_icmple +131 -> 2237
    //   2109: aload 20
    //   2111: getfield 631	android/graphics/BitmapFactory$Options:outWidth	I
    //   2114: aload 20
    //   2116: getfield 634	android/graphics/BitmapFactory$Options:outHeight	I
    //   2119: idiv
    //   2120: istore 7
    //   2122: iload 7
    //   2124: istore 8
    //   2126: iload 7
    //   2128: ifne +6 -> 2134
    //   2131: iconst_1
    //   2132: istore 8
    //   2134: ldc_w 1017
    //   2137: iload 8
    //   2139: idiv
    //   2140: i2d
    //   2141: invokestatic 1049	java/lang/Math:sqrt	(D)D
    //   2144: d2i
    //   2145: istore 7
    //   2147: aload 20
    //   2149: getfield 631	android/graphics/BitmapFactory$Options:outWidth	I
    //   2152: aload 20
    //   2154: getfield 634	android/graphics/BitmapFactory$Options:outHeight	I
    //   2157: if_icmple +96 -> 2253
    //   2160: iload 7
    //   2162: iload 8
    //   2164: imul
    //   2165: istore 10
    //   2167: ldc 65
    //   2169: new 97	java/lang/StringBuilder
    //   2172: dup
    //   2173: ldc_w 1051
    //   2176: invokespecial 181	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2179: iload 10
    //   2181: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2184: ldc_w 1003
    //   2187: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2190: iload 7
    //   2192: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2195: ldc_w 1003
    //   2198: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2201: iload 8
    //   2203: invokevirtual 298	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2206: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2209: invokestatic 141	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2212: aload_1
    //   2213: iload 7
    //   2215: iload 10
    //   2217: getstatic 762	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   2220: iload 9
    //   2222: aload_0
    //   2223: aload_2
    //   2224: iload_3
    //   2225: invokestatic 1053	com/tencent/mm/plugin/sns/storage/s:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   2228: istore_3
    //   2229: ldc_w 897
    //   2232: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2235: iload_3
    //   2236: ireturn
    //   2237: aload 20
    //   2239: getfield 634	android/graphics/BitmapFactory$Options:outHeight	I
    //   2242: aload 20
    //   2244: getfield 631	android/graphics/BitmapFactory$Options:outWidth	I
    //   2247: idiv
    //   2248: istore 7
    //   2250: goto -128 -> 2122
    //   2253: iload 7
    //   2255: iload 8
    //   2257: imul
    //   2258: istore 11
    //   2260: iload 7
    //   2262: istore 10
    //   2264: iload 11
    //   2266: istore 7
    //   2268: goto -101 -> 2167
    //   2271: iload 14
    //   2273: iload 15
    //   2275: if_icmpge +72 -> 2347
    //   2278: iload 17
    //   2280: ifeq +67 -> 2347
    //   2283: iload 10
    //   2285: ifne +62 -> 2347
    //   2288: ldc 65
    //   2290: ldc_w 1055
    //   2293: iload 15
    //   2295: invokestatic 345	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   2298: invokevirtual 133	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2301: invokestatic 141	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2304: aload_1
    //   2305: new 97	java/lang/StringBuilder
    //   2308: dup
    //   2309: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2312: aload_0
    //   2313: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2316: aload_2
    //   2317: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2320: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2323: invokestatic 527	com/tencent/mm/vfs/e:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   2326: lconst_0
    //   2327: lcmp
    //   2328: iflt +11 -> 2339
    //   2331: ldc_w 897
    //   2334: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2337: iconst_1
    //   2338: ireturn
    //   2339: ldc_w 897
    //   2342: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2345: iconst_0
    //   2346: ireturn
    //   2347: aload 20
    //   2349: getfield 631	android/graphics/BitmapFactory$Options:outWidth	I
    //   2352: aload 20
    //   2354: getfield 634	android/graphics/BitmapFactory$Options:outHeight	I
    //   2357: if_icmple +163 -> 2520
    //   2360: aload 20
    //   2362: getfield 631	android/graphics/BitmapFactory$Options:outWidth	I
    //   2365: istore 11
    //   2367: aload 20
    //   2369: getfield 631	android/graphics/BitmapFactory$Options:outWidth	I
    //   2372: aload 20
    //   2374: getfield 634	android/graphics/BitmapFactory$Options:outHeight	I
    //   2377: if_icmpge +153 -> 2530
    //   2380: aload 20
    //   2382: getfield 631	android/graphics/BitmapFactory$Options:outWidth	I
    //   2385: istore 13
    //   2387: iload 8
    //   2389: ifle +10 -> 2399
    //   2392: iload 13
    //   2394: iload 8
    //   2396: if_icmple +15 -> 2411
    //   2399: iload 8
    //   2401: ifgt +393 -> 2794
    //   2404: iload 11
    //   2406: iload 7
    //   2408: if_icmpgt +386 -> 2794
    //   2411: ldc 65
    //   2413: ldc_w 1057
    //   2416: iconst_3
    //   2417: anewarray 69	java/lang/Object
    //   2420: dup
    //   2421: iconst_0
    //   2422: iload 14
    //   2424: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2427: aastore
    //   2428: dup
    //   2429: iconst_1
    //   2430: aload 20
    //   2432: getfield 631	android/graphics/BitmapFactory$Options:outWidth	I
    //   2435: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2438: aastore
    //   2439: dup
    //   2440: iconst_2
    //   2441: aload 20
    //   2443: getfield 634	android/graphics/BitmapFactory$Options:outHeight	I
    //   2446: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2449: aastore
    //   2450: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2453: aload_1
    //   2454: invokestatic 187	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   2457: ldc2_w 1058
    //   2460: lcmp
    //   2461: ifge +140 -> 2601
    //   2464: iload 17
    //   2466: ifeq +82 -> 2548
    //   2469: ldc 65
    //   2471: ldc_w 1061
    //   2474: iconst_1
    //   2475: anewarray 69	java/lang/Object
    //   2478: dup
    //   2479: iconst_0
    //   2480: aload_1
    //   2481: aastore
    //   2482: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2485: aload_1
    //   2486: new 97	java/lang/StringBuilder
    //   2489: dup
    //   2490: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2493: aload_0
    //   2494: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2497: aload_2
    //   2498: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2501: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2504: invokestatic 527	com/tencent/mm/vfs/e:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   2507: lconst_0
    //   2508: lcmp
    //   2509: iflt +31 -> 2540
    //   2512: ldc_w 897
    //   2515: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2518: iconst_1
    //   2519: ireturn
    //   2520: aload 20
    //   2522: getfield 634	android/graphics/BitmapFactory$Options:outHeight	I
    //   2525: istore 11
    //   2527: goto -160 -> 2367
    //   2530: aload 20
    //   2532: getfield 634	android/graphics/BitmapFactory$Options:outHeight	I
    //   2535: istore 13
    //   2537: goto -150 -> 2387
    //   2540: ldc_w 897
    //   2543: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2546: iconst_0
    //   2547: ireturn
    //   2548: aload 20
    //   2550: getfield 631	android/graphics/BitmapFactory$Options:outWidth	I
    //   2553: sipush 150
    //   2556: if_icmpge +45 -> 2601
    //   2559: aload 20
    //   2561: getfield 634	android/graphics/BitmapFactory$Options:outHeight	I
    //   2564: sipush 150
    //   2567: if_icmpge +34 -> 2601
    //   2570: aload_1
    //   2571: aload 20
    //   2573: getfield 634	android/graphics/BitmapFactory$Options:outHeight	I
    //   2576: aload 20
    //   2578: getfield 631	android/graphics/BitmapFactory$Options:outWidth	I
    //   2581: getstatic 757	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   2584: iload 9
    //   2586: aload_0
    //   2587: aload_2
    //   2588: iload_3
    //   2589: invokestatic 1053	com/tencent/mm/plugin/sns/storage/s:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   2592: istore_3
    //   2593: ldc_w 897
    //   2596: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2599: iload_3
    //   2600: ireturn
    //   2601: aload_1
    //   2602: aload 20
    //   2604: getfield 634	android/graphics/BitmapFactory$Options:outHeight	I
    //   2607: aload 20
    //   2609: getfield 631	android/graphics/BitmapFactory$Options:outWidth	I
    //   2612: getstatic 762	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   2615: iload 9
    //   2617: aload_0
    //   2618: aload_2
    //   2619: iload_3
    //   2620: invokestatic 1053	com/tencent/mm/plugin/sns/storage/s:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   2623: istore_3
    //   2624: iload 17
    //   2626: ifeq +160 -> 2786
    //   2629: iload 10
    //   2631: ifne +155 -> 2786
    //   2634: new 97	java/lang/StringBuilder
    //   2637: dup
    //   2638: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2641: aload_0
    //   2642: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2645: aload_2
    //   2646: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2649: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2652: invokestatic 187	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   2655: lstore 18
    //   2657: ldc 65
    //   2659: ldc_w 1040
    //   2662: iconst_3
    //   2663: anewarray 69	java/lang/Object
    //   2666: dup
    //   2667: iconst_0
    //   2668: iload 14
    //   2670: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2673: aastore
    //   2674: dup
    //   2675: iconst_1
    //   2676: lload 18
    //   2678: invokestatic 726	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2681: aastore
    //   2682: dup
    //   2683: iconst_2
    //   2684: iload 12
    //   2686: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2689: aastore
    //   2690: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2693: iload 14
    //   2695: i2l
    //   2696: lload 18
    //   2698: lsub
    //   2699: ldc2_w 1041
    //   2702: lmul
    //   2703: iload 12
    //   2705: iload 14
    //   2707: imul
    //   2708: i2l
    //   2709: lcmp
    //   2710: ifge +68 -> 2778
    //   2713: new 97	java/lang/StringBuilder
    //   2716: dup
    //   2717: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2720: aload_0
    //   2721: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2724: aload_2
    //   2725: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2728: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2731: invokestatic 536	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   2734: pop
    //   2735: aload_1
    //   2736: new 97	java/lang/StringBuilder
    //   2739: dup
    //   2740: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2743: aload_0
    //   2744: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2747: aload_2
    //   2748: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2751: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2754: invokestatic 527	com/tencent/mm/vfs/e:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   2757: lconst_0
    //   2758: lcmp
    //   2759: iflt +11 -> 2770
    //   2762: ldc_w 897
    //   2765: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2768: iconst_1
    //   2769: ireturn
    //   2770: ldc_w 897
    //   2773: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2776: iconst_0
    //   2777: ireturn
    //   2778: ldc_w 897
    //   2781: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2784: iload_3
    //   2785: ireturn
    //   2786: ldc_w 897
    //   2789: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2792: iload_3
    //   2793: ireturn
    //   2794: iload 8
    //   2796: ifle +173 -> 2969
    //   2799: aload_1
    //   2800: aload 20
    //   2802: getfield 631	android/graphics/BitmapFactory$Options:outWidth	I
    //   2805: aload 20
    //   2807: getfield 634	android/graphics/BitmapFactory$Options:outHeight	I
    //   2810: iload 8
    //   2812: getstatic 762	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   2815: iload 9
    //   2817: aload_0
    //   2818: aload_2
    //   2819: invokestatic 1063	com/tencent/mm/plugin/sns/storage/s:a	(Ljava/lang/String;IIILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;)Z
    //   2822: istore_3
    //   2823: iload 17
    //   2825: ifeq +203 -> 3028
    //   2828: iload 10
    //   2830: ifne +198 -> 3028
    //   2833: new 97	java/lang/StringBuilder
    //   2836: dup
    //   2837: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2840: aload_0
    //   2841: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2844: aload_2
    //   2845: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2848: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2851: invokestatic 187	com/tencent/mm/vfs/e:avI	(Ljava/lang/String;)J
    //   2854: lstore 18
    //   2856: ldc 65
    //   2858: ldc_w 1040
    //   2861: iconst_3
    //   2862: anewarray 69	java/lang/Object
    //   2865: dup
    //   2866: iconst_0
    //   2867: iload 14
    //   2869: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2872: aastore
    //   2873: dup
    //   2874: iconst_1
    //   2875: lload 18
    //   2877: invokestatic 726	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2880: aastore
    //   2881: dup
    //   2882: iconst_2
    //   2883: iload 12
    //   2885: invokestatic 512	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2888: aastore
    //   2889: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2892: iload 14
    //   2894: i2l
    //   2895: lload 18
    //   2897: lsub
    //   2898: ldc2_w 1041
    //   2901: lmul
    //   2902: iload 12
    //   2904: iload 14
    //   2906: imul
    //   2907: i2l
    //   2908: lcmp
    //   2909: ifge +119 -> 3028
    //   2912: new 97	java/lang/StringBuilder
    //   2915: dup
    //   2916: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2919: aload_0
    //   2920: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2923: aload_2
    //   2924: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2927: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2930: invokestatic 536	com/tencent/mm/vfs/e:deleteFile	(Ljava/lang/String;)Z
    //   2933: pop
    //   2934: aload_1
    //   2935: new 97	java/lang/StringBuilder
    //   2938: dup
    //   2939: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   2942: aload_0
    //   2943: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2946: aload_2
    //   2947: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2950: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2953: invokestatic 527	com/tencent/mm/vfs/e:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   2956: lconst_0
    //   2957: lcmp
    //   2958: iflt +62 -> 3020
    //   2961: ldc_w 897
    //   2964: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2967: iconst_1
    //   2968: ireturn
    //   2969: iload 11
    //   2971: i2d
    //   2972: dconst_1
    //   2973: dmul
    //   2974: iload 7
    //   2976: i2d
    //   2977: ddiv
    //   2978: dstore 4
    //   2980: aload 20
    //   2982: getfield 631	android/graphics/BitmapFactory$Options:outWidth	I
    //   2985: i2d
    //   2986: dload 4
    //   2988: ddiv
    //   2989: d2i
    //   2990: istore 7
    //   2992: aload_1
    //   2993: aload 20
    //   2995: getfield 634	android/graphics/BitmapFactory$Options:outHeight	I
    //   2998: i2d
    //   2999: dload 4
    //   3001: ddiv
    //   3002: d2i
    //   3003: iload 7
    //   3005: getstatic 762	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   3008: iload 9
    //   3010: aload_0
    //   3011: aload_2
    //   3012: iload_3
    //   3013: invokestatic 1053	com/tencent/mm/plugin/sns/storage/s:a	(Ljava/lang/String;IILandroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;Ljava/lang/String;Z)Z
    //   3016: istore_3
    //   3017: goto -194 -> 2823
    //   3020: ldc_w 897
    //   3023: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3026: iconst_0
    //   3027: ireturn
    //   3028: ldc_w 897
    //   3031: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   3034: iload_3
    //   3035: ireturn
    //   3036: astore_0
    //   3037: goto -1361 -> 1676
    //   3040: astore_0
    //   3041: goto -1124 -> 1917
    //   3044: astore_0
    //   3045: goto -1105 -> 1940
    //   3048: astore_0
    //   3049: goto -1091 -> 1958
    //   3052: astore_0
    //   3053: goto -1052 -> 2001
    //   3056: astore_1
    //   3057: goto -1037 -> 2020
    //   3060: astore 21
    //   3062: goto -2587 -> 475
    //   3065: astore 21
    //   3067: bipush 100
    //   3069: istore 7
    //   3071: goto -2807 -> 264
    //   3074: astore 21
    //   3076: goto -2812 -> 264
    //   3079: goto -2416 -> 663
    //   3082: goto -2527 -> 555
    //   3085: iload 8
    //   3087: istore 11
    //   3089: iload 7
    //   3091: istore 9
    //   3093: goto -2743 -> 350
    //   3096: goto -2787 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3099	0	paramString1	String
    //   0	3099	1	paramString2	String
    //   0	3099	2	paramString3	String
    //   0	3099	3	paramBoolean	boolean
    //   2978	22	4	d	double
    //   1687	13	6	f	float
    //   164	2926	7	i	int
    //   103	2983	8	j	int
    //   107	2985	9	k	int
    //   100	2729	10	m	int
    //   111	2977	11	n	int
    //   400	2507	12	i1	int
    //   465	2071	13	i2	int
    //   355	2552	14	i3	int
    //   590	1704	15	i4	int
    //   629	259	16	i5	int
    //   63	2761	17	bool	boolean
    //   1770	1126	18	l	long
    //   10	2984	20	localObject1	Object
    //   22	1416	21	localObject2	Object
    //   1509	15	21	localException1	Exception
    //   1564	452	21	localObject3	Object
    //   3060	1	21	localException2	Exception
    //   3065	1	21	localException3	Exception
    //   3074	1	21	localException4	Exception
    //   1577	377	22	localObject4	Object
    //   1573	125	23	localObject5	Object
    //   1558	84	24	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   671	677	1509	java/lang/Exception
    //   686	697	1509	java/lang/Exception
    //   1569	1575	1966	java/io/IOException
    //   1587	1595	1966	java/io/IOException
    //   1603	1614	1966	java/io/IOException
    //   1622	1630	1966	java/io/IOException
    //   1638	1648	1966	java/io/IOException
    //   1656	1661	1966	java/io/IOException
    //   1697	1731	1966	java/io/IOException
    //   1749	1772	1966	java/io/IOException
    //   1780	1816	1966	java/io/IOException
    //   1844	1866	1966	java/io/IOException
    //   1874	1898	1966	java/io/IOException
    //   1569	1575	2009	finally
    //   1587	1595	2009	finally
    //   1603	1614	2009	finally
    //   1622	1630	2009	finally
    //   1638	1648	2009	finally
    //   1656	1661	2009	finally
    //   1697	1731	2009	finally
    //   1749	1772	2009	finally
    //   1780	1816	2009	finally
    //   1844	1866	2009	finally
    //   1874	1898	2009	finally
    //   1971	1991	2009	finally
    //   1671	1676	3036	java/io/IOException
    //   1912	1917	3040	java/io/IOException
    //   1935	1940	3044	java/io/IOException
    //   1953	1958	3048	java/io/IOException
    //   1996	2001	3052	java/io/IOException
    //   2015	2020	3056	java/io/IOException
    //   412	423	3060	java/lang/Exception
    //   427	445	3060	java/lang/Exception
    //   449	467	3060	java/lang/Exception
    //   1151	1160	3060	java/lang/Exception
    //   1164	1175	3060	java/lang/Exception
    //   1179	1197	3060	java/lang/Exception
    //   1201	1219	3060	java/lang/Exception
    //   1234	1243	3060	java/lang/Exception
    //   1247	1258	3060	java/lang/Exception
    //   1262	1280	3060	java/lang/Exception
    //   1284	1302	3060	java/lang/Exception
    //   1317	1326	3060	java/lang/Exception
    //   1330	1341	3060	java/lang/Exception
    //   1345	1363	3060	java/lang/Exception
    //   1367	1385	3060	java/lang/Exception
    //   1400	1411	3060	java/lang/Exception
    //   1415	1433	3060	java/lang/Exception
    //   1437	1455	3060	java/lang/Exception
    //   117	141	3065	java/lang/Exception
    //   141	166	3065	java/lang/Exception
    //   994	1019	3065	java/lang/Exception
    //   1022	1047	3065	java/lang/Exception
    //   1050	1066	3065	java/lang/Exception
    //   1069	1095	3065	java/lang/Exception
    //   1098	1124	3065	java/lang/Exception
    //   1127	1144	3065	java/lang/Exception
    //   166	264	3074	java/lang/Exception
  }
  
  public static void fF(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37978);
    qZk = paramInt1;
    qYs = paramInt2;
    ab.i("MicroMsg.snsMediaStorage", "SCREEN %d %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(37978);
  }
  
  public static int getScreenWidth()
  {
    if (qZk > qYs) {
      return qYs;
    }
    return qZk;
  }
  
  public final int a(int paramInt, r paramr)
  {
    AppMethodBeat.i(37983);
    paramr = paramr.ctc();
    paramInt = this.fnw.update("SnsMedia", paramr, "local_id=?", new String[] { String.valueOf(paramInt) });
    AppMethodBeat.o(37983);
    return paramInt;
  }
  
  public final com.tencent.mm.plugin.sns.data.h a(com.tencent.mm.plugin.sns.data.h paramh, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(37989);
    r localr = new r();
    localr.createTime = ((int)bo.aox());
    localr.type = paramh.type;
    bcv localbcv = new bcv();
    localbcv.xrU = paramh.rbr;
    localbcv.xsp = paramh.rbq;
    localbcv.token = paramh.rbs;
    localbcv.xsy = paramh.rbt;
    localbcv.xsL = 0;
    localbcv.xsK = new bcp();
    localbcv.ePG = 0;
    localbcv.Desc = paramh.desc;
    ab.d("MicroMsg.snsMediaStorage", "upload.filterId " + paramh.filterId);
    localbcv.xso = paramh.filterId;
    localbcv.nkT = 2;
    localbcv.videoPath = paramString1;
    localbcv.xsO = paramString2;
    localbcv.cqq = paramh.rbu;
    for (;;)
    {
      try
      {
        localr.rDG = localbcv.toByteArray();
        localr.ctd();
        i = (int)this.fnw.a("SnsMedia", "local_id", localr.ctc());
        str1 = "Locall_path".concat(String.valueOf(i));
        ab.d("MicroMsg.snsMediaStorage", "insert localId ".concat(String.valueOf(i)));
        String str2 = i.ZB(str1);
        String str3 = i.ZC(str1);
        String str4 = i.ZA(str1);
        String str5 = i.ZD(str1);
        String str6 = abJ(str1);
        e.um(str6);
        e.C(paramString2, str6 + str2);
        e.C(paramString2, str6 + str3);
        e.C(paramString2, str6 + str4);
        e.C(paramString1, str6 + str5);
        localbcv.videoPath = (str6 + str5);
        localbcv.xsO = (str6 + str3);
        localbcv.cqq = paramh.rbu;
      }
      catch (Exception localException)
      {
        try
        {
          int i;
          String str1;
          localr.rDG = localbcv.toByteArray();
          localr.rDC = str1;
          if ((TextUtils.isEmpty(paramString3)) || (TextUtils.isEmpty(paramString4)))
          {
            a(i, localr);
            paramh = a(paramh, localbcv.xsO);
            paramh.cIp = i;
            AppMethodBeat.o(37989);
            return paramh;
            localException = localException;
            ab.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
          }
        }
        catch (Exception paramString2)
        {
          ab.e("MicroMsg.snsMediaStorage", "uploadInfo to byteArray error");
          continue;
          paramString2 = new bcp();
          paramString2.jKs = 1;
          paramString2.Url = paramString3;
          localbcv.xsK = paramString2;
          localbcv.nkT = 0;
          f.afP();
          localbcv.xsn = com.tencent.mm.al.a.sE(paramString1);
          if (!bo.isNullOrNil(paramString4))
          {
            paramString1 = new bcp();
            paramString1.jKs = 1;
            paramString1.Url = paramString4;
            localbcv.xsM.add(paramString1);
          }
        }
      }
      try
      {
        localr.rDG = localbcv.toByteArray();
        localr.cte();
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.snsMediaStorage", paramString1, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean a(String paramString, r paramr)
  {
    AppMethodBeat.i(37981);
    ab.d("MicroMsg.snsMediaStorage", "replace AlbumLikeList ".concat(String.valueOf(paramString)));
    Cursor localCursor = this.fnw.a("SnsMedia", null, "StrId=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (localCursor.moveToFirst())
    {
      localCursor.close();
      bool = a(paramr);
      AppMethodBeat.o(37981);
      return bool;
    }
    localCursor.close();
    boolean bool = b(paramString, paramr);
    AppMethodBeat.o(37981);
    return bool;
  }
  
  public final r abK(String paramString)
  {
    AppMethodBeat.i(37984);
    r localr = new r();
    paramString = this.fnw.a("SnsMedia", null, "StrId=?", new String[] { String.valueOf(paramString) }, null, null, null, 2);
    if (paramString.moveToFirst())
    {
      localr.convertFrom(paramString);
      paramString.close();
      AppMethodBeat.o(37984);
      return localr;
    }
    paramString.close();
    AppMethodBeat.o(37984);
    return null;
  }
  
  public final List<com.tencent.mm.plugin.sns.data.h> di(List<com.tencent.mm.plugin.sns.data.h> paramList)
  {
    AppMethodBeat.i(37986);
    LinkedList localLinkedList = new LinkedList();
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(37986);
      return null;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.mm.plugin.sns.data.h localh1 = (com.tencent.mm.plugin.sns.data.h)paramList.next();
      int i = a(localh1);
      if (i == -1)
      {
        AppMethodBeat.o(37986);
        return null;
      }
      com.tencent.mm.plugin.sns.data.h localh2 = new com.tencent.mm.plugin.sns.data.h(i, localh1.type);
      localh2.height = localh1.height;
      localh2.width = localh1.width;
      localh2.fileSize = localh1.fileSize;
      localLinkedList.add(localh2);
    }
    AppMethodBeat.o(37986);
    return localLinkedList;
  }
  
  public final r ma(long paramLong)
  {
    AppMethodBeat.i(37985);
    r localr = new r();
    Cursor localCursor = this.fnw.a("SnsMedia", null, "local_id=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    if (!localCursor.moveToFirst())
    {
      localCursor.close();
      AppMethodBeat.o(37985);
      return null;
    }
    localr.convertFrom(localCursor);
    localCursor.close();
    AppMethodBeat.o(37985);
    return localr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.s
 * JD-Core Version:    0.7.0.1
 */