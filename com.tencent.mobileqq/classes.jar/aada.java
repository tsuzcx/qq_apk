import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import java.util.Map;

public class aada
  implements asij
{
  public aada(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    aadc localaadc;
    if (paramInt1 == 3)
    {
      localaadc = (aadc)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
      if (localaadc != null) {
        this.a.callJs(localaadc.g + "(" + localaadc.a() + ");");
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
            localaadc = (aadc)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
          } while (localaadc == null);
          this.a.callJs(localaadc.f + "(" + localaadc.a() + ");");
          return;
          if (paramInt1 != 7) {
            break;
          }
          localaadc = (aadc)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
        } while (localaadc == null);
        this.a.callJs(localaadc.h + "(" + localaadc.a() + ");");
        return;
      } while (paramInt1 != 0);
      localaadc = (aadc)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
    } while (localaadc == null);
    this.a.callJs(localaadc.i + "(" + localaadc.a() + ");");
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    aadc localaadc = (aadc)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt));
    if (localaadc != null)
    {
      localaadc.c = paramBoolean;
      this.a.callJs(localaadc.d + "(" + localaadc.a() + ");");
    }
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    aadc localaadc = (aadc)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt));
    if (localaadc != null)
    {
      localaadc.a = paramBoolean;
      this.a.callJs(localaadc.e + "(" + localaadc.a() + ");");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aada
 * JD-Core Version:    0.7.0.1
 */