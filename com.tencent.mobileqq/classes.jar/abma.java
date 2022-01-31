import com.tencent.qphone.base.util.QLog;

class abma
  implements Runnable
{
  abma(ablz paramablz, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      QLog.d("QQAnimationDrawable", 2, "SerialExecutor run");
      this.jdField_a_of_type_JavaLangRunnable.run();
      return;
    }
    finally
    {
      QLog.d("QQAnimationDrawable", 2, "SerialExecutor scheduleNext");
      this.jdField_a_of_type_Ablz.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abma
 * JD-Core Version:    0.7.0.1
 */