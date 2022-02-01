import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.app.BaseActivity;

public class afuc
{
  public static BaseChatPie a()
  {
    Object localObject = BaseActivity.sTopActivity;
    if ((localObject instanceof FragmentActivity))
    {
      localObject = ((FragmentActivity)localObject).getChatFragment();
      if (localObject != null) {
        return ((ChatFragment)localObject).a();
      }
    }
    return null;
  }
  
  public static boolean a()
  {
    boolean bool = false;
    BaseChatPie localBaseChatPie = a();
    if (localBaseChatPie != null) {
      bool = ((AIOLongShotHelper)localBaseChatPie.a(15)).a();
    }
    return bool;
  }
  
  public static boolean b()
  {
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afuc
 * JD-Core Version:    0.7.0.1
 */