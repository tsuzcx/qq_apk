import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;

class aiqq
  extends anmu
{
  aiqq(aiqp paramaiqp) {}
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    aiqp.a(this.a).removeMessages(1);
    if ((this.a.jdField_a_of_type_Biau == null) || (!this.a.jdField_a_of_type_Biau.isShowing())) {
      QLog.e("SeparateForward", 1, new Object[] { "onGetFriendNickBatch timeout, isSuccess:", Boolean.valueOf(paramBoolean) });
    }
    for (;;)
    {
      return;
      this.a.jdField_a_of_type_Biau.dismiss();
      awwm.a().b.clear();
      if ((paramBoolean) && (paramObject != null)) {
        awwm.a().b.putAll((Map)paramObject);
      }
      if (awwm.a().b.size() == 0)
      {
        BaseActivity localBaseActivity = (BaseActivity)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
        if (localBaseActivity != null) {
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131697671, 0).b(localBaseActivity.getTitleBarHeight());
        }
      }
      while (QLog.isDevelopLevel())
      {
        QLog.d("MultiMsg_TAG", 4, "onGetFriendNickBatch = " + paramObject);
        return;
        this.a.a((Map)paramObject, awwm.a().a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqq
 * JD-Core Version:    0.7.0.1
 */