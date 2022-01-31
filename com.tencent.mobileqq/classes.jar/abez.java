import com.tencent.qphone.base.util.QLog;

class abez
  implements Runnable
{
  abez(abey paramabey, Runnable paramRunnable) {}
  
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
      this.jdField_a_of_type_Abey.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abez
 * JD-Core Version:    0.7.0.1
 */