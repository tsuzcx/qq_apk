import android.content.Context;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopMediaFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

public class ajtz
  extends bgjg
{
  public ajtz(ChatHistoryTroopMediaFragment paramChatHistoryTroopMediaFragment, Context paramContext, bgjf parambgjf, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, parambgjf, paramQQAppInterface);
  }
  
  protected void b(Object paramObject)
  {
    super.b(paramObject);
    if (this.a.a != null) {
      this.a.a.sendEmptyMessage(102);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajtz
 * JD-Core Version:    0.7.0.1
 */