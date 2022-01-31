package com.tencent.ytcommon.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TimerTask;

final class Auth$2
  extends TimerTask
{
  public final void run()
  {
    AppMethodBeat.i(2);
    Log.d("log_print_java", "flush in java ");
    Auth.access$100();
    AppMethodBeat.o(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ytcommon.auth.Auth.2
 * JD-Core Version:    0.7.0.1
 */