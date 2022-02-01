package com.tencent.mm.plugin.vlog.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.ABAPrams;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/video/ABAParamsUtil;", "", "()V", "ABAPrams", "Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;", "getABAPrams", "()Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;", "setABAPrams", "(Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;)V", "SCENE_C2C", "", "SCENE_FINDER", "SCENE_SNS", "SCENE_STORY", "abaParams", "Lcom/tencent/mm/plugin/sight/base/ABAPrams;", "forceResolution", "", "videoBitrate", "videoFrameRate", "videoHeight", "videoPath", "", "videoWidth", "changeVideoParam", "", "para", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "videoParam", "reMuxEndTimeMsPrams", "reMuxStartTimeMsPrams", "setConfig", "encodeConfig", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "scene", "setForceResolution", "setVideoPath", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a UrA;
  final int ACC = 4;
  ABAPrams Gbz;
  AdaptiveAdjustBitrate NEq;
  boolean NEs;
  final int NEt = 1;
  final int NEu = 2;
  private final int NEv = 3;
  int videoBitrate;
  int videoFrameRate;
  int videoHeight;
  String videoPath = "";
  int videoWidth;
  
  static
  {
    AppMethodBeat.i(281887);
    UrA = new a.a((byte)0);
    AppMethodBeat.o(281887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.video.a
 * JD-Core Version:    0.7.0.1
 */