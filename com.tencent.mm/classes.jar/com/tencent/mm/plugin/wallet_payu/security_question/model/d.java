package com.tencent.mm.plugin.wallet_payu.security_question.model;

import com.tencent.mm.wallet_core.e.a.a;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends a
{
  public ArrayList<PayUSecurityQuestion> qOO;
  
  public d()
  {
    D(new HashMap());
  }
  
  public final void a(int paramInt, String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.qOO = new ArrayList();
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
            this.qOO.add(paramJSONObject);
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public final int bUM()
  {
    return 11;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.security_question.model.d
 * JD-Core Version:    0.7.0.1
 */