package com.tencent.tav.decoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class RenderContextParams
{
  private HashMap<String, Object> params;
  
  public RenderContextParams()
  {
    AppMethodBeat.i(191262);
    this.params = new HashMap();
    AppMethodBeat.o(191262);
  }
  
  public Object getParam(String paramString)
  {
    AppMethodBeat.i(191264);
    paramString = this.params.get(paramString);
    AppMethodBeat.o(191264);
    return paramString;
  }
  
  public void putParam(String paramString, Object paramObject)
  {
    AppMethodBeat.i(191263);
    this.params.put(paramString, paramObject);
    AppMethodBeat.o(191263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.decoder.RenderContextParams
 * JD-Core Version:    0.7.0.1
 */