package com.tencent.mm.plugin.sight.base;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Environment;
import android.os.StatFs;
import android.util.StringBuilderPrinter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.y;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.g;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

public final class d
{
  private static int oFB = 0;
  private static int oFC = 0;
  
  public static String TW(String paramString)
  {
    AppMethodBeat.i(117305);
    paramString = bo.bf(paramString, "") + ".thumb";
    AppMethodBeat.o(117305);
    return paramString;
  }
  
  public static String TX(String paramString)
  {
    AppMethodBeat.i(117310);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("extInfo: \n".concat(String.valueOf(a(paramString, new PInt(), new PInt(), new PInt(), new PInt(), new PInt()))));
    localStringBuffer.append("size: " + bo.hk(com.tencent.mm.vfs.e.avI(paramString)) + ":" + paramString + "\n");
    String str = SightVideoJNI.getMp4RecordInfo(paramString);
    if (!bo.isNullOrNil(str)) {
      localStringBuffer.append(str);
    }
    localStringBuffer.append("isH265:").append(r.va(paramString));
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(117310);
    return paramString;
  }
  
  public static String Zm(String paramString)
  {
    AppMethodBeat.i(117306);
    paramString = bo.bf(paramString, "") + ".soundmp4";
    AppMethodBeat.o(117306);
    return paramString;
  }
  
  public static boolean Zn(String paramString)
  {
    AppMethodBeat.i(117308);
    if ((bo.isNullOrNil(paramString)) || (!com.tencent.mm.vfs.e.cN(paramString)))
    {
      AppMethodBeat.o(117308);
      return false;
    }
    long l = bo.yB();
    c localc = new c();
    int i = SightVideoJNI.isSightOk(paramString, localc.qSx, localc.qSy, localc.qSz, localc.qSB, localc.qSA, localc.qSA.length);
    ab.d("MicroMsg.SightUtil", "ashu::check sight use %dms", new Object[] { Long.valueOf(bo.av(l)) });
    if (i == 0)
    {
      AppMethodBeat.o(117308);
      return true;
    }
    AppMethodBeat.o(117308);
    return false;
  }
  
  public static a Zo(String paramString)
  {
    AppMethodBeat.i(117312);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117312);
      return null;
    }
    if (!com.tencent.mm.vfs.e.cN(paramString))
    {
      AppMethodBeat.o(117312);
      return null;
    }
    a locala = new a();
    try
    {
      paramString = SightVideoJNI.getSimpleMp4Info(paramString);
      ab.d("MicroMsg.SightUtil", "get simple mp4 info %s", new Object[] { paramString });
      paramString = new JSONObject(paramString);
      locala.eVA = ((int)paramString.getDouble("videoDuration"));
      locala.width = paramString.getInt("videoWidth");
      locala.height = paramString.getInt("videoHeight");
      locala.eRw = ((int)paramString.getDouble("videoFPS"));
      locala.videoBitrate = paramString.getInt("videoBitrate");
      locala.fzT = paramString.getInt("audioBitrate");
      locala.qSh = paramString.getInt("audioChannel");
      locala.qSi = paramString.getInt("useABA");
      locala.qSj = paramString.getInt("useMinMaxQP");
      locala.qSk = paramString.getInt("bitrateAdaptiveUp");
      locala.qSl = paramString.getInt("bitrateAdaptiveDown");
      locala.qSm = paramString.getInt("resolutionAdjust");
      ab.i("MicroMsg.SightUtil", "get media %s", new Object[] { locala });
      AppMethodBeat.o(117312);
      return locala;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.e("MicroMsg.SightUtil", "get media info error %s", new Object[] { paramString.toString() });
      }
    }
  }
  
  public static String a(String paramString, PInt paramPInt1, PInt paramPInt2, PInt paramPInt3, PInt paramPInt4, PInt paramPInt5)
  {
    AppMethodBeat.i(117311);
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      paramString = SightVideoJNI.getSimpleMp4Info(paramString);
      ab.d("MicroMsg.SightUtil", "get simple mp4 info %s", new Object[] { paramString });
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
      AppMethodBeat.o(117311);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.SightUtil", paramString, "get media info error", new Object[0]);
      }
    }
  }
  
  public static Bitmap as(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117307);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(117307);
      return null;
    }
    Bitmap localBitmap = ThumbnailUtils.createVideoThumbnail(paramString, 1);
    if (localBitmap == null) {
      ab.e("MicroMsg.SightUtil", "create remux thumb bmp error, target path %s", new Object[] { paramString });
    }
    for (paramString = localBitmap;; paramString = com.tencent.mm.sdk.platformtools.d.a(localBitmap, paramInt2, paramInt1, true, true))
    {
      AppMethodBeat.o(117307);
      return paramString;
    }
  }
  
  public static boolean cmv()
  {
    AppMethodBeat.i(117304);
    if (ac.erw.ero == 0)
    {
      AppMethodBeat.o(117304);
      return false;
    }
    boolean bool = com.tencent.mm.compatible.util.d.fv(14);
    AppMethodBeat.o(117304);
    return bool;
  }
  
  public static String cmw()
  {
    AppMethodBeat.i(117309);
    StringBuilder localStringBuilder = new StringBuilder(512);
    StringBuilderPrinter localStringBuilderPrinter = new StringBuilderPrinter(localStringBuilder);
    Object localObject2 = ah.getContext();
    localStringBuilderPrinter.println("#accinfo.revision=" + f.REV);
    localStringBuilderPrinter.println("#accinfo.build=" + f.TIME + ":" + f.HOSTNAME + ":" + g.bWu);
    Object localObject3 = new StringBuilder("#accinfo.env=");
    Object localObject1;
    if (b.foreground) {
      localObject1 = "f";
    }
    for (;;)
    {
      localStringBuilderPrinter.println((String)localObject1 + ":" + Thread.currentThread().getName() + ":" + b.ymf);
      localStringBuilderPrinter.println("#aacinfo.device_brand=" + com.tencent.mm.protocal.d.whB);
      localStringBuilderPrinter.println("#aacinfo.device_model=" + com.tencent.mm.protocal.d.whC);
      localStringBuilderPrinter.println("#aacinfo.os_type=" + com.tencent.mm.protocal.d.whD);
      localStringBuilderPrinter.println("#aacinfo.os_name=" + com.tencent.mm.protocal.d.whE);
      localStringBuilderPrinter.println("#aacinfo.os_version=" + com.tencent.mm.protocal.d.whF);
      localStringBuilderPrinter.println("#aacinfo.device_name=" + com.tencent.mm.protocal.d.DEVICE_NAME);
      try
      {
        localObject1 = Environment.getDataDirectory().getAbsolutePath();
        localObject3 = new StatFs((String)localObject1);
        StatFs localStatFs = new StatFs(com.tencent.mm.compatible.util.e.eQx);
        localObject1 = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[] { Integer.valueOf(((ActivityManager)((Context)localObject2).getSystemService("activity")).getMemoryClass()), localObject1, Integer.valueOf(((StatFs)localObject3).getBlockSize()), Integer.valueOf(((StatFs)localObject3).getBlockCount()), Integer.valueOf(((StatFs)localObject3).getAvailableBlocks()), com.tencent.mm.compatible.util.e.eQx, Integer.valueOf(localStatFs.getBlockSize()), Integer.valueOf(localStatFs.getBlockCount()), Integer.valueOf(localStatFs.getAvailableBlocks()) });
        localStringBuilderPrinter.println("#accinfo.data=".concat(String.valueOf(localObject1)));
        localObject1 = new Date();
        localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault());
        localStringBuilderPrinter.println("#accinfo.crashTime=" + ((SimpleDateFormat)localObject2).format((Date)localObject1));
        localStringBuilderPrinter.println("#crashContent=");
        localObject1 = localStringBuilder.toString();
        AppMethodBeat.o(117309);
        return localObject1;
        localObject1 = "b";
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.SightUtil", "check data size failed :%s", new Object[] { localException.getMessage() });
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