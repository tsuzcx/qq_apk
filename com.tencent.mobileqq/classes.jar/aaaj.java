import android.text.TextUtils;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class aaaj
  extends ajss
{
  public aaaj(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  protected void a(boolean paramBoolean, axau paramaxau)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onGetBindSubAccount() isSuccess=" + paramBoolean);
    }
    if ((paramaxau == null) || (!TextUtils.equals(paramaxau.b, this.a.app.c()))) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      paramaxau = paramaxau.c();
    } while ((paramaxau == null) || (this.a.a == null));
    Iterator localIterator = this.a.a.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (paramaxau.contains(((SubAccountInfo)localIterator.next()).subuin));
    for (int i = 1;; i = 0)
    {
      if (paramaxau.size() != this.a.a.size()) {
        i = j;
      }
      while (i != 0)
      {
        AssociatedAccountActivity.d(this.a, false);
        return;
      }
      break;
    }
  }
  
  protected void b(boolean paramBoolean, axau paramaxau)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AssociatedAccountActivity", 2, "onBindSubAccount() isSuccess=" + paramBoolean);
      if (paramaxau != null) {
        QLog.d("AssociatedAccountActivity", 2, "onBindSubAccount() mainAccount=" + paramaxau.b + " subAccount=" + paramaxau.c + " errType=" + paramaxau.jdField_a_of_type_Int + " errMsg=" + paramaxau.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramaxau == null) || (!TextUtils.equals(paramaxau.b, this.a.app.c()))) {}
    while (!paramBoolean) {
      return;
    }
    AssociatedAccountActivity.d(this.a, false);
  }
  
  protected void c(boolean paramBoolean, axau paramaxau)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AssociatedAccountActivity", 2, "onUnBindSubAccount() isSuccess=" + paramBoolean);
      if (paramaxau != null) {
        QLog.d("AssociatedAccountActivity", 2, "onUnBindSubAccount() mainAccount=" + paramaxau.b + " subAccount=" + paramaxau.c + " errType=" + paramaxau.jdField_a_of_type_Int + " errMsg=" + paramaxau.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramaxau == null) || (!TextUtils.equals(paramaxau.b, this.a.app.c()))) {}
    while (!paramBoolean) {
      return;
    }
    AssociatedAccountActivity.d(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aaaj
 * JD-Core Version:    0.7.0.1
 */