import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.qphone.base.util.QLog;

public class abtd
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  
  public abtd(QQAnimationDrawable paramQQAnimationDrawable, int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void run()
  {
    Object localObject = new StringBuilder().append("WorkerRunnable run | drawtime:").append(this.jdField_a_of_type_Long).append(" main:");
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QQAnimationDrawable", 2, bool);
      Process.setThreadPriority(10);
      long l1 = SystemClock.uptimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.b = this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a(false, this.jdField_a_of_type_Int);
      QQAnimationDrawable.a(this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable, this.jdField_a_of_type_Int);
      if ((this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a == null) && (this.jdField_a_of_type_Int == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.a = this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable.b;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
      QQAnimationDrawable localQQAnimationDrawable = this.jdField_a_of_type_ComTencentMobileqqBubbleQQAnimationDrawable;
      long l2 = SystemClock.uptimeMillis();
      ((QQAnimationDrawable)localObject).scheduleSelf(localQQAnimationDrawable, Long.valueOf(Math.max(this.jdField_a_of_type_Long - l1, 0L)).longValue() + l2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     abtd
 * JD-Core Version:    0.7.0.1
 */