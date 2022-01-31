package com.tencent.ttpic.model;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TriggerConfig
{
  public final int BODY_TRIGGER_ANGLE_TOLERANCE = 15;
  public int activateTriggerCount;
  public int activateTriggerTotalCount;
  public boolean alwaysTriggered;
  public boolean audioNeedAdjust;
  public List<Pair<Float, Double>> audioScaleFactorMap;
  public int audioTriggerType;
  public StickerItem.ValueRange audioValueRange;
  public int bodyTriggerDirection;
  public int bodyTriggerDistance;
  public int bodyTriggerPoint;
  public double bodyTriggerTimeGap;
  public int countTriggerType;
  public int playCount;
  public int preTriggerType;
  public int randomGroupNum;
  public boolean renderForBitmap;
  private StickerItem stickerItem;
  public int triggerType;
  private Pattern triggerWordsPattern;
  
  public TriggerConfig()
  {
    this.triggerType = PTFaceAttr.PTExpression.FACE_DETECT.value;
  }
  
  public TriggerConfig(FaceItem paramFaceItem)
  {
    this.preTriggerType = paramFaceItem.preTriggerType;
    this.countTriggerType = paramFaceItem.countTriggerType;
    this.activateTriggerCount = paramFaceItem.activateTriggerCount;
    this.activateTriggerTotalCount = paramFaceItem.activateTriggerTotalCount;
    this.randomGroupNum = paramFaceItem.randomGroupNum;
    this.alwaysTriggered = paramFaceItem.alwaysTriggered;
    this.triggerType = paramFaceItem.triggerType;
    this.playCount = paramFaceItem.playCount;
  }
  
  public TriggerConfig(FaceMeshItem paramFaceMeshItem)
  {
    this.alwaysTriggered = paramFaceMeshItem.alwaysTriggered;
    this.triggerType = paramFaceMeshItem.triggerType;
    this.playCount = paramFaceMeshItem.playCount;
  }
  
  public TriggerConfig(StickerItem paramStickerItem)
  {
    this.preTriggerType = paramStickerItem.preTriggerType;
    this.countTriggerType = paramStickerItem.countTriggerType;
    this.activateTriggerCount = paramStickerItem.activateTriggerCount;
    this.activateTriggerTotalCount = paramStickerItem.activateTriggerTotalCount;
    this.randomGroupNum = paramStickerItem.randomGroupNum;
    this.alwaysTriggered = paramStickerItem.alwaysTriggered;
    this.triggerType = paramStickerItem.triggerType;
    this.audioTriggerType = paramStickerItem.audioTriggerType;
    this.audioNeedAdjust = paramStickerItem.audioNeedAdjust;
    this.audioValueRange = paramStickerItem.audioValueRange;
    this.audioScaleFactorMap = paramStickerItem.audioScaleFactorMap;
    this.playCount = paramStickerItem.playCount;
    this.bodyTriggerPoint = paramStickerItem.bodyTriggerPoint;
    this.bodyTriggerDirection = paramStickerItem.bodyTriggerDirection;
    this.bodyTriggerDistance = paramStickerItem.bodyTriggerDistance;
    this.bodyTriggerTimeGap = paramStickerItem.bodyTriggerTimeGap;
    this.stickerItem = paramStickerItem;
  }
  
  public int getBodyTriggerAngle()
  {
    switch (this.bodyTriggerDirection)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 45;
    case 2: 
      return 90;
    case 3: 
      return 135;
    case 4: 
      return 180;
    case 5: 
      return 225;
    case 6: 
      return 270;
    }
    return 315;
  }
  
  public boolean isDBTriggered()
  {
    AppMethodBeat.i(83555);
    if ((this.stickerItem != null) && (this.stickerItem.isDBTriggered()))
    {
      AppMethodBeat.o(83555);
      return true;
    }
    AppMethodBeat.o(83555);
    return false;
  }
  
  public boolean isRenderForBitmap()
  {
    return this.renderForBitmap;
  }
  
  public boolean isSentenceTriggered(String paramString)
  {
    AppMethodBeat.i(83554);
    if (this.triggerWordsPattern == null)
    {
      AppMethodBeat.o(83554);
      return false;
    }
    boolean bool = this.triggerWordsPattern.matcher(paramString).find();
    AppMethodBeat.o(83554);
    return bool;
  }
  
  public void setRenderForBitmap(boolean paramBoolean)
  {
    this.renderForBitmap = paramBoolean;
  }
  
  public void setTriggerWords(String paramString)
  {
    AppMethodBeat.i(83553);
    if (paramString == null)
    {
      AppMethodBeat.o(83553);
      return;
    }
    this.triggerWordsPattern = Pattern.compile(paramString);
    AppMethodBeat.o(83553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.model.TriggerConfig
 * JD-Core Version:    0.7.0.1
 */