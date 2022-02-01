import android.text.TextUtils;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class advw
  extends aoib
{
  public advw(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  protected void a(boolean paramBoolean, bdxd parambdxd)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onGetBindSubAccount() isSuccess=" + paramBoolean);
    }
    if ((parambdxd == null) || (!TextUtils.equals(parambdxd.b, this.a.app.c()))) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      parambdxd = parambdxd.c();
    } while ((parambdxd == null) || (this.a.a == null));
    Iterator localIterator = this.a.a.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (parambdxd.contains(((SubAccountInfo)localIterator.next()).subuin));
    for (int i = 1;; i = 0)
    {
      if (parambdxd.size() != this.a.a.size()) {
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
  
  protected void b(boolean paramBoolean, bdxd parambdxd)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AssociatedAccountActivity", 2, "onBindSubAccount() isSuccess=" + paramBoolean);
      if (parambdxd != null) {
        QLog.d("AssociatedAccountActivity", 2, "onBindSubAccount() mainAccount=" + parambdxd.b + " subAccount=" + parambdxd.c + " errType=" + parambdxd.jdField_a_of_type_Int + " errMsg=" + parambdxd.jdField_a_of_type_JavaLangString);
      }
    }
    if ((parambdxd == null) || (!TextUtils.equals(parambdxd.b, this.a.app.c()))) {}
    while (!paramBoolean) {
      return;
    }
    AssociatedAccountActivity.b(this.a, false);
  }
  
  protected void c(boolean paramBoolean, bdxd parambdxd)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AssociatedAccountActivity", 2, "onUnBindSubAccount() isSuccess=" + paramBoolean);
      if (parambdxd != null) {
        QLog.d("AssociatedAccountActivity", 2, "onUnBindSubAccount() mainAccount=" + parambdxd.b + " subAccount=" + parambdxd.c + " errType=" + parambdxd.jdField_a_of_type_Int + " errMsg=" + parambdxd.jdField_a_of_type_JavaLangString);
      }
    }
    if ((parambdxd == null) || (!TextUtils.equals(parambdxd.b, this.a.app.c()))) {}
    while (!paramBoolean) {
      return;
    }
    AssociatedAccountActivity.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     advw
 * JD-Core Version:    0.7.0.1
 */