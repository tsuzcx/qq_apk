package io.flutter.plugin.platform;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lio/flutter/plugin/platform/SkylineTextureInfo;", "", "width", "", "height", "(II)V", "getHeight", "()I", "setHeight", "(I)V", "getWidth", "setWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "skyline_android_lib_release"}, k=1, mv={1, 1, 16})
public final class SkylineTextureInfo
{
  private int height;
  private int width;
  
  public SkylineTextureInfo(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public final int component1()
  {
    return this.width;
  }
  
  public final int component2()
  {
    return this.height;
  }
  
  public final SkylineTextureInfo copy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(189938);
    SkylineTextureInfo localSkylineTextureInfo = new SkylineTextureInfo(paramInt1, paramInt2);
    AppMethodBeat.o(189938);
    return localSkylineTextureInfo;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof SkylineTextureInfo))
      {
        paramObject = (SkylineTextureInfo)paramObject;
        if ((this.width != paramObject.width) || (this.height != paramObject.height)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int getHeight()
  {
    return this.height;
  }
  
  public final int getWidth()
  {
    return this.width;
  }
  
  public final int hashCode()
  {
    return this.width * 31 + this.height;
  }
  
  public final void setHeight(int paramInt)
  {
    this.height = paramInt;
  }
  
  public final void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(189946);
    String str = "SkylineTextureInfo(width=" + this.width + ", height=" + this.height + ")";
    AppMethodBeat.o(189946);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     io.flutter.plugin.platform.SkylineTextureInfo
 * JD-Core Version:    0.7.0.1
 */