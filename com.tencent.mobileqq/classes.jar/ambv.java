import KQQ.ReqItem;
import KQQ.RespItem;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class ambv
  extends FriendListHandler
  implements azal
{
  private ToServiceMsg a;
  
  public ambv(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a(int paramInt)
  {
    Object localObject1;
    if (this.app.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.a == 2)
    {
      localObject1 = (bdmq)this.app.getManager(31);
      if (localObject1 != null) {
        ((bdmq)localObject1).a(true, this);
      }
    }
    if (this.a != null)
    {
      Object localObject2 = this.app.jdField_a_of_type_Ayxz.a(this.a.getServiceCmd());
      if (localObject2 != null)
      {
        localObject1 = new UniPacket(true);
        ((UniPacket)localObject1).setEncodeName("utf-8");
        if (((zhu)localObject2).a(this.a, (UniPacket)localObject1))
        {
          localObject2 = new ReqItem();
          ((ReqItem)localObject2).eServiceID = 115;
          ((ReqItem)localObject2).vecParam = ((UniPacket)localObject1).encode();
          return localObject2;
        }
      }
    }
    return null;
  }
  
  public void a(RespItem paramRespItem)
  {
    if ((paramRespItem.eServiceID == 115) && (paramRespItem.cResult == 2))
    {
      FromServiceMsg localFromServiceMsg = new FromServiceMsg(this.app.getAccount(), "ProfileService.ReqGetSettings");
      localFromServiceMsg.setMsgSuccess();
      localFromServiceMsg.putWupBuffer(paramRespItem.vecUpdate);
      this.app.a(this.a, localFromServiceMsg);
    }
  }
  
  public void send(ToServiceMsg paramToServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "ReqGetSettingsItem.send...");
    }
    this.a = paramToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ambv
 * JD-Core Version:    0.7.0.1
 */