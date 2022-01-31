import com.tencent.mobileqq.emosm.web.EmojiIPCAlarmer;
import com.tencent.mobileqq.emosm.web.EmojiIPCAlarmer.TimeoutObserver;

public class acas
  implements Runnable
{
  private int jdField_a_of_type_Int;
  
  public acas(EmojiIPCAlarmer paramEmojiIPCAlarmer, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer.a != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebEmojiIPCAlarmer.a.a(this.jdField_a_of_type_Int);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     acas
 * JD-Core Version:    0.7.0.1
 */