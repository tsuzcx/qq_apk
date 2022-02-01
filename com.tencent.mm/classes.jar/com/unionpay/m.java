package com.unionpay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.unionpay.utils.UPUtils;
import java.util.Iterator;
import org.json.JSONObject;

final class m
  implements x
{
  m(UPPayWapActivity paramUPPayWapActivity) {}
  
  public final void a(String paramString, y paramy)
  {
    AppMethodBeat.i(207253);
    try
    {
      paramString = new JSONObject(paramString);
      Iterator localIterator = paramString.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        UPUtils.a(this.aisR, paramString.getString(str), str);
      }
      if (paramy == null) {
        break label102;
      }
    }
    catch (Exception paramString)
    {
      if (paramy != null) {
        paramy.a(UPPayWapActivity.bU("1", paramString.getMessage(), null));
      }
      AppMethodBeat.o(207253);
      return;
    }
    paramy.a(UPPayWapActivity.bU("0", "success", null));
    label102:
    AppMethodBeat.o(207253);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.unionpay.m
 * JD-Core Version:    0.7.0.1
 */