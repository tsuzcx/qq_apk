import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;

class aerp
  extends ajjh
{
  aerp(aero paramaero) {}
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    aero.a(this.a).removeMessages(1);
    if ((this.a.jdField_a_of_type_Bbms == null) || (!this.a.jdField_a_of_type_Bbms.isShowing())) {
      QLog.e("SeparateForward", 1, new Object[] { "onGetFriendNickBatch timeout, isSuccess:", Boolean.valueOf(paramBoolean) });
    }
    for (;;)
    {
      return;
      this.a.jdField_a_of_type_Bbms.dismiss();
      arxu.a().b.clear();
      if ((paramBoolean) && (paramObject != null)) {
        arxu.a().b.putAll((Map)paramObject);
      }
      if (arxu.a().b.size() == 0)
      {
        BaseActivity localBaseActivity = (BaseActivity)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
        if (localBaseActivity != null) {
          bbmy.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131632732, 0).b(localBaseActivity.getTitleBarHeight());
        }
      }
      while (QLog.isDevelopLevel())
      {
        QLog.d("MultiMsg_TAG", 4, "onGetFriendNickBatch = " + paramObject);
        return;
        this.a.a((Map)paramObject, arxu.a().a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aerp
 * JD-Core Version:    0.7.0.1
 */