import com.tencent.gamecenter.common.util.GameCenterAPIJavaScript;
import java.util.Map;

public class aciq
  implements avla
{
  public aciq(GameCenterAPIJavaScript paramGameCenterAPIJavaScript) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    acis localacis;
    if (paramInt1 == 3)
    {
      localacis = (acis)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
      if (localacis != null) {
        this.a.callJs(localacis.g + "(" + localacis.a() + ");");
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
            localacis = (acis)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
          } while (localacis == null);
          this.a.callJs(localacis.f + "(" + localacis.a() + ");");
          return;
          if (paramInt1 != 7) {
            break;
          }
          localacis = (acis)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
        } while (localacis == null);
        this.a.callJs(localacis.h + "(" + localacis.a() + ");");
        return;
      } while (paramInt1 != 0);
      localacis = (acis)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt2));
    } while (localacis == null);
    this.a.callJs(localacis.i + "(" + localacis.a() + ");");
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    acis localacis = (acis)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt));
    if (localacis != null)
    {
      localacis.c = paramBoolean;
      this.a.callJs(localacis.d + "(" + localacis.a() + ");");
    }
  }
  
  public void b(boolean paramBoolean, int paramInt)
  {
    acis localacis = (acis)GameCenterAPIJavaScript.access$100(this.a).get(Integer.valueOf(paramInt));
    if (localacis != null)
    {
      localacis.a = paramBoolean;
      this.a.callJs(localacis.e + "(" + localacis.a() + ");");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aciq
 * JD-Core Version:    0.7.0.1
 */