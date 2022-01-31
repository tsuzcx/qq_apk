import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class ajqo
  extends ajfb
{
  public ajqo(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  protected Class<? extends ajfe> observerClass()
  {
    return ajqp.class;
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
 * Qualified Name:     ajqo
 * JD-Core Version:    0.7.0.1
 */