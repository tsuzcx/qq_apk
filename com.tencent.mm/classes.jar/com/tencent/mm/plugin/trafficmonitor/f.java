package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f
{
  private static Map<String, Long> Ajf;
  private static Map<String, Integer> Ajg;
  private long Aja;
  private double Ajb = 0.35D;
  private double Ajc = 3.0D;
  long Ajd = 0L;
  double Aje = 0.0D;
  public final String TAG = "Traf.TrafficModel";
  
  static
  {
    AppMethodBeat.i(123922);
    Ajf = new HashMap();
    Ajg = new HashMap();
    Ajf.put("null", Long.valueOf(4194304L));
    Ajf.put("Background", Long.valueOf(5242880L));
    Ajf.put("WebViewUI", Long.valueOf(83886080L));
    Ajf.put("WebviewMpUI", Long.valueOf(83886080L));
    Ajf.put("SnsTimeLineUI", Long.valueOf(15728640L));
    Ajf.put("SnsUserUI", Long.valueOf(15728640L));
    Ajf.put("AppBrandLaunchProxyUI", Long.valueOf(12582912L));
    Ajf.put("AppBrandUI", Long.valueOf(20971520L));
    Ajf.put("ChattingUI", Long.valueOf(12582912L));
    Ajf.put("SnsBrowseUI", Long.valueOf(12582912L));
    Ajf.put("SnsOnlineVideoActivity", Long.valueOf(12582912L));
    Ajf.put("EmojiStoreV2UI", Long.valueOf(16777216L));
    Ajf.put("EmojiStoreDetailUI", Long.valueOf(16777216L));
    Ajf.put("FTSSOSMoreWebViewUI", Long.valueOf(12582912L));
    Ajf.put("FTSWebViewUI", Long.valueOf(12582912L));
    Ajf.put("TopStoryHomeUI", Long.valueOf(16777216L));
    Ajf.put("TopStoryVideoStreamUI", Long.valueOf(25165824L));
    Ajf.put("GameDemoActivity1", Long.valueOf(12582912L));
    Ajf.put("ImageGalleryUI", Long.valueOf(12582912L));
    Ajf.put("SnsGalleryUI", Long.valueOf(12582912L));
    Ajf.put("VideoActivity", Long.valueOf(16777216L));
    Ajf.put("MultiTalkMainUI", Long.valueOf(16777216L));
    Ajf.put("FavoriteVideoPlayUI", Long.valueOf(16777216L));
    Ajf.put("AppAttachDownloadUI", Long.valueOf(20971520L));
    Ajf.put("LuggageGameWebViewUI", Long.valueOf(20971520L));
    Ajg.put("AppAttachDownloadUI", Integer.valueOf(2));
    Ajg.put("SendImgProxyUI", Integer.valueOf(2));
    AppMethodBeat.o(123922);
  }
  
  public f() {}
  
  public f(long paramLong)
  {
    this.Aja = paramLong;
  }
  
  public final boolean a(List<TrafficClickFlowReceiver.c> paramList, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(123920);
    ac.i("Traf.TrafficModel", "realInterval:%d", new Object[] { Long.valueOf(paramLong3) });
    if (paramLong3 <= 5000L)
    {
      AppMethodBeat.o(123920);
      return false;
    }
    int i;
    int j;
    label85:
    long l2;
    int k;
    double d2;
    if (paramLong3 <= 300000L)
    {
      i = 100;
      this.Aja = (i * paramLong3 * 1048576L / 60000L);
      this.Ajd = 0L;
      l1 = 0L;
      j = 0;
      i = 0;
      if (i >= paramList.size()) {
        break label395;
      }
      l2 = Math.min(((TrafficClickFlowReceiver.c)paramList.get(i)).endTime - ((TrafficClickFlowReceiver.c)paramList.get(i)).startTime, paramLong2);
      l1 += l2;
      Object localObject2 = ((TrafficClickFlowReceiver.c)paramList.get(i)).AiX;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "null";
      }
      k = j;
      if (((String)localObject1).equals("AppAttachDownloadUI"))
      {
        k = j;
        if (j == 0) {
          k = 1;
        }
      }
      ((String)localObject1).equals("SendImgProxyUI");
      localObject2 = localObject1;
      if (((String)localObject1).contains("_")) {
        localObject2 = ((String)localObject1).substring(0, ((String)localObject1).indexOf("_"));
      }
      if (!Ajf.containsKey(localObject2)) {
        break label362;
      }
      d1 = this.Ajd;
      d2 = ((Long)Ajf.get(localObject2)).longValue();
    }
    for (this.Ajd = ((l2 / 1000.0D / 60.0D * d2 + d1));; this.Ajd = ((l2 / 1000.0D / 60.0D * 8388608.0D + d1)))
    {
      i += 1;
      j = k;
      break label85;
      if ((paramLong3 > 300000L) && (paramLong3 <= 600000L))
      {
        i = 90;
        break;
      }
      if ((paramLong3 > 600000L) && (paramLong3 <= 1800000L))
      {
        i = 60;
        break;
      }
      i = 50;
      break;
      label362:
      d1 = this.Ajd;
    }
    label395:
    if (l1 < paramLong2) {
      this.Ajd += (paramLong2 - l1) / 1000L / 60L * 8388608L;
    }
    this.Ajd = Math.max(((Long)Ajf.get("null")).longValue() * (paramLong2 / 1000L / 60L), this.Ajd);
    if (j != 0)
    {
      paramLong2 = this.Ajd;
      this.Ajd = (((Integer)Ajg.get("AppAttachDownloadUI")).intValue() * paramLong2);
    }
    if (j != 0)
    {
      paramLong2 = this.Ajd;
      this.Ajd = (((Integer)Ajg.get("SendImgProxyUI")).intValue() * paramLong2);
    }
    paramLong2 = this.Aja;
    long l1 = this.Ajd;
    this.Aje = (paramLong1 / paramLong2 + paramLong1 / l1 * this.Ajb);
    if (this.Aje < 0.0D) {
      this.Aje = 0.0D;
    }
    double d1 = this.Aje;
    ac.i("Traf.TrafficModel", "compute Traffic realTraffic:%d , standardTraffic:%d, predictionTraffic:%d, realInterval:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.Aja), Long.valueOf(this.Ajd), Long.valueOf(paramLong3) });
    if (d1 > this.Ajc)
    {
      AppMethodBeat.o(123920);
      return true;
    }
    AppMethodBeat.o(123920);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(123921);
    String str = "TrafficModel{standardTraffic=" + this.Aja + ", preciseRatio=" + this.Ajb + ", threshold=" + this.Ajc + '}';
    AppMethodBeat.o(123921);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.f
 * JD-Core Version:    0.7.0.1
 */