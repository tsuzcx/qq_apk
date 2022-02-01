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
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class akrv
  extends Handler
{
  private final WeakReference<SendPhotoActivity> a;
  
  public akrv(SendPhotoActivity paramSendPhotoActivity)
  {
    this.a = new WeakReference(paramSendPhotoActivity);
  }
  
  public void handleMessage(Message paramMessage)
  {
    SendPhotoActivity localSendPhotoActivity = (SendPhotoActivity)this.a.get();
    if (localSendPhotoActivity != null) {
      switch (paramMessage.what)
      {
      default: 
        super.handleMessage(paramMessage);
      }
    }
    label399:
    label555:
    do
    {
      return;
      localSendPhotoActivity.finish();
      return;
      localSendPhotoActivity.a(2131694337);
      return;
      if (localSendPhotoActivity.jdField_a_of_type_AndroidOsHandler.hasMessages(2))
      {
        azpw.b(SendPhotoActivity.jdField_a_of_type_JavaLangString, "handleMessage", "remove delayed Message:MSG_CANCLE_PROGRESS");
        localSendPhotoActivity.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      }
      Object localObject2;
      Object localObject1;
      if ((localSendPhotoActivity.jdField_a_of_type_AndroidAppProgressDialog != null) && (localSendPhotoActivity.jdField_a_of_type_AndroidAppProgressDialog.isShowing()))
      {
        bool1 = true;
        localSendPhotoActivity.b();
        localObject2 = localSendPhotoActivity.getIntent().getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
        {
          localObject1 = new String[((ArrayList)localObject2).size()];
          ((ArrayList)localObject2).toArray((Object[])localObject1);
          i = localSendPhotoActivity.getIntent().getIntExtra("uintype", 1003);
          localObject2 = localSendPhotoActivity.app;
          if ((paramMessage.obj == null) || (!"TimeOut".equals(paramMessage.obj.toString()))) {
            break label399;
          }
        }
      }
      ArrayList localArrayList;
      for (boolean bool2 = true;; bool2 = false)
      {
        ThreadManager.post(new SendPhotoActivity.MyHandler.1(this, bool2, (String[])localObject1, i, (QQAppInterface)localObject2), 5, null, true);
        localObject2 = localSendPhotoActivity.getIntent();
        ((Intent)localObject2).putExtra(bhkc.h, 2);
        if (!((Intent)localObject2).hasExtra("extra_image_sender_tag")) {
          ((Intent)localObject2).putExtra("extra_image_sender_tag", "SendPhotoActivity.handlePhoto");
        }
        localObject1 = null;
        Object localObject3 = paramMessage.getData();
        localArrayList = new ArrayList();
        paramMessage = (Message)localObject1;
        if (localObject3 == null) {
          break label555;
        }
        ((Bundle)localObject3).setClassLoader(CompressInfo.class.getClassLoader());
        paramMessage = ((Bundle)localObject3).getParcelableArrayList("flag_compressinfolist");
        if (paramMessage == null) {
          break label555;
        }
        localObject1 = paramMessage.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (CompressInfo)((Iterator)localObject1).next();
          azpw.a(SendPhotoActivity.jdField_a_of_type_JavaLangString, "handleMessage print CompressInfo", "info:" + localObject3);
          localArrayList.add(((CompressInfo)localObject3).e);
        }
        bool1 = false;
        break;
      }
      int i = paramMessage.size();
      long l1 = System.nanoTime();
      long l2 = (l1 - localSendPhotoActivity.b) / 1000000L;
      azpw.a(SendPhotoActivity.jdField_a_of_type_JavaLangString, "CompressLog", "compress startTime = " + localSendPhotoActivity.b + "ns,finishTime = " + l1 + "ns,duration = " + l2 + "ms,count = " + i + ",isShowing = " + bool1);
      akrx.a(l2, i, bool1);
      localSendPhotoActivity.app.a().a(l1);
      azpw.a(SendPhotoActivity.jdField_a_of_type_JavaLangString, "TimeCompare", "CompressFinish Time = " + l1 + "ns");
      ((Intent)localObject2).putExtra("open_chatfragment_fromphoto", true);
      SendPhotoActivity.a(localSendPhotoActivity, localArrayList);
      ((Intent)localObject2).removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
      localSendPhotoActivity.setResult(-1, localSendPhotoActivity.getIntent());
      localSendPhotoActivity.finish();
      boolean bool1 = localSendPhotoActivity.getIntent().getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "sendPhotoActivity isWaitForResult=" + bool1);
      }
      if (!bool1)
      {
        localObject1 = localSendPhotoActivity.getIntent();
        localObject2 = ((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        ((Intent)localObject1).setClassName(((Intent)localObject1).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), (String)localObject2);
        ((Intent)localObject1).addFlags(603979776);
        localSendPhotoActivity.startActivity((Intent)localObject1);
      }
      azru.a(BaseApplication.getContext(), paramMessage);
      return;
      if (QLog.isColorLevel()) {
        QLog.e(SendPhotoActivity.jdField_a_of_type_JavaLangString, 2, "idleHandler time out");
      }
    } while (localSendPhotoActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoTask != null);
    Looper.myQueue().removeIdleHandler(localSendPhotoActivity.jdField_a_of_type_AndroidOsMessageQueue$IdleHandler);
    localSendPhotoActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoTask = new SendPhotoTask(localSendPhotoActivity, null, localSendPhotoActivity.jdField_a_of_type_AndroidOsHandler);
    if (localSendPhotoActivity.jdField_a_of_type_Long != 0L) {
      localSendPhotoActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoTask.jdField_a_of_type_Long = (SystemClock.uptimeMillis() - localSendPhotoActivity.jdField_a_of_type_Long);
    }
    ThreadManager.post(localSendPhotoActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoSendPhotoTask, 8, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     akrv
 * JD-Core Version:    0.7.0.1
 */