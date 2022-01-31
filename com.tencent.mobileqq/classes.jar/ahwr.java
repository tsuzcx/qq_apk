import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;

public class ahwr
  implements Runnable
{
  public ahwr(UniteSearchActivity paramUniteSearchActivity) {}
  
  public void run()
  {
    SosoInterface.a(new ahws(this, 3, true, true, 180000L, false, false, "UniteSearch"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ahwr
 * JD-Core Version:    0.7.0.1
 */