import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import java.util.Map;

public class abum
  implements avdn
{
  public abum(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    abuq localabuq = (abuq)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
    if (localabuq != null)
    {
      localabuq.e = (paramInt1 / 1000);
      this.a.callJs(localabuq.j + "(" + localabuq.a() + ");");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abum
 * JD-Core Version:    0.7.0.1
 */