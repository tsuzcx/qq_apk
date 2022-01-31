package com.tencent.ttpic.model;

import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import java.util.List;

public class VideoMaterial$FaceImageLayer
{
  public double blendAlpha;
  public double distortionAlpha;
  public List<DistortionItem> distortionList;
  public List<Double> faceMaskFacePoint;
  public String faceMaskImagePath;
  public List<Integer> faceTriangle;
  public FaceOffUtil.FEATURE_TYPE featureType = FaceOffUtil.FEATURE_TYPE.CRAZY_FACE;
  public double height;
  public List<Double> imageFaceColor;
  public List<Double> imageFacePoint;
  public String imagePath;
  public int type;
  public double width;
  public double x;
  public double y;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.model.VideoMaterial.FaceImageLayer
 * JD-Core Version:    0.7.0.1
 */