package com.tencent.youtu.ytcommon.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.TimerTask;

final class YTAuthJNIInterface$1
  extends TimerTask
{
  public final void run()
  {
    AppMethodBeat.i(118063);
    String str = YTAuthJNIInterface.access$000();
    if (str != "") {
      YTAuthJNIInterface.report(str);
    }
    AppMethodBeat.o(118063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.auth.YTAuthJNIInterface.1
 * JD-Core Version:    0.7.0.1
 */