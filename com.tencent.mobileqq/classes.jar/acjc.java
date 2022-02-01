import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class acjc
{
  private static acjc jdField_a_of_type_Acjc;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newFixedThreadPool(5);
  
  public static acjc a()
  {
    if (jdField_a_of_type_Acjc == null) {
      jdField_a_of_type_Acjc = new acjc();
    }
    return jdField_a_of_type_Acjc;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     acjc
 * JD-Core Version:    0.7.0.1
 */