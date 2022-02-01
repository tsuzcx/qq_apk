package com.tencent.tav.decoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class RenderContextParams
{
  private HashMap<String, Object> params;
  
  public RenderContextParams()
  {
    AppMethodBeat.i(218290);
    this.params = new HashMap();
    AppMethodBeat.o(218290);
  }
  
  public Object getParam(String paramString)
  {
    AppMethodBeat.i(218292);
    paramString = this.params.get(paramString);
    AppMethodBeat.o(218292);
    return paramString;
  }
  
  public void putParam(String paramString, Object paramObject)
  {
    AppMethodBeat.i(218291);
    this.params.put(paramString, paramObject);
    AppMethodBeat.o(218291);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.decoder.RenderContextParams
 * JD-Core Version:    0.7.0.1
 */