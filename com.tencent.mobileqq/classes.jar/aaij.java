import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ;
import com.tencent.mobileqq.ark.ArkTipsManager;
import java.lang.ref.WeakReference;

public class aaij
  implements Runnable
{
  public aaij(ArkAppModuleReg.ModuleQQ paramModuleQQ, long paramLong) {}
  
  public void run()
  {
    Object localObject = ark.arkGetContainer(this.jdField_a_of_type_Long);
    if (localObject == null) {}
    do
    {
      return;
      localObject = ArkAppContainer.a((ark.Container)localObject);
    } while ((localObject == null) || ((ArkAppContainer)((WeakReference)localObject).get() == null));
    ArkTipsManager.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aaij
 * JD-Core Version:    0.7.0.1
 */