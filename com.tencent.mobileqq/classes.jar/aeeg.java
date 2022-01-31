import com.tencent.mobileqq.javahook.TimeoutExceptionHooker;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.mobileqq.javahooksdk.ReplaceMethodCallback;

public class aeeg
  implements ReplaceMethodCallback
{
  public void replaceMethod(MethodHookParam paramMethodHookParam)
  {
    TimeoutExceptionHooker.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aeeg
 * JD-Core Version:    0.7.0.1
 */