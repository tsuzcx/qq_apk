package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public final class f$b
{
  public String desc;
  public String ffD;
  public String tXS;
  public String title;
  
  public f$b() {}
  
  public f$b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.title = paramString1;
    this.desc = paramString2;
    this.ffD = paramString3;
    this.tXS = paramString4;
  }
  
  public final JSONObject getJSONObject()
  {
    AppMethodBeat.i(142367);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("title", this.title);
      localJSONObject.put("desc", this.desc);
      localJSONObject.put("iconurl", this.ffD);
      localJSONObject.put("iconmd5", this.tXS);
      AppMethodBeat.o(142367);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.e("MicroMsg.NetSceneGetHbRefundConfig", "HbRefundTimeParcelable getJSONObjectString() Exception: %s", new Object[] { localJSONException.getMessage() });
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(142366);
    String str = "HbRefundTimeParcelable{title='" + this.title + '\'' + ", desc='" + this.desc + '\'' + ", iconurl='" + this.ffD + '\'' + ", iconmd5='" + this.tXS + '\'' + '}';
    AppMethodBeat.o(142366);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.f.b
 * JD-Core Version:    0.7.0.1
 */