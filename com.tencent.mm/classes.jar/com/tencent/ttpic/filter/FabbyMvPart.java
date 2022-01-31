package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.fabby.FabbyUtil;
import com.tencent.ttpic.model.GridSettingModel;
import com.tencent.ttpic.model.ShakaEffectItem;
import com.tencent.ttpic.model.StickerItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FabbyMvPart
{
  public List<Pair<Float, Double>> alphaMap;
  public List<Pair<Float, Double>> anchorXMap;
  public List<Pair<Float, Double>> anchorYMap;
  public String audio;
  public StickerItem bgItem;
  public List<Pair<Float, Double>> blurDirectionMap;
  public List<Pair<Float, Double>> blurRadiusMap;
  public StickerItem coverItem;
  public List<Pair<Float, Double>> degreeMap;
  public long duration;
  public int easeCurve;
  public StickerItem fgItem;
  public String filterId;
  public List<Pair<Float, Integer>> filterParamMap;
  public int filterType;
  public List<Pair<Float, Integer>> gridModeMap;
  public List<Pair<Float, Integer>> gridOrderMap;
  public List<Pair<Float, GridSettingModel>> gridSettingMap;
  public List<Pair<Float, Integer>> gridTypeMap;
  public String lutFile;
  public int partIndex;
  public List<Pair<Float, Double>> scaleMap;
  private ShakaEffectItem shakaEffectItem;
  public long transitionDuration;
  public int transitionEase;
  public int transitionFunction;
  public StickerItem transitionItem;
  public int transitionMaskType;
  public List<Pair<Float, Double>> translateXMap;
  public List<Pair<Float, Double>> translateYMap;
  
  public FabbyMvPart()
  {
    AppMethodBeat.i(82285);
    this.transitionMaskType = 1;
    this.scaleMap = new ArrayList();
    this.degreeMap = new ArrayList();
    this.translateXMap = new ArrayList();
    this.translateYMap = new ArrayList();
    this.anchorXMap = new ArrayList();
    this.anchorYMap = new ArrayList();
    this.alphaMap = new ArrayList();
    this.blurRadiusMap = new ArrayList();
    this.blurDirectionMap = new ArrayList();
    this.gridTypeMap = new ArrayList();
    this.gridSettingMap = new ArrayList();
    this.gridModeMap = new ArrayList();
    this.gridOrderMap = new ArrayList();
    this.filterParamMap = new ArrayList();
    this.easeCurve = 0;
    AppMethodBeat.o(82285);
  }
  
  public double getAlpha(float paramFloat)
  {
    AppMethodBeat.i(82288);
    double d = FabbyUtil.getRangeValue(this.easeCurve, paramFloat, this.alphaMap, 1.0D);
    AppMethodBeat.o(82288);
    return d;
  }
  
  public PointF getAnchor(float paramFloat)
  {
    AppMethodBeat.i(82291);
    PointF localPointF = new PointF();
    localPointF.x = ((float)FabbyUtil.getRangeValue(this.easeCurve, paramFloat, this.anchorXMap, 0.0D));
    localPointF.y = ((float)FabbyUtil.getRangeValue(this.easeCurve, paramFloat, this.anchorYMap, 0.0D));
    AppMethodBeat.o(82291);
    return localPointF;
  }
  
  public double getBlurAngle(float paramFloat)
  {
    AppMethodBeat.i(82290);
    double d = FabbyUtil.getRangeValue(this.easeCurve, paramFloat, this.blurDirectionMap, 0.0D);
    AppMethodBeat.o(82290);
    return d;
  }
  
  public double getBlurSize(float paramFloat)
  {
    AppMethodBeat.i(82289);
    double d = FabbyUtil.getRangeValue(this.easeCurve, paramFloat, this.blurRadiusMap, 0.0D);
    AppMethodBeat.o(82289);
    return d;
  }
  
  public double getDegree(float paramFloat)
  {
    AppMethodBeat.i(82287);
    double d = FabbyUtil.getRangeValue(this.easeCurve, paramFloat, this.degreeMap, 0.0D);
    AppMethodBeat.o(82287);
    return d;
  }
  
  public int getFilterParam(float paramFloat)
  {
    AppMethodBeat.i(82297);
    int i = FabbyUtil.getDivideValue(paramFloat, this.filterParamMap, 1);
    AppMethodBeat.o(82297);
    return i;
  }
  
  public int getGridMode(float paramFloat)
  {
    AppMethodBeat.i(82293);
    int i = FabbyUtil.getDivideValue(paramFloat, this.gridModeMap, 0);
    AppMethodBeat.o(82293);
    return i;
  }
  
  public int getGridOrder(float paramFloat)
  {
    AppMethodBeat.i(82296);
    int i = FabbyUtil.getDivideValue(paramFloat, this.gridOrderMap, 0);
    AppMethodBeat.o(82296);
    return i;
  }
  
  public GridSettingModel getGridSetting(float paramFloat)
  {
    AppMethodBeat.i(82295);
    GridSettingModel localGridSettingModel = FabbyUtil.getGridSetting(paramFloat, this.gridSettingMap, null);
    AppMethodBeat.o(82295);
    return localGridSettingModel;
  }
  
  public int getGridType(float paramFloat)
  {
    AppMethodBeat.i(82294);
    int i = FabbyUtil.getDivideValue(paramFloat, this.gridTypeMap, 0);
    AppMethodBeat.o(82294);
    return i;
  }
  
  public double getScale(float paramFloat)
  {
    AppMethodBeat.i(82286);
    double d = FabbyUtil.getRangeValue(this.easeCurve, paramFloat, this.scaleMap, 1.0D);
    AppMethodBeat.o(82286);
    return d;
  }
  
  public ShakaEffectItem getShakaEffectItem()
  {
    return this.shakaEffectItem;
  }
  
  public Map<String, Float> getShakaValueMap(float paramFloat)
  {
    AppMethodBeat.i(82298);
    Map localMap = this.shakaEffectItem.getValueMap(this.easeCurve, paramFloat);
    AppMethodBeat.o(82298);
    return localMap;
  }
  
  public PointF getTranslate(float paramFloat)
  {
    AppMethodBeat.i(82292);
    PointF localPointF = new PointF();
    localPointF.x = ((float)FabbyUtil.getRangeValue(this.easeCurve, paramFloat, this.translateXMap, 0.0D));
    localPointF.y = ((float)FabbyUtil.getRangeValue(this.easeCurve, paramFloat, this.translateYMap, 0.0D));
    AppMethodBeat.o(82292);
    return localPointF;
  }
  
  public void setShakaEffectItem(ShakaEffectItem paramShakaEffectItem)
  {
    this.shakaEffectItem = paramShakaEffectItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.filter.FabbyMvPart
 * JD-Core Version:    0.7.0.1
 */