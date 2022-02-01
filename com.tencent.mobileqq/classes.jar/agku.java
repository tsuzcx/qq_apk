import KQQ.ReqItem;
import KQQ.RespItem;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.GetResourceReqInfo;

public class agku
  extends anvl
  implements bcuc
{
  private ToServiceMsg a;
  
  public agku(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public int a()
  {
    return 7;
  }
  
  public ReqItem a(int paramInt)
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.d("AioAnimationConfigCheckUpdateItem", 2, "getCheckUpdateItemData:");
    }
    a(null, new GetResourceReqInfo[] { a() });
    Object localObject1 = localObject2;
    if (this.a != null)
    {
      abiv localabiv = this.app.a.a(this.a.getServiceCmd());
      localObject1 = localObject2;
      if (localabiv != null)
      {
        UniPacket localUniPacket = new UniPacket(true);
        localUniPacket.setEncodeName("utf-8");
        localObject1 = localObject2;
        if (localabiv.a(this.a, localUniPacket))
        {
          localObject1 = new ReqItem();
          ((ReqItem)localObject1).eServiceID = 120;
          ((ReqItem)localObject1).vecParam = localUniPacket.encode();
        }
      }
    }
    return localObject1;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (paramRespItem != null)
    {
      int i = paramRespItem.cResult;
      Object localObject = paramRespItem.vecUpdate;
      if (QLog.isColorLevel()) {
        QLog.d("AioAnimationConfigCheckUpdateItem", 2, "handleCheckUpdateItemData: item.cResult = " + i + ", dataLen = " + localObject.length);
      }
      if ((paramRespItem.eServiceID == 120) && (paramRespItem.cResult == 2))
      {
        localObject = new FromServiceMsg(this.app.getAccount(), "ResourceConfig.GetResourceReq");
        ((FromServiceMsg)localObject).setMsgSuccess();
        ((FromServiceMsg)localObject).putWupBuffer(paramRespItem.vecUpdate);
        this.app.a(this.a, (FromServiceMsg)localObject);
      }
    }
  }
  
  public void send(ToServiceMsg paramToServiceMsg)
  {
    this.a = paramToServiceMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agku
 * JD-Core Version:    0.7.0.1
 */