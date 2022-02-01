import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.GetAioListCallback;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.List;

public class abyx
  implements QQMessageFacade.GetAioListCallback
{
  public void onGetAioList(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, List<ChatMessage> paramList, QQMessageFacade paramQQMessageFacade)
  {
    if ((paramInt1 != 1001) && (paramInt1 != 10002) && (abwz.a(paramInt1) != 1032)) {
      return;
    }
    if (paramList == null) {}
    for (paramInt1 = 0;; paramInt1 = paramList.size())
    {
      paramInt1 -= 1;
      while (paramInt1 >= 0)
      {
        paramString = (ChatMessage)paramList.get(paramInt1);
        if ((paramString != null) && (paramString.msgtype == -4011)) {
          paramList.remove(paramString);
        }
        paramInt1 -= 1;
      }
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abyx
 * JD-Core Version:    0.7.0.1
 */