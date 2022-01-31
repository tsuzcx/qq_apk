package com.tencent.youtu.ytcommon.auth;

import java.util.TimerTask;

final class YTAuthJNIInterface$1
  extends TimerTask
{
  public final void run()
  {
    String str = YTAuthJNIInterface.access$000();
    if (str != "") {
      YTAuthJNIInterface.report(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.youtu.ytcommon.auth.YTAuthJNIInterface.1
 * JD-Core Version:    0.7.0.1
 */