import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ahmg
  implements ahma
{
  private final int jdField_a_of_type_Int;
  @Nullable
  private ahmc jdField_a_of_type_Ahmc;
  @NonNull
  private final Intent jdField_a_of_type_AndroidContentIntent;
  @NonNull
  private final String jdField_a_of_type_JavaLangString;
  @NonNull
  private final WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  @NonNull
  private final String b;
  @NonNull
  private final String c;
  @Nullable
  private final String d;
  @NonNull
  private final String e;
  
  public ahmg(@NonNull QQAppInterface paramQQAppInterface, @NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4, @NonNull Intent paramIntent, @NonNull String paramString5, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.e = paramString5;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(@Nullable ahmc paramahmc)
  {
    this.jdField_a_of_type_Ahmc = paramahmc;
  }
  
  public boolean isNeedAutoCloseWhenAccountChange()
  {
    return true;
  }
  
  public void onClose()
  {
    if (this.jdField_a_of_type_Ahmc == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localQQAppInterface == null);
    ahkf.a(localQQAppInterface, this.jdField_a_of_type_Ahmc);
  }
  
  public void onEnter()
  {
    if (this.jdField_a_of_type_Ahmc == null) {}
    QQAppInterface localQQAppInterface;
    BaseActivity localBaseActivity;
    do
    {
      do
      {
        return;
        localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      } while (localQQAppInterface == null);
      localBaseActivity = BaseActivity.sTopActivity;
    } while ((localBaseActivity == null) || (localBaseActivity.isFinishing()));
    try
    {
      Class localClass = Class.forName(this.jdField_b_of_type_JavaLangString).asSubclass(Activity.class);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("banner_fromBanner", true);
      bgkz localbgkz = new bgkz(this.jdField_a_of_type_Int);
      localbgkz.d = this.d;
      localbgkz.e = this.jdField_a_of_type_JavaLangString;
      localbgkz.jdField_a_of_type_JavaLangClass = localClass;
      localbgkz.jdField_b_of_type_JavaLangString = this.c;
      localbgkz.jdField_a_of_type_JavaLangString = this.e;
      localbgkz.jdField_a_of_type_AndroidContentIntent = this.jdField_a_of_type_AndroidContentIntent;
      localbgkz.jdField_b_of_type_Int = -1;
      bgkq.a(localBaseActivity, localbgkz);
      ahkf.a(localQQAppInterface, this.jdField_a_of_type_Ahmc);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      QLog.e("Q.recent.banner", 1, "return to plugin error, can not find the ckass " + this.jdField_b_of_type_JavaLangString);
    }
  }
  
  public void onOverride() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahmg
 * JD-Core Version:    0.7.0.1
 */