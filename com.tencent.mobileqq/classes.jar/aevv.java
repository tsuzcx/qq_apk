import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;

public class aevv
{
  public static void a(Activity paramActivity, Intent paramIntent, Class<? extends PublicFragmentActivity> paramClass, Class<? extends PublicBaseFragment> paramClass1, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramActivity, paramClass);
    localIntent.putExtra("public_fragment_class", paramClass1.getName());
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public static void a(Context paramContext, Intent paramIntent, Class<? extends PublicFragmentActivity> paramClass, Class<? extends PublicBaseFragment> paramClass1)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramContext, paramClass);
    localIntent.putExtra("public_fragment_class", paramClass1.getName());
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, Class<? extends PublicFragmentActivity> paramClass, Class<? extends PublicBaseFragment> paramClass1)
  {
    a(paramContext, null, paramClass, paramClass1);
  }
  
  public static void a(Intent paramIntent, Class<? extends PublicFragmentActivity> paramClass, Class<? extends PublicBaseFragment> paramClass1)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(BaseApplicationImpl.getApplication(), paramClass);
    localIntent.addFlags(268435456);
    localIntent.putExtra("public_fragment_class", paramClass1.getName());
    BaseApplicationImpl.getApplication().startActivity(localIntent);
  }
  
  public static void a(Fragment paramFragment, Intent paramIntent, Class<? extends PublicFragmentActivity> paramClass, Class<? extends PublicBaseFragment> paramClass1, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.setClass(paramFragment.getActivity(), paramClass);
    localIntent.putExtra("public_fragment_class", paramClass1.getName());
    paramFragment.startActivityForResult(localIntent, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aevv
 * JD-Core Version:    0.7.0.1
 */