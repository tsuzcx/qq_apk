package com.tencent.mm.plugin.recordvideo.e;

import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil;", "", "()V", "TAG", "", "checkConfigProviderParam", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getVideoInfo", "Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "path", "VideoInfo", "plugin-recordvideo_release"})
public final class c
{
  public static final c vtL;
  
  static
  {
    AppMethodBeat.i(76222);
    vtL = new c();
    AppMethodBeat.o(76222);
  }
  
  public static a alZ(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(76221);
    k.h(paramString, "path");
    a locala = e.ano(paramString);
    if (locala == null)
    {
      AppMethodBeat.o(76221);
      return null;
    }
    if ((locala.height <= 0) || (locala.width <= 0)) {}
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      locala.width = bt.getInt(localMediaMetadataRetriever.extractMetadata(18), 0);
      locala.height = bt.getInt(localMediaMetadataRetriever.extractMetadata(19), 0);
      locala.videoBitrate = bt.getInt(localMediaMetadataRetriever.extractMetadata(20), 0);
      localMediaMetadataRetriever.release();
      label116:
      int k = SightVideoJNI.getMp4RotateVFS(paramString);
      paramString = ai.cf(aj.getContext());
      int j;
      int i;
      if ((k == 270) || (k == 90))
      {
        j = 1;
        if (j == 0) {
          break label254;
        }
        i = locala.height;
        label153:
        if (j == 0) {
          break label263;
        }
        j = locala.width;
        label163:
        if (Math.abs(i / j - paramString.x / paramString.y) > 0.01D) {
          break label272;
        }
      }
      for (;;)
      {
        paramString = new a(locala.width, locala.height, locala.videoDuration, k, locala.videoBitrate, locala.frameRate, bool, locala.vtN, locala.vtO, locala.vtP);
        AppMethodBeat.o(76221);
        return paramString;
        j = 0;
        break;
        label254:
        i = locala.width;
        break label153;
        label263:
        j = locala.height;
        break label163;
        label272:
        bool = false;
      }
    }
    catch (Exception localException)
    {
      break label116;
    }
  }
  
  public static void g(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76220);
    k.h(paramRecordConfigProvider, "configProvider");
    if (paramRecordConfigProvider.vhH == null) {
      switch (paramRecordConfigProvider.scene)
      {
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.MediaRecordParamUtil", "checkConfigProviderParam " + paramRecordConfigProvider.vhH);
      AppMethodBeat.o(76220);
      return;
      d locald = d.awT();
      k.g(locald, "SubCoreVideoControl.getCore()");
      paramRecordConfigProvider.vhH = locald.awW();
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "", "width", "", "height", "duration", "rotate", "videoBitrate", "fps", "matchScreenRatio", "", "useABA", "bitrateAdaptiveUp", "useMinMaxQP", "(IIIIIIZIII)V", "getBitrateAdaptiveUp", "()I", "getDuration", "getFps", "getHeight", "getMatchScreenRatio", "()Z", "getRotate", "getUseABA", "getUseMinMaxQP", "getVideoBitrate", "getWidth", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "plugin-recordvideo_release"})
  public static final class a
  {
    public final int duration;
    public final int dwp;
    public final int fps;
    public final int height;
    public final int videoBitrate;
    public final boolean vtM;
    private final int vtN;
    public final int vtO;
    private final int vtP;
    public final int width;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, int paramInt7, int paramInt8, int paramInt9)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.duration = paramInt3;
      this.dwp = paramInt4;
      this.videoBitrate = paramInt5;
      this.fps = paramInt6;
      this.vtM = paramBoolean;
      this.vtN = paramInt7;
      this.vtO = paramInt8;
      this.vtP = paramInt9;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.width != paramObject.width) || (this.height != paramObject.height) || (this.duration != paramObject.duration) || (this.dwp != paramObject.dwp) || (this.videoBitrate != paramObject.videoBitrate) || (this.fps != paramObject.fps) || (this.vtM != paramObject.vtM) || (this.vtN != paramObject.vtN) || (this.vtO != paramObject.vtO) || (this.vtP != paramObject.vtP)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(76219);
      String str = "VideoInfo(width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", rotate=" + this.dwp + ", videoBitrate=" + this.videoBitrate + ", fps=" + this.fps + ", matchScreenRatio=" + this.vtM + ", useABA=" + this.vtN + ", bitrateAdaptiveUp=" + this.vtO + ", useMinMaxQP=" + this.vtP + ")";
      AppMethodBeat.o(76219);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.c
 * JD-Core Version:    0.7.0.1
 */