import android.text.TextUtils;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class aakb
  extends akhc
{
  public aakb(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  protected void a(boolean paramBoolean, ayaw paramayaw)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onGetBindSubAccount() isSuccess=" + paramBoolean);
    }
    if ((paramayaw == null) || (!TextUtils.equals(paramayaw.b, this.a.app.c()))) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      paramayaw = paramayaw.c();
    } while ((paramayaw == null) || (this.a.a == null));
    Iterator localIterator = this.a.a.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (paramayaw.contains(((SubAccountInfo)localIterator.next()).subuin));
    for (int i = 1;; i = 0)
    {
      if (paramayaw.size() != this.a.a.size()) {
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
  
  protected void b(boolean paramBoolean, ayaw paramayaw)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AssociatedAccountActivity", 2, "onBindSubAccount() isSuccess=" + paramBoolean);
      if (paramayaw != null) {
        QLog.d("AssociatedAccountActivity", 2, "onBindSubAccount() mainAccount=" + paramayaw.b + " subAccount=" + paramayaw.c + " errType=" + paramayaw.jdField_a_of_type_Int + " errMsg=" + paramayaw.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramayaw == null) || (!TextUtils.equals(paramayaw.b, this.a.app.c()))) {}
    while (!paramBoolean) {
      return;
    }
    AssociatedAccountActivity.d(this.a, false);
  }
  
  protected void c(boolean paramBoolean, ayaw paramayaw)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AssociatedAccountActivity", 2, "onUnBindSubAccount() isSuccess=" + paramBoolean);
      if (paramayaw != null) {
        QLog.d("AssociatedAccountActivity", 2, "onUnBindSubAccount() mainAccount=" + paramayaw.b + " subAccount=" + paramayaw.c + " errType=" + paramayaw.jdField_a_of_type_Int + " errMsg=" + paramayaw.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramayaw == null) || (!TextUtils.equals(paramayaw.b, this.a.app.c()))) {}
    while (!paramBoolean) {
      return;
    }
    AssociatedAccountActivity.d(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aakb
 * JD-Core Version:    0.7.0.1
 */