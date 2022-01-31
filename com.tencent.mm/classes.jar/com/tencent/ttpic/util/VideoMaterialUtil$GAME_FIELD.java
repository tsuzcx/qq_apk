package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum VideoMaterialUtil$GAME_FIELD
{
  public final String value;
  
  static
  {
    AppMethodBeat.i(84110);
    GAME_NAME = new GAME_FIELD("GAME_NAME", 0, "gameName");
    ANIM_NAMES = new GAME_FIELD("ANIM_NAMES", 1, "animNames");
    ANIM_DEFAULT_ROTATE = new GAME_FIELD("ANIM_DEFAULT_ROTATE", 2, "animDefaultRotate");
    ANIM_NODE_NAMES = new GAME_FIELD("ANIM_NODE_NAMES", 3, "animNodeNames");
    RUNNING_ANIM_NAME = new GAME_FIELD("RUNNING_ANIM_NAME", 4, "runningAnimName");
    RUNNING_ANIM_DEFAULT_ROTATE = new GAME_FIELD("RUNNING_ANIM_DEFAULT_ROTATE", 5, "runningAnimDefaultRotate");
    FOV = new GAME_FIELD("FOV", 6, "fov");
    NOT_FLATTEN_EAR = new GAME_FIELD("NOT_FLATTEN_EAR", 7, "notFlattenEar");
    NOT_FLATTEN_NOSE = new GAME_FIELD("NOT_FLATTEN_NOSE", 8, "notFlattenNose");
    TEXTURE_IMAGES = new GAME_FIELD("TEXTURE_IMAGES", 9, "textureImages");
    $VALUES = new GAME_FIELD[] { GAME_NAME, ANIM_NAMES, ANIM_DEFAULT_ROTATE, ANIM_NODE_NAMES, RUNNING_ANIM_NAME, RUNNING_ANIM_DEFAULT_ROTATE, FOV, NOT_FLATTEN_EAR, NOT_FLATTEN_NOSE, TEXTURE_IMAGES };
    AppMethodBeat.o(84110);
  }
  
  private VideoMaterialUtil$GAME_FIELD(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialUtil.GAME_FIELD
 * JD-Core Version:    0.7.0.1
 */