package com.tencent.mm.plugin.wallet_payu.security_question.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends a
{
  public ArrayList<PayUSecurityQuestion> uDV;
  
  public d()
  {
    AppMethodBeat.i(48572);
    setRequestData(new HashMap());
    AppMethodBeat.o(48572);
  }
  
  public final int cTa()
  {
    return 11;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(48573);
    if (paramJSONObject != null)
    {
      this.uDV = new ArrayList();
      paramString = paramJSONObject.optJSONArray("security_question_list");
      if (paramString != null)
      {
        paramInt = 0;
        while (paramInt < paramString.length())
        {
          paramJSONObject = paramString.optJSONObject(paramInt);
          if (paramJSONObject != null)
          {
            paramJSONObject = new PayUSecurityQuestion(paramJSONObject.optString("id"), paramJSONObject.optString("description"));
            this.uDV.add(paramJSONObject);
          }
          paramInt += 1;
        }
      }
    }
    AppMethodBeat.o(48573);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.model.d
 * JD-Core Version:    0.7.0.1
 */