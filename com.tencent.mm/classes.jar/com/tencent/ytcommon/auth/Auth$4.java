package com.tencent.ytcommon.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

final class Auth$4
  implements Runnable
{
  Auth$4(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(5);
    try
    {
      HttpUtil.post("https://api.youtu.qq.com/auth/report", this.val$data, Auth.access$400());
      AppMethodBeat.o(5);
      return;
    }
    catch (IOException localIOException)
    {
      AppMethodBeat.o(5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ytcommon.auth.Auth.4
 * JD-Core Version:    0.7.0.1
 */