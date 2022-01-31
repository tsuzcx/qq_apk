import com.tencent.ark.ark;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ;
import java.lang.ref.WeakReference;

public class aaqi
  implements Runnable
{
  public aaqi(ArkAppModuleReg.ModuleQQ paramModuleQQ, long paramLong) {}
  
  public void run()
  {
    ArkAppContainer localArkAppContainer = (ArkAppContainer)ArkAppContainer.a(ark.arkGetContainer(this.jdField_a_of_type_Long)).get();
    if (localArkAppContainer != null) {
      localArkAppContainer.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaqi
 * JD-Core Version:    0.7.0.1
 */