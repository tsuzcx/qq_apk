package com.tencent.ytcommon.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class Auth$3
  implements HttpUtil.HttpResponseListener
{
  public final void onFail(int paramInt)
  {
    AppMethodBeat.i(4);
    try
    {
      Log.d("log_print_java", "http request error : ".concat(String.valueOf(paramInt)));
      Log.d("log_print_java", "handle: " + Auth.access$200());
      Auth.access$300(Auth.access$200(), null);
      AppMethodBeat.o(4);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(4);
    }
  }
  
  public final void onSuccess(String paramString)
  {
    AppMethodBeat.i(3);
    try
    {
      Log.d("log_print_java", "response: ".concat(String.valueOf(paramString)));
      Log.d("log_print_java", "handle: " + Auth.access$200());
      Auth.access$300(Auth.access$200(), paramString);
      AppMethodBeat.o(3);
      return;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ytcommon.auth.Auth.3
 * JD-Core Version:    0.7.0.1
 */