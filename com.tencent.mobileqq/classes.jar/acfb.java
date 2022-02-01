import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class acfb
{
  private static acfb jdField_a_of_type_Acfb;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newFixedThreadPool(5);
  
  public static acfb a()
  {
    if (jdField_a_of_type_Acfb == null) {
      jdField_a_of_type_Acfb = new acfb();
    }
    return jdField_a_of_type_Acfb;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acfb
 * JD-Core Version:    0.7.0.1
 */