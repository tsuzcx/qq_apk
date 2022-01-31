import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class akua
  extends ajtb
{
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  bhwd jdField_a_of_type_Bhwd = null;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
  
  public akua(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bhwd != null)
    {
      this.jdField_a_of_type_Bhwd.a();
      this.jdField_a_of_type_Bhwd = null;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadInJoyHandler", 2, "readInJoyFeedsMsgNotify, isSuccess=" + paramBoolean1 + ",isNewMsgCome=" + paramBoolean2 + ",reason=" + paramInt);
    }
    notifyUI(1, paramBoolean1, new Object[] { Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt) });
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyHandler", 2, "handleOnlinePushReadInJoyFeedsMsg");
    }
  }
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null) {
      this.allowCmdSet = new HashSet();
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected Class<? extends ajte> observerClass()
  {
    return akuc.class;
  }
  
  public void onDestroy()
  {
    a();
    super.onDestroy();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akua
 * JD-Core Version:    0.7.0.1
 */