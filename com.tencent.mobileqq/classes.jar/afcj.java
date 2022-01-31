import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;

class afcj
  extends ajxj
{
  afcj(afci paramafci) {}
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    afci.a(this.a).removeMessages(1);
    if ((this.a.jdField_a_of_type_Bcqf == null) || (!this.a.jdField_a_of_type_Bcqf.isShowing())) {
      QLog.e("SeparateForward", 1, new Object[] { "onGetFriendNickBatch timeout, isSuccess:", Boolean.valueOf(paramBoolean) });
    }
    for (;;)
    {
      return;
      this.a.jdField_a_of_type_Bcqf.dismiss();
      asua.a().b.clear();
      if ((paramBoolean) && (paramObject != null)) {
        asua.a().b.putAll((Map)paramObject);
      }
      if (asua.a().b.size() == 0)
      {
        BaseActivity localBaseActivity = (BaseActivity)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
        if (localBaseActivity != null) {
          bcql.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131698478, 0).b(localBaseActivity.getTitleBarHeight());
        }
      }
      while (QLog.isDevelopLevel())
      {
        QLog.d("MultiMsg_TAG", 4, "onGetFriendNickBatch = " + paramObject);
        return;
        this.a.a((Map)paramObject, asua.a().a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     afcj
 * JD-Core Version:    0.7.0.1
 */