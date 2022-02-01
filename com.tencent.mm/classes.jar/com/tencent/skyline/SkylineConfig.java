package com.tencent.skyline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/skyline/SkylineConfig;", "", "()V", "id", "", "getId", "()I", "setId", "(I)V", "windowHeight", "", "getWindowHeight", "()D", "setWindowHeight", "(D)V", "windowWidth", "getWindowWidth", "setWindowWidth", "toMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "skyline_android_lib_release"}, k=1, mv={1, 1, 16})
public final class SkylineConfig
{
  private int id;
  private double windowHeight;
  private double windowWidth;
  
  public final int getId()
  {
    return this.id;
  }
  
  public final double getWindowHeight()
  {
    return this.windowHeight;
  }
  
  public final double getWindowWidth()
  {
    return this.windowWidth;
  }
  
  public final void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public final void setWindowHeight(double paramDouble)
  {
    this.windowHeight = paramDouble;
  }
  
  public final void setWindowWidth(double paramDouble)
  {
    this.windowWidth = paramDouble;
  }
  
  public final HashMap<String, Object> toMap()
  {
    AppMethodBeat.i(210688);
    HashMap localHashMap = new HashMap();
    localHashMap.put("id", Integer.valueOf(this.id));
    localHashMap.put("windowWidth", Double.valueOf(this.windowWidth));
    localHashMap.put("windowHeight", Double.valueOf(this.windowHeight));
    AppMethodBeat.o(210688);
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.skyline.SkylineConfig
 * JD-Core Version:    0.7.0.1
 */