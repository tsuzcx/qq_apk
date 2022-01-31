package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum VideoMaterialUtil$FACE_MESH_ITEM_LIST
{
  public String value;
  
  static
  {
    AppMethodBeat.i(84089);
    ID = new FACE_MESH_ITEM_LIST("ID", 0, "id");
    PERSON_ID = new FACE_MESH_ITEM_LIST("PERSON_ID", 1, "personID");
    FRAMES = new FACE_MESH_ITEM_LIST("FRAMES", 2, "frames");
    $VALUES = new FACE_MESH_ITEM_LIST[] { ID, PERSON_ID, FRAMES };
    AppMethodBeat.o(84089);
  }
  
  private VideoMaterialUtil$FACE_MESH_ITEM_LIST(String paramString)
  {
    this.value = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialUtil.FACE_MESH_ITEM_LIST
 * JD-Core Version:    0.7.0.1
 */