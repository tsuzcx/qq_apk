package com.tencent.mm.plugin.trafficmonitor;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class f
{
  private static Map<String, Long> NfH;
  private static Map<String, Integer> NfI;
  private long NfC;
  private double NfD = 0.35D;
  private double NfE = 3.0D;
  long NfF = 0L;
  double NfG = 0.0D;
  public final String TAG = "Traf.TrafficModel";
  
  static
  {
    AppMethodBeat.i(123922);
    NfH = new HashMap();
    NfI = new HashMap();
    NfH.put("null", Long.valueOf(4194304L));
    NfH.put("Background", Long.valueOf(5242880L));
    NfH.put("WebViewUI", Long.valueOf(83886080L));
    NfH.put("WebviewMpUI", Long.valueOf(83886080L));
    NfH.put("SnsTimeLineUI", Long.valueOf(15728640L));
    NfH.put("SnsUserUI", Long.valueOf(15728640L));
    NfH.put("AppBrandLaunchProxyUI", Long.valueOf(12582912L));
    NfH.put("AppBrandUI", Long.valueOf(20971520L));
    NfH.put("ChattingUI", Long.valueOf(12582912L));
    NfH.put("SnsBrowseUI", Long.valueOf(12582912L));
    NfH.put("SnsOnlineVideoActivity", Long.valueOf(12582912L));
    NfH.put("EmojiStoreV2UI", Long.valueOf(16777216L));
    NfH.put("EmojiStoreDetailUI", Long.valueOf(16777216L));
    NfH.put("FTSSOSMoreWebViewUI", Long.valueOf(12582912L));
    NfH.put("FTSWebViewUI", Long.valueOf(12582912L));
    NfH.put("TopStoryHomeUI", Long.valueOf(16777216L));
    NfH.put("TopStoryVideoStreamUI", Long.valueOf(25165824L));
    NfH.put("GameDemoActivity1", Long.valueOf(12582912L));
    NfH.put("ImageGalleryUI", Long.valueOf(12582912L));
    NfH.put("SnsGalleryUI", Long.valueOf(12582912L));
    NfH.put("VideoActivity", Long.valueOf(16777216L));
    NfH.put("MultiTalkMainUI", Long.valueOf(16777216L));
    NfH.put("FavoriteVideoPlayUI", Long.valueOf(16777216L));
    NfH.put("AppAttachDownloadUI", Long.valueOf(20971520L));
    NfH.put("LuggageGameWebViewUI", Long.valueOf(20971520L));
    NfI.put("AppAttachDownloadUI", Integer.valueOf(2));
    NfI.put("SendImgProxyUI", Integer.valueOf(2));
    AppMethodBeat.o(123922);
  }
  
  public f() {}
  
  public f(long paramLong)
  {
    this.NfC = paramLong;
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
      this.NfC = (i * paramLong3 * 1048576L / 60000L);
      this.NfF = 0L;
      l1 = 0L;
      j = 0;
      i = 0;
      if (i >= paramList.size()) {
        break label395;
      }
      l2 = Math.min(((TrafficClickFlowReceiver.c)paramList.get(i)).endTime - ((TrafficClickFlowReceiver.c)paramList.get(i)).startTime, paramLong2);
      l1 += l2;
      Object localObject2 = ((TrafficClickFlowReceiver.c)paramList.get(i)).Nfz;
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
      if (!NfH.containsKey(localObject2)) {
        break label362;
      }
      d1 = this.NfF;
      d2 = ((Long)NfH.get(localObject2)).longValue();
    }
    for (this.NfF = ((l2 / 1000.0D / 60.0D * d2 + d1));; this.NfF = ((l2 / 1000.0D / 60.0D * 8388608.0D + d1)))
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
      d1 = this.NfF;
    }
    label395:
    if (l1 < paramLong2) {
      this.NfF += (paramLong2 - l1) / 1000L / 60L * 8388608L;
    }
    this.NfF = Math.max(((Long)NfH.get("null")).longValue() * (paramLong2 / 1000L / 60L), this.NfF);
    if (j != 0)
    {
      paramLong2 = this.NfF;
      this.NfF = (((Integer)NfI.get("AppAttachDownloadUI")).intValue() * paramLong2);
    }
    if (j != 0)
    {
      paramLong2 = this.NfF;
      this.NfF = (((Integer)NfI.get("SendImgProxyUI")).intValue() * paramLong2);
    }
    paramLong2 = this.NfC;
    long l1 = this.NfF;
    this.NfG = (paramLong1 / paramLong2 + paramLong1 / l1 * this.NfD);
    if (this.NfG < 0.0D) {
      this.NfG = 0.0D;
    }
    double d1 = this.NfG;
    Log.i("Traf.TrafficModel", "compute Traffic realTraffic:%d , standardTraffic:%d, predictionTraffic:%d, realInterval:%d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(this.NfC), Long.valueOf(this.NfF), Long.valueOf(paramLong3) });
    if (d1 > this.NfE)
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
    String str = "TrafficModel{standardTraffic=" + this.NfC + ", preciseRatio=" + this.NfD + ", threshold=" + this.NfE + '}';
    AppMethodBeat.o(123921);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.trafficmonitor.f
 * JD-Core Version:    0.7.0.1
 */