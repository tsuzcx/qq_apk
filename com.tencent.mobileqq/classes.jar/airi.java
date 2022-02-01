import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;

class airi
  extends anvi
{
  airi(airh paramairh) {}
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject)
  {
    airh.a(this.a).removeMessages(1);
    if ((this.a.jdField_a_of_type_Bisl == null) || (!this.a.jdField_a_of_type_Bisl.isShowing())) {
      QLog.e("SeparateForward", 1, new Object[] { "onGetFriendNickBatch timeout, isSuccess:", Boolean.valueOf(paramBoolean) });
    }
    for (;;)
    {
      return;
      this.a.jdField_a_of_type_Bisl.dismiss();
      axio.a().b.clear();
      if ((paramBoolean) && (paramObject != null)) {
        axio.a().b.putAll((Map)paramObject);
      }
      if (axio.a().b.size() == 0)
      {
        BaseActivity localBaseActivity = (BaseActivity)this.a.jdField_a_of_type_MqqUtilWeakReference.get();
        if (localBaseActivity != null) {
          QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 2131698184, 0).b(localBaseActivity.getTitleBarHeight());
        }
      }
      while (QLog.isDevelopLevel())
      {
        QLog.d("MultiMsg_TAG", 4, "onGetFriendNickBatch = " + paramObject);
        return;
        this.a.a((Map)paramObject, axio.a().a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     airi
 * JD-Core Version:    0.7.0.1
 */