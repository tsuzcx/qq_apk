import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.1;

public class altv
{
  protected static boolean a = false;
  
  public static void a()
  {
    if (!a) {
      a = true;
    }
  }
  
  public static void a(altx paramaltx)
  {
    ThreadManager.post(new ArkMessageServerLogic.1(paramaltx), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     altv
 * JD-Core Version:    0.7.0.1
 */