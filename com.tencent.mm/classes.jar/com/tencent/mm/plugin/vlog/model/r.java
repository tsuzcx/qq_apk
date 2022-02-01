package com.tencent.mm.plugin.vlog.model;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.h.d;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;
import d.n.n;
import java.io.IOException;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker;", "", "()V", "getVideoFrameRate", "", "path", "", "getVideoInfo", "Lcom/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker$VideoInfo;", "getVideoInfoH264", "getVideoInfoH265", "isH265Video", "", "VideoInfo", "plugin-vlog_release"})
public final class r
{
  public static final r LqC;
  
  static
  {
    AppMethodBeat.i(200856);
    LqC = new r();
    AppMethodBeat.o(200856);
  }
  
  private static float IG(String paramString)
  {
    k = 0;
    int m = 0;
    AppMethodBeat.i(200855);
    localMediaExtractor = new MediaExtractor();
    for (;;)
    {
      try
      {
        localMediaExtractor.setDataSource(paramString);
        int n = localMediaExtractor.getTrackCount();
        j = 0;
        i = m;
        if (j < n)
        {
          paramString = localMediaExtractor.getTrackFormat(j);
          String str = paramString.getString("mime");
          k.g(str, "mime");
          if ((!n.mA(str, "video/")) || (!paramString.containsKey("frame-rate"))) {
            continue;
          }
          i = paramString.getInteger("frame-rate");
        }
        localMediaExtractor.release();
      }
      catch (IOException paramString)
      {
        int j;
        float f;
        localMediaExtractor.release();
        int i = k;
        continue;
      }
      finally
      {
        localMediaExtractor.release();
        AppMethodBeat.o(200855);
      }
      f = i;
      AppMethodBeat.o(200855);
      return f * 1.0F;
      j += 1;
    }
  }
  
  public static a aVP(String paramString)
  {
    AppMethodBeat.i(200852);
    k.h(paramString, "path");
    if (i.eK(paramString))
    {
      k.h(paramString, "path");
      if (SightVideoJNI.isH265VideoVFS(paramString))
      {
        paramString = aVQ(paramString);
        AppMethodBeat.o(200852);
        return paramString;
      }
      paramString = aVR(paramString);
      AppMethodBeat.o(200852);
      return paramString;
    }
    AppMethodBeat.o(200852);
    return null;
  }
  
  private static a aVQ(String paramString)
  {
    AppMethodBeat.i(200853);
    d locald = new d();
    for (;;)
    {
      try
      {
        locald.setDataSource(paramString);
        int i = bt.getInt(locald.extractMetadata(18), 0);
        int j = bt.getInt(locald.extractMetadata(19), 0);
        long l = bt.getLong(locald.extractMetadata(9), 0L);
        int k = SightVideoJNI.getMp4RotateVFS(paramString);
        if (Build.VERSION.SDK_INT >= 23)
        {
          f1 = bt.getFloat(locald.extractMetadata(25), 0.0F);
          float f2 = f1;
          if (f1 == 0.0F) {
            f2 = IG(paramString);
          }
          paramString = new a(i, j, f2, l, bt.getInt(locald.extractMetadata(20), 0), k, true);
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        return null;
      }
      finally
      {
        locald.release();
        AppMethodBeat.o(200853);
      }
      float f1 = 0.0F;
    }
  }
  
  private static a aVR(String paramString)
  {
    AppMethodBeat.i(200854);
    try
    {
      a locala = e.ano(paramString);
      if (locala != null)
      {
        int i = SightVideoJNI.getMp4RotateVFS(paramString);
        paramString = new a(locala.width, locala.height, locala.frameRate, locala.videoDuration, locala.videoBitrate, i);
        AppMethodBeat.o(200854);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(200854);
    }
    return null;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker$VideoInfo;", "", "width", "", "height", "fps", "", "duration", "", "bitrate", "rotate", "isH265", "", "(IIFJIIZ)V", "getBitrate", "()I", "getDuration", "()J", "getFps", "()F", "getHeight", "()Z", "getRotate", "getWidth", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "plugin-vlog_release"})
  public static final class a
  {
    private final int bitrate;
    public final float coh;
    public final long duration;
    final int dwp;
    public final int height;
    public final boolean tHz;
    public final int width;
    
    public a(int paramInt1, int paramInt2, float paramFloat, long paramLong, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.coh = paramFloat;
      this.duration = paramLong;
      this.bitrate = paramInt3;
      this.dwp = paramInt4;
      this.tHz = paramBoolean;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(200851);
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.width != paramObject.width) || (this.height != paramObject.height) || (Float.compare(this.coh, paramObject.coh) != 0) || (this.duration != paramObject.duration) || (this.bitrate != paramObject.bitrate) || (this.dwp != paramObject.dwp) || (this.tHz != paramObject.tHz)) {}
        }
      }
      else
      {
        AppMethodBeat.o(200851);
        return true;
      }
      AppMethodBeat.o(200851);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(200849);
      String str = "VideoInfo(width=" + this.width + ", height=" + this.height + ", fps=" + this.coh + ", duration=" + this.duration + ", bitrate=" + this.bitrate + ", rotate=" + this.dwp + ", isH265=" + this.tHz + ")";
      AppMethodBeat.o(200849);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.r
 * JD-Core Version:    0.7.0.1
 */