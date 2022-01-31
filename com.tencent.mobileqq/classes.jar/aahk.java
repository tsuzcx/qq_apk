import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog.ARLocalGestureCircleRecogCallback;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult.ARGestureResult;
import com.tencent.qphone.base.util.QLog;

public class aahk
  extends Thread
{
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean;
  byte[] jdField_a_of_type_ArrayOfByte = new byte[ARLocalGestureCircleRecog.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog) * ARLocalGestureCircleRecog.b(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog) * 3 / 2];
  private boolean b = true;
  
  public aahk(ARLocalGestureCircleRecog paramARLocalGestureCircleRecog)
  {
    setDaemon(true);
    start();
  }
  
  public void a()
  {
    this.b = false;
    if (getState() == Thread.State.WAITING) {
      try
      {
        notify();
        return;
      }
      finally {}
    }
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (getState() == Thread.State.WAITING)
    {
      System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length);
      this.jdField_a_of_type_Long = paramLong;
      this.jdField_a_of_type_Boolean = true;
      try
      {
        notify();
        return;
      }
      finally {}
    }
  }
  
  public void run()
  {
    for (;;)
    {
      boolean bool;
      try
      {
        setName("ARLocalGestureCircleRecogProcessWorker");
        if (!this.b) {
          break label60;
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          bool = this.b;
          if (bool)
          {
            try
            {
              wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
            continue;
          }
        }
        bool = this.b;
      }
      finally {}
      if (!bool) {
        label60:
        return;
      }
      this.jdField_a_of_type_Boolean = false;
      synchronized (ARLocalGestureCircleRecog.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog))
      {
        ARLocalGestureCircleRecog.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog, true);
        try
        {
          ARLocalGestureCircleRecogResult localARLocalGestureCircleRecogResult = this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.a(this.jdField_a_of_type_ArrayOfByte, ARLocalGestureCircleRecog.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog), ARLocalGestureCircleRecog.b(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog), 17);
          QLog.i("AREngine_ARLocalGestureCircleRecog", 1, "ARLocalGestureCircleRecog. recogResult = " + localARLocalGestureCircleRecogResult);
          if ((ARLocalGestureCircleRecog.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog)) && (!ARLocalGestureCircleRecog.b(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog)) && (ARLocalGestureCircleRecog.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog) != null) && (ARLocalGestureCircleRecog.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog).a.d == 0)) {
            ARLocalGestureCircleRecog.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog).a(localARLocalGestureCircleRecogResult);
          }
          ARLocalGestureCircleRecog.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog, false);
          yield();
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.d("AREngine_ARLocalGestureCircleRecog", 2, "Exception", localException);
            }
            ARLocalGestureCircleRecog.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog, false);
          }
        }
        finally
        {
          ARLocalGestureCircleRecog.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aahk
 * JD-Core Version:    0.7.0.1
 */