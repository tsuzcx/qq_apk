import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MemoryManager;

public class aczf
  extends acyf
{
  public String a()
  {
    return "ceilingvalue";
  }
  
  public void a() {}
  
  public void b()
  {
    super.b();
    if (BaseApplicationImpl.sProcessId == 1)
    {
      MemoryManager.getInstance().checkReportOOMInfo();
      return;
    }
    aavb.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aczf
 * JD-Core Version:    0.7.0.1
 */