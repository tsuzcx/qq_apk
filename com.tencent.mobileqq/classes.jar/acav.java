import android.text.TextUtils;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class acav
  extends alyr
{
  public acav(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  protected void a(boolean paramBoolean, azyv paramazyv)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("AssociatedAccountActivity", 2, "onGetBindSubAccount() isSuccess=" + paramBoolean);
    }
    if ((paramazyv == null) || (!TextUtils.equals(paramazyv.b, this.a.app.c()))) {}
    do
    {
      do
      {
        return;
      } while (!paramBoolean);
      paramazyv = paramazyv.c();
    } while ((paramazyv == null) || (this.a.a == null));
    Iterator localIterator = this.a.a.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (paramazyv.contains(((SubAccountInfo)localIterator.next()).subuin));
    for (int i = 1;; i = 0)
    {
      if (paramazyv.size() != this.a.a.size()) {
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
  
  protected void b(boolean paramBoolean, azyv paramazyv)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AssociatedAccountActivity", 2, "onBindSubAccount() isSuccess=" + paramBoolean);
      if (paramazyv != null) {
        QLog.d("AssociatedAccountActivity", 2, "onBindSubAccount() mainAccount=" + paramazyv.b + " subAccount=" + paramazyv.c + " errType=" + paramazyv.jdField_a_of_type_Int + " errMsg=" + paramazyv.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramazyv == null) || (!TextUtils.equals(paramazyv.b, this.a.app.c()))) {}
    while (!paramBoolean) {
      return;
    }
    AssociatedAccountActivity.b(this.a, false);
  }
  
  protected void c(boolean paramBoolean, azyv paramazyv)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("AssociatedAccountActivity", 2, "onUnBindSubAccount() isSuccess=" + paramBoolean);
      if (paramazyv != null) {
        QLog.d("AssociatedAccountActivity", 2, "onUnBindSubAccount() mainAccount=" + paramazyv.b + " subAccount=" + paramazyv.c + " errType=" + paramazyv.jdField_a_of_type_Int + " errMsg=" + paramazyv.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramazyv == null) || (!TextUtils.equals(paramazyv.b, this.a.app.c()))) {}
    while (!paramBoolean) {
      return;
    }
    AssociatedAccountActivity.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acav
 * JD-Core Version:    0.7.0.1
 */