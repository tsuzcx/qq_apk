import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

public class aihy
  implements aihz
{
  private int jdField_a_of_type_Int = 2;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public aihy(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public void a(Context paramContext, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (bhou.k())
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (localQQAppInterface != null) {
          ((PhoneContactManagerImp)localQQAppInterface.getManager(11)).b(true);
        }
        paramContext = new awdq(paramContext, paramContext.getPackageName());
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
 * Qualified Name:     aihy
 * JD-Core Version:    0.7.0.1
 */