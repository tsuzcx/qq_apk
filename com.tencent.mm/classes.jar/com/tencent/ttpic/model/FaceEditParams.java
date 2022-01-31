package com.tencent.ttpic.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class FaceEditParams
  implements Cloneable
{
  public HashMap<String, Double> mParamsMap;
  
  public FaceEditParams()
  {
    AppMethodBeat.i(83482);
    this.mParamsMap = new HashMap();
    this.mParamsMap.put("BEAUTY_WHITE", Double.valueOf(0.2D));
    this.mParamsMap.put("BEAUTY_SMOOTH", Double.valueOf(0.5D));
    this.mParamsMap.put("BEAUTY_COMPLEXION", Double.valueOf(0.5D));
    this.mParamsMap.put("BEAUTY_ANTISPOT", Double.valueOf(1.0D));
    this.mParamsMap.put("BEAUTY_EYEPOUCH", Double.valueOf(0.0D));
    this.mParamsMap.put("BEAUTY_TOOTH", Double.valueOf(0.0D));
    this.mParamsMap.put("BEAUTY_EYELIGHT", Double.valueOf(0.7D));
    this.mParamsMap.put("BEAUTY_GLOSSY", Double.valueOf(0.0D));
    AppMethodBeat.o(83482);
  }
  
  public FaceEditParams clone()
  {
    AppMethodBeat.i(83484);
    FaceEditParams localFaceEditParams = new FaceEditParams();
    Iterator localIterator = this.mParamsMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      double d = ((Double)this.mParamsMap.get(str)).doubleValue();
      localFaceEditParams.mParamsMap.put(str, Double.valueOf(d));
    }
    AppMethodBeat.o(83484);
    return localFaceEditParams;
  }
  
  public void updateFaceParam(String paramString, double paramDouble)
  {
    AppMethodBeat.i(83483);
    if (this.mParamsMap.containsKey(paramString)) {
      this.mParamsMap.put(paramString, Double.valueOf(paramDouble));
    }
    AppMethodBeat.o(83483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.model.FaceEditParams
 * JD-Core Version:    0.7.0.1
 */