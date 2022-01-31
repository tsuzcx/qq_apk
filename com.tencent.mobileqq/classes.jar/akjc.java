import VIP.AIOKeyWordReq;
import VIP.AIOSendReq;
import VIP.AIOSendRes;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class akjc
  extends ajtb
{
  public static int a;
  public static String a;
  public static String b = "AIOSendSvc.getUserKeyWordStips";
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_a_of_type_JavaLangString = "AIOSendSvc.CheckPopGrayStips";
  }
  
  public akjc(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a(AIOSendReq paramAIOSendReq)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), jdField_a_of_type_JavaLangString);
    localToServiceMsg.extraData.putSerializable("VIPAioSendRequest", paramAIOSendReq);
    super.send(localToServiceMsg);
  }
  
  public void a(String paramString)
  {
    paramString = new AIOKeyWordReq(this.app.c(), paramString);
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), b);
    localToServiceMsg.extraData.putSerializable("VIPAioSendRequest", paramString);
    super.send(localToServiceMsg);
  }
  
  protected Class<? extends ajte> observerClass()
  {
    return akjd.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramObject == null))
    {
      notifyUI(jdField_a_of_type_Int, false, null);
      return;
    }
    paramToServiceMsg = paramToServiceMsg.getServiceCmd();
    if (jdField_a_of_type_JavaLangString.equals(paramToServiceMsg))
    {
      paramToServiceMsg = (AIOSendRes)paramObject;
      bbwn.a().a(this.app, paramToServiceMsg);
    }
    for (;;)
    {
      notifyUI(jdField_a_of_type_Int, true, paramObject);
      return;
      if (b.equals(paramToServiceMsg))
      {
        paramToServiceMsg = (AIOSendRes)paramObject;
        bbwo.a().a(this.app, paramToServiceMsg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akjc
 * JD-Core Version:    0.7.0.1
 */