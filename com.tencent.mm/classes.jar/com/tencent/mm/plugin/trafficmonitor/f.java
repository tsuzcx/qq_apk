package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f
{
  private static Map<String, Long> yVq;
  private static Map<String, Integer> yVr;
  public final String TAG = "Traf.TrafficModel";
  private long yVl;
  private double yVm = 0.35D;
  private double yVn = 3.0D;
  long yVo = 0L;
  double yVp = 0.0D;
  
  static
  {
    AppMethodBeat.i(123922);
    yVq = new HashMap();
    yVr = new HashMap();
    yVq.put("null", Long.valueOf(4194304L));
    yVq.put("Background", Long.valueOf(5242880L));
    yVq.put("WebViewUI", Long.valueOf(83886080L));
    yVq.put("WebviewMpUI", Long.valueOf(83886080L));
    yVq.put("SnsTimeLineUI", Long.valueOf(15728640L));
    yVq.put("SnsUserUI", Long.valueOf(15728640L));
    yVq.put("AppBrandLaunchProxyUI", Long.valueOf(12582912L));
    yVq.put("AppBrandUI", Long.valueOf(20971520L));
    yVq.put("ChattingUI", Long.valueOf(12582912L));
    yVq.put("SnsBrowseUI", Long.valueOf(12582912L));
    yVq.put("SnsOnlineVideoActivity", Long.valueOf(12582912L));
    yVq.put("EmojiStoreV2UI", Long.valueOf(16777216L));
    yVq.put("EmojiStoreDetailUI", Long.valueOf(16777216L));
    yVq.put("FTSSOSMoreWebViewUI", Long.valueOf(12582912L));
    yVq.put("FTSWebViewUI", Long.valueOf(12582912L));
    yVq.put("TopStoryHomeUI", Long.valueOf(16777216L));
    yVq.put("TopStoryVideoStreamUI", Long.valueOf(25165824L));
    yVq.put("GameDemoActivity1", Long.valueOf(12582912L));
    yVq.put("ImageGalleryUI", Long.valueOf(12582912L));
    yVq.put("SnsGalleryUI", Long.valueOf(12582912L));
    yVq.put("VideoActivity", Long.valueOf(16777216L));
    yVq.put("MultiTalkMainUI", Long.valueOf(16777216L));
    yVq.put("FavoriteVideoPlayUI", Long.valueOf(16777216L));
    yVq.put("AppAttachDownloadUI", Long.valueOf(20971520L));
    yVq.put("LuggageGameWebViewUI", Long.valueOf(20971520L));
    yVr.put("AppAttachDownloadUI", Integer.valueOf(2));
    yVr.put("SendImgProxyUI", Integer.valueOf(2));
    AppMethodBeat.o(123922);
  }
  
  public f() {}
  
  public f(long paramLong)
  {
    this.yVl = paramLong;
  }
  
  public final boolean a(List<TrafficClickFlowReceiver.c> paramList, long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(123920);
    ad.i("Traf.TrafficModel", "realInterval:%d", new Object[] { Long.valueOf(paramLong3) });
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
      this.yVl = (i * paramLong3 * 1048576L / 60000L);
      this.yVo = 0L;
      l1 = 0L;
      j = 0;
      i = 0;
      if (i >= paramList.size()) {
        break label395;
      }
      l2 = Math.min(((TrafficClickFlowReceiver.c)paramList.get(i)).endTime - ((TrafficClickFlowReceiver.c)paramList.get(i)).startTime, paramLong2);
      l1 += l2;
      Object localObject2 = ((TrafficClickFlowReceiver.c)paramList.get(i)).yVi;
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
      if (!yVq.containsKey(localObject2)) {
        break label362;
      }
      d1 = this.yVo;
      d2 = ((Long)yVq.get(localObject2)).longValue();
    }
    for (this.yVo = ((l2 / 1000.0D / 60.0D * d2 + d1));; this.yVo = ((l2 / 1000.0D / 60.0D * 8388608.0D + d1)))
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
      d1 = this.yVo;
    }
    label395:
    if (l1 < paramLong2) {
      this.yVo += (paramLong2 - l1) / 1000L / 60L * 8388608L;
    }
    this.yVo = Math.max(((Long)yVq.get("null")).longValue() * (paramLong2 / 1000L / 60L), this.yVo);
    if (j != 0)
    {
      paramLong2 = this.yVo;
      this.yVo = (((Integer)yVr.get("AppAttachDownloadUI")).intValue() * paramLong2);
    }
    if (j != 0)
    {
      paramLong2 = this.yVo;
      this.yVo = (((Integer)yVr.get("SendImgProxyUI")).intValue() * paramLong2);
    }
    paramLong2 = this.yVl;
    long l1 = this.yVo;
    this.yVp = (paramLong1 / paramLong2 + paramLong1 / l1 * this.yVm);
    if (this.yVp < 0.0D) {
      this.yVp = 0.0D;
    }
    double d1 = this.yVp;
    ad.i("Traf.TrafficModel", "compute Traffic realTraffic:%d , standardTraffic:%d, predictionTraffic:%d, realInterval:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.yVl), Long.valueOf(this.yVo), Long.valueOf(paramLong3) });
    if (d1 > this.yVn)
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
    String str = "TrafficModel{standardTraffic=" + this.yVl + ", preciseRatio=" + this.yVm + ", threshold=" + this.yVn + '}';
    AppMethodBeat.o(123921);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.f
 * JD-Core Version:    0.7.0.1
 */