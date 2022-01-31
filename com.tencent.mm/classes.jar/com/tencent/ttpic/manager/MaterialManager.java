package com.tencent.ttpic.manager;

import com.tencent.ttpic.model.VideoMaterial;

public enum MaterialManager
{
  INSTANCE;
  
  private VideoMaterial material;
  
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
    if (paramVideoMaterial == null) {
      return;
    }
    if (paramVideoMaterial.getDataPath().equals("None"))
    {
      this.material = null;
      return;
    }
    if (this.material != null)
    {
      if ((paramVideoMaterial.getId() == null) || (this.material.getId() == null) || (!this.material.getId().equals(paramVideoMaterial.getId()))) {
        break label76;
      }
      RandomGroupManager.getInstance().clearCurValue();
    }
    for (;;)
    {
      this.material = paramVideoMaterial;
      return;
      label76:
      RandomGroupManager.getInstance().clearAll();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.manager.MaterialManager
 * JD-Core Version:    0.7.0.1
 */