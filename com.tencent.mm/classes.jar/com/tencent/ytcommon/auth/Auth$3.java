package com.tencent.ytcommon.auth;

final class Auth$3
  implements HttpUtil.HttpResponseListener
{
  public final void onFail(int paramInt)
  {
    try
    {
      Log.d("log_print_java", "http request error : " + paramInt);
      Log.d("log_print_java", "handle: " + Auth.access$200());
      Auth.access$300(Auth.access$200(), null);
      return;
    }
    catch (Exception localException) {}
  }
  
  public final void onSuccess(String paramString)
  {
    try
    {
      Log.d("log_print_java", "response: " + paramString);
      Log.d("log_print_java", "handle: " + Auth.access$200());
      Auth.access$300(Auth.access$200(), paramString);
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ytcommon.auth.Auth.3
 * JD-Core Version:    0.7.0.1
 */