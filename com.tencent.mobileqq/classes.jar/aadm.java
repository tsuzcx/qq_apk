import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class aadm
{
  private static aadm jdField_a_of_type_Aadm;
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newFixedThreadPool(5);
  
  public static aadm a()
  {
    if (jdField_a_of_type_Aadm == null) {
      jdField_a_of_type_Aadm = new aadm();
    }
    return jdField_a_of_type_Aadm;
  }
  
  public void a(Runnable paramRunnable)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.submit(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aadm
 * JD-Core Version:    0.7.0.1
 */