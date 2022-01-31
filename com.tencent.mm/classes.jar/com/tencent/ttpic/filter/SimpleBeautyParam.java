package com.tencent.ttpic.filter;

import com.tencent.ttpic.config.SimpleBeautyRealConfig.TYPE;
import com.tencent.ttpic.model.DistortParam;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.util.VideoTemplateParser;

public class SimpleBeautyParam
{
  public static final int BEAUTY_TYPE_EYE = 5;
  public static final int BEAUTY_TYPE_NOSE = 6;
  public static final int BEAUTY_TYPE_SMOOTH = 1;
  public static final int BEAUTY_TYPE_VLIAN = 2;
  public static final int BEAUTY_TYPE_WHITEN = 0;
  public static final int BEAUTY_TYPE_XIABA = 4;
  public static final int BEAUTY_TYPE_ZHAILIAN = 3;
  public static final DistortParam EMPTY_PARAM = new DistortParam();
  public DistortParam basic3 = null;
  private String daYanJson = "{\n  \"shaderType\" : 6,\n  \"distortionList\" : [\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.18,\n      \"position\" : 35,\n      \"direction\" : 1\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.18,\n      \"position\" : 45,\n      \"direction\" : 3\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.24,\n      \"position\" : 41,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.24,\n      \"position\" : 51,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 90,\n      \"distortion\" : 3,\n      \"strength\" : 0.14,\n      \"position\" : 37,\n      \"direction\" : 4\n    },\n    {\n      \"radius\" : 90,\n      \"distortion\" : 3,\n      \"strength\" : 0.14,\n      \"position\" : 47,\n      \"direction\" : 4\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.14,\n      \"position\" : 42,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 3,\n      \"strength\" : 0.14,\n      \"position\" : 52,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 1,\n      \"strength\" : 0.15,\n      \"position\" : 43,\n      \"direction\" : 0\n    },\n    {\n      \"radius\" : 80,\n      \"distortion\" : 1,\n      \"strength\" : 0.15,\n      \"position\" : 53,\n      \"direction\" : 0\n    },\n    {\n      \"radius\" : 60,\n      \"distortion\" : 3,\n      \"strength\" : 0.15,\n      \"position\" : 40,\n      \"direction\" : 3\n    },\n    {\n      \"radius\" : 60,\n      \"distortion\" : 3,\n      \"strength\" : 0.15,\n      \"position\" : 50,\n      \"direction\" : 1\n    }\n  ],\n  \"minAppVersion\" : 400\n}";
  public DistortParam eye = null;
  public DistortParam faceShorten = null;
  public DistortParam nose = null;
  public float opttype = 0.0F;
  public float radius = 0.0F;
  public DistortParam vlian = null;
  public float whitenmag = 0.0F;
  private String xiaBaJson = "{\n  \"shaderType\" : 6,\n  \"distortionList\" : [\n    {\n      \"radius\" : 260,\n      \"distortion\" : 3,\n      \"strength\" : 0.15,\n      \"position\" : 5,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 260,\n      \"distortion\" : 3,\n      \"strength\" : 0.15,\n      \"position\" : 13,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 240,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 7,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 240,\n      \"distortion\" : 3,\n      \"strength\" : 0.12,\n      \"position\" : 11,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 300,\n      \"distortion\" : 3,\n      \"strength\" : 0.06,\n      \"position\" : 9,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 300,\n      \"position\" : 69,\n      \"dy\" : 0,\n      \"targetDx\" : 0,\n      \"distortion\" : 3,\n      \"strength\" : 0.02,\n      \"direction\" : 3,\n      \"dx\" : 0,\n      \"targetDy\" : 0\n    }\n  ],\n  \"minAppVersion\" : 400\n}";
  public DistortParam xiaba = null;
  private String zhaiLianJson = "{\n  \"shaderType\" : 6,\n  \"distortionList\" : [\n    {\n      \"radius\" : 200,\n      \"distortion\" : 3,\n      \"strength\" : 0.02,\n      \"position\" : 0,\n      \"direction\" : 3\n    },\n    {\n      \"radius\" : 200,\n      \"distortion\" : 3,\n      \"strength\" : 0.02,\n      \"position\" : 18,\n      \"direction\" : 1\n    },\n    {\n      \"radius\" : 220,\n      \"distortion\" : 3,\n      \"strength\" : 0.04,\n      \"position\" : 2,\n      \"direction\" : 6\n    },\n    {\n      \"radius\" : 220,\n      \"distortion\" : 3,\n      \"strength\" : 0.04,\n      \"position\" : 16,\n      \"direction\" : 5\n    },\n    {\n      \"radius\" : 230,\n      \"distortion\" : 3,\n      \"strength\" : 0.07,\n      \"position\" : 5,\n      \"direction\" : 6\n    },\n    {\n      \"radius\" : 230,\n      \"distortion\" : 3,\n      \"strength\" : 0.07,\n      \"position\" : 13,\n      \"direction\" : 5\n    },\n    {\n      \"radius\" : 230,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 7,\n      \"direction\" : 6\n    },\n    {\n      \"radius\" : 230,\n      \"distortion\" : 3,\n      \"strength\" : 0.08,\n      \"position\" : 11,\n      \"direction\" : 5\n    },\n    {\n      \"radius\" : 320,\n      \"distortion\" : 3,\n      \"strength\" : 0.04,\n      \"position\" : 9,\n      \"direction\" : 2\n    },\n    {\n      \"radius\" : 150,\n      \"position\" : 57,\n      \"dy\" : 0,\n      \"targetDx\" : 0,\n      \"distortion\" : 3,\n      \"strength\" : 0.05,\n      \"direction\" : 3,\n      \"dx\" : 0,\n      \"targetDy\" : 0\n    },\n    {\n      \"radius\" : 150,\n      \"position\" : 61,\n      \"dy\" : 0,\n      \"targetDx\" : 0,\n      \"distortion\" : 3,\n      \"strength\" : 0.05,\n      \"direction\" : 1,\n      \"dx\" : 0,\n      \"targetDy\" : 0\n    },\n    {\n      \"radius\" : 400,\n      \"position\" : 59,\n      \"dy\" : 0,\n      \"targetDx\" : 0,\n      \"distortion\" : 3,\n      \"strength\" : 0.05,\n      \"direction\" : 2,\n      \"dx\" : 0,\n      \"targetDy\" : 0\n    }\n  ],\n  \"minAppVersion\" : 400\n}";
  public DistortParam zhailian = null;
  
  public SimpleBeautyParam(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.eye = initialEyeMesh();
      this.zhailian = initialZhailianMesh();
      this.xiaba = initialXiabaMesh();
      return;
    }
    this.eye = EMPTY_PARAM;
    this.nose = EMPTY_PARAM;
    this.vlian = EMPTY_PARAM;
    this.zhailian = EMPTY_PARAM;
    this.xiaba = EMPTY_PARAM;
    this.faceShorten = EMPTY_PARAM;
    this.basic3 = EMPTY_PARAM;
  }
  
  private DistortParam initialEyeMesh()
  {
    return new DistortParam(100, VideoTemplateParser.parseVideoMaterial(this.daYanJson, null).getDistortionItemList());
  }
  
  private DistortParam initialXiabaMesh()
  {
    return new DistortParam(100, VideoTemplateParser.parseVideoMaterial(this.xiaBaJson, null).getDistortionItemList());
  }
  
  private DistortParam initialZhailianMesh()
  {
    return new DistortParam(100, VideoTemplateParser.parseVideoMaterial(this.zhaiLianJson, null).getDistortionItemList());
  }
  
  public DistortParam getDistortList(int paramInt)
  {
    if (paramInt == SimpleBeautyRealConfig.TYPE.FACE_THIN.value) {
      return this.zhailian;
    }
    if (paramInt == SimpleBeautyRealConfig.TYPE.CHIN.value) {
      return this.xiaba;
    }
    if (paramInt == SimpleBeautyRealConfig.TYPE.EYE.value) {
      return this.eye;
    }
    return EMPTY_PARAM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.filter.SimpleBeautyParam
 * JD-Core Version:    0.7.0.1
 */