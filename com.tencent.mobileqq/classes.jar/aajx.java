import android.text.TextUtils;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class aajx
  extends akhb
{
  public aajx(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  protected void a(boolean paramBoolean, ayay paramayay)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onGetBindSubAccount() isSuccess=" + paramBoolean);
    }
    if ((paramayay == null) || (!TextUtils.equals(paramayay.b, this.a.app.c()))) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      paramayay = paramayay.c();
    } while ((paramayay == null) || (this.a.a == null));
    Iterator localIterator = this.a.a.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (paramayay.contains(((SubAccountInfo)localIterator.next()).subuin));
    for (int i = 1;; i = 0)
    {
      if (paramayay.size() != this.a.a.size()) {
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
  
  protected void b(boolean paramBoolean, ayay paramayay)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AssociatedAccountActivity", 2, "onBindSubAccount() isSuccess=" + paramBoolean);
      if (paramayay != null) {
        QLog.d("AssociatedAccountActivity", 2, "onBindSubAccount() mainAccount=" + paramayay.b + " subAccount=" + paramayay.c + " errType=" + paramayay.jdField_a_of_type_Int + " errMsg=" + paramayay.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramayay == null) || (!TextUtils.equals(paramayay.b, this.a.app.c()))) {}
    while (!paramBoolean) {
      return;
    }
    AssociatedAccountActivity.d(this.a, false);
  }
  
  protected void c(boolean paramBoolean, ayay paramayay)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AssociatedAccountActivity", 2, "onUnBindSubAccount() isSuccess=" + paramBoolean);
      if (paramayay != null) {
        QLog.d("AssociatedAccountActivity", 2, "onUnBindSubAccount() mainAccount=" + paramayay.b + " subAccount=" + paramayay.c + " errType=" + paramayay.jdField_a_of_type_Int + " errMsg=" + paramayay.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramayay == null) || (!TextUtils.equals(paramayay.b, this.a.app.c()))) {}
    while (!paramBoolean) {
      return;
    }
    AssociatedAccountActivity.d(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aajx
 * JD-Core Version:    0.7.0.1
 */