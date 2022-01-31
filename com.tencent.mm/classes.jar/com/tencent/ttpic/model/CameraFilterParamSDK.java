package com.tencent.ttpic.model;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public class CameraFilterParamSDK
{
  public int effectIndex = 0;
  public float faceCenterX = 0.5F;
  public float faceCenterY = 0.5F;
  public int faceRotation = 0;
  public float faceWidth = 0.0F;
  public int filterId = 0;
  public String flagId;
  public boolean isBlackOpen = false;
  public boolean isBlurOpen = false;
  private boolean lowEnergy = false;
  public int smoothLevel = -1;
  
  private Map<String, Object> getSmoothMapCommon()
  {
    AppMethodBeat.i(83469);
    HashMap localHashMap = new HashMap();
    switch (this.smoothLevel)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(83469);
      return localHashMap;
      localHashMap.put("opttype", Float.valueOf(0.0F));
      localHashMap.put("radius", Float.valueOf(0.0F));
      localHashMap.put("whitenmag", Float.valueOf(0.0F));
      continue;
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("radius", Float.valueOf(0.2F));
      localHashMap.put("whitenmag", Float.valueOf(0.2F));
      continue;
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("radius", Float.valueOf(0.35F));
      localHashMap.put("whitenmag", Float.valueOf(0.2F));
      continue;
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("radius", Float.valueOf(0.5F));
      localHashMap.put("whitenmag", Float.valueOf(0.25F));
      continue;
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("radius", Float.valueOf(0.625F));
      localHashMap.put("whitenmag", Float.valueOf(0.25F));
      continue;
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("radius", Float.valueOf(0.75F));
      localHashMap.put("whitenmag", Float.valueOf(0.25F));
    }
  }
  
  private Map<String, Object> getSmoothMapLowEnergy()
  {
    AppMethodBeat.i(83470);
    HashMap localHashMap = new HashMap();
    switch (this.smoothLevel)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(83470);
      return localHashMap;
      localHashMap.put("opttype", Float.valueOf(0.0F));
      localHashMap.put("radius", Float.valueOf(0.0F));
      localHashMap.put("whitenmag", Float.valueOf(0.0F));
      continue;
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("radius", Float.valueOf(0.1F));
      localHashMap.put("whitenmag", Float.valueOf(0.2F));
      continue;
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("radius", Float.valueOf(0.1725F));
      localHashMap.put("whitenmag", Float.valueOf(0.2F));
      continue;
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("radius", Float.valueOf(0.25F));
      localHashMap.put("whitenmag", Float.valueOf(0.25F));
      continue;
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("radius", Float.valueOf(0.3125F));
      localHashMap.put("whitenmag", Float.valueOf(0.25F));
      continue;
      localHashMap.put("opttype", Float.valueOf(1.0F));
      localHashMap.put("radius", Float.valueOf(0.375F));
      localHashMap.put("whitenmag", Float.valueOf(0.25F));
    }
  }
  
  public CameraFilterParamSDK copyParam()
  {
    AppMethodBeat.i(83471);
    CameraFilterParamSDK localCameraFilterParamSDK = new CameraFilterParamSDK();
    localCameraFilterParamSDK.smoothLevel = this.smoothLevel;
    localCameraFilterParamSDK.effectIndex = this.effectIndex;
    localCameraFilterParamSDK.filterId = this.filterId;
    localCameraFilterParamSDK.flagId = this.flagId;
    localCameraFilterParamSDK.isBlurOpen = this.isBlurOpen;
    localCameraFilterParamSDK.faceCenterX = this.faceCenterX;
    localCameraFilterParamSDK.faceCenterY = this.faceCenterY;
    localCameraFilterParamSDK.faceWidth = this.faceWidth;
    localCameraFilterParamSDK.faceRotation = this.faceRotation;
    localCameraFilterParamSDK.isBlackOpen = this.isBlackOpen;
    AppMethodBeat.o(83471);
    return localCameraFilterParamSDK;
  }
  
  public void enableLowEnergy(boolean paramBoolean)
  {
    this.lowEnergy = paramBoolean;
  }
  
  public Map<String, Object> getBlurMap(boolean paramBoolean)
  {
    AppMethodBeat.i(83467);
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
      AppMethodBeat.o(83467);
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
    AppMethodBeat.i(83472);
    PointF localPointF = new PointF(this.faceCenterX, this.faceCenterY);
    switch (this.faceRotation)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(83472);
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
    AppMethodBeat.i(83468);
    if (this.lowEnergy)
    {
      localMap = getSmoothMapLowEnergy();
      AppMethodBeat.o(83468);
      return localMap;
    }
    Map localMap = getSmoothMapCommon();
    AppMethodBeat.o(83468);
    return localMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.model.CameraFilterParamSDK
 * JD-Core Version:    0.7.0.1
 */