import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class abuz
{
  private static abuz jdField_a_of_type_Abuz;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newFixedThreadPool(5);
  
  public static abuz a()
  {
    if (jdField_a_of_type_Abuz == null) {
      jdField_a_of_type_Abuz = new abuz();
    }
    return jdField_a_of_type_Abuz;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abuz
 * JD-Core Version:    0.7.0.1
 */