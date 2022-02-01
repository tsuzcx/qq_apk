import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class alfl
  implements alfe
{
  private final int jdField_a_of_type_Int;
  @Nullable
  private alfg jdField_a_of_type_Alfg;
  @Nullable
  private final Bundle jdField_a_of_type_AndroidOsBundle;
  @NonNull
  private final String jdField_a_of_type_JavaLangString;
  @NonNull
  private final WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private final boolean jdField_a_of_type_Boolean;
  @Nullable
  private final String b;
  
  public alfl(@NonNull String paramString1, @NonNull QQAppInterface paramQQAppInterface, @Nullable String paramString2, int paramInt, @Nullable Bundle paramBundle, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.b = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(@Nullable alfg paramalfg)
  {
    this.jdField_a_of_type_Alfg = paramalfg;
  }
  
  public boolean isNeedAutoCloseWhenAccountChange()
  {
    return true;
  }
  
  public void onClose()
  {
    if (this.jdField_a_of_type_Alfg == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localQQAppInterface == null);
    aldh.a(localQQAppInterface, this.jdField_a_of_type_Alfg);
  }
  
  public void onEnter()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "onEnter: " + this.jdField_a_of_type_Alfg + " / " + this.b + " / " + this.jdField_a_of_type_Int + " / " + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Alfg == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localQQAppInterface == null);
    Object localObject3 = QQBrowserActivity.class;
    Object localObject1 = localObject3;
    if (!TextUtils.isEmpty(this.b)) {}
    try
    {
      localObject1 = Class.forName(this.b);
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      localObject3 = localBaseActivity;
      if (localBaseActivity == null)
      {
        localObject3 = BaseApplicationImpl.getContext();
        QLog.d("Q.recent.banner", 1, "sTopActivity is null,set Application context");
      }
      if (localObject3 != null)
      {
        localObject1 = new Intent(localQQAppInterface.getApp(), (Class)localObject1);
        ((Intent)localObject1).setFlags(this.jdField_a_of_type_Int);
        ((Intent)localObject1).putExtra("banner_fromBanner", true);
        ((Intent)localObject1).putExtra("url", this.jdField_a_of_type_JavaLangString);
        ((Intent)localObject1).putExtra("banner_webview_extra", this.jdField_a_of_type_AndroidOsBundle);
        ((Intent)localObject1).putExtra("force_no_reload", this.jdField_a_of_type_Boolean);
      }
      for (;;)
      {
        try
        {
          ((Context)localObject3).startActivity((Intent)localObject1);
          aldh.a(localQQAppInterface, this.jdField_a_of_type_Alfg);
          return;
        }
        catch (Exception localException)
        {
          QLog.d("Q.recent.banner", 1, "startActivity,error =" + localException);
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, "sTopActivity is null");
        }
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
  
  public void onOverride()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "banner for " + this.jdField_a_of_type_JavaLangString + " is overrided");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     alfl
 * JD-Core Version:    0.7.0.1
 */