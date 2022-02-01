package com.tencent.youtu.sdkkitframework.framework;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.util.HashMap;

public class TimeoutState
  extends YtFSMBaseState
{
  public void enter()
  {
    AppMethodBeat.i(218129);
    super.enter();
    YtFSM.getInstance().sendFSMEvent(new HashMap() {});
    YtFSM.getInstance().transitNow(YtSDKKitCommon.StateNameHelper.classNameOfState(YtSDKKitCommon.StateNameHelper.StateClassName.IDLE_STATE));
    AppMethodBeat.o(218129);
  }
  
  public void enterFirst() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.framework.TimeoutState
 * JD-Core Version:    0.7.0.1
 */