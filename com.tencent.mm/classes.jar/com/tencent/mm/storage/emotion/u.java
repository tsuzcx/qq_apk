package com.tencent.mm.storage.emotion;

import org.json.JSONException;
import org.json.JSONObject;

public final class u
{
  public long dXA;
  public String key;
  public int position;
  public int uDy;
  
  public final JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("key", this.key);
      localJSONObject.put("position", this.position);
      localJSONObject.put("use_count", this.uDy);
      localJSONObject.put("last_time", this.dXA);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.u
 * JD-Core Version:    0.7.0.1
 */