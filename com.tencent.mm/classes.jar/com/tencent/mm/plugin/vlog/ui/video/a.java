package com.tencent.mm.plugin.vlog.ui.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.AdaptiveAdjustBitrate;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/video/ABAParamsUtil;", "", "()V", "ABAPrams", "Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;", "getABAPrams", "()Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;", "setABAPrams", "(Lcom/tencent/mm/plugin/sight/base/AdaptiveAdjustBitrate;)V", "SCENE_C2C", "", "SCENE_FINDER", "SCENE_SNS", "SCENE_STORY", "abaParams", "", "forceResolution", "", "videoBitrate", "videoFrameRate", "videoHeight", "videoPath", "", "videoWidth", "changeVideoParam", "", "para", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "videoParam", "reMuxEndTimeMsPrams", "reMuxStartTimeMsPrams", "setConfig", "encodeConfig", "Lcom/tencent/mm/plugin/recordvideo/config/RemuxMediaEditConfig$EncodeConfig;", "scene", "setForceResolution", "setVideoPath", "Companion", "plugin-vlog_release"})
public final class a
{
  public static final a NFr;
  int[] Azu;
  AdaptiveAdjustBitrate HGT;
  boolean HGV;
  final int HGW;
  final int HGX;
  private final int HGY;
  int videoBitrate;
  int videoFrameRate;
  int videoHeight;
  String videoPath;
  int videoWidth;
  final int xde;
  
  static
  {
    AppMethodBeat.i(251017);
    NFr = new a((byte)0);
    AppMethodBeat.o(251017);
  }
  
  public a()
  {
    AppMethodBeat.i(251016);
    int[] arrayOfInt = new int[34];
    int i = 0;
    while (i < 34)
    {
      arrayOfInt[i] = 0;
      i += 1;
    }
    this.Azu = arrayOfInt;
    this.videoPath = "";
    this.HGW = 1;
    this.HGX = 2;
    this.HGY = 3;
    this.xde = 4;
    AppMethodBeat.o(251016);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/video/ABAParamsUtil$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.video.a
 * JD-Core Version:    0.7.0.1
 */