package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f
{
  private static Map<String, Long> GsV;
  private static Map<String, Integer> GsW;
  private long GsQ;
  private double GsR = 0.35D;
  private double GsS = 3.0D;
  long GsT = 0L;
  double GsU = 0.0D;
  public final String TAG = "Traf.TrafficModel";
  
  static
  {
    AppMethodBeat.i(123922);
    GsV = new HashMap();
    GsW = new HashMap();
    GsV.put("null", Long.valueOf(4194304L));
    GsV.put("Background", Long.valueOf(5242880L));
    GsV.put("WebViewUI", Long.valueOf(83886080L));
    GsV.put("WebviewMpUI", Long.valueOf(83886080L));
    GsV.put("SnsTimeLineUI", Long.valueOf(15728640L));
    GsV.put("SnsUserUI", Long.valueOf(15728640L));
    GsV.put("AppBrandLaunchProxyUI", Long.valueOf(12582912L));
    GsV.put("AppBrandUI", Long.valueOf(20971520L));
    GsV.put("ChattingUI", Long.valueOf(12582912L));
    GsV.put("SnsBrowseUI", Long.valueOf(12582912L));
    GsV.put("SnsOnlineVideoActivity", Long.valueOf(12582912L));
    GsV.put("EmojiStoreV2UI", Long.valueOf(16777216L));
    GsV.put("EmojiStoreDetailUI", Long.valueOf(16777216L));
    GsV.put("FTSSOSMoreWebViewUI", Long.valueOf(12582912L));
    GsV.put("FTSWebViewUI", Long.valueOf(12582912L));
    GsV.put("TopStoryHomeUI", Long.valueOf(16777216L));
    GsV.put("TopStoryVideoStreamUI", Long.valueOf(25165824L));
    GsV.put("GameDemoActivity1", Long.valueOf(12582912L));
    GsV.put("ImageGalleryUI", Long.valueOf(12582912L));
    GsV.put("SnsGalleryUI", Long.valueOf(12582912L));
    GsV.put("VideoActivity", Long.valueOf(16777216L));
    GsV.put("MultiTalkMainUI", Long.valueOf(16777216L));
    GsV.put("FavoriteVideoPlayUI", Long.valueOf(16777216L));
    GsV.put("AppAttachDownloadUI", Long.valueOf(20971520L));
    GsV.put("LuggageGameWebViewUI", Long.valueOf(20971520L));
    GsW.put("AppAttachDownloadUI", Integer.valueOf(2));
    GsW.put("SendImgProxyUI", Integer.valueOf(2));
    AppMethodBeat.o(123922);
  }
  
  public f() {}
  
  public f(long paramLong)
  {
    this.GsQ = paramLong;
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
    int k;
    double d2;
    if (paramLong3 <= 300000L)
    {
      i = 100;
      this.GsQ = (i * paramLong3 * 1048576L / 60000L);
      this.GsT = 0L;
      l1 = 0L;
      j = 0;
      i = 0;
      if (i >= paramList.size()) {
        break label395;
      }
      l2 = Math.min(((TrafficClickFlowReceiver.c)paramList.get(i)).endTime - ((TrafficClickFlowReceiver.c)paramList.get(i)).startTime, paramLong2);
      l1 += l2;
      Object localObject2 = ((TrafficClickFlowReceiver.c)paramList.get(i)).GsN;
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
      if (!GsV.containsKey(localObject2)) {
        break label362;
      }
      d1 = this.GsT;
      d2 = ((Long)GsV.get(localObject2)).longValue();
    }
    for (this.GsT = ((l2 / 1000.0D / 60.0D * d2 + d1));; this.GsT = ((l2 / 1000.0D / 60.0D * 8388608.0D + d1)))
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
      d1 = this.GsT;
    }
    label395:
    if (l1 < paramLong2) {
      this.GsT += (paramLong2 - l1) / 1000L / 60L * 8388608L;
    }
    this.GsT = Math.max(((Long)GsV.get("null")).longValue() * (paramLong2 / 1000L / 60L), this.GsT);
    if (j != 0)
    {
      paramLong2 = this.GsT;
      this.GsT = (((Integer)GsW.get("AppAttachDownloadUI")).intValue() * paramLong2);
    }
    if (j != 0)
    {
      paramLong2 = this.GsT;
      this.GsT = (((Integer)GsW.get("SendImgProxyUI")).intValue() * paramLong2);
    }
    paramLong2 = this.GsQ;
    long l1 = this.GsT;
    this.GsU = (paramLong1 / paramLong2 + paramLong1 / l1 * this.GsR);
    if (this.GsU < 0.0D) {
      this.GsU = 0.0D;
    }
    double d1 = this.GsU;
    Log.i("Traf.TrafficModel", "compute Traffic realTraffic:%d , standardTraffic:%d, predictionTraffic:%d, realInterval:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.GsQ), Long.valueOf(this.GsT), Long.valueOf(paramLong3) });
    if (d1 > this.GsS)
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
    String str = "TrafficModel{standardTraffic=" + this.GsQ + ", preciseRatio=" + this.GsR + ", threshold=" + this.GsS + '}';
    AppMethodBeat.o(123921);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.f
 * JD-Core Version:    0.7.0.1
 */