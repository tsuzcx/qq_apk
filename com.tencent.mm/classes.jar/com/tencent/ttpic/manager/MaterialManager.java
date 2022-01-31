package com.tencent.ttpic.manager;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.model.VideoMaterial;

public enum MaterialManager
{
  private VideoMaterial material;
  
  static
  {
    AppMethodBeat.i(83436);
    INSTANCE = new MaterialManager("INSTANCE", 0);
    $VALUES = new MaterialManager[] { INSTANCE };
    AppMethodBeat.o(83436);
  }
  
  private MaterialManager() {}
  
  public static MaterialManager getInstance()
  {
    return INSTANCE;
  }
  
  public final VideoMaterial getCurrentMaterial()
  {
    return this.material;
  }
  
  public final void setCurrentMaterial(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(83435);
    if (paramVideoMaterial == null)
    {
      AppMethodBeat.o(83435);
      return;
    }
    if ((this.material != null) && (this.material.getId() != null))
    {
      if (!this.material.getId().equals(paramVideoMaterial.getId())) {
        break label66;
      }
      RandomGroupManager.getInstance().clearCurValue();
    }
    for (;;)
    {
      this.material = paramVideoMaterial;
      AppMethodBeat.o(83435);
      return;
      label66:
      RandomGroupManager.getInstance().clearAll();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.manager.MaterialManager
 * JD-Core Version:    0.7.0.1
 */