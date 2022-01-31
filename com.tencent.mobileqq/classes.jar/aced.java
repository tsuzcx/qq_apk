import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;

public class aced
  implements Runnable
{
  public aced(EmoticonLinearLayout paramEmoticonLinearLayout) {}
  
  public void run()
  {
    if (this.a.a != null)
    {
      this.a.a.b();
      this.a.postDelayed(this, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aced
 * JD-Core Version:    0.7.0.1
 */