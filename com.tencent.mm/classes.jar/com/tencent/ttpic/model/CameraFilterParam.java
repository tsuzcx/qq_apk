package com.tencent.ttpic.model;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.filter.FaceFeatureParam;
import java.util.HashMap;
import java.util.Map;

public class CameraFilterParam
{
  public float adjustValue;
  public int beautyLevel;
  public float clarityAdjustValue;
  public float colorToneAlpha;
  public float contrastLevel;
  public int effectIndex;
  public float exposureLevel;
  public float eyeLightenAlpha;
  public float eyeLightenAlpha_573;
  public float faceCenterX;
  public float faceCenterY;
  public float faceFeatureAdjustValue_573;
  public float faceFeatureNormalFactor;
  public FaceFeatureParam faceFeatureParam;
  public int faceRotation;
  public float faceWidth;
  public int filterId;
  public String flagId;
  public int[] histogram;
  public boolean isBlackOpen;
  public boolean isBlurOpen;
  public float removePounchAlpha;
  public float removePounchAlpha_573;
  public int smoothLevel;
  public float toothWhitenAdjustValue;
  
  public CameraFilterParam()
  {
    AppMethodBeat.i(83461);
    this.filterId = 0;
    this.effectIndex = 0;
    this.smoothLevel = -1;
    this.faceRotation = 0;
    this.isBlurOpen = false;
    this.faceCenterX = 0.5F;
    this.faceCenterY = 0.5F;
    this.faceWidth = 0.0F;
    this.isBlackOpen = false;
    this.beautyLevel = 0;
    this.removePounchAlpha = 0.3F;
    this.removePounchAlpha_573 = 0.7F;
    this.eyeLightenAlpha = 0.25F;
    this.eyeLightenAlpha_573 = 0.8F;
    this.adjustValue = 1.0F;
    this.faceFeatureParam = new FaceFeatureParam(0.8F);
    this.faceFeatureAdjustValue_573 = 0.8F;
    this.clarityAdjustValue = 0.8F;
    this.exposureLevel = 50.0F;
    this.toothWhitenAdjustValue = 0.0F;
    this.colorToneAlpha = 0.0F;
    this.faceFeatureNormalFactor = 1.0F;
    this.contrastLevel = 0.0F;
    AppMethodBeat.o(83461);
  }
  
  public CameraFilterParam copyParam()
  {
    AppMethodBeat.i(83465);
    CameraFilterParam localCameraFilterParam = new CameraFilterParam();
    localCameraFilterParam.smoothLevel = this.smoothLevel;
    localCameraFilterParam.effectIndex = this.effectIndex;
    localCameraFilterParam.filterId = this.filterId;
    localCameraFilterParam.flagId = this.flagId;
    localCameraFilterParam.isBlurOpen = this.isBlurOpen;
    localCameraFilterParam.faceCenterX = this.faceCenterX;
    localCameraFilterParam.faceCenterY = this.faceCenterY;
    localCameraFilterParam.faceWidth = this.faceWidth;
    localCameraFilterParam.faceRotation = this.faceRotation;
    localCameraFilterParam.isBlackOpen = this.isBlackOpen;
    localCameraFilterParam.beautyLevel = this.beautyLevel;
    localCameraFilterParam.removePounchAlpha_573 = this.removePounchAlpha_573;
    localCameraFilterParam.removePounchAlpha = this.removePounchAlpha;
    localCameraFilterParam.eyeLightenAlpha = this.eyeLightenAlpha;
    localCameraFilterParam.eyeLightenAlpha_573 = this.eyeLightenAlpha_573;
    localCameraFilterParam.adjustValue = this.adjustValue;
    localCameraFilterParam.faceFeatureParam = this.faceFeatureParam;
    localCameraFilterParam.faceFeatureAdjustValue_573 = this.faceFeatureAdjustValue_573;
    localCameraFilterParam.clarityAdjustValue = this.clarityAdjustValue;
    localCameraFilterParam.exposureLevel = this.exposureLevel;
    localCameraFilterParam.toothWhitenAdjustValue = this.toothWhitenAdjustValue;
    localCameraFilterParam.colorToneAlpha = this.colorToneAlpha;
    localCameraFilterParam.contrastLevel = this.contrastLevel;
    AppMethodBeat.o(83465);
    return localCameraFilterParam;
  }
  
  public Map<String, Object> getBlurMap(boolean paramBoolean)
  {
    AppMethodBeat.i(83462);
    HashMap localHashMap = new HashMap();
    float f;
    if (this.faceWidth > 0.0D)
    {
      localHashMap.put("circle", Boolean.FALSE);
      localHashMap.put("tx", Float.valueOf(this.faceCenterX));
      if (paramBoolean)
      {
        f = 1.0F - this.faceCenterY;
        localHashMap.put("ty", Float.valueOf(f));
        localHashMap.put("radius", Float.valueOf(this.faceWidth / 2.0F));
        localHashMap.put("angle", Float.valueOf(this.faceRotation + 180.0F));
        if ((!paramBoolean) && (this.faceRotation % 180 == 0)) {
          localHashMap.put("angle", Float.valueOf(this.faceRotation));
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(83462);
      return localHashMap;
      f = this.faceCenterY;
      break;
      localHashMap.put("tx", Float.valueOf(0.5F));
      localHashMap.put("ty", Float.valueOf(0.5F));
      localHashMap.put("radius", Float.valueOf(0.35F));
      localHashMap.put("circle", Boolean.TRUE);
    }
  }
  
  public PointF getRealFaceCenter()
  {
    AppMethodBeat.i(83466);
    PointF localPointF = new PointF(this.faceCenterX, this.faceCenterY);
    switch (this.faceRotation)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(83466);
      return localPointF;
      localPointF.y = (1.0F - this.faceCenterX);
      localPointF.x = this.faceCenterY;
      continue;
      localPointF.y = this.faceCenterX;
      localPointF.x = (1.0F - this.faceCenterY);
      continue;
      localPointF.y = (1.0F - this.faceCenterY);
      localPointF.x = (1.0F - this.faceCenterX);
    }
  }
  
  public Map<String, Object> getSmoothMap()
  {
    AppMethodBeat.i(83463);
    HashMap localHashMap = new HashMap();
    switch (this.smoothLevel)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(83463);
      return localHashMap;
      localHashMap.put("opttype", Float.valueOf(0.0F));
      localHashMap.put("smoothMag", Float.valueOf(0.0F));
      localHashMap.put("whitenmag", Float.valueOf(0.0F));
      continue;
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("smoothMag", Float.valueOf(0.2F));
      localHashMap.put("whitenmag", Float.valueOf(0.2F));
      continue;
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("smoothMag", Float.valueOf(0.35F));
      localHashMap.put("whitenmag", Float.valueOf(0.2F));
      continue;
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("smoothMag", Float.valueOf(0.5F));
      localHashMap.put("whitenmag", Float.valueOf(0.25F));
      continue;
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("smoothMag", Float.valueOf(0.625F));
      localHashMap.put("whitenmag", Float.valueOf(0.25F));
      continue;
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("smoothMag", Float.valueOf(0.75F));
      localHashMap.put("whitenmag", Float.valueOf(0.25F));
    }
  }
  
  public Map<String, Object> getSmoothMap(int paramInt)
  {
    AppMethodBeat.i(83464);
    this.beautyLevel = paramInt;
    HashMap localHashMap = new HashMap();
    localHashMap.put("smoothMag", Float.valueOf(paramInt / 100.0F * 0.9F));
    AppMethodBeat.o(83464);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.model.CameraFilterParam
 * JD-Core Version:    0.7.0.1
 */