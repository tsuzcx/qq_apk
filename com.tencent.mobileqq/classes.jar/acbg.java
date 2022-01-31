import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout.ArkSearchReportCallback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppHandler;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import java.lang.ref.WeakReference;

public class acbg
  implements ArkAppRootLayout.ArkSearchReportCallback
{
  public acbg(ArkBabyqCardInfo paramArkBabyqCardInfo) {}
  
  public void a()
  {
    if ((this.a.mBabyQReplyMsg != null) && (this.a.mBabyQReplyMsg.get() != null))
    {
      MessageForArkBabyqReply localMessageForArkBabyqReply = (MessageForArkBabyqReply)this.a.mBabyQReplyMsg.get();
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (localQQAppInterface != null) {
        ((ArkAppHandler)localQQAppInterface.a(95)).a(localMessageForArkBabyqReply.arkSearchType, 0, 2, this.a.extra, localMessageForArkBabyqReply.arkMsgId, this.a.appName, this.a.appView, null, 0, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acbg
 * JD-Core Version:    0.7.0.1
 */