package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d
{
  private static Map<String, Long> toA;
  private static Map<String, Integer> toB;
  public final String TAG = "Traf.TrafficModel";
  private long tov;
  private double tow = 0.35D;
  private double tox = 3.0D;
  long toy = 0L;
  double toz = 0.0D;
  
  static
  {
    AppMethodBeat.i(114780);
    toA = new HashMap();
    toB = new HashMap();
    toA.put("null", Long.valueOf(4194304L));
    toA.put("Background", Long.valueOf(5242880L));
    toA.put("WebViewUI", Long.valueOf(83886080L));
    toA.put("WebviewMpUI", Long.valueOf(83886080L));
    toA.put("SnsTimeLineUI", Long.valueOf(15728640L));
    toA.put("SnsUserUI", Long.valueOf(15728640L));
    toA.put("AppBrandLaunchProxyUI", Long.valueOf(12582912L));
    toA.put("AppBrandUI", Long.valueOf(20971520L));
    toA.put("ChattingUI", Long.valueOf(12582912L));
    toA.put("SnsBrowseUI", Long.valueOf(12582912L));
    toA.put("SnsOnlineVideoActivity", Long.valueOf(12582912L));
    toA.put("EmojiStoreV2UI", Long.valueOf(16777216L));
    toA.put("EmojiStoreDetailUI", Long.valueOf(16777216L));
    toA.put("FTSSOSMoreWebViewUI", Long.valueOf(12582912L));
    toA.put("FTSWebViewUI", Long.valueOf(12582912L));
    toA.put("TopStoryHomeUI", Long.valueOf(16777216L));
    toA.put("TopStoryVideoStreamUI", Long.valueOf(25165824L));
    toA.put("GameDemoActivity1", Long.valueOf(12582912L));
    toA.put("ImageGalleryUI", Long.valueOf(12582912L));
    toA.put("SnsGalleryUI", Long.valueOf(12582912L));
    toA.put("VideoActivity", Long.valueOf(16777216L));
    toA.put("MultiTalkMainUI", Long.valueOf(16777216L));
    toA.put("FavoriteVideoPlayUI", Long.valueOf(16777216L));
    toA.put("AppAttachDownloadUI", Long.valueOf(20971520L));
    toA.put("LuggageGameWebViewUI", Long.valueOf(20971520L));
    toB.put("AppAttachDownloadUI", Integer.valueOf(2));
    toB.put("SendImgProxyUI", Integer.valueOf(2));
    AppMethodBeat.o(114780);
  }
  
  public d() {}
  
  public d(long paramLong)
  {
    this.tov = paramLong;
  }
  
  public final boolean a(List<TrafficClickFlowReceiver.c> paramList, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(114778);
    ab.i("Traf.TrafficModel", "realInterval:%d", new Object[] { Long.valueOf(paramLong3) });
    if (paramLong3 <= 5000L)
    {
      AppMethodBeat.o(114778);
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
      this.tov = (i * paramLong3 * 1048576L / 60000L);
      this.toy = 0L;
      l1 = 0L;
      j = 0;
      i = 0;
      if (i >= paramList.size()) {
        break label395;
      }
      l2 = Math.min(((TrafficClickFlowReceiver.c)paramList.get(i)).endTime - ((TrafficClickFlowReceiver.c)paramList.get(i)).startTime, paramLong2);
      l1 += l2;
      Object localObject2 = ((TrafficClickFlowReceiver.c)paramList.get(i)).tos;
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
      if (!toA.containsKey(localObject2)) {
        break label362;
      }
      d1 = this.toy;
      d2 = ((Long)toA.get(localObject2)).longValue();
    }
    for (this.toy = ((l2 / 1000.0D / 60.0D * d2 + d1));; this.toy = ((l2 / 1000.0D / 60.0D * 8388608.0D + d1)))
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
      d1 = this.toy;
    }
    label395:
    if (l1 < paramLong2) {
      this.toy += (paramLong2 - l1) / 1000L / 60L * 8388608L;
    }
    this.toy = Math.max(((Long)toA.get("null")).longValue() * (paramLong2 / 1000L / 60L), this.toy);
    if (j != 0)
    {
      paramLong2 = this.toy;
      this.toy = (((Integer)toB.get("AppAttachDownloadUI")).intValue() * paramLong2);
    }
    if (j != 0)
    {
      paramLong2 = this.toy;
      this.toy = (((Integer)toB.get("SendImgProxyUI")).intValue() * paramLong2);
    }
    paramLong2 = this.tov;
    long l1 = this.toy;
    this.toz = (paramLong1 / paramLong2 + paramLong1 / l1 * this.tow);
    if (this.toz < 0.0D) {
      this.toz = 0.0D;
    }
    double d1 = this.toz;
    ab.i("Traf.TrafficModel", "compute Traffic realTraffic:%d , standardTraffic:%d, predictionTraffic:%d, realInterval:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.tov), Long.valueOf(this.toy), Long.valueOf(paramLong3) });
    if (d1 > this.tox)
    {
      AppMethodBeat.o(114778);
      return true;
    }
    AppMethodBeat.o(114778);
    return false;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(114779);
    String str = "TrafficModel{standardTraffic=" + this.tov + ", preciseRatio=" + this.tow + ", threshold=" + this.tox + '}';
    AppMethodBeat.o(114779);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.d
 * JD-Core Version:    0.7.0.1
 */