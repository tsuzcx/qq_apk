package com.tencent.youtu.ytcommon.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import java.util.TimerTask;

final class YTAuthJNIInterface$2
  extends TimerTask
{
  public final void run()
  {
    AppMethodBeat.i(118064);
    YTLogger.d("log_print_java", "flush in java ");
    YTAuthJNIInterface.access$100();
    AppMethodBeat.o(118064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.auth.YTAuthJNIInterface.2
 * JD-Core Version:    0.7.0.1
 */