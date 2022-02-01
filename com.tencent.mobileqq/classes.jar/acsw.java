import android.text.TextUtils;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class acsw
  extends anbq
{
  public acsw(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  protected void a(boolean paramBoolean, bcqu parambcqu)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onGetBindSubAccount() isSuccess=" + paramBoolean);
    }
    if ((parambcqu == null) || (!TextUtils.equals(parambcqu.b, this.a.app.getCurrentUin()))) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      parambcqu = parambcqu.c();
    } while ((parambcqu == null) || (this.a.a == null));
    Iterator localIterator = this.a.a.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (parambcqu.contains(((SubAccountInfo)localIterator.next()).subuin));
    for (int i = 1;; i = 0)
    {
      if (parambcqu.size() != this.a.a.size()) {
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
  
  protected void b(boolean paramBoolean, bcqu parambcqu)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AssociatedAccountActivity", 2, "onBindSubAccount() isSuccess=" + paramBoolean);
      if (parambcqu != null) {
        QLog.d("AssociatedAccountActivity", 2, "onBindSubAccount() mainAccount=" + parambcqu.b + " subAccount=" + parambcqu.c + " errType=" + parambcqu.jdField_a_of_type_Int + " errMsg=" + parambcqu.jdField_a_of_type_JavaLangString);
      }
    }
    if ((parambcqu == null) || (!TextUtils.equals(parambcqu.b, this.a.app.getCurrentUin()))) {}
    while (!paramBoolean) {
      return;
    }
    AssociatedAccountActivity.b(this.a, false);
  }
  
  protected void c(boolean paramBoolean, bcqu parambcqu)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AssociatedAccountActivity", 2, "onUnBindSubAccount() isSuccess=" + paramBoolean);
      if (parambcqu != null) {
        QLog.d("AssociatedAccountActivity", 2, "onUnBindSubAccount() mainAccount=" + parambcqu.b + " subAccount=" + parambcqu.c + " errType=" + parambcqu.jdField_a_of_type_Int + " errMsg=" + parambcqu.jdField_a_of_type_JavaLangString);
      }
    }
    if ((parambcqu == null) || (!TextUtils.equals(parambcqu.b, this.a.app.getCurrentUin()))) {}
    while (!paramBoolean) {
      return;
    }
    AssociatedAccountActivity.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsw
 * JD-Core Version:    0.7.0.1
 */