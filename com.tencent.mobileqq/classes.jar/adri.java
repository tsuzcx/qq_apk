import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class adri
  implements bbgb
{
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<Activity> b;
  
  adri(adra paramadra, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramActivity);
  }
  
  public void a(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    Activity localActivity = (Activity)this.b.get();
    if ((localActivity == null) || (localQQAppInterface == null)) {
      QLog.e("ChatItemBuilder", 1, "TextItemBuilder  onDoubleClick  app null fa null");
    }
    do
    {
      return;
      aciy.n = true;
    } while ((this.jdField_a_of_type_Adra.a()) || (alyc.a(aciy.a(paramView))) || (aqux.a(this.jdField_a_of_type_Adra.a)) || (paramView.getId() == 2131311433) || (paramView.getId() == 2131304792) || (paramView.getId() == 2131298580));
    Object localObject = (FragmentActivity)paramView.getContext();
    if (localObject != null) {}
    for (localObject = ((FragmentActivity)localObject).getChatFragment();; localObject = null)
    {
      if (localObject == null)
      {
        ChatActivityUtils.a(localQQAppInterface, paramView, localActivity);
        return;
      }
      ChatActivityUtils.a(localQQAppInterface, paramView, localActivity, this.jdField_a_of_type_Adra.a.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adri
 * JD-Core Version:    0.7.0.1
 */