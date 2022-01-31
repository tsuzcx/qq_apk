import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.SystemClock;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity.MyHandler.1;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity.sendPhotoTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class agef
  extends Handler
{
  private final WeakReference<SendPhotoActivity> a;
  
  public agef(SendPhotoActivity paramSendPhotoActivity)
  {
    this.a = new WeakReference(paramSendPhotoActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    SendPhotoActivity localSendPhotoActivity = (SendPhotoActivity)this.a.get();
    if (localSendPhotoActivity != null) {}
    Object localObject2;
    Object localObject1;
    int i;
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
    case 1: 
      return;
    case 2: 
      if (localSendPhotoActivity.jdField_a_of_type_AndroidOsHandler.hasMessages(2))
      {
        atpg.b(SendPhotoActivity.jdField_a_of_type_JavaLangString, "handleMessage", "remove delayed Message:MSG_CANCLE_PROGRESS");
        localSendPhotoActivity.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      }
      localObject2 = localSendPhotoActivity.getIntent().getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject1 = new String[((ArrayList)localObject2).size()];
        ((ArrayList)localObject2).toArray((Object[])localObject1);
        i = localSendPhotoActivity.getIntent().getIntExtra("uintype", 1003);
        localObject2 = localSendPhotoActivity.app;
        if ((paramMessage.obj != null) && ("TimeOut".equals(paramMessage.obj.toString())))
        {
          bool = true;
          ThreadManager.post(new SendPhotoActivity.MyHandler.1(this, bool, (String[])localObject1, i, (QQAppInterface)localObject2), 5, null, true);
        }
      }
      else
      {
        if ((localSendPhotoActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity$sendPhotoTask == null) || (localSendPhotoActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity$sendPhotoTask.jdField_a_of_type_AndroidAppProgressDialog == null) || (!localSendPhotoActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity$sendPhotoTask.jdField_a_of_type_AndroidAppProgressDialog.isShowing())) {
          break label824;
        }
      }
      break;
    }
    label824:
    for (boolean bool = true;; bool = false)
    {
      for (;;)
      {
        if (localSendPhotoActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity$sendPhotoTask != null) {}
        try
        {
          localSendPhotoActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity$sendPhotoTask.a();
          localObject2 = localSendPhotoActivity.getIntent();
          ((Intent)localObject2).putExtra(baae.h, 2);
          if (!((Intent)localObject2).hasExtra("extra_image_sender_tag")) {
            ((Intent)localObject2).putExtra("extra_image_sender_tag", "SendPhotoActivity.handlePhoto");
          }
          localObject1 = null;
          Object localObject3 = paramMessage.getData();
          int j = 0;
          localArrayList = new ArrayList();
          i = j;
          paramMessage = (Message)localObject1;
          if (localObject3 != null)
          {
            ((Bundle)localObject3).setClassLoader(CompressInfo.class.getClassLoader());
            localObject1 = ((Bundle)localObject3).getParcelableArrayList("flag_compressinfolist");
            i = j;
            paramMessage = (Message)localObject1;
            if (localObject1 != null)
            {
              paramMessage = ((ArrayList)localObject1).iterator();
              while (paramMessage.hasNext())
              {
                localObject3 = (CompressInfo)paramMessage.next();
                atpg.a(SendPhotoActivity.jdField_a_of_type_JavaLangString, "handleMessage print CompressInfo", "info:" + localObject3);
                localArrayList.add(((CompressInfo)localObject3).e);
                continue;
                bool = false;
              }
            }
          }
        }
        catch (Exception localException)
        {
          ArrayList localArrayList;
          for (;;)
          {
            localException.printStackTrace();
          }
          i = localException.size();
          paramMessage = localException;
          long l1 = System.nanoTime();
          long l2 = (l1 - localSendPhotoActivity.b) / 1000000L;
          atpg.a(SendPhotoActivity.jdField_a_of_type_JavaLangString, "CompressLog", "compress startTime = " + localSendPhotoActivity.b + "ns,finishTime = " + l1 + "ns,duration = " + l2 + "ms,count = " + i + ",isShowing = " + bool);
          ageh.a(l2, i, bool);
          localSendPhotoActivity.app.a().a(l1);
          atpg.a(SendPhotoActivity.jdField_a_of_type_JavaLangString, "TimeCompare", "CompressFinish Time = " + l1 + "ns");
          ((Intent)localObject2).putExtra("open_chatfragment_fromphoto", true);
          SendPhotoActivity.a(localSendPhotoActivity, localArrayList);
          ((Intent)localObject2).removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
          localSendPhotoActivity.setResult(-1, localSendPhotoActivity.getIntent());
          localSendPhotoActivity.finish();
          bool = localSendPhotoActivity.getIntent().getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
          if (QLog.isColorLevel()) {
            QLog.d("forward", 2, "sendPhotoActivity isWaitForResult=" + bool);
          }
          if (!bool)
          {
            Intent localIntent = localSendPhotoActivity.getIntent();
            localObject2 = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
            localIntent.setClassName(localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject2);
            localIntent.addFlags(603979776);
            localSendPhotoActivity.startActivity(localIntent);
          }
          atra.a(BaseApplication.getContext(), paramMessage);
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "idleHandler time out");
      }
      if (localSendPhotoActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity$sendPhotoTask != null) {
        break;
      }
      Looper.myQueue().removeIdleHandler(localSendPhotoActivity.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
      localSendPhotoActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity$sendPhotoTask = new SendPhotoActivity.sendPhotoTask(localSendPhotoActivity, null);
      if (localSendPhotoActivity.jdField_a_of_type_Long != 0L) {
        localSendPhotoActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity$sendPhotoTask.jdField_a_of_type_Long = (SystemClock.uptimeMillis() - localSendPhotoActivity.jdField_a_of_type_Long);
      }
      ThreadManager.post(localSendPhotoActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoActivity$sendPhotoTask, 8, null, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     agef
 * JD-Core Version:    0.7.0.1
 */