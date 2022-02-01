package com.tencent.mm.plugin.sight.base;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.StatFs;
import android.util.StringBuilderPrinter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ab;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

public final class f
{
  private static int KTG = 0;
  private static int KTH = 0;
  
  public static String a(String paramString, PInt paramPInt1, PInt paramPInt2, PInt paramPInt3, PInt paramPInt4, PInt paramPInt5)
  {
    AppMethodBeat.i(133606);
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      paramString = SightVideoJNI.getSimpleMp4InfoVFS(paramString);
      Log.i("MicroMsg.SightUtil", "get simple mp4 info %s", new Object[] { paramString });
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
        Log.printErrStackTrace("MicroMsg.SightUtil", paramString, "get media info error", new Object[0]);
      }
    }
  }
  
  public static Bitmap aK(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(133602);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(133602);
      return null;
    }
    Bitmap localBitmap = BitmapUtil.createVideoThumbnail(paramString, 1);
    if (localBitmap == null) {
      Log.e("MicroMsg.SightUtil", "create remux thumb bmp error, target path %s", new Object[] { paramString });
    }
    for (paramString = localBitmap;; paramString = BitmapUtil.extractThumbNail(localBitmap, paramInt2, paramInt1, true, true))
    {
      AppMethodBeat.o(133602);
      return paramString;
    }
  }
  
  public static String aMt(String paramString)
  {
    AppMethodBeat.i(133600);
    paramString = Util.nullAs(paramString, "") + ".thumb";
    AppMethodBeat.o(133600);
    return paramString;
  }
  
  public static String aMu(String paramString)
  {
    AppMethodBeat.i(133605);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("extInfo: \n".concat(String.valueOf(a(paramString, new PInt(), new PInt(), new PInt(), new PInt(), new PInt()))));
    localStringBuffer.append("size: " + Util.getSizeKB(com.tencent.mm.vfs.y.bEl(paramString)) + ":" + paramString + "\n");
    String str = SightVideoJNI.getMp4RecordInfo(paramString);
    if (!Util.isNullOrNil(str)) {
      localStringBuffer.append(str);
    }
    localStringBuffer.append("isH265:").append(com.tencent.mm.modelvideo.y.isH265Video(paramString));
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(133605);
    return paramString;
  }
  
  public static String aVV(String paramString)
  {
    AppMethodBeat.i(133601);
    paramString = Util.nullAs(paramString, "") + ".soundmp4";
    AppMethodBeat.o(133601);
    return paramString;
  }
  
  public static boolean aVW(String paramString)
  {
    AppMethodBeat.i(133603);
    if ((Util.isNullOrNil(paramString)) || (!com.tencent.mm.vfs.y.ZC(paramString)))
    {
      AppMethodBeat.o(133603);
      return false;
    }
    long l = Util.currentTicks();
    e locale = new e();
    int i = SightVideoJNI.isSightOkVFS(paramString, locale.PFq, locale.PFr, locale.PFs, locale.PFu, locale.PFt, locale.PFt.length);
    Log.d("MicroMsg.SightUtil", "ashu::check sight use %dms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
    if (i == 0)
    {
      AppMethodBeat.o(133603);
      return true;
    }
    AppMethodBeat.o(133603);
    return false;
  }
  
  public static b aVX(String paramString)
  {
    AppMethodBeat.i(133607);
    paramString = aVY(paramString);
    AppMethodBeat.o(133607);
    return paramString;
  }
  
  public static b aVY(String paramString)
  {
    AppMethodBeat.i(291930);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(291930);
      return null;
    }
    if (!com.tencent.mm.vfs.y.ZC(paramString))
    {
      AppMethodBeat.o(291930);
      return null;
    }
    b localb = new b();
    for (;;)
    {
      try
      {
        paramString = SightVideoJNI.getSimpleMp4InfoVFS(paramString, true);
        Log.d("MicroMsg.SightUtil", "get simple mp4 info %s", new Object[] { paramString });
        paramString = new JSONObject(paramString);
        localb.videoDuration = ((int)paramString.getDouble("videoDuration"));
        localb.width = paramString.getInt("videoWidth");
        localb.height = paramString.getInt("videoHeight");
        localb.frameRate = ((int)paramString.getDouble("videoFPS"));
        localb.videoBitrate = paramString.getInt("videoBitrate");
        localb.audioBitrate = paramString.getInt("audioBitrate");
        localb.audioChannel = paramString.getInt("audioChannel");
        localb.Obw = paramString.getInt("useABA");
        localb.Oby = paramString.getInt("useMinMaxQP");
        localb.Obx = paramString.getInt("bitrateAdaptiveUp");
        localb.audioSampleRate = paramString.getInt("aacSampleRate");
        localb.pixelFormat = paramString.optInt("pixelFormat", -1);
        if (paramString.getInt("hasH264") != 1) {
          continue;
        }
        bool = true;
        localb.PFe = bool;
        localb.hYK = paramString.optInt("rotate", -1);
        localb.PFf = paramString.optString("format_name", "");
        localb.PFg = paramString.optString("format_long_name", "");
      }
      catch (Exception paramString)
      {
        boolean bool;
        Log.e("MicroMsg.SightUtil", "get media info error %s", new Object[] { paramString.toString() });
        continue;
      }
      Log.i("MicroMsg.SightUtil", "get media %s", new Object[] { localb });
      AppMethodBeat.o(291930);
      return localb;
      bool = false;
    }
  }
  
  public static JSONObject aVZ(String paramString)
  {
    AppMethodBeat.i(291933);
    try
    {
      paramString = new JSONObject(SightVideoJNI.getVideoMetaData(paramString));
      AppMethodBeat.o(291933);
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace("MicroMsg.SightUtil", paramString, "getVideoMetaData error:%s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(291933);
    }
    return null;
  }
  
  public static boolean gYq()
  {
    AppMethodBeat.i(133599);
    if (af.lYa.lXM == 0)
    {
      AppMethodBeat.o(133599);
      return false;
    }
    boolean bool = com.tencent.mm.compatible.util.d.rb(14);
    AppMethodBeat.o(133599);
    return bool;
  }
  
  public static String gYr()
  {
    AppMethodBeat.i(133604);
    StringBuilder localStringBuilder = new StringBuilder(512);
    StringBuilderPrinter localStringBuilderPrinter = new StringBuilderPrinter(localStringBuilder);
    Object localObject2 = MMApplicationContext.getContext();
    localStringBuilderPrinter.println("#accinfo.revision=" + BuildInfo.REV);
    localStringBuilderPrinter.println("#accinfo.build=" + BuildInfo.TIME + ":" + BuildInfo.HOSTNAME + ":" + ChannelUtil.channelId);
    Object localObject3 = new StringBuilder("#accinfo.env=");
    Object localObject1;
    if (CrashReportFactory.foreground) {
      localObject1 = "f";
    }
    for (;;)
    {
      localStringBuilderPrinter.println((String)localObject1 + ":" + Thread.currentThread().getName() + ":" + CrashReportFactory.currentActivity);
      localStringBuilderPrinter.println("#aacinfo.device_brand=" + com.tencent.mm.protocal.d.Yxa);
      localStringBuilderPrinter.println("#aacinfo.device_model=" + com.tencent.mm.protocal.d.Yxb);
      localStringBuilderPrinter.println("#aacinfo.os_type=" + com.tencent.mm.protocal.d.Yxc);
      localStringBuilderPrinter.println("#aacinfo.os_name=" + com.tencent.mm.protocal.d.Yxd);
      localStringBuilderPrinter.println("#aacinfo.os_version=" + com.tencent.mm.protocal.d.Yxe);
      localStringBuilderPrinter.println("#aacinfo.device_name=" + com.tencent.mm.protocal.d.Yxf);
      try
      {
        localObject1 = Environment.getDataDirectory().getAbsolutePath();
        localObject3 = new StatFs((String)localObject1);
        StatFs localStatFs = new StatFs(com.tencent.mm.loader.i.b.bmt());
        localObject1 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[] { Integer.valueOf(((ActivityManager)((Context)localObject2).getSystemService("activity")).getMemoryClass()), localObject1, Integer.valueOf(((StatFs)localObject3).getBlockSize()), Integer.valueOf(((StatFs)localObject3).getBlockCount()), Integer.valueOf(((StatFs)localObject3).getAvailableBlocks()), com.tencent.mm.loader.i.b.bmt(), Integer.valueOf(localStatFs.getBlockSize()), Integer.valueOf(localStatFs.getBlockCount()), Integer.valueOf(localStatFs.getAvailableBlocks()) });
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
          Log.e("MicroMsg.SightUtil", "check data size failed :%s", new Object[] { localException.getMessage() });
          String str = "";
        }
      }
    }
  }
  
  public static int lc(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt1 % paramInt2 == 0) {
      return paramInt1;
    }
    for (;;)
    {
      paramInt1 = i;
      if (i % paramInt2 == 0) {
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.f
 * JD-Core Version:    0.7.0.1
 */