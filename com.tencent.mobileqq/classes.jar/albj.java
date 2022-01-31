import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.3;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.3.1.1;
import com.tencent.mobileqq.ark.ArkAppCenter;

public class albj
  implements yjn
{
  public albj(ArkAppNotifyCenter.GdtNotify.3 param3) {}
  
  public void onResponse(yjm paramyjm)
  {
    ArkAppCenter.a().postToArkThread(new ArkAppNotifyCenter.GdtNotify.3.1.1(this, paramyjm));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     albj
 * JD-Core Version:    0.7.0.1
 */