import android.text.TextUtils;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class acfk
  extends amdg
{
  public acfk(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  protected void a(boolean paramBoolean, bade parambade)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onGetBindSubAccount() isSuccess=" + paramBoolean);
    }
    if ((parambade == null) || (!TextUtils.equals(parambade.b, this.a.app.c()))) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      parambade = parambade.c();
    } while ((parambade == null) || (this.a.a == null));
    Iterator localIterator = this.a.a.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (parambade.contains(((SubAccountInfo)localIterator.next()).subuin));
    for (int i = 1;; i = 0)
    {
      if (parambade.size() != this.a.a.size()) {
        i = j;
      }
      while (i != 0)
      {
        AssociatedAccountActivity.b(this.a, false);
        return;
      }
      break;
    }
  }
  
  protected void b(boolean paramBoolean, bade parambade)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AssociatedAccountActivity", 2, "onBindSubAccount() isSuccess=" + paramBoolean);
      if (parambade != null) {
        QLog.d("AssociatedAccountActivity", 2, "onBindSubAccount() mainAccount=" + parambade.b + " subAccount=" + parambade.c + " errType=" + parambade.jdField_a_of_type_Int + " errMsg=" + parambade.jdField_a_of_type_JavaLangString);
      }
    }
    if ((parambade == null) || (!TextUtils.equals(parambade.b, this.a.app.c()))) {}
    while (!paramBoolean) {
      return;
    }
    AssociatedAccountActivity.b(this.a, false);
  }
  
  protected void c(boolean paramBoolean, bade parambade)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AssociatedAccountActivity", 2, "onUnBindSubAccount() isSuccess=" + paramBoolean);
      if (parambade != null) {
        QLog.d("AssociatedAccountActivity", 2, "onUnBindSubAccount() mainAccount=" + parambade.b + " subAccount=" + parambade.c + " errType=" + parambade.jdField_a_of_type_Int + " errMsg=" + parambade.jdField_a_of_type_JavaLangString);
      }
    }
    if ((parambade == null) || (!TextUtils.equals(parambade.b, this.a.app.c()))) {}
    while (!paramBoolean) {
      return;
    }
    AssociatedAccountActivity.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfk
 * JD-Core Version:    0.7.0.1
 */