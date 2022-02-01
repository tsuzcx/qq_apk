import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import java.util.Map;

public class abez
  implements atya
{
  public abez(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void onAudioMute(boolean paramBoolean, int paramInt)
  {
    abfb localabfb = (abfb)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt));
    if (localabfb != null)
    {
      localabfb.a = paramBoolean;
      this.a.callJs(localabfb.e + "(" + localabfb.a() + ");");
    }
  }
  
  public void onSrceenModeChanged(boolean paramBoolean, int paramInt)
  {
    abfb localabfb = (abfb)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt));
    if (localabfb != null)
    {
      localabfb.c = paramBoolean;
      this.a.callJs(localabfb.d + "(" + localabfb.a() + ");");
    }
  }
  
  public void onVideoStatusChanged(int paramInt1, int paramInt2)
  {
    abfb localabfb;
    if (paramInt1 == 3)
    {
      localabfb = (abfb)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
      if (localabfb != null) {
        this.a.callJs(localabfb.g + "(" + localabfb.a() + ");");
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
            localabfb = (abfb)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
          } while (localabfb == null);
          this.a.callJs(localabfb.f + "(" + localabfb.a() + ");");
          return;
          if (paramInt1 != 7) {
            break;
          }
          localabfb = (abfb)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
        } while (localabfb == null);
        this.a.callJs(localabfb.h + "(" + localabfb.a() + ");");
        return;
      } while (paramInt1 != 0);
      localabfb = (abfb)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
    } while (localabfb == null);
    this.a.callJs(localabfb.i + "(" + localabfb.a() + ");");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abez
 * JD-Core Version:    0.7.0.1
 */