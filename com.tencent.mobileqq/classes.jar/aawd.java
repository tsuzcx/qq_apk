import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.tencent.ark.ark;
import com.tencent.ark.ark.Container;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg;
import com.tencent.mobileqq.ark.API.ArkAppModuleReg.ModuleQQ;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.data.MessageForArkApp;
import java.lang.ref.WeakReference;

public class aawd
  implements Runnable
{
  public aawd(ArkAppModuleReg.ModuleQQ paramModuleQQ, long paramLong, String paramString) {}
  
  public void run()
  {
    Object localObject3 = ark.arkGetContainer(this.jdField_a_of_type_Long);
    if (localObject3 == null) {}
    label12:
    Object localObject1;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              break label12;
              break label12;
              break label12;
              do
              {
                return;
              } while (!(BaseActivity.sTopActivity instanceof FragmentActivity));
              localObject1 = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
            } while (localObject1 == null);
            localObject2 = ((ChatFragment)localObject1).a();
            if (localObject2 == null) {
              break;
            }
            localObject1 = ((BaseChatPie)localObject2).a();
          } while (localObject1 == null);
          localObject3 = ArkAppContainer.a((ark.Container)localObject3);
        } while (localObject3 == null);
        localObject3 = (ArkAppContainer)((WeakReference)localObject3).get();
        Object localObject2 = ((BaseChatPie)localObject2).a((ArkAppContainer)localObject3);
        if (localObject2 != null)
        {
          ArkTipsManager.a().a(((MessageForArkApp)localObject2).arkContainer, (SessionInfo)localObject1, (MessageForArkApp)localObject2, this.jdField_a_of_type_JavaLangString, ArkAppModuleReg.a());
          return;
        }
      } while ((!ArkTipsManager.a().a()) || (localObject3 == null));
      ArkTipsManager.a().a((ArkAppContainer)localObject3, (SessionInfo)localObject1, this.jdField_a_of_type_JavaLangString);
      return;
      localObject1 = ArkAppContainer.a((ark.Container)localObject3);
    } while (localObject1 == null);
    ArkTipsManager.a().a((ArkAppContainer)((WeakReference)localObject1).get(), null, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aawd
 * JD-Core Version:    0.7.0.1
 */