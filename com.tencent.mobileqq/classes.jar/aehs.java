import android.text.TextUtils;
import com.tencent.mobileqq.activity.StructMsgObserver.1;
import com.tencent.mobileqq.activity.StructMsgObserver.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.util.Observable;
import java.util.Observer;

public class aehs
  implements Observer
{
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!aeub.a) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!(paramObject instanceof MessageForStructing)) {
              break;
            }
            paramObject = (MessageForStructing)paramObject;
            paramObservable = paramObject.structingMsg;
          } while ((paramObject.isSend()) || (!aeub.a(paramObservable)));
          paramObject = paramObservable.mMsgUrl;
          str1 = paramObservable.currentAccountUin;
          str2 = paramObservable.uin;
          ThreadManager.post(new StructMsgObserver.1(this, paramObject, paramObservable.uinType, str1, str2), 5, null, false);
          return;
        } while (!(paramObject instanceof MessageForText));
        paramObservable = (MessageForText)paramObject;
      } while ((paramObservable.isSend()) || (TextUtils.isEmpty(paramObservable.msg)));
      paramObject = aeub.c(paramObservable.msg);
    } while (TextUtils.isEmpty(paramObject));
    String str1 = paramObservable.frienduin;
    String str2 = paramObservable.selfuin;
    ThreadManager.post(new StructMsgObserver.2(this, paramObject, paramObservable.istroop, str2, str1), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aehs
 * JD-Core Version:    0.7.0.1
 */