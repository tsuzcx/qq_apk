import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQHeadDownloadHandler;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class ajpt
  implements INetInfoHandler
{
  private static WeakReference<QQAppInterface> a;
  
  public ajpt(QQAppInterface paramQQAppInterface)
  {
    a = new WeakReference(paramQQAppInterface);
  }
  
  private void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("raw_photo", 2, "type:" + paramInt + ",logmsg:" + paramString);
    }
    if ((a == null) || (a.get() == null)) {}
    do
    {
      return;
      if (1 == paramInt)
      {
        ((QQAppInterface)a.get()).E();
        return;
      }
    } while (2 != paramInt);
    ((QQAppInterface)a.get()).F();
  }
  
  public void onNetMobile2None()
  {
    a(3, "onNetMobile2None");
    ardv.a("Network", "onNetMobile2None()");
    if ((a == null) || (a.get() == null)) {}
    do
    {
      return;
      MqqHandler localMqqHandler = ((QQAppInterface)a.get()).getHandler(aoii.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10001, null).sendToTarget();
      }
      localMqqHandler = ((QQAppInterface)a.get()).getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10003, QQAppInterface.a((QQAppInterface)a.get()).getString(2131626719)).sendToTarget();
      }
      localMqqHandler = ((QQAppInterface)a.get()).getHandler(ChatHistoryC2CAllFragment.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(28, null).sendToTarget();
      }
      axpy.a().a();
      axve.a().a();
      ((QQAppInterface)a.get()).getHttpCommunicatort().a(1);
      QQHeadDownloadHandler.b();
    } while (QQAppInterface.i((QQAppInterface)a.get()) == null);
    QQAppInterface.j((QQAppInterface)a.get()).onNetMobile2None();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    a(2, "onNetMobile2Wifi");
    ardv.a("Network", "onNetMobile2Wifi()");
    if ((a == null) || (a.get() == null)) {}
    do
    {
      return;
      QQAppInterface localQQAppInterface = (QQAppInterface)a.get();
      MqqHandler localMqqHandler = localQQAppInterface.getHandler(aoii.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10001, null).sendToTarget();
      }
      localMqqHandler = localQQAppInterface.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10003, null).sendToTarget();
      }
      axpy.a().a();
      axve.a().a();
      localQQAppInterface.getHttpCommunicatort().a(1);
      QQHeadDownloadHandler.b();
      if (QQAppInterface.g(localQQAppInterface) != null) {
        QQAppInterface.h(localQQAppInterface).onNetMobile2Wifi(paramString);
      }
      localQQAppInterface.a();
      paramString = (amyp)localQQAppInterface.getManager(77);
      if (paramString != null) {
        paramString.a();
      }
      obz.a(localQQAppInterface);
      paramString = localQQAppInterface.getHandler(ShortVideoPlayActivity.class);
    } while (paramString == null);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPlayActivity", 2, "onNetMobile2Wifi");
    }
    paramString.obtainMessage(5).sendToTarget();
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    a(1, "onNetNone2Mobile");
    ardv.a("Network", "onNetNone2Mobile()");
    if ((a == null) || (a.get() == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)a.get();
    MqqHandler localMqqHandler = localQQAppInterface.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10003, null).sendToTarget();
    }
    localMqqHandler = localQQAppInterface.getHandler(ChatHistory.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(6, null).sendToTarget();
    }
    localMqqHandler = localQQAppInterface.getHandler(ChatHistoryC2CAllFragment.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(27).sendToTarget();
    }
    axpy.a().a();
    axve.a().a();
    localQQAppInterface.getHttpCommunicatort().a(2);
    QQHeadDownloadHandler.b();
    if (QQAppInterface.a(localQQAppInterface) != null) {
      QQAppInterface.b(localQQAppInterface).onNetNone2Mobile(paramString);
    }
    paramString = (amyp)localQQAppInterface.getManager(77);
    if (paramString != null) {
      paramString.a();
    }
    paramString = localQQAppInterface.getHandler(ShortVideoPlayActivity.class);
    if (paramString != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "onNetNone2Mobile");
      }
      paramString.obtainMessage(4).sendToTarget();
    }
    msl.a().b();
    atlb.a().b(localQQAppInterface);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    a(2, "onNetNone2Wifi");
    ardv.a("Network", "onNetNone2Wifi()");
    if ((a == null) || (a.get() == null)) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)a.get();
    MqqHandler localMqqHandler = localQQAppInterface.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10003, null).sendToTarget();
    }
    localMqqHandler = localQQAppInterface.getHandler(ChatHistory.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(6, null).sendToTarget();
    }
    localMqqHandler = localQQAppInterface.getHandler(ChatHistoryC2CAllFragment.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(27).sendToTarget();
    }
    axpy.a().a();
    axve.a().a();
    localQQAppInterface.getHttpCommunicatort().a(1);
    QQHeadDownloadHandler.b();
    if (QQAppInterface.e(localQQAppInterface) != null) {
      QQAppInterface.f(localQQAppInterface).onNetNone2Wifi(paramString);
    }
    localQQAppInterface.a();
    paramString = (amyp)localQQAppInterface.getManager(77);
    if (paramString != null) {
      paramString.a();
    }
    obz.a(localQQAppInterface);
    paramString = localQQAppInterface.getHandler(ShortVideoPlayActivity.class);
    if (paramString != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "onNetNone2Wifi");
      }
      paramString.obtainMessage(5).sendToTarget();
    }
    atlb.a().b(localQQAppInterface);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    a(1, "onNetWifi2Mobile");
    Object localObject = atqj.a();
    if (localObject != null) {
      ((atqj)localObject).b();
    }
    ardv.a("Network", "onNetWifi2Mobile()");
    if ((a == null) || (a.get() == null)) {
      return;
    }
    localObject = (QQAppInterface)a.get();
    MqqHandler localMqqHandler = ((QQAppInterface)localObject).getHandler(aoii.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10001, null).sendToTarget();
    }
    localMqqHandler = ((QQAppInterface)localObject).getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(10003, null).sendToTarget();
    }
    axpy.a().a();
    axve.a().a();
    ((QQAppInterface)localObject).getHttpCommunicatort().a(2);
    QQHeadDownloadHandler.b();
    if (QQAppInterface.c((QQAppInterface)localObject) != null) {
      QQAppInterface.d((QQAppInterface)localObject).onNetWifi2Mobile(paramString);
    }
    paramString = (amyp)((QQAppInterface)localObject).getManager(77);
    if (paramString != null) {
      paramString.a();
    }
    paramString = ((QQAppInterface)localObject).getHandler(ShortVideoPlayActivity.class);
    if (paramString != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPlayActivity", 2, "onNetWifi2Mobile");
      }
      paramString.obtainMessage(4).sendToTarget();
    }
    msl.a().b();
  }
  
  public void onNetWifi2None()
  {
    a(3, "onNetWifi2None");
    ardv.a("Network", "onNetWifi2None()");
    if ((a == null) || (a.get() == null)) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)a.get();
      MqqHandler localMqqHandler = localQQAppInterface.getHandler(aoii.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10001, null).sendToTarget();
      }
      localMqqHandler = localQQAppInterface.getHandler(Conversation.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(10003, QQAppInterface.b(localQQAppInterface).getString(2131626719)).sendToTarget();
      }
      localMqqHandler = localQQAppInterface.getHandler(ChatHistoryC2CAllFragment.class);
      if (localMqqHandler != null) {
        localMqqHandler.obtainMessage(28, null).sendToTarget();
      }
      axpy.a().a();
      axve.a().a();
      localQQAppInterface.getHttpCommunicatort().a(1);
      QQHeadDownloadHandler.b();
    } while (QQAppInterface.k(localQQAppInterface) == null);
    QQAppInterface.l(localQQAppInterface).onNetWifi2None();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ajpt
 * JD-Core Version:    0.7.0.1
 */