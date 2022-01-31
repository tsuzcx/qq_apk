import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;

class afcl
  extends ajxl
{
  afcl(afck paramafck) {}
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    afck.a(this.a).removeMessages(1);
    if ((this.a.jdField_a_of_type_Bcpq == null) || (!this.a.jdField_a_of_type_Bcpq.isShowing())) {
      QLog.e("SeparateForward", 1, new Object[] { "onGetFriendNickBatch timeout, isSuccess:", Boolean.valueOf(paramBoolean) });
    }
    for (;;)
    {
      return;
      this.a.jdField_a_of_type_Bcpq.dismiss();
      asty.a().b.clear();
      if ((paramBoolean) && (paramObject != null)) {
        asty.a().b.putAll((Map)paramObject);
      }
      if (asty.a().b.size() == 0)
      {
        BaseActivity localBaseActivity = (BaseActivity)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
        if (localBaseActivity != null) {
          bcpw.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131698468, 0).b(localBaseActivity.getTitleBarHeight());
        }
      }
      while (QLog.isDevelopLevel())
      {
        QLog.d("MultiMsg_TAG", 4, "onGetFriendNickBatch = " + paramObject);
        return;
        this.a.a((Map)paramObject, asty.a().a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afcl
 * JD-Core Version:    0.7.0.1
 */