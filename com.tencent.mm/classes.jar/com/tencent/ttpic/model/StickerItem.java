package com.tencent.ttpic.model;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.particle.ParticleConfig;
import com.tencent.ttpic.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StickerItem
{
  public int activateTriggerCount;
  public int activateTriggerTotalCount;
  public int activateTriggerType;
  public AgeRange ageRange;
  public int[] alignFacePoints;
  public boolean alwaysTriggered;
  public int[] anchorPoint;
  public double[] anchorPointAudio;
  public float angle;
  public int aspectMode;
  public String audio;
  public int audioLoopCount;
  public boolean audioNeedAdjust;
  public List<Pair<Float, Double>> audioScaleFactorMap;
  public int audioTriggerType;
  public StickerItem.ValueRange audioValueRange;
  public int blendMode;
  public int bodyTriggerDirection;
  public int bodyTriggerDistance;
  public int bodyTriggerPoint;
  public double bodyTriggerTimeGap;
  public CharmRange charmRange;
  public int countTriggerType;
  public CpRange cpRange;
  public List<Pair<Float, Double>> degreeMap;
  public int dx;
  public int dy;
  public int fabbyPart;
  public int fabbyTotalParts;
  public int featureStatType;
  public StickerItem.ValueRange featureStatValueRange;
  public double frameDuration;
  public int frameType;
  public int frames;
  public GenderRange genderRange;
  public int height;
  public String id;
  public boolean isFabbyMvItem;
  public int markMode;
  public String name;
  public int originalScaleFactor;
  public ParticleConfig particleConfig;
  public int personID;
  public int playCount;
  public PopularRange popularRange;
  public double[] position;
  public int preTriggerType;
  public int randomGroupNum;
  public float scale;
  public int scaleDirection;
  public int scaleFactor;
  public int[] scalePivots;
  public VideoMaterialUtil.ITEM_SOURCE_TYPE sourceType;
  public int stickerType;
  public String subFolder;
  public int support3D;
  public Transition transition;
  public List<Pair<Float, Double>> translateXMap;
  public List<Pair<Float, Double>> translateYMap;
  public int triggerType;
  public String triggerWords;
  public int type;
  public int width;
  public WMGroup wmGroup;
  public List<WMGroup> wmGroupCopies;
  public int zIndex;
  
  public StickerItem()
  {
    AppMethodBeat.i(83527);
    this.isFabbyMvItem = false;
    this.fabbyPart = 0;
    this.fabbyTotalParts = 1;
    this.aspectMode = 0;
    this.audioScaleFactorMap = new ArrayList();
    this.degreeMap = new ArrayList();
    this.translateXMap = new ArrayList();
    this.translateYMap = new ArrayList();
    this.scale = 1.0F;
    this.angle = 0.0F;
    this.dx = 0;
    this.dy = 0;
    this.personID = -1;
    AppMethodBeat.o(83527);
  }
  
  public boolean isDBTriggered()
  {
    return (this.audioTriggerType == 1) || (this.audioTriggerType == 2);
  }
  
  public String toString()
  {
    AppMethodBeat.i(83528);
    String str = "StickerItem{id='" + this.id + '\'' + ", name='" + this.name + '\'' + ", type=" + this.type + ", triggerType=" + this.triggerType + ", alwaysTriggered=" + this.alwaysTriggered + ", playCount=" + this.playCount + ", frameDuration=" + this.frameDuration + ", frames=" + this.frames + ", width=" + this.width + ", height=" + this.height + ", position=" + Arrays.toString(this.position) + ", audio='" + this.audio + '\'' + ", anchorPoint=" + Arrays.toString(this.anchorPoint) + ", alignFacePoints=" + Arrays.toString(this.alignFacePoints) + ", scalePivots=" + Arrays.toString(this.scalePivots) + ", scaleFactor=" + this.scaleFactor + ", support3D=" + this.support3D + '}';
    AppMethodBeat.o(83528);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.model.StickerItem
 * JD-Core Version:    0.7.0.1
 */