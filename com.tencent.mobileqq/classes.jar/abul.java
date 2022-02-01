import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import java.util.Map;

public class abul
  implements avdp
{
  public abul(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void onAudioMute(boolean paramBoolean, int paramInt)
  {
    abuq localabuq = (abuq)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt));
    if (localabuq != null)
    {
      localabuq.a = paramBoolean;
      this.a.callJs(localabuq.e + "(" + localabuq.a() + ");");
    }
  }
  
  public void onSrceenModeChanged(boolean paramBoolean, int paramInt)
  {
    abuq localabuq = (abuq)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt));
    if (localabuq != null)
    {
      localabuq.c = paramBoolean;
      this.a.callJs(localabuq.d + "(" + localabuq.a() + ");");
    }
  }
  
  public void onVideoStatusChanged(int paramInt1, int paramInt2)
  {
    abuq localabuq;
    if (paramInt1 == 3)
    {
      localabuq = (abuq)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
      if (localabuq != null) {
        this.a.callJs(localabuq.g + "(" + localabuq.a() + ");");
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
            localabuq = (abuq)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
          } while (localabuq == null);
          this.a.callJs(localabuq.f + "(" + localabuq.a() + ");");
          return;
          if (paramInt1 != 7) {
            break;
          }
          localabuq = (abuq)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
        } while (localabuq == null);
        this.a.callJs(localabuq.h + "(" + localabuq.a() + ");");
        return;
      } while (paramInt1 != 0);
      localabuq = (abuq)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
    } while (localabuq == null);
    this.a.callJs(localabuq.i + "(" + localabuq.a() + ");");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abul
 * JD-Core Version:    0.7.0.1
 */