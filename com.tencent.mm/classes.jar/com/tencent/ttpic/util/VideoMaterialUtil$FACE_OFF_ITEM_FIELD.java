package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum VideoMaterialUtil$FACE_OFF_ITEM_FIELD
{
  public String value;
  
  static
  {
    AppMethodBeat.i(84095);
    ID = new FACE_OFF_ITEM_FIELD("ID", 0, "id");
    FACE_EXCHANGE_IMAGE = new FACE_OFF_ITEM_FIELD("FACE_EXCHANGE_IMAGE", 1, "faceExchangeImage");
    BLEND_ALPHA = new FACE_OFF_ITEM_FIELD("BLEND_ALPHA", 2, "blendAlpha");
    FEATURE_TYPE = new FACE_OFF_ITEM_FIELD("FEATURE_TYPE", 3, "featureType");
    GRAY_SCALE = new FACE_OFF_ITEM_FIELD("GRAY_SCALE", 4, "grayScale");
    BLEND_MODE = new FACE_OFF_ITEM_FIELD("BLEND_MODE", 5, "blendMode");
    PERSON_ID = new FACE_OFF_ITEM_FIELD("PERSON_ID", 6, "personID");
    RANDOM_GROUP_NUM = new FACE_OFF_ITEM_FIELD("RANDOM_GROUP_NUM", 7, "randomGroupNum");
    FACE_POINTS = new FACE_OFF_ITEM_FIELD("FACE_POINTS", 8, "facePoints");
    IRIS_IMAGE = new FACE_OFF_ITEM_FIELD("IRIS_IMAGE", 9, "eyeIrisImage");
    FRAME_TYPE = new FACE_OFF_ITEM_FIELD("FRAME_TYPE", 10, "frameType");
    FRAMES = new FACE_OFF_ITEM_FIELD("FRAMES", 11, "frames");
    FRAME_DURATION = new FACE_OFF_ITEM_FIELD("FRAME_DURATION", 12, "frameDuration");
    TRIGGER_TYPE = new FACE_OFF_ITEM_FIELD("TRIGGER_TYPE", 13, "triggerType");
    $VALUES = new FACE_OFF_ITEM_FIELD[] { ID, FACE_EXCHANGE_IMAGE, BLEND_ALPHA, FEATURE_TYPE, GRAY_SCALE, BLEND_MODE, PERSON_ID, RANDOM_GROUP_NUM, FACE_POINTS, IRIS_IMAGE, FRAME_TYPE, FRAMES, FRAME_DURATION, TRIGGER_TYPE };
    AppMethodBeat.o(84095);
  }
  
  private VideoMaterialUtil$FACE_OFF_ITEM_FIELD(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialUtil.FACE_OFF_ITEM_FIELD
 * JD-Core Version:    0.7.0.1
 */