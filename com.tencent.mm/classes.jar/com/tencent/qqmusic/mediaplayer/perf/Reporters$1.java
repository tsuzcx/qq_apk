package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class Reporters$1
  implements PerformanceTracer.Visitor
{
  Reporters$1(AudioInformation paramAudioInformation, Map paramMap) {}
  
  public final void visitSpeedCheck(List<PerformanceTracer.SpeedCheck> paramList, PerformanceTracer.OverallInfo paramOverallInfo)
  {
    int i = 1;
    AppMethodBeat.i(128432);
    long l1 = Math.round(paramOverallInfo.totalPcmToBePlayed / paramOverallInfo.timeCostInMs);
    long l2 = this.val$audioInformation.getPlaySample();
    long l3 = this.val$audioInformation.getChannels();
    if (this.val$audioInformation.getBitDept() == 1) {}
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
      localStringBuilder.append("\t位深: ").append(this.val$audioInformation.getBitDept()).append("\n");
      localStringBuilder.append("\t声道数: ").append(this.val$audioInformation.getChannels()).append("\n");
      localStringBuilder.append("\t时长: ").append(this.val$audioInformation.getDuration()).append("\n");
      localStringBuilder.append("\n整体性能\n");
      localStringBuilder.append("\t总耗时 (ms): ").append(paramOverallInfo.timeCostInMs).append("\n");
      localStringBuilder.append("\t播放PCM数据量 (byte): ").append(paramOverallInfo.totalPcmToBePlayed).append("\n");
      localStringBuilder.append("\t总速度 (byte/ms): ").append(l1).append(" (").append(Math.round(d2)).append(" 倍于最低要求速度)\n");
      localStringBuilder.append("\t最低要求速度 (byte/ms): ").append(d1).append("\n");
      localStringBuilder.append("\n额外信息:");
      Iterator localIterator = this.val$extra.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localStringBuilder.append("\n\t").append((String)localEntry.getKey()).append(": ").append((String)localEntry.getValue());
      }
      i = 2;
    }
    localStringBuilder.append("\n");
    Reporters.access$000(paramList, localStringBuilder, paramOverallInfo.timeCostInMs);
    localStringBuilder.append("============== Info end ==============");
    Logger.i("PERFORMANCE", localStringBuilder.toString());
    AppMethodBeat.o(128432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.Reporters.1
 * JD-Core Version:    0.7.0.1
 */