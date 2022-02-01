import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ahty
  implements biuy
{
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<Activity> b;
  
  ahty(ahtp paramahtp, QQAppInterface paramQQAppInterface, Activity paramActivity)
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
      do
      {
        return;
        agej.n = true;
      } while (this.jdField_a_of_type_Ahtp.a());
      localObject = agej.a(paramView);
    } while ((aqyt.a((MessageRecord)localObject)) || (awlm.a(this.jdField_a_of_type_Ahtp.a)) || (((ChatMessage)localObject).istroop == 10007) || (paramView.getId() == 2131378827) || (paramView.getId() == 2131371445) || (paramView.getId() == 2131364451));
    Object localObject = (FragmentActivity)paramView.getContext();
    if (localObject != null) {}
    for (localObject = ((FragmentActivity)localObject).getChatFragment();; localObject = null)
    {
      if (localObject == null)
      {
        ChatActivityUtils.a(localQQAppInterface, paramView, localActivity);
        return;
      }
      ChatActivityUtils.a(localQQAppInterface, paramView, localActivity, this.jdField_a_of_type_Ahtp.a.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ahty
 * JD-Core Version:    0.7.0.1
 */