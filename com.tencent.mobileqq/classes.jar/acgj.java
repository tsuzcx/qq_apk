import android.os.Message;
import com.tencent.mobileqq.activity.TroopAssistantActivity;

public class acgj
  extends aywb
{
  public acgj(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i == 1003) || (i == 2003)) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     acgj
 * JD-Core Version:    0.7.0.1
 */