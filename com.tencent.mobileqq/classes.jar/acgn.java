import android.os.Message;
import com.tencent.mobileqq.activity.TroopAssistantActivity;

public class acgn
  extends ayvz
{
  public acgn(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i == 1003) || (i == 2003)) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acgn
 * JD-Core Version:    0.7.0.1
 */