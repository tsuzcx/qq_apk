import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.qphone.base.util.QLog;

public class adbh
  extends Handler
{
  public adbh(CommonRecordSoundPanel paramCommonRecordSoundPanel, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 16711687: 
      this.a.b(102);
      return;
    case 16711686: 
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "QQRecorder stop() is called,time is:" + System.currentTimeMillis());
      }
      CommonRecordSoundPanel.a(this.a).c();
      bbcf.b(2131230744, false);
      this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(16711686);
      bbcf.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, false);
      return;
    }
    this.a.b(1);
    this.a.b();
    bcql.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131698553), 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     adbh
 * JD-Core Version:    0.7.0.1
 */