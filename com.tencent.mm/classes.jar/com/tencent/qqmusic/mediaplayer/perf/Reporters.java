package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Reporters
{
  public static PerformanceTracer.Visitor detail(AudioInformation paramAudioInformation, final Map<String, String> paramMap)
  {
    AppMethodBeat.i(114198);
    paramAudioInformation = new PerformanceTracer.Visitor()
    {
      public final void visitSpeedCheck(List<PerformanceTracer.SpeedCheck> paramAnonymousList, PerformanceTracer.OverallInfo paramAnonymousOverallInfo)
      {
        int i = 1;
        AppMethodBeat.i(114194);
        long l1 = Math.round(paramAnonymousOverallInfo.totalPcmToBePlayed / paramAnonymousOverallInfo.timeCostInMs);
        long l2 = this.val$audioInformation.getPlaySample();
        long l3 = this.val$audioInformation.getChannels();
        if (this.val$audioInformation.getBitDepth() == 1) {}
        StringBuilder localStringBuilder;
        for (;;)
        {
          double d1 = i * (l2 * l3) / 1000.0D;
          double d2 = l1 / d1;
          localStringBuilder = new StringBuilder("\n============== Info start ==============\n");
          localStringBuilder.append("媒体文件信息:\n");
          localStringBuilder.append("\t播放时间: ").append(new Date().toString()).append("\n");
          localStringBuilder.append("\t音频类型: ").append(this.val$audioInformation.getAudioType().toString()).append("\n");
          localStringBuilder.append("\t文件采样率: ").append(this.val$audioInformation.getSampleRate()).append("\n");
          localStringBuilder.append("\t播放采样率: ").append(this.val$audioInformation.getPlaySample()).append("\n");
          localStringBuilder.append("\t位深: ").append(this.val$audioInformation.getBitDepth()).append("\n");
          localStringBuilder.append("\t声道数: ").append(this.val$audioInformation.getChannels()).append("\n");
          localStringBuilder.append("\t时长: ").append(this.val$audioInformation.getDuration()).append("\n");
          localStringBuilder.append("\n整体性能\n");
          localStringBuilder.append("\t总耗时 (ms): ").append(paramAnonymousOverallInfo.timeCostInMs).append("\n");
          localStringBuilder.append("\t播放PCM数据量 (byte): ").append(paramAnonymousOverallInfo.totalPcmToBePlayed).append("\n");
          localStringBuilder.append("\t总速度 (byte/ms): ").append(l1).append(" (").append(Math.round(d2)).append(" 倍于最低要求速度)\n");
          localStringBuilder.append("\t最低要求速度 (byte/ms): ").append(d1).append("\n");
          localStringBuilder.append("\n额外信息:");
          Iterator localIterator = paramMap.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            localStringBuilder.append("\n\t").append((String)localEntry.getKey()).append(": ").append((String)localEntry.getValue());
          }
          i = 2;
        }
        localStringBuilder.append("\n");
        Reporters.access$000(paramAnonymousList, localStringBuilder, paramAnonymousOverallInfo.timeCostInMs);
        localStringBuilder.append("============== Info end ==============");
        Logger.i("PERFORMANCE", localStringBuilder.toString());
        AppMethodBeat.o(114194);
      }
    };
    AppMethodBeat.o(114198);
    return paramAudioInformation;
  }
  
  private static void generateDetailedPerformance(List<PerformanceTracer.SpeedCheck> paramList, StringBuilder paramStringBuilder, long paramLong)
  {
    AppMethodBeat.i(114199);
    paramStringBuilder.append("\n详细性能数据:\n");
    paramStringBuilder.append(String.format(Locale.getDefault(), "\t%15s%15s%15s%15s%15s", new Object[] { "名称", "平均速度(byte/ms)", "耗时(ms)", "数据量(byte)", "占总耗时比" }));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PerformanceTracer.SpeedCheck localSpeedCheck = (PerformanceTracer.SpeedCheck)paramList.next();
      paramStringBuilder.append("\n");
      paramStringBuilder.append(String.format(Locale.getDefault(), "\t%15s%15.0f%15d%15d%13.2f", new Object[] { localSpeedCheck.getName(), Double.valueOf(localSpeedCheck.getAvg()), Long.valueOf(localSpeedCheck.getTotalTimeMs()), Long.valueOf(localSpeedCheck.getTotalBufferLength()), Double.valueOf(localSpeedCheck.getTotalTimeMs() / paramLong) }));
    }
    paramStringBuilder.append("\n");
    AppMethodBeat.o(114199);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.Reporters
 * JD-Core Version:    0.7.0.1
 */