import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.util.VersionUtils;
import java.lang.ref.WeakReference;

public class akdh
  implements akdi
{
  private int jdField_a_of_type_Int = 2;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public akdh(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (VersionUtils.isM())
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localQQAppInterface != null) {
          ((PhoneContactManagerImp)localQQAppInterface.getManager(11)).b(true);
        }
        paramContext = new aywl(paramContext, paramContext.getPackageName());
      }
    }
    else {
      try
      {
        paramContext.a();
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        paramContext.b();
        return;
      }
    }
    Intent localIntent = new Intent(paramContext, GuideBindPhoneActivity.class);
    localIntent.putExtra("fromKeyForContactBind", this.jdField_a_of_type_Int);
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akdh
 * JD-Core Version:    0.7.0.1
 */