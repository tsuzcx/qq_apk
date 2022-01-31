package com.tencent.mm.plugin.sight.base;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Environment;
import android.os.StatFs;
import android.util.StringBuilderPrinter;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.j;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

public final class d
{
  private static int mfc = 0;
  private static int mfd = 0;
  
  public static String Ik(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str = a(paramString, new PInt(), new PInt(), new PInt(), new PInt(), new PInt());
    localStringBuffer.append("extInfo: \n" + str);
    localStringBuffer.append("size: " + bk.cm(com.tencent.mm.vfs.e.aeQ(paramString)) + ":" + paramString + "\n");
    str = SightVideoJNI.getMp4RecordInfo(paramString);
    if (!bk.bl(str)) {
      localStringBuffer.append(str);
    }
    localStringBuffer.append("isH265:").append(r.nN(paramString));
    return localStringBuffer.toString();
  }
  
  public static String ME(String paramString)
  {
    return bk.aM(paramString, "") + ".thumb";
  }
  
  public static String MF(String paramString)
  {
    return bk.aM(paramString, "") + ".soundmp4";
  }
  
  public static boolean MG(String paramString)
  {
    if ((bk.bl(paramString)) || (!com.tencent.mm.vfs.e.bK(paramString))) {
      return false;
    }
    long l = bk.UZ();
    c localc = new c();
    int i = SightVideoJNI.isSightOk(paramString, localc.oei, localc.oej, localc.oek, localc.oem, localc.oel, localc.oel.length);
    y.d("MicroMsg.SightUtil", "ashu::check sight use %dms", new Object[] { Long.valueOf(bk.cp(l)) });
    return i == 0;
  }
  
  public static a MH(String paramString)
  {
    if (bk.bl(paramString)) {}
    while (!com.tencent.mm.vfs.e.bK(paramString)) {
      return null;
    }
    a locala = new a();
    try
    {
      paramString = SightVideoJNI.getSimpleMp4Info(paramString);
      y.d("MicroMsg.SightUtil", "get simple mp4 info %s", new Object[] { paramString });
      paramString = new JSONObject(paramString);
      locala.jlu = ((int)paramString.getDouble("videoDuration"));
      locala.width = paramString.getInt("videoWidth");
      locala.height = paramString.getInt("videoHeight");
      locala.eIM = ((int)paramString.getDouble("videoFPS"));
      locala.videoBitrate = paramString.getInt("videoBitrate");
      locala.ejM = paramString.getInt("audioBitrate");
      locala.odX = paramString.getInt("audioChannel");
      y.i("MicroMsg.SightUtil", "get media %s", new Object[] { locala });
      return locala;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.e("MicroMsg.SightUtil", "get media info error %s", new Object[] { paramString.toString() });
      }
    }
  }
  
  public static String a(String paramString, PInt paramPInt1, PInt paramPInt2, PInt paramPInt3, PInt paramPInt4, PInt paramPInt5)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      paramString = SightVideoJNI.getSimpleMp4Info(paramString);
      y.d("MicroMsg.SightUtil", "get simple mp4 info %s", new Object[] { paramString });
      paramString = new JSONObject(paramString);
      paramPInt1.value = ((int)paramString.getDouble("videoDuration"));
      paramPInt2.value = paramString.getInt("videoWidth");
      paramPInt3.value = paramString.getInt("videoHeight");
      paramPInt4.value = ((int)paramString.getDouble("videoFPS"));
      paramPInt5.value = paramString.getInt("videoBitrate");
      localStringBuffer.append("videoBitrate: ").append(paramPInt5.value).append("\n");
      localStringBuffer.append("videoWidth,videoHeight: ").append(paramPInt2.value).append("*").append(paramPInt3.value);
      localStringBuffer.append(" ").append(String.format("%.4f", new Object[] { Double.valueOf(paramPInt2.value * 1.0D / paramPInt3.value) })).append("\n");
      localStringBuffer.append("videoDuration: ").append(paramPInt1.value).append("\n");
      localStringBuffer.append("videoFPS: ").append(paramPInt4.value).append("\n");
      return localStringBuffer.toString();
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.SightUtil", paramString, "get media info error", new Object[0]);
      }
    }
  }
  
  public static Bitmap ab(String paramString, int paramInt1, int paramInt2)
  {
    if (bk.bl(paramString)) {
      return null;
    }
    Bitmap localBitmap = ThumbnailUtils.createVideoThumbnail(paramString, 1);
    if (localBitmap == null)
    {
      y.e("MicroMsg.SightUtil", "create remux thumb bmp error, target path %s", new Object[] { paramString });
      return localBitmap;
    }
    return com.tencent.mm.sdk.platformtools.c.a(localBitmap, paramInt2, paramInt1, true, true);
  }
  
  public static String bAU()
  {
    Object localObject = g.DP().dKt + "video/";
    int i = mfc;
    mfc = i + 1;
    localObject = new com.tencent.mm.vfs.b(String.format("%s/tempvideo%s.mp4", new Object[] { localObject, Integer.valueOf(i) }));
    if (((com.tencent.mm.vfs.b)localObject).exists()) {
      ((com.tencent.mm.vfs.b)localObject).delete();
    }
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(j.n(((com.tencent.mm.vfs.b)localObject).cLr()) + ".remux");
    if (localb.exists()) {
      localb.delete();
    }
    localb = new com.tencent.mm.vfs.b(((com.tencent.mm.vfs.b)localObject).cLs() + ".thumb");
    if (localb.exists()) {
      localb.delete();
    }
    localb = new com.tencent.mm.vfs.b(((com.tencent.mm.vfs.b)localObject).cLs() + ".soundmp4");
    if (localb.exists()) {
      localb.delete();
    }
    i = mfc;
    g.DS().O(new d.1(i - 3));
    return j.n(((com.tencent.mm.vfs.b)localObject).cLr());
  }
  
  public static boolean bAV()
  {
    if (q.dyf.dyO == 0) {
      return false;
    }
    return com.tencent.mm.compatible.util.d.gF(14);
  }
  
  public static String bAW()
  {
    StringBuilder localStringBuilder = new StringBuilder(512);
    StringBuilderPrinter localStringBuilderPrinter = new StringBuilderPrinter(localStringBuilder);
    Object localObject2 = ae.getContext();
    localStringBuilderPrinter.println("#accinfo.revision=" + com.tencent.mm.sdk.platformtools.d.REV);
    localStringBuilderPrinter.println("#accinfo.build=" + com.tencent.mm.sdk.platformtools.d.TIME + ":" + com.tencent.mm.sdk.platformtools.d.HOSTNAME + ":" + com.tencent.mm.sdk.platformtools.e.bvj);
    Object localObject3 = new StringBuilder("#accinfo.env=");
    Object localObject1;
    if (com.tencent.mm.sdk.a.b.foreground) {
      localObject1 = "f";
    }
    for (;;)
    {
      localStringBuilderPrinter.println((String)localObject1 + ":" + Thread.currentThread().getName() + ":" + com.tencent.mm.sdk.a.b.udL);
      localStringBuilderPrinter.println("#aacinfo.device_brand=" + com.tencent.mm.protocal.d.soU);
      localStringBuilderPrinter.println("#aacinfo.device_model=" + com.tencent.mm.protocal.d.soV);
      localStringBuilderPrinter.println("#aacinfo.os_type=" + com.tencent.mm.protocal.d.soW);
      localStringBuilderPrinter.println("#aacinfo.os_name=" + com.tencent.mm.protocal.d.soX);
      localStringBuilderPrinter.println("#aacinfo.os_version=" + com.tencent.mm.protocal.d.soY);
      localStringBuilderPrinter.println("#aacinfo.device_name=" + com.tencent.mm.protocal.d.DEVICE_NAME);
      try
      {
        localObject1 = Environment.getDataDirectory().getAbsolutePath();
        localObject3 = new StatFs((String)localObject1);
        StatFs localStatFs = new StatFs(com.tencent.mm.compatible.util.e.bkF);
        localObject1 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[] { Integer.valueOf(((ActivityManager)((Context)localObject2).getSystemService("activity")).getMemoryClass()), localObject1, Integer.valueOf(((StatFs)localObject3).getBlockSize()), Integer.valueOf(((StatFs)localObject3).getBlockCount()), Integer.valueOf(((StatFs)localObject3).getAvailableBlocks()), com.tencent.mm.compatible.util.e.bkF, Integer.valueOf(localStatFs.getBlockSize()), Integer.valueOf(localStatFs.getBlockCount()), Integer.valueOf(localStatFs.getAvailableBlocks()) });
        localStringBuilderPrinter.println("#accinfo.data=" + (String)localObject1);
        localObject1 = new Date();
        localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
        localStringBuilderPrinter.println("#accinfo.crashTime=" + ((SimpleDateFormat)localObject2).format((Date)localObject1));
        localStringBuilderPrinter.println("#crashContent=");
        return localStringBuilder.toString();
        localObject1 = "b";
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.SightUtil", "check data size failed :%s", new Object[] { localException.getMessage() });
          String str = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.d
 * JD-Core Version:    0.7.0.1
 */