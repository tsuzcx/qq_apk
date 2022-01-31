import com.tencent.qidian.controller.BigDataHandler;
import com.tencent.qidian.controller.QidianBusinessObserver;

public class alus
  extends QidianBusinessObserver
{
  public alus(BigDataHandler paramBigDataHandler) {}
  
  protected void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean)
    {
      BigDataHandler.a(this.a);
      return;
    }
    BigDataHandler.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     alus
 * JD-Core Version:    0.7.0.1
 */