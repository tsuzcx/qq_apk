import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class abfk
{
  private static abfk jdField_a_of_type_Abfk;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newFixedThreadPool(5);
  
  public static abfk a()
  {
    if (jdField_a_of_type_Abfk == null) {
      jdField_a_of_type_Abfk = new abfk();
    }
    return jdField_a_of_type_Abfk;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abfk
 * JD-Core Version:    0.7.0.1
 */