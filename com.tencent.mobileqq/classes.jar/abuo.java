import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import java.util.Map;

public class abuo
  implements avdm
{
  public abuo(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    abuq localabuq = (abuq)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt));
    if (localabuq != null)
    {
      localabuq.d = paramBoolean;
      this.a.callJs(localabuq.l + "(" + localabuq.a() + ");");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abuo
 * JD-Core Version:    0.7.0.1
 */