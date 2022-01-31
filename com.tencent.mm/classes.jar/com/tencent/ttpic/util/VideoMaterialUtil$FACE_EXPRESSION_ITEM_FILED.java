package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum VideoMaterialUtil$FACE_EXPRESSION_ITEM_FILED
{
  public String value;
  
  static
  {
    AppMethodBeat.i(84086);
    ID = new FACE_EXPRESSION_ITEM_FILED("ID", 0, "id");
    VIDEO_ID = new FACE_EXPRESSION_ITEM_FILED("VIDEO_ID", 1, "videoID");
    FRAME_DURATION = new FACE_EXPRESSION_ITEM_FILED("FRAME_DURATION", 2, "frameDuration");
    FRAMES = new FACE_EXPRESSION_ITEM_FILED("FRAMES", 3, "frames");
    AUDIO_ID = new FACE_EXPRESSION_ITEM_FILED("AUDIO_ID", 4, "audioID");
    CANVAS_SIZE = new FACE_EXPRESSION_ITEM_FILED("CANVAS_SIZE", 5, "canvasSize");
    CANVAS_RESIZE_MODE = new FACE_EXPRESSION_ITEM_FILED("CANVAS_RESIZE_MODE", 6, "canvasResizeMode");
    SCORE_IMAGE_ID = new FACE_EXPRESSION_ITEM_FILED("SCORE_IMAGE_ID", 7, "scoreImageID");
    EXPRESSION_NUMBER = new FACE_EXPRESSION_ITEM_FILED("EXPRESSION_NUMBER", 8, "expressionNumber");
    EXPRESSION_LIST = new FACE_EXPRESSION_ITEM_FILED("EXPRESSION_LIST", 9, "expressionList");
    CANVAS_ITEM_LIST = new FACE_EXPRESSION_ITEM_FILED("CANVAS_ITEM_LIST", 10, "canvasItemList");
    $VALUES = new FACE_EXPRESSION_ITEM_FILED[] { ID, VIDEO_ID, FRAME_DURATION, FRAMES, AUDIO_ID, CANVAS_SIZE, CANVAS_RESIZE_MODE, SCORE_IMAGE_ID, EXPRESSION_NUMBER, EXPRESSION_LIST, CANVAS_ITEM_LIST };
    AppMethodBeat.o(84086);
  }
  
  private VideoMaterialUtil$FACE_EXPRESSION_ITEM_FILED(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED
 * JD-Core Version:    0.7.0.1
 */