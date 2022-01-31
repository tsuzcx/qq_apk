import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class aaib
{
  private static aaib jdField_a_of_type_Aaib;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newFixedThreadPool(5);
  
  public static aaib a()
  {
    if (jdField_a_of_type_Aaib == null) {
      jdField_a_of_type_Aaib = new aaib();
    }
    return jdField_a_of_type_Aaib;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaib
 * JD-Core Version:    0.7.0.1
 */