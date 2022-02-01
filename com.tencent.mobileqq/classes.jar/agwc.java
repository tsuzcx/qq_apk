import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;

public class agwc
  implements agvc
{
  private BaseChatPie a;
  
  public agwc(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 8)
    {
      if ((this.a.a() != null) && (this.a.a().getIntent() != null)) {
        break label44;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ReplyOnlyHelper", 2, "params is error");
      }
    }
    return;
    label44:
    Intent localIntent = this.a.a().getIntent();
    long l = localIntent.getLongExtra("key_reply_only_uniseq", 0L);
    ChatMessage localChatMessage;
    Object localObject2;
    Object localObject1;
    if (l > 0L)
    {
      localChatMessage = ((bbdj)this.a.a.getManager(340)).a(l);
      localObject2 = localIntent.getStringExtra("troop_code");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = "0";
      }
    }
    try
    {
      l = Long.parseLong((String)localObject1);
      localObject1 = null;
      if (l > 0L)
      {
        localObject2 = (TroopManager)this.a.a.getManager(52);
        localObject1 = l + "";
        localObject2 = ((TroopManager)localObject2).b((String)localObject1);
        if ((localObject2 != null) && (!TextUtils.isEmpty(((TroopInfo)localObject2).getTroopName()))) {
          localObject1 = ((TroopInfo)localObject2).getTroopName();
        }
      }
      else
      {
        this.a.a(localChatMessage, 0, l, (String)localObject1);
        localIntent.removeExtra("key_reply_only_uniseq");
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReplyOnlyHelper", 2, "replyMessageAtInput", localException);
        }
        l = 0L;
      }
    }
  }
  
  public int[] a()
  {
    return new int[] { 8 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agwc
 * JD-Core Version:    0.7.0.1
 */