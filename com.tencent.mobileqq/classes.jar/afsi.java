import com.tencent.mobileqq.activity.TroopDisbandActivity;

public class afsi
  extends anyu
{
  public afsi(TroopDisbandActivity paramTroopDisbandActivity) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (this.a.a != null) && (this.a.a.a(paramString))) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     afsi
 * JD-Core Version:    0.7.0.1
 */