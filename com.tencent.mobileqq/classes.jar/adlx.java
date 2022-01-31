import com.tencent.mobileqq.javahook.TimeoutExceptionHooker;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.mobileqq.javahooksdk.ReplaceMethodCallback;

public class adlx
  implements ReplaceMethodCallback
{
  public void replaceMethod(MethodHookParam paramMethodHookParam)
  {
    TimeoutExceptionHooker.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     adlx
 * JD-Core Version:    0.7.0.1
 */