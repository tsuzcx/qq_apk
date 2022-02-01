package com.tencent.youtu.sdkkitframework.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.sdkkitframework.framework.YtFSM;
import com.tencent.youtu.sdkkitframework.framework.YtFSMBaseState;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class YtSDKStats
  extends YtFSMBaseState
{
  private static YtSDKStats ytSDKStats = null;
  private String currentAction;
  private long currentEnterTimeStampMS;
  private String currentState;
  private String preInfo;
  private String preUpdateState;
  private HashMap<String, Object> stateNameMap;
  
  public YtSDKStats()
  {
    AppMethodBeat.i(256635);
    this.stateNameMap = new HashMap();
    AppMethodBeat.o(256635);
  }
  
  public static void clearInstance()
  {
    try
    {
      if (ytSDKStats != null) {
        ytSDKStats = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public static YtSDKStats getInstance()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 43
    //   5: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 20	com/tencent/youtu/sdkkitframework/common/YtSDKStats:ytSDKStats	Lcom/tencent/youtu/sdkkitframework/common/YtSDKStats;
    //   11: ifnonnull +25 -> 36
    //   14: new 2	com/tencent/youtu/sdkkitframework/common/YtSDKStats
    //   17: dup
    //   18: invokespecial 44	com/tencent/youtu/sdkkitframework/common/YtSDKStats:<init>	()V
    //   21: astore_0
    //   22: aload_0
    //   23: putstatic 20	com/tencent/youtu/sdkkitframework/common/YtSDKStats:ytSDKStats	Lcom/tencent/youtu/sdkkitframework/common/YtSDKStats;
    //   26: ldc 43
    //   28: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: ldc 2
    //   33: monitorexit
    //   34: aload_0
    //   35: areturn
    //   36: getstatic 20	com/tencent/youtu/sdkkitframework/common/YtSDKStats:ytSDKStats	Lcom/tencent/youtu/sdkkitframework/common/YtSDKStats;
    //   39: astore_0
    //   40: ldc 43
    //   42: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: goto -14 -> 31
    //   48: astore_0
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   21	19	0	localYtSDKStats	YtSDKStats
    //   48	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	31	48	finally
    //   36	45	48	finally
  }
  
  public static String getNowTimeStamp()
  {
    AppMethodBeat.i(256653);
    long l = System.currentTimeMillis();
    AppMethodBeat.o(256653);
    return String.valueOf(l);
  }
  
  private void makeReport(String paramString1, String paramString2, HashMap<String, Object> paramHashMap, String paramString3, String paramString4)
  {
    AppMethodBeat.i(256651);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("state_id", paramString1);
    localHashMap2.put("state_action", paramString2);
    if (paramHashMap != null) {
      localHashMap2.put("state_error", paramHashMap);
    }
    if (paramString3 != null) {
      localHashMap2.put("state_cost", paramString3);
    }
    if (paramString4 != null) {
      localHashMap2.put("state_info", paramString4);
    }
    localHashMap1.put("state_stats", localHashMap2);
    sendStateEvent(localHashMap1);
    AppMethodBeat.o(256651);
  }
  
  private void sendStateEvent(HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(256652);
    if (paramHashMap != null) {
      YtFSM.getInstance().sendFSMEvent(paramHashMap);
    }
    AppMethodBeat.o(256652);
  }
  
  public void enterFirst() {}
  
  public void enterState(String paramString)
  {
    AppMethodBeat.i(256642);
    Object localObject = this.stateNameMap.get(paramString);
    if (localObject == null)
    {
      AppMethodBeat.o(256642);
      return;
    }
    this.currentAction = "enter";
    int i = ((Integer)localObject).intValue();
    if (i == 0)
    {
      exitState();
      if (this.currentAction != null)
      {
        this.currentEnterTimeStampMS = System.currentTimeMillis();
        this.currentState = paramString;
        makeReport(this.currentState, this.currentAction, null, null, null);
      }
    }
    this.stateNameMap.put(paramString, Integer.valueOf(i + 1));
    AppMethodBeat.o(256642);
  }
  
  public void exitState()
  {
    AppMethodBeat.i(256644);
    if (this.currentState != null)
    {
      String str = Long.toString(System.currentTimeMillis() - this.currentEnterTimeStampMS);
      makeReport(this.currentState, "exit", null, str, null);
    }
    AppMethodBeat.o(256644);
  }
  
  public void registerStateName(String paramString)
  {
    AppMethodBeat.i(256640);
    this.stateNameMap.put(paramString, Integer.valueOf(0));
    AppMethodBeat.o(256640);
  }
  
  public void reportError(int paramInt, String paramString)
  {
    AppMethodBeat.i(256646);
    HashMap localHashMap = new HashMap();
    localHashMap.put("error_code", Integer.valueOf(paramInt));
    localHashMap.put("error_msg", paramString);
    makeReport(this.currentState, this.currentAction, localHashMap, null, null);
    AppMethodBeat.o(256646);
  }
  
  public void reportInfo(String paramString)
  {
    AppMethodBeat.i(256647);
    if ((this.preInfo == null) || (!this.preInfo.equals(paramString))) {
      this.preInfo = paramString;
    }
    makeReport(this.currentState, this.currentAction, null, null, paramString);
    AppMethodBeat.o(256647);
  }
  
  public void reset()
  {
    AppMethodBeat.i(256649);
    Iterator localIterator = this.stateNameMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      this.stateNameMap.put(str, Integer.valueOf(0));
    }
    this.currentState = null;
    this.preUpdateState = null;
    this.preInfo = null;
    AppMethodBeat.o(256649);
  }
  
  public void updateState(String paramString)
  {
    AppMethodBeat.i(256643);
    this.currentAction = "update";
    if ((this.preUpdateState == null) || (!this.preUpdateState.equals(this.currentState)))
    {
      this.preUpdateState = this.currentState;
      makeReport(this.currentState, this.currentAction, null, null, null);
    }
    AppMethodBeat.o(256643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.youtu.sdkkitframework.common.YtSDKStats
 * JD-Core Version:    0.7.0.1
 */