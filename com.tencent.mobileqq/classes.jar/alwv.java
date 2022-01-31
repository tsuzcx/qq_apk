import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class alwv
  extends Handler
{
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<Message> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public alwv(MessageHandler paramMessageHandler, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label69;
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext()) {
        sendMessage((Message)localIterator.next());
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    label69:
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "updateUnreadWorker doC2CUpdateNow");
    }
  }
  
  public void a(Message paramMessage)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashSet)
    {
      paramMessage = paramMessage.getData();
      if ((paramMessage != null) && (paramMessage.containsKey("update_unread_uin")) && (paramMessage.containsKey("update_unread_time")))
      {
        String str = paramMessage.getString("update_unread_uin");
        int i = paramMessage.getInt("update_unread_type", 0);
        long l = paramMessage.getLong("update_unread_time");
        this.jdField_a_of_type_JavaUtilHashSet.add(abti.a(str, i) + "&" + l);
      }
      return;
    }
  }
  
  void a(String paramString, int paramInt, long paramLong)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashSet)
    {
      if (this.jdField_a_of_type_JavaUtilHashSet.contains(abti.a(paramString, paramInt) + "&" + paramLong)) {
        this.jdField_a_of_type_JavaUtilHashSet.remove(abti.a(paramString, paramInt) + "&" + paramLong);
      }
      return;
    }
  }
  
  public boolean a(Message paramMessage)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashSet)
    {
      paramMessage = paramMessage.getData();
      if ((paramMessage != null) && (paramMessage.containsKey("update_unread_uin")) && (paramMessage.containsKey("update_unread_time")))
      {
        String str = paramMessage.getString("update_unread_uin");
        int i = paramMessage.getInt("update_unread_type", 0);
        long l = paramMessage.getLong("update_unread_time");
        boolean bool = this.jdField_a_of_type_JavaUtilHashSet.contains(abti.a(str, i) + "&" + l);
        return bool;
      }
      return false;
    }
  }
  
  public void b(Message paramMessage)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramMessage);
      return;
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        return;
        paramMessage = paramMessage.getData();
      } while ((paramMessage == null) || (!paramMessage.containsKey("update_unread_uin")) || (!paramMessage.containsKey("update_unread_time")));
      String str = paramMessage.getString("update_unread_uin");
      int i = paramMessage.getInt("update_unread_type", 0);
      long l = paramMessage.getLong("update_unread_time");
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageHandler", 2, "msg update_c2c_unread-->uin:" + str + ", uinType:" + i + ", lastReadTime:" + l);
      }
      a(str, i, l);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.app.a().a(str, i, l);
      this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(2002, true, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageHandler", 2, "updateUnreadWorker C2CWorkerTimeout");
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alwv
 * JD-Core Version:    0.7.0.1
 */