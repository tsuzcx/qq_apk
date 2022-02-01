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
  public ArrayList<PayUSecurityQuestion> DLu;
  
  public d()
  {
    AppMethodBeat.i(72213);
    setRequestData(new HashMap());
    AppMethodBeat.o(72213);
  }
  
  public final int eIr()
  {
    return 11;
  }
  
  public final void onGYNetEnd(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(72214);
    if (paramJSONObject != null)
    {
      this.DLu = new ArrayList();
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
            this.DLu.add(paramJSONObject);
          }
          paramInt += 1;
        }
      }
    }
    AppMethodBeat.o(72214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.model.d
 * JD-Core Version:    0.7.0.1
 */