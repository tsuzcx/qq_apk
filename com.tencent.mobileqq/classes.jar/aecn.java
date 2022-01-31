import com.tencent.mobileqq.lyric.common.TimerTaskManager.TimerTaskRunnable;
import java.util.concurrent.ScheduledFuture;

public class aecn
{
  private long jdField_a_of_type_Long = -9223372036854775808L;
  private TimerTaskManager.TimerTaskRunnable jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable;
  private Runnable jdField_a_of_type_JavaLangRunnable = new aeco(this);
  private String jdField_a_of_type_JavaLangString;
  private ScheduledFuture jdField_a_of_type_JavaUtilConcurrentScheduledFuture;
  
  public static aecn a(TimerTaskManager.TimerTaskRunnable paramTimerTaskRunnable)
  {
    aecn localaecn = new aecn();
    TimerTaskManager.TimerTaskRunnable.a(paramTimerTaskRunnable, true);
    localaecn.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable = paramTimerTaskRunnable;
    return localaecn;
  }
  
  public String toString()
  {
    boolean bool2 = false;
    long l = this.jdField_a_of_type_Long;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable != null)
    {
      bool1 = bool2;
      if (TimerTaskManager.TimerTaskRunnable.a(this.jdField_a_of_type_ComTencentMobileqqLyricCommonTimerTaskManager$TimerTaskRunnable)) {
        bool1 = true;
      }
    }
    return String.format("Period = %d; IsValid = %b;", new Object[] { Long.valueOf(l), Boolean.valueOf(bool1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aecn
 * JD-Core Version:    0.7.0.1
 */