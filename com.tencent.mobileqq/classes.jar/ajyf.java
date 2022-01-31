import android.content.Context;
import com.tencent.mobileqq.unifiedebug.UnifiedDebugManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Queue;

public class ajyf
  implements Runnable
{
  public ajyf(UnifiedDebugManager paramUnifiedDebugManager, long paramLong1, Context paramContext, String paramString1, int paramInt, long paramLong2, String paramString2) {}
  
  public void run()
  {
    synchronized (this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager.a)
    {
      ajyh localajyh = (ajyh)this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager.a.peek();
      if ((localajyh != null) && (localajyh.jdField_b_of_type_Long == this.jdField_a_of_type_Long))
      {
        this.jdField_a_of_type_ComTencentMobileqqUnifiedebugUnifiedDebugManager.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Long, this.jdField_a_of_type_Long, this.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("UnifiedDebugManager", 2, "start debug(retry): seq=" + this.jdField_a_of_type_Long);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajyf
 * JD-Core Version:    0.7.0.1
 */