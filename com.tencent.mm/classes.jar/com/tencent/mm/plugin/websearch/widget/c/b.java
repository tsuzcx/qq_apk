package com.tencent.mm.plugin.websearch.widget.c;

import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends a
{
  private String cbd;
  private int x;
  private int y;
  
  public b(int paramInt1, int paramInt2, String paramString)
  {
    this.x = paramInt1;
    this.y = paramInt2;
    this.cbd = paramString;
  }
  
  public final String caj()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("x", this.x);
      localJSONObject.put("y", this.y);
      localJSONObject.put("eventId", this.cbd);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        y.printErrStackTrace("onTap", localJSONException, "", new Object[0]);
      }
    }
  }
  
  public final String getName()
  {
    return "onTap";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.c.b
 * JD-Core Version:    0.7.0.1
 */