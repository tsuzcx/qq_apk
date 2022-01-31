import com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;

public class absf
  implements Runnable
{
  public absf(EmoticonFromGroupManager paramEmoticonFromGroupManager) {}
  
  public void run()
  {
    EmoticonFromGroupManager.a(this.a).b = (FavEmoConstant.a - this.a.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     absf
 * JD-Core Version:    0.7.0.1
 */