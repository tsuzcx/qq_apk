import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import java.util.Map;

public class aceo
  implements auta
{
  public aceo(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    aceq localaceq;
    if (paramInt1 == 3)
    {
      localaceq = (aceq)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
      if (localaceq != null) {
        this.a.callJs(localaceq.g + "(" + localaceq.a() + ");");
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
            localaceq = (aceq)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
          } while (localaceq == null);
          this.a.callJs(localaceq.f + "(" + localaceq.a() + ");");
          return;
          if (paramInt1 != 7) {
            break;
          }
          localaceq = (aceq)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
        } while (localaceq == null);
        this.a.callJs(localaceq.h + "(" + localaceq.a() + ");");
        return;
      } while (paramInt1 != 0);
      localaceq = (aceq)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
    } while (localaceq == null);
    this.a.callJs(localaceq.i + "(" + localaceq.a() + ");");
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    aceq localaceq = (aceq)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt));
    if (localaceq != null)
    {
      localaceq.c = paramBoolean;
      this.a.callJs(localaceq.d + "(" + localaceq.a() + ");");
    }
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    aceq localaceq = (aceq)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt));
    if (localaceq != null)
    {
      localaceq.a = paramBoolean;
      this.a.callJs(localaceq.e + "(" + localaceq.a() + ");");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aceo
 * JD-Core Version:    0.7.0.1
 */