package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum VideoMaterialUtil$EXPRESSION_ITEM_FILED
{
  public String value;
  
  static
  {
    AppMethodBeat.i(84074);
    EXPRESSION_TIME = new EXPRESSION_ITEM_FILED("EXPRESSION_TIME", 0, "expressionTime");
    EXPRESSION_ID = new EXPRESSION_ITEM_FILED("EXPRESSION_ID", 1, "expressionID");
    EXPRESSION_FEAT_SIZE = new EXPRESSION_ITEM_FILED("EXPRESSION_FEAT_SIZE", 2, "expressionFeatSize");
    EXPRESSION_FEAT = new EXPRESSION_ITEM_FILED("EXPRESSION_FEAT", 3, "expressionFeat");
    EXPRESSION_ANGLE = new EXPRESSION_ITEM_FILED("EXPRESSION_ANGLE", 4, "expressionAngle");
    SCORE_IMAGE_ID = new EXPRESSION_ITEM_FILED("SCORE_IMAGE_ID", 5, "scoreImageID");
    EXPRESSION_WEIGHT = new EXPRESSION_ITEM_FILED("EXPRESSION_WEIGHT", 6, "expressionWeight");
    $VALUES = new EXPRESSION_ITEM_FILED[] { EXPRESSION_TIME, EXPRESSION_ID, EXPRESSION_FEAT_SIZE, EXPRESSION_FEAT, EXPRESSION_ANGLE, SCORE_IMAGE_ID, EXPRESSION_WEIGHT };
    AppMethodBeat.o(84074);
  }
  
  private VideoMaterialUtil$EXPRESSION_ITEM_FILED(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialUtil.EXPRESSION_ITEM_FILED
 * JD-Core Version:    0.7.0.1
 */