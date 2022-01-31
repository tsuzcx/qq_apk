import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class aisq
  implements Manager
{
  public static String a = "ApolloNativeSSOReqMgr";
  
  public aisq(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "[ApolloNativeSSOReqMgr]");
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aisq
 * JD-Core Version:    0.7.0.1
 */