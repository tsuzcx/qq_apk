package com.tencent.mm.plugin.recordvideo.e;

import android.graphics.Point;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.recordvideo.b.j;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.sight.base.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil;", "", "()V", "TAG", "", "checkConfigProviderParam", "", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "getVideoInfo", "Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "path", "VideoInfo", "plugin-recordvideo_release"})
public final class e
{
  public static final e Ife;
  
  static
  {
    AppMethodBeat.i(76222);
    Ife = new e();
    AppMethodBeat.o(76222);
  }
  
  public static a aWt(String paramString)
  {
    boolean bool = true;
    AppMethodBeat.i(76221);
    p.k(paramString, "path");
    b localb = f.aYg(paramString);
    if (localb == null)
    {
      AppMethodBeat.o(76221);
      return null;
    }
    if ((localb.height <= 0) || (localb.width <= 0)) {}
    try
    {
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      localMediaMetadataRetriever.setDataSource(paramString);
      localb.width = Util.getInt(localMediaMetadataRetriever.extractMetadata(18), 0);
      localb.height = Util.getInt(localMediaMetadataRetriever.extractMetadata(19), 0);
      localb.videoBitrate = Util.getInt(localMediaMetadataRetriever.extractMetadata(20), 0);
      localMediaMetadataRetriever.release();
      label116:
      int k = SightVideoJNI.getMp4RotateVFS(paramString);
      paramString = ar.au(MMApplicationContext.getContext());
      int j;
      int i;
      if ((k == 270) || (k == 90))
      {
        j = 1;
        if (j == 0) {
          break label254;
        }
        i = localb.height;
        label153:
        if (j == 0) {
          break label263;
        }
        j = localb.width;
        label163:
        if (Math.abs(i / j - paramString.x / paramString.y) > 0.01D) {
          break label272;
        }
      }
      for (;;)
      {
        paramString = new a(localb.width, localb.height, localb.videoDuration, k, localb.videoBitrate, localb.frameRate, bool, localb.Ifg, localb.Ifh, localb.Ifi);
        AppMethodBeat.o(76221);
        return paramString;
        j = 0;
        break;
        label254:
        i = localb.width;
        break label153;
        label263:
        j = localb.height;
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
  
  public static void j(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(76220);
    p.k(paramRecordConfigProvider, "configProvider");
    if (paramRecordConfigProvider.mfk == null) {
      switch (paramRecordConfigProvider.scene)
      {
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.MediaRecordParamUtil", "checkConfigProviderParam " + paramRecordConfigProvider.mfk);
      if (paramRecordConfigProvider.mfk != null) {
        break;
      }
      AppMethodBeat.o(76220);
      return;
      localObject = com.tencent.mm.modelcontrol.e.bkp();
      p.j(localObject, "SubCoreVideoControl.getCore()");
      paramRecordConfigProvider.mfk = ((com.tencent.mm.modelcontrol.e)localObject).bks();
    }
    Object localObject = j.HKg;
    localObject = j.aci(paramRecordConfigProvider.scene);
    if (localObject != null)
    {
      j localj = j.HKg;
      int i = j.br((JSONObject)localObject);
      localj = j.HKg;
      int j = j.bs((JSONObject)localObject);
      if ((i > 0) || (j > 0))
      {
        int k = paramRecordConfigProvider.mfk.width;
        int m = paramRecordConfigProvider.mfk.height;
        paramRecordConfigProvider.mfk.width = i;
        paramRecordConfigProvider.mfk.height = j;
        if (i <= 0) {
          paramRecordConfigProvider.mfk.width = (k * j / m);
        }
        if (j <= 0) {
          paramRecordConfigProvider.mfk.height = (m * i / k);
        }
        Log.i("MicroMsg.MediaRecordParamUtil", "force change video width:" + paramRecordConfigProvider.mfk.width + "  height:" + paramRecordConfigProvider.mfk.height + " ; config width:" + i + " height:" + j);
      }
      AppMethodBeat.o(76220);
      return;
    }
    AppMethodBeat.o(76220);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/util/MediaRecordParamUtil$VideoInfo;", "", "width", "", "height", "duration", "rotate", "videoBitrate", "fps", "matchScreenRatio", "", "useABA", "bitrateAdaptiveUp", "useMinMaxQP", "(IIIIIIZIII)V", "getBitrateAdaptiveUp", "()I", "setBitrateAdaptiveUp", "(I)V", "getDuration", "getFps", "getHeight", "getMatchScreenRatio", "()Z", "getRotate", "getUseABA", "getUseMinMaxQP", "getVideoBitrate", "getWidth", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "plugin-recordvideo_release"})
  public static final class a
  {
    public final boolean Iff;
    private final int Ifg;
    public int Ifh;
    private final int Ifi;
    public final int duration;
    public final int fSM;
    public final int fps;
    public final int height;
    public final int videoBitrate;
    public final int width;
    
    public a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean, int paramInt7, int paramInt8, int paramInt9)
    {
      this.width = paramInt1;
      this.height = paramInt2;
      this.duration = paramInt3;
      this.fSM = paramInt4;
      this.videoBitrate = paramInt5;
      this.fps = paramInt6;
      this.Iff = paramBoolean;
      this.Ifg = paramInt7;
      this.Ifh = paramInt8;
      this.Ifi = paramInt9;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.width != paramObject.width) || (this.height != paramObject.height) || (this.duration != paramObject.duration) || (this.fSM != paramObject.fSM) || (this.videoBitrate != paramObject.videoBitrate) || (this.fps != paramObject.fps) || (this.Iff != paramObject.Iff) || (this.Ifg != paramObject.Ifg) || (this.Ifh != paramObject.Ifh) || (this.Ifi != paramObject.Ifi)) {}
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
      String str = "VideoInfo(width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", rotate=" + this.fSM + ", videoBitrate=" + this.videoBitrate + ", fps=" + this.fps + ", matchScreenRatio=" + this.Iff + ", useABA=" + this.Ifg + ", bitrateAdaptiveUp=" + this.Ifh + ", useMinMaxQP=" + this.Ifi + ")";
      AppMethodBeat.o(76219);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.e
 * JD-Core Version:    0.7.0.1
 */