package com.tencent.ytcommon.auth;

import java.io.IOException;

final class Auth$4
  implements Runnable
{
  Auth$4(String paramString) {}
  
  public final void run()
  {
    try
    {
      HttpUtil.post("https://api.youtu.qq.com/auth/report", this.val$data, Auth.access$400());
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ytcommon.auth.Auth.4
 * JD-Core Version:    0.7.0.1
 */