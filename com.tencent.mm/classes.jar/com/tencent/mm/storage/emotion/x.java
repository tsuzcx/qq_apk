package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

public final class x
{
  public int admN;
  public String key;
  public long mJI;
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(105153);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("key", this.key);
      localJSONObject.put("use_count", this.admN);
      localJSONObject.put("last_time", this.mJI);
      AppMethodBeat.o(105153);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(105153);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.x
 * JD-Core Version:    0.7.0.1
 */