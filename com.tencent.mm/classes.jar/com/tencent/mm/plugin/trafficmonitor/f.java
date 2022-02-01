package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f
{
  private static Map<String, Long> BSp;
  private static Map<String, Integer> BSq;
  private long BSk;
  private double BSl = 0.35D;
  private double BSm = 3.0D;
  long BSn = 0L;
  double BSo = 0.0D;
  public final String TAG = "Traf.TrafficModel";
  
  static
  {
    AppMethodBeat.i(123922);
    BSp = new HashMap();
    BSq = new HashMap();
    BSp.put("null", Long.valueOf(4194304L));
    BSp.put("Background", Long.valueOf(5242880L));
    BSp.put("WebViewUI", Long.valueOf(83886080L));
    BSp.put("WebviewMpUI", Long.valueOf(83886080L));
    BSp.put("SnsTimeLineUI", Long.valueOf(15728640L));
    BSp.put("SnsUserUI", Long.valueOf(15728640L));
    BSp.put("AppBrandLaunchProxyUI", Long.valueOf(12582912L));
    BSp.put("AppBrandUI", Long.valueOf(20971520L));
    BSp.put("ChattingUI", Long.valueOf(12582912L));
    BSp.put("SnsBrowseUI", Long.valueOf(12582912L));
    BSp.put("SnsOnlineVideoActivity", Long.valueOf(12582912L));
    BSp.put("EmojiStoreV2UI", Long.valueOf(16777216L));
    BSp.put("EmojiStoreDetailUI", Long.valueOf(16777216L));
    BSp.put("FTSSOSMoreWebViewUI", Long.valueOf(12582912L));
    BSp.put("FTSWebViewUI", Long.valueOf(12582912L));
    BSp.put("TopStoryHomeUI", Long.valueOf(16777216L));
    BSp.put("TopStoryVideoStreamUI", Long.valueOf(25165824L));
    BSp.put("GameDemoActivity1", Long.valueOf(12582912L));
    BSp.put("ImageGalleryUI", Long.valueOf(12582912L));
    BSp.put("SnsGalleryUI", Long.valueOf(12582912L));
    BSp.put("VideoActivity", Long.valueOf(16777216L));
    BSp.put("MultiTalkMainUI", Long.valueOf(16777216L));
    BSp.put("FavoriteVideoPlayUI", Long.valueOf(16777216L));
    BSp.put("AppAttachDownloadUI", Long.valueOf(20971520L));
    BSp.put("LuggageGameWebViewUI", Long.valueOf(20971520L));
    BSq.put("AppAttachDownloadUI", Integer.valueOf(2));
    BSq.put("SendImgProxyUI", Integer.valueOf(2));
    AppMethodBeat.o(123922);
  }
  
  public f() {}
  
  public f(long paramLong)
  {
    this.BSk = paramLong;
  }
  
  public final boolean a(List<TrafficClickFlowReceiver.c> paramList, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(123920);
    ae.i("Traf.TrafficModel", "realInterval:%d", new Object[] { Long.valueOf(paramLong3) });
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
      this.BSk = (i * paramLong3 * 1048576L / 60000L);
      this.BSn = 0L;
      l1 = 0L;
      j = 0;
      i = 0;
      if (i >= paramList.size()) {
        break label395;
      }
      l2 = Math.min(((TrafficClickFlowReceiver.c)paramList.get(i)).endTime - ((TrafficClickFlowReceiver.c)paramList.get(i)).startTime, paramLong2);
      l1 += l2;
      Object localObject2 = ((TrafficClickFlowReceiver.c)paramList.get(i)).BSh;
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
      if (!BSp.containsKey(localObject2)) {
        break label362;
      }
      d1 = this.BSn;
      d2 = ((Long)BSp.get(localObject2)).longValue();
    }
    for (this.BSn = ((l2 / 1000.0D / 60.0D * d2 + d1));; this.BSn = ((l2 / 1000.0D / 60.0D * 8388608.0D + d1)))
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
      d1 = this.BSn;
    }
    label395:
    if (l1 < paramLong2) {
      this.BSn += (paramLong2 - l1) / 1000L / 60L * 8388608L;
    }
    this.BSn = Math.max(((Long)BSp.get("null")).longValue() * (paramLong2 / 1000L / 60L), this.BSn);
    if (j != 0)
    {
      paramLong2 = this.BSn;
      this.BSn = (((Integer)BSq.get("AppAttachDownloadUI")).intValue() * paramLong2);
    }
    if (j != 0)
    {
      paramLong2 = this.BSn;
      this.BSn = (((Integer)BSq.get("SendImgProxyUI")).intValue() * paramLong2);
    }
    paramLong2 = this.BSk;
    long l1 = this.BSn;
    this.BSo = (paramLong1 / paramLong2 + paramLong1 / l1 * this.BSl);
    if (this.BSo < 0.0D) {
      this.BSo = 0.0D;
    }
    double d1 = this.BSo;
    ae.i("Traf.TrafficModel", "compute Traffic realTraffic:%d , standardTraffic:%d, predictionTraffic:%d, realInterval:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.BSk), Long.valueOf(this.BSn), Long.valueOf(paramLong3) });
    if (d1 > this.BSm)
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
    String str = "TrafficModel{standardTraffic=" + this.BSk + ", preciseRatio=" + this.BSl + ", threshold=" + this.BSm + '}';
    AppMethodBeat.o(123921);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.f
 * JD-Core Version:    0.7.0.1
 */