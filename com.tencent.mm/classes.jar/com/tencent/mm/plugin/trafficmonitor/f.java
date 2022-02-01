package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f
{
  private static Map<String, Long> BAR;
  private static Map<String, Integer> BAS;
  private long BAM;
  private double BAN = 0.35D;
  private double BAO = 3.0D;
  long BAP = 0L;
  double BAQ = 0.0D;
  public final String TAG = "Traf.TrafficModel";
  
  static
  {
    AppMethodBeat.i(123922);
    BAR = new HashMap();
    BAS = new HashMap();
    BAR.put("null", Long.valueOf(4194304L));
    BAR.put("Background", Long.valueOf(5242880L));
    BAR.put("WebViewUI", Long.valueOf(83886080L));
    BAR.put("WebviewMpUI", Long.valueOf(83886080L));
    BAR.put("SnsTimeLineUI", Long.valueOf(15728640L));
    BAR.put("SnsUserUI", Long.valueOf(15728640L));
    BAR.put("AppBrandLaunchProxyUI", Long.valueOf(12582912L));
    BAR.put("AppBrandUI", Long.valueOf(20971520L));
    BAR.put("ChattingUI", Long.valueOf(12582912L));
    BAR.put("SnsBrowseUI", Long.valueOf(12582912L));
    BAR.put("SnsOnlineVideoActivity", Long.valueOf(12582912L));
    BAR.put("EmojiStoreV2UI", Long.valueOf(16777216L));
    BAR.put("EmojiStoreDetailUI", Long.valueOf(16777216L));
    BAR.put("FTSSOSMoreWebViewUI", Long.valueOf(12582912L));
    BAR.put("FTSWebViewUI", Long.valueOf(12582912L));
    BAR.put("TopStoryHomeUI", Long.valueOf(16777216L));
    BAR.put("TopStoryVideoStreamUI", Long.valueOf(25165824L));
    BAR.put("GameDemoActivity1", Long.valueOf(12582912L));
    BAR.put("ImageGalleryUI", Long.valueOf(12582912L));
    BAR.put("SnsGalleryUI", Long.valueOf(12582912L));
    BAR.put("VideoActivity", Long.valueOf(16777216L));
    BAR.put("MultiTalkMainUI", Long.valueOf(16777216L));
    BAR.put("FavoriteVideoPlayUI", Long.valueOf(16777216L));
    BAR.put("AppAttachDownloadUI", Long.valueOf(20971520L));
    BAR.put("LuggageGameWebViewUI", Long.valueOf(20971520L));
    BAS.put("AppAttachDownloadUI", Integer.valueOf(2));
    BAS.put("SendImgProxyUI", Integer.valueOf(2));
    AppMethodBeat.o(123922);
  }
  
  public f() {}
  
  public f(long paramLong)
  {
    this.BAM = paramLong;
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
      this.BAM = (i * paramLong3 * 1048576L / 60000L);
      this.BAP = 0L;
      l1 = 0L;
      j = 0;
      i = 0;
      if (i >= paramList.size()) {
        break label395;
      }
      l2 = Math.min(((TrafficClickFlowReceiver.c)paramList.get(i)).endTime - ((TrafficClickFlowReceiver.c)paramList.get(i)).startTime, paramLong2);
      l1 += l2;
      Object localObject2 = ((TrafficClickFlowReceiver.c)paramList.get(i)).BAJ;
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
      if (!BAR.containsKey(localObject2)) {
        break label362;
      }
      d1 = this.BAP;
      d2 = ((Long)BAR.get(localObject2)).longValue();
    }
    for (this.BAP = ((l2 / 1000.0D / 60.0D * d2 + d1));; this.BAP = ((l2 / 1000.0D / 60.0D * 8388608.0D + d1)))
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
      d1 = this.BAP;
    }
    label395:
    if (l1 < paramLong2) {
      this.BAP += (paramLong2 - l1) / 1000L / 60L * 8388608L;
    }
    this.BAP = Math.max(((Long)BAR.get("null")).longValue() * (paramLong2 / 1000L / 60L), this.BAP);
    if (j != 0)
    {
      paramLong2 = this.BAP;
      this.BAP = (((Integer)BAS.get("AppAttachDownloadUI")).intValue() * paramLong2);
    }
    if (j != 0)
    {
      paramLong2 = this.BAP;
      this.BAP = (((Integer)BAS.get("SendImgProxyUI")).intValue() * paramLong2);
    }
    paramLong2 = this.BAM;
    long l1 = this.BAP;
    this.BAQ = (paramLong1 / paramLong2 + paramLong1 / l1 * this.BAN);
    if (this.BAQ < 0.0D) {
      this.BAQ = 0.0D;
    }
    double d1 = this.BAQ;
    ad.i("Traf.TrafficModel", "compute Traffic realTraffic:%d , standardTraffic:%d, predictionTraffic:%d, realInterval:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.BAM), Long.valueOf(this.BAP), Long.valueOf(paramLong3) });
    if (d1 > this.BAO)
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
    String str = "TrafficModel{standardTraffic=" + this.BAM + ", preciseRatio=" + this.BAN + ", threshold=" + this.BAO + '}';
    AppMethodBeat.o(123921);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.f
 * JD-Core Version:    0.7.0.1
 */