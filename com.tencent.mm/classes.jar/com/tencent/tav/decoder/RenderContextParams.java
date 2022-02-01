package com.tencent.tav.decoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class RenderContextParams
{
  private HashMap<String, Object> params;
  
  public RenderContextParams()
  {
    AppMethodBeat.i(216046);
    this.params = new HashMap();
    AppMethodBeat.o(216046);
  }
  
  public Object getParam(String paramString)
  {
    AppMethodBeat.i(216062);
    paramString = this.params.get(paramString);
    AppMethodBeat.o(216062);
    return paramString;
  }
  
  public void putParam(String paramString, Object paramObject)
  {
    AppMethodBeat.i(216054);
    this.params.put(paramString, paramObject);
    AppMethodBeat.o(216054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tav.decoder.RenderContextParams
 * JD-Core Version:    0.7.0.1
 */