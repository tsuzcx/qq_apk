import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.util.VersionUtils;
import java.lang.ref.WeakReference;

public class akif
  implements akig
{
  private int jdField_a_of_type_Int = 2;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public akif(QQAppInterface paramQQAppInterface)
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
          ((PhoneContactManagerImp)localQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).b(true);
        }
        paramContext = new azis(paramContext, paramContext.getPackageName());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akif
 * JD-Core Version:    0.7.0.1
 */