import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.ArkMessageServerLogic.1;

public class alfi
{
  protected static boolean a = false;
  
  public static void a()
  {
    if (!a) {
      a = true;
    }
  }
  
  public static void a(alfk paramalfk)
  {
    ThreadManager.post(new ArkMessageServerLogic.1(paramalfk), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alfi
 * JD-Core Version:    0.7.0.1
 */