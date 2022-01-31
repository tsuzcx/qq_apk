package com.tencent.ytcommon.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TimerTask;

final class Auth$1
  extends TimerTask
{
  public final void run()
  {
    AppMethodBeat.i(1);
    String str = Auth.access$000();
    if (str != "") {
      Auth.report(str);
    }
    AppMethodBeat.o(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.ytcommon.auth.Auth.1
 * JD-Core Version:    0.7.0.1
 */