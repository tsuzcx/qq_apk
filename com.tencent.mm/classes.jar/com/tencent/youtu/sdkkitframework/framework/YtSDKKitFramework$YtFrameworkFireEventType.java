package com.tencent.youtu.sdkkitframework.framework;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum YtSDKKitFramework$YtFrameworkFireEventType
{
  static
  {
    AppMethodBeat.i(256874);
    YT_EVENT_TRIGGER_BEGIN_LIVENESS = new YtFrameworkFireEventType("YT_EVENT_TRIGGER_BEGIN_LIVENESS", 0);
    YT_EVENT_TRIGGER_CANCEL_LIVENESS = new YtFrameworkFireEventType("YT_EVENT_TRIGGER_CANCEL_LIVENESS", 1);
    $VALUES = new YtFrameworkFireEventType[] { YT_EVENT_TRIGGER_BEGIN_LIVENESS, YT_EVENT_TRIGGER_CANCEL_LIVENESS };
    AppMethodBeat.o(256874);
  }
  
  private YtSDKKitFramework$YtFrameworkFireEventType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.YtSDKKitFramework.YtFrameworkFireEventType
 * JD-Core Version:    0.7.0.1
 */