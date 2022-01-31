package com.tencent.mm.ui.chatting.k.a;

import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

final class a$b$a$a
  implements a.b.b
{
  public final a.b.c a(Object paramObject, Spannable paramSpannable)
  {
    AppMethodBeat.i(32677);
    String str = paramSpannable.toString().substring(paramSpannable.getSpanStart(paramObject), paramSpannable.getSpanEnd(paramObject));
    try
    {
      paramSpannable = bo.bf(new JSONObject(paramObject.toString()).optString("type"), paramObject.getClass().getName());
      paramObject = paramSpannable;
    }
    catch (JSONException paramSpannable)
    {
      for (;;)
      {
        paramObject = paramObject.getClass().getName();
      }
    }
    paramObject = new a.b.c(str, paramObject);
    AppMethodBeat.o(32677);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.k.a.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */