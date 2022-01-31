package com.tencent.ttpic.json;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.StringWriter;

public class JSONStringer
  extends JSONWriter
{
  public JSONStringer()
  {
    super(new StringWriter());
    AppMethodBeat.i(50181);
    AppMethodBeat.o(50181);
  }
  
  public String toString()
  {
    AppMethodBeat.i(50182);
    if (this.mode == 'd')
    {
      String str = this.writer.toString();
      AppMethodBeat.o(50182);
      return str;
    }
    AppMethodBeat.o(50182);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ttpic.json.JSONStringer
 * JD-Core Version:    0.7.0.1
 */