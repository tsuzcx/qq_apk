package com.tencent.tav.decoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class RenderContextParams
{
  private HashMap<String, Object> params;
  
  public RenderContextParams()
  {
    AppMethodBeat.i(197907);
    this.params = new HashMap();
    AppMethodBeat.o(197907);
  }
  
  public Object getParam(String paramString)
  {
    AppMethodBeat.i(197909);
    paramString = this.params.get(paramString);
    AppMethodBeat.o(197909);
    return paramString;
  }
  
  public void putParam(String paramString, Object paramObject)
  {
    AppMethodBeat.i(197908);
    this.params.put(paramString, paramObject);
    AppMethodBeat.o(197908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tav.decoder.RenderContextParams
 * JD-Core Version:    0.7.0.1
 */