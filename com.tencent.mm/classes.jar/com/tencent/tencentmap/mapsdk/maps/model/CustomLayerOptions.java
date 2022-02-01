package com.tencent.tencentmap.mapsdk.maps.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class CustomLayerOptions
{
  private String mLayerId;
  private String mLayerVersion;
  
  public String getLayerId()
  {
    return this.mLayerId;
  }
  
  public CustomLayerOptions layerId(String paramString)
  {
    AppMethodBeat.i(173135);
    if (!TextUtils.isEmpty(paramString)) {
      this.mLayerId = paramString;
    }
    AppMethodBeat.o(173135);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.CustomLayerOptions
 * JD-Core Version:    0.7.0.1
 */