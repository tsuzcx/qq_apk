import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class ablz
  implements Executor
{
  final abmb jdField_a_of_type_Abmb = new abmb(30);
  Runnable jdField_a_of_type_JavaLangRunnable;
  
  protected void a()
  {
    try
    {
      Runnable localRunnable = (Runnable)this.jdField_a_of_type_Abmb.a();
      this.jdField_a_of_type_JavaLangRunnable = localRunnable;
      if (localRunnable != null)
      {
        QLog.d("QQAnimationDrawable", 2, "scheduleNext start");
        QQAnimationDrawable.a.execute(this.jdField_a_of_type_JavaLangRunnable);
      }
      return;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      this.jdField_a_of_type_Abmb.a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    try
    {
      QLog.d("QQAnimationDrawable", 2, "SerialExecutor excute");
      this.jdField_a_of_type_Abmb.a(new abma(this, paramRunnable));
      if (this.jdField_a_of_type_JavaLangRunnable == null)
      {
        QLog.d("QQAnimationDrawable", 2, "SerialExecutor mActive == null scheduleNext");
        a();
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ablz
 * JD-Core Version:    0.7.0.1
 */