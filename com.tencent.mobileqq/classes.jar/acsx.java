import android.text.TextUtils;
import com.tencent.mobileqq.activity.AssociatedAccountActivity;
import com.tencent.qphone.base.util.QLog;

public class acsx
  extends amwl
{
  public acsx(AssociatedAccountActivity paramAssociatedAccountActivity) {}
  
  public void onGetSubAccountMsg(boolean paramBoolean, String paramString, bcqu parambcqu)
  {
    if (AssociatedAccountActivity.a(this.a, paramString, parambcqu)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "onGetSubAccountMsg subAccount=" + paramString + " mIsFromPull=" + this.a.jdField_b_of_type_Boolean + " isSuccess=" + paramBoolean + "  mPullReqNeedBackNum=" + this.a.jdField_a_of_type_Int);
      }
      if (this.a.jdField_b_of_type_Boolean)
      {
        AssociatedAccountActivity.a(this.a, paramBoolean, true);
        return;
      }
      this.a.jdField_a_of_type_Int = 0;
      this.a.c = false;
      if ((paramBoolean) && (parambcqu.c))
      {
        this.a.c();
        return;
      }
    } while (!paramBoolean);
    this.a.a();
  }
  
  public void onPushSubAccountMsg(boolean paramBoolean, String paramString, bcqu parambcqu)
  {
    if (AssociatedAccountActivity.a(this.a, paramString, parambcqu)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "onPushSubAccountMsg subUin" + paramString);
      }
    } while (!paramBoolean);
    AssociatedAccountActivity.b(this.a, false);
  }
  
  public void onSubAccountMsgNumConfirm(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder().append("onSubAccountMsgNumConfirm isSuccess=").append(paramBoolean).append(" subUin=").append(paramString1).append(" set need2ConfirmMsgNum=");
      if (paramBoolean) {
        break label157;
      }
    }
    label157:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("AssociatedAccountActivity", 2, paramBoolean + " nextAction=" + paramString2 + " mNeed2ConfirmMsgNum=" + this.a.jdField_b_of_type_Int);
      if (!"sub.account.switchAccount".equals(paramString2)) {
        break;
      }
      paramString1 = this.a;
      paramString1.jdField_b_of_type_Int -= 1;
      if (this.a.jdField_b_of_type_Int <= 0) {
        AssociatedAccountActivity.b(this.a, false, this.a.jdField_a_of_type_JavaLangString);
      }
      if (this.a.jdField_b_of_type_Int >= 0) {
        break;
      }
      this.a.jdField_b_of_type_Int = 0;
      return;
    }
  }
  
  public void onSubAccountThirdQQUnreadMsgNum(boolean paramBoolean, String paramString, bcqv parambcqv)
  {
    if (AssociatedAccountActivity.a(this.a, paramString, parambcqv)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AssociatedAccountActivity", 2, "onSubAccountThirdQQUnreadMsgNum mIsFromPull=" + this.a.jdField_b_of_type_Boolean + "  mPullReqNeedBackNum=" + this.a.jdField_a_of_type_Int + " isSuccess=" + paramBoolean + "  mainAccount=" + paramString + "  data=" + parambcqv);
      }
      if (this.a.jdField_b_of_type_Boolean)
      {
        AssociatedAccountActivity.a(this.a, paramBoolean, false);
        return;
      }
      this.a.jdField_a_of_type_Int = 0;
      this.a.c = false;
    } while (!paramBoolean);
    AssociatedAccountActivity.a(this.a, parambcqv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acsx
 * JD-Core Version:    0.7.0.1
 */