package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g
{
  private static final Map<String, Long> TSs;
  private static final Map<String, Integer> TSt;
  public final String TAG = "Traf.TrafficModel";
  private long TSn;
  private final double TSo = 0.35D;
  private double TSp = 5.0D;
  long TSq = 0L;
  double TSr = 0.0D;
  
  static
  {
    AppMethodBeat.i(123922);
    TSs = new HashMap();
    TSt = new HashMap();
    TSs.put("null", Long.valueOf(2097152L));
    TSs.put("Background", Long.valueOf(2097152L));
    TSs.put("WebViewUI", Long.valueOf(83886080L));
    TSs.put("WebviewMpUI", Long.valueOf(83886080L));
    TSs.put("SnsTimeLineUI", Long.valueOf(20971520L));
    TSs.put("SnsUserUI", Long.valueOf(20971520L));
    TSs.put("AppBrandLaunchProxyUI", Long.valueOf(15728640L));
    TSs.put("AppBrandUI", Long.valueOf(31457280L));
    TSs.put("ChattingUI", Long.valueOf(15728640L));
    TSs.put("SnsBrowseUI", Long.valueOf(15728640L));
    TSs.put("SnsOnlineVideoActivity", Long.valueOf(15728640L));
    TSs.put("EmojiStoreV2UI", Long.valueOf(20971520L));
    TSs.put("EmojiStoreDetailUI", Long.valueOf(20971520L));
    TSs.put("FTSSOSMoreWebViewUI", Long.valueOf(20971520L));
    TSs.put("FTSWebViewUI", Long.valueOf(20971520L));
    TSs.put("TopStoryHomeUI", Long.valueOf(20971520L));
    TSs.put("TopStoryVideoStreamUI", Long.valueOf(31457280L));
    TSs.put("GameDemoActivity1", Long.valueOf(20971520L));
    TSs.put("ImageGalleryUI", Long.valueOf(20971520L));
    TSs.put("SnsGalleryUI", Long.valueOf(20971520L));
    TSs.put("VideoActivity", Long.valueOf(31457280L));
    TSs.put("MultiTalkMainUI", Long.valueOf(31457280L));
    TSs.put("FavoriteVideoPlayUI", Long.valueOf(20971520L));
    TSs.put("AppAttachDownloadUI", Long.valueOf(31457280L));
    TSs.put("LuggageGameWebViewUI", Long.valueOf(31457280L));
    TSs.put("NearbyUI", Long.valueOf(62914560L));
    TSt.put("AppAttachDownloadUI", Integer.valueOf(2));
    TSt.put("SendImgProxyUI", Integer.valueOf(2));
    AppMethodBeat.o(123922);
  }
  
  public g() {}
  
  public g(long paramLong)
  {
    this.TSn = paramLong;
  }
  
  public final boolean a(List<TrafficClickFlowReceiver.c> paramList, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(123920);
    Log.i("Traf.TrafficModel", "realInterval:%d", new Object[] { Long.valueOf(paramLong3) });
    if (paramLong3 <= 5000L)
    {
      AppMethodBeat.o(123920);
      return false;
    }
    int i;
    int j;
    label85:
    long l2;
    String str1;
    label164:
    String str2;
    if (paramLong3 <= 300000L)
    {
      i = 100;
      this.TSn = (i * paramLong3 * 1048576L / 60000L);
      this.TSq = 0L;
      l1 = 0L;
      j = 0;
      i = 0;
      if (i >= paramList.size()) {
        break label410;
      }
      l2 = Math.min(((TrafficClickFlowReceiver.c)paramList.get(i)).endTime - ((TrafficClickFlowReceiver.c)paramList.get(i)).startTime, paramLong2);
      l1 += l2;
      str1 = ((TrafficClickFlowReceiver.c)paramList.get(i)).TSi;
      if (str1 != null) {
        break label302;
      }
      str1 = "null";
      str2 = str1;
      if (str1.contains("_")) {
        str2 = str1.substring(0, str1.indexOf("_"));
      }
      if (!TSs.containsKey(str2)) {
        break label334;
      }
      d1 = this.TSq;
      double d2 = ((Long)TSs.get(str2)).longValue();
      this.TSq = ((l2 / 1000.0D / 60.0D * d2 + d1));
    }
    for (;;)
    {
      i += 1;
      break label85;
      if (paramLong3 <= 600000L)
      {
        i = 90;
        break;
      }
      if (paramLong3 <= 1800000L)
      {
        i = 60;
        break;
      }
      i = 50;
      break;
      label302:
      if ((str1.equals("AppAttachDownloadUI")) && (j == 0))
      {
        j = 1;
        break label164;
      }
      str1.equals("SendImgProxyUI");
      break label164;
      label334:
      if (str2.contains("Finder"))
      {
        d1 = this.TSq;
        this.TSq = ((l2 / 1000.0D / 60.0D * 83886080.0D + d1));
      }
      else
      {
        d1 = this.TSq;
        this.TSq = ((l2 / 1000.0D / 60.0D * 8388608.0D + d1));
      }
    }
    label410:
    if (l1 < paramLong2) {
      this.TSq += (paramLong2 - l1) / 1000L / 60L * 8388608L;
    }
    this.TSq = Math.max(((Long)TSs.get("null")).longValue() * (paramLong2 / 1000L / 60L), this.TSq);
    if (j != 0)
    {
      paramLong2 = this.TSq;
      this.TSq = (((Integer)TSt.get("AppAttachDownloadUI")).intValue() * paramLong2);
    }
    if (j != 0)
    {
      paramLong2 = this.TSq;
      this.TSq = (((Integer)TSt.get("SendImgProxyUI")).intValue() * paramLong2);
    }
    paramLong2 = this.TSn;
    long l1 = this.TSq;
    this.TSr = (paramLong1 / paramLong2 + paramLong1 / l1 * 0.35D);
    if (this.TSr < 0.0D) {
      this.TSr = 0.0D;
    }
    double d1 = this.TSr;
    Log.i("Traf.TrafficModel", "compute Traffic realTraffic:%d , standardTraffic:%d, predictionTraffic:%d, realInterval:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.TSn), Long.valueOf(this.TSq), Long.valueOf(paramLong3) });
    if (d1 > this.TSp)
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
    String str = "TrafficModel{standardTraffic=" + this.TSn + ", preciseRatio=0.35, threshold=" + this.TSp + '}';
    AppMethodBeat.o(123921);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.g
 * JD-Core Version:    0.7.0.1
 */