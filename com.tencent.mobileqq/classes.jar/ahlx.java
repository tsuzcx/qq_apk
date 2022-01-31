import android.content.Intent;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ahlx
  implements ahly
{
  private ahma jdField_a_of_type_Ahma;
  private String jdField_a_of_type_JavaLangString;
  private final WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public ahlx(String paramString, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public void a(@Nullable ahma paramahma)
  {
    this.jdField_a_of_type_Ahma = paramahma;
  }
  
  public boolean isNeedAutoCloseWhenAccountChange()
  {
    return true;
  }
  
  public void onClose()
  {
    if (this.jdField_a_of_type_Ahma == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localQQAppInterface == null);
    ahkd.a(localQQAppInterface, this.jdField_a_of_type_Ahma);
  }
  
  public void onEnter()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface == null) {
      return;
    }
    Intent localIntent;
    if (BaseActivity.sTopActivity != null)
    {
      localIntent = new Intent();
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.addFlags(268435456);
    }
    for (;;)
    {
      try
      {
        PublicTransFragmentActivity.b(localQQAppInterface.getApp(), localIntent, Class.forName(this.jdField_a_of_type_JavaLangString));
        ahkd.a(localQQAppInterface, this.jdField_a_of_type_Ahma);
        return;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localClassNotFoundException.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "sTopActivity is null");
      }
    }
  }
  
  public void onOverride() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahlx
 * JD-Core Version:    0.7.0.1
 */