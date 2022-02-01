import android.os.Message;
import com.tencent.mobileqq.activity.TroopAssistantActivity;

public class afit
  extends bdzm
{
  public afit(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if ((i == 1003) || (i == 2003)) {
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afit
 * JD-Core Version:    0.7.0.1
 */