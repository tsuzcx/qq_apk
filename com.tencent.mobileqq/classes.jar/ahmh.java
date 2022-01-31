import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ahmh
  implements ahma
{
  private final int jdField_a_of_type_Int;
  @Nullable
  private ahmc jdField_a_of_type_Ahmc;
  @Nullable
  private final Bundle jdField_a_of_type_AndroidOsBundle;
  @NonNull
  private final String jdField_a_of_type_JavaLangString;
  @NonNull
  private final WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  private final boolean jdField_a_of_type_Boolean;
  @Nullable
  private final String b;
  
  public ahmh(@NonNull String paramString1, @NonNull QQAppInterface paramQQAppInterface, @Nullable String paramString2, int paramInt, @Nullable Bundle paramBundle, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.b = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    this.jdField_a_of_type_Boolean = paramBoolean;
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "onEnter: " + this.jdField_a_of_type_Ahmc + " / " + this.b + " / " + this.jdField_a_of_type_Int + " / " + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Ahmc == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localQQAppInterface == null);
    QQBrowserActivity localQQBrowserActivity2 = QQBrowserActivity.class;
    Object localObject = localQQBrowserActivity2;
    if (!TextUtils.isEmpty(this.b)) {}
    try
    {
      localObject = Class.forName(this.b);
      if (BaseActivity.sTopActivity != null)
      {
        localObject = new Intent(localQQAppInterface.getApp(), (Class)localObject);
        ((Intent)localObject).setFlags(this.jdField_a_of_type_Int);
        ((Intent)localObject).putExtra("banner_fromBanner", true);
        ((Intent)localObject).putExtra("url", this.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("banner_webview_extra", this.jdField_a_of_type_AndroidOsBundle);
        ((Intent)localObject).putExtra("force_no_reload", this.jdField_a_of_type_Boolean);
        BaseActivity.sTopActivity.startActivity((Intent)localObject);
      }
      for (;;)
      {
        ahkf.a(localQQAppInterface, this.jdField_a_of_type_Ahmc);
        return;
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent.banner", 2, "sTopActivity is null");
        }
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        QQBrowserActivity localQQBrowserActivity1 = localQQBrowserActivity2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ahmh
 * JD-Core Version:    0.7.0.1
 */