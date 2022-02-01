package com.tencent.mm.plugin.websearch.widget.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends a
{
  private String dAA;
  private int x;
  private int y;
  
  public b(int paramInt1, int paramInt2, String paramString)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.dAA = paramString;
  }
  
  public final String eiD()
  {
    AppMethodBeat.i(116656);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("x", this.x);
      ((JSONObject)localObject).put("y", this.y);
      ((JSONObject)localObject).put("eventId", this.dAA);
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(116656);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ad.printErrStackTrace("onTap", localJSONException, "", new Object[0]);
      }
    }
  }
  
  public final String getName()
  {
    return "onTap";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.b
 * JD-Core Version:    0.7.0.1
 */