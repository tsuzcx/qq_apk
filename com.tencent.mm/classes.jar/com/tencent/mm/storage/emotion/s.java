package com.tencent.mm.storage.emotion;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

public final class s
{
  public long ePF;
  public String key;
  public int position;
  public int yQf;
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(62891);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("key", this.key);
      localJSONObject.put("position", this.position);
      localJSONObject.put("use_count", this.yQf);
      localJSONObject.put("last_time", this.ePF);
      AppMethodBeat.o(62891);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      AppMethodBeat.o(62891);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.s
 * JD-Core Version:    0.7.0.1
 */