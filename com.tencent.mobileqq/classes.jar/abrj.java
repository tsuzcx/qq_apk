import android.content.Intent;
import android.os.Message;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicUtils;
import com.tencent.mobileqq.avatar.dynamicavatar.SelectCoverActivity;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class abrj
  extends TransProcessorHandler
{
  WeakReference a;
  WeakReference b;
  
  public abrj(QQAppInterface paramQQAppInterface, SelectCoverActivity paramSelectCoverActivity)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramSelectCoverActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.get();
    SelectCoverActivity localSelectCoverActivity = (SelectCoverActivity)this.b.get();
    if ((localQQAppInterface == null) || (localSelectCoverActivity == null)) {}
    Object localObject;
    label290:
    do
    {
      return;
      localObject = (FileMsg)paramMessage.obj;
      switch (paramMessage.what)
      {
      case 1004: 
      default: 
        return;
      case 1003: 
        if (((FileMsg)localObject).b == 48)
        {
          paramMessage = ((NearbyPeoplePhotoUploadProcessor)((FileMsg)localObject).a).a;
          if (QLog.isColorLevel()) {
            QLog.i("SelectCoverActivity", 2, "mPhotoUploadHandler.handleMessage(), static avatar upload success. photoId = " + paramMessage);
          }
          paramMessage = (CardHandler)localQQAppInterface.a(2);
          if (paramMessage != null) {
            paramMessage.a(true, localQQAppInterface.getCurrentAccountUin(), 0);
          }
          ProfileCardUtil.a(null);
          if (((Integer)NearbySPUtil.a(localQQAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue() != 1) {
            NearbySPUtil.a(localQQAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(1));
          }
          int i = localSelectCoverActivity.f;
          localObject = localSelectCoverActivity.c;
          String str = localSelectCoverActivity.d;
          if (localSelectCoverActivity.a)
          {
            paramMessage = "1";
            ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800711D", "0X800711D", 0, 0, String.valueOf(i), (String)localObject, str, paramMessage);
            if (!SelectCoverActivity.a(localSelectCoverActivity)) {
              break label290;
            }
            paramMessage = new Intent();
            paramMessage.putExtra("key_photo_file_path", SelectCoverActivity.a(localSelectCoverActivity));
            localSelectCoverActivity.setResult(-1, paramMessage);
          }
          for (;;)
          {
            localSelectCoverActivity.finish();
            return;
            paramMessage = "0";
            break;
            localSelectCoverActivity.setResult(-1);
          }
        }
        if (((FileMsg)localObject).b == 36)
        {
          paramMessage = ((NearbyPeoplePhotoUploadProcessor)((FileMsg)localObject).a).m;
          if (QLog.isColorLevel()) {
            QLog.i("SelectCoverActivity", 2, "mPhotoUploadHandler.handleMessage(), big video upload success. videoId = " + paramMessage);
          }
          ThreadManager.post(new abrk(this, localSelectCoverActivity, localQQAppInterface), 8, null, true);
          return;
        }
        if (((FileMsg)localObject).b == 37)
        {
          paramMessage = ((NearbyPeoplePhotoUploadProcessor)((FileMsg)localObject).a).m;
          if (QLog.isColorLevel()) {
            QLog.i("SelectCoverActivity", 2, "mPhotoUploadHandler.handleMessage(), medium video upload success. videoId = " + paramMessage);
          }
          ThreadManager.post(new abrl(this, localSelectCoverActivity, localQQAppInterface), 8, null, true);
          return;
        }
        break;
      }
    } while (((FileMsg)localObject).b != 38);
    paramMessage = ((NearbyPeoplePhotoUploadProcessor)((FileMsg)localObject).a).m;
    if (QLog.isColorLevel()) {
      QLog.i("SelectCoverActivity", 2, "mPhotoUploadHandler.handleMessage(), small video upload success. videoId = " + paramMessage);
    }
    DynamicUtils.a(localQQAppInterface, localSelectCoverActivity.b);
    ProfileCardUtil.a(localSelectCoverActivity.b);
    return;
    if (QLog.isColorLevel()) {
      QLog.i("SelectCoverActivity", 2, "mPhotoUploadHandler.handleMessage(), upload photo failed.");
    }
    SelectCoverActivity.a(localSelectCoverActivity, 2, "上传失败，请重试", 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abrj
 * JD-Core Version:    0.7.0.1
 */