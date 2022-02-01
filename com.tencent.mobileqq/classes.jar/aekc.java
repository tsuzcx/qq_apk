import com.tencent.mobileqq.activity.TroopAssistantActivity;
import mqq.os.MqqHandler;

public class aekc
  extends andd
{
  public aekc(TroopAssistantActivity paramTroopAssistantActivity) {}
  
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
    avnu.a().b(paramString, this.a.app);
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aekc
 * JD-Core Version:    0.7.0.1
 */