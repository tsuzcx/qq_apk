package com.tencent.mm.plugin.trafficmonitor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d
{
  private static Map<String, Long> pKm = new HashMap();
  private static Map<String, Integer> pKn = new HashMap();
  public final String TAG = "Traf.TrafficModel";
  private long pKh;
  private double pKi = 0.35D;
  private double pKj = 3.0D;
  long pKk = 0L;
  double pKl = 0.0D;
  
  static
  {
    pKm.put("null", Long.valueOf(4194304L));
    pKm.put("Background", Long.valueOf(5242880L));
    pKm.put("WebViewUI", Long.valueOf(68157440L));
    pKm.put("SnsTimeLineUI", Long.valueOf(12582912L));
    pKm.put("SnsUserUI", Long.valueOf(12582912L));
    pKm.put("AppBrandLaunchProxyUI", Long.valueOf(12582912L));
    pKm.put("AppBrandUI", Long.valueOf(20971520L));
    pKm.put("ChattingUI", Long.valueOf(12582912L));
    pKm.put("SnsBrowseUI", Long.valueOf(12582912L));
    pKm.put("SnsOnlineVideoActivity", Long.valueOf(12582912L));
    pKm.put("EmojiStoreV2UI", Long.valueOf(16777216L));
    pKm.put("EmojiStoreDetailUI", Long.valueOf(16777216L));
    pKm.put("FTSSOSMoreWebViewUI", Long.valueOf(12582912L));
    pKm.put("FTSWebViewUI", Long.valueOf(12582912L));
    pKm.put("TopStoryHomeUI", Long.valueOf(16777216L));
    pKm.put("TopStoryVideoStreamUI", Long.valueOf(25165824L));
    pKm.put("GameDemoActivity1", Long.valueOf(12582912L));
    pKm.put("ImageGalleryUI", Long.valueOf(12582912L));
    pKm.put("SnsGalleryUI", Long.valueOf(12582912L));
    pKm.put("VideoActivity", Long.valueOf(16777216L));
    pKm.put("MultiTalkMainUI", Long.valueOf(16777216L));
    pKm.put("FavoriteVideoPlayUI", Long.valueOf(16777216L));
    pKm.put("AppAttachDownloadUI", Long.valueOf(20971520L));
    pKm.put("LuggageGameWebViewUI", Long.valueOf(20971520L));
    pKn.put("AppAttachDownloadUI", Integer.valueOf(2));
    pKn.put("SendImgProxyUI", Integer.valueOf(2));
  }
  
  public d() {}
  
  public d(long paramLong)
  {
    this.pKh = paramLong;
  }
  
  public final boolean b(List<TrafficClickFlowReceiver.c> paramList, long paramLong1, long paramLong2)
  {
    this.pKk = 0L;
    long l1 = 0L;
    int j = 0;
    int i = 0;
    if (i < paramList.size())
    {
      long l2 = Math.min(((TrafficClickFlowReceiver.c)paramList.get(i)).endTime - ((TrafficClickFlowReceiver.c)paramList.get(i)).startTime, paramLong2);
      l1 += l2;
      Object localObject2 = ((TrafficClickFlowReceiver.c)paramList.get(i)).pKe;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "null";
      }
      int k = j;
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
      double d1;
      double d2;
      if (pKm.containsKey(localObject2))
      {
        d1 = this.pKk;
        d2 = ((Long)pKm.get(localObject2)).longValue();
      }
      for (this.pKk = ((l2 / 1000.0D / 60.0D * d2 + d1));; this.pKk = ((l2 / 1000.0D / 60.0D * 8388608.0D + d1)))
      {
        i += 1;
        j = k;
        break;
        d1 = this.pKk;
      }
    }
    if (l1 < paramLong2) {
      this.pKk += (paramLong2 - l1) / 1000L / 60L * 8388608L;
    }
    this.pKk = Math.max(((Long)pKm.get("null")).longValue() * (paramLong2 / 1000L / 60L), this.pKk);
    if (j != 0)
    {
      paramLong2 = this.pKk;
      this.pKk = (((Integer)pKn.get("AppAttachDownloadUI")).intValue() * paramLong2);
    }
    if (j != 0)
    {
      paramLong2 = this.pKk;
      this.pKk = (((Integer)pKn.get("SendImgProxyUI")).intValue() * paramLong2);
    }
    paramLong2 = this.pKh;
    l1 = this.pKk;
    this.pKl = (paramLong1 / paramLong2 + paramLong1 / l1 * this.pKi);
    if (this.pKl < 0.0D) {
      this.pKl = 0.0D;
    }
    return this.pKl > this.pKj;
  }
  
  public final String toString()
  {
    return "TrafficModel{standardTraffic=" + this.pKh + ", preciseRatio=" + this.pKi + ", threshold=" + this.pKj + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.d
 * JD-Core Version:    0.7.0.1
 */