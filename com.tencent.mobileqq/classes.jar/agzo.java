import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;

class agzo
  extends alox
{
  agzo(agzn paramagzn) {}
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    agzn.a(this.a).removeMessages(1);
    if ((this.a.jdField_a_of_type_Bepp == null) || (!this.a.jdField_a_of_type_Bepp.isShowing())) {
      QLog.e("SeparateForward", 1, new Object[] { "onGetFriendNickBatch timeout, isSuccess:", Boolean.valueOf(paramBoolean) });
    }
    for (;;)
    {
      return;
      this.a.jdField_a_of_type_Bepp.dismiss();
      aukx.a().b.clear();
      if ((paramBoolean) && (paramObject != null)) {
        aukx.a().b.putAll((Map)paramObject);
      }
      if (aukx.a().b.size() == 0)
      {
        BaseActivity localBaseActivity = (BaseActivity)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
        if (localBaseActivity != null) {
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131698773, 0).b(localBaseActivity.getTitleBarHeight());
        }
      }
      while (QLog.isDevelopLevel())
      {
        QLog.d("MultiMsg_TAG", 4, "onGetFriendNickBatch = " + paramObject);
        return;
        this.a.a((Map)paramObject, aukx.a().a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agzo
 * JD-Core Version:    0.7.0.1
 */