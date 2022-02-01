package com.tencent.mm.plugin.websearch.widget.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends a
{
  private String eventId;
  private int x;
  private int y;
  
  public b(int paramInt1, int paramInt2, String paramString)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.eventId = paramString;
  }
  
  public final String getName()
  {
    return "onTap";
  }
  
  public final String ire()
  {
    AppMethodBeat.i(116656);
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("x", this.x);
      ((JSONObject)localObject).put("y", this.y);
      ((JSONObject)localObject).put("eventId", this.eventId);
      localObject = ((JSONObject)localObject).toString();
      AppMethodBeat.o(116656);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.printErrStackTrace("onTap", localJSONException, "", new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.b
 * JD-Core Version:    0.7.0.1
 */