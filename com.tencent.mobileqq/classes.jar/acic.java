abstract class acic
  implements com.tencent.mobileqq.javahooksdk.HookMethodCallback
{
  public static com.tencent.qapmsdk.battery.monitor.MethodHookParam a(com.tencent.mobileqq.javahooksdk.MethodHookParam paramMethodHookParam)
  {
    com.tencent.qapmsdk.battery.monitor.MethodHookParam localMethodHookParam = new com.tencent.qapmsdk.battery.monitor.MethodHookParam();
    if (paramMethodHookParam != null)
    {
      localMethodHookParam.args = paramMethodHookParam.args;
      localMethodHookParam.method = paramMethodHookParam.method;
      localMethodHookParam.result = paramMethodHookParam.result;
      localMethodHookParam.thisObject = paramMethodHookParam.thisObject;
      localMethodHookParam.throwable = paramMethodHookParam.throwable;
    }
    return localMethodHookParam;
  }
  
  public abstract com.tencent.qapmsdk.battery.monitor.HookMethodCallback a();
  
  public abstract void a();
  
  public void afterHookedMethod(com.tencent.mobileqq.javahooksdk.MethodHookParam paramMethodHookParam)
  {
    com.tencent.qapmsdk.battery.monitor.HookMethodCallback localHookMethodCallback = a();
    if (localHookMethodCallback != null) {
      localHookMethodCallback.afterHookedMethod(a(paramMethodHookParam));
    }
  }
  
  public void beforeHookedMethod(com.tencent.mobileqq.javahooksdk.MethodHookParam paramMethodHookParam)
  {
    com.tencent.qapmsdk.battery.monitor.HookMethodCallback localHookMethodCallback = a();
    if (localHookMethodCallback != null) {
      localHookMethodCallback.beforeHookedMethod(a(paramMethodHookParam));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acic
 * JD-Core Version:    0.7.0.1
 */