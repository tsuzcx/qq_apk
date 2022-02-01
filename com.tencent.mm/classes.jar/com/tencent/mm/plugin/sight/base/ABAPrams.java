package com.tencent.mm.plugin.sight.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public class ABAPrams
{
  public int SkipReadQP;
  public int addStickers;
  public int averageMV;
  public int averageQP;
  public int bitrateAdaptiveDown;
  public int bitrateAdaptiveUP;
  public int codecID;
  public int compAudioBitrate;
  public int compAudioChannel;
  public int consumingtime;
  public int duration;
  public int enableABA;
  public int enableSWHEVCTrans;
  public int inputFps;
  public int inputHeight;
  public int inputKbps;
  public int inputWidth;
  public int interMode;
  public int intraMode;
  public int isEnableHEVC;
  public int oriAudioBitrate;
  public int oriAudioChannel;
  public int outputHeight;
  public int outputKbps;
  public int outputWidth;
  public int platform;
  public int qualityLevel;
  public int ratiosBitrateQP;
  public int resolutionAdjust;
  public int sceneCase;
  public int skipMode;
  public int skipVideoCompress;
  public int startTime;
  public int textureComplexity;
  public int transcosingKbps;
  public int use1080pC2CSNS;
  
  public List<Integer> transToList()
  {
    AppMethodBeat.i(291878);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(this.outputKbps));
    localLinkedList.add(Integer.valueOf(this.outputWidth));
    localLinkedList.add(Integer.valueOf(this.outputHeight));
    localLinkedList.add(Integer.valueOf(this.bitrateAdaptiveUP));
    localLinkedList.add(Integer.valueOf(this.bitrateAdaptiveDown));
    localLinkedList.add(Integer.valueOf(this.resolutionAdjust));
    localLinkedList.add(Integer.valueOf(this.sceneCase));
    localLinkedList.add(Integer.valueOf(this.inputKbps));
    localLinkedList.add(Integer.valueOf(this.inputWidth));
    localLinkedList.add(Integer.valueOf(this.inputHeight));
    localLinkedList.add(Integer.valueOf(this.inputFps));
    localLinkedList.add(Integer.valueOf(this.averageQP));
    localLinkedList.add(Integer.valueOf(this.averageMV));
    localLinkedList.add(Integer.valueOf(this.skipMode));
    localLinkedList.add(Integer.valueOf(this.intraMode));
    localLinkedList.add(Integer.valueOf(this.interMode));
    localLinkedList.add(Integer.valueOf(this.SkipReadQP));
    localLinkedList.add(Integer.valueOf(this.consumingtime));
    localLinkedList.add(Integer.valueOf(this.codecID));
    localLinkedList.add(Integer.valueOf(this.transcosingKbps));
    localLinkedList.add(Integer.valueOf(this.isEnableHEVC));
    localLinkedList.add(Integer.valueOf(this.enableABA));
    localLinkedList.add(Integer.valueOf(this.use1080pC2CSNS));
    localLinkedList.add(Integer.valueOf(this.startTime));
    localLinkedList.add(Integer.valueOf(this.duration));
    localLinkedList.add(Integer.valueOf(this.ratiosBitrateQP));
    localLinkedList.add(Integer.valueOf(this.textureComplexity));
    localLinkedList.add(Integer.valueOf(this.qualityLevel));
    localLinkedList.add(Integer.valueOf(this.platform));
    localLinkedList.add(Integer.valueOf(this.oriAudioBitrate));
    localLinkedList.add(Integer.valueOf(this.oriAudioChannel));
    localLinkedList.add(Integer.valueOf(this.compAudioBitrate));
    localLinkedList.add(Integer.valueOf(this.compAudioChannel));
    localLinkedList.add(Integer.valueOf(this.addStickers));
    localLinkedList.add(Integer.valueOf(this.enableSWHEVCTrans));
    localLinkedList.add(Integer.valueOf(this.skipVideoCompress));
    AppMethodBeat.o(291878);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.ABAPrams
 * JD-Core Version:    0.7.0.1
 */