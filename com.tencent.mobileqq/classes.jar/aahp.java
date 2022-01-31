import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import java.util.Map;

public class aahp
  implements asms
{
  public aahp(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    aahr localaahr;
    if (paramInt1 == 3)
    {
      localaahr = (aahr)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
      if (localaahr != null) {
        this.a.callJs(localaahr.g + "(" + localaahr.a() + ");");
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramInt1 != 5) {
              break;
            }
            localaahr = (aahr)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
          } while (localaahr == null);
          this.a.callJs(localaahr.f + "(" + localaahr.a() + ");");
          return;
          if (paramInt1 != 7) {
            break;
          }
          localaahr = (aahr)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
        } while (localaahr == null);
        this.a.callJs(localaahr.h + "(" + localaahr.a() + ");");
        return;
      } while (paramInt1 != 0);
      localaahr = (aahr)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
    } while (localaahr == null);
    this.a.callJs(localaahr.i + "(" + localaahr.a() + ");");
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    aahr localaahr = (aahr)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt));
    if (localaahr != null)
    {
      localaahr.c = paramBoolean;
      this.a.callJs(localaahr.d + "(" + localaahr.a() + ");");
    }
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    aahr localaahr = (aahr)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt));
    if (localaahr != null)
    {
      localaahr.a = paramBoolean;
      this.a.callJs(localaahr.e + "(" + localaahr.a() + ");");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aahp
 * JD-Core Version:    0.7.0.1
 */