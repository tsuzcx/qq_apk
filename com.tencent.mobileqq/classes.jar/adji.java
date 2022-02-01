import android.text.TextUtils;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class adji
  extends aoef
{
  public adji(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  protected void a(boolean paramBoolean, bdxt parambdxt)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onGetBindSubAccount() isSuccess=" + paramBoolean);
    }
    if ((parambdxt == null) || (!TextUtils.equals(parambdxt.b, this.a.app.getCurrentUin()))) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      parambdxt = parambdxt.c();
    } while ((parambdxt == null) || (this.a.a == null));
    Iterator localIterator = this.a.a.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (parambdxt.contains(((SubAccountInfo)localIterator.next()).subuin));
    for (int i = 1;; i = 0)
    {
      if (parambdxt.size() != this.a.a.size()) {
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
  
  protected void b(boolean paramBoolean, bdxt parambdxt)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AssociatedAccountActivity", 2, "onBindSubAccount() isSuccess=" + paramBoolean);
      if (parambdxt != null) {
        QLog.d("AssociatedAccountActivity", 2, "onBindSubAccount() mainAccount=" + parambdxt.b + " subAccount=" + parambdxt.c + " errType=" + parambdxt.jdField_a_of_type_Int + " errMsg=" + parambdxt.jdField_a_of_type_JavaLangString);
      }
    }
    if ((parambdxt == null) || (!TextUtils.equals(parambdxt.b, this.a.app.getCurrentUin()))) {}
    while (!paramBoolean) {
      return;
    }
    AssociatedAccountActivity.b(this.a, false);
  }
  
  protected void c(boolean paramBoolean, bdxt parambdxt)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AssociatedAccountActivity", 2, "onUnBindSubAccount() isSuccess=" + paramBoolean);
      if (parambdxt != null) {
        QLog.d("AssociatedAccountActivity", 2, "onUnBindSubAccount() mainAccount=" + parambdxt.b + " subAccount=" + parambdxt.c + " errType=" + parambdxt.jdField_a_of_type_Int + " errMsg=" + parambdxt.jdField_a_of_type_JavaLangString);
      }
    }
    if ((parambdxt == null) || (!TextUtils.equals(parambdxt.b, this.a.app.getCurrentUin()))) {}
    while (!paramBoolean) {
      return;
    }
    AssociatedAccountActivity.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     adji
 * JD-Core Version:    0.7.0.1
 */