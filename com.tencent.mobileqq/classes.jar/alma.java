import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class alma
  implements allu
{
  private final int jdField_a_of_type_Int;
  @Nullable
  private allw jdField_a_of_type_Allw;
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
  
  public alma(@NonNull QQAppInterface paramQQAppInterface, @NonNull String paramString1, @NonNull String paramString2, @NonNull String paramString3, @NonNull String paramString4, @NonNull Intent paramIntent, @NonNull String paramString5, int paramInt)
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
  
  public void a(@Nullable allw paramallw)
  {
    this.jdField_a_of_type_Allw = paramallw;
  }
  
  public boolean isNeedAutoCloseWhenAccountChange()
  {
    return true;
  }
  
  public void onClose()
  {
    if (this.jdField_a_of_type_Allw == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localQQAppInterface == null);
    aljw.a(localQQAppInterface, this.jdField_a_of_type_Allw);
  }
  
  public void onEnter()
  {
    if (this.jdField_a_of_type_Allw == null) {}
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
      bmgt localbmgt = new bmgt(this.jdField_a_of_type_Int);
      localbmgt.d = this.d;
      localbmgt.e = this.jdField_a_of_type_JavaLangString;
      localbmgt.jdField_a_of_type_JavaLangClass = localClass;
      localbmgt.jdField_b_of_type_JavaLangString = this.c;
      localbmgt.jdField_a_of_type_JavaLangString = this.e;
      localbmgt.jdField_a_of_type_AndroidContentIntent = this.jdField_a_of_type_AndroidContentIntent;
      localbmgt.jdField_b_of_type_Int = -1;
      bmgk.a(localBaseActivity, localbmgt);
      aljw.a(localQQAppInterface, this.jdField_a_of_type_Allw);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      QLog.e("Q.recent.banner", 1, "return to plugin error, can not find the ckass " + this.jdField_b_of_type_JavaLangString);
    }
  }
  
  public void onOverride() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alma
 * JD-Core Version:    0.7.0.1
 */