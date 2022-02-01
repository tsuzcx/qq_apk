package com.tencent.mm.plugin.sight.base;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.StatFs;
import android.util.StringBuilderPrinter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.aa;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.vfs.o;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

public final class e
{
  private static int vYr = 0;
  private static int vYs = 0;
  
  public static String a(String paramString, PInt paramPInt1, PInt paramPInt2, PInt paramPInt3, PInt paramPInt4, PInt paramPInt5)
  {
    AppMethodBeat.i(133606);
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      paramString = SightVideoJNI.getSimpleMp4InfoVFS(paramString);
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SightUtil", "get simple mp4 info %s", new Object[] { paramString });
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
      paramString = localStringBuffer.toString();
      AppMethodBeat.o(133606);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.SightUtil", paramString, "get media info error", new Object[0]);
      }
    }
  }
  
  public static String arQ(String paramString)
  {
    AppMethodBeat.i(133600);
    paramString = bu.bI(paramString, "") + ".thumb";
    AppMethodBeat.o(133600);
    return paramString;
  }
  
  public static String arR(String paramString)
  {
    AppMethodBeat.i(133605);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("extInfo: \n".concat(String.valueOf(a(paramString, new PInt(), new PInt(), new PInt(), new PInt(), new PInt()))));
    localStringBuffer.append("size: " + bu.sL(o.aZR(paramString)) + ":" + paramString + "\n");
    String str = SightVideoJNI.getMp4RecordInfo(paramString);
    if (!bu.isNullOrNil(str)) {
      localStringBuffer.append(str);
    }
    localStringBuffer.append("isH265:").append(r.isH265Video(paramString));
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(133605);
    return paramString;
  }
  
  public static Bitmap aw(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133602);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(133602);
      return null;
    }
    Bitmap localBitmap = h.createVideoThumbnail(paramString, 1);
    if (localBitmap == null) {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SightUtil", "create remux thumb bmp error, target path %s", new Object[] { paramString });
    }
    for (paramString = localBitmap;; paramString = h.a(localBitmap, paramInt2, paramInt1, true, true))
    {
      AppMethodBeat.o(133602);
      return paramString;
    }
  }
  
  public static String ayL(String paramString)
  {
    AppMethodBeat.i(133601);
    paramString = bu.bI(paramString, "") + ".soundmp4";
    AppMethodBeat.o(133601);
    return paramString;
  }
  
  public static boolean ayM(String paramString)
  {
    AppMethodBeat.i(133603);
    if ((bu.isNullOrNil(paramString)) || (!o.fB(paramString)))
    {
      AppMethodBeat.o(133603);
      return false;
    }
    long l = bu.HQ();
    d locald = new d();
    int i = SightVideoJNI.isSightOkVFS(paramString, locald.zhs, locald.zht, locald.zhu, locald.zhw, locald.zhv, locald.zhv.length);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SightUtil", "ashu::check sight use %dms", new Object[] { Long.valueOf(bu.aO(l)) });
    if (i == 0)
    {
      AppMethodBeat.o(133603);
      return true;
    }
    AppMethodBeat.o(133603);
    return false;
  }
  
  public static a ayN(String paramString)
  {
    AppMethodBeat.i(133607);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(133607);
      return null;
    }
    if (!o.fB(paramString))
    {
      AppMethodBeat.o(133607);
      return null;
    }
    a locala = new a();
    try
    {
      paramString = SightVideoJNI.getSimpleMp4InfoVFS(paramString);
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.SightUtil", "get simple mp4 info %s", new Object[] { paramString });
      paramString = new JSONObject(paramString);
      locala.videoDuration = ((int)paramString.getDouble("videoDuration"));
      locala.width = paramString.getInt("videoWidth");
      locala.height = paramString.getInt("videoHeight");
      locala.frameRate = ((int)paramString.getDouble("videoFPS"));
      locala.videoBitrate = paramString.getInt("videoBitrate");
      locala.audioBitrate = paramString.getInt("audioBitrate");
      locala.audioChannel = paramString.getInt("audioChannel");
      locala.yhq = paramString.getInt("useABA");
      locala.yhs = paramString.getInt("useMinMaxQP");
      locala.yhr = paramString.getInt("bitrateAdaptiveUp");
      locala.audioSampleRate = paramString.getInt("aacSampleRate");
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.SightUtil", "get media %s", new Object[] { locala });
      AppMethodBeat.o(133607);
      return locala;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SightUtil", "get media info error %s", new Object[] { paramString.toString() });
      }
    }
  }
  
  public static boolean dTv()
  {
    AppMethodBeat.i(133599);
    if (com.tencent.mm.compatible.deviceinfo.ae.geO.geG == 0)
    {
      AppMethodBeat.o(133599);
      return false;
    }
    boolean bool = com.tencent.mm.compatible.util.d.lA(14);
    AppMethodBeat.o(133599);
    return bool;
  }
  
  public static String dTw()
  {
    AppMethodBeat.i(133604);
    StringBuilder localStringBuilder = new StringBuilder(512);
    StringBuilderPrinter localStringBuilderPrinter = new StringBuilderPrinter(localStringBuilder);
    Object localObject2 = ak.getContext();
    localStringBuilderPrinter.println("#accinfo.revision=" + j.REV);
    localStringBuilderPrinter.println("#accinfo.build=" + j.TIME + ":" + j.HOSTNAME + ":" + k.cSM);
    Object localObject3 = new StringBuilder("#accinfo.env=");
    Object localObject1;
    if (com.tencent.mm.sdk.a.b.foreground) {
      localObject1 = "f";
    }
    for (;;)
    {
      localStringBuilderPrinter.println((String)localObject1 + ":" + Thread.currentThread().getName() + ":" + com.tencent.mm.sdk.a.b.IvL);
      localStringBuilderPrinter.println("#aacinfo.device_brand=" + com.tencent.mm.protocal.d.FFB);
      localStringBuilderPrinter.println("#aacinfo.device_model=" + com.tencent.mm.protocal.d.FFC);
      localStringBuilderPrinter.println("#aacinfo.os_type=" + com.tencent.mm.protocal.d.FFD);
      localStringBuilderPrinter.println("#aacinfo.os_name=" + com.tencent.mm.protocal.d.FFE);
      localStringBuilderPrinter.println("#aacinfo.os_version=" + com.tencent.mm.protocal.d.FFF);
      localStringBuilderPrinter.println("#aacinfo.device_name=" + com.tencent.mm.protocal.d.DEVICE_NAME);
      try
      {
        localObject1 = Environment.getDataDirectory().getAbsolutePath();
        localObject3 = new StatFs((String)localObject1);
        StatFs localStatFs = new StatFs(com.tencent.mm.loader.j.b.asd());
        localObject1 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[] { Integer.valueOf(((ActivityManager)((Context)localObject2).getSystemService("activity")).getMemoryClass()), localObject1, Integer.valueOf(((StatFs)localObject3).getBlockSize()), Integer.valueOf(((StatFs)localObject3).getBlockCount()), Integer.valueOf(((StatFs)localObject3).getAvailableBlocks()), com.tencent.mm.loader.j.b.asd(), Integer.valueOf(localStatFs.getBlockSize()), Integer.valueOf(localStatFs.getBlockCount()), Integer.valueOf(localStatFs.getAvailableBlocks()) });
        localStringBuilderPrinter.println("#accinfo.data=".concat(String.valueOf(localObject1)));
        localObject1 = new Date();
        localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
        localStringBuilderPrinter.println("#accinfo.crashTime=" + ((SimpleDateFormat)localObject2).format((Date)localObject1));
        localStringBuilderPrinter.println("#crashContent=");
        localObject1 = localStringBuilder.toString();
        AppMethodBeat.o(133604);
        return localObject1;
        localObject1 = "b";
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.SightUtil", "check data size failed :%s", new Object[] { localException.getMessage() });
          String str = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.e
 * JD-Core Version:    0.7.0.1
 */