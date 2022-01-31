import IMMsgBodyPack.SlaveMasterMsg;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import com.qq.taf.jce.JceInputStream;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class akay
  extends akac
{
  public akay(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private boolean a(MsgInfo paramMsgInfo)
  {
    JceInputStream localJceInputStream = new JceInputStream(paramMsgInfo.vMsg);
    SlaveMasterMsg localSlaveMasterMsg = new SlaveMasterMsg();
    localSlaveMasterMsg.readFrom(localJceInputStream);
    if (((int)localSlaveMasterMsg.uMsgType == 529) && (4L == localSlaveMasterMsg.uCmd))
    {
      awbg.a(this.a.a(), paramMsgInfo, localSlaveMasterMsg);
      return true;
    }
    return false;
  }
  
  public akbx a(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    boolean bool = false;
    switch (paramInt)
    {
    }
    for (;;)
    {
      return new akbx(null, bool);
      if ((paramMsgInfo != null) && (paramSvcReqPushMsg != null)) {
        bool = a(paramMsgInfo);
      } else {
        a(getClass().getName(), paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akay
 * JD-Core Version:    0.7.0.1
 */