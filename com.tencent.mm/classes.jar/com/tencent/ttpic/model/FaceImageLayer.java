package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.FaceOffUtil.FEATURE_TYPE;
import java.util.List;

public class FaceImageLayer
{
  public double antiWrinkle;
  public double blendAlpha;
  public String cosFunTemplateFile;
  public double distortionAlpha;
  public List<DistortionItem> distortionList;
  public List<Double> extraDistortionAlphaArray;
  public List<List<Double>> extraFacePointsArray;
  public List<Double> faceColorRange;
  public List<Double> faceMaskFacePoint;
  public String faceMaskImagePath;
  public List<Integer> faceTriangle;
  public FaceOffUtil.FEATURE_TYPE featureType = FaceOffUtil.FEATURE_TYPE.CRAZY_FACE;
  public double height;
  public List<Double> imageFaceColor;
  public List<Double> imageFaceColor2;
  public List<Double> imageFacePoint;
  public String imagePath;
  public int type;
  public double width;
  public double x;
  public double y;
  
  public int getVersion()
  {
    AppMethodBeat.i(83486);
    if ((this.imageFaceColor2 != null) && (this.imageFaceColor2.size() >= 12) && (this.faceColorRange != null) && (this.faceColorRange.size() >= 2))
    {
      AppMethodBeat.o(83486);
      return 2;
    }
    AppMethodBeat.o(83486);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.model.FaceImageLayer
 * JD-Core Version:    0.7.0.1
 */