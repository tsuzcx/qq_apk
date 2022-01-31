import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class ambc
  extends alpd
{
  public ambc(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class<? extends alpg> observerClass()
  {
    return ambd.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("QzoneService.GetNewAndUnread".equals(paramToServiceMsg.getServiceCmd()))
    {
      if (paramObject == null) {
        notifyUI(1, false, null);
      }
    }
    else {
      return;
    }
    notifyUI(1, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ambc
 * JD-Core Version:    0.7.0.1
 */