import com.tencent.mobileqq.activity.TroopAssistantActivity;
import mqq.os.MqqHandler;

public class afbk
  extends aofu
{
  public afbk(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  protected void onBeKickOutTroop(String paramString)
  {
    this.a.c();
  }
  
  protected void onTroopBlockStatusChanged(String paramString)
  {
    this.a.c();
  }
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 6) {
      if (paramInt2 == 0) {
        this.a.a.sendEmptyMessage(1);
      }
    }
    while ((paramInt1 != 2) || (paramInt2 != 0)) {
      return;
    }
    awtz.a().b(paramString, this.a.app);
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afbk
 * JD-Core Version:    0.7.0.1
 */