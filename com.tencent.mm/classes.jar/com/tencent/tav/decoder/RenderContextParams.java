package com.tencent.tav.decoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class RenderContextParams
{
  private HashMap<String, Object> params;
  
  public RenderContextParams()
  {
    AppMethodBeat.i(201846);
    this.params = new HashMap();
    AppMethodBeat.o(201846);
  }
  
  public Object getParam(String paramString)
  {
    AppMethodBeat.i(201848);
    paramString = this.params.get(paramString);
    AppMethodBeat.o(201848);
    return paramString;
  }
  
  public void putParam(String paramString, Object paramObject)
  {
    AppMethodBeat.i(201847);
    this.params.put(paramString, paramObject);
    AppMethodBeat.o(201847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.decoder.RenderContextParams
 * JD-Core Version:    0.7.0.1
 */