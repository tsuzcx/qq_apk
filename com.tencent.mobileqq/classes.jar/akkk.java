import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.vashealth.VideoCallBack;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

public class akkk
  extends Handler
{
  public akkk(VideoCallBack paramVideoCallBack, QQProgressDialog paramQQProgressDialog, String paramString, Activity paramActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int i;
    do
    {
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      i = paramMessage.arg1;
      if (i != 0) {
        break;
      }
      paramMessage = paramMessage.getData().getString("maxvideo.file.mp4");
      Intent localIntent = new Intent();
      localIntent.putExtra("video_dir", paramMessage);
      localIntent.putExtra("thumb_dir", this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidAppActivity.setResult(1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
    } while (!QLog.isColorLevel());
    QLog.i("VideoCallBack", 2, "encode success: " + paramMessage);
    return;
    this.jdField_a_of_type_AndroidAppActivity.setResult(2);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    QLog.e("VideoCallBack", 1, "error! ret = " + i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akkk
 * JD-Core Version:    0.7.0.1
 */