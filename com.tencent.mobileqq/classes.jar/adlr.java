import com.tencent.mobileqq.javahook.BitmapOOMHooker;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;

public class adlr
  implements HookMethodCallback
{
  private int a;
  
  public adlr(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (paramMethodHookParam.throwable == null) {
      return;
    }
    Throwable localThrowable;
    if (paramMethodHookParam.throwable.getCause() != null) {
      localThrowable = paramMethodHookParam.throwable.getCause();
    }
    while ((localThrowable instanceof OutOfMemoryError))
    {
      BitmapOOMHooker.b();
      try
      {
        paramMethodHookParam.result = JavaHookBridge.invokeOriginMethod(paramMethodHookParam.method, paramMethodHookParam.thisObject, paramMethodHookParam.args);
        paramMethodHookParam.throwable = null;
        BitmapOOMHooker.a(true, this.a);
        return;
      }
      catch (Exception paramMethodHookParam)
      {
        BitmapOOMHooker.a(false, this.a);
        return;
        localThrowable = paramMethodHookParam.throwable;
      }
      catch (Error paramMethodHookParam)
      {
        BitmapOOMHooker.a(false, this.a);
      }
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adlr
 * JD-Core Version:    0.7.0.1
 */